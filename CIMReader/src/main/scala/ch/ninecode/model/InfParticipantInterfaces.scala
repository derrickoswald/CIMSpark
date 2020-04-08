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
 * This schedule is assocated with the hourly parameters in a resource bid.
 *
 * @param sup [[ch.ninecode.model.BidHourlySchedule BidHourlySchedule]] Reference to the superclass object.
 * @param value <em>undocumented</em>
 * @group InfParticipantInterfaces
 * @groupname InfParticipantInterfaces Package InfParticipantInterfaces
 */
final case class WheelingReferenceSchedule
(
    override val sup: BidHourlySchedule = null,
    value: String = null
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
    def BidHourlySchedule: BidHourlySchedule = sup
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
        implicit val clz: String = WheelingReferenceSchedule.cls
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
    override val fields: Array[String] = Array[String] (
        "value"
    )
    val value: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): WheelingReferenceSchedule =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WheelingReferenceSchedule (
            BidHourlySchedule.parse (context),
            mask (value (), 0)
        )
        ret.bitfields = bitfields
        ret
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