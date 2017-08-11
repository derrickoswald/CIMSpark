package ch.ninecode

import java.util.{HashMap, Map}

import org.apache.spark.SparkConf
import org.apache.spark.sql.{DataFrame, SQLContext, SparkSession}

import org.scalatest.Outcome
import org.scalatest.fixture.FunSuite

import ch.ninecode.cim.CHIM
import ch.ninecode.cim.CIMExport
import ch.ninecode.model._

class ExportSuite extends FunSuite
{
    val FILE_DEPOT = "data/"
    type FixtureParam = SparkSession

    def withFixture (test: OneArgTest): Outcome =
    {
        // create the configuration
        val configuration = new SparkConf (false)
        configuration.setAppName ("CIMSparkSuite")
        configuration.setMaster ("local[2]")
        configuration.set ("spark.driver.memory", "1g")
        configuration.set ("spark.executor.memory", "4g")
        configuration.set ("spark.ui.showConsoleProgress", "false")

        val session = SparkSession.builder ().config (configuration).getOrCreate () // create the fixture
        session.sparkContext.setLogLevel ("OFF") // Valid log levels include: ALL, DEBUG, ERROR, FATAL, INFO, OFF, TRACE, WARN
        try
            withFixture (test.toNoArgTest (session)) // "loan" the fixture to the test
        finally session.stop() // clean up the fixture
    }

    def readFile (context: SQLContext, filename: String, options: Map[String, String]): DataFrame =
    {
        options.put ("path", filename)
        val files = filename.split (",")
        context.read.format ("ch.ninecode.cim").options (options).load (files:_*)
    }


    test ("Basic")
    {
        session: SparkSession ⇒
        val psr =
"""	<cim:PSRType rdf:ID="PSRType_Substation">
		<cim:IdentifiedObject.name>Substation</cim:IdentifiedObject.name>
	</cim:PSRType>"""
        val xml =
            """yadda yadda""" +
            psr +
            """foo bar"""
        val parser = new CHIM (xml)
        val result = CHIM.parse (parser)
        assert (result._1.size === 1)
        assert (result._2.length === 0)
        assert (result._1.getOrElse ("PSRType_Substation", null).export == psr)
    }

    test ("Double")
    {
        session: SparkSession ⇒
        val voltage =
"""	<cim:BaseVoltage rdf:ID="BaseVoltage_0.400000000000">
		<cim:IdentifiedObject.name>400.000 V</cim:IdentifiedObject.name>
		<cim:BaseVoltage.nominalVoltage>0.4</cim:BaseVoltage.nominalVoltage>
	</cim:BaseVoltage>"""
        val xml =
"""<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<rdf:RDF xmlns:cim="http://iec.ch/TC57/2013/CIM-schema-cim16#" xmlns:md="http://iec.ch/TC57/61970-552/ModelDescription/1#" xmlns:dm="http://iec.ch/2002/schema/CIM_difference_model#" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#">
	<md:FullModel rdf:about="sias_current">
		<md:Model.description>NIS Strom (http://nis.ch/produkte#nisStrom) export</md:Model.description>
		<md:Model.modelingAuthoritySet>http://9code.ch/</md:Model.modelingAuthoritySet>
		<md:Model.profile>https://github.com/derrickoswald/CIMScala</md:Model.profile>
	</md:FullModel>""" +
voltage +
"""</rdf:RDF>"""
        val parser = new CHIM (xml)
        val result = CHIM.parse (parser)
        assert (result._1.size === 1)
        assert (result._2.length === 0)
        assert (result._1.getOrElse ("BaseVoltage_0.400000000000", null).export == voltage)
    }

    test ("Multiple")
    {
        session: SparkSession ⇒
        val xml =
"""	<cim:Facility rdf:ID="STA196_asset">
		<cim:IdentifiedObject.aliasName>187674625:nis_el_station</cim:IdentifiedObject.aliasName>
		<cim:IdentifiedObject.description>Transformer Station</cim:IdentifiedObject.description>
		<cim:IdentifiedObject.name>Kiental</cim:IdentifiedObject.name>
		<cim:Asset.critical>false</cim:Asset.critical>
		<cim:Asset.initialLossOfLife>0.0</cim:Asset.initialLossOfLife>
		<cim:Asset.lifecycle rdf:resource="#STA196_lifecycle"/>
		<cim:Asset.purchasePrice>0.0</cim:Asset.purchasePrice>
		<cim:Asset.type>Ortsbeton (TS Gebäude eingebaut)</cim:Asset.type>
		<cim:Asset.Location rdf:resource="#_location_1745492_973692419_187674644"/>
		<cim:Asset.PowerSystemResources rdf:resource="#STA196"/>
		<cim:Asset.PowerSystemResources rdf:resource="#STA197"/>
	</cim:Facility>"""

        val parser = new CHIM (xml)
        val result = CHIM.parse (parser)
        assert (result._1.size === 1)
        assert (result._2.length === 0)
        val facility = result._1 ("STA196_asset").asInstanceOf[Facility]
        val asset = facility.AssetContainer.Asset
        assert (2 == asset.PowerSystemResources.length)
        assert (facility.export == xml)
    }

    test ("Export")
    {
        spark: SparkSession ⇒

        val filename =
            FILE_DEPOT + "NIS_CIM_Export_NS_INITIAL_FILL_Oberiberg" + ".rdf"
        val options = new HashMap[String, String] ().asInstanceOf[Map[String,String]]
        val elements = readFile (spark.sqlContext, filename, options)
        println (elements.count () + " elements")
        val export = new CIMExport (spark)
        export.exportAll ("target/" + "NIS_CIM_Export_NS_INITIAL_FILL_Oberiberg" + ".rdf")
    }
}
