package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

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
    override val sup: IdentifiedObject,
    priority: Int,
    ReportingGroup: String
)
extends
    Element
{
    def this () = { this (null, 0, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[BusNameMarker] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        "\t\t<cim:BusNameMarker.priority>" + priority + "</cim:BusNameMarker.priority>\n" +
        (if (null != ReportingGroup) "\t\t<cim:BusNameMarker.ReportingGroup rdf:resource=\"#" + ReportingGroup + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:BusNameMarker rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:BusNameMarker>"
    }
}

object BusNameMarker
extends
    Parseable[BusNameMarker]
{
    val priority: (Context) => String = parse_element (element ("""BusNameMarker.priority"""))
    val ReportingGroup: (Context) => String = parse_attribute (attribute ("""BusNameMarker.ReportingGroup"""))
    def parse (context: Context): BusNameMarker =
    {
        BusNameMarker(
            IdentifiedObject.parse (context),
            toInteger (priority (context), context),
            ReportingGroup (context)
        )
    }
}

/**
 * DC bus.
 * @param sup Reference to the superclass object.
 * @param DCEquipmentContainer <em>undocumented</em>
 * @param DCTopologicalIsland <em>undocumented</em>
 */
case class DCTopologicalNode
(
    override val sup: IdentifiedObject,
    DCEquipmentContainer: String,
    DCTopologicalIsland: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[DCTopologicalNode] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != DCEquipmentContainer) "\t\t<cim:DCTopologicalNode.DCEquipmentContainer rdf:resource=\"#" + DCEquipmentContainer + "\"/>\n" else "") +
        (if (null != DCTopologicalIsland) "\t\t<cim:DCTopologicalNode.DCTopologicalIsland rdf:resource=\"#" + DCTopologicalIsland + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:DCTopologicalNode rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DCTopologicalNode>"
    }
}

object DCTopologicalNode
extends
    Parseable[DCTopologicalNode]
{
    val DCEquipmentContainer: (Context) => String = parse_attribute (attribute ("""DCTopologicalNode.DCEquipmentContainer"""))
    val DCTopologicalIsland: (Context) => String = parse_attribute (attribute ("""DCTopologicalNode.DCTopologicalIsland"""))
    def parse (context: Context): DCTopologicalNode =
    {
        DCTopologicalNode(
            IdentifiedObject.parse (context),
            DCEquipmentContainer (context),
            DCTopologicalIsland (context)
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
    override val sup: IdentifiedObject,
    AngleRefTopologicalNode: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[TopologicalIsland] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != AngleRefTopologicalNode) "\t\t<cim:TopologicalIsland.AngleRefTopologicalNode rdf:resource=\"#" + AngleRefTopologicalNode + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TopologicalIsland rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TopologicalIsland>"
    }
}

object TopologicalIsland
extends
    Parseable[TopologicalIsland]
{
    val AngleRefTopologicalNode: (Context) => String = parse_attribute (attribute ("""TopologicalIsland.AngleRefTopologicalNode"""))
    def parse (context: Context): TopologicalIsland =
    {
        TopologicalIsland(
            IdentifiedObject.parse (context),
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
    override val sup: IdentifiedObject,
    pInjection: Double,
    qInjection: Double,
    AngleRefTopologicalIsland: String,
    BaseVoltage: String,
    ConnectivityNodeContainer: String,
    ReportingGroup: String,
    SvInjection: String,
    SvVoltage: String,
    TopologicalIsland: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null, null, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[TopologicalNode] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        "\t\t<cim:TopologicalNode.pInjection>" + pInjection + "</cim:TopologicalNode.pInjection>\n" +
        "\t\t<cim:TopologicalNode.qInjection>" + qInjection + "</cim:TopologicalNode.qInjection>\n" +
        (if (null != AngleRefTopologicalIsland) "\t\t<cim:TopologicalNode.AngleRefTopologicalIsland rdf:resource=\"#" + AngleRefTopologicalIsland + "\"/>\n" else "") +
        (if (null != BaseVoltage) "\t\t<cim:TopologicalNode.BaseVoltage rdf:resource=\"#" + BaseVoltage + "\"/>\n" else "") +
        (if (null != ConnectivityNodeContainer) "\t\t<cim:TopologicalNode.ConnectivityNodeContainer rdf:resource=\"#" + ConnectivityNodeContainer + "\"/>\n" else "") +
        (if (null != ReportingGroup) "\t\t<cim:TopologicalNode.ReportingGroup rdf:resource=\"#" + ReportingGroup + "\"/>\n" else "") +
        (if (null != SvInjection) "\t\t<cim:TopologicalNode.SvInjection rdf:resource=\"#" + SvInjection + "\"/>\n" else "") +
        (if (null != SvVoltage) "\t\t<cim:TopologicalNode.SvVoltage rdf:resource=\"#" + SvVoltage + "\"/>\n" else "") +
        (if (null != TopologicalIsland) "\t\t<cim:TopologicalNode.TopologicalIsland rdf:resource=\"#" + TopologicalIsland + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TopologicalNode rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TopologicalNode>"
    }
}

object TopologicalNode
extends
    Parseable[TopologicalNode]
{
    val pInjection: (Context) => String = parse_element (element ("""TopologicalNode.pInjection"""))
    val qInjection: (Context) => String = parse_element (element ("""TopologicalNode.qInjection"""))
    val AngleRefTopologicalIsland: (Context) => String = parse_attribute (attribute ("""TopologicalNode.AngleRefTopologicalIsland"""))
    val BaseVoltage: (Context) => String = parse_attribute (attribute ("""TopologicalNode.BaseVoltage"""))
    val ConnectivityNodeContainer: (Context) => String = parse_attribute (attribute ("""TopologicalNode.ConnectivityNodeContainer"""))
    val ReportingGroup: (Context) => String = parse_attribute (attribute ("""TopologicalNode.ReportingGroup"""))
    val SvInjection: (Context) => String = parse_attribute (attribute ("""TopologicalNode.SvInjection"""))
    val SvVoltage: (Context) => String = parse_attribute (attribute ("""TopologicalNode.SvVoltage"""))
    val TopologicalIsland: (Context) => String = parse_attribute (attribute ("""TopologicalNode.TopologicalIsland"""))
    def parse (context: Context): TopologicalNode =
    {
        TopologicalNode(
            IdentifiedObject.parse (context),
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

private[ninecode] object _Topology
{
    def register: List[ClassInfo] =
    {
        List (
            BusNameMarker.register,
            DCTopologicalNode.register,
            TopologicalIsland.register,
            TopologicalNode.register
        )
    }
}