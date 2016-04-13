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
 *   var graph = sample.graphx (sc)
 *
 */

case class VertexWithDistance (vertex: ch.ninecode.ConnectivityNode, var distance: Double, var abgang: ch.ninecode.Element = null) extends Serializable

class Sample extends Serializable
{

    // based on the Pregel sample at http://spark.apache.org/docs/latest/graphx-programming-guide.html#pregel-api

    def vprog (id: VertexId, v: VertexWithDistance, distance: Double): VertexWithDistance =
    {
        if (null != v)
            v.distance = math.min (v.distance, distance)
        return (v)
    }

    def sendMessage (triplet: EdgeTriplet[VertexWithDistance, ch.ninecode.cim.Edge]): Iterator[(VertexId, Double)] =
    {
        var ret:Iterator[(VertexId, Double)] = Iterator.empty
        if ((null != triplet.srcAttr) && (null != triplet.dstAttr))
        {
            // identify the upstream abgang vertex - if any
            val v = triplet.srcAttr.vertex
            val abgang = if ((null != v) && v.name.startsWith ("ABG") && v.container.startsWith ("_subnetwork")) v else null

            // compute the distance to the downstream vertex
            val distance = triplet.srcAttr.distance + triplet.attr.length
            if (distance < triplet.dstAttr.distance)
            {
                triplet.dstAttr.distance = distance
                if (null == abgang)
                {
                    println (triplet.srcId + " -> " + (if (triplet.attr != null) (triplet.attr.id_seq_1 + " " + triplet.attr.id_equ + " " + triplet.attr.id_seq_2) else "null") + " -> " + triplet.dstId + " " + distance + "<" + triplet.dstAttr.distance)
                    ret = Iterator ((triplet.dstId, distance))
                }
                else
                {
                    triplet.dstAttr.abgang = triplet.srcAttr.abgang
                    // for now just stop
                    println ("stopping at " + (if (null == triplet.dstAttr.vertex) "**unknown**" else (triplet.dstAttr.vertex.name + distance)))
                }
            }
        }
        return (ret)
    }

    def mergeMessage (a: Double, b: Double): Double =
    {
        math.min (a, b)
    }

    def seqOp (sum: Double, v: Tuple2[VertexId, VertexWithDistance]): Double =
    {
        if (null != v._2)
            if (v._2.distance != Double.PositiveInfinity) v._2.distance + sum else sum
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

    def graphx (sc: SparkContext): Graph[VertexWithDistance, ch.ninecode.cim.Edge] =
    {
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

        var graph:Graph[VertexWithDistance, ch.ninecode.cim.Edge] = null
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
                    Array (VertexWithDistance (v, Double.PositiveInfinity))
                }
            )

            // ToDo: what about hashCode() clashes
            // check: var set = graph.vertices. aggregate (new HashSet[Long]()) ((set, v) => { if (!set.add (v._1)) println (v._1); set }, (set1, set2) => set1++ set2)

            // create RDD of (key, value) pairs
            var _elements = elementsplus.keyBy (_.vertex.name.hashCode().asInstanceOf[VertexId])

            // convert CIM edges into graphx edges
            var _edges = edges.flatMap (
                (e: ch.ninecode.cim.Edge) =>
                {
                    Array (new Edge (e.id_seq_1.hashCode(), e.id_seq_2.hashCode(), e))
                }
            )

            // construct the graph from the augmented elements (vertices) and edges
            val default = VertexWithDistance (null, Double.PositiveInfinity)
            graph = Graph.apply[VertexWithDistance, ch.ninecode.cim.Edge] (_elements, _edges, default)

            // get all the busbars
            //var sammelschienen = graph.vertices.filter (x => { (x._2 != null) && (x._2.element != null) && (x._2.element.key.startsWith ("_busbar")) })

            // just do one for now
            var busbar = "SAM1753_node".hashCode ()

            // initialize the graph such that all vertices except the root have distance infinity
            val initial = graph.mapVertices (
                (id, v) =>
                {
                    if (null != v)
                        v.distance = if (id == busbar) 0.0 else Double.PositiveInfinity
                    v
                }
            )

            // perform the graph tracing
            graph = initial.pregel (Double.PositiveInfinity) (vprog, sendMessage, mergeMessage)

            // print the sum of the distances
            println (graph.vertices.aggregate (0.0) (seqOp, combOp))
        }

        return (graph)
    }
}
