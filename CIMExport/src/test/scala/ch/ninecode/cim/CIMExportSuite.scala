package ch.ninecode.cim

import java.io.File
import java.util.HashMap
import java.util.Map

import org.apache.spark.sql.SparkSession

import ch.ninecode.model._

class CIMExportSuite
    extends
        ch.ninecode.SparkSuite
{
    val FILE_DEPOT = "data/"

    val filenames_micro = Array (
        FILE_DEPOT + "MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_BE_EQ_V2.xml",
        FILE_DEPOT + "MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_BE_TP_V2.xml",
        FILE_DEPOT + "MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_BE_SSH_V2.xml",
        FILE_DEPOT + "MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_BE_DY_V2.xml",
        FILE_DEPOT + "MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_BE_GL_V2.xml",
        FILE_DEPOT + "MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_NL_EQ_V2.xml",
        FILE_DEPOT + "MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_NL_TP_V2.xml",
        FILE_DEPOT + "MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_NL_SSH_V2.xml",
        FILE_DEPOT + "MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_NL_DY_V2.xml",
        FILE_DEPOT + "MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_NL_GL_V2.xml",
        FILE_DEPOT + "MicroGrid/BaseCase_BC/MicroGridTestConfiguration_EQ_BD.xml",
        FILE_DEPOT + "MicroGrid/BaseCase_BC/MicroGridTestConfiguration_TP_BD.xml",
        FILE_DEPOT + "MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_Assembled_DL_V2.xml",
        FILE_DEPOT + "MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_Assembled_SV_V2.xml"
    )

    val filenames_real = Array (
        FILE_DEPOT + "RealGrid/CGMES_v2.4.15_RealGridTestConfiguration_EQ_v2.xml",
        FILE_DEPOT + "RealGrid/CGMES_v2.4.15_RealGridTestConfiguration_SSH_v2.xml",
        FILE_DEPOT + "RealGrid/CGMES_v2.4.15_RealGridTestConfiguration_SV_v2.xml",
        FILE_DEPOT + "RealGrid/CGMES_v2.4.15_RealGridTestConfiguration_TP_v2.xml"
    )

    val demo_data = FILE_DEPOT + "DemoData.rdf"

    override def run (testName: Option[String], args: org.scalatest.Args): org.scalatest.Status =
    {
        // unpack the zip file
        new Unzip ().unzip (FILE_DEPOT + "CGMES_v2.4.15_TestConfigurations_v4.0.3.zip", FILE_DEPOT)
        new Unzip ().unzip (FILE_DEPOT + "MicroGrid/BaseCase_BC/CGMES_v2.4.15_MicroGridTestConfiguration_BC_Assembled_v2.zip", FILE_DEPOT + "MicroGrid/BaseCase_BC/")
        new Unzip ().unzip (FILE_DEPOT + "CGMES_v2.4.15_TestConfigurations_v4.0.3.zip", FILE_DEPOT)
        new Unzip ().unzip (FILE_DEPOT + "RealGrid/CGMES_v2.4.15_RealGridTestConfiguration_v2.zip", FILE_DEPOT + "RealGrid/")
        new Unzip ().unzip (FILE_DEPOT + "DemoData.zip", FILE_DEPOT)
        // run the tests
        val ret = super.run (testName, args)
        // erase the unpacked files
        deleteRecursive (new File (FILE_DEPOT + "MicroGrid/"))
        deleteRecursive (new File (FILE_DEPOT + "MicroGrid_Error/"))
        deleteRecursive (new File (FILE_DEPOT + "MiniGrid/"))
        deleteRecursive (new File (FILE_DEPOT + "SmallGrid/"))
        deleteRecursive (new File (FILE_DEPOT + "RealGrid/"))
        new File (demo_data).delete
        ret
    }

    def cleanString (s: String): String =
    {
        s.replaceAll ("\n", "").replaceAll ("\\s", "")
    }

    ignore ("Basic")
    {
        _: SparkSession ⇒
            val psr =
                """<cim:PSRType rdf:ID="PSRType_Substation">
                  |	<cim:IdentifiedObject.name>Substation</cim:IdentifiedObject.name>
                  |</cim:PSRType>""".stripMargin
            val xml =
                """yadda yadda""" +
                    psr +
                    """foo bar"""
            val parser = new CHIM (xml)
            val result = CHIM.parse (parser)
            assert (result._1.size === 1)
            assert (result._2.length === 0)

            val s1 = cleanString (result._1.getOrElse ("PSRType_Substation", null).export)
            val s2 = cleanString (psr)
            assert (s1 == s2)
    }

    ignore ("Attribute")
    {
        _: SparkSession ⇒
            val loc =
                """<cim:Location rdf:ID="_location_1623670528_427088716_224817700">
                  |	<cim:Location.type>geographic</cim:Location.type>
                  |	<cim:Location.CoordinateSystem rdf:resource="#pseudo_wgs84"/>
                  |</cim:Location>""".stripMargin
            val xml =
                """yadda yadda""" +
                    loc +
                    """foo bar"""
            val parser = new CHIM (xml)
            val result = CHIM.parse (parser)
            assert (result._1.size === 1)
            assert (result._2.length === 0)

            val s1 = cleanString (result._1.getOrElse ("_location_1623670528_427088716_224817700", null).export)
            val s2 = cleanString (loc)
            assert (s1 == s2)
    }

    ignore ("Double")
    {
        _: SparkSession ⇒
            val voltage =
                """<cim:BaseVoltage rdf:ID="BaseVoltage_0.400000000000">
                  |	<cim:IdentifiedObject.name>400.000 V</cim:IdentifiedObject.name>
                  |	<cim:BaseVoltage.nominalVoltage>0.4</cim:BaseVoltage.nominalVoltage>
                  |</cim:BaseVoltage>""".stripMargin

            val xml =
                """<?xml version="1.0" encoding="UTF-8" standalone="no"?>
                  |<rdf:RDF xmlns:cim="http://iec.ch/TC57/2013/CIM-schema-cim16#" xmlns:md="http://iec.ch/TC57/61970-552/ModelDescription/1#" xmlns:dm="http://iec.ch/2002/schema/CIM_difference_model#" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#">
                  |	<md:FullModel rdf:about="sias_current">
                  | <md:Model.description>NIS Strom (http://nis.ch/produkte#nisStrom) export</md:Model.description>
                  |	<md:Model.modelingAuthoritySet>http://9code.ch/</md:Model.modelingAuthoritySet>
                  |	<md:Model.profile>https://github.com/derrickoswald/CIMScala</md:Model.profile>
                  |</md:FullModel>""".stripMargin +
                    voltage +
                    """</rdf:RDF>"""
            val parser = new CHIM (xml)
            val result = CHIM.parse (parser)
            assert (result._1.size === 1)
            assert (result._2.length === 0)

            val s1 = cleanString (result._1.getOrElse ("BaseVoltage_0.400000000000", null).export)
            val s2 = cleanString (voltage)
            assert (s1 == s2)
    }

    ignore ("Multiple")
    {
        _: SparkSession ⇒
            val xml =
                """<cim:Facility rdf:ID="STA196_asset">
                  |		<cim:IdentifiedObject.aliasName>187674625:nis_el_station</cim:IdentifiedObject.aliasName>
                  |		<cim:IdentifiedObject.description>Transformer Station</cim:IdentifiedObject.description>
                  |		<cim:IdentifiedObject.name>Kiental</cim:IdentifiedObject.name>
                  |		<cim:Asset.critical>false</cim:Asset.critical>
                  |		<cim:Asset.initialLossOfLife>0.0</cim:Asset.initialLossOfLife>
                  |		<cim:Asset.lifecycle rdf:resource="#STA196_lifecycle"/>
                  |		<cim:Asset.purchasePrice>0.0</cim:Asset.purchasePrice>
                  |		<cim:Asset.type>Ortsbeton (TS Gebäude eingebaut)</cim:Asset.type>
                  |		<cim:Asset.Location rdf:resource="#_location_1745492_973692419_187674644"/>
                  |		<cim:Asset.PowerSystemResources rdf:resource="#STA196"/>
                  |		<cim:Asset.PowerSystemResources rdf:resource="#STA197"/>
                  |	</cim:Facility>""".stripMargin

            val parser = new CHIM (xml)
            val result = CHIM.parse (parser)
            assert (result._1.size === 1)
            assert (result._2.length === 0)
            val facility = result._1 ("STA196_asset").asInstanceOf [Facility]
            val asset = facility.AssetContainer.Asset
            assert (2 == asset.PowerSystemResources.length)
            assert (cleanString(facility.export) == cleanString(xml))
    }

    ignore ("Export")
    {
        implicit spark: SparkSession ⇒

            val options = new HashMap[String, String]().asInstanceOf [Map[String, String]]
            options.put ("ch.ninecode.cim.do_about", "true")
            val elements = readFile (filenames_micro.mkString (","), options)
            println (elements.count + " elements")
            val export = new CIMExport (spark)
            export.exportAll ("target/BaseCase_BC.rdf")
            assert (new File ("target/BaseCase_BC.rdf").exists, "export all BaseCase_BC")
    }

    ignore ("ExportIsland")
    {
        implicit spark: SparkSession ⇒

            val options = new HashMap[String, String]().asInstanceOf [Map[String, String]]
            options.put ("ch.ninecode.cim.do_about", "true")
            options.put ("ch.ninecode.cim.do_normalize", "true")
            val elements = readFile (filenames_real.mkString (","), options)
            println (elements.count + " elements")
            val export = new CIMExport (spark)
            export.exportIsland ("_TI-1", "_TI-1_island" + ".rdf", "target/")
            assert (new File ("target/_TI-1" + "_island.rdf").exists, "island _TI-1")
    }

    ignore ("ExportAllIslands")
    {
        implicit spark: SparkSession ⇒

            val options = new HashMap[String, String]().asInstanceOf [Map[String, String]]
            options.put ("ch.ninecode.cim.do_topo_islands", "true")
            val elements = readFile (demo_data, options)
            println (elements.count + " elements")
            val start = System.nanoTime
            val export = new CIMExport (spark)
            export.exportAllIslands ("target/")
            println ("process: %s seconds".format ((System.nanoTime - start) / 1e9))
            assert (new File ("target/TX0002_terminal_2_island" + ".rdf").exists, "island TX0002_terminal_2_island")

            // remove all RDD to start from scratch
            spark.sparkContext.getPersistentRDDs.foreach (x ⇒ { x._2.unpersist(true); x._2.name = null })

            val elements2 = readFile ("target/TX0002_terminal_2_island" + ".rdf")
            println (elements2.count + " elements")
            val checker = new CIMIntegrityChecker (spark)
            val errors = checker.checkAll
            println (if (errors.isDefined) errors.get else "no errors")
            assert (errors.isEmpty, "reference errors")
    }

    test ("ExportAllTransformers")
    {
        implicit spark: SparkSession ⇒

            val options = new HashMap[String, String]().asInstanceOf [Map[String, String]]
            options.put ("ch.ninecode.cim.do_topo_islands", "true")
            val elements = readFile (demo_data, options)
            println (elements.count + " elements")
            val start = System.nanoTime
            val export = new CIMExport (spark)
            export.exportAllTransformers ("target/", true)
            println ("process: %s seconds".format ((System.nanoTime - start) / 1e9))
            assert (new File ("target/TX0002" + ".rdf").exists, "transformer TX0002")

            // remove all RDD to start from scratch
            spark.sparkContext.getPersistentRDDs.foreach (x ⇒ { x._2.unpersist(true); x._2.name = null })

            val elements2 = readFile ("target/TX0002" + ".rdf")
            println (elements2.count + " elements")
            val checker = new CIMIntegrityChecker (spark)
            val errors = checker.checkAll
            println (if (errors.isDefined) errors.get else "no errors")
            assert (errors.isEmpty, "reference errors")
    }
}
