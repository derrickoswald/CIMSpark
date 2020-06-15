package ch.ninecode.model

import com.esotericsoftware.kryo.Kryo
import com.esotericsoftware.kryo.io.Input
import com.esotericsoftware.kryo.io.Output
import org.apache.spark.sql.Row

import ch.ninecode.cim.CIMClassInfo
import ch.ninecode.cim.CIMContext
import ch.ninecode.cim.CIMParseable
import ch.ninecode.cim.CIMRelationship
import ch.ninecode.cim.CIMSerializer

/**
 * A unique identifier of a wheeling transaction.
 *
 * A wheeling transaction is a balanced Energy exchange among Supply and Demand Resources.
 *
 * This schedule is assocated with the hourly parameters in a resource bid.
 *
 * @param BidHourlySchedule [[ch.ninecode.model.BidHourlySchedule BidHourlySchedule]] Reference to the superclass object.
 * @param value <em>undocumented</em>
 * @group InfParticipantInterfaces
 * @groupname InfParticipantInterfaces Package InfParticipantInterfaces
 */
final case class WheelingReferenceSchedule
(
    BidHourlySchedule: BidHourlySchedule = null,
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
    override def sup: BidHourlySchedule = BidHourlySchedule

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
    CIMParseable[WheelingReferenceSchedule]
{
    override val fields: Array[String] = Array[String] (
        "value"
    )
    val value: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: CIMContext): WheelingReferenceSchedule =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WheelingReferenceSchedule (
            BidHourlySchedule.parse (context),
            mask (value (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

object WheelingReferenceScheduleSerializer extends CIMSerializer[WheelingReferenceSchedule]
{
    def write (kryo: Kryo, output: Output, obj: WheelingReferenceSchedule): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.value)
        )
        BidHourlyScheduleSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[WheelingReferenceSchedule]): WheelingReferenceSchedule =
    {
        val parent = BidHourlyScheduleSerializer.read (kryo, input, classOf[BidHourlySchedule])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = WheelingReferenceSchedule (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _InfParticipantInterfaces
{
    def register: List[CIMClassInfo] =
    {
        List (
            WheelingReferenceSchedule.register
        )
    }
}