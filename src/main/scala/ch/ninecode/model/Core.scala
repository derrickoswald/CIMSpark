package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/*
 * Package: Core
 */

case class ACDCTerminal
(
    override val sup: IdentifiedObject,
    val connected: Boolean,
    val sequenceNumber: Int,
    val BusNameMarker: String
)
extends
    Element
{
    def this () = { this (null, false, 0, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ACDCTerminal]); }
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
    val connected = parse_attribute (attribute ("""ACDCTerminal.connected"""))
    val sequenceNumber = parse_element (element ("""ACDCTerminal.sequenceNumber"""))
    val BusNameMarker = parse_attribute (attribute ("""ACDCTerminal.BusNameMarker"""))
    def parse (context: Context): ACDCTerminal =
    {
        return (
            ACDCTerminal
            (
                IdentifiedObject.parse (context),
                toBoolean (connected (context), context),
                toInteger (sequenceNumber (context), context),
                BusNameMarker (context)
            )
        )
    }
}

case class BaseFrequency
(
    override val sup: IdentifiedObject,
    val frequency: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[BaseFrequency]); }
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
    val frequency = parse_element (element ("""BaseFrequency.frequency"""))

    def parse (context: Context): BaseFrequency =
    {
        return (
            BaseFrequency
            (
                IdentifiedObject.parse (context),
                toDouble (frequency (context), context)
            )
        )
    }
}

case class BasePower
(
    override val sup: IdentifiedObject,
    val basePower: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[BasePower]); }
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
    val basePower = parse_element (element ("""BasePower.basePower"""))

    def parse (context: Context): BasePower =
    {
        return (
            BasePower
            (
                IdentifiedObject.parse (context),
                toDouble (basePower (context), context)
            )
        )
    }
}

case class BaseVoltage
(
    override val sup: IdentifiedObject,
    val nominalVoltage: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[BaseVoltage]); }
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
    val nominalVoltage = parse_element (element ("""BaseVoltage.nominalVoltage"""))

    def parse (context: Context): BaseVoltage =
    {
        return (
            BaseVoltage
            (
                IdentifiedObject.parse (context),
                toDouble (nominalVoltage (context), context)
            )
        )
    }
}

case class BasicIntervalSchedule
(
    override val sup: IdentifiedObject,
    val startTime: String,
    val value1Multiplier: String,
    val value1Unit: String,
    val value2Multiplier: String,
    val value2Unit: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[BasicIntervalSchedule]); }
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
    val startTime = parse_element (element ("""BasicIntervalSchedule.startTime"""))
    val value1Multiplier = parse_attribute (attribute ("""BasicIntervalSchedule.value1Multiplier"""))
    val value1Unit = parse_attribute (attribute ("""BasicIntervalSchedule.value1Unit"""))
    val value2Multiplier = parse_attribute (attribute ("""BasicIntervalSchedule.value2Multiplier"""))
    val value2Unit = parse_attribute (attribute ("""BasicIntervalSchedule.value2Unit"""))
    def parse (context: Context): BasicIntervalSchedule =
    {
        return (
            BasicIntervalSchedule
            (
                IdentifiedObject.parse (context),
                startTime (context),
                value1Multiplier (context),
                value1Unit (context),
                value2Multiplier (context),
                value2Unit (context)
            )
        )
    }
}

case class Bay
(
    override val sup: EquipmentContainer,
    val bayEnergyMeasFlag: Boolean,
    val bayPowerMeasFlag: Boolean,
    val Substation: String,
    val VoltageLevel: String
)
extends
    Element
{
    def this () = { this (null, false, false, null, null) }
    def EquipmentContainer: EquipmentContainer = sup.asInstanceOf[EquipmentContainer]
    override def copy (): Row = { return (clone ().asInstanceOf[Bay]); }
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
    val bayEnergyMeasFlag = parse_element (element ("""Bay.bayEnergyMeasFlag"""))
    val bayPowerMeasFlag = parse_element (element ("""Bay.bayPowerMeasFlag"""))
    val Substation = parse_attribute (attribute ("""Bay.Substation"""))
    val VoltageLevel = parse_attribute (attribute ("""Bay.VoltageLevel"""))
    def parse (context: Context): Bay =
    {
        return (
            Bay
            (
                EquipmentContainer.parse (context),
                toBoolean (bayEnergyMeasFlag (context), context),
                toBoolean (bayPowerMeasFlag (context), context),
                Substation (context),
                VoltageLevel (context)
            )
        )
    }
}

case class ConductingEquipment
(
    override val sup: Equipment,
    val BaseVoltage: String,
    val GroundingAction: String,
    val JumpingAction: String,
    val SvStatus: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Equipment: Equipment = sup.asInstanceOf[Equipment]
    override def copy (): Row = { return (clone ().asInstanceOf[ConductingEquipment]); }
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
    val BaseVoltage = parse_attribute (attribute ("""ConductingEquipment.BaseVoltage"""))
    val GroundingAction = parse_attribute (attribute ("""ConductingEquipment.GroundingAction"""))
    val JumpingAction = parse_attribute (attribute ("""ConductingEquipment.JumpingAction"""))
    val SvStatus = parse_attribute (attribute ("""ConductingEquipment.SvStatus"""))
    def parse (context: Context): ConductingEquipment =
    {
        return (
            ConductingEquipment
            (
                Equipment.parse (context),
                BaseVoltage (context),
                GroundingAction (context),
                JumpingAction (context),
                SvStatus (context)
            )
        )
    }
}

case class ConnectivityNode
(
    override val sup: IdentifiedObject,
    val ConnectivityNodeContainer: String,
    val TopologicalNode: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ConnectivityNode]); }
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
    val ConnectivityNodeContainer = parse_attribute (attribute ("""ConnectivityNode.ConnectivityNodeContainer"""))
    val TopologicalNode = parse_attribute (attribute ("""ConnectivityNode.TopologicalNode"""))

    def parse (context: Context): ConnectivityNode =
    {
        return (
            ConnectivityNode
            (
                IdentifiedObject.parse (context),
                ConnectivityNodeContainer (context),
                TopologicalNode (context)
            )
        )
    }
}

case class ConnectivityNodeContainer
(
    override val sup: PowerSystemResource
)
extends
    Element
{
    def this () = { this (null) }
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { return (clone ().asInstanceOf[ConnectivityNodeContainer]); }
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
    def parse (context: Context): ConnectivityNodeContainer =
    {
        return (
            ConnectivityNodeContainer
            (
                PowerSystemResource.parse (context)
            )
        )
    }
}

case class Curve
(
    override val sup: IdentifiedObject,
    val curveStyle: String,
    val xMultiplier: String,
    val xUnit: String,
    val y1Multiplier: String,
    val y1Unit: String,
    val y2Multiplier: String,
    val y2Unit: String,
    val y3Multiplier: String,
    val y3Unit: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Curve]); }
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
        return (
            Curve
            (
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
        )
    }
}

case class CurveData
(
    override val sup: BasicElement,
    val xvalue: Double,
    val y1value: Double,
    val y2value: Double,
    val y3value: Double,
    val Curve: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, null ) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[CurveData]); }
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
    val xvalue = parse_element (element ("""CurveData.xvalue"""))
    val y1value = parse_element (element ("""CurveData.y1value"""))
    val y2value = parse_element (element ("""CurveData.y2value"""))
    val y3value = parse_element (element ("""CurveData.y3value"""))
    val Curve = parse_attribute (attribute ("""CurveData.Curve"""))
    def parse (context: Context): CurveData =
    {
        return (
            CurveData
            (
                BasicElement.parse (context),
                toDouble (xvalue (context), context),
                toDouble (y1value (context), context),
                toDouble (y2value (context), context),
                toDouble (y3value (context), context),
                Curve (context)
            )
        )
    }
}

case class Equipment
(
    override val sup: PowerSystemResource,
    val aggregate: Boolean,
    val normallyInService: Boolean,
    val EquipmentContainer: String
)
extends
    Element
{
    def this () = { this (null, false, false, null) }
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { return (clone ().asInstanceOf[Equipment]); }
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
    val aggregate = parse_element (element ("""Equipment.aggregate"""))
    val normallyInService = parse_element (element ("""Equipment.normallyInService"""))
    val EquipmentContainer = parse_attribute (attribute ("""Equipment.EquipmentContainer"""))
    def parse (context: Context): Equipment =
    {
        return (
            Equipment
            (
                PowerSystemResource.parse (context),
                toBoolean (aggregate (context), context),
                toBoolean (normallyInService (context), context),
                EquipmentContainer (context)
            )
        )
    }
}

case class EquipmentContainer
(
    override val sup: ConnectivityNodeContainer
)
extends
    Element
{
    def this () = { this (null) }
    def ConnectivityNodeContainer: ConnectivityNodeContainer = sup.asInstanceOf[ConnectivityNodeContainer]
    override def copy (): Row = { return (clone ().asInstanceOf[EquipmentContainer]); }
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
    def parse (context: Context): EquipmentContainer =
    {
        return (
            EquipmentContainer
            (
                ConnectivityNodeContainer.parse (context)
            )
        )
    }
}

case class GeographicalRegion
(
    override val sup: IdentifiedObject
)
extends
    Element
{
    def this () = { this (null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[GeographicalRegion]); }
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
    def parse (context: Context): GeographicalRegion =
    {
        return (
            GeographicalRegion
            (
                IdentifiedObject.parse (context)
            )
        )
    }
}

/**
 * Top level CIM object.
 */

case class IdentifiedObject
(
    override val sup: Element,
    val aliasName: String,
    val description: String,
    val mRID: String,
    val name: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup
    override def id: String = mRID
    override def copy (): Row = { return (clone ().asInstanceOf[IdentifiedObject]); }
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
    val aliasName = parse_element (element ("""IdentifiedObject.aliasName"""))
    val description = parse_element (element ("""IdentifiedObject.description"""))
    val name = parse_element (element ("""IdentifiedObject.name"""))
    def parse (context: Context): IdentifiedObject =
    {
        val element = BasicElement.parse (context)
        return (
            IdentifiedObject (
                element,
                aliasName (context),
                description (context),
                element.mRID,
                name (context)
            )
        )
    }
}

case class IrregularIntervalSchedule
(
    override val sup: BasicIntervalSchedule
)
extends
    Element
{
    def this () = { this (null) }
    def BasicIntervalSchedule: BasicIntervalSchedule = sup.asInstanceOf[BasicIntervalSchedule]
    override def copy (): Row = { return (clone ().asInstanceOf[IrregularIntervalSchedule]); }
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
    def parse (context: Context): IrregularIntervalSchedule =
    {
        return (
            IrregularIntervalSchedule
            (
                BasicIntervalSchedule.parse (context)
            )
        )
    }
}

case class IrregularTimePoint
(
    override val sup: BasicElement,
    val time: Double,
    val value1: Double,
    val value2: Double,
    val IntervalSchedule: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, null ) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[IrregularTimePoint]); }
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
    val time = parse_element (element ("""IrregularTimePoint.time"""))
    val value1 = parse_element (element ("""IrregularTimePoint.value1"""))
    val value2 = parse_element (element ("""IrregularTimePoint.value2"""))
    val IntervalSchedule = parse_attribute (attribute ("""IrregularTimePoint.IntervalSchedule"""))
    def parse (context: Context): IrregularTimePoint =
    {
        return (
            IrregularTimePoint
            (
                BasicElement.parse (context),
                toDouble (time (context), context),
                toDouble (value1 (context), context),
                toDouble (value2 (context), context),
                IntervalSchedule (context)
            )
        )
    }
}

case class Name
(
    override val sup: IdentifiedObject,
    val name: String,
    val IdentifiedObj: String, // should be IdentifiedObject, but that leads to a conflict
    val NameType: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Name]); }
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
    def parse (context: Context): Name =
    {
        val name = parse_element (element ("""Name.name"""))
        val IdentifiedObj = parse_attribute (attribute ("""Name.IdentifiedObject"""))
        val NameType = parse_attribute (attribute ("""Name.NameType"""))
        return (
            Name
            (
                IdentifiedObject.parse (context),
                name (context),
                IdentifiedObj (context),
                NameType (context)
            )
        )
    }
}

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
    def this () = { this (null, null, null, null) }
    def Element: Element = sup
    override def copy (): Row = { return (clone ().asInstanceOf[NameType]); }
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
    val description = parse_element (element ("""NameType.description"""))
    val name = parse_element (element ("""NameType.name"""))
    val NameTypeAuthority = parse_attribute (attribute ("""NameType.NameTypeAuthority"""))
    def parse (context: Context): NameType =
    {
        return (
            NameType
            (
                BasicElement.parse (context),
                description (context),
                name (context),
                NameTypeAuthority (context)
            )
        )
    }
}

case class NameTypeAuthority
(
    override val sup: BasicElement,
    description: String,
    name: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup
    override def copy (): Row = { return (clone ().asInstanceOf[NameTypeAuthority]); }
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
    val description = parse_element (element ("""NameTypeAuthority.description"""))
    val name = parse_element (element ("""NameTypeAuthority.name"""))
    def parse (context: Context): NameTypeAuthority =
    {
        return (
            NameTypeAuthority
            (
                BasicElement.parse (context),
                description (context),
                name (context)
            )
        )
    }
}

case class OperatingParticipant
(
    override val sup: IdentifiedObject
)
extends
    Element
{
    def this () = { this (null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[OperatingParticipant]); }
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
    def parse (context: Context): OperatingParticipant =
    {
        return (
            OperatingParticipant
            (
                IdentifiedObject.parse (context)
            )
        )
    }
}

case class OperatingShare
(
    override val sup: BasicElement,
    val percentage: Double,
    val OperatingParticipant: String,
    val PowerSystemRecource: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[OperatingShare]); }
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
    def parse (context: Context): OperatingShare =
    {
        val percentage = parse_element (element ("""OperatingShare.percentage"""))
        val OperatingParticipant = parse_attribute (attribute ("""OperatingShare.OperatingParticipant"""))
        val PowerSystemRecource = parse_attribute (attribute ("""OperatingShare.PowerSystemRecource"""))
        return (
            OperatingShare
            (
                BasicElement.parse (context),
                toDouble (percentage (context), context),
                OperatingParticipant (context),
                PowerSystemRecource (context)
            )
        )
    }
}

case class PSRType
(
    override val sup: IdentifiedObject
)
extends
    Element
{
    def this () = { this (null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[PSRType]); }
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
    def parse (context: Context): PSRType =
    {
        return (
            PSRType
            (
                IdentifiedObject.parse (context)
            )
        )
    }
}

case class PowerSystemResource
(
    override val sup: IdentifiedObject,
    val AssetDatasheet: String,
    val Location: String,
    val PSRType: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[PowerSystemResource]); }
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
    val AssetDatasheet = parse_attribute (attribute ("""PowerSystemResource.AssetDatasheet"""))
    val Location = parse_attribute (attribute ("""PowerSystemResource.Location"""))
    val PSRType = parse_attribute (attribute ("""PowerSystemResource.PSRType"""))
    def parse (context: Context): PowerSystemResource =
    {
        return (
            PowerSystemResource
            (
                IdentifiedObject.parse (context),
                AssetDatasheet (context),
                Location (context),
                PSRType (context)
            )
        )
    }
}

case class RegularIntervalSchedule
(
    override val sup: BasicIntervalSchedule,
    val endTime: String,
    val timeStep: Double
)
extends
    Element
{
    def this () = { this (null, null, 0.0) }
    def BasicIntervalSchedule: BasicIntervalSchedule = sup.asInstanceOf[BasicIntervalSchedule]
    override def copy (): Row = { return (clone ().asInstanceOf[RegularIntervalSchedule]); }
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
    val endTime = parse_element (element ("""RegularIntervalSchedule.endTime"""))
    val timeStep = parse_element (element ("""RegularIntervalSchedule.timeStep"""))
    def parse (context: Context): RegularIntervalSchedule =
    {
        return (
            RegularIntervalSchedule
            (
                BasicIntervalSchedule.parse (context),
                endTime (context),
                toDouble (timeStep (context), context)
            )
        )
    }
}

case class RegularTimePoint
(
    override val sup: BasicElement,
    val sequenceNumber: Int,
    val value1: Double,
    val value2: Double,
    val IntervalSchedule: String
)
extends
    Element
{
    def this () = { this (null, 0, 0.0, 0.0, null ) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[RegularTimePoint]); }
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
    val sequenceNumber = parse_element (element ("""RegularTimePoint.sequenceNumber"""))
    val value1 = parse_element (element ("""RegularTimePoint.value1"""))
    val value2 = parse_element (element ("""RegularTimePoint.value2"""))
    val IntervalSchedule = parse_attribute (attribute ("""RegularTimePoint.IntervalSchedule"""))
    def parse (context: Context): RegularTimePoint =
    {
        return (
            RegularTimePoint
            (
                BasicElement.parse (context),
                toInteger (sequenceNumber (context), context),
                toDouble (value1 (context), context),
                toDouble (value2 (context), context),
                IntervalSchedule (context)
            )
        )
    }
}

case class ReportingGroup
(
    override val sup: IdentifiedObject
)
extends
    Element
{
    def this () = { this (null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ReportingGroup]); }
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
    def parse (context: Context): ReportingGroup =
    {
        return (
            ReportingGroup
            (
                IdentifiedObject.parse (context)
            )
        )
    }
}

case class ReportingSuperGroup
(
    override val sup: IdentifiedObject
)
extends
    Element
{
    def this () = { this (null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ReportingSuperGroup]); }
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
    def parse (context: Context): ReportingSuperGroup =
    {
        return (
            ReportingSuperGroup
            (
                IdentifiedObject.parse (context)
            )
        )
    }
}

case class SubGeographicalRegion
(
    override val sup: IdentifiedObject,
    val Region: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[SubGeographicalRegion]); }
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
    val Region = parse_attribute (attribute ("""SubGeographicalRegion.Region"""))
    def parse (context: Context): SubGeographicalRegion =
    {
        return (
            SubGeographicalRegion
            (
                IdentifiedObject.parse (context),
                Region (context)
            )
        )
    }
}

case class Substation
(
    override val sup: EquipmentContainer,
    val Region: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def EquipmentContainer: EquipmentContainer = sup.asInstanceOf[EquipmentContainer]
    override def copy (): Row = { return (clone ().asInstanceOf[Substation]); }
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
    val Region = parse_attribute (attribute ("""Substation.Region"""))
    def parse (context: Context): Substation =
    {
        return (
            Substation
            (
                EquipmentContainer.parse (context),
                Region (context)
            )
        )
    }
}

case class Terminal
(
    override val sup: ACDCTerminal,
    val phases: String,
    val Bushing: String,
    val ConductingEquipment: String,
    val ConnectivityNode: String,
    val SvPowerFlow: String,
    val TopologicalNode: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null) }
    def ACDCTerminal: ACDCTerminal = sup.asInstanceOf[ACDCTerminal]
    override def copy (): Row = { return (clone ().asInstanceOf[Terminal]); }
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
    val phases = parse_attribute (attribute ("""Terminal.phases"""))
    val Bushing = parse_attribute (attribute ("""Terminal.Bushing"""))
    val ConductingEquipment = parse_attribute (attribute ("""Terminal.ConductingEquipment"""))
    val ConnectivityNode = parse_attribute (attribute ("""Terminal.ConnectivityNode"""))
    val SvPowerFlow = parse_attribute (attribute ("""Terminal.SvPowerFlow"""))
    val TopologicalNode = parse_attribute (attribute ("""Terminal.TopologicalNode"""))
    def parse (context: Context): Terminal =
    {
        return (
            Terminal
            (
                ACDCTerminal.parse (context),
                phases (context),
                Bushing (context),
                ConductingEquipment (context),
                ConnectivityNode (context),
                SvPowerFlow (context),
                TopologicalNode (context)
            )
        )
    }
}

case class VoltageLevel
(
    override val sup: EquipmentContainer,
    val highVoltageLimit: Double,
    val lowVoltageLimit: Double,
    val BaseVoltage: String,
    val Substation: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null, null) }
    def EquipmentContainer: EquipmentContainer = sup.asInstanceOf[EquipmentContainer]
    override def copy (): Row = { return (clone ().asInstanceOf[VoltageLevel]); }
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
    val highVoltageLimit = parse_element (element ("""VoltageLevel.highVoltageLimit"""))
    val lowVoltageLimit = parse_element (element ("""VoltageLevel.lowVoltageLimit"""))
    val BaseVoltage = parse_attribute (attribute ("""VoltageLevel.BaseVoltage"""))
    val Substation = parse_attribute (attribute ("""VoltageLevel.Substation"""))
    def parse (context: Context): VoltageLevel =
    {
        return (
            VoltageLevel
            (
                EquipmentContainer.parse (context),
                toDouble (highVoltageLimit (context), context),
                toDouble (lowVoltageLimit (context), context),
                BaseVoltage (context),
                Substation (context)
            )
        )
    }
}

object Core
{
    def register: Unit =
    {
        ACDCTerminal.register
        BaseFrequency.register
        BasePower.register
        BaseVoltage.register
        BasicIntervalSchedule.register
        Bay.register
        ConductingEquipment.register
        ConnectivityNode.register
        ConnectivityNodeContainer.register
        Curve.register
        CurveData.register
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
