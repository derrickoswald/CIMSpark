package ch.ninecode.cim

import scala.reflect._
import scala.reflect.runtime.universe._
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.Row
import org.apache.spark.sql.types.StructType
import org.apache.spark.storage.StorageLevel
import org.apache.spark.sql.types._
import ch.ninecode.model.Element

import scala.reflect.runtime.universe

/**
 * Subclass extractor.
 *
 * Extracts the given type of object from the full Element Resilient Distributes Dataset (RDD),
 * to create another RDD of just those elements, and creates a DataFrame of that RDD,
 * and registers it as a temporary table for access via SQL (e.g. JDBC and SparkR::sql()).
 *
 * Note: This must be serializable and can't depend on the companion objects
 * for the CIM case classes.
 */
class CIMSubsetter[A <: Product : ClassTag : TypeTag] () extends Serializable
{
    type basetype = A
    type rddtype = RDD[A]
    val tag: universe.TypeTag[A] = typeTag[A]
    val runtime_class: Class[_] = classTag[A].runtimeClass

    val classname: String = runtime_class.getName

    val cls: String = { classname.substring (classname.lastIndexOf (".") + 1) }

    /**
     * Alter the schema so sup has the correct superclass name.
     *
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
     *
     * @param context The SQL context for creating the views.
     * @param rdd The raw Element RDD to subset.
     * @param storage The storage level to persist the subset RDD with.
     */
    def save (context: SQLContext, rdd: rddtype, storage: StorageLevel): Unit =
    {
        rdd.name = cls
        val _ = rdd.persist (storage)
        if (context.sparkSession.sparkContext.getCheckpointDir.isDefined) rdd.checkpoint ()
        val df = context.sparkSession.createDataFrame (rdd)(tag)
        val altered_schema = modify_schema (runtime_class, df.schema)
        val data_frame = context.sparkSession.createDataFrame (rdd.asInstanceOf[RDD[Row]], altered_schema)
        data_frame.createOrReplaceTempView (cls)
    }

    /**
     * Convert the generic element into an object of type A.
     *
     * Runs up the hierarchy of nested CIM classes to find this class - or not.
     *
     * @param element the generic element
     * @return the object of this class, or <code>null</code> if the element is not derived from this class
     */
    def subclass (element: Element): A =
    {
        var ret = element

        while ((null != ret) && (ret.getClass != runtime_class))
            ret = ret.sup

        ret.asInstanceOf[A]
    }

    /**
     * Selector for elements of this class.
     */
    val pf:PartialFunction[Element, A] =
    {
        case element: Element if null != subclass (element) =>
            subclass (element)
    }

    /**
     * Create the Dataframe for Typeclass A.
     * @param context The SQL context for creating the views.
     * @param rdd The raw Element RDD to subset.
     * @param storage The storage level to persist the subset RDD with.
     */
    def make (context: SQLContext, rdd: RDD[Element], storage: StorageLevel): Unit =
    {
        val subrdd = rdd.collect[A] (pf)
        save (context, subrdd, storage)
    }
}
