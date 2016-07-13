package ch.ninecode

import org.apache.spark._
import org.apache.spark.graphx._
import org.apache.spark.rdd.RDD
import scala.collection.mutable.HashMap
import scala.collection.mutable.MutableList
import org.apache.spark.sql.SQLContext

import ch.ninecode.model.ConnectivityNode

/**
 *   For an execution example see main().
 */

/**
 * Message passed between nodes when tracing.
 * busbar - that triggered the trace (use hashCode() to get VertexId)
 * distance - the distance traversed so far in the path
 * abgang - the upstream feeder (only for directly connected objects)
 */
case class Message (busbar: String, distance: Double, abgang: String) extends Serializable

/**
 * Data for each node when tracing.
 * node - the CIM connectivity node
 * trace - the last recieved (or coelesced) message data
 */
case class VertexData (node: ConnectivityNode, trace: Message)

/**
 * Simple example of using CIM.
 * Computes the average distance between directly connected house connections
 * and their corresponding busbar. See Sample.R for the R equivalent.
 */
class Sample extends Serializable
{

    // based on the Pregel sample at http://spark.apache.org/docs/latest/graphx-programming-guide.html#pregel-api
    // a better example is at http://www.cakesolutions.net/teamblogs/graphx-pregel-api-an-example

    /**
     * Vertex method to handle incoming messages at each node.
     * @param id - this vertex id (hashCode() of node name)
     * @param v - the vertex data attached to this node
     * @param message - the incoming message
     * @returns the new vertex data
     */
    def vprog (id: VertexId, v: VertexData, message: Message): VertexData =
    {
        var ret = v

        if (null == message) // initial message
        {
            val busbar = if ((v.node != null) && (v.node.IdentifiedObject.name.startsWith ("SAM"))) v.node.IdentifiedObject.name else null
            if (null != busbar)
                ret = (VertexData (v.node, Message (busbar, 0.0, null)))
        }
        else // subsequent messages
            ret = (VertexData (v.node, Message (message.busbar, message.distance, message.abgang)))

        return (ret)
    }

    /**
     * The message propagation method to determine the message downstream nodes get.
     * @param triplet - this edge data, including upstream and downstream vertecies
     * @returns a list of vertex and message tuples that will be used in the next round of tracing
     */
    def sendMessage (triplet: EdgeTriplet[VertexData, ch.ninecode.cim.Edge]): Iterator[(VertexId, Message)] =
    {
        var ret:Iterator[(VertexId, Message)] = Iterator.empty

        if ((null != triplet.srcAttr) && (null != triplet.dstAttr)) // eliminate edges unconnected on one end
        {
            // compute the distance to the downstream vertex
            val distance = triplet.srcAttr.trace.distance + triplet.attr.length
            // get the distance it already has
            val existing = triplet.dstAttr.trace.distance
            if (distance < existing)
            {
                // check if upstream node is an abgang
                // ToDo: eliminate abgang with container that isn't a substation
                val node = triplet.srcAttr.node
                val abgang = if ((node != null) && node.IdentifiedObject.name.startsWith ("ABG")) node.IdentifiedObject.name else null
                ret = Iterator ((triplet.dstId, Message (triplet.srcAttr.trace.busbar, distance, abgang)))
            }
        }

        return (ret)
    }

    /**
     * Merge two messages at a vertex when more than one message is recieved.
     * For more than two messages this is applied repeatedly.
     * @param a - one message
     * @param b - the other message
     */
    def mergeMessage (a: Message, b: Message): Message =
    {
        if ((a.busbar != b.busbar) || (a.abgang != b.abgang))
            println ("conflicting Busbars servicing one vertex: a.busbar (" + a.busbar + ") != b.busbar (" + b.busbar+ ") or a.abgang (" + a.abgang + ")!= b.abgang (" + b.abgang + ")")
        return (Message (a.busbar, math.min (a.distance, b.distance), a.abgang))
    }

    /**
     * Sample GraphX program.
     * Traces the network from each busbar (sammelschien).
     * Annotates the graph with the busbar, the distance to the busbar and any upstream feeder (abgang).
     * @param sc - the Spark context
     * @returns the annotated graph
     */
    def graphx (sc: SparkContext): Graph[VertexData, ch.ninecode.cim.Edge] =
    {
        // get the named RDD from the CIM reader
        var vertices:RDD[ConnectivityNode] = null
        var edges:RDD[ch.ninecode.cim.Edge] = null
        val rdds = sc.getPersistentRDDs
        for (key <- rdds.keys)
        {
            val rdd = rdds (key)
            if (rdd.name == "ConnectivityNode")
                vertices = rdds (key).asInstanceOf[RDD[ConnectivityNode]]
            if (rdd.name == "Edges")
                edges = rdds (key).asInstanceOf[RDD[ch.ninecode.cim.Edge]]
        }

        // make and process the graph
        var graph:Graph[VertexData, ch.ninecode.cim.Edge] = null
        if ((null != vertices) && (null != edges))
        {
            println ("Found the vertices RDD: " + vertices.name)
            println ("Found the edges RDD: " + edges.name)

            // keep only non-self connected and non-singly connected edges
            edges =  edges.filter ((e: ch.ninecode.cim.Edge) => { (e.id_seq_1 != e.id_seq_2) && e.id_seq_1 != null && e.id_seq_2 != null && e.id_seq_1 != "" && e.id_seq_2 != "" })

            // augment the elements to have the busbar, distance and upstream abgang using the VertexData class
            var elementsplus = vertices.flatMap (
                (v: ConnectivityNode) =>
                {
                    Array (VertexData (v, Message (null, Double.PositiveInfinity, null)))
                }
            )

            // ToDo: what about hashCode() clashes
            // check: var set = graph.vertices. aggregate (new HashSet[Long]()) ((set, v) => { if (!set.add (v._1)) println (v._1); set }, (set1, set2) => set1++ set2)
            // with sample data there were none

            // create RDD of (key, value) pairs
            var _elements = elementsplus.keyBy (_.node.IdentifiedObject.name.hashCode().asInstanceOf[VertexId])

            // convert CIM edges into graphx edges
            var _edges = edges.flatMap (
                (e: ch.ninecode.cim.Edge) =>
                {
                    Array (new Edge (e.id_seq_1.hashCode(), e.id_seq_2.hashCode(), e))
                }
            )

            // construct the graph from the augmented elements (vertices) and edges
            val default = VertexData (null, Message (null, Double.PositiveInfinity, null))
            val initial = Graph.apply[VertexData, ch.ninecode.cim.Edge] (_elements, _edges, default)

            // perform the graph tracing
            graph = initial.pregel (null.asInstanceOf[Message], Int.MaxValue, EdgeDirection.Either) (vprog, sendMessage, mergeMessage)
        }

        return (graph)
    }

    def seqOp (sum: Tuple2[Int, Double], v: VertexData): Tuple2[Int, Double] =
    {
        (sum._1 + 1, sum._2 + v.trace.distance)
    }

    def combOp (sum1: Tuple2[Int, Double], sum2: Tuple2[Int, Double]): Tuple2[Int, Double] =
    {
        (sum1._1 + sum2._1, sum1._2 + sum2._2)
    }

    def mapOp (circuit: Tuple2[String, Tuple2[Int, Double]]): Tuple2[String, Double] =
    {
        (circuit._1, circuit._2._2 / circuit._2._1)
    }

    /**
     * Prints the average house connection length from each busbar (samelschien).
     * @param - the annotated graph
     */
    def average_house_connection_distance (graph: Graph[VertexData, ch.ninecode.cim.Edge])
    {
         // gather the house service entries with a directly connected abgang
         var has = graph.vertices.collect (
             {
                 case v: Tuple2[VertexId, VertexData]
                 if ((v._2.trace.abgang != null) // the node has an upstream abgang
                    && (v._2.trace.distance != Double.PositiveInfinity) // and it's connected
                    && (v._2.node.IdentifiedObject.name.startsWith ("HAS"))) // and it's a house connection
                    =>
                    v._2 // keep just the data
             }
         )
         // create an RDD keyed by busbar
         val has_keyed = has.keyBy (_.trace.busbar)
         // aggregate the count and distances
         val agg = has_keyed.aggregateByKey ((0, 0.0)) (seqOp, combOp)
         // print the average of the distances
         println (agg.collect.map (mapOp).mkString ("\n"))
    }
}

/**
 * Main program for sample demo.
 * Run this from within the cluster with:
 * spark-shell --master yarn --deploy-mode client --driver-memory 1g --executor-memory 4g --executor-cores 1 --jars /opt/code/CIMScala-1.6.0-SNAPSHOT.jar --class ch.ninecode.Sample hdfs:/data/NIS_CIM_Export_NS_INITIAL_FILL.rdf
 */
object Sample
{
    def main (args: Array[String])
    {
        if (args.size > 0)
        {
            val filename = args (0)
            val begin = System.nanoTime ()
            // create the configuration
            val configuration = new SparkConf ()
            configuration.setAppName ("CIMScala GraphX Sample")
            // make a Spark context and SQL context
            val context = new SparkContext (configuration)
            val sqlContext = new SQLContext (context)
            context.setLogLevel ("OFF") // Valid log levels include: ALL, DEBUG, ERROR, FATAL, INFO, OFF, TRACE, WARN
            try
            {
                val start = System.nanoTime ()
                println ("Initialization time: " + ((start - begin) / 1e9) + "s")
                // read the CIM file
                var options = HashMap[String, String] ("path" -> filename)
                val elements = sqlContext.read.format ("ch.ninecode.cim").options (options)
                var rdd = elements.load ()
                var first = rdd.head ()
                val ready = System.nanoTime ()
                println ("Setup time: " + ((ready - start) / 1e9) + "s")
                // compute the graph of distances from busbars
                var sample = new Sample ()
                var graph = sample.graphx (context)
                val traced = System.nanoTime ()
                println ("Trace time: " + ((traced - ready) / 1e9) + "s")
                sample.average_house_connection_distance (graph)
                val summary = System.nanoTime ()
                println ("Summarize time: " + ((summary - traced) / 1e9) + "s")
            }
            finally context.stop () // clean up
            val end = System.nanoTime ()
            println ("Elapsed time: " + ((end - begin) / 1e9) + "s")
        }
        else
            println ("CIM XML input file not specified")
    }
}
