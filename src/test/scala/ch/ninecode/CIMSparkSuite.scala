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
import org.scalatest.fixture.FunSuite

import ch.ninecode.cim._
import ch.ninecode.model._

class CIMSparkSuite extends FunSuite
{
    val FILE_DEPOT = "data/"
    val PRIVATE_FILE_DEPOT = "private_data/"

    type FixtureParam = SparkSession

    def withFixture (test: OneArgTest): Outcome =
    {
        // create the configuration
        val configuration = new SparkConf (false)
        configuration.setAppName ("CIMSparkSuite")
        configuration.setMaster ("local[2]")
        configuration.set ("spark.driver.memory", "1g")
        configuration.set ("spark.executor.memory", "4g")
        configuration.set ("spark.ui.showConsoleProgress", "false")

        // register low level classes
        configuration.registerKryoClasses (Array (classOf[Element], classOf[BasicElement], classOf[Unknown]))
        // register CIM case classes
        CHIM.apply_to_all_classes { x => configuration.registerKryoClasses (Array (x.runtime_class)) }
        // register edge related classes
        configuration.registerKryoClasses (Array (classOf[PreEdge], classOf[Extremum], classOf[PostEdge]))

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
            FILE_DEPOT + "NIS_CIM_Export_NS_INITIAL_FILL_Oberiberg" + ".rdf"
        val options = new HashMap[String, String] ().asInstanceOf[Map[String,String]]
        options.put ("StorageLevel", "MEMORY_AND_DISK_SER")
        options.put ("ch.ninecode.cim.make_edges", "true")
        options.put ("ch.ninecode.cim.do_topo_islands", "true")
        val elements = readFile (session.sqlContext, filename, options)
        println (elements.count () + " elements")
        val edges = session.sqlContext.sql ("select * from edges")
        val count = edges.count
        markup ("edge count: " + count)
        assert (count === 760)
    }

    test ("Dedup")
    {
        session: SparkSession ⇒

        val filename =
            FILE_DEPOT + "NIS_CIM_Export_NS_INITIAL_FILL_Oberiberg" + ".rdf"
        val options = new HashMap[String, String] ().asInstanceOf[Map[String,String]]
        options.put ("StorageLevel", "MEMORY_AND_DISK_SER")
        options.put ("ch.ninecode.cim.do_deduplication", "true")
        val elements1 = readFile (session.sqlContext, filename, options)
        val count1 = elements1.count ()
        println (count1 + " elements")
        val elements2 = readFile (session.sqlContext, filename + "," + filename, options)
        val count2 = elements2.count ()
        println (count2 + " elements")
        assert (count1 === count2)
    }

    test ("Join")
    {
        session: SparkSession ⇒

        val filename =
            PRIVATE_FILE_DEPOT + "NIS_CIM_Export_sias_current_20161220_Bubenei_V11_assets_preview" + ".rdf" +
            "," +
            PRIVATE_FILE_DEPOT + "ISU_CIM_Export_20160505" + ".rdf"
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

        val join = new CIMJoin (session, StorageLevel.fromString ("MEMORY_AND_DISK_SER"))
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
            PRIVATE_FILE_DEPOT + "NIS_CIM_Export_sias_current_20161220_Bubenei_V11_assets_preview" + ".rdf" +
            "," +
            PRIVATE_FILE_DEPOT + "ISU_CIM_Export_20160505" + ".rdf"
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
