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
 * @param location   object containing the file(s) to read
 * @param parameters specific settings for reading the file(s)
 * @param spark      the Spark session object
 */
class CIMRelation (
    location: FileIndex,
    parameters: Map[String, String])(spark: SparkSession) extends BaseRelation with TableScan with CIMRDD
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
    implicit val log: Logger = LoggerFactory.getLogger(getClass)

    def parseState (text: String): State =
        text match
        {
            case "ForceTrue" => ForceTrue
            case "ForceFalse" => ForceFalse
            case _ => Unforced
        }

    val paths: Array[String] = location.inputFiles

    // check for a storage level option
    implicit val _StorageLevel: StorageLevel = StorageLevel.fromString(parameters.getOrElse("StorageLevel", "MEMORY_AND_DISK_SER"))
    // check for append option
    val _Append: Boolean = parameters.getOrElse("ch.ninecode.cim.append", "false").toBoolean
    // check for rdf:about option
    val _About: Boolean = parameters.getOrElse("ch.ninecode.cim.do_about", "false").toBoolean
    // check for normalization option
    val _Normalize: Boolean = parameters.getOrElse("ch.ninecode.cim.do_normalize", "false").toBoolean
    // check for deduplication option
    val _DeDup: Boolean = parameters.getOrElse("ch.ninecode.cim.do_deduplication", "false").toBoolean
    // check for change set merge option
    val _Changes: Boolean = parameters.getOrElse("ch.ninecode.cim.apply_changesets", "false").toBoolean
    // check for edge creation option
    val _Edges: Boolean = parameters.getOrElse("ch.ninecode.cim.make_edges", "false").toBoolean
    // check for ISU join option
    val _Join: Boolean = parameters.getOrElse("ch.ninecode.cim.do_join", "false").toBoolean
    // check for NTP island option
    val _Islands: Boolean = parameters.getOrElse("ch.ninecode.cim.do_topo_islands", "false").toBoolean
    // check for NTP option, islands requires topological nodes
    val _Topo: Boolean = if (_Islands) true else parameters.getOrElse("ch.ninecode.cim.do_topo", "false").toBoolean
    // check for NTP force switches option
    val _Force_Retain_Switches: State = parseState(parameters.getOrElse("ch.ninecode.cim.force_retain_switches", "Unforced"))
    // check for NTP force fuses option
    val _Force_Retain_Fuses: State = parseState(parameters.getOrElse("ch.ninecode.cim.force_retain_fuses", "Unforced"))
    // check for NTP force switches to separate islands option
    val _Force_Switch_Separate_Islands: State = parseState(parameters.getOrElse("ch.ninecode.cim.force_switch_separate_islands", "Unforced"))
    // check for NTP force fuses to separate islands option
    val _Force_Fuse_Separate_Islands: State = parseState(parameters.getOrElse("ch.ninecode.cim.force_fuse_separate_islands", "Unforced"))
    // check for NTP default switch state option
    val _Default_Switch_Open_State: Boolean = parameters.getOrElse("ch.ninecode.cim.default_switch_open_state", "false").toBoolean
    // check for NTP debug option
    val _Debug: Boolean = parameters.getOrElse("ch.ninecode.cim.debug", "false").toBoolean
    // check for split size option, default is 64MB
    val _SplitSize: Long = parameters.getOrElse("ch.ninecode.cim.split_maxsize", "67108864").toLong
    // check for cache option
    val _Cache: String = parameters.getOrElse("ch.ninecode.cim.cache", "")
    // get the name template if any
    val _NameTemplate: String = parameters.getOrElse("ch.ninecode.cim.name_template", "%s")

    log.info(s"parameters: ${parameters.toString}")
    log.info(s"storage: ${_StorageLevel.description}")

    def sqlContext: SQLContext = spark.sqlContext

    override def pattern: String = _NameTemplate

    // just to get a schema
    case class dummy
    (
        override val sup: Element = null
    )
        extends
            Element
    {
        override def copy (): Row =
        {
            clone().asInstanceOf[Row]
        }
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
            .aggregate(Set[String]())(
                (set, element) => set.union(element.classes.toSet),
                (set1, set2) => set1.union(set2)
            )
        CHIM.apply_to_all_classes(
            (subsetter: CIMSubsetter[_]) =>
            {
                if (names.contains(subsetter.cls))
                {
                    log.debug(s"building ${applyPattern(subsetter.cls)}")
                    subsetter.make(spark.sqlContext, rdd, _StorageLevel, _NameTemplate)
                }
            }
        )
    }

    def removeSubclassRDD (elements: RDD[Element]): Unit =
    {
        // aggregate the set of subclass names
        val names = elements
            .aggregate(Set[String]())(
                (set, element) => element.classes.toSet.union(set),
                (set1, set2) => set1.union(set2)
            )
        // remove subclass RDD if they exist
        for (name <- names;
             target = applyPattern(name))
        {
            spark.sparkContext.getPersistentRDDs.find(_._2.name == target) match
            {
                case Some((_: Int, existing: RDD[_])) =>
                    existing.setName(null).unpersist(true)
                case Some(_) | None =>
            }
        }
    }

    // For a non-partitioned relation, this method builds an RDD[Row] containing all rows within this relation.
    override def buildScan (): RDD[Row] =
    {
        log.info("buildScan")

        // register the ElementUDT
        ElementRegistration.register()

        var ret: RDD[Element] = null

        // if appending get the old RDD[Element] and remove any existing subclass RDD
        // else also remove the old RDD[Element]
        val target = applyPattern("Element")
        val previous = spark.sparkContext.getPersistentRDDs.find(_._2.name == target) match
        {
            case Some((_, old)) =>
                val rdd = old.asInstanceOf[RDD[Element]]
                removeSubclassRDD(rdd)
                if (_Append)
                    Some(rdd)
                else
                {
                    // remove the old RDD[Element]
                    rdd.setName(null).unpersist(true)
                    None
                }
            case None =>
                None
        }

        if (_Cache != "")
        {
            val path = new Path(_Cache)
            val configuration = new Configuration(spark.sparkContext.hadoopConfiguration)
            val fs = path.getFileSystem(configuration)
            if (fs.exists(path))
            {
                log.info(s"reading cache: ${_Cache}")
                val rdd: RDD[Element] = spark.sparkContext.objectFile(_Cache)
                put(rdd, true)
                make_tables(rdd)
                ret = rdd
            }
        }

        if (null == ret)
        {
            val path = parameters.getOrElse("path", paths.mkString(","))

            // make a config
            val configuration = new Configuration(spark.sparkContext.hadoopConfiguration)
            configuration.set(FileInputFormat.INPUT_DIR, path)
            configuration.setLong(FileInputFormat.SPLIT_MAXSIZE, _SplitSize)

            ret = if (_Debug)
                spark.sparkContext.newAPIHadoopRDD(
                    configuration,
                    classOf[CIMInputFormatDebug],
                    classOf[String],
                    classOf[Element]).values
            else
                spark.sparkContext.newAPIHadoopRDD(
                    configuration,
                    classOf[CIMInputFormat],
                    classOf[String],
                    classOf[Element]).values

            ret = previous match
            {
                case Some(old) =>
                    old.union(ret)
                case None =>
                    ret
            }
            put(ret, true)

            // about processing if requested
            if (_About)
                ret = new CIMAbout(spark, _StorageLevel).do_about()

            // normalize if requested
            if (_Normalize)
                ret = new CIMNormalize(spark, _StorageLevel).do_normalization()

            // dedup if requested
            if (_DeDup)
                ret = new CIMDeDup(spark, _StorageLevel).do_deduplicate()

            // apply changes if requested
            if (_Changes)
                ret = CIMChange(spark, _StorageLevel).apply_changes

            // as a side effect, define all the other temporary tables
            log.info("creating temporary tables")
            make_tables(ret)

            // merge ISU and NIS ServiceLocations if requested
            if (_Join)
                ret = new CIMJoin(spark, _StorageLevel).do_join()

            // perform topological processing if requested
            if (_Topo)
            {
                val ntp = CIMNetworkTopologyProcessor(
                    spark,
                    CIMTopologyOptions(
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
                ret = ntp.process
            }

            // set up edge graph if requested
            if (_Edges)
                ret = new CIMEdges(spark, _StorageLevel).make_edges(_Topo)

            // cache elements if requested
            if (_Cache != "")
            {
                log.info(s"writing cache: ${_Cache}")
                ret.saveAsObjectFile(_Cache)
            }
        }

        ret.asInstanceOf[RDD[Row]]
    }
}
