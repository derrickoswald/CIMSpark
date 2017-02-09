package ch.ninecode

import java.util.HashMap
import java.util.Map

import org.apache.spark.SparkConf
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.SparkSession
import org.apache.spark.storage.StorageLevel
import org.scalatest.fixture.FunSuite

import ch.ninecode.cim._
import ch.ninecode.model._

class CIMNetworkTopologyProcessorSuite extends FunSuite
{
    val FILE_DEPOT = "data/"

    type FixtureParam = SparkSession

    def withFixture (test: OneArgTest): org.scalatest.Outcome =
    {
        // create the fixture
        val start = System.nanoTime ()

        // create the configuration
        val configuration = new SparkConf (false)
        configuration.setAppName ("GridLABDSuite")
        configuration.setMaster ("local[2]")
        configuration.set ("spark.driver.memory", "1g")
        configuration.set ("spark.executor.memory", "4g")

        // register low level classes
        configuration.registerKryoClasses (Array (classOf[Element], classOf[BasicElement], classOf[Unknown]))
        // register CIM case classes
        CHIM.apply_to_all_classes { x => configuration.registerKryoClasses (Array (x.runtime_class)) }
        // register topological classes
        configuration.registerKryoClasses (Array (classOf[CuttingEdge], classOf[TopologicalData]))

        val end = System.nanoTime ()
        println ("setup : " + (end - start) / 1e9 + " seconds")
        val session = SparkSession.builder ().config (configuration).getOrCreate () // create the fixture
        session.sparkContext.setLogLevel ("OFF") // Valid log levels include: ALL, DEBUG, ERROR, FATAL, INFO, OFF, TRACE, WARN
        try
            withFixture (test.toNoArgTest (session)) // "loan" the fixture to the test
        finally session.stop() // clean up the fixture
    }

    def readFile (context: SQLContext, filename: String): DataFrame =
    {
        val files = filename.split (",")
        val options = new HashMap[String, String] ().asInstanceOf[Map[String,String]]
        options.put ("path", filename)
        options.put ("StorageLevel", "MEMORY_AND_DISK_SER")
        options.put ("ch.ninecode.cim.make_edges", "false")
        options.put ("ch.ninecode.cim.do_join", "false")
        options.put ("ch.ninecode.cim.do_topo", "false") // done explicitly in the test
        options.put ("ch.ninecode.cim.do_topo_islands", "false") // done explicitly in the test

        val element = context.read.format ("ch.ninecode.cim").options (options).load (files:_*)

        return (element)
    }

    test ("Basic")
    {
        session: SparkSession ⇒

        val start = System.nanoTime ()

        val filename =
            FILE_DEPOT + "NIS_CIM_Export_sias_current_20160816_Kiental_V9" + ".rdf"
        val elements = readFile (session.sqlContext, filename)
        println (elements.count () + " elements")
        val read = System.nanoTime ()

        // set up for execution
        val topo = new CIMNetworkTopologyProcessor (session, StorageLevel.MEMORY_AND_DISK_SER)
        topo.process (false)

        val process = System.nanoTime ()

        val topos = session.sparkContext.getPersistentRDDs.filter(_._2.name == "TopologicalNode").head._2.asInstanceOf[org.apache.spark.rdd.RDD[TopologicalNode]]
        println (topos.take (10).mkString ("\n"))

        println ("read : " + (read - start) / 1e9 + " seconds")
        println ("process: " + (process - read) / 1e9 + " seconds")
        println ()
    }

    test ("Islands")
    {
        session: SparkSession ⇒

        val start = System.nanoTime ()

        val filename =
            FILE_DEPOT + "NIS_CIM_Export_sias_current_20160816_Bubenei_V9" + ".rdf"
        val elements = readFile (session.sqlContext, filename)
        println (elements.count () + " elements")
        val read = System.nanoTime ()

        // set up for execution
        val topo = new CIMNetworkTopologyProcessor (session, StorageLevel.MEMORY_AND_DISK_SER)
        topo.process (true)

        val process = System.nanoTime ()

        val islands = session.sparkContext.getPersistentRDDs.filter(_._2.name == "TopologicalIsland").head._2.asInstanceOf[org.apache.spark.rdd.RDD[TopologicalIsland]]
        println (islands.take (10).mkString ("\n"))

        println ("read : " + (read - start) / 1e9 + " seconds")
        println ("process: " + (process - read) / 1e9 + " seconds")
        println ()
    }

    test ("Auto")
    {
        session: SparkSession ⇒

        def readFileAuto (context: SQLContext, filename: String): DataFrame =
        {
            val files = filename.split (",")
            val options = new HashMap[String, String] ().asInstanceOf[Map[String,String]]
            options.put ("path", filename)
            options.put ("StorageLevel", "MEMORY_AND_DISK_SER")
            options.put ("ch.ninecode.cim.make_edges", "false")
            options.put ("ch.ninecode.cim.do_join", "false")
            options.put ("ch.ninecode.cim.do_topo", "true")
            options.put ("ch.ninecode.cim.do_topo_islands", "true")

            val element = context.read.format ("ch.ninecode.cim").options (options).load (files:_*)

            return (element)
        }

        val start = System.nanoTime ()

        val filename =
            FILE_DEPOT + "NIS_CIM_Export_sias_current_20160816_Bubenei_V9" + ".rdf"
        val elements = readFileAuto (session.sqlContext, filename)
        println (elements.count () + " elements")
        val read = System.nanoTime ()

        val nodes = session.sparkContext.getPersistentRDDs.filter(_._2.name == "ConnectivityNode").head._2.asInstanceOf[org.apache.spark.rdd.RDD[ConnectivityNode]]
        println (nodes.take (10).mkString ("\n"))

        println ("read : " + (read - start) / 1e9 + " seconds")
        println ()
    }

}
