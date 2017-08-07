package ch.ninecode.cim

import java.io.UnsupportedEncodingException
import java.net.URLDecoder
import java.util.Properties

import scala.tools.nsc.io.Jar
import scala.util.Random

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.hive.thriftserver.HiveThriftServer2
import org.apache.spark.storage.StorageLevel
import org.slf4j.LoggerFactory

import ch.ninecode.model.BasicElement
import ch.ninecode.model.Element
import ch.ninecode.model.Unknown

/**
 * Application to expose CIM files as a Hive database.
 *
 * This program reads in one or more CIM files and
 * runs a Hive/Thrift server to expose the RDD as JDBC tables.
 *
 * The program is usually run on the master node with a command like:
 * <code>
 * $ spark-submit --master spark://sandbox:7077 --driver-memory 1g --executor-memory 4g /opt/code/CIMServerJDBC-2.11-2.0.2-2.1.0-jar-with-dependencies.jar --host sandbox --port 10004 "hdfs://sandbox:8020/data/cim_data_file.rdf"
 * </code>
 *
 * It will read the rdf file and create a Spark RDD for each CIM class,
 * a description of which can be found in [Model.md](https://github.com/derrickoswald/CIMReader/blob/master/Model.md).
 *
 * It then sets up a Hive/Thrift server on port 10004 (or what was specified on the command line)
 * to serve these RDD as JDBC tables.
 *
 * The program then waits for a Return to signal that it should exit.
 *
 * A java client program can get a JDBC connection to the Hive/Thrift server
 * using the [Hive JDBC driver](https://mvnrepository.com/artifact/org.apache.hive/hive-jdbc/2.0.1)
 * and the usual JDBC connection process:
 * <code>
 * private static String driverName = "org.apache.hive.jdbc.HiveDriver";
 * private static String port = "10004";
 * private static String database = "default";
 * private static String host = "localhost";
 * private static String user = "hive";
 * try
 * {
 *     Class.forName (driverName);
 * }
 * catch (ClassNotFoundException e)
 * {
 *     e.printStackTrace ();
 *     System.exit (1);
 * }
 * Connection con = DriverManager.getConnection ("jdbc:hive2://" + host + ":" + port + "/" + database, user, "");
 * </code>
 *
 * A [sample program](https://github.com/derrickoswald/CIMReader/blob/master/src/test/java/ch/ninecode/CIMJava.java)
 * is provided in the src/main/java directory.
 *
 */
object CIMServerJDBC
{
    val properties =
    {
        val in = this.getClass.getResourceAsStream ("/app.properties")
        val p = new Properties ();
        p.load (in)
        in.close
        p
    }
    val APPLICATION_NAME = getClass.getName.substring (getClass.getName.lastIndexOf (".") + 1, getClass.getName.length - 1)
    val APPLICATION_VERSION = properties.getProperty ("version")
    val SPARK = properties.getProperty ("spark")

    private val log = LoggerFactory.getLogger (APPLICATION_NAME)

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
        host: String = "localhost",
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

        opt[String]('h', "host").valueName ("host name or IP address").
            action ((x, c) => c.copy (host = x)).
            text ("Hive Thriftserver host interface to bind to")

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
                if (!arguments.quiet)
                    org.apache.log4j.LogManager.getLogger (APPLICATION_NAME).setLevel (org.apache.log4j.Level.INFO)
                val log = LoggerFactory.getLogger (APPLICATION_NAME)

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
                configuration.set ("spark.sql.hive.thriftServer.singleSession", "true")
                // set the host and port if specified, otherwise use the default of localhost:10004
                configuration.set ("hive.server2.thrift.bind.host", arguments.host)
                configuration.set ("hive.server2.thrift.port", arguments.port.toString)
                configuration.set ("hive.server2.authentication", "NONE")
                configuration.set ("hive.server2.enable.doAs", "false")
                configuration.set ("hive.server2.enable.impersonation", "false")
                // https://issues.apache.org/jira/browse/SPARK-5159
                // https://issues.apache.org/jira/browse/SPARK-11248
//                configuration.set ("hive.metastore.execute.setugi", "true")
                val session_builder = SparkSession.builder ()
                session_builder.enableHiveSupport ()
                val session = session_builder.config (configuration).getOrCreate ()
                val version = session.version
                log.info (s"Spark $version session established")
                if (version.take (SPARK.length) != SPARK.take (version.length))
                    log.warn (s"Spark version ($version) does not match the version ($SPARK) used to build $APPLICATION_NAME")

                try
                {
                    // read the file
                    log.info ("reading CIM files")
                    val reader_options = new scala.collection.mutable.HashMap[String, String] ()
                    reader_options.put ("path", arguments.files.mkString (","))
                    reader_options.put ("ch.ninecode.cim.make_edges", "false")
                    reader_options.put ("ch.ninecode.cim.do_join", "false")
                    reader_options.put ("ch.ninecode.cim.do_topo", "false")
                    reader_options.put ("ch.ninecode.cim.do_topo_islands", "false")
                    val elements = session.read.format ("ch.ninecode.cim").options (reader_options).load (arguments.files:_*)
                    if (-1 != session.sparkContext.master.indexOf ("sandbox")) // are we in development
                        elements.explain
                    else
                        log.info ("" + elements.count + " elements")

                    // start the thrift JDBC server
                    HiveThriftServer2.startWithContext (session.sqlContext)
                    log.info ("thriftserver started on port " + arguments.port)

//                    log.info ("databases")
//                    val databases = session.sqlContext.sql ("show databases")
//                    for (database <- databases)
//                        log.info (database.toString ())

                    log.info ("serving tables:")
                    val tables = session.sqlContext.tableNames ()
                    for (table <- tables)
                       log.info (table.toString ())

//                    log.info ("tables #2")
//                    val dataframe = session.sqlContext.sql ("show tables")
//                    for (x <- dataframe)
//                        log.info (x.getString (0))

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
