package ch.ninecode.cim

import java.util.regex.Pattern

import com.esotericsoftware.kryo.Serializer

import ch.ninecode.model.Element

/**
 * Provides common infrastructure for parsing CIM elements.
 * Subclasses (actually their companion objects) must implement the <code>parse</code> method.
 * Other methods are helpers for parsing the regular XML structure of CIM rdf files.
 */
trait CIMParser
{

    import CIMParser._

    type Expression = (Pattern, Int)

    type Field = Option[String]

    trait FielderFunction
    {
        def apply ()(implicit context: CIMContext): Field
    }

    type Fielder = FielderFunction

    type Fields = Option[List[String]]

    trait FielderFunctionMultiple
    {
        def apply ()(implicit context: CIMContext): Fields
    }

    type FielderMultiple = FielderFunctionMultiple

    val fields: Array[String] = Array()
    val relations: List[CIMRelationship] = List()

    def serializer: Serializer[_ <: Product]

    /**
     * Create the integer array of bitfields from field names.
     *
     * @param strings the names of the fields to set the bits for
     * @return the bitfield array corresponding to the given field names
     */
    def fieldsToBitfields (strings: String*): Array[Int] =
    {
        val bits = new Array[Int]((fields.length + 31) / 32)
        strings.foreach(
            fieldname =>
            {
                val index = fields.indexOf(fieldname)
                if (-1 != index)
                    bits(index / 32) |= (1 << (index % 32))
                else
                {
                    // ToDo: better error handling
                    println(s"""field "$fieldname not fould in fields array of ${getClass.getName}""")
                }
            }
        )
        bits
    }

    /**
     * Regular expression to parse an element.
     * For example: <cim:ACLineSegment.r>0.224</cim:ACLineSegment.r>
     *
     * @param cls  The class name.
     * @param name The element name (without namespace prefix).
     * @return The compiled regex pattern and the index of the match group.
     */
    def element (cls: String, name: String): Expression =
    {
        val trigger = s"$namespace:$cls.$name"
        (Pattern.compile("""<""" + trigger + """>([\s\S]*?)<\/""" + trigger + """>|<""" + trigger + """\/>"""), 1)
    }

    /**
     * Regular expression to parse an attribute.
     * For example: <cim:ACLineSegmentPhase.phase rdf:resource="http://iec.ch/TC57/2013/CIM-schema-cim16#SinglePhaseKind.A"/>
     *
     * @param cls  The class name.
     * @param name The attribute name (without namespace prefix).
     * @return The compiled regex pattern and the index of the match group.
     */
    def attribute (cls: String, name: String): Expression =
    {
        val trigger = s"$namespace:$cls.$name"
        (Pattern.compile("""<""" + trigger + """\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>"""), 2)
    }

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
     *
     * @param context The context for the substring in the XML and
     *                line number and position context for reporting in case of an error.
     * @return The parsed CIM element, e.g. ACLineSegment.
     */
    def parse (context: CIMContext): Element

    /**
     * Create a function to parse one XML element from a string.
     *
     * @param pattern A Tuple2 of the regular expression pattern to look for and
     *                the index of the capture group to extract from within the pattern.
     * @return A function for parsing the element.
     */
    def parse_element (pattern: Expression): FielderFunction =
    {
        // Anonymous function to parse an element field
        //     * @param context The context for the substring in the XML and
        //     * line number and position context for reporting in case of an error.
        //     * @return The matched group from the regular expression, or null if the pattern wasn't found.
        new FielderFunction
        {
            def apply ()(implicit context: CIMContext): Field =
            {
                val matcher = pattern._1.matcher(context.subxml)
                if (matcher.find())
                {
                    val string = matcher.group(pattern._2)
                    if (CIMContext.DEBUG)
                        context.coverage.append((matcher.start, matcher.end))
                    Some(if (null == string) "" else string)
                }
                else
                    None
            }
        }
    }

    /**
     * Parse one or more XML elements from a string.
     *
     * @param pattern A Tuple2 of the regular expression pattern to look for and
     *                the index of the capture group to extract from within the pattern.
     * @return A function for parsing the elements.
     */
    def parse_elements (pattern: Expression): FielderFunctionMultiple =
    {
        //     * @param context The context for the substring in the XML and
        //     * line number and position context for reporting in case of an error.
        //     * @return The matched group(s) from the regular expression or null if none were found.
        new FielderFunctionMultiple
        {
            def apply ()(implicit context: CIMContext): Fields =
            {
                val matcher = pattern._1.matcher(context.subxml)
                val enumerator = new Iterator[String]()
                {
                    def hasNext: Boolean = matcher.find()

                    def next (): String =
                    {
                        if (CIMContext.DEBUG)
                            context.coverage.append((matcher.start, matcher.end))
                        matcher.group(pattern._2)
                    }
                }
                val iterator = for (string <- enumerator)
                    yield string
                if (iterator.isEmpty) None else Some(iterator.toList)
            }
        }
    }

    /**
     * Create a function to parse one attribute from an XML string.
     *
     * @param pattern A Tuple2 of the regular expression pattern to look for and
     *                the index of the capture group to extract from within the pattern.
     * @return A function for parsing the attribute.
     */
    def parse_attribute (pattern: (Pattern, Int)): FielderFunction =
    {
        //     * @param context The context for the substring in the XML and
        //     * line number and position context for reporting in case of an error.
        //     * @return The attribute value (with leading # stripped off), or null if the pattern wasn't found.
        new FielderFunction
        {
            def apply ()(implicit context: CIMContext): Field =
            {
                val matcher = pattern._1.matcher(context.subxml)
                if (matcher.find())
                {
                    val start = matcher.start(pattern._2)
                    val end = matcher.end(pattern._2)
                    if ((-1 != start) && (-1 != end))
                    {
                        val begin = if ('#' == context.subxml.charAt(start)) start + 1 else start // remove '#'
                        val string = context.subxml.subSequence(begin, end).toString
                        if (CIMContext.DEBUG)
                            context.coverage.append((matcher.start, matcher.end))
                        Option(string)
                    }
                    else
                        None
                }
                else
                    None
            }
        }
    }

    /**
     * Create a function to parse one or more attributes from an XML string.
     *
     * @param pattern A Tuple2 of the regular expression pattern to look for and
     *                the index of the capture group to extract from within the pattern.
     * @return A function for parsing the attributes.
     */
    def parse_attributes (pattern: (Pattern, Int)): FielderMultiple =
    {
        //     * @param context The context for the substring in the XML and
        //     * line number and position context for reporting in case of an error.
        //     * @return The attribute value(s) (with leading # stripped off).
        new FielderFunctionMultiple
        {
            def apply ()(implicit context: CIMContext): Fields =
            {
                val matcher = pattern._1.matcher(context.subxml)
                val enumerator = new Iterator[Option[String]]()
                {
                    def hasNext: Boolean = matcher.find()

                    def next (): Option[String] =
                    {
                        val start = matcher.start(pattern._2)
                        val end = matcher.end(pattern._2)
                        if ((-1 != start) && (-1 != end))
                        {
                            val begin = if ('#' == context.subxml.charAt(start)) start + 1 else start // remove '#'
                            val string = context.subxml.subSequence(begin, end).toString
                            if (CIMContext.DEBUG)
                                context.coverage.append((matcher.start, matcher.end))
                            Some(string)
                        }
                        else
                            None
                    }
                }
                val iterator = for (string <- enumerator)
                    yield string
                val l = iterator.flatten
                if (l.isEmpty) None else Some(l.toList)
            }
        }
    }

    /**
     * Convert a string into a boolean.
     *
     * @param string  The string to convert. Should be either "true" or "false". <null> and the empty string are considered false.
     * @param context The context for reporting in case of an unparseable boolean.
     * @return The boolean value.
     */
    def toBoolean (string: String)(implicit context: CIMContext): Boolean =
    {
        var ret = false

        if ((null != string) && ("" != string))
            try
            ret = string.toBoolean
            catch
            {
                case _: Throwable => throw new Exception(s"unparsable boolean ($string) found while parsing at line ${context.line_number()}")
            }

        ret
    }

    /**
     * Convert a string into an integer.
     *
     * @param string  The string to convert. Should be just digits although whitespace at the beginning or end is tolerated.
     * @param context The context for reporting in case of an unparseable integer.
     * @return The integer value.
     */
    def toInteger (string: String)(implicit context: CIMContext): Int =
    {
        var ret: Int = 0

        if ((null != string) && ("" != string))
            try
            ret = string.trim.toInt
            catch
            {
                case _: Throwable => throw new Exception(s"unparsable integer ($string) found while parsing at line ${context.line_number()}")
            }

        ret
    }

    /**
     * Convert a string into a floating point value.
     *
     * @param string  The string to convert. Should be a valid floating point formatted number although whitespace at the beginning or end is tolerated.
     * @param context The context for reporting in case of an unparseable double.
     * @return The double value.
     */
    def toDouble (string: String)(implicit context: CIMContext): Double =
    {
        var ret = 0.0

        if ((null != string) && ("" != string))
            try
            ret = string.trim.toDouble
            catch
            {
                case _: Throwable => throw new Exception(s"unparsable double ($string) found while parsing at line ${context.line_number()}")
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
 */
object CIMParser
{
    /**
     * The CIM namespace ("cim").
     */
    val namespace: String = "cim"
    /**
     * The regular expression for parsing top level elements.
     */
    val rddex: Pattern = Pattern.compile("""\s*<(""" + namespace + """:[^>\.\s]+)([>\s][\s\S]*?)<\/\1>\s*""") // important to consume leading and trailing whitespace
}
