package ch.ninecode.cim

import scala.reflect._
import scala.reflect.runtime.universe._
import scala.util.Random

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession
import org.apache.spark.storage.StorageLevel
import org.slf4j.Logger

/**
  * Access globally named and cached RDD of CIM classes.
  *
  * This uses the list of persistent RDDs maintained by Spark
  * to retrieve pre-existing RDD of CIM classes pesisted by the
  * CIMReader.
  *
  * These RDD are strongly typed, and are named according to the
  * corresponding CIM class. For example, there is an <code>RDD[ACLineSegment]</code>
  * with the name <code>"ACLineSegment"</code> persisted and remembered in the
  * <code>spark.sparkContext.getPersistentRDDs: collection.Map[Int, RDD[_] ]</code>
  * by the CIMReader.
  *
  * Implicit parameters for the Spark context and error logger are required.
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
            case Some (_) =>
                log.warn (name + " not found in Spark context persistent RDDs map")
                null
            case None =>
                log.warn (name + " not found in Spark context persistent RDDs map")
                null
        }
    }

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
    def get[T : ClassTag](implicit spark: SparkSession, log: Logger): RDD[T] =
    {
        val classname = classTag[T].runtimeClass.getName
        val name = classname.substring (classname.lastIndexOf (".") + 1)
        get (name)
    }

    /**
     * Persist the typed RDD using the given name and create the SQL view for it.
     *
     * Should only be used where a non-CIM case class needs to be added to the persistent RDD list and registered as a SQL view.
     *
     * @param rdd The RDD to persist
     * @param name The name under which to persist it.
     * @param spark The Spark session.
     * @param storage The storage level for persistence.
     * @tparam T The type of RDD.
     */
    def put[T <: Product : ClassTag : TypeTag](rdd: RDD[T], name: String)(implicit spark: SparkSession, storage: StorageLevel): Unit =
    {
        val rdds: collection.Map[Int, RDD[_]] = spark.sparkContext.getPersistentRDDs
        rdds.find (_._2.name == name) match
        {
            case Some ((_: Int, old: RDD[_])) =>
                old.name = name + "_old" + Random.nextInt (99999999)
            case Some (_) =>
            case None =>
        }
        rdd.name = name
        rdd.persist (storage)
        spark.sparkContext.getCheckpointDir match
        {
            case Some (_) => rdd.checkpoint ()
            case None =>
        }
        spark.createDataFrame (rdd).createOrReplaceTempView (name)
    }

    /**
     * Persist the typed RDD using the class name and create the SQL view for it.
     *
     * Should only be used where a non-CIM case class needs to be added to the persistent RDD list and registered as a SQL view.
     *
     * @param rdd The RDD to persist
     * @param spark The Spark session.
     * @param storage The storage level for persistence.
     * @tparam T The type of RDD.
     */
    def put[T <: Product: ClassTag : TypeTag](rdd: RDD[T])(implicit spark: SparkSession, storage: StorageLevel): Unit =
    {
        val classname = classTag[T].runtimeClass.getName
        val name = classname.substring (classname.lastIndexOf (".") + 1)
        put (rdd, name)
    }
}
