package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Examples would be "Boundary" or "Region" type of frame.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param ModelFrame [[ch.ninecode.model.FrameworkPart FrameworkPart]] Model frames of the model frame type.
 * @group unused
 * @groupname unused Package unused
 */
case class ModelFrameType
(
    override val sup: IdentifiedObject,
    ModelFrame: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ModelFrameType] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ModelFrameType.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (ModelFrameType.fields (position), x))
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
    Parseable[ModelFrameType]
{
    override val fields: Array[String] = Array[String] (
        "ModelFrame"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ModelFrame", "FrameworkPart", "0..*", "1")
    )
    val ModelFrame: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): ModelFrameType =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ModelFrameType (
            IdentifiedObject.parse (context),
            masks (ModelFrame (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _unused
{
    def register: List[ClassInfo] =
    {
        List (
            ModelFrameType.register
        )
    }
}