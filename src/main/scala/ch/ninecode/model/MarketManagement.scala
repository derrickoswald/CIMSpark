package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * The Area Control Error tariff type that is applied or used.
 *
 * @param sup Reference to the superclass object.
 * @param typ The coded type of an ACE tariff.
 * @param MarketDocument [[ch.ninecode.model.MarketDocument MarketDocument]] <em>undocumented</em>
 * @param Unit [[ch.ninecode.model.Unit_ Unit_]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class AceTariffType
(
    override val sup: BasicElement,
    typ: String,
    MarketDocument: List[String],
    Unit: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[AceTariffType] }
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
        (if (null != typ) "\t\t<cim:AceTariffType.type>" + typ + "</cim:AceTariffType.type>\n" else "") +
        (if (null != MarketDocument) MarketDocument.map (x => "\t\t<cim:AceTariffType.MarketDocument rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != Unit) Unit.map (x => "\t\t<cim:AceTariffType.Unit rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:AceTariffType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AceTariffType>"
    }
}

object AceTariffType
extends
    Parseable[AceTariffType]
{
    val typ = parse_element (element ("""AceTariffType.type"""))
    val MarketDocument = parse_attributes (attribute ("""AceTariffType.MarketDocument"""))
    val Unit = parse_attributes (attribute ("""AceTariffType.Unit"""))
    def parse (context: Context): AceTariffType =
    {
        AceTariffType(
            BasicElement.parse (context),
            typ (context),
            MarketDocument (context),
            Unit (context)
        )
    }
}

/**
 * A class used to provide information about an attribute.
 *
 * @param sup Reference to the superclass object.
 * @param attribute The identification of the formal name of an attribute.
 * @param attributeValue The instance value of the attribute.
 * @param position A sequential value representing a relative sequence number.
 * @param TimeSeries [[ch.ninecode.model.TimeSeries TimeSeries]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class AttributeInstanceComponent
(
    override val sup: BasicElement,
    attribute: String,
    attributeValue: String,
    position: Int,
    TimeSeries: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, 0, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[AttributeInstanceComponent] }
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
        (if (null != attribute) "\t\t<cim:AttributeInstanceComponent.attribute>" + attribute + "</cim:AttributeInstanceComponent.attribute>\n" else "") +
        (if (null != attributeValue) "\t\t<cim:AttributeInstanceComponent.attributeValue>" + attributeValue + "</cim:AttributeInstanceComponent.attributeValue>\n" else "") +
        "\t\t<cim:AttributeInstanceComponent.position>" + position + "</cim:AttributeInstanceComponent.position>\n" +
        (if (null != TimeSeries) TimeSeries.map (x => "\t\t<cim:AttributeInstanceComponent.TimeSeries rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:AttributeInstanceComponent rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AttributeInstanceComponent>"
    }
}

object AttributeInstanceComponent
extends
    Parseable[AttributeInstanceComponent]
{
    val attribute = parse_element (element ("""AttributeInstanceComponent.attribute"""))
    val attributeValue = parse_element (element ("""AttributeInstanceComponent.attributeValue"""))
    val position = parse_element (element ("""AttributeInstanceComponent.position"""))
    val TimeSeries = parse_attributes (attribute ("""AttributeInstanceComponent.TimeSeries"""))
    def parse (context: Context): AttributeInstanceComponent =
    {
        AttributeInstanceComponent(
            BasicElement.parse (context),
            attribute (context),
            attributeValue (context),
            toInteger (position (context), context),
            TimeSeries (context)
        )
    }
}

/**
 * A class providing the identification and type of an auction.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param allocationMode Identification of the method of allocation in an auction.
 * @param cancelled An indicator that signifies that the auction has been cancelled.
 * @param category The product category of an auction.
 * @param paymentTerms The terms which dictate the determination of the bid payment price.
 * @param rights The rights of use the transmission capacity acquired in an auction.
 * @param typ The kind of the Auction (e.g. implicit, explicit ...).
 * @param TimeSeries [[ch.ninecode.model.TimeSeries TimeSeries]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class Auction
(
    override val sup: IdentifiedObject,
    allocationMode: String,
    cancelled: String,
    category: String,
    paymentTerms: String,
    rights: String,
    typ: String,
    TimeSeries: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Auction] }
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
        (if (null != allocationMode) "\t\t<cim:Auction.allocationMode>" + allocationMode + "</cim:Auction.allocationMode>\n" else "") +
        (if (null != cancelled) "\t\t<cim:Auction.cancelled>" + cancelled + "</cim:Auction.cancelled>\n" else "") +
        (if (null != category) "\t\t<cim:Auction.category>" + category + "</cim:Auction.category>\n" else "") +
        (if (null != paymentTerms) "\t\t<cim:Auction.paymentTerms>" + paymentTerms + "</cim:Auction.paymentTerms>\n" else "") +
        (if (null != rights) "\t\t<cim:Auction.rights>" + rights + "</cim:Auction.rights>\n" else "") +
        (if (null != typ) "\t\t<cim:Auction.type>" + typ + "</cim:Auction.type>\n" else "") +
        (if (null != TimeSeries) TimeSeries.map (x => "\t\t<cim:Auction.TimeSeries rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:Auction rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Auction>"
    }
}

object Auction
extends
    Parseable[Auction]
{
    val allocationMode = parse_element (element ("""Auction.allocationMode"""))
    val cancelled = parse_element (element ("""Auction.cancelled"""))
    val category = parse_element (element ("""Auction.category"""))
    val paymentTerms = parse_element (element ("""Auction.paymentTerms"""))
    val rights = parse_element (element ("""Auction.rights"""))
    val typ = parse_element (element ("""Auction.type"""))
    val TimeSeries = parse_attributes (attribute ("""Auction.TimeSeries"""))
    def parse (context: Context): Auction =
    {
        Auction(
            IdentifiedObject.parse (context),
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
 *
 * @param sup [[ch.ninecode.model.TimeSeries TimeSeries]] Reference to the superclass object.
 * @param blockBid Indication that  the values in the period are considered as a whole.
 *        They cannot be changed or subdivided.
 * @param direction The coded identification of the energy flow.
 * @param divisible An indication whether or not each element of the bid may be partially accepted or not.
 * @param linkedBidsIdentification Unique identification associated with all linked bids.
 * @param minimumActivationQuantity The minimum quantity of energy that can be activated at a given time interval.
 * @param stepIncrementQuantity The minimum increment that can be applied for an increase in an activation request.
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class BidTimeSeries
(
    override val sup: TimeSeries,
    blockBid: String,
    direction: String,
    divisible: String,
    linkedBidsIdentification: String,
    minimumActivationQuantity: Double,
    stepIncrementQuantity: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def TimeSeries: TimeSeries = sup.asInstanceOf[TimeSeries]
    override def copy (): Row = { clone ().asInstanceOf[BidTimeSeries] }
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
        (if (null != blockBid) "\t\t<cim:BidTimeSeries.blockBid>" + blockBid + "</cim:BidTimeSeries.blockBid>\n" else "") +
        (if (null != direction) "\t\t<cim:BidTimeSeries.direction>" + direction + "</cim:BidTimeSeries.direction>\n" else "") +
        (if (null != divisible) "\t\t<cim:BidTimeSeries.divisible>" + divisible + "</cim:BidTimeSeries.divisible>\n" else "") +
        (if (null != linkedBidsIdentification) "\t\t<cim:BidTimeSeries.linkedBidsIdentification>" + linkedBidsIdentification + "</cim:BidTimeSeries.linkedBidsIdentification>\n" else "") +
        "\t\t<cim:BidTimeSeries.minimumActivationQuantity>" + minimumActivationQuantity + "</cim:BidTimeSeries.minimumActivationQuantity>\n" +
        "\t\t<cim:BidTimeSeries.stepIncrementQuantity>" + stepIncrementQuantity + "</cim:BidTimeSeries.stepIncrementQuantity>\n"
    }
    override def export: String =
    {
        "\t<cim:BidTimeSeries rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:BidTimeSeries>"
    }
}

object BidTimeSeries
extends
    Parseable[BidTimeSeries]
{
    val blockBid = parse_element (element ("""BidTimeSeries.blockBid"""))
    val direction = parse_element (element ("""BidTimeSeries.direction"""))
    val divisible = parse_element (element ("""BidTimeSeries.divisible"""))
    val linkedBidsIdentification = parse_element (element ("""BidTimeSeries.linkedBidsIdentification"""))
    val minimumActivationQuantity = parse_element (element ("""BidTimeSeries.minimumActivationQuantity"""))
    val stepIncrementQuantity = parse_element (element ("""BidTimeSeries.stepIncrementQuantity"""))
    def parse (context: Context): BidTimeSeries =
    {
        BidTimeSeries(
            TimeSeries.parse (context),
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
 *
 * @param sup Reference to the superclass object.
 * @param date Date as "yyyy-mm-dd", which conforms with ISO 8601
 * @param time Time as "hh:mm:ss.sssZ", which conforms with ISO 8601.
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class DateAndOrTime
(
    override val sup: BasicElement,
    date: String,
    time: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[DateAndOrTime] }
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
        (if (null != date) "\t\t<cim:DateAndOrTime.date>" + date + "</cim:DateAndOrTime.date>\n" else "") +
        (if (null != time) "\t\t<cim:DateAndOrTime.time>" + time + "</cim:DateAndOrTime.time>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:DateAndOrTime rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DateAndOrTime>"
    }
}

object DateAndOrTime
extends
    Parseable[DateAndOrTime]
{
    val date = parse_element (element ("""DateAndOrTime.date"""))
    val time = parse_element (element ("""DateAndOrTime.time"""))
    def parse (context: Context): DateAndOrTime =
    {
        DateAndOrTime(
            BasicElement.parse (context),
            date (context),
            time (context)
        )
    }
}

/**
 * An area of activity defined within the energy market.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class Domain
(
    override val sup: IdentifiedObject
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Domain] }
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
        ""
    }
    override def export: String =
    {
        "\t<cim:Domain rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Domain>"
    }
}

object Domain
extends
    Parseable[Domain]
{
    def parse (context: Context): Domain =
    {
        Domain(
            IdentifiedObject.parse (context)
        )
    }
}

/**
 * The coded identification of the direction of energy flow.
 *
 * @param sup Reference to the superclass object.
 * @param direction The coded identification of the direction of energy flow.
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class FlowDirection
(
    override val sup: BasicElement,
    direction: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[FlowDirection] }
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
        (if (null != direction) "\t\t<cim:FlowDirection.direction>" + direction + "</cim:FlowDirection.direction>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:FlowDirection rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:FlowDirection>"
    }
}

object FlowDirection
extends
    Parseable[FlowDirection]
{
    val direction = parse_element (element ("""FlowDirection.direction"""))
    def parse (context: Context): FlowDirection =
    {
        FlowDirection(
            BasicElement.parse (context),
            direction (context)
        )
    }
}

/**
 * An identification  or eventually the contents of an agreement between two or more parties.
 *
 * @param sup [[ch.ninecode.model.MarketDocument MarketDocument]] Reference to the superclass object.
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class MarketAgreement
(
    override val sup: MarketDocument
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def MarketDocument: MarketDocument = sup.asInstanceOf[MarketDocument]
    override def copy (): Row = { clone ().asInstanceOf[MarketAgreement] }
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
        ""
    }
    override def export: String =
    {
        "\t<cim:MarketAgreement rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MarketAgreement>"
    }
}

object MarketAgreement
extends
    Parseable[MarketAgreement]
{
    def parse (context: Context): MarketAgreement =
    {
        MarketAgreement(
            MarketDocument.parse (context)
        )
    }
}

/**
 * Electronic document containing the information necessary to satisfy a given business process set of requirements.
 *
 * @param sup [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param selfMarketDocument <em>undocumented</em>
 * @param AttributeInstanceComponent [[ch.ninecode.model.AttributeInstanceComponent AttributeInstanceComponent]] <em>undocumented</em>
 * @param Domain [[ch.ninecode.model.Domain Domain]] <em>undocumented</em>
 * @param Period [[ch.ninecode.model.Period Period]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class MarketDocument
(
    override val sup: Document,
    selfMarketDocument: List[String],
    AttributeInstanceComponent: List[String],
    Domain: List[String],
    Period: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List(), List(), List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[MarketDocument] }
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
        (if (null != selfMarketDocument) selfMarketDocument.map (x => "\t\t<cim:MarketDocument.selfMarketDocument rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != AttributeInstanceComponent) AttributeInstanceComponent.map (x => "\t\t<cim:MarketDocument.AttributeInstanceComponent rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != Domain) Domain.map (x => "\t\t<cim:MarketDocument.Domain rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != Period) Period.map (x => "\t\t<cim:MarketDocument.Period rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:MarketDocument rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MarketDocument>"
    }
}

object MarketDocument
extends
    Parseable[MarketDocument]
{
    val selfMarketDocument = parse_attributes (attribute ("""MarketDocument.selfMarketDocument"""))
    val AttributeInstanceComponent = parse_attributes (attribute ("""MarketDocument.AttributeInstanceComponent"""))
    val Domain = parse_attributes (attribute ("""MarketDocument.Domain"""))
    val Period = parse_attributes (attribute ("""MarketDocument.Period"""))
    def parse (context: Context): MarketDocument =
    {
        MarketDocument(
            Document.parse (context),
            selfMarketDocument (context),
            AttributeInstanceComponent (context),
            Domain (context),
            Period (context)
        )
    }
}

/**
 * The identification of an entity where energy products are measured or computed.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class MarketEvaluationPoint
(
    override val sup: IdentifiedObject
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[MarketEvaluationPoint] }
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
        ""
    }
    override def export: String =
    {
        "\t<cim:MarketEvaluationPoint rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MarketEvaluationPoint>"
    }
}

object MarketEvaluationPoint
extends
    Parseable[MarketEvaluationPoint]
{
    def parse (context: Context): MarketEvaluationPoint =
    {
        MarketEvaluationPoint(
            IdentifiedObject.parse (context)
        )
    }
}

/**
 * The condition or position of an object with regard to its standing.
 *
 * @param sup Reference to the superclass object.
 * @param status The coded condition or position of an object with regard to its standing.
 * @param TimeSeries [[ch.ninecode.model.TimeSeries TimeSeries]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class MarketObjectStatus
(
    override val sup: BasicElement,
    status: String,
    TimeSeries: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[MarketObjectStatus] }
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
        (if (null != status) "\t\t<cim:MarketObjectStatus.status>" + status + "</cim:MarketObjectStatus.status>\n" else "") +
        (if (null != TimeSeries) TimeSeries.map (x => "\t\t<cim:MarketObjectStatus.TimeSeries rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:MarketObjectStatus rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MarketObjectStatus>"
    }
}

object MarketObjectStatus
extends
    Parseable[MarketObjectStatus]
{
    val status = parse_element (element ("""MarketObjectStatus.status"""))
    val TimeSeries = parse_attributes (attribute ("""MarketObjectStatus.TimeSeries"""))
    def parse (context: Context): MarketObjectStatus =
    {
        MarketObjectStatus(
            BasicElement.parse (context),
            status (context),
            TimeSeries (context)
        )
    }
}

/**
 * The type of a power system resource.
 *
 * @param sup [[ch.ninecode.model.PSRType PSRType]] Reference to the superclass object.
 * @param psrType The coded type of a power system resource.
 * @param TimeSeries [[ch.ninecode.model.TimeSeries TimeSeries]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class MktPSRType
(
    override val sup: PSRType,
    psrType: String,
    TimeSeries: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PSRType: PSRType = sup.asInstanceOf[PSRType]
    override def copy (): Row = { clone ().asInstanceOf[MktPSRType] }
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
        (if (null != psrType) "\t\t<cim:MktPSRType.psrType>" + psrType + "</cim:MktPSRType.psrType>\n" else "") +
        (if (null != TimeSeries) TimeSeries.map (x => "\t\t<cim:MktPSRType.TimeSeries rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:MktPSRType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MktPSRType>"
    }
}

object MktPSRType
extends
    Parseable[MktPSRType]
{
    val psrType = parse_element (element ("""MktPSRType.psrType"""))
    val TimeSeries = parse_attributes (attribute ("""MktPSRType.TimeSeries"""))
    def parse (context: Context): MktPSRType =
    {
        MktPSRType(
            PSRType.parse (context),
            psrType (context),
            TimeSeries (context)
        )
    }
}

/**
 * An identification of a time interval that may have a given resolution.
 *
 * @param sup Reference to the superclass object.
 * @param resolution The number of units of time that compose an individual step within a period.
 * @param timeInterval The start and end date and time for a given interval.
 * @param Reason [[ch.ninecode.model.Reason Reason]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class Period
(
    override val sup: BasicElement,
    resolution: String,
    timeInterval: String,
    Reason: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[Period] }
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
        (if (null != resolution) "\t\t<cim:Period.resolution>" + resolution + "</cim:Period.resolution>\n" else "") +
        (if (null != timeInterval) "\t\t<cim:Period.timeInterval rdf:resource=\"#" + timeInterval + "\"/>\n" else "") +
        (if (null != Reason) Reason.map (x => "\t\t<cim:Period.Reason rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:Period rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Period>"
    }
}

object Period
extends
    Parseable[Period]
{
    val resolution = parse_element (element ("""Period.resolution"""))
    val timeInterval = parse_attribute (attribute ("""Period.timeInterval"""))
    val Reason = parse_attributes (attribute ("""Period.Reason"""))
    def parse (context: Context): Period =
    {
        Period(
            BasicElement.parse (context),
            resolution (context),
            timeInterval (context),
            Reason (context)
        )
    }
}

/**
 * An identification of a set of values beeing adressed within a specific interval of time.
 *
 * @param sup Reference to the superclass object.
 * @param position A sequential value representing the relative position within a given time interval.
 * @param quality The quality of the information being provided.
 *        This quality may be estimated, not available, as provided, etc.
 * @param quantity Principal quantity identified for a point.
 * @param secondaryQuantity Secondary quantity identified for a point.
 * @param AceTariffType [[ch.ninecode.model.AceTariffType AceTariffType]] <em>undocumented</em>
 * @param Period [[ch.ninecode.model.Period Period]] <em>undocumented</em>
 * @param TimeSeries [[ch.ninecode.model.TimeSeries TimeSeries]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class Point
(
    override val sup: BasicElement,
    position: Int,
    quality: String,
    quantity: Double,
    secondaryQuantity: Double,
    AceTariffType: List[String],
    Period: String,
    TimeSeries: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0, null, 0.0, 0.0, List(), null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[Point] }
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
        "\t\t<cim:Point.position>" + position + "</cim:Point.position>\n" +
        (if (null != quality) "\t\t<cim:Point.quality>" + quality + "</cim:Point.quality>\n" else "") +
        "\t\t<cim:Point.quantity>" + quantity + "</cim:Point.quantity>\n" +
        "\t\t<cim:Point.secondaryQuantity>" + secondaryQuantity + "</cim:Point.secondaryQuantity>\n" +
        (if (null != AceTariffType) AceTariffType.map (x => "\t\t<cim:Point.AceTariffType rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != Period) "\t\t<cim:Point.Period rdf:resource=\"#" + Period + "\"/>\n" else "") +
        (if (null != TimeSeries) TimeSeries.map (x => "\t\t<cim:Point.TimeSeries rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:Point rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Point>"
    }
}

object Point
extends
    Parseable[Point]
{
    val position = parse_element (element ("""Point.position"""))
    val quality = parse_element (element ("""Point.quality"""))
    val quantity = parse_element (element ("""Point.quantity"""))
    val secondaryQuantity = parse_element (element ("""Point.secondaryQuantity"""))
    val AceTariffType = parse_attributes (attribute ("""Point.AceTariffType"""))
    val Period = parse_attribute (attribute ("""Point.Period"""))
    val TimeSeries = parse_attributes (attribute ("""Point.TimeSeries"""))
    def parse (context: Context): Point =
    {
        Point(
            BasicElement.parse (context),
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
 *
 * @param sup Reference to the superclass object.
 * @param amount A number of monetary units specified in a unit of currency.
 * @param category The category of a price to be used in a price calculation.
 *        The price category is mutually agreed between System Operators.
 * @param direction The direction indicates whether a System Operator pays the Market Parties or inverse.
 * @param Point [[ch.ninecode.model.Point Point]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class Price
(
    override val sup: BasicElement,
    amount: Double,
    category: String,
    direction: String,
    Point: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[Price] }
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
        "\t\t<cim:Price.amount>" + amount + "</cim:Price.amount>\n" +
        (if (null != category) "\t\t<cim:Price.category>" + category + "</cim:Price.category>\n" else "") +
        (if (null != direction) "\t\t<cim:Price.direction>" + direction + "</cim:Price.direction>\n" else "") +
        (if (null != Point) "\t\t<cim:Price.Point rdf:resource=\"#" + Point + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Price rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Price>"
    }
}

object Price
extends
    Parseable[Price]
{
    val amount = parse_element (element ("""Price.amount"""))
    val category = parse_element (element ("""Price.category"""))
    val direction = parse_element (element ("""Price.direction"""))
    val Point = parse_attribute (attribute ("""Price.Point"""))
    def parse (context: Context): Price =
    {
        Price(
            BasicElement.parse (context),
            toDouble (amount (context), context),
            category (context),
            direction (context),
            Point (context)
        )
    }
}

/**
 * The formal specification of a set of business transactions having the same business goal.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param classificationType The classification mechanism used to group a set of objects together within a business process.
 *        The grouping may be of a detailed or a summary nature.
 * @param processType The kind of business process.
 * @param MarketDocument [[ch.ninecode.model.MarketDocument MarketDocument]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class Process
(
    override val sup: IdentifiedObject,
    classificationType: String,
    processType: String,
    MarketDocument: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Process] }
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
        (if (null != classificationType) "\t\t<cim:Process.classificationType>" + classificationType + "</cim:Process.classificationType>\n" else "") +
        (if (null != processType) "\t\t<cim:Process.processType>" + processType + "</cim:Process.processType>\n" else "") +
        (if (null != MarketDocument) MarketDocument.map (x => "\t\t<cim:Process.MarketDocument rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:Process rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Process>"
    }
}

object Process
extends
    Parseable[Process]
{
    val classificationType = parse_element (element ("""Process.classificationType"""))
    val processType = parse_element (element ("""Process.processType"""))
    val MarketDocument = parse_attributes (attribute ("""Process.MarketDocument"""))
    def parse (context: Context): Process =
    {
        Process(
            IdentifiedObject.parse (context),
            classificationType (context),
            processType (context),
            MarketDocument (context)
        )
    }
}

/**
 * The motivation of an act.
 *
 * @param sup Reference to the superclass object.
 * @param code The motivation of an act in coded form.
 * @param text The textual explanation corresponding to the reason code.
 * @param MarketDocument [[ch.ninecode.model.MarketDocument MarketDocument]] <em>undocumented</em>
 * @param Point [[ch.ninecode.model.Point Point]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class Reason
(
    override val sup: BasicElement,
    code: String,
    text: String,
    MarketDocument: List[String],
    Point: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[Reason] }
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
        (if (null != code) "\t\t<cim:Reason.code>" + code + "</cim:Reason.code>\n" else "") +
        (if (null != text) "\t\t<cim:Reason.text>" + text + "</cim:Reason.text>\n" else "") +
        (if (null != MarketDocument) MarketDocument.map (x => "\t\t<cim:Reason.MarketDocument rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != Point) Point.map (x => "\t\t<cim:Reason.Point rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:Reason rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Reason>"
    }
}

object Reason
extends
    Parseable[Reason]
{
    val code = parse_element (element ("""Reason.code"""))
    val text = parse_element (element ("""Reason.text"""))
    val MarketDocument = parse_attributes (attribute ("""Reason.MarketDocument"""))
    val Point = parse_attributes (attribute ("""Reason.Point"""))
    def parse (context: Context): Reason =
    {
        Reason(
            BasicElement.parse (context),
            code (context),
            text (context),
            MarketDocument (context),
            Point (context)
        )
    }
}

/**
 * A set of regular time-ordered measurements or values of quantitative nature of an individual or collective phenomenon taken at successive, in most cases equidistant, periods / points of time.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param businessType The identification of the nature of the time series.
 * @param cancelledTS An indicator stating that the TimeSeries, identified by the mRID, is cancelled as well as all the values sent in a previous version of the TimeSeries in a previous document.
 * @param curveType The coded representation of the type of curve being described.
 * @param objectAggregation Identification of the object that is the common dominator used to aggregate a time series.
 * @param product The type of the product such as Power, energy, reactive power, transport capacity that is the subject of the time series.
 * @param version Version of the time series.
 * @param DateAndOrTime [[ch.ninecode.model.DateAndOrTime DateAndOrTime]] <em>undocumented</em>
 * @param Domain [[ch.ninecode.model.Domain Domain]] <em>undocumented</em>
 * @param FlowDirection [[ch.ninecode.model.FlowDirection FlowDirection]] <em>undocumented</em>
 * @param MarketDocument [[ch.ninecode.model.MarketDocument MarketDocument]] <em>undocumented</em>
 * @param MarketEvaluationPoint [[ch.ninecode.model.MarketEvaluationPoint MarketEvaluationPoint]] <em>undocumented</em>
 * @param MarketParticipant [[ch.ninecode.model.MarketParticipant MarketParticipant]] <em>undocumented</em>
 * @param Period [[ch.ninecode.model.Period Period]] <em>undocumented</em>
 * @param Reason [[ch.ninecode.model.Reason Reason]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class TimeSeries
(
    override val sup: IdentifiedObject,
    businessType: String,
    cancelledTS: String,
    curveType: String,
    objectAggregation: String,
    product: String,
    version: String,
    DateAndOrTime: List[String],
    Domain: List[String],
    FlowDirection: List[String],
    MarketDocument: List[String],
    MarketEvaluationPoint: List[String],
    MarketParticipant: List[String],
    Period: List[String],
    Reason: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null, List(), List(), List(), List(), List(), List(), List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[TimeSeries] }
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
        (if (null != businessType) "\t\t<cim:TimeSeries.businessType>" + businessType + "</cim:TimeSeries.businessType>\n" else "") +
        (if (null != cancelledTS) "\t\t<cim:TimeSeries.cancelledTS>" + cancelledTS + "</cim:TimeSeries.cancelledTS>\n" else "") +
        (if (null != curveType) "\t\t<cim:TimeSeries.curveType>" + curveType + "</cim:TimeSeries.curveType>\n" else "") +
        (if (null != objectAggregation) "\t\t<cim:TimeSeries.objectAggregation>" + objectAggregation + "</cim:TimeSeries.objectAggregation>\n" else "") +
        (if (null != product) "\t\t<cim:TimeSeries.product>" + product + "</cim:TimeSeries.product>\n" else "") +
        (if (null != version) "\t\t<cim:TimeSeries.version>" + version + "</cim:TimeSeries.version>\n" else "") +
        (if (null != DateAndOrTime) DateAndOrTime.map (x => "\t\t<cim:TimeSeries.DateAndOrTime rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != Domain) Domain.map (x => "\t\t<cim:TimeSeries.Domain rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != FlowDirection) FlowDirection.map (x => "\t\t<cim:TimeSeries.FlowDirection rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != MarketDocument) MarketDocument.map (x => "\t\t<cim:TimeSeries.MarketDocument rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != MarketEvaluationPoint) MarketEvaluationPoint.map (x => "\t\t<cim:TimeSeries.MarketEvaluationPoint rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != MarketParticipant) MarketParticipant.map (x => "\t\t<cim:TimeSeries.MarketParticipant rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != Period) Period.map (x => "\t\t<cim:TimeSeries.Period rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != Reason) Reason.map (x => "\t\t<cim:TimeSeries.Reason rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:TimeSeries rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TimeSeries>"
    }
}

object TimeSeries
extends
    Parseable[TimeSeries]
{
    val businessType = parse_element (element ("""TimeSeries.businessType"""))
    val cancelledTS = parse_element (element ("""TimeSeries.cancelledTS"""))
    val curveType = parse_element (element ("""TimeSeries.curveType"""))
    val objectAggregation = parse_element (element ("""TimeSeries.objectAggregation"""))
    val product = parse_element (element ("""TimeSeries.product"""))
    val version = parse_element (element ("""TimeSeries.version"""))
    val DateAndOrTime = parse_attributes (attribute ("""TimeSeries.DateAndOrTime"""))
    val Domain = parse_attributes (attribute ("""TimeSeries.Domain"""))
    val FlowDirection = parse_attributes (attribute ("""TimeSeries.FlowDirection"""))
    val MarketDocument = parse_attributes (attribute ("""TimeSeries.MarketDocument"""))
    val MarketEvaluationPoint = parse_attributes (attribute ("""TimeSeries.MarketEvaluationPoint"""))
    val MarketParticipant = parse_attributes (attribute ("""TimeSeries.MarketParticipant"""))
    val Period = parse_attributes (attribute ("""TimeSeries.Period"""))
    val Reason = parse_attributes (attribute ("""TimeSeries.Reason"""))
    def parse (context: Context): TimeSeries =
    {
        TimeSeries(
            IdentifiedObject.parse (context),
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
 *
 * @param sup Reference to the superclass object.
 * @param name The coded representation of the unit.
 * @param TimeSeries [[ch.ninecode.model.TimeSeries TimeSeries]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class Unit_
(
    override val sup: BasicElement,
    name: String,
    TimeSeries: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[Unit_] }
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
        (if (null != name) "\t\t<cim:Unit.name>" + name + "</cim:Unit.name>\n" else "") +
        (if (null != TimeSeries) TimeSeries.map (x => "\t\t<cim:Unit.TimeSeries rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:Unit rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Unit>"
    }
}

object Unit_
extends
    Parseable[Unit_]
{
    val name = parse_element (element ("""Unit_.name"""))
    val TimeSeries = parse_attributes (attribute ("""Unit_.TimeSeries"""))
    def parse (context: Context): Unit_ =
    {
        Unit_(
            BasicElement.parse (context),
            name (context),
            TimeSeries (context)
        )
    }
}

private[ninecode] object _MarketManagement
{
    def register: List[ClassInfo] =
    {
        List (
            AceTariffType.register,
            AttributeInstanceComponent.register,
            Auction.register,
            BidTimeSeries.register,
            DateAndOrTime.register,
            Domain.register,
            FlowDirection.register,
            MarketAgreement.register,
            MarketDocument.register,
            MarketEvaluationPoint.register,
            MarketObjectStatus.register,
            MktPSRType.register,
            Period.register,
            Point.register,
            Price.register,
            Process.register,
            Reason.register,
            TimeSeries.register,
            Unit_.register
        )
    }
}