package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities.
 * Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */

/**
 * An electrical connection point (AC or DC) to a piece of conducting equipment.
 * Terminals are connected at physical connection points called connectivity nodes.
 */
case class ACDCTerminal
(

    override val sup: IdentifiedObject,

    /**
     * The connected status is related to a bus-branch model and the topological node to terminal relation.
     * True implies the terminal is connected to the related topological node and false implies it is not.
     */
    val connected: Boolean,

    /**
     * The orientation of the terminal connections for a multiple terminal conducting equipment.
     * The sequence numbering starts with 1 and additional terminals should follow in increasing order.   The first terminal is the "starting point" for a two terminal branch.
     */
    val sequenceNumber: Int,

    /**
     * The bus name marker used to name the bus (topological node).
     */
    val BusNameMarker: String
)
extends
    Element
{
    def this () = { this (null, false, 0, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ACDCTerminal]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ACDCTerminal
extends
    Parseable[ACDCTerminal]
{
    val sup = IdentifiedObject.parse _
    val connected = parse_element (element ("""ACDCTerminal.connected"""))_
    val sequenceNumber = parse_element (element ("""ACDCTerminal.sequenceNumber"""))_
    val BusNameMarker = parse_attribute (attribute ("""ACDCTerminal.BusNameMarker"""))_
    def parse (context: Context): ACDCTerminal =
    {
        ACDCTerminal(
            sup (context),
            toBoolean (connected (context), context),
            toInteger (sequenceNumber (context), context),
            BusNameMarker (context)
        )
    }
}

/**
 * The class describe a base frequency for a power system network.
 * In case of multiple power networks with different frequencies, e.g. 50 or 60 Hertz each network will have it's own base frequency class. Hence it is assumed that power system objects having different base frequencies appear in separate documents where each document has a single base frequency instance.
 */
case class BaseFrequency
(

    override val sup: IdentifiedObject,

    /**
     * The base frequency.
     */
    val frequency: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[BaseFrequency]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BaseFrequency
extends
    Parseable[BaseFrequency]
{
    val sup = IdentifiedObject.parse _
    val frequency = parse_element (element ("""BaseFrequency.frequency"""))_
    def parse (context: Context): BaseFrequency =
    {
        BaseFrequency(
            sup (context),
            toDouble (frequency (context), context)
        )
    }
}

/**
 * The BasePower class defines the base power used in the per unit calculations.
 */
case class BasePower
(

    override val sup: IdentifiedObject,

    /**
     * Value used as base power.
     */
    val basePower: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[BasePower]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BasePower
extends
    Parseable[BasePower]
{
    val sup = IdentifiedObject.parse _
    val basePower = parse_element (element ("""BasePower.basePower"""))_
    def parse (context: Context): BasePower =
    {
        BasePower(
            sup (context),
            toDouble (basePower (context), context)
        )
    }
}

/**
 * Defines a system base voltage which is referenced.
 */
case class BaseVoltage
(

    override val sup: IdentifiedObject,

    /**
     * The power system resource's base voltage.
     */
    val nominalVoltage: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[BaseVoltage]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BaseVoltage
extends
    Parseable[BaseVoltage]
{
    val sup = IdentifiedObject.parse _
    val nominalVoltage = parse_element (element ("""BaseVoltage.nominalVoltage"""))_
    def parse (context: Context): BaseVoltage =
    {
        BaseVoltage(
            sup (context),
            toDouble (nominalVoltage (context), context)
        )
    }
}

/**
 * Schedule of values at points in time.
 */
case class BasicIntervalSchedule
(

    override val sup: IdentifiedObject,

    /**
     * The time for the first time point.
     */
    val startTime: String,

    /**
     * Multiplier for value1.
     */
    val value1Multiplier: String,

    /**
     * Value1 units of measure.
     */
    val value1Unit: String,

    /**
     * Multiplier for value2.
     */
    val value2Multiplier: String,

    /**
     * Value2 units of measure.
     */
    val value2Unit: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[BasicIntervalSchedule]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BasicIntervalSchedule
extends
    Parseable[BasicIntervalSchedule]
{
    val sup = IdentifiedObject.parse _
    val startTime = parse_element (element ("""BasicIntervalSchedule.startTime"""))_
    val value1Multiplier = parse_attribute (attribute ("""BasicIntervalSchedule.value1Multiplier"""))_
    val value1Unit = parse_attribute (attribute ("""BasicIntervalSchedule.value1Unit"""))_
    val value2Multiplier = parse_attribute (attribute ("""BasicIntervalSchedule.value2Multiplier"""))_
    val value2Unit = parse_attribute (attribute ("""BasicIntervalSchedule.value2Unit"""))_
    def parse (context: Context): BasicIntervalSchedule =
    {
        BasicIntervalSchedule(
            sup (context),
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
 * A bay typically represents a physical grouping related to modularization of equipment.
 */
case class Bay
(

    override val sup: EquipmentContainer,

    /**
     * Indicates the presence/absence of energy measurements.
     */
    val bayEnergyMeasFlag: Boolean,

    /**
     * Indicates the presence/absence of active/reactive power measurements.
     */
    val bayPowerMeasFlag: Boolean,

    /**
     * Breaker configuration.
     */
    val breakerConfiguration: String,

    /**
     * Bus bar configuration.
     */
    val busBarConfiguration: String,

    /**
     * Substation containing the bay.
     */
    val Substation: String,

    /**
     * The voltage level containing this bay.
     */
    val VoltageLevel: String
)
extends
    Element
{
    def this () = { this (null, false, false, null, null, null, null) }
    def EquipmentContainer: EquipmentContainer = sup.asInstanceOf[EquipmentContainer]
    override def copy (): Row = { return (clone ().asInstanceOf[Bay]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Bay
extends
    Parseable[Bay]
{
    val sup = EquipmentContainer.parse _
    val bayEnergyMeasFlag = parse_element (element ("""Bay.bayEnergyMeasFlag"""))_
    val bayPowerMeasFlag = parse_element (element ("""Bay.bayPowerMeasFlag"""))_
    val breakerConfiguration = parse_attribute (attribute ("""Bay.breakerConfiguration"""))_
    val busBarConfiguration = parse_attribute (attribute ("""Bay.busBarConfiguration"""))_
    val Substation = parse_attribute (attribute ("""Bay.Substation"""))_
    val VoltageLevel = parse_attribute (attribute ("""Bay.VoltageLevel"""))_
    def parse (context: Context): Bay =
    {
        Bay(
            sup (context),
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
 * Switching arrangement for bay.
 */
case class BreakerConfiguration
(

    override val sup: BasicElement,

    /**
     * Breaker and a half.
     */
    val breakerAndAHalf: String,

    /**
     * Double breaker.
     */
    val doubleBreaker: String,

    /**
     * No breaker.
     */
    val noBreaker: String,

    /**
     * Single breaker.
     */
    val singleBreaker: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[BreakerConfiguration]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BreakerConfiguration
extends
    Parseable[BreakerConfiguration]
{
    val sup = BasicElement.parse _
    val breakerAndAHalf = parse_attribute (attribute ("""BreakerConfiguration.breakerAndAHalf"""))_
    val doubleBreaker = parse_attribute (attribute ("""BreakerConfiguration.doubleBreaker"""))_
    val noBreaker = parse_attribute (attribute ("""BreakerConfiguration.noBreaker"""))_
    val singleBreaker = parse_attribute (attribute ("""BreakerConfiguration.singleBreaker"""))_
    def parse (context: Context): BreakerConfiguration =
    {
        BreakerConfiguration(
            sup (context),
            breakerAndAHalf (context),
            doubleBreaker (context),
            noBreaker (context),
            singleBreaker (context)
        )
    }
}

/**
 * Busbar layout for bay.
 */
case class BusbarConfiguration
(

    override val sup: BasicElement,

    /**
     * Double bus.
     */
    val doubleBus: String,

    /**
     * Main bus with transfer bus.
     */
    val mainWithTransfer: String,

    /**
     * Ring bus.
     */
    val ringBus: String,

    /**
     * Single bus.
     */
    val singleBus: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[BusbarConfiguration]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BusbarConfiguration
extends
    Parseable[BusbarConfiguration]
{
    val sup = BasicElement.parse _
    val doubleBus = parse_attribute (attribute ("""BusbarConfiguration.doubleBus"""))_
    val mainWithTransfer = parse_attribute (attribute ("""BusbarConfiguration.mainWithTransfer"""))_
    val ringBus = parse_attribute (attribute ("""BusbarConfiguration.ringBus"""))_
    val singleBus = parse_attribute (attribute ("""BusbarConfiguration.singleBus"""))_
    def parse (context: Context): BusbarConfiguration =
    {
        BusbarConfiguration(
            sup (context),
            doubleBus (context),
            mainWithTransfer (context),
            ringBus (context),
            singleBus (context)
        )
    }
}

/**
 * The parts of the AC power system that are designed to carry current or that are conductively connected through terminals.
 */
case class ConductingEquipment
(

    override val sup: Equipment,

    /**
     * Base voltage of this conducting equipment.
     * Use only when there is no voltage level container used and only one base voltage applies.  For example, not used for transformers.
     */
    val BaseVoltage: String,

    /**
     * Action involving grounding operation on this conducting equipment.
     */
    val GroundingAction: String,

    /**
     * Jumper action involving jumping operation on this conducting equipment.
     */
    val JumpingAction: String,

    /**
     * The status state variable associated with this conducting equipment.
     */
    val SvStatus: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Equipment: Equipment = sup.asInstanceOf[Equipment]
    override def copy (): Row = { return (clone ().asInstanceOf[ConductingEquipment]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ConductingEquipment
extends
    Parseable[ConductingEquipment]
{
    val sup = Equipment.parse _
    val BaseVoltage = parse_attribute (attribute ("""ConductingEquipment.BaseVoltage"""))_
    val GroundingAction = parse_attribute (attribute ("""ConductingEquipment.GroundingAction"""))_
    val JumpingAction = parse_attribute (attribute ("""ConductingEquipment.JumpingAction"""))_
    val SvStatus = parse_attribute (attribute ("""ConductingEquipment.SvStatus"""))_
    def parse (context: Context): ConductingEquipment =
    {
        ConductingEquipment(
            sup (context),
            BaseVoltage (context),
            GroundingAction (context),
            JumpingAction (context),
            SvStatus (context)
        )
    }
}

/**
 * Connectivity nodes are points where terminals of AC conducting equipment are connected together with zero impedance.
 */
case class ConnectivityNode
(

    override val sup: IdentifiedObject,

    /**
     * Container of this connectivity node.
     */
    val ConnectivityNodeContainer: String,

    /**
     * The topological node to which this connectivity node is assigned.
     * May depend on the current state of switches in the network.
     */
    val TopologicalNode: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ConnectivityNode]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ConnectivityNode
extends
    Parseable[ConnectivityNode]
{
    val sup = IdentifiedObject.parse _
    val ConnectivityNodeContainer = parse_attribute (attribute ("""ConnectivityNode.ConnectivityNodeContainer"""))_
    val TopologicalNode = parse_attribute (attribute ("""ConnectivityNode.TopologicalNode"""))_
    def parse (context: Context): ConnectivityNode =
    {
        ConnectivityNode(
            sup (context),
            ConnectivityNodeContainer (context),
            TopologicalNode (context)
        )
    }
}

/**
 * A base class for all objects that may contain connectivity nodes or topological nodes.
 */
case class ConnectivityNodeContainer
(

    override val sup: PowerSystemResource
)
extends
    Element
{
    def this () = { this (null) }
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { return (clone ().asInstanceOf[ConnectivityNodeContainer]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ConnectivityNodeContainer
extends
    Parseable[ConnectivityNodeContainer]
{
    val sup = PowerSystemResource.parse _
    def parse (context: Context): ConnectivityNodeContainer =
    {
        ConnectivityNodeContainer(
            sup (context)
        )
    }
}

/**
 * A multi-purpose curve or functional relationship between an independent variable (X-axis) and dependent (Y-axis) variables.
 */
case class Curve
(

    override val sup: IdentifiedObject,

    /**
     * The style or shape of the curve.
     */
    val curveStyle: String,

    /**
     * Multiplier for X-axis.
     */
    val xMultiplier: String,

    /**
     * The X-axis units of measure.
     */
    val xUnit: String,

    /**
     * Multiplier for Y1-axis.
     */
    val y1Multiplier: String,

    /**
     * The Y1-axis units of measure.
     */
    val y1Unit: String,

    /**
     * Multiplier for Y2-axis.
     */
    val y2Multiplier: String,

    /**
     * The Y2-axis units of measure.
     */
    val y2Unit: String,

    /**
     * Multiplier for Y3-axis.
     */
    val y3Multiplier: String,

    /**
     * The Y3-axis units of measure.
     */
    val y3Unit: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Curve]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Curve
extends
    Parseable[Curve]
{
    val sup = IdentifiedObject.parse _
    val curveStyle = parse_attribute (attribute ("""Curve.curveStyle"""))_
    val xMultiplier = parse_attribute (attribute ("""Curve.xMultiplier"""))_
    val xUnit = parse_attribute (attribute ("""Curve.xUnit"""))_
    val y1Multiplier = parse_attribute (attribute ("""Curve.y1Multiplier"""))_
    val y1Unit = parse_attribute (attribute ("""Curve.y1Unit"""))_
    val y2Multiplier = parse_attribute (attribute ("""Curve.y2Multiplier"""))_
    val y2Unit = parse_attribute (attribute ("""Curve.y2Unit"""))_
    val y3Multiplier = parse_attribute (attribute ("""Curve.y3Multiplier"""))_
    val y3Unit = parse_attribute (attribute ("""Curve.y3Unit"""))_
    def parse (context: Context): Curve =
    {
        Curve(
            sup (context),
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
 * The use of this generic class is discouraged if a more specific class  can be used to specify the x and y axis values along with their specific data types.
 */
case class CurveData
(

    override val sup: BasicElement,

    /**
     * The data value of the X-axis variable,  depending on the X-axis units.
     */
    val xvalue: Double,

    /**
     * The data value of the  first Y-axis variable, depending on the Y-axis units.
     */
    val y1value: Double,

    /**
     * The data value of the second Y-axis variable (if present), depending on the Y-axis units.
     */
    val y2value: Double,

    /**
     * The data value of the third Y-axis variable (if present), depending on the Y-axis units.
     */
    val y3value: Double,

    /**
     * The curve of  this curve data point.
     */
    val Curve: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[CurveData]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CurveData
extends
    Parseable[CurveData]
{
    val sup = BasicElement.parse _
    val xvalue = parse_element (element ("""CurveData.xvalue"""))_
    val y1value = parse_element (element ("""CurveData.y1value"""))_
    val y2value = parse_element (element ("""CurveData.y2value"""))_
    val y3value = parse_element (element ("""CurveData.y3value"""))_
    val Curve = parse_attribute (attribute ("""CurveData.Curve"""))_
    def parse (context: Context): CurveData =
    {
        CurveData(
            sup (context),
            toDouble (xvalue (context), context),
            toDouble (y1value (context), context),
            toDouble (y2value (context), context),
            toDouble (y3value (context), context),
            Curve (context)
        )
    }
}

/**
 * Style or shape of curve.
 */
case class CurveStyle
(

    override val sup: BasicElement,

    /**
     * The Y-axis values are assumed constant until the next curve point and prior to the first curve point.
     */
    val constantYValue: String,

    /**
     * The Y-axis values are assumed to be a straight line between values.
     * Also known as linear interpolation.
     */
    val straightLineYValues: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[CurveStyle]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CurveStyle
extends
    Parseable[CurveStyle]
{
    val sup = BasicElement.parse _
    val constantYValue = parse_attribute (attribute ("""CurveStyle.constantYValue"""))_
    val straightLineYValues = parse_attribute (attribute ("""CurveStyle.straightLineYValues"""))_
    def parse (context: Context): CurveStyle =
    {
        CurveStyle(
            sup (context),
            constantYValue (context),
            straightLineYValues (context)
        )
    }
}

/**
 * The parts of a power system that are physical devices, electronic or mechanical.
 */
case class Equipment
(

    override val sup: PowerSystemResource,

    /**
     * The single instance of equipment represents multiple pieces of equipment that have been modeled together as an aggregate.
     * Examples would be power transformers or synchronous machines operating in parallel modeled as a single aggregate power transformer or aggregate synchronous machine.  This is not to be used to indicate equipment that is part of a group of interdependent equipment produced by a network production program.
     */
    val aggregate: Boolean,

    /**
     * If true, the equipment is normally in service.
     */
    val normallyInService: Boolean,

    /**
     * Container of this equipment.
     */
    val EquipmentContainer: String,

    val WeatherStation: List[String]
)
extends
    Element
{
    def this () = { this (null, false, false, null, List()) }
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { return (clone ().asInstanceOf[Equipment]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Equipment
extends
    Parseable[Equipment]
{
    val sup = PowerSystemResource.parse _
    val aggregate = parse_element (element ("""Equipment.aggregate"""))_
    val normallyInService = parse_element (element ("""Equipment.normallyInService"""))_
    val EquipmentContainer = parse_attribute (attribute ("""Equipment.EquipmentContainer"""))_
    val WeatherStation = parse_attributes (attribute ("""Equipment.WeatherStation"""))_
    def parse (context: Context): Equipment =
    {
        Equipment(
            sup (context),
            toBoolean (aggregate (context), context),
            toBoolean (normallyInService (context), context),
            EquipmentContainer (context),
            WeatherStation (context)
        )
    }
}

/**
 * A modeling construct to provide a root class for containing equipment.
 */
case class EquipmentContainer
(

    override val sup: ConnectivityNodeContainer
)
extends
    Element
{
    def this () = { this (null) }
    def ConnectivityNodeContainer: ConnectivityNodeContainer = sup.asInstanceOf[ConnectivityNodeContainer]
    override def copy (): Row = { return (clone ().asInstanceOf[EquipmentContainer]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EquipmentContainer
extends
    Parseable[EquipmentContainer]
{
    val sup = ConnectivityNodeContainer.parse _
    def parse (context: Context): EquipmentContainer =
    {
        EquipmentContainer(
            sup (context)
        )
    }
}

/**
 * A geographical region of a power system network model.
 */
case class GeographicalRegion
(

    override val sup: IdentifiedObject
)
extends
    Element
{
    def this () = { this (null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[GeographicalRegion]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GeographicalRegion
extends
    Parseable[GeographicalRegion]
{
    val sup = IdentifiedObject.parse _
    def parse (context: Context): GeographicalRegion =
    {
        GeographicalRegion(
            sup (context)
        )
    }
}

/**
 * This is a root class to provide common identification for all classes needing identification and naming attributes.
 */
case class IdentifiedObject
(

    override val sup: BasicElement,

    /**
     * The aliasName is free text human readable name of the object alternative to IdentifiedObject.name.
     * It may be non unique and may not correlate to a naming hierarchy.
     */
    val aliasName: String,

    /**
     * The description is a free human readable text describing or naming the object.
     * It may be non unique and may not correlate to a naming hierarchy.
     */
    val description: String,

    /**
     * Master resource identifier issued by a model authority.
     * The mRID is globally unique within an exchange context. Global uniqueness is easily achieved by using a UUID,  as specified in RFC 4122, for the mRID.  The use of UUID is strongly recommended.
     */
    val mRID: String,

    /**
     * The name is any free human readable and possibly non unique text naming the object.
     */
    val name: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[IdentifiedObject]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object IdentifiedObject
extends
    Parseable[IdentifiedObject]
{
    val sup = BasicElement.parse _
    val aliasName = parse_element (element ("""IdentifiedObject.aliasName"""))_
    val description = parse_element (element ("""IdentifiedObject.description"""))_
    val mRID = parse_element (element ("""IdentifiedObject.mRID"""))_
    val name = parse_element (element ("""IdentifiedObject.name"""))_
    def parse (context: Context): IdentifiedObject =
    {
        IdentifiedObject(
            sup (context),
            aliasName (context),
            description (context),
            mRID (context),
            name (context)
        )
    }
}

/**
 * The schedule has time points where the time between them varies.
 */
case class IrregularIntervalSchedule
(

    override val sup: BasicIntervalSchedule
)
extends
    Element
{
    def this () = { this (null) }
    def BasicIntervalSchedule: BasicIntervalSchedule = sup.asInstanceOf[BasicIntervalSchedule]
    override def copy (): Row = { return (clone ().asInstanceOf[IrregularIntervalSchedule]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object IrregularIntervalSchedule
extends
    Parseable[IrregularIntervalSchedule]
{
    val sup = BasicIntervalSchedule.parse _
    def parse (context: Context): IrregularIntervalSchedule =
    {
        IrregularIntervalSchedule(
            sup (context)
        )
    }
}

/**
 * TimePoints for a schedule where the time between the points varies.
 */
case class IrregularTimePoint
(

    override val sup: BasicElement,

    /**
     * The time is relative to the schedule starting time.
     */
    val time: Double,

    /**
     * The first value at the time.
     * The meaning of the value is defined by the derived type of the associated schedule.
     */
    val value1: Double,

    /**
     * The second value at the time.
     * The meaning of the value is defined by the derived type of the associated schedule.
     */
    val value2: Double,

    /**
     * An IrregularTimePoint belongs to an IrregularIntervalSchedule.
     */
    val IntervalSchedule: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[IrregularTimePoint]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object IrregularTimePoint
extends
    Parseable[IrregularTimePoint]
{
    val sup = BasicElement.parse _
    val time = parse_element (element ("""IrregularTimePoint.time"""))_
    val value1 = parse_element (element ("""IrregularTimePoint.value1"""))_
    val value2 = parse_element (element ("""IrregularTimePoint.value2"""))_
    val IntervalSchedule = parse_attribute (attribute ("""IrregularTimePoint.IntervalSchedule"""))_
    def parse (context: Context): IrregularTimePoint =
    {
        IrregularTimePoint(
            sup (context),
            toDouble (time (context), context),
            toDouble (value1 (context), context),
            toDouble (value2 (context), context),
            IntervalSchedule (context)
        )
    }
}

/**
 * The Name class provides the means to define any number of human readable  names for an object.
 * A name is <b>not</b> to be used for defining inter-object relationships. For inter-object relationships instead use the object identification 'mRID'.
 */
case class Name
(

    override val sup: BasicElement,

    /**
     * Any free text that name the object.
     */
    val name: String,

    /**
     * Identified object that this name designates.
     */
    val IdentifiedObject: String,

    /**
     * Type of this name.
     */
    val NameType: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[Name]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Name
extends
    Parseable[Name]
{
    val sup = BasicElement.parse _
    val name = parse_element (element ("""Name.name"""))_
    val IdentifiedObject = parse_attribute (attribute ("""Name.IdentifiedObject"""))_
    val NameType = parse_attribute (attribute ("""Name.NameType"""))_
    def parse (context: Context): Name =
    {
        Name(
            sup (context),
            name (context),
            IdentifiedObject (context),
            NameType (context)
        )
    }
}

/**
 * Type of name.
 * Possible values for attribute 'name' are implementation dependent but standard profiles may specify types. An enterprise may have multiple IT systems each having its own local name for the same object, e.g. a planning system may have different names from an EMS. An object may also have different names within the same IT system, e.g. localName as defined in CIM version 14. The definition from CIM14 is:
 */
case class NameType
(

    override val sup: BasicElement,

    /**
     * Description of the name type.
     */
    val description: String,

    /**
     * Name of the name type.
     */
    val name: String,

    /**
     * Authority responsible for managing names of this type.
     */
    val NameTypeAuthority: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[NameType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object NameType
extends
    Parseable[NameType]
{
    val sup = BasicElement.parse _
    val description = parse_element (element ("""NameType.description"""))_
    val name = parse_element (element ("""NameType.name"""))_
    val NameTypeAuthority = parse_attribute (attribute ("""NameType.NameTypeAuthority"""))_
    def parse (context: Context): NameType =
    {
        NameType(
            sup (context),
            description (context),
            name (context),
            NameTypeAuthority (context)
        )
    }
}

/**
 * Authority responsible for creation and management of names of a given type; typically an organization or an enterprise system.
 */
case class NameTypeAuthority
(

    override val sup: BasicElement,

    /**
     * Description of the name type authority.
     */
    val description: String,

    /**
     * Name of the name type authority.
     */
    val name: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[NameTypeAuthority]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object NameTypeAuthority
extends
    Parseable[NameTypeAuthority]
{
    val sup = BasicElement.parse _
    val description = parse_element (element ("""NameTypeAuthority.description"""))_
    val name = parse_element (element ("""NameTypeAuthority.name"""))_
    def parse (context: Context): NameTypeAuthority =
    {
        NameTypeAuthority(
            sup (context),
            description (context),
            name (context)
        )
    }
}

/**
 * An operator of multiple power system resource objects.
 * Note multple operating participants may operate the same power system resource object.   This can be used for modeling jointly owned units where each owner operates as a contractual share.
 */
case class OperatingParticipant
(

    override val sup: IdentifiedObject
)
extends
    Element
{
    def this () = { this (null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[OperatingParticipant]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OperatingParticipant
extends
    Parseable[OperatingParticipant]
{
    val sup = IdentifiedObject.parse _
    def parse (context: Context): OperatingParticipant =
    {
        OperatingParticipant(
            sup (context)
        )
    }
}

/**
 * Specifies the operations contract relationship between a power system resource and a contract participant.
 */
case class OperatingShare
(

    override val sup: BasicElement,

    /**
     * Percentage operational ownership between the pair (power system resource and operatging participant) associated with this share.
     * The total percentage ownership for a power system resource should add to 100%.
     */
    val percentage: Double,

    /**
     * The operating participant having this share with the associated power system resource.
     */
    val OperatingParticipant: String,

    /**
     * The power system resource to which the share applies.
     */
    val PowerSystemResource: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[OperatingShare]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OperatingShare
extends
    Parseable[OperatingShare]
{
    val sup = BasicElement.parse _
    val percentage = parse_element (element ("""OperatingShare.percentage"""))_
    val OperatingParticipant = parse_attribute (attribute ("""OperatingShare.OperatingParticipant"""))_
    val PowerSystemResource = parse_attribute (attribute ("""OperatingShare.PowerSystemResource"""))_
    def parse (context: Context): OperatingShare =
    {
        OperatingShare(
            sup (context),
            toDouble (percentage (context), context),
            OperatingParticipant (context),
            PowerSystemResource (context)
        )
    }
}

/**
 * Classifying instances of the same class, e.g. overhead and underground ACLineSegments.
 * This classification mechanism is intended to provide flexibility outside the scope of this standard, i.e. provide customisation that is non standard.
 */
case class PSRType
(

    override val sup: IdentifiedObject
)
extends
    Element
{
    def this () = { this (null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[PSRType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PSRType
extends
    Parseable[PSRType]
{
    val sup = IdentifiedObject.parse _
    def parse (context: Context): PSRType =
    {
        PSRType(
            sup (context)
        )
    }
}

/**
 * Enumeration of phase identifiers.
 * Allows designation of phases for both transmission and distribution equipment, circuits and loads.
 */
case class PhaseCode
(

    override val sup: BasicElement,

    /**
     * Secondary phase 1.
     */
    val s1: String,

    /**
     * Secondary phase 1 and 2.
     */
    val s12: String,

    /**
     * Secondary phases 1, 2, and neutral.
     */
    val s12N: String,

    /**
     * Secondary phase 1 and neutral.
     */
    val s1N: String,

    /**
     * Secondary phase 2.
     */
    val s2: String,

    /**
     * Secondary phase 2 and neutral.
     */
    val s2N: String,

    /**
     * Phase A.
     */
    val A: String,

    /**
     * Phases A and B.
     */
    val AB: String,

    /**
     * Phases A, B, and C.
     */
    val ABC: String,

    /**
     * Phases A, B, C, and N.
     */
    val ABCN: String,

    /**
     * Phases A, B, and neutral.
     */
    val ABN: String,

    /**
     * Phases A and C.
     */
    val AC: String,

    /**
     * Phases A, C and neutral.
     */
    val ACN: String,

    /**
     * Phases A and neutral.
     */
    val AN: String,

    /**
     * Phase B.
     */
    val B: String,

    /**
     * Phases B and C.
     */
    val BC: String,

    /**
     * Phases B, C, and neutral.
     */
    val BCN: String,

    /**
     * Phases B and neutral.
     */
    val BN: String,

    /**
     * Phase C.
     */
    val C: String,

    /**
     * Phases C and neutral.
     */
    val CN: String,

    /**
     * Neutral phase.
     */
    val N: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[PhaseCode]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PhaseCode
extends
    Parseable[PhaseCode]
{
    val sup = BasicElement.parse _
    val s1 = parse_attribute (attribute ("""PhaseCode.s1"""))_
    val s12 = parse_attribute (attribute ("""PhaseCode.s12"""))_
    val s12N = parse_attribute (attribute ("""PhaseCode.s12N"""))_
    val s1N = parse_attribute (attribute ("""PhaseCode.s1N"""))_
    val s2 = parse_attribute (attribute ("""PhaseCode.s2"""))_
    val s2N = parse_attribute (attribute ("""PhaseCode.s2N"""))_
    val A = parse_attribute (attribute ("""PhaseCode.A"""))_
    val AB = parse_attribute (attribute ("""PhaseCode.AB"""))_
    val ABC = parse_attribute (attribute ("""PhaseCode.ABC"""))_
    val ABCN = parse_attribute (attribute ("""PhaseCode.ABCN"""))_
    val ABN = parse_attribute (attribute ("""PhaseCode.ABN"""))_
    val AC = parse_attribute (attribute ("""PhaseCode.AC"""))_
    val ACN = parse_attribute (attribute ("""PhaseCode.ACN"""))_
    val AN = parse_attribute (attribute ("""PhaseCode.AN"""))_
    val B = parse_attribute (attribute ("""PhaseCode.B"""))_
    val BC = parse_attribute (attribute ("""PhaseCode.BC"""))_
    val BCN = parse_attribute (attribute ("""PhaseCode.BCN"""))_
    val BN = parse_attribute (attribute ("""PhaseCode.BN"""))_
    val C = parse_attribute (attribute ("""PhaseCode.C"""))_
    val CN = parse_attribute (attribute ("""PhaseCode.CN"""))_
    val N = parse_attribute (attribute ("""PhaseCode.N"""))_
    def parse (context: Context): PhaseCode =
    {
        PhaseCode(
            sup (context),
            s1 (context),
            s12 (context),
            s12N (context),
            s1N (context),
            s2 (context),
            s2N (context),
            A (context),
            AB (context),
            ABC (context),
            ABCN (context),
            ABN (context),
            AC (context),
            ACN (context),
            AN (context),
            B (context),
            BC (context),
            BCN (context),
            BN (context),
            C (context),
            CN (context),
            N (context)
        )
    }
}

/**
 * A power system resource can be an item of equipment such as a switch, an equipment container containing many individual items of equipment such as a substation, or an organisational entity such as sub-control area.
 * Power system resources can have measurements associated.
 */
case class PowerSystemResource
(

    override val sup: IdentifiedObject,

    /**
     * Datasheet information for this power system resource.
     */
    val AssetDatasheet: String,

    /**
     * Location of this power system resource.
     */
    val Location: String,

    /**
     * Custom classification for this power system resource.
     */
    val PSRType: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[PowerSystemResource]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PowerSystemResource
extends
    Parseable[PowerSystemResource]
{
    val sup = IdentifiedObject.parse _
    val AssetDatasheet = parse_attribute (attribute ("""PowerSystemResource.AssetDatasheet"""))_
    val Location = parse_attribute (attribute ("""PowerSystemResource.Location"""))_
    val PSRType = parse_attribute (attribute ("""PowerSystemResource.PSRType"""))_
    def parse (context: Context): PowerSystemResource =
    {
        PowerSystemResource(
            sup (context),
            AssetDatasheet (context),
            Location (context),
            PSRType (context)
        )
    }
}

/**
 * The schedule has time points where the time between them is constant.
 */
case class RegularIntervalSchedule
(

    override val sup: BasicIntervalSchedule,

    /**
     * The time for the last time point.
     */
    val endTime: String,

    /**
     * The time between each pair of subsequent regular time points in sequence order.
     */
    val timeStep: Double
)
extends
    Element
{
    def this () = { this (null, null, 0.0) }
    def BasicIntervalSchedule: BasicIntervalSchedule = sup.asInstanceOf[BasicIntervalSchedule]
    override def copy (): Row = { return (clone ().asInstanceOf[RegularIntervalSchedule]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RegularIntervalSchedule
extends
    Parseable[RegularIntervalSchedule]
{
    val sup = BasicIntervalSchedule.parse _
    val endTime = parse_element (element ("""RegularIntervalSchedule.endTime"""))_
    val timeStep = parse_element (element ("""RegularIntervalSchedule.timeStep"""))_
    def parse (context: Context): RegularIntervalSchedule =
    {
        RegularIntervalSchedule(
            sup (context),
            endTime (context),
            toDouble (timeStep (context), context)
        )
    }
}

/**
 * Time point for a schedule where the time between the consecutive points is constant.
 */
case class RegularTimePoint
(

    override val sup: BasicElement,

    /**
     * The position of the regular time point in the sequence.
     * Note that time points don't have to be sequential, i.e. time points may be omitted. The actual time for a RegularTimePoint is computed by multiplying the associated regular interval schedule's time step with the regular time point sequence number and adding the associated schedules start time.
     */
    val sequenceNumber: Int,

    /**
     * The first value at the time.
     * The meaning of the value is defined by the derived type of the associated schedule.
     */
    val value1: Double,

    /**
     * The second value at the time.
     * The meaning of the value is defined by the derived type of the associated schedule.
     */
    val value2: Double,

    /**
     * Regular interval schedule containing this time point.
     */
    val IntervalSchedule: String
)
extends
    Element
{
    def this () = { this (null, 0, 0.0, 0.0, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[RegularTimePoint]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RegularTimePoint
extends
    Parseable[RegularTimePoint]
{
    val sup = BasicElement.parse _
    val sequenceNumber = parse_element (element ("""RegularTimePoint.sequenceNumber"""))_
    val value1 = parse_element (element ("""RegularTimePoint.value1"""))_
    val value2 = parse_element (element ("""RegularTimePoint.value2"""))_
    val IntervalSchedule = parse_attribute (attribute ("""RegularTimePoint.IntervalSchedule"""))_
    def parse (context: Context): RegularTimePoint =
    {
        RegularTimePoint(
            sup (context),
            toInteger (sequenceNumber (context), context),
            toDouble (value1 (context), context),
            toDouble (value2 (context), context),
            IntervalSchedule (context)
        )
    }
}

/**
 * A reporting group is used for various ad-hoc groupings used for reporting.
 */
case class ReportingGroup
(

    override val sup: IdentifiedObject,

    /**
     * Power system resources which belong to this reporting group.
     */
    val PowerSystemResource: List[String]
)
extends
    Element
{
    def this () = { this (null, List()) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ReportingGroup]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ReportingGroup
extends
    Parseable[ReportingGroup]
{
    val sup = IdentifiedObject.parse _
    val PowerSystemResource = parse_attributes (attribute ("""ReportingGroup.PowerSystemResource"""))_
    def parse (context: Context): ReportingGroup =
    {
        ReportingGroup(
            sup (context),
            PowerSystemResource (context)
        )
    }
}

/**
 * A reporting super group, groups reporting groups for a higher level report.
 */
case class ReportingSuperGroup
(

    override val sup: IdentifiedObject
)
extends
    Element
{
    def this () = { this (null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ReportingSuperGroup]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ReportingSuperGroup
extends
    Parseable[ReportingSuperGroup]
{
    val sup = IdentifiedObject.parse _
    def parse (context: Context): ReportingSuperGroup =
    {
        ReportingSuperGroup(
            sup (context)
        )
    }
}

/**
 * A subset of a geographical region of a power system network model.
 */
case class SubGeographicalRegion
(

    override val sup: IdentifiedObject,

    /**
     * The geographical region to which this sub-geographical region is within.
     */
    val Region: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[SubGeographicalRegion]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SubGeographicalRegion
extends
    Parseable[SubGeographicalRegion]
{
    val sup = IdentifiedObject.parse _
    val Region = parse_attribute (attribute ("""SubGeographicalRegion.Region"""))_
    def parse (context: Context): SubGeographicalRegion =
    {
        SubGeographicalRegion(
            sup (context),
            Region (context)
        )
    }
}

/**
 * A collection of equipment for purposes other than generation or utilization, through which electric energy in bulk is passed for the purposes of switching or modifying its characteristics.
 */
case class Substation
(

    override val sup: EquipmentContainer,

    /**
     * The SubGeographicalRegion containing the substation.
     */
    val Region: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def EquipmentContainer: EquipmentContainer = sup.asInstanceOf[EquipmentContainer]
    override def copy (): Row = { return (clone ().asInstanceOf[Substation]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Substation
extends
    Parseable[Substation]
{
    val sup = EquipmentContainer.parse _
    val Region = parse_attribute (attribute ("""Substation.Region"""))_
    def parse (context: Context): Substation =
    {
        Substation(
            sup (context),
            Region (context)
        )
    }
}

/**
 * An AC electrical connection point to a piece of conducting equipment.
 * Terminals are connected at physical connection points called connectivity nodes.
 */
case class Terminal
(

    override val sup: ACDCTerminal,

    /**
     * Represents the normal network phasing condition.
     * If the attribute is missing three phases (ABC or ABCN) shall be assumed.
     */
    val phases: String,

    val Bushing: String,

    /**
     * The conducting equipment of the terminal.
     * Conducting equipment have  terminals that may be connected to other conducting equipment terminals via connectivity nodes or topological nodes.
     */
    val ConductingEquipment: String,

    /**
     * The connectivity node to which this terminal connects with zero impedance.
     */
    val ConnectivityNode: String,

    /**
     * The power flow state variable associated with the terminal.
     */
    val SvPowerFlow: String,

    /**
     * The topological node associated with the terminal.
     * This can be used as an alternative to the connectivity node path to topological node, thus making it unneccesary to model connectivity nodes in some cases.   Note that the if connectivity nodes are in the model, this association would probably not be used as an input specification.
     */
    val TopologicalNode: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null) }
    def ACDCTerminal: ACDCTerminal = sup.asInstanceOf[ACDCTerminal]
    override def copy (): Row = { return (clone ().asInstanceOf[Terminal]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Terminal
extends
    Parseable[Terminal]
{
    val sup = ACDCTerminal.parse _
    val phases = parse_attribute (attribute ("""Terminal.phases"""))_
    val Bushing = parse_attribute (attribute ("""Terminal.Bushing"""))_
    val ConductingEquipment = parse_attribute (attribute ("""Terminal.ConductingEquipment"""))_
    val ConnectivityNode = parse_attribute (attribute ("""Terminal.ConnectivityNode"""))_
    val SvPowerFlow = parse_attribute (attribute ("""Terminal.SvPowerFlow"""))_
    val TopologicalNode = parse_attribute (attribute ("""Terminal.TopologicalNode"""))_
    def parse (context: Context): Terminal =
    {
        Terminal(
            sup (context),
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
 * The equipment typically consist of breakers, busbars, instrumentation, control, regulation and protection devices as well as assemblies of all these.
 */
case class VoltageLevel
(

    override val sup: EquipmentContainer,

    /**
     * The bus bar's high voltage limit
     */
    val highVoltageLimit: Double,

    /**
     * The bus bar's low voltage limit
     */
    val lowVoltageLimit: Double,

    /**
     * The base voltage used for all equipment within the voltage level.
     */
    val BaseVoltage: String,

    /**
     * The substation of the voltage level.
     */
    val Substation: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null, null) }
    def EquipmentContainer: EquipmentContainer = sup.asInstanceOf[EquipmentContainer]
    override def copy (): Row = { return (clone ().asInstanceOf[VoltageLevel]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object VoltageLevel
extends
    Parseable[VoltageLevel]
{
    val sup = EquipmentContainer.parse _
    val highVoltageLimit = parse_element (element ("""VoltageLevel.highVoltageLimit"""))_
    val lowVoltageLimit = parse_element (element ("""VoltageLevel.lowVoltageLimit"""))_
    val BaseVoltage = parse_attribute (attribute ("""VoltageLevel.BaseVoltage"""))_
    val Substation = parse_attribute (attribute ("""VoltageLevel.Substation"""))_
    def parse (context: Context): VoltageLevel =
    {
        VoltageLevel(
            sup (context),
            toDouble (highVoltageLimit (context), context),
            toDouble (lowVoltageLimit (context), context),
            BaseVoltage (context),
            Substation (context)
        )
    }
}

object _Core
{
    def register: Unit =
    {
        ACDCTerminal.register
        BaseFrequency.register
        BasePower.register
        BaseVoltage.register
        BasicIntervalSchedule.register
        Bay.register
        BreakerConfiguration.register
        BusbarConfiguration.register
        ConductingEquipment.register
        ConnectivityNode.register
        ConnectivityNodeContainer.register
        Curve.register
        CurveData.register
        CurveStyle.register
        Equipment.register
        EquipmentContainer.register
        GeographicalRegion.register
        IdentifiedObject.register
        IrregularIntervalSchedule.register
        IrregularTimePoint.register
        Name.register
        NameType.register
        NameTypeAuthority.register
        OperatingParticipant.register
        OperatingShare.register
        PSRType.register
        PhaseCode.register
        PowerSystemResource.register
        RegularIntervalSchedule.register
        RegularTimePoint.register
        ReportingGroup.register
        ReportingSuperGroup.register
        SubGeographicalRegion.register
        Substation.register
        Terminal.register
        VoltageLevel.register
    }
}