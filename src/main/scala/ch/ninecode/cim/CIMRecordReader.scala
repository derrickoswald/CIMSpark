package ch.ninecode.cim

import org.apache.commons.logging.LogFactory
import org.apache.hadoop.mapreduce.InputSplit
import org.apache.hadoop.mapreduce.RecordReader
import org.apache.hadoop.mapreduce.TaskAttemptContext
import org.apache.hadoop.mapreduce.lib.input.FileSplit
import org.apache.spark.sql.Row

import ch.ninecode.model.CHIM
import ch.ninecode.model.Element

class CIMRecordReader extends RecordReader[String, Element]
{
    val LocalLog = LogFactory.getLog (classOf[CIMRecordReader]);
    var start: Long = 0
    var end: Long = 0
    var cim: CHIM = null

    def initialize (genericSplit: InputSplit, context: TaskAttemptContext): Unit =
    {
        LocalLog.info ("initialize")
        LocalLog.info ("genericSplit: " + genericSplit.toString ())
        LocalLog.info ("context: " + context.toString ())
        var job = context.getConfiguration ();
        val split = genericSplit.asInstanceOf[FileSplit];
        start = split.getStart ();
        end = start + split.getLength ();
        val file = split.getPath ();

        // open the file and seek to the start of the split
        var fs = file.getFileSystem (job);
        val in = fs.open (file);

        val extra = if (in.available() > end) CHIM.OVERREAD else 0
        // ToDo: may need to handle block sizes bigger than 2GB - what happens for size > 2^31?
        val size = (end - start + extra).asInstanceOf[Int]
        val buffer = new Array[Byte] (size);
        in.readFully (start, buffer)

        var low = 0
        if (0 == start)
            // strip any BOM(Byte Order Mark) i.e. 0xEF,0xBB,0xBF
            if ((size >= 3) && (buffer (low) == 0xef) && (buffer (low + 1) == 0xbb) && (buffer (low + 2) == 0xbf))
                low += 3

        if (0 != start)
        {
            // skip to next UTF-8 non-continuation byte (high order bit zero)
            // by advancing past at most 4 bytes
            var i = 0
            if ((buffer(low) & 0xc0) != 0xc0) // check for the start of a UTF-8 character
                while (0 != (buffer(low) & 0x80) && (i < Math.min (4, size)))
                {
                    low += 1
                    i += 1
                }
        }

        var text = new org.apache.hadoop.io.Text ()
        text.append (buffer, low, size - low - extra)
        var xml = text.toString ()
        val len = xml.length ()

        text = new org.apache.hadoop.io.Text ()
        text.append (buffer, low, size - low)
        xml = text.toString ()
        LocalLog.info ("XML text starting at byte offset " + (start + low) + " of length " + len + " begins with: " + xml.substring (0, 120))
        // ToDo: using start here is approximate,
        // the real character count would require reading the complete file
        // from 0 to (start + low) and converting to characters
        cim = new CHIM (xml, start, start + len)
    }

    def close(): Unit = {}
    def getCurrentKey(): String = { return (cim.value.id) }
    def getCurrentValue(): Element = { return (cim.value) }
    def getProgress(): Float = { return (cim.progress ()) }
    def nextKeyValue(): Boolean =
    {
        return (cim.parse_one ())
    }
}
