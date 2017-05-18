package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * Market participant interfaces for bids and trades.
 */

/**
 * Action request against an existing Trade.
 * @param sup Reference to the superclass object.
 * @param actionName Action name type for the action request.
 */
case class ActionRequest
(
    override val sup: Element,
    val actionName: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ActionRequest]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ActionRequest
extends
    Parseable[ActionRequest]
{
    val sup = BasicElement.parse _
    val actionName = parse_attribute (attribute ("""ActionRequest.actionName"""))
    def parse (context: Context): ActionRequest =
    {
        ActionRequest(
            sup (context),
            actionName (context)
        )
    }
}

/**
 * AreaLoadBid is not submitted by a market participant into the Markets.
 * Instead, it is simply an aggregation of all LoadBids contained wtihin a specific SubControlArea. This entity should inherit from Bid for representation of the timeframe (startTime, stopTime) and the market type.
 * @param sup Reference to the superclass object.
 * @param demandBidMW The Demand Bid Megawatt for the area case.
 *        Attribute Usage: This is Scheduled demand MW in Day Ahead
 */
case class AreaLoadBid
(
    override val sup: Element,
    val demandBidMW: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
    def Bid: Bid = sup.asInstanceOf[Bid]
    override def copy (): Row = { return (clone ().asInstanceOf[AreaLoadBid]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AreaLoadBid
extends
    Parseable[AreaLoadBid]
{
    val sup = Bid.parse _
    val demandBidMW = parse_element (element ("""AreaLoadBid.demandBidMW"""))
    def parse (context: Context): AreaLoadBid =
    {
        AreaLoadBid(
            sup (context),
            toDouble (demandBidMW (context), context)
        )
    }
}

/**
 * Property for a particular attribute that contains name and value
 * @param sup Reference to the superclass object.
 * @param propertyName
 * @param propertyValue
 * @param sequence
 * @param MktUserAttribute
 */
case class AttributeProperty
(
    override val sup: Element,
    val propertyName: String,
    val propertyValue: String,
    val sequence: String,
    val MktUserAttribute: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[AttributeProperty]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AttributeProperty
extends
    Parseable[AttributeProperty]
{
    val sup = BasicElement.parse _
    val propertyName = parse_element (element ("""AttributeProperty.propertyName"""))
    val propertyValue = parse_element (element ("""AttributeProperty.propertyValue"""))
    val sequence = parse_element (element ("""AttributeProperty.sequence"""))
    val MktUserAttribute = parse_attribute (attribute ("""AttributeProperty.MktUserAttribute"""))
    def parse (context: Context): AttributeProperty =
    {
        AttributeProperty(
            sup (context),
            propertyName (context),
            propertyValue (context),
            sequence (context),
            MktUserAttribute (context)
        )
    }
}

/**
 * Represents both bids to purchase and offers to sell energy or ancillary services in an RTO-sponsored market.
 * @param sup Reference to the superclass object.
 * @param marketType The market type, DAM or RTM.
 * @param startTime Start time and date for which bid applies.
 * @param stopTime Stop time and date for which bid is applicable.
 * @param ActionRequest
 * @param EnergyMarket
 * @param MarketParticipant
 * @param SchedulingCoordinator
 */
case class Bid
(
    override val sup: Element,
    val marketType: String,
    val startTime: String,
    val stopTime: String,
    val ActionRequest: String,
    val EnergyMarket: String,
    val MarketParticipant: String,
    val SchedulingCoordinator: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { return (clone ().asInstanceOf[Bid]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Bid
extends
    Parseable[Bid]
{
    val sup = Document.parse _
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
            sup (context),
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
 * @param sup Reference to the superclass object.
 * @param timeIntervalEnd End of the time interval n which bid is valid (yyyy-mm-dd hh24: mi: ss)
 * @param timeIntervalStart Start of the time interval in which bid is valid (yyyy-mm-dd hh24: mi: ss).
 * @param ProductBid
 */
case class BidDistributionFactor
(
    override val sup: Element,
    val timeIntervalEnd: String,
    val timeIntervalStart: String,
    val ProductBid: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[BidDistributionFactor]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BidDistributionFactor
extends
    Parseable[BidDistributionFactor]
{
    val sup = BasicElement.parse _
    val timeIntervalEnd = parse_element (element ("""BidDistributionFactor.timeIntervalEnd"""))
    val timeIntervalStart = parse_element (element ("""BidDistributionFactor.timeIntervalStart"""))
    val ProductBid = parse_attribute (attribute ("""BidDistributionFactor.ProductBid"""))
    def parse (context: Context): BidDistributionFactor =
    {
        BidDistributionFactor(
            sup (context),
            timeIntervalEnd (context),
            timeIntervalStart (context),
            ProductBid (context)
        )
    }
}

/**
 * This class represent the error information for a bid that is detected during bid validation
 * @param sup Reference to the superclass object.
 * @param componentType
 * @param endTime hour wihthin the bid for which the error applies
 * @param errMessage error message
 * @param errPriority Priority number for the error message
 * @param logTimeStamp
 * @param msgLevel
 * @param ruleID
 * @param startTime hour wihthin the bid for which the error applies
 * @param MarketProduct
 */
case class BidError
(
    override val sup: Element,
    val componentType: String,
    val endTime: String,
    val errMessage: String,
    val errPriority: Int,
    val logTimeStamp: String,
    val msgLevel: Int,
    val ruleID: Int,
    val startTime: String,
    val MarketProduct: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, 0, null, 0, 0, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[BidError]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BidError
extends
    Parseable[BidError]
{
    val sup = IdentifiedObject.parse _
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
            sup (context),
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
 * @param sup Reference to the superclass object.
 * @param ProductBid
 */
case class BidHourlyProductSchedule
(
    override val sup: Element,
    val ProductBid: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def RegularIntervalSchedule: RegularIntervalSchedule = sup.asInstanceOf[RegularIntervalSchedule]
    override def copy (): Row = { return (clone ().asInstanceOf[BidHourlyProductSchedule]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BidHourlyProductSchedule
extends
    Parseable[BidHourlyProductSchedule]
{
    val sup = RegularIntervalSchedule.parse _
    val ProductBid = parse_attribute (attribute ("""BidHourlyProductSchedule.ProductBid"""))
    def parse (context: Context): BidHourlyProductSchedule =
    {
        BidHourlyProductSchedule(
            sup (context),
            ProductBid (context)
        )
    }
}

/**
 * Containment for bid hourly parameters that are not product dependent.
 * @param sup Reference to the superclass object.
 * @param Bid
 */
case class BidHourlySchedule
(
    override val sup: Element,
    val Bid: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def RegularIntervalSchedule: RegularIntervalSchedule = sup.asInstanceOf[RegularIntervalSchedule]
    override def copy (): Row = { return (clone ().asInstanceOf[BidHourlySchedule]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BidHourlySchedule
extends
    Parseable[BidHourlySchedule]
{
    val sup = RegularIntervalSchedule.parse _
    val Bid = parse_attribute (attribute ("""BidHourlySchedule.Bid"""))
    def parse (context: Context): BidHourlySchedule =
    {
        BidHourlySchedule(
            sup (context),
            Bid (context)
        )
    }
}

/**
 * Relationship between unit operating price in $/hour (Y-axis) and unit output in MW (X-axis).
 * @param sup Reference to the superclass object.
 */
case class BidPriceCurve
(
    override val sup: Element
)
extends
    Element
{
    def this () = { this (null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { return (clone ().asInstanceOf[BidPriceCurve]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BidPriceCurve
extends
    Parseable[BidPriceCurve]
{
    val sup = Curve.parse _
    def parse (context: Context): BidPriceCurve =
    {
        BidPriceCurve(
            sup (context)
        )
    }
}

/**
 * Defines bid schedules to allow a product bid to use specified bid price curves for different time intervals.
 * @param sup Reference to the superclass object.
 * @param bidType BID Type:  

I - Initial Bid;
 *        F - Final Bid
 * @param mitigationStatus Mitigation Status:

'S' - Mitigated by SMPM because of "misconduct"
'L; - Mitigated by LMPM because of "misconduct"
'R' - Modified by LMPM because of RMR rules
'M' - Mitigated because of "misconduct" both by SMPM and LMPM
'B' - Mitigated because of "misconduct" both by SMPM and modified by LMLM because of RMR rules
 *        'O' - original
 * @param BidPriceCurve
 * @param ProductBid
 */
case class BidPriceSchedule
(
    override val sup: Element,
    val bidType: String,
    val mitigationStatus: String,
    val BidPriceCurve: String,
    val ProductBid: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def RegularIntervalSchedule: RegularIntervalSchedule = sup.asInstanceOf[RegularIntervalSchedule]
    override def copy (): Row = { return (clone ().asInstanceOf[BidPriceSchedule]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BidPriceSchedule
extends
    Parseable[BidPriceSchedule]
{
    val sup = RegularIntervalSchedule.parse _
    val bidType = parse_attribute (attribute ("""BidPriceSchedule.bidType"""))
    val mitigationStatus = parse_attribute (attribute ("""BidPriceSchedule.mitigationStatus"""))
    val BidPriceCurve = parse_attribute (attribute ("""BidPriceSchedule.BidPriceCurve"""))
    val ProductBid = parse_attribute (attribute ("""BidPriceSchedule.ProductBid"""))
    def parse (context: Context): BidPriceSchedule =
    {
        BidPriceSchedule(
            sup (context),
            bidType (context),
            mitigationStatus (context),
            BidPriceCurve (context),
            ProductBid (context)
        )
    }
}

/**
 * Defines self schedule values to be used for specified time intervals.
 * @param sup Reference to the superclass object.
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
 * @param updateType
 * @param wheelingTransactionReference A unique identifier of a wheeling transaction.
 *        A wheeling transaction is a balanced Energy exchange among Supply and Demand Resources.
 * @param AdjacentCASet
 * @param HostControlArea
 * @param ProductBid
 * @param SubControlArea
 * @param TransmissionContractRight
 */
case class BidSelfSched
(
    override val sup: Element,
    val balancingFlag: String,
    val bidType: String,
    val priorityFlag: String,
    val pumpSelfSchedMw: Double,
    val referenceType: String,
    val selfSchedMw: Double,
    val selfSchedSptResource: String,
    val selfSchedType: String,
    val updateType: String,
    val wheelingTransactionReference: String,
    val AdjacentCASet: String,
    val HostControlArea: String,
    val ProductBid: String,
    val SubControlArea: String,
    val TransmissionContractRight: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, 0.0, null, 0.0, null, null, null, null, null, null, null, null, null) }
    def RegularIntervalSchedule: RegularIntervalSchedule = sup.asInstanceOf[RegularIntervalSchedule]
    override def copy (): Row = { return (clone ().asInstanceOf[BidSelfSched]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BidSelfSched
extends
    Parseable[BidSelfSched]
{
    val sup = RegularIntervalSchedule.parse _
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
            sup (context),
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
 * Of these generating bids, only one generating bid can be scheduled at a time.
 * @param sup Reference to the superclass object.
 */
case class BidSet
(
    override val sup: Element
)
extends
    Element
{
    def this () = { this (null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[BidSet]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BidSet
extends
    Parseable[BidSet]
{
    val sup = IdentifiedObject.parse _
    def parse (context: Context): BidSet =
    {
        BidSet(
            sup (context)
        )
    }
}

/**
 * A Charge Component is a list of configurable charge quality items to feed into settlement calculation and/or bill determinants.
 * @param sup Reference to the superclass object.
 * @param deleteStatus
 * @param effectiveDate
 * @param equation
 * @param message
 * @param roundOff
 * @param sum
 * @param terminationDate
 * @param typ
 * @param BillDeterminants A BillDeterminant can have 0-n ChargeComponent and a ChargeComponent can associate to 0-n BillDeterminant.
 */
case class ChargeComponent
(
    override val sup: Element,
    val deleteStatus: String,
    val effectiveDate: String,
    val equation: String,
    val message: String,
    val roundOff: String,
    val sum: String,
    val terminationDate: String,
    val typ: String,
    val BillDeterminants: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, List()) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ChargeComponent]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ChargeComponent
extends
    Parseable[ChargeComponent]
{
    val sup = IdentifiedObject.parse _
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
            sup (context),
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
 * Examples such as Ancillary Services, Interests, etc.
 * @param sup Reference to the superclass object.
 * @param effectiveDate
 * @param marketCode
 * @param terminationDate
 * @param ChargeGroupParent A ChargeGroup instance can have relationships with other ChargeGroup instances.
 * @param MktUserAttribute
 */
case class ChargeGroup
(
    override val sup: Element,
    val effectiveDate: String,
    val marketCode: String,
    val terminationDate: String,
    val ChargeGroupParent: String,
    val MktUserAttribute: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, List()) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ChargeGroup]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ChargeGroup
extends
    Parseable[ChargeGroup]
{
    val sup = IdentifiedObject.parse _
    val effectiveDate = parse_element (element ("""ChargeGroup.effectiveDate"""))
    val marketCode = parse_element (element ("""ChargeGroup.marketCode"""))
    val terminationDate = parse_element (element ("""ChargeGroup.terminationDate"""))
    val ChargeGroupParent = parse_attribute (attribute ("""ChargeGroup.ChargeGroupParent"""))
    val MktUserAttribute = parse_attributes (attribute ("""ChargeGroup.MktUserAttribute"""))
    def parse (context: Context): ChargeGroup =
    {
        ChargeGroup(
            sup (context),
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
 * Examples such as: Day Ahead Spinning Reserve Default Invoice Interest Charge, etc.
 * @param sup Reference to the superclass object.
 * @param chargeOrder
 * @param chargeVersion
 * @param effectiveDate
 * @param factor
 * @param frequencyType
 * @param terminationDate
 * @param totalInterval
 * @param ChargeComponents A ChargeType can have 0-n ChargeComponent and a ChargeComponent can associate to 0-n ChargeType
 * @param ChargeGroup A ChargeGroup can have 0-n ChargeType.
 *        A ChargeType can associate to 0-n ChargeGroup.
 * @param MktUserAttribute
 */
case class ChargeType
(
    override val sup: Element,
    val chargeOrder: String,
    val chargeVersion: String,
    val effectiveDate: String,
    val factor: String,
    val frequencyType: String,
    val terminationDate: String,
    val totalInterval: String,
    val ChargeComponents: List[String],
    val ChargeGroup: List[String],
    val MktUserAttribute: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, List(), List(), List()) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { return (clone ().asInstanceOf[ChargeType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ChargeType
extends
    Parseable[ChargeType]
{
    val sup = Document.parse _
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
            sup (context),
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
 * @param sup Reference to the superclass object.
 * @param acceptMW The accepted mw amount by the responder. aka response mw.
 * @param acceptStatus The accept status submitted by the responder. enumeration type needs to be defined
 * @param certificationName The Subject DN is the X509 Certificate Subject DN.
 *        This is the essentially the certificate name presented by the client. In the case of ADS Certificates, this will be the user name. It may be from an API Client or the MP Client (GUI).
 * @param clearedMW MW amount associated with instruction.
 *        For 5 minute binding dispatches, this is the Goto MW or DOT
 * @param instructionTime The target date/time for the received instruction.
 * @param instructionType instruction type:

commitment
out of sequence
 *        dispatch
 * @param passIndicator The type of run for the market clearing.
 * @param receivedTime Timestamp indicating the time at which the instruction was received.
 * @param startTime start time
 * @param RegisteredResource
 */
case class DispatchInstReply
(
    override val sup: Element,
    val acceptMW: Double,
    val acceptStatus: String,
    val certificationName: String,
    val clearedMW: Double,
    val instructionTime: String,
    val instructionType: String,
    val passIndicator: String,
    val receivedTime: String,
    val startTime: String,
    val RegisteredResource: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null, 0.0, null, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[DispatchInstReply]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DispatchInstReply
extends
    Parseable[DispatchInstReply]
{
    val sup = IdentifiedObject.parse _
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
            sup (context),
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
 * Relationship between a price in $(or other monetary unit) /hour (Y-axis) and a MW value (X-axis).
 * @param sup Reference to the superclass object.
 */
case class EnergyPriceCurve
(
    override val sup: Element
)
extends
    Element
{
    def this () = { this (null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[EnergyPriceCurve]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EnergyPriceCurve
extends
    Parseable[EnergyPriceCurve]
{
    val sup = BasicElement.parse _
    def parse (context: Context): EnergyPriceCurve =
    {
        EnergyPriceCurve(
            sup (context)
        )
    }
}

/**
 * Offer to supply energy/ancillary services from a generating unit or resource
 * @param sup Reference to the superclass object.
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
0 - Fixed ramp rate independent of rate function unit MW output
1 - Static ramp rates as a function of unit MW output only
 *        2 - Dynamic ramp rates as a function of unit MW output and ramping time
 * @param startUpRampRate Resource startup ramp rate (MW/minute)
 * @param startUpType Resource startup type:
1 - Fixed startup time and fixed startup cost
2 - Startup time as a function of down time and fixed startup cost
 *        3 - Startup cost as a function of down time
 * @param startupCost Startup cost/price
 * @param upTimeMax Maximum up time.
 * @param BidSet
 * @param NotificationTimeCurve
 * @param RegisteredGenerator
 * @param StartUpCostCurve
 * @param StartUpTimeCurve
 */
case class GeneratingBid
(
    override val sup: Element,
    val combinedCycleUnitOffer: String,
    val downTimeMax: Double,
    val installedCapacity: Double,
    val lowerRampRate: Double,
    val maxEmergencyMW: Double,
    val maximumEconomicMW: Double,
    val minEmergencyMW: Double,
    val minimumEconomicMW: Double,
    val noLoadCost: Double,
    val notificationTime: Double,
    val operatingMode: String,
    val raiseRampRate: Double,
    val rampCurveType: Int,
    val startUpRampRate: Double,
    val startUpType: Int,
    val startupCost: Double,
    val upTimeMax: Double,
    val BidSet: String,
    val NotificationTimeCurve: String,
    val RegisteredGenerator: String,
    val StartUpCostCurve: String,
    val StartUpTimeCurve: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, 0.0, 0, 0.0, 0, 0.0, 0.0, null, null, null, null, null) }
    def ResourceBid: ResourceBid = sup.asInstanceOf[ResourceBid]
    override def copy (): Row = { return (clone ().asInstanceOf[GeneratingBid]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GeneratingBid
extends
    Parseable[GeneratingBid]
{
    val sup = ResourceBid.parse _
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
            sup (context),
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
 * The resource could be a RegisteredGenerator or a RegisteredInterTie.
 * @param sup Reference to the superclass object.
 * @param value Flag defining that for this hour in the resource bid the resource shall have an hourly pre-dispatch.
 */
case class HourlyPreDispatchSchedule
(
    override val sup: Element,
    val value: Boolean
)
extends
    Element
{
    def this () = { this (null, false) }
    def BidHourlySchedule: BidHourlySchedule = sup.asInstanceOf[BidHourlySchedule]
    override def copy (): Row = { return (clone ().asInstanceOf[HourlyPreDispatchSchedule]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object HourlyPreDispatchSchedule
extends
    Parseable[HourlyPreDispatchSchedule]
{
    val sup = BidHourlySchedule.parse _
    val value = parse_element (element ("""HourlyPreDispatchSchedule.value"""))
    def parse (context: Context): HourlyPreDispatchSchedule =
    {
        HourlyPreDispatchSchedule(
            sup (context),
            toBoolean (value (context), context)
        )
    }
}

/**
 * This class represents the inter tie bid
 * @param sup Reference to the superclass object.
 * @param minHourlyBlock_1 The minimum hourly block for an Inter-Tie Resource supplied within the bid.
 * @param RegisteredInterTie
 */
case class InterTieBid
(
    override val sup: Element,
    val minHourlyBlock_1: Int,
    val RegisteredInterTie: String
)
extends
    Element
{
    def this () = { this (null, 0, null) }
    def ResourceBid: ResourceBid = sup.asInstanceOf[ResourceBid]
    override def copy (): Row = { return (clone ().asInstanceOf[InterTieBid]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object InterTieBid
extends
    Parseable[InterTieBid]
{
    val sup = ResourceBid.parse _
    val minHourlyBlock_1 = parse_element (element ("""InterTieBid.minHourlyBlock """))
    val RegisteredInterTie = parse_attribute (attribute ("""InterTieBid.RegisteredInterTie"""))
    def parse (context: Context): InterTieBid =
    {
        InterTieBid(
            sup (context),
            toInteger (minHourlyBlock_1 (context), context),
            RegisteredInterTie (context)
        )
    }
}

/**
 * Response from an intertie resource acknowleging receipt of dispatch instructions
 * @param sup Reference to the superclass object.
 * @param acceptMW The accepted mw amount by the responder. aka response mw.
 * @param acceptStatus The accept status submitted by the responder.
 *        Valid values are NON-RESPONSE, ACCEPT, DECLINE, PARTIAL.
 * @param clearedMW MW amount associated with instruction.
 *        For 5 minute binding dispatches, this is the Goto MW or DOT
 * @param passIndicator Part of the Composite key that downstream app uses to match the instruction
 * @param startTime Part of the Composite key that downstream app uses to match the instruction
 * @param RegisteredInterTie
 */
case class InterTieDispatchResponse
(
    override val sup: Element,
    val acceptMW: Double,
    val acceptStatus: String,
    val clearedMW: Double,
    val passIndicator: String,
    val startTime: String,
    val RegisteredInterTie: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, 0.0, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[InterTieDispatchResponse]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object InterTieDispatchResponse
extends
    Parseable[InterTieDispatchResponse]
{
    val sup = BasicElement.parse _
    val acceptMW = parse_element (element ("""InterTieDispatchResponse.acceptMW"""))
    val acceptStatus = parse_attribute (attribute ("""InterTieDispatchResponse.acceptStatus"""))
    val clearedMW = parse_element (element ("""InterTieDispatchResponse.clearedMW"""))
    val passIndicator = parse_attribute (attribute ("""InterTieDispatchResponse.passIndicator"""))
    val startTime = parse_element (element ("""InterTieDispatchResponse.startTime"""))
    val RegisteredInterTie = parse_attribute (attribute ("""InterTieDispatchResponse.RegisteredInterTie"""))
    def parse (context: Context): InterTieDispatchResponse =
    {
        InterTieDispatchResponse(
            sup (context),
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
 * @param sup Reference to the superclass object.
 * @param dropRampRate Maximum rate that load can be reduced (MW/minute)
 * @param loadRedInitiationCost load reduction initiation cost
 * @param loadRedInitiationTime load reduction initiation time
 * @param marketDate The date represents the NextMarketDate for which the load response bids apply to.
 * @param meteredValue Flag indicated that the load reduction is metered. (See above)
 *        If priceSetting and meteredValue both equal 1, then the facility is eligible to set LMP in the real time market.
 * @param minLoad Minimum MW load below which it may not be reduced.
 * @param minLoadReduction Minimum MW for a load reduction (e.g.
 *        MW rating of a discrete pump.
 * @param minLoadReductionCost Cost in $ at the minimum reduced load
 * @param minLoadReductionInterval Shortest period load reduction shall be maintained before load can be restored to normal levels.
 * @param minTimeBetLoadRed Shortest time that load shall be left at normal levels before a new load reduction.
 * @param pickUpRampRate Maximum rate load may be restored (MW/minute)
 * @param priceSetting Flag to indicate that the facility can set LMP Works in tandem with Metered Value.
 *        Greater chance of this being dynamic than the Metered Value, however, it is requested that Price Setting and Metered Value stay at the same source.  Currently no customers have implemented the metering capability, but if this option is implemented, then Price Setting could become dynamic.  However, Metered Value will remain static.
 * @param reqNoticeTime Time period that is required from an order to reduce a load to the time that it takes to get to the minimum load reduction.
 * @param shutdownCost The fixed cost associated with committing a load reduction.
 * @param AreaLoadBid
 * @param RegisteredLoad
 */
case class LoadBid
(
    override val sup: Element,
    val dropRampRate: Double,
    val loadRedInitiationCost: Double,
    val loadRedInitiationTime: Double,
    val marketDate: String,
    val meteredValue: Boolean,
    val minLoad: Double,
    val minLoadReduction: Double,
    val minLoadReductionCost: Double,
    val minLoadReductionInterval: Double,
    val minTimeBetLoadRed: Double,
    val pickUpRampRate: Double,
    val priceSetting: Boolean,
    val reqNoticeTime: Double,
    val shutdownCost: Double,
    val AreaLoadBid: String,
    val RegisteredLoad: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, null, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0, null, null) }
    def ResourceBid: ResourceBid = sup.asInstanceOf[ResourceBid]
    override def copy (): Row = { return (clone ().asInstanceOf[LoadBid]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object LoadBid
extends
    Parseable[LoadBid]
{
    val sup = ResourceBid.parse _
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
            sup (context),
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
 * @param sup Reference to the superclass object.
 * @param endTime Instruction End Time
 * @param loadFollowingMW Load Following MW Positive for follow-up and negative for follow-down
 * @param mssInstructionID Unique instruction id per instruction, assigned by the SC and provided to ADS.
 *        ADS passes through.
 * @param startTime Instruction Start Time
 * @param RegisteredResource
 */
case class LoadFollowingInst
(
    override val sup: Element,
    val endTime: String,
    val loadFollowingMW: Double,
    val mssInstructionID: String,
    val startTime: String,
    val RegisteredResource: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[LoadFollowingInst]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object LoadFollowingInst
extends
    Parseable[LoadFollowingInst]
{
    val sup = BasicElement.parse _
    val endTime = parse_element (element ("""LoadFollowingInst.endTime"""))
    val loadFollowingMW = parse_element (element ("""LoadFollowingInst.loadFollowingMW"""))
    val mssInstructionID = parse_element (element ("""LoadFollowingInst.mssInstructionID"""))
    val startTime = parse_element (element ("""LoadFollowingInst.startTime"""))
    val RegisteredResource = parse_attribute (attribute ("""LoadFollowingInst.RegisteredResource"""))
    def parse (context: Context): LoadFollowingInst =
    {
        LoadFollowingInst(
            sup (context),
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
 * Relationship between price (Y1-axis) vs. MW (X-axis).
 * @param sup Reference to the superclass object.
 * @param LoadBid
 */
case class LoadReductionPriceCurve
(
    override val sup: Element,
    val LoadBid: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { return (clone ().asInstanceOf[LoadReductionPriceCurve]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object LoadReductionPriceCurve
extends
    Parseable[LoadReductionPriceCurve]
{
    val sup = Curve.parse _
    val LoadBid = parse_attribute (attribute ("""LoadReductionPriceCurve.LoadBid"""))
    def parse (context: Context): LoadReductionPriceCurve =
    {
        LoadReductionPriceCurve(
            sup (context),
            LoadBid (context)
        )
    }
}

/**
 * A Major Charge Group is the same as Invocie Type which provides the highest level of grouping for charge types configration.
 * Examples as Market, FERC, RMR,
 * @param sup Reference to the superclass object.
 * @param effectiveDate
 * @param frequencyType
 * @param invoiceType
 * @param requireAutorun
 * @param revisionNumber Revision number for the major charge group
 * @param runType
 * @param runVersion
 * @param terminationDate
 * @param ChargeType A MajorChargeGroup can have 0-n ChargeType.
 *        A ChargeType can associate to 0-n MajorChargeGroup.
 */
case class MajorChargeGroup
(
    override val sup: Element,
    val effectiveDate: String,
    val frequencyType: String,
    val invoiceType: String,
    val requireAutorun: String,
    val revisionNumber: String,
    val runType: String,
    val runVersion: String,
    val terminationDate: String,
    val ChargeType: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, List()) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[MajorChargeGroup]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MajorChargeGroup
extends
    Parseable[MajorChargeGroup]
{
    val sup = IdentifiedObject.parse _
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
            sup (context),
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
 * @param sup Reference to the superclass object.
 * @param category Category of scheduled event.
 * @param duration Duration of the scheduled event, for example, the time to ramp between values.
 * @param status
 * @param MajorChargeGroup
 */
case class MarketScheduledEvent
(
    override val sup: Element,
    val category: String,
    val duration: Double,
    val status: String,
    val MajorChargeGroup: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[MarketScheduledEvent]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MarketScheduledEvent
extends
    Parseable[MarketScheduledEvent]
{
    val sup = IdentifiedObject.parse _
    val category = parse_element (element ("""MarketScheduledEvent.category"""))
    val duration = parse_element (element ("""MarketScheduledEvent.duration"""))
    val status = parse_attribute (attribute ("""MarketScheduledEvent.status"""))
    val MajorChargeGroup = parse_attribute (attribute ("""MarketScheduledEvent.MajorChargeGroup"""))
    def parse (context: Context): MarketScheduledEvent =
    {
        MarketScheduledEvent(
            sup (context),
            category (context),
            toDouble (duration (context), context),
            status (context),
            MajorChargeGroup (context)
        )
    }
}

/**
 * Notification time curve as a function of down time.
 * Relationship between crew notification time (Y1-axis) and unit startup time (Y2-axis) vs. unit elapsed down time (X-axis).
 * @param sup Reference to the superclass object.
 */
case class NotificationTimeCurve
(
    override val sup: Element
)
extends
    Element
{
    def this () = { this (null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { return (clone ().asInstanceOf[NotificationTimeCurve]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object NotificationTimeCurve
extends
    Parseable[NotificationTimeCurve]
{
    val sup = Curve.parse _
    def parse (context: Context): NotificationTimeCurve =
    {
        NotificationTimeCurve(
            sup (context)
        )
    }
}

/**
 * Result of bid validation against conditions that may exist on an interchange that becomes disconnected or is heavily discounted with respect the MW flow.
 * This schedule is assocated with the hourly parameters in a resource bid.
 * @param sup Reference to the superclass object.
 * @param value
 */
case class OpenTieSchedule
(
    override val sup: Element,
    val value: Boolean
)
extends
    Element
{
    def this () = { this (null, false) }
    def BidHourlySchedule: BidHourlySchedule = sup.asInstanceOf[BidHourlySchedule]
    override def copy (): Row = { return (clone ().asInstanceOf[OpenTieSchedule]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OpenTieSchedule
extends
    Parseable[OpenTieSchedule]
{
    val sup = BidHourlySchedule.parse _
    val value = parse_element (element ("""OpenTieSchedule.value"""))
    def parse (context: Context): OpenTieSchedule =
    {
        OpenTieSchedule(
            sup (context),
            toBoolean (value (context), context)
        )
    }
}

/**
 * Component of a bid that pertains to one market product.
 * @param sup Reference to the superclass object.
 * @param Bid A bid comprises one or more product bids of market products
 * @param MarketProduct
 */
case class ProductBid
(
    override val sup: Element,
    val Bid: String,
    val MarketProduct: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ProductBid]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ProductBid
extends
    Parseable[ProductBid]
{
    val sup = IdentifiedObject.parse _
    val Bid = parse_attribute (attribute ("""ProductBid.Bid"""))
    val MarketProduct = parse_attribute (attribute ("""ProductBid.MarketProduct"""))
    def parse (context: Context): ProductBid =
    {
        ProductBid(
            sup (context),
            Bid (context),
            MarketProduct (context)
        )
    }
}

/**
 * The operating cost of a Pump Storage Hydro Unit operating as a hydro pump.
 * This schedule is assocated with the hourly parameters in a resource bid associated with a specific product within the bid.
 * @param sup Reference to the superclass object.
 * @param value
 */
case class PumpingCostSchedule
(
    override val sup: Element,
    val value: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
    def BidHourlyProductSchedule: BidHourlyProductSchedule = sup.asInstanceOf[BidHourlyProductSchedule]
    override def copy (): Row = { return (clone ().asInstanceOf[PumpingCostSchedule]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PumpingCostSchedule
extends
    Parseable[PumpingCostSchedule]
{
    val sup = BidHourlyProductSchedule.parse _
    val value = parse_element (element ("""PumpingCostSchedule.value"""))
    def parse (context: Context): PumpingCostSchedule =
    {
        PumpingCostSchedule(
            sup (context),
            toDouble (value (context), context)
        )
    }
}

/**
 * The fixed operating level of a Pump Storage Hydro Unit operating as a hydro pump.
 * Associated with the energy market product type.
 * @param sup Reference to the superclass object.
 * @param value
 */
case class PumpingLevelSchedule
(
    override val sup: Element,
    val value: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
    def BidHourlyProductSchedule: BidHourlyProductSchedule = sup.asInstanceOf[BidHourlyProductSchedule]
    override def copy (): Row = { return (clone ().asInstanceOf[PumpingLevelSchedule]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PumpingLevelSchedule
extends
    Parseable[PumpingLevelSchedule]
{
    val sup = BidHourlyProductSchedule.parse _
    val value = parse_element (element ("""PumpingLevelSchedule.value"""))
    def parse (context: Context): PumpingLevelSchedule =
    {
        PumpingLevelSchedule(
            sup (context),
            toDouble (value (context), context)
        )
    }
}

/**
 * The cost to shutdown a Pump Storage Hydro Unit (in pump mode) or a pump.
 * This schedule is assocated with the hourly parameters in a resource bid associated with a specific product within the bid.
 * @param sup Reference to the superclass object.
 * @param value
 */
case class PumpingShutDownCostSchedule
(
    override val sup: Element,
    val value: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
    def BidHourlyProductSchedule: BidHourlyProductSchedule = sup.asInstanceOf[BidHourlyProductSchedule]
    override def copy (): Row = { return (clone ().asInstanceOf[PumpingShutDownCostSchedule]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PumpingShutDownCostSchedule
extends
    Parseable[PumpingShutDownCostSchedule]
{
    val sup = BidHourlyProductSchedule.parse _
    val value = parse_element (element ("""PumpingShutDownCostSchedule.value"""))
    def parse (context: Context): PumpingShutDownCostSchedule =
    {
        PumpingShutDownCostSchedule(
            sup (context),
            toDouble (value (context), context)
        )
    }
}

/**
 * Ramp rate as a function of resource MW output
 * @param sup Reference to the superclass object.
 * @param condition condition for the ramp rate
 * @param constraintRampType The condition that identifies whether a Generating Resource should be constrained from Ancillary Service provision if its Schedule or Dispatch change across Trading Hours or Trading Intervals requires more than a specified fraction of the duration of the Trading Hour or Trading Interval.
 *        Valid values are Fast/Slow
 * @param rampRateType How ramp rate is applied (e.g. raise or lower, as when applied to a generation resource)
 * @param GeneratingBid
 * @param InterTieBid
 * @param LoadBid
 */
case class RampRateCurve
(
    override val sup: Element,
    val condition: String,
    val constraintRampType: String,
    val rampRateType: String,
    val GeneratingBid: String,
    val InterTieBid: String,
    val LoadBid: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { return (clone ().asInstanceOf[RampRateCurve]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RampRateCurve
extends
    Parseable[RampRateCurve]
{
    val sup = Curve.parse _
    val condition = parse_attribute (attribute ("""RampRateCurve.condition"""))
    val constraintRampType = parse_attribute (attribute ("""RampRateCurve.constraintRampType"""))
    val rampRateType = parse_attribute (attribute ("""RampRateCurve.rampRateType"""))
    val GeneratingBid = parse_attribute (attribute ("""RampRateCurve.GeneratingBid"""))
    val InterTieBid = parse_attribute (attribute ("""RampRateCurve.InterTieBid"""))
    val LoadBid = parse_attribute (attribute ("""RampRateCurve.LoadBid"""))
    def parse (context: Context): RampRateCurve =
    {
        RampRateCurve(
            sup (context),
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
 * @param sup Reference to the superclass object.
 * @param aggregationFlag Aggregation flag 
0: individual resource level
1: Aggregated node location
 *        2: Aggregated price location)
 * @param bidStatus
 * @param commodityType Energy product (commodity) type:
'En' - Energy
'Ru' - Regulation Up
'Rd' - Regulation Dn
'Sr' - Spinning Reserve
'Nr' - Non-Spinning Reserve
 *        'Or' - Operating Reserve
 * @param contingencyAvailFlag contingent operating reserve availiability (Yes/No).
 *        Resource is availiable to participate with capacity only in contingency dispatch.
 * @param createdISO A Yes indicates that this bid was created by the ISO.
 * @param energyMaxDay Maximum amount of energy per day which can be produced during the trading period in MWh
 * @param energyMinDay Minimum amount of energy per day which has to be produced during the trading period in MWh
 * @param marketSepFlag Market Separation Flag

'Y' - Enforce market separation constraints for this bid
 *        'N' - Don't enforce market separation constraints for this bid.
 * @param minDispatchTime minimum number of consecutive hours a resource shall be dispatched if bid is accepted
 * @param resourceLoadingType Resource loading curve type
1 - step-wise continuous loading
2 - piece-wise linear continuous loading
 *        3 - block loading
 * @param shutDownsMaxDay Maximum number of shutdowns per day.
 * @param shutDownsMaxWeek Maximum number of shutdowns per week.
 * @param startUpsMaxDay Maximum number of startups per day.
 * @param startUpsMaxWeek Maximum number of startups per week.
 * @param virtual True if bid is virtual.
 *        Bid is assumed to be non-virtual if attribute is absent
 * @param BidError
 */
case class ResourceBid
(
    override val sup: Element,
    val aggregationFlag: Int,
    val bidStatus: String,
    val commodityType: String,
    val contingencyAvailFlag: String,
    val createdISO: String,
    val energyMaxDay: Double,
    val energyMinDay: Double,
    val marketSepFlag: String,
    val minDispatchTime: Int,
    val resourceLoadingType: Int,
    val shutDownsMaxDay: Int,
    val shutDownsMaxWeek: Int,
    val startUpsMaxDay: Int,
    val startUpsMaxWeek: Int,
    val virtual: Boolean,
    val BidError: List[String]
)
extends
    Element
{
    def this () = { this (null, 0, null, null, null, null, 0.0, 0.0, null, 0, 0, 0, 0, 0, 0, false, List()) }
    def Bid: Bid = sup.asInstanceOf[Bid]
    override def copy (): Row = { return (clone ().asInstanceOf[ResourceBid]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ResourceBid
extends
    Parseable[ResourceBid]
{
    val sup = Bid.parse _
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
            sup (context),
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
 * Relationship between unit startup cost (Y1-axis) vs. unit elapsed down time (X-axis).
 * @param sup Reference to the superclass object.
 * @param RegisteredGenerators
 */
case class StartUpCostCurve
(
    override val sup: Element,
    val RegisteredGenerators: List[String]
)
extends
    Element
{
    def this () = { this (null, List()) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { return (clone ().asInstanceOf[StartUpCostCurve]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object StartUpCostCurve
extends
    Parseable[StartUpCostCurve]
{
    val sup = Curve.parse _
    val RegisteredGenerators = parse_attributes (attribute ("""StartUpCostCurve.RegisteredGenerators"""))
    def parse (context: Context): StartUpCostCurve =
    {
        StartUpCostCurve(
            sup (context),
            RegisteredGenerators (context)
        )
    }
}

/**
 * Startup time curve as a function of down time, where time is specified in minutes.
 * Relationship between unit startup time (Y1-axis) vs. unit elapsed down time (X-axis).
 * @param sup Reference to the superclass object.
 * @param RegisteredGenerator
 */
case class StartUpTimeCurve
(
    override val sup: Element,
    val RegisteredGenerator: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { return (clone ().asInstanceOf[StartUpTimeCurve]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object StartUpTimeCurve
extends
    Parseable[StartUpTimeCurve]
{
    val sup = Curve.parse _
    val RegisteredGenerator = parse_attribute (attribute ("""StartUpTimeCurve.RegisteredGenerator"""))
    def parse (context: Context): StartUpTimeCurve =
    {
        StartUpTimeCurve(
            sup (context),
            RegisteredGenerator (context)
        )
    }
}

/**
 * Inter Scheduling Coordinator Trades to model financial trades which may impact settlement
 * @param sup Reference to the superclass object.
 * @param adjustedTradeQuantity The validated and current market accepted trade amount of a physical energy trade.
 * @param counterTradeQuantity MW quantity submitted by counter SC for the same trade
 * @param dependOnTradeName The Depend On IST Name points to the unique IST Name in the chain of physical energy trades.
 * @param lastModified Time and date the trade was last modified.
 * @param marketType
 * @param startTime Start time and date for which trade applies.
 * @param stopTime Stop time and date for which trade is applicable.
 * @param submitFromSchedulingCoordinator
 * @param submitFromTimeStamp Timestamp of submittal of submit From Scheduling Coordinator Trade to Market Participant Bid Submittal
 * @param submitFromUser Userid of the submit From Scheduling Coordinator trade
 * @param submitToSchedulingCoordinator
 * @param submitToTimeStamp Timestamp of submittal of submit To Scheduling Coordinator Trade to Market Participant Bid Submittal
 * @param submitToUser_1 Userid of the submit To Scheduling Coordinator trade
 * @param tradeQuantity tradeQuantity: 
If tradeType = IST, The amount of an Energy Trade.
 *        If tradeType = AST, The amount of an Ancillary Service Obligation Trade.
 * @param tradeStatus Resulting status of the trade following the rule engine processing.
 * @param updateTimeStamp
 * @param updateUser
 * @param ActionRequest
 * @param From_SC
 * @param Pnode
 * @param RegisteredGenerator
 * @param To_SC
 * @param TradeProduct
 */
case class Trade
(
    override val sup: Element,
    val adjustedTradeQuantity: Double,
    val counterTradeQuantity: Double,
    val dependOnTradeName: String,
    val lastModified: String,
    val marketType: String,
    val startTime: String,
    val stopTime: String,
    val submitFromSchedulingCoordinator: String,
    val submitFromTimeStamp: String,
    val submitFromUser: String,
    val submitToSchedulingCoordinator: String,
    val submitToTimeStamp: String,
    val submitToUser_1: String,
    val tradeQuantity: Double,
    val tradeStatus: String,
    val updateTimeStamp: String,
    val updateUser: String,
    val ActionRequest: String,
    val From_SC: String,
    val Pnode: String,
    val RegisteredGenerator: String,
    val To_SC: String,
    val TradeProduct: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null, null, null, null, null, null, null, null, null, null, null, 0.0, null, null, null, null, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Trade]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Trade
extends
    Parseable[Trade]
{
    val sup = IdentifiedObject.parse _
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
            sup (context),
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
 * @param sup Reference to the superclass object.
 * @param endTime hour wihthin the trade for which the error applies
 * @param errMessage error message
 * @param errPriority Priority number for the error message
 * @param logTimeStamp Timestamp of logged error/warning message
 * @param ruleID Rule identifier which triggered the error/warning message
 * @param startTime hour wihthin the trade for which the error applies
 * @param Trade
 */
case class TradeError
(
    override val sup: Element,
    val endTime: String,
    val errMessage: String,
    val errPriority: Int,
    val logTimeStamp: String,
    val ruleID: Int,
    val startTime: String,
    val Trade: String
)
extends
    Element
{
    def this () = { this (null, null, null, 0, null, 0, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[TradeError]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TradeError
extends
    Parseable[TradeError]
{
    val sup = IdentifiedObject.parse _
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
            sup (context),
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
IST  (InterSC Trade)                          PHY (Physical Energy Trade)
IST                                                  APN (Energy Trades at Aggregated Pricing Nodes)
IST                                                  CPT (Converted Physical Energy Trade)
AST (Ancilliary Services Trade)             RUT (Regulation Up Trade)
AST                                                 RDT (Regulation Down Trade)
AST                                                 SRT (Spinning Reserve Trade)
AST                                                 NRT (Non-Spinning Reserve Trade)
 * UCT (Unit Commitment Trade)            null
 * @param sup Reference to the superclass object.
 * @param tradeProductType PHY (Physical Energy Trade);  
APN (Energy Trades at Aggregated Pricing Nodes);  
CPT (Converted Physical Energy Trade);  
RUT (Regulation Up Trade);  
RDT (Regulation Down Trade);  
SRT (Spinning Reserve Trade);
 *        NRT (Non-Spinning Reserve Trade)
 * @param tradeType IST  - InterSC Trade;  
AST - Ancilliary Services Trade;
 *        UCT - Unit Commitment Trade
 */
case class TradeProduct
(
    override val sup: Element,
    val tradeProductType: String,
    val tradeType: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[TradeProduct]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TradeProduct
extends
    Parseable[TradeProduct]
{
    val sup = BasicElement.parse _
    val tradeProductType = parse_element (element ("""TradeProduct.tradeProductType"""))
    val tradeType = parse_attribute (attribute ("""TradeProduct.tradeType"""))
    def parse (context: Context): TradeProduct =
    {
        TradeProduct(
            sup (context),
            tradeProductType (context),
            tradeType (context)
        )
    }
}

/**
 * Bilateral or scheduled transactions for energy and ancillary services considered by market clearing process
 * @param sup Reference to the superclass object.
 * @param demandTransaction Set true if this is a demand transaction.
 * @param dispatchable Set true if this is a dispatchable transaction.
 * @param payCongestion Set true if this is a willing to pay transaction.
 *        This flag is used to determine whether a schedule is willing-to-pay-congestion or not.
 * @param Delivery_Pnode
 * @param Receipt_Pnode
 * @param TransmissionReservation
 */
case class TransactionBid
(
    override val sup: Element,
    val demandTransaction: Boolean,
    val dispatchable: Boolean,
    val payCongestion: Boolean,
    val Delivery_Pnode: String,
    val Receipt_Pnode: String,
    val TransmissionReservation: String
)
extends
    Element
{
    def this () = { this (null, false, false, false, null, null, null) }
    def Bid: Bid = sup.asInstanceOf[Bid]
    override def copy (): Row = { return (clone ().asInstanceOf[TransactionBid]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TransactionBid
extends
    Parseable[TransactionBid]
{
    val sup = Bid.parse _
    val demandTransaction = parse_element (element ("""TransactionBid.demandTransaction"""))
    val dispatchable = parse_element (element ("""TransactionBid.dispatchable"""))
    val payCongestion = parse_element (element ("""TransactionBid.payCongestion"""))
    val Delivery_Pnode = parse_attribute (attribute ("""TransactionBid.Delivery_Pnode"""))
    val Receipt_Pnode = parse_attribute (attribute ("""TransactionBid.Receipt_Pnode"""))
    val TransmissionReservation = parse_attribute (attribute ("""TransactionBid.TransmissionReservation"""))
    def parse (context: Context): TransactionBid =
    {
        TransactionBid(
            sup (context),
            toBoolean (demandTransaction (context), context),
            toBoolean (dispatchable (context), context),
            toBoolean (payCongestion (context), context),
            Delivery_Pnode (context),
            Receipt_Pnode (context),
            TransmissionReservation (context)
        )
    }
}

object _ParticipantInterfaces
{
    def register: Unit =
    {
        ActionRequest.register
        AreaLoadBid.register
        AttributeProperty.register
        Bid.register
        BidDistributionFactor.register
        BidError.register
        BidHourlyProductSchedule.register
        BidHourlySchedule.register
        BidPriceCurve.register
        BidPriceSchedule.register
        BidSelfSched.register
        BidSet.register
        ChargeComponent.register
        ChargeGroup.register
        ChargeType.register
        DispatchInstReply.register
        EnergyPriceCurve.register
        GeneratingBid.register
        HourlyPreDispatchSchedule.register
        InterTieBid.register
        InterTieDispatchResponse.register
        LoadBid.register
        LoadFollowingInst.register
        LoadReductionPriceCurve.register
        MajorChargeGroup.register
        MarketScheduledEvent.register
        NotificationTimeCurve.register
        OpenTieSchedule.register
        ProductBid.register
        PumpingCostSchedule.register
        PumpingLevelSchedule.register
        PumpingShutDownCostSchedule.register
        RampRateCurve.register
        ResourceBid.register
        StartUpCostCurve.register
        StartUpTimeCurve.register
        Trade.register
        TradeError.register
        TradeProduct.register
        TransactionBid.register
    }
}