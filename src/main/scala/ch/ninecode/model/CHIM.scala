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

    def element (name: String) = (Pattern.compile ("""<cim:""" + name + """>([\s\S]*?)<\/cim:""" + name + """>"""), 1)
    def attribute (name: String) = (Pattern.compile ("""<cim:""" + name + """\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>"""), 2)

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
        {
            ret = matcher.group (pattern._2)
            if (context.DEBUG)
                context.coverage += Tuple2 (matcher.start (), matcher.end ())
        }

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

    def toDouble (string: String, context: Context): Double =
    {
        var ret = 0.0

        if ((null != string) && ("" != string))
            try
            {
                ret = string.toDouble
            }
            catch
            {
                case nfe: NumberFormatException ⇒ throw new Exception ("unparsable double (" + string + ")found while parsing at line " + context.line_number ())
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
    def apply(i: Int): Any =
    {
        if (0 != i)
            throw new IllegalArgumentException ("only one property")
        else
            key
    }

    /** Checks whether the value at position i is null. */
    def isNullAt(i: Int): Boolean = get(i) == null

    /**
     * Returns the value at position i as a primitive boolean.
     *
     * @throws ClassCastException when data type does not match.
     * @throws NullPointerException when value is null.
     */
    def getBoolean(i: Int): Boolean = getAnyValAs[Boolean](i)

    /**
     * Returns the value at position i as a primitive byte.
     *
     * @throws ClassCastException when data type does not match.
     * @throws NullPointerException when value is null.
     */
    def getByte(i: Int): Byte = getAnyValAs[Byte](i)

    /**
     * Returns the value at position i as a primitive short.
     *
     * @throws ClassCastException when data type does not match.
     * @throws NullPointerException when value is null.
     */
    def getShort(i: Int): Short = getAnyValAs[Short](i)

    /**
     * Returns the value at position i as a primitive int.
     *
     * @throws ClassCastException when data type does not match.
     * @throws NullPointerException when value is null.
     */
    def getInt(i: Int): Int = getAnyValAs[Int](i)

    /**
     * Returns the value at position i as a primitive long.
     *
     * @throws ClassCastException when data type does not match.
     * @throws NullPointerException when value is null.
     */
    def getLong(i: Int): Long = getAnyValAs[Long](i)

    /**
     * Returns the value at position i as a primitive float.
     * Throws an exception if the type mismatches or if the value is null.
     *
     * @throws ClassCastException when data type does not match.
     * @throws NullPointerException when value is null.
     */
    def getFloat(i: Int): Float = getAnyValAs[Float](i)

    /**
     * Returns the value at position i as a primitive double.
     *
     * @throws ClassCastException when data type does not match.
     * @throws NullPointerException when value is null.
     */
    def getDouble(i: Int): Double = getAnyValAs[Double](i)

    /**
     * Returns the value at position i as a String object.
     *
     * @throws ClassCastException when data type does not match.
     */
    def getString(i: Int): String = getAs[String](i)


    /**
     * Returns the value of a given fieldName.
     *
     * @throws UnsupportedOperationException when schema is not defined.
     * @throws ClassCastException when data type does not match.
     * @throws NullPointerException when value is null.
     */
    private def getAnyValAs[T <: AnyVal](i: Int): T =
        if (isNullAt(i))
            throw new NullPointerException(s"Value at index $i in null")
        else
            getAs[T](i)

    /**
     * Return a Scala Seq representing the row. Elements are placed in the same order in the Seq.
     */
    def toSeq: Seq[Any] =
    {
        val n = length
        val values = new Array[Any](n)
        var i = 0
        while (i < n)
        {
            values.update(i, get(i))
            i += 1
        }
        values.toSeq
    }
}

object Element
extends
    Parser
{
    /**
     * Parse an element.
     * Simply extracts the id
     */
    val mRID = parse_element ((Pattern.compile ("""rdf:ID=("|')([\s\S]*?)\1>?"""), 2))_
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
        return (
            Unknown
            (
                Element.parse (context),
                context.xml,
                context.line_number (),
                context.start,
                context.end
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
                        case "cim:UserAttribute" ⇒ UserAttribute.parse (context)
                        case "cim:NameTypeAuthority" ⇒ NameTypeAuthority.parse (context)
                        case "cim:NameType" ⇒ NameType.parse (context)
                        case "cim:StateVariable" ⇒ StateVariable.parse (context)
                        case "cim:SvStatus" ⇒ SvStatus.parse (context)
                        case "cim:IdentifiedObject" ⇒ IdentifiedObject.parse (context)
                        case "cim:PSRType" ⇒ PSRType.parse (context)
                        case "cim:Name" ⇒ Name.parse (context)
                        case "cim:CoordinateSystem" ⇒ CoordinateSystem.parse (context)
                        case "cim:BaseVoltage" ⇒ BaseVoltage.parse (context)
                        case "cim:ConnectivityNode" ⇒ ConnectivityNode.parse (context)
                        case "cim:ACDCTerminal" ⇒ ACDCTerminal.parse (context)
                        case "cim:Terminal" ⇒ Terminal.parse (context)
                        case "cim:PowerSystemResource" ⇒ PowerSystemResource.parse (context)
                        case "cim:ConnectivityNodeContainer" ⇒ ConnectivityNodeContainer.parse (context)
                        case "cim:EquipmentContainer" ⇒ EquipmentContainer.parse (context)
                        case "cim:Line" ⇒ Line.parse (context)
                        case "cim:Substation" ⇒ Substation.parse (context)
                        case "cim:VoltageLevel" ⇒ VoltageLevel.parse (context)
                        case "cim:Bay" ⇒ Bay.parse (context)
                        case "cim:Equipment" ⇒ Equipment.parse (context)
                        case "cim:ConductingEquipment" ⇒ ConductingEquipment.parse (context)
                        case "cim:Connector" ⇒ Connector.parse (context)
                        case "cim:Junction" ⇒ Junction.parse (context)
                        case "cim:EnergyConsumer" ⇒ EnergyConsumer.parse (context)
                        case "cim:Conductor" ⇒ Conductor.parse (context)
                        case "cim:ACLineSegment" ⇒ ACLineSegment.parse (context)
                        case "cim:BusbarSection" ⇒ BusbarSection.parse (context)
                        case "cim:Switch" ⇒ Switch.parse (context)
                        case "cim:Fuse" ⇒ Fuse.parse (context)
                        case "cim:Disconnector" ⇒ Disconnector.parse (context)
                        case "cim:GeneratingUnit" ⇒ GeneratingUnit.parse (context)
                        case "cim:SolarGeneratingUnit" ⇒ SolarGeneratingUnit.parse (context)
                        case "cim:TransformerTank" ⇒ TransformerTank.parse (context)
                        case "cim:TransformerEnd" ⇒ TransformerEnd.parse (context)
                        case "cim:PowerTransformerEnd" ⇒ PowerTransformerEnd.parse (context)
                        case "cim:TransformerTankEnd" ⇒ TransformerTankEnd.parse (context)
                        case "cim:PowerTransformer" ⇒ PowerTransformer.parse (context)
                        case "cim:Location" ⇒ Location.parse (context)
                        case "cim:PositionPoint" ⇒ PositionPoint.parse (context)
                        case "cim:WorkLocation" ⇒ WorkLocation.parse (context)
                        case "cim:ServiceLocation" ⇒ ServiceLocation.parse (context)
                        case "cim:UsagePoint" ⇒ UsagePoint.parse (context)
                        case "cim:UsagePointLocation" ⇒ UsagePointLocation.parse (context)
                        case "cim:Agreement" ⇒ Agreement.parse (context)
                        case "cim:Customer" ⇒ Customer.parse (context)
                        case "cim:CustomerAgreement" ⇒ CustomerAgreement.parse (context)
                        case "cim:OrganisationRole" ⇒ OrganisationRole.parse (context)
                        case "cim:ServiceCategory" ⇒ ServiceCategory.parse (context)
                        case "cim:PricingStructure" ⇒ PricingStructure.parse (context)
                        case "cim:Document" ⇒ Document.parse (context)

                        case _ ⇒
                        {
                            if ((context.DEBUG) && (context.errors.size < context.MAXERRORS))
                                context.errors += "Unknown element \"" + name + "\" at line " + context.line_number ()
                            Unknown.parse (context)
                        }
                    }
                    value = element

                    // return success unless there was unrecognized text before the match
                    // that wasn't at the start of the xml
                    ret = (context.end == (matcher.start () + context.start)) || (context.end == context.start)
                    // or there is non-whitespace not covered
                    if (context.DEBUG)
                        ret &= context.covered ()

                    // set up for next parse
                    context.end = matcher.end () + context.start
                    context.coverage.clear ()
                    found = true
                }
            }

        return (ret)
    }

    def parse (): HashMap[String, Element] =
    {
        val ret = HashMap[String, Element] ()
        while (parse_one ())
            ret.put (value.key, value)

        return (ret)
    }
}

object CHIM
{
    val CHUNK = 1024*1024*64
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

                for (error <- parser.context.errors)
                    println (error)
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
