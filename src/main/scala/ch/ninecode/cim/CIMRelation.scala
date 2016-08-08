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

import scala.reflect._
import scala.reflect.runtime.universe._
import scala.reflect.runtime.{universe => ru}

import ch.ninecode.model._

case class PreEdge (var id_seq_1: String, var cn_1: String, var id_seq_2: String, var cn_2: String, var id_equ: String, var container: String, var length: Double, var voltage: String, var typ: String, var normalOpen: Boolean, var ratedCurrent: Double, var location: String, val power: Double, val commissioned: String, val status: String) extends Serializable
class Extremum (val id_loc: String, var min_index: Int, var x1 : String, var y1 : String, var max_index: Int, var x2 : String, var y2 : String) extends Serializable
case class Edge (id_seq_1: String, id_seq_2: String, id_equ: String, container: String, length: Double, voltage: String, typ: String, normalOpen: Boolean, ratedCurrent: Double, power: Double, commissioned: String, val status: String, x1: String, y1: String, x2: String, y2: String)

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

    def get (name: String): RDD[Element] =
    {
        val rdds = sqlContext.sparkContext.getPersistentRDDs
        for (key <- rdds.keys)
        {
            val rdd = rdds (key)
            if (rdd.name == name)
                return (rdd.asInstanceOf[RDD[Element]])
        }
        return (null)
    }

    // For a non-partitioned relation, this method builds an RDD[Row] containing all rows within this relation.
    override def buildScan (inputFiles: Array[FileStatus]): RDD[Row] =
    {
        logInfo ("ch.ninecode.cim.DefaultSource.buildScan")

        var ret: RDD[Row] = null

        if (inputFiles.length > 0)
        {
            // make a config
            val configuration = new Configuration (sqlContext.sparkContext.hadoopConfiguration)
            val filename = inputFiles (0).getPath.toString
            configuration.set ("mapreduce.input.fileinputformat.inputdir", filename);

            val rdd = sqlContext.sparkContext.newAPIHadoopRDD (
                configuration,
                classOf[CIMInputFormat],
                classOf[String],
                classOf[Element]).values

            ret = rdd.asInstanceOf[RDD[Row]]
            ret.setName ("Elements") // persist it
            ret.cache ()

            // as a side effect, define all the other temporary tables
            logInfo ("creating temporary tables")
            CHIM.apply_to_all_classes (
                (subsetter: CIMSubsetter[_]) =>
                {
                    logInfo ("building " + subsetter.cls)
                    subsetter.make (sqlContext, rdd)
                }
            )

            val connectivitynodes = get ("ConnectivityNode").asInstanceOf[RDD[ConnectivityNode]]
            val points = get ("PositionPoint").asInstanceOf[RDD[PositionPoint]]
            val terminals = get ("Terminal").asInstanceOf[RDD[Terminal]]
            val aclinesegments = get ("ACLineSegment").asInstanceOf[RDD[ACLineSegment]]

            // set up edge graph if it's not an ISU file
            if (!filename.contains ("ISU"))
            {
                // first get the terminals keyed by equipment
                val terms = terminals.groupBy (_.ConductingEquipment) // groupBy[K](f: (T) ⇒ K)(implicit kt: ClassTag[K]): RDD[(K, Iterable[T])]

                // next, map the terminal pairs to pre-edges
                val term_op =
                {
                    (arg: Any) ⇒
                    {
                        arg match
                        {
                            case (e: Element, Some(it: Iterable[Terminal])) ⇒
                            {
                                var ret = List[PreEdge] ()

                                // sort terminals by sequence number
                                var terminals = it.toArray.sortWith (_.ACDCTerminal.sequenceNumber < _.ACDCTerminal.sequenceNumber)

                                // extract pertinent information from the equipment using a join
                                var container = ""
                                var length = 0.0
                                var voltage = ""
                                var typ = ""
                                var normalOpen = false
                                var ratedCurrent = 0.0
                                var location = ""
                                var power = 0.0
                                var commissioned = ""
                                var status = ""
                                Some(e) match
                                {
                                    case Some(o) if o.getClass () == classOf[PSRType] => { }
                                    case Some(o) if o.getClass () == classOf[SvStatus] => { }
                                    case Some(o) if o.getClass () == classOf[Line] => { }
                                    case Some(o) if o.getClass () == classOf[Substation] => { }
                                    case Some(o) if o.getClass () == classOf[VoltageLevel] => { }
                                    case Some(o) if o.getClass () == classOf[Bay] => { }
                                    case Some(o) if o.getClass () == classOf[ConnectivityNode] => { }
                                    case Some(o) if o.getClass () == classOf[BaseVoltage] => { }
                                    case Some(o) if o.getClass () == classOf[CoordinateSystem] => { }
                                    case Some(o) if o.getClass () == classOf[Location] => { }
                                    case Some(o) if o.getClass () == classOf[PositionPoint] => { };
                                    //case Some(o) if o.getClass () == classOf[Asset] => { }
                                    case Some(o) if o.getClass () == classOf[EnergyConsumer] =>
                                        {
                                            val ec = o.asInstanceOf[EnergyConsumer]
                                            container = ec.ConductingEquipment.Equipment.EquipmentContainer
                                            voltage = ec.ConductingEquipment.BaseVoltage
                                            location = ec.ConductingEquipment.Equipment.PowerSystemResource.Location
                                        }
                                    case Some(o) if o.getClass () == classOf[Terminal] => { }
                                    //case Some(o) if o.getClass () == classOf[BusbarInfo] => { }
                                    case Some(o) if o.getClass () == classOf[BusbarSection] =>
                                        {
                                            val bs = o.asInstanceOf[BusbarSection]
                                            container = bs.Connector.ConductingEquipment.Equipment.EquipmentContainer
                                            voltage = bs.Connector.ConductingEquipment.BaseVoltage
                                            location = bs.Connector.ConductingEquipment.Equipment.PowerSystemResource.Location
                                        }
                                    case Some(o) if o.getClass () == classOf[Connector] =>
                                        {
                                            val c = o.asInstanceOf[Connector]
                                            container = c.ConductingEquipment.Equipment.EquipmentContainer
                                            voltage = c.ConductingEquipment.BaseVoltage
                                            location = c.ConductingEquipment.Equipment.PowerSystemResource.Location
                                        }
                                    case Some(o) if o.getClass () == classOf[Junction] => { }
                                        {
                                            val j = o.asInstanceOf[Junction]
                                            container = j.Connector.ConductingEquipment.Equipment.EquipmentContainer
                                            voltage = j.Connector.ConductingEquipment.BaseVoltage
                                            location = j.Connector.ConductingEquipment.Equipment.PowerSystemResource.Location
                                        }
                                    //case Some(o) if o.getClass () == classOf[CableInfo] => { }
                                    case Some(o) if o.getClass () == classOf[ACLineSegment] =>
                                        {
                                            val ac = o.asInstanceOf[ACLineSegment]
                                            container = ac.Conductor.ConductingEquipment.Equipment.EquipmentContainer
                                            length = ac.Conductor.len
                                            voltage = ac.Conductor.ConductingEquipment.BaseVoltage
                                            typ = ac.Conductor.ConductingEquipment.Equipment.PowerSystemResource.IdentifiedObject.name
                                            location = ac.Conductor.ConductingEquipment.Equipment.PowerSystemResource.Location
                                            status = ac.Conductor.ConductingEquipment.SvStatus

                                        }
                                    case Some(o) if o.getClass () == classOf[ACLineSegmentPhase] => { }
                                    //case Some(o) if o.getClass () == classOf[SwitchInfo] => { }
                                    case Some(o) if o.getClass () == classOf[Switch] =>
                                        {
                                            val s = o.asInstanceOf[Switch]
                                            container = s.ConductingEquipment.Equipment.EquipmentContainer
                                            voltage = s.ConductingEquipment.BaseVoltage
                                            normalOpen = s.normalOpen
                                            ratedCurrent = s.ratedCurrent
                                            location = s.ConductingEquipment.Equipment.PowerSystemResource.Location
                                        }
                                    //case Some(o) if o.getClass () == classOf[PowerTransformerInfo] => { }
                                    //case Some(o) if o.getClass () == classOf[TransformerTankInfo] => { }
                                    //case Some(o) if o.getClass () == classOf[TransformerEndInfo] => { }
                                    case Some(o) if o.getClass () == classOf[PowerTransformer] =>
                                        {
                                            val t = o.asInstanceOf[PowerTransformer]
                                            container = t.ConductingEquipment.Equipment.EquipmentContainer
                                            typ = t.ConductingEquipment.Equipment.PowerSystemResource.IdentifiedObject.name
                                            location = t.ConductingEquipment.Equipment.PowerSystemResource.Location
                                        }
                                    case Some(o) if o.getClass () == classOf[TransformerTank] => { }
                                    case Some(o) if o.getClass () == classOf[TransformerTankEnd] =>
                                        {
                                            val te = o.asInstanceOf[TransformerTankEnd]
                                            voltage = te.TransformerEnd.BaseVoltage
                                        }
                                    case Some(o) if o.getClass () == classOf[Fuse] =>
                                        {
                                            val f = o.asInstanceOf[Fuse]
                                            container = f.Switch.ConductingEquipment.Equipment.EquipmentContainer
                                            voltage = f.Switch.ConductingEquipment.BaseVoltage
                                            normalOpen = f.Switch.normalOpen
                                            ratedCurrent = f.Switch.ratedCurrent
                                            location = f.Switch.ConductingEquipment.Equipment.PowerSystemResource.Location
                                        }
                                    case Some(o) if o.getClass () == classOf[Disconnector] => { }
                                        {
                                            val d = o.asInstanceOf[Disconnector]
                                            container = d.Switch.ConductingEquipment.Equipment.EquipmentContainer
                                            voltage = d.Switch.ConductingEquipment.BaseVoltage
                                            normalOpen = d.Switch.normalOpen
                                            ratedCurrent = d.Switch.ratedCurrent
                                            location = d.Switch.ConductingEquipment.Equipment.PowerSystemResource.Location
                                        }
                                    case Some(o) if o.getClass () == classOf[GroundDisconnector] =>
                                        {
                                            val gd = o.asInstanceOf[GroundDisconnector]
                                            container = gd.Switch.ConductingEquipment.Equipment.EquipmentContainer
                                            voltage = gd.Switch.ConductingEquipment.BaseVoltage
                                            normalOpen = gd.Switch.normalOpen
                                            ratedCurrent = gd.Switch.ratedCurrent
                                            location = gd.Switch.ConductingEquipment.Equipment.PowerSystemResource.Location
                                        }
                                    case Some(o) if o.getClass () == classOf[ProtectionEquipment] => { }
                                    //case Some(o) if o.getClass () == classOf[CurrentTransformer] => { }
                                    case Some(o) if o.getClass () == classOf[CurrentRelay] => { }
                                    case Some(o) if o.getClass () == classOf[SolarGeneratingUnit] =>
                                        {
                                            val sgu = o.asInstanceOf[SolarGeneratingUnit]
                                            location = sgu.GeneratingUnit.Equipment.PowerSystemResource.Location
                                            power = sgu.GeneratingUnit.ratedNetMaxP
                                            commissioned = sgu.commissioningDate
                                        }

                                    case Some(o) if o.getClass () == classOf[ServiceLocation] => { }
                                    case Some(o) if o.getClass () == classOf[UsagePointLocation] => { }
                                    case Some(o) if o.getClass () == classOf[ServiceCategory] => { }
                                    case Some(o) if o.getClass () == classOf[PricingStructure] => { }
                                    case Some(o) if o.getClass () == classOf[Customer] => { }
                                    case Some(o) if o.getClass () == classOf[CustomerAgreement] => { }
                                    case Some(o) if o.getClass () == classOf[UsagePoint] =>
                                        {
                                            val up = o.asInstanceOf[UsagePoint]
                                            voltage = up.nominalServiceVoltage.toString ()
                                            location = up.UsagePointLocation
                                        }

                                    case Some(o) if o.getClass () == classOf[NameTypeAuthority] => { }
                                    case Some(o) if o.getClass () == classOf[NameType] => { }
                                    case Some(o) if o.getClass () == classOf[ch.ninecode.model.Name] => { }
                                    case Some(o) if o.getClass () == classOf[UserAttribute] => { }
                                }

                                // make a pre-edge for each pair of terminals
                                ret = terminals.length match
                                {
                                    case 1 =>
                                        List (
                                            new PreEdge (
                                                terminals(0).ACDCTerminal.IdentifiedObject.mRID,
                                                terminals(0).ConnectivityNode,
                                                "",
                                                "",
                                                terminals(0).ConductingEquipment,
                                                container,
                                                length,
                                                voltage,
                                                typ,
                                                normalOpen,
                                                ratedCurrent,
                                                location,
                                                power,
                                                commissioned,
                                                status))
                                    case 2 =>
                                        List (
                                            new PreEdge (
                                                terminals(0).ACDCTerminal.IdentifiedObject.mRID,
                                                terminals(0).ConnectivityNode,
                                                terminals(1).ACDCTerminal.IdentifiedObject.mRID,
                                                terminals(1).ConnectivityNode,
                                                terminals(0).ConductingEquipment,
                                                container,
                                                length,
                                                voltage,
                                                typ,
                                                normalOpen,
                                                ratedCurrent,
                                                location,
                                                power,
                                                commissioned,
                                                status))
                                    case _ =>
                                        {
                                            // three (or more terminal device - which we assume is a transformer
                                            // sequence number 1 at index 0 is the high side of a transformer
                                            // make edges to each of the secondaries
                                            println ("equipment with " + terminals.length + " terminals: " + terminals(0).ConductingEquipment)
                                            var i = 0
                                            var list = List[PreEdge] ()
                                            while (i < terminals.length - 1)
                                            {
                                                list = list :+ new PreEdge (
                                                        terminals(0).ACDCTerminal.IdentifiedObject.mRID,
                                                        terminals(0).ConnectivityNode,
                                                        terminals(i + 1).ACDCTerminal.IdentifiedObject.mRID,
                                                        terminals(i + 1).ConnectivityNode,
                                                        terminals(0).ConductingEquipment,
                                                        container,
                                                        length,
                                                        voltage,
                                                        typ,
                                                        normalOpen,
                                                        ratedCurrent,
                                                        location,
                                                        power,
                                                        commissioned,
                                                        status)
                                                i += 1
                                            }
                                            list
                                        }
                                }
                                ret
                            }
                            case (e: Element, None) ⇒
                            {
                                List[PreEdge] ()
                            }
                        }
                    }
                }
                var preedges = rdd.keyBy (_.id).leftOuterJoin (terms).flatMapValues (term_op).values

                // change node id to node name
                val left_op2 =
                {
                    j: Any =>
                    {
                        j match
                        {
                            case (s: String, (e:PreEdge, Some (c:ConnectivityNode))) =>
                                {
                                    if (c.IdentifiedObject.name != null)
                                        e.cn_1 = c.IdentifiedObject.name
                                    if (c.ConnectivityNodeContainer != null)
                                        e.container = c.ConnectivityNodeContainer
                                    e
                                }
                            case (s: String, (e:PreEdge, None)) => e // these two cases handle when a connectivity node was not found
                            case (null, (e:PreEdge, None)) => e // or a terminal has no connectivty node
                        }
                    }
                }
                val cns = connectivitynodes.keyBy (_.IdentifiedObject.mRID)
                preedges = preedges.keyBy (_.cn_1).leftOuterJoin (cns).map (left_op2)
                val right_op2 = // ToDo: equipment with two containers should be deterministically assigned to the correct container
                {
                    j: Any =>
                    {
                        j match
                        {
                            case (s: String, (e:PreEdge, Some (c:ConnectivityNode))) =>
                                {
                                    if (c.IdentifiedObject.name != null)
                                        e.cn_2 = c.IdentifiedObject.name
                                    if (c.ConnectivityNodeContainer != null)
                                        e.container = c.ConnectivityNodeContainer
                                    e
                                }
                            case (s: String, (e:PreEdge, None)) => e // these two cases handle when a connectivity node was not found
                            case (null, (e:PreEdge, None)) => e // or a terminal has no connectivty node
                        }
                    }
                }
                preedges = preedges.keyBy (_.cn_2).leftOuterJoin (cns).map (right_op2)

                // get start and end coordinates of each location
                val point_seq_op = (x: Extremum /* null */, p: PositionPoint) ⇒
                {
                    if (null == x)
                        new Extremum (p.Location, p.sequenceNumber, p.xPosition, p.yPosition, p.sequenceNumber, p.xPosition, p.yPosition)
                    else
                    {
                        if (p.sequenceNumber < x.min_index)
                        {
                            x.min_index = p.sequenceNumber
                            x.x1 = p.xPosition
                            x.y1 = p.yPosition
                        }
                        else if (p.sequenceNumber > x.max_index)
                        {
                            x.max_index = p.sequenceNumber
                            x.x2 = p.xPosition
                            x.y2 = p.yPosition
                        }
                        x
                    }
                }
                val point_comb_op = (l: Extremum, r: Extremum) ⇒
                {
                    if (r.min_index < l.min_index)
                    {
                        l.min_index = r.min_index
                        l.x1 = r.x1
                        l.y1 = r.y1
                    }
                    if (r.max_index > l.max_index)
                    {
                        l.max_index = r.max_index
                        l.x2 = r.x2
                        l.y2 = r.y2
                    }
                    l
                }
                val extremum = points.keyBy (_.Location).aggregateByKey (null: Extremum) (point_seq_op, point_comb_op).values

                // join coordinates with edges using equipment
                val edge_op =
                {
                    j: Any =>
                    {
                        j match
                        {
                            case (l: String, (e:PreEdge, Some (x:Extremum))) =>
                                Edge (e.cn_1, e.cn_2, e.id_equ, e.container, e.length, e.voltage, e.typ, e.normalOpen, e.ratedCurrent, e.power, e.commissioned, e.status, x.x1, x.y1, x.x2, x.y2)
                            case (l: String, (e:PreEdge, None)) =>
                                // shouldn't happen of course: if it does we have an equipment with a location reference to non-existant location
                                Edge (e.cn_1, e.cn_2, e.id_equ, e.container, e.length, e.voltage, e.typ, e.normalOpen, e.ratedCurrent, e.power, e.commissioned, e.status, "0.0", "0.0", "0.0", "0.0")
                        }
                    }
                }
                val edges = preedges.keyBy (_.location).leftOuterJoin (extremum.keyBy (_.id_loc)).map (edge_op)

                // persist it so the sample can get at it
                edges.setName ("Edges")
                edges.cache ()

                // expose it
                sqlContext.createDataFrame (edges).registerTempTable ("edges")
            }
        }
        else
            logError ("ch.ninecode.cim.CIMRelation.buildScan was given an input list containing no files")

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
