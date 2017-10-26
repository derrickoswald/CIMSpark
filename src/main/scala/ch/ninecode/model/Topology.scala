package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Used to apply user standard names to topology buses.
 *
 * Typically used for "bus/branch" case generation. Associated with one or more terminals that are normally connected with the bus name.    The associated terminals are normally connected by non-retained switches. For a ring bus station configuration, all busbar terminals in the ring are typically associated.   For a breaker and a half scheme, both busbars would normally be associated.  For a ring bus, all busbars would normally be associated.  For a "straight" busbar configuration, normally only the main terminal at the busbar would be associated.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param priority Priority of bus name marker for use as topology bus name.
 *        Use 0 for don t care.  Use 1 for highest priority.  Use 2 as priority is less than 1 and so on.
 * @param ReportingGroup [[ch.ninecode.model.ReportingGroup ReportingGroup]] The reporting group to which this bus name marker belongs.
 * @group Topology
 * @groupname Topology Package Topology
 * @groupdesc Topology An extension to the Core Package that in association with the Terminal class models Connectivity, that is the physical definition of how equipment is connected together. In addition it models Topology, that is the logical definition of how equipment is connected via closed switches. The Topology definition is independent of the other electrical characteristics.
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
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = BusNameMarker.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (BusNameMarker.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (BusNameMarker.fields (position), value)
        emitelem (0, priority)
        emitattr (1, ReportingGroup)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:BusNameMarker rdf:ID=\"%s\">\n%s\t</cim:BusNameMarker>".format (id, export_fields)
    }
}

object BusNameMarker
extends
    Parseable[BusNameMarker]
{
    val fields: Array[String] = Array[String] (
        "priority",
        "ReportingGroup"
    )
    val priority: Fielder = parse_element (element (cls, fields(0)))
    val ReportingGroup: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): BusNameMarker =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = BusNameMarker (
            IdentifiedObject.parse (context),
            toInteger (mask (priority (), 0)),
            mask (ReportingGroup (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ReportingGroup", "ReportingGroup", false)
    )
}

/**
 * DC bus.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param DCEquipmentContainer [[ch.ninecode.model.DCEquipmentContainer DCEquipmentContainer]] <em>undocumented</em>
 * @param DCTopologicalIsland [[ch.ninecode.model.DCTopologicalIsland DCTopologicalIsland]] <em>undocumented</em>
 * @group Topology
 * @groupname Topology Package Topology
 * @groupdesc Topology An extension to the Core Package that in association with the Terminal class models Connectivity, that is the physical definition of how equipment is connected together. In addition it models Topology, that is the logical definition of how equipment is connected via closed switches. The Topology definition is independent of the other electrical characteristics.
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
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = DCTopologicalNode.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DCTopologicalNode.fields (position), value)
        emitattr (0, DCEquipmentContainer)
        emitattr (1, DCTopologicalIsland)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DCTopologicalNode rdf:ID=\"%s\">\n%s\t</cim:DCTopologicalNode>".format (id, export_fields)
    }
}

object DCTopologicalNode
extends
    Parseable[DCTopologicalNode]
{
    val fields: Array[String] = Array[String] (
        "DCEquipmentContainer",
        "DCTopologicalIsland"
    )
    val DCEquipmentContainer: Fielder = parse_attribute (attribute (cls, fields(0)))
    val DCTopologicalIsland: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): DCTopologicalNode =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = DCTopologicalNode (
            IdentifiedObject.parse (context),
            mask (DCEquipmentContainer (), 0),
            mask (DCTopologicalIsland (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("DCEquipmentContainer", "DCEquipmentContainer", false),
        Relationship ("DCTopologicalIsland", "DCTopologicalIsland", false)
    )
}

/**
 * An electrically connected subset of the network.
 *
 * Topological islands can change as the current network state changes: e.g. due to
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param AngleRefTopologicalNode [[ch.ninecode.model.TopologicalNode TopologicalNode]] The angle reference for the island.
 *        Normally there is one TopologicalNode that is selected as the angle reference for each island.   Other reference schemes exist, so the association is typically optional.
 * @group Topology
 * @groupname Topology Package Topology
 * @groupdesc Topology An extension to the Core Package that in association with the Terminal class models Connectivity, that is the physical definition of how equipment is connected together. In addition it models Topology, that is the logical definition of how equipment is connected via closed switches. The Topology definition is independent of the other electrical characteristics.
 */
case class TopologicalIsland
(
    override val sup: IdentifiedObject,
    AngleRefTopologicalNode: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TopologicalIsland.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TopologicalIsland.fields (position), value)
        emitattr (0, AngleRefTopologicalNode)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TopologicalIsland rdf:ID=\"%s\">\n%s\t</cim:TopologicalIsland>".format (id, export_fields)
    }
}

object TopologicalIsland
extends
    Parseable[TopologicalIsland]
{
    val fields: Array[String] = Array[String] (
        "AngleRefTopologicalNode"
    )
    val AngleRefTopologicalNode: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): TopologicalIsland =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = TopologicalIsland (
            IdentifiedObject.parse (context),
            mask (AngleRefTopologicalNode (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("AngleRefTopologicalNode", "TopologicalNode", false)
    )
}

/**
 * For a detailed substation model a topological node is a set of connectivity nodes that, in the current network state, are connected together through any type of closed switches, including  jumpers.
 *
 * Topological nodes change as the current network state changes (i.e., switches, breakers, etc. change state).
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param pInjection The active power injected into the bus at this location in addition to injections from equipment.
 *        Positive sign means injection into the TopologicalNode (bus).
 * @param qInjection The reactive power injected into the bus at this location in addition to injections from equipment.
 *        Positive sign means injection into the TopologicalNode (bus).
 * @param AngleRefTopologicalIsland [[ch.ninecode.model.TopologicalIsland TopologicalIsland]] The island for which the node is an angle reference.
 *        Normally there is one angle reference node for each island.
 * @param BaseVoltage [[ch.ninecode.model.BaseVoltage BaseVoltage]] The base voltage of the topologocial node.
 * @param ConnectivityNodeContainer [[ch.ninecode.model.ConnectivityNodeContainer ConnectivityNodeContainer]] The connectivity node container to which the toplogical node belongs.
 * @param ReportingGroup [[ch.ninecode.model.ReportingGroup ReportingGroup]] The reporting group to which the topological node belongs.
 * @param SvInjection [[ch.ninecode.model.SvInjection SvInjection]] The injection flows state variables associated with the topological node.
 * @param SvVoltage [[ch.ninecode.model.SvVoltage SvVoltage]] The state voltage associated with the topological node.
 * @param TopologicalIsland [[ch.ninecode.model.TopologicalIsland TopologicalIsland]] A topological node belongs to a topological island.
 * @group Topology
 * @groupname Topology Package Topology
 * @groupdesc Topology An extension to the Core Package that in association with the Terminal class models Connectivity, that is the physical definition of how equipment is connected together. In addition it models Topology, that is the logical definition of how equipment is connected via closed switches. The Topology definition is independent of the other electrical characteristics.
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
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, null, null, null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TopologicalNode.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TopologicalNode.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TopologicalNode.fields (position), value)
        emitelem (0, pInjection)
        emitelem (1, qInjection)
        emitattr (2, AngleRefTopologicalIsland)
        emitattr (3, BaseVoltage)
        emitattr (4, ConnectivityNodeContainer)
        emitattr (5, ReportingGroup)
        emitattr (6, SvInjection)
        emitattr (7, SvVoltage)
        emitattr (8, TopologicalIsland)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TopologicalNode rdf:ID=\"%s\">\n%s\t</cim:TopologicalNode>".format (id, export_fields)
    }
}

object TopologicalNode
extends
    Parseable[TopologicalNode]
{
    val fields: Array[String] = Array[String] (
        "pInjection",
        "qInjection",
        "AngleRefTopologicalIsland",
        "BaseVoltage",
        "ConnectivityNodeContainer",
        "ReportingGroup",
        "SvInjection",
        "SvVoltage",
        "TopologicalIsland"
    )
    val pInjection: Fielder = parse_element (element (cls, fields(0)))
    val qInjection: Fielder = parse_element (element (cls, fields(1)))
    val AngleRefTopologicalIsland: Fielder = parse_attribute (attribute (cls, fields(2)))
    val BaseVoltage: Fielder = parse_attribute (attribute (cls, fields(3)))
    val ConnectivityNodeContainer: Fielder = parse_attribute (attribute (cls, fields(4)))
    val ReportingGroup: Fielder = parse_attribute (attribute (cls, fields(5)))
    val SvInjection: Fielder = parse_attribute (attribute (cls, fields(6)))
    val SvVoltage: Fielder = parse_attribute (attribute (cls, fields(7)))
    val TopologicalIsland: Fielder = parse_attribute (attribute (cls, fields(8)))

    def parse (context: Context): TopologicalNode =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = TopologicalNode (
            IdentifiedObject.parse (context),
            toDouble (mask (pInjection (), 0)),
            toDouble (mask (qInjection (), 1)),
            mask (AngleRefTopologicalIsland (), 2),
            mask (BaseVoltage (), 3),
            mask (ConnectivityNodeContainer (), 4),
            mask (ReportingGroup (), 5),
            mask (SvInjection (), 6),
            mask (SvVoltage (), 7),
            mask (TopologicalIsland (), 8)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("AngleRefTopologicalIsland", "TopologicalIsland", false),
        Relationship ("BaseVoltage", "BaseVoltage", false),
        Relationship ("ConnectivityNodeContainer", "ConnectivityNodeContainer", false),
        Relationship ("ReportingGroup", "ReportingGroup", false),
        Relationship ("SvInjection", "SvInjection", false),
        Relationship ("SvVoltage", "SvVoltage", false),
        Relationship ("TopologicalIsland", "TopologicalIsland", false)
    )
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