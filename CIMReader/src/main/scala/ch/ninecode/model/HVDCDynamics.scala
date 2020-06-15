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
 * CSC function block whose behaviour is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model.</font>
 *
 * @param HVDCDynamics [[ch.ninecode.model.HVDCDynamics HVDCDynamics]] Reference to the superclass object.
 * @param CSConverter [[ch.ninecode.model.CsConverter CsConverter]] Current source converter to which current source converter dynamics model applies.
 * @group HVDCDynamics
 * @groupname HVDCDynamics Package HVDCDynamics
 * @groupdesc HVDCDynamics High voltage direct current (HVDC) models.
 */
final case class CSCDynamics
(
    HVDCDynamics: HVDCDynamics = null,
    CSConverter: String = null
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
    override def sup: HVDCDynamics = HVDCDynamics

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
        implicit val clz: String = CSCDynamics.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CSCDynamics.fields (position), value)
        emitattr (0, CSConverter)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CSCDynamics rdf:ID=\"%s\">\n%s\t</cim:CSCDynamics>".format (id, export_fields)
    }
}

object CSCDynamics
extends
    CIMParseable[CSCDynamics]
{
    override val fields: Array[String] = Array[String] (
        "CSConverter"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("CSConverter", "CsConverter", "1", "0..1")
    )
    val CSConverter: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): CSCDynamics =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CSCDynamics (
            HVDCDynamics.parse (context),
            mask (CSConverter (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[CSCDynamics] = CSCDynamicsSerializer
}

object CSCDynamicsSerializer extends CIMSerializer[CSCDynamics]
{
    def write (kryo: Kryo, output: Output, obj: CSCDynamics): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.CSConverter)
        )
        HVDCDynamicsSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CSCDynamics]): CSCDynamics =
    {
        val parent = HVDCDynamicsSerializer.read (kryo, input, classOf[HVDCDynamics])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = CSCDynamics (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * HVDC whose behaviour is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model.</font>
 *
 * @param DynamicsFunctionBlock [[ch.ninecode.model.DynamicsFunctionBlock DynamicsFunctionBlock]] Reference to the superclass object.
 * @group HVDCDynamics
 * @groupname HVDCDynamics Package HVDCDynamics
 * @groupdesc HVDCDynamics High voltage direct current (HVDC) models.
 */
final case class HVDCDynamics
(
    DynamicsFunctionBlock: DynamicsFunctionBlock = null
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:HVDCDynamics rdf:ID=\"%s\">\n%s\t</cim:HVDCDynamics>".format (id, export_fields)
    }
}

object HVDCDynamics
extends
    CIMParseable[HVDCDynamics]
{

    def parse (context: CIMContext): HVDCDynamics =
    {
        val ret = HVDCDynamics (
            DynamicsFunctionBlock.parse (context)
        )
        ret
    }

    def serializer: Serializer[HVDCDynamics] = HVDCDynamicsSerializer
}

object HVDCDynamicsSerializer extends CIMSerializer[HVDCDynamics]
{
    def write (kryo: Kryo, output: Output, obj: HVDCDynamics): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        DynamicsFunctionBlockSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[HVDCDynamics]): HVDCDynamics =
    {
        val parent = DynamicsFunctionBlockSerializer.read (kryo, input, classOf[DynamicsFunctionBlock])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = HVDCDynamics (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * VSC function block whose behaviour is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model.</font>
 *
 * @param HVDCDynamics [[ch.ninecode.model.HVDCDynamics HVDCDynamics]] Reference to the superclass object.
 * @param VsConverter [[ch.ninecode.model.VsConverter VsConverter]] Voltage source converter to which voltage source converter dynamics model applies.
 * @group HVDCDynamics
 * @groupname HVDCDynamics Package HVDCDynamics
 * @groupdesc HVDCDynamics High voltage direct current (HVDC) models.
 */
final case class VSCDynamics
(
    HVDCDynamics: HVDCDynamics = null,
    VsConverter: String = null
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
    override def sup: HVDCDynamics = HVDCDynamics

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
        implicit val clz: String = VSCDynamics.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (VSCDynamics.fields (position), value)
        emitattr (0, VsConverter)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:VSCDynamics rdf:ID=\"%s\">\n%s\t</cim:VSCDynamics>".format (id, export_fields)
    }
}

object VSCDynamics
extends
    CIMParseable[VSCDynamics]
{
    override val fields: Array[String] = Array[String] (
        "VsConverter"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("VsConverter", "VsConverter", "1", "0..1")
    )
    val VsConverter: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): VSCDynamics =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = VSCDynamics (
            HVDCDynamics.parse (context),
            mask (VsConverter (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[VSCDynamics] = VSCDynamicsSerializer
}

object VSCDynamicsSerializer extends CIMSerializer[VSCDynamics]
{
    def write (kryo: Kryo, output: Output, obj: VSCDynamics): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.VsConverter)
        )
        HVDCDynamicsSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[VSCDynamics]): VSCDynamics =
    {
        val parent = HVDCDynamicsSerializer.read (kryo, input, classOf[HVDCDynamics])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = VSCDynamics (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _HVDCDynamics
{
    def register: List[CIMClassInfo] =
    {
        List (
            CSCDynamics.register,
            HVDCDynamics.register,
            VSCDynamics.register
        )
    }
}