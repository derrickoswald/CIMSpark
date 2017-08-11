package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable


/**
 * A unique identifier of a wheeling transaction.
 * A wheeling transaction is a balanced Energy exchange among Supply and Demand Resources.
 * @param sup Reference to the superclass object.
 * @param value <em>undocumented</em>
 */
case class WheelingReferenceSchedule
(
    override val sup: BidHourlySchedule,
    value: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def BidHourlySchedule: BidHourlySchedule = sup.asInstanceOf[BidHourlySchedule]
    override def copy (): Row = { clone ().asInstanceOf[WheelingReferenceSchedule] }
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
        (if (null != value) "\t\t<cim:WheelingReferenceSchedule.value>" + value + "</cim:WheelingReferenceSchedule.value>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WheelingReferenceSchedule rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WheelingReferenceSchedule>"
    }
}

object WheelingReferenceSchedule
extends
    Parseable[WheelingReferenceSchedule]
{
    val value: (Context) => String = parse_element (element ("""WheelingReferenceSchedule.value"""))
    def parse (context: Context): WheelingReferenceSchedule =
    {
        WheelingReferenceSchedule(
            BidHourlySchedule.parse (context),
            value (context)
        )
    }
}

private[ninecode] object _InfParticipantInterfaces
{
    def register: List[ClassInfo] =
    {
        List (
            WheelingReferenceSchedule.register
        )
    }
}