package ch.ninecode.cim

import java.io.UnsupportedEncodingException
import java.net.URLDecoder
import java.util.Properties

import scala.tools.nsc.io.Jar
import scala.util.Random

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
        val in = this.getClass.getResourceAsStream ("/application.properties")
        val p = new Properties ()
        p.load (in)
        in.close ()
        p
    }
    val APPLICATION_NAME: String = properties.getProperty ("artifactId")
    val APPLICATION_VERSION: String = properties.getProperty ("version")
    val SPARK: String = properties.getProperty ("spark")

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
            val name = s"/tmp/${Random.nextInt (99999999)}.jar"
            val writer = new Jar (new scala.reflect.io.File (new java.io.File (name))).jarWriter ()
            writer.addDirectory (new scala.reflect.io.Directory (new java.io.File (s"${ret}ch/")), "ch/")
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
        val optionparser = new CIMExportOptionsParser (APPLICATION_NAME, APPLICATION_VERSION)

        optionparser.parse (args, CIMExportOptions ()) match
        {
            case Some (options) =>
                if (options.valid)
                {
                    if (options.loglevel != LogLevels.OFF)
                    {
                        org.apache.log4j.LogManager.getLogger ("ch.ninecode.cim.CIMExport").setLevel (LogLevels.toLog4j (options.loglevel))
                        org.apache.log4j.LogManager.getLogger ("ch.ninecode.cim.CIMNetworkTopologyProcessor").setLevel (LogLevels.toLog4j (options.loglevel))
                    }
                    val log = LoggerFactory.getLogger (this.getClass)

                    val configuration = new SparkConf ()
                    configuration.setAppName (APPLICATION_NAME)
                    if ("" != options.master)
                        configuration.setMaster (options.master)
                    if (options.sparkopts.nonEmpty)
                        options.sparkopts.map (pair => configuration.set (pair._1, pair._2))
                    // get the necessary jar files to send to the cluster
                    configuration.setJars (Array (jarForObject (new DefaultSource ())))
                    // register for Kryo serialization
                    configuration.registerKryoClasses (CIMClasses.list)
                    // choose which Cassandra
                    configuration.set ("spark.cassandra.connection.host", options.host)
                    configuration.set ("spark.cassandra.connection.port", options.port.toString)

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
                        options.cimopts.map (pair => reader_options.put (pair._1, pair._2))
                        val filelist = options.files.mkString (",")
                        reader_options.put ("path", filelist)
                        log.info (s"reading CIM files $filelist")
                        val elements = session.read.format ("ch.ninecode.cim").options (reader_options).load (options.files:_*)
                        log.info (s"${elements.count} elements")

                        val export = new CIMExport (session)
                        if (options.all)
                            export.exportAll (options.outputfile)
                        if (options.islands)
                            export.exportAllIslands (options.outputdir)
                        else if (options.transformers)
                            export.exportAllTransformers (options)
                    }
                    finally
                    {
                        session.stop ()
                    }
                }
                if (!options.unittest)
                    sys.exit (0)
            case None =>
                sys.exit (1)
        }
    }
}
