package ch.ninecode.model

import com.esotericsoftware.kryo.Kryo
import com.esotericsoftware.kryo.Serializer
import com.esotericsoftware.kryo.io.Input
import com.esotericsoftware.kryo.io.Output
import org.apache.spark.sql.Row

import ch.ninecode.cim.CIMClassInfo
import ch.ninecode.cim.CIMContext
import ch.ninecode.cim.CIMParseable
import ch.ninecode.cim.CIMRelationship
import ch.ninecode.cim.CIMSerializer

/**
 * Used to apply user standard names to TopologicalNodes.
 *
 * Associated with one or more terminals that are normally connected with the bus name.    The associated terminals are normally connected by non-retained switches. For a ring bus station configuration, all BusbarSection terminals in the ring are typically associated.   For a breaker and a half scheme, both BusbarSections would normally be associated.  For a ring bus, all BusbarSections would normally be associated.  For a "straight" busbar configuration, normally only the main terminal at the BusbarSection would be associated.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param priority         Priority of bus name marker for use as topology bus name.
 *                         Use 0 for do not care.  Use 1 for highest priority.  Use 2 as priority is less than 1 and so on.
 * @param ReportingGroup   [[ch.ninecode.model.ReportingGroup ReportingGroup]] The reporting group to which this bus name marker belongs.
 * @param Terminal         [[ch.ninecode.model.ACDCTerminal ACDCTerminal]] The terminals associated with this bus name marker.
 * @param TopologicalNode  [[ch.ninecode.model.TopologicalNode TopologicalNode]] A user defined topological node that was originally defined in a planning model not yet having topology described by ConnectivityNodes.
 *                         Once ConnectivityNodes has been created they may linked to user defined ToplogicalNdes using BusNameMarkers.
 * @group Topology
 * @groupname Topology Package Topology
 * @groupdesc Topology An extension to the Core Package that, in association with the Terminal class, models Connectivity, that is the physical definition of how equipment is connected together. In addition it models Topology, that is the logical definition of how equipment is connected via closed switches. The Topology definition is independent of the other electrical characteristics.
 */
final case class BusNameMarker
(
    IdentifiedObject: IdentifiedObject = null,
    priority: Int = 0,
    ReportingGroup: String = null,
    Terminal: List[String] = null,
    TopologicalNode: String = null
)
    extends
        Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: IdentifiedObject = IdentifiedObject

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row =
    {
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = BusNameMarker.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(BusNameMarker.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(BusNameMarker.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(BusNameMarker.fields(position), x))

        emitelem(0, priority)
        emitattr(1, ReportingGroup)
        emitattrs(2, Terminal)
        emitattr(3, TopologicalNode)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:BusNameMarker rdf:%s=\"%s\">\n%s\t</cim:BusNameMarker>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object BusNameMarker
    extends
        CIMParseable[BusNameMarker]
{
    override val fields: Array[String] = Array[String](
        "priority",
        "ReportingGroup",
        "Terminal",
        "TopologicalNode"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("ReportingGroup", "ReportingGroup", "0..1", "0..*"),
        CIMRelationship("Terminal", "ACDCTerminal", "1..*", "0..1"),
        CIMRelationship("TopologicalNode", "TopologicalNode", "0..1", "0..*")
    )
    val priority: Fielder = parse_element(element(cls, fields(0)))
    val ReportingGroup: Fielder = parse_attribute(attribute(cls, fields(1)))
    val Terminal: FielderMultiple = parse_attributes(attribute(cls, fields(2)))
    val TopologicalNode: Fielder = parse_attribute(attribute(cls, fields(3)))

    def parse (context: CIMContext): BusNameMarker =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = BusNameMarker(
            IdentifiedObject.parse(context),
            toInteger(mask(priority(), 0)),
            mask(ReportingGroup(), 1),
            masks(Terminal(), 2),
            mask(TopologicalNode(), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[BusNameMarker] = BusNameMarkerSerializer
}

object BusNameMarkerSerializer extends CIMSerializer[BusNameMarker]
{
    def write (kryo: Kryo, output: Output, obj: BusNameMarker): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeInt(obj.priority),
            () => output.writeString(obj.ReportingGroup),
            () => writeList(obj.Terminal, output),
            () => output.writeString(obj.TopologicalNode)
        )
        IdentifiedObjectSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[BusNameMarker]): BusNameMarker =
    {
        val parent = IdentifiedObjectSerializer.read(kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = BusNameMarker(
            parent,
            if (isSet(0)) input.readInt else 0,
            if (isSet(1)) input.readString else null,
            if (isSet(2)) readList(input) else null,
            if (isSet(3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * An electrically connected subset of the network.
 *
 * Topological islands can change as the current network state changes, e.g. due to:
 * - disconnect switches or breakers changing state in a SCADA/EMS.
 * - manual creation, change or deletion of topological nodes in a planning tool.
 * Only energised TopologicalNode-s shall be part of the topological island.
 *
 * @param IdentifiedObject        [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param AngleRefTopologicalNode [[ch.ninecode.model.TopologicalNode TopologicalNode]] The angle reference for the island.
 *                                Normally there is one TopologicalNode that is selected as the angle reference for each island.   Other reference schemes exist, so the association is typically optional.
 * @param TopologicalNodes        [[ch.ninecode.model.TopologicalNode TopologicalNode]] A topological node belongs to a topological island.
 * @group Topology
 * @groupname Topology Package Topology
 * @groupdesc Topology An extension to the Core Package that, in association with the Terminal class, models Connectivity, that is the physical definition of how equipment is connected together. In addition it models Topology, that is the logical definition of how equipment is connected via closed switches. The Topology definition is independent of the other electrical characteristics.
 */
final case class TopologicalIsland
(
    IdentifiedObject: IdentifiedObject = null,
    AngleRefTopologicalNode: String = null,
    TopologicalNodes: List[String] = null
)
    extends
        Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: IdentifiedObject = IdentifiedObject

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row =
    {
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = TopologicalIsland.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(TopologicalIsland.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(TopologicalIsland.fields(position), x))

        emitattr(0, AngleRefTopologicalNode)
        emitattrs(1, TopologicalNodes)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:TopologicalIsland rdf:%s=\"%s\">\n%s\t</cim:TopologicalIsland>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object TopologicalIsland
    extends
        CIMParseable[TopologicalIsland]
{
    override val fields: Array[String] = Array[String](
        "AngleRefTopologicalNode",
        "TopologicalNodes"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("AngleRefTopologicalNode", "TopologicalNode", "0..1", "0..1"),
        CIMRelationship("TopologicalNodes", "TopologicalNode", "1..*", "0..1")
    )
    val AngleRefTopologicalNode: Fielder = parse_attribute(attribute(cls, fields(0)))
    val TopologicalNodes: FielderMultiple = parse_attributes(attribute(cls, fields(1)))

    def parse (context: CIMContext): TopologicalIsland =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TopologicalIsland(
            IdentifiedObject.parse(context),
            mask(AngleRefTopologicalNode(), 0),
            masks(TopologicalNodes(), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[TopologicalIsland] = TopologicalIslandSerializer
}

object TopologicalIslandSerializer extends CIMSerializer[TopologicalIsland]
{
    def write (kryo: Kryo, output: Output, obj: TopologicalIsland): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.AngleRefTopologicalNode),
            () => writeList(obj.TopologicalNodes, output)
        )
        IdentifiedObjectSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TopologicalIsland]): TopologicalIsland =
    {
        val parent = IdentifiedObjectSerializer.read(kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = TopologicalIsland(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * For a detailed substation model a topological node is a set of connectivity nodes that, in the current network state, are connected together through any type of closed switches, including  jumpers.
 *
 * Topological nodes change as the current network state changes (i.e., switches, breakers, etc. change state).
 * For a planning model, switch statuses are not used to form topological nodes. Instead they are manually created or deleted in a model builder tool. Topological nodes maintained this way are also called "busses".
 *
 * @param IdentifiedObject          [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param pInjection                The active power injected into the bus at this location in addition to injections from equipment.
 *                                  Positive sign means injection into the TopologicalNode (bus).
 *                                  Starting value for a steady state solution.
 * @param qInjection                The reactive power injected into the bus at this location in addition to injections from equipment.
 *                                  Positive sign means injection into the TopologicalNode (bus).
 *                                  Starting value for a steady state solution.
 * @param AngleRefTopologicalIsland [[ch.ninecode.model.TopologicalIsland TopologicalIsland]] The island for which the node is an angle reference.
 *                                  Normally there is one angle reference node for each island.
 * @param BaseVoltage               [[ch.ninecode.model.BaseVoltage BaseVoltage]] The base voltage of the topological node.
 * @param BusNameMarker             [[ch.ninecode.model.BusNameMarker BusNameMarker]] BusnameMarkers that may refer to a pre defined TopologicalNode.
 * @param ConnectivityNodeContainer [[ch.ninecode.model.ConnectivityNodeContainer ConnectivityNodeContainer]] The connectivity node container to which the topological node belongs.
 * @param ConnectivityNodes         [[ch.ninecode.model.ConnectivityNode ConnectivityNode]] The connectivity nodes combine together to form this topological node.
 *                                  May depend on the current state of switches in the network.
 * @param ReportingGroup            [[ch.ninecode.model.ReportingGroup ReportingGroup]] The reporting group to which the topological node belongs.
 * @param SvInjection               [[ch.ninecode.model.SvInjection SvInjection]] The injection flows state variables associated with the topological node.
 * @param SvVoltage                 [[ch.ninecode.model.SvVoltage SvVoltage]] The state voltage associated with the topological node.
 * @param Terminal                  [[ch.ninecode.model.Terminal Terminal]] The terminals associated with the topological node.
 *                                  This can be used as an alternative to the connectivity node path to terminal, thus making it unnecessary to model connectivity nodes in some cases.   Note that if connectivity nodes are in the model, this association would probably not be used as an input specification.
 * @param TopologicalIsland         [[ch.ninecode.model.TopologicalIsland TopologicalIsland]] A topological node belongs to a topological island.
 * @group Topology
 * @groupname Topology Package Topology
 * @groupdesc Topology An extension to the Core Package that, in association with the Terminal class, models Connectivity, that is the physical definition of how equipment is connected together. In addition it models Topology, that is the logical definition of how equipment is connected via closed switches. The Topology definition is independent of the other electrical characteristics.
 */
final case class TopologicalNode
(
    IdentifiedObject: IdentifiedObject = null,
    pInjection: Double = 0.0,
    qInjection: Double = 0.0,
    AngleRefTopologicalIsland: String = null,
    BaseVoltage: String = null,
    BusNameMarker: List[String] = null,
    ConnectivityNodeContainer: String = null,
    ConnectivityNodes: List[String] = null,
    ReportingGroup: String = null,
    SvInjection: List[String] = null,
    SvVoltage: List[String] = null,
    Terminal: List[String] = null,
    TopologicalIsland: String = null
)
    extends
        Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: IdentifiedObject = IdentifiedObject

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row =
    {
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = TopologicalNode.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(TopologicalNode.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(TopologicalNode.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(TopologicalNode.fields(position), x))

        emitelem(0, pInjection)
        emitelem(1, qInjection)
        emitattr(2, AngleRefTopologicalIsland)
        emitattr(3, BaseVoltage)
        emitattrs(4, BusNameMarker)
        emitattr(5, ConnectivityNodeContainer)
        emitattrs(6, ConnectivityNodes)
        emitattr(7, ReportingGroup)
        emitattrs(8, SvInjection)
        emitattrs(9, SvVoltage)
        emitattrs(10, Terminal)
        emitattr(11, TopologicalIsland)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:TopologicalNode rdf:%s=\"%s\">\n%s\t</cim:TopologicalNode>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object TopologicalNode
    extends
        CIMParseable[TopologicalNode]
{
    override val fields: Array[String] = Array[String](
        "pInjection",
        "qInjection",
        "AngleRefTopologicalIsland",
        "BaseVoltage",
        "BusNameMarker",
        "ConnectivityNodeContainer",
        "ConnectivityNodes",
        "ReportingGroup",
        "SvInjection",
        "SvVoltage",
        "Terminal",
        "TopologicalIsland"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("AngleRefTopologicalIsland", "TopologicalIsland", "0..1", "0..1"),
        CIMRelationship("BaseVoltage", "BaseVoltage", "0..1", "0..*"),
        CIMRelationship("BusNameMarker", "BusNameMarker", "0..*", "0..1"),
        CIMRelationship("ConnectivityNodeContainer", "ConnectivityNodeContainer", "0..1", "0..*"),
        CIMRelationship("ConnectivityNodes", "ConnectivityNode", "0..*", "0..1"),
        CIMRelationship("ReportingGroup", "ReportingGroup", "0..1", "0..*"),
        CIMRelationship("SvInjection", "SvInjection", "0..*", "1"),
        CIMRelationship("SvVoltage", "SvVoltage", "0..*", "1"),
        CIMRelationship("Terminal", "Terminal", "0..*", "0..1"),
        CIMRelationship("TopologicalIsland", "TopologicalIsland", "0..1", "1..*")
    )
    val pInjection: Fielder = parse_element(element(cls, fields(0)))
    val qInjection: Fielder = parse_element(element(cls, fields(1)))
    val AngleRefTopologicalIsland: Fielder = parse_attribute(attribute(cls, fields(2)))
    val BaseVoltage: Fielder = parse_attribute(attribute(cls, fields(3)))
    val BusNameMarker: FielderMultiple = parse_attributes(attribute(cls, fields(4)))
    val ConnectivityNodeContainer: Fielder = parse_attribute(attribute(cls, fields(5)))
    val ConnectivityNodes: FielderMultiple = parse_attributes(attribute(cls, fields(6)))
    val ReportingGroup: Fielder = parse_attribute(attribute(cls, fields(7)))
    val SvInjection: FielderMultiple = parse_attributes(attribute(cls, fields(8)))
    val SvVoltage: FielderMultiple = parse_attributes(attribute(cls, fields(9)))
    val Terminal: FielderMultiple = parse_attributes(attribute(cls, fields(10)))
    val TopologicalIsland: Fielder = parse_attribute(attribute(cls, fields(11)))

    def parse (context: CIMContext): TopologicalNode =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TopologicalNode(
            IdentifiedObject.parse(context),
            toDouble(mask(pInjection(), 0)),
            toDouble(mask(qInjection(), 1)),
            mask(AngleRefTopologicalIsland(), 2),
            mask(BaseVoltage(), 3),
            masks(BusNameMarker(), 4),
            mask(ConnectivityNodeContainer(), 5),
            masks(ConnectivityNodes(), 6),
            mask(ReportingGroup(), 7),
            masks(SvInjection(), 8),
            masks(SvVoltage(), 9),
            masks(Terminal(), 10),
            mask(TopologicalIsland(), 11)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[TopologicalNode] = TopologicalNodeSerializer
}

object TopologicalNodeSerializer extends CIMSerializer[TopologicalNode]
{
    def write (kryo: Kryo, output: Output, obj: TopologicalNode): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeDouble(obj.pInjection),
            () => output.writeDouble(obj.qInjection),
            () => output.writeString(obj.AngleRefTopologicalIsland),
            () => output.writeString(obj.BaseVoltage),
            () => writeList(obj.BusNameMarker, output),
            () => output.writeString(obj.ConnectivityNodeContainer),
            () => writeList(obj.ConnectivityNodes, output),
            () => output.writeString(obj.ReportingGroup),
            () => writeList(obj.SvInjection, output),
            () => writeList(obj.SvVoltage, output),
            () => writeList(obj.Terminal, output),
            () => output.writeString(obj.TopologicalIsland)
        )
        IdentifiedObjectSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TopologicalNode]): TopologicalNode =
    {
        val parent = IdentifiedObjectSerializer.read(kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = TopologicalNode(
            parent,
            if (isSet(0)) input.readDouble else 0.0,
            if (isSet(1)) input.readDouble else 0.0,
            if (isSet(2)) input.readString else null,
            if (isSet(3)) input.readString else null,
            if (isSet(4)) readList(input) else null,
            if (isSet(5)) input.readString else null,
            if (isSet(6)) readList(input) else null,
            if (isSet(7)) input.readString else null,
            if (isSet(8)) readList(input) else null,
            if (isSet(9)) readList(input) else null,
            if (isSet(10)) readList(input) else null,
            if (isSet(11)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _Topology
{
    def register: List[CIMClassInfo] =
    {
        List(
            BusNameMarker.register,
            TopologicalIsland.register,
            TopologicalNode.register
        )
    }
}