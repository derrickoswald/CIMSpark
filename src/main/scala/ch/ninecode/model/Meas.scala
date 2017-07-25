package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/*
 * Package: Meas
 */

case class Accumulator
(
    override val sup: Measurement,
    val maxValue: Int
)
extends
    Element
{
    def this () = { this (null, 0) }
    def Measurement: Measurement = sup.asInstanceOf[Measurement]
    override def copy (): Row = { return (clone ().asInstanceOf[Accumulator]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Accumulator
extends
    Parseable[Accumulator]
{
    val maxValue = parse_element (element ("""Accumulator.maxValue"""))
    def parse (context: Context): Accumulator =
    {
        return (
            Accumulator
            (
                Measurement.parse (context),
                toInteger (maxValue (context), context)
            )
        )
    }
}

case class AccumulatorLimit
(
    override val sup: Limit,
    val value: Int,
    val LimitSet: String
)
extends
    Element
{
    def this () = { this (null, 0, null) }
    def Limit: Limit = sup.asInstanceOf[Limit]
    override def copy (): Row = { return (clone ().asInstanceOf[AccumulatorLimit]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AccumulatorLimit
extends
    Parseable[AccumulatorLimit]
{
    val value = parse_element (element ("""AccumulatorLimit.value"""))
    val LimitSet = parse_attribute (attribute ("""AccumulatorLimit.LimitSet"""))
    def parse (context: Context): AccumulatorLimit =
    {
        return (
            AccumulatorLimit
            (
                Limit.parse (context),
                toInteger (value (context), context),
                LimitSet (context)
            )
        )
    }
}

case class AccumulatorLimitSet
(
    override val sup: LimitSet
)
extends
    Element
{
    def this () = { this (null) }
    def LimitSet: LimitSet = sup.asInstanceOf[LimitSet]
    override def copy (): Row = { return (clone ().asInstanceOf[AccumulatorLimitSet]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AccumulatorLimitSet
extends
    Parseable[AccumulatorLimitSet]
{
    def parse (context: Context): AccumulatorLimitSet =
    {
        return (
            AccumulatorLimitSet
            (
                LimitSet.parse (context)
            )
        )
    }
}

case class AccumulatorReset
(
    override val sup: Control,
    val AccumulatorValue: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Control: Control = sup.asInstanceOf[Control]
    override def copy (): Row = { return (clone ().asInstanceOf[AccumulatorReset]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AccumulatorReset
extends
    Parseable[AccumulatorReset]
{
    val AccumulatorValue = parse_attribute (attribute ("""AccumulatorReset.AccumulatorValue"""))
    def parse (context: Context): AccumulatorReset =
    {
        return (
            AccumulatorReset
            (
                Control.parse (context),
                AccumulatorValue (context)
            )
        )
    }
}

case class AccumulatorValue
(
    override val sup: MeasurementValue,
    val value: Int,
    val Accumulator: String,
    val AccumulatorReset: String
)
extends
    Element
{
    def this () = { this (null, 0, null, null) }
    def MeasurementValue: MeasurementValue = sup.asInstanceOf[MeasurementValue]
    override def copy (): Row = { return (clone ().asInstanceOf[AccumulatorValue]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AccumulatorValue
extends
    Parseable[AccumulatorValue]
{
    val value = parse_element (element ("""AccumulatorValue.value"""))
    val Accumulator = parse_attribute (attribute ("""AccumulatorValue.Accumulator"""))
    val AccumulatorReset = parse_attribute (attribute ("""AccumulatorValue.AccumulatorReset"""))
    def parse (context: Context): AccumulatorValue =
    {
        return (
            AccumulatorValue
            (
                MeasurementValue.parse (context),
                toInteger (value (context), context),
                Accumulator (context),
                AccumulatorReset (context)
            )
        )
    }
}

case class Analog
(
    override val sup: Measurement,
    val maxValue: Double,
    val minValue: Double,
    val normalValue: Double,
    val positiveFlowIn: Boolean
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, false) }
    def Measurement: Measurement = sup.asInstanceOf[Measurement]
    override def copy (): Row = { return (clone ().asInstanceOf[Analog]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Analog
extends
    Parseable[Analog]
{
    val maxValue = parse_element (element ("""Analog.maxValue"""))
    val minValue = parse_element (element ("""Analog.minValue"""))
    val normalValue = parse_element (element ("""Analog.normalValue"""))
    val positiveFlowIn = parse_element (element ("""Analog.positiveFlowIn"""))
    def parse (context: Context): Analog =
    {
        return (
            Analog
            (
                Measurement.parse (context),
                toDouble (maxValue (context), context),
                toDouble (minValue (context), context),
                toDouble (normalValue (context), context),
                toBoolean (positiveFlowIn (context), context)
            )
        )
    }
}

case class AnalogControl
(
    override val sup: Control,
    val maxValue: Double,
    val minValue: Double,
    val AnalogValue: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null) }
    def Control: Control = sup.asInstanceOf[Control]
    override def copy (): Row = { return (clone ().asInstanceOf[AnalogControl]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AnalogControl
extends
    Parseable[AnalogControl]
{
    val maxValue = parse_element (element ("""AnalogControl.maxValue"""))
    val minValue = parse_element (element ("""AnalogControl.minValue"""))
    val AnalogValue = parse_attribute (attribute ("""AnalogControl.AnalogValue"""))
    def parse (context: Context): AnalogControl =
    {
        return (
            AnalogControl
            (
                Control.parse (context),
                toDouble (maxValue (context), context),
                toDouble (minValue (context), context),
                AnalogValue (context)
            )
        )
    }
}

case class AnalogLimit
(
    override val sup: Limit,
    val value: Double,
    val LimitSet: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null) }
    def Limit: Limit = sup.asInstanceOf[Limit]
    override def copy (): Row = { return (clone ().asInstanceOf[AnalogLimit]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AnalogLimit
extends
    Parseable[AnalogLimit]
{
    val value = parse_element (element ("""AnalogLimit.value"""))
    val LimitSet = parse_attribute (attribute ("""AnalogLimit.LimitSet"""))
    def parse (context: Context): AnalogLimit =
    {
        return (
            AnalogLimit
            (
                Limit.parse (context),
                toDouble (value (context), context),
                LimitSet (context)
            )
        )
    }
}

case class AnalogLimitSet
(
    override val sup: LimitSet
)
extends
    Element
{
    def this () = { this (null) }
    def LimitSet: LimitSet = sup.asInstanceOf[LimitSet]
    override def copy (): Row = { return (clone ().asInstanceOf[AnalogLimitSet]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AnalogLimitSet
extends
    Parseable[AnalogLimitSet]
{
    def parse (context: Context): AnalogLimitSet =
    {
        return (
            AnalogLimitSet
            (
                LimitSet.parse (context)
            )
        )
    }
}

case class AnalogValue
(
    override val sup: MeasurementValue,
    val value: Double,
    val Analog: String,
    val AnalogControl: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null) }
    def MeasurementValue: MeasurementValue = sup.asInstanceOf[MeasurementValue]
    override def copy (): Row = { return (clone ().asInstanceOf[AnalogValue]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AnalogValue
extends
    Parseable[AnalogValue]
{
    val value = parse_element (element ("""AnalogValue.value"""))
    val Analog = parse_attribute (attribute ("""AnalogValue.Analog"""))
    val AnalogControl = parse_attribute (attribute ("""AnalogValue.AnalogControl"""))
    def parse (context: Context): AnalogValue =
    {
        return (
            AnalogValue
            (
                MeasurementValue.parse (context),
                toDouble (value (context), context),
                Analog (context),
                AnalogControl (context)
            )
        )
    }
}

case class Command
(
    override val sup: Control,
    val normalValue: Int,
    val value: Int,
    val DiscreteValue: String,
    val ValueAliasSet: String
)
extends
    Element
{
    def this () = { this (null, 0, 0, null, null) }
    def Control: Control = sup.asInstanceOf[Control]
    override def copy (): Row = { return (clone ().asInstanceOf[Command]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Command
extends
    Parseable[Command]
{
    val normalValue = parse_element (element ("""Command.normalValue"""))
    val value = parse_element (element ("""Command.value"""))
    val DiscreteValue = parse_attribute (attribute ("""Command.DiscreteValue"""))
    val ValueAliasSet = parse_attribute (attribute ("""Command.ValueAliasSet"""))
    def parse (context: Context): Command =
    {
        return (
            Command
            (
                Control.parse (context),
                toInteger (normalValue (context), context),
                toInteger (value (context), context),
                DiscreteValue (context),
                ValueAliasSet (context)
            )
        )
    }
}

case class Control
(
    override val sup: IdentifiedObject,
    val controlType: String,
    val operationInProgress: Boolean,
    val timeStamp: String,
    val unitMultiplier: String,
    val unitSymbol: String,
    val PowerSystemResource: String,
    val RemoteControl: String
)
extends
    Element
{
    def this () = { this (null, null, false, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Control]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Control
extends
    Parseable[Control]
{
    val controlType = parse_element (element ("""Control.controlType"""))
    val operationInProgress = parse_element (element ("""Control.operationInProgress"""))
    val timeStamp = parse_element (element ("""Control.timeStamp"""))
    val unitMultiplier = parse_attribute (attribute ("""Control.unitMultiplier"""))
    val unitSymbol = parse_attribute (attribute ("""Control.unitSymbol"""))
    val PowerSystemResource = parse_attribute (attribute ("""Control.PowerSystemResource"""))
    val RemoteControl = parse_attribute (attribute ("""Control.RemoteControl"""))
    def parse (context: Context): Control =
    {
        return (
            Control
            (
                IdentifiedObject.parse (context),
                controlType (context),
                toBoolean (operationInProgress (context), context),
                timeStamp (context),
                unitMultiplier (context),
                unitSymbol (context),
                PowerSystemResource (context),
                RemoteControl (context)
            )
        )
    }
}

case class Discrete
(
    override val sup: Measurement,
    val maxValue: Int,
    val minValue: Int,
    val normalValue: Int,
    val valueAliasSet: String
)
extends
    Element
{
    def this () = { this (null, 0, 0, 0, null) }
    def Measurement: Measurement = sup.asInstanceOf[Measurement]
    override def copy (): Row = { return (clone ().asInstanceOf[Discrete]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Discrete
extends
    Parseable[Discrete]
{
    val maxValue = parse_element (element ("""Discrete.maxValue"""))
    val minValue = parse_element (element ("""Discrete.minValue"""))
    val normalValue = parse_element (element ("""Discrete.normalValue"""))
    val valueAliasSet = parse_attribute (attribute ("""Discrete.valueAliasSet"""))
    def parse (context: Context): Discrete =
    {
        return (
            Discrete
            (
                Measurement.parse (context),
                toInteger (maxValue (context), context),
                toInteger (minValue (context), context),
                toInteger (normalValue (context), context),
                valueAliasSet (context)
            )
        )
    }
}

case class DiscreteCommand
(
    override val sup: Command
)
extends
    Element
{
    def this () = { this (null) }
    def Command: Command = sup.asInstanceOf[Command]
    override def copy (): Row = { return (clone ().asInstanceOf[DiscreteCommand]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DiscreteCommand
extends
    Parseable[DiscreteCommand]
{
    def parse (context: Context): DiscreteCommand =
    {
        return (
            DiscreteCommand
            (
                Command.parse (context)
            )
        )
    }
}

case class DiscreteValue
(
    override val sup: MeasurementValue,
    val value: Int,
    val Command: String,
    val Discrete: String
)
extends
    Element
{
    def this () = { this (null, 0, null, null) }
    def MeasurementValue: MeasurementValue = sup.asInstanceOf[MeasurementValue]
    override def copy (): Row = { return (clone ().asInstanceOf[DiscreteValue]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DiscreteValue
extends
    Parseable[DiscreteValue]
{
    val value = parse_element (element ("""DiscreteValue.value"""))
    val Command = parse_attribute (attribute ("""DiscreteValue.Command"""))
    val Discrete = parse_attribute (attribute ("""DiscreteValue.Discrete"""))
    def parse (context: Context): DiscreteValue =
    {
        return (
            DiscreteValue
            (
                MeasurementValue.parse (context),
                toInteger (value (context), context),
                Command (context),
                Discrete (context)
            )
        )
    }
}

case class Limit
(
    override val sup: IdentifiedObject
)
extends
    Element
{
    def this () = { this (null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Limit]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Limit
extends
    Parseable[Limit]
{
    def parse (context: Context): Limit =
    {
        return (
            Limit
            (
                IdentifiedObject.parse (context)
            )
        )
    }
}

case class LimitSet
(
    override val sup: IdentifiedObject,
    val isPercentageLimits: Boolean
)
extends
    Element
{
    def this () = { this (null, false) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[LimitSet]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object LimitSet
extends
    Parseable[LimitSet]
{
    val isPercentageLimits = parse_element (element ("""LimitSet.isPercentageLimits"""))
    def parse (context: Context): LimitSet =
    {
        return (
            LimitSet
            (
                IdentifiedObject.parse (context),
                toBoolean (isPercentageLimits (context), context)
            )
        )
    }
}

case class Measurement
(
    override val sup: IdentifiedObject,
    val measurementType: String,
    val phases: String,
    val unitMultiplier: String,
    val unitSymbol: String,
    val Asset: String,
    val PowerSystemResource: String,
    val Terminal: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Measurement]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Measurement
extends
    Parseable[Measurement]
{
    val measurementType = parse_element (element ("""Measurement.measurementType"""))
    val phases = parse_attribute (attribute ("""Measurement.phases"""))
    val unitMultiplier = parse_attribute (attribute ("""Measurement.unitMultiplier"""))
    val unitSymbol = parse_attribute (attribute ("""Measurement.unitSymbol"""))
    val Asset = parse_attribute (attribute ("""Measurement.Asset"""))
    val PowerSystemResource = parse_attribute (attribute ("""Measurement.PowerSystemResource"""))
    val Terminal = parse_attribute (attribute ("""Measurement.Terminal"""))
    def parse (context: Context): Measurement =
    {
        return (
            Measurement
            (
                IdentifiedObject.parse (context),
                measurementType (context),
                phases (context),
                unitMultiplier (context),
                unitSymbol (context),
                Asset (context),
                PowerSystemResource (context),
                Terminal (context)
            )
        )
    }
}

case class MeasurementValue
(
    override val sup: IdentifiedObject,
    val sensorAccuracy: Double,
    val timeStamp: String,
    val ErpPerson: String,
    val measurementValueSource: String,
    val RemoteSource: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[MeasurementValue]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MeasurementValue
extends
    Parseable[MeasurementValue]
{
    val sensorAccuracy = parse_element (element ("""MeasurementValue.sensorAccuracy"""))
    val timeStamp = parse_element (element ("""MeasurementValue.timeStamp"""))
    val ErpPerson = parse_attribute (attribute ("""MeasurementValue.ErpPerson"""))
    val measurementValueSource = parse_attribute (attribute ("""MeasurementValue.measurementValueSource"""))
    val RemoteSource = parse_attribute (attribute ("""MeasurementValue.RemoteSource"""))
    def parse (context: Context): MeasurementValue =
    {
        return (
            MeasurementValue
            (
                IdentifiedObject.parse (context),
                toDouble (sensorAccuracy (context), context),
                timeStamp (context),
                ErpPerson (context),
                measurementValueSource (context),
                RemoteSource (context)
            )
        )
    }
}

case class MeasurementValueQuality
(
    override val sup: Quality61850,
    val MeasurementValue: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Quality61850: Quality61850 = sup.asInstanceOf[Quality61850]
    override def copy (): Row = { return (clone ().asInstanceOf[MeasurementValueQuality]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MeasurementValueQuality
extends
    Parseable[MeasurementValueQuality]
{
    val MeasurementValue = parse_attribute (attribute ("""MeasurementValueQuality.MeasurementValue"""))
    def parse (context: Context): MeasurementValueQuality =
    {
        return (
            MeasurementValueQuality
            (
                Quality61850.parse (context),
                MeasurementValue (context)
            )
        )
    }
}

case class MeasurementValueSource
(
    override val sup: IdentifiedObject
)
extends
    Element
{
    def this () = { this (null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[MeasurementValueSource]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MeasurementValueSource
extends
    Parseable[MeasurementValueSource]
{
    def parse (context: Context): MeasurementValueSource =
    {
        return (
            MeasurementValueSource
            (
                IdentifiedObject.parse (context)
            )
        )
    }
}

case class Quality61850
(
    override val sup: BasicElement,
    val badReference: Boolean,
    val estimatorReplaced: Boolean,
    val failure: Boolean,
    val oldData: Boolean,
    val operatorBlocked: Boolean,
    val oscillatory: Boolean,
    val outOfRange: Boolean,
    val overFlow: Boolean,
    val source: String,
    val suspect: Boolean,
    val test: Boolean,
    val validity: String
)
extends
    Element
{
    def this () = { this (null, false, false, false, false, false, false, false, false, null, false, false, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[Quality61850]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Quality61850
extends
    Parseable[Quality61850]
{
    val badReference = parse_element (element ("""Quality61850.badReference"""))
    val estimatorReplaced = parse_element (element ("""Quality61850.estimatorReplaced"""))
    val failure = parse_element (element ("""Quality61850.failure"""))
    val oldData = parse_element (element ("""Quality61850.oldData"""))
    val operatorBlocked = parse_element (element ("""Quality61850.operatorBlocked"""))
    val oscillatory = parse_element (element ("""Quality61850.oscillatory"""))
    val outOfRange = parse_element (element ("""Quality61850.outOfRange"""))
    val overFlow = parse_element (element ("""Quality61850.overFlow"""))
    val source = parse_attribute (attribute ("""Quality61850.source"""))
    val suspect = parse_element (element ("""Quality61850.suspect"""))
    val test = parse_element (element ("""Quality61850.test"""))
    val validity = parse_attribute (attribute ("""Quality61850.validity"""))
    def parse (context: Context): Quality61850 =
    {
        return (
            Quality61850
            (
                BasicElement.parse (context),
                toBoolean (badReference (context), context),
                toBoolean (estimatorReplaced (context), context),
                toBoolean (failure (context), context),
                toBoolean (oldData (context), context),
                toBoolean (operatorBlocked (context), context),
                toBoolean (oscillatory (context), context),
                toBoolean (outOfRange (context), context),
                toBoolean (overFlow (context), context),
                source (context),
                toBoolean (suspect (context), context),
                toBoolean (test (context), context),
                validity (context)
            )
        )
    }
}

case class RaiseLowerCommand
(
    override val sup: AnalogControl,
    val ValueAliasSet: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def AnalogControl: AnalogControl = sup.asInstanceOf[AnalogControl]
    override def copy (): Row = { return (clone ().asInstanceOf[RaiseLowerCommand]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RaiseLowerCommand
extends
    Parseable[RaiseLowerCommand]
{
    val ValueAliasSet = parse_attribute (attribute ("""RaiseLowerCommand.ValueAliasSet"""))
    def parse (context: Context): RaiseLowerCommand =
    {
        return (
            RaiseLowerCommand
            (
                AnalogControl.parse (context),
                ValueAliasSet (context)
            )
        )
    }
}

case class SetPoint
(
    override val sup: AnalogControl,
    val normalValue: Double,
    val value: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0) }
    def AnalogControl: AnalogControl = sup.asInstanceOf[AnalogControl]
    override def copy (): Row = { return (clone ().asInstanceOf[SetPoint]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SetPoint
extends
    Parseable[SetPoint]
{
    val normalValue = parse_element (element ("""SetPoint.normalValue"""))
    val value = parse_element (element ("""SetPoint.value"""))
    def parse (context: Context): SetPoint =
    {
        return (
            SetPoint
            (
                AnalogControl.parse (context),
                toDouble (normalValue (context), context),
                toDouble (value (context), context)
            )
        )
    }
}

case class StringMeasurement
(
    override val sup: Measurement
)
extends
    Element
{
    def this () = { this (null) }
    def Measurement: Measurement = sup.asInstanceOf[Measurement]
    override def copy (): Row = { return (clone ().asInstanceOf[StringMeasurement]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object StringMeasurement
extends
    Parseable[StringMeasurement]
{
    def parse (context: Context): StringMeasurement =
    {
        return (
            StringMeasurement
            (
                Measurement.parse (context)
            )
        )
    }
}

case class StringMeasurementValue
(
    override val sup: MeasurementValue,
    val value: String,
    val StringMeasurement: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def MeasurementValue: MeasurementValue = sup.asInstanceOf[MeasurementValue]
    override def copy (): Row = { return (clone ().asInstanceOf[StringMeasurementValue]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object StringMeasurementValue
extends
    Parseable[StringMeasurementValue]
{
    val value = parse_element (element ("""StringMeasurementValue.value"""))
    val StringMeasurement = parse_attribute (attribute ("""StringMeasurementValue.StringMeasurement"""))
    def parse (context: Context): StringMeasurementValue =
    {
        return (
            StringMeasurementValue
            (
                MeasurementValue.parse (context),
                value (context),
                StringMeasurement (context)
            )
        )
    }
}

case class ValueAliasSet
(
    override val sup: IdentifiedObject
)
extends
    Element
{
    def this () = { this (null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ValueAliasSet]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ValueAliasSet
extends
    Parseable[ValueAliasSet]
{
    def parse (context: Context): ValueAliasSet =
    {
        return (
            ValueAliasSet
            (
                IdentifiedObject.parse (context)
            )
        )
    }
}

case class ValueToAlias
(
    override val sup: IdentifiedObject,
    val value: Int,
    val ValueAliasSet: String
)
extends
    Element
{
    def this () = { this (null, 0, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ValueToAlias]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ValueToAlias
extends
    Parseable[ValueToAlias]
{
    val value = parse_element (element ("""ValueToAlias.value"""))
    val ValueAliasSet = parse_attribute (attribute ("""ValueToAlias.ValueAliasSet"""))
    def parse (context: Context): ValueToAlias =
    {
        return (
            ValueToAlias
            (
                IdentifiedObject.parse (context),
                toInteger (value (context), context),
                ValueAliasSet (context)
            )
        )
    }
}

object _Meas
{
    def register: Unit =
    {
        Accumulator.register
        AccumulatorLimit.register
        AccumulatorLimitSet.register
        AccumulatorReset.register
        AccumulatorValue.register
        Analog.register
        AnalogControl.register
        AnalogLimit.register
        AnalogLimitSet.register
        AnalogValue.register
        Command.register
        Control.register
        Discrete.register
        DiscreteCommand.register
        DiscreteValue.register
        Limit.register
        LimitSet.register
        Measurement.register
        MeasurementValue.register
        MeasurementValueQuality.register
        MeasurementValueSource.register
        Quality61850.register
        RaiseLowerCommand.register
        SetPoint.register
        StringMeasurement.register
        StringMeasurementValue.register
        ValueAliasSet.register
        ValueToAlias.register
    }
}
