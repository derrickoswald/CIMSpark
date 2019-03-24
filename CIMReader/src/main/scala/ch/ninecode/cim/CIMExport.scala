package ch.ninecode.cim

import java.io.UnsupportedEncodingException
import java.net.URI
import java.net.URLDecoder
import java.nio.charset.StandardCharsets
import java.time.LocalDateTime
import java.util.Properties

import scala.reflect.ClassTag
import scala.tools.nsc.io.Jar
import scala.util.Random
import scopt.OptionParser
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.FileSystem
import org.apache.hadoop.fs.FileUtil
import org.apache.hadoop.fs.Path
import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions
import org.apache.spark.sql.SparkSession
import org.apache.spark.storage.StorageLevel
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
        val ss = head.union (guts).union (tail)
        ss.saveAsTextFile (txt)
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
    def export_iterable (elements: Iterable[Element], filename: String, about: String = ""): Unit =
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
        var todo = what

        val classes = new CHIM ("").classes

        // make a mapping of mRID to mRID
        // "if you include me, you have to include him" and vice-versa for some relations
        val relationships = classes.map (x ⇒ (x.name, x.relations)).toMap
        val ying_yang = getOrElse[Element]("Elements").flatMap (dependents (relationships)).persist (storage)

        // the done list is a list of PairRDD, the keys are the mRID and the values are the Island it belongs to
        var done: List[RDD[Item]] = List ()

        do
        {
            val next: RDD[(mRID, (Island, mRID))] = todo.join (ying_yang).persist (storage)
            done = done ++ Seq (todo)
            var new_todo: RDD[Item] = next.values.map (_.swap)
            done.foreach (d ⇒ new_todo = new_todo.subtractByKey (d))
            new_todo.persist (storage)
            next.unpersist (false)
            todo = new_todo
        }
        while (!todo.isEmpty)
        val all_done = session.sparkContext.union (done).distinct.persist (storage)

        val ret = getOrElse[Element]("Elements").keyBy (_.id).join (all_done).values.map (_.swap).persist (storage)
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
                export_iterable (elements, filename, island)
                1
            }
        ).sum.toInt
        log.info ("exported %s island%s".format (total, if (total == 1) "" else "s"))
        total
    }

    /**
     * Export every transformer service area.
     * @param directory The name of the directory to write the CIM files.
     * @return the number of transformers processed
     */
    def exportAllTransformers (directory: String = "simulation/"): Int =
    {
        val dir = if (directory.endsWith ("/")) directory else directory + "/"
        // get transformer low voltage pins
        val transformers: RDD[Item] = getOrElse [PowerTransformerEnd]
            .filter (_.TransformerEnd.endNumber != 1)
            .map (x ⇒ (x.TransformerEnd.Terminal, x.PowerTransformer))
            .join (getOrElse [Terminal].map (x ⇒ (x.id, x.TopologicalNode))).values
            .map (_.swap)
            .join (getOrElse [TopologicalNode].map (x ⇒ (x.id, x.TopologicalIsland))).values
            .map (_.swap)
            .groupByKey
            .mapValues (_.toArray.sortWith (_ < _).mkString ("_"))
            .persist (storage)
        val count = transformers.count
        log.info ("exporting %s transformer%s".format (count, if (count == 1) "" else "s"))

        val labeled = labelRelated (transformers)
        val trafokreise = labeled.groupByKey
        val total = trafokreise.map (
            group ⇒
            {
                val transformer = group._1
                val elements = group._2
                val filename = dir + transformer + ".rdf"
                log.info ("exporting %s".format (filename))
                export_iterable (elements, filename, transformer)
                1
            }
        ).sum.toInt
        log.info ("exported %s transformer%s".format (total, if (total == 1) "" else "s"))

        /*
        // create a convex hull for each transformer service area
        type Key = String
        type Value = String
        type KeyValue = (Key, Value)
        type KeyValueList = Iterable[KeyValue]
        val json: RDD[(String, (String, List[List[List[Double]]]), KeyValueList)] = trafokreise.map (
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
                val properties: KeyValueList = List (("mrid", transformer))
                ("Feature", geometry, properties)
            }
        )
        val contents = json.collect.mkString (",")

        /**
         * Index of normalOpen field in Switch bitmask.
         */
        val normalOpenMask: Int = Switch.fields.indexOf ("normalOpen")

        /**
         * Index of open field in Switch bitmask.
         */
        val openMask: Int = Switch.fields.indexOf ("open")

        /**
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
        val switches: RDD[(mRID, Iterable[Island])] = labeled.flatMap (switchp).groupByKey.filter (_._2.size > 1)
        */

        total
    }
}

/**
 * Application to export (subset by island) CIM files.
 *
 * This program reads in one or more CIM files and exports topological islands
 * as subset CIM files.
 *
 */
object CIMExportMain
{
    val properties: Properties =
    {
        val in = this.getClass.getResourceAsStream ("/app.properties")
        val p = new Properties ()
        p.load (in)
        in.close ()
        p
    }
    val APPLICATION_NAME: String = getClass.getName.substring (getClass.getName.lastIndexOf (".") + 1, getClass.getName.length - 1)
    val APPLICATION_VERSION: String = properties.getProperty ("version")
    val SPARK: String = properties.getProperty ("spark")

    private val log = LoggerFactory.getLogger (APPLICATION_NAME)

    object LogLevels extends Enumeration
    {
        type LogLevels = Value
        val ALL, DEBUG, ERROR, FATAL, INFO, OFF, TRACE, WARN = Value
    }
    implicit val LogLevelsRead: scopt.Read[LogLevels.Value] = scopt.Read.reads (LogLevels.withName)

    implicit val mapRead: scopt.Read[Map[String,String]] = scopt.Read.reads (
        s =>
        {
            var ret = Map[String, String] ()
            val ss = s.split (",")
            for (p <- ss)
            {
                val kv = p.split ("=")
                ret = ret + ((kv(0), kv(1)))
            }
            ret
        }
    )

    case class Arguments (
         quiet: Boolean = false,
         log_level: LogLevels.Value = LogLevels.OFF,
         // see https://spark.apache.org/docs/latest/configuration.html
         sparkopts: Map[String,String] = Map (
             "spark.graphx.pregel.checkpointInterval" → "8",
             "spark.serializer" → "org.apache.spark.serializer.KryoSerializer",
             "spark.ui.showConsoleProgress" → "false"),
         cimopts: Map[String,String] = Map (
             "ch.ninecode.cim.do_topo_islands" → "true"
         ),
         all: Boolean = false,
         islands: Boolean = false,
         transformers: Boolean = false,
         output: String = "simulation",
         files: Seq[String] = Seq()
     )

    val parser: OptionParser[Arguments] = new scopt.OptionParser[Arguments](APPLICATION_NAME)
    {
        head (APPLICATION_NAME, APPLICATION_VERSION)

        note ("Extracts subsets of CIM files based on topology.\n")

        help ("help").text ("prints this usage text")

        version ("version").text ("Scala: %s, Spark: %s, %s: %s".format (
            APPLICATION_VERSION.split ("-")(0),
            APPLICATION_VERSION.split ("-")(1),
            APPLICATION_NAME,
            APPLICATION_VERSION.split ("-")(2)
        ))

        val default = new Arguments

        opt[Unit]("quiet").
            action ((_, c) => c.copy (quiet = true)).
            text ("suppress informational messages [%s]".format (default.quiet))

        opt[LogLevels.Value]("logging").
            action ((x, c) => c.copy (log_level = x)).
            text ("log level, one of %s [%s]".format (LogLevels.values.iterator.mkString (","), default.log_level))

        opt[Map[String,String]]("sparkopts").valueName ("k1=v1,k2=v2").
            action ((x, c) => c.copy (sparkopts = x)).
            text ("Spark options [%s]".format (default.sparkopts.map (x ⇒ x._1 + "=" + x._2).mkString (",")))

        opt[Map[String,String]]("cimopts").valueName ("k1=v1,k2=v2").
            action ((x, c) => c.copy (cimopts = x)).
            text ("CIMReader options [%s]".format (default.cimopts.map (x ⇒ x._1 + "=" + x._2).mkString (",")))

        opt[Unit]("all").
            action ((_, c) => c.copy (all = true)).
            text ("export entire processed file [%s]".format (default.all))

        opt[Unit]("islands").
            action ((_, c) => c.copy (islands = true)).
            text ("export topological islands [%s]".format (default.islands))

        opt[Unit]("transformers").
            action ((_, c) => c.copy (transformers = true)).
            text ("export transformer service areas [%s]".format (default.transformers))

        opt[String]("output").valueName ("<file> or <dir>").
            action ((x, c) => c.copy (output = x)).
            text ("output file or directory name [%s]".format (default.output))

        arg[String]("<CIM> <CIM> ...").unbounded ().
            action ((x, c) => c.copy (files = c.files :+ x)).
            text ("CIM rdf files to process")
    }

    def jarForObject (obj: Object): String =
    {
        // see https://stackoverflow.com/questions/320542/how-to-get-the-path-of-a-running-jar-file
        var ret = obj.getClass.getProtectionDomain.getCodeSource.getLocation.getPath
        try
        {
            ret = URLDecoder.decode (ret, "UTF-8")
        }
        catch
        {
            case e: UnsupportedEncodingException => e.printStackTrace ()
        }
        if (!ret.toLowerCase ().endsWith (".jar"))
        {
            // as an aid to debugging, make jar in tmp and pass that name
            val name = "/tmp/" + Random.nextInt (99999999) + ".jar"
            val writer = new Jar (new scala.reflect.io.File (new java.io.File (name))).jarWriter ()
            writer.addDirectory (new scala.reflect.io.Directory (new java.io.File (ret + "ch/")), "ch/")
            writer.close ()
            ret = name
        }

        ret
    }

    /**
     * Main entry point for the Export program.
     *
     * @param args command line arguments
     */
    def main (args:Array[String])
    {
        parser.parse (args, Arguments ()) match
        {
            case Some (arguments) =>
                if (!arguments.quiet)
                    org.apache.log4j.LogManager.getLogger (APPLICATION_NAME).setLevel (org.apache.log4j.Level.INFO)
                if (!arguments.quiet)
                    org.apache.log4j.LogManager.getLogger ("ch.ninecode.cim.CIMExport").setLevel (org.apache.log4j.Level.INFO)
                if (!arguments.quiet)
                    org.apache.log4j.LogManager.getLogger ("ch.ninecode.cim.CIMNetworkTopologyProcessor").setLevel (org.apache.log4j.Level.INFO)
                val log = LoggerFactory.getLogger (APPLICATION_NAME)

                val configuration = new SparkConf ()
                configuration.setAppName (APPLICATION_NAME)
                if (arguments.sparkopts.nonEmpty)
                    arguments.sparkopts.map ((pair: (String, String)) => configuration.set (pair._1, pair._2))
                // get the necessary jar files to send to the cluster
                configuration.setJars (Array (jarForObject (new DefaultSource ())))
                // register for Kryo serialization
                configuration.registerKryoClasses (CIMClasses.list)

                val session_builder = SparkSession.builder ()
                val session = session_builder.config (configuration).getOrCreate ()
                val version = session.version
                log.info (s"Spark $version session established")
                if (version.take (SPARK.length) != SPARK.take (version.length))
                    log.warn (s"Spark version ($version) does not match the version ($SPARK) used to build $APPLICATION_NAME")

                try
                {
                    // read the file
                    val reader_options = scala.collection.mutable.HashMap[String, String] ()
                    arguments.cimopts.map ((pair: (String, String)) => reader_options.put (pair._1, pair._2))
                    reader_options.put ("path", arguments.files.mkString (","))
                    log.info ("reading CIM files %s".format (arguments.files.mkString (",")))
                    val elements = session.read.format ("ch.ninecode.cim").options (reader_options).load (arguments.files:_*)
                    log.info ("" + elements.count + " elements")

                    val export = new CIMExport (session)
                    if (arguments.all)
                        export.exportAll (arguments.output)
                    if (arguments.islands)
                        export.exportAllIslands (arguments.output)
                    else if (arguments.transformers)
                        export.exportAllTransformers (arguments.output)
                }
                finally
                {
                    session.stop ()
                }
                sys.exit (0)
            case None =>
                sys.exit (1)
        }
    }
}
