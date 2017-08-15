package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * Congestion Revenue Rights (CRR) class that is inherited from a Document class.
 *
 * A CRR is a financial concept that is used to hedge congestion charges.
 *
 * @param sup Reference to the superclass object.
 * @param cRRcategory CRR category represents 'PTP' for a point-to-point CRR, or 'NSR' for a Network Service Right .
 *        If CRR category is 'PTP', both Source ID and Sink ID fields are required. If CRR category is 'NSR' only one field, either Source ID or Sink ID, shall be not null and the other shall be null. However, the 'NSR' category will include at least three records
 * @param cRRtype Type of the CRR, from the possible type definitions in the CRR System (e.g. 'LSE', 'ETC').
 * @param hedgeType hedger type Obligation or Option
 * @param timeOfUse Time of Use flag of the CRR - Peak (ON), Offpeak (OFF) or all 24 hours (24HR).
 * @param tradeSliceID Segment of the CRR described in the current record
 * @param CRRMarket <em>undocumented</em>
 * @param Flowgate <em>undocumented</em>
 * @group CongestionRevenueRights
 * @groupname CongestionRevenueRights Package CongestionRevenueRights
 * @groupdesc CongestionRevenueRights Congestion rent is a major, highly volatile charge currently faced by many participants in the LMP-based electrical energy markets. For this reason, the ISOs offer congestion revenue rights (CRR), also known as financial transmission rights or transmission congestion contracts. These are financial instruments that allow market participants to hedge against congestion charges when they schedule their generation, load and bilateral energy transactions.
 */
case class CRR
(
    override val sup: Document,
    cRRcategory: String,
    cRRtype: String,
    hedgeType: String,
    timeOfUse: String,
    tradeSliceID: String,
    CRRMarket: String,
    Flowgate: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[CRR] }
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
        (if (null != cRRcategory) "\t\t<cim:CRR.cRRcategory rdf:resource=\"#" + cRRcategory + "\"/>\n" else "") +
        (if (null != cRRtype) "\t\t<cim:CRR.cRRtype rdf:resource=\"#" + cRRtype + "\"/>\n" else "") +
        (if (null != hedgeType) "\t\t<cim:CRR.hedgeType rdf:resource=\"#" + hedgeType + "\"/>\n" else "") +
        (if (null != timeOfUse) "\t\t<cim:CRR.timeOfUse rdf:resource=\"#" + timeOfUse + "\"/>\n" else "") +
        (if (null != tradeSliceID) "\t\t<cim:CRR.tradeSliceID>" + tradeSliceID + "</cim:CRR.tradeSliceID>\n" else "") +
        (if (null != CRRMarket) "\t\t<cim:CRR.CRRMarket rdf:resource=\"#" + CRRMarket + "\"/>\n" else "") +
        (if (null != Flowgate) "\t\t<cim:CRR.Flowgate rdf:resource=\"#" + Flowgate + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:CRR rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CRR>"
    }
}

object CRR
extends
    Parseable[CRR]
{
    val cRRcategory = parse_attribute (attribute ("""CRR.cRRcategory"""))
    val cRRtype = parse_attribute (attribute ("""CRR.cRRtype"""))
    val hedgeType = parse_attribute (attribute ("""CRR.hedgeType"""))
    val timeOfUse = parse_attribute (attribute ("""CRR.timeOfUse"""))
    val tradeSliceID = parse_element (element ("""CRR.tradeSliceID"""))
    val CRRMarket = parse_attribute (attribute ("""CRR.CRRMarket"""))
    val Flowgate = parse_attribute (attribute ("""CRR.Flowgate"""))
    def parse (context: Context): CRR =
    {
        CRR(
            Document.parse (context),
            cRRcategory (context),
            cRRtype (context),
            hedgeType (context),
            timeOfUse (context),
            tradeSliceID (context),
            CRRMarket (context),
            Flowgate (context)
        )
    }
}

/**
 * Identifies a way in which an organisation may participate with a defined Congestion Revenue Right (CRR).
 *
 * @param sup Reference to the superclass object.
 * @param kind Kind of role the organisation is with regards to the congestion revenue rights.
 * @param status Status of congestion revenue rights organisation role.
 * @param CRR <em>undocumented</em>
 * @param MktOrganisation <em>undocumented</em>
 * @group CongestionRevenueRights
 * @groupname CongestionRevenueRights Package CongestionRevenueRights
 * @groupdesc CongestionRevenueRights Congestion rent is a major, highly volatile charge currently faced by many participants in the LMP-based electrical energy markets. For this reason, the ISOs offer congestion revenue rights (CRR), also known as financial transmission rights or transmission congestion contracts. These are financial instruments that allow market participants to hedge against congestion charges when they schedule their generation, load and bilateral energy transactions.
 */
case class CRROrgRole
(
    override val sup: OrganisationRole,
    kind: String,
    status: String,
    CRR: String,
    MktOrganisation: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != kind) "\t\t<cim:CRROrgRole.kind rdf:resource=\"#" + kind + "\"/>\n" else "") +
        (if (null != status) "\t\t<cim:CRROrgRole.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != CRR) "\t\t<cim:CRROrgRole.CRR rdf:resource=\"#" + CRR + "\"/>\n" else "") +
        (if (null != MktOrganisation) "\t\t<cim:CRROrgRole.MktOrganisation rdf:resource=\"#" + MktOrganisation + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:CRROrgRole rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CRROrgRole>"
    }
}

object CRROrgRole
extends
    Parseable[CRROrgRole]
{
    val kind = parse_attribute (attribute ("""CRROrgRole.kind"""))
    val status = parse_attribute (attribute ("""CRROrgRole.status"""))
    val CRR = parse_attribute (attribute ("""CRROrgRole.CRR"""))
    val MktOrganisation = parse_attribute (attribute ("""CRROrgRole.MktOrganisation"""))
    def parse (context: Context): CRROrgRole =
    {
        CRROrgRole(
            OrganisationRole.parse (context),
            kind (context),
            status (context),
            CRR (context),
            MktOrganisation (context)
        )
    }
}

/**
 * CRRSegment represents a segment of a CRR in a particular time frame.
 *
 * The segment class contains CRR kind, type, quantity, hedger type, time of use flag, and segment period.
 *
 * @param sup Reference to the superclass object.
 * @param amount Dollar amount = quantity x clearingPrice
 * @param clearingPrice Clearing price of a CRR
 * @param endDateTime segment end date time
 * @param quantity The MW amount associated with the CRR
 * @param startDateTime segment start date time
 * @param CRR <em>undocumented</em>
 * @group CongestionRevenueRights
 * @groupname CongestionRevenueRights Package CongestionRevenueRights
 * @groupdesc CongestionRevenueRights Congestion rent is a major, highly volatile charge currently faced by many participants in the LMP-based electrical energy markets. For this reason, the ISOs offer congestion revenue rights (CRR), also known as financial transmission rights or transmission congestion contracts. These are financial instruments that allow market participants to hedge against congestion charges when they schedule their generation, load and bilateral energy transactions.
 */
case class CRRSegment
(
    override val sup: IdentifiedObject,
    amount: Double,
    clearingPrice: Double,
    endDateTime: String,
    quantity: Double,
    startDateTime: String,
    CRR: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, null, 0.0, null, null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        "\t\t<cim:CRRSegment.amount>" + amount + "</cim:CRRSegment.amount>\n" +
        "\t\t<cim:CRRSegment.clearingPrice>" + clearingPrice + "</cim:CRRSegment.clearingPrice>\n" +
        (if (null != endDateTime) "\t\t<cim:CRRSegment.endDateTime>" + endDateTime + "</cim:CRRSegment.endDateTime>\n" else "") +
        "\t\t<cim:CRRSegment.quantity>" + quantity + "</cim:CRRSegment.quantity>\n" +
        (if (null != startDateTime) "\t\t<cim:CRRSegment.startDateTime>" + startDateTime + "</cim:CRRSegment.startDateTime>\n" else "") +
        (if (null != CRR) "\t\t<cim:CRRSegment.CRR rdf:resource=\"#" + CRR + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:CRRSegment rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CRRSegment>"
    }
}

object CRRSegment
extends
    Parseable[CRRSegment]
{
    val amount = parse_element (element ("""CRRSegment.amount"""))
    val clearingPrice = parse_element (element ("""CRRSegment.clearingPrice"""))
    val endDateTime = parse_element (element ("""CRRSegment.endDateTime"""))
    val quantity = parse_element (element ("""CRRSegment.quantity"""))
    val startDateTime = parse_element (element ("""CRRSegment.startDateTime"""))
    val CRR = parse_attribute (attribute ("""CRRSegment.CRR"""))
    def parse (context: Context): CRRSegment =
    {
        CRRSegment(
            IdentifiedObject.parse (context),
            toDouble (amount (context), context),
            toDouble (clearingPrice (context), context),
            endDateTime (context),
            toDouble (quantity (context), context),
            startDateTime (context),
            CRR (context)
        )
    }
}

private[ninecode] object _CongestionRevenueRights
{
    def register: List[ClassInfo] =
    {
        List (
            CRR.register,
            CRROrgRole.register,
            CRRSegment.register
        )
    }
}