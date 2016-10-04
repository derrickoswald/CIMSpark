package ch.ninecode.cim

import org.apache.spark.graphx.EdgeDirection
import org.apache.spark.graphx.EdgeTriplet
import org.apache.spark.graphx.Graph
import org.apache.spark.graphx.Graph.graphToGraphOps
import org.apache.spark.graphx.VertexId
import org.apache.spark.rdd.RDD
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.types.SQLUserDefinedType
import org.apache.spark.storage.StorageLevel
import org.apache.spark.SparkContext

import ch.ninecode.model._

case class CuttingEdge (id_seq_1: String, id_cn_1: String, id_seq_2: String, id_cn_2: String, id_equ: String, equipment: ConductingEquipment, element: Element) extends Serializable
/**
 * island is min of all connected ConnectivityNode ( single topological island)
 * label is min of equivalent ConnectivityNode (a single topological node)
 */
case class TopologicalData (island: VertexId = Long.MaxValue, label: VertexId = Long.MaxValue) extends Serializable

/**
 * Create a topology.
 * Create TopologicalNode and TopologicalIsland RDD.
 * Based on ConnectivityNode elements and connecting edges, find the topology that has:
 * - each substation has a single bus (TopologicalNode) at each nominal voltage level
 *   for each set of BusbarSection that are conected by closed switches
 * - eliminates switches based on their open/closed state
 * - assigns each ConnectivityNode to exactly one TopologicalNode
 * - assigns each TopologicalNode to exactly one TopologicalIsland
 *   (islands are un-connected groups of internally-connected TopologicalNode)
 * - assigns to each TopologicalNode only one ConnectivityNodeContainer
 *   (a new unique generated container or one of the possibly many
 *   different existing ConnectivityNodeContainer (Bay, Line, Substation, VoltageLevel)
 *   of all the ConnectivityNode with the same TopologicalNode)
 * To be done eventually:
 * - create EquivalentEquipment (branch, injection, shunt) for an EquivalentNetwork
 */
class CIMNetworkTopologyProcessor (val sqlContext: SQLContext, val storage: StorageLevel) extends Serializable
{
    def get (name: String, sc: SparkContext): RDD[Element] =
    {
        val rdds = sc.getPersistentRDDs
        for (key <- rdds.keys)
        {
            val rdd = rdds (key)
            if (rdd.name == name)
                return (rdd.asInstanceOf[RDD[Element]])
        }

        return (null)
    }

    def edge_operator (arg: Tuple2[Element, Iterable[Terminal]]): List[CuttingEdge] =
    {
        var ret = List[CuttingEdge] ()

        // get the ConductingEquipment
        var equipment = arg._1
        while ((null != equipment) && !equipment.getClass ().getName ().endsWith (".ConductingEquipment"))
            equipment = equipment.sup
        if (null != equipment)
        {
            // make an array of terminals sorted by sequence number
            val terminals = arg._2.toArray.sortWith (_.ACDCTerminal.sequenceNumber < _.ACDCTerminal.sequenceNumber)
            // make an edge for each pair of terminals
            if (null != terminals(0).ConnectivityNode)  // eliminate edges without two connectivity nodes
                for (i <- 1 until terminals.length) // eliminate edges with only one terminal
                {
                    if (null != terminals(i).ConnectivityNode) // eliminate edges without two connectivity nodes
                        ret = ret :+ new CuttingEdge (
                                terminals(0).ACDCTerminal.IdentifiedObject.mRID,
                                terminals(0).ConnectivityNode,
                                terminals(i).ACDCTerminal.IdentifiedObject.mRID,
                                terminals(i).ConnectivityNode,
                                terminals(0).ConductingEquipment,
                                equipment.asInstanceOf[ConductingEquipment],
                                arg._1)
                }
        }
        //else // shouldn't happen, terminals always reference ConductingEquipment, right?
            // throw new Exception ("element " + e.id + " is not derived from ConductingEquipment")
            // ProtectionEquipment and CurrentRelay are emitted with terminals even though they shouldn't be


        return (ret)
    }

    def vertex_id (string: String): VertexId =
    {
        return (string.hashCode().asInstanceOf[VertexId])
    }

    def make_graph_edges (e: CuttingEdge): org.apache.spark.graphx.Edge[CuttingEdge] =
    {
        return (org.apache.spark.graphx.Edge (vertex_id (e.id_cn_1), vertex_id (e.id_cn_2), e))
    }

    def make_graph (sc: SparkContext): Graph[TopologicalData, CuttingEdge] =
    {
        // get the terminals keyed by equipment
        val terms = get ("Terminal", sc).asInstanceOf[RDD[Terminal]].groupBy (_.ConductingEquipment)

        // map elements with their terminal 'pairs' to edges
        val edges = get ("Elements", sc).asInstanceOf[RDD[Element]].keyBy (_.id).join (terms)
            .flatMapValues (edge_operator).values

        // construct the initial graph from the edges
        return (Graph.fromEdges[TopologicalData, CuttingEdge](edges.map (make_graph_edges), TopologicalData (), storage, storage))
    }

    def vertexProgram (id: VertexId, data: TopologicalData, message: TopologicalData): TopologicalData =
    {
        return (TopologicalData (math.min (data.island, message.island), math.min (data.label, message.label)))
    }

    // function to see if the nodes for an element are topologically connected
    def isSameNode (element: Element): Boolean =
    {
        val clazz = element.getClass.getName
        val cls = clazz.substring (clazz.lastIndexOf (".") + 1)
        val ret = cls match
        {
            case "Switch" =>
                !element.asInstanceOf[Switch].normalOpen
            case "Cut" =>
                !element.asInstanceOf[Cut].Switch.normalOpen
            case "Disconnector" =>
                !element.asInstanceOf[Disconnector].Switch.normalOpen
            case "Fuse" =>
                !element.asInstanceOf[Fuse].Switch.normalOpen
            case "GroundDisconnector" =>
                !element.asInstanceOf[GroundDisconnector].Switch.normalOpen
            case "Jumper" =>
                !element.asInstanceOf[Jumper].Switch.normalOpen
            case "ProtectedSwitch" =>
                !element.asInstanceOf[ProtectedSwitch].Switch.normalOpen
            case "Sectionaliser" =>
                !element.asInstanceOf[Sectionaliser].Switch.normalOpen
            case "Breaker" =>
                !element.asInstanceOf[Breaker].ProtectedSwitch.Switch.normalOpen
            case "LoadBreakSwitch" =>
                !element.asInstanceOf[LoadBreakSwitch].ProtectedSwitch.Switch.normalOpen
            case "Recloser" =>
                !element.asInstanceOf[Recloser].ProtectedSwitch.Switch.normalOpen
            case "PowerTransformer" =>
                false
            case "ACLineSegment" =>
                (0.0 <= element.asInstanceOf[ACLineSegment].Conductor.length) ||
                (0.0 <= element.asInstanceOf[ACLineSegment].r)
            case "Conductor" =>
                (0.0 <= element.asInstanceOf[Conductor].length)
            case _ =>
            {
                false
            }
        }

        return (ret)
    }

    def sendMessage (triplet: EdgeTriplet[TopologicalData, CuttingEdge]): Iterator[(VertexId, TopologicalData)] =
    {
        var ret:Iterator[(VertexId, TopologicalData)] = Iterator.empty

        val same = isSameNode (triplet.attr.element)
        if (triplet.srcAttr.island > triplet.dstAttr.island)
            ret = Iterator ((triplet.dstId, TopologicalData (triplet.srcAttr.island, if (same) math.min (triplet.srcAttr.label, triplet.dstAttr.label) else triplet.dstAttr.label)))
        else if (triplet.dstAttr.island > triplet.srcAttr.island)
            ret = Iterator ((triplet.srcId, TopologicalData (triplet.dstAttr.island, if (same) math.min (triplet.srcAttr.label, triplet.dstAttr.label) else triplet.srcAttr.label)))
        else if (same && triplet.srcAttr.label > triplet.dstAttr.label)
            ret = Iterator ((triplet.dstId, TopologicalData (triplet.srcAttr.island, triplet.srcAttr.label)))
        else if (same && triplet.dstAttr.label > triplet.srcAttr.label)
            ret = Iterator ((triplet.srcId, TopologicalData (triplet.dstAttr.island, triplet.dstAttr.label)))

        return (ret)
    }

    def mergeMessage (a: TopologicalData, b: TopologicalData): TopologicalData =
    {
        return (TopologicalData (math.min (a.island, b.island), math.min (a.label, b.label)))
    }

    def island_name (v: VertexId): String =
    {
        return ("topoisland_" + v.toString) // ToDo: is it legal to have dashes (minus signs) in element names
    }

    def to_islands (v: VertexId): TopologicalIsland =
    {
        return (
            TopologicalIsland
            (
                IdentifiedObject
                (
                    BasicElement
                    (
                        null,
                        island_name (v)
                    ),
                    v.toString, // aliasName: String
                    "", // description: String
                    island_name (v),  // mRID: String
                    ""  // name: String
                ),
                "" // AngleRefTopologicalNode: String
            )
        )
    }

    def node_name (v: VertexId): String =
    {
        return ("toponode_" + v.toString) // ToDo: is it legal to have dashes (minus signs) in element names
    }

    def to_nodes (arg: Tuple2[VertexId, Iterable[TopologicalData]]): TopologicalNode =
    {
        // NOTE: all of the TopologicalData should have the same island
        // val uniques = arg._2.filterNot { x => x.island == arg._2.head.island }
        // if (uniques.size != 0)
        //     println ("ah shit")
        return (
            TopologicalNode
            (
                IdentifiedObject
                (
                    BasicElement
                    (
                        null,
                        node_name (arg._1)
                    ),
                    arg._1.toString, // aliasName: String
                    "", // description: String
                    node_name (arg._1),  // mRID: String
                    ""  // name: String
                ),
                0.0, // pInjection: Double,
                0.0, // qInjection: Double,
                "", // AngleRefTopologicalIsland: String,
                "", // BaseVoltage: String,
                "", // ConnectivityNodeContainer: String,
                "", // ReportingGroup: String,
                "", // SvInjection: String,
                "", // SvVoltage: String,
                island_name (arg._2.head.island)  // TopologicalIsland: String
            )
        )
    }

    def update_cn (arg: Tuple2[VertexId, Tuple2[ConnectivityNode,Option[TopologicalNode]]]): ConnectivityNode =
    {
        return (
            ConnectivityNode
            (
                arg._2._1.sup,
                arg._2._1.ConnectivityNodeContainer,
                arg._2._2 match
                {
                    case Some (node) => node.id
                    case None => ""
                }
            )
        )
    }

    def process (): Unit =
    {
        // get the initial graph based on edges
        val initial = make_graph (sqlContext.sparkContext)

        // traverse the graph with the Pregel algorithm
        // assigns the minimum VertexId of all:
        // - connected nodes (island)
        // - electrically identical nodes (label)
        // Note: on the first pass through the Pregel algorithm all nodes get a maximum message (TopologicalData (Long.MaxValue, Long.MaxValue))
        val graph = initial.pregel[TopologicalData] (TopologicalData (), 10000, EdgeDirection.Either) (vertexProgram, sendMessage, mergeMessage)

        // create TopologicalIsland RDD
        val islands = graph.vertices.map (_._2.island).distinct.map (to_islands)
        islands.name = "TopologicalIsland"
        islands.persist (storage)
        sqlContext.createDataFrame (islands).registerTempTable ("TopologicalIsland")

        // create TopologicalNode RDD
        val nodes = graph.vertices.map (_._2).groupBy (_.label).map (to_nodes) // ToDo: is there a  better way than GroupBy?
        nodes.name = "TopologicalNode"
        nodes.persist (storage)
        sqlContext.createDataFrame (nodes).registerTempTable ("TopologicalNode")

        // assign every ConnectivtyNode to a TopologicalNode
        val old_cn = get ("ConnectivityNode", sqlContext.sparkContext).asInstanceOf[RDD[ConnectivityNode]]
        val new_cn = old_cn.keyBy (a => vertex_id (a.id)).leftOuterJoin (nodes.keyBy (_.IdentifiedObject.aliasName.toLong)).map (update_cn)

        // swap the old RDD for the new one

        old_cn.name = "trash_connectivitynode"
        old_cn.unpersist (false)
        new_cn.name = "ConnectivityNode"
        new_cn.persist (storage)
        sqlContext.createDataFrame (new_cn).registerTempTable ("ConnectivityNode")

        // ToDo: assign every Terminal to a TopologicalNode
    }
}
