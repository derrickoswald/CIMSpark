package ch.ninecode.cim

import java.io.File
import java.util

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.SparkSession
import org.apache.spark.storage.StorageLevel

import ch.ninecode.model.TopologicalIsland
import ch.ninecode.model.TopologicalNode

class CIMNetworkTopologyProcessorSuite extends ch.ninecode.SparkSuite
{
    val FILE_DEPOT = "data/"

    override def run (testName: Option[String], args: org.scalatest.Args): org.scalatest.Status =
    {
        // unpack the zip file
        new Unzip ().unzip (FILE_DEPOT + "DemoData.zip", FILE_DEPOT)
        // run the tests
        val ret  = super.run (testName, args)
        // erase the unpacked files
        deleteRecursive (new File (FILE_DEPOT + "DemoData.rdf"))
        ret
    }

    test ("Basic")
    {
        implicit session: SparkSession ⇒

            val start = System.nanoTime ()

            val filename = FILE_DEPOT + "DemoData.rdf"
            val elements = readFile (filename)
            assert (elements.count == 1740, "# elements before")

            val read = System.nanoTime ()

            // set up for execution
            val topo = new CIMNetworkTopologyProcessor (session, StorageLevel.MEMORY_AND_DISK_SER, true, true, true)
            val new_elements = topo.process (false)

            val process = System.nanoTime ()

            assert (new_elements.count == 1891, "# elements after")
            val nodes = get[TopologicalNode]
            assert (nodes != null, "no TopologicalNode RDD")
            assert (nodes.count == 151, "# nodes")

            info ("read: %s seconds, process: %s seconds".format ((read - start) / 1e9, (process - read) / 1e9))
    }

    test ("Islands")
    {
        implicit session: SparkSession ⇒

            val start = System.nanoTime ()

            val filename = FILE_DEPOT + "DemoData.rdf"
            val elements = readFile (filename)
            assert (elements.count == 1740, "# elements before")

            val read = System.nanoTime ()

            // set up for execution
            val topo = new CIMNetworkTopologyProcessor (session, StorageLevel.MEMORY_AND_DISK_SER, true, true, true)
            val new_elements = topo.process (true)

            val process = System.nanoTime ()

            assert (new_elements.count == 1993, "# elements after")
            val islands = get[TopologicalIsland]
            assert (islands != null, "no TopologicalIsland RDD")
            assert (islands.count == 102, "# islands")
            val nodes = get[TopologicalNode]
            assert (nodes != null, "no TopologicalNode RDD")
            assert (nodes.count == 151, "# nodes")

            info ("read: %s seconds, process: %s seconds".format ((read - start) / 1e9, (process - read) / 1e9))
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

            val filename = FILE_DEPOT + "DemoData.rdf"
            val elements= readFileAuto (session.sqlContext, filename)
            assert (elements.count == 1813, "# elements")

            val read = System.nanoTime ()

            val islands = get[TopologicalIsland]
            assert (null != islands, "no TopologicalIsland RDD")
            assert (islands.count == 13, "# islands")
            val nodes = get[TopologicalNode]
            assert (null != nodes, "no TopologicalNode RDD")
            assert (nodes.count == 60, "# nodes")

            info ("read and process: %s seconds".format ((read - start) / 1e9))
        }
}
