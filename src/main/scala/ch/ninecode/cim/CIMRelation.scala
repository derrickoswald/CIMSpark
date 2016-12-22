package ch.ninecode.cim

import java.util.Objects

import scala.util.Sorting
import scala.reflect.runtime.universe

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.FileStatus
import org.apache.hadoop.mapreduce.Job
import org.apache.spark.rdd.RDD
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions
import org.apache.spark.sql.Row
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.catalyst.ScalaReflection
import org.apache.spark.sql.types.StringType
import org.apache.spark.sql.types.StructField
import org.apache.spark.sql.types.StructType
import org.apache.spark.storage.StorageLevel
import org.apache.spark.sql.sources._

import scala.reflect._
import scala.reflect.runtime.universe._
import scala.reflect.runtime.{universe => ru}
import org.slf4j.LoggerFactory

import ch.ninecode.model._
import org.apache.spark.sql.types._

class CIMRelation(
    private val parameters: Map[String, String])
    (@transient val sqlContext: SQLContext) extends BaseRelation with TableScan
{
  
    private val log = LoggerFactory.getLogger(getClass)
    // check for a storage level option
    val _StorageLevel: StorageLevel = StorageLevel.fromString (parameters.getOrElse ("StorageLevel", "MEMORY_ONLY"))
    // check for edge creation option
    val _Edges: Boolean = parameters.getOrElse ("ch.ninecode.cim.make_edges", "false").toBoolean
    // check for ISU join option
    val _Join: Boolean = parameters.getOrElse ("ch.ninecode.cim.do_join", "false").toBoolean
    // check for NTP island option
    val _Islands: Boolean = parameters.getOrElse ("ch.ninecode.cim.do_topo_islands", "false").toBoolean
    // check for NTP option, islands requires topological nodes
    val _Topo: Boolean = if (_Islands) true else parameters.getOrElse ("ch.ninecode.cim.do_topo", "false").toBoolean

    log.info ("parameters: " + parameters.toString ())
    log.info ("sqlContext: " + sqlContext.toString ())
    log.info ("storage: " + _StorageLevel.description)

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
        log.info ("storage: " + _StorageLevel.description)

        var ret: RDD[Row] = null

        val path = parameters.getOrElse("path", sys.error("'path' must be specified for CIM data."))

        // make a config
        val configuration = new Configuration (sqlContext.sparkContext.hadoopConfiguration)
        //val filename = inputFiles.map (_.getPath.toString).mkString (",")
        val filename = path
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
        log.info ("creating temporary tables")
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
                log.info ("building " + subsetter.cls)
                subsetter.make (sqlContext, rdd, _StorageLevel)
            }
        )

        // merge ISU and NIS ServiceLocations if requested
        if (_Join)
        {
            log.info ("joining ISU and NIS")
            val join = new CIMJoin (sqlContext, _StorageLevel)
            join.do_join ()
        }

        // perform topological processing if requested
        if (_Topo)
        {
            log.info ("performing Network Topology Processing")
            val ntp = new CIMNetworkTopologyProcessor (sqlContext, _StorageLevel)
            ntp.process (_Islands)
        }

        // set up edge graph if requested
        if (_Edges)
        {
            log.info ("making Edges RDD")
            val cimedges = new CIMEdges (sqlContext, _StorageLevel)
            cimedges.make_edges (_Topo)
        }

        return (ret)
  }

}
