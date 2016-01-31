package ch.ninecode

import org.apache.hadoop.mapreduce.lib.input.FileSplit
import org.apache.hadoop.mapreduce.InputSplit
import org.apache.hadoop.mapreduce.RecordReader
import org.apache.hadoop.mapreduce.TaskAttemptContext

class CIMRecordReader extends RecordReader[String, Element]
{
    var start: Long = 0
    var end: Long = 0
    var xml: String = ""
    var key: String = ""
    var value: Element = null

    def initialize (genericSplit: InputSplit, context: TaskAttemptContext): Unit =
    {
        var job = context.getConfiguration ();
        val split = genericSplit.asInstanceOf[FileSplit];
        start = split.getStart ();
        end = start + split.getLength ();
        val file = split.getPath ();

        // open the file and seek to the start of the split
        var fs = file.getFileSystem (job);
        val in:org.apache.hadoop.fs.FSDataInputStream = fs.open (file);

        // ToDo: may need to align here first
        // ToDo: may need to strip BOM(Byte Order Mark) at the start of the text stream, i.e. 0xEF,0xBB,0xBF
        // ToDo: may need to handle block sizes bigger than 2GB
        val size = (end - start).asInstanceOf[Int]
        val buffer = new Array[Byte] (size);
        in.readFully (start, buffer)
        val text = new org.apache.hadoop.io.Text ()
        text.append (buffer, 0, size)
        xml = text.toString ()
    }

    def close(): Unit = {}
    def getCurrentKey(): String = { return (key) }
    def getCurrentValue(): Element = { return (value) }
    def getProgress(): Float = { return (0.0f) }
    def nextKeyValue(): Boolean =
    {
        // here we do a parse
        return (false)
    }
}
