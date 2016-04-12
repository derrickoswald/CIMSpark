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

    // We can use the Pregel operator to express computation such as single source shortest path in the following example.
    //    import org.apache.spark.graphx._
    //    // Import random graph generation library
    //    import org.apache.spark.graphx.util.GraphGenerators
    //    // A graph with edge attributes containing distances
    //    val graph: Graph[Long, Double] =
    //        GraphGenerators.logNormalGraph(sc, numVertices = 100).mapEdges(e ⇒ e.attr.toDouble)
    //    val sourceId: VertexId = 42 // The ultimate source
    //    // Initialize the graph such that all vertices except the root have distance infinity.
    //    val initialGraph = graph.mapVertices((id, _) ⇒ if (id == sourceId) 0.0 else Double.PositiveInfinity)
    //    val sssp = initialGraph.pregel(Double.PositiveInfinity)(
    //        (id, dist, newDist) ⇒ math.min(dist, newDist), // Vertex Program
    //        triplet ⇒ { // Send Message
    //            if (triplet.srcAttr + triplet.attr < triplet.dstAttr) {
    //                Iterator((triplet.dstId, triplet.srcAttr + triplet.attr))
    //            }
    //            else {
    //                Iterator.empty
    //            }
    //        },
    //        (a, b) ⇒ math.min(a, b) // Merge Message
    //    )
    //    println(sssp.vertices.collect.mkString("\n"))

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
            val distance = triplet.srcAttr.distance + triplet.attr.length
            if (triplet.srcAttr.abgang != null)
            {
                triplet.dstAttr.abgang = triplet.srcAttr.abgang
                // for now just stop
                println ("stopping at " + (if (null == triplet.dstAttr.vertex) "**unknown**" else triplet.dstAttr.vertex.name))
            }
            else
                if (distance < triplet.dstAttr.distance)
                {
                    println (triplet.srcId + " -> " + (if (triplet.attr != null) (triplet.attr.id_seq_1 + " " + triplet.attr.id_equ + " " + triplet.attr.id_seq_2) else "null") + " -> " + triplet.dstId + " " + distance)
                    ret = Iterator ((triplet.dstId, distance))
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

            // augment the elements to have the distance and upstream abgang
            var elementsplus = vertices.flatMap ((v: ch.ninecode.ConnectivityNode) => { Array (VertexWithDistance (v, Double.PositiveInfinity, if (v.name.startsWith ("ABG") && v.container.startsWith ("_subnetwork")) v else null)) })

            // construct the graph from the edges and augmented elements (vertices)
            // ToDo: what about hashCode() clashes
            var _elements = elementsplus.keyBy (_.vertex.name.hashCode().asInstanceOf[VertexId])
            var _edges = edges.flatMap ((e: ch.ninecode.cim.Edge) => { Array (new Edge (e.id_seq_1.hashCode(), e.id_seq_2.hashCode(), e)) })
            graph = Graph.apply[VertexWithDistance, ch.ninecode.cim.Edge] (_elements, _edges, VertexWithDistance (null, Double.PositiveInfinity))

            // get all the busbars
            //var sammelschienen = graph.vertices.filter (x => { (x._2 != null) && (x._2.element != null) && (x._2.element.key.startsWith ("_busbar")) })
/*
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
*/
        }

        return (graph)
    }
}
