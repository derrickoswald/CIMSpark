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
import ch.ninecode.ACLineSegment
import ch.ninecode.Terminal
import ch.ninecode.ConnectivityNode
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions
import scala.Stream

case class Pair (id_equ: String, var left: Terminal = null, var right: Terminal = null)
case class Edge (id_seq_1: String, id_seq_2: String, id_equ: String, length: Float)

class CIMRelation(
    override val paths: Array[String],
    private val maybeDataSchema: Option[StructType],
    override val userDefinedPartitionColumns: Option[StructType],
    private val parameters: Map[String, String])
    (@transient val sqlContext: SQLContext) extends HadoopFsRelation with Logging
{

//  private val IgnoreFilesWithoutExtensionProperty = "avro.mapred.ignore.inputs.without.extension"
//  private val recordName = parameters.getOrElse("recordName", "topLevelRecord")
//  private val recordNamespace = parameters.getOrElse("recordNamespace", "")

    logInfo ("paths: " + paths.mkString (","))
    logInfo ("maybeDataSchema: " + maybeDataSchema.toString ())
    logInfo ("userDefinedPartitionColumns: " + userDefinedPartitionColumns.toString ())
    logInfo ("parameters: " + parameters.toString ())
    logInfo ("sqlContext: " + sqlContext.toString ())

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
        logInfo ("ch.ninecode.DefaultSource.buildScan")

        var ret: RDD[Row] = null

        if (inputFiles.length > 0)
        {
            // make a config
            val configuration = new Configuration (sqlContext.sparkContext.hadoopConfiguration)
            configuration.set ("mapreduce.input.fileinputformat.inputdir", inputFiles (0).getPath.toString);

            val rdd = sqlContext.sparkContext.newAPIHadoopRDD (
                configuration,
                classOf[ch.ninecode.CIMInputFormat],
                classOf[String],
                classOf[ch.ninecode.Element]).values

            ret = rdd.asInstanceOf[RDD[Row]]

            // as a side effect, define all the other temporary tables
            sqlContext.createDataFrame (rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.Unknown] => x.asInstanceOf[ch.ninecode.Unknown]})).registerTempTable ("Unknown")
            sqlContext.createDataFrame (rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.PSRType] => x.asInstanceOf[ch.ninecode.PSRType]})).registerTempTable ("PSRType")
            sqlContext.createDataFrame (rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.Line] => x.asInstanceOf[ch.ninecode.Line]})).registerTempTable ("Line")
            sqlContext.createDataFrame (rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.Subnetwork] => x.asInstanceOf[ch.ninecode.Subnetwork]})).registerTempTable ("Subnetwork")
            val connectivitynodes = rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.ConnectivityNode] => x.asInstanceOf[ch.ninecode.ConnectivityNode]})
            sqlContext.createDataFrame (connectivitynodes).registerTempTable ("ConnectivityNode")
            sqlContext.createDataFrame (rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.Voltage] => x.asInstanceOf[ch.ninecode.Voltage]})).registerTempTable ("Voltage")
            sqlContext.createDataFrame (rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.CoordinateSystem] => x.asInstanceOf[ch.ninecode.CoordinateSystem]})).registerTempTable ("CoordinateSystem")
            sqlContext.createDataFrame (rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.Location] => x.asInstanceOf[ch.ninecode.Location]})).registerTempTable ("Location")
            sqlContext.createDataFrame (rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.PositionPoint] => x.asInstanceOf[ch.ninecode.PositionPoint]})).registerTempTable ("PositionPoint")
            sqlContext.createDataFrame (rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.Asset] => x.asInstanceOf[ch.ninecode.Asset]})).registerTempTable ("Asset")
            val consumers = rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.Consumer] => x.asInstanceOf[ch.ninecode.Consumer]})
            sqlContext.createDataFrame (consumers).registerTempTable ("Consumer")
            val terminals = rdd.collect ({ case x: Element if x.getClass () == classOf[Terminal] => x.asInstanceOf[Terminal]})
            sqlContext.createDataFrame (terminals).registerTempTable ("Terminal")
            sqlContext.createDataFrame (rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.BusbarInfo] => x.asInstanceOf[ch.ninecode.BusbarInfo]})).registerTempTable ("BusbarInfo")
            val busbarsections = rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.BusbarSection] => x.asInstanceOf[ch.ninecode.BusbarSection]})
            sqlContext.createDataFrame (busbarsections).registerTempTable ("BusbarSection")
            sqlContext.createDataFrame (rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.CableInfo] => x.asInstanceOf[ch.ninecode.CableInfo]})).registerTempTable ("CableInfo")
            val aclinesegments = rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.ACLineSegment] => x.asInstanceOf[ch.ninecode.ACLineSegment]})
            sqlContext.createDataFrame (aclinesegments).registerTempTable ("ACLineSegment")
            sqlContext.createDataFrame (rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.ACLineSegmentPhase] => x.asInstanceOf[ch.ninecode.ACLineSegmentPhase]})).registerTempTable ("ACLineSegmentPhase")
            sqlContext.createDataFrame (rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.SwitchInfo] => x.asInstanceOf[ch.ninecode.SwitchInfo]})).registerTempTable ("SwitchInfo")
            val switchs = rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.Switch] => x.asInstanceOf[ch.ninecode.Switch]})
            sqlContext.createDataFrame (switchs).registerTempTable ("Switch")
            sqlContext.createDataFrame (rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.PowerTransformerInfo] => x.asInstanceOf[ch.ninecode.PowerTransformerInfo]})).registerTempTable ("PowerTransformerInfo")
            sqlContext.createDataFrame (rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.TransformerTankInfo] => x.asInstanceOf[ch.ninecode.TransformerTankInfo]})).registerTempTable ("TransformerTankInfo")
            sqlContext.createDataFrame (rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.TransformerEndInfo] => x.asInstanceOf[ch.ninecode.TransformerEndInfo]})).registerTempTable ("TransformerEndInfo")
            val transformers = rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.PowerTransformer] => x.asInstanceOf[ch.ninecode.PowerTransformer]})
            sqlContext.createDataFrame (transformers).registerTempTable ("PowerTransformer")
            sqlContext.createDataFrame (rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.TransformerTank] => x.asInstanceOf[ch.ninecode.TransformerTank]})).registerTempTable ("TransformerTank")
            sqlContext.createDataFrame (rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.TransformerTankEnd] => x.asInstanceOf[ch.ninecode.TransformerTankEnd]})).registerTempTable ("TransformerTankEnd")

            // SAP IS-U
            sqlContext.createDataFrame (rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.ServiceLocation] => x.asInstanceOf[ch.ninecode.ServiceLocation]})).registerTempTable ("ServiceLocation")
            sqlContext.createDataFrame (rdd.collect ({ case x: Element if x.getClass () == classOf[ch.ninecode.Customer] => x.asInstanceOf[ch.ninecode.Customer]})).registerTempTable ("Customer")

            // set up edge graph

            // first get the pairs of terminals keyed by equipment
            val pair_seq_op = (l: Pair /* null */, r: Terminal) ⇒
            {
                if (null == l)
                    Pair (r.equipment, r)
                else
                {
                    if (null != l.right)
                        throw new IllegalStateException ("three terminals")
                    l.right = r
                    l
                }
            }
            val pair_comb_op = (l: Pair, r: Pair) ⇒
            {
                if ((null != l.right) || (null != r.right))
                    throw new IllegalStateException ("three terminals")
                if (1 == l.left.sequence)
                    l.right = r.left
                else
                {   // swap so seq#1 is left
                    l.right = l.left
                    l.left = r.left
                }
                l
            }
            val terms = terminals.keyBy (_.equipment).aggregateByKey (null: Pair) (pair_seq_op, pair_comb_op).values

            // next, map the pairs to edges
            val term_op =
            {
                p: Pair =>
                {
                    Edge (
                        p.left.id,
                        if (null != p.right) p.right.id else "",
                        p.left.equipment,
                        0)
                }
            }
            var edges = terms.map (term_op)

            // add the length value if it is an ACLineSegment by perfoming a left outer join
            val edgepairs = edges.keyBy (_.id_equ)
            val lines = aclinesegments.keyBy (_.id)
            // all pairs (k, (v, Some(w))) for w in other, or the pair (k, (v, None)) if no elements in other have key k
            val edge_op =
            {
                j: Any =>
                {
                    j match
                    {
                        case (s: String, (e:Edge, Some (ac:ACLineSegment)))
                            => Edge (e.id_seq_1, e.id_seq_2, e.id_equ, ac.len.toFloat) // ToDo: avoid reallocation here
                        case (s: String, (e:Edge, None))
                            => e
                    }
                }
            }
            edges = edgepairs.leftOuterJoin (lines).map (edge_op)

            // change terminal id to node id
            val left_op =
            {
                j: Any =>
                {
                    j match
                    {
                        case (s: String, (e:Edge, Some (t:Terminal)))
                            => Edge (if (t.connectivity != null) t.connectivity else e.id_seq_1, e.id_seq_2, e.id_equ, e.length) // ToDo: avoid reallocation here
                        case (s: String, (e:Edge, None))
                            => e
                    }
                }
            }
            edges = edges.keyBy (_.id_seq_1).leftOuterJoin (terminals.keyBy (_.id)).map (left_op)
            val right_op =
            {
                j: Any =>
                {
                    j match
                    {
                        case (s: String, (e:Edge, Some (t:Terminal)))
                            => Edge (e.id_seq_1, if (t.connectivity != null) t.connectivity else e.id_seq_2, e.id_equ, e.length) // ToDo: avoid reallocation here
                        case (s: String, (e:Edge, None))
                            => e
                    }
                }
            }
            edges = edges.keyBy (_.id_seq_2).leftOuterJoin (terminals.keyBy (_.id)).map (right_op)

            // change node id to node name
            val left_op2 =
            {
                j: Any =>
                {
                    j match
                    {
                        case (s: String, (e:Edge, Some (c:ConnectivityNode)))
                            => Edge (if (c.name != null) c.name else e.id_seq_1, e.id_seq_2, e.id_equ, e.length) // ToDo: avoid reallocation here
                        case (s: String, (e:Edge, None))
                            => e
                    }
                }
            }
            edges = edges.keyBy (_.id_seq_1).leftOuterJoin (connectivitynodes.keyBy (_.id)).map (left_op2)
            val right_op2 =
            {
                j: Any =>
                {
                    j match
                    {
                        case (s: String, (e:Edge, Some (c:ConnectivityNode)))
                            => Edge (e.id_seq_1, if (c.name != null) c.name else e.id_seq_2, e.id_equ, e.length) // ToDo: avoid reallocation here
                        case (s: String, (e:Edge, None))
                            => e
                    }
                }
            }
            edges = edges.keyBy (_.id_seq_2).leftOuterJoin (connectivitynodes.keyBy (_.id)).map (right_op2)

            // expose it
            sqlContext.createDataFrame (edges).registerTempTable ("edges")
        }
        else
            logError ("ch.ninecode.DefaultSource.buildScan was given an input list containing no files")

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
