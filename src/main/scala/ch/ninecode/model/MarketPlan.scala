package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * Market plan definitions for planned markets, planned market events, actual market runs, actual market events.
 */

/**
 * Model that describes the Congestion Revenue Rights Auction Market
 * @param sup Reference to the superclass object.
 * @param labelID labelID - an ID for a set of apnodes/pnodes used in a CRR market
 */
case class CRRMarket
(
    override val sup: Market,
    labelID: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Market: Market = sup.asInstanceOf[Market]
    override def copy (): Row = { clone ().asInstanceOf[CRRMarket] }
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
        (if (null != labelID) "\t\t<cim:CRRMarket.labelID>" + labelID + "</cim:CRRMarket.labelID>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:CRRMarket rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CRRMarket>"
    }
}

object CRRMarket
extends
    Parseable[CRRMarket]
{
    val labelID: (Context) => String = parse_element (element ("""CRRMarket.labelID"""))
    def parse (context: Context): CRRMarket =
    {
        CRRMarket(
            Market.parse (context),
            labelID (context)
        )
    }
}

/**
 * Energy and Ancillary Market (e.g.
 * Energy, Spinning Reserve, Non-Spinning Reserve) with a description of the Market operation control parameters.
 * @param sup Reference to the superclass object.
 * @param MarketResults <em>undocumented</em>
 * @param RTO <em>undocumented</em>
 * @param RegisteredResources <em>undocumented</em>
 */
case class EnergyMarket
(
    override val sup: Market,
    MarketResults: String,
    RTO: String,
    RegisteredResources: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, List()) }
    def Market: Market = sup.asInstanceOf[Market]
    override def copy (): Row = { clone ().asInstanceOf[EnergyMarket] }
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
        (if (null != MarketResults) "\t\t<cim:EnergyMarket.MarketResults rdf:resource=\"#" + MarketResults + "\"/>\n" else "") +
        (if (null != RTO) "\t\t<cim:EnergyMarket.RTO rdf:resource=\"#" + RTO + "\"/>\n" else "") +
        (if (null != RegisteredResources) RegisteredResources.map (x => "\t\t<cim:EnergyMarket.RegisteredResources rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:EnergyMarket rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:EnergyMarket>"
    }
}

object EnergyMarket
extends
    Parseable[EnergyMarket]
{
    val MarketResults: (Context) => String = parse_attribute (attribute ("""EnergyMarket.MarketResults"""))
    val RTO: (Context) => String = parse_attribute (attribute ("""EnergyMarket.RTO"""))
    val RegisteredResources: (Context) => List[String] = parse_attributes (attribute ("""EnergyMarket.RegisteredResources"""))
    def parse (context: Context): EnergyMarket =
    {
        EnergyMarket(
            Market.parse (context),
            MarketResults (context),
            RTO (context),
            RegisteredResources (context)
        )
    }
}

/**
 * Market (e.g.
 * Day Ahead Market, RealTime Market) with a description of the the Market operation control parameters.
 * @param sup Reference to the superclass object.
 * @param actualEnd Market ending time - actual market end
 * @param actualStart Market starting time - actual market start
 * @param dst True if daylight savings time (DST) is in effect.
 * @param end Market end time.
 * @param localTimeZone Local time zone.
 * @param start Market start time.
 * @param status Market Status
 *        'OPEN', 'CLOSED', 'CLEARED', 'BLOCKED'
 * @param timeIntervalLength Trading time interval length.
 * @param tradingDay Market trading date
 * @param tradingPeriod Trading period that describes the market, possibilities could be for an Energy Market:
Day
Hour

For a CRR Market:
Year
Month
 *        Season
 */
case class Market
(
    override val sup: IdentifiedObject,
    actualEnd: String,
    actualStart: String,
    dst: Boolean,
    end: String,
    localTimeZone: String,
    start: String,
    status: String,
    timeIntervalLength: Double,
    tradingDay: String,
    tradingPeriod: String
)
extends
    Element
{
    def this () = { this (null, null, null, false, null, null, null, null, 0.0, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Market] }
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
        (if (null != actualEnd) "\t\t<cim:Market.actualEnd>" + actualEnd + "</cim:Market.actualEnd>\n" else "") +
        (if (null != actualStart) "\t\t<cim:Market.actualStart>" + actualStart + "</cim:Market.actualStart>\n" else "") +
        "\t\t<cim:Market.dst>" + dst + "</cim:Market.dst>\n" +
        (if (null != end) "\t\t<cim:Market.end>" + end + "</cim:Market.end>\n" else "") +
        (if (null != localTimeZone) "\t\t<cim:Market.localTimeZone>" + localTimeZone + "</cim:Market.localTimeZone>\n" else "") +
        (if (null != start) "\t\t<cim:Market.start>" + start + "</cim:Market.start>\n" else "") +
        (if (null != status) "\t\t<cim:Market.status>" + status + "</cim:Market.status>\n" else "") +
        "\t\t<cim:Market.timeIntervalLength>" + timeIntervalLength + "</cim:Market.timeIntervalLength>\n" +
        (if (null != tradingDay) "\t\t<cim:Market.tradingDay>" + tradingDay + "</cim:Market.tradingDay>\n" else "") +
        (if (null != tradingPeriod) "\t\t<cim:Market.tradingPeriod>" + tradingPeriod + "</cim:Market.tradingPeriod>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Market rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Market>"
    }
}

object Market
extends
    Parseable[Market]
{
    val actualEnd: (Context) => String = parse_element (element ("""Market.actualEnd"""))
    val actualStart: (Context) => String = parse_element (element ("""Market.actualStart"""))
    val dst: (Context) => String = parse_element (element ("""Market.dst"""))
    val end: (Context) => String = parse_element (element ("""Market.end"""))
    val localTimeZone: (Context) => String = parse_element (element ("""Market.localTimeZone"""))
    val start: (Context) => String = parse_element (element ("""Market.start"""))
    val status: (Context) => String = parse_element (element ("""Market.status"""))
    val timeIntervalLength: (Context) => String = parse_element (element ("""Market.timeIntervalLength"""))
    val tradingDay: (Context) => String = parse_element (element ("""Market.tradingDay"""))
    val tradingPeriod: (Context) => String = parse_element (element ("""Market.tradingPeriod"""))
    def parse (context: Context): Market =
    {
        Market(
            IdentifiedObject.parse (context),
            actualEnd (context),
            actualStart (context),
            toBoolean (dst (context), context),
            end (context),
            localTimeZone (context),
            start (context),
            status (context),
            toDouble (timeIntervalLength (context), context),
            tradingDay (context),
            tradingPeriod (context)
        )
    }
}

/**
 * This class represent the actual instance of an event.
 * @param sup Reference to the superclass object.
 * @param description Description of the event.
 * @param eventID Actual event ID.
 * @param eventTime Start time of the event.
 * @param MarketRun Market run triggered by this actual event.
 *        For example, the DA run is triggered by the actual open bid submission event and terminated by the actual close bid submission event.
 * @param PlannedMarketEvent Planned event executed by this actual event.
 */
case class MarketActualEvent
(
    override val sup: BasicElement,
    description: String,
    eventID: String,
    eventTime: String,
    MarketRun: String,
    PlannedMarketEvent: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[MarketActualEvent] }
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
        (if (null != description) "\t\t<cim:MarketActualEvent.description>" + description + "</cim:MarketActualEvent.description>\n" else "") +
        (if (null != eventID) "\t\t<cim:MarketActualEvent.eventID>" + eventID + "</cim:MarketActualEvent.eventID>\n" else "") +
        (if (null != eventTime) "\t\t<cim:MarketActualEvent.eventTime>" + eventTime + "</cim:MarketActualEvent.eventTime>\n" else "") +
        (if (null != MarketRun) "\t\t<cim:MarketActualEvent.MarketRun rdf:resource=\"#" + MarketRun + "\"/>\n" else "") +
        (if (null != PlannedMarketEvent) "\t\t<cim:MarketActualEvent.PlannedMarketEvent rdf:resource=\"#" + PlannedMarketEvent + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MarketActualEvent rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MarketActualEvent>"
    }
}

object MarketActualEvent
extends
    Parseable[MarketActualEvent]
{
    val description: (Context) => String = parse_element (element ("""MarketActualEvent.description"""))
    val eventID: (Context) => String = parse_element (element ("""MarketActualEvent.eventID"""))
    val eventTime: (Context) => String = parse_element (element ("""MarketActualEvent.eventTime"""))
    val MarketRun: (Context) => String = parse_attribute (attribute ("""MarketActualEvent.MarketRun"""))
    val PlannedMarketEvent: (Context) => String = parse_attribute (attribute ("""MarketActualEvent.PlannedMarketEvent"""))
    def parse (context: Context): MarketActualEvent =
    {
        MarketActualEvent(
            BasicElement.parse (context),
            description (context),
            eventID (context),
            eventTime (context),
            MarketRun (context),
            PlannedMarketEvent (context)
        )
    }
}

/**
 * Aggregation of market information relative for a specific time interval.
 * @param sup Reference to the superclass object.
 * @param intervalEndTime The end of the time interval for which requirement is defined.
 * @param intervalStartTime The start of the time interval for which requirement is defined.
 * @param Market <em>undocumented</em>
 * @param MktActivityRecord <em>undocumented</em>
 */
case class MarketFactors
(
    override val sup: Document,
    intervalEndTime: String,
    intervalStartTime: String,
    Market: String,
    MktActivityRecord: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, null, List()) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[MarketFactors] }
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
        (if (null != intervalEndTime) "\t\t<cim:MarketFactors.intervalEndTime>" + intervalEndTime + "</cim:MarketFactors.intervalEndTime>\n" else "") +
        (if (null != intervalStartTime) "\t\t<cim:MarketFactors.intervalStartTime>" + intervalStartTime + "</cim:MarketFactors.intervalStartTime>\n" else "") +
        (if (null != Market) "\t\t<cim:MarketFactors.Market rdf:resource=\"#" + Market + "\"/>\n" else "") +
        (if (null != MktActivityRecord) MktActivityRecord.map (x => "\t\t<cim:MarketFactors.MktActivityRecord rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:MarketFactors rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MarketFactors>"
    }
}

object MarketFactors
extends
    Parseable[MarketFactors]
{
    val intervalEndTime: (Context) => String = parse_element (element ("""MarketFactors.intervalEndTime"""))
    val intervalStartTime: (Context) => String = parse_element (element ("""MarketFactors.intervalStartTime"""))
    val Market: (Context) => String = parse_attribute (attribute ("""MarketFactors.Market"""))
    val MktActivityRecord: (Context) => List[String] = parse_attributes (attribute ("""MarketFactors.MktActivityRecord"""))
    def parse (context: Context): MarketFactors =
    {
        MarketFactors(
            Document.parse (context),
            intervalEndTime (context),
            intervalStartTime (context),
            Market (context),
            MktActivityRecord (context)
        )
    }
}

/**
 * This class identifies a set of planned markets.
 * This class is a container of these planned markets
 * @param sup Reference to the superclass object.
 * @param description Description of the planned market.
 * @param marketPlanID Planned market identifier.
 * @param name Name of the planned market.
 * @param tradingDay Planned market trading day.
 */
case class MarketPlan
(
    override val sup: BasicElement,
    description: String,
    marketPlanID: String,
    name: String,
    tradingDay: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[MarketPlan] }
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
        (if (null != description) "\t\t<cim:MarketPlan.description>" + description + "</cim:MarketPlan.description>\n" else "") +
        (if (null != marketPlanID) "\t\t<cim:MarketPlan.marketPlanID>" + marketPlanID + "</cim:MarketPlan.marketPlanID>\n" else "") +
        (if (null != name) "\t\t<cim:MarketPlan.name>" + name + "</cim:MarketPlan.name>\n" else "") +
        (if (null != tradingDay) "\t\t<cim:MarketPlan.tradingDay>" + tradingDay + "</cim:MarketPlan.tradingDay>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MarketPlan rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MarketPlan>"
    }
}

object MarketPlan
extends
    Parseable[MarketPlan]
{
    val description: (Context) => String = parse_element (element ("""MarketPlan.description"""))
    val marketPlanID: (Context) => String = parse_element (element ("""MarketPlan.marketPlanID"""))
    val name: (Context) => String = parse_element (element ("""MarketPlan.name"""))
    val tradingDay: (Context) => String = parse_element (element ("""MarketPlan.tradingDay"""))
    def parse (context: Context): MarketPlan =
    {
        MarketPlan(
            BasicElement.parse (context),
            description (context),
            marketPlanID (context),
            name (context),
            tradingDay (context)
        )
    }
}

/**
 * A product traded by an RTO (e.g. energy, 10 minute spinning reserve).
 * Ancillary service product examples include:Regulation UpRegulation DnSpinning ReserveNon-Spinning ReserveOperating Reserve
 * @param sup Reference to the superclass object.
 * @param marketProductType Market product type examples:

EN (Energy)
RU (Regulation Up)
RD (Regulation Dn)
SR (Spinning Reserve)
NR (Non-Spinning Reserve)
 *        RC (RUC)
 * @param rampInterval Ramping time interval for the specific market product type specified by marketProductType attribute.
 *        For example, if marketProductType = EN (from enumeration MarketProductType), then the rampInterval is the ramping time interval for Energy.
 * @param Market <em>undocumented</em>
 * @param MarketRegionResults <em>undocumented</em>
 */
case class MarketProduct
(
    override val sup: IdentifiedObject,
    marketProductType: String,
    rampInterval: Double,
    Market: String,
    MarketRegionResults: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[MarketProduct] }
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
        (if (null != marketProductType) "\t\t<cim:MarketProduct.marketProductType rdf:resource=\"#" + marketProductType + "\"/>\n" else "") +
        "\t\t<cim:MarketProduct.rampInterval>" + rampInterval + "</cim:MarketProduct.rampInterval>\n" +
        (if (null != Market) "\t\t<cim:MarketProduct.Market rdf:resource=\"#" + Market + "\"/>\n" else "") +
        (if (null != MarketRegionResults) "\t\t<cim:MarketProduct.MarketRegionResults rdf:resource=\"#" + MarketRegionResults + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MarketProduct rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MarketProduct>"
    }
}

object MarketProduct
extends
    Parseable[MarketProduct]
{
    val marketProductType: (Context) => String = parse_attribute (attribute ("""MarketProduct.marketProductType"""))
    val rampInterval: (Context) => String = parse_element (element ("""MarketProduct.rampInterval"""))
    val Market: (Context) => String = parse_attribute (attribute ("""MarketProduct.Market"""))
    val MarketRegionResults: (Context) => String = parse_attribute (attribute ("""MarketProduct.MarketRegionResults"""))
    def parse (context: Context): MarketProduct =
    {
        MarketProduct(
            IdentifiedObject.parse (context),
            marketProductType (context),
            toDouble (rampInterval (context), context),
            Market (context),
            MarketRegionResults (context)
        )
    }
}

/**
 * This class represent an actual instance of a planned market.
 * For example, a Day Ahead market opens with the Bid Submission, ends with the closing of the Bid Submission. The market run represent the whole process. MarketRuns can be defined for markets such as Day Ahead Market, Real Time Market, Hour Ahead Market, Week Ahead Market,...
 * @param sup Reference to the superclass object.
 * @param executionType The execution type; Day Ahead, Intra Day, Real Time Pre-Dispatch, Real Time Dispatch
 * @param marketApprovalTime Approved time for case.
 *        Identifies the time that the dispatcher approved a specific real time unit dispatch case
 * @param marketApprovedStatus Set to true when the plan is approved by authority and becomes the official plan for the day ahead market.
 *        Identifies the approved case for the market for the specified time interval.
 * @param marketEndTime The end time defined as the end of the market, market end time.
 * @param marketID An identification that defines the attributes of the Market.
 *        In todays terms: Market Type: DA, RTM, Trade Date:  1/25/04, Trade Hour: 1-25
 * @param marketRunID A unique identifier that differentiates the different runs of the same Market ID.
 *        More specifically, if the market is re-opened and re-closed and rerun completely, the first set of results and the second set of results produced will have the same Market ID but will have different Market Run IDs since the multiple run is for the same market.
 * @param marketStartTime The start time defined as the beginning of the market, market start time.
 * @param marketType The market type, Day Ahead Market or Real Time Market.
 * @param reportedState This is the state of market run activitie as reported by market systems to the market definition services.
 * @param runState This is the state controlled by market defintion service.
 *        possible values could be but not limited by: Open, Close.
 * @param Market <em>undocumented</em>
 * @param PlannedMarket A planned market could have multiple market runs for the reason that a planned market could have a rerun.
 */
case class MarketRun
(
    override val sup: BasicElement,
    executionType: String,
    marketApprovalTime: String,
    marketApprovedStatus: Boolean,
    marketEndTime: String,
    marketID: String,
    marketRunID: String,
    marketStartTime: String,
    marketType: String,
    reportedState: String,
    runState: String,
    Market: String,
    PlannedMarket: String
)
extends
    Element
{
    def this () = { this (null, null, null, false, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[MarketRun] }
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
        (if (null != executionType) "\t\t<cim:MarketRun.executionType rdf:resource=\"#" + executionType + "\"/>\n" else "") +
        (if (null != marketApprovalTime) "\t\t<cim:MarketRun.marketApprovalTime>" + marketApprovalTime + "</cim:MarketRun.marketApprovalTime>\n" else "") +
        "\t\t<cim:MarketRun.marketApprovedStatus>" + marketApprovedStatus + "</cim:MarketRun.marketApprovedStatus>\n" +
        (if (null != marketEndTime) "\t\t<cim:MarketRun.marketEndTime>" + marketEndTime + "</cim:MarketRun.marketEndTime>\n" else "") +
        (if (null != marketID) "\t\t<cim:MarketRun.marketID>" + marketID + "</cim:MarketRun.marketID>\n" else "") +
        (if (null != marketRunID) "\t\t<cim:MarketRun.marketRunID>" + marketRunID + "</cim:MarketRun.marketRunID>\n" else "") +
        (if (null != marketStartTime) "\t\t<cim:MarketRun.marketStartTime>" + marketStartTime + "</cim:MarketRun.marketStartTime>\n" else "") +
        (if (null != marketType) "\t\t<cim:MarketRun.marketType rdf:resource=\"#" + marketType + "\"/>\n" else "") +
        (if (null != reportedState) "\t\t<cim:MarketRun.reportedState>" + reportedState + "</cim:MarketRun.reportedState>\n" else "") +
        (if (null != runState) "\t\t<cim:MarketRun.runState>" + runState + "</cim:MarketRun.runState>\n" else "") +
        (if (null != Market) "\t\t<cim:MarketRun.Market rdf:resource=\"#" + Market + "\"/>\n" else "") +
        (if (null != PlannedMarket) "\t\t<cim:MarketRun.PlannedMarket rdf:resource=\"#" + PlannedMarket + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MarketRun rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MarketRun>"
    }
}

object MarketRun
extends
    Parseable[MarketRun]
{
    val executionType: (Context) => String = parse_attribute (attribute ("""MarketRun.executionType"""))
    val marketApprovalTime: (Context) => String = parse_element (element ("""MarketRun.marketApprovalTime"""))
    val marketApprovedStatus: (Context) => String = parse_element (element ("""MarketRun.marketApprovedStatus"""))
    val marketEndTime: (Context) => String = parse_element (element ("""MarketRun.marketEndTime"""))
    val marketID: (Context) => String = parse_element (element ("""MarketRun.marketID"""))
    val marketRunID: (Context) => String = parse_element (element ("""MarketRun.marketRunID"""))
    val marketStartTime: (Context) => String = parse_element (element ("""MarketRun.marketStartTime"""))
    val marketType: (Context) => String = parse_attribute (attribute ("""MarketRun.marketType"""))
    val reportedState: (Context) => String = parse_element (element ("""MarketRun.reportedState"""))
    val runState: (Context) => String = parse_element (element ("""MarketRun.runState"""))
    val Market: (Context) => String = parse_attribute (attribute ("""MarketRun.Market"""))
    val PlannedMarket: (Context) => String = parse_attribute (attribute ("""MarketRun.PlannedMarket"""))
    def parse (context: Context): MarketRun =
    {
        MarketRun(
            BasicElement.parse (context),
            executionType (context),
            marketApprovalTime (context),
            toBoolean (marketApprovedStatus (context), context),
            marketEndTime (context),
            marketID (context),
            marketRunID (context),
            marketStartTime (context),
            marketType (context),
            reportedState (context),
            runState (context),
            Market (context),
            PlannedMarket (context)
        )
    }
}

/**
 * Represent a planned market.
 * For example an planned DA/HA/RT market.
 * @param sup Reference to the superclass object.
 * @param marketEndTime Market end time.
 * @param marketID An identification that defines the attributes of the Market.
 *        In todays terms: Market Type: DA, RTM, Trade Date:  1/25/04, Trade Hour: 1-25.
 * @param marketStartTime Market start time.
 * @param marketType Market type.
 * @param MarketPlan a market plan has a number of markets (DA, HA, RT)
 */
case class PlannedMarket
(
    override val sup: BasicElement,
    marketEndTime: String,
    marketID: String,
    marketStartTime: String,
    marketType: String,
    MarketPlan: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[PlannedMarket] }
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
        (if (null != marketEndTime) "\t\t<cim:PlannedMarket.marketEndTime>" + marketEndTime + "</cim:PlannedMarket.marketEndTime>\n" else "") +
        (if (null != marketID) "\t\t<cim:PlannedMarket.marketID>" + marketID + "</cim:PlannedMarket.marketID>\n" else "") +
        (if (null != marketStartTime) "\t\t<cim:PlannedMarket.marketStartTime>" + marketStartTime + "</cim:PlannedMarket.marketStartTime>\n" else "") +
        (if (null != marketType) "\t\t<cim:PlannedMarket.marketType rdf:resource=\"#" + marketType + "\"/>\n" else "") +
        (if (null != MarketPlan) "\t\t<cim:PlannedMarket.MarketPlan rdf:resource=\"#" + MarketPlan + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:PlannedMarket rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PlannedMarket>"
    }
}

object PlannedMarket
extends
    Parseable[PlannedMarket]
{
    val marketEndTime: (Context) => String = parse_element (element ("""PlannedMarket.marketEndTime"""))
    val marketID: (Context) => String = parse_element (element ("""PlannedMarket.marketID"""))
    val marketStartTime: (Context) => String = parse_element (element ("""PlannedMarket.marketStartTime"""))
    val marketType: (Context) => String = parse_attribute (attribute ("""PlannedMarket.marketType"""))
    val MarketPlan: (Context) => String = parse_attribute (attribute ("""PlannedMarket.MarketPlan"""))
    def parse (context: Context): PlannedMarket =
    {
        PlannedMarket(
            BasicElement.parse (context),
            marketEndTime (context),
            marketID (context),
            marketStartTime (context),
            marketType (context),
            MarketPlan (context)
        )
    }
}

/**
 * This class represents planned events.
 * Used to model the various planned events in a market (closing time, clearing time, etc).
 * @param sup Reference to the superclass object.
 * @param description Description of the planned event.
 * @param eventType Planned event type.
 * @param plannedEventID Planned event identifier.
 * @param plannedTime This is relative time so that this attribute can be used by more than one planned market.
 *        For example the bid submission is 10am everyday.
 */
case class PlannedMarketEvent
(
    override val sup: BasicElement,
    description: String,
    eventType: String,
    plannedEventID: String,
    plannedTime: Int
)
extends
    Element
{
    def this () = { this (null, null, null, null, 0) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[PlannedMarketEvent] }
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
        (if (null != description) "\t\t<cim:PlannedMarketEvent.description>" + description + "</cim:PlannedMarketEvent.description>\n" else "") +
        (if (null != eventType) "\t\t<cim:PlannedMarketEvent.eventType>" + eventType + "</cim:PlannedMarketEvent.eventType>\n" else "") +
        (if (null != plannedEventID) "\t\t<cim:PlannedMarketEvent.plannedEventID>" + plannedEventID + "</cim:PlannedMarketEvent.plannedEventID>\n" else "") +
        "\t\t<cim:PlannedMarketEvent.plannedTime>" + plannedTime + "</cim:PlannedMarketEvent.plannedTime>\n"
    }
    override def export: String =
    {
        "\t<cim:PlannedMarketEvent rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PlannedMarketEvent>"
    }
}

object PlannedMarketEvent
extends
    Parseable[PlannedMarketEvent]
{
    val description: (Context) => String = parse_element (element ("""PlannedMarketEvent.description"""))
    val eventType: (Context) => String = parse_element (element ("""PlannedMarketEvent.eventType"""))
    val plannedEventID: (Context) => String = parse_element (element ("""PlannedMarketEvent.plannedEventID"""))
    val plannedTime: (Context) => String = parse_element (element ("""PlannedMarketEvent.plannedTime"""))
    def parse (context: Context): PlannedMarketEvent =
    {
        PlannedMarketEvent(
            BasicElement.parse (context),
            description (context),
            eventType (context),
            plannedEventID (context),
            toInteger (plannedTime (context), context)
        )
    }
}

private[ninecode] object _MarketPlan
{
    def register: List[ClassInfo] =
    {
        List (
            CRRMarket.register,
            EnergyMarket.register,
            Market.register,
            MarketActualEvent.register,
            MarketFactors.register,
            MarketPlan.register,
            MarketProduct.register,
            MarketRun.register,
            PlannedMarket.register,
            PlannedMarketEvent.register
        )
    }
}