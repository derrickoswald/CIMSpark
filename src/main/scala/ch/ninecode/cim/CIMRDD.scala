package ch.ninecode.cim

import java.io.UnsupportedEncodingException
import java.net.URLDecoder

import scala.tools.nsc.io.Jar
import scala.util.Random

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.hive.thriftserver.HiveThriftServer2
import org.apache.spark.storage.StorageLevel
import org.slf4j.LoggerFactory

import ch.ninecode.model._

//// NOTE: in order to get maven and scala to work together in Eclipse
//// I needed to install the maven-scala plugin from here:
//// http://alchim31.free.fr/m2e-scala/update-site/

/**
 * Wrapper class for CIM.
 *
 * This class isolates the Spark related dependencies, so the CIM
 * class remains unencumbered by the heavy overhead.
 *
 */
object CIMRDD
{
    private val log = LoggerFactory.getLogger(getClass)
    val APPLICATION_NAME = "CIMRDD JDBC Server"
    val APPLICATION_VERSION = "2.11-2.0.2-2.0.0"

    object LogLevels extends Enumeration
    {
        type LogLevels = Value
        val ALL, DEBUG, ERROR, FATAL, INFO, OFF, TRACE, WARN = Value
    }
    implicit val LogLevelsRead: scopt.Read[LogLevels.Value] = scopt.Read.reads (LogLevels.withName (_))

    implicit val mapRead: scopt.Read[Map[String,String]] = scopt.Read.reads (
    (s) =>
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
        master: String = "",
        opts: Map[String,String] = Map(),
        storage: String = "MEMORY_AND_DISK_SER",
        dedup: Boolean = false,
        log_level: LogLevels.Value = LogLevels.OFF,
        port: Int = 10004,
        files: Seq[String] = Seq()
    )

    val parser = new scopt.OptionParser[Arguments](APPLICATION_NAME)
    {
        head (APPLICATION_NAME, APPLICATION_VERSION)

        opt[Unit]('q', "quiet").
            action ((_, c) => c.copy (quiet = true)).
            text ("supress informational messages")

        opt[String]('m', "master").valueName ("MASTER_URL").
            action ((x, c) => c.copy (master = x)).
            text ("spark://host:port, mesos://host:port, yarn, or local[*]")

        opt[Map[String,String]]('o', "opts").valueName ("k1=v1,k2=v2").
            action ((x, c) => c.copy (opts = x)).
            text ("other Spark options")

        opt[String]('s', "storage_level").
            action ((x, c) => c.copy (storage = x)).
            text ("storage level for RDD serialization (default: MEMORY_AND_DISK_SER)")

        opt[Unit]('u', "deduplicate").
            action ((_, c) => c.copy (dedup = true)).
            text ("de-duplicate input (striped) files")

        opt[LogLevels.Value]('l', "logging").
            action ((x, c) => c.copy (log_level = x)).
            text ("log level, one of " + LogLevels.values.iterator.mkString (","))

        opt[Int]('p', "port").valueName ("integer").
            action ((x, c) => c.copy (port = x)).
            text ("Hive Thriftserver port")

        help ("help").text ("prints this usage text")

        arg[String]("<CIM> <CIM> ...").unbounded ().
            action ((x, c) => c.copy (files = c.files :+ x)).
            text ("CIM rdf files to process")
    }

    def jarForObject (obj: Object): String =
    {
        // see https://stackoverflow.com/questions/320542/how-to-get-the-path-of-a-running-jar-file
        var ret = obj.getClass.getProtectionDomain ().getCodeSource ().getLocation ().getPath ()
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

        return (ret)
    }

    def main (args:Array[String])
    {
        parser.parse (args, Arguments ()) match
        {
            case Some (arguments) =>
                if (!arguments.quiet) org.apache.log4j.LogManager.getLogger ("ch.ninecode.cim.CIMRDD$").setLevel (org.apache.log4j.Level.INFO)
                val log = LoggerFactory.getLogger (getClass)

                val configuration = new SparkConf ()
                configuration.setAppName (APPLICATION_NAME)
                if ("" != arguments.master)
                    configuration.setMaster (arguments.master)
                if (arguments.opts.size != 0)
                    arguments.opts.map ((pair: Tuple2[String, String]) => configuration.set (pair._1, pair._2))
                // get the necessary jar files to send to the cluster
                if ("" != arguments.master)
                {
                    val s1 = jarForObject (new DefaultSource ())
                    configuration.setJars (Array (s1))
                }

                if (StorageLevel.fromString (arguments.storage).useDisk)
                {
                    // register low level classes
                    configuration.registerKryoClasses (Array (classOf[Element], classOf[BasicElement], classOf[Unknown]))
                    // register CIM case classes
                    CHIM.apply_to_all_classes { x => configuration.registerKryoClasses (Array (x.runtime_class)) }
                    // register edge related classes
                    configuration.registerKryoClasses (Array (classOf[PreEdge], classOf[Extremum], classOf[PostEdge]))
                    // register topological classes
                    configuration.registerKryoClasses (Array (classOf[CuttingEdge], classOf[TopologicalData]))
                }
                configuration.set ("spark.ui.showConsoleProgress", "false")
                configuration.set ("spark.ui.showConsoleProgress", "false")
                configuration.set ("spark.sql.hive.thriftServer.singleSession", "true")
                val session_builder = SparkSession.builder()
                session_builder.enableHiveSupport()
                val session = session_builder.config (configuration).getOrCreate ()
                log.info ("Spark " + session.version +  " session established")

                try
                {


                    // read the file
                    log.info ("reading CIM files")
                    val reader_options = new scala.collection.mutable.HashMap[String, String] ()
                    reader_options.put ("path", arguments.files.mkString (","))
                    reader_options.put ("ch.ninecode.cim.make_edges", "false")
                    reader_options.put ("ch.ninecode.cim.do_join", "false")
                    reader_options.put ("ch.ninecode.cim.do_topo", "false") // use the topological processor after reading
                    reader_options.put ("ch.ninecode.cim.do_topo_islands", "false")
                    val elements = session.read.format ("ch.ninecode.cim").options (reader_options).load (arguments.files:_*)
                    if (-1 != session.sparkContext.master.indexOf ("sandbox")) // are we in development
                        elements.explain
                    else
                        log.info (elements.count () + " elements")


//                    var sql = "create temporary table elements using ch.ninecode.cim options (path '" + arguments.files.mkString (",") + "')"
//                    val dataframe = session.sqlContext.sql (sql)
//                    val count = session.sqlContext.sql ("select count(*) from elements")
//                    println ("dataframe created with " + count.head ().getLong (0) + " elements")

                    // start the thrift JDBC server
                    // set the port if it was specified, otherwise use the default of port 10000
                    session.sqlContext.setConf ("hive.server2.thrift.port", arguments.port.toString)
                    HiveThriftServer2.startWithContext (session.sqlContext)
                    log.info ("thriftserver started")

                    // show databases
//                log.info ("databases")
//                var sql = "show databases";
//                val databases = sql_context.sql (sql)
//                for (database <- databases)
//                   log.info (database.toString ())

//                    log.info ("tables")
//                    val tables = session.sqlContext.tableNames ()
//                    for (table <- tables)
//                       log.info (table.toString ())

                    var sql = "show tables"
                    val dataframe = session.sqlContext.sql (sql)
                    for (x <- dataframe)
                        log.info (x.getString (0))

                    scala.io.StdIn.readLine ("Press [Return] to exit...")
                    println ("Done.")
                }
                finally
                {
                    session.stop ();
                }
                sys.exit (0)
            case None =>
                sys.exit (1)
        }
    }
}
