package ch.ninecode

import java.util.regex.Pattern
import scala.collection.mutable.ArrayBuffer

/**
 * Context for error messages raised while parsing.
 *
 */
class Context (var xml: String, var start: Long, var end: Long, val newlines: ArrayBuffer[Long])
{
    import Context._
    val DEBUG = true
    val MAXERRORS = 10
    var name: String = null // current element name
    val coverage = new ArrayBuffer[Pair[Int, Int]]
    val errors = new ArrayBuffer[String]

    /**
     * Create an index of newline characters in a string.
     * The index of newlines for the string
     * "Now is the time\nfor all good men\nto come to the aid of the party\n"
     * is [15, 32, 64]
     * @param {String} string - the string to index
     * @param {Number} offset - optional offset to add to the index values
     * @returns {Unit} nothing
     * @memberOf module:cim
     */
    def index_string (string: String, offset: Long = 0L): Unit =
    {
        val matcher = lines.matcher (string)
        while (matcher.find ())
            newlines += (matcher.start () + offset)
    }

    /**
     * Get the line number for the given offset value.
     * Uses a binary search through the neline array to determine where the
     * given offset lies in the source stream.
     * @param offset the character position in the stream
     * @return the line number (1 + how many newlines precede the offset)
     */
    def line_number (offset: Long = end): Int =
    {
        var min = 0
        var max = newlines.length - 1
        var index = min

        while (min <= max)
        {
            index = (min + max) / 2 | 0
            var item = newlines(index)

            if (item < offset)
                min = index + 1
            else if (item > offset)
                max = index - 1
            else
                return (index + 1)
        }

        if (newlines(index) <= offset)
            index += 1

        return (index + 1)
    }

    def covered (): Boolean =
    {
        var ret: Boolean = true
        var index: Int = 0
        for (pair <- coverage.sorted)
        {
            val sub = xml.substring (index, pair._1).trim ()
            if ("" != sub)
            {
                ret = false
                if (errors.size < MAXERRORS)
                    errors += "Unknown content \"" + sub + "\" at line " + line_number ()
            }
            index = pair._2
        }

        return (ret)
    }

    override def toString: String =
    {
        xml.substring (0, 50) + " start: " + start + " end: " + end
    }
}

object Context
{
    val lines = Pattern.compile ("""\n""")
}
