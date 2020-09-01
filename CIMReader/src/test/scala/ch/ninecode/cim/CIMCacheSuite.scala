package ch.ninecode.cim

import java.io.File

import scala.collection.mutable

import org.apache.spark.sql.SparkSession

class CIMCacheSuite extends ch.ninecode.SparkSuite
{
    val FILE_DEPOT = "data/"

    override def run (testName: Option[String], args: org.scalatest.Args): org.scalatest.Status =
    {
        // unpack the zip file
        new Unzip ().unzip (s"${FILE_DEPOT}DemoData.zip", FILE_DEPOT)

        // run the tests
        val ret = super.run (testName, args)

        // erase the unpacked file and cache
        deleteRecursive (new File (s"${FILE_DEPOT}DemoData.rdf"))
        deleteRecursive (new File (s"${FILE_DEPOT}DemoData_cache"))
        ret
    }

    test ("create cache")
    {
        implicit spark: SparkSession =>

            val filename = s"${FILE_DEPOT}DemoData.rdf"
            val cache = new File (s"${FILE_DEPOT}DemoData_cache")
            deleteRecursive (cache)
            val options = Map [String, String](
                "ch.ninecode.cim.cache" -> s"${FILE_DEPOT}DemoData_cache")
            val elements = readFile (filename, options)
            val count = elements.count
            assert (cache.exists (), "cache created (%s elements)".format (count))
            deleteRecursive (cache)
    }

    test ("use cache")
    {
        implicit spark: SparkSession =>

            val filename = s"${FILE_DEPOT}DemoData.rdf"
            val cache = new File (s"${FILE_DEPOT}DemoData_cache")
            deleteRecursive (cache)
            val options = Map [String, String](
                "ch.ninecode.cim.cache" -> s"${FILE_DEPOT}DemoData_cache")
            val elements1 = readFile (filename, options)
            val count1 = elements1.count
            val counts = new mutable.HashMap[String, Long]()
            spark.sparkContext.getPersistentRDDs.foreach (x => counts (x._2.name) = x._2.count)

            // nothing up my sleeve
            val _ = elements1.unpersist (true)
            spark.sparkContext.getPersistentRDDs.foreach (x =>
            {
                val _ = x._2.unpersist (true);
                x._2.name = null
            })

            assert (cache.exists (), "cache created")
            val elements2 = readFile (filename, options)
            val count2 = elements2.count
            assert (count1 == count2, "cache used")

            spark.sparkContext.getPersistentRDDs.foreach (x => assert (counts (x._2.name) == x._2.count, "RDD[%s] count".format (x._2.name)))
            deleteRecursive (cache)
    }
}
