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
final case class StateVariable
(
    override val sup: BasicElement = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
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
        val ret = StateVariable (
            BasicElement.parse (context)
        )
        ret
    }
}

/**
 * The SvInjection reports the calculated bus injection minus the sum of the terminal flows.
 *
 * The terminal flow is positive out from the bus (load sign convention) and bus injection has positive flow into the bus. SvInjection may have the remainder after state estimation or slack after power flow calculation.
 *
 * @param sup [[ch.ninecode.model.StateVariable StateVariable]] Reference to the superclass object.
 * @param pInjection The active power mismatch between calculated injection and initial injection.
 *        Positive sign means injection into the TopologicalNode (bus).
 * @param phase The terminal phase at which the connection is applied.
 *        If missing, the injection is assumed to be balanced among non-neutral phases.
 * @param qInjection The reactive power mismatch between calculated injection and initial injection.
 *        Positive sign means injection into the TopologicalNode (bus).
 * @param TopologicalNode [[ch.ninecode.model.TopologicalNode TopologicalNode]] The topological node associated with the flow injection state variable.
 * @group StateVariables
 * @groupname StateVariables Package StateVariables
 * @groupdesc StateVariables State variables for analysis solutions such as powerflow.
 */
final case class SvInjection
(
    override val sup: StateVariable = null,
    pInjection: Double = 0.0,
    phase: String = null,
    qInjection: Double = 0.0,
    TopologicalNode: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def StateVariable: StateVariable = sup
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = SvInjection.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SvInjection.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SvInjection.fields (position), value)
        emitelem (0, pInjection)
        emitattr (1, phase)
        emitelem (2, qInjection)
        emitattr (3, TopologicalNode)
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
    override val fields: Array[String] = Array[String] (
        "pInjection",
        "phase",
        "qInjection",
        "TopologicalNode"
    )
    override val relations: List[Relationship] = List (
        Relationship ("TopologicalNode", "TopologicalNode", "1", "0..*")
    )
    val pInjection: Fielder = parse_element (element (cls, fields(0)))
    val phase: Fielder = parse_attribute (attribute (cls, fields(1)))
    val qInjection: Fielder = parse_element (element (cls, fields(2)))
    val TopologicalNode: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): SvInjection =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SvInjection (
            StateVariable.parse (context),
            toDouble (mask (pInjection (), 0)),
            mask (phase (), 1),
            toDouble (mask (qInjection (), 2)),
            mask (TopologicalNode (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * State variable for power flow.
 *
 * Load convention is used for flow direction. This means flow out from the TopologicalNode into the equipment is positive.
 *
 * @param sup [[ch.ninecode.model.StateVariable StateVariable]] Reference to the superclass object.
 * @param p The active power flow.
 *        Load sign convention is used, i.e. positive sign means flow out from a TopologicalNode (bus) into the conducting equipment.
 * @param phase The individual phase of the flow.
 *        If unspecified, then assumed to be balanced among phases.
 * @param q The reactive power flow.
 *        Load sign convention is used, i.e. positive sign means flow out from a TopologicalNode (bus) into the conducting equipment.
 * @param Terminal [[ch.ninecode.model.Terminal Terminal]] The terminal associated with the power flow state variable.
 * @group StateVariables
 * @groupname StateVariables Package StateVariables
 * @groupdesc StateVariables State variables for analysis solutions such as powerflow.
 */
final case class SvPowerFlow
(
    override val sup: StateVariable = null,
    p: Double = 0.0,
    phase: String = null,
    q: Double = 0.0,
    Terminal: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def StateVariable: StateVariable = sup
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = SvPowerFlow.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SvPowerFlow.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SvPowerFlow.fields (position), value)
        emitelem (0, p)
        emitattr (1, phase)
        emitelem (2, q)
        emitattr (3, Terminal)
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
    override val fields: Array[String] = Array[String] (
        "p",
        "phase",
        "q",
        "Terminal"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Terminal", "Terminal", "1", "0..*")
    )
    val p: Fielder = parse_element (element (cls, fields(0)))
    val phase: Fielder = parse_attribute (attribute (cls, fields(1)))
    val q: Fielder = parse_element (element (cls, fields(2)))
    val Terminal: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): SvPowerFlow =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SvPowerFlow (
            StateVariable.parse (context),
            toDouble (mask (p (), 0)),
            mask (phase (), 1),
            toDouble (mask (q (), 2)),
            mask (Terminal (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * State variable for the number of sections in service for a shunt compensator.
 *
 * @param sup [[ch.ninecode.model.StateVariable StateVariable]] Reference to the superclass object.
 * @param phase The terminal phase at which the connection is applied.
 *        If missing, the injection is assumed to be balanced among non-neutral phases.
 * @param sections The number of sections in service as a continuous variable.
 *        To get integer value scale with ShuntCompensator.bPerSection.
 * @param ShuntCompensator [[ch.ninecode.model.ShuntCompensator ShuntCompensator]] The shunt compensator for which the state applies.
 * @group StateVariables
 * @groupname StateVariables Package StateVariables
 * @groupdesc StateVariables State variables for analysis solutions such as powerflow.
 */
final case class SvShuntCompensatorSections
(
    override val sup: StateVariable = null,
    phase: String = null,
    sections: Double = 0.0,
    ShuntCompensator: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def StateVariable: StateVariable = sup
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = SvShuntCompensatorSections.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SvShuntCompensatorSections.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SvShuntCompensatorSections.fields (position), value)
        emitattr (0, phase)
        emitelem (1, sections)
        emitattr (2, ShuntCompensator)
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
    override val fields: Array[String] = Array[String] (
        "phase",
        "sections",
        "ShuntCompensator"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ShuntCompensator", "ShuntCompensator", "1", "0..*")
    )
    val phase: Fielder = parse_attribute (attribute (cls, fields(0)))
    val sections: Fielder = parse_element (element (cls, fields(1)))
    val ShuntCompensator: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): SvShuntCompensatorSections =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SvShuntCompensatorSections (
            StateVariable.parse (context),
            mask (phase (), 0),
            toDouble (mask (sections (), 1)),
            mask (ShuntCompensator (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * State variable for status.
 *
 * @param sup [[ch.ninecode.model.StateVariable StateVariable]] Reference to the superclass object.
 * @param inService The in service status as a result of topology processing.
 *        It indicates if the equipment is considered as energized by the power flow. It reflects if the equipment is connected within a solvable island.  It does not necessarily reflect whether or not the island was solved by the power flow.
 * @param phase The individual phase status.
 *        If the attribute is unspecified, then three phase model is assumed.
 * @param ConductingEquipment [[ch.ninecode.model.ConductingEquipment ConductingEquipment]] The conducting equipment associated with the status state variable.
 * @group StateVariables
 * @groupname StateVariables Package StateVariables
 * @groupdesc StateVariables State variables for analysis solutions such as powerflow.
 */
final case class SvStatus
(
    override val sup: StateVariable = null,
    inService: Boolean = false,
    phase: String = null,
    ConductingEquipment: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def StateVariable: StateVariable = sup
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = SvStatus.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SvStatus.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SvStatus.fields (position), value)
        emitelem (0, inService)
        emitattr (1, phase)
        emitattr (2, ConductingEquipment)
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
    override val fields: Array[String] = Array[String] (
        "inService",
        "phase",
        "ConductingEquipment"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ConductingEquipment", "ConductingEquipment", "1", "0..*")
    )
    val inService: Fielder = parse_element (element (cls, fields(0)))
    val phase: Fielder = parse_attribute (attribute (cls, fields(1)))
    val ConductingEquipment: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): SvStatus =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SvStatus (
            StateVariable.parse (context),
            toBoolean (mask (inService (), 0)),
            mask (phase (), 1),
            mask (ConductingEquipment (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * State variable for switch.
 *
 * @param sup [[ch.ninecode.model.StateVariable StateVariable]] Reference to the superclass object.
 * @param open The attribute tells if the computed state of the switch is considered open.
 * @param phase The terminal phase at which the connection is applied.
 *        If missing, the injection is assumed to be balanced among non-neutral phases.
 * @param Switch [[ch.ninecode.model.Switch Switch]] The switch associated with the switch state.
 * @group StateVariables
 * @groupname StateVariables Package StateVariables
 * @groupdesc StateVariables State variables for analysis solutions such as powerflow.
 */
final case class SvSwitch
(
    override val sup: StateVariable = null,
    open: Boolean = false,
    phase: String = null,
    Switch: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def StateVariable: StateVariable = sup
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = SvSwitch.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SvSwitch.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SvSwitch.fields (position), value)
        emitelem (0, open)
        emitattr (1, phase)
        emitattr (2, Switch)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SvSwitch rdf:ID=\"%s\">\n%s\t</cim:SvSwitch>".format (id, export_fields)
    }
}

object SvSwitch
extends
    Parseable[SvSwitch]
{
    override val fields: Array[String] = Array[String] (
        "open",
        "phase",
        "Switch"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Switch", "Switch", "1", "0..*")
    )
    val open: Fielder = parse_element (element (cls, fields(0)))
    val phase: Fielder = parse_attribute (attribute (cls, fields(1)))
    val Switch: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): SvSwitch =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SvSwitch (
            StateVariable.parse (context),
            toBoolean (mask (open (), 0)),
            mask (phase (), 1),
            mask (Switch (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * State variable for transformer tap step.
 *
 * @param sup [[ch.ninecode.model.StateVariable StateVariable]] Reference to the superclass object.
 * @param position The floating point tap position.
 *        This is not the tap ratio, but rather the tap step position as defined by the related tap changer model and normally is constrained to be within the range of minimum and maximum tap positions.
 * @param TapChanger [[ch.ninecode.model.TapChanger TapChanger]] The tap changer associated with the tap step state.
 * @group StateVariables
 * @groupname StateVariables Package StateVariables
 * @groupdesc StateVariables State variables for analysis solutions such as powerflow.
 */
final case class SvTapStep
(
    override val sup: StateVariable = null,
    position: Double = 0.0,
    TapChanger: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def StateVariable: StateVariable = sup
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
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
    override val fields: Array[String] = Array[String] (
        "position",
        "TapChanger"
    )
    override val relations: List[Relationship] = List (
        Relationship ("TapChanger", "TapChanger", "1", "0..1")
    )
    val position: Fielder = parse_element (element (cls, fields(0)))
    val TapChanger: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): SvTapStep =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SvTapStep (
            StateVariable.parse (context),
            toDouble (mask (position (), 0)),
            mask (TapChanger (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * State variable for voltage.
 *
 * @param sup [[ch.ninecode.model.StateVariable StateVariable]] Reference to the superclass object.
 * @param angle The voltage angle of the topological node complex voltage with respect to system reference.
 * @param phase If specified the voltage is the line to ground voltage of the individual phase.
 *        If unspecified, then the voltage is assumed balanced.
 * @param v The voltage magnitude at the topological node.
 * @param TopologicalNode [[ch.ninecode.model.TopologicalNode TopologicalNode]] The topological node associated with the voltage state.
 * @group StateVariables
 * @groupname StateVariables Package StateVariables
 * @groupdesc StateVariables State variables for analysis solutions such as powerflow.
 */
final case class SvVoltage
(
    override val sup: StateVariable = null,
    angle: Double = 0.0,
    phase: String = null,
    v: Double = 0.0,
    TopologicalNode: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def StateVariable: StateVariable = sup
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = SvVoltage.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SvVoltage.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SvVoltage.fields (position), value)
        emitelem (0, angle)
        emitattr (1, phase)
        emitelem (2, v)
        emitattr (3, TopologicalNode)
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
    override val fields: Array[String] = Array[String] (
        "angle",
        "phase",
        "v",
        "TopologicalNode"
    )
    override val relations: List[Relationship] = List (
        Relationship ("TopologicalNode", "TopologicalNode", "1", "0..*")
    )
    val angle: Fielder = parse_element (element (cls, fields(0)))
    val phase: Fielder = parse_attribute (attribute (cls, fields(1)))
    val v: Fielder = parse_element (element (cls, fields(2)))
    val TopologicalNode: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): SvVoltage =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SvVoltage (
            StateVariable.parse (context),
            toDouble (mask (angle (), 0)),
            mask (phase (), 1),
            toDouble (mask (v (), 2)),
            mask (TopologicalNode (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
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
            SvSwitch.register,
            SvTapStep.register,
            SvVoltage.register
        )
    }
}