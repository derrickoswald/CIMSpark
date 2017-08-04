package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable


/**
 * Site of an interface between interchange areas.
 * The tie point can be a network branch (e.g., transmission line or transformer) or a switching device. For transmission lines, the interchange area boundary is usually at a designated point such as the middle of the line. Line end metering is then corrected for line losses.
 * @param sup Reference to the superclass object.
 * @param tiePointMWRating The MW rating of the tie point.
 */
case class TiePoint
(
    override val sup: IdentifiedObject,
    tiePointMWRating: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
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
        sup.export_fields +
        "\t\t<cim:TiePoint.tiePointMWRating>" + tiePointMWRating + "</cim:TiePoint.tiePointMWRating>\n"
    }
    override def export: String =
    {
        "\t<cim:TiePoint rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TiePoint>\n"
    }
}

object TiePoint
extends
    Parseable[TiePoint]
{
    val tiePointMWRating: (Context) => String = parse_element (element ("""TiePoint.tiePointMWRating"""))
    def parse (context: Context): TiePoint =
    {
        TiePoint(
            IdentifiedObject.parse (context),
            toDouble (tiePointMWRating (context), context)
        )
    }
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