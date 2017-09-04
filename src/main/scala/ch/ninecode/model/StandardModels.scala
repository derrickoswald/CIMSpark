package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * Abstract parent class for all Dynamics function blocks.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param enabled Function block used indicator.
 *        true = use of function block is enabled
 *        false = use of function block is disabled.
 * @group StandardModels
 * @groupname StandardModels Package StandardModels
 * @groupdesc StandardModels This section contains standard dynamic model specifications grouped into packages by standard function block (type of equipment being modelled).
In the CIM, standard dynamic models are expressed by means of a class named with the standard model name and attributes reflecting each of the parameters necessary to describe the behaviour of an instance of the standard model.
 */
case class DynamicsFunctionBlock
(
    override val sup: IdentifiedObject,
    enabled: Boolean
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[DynamicsFunctionBlock] }
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
        "\t\t<cim:DynamicsFunctionBlock.enabled>" + enabled + "</cim:DynamicsFunctionBlock.enabled>\n"
    }
    override def export: String =
    {
        "\t<cim:DynamicsFunctionBlock rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DynamicsFunctionBlock>"
    }
}

object DynamicsFunctionBlock
extends
    Parseable[DynamicsFunctionBlock]
{
    val enabled = parse_element (element ("""DynamicsFunctionBlock.enabled"""))
    def parse (context: Context): DynamicsFunctionBlock =
    {
        DynamicsFunctionBlock(
            IdentifiedObject.parse (context),
            toBoolean (enabled (context), context)
        )
    }
}

/**
 * Abstract parent class for all synchronous and asynchronous machine standard models.
 *
 * @param sup [[ch.ninecode.model.DynamicsFunctionBlock DynamicsFunctionBlock]] Reference to the superclass object.
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
 * @group StandardModels
 * @groupname StandardModels Package StandardModels
 * @groupdesc StandardModels This section contains standard dynamic model specifications grouped into packages by standard function block (type of equipment being modelled).
In the CIM, standard dynamic models are expressed by means of a class named with the standard model name and attributes reflecting each of the parameters necessary to describe the behaviour of an instance of the standard model.
 */
case class RotatingMachineDynamics
(
    override val sup: DynamicsFunctionBlock,
    damping: Double,
    inertia: Double,
    saturationFactor: Double,
    saturationFactor120: Double,
    statorLeakageReactance: Double,
    statorResistance: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def DynamicsFunctionBlock: DynamicsFunctionBlock = sup.asInstanceOf[DynamicsFunctionBlock]
    override def copy (): Row = { clone ().asInstanceOf[RotatingMachineDynamics] }
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
        "\t\t<cim:RotatingMachineDynamics.damping>" + damping + "</cim:RotatingMachineDynamics.damping>\n" +
        "\t\t<cim:RotatingMachineDynamics.inertia>" + inertia + "</cim:RotatingMachineDynamics.inertia>\n" +
        "\t\t<cim:RotatingMachineDynamics.saturationFactor>" + saturationFactor + "</cim:RotatingMachineDynamics.saturationFactor>\n" +
        "\t\t<cim:RotatingMachineDynamics.saturationFactor120>" + saturationFactor120 + "</cim:RotatingMachineDynamics.saturationFactor120>\n" +
        "\t\t<cim:RotatingMachineDynamics.statorLeakageReactance>" + statorLeakageReactance + "</cim:RotatingMachineDynamics.statorLeakageReactance>\n" +
        "\t\t<cim:RotatingMachineDynamics.statorResistance>" + statorResistance + "</cim:RotatingMachineDynamics.statorResistance>\n"
    }
    override def export: String =
    {
        "\t<cim:RotatingMachineDynamics rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RotatingMachineDynamics>"
    }
}

object RotatingMachineDynamics
extends
    Parseable[RotatingMachineDynamics]
{
    val damping = parse_element (element ("""RotatingMachineDynamics.damping"""))
    val inertia = parse_element (element ("""RotatingMachineDynamics.inertia"""))
    val saturationFactor = parse_element (element ("""RotatingMachineDynamics.saturationFactor"""))
    val saturationFactor120 = parse_element (element ("""RotatingMachineDynamics.saturationFactor120"""))
    val statorLeakageReactance = parse_element (element ("""RotatingMachineDynamics.statorLeakageReactance"""))
    val statorResistance = parse_element (element ("""RotatingMachineDynamics.statorResistance"""))
    def parse (context: Context): RotatingMachineDynamics =
    {
        RotatingMachineDynamics(
            DynamicsFunctionBlock.parse (context),
            toDouble (damping (context), context),
            toDouble (inertia (context), context),
            toDouble (saturationFactor (context), context),
            toDouble (saturationFactor120 (context), context),
            toDouble (statorLeakageReactance (context), context),
            toDouble (statorResistance (context), context)
        )
    }
}

private[ninecode] object _StandardModels
{
    def register: List[ClassInfo] =
    {
        List (
            DynamicsFunctionBlock.register,
            RotatingMachineDynamics.register
        )
    }
}