package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * A mechanical load represents the variation in a motor's shaft torque or power as a function of shaft speed.
 */

/**
 * Mechanical load model type 1.
 */
case class MechLoad1
(

    override val sup: MechanicalLoadDynamics,

    /**
     * Speed squared coefficient (a).
     */
    val a: Double,

    /**
     * Speed coefficient (b).
     */
    val b: Double,

    /**
     * Speed to the exponent coefficient (d).
     */
    val d: Double,

    /**
     * Exponent (e).
     */
    val e: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0) }
    def MechanicalLoadDynamics: MechanicalLoadDynamics = sup.asInstanceOf[MechanicalLoadDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[MechLoad1]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MechLoad1
extends
    Parseable[MechLoad1]
{
    val sup = MechanicalLoadDynamics.parse _
    val a = parse_element (element ("""MechLoad1.a"""))_
    val b = parse_element (element ("""MechLoad1.b"""))_
    val d = parse_element (element ("""MechLoad1.d"""))_
    val e = parse_element (element ("""MechLoad1.e"""))_
    def parse (context: Context): MechLoad1 =
    {
        MechLoad1(
            sup (context),
            toDouble (a (context), context),
            toDouble (b (context), context),
            toDouble (d (context), context),
            toDouble (e (context), context)
        )
    }
}

/**
 * Mechanical load function block whose behavior is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model.</font>
 */
case class MechanicalLoadDynamics
(

    override val sup: DynamicsFunctionBlock,

    /**
     * Asynchronous machine model with which this mechanical load model is associated.
     */
    val AsynchronousMachineDynamics: String,

    /**
     * Synchronous machine model with which this mechanical load model is associated.
     */
    val SynchronousMachineDynamics: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def DynamicsFunctionBlock: DynamicsFunctionBlock = sup.asInstanceOf[DynamicsFunctionBlock]
    override def copy (): Row = { return (clone ().asInstanceOf[MechanicalLoadDynamics]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MechanicalLoadDynamics
extends
    Parseable[MechanicalLoadDynamics]
{
    val sup = DynamicsFunctionBlock.parse _
    val AsynchronousMachineDynamics = parse_attribute (attribute ("""MechanicalLoadDynamics.AsynchronousMachineDynamics"""))_
    val SynchronousMachineDynamics = parse_attribute (attribute ("""MechanicalLoadDynamics.SynchronousMachineDynamics"""))_
    def parse (context: Context): MechanicalLoadDynamics =
    {
        MechanicalLoadDynamics(
            sup (context),
            AsynchronousMachineDynamics (context),
            SynchronousMachineDynamics (context)
        )
    }
}

object _MechanicalLoadDynamics
{
    def register: Unit =
    {
        MechLoad1.register
        MechanicalLoadDynamics.register
    }
}