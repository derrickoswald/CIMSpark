package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * This section contains standard dynamic model specifications grouped into packages by standard function block (type of equipment being modelled).
 * In the CIM, standard dynamic models are expressed by means of a class named with the standard model name and attributes reflecting each of the parameters necessary to describe the behaviour of an instance of the standard model.
 */

/**
 * Abstract parent class for all Dynamics function blocks.
 * @param sup Reference to the superclass object.
 * @param enabled Function block used indicator.
true = use of function block is enabled
 *        false = use of function block is disabled.
 */
case class DynamicsFunctionBlock
(
    override val sup: Element,
    val enabled: Boolean
)
extends
    Element
{
    def this () = { this (null, false) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[DynamicsFunctionBlock]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DynamicsFunctionBlock
extends
    Parseable[DynamicsFunctionBlock]
{
    val sup = IdentifiedObject.parse _
    val enabled = parse_element (element ("""DynamicsFunctionBlock.enabled"""))_
    def parse (context: Context): DynamicsFunctionBlock =
    {
        DynamicsFunctionBlock(
            sup (context),
            toBoolean (enabled (context), context)
        )
    }
}

/**
 * Abstract parent class for all synchronous and asynchronous machine standard models.
 * @param sup Reference to the superclass object.
 * @param damping Damping torque coefficient (D).
 *        A proportionality constant that, when multiplied by the angular velocity of the rotor poles with respect to the magnetic field (frequency), results in the damping torque.  This value is often zero when the sources of damping torques (generator damper windings, load damping effects, etc.) are modelled in detail.  Typical Value = 0.
 * @param inertia Inertia constant of generator or motor and mechanical load (H) (&gt;0).
 *        This is the specification for the stored energy in the rotating mass when operating at rated speed.  For a generator, this includes the generator plus all other elements (turbine, exciter) on the same shaft and has units of MW*sec.  For a motor, it includes the motor plus its mechanical load. Conventional units are per unit on the generator MVA base, usually expressed as MW*second/MVA or just second.   This value is used in the accelerating power reference frame for operator training simulator solutions.  Typical Value = 3.
 * @param saturationFactor Saturation factor at rated terminal voltage (S1) (&gt; or =0).
 *        Not used by simplified model.  Defined by defined by S(E1) in the SynchronousMachineSaturationParameters diagram.  Typical Value = 0.02.
 * @param saturationFactor120 Saturation factor at 120% of rated terminal voltage (S12) (&gt; or =S1).
 *        Not used by the simplified model, defined by S(E2) in the SynchronousMachineSaturationParameters diagram.  Typical Value = 0.12.
 * @param statorLeakageReactance Stator leakage reactance (Xl) (&gt; or =0).
 *        Typical Value = 0.15.
 * @param statorResistance Stator (armature) resistance (Rs) (&gt; or =0).
 *        Typical Value = 0.005.
 */
case class RotatingMachineDynamics
(
    override val sup: Element,
    val damping: Double,
    val inertia: Double,
    val saturationFactor: Double,
    val saturationFactor120: Double,
    val statorLeakageReactance: Double,
    val statorResistance: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def DynamicsFunctionBlock: DynamicsFunctionBlock = sup.asInstanceOf[DynamicsFunctionBlock]
    override def copy (): Row = { return (clone ().asInstanceOf[RotatingMachineDynamics]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RotatingMachineDynamics
extends
    Parseable[RotatingMachineDynamics]
{
    val sup = DynamicsFunctionBlock.parse _
    val damping = parse_element (element ("""RotatingMachineDynamics.damping"""))_
    val inertia = parse_element (element ("""RotatingMachineDynamics.inertia"""))_
    val saturationFactor = parse_element (element ("""RotatingMachineDynamics.saturationFactor"""))_
    val saturationFactor120 = parse_element (element ("""RotatingMachineDynamics.saturationFactor120"""))_
    val statorLeakageReactance = parse_element (element ("""RotatingMachineDynamics.statorLeakageReactance"""))_
    val statorResistance = parse_element (element ("""RotatingMachineDynamics.statorResistance"""))_
    def parse (context: Context): RotatingMachineDynamics =
    {
        RotatingMachineDynamics(
            sup (context),
            toDouble (damping (context), context),
            toDouble (inertia (context), context),
            toDouble (saturationFactor (context), context),
            toDouble (saturationFactor120 (context), context),
            toDouble (statorLeakageReactance (context), context),
            toDouble (statorResistance (context), context)
        )
    }
}

object _StandardModels
{
    def register: Unit =
    {
        DynamicsFunctionBlock.register
        RotatingMachineDynamics.register
    }
}