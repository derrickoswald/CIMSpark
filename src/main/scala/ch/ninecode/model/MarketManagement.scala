package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * This package contains all core CIM Market Extensions required for market management systems.
 */

/**
 * The Area Control Error tariff type that is applied or used.
 * @param sup Reference to the superclass object.
 * @param typ The coded type of an ACE tariff.
 * @param MarketDocument
 * @param Unit
 */
case class AceTariffType
(
    override val sup: Element,
    val typ: String,
    val MarketDocument: List[String],
    val Unit: List[String]
)
extends
    Element
{
    def this () = { this (null, null, List(), List()) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[AceTariffType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AceTariffType
extends
    Parseable[AceTariffType]
{
    val sup = BasicElement.parse _
    val typ = parse_element (element ("""AceTariffType.type"""))_
    val MarketDocument = parse_attributes (attribute ("""AceTariffType.MarketDocument"""))_
    val Unit = parse_attributes (attribute ("""AceTariffType.Unit"""))_
    def parse (context: Context): AceTariffType =
    {
        AceTariffType(
            sup (context),
            typ (context),
            MarketDocument (context),
            Unit (context)
        )
    }
}

/**
 * A class used to provide information about an attribute.
 * @param sup Reference to the superclass object.
 * @param attribute The identification of the formal name of an attribute.
 * @param attributeValue The instance value of the attribute.
 * @param position A sequential value representing a relative sequence number.
 * @param TimeSeries
 */
case class AttributeInstanceComponent
(
    override val sup: Element,
    val attribute: String,
    val attributeValue: String,
    val position: Int,
    val TimeSeries: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, 0, List()) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[AttributeInstanceComponent]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AttributeInstanceComponent
extends
    Parseable[AttributeInstanceComponent]
{
    val sup = BasicElement.parse _
    val attribute = parse_element (element ("""AttributeInstanceComponent.attribute"""))_
    val attributeValue = parse_element (element ("""AttributeInstanceComponent.attributeValue"""))_
    val position = parse_element (element ("""AttributeInstanceComponent.position"""))_
    val TimeSeries = parse_attributes (attribute ("""AttributeInstanceComponent.TimeSeries"""))_
    def parse (context: Context): AttributeInstanceComponent =
    {
        AttributeInstanceComponent(
            sup (context),
            attribute (context),
            attributeValue (context),
            toInteger (position (context), context),
            TimeSeries (context)
        )
    }
}

/**
 * A class providing the identification and type of an auction.
 * @param sup Reference to the superclass object.
 * @param allocationMode Identification of the method of allocation in an auction.
 * @param cancelled An indicator that signifies that the auction has been cancelled.
 * @param category The product category of an auction.
 * @param paymentTerms The terms which dictate the determination of the bid payment price.
 * @param rights The rights of use the transmission capacity acquired in an auction.
 * @param typ The kind of the Auction (e.g. implicit, explicit ...).
 * @param TimeSeries
 */
case class Auction
(
    override val sup: Element,
    val allocationMode: String,
    val cancelled: String,
    val category: String,
    val paymentTerms: String,
    val rights: String,
    val typ: String,
    val TimeSeries: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, List()) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Auction]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Auction
extends
    Parseable[Auction]
{
    val sup = IdentifiedObject.parse _
    val allocationMode = parse_element (element ("""Auction.allocationMode"""))_
    val cancelled = parse_element (element ("""Auction.cancelled"""))_
    val category = parse_element (element ("""Auction.category"""))_
    val paymentTerms = parse_element (element ("""Auction.paymentTerms"""))_
    val rights = parse_element (element ("""Auction.rights"""))_
    val typ = parse_element (element ("""Auction.type"""))_
    val TimeSeries = parse_attributes (attribute ("""Auction.TimeSeries"""))_
    def parse (context: Context): Auction =
    {
        Auction(
            sup (context),
            allocationMode (context),
            cancelled (context),
            category (context),
            paymentTerms (context),
            rights (context),
            typ (context),
            TimeSeries (context)
        )
    }
}

/**
 * The formal specification of specific characteristics related to a bid.
 * @param sup Reference to the superclass object.
 * @param blockBid Indication that  the values in the period are considered as a whole.
 *        They cannot be changed or subdivided.
 * @param direction The coded identification of the energy flow.
 * @param divisible An indication whether or not each element of the bid may be partially accepted or not.
 * @param linkedBidsIdentification Unique identification associated with all linked bids.
 * @param minimumActivationQuantity The minimum quantity of energy that can be activated at a given time interval.
 * @param stepIncrementQuantity The minimum increment that can be applied for an increase in an activation request.
 */
case class BidTimeSeries
(
    override val sup: Element,
    val blockBid: String,
    val direction: String,
    val divisible: String,
    val linkedBidsIdentification: String,
    val minimumActivationQuantity: Double,
    val stepIncrementQuantity: Double
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, 0.0, 0.0) }
    def TimeSeries: TimeSeries = sup.asInstanceOf[TimeSeries]
    override def copy (): Row = { return (clone ().asInstanceOf[BidTimeSeries]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BidTimeSeries
extends
    Parseable[BidTimeSeries]
{
    val sup = TimeSeries.parse _
    val blockBid = parse_element (element ("""BidTimeSeries.blockBid"""))_
    val direction = parse_element (element ("""BidTimeSeries.direction"""))_
    val divisible = parse_element (element ("""BidTimeSeries.divisible"""))_
    val linkedBidsIdentification = parse_element (element ("""BidTimeSeries.linkedBidsIdentification"""))_
    val minimumActivationQuantity = parse_element (element ("""BidTimeSeries.minimumActivationQuantity"""))_
    val stepIncrementQuantity = parse_element (element ("""BidTimeSeries.stepIncrementQuantity"""))_
    def parse (context: Context): BidTimeSeries =
    {
        BidTimeSeries(
            sup (context),
            blockBid (context),
            direction (context),
            divisible (context),
            linkedBidsIdentification (context),
            toDouble (minimumActivationQuantity (context), context),
            toDouble (stepIncrementQuantity (context), context)
        )
    }
}

/**
 * The date and or the time.
 * @param sup Reference to the superclass object.
 * @param date Date as "yyyy-mm-dd", which conforms with ISO 8601
 * @param time Time as "hh:mm:ss.sssZ", which conforms with ISO 8601.
 */
case class DateAndOrTime
(
    override val sup: Element,
    val date: String,
    val time: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[DateAndOrTime]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DateAndOrTime
extends
    Parseable[DateAndOrTime]
{
    val sup = BasicElement.parse _
    val date = parse_element (element ("""DateAndOrTime.date"""))_
    val time = parse_element (element ("""DateAndOrTime.time"""))_
    def parse (context: Context): DateAndOrTime =
    {
        DateAndOrTime(
            sup (context),
            date (context),
            time (context)
        )
    }
}

/**
 * An area of activity defined within the energy market.
 * @param sup Reference to the superclass object.
 */
case class Domain
(
    override val sup: Element
)
extends
    Element
{
    def this () = { this (null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Domain]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Domain
extends
    Parseable[Domain]
{
    val sup = IdentifiedObject.parse _
    def parse (context: Context): Domain =
    {
        Domain(
            sup (context)
        )
    }
}

/**
 * The coded identification of the direction of energy flow.
 * @param sup Reference to the superclass object.
 * @param direction The coded identification of the direction of energy flow.
 */
case class FlowDirection
(
    override val sup: Element,
    val direction: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[FlowDirection]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object FlowDirection
extends
    Parseable[FlowDirection]
{
    val sup = BasicElement.parse _
    val direction = parse_element (element ("""FlowDirection.direction"""))_
    def parse (context: Context): FlowDirection =
    {
        FlowDirection(
            sup (context),
            direction (context)
        )
    }
}

/**
 * An identification  or eventually the contents of an agreement between two or more parties.
 * @param sup Reference to the superclass object.
 */
case class MarketAgreement
(
    override val sup: Element
)
extends
    Element
{
    def this () = { this (null) }
    def MarketDocument: MarketDocument = sup.asInstanceOf[MarketDocument]
    override def copy (): Row = { return (clone ().asInstanceOf[MarketAgreement]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MarketAgreement
extends
    Parseable[MarketAgreement]
{
    val sup = MarketDocument.parse _
    def parse (context: Context): MarketAgreement =
    {
        MarketAgreement(
            sup (context)
        )
    }
}

/**
 * Electronic document containing the information necessary to satisfy a given business process set of requirements.
 * @param sup Reference to the superclass object.
 * @param selfMarketDocument
 * @param AttributeInstanceComponent
 * @param Domain
 * @param Period
 */
case class MarketDocument
(
    override val sup: Element,
    val selfMarketDocument: List[String],
    val AttributeInstanceComponent: List[String],
    val Domain: List[String],
    val Period: List[String]
)
extends
    Element
{
    def this () = { this (null, List(), List(), List(), List()) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { return (clone ().asInstanceOf[MarketDocument]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MarketDocument
extends
    Parseable[MarketDocument]
{
    val sup = Document.parse _
    val selfMarketDocument = parse_attributes (attribute ("""MarketDocument.selfMarketDocument"""))_
    val AttributeInstanceComponent = parse_attributes (attribute ("""MarketDocument.AttributeInstanceComponent"""))_
    val Domain = parse_attributes (attribute ("""MarketDocument.Domain"""))_
    val Period = parse_attributes (attribute ("""MarketDocument.Period"""))_
    def parse (context: Context): MarketDocument =
    {
        MarketDocument(
            sup (context),
            selfMarketDocument (context),
            AttributeInstanceComponent (context),
            Domain (context),
            Period (context)
        )
    }
}

/**
 * The identification of an entity where energy products are measured or computed.
 * @param sup Reference to the superclass object.
 */
case class MarketEvaluationPoint
(
    override val sup: Element
)
extends
    Element
{
    def this () = { this (null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[MarketEvaluationPoint]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MarketEvaluationPoint
extends
    Parseable[MarketEvaluationPoint]
{
    val sup = IdentifiedObject.parse _
    def parse (context: Context): MarketEvaluationPoint =
    {
        MarketEvaluationPoint(
            sup (context)
        )
    }
}

/**
 * The condition or position of an object with regard to its standing.
 * @param sup Reference to the superclass object.
 * @param status The coded condition or position of an object with regard to its standing.
 * @param TimeSeries
 */
case class MarketObjectStatus
(
    override val sup: Element,
    val status: String,
    val TimeSeries: List[String]
)
extends
    Element
{
    def this () = { this (null, null, List()) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[MarketObjectStatus]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MarketObjectStatus
extends
    Parseable[MarketObjectStatus]
{
    val sup = BasicElement.parse _
    val status = parse_element (element ("""MarketObjectStatus.status"""))_
    val TimeSeries = parse_attributes (attribute ("""MarketObjectStatus.TimeSeries"""))_
    def parse (context: Context): MarketObjectStatus =
    {
        MarketObjectStatus(
            sup (context),
            status (context),
            TimeSeries (context)
        )
    }
}

/**
 * The type of a power system resource.
 * @param sup Reference to the superclass object.
 * @param psrType The coded type of a power system resource.
 * @param TimeSeries
 */
case class MktPSRType
(
    override val sup: Element,
    val psrType: String,
    val TimeSeries: List[String]
)
extends
    Element
{
    def this () = { this (null, null, List()) }
    def PSRType: PSRType = sup.asInstanceOf[PSRType]
    override def copy (): Row = { return (clone ().asInstanceOf[MktPSRType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MktPSRType
extends
    Parseable[MktPSRType]
{
    val sup = PSRType.parse _
    val psrType = parse_element (element ("""MktPSRType.psrType"""))_
    val TimeSeries = parse_attributes (attribute ("""MktPSRType.TimeSeries"""))_
    def parse (context: Context): MktPSRType =
    {
        MktPSRType(
            sup (context),
            psrType (context),
            TimeSeries (context)
        )
    }
}

/**
 * An identification of a time interval that may have a given resolution.
 * @param sup Reference to the superclass object.
 * @param resolution The number of units of time that compose an individual step within a period.
 * @param timeInterval The start and end date and time for a given interval.
 * @param Reason
 */
case class Period
(
    override val sup: Element,
    val resolution: String,
    val timeInterval: String,
    val Reason: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, List()) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[Period]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Period
extends
    Parseable[Period]
{
    val sup = BasicElement.parse _
    val resolution = parse_element (element ("""Period.resolution"""))_
    val timeInterval = parse_attribute (attribute ("""Period.timeInterval"""))_
    val Reason = parse_attributes (attribute ("""Period.Reason"""))_
    def parse (context: Context): Period =
    {
        Period(
            sup (context),
            resolution (context),
            timeInterval (context),
            Reason (context)
        )
    }
}

/**
 * An identification of a set of values beeing adressed within a specific interval of time.
 * @param sup Reference to the superclass object.
 * @param position A sequential value representing the relative position within a given time interval.
 * @param quality The quality of the information being provided.
 *        This quality may be estimated, not available, as provided, etc.
 * @param quantity Principal quantity identified for a point.
 * @param secondaryQuantity Secondary quantity identified for a point.
 * @param AceTariffType
 * @param Period
 * @param TimeSeries
 */
case class Point
(
    override val sup: Element,
    val position: Int,
    val quality: String,
    val quantity: Double,
    val secondaryQuantity: Double,
    val AceTariffType: List[String],
    val Period: String,
    val TimeSeries: List[String]
)
extends
    Element
{
    def this () = { this (null, 0, null, 0.0, 0.0, List(), null, List()) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[Point]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Point
extends
    Parseable[Point]
{
    val sup = BasicElement.parse _
    val position = parse_element (element ("""Point.position"""))_
    val quality = parse_element (element ("""Point.quality"""))_
    val quantity = parse_element (element ("""Point.quantity"""))_
    val secondaryQuantity = parse_element (element ("""Point.secondaryQuantity"""))_
    val AceTariffType = parse_attributes (attribute ("""Point.AceTariffType"""))_
    val Period = parse_attribute (attribute ("""Point.Period"""))_
    val TimeSeries = parse_attributes (attribute ("""Point.TimeSeries"""))_
    def parse (context: Context): Point =
    {
        Point(
            sup (context),
            toInteger (position (context), context),
            quality (context),
            toDouble (quantity (context), context),
            toDouble (secondaryQuantity (context), context),
            AceTariffType (context),
            Period (context),
            TimeSeries (context)
        )
    }
}

/**
 * The cost corresponding to a specific measure and expressed in a currency.
 * @param sup Reference to the superclass object.
 * @param amount A number of monetary units specified in a unit of currency.
 * @param category The category of a price to be used in a price calculation.
 *        The price category is mutually agreed between System Operators.
 * @param direction The direction indicates whether a System Operator pays the Market Parties or inverse.
 * @param Point
 */
case class Price
(
    override val sup: Element,
    val amount: Double,
    val category: String,
    val direction: String,
    val Point: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[Price]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Price
extends
    Parseable[Price]
{
    val sup = BasicElement.parse _
    val amount = parse_element (element ("""Price.amount"""))_
    val category = parse_element (element ("""Price.category"""))_
    val direction = parse_element (element ("""Price.direction"""))_
    val Point = parse_attribute (attribute ("""Price.Point"""))_
    def parse (context: Context): Price =
    {
        Price(
            sup (context),
            toDouble (amount (context), context),
            category (context),
            direction (context),
            Point (context)
        )
    }
}

/**
 * The formal specification of a set of business transactions having the same business goal.
 * @param sup Reference to the superclass object.
 * @param classificationType The classification mechanism used to group a set of objects together within a business process.
 *        The grouping may be of a detailed or a summary nature.
 * @param processType The kind of business process.
 * @param MarketDocument
 */
case class Process
(
    override val sup: Element,
    val classificationType: String,
    val processType: String,
    val MarketDocument: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, List()) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Process]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Process
extends
    Parseable[Process]
{
    val sup = IdentifiedObject.parse _
    val classificationType = parse_element (element ("""Process.classificationType"""))_
    val processType = parse_element (element ("""Process.processType"""))_
    val MarketDocument = parse_attributes (attribute ("""Process.MarketDocument"""))_
    def parse (context: Context): Process =
    {
        Process(
            sup (context),
            classificationType (context),
            processType (context),
            MarketDocument (context)
        )
    }
}

/**
 * The motivation of an act.
 * @param sup Reference to the superclass object.
 * @param code The motivation of an act in coded form.
 * @param text The textual explanation corresponding to the reason code.
 * @param MarketDocument
 * @param Point
 */
case class Reason
(
    override val sup: Element,
    val code: String,
    val text: String,
    val MarketDocument: List[String],
    val Point: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, List(), List()) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[Reason]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Reason
extends
    Parseable[Reason]
{
    val sup = BasicElement.parse _
    val code = parse_element (element ("""Reason.code"""))_
    val text = parse_element (element ("""Reason.text"""))_
    val MarketDocument = parse_attributes (attribute ("""Reason.MarketDocument"""))_
    val Point = parse_attributes (attribute ("""Reason.Point"""))_
    def parse (context: Context): Reason =
    {
        Reason(
            sup (context),
            code (context),
            text (context),
            MarketDocument (context),
            Point (context)
        )
    }
}

/**
 * A set of regular time-ordered measurements or values of quantitative nature of an individual or collective phenomenon taken at successive, in most cases equidistant, periods / points of time.
 * @param sup Reference to the superclass object.
 * @param businessType The identification of the nature of the time series.
 * @param cancelledTS An indicator stating that the TimeSeries, identified by the mRID, is cancelled as well as all the values sent in a previous version of the TimeSeries in a previous document.
 * @param curveType The coded representation of the type of curve being described.
 * @param objectAggregation Identification of the object that is the common dominator used to aggregate a time series.
 * @param product The type of the product such as Power, energy, reactive power, transport capacity that is the subject of the time series.
 * @param version Version of the time series.
 * @param DateAndOrTime
 * @param Domain
 * @param FlowDirection
 * @param MarketDocument
 * @param MarketEvaluationPoint
 * @param MarketParticipant
 * @param Period
 * @param Reason
 */
case class TimeSeries
(
    override val sup: Element,
    val businessType: String,
    val cancelledTS: String,
    val curveType: String,
    val objectAggregation: String,
    val product: String,
    val version: String,
    val DateAndOrTime: List[String],
    val Domain: List[String],
    val FlowDirection: List[String],
    val MarketDocument: List[String],
    val MarketEvaluationPoint: List[String],
    val MarketParticipant: List[String],
    val Period: List[String],
    val Reason: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, List(), List(), List(), List(), List(), List(), List(), List()) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[TimeSeries]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TimeSeries
extends
    Parseable[TimeSeries]
{
    val sup = IdentifiedObject.parse _
    val businessType = parse_element (element ("""TimeSeries.businessType"""))_
    val cancelledTS = parse_element (element ("""TimeSeries.cancelledTS"""))_
    val curveType = parse_element (element ("""TimeSeries.curveType"""))_
    val objectAggregation = parse_element (element ("""TimeSeries.objectAggregation"""))_
    val product = parse_element (element ("""TimeSeries.product"""))_
    val version = parse_element (element ("""TimeSeries.version"""))_
    val DateAndOrTime = parse_attributes (attribute ("""TimeSeries.DateAndOrTime"""))_
    val Domain = parse_attributes (attribute ("""TimeSeries.Domain"""))_
    val FlowDirection = parse_attributes (attribute ("""TimeSeries.FlowDirection"""))_
    val MarketDocument = parse_attributes (attribute ("""TimeSeries.MarketDocument"""))_
    val MarketEvaluationPoint = parse_attributes (attribute ("""TimeSeries.MarketEvaluationPoint"""))_
    val MarketParticipant = parse_attributes (attribute ("""TimeSeries.MarketParticipant"""))_
    val Period = parse_attributes (attribute ("""TimeSeries.Period"""))_
    val Reason = parse_attributes (attribute ("""TimeSeries.Reason"""))_
    def parse (context: Context): TimeSeries =
    {
        TimeSeries(
            sup (context),
            businessType (context),
            cancelledTS (context),
            curveType (context),
            objectAggregation (context),
            product (context),
            version (context),
            DateAndOrTime (context),
            Domain (context),
            FlowDirection (context),
            MarketDocument (context),
            MarketEvaluationPoint (context),
            MarketParticipant (context),
            Period (context),
            Reason (context)
        )
    }
}

/**
 * The identification of the unit name for the time series quantities.
 * @param sup Reference to the superclass object.
 * @param name The coded representation of the unit.
 * @param TimeSeries
 */
case class Unit_
(
    override val sup: Element,
    val name: String,
    val TimeSeries: List[String]
)
extends
    Element
{
    def this () = { this (null, null, List()) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[Unit_]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Unit_
extends
    Parseable[Unit_]
{
    val sup = BasicElement.parse _
    val name = parse_element (element ("""Unit_.name"""))_
    val TimeSeries = parse_attributes (attribute ("""Unit_.TimeSeries"""))_
    def parse (context: Context): Unit_ =
    {
        Unit_(
            sup (context),
            name (context),
            TimeSeries (context)
        )
    }
}

object _MarketManagement
{
    def register: Unit =
    {
        AceTariffType.register
        AttributeInstanceComponent.register
        Auction.register
        BidTimeSeries.register
        DateAndOrTime.register
        Domain.register
        FlowDirection.register
        MarketAgreement.register
        MarketDocument.register
        MarketEvaluationPoint.register
        MarketObjectStatus.register
        MktPSRType.register
        Period.register
        Point.register
        Price.register
        Process.register
        Reason.register
        TimeSeries.register
        Unit_.register
    }
}