package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Abstract parent class for all Dynamics function blocks.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param enabled Function block used indicator.
 *        true = use of function block is enabled
 *        false = use of function block is disabled.
 * @group StandardModels
 * @groupname StandardModels Package StandardModels
 * @groupdesc StandardModels This subclause contains standard dynamic model specifications grouped into packages by standard function block (type of equipment being modelled).
In the CIM, standard dynamic models are expressed by means of a class named with the standard model name and attributes reflecting each of the parameters necessary to describe the behaviour of an instance of the standard model.
 */
final case class DynamicsFunctionBlock
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
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = DynamicsFunctionBlock.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DynamicsFunctionBlock.fields (position), value)
        emitelem (0, enabled)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DynamicsFunctionBlock rdf:ID=\"%s\">\n%s\t</cim:DynamicsFunctionBlock>".format (id, export_fields)
    }
}

object DynamicsFunctionBlock
extends
    Parseable[DynamicsFunctionBlock]
{
    override val fields: Array[String] = Array[String] (
        "enabled"
    )
    val enabled: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): DynamicsFunctionBlock =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DynamicsFunctionBlock (
            IdentifiedObject.parse (context),
            toBoolean (mask (enabled (), 0))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Abstract parent class for all synchronous and asynchronous machine standard models.
 *
 * @param sup [[ch.ninecode.model.DynamicsFunctionBlock DynamicsFunctionBlock]] Reference to the superclass object.
 * @param damping Damping torque coefficient (<i>D</i>) (&gt;= 0).
 *        A proportionality constant that, when multiplied by the angular velocity of the rotor poles with respect to the magnetic field (frequency), results in the damping torque.  This value is often zero when the sources of damping torques (generator damper windings, load damping effects, etc.) are modelled in detail.  Typical value = 0.
 * @param inertia Inertia constant of generator or motor and mechanical load (<i>H</i>) (&gt; 0).
 *        This is the specification for the stored energy in the rotating mass when operating at rated speed.  For a generator, this includes the generator plus all other elements (turbine, exciter) on the same shaft and has units of MW x s.  For a motor, it includes the motor plus its mechanical load. Conventional units are PU on the generator MVA base, usually expressed as MW x s / MVA or just s. This value is used in the accelerating power reference frame for operator training simulator solutions.  Typical value = 3.
 * @param saturationFactor Saturation factor at rated terminal voltage (<i>S1</i>) (&gt;= 0).
 *        Not used by simplified model.  Defined by defined by <i>S</i>(<i>E1</i>) in the SynchronousMachineSaturationParameters diagram.  Typical value = 0,02.
 * @param saturationFactor120 Saturation factor at 120% of rated terminal voltage (<i>S12</i>) (&gt;= RotatingMachineDynamics.saturationFactor).
 *        Not used by the simplified model, defined by <i>S</i>(<i>E2</i>) in the SynchronousMachineSaturationParameters diagram.  Typical value = 0,12.
 * @param statorLeakageReactance Stator leakage reactance (<i>Xl</i>) (&gt;= 0).
 *        Typical value = 0,15.
 * @param statorResistance Stator (armature) resistance (<i>Rs</i>) (&gt;= 0).
 *        Typical value = 0,005.
 * @group StandardModels
 * @groupname StandardModels Package StandardModels
 * @groupdesc StandardModels This subclause contains standard dynamic model specifications grouped into packages by standard function block (type of equipment being modelled).
In the CIM, standard dynamic models are expressed by means of a class named with the standard model name and attributes reflecting each of the parameters necessary to describe the behaviour of an instance of the standard model.
 */
final case class RotatingMachineDynamics
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
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = RotatingMachineDynamics.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (RotatingMachineDynamics.fields (position), value)
        emitelem (0, damping)
        emitelem (1, inertia)
        emitelem (2, saturationFactor)
        emitelem (3, saturationFactor120)
        emitelem (4, statorLeakageReactance)
        emitelem (5, statorResistance)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RotatingMachineDynamics rdf:ID=\"%s\">\n%s\t</cim:RotatingMachineDynamics>".format (id, export_fields)
    }
}

object RotatingMachineDynamics
extends
    Parseable[RotatingMachineDynamics]
{
    override val fields: Array[String] = Array[String] (
        "damping",
        "inertia",
        "saturationFactor",
        "saturationFactor120",
        "statorLeakageReactance",
        "statorResistance"
    )
    val damping: Fielder = parse_element (element (cls, fields(0)))
    val inertia: Fielder = parse_element (element (cls, fields(1)))
    val saturationFactor: Fielder = parse_element (element (cls, fields(2)))
    val saturationFactor120: Fielder = parse_element (element (cls, fields(3)))
    val statorLeakageReactance: Fielder = parse_element (element (cls, fields(4)))
    val statorResistance: Fielder = parse_element (element (cls, fields(5)))

    def parse (context: Context): RotatingMachineDynamics =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = RotatingMachineDynamics (
            DynamicsFunctionBlock.parse (context),
            toDouble (mask (damping (), 0)),
            toDouble (mask (inertia (), 1)),
            toDouble (mask (saturationFactor (), 2)),
            toDouble (mask (saturationFactor120 (), 3)),
            toDouble (mask (statorLeakageReactance (), 4)),
            toDouble (mask (statorResistance (), 5))
        )
        ret.bitfields = bitfields
        ret
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