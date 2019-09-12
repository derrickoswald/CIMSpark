package ch.ninecode.cim

import java.io.ByteArrayOutputStream
import java.net.URI
import java.nio.charset.StandardCharsets
import java.time.LocalDateTime
import java.util.Date
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream

import scala.reflect.ClassTag

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.FileSystem
import org.apache.hadoop.fs.FileUtil
import org.apache.hadoop.fs.Path
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
 * spark-shell --master spark://sandbox:7077 --executor-memory 4g --driver-memory 1g --conf spark.sql.warehouse.dir=file:/tmp/spark-warehouse --jars /opt/code/CIMReader-2.11-2.2.0-2.2.1.jar
 *
 * // read the large CIM file
 * import scala.collection.mutable.HashMap
 * import org.apache.spark.rdd.RDD
 * import ch.ninecode.cim._
 * import ch.ninecode.model._
 * val opts = new HashMap[String,String] ()
 * opts.put("StorageLevel", "MEMORY_AND_DISK_SER")
 * opts.put("ch.ninecode.cim.do_deduplication", "true")
 * val element = spark.read.format ("ch.ninecode.cim").options (opts).load ("hdfs://sandbox:8020/data/bkw_cim_export_equipmentsstripe1.rdf,hdfs://sandbox:8020/data/bkw_cim_export_equipmentsstripe2.rdf, etc.")
 * element.count
 *
 * // process topology (your choice of with or without islands)
 * val ntp = new CIMNetworkTopologyProcessor (spark, org.apache.spark.storage.StorageLevel.MEMORY_AND_DISK_SER)
 * val elements2 = ntp.process (true)
 * elements2.count
 *
 * // export the complete CIM file
 * val export = new CIMExport (spark)
 * export.exportAll ("bkw_cim_export_equipment.rdf")
 * }}}
 *
 * @example Export one transformer area (trafokreis)
 * {{{
 * // enter Spark shell environment
 * spark-shell --master spark://sandbox:7077 --executor-memory 4g --driver-memory 1g --conf spark.sql.warehouse.dir=file:/tmp/spark-warehouse --jars /opt/code/CIMReader-2.11-2.2.0-2.2.1.jar
 *
 * // read the large CIM file
 * import scala.collection.mutable.HashMap
 * import org.apache.spark.rdd.RDD
 * import ch.ninecode.cim._
 * import ch.ninecode.model._
 * val opts = new HashMap[String,String] ()
 * opts.put("StorageLevel", "MEMORY_AND_DISK_SER")
 * val element = spark.read.format ("ch.ninecode.cim").options (opts).load ("hdfs://sandbox:8020/data/bkw_cim_export_equipmentsstripe2.rdf")
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
    implicit val log: Logger = LoggerFactory.getLogger (getClass)

    /**
     * Merge source into destination and clean up source.
     *
     * @param source existing directory to be copied from
     * @param destination target file
     */
    def merge (source: String, destination: String): Unit =
    {
        val configuration: Configuration = spark.sparkContext.hadoopConfiguration
        val hdfs: FileSystem = FileSystem.get (configuration)
        FileUtil.copyMerge (hdfs, new Path (source), hdfs, new Path (destination), true, configuration, null)
    }

    /**
     * Export elements.
     *
     * @param elements The elements to export.
     * @param filename The name of the file to write.
     * @param about The about string for the CIM file header.
     * @param temp The temporary directory to build the text file in.
     */
    def export (elements: RDD[Element], filename: String, about: String = "", temp: String = "/tmp/export.rdf"): Unit =
    {
        val ldt = LocalDateTime.now.toString
        // ToDo: Model.scenarioTime and Model.version
        val header =
"""<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<rdf:RDF xmlns:cim="http://iec.ch/TC57/2013/CIM-schema-cim16#" xmlns:md="http://iec.ch/TC57/61970-552/ModelDescription/1#" xmlns:dm="http://iec.ch/2002/schema/CIM_difference_model#" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#">
	<md:FullModel rdf:about="%s">
		<md:Model.created>%s</md:Model.created>
		<md:Model.description>CIMExport</md:Model.description>
		<md:Model.modelingAuthoritySet>http://9code.ch/</md:Model.modelingAuthoritySet>
		<md:Model.profile>https://github.com/derrickoswald/CIMReader</md:Model.profile>
	</md:FullModel>""".format (about, ldt)
        val tailer = """</rdf:RDF>"""

        // setup
        val configuration: Configuration = spark.sparkContext.hadoopConfiguration
        val hdfs = FileSystem.get (URI.create (configuration.get ("fs.defaultFS")), configuration)
        val directory: Path = new Path (hdfs.getWorkingDirectory, temp)
        hdfs.delete (directory, true)
        val file = new Path (filename)
        hdfs.delete (file, false)
        // write the file
        val txt = directory.toUri.toString
        val head = spark.sparkContext.makeRDD (List[String] (header))
        val tail = spark.sparkContext.makeRDD (List[String] (tailer))
        val guts = elements.map (_.export)
        val all = head.union (guts).union (tail)
        all.saveAsTextFile (txt)
        merge (txt, file.toUri.toString)
        // clean up temporary directory
        hdfs.delete (directory, true)
        // delete the stupid .crc file
        val index = filename.lastIndexOf ("/")
        val crc = if (-1 != index) filename.substring (0, index + 1) + "." + filename.substring (index + 1) + ".crc" else "." + filename + ".crc"
        hdfs.delete (new Path (crc), false)
    }

    /**
     * Export elements.
     *
     * @param elements The elements to export.
     * @param filename The name of the file to write.
     * @param about The about string for the CIM file header.
     */
    def export_iterable_file (elements: Iterable[Element], filename: String, about: String = ""): Unit =
    {
        val ldt = LocalDateTime.now.toString
        // ToDo: Model.scenarioTime and Model.version
        val header =
            """<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<rdf:RDF xmlns:cim="http://iec.ch/TC57/2013/CIM-schema-cim16#" xmlns:md="http://iec.ch/TC57/61970-552/ModelDescription/1#" xmlns:dm="http://iec.ch/2002/schema/CIM_difference_model#" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#">
	<md:FullModel rdf:about="%s">
		<md:Model.created>%s</md:Model.created>
		<md:Model.description>CIMExport</md:Model.description>
		<md:Model.modelingAuthoritySet>http://9code.ch/</md:Model.modelingAuthoritySet>
		<md:Model.profile>https://github.com/derrickoswald/CIMReader</md:Model.profile>
	</md:FullModel>
""".format (about, ldt)
        val tailer =
            """
</rdf:RDF>"""

        // setup
        val configuration: Configuration = new Configuration ()
        val hdfs: FileSystem = FileSystem.get (URI.create (configuration.get ("fs.defaultFS")), configuration)
        val file = new Path (filename)

        // write the file
        val out = hdfs.create (file, true)
        out.write (header.getBytes (StandardCharsets.UTF_8))
        elements.map (_.export).foreach ((s: String) ⇒ { out.write (s.getBytes (StandardCharsets.UTF_8)); out.writeByte ('\n') })
        out.write (tailer.getBytes (StandardCharsets.UTF_8))
        out.close ()

        // delete the stupid .crc file
        val index = filename.lastIndexOf ("/")
        val crc = if (-1 != index) filename.substring (0, index + 1) + "." + filename.substring (index + 1) + ".crc" else "." + filename + ".crc"
        hdfs.delete (new Path (crc), false)
    }

    /**
     * Export elements.
     *
     * @param elements The elements to export.
     * @param transformer The name of the transformer service area.
     * @param about The about string for the CIM file header.
     * @return A Tuple2 with uncompressed size and compressed bytes.
     */
    def export_iterable_blob (elements: Iterable[Element], transformer: String, about: String = ""): (Int, Array[Byte]) =
    {
        val ldt = LocalDateTime.now.toString
        // ToDo: Model.scenarioTime and Model.version
        val header =
            """<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<rdf:RDF xmlns:cim="http://iec.ch/TC57/2013/CIM-schema-cim16#" xmlns:md="http://iec.ch/TC57/61970-552/ModelDescription/1#" xmlns:dm="http://iec.ch/2002/schema/CIM_difference_model#" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#">
	<md:FullModel rdf:about="%s">
		<md:Model.created>%s</md:Model.created>
		<md:Model.description>CIMExport</md:Model.description>
		<md:Model.modelingAuthoritySet>http://9code.ch/</md:Model.modelingAuthoritySet>
		<md:Model.profile>https://github.com/derrickoswald/CIMReader</md:Model.profile>
	</md:FullModel>
""".format (about, ldt)
        val tailer =
            """</rdf:RDF>"""

        // create the text
        val sb = new scala.collection.mutable.StringBuilder (32768, header)
        elements.map (_.export).foreach ((s: String) ⇒ { sb.append (s); sb.append ('\n') })
        sb.append (tailer)
        val data = sb.toString.getBytes (StandardCharsets.UTF_8)

        // zip it
        val bos = new ByteArrayOutputStream ()
        val zos = new ZipOutputStream (bos)
        zos.setLevel (9)
        val name = "%s.rdf".format (transformer)
        zos.putNextEntry (new ZipEntry (name))
        zos.write (data, 0, data.length)
        zos.finish ()
        zos.close ()
        (data.length, bos.toByteArray)
    }

    /**
     * Make a pair RDD to access PairRDDFunctions.
     * @param s the string to duplicate
     * @return the Tuple2 pair
     */
    def pair (s: String): (String, String) = (s, s)

    def keyed[T <: Element] (key: T ⇒ String = (x: T) ⇒ x.id) (implicit kt: ClassTag[T]): RDD[(String, T)] = getOrElse[T].keyBy (key)

    def foreign[T] (fn: T ⇒ String) (x: T): (String, String) = pair (fn (x))

    def narrow[T] (rdd: RDD[(String, (T, String))]) (implicit kt: ClassTag[T]): RDD[(String, T)] = rdd.map (x ⇒ (x._1, x._2._1))

    def asIDs (rdd: RDD[(String, (String, String))]): RDD[(String, String)] = rdd.map (x ⇒ (x._1, x._2._1))

    def distinct[T] (rdd: RDD[(String, T)]) (implicit kt: ClassTag[T]): RDD[(String, T)] = rdd.reduceByKey ((x, _) => x)

    /**
      * Export all CIM elements.
      *
      * Useful after doing some processing, such as stripe de-duplicating or topological processing,
      * to avoid having to redo that processing again.
      *
      * @param filename The name of the file to write.
      * @param about The about string for the CIM file header.
      */
    def exportAll (filename: String, about: String = ""):Unit =
    {
        val elements = getOrElse[Element]("Elements")
        export (elements, filename, about)
    }

    type Island = String
    type mRID = String
    type Item = (mRID, Island)
    type Key = String
    type KeyedItem = (Key, Item)
    type Clazz = String

    def dependents (relations: Map[String, List[Relationship]]) (element: Element): List[(mRID, mRID)] =
    {
        var e = element
        var list = List[(mRID, mRID)] ()
        while (classOf[BasicElement] != e.getClass)
        {
            val cls = e.getClass
            val raw = cls.getName
            val clazz = raw.substring (raw.lastIndexOf (".") + 1)
            val related = relations (clazz)
            val l = related.flatMap (
                relation ⇒
                {
                    val method = cls.getDeclaredMethod (relation.field)
                    method.setAccessible (true)
                    val ref = method.invoke (e)
                    if (null != ref)
                    {
                        val mrid = ref.toString
                        if ("" != mrid)
                            if (relation.field == "TopologicalIsland")
                                List ((e.id, mrid), (mrid, e.id))
                            else if (relation.field == "TopologicalNode")
                                List ((e.id, mrid), (mrid, e.id))
                            else if (relation.field == "ConnectivityNode")
                                List ((e.id, mrid), (mrid, e.id))
                            else if (relation.field == "Location")
                                List ((e.id, mrid), (mrid, e.id))
                            else if (relation.field == "PerLengthParameters")
                                Some ((e.id, ref.asInstanceOf[List[String]].head))
                            else if (relation.field == "PowerTransformer")
                                List ((e.id, mrid), (mrid, e.id))
                            else if (relation.field == "IdentifiedObject_attr") // DiagramObject has a special name for IdentifiedObject
                                List ((e.id, mrid), (mrid, e.id))
                            else if (relation.field == "DiagramObject")
                                List ((e.id, mrid), (mrid, e.id))
                            else if (relation.field == "SvStatus")
                                Some ((e.id, ref.asInstanceOf[List[String]].head))
                            else if (!relation.multiple)
                                Some ((e.id, mrid))
                            else
                                None
                        else
                            None
                    }
                    else
                        None
                }
            )
            list = list ++ l
            e = e.sup
        }
        list
    }

    /**
     * Export related.
     *
     * @param what a PairRDD, the keys are mrid to check, and the values are the name we will save to
     * @return the number of related groups processed
     */
    def labelRelated (what: RDD[Item]): RDD[(Island, Element)] =
    {
        // the to do list is a PairRDD, the keys are mrid to check,
        // and the values are the name to label the related items
        var todo = what.keyBy (x ⇒ x._1 + x._2)

        val classes = new CHIM ("").classes

        // make a mapping of mRID to mRID
        // "if you include me, you have to include him" and vice-versa for some relations
        val relationships = classes.map (x ⇒ (x.name, x.relations)).toMap
        val ying_yang = getOrElse[Element]("Elements").flatMap (dependents (relationships)).persist (storage)

        // done is a list of keyed PairRDD, the keys are mRID_Island and each pair is an mRID and the Island it belongs to
        var done: List[RDD[KeyedItem]] = List ()

        do
        {
            val next: RDD[(mRID, (Island, mRID))] = todo.values.join (ying_yang).persist (storage)
            done = done ++ Seq (todo)
            var new_todo: RDD[KeyedItem] = next.values.map (_.swap).keyBy (x ⇒ x._1 + x._2)
            done.foreach (d ⇒ new_todo = new_todo.subtractByKey (d))
            new_todo.persist (storage)
            next.unpersist (false)
            todo = new_todo
        }
        while (!todo.isEmpty)
        // reduce to n executors
        val n = session.sparkContext.getExecutorMemoryStatus.size
        val done_minimized = done.map (_.values.map (x ⇒ (x._1, Set[Island](x._2)))
            .reduceByKey (
                (x, y) ⇒ x.union (y), n))
        val all_done: RDD[Item] = session.sparkContext.union (done_minimized)
            .reduceByKey (
                (x, y) ⇒ x.union (y), n)
            .flatMap (p ⇒ p._2.map (q ⇒ (p._1, q)))
            .persist (storage)

        val ret = getOrElse[Element]("Elements").keyBy (_.id).join (all_done).values.map (_.swap).persist (storage)
        log.info ("%s elements".format (ret.count))
        done.foreach (_.unpersist (false))
        ying_yang.unpersist (false)
        ret
    }

    /**
     * Export elements associated to the given topological island.
     * @param island The name of the topological island to export.
     * @param filename The name of the file to write.
     * @param directory The name of the directory to write the CIM file.
     */
    def exportIsland (island: String, filename: String, directory: String = "simulation/"): Unit =
    {
        val dir = if (directory.endsWith ("/")) directory else directory + "/"
        // start with the island
        val todo = getOrElse[TopologicalIsland].filter (_.id == island).map (x ⇒ (x.id, filename)).persist (storage)
        val labeled = labelRelated (todo)
        export (labeled.map (_._2), dir + filename)
        log.info ("exported island %s".format (dir + filename))
    }

    /**
     * Export every topological island.
     * @param directory The name of the directory to write the CIM files.
     * @return the number of islands processed
     */
    def exportAllIslands (directory: String = "simulation/"): Int =
    {
        val dir = if (directory.endsWith ("/")) directory else directory + "/"
        // start with all islands
        val islands = getOrElse[TopologicalIsland].map (_.id)
        val count = islands.count
        log.info ("exporting %s island%s".format (count, if (count == 1) "" else "s"))

        val todo = islands.map (pair).persist (storage)
        val labeled = labelRelated (todo)
        val total = labeled.groupByKey.map (
            group ⇒
            {
                val island = group._1
                val elements = group._2
                val filename = dir + island + ".rdf"
                log.info ("exporting %s".format (filename))
                export_iterable_file (elements, filename, island)
                1
            }
        ).sum.toInt
        log.info ("exported %s island%s".format (total, if (total == 1) "" else "s"))
        total
    }

    def class_name (e: Element): String =
    {
        val classname = e.getClass.getName
        classname.substring (classname.lastIndexOf (".") + 1)
    }

    /**
     * Export every transformer service area.
     * @param source The source file names as a comma delimited list.
     * @param directory The name of the directory to write the CIM files.
     * @param cassandra If <code>true</code> output metadata to Cassandra.
     * @param keyspace If <b>cassandra</b> is true, use this keyspace in Cassandra.
     * @return the number of transformers processed
     */
    def exportAllTransformers (source: String, directory: String = "simulation/", cassandra: Boolean = false, keyspace: String = "cimexport", replication: Int = 1): Int =
    {
        // get transformer low voltage pins
        val transformers: RDD[Item] = getOrElse [PowerTransformerEnd]
            .filter (_.TransformerEnd.endNumber != 1)
            .map (x ⇒ (x.TransformerEnd.Terminal, x.PowerTransformer))
            .join (getOrElse [Terminal].map (y ⇒ (y.id, y.TopologicalNode))).values
            .map (_.swap)
            .join (getOrElse [TopologicalNode].map (z ⇒ (z.id, z.TopologicalIsland))).values
            .map (_.swap)
            .groupByKey
            .mapValues (_.toArray.sortWith (_ < _).mkString ("_"))
            .persist (storage)
        val count = transformers.count
        log.info ("exporting %s transformer%s".format (count, if (count == 1) "" else "s"))

        val labeled = labelRelated (transformers)
        val trafokreise = labeled.groupByKey
        var total = 0

        if (cassandra)
        {
            type Key = String
            type Value = String
            type KeyValue = (Key, Value)
            type KeyValueList = Iterable[KeyValue]

            val schema = Schema (session, keyspace, replication, true)
            if (schema.make)
            {
                val id = java.util.UUID.randomUUID.toString
                val time = new Date ().getTime
                val fs = FileSystem.get (spark.sparkContext.hadoopConfiguration)
                val path = new Path (source)
                val file = fs.getFileStatus (path)
                val filetime = file.getModificationTime
                val filesize = file.getLen
                val export = spark.sparkContext.parallelize (Seq ((id, time, source, filetime, filesize)))
                export.saveToCassandra (keyspace, "export", SomeColumns ("id", "runtime", "filename", "filetime", "filesize"))

                val trafos = trafokreise.map (
                    group ⇒
                    {
                        val transformer = group._1
                        val elements = group._2
                        log.info ("exporting %s".format (transformer))
                        val (filesize, zipdata) = export_iterable_blob (elements, transformer)
                        (id, transformer, elements.map (x ⇒ (x.id, class_name (x))).toMap, filesize, zipdata.length, zipdata)
                    }
                )
                trafos.saveToCassandra (keyspace, "transformers", SomeColumns ("id", "name", "elements", "filesize", "zipsize", "cim"))
                total = trafos.count.toInt
                log.info ("exported %s transformer%s".format (total, if (total == 1) "" else "s"))

                // create a convex hull for each transformer service area
                val json: RDD[(String, String, String, (String, List[List[List[Double]]]), Iterable[(String, String)])] = trafokreise.map (
                    group ⇒
                    {
                        val transformer = group._1
                        val elements = group._2
                        val points = for
                            {
                                e <- elements
                                cls = e.getClass
                                raw = cls.getName
                                clazz = raw.substring (raw.lastIndexOf (".") + 1)
                                if clazz == "PositionPoint"
                            }
                            yield e.asInstanceOf[PositionPoint]
                        val list = points.map (p ⇒ (p.xPosition.toDouble, p.yPosition.toDouble)).toList
                        val hull = Hull.scan (list).map (p ⇒ List (p._1, p._2))
                        val coordinates: List[List[List[Double]]] = List (hull)
                        val geometry = ("Polygon", coordinates)
                        val properties: KeyValueList = List (("name", transformer))
                        (id, transformer, "Feature", geometry, properties)
                    }
                )
                json.saveToCassandra (keyspace, "transformer_service_area", SomeColumns ("id", "name", "type", "geometry", "properties"))

                /**
                 * Index of normalOpen field in Switch bitmask.
                 */
                val normalOpenMask: Int = Switch.fields.indexOf ("normalOpen")

                /**
                 * Index of open field in Switch bitmask.
                 */
                val openMask: Int = Switch.fields.indexOf ("open")

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
                    else if (0 != (switch.bitfields(normalOpenMask / 32) & (1 << (normalOpenMask % 32))))
                        !switch.normalOpen
                    else
                        true
                }

                // get the list of open switches straddling island boundaries
                def switchp (item: (Island, Element)): Option[(mRID, Island)] =
                {
                    val island = item._1
                    val e = item._2
                    val switch = e match
                    {
                        case s: Switch ⇒ s.asInstanceOf [Switch]
                        case c: Cut ⇒ c.asInstanceOf [Cut].Switch
                        case d: Disconnector ⇒ d.asInstanceOf [Disconnector].Switch
                        case f: Fuse ⇒ f.asInstanceOf [Fuse].Switch
                        case g: GroundDisconnector ⇒ g.asInstanceOf [GroundDisconnector].Switch
                        case j: Jumper ⇒ j.asInstanceOf [Jumper].Switch
                        case m: MktSwitch ⇒ m.asInstanceOf [MktSwitch].Switch
                        case p: ProtectedSwitch ⇒ p.asInstanceOf [ProtectedSwitch].Switch
                        case b: Breaker ⇒ b.asInstanceOf [Breaker].ProtectedSwitch.Switch
                        case l: LoadBreakSwitch ⇒ l.asInstanceOf [LoadBreakSwitch].ProtectedSwitch.Switch
                        case r: Recloser ⇒ r.asInstanceOf [Recloser].ProtectedSwitch.Switch
                        case s: Sectionaliser ⇒ s.asInstanceOf [Sectionaliser].Switch
                        case _ ⇒ null
                    }
                    if (null != switch && !switchClosed (switch))
                        Some ((switch.id, island))
                    else
                        None
                }
                val switches = labeled.flatMap (switchp).groupByKey.filter (_._2.size > 1)
                        .map (x ⇒ (id, x._1, x._2.head, x._2.tail.head))
                switches.saveToCassandra (keyspace, "boundary_switches", SomeColumns ("id", "mrid", "island1", "island2"))
            }
        }
        else
        {
            val dir = if (directory.endsWith ("/")) directory else directory + "/"
            total = trafokreise.map (
                group ⇒
                {
                    val transformer = group._1
                    val elements = group._2
                    val filename = dir + transformer + ".rdf"
                    log.info ("exporting %s".format (filename))
                    export_iterable_file (elements, filename, transformer)
                    1
                }
            ).sum.toInt
            log.info ("exported %s transformer%s".format (total, if (total == 1) "" else "s"))
        }

        total
    }
}

