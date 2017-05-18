package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * An extension to the Core Package that in association with the Terminal class models Connectivity, that is the physical definition of how equipment is connected together.
 * In addition it models Topology, that is the logical definition of how equipment is connected via closed switches. The Topology definition is independent of the other electrical characteristics.
 */

/**
 * Used to apply user standard names to topology buses.
 * Typically used for "bus/branch" case generation. Associated with one or more terminals that are normally connected with the bus name.    The associated terminals are normally connected by non-retained switches. For a ring bus station configuration, all busbar terminals in the ring are typically associated.   For a breaker and a half scheme, both busbars would normally be associated.  For a ring bus, all busbars would normally be associated.  For a "straight" busbar configuration, normally only the main terminal at the busbar would be associated.
 * @param sup Reference to the superclass object.
 * @param priority Priority of bus name marker for use as topology bus name.
 *        Use 0 for don t care.  Use 1 for highest priority.  Use 2 as priority is less than 1 and so on.
 * @param ReportingGroup The reporting group to which this bus name marker belongs.
 */
case class BusNameMarker
(
    override val sup: Element,
    val priority: Int,
    val ReportingGroup: String
)
extends
    Element
{
    def this () = { this (null, 0, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[BusNameMarker]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BusNameMarker
extends
    Parseable[BusNameMarker]
{
    val sup = IdentifiedObject.parse _
    val priority = parse_element (element ("""BusNameMarker.priority"""))_
    val ReportingGroup = parse_attribute (attribute ("""BusNameMarker.ReportingGroup"""))_
    def parse (context: Context): BusNameMarker =
    {
        BusNameMarker(
            sup (context),
            toInteger (priority (context), context),
            ReportingGroup (context)
        )
    }
}

/**
 * DC bus.
 * @param sup Reference to the superclass object.
 * @param DCEquipmentContainer
 */
case class DCTopologicalNode
(
    override val sup: Element,
    val DCEquipmentContainer: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[DCTopologicalNode]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DCTopologicalNode
extends
    Parseable[DCTopologicalNode]
{
    val sup = IdentifiedObject.parse _
    val DCEquipmentContainer = parse_attribute (attribute ("""DCTopologicalNode.DCEquipmentContainer"""))_
    def parse (context: Context): DCTopologicalNode =
    {
        DCTopologicalNode(
            sup (context),
            DCEquipmentContainer (context)
        )
    }
}

/**
 * An electrically connected subset of the network.
 * Topological islands can change as the current network state changes: e.g. due to
 * @param sup Reference to the superclass object.
 * @param AngleRefTopologicalNode The angle reference for the island.
 *        Normally there is one TopologicalNode that is selected as the angle reference for each island.   Other reference schemes exist, so the association is typically optional.
 */
case class TopologicalIsland
(
    override val sup: Element,
    val AngleRefTopologicalNode: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[TopologicalIsland]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TopologicalIsland
extends
    Parseable[TopologicalIsland]
{
    val sup = IdentifiedObject.parse _
    val AngleRefTopologicalNode = parse_attribute (attribute ("""TopologicalIsland.AngleRefTopologicalNode"""))_
    def parse (context: Context): TopologicalIsland =
    {
        TopologicalIsland(
            sup (context),
            AngleRefTopologicalNode (context)
        )
    }
}

/**
 * For a detailed substation model a topological node is a set of connectivity nodes that, in the current network state, are connected together through any type of closed switches, including  jumpers.
 * Topological nodes change as the current network state changes (i.e., switches, breakers, etc. change state).
 * @param sup Reference to the superclass object.
 * @param pInjection The active power injected into the bus at this location in addition to injections from equipment.
 *        Positive sign means injection into the TopologicalNode (bus).
 * @param qInjection The reactive power injected into the bus at this location in addition to injections from equipment.
 *        Positive sign means injection into the TopologicalNode (bus).
 * @param AngleRefTopologicalIsland The island for which the node is an angle reference.
 *        Normally there is one angle reference node for each island.
 * @param BaseVoltage The base voltage of the topologocial node.
 * @param ConnectivityNodeContainer The connectivity node container to which the toplogical node belongs.
 * @param ReportingGroup The reporting group to which the topological node belongs.
 * @param SvInjection The injection flows state variables associated with the topological node.
 * @param SvVoltage The state voltage associated with the topological node.
 * @param TopologicalIsland A topological node belongs to a topological island.
 */
case class TopologicalNode
(
    override val sup: Element,
    val pInjection: Double,
    val qInjection: Double,
    val AngleRefTopologicalIsland: String,
    val BaseVoltage: String,
    val ConnectivityNodeContainer: String,
    val ReportingGroup: String,
    val SvInjection: String,
    val SvVoltage: String,
    val TopologicalIsland: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null, null, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[TopologicalNode]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TopologicalNode
extends
    Parseable[TopologicalNode]
{
    val sup = IdentifiedObject.parse _
    val pInjection = parse_element (element ("""TopologicalNode.pInjection"""))_
    val qInjection = parse_element (element ("""TopologicalNode.qInjection"""))_
    val AngleRefTopologicalIsland = parse_attribute (attribute ("""TopologicalNode.AngleRefTopologicalIsland"""))_
    val BaseVoltage = parse_attribute (attribute ("""TopologicalNode.BaseVoltage"""))_
    val ConnectivityNodeContainer = parse_attribute (attribute ("""TopologicalNode.ConnectivityNodeContainer"""))_
    val ReportingGroup = parse_attribute (attribute ("""TopologicalNode.ReportingGroup"""))_
    val SvInjection = parse_attribute (attribute ("""TopologicalNode.SvInjection"""))_
    val SvVoltage = parse_attribute (attribute ("""TopologicalNode.SvVoltage"""))_
    val TopologicalIsland = parse_attribute (attribute ("""TopologicalNode.TopologicalIsland"""))_
    def parse (context: Context): TopologicalNode =
    {
        TopologicalNode(
            sup (context),
            toDouble (pInjection (context), context),
            toDouble (qInjection (context), context),
            AngleRefTopologicalIsland (context),
            BaseVoltage (context),
            ConnectivityNodeContainer (context),
            ReportingGroup (context),
            SvInjection (context),
            SvVoltage (context),
            TopologicalIsland (context)
        )
    }
}

object _Topology
{
    def register: Unit =
    {
        BusNameMarker.register
        DCTopologicalNode.register
        TopologicalIsland.register
        TopologicalNode.register
    }
}