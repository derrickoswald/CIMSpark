package ch.ninecode.cim

import java.util

import org.apache.spark.sql.SparkSession
import ch.ninecode.model._

class CIMExportSuite extends ch.ninecode.SparkSuite
{
    val FILE_DEPOT = "data/"
    val PRIVATE_FILE_DEPOT = "private_data/"

    test ("Basic")
    {
        _: SparkSession ⇒
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
        _: SparkSession ⇒
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
        _: SparkSession ⇒
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
        implicit spark: SparkSession ⇒

        val filename =
            FILE_DEPOT + "NIS_CIM_Export_NS_INITIAL_FILL_Oberiberg" + ".rdf"
        val options = new util.HashMap[String, String] ().asInstanceOf[util.Map[String,String]]
        val elements = readFile (filename, options)
        println (elements.count + " elements")
        val export = new CIMExport (spark)
        export.exportAll ("target/" + "NIS_CIM_Export_NS_INITIAL_FILL_Oberiberg" + ".rdf")
    }

    test ("ExportIsland")
    {
        implicit spark: SparkSession ⇒

        val filename =
            PRIVATE_FILE_DEPOT + "bkw_cim_export_haelig" + ".rdf"
        val options = new util.HashMap[String, String] ().asInstanceOf[util.Map[String,String]]
        val elements = readFile (filename, options)
        println (elements.count + " elements")
        val ntp = new CIMNetworkTopologyProcessor (spark, org.apache.spark.storage.StorageLevel.MEMORY_AND_DISK_SER)
        val elements2 = ntp.process (true)
        println (elements2.count + " elements")
        val export = new CIMExport (spark)
        export.exportIsland ("TRA5200_terminal_2_island", "target/" + "TRA5200" + ".rdf")
    }

    test ("ExportAllIslands")
    {
        implicit spark: SparkSession ⇒

            val filename =
                PRIVATE_FILE_DEPOT + "bkw_cim_export_haelig" + ".rdf"
            val options = new util.HashMap[String, String] ().asInstanceOf[util.Map[String,String]]
            val elements = readFile (filename, options)
            println (elements.count + " elements")
            val ntp = new CIMNetworkTopologyProcessor (spark, org.apache.spark.storage.StorageLevel.MEMORY_AND_DISK_SER)
            val elements2 = ntp.process (true)
            println (elements2.count + " elements")
            val export = new CIMExport (spark)
            export.exportAllIslands ("target/simulation")
    }
}
