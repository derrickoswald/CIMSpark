package ch.ninecode.cim

import java.util

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.SparkSession
import org.apache.spark.storage.StorageLevel

import ch.ninecode.model.ConnectivityNode
import ch.ninecode.model.TopologicalIsland
import ch.ninecode.model.TopologicalNode

class CIMNetworkTopologyProcessorSuite extends ch.ninecode.SparkSuite
{
    val PRIVATE_FILE_DEPOT = "private_data/"

    test ("Basic")
    {
        implicit session: SparkSession ⇒

        val start = System.nanoTime ()

        val filename =
            PRIVATE_FILE_DEPOT + "NIS_CIM_Export_sias_current_20161220_Kiental im Oberland_V11_assets_preview.rdf"
        val elements = readFile (filename)
        println (elements.count () + " elements")
        val read = System.nanoTime ()

            // set up for execution
        val topo = new CIMNetworkTopologyProcessor (session, StorageLevel.MEMORY_AND_DISK_SER, true, true)
        val new_elements = topo.process (false)
        println (new_elements.count () + " new elements")

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
        val topo = new CIMNetworkTopologyProcessor (session, StorageLevel.MEMORY_AND_DISK_SER, true, true)
        val new_elements = topo.process (true)
        println (new_elements.count () + " new elements")

        val process = System.nanoTime ()

        val islands = session.sparkContext.getPersistentRDDs.filter(_._2.name == "TopologicalIsland").head._2.asInstanceOf[org.apache.spark.rdd.RDD[TopologicalIsland]]
        println (islands.take (10).mkString ("\n"))

        println ("read : " + (read - start) / 1e9 + " seconds")
        println ("process: " + (process - read) / 1e9 + " seconds")
    }

    test ("Auto")
    {
        implicit session: SparkSession ⇒

        def readFileAuto (context: SQLContext, filename: String): DataFrame =
        {
            val options = new util.HashMap[String, String] ().asInstanceOf[util.Map[String,String]]
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
