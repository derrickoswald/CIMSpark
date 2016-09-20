package ch.ninecode

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.annotation.DeveloperApi
import org.apache.spark.annotation.Experimental
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.types.SQLUserDefinedType
import org.apache.spark.storage.StorageLevel

import org.scalatest.fixture

import ch.ninecode.cim._
import ch.ninecode.model._

class CIMSparkSuite extends fixture.FunSuite
{
    case class ContextPair (_SparkContext: SparkContext, _SQLContext: SQLContext)

    val FILE_DEPOT = "/home/derrick/Documents/9code/nis/cim/cim_export/"

    type FixtureParam = ContextPair

    def withFixture (test: OneArgTest): org.scalatest.Outcome =
    {
        // create the fixture

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

        val context = new SparkContext (configuration)
        context.setLogLevel ("OFF") // Valid log levels include: ALL, DEBUG, ERROR, FATAL, INFO, OFF, TRACE, WARN
        val sql_context = new SQLContext (context)
        try
        {
            withFixture (test.toNoArgTest (ContextPair (context, sql_context))) // "loan" the fixture to the test
        }
        finally context.stop () // clean up the fixture
    }

    def readFile (context: SQLContext, filename: String): DataFrame =
    {
        val files = filename.split (",")
        val element = context.read.format ("ch.ninecode.cim").option ("StorageLevel", "MEMORY_AND_DISK_SER").load (files:_*)
        val plan = element.queryExecution
        val test = plan.toString ()
        if (!test.contains ("InputPaths"))
            throw new Exception ("input file not found: " + filename)

        return (element)
    }

    test ("Basic")
    {
        a: ContextPair ⇒

        val context: SparkContext = a._SparkContext
        val sql_context: SQLContext = a._SQLContext

        val filename =
            FILE_DEPOT + "NIS_CIM_Export_sias_current_20160816_V8_Bruegg" + ".rdf" +
            "," +
            FILE_DEPOT + "ISU_CIM_Export_20160505_partial" + ".rdf"
        val elements = readFile (sql_context, filename)
        println (elements.count())
        val edges = sql_context.sql ("select * from edges")
        val head = edges.head (5)
        if (0 != head.length)
            println (head (0))
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

    test ("Join")
    {
        a: ContextPair ⇒

        val context: SparkContext = a._SparkContext
        val sql_context: SQLContext = a._SQLContext

        val filename =
            FILE_DEPOT + "NIS_CIM_Export_b4_Bruegg" + ".rdf" + // NIS_CIM_Export_b4_Bubenei
            "," +
            FILE_DEPOT + "ISU_CIM_Export_20160505" + ".rdf"
        val elements = readFile (sql_context, filename)
        println (elements.count () + " elements")

        var servicelocations = get (sql_context, "ServiceLocation").asInstanceOf[RDD[ServiceLocation]]
        println (servicelocations.count () + " servicelocations before")

        var positions = get (sql_context, "PositionPoint").asInstanceOf[RDD[PositionPoint]]
        println (positions.count () + " positions before")

        var users = get (sql_context, "UserAttribute").asInstanceOf[RDD[UserAttribute]]
        println (users.count () + " user attributes before")

        var names = get (sql_context, "Name").asInstanceOf[RDD[UserAttribute]]
        println (names.count () + " names before")

        val join = new CIMJoin (sql_context, StorageLevel.fromString ("MEMORY_AND_DISK_SER"))
        join.do_join ()

        servicelocations = get (sql_context, "ServiceLocation").asInstanceOf[RDD[ServiceLocation]]
        println (servicelocations.count () + " servicelocations after")

        positions = get (sql_context, "PositionPoint").asInstanceOf[RDD[PositionPoint]]
        println (positions.count () + " positions after")

        users = get (sql_context, "UserAttribute").asInstanceOf[RDD[UserAttribute]]
        println (users.count () + " user attributes after")

        names = get (sql_context, "Name").asInstanceOf[RDD[UserAttribute]]
        val count = names.count ()
        println (count + " names after")
        if (0 != count)
            println (names.first)
    }
}
