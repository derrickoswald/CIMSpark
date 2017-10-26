package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Financial Transmission Rights (FTR) regarding transmission capacity at a flowgate.
 *
 * @param sup [[ch.ninecode.model.Agreement Agreement]] Reference to the superclass object.
 * @param action Buy, Sell
 * @param baseEnergy Quantity, typically MWs - Seller owns all rights being offered, MWs over time on same Point of Receipt, Point of Delivery, or Resource.
 * @param ftrType Type of rights being offered (product) allowed to be auctioned (option, obligation).
 * @param optimized Fixed (covers re-configuration, grandfathering) or Optimized (up for sale/purchase
 * @param EnergyPriceCurve [[ch.ninecode.model.EnergyPriceCurve EnergyPriceCurve]] <em>undocumented</em>
 * @param Flowgate [[ch.ninecode.model.Flowgate Flowgate]] <em>undocumented</em>
 * @param Pnodes [[ch.ninecode.model.Pnode Pnode]] <em>undocumented</em>
 * @param _class Peak, Off-peak, 24-hour
 * @group InfCongestionRevenueRights
 * @groupname InfCongestionRevenueRights Package InfCongestionRevenueRights
 */
case class FTR
(
    override val sup: Agreement,
    action: String,
    baseEnergy: Double,
    ftrType: String,
    optimized: String,
    EnergyPriceCurve: String,
    Flowgate: String,
    Pnodes: List[String],
    _class: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, null, null, null, null, List(), null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Agreement: Agreement = sup.asInstanceOf[Agreement]
    override def copy (): Row = { clone ().asInstanceOf[FTR] }
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
        implicit val clz: String = FTR.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (FTR.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (FTR.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (FTR.fields (position), x))
        emitelem (0, action)
        emitelem (1, baseEnergy)
        emitelem (2, ftrType)
        emitelem (3, optimized)
        emitattr (4, EnergyPriceCurve)
        emitattr (5, Flowgate)
        emitattrs (6, Pnodes)
        emitelem (7, _class)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:FTR rdf:ID=\"%s\">\n%s\t</cim:FTR>".format (id, export_fields)
    }
}

object FTR
extends
    Parseable[FTR]
{
    val fields: Array[String] = Array[String] (
        "action",
        "baseEnergy",
        "ftrType",
        "optimized",
        "EnergyPriceCurve",
        "Flowgate",
        "Pnodes",
        "class"
    )
    val action: Fielder = parse_element (element (cls, fields(0)))
    val baseEnergy: Fielder = parse_element (element (cls, fields(1)))
    val ftrType: Fielder = parse_element (element (cls, fields(2)))
    val optimized: Fielder = parse_element (element (cls, fields(3)))
    val EnergyPriceCurve: Fielder = parse_attribute (attribute (cls, fields(4)))
    val Flowgate: Fielder = parse_attribute (attribute (cls, fields(5)))
    val Pnodes: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val _class: Fielder = parse_element (element (cls, fields(7)))

    def parse (context: Context): FTR =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = FTR (
            Agreement.parse (context),
            mask (action (), 0),
            toDouble (mask (baseEnergy (), 1)),
            mask (ftrType (), 2),
            mask (optimized (), 3),
            mask (EnergyPriceCurve (), 4),
            mask (Flowgate (), 5),
            masks (Pnodes (), 6),
            mask (_class (), 7)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("EnergyPriceCurve", "EnergyPriceCurve", false),
        Relationship ("Flowgate", "Flowgate", false),
        Relationship ("Pnodes", "Pnode", true)
    )
}

/**
 * A type of limit that indicates if it is enforced and, through association, the organisation responsible for setting the limit.
 *
 * @param sup [[ch.ninecode.model.Limit Limit]] Reference to the superclass object.
 * @param enforced True if limit is enforced.
 * @param Flowgate [[ch.ninecode.model.Flowgate Flowgate]] <em>undocumented</em>
 * @param MktMeasurement [[ch.ninecode.model.MktMeasurement MktMeasurement]] <em>undocumented</em>
 * @param MktOrganisation [[ch.ninecode.model.MktOrganisation MktOrganisation]] <em>undocumented</em>
 * @group InfCongestionRevenueRights
 * @groupname InfCongestionRevenueRights Package InfCongestionRevenueRights
 */
case class ViolationLimit
(
    override val sup: Limit,
    enforced: Boolean,
    Flowgate: String,
    MktMeasurement: String,
    MktOrganisation: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Limit: Limit = sup.asInstanceOf[Limit]
    override def copy (): Row = { clone ().asInstanceOf[ViolationLimit] }
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
        implicit val clz: String = ViolationLimit.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ViolationLimit.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ViolationLimit.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (ViolationLimit.fields (position), x))
        emitelem (0, enforced)
        emitattr (1, Flowgate)
        emitattr (2, MktMeasurement)
        emitattrs (3, MktOrganisation)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ViolationLimit rdf:ID=\"%s\">\n%s\t</cim:ViolationLimit>".format (id, export_fields)
    }
}

object ViolationLimit
extends
    Parseable[ViolationLimit]
{
    val fields: Array[String] = Array[String] (
        "enforced",
        "Flowgate",
        "MktMeasurement",
        "MktOrganisation"
    )
    val enforced: Fielder = parse_element (element (cls, fields(0)))
    val Flowgate: Fielder = parse_attribute (attribute (cls, fields(1)))
    val MktMeasurement: Fielder = parse_attribute (attribute (cls, fields(2)))
    val MktOrganisation: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: Context): ViolationLimit =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ViolationLimit (
            Limit.parse (context),
            toBoolean (mask (enforced (), 0)),
            mask (Flowgate (), 1),
            mask (MktMeasurement (), 2),
            masks (MktOrganisation (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Flowgate", "Flowgate", false),
        Relationship ("MktMeasurement", "MktMeasurement", false),
        Relationship ("MktOrganisation", "MktOrganisation", true)
    )
}

private[ninecode] object _InfCongestionRevenueRights
{
    def register: List[ClassInfo] =
    {
        List (
            FTR.register,
            ViolationLimit.register
        )
    }
}