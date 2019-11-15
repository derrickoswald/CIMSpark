package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**

 * @group Feeder
 * @groupname Feeder Package Feeder
 */
final case class Circuit
(
    override val sup: Line = null,
    EndBay: List[String] = List(),
    EndTerminal: List[String] = List()
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
    def Line: Line = sup.asInstanceOf[Line]
    override def copy (): Row = { clone ().asInstanceOf[Circuit] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Circuit.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Circuit.fields (position), x))
        emitattrs (0, EndBay)
        emitattrs (1, EndTerminal)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Circuit rdf:ID=\"%s\">\n%s\t</cim:Circuit>".format (id, export_fields)
    }
}

object Circuit
extends
    Parseable[Circuit]
{
    override val fields: Array[String] = Array[String] (
        "EndBay",
        "EndTerminal"
    )
    override val relations: List[Relationship] = List (
        Relationship ("EndBay", "Bay", "0..*", "0..1"),
        Relationship ("EndTerminal", "Terminal", "0..*", "0..1")
    )
    val EndBay: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val EndTerminal: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): Circuit =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Circuit (
            Line.parse (context),
            masks (EndBay (), 0),
            masks (EndTerminal (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _Feeder
{
    def register: List[ClassInfo] =
    {
        List (
            Circuit.register
        )
    }
}