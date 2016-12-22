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
import org.slf4j.LoggerFactory
import org.apache.spark.SparkContext

import org.apache.spark.sql.types.Element
import ch.ninecode.model._

case class CuttingEdge (id_seq_1: String, id_cn_1: String, id_seq_2: String, id_cn_2: String, id_equ: String, equipment: ConductingEquipment, element: Element) extends Serializable
/**
 * island is min of all connected ConnectivityNode ( single topological island)
 * node is min of equivalent ConnectivityNode (a single topological node)
 * label is a user freindly label
 */
case class TopologicalData (var island: VertexId = Long.MaxValue, var island_label: String = "", var node: VertexId = Long.MaxValue, var node_label: String = "") extends Serializable
{
    def name: String =
    {
        if (node_label.endsWith ("_node_fuse"))
            node_label.substring (0, node_label.length - "_node_fuse".length) + "_topo_fuse"
        else if (node_label.endsWith ("_node"))
            node_label.substring (0, node_label.length - "_node".length) + "_topo"
        else
            node_label + "_topo"
    }

    def island_name: String =
    {
        if (0 == island)
            ""
        else
            if (island_label.endsWith ("_node_fuse"))
                island_label.substring (0, island_label.length - "_node_fuse".length) + "_island_fuse"
            else if (island_label.endsWith ("_node"))
                island_label.substring (0, island_label.length - "_node".length) + "_island"
            else
                island_label + "_island"
    }
}

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
    private val log = LoggerFactory.getLogger(getClass)
    
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

    def to_vertex (n: ConnectivityNode): TopologicalData =
    {
        val id = vertex_id (n.id)
        TopologicalData (0.asInstanceOf[VertexId], "", id, n.id)
    }

    def make_graph (sc: SparkContext): Graph[TopologicalData, CuttingEdge] =
    {
        // get the terminals keyed by equipment
        val terms = get ("Terminal", sc).asInstanceOf[RDD[Terminal]].groupBy (_.ConductingEquipment)

        // map elements with their terminal 'pairs' to edges
        val elements = get ("Elements", sc).asInstanceOf[RDD[Element]].keyBy (_.id).join (terms)
            .flatMapValues (edge_operator).values

        // get the vertices
        val vertices = get ("ConnectivityNode", sc).asInstanceOf[RDD[ConnectivityNode]].map (to_vertex).keyBy (_.node)

        // get the edges
        val edges = elements.map (make_graph_edges)

        // construct the initial graph from the edges
        val ret = Graph.apply[TopologicalData, CuttingEdge](vertices, edges, TopologicalData (), storage, storage)

        // persist the RDD to avoid recomputation
        ret.vertices.persist (storage)
        ret.edges.persist (storage)

        return (ret)
    }

    def identifyNodes (graph: Graph[TopologicalData, CuttingEdge]): Graph[TopologicalData, CuttingEdge] =
    {
        def vertex_program (id: VertexId, data: TopologicalData, message: TopologicalData): TopologicalData =
        {
            if (null != message) // not initialization call?
                if (data.node > message.node)
                {
                    data.node = message.node
                    data.node_label = message.node_label
                }

            return (data)
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
                    val line = element.asInstanceOf[ACLineSegment]
                    val nonzero = ((line.Conductor.len > 0.0) && ((line.r > 0.0) || (line.x > 0.0)))
                    //println ("ACLineSegment " + element.id + " " + line.Conductor.len + "m " + line.r + "+" + line.x + "jΩ/km " + !nonzero)
                    !nonzero
                case "Conductor" =>
                    true
                case _ =>
                {
                    false
                }
            }

            return (ret)
        }

        def send_message (triplet: EdgeTriplet[TopologicalData, CuttingEdge]): Iterator[(VertexId, TopologicalData)] =
        {
            val same = isSameNode (triplet.attr.element) // true if these should be the same TopologicalNode
            if (!same)
                Iterator.empty // send no message across a topological boundary
            else
                if (triplet.srcAttr.node < triplet.dstAttr.node)
                    Iterator ((triplet.dstId, triplet.srcAttr))
                else if (triplet.srcAttr.node > triplet.dstAttr.node)
                    Iterator ((triplet.srcId, triplet.dstAttr))
                else
                    Iterator.empty
        }

        def merge_message (a: TopologicalData, b: TopologicalData): TopologicalData =
        {
            if (a.node <= b.node)
                a
            else
                b
        }

        // traverse the graph with the Pregel algorithm
        // assigns the minimum VertexId of all electrically identical nodes (node)
        // Note: on the first pass through the Pregel algorithm all nodes get a null message
        return (graph.pregel[TopologicalData] (null, 10000, EdgeDirection.Either) (vertex_program, send_message, merge_message))
    }

    def to_islands (nodes: Iterable[TopologicalData]): TopologicalIsland =
    {
        val name = nodes.head.island_name
        val alias = nodes.head.island.toString
        return (
            TopologicalIsland
            (
                IdentifiedObject
                (
                    BasicElement
                    (
                        null,
                        name
                    ),
                    alias, // aliasName: String
                    "", // description: String
                    name,  // mRID: String
                    ""  // name: String
                ),
                "" // AngleRefTopologicalNode: String
            )
        )
    }

    def to_nodes (arg: Tuple2[VertexId, Iterable[TopologicalData]]): TopologicalNode =
    {
        val name = arg._2.head.name
        return (
            TopologicalNode
            (
                IdentifiedObject
                (
                    BasicElement
                    (
                        null,
                        name
                    ),
                    arg._1.toString, // aliasName: String
                    "", // description: String
                    name,  // mRID: String
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
                arg._2.head.island_name  // TopologicalIsland: String
            )
        )
    }

    def update_cn (arg: Tuple2[VertexId, Tuple2[ConnectivityNode,Option[TopologicalData]]]): ConnectivityNode =
    {
        return (
            ConnectivityNode
            (
                arg._2._1.sup,
                arg._2._1.ConnectivityNodeContainer,
                arg._2._2 match
                {
                    case Some (node) => node.name
                    case None => ""
                }
            )
        )
    }

    def update_terminals (arg: Tuple2[VertexId, Tuple2[Terminal,Option[TopologicalData]]]): Terminal =
    {
        return (
            Terminal
            (
                arg._2._1.sup,
                arg._2._1.phases,
                arg._2._1.Bushing,
                arg._2._1.ConductingEquipment,
                arg._2._1.ConnectivityNode,
                arg._2._1.SvPowerFlow,
                arg._2._2 match
                {
                    case Some (node) => node.name
                    case None => ""
                }
            )
        )
    }

    def identifyIslands (graph: Graph[TopologicalData, CuttingEdge]): Graph[TopologicalData, CuttingEdge] =
    {
        def vertex_program (id: VertexId, attr: TopologicalData, msg: TopologicalData): TopologicalData =
        {
            if (null == msg)
            {
                // initially assign each node to it's own island
                attr.island = attr.node
                attr.island_label = attr.node_label
            }
            else
                if (attr.island > msg.island)
                {
                    attr.island = msg.island
                    attr.island_label = msg.island_label
                }

            attr
        }

        // function to see if the nodes for an element are topologically connected
        def isSameIsland (element: Element): Boolean =
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
                    true
                case "Conductor" =>
                    true
                case _ =>
                {
                    false
                }
            }

            return (ret)
        }

        def send_message (triplet: EdgeTriplet[TopologicalData, CuttingEdge]): Iterator[(VertexId, TopologicalData)] =
        {
            val same = isSameIsland (triplet.attr.element) // true if these should be the same TopologicalIsland
            if (!same)
                Iterator.empty // send no message across a topological boundary
            else
                if (triplet.srcAttr.island < triplet.dstAttr.island)
                    Iterator ((triplet.dstId, triplet.srcAttr))
                else if (triplet.srcAttr.island > triplet.dstAttr.island)
                    Iterator ((triplet.srcId, triplet.dstAttr))
                else
                    Iterator.empty
        }

        def merge_message (a: TopologicalData, b: TopologicalData): TopologicalData =
        {
            if (a.island < b.island)
                a
            else
                b
        }

        def boundary (edge: Tuple3[org.apache.spark.graphx.Edge[CuttingEdge], TopologicalData, TopologicalData]): Boolean =
        {
            val end1 = edge._2
            val end2 = edge._3
            end1.node != end2.node
        }

        def make_graph_edges (edge: Tuple3[org.apache.spark.graphx.Edge[CuttingEdge], TopologicalData, TopologicalData]): org.apache.spark.graphx.Edge[CuttingEdge] =
        {
            return (org.apache.spark.graphx.Edge (edge._2.node, edge._3.node, edge._1.attr))
        }

        def update_vertices (id: VertexId, vertex: TopologicalData, island: Option[TopologicalData]): TopologicalData =
        {
            island match
            {
                case Some (data: TopologicalData) =>
                    vertex.island = data.island
                    vertex.island_label = data.island_label
                case None => // should never happen
                    // ToDo: log warning
            }

            return (vertex)
        }

        def mapper (d: Tuple2[VertexId, Tuple2[Tuple2[VertexId, TopologicalData], Option[TopologicalData]]]): Tuple2[VertexId, TopologicalData] =
        {
            val td = d._2._2 match
            {
                case Some (data: TopologicalData) =>
                    data
                case None => // this will happen if no edges are connected to a node, use the "no-island" default
                    d._2._1._2
            }
            return (( d._2._1._1, td))
        }

        // get the edges that have different topological nodes on each end
        val nodes = graph.vertices.values.keyBy (_.node).distinct // distinct topological nodes
        val pairs = graph.vertices.keyBy (_._2.node).join (nodes).map ( x => (x._2._1._1, x._2._2)) // get vertex-node pairs
        val b1 = graph.edges.keyBy ((edge) => edge.dstId).join (pairs) // match edge end 1
        val b2 = b1.values.keyBy ((edge) => edge._1.srcId).join (pairs) // match edge end 2
        val b3 = b2.values.map ((edge) => (edge._1._1, edge._1._2, edge._2)) // simplify
        val boundaries = b3.filter (boundary) // keep edges with different nodes on each end

        // construct the topological graph from the edges
        val edges = boundaries.map (make_graph_edges)
        val vertices = boundaries.map (_._2).union (boundaries.map (_._3)).distinct.keyBy (_.node)
        val topo_graph = Graph.apply[TopologicalData, CuttingEdge](vertices, edges, TopologicalData (), storage, storage)

        // run the pregel algorithm over the reduced topological graph
        val g = topo_graph.pregel[TopologicalData] (null, 10000, activeDirection = EdgeDirection.Either) (vertex_program, send_message, merge_message)

        // update the original graph with the islands
        val v = graph.vertices.keyBy (_._2.node).leftOuterJoin (g.vertices.values.keyBy (_.node)).map (mapper)

        return (graph.outerJoinVertices (v) (update_vertices))
    }

    def process (identify_islands: Boolean): Unit =
    {
        // get the initial graph based on edges
        val initial = make_graph (sqlContext.sparkContext)

        // get the topological nodes
        log.info ("identifyNodes")
        var graph = identifyNodes (initial)

        // persist the RDD to avoid recomputation
        graph.vertices.persist (storage)
        graph.edges.persist (storage)

        if (identify_islands)
        {
            // get the topological islands
            log.info ("identifyIslands")
            graph = identifyIslands (graph)

            // persist the RDD to avoid recomputation
            graph.vertices.persist (storage)
            graph.edges.persist (storage)

            // create TopologicalIsland RDD
            log.info ("islands")
            val islands = graph.vertices.values.filter (_.island != 0L).groupBy (_.island).values.map (to_islands)
            get ("TopologicalIsland", sqlContext.sparkContext).asInstanceOf[RDD[TopologicalIsland]].unpersist (false)
            islands.name = "TopologicalIsland"
            islands.persist (storage)
            sqlContext.createDataFrame (islands).createOrReplaceTempView ("TopologicalIsland")
        }

        // create TopologicalNode RDD
        log.info ("nodes")
        val nodes = graph.vertices.map (_._2).groupBy (_.node).map (to_nodes) // ToDo: is there a  better way than GroupBy?
        get ("TopologicalNode", sqlContext.sparkContext).asInstanceOf[RDD[TopologicalNode]].unpersist (false)
        nodes.name = "TopologicalNode"
        val stuff = nodes.persist (storage)
        sqlContext.createDataFrame (nodes).createOrReplaceTempView ("TopologicalNode")

        // assign every ConnectivtyNode to a TopologicalNode
        val old_cn = get ("ConnectivityNode", sqlContext.sparkContext).asInstanceOf[RDD[ConnectivityNode]]
        val new_cn = old_cn.keyBy (a => vertex_id (a.id)).leftOuterJoin (graph.vertices).map (update_cn)

        // swap the old RDD for the new one
        old_cn.unpersist (false)
        new_cn.name = "ConnectivityNode"
        new_cn.persist (storage)
        sqlContext.createDataFrame (new_cn).createOrReplaceTempView ("ConnectivityNode")

        // assign every Terminal to a TopologicalNode
        val old_terminals = get ("Terminal", sqlContext.sparkContext).asInstanceOf[RDD[Terminal]]
        val new_terminals = old_terminals.filter (null != _.ConnectivityNode).keyBy (a => vertex_id (a.ConnectivityNode)).leftOuterJoin (graph.vertices).map (update_terminals)

        // swap the old RDD for the new one
        old_terminals.unpersist (false)
        new_terminals.name = "Terminal"
        new_terminals.persist (storage)
        sqlContext.createDataFrame (new_terminals).createOrReplaceTempView ("Terminal")
    }
}
