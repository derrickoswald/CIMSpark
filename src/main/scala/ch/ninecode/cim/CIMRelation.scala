package ch.ninecode.cim

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat
import org.apache.spark.rdd.RDD
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions
import org.apache.spark.sql.Row
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.catalyst.ScalaReflection
import org.apache.spark.sql.execution.datasources.FileIndex
import org.apache.spark.sql.execution.datasources.FileFormat
import org.apache.spark.sql.sources.BaseRelation
import org.apache.spark.sql.sources.TableScan
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.types.ElementRegistration
import org.apache.spark.storage.StorageLevel
import org.slf4j.{Logger, LoggerFactory}
import ch.ninecode.model.Element

class CIMRelation (
    location: FileIndex,
    partitionSchema: StructType,
    dataSchema: StructType,
    fileFormat: FileFormat,
    parameters: Map[String, String])
                                    (spark: SparkSession)

// Derrick: if it inherits from HadoopFSRelation, DataSource uses the CIMFileFormat which doesn't allow subsetting, etc.
//extends
//    HadoopFsRelation (
//        location,
//        partitionSchema,
//        dataSchema,
//        None, // org.apache.spark.sql.execution.datasources.BucketSpec is private
//        fileFormat,
//        parameters)                    (spark)
extends
    BaseRelation
with
    TableScan
{
    implicit val log: Logger = LoggerFactory.getLogger (getClass)

    // check for a storage level option
    implicit val _StorageLevel: StorageLevel = StorageLevel.fromString (parameters.getOrElse ("StorageLevel", "MEMORY_ONLY"))
    // check for rdf:about option
    val _About: Boolean = parameters.getOrElse ("ch.ninecode.cim.do_about", "false").toBoolean
    // check for normalization option
    val _Normalize: Boolean = parameters.getOrElse ("ch.ninecode.cim.do_normalize", "false").toBoolean
    // check for deduplication option
    val _DeDup: Boolean = parameters.getOrElse ("ch.ninecode.cim.do_deduplication", "false").toBoolean
    // check for edge creation option
    val _Edges: Boolean = parameters.getOrElse ("ch.ninecode.cim.make_edges", "false").toBoolean
    // check for ISU join option
    val _Join: Boolean = parameters.getOrElse ("ch.ninecode.cim.do_join", "false").toBoolean
    // check for NTP island option
    val _Islands: Boolean = parameters.getOrElse ("ch.ninecode.cim.do_topo_islands", "false").toBoolean
    // check for NTP option, islands requires topological nodes
    val _Topo: Boolean = if (_Islands) true else parameters.getOrElse ("ch.ninecode.cim.do_topo", "false").toBoolean
    // check for split size option, default is 64MB
    val _SplitSize: Long = parameters.getOrElse ("ch.ninecode.cim.split_maxsize", "67108864").toLong

    log.info ("parameters: " + parameters.toString)
    log.info ("storage: " + _StorageLevel.description)

    def sqlContext: SQLContext = spark.sqlContext

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
    override def schema: StructType =
    {
        // we cheat here: the elements in the elements rdd are full Scala hierarchical objects,
        // but we say here they only have one field of type Element because for some that is all they have
        // (lowest common denominator)
        ScalaReflection.schemaFor[dummy].dataType.asInstanceOf[StructType]
    }

    // For a non-partitioned relation, this method builds an RDD[Row] containing all rows within this relation.
    override def buildScan (): RDD[Row] =
    {
        log.info ("buildScan")

        // register the ElementUDT
        ElementRegistration.register ()

        var ret: RDD[Row] = null

        val path = parameters.getOrElse ("path", sys.error ("'path' must be specified for CIM data."))

        // make a config
        val configuration = new Configuration (spark.sparkContext.hadoopConfiguration)
        configuration.set (FileInputFormat.INPUT_DIR, path)
        configuration.setLong (FileInputFormat.SPLIT_MAXSIZE, _SplitSize)

        var rdd = spark.sparkContext.newAPIHadoopRDD (
            configuration,
            classOf[CIMInputFormat],
            classOf[String],
            classOf[Element]).values

        ret = rdd.asInstanceOf[RDD[Row]]
        ret.setName ("Elements")
        ret.persist (_StorageLevel)
        if (spark.sparkContext.getCheckpointDir.isDefined) ret.checkpoint ()

        // about processing if requested
        if (_About)
        {
            val about = new CIMAbout (spark, _StorageLevel)
            rdd = about.do_about ()
            ret = rdd.asInstanceOf[RDD[Row]]
        }

        // normalize if requested
        if (_Normalize)
        {
            val normalize = new CIMNormalize (spark, _StorageLevel)
            rdd = normalize.do_normalization ()
            ret = rdd.asInstanceOf[RDD[Row]]
        }

        // dedup if requested
        if (_DeDup)
        {
            val dedup = new CIMDeDup (spark, _StorageLevel)
            rdd = dedup.do_deduplicate ()
            ret = rdd.asInstanceOf[RDD[Row]]
        }

        // as a side effect, define all the other temporary tables
        log.info ("creating temporary tables")
        val names = rdd.flatMap (
            (x: Element) => // hierarchy: List[String]
            {
                var ret = List[String]()
                var clz = x

                while (null != clz)
                {
                    ret = ret :+ clz.getClass.getName
                    clz = clz.sup
                }

                ret.map (x => x.substring (x.lastIndexOf (".") + 1))
            }
        ).distinct.collect
        CHIM.apply_to_all_classes (
            (subsetter: CIMSubsetter[_]) =>
            {
                // in earlier Scala versions this loop doesn't work well
                // the symptoms are:
                //     scala.reflect.runtime.ReflectError: value ch is not a package
                // or
                //     java.lang.RuntimeException: error reading Scala signature of ch.ninecode.model.BusBarSectionInfo: value model is not a package
                // due to https://issues.apache.org/jira/browse/SPARK-2178
                // which is due to https://issues.scala-lang.org/browse/SI-6240
                // and described in http://docs.scala-lang.org/overviews/reflection/thread-safety.html
                // p.s. Scala's type system is a shit show of kludgy code
                if (names.contains (subsetter.cls))
                {
                    log.debug ("building " + subsetter.cls)
                    subsetter.make (spark.sqlContext, rdd, _StorageLevel)
                }
            }
        )

        // merge ISU and NIS ServiceLocations if requested
        if (_Join)
        {
            val join = new CIMJoin (spark, _StorageLevel)
            ret = join.do_join ().asInstanceOf[RDD[Row]]
        }

        // perform topological processing if requested
        if (_Topo)
        {
            val ntp = new CIMNetworkTopologyProcessor (spark, _StorageLevel)
            ret = ntp.process (_Islands).asInstanceOf[RDD[Row]]
        }

        // set up edge graph if requested
        if (_Edges)
        {
            val cimedges = new CIMEdges (spark, _StorageLevel)
            ret = cimedges.make_edges (_Topo).asInstanceOf[RDD[Row]]
        }

        ret
    }
}
