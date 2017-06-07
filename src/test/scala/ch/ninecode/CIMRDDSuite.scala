package ch.ninecode

import java.io.File

import scala.collection.mutable.HashMap
import scala.util.Random

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.Path
import org.apache.hadoop.mapreduce.lib.input.FileSplit
import org.apache.hadoop.mapreduce.TaskAttemptContext
import org.apache.hadoop.mapred.JobConf
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions
import org.apache.spark.sql.Row
import org.apache.spark.sql.types.SQLUserDefinedType
import org.scalatest.fixture.FunSuite

import ch.ninecode.cim.CHIM
import ch.ninecode.cim.CIMInputFormat
import ch.ninecode.cim.CIMRecordReader
import ch.ninecode.model.Element
import ch.ninecode.model.Unknown

class CIMRDDSuite extends FunSuite
{
    val FILE_DEPOT = "data/"
    val PRIVATE_FILE_DEPOT = "private_data/"

    type FixtureParam = SparkContext

    // test file names
    val FILENAME1 = FILE_DEPOT + "NIS_CIM_Export_NS_INITIAL_FILL_Oberiberg.rdf"
    val FILENAME2 = FILE_DEPOT + "NIS_CIM_Export_NS_INITIAL_FILL_Stoos.rdf"
    val FILENAME3 = FILE_DEPOT + "NIS_CIM_Export_NS_INITIAL_FILL.rdf"
    val FILENAME4 = PRIVATE_FILE_DEPOT + "bkw_cim_export_defaultall.rdf"

    // number of elements in the file
    // get number of lines at the top level with:
    // grep -P "^[\t]<cim" NIS_CIM_Export_NS_INITIAL_FILL_Oberiberg.rdf | wc
    val ELEMENTS1 = 22312
    val ELEMENTS2 = 36927
    val ELEMENTS3 = 679473

    // number of elements in a 1MB chunk
    // tail --bytes=+3145728 NIS_CIM_Export_NS_INITIAL_FILL_Oberiberg.rdf | head --bytes=1048576 | grep -P "^[\t]<cim" | wc
    val OFFSET = 3145728
    val PARTIAL_MAP_SIZE = 2546

    // tail --bytes=+5905580032 bkw_cim_export_defaultall.rdf | head --bytes=67108864 | grep -P "^[\t]<cim" | wc
    val SIZE4 = 64L * 1024L * 1024L // 67108864
    val OFFSET4 = 88L * SIZE4 // 5905580032
    val PARTIAL4 = 150674

    def rddFile (context: SparkContext, filename: String, offset: Long = 0, length: Long = 0): RDD[Row] =
    {
        val size = if (0L != length) length else new File (filename).length () - offset
        val (xml, start, end) = CHIM.read (filename, offset, size)
        //markup ("" + start + ":" + end + " " + offset + "+" + size + " " + xml.substring (0, 50))
        val parser = new CHIM (xml, start, end)
        val result = CHIM.parse (parser)
        assert (result._2.length === 0)
        return (context.parallelize (result._1.values.toSeq))
    }

    def rddHadoop (context: SparkContext, map: Map[String,String]): RDD[Element] =
    {
        val configuration = map.foldLeft (new Configuration (context.hadoopConfiguration))((c, e) => { c.set (e._1, e._2); c })
        context.newAPIHadoopRDD (configuration, classOf[CIMInputFormat], classOf[String], classOf[Element]).values
    }

    def withFixture (test: OneArgTest) =
    {
        // create the fixture
        val configuration = new SparkConf ()
        configuration.setAppName ("CIMRDDSuite")
        configuration.setMaster ("local[2]")
        configuration.set ("spark.ui.showConsoleProgress", "false")
        val context = new SparkContext (configuration)
        context.setLogLevel ("OFF") // Valid log levels include: ALL, DEBUG, ERROR, FATAL, INFO, OFF, TRACE, WARN
        try
        {
            withFixture (test.toNoArgTest (context)) // "loan" the fixture to the test
        }
        finally context.stop () // clean up the fixture
    }

    test ("Create")
    {
        context ⇒
        val xml = "yadda yadda <cim:PSRType rdf:ID=\"PSRType_Substation\">\n<cim:IdentifiedObject.name>Substation</cim:IdentifiedObject.name>\n</cim:PSRType> foo bar"
        val parser = new CHIM (xml.toString ())
        val result = CHIM.parse (parser)
        assert (result._1.size === 1)
        assert (result._2.length === 0)
        val rdd = context.parallelize (result._1.toSeq, 2)
        assert (rdd.count () === 1)
    }

    test ("Read")
    {
        context ⇒
        val rdd = rddFile (context, FILENAME1, 0, 0)
        assert (rdd.count () === ELEMENTS1)
    }

    test ("Read Partial")
    {
        context ⇒
        val (xml, start, end) = CHIM.read (FILENAME1, OFFSET, 1024 * 1024) // exactly a megabyte
        //markup ("" + start + ":" + end + " " + OFFSET + "+" + 1024 * 1024 + " " + xml.substring (0, 50))
        val parser = new CHIM (xml, start, end, OFFSET, OFFSET + (1024 * 1024))
        val result = CHIM.parse (parser)
        assert (result._1.size === PARTIAL_MAP_SIZE)
        assert (result._2.length === 0)
        assert (result._1.filter (_.getClass() == classOf[Unknown]).size == 0)
    }

    test ("Merge Partial")
    {
        context ⇒
        val size = new File (FILENAME3).length ().toInt
        var offset = 0
        var count = 0 // count of elements
        val random = new Random ()
        var last: RDD[String] = null // previous result
        var rdd: RDD[String] = null // the current result
        while (offset < size)
        {
            var piece = random.nextInt (size / 10)
            if (offset + piece > size)
                piece = size - offset
            var (xml, start, end) = CHIM.read (FILENAME3, offset, piece)
            //markup ("" + start + ":" + end + " " + offset + "+" + piece + " " + xml.substring (0, 50))
            val parser = new CHIM (xml, start, end, offset, offset + piece)
            xml = null
            val result = CHIM.parse (parser)
            //markup ("" + result._1.size + " elements")
            assert (result._2.length === 0)
            val rdd = context.parallelize (result._1.keys.toSeq)
            if (null != last)
            {
                val int = rdd.intersection (last)
                if (int.count () != 0)
                {
                    val i1 = int.collect ()
                    markup ("There were non-zero intersections between rdd1 and rdd2 (" + i1.length + ") like:")
                    for (i <- 0 until i1.length)
                        markup (i1 (i))
                }
                assert (int.count () == 0)
            }
            last = rdd
            offset += piece
            count += result._1.size
        }
        assert (count === ELEMENTS3)
    }

    test ("Hadoop")
    {
        context ⇒
        val rdd = rddHadoop (context, Map (("mapreduce.input.fileinputformat.inputdir", FILENAME1)))
        val unknowns = rdd.collect ({ case x: Any if x.getClass () == classOf[Unknown] => x.asInstanceOf[Unknown] })
        if (unknowns.count () != 0)
        {
            val u = unknowns.first ()
            markup ("There were non-zero unknowns (" + unknowns.count () + ") like @line " + u.line + " when parsing text starting at " + u.start + " and last parse ending at " + u.end + " with internal text '" + u.guts + "'")
        }
        assert (rdd.count () === ELEMENTS1)
    }

    test ("Multiple Files")
    {
        context ⇒
        val rdd1 = rddHadoop (context, Map (("mapreduce.input.fileinputformat.inputdir", FILENAME1)))
        val rdd2 = rddHadoop (context, Map (("mapreduce.input.fileinputformat.inputdir", FILENAME2)))
        val rdd3 = rddHadoop (context, Map (("mapreduce.input.fileinputformat.inputdir", FILENAME1 + "," + FILENAME2)))
        assert (rdd1.count () === ELEMENTS1)
        assert (rdd2.count () === ELEMENTS2)
        assert (rdd3.count () === (ELEMENTS1 + ELEMENTS2))
    }

    test ("Splits")
    {
        context ⇒
        val rdd1 = rddHadoop (context, Map (("mapreduce.input.fileinputformat.inputdir", FILENAME3)))
        val rdd2 = rddHadoop (context, Map (("mapreduce.input.fileinputformat.inputdir", FILENAME3), ("mapreduce.input.fileinputformat.split.maxsize", "655360")))
        assert (rdd1.count () === ELEMENTS3)
        assert (rdd2.count () === ELEMENTS3)
    }

    case class MyInputSplit (file: String, start: Long, end: Long) extends FileSplit
    {
        override def getStart (): Long = start
        override def getPath (): Path = new Path (file)
        override def getLength (): Long = end - start
        override def getLocations (): Array[String] = Array (file)
    }

    case class MyTaskAttemptContext () extends TaskAttemptContext
    {
        val task = new org.apache.hadoop.mapred.TaskID ("test case", 1, org.apache.hadoop.mapreduce.TaskType.JOB_SETUP, 1)
        override def getTaskAttemptID () = new org.apache.hadoop.mapred.TaskAttemptID (task, 1)

        // Members declared in org.apache.hadoop.mapreduce.JobContext
        def getArchiveClassPaths(): Array[org.apache.hadoop.fs.Path] = ???
        def getArchiveTimestamps(): Array[String] = ???
        def getCacheArchives(): Array[java.net.URI] = ???
        def getCacheFiles(): Array[java.net.URI] = ???
        def getCombinerClass(): Class[_ <: org.apache.hadoop.mapreduce.Reducer[_, _, _, _]] = ???
        def getConfiguration(): org.apache.hadoop.conf.Configuration = new org.apache.hadoop.conf.Configuration ()
        def getCredentials(): org.apache.hadoop.security.Credentials = ???
        def getFileClassPaths(): Array[org.apache.hadoop.fs.Path] = ???
        def getFileTimestamps(): Array[String] = ???
        def getGroupingComparator(): org.apache.hadoop.io.RawComparator[_] = ???
        def getInputFormatClass(): Class[_ <: org.apache.hadoop.mapreduce.InputFormat[_, _]] = ???
        def getJar(): String = ???
        def getJobID(): org.apache.hadoop.mapreduce.JobID = ???
        def getJobName(): String = ???
        def getJobSetupCleanupNeeded(): Boolean = ???
        def getLocalCacheArchives(): Array[org.apache.hadoop.fs.Path] = ???
        def getLocalCacheFiles(): Array[org.apache.hadoop.fs.Path] = ???
        def getMapOutputKeyClass(): Class[_] = ???
        def getMapOutputValueClass(): Class[_] = ???
        def getMapperClass(): Class[_ <: org.apache.hadoop.mapreduce.Mapper[_, _, _, _]] = ???
        def getMaxMapAttempts(): Int = ???
        def getMaxReduceAttempts(): Int = ???
        def getNumReduceTasks(): Int = ???
        def getOutputFormatClass(): Class[_ <: org.apache.hadoop.mapreduce.OutputFormat[_, _]] = ???
        def getOutputKeyClass(): Class[_] = ???
        def getOutputValueClass(): Class[_] = ???
        def getPartitionerClass(): Class[_ <: org.apache.hadoop.mapreduce.Partitioner[_, _]] = ???
        def getProfileEnabled(): Boolean = ???
        def getProfileParams(): String = ???
        def getProfileTaskRange(x$1: Boolean): org.apache.hadoop.conf.Configuration.IntegerRanges = ???
        def getReducerClass(): Class[_ <: org.apache.hadoop.mapreduce.Reducer[_, _, _, _]] = ???
        def getSortComparator(): org.apache.hadoop.io.RawComparator[_] = ???
        def getSymlink(): Boolean = ???
        def getTaskCleanupNeeded(): Boolean = ???
        def getUser(): String = ???
        def getWorkingDirectory(): org.apache.hadoop.fs.Path = ???

        // Members declared in org.apache.hadoop.util.Progressable
        def progress(): Unit = ???

        // Members declared in org.apache.hadoop.mapreduce.TaskAttemptContext
        def getCounter(x$1: String,x$2: String): org.apache.hadoop.mapreduce.Counter = ???
        def getCounter(x$1: Enum[_]): org.apache.hadoop.mapreduce.Counter = ???
        def getProgress(): Float = ???
        def getStatus(): String = ???
        def setStatus(x$1: String): Unit = ???
    }

    test ("Read beyond 2GB")
    {
        context ⇒
        val reader = new CIMRecordReader ()
        val split = MyInputSplit (FILENAME4, OFFSET4, OFFSET4 + SIZE4)
        val context = MyTaskAttemptContext ()
        reader.initialize (split, context)
        var count = 0
        while (reader.nextKeyValue)
            count += 1
        reader.close ()
        assert (count === PARTIAL4)

    }
}
