package ch.ninecode.model

import org.apache.spark.sql.catalyst.InternalRow

import ch.ninecode.Context

/*
 * Package: LoadModel
 */

case class SeasonDayTypeSchedule
(
    override val sup: RegularIntervalSchedule,
    val DayType: String,
    val Season: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def RegularIntervalSchedule: RegularIntervalSchedule = sup.asInstanceOf[RegularIntervalSchedule]
    override def copy (): InternalRow = { return (clone ().asInstanceOf[SeasonDayTypeSchedule]); }
    override def get (i: Int, d: org.apache.spark.sql.types.DataType): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def numFields: Int = productArity
}

object SeasonDayTypeSchedule
extends
    Parseable[SeasonDayTypeSchedule]
{
    val DayType = parse_attribute (attribute ("""SeasonDayTypeSchedule.DayType"""))_
    val Season = parse_attribute (attribute ("""SeasonDayTypeSchedule.Season"""))_
    def parse (context: Context): SeasonDayTypeSchedule =
    {
        return (
            SeasonDayTypeSchedule
            (
                RegularIntervalSchedule.parse (context),
                DayType (context),
                Season (context)
            )
        )
    }
}

object LoadModel
{
    def register: Unit =
    {
        SeasonDayTypeSchedule.register
    }
}
