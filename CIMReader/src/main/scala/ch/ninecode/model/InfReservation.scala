package ch.ninecode.model

import com.esotericsoftware.kryo.Kryo
import com.esotericsoftware.kryo.Serializer
import com.esotericsoftware.kryo.io.Input
import com.esotericsoftware.kryo.io.Output
import org.apache.spark.sql.Row

import ch.ninecode.cim.CIMClassInfo
import ch.ninecode.cim.CIMContext
import ch.ninecode.cim.CIMParseable
import ch.ninecode.cim.CIMRelationship
import ch.ninecode.cim.CIMSerializer

/**
 * Site of an interface between interchange areas.
 *
 * The tie point can be a network branch (e.g., transmission line or transformer) or a switching device. For transmission lines, the interchange area boundary is usually at a designated point such as the middle of the line. Line end metering is then corrected for line losses.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param tiePointMWRating The MW rating of the tie point.
 * @param ByMktMeasurement [[ch.ninecode.model.MktMeasurement MktMeasurement]] A measurement is made on the B side of a tie point
 * @param ForMktMeasurement [[ch.ninecode.model.MktMeasurement MktMeasurement]] A measurement is made on the A side of a tie point
 * @group InfReservation
 * @groupname InfReservation Package InfReservation
 */
final case class TiePoint
(
    IdentifiedObject: IdentifiedObject = null,
    tiePointMWRating: Double = 0.0,
    ByMktMeasurement: List[String] = null,
    ForMktMeasurement: List[String] = null
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
    override def sup: IdentifiedObject = IdentifiedObject

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
        implicit val clz: String = TiePoint.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TiePoint.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (TiePoint.fields (position), x))
        emitelem (0, tiePointMWRating)
        emitattrs (1, ByMktMeasurement)
        emitattrs (2, ForMktMeasurement)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TiePoint rdf:%s=\"%s\">\n%s\t</cim:TiePoint>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object TiePoint
extends
    CIMParseable[TiePoint]
{
    override val fields: Array[String] = Array[String] (
        "tiePointMWRating",
        "ByMktMeasurement",
        "ForMktMeasurement"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ByMktMeasurement", "MktMeasurement", "1..*", "1"),
        CIMRelationship ("ForMktMeasurement", "MktMeasurement", "1..*", "1")
    )
    val tiePointMWRating: Fielder = parse_element (element (cls, fields(0)))
    val ByMktMeasurement: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val ForMktMeasurement: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: CIMContext): TiePoint =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TiePoint (
            IdentifiedObject.parse (context),
            toDouble (mask (tiePointMWRating (), 0)),
            masks (ByMktMeasurement (), 1),
            masks (ForMktMeasurement (), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[TiePoint] = TiePointSerializer
}

object TiePointSerializer extends CIMSerializer[TiePoint]
{
    def write (kryo: Kryo, output: Output, obj: TiePoint): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.tiePointMWRating),
            () => writeList (obj.ByMktMeasurement, output),
            () => writeList (obj.ForMktMeasurement, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TiePoint]): TiePoint =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = TiePoint (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _InfReservation
{
    def register: List[CIMClassInfo] =
    {
        List (
            TiePoint.register
        )
    }
}