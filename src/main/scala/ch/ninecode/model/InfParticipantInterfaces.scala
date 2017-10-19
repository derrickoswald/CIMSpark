package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * A unique identifier of a wheeling transaction.
 *
 * A wheeling transaction is a balanced Energy exchange among Supply and Demand Resources.
 *
 * @param sup [[ch.ninecode.model.BidHourlySchedule BidHourlySchedule]] Reference to the superclass object.
 * @param value <em>undocumented</em>
 * @group InfParticipantInterfaces
 * @groupname InfParticipantInterfaces Package InfParticipantInterfaces
 */
case class WheelingReferenceSchedule
(
    override val sup: BidHourlySchedule,
    value: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = WheelingReferenceSchedule.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (WheelingReferenceSchedule.fields (position), value)
        emitelem (0, value)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WheelingReferenceSchedule rdf:ID=\"%s\">\n%s\t</cim:WheelingReferenceSchedule>".format (id, export_fields)
    }
}

object WheelingReferenceSchedule
extends
    Parseable[WheelingReferenceSchedule]
{
    val fields: Array[String] = Array[String] (
        "value"
    )
    val value: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): WheelingReferenceSchedule =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = WheelingReferenceSchedule (
            BidHourlySchedule.parse (context),
            mask (value (), 0)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (

    )
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