package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:StateVariable rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:StateVariable>"
    }
}

object StateVariable
extends
    Parseable[StateVariable]
{
    def parse (context: Context): StateVariable =
    {
        StateVariable(
            BasicElement.parse (context)
        )
    }
}

/**
 * The SvInjection is reporting the calculated bus injection minus the sum of the terminal flows.
 *
 * The terminal flow is positive out from the bus (load sign convention) and bus injection has positive flow into the bus. SvInjection may have the remainder after state estimation or slack after power flow calculation.
 *
 * @param sup Reference to the superclass object.
 * @param pInjection The active power injected into the bus in addition to injections from equipment terminals.
 *        Positive sign means injection into the TopologicalNode (bus).
 * @param qInjection The reactive power injected into the bus in addition to injections from equipment terminals.
 *        Positive sign means injection into the TopologicalNode (bus).
 * @param TopologicalNode The topological node associated with the flow injection state variable.
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
        sup.export_fields +
        "\t\t<cim:SvInjection.pInjection>" + pInjection + "</cim:SvInjection.pInjection>\n" +
        "\t\t<cim:SvInjection.qInjection>" + qInjection + "</cim:SvInjection.qInjection>\n" +
        (if (null != TopologicalNode) "\t\t<cim:SvInjection.TopologicalNode rdf:resource=\"#" + TopologicalNode + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SvInjection rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SvInjection>"
    }
}

object SvInjection
extends
    Parseable[SvInjection]
{
    val pInjection = parse_element (element ("""SvInjection.pInjection"""))
    val qInjection = parse_element (element ("""SvInjection.qInjection"""))
    val TopologicalNode = parse_attribute (attribute ("""SvInjection.TopologicalNode"""))
    def parse (context: Context): SvInjection =
    {
        SvInjection(
            StateVariable.parse (context),
            toDouble (pInjection (context), context),
            toDouble (qInjection (context), context),
            TopologicalNode (context)
        )
    }
}

/**
 * State variable for power flow.
 *
 * Load convention is used for flow direction. This means flow out from the TopologicalNode into the equipment is positive.
 *
 * @param sup Reference to the superclass object.
 * @param p The active power flow.
 *        Load sign convention is used, i.e. positive sign means flow out from a TopologicalNode (bus) into the conducting equipment.
 * @param q The reactive power flow.
 *        Load sign convention is used, i.e. positive sign means flow out from a TopologicalNode (bus) into the conducting equipment.
 * @param Terminal The terminal associated with the power flow state variable.
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
        sup.export_fields +
        "\t\t<cim:SvPowerFlow.p>" + p + "</cim:SvPowerFlow.p>\n" +
        "\t\t<cim:SvPowerFlow.q>" + q + "</cim:SvPowerFlow.q>\n" +
        (if (null != Terminal) "\t\t<cim:SvPowerFlow.Terminal rdf:resource=\"#" + Terminal + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SvPowerFlow rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SvPowerFlow>"
    }
}

object SvPowerFlow
extends
    Parseable[SvPowerFlow]
{
    val p = parse_element (element ("""SvPowerFlow.p"""))
    val q = parse_element (element ("""SvPowerFlow.q"""))
    val Terminal = parse_attribute (attribute ("""SvPowerFlow.Terminal"""))
    def parse (context: Context): SvPowerFlow =
    {
        SvPowerFlow(
            StateVariable.parse (context),
            toDouble (p (context), context),
            toDouble (q (context), context),
            Terminal (context)
        )
    }
}

/**
 * State variable for the number of sections in service for a shunt compensator.
 *
 * @param sup Reference to the superclass object.
 * @param sections The number of sections in service as a continous variable.
 *        To get integer value scale with ShuntCompensator.bPerSection.
 * @param ShuntCompensator The shunt compensator for which the state applies.
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
        sup.export_fields +
        "\t\t<cim:SvShuntCompensatorSections.sections>" + sections + "</cim:SvShuntCompensatorSections.sections>\n" +
        (if (null != ShuntCompensator) "\t\t<cim:SvShuntCompensatorSections.ShuntCompensator rdf:resource=\"#" + ShuntCompensator + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SvShuntCompensatorSections rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SvShuntCompensatorSections>"
    }
}

object SvShuntCompensatorSections
extends
    Parseable[SvShuntCompensatorSections]
{
    val sections = parse_element (element ("""SvShuntCompensatorSections.sections"""))
    val ShuntCompensator = parse_attribute (attribute ("""SvShuntCompensatorSections.ShuntCompensator"""))
    def parse (context: Context): SvShuntCompensatorSections =
    {
        SvShuntCompensatorSections(
            StateVariable.parse (context),
            toDouble (sections (context), context),
            ShuntCompensator (context)
        )
    }
}

/**
 * State variable for status.
 *
 * @param sup Reference to the superclass object.
 * @param inService The in service status as a result of topology processing.
 * @param ConductingEquipment The conducting equipment associated with the status state variable.
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
        sup.export_fields +
        "\t\t<cim:SvStatus.inService>" + inService + "</cim:SvStatus.inService>\n" +
        (if (null != ConductingEquipment) "\t\t<cim:SvStatus.ConductingEquipment rdf:resource=\"#" + ConductingEquipment + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SvStatus rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SvStatus>"
    }
}

object SvStatus
extends
    Parseable[SvStatus]
{
    val inService = parse_element (element ("""SvStatus.inService"""))
    val ConductingEquipment = parse_attribute (attribute ("""SvStatus.ConductingEquipment"""))
    def parse (context: Context): SvStatus =
    {
        SvStatus(
            StateVariable.parse (context),
            toBoolean (inService (context), context),
            ConductingEquipment (context)
        )
    }
}

/**
 * State variable for transformer tap step.
 *
 * This class is to be used for taps of LTC (load tap changing) transformers, not fixed tap transformers.
 *
 * @param sup Reference to the superclass object.
 * @param position The floating point tap position.
 *        This is not the tap ratio, but rather the tap step position as defined by the related tap changer model and normally is constrained to be within the range of minimum and maximum tap positions.
 * @param TapChanger The tap changer associated with the tap step state.
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
        sup.export_fields +
        "\t\t<cim:SvTapStep.position>" + position + "</cim:SvTapStep.position>\n" +
        (if (null != TapChanger) "\t\t<cim:SvTapStep.TapChanger rdf:resource=\"#" + TapChanger + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SvTapStep rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SvTapStep>"
    }
}

object SvTapStep
extends
    Parseable[SvTapStep]
{
    val position = parse_element (element ("""SvTapStep.position"""))
    val TapChanger = parse_attribute (attribute ("""SvTapStep.TapChanger"""))
    def parse (context: Context): SvTapStep =
    {
        SvTapStep(
            StateVariable.parse (context),
            toDouble (position (context), context),
            TapChanger (context)
        )
    }
}

/**
 * State variable for voltage.
 *
 * @param sup Reference to the superclass object.
 * @param angle The voltage angle of the topological node complex voltage with respect to system reference.
 * @param v The voltage magnitude of the topological node.
 * @param TopologicalNode The topological node associated with the voltage state.
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
        sup.export_fields +
        "\t\t<cim:SvVoltage.angle>" + angle + "</cim:SvVoltage.angle>\n" +
        "\t\t<cim:SvVoltage.v>" + v + "</cim:SvVoltage.v>\n" +
        (if (null != TopologicalNode) "\t\t<cim:SvVoltage.TopologicalNode rdf:resource=\"#" + TopologicalNode + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SvVoltage rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SvVoltage>"
    }
}

object SvVoltage
extends
    Parseable[SvVoltage]
{
    val angle = parse_element (element ("""SvVoltage.angle"""))
    val v = parse_element (element ("""SvVoltage.v"""))
    val TopologicalNode = parse_attribute (attribute ("""SvVoltage.TopologicalNode"""))
    def parse (context: Context): SvVoltage =
    {
        SvVoltage(
            StateVariable.parse (context),
            toDouble (angle (context), context),
            toDouble (v (context), context),
            TopologicalNode (context)
        )
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
            SvTapStep.register,
            SvVoltage.register
        )
    }
}