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
 * @group Feeder
 * @groupname Feeder Package Feeder
 */
final case class Circuit
(
    Line: Line = null,
    EndBay: List[String] = null,
    EndTerminal: List[String] = null
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
    override def sup: Line = Line

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
    CIMParseable[Circuit]
{
    override val fields: Array[String] = Array[String] (
        "EndBay",
        "EndTerminal"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("EndBay", "Bay", "0..*", "0..1"),
        CIMRelationship ("EndTerminal", "Terminal", "0..*", "0..1")
    )
    val EndBay: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val EndTerminal: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): Circuit =
    {
        implicit val ctx: CIMContext = context
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

object CircuitSerializer extends CIMSerializer[Circuit]
{
    def write (kryo: Kryo, output: Output, obj: Circuit): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.EndBay, output),
            () => writeList (obj.EndTerminal, output)
        )
        LineSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Circuit]): Circuit =
    {
        val parent = LineSerializer.read (kryo, input, classOf[Line])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Circuit (
            parent,
            if (isSet (0)) readList (input) else null,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _Feeder
{
    def register: List[CIMClassInfo] =
    {
        List (
            Circuit.register
        )
    }
}