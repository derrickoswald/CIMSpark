package ch.ninecode

import scala.xml._

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

import org.junit.runner.RunWith
import org.scalatest.fixture
import org.scalatest.junit.JUnitRunner
import org.scalatest.Outcome

class CIMRDDSuite extends fixture.FunSuite
{
    type FixtureParam = SparkContext

    // test file name
    val FILENAME = "data/NIS_CIM_Export_NS_INITIAL_FILL_Oberiberg.rdf"

    // number of elements in the file
    // get number of lines at the top level with:
    // grep -P "^[\t]<cim" NIS_CIM_Export_NS_INITIAL_FILL_Oberiberg.rdf | wc
    val ELEMENTS = 14501

    // number of elements in a 1MB chunk
    // this is approximately (off by +one)
    // tail --bytes=+3145728 NIS_CIM_Export_NS_INITIAL_FILL_Oberiberg.rdf | head --bytes=1048576 | grep -P "^[\t]<cim" | wc
    val OFFSET = 3145728
    val PARTIAL_MAP_SIZE = 2548

    def withFixture (test: OneArgTest): org.scalatest.Outcome =
    {
        // create the fixture
        val configuration = new SparkConf ()
        configuration.setAppName ("CIMSuite")
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
        val parser = new CIM (xml.toString ())
        val map = parser.parse ()
        assert (map.size === 1)
        val rdd = sc.parallelize (map.toSeq, 2)
        assert (rdd.count () === 1)
    }

    test ("Read")
    {
        sc ⇒
        val rdd = CIMRDD.rddFile (sc, FILENAME, 0, 0)
        assert (rdd.count () === ELEMENTS) // 203046 /* Elements */ + 67137 /* PositionPoints */)
    }

    test ("Read Partial")
    {
        sc ⇒
        val xml = CIM.read (FILENAME, OFFSET, 1024 * 1024, 0) // exactly a megabyte
        val parser = new CIM (xml)
        val map = parser.parse ()
        assert (map.size == PARTIAL_MAP_SIZE)
        assert (map.filter (_.getClass() == classOf[Unknown]).size == 0)
    }

    test ("Merge Partial")
    {
        sc ⇒
        val xml1 = CIMRDD.read (FILENAME, 0, OFFSET + CIM.OVERREAD)
        val xml2 = CIMRDD.read (FILENAME, OFFSET, 1024*1024 + CIM.OVERREAD)
        val xml3 = CIMRDD.read (FILENAME, OFFSET + 1024*1024, 1024*1024)
        markup ("xml1 " + xml1.substring (0, 60))
        markup ("xml2 " + xml2.substring (0, 60))
        markup ("xml3 " + xml3.substring (0, 60))
        val parser1 = new CIM (xml1, 0, OFFSET)
        val parser2 = new CIM (xml2, OFFSET, OFFSET + 1024*1024)
        val parser3 = new CIM (xml3, OFFSET + 1024*1024, OFFSET + 2*1024*1024)
        val map1 = parser1.parse ()
        val map2 = parser2.parse ()
        val map3 = parser3.parse ()
        markup ("map1 has " + map1.size + " elements")
        markup ("map2 has " + map2.size + " elements")
        markup ("map3 has " + map3.size + " elements")
        val rdd1 = sc.parallelize (map1.values.toSeq)
        val rdd2 = sc.parallelize (map2.values.toSeq)
        val rdd3 = sc.parallelize (map3.values.toSeq)
        val int1 = rdd1.intersection (rdd2)
        val int2 = rdd1.intersection (rdd3)
        val int3 = rdd2.intersection (rdd3)
        if (int1.count () != 0)
        {
            val i1 = int1.collect ()
            markup ("There were non-zero intersections between rdd1 and rdd2 (" + i1.length + ") like:")
            for (i <- 0 until i1.length)
                markup (i1 (i).key)
        }
        if (int2.count () != 0)
        {
            val i2 = int2.collect ()
            markup ("There were non-zero intersections between rdd1 and rdd3 (" + i2.length + ") like:")
            for (i <- 0 until i2.length)
                markup (i2 (i).key)
        }
        if (int3.count () != 0)
        {
            val i3 = int3.collect ()
            markup ("There were non-zero intersections between rdd2 and rdd3 (" + i3.length + ") like:")
            for (i <- 0 until i3.length)
                markup (i3 (i).key)
        }
        assert (int1.count () == 0)
        assert (int2.count () == 0)
        assert (int3.count () == 0)
    }

    test ("Hadoop")
    {
        sc ⇒
        val rdd = CIMRDD.rddHadoop (sc, FILENAME)
        val unknowns = rdd.collect ({ case x: Any if x.getClass () == classOf[Unknown] => x.asInstanceOf[Unknown] })
        if (unknowns.count () != 0)
        {
            val u = unknowns.first ()
            markup ("There were non-zero unknowns (" + unknowns.count () + ") like @line " + u.line + " when parsing text starting at " + u.start + " and last parse ending at " + u.end + " with internal text '" + u.guts + "'")
        }
        assert (rdd.count () === ELEMENTS) // 203046 /* Elements */ + 67137 /* PositionPoints */)
    }

//    test ("Greedy")
//    {
//        sc ⇒
//        val chunk = 134217728L
//        val xml1 = CIMRDD.read ("data/dump_bkw.xml", 2952790016L, chunk + CIM.OVERREAD)
//        val xml2 = CIMRDD.read ("data/dump_bkw.xml", 2550136832L, chunk + CIM.OVERREAD)
//        markup ("xml1 " + xml1.substring (0, 60))
//        markup ("xml2 " + xml2.substring (0, 60))
//        val length = 134217728L
//        val parser1 = new CIM (xml1, 2952790016L, 2952790016L + length) // 3087007744L
//        val parser2 = new CIM (xml2, 2550136832L, 2550136832L + length) // 2684354560L
//
//        var s = System.nanoTime
//        val map1 = parser1.parse ()
//        var e = System.nanoTime
//        markup ("xml1 time: " + (e - s) / 1e6 + "ms")
//
//        s = System.nanoTime
//        val map2 = parser2.parse ()
//        e = System.nanoTime
//        markup ("xml2 time: " + (e - s) / 1e6 + "ms")
//
//        markup ("map1 has " + map1.size + " elements")
//        markup ("map2 has " + map2.size + " elements")
//    }
//
//    test ("Greedy2")
//    {
//        sc ⇒
//        val chunk = 134217728L
//        val xml1 = CIMRDD.read ("data/dump_bkw.xml",  402653184L, chunk + CIM.OVERREAD)
//        val xml2 = CIMRDD.read ("data/dump_bkw.xml", 1610612736L, chunk + CIM.OVERREAD)
//        markup ("xml1 " + xml1.substring (0, 60))
//        markup ("xml2 " + xml2.substring (0, 60))
//        val length = 134217728L
//        val parser1 = new CIM (xml1,  402653184L,  402653184L + length)
//        val parser2 = new CIM (xml2, 1610612736L, 1610612736L + length)
//
//        var s = System.nanoTime
//        val map1 = parser1.parse ()
//        var e = System.nanoTime
//        markup ("xml1 time: " + (e - s) / 1e6 + "ms")
//
//        s = System.nanoTime
//        val map2 = parser2.parse ()
//        e = System.nanoTime
//        markup ("xml2 time: " + (e - s) / 1e6 + "ms")
//
//        markup ("map1 has " + map1.size + " elements")
//        markup ("map2 has " + map2.size + " elements")
//    }
}
