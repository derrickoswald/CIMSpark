package ch.ninecode.cim

import java.io.File

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession

import ch.ninecode.SparkSuite
import ch.ninecode.model._

class CIMExportSuite extends SparkSuite
{
    val FILE_DEPOT = "data/"

    val filenames_micro: Array[String] = Array(
        s"${FILE_DEPOT}MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_BE_EQ_V2.xml",
        s"${FILE_DEPOT}MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_BE_TP_V2.xml",
        s"${FILE_DEPOT}MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_BE_SSH_V2.xml",
        s"${FILE_DEPOT}MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_BE_DY_V2.xml",
        s"${FILE_DEPOT}MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_BE_GL_V2.xml",
        s"${FILE_DEPOT}MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_NL_EQ_V2.xml",
        s"${FILE_DEPOT}MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_NL_TP_V2.xml",
        s"${FILE_DEPOT}MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_NL_SSH_V2.xml",
        s"${FILE_DEPOT}MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_NL_DY_V2.xml",
        s"${FILE_DEPOT}MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_NL_GL_V2.xml",
        s"${FILE_DEPOT}MicroGrid/BaseCase_BC/MicroGridTestConfiguration_EQ_BD.xml",
        s"${FILE_DEPOT}MicroGrid/BaseCase_BC/MicroGridTestConfiguration_TP_BD.xml",
        s"${FILE_DEPOT}MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_Assembled_DL_V2.xml",
        s"${FILE_DEPOT}MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_Assembled_SV_V2.xml"
    )

    val filenames_real: Array[String] = Array(
        s"${FILE_DEPOT}RealGrid/CGMES_v2.4.15_RealGridTestConfiguration_EQ_v2.xml",
        s"${FILE_DEPOT}RealGrid/CGMES_v2.4.15_RealGridTestConfiguration_SSH_v2.xml",
        s"${FILE_DEPOT}RealGrid/CGMES_v2.4.15_RealGridTestConfiguration_SV_v2.xml",
        s"${FILE_DEPOT}RealGrid/CGMES_v2.4.15_RealGridTestConfiguration_TP_v2.xml"
    )

    val DEMO_DATA1: String = s"${FILE_DEPOT}DemoData_with_medium_voltage.rdf"
    val DEMO_DATA2: String = s"${FILE_DEPOT}DemoData_with_medium_voltage_and_ganged_transformers.rdf"

    override def run (testName: Option[String], args: org.scalatest.Args): org.scalatest.Status =
    {
        // unpack the zip file
        new Unzip().unzip(s"${FILE_DEPOT}CGMES_v2.4.15_TestConfigurations_v4.0.3.zip", FILE_DEPOT)
        new Unzip().unzip(s"${FILE_DEPOT}MicroGrid/BaseCase_BC/CGMES_v2.4.15_MicroGridTestConfiguration_BC_Assembled_v2.zip", s"${FILE_DEPOT}MicroGrid/BaseCase_BC/")
        new Unzip().unzip(s"${FILE_DEPOT}CGMES_v2.4.15_TestConfigurations_v4.0.3.zip", FILE_DEPOT)
        new Unzip().unzip(s"${FILE_DEPOT}RealGrid/CGMES_v2.4.15_RealGridTestConfiguration_v2.zip", s"${FILE_DEPOT}RealGrid/")
        new Unzip().unzip(s"${FILE_DEPOT}DemoData_with_medium_voltage.zip", FILE_DEPOT)
        new Unzip().unzip(s"${FILE_DEPOT}DemoData_with_medium_voltage_and_ganged_transformers.zip", FILE_DEPOT)
        // run the tests
        val ret = super.run(testName, args)
        // erase the unpacked files
        deleteRecursive(new File(s"${FILE_DEPOT}MicroGrid/"))
        deleteRecursive(new File(s"${FILE_DEPOT}MicroGrid_Error/"))
        deleteRecursive(new File(s"${FILE_DEPOT}MiniGrid/"))
        deleteRecursive(new File(s"${FILE_DEPOT}SmallGrid/"))
        deleteRecursive(new File(s"${FILE_DEPOT}RealGrid/"))
        new File(DEMO_DATA1).delete
        new File(DEMO_DATA2).delete
        ret
    }

    def cleanString (s: String): String =
    {
        s.replaceAll("\n", "").replaceAll("\\s", "")
    }

    test("Basic")
    {
        _: SparkSession =>
            val psr =
                """<cim:PSRType rdf:ID="PSRType_Substation">
                  |	<cim:IdentifiedObject.name>Substation</cim:IdentifiedObject.name>
                  |</cim:PSRType>""".stripMargin
            val xml =
                s"""yadda yadda${psr}foo bar"""
            val parser = new CHIM(xml)
            val result = CHIM.parse(parser)
            assert(result._1.size === 1)
            assert(result._2.length === 0)

            val s1 = cleanString(result._1.getOrElse("PSRType_Substation", null).export)
            val s2 = cleanString(psr)
            assert(s1 == s2)
    }

    test("Attribute")
    {
        _: SparkSession =>
            val loc =
                """<cim:Location rdf:ID="_location_1623670528_427088716_224817700">
                  |	<cim:Location.type>geographic</cim:Location.type>
                  |	<cim:Location.CoordinateSystem rdf:resource="#pseudo_wgs84"/>
                  |</cim:Location>""".stripMargin
            val xml =
                s"""yadda yadda${loc}foo bar"""
            val parser = new CHIM(xml)
            val result = CHIM.parse(parser)
            assert(result._1.size === 1)
            assert(result._2.length === 0)

            val s1 = cleanString(result._1.getOrElse("_location_1623670528_427088716_224817700", null).export)
            val s2 = cleanString(loc)
            assert(s1 == s2)
    }

    test("Double")
    {
        _: SparkSession =>
            val voltage =
                """<cim:BaseVoltage rdf:ID="BaseVoltage_0.400000000000">
	<cim:IdentifiedObject.name>400.000 V</cim:IdentifiedObject.name>
	<cim:BaseVoltage.nominalVoltage>0.4</cim:BaseVoltage.nominalVoltage>
</cim:BaseVoltage>"""

            val xml =
                s"""<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<rdf:RDF xmlns:cim="http://iec.ch/TC57/2013/CIM-schema-cim16#" xmlns:md="http://iec.ch/TC57/61970-552/ModelDescription/1#" xmlns:dm="http://iec.ch/2002/schema/CIM_difference_model#" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#">
	<md:FullModel rdf:about="sias_current">
	<md:Model.description>NIS Strom (http://nis.ch/produkte#nisStrom) export</md:Model.description>
	<md:Model.modelingAuthoritySet>http://9code.ch/</md:Model.modelingAuthoritySet>
	<md:Model.profile>https://github.com/derrickoswald/CIMScala</md:Model.profile>
</md:FullModel>
$voltage
</rdf:RDF>"""
            val parser = new CHIM(xml)
            val result = CHIM.parse(parser)
            assert(result._1.size === 1)
            assert(result._2.length === 0)

            val s1 = cleanString(result._1.getOrElse("BaseVoltage_0.400000000000", null).export)
            val s2 = cleanString(voltage)
            assert(s1 == s2)
    }

    test("Multiple")
    {
        _: SparkSession =>
            val xml =
                """	<cim:Facility rdf:ID="STA196_asset">
		<cim:IdentifiedObject.aliasName>187674625:nis_el_station</cim:IdentifiedObject.aliasName>
		<cim:IdentifiedObject.description>Transformer Station</cim:IdentifiedObject.description>
		<cim:IdentifiedObject.name>Kiental</cim:IdentifiedObject.name>
		<cim:Asset.critical>false</cim:Asset.critical>
		<cim:Asset.lifecycleDate rdf:resource="#STA196_lifecycle"/>
		<cim:Asset.purchasePrice>0.0</cim:Asset.purchasePrice>
		<cim:Asset.type>Ortsbeton (TS Gebäude eingebaut)</cim:Asset.type>
		<cim:Asset.Location rdf:resource="#_location_1745492_973692419_187674644"/>
		<cim:Asset.PowerSystemResources rdf:resource="#STA196"/>
		<cim:Asset.PowerSystemResources rdf:resource="#STA197"/>
		<cim:Facility.kind>Substation</cim:Facility.kind>
	</cim:Facility>"""

            val parser = new CHIM(xml)
            val result = CHIM.parse(parser)
            assert(result._1.size === 1)
            assert(result._2.length === 0)
            val facility = result._1("STA196_asset").asInstanceOf[Facility]
            val asset = facility.AssetContainer.Asset
            assert(2 == asset.PowerSystemResources.length)
            assert(cleanString(facility.export) == cleanString(xml))
    }

    test("About")
    {
        _: SparkSession =>
            val xml =
                """	<cim:Terminal rdf:about="KLE120953_terminal_1">
		<cim:Terminal.TopologicalNode rdf:resource="#MUF129829_topo"/>
	</cim:Terminal>"""

            val parser = new CHIM(xml)
            val result = CHIM.parse(parser)
            assert(result._1.size === 1)
            assert(result._2.length === 0)
            val terminal = result._1("KLE120953_terminal_1").asInstanceOf[Terminal]
            assert(terminal.about)
            assert(cleanString(terminal.export) == cleanString(xml))
    }

    test("Convex Hull")
    {
        _: SparkSession =>
            val pp = Array[(Double, Double)]((8, 9), (3, 5), (4, 4), (1, 7), (3, 4), (4, 5), (6, 6), (5, 7), (3, 8))
            val hull = Hull.scan(pp.toList).toArray[(Double, Double)]
            assert("(3.0,4.0)(1.0,7.0)(3.0,8.0)(8.0,9.0)(6.0,6.0)(4.0,4.0)(3.0,4.0)" == hull.mkString)
    }

    test("Export")
    {
        implicit spark: SparkSession =>

            val elements = readFile(filenames_micro.mkString(","), Map("ch.ninecode.cim.do_about" -> "true"))
            println(s"${elements.count} elements")
            val export = new CIMExport(spark)
            export.exportAll("target/BaseCase_BC.rdf")
            assert(new File("target/BaseCase_BC.rdf").exists, "export all BaseCase_BC")
    }

    test("ExportIsland")
    {
        implicit spark: SparkSession =>

            val output = new File("target/_TI-1_island.rdf")
            val _ = output.delete
            val elements = readFile(
                filenames_real.mkString(","),
                Map("ch.ninecode.cim.do_about" -> "true", "ch.ninecode.cim.do_normalize" -> "true"))
            println(s"${elements.count} elements")
            val export = new CIMExport(spark)
            export.exportIsland("_TI-1", "_TI-1_island.rdf", "target/")
            assert(output.exists, "island _TI-1")
    }

    test("ExportAllIslands")
    {
        implicit spark: SparkSession =>

            val elements = readFile(DEMO_DATA1, Map("ch.ninecode.cim.do_topo_islands" -> "true"))
            println(s"${elements.count} elements")
            val islands = spark.sparkContext.getPersistentRDDs.find(_._2.name == "TopologicalIsland").get._2.asInstanceOf[RDD[TopologicalIsland]].map(_.id).collect

            val start = System.nanoTime
            val export = new CIMExport(spark)
            export.exportAllIslands("target/")
            println(s"process: ${(System.nanoTime - start) / 1e9} seconds")

            islands.foreach(
                island =>
                {
                    // remove all RDD to start from scratch
                    spark.sparkContext.getPersistentRDDs.foreach(x =>
                    {
                        x._2.unpersist(true)
                        x._2.name = null
                    })
                    val file = s"target/$island.rdf"
                    assert(new File(file).exists, s"island $island")

                    val elements2 = readFile(file)
                    println(s"island $island has ${elements2.count} elements")
                    val checker = new CIMIntegrityChecker(spark)
                    val errors = checker.checkAll
                    println(if (errors.isDefined) errors.get else "no errors")
                    assert(errors.isEmpty, "reference errors")
                }
            )
    }

    test("ExportAllTransformersFile")
    {
        implicit spark: SparkSession =>

            val elements = readFile(DEMO_DATA1, Map("ch.ninecode.cim.do_topo_islands" -> "true"))
            println(s"${elements.count} elements")
            val transformers = spark.sparkContext.getPersistentRDDs.find(_._2.name == "PowerTransformer").get._2.asInstanceOf[RDD[PowerTransformer]].map(_.id).collect

            val start = System.nanoTime
            val export = new CIMExport(spark)
            export.exportAllTransformers(CIMExportOptions(files = Seq(DEMO_DATA1), topology = true, outputdir = "target/"))
            println(s"process: ${(System.nanoTime - start) / 1e9} seconds")

            transformers.foreach(
                transformer =>
                {
                    // remove all RDD to start from scratch
                    spark.sparkContext.getPersistentRDDs.foreach(x =>
                    {
                        x._2.unpersist(true)
                        x._2.name = null
                    })
                    val file = s"target/$transformer.rdf"
                    assert(new File(file).exists, s"transformer $transformer")

                    val elements2 = readFile(file)
                    println(s"transformer $transformer has ${elements2.count} elements")
                    val checker = new CIMIntegrityChecker(spark)
                    val errors = checker.checkAll
                    println(if (errors.isDefined) errors.get else "no errors")
                    assert(errors.isEmpty, "reference errors")
                }
            )
    }

    test("ExportAllTransformersFileGanged")
    {
        implicit spark: SparkSession =>

            val elements = readFile(DEMO_DATA2, Map("ch.ninecode.cim.do_topo_islands" -> "true"))
            println(s"${elements.count} elements")
            val transformers = Array("TX0001", "TX0002_TX0003") // call me lazy

            val start = System.nanoTime
            val export = new CIMExport(spark)
            export.exportAllTransformers(CIMExportOptions(files = Seq(DEMO_DATA2), outputdir = "target/"))
            println(s"process: ${(System.nanoTime - start) / 1e9} seconds")

            transformers.foreach(
                transformer =>
                {
                    // remove all RDD to start from scratch
                    spark.sparkContext.getPersistentRDDs.foreach(x =>
                    {
                        x._2.unpersist(true)
                        x._2.name = null
                    })
                    val file = s"target/$transformer.rdf"
                    assert(new File(file).exists, s"transformer $transformer")

                    val elements2 = readFile(file)
                    println(s"transformer $transformer has ${elements2.count} elements")
                    val checker = new CIMIntegrityChecker(spark)
                    val errors = checker.checkAll
                    println(if (errors.isDefined) errors.get else "no errors")
                    assert(errors.isEmpty, "reference errors")
                }
            )
    }
}
