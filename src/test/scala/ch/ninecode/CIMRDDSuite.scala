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

    def withFixture (test: OneArgTest): org.scalatest.Outcome =
    {
        // create the fixture
        val configuration = new SparkConf ()
        configuration.setAppName ("CIMSuite")
        configuration.setMaster ("local[2]")
        val context = new SparkContext (configuration)
        context.setLogLevel ("ALL") // Valid log levels include: ALL, DEBUG, ERROR, FATAL, INFO, OFF, TRACE, WARN
        try
        {
            withFixture (test.toNoArgTest (context)) // "loan" the fixture to the test
        }
        finally context.stop () // clean up the fixture
    }

//    test ("Create")
//    {
//        sc ⇒
//        val xml = "yadda yadda <cim:PSRType rdf:ID=\"PSRType_Substation\">\n<cim:IdentifiedObject.name>Substation</cim:IdentifiedObject.name>\n</cim:PSRType> foo bar"
//        val parser = new CIM (xml.toString ())
//        val map = parser.parse ()
//        assert (map.size === 1)
//        val rdd = sc.parallelize (map.toSeq, 2)
//        assert (rdd.count () === 1)
//    }

//    test ("Read")
//    {
//        sc ⇒
//        val rdd = CIMRDD.rddFile (sc, "data/dump_all.xml", 0, 0)
//        assert (rdd.count () === 203046 /* Elements */ + 67137 /* PositionPoints */)
//    }

    test ("Hadoop")
    {
        sc ⇒
        val rdd = CIMRDD.rddHadoop (sc, "data/dump_all.xml")
        val unknowns = rdd.collect ({ case x: Any if x.getClass () == classOf[Unknown] => x.asInstanceOf[Unknown] })
        if (unknowns.count () != 0)
            fail (unknowns.first ().guts)
        assert (rdd.count () === 203046 /* Elements */ + 67137 /* PositionPoints */)

    }
}
