package ch.ninecode.cim

import org.apache.spark.graphx.Edge
import org.apache.spark.graphx.EdgeDirection
import org.apache.spark.graphx.EdgeTriplet
import org.apache.spark.graphx.Graph
import org.apache.spark.graphx.Graph.graphToGraphOps
import org.apache.spark.graphx.VertexId
import org.apache.spark.rdd.RDD
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.SQLUserDefinedType
import org.apache.spark.storage.StorageLevel
import org.slf4j.LoggerFactory


import ch.ninecode.model._

case class CuttingEdge (
    id_seq_1: String,
    id_cn_1: String,
    id_seq_2: String,
    id_cn_2: String,
    id_equ: String,
    isZero: Boolean,
    isConnected: Boolean) extends Serializable

/**
 * island is min of all connected ConnectivityNode ( single topological island)
 * node is min of equivalent ConnectivityNode (a single topological node)
 * label is a user friendly label
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
}

/**
 * Create a topology.
 * Create TopologicalNode and TopologicalIsland RDD.
 * Based on ConnectivityNode elements and connecting edges, find the topology that has:
 * - each substation has a single bus (TopologicalNode) at each nominal voltage level
 *   for each set of BusbarSection that are connected by closed switches
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
class CIMNetworkTopologyProcessor (session: SparkSession, storage: StorageLevel) extends Serializable
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

    // function to see if the nodes for an element are topologically connected
    def isSameNode (element: Element): Boolean =
    {
        val clazz = element.getClass.getName
        val cls = clazz.substring (clazz.lastIndexOf (".") + 1)
        cls match
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
                // log.debug ("ACLineSegment " + element.id + " " + line.Conductor.len + "m " + line.r + "+" + line.x + "jΩ/km " + !nonzero)
                !nonzero
            case "Conductor" =>
                true
            case _ =>
            {
                log.warn ("topological node processor encountered edge with unhandled class '" + cls +"', assumed conducting")
                true
            }
        }
    }

    // function to see if the nodes for an element are topologically connected
    def isSameIsland (element: Element): Boolean =
    {
        val clazz = element.getClass.getName
        val cls = clazz.substring (clazz.lastIndexOf (".") + 1)
        cls match
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
                log.warn ("topological island processor encountered edge with unhandled class '" + cls +"', assumed conducting")
                true
            }
        }
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
            val terminals = arg._2.toArray.sortBy (_.ACDCTerminal.sequenceNumber)
            // make an edge for each pair of terminals
            if (null != terminals(0).ConnectivityNode)  // eliminate edges without two connectivity nodes
                for (i <- 1 until terminals.length) // eliminate edges with only one terminal
                {
                    // check if this edge connects its nodes
                    val identical = isSameNode (arg._1)
                    // check if this edge has its nodes in the same island
                    val connected = isSameIsland (arg._1)
                    if (null != terminals(i).ConnectivityNode) // eliminate edges without two connectivity nodes
                        ret = ret :+ new CuttingEdge (
                                terminals(0).ACDCTerminal.IdentifiedObject.mRID,
                                terminals(0).ConnectivityNode,
                                terminals(i).ACDCTerminal.IdentifiedObject.mRID,
                                terminals(i).ConnectivityNode,
                                terminals(0).ConductingEquipment,
                                identical,
                                connected)
                }
        }
        //else // shouldn't happen, terminals always reference ConductingEquipment, right?
            // throw new Exception ("element " + e.id + " is not derived from ConductingEquipment")
            // ProtectionEquipment and CurrentRelay are emitted with terminals even though they shouldn't be


        return (ret)
    }

    def vertex_id (string: String): VertexId = {
        var h = 2166136261l;
        for (c ← string)
            h = (h * 16777619) ^ c
        h.asInstanceOf[VertexId]    
    }

    def make_graph_edges (e: CuttingEdge): Edge[CuttingEdge] = Edge (vertex_id (e.id_cn_1), vertex_id (e.id_cn_2), e)

    def to_vertex (n: ConnectivityNode): (VertexId, TopologicalData) =
    {
        val v = vertex_id (n.id)
        (v, TopologicalData (0.asInstanceOf[VertexId], "", v, n.id))
    }

    def make_graph (): Graph[TopologicalData, CuttingEdge] =
    {
        // get the terminals keyed by equipment
        val terms = get ("Terminal").asInstanceOf[RDD[Terminal]].groupBy (_.ConductingEquipment)

        // map elements with their terminal 'pairs' to edges
        val edges = get ("Elements").asInstanceOf[RDD[Element]].keyBy (_.id).join (terms)
            .flatMapValues (edge_operator).values.map (make_graph_edges)

        // get the vertices
        val vertices = get ("ConnectivityNode").asInstanceOf[RDD[ConnectivityNode]].map (to_vertex)

        // construct the initial graph from the edges
        Graph.apply (vertices, edges, TopologicalData (), storage, storage).cache
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

        def send_message (triplet: EdgeTriplet[TopologicalData, CuttingEdge]): Iterator[(VertexId, TopologicalData)] =
        {
            if (!triplet.attr.isZero)
                Iterator.empty // send no message across a topological boundary
            else
                if (triplet.srcAttr.node < triplet.dstAttr.node)
                    Iterator ((triplet.dstId, triplet.srcAttr))
                else if (triplet.srcAttr.node > triplet.dstAttr.node)
                    Iterator ((triplet.srcId, triplet.dstAttr))
                else
                    Iterator.empty
        }

        def merge_message (a: TopologicalData, b: TopologicalData): TopologicalData = if (a.node <= b.node) a else b

        // traverse the graph with the Pregel algorithm
        // assigns the minimum VertexId of all electrically identical nodes (node)
        // Note: on the first pass through the Pregel algorithm all nodes get a null message
        graph.pregel[TopologicalData] (null, 10000, EdgeDirection.Either) (vertex_program, send_message, merge_message).cache
    }

    def to_islands (nodes: Iterable[Tuple2[Tuple2[TopologicalData,ConnectivityNode],Option[Tuple2[Terminal, Element]]]]): Tuple2[VertexId, TopologicalIsland] =
    {
        def op (current: Tuple2[List[Terminal],ConnectivityNode], data: Tuple2[Tuple2[TopologicalData,ConnectivityNode],Option[Tuple2[Terminal, Element]]]): Tuple2[List[Terminal],ConnectivityNode] =
        {
            val ret =
                data._2 match
                {
                    case Some ((terminal, element)) =>
                        // get the alphabetically least connectivity node name as a fall-back
                        val cn = data._1._2
                        val best = if (null == current._2) cn else if (cn.id < current._2.id) cn else current._2
                        // get the transformer secondary terminal
                        val clazz = element.getClass.getName
                        val cls = clazz.substring (clazz.lastIndexOf (".") + 1)
                        cls match
                        {
                            case "PowerTransformer" =>
                                if (terminal.ACDCTerminal.sequenceNumber > 1)
                                    (current._1 :+ terminal, cn)
                                else
                                    (current._1, best)
                            case _ =>
                                (current._1, best)
                        }
                    case None =>
                        current
                }
            return (ret)
        }
        val (lv_terminals, cn) = nodes.foldLeft (Tuple2[List[Terminal],ConnectivityNode](List[Terminal](), null))(op)
        // based on how many transformer terminals there are, construct a suitable name
        def trafos (l: List[Terminal]): String = l.map (_.ConductingEquipment).mkString ("_")
        val terminals = lv_terminals.sortBy (_.id)
        val base =
            terminals match
            {
                case t1 :: Nil =>
                    t1.id
                case t1 :: tail =>
                    trafos (terminals) + "_terminal_" + t1.ACDCTerminal.sequenceNumber
                case _ =>
                    cn.id
            }
        val name = base + "_topo"
        val island = nodes.head._1._1.island
        return (
            (
                island,
                TopologicalIsland
                (
                    IdentifiedObject
                    (
                        BasicElement
                        (
                            null,
                            name
                        ),
                        cn.IdentifiedObject.aliasName, // aliasName: String
                        cn.IdentifiedObject.description, // description: String
                        name,  // mRID: String
                        cn.id  // name: String
                    ),
                    "" // AngleRefTopologicalNode: String
                )
            )
        )
    }

    def to_nodes (arg: Tuple3[VertexId, TopologicalData, Option[TopologicalIsland]]): TopologicalNode =
    {
        val name = arg._2.name
        val island = arg._3 match
        {
            case Some (i) =>
                i.id
            case _ =>
                ""
        }
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
                island  // TopologicalIsland: String
            )
        )
    }

    def update_cn (arg: Tuple2[VertexId, Tuple2[ConnectivityNode,Option[TopologicalData]]]): ConnectivityNode =
    {
        val c = arg._2._1
        arg._2._2 match
        {
            case Some (node) =>
                ConnectivityNode (
                    c.IdentifiedObject.copy ().asInstanceOf[IdentifiedObject],
                    c.ConnectivityNodeContainer,
                    node.name
                )
            case None => c
        }
    }

    def update_terminals (arg: Tuple2[VertexId, Tuple2[Terminal,Option[TopologicalData]]]): Terminal =
    {
        val t = arg._2._1
        val a = t.ACDCTerminal
        arg._2._2 match
        {
            case Some (node) =>
                val id = a.IdentifiedObject.copy ().asInstanceOf[IdentifiedObject]
                val acdc = ACDCTerminal (id, a.connected, a.sequenceNumber, a.BusNameMarker)
                Terminal (
                    acdc,
                    t.phases,
                    t.Bushing,
                    t.ConductingEquipment,
                    t.ConnectivityNode,
                    t.SvPowerFlow,
                    node.name
                )
            case None => t
        }
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

        def send_message (triplet: EdgeTriplet[TopologicalData, CuttingEdge]): Iterator[(VertexId, TopologicalData)] =
        {
            if (!triplet.attr.isConnected)
                Iterator.empty // send no message across a topological boundary
            else
                if (triplet.srcAttr.island < triplet.dstAttr.island)
                    Iterator ((triplet.dstId, triplet.srcAttr))
                else if (triplet.srcAttr.island > triplet.dstAttr.island)
                    Iterator ((triplet.srcId, triplet.dstAttr))
                else
                    Iterator.empty
        }

        def merge_message (a: TopologicalData, b: TopologicalData): TopologicalData = if (a.island < b.island) a else b

        def boundary (edge: Tuple3[Edge[CuttingEdge], TopologicalData, TopologicalData]): Boolean = edge._2.node != edge._3.node

        def make_graph_edges (edge: Tuple3[Edge[CuttingEdge], TopologicalData, TopologicalData]): Edge[CuttingEdge] =
            Edge (edge._2.node, edge._3.node, edge._1.attr)

        def update_vertices (id: VertexId, vertex: TopologicalData, island: Option[TopologicalData]): TopologicalData =
        {
            island match
            {
                case Some (data: TopologicalData) =>
                    vertex.island = data.island
                    vertex.island_label = data.island_label
                case None => // should never happen
                    log.warn ("update vertices skipping vertex with no associated island")
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

        // run the Pregel algorithm over the reduced topological graph
        val g = topo_graph.pregel[TopologicalData] (null, 10000, EdgeDirection.Either) (vertex_program, send_message, merge_message)

        // update the original graph with the islands
        val v = graph.vertices.keyBy (_._2.node).leftOuterJoin (g.vertices.values.keyBy (_.node)).map (mapper)

        val ret = graph.outerJoinVertices (v) (update_vertices)

        // persist the RDD to avoid recomputation
        ret.vertices.persist (storage)
        ret.edges.persist (storage)

        return (ret)
    }

    def process (identify_islands: Boolean): RDD[Element] =
    {
        // get the initial graph based on edges
        val initial = make_graph ()

        // get the topological nodes
        log.info ("identifyNodes")
        var graph = identifyNodes (initial)

        // create a new TopologicalNode RDD
        val new_tn = if (identify_islands)
        {
            // get the topological islands
            log.info ("identifyIslands")
            graph = identifyIslands (graph)

            log.info ("islands")
            // get the terminals keyed by equipment with equipment
            val elements = get ("Elements").asInstanceOf[RDD[Element]].keyBy (_.id)
            val terms = get ("Terminal").asInstanceOf[RDD[Terminal]].keyBy (_.ConductingEquipment).join (elements).values
            // map each graph vertex to the terminals
            val vertices = get ("ConnectivityNode").asInstanceOf[RDD[ConnectivityNode]].map ((x) => (vertex_id (x.id), x))
            val td_plus = graph.vertices.join (vertices).values.filter (_._1.island != 0L).keyBy (_._2.id).leftOuterJoin (terms.keyBy (_._1.ConnectivityNode)).values
            val islands = td_plus.groupBy (_._1._1.island).values.map (to_islands)

            // create a new TopologicalIsland RDD
            val old_ti = get ("TopologicalIsland").asInstanceOf[RDD[TopologicalIsland]]
            val new_ti = islands.values

            // swap the old TopologicalIsland RDD for the new one
            if (null != old_ti)
            {
                old_ti.unpersist (false)
                old_ti.name = null
            }
            new_ti.name = "TopologicalIsland"
            new_ti.persist (storage)
            session.sparkContext.getCheckpointDir match
            {
                case Some (dir) => new_ti.checkpoint ()
                case None =>
            }
            session.createDataFrame (new_ti).createOrReplaceTempView ("TopologicalIsland")

            val nodes_with_islands = graph.vertices.values.keyBy (_.island).join (islands).values
            nodes_with_islands.groupBy (_._1.node).map ((x) => (x._1, x._2.head._1, Some (x._2.head._2))).map (to_nodes)
        }
        else
            graph.vertices.values.groupBy (_.node).map ((x) => (x._1, x._2.head, None)).map (to_nodes)

        // swap the old TopologicalNode RDD for the new one
        val old_tn = get ("TopologicalNode").asInstanceOf[RDD[TopologicalNode]]
        if (null != old_tn)
        {
            old_tn.unpersist (false)
            old_tn.name = null
        }
        new_tn.name = "TopologicalNode"
        new_tn.persist (storage)
        session.sparkContext.getCheckpointDir match
        {
            case Some (dir) => new_tn.checkpoint ()
            case None =>
        }
        session.createDataFrame (new_tn).createOrReplaceTempView ("TopologicalNode")

        // assume the old TopologicalIsland and TopologicalNode RDD were empty
        // but the other RDD (ConnectivityNode and Terminal also ACDCTerminal) need to be updated in IdentifiedObject and Element

        // assign every ConnectivtyNode to a TopologicalNode
        val old_cn = get ("ConnectivityNode").asInstanceOf[RDD[ConnectivityNode]]
        val new_cn = old_cn.keyBy (a => vertex_id (a.id)).leftOuterJoin (graph.vertices).map (update_cn)

        // swap the old ConnectivityNode RDD for the new one
        old_cn.name = null
        new_cn.name = "ConnectivityNode"
        new_cn.persist (storage)
        session.sparkContext.getCheckpointDir match
        {
            case Some (dir) => new_cn.checkpoint ()
            case None =>
        }
        session.createDataFrame (new_cn).createOrReplaceTempView ("ConnectivityNode")

        // assign every Terminal to a TopologicalNode
        val old_terminals = get ("Terminal").asInstanceOf[RDD[Terminal]]
        val new_terminals = old_terminals.filter (null != _.ConnectivityNode).keyBy (a => vertex_id (a.ConnectivityNode)).leftOuterJoin (graph.vertices).map (update_terminals)

        // replace terminals in Terminal
        val new_term = old_terminals.keyBy (_.id).leftOuterJoin (new_terminals.keyBy (_.id)).
            values.flatMap (
                (arg: Tuple2[Terminal, Option[Terminal]]) =>
                    arg._2 match
                     {
                        case Some (x) => List(x)
                        case None => List (arg._1)
                     }
                )

        // swap the old Terminal RDD for the new one
        old_terminals.name = null
        new_term.name = "Terminal"
        new_term.persist (storage)
        session.sparkContext.getCheckpointDir match
        {
            case Some (dir) => new_term.checkpoint ()
            case None =>
        }
        session.createDataFrame (new_term).createOrReplaceTempView ("Terminal")

        // replace terminals in ACDCTerminal
        val old_acdc_term = get ("ACDCTerminal").asInstanceOf[RDD[ACDCTerminal]]
        val new_acdc_term = old_acdc_term.keyBy (_.id).leftOuterJoin (new_terminals.map (_.ACDCTerminal).keyBy (_.id)).
            values.flatMap (
                (arg: Tuple2[ACDCTerminal, Option[ACDCTerminal]]) =>
                    arg._2 match
                    {
                        case Some (x) => List(x)
                        case None => List (arg._1)
                    }
                )

        // swap the old ACDCTerminal RDD for the new one
        old_acdc_term.name = null
        new_acdc_term.name = "ACDCTerminal"
        new_acdc_term.persist (storage)
        session.sparkContext.getCheckpointDir match
        {
            case Some (dir) => new_acdc_term.checkpoint ()
            case None =>
        }
        session.createDataFrame (new_acdc_term).createOrReplaceTempView ("ACDCTerminal")

        // make a union of all new RDD as IdentifiedObject
        val idobj = get ("TopologicalIsland").asInstanceOf[RDD[TopologicalIsland]].map (_.IdentifiedObject).
            union (new_tn.map (_.IdentifiedObject)).
            union (new_cn.map (_.IdentifiedObject)).
            union (new_acdc_term.map (_.IdentifiedObject))

        // replace identified objects in IdentifiedObject
        val old_idobj = get ("IdentifiedObject").asInstanceOf[RDD[IdentifiedObject]]
        val new_idobj = old_idobj.keyBy (_.id).leftOuterJoin (idobj.keyBy (_.id)).
            values.flatMap (
                (arg: Tuple2[IdentifiedObject, Option[IdentifiedObject]]) =>
                    arg._2 match
                    {
                        case Some (x) => List(x)
                        case None => List (arg._1)
                    }
                )

        // swap the old IdentifiedObject RDD for the new one
        old_idobj.name = null
        new_idobj.name = "IdentifiedObject"
        new_idobj.persist (storage)
        session.sparkContext.getCheckpointDir match
        {
            case Some (dir) => new_idobj.checkpoint ()
            case None =>
        }
        session.createDataFrame (new_idobj).createOrReplaceTempView ("IdentifiedObject")

        // make a union of all new RDD as Element
        val newelem = get ("TopologicalIsland").
            union (new_tn.asInstanceOf[RDD[Element]]).
            union (new_cn.asInstanceOf[RDD[Element]]).
            union (new_acdc_term.asInstanceOf[RDD[Element]])

        // replace elements in Elements
        val old_elements = get ("Elements")
        val new_elements = old_elements.keyBy (_.id).leftOuterJoin (newelem.keyBy (_.id)).
            values.flatMap (
                (arg: Tuple2[Element, Option[Element]]) =>
                    arg._2 match
                    {
                        case Some (x) => List(x)
                        case None => List (arg._1)
                    }
                )

        // swap the old Elements RDD for the new one
        old_elements.name = null
        new_elements.name = "Elements"
        new_elements.persist (storage)
        session.sparkContext.getCheckpointDir match
        {
            case Some (dir) => new_elements.checkpoint ()
            case None =>
        }

        new_elements
    }
}
