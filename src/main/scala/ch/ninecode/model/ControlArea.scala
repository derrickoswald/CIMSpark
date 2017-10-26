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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = AltGeneratingUnitMeas.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AltGeneratingUnitMeas.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AltGeneratingUnitMeas.fields (position), value)
        emitelem (0, priority)
        emitattr (1, AnalogValue)
        emitattr (2, ControlAreaGeneratingUnit)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AltGeneratingUnitMeas rdf:ID=\"%s\">\n%s\t</cim:AltGeneratingUnitMeas>".format (id, export_fields)
    }
}

object AltGeneratingUnitMeas
extends
    Parseable[AltGeneratingUnitMeas]
{
    val fields: Array[String] = Array[String] (
        "priority",
        "AnalogValue",
        "ControlAreaGeneratingUnit"
    )
    val priority: Fielder = parse_element (element (cls, fields(0)))
    val AnalogValue: Fielder = parse_attribute (attribute (cls, fields(1)))
    val ControlAreaGeneratingUnit: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): AltGeneratingUnitMeas =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = AltGeneratingUnitMeas (
            BasicElement.parse (context),
            toInteger (mask (priority (), 0)),
            mask (AnalogValue (), 1),
            mask (ControlAreaGeneratingUnit (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("AnalogValue", "AnalogValue", false),
        Relationship ("ControlAreaGeneratingUnit", "ControlAreaGeneratingUnit", false)
    )
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = AltTieMeas.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AltTieMeas.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AltTieMeas.fields (position), value)
        emitelem (0, priority)
        emitattr (1, AnalogValue)
        emitattr (2, TieFlow)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AltTieMeas rdf:ID=\"%s\">\n%s\t</cim:AltTieMeas>".format (id, export_fields)
    }
}

object AltTieMeas
extends
    Parseable[AltTieMeas]
{
    val fields: Array[String] = Array[String] (
        "priority",
        "AnalogValue",
        "TieFlow"
    )
    val priority: Fielder = parse_element (element (cls, fields(0)))
    val AnalogValue: Fielder = parse_attribute (attribute (cls, fields(1)))
    val TieFlow: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): AltTieMeas =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = AltTieMeas (
            BasicElement.parse (context),
            toInteger (mask (priority (), 0)),
            mask (AnalogValue (), 1),
            mask (TieFlow (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("AnalogValue", "AnalogValue", false),
        Relationship ("TieFlow", "TieFlow", false)
    )
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ControlArea.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ControlArea.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ControlArea.fields (position), value)
        emitelem (0, netInterchange)
        emitelem (1, pTolerance)
        emitattr (2, typ)
        emitattr (3, EnergyArea)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ControlArea rdf:ID=\"%s\">\n%s\t</cim:ControlArea>".format (id, export_fields)
    }
}

object ControlArea
extends
    Parseable[ControlArea]
{
    val fields: Array[String] = Array[String] (
        "netInterchange",
        "pTolerance",
        "type",
        "EnergyArea"
    )
    val netInterchange: Fielder = parse_element (element (cls, fields(0)))
    val pTolerance: Fielder = parse_element (element (cls, fields(1)))
    val typ: Fielder = parse_attribute (attribute (cls, fields(2)))
    val EnergyArea: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): ControlArea =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ControlArea (
            PowerSystemResource.parse (context),
            toDouble (mask (netInterchange (), 0)),
            toDouble (mask (pTolerance (), 1)),
            mask (typ (), 2),
            mask (EnergyArea (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("EnergyArea", "EnergyArea", false)
    )
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ControlAreaGeneratingUnit.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ControlAreaGeneratingUnit.fields (position), value)
        emitattr (0, ControlArea)
        emitattr (1, GeneratingUnit)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ControlAreaGeneratingUnit rdf:ID=\"%s\">\n%s\t</cim:ControlAreaGeneratingUnit>".format (id, export_fields)
    }
}

object ControlAreaGeneratingUnit
extends
    Parseable[ControlAreaGeneratingUnit]
{
    val fields: Array[String] = Array[String] (
        "ControlArea",
        "GeneratingUnit"
    )
    val ControlArea: Fielder = parse_attribute (attribute (cls, fields(0)))
    val GeneratingUnit: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): ControlAreaGeneratingUnit =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ControlAreaGeneratingUnit (
            IdentifiedObject.parse (context),
            mask (ControlArea (), 0),
            mask (GeneratingUnit (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ControlArea", "ControlArea", false),
        Relationship ("GeneratingUnit", "GeneratingUnit", false)
    )
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TieFlow.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TieFlow.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TieFlow.fields (position), value)
        emitelem (0, positiveFlowIn)
        emitattr (1, ControlArea)
        emitattr (2, Terminal)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TieFlow rdf:ID=\"%s\">\n%s\t</cim:TieFlow>".format (id, export_fields)
    }
}

object TieFlow
extends
    Parseable[TieFlow]
{
    val fields: Array[String] = Array[String] (
        "positiveFlowIn",
        "ControlArea",
        "Terminal"
    )
    val positiveFlowIn: Fielder = parse_element (element (cls, fields(0)))
    val ControlArea: Fielder = parse_attribute (attribute (cls, fields(1)))
    val Terminal: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): TieFlow =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = TieFlow (
            BasicElement.parse (context),
            toBoolean (mask (positiveFlowIn (), 0)),
            mask (ControlArea (), 1),
            mask (Terminal (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ControlArea", "ControlArea", false),
        Relationship ("Terminal", "Terminal", false)
    )
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