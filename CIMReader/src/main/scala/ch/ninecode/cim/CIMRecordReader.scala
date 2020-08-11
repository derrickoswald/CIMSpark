package ch.ninecode.cim

import org.apache.commons.logging.{Log, LogFactory}
import org.apache.hadoop.io.Text
import org.apache.hadoop.mapreduce.InputSplit
import org.apache.hadoop.mapreduce.RecordReader
import org.apache.hadoop.mapreduce.TaskAttemptContext
import org.apache.hadoop.mapreduce.lib.input.FileSplit

import ch.ninecode.model.Element

class CIMRecordReader extends RecordReader[String, Element]
{
    val log: Log = LogFactory.getLog (classOf [CIMRecordReader])
    var cim: CHIM = _

    def initialize (genericSplit: InputSplit, context: TaskAttemptContext): Unit =
    {
        log.info ("initialize")
        log.info (s"genericSplit: ${genericSplit.toString}")
        log.info (s"context: ${context.getTaskAttemptID.toString}")
        val job = context.getConfiguration
        val split = genericSplit.asInstanceOf [FileSplit]
        val start = split.getStart
        val bytes = split.getLength
        val file = split.getPath

        // open the file and seek to the start of the split
        val fs = file.getFileSystem (job)
        val in = fs.open (file)

        val end = start + bytes
        val available = fs.getFileStatus (file).getLen
        val extra = if (available > end) Math.min (CHIM.OVERREAD.toLong, available - end) else 0L
        // ToDo: may need to handle block sizes bigger than 2GB - what happens for size > 2^31?
        val size = (bytes + extra).toInt
        val buffer = new Array[Byte](size)
        in.readFully (start, buffer)

        val low =
            if (0 == start)
            // strip any BOM(Byte Order Mark) i.e. 0xEF,0xBB,0xBF
                if ((size >= 3) && (buffer (0) == 0xef) && (buffer (1) == 0xbb) && (buffer (2) == 0xbf))
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
                if ((buffer (low + i) & 0xc0) != 0xc0) // check for the start of a UTF-8 character
                    while (0 != (buffer (low + i) & 0x80) && (i < Math.min (4, size)))
                        i += 1
                low + i
            }
            else
                low

        val xml = Text.decode (buffer, first, size - first)
        val len = if (0 == extra) xml.length else Text.decode (buffer, first, (size - first - extra).toInt).length

        // ToDo: using first here is approximate,
        // the real character count would require reading the complete file
        // from 0 to (start + first) and converting to characters
        log.debug (s"XML text starting at byte offset ${start + first} of length $len characters begins with: ${xml.substring (0, 120)}")
        cim = new CHIM (xml, first, first + len, start, start + bytes)
    }

    def close (): Unit =
    {
        log.info ("close")
        cim = null
    }

    def getCurrentKey: String = cim.value.id

    def getCurrentValue: Element = cim.value

    def getProgress: Float = cim.progress ()

    def nextKeyValue (): Boolean = cim.parse_one ()
}
