package ch.ninecode

import java.lang.NumberFormatException
import java.util.regex.Pattern
import java.io.File
import java.io.FileInputStream
import java.io.IOException
import java.io.InputStreamReader

import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.HashMap
import scala.collection.mutable.HashSet

class Result (val context: Context)
{
    var properties = new HashMap[String, String]
}

trait Parser
{
    def steps (): Array[(String, Result) ⇒ Unit]
    def parse (xml: String, result: Result): Unit =
        for (f <- steps)
            f (xml, result)
}

abstract class Element (val key: String) extends Serializable

object Element extends Parser
{
    override def steps () = Array ()

    /**
     * Parse one XML element from a string.
     * @param pattern the regular expression pattern to look for
     * @param index the number of the capture group to extract from within the pattern
     * @param xml the text to parse
     * @param context the context for the substring in the XML and
     * line number and position context for reporting in case of an error
     * @return the matched group from the regular expression
     */
    def parse_element (pattern: Pattern, index: Int, xml:String, context: Context): String =
    {
        val optional = true

        var ret:String = null
        val matcher = pattern.matcher (xml)
        if (matcher.find ())
            ret = matcher.group (index)
        else
            if (!optional)
                throw new Exception ("regular expression " + pattern.toString () + " not found while parsing at line " + context.line_number ())

        return (ret)
    }

    /**
     * Parse one attribute from an XML string.
     * @param pattern the regular expression pattern to look for
     * @param index the number of the capture group to extract from within the pattern
     * @param xml the text to parse
     * @param context the context for the substring in the XML and
     * line number and position context for reporting in case of an error
     * @return the attribute value (with leading # stripped off)
     */
    def parse_attribute (pattern: Pattern, index: Int, xml:String, context: Context): String =
    {
        var ret = parse_element (pattern, index, xml, context)
        if ((null != ret) && ret.startsWith ("#")) // remove '#'
            ret = ret.substring (1)

        return (ret)
    }

    /**
     * Extract and store a property function generator.
     *
     * Using the provided regular expression, parse out the value of the given property
     * which has the given group index and store it under the property name provided.
     * Complain with an exception if the property is not found and mandatory is true.
     *
     * Curry the function with a string to parse and the parsing result/context.
     *
     * @param regex The regular expression with at least one group
     * that can pick out the property value - which will be a string so it can be
     * stored in the properties collection.
     * @param index The group index of the property pattern within the regular expression.
     * @param name The name of the property under which to store the
     * value in the properties collection.
     * @param mandatory If true and the property is not found by the regular expression,
     * throw an exception.
     * @param xml The substring to parse.
     * @param context The context object with character offsets and linenumber index array.
     */
    def parse_element (regex: Pattern, index: Int, name: String, mandatory: Boolean)(xml: String, result: Result): Unit =
    {
        val context = result.context
        val value = Element.parse_element (regex, index, xml, context)
        if (null != value)
            result.properties.put (name, value)
        else
            if (mandatory)
                throw new Exception ("mandatory " + name + " value not found while parsing at line " + context.line_number ())
    }

    def parse_attribute (regex: Pattern, index: Int, name: String, mandatory: Boolean)(xml: String, result: Result): Unit =
    {
        val context = result.context
        val value = Element.parse_attribute (regex, index, xml, context)
        if (null != value)
            result.properties.put (name, value)
        else
            if (mandatory)
                throw new Exception ("mandatory " + name + " value not found while parsing at line " + context.line_number ())
    }
}

case class Unknown (override val key: String, guts: String) extends Element (key)

object Unknown extends Parser
{
    override def steps () = Array (Element.parse)
    def unpickle (xml: String, result: Result): Unknown =
    {
        parse (xml, result)
        val ret = Unknown (xml.hashCode().toString(), xml)
        return (ret)
    }
}

class IdentifiedElement (val id: String) extends Element (id)

object IdentifiedElement extends Parser
{
    val idex = Pattern.compile ("""rdf:ID=("|')([\s\S]*?)\1""")
    override def steps () = Array (Element.parse, Element.parse_attribute (idex, 2, "id", true)_)
}

abstract class NamedElement (id: String, val name: String) extends IdentifiedElement (id)

object NamedElement extends Parser
{
    val namex = Pattern.compile ("""<cim:IdentifiedObject.name>([\s\S]*?)<\/cim:IdentifiedObject.name>""")
    override def steps () = Array (IdentifiedElement.parse, Element.parse_element (namex, 1, "name", true)_)
}

abstract class PowerSystemResource (id: String, name: String) extends NamedElement (id, name)

abstract class LocatedElement (id: String, name: String, val location: String, val container: String) extends PowerSystemResource (id, name)

object LocatedElement extends Parser
{
    val locex = Pattern.compile ("""<cim:PowerSystemResource.Location>([\s\S]*?)<\/cim:PowerSystemResource.Location>""")
    val conex = Pattern.compile ("""<cim:Equipment.EquipmentContainer\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
    override def steps () = Array (
        NamedElement.parse,
        Element.parse_element (locex, 1, "location", true)_,
        Element.parse_attribute (conex, 2, "container", true)_
    )
}

//        <cim:PSRType rdf:ID="PSRType_Substation">
//                <cim:IdentifiedObject.name>Substation</cim:IdentifiedObject.name>
//        </cim:PSRType>
case class PSRType (override val id: String, override val name: String) extends PowerSystemResource (id, name)

object PSRType extends Parser
{
    override def steps () = Array (NamedElement.parse)
    def unpickle (xml: String, result: Result): PSRType =
    {
        parse (xml, result)
        val ret = PSRType (result.properties ("id"), result.properties ("name"))
        return (ret)
    }
}

class Container (id: String, name: String) extends PowerSystemResource (id, name)

//        <cim:Line rdf:ID="_subnetwork_349554">
//                <cim:IdentifiedObject.name>ABG2236|ABG7246|APP197|FLT13|FLU20|FLU21|FLU22|FLU23|HAS332|HAS333|HAS334|HAS335|MUF2681|MUF2682|PIN2</cim:IdentifiedObject.name>
//        </cim:Line>
case class Line (override val id: String, override val name: String) extends Container (id, name)

object Line extends Parser
{
    override def steps () = Array (NamedElement.parse)
    def unpickle (xml: String, result: Result): Line =
    {
        parse (xml, result)
        val ret = Line (result.properties ("id"), result.properties ("name"))
        return (ret)
    }
}

case class Subnetwork (override val id: String, override val name: String) extends Container (id, name)

object Subnetwork extends Parser
{
    override def steps () = Array (NamedElement.parse)
    def unpickle (xml: String, result: Result): Subnetwork =
    {
        parse (xml, result)
        val ret = Subnetwork (result.properties ("id"), result.properties ("name"))
        return (ret)
    }
}

//        <cim:ConnectivityNode rdf:ID="_pin_1555069">
//                <cim:IdentifiedObject.name>PIN2</cim:IdentifiedObject.name>
//                <cim:ConnectivityNode.ConnectivityNodeContainer rdf:resource="_subnetwork_349554"/>
//        </cim:ConnectivityNode>
case class ConnectivityNode (override val id: String, override val name: String, val container: String) extends PowerSystemResource (id, name)

object ConnectivityNode extends Parser
{
    val connex = Pattern.compile ("""<cim:ConnectivityNode.ConnectivityNodeContainer\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
    override def steps () = Array (NamedElement.parse, Element.parse_attribute (connex, 2, "container", true)_)
    def unpickle (xml: String, result: Result): ConnectivityNode =
    {
        parse (xml, result)
        val ret = ConnectivityNode (result.properties ("id"), result.properties ("name"), result.properties ("container"))
        return (ret)
    }
}

//        <cim:BaseVoltage rdf:ID="BaseVoltage_0.400000000000">
//                <cim:IdentifiedObject.name>400.000 V</cim:IdentifiedObject.name>
//                <cim:BaseVoltage.nominalVoltage>0.400000000000</cim:BaseVoltage.nominalVoltage>
//        </cim:BaseVoltage>
case class Voltage (override val id: String, override val name: String, val voltage: Double) extends NamedElement (id, name)

object Voltage extends Parser
{
    val voltex = Pattern.compile ("""<cim:BaseVoltage.nominalVoltage>([\s\S]*?)<\/cim:BaseVoltage.nominalVoltage>""")
    override def steps () = Array (NamedElement.parse, Element.parse_attribute (voltex, 1, "voltage", true)_)
    def unpickle (xml: String, result: Result): Voltage =
    {
        parse (xml, result)
        try
        {
            val voltage = result.properties ("voltage")
            val v = voltage.toDouble * 1000.0
            return (Voltage (result.properties ("id"), result.properties ("name"), v))
        }
        catch
        {
            case nfe: NumberFormatException ⇒ throw new Exception ("unparsable voltage value found for a voltage element while parsing at line " + result.context.line_number ())
        }
    }

}

//        <cim:CoordinateSystem rdf:ID="wgs_84">
//                <cim:IdentifiedObject.name>WGS 84</cim:IdentifiedObject.name>
//                <cim:crsUrn>EPSG::4326</cim:crsUrn>
//        </cim:CoordinateSystem>

case class CoordinateSystem (override val id: String, override val name: String, val urn: String) extends PowerSystemResource (id, name)

object CoordinateSystem extends Parser
{
    val urnex = Pattern.compile ("""<cim:crsUrn>([\s\S]*?)<\/cim:crsUrn>""")
    override def steps () = Array (NamedElement.parse, Element.parse_attribute (urnex, 1, "urn", true)_)
    def unpickle (xml: String, result: Result): CoordinateSystem =
    {
        parse (xml, result)
        val urn = result.properties ("urn")
        return (CoordinateSystem (result.properties ("id"), result.properties ("name"), urn))
    }
}

//    <cim:Location rdf:ID="_location_5773088_1107287243_317923">
//            <cim:Location.CoordinateSystem>wgs_84</cim:Location.CoordinateSystem>
//            <cim:Location.type>geographic</cim:Location.type>
//    </cim:Location>

case class Location (override val id: String, val cs: String, val typ: String) extends IdentifiedElement (id)

object Location extends Parser
{
    val csex = Pattern.compile ("""<cim:Location.CoordinateSystem>([\s\S]*?)<\/cim:Location.CoordinateSystem>""")
    val typex = Pattern.compile ("""<cim:Location.type>([\s\S]*?)<\/cim:Location.type>""")
    override def steps () = Array (IdentifiedElement.parse, Element.parse_element (csex, 1, "cs", true)_, Element.parse_element (typex, 1, "type", true)_)
    def unpickle (xml: String, result: Result): Location =
    {
        parse (xml, result)
        val ret = Location (result.properties ("id"), result.properties ("cs"), result.properties ("type"))
        return (ret)
    }
}

//    <cim:PositionPoint>
//            <cim:PositionPoint.Location>_location_5773088_1107287243_317923</cim:PositionPoint.Location>
//            <cim:sequenceNumber>0</cim:sequenceNumber>
//            <cim:xPosition>8.78184724183</cim:xPosition>
//            <cim:yPosition>47.0400997930</cim:yPosition>
//    </cim:PositionPoint>

case class PositionPoint (override val key:String, val location: String, val sequence: Int, val x: Double, val y: Double) extends Element (key)

object PositionPoint extends Parser
{
    val locex = Pattern.compile ("""<cim:PositionPoint.Location>([\s\S]*?)<\/cim:PositionPoint.Location>""")
    val seqex = Pattern.compile ("""<cim:sequenceNumber>([\s\S]*?)<\/cim:sequenceNumber>""")
    val xposex = Pattern.compile ("""<cim:xPosition>([\s\S]*?)<\/cim:xPosition>""")
    val yposex = Pattern.compile ("""<cim:yPosition>([\s\S]*?)<\/cim:yPosition>""")

    def loc = Element.parse_attribute (locex, 1, "location", true)_
    def seq = Element.parse_attribute (seqex, 1, "sequence", true)_
    def xcoord = Element.parse_attribute (xposex, 1, "x", true)_
    def ycoord = Element.parse_attribute (yposex, 1, "y", true)_
    override def steps () = Array (Element.parse, loc, seq, xcoord, ycoord)
    def unpickle (xml: String, result: Result): PositionPoint =
    {
        parse (xml, result)
        val location = result.properties ("location")
        try
        {
            val sequence = result.properties ("sequence").toInt
            val key = location + "_seq_" + sequence
            try
            {
                val x = result.properties ("x").toDouble
                val y = result.properties ("y").toDouble
                val ret = PositionPoint (key, location, sequence, x, y)
                return (ret)
            }
            catch
            {
                case nfe: NumberFormatException ⇒ throw new Exception ("unparsable coordinate value found for a position point element while parsing at line " + result.context.line_number ())
            }
        }
        catch
        {
            case nfe: NumberFormatException ⇒ throw new Exception ("unparsable sequence value found for a position point element while parsing at line " + result.context.line_number ())
        }
    }
}

//<cim:Asset rdf:ID="_busbar_1772383_asset">
//<cim:Asset.type>Busbar</cim:Asset.type>
//<cim:IdentifiedObject.name>Busbar_SAM143</cim:IdentifiedObject.name>
//<cim:Asset.PowerSystemResources rdf:resource="#_busbar_1772383"/>
//<cim:Asset.AssetInfo rdf:resource="#_busbar_spec_566593648"/>
//</cim:Asset>
case class Asset (override val id: String, override val name: String, val typ: String, val asset: String, val info: String) extends NamedElement (id, name)

object Asset extends Parser
{
    val typex = Pattern.compile ("""<cim:Asset.type>([\s\S]*?)<\/cim:Asset.type>""")
    val assex = Pattern.compile ("""<cim:Asset.PowerSystemResources\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
    val infox = Pattern.compile ("""<cim:Asset.AssetInfo\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")

    def typ = Element.parse_element (typex, 1, "type", true)_
    def ass = Element.parse_attribute (assex, 2, "asset", true)_
    def inf = Element.parse_attribute (infox, 2, "info", true)_
    override def steps () = Array (NamedElement.parse, typ, ass, inf)
    def unpickle (xml: String, result: Result): Asset =
    {
        parse (xml, result)
        val ret = Asset (result.properties ("id"), result.properties ("name"), result.properties ("type"), result.properties ("asset"), result.properties ("info"))
        return (ret)
    }
}

//<cim:EnergyConsumer rdf:ID="_house_connection_1469932">
//    <cim:IdentifiedObject.name>HAS1</cim:IdentifiedObject.name>
//    <cim:PowerSystemResource.Location>_location_5773088_1107287243_317923</cim:PowerSystemResource.Location>
//    <cim:PowerSystemResource.PSRType rdf:resource="#PSRType_Unknown"/>
//    <cim:ConductingEquipment.BaseVoltage rdf:resource="#BaseVoltage_0.400000000000"/>
//    <cim:Equipment.EquipmentContainer rdf:resource="_subnetwork_350063"/>
//    <cim:PhaseConnection rdf:resource="http://iec.ch/TC57/2010/CIM-schema-cim15#PhaseShuntConnectionKind.Y"/>
//</cim:EnergyConsumer>
case class Consumer (override val id: String, override val name: String, override val location: String, override val container: String, val typ: String, val voltage: String, val phase: String) extends LocatedElement (id, name, location, container)

object Consumer extends Parser
{
    val typex = Pattern.compile ("""<cim:PowerSystemResource.PSRType\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
    val volex = Pattern.compile ("""<cim:ConductingEquipment.BaseVoltage\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
    val fazex = Pattern.compile ("""<cim:PhaseConnection\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")

    def typ = Element.parse_attribute (typex, 2, "type", true)_
    def vol = Element.parse_attribute (volex, 2, "voltage", true)_
    def faz = Element.parse_attribute (fazex, 2, "phase", true)_
    override def steps () = Array (LocatedElement.parse, typ, vol, faz)
    def unpickle (xml: String, result: Result): Consumer =
    {
        parse (xml, result)
        val ret = Consumer (result.properties ("id"), result.properties ("name"), result.properties ("location"), result.properties ("container"), result.properties ("type"), result.properties ("voltage"), result.properties ("phase"))
        return (ret)
    }
}

//<cim:Terminal rdf:ID="_house_connection_1469932_terminal">
//    <cim:IdentifiedObject.name>HAS1_terminal</cim:IdentifiedObject.name>
//    <cim:Terminal.sequenceNumber>1</cim:Terminal.sequenceNumber>
//    <cim:Terminal.phases rdf:resource="http://iec.ch/TC57/2010/CIM-schema-cim15#PhaseCode.ABC"/>
//    <cim:Terminal.ConnectivityNode rdf:resource="#_node_1469932"/>
//    <cim:Terminal.ConductingEquipment rdf:resource="#_house_connection_1469932"/>
//</cim:Terminal>

case class Terminal (override val id: String, override val name: String, val sequence: String, val phase: String, val connectivity: String, val equipment: String) extends PowerSystemResource (id, name)

object Terminal extends Parser
{
    val seqex = Pattern.compile ("""<cim:Terminal.sequenceNumber>([\s\S]*?)<\/cim:Terminal.sequenceNumber>""")
    val fazex = Pattern.compile ("""<cim:Terminal.phases\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
    val conex = Pattern.compile ("""<cim:Terminal.ConnectivityNode\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
    val eqpex = Pattern.compile ("""<cim:Terminal.ConductingEquipment\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")

    def seq = Element.parse_element (seqex, 1, "sequence", true)_
    def faz = Element.parse_attribute (fazex, 2, "phase", true)_
    def con = Element.parse_attribute (conex, 2, "connectivity", false)_  // allow for unconnected terminals
    def eqp = Element.parse_attribute (eqpex, 2, "equipment", true)_
    override def steps () = Array (NamedElement.parse, seq, faz, con, eqp)
    def unpickle (xml: String, result: Result): Terminal =
    {
        parse (xml, result)
        // allow for unconnected terminals
        val con = result.properties.get ("connectivity") match
        {
            case Some (value) ⇒ value
            case None ⇒ null
        }
        val ret = Terminal (result.properties ("id"), result.properties ("name"), result.properties ("sequence"), result.properties ("phase"), con, result.properties ("equipment"))
        return (ret)
    }
}

//        <cim:BusbarInfo rdf:ID="_busbar_spec_566593648">
//                <cim:IdentifiedObject.name>unbekannt EWS</cim:IdentifiedObject.name>
//        </cim:BusbarInfo>

case class BusbarInfo (override val id: String, override val name: String) extends PowerSystemResource (id, name)

object BusbarInfo extends Parser
{
    override def steps () = Array (NamedElement.parse)
    def unpickle (xml: String, result: Result): BusbarInfo =
    {
        parse (xml, result)
        val ret = BusbarInfo (result.properties apply "id", result.properties apply "name")
        return (ret)
    }
}

//<cim:BusbarSection rdf:ID="_busbar_1772383">
//    <cim:IdentifiedObject.name>SAM143</cim:IdentifiedObject.name>
//    <cim:PowerSystemResource.Location>_location_1610657792_427078125_1772388</cim:PowerSystemResource.Location>
//    <cim:PowerSystemResource.PSRType rdf:resource="#PSRType_Substation"/>
//    <cim:ConductingEquipment.BaseVoltage rdf:resource="#BaseVoltage_0.400000000000"/>
//    <cim:Equipment.EquipmentContainer rdf:resource="_subnetwork_858945"/>
//</cim:BusbarSection>

case class BusbarSection (override val id: String, override val name: String, override val location: String, override val container: String, val typ: String, val voltage: String) extends LocatedElement (id, name, location, container)

object BusbarSection extends Parser
{
    val typex = Pattern.compile ("""<cim:PowerSystemResource.PSRType\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
    val volex = Pattern.compile ("""<cim:ConductingEquipment.BaseVoltage\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")

    def typ = Element.parse_attribute (typex, 2, "type", true)_
    def vol = Element.parse_attribute (volex, 2, "voltage", true)_
    override def steps () = Array (LocatedElement.parse, typ, vol)
    def unpickle (xml: String, result: Result): BusbarSection =
    {
        parse (xml, result)
        BusbarSection (result.properties ("id"), result.properties ("name"), result.properties ("location"), result.properties ("container"), result.properties ("type"), result.properties ("voltage"))
    }
}

case class CableInfo (override val id: String, override val name: String) extends PowerSystemResource (id, name)

object CableInfo extends Parser
{
    override def steps () = Array (NamedElement.parse)
    def unpickle (xml: String, result: Result): CableInfo =
    {
        parse (xml, result)
        val ret = CableInfo (result.properties apply "id", result.properties apply "name")
        return (ret)
    }
}

//<cim:ACLineSegment rdf:ID="_internal_line_2094357">
//    <cim:IdentifiedObject.name>KLE8207</cim:IdentifiedObject.name>
//    <cim:PowerSystemResource.Location>_location_1610630656_427084375_2094361</cim:PowerSystemResource.Location>
//    <cim:Conductor.length>19.5</cim:Conductor.length>
//    <cim:PowerSystemResource.PSRType rdf:resource="#PSRType_Unknown"/>
//    <cim:ConductingEquipment.BaseVoltage rdf:resource="#BaseVoltage_0.400000000000"/>
//    <cim:Equipment.EquipmentContainer rdf:resource="_subnetwork_859028"/>
//</cim:ACLineSegment>

case class ACLineSegment (override val id: String, override val name: String, override val location: String, override val container: String, val typ: String, val length: String, val voltage: String) extends LocatedElement (id, name, location, container)

object ACLineSegment extends Parser
{
    val typex = Pattern.compile ("""<cim:PowerSystemResource.PSRType\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
    val lenex = Pattern.compile ("""<cim:Conductor.length>([\s\S]*?)<\/cim:Conductor.length>""")
    val volex = Pattern.compile ("""<cim:ConductingEquipment.BaseVoltage\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
    def typ = Element.parse_attribute (typex, 2, "type", true)_
    def len = Element.parse_element (lenex, 1, "length", true)_
    def vol = Element.parse_attribute (volex, 2, "voltage", true)_
    override def steps () = Array (LocatedElement.parse, typ, len, vol)
    def unpickle (xml: String, result: Result): ACLineSegment =
    {
        parse (xml, result)
        val ret = ACLineSegment (result.properties ("id"), result.properties ("name"), result.properties ("location"), result.properties ("container"), result.properties ("type"), result.properties ("length"), result.properties ("voltage"))
        return (ret)
    }
}

//<cim:ACLineSegmentPhase rdf:ID="_internal_line_2094357_phase_A">
//   <cim:IdentifiedObject.name>KLE8207_phase_A</cim:IdentifiedObject.name>
//   <cim:ACLineSegmentPhase.phase rdf:resource="http://iec.ch/TC57/2010/CIM-schema-cim15#SinglePhaseKind.A"/>
//   <cim:ACLineSegmentPhase.ACLineSegment rdf:resource="_internal_line_2094357"/>
//</cim:ACLineSegmentPhase>

case class ACLineSegmentPhase (override val id: String, override val name: String, val phase: String, val segment: String) extends PowerSystemResource (id, name)

object ACLineSegmentPhase extends Parser
{
    val fazex = Pattern.compile ("""<cim:ACLineSegmentPhase.phase\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
    val segex = Pattern.compile ("""<cim:ACLineSegmentPhase.ACLineSegment\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
    def faz = Element.parse_attribute (fazex, 2, "phase", true)_
    def seg = Element.parse_attribute (segex, 2, "segment", true)_
    override def steps () = Array (NamedElement.parse, faz, seg)
    def unpickle (xml: String, result: Result): ACLineSegmentPhase =
    {
        parse (xml, result)
        val ret = ACLineSegmentPhase (result.properties apply "id", result.properties apply "name", result.properties apply "phase", result.properties apply "segment")
        return (ret)
    }
}

//        <cim:SwitchInfo rdf:ID="_switch_spec_566593661">
//                <cim:IdentifiedObject.name>G4</cim:IdentifiedObject.name>
//        </cim:SwitchInfo>

case class SwitchInfo (override val id: String, override val name: String) extends PowerSystemResource (id, name)

object SwitchInfo extends Parser
{
    override def steps () = Array (NamedElement.parse)
    def unpickle (xml: String, result: Result): SwitchInfo =
    {
        parse (xml, result)
        val ret = SwitchInfo (result.properties apply "id", result.properties apply "name")
        return (ret)
    }
}

//    <cim:LoadBreakSwitch rdf:ID="_switch_1977502">
//            <cim:IdentifiedObject.name>TEI568</cim:IdentifiedObject.name>
//            <cim:PowerSystemResource.Location>_location_1610720512_427087414_1977506</cim:PowerSystemResource.Location>
//            <cim:Switch.normalOpen>false</cim:Switch.normalOpen>
//            <cim:PowerSystemResource.PSRType rdf:resource="#PSRType_Substation"/>
//            <cim:Equipment.EquipmentContainer rdf:resource="_substation_251865"/>
//    </cim:LoadBreakSwitch>

case class Switch (override val id: String, override val name: String, override val location: String, override val container: String, val normalOpen: Boolean, val typ: String) extends LocatedElement (id, name, location, container)

object Switch extends Parser
{
    val typex = Pattern.compile ("""<cim:PowerSystemResource.PSRType\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
    val opnex = Pattern.compile ("""<cim:Switch.normalOpen>([\s\S]*?)<\/cim:Switch.normalOpen>""")
    def opn = Element.parse_element (opnex, 1, "normalOpen", true)_
    def typ = Element.parse_attribute (typex, 2, "type", true)_
    override def steps () = Array (LocatedElement.parse, opn, typ)
    def unpickle (xml: String, result: Result): Switch =
    {
        parse (xml, result)
        try
        {
            val open = (result.properties ("normalOpen")).toBoolean
            val ret = Switch (result.properties ("id"), result.properties ("name"), result.properties ("location"), result.properties ("container"), open, result.properties ("type"))
            return (ret)
        }
        catch
        {
            case iae: IllegalArgumentException ⇒ throw new Exception ("unparsable boolean value found for a normalOpen element while parsing at line " + result.context.line_number ())
        }
    }
}

//        <cim:PowerTransformerInfo rdf:ID="_power_transformer_2083545">
//                <cim:IdentifiedObject.name>Rauscher + Stöckli 100 kVA</cim:IdentifiedObject.name>
//                <cim:PowerTransformerInfo.TransformerTankInfo rdf:resource="#_power_xfrmr_spec_2083545"/>
//        </cim:PowerTransformerInfo>
case class PowerTransformerInfo (override val id: String, override val name: String, val info: String) extends PowerSystemResource (id, name)

object PowerTransformerInfo extends Parser
{
    val infex = Pattern.compile ("""<cim:PowerTransformerInfo.TransformerTankInfo\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")

    def inf = Element.parse_attribute (infex, 2, "info", true)_
    override def steps () = Array (NamedElement.parse, inf)
    def unpickle (xml: String, result: Result): PowerTransformerInfo =
    {
        parse (xml, result)
        val ret = PowerTransformerInfo (result.properties ("id"), result.properties ("name"), result.properties ("info"))
        return (ret)
    }
}

//        <cim:TransformerTankInfo rdf:ID="_power_xfrmr_spec_2083545">
//                <cim:IdentifiedObject.name>Rauscher + Stöckli 100 kVA tank</cim:IdentifiedObject.name>
//                <cim:TransformerTankInfo.PowerTransformerInfo rdf:resource="#_power_transformer_2083545"/>
//        </cim:TransformerTankInfo>

case class TransformerTankInfo (override val id: String, override val name: String, val info: String) extends PowerSystemResource (id, name)

object TransformerTankInfo extends Parser
{
    val infex = Pattern.compile ("""<cim:TransformerTankInfo.PowerTransformerInfo\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")

    def inf = Element.parse_attribute (infex, 2, "info", true)_
    override def steps () = Array (NamedElement.parse, inf)
    def unpickle (xml: String, result: Result): TransformerTankInfo =
    {
        parse (xml, result)
        val ret = TransformerTankInfo (result.properties ("id"), result.properties ("name"), result.properties ("info"))
        return (ret)
    }
}

//        <cim:TransformerEndInfo rdf:ID="_power_transformer_2083545_end_info_1">
//                <cim:IdentifiedObject.name>Rauscher + Stöckli 100 kVA_tei_1</cim:IdentifiedObject.name>
//                <cim:TransformerEndInfo.endNumber>1</cim:TransformerEndInfo.endNumber>
//        </cim:TransformerEndInfo>
case class TransformerEndInfo (override val id: String, override val name: String, val end: Integer) extends PowerSystemResource (id, name)

object TransformerEndInfo extends Parser
{
    val numex = Pattern.compile ("""<cim:TransformerEndInfo.endNumber>([\s\S]*?)<\/cim:TransformerEndInfo.endNumber>""")

    def end = Element.parse_element (numex, 1, "end", true)_
    override def steps () = Array (NamedElement.parse, end)
    def unpickle (xml: String, result: Result): TransformerEndInfo =
    {
        parse (xml, result)
        val end = result.properties ("end")
        try
        {
            val num = end.toInt
            val ret = TransformerEndInfo (result.properties ("id"), result.properties ("name"), num)
            return (ret)
        }
        catch
        {
            case nfe: NumberFormatException ⇒ throw new Exception ("unparsable end value found for a transformer end info element while parsing at line " + result.context.line_number ())
        }
    }
}

//        <cim:PowerTransformer rdf:ID="_transformer_2083545">
//                <cim:IdentifiedObject.name>TRA79</cim:IdentifiedObject.name>
//                <cim:PowerSystemResource.Location>_location_1610630656_427085543_2083549</cim:PowerSystemResource.Location>
//                <cim:PowerSystemResource.PSRType rdf:resource="#PSRType_Unknown"/>
//                <cim:Equipment.EquipmentContainer rdf:resource="#_substation_244441"/>
//        </cim:PowerTransformer>

case class PowerTransformer (override val id: String, override val name: String, override val location: String, override val container: String, val typ: String) extends LocatedElement (id, name, location, container)

object PowerTransformer extends Parser
{
    val typex = Pattern.compile ("""<cim:PowerSystemResource.PSRType\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")

    def typ = Element.parse_attribute (typex, 2, "type", true)_
    override def steps () = Array (LocatedElement.parse, typ)
    def unpickle (xml: String, result: Result): PowerTransformer =
    {
        parse (xml, result)
        val ret = PowerTransformer (result.properties ("id"), result.properties ("name"), result.properties ("location"), result.properties ("container"), result.properties ("type"))
        return (ret)
    }
}

//       <cim:TransformerTank rdf:ID="_transformer_2083545_tank">
//                <cim:IdentifiedObject.name>TRA79_tank</cim:IdentifiedObject.name>
//                <cim:TransformerTank.PowerTransformer rdf:resource="#_transformer_2083545"/>
//        </cim:TransformerTank>
case class TransformerTank (override val id: String, override val name: String, val transformer: String) extends PowerSystemResource (id, name)

object TransformerTank extends Parser
{
    val traex = Pattern.compile ("""<cim:TransformerTank.PowerTransformer\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")

    def tra = Element.parse_attribute (traex, 2, "transformer", true)_
    override def steps () = Array (NamedElement.parse, tra)
    def unpickle (xml: String, result: Result): TransformerTank =
    {
        parse (xml, result)
        val ret = TransformerTank (result.properties ("id"), result.properties ("name"), result.properties ("transformer"))
        return (ret)
    }
}

//        <cim:TransformerTankEnd rdf:ID="_transformer_2083545_tank_end_1">
//                <cim:TransformerEnd.endNumber>1</cim:TransformerEnd.endNumber>
//                <cim:IdentifiedObject.name>TRA79_tank_end_1</cim:IdentifiedObject.name>
//                <cim:TransformerTankEnd.phases rdf:resource="http://iec.ch/TC57/2010/CIM-schema-cim15#PhaseCode.ABC"/>
//                <cim:TransformerTankEnd.TransformerTank rdf:resource="#_transformer_2083545_tank"/>
//                <cim:TransformerEnd.Terminal rdf:resource="#_transformer_2083545_terminal_1"/>
//                <cim:TransformerEnd.BaseVoltage rdf:resource="#BaseVoltage_16.0000000000"/>
//        </cim:TransformerTankEnd>
case class TransformerTankEnd (override val id: String, override val name: String, val end: Integer, val phases: String, val tank: String, val terminal: String, val voltage: String) extends PowerSystemResource (id, name)

object TransformerTankEnd extends Parser
{
    val endex = Pattern.compile ("""<cim:TransformerEnd.endNumber>([\s\S]*?)<\/cim:TransformerEnd.endNumber>""")
    val fazex = Pattern.compile ("""<cim:TransformerTankEnd.phases\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
    val tnkex = Pattern.compile ("""<cim:TransformerTankEnd.TransformerTank\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
    val trmex = Pattern.compile ("""<cim:TransformerEnd.Terminal\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
    val volex = Pattern.compile ("""<cim:TransformerEnd.BaseVoltage\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")

    def end = Element.parse_element (endex, 1, "end", true)_
    def faz = Element.parse_attribute (fazex, 2, "phases", true)_
    def tnk = Element.parse_attribute (tnkex, 2, "tank", true)_
    def trm = Element.parse_attribute (trmex, 2, "terminal", true)_
    def vol = Element.parse_attribute (volex, 2, "voltage", true)_
    override def steps () = Array (NamedElement.parse, end, faz, tnk, trm, vol)
    def unpickle (xml: String, result: Result): TransformerTankEnd =
    {
        parse (xml, result)
        val end = result.properties ("end")
        try
        {
            val num = end.toInt
            val ret = TransformerTankEnd (result.properties ("id"), result.properties ("name"), num, result.properties ("phases"), result.properties ("tank"), result.properties ("terminal"), result.properties ("voltage"))
            return (ret)
        }
        catch
        {
            case nfe: NumberFormatException ⇒ throw new Exception ("unparsable end value found for a tanke end element while parsing at line " + result.context.line_number ())
        }
    }
}

//<cim:ServiceLocation rdf:ID="_ao_902716339">
//    <cim:IdentifiedObject.name>HAS14</cim:IdentifiedObject.name>
//    <cim:ServiceLocation.device>_house_connection_1469992</cim:ServiceLocation.device>
//</cim:ServiceLocation>
case class ServiceLocation (override val id: String, override val name: String, val device: String) extends NamedElement (id, name)

object ServiceLocation extends Parser
{
    val devex = Pattern.compile ("""<cim:ServiceLocation.device>([\s\S]*?)<\/cim:ServiceLocation.device>""")

    def dev = Element.parse_element (devex, 1, "device", true)_
    override def steps () = Array (NamedElement.parse, dev)
    def unpickle (xml: String, result: Result): ServiceLocation =
    {
        parse (xml, result)

        val ret = ServiceLocation (result.properties ("id"), result.properties ("name"), result.properties ("device"))
        return (ret)
    }
}

//<cim:Customer rdf:ID="_customer_1845515577">
//    <cim:IdentifiedObject.name>HAS14_1</cim:IdentifiedObject.name>
//    <cim:Customer.kind rdf:resource="http://iec.ch/TC57/2010/CIM-schema-cim15#CustomerKind.residential"/>
//    <cim:Customer.locale>fr_CH</cim:Customer.locale>
//    <cim:Customer.service>_ao_902716339</cim:Customer.service>
//</cim:Customer>
case class Customer (override val id: String, override val name: String, val kind: String, val locale: String, val service: String) extends NamedElement (id, name)

object Customer extends Parser
{
    val kinex = Pattern.compile ("""<cim:Customer.kind\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
    val locex = Pattern.compile ("""<cim:Customer.locale>([\s\S]*?)<\/cim:Customer.locale>""")
    val serex = Pattern.compile ("""<cim:Customer.service>([\s\S]*?)<\/cim:Customer.service>""")

    def kind = Element.parse_attribute (kinex, 2, "kind", true)_
    def loc = Element.parse_element (locex, 1, "locale", true)_
    def serv = Element.parse_element (serex, 1, "service", true)_
    override def steps () = Array (NamedElement.parse, kind, loc, serv)
    def unpickle (xml: String, result: Result): Customer =
    {
        parse (xml, result)
        val ret = Customer (result.properties ("id"), result.properties ("name"), result.properties ("kind"), result.properties ("locale"), result.properties ("service"))
        return (ret)
    }
}

class CIM (var xml:String)
{
    val matcher = CIM.rddex.matcher (xml)
    val context = new Context (0, 0, ArrayBuffer (0))
    context.index_string (xml, context.start)
    val result = new Result (context)

    var key: String = "";
    var value: Element = null;

    def parse_one (): Boolean =
    {
        var ret = false

        if (matcher.find ())
        {
            val name = matcher.group (1)
            val rest = matcher.group (2)
            val element = name match
            {
                case "cim:PSRType" ⇒ PSRType.unpickle (rest, result)
                case "cim:Line" ⇒ Line.unpickle (rest, result)
                case "cim:Substation" ⇒ Subnetwork.unpickle (rest, result)
                case "cim:ConnectivityNode" ⇒ ConnectivityNode.unpickle (rest, result)
                case "cim:BaseVoltage" ⇒ Voltage.unpickle (rest, result)
                case "cim:CoordinateSystem" ⇒ CoordinateSystem.unpickle (rest, result)
                case "cim:Location" ⇒ Location.unpickle (rest, result)
                case "cim:PositionPoint" ⇒ PositionPoint.unpickle (rest, result);
                case "cim:Asset" ⇒ Asset.unpickle (rest, result)
                case "cim:EnergyConsumer" ⇒ Consumer.unpickle (rest, result)
                case "cim:Terminal" ⇒ Terminal.unpickle (rest, result)
                case "cim:BusbarInfo" ⇒ BusbarInfo.unpickle (rest, result)
                case "cim:BusbarSection" ⇒ BusbarSection.unpickle (rest, result)
                case "cim:CableInfo" ⇒ CableInfo.unpickle (rest, result)
                case "cim:ACLineSegment" ⇒ ACLineSegment.unpickle (rest, result)
                case "cim:ACLineSegmentPhase" ⇒ ACLineSegmentPhase.unpickle (rest, result)
                case "cim:SwitchInfo" ⇒ SwitchInfo.unpickle (rest, result)
                case "cim:LoadBreakSwitch" ⇒ Switch.unpickle (rest, result)
                case "cim:PowerTransformerInfo" ⇒ PowerTransformerInfo.unpickle (rest, result)
                case "cim:TransformerTankInfo" ⇒ TransformerTankInfo.unpickle (rest, result)
                case "cim:TransformerEndInfo" ⇒ TransformerEndInfo.unpickle (rest, result)
                case "cim:PowerTransformer" ⇒ PowerTransformer.unpickle (rest, result)
                case "cim:TransformerTank" ⇒ TransformerTank.unpickle (rest, result)
                case "cim:TransformerTankEnd" ⇒ TransformerTankEnd.unpickle (rest, result)

                case "cim:ServiceLocation" ⇒ ServiceLocation.unpickle (rest, result)
                case "cim:Customer" ⇒ Customer.unpickle (rest, result)

                case _ ⇒ Unknown.unpickle (rest, result)
            }
            key = element.key
            value = element

            // set up for next parse
            result.properties = new HashMap[String, String] ()
            context.end = matcher.end ()

            ret = true
        }

        return (ret)
    }

    def parse (): HashMap[String, Element] =
    {
        val ret = HashMap[String, Element] ()

        while (parse_one ())
            ret.put (key, value)

        return (ret)
    }
}

object CIM
{
    val CHUNK = 1024*1024*16
    val OVERREAD = 2048 // should be large enough that no RDF element is bigger than this
    val rddex = Pattern.compile ("""\s*<(cim:[^ >\s]+)([\s\S]*?)<\/\1>\s*""") // important to consume leading and trailing whitespace

// fast ~ 0.55 seconds, but this fails in the scala-shell of Spark (for non-trivial files):
//                val source = scala.io.Source.fromFile (args (0))
//                val xml = try source.mkString finally source.close ()

//            var xml = ""
// slow 17 seconds      xml = xml + buf.view (0, i).mkString
// slow 2 seconds       xml = xml + String.valueOf (buf.slice (0, i))
// OK 0.83 seconds:
//            val sb = new StringBuilder (size)
//            do
//            {
//                i = isr.read (buf, 0, CHUNK)
//                if (0 < i)
//                    sb.appendAll (buf, 0, i)
//            }

    def read (filename: String, offset: Long, size: Long = CHUNK, overread: Long = OVERREAD): String =
    {
        var ret: String = null

        val file = new File (filename)
        if (file.exists ()) // avoid FileNotFoundException
        {
            val fis = new FileInputStream (file)
            val isr = new InputStreamReader (fis, "UTF8")
            val skipped = isr.skip (offset)
            if (offset == skipped)
            {
                val buf = new Array[Char] (CHUNK)
                val sb = new StringBuilder (if (size > Int.MaxValue) Int.MaxValue else size.asInstanceOf[Int])
                var count:Long = 0
                var stop = false
                do
                {
                    val max = size + overread - count
                    val actual = isr.read (buf, 0, if (max > CHUNK) CHUNK else max.asInstanceOf[Int])
                    if (0 < actual)
                    {
                        sb.appendAll (buf, 0, actual)
                        count += actual
                    }
                    else
                        stop = true
                }
                while (!stop && (count < size + overread))
                isr.close ()
                ret = sb.toString ()
            }
            else
                println ("CIM XML input file cannot be skipped to offset " + offset + ", actual " + skipped)
        }
        else
            println ("CIM XML input file '" + filename + "' not found")

        return (ret)
    }

    def main (args: Array[String])
    {
        if (args.size > 0)
        {
            val filename = args (0)
            val fis = new FileInputStream (filename)
            val size = fis.available ()
            fis.close ();
            val start = System.nanoTime
            val xml = read (filename, 0, size)
            val before = System.nanoTime
            val reading = (before - start) / 1000
            println ("reading %g seconds".format (reading / 1e6))

            val parser = new CIM (xml)
            val map = parser.parse ()

            val after = System.nanoTime
            val parsing = (after - before) / 1000
            println ("parsing %g seconds".format (parsing / 1e6))

            println (map.size + " identified elements parsed")
            val subset = map.filter (_._2.getClass() == classOf[Unknown])
            println (subset.size + " unknown elements")
        }
        else
            println ("CIM XML input file not specified")
    }
}


