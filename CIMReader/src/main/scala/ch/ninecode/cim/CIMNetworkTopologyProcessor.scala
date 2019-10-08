package ch.ninecode.cim

import org.apache.spark.graphx.Edge
import org.apache.spark.graphx.EdgeDirection
import org.apache.spark.graphx.EdgeTriplet
import org.apache.spark.graphx.Graph
import org.apache.spark.graphx.Graph.graphToGraphOps
import org.apache.spark.graphx.VertexId
import org.apache.spark.rdd.RDD
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions
import org.apache.spark.sql.Encoders
import org.apache.spark.sql.Row
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
 */
case class CIMNetworkTopologyProcessor (spark: SparkSession) extends CIMRDD
{
    /**
     * The old constructor for CIMNetworkTopologyProcessor.
     *
     * @deprecated ("Use the constructor taking a CIMTopologyOptions object", "3.0.3")
     * or pass a CIMTopologyOptions object to process(CIMTopologyOptions) or processIfNeeded(CIMTopologyOptions)
     */
    def this (
                 spark: SparkSession,
                 storage: StorageLevel = StorageLevel.MEMORY_AND_DISK_SER,
                 force_retain_switches: Boolean = false,
                 force_retain_fuses: Boolean = false,
                 debug: Boolean = false) =
    {
        this (spark)
        options = CIMTopologyOptions (
            identify_islands = false,
            force_retain_switches = if (force_retain_switches) ForceTrue else Unforced,
            force_retain_fuses = if (force_retain_fuses) ForceTrue else Unforced,
            force_switch_separate_islands = Unforced,
            force_fuse_separate_islands = Unforced,
            default_switch_open_state = false,
            debug = debug,
            storage = storage
        )
    }

    private implicit val session: SparkSession = spark
    private implicit val log: Logger = LoggerFactory.getLogger(getClass)

    /**
     * Options in effect for the process operation.
     */
    var options: CIMTopologyOptions = CIMTopologyOptions ()

    /**
     * Index of normalOpen field in Switch bitmask.
     */
    val normalOpenMask: Int = Switch.fields.indexOf ("normalOpen")

    /**
     * Index of open field in Switch bitmask.
     */
    val openMask: Int = Switch.fields.indexOf ("open")

    /**
     * Index of retained field in Switch bitmask.
     */
    val retainedMask: Int = Switch.fields.indexOf ("retained")

    // just to get a schema
    case class dummy (override val sup: Element = null) extends Element

    /**
     * Method to determine if a switch is closed (both terminals are the same topological node).
     *
     * If the switch has the <code>open</code> attribute set, use that.
     * Otherwise if it has the <code>normalOpen</code> attribute set, use that.
     * Otherwise assume it is the default state set by
     * CIMTopologyOptions.default_switch_open_state which means not closed unless explicitly set.
     *
     * @param switch The switch object to test.
     * @return <code>true</code> if the switch is closed, <code>false</code> otherwise.
     */
    def switchClosed (switch: Switch): Boolean =
    {
        if (0 != (switch.bitfields(openMask / 32) & (1 << (openMask % 32))))
            !switch.open // open valid
        else if (0 != (switch.bitfields(normalOpenMask / 32) & (1 << (normalOpenMask % 32))))
            !switch.normalOpen
        else
            !options.default_switch_open_state
    }

    /**
     * Method to determine if a switch should be retained in the topology.
     *
     * @param switch The switch object to test.
     * @return <code>true</code> if the switch should be retained, <code>false</code> otherwise.
     */
    def retainSwitch (switch: Switch): Boolean =
    {
        if (0 != (switch.bitfields(retainedMask / 32) & (1 << (retainedMask % 32))))
            switch.retained
        else
            false
    }

    /**
     * Method to determine if a switch can be represented as a single topological node.
     *
     * @param switch The switch object to test.
     * @return <code>true</code> if the switch is effectively one node, <code>false</code> otherwise.
     */
    def isSwitchOneNode (switch: Switch): Boolean =
    {
        options.force_retain_switches match
        {
            case ForceTrue => false
            case ForceFalse => true
            case Unforced => !retainSwitch (switch) && switchClosed (switch)
        }
    }

    /**
     * Method to determine if a fuse can be represented as a single topological node.
     *
     * @param switch The fuse object to test.
     * @return <code>true</code> if the fuse is effectively one node, <code>false</code> otherwise.
     */
    def isFuseOneNode (switch: Switch): Boolean =
    {
        options.force_retain_fuses match
        {
            case ForceTrue => false
            case ForceFalse => true
            case Unforced => !retainSwitch (switch) && switchClosed (switch)
        }
    }

    /**
     * Method to determine if the nodes for an element are the same topological node.
     *
     * @param element The element to test.
     * @return <code>true</code> if the element is effectively one node, <code>false</code> otherwise.
     */
    def isSameNode (element: Element): Boolean =
    {
        element match
        {
            case switch:             Switch =>             isSwitchOneNode (switch)
            case mktswitch:          MktSwitch =>          isSwitchOneNode (mktswitch.Switch)
            case cut:                Cut =>                isSwitchOneNode (cut.Switch)
            case disconnector:       Disconnector =>       isSwitchOneNode (disconnector.Switch)
            case fuse:               Fuse =>               isFuseOneNode   (fuse.Switch)
            case grounddisconnector: GroundDisconnector => isSwitchOneNode (grounddisconnector.Switch)
            case jumper:             Jumper =>             isSwitchOneNode (jumper.Switch)
            case protectedswitch:    ProtectedSwitch =>    isFuseOneNode   (protectedswitch.Switch)
            case sectionaliser:      Sectionaliser =>      isSwitchOneNode (sectionaliser.Switch)
            case breaker:            Breaker =>            isFuseOneNode   (breaker.ProtectedSwitch.Switch)
            case loadbreakswitch:    LoadBreakSwitch =>    isFuseOneNode   (loadbreakswitch.ProtectedSwitch.Switch)
            case recloser:           Recloser =>           isFuseOneNode   (recloser.ProtectedSwitch.Switch)
            case _:                  PowerTransformer =>   false
            case line:               ACLineSegment =>      !((line.Conductor.len > 0.0) && ((line.r > 0.0) || (line.x > 0.0)))
            case _:                  Conductor =>          true
            case _ =>
                log.warn ("topological node processor encountered edge with unhandled class '" + element.getClass.getName +"', assumed zero impedance")
                true
        }
    }

    /**
     * Method to determine if a switch can be represented as a single topological island.
     *
     * @param switch The switch object to test.
     * @return <code>true</code> if the switch is effectively one island, <code>false</code> otherwise.
     */
    def isSwitchOneIsland (switch: Switch): Boolean =
    {
        options.force_switch_separate_islands match
        {
            case ForceTrue => false
            case ForceFalse => true
            case Unforced => switchClosed (switch)
        }
    }

    /**
     * Method to determine if a fuse can be represented as a single topological island.
     *
     * @param switch The fuse object to test.
     * @return <code>true</code> if the fuse is effectively one island, <code>false</code> otherwise.
     */
    def isFuseOneIsland (switch: Switch): Boolean =
    {
        options.force_fuse_separate_islands match
        {
            case ForceTrue => false
            case ForceFalse => true
            case Unforced => switchClosed (switch)
        }
    }

    /**
     * Method to determine if the nodes for an element are in the same topological island.
     *
     * @param element The element to test.
     * @return <code>true</code> if the element is effectively one node, <code>false</code> otherwise.
     */
    def isSameIsland (element: Element): Boolean =
    {
        element match
        {
            case switch:             Switch =>             isSwitchOneIsland (switch)
            case mktswitch:          MktSwitch =>          isSwitchOneIsland (mktswitch.Switch)
            case cut:                Cut =>                isSwitchOneIsland (cut.Switch)
            case disconnector:       Disconnector =>       isSwitchOneIsland (disconnector.Switch)
            case fuse:               Fuse =>               isFuseOneIsland   (fuse.Switch)
            case grounddisconnector: GroundDisconnector => isSwitchOneIsland (grounddisconnector.Switch)
            case jumper:             Jumper =>             isSwitchOneIsland (jumper.Switch)
            case protectedswitch:    ProtectedSwitch =>    isFuseOneIsland   (protectedswitch.Switch)
            case sectionaliser:      Sectionaliser =>      isSwitchOneIsland (sectionaliser.Switch)
            case breaker:            Breaker =>            isFuseOneIsland   (breaker.ProtectedSwitch.Switch)
            case loadbreakswitch:    LoadBreakSwitch =>    isFuseOneIsland   (loadbreakswitch.ProtectedSwitch.Switch)
            case recloser:           Recloser =>           isFuseOneIsland   (recloser.ProtectedSwitch.Switch)
            case _:                  PowerTransformer =>   false
            case _:                  ACLineSegment =>      true
            case _:                  Conductor =>          true
            case _ =>
                log.warn ("topological island processor encountered edge with unhandled class '" + element.getClass.getName +"', assumed zero impedance")
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
            val terminals = arg._2.filter (x => (null != x.ConnectivityNode) && ("" != x.ConnectivityNode)).toArray.sortBy (_.ACDCTerminal.sequenceNumber)
            // make an edge for each pair of terminals
            if (terminals.length >= 2) // eliminate edges without two connectivity nodes
                for (i <- 1 until terminals.length) // eliminate edges with only one terminal
                {
                    // check if this edge connects its nodes
                    val identical = isSameNode (arg._1)
                    // check if this edge has its nodes in the same island
                    val connected = isSameIsland (arg._1)
                    ret = ret :+ CIMEdgeData (
                        terminals(0).ConnectivityNode,
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
        for (c <- string)
            h = (h * 16777619) ^ c
        h
    }

    def make_graph_edges (e: CIMEdgeData): Edge[CIMEdgeData] = Edge (vertex_id (e.id_cn_1), vertex_id (e.id_cn_2), e)

    def to_vertex (arg: (ConnectivityNode, String)): CIMVertexData =
    {
        val v = vertex_id (arg._1.id)
        CIMVertexData (0.asInstanceOf[VertexId], "", v, arg._1.id, arg._2, arg._1.ConnectivityNodeContainer)
    }

    def make_graph (): Graph[CIMVertexData, CIMEdgeData] =
    {
        // get the terminals keyed by equipment
        val terms = getOrElse[Terminal].groupBy (_.ConductingEquipment)

        // map elements with their terminal 'pairs' to edges
        val edges = getOrElse[Element]("Elements").keyBy (_.id).join (terms)
            .values.flatMap (edge_operator).map (make_graph_edges).persist (options.storage)

        val end_voltages = getOrElse[PowerTransformerEnd].map (x => (x.PowerTransformer, (x.TransformerEnd.endNumber, x.TransformerEnd.BaseVoltage))).groupByKey
        val equipment_voltages = getOrElse[ConductingEquipment].flatMap (
            x =>
                if ((null == x.BaseVoltage) || ("" == x.BaseVoltage))
                    None
                else
                    Some((x.id, Iterable ((1, x.BaseVoltage), (2, x.BaseVoltage))))) // same voltage for both terminals

        // get the voltage for each ConnectivityNode by joining through Terminal
        val e = getOrElse[Terminal]
            .filter (x => (null != x.ConductingEquipment) && (null != x.ConnectivityNode))
            .map (x => (x.ConductingEquipment, (x.ACDCTerminal.sequenceNumber, x.ConnectivityNode))).groupByKey
            .join (equipment_voltages.union (end_voltages)).values // ([(term#, ConnectivityNode)], [(end#, voltage)])
            .flatMap (
                x =>
                    x._1.flatMap (
                    y =>
                        x._2.find (_._1 == y._1) match
                        {
                            case Some (voltage) => Some ((y._2, voltage._2))
                            case None => None
                        }
                    )
                )
            .groupByKey.map (
                x =>
                {
                    val voltages = x._2.filter (_ != null)
                    val voltage = voltages.headOption.getOrElse ("Unknown")
                    if (options.debug)
                        if (!voltages.forall (_ == voltage))
                            log.error ("conflicting edge voltages on node %s (%s)".format (x._1, voltages.take(10).mkString (",")))
                    (x._1, voltage)
                }
            )

        // get the vertices
        val vertices = getOrElse[ConnectivityNode].keyBy (_.id).join (e).values.map (to_vertex).keyBy (_.node).persist (options.storage)

        if (options.debug)
        {
            // check for uniqueness of VertexId
            val duplicates = vertices.groupByKey.filter (_._2.size > 1)
            if (!duplicates.isEmpty ())
                duplicates.collect.map (x => { log.error ("VertexId clash (%d) for %s and %s".format (x._1, x._2.head.node_label, x._2.tail.head.node_label)); 1 })

            // check for missing vertices
            val cn = edges.flatMap (x => List ((x.attr.id_cn_1, x.attr.id_equ), (x.attr.id_cn_2, x.attr.id_equ)))
            val missing = cn.leftOuterJoin (vertices.keyBy (_._2.node_label)).filter (_._2._2 match { case None => true case _ => false } ).map (x => (x._2._1, x._1))
            if (!missing.isEmpty)
                missing.collect. map (x => { log.error ("%s missing ConnectivityNode %s".format (x._1, x._2)); 1 })
        }

        // construct the initial graph from the edges
        Graph.apply (vertices, edges, CIMVertexData (), options.storage, options.storage).cache
    }

    def identifyNodes (graph: Graph[CIMVertexData, CIMEdgeData]): Graph[CIMVertexData, CIMEdgeData] =
    {
        def vertex_program (id: VertexId, data: CIMVD, message: CIMVD): CIMVD =
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

        def send_message (triplet: EdgeTriplet[CIMVD, CIMEdgeData]): Iterator[(VertexId, CIMVD)] =
        {
            if (!triplet.attr.isZero)
                Iterator.empty // send no message across a topological boundary
            else
            {
                if (options.debug)
                    if ((null != triplet.srcAttr.voltage) && (null != triplet.dstAttr.voltage))
                        if (triplet.srcAttr.voltage != triplet.dstAttr.voltage)
                            log.error ("conflicting node voltages across edge %s, %s:%s, %s:%s".format (triplet.attr.id_equ, triplet.srcAttr.node_label, triplet.srcAttr.voltage, triplet.dstAttr.node_label, triplet.dstAttr.voltage))
                if (triplet.srcAttr.node < triplet.dstAttr.node)
                {
                    if (options.debug && log.isDebugEnabled)
                        log.debug ("%s: from src:%d to dst:%d %s ---> %s".format (triplet.attr.id_equ, triplet.srcId, triplet.dstId, triplet.srcAttr.toString, triplet.dstAttr.toString))
                    val voltage = if (null != triplet.attr.voltage) triplet.attr.voltage else if (null != triplet.srcAttr.voltage) triplet.srcAttr.voltage else triplet.dstAttr.voltage
                    if ((null != voltage) && (null == triplet.dstAttr.voltage))
                        Iterator ((triplet.dstId, triplet.srcAttr.copy (voltage = voltage)), (triplet.srcId, triplet.srcAttr.copy (voltage = voltage)))
                    else
                        Iterator ((triplet.dstId, triplet.srcAttr.copy (voltage = voltage)))
                }
                else if (triplet.srcAttr.node > triplet.dstAttr.node)
                {
                    if (options.debug && log.isDebugEnabled)
                        log.debug ("%s: from dst:%d to src:%d %s ---> %s".format (triplet.attr.id_equ, triplet.dstId, triplet.srcId,  triplet.dstAttr.toString, triplet.srcAttr.toString))
                    val voltage = if (null != triplet.attr.voltage) triplet.attr.voltage else if (null != triplet.dstAttr.voltage) triplet.dstAttr.voltage else triplet.srcAttr.voltage
                    if ((null != voltage) && (null == triplet.srcAttr.voltage))
                        Iterator ((triplet.srcId, triplet.dstAttr.copy (voltage = voltage)), (triplet.dstId, triplet.dstAttr.copy (voltage = voltage)))
                    else
                        Iterator ((triplet.srcId, triplet.dstAttr.copy (voltage = voltage)))
                }
                else
                    Iterator.empty
            }
        }

        def merge_message (a: CIMVD, b: CIMVD): CIMVD =
        {
            if (options.debug)
                if ((null != a.voltage) && (null != b.voltage))
                    if (a.voltage != b.voltage)
                        log.error ("conflicting node voltages, merging: %s into %s".format (if (a.node <= b.node) b.node_label + ":" + b.voltage else a.node_label + ":" + a.voltage, if (a.node <= b.node) a.node_label + ":" + a.voltage else b.node_label + ":" + b.voltage))
            if (a.node <= b.node) a else b
        }

        // convert to smaller objects
        val g = graph.mapVertices ((id, v) => CIMVD (v.node, v.node_label, v.voltage))

        // traverse the graph with the Pregel algorithm
        // assigns the minimum VertexId of all electrically identical nodes (node)
        // Note: on the first pass through the Pregel algorithm all nodes get a null message
        val ng = g.pregel[CIMVD] (null, 10000, EdgeDirection.Either) (vertex_program, send_message, merge_message).cache

        // transfer the labels back to the full vertices
        val nv = ng.vertices.join (graph.vertices).map (x => { val v = x._2._2; v.node = x._2._1.node; v.node_label = x._2._1.node_label; (x._1, v) })

        // rebuild the graph
        Graph.apply (nv, graph.edges, CIMVertexData (), options.storage, options.storage).cache
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
        val basic = BasicElement (
            null,
            mRID = name
        )
        basic.bitfields = Array (Integer.parseInt ("1", 2))
        val obj = IdentifiedObject (
            basic,
            aliasName = cn.IdentifiedObject.aliasName,
            description = cn.IdentifiedObject.description,
            mRID = name,
            name = cn.id,
            DiagramObjects = List (),
            InstanceSet = null,
            Names = List (),
            PropertiesCIMDataObject = null,
            TargetingCIMDataObject = List()
        )
        obj.bitfields = Array (Integer.parseInt ("1111", 2))
        val island = TopologicalIsland (
            obj,
            AngleRefTopologicalNode = null,
            TopologicalNodes = List()
        )
        island.bitfields = Array (0)

        (
            nodes.head._1._1.island,
            island
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
        val element = BasicElement (
            null,
            mRID = name
        )
        element.bitfields = Array (Integer.parseInt ("1", 2))
        val obj = IdentifiedObject (
            element,
            aliasName = arg._1.toString,
            description = null,
            mRID = name,
            name = null,
            DiagramObjects = List (),
            InstanceSet = null,
            Names = List (),
            PropertiesCIMDataObject = null,
            TargetingCIMDataObject = List()
        )
        obj.bitfields = Array (Integer.parseInt ("101", 2))
        val node = TopologicalNode (
            obj,
            pInjection = 0.0,
            qInjection = 0.0,
            AngleRefTopologicalIsland = null,
            BaseVoltage = arg._2.voltage,
            BusNameMarker = List (),
            ConnectivityNodeContainer = arg._2.container,
            ConnectivityNodes = List (),
            ReportingGroup = null,
            SvInjection = List (),
            SvVoltage = List (),
            Terminal = List (),
            TopologicalIsland = island
        )
        node.bitfields = Array (Integer.parseInt ("100000101000", 2))
        node
    }

    def update_cn (arg: (ConnectivityNode,Option[CIMVertexData])): ConnectivityNode =
    {
        val c = arg._1
        arg._2 match
        {
            case Some (node) =>
                // ToDo: should be: c.copy (TopologicalNode = node.name)
                val cn = ConnectivityNode (
                    c.IdentifiedObject,
                    ConnectivityNodeContainer = c.ConnectivityNodeContainer,
                    Terminals = List (),
                    TopologicalNode = node.name
                )
                val bitfields = c.bitfields.clone ()
                val position = ConnectivityNode.fields.indexOf ("TopologicalNode")
                bitfields(position / 32) |= (1 << (position % 32))
                cn.bitfields = bitfields
                cn
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
                val terminal = Terminal (
                    t.ACDCTerminal,
                    phases = t.phases,
                    AuxiliaryEquipment = t.AuxiliaryEquipment,
                    BranchGroupTerminal = t.BranchGroupTerminal,
                    Bushing = t.Bushing,
                    Circuit = t.Circuit,
                    ConductingEquipment = t.ConductingEquipment,
                    ConnectivityNode = t.ConnectivityNode,
                    ConverterDCSides = t.ConverterDCSides,
                    EquipmentFaults = t.EquipmentFaults,
                    HasFirstMutualCoupling = t.HasFirstMutualCoupling,
                    HasSecondMutualCoupling = t.HasSecondMutualCoupling,
                    NormalHeadFeeder = t.NormalHeadFeeder,
                    PinTerminal = t.PinTerminal,
                    RegulatingControl = t.RegulatingControl,
                    RemoteInputSignal = t.RemoteInputSignal,
                    SvPowerFlow = t.SvPowerFlow,
                    TieFlow = t.TieFlow,
                    TopologicalNode = node.name, // the one changed property
                    TransformerEnd = t.TransformerEnd
                )
                val bitfields = t.bitfields.clone ()
                val position = Terminal.fields.indexOf ("TopologicalNode")
                bitfields(position / 32) |= (1 << (position % 32))
                terminal.bitfields = bitfields
                terminal
            case None => t
        }
    }

    /**
     * Use GraphX to identify nodes that are connected electrically
     * @see isSameIsland(Element)
     * @param graph The results from the topological node processing step.
     * @return A new graph with vertices having island information.
     */
    def identifyIslands (graph: Graph[CIMVertexData, CIMEdgeData]): Graph[CIMVertexData, CIMEdgeData] =
    {
        def to_topo_edge (triplet: EdgeTriplet[CIMVertexData, CIMEdgeData]): CIMEdgeData =
        {
            val edge = triplet.attr
            CIMEdgeData (triplet.srcAttr.node_label, triplet.dstAttr.node_label, edge.id_equ, edge.voltage, edge.isZero, edge.isConnected)
        }

        def to_island_vertices (edge: CIMEdgeData): Iterable[CIMIslandData] =
        {
            if (edge.id_cn_2 == null)
                List (CIMIslandData (vertex_id (edge.id_cn_1), edge.id_cn_1))
            else
                List (CIMIslandData (vertex_id (edge.id_cn_1), edge.id_cn_1), CIMIslandData (vertex_id (edge.id_cn_2), edge.id_cn_2))
        }

        def mapper (d: ((VertexId, CIMVertexData), Option[CIMIslandData])): (VertexId, CIMVertexData) =
        {
            d._2 match
            {
                case Some(data) =>
                    d._1._2.island = data.island
                    d._1._2.island_label = data.island_label
                    d._1
                case _ =>
                    d._1._2.island = vertex_id (d._1._2.node_label)
                    d._1._2.island_label = d._1._2.node_label
                    d._1
            }
        }

        def vertex_program (id: VertexId, attr: CIMIslandData, msg: CIMIslandData): CIMIslandData =
        {
            if (null == msg)
            // initially assign each node to it's own island
                attr.island = attr.node
            else
                if (attr.island > msg.island)
                {
                    attr.island = msg.island
                    attr.island_label = msg.island_label
                }

            attr
        }

        def send_message (triplet: EdgeTriplet[CIMIslandData, CIMEdgeData]): Iterator[(VertexId, CIMIslandData)] =
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

        def merge_message (a: CIMIslandData, b: CIMIslandData): CIMIslandData = if (a.island < b.island) a else b

        // make new edges with TopologicalNode VertexId for edges with feet in different nodes
        val e: RDD[CIMEdgeData] = graph.triplets
            .filter (edge => edge.srcAttr.node != edge.dstAttr.node)
            .map (to_topo_edge)

        val nodes: RDD[(VertexId, CIMIslandData)] = e.flatMap (to_island_vertices).keyBy (_.node)

        val edges: RDD[Edge[CIMEdgeData]] = e.map (x => Edge (vertex_id (x.id_cn_1), vertex_id (x.id_cn_2), x))

        val topo_graph: Graph[CIMIslandData, CIMEdgeData] = Graph.apply (nodes, edges, CIMIslandData (0, ""), options.storage, options.storage)

        // run the Pregel algorithm over the reduced topological graph
        val g = topo_graph.pregel[CIMIslandData] (null, 10000, EdgeDirection.Either) (vertex_program, send_message, merge_message)

        // update the original graph with the islands
        val v = graph.vertices.keyBy (_._2.node).leftOuterJoin (g.vertices.values.keyBy (_.node)).values.map (mapper)

        // make a new graph with the updated vertices
        val ret: Graph[CIMVertexData, CIMEdgeData] = Graph.apply (v, graph.edges, CIMVertexData (), options.storage, options.storage)

        // persist the RDD to avoid recomputation
        ret.vertices.persist (options.storage)
        ret.edges.persist (options.storage)

        ret
    }

    /**
     * Old process() method.
     * @deprecated ("Use the method taking a CIMTopologyOptions", "3.0.3")
     * @param identify_islands pass <code>true</code> if the TopologicalIsland RDD should be populated.
     */
    def process (identify_islands: Boolean): RDD[Element] =
        process (options.copy (identify_islands = identify_islands))

    /**
     * Create new TopologicalNode and optionally TopologicalIsland RDD based on connectivity.
     *
     * Any existing RDDs with these names will be unpersisted and renamed "old_XXX".
     * Hierarchical nested case class RDDs will also be updated.
     *
     * @return The new Elements RDD - with TopologicalNode and TopologicalIsland objects included.
     */
    def process (_options: CIMTopologyOptions): RDD[Element] =
    {
        log.info ("performing Network Topology Processing")
        options = _options

        // get the initial graph based on edges
        val initial = make_graph ()

        // get the topological nodes
        log.info ("identifyNodes")
        var graph: Graph[CIMVertexData, CIMEdgeData] = identifyNodes (initial)

        // get the original island and node RDD
        val old_ti = getOrElse[TopologicalIsland]
        val old_tn = getOrElse[TopologicalNode]

        // create a new TopologicalNode RDD
        val (new_tn, new_ti) = if (options.identify_islands)
        {
            // get the topological islands
            log.info ("identifyIslands")
            graph = identifyIslands (graph)

            // get the terminals keyed by equipment with equipment
            val elements = getOrElse[Element]("Elements").keyBy (_.id)
            val terms = getOrElse[Terminal].keyBy (_.ConductingEquipment).join (elements).values
            // map each graph vertex to the terminals
            val vertices = getOrElse[ConnectivityNode].map (x => (vertex_id (x.id), x))
            val td_plus = graph.vertices.join (vertices).values.filter (_._1.island != 0L).keyBy (_._2.id).leftOuterJoin (terms.keyBy (_._1.ConnectivityNode)).values
            val islands = td_plus.groupBy (_._1._1.island).values.map (to_islands)

            // create a new TopologicalIsland RDD
            val new_ti = islands.values
            if (options.debug && log.isDebugEnabled)
                log.debug (new_ti.count + " islands identified")

            // swap the old TopologicalIsland RDD for the new one
            if (!old_ti.isEmpty)
            {
                old_ti.unpersist (true)
                old_ti.name = "old_TopologicalIsland"
            }
            TopologicalIsland.subsetter.save (session.sqlContext, new_ti.asInstanceOf[TopologicalIsland.subsetter.rddtype], options.storage)

            val nodes_with_islands = graph.vertices.values.keyBy (_.island).join (islands).values
            val nodes = nodes_with_islands.groupBy (_._1.node).map (x => (x._1, x._2.head._1, Some (x._2.head._2))).map (to_nodes)
            if (options.debug && log.isDebugEnabled)
                log.debug (nodes.count + " nodes")
            (nodes, new_ti)
        }
        else
        {
            val nodes = graph.vertices.values.groupBy (_.node).map (x => (x._1, x._2.head, None)).map (to_nodes)
            if (options.debug && log.isDebugEnabled)
                log.debug (nodes.count + " nodes")
            (nodes, spark.sparkContext.emptyRDD[TopologicalIsland])
        }

        // swap the old TopologicalNode RDD for the new one
        if (!old_tn.isEmpty)
        {
            old_tn.unpersist (true)
            old_tn.name = "old_TopologicalNode"
        }
        TopologicalNode.subsetter.save (session.sqlContext, new_tn.asInstanceOf[TopologicalNode.subsetter.rddtype], options.storage)

        // but the other RDD (ConnectivityNode and Terminal also ACDCTerminal) need to be updated in IdentifiedObject and Element

        // assign every ConnectivityNode to a TopologicalNode
        val old_cn = getOrElse[ConnectivityNode]
        val new_cn = old_cn.keyBy (a => vertex_id (a.id)).leftOuterJoin (graph.vertices).values.map (update_cn)

        // swap the old ConnectivityNode RDD for the new one
        old_cn.name = "nontopological_ConnectivityNode"
        ConnectivityNode.subsetter.save (session.sqlContext, new_cn.asInstanceOf[ConnectivityNode.subsetter.rddtype], options.storage)

        // assign every Terminal with a connectivity node to a TopologicalNode
        // note: keep the original enclosed ACDCTerminal objects
        val old_terminals = getOrElse[Terminal]
        val t_with = old_terminals.filter (null != _.ConnectivityNode)
        val t_without = old_terminals.filter (null == _.ConnectivityNode)
        val new_terminals = t_with.keyBy (a => vertex_id (a.ConnectivityNode)).leftOuterJoin (graph.vertices).values.map (update_terminals)
            .union (t_without)

        // swap the old Terminal RDD for the new one
        old_terminals.name = "nontopological_Terminal"
        Terminal.subsetter.save (session.sqlContext, new_terminals.asInstanceOf[Terminal.subsetter.rddtype], options.storage)

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
        val old_idobj = getOrElse[IdentifiedObject]
        val new_idobj = old_idobj.keyBy (_.id).subtract (oldobj.keyBy (_.id)).values.union (newobj)

        // swap the old IdentifiedObject RDD for the new one
        old_idobj.name = "nontopological_IdentifiedObject"
        IdentifiedObject.subsetter.save (session.sqlContext, new_idobj.asInstanceOf[IdentifiedObject.subsetter.rddtype], options.storage)

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
        val old_elements = getOrElse[Element]("Elements")
        val new_elements = old_elements.keyBy (_.id).subtract (oldelem.keyBy (_.id)).values.union (newelem)

        // swap the old Elements RDD for the new one
        old_elements.name = "nontopological_Elements"
        new_elements.name = "Elements"
        new_elements.persist (options.storage)
        if (spark.sparkContext.getCheckpointDir.isDefined) new_elements.checkpoint ()
        val schema = Encoders.product[dummy].schema
        val data_frame = spark.sqlContext.createDataFrame (new_elements.asInstanceOf[RDD[Row]], schema)
        data_frame.createOrReplaceTempView ("Elements")

        new_elements
    }

    /**
     * Old processIfNeeded() method.
     * @deprecated ("Use the method taking a CIMTopologyOptions", "3.0.3")
     * @param identify_islands pass <code>true</code> if the TopologicalIsland RDD should be populated.
     */
    def processIfNeeded (identify_islands: Boolean): RDD[Element] = processIfNeeded (options.copy (identify_islands = identify_islands))

    /**
     * Conditionally create new TopologicalNode and optionally TopologicalIsland RDD based on connectivity.
     *
     * Note, if these RDD exist and are already populated, this method does nothing.
     * Otherwise it calls the [[process(_options:ch\.ninecode\.cim\.CIMTopologyOptions)* process]] method.
     *
     * @return Either the old Elements RDD or a new Elements RDD - with TopologicalNode and TopologicalIsland objects included.
     */
    def processIfNeeded (_options: CIMTopologyOptions): RDD[Element] =
    {
        val nodes = getOrElse[TopologicalNode]
        if (nodes.isEmpty)
            process (_options)
        else
        {
            val islands = getOrElse[TopologicalIsland]
            if (_options.identify_islands && islands.isEmpty)
                process (_options)
            else
                get [Element]("Elements")
        }
    }
}
