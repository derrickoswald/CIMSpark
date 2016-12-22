package ch.ninecode

import java.io.File
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths
import java.util.HashMap
import java.util.Map

import org.apache.commons.io.FileUtils
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.SQLContext
import org.apache.spark.storage.StorageLevel
import org.scalatest.fixture
import org.apache.spark.sql.SparkSession


import ch.ninecode.cim._
import ch.ninecode.model._
import org.apache.spark.sql.types.Element

class CIMNetworkTopologyProcessorSuite extends fixture.FunSuite
{
    val FILE_DEPOT = "/home/derrick/Documents/9code/nis/cim/cim_export/"

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
        options.put ("StorageLevel", "MEMORY_AND_DISK_SER");
        options.put ("ch.ninecode.cim.make_edges", "false");
        options.put ("ch.ninecode.cim.do_join", "false");
        options.put ("ch.ninecode.cim.do_topo", "false"); // done explicitly in the test
        options.put ("ch.ninecode.cim.do_topo_islands", "false"); // done explicitly in the test

        val element = context.read.format ("ch.ninecode.cim").options (options).load (files:_*)
        val plan = element.queryExecution
        val test = plan.toString ()
        if (!test.contains ("InputPaths"))
            throw new Exception ("input file not found: " + filename)

        return (element)
    }

    test ("Basic")
    {
        session: SparkSession ⇒

        val start = System.nanoTime ()

        val filename =
            FILE_DEPOT + "NIS_CIM_Export_sias_current_20160816_Kiental_V9" + ".rdf"
        val elements = readFile (session.sqlContext, filename)

        val read = System.nanoTime ()

        // set up for execution
        val topo = new CIMNetworkTopologyProcessor (session.sqlContext, StorageLevel.MEMORY_AND_DISK_SER)
        topo.process (false)

        val process = System.nanoTime ()

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

        val read = System.nanoTime ()

        // set up for execution
        val topo = new CIMNetworkTopologyProcessor (session.sqlContext, StorageLevel.MEMORY_AND_DISK_SER)
        topo.process (true)

        val process = System.nanoTime ()

        println ("read : " + (read - start) / 1e9 + " seconds")
        println ("process: " + (process - read) / 1e9 + " seconds")
        println ()
    }

}
