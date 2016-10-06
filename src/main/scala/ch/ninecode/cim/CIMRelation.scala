package ch.ninecode.cim

import java.util.Objects

import scala.util.Sorting
import scala.reflect.runtime.universe

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.FileStatus
import org.apache.hadoop.mapreduce.Job
import org.apache.spark.Logging
import org.apache.spark.rdd.RDD
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions
import org.apache.spark.sql.Row
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.catalyst.ScalaReflection
import org.apache.spark.sql.sources.HadoopFsRelation
import org.apache.spark.sql.sources.OutputWriterFactory
import org.apache.spark.sql.types.StringType
import org.apache.spark.sql.types.StructField
import org.apache.spark.sql.types.StructType
import org.apache.spark.storage.StorageLevel

import scala.reflect._
import scala.reflect.runtime.universe._
import scala.reflect.runtime.{universe => ru}

import ch.ninecode.model._

class CIMRelation(
    override val paths: Array[String],
    private val maybeDataSchema: Option[StructType],
    override val userDefinedPartitionColumns: Option[StructType],
    private val parameters: Map[String, String])
    (@transient val sqlContext: SQLContext) extends HadoopFsRelation with Logging
{
    // check for a storage level option
    val _StorageLevel: StorageLevel = StorageLevel.fromString (parameters.getOrElse ("StorageLevel", "MEMORY_ONLY"))
    // check for edge creation option
    val _Edges: Boolean = parameters.getOrElse ("ch.ninecode.cim.make_edges", "false").toBoolean
    // check for ISU join option
    val _Join: Boolean = parameters.getOrElse ("ch.ninecode.cim.do_join", "false").toBoolean
    // check for NTP option
    val _Topo: Boolean = parameters.getOrElse ("ch.ninecode.cim.do_topo", "false").toBoolean
    // check for NTP island option
    val _Islands: Boolean = parameters.getOrElse ("ch.ninecode.cim.do_topo_islands", "false").toBoolean

    logInfo ("paths: " + paths.mkString (","))
    logInfo ("maybeDataSchema: " + maybeDataSchema.toString ())
    logInfo ("userDefinedPartitionColumns: " + userDefinedPartitionColumns.toString ())
    logInfo ("parameters: " + parameters.toString ())
    logInfo ("sqlContext: " + sqlContext.toString ())
    logInfo ("storage: " + _StorageLevel.description)

    // just to get a schema
    case class dummy
    (
        override val sup: Element = null
    )
    extends
        Element

    /**
     * Specifies schema of actual data files.  For partitioned relations, if one or more partitioned
     * columns are contained in the data files, they should also appear in `dataSchema`.
     *
     * @since 1.4.0
     */
    override def dataSchema: StructType =
    {
        // we cheat here: the elements in the elements rdd are full Scala hierarchical objects,
        // but we say here they only have one field of type Element because for some that is all they have
        // (lowest common denominator)
        val element = ScalaReflection.schemaFor[dummy].dataType.asInstanceOf[StructType]
        maybeDataSchema match
        {
          case Some (structType) => structType
          case None => element
        }
    }

    /**
     * Prepares a write job and returns an OutputWriterFactory.  Client side job preparation can
     * be put here.  For example, user defined output committer can be configured here
     * by setting the output committer class in the conf of spark.sql.sources.outputCommitterClass.
     *
     * Note that the only side effect expected here is mutating `job` via its setters.  Especially,
     * Spark SQL caches BaseRelation instances for performance, mutating relation internal states
     * may cause unexpected behaviors.
     *
     * @since 1.4.0
     */
    override def prepareJobForWrite(job: Job): OutputWriterFactory =
    {
//        val build = SchemaBuilder.record(recordName).namespace(recordNamespace)
//        val outputAvroSchema = SchemaConverters.convertStructToAvro(dataSchema, build, recordNamespace)
//        AvroJob.setOutputKeySchema(job, outputAvroSchema)
//        val AVRO_COMPRESSION_CODEC = "spark.sql.avro.compression.codec"
//        val AVRO_DEFLATE_LEVEL = "spark.sql.avro.deflate.level"
//        val COMPRESS_KEY = "mapred.output.compress"
//
//        sqlContext.getConf(AVRO_COMPRESSION_CODEC, "snappy") match {
//            case "uncompressed" =>
//                logInfo("writing Avro out uncompressed")
//                job.getConfiguration.setBoolean(COMPRESS_KEY, false)
//            case "snappy" =>
//                logInfo("using snappy for Avro output")
//                job.getConfiguration.setBoolean(COMPRESS_KEY, true)
//                job.getConfiguration.set(AvroJob.CONF_OUTPUT_CODEC, DataFileConstants.SNAPPY_CODEC)
//            case "deflate" =>
//                val deflateLevel = sqlContext.getConf(
//                  AVRO_DEFLATE_LEVEL, Deflater.DEFAULT_COMPRESSION.toString).toInt
//                logInfo(s"using deflate: $deflateLevel for Avro output")
//                job.getConfiguration.setBoolean(COMPRESS_KEY, true)
//                job.getConfiguration.set(AvroJob.CONF_OUTPUT_CODEC, DataFileConstants.DEFLATE_CODEC)
//                job.getConfiguration.setInt(AvroOutputFormat.DEFLATE_LEVEL_KEY, deflateLevel)
//            case unknown: String => logError(s"compression $unknown is not supported")
//        }
//        new AvroOutputWriterFactory(dataSchema, recordName, recordNamespace)
        throw new UnsupportedOperationException ("oops, no writing yet")
    }

    // For a non-partitioned relation, this method builds an RDD[Row] containing all rows within this relation.
    override def buildScan (inputFiles: Array[FileStatus]): RDD[Row] =
    {
        logInfo ("buildScan")
        logInfo ("storage: " + _StorageLevel.description)

        var ret: RDD[Row] = null

        if (inputFiles.length > 0)
        {
            // make a config
            val configuration = new Configuration (sqlContext.sparkContext.hadoopConfiguration)
            val filename = inputFiles.map (_.getPath.toString).mkString (",")
            configuration.set ("mapreduce.input.fileinputformat.inputdir", filename);

            val rdd = sqlContext.sparkContext.newAPIHadoopRDD (
                configuration,
                classOf[CIMInputFormat],
                classOf[String],
                classOf[Element]).values

            ret = rdd.asInstanceOf[RDD[Row]]
            ret.setName ("Elements") // persist it
            ret.persist (_StorageLevel)

            // as a side effect, define all the other temporary tables
            logInfo ("creating temporary tables")
            CHIM.apply_to_all_classes (
                (subsetter: CIMSubsetter[_]) =>
                {
                    // sometimes this loop doesn't work well
                    // the symptoms are:
                    //     scala.reflect.runtime.ReflectError: value ch is not a package
                    // or
                    //     java.lang.RuntimeException: error reading Scala signature of ch.ninecode.model.BusBarSectionInfo: value model is not a package
                    // due to https://issues.apache.org/jira/browse/SPARK-2178
                    // which is due to https://issues.scala-lang.org/browse/SI-6240
                    // and described in http://docs.scala-lang.org/overviews/reflection/thread-safety.html
                    // p.s. Scala's type system is a shit show of kludgy code
                    logInfo ("building " + subsetter.cls)
                    subsetter.make (sqlContext, rdd, _StorageLevel)
                }
            )

            // set up edge graph if requested
            if (_Edges)
            {
                logInfo ("making Edges RDD")
                val cimedges = new CIMEdges (sqlContext, _StorageLevel)
                cimedges.make_edges ()
            }

            // merge ISU and NIS ServiceLocations if requested
            if (_Join)
            {
                logInfo ("joining ISU and NIS")
                val join = new CIMJoin (sqlContext, _StorageLevel)
                join.do_join ()
            }

            // perform topological processing if requested
            if (_Topo || _Islands)
            {
                logInfo ("performing Network Topology Processing")
                val ntp = new CIMNetworkTopologyProcessor (sqlContext, _StorageLevel)
                ntp.process (_Islands)
            }
        }
        else
            logError ("buildScan was given an input list containing no files")

        return (ret)
  }

//  /**
//   * Filters out unneeded columns before converting into the internal row representation.
//   * The first record is used to get the sub-schema that contains only the requested fields,
//   * this is then used to generate the field converters and the rows that only
//   * contain `requiredColumns`
//   */
//  override def buildScan(requiredColumns: Array[String], inputs: Array[FileStatus]): RDD[Row] =
//  {
//      logInfo ("ch.ninecode.cim.DefaultSource.buildScan with requiredColumns")
//      logInfo ("requiredColumns: " + requiredColumns.mkString (","))
//      logInfo ("inputs: " + inputs.mkString (","))
//      if (inputs.isEmpty)
//        sqlContext.sparkContext.emptyRDD[Row]
//      else
//      {
//          new UnionRDD[Row](sqlContext.sparkContext,
//          inputs.map(path =>
//              {
//            // make a config
//            val configuration = new Configuration (sqlContext.sparkContext.hadoopConfiguration)
//            configuration.set ("mapreduce.input.fileinputformat.inputdir", path.getPath.toString);
//
//            sqlContext.sparkContext.newAPIHadoopRDD (
//              configuration,
//                classOf[CIMInputFormat],
//                classOf[String],
//                classOf[Element]).values
//    //          classOf[org.apache.avro.mapred.AvroInputFormat[GenericRecord]],
//    //          classOf[org.apache.avro.mapred.AvroWrapper[GenericRecord]],
//    //          classOf[org.apache.hadoop.io.NullWritable]).keys.map(_.datum())
//              .mapPartitions { records =>
//                if (records.isEmpty)
//                  Iterator.empty
//                else
//                {
//
//                  val firstRecord = records.next()
//    //              val superSchema = firstRecord.getSchema // the schema of the actual record
//    //              // the fields that are actually required along with their converters
//    //              val avroFieldMap = superSchema.getFields.map(f => (f.name, f)).toMap
//
//                  new Iterator[Row] {
//                    private[this] val baseIterator = records
//                    private[this] var currentRecord = firstRecord
//                    private[this] val rowBuffer = new Array[Any](requiredColumns.length)
//                    // A micro optimization to avoid allocating a WrappedArray per row.
//                    private[this] val bufferSeq = rowBuffer.toSeq
//
//                    // An array of functions that pull a column out of an avro record and puts the
//                    // converted value into the correct slot of the rowBuffer.
//                    private[this] val fieldExtractors = requiredColumns.zipWithIndex.map {
//                      case (columnName, idx) =>
//                        (record: Element) => rowBuffer(idx) = (item: Any) => if (item == null) null else item.toString
//                    }
//
//                    private def advanceNextRecord() = {
//                      if (baseIterator.hasNext) {
//                        currentRecord = baseIterator.next()
//                        true
//                      } else {
//                        false
//                      }
//                    }
//
//                    def hasNext = {
//                      currentRecord != null || advanceNextRecord()
//                    }
//
//                    def next() = {
//                      assert(hasNext)
//                      var i = 0
//                      while (i < fieldExtractors.length) {
//                        fieldExtractors(i)(currentRecord)
//                        i += 1
//                      }
//                      currentRecord = null
//                      Row.fromSeq(bufferSeq)
//                    }
//                  }
//                }
//            }}))
//    }
//  }

  /**
   * Checks to see if the given Any is the same avro relation based off of the input paths, schema,
   * and partitions
   */
  override def equals(other: Any): Boolean = other match {
    case that: CIMRelation => paths.toSet == that.paths.toSet &&
                                dataSchema == that.dataSchema &&
                                schema == that.schema &&
                                partitionColumns == that.partitionColumns
    case _ => false
  }

  /**
   * Generates a unique has of this relation based off of its paths, schema, and partition
   */
  override def hashCode(): Int = Objects.hash(paths.toSet, dataSchema, schema, partitionColumns)

//  /**
//   * Opens up the location to for reading. Takes in a function to run on the schema and returns the
//   * result of this function. This takes in a function so that the caller does not have to worry
//   * about cleaning up and closing the reader.
//   * @param location the location in the filesystem to read from
//   * @param fun the function that is called on when the reader has been initialized
//   * @tparam T the return type of the function given
//   */
//  private def newReader[T](location: String)(fun: FileReader[GenericRecord] => T): T = {
//    val path = new Path(location)
//    val hadoopConfiguration = sqlContext.sparkContext.hadoopConfiguration
//    val fs = FileSystem.get(path.toUri, hadoopConfiguration)
//
//    val statuses = fs.globStatus(path) match {
//      case null => throw new FileNotFoundException(s"The path ($location) is invalid.")
//      case globStatus => globStatus.toStream.map(_.getPath).flatMap(getAllFiles(fs, _))
//    }
//
//    val singleFile =
//      (if (hadoopConfiguration.getBoolean(IgnoreFilesWithoutExtensionProperty, true)) {
//        statuses.find(_.getName.endsWith("avro"))
//      } else {
//        statuses.headOption
//      }).getOrElse(throw new FileNotFoundException(s"No avro files present at ${path.toString}"))
//
//    val reader = DataFileReader.openReader(new FsInput(singleFile, hadoopConfiguration),
//      new GenericDatumReader[GenericRecord]())
//    val result = fun(reader)
//    reader.close()
//    result
//  }

//  private def getAllFiles(fs: FileSystem, path: Path): Stream[Path] = {
//    if (fs.isDirectory(path)) {
//      fs.listStatus(path).toStream.map(_.getPath).flatMap(getAllFiles(fs, _))
//    } else {
//      Stream(path)
//    }
//  }
}
