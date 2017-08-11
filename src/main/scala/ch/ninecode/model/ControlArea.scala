package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * The ControlArea package models area specifications which can be used for a variety of purposes.
 * The package as a whole models potentially overlapping control area specifications for the purpose of actual generation control, load forecast area load capture, or powerflow based analysis.
 */

/**
 * A prioritized measurement to be used for the generating unit in the control area specificaiton.
 * @param sup Reference to the superclass object.
 * @param priority Priority of a measurement usage.
 *        Lower numbers have first priority.
 * @param AnalogValue The specific analog value used as a source.
 * @param ControlAreaGeneratingUnit The control aread generating unit to which the prioritized measurement assignment is applied.
 */
case class AltGeneratingUnitMeas
(
    override val sup: BasicElement,
    priority: Int,
    AnalogValue: String,
    ControlAreaGeneratingUnit: String
)
extends
    Element
{
    def this () = { this (null, 0, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[AltGeneratingUnitMeas] }
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
        "\t\t<cim:AltGeneratingUnitMeas.priority>" + priority + "</cim:AltGeneratingUnitMeas.priority>\n" +
        (if (null != AnalogValue) "\t\t<cim:AltGeneratingUnitMeas.AnalogValue rdf:resource=\"#" + AnalogValue + "\"/>\n" else "") +
        (if (null != ControlAreaGeneratingUnit) "\t\t<cim:AltGeneratingUnitMeas.ControlAreaGeneratingUnit rdf:resource=\"#" + ControlAreaGeneratingUnit + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AltGeneratingUnitMeas rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AltGeneratingUnitMeas>"
    }
}

object AltGeneratingUnitMeas
extends
    Parseable[AltGeneratingUnitMeas]
{
    val priority: (Context) => String = parse_element (element ("""AltGeneratingUnitMeas.priority"""))
    val AnalogValue: (Context) => String = parse_attribute (attribute ("""AltGeneratingUnitMeas.AnalogValue"""))
    val ControlAreaGeneratingUnit: (Context) => String = parse_attribute (attribute ("""AltGeneratingUnitMeas.ControlAreaGeneratingUnit"""))
    def parse (context: Context): AltGeneratingUnitMeas =
    {
        AltGeneratingUnitMeas(
            BasicElement.parse (context),
            toInteger (priority (context), context),
            AnalogValue (context),
            ControlAreaGeneratingUnit (context)
        )
    }
}

/**
 * A prioritized measurement to be used for the tie flow as part of the control area specification.
 * @param sup Reference to the superclass object.
 * @param priority Priority of a measurement usage.
 *        Lower numbers have first priority.
 * @param AnalogValue The specific analog value used as a source.
 * @param TieFlow The tie flow of the alternate measurements.
 */
case class AltTieMeas
(
    override val sup: BasicElement,
    priority: Int,
    AnalogValue: String,
    TieFlow: String
)
extends
    Element
{
    def this () = { this (null, 0, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[AltTieMeas] }
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
        "\t\t<cim:AltTieMeas.priority>" + priority + "</cim:AltTieMeas.priority>\n" +
        (if (null != AnalogValue) "\t\t<cim:AltTieMeas.AnalogValue rdf:resource=\"#" + AnalogValue + "\"/>\n" else "") +
        (if (null != TieFlow) "\t\t<cim:AltTieMeas.TieFlow rdf:resource=\"#" + TieFlow + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AltTieMeas rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AltTieMeas>"
    }
}

object AltTieMeas
extends
    Parseable[AltTieMeas]
{
    val priority: (Context) => String = parse_element (element ("""AltTieMeas.priority"""))
    val AnalogValue: (Context) => String = parse_attribute (attribute ("""AltTieMeas.AnalogValue"""))
    val TieFlow: (Context) => String = parse_attribute (attribute ("""AltTieMeas.TieFlow"""))
    def parse (context: Context): AltTieMeas =
    {
        AltTieMeas(
            BasicElement.parse (context),
            toInteger (priority (context), context),
            AnalogValue (context),
            TieFlow (context)
        )
    }
}

/**
 * A control area<b> </b>is a grouping of generating units and/or loads and a cutset of tie lines (as terminals) which may be used for a variety of purposes including automatic generation control, powerflow solution area interchange control specification, and input to load forecasting.
 * Note that any number of overlapping control area specifications can be superimposed on the physical model.
 * @param sup Reference to the superclass object.
 * @param netInterchange The specified positive net interchange into the control area, i.e. positive sign means flow in to the area.
 * @param pTolerance Active power net interchange tolerance
 * @param typ The primary type of control area definition used to determine if this is used for automatic generation control, for planning interchange control, or other purposes.
 *        A control area specified with primary type of automatic generation control could still be forecast and used as an interchange area in power flow analysis.
 * @param EnergyArea The energy area that is forecast from this control area specification.
 */
case class ControlArea
(
    override val sup: PowerSystemResource,
    netInterchange: Double,
    pTolerance: Double,
    typ: String,
    EnergyArea: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null, null) }
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { clone ().asInstanceOf[ControlArea] }
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
        "\t\t<cim:ControlArea.netInterchange>" + netInterchange + "</cim:ControlArea.netInterchange>\n" +
        "\t\t<cim:ControlArea.pTolerance>" + pTolerance + "</cim:ControlArea.pTolerance>\n" +
        (if (null != typ) "\t\t<cim:ControlArea.type rdf:resource=\"#" + typ + "\"/>\n" else "") +
        (if (null != EnergyArea) "\t\t<cim:ControlArea.EnergyArea rdf:resource=\"#" + EnergyArea + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ControlArea rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ControlArea>"
    }
}

object ControlArea
extends
    Parseable[ControlArea]
{
    val netInterchange: (Context) => String = parse_element (element ("""ControlArea.netInterchange"""))
    val pTolerance: (Context) => String = parse_element (element ("""ControlArea.pTolerance"""))
    val typ: (Context) => String = parse_attribute (attribute ("""ControlArea.type"""))
    val EnergyArea: (Context) => String = parse_attribute (attribute ("""ControlArea.EnergyArea"""))
    def parse (context: Context): ControlArea =
    {
        ControlArea(
            PowerSystemResource.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param ControlArea The parent control area for the generating unit specifications.
 * @param GeneratingUnit The generating unit specified for this control area.
 *        Note that a control area should include a GeneratingUnit only once.
 */
case class ControlAreaGeneratingUnit
(
    override val sup: IdentifiedObject,
    ControlArea: String,
    GeneratingUnit: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ControlAreaGeneratingUnit] }
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
        (if (null != ControlArea) "\t\t<cim:ControlAreaGeneratingUnit.ControlArea rdf:resource=\"#" + ControlArea + "\"/>\n" else "") +
        (if (null != GeneratingUnit) "\t\t<cim:ControlAreaGeneratingUnit.GeneratingUnit rdf:resource=\"#" + GeneratingUnit + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ControlAreaGeneratingUnit rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ControlAreaGeneratingUnit>"
    }
}

object ControlAreaGeneratingUnit
extends
    Parseable[ControlAreaGeneratingUnit]
{
    val ControlArea: (Context) => String = parse_attribute (attribute ("""ControlAreaGeneratingUnit.ControlArea"""))
    val GeneratingUnit: (Context) => String = parse_attribute (attribute ("""ControlAreaGeneratingUnit.GeneratingUnit"""))
    def parse (context: Context): ControlAreaGeneratingUnit =
    {
        ControlAreaGeneratingUnit(
            IdentifiedObject.parse (context),
            ControlArea (context),
            GeneratingUnit (context)
        )
    }
}

/**
 * A flow specification in terms of location and direction for a control area.
 * @param sup Reference to the superclass object.
 * @param positiveFlowIn True if the flow into the terminal (load convention) is also flow into the control area.
 *        For example, this attribute should be true if using the tie line terminal further away from the control area. For example to represent a tie to a shunt component (like a load or generator) in another area, this is the near end of a branch and this attribute would be specified as false.
 * @param ControlArea The control area of the tie flows.
 * @param Terminal The terminal to which this tie flow belongs.
 */
case class TieFlow
(
    override val sup: BasicElement,
    positiveFlowIn: Boolean,
    ControlArea: String,
    Terminal: String
)
extends
    Element
{
    def this () = { this (null, false, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[TieFlow] }
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
        "\t\t<cim:TieFlow.positiveFlowIn>" + positiveFlowIn + "</cim:TieFlow.positiveFlowIn>\n" +
        (if (null != ControlArea) "\t\t<cim:TieFlow.ControlArea rdf:resource=\"#" + ControlArea + "\"/>\n" else "") +
        (if (null != Terminal) "\t\t<cim:TieFlow.Terminal rdf:resource=\"#" + Terminal + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TieFlow rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TieFlow>"
    }
}

object TieFlow
extends
    Parseable[TieFlow]
{
    val positiveFlowIn: (Context) => String = parse_element (element ("""TieFlow.positiveFlowIn"""))
    val ControlArea: (Context) => String = parse_attribute (attribute ("""TieFlow.ControlArea"""))
    val Terminal: (Context) => String = parse_attribute (attribute ("""TieFlow.Terminal"""))
    def parse (context: Context): TieFlow =
    {
        TieFlow(
            BasicElement.parse (context),
            toBoolean (positiveFlowIn (context), context),
            ControlArea (context),
            Terminal (context)
        )
    }
}

private[ninecode] object _ControlArea
{
    def register: List[ClassInfo] =
    {
        List (
            AltGeneratingUnitMeas.register,
            AltTieMeas.register,
            ControlArea.register,
            ControlAreaGeneratingUnit.register,
            TieFlow.register
        )
    }
}