package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * @group AlternateModels
 * @groupname AlternateModels Package AlternateModels
 */
final case class AlternateModel
(
    IdentifiedObject: IdentifiedObject = null,
    AlternateModelGroup: String = null,
    Dataset: String = null
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
        implicit val clz: String = AlternateModel.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AlternateModel.fields (position), value)
        emitattr (0, AlternateModelGroup)
        emitattr (1, Dataset)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AlternateModel rdf:ID=\"%s\">\n%s\t</cim:AlternateModel>".format (id, export_fields)
    }
}

object AlternateModel
extends
    Parseable[AlternateModel]
{
    override val fields: Array[String] = Array[String] (
        "AlternateModelGroup",
        "Dataset"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AlternateModelGroup", "AlternateModelGroup", "1", "0..*"),
        Relationship ("Dataset", "DataSet", "1", "0..1")
    )
    val AlternateModelGroup: Fielder = parse_attribute (attribute (cls, fields(0)))
    val Dataset: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): AlternateModel =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AlternateModel (
            IdentifiedObject.parse (context),
            mask (AlternateModelGroup (), 0),
            mask (Dataset (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * @group AlternateModels
 * @groupname AlternateModels Package AlternateModels
 */
final case class AlternateModelGroup
(
    IdentifiedObject: IdentifiedObject = null,
    AlternateModel: List[String] = null
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
        implicit val clz: String = AlternateModelGroup.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (AlternateModelGroup.fields (position), x))
        emitattrs (0, AlternateModel)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AlternateModelGroup rdf:ID=\"%s\">\n%s\t</cim:AlternateModelGroup>".format (id, export_fields)
    }
}

object AlternateModelGroup
extends
    Parseable[AlternateModelGroup]
{
    override val fields: Array[String] = Array[String] (
        "AlternateModel"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AlternateModel", "AlternateModel", "0..*", "1")
    )
    val AlternateModel: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): AlternateModelGroup =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AlternateModelGroup (
            IdentifiedObject.parse (context),
            masks (AlternateModel (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _AlternateModels
{
    def register: List[ClassInfo] =
    {
        List (
            AlternateModel.register,
            AlternateModelGroup.register
        )
    }
}