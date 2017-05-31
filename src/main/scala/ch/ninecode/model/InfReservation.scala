package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context


/**
 * Site of an interface between interchange areas.
 * The tie point can be a network branch (e.g., transmission line or transformer) or a switching device. For transmission lines, the interchange area boundary is usually at a designated point such as the middle of the line. Line end metering is then corrected for line losses.
 * @param sup Reference to the superclass object.
 * @param tiePointMWRating The MW rating of the tie point.
 */
case class TiePoint
(
    override val sup: IdentifiedObject,
    val tiePointMWRating: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[TiePoint]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TiePoint
extends
    Parseable[TiePoint]
{
    val sup = IdentifiedObject.parse _
    val tiePointMWRating = parse_element (element ("""TiePoint.tiePointMWRating"""))
    def parse (context: Context): TiePoint =
    {
        TiePoint(
            sup (context),
            toDouble (tiePointMWRating (context), context)
        )
    }
}

object _InfReservation
{
    def register: Unit =
    {
        TiePoint.register
    }
}