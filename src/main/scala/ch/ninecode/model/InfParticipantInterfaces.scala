package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context


/**
 * A unique identifier of a wheeling transaction.
 * A wheeling transaction is a balanced Energy exchange among Supply and Demand Resources.
 */
case class WheelingReferenceSchedule
(

    override val sup: BidHourlySchedule,

    val value: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def BidHourlySchedule: BidHourlySchedule = sup.asInstanceOf[BidHourlySchedule]
    override def copy (): Row = { return (clone ().asInstanceOf[WheelingReferenceSchedule]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WheelingReferenceSchedule
extends
    Parseable[WheelingReferenceSchedule]
{
    val sup = BidHourlySchedule.parse _
    val value = parse_element (element ("""WheelingReferenceSchedule.value"""))_
    def parse (context: Context): WheelingReferenceSchedule =
    {
        WheelingReferenceSchedule(
            sup (context),
            value (context)
        )
    }
}

object _InfParticipantInterfaces
{
    def register: Unit =
    {
        WheelingReferenceSchedule.register
    }
}