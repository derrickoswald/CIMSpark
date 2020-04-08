package ch.ninecode.cim

import java.io.File

import scala.collection.JavaConversions.mapAsJavaMap

import org.apache.spark.sql.SparkSession

class CIMSparkSuite extends ch.ninecode.SparkSuite
{
    val FILE_DEPOT = "data/"

    // test file names
    val FILENAME: String = s"${FILE_DEPOT}RealGrid/CGMES_v2.4.15_RealGridTestConfiguration_EQ_v2.xml"

    // number of elements in the file
    // get number of lines at the top level with:
    // grep -P "^[\t]<cim" RealGrid/CGMES_v2.4.15_RealGridTestConfiguration_EQ_v2.xml | wc
    val ELEMENTS1x = 127686

    override def run (testName: Option[String], args: org.scalatest.Args): org.scalatest.Status =
    {
        // unpack the zip file
        new Unzip ().unzip (s"${FILE_DEPOT}CGMES_v2.4.15_TestConfigurations_v4.0.3.zip", FILE_DEPOT)
        new Unzip ().unzip (s"${FILE_DEPOT}RealGrid/CGMES_v2.4.15_RealGridTestConfiguration_v2.zip", s"${FILE_DEPOT}RealGrid/")
        // run the tests
        val ret  = super.run (testName, args)
        // erase the unpacked files
        deleteRecursive (new File (s"${FILE_DEPOT}MicroGrid/"))
        deleteRecursive (new File (s"${FILE_DEPOT}MicroGrid_Error/"))
        deleteRecursive (new File (s"${FILE_DEPOT}MiniGrid/"))
        deleteRecursive (new File (s"${FILE_DEPOT}SmallGrid/"))
        deleteRecursive (new File (s"${FILE_DEPOT}RealGrid/"))
        ret
    }

    test ("Basic")
    {
        implicit session: SparkSession =>
            val options = Map[String, String] (
                "ch.ninecode.cim.make_edges" -> "true",
                "ch.ninecode.cim.do_topo_islands" -> "true")
            val elements = readFile (FILENAME, options)
            assert (elements.count () === ELEMENTS1x)
            val edges = session.sqlContext.sql ("select * from edges")
            val count = edges.count
            markup (s"edge count: $count")
            assert (count === 8348)
    }

    test ("Dedup")
    {
        implicit session: SparkSession =>
            val elements1 = readFile (FILENAME)
            val count1 = elements1.count ()
            assert (count1 === ELEMENTS1x)
            val options = Map[String, String] ("ch.ninecode.cim.do_deduplication" -> "true")
            val elements2 = readFile (s"$FILENAME,$FILENAME", options)
            val count2 = elements2.count ()
            assert (count1 === count2)
    }
}
