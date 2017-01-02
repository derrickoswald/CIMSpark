package ch.ninecode

import java.io.File

import scala.util.Random

import org.apache.hadoop.conf.Configuration
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions
import org.apache.spark.sql.Row
import org.apache.spark.sql.types.SQLUserDefinedType
import org.scalatest.fixture

import ch.ninecode.cim.CIMInputFormat
import ch.ninecode.model.CHIM
import ch.ninecode.model.Element
import ch.ninecode.model.Unknown

class CIMRDDSuite extends fixture.FunSuite
{
    type FixtureParam = SparkContext

    // test file names
    val FILENAME1 = "data/NIS_CIM_Export_NS_INITIAL_FILL_Oberiberg.rdf"
    val FILENAME2 = "data/NIS_CIM_Export_NS_INITIAL_FILL_Stoos.rdf"

    // number of elements in the file
    // get number of lines at the top level with:
    // grep -P "^[\t]<cim" NIS_CIM_Export_NS_INITIAL_FILL_Oberiberg.rdf | wc
    val ELEMENTS1 = 14584
    val ELEMENTS2 = 23576

    // number of elements in a 1MB chunk
    // this is approximately (off by +one)
    // tail --bytes=+3145728 NIS_CIM_Export_NS_INITIAL_FILL_Oberiberg.rdf | head --bytes=1048576 | grep -P "^[\t]<cim" | wc
    val OFFSET = 3145728
    val PARTIAL_MAP_SIZE = 2544

    def rddFile (sc: SparkContext, filename: String, offset: Long = 0, length: Long = 0): RDD[Row] =
    {
        var size: Long = length
        if (0 == size)
            size = new File (filename).length () - offset
        val (xml, start, end) = CHIM.read (filename, offset, size)
        val parser = new CHIM (xml, start, end)
        val map = parser.parse ()
        return (sc.parallelize (map.values.toSeq))
    }

    def rddHadoop (sc: SparkContext, hdfs: String): RDD[Element] =
    {
        // make a config
        val configuration = new Configuration (sc.hadoopConfiguration)
        configuration.set ("mapreduce.input.fileinputformat.inputdir", hdfs);

        // RDD[(String, Element)]
        val rdd = sc.newAPIHadoopRDD (configuration, classOf[CIMInputFormat], classOf[String], classOf[Element])

        return (rdd.values)
    }

    def withFixture (test: OneArgTest): org.scalatest.Outcome =
    {
        // create the fixture
        val configuration = new SparkConf ()
        configuration.setAppName ("CIMRDDSuite")
        configuration.setMaster ("local[2]")
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
        sc ⇒
        val xml = "yadda yadda <cim:PSRType rdf:ID=\"PSRType_Substation\">\n<cim:IdentifiedObject.name>Substation</cim:IdentifiedObject.name>\n</cim:PSRType> foo bar"
        val parser = new CHIM (xml.toString ())
        val map = parser.parse ()
        assert (map.size === 1)
        val rdd = sc.parallelize (map.toSeq, 2)
        assert (rdd.count () === 1)
    }

    test ("Read")
    {
        sc ⇒
        val rdd = rddFile (sc, FILENAME1, 0, 0)
        assert (rdd.count () === ELEMENTS1)
    }

    test ("Read Partial")
    {
        sc ⇒
        val (xml, start, end) = CHIM.read (FILENAME1, OFFSET, 1024 * 1024, 0) // exactly a megabyte
        val parser = new CHIM (xml, start, end)
        val map = parser.parse ()
        markup ("map size: " + map.size)
        assert (map.size == PARTIAL_MAP_SIZE)
        assert (map.filter (_.getClass() == classOf[Unknown]).size == 0)
    }

    test ("Merge Partial")
    {
        sc ⇒
        val size = new File (FILENAME1).length ().asInstanceOf[Int]
        var offset = 0
        var count = 0 // count of elements
        val random = new Random ()
        var last: RDD[String] = null // previous result
        var rdd: RDD[String] = null // the current result
        while (offset < size)
        {
            var piece = random.nextInt (size)
            if (offset + piece > size)
                piece = size - offset
            var (xml, start, end) = CHIM.read (FILENAME1, offset, piece)
            markup ("xml " + xml.substring (0, 60))
            val parser = new CHIM (xml, start, end)
            xml = null
            val map = parser.parse ()
            markup ("map has " + map.size + " elements")
            val rdd = sc.parallelize (map.keys.toSeq)
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
            count += map.size
        }
        assert (count === ELEMENTS1)
    }

    test ("Hadoop")
    {
        sc ⇒
        val rdd = rddHadoop (sc, FILENAME1)
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
        sc ⇒
        val rdd1 = rddHadoop (sc, FILENAME1)
        val rdd2 = rddHadoop (sc, FILENAME2)
        val rdd3 = rddHadoop (sc, FILENAME1 + "," + FILENAME2)
        assert (rdd1.count () === ELEMENTS1)
        assert (rdd2.count () === ELEMENTS2)
        assert (rdd3.count () === (ELEMENTS1 + ELEMENTS2))
    }

}
