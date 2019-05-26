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
case class RelativeDisplacement
(
    override val sup: BasicElement,
    displacement: Double,
    kind: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[RelativeDisplacement] }
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
        implicit var bitfields: Array[Int] = Array(0)
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