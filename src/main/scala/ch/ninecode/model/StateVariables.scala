package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * An abstract class for state variables.
 *
 * @param sup Reference to the superclass object.
 * @group StateVariables
 * @groupname StateVariables Package StateVariables
 * @groupdesc StateVariables State variables for analysis solutions such as powerflow.
 */
case class StateVariable
(
    override val sup: BasicElement
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
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[StateVariable] }
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
        "\t<cim:StateVariable rdf:ID=\"%s\">\n%s\t</cim:StateVariable>".format (id, export_fields)
    }
}

object StateVariable
extends
    Parseable[StateVariable]
{

    def parse (context: Context): StateVariable =
    {
        implicit val ctx: Context = context
        val ret = StateVariable (
            BasicElement.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * The SvInjection is reporting the calculated bus injection minus the sum of the terminal flows.
 *
 * The terminal flow is positive out from the bus (load sign convention) and bus injection has positive flow into the bus. SvInjection may have the remainder after state estimation or slack after power flow calculation.
 *
 * @param sup [[ch.ninecode.model.StateVariable StateVariable]] Reference to the superclass object.
 * @param pInjection The active power injected into the bus in addition to injections from equipment terminals.
 *        Positive sign means injection into the TopologicalNode (bus).
 * @param qInjection The reactive power injected into the bus in addition to injections from equipment terminals.
 *        Positive sign means injection into the TopologicalNode (bus).
 * @param TopologicalNode [[ch.ninecode.model.TopologicalNode TopologicalNode]] The topological node associated with the flow injection state variable.
 * @group StateVariables
 * @groupname StateVariables Package StateVariables
 * @groupdesc StateVariables State variables for analysis solutions such as powerflow.
 */
case class SvInjection
(
    override val sup: StateVariable,
    pInjection: Double,
    qInjection: Double,
    TopologicalNode: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def StateVariable: StateVariable = sup.asInstanceOf[StateVariable]
    override def copy (): Row = { clone ().asInstanceOf[SvInjection] }
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
        implicit val clz: String = SvInjection.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SvInjection.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SvInjection.fields (position), value)
        emitelem (0, pInjection)
        emitelem (1, qInjection)
        emitattr (2, TopologicalNode)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SvInjection rdf:ID=\"%s\">\n%s\t</cim:SvInjection>".format (id, export_fields)
    }
}

object SvInjection
extends
    Parseable[SvInjection]
{
    val fields: Array[String] = Array[String] (
        "pInjection",
        "qInjection",
        "TopologicalNode"
    )
    val pInjection: Fielder = parse_element (element (cls, fields(0)))
    val qInjection: Fielder = parse_element (element (cls, fields(1)))
    val TopologicalNode: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): SvInjection =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = SvInjection (
            StateVariable.parse (context),
            toDouble (mask (pInjection (), 0)),
            toDouble (mask (qInjection (), 1)),
            mask (TopologicalNode (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("TopologicalNode", "TopologicalNode", false)
    )
}

/**
 * State variable for power flow.
 *
 * Load convention is used for flow direction. This means flow out from the TopologicalNode into the equipment is positive.
 *
 * @param sup [[ch.ninecode.model.StateVariable StateVariable]] Reference to the superclass object.
 * @param p The active power flow.
 *        Load sign convention is used, i.e. positive sign means flow out from a TopologicalNode (bus) into the conducting equipment.
 * @param q The reactive power flow.
 *        Load sign convention is used, i.e. positive sign means flow out from a TopologicalNode (bus) into the conducting equipment.
 * @param Terminal [[ch.ninecode.model.Terminal Terminal]] The terminal associated with the power flow state variable.
 * @group StateVariables
 * @groupname StateVariables Package StateVariables
 * @groupdesc StateVariables State variables for analysis solutions such as powerflow.
 */
case class SvPowerFlow
(
    override val sup: StateVariable,
    p: Double,
    q: Double,
    Terminal: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def StateVariable: StateVariable = sup.asInstanceOf[StateVariable]
    override def copy (): Row = { clone ().asInstanceOf[SvPowerFlow] }
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
        implicit val clz: String = SvPowerFlow.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SvPowerFlow.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SvPowerFlow.fields (position), value)
        emitelem (0, p)
        emitelem (1, q)
        emitattr (2, Terminal)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SvPowerFlow rdf:ID=\"%s\">\n%s\t</cim:SvPowerFlow>".format (id, export_fields)
    }
}

object SvPowerFlow
extends
    Parseable[SvPowerFlow]
{
    val fields: Array[String] = Array[String] (
        "p",
        "q",
        "Terminal"
    )
    val p: Fielder = parse_element (element (cls, fields(0)))
    val q: Fielder = parse_element (element (cls, fields(1)))
    val Terminal: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): SvPowerFlow =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = SvPowerFlow (
            StateVariable.parse (context),
            toDouble (mask (p (), 0)),
            toDouble (mask (q (), 1)),
            mask (Terminal (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Terminal", "Terminal", false)
    )
}

/**
 * State variable for the number of sections in service for a shunt compensator.
 *
 * @param sup [[ch.ninecode.model.StateVariable StateVariable]] Reference to the superclass object.
 * @param sections The number of sections in service as a continous variable.
 *        To get integer value scale with ShuntCompensator.bPerSection.
 * @param ShuntCompensator [[ch.ninecode.model.ShuntCompensator ShuntCompensator]] The shunt compensator for which the state applies.
 * @group StateVariables
 * @groupname StateVariables Package StateVariables
 * @groupdesc StateVariables State variables for analysis solutions such as powerflow.
 */
case class SvShuntCompensatorSections
(
    override val sup: StateVariable,
    sections: Double,
    ShuntCompensator: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def StateVariable: StateVariable = sup.asInstanceOf[StateVariable]
    override def copy (): Row = { clone ().asInstanceOf[SvShuntCompensatorSections] }
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
        implicit val clz: String = SvShuntCompensatorSections.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SvShuntCompensatorSections.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SvShuntCompensatorSections.fields (position), value)
        emitelem (0, sections)
        emitattr (1, ShuntCompensator)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SvShuntCompensatorSections rdf:ID=\"%s\">\n%s\t</cim:SvShuntCompensatorSections>".format (id, export_fields)
    }
}

object SvShuntCompensatorSections
extends
    Parseable[SvShuntCompensatorSections]
{
    val fields: Array[String] = Array[String] (
        "sections",
        "ShuntCompensator"
    )
    val sections: Fielder = parse_element (element (cls, fields(0)))
    val ShuntCompensator: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): SvShuntCompensatorSections =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = SvShuntCompensatorSections (
            StateVariable.parse (context),
            toDouble (mask (sections (), 0)),
            mask (ShuntCompensator (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ShuntCompensator", "ShuntCompensator", false)
    )
}

/**
 * State variable for status.
 *
 * @param sup [[ch.ninecode.model.StateVariable StateVariable]] Reference to the superclass object.
 * @param inService The in service status as a result of topology processing.
 * @param ConductingEquipment [[ch.ninecode.model.ConductingEquipment ConductingEquipment]] The conducting equipment associated with the status state variable.
 * @group StateVariables
 * @groupname StateVariables Package StateVariables
 * @groupdesc StateVariables State variables for analysis solutions such as powerflow.
 */
case class SvStatus
(
    override val sup: StateVariable,
    inService: Boolean,
    ConductingEquipment: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def StateVariable: StateVariable = sup.asInstanceOf[StateVariable]
    override def copy (): Row = { clone ().asInstanceOf[SvStatus] }
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
        implicit val clz: String = SvStatus.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SvStatus.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SvStatus.fields (position), value)
        emitelem (0, inService)
        emitattr (1, ConductingEquipment)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SvStatus rdf:ID=\"%s\">\n%s\t</cim:SvStatus>".format (id, export_fields)
    }
}

object SvStatus
extends
    Parseable[SvStatus]
{
    val fields: Array[String] = Array[String] (
        "inService",
        "ConductingEquipment"
    )
    val inService: Fielder = parse_element (element (cls, fields(0)))
    val ConductingEquipment: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): SvStatus =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = SvStatus (
            StateVariable.parse (context),
            toBoolean (mask (inService (), 0)),
            mask (ConductingEquipment (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ConductingEquipment", "ConductingEquipment", false)
    )
}

/**
 * State variable for transformer tap step.
 *
 * This class is to be used for taps of LTC (load tap changing) transformers, not fixed tap transformers.
 *
 * @param sup [[ch.ninecode.model.StateVariable StateVariable]] Reference to the superclass object.
 * @param position The floating point tap position.
 *        This is not the tap ratio, but rather the tap step position as defined by the related tap changer model and normally is constrained to be within the range of minimum and maximum tap positions.
 * @param TapChanger [[ch.ninecode.model.TapChanger TapChanger]] The tap changer associated with the tap step state.
 * @group StateVariables
 * @groupname StateVariables Package StateVariables
 * @groupdesc StateVariables State variables for analysis solutions such as powerflow.
 */
case class SvTapStep
(
    override val sup: StateVariable,
    position: Double,
    TapChanger: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def StateVariable: StateVariable = sup.asInstanceOf[StateVariable]
    override def copy (): Row = { clone ().asInstanceOf[SvTapStep] }
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
        implicit val clz: String = SvTapStep.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SvTapStep.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SvTapStep.fields (position), value)
        emitelem (0, position)
        emitattr (1, TapChanger)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SvTapStep rdf:ID=\"%s\">\n%s\t</cim:SvTapStep>".format (id, export_fields)
    }
}

object SvTapStep
extends
    Parseable[SvTapStep]
{
    val fields: Array[String] = Array[String] (
        "position",
        "TapChanger"
    )
    val position: Fielder = parse_element (element (cls, fields(0)))
    val TapChanger: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): SvTapStep =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = SvTapStep (
            StateVariable.parse (context),
            toDouble (mask (position (), 0)),
            mask (TapChanger (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("TapChanger", "TapChanger", false)
    )
}

/**
 * State variable for voltage.
 *
 * @param sup [[ch.ninecode.model.StateVariable StateVariable]] Reference to the superclass object.
 * @param angle The voltage angle of the topological node complex voltage with respect to system reference.
 * @param v The voltage magnitude of the topological node.
 * @param TopologicalNode [[ch.ninecode.model.TopologicalNode TopologicalNode]] The topological node associated with the voltage state.
 * @group StateVariables
 * @groupname StateVariables Package StateVariables
 * @groupdesc StateVariables State variables for analysis solutions such as powerflow.
 */
case class SvVoltage
(
    override val sup: StateVariable,
    angle: Double,
    v: Double,
    TopologicalNode: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def StateVariable: StateVariable = sup.asInstanceOf[StateVariable]
    override def copy (): Row = { clone ().asInstanceOf[SvVoltage] }
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
        implicit val clz: String = SvVoltage.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SvVoltage.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SvVoltage.fields (position), value)
        emitelem (0, angle)
        emitelem (1, v)
        emitattr (2, TopologicalNode)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SvVoltage rdf:ID=\"%s\">\n%s\t</cim:SvVoltage>".format (id, export_fields)
    }
}

object SvVoltage
extends
    Parseable[SvVoltage]
{
    val fields: Array[String] = Array[String] (
        "angle",
        "v",
        "TopologicalNode"
    )
    val angle: Fielder = parse_element (element (cls, fields(0)))
    val v: Fielder = parse_element (element (cls, fields(1)))
    val TopologicalNode: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): SvVoltage =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = SvVoltage (
            StateVariable.parse (context),
            toDouble (mask (angle (), 0)),
            toDouble (mask (v (), 1)),
            mask (TopologicalNode (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("TopologicalNode", "TopologicalNode", false)
    )
}

private[ninecode] object _StateVariables
{
    def register: List[ClassInfo] =
    {
        List (
            StateVariable.register,
            SvInjection.register,
            SvPowerFlow.register,
            SvShuntCompensatorSections.register,
            SvStatus.register,
            SvTapStep.register,
            SvVoltage.register
        )
    }
}