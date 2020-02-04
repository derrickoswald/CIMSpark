package ch.ninecode.cim

import scala.reflect._
import scala.reflect.runtime.universe
import scala.reflect.runtime.universe._

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.Row
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.StructField
import org.apache.spark.sql.types.StructType
import org.apache.spark.storage.StorageLevel
import org.slf4j.Logger

/**
  * Access globally named and cached RDD of CIM classes.
  *
  * This uses the list of persistent RDDs maintained by Spark
  * to retrieve pre-existing RDD of CIM classes persisted by the
  * CIMReader.
  *
  * These RDD are strongly typed, and are named according to the
  * corresponding CIM class. For example, there is an <code>RDD[ACLineSegment]</code>
  * with the name <code>"ACLineSegment"</code> persisted and remembered in the
  * <code>spark.sparkContext.getPersistentRDDs: collection.Map[Int, RDD[_] ]</code>
  * by the CIMReader.
  *
  * Implicit parameters for the SparkSession and error Logger are required.
  * Implicit parameter StorageLevel is required to put().
  *
  * @example Declare a class that extends CIMRDD to be able to access the <code>get()</code> methods:
  * {{{
  * import org.apache.spark.rdd.RDD
  * import org.apache.spark.sql.SparkSession
  * import org.slf4j.Logger
  *
  * import ch.ninecode.CIMRDD
  * import ch.ninecode.model._
  *
  * class Processor (spark: SparkSession) extends CIMRDD with Serializable
  * {
  *     implicit val log: Logger = LoggerFactory.getLogger (getClass)
  *     implicit val session = spark
  *
  *     def process =
  *     {
  *         val switches: RDD[Switch] = get[Switch]
  *         ⋮
  *     }
  * }
  * }}}
  */
trait CIMRDD
{
    /**
     * Check for the named RDD.
     *
     * @param name The name of the RDD, usually the same as the CIM class.
     * @param spark The Spark session which persisted the named RDD.
     * @param log A logger for error messages.
     * @tparam T The type of objects contained in the named RDD.
     * @return <code>true</code> if the named RDD exists, <code>false</code> otherwise.
     */
    def test[T : ClassTag](name: String)(implicit spark: SparkSession, log: Logger): Boolean =
    {
        spark.sparkContext.getPersistentRDDs.find (_._2.name == name) match
        {
            case Some ((_: Int, _: RDD[_])) =>
                true
            case Some (_) | None =>
                false
        }
    }

    /**
      * Get the named RDD.
      *
      * @param name The name of the RDD, usually the same as the CIM class.
      * @param spark The Spark session which persisted the named RDD.
      * @param log A logger for error messages.
      * @tparam T The type of objects contained in the named RDD.
      * @return The typed RDD, e.g. <code>RDD[T]</code>.
      *
      * @example The RDD of all elements is somewhat special,
      * currently it is named Elements (plural), so this method must be used:
      * {{{val elements: RDD[Element] = get[Element]("Elements")}}}.
      *
      */
    def get[T : ClassTag](name: String)(implicit spark: SparkSession, log: Logger): RDD[T] =
    {
        spark.sparkContext.getPersistentRDDs.find (_._2.name == name) match
        {
            case Some ((_: Int, rdd: RDD[_])) =>
                rdd.asInstanceOf[RDD[T]]
            case Some (_) | None =>
                log.warn ("""%s not found in Spark context persistent RDDs map""".format (name))
                null
        }
    }

    /**
     * Get the named RDD or else an empty RDD of the requested type.
     *
     * @param name The name of the RDD, usually the same as the CIM class.
     * @param spark The Spark session which persisted the named RDD.
     * @param log A logger for error messages.
     * @tparam T The type of objects contained in the named RDD.
     * @return The typed RDD, e.g. <code>RDD[T]</code>, as either the persisted RDD or an empty one if none was found.
     *
     */
    def getOrElse[T : ClassTag](name: String)(implicit spark: SparkSession, log: Logger): RDD[T] =
    {
        spark.sparkContext.getPersistentRDDs.find (_._2.name == name) match
        {
            case Some ((_: Int, rdd: RDD[_])) =>
                rdd.asInstanceOf[RDD[T]]
            case Some (_) | None =>
                spark.sparkContext.emptyRDD[T]
        }
    }

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
     * Persist the typed RDD using the given name, checkpoint it if that is enabled, and create the SQL view for it.
     *
     * Should only be used where a non-CIM case class needs to be added to the persistent RDD list and registered as a SQL view.
     *
     * @param rdd The RDD to persist
     * @param name The name under which to persist it.
     * @param spark The Spark session.
     * @param storage The storage level for persistence.
     * @return The named, viewed and possibly checkpointed original RDD.
     * @tparam T The type of RDD.
     */
    def put[T <: Product : ClassTag : TypeTag](rdd: RDD[T], name: String)(implicit spark: SparkSession, storage: StorageLevel): RDD[T] =
    {
        spark.sparkContext.getPersistentRDDs.find (_._2.name == name) match
        {
            case Some ((_: Int, old: RDD[_])) =>
                old.setName (null).unpersist (true)
            case Some (_) | None =>
        }
        rdd.setName (name).persist (storage)
        if (spark.sparkContext.getCheckpointDir.isDefined) rdd.checkpoint ()
        val tag: universe.TypeTag[T] = typeTag[T]
        val runtime_class: Class[_] = classTag[T].runtimeClass
        val df = spark.createDataFrame (rdd)(tag)
        if (df.schema.fields (0).name == "sup")
        {
            val altered_schema = modify_schema (runtime_class, df.schema)
            spark.createDataFrame (rdd.asInstanceOf[RDD[Row]], altered_schema).createOrReplaceTempView (name)
        }
        else
            spark.createDataFrame (rdd).createOrReplaceTempView (name)
        rdd
    }

    /**
     * Get the base name of the CIM class.
     *
     * @tparam T The type of the class.
     * @return The base name of the class.
     */
    def nameOf[T : ClassTag]: String =
    {
        val classname = classTag[T].runtimeClass.getName
        classname.substring (classname.lastIndexOf (".") + 1)
    }

    /**
     * Check for the typed RDD.
     *
     * Convenience method where the name of the RDD is the same as the contained
     * class type (the usual case).
     *
     * @param spark The Spark session which persisted the typed RDD.
     * @param log A logger for error messages.
     * @tparam T The type of the RDD, e.g. <code>RDD[T]</code>.
     * @return <code>true</code> if the named RDD exists, <code>false</code> otherwise.
     */
    def test[T : ClassTag](implicit spark: SparkSession, log: Logger): Boolean = test[T] (nameOf[T])

    /**
     * Get the typed RDD.
     *
     * Convenience method where the name of the RDD is the same as the contained
     * class type (the usual case).
     *
     * @param spark The Spark session which persisted the typed RDD.
     * @param log A logger for error messages.
     * @tparam T The type of the RDD, e.g. <code>RDD[T]</code>.
     * @return The RDD with the given type of objects, e.g. <code>RDD[ACLineSegment]</code>.
     */
    def get[T : ClassTag](implicit spark: SparkSession, log: Logger): RDD[T] = get[T] (nameOf[T])

    /**
     * Get the typed RDD or an empty RDD if none was registered.
     *
     * Convenience method where the name of the RDD is the same as the contained
     * class type (the usual case).
     *
     * @param spark The Spark session which persisted the typed RDD.
     * @param log A logger for error messages.
     * @tparam T The type of the RDD, e.g. <code>RDD[T]</code>.
     * @return The RDD with the given type of objects, e.g. <code>RDD[ACLineSegment]</code>, or an empty RDD of the requested type.
     */
    def getOrElse[T : ClassTag](implicit spark: SparkSession, log: Logger): RDD[T] = getOrElse (nameOf[T])

    /**
     * Persist the typed RDD using the class name, checkpoint it if that is enabled, and create the SQL view for it.
     *
     * @param rdd The RDD to persist
     * @param spark The Spark session.
     * @param storage The storage level for persistence.
     * @tparam T The type of RDD.
     */
    def put[T <: Product : ClassTag : TypeTag](rdd: RDD[T])(implicit spark: SparkSession, storage: StorageLevel): RDD[T] = put (rdd, nameOf[T])
}
