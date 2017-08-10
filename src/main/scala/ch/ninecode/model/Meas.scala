package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * Contains entities that describe dynamic measurement data exchanged between applications.
 */

/**
 * Accumulator represents an accumulated (counted) Measurement, e.g. an energy value.
 * @param sup Reference to the superclass object.
 * @param maxValue Normal value range maximum for any of the MeasurementValue.values.
 *        Used for scaling, e.g. in bar graphs or of telemetered raw values.
 * @param LimitSets A measurement may have zero or more limit ranges defined for it.
 */
case class Accumulator
(
    override val sup: Measurement,
    maxValue: Int,
    LimitSets: List[String]
)
extends
    Element
{
    def this () = { this (null, 0, List()) }
    def Measurement: Measurement = sup.asInstanceOf[Measurement]
    override def copy (): Row = { clone ().asInstanceOf[Accumulator] }
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
        "\t\t<cim:Accumulator.maxValue>" + maxValue + "</cim:Accumulator.maxValue>\n" +
        (if (null != LimitSets) LimitSets.map (x => "\t\t<cim:Accumulator.LimitSets rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:Accumulator rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Accumulator>\n"
    }
}

object Accumulator
extends
    Parseable[Accumulator]
{
    val maxValue: (Context) => String = parse_element (element ("""Accumulator.maxValue"""))
    val LimitSets: (Context) => List[String] = parse_attributes (attribute ("""Accumulator.LimitSets"""))
    def parse (context: Context): Accumulator =
    {
        Accumulator(
            Measurement.parse (context),
            toInteger (maxValue (context), context),
            LimitSets (context)
        )
    }
}

/**
 * Limit values for Accumulator measurements.
 * @param sup Reference to the superclass object.
 * @param value The value to supervise against.
 *        The value is positive.
 * @param LimitSet The set of limits.
 */
case class AccumulatorLimit
(
    override val sup: Limit,
    value: Int,
    LimitSet: String
)
extends
    Element
{
    def this () = { this (null, 0, null) }
    def Limit: Limit = sup.asInstanceOf[Limit]
    override def copy (): Row = { clone ().asInstanceOf[AccumulatorLimit] }
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
        "\t\t<cim:AccumulatorLimit.value>" + value + "</cim:AccumulatorLimit.value>\n" +
        (if (null != LimitSet) "\t\t<cim:AccumulatorLimit.LimitSet rdf:resource=\"#" + LimitSet + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AccumulatorLimit rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AccumulatorLimit>\n"
    }
}

object AccumulatorLimit
extends
    Parseable[AccumulatorLimit]
{
    val value: (Context) => String = parse_element (element ("""AccumulatorLimit.value"""))
    val LimitSet: (Context) => String = parse_attribute (attribute ("""AccumulatorLimit.LimitSet"""))
    def parse (context: Context): AccumulatorLimit =
    {
        AccumulatorLimit(
            Limit.parse (context),
            toInteger (value (context), context),
            LimitSet (context)
        )
    }
}

/**
 * An AccumulatorLimitSet specifies a set of Limits that are associated with an Accumulator measurement.
 * @param sup Reference to the superclass object.
 */
case class AccumulatorLimitSet
(
    override val sup: LimitSet
)
extends
    Element
{
    def this () = { this (null) }
    def LimitSet: LimitSet = sup.asInstanceOf[LimitSet]
    override def copy (): Row = { clone ().asInstanceOf[AccumulatorLimitSet] }
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
        "\t<cim:AccumulatorLimitSet rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AccumulatorLimitSet>\n"
    }
}

object AccumulatorLimitSet
extends
    Parseable[AccumulatorLimitSet]
{
    def parse (context: Context): AccumulatorLimitSet =
    {
        AccumulatorLimitSet(
            LimitSet.parse (context)
        )
    }
}

/**
 * This command reset the counter value to zero.
 * @param sup Reference to the superclass object.
 * @param AccumulatorValue The accumulator value that is reset by the command.
 */
case class AccumulatorReset
(
    override val sup: Control,
    AccumulatorValue: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Control: Control = sup.asInstanceOf[Control]
    override def copy (): Row = { clone ().asInstanceOf[AccumulatorReset] }
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
        (if (null != AccumulatorValue) "\t\t<cim:AccumulatorReset.AccumulatorValue rdf:resource=\"#" + AccumulatorValue + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AccumulatorReset rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AccumulatorReset>\n"
    }
}

object AccumulatorReset
extends
    Parseable[AccumulatorReset]
{
    val AccumulatorValue: (Context) => String = parse_attribute (attribute ("""AccumulatorReset.AccumulatorValue"""))
    def parse (context: Context): AccumulatorReset =
    {
        AccumulatorReset(
            Control.parse (context),
            AccumulatorValue (context)
        )
    }
}

/**
 * AccumulatorValue represents an accumulated (counted) MeasurementValue.
 * @param sup Reference to the superclass object.
 * @param value The value to supervise.
 *        The value is positive.
 * @param Accumulator Measurement to which this value is connected.
 * @param AccumulatorReset The command that reset the accumulator value.
 */
case class AccumulatorValue
(
    override val sup: MeasurementValue,
    value: Int,
    Accumulator: String,
    AccumulatorReset: String
)
extends
    Element
{
    def this () = { this (null, 0, null, null) }
    def MeasurementValue: MeasurementValue = sup.asInstanceOf[MeasurementValue]
    override def copy (): Row = { clone ().asInstanceOf[AccumulatorValue] }
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
        "\t\t<cim:AccumulatorValue.value>" + value + "</cim:AccumulatorValue.value>\n" +
        (if (null != Accumulator) "\t\t<cim:AccumulatorValue.Accumulator rdf:resource=\"#" + Accumulator + "\"/>\n" else "") +
        (if (null != AccumulatorReset) "\t\t<cim:AccumulatorValue.AccumulatorReset rdf:resource=\"#" + AccumulatorReset + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AccumulatorValue rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AccumulatorValue>\n"
    }
}

object AccumulatorValue
extends
    Parseable[AccumulatorValue]
{
    val value: (Context) => String = parse_element (element ("""AccumulatorValue.value"""))
    val Accumulator: (Context) => String = parse_attribute (attribute ("""AccumulatorValue.Accumulator"""))
    val AccumulatorReset: (Context) => String = parse_attribute (attribute ("""AccumulatorValue.AccumulatorReset"""))
    def parse (context: Context): AccumulatorValue =
    {
        AccumulatorValue(
            MeasurementValue.parse (context),
            toInteger (value (context), context),
            Accumulator (context),
            AccumulatorReset (context)
        )
    }
}

/**
 * Analog represents an analog Measurement.
 * @param sup Reference to the superclass object.
 * @param maxValue Normal value range maximum for any of the MeasurementValue.values.
 *        Used for scaling, e.g. in bar graphs or of telemetered raw values.
 * @param minValue Normal value range minimum for any of the MeasurementValue.values.
 *        Used for scaling, e.g. in bar graphs or of telemetered raw values.
 * @param normalValue Normal measurement value, e.g., used for percentage calculations.
 * @param positiveFlowIn If true then this measurement is an active power, reactive power or current with the convention that a positive value measured at the Terminal means power is flowing into the related PowerSystemResource.
 * @param LimitSets A measurement may have zero or more limit ranges defined for it.
 */
case class Analog
(
    override val sup: Measurement,
    maxValue: Double,
    minValue: Double,
    normalValue: Double,
    positiveFlowIn: Boolean,
    LimitSets: List[String]
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, false, List()) }
    def Measurement: Measurement = sup.asInstanceOf[Measurement]
    override def copy (): Row = { clone ().asInstanceOf[Analog] }
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
        "\t\t<cim:Analog.maxValue>" + maxValue + "</cim:Analog.maxValue>\n" +
        "\t\t<cim:Analog.minValue>" + minValue + "</cim:Analog.minValue>\n" +
        "\t\t<cim:Analog.normalValue>" + normalValue + "</cim:Analog.normalValue>\n" +
        "\t\t<cim:Analog.positiveFlowIn>" + positiveFlowIn + "</cim:Analog.positiveFlowIn>\n" +
        (if (null != LimitSets) LimitSets.map (x => "\t\t<cim:Analog.LimitSets rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:Analog rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Analog>\n"
    }
}

object Analog
extends
    Parseable[Analog]
{
    val maxValue: (Context) => String = parse_element (element ("""Analog.maxValue"""))
    val minValue: (Context) => String = parse_element (element ("""Analog.minValue"""))
    val normalValue: (Context) => String = parse_element (element ("""Analog.normalValue"""))
    val positiveFlowIn: (Context) => String = parse_element (element ("""Analog.positiveFlowIn"""))
    val LimitSets: (Context) => List[String] = parse_attributes (attribute ("""Analog.LimitSets"""))
    def parse (context: Context): Analog =
    {
        Analog(
            Measurement.parse (context),
            toDouble (maxValue (context), context),
            toDouble (minValue (context), context),
            toDouble (normalValue (context), context),
            toBoolean (positiveFlowIn (context), context),
            LimitSets (context)
        )
    }
}

/**
 * An analog control used for supervisory control.
 * @param sup Reference to the superclass object.
 * @param maxValue Normal value range maximum for any of the Control.value.
 *        Used for scaling, e.g. in bar graphs.
 * @param minValue Normal value range minimum for any of the Control.value.
 *        Used for scaling, e.g. in bar graphs.
 * @param AnalogValue The MeasurementValue that is controlled.
 */
case class AnalogControl
(
    override val sup: Control,
    maxValue: Double,
    minValue: Double,
    AnalogValue: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null) }
    def Control: Control = sup.asInstanceOf[Control]
    override def copy (): Row = { clone ().asInstanceOf[AnalogControl] }
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
        "\t\t<cim:AnalogControl.maxValue>" + maxValue + "</cim:AnalogControl.maxValue>\n" +
        "\t\t<cim:AnalogControl.minValue>" + minValue + "</cim:AnalogControl.minValue>\n" +
        (if (null != AnalogValue) "\t\t<cim:AnalogControl.AnalogValue rdf:resource=\"#" + AnalogValue + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AnalogControl rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AnalogControl>\n"
    }
}

object AnalogControl
extends
    Parseable[AnalogControl]
{
    val maxValue: (Context) => String = parse_element (element ("""AnalogControl.maxValue"""))
    val minValue: (Context) => String = parse_element (element ("""AnalogControl.minValue"""))
    val AnalogValue: (Context) => String = parse_attribute (attribute ("""AnalogControl.AnalogValue"""))
    def parse (context: Context): AnalogControl =
    {
        AnalogControl(
            Control.parse (context),
            toDouble (maxValue (context), context),
            toDouble (minValue (context), context),
            AnalogValue (context)
        )
    }
}

/**
 * Limit values for Analog measurements.
 * @param sup Reference to the superclass object.
 * @param value The value to supervise against.
 * @param LimitSet The set of limits.
 */
case class AnalogLimit
(
    override val sup: Limit,
    value: Double,
    LimitSet: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null) }
    def Limit: Limit = sup.asInstanceOf[Limit]
    override def copy (): Row = { clone ().asInstanceOf[AnalogLimit] }
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
        "\t\t<cim:AnalogLimit.value>" + value + "</cim:AnalogLimit.value>\n" +
        (if (null != LimitSet) "\t\t<cim:AnalogLimit.LimitSet rdf:resource=\"#" + LimitSet + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AnalogLimit rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AnalogLimit>\n"
    }
}

object AnalogLimit
extends
    Parseable[AnalogLimit]
{
    val value: (Context) => String = parse_element (element ("""AnalogLimit.value"""))
    val LimitSet: (Context) => String = parse_attribute (attribute ("""AnalogLimit.LimitSet"""))
    def parse (context: Context): AnalogLimit =
    {
        AnalogLimit(
            Limit.parse (context),
            toDouble (value (context), context),
            LimitSet (context)
        )
    }
}

/**
 * An AnalogLimitSet specifies a set of Limits that are associated with an Analog measurement.
 * @param sup Reference to the superclass object.
 */
case class AnalogLimitSet
(
    override val sup: LimitSet
)
extends
    Element
{
    def this () = { this (null) }
    def LimitSet: LimitSet = sup.asInstanceOf[LimitSet]
    override def copy (): Row = { clone ().asInstanceOf[AnalogLimitSet] }
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
        "\t<cim:AnalogLimitSet rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AnalogLimitSet>\n"
    }
}

object AnalogLimitSet
extends
    Parseable[AnalogLimitSet]
{
    def parse (context: Context): AnalogLimitSet =
    {
        AnalogLimitSet(
            LimitSet.parse (context)
        )
    }
}

/**
 * AnalogValue represents an analog MeasurementValue.
 * @param sup Reference to the superclass object.
 * @param value The value to supervise.
 * @param Analog Measurement to which this value is connected.
 * @param AnalogControl The Control variable associated with the MeasurementValue.
 */
case class AnalogValue
(
    override val sup: MeasurementValue,
    value: Double,
    Analog: String,
    AnalogControl: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null) }
    def MeasurementValue: MeasurementValue = sup.asInstanceOf[MeasurementValue]
    override def copy (): Row = { clone ().asInstanceOf[AnalogValue] }
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
        "\t\t<cim:AnalogValue.value>" + value + "</cim:AnalogValue.value>\n" +
        (if (null != Analog) "\t\t<cim:AnalogValue.Analog rdf:resource=\"#" + Analog + "\"/>\n" else "") +
        (if (null != AnalogControl) "\t\t<cim:AnalogValue.AnalogControl rdf:resource=\"#" + AnalogControl + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AnalogValue rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AnalogValue>\n"
    }
}

object AnalogValue
extends
    Parseable[AnalogValue]
{
    val value: (Context) => String = parse_element (element ("""AnalogValue.value"""))
    val Analog: (Context) => String = parse_attribute (attribute ("""AnalogValue.Analog"""))
    val AnalogControl: (Context) => String = parse_attribute (attribute ("""AnalogValue.AnalogControl"""))
    def parse (context: Context): AnalogValue =
    {
        AnalogValue(
            MeasurementValue.parse (context),
            toDouble (value (context), context),
            Analog (context),
            AnalogControl (context)
        )
    }
}

/**
 * A Command is a discrete control used for supervisory control.
 * @param sup Reference to the superclass object.
 * @param normalValue Normal value for Control.value e.g. used for percentage scaling.
 * @param value The value representing the actuator output.
 * @param DiscreteValue The MeasurementValue that is controlled.
 * @param ValueAliasSet The ValueAliasSet used for translation of a Control value to a name.
 */
case class Command
(
    override val sup: Control,
    normalValue: Int,
    value: Int,
    DiscreteValue: String,
    ValueAliasSet: String
)
extends
    Element
{
    def this () = { this (null, 0, 0, null, null) }
    def Control: Control = sup.asInstanceOf[Control]
    override def copy (): Row = { clone ().asInstanceOf[Command] }
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
        "\t\t<cim:Command.normalValue>" + normalValue + "</cim:Command.normalValue>\n" +
        "\t\t<cim:Command.value>" + value + "</cim:Command.value>\n" +
        (if (null != DiscreteValue) "\t\t<cim:Command.DiscreteValue rdf:resource=\"#" + DiscreteValue + "\"/>\n" else "") +
        (if (null != ValueAliasSet) "\t\t<cim:Command.ValueAliasSet rdf:resource=\"#" + ValueAliasSet + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Command rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Command>\n"
    }
}

object Command
extends
    Parseable[Command]
{
    val normalValue: (Context) => String = parse_element (element ("""Command.normalValue"""))
    val value: (Context) => String = parse_element (element ("""Command.value"""))
    val DiscreteValue: (Context) => String = parse_attribute (attribute ("""Command.DiscreteValue"""))
    val ValueAliasSet: (Context) => String = parse_attribute (attribute ("""Command.ValueAliasSet"""))
    def parse (context: Context): Command =
    {
        Command(
            Control.parse (context),
            toInteger (normalValue (context), context),
            toInteger (value (context), context),
            DiscreteValue (context),
            ValueAliasSet (context)
        )
    }
}

/**
 * Control is used for supervisory/device control.
 * It represents control outputs that are used to change the state in a process, e.g. close or open breaker, a set point value or a raise lower command.
 * @param sup Reference to the superclass object.
 * @param controlType Specifies the type of Control, e.g.
 *        BreakerOn/Off, GeneratorVoltageSetPoint, TieLineFlow etc. The ControlType.name shall be unique among all specified types and describe the type.
 * @param operationInProgress Indicates that a client is currently sending control commands that has not completed.
 * @param timeStamp The last time a control output was sent.
 * @param unitMultiplier The unit multiplier of the controlled quantity.
 * @param unitSymbol The unit of measure of the controlled quantity.
 * @param PowerSystemResource Regulating device governed by this control output.
 * @param RemoteControl The remote point controlling the physical actuator.
 */
case class Control
(
    override val sup: IdentifiedObject,
    controlType: String,
    operationInProgress: Boolean,
    timeStamp: String,
    unitMultiplier: String,
    unitSymbol: String,
    PowerSystemResource: String,
    RemoteControl: String
)
extends
    Element
{
    def this () = { this (null, null, false, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Control] }
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
        (if (null != controlType) "\t\t<cim:Control.controlType>" + controlType + "</cim:Control.controlType>\n" else "") +
        "\t\t<cim:Control.operationInProgress>" + operationInProgress + "</cim:Control.operationInProgress>\n" +
        (if (null != timeStamp) "\t\t<cim:Control.timeStamp>" + timeStamp + "</cim:Control.timeStamp>\n" else "") +
        (if (null != unitMultiplier) "\t\t<cim:Control.unitMultiplier rdf:resource=\"#" + unitMultiplier + "\"/>\n" else "") +
        (if (null != unitSymbol) "\t\t<cim:Control.unitSymbol rdf:resource=\"#" + unitSymbol + "\"/>\n" else "") +
        (if (null != PowerSystemResource) "\t\t<cim:Control.PowerSystemResource rdf:resource=\"#" + PowerSystemResource + "\"/>\n" else "") +
        (if (null != RemoteControl) "\t\t<cim:Control.RemoteControl rdf:resource=\"#" + RemoteControl + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Control rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Control>\n"
    }
}

object Control
extends
    Parseable[Control]
{
    val controlType: (Context) => String = parse_element (element ("""Control.controlType"""))
    val operationInProgress: (Context) => String = parse_element (element ("""Control.operationInProgress"""))
    val timeStamp: (Context) => String = parse_element (element ("""Control.timeStamp"""))
    val unitMultiplier: (Context) => String = parse_attribute (attribute ("""Control.unitMultiplier"""))
    val unitSymbol: (Context) => String = parse_attribute (attribute ("""Control.unitSymbol"""))
    val PowerSystemResource: (Context) => String = parse_attribute (attribute ("""Control.PowerSystemResource"""))
    val RemoteControl: (Context) => String = parse_attribute (attribute ("""Control.RemoteControl"""))
    def parse (context: Context): Control =
    {
        Control(
            IdentifiedObject.parse (context),
            controlType (context),
            toBoolean (operationInProgress (context), context),
            timeStamp (context),
            unitMultiplier (context),
            unitSymbol (context),
            PowerSystemResource (context),
            RemoteControl (context)
        )
    }
}

/**
 * Discrete represents a discrete Measurement, i.e. a Measurement representing discrete values, e.g. a Breaker position.
 * @param sup Reference to the superclass object.
 * @param maxValue Normal value range maximum for any of the MeasurementValue.values.
 *        Used for scaling, e.g. in bar graphs or of telemetered raw values.
 * @param minValue Normal value range minimum for any of the MeasurementValue.values.
 *        Used for scaling, e.g. in bar graphs or of telemetered raw values.
 * @param normalValue Normal measurement value, e.g., used for percentage calculations.
 * @param ValueAliasSet The ValueAliasSet used for translation of a MeasurementValue.value to a name.
 */
case class Discrete
(
    override val sup: Measurement,
    maxValue: Int,
    minValue: Int,
    normalValue: Int,
    ValueAliasSet: String
)
extends
    Element
{
    def this () = { this (null, 0, 0, 0, null) }
    def Measurement: Measurement = sup.asInstanceOf[Measurement]
    override def copy (): Row = { clone ().asInstanceOf[Discrete] }
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
        "\t\t<cim:Discrete.maxValue>" + maxValue + "</cim:Discrete.maxValue>\n" +
        "\t\t<cim:Discrete.minValue>" + minValue + "</cim:Discrete.minValue>\n" +
        "\t\t<cim:Discrete.normalValue>" + normalValue + "</cim:Discrete.normalValue>\n" +
        (if (null != ValueAliasSet) "\t\t<cim:Discrete.ValueAliasSet rdf:resource=\"#" + ValueAliasSet + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Discrete rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Discrete>\n"
    }
}

object Discrete
extends
    Parseable[Discrete]
{
    val maxValue: (Context) => String = parse_element (element ("""Discrete.maxValue"""))
    val minValue: (Context) => String = parse_element (element ("""Discrete.minValue"""))
    val normalValue: (Context) => String = parse_element (element ("""Discrete.normalValue"""))
    val ValueAliasSet: (Context) => String = parse_attribute (attribute ("""Discrete.ValueAliasSet"""))
    def parse (context: Context): Discrete =
    {
        Discrete(
            Measurement.parse (context),
            toInteger (maxValue (context), context),
            toInteger (minValue (context), context),
            toInteger (normalValue (context), context),
            ValueAliasSet (context)
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
    override def copy (): Row = { clone ().asInstanceOf[DiscreteCommand] }
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
        "\t<cim:DiscreteCommand rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DiscreteCommand>\n"
    }
}

object DiscreteCommand
extends
    Parseable[DiscreteCommand]
{
    def parse (context: Context): DiscreteCommand =
    {
        DiscreteCommand(
            Command.parse (context)
        )
    }
}

/**
 * DiscreteValue represents a discrete MeasurementValue.
 * @param sup Reference to the superclass object.
 * @param value The value to supervise.
 * @param Command The Control variable associated with the MeasurementValue.
 * @param Discrete Measurement to which this value is connected.
 */
case class DiscreteValue
(
    override val sup: MeasurementValue,
    value: Int,
    Command: String,
    Discrete: String
)
extends
    Element
{
    def this () = { this (null, 0, null, null) }
    def MeasurementValue: MeasurementValue = sup.asInstanceOf[MeasurementValue]
    override def copy (): Row = { clone ().asInstanceOf[DiscreteValue] }
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
        "\t\t<cim:DiscreteValue.value>" + value + "</cim:DiscreteValue.value>\n" +
        (if (null != Command) "\t\t<cim:DiscreteValue.Command rdf:resource=\"#" + Command + "\"/>\n" else "") +
        (if (null != Discrete) "\t\t<cim:DiscreteValue.Discrete rdf:resource=\"#" + Discrete + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:DiscreteValue rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DiscreteValue>\n"
    }
}

object DiscreteValue
extends
    Parseable[DiscreteValue]
{
    val value: (Context) => String = parse_element (element ("""DiscreteValue.value"""))
    val Command: (Context) => String = parse_attribute (attribute ("""DiscreteValue.Command"""))
    val Discrete: (Context) => String = parse_attribute (attribute ("""DiscreteValue.Discrete"""))
    def parse (context: Context): DiscreteValue =
    {
        DiscreteValue(
            MeasurementValue.parse (context),
            toInteger (value (context), context),
            Command (context),
            Discrete (context)
        )
    }
}

/**
 * Specifies one limit value for a Measurement.
 * A Measurement typically has several limits that are kept together by the LimitSet class. The actual meaning and use of a Limit instance (i.e., if it is an alarm or warning limit or if it is a high or low limit) is not captured in the Limit class. However the name of a Limit instance may indicate both meaning and use.
 * @param sup Reference to the superclass object.
 */
case class Limit
(
    override val sup: IdentifiedObject
)
extends
    Element
{
    def this () = { this (null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Limit] }
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
        "\t<cim:Limit rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Limit>\n"
    }
}

object Limit
extends
    Parseable[Limit]
{
    def parse (context: Context): Limit =
    {
        Limit(
            IdentifiedObject.parse (context)
        )
    }
}

/**
 * Specifies a set of Limits that are associated with a Measurement.
 * A Measurement may have several LimitSets corresponding to seasonal or other changing conditions. The condition is captured in the name and description attributes. The same LimitSet may be used for several Measurements. In particular percentage limits are used this way.
 * @param sup Reference to the superclass object.
 * @param isPercentageLimits Tells if the limit values are in percentage of normalValue or the specified Unit for Measurements and Controls.
 */
case class LimitSet
(
    override val sup: IdentifiedObject,
    isPercentageLimits: Boolean
)
extends
    Element
{
    def this () = { this (null, false) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[LimitSet] }
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
        "\t\t<cim:LimitSet.isPercentageLimits>" + isPercentageLimits + "</cim:LimitSet.isPercentageLimits>\n"
    }
    override def export: String =
    {
        "\t<cim:LimitSet rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:LimitSet>\n"
    }
}

object LimitSet
extends
    Parseable[LimitSet]
{
    val isPercentageLimits: (Context) => String = parse_element (element ("""LimitSet.isPercentageLimits"""))
    def parse (context: Context): LimitSet =
    {
        LimitSet(
            IdentifiedObject.parse (context),
            toBoolean (isPercentageLimits (context), context)
        )
    }
}

/**
 * A Measurement represents any measured, calculated or non-measured non-calculated quantity.
 * Any piece of equipment may contain Measurements, e.g. a substation may have temperature measurements and door open indications, a transformer may have oil temperature and tank pressure measurements, a bay may contain a number of power flow measurements and a Breaker may contain a switch status measurement.
 * @param sup Reference to the superclass object.
 * @param measurementType Specifies the type of measurement.
 *        For example, this specifies if the measurement represents an indoor temperature, outdoor temperature, bus voltage, line flow, etc.
 * @param phases Indicates to which phases the measurement applies and avoids the need to use 'measurementType' to also encode phase information (which would explode the types).
 *        The phase information in Measurement, along with 'measurementType' and 'phases' uniquely defines a Measurement for a device, based on normal network phase. Their meaning will not change when the computed energizing phasing is changed due to jumpers or other reasons.
 * @param unitMultiplier The unit multiplier of the measured quantity.
 * @param unitSymbol The unit of measure of the measured quantity.
 * @param Asset <em>undocumented</em>
 * @param PowerSystemResource The power system resource that contains the measurement.
 * @param Terminal One or more measurements may be associated with a terminal in the network.
 */
case class Measurement
(
    override val sup: IdentifiedObject,
    measurementType: String,
    phases: String,
    unitMultiplier: String,
    unitSymbol: String,
    Asset: String,
    PowerSystemResource: String,
    Terminal: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Measurement] }
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
        (if (null != measurementType) "\t\t<cim:Measurement.measurementType>" + measurementType + "</cim:Measurement.measurementType>\n" else "") +
        (if (null != phases) "\t\t<cim:Measurement.phases rdf:resource=\"#" + phases + "\"/>\n" else "") +
        (if (null != unitMultiplier) "\t\t<cim:Measurement.unitMultiplier rdf:resource=\"#" + unitMultiplier + "\"/>\n" else "") +
        (if (null != unitSymbol) "\t\t<cim:Measurement.unitSymbol rdf:resource=\"#" + unitSymbol + "\"/>\n" else "") +
        (if (null != Asset) "\t\t<cim:Measurement.Asset rdf:resource=\"#" + Asset + "\"/>\n" else "") +
        (if (null != PowerSystemResource) "\t\t<cim:Measurement.PowerSystemResource rdf:resource=\"#" + PowerSystemResource + "\"/>\n" else "") +
        (if (null != Terminal) "\t\t<cim:Measurement.Terminal rdf:resource=\"#" + Terminal + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Measurement rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Measurement>\n"
    }
}

object Measurement
extends
    Parseable[Measurement]
{
    val measurementType: (Context) => String = parse_element (element ("""Measurement.measurementType"""))
    val phases: (Context) => String = parse_attribute (attribute ("""Measurement.phases"""))
    val unitMultiplier: (Context) => String = parse_attribute (attribute ("""Measurement.unitMultiplier"""))
    val unitSymbol: (Context) => String = parse_attribute (attribute ("""Measurement.unitSymbol"""))
    val Asset: (Context) => String = parse_attribute (attribute ("""Measurement.Asset"""))
    val PowerSystemResource: (Context) => String = parse_attribute (attribute ("""Measurement.PowerSystemResource"""))
    val Terminal: (Context) => String = parse_attribute (attribute ("""Measurement.Terminal"""))
    def parse (context: Context): Measurement =
    {
        Measurement(
            IdentifiedObject.parse (context),
            measurementType (context),
            phases (context),
            unitMultiplier (context),
            unitSymbol (context),
            Asset (context),
            PowerSystemResource (context),
            Terminal (context)
        )
    }
}

/**
 * The current state for a measurement.
 * A state value is an instance of a measurement from a specific source. Measurements can be associated with many state values, each representing a different source for the measurement.
 * @param sup Reference to the superclass object.
 * @param attr <em>undocumented</em>
 * @param sensorAccuracy The limit, expressed as a percentage of the sensor maximum, that errors will not exceed when the sensor is used under  reference conditions.
 * @param timeStamp The time when the value was last updated
 * @param ErpPerson <em>undocumented</em>
 * @param MeasurementValueQuality A MeasurementValue has a MeasurementValueQuality associated with it.
 * @param MeasurementValueSource A reference to the type of source that updates the MeasurementValue, e.g.
 *        SCADA, CCLink, manual, etc. User conventions for the names of sources are contained in the introduction to IEC 61970-301.
 * @param RemoteSource Link to the physical telemetered point associated with this measurement.
 */
case class MeasurementValue
(
    override val sup: IdentifiedObject,
    attr: String,
    sensorAccuracy: Double,
    timeStamp: String,
    ErpPerson: String,
    MeasurementValueQuality: String,
    MeasurementValueSource: String,
    RemoteSource: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[MeasurementValue] }
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
        (if (null != attr) "\t\t<cim:MeasurementValue. rdf:resource=\"#" + attr + "\"/>\n" else "") +
        "\t\t<cim:MeasurementValue.sensorAccuracy>" + sensorAccuracy + "</cim:MeasurementValue.sensorAccuracy>\n" +
        (if (null != timeStamp) "\t\t<cim:MeasurementValue.timeStamp>" + timeStamp + "</cim:MeasurementValue.timeStamp>\n" else "") +
        (if (null != ErpPerson) "\t\t<cim:MeasurementValue.ErpPerson rdf:resource=\"#" + ErpPerson + "\"/>\n" else "") +
        (if (null != MeasurementValueQuality) "\t\t<cim:MeasurementValue.MeasurementValueQuality rdf:resource=\"#" + MeasurementValueQuality + "\"/>\n" else "") +
        (if (null != MeasurementValueSource) "\t\t<cim:MeasurementValue.MeasurementValueSource rdf:resource=\"#" + MeasurementValueSource + "\"/>\n" else "") +
        (if (null != RemoteSource) "\t\t<cim:MeasurementValue.RemoteSource rdf:resource=\"#" + RemoteSource + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MeasurementValue rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MeasurementValue>\n"
    }
}

object MeasurementValue
extends
    Parseable[MeasurementValue]
{
    val attr: (Context) => String = parse_attribute (attribute ("""MeasurementValue."""))
    val sensorAccuracy: (Context) => String = parse_element (element ("""MeasurementValue.sensorAccuracy"""))
    val timeStamp: (Context) => String = parse_element (element ("""MeasurementValue.timeStamp"""))
    val ErpPerson: (Context) => String = parse_attribute (attribute ("""MeasurementValue.ErpPerson"""))
    val MeasurementValueQuality: (Context) => String = parse_attribute (attribute ("""MeasurementValue.MeasurementValueQuality"""))
    val MeasurementValueSource: (Context) => String = parse_attribute (attribute ("""MeasurementValue.MeasurementValueSource"""))
    val RemoteSource: (Context) => String = parse_attribute (attribute ("""MeasurementValue.RemoteSource"""))
    def parse (context: Context): MeasurementValue =
    {
        MeasurementValue(
            IdentifiedObject.parse (context),
            attr (context),
            toDouble (sensorAccuracy (context), context),
            timeStamp (context),
            ErpPerson (context),
            MeasurementValueQuality (context),
            MeasurementValueSource (context),
            RemoteSource (context)
        )
    }
}

/**
 * Measurement quality flags.
 * Bits 0-10 are defined for substation automation in draft IEC 61850 part 7-3. Bits 11-15 are reserved for future expansion by that document. Bits 16-31 are reserved for EMS applications.
 * @param sup Reference to the superclass object.
 * @param MeasurementValue A MeasurementValue has a MeasurementValueQuality associated with it.
 */
case class MeasurementValueQuality
(
    override val sup: Quality61850,
    MeasurementValue: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Quality61850: Quality61850 = sup.asInstanceOf[Quality61850]
    override def copy (): Row = { clone ().asInstanceOf[MeasurementValueQuality] }
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
        (if (null != MeasurementValue) "\t\t<cim:MeasurementValueQuality.MeasurementValue rdf:resource=\"#" + MeasurementValue + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MeasurementValueQuality rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MeasurementValueQuality>\n"
    }
}

object MeasurementValueQuality
extends
    Parseable[MeasurementValueQuality]
{
    val MeasurementValue: (Context) => String = parse_attribute (attribute ("""MeasurementValueQuality.MeasurementValue"""))
    def parse (context: Context): MeasurementValueQuality =
    {
        MeasurementValueQuality(
            Quality61850.parse (context),
            MeasurementValue (context)
        )
    }
}

/**
 * MeasurementValueSource describes the alternative sources updating a MeasurementValue.
 * User conventions for how to use the MeasurementValueSource attributes are described in the introduction to IEC 61970-301.
 * @param sup Reference to the superclass object.
 */
case class MeasurementValueSource
(
    override val sup: IdentifiedObject
)
extends
    Element
{
    def this () = { this (null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[MeasurementValueSource] }
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
        "\t<cim:MeasurementValueSource rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MeasurementValueSource>\n"
    }
}

object MeasurementValueSource
extends
    Parseable[MeasurementValueSource]
{
    def parse (context: Context): MeasurementValueSource =
    {
        MeasurementValueSource(
            IdentifiedObject.parse (context)
        )
    }
}

/**
 * Quality flags in this class are as defined in IEC 61850, except for estimatorReplaced, which has been included in this class for convenience.
 * @param sup Reference to the superclass object.
 * @param badReference Measurement value may be incorrect due to a reference being out of calibration.
 * @param estimatorReplaced Value has been replaced by State Estimator. estimatorReplaced is not an IEC61850 quality bit but has been put in this class for convenience.
 * @param failure This identifier indicates that a supervision function has detected an internal or external failure, e.g. communication failure.
 * @param oldData Measurement value is old and possibly invalid, as it has not been successfully updated during a specified time interval.
 * @param operatorBlocked Measurement value is blocked and hence unavailable for transmission.
 * @param oscillatory To prevent some overload of the communication it is sensible to detect and suppress oscillating (fast changing) binary inputs.
 *        If a signal changes in a defined time (tosc) twice in the same direction (from 0 to 1 or from 1 to 0) then oscillation is detected and the detail quality identifier "oscillatory" is set. If it is detected a configured numbers of transient changes could be passed by. In this time the validity status "questionable" is set. If after this defined numbers of changes the signal is still in the oscillating state the value shall be set either to the opposite state of the previous stable value or to a defined default value. In this case the validity status "questionable" is reset and "invalid" is set as long as the signal is oscillating. If it is configured such that no transient changes should be passed by then the validity status "invalid" is set immediately in addition to the detail quality identifier "oscillatory" (used for status information only).
 * @param outOfRange Measurement value is beyond a predefined range of value.
 * @param overFlow Measurement value is beyond the capability of being  represented properly.
 *        For example, a counter value overflows from maximum count back to a value of zero.
 * @param source Source gives information related to the origin of a value.
 *        The value may be acquired from the process, defaulted or substituted.
 * @param suspect A correlation function has detected that the value is not consitent with other values.
 *        Typically set by a network State Estimator.
 * @param test Measurement value is transmitted for test purposes.
 * @param validity Validity of the measurement value.
 */
case class Quality61850
(
    override val sup: BasicElement,
    badReference: Boolean,
    estimatorReplaced: Boolean,
    failure: Boolean,
    oldData: Boolean,
    operatorBlocked: Boolean,
    oscillatory: Boolean,
    outOfRange: Boolean,
    overFlow: Boolean,
    source: String,
    suspect: Boolean,
    test: Boolean,
    validity: String
)
extends
    Element
{
    def this () = { this (null, false, false, false, false, false, false, false, false, null, false, false, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[Quality61850] }
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
        "\t\t<cim:Quality61850.badReference>" + badReference + "</cim:Quality61850.badReference>\n" +
        "\t\t<cim:Quality61850.estimatorReplaced>" + estimatorReplaced + "</cim:Quality61850.estimatorReplaced>\n" +
        "\t\t<cim:Quality61850.failure>" + failure + "</cim:Quality61850.failure>\n" +
        "\t\t<cim:Quality61850.oldData>" + oldData + "</cim:Quality61850.oldData>\n" +
        "\t\t<cim:Quality61850.operatorBlocked>" + operatorBlocked + "</cim:Quality61850.operatorBlocked>\n" +
        "\t\t<cim:Quality61850.oscillatory>" + oscillatory + "</cim:Quality61850.oscillatory>\n" +
        "\t\t<cim:Quality61850.outOfRange>" + outOfRange + "</cim:Quality61850.outOfRange>\n" +
        "\t\t<cim:Quality61850.overFlow>" + overFlow + "</cim:Quality61850.overFlow>\n" +
        (if (null != source) "\t\t<cim:Quality61850.source rdf:resource=\"#" + source + "\"/>\n" else "") +
        "\t\t<cim:Quality61850.suspect>" + suspect + "</cim:Quality61850.suspect>\n" +
        "\t\t<cim:Quality61850.test>" + test + "</cim:Quality61850.test>\n" +
        (if (null != validity) "\t\t<cim:Quality61850.validity rdf:resource=\"#" + validity + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Quality61850 rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Quality61850>\n"
    }
}

object Quality61850
extends
    Parseable[Quality61850]
{
    val badReference: (Context) => String = parse_element (element ("""Quality61850.badReference"""))
    val estimatorReplaced: (Context) => String = parse_element (element ("""Quality61850.estimatorReplaced"""))
    val failure: (Context) => String = parse_element (element ("""Quality61850.failure"""))
    val oldData: (Context) => String = parse_element (element ("""Quality61850.oldData"""))
    val operatorBlocked: (Context) => String = parse_element (element ("""Quality61850.operatorBlocked"""))
    val oscillatory: (Context) => String = parse_element (element ("""Quality61850.oscillatory"""))
    val outOfRange: (Context) => String = parse_element (element ("""Quality61850.outOfRange"""))
    val overFlow: (Context) => String = parse_element (element ("""Quality61850.overFlow"""))
    val source: (Context) => String = parse_attribute (attribute ("""Quality61850.source"""))
    val suspect: (Context) => String = parse_element (element ("""Quality61850.suspect"""))
    val test: (Context) => String = parse_element (element ("""Quality61850.test"""))
    val validity: (Context) => String = parse_attribute (attribute ("""Quality61850.validity"""))
    def parse (context: Context): Quality61850 =
    {
        Quality61850(
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
    }
}

/**
 * An analog control that increase or decrease a set point value with pulses.
 * @param sup Reference to the superclass object.
 * @param ValueAliasSet The ValueAliasSet used for translation of a Control value to a name.
 */
case class RaiseLowerCommand
(
    override val sup: AnalogControl,
    ValueAliasSet: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def AnalogControl: AnalogControl = sup.asInstanceOf[AnalogControl]
    override def copy (): Row = { clone ().asInstanceOf[RaiseLowerCommand] }
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
        (if (null != ValueAliasSet) "\t\t<cim:RaiseLowerCommand.ValueAliasSet rdf:resource=\"#" + ValueAliasSet + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:RaiseLowerCommand rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RaiseLowerCommand>\n"
    }
}

object RaiseLowerCommand
extends
    Parseable[RaiseLowerCommand]
{
    val ValueAliasSet: (Context) => String = parse_attribute (attribute ("""RaiseLowerCommand.ValueAliasSet"""))
    def parse (context: Context): RaiseLowerCommand =
    {
        RaiseLowerCommand(
            AnalogControl.parse (context),
            ValueAliasSet (context)
        )
    }
}

/**
 * An analog control that issue a set point value.
 * @param sup Reference to the superclass object.
 * @param normalValue Normal value for Control.value e.g. used for percentage scaling.
 * @param value The value representing the actuator output.
 */
case class SetPoint
(
    override val sup: AnalogControl,
    normalValue: Double,
    value: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0) }
    def AnalogControl: AnalogControl = sup.asInstanceOf[AnalogControl]
    override def copy (): Row = { clone ().asInstanceOf[SetPoint] }
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
        "\t\t<cim:SetPoint.normalValue>" + normalValue + "</cim:SetPoint.normalValue>\n" +
        "\t\t<cim:SetPoint.value>" + value + "</cim:SetPoint.value>\n"
    }
    override def export: String =
    {
        "\t<cim:SetPoint rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SetPoint>\n"
    }
}

object SetPoint
extends
    Parseable[SetPoint]
{
    val normalValue: (Context) => String = parse_element (element ("""SetPoint.normalValue"""))
    val value: (Context) => String = parse_element (element ("""SetPoint.value"""))
    def parse (context: Context): SetPoint =
    {
        SetPoint(
            AnalogControl.parse (context),
            toDouble (normalValue (context), context),
            toDouble (value (context), context)
        )
    }
}

/**
 * StringMeasurement represents a measurement with values of type string.
 * @param sup Reference to the superclass object.
 */
case class StringMeasurement
(
    override val sup: Measurement
)
extends
    Element
{
    def this () = { this (null) }
    def Measurement: Measurement = sup.asInstanceOf[Measurement]
    override def copy (): Row = { clone ().asInstanceOf[StringMeasurement] }
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
        "\t<cim:StringMeasurement rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:StringMeasurement>\n"
    }
}

object StringMeasurement
extends
    Parseable[StringMeasurement]
{
    def parse (context: Context): StringMeasurement =
    {
        StringMeasurement(
            Measurement.parse (context)
        )
    }
}

/**
 * StringMeasurementValue represents a measurement value of type string.
 * @param sup Reference to the superclass object.
 * @param value The value to supervise.
 * @param StringMeasurement Measurement to which this value is connected.
 */
case class StringMeasurementValue
(
    override val sup: MeasurementValue,
    value: String,
    StringMeasurement: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def MeasurementValue: MeasurementValue = sup.asInstanceOf[MeasurementValue]
    override def copy (): Row = { clone ().asInstanceOf[StringMeasurementValue] }
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
        (if (null != value) "\t\t<cim:StringMeasurementValue.value>" + value + "</cim:StringMeasurementValue.value>\n" else "") +
        (if (null != StringMeasurement) "\t\t<cim:StringMeasurementValue.StringMeasurement rdf:resource=\"#" + StringMeasurement + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:StringMeasurementValue rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:StringMeasurementValue>\n"
    }
}

object StringMeasurementValue
extends
    Parseable[StringMeasurementValue]
{
    val value: (Context) => String = parse_element (element ("""StringMeasurementValue.value"""))
    val StringMeasurement: (Context) => String = parse_attribute (attribute ("""StringMeasurementValue.StringMeasurement"""))
    def parse (context: Context): StringMeasurementValue =
    {
        StringMeasurementValue(
            MeasurementValue.parse (context),
            value (context),
            StringMeasurement (context)
        )
    }
}

/**
 * Describes the translation of a set of values into a name and is intendend to facilitate cusom translations.
 * Each ValueAliasSet has a name, description etc. A specific Measurement may represent a discrete state like Open, Closed, Intermediate etc. This requires a translation from the MeasurementValue.value number to a string, e.g. 0-&gt;"Invalid", 1-&gt;"Open", 2-&gt;"Closed", 3-&gt;"Intermediate". Each ValueToAlias member in ValueAliasSet.Value describe a mapping for one particular value to a name.
 * @param sup Reference to the superclass object.
 */
case class ValueAliasSet
(
    override val sup: IdentifiedObject
)
extends
    Element
{
    def this () = { this (null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ValueAliasSet] }
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
        "\t<cim:ValueAliasSet rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ValueAliasSet>\n"
    }
}

object ValueAliasSet
extends
    Parseable[ValueAliasSet]
{
    def parse (context: Context): ValueAliasSet =
    {
        ValueAliasSet(
            IdentifiedObject.parse (context)
        )
    }
}

/**
 * Describes the translation of one particular value into a name, e.g. 1 as "Open".
 * @param sup Reference to the superclass object.
 * @param value The value that is mapped.
 * @param ValueAliasSet The ValueAliasSet having the ValueToAlias mappings.
 */
case class ValueToAlias
(
    override val sup: IdentifiedObject,
    value: Int,
    ValueAliasSet: String
)
extends
    Element
{
    def this () = { this (null, 0, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ValueToAlias] }
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
        "\t\t<cim:ValueToAlias.value>" + value + "</cim:ValueToAlias.value>\n" +
        (if (null != ValueAliasSet) "\t\t<cim:ValueToAlias.ValueAliasSet rdf:resource=\"#" + ValueAliasSet + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ValueToAlias rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ValueToAlias>\n"
    }
}

object ValueToAlias
extends
    Parseable[ValueToAlias]
{
    val value: (Context) => String = parse_element (element ("""ValueToAlias.value"""))
    val ValueAliasSet: (Context) => String = parse_attribute (attribute ("""ValueToAlias.ValueAliasSet"""))
    def parse (context: Context): ValueToAlias =
    {
        ValueToAlias(
            IdentifiedObject.parse (context),
            toInteger (value (context), context),
            ValueAliasSet (context)
        )
    }
}

private[ninecode] object _Meas
{
    def register: List[ClassInfo] =
    {
        List (
            Accumulator.register,
            AccumulatorLimit.register,
            AccumulatorLimitSet.register,
            AccumulatorReset.register,
            AccumulatorValue.register,
            Analog.register,
            AnalogControl.register,
            AnalogLimit.register,
            AnalogLimitSet.register,
            AnalogValue.register,
            Command.register,
            Control.register,
            Discrete.register,
            DiscreteCommand.register,
            DiscreteValue.register,
            Limit.register,
            LimitSet.register,
            Measurement.register,
            MeasurementValue.register,
            MeasurementValueQuality.register,
            MeasurementValueSource.register,
            Quality61850.register,
            RaiseLowerCommand.register,
            SetPoint.register,
            StringMeasurement.register,
            StringMeasurementValue.register,
            ValueAliasSet.register,
            ValueToAlias.register
        )
    }
}