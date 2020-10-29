package ch.ninecode.cim

import java.io.UnsupportedEncodingException
import java.net.URLDecoder
import java.util.Properties

import scala.tools.nsc.io.Jar
import scala.util.Random

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import ch.ninecode.model.Element

case class CIMDifference (spark: SparkSession, options: CIMDifferenceOptions) extends CIMRDD
{
    implicit val session: SparkSession = spark
    implicit val log: Logger = LoggerFactory.getLogger(getClass)

    val FROMSUFFIX = "_from"
    val TOSUFFIX = "_to"
    val FROMPATTERN = s"%s$FROMSUFFIX"
    val TOPATTERN = s"%s$TOSUFFIX"
    var PATTERN: String = FROMPATTERN

    override def pattern: String = PATTERN

    def readCIM (files: Seq[String], pattern: String): Unit =
    {
        val reader_options = scala.collection.mutable.HashMap[String, String](
            "ch.ninecode.cim.name_template" -> pattern
        )
        options.cimopts.map(pair => reader_options.put(pair._1, pair._2))
        val filelist = files.mkString(",")
        reader_options.put("path", filelist)
        log.info(s"reading CIM files $filelist")
        val elements = session.read.format("ch.ninecode.cim").options(reader_options).load(files: _*)
        log.info(s"${elements.count} elements")
    }

    def nameAndSuffix (pair: (Int, RDD[_])): Option[(String, String)] =
    {
        val (_, rdd) = pair
        val name = rdd.name
        if (name.endsWith(FROMSUFFIX))
            Some((name.substring(0, name.length - FROMSUFFIX.length), FROMSUFFIX))
        else
            if (name.endsWith(TOSUFFIX))
                Some((name.substring(0, name.length - TOSUFFIX.length), TOSUFFIX))
            else
                None
    }

    def execute (): Unit =
    {
        val target = if ("" != options.output) s" ⇒ ${options.output}" else ""
        log.info(s"${options.mode.toString} from ${options.from.mkString(",")} to ${options.to.mkString(",")}$target")
        readCIM(options.from, FROMPATTERN)
        readCIM(options.to, TOPATTERN)

        PATTERN = FROMPATTERN
        val from = getOrElse[Element].keyBy(_.id)
        PATTERN = TOPATTERN
        val to = getOrElse[Element].keyBy(_.id)

        val join = from.fullOuterJoin(to)

        options.mode match
        {
            case Mode.ChangeSet =>
                CIMDifferenceChangeSet(options).execute(join)
            case Mode.HumanReadable =>
                CIMDifferenceRaw(options).execute(join)
            case Mode.Summary =>
                CIMDifferenceSummarize(options).execute(join)
        }
    }
}

object CIMDifference
{
    val properties: Properties =
    {
        val in = this.getClass.getResourceAsStream("/application.properties")
        val p = new Properties()
        p.load(in)
        in.close()
        p
    }
    val APPLICATION_NAME: String = properties.getProperty("artifactId")
    val APPLICATION_VERSION: String = properties.getProperty("version")
    val SPARK: String = properties.getProperty("spark")

    def jarForObject (obj: Object): String =
    {
        // see https://stackoverflow.com/questions/320542/how-to-get-the-path-of-a-running-jar-file
        var ret = obj.getClass.getProtectionDomain.getCodeSource.getLocation.getPath
        try
        {
            ret = URLDecoder.decode(ret, "UTF-8")
        }
        catch
        {
            case e: UnsupportedEncodingException => e.printStackTrace()
        }
        if (!ret.toLowerCase().endsWith(".jar"))
        {
            // as an aid to debugging, make jar in tmp and pass that name
            val name = s"/tmp/${Random.nextInt(99999999)}.jar"
            val writer = new Jar(new scala.reflect.io.File(new java.io.File(name))).jarWriter()
            writer.addDirectory(new scala.reflect.io.Directory(new java.io.File(s"${ret}ch/")), "ch/")
            writer.close()
            ret = name
        }

        ret
    }

    /**
     * Main entry point for the Export program.
     *
     * @param args command line arguments
     */
    def main (args: Array[String])
    {
        val optionparser = new CIMDifferenceOptionsParser(APPLICATION_NAME, APPLICATION_VERSION)

        optionparser.parse(args, CIMDifferenceOptions()) match
        {
            case Some(options) =>
                if (options.valid)
                {
                    if (options.loglevel != LogLevels.OFF)
                    {
                        org.apache.log4j.LogManager.getLogger("ch.ninecode.cim.CIMDifference").setLevel(LogLevels.toLog4j(options.loglevel))
                    }
                    val log = LoggerFactory.getLogger(this.getClass)

                    val configuration = new SparkConf()
                    configuration.setAppName(APPLICATION_NAME)
                    if ("" != options.master)
                        configuration.setMaster(options.master)
                    if (options.sparkopts.nonEmpty)
                        options.sparkopts.map(pair => configuration.set(pair._1, pair._2))
                    // get the necessary jar files to send to the cluster
                    configuration.setJars(Array(jarForObject(new DefaultSource())))
                    // register for Kryo serialization
                    configuration.registerKryoClasses(CIMClasses.list)

                    val session_builder = SparkSession.builder()
                    val session = session_builder.config(configuration).getOrCreate()
                    val version = session.version
                    log.info(s"Spark $version session established")
                    if (version.take(SPARK.length) != SPARK.take(version.length))
                        log.warn(s"Spark version ($version) does not match the version ($SPARK) used to build $APPLICATION_NAME")

                    try
                    {
                        val diff = new CIMDifference(session, options)
                        diff.execute()
                    }
                    finally
                    {
                        session.stop()
                    }
                }
                if (!options.unittest)
                    sys.exit(0)
            case None =>
                sys.exit(1)
        }
    }
}