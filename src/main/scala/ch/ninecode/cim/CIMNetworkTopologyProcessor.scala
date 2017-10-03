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
import org.apache.spark.storage.StorageLevel
import org.slf4j.LoggerFactory
import org.slf4j.Logger

import ch.ninecode.model._

/**
 * Create a topology.
 *
 * Create TopologicalNode and optionally TopologicalIsland RDD that encode the
 * connections between electrical elements.
 *
 * Based on ConnectivityNode elements and connecting edges, find the topology that has:
 *
 - each substation has a single bus (TopologicalNode) at each nominal voltage level
   for each set of BusbarSection that are connected by closed switches
 - eliminates switches based on their open/closed state
 - assigns each ConnectivityNode to exactly one TopologicalNode
 - assigns each TopologicalNode to exactly one TopologicalIsland
   (islands are un-connected groups of internally-connected TopologicalNode)
 - assigns to each TopologicalNode only one ConnectivityNodeContainer
   (a new unique generated container or one of the possibly many
   different existing ConnectivityNodeContainer (Bay, Line, Substation, VoltageLevel)
   of all the ConnectivityNode with the same TopologicalNode)
 *
 * To be done eventually:
 *
 - create EquivalentEquipment (branch, injection, shunt) for an EquivalentNetwork
 *
 * @param spark The session with CIM RDD defined, for which the topology should be calculated
 * @param storage The storage level for new and replaced CIM RDD.
 * @param debug Adds additional tests during topology processing:
 *
 - unique VertexId for every ConnectivityNode mRID (checks the hash function)
 - all edges reference existing ConnectivityNode elements (checks for completeness)
 - no voltage transitions (checks that edges that are joined have the same BaseVoltage)
 *
 */
class CIMNetworkTopologyProcessor (spark: SparkSession, storage: StorageLevel = StorageLevel.MEMORY_AND_DISK_SER, debug: Boolean = false) extends CIMRDD with Serializable
{
    private implicit val session: SparkSession = spark
    private implicit val log: Logger = LoggerFactory.getLogger(getClass)

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
                val nonzero = (line.Conductor.len > 0.0) && ((line.r > 0.0) || (line.x > 0.0))
                // log.debug ("ACLineSegment " + element.id + " " + line.Conductor.len + "m " + line.r + "+" + line.x + "jΩ/km " + !nonzero)
                !nonzero
            case "Conductor" =>
                true
            case _ =>
                log.warn ("topological node processor encountered edge with unhandled class '" + cls +"', assumed zero impedance")
                true
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
                log.warn ("topological island processor encountered edge with unhandled class '" + cls +"', assumed conducting")
                true
        }
    }

    def edge_operator (arg: (Element, Iterable[Terminal])): List[CIMEdgeData] =
    {
        var ret = List[CIMEdgeData] ()

        // get the ConductingEquipment
        var equipment = arg._1
        while ((null != equipment) && !equipment.getClass.getName.endsWith (".ConductingEquipment"))
            equipment = equipment.sup
        if (null != equipment)
        {
            // make an array of terminals sorted by sequence number
            val terminals = arg._2.filter (x ⇒ (null != x.ConnectivityNode) && ("" != x.ConnectivityNode)).toArray.sortBy (_.ACDCTerminal.sequenceNumber)
            // make an edge for each pair of terminals
            if (terminals.length >= 2) // eliminate edges without two connectivity nodes
                for (i <- 1 until terminals.length) // eliminate edges with only one terminal
                {
                    // check if this edge connects its nodes
                    val identical = isSameNode (arg._1)
                    // check if this edge has its nodes in the same island
                    val connected = isSameIsland (arg._1)
                    ret = ret :+ CIMEdgeData (
                            terminals(0).ACDCTerminal.IdentifiedObject.mRID,
                            terminals(0).ConnectivityNode,
                            terminals(i).ACDCTerminal.IdentifiedObject.mRID,
                            terminals(i).ConnectivityNode,
                            equipment.id, // terminals(n).ConductingEquipment,
                            equipment.asInstanceOf[ConductingEquipment].BaseVoltage,
                            identical,
                            connected)
                }
        }
        //else // shouldn't happen, terminals always reference ConductingEquipment, right?
            // throw new Exception ("element " + e.id + " is not derived from ConductingEquipment")
            // ProtectionEquipment and CurrentRelay are emitted with terminals even though they shouldn't be


        ret
    }

    def vertex_id (string: String): VertexId =
    {
        var h = 2166136261l
        for (c ← string)
            h = (h * 16777619) ^ c
        h
    }

    def make_graph_edges (e: CIMEdgeData): Edge[CIMEdgeData] = Edge (vertex_id (e.id_cn_1), vertex_id (e.id_cn_2), e)

    def to_vertex (n: ConnectivityNode): (VertexId, CIMVertexData) =
    {
        val v = vertex_id (n.id)
        (v, CIMVertexData (0.asInstanceOf[VertexId], "", v, n.id, null))
    }

    def make_graph (): Graph[CIMVertexData, CIMEdgeData] =
    {
        // get the terminals keyed by equipment
        val terms = get[Terminal].groupBy (_.ConductingEquipment)

        // map elements with their terminal 'pairs' to edges
        val edges: RDD[Edge[CIMEdgeData]] = get[Element]("Elements").keyBy (_.id).join (terms)
            .flatMapValues (edge_operator).values.map (make_graph_edges)

        // get the vertices
        val vertices: RDD[(VertexId, CIMVertexData)] = get[ConnectivityNode].map (to_vertex)

        if (debug)
        {
            // check for uniqueness of VertexId
            val duplicates: RDD[(VertexId, Iterable[CIMVertexData])] = vertices.groupByKey.filter (_._2.size > 1)
            if (!duplicates.isEmpty ())
                duplicates.collect.map (x ⇒ { log.error ("VertexId clash (%d) for %s and %s".format (x._1, x._2.head.node_label, x._2.tail.head.node_label)); 1 })

            // check for missing vertices
            val cn: RDD[(String, String)] = edges.flatMap (x ⇒ List ((x.attr.id_cn_1, x.attr.id_equ), (x.attr.id_cn_2, x.attr.id_equ)))
            val missing = cn.leftOuterJoin (vertices.keyBy (_._2.node_label)).filter (_._2._2 match { case None ⇒ true case _ ⇒ false } ).map (x ⇒ (x._2._1, x._1))
            if (!missing.isEmpty)
                missing.collect. map (x ⇒ { log.error ("%s missing ConnectivityNode %s".format (x._1, x._2)); 1 })
        }

        // construct the initial graph from the edges
        Graph.apply (vertices, edges, CIMVertexData (), storage, storage).cache
    }

    def identifyNodes (graph: Graph[CIMVertexData, CIMEdgeData]): Graph[CIMVertexData, CIMEdgeData] =
    {
        def vertex_program (id: VertexId, data: CIMVertexData, message: CIMVertexData): CIMVertexData =
        {
            if (null != message) // not initialization call?
                if (data.node > message.node)
                {
                    data.node = message.node
                    data.node_label = message.node_label
                    data.voltage = message.voltage
                }
            data
        }

        def send_message (triplet: EdgeTriplet[CIMVertexData, CIMEdgeData]): Iterator[(VertexId, CIMVertexData)] =
        {
            if (!triplet.attr.isZero)
                Iterator.empty // send no message across a topological boundary
            else
            {
                if (debug)
                    if ((null != triplet.srcAttr.voltage) && (null != triplet.dstAttr.voltage))
                        if (triplet.srcAttr.voltage != triplet.dstAttr.voltage)
                            log.error ("conflicting node voltages across edge %s, %s:%s, %s:%s".format (triplet.attr.id_equ, triplet.srcAttr.node_label, triplet.srcAttr.voltage, triplet.dstAttr.node_label, triplet.dstAttr.voltage))
                if (triplet.srcAttr.node < triplet.dstAttr.node)
                {
                    if (debug && log.isDebugEnabled)
                        log.debug ("%s: from src:%d to dst:%d %s ---> %s".format (triplet.attr.id_equ, triplet.srcId, triplet.dstId, triplet.srcAttr.toString, triplet.dstAttr.toString))
                    Iterator ((triplet.dstId, triplet.srcAttr.copy (voltage = triplet.attr.voltage)))
                }
                else if (triplet.srcAttr.node > triplet.dstAttr.node)
                {
                    if (debug && log.isDebugEnabled)
                        log.debug ("%s: from dst:%d to src:%d %s ---> %s".format (triplet.attr.id_equ, triplet.dstId, triplet.srcId,  triplet.dstAttr.toString, triplet.srcAttr.toString))
                    Iterator ((triplet.srcId, triplet.dstAttr.copy (voltage = triplet.attr.voltage)))
                }
                else
                    Iterator.empty
            }
        }

        def merge_message (a: CIMVertexData, b: CIMVertexData): CIMVertexData =
        {
            if (debug)
                if ((null != a.voltage) && (null != b.voltage))
                    if (a.voltage != b.voltage)
                        log.error ("conflicting node voltages, merging: %s into %s".format (if (a.node <= b.node) b.node_label + ":" + b.voltage else a.node_label + ":" + a.voltage, if (a.node <= b.node) a.node_label + ":" + a.voltage else b.node_label + ":" + b.voltage))
            if (a.node <= b.node) a else b
        }

        // traverse the graph with the Pregel algorithm
        // assigns the minimum VertexId of all electrically identical nodes (node)
        // Note: on the first pass through the Pregel algorithm all nodes get a null message
        graph.pregel[CIMVertexData] (null, 10000, EdgeDirection.Either) (vertex_program, send_message, merge_message).cache
    }

    def to_islands (nodes: Iterable[((CIMVertexData,ConnectivityNode),Option[(Terminal, Element)])]): (VertexId, TopologicalIsland) =
    {
        def op (current: (List[Terminal],ConnectivityNode), data: ((CIMVertexData,ConnectivityNode),Option[(Terminal, Element)])): (List[Terminal],ConnectivityNode) =
        {
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
                case t1 :: _ =>
                    trafos (terminals) + "_terminal_" + t1.ACDCTerminal.sequenceNumber
                case _ =>
                    cn.id
            }
        val name = base + "_island"
        val island = nodes.head._1._1.island
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
                null // AngleRefTopologicalNode: String
            )
        )
    }

    def to_nodes (arg: (VertexId, CIMVertexData, Option[TopologicalIsland])): TopologicalNode =
    {
        val name = arg._2.name
        val island = arg._3 match
        {
            case Some (i) =>
                i.id
            case _ =>
                ""
        }
        TopologicalNode (
            IdentifiedObject
            (
                BasicElement
                (
                    null,
                    name
                ),
                arg._1.toString, // aliasName: String
                null, // description: String
                name,  // mRID: String
                null  // name: String
            ),
            0.0, // pInjection: Double,
            0.0, // qInjection: Double,
            null, // AngleRefTopologicalIsland: String,
            null, // BaseVoltage: String,
            null, // ConnectivityNodeContainer: String,
            null, // ReportingGroup: String,
            null, // SvInjection: String,
            null, // SvVoltage: String,
            island  // TopologicalIsland: String
        )
    }

    def update_cn (arg: (ConnectivityNode,Option[CIMVertexData])): ConnectivityNode =
    {
        val c = arg._1
        arg._2 match
        {
            case Some (node) =>
                // ToDo: should be: c.copy (TopologicalNode = node.name)
                ConnectivityNode (
                    c.IdentifiedObject,
                    ConnectivityNodeContainer = c.ConnectivityNodeContainer,
                    TopologicalNode = node.name
                )
            case None => c
        }
    }

    def update_terminals (arg: (Terminal,Option[CIMVertexData])): Terminal =
    {
        val t = arg._1
        arg._2 match
        {
            case Some (node) =>
                // ToDo: should be: t.copy (TopologicalNode = node.name)
                Terminal (
                    t.ACDCTerminal,
                    phases = t.phases,
                    Bushing = t.Bushing,
                    ConductingEquipment = t.ConductingEquipment,
                    ConnectivityNode = t.ConnectivityNode,
                    SvPowerFlow = t.SvPowerFlow,
                    TopologicalNode = node.name
                )
            case None => t
        }
    }

    def identifyIslands (graph: Graph[CIMVertexData, CIMEdgeData]): Graph[CIMVertexData, CIMEdgeData] =
    {
        def vertex_program (id: VertexId, attr: CIMVertexData, msg: CIMVertexData): CIMVertexData =
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

        def send_message (triplet: EdgeTriplet[CIMVertexData, CIMEdgeData]): Iterator[(VertexId, CIMVertexData)] =
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

        def merge_message (a: CIMVertexData, b: CIMVertexData): CIMVertexData = if (a.island < b.island) a else b

        def boundary (edge: (Edge[CIMEdgeData], CIMVertexData, CIMVertexData)): Boolean = edge._2.node != edge._3.node

        def make_graph_edges (edge: (Edge[CIMEdgeData], CIMVertexData, CIMVertexData)): Edge[CIMEdgeData] =
            Edge (edge._2.node, edge._3.node, edge._1.attr)

        def update_vertices (id: VertexId, vertex: CIMVertexData, island: Option[CIMVertexData]): CIMVertexData =
        {
            island match
            {
                case Some (data: CIMVertexData) =>
                    vertex.island = data.island
                    vertex.island_label = data.island_label
                case None => // should never happen
                    log.warn ("update vertices skipping vertex with no associated island")
            }

            vertex
        }

        def mapper (d: (VertexId, ((VertexId, CIMVertexData), Option[CIMVertexData]))): (VertexId, CIMVertexData) =
        {
            val td = d._2._2 match
            {
                case Some (data: CIMVertexData) =>
                    data
                case None => // this will happen if no edges are connected to a node, use the "no-island" default
                    d._2._1._2
            }
            ( d._2._1._1, td)
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
        val topo_graph = Graph.apply[CIMVertexData, CIMEdgeData](vertices, edges, CIMVertexData (), storage, storage)

        // run the Pregel algorithm over the reduced topological graph
        val g = topo_graph.pregel[CIMVertexData] (null, 10000, EdgeDirection.Either) (vertex_program, send_message, merge_message)

        // update the original graph with the islands
        val v = graph.vertices.keyBy (_._2.node).leftOuterJoin (g.vertices.values.keyBy (_.node)).map (mapper)

        val ret = graph.outerJoinVertices (v) (update_vertices)

        // persist the RDD to avoid recomputation
        ret.vertices.persist (storage)
        ret.edges.persist (storage)

        ret
    }

    /**
     * Create new TopologicalNode and optionally TopologicalIsland RDD based on connectivity.
     *
     * Any existing RDDs with these names will be unpersisted and renamed "old_XXX".
     * Hierarchical nested case class RDDs will also be updated.
     *
     * @param identify_islands pass <code>true</code> if the TopologicalIsland RDD should be populated.
     * @return The new Elements RDD - with TopologicalNode and TopologicalIsland objects included.
     */
    def process (identify_islands: Boolean): RDD[Element] =
    {
        // get the initial graph based on edges
        val initial = make_graph ()

        // get the topological nodes
        log.info ("identifyNodes")
        var graph = identifyNodes (initial)

        // get the original island and node RDD
        val _old_ti = get[TopologicalIsland]
        val _old_tn = get[TopologicalNode]
        val old_ti = if (null == _old_ti) spark.sparkContext.emptyRDD[TopologicalIsland] else _old_ti
        val old_tn = if (null == _old_tn) spark.sparkContext.emptyRDD[TopologicalNode] else _old_tn

        // create a new TopologicalNode RDD
        val (new_tn, new_ti) = if (identify_islands)
        {
            // get the topological islands
            log.info ("identifyIslands")
            graph = identifyIslands (graph)

            log.info ("islands")
            // get the terminals keyed by equipment with equipment
            val elements = get[Element]("Elements").keyBy (_.id)
            val terms = get[Terminal].keyBy (_.ConductingEquipment).join (elements).values
            // map each graph vertex to the terminals
            val vertices = get[ConnectivityNode].map ((x) => (vertex_id (x.id), x))
            val td_plus = graph.vertices.join (vertices).values.filter (_._1.island != 0L).keyBy (_._2.id).leftOuterJoin (terms.keyBy (_._1.ConnectivityNode)).values
            val islands = td_plus.groupBy (_._1._1.island).values.map (to_islands)

            // create a new TopologicalIsland RDD
            val new_ti = islands.values

            // swap the old TopologicalIsland RDD for the new one
            if (null != _old_ti)
            {
                old_ti.unpersist (false)
                old_ti.name = "old_TopologicalIsland"
            }
            new_ti.name = "TopologicalIsland"
            new_ti.persist (storage)
            spark.sparkContext.getCheckpointDir match
            {
                case Some (_) => new_ti.checkpoint ()
                case None =>
            }
            spark.createDataFrame (new_ti).createOrReplaceTempView ("TopologicalIsland")

            val nodes_with_islands = graph.vertices.values.keyBy (_.island).join (islands).values
            (nodes_with_islands.groupBy (_._1.node).map ((x) => (x._1, x._2.head._1, Some (x._2.head._2))).map (to_nodes), new_ti)
        }
        else
            (graph.vertices.values.groupBy (_.node).map ((x) => (x._1, x._2.head, None)).map (to_nodes), spark.sparkContext.emptyRDD[TopologicalIsland])

        // swap the old TopologicalNode RDD for the new one
        if (null != _old_tn)
        {
            old_tn.unpersist (false)
            old_tn.name = "old_TopologicalNode"
        }
        new_tn.name = "TopologicalNode"
        new_tn.persist (storage)
        spark.sparkContext.getCheckpointDir match
        {
            case Some (_) => new_tn.checkpoint ()
            case None =>
        }
        spark.createDataFrame (new_tn).createOrReplaceTempView ("TopologicalNode")

        // but the other RDD (ConnectivityNode and Terminal also ACDCTerminal) need to be updated in IdentifiedObject and Element

        // assign every ConnectivtyNode to a TopologicalNode
        val old_cn = get[ConnectivityNode]
        val new_cn = old_cn.keyBy (a => vertex_id (a.id)).leftOuterJoin (graph.vertices).values.map (update_cn)

        // swap the old ConnectivityNode RDD for the new one
        old_cn.name = "nontopological_ConnectivityNode"
        new_cn.name = "ConnectivityNode"
        new_cn.persist (storage)
        spark.sparkContext.getCheckpointDir match
        {
            case Some (_) => new_cn.checkpoint ()
            case None =>
        }
        spark.createDataFrame (new_cn).createOrReplaceTempView ("ConnectivityNode")

        // assign every Terminal with a connectivity node to a TopologicalNode
        // note: keep the original enclosed ACDCTerminal objects
        val old_terminals = get[Terminal]
        val t_with = old_terminals.filter (null != _.ConnectivityNode)
        val t_without = old_terminals.filter (null == _.ConnectivityNode)
        val new_terminals = t_with.keyBy (a => vertex_id (a.ConnectivityNode)).leftOuterJoin (graph.vertices).values.map (update_terminals)
            .union (t_without)

        // swap the old Terminal RDD for the new one
        old_terminals.name = "nontopological_Terminal"
        new_terminals.name = "Terminal"
        new_terminals.persist (storage)
        spark.sparkContext.getCheckpointDir match
        {
            case Some (_) => new_terminals.checkpoint ()
            case None =>
        }
        spark.createDataFrame (new_terminals).createOrReplaceTempView ("Terminal")

        // make a union of all old RDD as IdentifiedObject
        val oldobj =
                   old_ti.map (_.IdentifiedObject).
            union (old_tn.map (_.IdentifiedObject)).
            union (old_cn.map (_.IdentifiedObject)).
            union (old_terminals.map (_.ACDCTerminal.IdentifiedObject))

        // make a union of all new RDD as IdentifiedObject
        val newobj =
                   new_ti.map (_.IdentifiedObject).
            union (new_tn.map (_.IdentifiedObject)).
            union (new_cn.map (_.IdentifiedObject)).
            union (new_terminals.map (_.ACDCTerminal.IdentifiedObject))

        // replace identified objects in IdentifiedObject
        val old_idobj = get[IdentifiedObject]
        val new_idobj = old_idobj.keyBy (_.id).subtract (oldobj.keyBy (_.id)).values.union (newobj)

        // swap the old IdentifiedObject RDD for the new one
        old_idobj.name = "nontopological_IdentifiedObject"
        new_idobj.name = "IdentifiedObject"
        new_idobj.persist (storage)
        spark.sparkContext.getCheckpointDir match
        {
            case Some (_) => new_idobj.checkpoint ()
            case None =>
        }
        spark.createDataFrame (new_idobj).createOrReplaceTempView ("IdentifiedObject")

        // make a union of all old RDD as Element
        val oldelem =
                   old_ti.asInstanceOf[RDD[Element]].
            union (old_tn.asInstanceOf[RDD[Element]]).
            union (old_cn.asInstanceOf[RDD[Element]]).
            union (old_terminals.asInstanceOf[RDD[Element]])

        // make a union of all new RDD as Element
        val newelem = new_ti.asInstanceOf[RDD[Element]].
            union (new_tn.asInstanceOf[RDD[Element]]).
            union (new_cn.asInstanceOf[RDD[Element]]).
            union (new_terminals.asInstanceOf[RDD[Element]])

        // replace elements in Elements
        val old_elements = get[Element]("Elements")
        val new_elements = old_elements.keyBy (_.id).subtract (oldelem.keyBy (_.id)).values.union (newelem)

        // swap the old Elements RDD for the new one
        old_elements.name = "nontopological_Elements"
        new_elements.name = "Elements"
        new_elements.persist (storage)
        spark.sparkContext.getCheckpointDir match
        {
            case Some (_) => new_elements.checkpoint ()
            case None =>
        }

        new_elements
    }

    /**
     * Conditionally create new TopologicalNode and optionally TopologicalIsland RDD based on connectivity.
     *
     * Note, if these RDD exist and are already populated, this method does nothing.
     * Otherwise it calls the [[process]] method.
     *
     * @param identify_islands pass <code>true</code> if the TopologicalIsland RDD should be populated.
     * @return Either the old Elements RDD or a new Elements RDD - with TopologicalNode and TopologicalIsland objects included.
     */
    def processIfNeeded (identify_islands: Boolean): RDD[Element] =
    {
        val nodes = get[TopologicalNode]
        if ((null == nodes) || nodes.isEmpty ())
            process (identify_islands)
        else
        {
            val islands = get[TopologicalIsland]
            if (identify_islands && ((null == islands) || islands.isEmpty ()))
                process (identify_islands)
            else
                get [Element]("Elements")
        }
    }
}
