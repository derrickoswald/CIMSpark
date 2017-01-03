package ch.ninecode

import java.util.HashMap
import java.util.Map

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.SparkSession
import org.apache.spark.storage.StorageLevel

import org.scalatest.Outcome
import org.scalatest.fixture

import ch.ninecode.cim._
import ch.ninecode.model._

class CIMSparkSuite extends fixture.FunSuite
{
    val FILE_DEPOT = "data/"

    type FixtureParam = SparkSession

    def withFixture (test: OneArgTest): Outcome =
    {
        // create the configuration
        val configuration = new SparkConf (false)
        configuration.setAppName ("CIMSparkSuite")
        configuration.setMaster ("local[2]")
        configuration.set ("spark.driver.memory", "1g")
        configuration.set ("spark.executor.memory", "4g")

        // register low level classes
        configuration.registerKryoClasses (Array (classOf[Element], classOf[BasicElement], classOf[Unknown]))
        // register CIM case classes
        CHIM.apply_to_all_classes { x => configuration.registerKryoClasses (Array (x.runtime_class)) }
        // register edge related classes
        configuration.registerKryoClasses (Array (classOf[PreEdge], classOf[Extremum], classOf[Edge]))

        val session = SparkSession.builder ().config (configuration).getOrCreate () // create the fixture
        session.sparkContext.setLogLevel ("OFF") // Valid log levels include: ALL, DEBUG, ERROR, FATAL, INFO, OFF, TRACE, WARN
        try
            withFixture (test.toNoArgTest (session)) // "loan" the fixture to the test
        finally session.stop() // clean up the fixture
    }

    def readFile (context: SQLContext, filename: String, options: Map[String, String]): DataFrame =
    {
        options.put ("path", filename)
        val files = filename.split (",")
        val element = context.read.format ("ch.ninecode.cim").options (options).load (files:_*)

        return (element)
    }

    def get (sql_context: SQLContext, name: String): RDD[Element] =
    {
        val rdds = sql_context.sparkContext.getPersistentRDDs
        for (key <- rdds.keys)
        {
            val rdd = rdds (key)
            if (rdd.name == name)
                return (rdd.asInstanceOf[RDD[Element]])
        }
        return (null)
    }

    test ("Basic")
    {
        session: SparkSession ⇒

        val filename =
            FILE_DEPOT + "NIS_CIM_Export_sias_current_20160816_Brügg_V9" + ".rdf" +
            "," +
            FILE_DEPOT + "ISU_CIM_Export_20160505_partial" + ".rdf"
        val options = new HashMap[String, String] ().asInstanceOf[Map[String,String]]
        options.put ("StorageLevel", "MEMORY_AND_DISK_SER")
        options.put ("ch.ninecode.cim.make_edges", "true")
        val elements = readFile (session.sqlContext, filename, options)
        println (elements.count())
        val edges = session.sqlContext.sql ("select * from edges")
        val head = edges.head (5)
        if (0 != head.length)
            println (head (0))
    }

    test ("Join")
    {
        session: SparkSession ⇒

        val filename =
            FILE_DEPOT + "NIS_CIM_Export_sias_current_20160816_Bubenei_V9" + ".rdf" +
            "," +
            FILE_DEPOT + "ISU_CIM_Export_20160505" + ".rdf"
        val options = new HashMap[String, String] ().asInstanceOf[Map[String,String]]
        options.put ("StorageLevel", "MEMORY_AND_DISK_SER")
        val elements = readFile (session.sqlContext, filename, options)
        println (elements.count () + " elements")

        var servicelocations = get (session.sqlContext, "ServiceLocation").asInstanceOf[RDD[ServiceLocation]]
        println (servicelocations.count () + " servicelocations before")

        var positions = get (session.sqlContext, "PositionPoint").asInstanceOf[RDD[PositionPoint]]
        println (positions.count () + " positions before")

        var users = get (session.sqlContext, "UserAttribute").asInstanceOf[RDD[UserAttribute]]
        println (users.count () + " user attributes before")

        var names = get (session.sqlContext, "Name").asInstanceOf[RDD[UserAttribute]]
        println (names.count () + " names before")

        val join = new CIMJoin (session.sqlContext, StorageLevel.fromString ("MEMORY_AND_DISK_SER"))
        join.do_join ()

        servicelocations = get (session.sqlContext, "ServiceLocation").asInstanceOf[RDD[ServiceLocation]]
        println (servicelocations.count () + " servicelocations after")

        positions = get (session.sqlContext, "PositionPoint").asInstanceOf[RDD[PositionPoint]]
        println (positions.count () + " positions after")

        users = get (session.sqlContext, "UserAttribute").asInstanceOf[RDD[UserAttribute]]
        println (users.count () + " user attributes after")

        names = get (session.sqlContext, "Name").asInstanceOf[RDD[UserAttribute]]
        val count = names.count ()
        println (count + " names after")
        if (0 != count)
            println (names.first)
    }

    test ("Auto-join")
    {
        session: SparkSession ⇒

        val filename =
            FILE_DEPOT + "NIS_CIM_Export_sias_current_20160816_Bubenei_V9" + ".rdf" +
            "," +
            FILE_DEPOT + "ISU_CIM_Export_20160505" + ".rdf"
        val options = new HashMap[String, String] ().asInstanceOf[Map[String,String]]
        options.put ("StorageLevel", "MEMORY_AND_DISK_SER")
        options.put ("ch.ninecode.cim.do_join", "true")
        val elements = readFile (session.sqlContext, filename, options)
        println (elements.count () + " elements")
        val servicelocations = get (session.sqlContext, "ServiceLocation").asInstanceOf[RDD[ServiceLocation]]
        println (servicelocations.count () + " servicelocations after")

        val positions = get (session.sqlContext, "PositionPoint").asInstanceOf[RDD[PositionPoint]]
        println (positions.count () + " positions after")

        val users = get (session.sqlContext, "UserAttribute").asInstanceOf[RDD[UserAttribute]]
        println (users.count () + " user attributes after")

        val names = get (session.sqlContext, "Name").asInstanceOf[RDD[UserAttribute]]
        val count = names.count ()
        println (count + " names after")
        if (0 != count)
            println (names.first)
    }

}
