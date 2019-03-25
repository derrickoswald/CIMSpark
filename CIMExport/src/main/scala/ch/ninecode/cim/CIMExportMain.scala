package ch.ninecode.cim

import java.io.UnsupportedEncodingException
import java.net.URLDecoder
import java.util.Properties

import scala.tools.nsc.io.Jar
import scala.util.Random
import scopt.OptionParser

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.slf4j.LoggerFactory

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
        outputfile: String = "export.rdf",
        outputdir: String = "simulation/",
        cassandra: Boolean = false,
        host: String = "localhost",
        keyspace: String = "cimexport",
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

        opt[String]("outputfile").valueName ("<file>").
            action ((x, c) => c.copy (outputfile = x)).
            text ("output file name [%s]".format (default.outputfile))

        opt[String]("outputdir").valueName ("<dir>").
            action ((x, c) => c.copy (outputdir = x)).
            text ("output directory name [%s]".format (default.outputdir))

        opt[Unit]("cassandra").
            action ((_, c) => c.copy (cassandra = true)).
            text ("output transformer metadata to cassandra [%s]".format (default.cassandra))

        opt [String]("host").valueName ("<cassandra>").
            action ((x, c) ⇒ c.copy (host = x)).
            text ("Cassandra connection host (listen_address or seed in cassandra.yaml) [%s]".format (default.host))

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
                // choose which Cassandra
                configuration.set ("spark.cassandra.connection.host", arguments.host)

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
                        export.exportAll (arguments.outputfile)
                    if (arguments.islands)
                        export.exportAllIslands (arguments.outputdir)
                    else if (arguments.transformers)
                        export.exportAllTransformers (arguments.outputdir, arguments.cassandra, arguments.keyspace)
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
