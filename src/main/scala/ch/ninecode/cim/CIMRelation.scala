/*
 * Copyright 2014 Databricks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ch.ninecode.cim

import scala.collection.Iterator
import scala.collection.JavaConversions._
import com.google.common.base.Objects
import org.apache.hadoop.fs.{FileStatus, FileSystem, Path}
import org.apache.hadoop.mapreduce.Job
import org.apache.spark.Logging
import org.apache.spark.rdd.{RDD, UnionRDD}
import org.apache.spark.sql.sources._
import org.apache.spark.sql.types._
import org.apache.spark.sql.{Row, SQLContext}
import org.apache.hadoop.conf.Configuration
import ch.ninecode.CIMInputFormat
import ch.ninecode.Element
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions
import scala.Stream

class CIMRelation(
    override val paths: Array[String],
    private val maybeDataSchema: Option[StructType],
    override val userDefinedPartitionColumns: Option[StructType],
    private val parameters: Map[String, String])
    (@transient val sqlContext: SQLContext) extends HadoopFsRelation with Logging {

//  private val IgnoreFilesWithoutExtensionProperty = "avro.mapred.ignore.inputs.without.extension"
//  private val recordName = parameters.getOrElse("recordName", "topLevelRecord")
//  private val recordNamespace = parameters.getOrElse("recordNamespace", "")

    logInfo ("ch.ninecode.CIMRelation")
    logInfo ("paths: " + paths.mkString (","))
    logInfo ("maybeDataSchema: " + maybeDataSchema.toString ())
    logInfo ("userDefinedPartitionColumns: " + userDefinedPartitionColumns.toString ())
    logInfo ("parameters: " + parameters.toString ())
    logInfo ("sqlContext: " + sqlContext.toString ())


    // Define the schema using a case class.
    // Note: Case classes in Scala 2.10 can support only up to 22 fields. To work around this limit,
    // you can use custom classes that implement the Product interface.
    case class Person(name: String, age: Int)

    // create an RDD of Person objects and register it as a table
    var people0 = scala.collection.mutable.HashMap.empty[String, Int]
    people0 += ("Derrick" -> 58)
    people0 += ("Jacqueline" -> 56)
    val people1 = sqlContext.sparkContext.parallelize(people0.toSeq)
    val people = sqlContext.createDataFrame (people1)
    people.registerTempTable ("people")

    // create an RDD from the CIM file and register various tables

    // make a config
    val configuration = new Configuration (sqlContext.sparkContext.hadoopConfiguration)
    configuration.set ("mapreduce.input.fileinputformat.inputdir", paths (0));


  /**
   * Specifies schema of actual data files.  For partitioned relations, if one or more partitioned
   * columns are contained in the data files, they should also appear in `dataSchema`.
   *
   * @since 1.4.0
   */
  override def dataSchema: StructType =
  {
      val struct = StructType (StructField ("key", StringType, true) :: Nil)
      maybeDataSchema match
      {
        case Some(structType) => structType
        case None => struct // SchemaConverters.toSqlType(avroSchema).dataType.asInstanceOf[StructType]
      }
  }

  /**
   * Prepares a write job and returns an [[OutputWriterFactory]].  Client side job preparation can
   * be put here.  For example, user defined output committer can be configured here
   * by setting the output committer class in the conf of spark.sql.sources.outputCommitterClass.
   *
   * Note that the only side effect expected here is mutating `job` via its setters.  Especially,
   * Spark SQL caches [[BaseRelation]] instances for performance, mutating relation internal states
   * may cause unexpected behaviors.
   *
   * @since 1.4.0
   */
  override def prepareJobForWrite(job: Job): OutputWriterFactory = {
//    val build = SchemaBuilder.record(recordName).namespace(recordNamespace)
//    val outputAvroSchema = SchemaConverters.convertStructToAvro(dataSchema, build, recordNamespace)
//    AvroJob.setOutputKeySchema(job, outputAvroSchema)
//    val AVRO_COMPRESSION_CODEC = "spark.sql.avro.compression.codec"
//    val AVRO_DEFLATE_LEVEL = "spark.sql.avro.deflate.level"
//    val COMPRESS_KEY = "mapred.output.compress"
//
//    sqlContext.getConf(AVRO_COMPRESSION_CODEC, "snappy") match {
//      case "uncompressed" =>
//        logInfo("writing Avro out uncompressed")
//        job.getConfiguration.setBoolean(COMPRESS_KEY, false)
//      case "snappy" =>
//        logInfo("using snappy for Avro output")
//        job.getConfiguration.setBoolean(COMPRESS_KEY, true)
//        job.getConfiguration.set(AvroJob.CONF_OUTPUT_CODEC, DataFileConstants.SNAPPY_CODEC)
//      case "deflate" =>
//        val deflateLevel = sqlContext.getConf(
//          AVRO_DEFLATE_LEVEL, Deflater.DEFAULT_COMPRESSION.toString).toInt
//        logInfo(s"using deflate: $deflateLevel for Avro output")
//        job.getConfiguration.setBoolean(COMPRESS_KEY, true)
//        job.getConfiguration.set(AvroJob.CONF_OUTPUT_CODEC, DataFileConstants.DEFLATE_CODEC)
//        job.getConfiguration.setInt(AvroOutputFormat.DEFLATE_LEVEL_KEY, deflateLevel)
//      case unknown: String => logError(s"compression $unknown is not supported")
//    }
//    new AvroOutputWriterFactory(dataSchema, recordName, recordNamespace)
      throw new UnsupportedOperationException ("oops, no writing yet")
  }

// For a non-partitioned relation, this method builds an RDD[Row] containing all rows within this relation.
    override def buildScan (inputFiles: Array[FileStatus]): RDD[Row] =
    {
        logInfo ("ch.ninecode.DefaultSource.buildScan")
        // make a config
        val configuration = new Configuration (sqlContext.sparkContext.hadoopConfiguration)
        configuration.set ("mapreduce.input.fileinputformat.inputdir", inputFiles (0).getPath.toString);

        val rdd = sqlContext.sparkContext.newAPIHadoopRDD (
            configuration,
            classOf[ch.ninecode.CIMInputFormat],
            classOf[String],
            classOf[ch.ninecode.Element]).values

        val ret: RDD[Row] = rdd.map (x => Row (x.key))

        // as a side effect, define all the other temporary tables
//        val points = sqlContext.createDataFrame (rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.PositionPoint] => x.asInstanceOf[ch.ninecode.PositionPoint]}))
//        points.registerTempTable ("points")
        sqlContext.createDataFrame (rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.Unknown] => x.asInstanceOf[ch.ninecode.Unknown]})).registerTempTable ("Unknown")
        sqlContext.createDataFrame (rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.PSRType] => x.asInstanceOf[ch.ninecode.PSRType]})).registerTempTable ("PSRType")
        sqlContext.createDataFrame (rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.Line] => x.asInstanceOf[ch.ninecode.Line]})).registerTempTable ("Line")
        sqlContext.createDataFrame (rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.Subnetwork] => x.asInstanceOf[ch.ninecode.Subnetwork]})).registerTempTable ("Subnetwork")
        sqlContext.createDataFrame (rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.ConnectivityNode] => x.asInstanceOf[ch.ninecode.ConnectivityNode]})).registerTempTable ("ConnectivityNode")
        sqlContext.createDataFrame (rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.Voltage] => x.asInstanceOf[ch.ninecode.Voltage]})).registerTempTable ("Voltage")
        sqlContext.createDataFrame (rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.CoordinateSystem] => x.asInstanceOf[ch.ninecode.CoordinateSystem]})).registerTempTable ("CoordinateSystem")
        sqlContext.createDataFrame (rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.Location] => x.asInstanceOf[ch.ninecode.Location]})).registerTempTable ("Location")
        sqlContext.createDataFrame (rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.PositionPoint] => x.asInstanceOf[ch.ninecode.PositionPoint]})).registerTempTable ("PositionPoint")
        sqlContext.createDataFrame (rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.Asset] => x.asInstanceOf[ch.ninecode.Asset]})).registerTempTable ("Asset")
        sqlContext.createDataFrame (rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.Consumer] => x.asInstanceOf[ch.ninecode.Consumer]})).registerTempTable ("Consumer")
        sqlContext.createDataFrame (rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.Terminal] => x.asInstanceOf[ch.ninecode.Terminal]})).registerTempTable ("Terminal")
        sqlContext.createDataFrame (rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.BusbarInfo] => x.asInstanceOf[ch.ninecode.BusbarInfo]})).registerTempTable ("BusbarInfo")
        sqlContext.createDataFrame (rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.BusbarSection] => x.asInstanceOf[ch.ninecode.BusbarSection]})).registerTempTable ("BusbarSection")
        sqlContext.createDataFrame (rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.CableInfo] => x.asInstanceOf[ch.ninecode.CableInfo]})).registerTempTable ("CableInfo")
        sqlContext.createDataFrame (rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.ACLineSegment] => x.asInstanceOf[ch.ninecode.ACLineSegment]})).registerTempTable ("ACLineSegment")
        sqlContext.createDataFrame (rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.ACLineSegmentPhase] => x.asInstanceOf[ch.ninecode.ACLineSegmentPhase]})).registerTempTable ("ACLineSegmentPhase")
        sqlContext.createDataFrame (rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.SwitchInfo] => x.asInstanceOf[ch.ninecode.SwitchInfo]})).registerTempTable ("SwitchInfo")
        sqlContext.createDataFrame (rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.Switch] => x.asInstanceOf[ch.ninecode.Switch]})).registerTempTable ("Switch")
        sqlContext.createDataFrame (rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.PowerTransformerInfo] => x.asInstanceOf[ch.ninecode.PowerTransformerInfo]})).registerTempTable ("PowerTransformerInfo")
        sqlContext.createDataFrame (rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.TransformerTankInfo] => x.asInstanceOf[ch.ninecode.TransformerTankInfo]})).registerTempTable ("TransformerTankInfo")
        sqlContext.createDataFrame (rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.TransformerEndInfo] => x.asInstanceOf[ch.ninecode.TransformerEndInfo]})).registerTempTable ("TransformerEndInfo")
        sqlContext.createDataFrame (rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.PowerTransformer] => x.asInstanceOf[ch.ninecode.PowerTransformer]})).registerTempTable ("PowerTransformer")
        sqlContext.createDataFrame (rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.TransformerTank] => x.asInstanceOf[ch.ninecode.TransformerTank]})).registerTempTable ("TransformerTank")
        sqlContext.createDataFrame (rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.TransformerTankEnd] => x.asInstanceOf[ch.ninecode.TransformerTankEnd]})).registerTempTable ("TransformerTankEnd")

        // SAP IS-U
        sqlContext.createDataFrame (rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.ServiceLocation] => x.asInstanceOf[ch.ninecode.ServiceLocation]})).registerTempTable ("ServiceLocation")
        sqlContext.createDataFrame (rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.Customer] => x.asInstanceOf[ch.ninecode.Customer]})).registerTempTable ("Customer")

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
//      logInfo ("ch.ninecode.DefaultSource.buildScan with requiredColumns")
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
//                classOf[ch.ninecode.CIMInputFormat],
//                classOf[String],
//                classOf[ch.ninecode.Element]).values
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
//                        (record: ch.ninecode.Element) => rowBuffer(idx) = (item: Any) => if (item == null) null else item.toString
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
  override def hashCode(): Int = Objects.hashCode(paths.toSet, dataSchema, schema, partitionColumns)

  /**
   * Opens up the location to for reading. Takes in a function to run on the schema and returns the
   * result of this function. This takes in a function so that the caller does not have to worry
   * about cleaning up and closing the reader.
   * @param location the location in the filesystem to read from
   * @param fun the function that is called on when the reader has been initialized
   * @tparam T the return type of the function given
   */
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
