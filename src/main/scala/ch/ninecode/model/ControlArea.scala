package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * The ControlArea package models area specifications which can be used for a variety of purposes.
 * The package as a whole models potentially overlapping control area specifications for the purpose of actual generation control, load forecast area load capture, or powerflow based analysis.
 */

/**
 * A prioritized measurement to be used for the generating unit in the control area specificaiton.
 */
case class AltGeneratingUnitMeas
(

    override val sup: BasicElement,

    /**
     * Priority of a measurement usage.
     * Lower numbers have first priority.
     */
    val priority: Int,

    /**
     * The specific analog value used as a source.
     */
    val AnalogValue: String
)
extends
    Element
{
    def this () = { this (null, 0, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[AltGeneratingUnitMeas]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AltGeneratingUnitMeas
extends
    Parseable[AltGeneratingUnitMeas]
{
    val sup = BasicElement.parse _
    val priority = parse_element (element ("""AltGeneratingUnitMeas.priority"""))_
    val AnalogValue = parse_attribute (attribute ("""AltGeneratingUnitMeas.AnalogValue"""))_
    def parse (context: Context): AltGeneratingUnitMeas =
    {
        AltGeneratingUnitMeas(
            sup (context),
            toInteger (priority (context), context),
            AnalogValue (context)
        )
    }
}

/**
 * A prioritized measurement to be used for the tie flow as part of the control area specification.
 */
case class AltTieMeas
(

    override val sup: BasicElement,

    /**
     * Priority of a measurement usage.
     * Lower numbers have first priority.
     */
    val priority: Int,

    /**
     * The specific analog value used as a source.
     */
    val AnalogValue: String
)
extends
    Element
{
    def this () = { this (null, 0, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[AltTieMeas]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AltTieMeas
extends
    Parseable[AltTieMeas]
{
    val sup = BasicElement.parse _
    val priority = parse_element (element ("""AltTieMeas.priority"""))_
    val AnalogValue = parse_attribute (attribute ("""AltTieMeas.AnalogValue"""))_
    def parse (context: Context): AltTieMeas =
    {
        AltTieMeas(
            sup (context),
            toInteger (priority (context), context),
            AnalogValue (context)
        )
    }
}

/**
 * A control area<b> </b>is a grouping of generating units and/or loads and a cutset of tie lines (as terminals) which may be used for a variety of purposes including automatic generation control, powerflow solution area interchange control specification, and input to load forecasting.
 * Note that any number of overlapping control area specifications can be superimposed on the physical model.
 */
case class ControlArea
(

    override val sup: PowerSystemResource,

    /**
     * The specified positive net interchange into the control area, i.e. positive sign means flow in to the area.
     */
    val netInterchange: Double,

    /**
     * Active power net interchange tolerance
     */
    val pTolerance: Double,

    /**
     * The primary type of control area definition used to determine if this is used for automatic generation control, for planning interchange control, or other purposes.
     * A control area specified with primary type of automatic generation control could still be forecast and used as an interchange area in power flow analysis.
     */
    val typ: String,

    /**
     * The energy area that is forecast from this control area specification.
     */
    val EnergyArea: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null, null) }
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { return (clone ().asInstanceOf[ControlArea]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ControlArea
extends
    Parseable[ControlArea]
{
    val sup = PowerSystemResource.parse _
    val netInterchange = parse_element (element ("""ControlArea.netInterchange"""))_
    val pTolerance = parse_element (element ("""ControlArea.pTolerance"""))_
    val typ = parse_attribute (attribute ("""ControlArea.type"""))_
    val EnergyArea = parse_attribute (attribute ("""ControlArea.EnergyArea"""))_
    def parse (context: Context): ControlArea =
    {
        ControlArea(
            sup (context),
            toDouble (netInterchange (context), context),
            toDouble (pTolerance (context), context),
            typ (context),
            EnergyArea (context)
        )
    }
}

/**
 * A control area generating unit.
 * This class is needed so that alternate control area definitions may include the same generating unit.   Note only one instance within a control area should reference a specific generating unit.
 */
case class ControlAreaGeneratingUnit
(

    override val sup: IdentifiedObject,

    /**
     * The generating unit specified for this control area.
     * Note that a control area should include a GeneratingUnit only once.
     */
    val GeneratingUnit: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ControlAreaGeneratingUnit]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ControlAreaGeneratingUnit
extends
    Parseable[ControlAreaGeneratingUnit]
{
    val sup = IdentifiedObject.parse _
    val GeneratingUnit = parse_attribute (attribute ("""ControlAreaGeneratingUnit.GeneratingUnit"""))_
    def parse (context: Context): ControlAreaGeneratingUnit =
    {
        ControlAreaGeneratingUnit(
            sup (context),
            GeneratingUnit (context)
        )
    }
}

/**
 * The type of control area.
 */
case class ControlAreaTypeKind
(

    override val sup: BasicElement,

    /**
     * Used for automatic generation control.
     */
    val AGC: String,

    /**
     * Used for load forecast.
     */
    val Forecast: String,

    /**
     * Used for interchange specification or control.
     */
    val Interchange: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ControlAreaTypeKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ControlAreaTypeKind
extends
    Parseable[ControlAreaTypeKind]
{
    val sup = BasicElement.parse _
    val AGC = parse_attribute (attribute ("""ControlAreaTypeKind.AGC"""))_
    val Forecast = parse_attribute (attribute ("""ControlAreaTypeKind.Forecast"""))_
    val Interchange = parse_attribute (attribute ("""ControlAreaTypeKind.Interchange"""))_
    def parse (context: Context): ControlAreaTypeKind =
    {
        ControlAreaTypeKind(
            sup (context),
            AGC (context),
            Forecast (context),
            Interchange (context)
        )
    }
}

/**
 * A flow specification in terms of location and direction for a control area.
 */
case class TieFlow
(

    override val sup: BasicElement,

    /**
     * True if the flow into the terminal (load convention) is also flow into the control area.
     * For example, this attribute should be true if using the tie line terminal further away from the control area. For example to represent a tie to a shunt component (like a load or generator) in another area, this is the near end of a branch and this attribute would be specified as false.
     */
    val positiveFlowIn: Boolean,

    /**
     * The terminal to which this tie flow belongs.
     */
    val Terminal: String
)
extends
    Element
{
    def this () = { this (null, false, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[TieFlow]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TieFlow
extends
    Parseable[TieFlow]
{
    val sup = BasicElement.parse _
    val positiveFlowIn = parse_element (element ("""TieFlow.positiveFlowIn"""))_
    val Terminal = parse_attribute (attribute ("""TieFlow.Terminal"""))_
    def parse (context: Context): TieFlow =
    {
        TieFlow(
            sup (context),
            toBoolean (positiveFlowIn (context), context),
            Terminal (context)
        )
    }
}

object _ControlArea
{
    def register: Unit =
    {
        AltGeneratingUnitMeas.register
        AltTieMeas.register
        ControlArea.register
        ControlAreaGeneratingUnit.register
        ControlAreaTypeKind.register
        TieFlow.register
    }
}