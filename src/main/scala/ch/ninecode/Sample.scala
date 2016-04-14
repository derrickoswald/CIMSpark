package ch.ninecode

import org.apache.spark._
import org.apache.spark.graphx._
import org.apache.spark.rdd.RDD
import scala.collection.mutable.HashMap
import scala.collection.mutable.MutableList
import org.apache.spark.sql.SQLContext

/**
 *   For an execution example see main().
 *
 */

class Sample extends Serializable
{

    // based on the Pregel sample at http://spark.apache.org/docs/latest/graphx-programming-guide.html#pregel-api

    // messages are a Tuple2 with busbar name String (use hashCode() to get VertexId) and distance as a Double

    var count = 0

    def vprog (id: VertexId, v: (ch.ninecode.ConnectivityNode, (String, Double), String), distances: (String, Double)): (ch.ninecode.ConnectivityNode, (String, Double), String) =
    {
        var ret = v
        count += 1
        if (null == distances)
        {
            // initial message
            val busbar = if ((v._1 != null) && (v._1.name.startsWith ("SAM"))) v._1.name else null
            if (null != busbar)
                ret = ((v._1, (busbar, 0.0), v._3))
        }
        else
        {
            // subsequent messages
            val abgang = if ((v._1 != null) && v._1.name.startsWith ("ABG") && !v._1.container.startsWith ("_substation")) v._1.name else null
            ret = ((v._1, (distances._1, distances._2), abgang))
        }
        if (null != ret._2._1)
            println ("vprog " + count + ": " + id + (if (null != ret._1) " " + ret._1.name + "[" + ret._2._1 + "->" + ret._2._2 + "]" else ""))
        return (ret)
    }

    def sendMessage (triplet: EdgeTriplet[(ch.ninecode.ConnectivityNode, (String, Double), String), ch.ninecode.cim.Edge]): Iterator[(VertexId, (String, Double))] =
    {
        var ret:Iterator[(VertexId, (String, Double))] = Iterator.empty
        if (triplet.attr == null)
            println ("null attr for " + triplet.toString ())
        if ((null != triplet.srcAttr) && (null != triplet.dstAttr))
        {
            // compute the distance to the downstream vertex
            val distance = triplet.srcAttr._2._2 + triplet.attr.length
            // get the distance it may already have
            val existing = triplet.dstAttr._2._2
            if (distance < existing)
            {
                val abgang = triplet.srcAttr._3
                if (null == abgang)
                {
                    println (triplet.srcId + " -> " + (if (triplet.attr != null) (triplet.attr.id_seq_1 + " " + triplet.attr.id_equ + " " + triplet.attr.id_seq_2) else "null") + " -> " + triplet.dstId + " " + distance + "<" + existing)
                    ret = Iterator ((triplet.dstId, (triplet.srcAttr._2._1, distance)))
                }
                else
                {
                    // for now just stop
                    println ("stopping at " + (if (null == triplet.dstAttr._1) "**unknown**" else triplet.dstAttr._1.name) + " " + (if (triplet.attr != null) (triplet.attr.id_seq_1 + " " + triplet.attr.id_equ + " " + triplet.attr.id_seq_2) else "null") + " " + distance)
                }
            }
        }
        else
        {
            if (null == triplet.srcAttr)
                println ("null srcAttr for " + triplet.toString ())
            if (null == triplet.dstAttr)
                println ("null dstAttr for " + triplet.toString ())
        }
        return (ret)
    }

    def mergeMessage (a: (String, Double), b: (String, Double)): (String, Double) =
    {
        if (a._1 != b._1)
            println ("conflicting Busbars servicing one vertex")
        return ((a._1, math.min (a._2, b._2)))
    }

    def graphx (sc: SparkContext): Graph[(ch.ninecode.ConnectivityNode, (String, Double), String), ch.ninecode.cim.Edge] =
    {
        // get the named RDD from the CIM reader
        var vertices:RDD[ch.ninecode.ConnectivityNode] = null
        var edges:RDD[ch.ninecode.cim.Edge] = null
        val rdds = sc.getPersistentRDDs
        for (key <- rdds.keys)
        {
            val rdd = rdds (key)
            if (rdd.name == "Vertices")
                vertices = rdds (key).asInstanceOf[RDD[ch.ninecode.ConnectivityNode]]
            if (rdd.name == "Edges")
                edges = rdds (key).asInstanceOf[RDD[ch.ninecode.cim.Edge]]
        }

        // make and process the graph
        var graph:Graph[(ch.ninecode.ConnectivityNode, (String, Double), String), ch.ninecode.cim.Edge] = null
        if ((null != vertices) && (null != edges))
        {
            println ("Found the vertices RDD: " + vertices.name)
            println ("Found the edges RDD: " + edges.name)

            // keep only non-self connected and non-singly connected edges
            edges =  edges.filter ((e: ch.ninecode.cim.Edge) => { (e.id_seq_1 != e.id_seq_2) && e.id_seq_2 != "" })

            // augment the elements to have the distance and upstream abgang using the VertexWithDistance class
            var elementsplus = vertices.flatMap (
                (v: ch.ninecode.ConnectivityNode) =>
                {
                    Array ((v, (null.asInstanceOf[String], Double.PositiveInfinity), null.asInstanceOf[String]))
                }
            )

            // ToDo: what about hashCode() clashes
            // check: var set = graph.vertices. aggregate (new HashSet[Long]()) ((set, v) => { if (!set.add (v._1)) println (v._1); set }, (set1, set2) => set1++ set2)
            // with sample data there were none

            // create RDD of (key, value) pairs
            var _elements = elementsplus.keyBy (_._1.name.hashCode().asInstanceOf[VertexId])

            // convert CIM edges into graphx edges
            var _edges = edges.flatMap (
                (e: ch.ninecode.cim.Edge) =>
                {
                    Array (new Edge (e.id_seq_1.hashCode(), e.id_seq_2.hashCode(), e))
                }
            )

            // construct the graph from the augmented elements (vertices) and edges
            val default = (null, (null, Double.PositiveInfinity), null)
            val initial = Graph.apply[(ch.ninecode.ConnectivityNode, (String, Double), String), ch.ninecode.cim.Edge] (_elements, _edges, default)

            // perform the graph tracing
            graph = initial.pregel (null.asInstanceOf[(String, Double)], Int.MaxValue, EdgeDirection.Either) (vprog, sendMessage, mergeMessage)
        }

        return (graph)
    }

    def seqOp (sum: Double, v: Tuple2[VertexId, (ch.ninecode.ConnectivityNode, (String, Double), String)]): Double =
    {
        if (null != v._2)
            if (v._2._2._2 != Double.PositiveInfinity) v._2._2._2 + sum else sum
        else
            sum
    }

    def combOp (a: Double, b: Double): Double =
    {
        if (a != Double.PositiveInfinity)
            if (b != Double.PositiveInfinity)
                a + b
            else
                a
        else if (b != Double.PositiveInfinity)
            b
        else
            Double.PositiveInfinity
    }
}

object Sample
{
    def main (args: Array[String])
    {
        // create the configuration
        val configuration = new SparkConf ()
        configuration.setAppName ("Simple")
        configuration.setMaster ("local[2]")
        // make a Spark context and SQL context
        val context = new SparkContext (configuration)
        val sqlContext = new SQLContext (context)
        context.setLogLevel ("OFF") // Valid log levels include: ALL, DEBUG, ERROR, FATAL, INFO, OFF, TRACE, WARN
        try
        {
             // read the CIM file
             var options = HashMap[String, String] ("path" -> "file:///home/derrick/code/CIMScala/data/dump_ews.xml")
             val elements = sqlContext.read.format ("ch.ninecode.cim").options (options)
             var rdd = elements.load ()
             rdd.head ()
             // compute the graph of distances from busbars
             var sample = new ch.ninecode.Sample ()
             var graph = sample.graphx (context)
             // print the sum of the distances
             println (graph.vertices.aggregate (0.0) (sample.seqOp, sample.combOp))
        }
        finally context.stop () // clean up
    }
}
