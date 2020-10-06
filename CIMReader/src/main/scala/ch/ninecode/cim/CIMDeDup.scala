package ch.ninecode.cim

import org.apache.spark.rdd.RDD
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions
import org.apache.spark.sql.SparkSession
import org.apache.spark.storage.StorageLevel
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import ch.ninecode.model._

/**
 * Handle duplicate processing.
 *
 * For each element with id X, if there are other elements with "rdf:ID='X'",
 * this class chooses only one.
 *
 * This "duplicates" condition arises, for example, when spatial filters
 * are applied to tile large datasets to partition the export task into
 * smaller subsets, for reasons such as parallelization, memory
 * constraints, etc.
 *
 * A linear element crossing a tile boundary can be exported in either tile,
 * if it can be determined beforehand which tile. A simpler option is to
 * export such objects in all tiles whose spatial extents includes
 * some of the element. It is also nice to include
 * related elements to make each tile self consistent.
 *
 * These tiles must then be recombined into the full dataset,
 * which is the task for this component - to delete duplicate elements.
 *
 * Warnings are generated if the deleted elements are not identical to
 * the elements that are retained.
 *
 * @param spark   The Spark session this class is running in.
 * @param storage The storage level to cache the resultant RDD.
 */
class CIMDeDup (spark: SparkSession, storage: StorageLevel = StorageLevel.MEMORY_AND_DISK_SER) extends CIMRDD with Serializable
{
    implicit val session: SparkSession = spark
    implicit val storage_level: StorageLevel = storage // for put()
    implicit val log: Logger = LoggerFactory.getLogger (getClass)

    /**
     * Compare elements for equality.
     *
     * Since all but one element with the same mRID will be deleted,
     * this checks that they really are the same.
     *
     * It logs a warning if the elements are not equal.
     *
     * @param element The "primary" element.
     * @param others  The "other" elements, although this choice of primary and other is arbitrary.
     */
    def check (element: Element, others: Iterable[Element]): Unit =
    {
        others match
        {
            case e :: t =>
                if (element != e)
                    log.warn (s"element ${element.id} has a non-identical duplicate")
                check (element, t)
            case Nil =>
        }
    }

    /**
     * Perform deduplication - keep only one element.
     *
     * @param elements The elements with identical mRID.
     * @return One element (the head of the list) after checking the others are true duplicates.
     */
    def deduplicate (elements: Iterable[Element]): Element =
    {
        elements.toList match
        {
            case head :: Nil =>
                head
            case head :: tail =>
                // check for equality
                check (head, tail)
                head
            case _ => BasicElement ()
        }
    }

    /**
     * Replace the Element RDD with a de-duplicated version.
     *
     * Since RDD are immutable, another copy is created containing only unique elements
     * and this replaces the current RDD[Element] referenced by the persistent
     * RDD registry.
     *
     * The new RDD is cached and checkpointed (if checkpointing is enabled by the Spark context having a CheckpointDir).
     *
     * @return The new element RDD.
     */
    def do_deduplicate (): RDD[Element] =
    {
        log.info ("eliminating duplicates")

        // get the elements RDD
        val elements = getOrElse [Element]

        // deduplicate
        val new_elements = elements.keyBy (_.id).groupByKey ().values.map (deduplicate)

        // swap the old Elements RDD for the new one
        put (new_elements, false)

        new_elements
    }
}