package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Identifies a way in which an organisation may participate with a defined Congestion Revenue Right (CRR).
 *
 * @param sup [[ch.ninecode.model.OrganisationRole OrganisationRole]] Reference to the superclass object.
 * @param kind Kind of role the organisation is with regards to the congestion revenue rights.
 * @param status Status of congestion revenue rights organisation role.
 * @param CongestionRevenueRight [[ch.ninecode.model.CongestionRevenueRight CongestionRevenueRight]] <em>undocumented</em>
 * @group CongestionRevenueRights
 * @groupname CongestionRevenueRights Package CongestionRevenueRights
 * @groupdesc CongestionRevenueRights Congestion rent is a major, highly volatile charge currently faced by many participants in the LMP-based electrical energy markets. For this reason, the ISOs offer congestion revenue rights (CRR), also known as financial transmission rights or transmission congestion contracts. These are financial instruments that allow market participants to hedge against congestion charges when they schedule their generation, load and bilateral energy transactions.
 */
final case class CRROrgRole
(
    override val sup: OrganisationRole,
    kind: String,
    status: String,
    CongestionRevenueRight: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def OrganisationRole: OrganisationRole = sup.asInstanceOf[OrganisationRole]
    override def copy (): Row = { clone ().asInstanceOf[CRROrgRole] }
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
        implicit val clz: String = CRROrgRole.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CRROrgRole.fields (position), value)
        emitattr (0, kind)
        emitattr (1, status)
        emitattr (2, CongestionRevenueRight)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CRROrgRole rdf:ID=\"%s\">\n%s\t</cim:CRROrgRole>".format (id, export_fields)
    }
}

object CRROrgRole
extends
    Parseable[CRROrgRole]
{
    override val fields: Array[String] = Array[String] (
        "kind",
        "status",
        "CongestionRevenueRight"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CongestionRevenueRight", "CongestionRevenueRight", "1", "1..*")
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val status: Fielder = parse_attribute (attribute (cls, fields(1)))
    val CongestionRevenueRight: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): CRROrgRole =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = CRROrgRole (
            OrganisationRole.parse (context),
            mask (kind (), 0),
            mask (status (), 1),
            mask (CongestionRevenueRight (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * CRRSegment represents a segment of a CRR in a particular time frame.
 *
 * The segment class contains amount, clearing price, start date and time, end date and time.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param amount Dollar amount = quantity x clearingPrice
 * @param clearingPrice Clearing price of a CRR
 * @param endDateTime segment end date time
 * @param quantity The MW amount associated with the CRR
 * @param startDateTime segment start date time
 * @param CongestionRevenueRight [[ch.ninecode.model.CongestionRevenueRight CongestionRevenueRight]] <em>undocumented</em>
 * @param Sink [[ch.ninecode.model.Pnode Pnode]] <em>undocumented</em>
 * @param Source [[ch.ninecode.model.Pnode Pnode]] <em>undocumented</em>
 * @group CongestionRevenueRights
 * @groupname CongestionRevenueRights Package CongestionRevenueRights
 * @groupdesc CongestionRevenueRights Congestion rent is a major, highly volatile charge currently faced by many participants in the LMP-based electrical energy markets. For this reason, the ISOs offer congestion revenue rights (CRR), also known as financial transmission rights or transmission congestion contracts. These are financial instruments that allow market participants to hedge against congestion charges when they schedule their generation, load and bilateral energy transactions.
 */
final case class CRRSegment
(
    override val sup: IdentifiedObject,
    amount: Double,
    clearingPrice: Double,
    endDateTime: String,
    quantity: Double,
    startDateTime: String,
    CongestionRevenueRight: String,
    Sink: List[String],
    Source: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, null, 0.0, null, null, List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[CRRSegment] }
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
        implicit val clz: String = CRRSegment.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CRRSegment.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CRRSegment.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (CRRSegment.fields (position), x))
        emitelem (0, amount)
        emitelem (1, clearingPrice)
        emitelem (2, endDateTime)
        emitelem (3, quantity)
        emitelem (4, startDateTime)
        emitattr (5, CongestionRevenueRight)
        emitattrs (6, Sink)
        emitattrs (7, Source)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CRRSegment rdf:ID=\"%s\">\n%s\t</cim:CRRSegment>".format (id, export_fields)
    }
}

object CRRSegment
extends
    Parseable[CRRSegment]
{
    override val fields: Array[String] = Array[String] (
        "amount",
        "clearingPrice",
        "endDateTime",
        "quantity",
        "startDateTime",
        "CongestionRevenueRight",
        "Sink",
        "Source"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CongestionRevenueRight", "CongestionRevenueRight", "1", "1..*"),
        Relationship ("Sink", "Pnode", "0..*", "0..*"),
        Relationship ("Source", "Pnode", "0..*", "0..*")
    )
    val amount: Fielder = parse_element (element (cls, fields(0)))
    val clearingPrice: Fielder = parse_element (element (cls, fields(1)))
    val endDateTime: Fielder = parse_element (element (cls, fields(2)))
    val quantity: Fielder = parse_element (element (cls, fields(3)))
    val startDateTime: Fielder = parse_element (element (cls, fields(4)))
    val CongestionRevenueRight: Fielder = parse_attribute (attribute (cls, fields(5)))
    val Sink: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val Source: FielderMultiple = parse_attributes (attribute (cls, fields(7)))

    def parse (context: Context): CRRSegment =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = CRRSegment (
            IdentifiedObject.parse (context),
            toDouble (mask (amount (), 0)),
            toDouble (mask (clearingPrice (), 1)),
            mask (endDateTime (), 2),
            toDouble (mask (quantity (), 3)),
            mask (startDateTime (), 4),
            mask (CongestionRevenueRight (), 5),
            masks (Sink (), 6),
            masks (Source (), 7)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Congestion Revenue Rights (CRR) class that is inherited from a Document class.
 *
 * A CRR is a financial concept that is used to hedge congestion charges.
 * 
 * The CRR is usually settled based on the Locational Marginal Prices (LMPs) that are calculated in the day-ahead market. These LMPs are determined by the Day-ahead resource schedules/bids. CRRs will not hedge against marginal losses. If the congestion component of LMP at the sink is greater than at the source, then the CRR owner is entitled to receive a portion of congestion revenues. If the congestion component at the sink is less than at the source, then an obligation-type CRR owner will be charged, but an option-type CRR owner will not.
 *
 * @param sup [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param cRRcategory CRR category represents 'PTP' for a point-to-point CRR, or 'NSR' for a Network Service Right.
 *        If CRR category is 'PTP', both Source ID and Sink ID fields are required. If CRR category is 'NSR' only one field, either Source ID or Sink ID, shall be not null and the other shall be null. However, the 'NSR' category will include at least three records.
 * @param cRRtype Type of the CRR, from the possible type definitions in the CRR System (e.g. 'LSE', 'ETC').
 * @param hedgeType Hedge type Obligation or Option.
 *        An obligation type requires the holder to receive or pay the congestion rent. An option type gives the holder the option of receiving or paying the congestion rent.
 * @param timeOfUse Time of Use flag of the CRR - Peak (ON), Offpeak (OFF) or all 24 hours (24HR).
 * @param tradeSliceID Segment of the CRR described in the current record.
 * @param CRRMarket [[ch.ninecode.model.CRRMarket CRRMarket]] <em>undocumented</em>
 * @param CRROrgRole [[ch.ninecode.model.CRROrgRole CRROrgRole]] <em>undocumented</em>
 * @param CRRSegment [[ch.ninecode.model.CRRSegment CRRSegment]] <em>undocumented</em>
 * @param Flowgate [[ch.ninecode.model.Flowgate Flowgate]] <em>undocumented</em>
 * @group CongestionRevenueRights
 * @groupname CongestionRevenueRights Package CongestionRevenueRights
 * @groupdesc CongestionRevenueRights Congestion rent is a major, highly volatile charge currently faced by many participants in the LMP-based electrical energy markets. For this reason, the ISOs offer congestion revenue rights (CRR), also known as financial transmission rights or transmission congestion contracts. These are financial instruments that allow market participants to hedge against congestion charges when they schedule their generation, load and bilateral energy transactions.
 */
final case class CongestionRevenueRight
(
    override val sup: Document,
    cRRcategory: String,
    cRRtype: String,
    hedgeType: String,
    timeOfUse: String,
    tradeSliceID: String,
    CRRMarket: String,
    CRROrgRole: List[String],
    CRRSegment: List[String],
    Flowgate: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null, List(), List(), null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[CongestionRevenueRight] }
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
        implicit val clz: String = CongestionRevenueRight.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CongestionRevenueRight.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CongestionRevenueRight.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (CongestionRevenueRight.fields (position), x))
        emitattr (0, cRRcategory)
        emitattr (1, cRRtype)
        emitattr (2, hedgeType)
        emitattr (3, timeOfUse)
        emitelem (4, tradeSliceID)
        emitattr (5, CRRMarket)
        emitattrs (6, CRROrgRole)
        emitattrs (7, CRRSegment)
        emitattr (8, Flowgate)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CongestionRevenueRight rdf:ID=\"%s\">\n%s\t</cim:CongestionRevenueRight>".format (id, export_fields)
    }
}

object CongestionRevenueRight
extends
    Parseable[CongestionRevenueRight]
{
    override val fields: Array[String] = Array[String] (
        "cRRcategory",
        "cRRtype",
        "hedgeType",
        "timeOfUse",
        "tradeSliceID",
        "CRRMarket",
        "CRROrgRole",
        "CRRSegment",
        "Flowgate"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CRRMarket", "CRRMarket", "1", "1..*"),
        Relationship ("CRROrgRole", "CRROrgRole", "1..*", "1"),
        Relationship ("CRRSegment", "CRRSegment", "1..*", "1"),
        Relationship ("Flowgate", "Flowgate", "0..1", "0..1")
    )
    val cRRcategory: Fielder = parse_attribute (attribute (cls, fields(0)))
    val cRRtype: Fielder = parse_attribute (attribute (cls, fields(1)))
    val hedgeType: Fielder = parse_attribute (attribute (cls, fields(2)))
    val timeOfUse: Fielder = parse_attribute (attribute (cls, fields(3)))
    val tradeSliceID: Fielder = parse_element (element (cls, fields(4)))
    val CRRMarket: Fielder = parse_attribute (attribute (cls, fields(5)))
    val CRROrgRole: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val CRRSegment: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val Flowgate: Fielder = parse_attribute (attribute (cls, fields(8)))

    def parse (context: Context): CongestionRevenueRight =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = CongestionRevenueRight (
            Document.parse (context),
            mask (cRRcategory (), 0),
            mask (cRRtype (), 1),
            mask (hedgeType (), 2),
            mask (timeOfUse (), 3),
            mask (tradeSliceID (), 4),
            mask (CRRMarket (), 5),
            masks (CRROrgRole (), 6),
            masks (CRRSegment (), 7),
            mask (Flowgate (), 8)
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _CongestionRevenueRights
{
    def register: List[ClassInfo] =
    {
        List (
            CRROrgRole.register,
            CRRSegment.register,
            CongestionRevenueRight.register
        )
    }
}