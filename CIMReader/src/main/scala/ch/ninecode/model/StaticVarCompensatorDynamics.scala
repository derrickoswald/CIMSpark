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
 * Static var compensator whose behaviour is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model.</font>
 *
 * @param DynamicsFunctionBlock [[ch.ninecode.model.DynamicsFunctionBlock DynamicsFunctionBlock]] Reference to the superclass object.
 * @param StaticVarCompensator  [[ch.ninecode.model.StaticVarCompensator StaticVarCompensator]] Static Var Compensator to which Static Var Compensator dynamics model applies.
 * @group StaticVarCompensatorDynamics
 * @groupname StaticVarCompensatorDynamics Package StaticVarCompensatorDynamics
 * @groupdesc StaticVarCompensatorDynamics Static var compensator (SVC) models.
 */
final case class StaticVarCompensatorDynamics
(
    DynamicsFunctionBlock: DynamicsFunctionBlock = null,
    StaticVarCompensator: String = null
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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = StaticVarCompensatorDynamics.cls

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (StaticVarCompensatorDynamics.fields (position), value)

        emitattr (0, StaticVarCompensator)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:StaticVarCompensatorDynamics rdf:ID=\"%s\">\n%s\t</cim:StaticVarCompensatorDynamics>".format (id, export_fields)
    }
}

object StaticVarCompensatorDynamics
    extends
        CIMParseable[StaticVarCompensatorDynamics]
{
    override val fields: Array[String] = Array [String](
        "StaticVarCompensator"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("StaticVarCompensator", "StaticVarCompensator", "1", "0..1")
    )
    val StaticVarCompensator: Fielder = parse_attribute (attribute (cls, fields (0)))

    def parse (context: CIMContext): StaticVarCompensatorDynamics =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = StaticVarCompensatorDynamics (
            DynamicsFunctionBlock.parse (context),
            mask (StaticVarCompensator (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[StaticVarCompensatorDynamics] = StaticVarCompensatorDynamicsSerializer
}

object StaticVarCompensatorDynamicsSerializer extends CIMSerializer[StaticVarCompensatorDynamics]
{
    def write (kryo: Kryo, output: Output, obj: StaticVarCompensatorDynamics): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.StaticVarCompensator)
        )
        DynamicsFunctionBlockSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[StaticVarCompensatorDynamics]): StaticVarCompensatorDynamics =
    {
        val parent = DynamicsFunctionBlockSerializer.read (kryo, input, classOf [DynamicsFunctionBlock])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = StaticVarCompensatorDynamics (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _StaticVarCompensatorDynamics
{
    def register: List[CIMClassInfo] =
    {
        List (
            StaticVarCompensatorDynamics.register
        )
    }
}