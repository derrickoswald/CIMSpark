package ch.ninecode.cim

import scala.reflect._
import scala.reflect.runtime.universe._
import scala.reflect.runtime.{universe => ru}
import org.apache.spark.rdd.RDD
import org.apache.spark.SparkContext
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.Row
import org.apache.spark.sql.catalyst.ScalaReflection
import org.apache.spark.sql.types.StructType
import org.apache.spark.storage.StorageLevel
import org.apache.spark.sql.types._

import org.apache.spark.sql.Encoders
import org.apache.spark.sql.SparkSession

import ch.ninecode.model.Element

/**
 * Subclass extractor
 * Extracts the given type of object from the full Element Resilient Distributes Dataset (RDD),
 * to create another RDD of just those elements, and creates a DataFrame of that RDD,
 * and registers it as a temporary table for access via SQL (e.g. JDBC and SparkR::sql()).
 * Note: This must be serializable and can't depend on the companion objects
 * for the CIM case classes.
 */
class CIMSubsetter[A <: Product : ClassTag : TypeTag] () extends Serializable
{
    def runtime_class = classTag[A].runtimeClass
    def classname = runtime_class.getName
    def cls: String = { classname.substring (classname.lastIndexOf (".") + 1) }
    def subclass (x: Element): A =
    {
        var ret = x

        while ((null != ret) && (ret.getClass () != runtime_class))
            ret = ret.sup

        return (ret.asInstanceOf[A])
    }
    val pf:PartialFunction[Element, A] =
    {
        case x: Element if (null != subclass (x)) =>
            subclass (x)
    }
    def subset (rdd: RDD[Element], storage: StorageLevel, context: SparkContext): RDD[A] =
    {
        val subrdd = rdd.collect[A] (pf)
        subrdd.name = cls
        subrdd.persist (storage)
        context.getCheckpointDir match
        {
            case Some (dir) => subrdd.checkpoint ()
            case None =>
        }
        subrdd
    }
    def make (sqlContext: SQLContext, rdd: RDD[Element], storage: StorageLevel) =
    {
        val sub = subset (rdd, storage, sqlContext.sparkSession.sparkContext)
        val df = sqlContext.sparkSession.createDataFrame(sub)(typeTag[A])
        df.createOrReplaceTempView (cls)
    }
}
