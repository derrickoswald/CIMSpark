package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * A prioritized measurement to be used for the generating unit in the control area specificaiton.
 *
 * @param sup Reference to the superclass object.
 * @param priority Priority of a measurement usage.
 *        Lower numbers have first priority.
 * @param AnalogValue [[ch.ninecode.model.AnalogValue AnalogValue]] The specific analog value used as a source.
 * @param ControlAreaGeneratingUnit [[ch.ninecode.model.ControlAreaGeneratingUnit ControlAreaGeneratingUnit]] The control aread generating unit to which the prioritized measurement assignment is applied.
 * @group ControlArea
 * @groupname ControlArea Package ControlArea
 * @groupdesc ControlArea The ControlArea package models area specifications which can be used for a variety of purposes.  The package as a whole models potentially overlapping control area specifications for the purpose of actual generation control, load forecast area load capture, or powerflow based analysis.
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
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
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
    val priority = parse_element (element ("""AltGeneratingUnitMeas.priority"""))
    val AnalogValue = parse_attribute (attribute ("""AltGeneratingUnitMeas.AnalogValue"""))
    val ControlAreaGeneratingUnit = parse_attribute (attribute ("""AltGeneratingUnitMeas.ControlAreaGeneratingUnit"""))
    def parse (context: Context): AltGeneratingUnitMeas =
    {
        AltGeneratingUnitMeas(
            BasicElement.parse (context),
            toInteger (priority (context), context),
            AnalogValue (context),
            ControlAreaGeneratingUnit (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("AnalogValue", "AnalogValue", false),
        Relationship ("ControlAreaGeneratingUnit", "ControlAreaGeneratingUnit", false))
}

/**
 * A prioritized measurement to be used for the tie flow as part of the control area specification.
 *
 * @param sup Reference to the superclass object.
 * @param priority Priority of a measurement usage.
 *        Lower numbers have first priority.
 * @param AnalogValue [[ch.ninecode.model.AnalogValue AnalogValue]] The specific analog value used as a source.
 * @param TieFlow [[ch.ninecode.model.TieFlow TieFlow]] The tie flow of the alternate measurements.
 * @group ControlArea
 * @groupname ControlArea Package ControlArea
 * @groupdesc ControlArea The ControlArea package models area specifications which can be used for a variety of purposes.  The package as a whole models potentially overlapping control area specifications for the purpose of actual generation control, load forecast area load capture, or powerflow based analysis.
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
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
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
    val priority = parse_element (element ("""AltTieMeas.priority"""))
    val AnalogValue = parse_attribute (attribute ("""AltTieMeas.AnalogValue"""))
    val TieFlow = parse_attribute (attribute ("""AltTieMeas.TieFlow"""))
    def parse (context: Context): AltTieMeas =
    {
        AltTieMeas(
            BasicElement.parse (context),
            toInteger (priority (context), context),
            AnalogValue (context),
            TieFlow (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("AnalogValue", "AnalogValue", false),
        Relationship ("TieFlow", "TieFlow", false))
}

/**
 * A control area<b> </b>is a grouping of generating units and/or loads and a cutset of tie lines (as terminals) which may be used for a variety of purposes including automatic generation control, powerflow solution area interchange control specification, and input to load forecasting.
 *
 * Note that any number of overlapping control area specifications can be superimposed on the physical model.
 *
 * @param sup [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param netInterchange The specified positive net interchange into the control area, i.e. positive sign means flow in to the area.
 * @param pTolerance Active power net interchange tolerance
 * @param typ The primary type of control area definition used to determine if this is used for automatic generation control, for planning interchange control, or other purposes.
 *        A control area specified with primary type of automatic generation control could still be forecast and used as an interchange area in power flow analysis.
 * @param EnergyArea [[ch.ninecode.model.EnergyArea EnergyArea]] The energy area that is forecast from this control area specification.
 * @group ControlArea
 * @groupname ControlArea Package ControlArea
 * @groupdesc ControlArea The ControlArea package models area specifications which can be used for a variety of purposes.  The package as a whole models potentially overlapping control area specifications for the purpose of actual generation control, load forecast area load capture, or powerflow based analysis.
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
    val netInterchange = parse_element (element ("""ControlArea.netInterchange"""))
    val pTolerance = parse_element (element ("""ControlArea.pTolerance"""))
    val typ = parse_attribute (attribute ("""ControlArea.type"""))
    val EnergyArea = parse_attribute (attribute ("""ControlArea.EnergyArea"""))
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
    val relations: List[Relationship] = List (
        Relationship ("EnergyArea", "EnergyArea", false))
}

/**
 * A control area generating unit.
 *
 * This class is needed so that alternate control area definitions may include the same generating unit.   Note only one instance within a control area should reference a specific generating unit.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param ControlArea [[ch.ninecode.model.ControlArea ControlArea]] The parent control area for the generating unit specifications.
 * @param GeneratingUnit [[ch.ninecode.model.GeneratingUnit GeneratingUnit]] The generating unit specified for this control area.
 *        Note that a control area should include a GeneratingUnit only once.
 * @group ControlArea
 * @groupname ControlArea Package ControlArea
 * @groupdesc ControlArea The ControlArea package models area specifications which can be used for a variety of purposes.  The package as a whole models potentially overlapping control area specifications for the purpose of actual generation control, load forecast area load capture, or powerflow based analysis.
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
    val ControlArea = parse_attribute (attribute ("""ControlAreaGeneratingUnit.ControlArea"""))
    val GeneratingUnit = parse_attribute (attribute ("""ControlAreaGeneratingUnit.GeneratingUnit"""))
    def parse (context: Context): ControlAreaGeneratingUnit =
    {
        ControlAreaGeneratingUnit(
            IdentifiedObject.parse (context),
            ControlArea (context),
            GeneratingUnit (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("ControlArea", "ControlArea", false),
        Relationship ("GeneratingUnit", "GeneratingUnit", false))
}

/**
 * A flow specification in terms of location and direction for a control area.
 *
 * @param sup Reference to the superclass object.
 * @param positiveFlowIn True if the flow into the terminal (load convention) is also flow into the control area.
 *        For example, this attribute should be true if using the tie line terminal further away from the control area. For example to represent a tie to a shunt component (like a load or generator) in another area, this is the near end of a branch and this attribute would be specified as false.
 * @param ControlArea [[ch.ninecode.model.ControlArea ControlArea]] The control area of the tie flows.
 * @param Terminal [[ch.ninecode.model.Terminal Terminal]] The terminal to which this tie flow belongs.
 * @group ControlArea
 * @groupname ControlArea Package ControlArea
 * @groupdesc ControlArea The ControlArea package models area specifications which can be used for a variety of purposes.  The package as a whole models potentially overlapping control area specifications for the purpose of actual generation control, load forecast area load capture, or powerflow based analysis.
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
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
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
    val positiveFlowIn = parse_element (element ("""TieFlow.positiveFlowIn"""))
    val ControlArea = parse_attribute (attribute ("""TieFlow.ControlArea"""))
    val Terminal = parse_attribute (attribute ("""TieFlow.Terminal"""))
    def parse (context: Context): TieFlow =
    {
        TieFlow(
            BasicElement.parse (context),
            toBoolean (positiveFlowIn (context), context),
            ControlArea (context),
            Terminal (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("ControlArea", "ControlArea", false),
        Relationship ("Terminal", "Terminal", false))
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