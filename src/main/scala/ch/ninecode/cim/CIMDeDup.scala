package ch.ninecode.cim

import org.apache.spark.rdd.RDD
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions
import org.apache.spark.sql.Row
import org.apache.spark.sql.SparkSession
import org.apache.spark.storage.StorageLevel
import org.slf4j.LoggerFactory

import ch.ninecode.model._

class CIMDeDup (session: SparkSession, storage: StorageLevel) extends Serializable
{
    private val log = LoggerFactory.getLogger(getClass)

    def get (name: String): RDD[Element] =
    {
        val rdds = session.sparkContext.getPersistentRDDs
        for (key <- rdds.keys)
        {
            val rdd = rdds (key)
            if (rdd.name == name)
                return (rdd.asInstanceOf[RDD[Element]])
        }
        return (null)
    }

    def check (element: Element, others: Iterable[Element]): Unit =
    {
        others match
        {
            case e::t =>
                if (element != e)
                    log.warn ("element " + element.id + " has a non-identical duplicate")
                check (element, t)
            case Nil =>
        }
    }

    def dedup (arg: Iterable[Element]): List[Element] =
    {
        val ret = arg.head
        if (1 != arg.size)
            // check for equality
            check (ret, arg.tail)
        List (ret)
    }

    def do_dedupulicate (): (RDD[Element], RDD[Row]) =
    {
        // get the elements RDD
        val elements = get ("Elements").asInstanceOf[RDD[Element]]

        // deduplicate
        val new_elements = elements.keyBy (_.id).groupByKey ().values.flatMap (dedup)

        // swap the old Elements RDD for the new one
        elements.name = "duplicate_Elements"
        new_elements.name = "Elements"
        new_elements.persist (storage)
        session.sparkContext.getCheckpointDir match
        {
            case Some (dir) => new_elements.checkpoint ()
            case None =>
        }

        (new_elements, new_elements.asInstanceOf[RDD[Row]])
    }
}