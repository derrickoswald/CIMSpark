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

    val cls: String =
    {
        classname.substring(classname.lastIndexOf(".") + 1)
    }

    /**
     * Alter the schema so sup has the correct superclass name.
     *
     * @param rtc    The runtime class for Typeclass A.
     * @param schema The SQL schema for Typeclass A, e.g.
     *               org.apache.spark.sql.types.StructType = StructType(StructField(sup,StructType(StructField(sup,StructType(StructField(sup,...
     */
    def modify_schema (rtc: Class[_], schema: StructType): StructType =
    {
        val sup = schema.fields(0)
        val supcls = rtc.getMethod("sup").getReturnType
        val clsname = supcls.getName.substring(supcls.getName.lastIndexOf(".") + 1)
        val suptyp = sup.dataType
        val dataType = if (suptyp.typeName == "struct")
            modify_schema(supcls, suptyp.asInstanceOf[StructType])
        else
            suptyp
        val supersup = StructField(clsname, dataType, sup.nullable, sup.metadata)
        schema.fields.update(0, supersup)
        StructType(schema.fields)
    }

    /**
     * Match names with pattern "name|xxx".
     *
     * @param name the name to match
     * @return <code>true</code> if the RDD name matches the pattern
     */
    def like (name: String): ((Int, RDD[_])) => Boolean =
    {
        val pattern = s"$name|"
        (rdd: (Int, RDD[_])) => (rdd._2.name != null) && ((rdd._2.name == name) || rdd._2.name.startsWith(pattern))
    }

    /**
     * Create the Dataframe for Typeclass A.
     *
     * @param context  the SQL context for creating the views
     * @param rdd      the raw Element RDD to subset
     * @param storage  the storage level to persist the subset RDD with
     * @param template the name template, String.format for the name of the RDD and Dataset view
     */
    def save (context: SQLContext, rdd: rddtype, storage: StorageLevel, template: String): Unit =
    {
        val name = template.format(cls)

        // remove any previously named RDD
        val matched = context.sparkContext.getPersistentRDDs.filter(like(name))
        matched.foreach(_._2.setName(null).unpersist(true))

        rdd.name = name
        val _ = rdd.persist(storage)
        if (context.sparkSession.sparkContext.getCheckpointDir.isDefined) rdd.checkpoint()
        val df = context.sparkSession.createDataFrame(rdd)(tag)
        val altered_schema = modify_schema(runtime_class, df.schema)
        val data_frame = context.sparkSession.createDataFrame(rdd.asInstanceOf[RDD[Row]], altered_schema)
        data_frame.createOrReplaceTempView(name)
    }

    /**
     * Return the provided Element as this class if possible.
     *
     * @param element the element to convert
     * @return Some(A) or None if the Element is not this Subsetter class type.
     */
    def asThisClass (element: Element): Option[A] =
    {
        element match
        {
            case obj: A => Some(obj)
            case e => if (null == e.sup) None else asThisClass(e.sup)
        }
    }

    /**
     * Create the Dataframe for Typeclass A.
     *
     * @param context  the SQL context for creating the views
     * @param rdd      the raw Element RDD to subset
     * @param storage  the storage level to persist the subset RDD with
     * @param template the name template, String.format for the name of the RDD and Dataset view
     */
    def make (context: SQLContext, rdd: RDD[Element], storage: StorageLevel, template: String): Unit =
    {
        val subrdd = rdd.flatMap(asThisClass)
        save(context, subrdd, storage, template)
    }
}
