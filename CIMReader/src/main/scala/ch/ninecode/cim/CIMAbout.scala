package ch.ninecode.cim

import ch.ninecode.model._
import org.apache.spark.rdd.RDD
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions
import org.apache.spark.sql.SparkSession
import org.apache.spark.storage.StorageLevel
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Handle "about" processing.
 *
 * For each element with id X, if there are elements with "rdf:about='X'",
 * this class merges the about elements into the "primary" element(s).
 *
 * @param spark The Spark session this class is running in.
 * @param storage The storage level to cache the resultant RDD.
 */
class CIMAbout (spark: SparkSession, storage: StorageLevel = StorageLevel.MEMORY_AND_DISK_SER)
extends
    CIMRDD
with
    Serializable
{
    implicit val session: SparkSession = spark
    implicit val storage_level: StorageLevel = storage // for put()
    implicit val log: Logger = LoggerFactory.getLogger (getClass)

    /**
     * Apply rdf:about elements to the primary element.
     *
     * @param arg The primary element and any rdf:about elements.
     * @return The new element if there were rdf:about elements to merge,
     * or the original element if there were none.
     */
    def merge (arg: (Element, Option[Iterable[Element]])): Element =
    {
        val original = arg._1
        val maybe__about = arg._2

        // get the class we're working on
        val clz = original.getClass
        // get the bitfields
        val bitfields: Array[Int] = original.bitfields.clone
        // process any rdf:about elements
        maybe__about match
        {
            case Some (abouts: Iterable[Element]) =>
                val fields = (for (i <- 0 until original.length) yield original.get (i)).toArray
                for (about <- abouts)
                    if (clz.getCanonicalName == about.getClass.getCanonicalName) // check the class is the same
                    {
                        for (i <- 0 until original.length - 1)
                            if (about.mask (i))
                            {
                                fields(i + 1) = about.get (i + 1) // shift by one to avoid superclass
                                bitfields(i / 32) |= (1 << (i % 32))
                            }
                    }
                    else
                        log.error ("rdf:about class %s is not the same as the reference class %s".format (about.getClass.getCanonicalName, clz.getCanonicalName))
                // recurse for superclasses
                fields(0) = if (null != original.sup) merge ((original.sup, Some (abouts.map (_.sup)))) else null
                val c = clz.getConstructors.filter (_.getParameterCount == fields.length).head
                val n = c.newInstance (fields: _*).asInstanceOf[Element]
                n.bitfields  = bitfields
                n
            case None =>
                original
        }
    }

    /**
     * Replace the Element RDD with a version with no rdf:about elements.
     *
     * Since RDD are immutable, another copy is created containing only
     * primary elements (elements with rdf:ID attributes) and this replaces
     * the current RDD[Element] referenced by the persistent
     * RDD registry. The old element RDD is renamed to "about_Elements".
     * Multiple (duplicate) primary elements each have all rdf:about elements
     * merged into them (no de-duplication).
     *
     * The new RDD is cached and checkpointed (if checkpointing is enabled).
     *
     * @return The new element RDD.
     */
    def do_about (): RDD[Element] =
    {
        // get the elements RDD
        val elements = getOrElse[Element]("Elements")

        // get the elements flagged as "rdf:about"
        val about_elements = elements.filter (_.about).groupBy (_.id)

        if (!about_elements.isEmpty)
        {
            log.info ("merging rdf:about elements")

            // clusters of similarly named elements
            val element_groups = elements.filter (!_.about).keyBy (_.id).leftOuterJoin (about_elements).values

            val new_elements = element_groups.map (merge)

            // swap the old Elements RDD for the new one
            put (new_elements, "Elements")

            new_elements
        }
        else
            elements
    }
}
