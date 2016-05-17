package ch.ninecode.model

import org.apache.spark.sql.Row

import java.lang.NumberFormatException
import java.util.regex.Pattern
import java.io.File
import java.io.FileInputStream
import java.io.IOException
import java.io.InputStreamReader
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.HashMap
import scala.collection.mutable.HashSet

import ch.ninecode.Context

trait Parser
{
    /**
     * Abstract parse function.
     * To be overridden in each implemented class.
     */
    def parse (context: Context): Element

    def element (name: String) = { print ("+"); (Pattern.compile ("""<cim:""" + name + """>([\s\S]*?)<\/cim:""" + name + """>"""), 1)}
    def attribute (name: String) = { print ("+"); (Pattern.compile ("""<cim:""" + name + """\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>"""), 2)}

    /**
     * Parse one XML element from a string.
     * @param pattern the regular expression pattern to look for
     * @param index the number of the capture group to extract from within the pattern
     * @param context the context for the substring in the XML and
     * line number and position context for reporting in case of an error
     * @return the matched group from the regular expression
     */
    def parse_element (pattern: Tuple2[Pattern, Int])(context: Context): String =
    {
        var ret:String = null
        val matcher = pattern._1.matcher (context.xml)
        if (matcher.find ())
            ret = matcher.group (pattern._2)

        return (ret)
    }

    /**
     * Parse one attribute from an XML string.
     * @param pattern the regular expression pattern to look for
     * @param index the number of the capture group to extract from within the pattern
     * @param context the context for the substring in the XML and
     * line number and position context for reporting in case of an error
     * @return the attribute value (with leading # stripped off)
     */
    def parse_attribute (pattern: Tuple2[Pattern, Int])(context: Context): String =
    {
        var ret = parse_element (pattern)(context)
        if ((null != ret) && ret.startsWith ("#")) // remove '#'
            ret = ret.substring (1)

        return (ret)
    }

    def toBoolean (string: String, context: Context): Boolean =
    {
        var ret = false

        if ((null != string) && ("" != string))
            try
            {
                ret = string.toBoolean
            }
            catch
            {
                case nfe: IllegalArgumentException ⇒ throw new Exception ("unparsable boolean (" + string + ") found while parsing at line " + context.line_number ())
            }

        return (ret);


    }

    def toInteger (string: String, context: Context): Integer =
    {
        var ret = 0

        if ((null != string) && ("" != string))
            try
            {
                ret = string.toInt
            }
            catch
            {
                case nfe: NumberFormatException ⇒ throw new Exception ("unparsable integer (" + string + ")found while parsing at line " + context.line_number ())
            }

        return (ret);
    }
}

/**
 * Top level element.
 */
class Element
(
    val sup: Element = null,
    val id: String = null
)
extends
    Row
with
    Serializable
with
    Cloneable
{
    def key: String = { if (null == sup) id else sup.key }
    def copy (): Row = { return (this.clone ().asInstanceOf[Element]); }
    override def get (i: Int): Any =
    {
        if (0 == i)
            sup
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    def length: Int = 2
}

object Element
extends
    Parser
{
    /**
     * Parse an element.
     * Simply extracts the id
     */
    val mRID = parse_element ((Pattern.compile ("""rdf:ID=("|')([\s\S]*?)\1"""), 2))_
    override def parse (context: Context): Element =
    {
        return (
            new Element
            (
                null,
                mRID (context)
            )
        )
    }

}

/**
 * Unknown element
 * Default parsed element, when no other more specific class applies
 */
case class Unknown (
    override val sup: Element,
    guts: String,
    line: Int,
    start: Long,
    end: Long
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[Unknown]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Unknown
extends
    Parser
{
    def parse (context: Context): Unknown =
    {
        val element = Element.parse (context)
        return (
            Unknown
            (
                element,
                context.xml,
                context.line_number (),
                context.start,
                context.end
            )
        )
    }
}

/**
 * Top level CIM object.
 */
case class IdentifiedObject
(
    override val sup: Element,
    val aliasName: String,
    val description: String,
    val mRID: String,
    val name: String
)
extends
    Element (sup)
{
    override def key: String = { if (null == sup) mRID else sup.key }
    override def copy (): Row = { return (this.clone ().asInstanceOf[IdentifiedObject]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object IdentifiedObject
extends
    Parser
{
    val aliasName = parse_element (element ("""IdentifiedObject.aliasName"""))_
    val description = parse_element (element ("""IdentifiedObject.description"""))_
    val name = parse_element (element ("""IdentifiedObject.name"""))_

    def parse (context: Context): IdentifiedObject =
    {
        val element = Element.parse (context)
        return (
            IdentifiedObject (
                element,
                aliasName (context),
                description (context),
                element.id,
                name (context)
            )
        )
    }
}

case class PSRType
(
    override val sup: Element
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[PSRType]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PSRType
extends
    Parser
{
    def parse (context: Context): PSRType =
    {
        return (
            PSRType
            (
                IdentifiedObject.parse (context)
            )
        )
    }
}

case class CoordinateSystem
(
    override val sup: Element,
    val crsUrn: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[CoordinateSystem]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CoordinateSystem
extends
    Parser
{
    val crsUrn = parse_element (element ("""CoordinateSystem.crsUrn"""))_

    def parse (context: Context): CoordinateSystem =
    {
        return (
            CoordinateSystem
            (
                IdentifiedObject.parse (context),
                crsUrn (context)
            )
        )
    }
}

case class ConnectivityNode
(
    override val sup: Element,
    val ConnectivityNodeContainer: String,
    val TopologicalNode: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[ConnectivityNode]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ConnectivityNode
extends
    Parser
{
    val ConnectivityNodeContainer = parse_attribute (attribute ("""ConnectivityNode.ConnectivityNodeContainer"""))_
    val TopologicalNode = parse_attribute (attribute ("""ConnectivityNode.TopologicalNode"""))_

    def parse (context: Context): ConnectivityNode =
    {
        return (
            ConnectivityNode
            (
                IdentifiedObject.parse (context),
                ConnectivityNodeContainer (context),
                TopologicalNode (context)
            )
        )
    }
}

case class ACDCTerminal
(
    override val sup: Element,
    val connected: Boolean,
    val sequenceNumber: Integer,
    val BusNameMarker: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[ACDCTerminal]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ACDCTerminal
extends
    Parser
{
    val connected = parse_attribute (attribute ("""ACDCTerminal.connected"""))_
    val sequenceNumber = parse_element (element ("""ACDCTerminal.sequenceNumber"""))_
    val BusNameMarker = parse_attribute (attribute ("""ACDCTerminal.BusNameMarker"""))_
    def parse (context: Context): ACDCTerminal =
    {
        return (
            ACDCTerminal
            (
                IdentifiedObject.parse (context),
                toBoolean (connected (context), context),
                toInteger (sequenceNumber (context), context),
                BusNameMarker (context)
            )
        )
    }
}

case class Terminal
(
    override val sup: Element,
    val phases: String,
    val Bushing: String,
    val ConductingEquipment: String,
    val ConnectivityNode: String,
    val SvPowerFlow: String,
    val TopologicalNode: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[Terminal]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Terminal
extends
    Parser
{
    val phases = parse_element (element ("""Terminal.phases"""))_
    val Bushing = parse_attribute (attribute ("""Terminal.Bushing"""))_
    val ConductingEquipment = parse_attribute (attribute ("""Terminal.ConductingEquipment"""))_
    val ConnectivityNode = parse_attribute (attribute ("""Terminal.ConnectivityNode"""))_
    val SvPowerFlow = parse_attribute (attribute ("""Terminal.SvPowerFlow"""))_
    val TopologicalNode = parse_attribute (attribute ("""Terminal.TopologicalNode"""))_
    def parse (context: Context): Terminal =
    {
        return (
            Terminal
            (
                ACDCTerminal.parse (context),
                phases (context),
                Bushing (context),
                ConductingEquipment (context),
                ConnectivityNode (context),
                SvPowerFlow (context),
                TopologicalNode (context)
            )
        )
    }
}

case class PowerSystemResource
(
    override val sup: Element,
    val AssetDataSheet: String,
    val Location: String,
    val PSRType: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[PowerSystemResource]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PowerSystemResource
extends
    Parser
{
    val AssetDataSheet = parse_attribute (attribute ("""PowerSystemResource.AssetDataSheet"""))_
    val Location = parse_attribute (attribute ("""PowerSystemResource.Location"""))_
    val PSRType = parse_attribute (attribute ("""PowerSystemResource.PSRType"""))_
    // ToDo: other relations and containments
    def parse (context: Context): PowerSystemResource =
    {
        return (
            PowerSystemResource
            (
                IdentifiedObject.parse (context),
                AssetDataSheet (context),
                Location (context),
                PSRType (context)
            )
        )
    }
}

case class ConnectivityNodeContainer
(
    override val sup: Element
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[ConnectivityNodeContainer]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ConnectivityNodeContainer
extends
    Parser
{
    def parse (context: Context): ConnectivityNodeContainer =
    {
        return (
            ConnectivityNodeContainer
            (
                PowerSystemResource.parse (context)
            )
        )
    }
}

case class EquipmentContainer
(
    override val sup: Element
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[EquipmentContainer]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EquipmentContainer
extends
    Parser
{
    def parse (context: Context): EquipmentContainer =
    {
        return (
            EquipmentContainer
            (
                ConnectivityNodeContainer.parse (context)
            )
        )
    }
}

case class Line
(
    override val sup: Element,
    val Region: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[Line]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Line
extends
    Parser
{
    val Region = parse_attribute (attribute ("""Line.Region"""))_
    def parse (context: Context): Line =
    {
        return (
            Line
            (
                ConnectivityNodeContainer.parse (context),
                Region (context)
            )
        )
    }
}

/**
 * Common Hierarchical Information Model
 * CIM classes for parsing RDF files.
 */
class CHIM (var xml:String, var start: Long = 0L, var end: Long = 0L)
{
    if (end == 0L)
        end = start + xml.length ()
    val matcher = CHIM.rddex.matcher (xml)
    val context = new Context (xml, start, start, ArrayBuffer (0L))
    context.index_string (xml, context.start)

    var value: Element = null;

    def progress (): Float =
    {
        (context.end - context.start).asInstanceOf[Float] / xml.length ().asInstanceOf[Float]
    }

    def parse_one (): Boolean =
    {
        var ret = false
        var found = false
        if (context.end < end)
            while (!found && matcher.find ())
            {
                val name = matcher.group (1)
                // heuristic (along with the while and the 'not a dot' in rddex regular expression)
                // that allows jumping into the middle of a large file:
                // top level RDF elements do not have a period in their name
                if (!name.contains ('.'))
                {
                    context.xml = matcher.group (2)
                    val element = name match
                    {
                        case "cim:IdentifiedObject" ⇒ IdentifiedObject.parse (context)
                        case "cim:PSRType" ⇒ PSRType.parse (context)
                        case "cim:CoordinateSystem" ⇒ CoordinateSystem.parse (context)
                        case "cim:ConnectivityNode" ⇒ ConnectivityNode.parse (context)
                        case "cim:ACDCTerminal" ⇒ ACDCTerminal.parse (context)
                        case "cim:Terminal" ⇒ Terminal.parse (context)
                        case "cim:PowerSystemResource" ⇒ PowerSystemResource.parse (context)
                        case "cim:ConnectivityNodeContainer" ⇒ ConnectivityNodeContainer.parse (context)
                        case "cim:EquipmentContainer" ⇒ EquipmentContainer.parse (context)
                        case "cim:Line" ⇒ Line.parse (context)

                        case _ ⇒ Unknown.parse (context)
                    }
                    value = element

                    // return success unless there was unrecognized text before the match
                    // that wasn't at the start of the xml
                    ret = (context.end == (matcher.start () + context.start)) || (context.end == context.start)

                    // set up for next parse
                    context.end = matcher.end () + context.start
                    found = true
                }
            }

        return (ret)
    }

    def parse (): HashMap[String, Element] =
    {
        val ret = HashMap[String, Element] ()
var count = 0
        while (parse_one () && (count < 100))
        {
            ret.put (value.key, value)
            count += 1
        }

        return (ret)
    }
}
object CHIM
{
    val CHUNK = 1024*1024*128
    val OVERREAD = 2048 // should be large enough that no RDF element is bigger than this
    val rddex = Pattern.compile ("""\s*<(cim:[^>\.\s]+)([>\s][\s\S]*?)<\/\1>\s*""") // important to consume leading and trailing whitespace

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
                val sint: Int = if (size > Int.MaxValue) Int.MaxValue else size.asInstanceOf[Int]
                val sb = new StringBuilder (sint)
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

    /**
     * Main program for testing purposes.
     */
    def main (args: Array[String])
    {
        if (args.size > 0)
        {
            val filename = args (0)
            val fis = new FileInputStream (filename)
            val size = fis.available ()
            fis.close ();

            val result = new HashMap[String, Element]
            var offset = 0L
            var reading = 0.0
            var parsing = 0.0
            while (offset < size)
            {
                val start = System.nanoTime
                var xml = read (filename, offset)
                offset += CHUNK
                val before = System.nanoTime
                reading += (before - start) / 1000

                val parser = new CHIM (xml)
                xml = null
                val map = parser.parse ()
                result ++= map

                val after = System.nanoTime
                parsing += (after - before) / 1000
                print (".")
            }
            println ()

            println ("reading %g seconds".format (reading / 1e6))
            println ("parsing %g seconds".format (parsing / 1e6))
            println (result.size + " identified elements parsed")
            val subset = result.filter (_._2.getClass() == classOf[Unknown])
            println (subset.size + " unknown elements")
        }
        else
            println ("CIM XML input file not specified")
    }
}
