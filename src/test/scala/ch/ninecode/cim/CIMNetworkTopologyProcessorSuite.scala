package ch.ninecode.cim

import java.util.HashMap
import java.util.Map

import org.apache.spark.SparkConf
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.SparkSession
import org.apache.spark.storage.StorageLevel
import org.scalatest.fixture.FunSuite

import ch.ninecode.model._

class CIMNetworkTopologyProcessorSuite extends ch.ninecode.SparkSuite
{
    val PRIVATE_FILE_DEPOT = "private_data/"

    test ("Basic")
    {
        implicit session: SparkSession ⇒

        val start = System.nanoTime ()

        val filename =
            PRIVATE_FILE_DEPOT + "NIS_CIM_Export_sias_current_20161220_Kiental im Oberland_V11_assets_preview" + ".rdf"
        val elements = readFile (filename)
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
        implicit session: SparkSession ⇒

        val start = System.nanoTime ()

        val filename =
            PRIVATE_FILE_DEPOT + "NIS_CIM_Export_sias_current_20161220_Bubenei_V11_assets_preview" + ".rdf"
        val elements = readFile (filename)
        println (elements.count () + " elements")
        val read = System.nanoTime ()

        // set up for execution
        val topo = new CIMNetworkTopologyProcessor (session, StorageLevel.MEMORY_AND_DISK_SER)
        topo.process (true)

        val process = System.nanoTime ()

        val islands = session.sparkContext.getPersistentRDDs.filter(_._2.name == "TopologicalIsland").head._2.asInstanceOf[org.apache.spark.rdd.RDD[TopologicalIsland]]
        println (islands.take (10).mkString ("\n"))

        println ("process: " + (process - read) / 1e9 + " seconds")
    }

    test ("Auto")
    {
        implicit session: SparkSession ⇒

        def readFileAuto (context: SQLContext, filename: String): DataFrame =
        {
            val files = filename.split (",")
            val options = new HashMap[String, String] ().asInstanceOf[Map[String,String]]
            options.put ("ch.ninecode.cim.do_topo_islands", "true")
            readFile (filename, options)
        }

        val start = System.nanoTime ()

        val filename =
            PRIVATE_FILE_DEPOT + "NIS_CIM_Export_sias_current_20161220_Bubenei_V11_assets_preview" + ".rdf"
        val elements = readFileAuto (session.sqlContext, filename)
        println (elements.count () + " elements")
        val read = System.nanoTime ()

        val nodes = session.sparkContext.getPersistentRDDs.filter(_._2.name == "ConnectivityNode").head._2.asInstanceOf[org.apache.spark.rdd.RDD[ConnectivityNode]]
        println (nodes.take (10).mkString ("\n"))

        println ("read : " + (read - start) / 1e9 + " seconds")
        println ()
    }

}
