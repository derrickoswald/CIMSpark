package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * An electrical connection point (AC or DC) to a piece of conducting equipment.
 *
 * Terminals are connected at physical connection points called connectivity nodes.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param connected The connected status is related to a bus-branch model and the topological node to terminal relation.
 *        True implies the terminal is connected to the related topological node and false implies it is not.
 * @param sequenceNumber The orientation of the terminal connections for a multiple terminal conducting equipment.
 *        The sequence numbering starts with 1 and additional terminals should follow in increasing order.   The first terminal is the "starting point" for a two terminal branch.
 * @param BusNameMarker [[ch.ninecode.model.BusNameMarker BusNameMarker]] The bus name marker used to name the bus (topological node).
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class ACDCTerminal
(
    override val sup: IdentifiedObject,
    connected: Boolean,
    sequenceNumber: Int,
    BusNameMarker: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, 0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ACDCTerminal] }
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
        implicit val clz: String = ACDCTerminal.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ACDCTerminal.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ACDCTerminal.fields (position), value)
        emitelem (0, connected)
        emitelem (1, sequenceNumber)
        emitattr (2, BusNameMarker)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ACDCTerminal rdf:ID=\"%s\">\n%s\t</cim:ACDCTerminal>".format (id, export_fields)
    }
}

object ACDCTerminal
extends
    Parseable[ACDCTerminal]
{
    val fields: Array[String] = Array[String] (
        "connected",
        "sequenceNumber",
        "BusNameMarker"
    )
    val connected: Fielder = parse_element (element (cls, fields(0)))
    val sequenceNumber: Fielder = parse_element (element (cls, fields(1)))
    val BusNameMarker: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): ACDCTerminal =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ACDCTerminal (
            IdentifiedObject.parse (context),
            toBoolean (mask (connected (), 0)),
            toInteger (mask (sequenceNumber (), 1)),
            mask (BusNameMarker (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("BusNameMarker", "BusNameMarker", false)
    )
}

/**
 * The class describe a base frequency for a power system network.
 *
 * In case of multiple power networks with different frequencies, e.g. 50 or 60 Hertz each network will have it's own base frequency class. Hence it is assumed that power system objects having different base frequencies appear in separate documents where each document has a single base frequency instance.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param frequency The base frequency.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class BaseFrequency
(
    override val sup: IdentifiedObject,
    frequency: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[BaseFrequency] }
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
        implicit val clz: String = BaseFrequency.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (BaseFrequency.fields (position), value)
        emitelem (0, frequency)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:BaseFrequency rdf:ID=\"%s\">\n%s\t</cim:BaseFrequency>".format (id, export_fields)
    }
}

object BaseFrequency
extends
    Parseable[BaseFrequency]
{
    val fields: Array[String] = Array[String] (
        "frequency"
    )
    val frequency: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): BaseFrequency =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = BaseFrequency (
            IdentifiedObject.parse (context),
            toDouble (mask (frequency (), 0))
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * The BasePower class defines the base power used in the per unit calculations.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param basePower Value used as base power.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class BasePower
(
    override val sup: IdentifiedObject,
    basePower: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[BasePower] }
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
        implicit val clz: String = BasePower.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (BasePower.fields (position), value)
        emitelem (0, basePower)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:BasePower rdf:ID=\"%s\">\n%s\t</cim:BasePower>".format (id, export_fields)
    }
}

object BasePower
extends
    Parseable[BasePower]
{
    val fields: Array[String] = Array[String] (
        "basePower"
    )
    val basePower: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): BasePower =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = BasePower (
            IdentifiedObject.parse (context),
            toDouble (mask (basePower (), 0))
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Defines a system base voltage which is referenced.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param nominalVoltage The power system resource's base voltage.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class BaseVoltage
(
    override val sup: IdentifiedObject,
    nominalVoltage: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[BaseVoltage] }
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
        implicit val clz: String = BaseVoltage.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (BaseVoltage.fields (position), value)
        emitelem (0, nominalVoltage)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:BaseVoltage rdf:ID=\"%s\">\n%s\t</cim:BaseVoltage>".format (id, export_fields)
    }
}

object BaseVoltage
extends
    Parseable[BaseVoltage]
{
    val fields: Array[String] = Array[String] (
        "nominalVoltage"
    )
    val nominalVoltage: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): BaseVoltage =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = BaseVoltage (
            IdentifiedObject.parse (context),
            toDouble (mask (nominalVoltage (), 0))
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Schedule of values at points in time.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param startTime The time for the first time point.
 * @param value1Multiplier Multiplier for value1.
 * @param value1Unit Value1 units of measure.
 * @param value2Multiplier Multiplier for value2.
 * @param value2Unit Value2 units of measure.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class BasicIntervalSchedule
(
    override val sup: IdentifiedObject,
    startTime: String,
    value1Multiplier: String,
    value1Unit: String,
    value2Multiplier: String,
    value2Unit: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[BasicIntervalSchedule] }
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
        implicit val clz: String = BasicIntervalSchedule.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (BasicIntervalSchedule.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (BasicIntervalSchedule.fields (position), value)
        emitelem (0, startTime)
        emitattr (1, value1Multiplier)
        emitattr (2, value1Unit)
        emitattr (3, value2Multiplier)
        emitattr (4, value2Unit)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:BasicIntervalSchedule rdf:ID=\"%s\">\n%s\t</cim:BasicIntervalSchedule>".format (id, export_fields)
    }
}

object BasicIntervalSchedule
extends
    Parseable[BasicIntervalSchedule]
{
    val fields: Array[String] = Array[String] (
        "startTime",
        "value1Multiplier",
        "value1Unit",
        "value2Multiplier",
        "value2Unit"
    )
    val startTime: Fielder = parse_element (element (cls, fields(0)))
    val value1Multiplier: Fielder = parse_attribute (attribute (cls, fields(1)))
    val value1Unit: Fielder = parse_attribute (attribute (cls, fields(2)))
    val value2Multiplier: Fielder = parse_attribute (attribute (cls, fields(3)))
    val value2Unit: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): BasicIntervalSchedule =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = BasicIntervalSchedule (
            IdentifiedObject.parse (context),
            mask (startTime (), 0),
            mask (value1Multiplier (), 1),
            mask (value1Unit (), 2),
            mask (value2Multiplier (), 3),
            mask (value2Unit (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * A collection of power system resources (within a given substation) including conducting equipment, protection relays, measurements, and telemetry.
 *
 * A bay typically represents a physical grouping related to modularization of equipment.
 *
 * @param sup [[ch.ninecode.model.EquipmentContainer EquipmentContainer]] Reference to the superclass object.
 * @param bayEnergyMeasFlag Indicates the presence/absence of energy measurements.
 * @param bayPowerMeasFlag Indicates the presence/absence of active/reactive power measurements.
 * @param breakerConfiguration Breaker configuration.
 * @param busBarConfiguration Bus bar configuration.
 * @param Substation [[ch.ninecode.model.Substation Substation]] Substation containing the bay.
 * @param VoltageLevel [[ch.ninecode.model.VoltageLevel VoltageLevel]] The voltage level containing this bay.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class Bay
(
    override val sup: EquipmentContainer,
    bayEnergyMeasFlag: Boolean,
    bayPowerMeasFlag: Boolean,
    breakerConfiguration: String,
    busBarConfiguration: String,
    Substation: String,
    VoltageLevel: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, false, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def EquipmentContainer: EquipmentContainer = sup.asInstanceOf[EquipmentContainer]
    override def copy (): Row = { clone ().asInstanceOf[Bay] }
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
        implicit val clz: String = Bay.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Bay.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Bay.fields (position), value)
        emitelem (0, bayEnergyMeasFlag)
        emitelem (1, bayPowerMeasFlag)
        emitattr (2, breakerConfiguration)
        emitattr (3, busBarConfiguration)
        emitattr (4, Substation)
        emitattr (5, VoltageLevel)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Bay rdf:ID=\"%s\">\n%s\t</cim:Bay>".format (id, export_fields)
    }
}

object Bay
extends
    Parseable[Bay]
{
    val fields: Array[String] = Array[String] (
        "bayEnergyMeasFlag",
        "bayPowerMeasFlag",
        "breakerConfiguration",
        "busBarConfiguration",
        "Substation",
        "VoltageLevel"
    )
    val bayEnergyMeasFlag: Fielder = parse_element (element (cls, fields(0)))
    val bayPowerMeasFlag: Fielder = parse_element (element (cls, fields(1)))
    val breakerConfiguration: Fielder = parse_attribute (attribute (cls, fields(2)))
    val busBarConfiguration: Fielder = parse_attribute (attribute (cls, fields(3)))
    val Substation: Fielder = parse_attribute (attribute (cls, fields(4)))
    val VoltageLevel: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: Context): Bay =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Bay (
            EquipmentContainer.parse (context),
            toBoolean (mask (bayEnergyMeasFlag (), 0)),
            toBoolean (mask (bayPowerMeasFlag (), 1)),
            mask (breakerConfiguration (), 2),
            mask (busBarConfiguration (), 3),
            mask (Substation (), 4),
            mask (VoltageLevel (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Substation", "Substation", false),
        Relationship ("VoltageLevel", "VoltageLevel", false)
    )
}

/**
 * The parts of the AC power system that are designed to carry current or that are conductively connected through terminals.
 *
 * @param sup [[ch.ninecode.model.Equipment Equipment]] Reference to the superclass object.
 * @param BaseVoltage [[ch.ninecode.model.BaseVoltage BaseVoltage]] Base voltage of this conducting equipment.
 *        Use only when there is no voltage level container used and only one base voltage applies.  For example, not used for transformers.
 * @param GroundingAction [[ch.ninecode.model.GroundAction GroundAction]] Action involving grounding operation on this conducting equipment.
 * @param JumpingAction [[ch.ninecode.model.JumperAction JumperAction]] Jumper action involving jumping operation on this conducting equipment.
 * @param SvStatus [[ch.ninecode.model.SvStatus SvStatus]] The status state variable associated with this conducting equipment.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class ConductingEquipment
(
    override val sup: Equipment,
    BaseVoltage: String,
    GroundingAction: String,
    JumpingAction: String,
    SvStatus: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Equipment: Equipment = sup.asInstanceOf[Equipment]
    override def copy (): Row = { clone ().asInstanceOf[ConductingEquipment] }
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
        implicit val clz: String = ConductingEquipment.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ConductingEquipment.fields (position), value)
        emitattr (0, BaseVoltage)
        emitattr (1, GroundingAction)
        emitattr (2, JumpingAction)
        emitattr (3, SvStatus)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ConductingEquipment rdf:ID=\"%s\">\n%s\t</cim:ConductingEquipment>".format (id, export_fields)
    }
}

object ConductingEquipment
extends
    Parseable[ConductingEquipment]
{
    val fields: Array[String] = Array[String] (
        "BaseVoltage",
        "GroundingAction",
        "JumpingAction",
        "SvStatus"
    )
    val BaseVoltage: Fielder = parse_attribute (attribute (cls, fields(0)))
    val GroundingAction: Fielder = parse_attribute (attribute (cls, fields(1)))
    val JumpingAction: Fielder = parse_attribute (attribute (cls, fields(2)))
    val SvStatus: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): ConductingEquipment =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ConductingEquipment (
            Equipment.parse (context),
            mask (BaseVoltage (), 0),
            mask (GroundingAction (), 1),
            mask (JumpingAction (), 2),
            mask (SvStatus (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("BaseVoltage", "BaseVoltage", false),
        Relationship ("GroundingAction", "GroundAction", false),
        Relationship ("JumpingAction", "JumperAction", false),
        Relationship ("SvStatus", "SvStatus", false)
    )
}

/**
 * Connectivity nodes are points where terminals of AC conducting equipment are connected together with zero impedance.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param ConnectivityNodeContainer [[ch.ninecode.model.ConnectivityNodeContainer ConnectivityNodeContainer]] Container of this connectivity node.
 * @param TopologicalNode [[ch.ninecode.model.TopologicalNode TopologicalNode]] The topological node to which this connectivity node is assigned.
 *        May depend on the current state of switches in the network.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class ConnectivityNode
(
    override val sup: IdentifiedObject,
    ConnectivityNodeContainer: String,
    TopologicalNode: String
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
    override def copy (): Row = { clone ().asInstanceOf[ConnectivityNode] }
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
        implicit val clz: String = ConnectivityNode.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ConnectivityNode.fields (position), value)
        emitattr (0, ConnectivityNodeContainer)
        emitattr (1, TopologicalNode)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ConnectivityNode rdf:ID=\"%s\">\n%s\t</cim:ConnectivityNode>".format (id, export_fields)
    }
}

object ConnectivityNode
extends
    Parseable[ConnectivityNode]
{
    val fields: Array[String] = Array[String] (
        "ConnectivityNodeContainer",
        "TopologicalNode"
    )
    val ConnectivityNodeContainer: Fielder = parse_attribute (attribute (cls, fields(0)))
    val TopologicalNode: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): ConnectivityNode =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ConnectivityNode (
            IdentifiedObject.parse (context),
            mask (ConnectivityNodeContainer (), 0),
            mask (TopologicalNode (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ConnectivityNodeContainer", "ConnectivityNodeContainer", false),
        Relationship ("TopologicalNode", "TopologicalNode", false)
    )
}

/**
 * A base class for all objects that may contain connectivity nodes or topological nodes.
 *
 * @param sup [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class ConnectivityNodeContainer
(
    override val sup: PowerSystemResource
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { clone ().asInstanceOf[ConnectivityNodeContainer] }
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:ConnectivityNodeContainer rdf:ID=\"%s\">\n%s\t</cim:ConnectivityNodeContainer>".format (id, export_fields)
    }
}

object ConnectivityNodeContainer
extends
    Parseable[ConnectivityNodeContainer]
{

    def parse (context: Context): ConnectivityNodeContainer =
    {
        implicit val ctx: Context = context
        val ret = ConnectivityNodeContainer (
            PowerSystemResource.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * A multi-purpose curve or functional relationship between an independent variable (X-axis) and dependent (Y-axis) variables.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param curveStyle The style or shape of the curve.
 * @param xMultiplier Multiplier for X-axis.
 * @param xUnit The X-axis units of measure.
 * @param y1Multiplier Multiplier for Y1-axis.
 * @param y1Unit The Y1-axis units of measure.
 * @param y2Multiplier Multiplier for Y2-axis.
 * @param y2Unit The Y2-axis units of measure.
 * @param y3Multiplier Multiplier for Y3-axis.
 * @param y3Unit The Y3-axis units of measure.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class Curve
(
    override val sup: IdentifiedObject,
    curveStyle: String,
    xMultiplier: String,
    xUnit: String,
    y1Multiplier: String,
    y1Unit: String,
    y2Multiplier: String,
    y2Unit: String,
    y3Multiplier: String,
    y3Unit: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Curve] }
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
        implicit val clz: String = Curve.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Curve.fields (position), value)
        emitattr (0, curveStyle)
        emitattr (1, xMultiplier)
        emitattr (2, xUnit)
        emitattr (3, y1Multiplier)
        emitattr (4, y1Unit)
        emitattr (5, y2Multiplier)
        emitattr (6, y2Unit)
        emitattr (7, y3Multiplier)
        emitattr (8, y3Unit)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Curve rdf:ID=\"%s\">\n%s\t</cim:Curve>".format (id, export_fields)
    }
}

object Curve
extends
    Parseable[Curve]
{
    val fields: Array[String] = Array[String] (
        "curveStyle",
        "xMultiplier",
        "xUnit",
        "y1Multiplier",
        "y1Unit",
        "y2Multiplier",
        "y2Unit",
        "y3Multiplier",
        "y3Unit"
    )
    val curveStyle: Fielder = parse_attribute (attribute (cls, fields(0)))
    val xMultiplier: Fielder = parse_attribute (attribute (cls, fields(1)))
    val xUnit: Fielder = parse_attribute (attribute (cls, fields(2)))
    val y1Multiplier: Fielder = parse_attribute (attribute (cls, fields(3)))
    val y1Unit: Fielder = parse_attribute (attribute (cls, fields(4)))
    val y2Multiplier: Fielder = parse_attribute (attribute (cls, fields(5)))
    val y2Unit: Fielder = parse_attribute (attribute (cls, fields(6)))
    val y3Multiplier: Fielder = parse_attribute (attribute (cls, fields(7)))
    val y3Unit: Fielder = parse_attribute (attribute (cls, fields(8)))

    def parse (context: Context): Curve =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Curve (
            IdentifiedObject.parse (context),
            mask (curveStyle (), 0),
            mask (xMultiplier (), 1),
            mask (xUnit (), 2),
            mask (y1Multiplier (), 3),
            mask (y1Unit (), 4),
            mask (y2Multiplier (), 5),
            mask (y2Unit (), 6),
            mask (y3Multiplier (), 7),
            mask (y3Unit (), 8)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Multi-purpose data points for defining a curve.
 *
 * The use of this generic class is discouraged if a more specific class  can be used to specify the x and y axis values along with their specific data types.
 *
 * @param sup Reference to the superclass object.
 * @param xvalue The data value of the X-axis variable,  depending on the X-axis units.
 * @param y1value The data value of the  first Y-axis variable, depending on the Y-axis units.
 * @param y2value The data value of the second Y-axis variable (if present), depending on the Y-axis units.
 * @param y3value The data value of the third Y-axis variable (if present), depending on the Y-axis units.
 * @param Curve [[ch.ninecode.model.Curve Curve]] The curve of  this curve data point.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class CurveData
(
    override val sup: BasicElement,
    xvalue: Double,
    y1value: Double,
    y2value: Double,
    y3value: Double,
    Curve: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[CurveData] }
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
        implicit val clz: String = CurveData.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CurveData.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CurveData.fields (position), value)
        emitelem (0, xvalue)
        emitelem (1, y1value)
        emitelem (2, y2value)
        emitelem (3, y3value)
        emitattr (4, Curve)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CurveData rdf:ID=\"%s\">\n%s\t</cim:CurveData>".format (id, export_fields)
    }
}

object CurveData
extends
    Parseable[CurveData]
{
    val fields: Array[String] = Array[String] (
        "xvalue",
        "y1value",
        "y2value",
        "y3value",
        "Curve"
    )
    val xvalue: Fielder = parse_element (element (cls, fields(0)))
    val y1value: Fielder = parse_element (element (cls, fields(1)))
    val y2value: Fielder = parse_element (element (cls, fields(2)))
    val y3value: Fielder = parse_element (element (cls, fields(3)))
    val Curve: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): CurveData =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = CurveData (
            BasicElement.parse (context),
            toDouble (mask (xvalue (), 0)),
            toDouble (mask (y1value (), 1)),
            toDouble (mask (y2value (), 2)),
            toDouble (mask (y3value (), 3)),
            mask (Curve (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Curve", "Curve", false)
    )
}

/**
 * The parts of a power system that are physical devices, electronic or mechanical.
 *
 * @param sup [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param aggregate The single instance of equipment represents multiple pieces of equipment that have been modeled together as an aggregate.
 *        Examples would be power transformers or synchronous machines operating in parallel modeled as a single aggregate power transformer or aggregate synchronous machine.  This is not to be used to indicate equipment that is part of a group of interdependent equipment produced by a network production program.
 * @param normallyInService If true, the equipment is normally in service.
 * @param EquipmentContainer [[ch.ninecode.model.EquipmentContainer EquipmentContainer]] Container of this equipment.
 * @param WeatherStation [[ch.ninecode.model.WeatherStation WeatherStation]] <em>undocumented</em>
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class Equipment
(
    override val sup: PowerSystemResource,
    aggregate: Boolean,
    normallyInService: Boolean,
    EquipmentContainer: String,
    WeatherStation: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, false, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { clone ().asInstanceOf[Equipment] }
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
        implicit val clz: String = Equipment.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Equipment.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Equipment.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (Equipment.fields (position), x))
        emitelem (0, aggregate)
        emitelem (1, normallyInService)
        emitattr (2, EquipmentContainer)
        emitattrs (3, WeatherStation)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Equipment rdf:ID=\"%s\">\n%s\t</cim:Equipment>".format (id, export_fields)
    }
}

object Equipment
extends
    Parseable[Equipment]
{
    val fields: Array[String] = Array[String] (
        "aggregate",
        "normallyInService",
        "EquipmentContainer",
        "WeatherStation"
    )
    val aggregate: Fielder = parse_element (element (cls, fields(0)))
    val normallyInService: Fielder = parse_element (element (cls, fields(1)))
    val EquipmentContainer: Fielder = parse_attribute (attribute (cls, fields(2)))
    val WeatherStation: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: Context): Equipment =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Equipment (
            PowerSystemResource.parse (context),
            toBoolean (mask (aggregate (), 0)),
            toBoolean (mask (normallyInService (), 1)),
            mask (EquipmentContainer (), 2),
            masks (WeatherStation (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("EquipmentContainer", "EquipmentContainer", false),
        Relationship ("WeatherStation", "WeatherStation", true)
    )
}

/**
 * A modeling construct to provide a root class for containing equipment.
 *
 * @param sup [[ch.ninecode.model.ConnectivityNodeContainer ConnectivityNodeContainer]] Reference to the superclass object.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class EquipmentContainer
(
    override val sup: ConnectivityNodeContainer
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ConnectivityNodeContainer: ConnectivityNodeContainer = sup.asInstanceOf[ConnectivityNodeContainer]
    override def copy (): Row = { clone ().asInstanceOf[EquipmentContainer] }
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:EquipmentContainer rdf:ID=\"%s\">\n%s\t</cim:EquipmentContainer>".format (id, export_fields)
    }
}

object EquipmentContainer
extends
    Parseable[EquipmentContainer]
{

    def parse (context: Context): EquipmentContainer =
    {
        implicit val ctx: Context = context
        val ret = EquipmentContainer (
            ConnectivityNodeContainer.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * A geographical region of a power system network model.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class GeographicalRegion
(
    override val sup: IdentifiedObject
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[GeographicalRegion] }
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:GeographicalRegion rdf:ID=\"%s\">\n%s\t</cim:GeographicalRegion>".format (id, export_fields)
    }
}

object GeographicalRegion
extends
    Parseable[GeographicalRegion]
{

    def parse (context: Context): GeographicalRegion =
    {
        implicit val ctx: Context = context
        val ret = GeographicalRegion (
            IdentifiedObject.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * This is a root class to provide common identification for all classes needing identification and naming attributes.
 *
 * @param sup Reference to the superclass object.
 * @param aliasName The aliasName is free text human readable name of the object alternative to IdentifiedObject.name.
 *        It may be non unique and may not correlate to a naming hierarchy.
 * @param description The description is a free human readable text describing or naming the object.
 *        It may be non unique and may not correlate to a naming hierarchy.
 * @param mRID Master resource identifier issued by a model authority.
 *        The mRID is globally unique within an exchange context. Global uniqueness is easily achieved by using a UUID,  as specified in RFC 4122, for the mRID.  The use of UUID is strongly recommended.
 * @param name The name is any free human readable and possibly non unique text naming the object.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class IdentifiedObject
(
    override val sup: BasicElement,
    aliasName: String,
    description: String,
    mRID: String,
    name: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[IdentifiedObject] }
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
        implicit val clz: String = IdentifiedObject.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (IdentifiedObject.fields (position), value)
        emitelem (0, aliasName)
        emitelem (1, description)
        emitelem (2, mRID)
        emitelem (3, name)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:IdentifiedObject rdf:ID=\"%s\">\n%s\t</cim:IdentifiedObject>".format (id, export_fields)
    }
}

object IdentifiedObject
extends
    Parseable[IdentifiedObject]
{
    val fields: Array[String] = Array[String] (
        "aliasName",
        "description",
        "mRID",
        "name"
    )
    val aliasName: Fielder = parse_element (element (cls, fields(0)))
    val description: Fielder = parse_element (element (cls, fields(1)))
    val mRID: Fielder = parse_element (element (cls, fields(2)))
    val name: Fielder = parse_element (element (cls, fields(3)))

    def parse (context: Context): IdentifiedObject =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val base = BasicElement.parse (context)
        val ret = IdentifiedObject (
            base,
            mask (aliasName (), 0),
            mask (description (), 1),
            base.id,
            mask (name (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * The schedule has time points where the time between them varies.
 *
 * @param sup [[ch.ninecode.model.BasicIntervalSchedule BasicIntervalSchedule]] Reference to the superclass object.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class IrregularIntervalSchedule
(
    override val sup: BasicIntervalSchedule
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def BasicIntervalSchedule: BasicIntervalSchedule = sup.asInstanceOf[BasicIntervalSchedule]
    override def copy (): Row = { clone ().asInstanceOf[IrregularIntervalSchedule] }
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:IrregularIntervalSchedule rdf:ID=\"%s\">\n%s\t</cim:IrregularIntervalSchedule>".format (id, export_fields)
    }
}

object IrregularIntervalSchedule
extends
    Parseable[IrregularIntervalSchedule]
{

    def parse (context: Context): IrregularIntervalSchedule =
    {
        implicit val ctx: Context = context
        val ret = IrregularIntervalSchedule (
            BasicIntervalSchedule.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * TimePoints for a schedule where the time between the points varies.
 *
 * @param sup Reference to the superclass object.
 * @param time The time is relative to the schedule starting time.
 * @param value1 The first value at the time.
 *        The meaning of the value is defined by the derived type of the associated schedule.
 * @param value2 The second value at the time.
 *        The meaning of the value is defined by the derived type of the associated schedule.
 * @param IntervalSchedule [[ch.ninecode.model.IrregularIntervalSchedule IrregularIntervalSchedule]] An IrregularTimePoint belongs to an IrregularIntervalSchedule.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class IrregularTimePoint
(
    override val sup: BasicElement,
    time: Double,
    value1: Double,
    value2: Double,
    IntervalSchedule: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[IrregularTimePoint] }
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
        implicit val clz: String = IrregularTimePoint.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (IrregularTimePoint.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (IrregularTimePoint.fields (position), value)
        emitelem (0, time)
        emitelem (1, value1)
        emitelem (2, value2)
        emitattr (3, IntervalSchedule)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:IrregularTimePoint rdf:ID=\"%s\">\n%s\t</cim:IrregularTimePoint>".format (id, export_fields)
    }
}

object IrregularTimePoint
extends
    Parseable[IrregularTimePoint]
{
    val fields: Array[String] = Array[String] (
        "time",
        "value1",
        "value2",
        "IntervalSchedule"
    )
    val time: Fielder = parse_element (element (cls, fields(0)))
    val value1: Fielder = parse_element (element (cls, fields(1)))
    val value2: Fielder = parse_element (element (cls, fields(2)))
    val IntervalSchedule: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): IrregularTimePoint =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = IrregularTimePoint (
            BasicElement.parse (context),
            toDouble (mask (time (), 0)),
            toDouble (mask (value1 (), 1)),
            toDouble (mask (value2 (), 2)),
            mask (IntervalSchedule (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("IntervalSchedule", "IrregularIntervalSchedule", false)
    )
}

/**
 * The Name class provides the means to define any number of human readable  names for an object.
 *
 * A name is <b>not</b> to be used for defining inter-object relationships. For inter-object relationships instead use the object identification 'mRID'.
 *
 * @param sup Reference to the superclass object.
 * @param name Any free text that name the object.
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Identified object that this name designates.
 * @param NameType [[ch.ninecode.model.NameType NameType]] Type of this name.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class Name
(
    override val sup: BasicElement,
    name: String,
    IdentifiedObject: String,
    NameType: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[Name] }
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
        implicit val clz: String = Name.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Name.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Name.fields (position), value)
        emitelem (0, name)
        emitattr (1, IdentifiedObject)
        emitattr (2, NameType)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Name rdf:ID=\"%s\">\n%s\t</cim:Name>".format (id, export_fields)
    }
}

object Name
extends
    Parseable[Name]
{
    val fields: Array[String] = Array[String] (
        "name",
        "IdentifiedObject",
        "NameType"
    )
    val name: Fielder = parse_element (element (cls, fields(0)))
    val IdentifiedObject: Fielder = parse_attribute (attribute (cls, fields(1)))
    val NameType: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): Name =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Name (
            BasicElement.parse (context),
            mask (name (), 0),
            mask (IdentifiedObject (), 1),
            mask (NameType (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("IdentifiedObject", "IdentifiedObject", false),
        Relationship ("NameType", "NameType", false)
    )
}

/**
 * Type of name.
 *
 * Possible values for attribute 'name' are implementation dependent but standard profiles may specify types. An enterprise may have multiple IT systems each having its own local name for the same object, e.g. a planning system may have different names from an EMS. An object may also have different names within the same IT system, e.g. localName as defined in CIM version 14. The definition from CIM14 is:
 *
 * @param sup Reference to the superclass object.
 * @param description Description of the name type.
 * @param name Name of the name type.
 * @param NameTypeAuthority [[ch.ninecode.model.NameTypeAuthority NameTypeAuthority]] Authority responsible for managing names of this type.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class NameType
(
    override val sup: BasicElement,
    description: String,
    name: String,
    NameTypeAuthority: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[NameType] }
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
        implicit val clz: String = NameType.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (NameType.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (NameType.fields (position), value)
        emitelem (0, description)
        emitelem (1, name)
        emitattr (2, NameTypeAuthority)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:NameType rdf:ID=\"%s\">\n%s\t</cim:NameType>".format (id, export_fields)
    }
}

object NameType
extends
    Parseable[NameType]
{
    val fields: Array[String] = Array[String] (
        "description",
        "name",
        "NameTypeAuthority"
    )
    val description: Fielder = parse_element (element (cls, fields(0)))
    val name: Fielder = parse_element (element (cls, fields(1)))
    val NameTypeAuthority: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): NameType =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = NameType (
            BasicElement.parse (context),
            mask (description (), 0),
            mask (name (), 1),
            mask (NameTypeAuthority (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("NameTypeAuthority", "NameTypeAuthority", false)
    )
}

/**
 * Authority responsible for creation and management of names of a given type; typically an organization or an enterprise system.
 *
 * @param sup Reference to the superclass object.
 * @param description Description of the name type authority.
 * @param name Name of the name type authority.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class NameTypeAuthority
(
    override val sup: BasicElement,
    description: String,
    name: String
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
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[NameTypeAuthority] }
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
        implicit val clz: String = NameTypeAuthority.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (NameTypeAuthority.fields (position), value)
        emitelem (0, description)
        emitelem (1, name)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:NameTypeAuthority rdf:ID=\"%s\">\n%s\t</cim:NameTypeAuthority>".format (id, export_fields)
    }
}

object NameTypeAuthority
extends
    Parseable[NameTypeAuthority]
{
    val fields: Array[String] = Array[String] (
        "description",
        "name"
    )
    val description: Fielder = parse_element (element (cls, fields(0)))
    val name: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: Context): NameTypeAuthority =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = NameTypeAuthority (
            BasicElement.parse (context),
            mask (description (), 0),
            mask (name (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * An operator of multiple power system resource objects.
 *
 * Note multple operating participants may operate the same power system resource object.   This can be used for modeling jointly owned units where each owner operates as a contractual share.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class OperatingParticipant
(
    override val sup: IdentifiedObject
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[OperatingParticipant] }
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:OperatingParticipant rdf:ID=\"%s\">\n%s\t</cim:OperatingParticipant>".format (id, export_fields)
    }
}

object OperatingParticipant
extends
    Parseable[OperatingParticipant]
{

    def parse (context: Context): OperatingParticipant =
    {
        implicit val ctx: Context = context
        val ret = OperatingParticipant (
            IdentifiedObject.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Specifies the operations contract relationship between a power system resource and a contract participant.
 *
 * @param sup Reference to the superclass object.
 * @param percentage Percentage operational ownership between the pair (power system resource and operatging participant) associated with this share.
 *        The total percentage ownership for a power system resource should add to 100%.
 * @param OperatingParticipant [[ch.ninecode.model.OperatingParticipant OperatingParticipant]] The operating participant having this share with the associated power system resource.
 * @param PowerSystemResource [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] The power system resource to which the share applies.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class OperatingShare
(
    override val sup: BasicElement,
    percentage: Double,
    OperatingParticipant: String,
    PowerSystemResource: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[OperatingShare] }
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
        implicit val clz: String = OperatingShare.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (OperatingShare.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OperatingShare.fields (position), value)
        emitelem (0, percentage)
        emitattr (1, OperatingParticipant)
        emitattr (2, PowerSystemResource)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OperatingShare rdf:ID=\"%s\">\n%s\t</cim:OperatingShare>".format (id, export_fields)
    }
}

object OperatingShare
extends
    Parseable[OperatingShare]
{
    val fields: Array[String] = Array[String] (
        "percentage",
        "OperatingParticipant",
        "PowerSystemResource"
    )
    val percentage: Fielder = parse_element (element (cls, fields(0)))
    val OperatingParticipant: Fielder = parse_attribute (attribute (cls, fields(1)))
    val PowerSystemResource: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): OperatingShare =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = OperatingShare (
            BasicElement.parse (context),
            toDouble (mask (percentage (), 0)),
            mask (OperatingParticipant (), 1),
            mask (PowerSystemResource (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("OperatingParticipant", "OperatingParticipant", false),
        Relationship ("PowerSystemResource", "PowerSystemResource", false)
    )
}

/**
 * Classifying instances of the same class, e.g. overhead and underground ACLineSegments.
 *
 * This classification mechanism is intended to provide flexibility outside the scope of this standard, i.e. provide customisation that is non standard.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class PSRType
(
    override val sup: IdentifiedObject
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[PSRType] }
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:PSRType rdf:ID=\"%s\">\n%s\t</cim:PSRType>".format (id, export_fields)
    }
}

object PSRType
extends
    Parseable[PSRType]
{

    def parse (context: Context): PSRType =
    {
        implicit val ctx: Context = context
        val ret = PSRType (
            IdentifiedObject.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * A power system resource can be an item of equipment such as a switch, an equipment container containing many individual items of equipment such as a substation, or an organisational entity such as sub-control area.
 *
 * Power system resources can have measurements associated.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param AssetDatasheet [[ch.ninecode.model.AssetInfo AssetInfo]] Datasheet information for this power system resource.
 * @param Location [[ch.ninecode.model.Location Location]] Location of this power system resource.
 * @param PSRType [[ch.ninecode.model.PSRType PSRType]] Custom classification for this power system resource.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class PowerSystemResource
(
    override val sup: IdentifiedObject,
    AssetDatasheet: String,
    Location: String,
    PSRType: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[PowerSystemResource] }
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
        implicit val clz: String = PowerSystemResource.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PowerSystemResource.fields (position), value)
        emitattr (0, AssetDatasheet)
        emitattr (1, Location)
        emitattr (2, PSRType)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PowerSystemResource rdf:ID=\"%s\">\n%s\t</cim:PowerSystemResource>".format (id, export_fields)
    }
}

object PowerSystemResource
extends
    Parseable[PowerSystemResource]
{
    val fields: Array[String] = Array[String] (
        "AssetDatasheet",
        "Location",
        "PSRType"
    )
    val AssetDatasheet: Fielder = parse_attribute (attribute (cls, fields(0)))
    val Location: Fielder = parse_attribute (attribute (cls, fields(1)))
    val PSRType: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): PowerSystemResource =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = PowerSystemResource (
            IdentifiedObject.parse (context),
            mask (AssetDatasheet (), 0),
            mask (Location (), 1),
            mask (PSRType (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("AssetDatasheet", "AssetInfo", false),
        Relationship ("Location", "Location", false),
        Relationship ("PSRType", "PSRType", false)
    )
}

/**
 * The schedule has time points where the time between them is constant.
 *
 * @param sup [[ch.ninecode.model.BasicIntervalSchedule BasicIntervalSchedule]] Reference to the superclass object.
 * @param endTime The time for the last time point.
 * @param timeStep The time between each pair of subsequent regular time points in sequence order.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class RegularIntervalSchedule
(
    override val sup: BasicIntervalSchedule,
    endTime: String,
    timeStep: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def BasicIntervalSchedule: BasicIntervalSchedule = sup.asInstanceOf[BasicIntervalSchedule]
    override def copy (): Row = { clone ().asInstanceOf[RegularIntervalSchedule] }
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
        implicit val clz: String = RegularIntervalSchedule.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (RegularIntervalSchedule.fields (position), value)
        emitelem (0, endTime)
        emitelem (1, timeStep)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RegularIntervalSchedule rdf:ID=\"%s\">\n%s\t</cim:RegularIntervalSchedule>".format (id, export_fields)
    }
}

object RegularIntervalSchedule
extends
    Parseable[RegularIntervalSchedule]
{
    val fields: Array[String] = Array[String] (
        "endTime",
        "timeStep"
    )
    val endTime: Fielder = parse_element (element (cls, fields(0)))
    val timeStep: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: Context): RegularIntervalSchedule =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = RegularIntervalSchedule (
            BasicIntervalSchedule.parse (context),
            mask (endTime (), 0),
            toDouble (mask (timeStep (), 1))
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Time point for a schedule where the time between the consecutive points is constant.
 *
 * @param sup Reference to the superclass object.
 * @param sequenceNumber The position of the regular time point in the sequence.
 *        Note that time points don't have to be sequential, i.e. time points may be omitted. The actual time for a RegularTimePoint is computed by multiplying the associated regular interval schedule's time step with the regular time point sequence number and adding the associated schedules start time.
 * @param value1 The first value at the time.
 *        The meaning of the value is defined by the derived type of the associated schedule.
 * @param value2 The second value at the time.
 *        The meaning of the value is defined by the derived type of the associated schedule.
 * @param IntervalSchedule [[ch.ninecode.model.RegularIntervalSchedule RegularIntervalSchedule]] Regular interval schedule containing this time point.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class RegularTimePoint
(
    override val sup: BasicElement,
    sequenceNumber: Int,
    value1: Double,
    value2: Double,
    IntervalSchedule: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[RegularTimePoint] }
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
        implicit val clz: String = RegularTimePoint.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (RegularTimePoint.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RegularTimePoint.fields (position), value)
        emitelem (0, sequenceNumber)
        emitelem (1, value1)
        emitelem (2, value2)
        emitattr (3, IntervalSchedule)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RegularTimePoint rdf:ID=\"%s\">\n%s\t</cim:RegularTimePoint>".format (id, export_fields)
    }
}

object RegularTimePoint
extends
    Parseable[RegularTimePoint]
{
    val fields: Array[String] = Array[String] (
        "sequenceNumber",
        "value1",
        "value2",
        "IntervalSchedule"
    )
    val sequenceNumber: Fielder = parse_element (element (cls, fields(0)))
    val value1: Fielder = parse_element (element (cls, fields(1)))
    val value2: Fielder = parse_element (element (cls, fields(2)))
    val IntervalSchedule: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): RegularTimePoint =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = RegularTimePoint (
            BasicElement.parse (context),
            toInteger (mask (sequenceNumber (), 0)),
            toDouble (mask (value1 (), 1)),
            toDouble (mask (value2 (), 2)),
            mask (IntervalSchedule (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("IntervalSchedule", "RegularIntervalSchedule", false)
    )
}

/**
 * A reporting group is used for various ad-hoc groupings used for reporting.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param PowerSystemResource [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Power system resources which belong to this reporting group.
 * @param ReportingSuperGroup [[ch.ninecode.model.ReportingSuperGroup ReportingSuperGroup]] Reporting super group to which this reporting group belongs.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class ReportingGroup
(
    override val sup: IdentifiedObject,
    PowerSystemResource: List[String],
    ReportingSuperGroup: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List(), null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ReportingGroup] }
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
        implicit val clz: String = ReportingGroup.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ReportingGroup.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (ReportingGroup.fields (position), x))
        emitattrs (0, PowerSystemResource)
        emitattr (1, ReportingSuperGroup)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ReportingGroup rdf:ID=\"%s\">\n%s\t</cim:ReportingGroup>".format (id, export_fields)
    }
}

object ReportingGroup
extends
    Parseable[ReportingGroup]
{
    val fields: Array[String] = Array[String] (
        "PowerSystemResource",
        "ReportingSuperGroup"
    )
    val PowerSystemResource: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val ReportingSuperGroup: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): ReportingGroup =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ReportingGroup (
            IdentifiedObject.parse (context),
            masks (PowerSystemResource (), 0),
            mask (ReportingSuperGroup (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("PowerSystemResource", "PowerSystemResource", true),
        Relationship ("ReportingSuperGroup", "ReportingSuperGroup", false)
    )
}

/**
 * A reporting super group, groups reporting groups for a higher level report.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class ReportingSuperGroup
(
    override val sup: IdentifiedObject
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ReportingSuperGroup] }
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:ReportingSuperGroup rdf:ID=\"%s\">\n%s\t</cim:ReportingSuperGroup>".format (id, export_fields)
    }
}

object ReportingSuperGroup
extends
    Parseable[ReportingSuperGroup]
{

    def parse (context: Context): ReportingSuperGroup =
    {
        implicit val ctx: Context = context
        val ret = ReportingSuperGroup (
            IdentifiedObject.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * A subset of a geographical region of a power system network model.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param Region [[ch.ninecode.model.GeographicalRegion GeographicalRegion]] The geographical region to which this sub-geographical region is within.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class SubGeographicalRegion
(
    override val sup: IdentifiedObject,
    Region: String
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
    override def copy (): Row = { clone ().asInstanceOf[SubGeographicalRegion] }
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
        implicit val clz: String = SubGeographicalRegion.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SubGeographicalRegion.fields (position), value)
        emitattr (0, Region)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SubGeographicalRegion rdf:ID=\"%s\">\n%s\t</cim:SubGeographicalRegion>".format (id, export_fields)
    }
}

object SubGeographicalRegion
extends
    Parseable[SubGeographicalRegion]
{
    val fields: Array[String] = Array[String] (
        "Region"
    )
    val Region: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): SubGeographicalRegion =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = SubGeographicalRegion (
            IdentifiedObject.parse (context),
            mask (Region (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Region", "GeographicalRegion", false)
    )
}

/**
 * A collection of equipment for purposes other than generation or utilization, through which electric energy in bulk is passed for the purposes of switching or modifying its characteristics.
 *
 * @param sup [[ch.ninecode.model.EquipmentContainer EquipmentContainer]] Reference to the superclass object.
 * @param Region [[ch.ninecode.model.SubGeographicalRegion SubGeographicalRegion]] The SubGeographicalRegion containing the substation.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class Substation
(
    override val sup: EquipmentContainer,
    Region: String
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
    def EquipmentContainer: EquipmentContainer = sup.asInstanceOf[EquipmentContainer]
    override def copy (): Row = { clone ().asInstanceOf[Substation] }
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
        implicit val clz: String = Substation.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Substation.fields (position), value)
        emitattr (0, Region)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Substation rdf:ID=\"%s\">\n%s\t</cim:Substation>".format (id, export_fields)
    }
}

object Substation
extends
    Parseable[Substation]
{
    val fields: Array[String] = Array[String] (
        "Region"
    )
    val Region: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): Substation =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Substation (
            EquipmentContainer.parse (context),
            mask (Region (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Region", "SubGeographicalRegion", false)
    )
}

/**
 * An AC electrical connection point to a piece of conducting equipment.
 *
 * Terminals are connected at physical connection points called connectivity nodes.
 *
 * @param sup [[ch.ninecode.model.ACDCTerminal ACDCTerminal]] Reference to the superclass object.
 * @param phases Represents the normal network phasing condition.
 *        If the attribute is missing three phases (ABC or ABCN) shall be assumed.
 * @param Bushing [[ch.ninecode.model.Bushing Bushing]] <em>undocumented</em>
 * @param ConductingEquipment [[ch.ninecode.model.ConductingEquipment ConductingEquipment]] The conducting equipment of the terminal.
 *        Conducting equipment have  terminals that may be connected to other conducting equipment terminals via connectivity nodes or topological nodes.
 * @param ConnectivityNode [[ch.ninecode.model.ConnectivityNode ConnectivityNode]] The connectivity node to which this terminal connects with zero impedance.
 * @param SvPowerFlow [[ch.ninecode.model.SvPowerFlow SvPowerFlow]] The power flow state variable associated with the terminal.
 * @param TopologicalNode [[ch.ninecode.model.TopologicalNode TopologicalNode]] The topological node associated with the terminal.
 *        This can be used as an alternative to the connectivity node path to topological node, thus making it unneccesary to model connectivity nodes in some cases.   Note that the if connectivity nodes are in the model, this association would probably not be used as an input specification.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class Terminal
(
    override val sup: ACDCTerminal,
    phases: String,
    Bushing: String,
    ConductingEquipment: String,
    ConnectivityNode: String,
    SvPowerFlow: String,
    TopologicalNode: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ACDCTerminal: ACDCTerminal = sup.asInstanceOf[ACDCTerminal]
    override def copy (): Row = { clone ().asInstanceOf[Terminal] }
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
        implicit val clz: String = Terminal.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Terminal.fields (position), value)
        emitattr (0, phases)
        emitattr (1, Bushing)
        emitattr (2, ConductingEquipment)
        emitattr (3, ConnectivityNode)
        emitattr (4, SvPowerFlow)
        emitattr (5, TopologicalNode)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Terminal rdf:ID=\"%s\">\n%s\t</cim:Terminal>".format (id, export_fields)
    }
}

object Terminal
extends
    Parseable[Terminal]
{
    val fields: Array[String] = Array[String] (
        "phases",
        "Bushing",
        "ConductingEquipment",
        "ConnectivityNode",
        "SvPowerFlow",
        "TopologicalNode"
    )
    val phases: Fielder = parse_attribute (attribute (cls, fields(0)))
    val Bushing: Fielder = parse_attribute (attribute (cls, fields(1)))
    val ConductingEquipment: Fielder = parse_attribute (attribute (cls, fields(2)))
    val ConnectivityNode: Fielder = parse_attribute (attribute (cls, fields(3)))
    val SvPowerFlow: Fielder = parse_attribute (attribute (cls, fields(4)))
    val TopologicalNode: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: Context): Terminal =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Terminal (
            ACDCTerminal.parse (context),
            mask (phases (), 0),
            mask (Bushing (), 1),
            mask (ConductingEquipment (), 2),
            mask (ConnectivityNode (), 3),
            mask (SvPowerFlow (), 4),
            mask (TopologicalNode (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Bushing", "Bushing", false),
        Relationship ("ConductingEquipment", "ConductingEquipment", false),
        Relationship ("ConnectivityNode", "ConnectivityNode", false),
        Relationship ("SvPowerFlow", "SvPowerFlow", false),
        Relationship ("TopologicalNode", "TopologicalNode", false)
    )
}

/**
 * A collection of equipment at one common system voltage forming a switchgear.
 *
 * The equipment typically consist of breakers, busbars, instrumentation, control, regulation and protection devices as well as assemblies of all these.
 *
 * @param sup [[ch.ninecode.model.EquipmentContainer EquipmentContainer]] Reference to the superclass object.
 * @param highVoltageLimit The bus bar's high voltage limit
 * @param lowVoltageLimit The bus bar's low voltage limit
 * @param BaseVoltage [[ch.ninecode.model.BaseVoltage BaseVoltage]] The base voltage used for all equipment within the voltage level.
 * @param Substation [[ch.ninecode.model.Substation Substation]] The substation of the voltage level.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class VoltageLevel
(
    override val sup: EquipmentContainer,
    highVoltageLimit: Double,
    lowVoltageLimit: Double,
    BaseVoltage: String,
    Substation: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def EquipmentContainer: EquipmentContainer = sup.asInstanceOf[EquipmentContainer]
    override def copy (): Row = { clone ().asInstanceOf[VoltageLevel] }
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
        implicit val clz: String = VoltageLevel.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (VoltageLevel.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (VoltageLevel.fields (position), value)
        emitelem (0, highVoltageLimit)
        emitelem (1, lowVoltageLimit)
        emitattr (2, BaseVoltage)
        emitattr (3, Substation)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:VoltageLevel rdf:ID=\"%s\">\n%s\t</cim:VoltageLevel>".format (id, export_fields)
    }
}

object VoltageLevel
extends
    Parseable[VoltageLevel]
{
    val fields: Array[String] = Array[String] (
        "highVoltageLimit",
        "lowVoltageLimit",
        "BaseVoltage",
        "Substation"
    )
    val highVoltageLimit: Fielder = parse_element (element (cls, fields(0)))
    val lowVoltageLimit: Fielder = parse_element (element (cls, fields(1)))
    val BaseVoltage: Fielder = parse_attribute (attribute (cls, fields(2)))
    val Substation: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): VoltageLevel =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = VoltageLevel (
            EquipmentContainer.parse (context),
            toDouble (mask (highVoltageLimit (), 0)),
            toDouble (mask (lowVoltageLimit (), 1)),
            mask (BaseVoltage (), 2),
            mask (Substation (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("BaseVoltage", "BaseVoltage", false),
        Relationship ("Substation", "Substation", false)
    )
}

private[ninecode] object _Core
{
    def register: List[ClassInfo] =
    {
        List (
            ACDCTerminal.register,
            BaseFrequency.register,
            BasePower.register,
            BaseVoltage.register,
            BasicIntervalSchedule.register,
            Bay.register,
            ConductingEquipment.register,
            ConnectivityNode.register,
            ConnectivityNodeContainer.register,
            Curve.register,
            CurveData.register,
            Equipment.register,
            EquipmentContainer.register,
            GeographicalRegion.register,
            IdentifiedObject.register,
            IrregularIntervalSchedule.register,
            IrregularTimePoint.register,
            Name.register,
            NameType.register,
            NameTypeAuthority.register,
            OperatingParticipant.register,
            OperatingShare.register,
            PSRType.register,
            PowerSystemResource.register,
            RegularIntervalSchedule.register,
            RegularTimePoint.register,
            ReportingGroup.register,
            ReportingSuperGroup.register,
            SubGeographicalRegion.register,
            Substation.register,
            Terminal.register,
            VoltageLevel.register
        )
    }
}