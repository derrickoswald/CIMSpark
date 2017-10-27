package ch.ninecode.cim

import java.io.File
import java.util.HashMap
import java.util.Map

import org.scalatest.BeforeAndAfter

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession
import org.apache.spark.storage.StorageLevel

import ch.ninecode.model._

class CIMSparkSuite
extends
    ch.ninecode.SparkSuite
with
    org.scalatest.BeforeAndAfter
{
    val FILE_DEPOT = "data/"
    val PRIVATE_FILE_DEPOT = "private_data/"

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

        val options = new HashMap[String, String] ().asInstanceOf[Map[String,String]]
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

        val options = new HashMap[String, String] ().asInstanceOf[Map[String,String]]
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

    test ("DedupStripes")
    {
        implicit session: SparkSession ⇒

        val filename =
            PRIVATE_FILE_DEPOT + "bkw_cim_export_all_overlays" + ".rdf"
        val options = new HashMap[String, String] ().asInstanceOf[Map[String,String]]
        options.put ("StorageLevel", "MEMORY_AND_DISK_SER")
        val elements1 = readFile (filename, options)
        val count1 = elements1.count ()
        println (count1 + " elements")
        val filename1 =
            PRIVATE_FILE_DEPOT + "bkw_cim_export_stripe1_overlays" + ".rdf"
        val filename2 =
            PRIVATE_FILE_DEPOT + "bkw_cim_export_stripe2_overlays" + ".rdf"
        options.put ("ch.ninecode.cim.do_deduplication", "true")
        val elements2 = readFile (filename1 + "," + filename2, options)
        val count2 = elements2.count ()
        println (count2 + " elements")
        assert (count1 === count2)
    }

    test ("Join")
    {
        implicit session: SparkSession ⇒

        val filename =
            PRIVATE_FILE_DEPOT + "NIS_CIM_Export_sias_current_20161220_Bubenei_V11_assets_preview" + ".rdf" +
            "," +
            PRIVATE_FILE_DEPOT + "ISU_CIM_Export_20160505" + ".rdf"
        val options = new HashMap[String, String] ().asInstanceOf[Map[String,String]]
        options.put ("StorageLevel", "MEMORY_AND_DISK_SER")
        val elements = readFile (filename, options)
        println (elements.count () + " elements")

        var servicelocations: RDD[ServiceLocation] = get[ServiceLocation]
        println (servicelocations.count () + " servicelocations before")

        var positions = get[PositionPoint]
        println (positions.count () + " positions before")

        var users = get[UserAttribute]
        println (users.count () + " user attributes before")

        var names = get[UserAttribute]
        println (names.count () + " names before")

        val join = new CIMJoin (session, StorageLevel.fromString ("MEMORY_AND_DISK_SER"))
        join.do_join ()

        servicelocations = get[ServiceLocation]
        println (servicelocations.count () + " servicelocations after")

        positions = get[PositionPoint]
        println (positions.count () + " positions after")

        users = get[UserAttribute]
        println (users.count () + " user attributes after")

        names = get[UserAttribute]
        val count = names.count ()
        println (count + " names after")
        if (0 != count)
            println (names.first)
    }

    test ("Auto-join")
    {
        implicit session: SparkSession ⇒

        val filename =
            PRIVATE_FILE_DEPOT + "NIS_CIM_Export_sias_current_20161220_Bubenei_V11_assets_preview" + ".rdf" +
            "," +
            PRIVATE_FILE_DEPOT + "ISU_CIM_Export_20160505" + ".rdf"
        val options = new HashMap[String, String] ().asInstanceOf[Map[String,String]]
        options.put ("StorageLevel", "MEMORY_AND_DISK_SER")
        options.put ("ch.ninecode.cim.do_join", "true")
        val elements = readFile (filename, options)
        println (elements.count () + " elements")
        val servicelocations = get[ServiceLocation]
        println (servicelocations.count () + " servicelocations after")

        val positions = get[PositionPoint]
        println (positions.count () + " positions after")

        val users = get[UserAttribute]
        println (users.count () + " user attributes after")

        val names = get[UserAttribute]
        val count = names.count ()
        println (count + " names after")
        if (0 != count)
            println (names.first)
    }
}
