package ch.ninecode.cim

import java.io.File

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.SparkSession
import org.apache.spark.storage.StorageLevel

import ch.ninecode.model.Terminal
import ch.ninecode.model.TopologicalIsland
import ch.ninecode.model.TopologicalNode

class CIMNetworkTopologyProcessorSuite extends ch.ninecode.SparkSuite
{
    val FILE_DEPOT = "data/"

    override def run (testName: Option[String], args: org.scalatest.Args): org.scalatest.Status =
    {
        // unpack the zip files
        new Unzip ().unzip (s"${FILE_DEPOT}DemoData.zip", FILE_DEPOT)
        new Unzip ().unzip (s"${FILE_DEPOT}DemoData_unknown_voltage.zip", FILE_DEPOT)

        // run the tests
        val ret  = super.run (testName, args)

        // erase the unpacked files
        deleteRecursive (new File (s"${FILE_DEPOT}DemoData.rdf"))
        deleteRecursive (new File (s"${FILE_DEPOT}DemoData_unknown_voltage.rdf"))
        ret
    }

    test ("Basic")
    {
        implicit session: SparkSession =>

            val start = System.nanoTime ()

            val filename = s"${FILE_DEPOT}DemoData.rdf"
            val elements = readFile (filename)
            assert (elements.count == 1738, "# elements before")

            val read = System.nanoTime ()

            // set up for execution
            val topo = CIMNetworkTopologyProcessor (session)
            val new_elements = topo.process (
                CIMTopologyOptions (
                    identify_islands = true,
                    force_retain_switches = ForceTrue,
                    force_retain_fuses = ForceTrue,
                    debug = true,
                    storage = StorageLevel.MEMORY_AND_DISK_SER))

            val process = System.nanoTime ()

            assert (new_elements.count == 1893, "# elements after")
            val nodes = get[TopologicalNode]
            assert (nodes != null, "no TopologicalNode RDD")
            assert (nodes.count == 151, "# nodes")

            info ("read: %s seconds, process: %s seconds".format ((read - start) / 1e9, (process - read) / 1e9))
    }

    test ("TopologicalNode")
    {
        implicit session: SparkSession =>

            val start = System.nanoTime ()

            val filename = s"${FILE_DEPOT}DemoData_unknown_voltage.rdf"
            val elements = readFile (filename)
            assert (elements.count == 1742, "# elements before")

            val read = System.nanoTime ()

            // set up for execution
            val topo = CIMNetworkTopologyProcessor (session)
            val new_elements = topo.process (
                CIMTopologyOptions (
                    identify_islands = false,
                    force_retain_switches = ForceTrue,
                    force_retain_fuses = ForceTrue,
                    debug = true,
                    storage = StorageLevel.MEMORY_AND_DISK_SER))

            val process = System.nanoTime ()

            assert (new_elements.count == 1894, "# elements after")
            val nodes = get[TopologicalNode]
            assert (nodes != null, "no TopologicalNode RDD")
            assert (nodes.count == 152, "# nodes")
            assert (nodes.filter (_.TopologicalIsland == null).isEmpty, "null islands")

            info ("read: %s seconds, process: %s seconds".format ((read - start) / 1e9, (process - read) / 1e9))
    }

    test ("Islands")
    {
        implicit session: SparkSession =>

            val start = System.nanoTime ()

            val filename = s"${FILE_DEPOT}DemoData.rdf"
            val elements = readFile (filename)
            assert (elements.count == 1738, "# elements before")

            val read = System.nanoTime ()

            // set up for execution
            val topo = CIMNetworkTopologyProcessor (session)
            val new_elements = topo.process (
                CIMTopologyOptions (
                    identify_islands = true,
                    force_retain_switches = ForceTrue,
                    force_retain_fuses = ForceTrue,
                    debug = true,
                    storage = StorageLevel.MEMORY_AND_DISK_SER))

            val process = System.nanoTime ()

            assert (new_elements.count == 1893, "# elements after")
            val islands = get[TopologicalIsland]
            assert (islands != null, "no TopologicalIsland RDD")
            assert (islands.count == 4, "# islands")
            val nodes = get[TopologicalNode]
            assert (nodes != null, "no TopologicalNode RDD")
            assert (nodes.count == 151, "# nodes")

            info ("read: %s seconds, process: %s seconds".format ((read - start) / 1e9, (process - read) / 1e9))
    }

    test ("TopologicalIsland")
    {
        implicit session: SparkSession =>

            val start = System.nanoTime ()

            val filename = s"${FILE_DEPOT}DemoData_unknown_voltage.rdf"
            val elements = readFile (filename)
            assert (elements.count == 1742, "# elements before")

            val read = System.nanoTime ()

            // set up for execution
            val topo = CIMNetworkTopologyProcessor (session)
            val new_elements = topo.process (
                CIMTopologyOptions (
                    identify_islands = true,
                    force_retain_switches = ForceTrue,
                    force_retain_fuses = ForceTrue,
                    debug = true,
                    storage = StorageLevel.MEMORY_AND_DISK_SER))

            val process = System.nanoTime ()

            assert (new_elements.count == 1899, "# elements after")
            val terminals = get[Terminal]
            assert (terminals.filter (_.TopologicalNode == null).isEmpty, "null nodes")
            val nodes = get[TopologicalNode]
            assert (nodes != null, "no TopologicalNode RDD")
            assert (nodes.count == 152, "# nodes")
            assert (nodes.filter (_.TopologicalIsland == null).isEmpty, "null islands")

            info ("read: %s seconds, process: %s seconds".format ((read - start) / 1e9, (process - read) / 1e9))
    }

    test ("Auto")
    {
        implicit session: SparkSession =>

            def readFileAuto (filename: String): DataFrame =
            {
                val options = Map[String, String] (
                    "ch.ninecode.cim.do_topo_islands" -> "true")
                readFile (filename, options)
            }

            val start = System.nanoTime ()

            val filename = s"${FILE_DEPOT}DemoData.rdf"
            val elements= readFileAuto (filename)
            assert (elements.count == 1802, "# elements")

            val read = System.nanoTime ()
            val islands = get[TopologicalIsland]
            assert (null != islands, "no TopologicalIsland RDD")
            assert (islands.count == 4, "# islands")
            val nodes = get[TopologicalNode]
            assert (null != nodes, "no TopologicalNode RDD")
            assert (nodes.count == 60, "# nodes")  // 91 fewer nodes when switches and fuses aren't retained

            info ("read and process: %s seconds".format ((read - start) / 1e9))
        }
}
