package ch.ninecode.cim

import org.apache.commons.logging.{Log, LogFactory}
import org.apache.hadoop.mapreduce.InputSplit
import org.apache.hadoop.mapreduce.JobContext
import org.apache.hadoop.mapreduce.RecordReader
import org.apache.hadoop.mapreduce.TaskAttemptContext
import ch.ninecode.model.Element

class CIMInputFormatDebug extends CIMInputFormat
{
    val log: Log = LogFactory.getLog (getClass)

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
     * @return the list of FileSplit objects for the job
     */
    override def getSplits (context: JobContext): java.util.List[InputSplit] =
    {
        log.info ("getSplits")
        val ret = super.getSplits (context)
        log.info (s"getSplits: ${ret.size ()} splits returned")
        ret
    }

    /**
     * Create a record reader for a given split.
     *
     * @param split   the split to be read
     * @param context the information about the task
     * @return a new record reader
     */
    override def createRecordReader (split: InputSplit, context: TaskAttemptContext): RecordReader[String, Element] =
    {
        log.info ("createRecordReader")
        log.info (s"split: ${split.toString}")
        log.info (s"context: ${context.getTaskAttemptID.toString}")
        new CIMRecordReader (true)
    }
}
