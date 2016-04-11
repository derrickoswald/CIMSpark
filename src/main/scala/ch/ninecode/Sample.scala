package ch.ninecode

import org.apache.spark._
import org.apache.spark.graphx._
import org.apache.spark.rdd.RDD

/**
 *   Execute in the scala-shell with:
 *
 *   import ch.ninecode._
 *   import scala.collection.mutable.HashMap
 *   var options = new HashMap[String, String]
 *   options.put ("path", "file:///opt/data/dump_ews.xml")
 *   val elements = sqlContext.read.format ("ch.ninecode.cim").options (options)
 *   var rdd = elements.load ()
 *   rdd.head ()
 *   var sample = new ch.ninecode.Sample ()
 *   sample.graphx (sc)
 *
 *   prints:
 *   122: Edges
 */
class Sample
{

    def graphx (sc: SparkContext)
    {
        val rdds = sc.getPersistentRDDs
        for (key <- rdds.keys)
        {
            val rdd = rdds (key)
            println ("" + key + ": " + rdd.name)
        }
    }
}
