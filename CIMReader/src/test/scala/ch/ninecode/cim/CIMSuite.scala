package ch.ninecode.cim

import org.scalatest.funsuite.AnyFunSuite

import ch.ninecode.model._

class CIMSuite extends AnyFunSuite
{
    /**
     * Link to the scaladoc - very clear and detailed tutorial of AnyFunSuite
     *
     * http://doc.scalatest.org/3.1.2/org/scalatest/funsuite/AnyFunSuite.html
     *
     * Operators
     *  - test
     *  - ignore
     *  - pending
     */
    test ("Basic")
    {
        val xml =
            """yadda yadda
    <cim:PSRType rdf:ID="PSRType_Substation">
        <cim:IdentifiedObject.name>Substation</cim:IdentifiedObject.name>
    </cim:PSRType>
foo bar"""
        val parser = new CHIM (xml)
        val result = CHIM.parse (parser)
        assert (result._1.size === 1)
        assert (result._2.length === 0)
    }

    test ("External Extra")
    {
        val xml =
            """yadda yadda
		<cim:PSRType rdf:ID="PSRType_Substation">
			<cim:IdentifiedObject.name>Substation</cim:IdentifiedObject.name>
		</cim:PSRType>
foo bar
		<cim:PSRType rdf:ID="PSRType_TransformerStation">
			<cim:IdentifiedObject.name>Transformer Station</cim:IdentifiedObject.name>
		</cim:PSRType>
yadda yadda"""
        val parser = new CHIM (xml)
        val result = CHIM.parse (parser)
        assert (result._1.size === 1)
        assert (result._2.length === 1)
        //markup (result._2(0))
    }

    test ("Internal Extra")
    {
        val xml =
            """yadda yadda
		<cim:PSRType rdf:ID="PSRType_Substation">
			<cim:IdentifiedObject.name>Substation</cim:IdentifiedObject.name>
		</cim:PSRType>
		<cim:PSRType rdf:ID="PSRType_TransformerStation">
foo bar
			<cim:IdentifiedObject.name>Transformer Station</cim:IdentifiedObject.name>
		</cim:PSRType>
yadda yadda"""

        CIMContext.STOP_ON_ERROR = true
        val parser = new CHIM (xml)
        val result = CHIM.parse (parser)
        assert (result._1.size === 1)
        assert (result._2.length === 1)
        //markup (result._2(0))
        CIMContext.STOP_ON_ERROR = false
    }

    test ("Voltage")
    {
        // Note: scala XML really hates processing instructions
        val xml =
            """<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<rdf:RDF xmlns:cim="http://iec.ch/TC57/2013/CIM-schema-cim16#" xmlns:md="http://iec.ch/TC57/61970-552/ModelDescription/1#" xmlns:dm="http://iec.ch/2002/schema/CIM_difference_model#" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#">
	<md:FullModel rdf:about="sias_current">
		<md:Model.description>NIS Strom (http://nis.ch/produkte#nisStrom) export</md:Model.description>
		<md:Model.modelingAuthoritySet>http://9code.ch/</md:Model.modelingAuthoritySet>
		<md:Model.profile>https://github.com/derrickoswald/CIMScala</md:Model.profile>
	</md:FullModel>
	<cim:BaseVoltage rdf:ID="BaseVoltage_0.400000000000">
		<cim:IdentifiedObject.name>400.000 V</cim:IdentifiedObject.name>
		<cim:BaseVoltage.nominalVoltage>0.400000000000</cim:BaseVoltage.nominalVoltage>
	</cim:BaseVoltage>
</rdf:RDF>"""
        val parser = new CHIM (xml)
        val result = CHIM.parse (parser)
        assert (result._1.size === 1)
        assert (result._2.length === 0)
        val voltage = result._1 ("BaseVoltage_0.400000000000").asInstanceOf [BaseVoltage]
        assert (voltage.nominalVoltage === 0.40)
    }

    test ("Illegal Voltage")
    {
        val xml =
            """<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<rdf:RDF xmlns:cim="http://iec.ch/TC57/2013/CIM-schema-cim16#" xmlns:md="http://iec.ch/TC57/61970-552/ModelDescription/1#" xmlns:dm="http://iec.ch/2002/schema/CIM_difference_model#" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#">
	<md:FullModel rdf:about="sias_current">
		<md:Model.description>NIS Strom (http://nis.ch/produkte#nisStrom) export</md:Model.description>
		<md:Model.modelingAuthoritySet>http://9code.ch/</md:Model.modelingAuthoritySet>
		<md:Model.profile>https://github.com/derrickoswald/CIMScala</md:Model.profile>
	</md:FullModel>
	<cim:BaseVoltage rdf:ID="BaseVoltage_0.400000000000">
		<cim:IdentifiedObject.name>400.000 V</cim:IdentifiedObject.name>
		<cim:BaseVoltage.nominalVoltage>x0.400000000000</cim:BaseVoltage.nominalVoltage>
	</cim:BaseVoltage>
</rdf:RDF>"""
        val parser = new CHIM (xml)
        intercept [Exception]
            {
                val _ = CHIM.parse (parser)
                fail ("invalid voltage accepted")
            }
    }

    test ("Coordinate System")
    {
        val xml =
            """<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<rdf:RDF xmlns:cim="http://iec.ch/TC57/2013/CIM-schema-cim16#" xmlns:md="http://iec.ch/TC57/61970-552/ModelDescription/1#" xmlns:dm="http://iec.ch/2002/schema/CIM_difference_model#" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#">
	<md:FullModel rdf:about="sias_current">
		<md:Model.description>NIS Strom (http://nis.ch/produkte#nisStrom) export</md:Model.description>
		<md:Model.modelingAuthoritySet>http://9code.ch/</md:Model.modelingAuthoritySet>
		<md:Model.profile>https://github.com/derrickoswald/CIMScala</md:Model.profile>
	</md:FullModel>
	<cim:CoordinateSystem rdf:ID="wgs84">
		<cim:IdentifiedObject.name>WGS 84</cim:IdentifiedObject.name>
		<cim:IdentifiedObject.description>new World Geodetic System</cim:IdentifiedObject.description>
		<cim:CoordinateSystem.crsUrn>EPSG::4326</cim:CoordinateSystem.crsUrn>
	</cim:CoordinateSystem>
</rdf:RDF>"""

        val parser = new CHIM (xml)
        val result = CHIM.parse (parser)
        assert (result._1.size === 1)
        assert (result._2.length === 0)
        result._1 ("wgs84") match
        {
            case cs: CoordinateSystem => assert (cs.crsUrn === "EPSG::4326")
            case _ => assert (false, "not a CoordinateSystem")
        }
    }

    test ("Many-to-Many")
    {
        val xml =
            """	<cim:Facility rdf:ID="STA196_asset">
		<cim:IdentifiedObject.name>Kiental</cim:IdentifiedObject.name>
		<cim:IdentifiedObject.aliasName>187674625:nis_el_station</cim:IdentifiedObject.aliasName>
		<cim:IdentifiedObject.description>Transformer Station</cim:IdentifiedObject.description>
		<cim:Asset.type>Ortsbeton (TS Gebäude eingebaut)</cim:Asset.type>
		<cim:Asset.Location rdf:resource="#_location_1745492_973692419_187674644"/>
		<cim:Asset.PowerSystemResources rdf:resource="#STA196"/>
		<cim:Asset.PowerSystemResources rdf:resource="#STA197"/>
		<cim:Asset.lifecycleDate rdf:resource="#STA196_lifecycle"/>
	</cim:Facility>"""

        val parser = new CHIM (xml)
        val result = CHIM.parse (parser)
        assert (result._1.size === 1)
        assert (result._2.length === 0)
        val facility = result._1 ("STA196_asset").asInstanceOf [Facility]
        val asset = facility.AssetContainer.Asset
        assert (2 == asset.PowerSystemResources.length)
    }

    test ("Self Closing Tag")
    {
        val xml =
            """	<cim:ACLineSegment rdf:ID="LEK110315">
		<cim:IdentifiedObject.name>unbekannt</cim:IdentifiedObject.name>
		<cim:IdentifiedObject.aliasName>19657248:nis_el_cable</cim:IdentifiedObject.aliasName>
		<cim:IdentifiedObject.description>unbekannt</cim:IdentifiedObject.description>
		<cim:PowerSystemResource.Location rdf:resource="#_location_667281_1203774000_19657253"/>
		<cim:PowerSystemResource.PSRType rdf:resource="#PSRType_Underground"/>
		<cim:PowerSystemResource.AssetDatasheet rdf:resource="#nis_el_cable_art_ART3313"/>
		<cim:ConductingEquipment.BaseVoltage rdf:resource="#BaseVoltage_400"/>
		<cim:ConductingEquipment.SvStatus rdf:resource="#in_use"/>
		<cim:Conductor.length>1.125373716</cim:Conductor.length>
		<cim:ACLineSegment.r0/>
		<cim:ACLineSegment.r/>
		<cim:ACLineSegment.x0/>
		<cim:ACLineSegment.x/>
	</cim:ACLineSegment>"""

        val parser = new CHIM (xml)
        val result = CHIM.parse (parser)
        assert (result._1.size === 1)
        assert (result._2.length === 0)
        val line = result._1 ("LEK110315").asInstanceOf [ACLineSegment]
        assert (0 == line.r)
        assert (0 == line.x)
        assert (0 == line.r0)
        assert (0 == line.x0)
        assert (1.125373716 == line.Conductor.len)
    }
}
