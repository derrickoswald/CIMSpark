package ch.ninecode.cim

import java.io.File
import java.io.FileInputStream
import java.nio.CharBuffer
import java.nio.ByteBuffer
import java.nio.charset.{Charset, CharsetEncoder}
import java.util.regex.{Matcher, Pattern}

import scala.collection.mutable.ArrayBuffer
import scala.collection.immutable.HashMap
import scala.language.existentials
import scala.reflect.ClassTag
import scala.reflect.classTag
import scala.reflect.runtime.universe.TypeTag
import org.apache.spark.sql.Row
import ch.ninecode.model._

/**
 * A bogus class needed for synchronization.
 * @see https://issues.scala-lang.org/browse/SI-6240
 * @see http://docs.scala-lang.org/overviews/reflection/thread-safety.html
 */
case class SerializableObject (name: String) extends Serializable

/**
 * Provides common infrastructure for parsing CIM elements.
 * Subclasses (actually their companion objects) must implement the <code>parse</code> method.
 * Other methods are helpers for parsing the regular XML structure of CIM rdf files.
 */
trait Parser
{
    import Parser._

    /**
     * Regular expression to parse an element.
     * For example: <cim:ACLineSegment.r>0.224</cim:ACLineSegment.r>
     * @param name The element name (without namespace prefix).
     * @return The compiled regex pattern and the index of the match group.
     */
    def element (name: String): (Pattern, Int) = (Pattern.compile ("""<""" + namespace + """:""" + name + """>([\s\S]*?)<\/""" + namespace + """:""" + name + """>"""), 1)

    /**
     * Regular expression to parse an attribute.
     * For example: <cim:ACLineSegmentPhase.phase rdf:resource="http://iec.ch/TC57/2013/CIM-schema-cim16#SinglePhaseKind.A"/>
     * @param name The attribute name (without namespace prefix).
     * @return The compiled regex pattern and the index of the match group.
     */
    def attribute (name: String): (Pattern, Int) = (Pattern.compile ("""<""" + namespace + """:""" + name + """\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>"""), 2)

    /**
     * Abstract parse function.
     * To be overridden in each implemented class.
     * This is intended to be used by the companion object of
     * each CIM class to provide a way to parse the XML element
     * and generate the CIM class.
     * The hierarchical nature of the generated elements necessitates
     * CIM classes to call their CIM superclass parser, for example,
     * since Terminal is a subclass of ACDCTerminal, it should
     * invoke the superclass parse method.
     * {{{
     *     def parse (context: Context): Terminal =
     *     {
     *         Terminal
     *         (
     *             ACDCTerminal.parse (context),
     *             ...
     *         )
     *     }
     * }}}
     * @param context The context for the substring in the XML and
     * line number and position context for reporting in case of an error.
     * @return The parsed CIM element, e.g. ACLineSegment.
     */
    def parse (context: Context): Element

    /**
     * Parse one or more XML elements from a string.
     * @param pattern A Tuple2 of the regular expression pattern to look for and
     * the index of the capture group to extract from within the pattern.
     * @return A function for parsing the elements.
     */
    def parse_elements (pattern: (Pattern, Int)): (Context) => List[String] =
    {
//     * @param context The context for the substring in the XML and
//     * line number and position context for reporting in case of an error.
//     * @return The matched group(s) from the regular expression or null if none were found.
        (context: Context) =>
        {
            var ret: List[String] = null

            val matcher = pattern._1.matcher (context.subxml)
            while (matcher.find ())
            {
                val string = matcher.group (pattern._2)
                if (Context.DEBUG)
                    context.coverage += Tuple2 (matcher.start, matcher.end)
                if (null != string)
                    ret = if (null == ret) List (string) else ret :+ string
            }

            ret
        }
    }

    /**
     * Create a function to parse one XML element from a string.
     * @param pattern A Tuple2 of the regular expression pattern to look for and
     * the index of the capture group to extract from within the pattern.
     * @return A function for parsing the element.
     */
    def parse_element (pattern: (Pattern, Int)): Context => String =
    {
//     * @param context The context for the substring in the XML and
//     * line number and position context for reporting in case of an error.
//     * @return The matched group from the regular expression, or null if the pattern wasn't found.
        (context: Context) =>
        {
            val matcher = pattern._1.matcher (context.subxml)
            if (matcher.find ())
            {
                val string = matcher.group (pattern._2)
                if (Context.DEBUG)
                    context.coverage += Tuple2 (matcher.start, matcher.end)
                string
            }
            else
                null
        }
    }

    /**
     * Create a function to parse one or more attributes from an XML string.
     * @param pattern A Tuple2 of the regular expression pattern to look for and
     * the index of the capture group to extract from within the pattern.
     * @return A function for parsing the attributes.
     */
    def parse_attributes (pattern: (Pattern, Int)): Context => List[String] =
    {
//     * @param context The context for the substring in the XML and
//     * line number and position context for reporting in case of an error.
//     * @return The attribute value(s) (with leading # stripped off).
        context: Context =>
        {
            var ret: List[String] = null

            val matcher = pattern._1.matcher (context.subxml)
            while (matcher.find ())
            {
                val start = matcher.start (pattern._2)
                val end = matcher.end (pattern._2)
                if ((-1 != start) && (-1 != end))
                {
                    val begin = if ('#' == context.subxml.charAt (start)) start + 1 else start // remove '#'
                    val string = context.subxml.subSequence (begin, end).toString
                    if (Context.DEBUG)
                        context.coverage += Tuple2 (matcher.start, matcher.end)
                    ret = if (null == ret) List (string) else ret :+ string
                }
            }

            ret
        }
    }

    /**
     * Create a function to parse one attribute from an XML string.
     * @param pattern A Tuple2 of the regular expression pattern to look for and
     * the index of the capture group to extract from within the pattern.
     * @return A function for parsing the attribute.
     */
    def parse_attribute (pattern: (Pattern, Int)): Context => String =
    {
//     * @param context The context for the substring in the XML and
//     * line number and position context for reporting in case of an error.
//     * @return The attribute value (with leading # stripped off), or null if the pattern wasn't found.
        (context: Context) =>
        {
            val matcher = pattern._1.matcher (context.subxml)
            if (matcher.find ())
            {
                val start = matcher.start (pattern._2)
                val end = matcher.end (pattern._2)
                if ((-1 != start) && (-1 != end))
                {
                    val begin = if ('#' == context.subxml.charAt (start)) start + 1 else start // remove '#'
                    val string = context.subxml.subSequence (begin, end).toString
                    if (Context.DEBUG)
                        context.coverage += Tuple2 (matcher.start, matcher.end)
                    string
                }
                else
                    null
            }
            else
                null
        }
    }

    /**
     * Convert a string into a boolean.
     * @param string The string to convert. Should be either "true" or "false". <null> and the empty string are considered false.
     * @param context The context for reporting in case of an unparseable boolean.
     * @return The boolean value.
     */
    def toBoolean (string: String, context: Context): Boolean =
    {
        var ret = false

        if ((null != string) && ("" != string))
            try
                ret = string.toBoolean
            catch
            {
                case _: Throwable ⇒ throw new Exception ("unparsable boolean (" + string + ") found while parsing at line " + context.line_number())
            }

        ret
    }

    /**
     * Convert a string into an integer.
     * @param string The string to convert. Should be just digits although whitespace at the beginning or end is tolerated.
     * @param context The context for reporting in case of an unparseable integer.
     * @return The integer value.
     */
    def toInteger (string: String, context: Context): Int =
    {
        var ret: Int = 0

        if ((null != string) && ("" != string))
            try
                ret = string.trim.toInt
            catch
            {
                case _: Throwable ⇒ throw new Exception ("unparsable integer (" + string + ") found while parsing at line " + context.line_number())
            }

        ret
    }

    /**
     * Convert a string into a floating point value.
     * @param string The string to convert. Should be a valid floating point formatted number although whitespace at the beginning or end is tolerated.
     * @param context The context for reporting in case of an unparseable double.
     * @return The double value.
     */
    def toDouble (string: String, context: Context): Double =
    {
        var ret = 0.0

        if ((null != string) && ("" != string))
            try
                ret = string.trim.toDouble
            catch
            {
                case _: Throwable ⇒ throw new Exception ("unparsable double (" + string + ") found while parsing at line " + context.line_number ())
            }

      ret
    }
}

/**
 * Holds constant members of the Parser trait.
 * Includes constants for use by subclasses and the parser.
 * This parser companion object is only needed because Scala doesn't have a static declaration,
 * and instead invents a "companion object" to hold the trait or class
 * members that should be accessible without an instantiated object.
 * 
 */
object Parser
{
    /**
     * The CIM namespace ("cim").
     */
    val namespace: String = "cim"
    /**
     * The regular expression for parsing top level elements.
     */
    val rddex: Pattern = Pattern.compile ("""\s*<(""" + namespace + """:[^>\.\s]+)([>\s][\s\S]*?)<\/\1>\s*""") // important to consume leading and trailing whitespace
}

case class ClassInfo (
    name: String,
    parseable: Parseable[Product],
    subsetter: CIMSubsetter[_ <: Product])

/**
 * Typed base class for registration and subsetting.
 * Provides facilities to register subclasses with the CHIM parsing framework
 * and forms the subsetting 'typed object' to spcify RDDs of specific CIM classes.
 * Typical usage:
 * {{{
 * object Terminal extends Parseable[Terminal]
 * {
 *     // implement Parser abstract method
 *     def parse (context: Context): Terminal = ???
 * }
 * }}}
 * 
 * @tparam A The CIM class type.
 */
abstract class Parseable[+A <: Product : ClassTag : TypeTag]
extends
    Parser
{
    val runtime_class: Class[_] = classTag[A].runtimeClass
    val classname: String = runtime_class.getName
    val cls: String = classname.substring (classname.lastIndexOf (".") + 1)
    def register: ClassInfo =
        ClassInfo (Parser.namespace + ":" + cls, this.asInstanceOf[Parseable[Product]], new CIMSubsetter[A]())
}

// Classes are organized by CIM package in .scala files and arranged alphabetically within the package.
// All attributes have been included for the classes except:
//   - m:n relations, e.g. ConnectDisconnectFunctions in Switch
//   - containment attributes and relations
// At the end of a package .scala file is an object with the same name as the package
// with an underscore prefix, e.g. _Common, used to register the classes at runtime.
// ** It is important to include any new classes in their package object so they are registered **

/**
 * Common Hierarchical Information Model
 * CIM classes for parsing RDF files.
 * @param xml The CIM RDF to parse.
 * @param start The initial character position in the xml to start parsing at.
 * @param finish The final character position in the xml to parse.
 * @param first_byte The first byte offset of the xml.
 * @param last_byte The last byte offset within the xml at which to stop parsing.
 */
class CHIM (val xml: String, val start: Long = 0L, val finish: Long = 0L, val first_byte: Long = 0L, val last_byte: Long = 0L) extends Serializable
{
    val last: Long = if (last_byte != 0L) last_byte else xml.getBytes ("UTF-8").length
    val context: Context = new Context (xml, start, start, first_byte)
    val matcher: Matcher = Parser.rddex.matcher (xml)
    val bytes: ByteBuffer = ByteBuffer.wrap (new Array[Byte] (4 * CHIM.OVERREAD))
    val encoder: CharsetEncoder = Charset.forName ("UTF-8").newEncoder ()
    var value: Element = _

    def classes: List[ClassInfo] =
        List (
            _AssetInfo.register,
            _Assets.register,
            _Common.register,
            _Core.register,
            _Customers.register,
            _DiagramLayout.register,
            _Domain.register,
            _InfAssets.register,
            _LoadControl.register,
            _LoadModel.register,
            _Meas.register,
            _Metering.register,
            _Production.register,
            _Protection.register,
            _StateVariables.register,
            _Topology.register,
            _Wires.register,
            _Work.register
        ).flatten
    val parsers: List[(String, Parseable[Product])] = classes.map (x => (x.name, x.parseable))
    val lookup: HashMap[String, Parseable[Product]] = HashMap (parsers: _*)

    def progress (): Float =
    {
        (context.end - context.start).toFloat / xml.length ().toFloat
    }

    def byte_count (xml: String, begin: Int, end: Int): Int =
    {
        val cb = CharBuffer.wrap (xml, begin, end)
        bytes.position (0)
        val cr = encoder.encode (cb, bytes, true)
        if (!cr.isUnderflow)
            cr.throwException ()
        bytes.position
    }

    def parse_one (): Boolean =
    {
        var ret = false

        var found = false
        if (context.last_byte < last)
        {
            while (!found && matcher.find ())
            {
                val name = matcher.group (1)
                // heuristic (along with the while and the 'not a dot' in rddex regular expression)
                // that allows jumping into the middle of a large file:
                // top level RDF elements do not have a period in their name
                if (!name.contains ('.'))
                {
                    context.subxml = matcher.group (2)
                    Unknown.name = name
                    value = lookup.getOrElse (name, Unknown).parse (context)

                    // return success unless there was unrecognized text before the match
                    // that wasn't at the start of the xml
                    if (context.end != (matcher.start + context.start))
                    {
                        val unknown = xml.substring (context.end.toInt, matcher.start + context.start.toInt)
                        if (context.end == context.start)
                        {
                            context.end += unknown.length
                            val l = byte_count (unknown, 0, unknown.length)
                            context.last_byte += l
                            ret = true // ignore unrecognized text at the start of the xml string
                        }
                        else
                        {
                            val snippet = if (unknown.length > 50) unknown.substring (0, 50) + "..." else unknown
                            context.errors += "Unknown content \"" + snippet + "\" at line " + context.line_number ()
                            ret = false
                        }
                    }
                    else
                        ret = true
                    // or there is non-whitespace not covered
                    if (Context.DEBUG)
                        if (!context.covered () && Context.STOP_ON_ERROR)
                            ret = false

                    // set up for next parse
                    val l = byte_count (xml, context.end.toInt - context.start.toInt, matcher.end)
                    context.last_byte += l
                    context.end = matcher.end () + context.start
                    context.coverage.clear
                    found = true
                }
            }
        }

        ret
    }
}

object CHIM
{
    val CHUNK: Int = 1024*1024*64
    val OVERREAD: Int = 1024*32 // should be large enough that no RDF element is bigger than this
    val row: Row = null

    def parse (parser: CHIM): (scala.collection.mutable.HashMap[String, Element], ArrayBuffer[String]) =
    {
        val result = new scala.collection.mutable.HashMap[String, Element]
        while (parser.parse_one ())
            result.put (parser.value.id, parser.value)
        (result, parser.context.errors)
    }

    def apply_to_all_classes (fn: (CIMSubsetter[_]) => Unit): Unit =
    {
        val chim = new CHIM ("") // ensure registration has occurred
        for (i <- chim.classes)
            fn (i.subsetter)
    }

    def read (filename: String, start: Long, size: Long, overread: Long = OVERREAD): (String, Long, Long) =
    {
        val file = new File (filename)
        val end = start + size
        if (file.exists ())
        {
            // open the file and skip to the starting offset
            val in = new FileInputStream (file)
            val skipped = in.skip (start)
            if (start == skipped)
            {
                val extra = if (in.available () > end - start) CHIM.OVERREAD else 0
                // ToDo: may need to handle block sizes bigger than 2GB - what happens for size > 2^31?
                val size = (end - start + extra).toInt
                val buffer = new Array[Byte] (size)
                in.read (buffer)

                val low =
                    if (0 == start)
                        // strip any BOM(Byte Order Mark) i.e. 0xEF,0xBB,0xBF
                        if ((size >= 3) && (buffer(0) == 0xef) && (buffer(1) == 0xbb) && (buffer(2) == 0xbf))
                            3
                        else
                            0
                    else
                        0

                val first =
                    if (0 != start)
                    {
                        // skip to next UTF-8 non-continuation byte (high order bit zero)
                        // by advancing past at most 4 bytes
                        var i = 0
                        if ((buffer(low + i) & 0xc0) != 0xc0) // check for the start of a UTF-8 character
                            while (0 != (buffer(low + i) & 0x80) && (i < Math.min (4, size)))
                                i += 1
                        low + i
                    }
                    else
                        low

                val len = new String (buffer, first, size - first - extra, "UTF-8").length
                val xml = new String (buffer, first, size - first, "UTF-8")
                (xml, first, first + len)
            }
            else
                ("", 0L, 0L)
        }
        else
            ("", 0L, 0L)
    }

    /**
     * Main program for testing purposes.
     */
    def main (args: Array[String])
    {
        if (args.length > 0)
        {
            if (args.length > 1)
            {
                println ("Press [Return] to continue...")
                System.console().readLine()
            }

            val filename = args (0)
            val fis = new FileInputStream (filename)
            val size = fis.available ()
            fis.close ()

            val result = new scala.collection.mutable.HashMap[String, Element]
            var offset = 0L
            var reading = 0.0
            var parsing = 0.0
            while (offset < size)
            {
                val start = System.nanoTime
                var (xml, lo, hi) = read (filename, offset, CHUNK)
                val before = System.nanoTime
                reading += (before - start) / 1000

                val parser = new CHIM (xml, lo, hi, offset, offset + CHUNK)
                offset += CHUNK
                xml = null
                val map = CHIM.parse (parser)
                result ++= map._1

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
            val subset = result.values.filter (_.getClass == classOf[Unknown])
            println (subset.size + " unknown elements")
        }
        else
            println ("CIM XML input file not specified")
    }
}
