package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * A mechanical load represents the variation in a motor's shaft torque or power as a function of shaft speed.
 */

/**
 * Mechanical load model type 1.
 * @param sup Reference to the superclass object.
 * @param a Speed squared coefficient (a).
 * @param b Speed coefficient (b).
 * @param d Speed to the exponent coefficient (d).
 * @param e Exponent (e).
 */
case class MechLoad1
(
    override val sup: MechanicalLoadDynamics,
    a: Double,
    b: Double,
    d: Double,
    e: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0) }
    def MechanicalLoadDynamics: MechanicalLoadDynamics = sup.asInstanceOf[MechanicalLoadDynamics]
    override def copy (): Row = { clone ().asInstanceOf[MechLoad1] }
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
        "\t\t<cim:MechLoad1.a>" + a + "</cim:MechLoad1.a>\n" +
        "\t\t<cim:MechLoad1.b>" + b + "</cim:MechLoad1.b>\n" +
        "\t\t<cim:MechLoad1.d>" + d + "</cim:MechLoad1.d>\n" +
        "\t\t<cim:MechLoad1.e>" + e + "</cim:MechLoad1.e>\n"
    }
    override def export: String =
    {
        "\t<cim:MechLoad1 rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MechLoad1>"
    }
}

object MechLoad1
extends
    Parseable[MechLoad1]
{
    val a: (Context) => String = parse_element (element ("""MechLoad1.a"""))
    val b: (Context) => String = parse_element (element ("""MechLoad1.b"""))
    val d: (Context) => String = parse_element (element ("""MechLoad1.d"""))
    val e: (Context) => String = parse_element (element ("""MechLoad1.e"""))
    def parse (context: Context): MechLoad1 =
    {
        MechLoad1(
            MechanicalLoadDynamics.parse (context),
            toDouble (a (context), context),
            toDouble (b (context), context),
            toDouble (d (context), context),
            toDouble (e (context), context)
        )
    }
}

/**
 * Mechanical load function block whose behavior is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model.</font>
 * @param sup Reference to the superclass object.
 * @param AsynchronousMachineDynamics Asynchronous machine model with which this mechanical load model is associated.
 * @param SynchronousMachineDynamics Synchronous machine model with which this mechanical load model is associated.
 */
case class MechanicalLoadDynamics
(
    override val sup: DynamicsFunctionBlock,
    AsynchronousMachineDynamics: String,
    SynchronousMachineDynamics: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def DynamicsFunctionBlock: DynamicsFunctionBlock = sup.asInstanceOf[DynamicsFunctionBlock]
    override def copy (): Row = { clone ().asInstanceOf[MechanicalLoadDynamics] }
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
        (if (null != AsynchronousMachineDynamics) "\t\t<cim:MechanicalLoadDynamics.AsynchronousMachineDynamics rdf:resource=\"#" + AsynchronousMachineDynamics + "\"/>\n" else "") +
        (if (null != SynchronousMachineDynamics) "\t\t<cim:MechanicalLoadDynamics.SynchronousMachineDynamics rdf:resource=\"#" + SynchronousMachineDynamics + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MechanicalLoadDynamics rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MechanicalLoadDynamics>"
    }
}

object MechanicalLoadDynamics
extends
    Parseable[MechanicalLoadDynamics]
{
    val AsynchronousMachineDynamics: (Context) => String = parse_attribute (attribute ("""MechanicalLoadDynamics.AsynchronousMachineDynamics"""))
    val SynchronousMachineDynamics: (Context) => String = parse_attribute (attribute ("""MechanicalLoadDynamics.SynchronousMachineDynamics"""))
    def parse (context: Context): MechanicalLoadDynamics =
    {
        MechanicalLoadDynamics(
            DynamicsFunctionBlock.parse (context),
            AsynchronousMachineDynamics (context),
            SynchronousMachineDynamics (context)
        )
    }
}

private[ninecode] object _MechanicalLoadDynamics
{
    def register: List[ClassInfo] =
    {
        List (
            MechLoad1.register,
            MechanicalLoadDynamics.register
        )
    }
}