package ch.ninecode

import java.lang.NumberFormatException
import java.util.regex.Pattern

import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.HashMap
import scala.collection.mutable.HashSet

trait Parser
{
    def parse (xml: String, context: Context, result: Result): Unit =
    {
        // default implementation does nothing at the moment
    }
}

class Result
{
    val PowerSystemResourceTypes = HashMap[String, PSRType] ()
    val PowerSystemResources = HashMap[String, Element] ()
    val ConnectivityNodes = HashMap[String, ConnectivityNode] ()
    val Containers = HashMap[String, Container] ()
    val Voltages = HashMap[String, Voltage] ()
    var Ignored = 0
}

abstract class Element () extends Parser
{
    val properties: HashMap[String, String] = new HashMap[String, String]

    /**
     * Extract and store a property function generator.
     *
     * Using the provided regular expression, parse out the value of the given property
     * which has the given group index and store it under the property name provided.
     * Complain with an exception if the property is not found and mandatory is true.
     *
     * Curry the function with a string to parse and the parsing context.
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
     * @param result The current parse partial result.
     */
    def parse_property (regex: Pattern, index: Int, name: String, mandatory: Boolean)(xml: String, context: Context, result: Result): Unit =
    {
        val value = Element.parse_attribute (regex, index, xml, context);
        if (null != value)
            properties.put (name, value)
        else
            if (mandatory)
                throw new Exception ("mandatory " + name + " value not found while parsing at line " + context.line_number (context.end))
    }
}

object Element
{
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
        val optional = true;

        var ret:String = null
        val matcher = pattern.matcher (xml)
        if (matcher.find ())
            ret = matcher.group (index)
        else
            if (!optional)
                throw new Exception ("regular expression " + pattern.toString () + " not found while parsing at line " + context.line_number (context.end))

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
}

class Unknown extends Element
{
    override def parse(xml: String, context: Context, result: Result): Unit =
    {
        super.parse (xml, context, result)
        result.Ignored = result.Ignored + 1
    }
}

class IdentifiedElement extends Element
{
    def id () = properties apply "id"

    override def parse(xml: String, context: Context, result: Result): Unit =
    {
        super.parse (xml, context, result)
        val id = IdentifiedElement.parse_id (xml, context)
        if (null != id)
        {
            properties.put ("id", id)
            result.PowerSystemResources += (id -> this)
        }
        else
            throw new Exception ("no id found for an identified element while parsing at line " + context.line_number (context.end))
    }
}

object IdentifiedElement
{
    val idex = Pattern.compile ("""rdf:ID=("|')([\s\S]*?)\1""")

    /**
     * Extract an id (rdf:ID value) from an XML string.
     * @param xml the text to parse
     * @param the context for the substring in the XML and
     * line number and position context for reporting in case of an error
     * @return the id value
     */
    def parse_id (xml: String, context: Context): String =
        return (Element.parse_attribute (idex, 2, xml, context))
}

class NamedElement extends IdentifiedElement
{
    def name () = properties apply "name"

    override def parse (xml: String, context: Context, result: Result): Unit =
    {
        super.parse (xml, context, result)
        val name = NamedElement.parse_name (xml, context)
        if (null != name)
            properties.put ("name", name)
        else
            throw new Exception ("no name found for a named element while parsing at line " + context.line_number (context.end))
    }
}

object NamedElement
{
    val namex = Pattern.compile ("""<cim:IdentifiedObject.name>([\s\S]*?)<\/cim:IdentifiedObject.name>""")

    /**
     * Extract the name (cim:IdentifiedObject.name value) from an XML string.
     * @param xml the text to parse
     * @param the context for the substring in the XML and
     * line number and position context for reporting in case of an error
     * @return the name
     */
    def parse_name (xml: String, context: Context): String =
        return (Element.parse_element (namex, 1, xml, context))
}

//        <cim:PSRType rdf:ID="PSRType_Substation">
//                <cim:IdentifiedObject.name>Substation</cim:IdentifiedObject.name>
//        </cim:PSRType>
class PSRType extends NamedElement
{
    override def parse (xml: String, context: Context, result: Result): Unit =
    {
        super.parse (xml, context, result)
        result.PowerSystemResourceTypes += (id -> this)
    }
}

//        <cim:Line rdf:ID="_subnetwork_349554">
//                <cim:IdentifiedObject.name>ABG2236|ABG7246|APP197|FLT13|FLU20|FLU21|FLU22|FLU23|HAS332|HAS333|HAS334|HAS335|MUF2681|MUF2682|PIN2</cim:IdentifiedObject.name>
//        </cim:Line>
class Container extends NamedElement
{
    val contents = HashSet[String] ()

    /**
     * Forward reference constructor.
     *
     * Used when there is a forward reference to a container that has not yet been parsed.
     * @param identifier the id (rdf:ID) of the container, i.e. the forward reference
     */
    def this (identifier: String)
    {
        this
        properties.put ("id", identifier)
    }

    override def parse (xml: String, context: Context, result: Result): Unit =
    {
        super.parse (xml, context, result)
        val node = result.Containers getOrElseUpdate (id, this)
        // check for forward reference definition and copy any references seen so far
        if (this != node)
        {
            contents ++= node.contents
            result.Containers.update (id, this) // replace with this Container
        }
    }
}

//        <cim:ConnectivityNode rdf:ID="_pin_1555069">
//                <cim:IdentifiedObject.name>PIN2</cim:IdentifiedObject.name>
//                <cim:ConnectivityNode.ConnectivityNodeContainer rdf:resource="_subnetwork_349554"/>
//        </cim:ConnectivityNode>
class ConnectivityNode extends NamedElement
{
    override def parse (xml: String, context: Context, result: Result): Unit =
    {
        super.parse (xml, context, result)
        result.ConnectivityNodes += (id -> this) // ToDo: or update?
        val container = ConnectivityNode.parse_connectivity (xml, context)
        if (null != container)
        {
            properties.put ("container", container)
            val node = result.Containers getOrElseUpdate (container, new Container (container))
            node.contents += id
        }
        else
            throw new Exception ("no container found for a connectivity element while parsing at line " + context.line_number (context.end))
    }
}

object ConnectivityNode
{
    val connex = Pattern.compile ("""<cim:ConnectivityNode.ConnectivityNodeContainer\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")

    def parse_connectivity (xml: String, context: Context): String =
        return (Element.parse_attribute (connex, 2, xml, context))
}

//        <cim:BaseVoltage rdf:ID="BaseVoltage_0.400000000000">
//                <cim:IdentifiedObject.name>400.000 V</cim:IdentifiedObject.name>
//                <cim:BaseVoltage.nominalVoltage>0.400000000000</cim:BaseVoltage.nominalVoltage>
//        </cim:BaseVoltage>
class Voltage extends NamedElement
{
    def voltage () =
    {
        val v = properties apply "voltage"
        v.toDouble * 1000.0
    }

    override def parse (xml: String, context: Context, result: Result): Unit =
    {
        super.parse (xml, context, result)
        result.Voltages += (id -> this)
        val voltage = Voltage.parse_voltage (xml, context)
        if (null != voltage)
        {
            properties.put ("voltage", voltage)
            try
                voltage.toDouble
            catch
            {
                case nfe: NumberFormatException => throw new Exception ("unparsable voltage value found for a voltage element while parsing at line " + context.line_number (context.end))
            }
        }
        else
            throw new Exception ("no voltage value found for a voltage element while parsing at line " + context.line_number (context.end))
    }
}

object Voltage
{
    val voltex = Pattern.compile ("""<cim:BaseVoltage.nominalVoltage>([\s\S]*?)<\/cim:BaseVoltage.nominalVoltage>""")

    def parse_voltage (xml: String, context: Context): String =
        return (Element.parse_attribute (voltex, 1, xml, context))
}

class CoordinateSystem extends NamedElement
{
    def urn = properties apply "urn"

    override def parse (xml: String, context: Context, result: Result): Unit =
    {
        super.parse (xml, context, result)
        val urn = CoordinateSystem.parse_urn (xml, context)
        if (null != urn)
            properties.put ("urn", urn)
        else
            throw new Exception ("no urn value found for a coordinate system element while parsing at line " + context.line_number (context.end))
    }
}

object CoordinateSystem
{
    val urnex = Pattern.compile ("""<cim:crsUrn>([\s\S]*?)<\/cim:crsUrn>""")

    def parse_urn (xml: String, context: Context): String =
        return (Element.parse_attribute (urnex, 1, xml, context))
}

//    <cim:Location rdf:ID="_location_5773088_1107287243_317923">
//            <cim:Location.CoordinateSystem>wgs_84</cim:Location.CoordinateSystem>
//            <cim:Location.type>geographic</cim:Location.type>
//    </cim:Location>

class Location extends IdentifiedElement
{
    import Location._

    var coordinates = new ArrayBuffer[Double] (2)

    /**
     * Forward reference constructor.
     *
     * Used when there is a forward reference to a location that has not yet been parsed.
     * @param identifier the id (rdf:ID) of the location, i.e. the forward reference
     */
    def this (identifier: String)
    {
        this
        properties.put ("id", identifier)
    }

    def cs = parse_property (csex, 1, "cs", true)_
    def typ = parse_property (typex, 1, "type", true)_
    override def parse (xml: String, context: Context, result: Result): Unit =
    {
        super.parse (xml, context, result)
        cs (xml, context, result);
        typ (xml, context, result);
        val node = (result.PowerSystemResources getOrElseUpdate (id, this)).asInstanceOf [Location]
        // check for forward reference definition and copy any coordinates seen so far
        if (this != node)
        {
            coordinates ++= node.coordinates
            result.PowerSystemResources.update (id, this) // replace with this Location
        }
    }
}

object Location
{
    val csex = Pattern.compile ("""<cim:Location.CoordinateSystem>([\s\S]*?)<\/cim:Location.CoordinateSystem>""")
    val typex = Pattern.compile ("""<cim:Location.type>([\s\S]*?)<\/cim:Location.type>""")
}

//    <cim:PositionPoint>
//            <cim:PositionPoint.Location>_location_5773088_1107287243_317923</cim:PositionPoint.Location>
//            <cim:sequenceNumber>0</cim:sequenceNumber>
//            <cim:xPosition>8.78184724183</cim:xPosition>
//            <cim:yPosition>47.0400997930</cim:yPosition>
//    </cim:PositionPoint>

class PositionPoint extends Element
{
    import PositionPoint._

    override def parse (xml: String, context: Context, result: Result): Unit =
    {
        super.parse (xml, context, result)
        val location = Element.parse_attribute (locex, 1, xml, context)
        val sequence = Element.parse_attribute (seqex, 1, xml, context).toInt
        val x = Element.parse_attribute (xposex, 1, xml, context).toDouble
        val y = Element.parse_attribute (yposex, 1, xml, context).toDouble
        val loc = (result.PowerSystemResources getOrElseUpdate (location, new Location (location))).asInstanceOf[Location]
        val size = 2 * (sequence + 1)
        if (loc.coordinates.length < size)
            loc.coordinates = loc.coordinates.padTo (size, 0.0)
        loc.coordinates.update (sequence * 2, x)
        loc.coordinates.update (sequence * 2 + 1, y)
    }
}

object PositionPoint
{
    val locex = Pattern.compile ("""<cim:PositionPoint.Location>([\s\S]*?)<\/cim:PositionPoint.Location>""")
    val seqex = Pattern.compile ("""<cim:sequenceNumber>([\s\S]*?)<\/cim:sequenceNumber>""")
    val xposex = Pattern.compile ("""<cim:xPosition>([\s\S]*?)<\/cim:xPosition>""")
    val yposex = Pattern.compile ("""<cim:yPosition>([\s\S]*?)<\/cim:yPosition>""")
}

//<cim:Asset rdf:ID="_busbar_1772383_asset">
//<cim:Asset.type>Busbar</cim:Asset.type>
//<cim:IdentifiedObject.name>Busbar_SAM143</cim:IdentifiedObject.name>
//<cim:Asset.PowerSystemResources rdf:resource="#_busbar_1772383"/>
//<cim:Asset.AssetInfo rdf:resource="#_busbar_spec_566593648"/>
//</cim:Asset>
class Asset extends NamedElement
{
    import Asset._

    def typ = parse_property (typex, 1, "type", true)_
    def ass = parse_property (assex, 2, "asset", true)_
    def inf = parse_property (infox, 2, "info", true)_
    override def parse (xml: String, context: Context, result: Result): Unit =
    {
        super.parse (xml, context, result)
        typ (xml, context, result);
        ass (xml, context, result);
        inf (xml, context, result);
        // ToDo: check for forward reference definition and copy any data necessary
    }
}

object Asset
{
    val typex = Pattern.compile ("""<cim:Asset.type>([\s\S]*?)<\/cim:Asset.type>""")
    val assex = Pattern.compile ("""<cim:Asset.PowerSystemResources\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
    val infox = Pattern.compile ("""<cim:Asset.AssetInfo\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
}

//<cim:EnergyConsumer rdf:ID="_house_connection_1469932">
//    <cim:IdentifiedObject.name>HAS1</cim:IdentifiedObject.name>
//    <cim:PowerSystemResource.Location>_location_5773088_1107287243_317923</cim:PowerSystemResource.Location>
//    <cim:PowerSystemResource.PSRType rdf:resource="#PSRType_Unknown"/>
//    <cim:ConductingEquipment.BaseVoltage rdf:resource="#BaseVoltage_0.400000000000"/>
//    <cim:Equipment.EquipmentContainer rdf:resource="_subnetwork_350063"/>
//    <cim:PhaseConnection rdf:resource="http://iec.ch/TC57/2010/CIM-schema-cim15#PhaseShuntConnectionKind.Y"/>
//</cim:EnergyConsumer>
class Consumer extends NamedElement
{
    import Consumer._

    def container () = properties apply "container"


    // ToDo: some of these should be parse_attribute
    def typ = parse_property (typex, 2, "type", true)_
    def loc = parse_property (locex, 1, "location", true)_
    def vol = parse_property (volex, 2, "voltage", true)_
    def con = parse_property (conex, 2, "container", true)_
    def faz = parse_property (fazex, 2, "phase", true)_

    override def parse (xml: String, context: Context, result: Result): Unit =
    {
//      super.parse (xml, context, result)
//      typ (xml, context, result);
//      loc (xml, context, result);
//      vol (xml, context, result);
//      con (xml, context, result);
//      faz (xml, context, result);

        val steps = Array[(String, Context, Result) => Unit](
            super.parse,
            typ,
            loc,
            vol,
            con,
            faz
        )
        for (f <- steps)
            f (xml, context, result)
        val node = (result.PowerSystemResources getOrElseUpdate (container, new Container (container))).asInstanceOf [Container]
            node.contents += id
    }
}

object Consumer
{
    val typex = Pattern.compile ("""<cim:PowerSystemResource.PSRType\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
    val locex = Pattern.compile ("""<cim:PowerSystemResource.Location>([\s\S]*?)<\/cim:PowerSystemResource.Location>""")
    val volex = Pattern.compile ("""<cim:ConductingEquipment.BaseVoltage\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
    val conex = Pattern.compile ("""<cim:Equipment.EquipmentContainer\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
    val fazex = Pattern.compile ("""<cim:PhaseConnection\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
}

class CIM
{
    /*
     * THIS DOES NOT WORK !
     * Using scala.util.matching is a complete failure.
     * As near as I can tell, the regular expression is not compiled down into a state machine,
     * with concomitant performance issues.
import scala.util.matching._
    def parse2 (xml:String): HashMap[String, String] =
    {
        val regex = """\s*<(cim:[^ >\\s]+)([\s\S]*?)<\/\1>\s*""".r // .unanchored
        val regex = new Regex ("""\s*<(cim:[^ >\\s]+)([\s\S]*?)<\/\1>\s*""", "head", "guts")
        var ret = HashMap[String, String] ()

        val elements = regex findFirstIn xml

         val elements = for (m <- regex findAllMatchIn xml) yield m
         var count = elements.length

         (regex findAllMatchIn xml map (_.start)).toList

        val elements = for (m <- regex findAllIn xml) yield 1
        var count = elements.length

        val elements = regex findAllIn xml
        var count = elements.length

        while (elements.hasNext)
        {
            elements.next ()
            var id = parse_attribute ("rdf:ID=(\"|')([\\s\\S]*?)\\1", elements.group (2)) // /rdf:ID=("|')([\s\S]*?)\1/g
            if (null != id)
              ret += (id -> elements.group (2))
        }

        return (ret)
    }
    */

    def parse (xml:String): Result =
    {
        val matcher = CIM.rddex.matcher (xml)
        val context = new Context (0, 0, ArrayBuffer (0))
        context.index_string (xml, context.start)
        val result = new Result ()
        while (matcher.find ())
        {
            val name = matcher.group (1)
            val rest = matcher.group (2)
            val element = name match
            {
                case "cim:PSRType" ⇒ new PSRType ()
                case "cim:Line" ⇒ new Container () // type is lost
                case "cim:Substation" ⇒ new Container () // type is lost
                case "cim:ConnectivityNode" ⇒ new ConnectivityNode ()
                case "cim:BaseVoltage" ⇒ new Voltage ()
                case "cim:CoordinateSystem" ⇒ new CoordinateSystem ()
                case "cim:Location" ⇒ new Location ()
                case "cim:PositionPoint" ⇒ CIM.point
                case "cim:Asset" ⇒ new Asset ()
                case "cim:EnergyConsumer" ⇒ new Consumer ()
                case _ ⇒ CIM.unknown
            }
            element.parse (rest, context, result)
            context.end = matcher.end ()
        }

        return (result)
    }
}

object CIM
{

    val rddex = Pattern.compile ("""\s*<(cim:[^ >\s]+)([\s\S]*?)<\/\1>\s*""") // important to consume leading and trailing whitespace
    val point = new PositionPoint () // only one of these is required because it just updates the Location object it references
    val unknown = new Unknown ();
    def main (args: Array[String])
    {
        if (args.size > 0)
        {
            val start = System.nanoTime

            val source = scala.io.Source.fromFile (args (0))
            val xml = try source.mkString finally source.close ()

            val before = System.nanoTime
            val reading = (before - start) / 1000
            println ("reading %g seconds".format (reading / 1e6))

            val parser = new CIM ()
            val result = parser.parse (xml)

            val after = System.nanoTime
            val parsing = (after - before) / 1000
            println ("parsing %g seconds".format (parsing / 1e6))

            println (result.PowerSystemResources.size + " PowerSystemResource elements parsed")
            println (result.Ignored + " elements ignored")
        }
    }
}

// enable postfix operation with:   scala -language:postfixOps
// usage: CIM.main(Array[String]())
        // get the xml content from our sample file
//        val xml = XML.loadFile ("/home/derrick/Documents/9code/nis/cim/cim_export/dump_all.xml")
//        val temp = (xml \\ "CoordinateSystem" \\ "IdentifiedObject.name") text;
//        println ("coordinate system: " + temp)


// interactive creation of an RDD:
//
// needs /home/derrick/code/scala-xml/target/scala-2.11/scala-xml_2.11-1.0.6-SNAPSHOT.jar
//scala> import scala.xml.XML
//import scala.xml.XML
//
//scala> val xml = XML.loadFile ("/opt/cim_export/dump_all.xml")
//xml: scala.xml.Elem =
//<rdf:RDF xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#" xmlns:cim="http://iec.ch/TC57/2010/CIM-schema-cim15#" xmlns:dm="http://iec.ch/2002/schema/CIM_difference_model#">
//  <cim:PSRType rdf:ID="PSRType_Substation">
//    <cim:IdentifiedObject.name>Substation</cim:IdentifiedObject.name>
//  </cim:PSRType>
//  <cim:PSRType rdf:ID="PSRType_Underground">
//    <cim:IdentifiedObject.name>Underground</cim:IdentifiedObject.name>
//  </cim:PSRType>
//  <cim:PSRType rdf:ID="PSRType_Overhead">
//    <cim:IdentifiedObject.name>Overhead</cim:IdentifiedObject.name>
//  </cim:PSRType>
//  <cim:PSRType rdf:ID="PSRType_Unknown">
//    <cim:IdentifiedObject.name>Unknown</cim:IdentifiedObject.name>
//  </cim:PSRType>
//  <cim:CoordinateSystem rdf:ID="wgs_84">
//    <cim:IdentifiedObject.name>WGS 84</cim:IdentifiedObje...
//
// takes about 30 seconds
//
//scala> var myrdd = sc.parallelize (xml match { case <rdf:RDF>{ xs @ _* }</rdf:RDF> => xs })
//myrdd: org.apache.spark.rdd.RDD[scala.xml.Node] = ParallelCollectionRDD[0] at parallelize at <console>:24
//
//scala> myrdd.count ()
//res3: Long = 540367
//
//use 3 GB : spark-shell --master yarn-client --driver-memory 3g --executor-memory 1g --executor-cores 1
//otherwise
//XML.loadFile java.lang.OutOfMemoryError: Java heap space
