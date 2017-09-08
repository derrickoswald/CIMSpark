package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

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
        sup.export_fields +
        (if (null != actionName) "\t\t<cim:ActionRequest.actionName rdf:resource=\"#" + actionName + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ActionRequest rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ActionRequest>"
    }
}

object ActionRequest
extends
    Parseable[ActionRequest]
{
    val actionName = parse_attribute (attribute ("""ActionRequest.actionName"""))
    def parse (context: Context): ActionRequest =
    {
        ActionRequest(
            BasicElement.parse (context),
            actionName (context)
        )
    }
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
        sup.export_fields +
        "\t\t<cim:AreaLoadBid.demandBidMW>" + demandBidMW + "</cim:AreaLoadBid.demandBidMW>\n"
    }
    override def export: String =
    {
        "\t<cim:AreaLoadBid rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AreaLoadBid>"
    }
}

object AreaLoadBid
extends
    Parseable[AreaLoadBid]
{
    val demandBidMW = parse_element (element ("""AreaLoadBid.demandBidMW"""))
    def parse (context: Context): AreaLoadBid =
    {
        AreaLoadBid(
            Bid.parse (context),
            toDouble (demandBidMW (context), context)
        )
    }
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
        sup.export_fields +
        (if (null != propertyName) "\t\t<cim:AttributeProperty.propertyName>" + propertyName + "</cim:AttributeProperty.propertyName>\n" else "") +
        (if (null != propertyValue) "\t\t<cim:AttributeProperty.propertyValue>" + propertyValue + "</cim:AttributeProperty.propertyValue>\n" else "") +
        (if (null != sequence) "\t\t<cim:AttributeProperty.sequence>" + sequence + "</cim:AttributeProperty.sequence>\n" else "") +
        (if (null != MktUserAttribute) "\t\t<cim:AttributeProperty.MktUserAttribute rdf:resource=\"#" + MktUserAttribute + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AttributeProperty rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AttributeProperty>"
    }
}

object AttributeProperty
extends
    Parseable[AttributeProperty]
{
    val propertyName = parse_element (element ("""AttributeProperty.propertyName"""))
    val propertyValue = parse_element (element ("""AttributeProperty.propertyValue"""))
    val sequence = parse_element (element ("""AttributeProperty.sequence"""))
    val MktUserAttribute = parse_attribute (attribute ("""AttributeProperty.MktUserAttribute"""))
    def parse (context: Context): AttributeProperty =
    {
        AttributeProperty(
            BasicElement.parse (context),
            propertyName (context),
            propertyValue (context),
            sequence (context),
            MktUserAttribute (context)
        )
    }
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
        sup.export_fields +
        (if (null != marketType) "\t\t<cim:Bid.marketType rdf:resource=\"#" + marketType + "\"/>\n" else "") +
        (if (null != startTime) "\t\t<cim:Bid.startTime>" + startTime + "</cim:Bid.startTime>\n" else "") +
        (if (null != stopTime) "\t\t<cim:Bid.stopTime>" + stopTime + "</cim:Bid.stopTime>\n" else "") +
        (if (null != ActionRequest) "\t\t<cim:Bid.ActionRequest rdf:resource=\"#" + ActionRequest + "\"/>\n" else "") +
        (if (null != EnergyMarket) "\t\t<cim:Bid.EnergyMarket rdf:resource=\"#" + EnergyMarket + "\"/>\n" else "") +
        (if (null != MarketParticipant) "\t\t<cim:Bid.MarketParticipant rdf:resource=\"#" + MarketParticipant + "\"/>\n" else "") +
        (if (null != SchedulingCoordinator) "\t\t<cim:Bid.SchedulingCoordinator rdf:resource=\"#" + SchedulingCoordinator + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Bid rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Bid>"
    }
}

object Bid
extends
    Parseable[Bid]
{
    val marketType = parse_attribute (attribute ("""Bid.marketType"""))
    val startTime = parse_element (element ("""Bid.startTime"""))
    val stopTime = parse_element (element ("""Bid.stopTime"""))
    val ActionRequest = parse_attribute (attribute ("""Bid.ActionRequest"""))
    val EnergyMarket = parse_attribute (attribute ("""Bid.EnergyMarket"""))
    val MarketParticipant = parse_attribute (attribute ("""Bid.MarketParticipant"""))
    val SchedulingCoordinator = parse_attribute (attribute ("""Bid.SchedulingCoordinator"""))
    def parse (context: Context): Bid =
    {
        Bid(
            Document.parse (context),
            marketType (context),
            startTime (context),
            stopTime (context),
            ActionRequest (context),
            EnergyMarket (context),
            MarketParticipant (context),
            SchedulingCoordinator (context)
        )
    }
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
        sup.export_fields +
        (if (null != timeIntervalEnd) "\t\t<cim:BidDistributionFactor.timeIntervalEnd>" + timeIntervalEnd + "</cim:BidDistributionFactor.timeIntervalEnd>\n" else "") +
        (if (null != timeIntervalStart) "\t\t<cim:BidDistributionFactor.timeIntervalStart>" + timeIntervalStart + "</cim:BidDistributionFactor.timeIntervalStart>\n" else "") +
        (if (null != ProductBid) "\t\t<cim:BidDistributionFactor.ProductBid rdf:resource=\"#" + ProductBid + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:BidDistributionFactor rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:BidDistributionFactor>"
    }
}

object BidDistributionFactor
extends
    Parseable[BidDistributionFactor]
{
    val timeIntervalEnd = parse_element (element ("""BidDistributionFactor.timeIntervalEnd"""))
    val timeIntervalStart = parse_element (element ("""BidDistributionFactor.timeIntervalStart"""))
    val ProductBid = parse_attribute (attribute ("""BidDistributionFactor.ProductBid"""))
    def parse (context: Context): BidDistributionFactor =
    {
        BidDistributionFactor(
            BasicElement.parse (context),
            timeIntervalEnd (context),
            timeIntervalStart (context),
            ProductBid (context)
        )
    }
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
        sup.export_fields +
        (if (null != componentType) "\t\t<cim:BidError.componentType>" + componentType + "</cim:BidError.componentType>\n" else "") +
        (if (null != endTime) "\t\t<cim:BidError.endTime>" + endTime + "</cim:BidError.endTime>\n" else "") +
        (if (null != errMessage) "\t\t<cim:BidError.errMessage>" + errMessage + "</cim:BidError.errMessage>\n" else "") +
        "\t\t<cim:BidError.errPriority>" + errPriority + "</cim:BidError.errPriority>\n" +
        (if (null != logTimeStamp) "\t\t<cim:BidError.logTimeStamp>" + logTimeStamp + "</cim:BidError.logTimeStamp>\n" else "") +
        "\t\t<cim:BidError.msgLevel>" + msgLevel + "</cim:BidError.msgLevel>\n" +
        "\t\t<cim:BidError.ruleID>" + ruleID + "</cim:BidError.ruleID>\n" +
        (if (null != startTime) "\t\t<cim:BidError.startTime>" + startTime + "</cim:BidError.startTime>\n" else "") +
        (if (null != MarketProduct) "\t\t<cim:BidError.MarketProduct rdf:resource=\"#" + MarketProduct + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:BidError rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:BidError>"
    }
}

object BidError
extends
    Parseable[BidError]
{
    val componentType = parse_element (element ("""BidError.componentType"""))
    val endTime = parse_element (element ("""BidError.endTime"""))
    val errMessage = parse_element (element ("""BidError.errMessage"""))
    val errPriority = parse_element (element ("""BidError.errPriority"""))
    val logTimeStamp = parse_element (element ("""BidError.logTimeStamp"""))
    val msgLevel = parse_element (element ("""BidError.msgLevel"""))
    val ruleID = parse_element (element ("""BidError.ruleID"""))
    val startTime = parse_element (element ("""BidError.startTime"""))
    val MarketProduct = parse_attribute (attribute ("""BidError.MarketProduct"""))
    def parse (context: Context): BidError =
    {
        BidError(
            IdentifiedObject.parse (context),
            componentType (context),
            endTime (context),
            errMessage (context),
            toInteger (errPriority (context), context),
            logTimeStamp (context),
            toInteger (msgLevel (context), context),
            toInteger (ruleID (context), context),
            startTime (context),
            MarketProduct (context)
        )
    }
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
        sup.export_fields +
        (if (null != ProductBid) "\t\t<cim:BidHourlyProductSchedule.ProductBid rdf:resource=\"#" + ProductBid + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:BidHourlyProductSchedule rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:BidHourlyProductSchedule>"
    }
}

object BidHourlyProductSchedule
extends
    Parseable[BidHourlyProductSchedule]
{
    val ProductBid = parse_attribute (attribute ("""BidHourlyProductSchedule.ProductBid"""))
    def parse (context: Context): BidHourlyProductSchedule =
    {
        BidHourlyProductSchedule(
            RegularIntervalSchedule.parse (context),
            ProductBid (context)
        )
    }
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
        sup.export_fields +
        (if (null != Bid) "\t\t<cim:BidHourlySchedule.Bid rdf:resource=\"#" + Bid + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:BidHourlySchedule rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:BidHourlySchedule>"
    }
}

object BidHourlySchedule
extends
    Parseable[BidHourlySchedule]
{
    val Bid = parse_attribute (attribute ("""BidHourlySchedule.Bid"""))
    def parse (context: Context): BidHourlySchedule =
    {
        BidHourlySchedule(
            RegularIntervalSchedule.parse (context),
            Bid (context)
        )
    }
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:BidPriceCurve rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:BidPriceCurve>"
    }
}

object BidPriceCurve
extends
    Parseable[BidPriceCurve]
{
    def parse (context: Context): BidPriceCurve =
    {
        BidPriceCurve(
            Curve.parse (context)
        )
    }
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
        sup.export_fields +
        (if (null != bidType) "\t\t<cim:BidPriceSchedule.bidType rdf:resource=\"#" + bidType + "\"/>\n" else "") +
        (if (null != mitigationStatus) "\t\t<cim:BidPriceSchedule.mitigationStatus rdf:resource=\"#" + mitigationStatus + "\"/>\n" else "") +
        (if (null != BidPriceCurve) "\t\t<cim:BidPriceSchedule.BidPriceCurve rdf:resource=\"#" + BidPriceCurve + "\"/>\n" else "") +
        (if (null != ProductBid) "\t\t<cim:BidPriceSchedule.ProductBid rdf:resource=\"#" + ProductBid + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:BidPriceSchedule rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:BidPriceSchedule>"
    }
}

object BidPriceSchedule
extends
    Parseable[BidPriceSchedule]
{
    val bidType = parse_attribute (attribute ("""BidPriceSchedule.bidType"""))
    val mitigationStatus = parse_attribute (attribute ("""BidPriceSchedule.mitigationStatus"""))
    val BidPriceCurve = parse_attribute (attribute ("""BidPriceSchedule.BidPriceCurve"""))
    val ProductBid = parse_attribute (attribute ("""BidPriceSchedule.ProductBid"""))
    def parse (context: Context): BidPriceSchedule =
    {
        BidPriceSchedule(
            RegularIntervalSchedule.parse (context),
            bidType (context),
            mitigationStatus (context),
            BidPriceCurve (context),
            ProductBid (context)
        )
    }
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
        sup.export_fields +
        (if (null != balancingFlag) "\t\t<cim:BidSelfSched.balancingFlag rdf:resource=\"#" + balancingFlag + "\"/>\n" else "") +
        (if (null != bidType) "\t\t<cim:BidSelfSched.bidType rdf:resource=\"#" + bidType + "\"/>\n" else "") +
        (if (null != priorityFlag) "\t\t<cim:BidSelfSched.priorityFlag rdf:resource=\"#" + priorityFlag + "\"/>\n" else "") +
        "\t\t<cim:BidSelfSched.pumpSelfSchedMw>" + pumpSelfSchedMw + "</cim:BidSelfSched.pumpSelfSchedMw>\n" +
        (if (null != referenceType) "\t\t<cim:BidSelfSched.referenceType rdf:resource=\"#" + referenceType + "\"/>\n" else "") +
        "\t\t<cim:BidSelfSched.selfSchedMw>" + selfSchedMw + "</cim:BidSelfSched.selfSchedMw>\n" +
        (if (null != selfSchedSptResource) "\t\t<cim:BidSelfSched.selfSchedSptResource>" + selfSchedSptResource + "</cim:BidSelfSched.selfSchedSptResource>\n" else "") +
        (if (null != selfSchedType) "\t\t<cim:BidSelfSched.selfSchedType rdf:resource=\"#" + selfSchedType + "\"/>\n" else "") +
        (if (null != updateType) "\t\t<cim:BidSelfSched.updateType rdf:resource=\"#" + updateType + "\"/>\n" else "") +
        (if (null != wheelingTransactionReference) "\t\t<cim:BidSelfSched.wheelingTransactionReference>" + wheelingTransactionReference + "</cim:BidSelfSched.wheelingTransactionReference>\n" else "") +
        (if (null != AdjacentCASet) "\t\t<cim:BidSelfSched.AdjacentCASet rdf:resource=\"#" + AdjacentCASet + "\"/>\n" else "") +
        (if (null != HostControlArea) "\t\t<cim:BidSelfSched.HostControlArea rdf:resource=\"#" + HostControlArea + "\"/>\n" else "") +
        (if (null != ProductBid) "\t\t<cim:BidSelfSched.ProductBid rdf:resource=\"#" + ProductBid + "\"/>\n" else "") +
        (if (null != SubControlArea) "\t\t<cim:BidSelfSched.SubControlArea rdf:resource=\"#" + SubControlArea + "\"/>\n" else "") +
        (if (null != TransmissionContractRight) "\t\t<cim:BidSelfSched.TransmissionContractRight rdf:resource=\"#" + TransmissionContractRight + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:BidSelfSched rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:BidSelfSched>"
    }
}

object BidSelfSched
extends
    Parseable[BidSelfSched]
{
    val balancingFlag = parse_attribute (attribute ("""BidSelfSched.balancingFlag"""))
    val bidType = parse_attribute (attribute ("""BidSelfSched.bidType"""))
    val priorityFlag = parse_attribute (attribute ("""BidSelfSched.priorityFlag"""))
    val pumpSelfSchedMw = parse_element (element ("""BidSelfSched.pumpSelfSchedMw"""))
    val referenceType = parse_attribute (attribute ("""BidSelfSched.referenceType"""))
    val selfSchedMw = parse_element (element ("""BidSelfSched.selfSchedMw"""))
    val selfSchedSptResource = parse_element (element ("""BidSelfSched.selfSchedSptResource"""))
    val selfSchedType = parse_attribute (attribute ("""BidSelfSched.selfSchedType"""))
    val updateType = parse_attribute (attribute ("""BidSelfSched.updateType"""))
    val wheelingTransactionReference = parse_element (element ("""BidSelfSched.wheelingTransactionReference"""))
    val AdjacentCASet = parse_attribute (attribute ("""BidSelfSched.AdjacentCASet"""))
    val HostControlArea = parse_attribute (attribute ("""BidSelfSched.HostControlArea"""))
    val ProductBid = parse_attribute (attribute ("""BidSelfSched.ProductBid"""))
    val SubControlArea = parse_attribute (attribute ("""BidSelfSched.SubControlArea"""))
    val TransmissionContractRight = parse_attribute (attribute ("""BidSelfSched.TransmissionContractRight"""))
    def parse (context: Context): BidSelfSched =
    {
        BidSelfSched(
            RegularIntervalSchedule.parse (context),
            balancingFlag (context),
            bidType (context),
            priorityFlag (context),
            toDouble (pumpSelfSchedMw (context), context),
            referenceType (context),
            toDouble (selfSchedMw (context), context),
            selfSchedSptResource (context),
            selfSchedType (context),
            updateType (context),
            wheelingTransactionReference (context),
            AdjacentCASet (context),
            HostControlArea (context),
            ProductBid (context),
            SubControlArea (context),
            TransmissionContractRight (context)
        )
    }
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:BidSet rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:BidSet>"
    }
}

object BidSet
extends
    Parseable[BidSet]
{
    def parse (context: Context): BidSet =
    {
        BidSet(
            IdentifiedObject.parse (context)
        )
    }
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
        sup.export_fields +
        (if (null != deleteStatus) "\t\t<cim:ChargeComponent.deleteStatus>" + deleteStatus + "</cim:ChargeComponent.deleteStatus>\n" else "") +
        (if (null != effectiveDate) "\t\t<cim:ChargeComponent.effectiveDate>" + effectiveDate + "</cim:ChargeComponent.effectiveDate>\n" else "") +
        (if (null != equation) "\t\t<cim:ChargeComponent.equation>" + equation + "</cim:ChargeComponent.equation>\n" else "") +
        (if (null != message) "\t\t<cim:ChargeComponent.message>" + message + "</cim:ChargeComponent.message>\n" else "") +
        (if (null != roundOff) "\t\t<cim:ChargeComponent.roundOff>" + roundOff + "</cim:ChargeComponent.roundOff>\n" else "") +
        (if (null != sum) "\t\t<cim:ChargeComponent.sum>" + sum + "</cim:ChargeComponent.sum>\n" else "") +
        (if (null != terminationDate) "\t\t<cim:ChargeComponent.terminationDate>" + terminationDate + "</cim:ChargeComponent.terminationDate>\n" else "") +
        (if (null != typ) "\t\t<cim:ChargeComponent.type>" + typ + "</cim:ChargeComponent.type>\n" else "") +
        (if (null != BillDeterminants) BillDeterminants.map (x => "\t\t<cim:ChargeComponent.BillDeterminants rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:ChargeComponent rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ChargeComponent>"
    }
}

object ChargeComponent
extends
    Parseable[ChargeComponent]
{
    val deleteStatus = parse_element (element ("""ChargeComponent.deleteStatus"""))
    val effectiveDate = parse_element (element ("""ChargeComponent.effectiveDate"""))
    val equation = parse_element (element ("""ChargeComponent.equation"""))
    val message = parse_element (element ("""ChargeComponent.message"""))
    val roundOff = parse_element (element ("""ChargeComponent.roundOff"""))
    val sum = parse_element (element ("""ChargeComponent.sum"""))
    val terminationDate = parse_element (element ("""ChargeComponent.terminationDate"""))
    val typ = parse_element (element ("""ChargeComponent.type"""))
    val BillDeterminants = parse_attributes (attribute ("""ChargeComponent.BillDeterminants"""))
    def parse (context: Context): ChargeComponent =
    {
        ChargeComponent(
            IdentifiedObject.parse (context),
            deleteStatus (context),
            effectiveDate (context),
            equation (context),
            message (context),
            roundOff (context),
            sum (context),
            terminationDate (context),
            typ (context),
            BillDeterminants (context)
        )
    }
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
        sup.export_fields +
        (if (null != effectiveDate) "\t\t<cim:ChargeGroup.effectiveDate>" + effectiveDate + "</cim:ChargeGroup.effectiveDate>\n" else "") +
        (if (null != marketCode) "\t\t<cim:ChargeGroup.marketCode>" + marketCode + "</cim:ChargeGroup.marketCode>\n" else "") +
        (if (null != terminationDate) "\t\t<cim:ChargeGroup.terminationDate>" + terminationDate + "</cim:ChargeGroup.terminationDate>\n" else "") +
        (if (null != ChargeGroupParent) "\t\t<cim:ChargeGroup.ChargeGroupParent rdf:resource=\"#" + ChargeGroupParent + "\"/>\n" else "") +
        (if (null != MktUserAttribute) MktUserAttribute.map (x => "\t\t<cim:ChargeGroup.MktUserAttribute rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:ChargeGroup rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ChargeGroup>"
    }
}

object ChargeGroup
extends
    Parseable[ChargeGroup]
{
    val effectiveDate = parse_element (element ("""ChargeGroup.effectiveDate"""))
    val marketCode = parse_element (element ("""ChargeGroup.marketCode"""))
    val terminationDate = parse_element (element ("""ChargeGroup.terminationDate"""))
    val ChargeGroupParent = parse_attribute (attribute ("""ChargeGroup.ChargeGroupParent"""))
    val MktUserAttribute = parse_attributes (attribute ("""ChargeGroup.MktUserAttribute"""))
    def parse (context: Context): ChargeGroup =
    {
        ChargeGroup(
            IdentifiedObject.parse (context),
            effectiveDate (context),
            marketCode (context),
            terminationDate (context),
            ChargeGroupParent (context),
            MktUserAttribute (context)
        )
    }
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
        sup.export_fields +
        (if (null != chargeOrder) "\t\t<cim:ChargeType.chargeOrder>" + chargeOrder + "</cim:ChargeType.chargeOrder>\n" else "") +
        (if (null != chargeVersion) "\t\t<cim:ChargeType.chargeVersion>" + chargeVersion + "</cim:ChargeType.chargeVersion>\n" else "") +
        (if (null != effectiveDate) "\t\t<cim:ChargeType.effectiveDate>" + effectiveDate + "</cim:ChargeType.effectiveDate>\n" else "") +
        (if (null != factor) "\t\t<cim:ChargeType.factor>" + factor + "</cim:ChargeType.factor>\n" else "") +
        (if (null != frequencyType) "\t\t<cim:ChargeType.frequencyType>" + frequencyType + "</cim:ChargeType.frequencyType>\n" else "") +
        (if (null != terminationDate) "\t\t<cim:ChargeType.terminationDate>" + terminationDate + "</cim:ChargeType.terminationDate>\n" else "") +
        (if (null != totalInterval) "\t\t<cim:ChargeType.totalInterval>" + totalInterval + "</cim:ChargeType.totalInterval>\n" else "") +
        (if (null != ChargeComponents) ChargeComponents.map (x => "\t\t<cim:ChargeType.ChargeComponents rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != ChargeGroup) ChargeGroup.map (x => "\t\t<cim:ChargeType.ChargeGroup rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != MktUserAttribute) MktUserAttribute.map (x => "\t\t<cim:ChargeType.MktUserAttribute rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:ChargeType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ChargeType>"
    }
}

object ChargeType
extends
    Parseable[ChargeType]
{
    val chargeOrder = parse_element (element ("""ChargeType.chargeOrder"""))
    val chargeVersion = parse_element (element ("""ChargeType.chargeVersion"""))
    val effectiveDate = parse_element (element ("""ChargeType.effectiveDate"""))
    val factor = parse_element (element ("""ChargeType.factor"""))
    val frequencyType = parse_element (element ("""ChargeType.frequencyType"""))
    val terminationDate = parse_element (element ("""ChargeType.terminationDate"""))
    val totalInterval = parse_element (element ("""ChargeType.totalInterval"""))
    val ChargeComponents = parse_attributes (attribute ("""ChargeType.ChargeComponents"""))
    val ChargeGroup = parse_attributes (attribute ("""ChargeType.ChargeGroup"""))
    val MktUserAttribute = parse_attributes (attribute ("""ChargeType.MktUserAttribute"""))
    def parse (context: Context): ChargeType =
    {
        ChargeType(
            Document.parse (context),
            chargeOrder (context),
            chargeVersion (context),
            effectiveDate (context),
            factor (context),
            frequencyType (context),
            terminationDate (context),
            totalInterval (context),
            ChargeComponents (context),
            ChargeGroup (context),
            MktUserAttribute (context)
        )
    }
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
        sup.export_fields +
        "\t\t<cim:DispatchInstReply.acceptMW>" + acceptMW + "</cim:DispatchInstReply.acceptMW>\n" +
        (if (null != acceptStatus) "\t\t<cim:DispatchInstReply.acceptStatus rdf:resource=\"#" + acceptStatus + "\"/>\n" else "") +
        (if (null != certificationName) "\t\t<cim:DispatchInstReply.certificationName>" + certificationName + "</cim:DispatchInstReply.certificationName>\n" else "") +
        "\t\t<cim:DispatchInstReply.clearedMW>" + clearedMW + "</cim:DispatchInstReply.clearedMW>\n" +
        (if (null != instructionTime) "\t\t<cim:DispatchInstReply.instructionTime>" + instructionTime + "</cim:DispatchInstReply.instructionTime>\n" else "") +
        (if (null != instructionType) "\t\t<cim:DispatchInstReply.instructionType>" + instructionType + "</cim:DispatchInstReply.instructionType>\n" else "") +
        (if (null != passIndicator) "\t\t<cim:DispatchInstReply.passIndicator rdf:resource=\"#" + passIndicator + "\"/>\n" else "") +
        (if (null != receivedTime) "\t\t<cim:DispatchInstReply.receivedTime>" + receivedTime + "</cim:DispatchInstReply.receivedTime>\n" else "") +
        (if (null != startTime) "\t\t<cim:DispatchInstReply.startTime>" + startTime + "</cim:DispatchInstReply.startTime>\n" else "") +
        (if (null != RegisteredResource) "\t\t<cim:DispatchInstReply.RegisteredResource rdf:resource=\"#" + RegisteredResource + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:DispatchInstReply rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DispatchInstReply>"
    }
}

object DispatchInstReply
extends
    Parseable[DispatchInstReply]
{
    val acceptMW = parse_element (element ("""DispatchInstReply.acceptMW"""))
    val acceptStatus = parse_attribute (attribute ("""DispatchInstReply.acceptStatus"""))
    val certificationName = parse_element (element ("""DispatchInstReply.certificationName"""))
    val clearedMW = parse_element (element ("""DispatchInstReply.clearedMW"""))
    val instructionTime = parse_element (element ("""DispatchInstReply.instructionTime"""))
    val instructionType = parse_element (element ("""DispatchInstReply.instructionType"""))
    val passIndicator = parse_attribute (attribute ("""DispatchInstReply.passIndicator"""))
    val receivedTime = parse_element (element ("""DispatchInstReply.receivedTime"""))
    val startTime = parse_element (element ("""DispatchInstReply.startTime"""))
    val RegisteredResource = parse_attribute (attribute ("""DispatchInstReply.RegisteredResource"""))
    def parse (context: Context): DispatchInstReply =
    {
        DispatchInstReply(
            IdentifiedObject.parse (context),
            toDouble (acceptMW (context), context),
            acceptStatus (context),
            certificationName (context),
            toDouble (clearedMW (context), context),
            instructionTime (context),
            instructionType (context),
            passIndicator (context),
            receivedTime (context),
            startTime (context),
            RegisteredResource (context)
        )
    }
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:EnergyPriceCurve rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:EnergyPriceCurve>"
    }
}

object EnergyPriceCurve
extends
    Parseable[EnergyPriceCurve]
{
    def parse (context: Context): EnergyPriceCurve =
    {
        EnergyPriceCurve(
            BasicElement.parse (context)
        )
    }
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
        sup.export_fields +
        (if (null != combinedCycleUnitOffer) "\t\t<cim:GeneratingBid.combinedCycleUnitOffer>" + combinedCycleUnitOffer + "</cim:GeneratingBid.combinedCycleUnitOffer>\n" else "") +
        "\t\t<cim:GeneratingBid.downTimeMax>" + downTimeMax + "</cim:GeneratingBid.downTimeMax>\n" +
        "\t\t<cim:GeneratingBid.installedCapacity>" + installedCapacity + "</cim:GeneratingBid.installedCapacity>\n" +
        "\t\t<cim:GeneratingBid.lowerRampRate>" + lowerRampRate + "</cim:GeneratingBid.lowerRampRate>\n" +
        "\t\t<cim:GeneratingBid.maxEmergencyMW>" + maxEmergencyMW + "</cim:GeneratingBid.maxEmergencyMW>\n" +
        "\t\t<cim:GeneratingBid.maximumEconomicMW>" + maximumEconomicMW + "</cim:GeneratingBid.maximumEconomicMW>\n" +
        "\t\t<cim:GeneratingBid.minEmergencyMW>" + minEmergencyMW + "</cim:GeneratingBid.minEmergencyMW>\n" +
        "\t\t<cim:GeneratingBid.minimumEconomicMW>" + minimumEconomicMW + "</cim:GeneratingBid.minimumEconomicMW>\n" +
        "\t\t<cim:GeneratingBid.noLoadCost>" + noLoadCost + "</cim:GeneratingBid.noLoadCost>\n" +
        "\t\t<cim:GeneratingBid.notificationTime>" + notificationTime + "</cim:GeneratingBid.notificationTime>\n" +
        (if (null != operatingMode) "\t\t<cim:GeneratingBid.operatingMode>" + operatingMode + "</cim:GeneratingBid.operatingMode>\n" else "") +
        "\t\t<cim:GeneratingBid.raiseRampRate>" + raiseRampRate + "</cim:GeneratingBid.raiseRampRate>\n" +
        "\t\t<cim:GeneratingBid.rampCurveType>" + rampCurveType + "</cim:GeneratingBid.rampCurveType>\n" +
        "\t\t<cim:GeneratingBid.startUpRampRate>" + startUpRampRate + "</cim:GeneratingBid.startUpRampRate>\n" +
        "\t\t<cim:GeneratingBid.startUpType>" + startUpType + "</cim:GeneratingBid.startUpType>\n" +
        "\t\t<cim:GeneratingBid.startupCost>" + startupCost + "</cim:GeneratingBid.startupCost>\n" +
        "\t\t<cim:GeneratingBid.upTimeMax>" + upTimeMax + "</cim:GeneratingBid.upTimeMax>\n" +
        (if (null != BidSet) "\t\t<cim:GeneratingBid.BidSet rdf:resource=\"#" + BidSet + "\"/>\n" else "") +
        (if (null != NotificationTimeCurve) "\t\t<cim:GeneratingBid.NotificationTimeCurve rdf:resource=\"#" + NotificationTimeCurve + "\"/>\n" else "") +
        (if (null != RegisteredGenerator) "\t\t<cim:GeneratingBid.RegisteredGenerator rdf:resource=\"#" + RegisteredGenerator + "\"/>\n" else "") +
        (if (null != StartUpCostCurve) "\t\t<cim:GeneratingBid.StartUpCostCurve rdf:resource=\"#" + StartUpCostCurve + "\"/>\n" else "") +
        (if (null != StartUpTimeCurve) "\t\t<cim:GeneratingBid.StartUpTimeCurve rdf:resource=\"#" + StartUpTimeCurve + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:GeneratingBid rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GeneratingBid>"
    }
}

object GeneratingBid
extends
    Parseable[GeneratingBid]
{
    val combinedCycleUnitOffer = parse_element (element ("""GeneratingBid.combinedCycleUnitOffer"""))
    val downTimeMax = parse_element (element ("""GeneratingBid.downTimeMax"""))
    val installedCapacity = parse_element (element ("""GeneratingBid.installedCapacity"""))
    val lowerRampRate = parse_element (element ("""GeneratingBid.lowerRampRate"""))
    val maxEmergencyMW = parse_element (element ("""GeneratingBid.maxEmergencyMW"""))
    val maximumEconomicMW = parse_element (element ("""GeneratingBid.maximumEconomicMW"""))
    val minEmergencyMW = parse_element (element ("""GeneratingBid.minEmergencyMW"""))
    val minimumEconomicMW = parse_element (element ("""GeneratingBid.minimumEconomicMW"""))
    val noLoadCost = parse_element (element ("""GeneratingBid.noLoadCost"""))
    val notificationTime = parse_element (element ("""GeneratingBid.notificationTime"""))
    val operatingMode = parse_element (element ("""GeneratingBid.operatingMode"""))
    val raiseRampRate = parse_element (element ("""GeneratingBid.raiseRampRate"""))
    val rampCurveType = parse_element (element ("""GeneratingBid.rampCurveType"""))
    val startUpRampRate = parse_element (element ("""GeneratingBid.startUpRampRate"""))
    val startUpType = parse_element (element ("""GeneratingBid.startUpType"""))
    val startupCost = parse_element (element ("""GeneratingBid.startupCost"""))
    val upTimeMax = parse_element (element ("""GeneratingBid.upTimeMax"""))
    val BidSet = parse_attribute (attribute ("""GeneratingBid.BidSet"""))
    val NotificationTimeCurve = parse_attribute (attribute ("""GeneratingBid.NotificationTimeCurve"""))
    val RegisteredGenerator = parse_attribute (attribute ("""GeneratingBid.RegisteredGenerator"""))
    val StartUpCostCurve = parse_attribute (attribute ("""GeneratingBid.StartUpCostCurve"""))
    val StartUpTimeCurve = parse_attribute (attribute ("""GeneratingBid.StartUpTimeCurve"""))
    def parse (context: Context): GeneratingBid =
    {
        GeneratingBid(
            ResourceBid.parse (context),
            combinedCycleUnitOffer (context),
            toDouble (downTimeMax (context), context),
            toDouble (installedCapacity (context), context),
            toDouble (lowerRampRate (context), context),
            toDouble (maxEmergencyMW (context), context),
            toDouble (maximumEconomicMW (context), context),
            toDouble (minEmergencyMW (context), context),
            toDouble (minimumEconomicMW (context), context),
            toDouble (noLoadCost (context), context),
            toDouble (notificationTime (context), context),
            operatingMode (context),
            toDouble (raiseRampRate (context), context),
            toInteger (rampCurveType (context), context),
            toDouble (startUpRampRate (context), context),
            toInteger (startUpType (context), context),
            toDouble (startupCost (context), context),
            toDouble (upTimeMax (context), context),
            BidSet (context),
            NotificationTimeCurve (context),
            RegisteredGenerator (context),
            StartUpCostCurve (context),
            StartUpTimeCurve (context)
        )
    }
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
        sup.export_fields +
        "\t\t<cim:HourlyPreDispatchSchedule.value>" + value + "</cim:HourlyPreDispatchSchedule.value>\n"
    }
    override def export: String =
    {
        "\t<cim:HourlyPreDispatchSchedule rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:HourlyPreDispatchSchedule>"
    }
}

object HourlyPreDispatchSchedule
extends
    Parseable[HourlyPreDispatchSchedule]
{
    val value = parse_element (element ("""HourlyPreDispatchSchedule.value"""))
    def parse (context: Context): HourlyPreDispatchSchedule =
    {
        HourlyPreDispatchSchedule(
            BidHourlySchedule.parse (context),
            toBoolean (value (context), context)
        )
    }
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
        sup.export_fields +
        "\t\t<cim:InterTieBid.minHourlyBlock >" + minHourlyBlock_1 + "</cim:InterTieBid.minHourlyBlock >\n" +
        (if (null != RegisteredInterTie) "\t\t<cim:InterTieBid.RegisteredInterTie rdf:resource=\"#" + RegisteredInterTie + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:InterTieBid rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:InterTieBid>"
    }
}

object InterTieBid
extends
    Parseable[InterTieBid]
{
    val minHourlyBlock_1 = parse_element (element ("""InterTieBid.minHourlyBlock """))
    val RegisteredInterTie = parse_attribute (attribute ("""InterTieBid.RegisteredInterTie"""))
    def parse (context: Context): InterTieBid =
    {
        InterTieBid(
            ResourceBid.parse (context),
            toInteger (minHourlyBlock_1 (context), context),
            RegisteredInterTie (context)
        )
    }
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
        sup.export_fields +
        "\t\t<cim:InterTieDispatchResponse.acceptMW>" + acceptMW + "</cim:InterTieDispatchResponse.acceptMW>\n" +
        (if (null != acceptStatus) "\t\t<cim:InterTieDispatchResponse.acceptStatus rdf:resource=\"#" + acceptStatus + "\"/>\n" else "") +
        "\t\t<cim:InterTieDispatchResponse.clearedMW>" + clearedMW + "</cim:InterTieDispatchResponse.clearedMW>\n" +
        (if (null != passIndicator) "\t\t<cim:InterTieDispatchResponse.passIndicator rdf:resource=\"#" + passIndicator + "\"/>\n" else "") +
        (if (null != startTime) "\t\t<cim:InterTieDispatchResponse.startTime>" + startTime + "</cim:InterTieDispatchResponse.startTime>\n" else "") +
        (if (null != RegisteredInterTie) "\t\t<cim:InterTieDispatchResponse.RegisteredInterTie rdf:resource=\"#" + RegisteredInterTie + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:InterTieDispatchResponse rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:InterTieDispatchResponse>"
    }
}

object InterTieDispatchResponse
extends
    Parseable[InterTieDispatchResponse]
{
    val acceptMW = parse_element (element ("""InterTieDispatchResponse.acceptMW"""))
    val acceptStatus = parse_attribute (attribute ("""InterTieDispatchResponse.acceptStatus"""))
    val clearedMW = parse_element (element ("""InterTieDispatchResponse.clearedMW"""))
    val passIndicator = parse_attribute (attribute ("""InterTieDispatchResponse.passIndicator"""))
    val startTime = parse_element (element ("""InterTieDispatchResponse.startTime"""))
    val RegisteredInterTie = parse_attribute (attribute ("""InterTieDispatchResponse.RegisteredInterTie"""))
    def parse (context: Context): InterTieDispatchResponse =
    {
        InterTieDispatchResponse(
            BasicElement.parse (context),
            toDouble (acceptMW (context), context),
            acceptStatus (context),
            toDouble (clearedMW (context), context),
            passIndicator (context),
            startTime (context),
            RegisteredInterTie (context)
        )
    }
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
        sup.export_fields +
        "\t\t<cim:LoadBid.dropRampRate>" + dropRampRate + "</cim:LoadBid.dropRampRate>\n" +
        "\t\t<cim:LoadBid.loadRedInitiationCost>" + loadRedInitiationCost + "</cim:LoadBid.loadRedInitiationCost>\n" +
        "\t\t<cim:LoadBid.loadRedInitiationTime>" + loadRedInitiationTime + "</cim:LoadBid.loadRedInitiationTime>\n" +
        (if (null != marketDate) "\t\t<cim:LoadBid.marketDate>" + marketDate + "</cim:LoadBid.marketDate>\n" else "") +
        "\t\t<cim:LoadBid.meteredValue>" + meteredValue + "</cim:LoadBid.meteredValue>\n" +
        "\t\t<cim:LoadBid.minLoad>" + minLoad + "</cim:LoadBid.minLoad>\n" +
        "\t\t<cim:LoadBid.minLoadReduction>" + minLoadReduction + "</cim:LoadBid.minLoadReduction>\n" +
        "\t\t<cim:LoadBid.minLoadReductionCost>" + minLoadReductionCost + "</cim:LoadBid.minLoadReductionCost>\n" +
        "\t\t<cim:LoadBid.minLoadReductionInterval>" + minLoadReductionInterval + "</cim:LoadBid.minLoadReductionInterval>\n" +
        "\t\t<cim:LoadBid.minTimeBetLoadRed>" + minTimeBetLoadRed + "</cim:LoadBid.minTimeBetLoadRed>\n" +
        "\t\t<cim:LoadBid.pickUpRampRate>" + pickUpRampRate + "</cim:LoadBid.pickUpRampRate>\n" +
        "\t\t<cim:LoadBid.priceSetting>" + priceSetting + "</cim:LoadBid.priceSetting>\n" +
        "\t\t<cim:LoadBid.reqNoticeTime>" + reqNoticeTime + "</cim:LoadBid.reqNoticeTime>\n" +
        "\t\t<cim:LoadBid.shutdownCost>" + shutdownCost + "</cim:LoadBid.shutdownCost>\n" +
        (if (null != AreaLoadBid) "\t\t<cim:LoadBid.AreaLoadBid rdf:resource=\"#" + AreaLoadBid + "\"/>\n" else "") +
        (if (null != RegisteredLoad) "\t\t<cim:LoadBid.RegisteredLoad rdf:resource=\"#" + RegisteredLoad + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:LoadBid rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:LoadBid>"
    }
}

object LoadBid
extends
    Parseable[LoadBid]
{
    val dropRampRate = parse_element (element ("""LoadBid.dropRampRate"""))
    val loadRedInitiationCost = parse_element (element ("""LoadBid.loadRedInitiationCost"""))
    val loadRedInitiationTime = parse_element (element ("""LoadBid.loadRedInitiationTime"""))
    val marketDate = parse_element (element ("""LoadBid.marketDate"""))
    val meteredValue = parse_element (element ("""LoadBid.meteredValue"""))
    val minLoad = parse_element (element ("""LoadBid.minLoad"""))
    val minLoadReduction = parse_element (element ("""LoadBid.minLoadReduction"""))
    val minLoadReductionCost = parse_element (element ("""LoadBid.minLoadReductionCost"""))
    val minLoadReductionInterval = parse_element (element ("""LoadBid.minLoadReductionInterval"""))
    val minTimeBetLoadRed = parse_element (element ("""LoadBid.minTimeBetLoadRed"""))
    val pickUpRampRate = parse_element (element ("""LoadBid.pickUpRampRate"""))
    val priceSetting = parse_element (element ("""LoadBid.priceSetting"""))
    val reqNoticeTime = parse_element (element ("""LoadBid.reqNoticeTime"""))
    val shutdownCost = parse_element (element ("""LoadBid.shutdownCost"""))
    val AreaLoadBid = parse_attribute (attribute ("""LoadBid.AreaLoadBid"""))
    val RegisteredLoad = parse_attribute (attribute ("""LoadBid.RegisteredLoad"""))
    def parse (context: Context): LoadBid =
    {
        LoadBid(
            ResourceBid.parse (context),
            toDouble (dropRampRate (context), context),
            toDouble (loadRedInitiationCost (context), context),
            toDouble (loadRedInitiationTime (context), context),
            marketDate (context),
            toBoolean (meteredValue (context), context),
            toDouble (minLoad (context), context),
            toDouble (minLoadReduction (context), context),
            toDouble (minLoadReductionCost (context), context),
            toDouble (minLoadReductionInterval (context), context),
            toDouble (minTimeBetLoadRed (context), context),
            toDouble (pickUpRampRate (context), context),
            toBoolean (priceSetting (context), context),
            toDouble (reqNoticeTime (context), context),
            toDouble (shutdownCost (context), context),
            AreaLoadBid (context),
            RegisteredLoad (context)
        )
    }
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
        sup.export_fields +
        (if (null != endTime) "\t\t<cim:LoadFollowingInst.endTime>" + endTime + "</cim:LoadFollowingInst.endTime>\n" else "") +
        "\t\t<cim:LoadFollowingInst.loadFollowingMW>" + loadFollowingMW + "</cim:LoadFollowingInst.loadFollowingMW>\n" +
        (if (null != mssInstructionID) "\t\t<cim:LoadFollowingInst.mssInstructionID>" + mssInstructionID + "</cim:LoadFollowingInst.mssInstructionID>\n" else "") +
        (if (null != startTime) "\t\t<cim:LoadFollowingInst.startTime>" + startTime + "</cim:LoadFollowingInst.startTime>\n" else "") +
        (if (null != RegisteredResource) "\t\t<cim:LoadFollowingInst.RegisteredResource rdf:resource=\"#" + RegisteredResource + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:LoadFollowingInst rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:LoadFollowingInst>"
    }
}

object LoadFollowingInst
extends
    Parseable[LoadFollowingInst]
{
    val endTime = parse_element (element ("""LoadFollowingInst.endTime"""))
    val loadFollowingMW = parse_element (element ("""LoadFollowingInst.loadFollowingMW"""))
    val mssInstructionID = parse_element (element ("""LoadFollowingInst.mssInstructionID"""))
    val startTime = parse_element (element ("""LoadFollowingInst.startTime"""))
    val RegisteredResource = parse_attribute (attribute ("""LoadFollowingInst.RegisteredResource"""))
    def parse (context: Context): LoadFollowingInst =
    {
        LoadFollowingInst(
            BasicElement.parse (context),
            endTime (context),
            toDouble (loadFollowingMW (context), context),
            mssInstructionID (context),
            startTime (context),
            RegisteredResource (context)
        )
    }
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
        sup.export_fields +
        (if (null != LoadBid) "\t\t<cim:LoadReductionPriceCurve.LoadBid rdf:resource=\"#" + LoadBid + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:LoadReductionPriceCurve rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:LoadReductionPriceCurve>"
    }
}

object LoadReductionPriceCurve
extends
    Parseable[LoadReductionPriceCurve]
{
    val LoadBid = parse_attribute (attribute ("""LoadReductionPriceCurve.LoadBid"""))
    def parse (context: Context): LoadReductionPriceCurve =
    {
        LoadReductionPriceCurve(
            Curve.parse (context),
            LoadBid (context)
        )
    }
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
        sup.export_fields +
        (if (null != effectiveDate) "\t\t<cim:MajorChargeGroup.effectiveDate>" + effectiveDate + "</cim:MajorChargeGroup.effectiveDate>\n" else "") +
        (if (null != frequencyType) "\t\t<cim:MajorChargeGroup.frequencyType>" + frequencyType + "</cim:MajorChargeGroup.frequencyType>\n" else "") +
        (if (null != invoiceType) "\t\t<cim:MajorChargeGroup.invoiceType>" + invoiceType + "</cim:MajorChargeGroup.invoiceType>\n" else "") +
        (if (null != requireAutorun) "\t\t<cim:MajorChargeGroup.requireAutorun>" + requireAutorun + "</cim:MajorChargeGroup.requireAutorun>\n" else "") +
        (if (null != revisionNumber) "\t\t<cim:MajorChargeGroup.revisionNumber>" + revisionNumber + "</cim:MajorChargeGroup.revisionNumber>\n" else "") +
        (if (null != runType) "\t\t<cim:MajorChargeGroup.runType>" + runType + "</cim:MajorChargeGroup.runType>\n" else "") +
        (if (null != runVersion) "\t\t<cim:MajorChargeGroup.runVersion>" + runVersion + "</cim:MajorChargeGroup.runVersion>\n" else "") +
        (if (null != terminationDate) "\t\t<cim:MajorChargeGroup.terminationDate>" + terminationDate + "</cim:MajorChargeGroup.terminationDate>\n" else "") +
        (if (null != ChargeType) ChargeType.map (x => "\t\t<cim:MajorChargeGroup.ChargeType rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:MajorChargeGroup rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MajorChargeGroup>"
    }
}

object MajorChargeGroup
extends
    Parseable[MajorChargeGroup]
{
    val effectiveDate = parse_element (element ("""MajorChargeGroup.effectiveDate"""))
    val frequencyType = parse_element (element ("""MajorChargeGroup.frequencyType"""))
    val invoiceType = parse_element (element ("""MajorChargeGroup.invoiceType"""))
    val requireAutorun = parse_element (element ("""MajorChargeGroup.requireAutorun"""))
    val revisionNumber = parse_element (element ("""MajorChargeGroup.revisionNumber"""))
    val runType = parse_element (element ("""MajorChargeGroup.runType"""))
    val runVersion = parse_element (element ("""MajorChargeGroup.runVersion"""))
    val terminationDate = parse_element (element ("""MajorChargeGroup.terminationDate"""))
    val ChargeType = parse_attributes (attribute ("""MajorChargeGroup.ChargeType"""))
    def parse (context: Context): MajorChargeGroup =
    {
        MajorChargeGroup(
            IdentifiedObject.parse (context),
            effectiveDate (context),
            frequencyType (context),
            invoiceType (context),
            requireAutorun (context),
            revisionNumber (context),
            runType (context),
            runVersion (context),
            terminationDate (context),
            ChargeType (context)
        )
    }
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
        sup.export_fields +
        (if (null != category) "\t\t<cim:MarketScheduledEvent.category>" + category + "</cim:MarketScheduledEvent.category>\n" else "") +
        "\t\t<cim:MarketScheduledEvent.duration>" + duration + "</cim:MarketScheduledEvent.duration>\n" +
        (if (null != status) "\t\t<cim:MarketScheduledEvent.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != MajorChargeGroup) "\t\t<cim:MarketScheduledEvent.MajorChargeGroup rdf:resource=\"#" + MajorChargeGroup + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MarketScheduledEvent rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MarketScheduledEvent>"
    }
}

object MarketScheduledEvent
extends
    Parseable[MarketScheduledEvent]
{
    val category = parse_element (element ("""MarketScheduledEvent.category"""))
    val duration = parse_element (element ("""MarketScheduledEvent.duration"""))
    val status = parse_attribute (attribute ("""MarketScheduledEvent.status"""))
    val MajorChargeGroup = parse_attribute (attribute ("""MarketScheduledEvent.MajorChargeGroup"""))
    def parse (context: Context): MarketScheduledEvent =
    {
        MarketScheduledEvent(
            IdentifiedObject.parse (context),
            category (context),
            toDouble (duration (context), context),
            status (context),
            MajorChargeGroup (context)
        )
    }
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:NotificationTimeCurve rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:NotificationTimeCurve>"
    }
}

object NotificationTimeCurve
extends
    Parseable[NotificationTimeCurve]
{
    def parse (context: Context): NotificationTimeCurve =
    {
        NotificationTimeCurve(
            Curve.parse (context)
        )
    }
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
        sup.export_fields +
        "\t\t<cim:OpenTieSchedule.value>" + value + "</cim:OpenTieSchedule.value>\n"
    }
    override def export: String =
    {
        "\t<cim:OpenTieSchedule rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:OpenTieSchedule>"
    }
}

object OpenTieSchedule
extends
    Parseable[OpenTieSchedule]
{
    val value = parse_element (element ("""OpenTieSchedule.value"""))
    def parse (context: Context): OpenTieSchedule =
    {
        OpenTieSchedule(
            BidHourlySchedule.parse (context),
            toBoolean (value (context), context)
        )
    }
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
        sup.export_fields +
        (if (null != Bid) "\t\t<cim:ProductBid.Bid rdf:resource=\"#" + Bid + "\"/>\n" else "") +
        (if (null != MarketProduct) "\t\t<cim:ProductBid.MarketProduct rdf:resource=\"#" + MarketProduct + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ProductBid rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ProductBid>"
    }
}

object ProductBid
extends
    Parseable[ProductBid]
{
    val Bid = parse_attribute (attribute ("""ProductBid.Bid"""))
    val MarketProduct = parse_attribute (attribute ("""ProductBid.MarketProduct"""))
    def parse (context: Context): ProductBid =
    {
        ProductBid(
            IdentifiedObject.parse (context),
            Bid (context),
            MarketProduct (context)
        )
    }
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
        sup.export_fields +
        "\t\t<cim:PumpingCostSchedule.value>" + value + "</cim:PumpingCostSchedule.value>\n"
    }
    override def export: String =
    {
        "\t<cim:PumpingCostSchedule rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PumpingCostSchedule>"
    }
}

object PumpingCostSchedule
extends
    Parseable[PumpingCostSchedule]
{
    val value = parse_element (element ("""PumpingCostSchedule.value"""))
    def parse (context: Context): PumpingCostSchedule =
    {
        PumpingCostSchedule(
            BidHourlyProductSchedule.parse (context),
            toDouble (value (context), context)
        )
    }
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
        sup.export_fields +
        "\t\t<cim:PumpingLevelSchedule.value>" + value + "</cim:PumpingLevelSchedule.value>\n"
    }
    override def export: String =
    {
        "\t<cim:PumpingLevelSchedule rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PumpingLevelSchedule>"
    }
}

object PumpingLevelSchedule
extends
    Parseable[PumpingLevelSchedule]
{
    val value = parse_element (element ("""PumpingLevelSchedule.value"""))
    def parse (context: Context): PumpingLevelSchedule =
    {
        PumpingLevelSchedule(
            BidHourlyProductSchedule.parse (context),
            toDouble (value (context), context)
        )
    }
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
        sup.export_fields +
        "\t\t<cim:PumpingShutDownCostSchedule.value>" + value + "</cim:PumpingShutDownCostSchedule.value>\n"
    }
    override def export: String =
    {
        "\t<cim:PumpingShutDownCostSchedule rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PumpingShutDownCostSchedule>"
    }
}

object PumpingShutDownCostSchedule
extends
    Parseable[PumpingShutDownCostSchedule]
{
    val value = parse_element (element ("""PumpingShutDownCostSchedule.value"""))
    def parse (context: Context): PumpingShutDownCostSchedule =
    {
        PumpingShutDownCostSchedule(
            BidHourlyProductSchedule.parse (context),
            toDouble (value (context), context)
        )
    }
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
        sup.export_fields +
        (if (null != condition) "\t\t<cim:RampRateCurve.condition rdf:resource=\"#" + condition + "\"/>\n" else "") +
        (if (null != constraintRampType) "\t\t<cim:RampRateCurve.constraintRampType rdf:resource=\"#" + constraintRampType + "\"/>\n" else "") +
        (if (null != rampRateType) "\t\t<cim:RampRateCurve.rampRateType rdf:resource=\"#" + rampRateType + "\"/>\n" else "") +
        (if (null != GeneratingBid) "\t\t<cim:RampRateCurve.GeneratingBid rdf:resource=\"#" + GeneratingBid + "\"/>\n" else "") +
        (if (null != InterTieBid) "\t\t<cim:RampRateCurve.InterTieBid rdf:resource=\"#" + InterTieBid + "\"/>\n" else "") +
        (if (null != LoadBid) "\t\t<cim:RampRateCurve.LoadBid rdf:resource=\"#" + LoadBid + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:RampRateCurve rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RampRateCurve>"
    }
}

object RampRateCurve
extends
    Parseable[RampRateCurve]
{
    val condition = parse_attribute (attribute ("""RampRateCurve.condition"""))
    val constraintRampType = parse_attribute (attribute ("""RampRateCurve.constraintRampType"""))
    val rampRateType = parse_attribute (attribute ("""RampRateCurve.rampRateType"""))
    val GeneratingBid = parse_attribute (attribute ("""RampRateCurve.GeneratingBid"""))
    val InterTieBid = parse_attribute (attribute ("""RampRateCurve.InterTieBid"""))
    val LoadBid = parse_attribute (attribute ("""RampRateCurve.LoadBid"""))
    def parse (context: Context): RampRateCurve =
    {
        RampRateCurve(
            Curve.parse (context),
            condition (context),
            constraintRampType (context),
            rampRateType (context),
            GeneratingBid (context),
            InterTieBid (context),
            LoadBid (context)
        )
    }
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
        sup.export_fields +
        "\t\t<cim:ResourceBid.aggregationFlag>" + aggregationFlag + "</cim:ResourceBid.aggregationFlag>\n" +
        (if (null != bidStatus) "\t\t<cim:ResourceBid.bidStatus>" + bidStatus + "</cim:ResourceBid.bidStatus>\n" else "") +
        (if (null != commodityType) "\t\t<cim:ResourceBid.commodityType>" + commodityType + "</cim:ResourceBid.commodityType>\n" else "") +
        (if (null != contingencyAvailFlag) "\t\t<cim:ResourceBid.contingencyAvailFlag rdf:resource=\"#" + contingencyAvailFlag + "\"/>\n" else "") +
        (if (null != createdISO) "\t\t<cim:ResourceBid.createdISO rdf:resource=\"#" + createdISO + "\"/>\n" else "") +
        "\t\t<cim:ResourceBid.energyMaxDay>" + energyMaxDay + "</cim:ResourceBid.energyMaxDay>\n" +
        "\t\t<cim:ResourceBid.energyMinDay>" + energyMinDay + "</cim:ResourceBid.energyMinDay>\n" +
        (if (null != marketSepFlag) "\t\t<cim:ResourceBid.marketSepFlag>" + marketSepFlag + "</cim:ResourceBid.marketSepFlag>\n" else "") +
        "\t\t<cim:ResourceBid.minDispatchTime>" + minDispatchTime + "</cim:ResourceBid.minDispatchTime>\n" +
        "\t\t<cim:ResourceBid.resourceLoadingType>" + resourceLoadingType + "</cim:ResourceBid.resourceLoadingType>\n" +
        "\t\t<cim:ResourceBid.shutDownsMaxDay>" + shutDownsMaxDay + "</cim:ResourceBid.shutDownsMaxDay>\n" +
        "\t\t<cim:ResourceBid.shutDownsMaxWeek>" + shutDownsMaxWeek + "</cim:ResourceBid.shutDownsMaxWeek>\n" +
        "\t\t<cim:ResourceBid.startUpsMaxDay>" + startUpsMaxDay + "</cim:ResourceBid.startUpsMaxDay>\n" +
        "\t\t<cim:ResourceBid.startUpsMaxWeek>" + startUpsMaxWeek + "</cim:ResourceBid.startUpsMaxWeek>\n" +
        "\t\t<cim:ResourceBid.virtual>" + virtual + "</cim:ResourceBid.virtual>\n" +
        (if (null != BidError) BidError.map (x => "\t\t<cim:ResourceBid.BidError rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:ResourceBid rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ResourceBid>"
    }
}

object ResourceBid
extends
    Parseable[ResourceBid]
{
    val aggregationFlag = parse_element (element ("""ResourceBid.aggregationFlag"""))
    val bidStatus = parse_element (element ("""ResourceBid.bidStatus"""))
    val commodityType = parse_element (element ("""ResourceBid.commodityType"""))
    val contingencyAvailFlag = parse_attribute (attribute ("""ResourceBid.contingencyAvailFlag"""))
    val createdISO = parse_attribute (attribute ("""ResourceBid.createdISO"""))
    val energyMaxDay = parse_element (element ("""ResourceBid.energyMaxDay"""))
    val energyMinDay = parse_element (element ("""ResourceBid.energyMinDay"""))
    val marketSepFlag = parse_element (element ("""ResourceBid.marketSepFlag"""))
    val minDispatchTime = parse_element (element ("""ResourceBid.minDispatchTime"""))
    val resourceLoadingType = parse_element (element ("""ResourceBid.resourceLoadingType"""))
    val shutDownsMaxDay = parse_element (element ("""ResourceBid.shutDownsMaxDay"""))
    val shutDownsMaxWeek = parse_element (element ("""ResourceBid.shutDownsMaxWeek"""))
    val startUpsMaxDay = parse_element (element ("""ResourceBid.startUpsMaxDay"""))
    val startUpsMaxWeek = parse_element (element ("""ResourceBid.startUpsMaxWeek"""))
    val virtual = parse_element (element ("""ResourceBid.virtual"""))
    val BidError = parse_attributes (attribute ("""ResourceBid.BidError"""))
    def parse (context: Context): ResourceBid =
    {
        ResourceBid(
            Bid.parse (context),
            toInteger (aggregationFlag (context), context),
            bidStatus (context),
            commodityType (context),
            contingencyAvailFlag (context),
            createdISO (context),
            toDouble (energyMaxDay (context), context),
            toDouble (energyMinDay (context), context),
            marketSepFlag (context),
            toInteger (minDispatchTime (context), context),
            toInteger (resourceLoadingType (context), context),
            toInteger (shutDownsMaxDay (context), context),
            toInteger (shutDownsMaxWeek (context), context),
            toInteger (startUpsMaxDay (context), context),
            toInteger (startUpsMaxWeek (context), context),
            toBoolean (virtual (context), context),
            BidError (context)
        )
    }
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
        sup.export_fields +
        (if (null != RegisteredGenerators) RegisteredGenerators.map (x => "\t\t<cim:StartUpCostCurve.RegisteredGenerators rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:StartUpCostCurve rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:StartUpCostCurve>"
    }
}

object StartUpCostCurve
extends
    Parseable[StartUpCostCurve]
{
    val RegisteredGenerators = parse_attributes (attribute ("""StartUpCostCurve.RegisteredGenerators"""))
    def parse (context: Context): StartUpCostCurve =
    {
        StartUpCostCurve(
            Curve.parse (context),
            RegisteredGenerators (context)
        )
    }
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
        sup.export_fields +
        (if (null != RegisteredGenerator) "\t\t<cim:StartUpTimeCurve.RegisteredGenerator rdf:resource=\"#" + RegisteredGenerator + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:StartUpTimeCurve rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:StartUpTimeCurve>"
    }
}

object StartUpTimeCurve
extends
    Parseable[StartUpTimeCurve]
{
    val RegisteredGenerator = parse_attribute (attribute ("""StartUpTimeCurve.RegisteredGenerator"""))
    def parse (context: Context): StartUpTimeCurve =
    {
        StartUpTimeCurve(
            Curve.parse (context),
            RegisteredGenerator (context)
        )
    }
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
        sup.export_fields +
        "\t\t<cim:Trade.adjustedTradeQuantity>" + adjustedTradeQuantity + "</cim:Trade.adjustedTradeQuantity>\n" +
        "\t\t<cim:Trade.counterTradeQuantity>" + counterTradeQuantity + "</cim:Trade.counterTradeQuantity>\n" +
        (if (null != dependOnTradeName) "\t\t<cim:Trade.dependOnTradeName>" + dependOnTradeName + "</cim:Trade.dependOnTradeName>\n" else "") +
        (if (null != lastModified) "\t\t<cim:Trade.lastModified>" + lastModified + "</cim:Trade.lastModified>\n" else "") +
        (if (null != marketType) "\t\t<cim:Trade.marketType rdf:resource=\"#" + marketType + "\"/>\n" else "") +
        (if (null != startTime) "\t\t<cim:Trade.startTime>" + startTime + "</cim:Trade.startTime>\n" else "") +
        (if (null != stopTime) "\t\t<cim:Trade.stopTime>" + stopTime + "</cim:Trade.stopTime>\n" else "") +
        (if (null != submitFromSchedulingCoordinator) "\t\t<cim:Trade.submitFromSchedulingCoordinator rdf:resource=\"#" + submitFromSchedulingCoordinator + "\"/>\n" else "") +
        (if (null != submitFromTimeStamp) "\t\t<cim:Trade.submitFromTimeStamp>" + submitFromTimeStamp + "</cim:Trade.submitFromTimeStamp>\n" else "") +
        (if (null != submitFromUser) "\t\t<cim:Trade.submitFromUser>" + submitFromUser + "</cim:Trade.submitFromUser>\n" else "") +
        (if (null != submitToSchedulingCoordinator) "\t\t<cim:Trade.submitToSchedulingCoordinator rdf:resource=\"#" + submitToSchedulingCoordinator + "\"/>\n" else "") +
        (if (null != submitToTimeStamp) "\t\t<cim:Trade.submitToTimeStamp>" + submitToTimeStamp + "</cim:Trade.submitToTimeStamp>\n" else "") +
        (if (null != submitToUser_1) "\t\t<cim:Trade.submitToUser >" + submitToUser_1 + "</cim:Trade.submitToUser >\n" else "") +
        "\t\t<cim:Trade.tradeQuantity>" + tradeQuantity + "</cim:Trade.tradeQuantity>\n" +
        (if (null != tradeStatus) "\t\t<cim:Trade.tradeStatus>" + tradeStatus + "</cim:Trade.tradeStatus>\n" else "") +
        (if (null != updateTimeStamp) "\t\t<cim:Trade.updateTimeStamp>" + updateTimeStamp + "</cim:Trade.updateTimeStamp>\n" else "") +
        (if (null != updateUser) "\t\t<cim:Trade.updateUser>" + updateUser + "</cim:Trade.updateUser>\n" else "") +
        (if (null != ActionRequest) "\t\t<cim:Trade.ActionRequest rdf:resource=\"#" + ActionRequest + "\"/>\n" else "") +
        (if (null != From_SC) "\t\t<cim:Trade.From_SC rdf:resource=\"#" + From_SC + "\"/>\n" else "") +
        (if (null != Pnode) "\t\t<cim:Trade.Pnode rdf:resource=\"#" + Pnode + "\"/>\n" else "") +
        (if (null != RegisteredGenerator) "\t\t<cim:Trade.RegisteredGenerator rdf:resource=\"#" + RegisteredGenerator + "\"/>\n" else "") +
        (if (null != To_SC) "\t\t<cim:Trade.To_SC rdf:resource=\"#" + To_SC + "\"/>\n" else "") +
        (if (null != TradeProduct) "\t\t<cim:Trade.TradeProduct rdf:resource=\"#" + TradeProduct + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Trade rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Trade>"
    }
}

object Trade
extends
    Parseable[Trade]
{
    val adjustedTradeQuantity = parse_element (element ("""Trade.adjustedTradeQuantity"""))
    val counterTradeQuantity = parse_element (element ("""Trade.counterTradeQuantity"""))
    val dependOnTradeName = parse_element (element ("""Trade.dependOnTradeName"""))
    val lastModified = parse_element (element ("""Trade.lastModified"""))
    val marketType = parse_attribute (attribute ("""Trade.marketType"""))
    val startTime = parse_element (element ("""Trade.startTime"""))
    val stopTime = parse_element (element ("""Trade.stopTime"""))
    val submitFromSchedulingCoordinator = parse_attribute (attribute ("""Trade.submitFromSchedulingCoordinator"""))
    val submitFromTimeStamp = parse_element (element ("""Trade.submitFromTimeStamp"""))
    val submitFromUser = parse_element (element ("""Trade.submitFromUser"""))
    val submitToSchedulingCoordinator = parse_attribute (attribute ("""Trade.submitToSchedulingCoordinator"""))
    val submitToTimeStamp = parse_element (element ("""Trade.submitToTimeStamp"""))
    val submitToUser_1 = parse_element (element ("""Trade.submitToUser """))
    val tradeQuantity = parse_element (element ("""Trade.tradeQuantity"""))
    val tradeStatus = parse_element (element ("""Trade.tradeStatus"""))
    val updateTimeStamp = parse_element (element ("""Trade.updateTimeStamp"""))
    val updateUser = parse_element (element ("""Trade.updateUser"""))
    val ActionRequest = parse_attribute (attribute ("""Trade.ActionRequest"""))
    val From_SC = parse_attribute (attribute ("""Trade.From_SC"""))
    val Pnode = parse_attribute (attribute ("""Trade.Pnode"""))
    val RegisteredGenerator = parse_attribute (attribute ("""Trade.RegisteredGenerator"""))
    val To_SC = parse_attribute (attribute ("""Trade.To_SC"""))
    val TradeProduct = parse_attribute (attribute ("""Trade.TradeProduct"""))
    def parse (context: Context): Trade =
    {
        Trade(
            IdentifiedObject.parse (context),
            toDouble (adjustedTradeQuantity (context), context),
            toDouble (counterTradeQuantity (context), context),
            dependOnTradeName (context),
            lastModified (context),
            marketType (context),
            startTime (context),
            stopTime (context),
            submitFromSchedulingCoordinator (context),
            submitFromTimeStamp (context),
            submitFromUser (context),
            submitToSchedulingCoordinator (context),
            submitToTimeStamp (context),
            submitToUser_1 (context),
            toDouble (tradeQuantity (context), context),
            tradeStatus (context),
            updateTimeStamp (context),
            updateUser (context),
            ActionRequest (context),
            From_SC (context),
            Pnode (context),
            RegisteredGenerator (context),
            To_SC (context),
            TradeProduct (context)
        )
    }
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
        sup.export_fields +
        (if (null != endTime) "\t\t<cim:TradeError.endTime>" + endTime + "</cim:TradeError.endTime>\n" else "") +
        (if (null != errMessage) "\t\t<cim:TradeError.errMessage>" + errMessage + "</cim:TradeError.errMessage>\n" else "") +
        "\t\t<cim:TradeError.errPriority>" + errPriority + "</cim:TradeError.errPriority>\n" +
        (if (null != logTimeStamp) "\t\t<cim:TradeError.logTimeStamp>" + logTimeStamp + "</cim:TradeError.logTimeStamp>\n" else "") +
        "\t\t<cim:TradeError.ruleID>" + ruleID + "</cim:TradeError.ruleID>\n" +
        (if (null != startTime) "\t\t<cim:TradeError.startTime>" + startTime + "</cim:TradeError.startTime>\n" else "") +
        (if (null != Trade) "\t\t<cim:TradeError.Trade rdf:resource=\"#" + Trade + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TradeError rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TradeError>"
    }
}

object TradeError
extends
    Parseable[TradeError]
{
    val endTime = parse_element (element ("""TradeError.endTime"""))
    val errMessage = parse_element (element ("""TradeError.errMessage"""))
    val errPriority = parse_element (element ("""TradeError.errPriority"""))
    val logTimeStamp = parse_element (element ("""TradeError.logTimeStamp"""))
    val ruleID = parse_element (element ("""TradeError.ruleID"""))
    val startTime = parse_element (element ("""TradeError.startTime"""))
    val Trade = parse_attribute (attribute ("""TradeError.Trade"""))
    def parse (context: Context): TradeError =
    {
        TradeError(
            IdentifiedObject.parse (context),
            endTime (context),
            errMessage (context),
            toInteger (errPriority (context), context),
            logTimeStamp (context),
            toInteger (ruleID (context), context),
            startTime (context),
            Trade (context)
        )
    }
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
        sup.export_fields +
        (if (null != tradeProductType) "\t\t<cim:TradeProduct.tradeProductType>" + tradeProductType + "</cim:TradeProduct.tradeProductType>\n" else "") +
        (if (null != tradeType) "\t\t<cim:TradeProduct.tradeType rdf:resource=\"#" + tradeType + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TradeProduct rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TradeProduct>"
    }
}

object TradeProduct
extends
    Parseable[TradeProduct]
{
    val tradeProductType = parse_element (element ("""TradeProduct.tradeProductType"""))
    val tradeType = parse_attribute (attribute ("""TradeProduct.tradeType"""))
    def parse (context: Context): TradeProduct =
    {
        TradeProduct(
            BasicElement.parse (context),
            tradeProductType (context),
            tradeType (context)
        )
    }
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
        sup.export_fields +
        "\t\t<cim:TransactionBid.demandTransaction>" + demandTransaction + "</cim:TransactionBid.demandTransaction>\n" +
        "\t\t<cim:TransactionBid.dispatchable>" + dispatchable + "</cim:TransactionBid.dispatchable>\n" +
        "\t\t<cim:TransactionBid.payCongestion>" + payCongestion + "</cim:TransactionBid.payCongestion>\n" +
        (if (null != Delivery_Pnode) "\t\t<cim:TransactionBid.Delivery_Pnode rdf:resource=\"#" + Delivery_Pnode + "\"/>\n" else "") +
        (if (null != Receipt_Pnode) "\t\t<cim:TransactionBid.Receipt_Pnode rdf:resource=\"#" + Receipt_Pnode + "\"/>\n" else "") +
        (if (null != TransmissionReservation) "\t\t<cim:TransactionBid.TransmissionReservation rdf:resource=\"#" + TransmissionReservation + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TransactionBid rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TransactionBid>"
    }
}

object TransactionBid
extends
    Parseable[TransactionBid]
{
    val demandTransaction = parse_element (element ("""TransactionBid.demandTransaction"""))
    val dispatchable = parse_element (element ("""TransactionBid.dispatchable"""))
    val payCongestion = parse_element (element ("""TransactionBid.payCongestion"""))
    val Delivery_Pnode = parse_attribute (attribute ("""TransactionBid.Delivery_Pnode"""))
    val Receipt_Pnode = parse_attribute (attribute ("""TransactionBid.Receipt_Pnode"""))
    val TransmissionReservation = parse_attribute (attribute ("""TransactionBid.TransmissionReservation"""))
    def parse (context: Context): TransactionBid =
    {
        TransactionBid(
            Bid.parse (context),
            toBoolean (demandTransaction (context), context),
            toBoolean (dispatchable (context), context),
            toBoolean (payCongestion (context), context),
            Delivery_Pnode (context),
            Receipt_Pnode (context),
            TransmissionReservation (context)
        )
    }
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