package ch.ninecode.model

import com.esotericsoftware.kryo.Kryo
import com.esotericsoftware.kryo.Serializer
import com.esotericsoftware.kryo.io.Input
import com.esotericsoftware.kryo.io.Output
import org.apache.spark.sql.Row

import ch.ninecode.cim.CIMClassInfo
import ch.ninecode.cim.CIMContext
import ch.ninecode.cim.CIMParseable
import ch.ninecode.cim.CIMRelationship
import ch.ninecode.cim.CIMSerializer

/**
 * Mechanical load model type 1.
 *
 * @param MechanicalLoadDynamics [[ch.ninecode.model.MechanicalLoadDynamics MechanicalLoadDynamics]] Reference to the superclass object.
 * @param a Speed squared coefficient (<i>a</i>).
 * @param b Speed coefficient (<i>b</i>).
 * @param d Speed to the exponent coefficient (<i>d</i>).
 * @param e Exponent (<i>e</i>).
 * @group MechanicalLoadDynamics
 * @groupname MechanicalLoadDynamics Package MechanicalLoadDynamics
 * @groupdesc MechanicalLoadDynamics A mechanical load represents the variation in a motor's shaft torque or power as a function of shaft speed.
 */
final case class MechLoad1
(
    MechanicalLoadDynamics: MechanicalLoadDynamics = null,
    a: Double = 0.0,
    b: Double = 0.0,
    d: Double = 0.0,
    e: Double = 0.0
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
    override def sup: MechanicalLoadDynamics = MechanicalLoadDynamics

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
        implicit val clz: String = MechLoad1.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MechLoad1.fields (position), value)
        emitelem (0, a)
        emitelem (1, b)
        emitelem (2, d)
        emitelem (3, e)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MechLoad1 rdf:ID=\"%s\">\n%s\t</cim:MechLoad1>".format (id, export_fields)
    }
}

object MechLoad1
extends
    CIMParseable[MechLoad1]
{
    override val fields: Array[String] = Array[String] (
        "a",
        "b",
        "d",
        "e"
    )
    val a: Fielder = parse_element (element (cls, fields(0)))
    val b: Fielder = parse_element (element (cls, fields(1)))
    val d: Fielder = parse_element (element (cls, fields(2)))
    val e: Fielder = parse_element (element (cls, fields(3)))

    def parse (context: CIMContext): MechLoad1 =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MechLoad1 (
            MechanicalLoadDynamics.parse (context),
            toDouble (mask (a (), 0)),
            toDouble (mask (b (), 1)),
            toDouble (mask (d (), 2)),
            toDouble (mask (e (), 3))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[MechLoad1] = MechLoad1Serializer
}

object MechLoad1Serializer extends CIMSerializer[MechLoad1]
{
    def write (kryo: Kryo, output: Output, obj: MechLoad1): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.a),
            () => output.writeDouble (obj.b),
            () => output.writeDouble (obj.d),
            () => output.writeDouble (obj.e)
        )
        MechanicalLoadDynamicsSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MechLoad1]): MechLoad1 =
    {
        val parent = MechanicalLoadDynamicsSerializer.read (kryo, input, classOf[MechanicalLoadDynamics])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = MechLoad1 (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Mechanical load function block whose behaviour is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model.</font>
 *
 * @param DynamicsFunctionBlock [[ch.ninecode.model.DynamicsFunctionBlock DynamicsFunctionBlock]] Reference to the superclass object.
 * @param AsynchronousMachineDynamics [[ch.ninecode.model.AsynchronousMachineDynamics AsynchronousMachineDynamics]] Asynchronous machine model with which this mechanical load model is associated.
 *        MechanicalLoadDynamics shall have either an association to SynchronousMachineDynamics or to AsynchronousMachineDynamics.
 * @param SynchronousMachineDynamics [[ch.ninecode.model.SynchronousMachineDynamics SynchronousMachineDynamics]] Synchronous machine model with which this mechanical load model is associated.
 *        MechanicalLoadDynamics shall have either an association to SynchronousMachineDynamics or AsynchronousMachineDyanmics.
 * @group MechanicalLoadDynamics
 * @groupname MechanicalLoadDynamics Package MechanicalLoadDynamics
 * @groupdesc MechanicalLoadDynamics A mechanical load represents the variation in a motor's shaft torque or power as a function of shaft speed.
 */
final case class MechanicalLoadDynamics
(
    DynamicsFunctionBlock: DynamicsFunctionBlock = null,
    AsynchronousMachineDynamics: String = null,
    SynchronousMachineDynamics: String = null
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
    override def sup: DynamicsFunctionBlock = DynamicsFunctionBlock

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
        implicit val clz: String = MechanicalLoadDynamics.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MechanicalLoadDynamics.fields (position), value)
        emitattr (0, AsynchronousMachineDynamics)
        emitattr (1, SynchronousMachineDynamics)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MechanicalLoadDynamics rdf:ID=\"%s\">\n%s\t</cim:MechanicalLoadDynamics>".format (id, export_fields)
    }
}

object MechanicalLoadDynamics
extends
    CIMParseable[MechanicalLoadDynamics]
{
    override val fields: Array[String] = Array[String] (
        "AsynchronousMachineDynamics",
        "SynchronousMachineDynamics"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AsynchronousMachineDynamics", "AsynchronousMachineDynamics", "0..1", "0..1"),
        CIMRelationship ("SynchronousMachineDynamics", "SynchronousMachineDynamics", "0..1", "0..1")
    )
    val AsynchronousMachineDynamics: Fielder = parse_attribute (attribute (cls, fields(0)))
    val SynchronousMachineDynamics: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): MechanicalLoadDynamics =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MechanicalLoadDynamics (
            DynamicsFunctionBlock.parse (context),
            mask (AsynchronousMachineDynamics (), 0),
            mask (SynchronousMachineDynamics (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[MechanicalLoadDynamics] = MechanicalLoadDynamicsSerializer
}

object MechanicalLoadDynamicsSerializer extends CIMSerializer[MechanicalLoadDynamics]
{
    def write (kryo: Kryo, output: Output, obj: MechanicalLoadDynamics): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.AsynchronousMachineDynamics),
            () => output.writeString (obj.SynchronousMachineDynamics)
        )
        DynamicsFunctionBlockSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MechanicalLoadDynamics]): MechanicalLoadDynamics =
    {
        val parent = DynamicsFunctionBlockSerializer.read (kryo, input, classOf[DynamicsFunctionBlock])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = MechanicalLoadDynamics (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _MechanicalLoadDynamics
{
    def register: List[CIMClassInfo] =
    {
        List (
            MechLoad1.register,
            MechanicalLoadDynamics.register
        )
    }
}