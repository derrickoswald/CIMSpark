package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Vertical displacement relative to either sealevel, ground or the center of the earth.
 *
 * @param sup Reference to the superclass object.
 * @param displacement <em>undocumented</em>
 * @param kind <em>undocumented</em>
 * @group EnvDomain
 * @groupname EnvDomain Package EnvDomain
 */
final case class RelativeDisplacement
(
    override val sup: BasicElement = null,
    displacement: Double = 0.0,
    kind: String = null
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
    def  Element: Element = sup.asInstanceOf[Element]
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
        implicit val clz: String = RelativeDisplacement.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (RelativeDisplacement.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RelativeDisplacement.fields (position), value)
        emitelem (0, displacement)
        emitattr (1, kind)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RelativeDisplacement rdf:ID=\"%s\">\n%s\t</cim:RelativeDisplacement>".format (id, export_fields)
    }
}

object RelativeDisplacement
extends
    Parseable[RelativeDisplacement]
{
    override val fields: Array[String] = Array[String] (
        "displacement",
        "kind"
    )
    val displacement: Fielder = parse_element (element (cls, fields(0)))
    val kind: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): RelativeDisplacement =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = RelativeDisplacement (
            BasicElement.parse (context),
            toDouble (mask (displacement (), 0)),
            mask (kind (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _EnvDomain
{
    def register: List[ClassInfo] =
    {
        List (
            RelativeDisplacement.register
        )
    }
}