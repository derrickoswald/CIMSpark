package ch.ninecode

import java.io._
import java.lang.NumberFormatException
import java.util.regex.Pattern

import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.HashMap
import scala.collection.mutable.HashSet

trait Parser
{
    def parse (xml: String, context: Context, result: Result): Unit
}

class Result
{
    val PowerSystemResourceTypes = HashMap[String, PSRType] ()
    val PowerSystemResources = HashMap[String, Element] ()
    val ConnectivityNodes = HashMap[String, ConnectivityNode] ()
    val Containers = HashMap[String, Container] ()
    val Voltages = HashMap[String, Voltage] ()
    val Ignored = HashMap[String, Element] ()
}

class Element() extends Parser
{
    val properties: HashMap[String, String] = new HashMap[String, String]

    override def parse(xml: String, context: Context, result: Result): Unit =
    {
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
                case _ ⇒ new Element()
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
