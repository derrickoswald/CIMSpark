package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Action request against an existing Trade.
 *
 * @param sup Reference to the superclass object.
 * @param actionName Action name type for the action request.
 * @group ParticipantInterfaces
 * @groupname ParticipantInterfaces Package ParticipantInterfaces
 * @groupdesc ParticipantInterfaces Market participant interfaces for bids and trades.
 */
case class ActionRequest
(
    override val sup: BasicElement,
    actionName: String
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
    override def copy (): Row = { clone ().asInstanceOf[ActionRequest] }
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
        implicit val clz: String = ActionRequest.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ActionRequest.fields (position), value)
        emitattr (0, actionName)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ActionRequest rdf:ID=\"%s\">\n%s\t</cim:ActionRequest>".format (id, export_fields)
    }
}

object ActionRequest
extends
    Parseable[ActionRequest]
{
    val fields: Array[String] = Array[String] (
        "actionName"
    )
    val actionName: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): ActionRequest =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ActionRequest (
            BasicElement.parse (context),
            mask (actionName (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * AreaLoadBid is not submitted by a market participant into the Markets.
 *
 * Instead, it is simply an aggregation of all LoadBids contained wtihin a specific SubControlArea. This entity should inherit from Bid for representation of the timeframe (startTime, stopTime) and the market type.
 *
 * @param sup [[ch.ninecode.model.Bid Bid]] Reference to the superclass object.
 * @param demandBidMW The Demand Bid Megawatt for the area case.
 *        Attribute Usage: This is Scheduled demand MW in Day Ahead
 * @group ParticipantInterfaces
 * @groupname ParticipantInterfaces Package ParticipantInterfaces
 * @groupdesc ParticipantInterfaces Market participant interfaces for bids and trades.
 */
case class AreaLoadBid
(
    override val sup: Bid,
    demandBidMW: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Bid: Bid = sup.asInstanceOf[Bid]
    override def copy (): Row = { clone ().asInstanceOf[AreaLoadBid] }
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
        implicit val clz: String = AreaLoadBid.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AreaLoadBid.fields (position), value)
        emitelem (0, demandBidMW)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AreaLoadBid rdf:ID=\"%s\">\n%s\t</cim:AreaLoadBid>".format (id, export_fields)
    }
}

object AreaLoadBid
extends
    Parseable[AreaLoadBid]
{
    val fields: Array[String] = Array[String] (
        "demandBidMW"
    )
    val demandBidMW: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): AreaLoadBid =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = AreaLoadBid (
            Bid.parse (context),
            toDouble (mask (demandBidMW (), 0))
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Property for a particular attribute that contains name and value
 *
 * @param sup Reference to the superclass object.
 * @param propertyName <em>undocumented</em>
 * @param propertyValue <em>undocumented</em>
 * @param sequence <em>undocumented</em>
 * @param MktUserAttribute [[ch.ninecode.model.MktUserAttribute MktUserAttribute]] <em>undocumented</em>
 * @group ParticipantInterfaces
 * @groupname ParticipantInterfaces Package ParticipantInterfaces
 * @groupdesc ParticipantInterfaces Market participant interfaces for bids and trades.
 */
case class AttributeProperty
(
    override val sup: BasicElement,
    propertyName: String,
    propertyValue: String,
    sequence: String,
    MktUserAttribute: String
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
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[AttributeProperty] }
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
        implicit val clz: String = AttributeProperty.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AttributeProperty.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AttributeProperty.fields (position), value)
        emitelem (0, propertyName)
        emitelem (1, propertyValue)
        emitelem (2, sequence)
        emitattr (3, MktUserAttribute)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AttributeProperty rdf:ID=\"%s\">\n%s\t</cim:AttributeProperty>".format (id, export_fields)
    }
}

object AttributeProperty
extends
    Parseable[AttributeProperty]
{
    val fields: Array[String] = Array[String] (
        "propertyName",
        "propertyValue",
        "sequence",
        "MktUserAttribute"
    )
    val propertyName: Fielder = parse_element (element (cls, fields(0)))
    val propertyValue: Fielder = parse_element (element (cls, fields(1)))
    val sequence: Fielder = parse_element (element (cls, fields(2)))
    val MktUserAttribute: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): AttributeProperty =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = AttributeProperty (
            BasicElement.parse (context),
            mask (propertyName (), 0),
            mask (propertyValue (), 1),
            mask (sequence (), 2),
            mask (MktUserAttribute (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("MktUserAttribute", "MktUserAttribute", false)
    )
}

/**
 * Represents both bids to purchase and offers to sell energy or ancillary services in an RTO-sponsored market.
 *
 * @param sup [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param marketType The market type, DAM or RTM.
 * @param startTime Start time and date for which bid applies.
 * @param stopTime Stop time and date for which bid is applicable.
 * @param ActionRequest [[ch.ninecode.model.ActionRequest ActionRequest]] <em>undocumented</em>
 * @param EnergyMarket [[ch.ninecode.model.EnergyMarket EnergyMarket]] <em>undocumented</em>
 * @param MarketParticipant [[ch.ninecode.model.MarketParticipant MarketParticipant]] <em>undocumented</em>
 * @param SchedulingCoordinator [[ch.ninecode.model.SchedulingCoordinator SchedulingCoordinator]] <em>undocumented</em>
 * @group ParticipantInterfaces
 * @groupname ParticipantInterfaces Package ParticipantInterfaces
 * @groupdesc ParticipantInterfaces Market participant interfaces for bids and trades.
 */
case class Bid
(
    override val sup: Document,
    marketType: String,
    startTime: String,
    stopTime: String,
    ActionRequest: String,
    EnergyMarket: String,
    MarketParticipant: String,
    SchedulingCoordinator: String
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
    override def copy (): Row = { clone ().asInstanceOf[Bid] }
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
        implicit val clz: String = Bid.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Bid.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Bid.fields (position), value)
        emitattr (0, marketType)
        emitelem (1, startTime)
        emitelem (2, stopTime)
        emitattr (3, ActionRequest)
        emitattr (4, EnergyMarket)
        emitattr (5, MarketParticipant)
        emitattr (6, SchedulingCoordinator)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Bid rdf:ID=\"%s\">\n%s\t</cim:Bid>".format (id, export_fields)
    }
}

object Bid
extends
    Parseable[Bid]
{
    val fields: Array[String] = Array[String] (
        "marketType",
        "startTime",
        "stopTime",
        "ActionRequest",
        "EnergyMarket",
        "MarketParticipant",
        "SchedulingCoordinator"
    )
    val marketType: Fielder = parse_attribute (attribute (cls, fields(0)))
    val startTime: Fielder = parse_element (element (cls, fields(1)))
    val stopTime: Fielder = parse_element (element (cls, fields(2)))
    val ActionRequest: Fielder = parse_attribute (attribute (cls, fields(3)))
    val EnergyMarket: Fielder = parse_attribute (attribute (cls, fields(4)))
    val MarketParticipant: Fielder = parse_attribute (attribute (cls, fields(5)))
    val SchedulingCoordinator: Fielder = parse_attribute (attribute (cls, fields(6)))

    def parse (context: Context): Bid =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Bid (
            Document.parse (context),
            mask (marketType (), 0),
            mask (startTime (), 1),
            mask (stopTime (), 2),
            mask (ActionRequest (), 3),
            mask (EnergyMarket (), 4),
            mask (MarketParticipant (), 5),
            mask (SchedulingCoordinator (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ActionRequest", "ActionRequest", false),
        Relationship ("EnergyMarket", "EnergyMarket", false),
        Relationship ("MarketParticipant", "MarketParticipant", false),
        Relationship ("SchedulingCoordinator", "SchedulingCoordinator", false)
    )
}

/**
 * This class allows SC to input different time intervals for distribution factors
 *
 * @param sup Reference to the superclass object.
 * @param timeIntervalEnd End of the time interval n which bid is valid (yyyy-mm-dd hh24: mi: ss)
 * @param timeIntervalStart Start of the time interval in which bid is valid (yyyy-mm-dd hh24: mi: ss).
 * @param ProductBid [[ch.ninecode.model.ProductBid ProductBid]] <em>undocumented</em>
 * @group ParticipantInterfaces
 * @groupname ParticipantInterfaces Package ParticipantInterfaces
 * @groupdesc ParticipantInterfaces Market participant interfaces for bids and trades.
 */
case class BidDistributionFactor
(
    override val sup: BasicElement,
    timeIntervalEnd: String,
    timeIntervalStart: String,
    ProductBid: String
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
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[BidDistributionFactor] }
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
        implicit val clz: String = BidDistributionFactor.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (BidDistributionFactor.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (BidDistributionFactor.fields (position), value)
        emitelem (0, timeIntervalEnd)
        emitelem (1, timeIntervalStart)
        emitattr (2, ProductBid)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:BidDistributionFactor rdf:ID=\"%s\">\n%s\t</cim:BidDistributionFactor>".format (id, export_fields)
    }
}

object BidDistributionFactor
extends
    Parseable[BidDistributionFactor]
{
    val fields: Array[String] = Array[String] (
        "timeIntervalEnd",
        "timeIntervalStart",
        "ProductBid"
    )
    val timeIntervalEnd: Fielder = parse_element (element (cls, fields(0)))
    val timeIntervalStart: Fielder = parse_element (element (cls, fields(1)))
    val ProductBid: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): BidDistributionFactor =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = BidDistributionFactor (
            BasicElement.parse (context),
            mask (timeIntervalEnd (), 0),
            mask (timeIntervalStart (), 1),
            mask (ProductBid (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ProductBid", "ProductBid", false)
    )
}

/**
 * This class represent the error information for a bid that is detected during bid validation
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param componentType <em>undocumented</em>
 * @param endTime hour wihthin the bid for which the error applies
 * @param errMessage error message
 * @param errPriority Priority number for the error message
 * @param logTimeStamp <em>undocumented</em>
 * @param msgLevel <em>undocumented</em>
 * @param ruleID <em>undocumented</em>
 * @param startTime hour wihthin the bid for which the error applies
 * @param MarketProduct [[ch.ninecode.model.MarketProduct MarketProduct]] <em>undocumented</em>
 * @group ParticipantInterfaces
 * @groupname ParticipantInterfaces Package ParticipantInterfaces
 * @groupdesc ParticipantInterfaces Market participant interfaces for bids and trades.
 */
case class BidError
(
    override val sup: IdentifiedObject,
    componentType: String,
    endTime: String,
    errMessage: String,
    errPriority: Int,
    logTimeStamp: String,
    msgLevel: Int,
    ruleID: Int,
    startTime: String,
    MarketProduct: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, 0, null, 0, 0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[BidError] }
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
        implicit val clz: String = BidError.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (BidError.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (BidError.fields (position), value)
        emitelem (0, componentType)
        emitelem (1, endTime)
        emitelem (2, errMessage)
        emitelem (3, errPriority)
        emitelem (4, logTimeStamp)
        emitelem (5, msgLevel)
        emitelem (6, ruleID)
        emitelem (7, startTime)
        emitattr (8, MarketProduct)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:BidError rdf:ID=\"%s\">\n%s\t</cim:BidError>".format (id, export_fields)
    }
}

object BidError
extends
    Parseable[BidError]
{
    val fields: Array[String] = Array[String] (
        "componentType",
        "endTime",
        "errMessage",
        "errPriority",
        "logTimeStamp",
        "msgLevel",
        "ruleID",
        "startTime",
        "MarketProduct"
    )
    val componentType: Fielder = parse_element (element (cls, fields(0)))
    val endTime: Fielder = parse_element (element (cls, fields(1)))
    val errMessage: Fielder = parse_element (element (cls, fields(2)))
    val errPriority: Fielder = parse_element (element (cls, fields(3)))
    val logTimeStamp: Fielder = parse_element (element (cls, fields(4)))
    val msgLevel: Fielder = parse_element (element (cls, fields(5)))
    val ruleID: Fielder = parse_element (element (cls, fields(6)))
    val startTime: Fielder = parse_element (element (cls, fields(7)))
    val MarketProduct: Fielder = parse_attribute (attribute (cls, fields(8)))

    def parse (context: Context): BidError =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = BidError (
            IdentifiedObject.parse (context),
            mask (componentType (), 0),
            mask (endTime (), 1),
            mask (errMessage (), 2),
            toInteger (mask (errPriority (), 3)),
            mask (logTimeStamp (), 4),
            toInteger (mask (msgLevel (), 5)),
            toInteger (mask (ruleID (), 6)),
            mask (startTime (), 7),
            mask (MarketProduct (), 8)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("MarketProduct", "MarketProduct", false)
    )
}

/**
 * Containment for bid parameters that are dependent on a market product type.
 *
 * @param sup [[ch.ninecode.model.RegularIntervalSchedule RegularIntervalSchedule]] Reference to the superclass object.
 * @param ProductBid [[ch.ninecode.model.ProductBid ProductBid]] <em>undocumented</em>
 * @group ParticipantInterfaces
 * @groupname ParticipantInterfaces Package ParticipantInterfaces
 * @groupdesc ParticipantInterfaces Market participant interfaces for bids and trades.
 */
case class BidHourlyProductSchedule
(
    override val sup: RegularIntervalSchedule,
    ProductBid: String
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
    def RegularIntervalSchedule: RegularIntervalSchedule = sup.asInstanceOf[RegularIntervalSchedule]
    override def copy (): Row = { clone ().asInstanceOf[BidHourlyProductSchedule] }
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
        implicit val clz: String = BidHourlyProductSchedule.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (BidHourlyProductSchedule.fields (position), value)
        emitattr (0, ProductBid)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:BidHourlyProductSchedule rdf:ID=\"%s\">\n%s\t</cim:BidHourlyProductSchedule>".format (id, export_fields)
    }
}

object BidHourlyProductSchedule
extends
    Parseable[BidHourlyProductSchedule]
{
    val fields: Array[String] = Array[String] (
        "ProductBid"
    )
    val ProductBid: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): BidHourlyProductSchedule =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = BidHourlyProductSchedule (
            RegularIntervalSchedule.parse (context),
            mask (ProductBid (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ProductBid", "ProductBid", false)
    )
}

/**
 * Containment for bid hourly parameters that are not product dependent.
 *
 * @param sup [[ch.ninecode.model.RegularIntervalSchedule RegularIntervalSchedule]] Reference to the superclass object.
 * @param Bid [[ch.ninecode.model.Bid Bid]] <em>undocumented</em>
 * @group ParticipantInterfaces
 * @groupname ParticipantInterfaces Package ParticipantInterfaces
 * @groupdesc ParticipantInterfaces Market participant interfaces for bids and trades.
 */
case class BidHourlySchedule
(
    override val sup: RegularIntervalSchedule,
    Bid: String
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
    def RegularIntervalSchedule: RegularIntervalSchedule = sup.asInstanceOf[RegularIntervalSchedule]
    override def copy (): Row = { clone ().asInstanceOf[BidHourlySchedule] }
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
        implicit val clz: String = BidHourlySchedule.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (BidHourlySchedule.fields (position), value)
        emitattr (0, Bid)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:BidHourlySchedule rdf:ID=\"%s\">\n%s\t</cim:BidHourlySchedule>".format (id, export_fields)
    }
}

object BidHourlySchedule
extends
    Parseable[BidHourlySchedule]
{
    val fields: Array[String] = Array[String] (
        "Bid"
    )
    val Bid: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): BidHourlySchedule =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = BidHourlySchedule (
            RegularIntervalSchedule.parse (context),
            mask (Bid (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Bid", "Bid", false)
    )
}

/**
 * Relationship between unit operating price in \$/hour (Y-axis) and unit output in MW (X-axis).
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @group ParticipantInterfaces
 * @groupname ParticipantInterfaces Package ParticipantInterfaces
 * @groupdesc ParticipantInterfaces Market participant interfaces for bids and trades.
 */
case class BidPriceCurve
(
    override val sup: Curve
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
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[BidPriceCurve] }
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:BidPriceCurve rdf:ID=\"%s\">\n%s\t</cim:BidPriceCurve>".format (id, export_fields)
    }
}

object BidPriceCurve
extends
    Parseable[BidPriceCurve]
{

    def parse (context: Context): BidPriceCurve =
    {
        implicit val ctx: Context = context
        val ret = BidPriceCurve (
            Curve.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Defines bid schedules to allow a product bid to use specified bid price curves for different time intervals.
 *
 * @param sup [[ch.ninecode.model.RegularIntervalSchedule RegularIntervalSchedule]] Reference to the superclass object.
 * @param bidType BID Type:
 *        
 *        I - Initial Bid;
 *        F - Final Bid
 * @param mitigationStatus Mitigation Status:
 *        
 *        'S' - Mitigated by SMPM because of "misconduct"
 *        'L; - Mitigated by LMPM because of "misconduct"
 *        'R' - Modified by LMPM because of RMR rules
 *        'M' - Mitigated because of "misconduct" both by SMPM and LMPM
 *        'B' - Mitigated because of "misconduct" both by SMPM and modified by LMLM because of RMR rules
 *        'O' - original
 * @param BidPriceCurve [[ch.ninecode.model.BidPriceCurve BidPriceCurve]] <em>undocumented</em>
 * @param ProductBid [[ch.ninecode.model.ProductBid ProductBid]] <em>undocumented</em>
 * @group ParticipantInterfaces
 * @groupname ParticipantInterfaces Package ParticipantInterfaces
 * @groupdesc ParticipantInterfaces Market participant interfaces for bids and trades.
 */
case class BidPriceSchedule
(
    override val sup: RegularIntervalSchedule,
    bidType: String,
    mitigationStatus: String,
    BidPriceCurve: String,
    ProductBid: String
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
    def RegularIntervalSchedule: RegularIntervalSchedule = sup.asInstanceOf[RegularIntervalSchedule]
    override def copy (): Row = { clone ().asInstanceOf[BidPriceSchedule] }
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
        implicit val clz: String = BidPriceSchedule.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (BidPriceSchedule.fields (position), value)
        emitattr (0, bidType)
        emitattr (1, mitigationStatus)
        emitattr (2, BidPriceCurve)
        emitattr (3, ProductBid)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:BidPriceSchedule rdf:ID=\"%s\">\n%s\t</cim:BidPriceSchedule>".format (id, export_fields)
    }
}

object BidPriceSchedule
extends
    Parseable[BidPriceSchedule]
{
    val fields: Array[String] = Array[String] (
        "bidType",
        "mitigationStatus",
        "BidPriceCurve",
        "ProductBid"
    )
    val bidType: Fielder = parse_attribute (attribute (cls, fields(0)))
    val mitigationStatus: Fielder = parse_attribute (attribute (cls, fields(1)))
    val BidPriceCurve: Fielder = parse_attribute (attribute (cls, fields(2)))
    val ProductBid: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): BidPriceSchedule =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = BidPriceSchedule (
            RegularIntervalSchedule.parse (context),
            mask (bidType (), 0),
            mask (mitigationStatus (), 1),
            mask (BidPriceCurve (), 2),
            mask (ProductBid (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("BidPriceCurve", "BidPriceCurve", false),
        Relationship ("ProductBid", "ProductBid", false)
    )
}

/**
 * Defines self schedule values to be used for specified time intervals.
 *
 * @param sup [[ch.ninecode.model.RegularIntervalSchedule RegularIntervalSchedule]] Reference to the superclass object.
 * @param balancingFlag This is a Y/N flag for a self-schedule of a resource per market per date and hour, using a specific TR ID.
 *        It indicates whether a self-schedule using a TR is balanced with another self-schedule using the same TR ID.
 * @param bidType bidType has two types as the required output of requirements and qualified pre-dispatch.
 * @param priorityFlag This is a Y/N flag for a self-schedule of a resource per market per date and hour, using a specific TR ID.
 *        It indicates whether a self-schedule using a TR has scheduling priority in DAM/RTM.
 * @param pumpSelfSchedMw Contains the PriceTaker, ExistingTransmissionContract, TransmissionOwnershipRights pumping self schedule quantity.
 *        If this value is not null, then the unit is in pumping mode.
 * @param referenceType Indication of which type of self schedule is being referenced.
 * @param selfSchedMw Self scheduled value
 * @param selfSchedSptResource Price Taker Export Self Sched Support Resource
 * @param selfSchedType This attribute is used to specify if a bid includes a self sched bid.
 *        If so what self sched type is it. The possible values are shown as follow but not limited to:
 * @param updateType <em>undocumented</em>
 * @param wheelingTransactionReference A unique identifier of a wheeling transaction.
 *        A wheeling transaction is a balanced Energy exchange among Supply and Demand Resources.
 * @param AdjacentCASet [[ch.ninecode.model.AdjacentCASet AdjacentCASet]] <em>undocumented</em>
 * @param HostControlArea [[ch.ninecode.model.HostControlArea HostControlArea]] <em>undocumented</em>
 * @param ProductBid [[ch.ninecode.model.ProductBid ProductBid]] <em>undocumented</em>
 * @param SubControlArea [[ch.ninecode.model.SubControlArea SubControlArea]] <em>undocumented</em>
 * @param TransmissionContractRight [[ch.ninecode.model.ContractRight ContractRight]] <em>undocumented</em>
 * @group ParticipantInterfaces
 * @groupname ParticipantInterfaces Package ParticipantInterfaces
 * @groupdesc ParticipantInterfaces Market participant interfaces for bids and trades.
 */
case class BidSelfSched
(
    override val sup: RegularIntervalSchedule,
    balancingFlag: String,
    bidType: String,
    priorityFlag: String,
    pumpSelfSchedMw: Double,
    referenceType: String,
    selfSchedMw: Double,
    selfSchedSptResource: String,
    selfSchedType: String,
    updateType: String,
    wheelingTransactionReference: String,
    AdjacentCASet: String,
    HostControlArea: String,
    ProductBid: String,
    SubControlArea: String,
    TransmissionContractRight: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, 0.0, null, 0.0, null, null, null, null, null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def RegularIntervalSchedule: RegularIntervalSchedule = sup.asInstanceOf[RegularIntervalSchedule]
    override def copy (): Row = { clone ().asInstanceOf[BidSelfSched] }
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
        implicit val clz: String = BidSelfSched.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (BidSelfSched.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (BidSelfSched.fields (position), value)
        emitattr (0, balancingFlag)
        emitattr (1, bidType)
        emitattr (2, priorityFlag)
        emitelem (3, pumpSelfSchedMw)
        emitattr (4, referenceType)
        emitelem (5, selfSchedMw)
        emitelem (6, selfSchedSptResource)
        emitattr (7, selfSchedType)
        emitattr (8, updateType)
        emitelem (9, wheelingTransactionReference)
        emitattr (10, AdjacentCASet)
        emitattr (11, HostControlArea)
        emitattr (12, ProductBid)
        emitattr (13, SubControlArea)
        emitattr (14, TransmissionContractRight)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:BidSelfSched rdf:ID=\"%s\">\n%s\t</cim:BidSelfSched>".format (id, export_fields)
    }
}

object BidSelfSched
extends
    Parseable[BidSelfSched]
{
    val fields: Array[String] = Array[String] (
        "balancingFlag",
        "bidType",
        "priorityFlag",
        "pumpSelfSchedMw",
        "referenceType",
        "selfSchedMw",
        "selfSchedSptResource",
        "selfSchedType",
        "updateType",
        "wheelingTransactionReference",
        "AdjacentCASet",
        "HostControlArea",
        "ProductBid",
        "SubControlArea",
        "TransmissionContractRight"
    )
    val balancingFlag: Fielder = parse_attribute (attribute (cls, fields(0)))
    val bidType: Fielder = parse_attribute (attribute (cls, fields(1)))
    val priorityFlag: Fielder = parse_attribute (attribute (cls, fields(2)))
    val pumpSelfSchedMw: Fielder = parse_element (element (cls, fields(3)))
    val referenceType: Fielder = parse_attribute (attribute (cls, fields(4)))
    val selfSchedMw: Fielder = parse_element (element (cls, fields(5)))
    val selfSchedSptResource: Fielder = parse_element (element (cls, fields(6)))
    val selfSchedType: Fielder = parse_attribute (attribute (cls, fields(7)))
    val updateType: Fielder = parse_attribute (attribute (cls, fields(8)))
    val wheelingTransactionReference: Fielder = parse_element (element (cls, fields(9)))
    val AdjacentCASet: Fielder = parse_attribute (attribute (cls, fields(10)))
    val HostControlArea: Fielder = parse_attribute (attribute (cls, fields(11)))
    val ProductBid: Fielder = parse_attribute (attribute (cls, fields(12)))
    val SubControlArea: Fielder = parse_attribute (attribute (cls, fields(13)))
    val TransmissionContractRight: Fielder = parse_attribute (attribute (cls, fields(14)))

    def parse (context: Context): BidSelfSched =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = BidSelfSched (
            RegularIntervalSchedule.parse (context),
            mask (balancingFlag (), 0),
            mask (bidType (), 1),
            mask (priorityFlag (), 2),
            toDouble (mask (pumpSelfSchedMw (), 3)),
            mask (referenceType (), 4),
            toDouble (mask (selfSchedMw (), 5)),
            mask (selfSchedSptResource (), 6),
            mask (selfSchedType (), 7),
            mask (updateType (), 8),
            mask (wheelingTransactionReference (), 9),
            mask (AdjacentCASet (), 10),
            mask (HostControlArea (), 11),
            mask (ProductBid (), 12),
            mask (SubControlArea (), 13),
            mask (TransmissionContractRight (), 14)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("AdjacentCASet", "AdjacentCASet", false),
        Relationship ("HostControlArea", "HostControlArea", false),
        Relationship ("ProductBid", "ProductBid", false),
        Relationship ("SubControlArea", "SubControlArea", false),
        Relationship ("TransmissionContractRight", "ContractRight", false)
    )
}

/**
 * As set of mutually exclusive bids for which a maximum of one may be scheduled.
 *
 * Of these generating bids, only one generating bid can be scheduled at a time.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @group ParticipantInterfaces
 * @groupname ParticipantInterfaces Package ParticipantInterfaces
 * @groupdesc ParticipantInterfaces Market participant interfaces for bids and trades.
 */
case class BidSet
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
    override def copy (): Row = { clone ().asInstanceOf[BidSet] }
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:BidSet rdf:ID=\"%s\">\n%s\t</cim:BidSet>".format (id, export_fields)
    }
}

object BidSet
extends
    Parseable[BidSet]
{

    def parse (context: Context): BidSet =
    {
        implicit val ctx: Context = context
        val ret = BidSet (
            IdentifiedObject.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * A Charge Component is a list of configurable charge quality items to feed into settlement calculation and/or bill determinants.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param deleteStatus <em>undocumented</em>
 * @param effectiveDate <em>undocumented</em>
 * @param equation <em>undocumented</em>
 * @param message <em>undocumented</em>
 * @param roundOff <em>undocumented</em>
 * @param sum <em>undocumented</em>
 * @param terminationDate <em>undocumented</em>
 * @param typ <em>undocumented</em>
 * @param BillDeterminants [[ch.ninecode.model.BillDeterminant BillDeterminant]] A BillDeterminant can have 0-n ChargeComponent and a ChargeComponent can associate to 0-n BillDeterminant.
 * @group ParticipantInterfaces
 * @groupname ParticipantInterfaces Package ParticipantInterfaces
 * @groupdesc ParticipantInterfaces Market participant interfaces for bids and trades.
 */
case class ChargeComponent
(
    override val sup: IdentifiedObject,
    deleteStatus: String,
    effectiveDate: String,
    equation: String,
    message: String,
    roundOff: String,
    sum: String,
    terminationDate: String,
    typ: String,
    BillDeterminants: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null, null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ChargeComponent] }
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
        implicit val clz: String = ChargeComponent.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ChargeComponent.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (ChargeComponent.fields (position), x))
        emitelem (0, deleteStatus)
        emitelem (1, effectiveDate)
        emitelem (2, equation)
        emitelem (3, message)
        emitelem (4, roundOff)
        emitelem (5, sum)
        emitelem (6, terminationDate)
        emitelem (7, typ)
        emitattrs (8, BillDeterminants)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ChargeComponent rdf:ID=\"%s\">\n%s\t</cim:ChargeComponent>".format (id, export_fields)
    }
}

object ChargeComponent
extends
    Parseable[ChargeComponent]
{
    val fields: Array[String] = Array[String] (
        "deleteStatus",
        "effectiveDate",
        "equation",
        "message",
        "roundOff",
        "sum",
        "terminationDate",
        "type",
        "BillDeterminants"
    )
    val deleteStatus: Fielder = parse_element (element (cls, fields(0)))
    val effectiveDate: Fielder = parse_element (element (cls, fields(1)))
    val equation: Fielder = parse_element (element (cls, fields(2)))
    val message: Fielder = parse_element (element (cls, fields(3)))
    val roundOff: Fielder = parse_element (element (cls, fields(4)))
    val sum: Fielder = parse_element (element (cls, fields(5)))
    val terminationDate: Fielder = parse_element (element (cls, fields(6)))
    val typ: Fielder = parse_element (element (cls, fields(7)))
    val BillDeterminants: FielderMultiple = parse_attributes (attribute (cls, fields(8)))

    def parse (context: Context): ChargeComponent =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ChargeComponent (
            IdentifiedObject.parse (context),
            mask (deleteStatus (), 0),
            mask (effectiveDate (), 1),
            mask (equation (), 2),
            mask (message (), 3),
            mask (roundOff (), 4),
            mask (sum (), 5),
            mask (terminationDate (), 6),
            mask (typ (), 7),
            masks (BillDeterminants (), 8)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("BillDeterminants", "BillDeterminant", true)
    )
}

/**
 * Charge Group is the grouping of Charge Types for settlement invoicing purpose.
 *
 * Examples such as Ancillary Services, Interests, etc.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param effectiveDate <em>undocumented</em>
 * @param marketCode <em>undocumented</em>
 * @param terminationDate <em>undocumented</em>
 * @param ChargeGroupParent [[ch.ninecode.model.ChargeGroup ChargeGroup]] A ChargeGroup instance can have relationships with other ChargeGroup instances.
 * @param MktUserAttribute [[ch.ninecode.model.MktUserAttribute MktUserAttribute]] <em>undocumented</em>
 * @group ParticipantInterfaces
 * @groupname ParticipantInterfaces Package ParticipantInterfaces
 * @groupdesc ParticipantInterfaces Market participant interfaces for bids and trades.
 */
case class ChargeGroup
(
    override val sup: IdentifiedObject,
    effectiveDate: String,
    marketCode: String,
    terminationDate: String,
    ChargeGroupParent: String,
    MktUserAttribute: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ChargeGroup] }
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
        implicit val clz: String = ChargeGroup.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ChargeGroup.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ChargeGroup.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (ChargeGroup.fields (position), x))
        emitelem (0, effectiveDate)
        emitelem (1, marketCode)
        emitelem (2, terminationDate)
        emitattr (3, ChargeGroupParent)
        emitattrs (4, MktUserAttribute)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ChargeGroup rdf:ID=\"%s\">\n%s\t</cim:ChargeGroup>".format (id, export_fields)
    }
}

object ChargeGroup
extends
    Parseable[ChargeGroup]
{
    val fields: Array[String] = Array[String] (
        "effectiveDate",
        "marketCode",
        "terminationDate",
        "ChargeGroupParent",
        "MktUserAttribute"
    )
    val effectiveDate: Fielder = parse_element (element (cls, fields(0)))
    val marketCode: Fielder = parse_element (element (cls, fields(1)))
    val terminationDate: Fielder = parse_element (element (cls, fields(2)))
    val ChargeGroupParent: Fielder = parse_attribute (attribute (cls, fields(3)))
    val MktUserAttribute: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: Context): ChargeGroup =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ChargeGroup (
            IdentifiedObject.parse (context),
            mask (effectiveDate (), 0),
            mask (marketCode (), 1),
            mask (terminationDate (), 2),
            mask (ChargeGroupParent (), 3),
            masks (MktUserAttribute (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ChargeGroupParent", "ChargeGroup", false),
        Relationship ("MktUserAttribute", "MktUserAttribute", true)
    )
}

/**
 * Charge Type is the basic level configuration for settlement to process specific charges for invoicing purpose.
 *
 * Examples such as: Day Ahead Spinning Reserve Default Invoice Interest Charge, etc.
 *
 * @param sup [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param chargeOrder <em>undocumented</em>
 * @param chargeVersion <em>undocumented</em>
 * @param effectiveDate <em>undocumented</em>
 * @param factor <em>undocumented</em>
 * @param frequencyType <em>undocumented</em>
 * @param terminationDate <em>undocumented</em>
 * @param totalInterval <em>undocumented</em>
 * @param ChargeComponents [[ch.ninecode.model.ChargeComponent ChargeComponent]] A ChargeType can have 0-n ChargeComponent and a ChargeComponent can associate to 0-n ChargeType
 * @param ChargeGroup [[ch.ninecode.model.ChargeGroup ChargeGroup]] A ChargeGroup can have 0-n ChargeType.
 *        A ChargeType can associate to 0-n ChargeGroup.
 * @param MktUserAttribute [[ch.ninecode.model.MktUserAttribute MktUserAttribute]] <em>undocumented</em>
 * @group ParticipantInterfaces
 * @groupname ParticipantInterfaces Package ParticipantInterfaces
 * @groupdesc ParticipantInterfaces Market participant interfaces for bids and trades.
 */
case class ChargeType
(
    override val sup: Document,
    chargeOrder: String,
    chargeVersion: String,
    effectiveDate: String,
    factor: String,
    frequencyType: String,
    terminationDate: String,
    totalInterval: String,
    ChargeComponents: List[String],
    ChargeGroup: List[String],
    MktUserAttribute: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null, null, List(), List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[ChargeType] }
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
        implicit val clz: String = ChargeType.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ChargeType.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (ChargeType.fields (position), x))
        emitelem (0, chargeOrder)
        emitelem (1, chargeVersion)
        emitelem (2, effectiveDate)
        emitelem (3, factor)
        emitelem (4, frequencyType)
        emitelem (5, terminationDate)
        emitelem (6, totalInterval)
        emitattrs (7, ChargeComponents)
        emitattrs (8, ChargeGroup)
        emitattrs (9, MktUserAttribute)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ChargeType rdf:ID=\"%s\">\n%s\t</cim:ChargeType>".format (id, export_fields)
    }
}

object ChargeType
extends
    Parseable[ChargeType]
{
    val fields: Array[String] = Array[String] (
        "chargeOrder",
        "chargeVersion",
        "effectiveDate",
        "factor",
        "frequencyType",
        "terminationDate",
        "totalInterval",
        "ChargeComponents",
        "ChargeGroup",
        "MktUserAttribute"
    )
    val chargeOrder: Fielder = parse_element (element (cls, fields(0)))
    val chargeVersion: Fielder = parse_element (element (cls, fields(1)))
    val effectiveDate: Fielder = parse_element (element (cls, fields(2)))
    val factor: Fielder = parse_element (element (cls, fields(3)))
    val frequencyType: Fielder = parse_element (element (cls, fields(4)))
    val terminationDate: Fielder = parse_element (element (cls, fields(5)))
    val totalInterval: Fielder = parse_element (element (cls, fields(6)))
    val ChargeComponents: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val ChargeGroup: FielderMultiple = parse_attributes (attribute (cls, fields(8)))
    val MktUserAttribute: FielderMultiple = parse_attributes (attribute (cls, fields(9)))

    def parse (context: Context): ChargeType =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ChargeType (
            Document.parse (context),
            mask (chargeOrder (), 0),
            mask (chargeVersion (), 1),
            mask (effectiveDate (), 2),
            mask (factor (), 3),
            mask (frequencyType (), 4),
            mask (terminationDate (), 5),
            mask (totalInterval (), 6),
            masks (ChargeComponents (), 7),
            masks (ChargeGroup (), 8),
            masks (MktUserAttribute (), 9)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ChargeComponents", "ChargeComponent", true),
        Relationship ("ChargeGroup", "ChargeGroup", true),
        Relationship ("MktUserAttribute", "MktUserAttribute", true)
    )
}

/**
 * Response from registered resource acknowleging receipt of dispatch instructions
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param acceptMW The accepted mw amount by the responder. aka response mw.
 * @param acceptStatus The accept status submitted by the responder. enumeration type needs to be defined
 * @param certificationName The Subject DN is the X509 Certificate Subject DN.
 *        This is the essentially the certificate name presented by the client. In the case of ADS Certificates, this will be the user name. It may be from an API Client or the MP Client (GUI).
 * @param clearedMW MW amount associated with instruction.
 *        For 5 minute binding dispatches, this is the Goto MW or DOT
 * @param instructionTime The target date/time for the received instruction.
 * @param instructionType instruction type:
 *        
 *        commitment
 *        out of sequence
 *        dispatch
 * @param passIndicator The type of run for the market clearing.
 * @param receivedTime Timestamp indicating the time at which the instruction was received.
 * @param startTime start time
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @group ParticipantInterfaces
 * @groupname ParticipantInterfaces Package ParticipantInterfaces
 * @groupdesc ParticipantInterfaces Market participant interfaces for bids and trades.
 */
case class DispatchInstReply
(
    override val sup: IdentifiedObject,
    acceptMW: Double,
    acceptStatus: String,
    certificationName: String,
    clearedMW: Double,
    instructionTime: String,
    instructionType: String,
    passIndicator: String,
    receivedTime: String,
    startTime: String,
    RegisteredResource: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, null, 0.0, null, null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[DispatchInstReply] }
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
        implicit val clz: String = DispatchInstReply.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DispatchInstReply.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DispatchInstReply.fields (position), value)
        emitelem (0, acceptMW)
        emitattr (1, acceptStatus)
        emitelem (2, certificationName)
        emitelem (3, clearedMW)
        emitelem (4, instructionTime)
        emitelem (5, instructionType)
        emitattr (6, passIndicator)
        emitelem (7, receivedTime)
        emitelem (8, startTime)
        emitattr (9, RegisteredResource)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DispatchInstReply rdf:ID=\"%s\">\n%s\t</cim:DispatchInstReply>".format (id, export_fields)
    }
}

object DispatchInstReply
extends
    Parseable[DispatchInstReply]
{
    val fields: Array[String] = Array[String] (
        "acceptMW",
        "acceptStatus",
        "certificationName",
        "clearedMW",
        "instructionTime",
        "instructionType",
        "passIndicator",
        "receivedTime",
        "startTime",
        "RegisteredResource"
    )
    val acceptMW: Fielder = parse_element (element (cls, fields(0)))
    val acceptStatus: Fielder = parse_attribute (attribute (cls, fields(1)))
    val certificationName: Fielder = parse_element (element (cls, fields(2)))
    val clearedMW: Fielder = parse_element (element (cls, fields(3)))
    val instructionTime: Fielder = parse_element (element (cls, fields(4)))
    val instructionType: Fielder = parse_element (element (cls, fields(5)))
    val passIndicator: Fielder = parse_attribute (attribute (cls, fields(6)))
    val receivedTime: Fielder = parse_element (element (cls, fields(7)))
    val startTime: Fielder = parse_element (element (cls, fields(8)))
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields(9)))

    def parse (context: Context): DispatchInstReply =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = DispatchInstReply (
            IdentifiedObject.parse (context),
            toDouble (mask (acceptMW (), 0)),
            mask (acceptStatus (), 1),
            mask (certificationName (), 2),
            toDouble (mask (clearedMW (), 3)),
            mask (instructionTime (), 4),
            mask (instructionType (), 5),
            mask (passIndicator (), 6),
            mask (receivedTime (), 7),
            mask (startTime (), 8),
            mask (RegisteredResource (), 9)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("RegisteredResource", "RegisteredResource", false)
    )
}

/**
 * Relationship between a price in \$(or other monetary unit) /hour (Y-axis) and a MW value (X-axis).
 *
 * @param sup Reference to the superclass object.
 * @group ParticipantInterfaces
 * @groupname ParticipantInterfaces Package ParticipantInterfaces
 * @groupdesc ParticipantInterfaces Market participant interfaces for bids and trades.
 */
case class EnergyPriceCurve
(
    override val sup: BasicElement
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
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[EnergyPriceCurve] }
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:EnergyPriceCurve rdf:ID=\"%s\">\n%s\t</cim:EnergyPriceCurve>".format (id, export_fields)
    }
}

object EnergyPriceCurve
extends
    Parseable[EnergyPriceCurve]
{

    def parse (context: Context): EnergyPriceCurve =
    {
        implicit val ctx: Context = context
        val ret = EnergyPriceCurve (
            BasicElement.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Offer to supply energy/ancillary services from a generating unit or resource
 *
 * @param sup [[ch.ninecode.model.ResourceBid ResourceBid]] Reference to the superclass object.
 * @param combinedCycleUnitOffer Will indicate if the unit is part of a CC offer or not
 * @param downTimeMax Maximum down time.
 * @param installedCapacity Installed Capacity value
 * @param lowerRampRate Maximum Dn ramp rate in MW/min
 * @param maxEmergencyMW Power rating available for unit under emergency conditions greater than or equal to maximum economic limit.
 * @param maximumEconomicMW Maximum high economic MW limit, that should not exceed the maximum operating MW limit
 * @param minEmergencyMW Minimum power rating for unit under emergency conditions, which is less than or equal to the economic minimum.
 * @param minimumEconomicMW Low economic MW limit that shall be greater than or equal to the minimum operating MW limit
 * @param noLoadCost Resource fixed no load cost.
 * @param notificationTime Time required for crew notification prior to start up of the unit.
 * @param operatingMode Bid operating mode ('C' - cycling, 'F' - fixed, 'M' - must run, 'U' - unavailable)
 * @param raiseRampRate Maximum Up ramp rate in MW/min
 * @param rampCurveType Ramp curve type:
 *        0 - Fixed ramp rate independent of rate function unit MW output
 *        1 - Static ramp rates as a function of unit MW output only
 *        2 - Dynamic ramp rates as a function of unit MW output and ramping time
 * @param startUpRampRate Resource startup ramp rate (MW/minute)
 * @param startUpType Resource startup type:
 *        1 - Fixed startup time and fixed startup cost
 *        2 - Startup time as a function of down time and fixed startup cost
 *        3 - Startup cost as a function of down time
 * @param startupCost Startup cost/price
 * @param upTimeMax Maximum up time.
 * @param BidSet [[ch.ninecode.model.BidSet BidSet]] <em>undocumented</em>
 * @param NotificationTimeCurve [[ch.ninecode.model.NotificationTimeCurve NotificationTimeCurve]] <em>undocumented</em>
 * @param RegisteredGenerator [[ch.ninecode.model.RegisteredGenerator RegisteredGenerator]] <em>undocumented</em>
 * @param StartUpCostCurve [[ch.ninecode.model.StartUpCostCurve StartUpCostCurve]] <em>undocumented</em>
 * @param StartUpTimeCurve [[ch.ninecode.model.StartUpTimeCurve StartUpTimeCurve]] <em>undocumented</em>
 * @group ParticipantInterfaces
 * @groupname ParticipantInterfaces Package ParticipantInterfaces
 * @groupdesc ParticipantInterfaces Market participant interfaces for bids and trades.
 */
case class GeneratingBid
(
    override val sup: ResourceBid,
    combinedCycleUnitOffer: String,
    downTimeMax: Double,
    installedCapacity: Double,
    lowerRampRate: Double,
    maxEmergencyMW: Double,
    maximumEconomicMW: Double,
    minEmergencyMW: Double,
    minimumEconomicMW: Double,
    noLoadCost: Double,
    notificationTime: Double,
    operatingMode: String,
    raiseRampRate: Double,
    rampCurveType: Int,
    startUpRampRate: Double,
    startUpType: Int,
    startupCost: Double,
    upTimeMax: Double,
    BidSet: String,
    NotificationTimeCurve: String,
    RegisteredGenerator: String,
    StartUpCostCurve: String,
    StartUpTimeCurve: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, 0.0, 0, 0.0, 0, 0.0, 0.0, null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ResourceBid: ResourceBid = sup.asInstanceOf[ResourceBid]
    override def copy (): Row = { clone ().asInstanceOf[GeneratingBid] }
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
        implicit val clz: String = GeneratingBid.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GeneratingBid.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (GeneratingBid.fields (position), value)
        emitelem (0, combinedCycleUnitOffer)
        emitelem (1, downTimeMax)
        emitelem (2, installedCapacity)
        emitelem (3, lowerRampRate)
        emitelem (4, maxEmergencyMW)
        emitelem (5, maximumEconomicMW)
        emitelem (6, minEmergencyMW)
        emitelem (7, minimumEconomicMW)
        emitelem (8, noLoadCost)
        emitelem (9, notificationTime)
        emitelem (10, operatingMode)
        emitelem (11, raiseRampRate)
        emitelem (12, rampCurveType)
        emitelem (13, startUpRampRate)
        emitelem (14, startUpType)
        emitelem (15, startupCost)
        emitelem (16, upTimeMax)
        emitattr (17, BidSet)
        emitattr (18, NotificationTimeCurve)
        emitattr (19, RegisteredGenerator)
        emitattr (20, StartUpCostCurve)
        emitattr (21, StartUpTimeCurve)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GeneratingBid rdf:ID=\"%s\">\n%s\t</cim:GeneratingBid>".format (id, export_fields)
    }
}

object GeneratingBid
extends
    Parseable[GeneratingBid]
{
    val fields: Array[String] = Array[String] (
        "combinedCycleUnitOffer",
        "downTimeMax",
        "installedCapacity",
        "lowerRampRate",
        "maxEmergencyMW",
        "maximumEconomicMW",
        "minEmergencyMW",
        "minimumEconomicMW",
        "noLoadCost",
        "notificationTime",
        "operatingMode",
        "raiseRampRate",
        "rampCurveType",
        "startUpRampRate",
        "startUpType",
        "startupCost",
        "upTimeMax",
        "BidSet",
        "NotificationTimeCurve",
        "RegisteredGenerator",
        "StartUpCostCurve",
        "StartUpTimeCurve"
    )
    val combinedCycleUnitOffer: Fielder = parse_element (element (cls, fields(0)))
    val downTimeMax: Fielder = parse_element (element (cls, fields(1)))
    val installedCapacity: Fielder = parse_element (element (cls, fields(2)))
    val lowerRampRate: Fielder = parse_element (element (cls, fields(3)))
    val maxEmergencyMW: Fielder = parse_element (element (cls, fields(4)))
    val maximumEconomicMW: Fielder = parse_element (element (cls, fields(5)))
    val minEmergencyMW: Fielder = parse_element (element (cls, fields(6)))
    val minimumEconomicMW: Fielder = parse_element (element (cls, fields(7)))
    val noLoadCost: Fielder = parse_element (element (cls, fields(8)))
    val notificationTime: Fielder = parse_element (element (cls, fields(9)))
    val operatingMode: Fielder = parse_element (element (cls, fields(10)))
    val raiseRampRate: Fielder = parse_element (element (cls, fields(11)))
    val rampCurveType: Fielder = parse_element (element (cls, fields(12)))
    val startUpRampRate: Fielder = parse_element (element (cls, fields(13)))
    val startUpType: Fielder = parse_element (element (cls, fields(14)))
    val startupCost: Fielder = parse_element (element (cls, fields(15)))
    val upTimeMax: Fielder = parse_element (element (cls, fields(16)))
    val BidSet: Fielder = parse_attribute (attribute (cls, fields(17)))
    val NotificationTimeCurve: Fielder = parse_attribute (attribute (cls, fields(18)))
    val RegisteredGenerator: Fielder = parse_attribute (attribute (cls, fields(19)))
    val StartUpCostCurve: Fielder = parse_attribute (attribute (cls, fields(20)))
    val StartUpTimeCurve: Fielder = parse_attribute (attribute (cls, fields(21)))

    def parse (context: Context): GeneratingBid =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = GeneratingBid (
            ResourceBid.parse (context),
            mask (combinedCycleUnitOffer (), 0),
            toDouble (mask (downTimeMax (), 1)),
            toDouble (mask (installedCapacity (), 2)),
            toDouble (mask (lowerRampRate (), 3)),
            toDouble (mask (maxEmergencyMW (), 4)),
            toDouble (mask (maximumEconomicMW (), 5)),
            toDouble (mask (minEmergencyMW (), 6)),
            toDouble (mask (minimumEconomicMW (), 7)),
            toDouble (mask (noLoadCost (), 8)),
            toDouble (mask (notificationTime (), 9)),
            mask (operatingMode (), 10),
            toDouble (mask (raiseRampRate (), 11)),
            toInteger (mask (rampCurveType (), 12)),
            toDouble (mask (startUpRampRate (), 13)),
            toInteger (mask (startUpType (), 14)),
            toDouble (mask (startupCost (), 15)),
            toDouble (mask (upTimeMax (), 16)),
            mask (BidSet (), 17),
            mask (NotificationTimeCurve (), 18),
            mask (RegisteredGenerator (), 19),
            mask (StartUpCostCurve (), 20),
            mask (StartUpTimeCurve (), 21)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("BidSet", "BidSet", false),
        Relationship ("NotificationTimeCurve", "NotificationTimeCurve", false),
        Relationship ("RegisteredGenerator", "RegisteredGenerator", false),
        Relationship ("StartUpCostCurve", "StartUpCostCurve", false),
        Relationship ("StartUpTimeCurve", "StartUpTimeCurve", false)
    )
}

/**
 * An indicator specifying that a resource shall have an Hourly Pre-Dispatch.
 *
 * The resource could be a RegisteredGenerator or a RegisteredInterTie.
 *
 * @param sup [[ch.ninecode.model.BidHourlySchedule BidHourlySchedule]] Reference to the superclass object.
 * @param value Flag defining that for this hour in the resource bid the resource shall have an hourly pre-dispatch.
 * @group ParticipantInterfaces
 * @groupname ParticipantInterfaces Package ParticipantInterfaces
 * @groupdesc ParticipantInterfaces Market participant interfaces for bids and trades.
 */
case class HourlyPreDispatchSchedule
(
    override val sup: BidHourlySchedule,
    value: Boolean
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def BidHourlySchedule: BidHourlySchedule = sup.asInstanceOf[BidHourlySchedule]
    override def copy (): Row = { clone ().asInstanceOf[HourlyPreDispatchSchedule] }
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
        implicit val clz: String = HourlyPreDispatchSchedule.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (HourlyPreDispatchSchedule.fields (position), value)
        emitelem (0, value)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:HourlyPreDispatchSchedule rdf:ID=\"%s\">\n%s\t</cim:HourlyPreDispatchSchedule>".format (id, export_fields)
    }
}

object HourlyPreDispatchSchedule
extends
    Parseable[HourlyPreDispatchSchedule]
{
    val fields: Array[String] = Array[String] (
        "value"
    )
    val value: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): HourlyPreDispatchSchedule =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = HourlyPreDispatchSchedule (
            BidHourlySchedule.parse (context),
            toBoolean (mask (value (), 0))
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * This class represents the inter tie bid
 *
 * @param sup [[ch.ninecode.model.ResourceBid ResourceBid]] Reference to the superclass object.
 * @param minHourlyBlock_1 The minimum hourly block for an Inter-Tie Resource supplied within the bid.
 * @param RegisteredInterTie [[ch.ninecode.model.RegisteredInterTie RegisteredInterTie]] <em>undocumented</em>
 * @group ParticipantInterfaces
 * @groupname ParticipantInterfaces Package ParticipantInterfaces
 * @groupdesc ParticipantInterfaces Market participant interfaces for bids and trades.
 */
case class InterTieBid
(
    override val sup: ResourceBid,
    minHourlyBlock_1: Int,
    RegisteredInterTie: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ResourceBid: ResourceBid = sup.asInstanceOf[ResourceBid]
    override def copy (): Row = { clone ().asInstanceOf[InterTieBid] }
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
        implicit val clz: String = InterTieBid.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (InterTieBid.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (InterTieBid.fields (position), value)
        emitelem (0, minHourlyBlock_1)
        emitattr (1, RegisteredInterTie)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:InterTieBid rdf:ID=\"%s\">\n%s\t</cim:InterTieBid>".format (id, export_fields)
    }
}

object InterTieBid
extends
    Parseable[InterTieBid]
{
    val fields: Array[String] = Array[String] (
        "minHourlyBlock ",
        "RegisteredInterTie"
    )
    val minHourlyBlock_1: Fielder = parse_element (element (cls, fields(0)))
    val RegisteredInterTie: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): InterTieBid =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = InterTieBid (
            ResourceBid.parse (context),
            toInteger (mask (minHourlyBlock_1 (), 0)),
            mask (RegisteredInterTie (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("RegisteredInterTie", "RegisteredInterTie", false)
    )
}

/**
 * Response from an intertie resource acknowleging receipt of dispatch instructions
 *
 * @param sup Reference to the superclass object.
 * @param acceptMW The accepted mw amount by the responder. aka response mw.
 * @param acceptStatus The accept status submitted by the responder.
 *        Valid values are NON-RESPONSE, ACCEPT, DECLINE, PARTIAL.
 * @param clearedMW MW amount associated with instruction.
 *        For 5 minute binding dispatches, this is the Goto MW or DOT
 * @param passIndicator Part of the Composite key that downstream app uses to match the instruction
 * @param startTime Part of the Composite key that downstream app uses to match the instruction
 * @param RegisteredInterTie [[ch.ninecode.model.RegisteredInterTie RegisteredInterTie]] <em>undocumented</em>
 * @group ParticipantInterfaces
 * @groupname ParticipantInterfaces Package ParticipantInterfaces
 * @groupdesc ParticipantInterfaces Market participant interfaces for bids and trades.
 */
case class InterTieDispatchResponse
(
    override val sup: BasicElement,
    acceptMW: Double,
    acceptStatus: String,
    clearedMW: Double,
    passIndicator: String,
    startTime: String,
    RegisteredInterTie: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, 0.0, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[InterTieDispatchResponse] }
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
        implicit val clz: String = InterTieDispatchResponse.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (InterTieDispatchResponse.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (InterTieDispatchResponse.fields (position), value)
        emitelem (0, acceptMW)
        emitattr (1, acceptStatus)
        emitelem (2, clearedMW)
        emitattr (3, passIndicator)
        emitelem (4, startTime)
        emitattr (5, RegisteredInterTie)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:InterTieDispatchResponse rdf:ID=\"%s\">\n%s\t</cim:InterTieDispatchResponse>".format (id, export_fields)
    }
}

object InterTieDispatchResponse
extends
    Parseable[InterTieDispatchResponse]
{
    val fields: Array[String] = Array[String] (
        "acceptMW",
        "acceptStatus",
        "clearedMW",
        "passIndicator",
        "startTime",
        "RegisteredInterTie"
    )
    val acceptMW: Fielder = parse_element (element (cls, fields(0)))
    val acceptStatus: Fielder = parse_attribute (attribute (cls, fields(1)))
    val clearedMW: Fielder = parse_element (element (cls, fields(2)))
    val passIndicator: Fielder = parse_attribute (attribute (cls, fields(3)))
    val startTime: Fielder = parse_element (element (cls, fields(4)))
    val RegisteredInterTie: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: Context): InterTieDispatchResponse =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = InterTieDispatchResponse (
            BasicElement.parse (context),
            toDouble (mask (acceptMW (), 0)),
            mask (acceptStatus (), 1),
            toDouble (mask (clearedMW (), 2)),
            mask (passIndicator (), 3),
            mask (startTime (), 4),
            mask (RegisteredInterTie (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("RegisteredInterTie", "RegisteredInterTie", false)
    )
}

/**
 * Offer to supply energy/ancillary services from a load resource (participating load reduces consumption)
 *
 * @param sup [[ch.ninecode.model.ResourceBid ResourceBid]] Reference to the superclass object.
 * @param dropRampRate Maximum rate that load can be reduced (MW/minute)
 * @param loadRedInitiationCost load reduction initiation cost
 * @param loadRedInitiationTime load reduction initiation time
 * @param marketDate The date represents the NextMarketDate for which the load response bids apply to.
 * @param meteredValue Flag indicated that the load reduction is metered. (See above)
 *        If priceSetting and meteredValue both equal 1, then the facility is eligible to set LMP in the real time market.
 * @param minLoad Minimum MW load below which it may not be reduced.
 * @param minLoadReduction Minimum MW for a load reduction (e.g.
 *        MW rating of a discrete pump.
 * @param minLoadReductionCost Cost in \$ at the minimum reduced load
 * @param minLoadReductionInterval Shortest period load reduction shall be maintained before load can be restored to normal levels.
 * @param minTimeBetLoadRed Shortest time that load shall be left at normal levels before a new load reduction.
 * @param pickUpRampRate Maximum rate load may be restored (MW/minute)
 * @param priceSetting Flag to indicate that the facility can set LMP Works in tandem with Metered Value.
 *        Greater chance of this being dynamic than the Metered Value, however, it is requested that Price Setting and Metered Value stay at the same source.  Currently no customers have implemented the metering capability, but if this option is implemented, then Price Setting could become dynamic.  However, Metered Value will remain static.
 * @param reqNoticeTime Time period that is required from an order to reduce a load to the time that it takes to get to the minimum load reduction.
 * @param shutdownCost The fixed cost associated with committing a load reduction.
 * @param AreaLoadBid [[ch.ninecode.model.AreaLoadBid AreaLoadBid]] <em>undocumented</em>
 * @param RegisteredLoad [[ch.ninecode.model.RegisteredLoad RegisteredLoad]] <em>undocumented</em>
 * @group ParticipantInterfaces
 * @groupname ParticipantInterfaces Package ParticipantInterfaces
 * @groupdesc ParticipantInterfaces Market participant interfaces for bids and trades.
 */
case class LoadBid
(
    override val sup: ResourceBid,
    dropRampRate: Double,
    loadRedInitiationCost: Double,
    loadRedInitiationTime: Double,
    marketDate: String,
    meteredValue: Boolean,
    minLoad: Double,
    minLoadReduction: Double,
    minLoadReductionCost: Double,
    minLoadReductionInterval: Double,
    minTimeBetLoadRed: Double,
    pickUpRampRate: Double,
    priceSetting: Boolean,
    reqNoticeTime: Double,
    shutdownCost: Double,
    AreaLoadBid: String,
    RegisteredLoad: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, null, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ResourceBid: ResourceBid = sup.asInstanceOf[ResourceBid]
    override def copy (): Row = { clone ().asInstanceOf[LoadBid] }
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
        implicit val clz: String = LoadBid.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (LoadBid.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (LoadBid.fields (position), value)
        emitelem (0, dropRampRate)
        emitelem (1, loadRedInitiationCost)
        emitelem (2, loadRedInitiationTime)
        emitelem (3, marketDate)
        emitelem (4, meteredValue)
        emitelem (5, minLoad)
        emitelem (6, minLoadReduction)
        emitelem (7, minLoadReductionCost)
        emitelem (8, minLoadReductionInterval)
        emitelem (9, minTimeBetLoadRed)
        emitelem (10, pickUpRampRate)
        emitelem (11, priceSetting)
        emitelem (12, reqNoticeTime)
        emitelem (13, shutdownCost)
        emitattr (14, AreaLoadBid)
        emitattr (15, RegisteredLoad)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:LoadBid rdf:ID=\"%s\">\n%s\t</cim:LoadBid>".format (id, export_fields)
    }
}

object LoadBid
extends
    Parseable[LoadBid]
{
    val fields: Array[String] = Array[String] (
        "dropRampRate",
        "loadRedInitiationCost",
        "loadRedInitiationTime",
        "marketDate",
        "meteredValue",
        "minLoad",
        "minLoadReduction",
        "minLoadReductionCost",
        "minLoadReductionInterval",
        "minTimeBetLoadRed",
        "pickUpRampRate",
        "priceSetting",
        "reqNoticeTime",
        "shutdownCost",
        "AreaLoadBid",
        "RegisteredLoad"
    )
    val dropRampRate: Fielder = parse_element (element (cls, fields(0)))
    val loadRedInitiationCost: Fielder = parse_element (element (cls, fields(1)))
    val loadRedInitiationTime: Fielder = parse_element (element (cls, fields(2)))
    val marketDate: Fielder = parse_element (element (cls, fields(3)))
    val meteredValue: Fielder = parse_element (element (cls, fields(4)))
    val minLoad: Fielder = parse_element (element (cls, fields(5)))
    val minLoadReduction: Fielder = parse_element (element (cls, fields(6)))
    val minLoadReductionCost: Fielder = parse_element (element (cls, fields(7)))
    val minLoadReductionInterval: Fielder = parse_element (element (cls, fields(8)))
    val minTimeBetLoadRed: Fielder = parse_element (element (cls, fields(9)))
    val pickUpRampRate: Fielder = parse_element (element (cls, fields(10)))
    val priceSetting: Fielder = parse_element (element (cls, fields(11)))
    val reqNoticeTime: Fielder = parse_element (element (cls, fields(12)))
    val shutdownCost: Fielder = parse_element (element (cls, fields(13)))
    val AreaLoadBid: Fielder = parse_attribute (attribute (cls, fields(14)))
    val RegisteredLoad: Fielder = parse_attribute (attribute (cls, fields(15)))

    def parse (context: Context): LoadBid =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = LoadBid (
            ResourceBid.parse (context),
            toDouble (mask (dropRampRate (), 0)),
            toDouble (mask (loadRedInitiationCost (), 1)),
            toDouble (mask (loadRedInitiationTime (), 2)),
            mask (marketDate (), 3),
            toBoolean (mask (meteredValue (), 4)),
            toDouble (mask (minLoad (), 5)),
            toDouble (mask (minLoadReduction (), 6)),
            toDouble (mask (minLoadReductionCost (), 7)),
            toDouble (mask (minLoadReductionInterval (), 8)),
            toDouble (mask (minTimeBetLoadRed (), 9)),
            toDouble (mask (pickUpRampRate (), 10)),
            toBoolean (mask (priceSetting (), 11)),
            toDouble (mask (reqNoticeTime (), 12)),
            toDouble (mask (shutdownCost (), 13)),
            mask (AreaLoadBid (), 14),
            mask (RegisteredLoad (), 15)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("AreaLoadBid", "AreaLoadBid", false),
        Relationship ("RegisteredLoad", "RegisteredLoad", false)
    )
}

/**
 * Metered SubSystem Load Following Instruction
 *
 * @param sup Reference to the superclass object.
 * @param endTime Instruction End Time
 * @param loadFollowingMW Load Following MW Positive for follow-up and negative for follow-down
 * @param mssInstructionID Unique instruction id per instruction, assigned by the SC and provided to ADS.
 *        ADS passes through.
 * @param startTime Instruction Start Time
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @group ParticipantInterfaces
 * @groupname ParticipantInterfaces Package ParticipantInterfaces
 * @groupdesc ParticipantInterfaces Market participant interfaces for bids and trades.
 */
case class LoadFollowingInst
(
    override val sup: BasicElement,
    endTime: String,
    loadFollowingMW: Double,
    mssInstructionID: String,
    startTime: String,
    RegisteredResource: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[LoadFollowingInst] }
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
        implicit val clz: String = LoadFollowingInst.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (LoadFollowingInst.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (LoadFollowingInst.fields (position), value)
        emitelem (0, endTime)
        emitelem (1, loadFollowingMW)
        emitelem (2, mssInstructionID)
        emitelem (3, startTime)
        emitattr (4, RegisteredResource)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:LoadFollowingInst rdf:ID=\"%s\">\n%s\t</cim:LoadFollowingInst>".format (id, export_fields)
    }
}

object LoadFollowingInst
extends
    Parseable[LoadFollowingInst]
{
    val fields: Array[String] = Array[String] (
        "endTime",
        "loadFollowingMW",
        "mssInstructionID",
        "startTime",
        "RegisteredResource"
    )
    val endTime: Fielder = parse_element (element (cls, fields(0)))
    val loadFollowingMW: Fielder = parse_element (element (cls, fields(1)))
    val mssInstructionID: Fielder = parse_element (element (cls, fields(2)))
    val startTime: Fielder = parse_element (element (cls, fields(3)))
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): LoadFollowingInst =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = LoadFollowingInst (
            BasicElement.parse (context),
            mask (endTime (), 0),
            toDouble (mask (loadFollowingMW (), 1)),
            mask (mssInstructionID (), 2),
            mask (startTime (), 3),
            mask (RegisteredResource (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("RegisteredResource", "RegisteredResource", false)
    )
}

/**
 * This is the price sensitivity that bidder expresses for allowing market load interruption.
 *
 * Relationship between price (Y1-axis) vs. MW (X-axis).
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param LoadBid [[ch.ninecode.model.LoadBid LoadBid]] <em>undocumented</em>
 * @group ParticipantInterfaces
 * @groupname ParticipantInterfaces Package ParticipantInterfaces
 * @groupdesc ParticipantInterfaces Market participant interfaces for bids and trades.
 */
case class LoadReductionPriceCurve
(
    override val sup: Curve,
    LoadBid: String
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
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[LoadReductionPriceCurve] }
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
        implicit val clz: String = LoadReductionPriceCurve.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (LoadReductionPriceCurve.fields (position), value)
        emitattr (0, LoadBid)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:LoadReductionPriceCurve rdf:ID=\"%s\">\n%s\t</cim:LoadReductionPriceCurve>".format (id, export_fields)
    }
}

object LoadReductionPriceCurve
extends
    Parseable[LoadReductionPriceCurve]
{
    val fields: Array[String] = Array[String] (
        "LoadBid"
    )
    val LoadBid: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): LoadReductionPriceCurve =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = LoadReductionPriceCurve (
            Curve.parse (context),
            mask (LoadBid (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("LoadBid", "LoadBid", false)
    )
}

/**
 * A Major Charge Group is the same as Invocie Type which provides the highest level of grouping for charge types configration.
 *
 * Examples as Market, FERC, RMR,
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param effectiveDate <em>undocumented</em>
 * @param frequencyType <em>undocumented</em>
 * @param invoiceType <em>undocumented</em>
 * @param requireAutorun <em>undocumented</em>
 * @param revisionNumber Revision number for the major charge group
 * @param runType <em>undocumented</em>
 * @param runVersion <em>undocumented</em>
 * @param terminationDate <em>undocumented</em>
 * @param ChargeType [[ch.ninecode.model.ChargeType ChargeType]] A MajorChargeGroup can have 0-n ChargeType.
 *        A ChargeType can associate to 0-n MajorChargeGroup.
 * @group ParticipantInterfaces
 * @groupname ParticipantInterfaces Package ParticipantInterfaces
 * @groupdesc ParticipantInterfaces Market participant interfaces for bids and trades.
 */
case class MajorChargeGroup
(
    override val sup: IdentifiedObject,
    effectiveDate: String,
    frequencyType: String,
    invoiceType: String,
    requireAutorun: String,
    revisionNumber: String,
    runType: String,
    runVersion: String,
    terminationDate: String,
    ChargeType: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null, null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[MajorChargeGroup] }
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
        implicit val clz: String = MajorChargeGroup.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MajorChargeGroup.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (MajorChargeGroup.fields (position), x))
        emitelem (0, effectiveDate)
        emitelem (1, frequencyType)
        emitelem (2, invoiceType)
        emitelem (3, requireAutorun)
        emitelem (4, revisionNumber)
        emitelem (5, runType)
        emitelem (6, runVersion)
        emitelem (7, terminationDate)
        emitattrs (8, ChargeType)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MajorChargeGroup rdf:ID=\"%s\">\n%s\t</cim:MajorChargeGroup>".format (id, export_fields)
    }
}

object MajorChargeGroup
extends
    Parseable[MajorChargeGroup]
{
    val fields: Array[String] = Array[String] (
        "effectiveDate",
        "frequencyType",
        "invoiceType",
        "requireAutorun",
        "revisionNumber",
        "runType",
        "runVersion",
        "terminationDate",
        "ChargeType"
    )
    val effectiveDate: Fielder = parse_element (element (cls, fields(0)))
    val frequencyType: Fielder = parse_element (element (cls, fields(1)))
    val invoiceType: Fielder = parse_element (element (cls, fields(2)))
    val requireAutorun: Fielder = parse_element (element (cls, fields(3)))
    val revisionNumber: Fielder = parse_element (element (cls, fields(4)))
    val runType: Fielder = parse_element (element (cls, fields(5)))
    val runVersion: Fielder = parse_element (element (cls, fields(6)))
    val terminationDate: Fielder = parse_element (element (cls, fields(7)))
    val ChargeType: FielderMultiple = parse_attributes (attribute (cls, fields(8)))

    def parse (context: Context): MajorChargeGroup =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MajorChargeGroup (
            IdentifiedObject.parse (context),
            mask (effectiveDate (), 0),
            mask (frequencyType (), 1),
            mask (invoiceType (), 2),
            mask (requireAutorun (), 3),
            mask (revisionNumber (), 4),
            mask (runType (), 5),
            mask (runVersion (), 6),
            mask (terminationDate (), 7),
            masks (ChargeType (), 8)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ChargeType", "ChargeType", true)
    )
}

/**
 * Signifies an event to trigger one or more activities, such as reading a meter, recalculating a bill, requesting work, when generating units shall be scheduled for maintenance, when a transformer is scheduled to be refurbished, etc.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param category Category of scheduled event.
 * @param duration Duration of the scheduled event, for example, the time to ramp between values.
 * @param status <em>undocumented</em>
 * @param MajorChargeGroup [[ch.ninecode.model.MajorChargeGroup MajorChargeGroup]] <em>undocumented</em>
 * @group ParticipantInterfaces
 * @groupname ParticipantInterfaces Package ParticipantInterfaces
 * @groupdesc ParticipantInterfaces Market participant interfaces for bids and trades.
 */
case class MarketScheduledEvent
(
    override val sup: IdentifiedObject,
    category: String,
    duration: Double,
    status: String,
    MajorChargeGroup: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[MarketScheduledEvent] }
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
        implicit val clz: String = MarketScheduledEvent.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MarketScheduledEvent.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MarketScheduledEvent.fields (position), value)
        emitelem (0, category)
        emitelem (1, duration)
        emitattr (2, status)
        emitattr (3, MajorChargeGroup)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MarketScheduledEvent rdf:ID=\"%s\">\n%s\t</cim:MarketScheduledEvent>".format (id, export_fields)
    }
}

object MarketScheduledEvent
extends
    Parseable[MarketScheduledEvent]
{
    val fields: Array[String] = Array[String] (
        "category",
        "duration",
        "status",
        "MajorChargeGroup"
    )
    val category: Fielder = parse_element (element (cls, fields(0)))
    val duration: Fielder = parse_element (element (cls, fields(1)))
    val status: Fielder = parse_attribute (attribute (cls, fields(2)))
    val MajorChargeGroup: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): MarketScheduledEvent =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MarketScheduledEvent (
            IdentifiedObject.parse (context),
            mask (category (), 0),
            toDouble (mask (duration (), 1)),
            mask (status (), 2),
            mask (MajorChargeGroup (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("MajorChargeGroup", "MajorChargeGroup", false)
    )
}

/**
 * Notification time curve as a function of down time.
 *
 * Relationship between crew notification time (Y1-axis) and unit startup time (Y2-axis) vs. unit elapsed down time (X-axis).
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @group ParticipantInterfaces
 * @groupname ParticipantInterfaces Package ParticipantInterfaces
 * @groupdesc ParticipantInterfaces Market participant interfaces for bids and trades.
 */
case class NotificationTimeCurve
(
    override val sup: Curve
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
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[NotificationTimeCurve] }
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:NotificationTimeCurve rdf:ID=\"%s\">\n%s\t</cim:NotificationTimeCurve>".format (id, export_fields)
    }
}

object NotificationTimeCurve
extends
    Parseable[NotificationTimeCurve]
{

    def parse (context: Context): NotificationTimeCurve =
    {
        implicit val ctx: Context = context
        val ret = NotificationTimeCurve (
            Curve.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Result of bid validation against conditions that may exist on an interchange that becomes disconnected or is heavily discounted with respect the MW flow.
 *
 * This schedule is assocated with the hourly parameters in a resource bid.
 *
 * @param sup [[ch.ninecode.model.BidHourlySchedule BidHourlySchedule]] Reference to the superclass object.
 * @param value <em>undocumented</em>
 * @group ParticipantInterfaces
 * @groupname ParticipantInterfaces Package ParticipantInterfaces
 * @groupdesc ParticipantInterfaces Market participant interfaces for bids and trades.
 */
case class OpenTieSchedule
(
    override val sup: BidHourlySchedule,
    value: Boolean
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def BidHourlySchedule: BidHourlySchedule = sup.asInstanceOf[BidHourlySchedule]
    override def copy (): Row = { clone ().asInstanceOf[OpenTieSchedule] }
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
        implicit val clz: String = OpenTieSchedule.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (OpenTieSchedule.fields (position), value)
        emitelem (0, value)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OpenTieSchedule rdf:ID=\"%s\">\n%s\t</cim:OpenTieSchedule>".format (id, export_fields)
    }
}

object OpenTieSchedule
extends
    Parseable[OpenTieSchedule]
{
    val fields: Array[String] = Array[String] (
        "value"
    )
    val value: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): OpenTieSchedule =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = OpenTieSchedule (
            BidHourlySchedule.parse (context),
            toBoolean (mask (value (), 0))
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Component of a bid that pertains to one market product.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param Bid [[ch.ninecode.model.Bid Bid]] A bid comprises one or more product bids of market products
 * @param MarketProduct [[ch.ninecode.model.MarketProduct MarketProduct]] <em>undocumented</em>
 * @group ParticipantInterfaces
 * @groupname ParticipantInterfaces Package ParticipantInterfaces
 * @groupdesc ParticipantInterfaces Market participant interfaces for bids and trades.
 */
case class ProductBid
(
    override val sup: IdentifiedObject,
    Bid: String,
    MarketProduct: String
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
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ProductBid] }
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
        implicit val clz: String = ProductBid.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ProductBid.fields (position), value)
        emitattr (0, Bid)
        emitattr (1, MarketProduct)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ProductBid rdf:ID=\"%s\">\n%s\t</cim:ProductBid>".format (id, export_fields)
    }
}

object ProductBid
extends
    Parseable[ProductBid]
{
    val fields: Array[String] = Array[String] (
        "Bid",
        "MarketProduct"
    )
    val Bid: Fielder = parse_attribute (attribute (cls, fields(0)))
    val MarketProduct: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): ProductBid =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ProductBid (
            IdentifiedObject.parse (context),
            mask (Bid (), 0),
            mask (MarketProduct (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Bid", "Bid", false),
        Relationship ("MarketProduct", "MarketProduct", false)
    )
}

/**
 * The operating cost of a Pump Storage Hydro Unit operating as a hydro pump.
 *
 * This schedule is assocated with the hourly parameters in a resource bid associated with a specific product within the bid.
 *
 * @param sup [[ch.ninecode.model.BidHourlyProductSchedule BidHourlyProductSchedule]] Reference to the superclass object.
 * @param value <em>undocumented</em>
 * @group ParticipantInterfaces
 * @groupname ParticipantInterfaces Package ParticipantInterfaces
 * @groupdesc ParticipantInterfaces Market participant interfaces for bids and trades.
 */
case class PumpingCostSchedule
(
    override val sup: BidHourlyProductSchedule,
    value: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def BidHourlyProductSchedule: BidHourlyProductSchedule = sup.asInstanceOf[BidHourlyProductSchedule]
    override def copy (): Row = { clone ().asInstanceOf[PumpingCostSchedule] }
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
        implicit val clz: String = PumpingCostSchedule.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PumpingCostSchedule.fields (position), value)
        emitelem (0, value)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PumpingCostSchedule rdf:ID=\"%s\">\n%s\t</cim:PumpingCostSchedule>".format (id, export_fields)
    }
}

object PumpingCostSchedule
extends
    Parseable[PumpingCostSchedule]
{
    val fields: Array[String] = Array[String] (
        "value"
    )
    val value: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): PumpingCostSchedule =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = PumpingCostSchedule (
            BidHourlyProductSchedule.parse (context),
            toDouble (mask (value (), 0))
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * The fixed operating level of a Pump Storage Hydro Unit operating as a hydro pump.
 *
 * Associated with the energy market product type.
 *
 * @param sup [[ch.ninecode.model.BidHourlyProductSchedule BidHourlyProductSchedule]] Reference to the superclass object.
 * @param value <em>undocumented</em>
 * @group ParticipantInterfaces
 * @groupname ParticipantInterfaces Package ParticipantInterfaces
 * @groupdesc ParticipantInterfaces Market participant interfaces for bids and trades.
 */
case class PumpingLevelSchedule
(
    override val sup: BidHourlyProductSchedule,
    value: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def BidHourlyProductSchedule: BidHourlyProductSchedule = sup.asInstanceOf[BidHourlyProductSchedule]
    override def copy (): Row = { clone ().asInstanceOf[PumpingLevelSchedule] }
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
        implicit val clz: String = PumpingLevelSchedule.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PumpingLevelSchedule.fields (position), value)
        emitelem (0, value)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PumpingLevelSchedule rdf:ID=\"%s\">\n%s\t</cim:PumpingLevelSchedule>".format (id, export_fields)
    }
}

object PumpingLevelSchedule
extends
    Parseable[PumpingLevelSchedule]
{
    val fields: Array[String] = Array[String] (
        "value"
    )
    val value: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): PumpingLevelSchedule =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = PumpingLevelSchedule (
            BidHourlyProductSchedule.parse (context),
            toDouble (mask (value (), 0))
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * The cost to shutdown a Pump Storage Hydro Unit (in pump mode) or a pump.
 *
 * This schedule is assocated with the hourly parameters in a resource bid associated with a specific product within the bid.
 *
 * @param sup [[ch.ninecode.model.BidHourlyProductSchedule BidHourlyProductSchedule]] Reference to the superclass object.
 * @param value <em>undocumented</em>
 * @group ParticipantInterfaces
 * @groupname ParticipantInterfaces Package ParticipantInterfaces
 * @groupdesc ParticipantInterfaces Market participant interfaces for bids and trades.
 */
case class PumpingShutDownCostSchedule
(
    override val sup: BidHourlyProductSchedule,
    value: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def BidHourlyProductSchedule: BidHourlyProductSchedule = sup.asInstanceOf[BidHourlyProductSchedule]
    override def copy (): Row = { clone ().asInstanceOf[PumpingShutDownCostSchedule] }
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
        implicit val clz: String = PumpingShutDownCostSchedule.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PumpingShutDownCostSchedule.fields (position), value)
        emitelem (0, value)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PumpingShutDownCostSchedule rdf:ID=\"%s\">\n%s\t</cim:PumpingShutDownCostSchedule>".format (id, export_fields)
    }
}

object PumpingShutDownCostSchedule
extends
    Parseable[PumpingShutDownCostSchedule]
{
    val fields: Array[String] = Array[String] (
        "value"
    )
    val value: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): PumpingShutDownCostSchedule =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = PumpingShutDownCostSchedule (
            BidHourlyProductSchedule.parse (context),
            toDouble (mask (value (), 0))
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Ramp rate as a function of resource MW output
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param condition condition for the ramp rate
 * @param constraintRampType The condition that identifies whether a Generating Resource should be constrained from Ancillary Service provision if its Schedule or Dispatch change across Trading Hours or Trading Intervals requires more than a specified fraction of the duration of the Trading Hour or Trading Interval.
 *        Valid values are Fast/Slow
 * @param rampRateType How ramp rate is applied (e.g. raise or lower, as when applied to a generation resource)
 * @param GeneratingBid [[ch.ninecode.model.GeneratingBid GeneratingBid]] <em>undocumented</em>
 * @param InterTieBid [[ch.ninecode.model.InterTieBid InterTieBid]] <em>undocumented</em>
 * @param LoadBid [[ch.ninecode.model.LoadBid LoadBid]] <em>undocumented</em>
 * @group ParticipantInterfaces
 * @groupname ParticipantInterfaces Package ParticipantInterfaces
 * @groupdesc ParticipantInterfaces Market participant interfaces for bids and trades.
 */
case class RampRateCurve
(
    override val sup: Curve,
    condition: String,
    constraintRampType: String,
    rampRateType: String,
    GeneratingBid: String,
    InterTieBid: String,
    LoadBid: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[RampRateCurve] }
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
        implicit val clz: String = RampRateCurve.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RampRateCurve.fields (position), value)
        emitattr (0, condition)
        emitattr (1, constraintRampType)
        emitattr (2, rampRateType)
        emitattr (3, GeneratingBid)
        emitattr (4, InterTieBid)
        emitattr (5, LoadBid)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RampRateCurve rdf:ID=\"%s\">\n%s\t</cim:RampRateCurve>".format (id, export_fields)
    }
}

object RampRateCurve
extends
    Parseable[RampRateCurve]
{
    val fields: Array[String] = Array[String] (
        "condition",
        "constraintRampType",
        "rampRateType",
        "GeneratingBid",
        "InterTieBid",
        "LoadBid"
    )
    val condition: Fielder = parse_attribute (attribute (cls, fields(0)))
    val constraintRampType: Fielder = parse_attribute (attribute (cls, fields(1)))
    val rampRateType: Fielder = parse_attribute (attribute (cls, fields(2)))
    val GeneratingBid: Fielder = parse_attribute (attribute (cls, fields(3)))
    val InterTieBid: Fielder = parse_attribute (attribute (cls, fields(4)))
    val LoadBid: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: Context): RampRateCurve =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = RampRateCurve (
            Curve.parse (context),
            mask (condition (), 0),
            mask (constraintRampType (), 1),
            mask (rampRateType (), 2),
            mask (GeneratingBid (), 3),
            mask (InterTieBid (), 4),
            mask (LoadBid (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("GeneratingBid", "GeneratingBid", false),
        Relationship ("InterTieBid", "InterTieBid", false),
        Relationship ("LoadBid", "LoadBid", false)
    )
}

/**
 * Energy bid for generation, load, or virtual type for the whole of the market-trading period (i.e., one day in day ahead market or one hour in the real time market)
 *
 * @param sup [[ch.ninecode.model.Bid Bid]] Reference to the superclass object.
 * @param aggregationFlag Aggregation flag
 *        0: individual resource level
 *        1: Aggregated node location
 *        2: Aggregated price location)
 * @param bidStatus <em>undocumented</em>
 * @param commodityType Energy product (commodity) type:
 *        'En' - Energy
 *        'Ru' - Regulation Up
 *        'Rd' - Regulation Dn
 *        'Sr' - Spinning Reserve
 *        'Nr' - Non-Spinning Reserve
 *        'Or' - Operating Reserve
 * @param contingencyAvailFlag contingent operating reserve availiability (Yes/No).
 *        Resource is availiable to participate with capacity only in contingency dispatch.
 * @param createdISO A Yes indicates that this bid was created by the ISO.
 * @param energyMaxDay Maximum amount of energy per day which can be produced during the trading period in MWh
 * @param energyMinDay Minimum amount of energy per day which has to be produced during the trading period in MWh
 * @param marketSepFlag Market Separation Flag
 *        
 *        'Y' - Enforce market separation constraints for this bid
 *        'N' - Don't enforce market separation constraints for this bid.
 * @param minDispatchTime minimum number of consecutive hours a resource shall be dispatched if bid is accepted
 * @param resourceLoadingType Resource loading curve type
 *        1 - step-wise continuous loading
 *        2 - piece-wise linear continuous loading
 *        3 - block loading
 * @param shutDownsMaxDay Maximum number of shutdowns per day.
 * @param shutDownsMaxWeek Maximum number of shutdowns per week.
 * @param startUpsMaxDay Maximum number of startups per day.
 * @param startUpsMaxWeek Maximum number of startups per week.
 * @param virtual True if bid is virtual.
 *        Bid is assumed to be non-virtual if attribute is absent
 * @param BidError [[ch.ninecode.model.BidError BidError]] <em>undocumented</em>
 * @group ParticipantInterfaces
 * @groupname ParticipantInterfaces Package ParticipantInterfaces
 * @groupdesc ParticipantInterfaces Market participant interfaces for bids and trades.
 */
case class ResourceBid
(
    override val sup: Bid,
    aggregationFlag: Int,
    bidStatus: String,
    commodityType: String,
    contingencyAvailFlag: String,
    createdISO: String,
    energyMaxDay: Double,
    energyMinDay: Double,
    marketSepFlag: String,
    minDispatchTime: Int,
    resourceLoadingType: Int,
    shutDownsMaxDay: Int,
    shutDownsMaxWeek: Int,
    startUpsMaxDay: Int,
    startUpsMaxWeek: Int,
    virtual: Boolean,
    BidError: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0, null, null, null, null, 0.0, 0.0, null, 0, 0, 0, 0, 0, 0, false, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Bid: Bid = sup.asInstanceOf[Bid]
    override def copy (): Row = { clone ().asInstanceOf[ResourceBid] }
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
        implicit val clz: String = ResourceBid.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ResourceBid.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ResourceBid.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (ResourceBid.fields (position), x))
        emitelem (0, aggregationFlag)
        emitelem (1, bidStatus)
        emitelem (2, commodityType)
        emitattr (3, contingencyAvailFlag)
        emitattr (4, createdISO)
        emitelem (5, energyMaxDay)
        emitelem (6, energyMinDay)
        emitelem (7, marketSepFlag)
        emitelem (8, minDispatchTime)
        emitelem (9, resourceLoadingType)
        emitelem (10, shutDownsMaxDay)
        emitelem (11, shutDownsMaxWeek)
        emitelem (12, startUpsMaxDay)
        emitelem (13, startUpsMaxWeek)
        emitelem (14, virtual)
        emitattrs (15, BidError)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ResourceBid rdf:ID=\"%s\">\n%s\t</cim:ResourceBid>".format (id, export_fields)
    }
}

object ResourceBid
extends
    Parseable[ResourceBid]
{
    val fields: Array[String] = Array[String] (
        "aggregationFlag",
        "bidStatus",
        "commodityType",
        "contingencyAvailFlag",
        "createdISO",
        "energyMaxDay",
        "energyMinDay",
        "marketSepFlag",
        "minDispatchTime",
        "resourceLoadingType",
        "shutDownsMaxDay",
        "shutDownsMaxWeek",
        "startUpsMaxDay",
        "startUpsMaxWeek",
        "virtual",
        "BidError"
    )
    val aggregationFlag: Fielder = parse_element (element (cls, fields(0)))
    val bidStatus: Fielder = parse_element (element (cls, fields(1)))
    val commodityType: Fielder = parse_element (element (cls, fields(2)))
    val contingencyAvailFlag: Fielder = parse_attribute (attribute (cls, fields(3)))
    val createdISO: Fielder = parse_attribute (attribute (cls, fields(4)))
    val energyMaxDay: Fielder = parse_element (element (cls, fields(5)))
    val energyMinDay: Fielder = parse_element (element (cls, fields(6)))
    val marketSepFlag: Fielder = parse_element (element (cls, fields(7)))
    val minDispatchTime: Fielder = parse_element (element (cls, fields(8)))
    val resourceLoadingType: Fielder = parse_element (element (cls, fields(9)))
    val shutDownsMaxDay: Fielder = parse_element (element (cls, fields(10)))
    val shutDownsMaxWeek: Fielder = parse_element (element (cls, fields(11)))
    val startUpsMaxDay: Fielder = parse_element (element (cls, fields(12)))
    val startUpsMaxWeek: Fielder = parse_element (element (cls, fields(13)))
    val virtual: Fielder = parse_element (element (cls, fields(14)))
    val BidError: FielderMultiple = parse_attributes (attribute (cls, fields(15)))

    def parse (context: Context): ResourceBid =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ResourceBid (
            Bid.parse (context),
            toInteger (mask (aggregationFlag (), 0)),
            mask (bidStatus (), 1),
            mask (commodityType (), 2),
            mask (contingencyAvailFlag (), 3),
            mask (createdISO (), 4),
            toDouble (mask (energyMaxDay (), 5)),
            toDouble (mask (energyMinDay (), 6)),
            mask (marketSepFlag (), 7),
            toInteger (mask (minDispatchTime (), 8)),
            toInteger (mask (resourceLoadingType (), 9)),
            toInteger (mask (shutDownsMaxDay (), 10)),
            toInteger (mask (shutDownsMaxWeek (), 11)),
            toInteger (mask (startUpsMaxDay (), 12)),
            toInteger (mask (startUpsMaxWeek (), 13)),
            toBoolean (mask (virtual (), 14)),
            masks (BidError (), 15)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("BidError", "BidError", true)
    )
}

/**
 * Startup costs and time as a function of down time.
 *
 * Relationship between unit startup cost (Y1-axis) vs. unit elapsed down time (X-axis).
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param RegisteredGenerators [[ch.ninecode.model.RegisteredGenerator RegisteredGenerator]] <em>undocumented</em>
 * @group ParticipantInterfaces
 * @groupname ParticipantInterfaces Package ParticipantInterfaces
 * @groupdesc ParticipantInterfaces Market participant interfaces for bids and trades.
 */
case class StartUpCostCurve
(
    override val sup: Curve,
    RegisteredGenerators: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[StartUpCostCurve] }
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
        implicit val clz: String = StartUpCostCurve.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (StartUpCostCurve.fields (position), x))
        emitattrs (0, RegisteredGenerators)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:StartUpCostCurve rdf:ID=\"%s\">\n%s\t</cim:StartUpCostCurve>".format (id, export_fields)
    }
}

object StartUpCostCurve
extends
    Parseable[StartUpCostCurve]
{
    val fields: Array[String] = Array[String] (
        "RegisteredGenerators"
    )
    val RegisteredGenerators: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): StartUpCostCurve =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = StartUpCostCurve (
            Curve.parse (context),
            masks (RegisteredGenerators (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("RegisteredGenerators", "RegisteredGenerator", true)
    )
}

/**
 * Startup time curve as a function of down time, where time is specified in minutes.
 *
 * Relationship between unit startup time (Y1-axis) vs. unit elapsed down time (X-axis).
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param RegisteredGenerator [[ch.ninecode.model.RegisteredGenerator RegisteredGenerator]] <em>undocumented</em>
 * @group ParticipantInterfaces
 * @groupname ParticipantInterfaces Package ParticipantInterfaces
 * @groupdesc ParticipantInterfaces Market participant interfaces for bids and trades.
 */
case class StartUpTimeCurve
(
    override val sup: Curve,
    RegisteredGenerator: String
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
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[StartUpTimeCurve] }
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
        implicit val clz: String = StartUpTimeCurve.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (StartUpTimeCurve.fields (position), value)
        emitattr (0, RegisteredGenerator)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:StartUpTimeCurve rdf:ID=\"%s\">\n%s\t</cim:StartUpTimeCurve>".format (id, export_fields)
    }
}

object StartUpTimeCurve
extends
    Parseable[StartUpTimeCurve]
{
    val fields: Array[String] = Array[String] (
        "RegisteredGenerator"
    )
    val RegisteredGenerator: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): StartUpTimeCurve =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = StartUpTimeCurve (
            Curve.parse (context),
            mask (RegisteredGenerator (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("RegisteredGenerator", "RegisteredGenerator", false)
    )
}

/**
 * Inter Scheduling Coordinator Trades to model financial trades which may impact settlement
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param adjustedTradeQuantity The validated and current market accepted trade amount of a physical energy trade.
 * @param counterTradeQuantity MW quantity submitted by counter SC for the same trade
 * @param dependOnTradeName The Depend On IST Name points to the unique IST Name in the chain of physical energy trades.
 * @param lastModified Time and date the trade was last modified.
 * @param marketType <em>undocumented</em>
 * @param startTime Start time and date for which trade applies.
 * @param stopTime Stop time and date for which trade is applicable.
 * @param submitFromSchedulingCoordinator [[ch.ninecode.model.SchedulingCoordinator SchedulingCoordinator]] <em>undocumented</em>
 * @param submitFromTimeStamp Timestamp of submittal of submit From Scheduling Coordinator Trade to Market Participant Bid Submittal
 * @param submitFromUser Userid of the submit From Scheduling Coordinator trade
 * @param submitToSchedulingCoordinator [[ch.ninecode.model.SchedulingCoordinator SchedulingCoordinator]] <em>undocumented</em>
 * @param submitToTimeStamp Timestamp of submittal of submit To Scheduling Coordinator Trade to Market Participant Bid Submittal
 * @param submitToUser_1 Userid of the submit To Scheduling Coordinator trade
 * @param tradeQuantity tradeQuantity:
 *        If tradeType = IST, The amount of an Energy Trade.
 *        If tradeType = AST, The amount of an Ancillary Service Obligation Trade.
 * @param tradeStatus Resulting status of the trade following the rule engine processing.
 * @param updateTimeStamp <em>undocumented</em>
 * @param updateUser <em>undocumented</em>
 * @param ActionRequest [[ch.ninecode.model.ActionRequest ActionRequest]] <em>undocumented</em>
 * @param From_SC [[ch.ninecode.model.SchedulingCoordinator SchedulingCoordinator]] <em>undocumented</em>
 * @param Pnode [[ch.ninecode.model.Pnode Pnode]] <em>undocumented</em>
 * @param RegisteredGenerator [[ch.ninecode.model.RegisteredGenerator RegisteredGenerator]] <em>undocumented</em>
 * @param To_SC [[ch.ninecode.model.SchedulingCoordinator SchedulingCoordinator]] <em>undocumented</em>
 * @param TradeProduct [[ch.ninecode.model.TradeProduct TradeProduct]] <em>undocumented</em>
 * @group ParticipantInterfaces
 * @groupname ParticipantInterfaces Package ParticipantInterfaces
 * @groupdesc ParticipantInterfaces Market participant interfaces for bids and trades.
 */
case class Trade
(
    override val sup: IdentifiedObject,
    adjustedTradeQuantity: Double,
    counterTradeQuantity: Double,
    dependOnTradeName: String,
    lastModified: String,
    marketType: String,
    startTime: String,
    stopTime: String,
    submitFromSchedulingCoordinator: String,
    submitFromTimeStamp: String,
    submitFromUser: String,
    submitToSchedulingCoordinator: String,
    submitToTimeStamp: String,
    submitToUser_1: String,
    tradeQuantity: Double,
    tradeStatus: String,
    updateTimeStamp: String,
    updateUser: String,
    ActionRequest: String,
    From_SC: String,
    Pnode: String,
    RegisteredGenerator: String,
    To_SC: String,
    TradeProduct: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, null, null, null, null, null, null, null, null, null, null, null, 0.0, null, null, null, null, null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Trade] }
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
        implicit val clz: String = Trade.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Trade.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Trade.fields (position), value)
        emitelem (0, adjustedTradeQuantity)
        emitelem (1, counterTradeQuantity)
        emitelem (2, dependOnTradeName)
        emitelem (3, lastModified)
        emitattr (4, marketType)
        emitelem (5, startTime)
        emitelem (6, stopTime)
        emitattr (7, submitFromSchedulingCoordinator)
        emitelem (8, submitFromTimeStamp)
        emitelem (9, submitFromUser)
        emitattr (10, submitToSchedulingCoordinator)
        emitelem (11, submitToTimeStamp)
        emitelem (12, submitToUser_1)
        emitelem (13, tradeQuantity)
        emitelem (14, tradeStatus)
        emitelem (15, updateTimeStamp)
        emitelem (16, updateUser)
        emitattr (17, ActionRequest)
        emitattr (18, From_SC)
        emitattr (19, Pnode)
        emitattr (20, RegisteredGenerator)
        emitattr (21, To_SC)
        emitattr (22, TradeProduct)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Trade rdf:ID=\"%s\">\n%s\t</cim:Trade>".format (id, export_fields)
    }
}

object Trade
extends
    Parseable[Trade]
{
    val fields: Array[String] = Array[String] (
        "adjustedTradeQuantity",
        "counterTradeQuantity",
        "dependOnTradeName",
        "lastModified",
        "marketType",
        "startTime",
        "stopTime",
        "submitFromSchedulingCoordinator",
        "submitFromTimeStamp",
        "submitFromUser",
        "submitToSchedulingCoordinator",
        "submitToTimeStamp",
        "submitToUser ",
        "tradeQuantity",
        "tradeStatus",
        "updateTimeStamp",
        "updateUser",
        "ActionRequest",
        "From_SC",
        "Pnode",
        "RegisteredGenerator",
        "To_SC",
        "TradeProduct"
    )
    val adjustedTradeQuantity: Fielder = parse_element (element (cls, fields(0)))
    val counterTradeQuantity: Fielder = parse_element (element (cls, fields(1)))
    val dependOnTradeName: Fielder = parse_element (element (cls, fields(2)))
    val lastModified: Fielder = parse_element (element (cls, fields(3)))
    val marketType: Fielder = parse_attribute (attribute (cls, fields(4)))
    val startTime: Fielder = parse_element (element (cls, fields(5)))
    val stopTime: Fielder = parse_element (element (cls, fields(6)))
    val submitFromSchedulingCoordinator: Fielder = parse_attribute (attribute (cls, fields(7)))
    val submitFromTimeStamp: Fielder = parse_element (element (cls, fields(8)))
    val submitFromUser: Fielder = parse_element (element (cls, fields(9)))
    val submitToSchedulingCoordinator: Fielder = parse_attribute (attribute (cls, fields(10)))
    val submitToTimeStamp: Fielder = parse_element (element (cls, fields(11)))
    val submitToUser_1: Fielder = parse_element (element (cls, fields(12)))
    val tradeQuantity: Fielder = parse_element (element (cls, fields(13)))
    val tradeStatus: Fielder = parse_element (element (cls, fields(14)))
    val updateTimeStamp: Fielder = parse_element (element (cls, fields(15)))
    val updateUser: Fielder = parse_element (element (cls, fields(16)))
    val ActionRequest: Fielder = parse_attribute (attribute (cls, fields(17)))
    val From_SC: Fielder = parse_attribute (attribute (cls, fields(18)))
    val Pnode: Fielder = parse_attribute (attribute (cls, fields(19)))
    val RegisteredGenerator: Fielder = parse_attribute (attribute (cls, fields(20)))
    val To_SC: Fielder = parse_attribute (attribute (cls, fields(21)))
    val TradeProduct: Fielder = parse_attribute (attribute (cls, fields(22)))

    def parse (context: Context): Trade =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Trade (
            IdentifiedObject.parse (context),
            toDouble (mask (adjustedTradeQuantity (), 0)),
            toDouble (mask (counterTradeQuantity (), 1)),
            mask (dependOnTradeName (), 2),
            mask (lastModified (), 3),
            mask (marketType (), 4),
            mask (startTime (), 5),
            mask (stopTime (), 6),
            mask (submitFromSchedulingCoordinator (), 7),
            mask (submitFromTimeStamp (), 8),
            mask (submitFromUser (), 9),
            mask (submitToSchedulingCoordinator (), 10),
            mask (submitToTimeStamp (), 11),
            mask (submitToUser_1 (), 12),
            toDouble (mask (tradeQuantity (), 13)),
            mask (tradeStatus (), 14),
            mask (updateTimeStamp (), 15),
            mask (updateUser (), 16),
            mask (ActionRequest (), 17),
            mask (From_SC (), 18),
            mask (Pnode (), 19),
            mask (RegisteredGenerator (), 20),
            mask (To_SC (), 21),
            mask (TradeProduct (), 22)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("submitFromSchedulingCoordinator", "SchedulingCoordinator", false),
        Relationship ("submitToSchedulingCoordinator", "SchedulingCoordinator", false),
        Relationship ("ActionRequest", "ActionRequest", false),
        Relationship ("From_SC", "SchedulingCoordinator", false),
        Relationship ("Pnode", "Pnode", false),
        Relationship ("RegisteredGenerator", "RegisteredGenerator", false),
        Relationship ("To_SC", "SchedulingCoordinator", false),
        Relationship ("TradeProduct", "TradeProduct", false)
    )
}

/**
 * Trade error and warning messages associated with the rule engine processing of the submitted trade.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param endTime hour wihthin the trade for which the error applies
 * @param errMessage error message
 * @param errPriority Priority number for the error message
 * @param logTimeStamp Timestamp of logged error/warning message
 * @param ruleID Rule identifier which triggered the error/warning message
 * @param startTime hour wihthin the trade for which the error applies
 * @param Trade [[ch.ninecode.model.Trade Trade]] <em>undocumented</em>
 * @group ParticipantInterfaces
 * @groupname ParticipantInterfaces Package ParticipantInterfaces
 * @groupdesc ParticipantInterfaces Market participant interfaces for bids and trades.
 */
case class TradeError
(
    override val sup: IdentifiedObject,
    endTime: String,
    errMessage: String,
    errPriority: Int,
    logTimeStamp: String,
    ruleID: Int,
    startTime: String,
    Trade: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, 0, null, 0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[TradeError] }
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
        implicit val clz: String = TradeError.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TradeError.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TradeError.fields (position), value)
        emitelem (0, endTime)
        emitelem (1, errMessage)
        emitelem (2, errPriority)
        emitelem (3, logTimeStamp)
        emitelem (4, ruleID)
        emitelem (5, startTime)
        emitattr (6, Trade)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TradeError rdf:ID=\"%s\">\n%s\t</cim:TradeError>".format (id, export_fields)
    }
}

object TradeError
extends
    Parseable[TradeError]
{
    val fields: Array[String] = Array[String] (
        "endTime",
        "errMessage",
        "errPriority",
        "logTimeStamp",
        "ruleID",
        "startTime",
        "Trade"
    )
    val endTime: Fielder = parse_element (element (cls, fields(0)))
    val errMessage: Fielder = parse_element (element (cls, fields(1)))
    val errPriority: Fielder = parse_element (element (cls, fields(2)))
    val logTimeStamp: Fielder = parse_element (element (cls, fields(3)))
    val ruleID: Fielder = parse_element (element (cls, fields(4)))
    val startTime: Fielder = parse_element (element (cls, fields(5)))
    val Trade: Fielder = parse_attribute (attribute (cls, fields(6)))

    def parse (context: Context): TradeError =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = TradeError (
            IdentifiedObject.parse (context),
            mask (endTime (), 0),
            mask (errMessage (), 1),
            toInteger (mask (errPriority (), 2)),
            mask (logTimeStamp (), 3),
            toInteger (mask (ruleID (), 4)),
            mask (startTime (), 5),
            mask (Trade (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Trade", "Trade", false)
    )
}

/**
 * <b>TradeType</b>                                        <b>TradeProduct</b>
 * IST  (InterSC Trade)                          PHY (Physical Energy Trade)
 * IST                                                  APN (Energy Trades at Aggregated Pricing Nodes)
 * IST                                                  CPT (Converted Physical Energy Trade)
 * AST (Ancilliary Services Trade)             RUT (Regulation Up Trade)
 * AST                                                 RDT (Regulation Down Trade)
 * AST                                                 SRT (Spinning Reserve Trade)
 * AST                                                 NRT (Non-Spinning Reserve Trade)
 *
 * UCT (Unit Commitment Trade)            null
 *
 * @param sup Reference to the superclass object.
 * @param tradeProductType PHY (Physical Energy Trade);
 *        APN (Energy Trades at Aggregated Pricing Nodes);
 *        CPT (Converted Physical Energy Trade);
 *        RUT (Regulation Up Trade);
 *        RDT (Regulation Down Trade);
 *        SRT (Spinning Reserve Trade);
 *        NRT (Non-Spinning Reserve Trade)
 * @param tradeType IST  - InterSC Trade;
 *        AST - Ancilliary Services Trade;
 *        UCT - Unit Commitment Trade
 * @group ParticipantInterfaces
 * @groupname ParticipantInterfaces Package ParticipantInterfaces
 * @groupdesc ParticipantInterfaces Market participant interfaces for bids and trades.
 */
case class TradeProduct
(
    override val sup: BasicElement,
    tradeProductType: String,
    tradeType: String
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
    override def copy (): Row = { clone ().asInstanceOf[TradeProduct] }
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
        implicit val clz: String = TradeProduct.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TradeProduct.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TradeProduct.fields (position), value)
        emitelem (0, tradeProductType)
        emitattr (1, tradeType)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TradeProduct rdf:ID=\"%s\">\n%s\t</cim:TradeProduct>".format (id, export_fields)
    }
}

object TradeProduct
extends
    Parseable[TradeProduct]
{
    val fields: Array[String] = Array[String] (
        "tradeProductType",
        "tradeType"
    )
    val tradeProductType: Fielder = parse_element (element (cls, fields(0)))
    val tradeType: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): TradeProduct =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = TradeProduct (
            BasicElement.parse (context),
            mask (tradeProductType (), 0),
            mask (tradeType (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Bilateral or scheduled transactions for energy and ancillary services considered by market clearing process
 *
 * @param sup [[ch.ninecode.model.Bid Bid]] Reference to the superclass object.
 * @param demandTransaction Set true if this is a demand transaction.
 * @param dispatchable Set true if this is a dispatchable transaction.
 * @param payCongestion Set true if this is a willing to pay transaction.
 *        This flag is used to determine whether a schedule is willing-to-pay-congestion or not.
 * @param Delivery_Pnode [[ch.ninecode.model.Pnode Pnode]] <em>undocumented</em>
 * @param Receipt_Pnode [[ch.ninecode.model.Pnode Pnode]] <em>undocumented</em>
 * @param TransmissionReservation [[ch.ninecode.model.TransmissionReservation TransmissionReservation]] <em>undocumented</em>
 * @group ParticipantInterfaces
 * @groupname ParticipantInterfaces Package ParticipantInterfaces
 * @groupdesc ParticipantInterfaces Market participant interfaces for bids and trades.
 */
case class TransactionBid
(
    override val sup: Bid,
    demandTransaction: Boolean,
    dispatchable: Boolean,
    payCongestion: Boolean,
    Delivery_Pnode: String,
    Receipt_Pnode: String,
    TransmissionReservation: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, false, false, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Bid: Bid = sup.asInstanceOf[Bid]
    override def copy (): Row = { clone ().asInstanceOf[TransactionBid] }
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
        implicit val clz: String = TransactionBid.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TransactionBid.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TransactionBid.fields (position), value)
        emitelem (0, demandTransaction)
        emitelem (1, dispatchable)
        emitelem (2, payCongestion)
        emitattr (3, Delivery_Pnode)
        emitattr (4, Receipt_Pnode)
        emitattr (5, TransmissionReservation)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TransactionBid rdf:ID=\"%s\">\n%s\t</cim:TransactionBid>".format (id, export_fields)
    }
}

object TransactionBid
extends
    Parseable[TransactionBid]
{
    val fields: Array[String] = Array[String] (
        "demandTransaction",
        "dispatchable",
        "payCongestion",
        "Delivery_Pnode",
        "Receipt_Pnode",
        "TransmissionReservation"
    )
    val demandTransaction: Fielder = parse_element (element (cls, fields(0)))
    val dispatchable: Fielder = parse_element (element (cls, fields(1)))
    val payCongestion: Fielder = parse_element (element (cls, fields(2)))
    val Delivery_Pnode: Fielder = parse_attribute (attribute (cls, fields(3)))
    val Receipt_Pnode: Fielder = parse_attribute (attribute (cls, fields(4)))
    val TransmissionReservation: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: Context): TransactionBid =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = TransactionBid (
            Bid.parse (context),
            toBoolean (mask (demandTransaction (), 0)),
            toBoolean (mask (dispatchable (), 1)),
            toBoolean (mask (payCongestion (), 2)),
            mask (Delivery_Pnode (), 3),
            mask (Receipt_Pnode (), 4),
            mask (TransmissionReservation (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Delivery_Pnode", "Pnode", false),
        Relationship ("Receipt_Pnode", "Pnode", false),
        Relationship ("TransmissionReservation", "TransmissionReservation", false)
    )
}

private[ninecode] object _ParticipantInterfaces
{
    def register: List[ClassInfo] =
    {
        List (
            ActionRequest.register,
            AreaLoadBid.register,
            AttributeProperty.register,
            Bid.register,
            BidDistributionFactor.register,
            BidError.register,
            BidHourlyProductSchedule.register,
            BidHourlySchedule.register,
            BidPriceCurve.register,
            BidPriceSchedule.register,
            BidSelfSched.register,
            BidSet.register,
            ChargeComponent.register,
            ChargeGroup.register,
            ChargeType.register,
            DispatchInstReply.register,
            EnergyPriceCurve.register,
            GeneratingBid.register,
            HourlyPreDispatchSchedule.register,
            InterTieBid.register,
            InterTieDispatchResponse.register,
            LoadBid.register,
            LoadFollowingInst.register,
            LoadReductionPriceCurve.register,
            MajorChargeGroup.register,
            MarketScheduledEvent.register,
            NotificationTimeCurve.register,
            OpenTieSchedule.register,
            ProductBid.register,
            PumpingCostSchedule.register,
            PumpingLevelSchedule.register,
            PumpingShutDownCostSchedule.register,
            RampRateCurve.register,
            ResourceBid.register,
            StartUpCostCurve.register,
            StartUpTimeCurve.register,
            Trade.register,
            TradeError.register,
            TradeProduct.register,
            TransactionBid.register
        )
    }
}