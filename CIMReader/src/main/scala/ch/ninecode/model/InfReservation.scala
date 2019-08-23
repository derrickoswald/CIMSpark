package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Site of an interface between interchange areas.
 *
 * The tie point can be a network branch (e.g., transmission line or transformer) or a switching device. For transmission lines, the interchange area boundary is usually at a designated point such as the middle of the line. Line end metering is then corrected for line losses.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param tiePointMWRating The MW rating of the tie point.
 * @param ByMktMeasurement [[ch.ninecode.model.MktMeasurement MktMeasurement]] A measurement is made on the B side of a tie point
 * @param ForMktMeasurement [[ch.ninecode.model.MktMeasurement MktMeasurement]] A measurement is made on the A side of a tie point
 * @group InfReservation
 * @groupname InfReservation Package InfReservation
 */
final case class TiePoint
(
    override val sup: IdentifiedObject,
    tiePointMWRating: Double,
    ByMktMeasurement: List[String],
    ForMktMeasurement: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[TiePoint] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
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
        "\t<cim:TiePoint rdf:ID=\"%s\">\n%s\t</cim:TiePoint>".format (id, export_fields)
    }
}

object TiePoint
extends
    Parseable[TiePoint]
{
    override val fields: Array[String] = Array[String] (
        "tiePointMWRating",
        "ByMktMeasurement",
        "ForMktMeasurement"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ByMktMeasurement", "MktMeasurement", "1..*", "1"),
        Relationship ("ForMktMeasurement", "MktMeasurement", "1..*", "1")
    )
    val tiePointMWRating: Fielder = parse_element (element (cls, fields(0)))
    val ByMktMeasurement: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val ForMktMeasurement: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: Context): TiePoint =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = TiePoint (
            IdentifiedObject.parse (context),
            toDouble (mask (tiePointMWRating (), 0)),
            masks (ByMktMeasurement (), 1),
            masks (ForMktMeasurement (), 2)
        )
        ret.bitfields = bitfields
        ret
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