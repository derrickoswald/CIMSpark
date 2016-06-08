package ch.ninecode.cim

import org.apache.commons.logging.LogFactory
import org.apache.hadoop.fs.Path
import org.apache.hadoop.mapreduce.InputSplit
import org.apache.hadoop.mapreduce.JobContext
import org.apache.hadoop.mapreduce.RecordReader
import org.apache.hadoop.mapreduce.TaskAttemptContext
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat
import org.apache.hadoop.mapreduce.lib.input.FileSplit

import ch.ninecode.model.Element

class CIMInputFormat extends FileInputFormat[String, Element]
{
    val LocalLog = LogFactory.getLog (classOf[CIMInputFormat]);

//    /**
//     * A factory that makes the split for this class. It can be overridden
//     * by sub-classes to make sub-types
//     */
//    override def makeSplit (file: Path, start: Long, length: Long, hosts: Array[String]): FileSplit =
//    {
//        return new FileSplit (file, start, length, hosts);
//    }

    /**
     * Generate the list of files and make them into FileSplits.
     *
     * Logically split the set of input files for the job.
     * Each InputSplit is then assigned to an individual Mapper for processing.
     * Note: The split is a logical split of the inputs and the input files are not physically split into chunks.
     * For e.g. a split could be <input-file-path, start, offset> tuple.
     * The InputFormat also creates the RecordReader to consume the InputSplit objects produced.
     *
     * @param context the job context
     * @returns the list of FileSplit objects for the job
     * @throws IOException
     */
    override def getSplits (context: JobContext): java.util.List[InputSplit] =
    {
        LocalLog.info ("getSplits")
        var ret: java.util.List[InputSplit] = new java.util.ArrayList[InputSplit]

        // Note: we don't need to override this yet,
        // but the JobContext has the Credentials (@see org.apache.hadoop.mapreduce.JobContext.getCredentials())
        // which would be checked here.
        ret = super.getSplits (context)

        LocalLog.info ("getSplits: " + ret.size() + " splits returned")
        return (ret)
    }

   /**
    * Create a record reader for a given split. The framework will call
    * {@link RecordReader#initialize(InputSplit, TaskAttemptContext)} before
    * the split is used.
    * @param split the split to be read
    * @param context the information about the task
    * @return a new record reader
    */
    def createRecordReader (split: InputSplit, context: TaskAttemptContext): RecordReader[String, Element] =
    {
        LocalLog.info ("createRecordReader")
        LocalLog.info ("split: " + split.toString ())
        LocalLog.info ("context: " + context.toString ())
        return (new CIMRecordReader ());
    }
}
