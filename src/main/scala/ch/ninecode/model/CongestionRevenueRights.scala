package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * Congestion rent is a major, highly volatile charge currently faced by many participants in the LMP-based electrical energy markets.
 * For this reason, the ISOs offer congestion revenue rights (CRR), also known as financial transmission rights or transmission congestion contracts. These are financial instruments that allow market participants to hedge against congestion charges when they schedule their generation, load and bilateral energy transactions.
 */

/**
 * Congestion Revenue Rights (CRR) class that is inherited from a Document class.
 * A CRR is a financial concept that is used to hedge congestion charges.
 */
case class CRR
(

    override val sup: Document,

    /**
     * CRR category represents 'PTP' for a point-to-point CRR, or 'NSR' for a Network Service Right .
     * If CRR category is 'PTP', both Source ID and Sink ID fields are required. If CRR category is 'NSR' only one field, either Source ID or Sink ID, shall be not null and the other shall be null. However, the 'NSR' category will include at least three records
     */
    val cRRcategory: String,

    /**
     * Type of the CRR, from the possible type definitions in the CRR System (e.g. 'LSE', 'ETC').
     */
    val cRRtype: String,

    /**
     * hedger type Obligation or Option
     */
    val hedgeType: String,

    /**
     * Time of Use flag of the CRR - Peak (ON), Offpeak (OFF) or all 24 hours (24HR).
     */
    val timeOfUse: String,

    /**
     * Segment of the CRR described in the current record
     */
    val tradeSliceID: String,

    val CRRMarket: String,

    val Flowgate: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { return (clone ().asInstanceOf[CRR]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CRR
extends
    Parseable[CRR]
{
    val sup = Document.parse _
    val cRRcategory = parse_attribute (attribute ("""CRR.cRRcategory"""))_
    val cRRtype = parse_attribute (attribute ("""CRR.cRRtype"""))_
    val hedgeType = parse_attribute (attribute ("""CRR.hedgeType"""))_
    val timeOfUse = parse_attribute (attribute ("""CRR.timeOfUse"""))_
    val tradeSliceID = parse_element (element ("""CRR.tradeSliceID"""))_
    val CRRMarket = parse_attribute (attribute ("""CRR.CRRMarket"""))_
    val Flowgate = parse_attribute (attribute ("""CRR.Flowgate"""))_
    def parse (context: Context): CRR =
    {
        CRR(
            sup (context),
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
 */
case class CRROrgRole
(

    override val sup: OrganisationRole,

    /**
     * Kind of role the organisation is with regards to the congestion revenue rights.
     */
    val kind: String,

    /**
     * Status of congestion revenue rights organisation role.
     */
    val status: String,

    val CRR: String,

    val MktOrganisation: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def OrganisationRole: OrganisationRole = sup.asInstanceOf[OrganisationRole]
    override def copy (): Row = { return (clone ().asInstanceOf[CRROrgRole]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CRROrgRole
extends
    Parseable[CRROrgRole]
{
    val sup = OrganisationRole.parse _
    val kind = parse_attribute (attribute ("""CRROrgRole.kind"""))_
    val status = parse_attribute (attribute ("""CRROrgRole.status"""))_
    val CRR = parse_attribute (attribute ("""CRROrgRole.CRR"""))_
    val MktOrganisation = parse_attribute (attribute ("""CRROrgRole.MktOrganisation"""))_
    def parse (context: Context): CRROrgRole =
    {
        CRROrgRole(
            sup (context),
            kind (context),
            status (context),
            CRR (context),
            MktOrganisation (context)
        )
    }
}

/**
 * CRRSegment represents a segment of a CRR in a particular time frame.
 * The segment class contains CRR kind, type, quantity, hedger type, time of use flag, and segment period.
 */
case class CRRSegment
(

    override val sup: IdentifiedObject,

    /**
     * Dollar amount = quantity x clearingPrice
     */
    val amount: Double,

    /**
     * Clearing price of a CRR
     */
    val clearingPrice: Double,

    /**
     * segment end date time
     */
    val endDateTime: String,

    /**
     * The MW amount associated with the CRR
     */
    val quantity: Double,

    /**
     * segment start date time
     */
    val startDateTime: String,

    val CRR: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null, 0.0, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[CRRSegment]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CRRSegment
extends
    Parseable[CRRSegment]
{
    val sup = IdentifiedObject.parse _
    val amount = parse_element (element ("""CRRSegment.amount"""))_
    val clearingPrice = parse_element (element ("""CRRSegment.clearingPrice"""))_
    val endDateTime = parse_element (element ("""CRRSegment.endDateTime"""))_
    val quantity = parse_element (element ("""CRRSegment.quantity"""))_
    val startDateTime = parse_element (element ("""CRRSegment.startDateTime"""))_
    val CRR = parse_attribute (attribute ("""CRRSegment.CRR"""))_
    def parse (context: Context): CRRSegment =
    {
        CRRSegment(
            sup (context),
            toDouble (amount (context), context),
            toDouble (clearingPrice (context), context),
            endDateTime (context),
            toDouble (quantity (context), context),
            startDateTime (context),
            CRR (context)
        )
    }
}

object _CongestionRevenueRights
{
    def register: Unit =
    {
        CRR.register
        CRROrgRole.register
        CRRSegment.register
    }
}