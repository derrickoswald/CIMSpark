package ch.ninecode.cim

import java.io.File

import org.apache.spark.sql.SparkSession

class CIMSparkSuite extends ch.ninecode.SparkSuite with org.scalatest.BeforeAndAfter
{
    val FILE_DEPOT = "data/"

    // test file names
    val FILENAME: String = FILE_DEPOT + "NIS_CIM_Export_NS_INITIAL_FILL_Oberiberg.rdf"

    before
    {
        // unpack the zip file
        if (!new File (FILENAME).exists)
            new Unzip ().unzip (FILE_DEPOT + "NIS_CIM_Export_NS_INITIAL_FILL_Oberiberg.zip", FILE_DEPOT)
    }

    test ("Basic")
    {
        implicit session: SparkSession ⇒

        val options = new java.util.HashMap[String, String] ().asInstanceOf[java.util.Map[String,String]]
        options.put ("StorageLevel", "MEMORY_AND_DISK_SER")
        options.put ("ch.ninecode.cim.make_edges", "true")
        options.put ("ch.ninecode.cim.do_topo_islands", "true")
        val elements = readFile (FILENAME, options)
        println (elements.count () + " elements")
        val edges = session.sqlContext.sql ("select * from edges")
        val count = edges.count
        markup ("edge count: " + count)
        assert (count === 760)
    }

    test ("Dedup")
    {
        implicit session: SparkSession ⇒

        val options = new java.util.HashMap[String, String] ().asInstanceOf[java.util.Map[String,String]]
        options.put ("StorageLevel", "MEMORY_AND_DISK_SER")
        val elements1 = readFile (FILENAME, options)
        val count1 = elements1.count ()
        println (count1 + " elements")
        options.put ("ch.ninecode.cim.do_deduplication", "true")
        val elements2 = readFile (FILENAME + "," + FILENAME, options)
        val count2 = elements2.count ()
        println (count2 + " elements")
        assert (count1 === count2)
    }
}
