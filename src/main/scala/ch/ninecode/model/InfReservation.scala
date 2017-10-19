package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Site of an interface between interchange areas.
 *
 * The tie point can be a network branch (e.g., transmission line or transformer) or a switching device. For transmission lines, the interchange area boundary is usually at a designated point such as the middle of the line. Line end metering is then corrected for line losses.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param tiePointMWRating The MW rating of the tie point.
 * @group InfReservation
 * @groupname InfReservation Package InfReservation
 */
case class TiePoint
(
    override val sup: IdentifiedObject,
    tiePointMWRating: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[TiePoint] }
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
        implicit val clz: String = TiePoint.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TiePoint.fields (position), value)
        emitelem (0, tiePointMWRating)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TiePoint rdf:ID=\"%s\">\n%s\t</cim:TiePoint>".format (id, export_fields)
    }
}

object TiePoint
extends
    Parseable[TiePoint]
{
    val fields: Array[String] = Array[String] (
        "tiePointMWRating"
    )
    val tiePointMWRating: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): TiePoint =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = TiePoint (
            IdentifiedObject.parse (context),
            toDouble (mask (tiePointMWRating (), 0))
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

private[ninecode] object _InfReservation
{
    def register: List[ClassInfo] =
    {
        List (
            TiePoint.register
        )
    }
}