package ch.ninecode.cim

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.Path
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat
import org.apache.spark.rdd.RDD
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions
import org.apache.spark.sql.Encoders
import org.apache.spark.sql.Row
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.execution.datasources.FileIndex
import org.apache.spark.sql.sources.BaseRelation
import org.apache.spark.sql.sources.TableScan
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.types.ElementRegistration
import org.apache.spark.storage.StorageLevel
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import ch.ninecode.model.Element

/**
 * A Relation for CIM RDF files that can produce all of its tuples as an RDD of Row objects.
 *
 * As a side effect, this relation also creates RDD and local temporary views corresponding
 * to the subclasses of each element, and saves each RDD in the persistent RDD list
 * using the CIM class name.
 *
 * @param location object containing the file(s) to read
 * @param parameters specific settings for reading the file(s)
 * @param spark the Spark session object
 */
class CIMRelation (
    location: FileIndex,
    parameters: Map[String, String]) (spark: SparkSession) extends BaseRelation with TableScan with CIMRDD
{
    // We use BaseRelation because if it inherits from HadoopFSRelation,
    // DataSource uses the CIMFileFormat which doesn't allow subsetting, etc. :
    //extends
    //    HadoopFsRelation (
    //        location,
    //        partitionSchema,
    //        dataSchema,
    //        None, // org.apache.spark.sql.execution.datasources.BucketSpec is private
    //        fileFormat,
    //        parameters) (spark)

    implicit val session: SparkSession = spark
    implicit val log: Logger = LoggerFactory.getLogger (getClass)

    def parseState (text: String): State =
        text match
        {
            case "ForceTrue" => ForceTrue
            case "ForceFalse" => ForceFalse
            case _ => Unforced
        }

    val paths: Array[String] = location.inputFiles

    // check for a storage level option
    implicit val _StorageLevel: StorageLevel = StorageLevel.fromString (parameters.getOrElse ("StorageLevel", "MEMORY_AND_DISK_SER"))
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
    // check for NTP force switches option
    val _Force_Retain_Switches: State = parseState (parameters.getOrElse ("ch.ninecode.cim.force_retain_switches", "Unforced"))
    // check for NTP force fuses option
    val _Force_Retain_Fuses: State = parseState (parameters.getOrElse ("ch.ninecode.cim.force_retain_fuses", "Unforced"))
    // check for NTP force switches to separate islands option
    val _Force_Switch_Separate_Islands: State = parseState (parameters.getOrElse ("ch.ninecode.cim.force_switch_separate_islands", "Unforced"))
    // check for NTP force fuses to separate islands option
    val _Force_Fuse_Separate_Islands: State = parseState (parameters.getOrElse ("ch.ninecode.cim.force_fuse_separate_islands", "Unforced"))
    // check for NTP default switch state option
    val _Default_Switch_Open_State: Boolean = parameters.getOrElse ("ch.ninecode.cim.default_switch_open_state", "false").toBoolean
    // check for NTP debug option
    val _Debug: Boolean = parameters.getOrElse ("ch.ninecode.cim.debug", "false").toBoolean
    // check for split size option, default is 64MB
    val _SplitSize: Long = parameters.getOrElse ("ch.ninecode.cim.split_maxsize", "67108864").toLong
    // check for cache option
    val _Cache: String = parameters.getOrElse ("ch.ninecode.cim.cache", "")

    log.info (s"parameters: ${parameters.toString}")
    log.info (s"storage: ${_StorageLevel.description}")

    def sqlContext: SQLContext = spark.sqlContext

    // just to get a schema
    case class dummy
    (
        override val sup: Element = null
    )
    extends
        Element
    {
        override def copy (): Row = { clone ().asInstanceOf[Row] }
    }

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
        Encoders.product[dummy].schema
    }

    def make_tables (rdd: RDD[Element]): Unit =
    {
        // aggregate the set of class names
        val names = rdd
            .aggregate (Set[String]()) (
                (set, element) => set.union (element.classes.toSet),
                (set1, set2) => set1.union (set2)
            )
        CHIM.apply_to_all_classes (
            (subsetter: CIMSubsetter[_]) =>
            {
                if (names.contains (subsetter.cls))
                {
                    log.debug (s"building ${subsetter.cls}")
                    subsetter.make (spark.sqlContext, rdd, _StorageLevel)
                }
            }
        )
    }

    // For a non-partitioned relation, this method builds an RDD[Row] containing all rows within this relation.
    override def buildScan (): RDD[Row] =
    {
        log.info ("buildScan")

        // register the ElementUDT
        ElementRegistration.register ()

        var ret: RDD[Row] = null

        // remove any existing RDD created by this relation
        spark.sparkContext.getPersistentRDDs.find (_._2.name == "Elements").foreach (
            x =>
            {
                val (_, old) = x
                // aggregate the set of subclass names
                val names = old.asInstanceOf[RDD[Element]]
                    .aggregate (Set[String]()) (
                        (set, element) => element.classes.toSet.union (set),
                        (set1, set2) => set1.union (set2)
                    )
                // remove subclass RDD if they exist (they should)
                for (name <- names)
                    spark.sparkContext.getPersistentRDDs.find (_._2.name == name) match
                    {
                        case Some ((_: Int, existing: RDD[_])) =>
                            existing.setName (null).unpersist (true)
                        case Some (_) | None =>
                    }
                // remove the Element rdd
                old.setName (null).unpersist (true)
            }
        )

        if (_Cache != "")
        {
            val path = new Path (_Cache)
            val configuration = new Configuration (spark.sparkContext.hadoopConfiguration)
            val fs = path.getFileSystem (configuration)
            if (fs.exists (path))
            {
                log.info (s"reading cache: ${_Cache}")
                val rdd: RDD[Element] = spark.sparkContext.objectFile (_Cache)
                put (rdd, "Elements", true)
                make_tables (rdd)
                ret = rdd.asInstanceOf[RDD[Row]]
            }
        }

        if (null == ret)
        {
            val path = parameters.getOrElse ("path", paths.mkString (","))

            // make a config
            val configuration = new Configuration (spark.sparkContext.hadoopConfiguration)
            configuration.set (FileInputFormat.INPUT_DIR, path)
            configuration.setLong (FileInputFormat.SPLIT_MAXSIZE, _SplitSize)

            var rdd = spark.sparkContext.newAPIHadoopRDD (
                configuration,
                classOf[CIMInputFormat],
                classOf[String],
                classOf[Element]).values

            put (rdd, "Elements", true)
            ret = rdd.asInstanceOf[RDD[Row]]

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
            make_tables (rdd)

            // merge ISU and NIS ServiceLocations if requested
            if (_Join)
            {
                val join = new CIMJoin (spark, _StorageLevel)
                ret = join.do_join ().asInstanceOf[RDD[Row]]
            }

            // perform topological processing if requested
            if (_Topo)
            {
                val ntp = CIMNetworkTopologyProcessor (
                    spark,
                    CIMTopologyOptions (
                        identify_islands = _Islands,
                        force_retain_switches = _Force_Retain_Switches,
                        force_retain_fuses = _Force_Retain_Fuses,
                        force_switch_separate_islands = _Force_Switch_Separate_Islands,
                        force_fuse_separate_islands = _Force_Fuse_Separate_Islands,
                        default_switch_open_state = _Default_Switch_Open_State,
                        debug = _Debug,
                        storage = _StorageLevel
                    )
                )
                ret = ntp.process.asInstanceOf[RDD[Row]]
            }

            // set up edge graph if requested
            if (_Edges)
            {
                val cimedges = new CIMEdges (spark, _StorageLevel)
                ret = cimedges.make_edges (_Topo).asInstanceOf[RDD[Row]]
            }

            // cache elements if requested
            if (_Cache != "")
            {
                log.info (s"writing cache: ${_Cache}")
                ret.saveAsObjectFile (_Cache)
            }
        }

        ret
    }
}
