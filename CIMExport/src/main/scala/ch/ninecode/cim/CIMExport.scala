package ch.ninecode.cim

import java.io.ByteArrayOutputStream
import java.net.URI
import java.nio.charset.StandardCharsets
import java.util.Date
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream

import scala.reflect.ClassTag

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.FileSystem
import org.apache.hadoop.fs.LocatedFileStatus
import org.apache.hadoop.fs.Path
import org.apache.hadoop.fs.permission.FsAction
import org.apache.hadoop.fs.permission.FsPermission
import org.apache.spark.rdd.RDD
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions
import org.apache.spark.sql.SparkSession
import org.apache.spark.storage.StorageLevel
import com.datastax.spark.connector._
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import ch.ninecode.model._

/**
 * Export (a subset of) CIM data.
 *
 * @example Export entire deduplicated CIM file with it's topology
 * {{{
 * // enter Spark shell environment
 * spark-shell --master spark://sandbox:7077 --executor-memory 4g --driver-memory 1g --jars /opt/code/CIMExport-<cim_export_version>.jar
 *
 * // read the large CIM file
 * import scala.collection.mutable.HashMap
 * import org.apache.spark.rdd.RDD
 * import ch.ninecode.cim._
 * import ch.ninecode.model._
 * val opts = new HashMap[String,String] ()
 * opts.put("StorageLevel", "MEMORY_AND_DISK_SER")
 * opts.put("ch.ninecode.cim.do_deduplication", "true")
 * val element = spark.read.format ("ch.ninecode.cim").options (opts).load ("hdfs://sandbox:8020/cim_export_equipmentsstripe1.rdf,hdfs://sandbox:8020/cim_export_equipmentsstripe2.rdf, etc.")
 * element.count
 *
 * // process topology (your choice of with or without islands)
 * val ntp = new CIMNetworkTopologyProcessor (spark, org.apache.spark.storage.StorageLevel.MEMORY_AND_DISK_SER)
 * val elements2 = ntp.process (true)
 * elements2.count
 *
 * // export the complete CIM file
 * val export = new CIMExport (spark)
 * export.exportAll ("cim_export_equipment.rdf")
 * }}}
 * @example Export one transformer area (trafokreis)
 * {{{
 * // enter Spark shell environment
 * spark-shell --master spark://sandbox:7077 --executor-memory 4g --driver-memory 1g --jars /opt/code/CIMExport-<cim_export_version>.jar
 *
 * // read the large CIM file
 * import scala.collection.mutable.HashMap
 * import org.apache.spark.rdd.RDD
 * import ch.ninecode.cim._
 * import ch.ninecode.model._
 * val opts = new HashMap[String,String] ()
 * opts.put("StorageLevel", "MEMORY_AND_DISK_SER")
 * val element = spark.read.format ("ch.ninecode.cim").options (opts).load ("hdfs://sandbox:8020/cim_export_equipmentsstripe2.rdf")
 * element.count
 *
 * // process topology with islands
 * val ntp = new CIMNetworkTopologyProcessor (spark, org.apache.spark.storage.StorageLevel.MEMORY_AND_DISK_SER)
 * val elements2 = ntp.process (true)
 * elements2.count
 *
 * // get the name of the transformer's low voltage pin TopologicalNode
 * val terminals = sc.getPersistentRDDs.filter(_._2.name == "Terminal").head._2.asInstanceOf[RDD[Terminal]]
 * val NSpin = terminals.filter (x => x.ConductingEquipment == "TRA7872" && x.ACDCTerminal.sequenceNumber == 2)
 * println (NSpin.first.TopologicalNode)
 * MUI452395_island
 *
 * // get the name of the trafokreis TopologicalIsland
 * val nodes = sc.getPersistentRDDs.filter(_._2.name == "TopologicalNode").head._2.asInstanceOf[RDD[TopologicalNode]]
 * val NSnode = nodes.filter (_.id == "MUI452395_island")
 * println (NSnode.first.TopologicalIsland)
 * TRA7872_terminal_2_island
 *
 * // export the reduced CIM file
 * val export = new CIMExport (spark)
 * export.exportIsland ("TRA7872_terminal_2_island", "TRA7872.rdf")
 * }}}
 *
 */
class CIMExport (spark: SparkSession, storage: StorageLevel = StorageLevel.MEMORY_AND_DISK_SER) extends CIMRDD with Serializable
{
    implicit val session: SparkSession = spark
    implicit val log: Logger = LoggerFactory.getLogger(getClass)

    /**
     * Index of open field in Switch bitmask.
     */
    lazy val openMask: Int = Switch.fields.indexOf("open")

    /**
     * Index of normalOpen field in Switch bitmask.
     */
    lazy val normalOpenMask: Int = Switch.fields.indexOf("normalOpen")

    /**
     * Permission mask for complete access.
     */
    lazy val wideOpen = new FsPermission(FsAction.ALL, FsAction.ALL, FsAction.ALL)

    /**
     * CIM file header.
     */
    lazy val header =
        """<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<rdf:RDF xmlns:cim="http://iec.ch/TC57/2016/CIM-schema-cim17#" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#">
"""
    lazy val header_bytes: Array[Byte] = header.getBytes("UTF-8")

    /**
     * CIM file tail.
     */
    lazy val tailer = """</rdf:RDF>"""
    lazy val tailer_bytes: Array[Byte] = tailer.getBytes("UTF-8")

    /**
     * A suitable file system configuration.
     */
    lazy val hdfs_configuration: Configuration =
    {
        val configuration = new Configuration()
        configuration.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem")
        configuration.set("fs.file.impl", "org.apache.hadoop.fs.LocalFileSystem")
        configuration
    }

    /*
     * Method to determine if a switch is closed (both terminals are the same topological node).
     *
     * If the switch has the <code>open</code> attribute set, use that.
     * Otherwise if it has the <code>normalOpen</code> attribute set, use that.
     * Otherwise assume it is the default state set by
     * CIMTopologyOptions.default_switch_open_state which means not closed unless explicitly set.
     *
     * @param switch The switch object to test.
     * @return <code>true</code> if the switch is closed, <code>false</code> otherwise.
     */
    def switchClosed (switch: Switch): Boolean =
    {
        if (0 != (switch.bitfields(openMask / 32) & (1 << (openMask % 32))))
            !switch.open // open valid
        else
            if (0 != (switch.bitfields(normalOpenMask / 32) & (1 << (normalOpenMask % 32))))
                !switch.normalOpen
            else
                true
    }

    /**
     * Get the list of open switches straddling island boundaries.
     *
     * Provides a list of normally open switches that join two transformer service areas.
     */
    def switchp (item: (Island, Element)): Option[(mRID, Island)] =
    {
        val (island, element) = item
        val switch: Option[Switch] = element match
        {
            case s: Switch => Some(s)
            case s: Cut => Some(s.Switch)
            case s: Disconnector => Some(s.Switch)
            case s: Fuse => Some(s.Switch)
            case s: GroundDisconnector => Some(s.Switch)
            case s: Jumper => Some(s.Switch)
            case s: MktSwitch => Some(s.Switch)
            case s: ProtectedSwitch => Some(s.Switch)
            case s: Breaker => Some(s.ProtectedSwitch.Switch)
            case s: LoadBreakSwitch => Some(s.ProtectedSwitch.Switch)
            case s: Recloser => Some(s.ProtectedSwitch.Switch)
            case s: Sectionaliser => Some(s.Switch)
            case _ => None
        }
        switch.filter(!switchClosed(_)).map(switch => (switch.id, island))
    }

    def class_name (e: Element): String =
    {
        val classname = e.getClass.getName
        classname.substring(classname.lastIndexOf(".") + 1)
    }

    def toJSON (id: String)(group: (String, Iterable[Element])): (String, String, String, (String, List[List[List[Double]]]), Iterable[(String, String)]) =
    {
        type Key = String
        type Value = String
        type KeyValue = (Key, Value)
        type KeyValueList = Iterable[KeyValue]

        val (transformer, elements) = group
        val points = elements.flatMap({ case point: PositionPoint => Some(point) case _ => None })
        val list = points.map(p => (p.xPosition.toDouble, p.yPosition.toDouble)).toList
        val coordinates = List(Hull.scan(list).map(p => List(p._1, p._2)))
        val geometry = ("Polygon", coordinates)
        val properties: KeyValueList = List(("name", transformer))
        (id, transformer, "Feature", geometry, properties)
    }

    def removeTopology (elements: Iterable[Element]): Iterable[Element] =
    {
        elements.flatMap
        {
            case terminal: Terminal =>
                Some(
                    // since Element extends Row and Row defines copy(), terminal.copy (TopologicalNode = null) becomes:
                    Terminal(
                        terminal.ACDCTerminal,
                        phases = terminal.phases,
                        AuxiliaryEquipment = terminal.AuxiliaryEquipment,
                        BranchGroupTerminal = terminal.BranchGroupTerminal,
                        Bushing = terminal.Bushing,
                        Circuit = terminal.Circuit,
                        ConductingEquipment = terminal.ConductingEquipment,
                        ConnectivityNode = terminal.ConnectivityNode,
                        ConverterDCSides = terminal.ConverterDCSides,
                        EquipmentFaults = terminal.EquipmentFaults,
                        HasFirstMutualCoupling = terminal.HasFirstMutualCoupling,
                        HasSecondMutualCoupling = terminal.HasSecondMutualCoupling,
                        NormalHeadFeeder = terminal.NormalHeadFeeder,
                        PinTerminal = terminal.PinTerminal,
                        RegulatingControl = terminal.RegulatingControl,
                        RemoteInputSignal = terminal.RemoteInputSignal,
                        SvPowerFlow = terminal.SvPowerFlow,
                        TieFlow = terminal.TieFlow,
                        TopologicalNode = null, // null out node reference
                        TransformerEnd = terminal.TransformerEnd
                    )
                )

            case node: ConnectivityNode =>
                Some(
                    ConnectivityNode(
                        node.IdentifiedObject,
                        ConnectivityNodeContainer = node.ConnectivityNodeContainer,
                        Terminals = node.Terminals,
                        TopologicalNode = null // null out node reference
                    )
                )

            case _: TopologicalNode => None
            case _: TopologicalIsland => None

            case element => Some(element)
        }
    }

    def truncateTopology (nodes: Set[String], elements: Iterable[Element]): Iterable[Element] =
    {
        elements.flatMap
        {
            case terminal: Terminal =>
                if (nodes.contains(terminal.TopologicalNode))
                    Some(
                        // since Element extends Row and Row defines copy(), terminal.copy (TopologicalNode = null) becomes:
                        Terminal(
                            terminal.ACDCTerminal,
                            phases = terminal.phases,
                            AuxiliaryEquipment = terminal.AuxiliaryEquipment,
                            BranchGroupTerminal = terminal.BranchGroupTerminal,
                            Bushing = terminal.Bushing,
                            Circuit = terminal.Circuit,
                            ConductingEquipment = terminal.ConductingEquipment,
                            ConnectivityNode = terminal.ConnectivityNode,
                            ConverterDCSides = terminal.ConverterDCSides,
                            EquipmentFaults = terminal.EquipmentFaults,
                            HasFirstMutualCoupling = terminal.HasFirstMutualCoupling,
                            HasSecondMutualCoupling = terminal.HasSecondMutualCoupling,
                            NormalHeadFeeder = terminal.NormalHeadFeeder,
                            PinTerminal = terminal.PinTerminal,
                            RegulatingControl = terminal.RegulatingControl,
                            RemoteInputSignal = terminal.RemoteInputSignal,
                            SvPowerFlow = terminal.SvPowerFlow,
                            TieFlow = terminal.TieFlow,
                            TopologicalNode = null, // null out node reference
                            TransformerEnd = terminal.TransformerEnd
                        )
                    )
                else
                    Some(terminal)

            case node: ConnectivityNode =>
                if (nodes.contains(node.TopologicalNode))
                    Some(
                        ConnectivityNode(
                            node.IdentifiedObject,
                            ConnectivityNodeContainer = node.ConnectivityNodeContainer,
                            Terminals = node.Terminals,
                            TopologicalNode = null // null out node reference
                        )
                    )
                else
                    Some(node)

            case element => Some(element)
        }
    }

    def saveToCassandra (
        options: CIMExportOptions,
        trafokreise: RDD[(Island, Iterable[Element])],
        labeled: RDD[(Island, Element)],
        nodes: Set[String]): Int =
    {
        val schema = Schema(session, """/export_schema.sql""", LogLevels.toLog4j(options.loglevel))
        if (schema.make(keyspace = options.keyspace, replication = options.replication))
        {
            val id = java.util.UUID.randomUUID.toString
            val time = new Date().getTime
            val fs = FileSystem.get(spark.sparkContext.hadoopConfiguration)
            var filesize = 0L
            var filetime = 0L
            for (file <- options.files)
            {
                val path = new Path(file)
                val status = fs.getFileStatus(path)
                filetime = status.getModificationTime
                filesize = filesize + status.getLen
            }
            val source = options.files.mkString(",")
            val export = spark.sparkContext.parallelize(Seq((id, time, source, filetime, filesize)))
            export.saveToCassandra(options.keyspace, "export", SomeColumns("id", "runtime", "filename", "filetime", "filesize"))

            val trafos = trafokreise.map(
                group =>
                {
                    val (transformer, elements) = group
                    val fixed_elements = if (options.topology) truncateTopology(nodes, elements) else removeTopology(elements)
                    log.info(s"exporting $transformer")
                    val (filesize, zipdata) = export_iterable_blob(fixed_elements, transformer)
                    (id, transformer, fixed_elements.map(x ⇒ (x.id, class_name(x))).toMap, filesize, zipdata.length, zipdata)
                }
            )
            trafos.saveToCassandra(options.keyspace, "transformers", SomeColumns("id", "name", "elements", "filesize", "zipsize", "cim"))
            val total = trafos.count.toInt
            log.info(s"exported $total transformer${if (total == 1) "" else "s"}")

            // create a convex hull for each transformer service area
            val json = trafokreise.map(toJSON(id))
            json.saveToCassandra(options.keyspace, "transformer_service_area", SomeColumns("id", "name", "type", "geometry", "properties"))

            val switches = labeled.flatMap(switchp).groupByKey.filter(_._2.size > 1)
                .map(x => (id, x._1, x._2.head, x._2.tail.head))
            switches.saveToCassandra(options.keyspace, "boundary_switches", SomeColumns("id", "mrid", "island1", "island2"))

            total
        }
        else
            0
    }

    /**
     * Merge a directory of files into a single file.
     *
     * @param src the source directory name
     * @param dst the target file name
     */
    def merge (src: String, dst: String): Unit =
    {
        // get a list of paths
        val dir = new Path(src)
        val srcfs = FileSystem.get(dir.toUri, hdfs_configuration)
        val r = srcfs.listFiles(dir, false)
        var files: List[Path] = List()
        while (r.hasNext)
        {
            val f: LocatedFileStatus = r.next
            if (f.getPath.getName != "_SUCCESS")
                files = f.getPath :: files
        }
        files = files.reverse

        // delete any existing file and make required directories
        val file = new Path(dst)
        val dstfs = FileSystem.get(file.toUri, hdfs_configuration)
        dstfs.delete(file, false)
        val parent = file.getParent
        if (dstfs.mkdirs(parent, wideOpen))
            dstfs.setPermission(parent, wideOpen)

        // manually copy all the partition parts
        val out = dstfs.create(file)
        out.write(header_bytes)
        val buf = new Array[Byte](1048576)
        for (f <- files)
        {
            val in = srcfs.open(f)
            var length = in.available
            while (length > 0)
            {
                val count = in.read(buf)
                out.write(buf, 0, count)
                length = length - count
            }
            in.close()
        }
        out.write(tailer_bytes)
        out.close()
    }

    /**
     * Export elements.
     *
     * @param elements The elements to export.
     * @param filename The name of the file to write.
     * @param temp     The temporary directory to build the text file in.
     */
    def export (elements: RDD[Element], filename: String, temp: String = "/tmp/export.rdf"): Unit =
    {
        // setup
        val dstfs = FileSystem.get(new Path(filename).toUri, hdfs_configuration)
        val directory: Path = new Path(dstfs.getWorkingDirectory, temp)
        dstfs.delete(directory, true)

        // write the file
        val txt = directory.toUri.toString
        val guts = elements.map(_.export)
        guts.saveAsTextFile(txt)

        // combine all the partition parts
        merge(txt, filename)

        // clean up temporary directory
        dstfs.delete(directory, true)
    }

    /**
     * Export elements.
     *
     * @param elements The elements to export.
     * @param filename The name of the file to write.
     */
    def export_iterable_file (elements: Iterable[Element], filename: String): Unit =
    {
        // setup
        val configuration: Configuration = new Configuration()
        val hdfs: FileSystem = FileSystem.get(URI.create(configuration.get("fs.defaultFS")), configuration)
        val file = new Path(filename)

        // write the file
        val out = hdfs.create(file, true)
        out.write(header_bytes)
        elements.map(_.export).foreach(
            (s: String) =>
            {
                out.write(s.getBytes(StandardCharsets.UTF_8))
                out.writeByte('\n')
            }
        )
        out.write(tailer_bytes)
        out.close()

        // delete the stupid .crc file
        val index = filename.lastIndexOf("/")
        val crc = if (-1 != index) s"${filename.substring(0, index + 1)}.${filename.substring(index + 1)}.crc" else s".$filename.crc"
        hdfs.delete(new Path(crc), false)
    }

    /**
     * Export elements.
     *
     * @param elements    The elements to export.
     * @param transformer The name of the transformer service area.
     * @return A Tuple2 with uncompressed size and compressed bytes.
     */
    def export_iterable_blob (elements: Iterable[Element], transformer: String): (Int, Array[Byte]) =
    {
        // create the text
        val sb = new scala.collection.mutable.StringBuilder(32768)
        sb.append(header)
        elements.map(_.export).foreach(
            (s: String) =>
            {
                sb.append(s)
                sb.append('\n')
            }
        )
        sb.append(tailer)
        val data = sb.toString.getBytes(StandardCharsets.UTF_8)

        // zip it
        val bos = new ByteArrayOutputStream()
        val zos = new ZipOutputStream(bos)
        zos.setLevel(9)
        val name = s"$transformer.rdf"
        zos.putNextEntry(new ZipEntry(name))
        zos.write(data, 0, data.length)
        zos.finish()
        zos.close()
        (data.length, bos.toByteArray)
    }

    /**
     * Make a pair RDD to access PairRDDFunctions.
     *
     * @param s the string to duplicate
     * @return the Tuple2 pair
     */
    def pair (s: String): (String, String) = (s, s)

    def keyed[T <: Element] (key: T => String = (x: T) => x.id)(implicit kt: ClassTag[T]): RDD[(String, T)] = getOrElse[T].keyBy(key)

    def foreign[T] (fn: T => String)(x: T): (String, String) = pair(fn(x))

    def narrow[T] (rdd: RDD[(String, (T, String))]): RDD[(String, T)] = rdd.map(x => (x._1, x._2._1))

    def asIDs (rdd: RDD[(String, (String, String))]): RDD[(String, String)] = rdd.map(x => (x._1, x._2._1))

    def distinct[T] (rdd: RDD[(String, T)])(implicit kt: ClassTag[T]): RDD[(String, T)] = rdd.reduceByKey((x, _) => x)

    /**
     * Export all CIM elements.
     *
     * Useful after doing some processing, such as stripe de-duplicating or topological processing,
     * to avoid having to redo that processing again.
     *
     * @param filename The name of the file to write.
     */
    def exportAll (filename: String): Unit =
    {
        val elements = getOrElse[Element]
        export(elements, filename)
    }

    type Island = String
    type mRID = String
    type Item = (mRID, Island)
    type Key = String
    type KeyedItem = (Key, Item)
    type Clazz = String

    /**
     * Find the list of dependents that should be included for the given element.
     *
     * @param relations the list of relation descriptions
     * @param stop      a set of Terminal mRID that will limit the dependency check
     * @param element   the element to check
     * @return the dependents as pairs of mRID ("if you include me, include him")
     */
    def dependents (relations: Map[String, List[CIMRelationship]], stop: Set[String])(element: Element): List[(mRID, mRID)] =
    {
        var e = element
        var list = List[(mRID, mRID)]()
        while (classOf[BasicElement] != e.getClass)
        {
            val cls = e.getClass
            val raw = cls.getName
            val clazz = raw.substring(raw.lastIndexOf(".") + 1)
            // the original way to link SolarGeneratingUnit to EnergyConsumer
            val pseudo_relations =
                e match
                {
                    case attr: UserAttribute =>
                        List((attr.id, attr.name), (attr.name, attr.id), (attr.id, attr.value), (attr.value, attr.id))
                    case str: StringQuantity =>
                        List((str.id, str.value), (str.value, str.id))
                    case _ =>
                        List()
                }
            val related = relations(clazz)
            val l = related.flatMap(
                relation =>
                {
                    val method = cls.getDeclaredMethod(relation.field)
                    method.setAccessible(true)
                    val ref = method.invoke(e)
                    if (null != ref)
                    {
                        val mrid = ref.toString
                        if ("" != mrid)
                            relation.field match
                            {
                                case "TopologicalIsland" =>
                                    List((e.id, mrid), (mrid, e.id))
                                case "TopologicalNode" =>
                                    if (stop.contains(e.id))
                                        List()
                                    else
                                        List((e.id, mrid), (mrid, e.id))
                                case "ConnectivityNode" =>
                                    if (stop.contains(e.id))
                                        List()
                                    else
                                        List((e.id, mrid), (mrid, e.id))
                                case "Location" =>
                                    List((e.id, mrid), (mrid, e.id))
                                case "PerLengthParameters" =>
                                    List((e.id, ref.asInstanceOf[List[String]].head))
                                case "PowerTransformer" =>
                                    List((e.id, mrid), (mrid, e.id))
                                case "IdentifiedObject_attr" => // DiagramObject has a special name for IdentifiedObject
                                    List((e.id, mrid), (mrid, e.id))
                                case "DiagramObject" =>
                                    List((e.id, mrid), (mrid, e.id))
                                case "SvStatus" =>
                                    List((e.id, ref.asInstanceOf[List[String]].head))
                                case _ =>
                                    if (!relation.multiple)
                                        List((e.id, mrid))
                                    else
                                        List()
                            }
                        else
                            List()
                    }
                    else
                        List()
                }
            )
            list = list ++ l ++ pseudo_relations
            e = e.sup
        }
        list
    }

    /**
     * Export related.
     *
     * @param what a PairRDD, the keys are mrid to check, and the values are the name we will save to
     * @param stop a set of Terminal mRID that will limit the dependency check
     * @return the number of related groups processed
     */
    def labelRelated (what: RDD[Item], stop: Set[Item] = Set()): RDD[(Island, Element)] =
    {
        // the to do list is a PairRDD, the keys are mrid to check,
        // and the values are the name to label the related items
        var todo = what.keyBy(x => s"${x._1}${x._2}")

        val classes = new CHIM("").classes

        // make a mapping of mRID to mRID
        // "if you include me, you have to include him" and vice-versa for some relations
        val relationships = classes.map(x => (x.name, x.relations)).toMap
        val ying_yang = getOrElse[Element].flatMap(dependents(relationships, stop.map(_._1))).persist(storage)

        // done is a list of keyed PairRDD, the keys are mRID_Island and each pair is an mRID and the Island it belongs to
        var done: List[RDD[KeyedItem]] = List()

        do
        {
            val next: RDD[(mRID, (Island, mRID))] = todo.values.join(ying_yang).persist(storage)
            done = done ++ Seq(todo)
            var new_todo: RDD[KeyedItem] = next.values.map(_.swap).keyBy(x => s"${x._1}${x._2}")
            done.foreach(d => new_todo = new_todo.subtractByKey(d))
            new_todo.persist(storage)
            next.unpersist(false)
            todo = new_todo
        }
        while (!todo.isEmpty)

        // add stopping connectivity nodes (ConnectivityNode referenced by stop Terminal)
        val nodes: RDD[Item] = getOrElse[Terminal].flatMap(
            terminal =>
            {
                stop.find(_._1 == terminal.id) match
                {
                    case Some(i: Item) =>
                        Some((terminal.ConnectivityNode, i._2))
                    case _ =>
                        None
                }
            }
        )
        done = done :+ nodes.keyBy(x => s"${x._1}${x._2}")

        // reduce to n executors
        val n = session.sparkContext.getExecutorMemoryStatus.size
        val done_minimized = done.map(_.values.map(x => (x._1, Set[Island](x._2)))
            .reduceByKey(
                (x, y) => x.union(y), n))
        val all_done: RDD[Item] = session.sparkContext.union(done_minimized)
            .reduceByKey(
                (x, y) => x.union(y), n)
            .flatMap(p => p._2.map(q => (p._1, q)))
            .persist(storage)

        val ret = getOrElse[Element].keyBy(_.id).join(all_done).values.map(_.swap).persist(storage)
        log.info(s"${ret.count} elements")
        done.foreach(_.unpersist(false))
        ying_yang.unpersist(false)
        ret
    }

    /**
     * Export elements associated to the given topological island.
     *
     * @param island    The name of the topological island to export.
     * @param filename  The name of the file to write.
     * @param directory The name of the directory to write the CIM file.
     */
    def exportIsland (island: String, filename: String, directory: String = "simulation/"): Unit =
    {
        val dir = if (directory.endsWith("/")) directory else s"$directory/"
        // start with the island
        val todo = getOrElse[TopologicalIsland].filter(_.id == island).map(x => (x.id, filename)).persist(storage)
        val labeled = labelRelated(todo)
        val file = s"$dir$filename"
        export(labeled.map(_._2), file)
        log.info(s"exported island $dir$filename")
    }

    /**
     * Export every topological island.
     *
     * @param directory The name of the directory to write the CIM files.
     * @return the number of islands processed
     */
    def exportAllIslands (directory: String = "simulation/"): Int =
    {
        val dir = if (directory.endsWith("/")) directory else s"$directory/"
        // start with all islands
        val islands = getOrElse[TopologicalIsland].map(_.id)
        val count = islands.count
        log.info(s"exporting $count island${if (count == 1) "" else "s"}")

        val todo = islands.map(pair).persist(storage)
        val labeled = labelRelated(todo)
        val total = labeled.groupByKey.map(
            group =>
            {
                val island = group._1
                val elements = group._2
                val filename = s"$dir$island.rdf"
                log.info(s"exporting $filename")
                export_iterable_file(elements, filename)
                1
            }
        ).sum.toInt
        log.info(s"exported $total island${if (total == 1) "" else "s"}")
        total
    }

    val voltages: Map[String, Double] = getOrElse[BaseVoltage]
        .map(v => (v.id, v.nominalVoltage * 1000.0))
        .collect
        .toMap
        .withDefaultValue(0.0)

    // eliminate "230V" tranformers for public lighting
    def n7 (v: String): Boolean = voltages(v) >= 400.0

    /**
     * Export every transformer service area.
     *
     * @param options the export options
     * @return the number of transformers processed
     */
    def exportAllTransformers (options: CIMExportOptions): Int =
    {
        // get transformer low voltage pins
        val term_by_node = getOrElse[Terminal].map(y => (y.id, y.TopologicalNode))
        val node_by_island = getOrElse[TopologicalNode].map(z => (z.id, z.TopologicalIsland))
        val ends = getOrElse[PowerTransformerEnd]
        val transformers = ends
            .filter(end => end.TransformerEnd.endNumber != 1 && n7(end.TransformerEnd.BaseVoltage))
            .map(x => (x.TransformerEnd.Terminal, x.PowerTransformer))
            .join(term_by_node).values
            .map(_.swap)
            .join(node_by_island).values
            .map(_.swap)
            .groupByKey
            .map(trafo => (trafo._1, trafo._2.toArray.sortWith(_ < _).mkString("_"), trafo._2))
            .persist(storage)
        val count = transformers.count
        log.info(s"exporting $count transformer${if (count == 1) "" else "s"}")

        val start: RDD[Item] = transformers.map(trafo => (trafo._1, trafo._2))
        val trafo_island: RDD[Item] = transformers.flatMap(trafo => trafo._3.map(t => (t, trafo._2)))

        // only traverse from Terminal to a node if it's not a stop node
        val stopTerminals: Set[Item] = ends
            .flatMap(end => if (end.TransformerEnd.endNumber == 1) Some((end.PowerTransformer, end.TransformerEnd.Terminal)) else None)
            .join(trafo_island)
            .values
            .collect
            .toSet
        val labeled = labelRelated(start, stopTerminals)
        val trafokreise = labeled.groupByKey

        val terminals = stopTerminals.map(_._1)
        val nodes = getOrElse[Terminal].flatMap(
            terminal =>
            {
                if (terminals.contains(terminal.id)) Some(terminal.TopologicalNode) else None
            }
        ).collect.toSet
        val total = if (options.cassandra)
            saveToCassandra(options, trafokreise, labeled, nodes)
        else
        {
            val dir = if (options.outputdir.endsWith("/")) options.outputdir else s"${options.outputdir}/"
            val total = trafokreise.map(
                group =>
                {
                    val (transformer, elements) = group
                    val fixed_elements = if (options.topology) truncateTopology(nodes, elements) else removeTopology(elements)
                    val filename = s"$dir$transformer.rdf"
                    log.info(s"exporting $filename")
                    export_iterable_file(fixed_elements, filename)
                    1
                }
            ).sum.toInt
            log.info(s"exported $total transformer${if (total == 1) "" else "s"}")
            total
        }

        total
    }
}

