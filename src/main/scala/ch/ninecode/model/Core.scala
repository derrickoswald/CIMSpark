package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

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
        sup.export_fields +
        "\t\t<cim:ACDCTerminal.connected>" + connected + "</cim:ACDCTerminal.connected>\n" +
        "\t\t<cim:ACDCTerminal.sequenceNumber>" + sequenceNumber + "</cim:ACDCTerminal.sequenceNumber>\n" +
        (if (null != BusNameMarker) "\t\t<cim:ACDCTerminal.BusNameMarker rdf:resource=\"#" + BusNameMarker + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ACDCTerminal rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ACDCTerminal>"
    }
}

object ACDCTerminal
extends
    Parseable[ACDCTerminal]
{
    val connected = parse_element (element ("""ACDCTerminal.connected"""))
    val sequenceNumber = parse_element (element ("""ACDCTerminal.sequenceNumber"""))
    val BusNameMarker = parse_attribute (attribute ("""ACDCTerminal.BusNameMarker"""))
    def parse (context: Context): ACDCTerminal =
    {
        ACDCTerminal(
            IdentifiedObject.parse (context),
            toBoolean (connected (context), context),
            toInteger (sequenceNumber (context), context),
            BusNameMarker (context)
        )
    }
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
        sup.export_fields +
        "\t\t<cim:BaseFrequency.frequency>" + frequency + "</cim:BaseFrequency.frequency>\n"
    }
    override def export: String =
    {
        "\t<cim:BaseFrequency rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:BaseFrequency>"
    }
}

object BaseFrequency
extends
    Parseable[BaseFrequency]
{
    val frequency = parse_element (element ("""BaseFrequency.frequency"""))
    def parse (context: Context): BaseFrequency =
    {
        BaseFrequency(
            IdentifiedObject.parse (context),
            toDouble (frequency (context), context)
        )
    }
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
        sup.export_fields +
        "\t\t<cim:BasePower.basePower>" + basePower + "</cim:BasePower.basePower>\n"
    }
    override def export: String =
    {
        "\t<cim:BasePower rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:BasePower>"
    }
}

object BasePower
extends
    Parseable[BasePower]
{
    val basePower = parse_element (element ("""BasePower.basePower"""))
    def parse (context: Context): BasePower =
    {
        BasePower(
            IdentifiedObject.parse (context),
            toDouble (basePower (context), context)
        )
    }
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
        sup.export_fields +
        "\t\t<cim:BaseVoltage.nominalVoltage>" + nominalVoltage + "</cim:BaseVoltage.nominalVoltage>\n"
    }
    override def export: String =
    {
        "\t<cim:BaseVoltage rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:BaseVoltage>"
    }
}

object BaseVoltage
extends
    Parseable[BaseVoltage]
{
    val nominalVoltage = parse_element (element ("""BaseVoltage.nominalVoltage"""))
    def parse (context: Context): BaseVoltage =
    {
        BaseVoltage(
            IdentifiedObject.parse (context),
            toDouble (nominalVoltage (context), context)
        )
    }
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
        sup.export_fields +
        (if (null != startTime) "\t\t<cim:BasicIntervalSchedule.startTime>" + startTime + "</cim:BasicIntervalSchedule.startTime>\n" else "") +
        (if (null != value1Multiplier) "\t\t<cim:BasicIntervalSchedule.value1Multiplier rdf:resource=\"#" + value1Multiplier + "\"/>\n" else "") +
        (if (null != value1Unit) "\t\t<cim:BasicIntervalSchedule.value1Unit rdf:resource=\"#" + value1Unit + "\"/>\n" else "") +
        (if (null != value2Multiplier) "\t\t<cim:BasicIntervalSchedule.value2Multiplier rdf:resource=\"#" + value2Multiplier + "\"/>\n" else "") +
        (if (null != value2Unit) "\t\t<cim:BasicIntervalSchedule.value2Unit rdf:resource=\"#" + value2Unit + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:BasicIntervalSchedule rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:BasicIntervalSchedule>"
    }
}

object BasicIntervalSchedule
extends
    Parseable[BasicIntervalSchedule]
{
    val startTime = parse_element (element ("""BasicIntervalSchedule.startTime"""))
    val value1Multiplier = parse_attribute (attribute ("""BasicIntervalSchedule.value1Multiplier"""))
    val value1Unit = parse_attribute (attribute ("""BasicIntervalSchedule.value1Unit"""))
    val value2Multiplier = parse_attribute (attribute ("""BasicIntervalSchedule.value2Multiplier"""))
    val value2Unit = parse_attribute (attribute ("""BasicIntervalSchedule.value2Unit"""))
    def parse (context: Context): BasicIntervalSchedule =
    {
        BasicIntervalSchedule(
            IdentifiedObject.parse (context),
            startTime (context),
            value1Multiplier (context),
            value1Unit (context),
            value2Multiplier (context),
            value2Unit (context)
        )
    }
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
        sup.export_fields +
        "\t\t<cim:Bay.bayEnergyMeasFlag>" + bayEnergyMeasFlag + "</cim:Bay.bayEnergyMeasFlag>\n" +
        "\t\t<cim:Bay.bayPowerMeasFlag>" + bayPowerMeasFlag + "</cim:Bay.bayPowerMeasFlag>\n" +
        (if (null != breakerConfiguration) "\t\t<cim:Bay.breakerConfiguration rdf:resource=\"#" + breakerConfiguration + "\"/>\n" else "") +
        (if (null != busBarConfiguration) "\t\t<cim:Bay.busBarConfiguration rdf:resource=\"#" + busBarConfiguration + "\"/>\n" else "") +
        (if (null != Substation) "\t\t<cim:Bay.Substation rdf:resource=\"#" + Substation + "\"/>\n" else "") +
        (if (null != VoltageLevel) "\t\t<cim:Bay.VoltageLevel rdf:resource=\"#" + VoltageLevel + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Bay rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Bay>"
    }
}

object Bay
extends
    Parseable[Bay]
{
    val bayEnergyMeasFlag = parse_element (element ("""Bay.bayEnergyMeasFlag"""))
    val bayPowerMeasFlag = parse_element (element ("""Bay.bayPowerMeasFlag"""))
    val breakerConfiguration = parse_attribute (attribute ("""Bay.breakerConfiguration"""))
    val busBarConfiguration = parse_attribute (attribute ("""Bay.busBarConfiguration"""))
    val Substation = parse_attribute (attribute ("""Bay.Substation"""))
    val VoltageLevel = parse_attribute (attribute ("""Bay.VoltageLevel"""))
    def parse (context: Context): Bay =
    {
        Bay(
            EquipmentContainer.parse (context),
            toBoolean (bayEnergyMeasFlag (context), context),
            toBoolean (bayPowerMeasFlag (context), context),
            breakerConfiguration (context),
            busBarConfiguration (context),
            Substation (context),
            VoltageLevel (context)
        )
    }
}

/**
 * The parts of the AC power system that are designed to carry current or that are conductively connected through terminals.
 *
 * @param sup [[ch.ninecode.model.Equipment Equipment]] Reference to the superclass object.
 * @param BaseVoltage [[ch.ninecode.model.BaseVoltage BaseVoltage]] Base voltage of this conducting equipment.
 *        Use only when there is no voltage level container used and only one base voltage applies.  For example, not used for transformers.
 * @param GroundingAction Action involving grounding operation on this conducting equipment.
 * @param JumpingAction Jumper action involving jumping operation on this conducting equipment.
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
        sup.export_fields +
        (if (null != BaseVoltage) "\t\t<cim:ConductingEquipment.BaseVoltage rdf:resource=\"#" + BaseVoltage + "\"/>\n" else "") +
        (if (null != GroundingAction) "\t\t<cim:ConductingEquipment.GroundingAction rdf:resource=\"#" + GroundingAction + "\"/>\n" else "") +
        (if (null != JumpingAction) "\t\t<cim:ConductingEquipment.JumpingAction rdf:resource=\"#" + JumpingAction + "\"/>\n" else "") +
        (if (null != SvStatus) "\t\t<cim:ConductingEquipment.SvStatus rdf:resource=\"#" + SvStatus + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ConductingEquipment rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ConductingEquipment>"
    }
}

object ConductingEquipment
extends
    Parseable[ConductingEquipment]
{
    val BaseVoltage = parse_attribute (attribute ("""ConductingEquipment.BaseVoltage"""))
    val GroundingAction = parse_attribute (attribute ("""ConductingEquipment.GroundingAction"""))
    val JumpingAction = parse_attribute (attribute ("""ConductingEquipment.JumpingAction"""))
    val SvStatus = parse_attribute (attribute ("""ConductingEquipment.SvStatus"""))
    def parse (context: Context): ConductingEquipment =
    {
        ConductingEquipment(
            Equipment.parse (context),
            BaseVoltage (context),
            GroundingAction (context),
            JumpingAction (context),
            SvStatus (context)
        )
    }
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
        sup.export_fields +
        (if (null != ConnectivityNodeContainer) "\t\t<cim:ConnectivityNode.ConnectivityNodeContainer rdf:resource=\"#" + ConnectivityNodeContainer + "\"/>\n" else "") +
        (if (null != TopologicalNode) "\t\t<cim:ConnectivityNode.TopologicalNode rdf:resource=\"#" + TopologicalNode + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ConnectivityNode rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ConnectivityNode>"
    }
}

object ConnectivityNode
extends
    Parseable[ConnectivityNode]
{
    val ConnectivityNodeContainer = parse_attribute (attribute ("""ConnectivityNode.ConnectivityNodeContainer"""))
    val TopologicalNode = parse_attribute (attribute ("""ConnectivityNode.TopologicalNode"""))
    def parse (context: Context): ConnectivityNode =
    {
        ConnectivityNode(
            IdentifiedObject.parse (context),
            ConnectivityNodeContainer (context),
            TopologicalNode (context)
        )
    }
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:ConnectivityNodeContainer rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ConnectivityNodeContainer>"
    }
}

object ConnectivityNodeContainer
extends
    Parseable[ConnectivityNodeContainer]
{
    def parse (context: Context): ConnectivityNodeContainer =
    {
        ConnectivityNodeContainer(
            PowerSystemResource.parse (context)
        )
    }
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
        sup.export_fields +
        (if (null != curveStyle) "\t\t<cim:Curve.curveStyle rdf:resource=\"#" + curveStyle + "\"/>\n" else "") +
        (if (null != xMultiplier) "\t\t<cim:Curve.xMultiplier rdf:resource=\"#" + xMultiplier + "\"/>\n" else "") +
        (if (null != xUnit) "\t\t<cim:Curve.xUnit rdf:resource=\"#" + xUnit + "\"/>\n" else "") +
        (if (null != y1Multiplier) "\t\t<cim:Curve.y1Multiplier rdf:resource=\"#" + y1Multiplier + "\"/>\n" else "") +
        (if (null != y1Unit) "\t\t<cim:Curve.y1Unit rdf:resource=\"#" + y1Unit + "\"/>\n" else "") +
        (if (null != y2Multiplier) "\t\t<cim:Curve.y2Multiplier rdf:resource=\"#" + y2Multiplier + "\"/>\n" else "") +
        (if (null != y2Unit) "\t\t<cim:Curve.y2Unit rdf:resource=\"#" + y2Unit + "\"/>\n" else "") +
        (if (null != y3Multiplier) "\t\t<cim:Curve.y3Multiplier rdf:resource=\"#" + y3Multiplier + "\"/>\n" else "") +
        (if (null != y3Unit) "\t\t<cim:Curve.y3Unit rdf:resource=\"#" + y3Unit + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Curve rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Curve>"
    }
}

object Curve
extends
    Parseable[Curve]
{
    val curveStyle = parse_attribute (attribute ("""Curve.curveStyle"""))
    val xMultiplier = parse_attribute (attribute ("""Curve.xMultiplier"""))
    val xUnit = parse_attribute (attribute ("""Curve.xUnit"""))
    val y1Multiplier = parse_attribute (attribute ("""Curve.y1Multiplier"""))
    val y1Unit = parse_attribute (attribute ("""Curve.y1Unit"""))
    val y2Multiplier = parse_attribute (attribute ("""Curve.y2Multiplier"""))
    val y2Unit = parse_attribute (attribute ("""Curve.y2Unit"""))
    val y3Multiplier = parse_attribute (attribute ("""Curve.y3Multiplier"""))
    val y3Unit = parse_attribute (attribute ("""Curve.y3Unit"""))
    def parse (context: Context): Curve =
    {
        Curve(
            IdentifiedObject.parse (context),
            curveStyle (context),
            xMultiplier (context),
            xUnit (context),
            y1Multiplier (context),
            y1Unit (context),
            y2Multiplier (context),
            y2Unit (context),
            y3Multiplier (context),
            y3Unit (context)
        )
    }
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
        sup.export_fields +
        "\t\t<cim:CurveData.xvalue>" + xvalue + "</cim:CurveData.xvalue>\n" +
        "\t\t<cim:CurveData.y1value>" + y1value + "</cim:CurveData.y1value>\n" +
        "\t\t<cim:CurveData.y2value>" + y2value + "</cim:CurveData.y2value>\n" +
        "\t\t<cim:CurveData.y3value>" + y3value + "</cim:CurveData.y3value>\n" +
        (if (null != Curve) "\t\t<cim:CurveData.Curve rdf:resource=\"#" + Curve + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:CurveData rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CurveData>"
    }
}

object CurveData
extends
    Parseable[CurveData]
{
    val xvalue = parse_element (element ("""CurveData.xvalue"""))
    val y1value = parse_element (element ("""CurveData.y1value"""))
    val y2value = parse_element (element ("""CurveData.y2value"""))
    val y3value = parse_element (element ("""CurveData.y3value"""))
    val Curve = parse_attribute (attribute ("""CurveData.Curve"""))
    def parse (context: Context): CurveData =
    {
        CurveData(
            BasicElement.parse (context),
            toDouble (xvalue (context), context),
            toDouble (y1value (context), context),
            toDouble (y2value (context), context),
            toDouble (y3value (context), context),
            Curve (context)
        )
    }
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
        sup.export_fields +
        "\t\t<cim:Equipment.aggregate>" + aggregate + "</cim:Equipment.aggregate>\n" +
        "\t\t<cim:Equipment.normallyInService>" + normallyInService + "</cim:Equipment.normallyInService>\n" +
        (if (null != EquipmentContainer) "\t\t<cim:Equipment.EquipmentContainer rdf:resource=\"#" + EquipmentContainer + "\"/>\n" else "") +
        (if (null != WeatherStation) WeatherStation.map (x => "\t\t<cim:Equipment.WeatherStation rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:Equipment rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Equipment>"
    }
}

object Equipment
extends
    Parseable[Equipment]
{
    val aggregate = parse_element (element ("""Equipment.aggregate"""))
    val normallyInService = parse_element (element ("""Equipment.normallyInService"""))
    val EquipmentContainer = parse_attribute (attribute ("""Equipment.EquipmentContainer"""))
    val WeatherStation = parse_attributes (attribute ("""Equipment.WeatherStation"""))
    def parse (context: Context): Equipment =
    {
        Equipment(
            PowerSystemResource.parse (context),
            toBoolean (aggregate (context), context),
            toBoolean (normallyInService (context), context),
            EquipmentContainer (context),
            WeatherStation (context)
        )
    }
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:EquipmentContainer rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:EquipmentContainer>"
    }
}

object EquipmentContainer
extends
    Parseable[EquipmentContainer]
{
    def parse (context: Context): EquipmentContainer =
    {
        EquipmentContainer(
            ConnectivityNodeContainer.parse (context)
        )
    }
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:GeographicalRegion rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GeographicalRegion>"
    }
}

object GeographicalRegion
extends
    Parseable[GeographicalRegion]
{
    def parse (context: Context): GeographicalRegion =
    {
        GeographicalRegion(
            IdentifiedObject.parse (context)
        )
    }
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
        sup.export_fields +
        (if (null != aliasName) "\t\t<cim:IdentifiedObject.aliasName>" + aliasName + "</cim:IdentifiedObject.aliasName>\n" else "") +
        (if (null != description) "\t\t<cim:IdentifiedObject.description>" + description + "</cim:IdentifiedObject.description>\n" else "") +
        (if (null != name) "\t\t<cim:IdentifiedObject.name>" + name + "</cim:IdentifiedObject.name>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:IdentifiedObject rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:IdentifiedObject>"
    }
}

object IdentifiedObject
extends
    Parseable[IdentifiedObject]
{
    val aliasName = parse_element (element ("""IdentifiedObject.aliasName"""))
    val description = parse_element (element ("""IdentifiedObject.description"""))
    val mRID = parse_element (element ("""IdentifiedObject.mRID"""))
    val name = parse_element (element ("""IdentifiedObject.name"""))
    def parse (context: Context): IdentifiedObject =
    {
        val base = BasicElement.parse (context)
        IdentifiedObject(
            base,
            aliasName (context),
            description (context),
            base.id,
            name (context)
        )
    }
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:IrregularIntervalSchedule rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:IrregularIntervalSchedule>"
    }
}

object IrregularIntervalSchedule
extends
    Parseable[IrregularIntervalSchedule]
{
    def parse (context: Context): IrregularIntervalSchedule =
    {
        IrregularIntervalSchedule(
            BasicIntervalSchedule.parse (context)
        )
    }
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
 * @param IntervalSchedule An IrregularTimePoint belongs to an IrregularIntervalSchedule.
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
        sup.export_fields +
        "\t\t<cim:IrregularTimePoint.time>" + time + "</cim:IrregularTimePoint.time>\n" +
        "\t\t<cim:IrregularTimePoint.value1>" + value1 + "</cim:IrregularTimePoint.value1>\n" +
        "\t\t<cim:IrregularTimePoint.value2>" + value2 + "</cim:IrregularTimePoint.value2>\n" +
        (if (null != IntervalSchedule) "\t\t<cim:IrregularTimePoint.IntervalSchedule rdf:resource=\"#" + IntervalSchedule + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:IrregularTimePoint rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:IrregularTimePoint>"
    }
}

object IrregularTimePoint
extends
    Parseable[IrregularTimePoint]
{
    val time = parse_element (element ("""IrregularTimePoint.time"""))
    val value1 = parse_element (element ("""IrregularTimePoint.value1"""))
    val value2 = parse_element (element ("""IrregularTimePoint.value2"""))
    val IntervalSchedule = parse_attribute (attribute ("""IrregularTimePoint.IntervalSchedule"""))
    def parse (context: Context): IrregularTimePoint =
    {
        IrregularTimePoint(
            BasicElement.parse (context),
            toDouble (time (context), context),
            toDouble (value1 (context), context),
            toDouble (value2 (context), context),
            IntervalSchedule (context)
        )
    }
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
        sup.export_fields +
        (if (null != name) "\t\t<cim:Name.name>" + name + "</cim:Name.name>\n" else "") +
        (if (null != IdentifiedObject) "\t\t<cim:Name.IdentifiedObject rdf:resource=\"#" + IdentifiedObject + "\"/>\n" else "") +
        (if (null != NameType) "\t\t<cim:Name.NameType rdf:resource=\"#" + NameType + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Name rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Name>"
    }
}

object Name
extends
    Parseable[Name]
{
    val name = parse_element (element ("""Name.name"""))
    val IdentifiedObject = parse_attribute (attribute ("""Name.IdentifiedObject"""))
    val NameType = parse_attribute (attribute ("""Name.NameType"""))
    def parse (context: Context): Name =
    {
        Name(
            BasicElement.parse (context),
            name (context),
            IdentifiedObject (context),
            NameType (context)
        )
    }
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
        sup.export_fields +
        (if (null != description) "\t\t<cim:NameType.description>" + description + "</cim:NameType.description>\n" else "") +
        (if (null != name) "\t\t<cim:NameType.name>" + name + "</cim:NameType.name>\n" else "") +
        (if (null != NameTypeAuthority) "\t\t<cim:NameType.NameTypeAuthority rdf:resource=\"#" + NameTypeAuthority + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:NameType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:NameType>"
    }
}

object NameType
extends
    Parseable[NameType]
{
    val description = parse_element (element ("""NameType.description"""))
    val name = parse_element (element ("""NameType.name"""))
    val NameTypeAuthority = parse_attribute (attribute ("""NameType.NameTypeAuthority"""))
    def parse (context: Context): NameType =
    {
        NameType(
            BasicElement.parse (context),
            description (context),
            name (context),
            NameTypeAuthority (context)
        )
    }
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
        sup.export_fields +
        (if (null != description) "\t\t<cim:NameTypeAuthority.description>" + description + "</cim:NameTypeAuthority.description>\n" else "") +
        (if (null != name) "\t\t<cim:NameTypeAuthority.name>" + name + "</cim:NameTypeAuthority.name>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:NameTypeAuthority rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:NameTypeAuthority>"
    }
}

object NameTypeAuthority
extends
    Parseable[NameTypeAuthority]
{
    val description = parse_element (element ("""NameTypeAuthority.description"""))
    val name = parse_element (element ("""NameTypeAuthority.name"""))
    def parse (context: Context): NameTypeAuthority =
    {
        NameTypeAuthority(
            BasicElement.parse (context),
            description (context),
            name (context)
        )
    }
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:OperatingParticipant rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:OperatingParticipant>"
    }
}

object OperatingParticipant
extends
    Parseable[OperatingParticipant]
{
    def parse (context: Context): OperatingParticipant =
    {
        OperatingParticipant(
            IdentifiedObject.parse (context)
        )
    }
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
        sup.export_fields +
        "\t\t<cim:OperatingShare.percentage>" + percentage + "</cim:OperatingShare.percentage>\n" +
        (if (null != OperatingParticipant) "\t\t<cim:OperatingShare.OperatingParticipant rdf:resource=\"#" + OperatingParticipant + "\"/>\n" else "") +
        (if (null != PowerSystemResource) "\t\t<cim:OperatingShare.PowerSystemResource rdf:resource=\"#" + PowerSystemResource + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:OperatingShare rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:OperatingShare>"
    }
}

object OperatingShare
extends
    Parseable[OperatingShare]
{
    val percentage = parse_element (element ("""OperatingShare.percentage"""))
    val OperatingParticipant = parse_attribute (attribute ("""OperatingShare.OperatingParticipant"""))
    val PowerSystemResource = parse_attribute (attribute ("""OperatingShare.PowerSystemResource"""))
    def parse (context: Context): OperatingShare =
    {
        OperatingShare(
            BasicElement.parse (context),
            toDouble (percentage (context), context),
            OperatingParticipant (context),
            PowerSystemResource (context)
        )
    }
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:PSRType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PSRType>"
    }
}

object PSRType
extends
    Parseable[PSRType]
{
    def parse (context: Context): PSRType =
    {
        PSRType(
            IdentifiedObject.parse (context)
        )
    }
}

/**
 * A power system resource can be an item of equipment such as a switch, an equipment container containing many individual items of equipment such as a substation, or an organisational entity such as sub-control area.
 *
 * Power system resources can have measurements associated.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param AssetDatasheet Datasheet information for this power system resource.
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
        sup.export_fields +
        (if (null != AssetDatasheet) "\t\t<cim:PowerSystemResource.AssetDatasheet rdf:resource=\"#" + AssetDatasheet + "\"/>\n" else "") +
        (if (null != Location) "\t\t<cim:PowerSystemResource.Location rdf:resource=\"#" + Location + "\"/>\n" else "") +
        (if (null != PSRType) "\t\t<cim:PowerSystemResource.PSRType rdf:resource=\"#" + PSRType + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:PowerSystemResource rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PowerSystemResource>"
    }
}

object PowerSystemResource
extends
    Parseable[PowerSystemResource]
{
    val AssetDatasheet = parse_attribute (attribute ("""PowerSystemResource.AssetDatasheet"""))
    val Location = parse_attribute (attribute ("""PowerSystemResource.Location"""))
    val PSRType = parse_attribute (attribute ("""PowerSystemResource.PSRType"""))
    def parse (context: Context): PowerSystemResource =
    {
        PowerSystemResource(
            IdentifiedObject.parse (context),
            AssetDatasheet (context),
            Location (context),
            PSRType (context)
        )
    }
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
        sup.export_fields +
        (if (null != endTime) "\t\t<cim:RegularIntervalSchedule.endTime>" + endTime + "</cim:RegularIntervalSchedule.endTime>\n" else "") +
        "\t\t<cim:RegularIntervalSchedule.timeStep>" + timeStep + "</cim:RegularIntervalSchedule.timeStep>\n"
    }
    override def export: String =
    {
        "\t<cim:RegularIntervalSchedule rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RegularIntervalSchedule>"
    }
}

object RegularIntervalSchedule
extends
    Parseable[RegularIntervalSchedule]
{
    val endTime = parse_element (element ("""RegularIntervalSchedule.endTime"""))
    val timeStep = parse_element (element ("""RegularIntervalSchedule.timeStep"""))
    def parse (context: Context): RegularIntervalSchedule =
    {
        RegularIntervalSchedule(
            BasicIntervalSchedule.parse (context),
            endTime (context),
            toDouble (timeStep (context), context)
        )
    }
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
 * @param IntervalSchedule Regular interval schedule containing this time point.
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
        sup.export_fields +
        "\t\t<cim:RegularTimePoint.sequenceNumber>" + sequenceNumber + "</cim:RegularTimePoint.sequenceNumber>\n" +
        "\t\t<cim:RegularTimePoint.value1>" + value1 + "</cim:RegularTimePoint.value1>\n" +
        "\t\t<cim:RegularTimePoint.value2>" + value2 + "</cim:RegularTimePoint.value2>\n" +
        (if (null != IntervalSchedule) "\t\t<cim:RegularTimePoint.IntervalSchedule rdf:resource=\"#" + IntervalSchedule + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:RegularTimePoint rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RegularTimePoint>"
    }
}

object RegularTimePoint
extends
    Parseable[RegularTimePoint]
{
    val sequenceNumber = parse_element (element ("""RegularTimePoint.sequenceNumber"""))
    val value1 = parse_element (element ("""RegularTimePoint.value1"""))
    val value2 = parse_element (element ("""RegularTimePoint.value2"""))
    val IntervalSchedule = parse_attribute (attribute ("""RegularTimePoint.IntervalSchedule"""))
    def parse (context: Context): RegularTimePoint =
    {
        RegularTimePoint(
            BasicElement.parse (context),
            toInteger (sequenceNumber (context), context),
            toDouble (value1 (context), context),
            toDouble (value2 (context), context),
            IntervalSchedule (context)
        )
    }
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
        sup.export_fields +
        (if (null != PowerSystemResource) PowerSystemResource.map (x => "\t\t<cim:ReportingGroup.PowerSystemResource rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != ReportingSuperGroup) "\t\t<cim:ReportingGroup.ReportingSuperGroup rdf:resource=\"#" + ReportingSuperGroup + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ReportingGroup rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ReportingGroup>"
    }
}

object ReportingGroup
extends
    Parseable[ReportingGroup]
{
    val PowerSystemResource = parse_attributes (attribute ("""ReportingGroup.PowerSystemResource"""))
    val ReportingSuperGroup = parse_attribute (attribute ("""ReportingGroup.ReportingSuperGroup"""))
    def parse (context: Context): ReportingGroup =
    {
        ReportingGroup(
            IdentifiedObject.parse (context),
            PowerSystemResource (context),
            ReportingSuperGroup (context)
        )
    }
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:ReportingSuperGroup rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ReportingSuperGroup>"
    }
}

object ReportingSuperGroup
extends
    Parseable[ReportingSuperGroup]
{
    def parse (context: Context): ReportingSuperGroup =
    {
        ReportingSuperGroup(
            IdentifiedObject.parse (context)
        )
    }
}

/**
 * A subset of a geographical region of a power system network model.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param Region The geographical region to which this sub-geographical region is within.
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
        sup.export_fields +
        (if (null != Region) "\t\t<cim:SubGeographicalRegion.Region rdf:resource=\"#" + Region + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SubGeographicalRegion rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SubGeographicalRegion>"
    }
}

object SubGeographicalRegion
extends
    Parseable[SubGeographicalRegion]
{
    val Region = parse_attribute (attribute ("""SubGeographicalRegion.Region"""))
    def parse (context: Context): SubGeographicalRegion =
    {
        SubGeographicalRegion(
            IdentifiedObject.parse (context),
            Region (context)
        )
    }
}

/**
 * A collection of equipment for purposes other than generation or utilization, through which electric energy in bulk is passed for the purposes of switching or modifying its characteristics.
 *
 * @param sup [[ch.ninecode.model.EquipmentContainer EquipmentContainer]] Reference to the superclass object.
 * @param Region The SubGeographicalRegion containing the substation.
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
        sup.export_fields +
        (if (null != Region) "\t\t<cim:Substation.Region rdf:resource=\"#" + Region + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Substation rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Substation>"
    }
}

object Substation
extends
    Parseable[Substation]
{
    val Region = parse_attribute (attribute ("""Substation.Region"""))
    def parse (context: Context): Substation =
    {
        Substation(
            EquipmentContainer.parse (context),
            Region (context)
        )
    }
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
        sup.export_fields +
        (if (null != phases) "\t\t<cim:Terminal.phases rdf:resource=\"#" + phases + "\"/>\n" else "") +
        (if (null != Bushing) "\t\t<cim:Terminal.Bushing rdf:resource=\"#" + Bushing + "\"/>\n" else "") +
        (if (null != ConductingEquipment) "\t\t<cim:Terminal.ConductingEquipment rdf:resource=\"#" + ConductingEquipment + "\"/>\n" else "") +
        (if (null != ConnectivityNode) "\t\t<cim:Terminal.ConnectivityNode rdf:resource=\"#" + ConnectivityNode + "\"/>\n" else "") +
        (if (null != SvPowerFlow) "\t\t<cim:Terminal.SvPowerFlow rdf:resource=\"#" + SvPowerFlow + "\"/>\n" else "") +
        (if (null != TopologicalNode) "\t\t<cim:Terminal.TopologicalNode rdf:resource=\"#" + TopologicalNode + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Terminal rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Terminal>"
    }
}

object Terminal
extends
    Parseable[Terminal]
{
    val phases = parse_attribute (attribute ("""Terminal.phases"""))
    val Bushing = parse_attribute (attribute ("""Terminal.Bushing"""))
    val ConductingEquipment = parse_attribute (attribute ("""Terminal.ConductingEquipment"""))
    val ConnectivityNode = parse_attribute (attribute ("""Terminal.ConnectivityNode"""))
    val SvPowerFlow = parse_attribute (attribute ("""Terminal.SvPowerFlow"""))
    val TopologicalNode = parse_attribute (attribute ("""Terminal.TopologicalNode"""))
    def parse (context: Context): Terminal =
    {
        Terminal(
            ACDCTerminal.parse (context),
            phases (context),
            Bushing (context),
            ConductingEquipment (context),
            ConnectivityNode (context),
            SvPowerFlow (context),
            TopologicalNode (context)
        )
    }
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
        sup.export_fields +
        "\t\t<cim:VoltageLevel.highVoltageLimit>" + highVoltageLimit + "</cim:VoltageLevel.highVoltageLimit>\n" +
        "\t\t<cim:VoltageLevel.lowVoltageLimit>" + lowVoltageLimit + "</cim:VoltageLevel.lowVoltageLimit>\n" +
        (if (null != BaseVoltage) "\t\t<cim:VoltageLevel.BaseVoltage rdf:resource=\"#" + BaseVoltage + "\"/>\n" else "") +
        (if (null != Substation) "\t\t<cim:VoltageLevel.Substation rdf:resource=\"#" + Substation + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:VoltageLevel rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:VoltageLevel>"
    }
}

object VoltageLevel
extends
    Parseable[VoltageLevel]
{
    val highVoltageLimit = parse_element (element ("""VoltageLevel.highVoltageLimit"""))
    val lowVoltageLimit = parse_element (element ("""VoltageLevel.lowVoltageLimit"""))
    val BaseVoltage = parse_attribute (attribute ("""VoltageLevel.BaseVoltage"""))
    val Substation = parse_attribute (attribute ("""VoltageLevel.Substation"""))
    def parse (context: Context): VoltageLevel =
    {
        VoltageLevel(
            EquipmentContainer.parse (context),
            toDouble (highVoltageLimit (context), context),
            toDouble (lowVoltageLimit (context), context),
            BaseVoltage (context),
            Substation (context)
        )
    }
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