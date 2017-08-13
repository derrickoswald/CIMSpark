package ch.ninecode.cim

import scala.reflect._
import scala.reflect.runtime.universe._
import org.apache.spark.rdd.RDD
import org.apache.spark.SparkContext
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.Row
import org.apache.spark.sql.types.StructType
import org.apache.spark.storage.StorageLevel
import org.apache.spark.sql.types._

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
    val runtime_class: Class[_] = classTag[A].runtimeClass

    val classname: String = runtime_class.getName

    val cls: String = { classname.substring (classname.lastIndexOf (".") + 1) }

    def subclass (x: Element): A =
    {
        var ret = x

        while ((null != ret) && (ret.getClass != runtime_class))
            ret = ret.sup

        ret.asInstanceOf[A]
    }

    val pf:PartialFunction[Element, A] =
    {
        case x: Element if null != subclass (x) =>
            subclass (x)
    }

    def subset (rdd: RDD[Element], storage: StorageLevel, context: SparkContext): RDD[A] =
    {
        val subrdd = rdd.collect[A] (pf)
        subrdd.name = cls
        subrdd.persist (storage)
        context.getCheckpointDir match
        {
            case Some (_) => subrdd.checkpoint ()
            case None =>
        }
        subrdd
    }

    /**
     * Alter the schema so sup has the correct superclass name.
     * @param rtc The runtime class for Typeclass A.
     * @param schema The SQL schema for Typeclass A, e.g.
     *   org.apache.spark.sql.types.StructType = StructType(StructField(sup,StructType(StructField(sup,StructType(StructField(sup,...
     */
    def modify_schema (rtc: Class[_], schema: StructType): StructType =
    {
        val sup = schema.fields (0)
        val supcls = rtc.getMethod ("sup").getReturnType
        val clsname = supcls.getName.substring (supcls.getName.lastIndexOf (".") + 1)
        val suptyp = sup.dataType
        val dataType = if (suptyp.typeName == "struct")
            modify_schema (supcls, suptyp.asInstanceOf[StructType])
        else
            suptyp
        val supersup = StructField (clsname, dataType, sup.nullable, sup.metadata)
        schema.fields.update (0, supersup)
        StructType (schema.fields)
    }

    /**
     * Create the Dataframe for Typeclass A.
     * @param context The SQL context for creating the views.
     * @param rdd The raw Element RDD to subset.
     * @param storage The storage level to persist the subset RDD with.
     */
    def make (context: SQLContext, rdd: RDD[Element], storage: StorageLevel): Unit =
    {
        val sub = subset (rdd, storage, context.sparkSession.sparkContext)
        val df = context.sparkSession.createDataFrame (sub)(typeTag[A])
        val altered_schema = modify_schema (runtime_class, df.schema)
        val data_frame = context.sparkSession.createDataFrame (sub.asInstanceOf[RDD[Row]], altered_schema)
        data_frame.createOrReplaceTempView (cls)
    }
}
