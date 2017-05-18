package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * State variables for analysis solutions such as powerflow.
 */

/**
 * An abstract class for state variables.
 * @param sup Reference to the superclass object.
 */
case class StateVariable
(
    override val sup: Element
)
extends
    Element
{
    def this () = { this (null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[StateVariable]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object StateVariable
extends
    Parseable[StateVariable]
{
    val sup = BasicElement.parse _
    def parse (context: Context): StateVariable =
    {
        StateVariable(
            sup (context)
        )
    }
}

/**
 * The SvInjection is reporting the calculated bus injection minus the sum of the terminal flows.
 * The terminal flow is positive out from the bus (load sign convention) and bus injection has positive flow into the bus. SvInjection may have the remainder after state estimation or slack after power flow calculation.
 * @param sup Reference to the superclass object.
 * @param pInjection The active power injected into the bus in addition to injections from equipment terminals.
 *        Positive sign means injection into the TopologicalNode (bus).
 * @param qInjection The reactive power injected into the bus in addition to injections from equipment terminals.
 *        Positive sign means injection into the TopologicalNode (bus).
 * @param TopologicalNode The topological node associated with the flow injection state variable.
 */
case class SvInjection
(
    override val sup: Element,
    val pInjection: Double,
    val qInjection: Double,
    val TopologicalNode: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null) }
    def StateVariable: StateVariable = sup.asInstanceOf[StateVariable]
    override def copy (): Row = { return (clone ().asInstanceOf[SvInjection]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SvInjection
extends
    Parseable[SvInjection]
{
    val sup = StateVariable.parse _
    val pInjection = parse_element (element ("""SvInjection.pInjection"""))
    val qInjection = parse_element (element ("""SvInjection.qInjection"""))
    val TopologicalNode = parse_attribute (attribute ("""SvInjection.TopologicalNode"""))
    def parse (context: Context): SvInjection =
    {
        SvInjection(
            sup (context),
            toDouble (pInjection (context), context),
            toDouble (qInjection (context), context),
            TopologicalNode (context)
        )
    }
}

/**
 * State variable for power flow.
 * Load convention is used for flow direction. This means flow out from the TopologicalNode into the equipment is positive.
 * @param sup Reference to the superclass object.
 * @param p The active power flow.
 *        Load sign convention is used, i.e. positive sign means flow out from a TopologicalNode (bus) into the conducting equipment.
 * @param q The reactive power flow.
 *        Load sign convention is used, i.e. positive sign means flow out from a TopologicalNode (bus) into the conducting equipment.
 * @param Terminal The terminal associated with the power flow state variable.
 */
case class SvPowerFlow
(
    override val sup: Element,
    val p: Double,
    val q: Double,
    val Terminal: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null) }
    def StateVariable: StateVariable = sup.asInstanceOf[StateVariable]
    override def copy (): Row = { return (clone ().asInstanceOf[SvPowerFlow]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SvPowerFlow
extends
    Parseable[SvPowerFlow]
{
    val sup = StateVariable.parse _
    val p = parse_element (element ("""SvPowerFlow.p"""))
    val q = parse_element (element ("""SvPowerFlow.q"""))
    val Terminal = parse_attribute (attribute ("""SvPowerFlow.Terminal"""))
    def parse (context: Context): SvPowerFlow =
    {
        SvPowerFlow(
            sup (context),
            toDouble (p (context), context),
            toDouble (q (context), context),
            Terminal (context)
        )
    }
}

/**
 * State variable for the number of sections in service for a shunt compensator.
 * @param sup Reference to the superclass object.
 * @param sections The number of sections in service as a continous variable.
 *        To get integer value scale with ShuntCompensator.bPerSection.
 * @param ShuntCompensator The shunt compensator for which the state applies.
 */
case class SvShuntCompensatorSections
(
    override val sup: Element,
    val sections: Double,
    val ShuntCompensator: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null) }
    def StateVariable: StateVariable = sup.asInstanceOf[StateVariable]
    override def copy (): Row = { return (clone ().asInstanceOf[SvShuntCompensatorSections]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SvShuntCompensatorSections
extends
    Parseable[SvShuntCompensatorSections]
{
    val sup = StateVariable.parse _
    val sections = parse_element (element ("""SvShuntCompensatorSections.sections"""))
    val ShuntCompensator = parse_attribute (attribute ("""SvShuntCompensatorSections.ShuntCompensator"""))
    def parse (context: Context): SvShuntCompensatorSections =
    {
        SvShuntCompensatorSections(
            sup (context),
            toDouble (sections (context), context),
            ShuntCompensator (context)
        )
    }
}

/**
 * State variable for status.
 * @param sup Reference to the superclass object.
 * @param inService The in service status as a result of topology processing.
 * @param ConductingEquipment The conducting equipment associated with the status state variable.
 */
case class SvStatus
(
    override val sup: Element,
    val inService: Boolean,
    val ConductingEquipment: String
)
extends
    Element
{
    def this () = { this (null, false, null) }
    def StateVariable: StateVariable = sup.asInstanceOf[StateVariable]
    override def copy (): Row = { return (clone ().asInstanceOf[SvStatus]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SvStatus
extends
    Parseable[SvStatus]
{
    val sup = StateVariable.parse _
    val inService = parse_element (element ("""SvStatus.inService"""))
    val ConductingEquipment = parse_attribute (attribute ("""SvStatus.ConductingEquipment"""))
    def parse (context: Context): SvStatus =
    {
        SvStatus(
            sup (context),
            toBoolean (inService (context), context),
            ConductingEquipment (context)
        )
    }
}

/**
 * State variable for transformer tap step.
 * This class is to be used for taps of LTC (load tap changing) transformers, not fixed tap transformers.
 * @param sup Reference to the superclass object.
 * @param position The floating point tap position.
 *        This is not the tap ratio, but rather the tap step position as defined by the related tap changer model and normally is constrained to be within the range of minimum and maximum tap positions.
 * @param TapChanger The tap changer associated with the tap step state.
 */
case class SvTapStep
(
    override val sup: Element,
    val position: Double,
    val TapChanger: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null) }
    def StateVariable: StateVariable = sup.asInstanceOf[StateVariable]
    override def copy (): Row = { return (clone ().asInstanceOf[SvTapStep]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SvTapStep
extends
    Parseable[SvTapStep]
{
    val sup = StateVariable.parse _
    val position = parse_element (element ("""SvTapStep.position"""))
    val TapChanger = parse_attribute (attribute ("""SvTapStep.TapChanger"""))
    def parse (context: Context): SvTapStep =
    {
        SvTapStep(
            sup (context),
            toDouble (position (context), context),
            TapChanger (context)
        )
    }
}

/**
 * State variable for voltage.
 * @param sup Reference to the superclass object.
 * @param angle The voltage angle of the topological node complex voltage with respect to system reference.
 * @param v The voltage magnitude of the topological node.
 * @param TopologicalNode The topological node associated with the voltage state.
 */
case class SvVoltage
(
    override val sup: Element,
    val angle: Double,
    val v: Double,
    val TopologicalNode: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null) }
    def StateVariable: StateVariable = sup.asInstanceOf[StateVariable]
    override def copy (): Row = { return (clone ().asInstanceOf[SvVoltage]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SvVoltage
extends
    Parseable[SvVoltage]
{
    val sup = StateVariable.parse _
    val angle = parse_element (element ("""SvVoltage.angle"""))
    val v = parse_element (element ("""SvVoltage.v"""))
    val TopologicalNode = parse_attribute (attribute ("""SvVoltage.TopologicalNode"""))
    def parse (context: Context): SvVoltage =
    {
        SvVoltage(
            sup (context),
            toDouble (angle (context), context),
            toDouble (v (context), context),
            TopologicalNode (context)
        )
    }
}

object _StateVariables
{
    def register: Unit =
    {
        StateVariable.register
        SvInjection.register
        SvPowerFlow.register
        SvShuntCompensatorSections.register
        SvStatus.register
        SvTapStep.register
        SvVoltage.register
    }
}