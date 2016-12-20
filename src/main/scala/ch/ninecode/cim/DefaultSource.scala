package ch.ninecode.cim

import java.io.{FileNotFoundException, IOException, ObjectInputStream, ObjectOutputStream}
import scala.util.control.NonFatal

import org.apache.spark.sql.types._
import ch.ninecode.cim.DefaultSource.{IgnoreFilesWithoutExtensionProperty, SerializableConfiguration}

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileStatus, Path, FSDataInputStream, FSInputStream, FileSystem}
import org.apache.hadoop.mapreduce.Job
import org.slf4j.LoggerFactory

import org.apache.spark.sql.types._
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.execution.datasources.{FileFormat, OutputWriterFactory, PartitionedFile}
import org.apache.spark.sql.sources.{DataSourceRegister, Filter}
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.catalyst.ScalaReflection
     
class DefaultSource extends FileFormat with DataSourceRegister with Serializable {
  private val log = LoggerFactory.getLogger(getClass)
        
  override def equals(other: Any): Boolean = other match {
    case _: DefaultSource => true
    case _ => false
  }
  
  case class dummy
    (
        override val sup: Element = null
    )
    extends
        Element

  override def inferSchema(
      spark: SparkSession,
      options: Map[String, String],
      files: Seq[FileStatus]): Option[StructType] = {
        
    val cimSchema = ScalaReflection.schemaFor[dummy].dataType.asInstanceOf[StructType]
//    val cimSchema = new StructType()
//    cimSchema.add("id", StringType);
//    cimSchema.add("sup", NullType);
   
    return Some(cimSchema)
  }

  override def shortName(): String = "cim"

  override def prepareWrite(
      sparkSession: SparkSession,
      job: Job,
      options: Map[String, String],
      dataSchema: StructType): OutputWriterFactory = {
    
    log.info("DefaultSource.prepareWrite")
    
    return null
  }
  
  def getCIM(file: PartitionedFile): CHIM = {
    log.info("DefaultSource.getCIM")
    val start = file.start;
    val end = start + file.length;
    val filePath = file.filePath;

    val fileSystem = FileSystem.get(new Configuration())
    val in = fileSystem.open(new Path(filePath))
    val extra = if (in.available() > end) CHIM.OVERREAD else 0
    val size = (end - start + extra).asInstanceOf[Int]
    val buffer = new Array[Byte] (size)
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
    log.info ("XML text starting at byte offset " + (start + low) + " of length " + len + " begins with: " + xml.substring (0, 120))
    // ToDo: using start here is approximate,
    // the real character count would require reading the complete file
    // from 0 to (start + low) and converting to characters
    val cim = new CHIM (xml, start, start + len)
    return cim
  }
    
  override def buildReader(
      spark: SparkSession,
      dataSchema: StructType,
      partitionSchema: StructType,
      requiredSchema: StructType,
      filters: Seq[Filter],
      options: Map[String, String],
      hadoopConf: Configuration): (PartitionedFile) => Iterator[InternalRow] = {
     
    (file: PartitionedFile) => {
      val cim = getCIM(file)

      new Iterator[InternalRow] {

        override def hasNext: Boolean = cim.parse_one

        override def next(): InternalRow = cim.value
      }
    }
  }
}

object DefaultSource {
  val IgnoreFilesWithoutExtensionProperty = "avro.mapred.ignore.inputs.without.extension"

  class SerializableConfiguration(@transient var value: Configuration) extends Serializable {
    private val log = LoggerFactory.getLogger(getClass)

    private def writeObject(out: ObjectOutputStream): Unit = tryOrIOException {
      log.info("DefaultSource.writeObject")
      out.defaultWriteObject()
      value.write(out)
    }

    private def readObject(in: ObjectInputStream): Unit = tryOrIOException {
      log.info("DefaultSource.readObject")
      value = new Configuration(false)
      value.readFields(in)
    }

    private def tryOrIOException[T](block: => T): T = {
      try {
        block
      } catch {
        case e: IOException =>
          log.error("Exception encountered", e)
          throw e
        case NonFatal(e) =>
          log.error("Exception encountered", e)
          throw new IOException(e)
      }
    }
  }
}

