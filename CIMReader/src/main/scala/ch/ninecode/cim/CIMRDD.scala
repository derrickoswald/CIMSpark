package ch.ninecode.cim

import scala.reflect._
import scala.reflect.runtime.universe._

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.Dataset
import org.apache.spark.sql.SparkSession
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
 *     implicit val level: StorageLevel = storage // for put()
 *     implicit val session = spark
 *
 *     def process =
 *     {
 *         val switches: RDD[Switch] = getOrElse[Switch]
 *         ⋮
 *     }
 * }
 * }}}
 */
trait CIMRDD
{
    /**
     * The RDD name pattern.
     *
     * By default this simply returns the unqualified class name T for RDD[T].
     * For example, the name for RDD[ch.ninecode.model.ACLineSegment] would be "ACLineSegment".
     * To support the use case of multiple named RDD[T] in Spark memory at the same time,
     * this method and the corresponding functionality in the CIMRReader ("ch.ninecode.cim.name_template")
     * allows classes that override <code>pattern</code> to store and retrieve RDD
     * to/from Spark's list of persistent RDD with a name derived from the unqualified class name.
     * For example, a CIM difference program could read two CIM files, one with ch.ninecode.cim.name_template=%s_1,
     * and the other with ch.ninecode.cim.name_template=%s_2, and be able to compute difference RDD, i.e.:
     *
     * var Pattern = "%s"
     * override def pattern = Pattern
     *
     * spark.read.options (Map ("ch.ninecode.cim.name_template" -> "%s_1")).cim (file1).count
     * spark.read.options (Map ("ch.ninecode.cim.name_template" -> "%s_2")).cim (file2).count
     *
     * Pattern = "%s_1"
     * val rdd1 = getOrElse[ACLineSegment]
     * Pattern = "%s_2"
     * val rdd2 = getOrElse[ACLineSegment]
     *
     * The pattern must include %s where the unqualified class name of the class is inserted by String.format().
     *
     * @return the name pattern for all classes stored and retrieved from the Spark persistent RDD list.
     */
    def pattern: String = "%s"

    /**
     * Apply the pattern to the name to get the RDD name.
     *
     * @param name the root name of the RDD
     * @return the patterned name as formatted
     */
    def applyPattern (name: String): String = pattern.format(name)

    /**
     * Check for the named RDD.
     *
     * @param name  The name of the RDD, usually the same as the CIM class.
     * @param spark The Spark session which persisted the named RDD.
     * @tparam T The type of objects contained in the named RDD.
     * @return <code>true</code> if the named RDD exists, <code>false</code> otherwise.
     */
    def test[T: ClassTag] (name: String)(implicit spark: SparkSession): Boolean =
    {
        val target = applyPattern(name)
        spark.sparkContext.getPersistentRDDs.find(_._2.name == target) match
        {
            case Some((_: Int, _: RDD[_])) =>
                true
            case Some(_) | None =>
                false
        }
    }

    /**
     * Get the named RDD.
     *
     * @param name  The name of the RDD, usually the same as the CIM class.
     * @param spark The Spark session which persisted the named RDD.
     * @param log   A logger for error messages.
     * @tparam T The type of objects contained in the named RDD.
     * @return The typed RDD, e.g. <code>RDD[T]</code>.
     * @example If there were two CIM files read in and stored with names having suffix _1 and _2,
     *          this would get both of the RDD[Element] :
     * {{{val elements_1: RDD[Element] = get[Element]("Element_1")}}}
     * {{{val elements_2: RDD[Element] = get[Element]("Element_2")}}}
     *
     */
    def get[T: ClassTag] (name: String)(implicit spark: SparkSession, log: Logger): RDD[T] =
    {
        val target = applyPattern(name)
        spark.sparkContext.getPersistentRDDs.find(_._2.name == target) match
        {
            case Some((_: Int, rdd: RDD[_])) =>
                rdd.asInstanceOf[RDD[T]]
            case Some(_) | None =>
                log.warn("""%s not found in Spark context persistent RDDs map""".format(name))
                null
        }
    }

    /**
     * Get the named RDD or else an empty RDD of the requested type.
     *
     * @param name  The name of the RDD, usually the same as the CIM class.
     * @param spark The Spark session which persisted the named RDD.
     * @tparam T The type of objects contained in the named RDD.
     * @return The typed RDD, e.g. <code>RDD[T]</code>, as either the persisted RDD or an empty one if none was found.
     *
     */
    def getOrElse[T: ClassTag] (name: String)(implicit spark: SparkSession): RDD[T] =
    {
        val target = applyPattern(name)
        spark.sparkContext.getPersistentRDDs.find(_._2.name == target) match
        {
            case Some((_: Int, rdd: RDD[_])) =>
                rdd.asInstanceOf[RDD[T]]
            case Some(_) | None =>
                spark.sparkContext.emptyRDD[T]
        }
    }

    /**
     * Match names with pattern "name|xxx".
     *
     * @param name the name to match
     * @return <code>true</code> if the RDD name matches the pattern
     */
    def like (name: String): ((Int, RDD[_])) => Boolean =
    {
        val target = applyPattern(name)
        val pattern = s"$target|"
        (rdd: (Int, RDD[_])) => (rdd._2.name != null) && ((rdd._2.name == target) || rdd._2.name.startsWith(pattern))
    }

    def toInt (s: String): Option[Int] =
    {
        try
        {
            Some(s.toInt)
        }
        catch
        {
            case _: Exception => None
        }
    }

    /**
     * Find the largest integer after the name| pattern in a foldLeft operation.
     *
     * @param name the name to check
     * @return
     */
    def biggest (name: String): (Int, (Int, RDD[_])) => Int =
    {
        val target = applyPattern(name)
        val pattern = s"$target|"
        (current: Int, rdd: (Int, RDD[_])) =>
        {
            val rdd_name = rdd._2.name
            if (rdd_name.startsWith(pattern))
                toInt(rdd_name.substring(pattern.length)) match
                {
                    case Some(i) => if (i > current) i else current
                    case _ => current
                }
            else
                current
        }
    }

    /**
     * Persist the typed RDD using the given name, checkpoint it if that is enabled, and create the SQL view for it.
     *
     * Since the use of RDD persistence can be problematic for memory reuse, the <code>keep</code> parameter
     * has special processing. When <code>keep</code> is <code>true</code> any existing RDD of the same name is renamed to
     * <code>name|n</code>
     * where n is sequentially increasing to the next available integer. When <code>keep</code> is <code>false</code>
     * all existing RDD of the above form are unpersisted.
     *
     * This facilitates the use-case where the new RDD depends on the existing one. For example, the <code>Elements</code>
     * RDD is rewritten by about, dedup, join, normalize and topological processing, where the new RDD is derived from
     * the original. But when a completely new CIM RDF file is read in, <code>keep=false</code> will unpersist all
     * the derived RDD.
     *
     * @param rdd     The RDD to persist
     * @param name    The name under which to persist it.
     * @param keep    If <code>true</code> then don't unpersist the existing RDD with the given name.
     * @param spark   The Spark session.
     * @param storage The storage level for persistence.
     * @return The named, viewed and possibly checkpointed original RDD.
     * @tparam T The type of RDD.
     */
    def put[T <: Product : ClassTag : TypeTag] (rdd: RDD[T], name: String, keep: Boolean)(implicit spark: SparkSession, storage: StorageLevel): Unit =
    {
        val target = applyPattern(name)
        val matched = spark.sparkContext.getPersistentRDDs.filter(like(name))
        val next = matched.foldLeft(0)(biggest(name)) + 1
        matched.foreach(
            x =>
            {
                val (_, old) = x
                if (keep)
                    old.setName(s"$target|$next")
                else
                {
                    old.setName(null)
                    old.unpersist(true)
                }
            }
        )
        val _ = rdd.setName(target).persist(storage)
        if (spark.sparkContext.getCheckpointDir.isDefined) rdd.checkpoint()
        spark.createDataFrame(rdd).createOrReplaceTempView(target)
    }

    /**
     * Get the base name of the CIM class.
     *
     * @tparam T The type of the class.
     * @return The base name of the class.
     */
    def nameOf[T: ClassTag]: String =
    {
        val classname = classTag[T].runtimeClass.getName
        classname.substring(classname.lastIndexOf(".") + 1)
    }

    /**
     * Check for the typed RDD.
     *
     * Convenience method where the name of the RDD is the same as the contained
     * class type (the usual case).
     *
     * @param spark The Spark session which persisted the typed RDD.
     * @tparam T The type of the RDD, e.g. <code>RDD[T]</code>.
     * @return <code>true</code> if the named RDD exists, <code>false</code> otherwise.
     */
    def test[T: ClassTag] (implicit spark: SparkSession): Boolean = test[T](nameOf[T])

    /**
     * Get the typed RDD.
     *
     * Convenience method where the name of the RDD is the same as the contained
     * class type (the usual case).
     *
     * @param spark The Spark session which persisted the typed RDD.
     * @param log   A logger for error messages.
     * @tparam T The type of the RDD, e.g. <code>RDD[T]</code>.
     * @return The RDD with the given type of objects, e.g. <code>RDD[ACLineSegment]</code>.
     */
    def get[T: ClassTag] (implicit spark: SparkSession, log: Logger): RDD[T] = get[T](nameOf[T])

    /**
     * Get the typed RDD or an empty RDD if none was registered.
     *
     * Convenience method where the name of the RDD is the same as the contained
     * class type (the usual case).
     *
     * @param spark The Spark session which persisted the typed RDD.
     * @tparam T The type of the RDD, e.g. <code>RDD[T]</code>.
     * @return The RDD with the given type of objects, e.g. <code>RDD[ACLineSegment]</code>, or an empty RDD of the requested type.
     */
    def getOrElse[T: ClassTag] (implicit spark: SparkSession): RDD[T] = getOrElse(nameOf[T])

    /**
     * Persist the typed RDD using the class name, checkpoint it if that is enabled, and create the SQL view for it.
     *
     * @param rdd     The RDD to persist
     * @param keep    If <code>true</code> then don't unpersist any existing RDD with the given name.
     * @param spark   The Spark session.
     * @param storage The storage level for persistence.
     * @tparam T The type of RDD.
     */
    def put[T <: Product : ClassTag : TypeTag] (rdd: RDD[T], keep: Boolean = false)(implicit spark: SparkSession, storage: StorageLevel): Unit =
        put(rdd, nameOf[T], keep)

    /**
     * Get a typed DataSet for the given class.
     *
     * @param spark The Spark session.
     * @tparam T The type of RDD.
     * @return A typed dataset of the RDD.
     */
    def asDataSet[T <: Product : ClassTag : TypeTag] (implicit spark: SparkSession): Dataset[T] =
    {
        import spark.sqlContext.implicits._
        val rdd = getOrElse[T]
        spark.createDataset(rdd)
    }
}
