package ch.ninecode.model

import com.esotericsoftware.kryo.Kryo
import com.esotericsoftware.kryo.io.Input
import com.esotericsoftware.kryo.io.Output
import org.apache.spark.sql.Row

import ch.ninecode.cim.CIMClassInfo
import ch.ninecode.cim.CIMContext
import ch.ninecode.cim.CIMParseable
import ch.ninecode.cim.CIMRelationship
import ch.ninecode.cim.CIMSerializer

/**
 * Examples would be "Boundary" or "Region" type of frame.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param ModelFrame [[ch.ninecode.model.FrameworkPart FrameworkPart]] Model frames of the model frame type.
 * @group unused
 * @groupname unused Package unused
 */
final case class ModelFrameType
(
    IdentifiedObject: IdentifiedObject = null,
    ModelFrame: List[String] = null
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
    override def sup: IdentifiedObject = IdentifiedObject

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
        implicit val clz: String = ModelFrameType.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ModelFrameType.fields (position), x))
        emitattrs (0, ModelFrame)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ModelFrameType rdf:ID=\"%s\">\n%s\t</cim:ModelFrameType>".format (id, export_fields)
    }
}

object ModelFrameType
extends
    CIMParseable[ModelFrameType]
{
    override val fields: Array[String] = Array[String] (
        "ModelFrame"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ModelFrame", "FrameworkPart", "0..*", "1")
    )
    val ModelFrame: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): ModelFrameType =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ModelFrameType (
            IdentifiedObject.parse (context),
            masks (ModelFrame (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

object ModelFrameTypeSerializer extends CIMSerializer[ModelFrameType]
{
    def write (kryo: Kryo, output: Output, obj: ModelFrameType): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.ModelFrame, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ModelFrameType]): ModelFrameType =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ModelFrameType (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _unused
{
    def register: List[CIMClassInfo] =
    {
        List (
            ModelFrameType.register
        )
    }
}