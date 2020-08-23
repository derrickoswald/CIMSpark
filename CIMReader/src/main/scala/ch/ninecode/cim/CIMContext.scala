package ch.ninecode.cim

import java.util.regex.Pattern
import scala.collection.mutable.ArrayBuffer

/**
 * Context for parsing.
 * Contains the raw XML, indexes at which to start and stop parsing,
 * the line number index of newlines within the XML,
 * text coverage set (in debug) and error messages raised while parsing.
 *
 * @param xml        The current xml string being parsed.
 * @param start      The starting character position of the xml string - non-zero if not the first Split.
 * @param end        The ending character position at which to stop parsing.
 * @param first_byte The byte offset of the first character to be parsed.
 */
class CIMContext (var xml: String, val start: Long, var end: Long, var first_byte: Long)
{

    import CIMContext._

    /**
     * The array of character positions of newlines in the xml string.
     */
    val newlines: ArrayBuffer[Long] = index_string (xml, start)

    /**
     * An array of string start and end offsets that have been parsed.
     */
    val coverage: ArrayBuffer[(Int, Int)] = new ArrayBuffer[(Int, Int)]

    /**
     * An array of up to MAXERRORS error messages.
     */
    val errors: ArrayBuffer[String] = new ArrayBuffer[String]

    /**
     * The byte offset of the last successfully parsed full element.
     */
    var last_byte: Long = first_byte

    /**
     * The internal XML for an element being parsed.
     */
    var subxml: String = _

    /**
     * Create an index of newline characters in a string.
     * The index of newlines for the string
     * "Now is the time\nfor all good men\nto come to the aid of the party\n"
     * is [15, 32, 64]
     *
     * @param string the string to index
     * @param offset optional offset to add to the index values
     * @return {Unit} nothing
     */
    def index_string (string: String, offset: Long = 0L, n: ArrayBuffer[Long] = ArrayBuffer [Long]()): ArrayBuffer[Long] =
    {
        val matcher = lines.matcher (string)
        while (matcher.find ())
        {
            val _ = n += (matcher.start () + offset)
        }
        n
    }

    /**
     * Get the line number for the given offset value.
     * Uses a binary search through the newline array to determine where the
     * given offset lies in the source stream.
     *
     * @param offset the character position in the stream
     * @return the line number (1 + how many newlines precede the offset)
     */
    @SuppressWarnings (Array ("org.wartremover.warts.Return"))
    def line_number (offset: Long = end): Int =
    {
        var min = 0
        var max = newlines.length - 1
        var index = min

        while (min <= max)
        {
            index = (min + max) / 2 | 0
            val item = newlines (index)

            if (item < offset)
                min = index + 1
            else
                if (item > offset)
                    max = index - 1
                else
                    return index + 1
        }

        if (newlines (index) <= offset)
            index += 1

        index + 1
    }

    /**
     * Check that all characters were consumed by parsing.
     * Used to find attributes and references that are not understood by the model.
     *
     * @return <code>true</code> if all non-whitespace characters were parsed.
     */
    def covered (): Boolean =
    {
        var ret: Boolean = true
        var index: Int = 0
        for (pair <- coverage.sorted)
        {
            while (ret && index < pair._1)
            {
                ret &&= subxml.charAt (index).isWhitespace
                if (!ret && errors.size < MAXERRORS)
                {
                    val _ = errors += """Unknown content "%s" at line %d""".format (subxml.substring (index, pair._1).trim (), line_number ())
                }
                index += 1
            }
            index = pair._2
        }
        while (ret && index < subxml.length ())
        {
            ret &&= subxml.charAt (index).isWhitespace
            if (!ret && errors.size < MAXERRORS)
            {
                val _ = errors += """Unknown content "%s" at line %d""".format (subxml.substring (index, subxml.length ()).trim (), line_number ())
            }
            index += 1
        }

        ret
    }

    /**
     * Output a debugging string of this context.
     */
    override def toString: String =
    {
        s""""${subxml.substring (0, 50)}..." @ $end character $last_byte byte"""
    }
}

object CIMContext
{
    /**
     * Add extra checks while parsing flag.
     */
    var DEBUG = true

    /**
     * Return no elements after an error flag.
     */
    var STOP_ON_ERROR = false

    /**
     * Limit errors accumulation to this amount.
     */
    var MAXERRORS = 10

    /**
     * Regular expression for line counting.
     */
    val lines: Pattern = Pattern.compile ("""\n""")
}
