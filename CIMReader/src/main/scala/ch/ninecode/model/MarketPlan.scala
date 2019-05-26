package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Model that describes the Congestion Revenue Rights Auction Market.
 *
 * @param sup [[ch.ninecode.model.Market Market]] Reference to the superclass object.
 * @param labelID labelID - an ID for a set of apnodes/pnodes used in a CRR market
 * @param CongestionRevenueRight [[ch.ninecode.model.CongestionRevenueRight CongestionRevenueRight]] <em>undocumented</em>
 * @group MarketPlan
 * @groupname MarketPlan Package MarketPlan
 * @groupdesc MarketPlan Market plan definitions for planned markets, planned market events, actual market runs, actual market events.
 */
case class CRRMarket
(
    override val sup: Market,
    labelID: String,
    CongestionRevenueRight: List[String]
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CRRMarket.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CRRMarket.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (CRRMarket.fields (position), x))
        emitelem (0, labelID)
        emitattrs (1, CongestionRevenueRight)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CRRMarket rdf:ID=\"%s\">\n%s\t</cim:CRRMarket>".format (id, export_fields)
    }
}

object CRRMarket
extends
    Parseable[CRRMarket]
{
    override val fields: Array[String] = Array[String] (
        "labelID",
        "CongestionRevenueRight"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CongestionRevenueRight", "CongestionRevenueRight", "1..*", "1")
    )
    val labelID: Fielder = parse_element (element (cls, fields(0)))
    val CongestionRevenueRight: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): CRRMarket =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = CRRMarket (
            Market.parse (context),
            mask (labelID (), 0),
            masks (CongestionRevenueRight (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Commodities in the context of IEC 62325 are MarketProducts (energy, regulation, reserve, etc) traded at a specific location, which in this case is a Pnode (either a specific pricing node or a pricing area or zone defined as a collection of pricing nodes).
 *
 * The CommodityDefinition is a container for these two parameters, plus the unit of measure and the currency in which the Commodity is traded.  Each CommodityDefinition should be relatively static; defined once and rarely changed.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param commodityCurrency The currency in which the Commodity is traded, using the standard conventions associated with the Currency enumeration.
 * @param commodityUnit The unit of measure in which the Commodity is traded, using the standard conventions associated with the UnitSymbol enumeration.
 * @param commodityUnitMultiplier The unit multiplier, e.g. "k" to convert the unit "W-h" to "kW-h", using the standard conventions associated with the UnitMultiplier enumeration.
 * @param CommodityPrice [[ch.ninecode.model.CommodityPrice CommodityPrice]] <em>undocumented</em>
 * @param MarketProduct [[ch.ninecode.model.MarketProduct MarketProduct]] <em>undocumented</em>
 * @param Pnode [[ch.ninecode.model.Pnode Pnode]] <em>undocumented</em>
 * @param RTO [[ch.ninecode.model.RTO RTO]] <em>undocumented</em>
 * @group MarketPlan
 * @groupname MarketPlan Package MarketPlan
 * @groupdesc MarketPlan Market plan definitions for planned markets, planned market events, actual market runs, actual market events.
 */
case class CommodityDefinition
(
    override val sup: IdentifiedObject,
    commodityCurrency: String,
    commodityUnit: String,
    commodityUnitMultiplier: String,
    CommodityPrice: List[String],
    MarketProduct: String,
    Pnode: String,
    RTO: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, List(), null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[CommodityDefinition] }
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
        implicit val clz: String = CommodityDefinition.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CommodityDefinition.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (CommodityDefinition.fields (position), x))
        emitattr (0, commodityCurrency)
        emitattr (1, commodityUnit)
        emitattr (2, commodityUnitMultiplier)
        emitattrs (3, CommodityPrice)
        emitattr (4, MarketProduct)
        emitattr (5, Pnode)
        emitattr (6, RTO)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CommodityDefinition rdf:ID=\"%s\">\n%s\t</cim:CommodityDefinition>".format (id, export_fields)
    }
}

object CommodityDefinition
extends
    Parseable[CommodityDefinition]
{
    override val fields: Array[String] = Array[String] (
        "commodityCurrency",
        "commodityUnit",
        "commodityUnitMultiplier",
        "CommodityPrice",
        "MarketProduct",
        "Pnode",
        "RTO"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CommodityPrice", "CommodityPrice", "1..*", "1"),
        Relationship ("MarketProduct", "MarketProduct", "1", "0..*"),
        Relationship ("Pnode", "Pnode", "1", "0..*"),
        Relationship ("RTO", "RTO", "1", "0..*")
    )
    val commodityCurrency: Fielder = parse_attribute (attribute (cls, fields(0)))
    val commodityUnit: Fielder = parse_attribute (attribute (cls, fields(1)))
    val commodityUnitMultiplier: Fielder = parse_attribute (attribute (cls, fields(2)))
    val CommodityPrice: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val MarketProduct: Fielder = parse_attribute (attribute (cls, fields(4)))
    val Pnode: Fielder = parse_attribute (attribute (cls, fields(5)))
    val RTO: Fielder = parse_attribute (attribute (cls, fields(6)))

    def parse (context: Context): CommodityDefinition =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = CommodityDefinition (
            IdentifiedObject.parse (context),
            mask (commodityCurrency (), 0),
            mask (commodityUnit (), 1),
            mask (commodityUnitMultiplier (), 2),
            masks (CommodityPrice (), 3),
            mask (MarketProduct (), 4),
            mask (Pnode (), 5),
            mask (RTO (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A demand response event is created when there is a need to call upon resources to respond to demand adjustment requests.
 *
 * These events are created by ISO/RTO system operations and managed  by a demand response management system (DRMS). These events may or may not be coordinated with the Market Events and a defined Energy Market. The event will call for the deployment of a number of registered resources, or for deployment of resources within a zone (an organizational area within the power system that contains a number of resources).
 *
 * @param sup [[ch.ninecode.model.MarketActualEvent MarketActualEvent]] Reference to the superclass object.
 * @param totalPowerAdjustment Total active power adjustment (e.g. load reduction) requested for this demand response event.
 * @param InstructionClearing [[ch.ninecode.model.InstructionClearing InstructionClearing]] ActualDemandResponseEvents may exist that are not part of a coordinated MarketActualEvent associated to a Market.
 *        These ActualDemandResponseEvents can have many InstructionClearing Instructions for specified RegisteredResources or DemandResponse AggregateNodes.
 * @param InstructionClearingDOT [[ch.ninecode.model.InstructionClearingDOT InstructionClearingDOT]] <em>undocumented</em>
 * @param ResourcePerformanceEvaluations [[ch.ninecode.model.ResourcePerformanceEvaluation ResourcePerformanceEvaluation]] <em>undocumented</em>
 * @group MarketPlan
 * @groupname MarketPlan Package MarketPlan
 * @groupdesc MarketPlan Market plan definitions for planned markets, planned market events, actual market runs, actual market events.
 */
case class DistributedResourceActualEvent
(
    override val sup: MarketActualEvent,
    totalPowerAdjustment: Double,
    InstructionClearing: List[String],
    InstructionClearingDOT: List[String],
    ResourcePerformanceEvaluations: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, List(), List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def MarketActualEvent: MarketActualEvent = sup.asInstanceOf[MarketActualEvent]
    override def copy (): Row = { clone ().asInstanceOf[DistributedResourceActualEvent] }
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
        implicit val clz: String = DistributedResourceActualEvent.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DistributedResourceActualEvent.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (DistributedResourceActualEvent.fields (position), x))
        emitelem (0, totalPowerAdjustment)
        emitattrs (1, InstructionClearing)
        emitattrs (2, InstructionClearingDOT)
        emitattrs (3, ResourcePerformanceEvaluations)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DistributedResourceActualEvent rdf:ID=\"%s\">\n%s\t</cim:DistributedResourceActualEvent>".format (id, export_fields)
    }
}

object DistributedResourceActualEvent
extends
    Parseable[DistributedResourceActualEvent]
{
    override val fields: Array[String] = Array[String] (
        "totalPowerAdjustment",
        "InstructionClearing",
        "InstructionClearingDOT",
        "ResourcePerformanceEvaluations"
    )
    override val relations: List[Relationship] = List (
        Relationship ("InstructionClearing", "InstructionClearing", "0..*", "0..1"),
        Relationship ("InstructionClearingDOT", "InstructionClearingDOT", "0..*", "0..1"),
        Relationship ("ResourcePerformanceEvaluations", "ResourcePerformanceEvaluation", "0..*", "1")
    )
    val totalPowerAdjustment: Fielder = parse_element (element (cls, fields(0)))
    val InstructionClearing: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val InstructionClearingDOT: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val ResourcePerformanceEvaluations: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: Context): DistributedResourceActualEvent =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = DistributedResourceActualEvent (
            MarketActualEvent.parse (context),
            toDouble (mask (totalPowerAdjustment (), 0)),
            masks (InstructionClearing (), 1),
            masks (InstructionClearingDOT (), 2),
            masks (ResourcePerformanceEvaluations (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Energy and Ancillary Market (e.g.
 *
 * Energy, Spinning Reserve, Non-Spinning Reserve) with a description of the Market operation control parameters.
 *
 * @param sup [[ch.ninecode.model.Market Market]] Reference to the superclass object.
 * @param Bids [[ch.ninecode.model.Bid Bid]] <em>undocumented</em>
 * @param MarketResults [[ch.ninecode.model.MarketResults MarketResults]] <em>undocumented</em>
 * @param RTO [[ch.ninecode.model.RTO RTO]] <em>undocumented</em>
 * @param RegisteredResources [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @param Settlements [[ch.ninecode.model.Settlement Settlement]] <em>undocumented</em>
 * @group MarketPlan
 * @groupname MarketPlan Package MarketPlan
 * @groupdesc MarketPlan Market plan definitions for planned markets, planned market events, actual market runs, actual market events.
 */
case class EnergyMarket
(
    override val sup: Market,
    Bids: List[String],
    MarketResults: String,
    RTO: String,
    RegisteredResources: List[String],
    Settlements: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List(), null, null, List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = EnergyMarket.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EnergyMarket.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (EnergyMarket.fields (position), x))
        emitattrs (0, Bids)
        emitattr (1, MarketResults)
        emitattr (2, RTO)
        emitattrs (3, RegisteredResources)
        emitattrs (4, Settlements)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EnergyMarket rdf:ID=\"%s\">\n%s\t</cim:EnergyMarket>".format (id, export_fields)
    }
}

object EnergyMarket
extends
    Parseable[EnergyMarket]
{
    override val fields: Array[String] = Array[String] (
        "Bids",
        "MarketResults",
        "RTO",
        "RegisteredResources",
        "Settlements"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Bids", "Bid", "0..*", "1"),
        Relationship ("MarketResults", "MarketResults", "0..1", "1"),
        Relationship ("RTO", "RTO", "0..1", "0..*"),
        Relationship ("RegisteredResources", "RegisteredResource", "0..*", "0..*"),
        Relationship ("Settlements", "Settlement", "0..*", "0..1")
    )
    val Bids: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val MarketResults: Fielder = parse_attribute (attribute (cls, fields(1)))
    val RTO: Fielder = parse_attribute (attribute (cls, fields(2)))
    val RegisteredResources: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val Settlements: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: Context): EnergyMarket =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = EnergyMarket (
            Market.parse (context),
            masks (Bids (), 0),
            mask (MarketResults (), 1),
            mask (RTO (), 2),
            masks (RegisteredResources (), 3),
            masks (Settlements (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Market (e.g.
 *
 * Day Ahead Market, Real Time Market) with a description of the Market operation control parameters.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
 *        Day
 *        Hour
 *        
 *        For a CRR Market:
 *        Year
 *        Month
 *        Season
 * @param MarketFactors [[ch.ninecode.model.MarketFactors MarketFactors]] <em>undocumented</em>
 * @param MarketProducts [[ch.ninecode.model.MarketProduct MarketProduct]] <em>undocumented</em>
 * @param MarketRun [[ch.ninecode.model.MarketRun MarketRun]] <em>undocumented</em>
 * @group MarketPlan
 * @groupname MarketPlan Package MarketPlan
 * @groupdesc MarketPlan Market plan definitions for planned markets, planned market events, actual market runs, actual market events.
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
    tradingPeriod: String,
    MarketFactors: List[String],
    MarketProducts: List[String],
    MarketRun: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, false, null, null, null, null, 0.0, null, null, List(), List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Market.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Market.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (Market.fields (position), x))
        emitelem (0, actualEnd)
        emitelem (1, actualStart)
        emitelem (2, dst)
        emitelem (3, end)
        emitelem (4, localTimeZone)
        emitelem (5, start)
        emitelem (6, status)
        emitelem (7, timeIntervalLength)
        emitelem (8, tradingDay)
        emitelem (9, tradingPeriod)
        emitattrs (10, MarketFactors)
        emitattrs (11, MarketProducts)
        emitattrs (12, MarketRun)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Market rdf:ID=\"%s\">\n%s\t</cim:Market>".format (id, export_fields)
    }
}

object Market
extends
    Parseable[Market]
{
    override val fields: Array[String] = Array[String] (
        "actualEnd",
        "actualStart",
        "dst",
        "end",
        "localTimeZone",
        "start",
        "status",
        "timeIntervalLength",
        "tradingDay",
        "tradingPeriod",
        "MarketFactors",
        "MarketProducts",
        "MarketRun"
    )
    override val relations: List[Relationship] = List (
        Relationship ("MarketFactors", "MarketFactors", "0..*", "0..1"),
        Relationship ("MarketProducts", "MarketProduct", "1..*", "0..1"),
        Relationship ("MarketRun", "MarketRun", "0..*", "1")
    )
    val actualEnd: Fielder = parse_element (element (cls, fields(0)))
    val actualStart: Fielder = parse_element (element (cls, fields(1)))
    val dst: Fielder = parse_element (element (cls, fields(2)))
    val end: Fielder = parse_element (element (cls, fields(3)))
    val localTimeZone: Fielder = parse_element (element (cls, fields(4)))
    val start: Fielder = parse_element (element (cls, fields(5)))
    val status: Fielder = parse_element (element (cls, fields(6)))
    val timeIntervalLength: Fielder = parse_element (element (cls, fields(7)))
    val tradingDay: Fielder = parse_element (element (cls, fields(8)))
    val tradingPeriod: Fielder = parse_element (element (cls, fields(9)))
    val MarketFactors: FielderMultiple = parse_attributes (attribute (cls, fields(10)))
    val MarketProducts: FielderMultiple = parse_attributes (attribute (cls, fields(11)))
    val MarketRun: FielderMultiple = parse_attributes (attribute (cls, fields(12)))

    def parse (context: Context): Market =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Market (
            IdentifiedObject.parse (context),
            mask (actualEnd (), 0),
            mask (actualStart (), 1),
            toBoolean (mask (dst (), 2)),
            mask (end (), 3),
            mask (localTimeZone (), 4),
            mask (start (), 5),
            mask (status (), 6),
            toDouble (mask (timeIntervalLength (), 7)),
            mask (tradingDay (), 8),
            mask (tradingPeriod (), 9),
            masks (MarketFactors (), 10),
            masks (MarketProducts (), 11),
            masks (MarketRun (), 12)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * This class represents the actual instance of an event.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param eventComments Free format comments for the event, for any purpose needed.
 * @param eventEndTime End time of the event.
 * @param eventStartTime Start time of the event.
 * @param eventStatus Event status, e.g. active, canceled, expired, etc.
 * @param eventType Actual event type.
 * @param MarketRun [[ch.ninecode.model.MarketRun MarketRun]] Market run triggered by this actual event.
 *        For example, the DA market run is triggered by the actual open bid submission event and terminated by the actual execution and completion of the DA market run captured by the runState of the MarketRun.
 * @param PlannedMarketEvent [[ch.ninecode.model.PlannedMarketEvent PlannedMarketEvent]] Planned event executed by this actual event.
 * @group MarketPlan
 * @groupname MarketPlan Package MarketPlan
 * @groupdesc MarketPlan Market plan definitions for planned markets, planned market events, actual market runs, actual market events.
 */
case class MarketActualEvent
(
    override val sup: IdentifiedObject,
    eventComments: String,
    eventEndTime: String,
    eventStartTime: String,
    eventStatus: String,
    eventType: String,
    MarketRun: String,
    PlannedMarketEvent: String
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
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MarketActualEvent.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MarketActualEvent.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MarketActualEvent.fields (position), value)
        emitelem (0, eventComments)
        emitelem (1, eventEndTime)
        emitelem (2, eventStartTime)
        emitattr (3, eventStatus)
        emitelem (4, eventType)
        emitattr (5, MarketRun)
        emitattr (6, PlannedMarketEvent)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MarketActualEvent rdf:ID=\"%s\">\n%s\t</cim:MarketActualEvent>".format (id, export_fields)
    }
}

object MarketActualEvent
extends
    Parseable[MarketActualEvent]
{
    override val fields: Array[String] = Array[String] (
        "eventComments",
        "eventEndTime",
        "eventStartTime",
        "eventStatus",
        "eventType",
        "MarketRun",
        "PlannedMarketEvent"
    )
    override val relations: List[Relationship] = List (
        Relationship ("MarketRun", "MarketRun", "0..1", "1..*"),
        Relationship ("PlannedMarketEvent", "PlannedMarketEvent", "0..1", "1..*")
    )
    val eventComments: Fielder = parse_element (element (cls, fields(0)))
    val eventEndTime: Fielder = parse_element (element (cls, fields(1)))
    val eventStartTime: Fielder = parse_element (element (cls, fields(2)))
    val eventStatus: Fielder = parse_attribute (attribute (cls, fields(3)))
    val eventType: Fielder = parse_element (element (cls, fields(4)))
    val MarketRun: Fielder = parse_attribute (attribute (cls, fields(5)))
    val PlannedMarketEvent: Fielder = parse_attribute (attribute (cls, fields(6)))

    def parse (context: Context): MarketActualEvent =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MarketActualEvent (
            IdentifiedObject.parse (context),
            mask (eventComments (), 0),
            mask (eventEndTime (), 1),
            mask (eventStartTime (), 2),
            mask (eventStatus (), 3),
            mask (eventType (), 4),
            mask (MarketRun (), 5),
            mask (PlannedMarketEvent (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Aggregation of market information relative for a specific time interval.
 *
 * @param sup [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param intervalEndTime The end of the time interval for which requirement is defined.
 * @param intervalStartTime The start of the time interval for which requirement is defined.
 * @param Market [[ch.ninecode.model.Market Market]] <em>undocumented</em>
 * @param MktActivityRecord [[ch.ninecode.model.MktActivityRecord MktActivityRecord]] <em>undocumented</em>
 * @group MarketPlan
 * @groupname MarketPlan Package MarketPlan
 * @groupdesc MarketPlan Market plan definitions for planned markets, planned market events, actual market runs, actual market events.
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
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MarketFactors.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MarketFactors.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MarketFactors.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (MarketFactors.fields (position), x))
        emitelem (0, intervalEndTime)
        emitelem (1, intervalStartTime)
        emitattr (2, Market)
        emitattrs (3, MktActivityRecord)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MarketFactors rdf:ID=\"%s\">\n%s\t</cim:MarketFactors>".format (id, export_fields)
    }
}

object MarketFactors
extends
    Parseable[MarketFactors]
{
    override val fields: Array[String] = Array[String] (
        "intervalEndTime",
        "intervalStartTime",
        "Market",
        "MktActivityRecord"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Market", "Market", "0..1", "0..*"),
        Relationship ("MktActivityRecord", "MktActivityRecord", "0..*", "0..*")
    )
    val intervalEndTime: Fielder = parse_element (element (cls, fields(0)))
    val intervalStartTime: Fielder = parse_element (element (cls, fields(1)))
    val Market: Fielder = parse_attribute (attribute (cls, fields(2)))
    val MktActivityRecord: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: Context): MarketFactors =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MarketFactors (
            Document.parse (context),
            mask (intervalEndTime (), 0),
            mask (intervalStartTime (), 1),
            mask (Market (), 2),
            masks (MktActivityRecord (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * This class identifies a set of planned markets.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param tradingDay Planned market trading day.
 * @param PlannedMarket [[ch.ninecode.model.PlannedMarket PlannedMarket]] A market plan has a number of markets (DA, HA, RT).
 * @group MarketPlan
 * @groupname MarketPlan Package MarketPlan
 * @groupdesc MarketPlan Market plan definitions for planned markets, planned market events, actual market runs, actual market events.
 */
case class MarketPlan
(
    override val sup: IdentifiedObject,
    tradingDay: String,
    PlannedMarket: List[String]
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
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MarketPlan.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MarketPlan.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (MarketPlan.fields (position), x))
        emitelem (0, tradingDay)
        emitattrs (1, PlannedMarket)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MarketPlan rdf:ID=\"%s\">\n%s\t</cim:MarketPlan>".format (id, export_fields)
    }
}

object MarketPlan
extends
    Parseable[MarketPlan]
{
    override val fields: Array[String] = Array[String] (
        "tradingDay",
        "PlannedMarket"
    )
    override val relations: List[Relationship] = List (
        Relationship ("PlannedMarket", "PlannedMarket", "1..*", "1")
    )
    val tradingDay: Fielder = parse_element (element (cls, fields(0)))
    val PlannedMarket: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): MarketPlan =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MarketPlan (
            IdentifiedObject.parse (context),
            mask (tradingDay (), 0),
            masks (PlannedMarket (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A product traded by an RTO (e.g. energy, 10 minute spinning reserve).
 *
 * Ancillary service product examples include: Regulation, Regulation Up, Regulation Down, Spinning Reserve, Non-Spinning Reserve, etc.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param marketProductType Market product type examples:
 *        
 *        EN (Energy)
 *        RU (Regulation Up)
 *        RD (Regulation Dn)
 *        SR (Spinning Reserve)
 *        NR (Non-Spinning Reserve)
 *        RC (RUC)
 * @param rampInterval Ramping time interval for the specific market product type specified by marketProductType attribute.
 *        For example, if marketProductType = EN (from enumeration MarketProductType), then the rampInterval is the ramping time interval for Energy.
 * @param BidError [[ch.ninecode.model.BidError BidError]] <em>undocumented</em>
 * @param BidPriceCap [[ch.ninecode.model.BidPriceCap BidPriceCap]] <em>undocumented</em>
 * @param CommodityDefinition [[ch.ninecode.model.CommodityDefinition CommodityDefinition]] <em>undocumented</em>
 * @param Market [[ch.ninecode.model.Market Market]] <em>undocumented</em>
 * @param MarketRegionResults [[ch.ninecode.model.MarketRegionResults MarketRegionResults]] <em>undocumented</em>
 * @param ProductBids [[ch.ninecode.model.ProductBid ProductBid]] <em>undocumented</em>
 * @param ReserveReqs [[ch.ninecode.model.ReserveReq ReserveReq]] Market product associated with reserve requirement must be a reserve or regulation product.
 * @param ResourceAwardInstruction [[ch.ninecode.model.ResourceAwardInstruction ResourceAwardInstruction]] <em>undocumented</em>
 * @group MarketPlan
 * @groupname MarketPlan Package MarketPlan
 * @groupdesc MarketPlan Market plan definitions for planned markets, planned market events, actual market runs, actual market events.
 */
case class MarketProduct
(
    override val sup: IdentifiedObject,
    marketProductType: String,
    rampInterval: Double,
    BidError: List[String],
    BidPriceCap: List[String],
    CommodityDefinition: List[String],
    Market: String,
    MarketRegionResults: String,
    ProductBids: List[String],
    ReserveReqs: List[String],
    ResourceAwardInstruction: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, List(), List(), List(), null, null, List(), List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MarketProduct.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MarketProduct.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MarketProduct.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (MarketProduct.fields (position), x))
        emitattr (0, marketProductType)
        emitelem (1, rampInterval)
        emitattrs (2, BidError)
        emitattrs (3, BidPriceCap)
        emitattrs (4, CommodityDefinition)
        emitattr (5, Market)
        emitattr (6, MarketRegionResults)
        emitattrs (7, ProductBids)
        emitattrs (8, ReserveReqs)
        emitattrs (9, ResourceAwardInstruction)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MarketProduct rdf:ID=\"%s\">\n%s\t</cim:MarketProduct>".format (id, export_fields)
    }
}

object MarketProduct
extends
    Parseable[MarketProduct]
{
    override val fields: Array[String] = Array[String] (
        "marketProductType",
        "rampInterval",
        "BidError",
        "BidPriceCap",
        "CommodityDefinition",
        "Market",
        "MarketRegionResults",
        "ProductBids",
        "ReserveReqs",
        "ResourceAwardInstruction"
    )
    override val relations: List[Relationship] = List (
        Relationship ("BidError", "BidError", "0..*", "0..1"),
        Relationship ("BidPriceCap", "BidPriceCap", "0..*", "0..1"),
        Relationship ("CommodityDefinition", "CommodityDefinition", "0..*", "1"),
        Relationship ("Market", "Market", "0..1", "1..*"),
        Relationship ("MarketRegionResults", "MarketRegionResults", "0..1", "0..1"),
        Relationship ("ProductBids", "ProductBid", "0..*", "1"),
        Relationship ("ReserveReqs", "ReserveReq", "0..*", "1"),
        Relationship ("ResourceAwardInstruction", "ResourceAwardInstruction", "0..*", "1")
    )
    val marketProductType: Fielder = parse_attribute (attribute (cls, fields(0)))
    val rampInterval: Fielder = parse_element (element (cls, fields(1)))
    val BidError: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val BidPriceCap: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val CommodityDefinition: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val Market: Fielder = parse_attribute (attribute (cls, fields(5)))
    val MarketRegionResults: Fielder = parse_attribute (attribute (cls, fields(6)))
    val ProductBids: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val ReserveReqs: FielderMultiple = parse_attributes (attribute (cls, fields(8)))
    val ResourceAwardInstruction: FielderMultiple = parse_attributes (attribute (cls, fields(9)))

    def parse (context: Context): MarketProduct =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MarketProduct (
            IdentifiedObject.parse (context),
            mask (marketProductType (), 0),
            toDouble (mask (rampInterval (), 1)),
            masks (BidError (), 2),
            masks (BidPriceCap (), 3),
            masks (CommodityDefinition (), 4),
            mask (Market (), 5),
            mask (MarketRegionResults (), 6),
            masks (ProductBids (), 7),
            masks (ReserveReqs (), 8),
            masks (ResourceAwardInstruction (), 9)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * This class represents an actual instance of a planned market.
 *
 * For example, a Day Ahead market opens with the Bid Submission, ends with the closing of the Bid Submission. The market run represent the whole process. MarketRuns can be defined for markets such as Day Ahead Market, Real Time Market, Hour Ahead Market, Week Ahead Market, etc.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param executionType The execution type; Day Ahead, Intra Day, Real Time Pre-Dispatch, Real Time Dispatch
 * @param marketApprovalTime Approved time for case.
 *        Identifies the time that the dispatcher approved a specific real time unit dispatch case
 * @param marketApprovedStatus Set to true when the plan is approved by authority and becomes the official plan for the day ahead market.
 *        Identifies the approved case for the market for the specified time interval.
 * @param marketEndTime The end time defined as the end of the market, market end time.
 * @param marketStartTime The start time defined as the beginning of the market, market start time.
 * @param marketType The market type, Day Ahead Market or Real Time Market.
 * @param reportedState This is the state of market run activity as reported by market systems to the market definition services.
 * @param runState This is the state controlled by market defintion service.
 *        Possible values could be but not limited by: Open, Close.
 * @param Market [[ch.ninecode.model.Market Market]] <em>undocumented</em>
 * @param MarketActualEvent [[ch.ninecode.model.MarketActualEvent MarketActualEvent]] All actual events that trigger this market run.
 * @param PlannedMarket [[ch.ninecode.model.PlannedMarket PlannedMarket]] A planned market could have multiple market runs for the reason that a planned market could have a rerun.
 * @group MarketPlan
 * @groupname MarketPlan Package MarketPlan
 * @groupdesc MarketPlan Market plan definitions for planned markets, planned market events, actual market runs, actual market events.
 */
case class MarketRun
(
    override val sup: IdentifiedObject,
    executionType: String,
    marketApprovalTime: String,
    marketApprovedStatus: Boolean,
    marketEndTime: String,
    marketStartTime: String,
    marketType: String,
    reportedState: String,
    runState: String,
    Market: String,
    MarketActualEvent: List[String],
    PlannedMarket: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, false, null, null, null, null, null, null, List(), null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MarketRun.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MarketRun.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MarketRun.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (MarketRun.fields (position), x))
        emitattr (0, executionType)
        emitelem (1, marketApprovalTime)
        emitelem (2, marketApprovedStatus)
        emitelem (3, marketEndTime)
        emitelem (4, marketStartTime)
        emitattr (5, marketType)
        emitelem (6, reportedState)
        emitelem (7, runState)
        emitattr (8, Market)
        emitattrs (9, MarketActualEvent)
        emitattr (10, PlannedMarket)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MarketRun rdf:ID=\"%s\">\n%s\t</cim:MarketRun>".format (id, export_fields)
    }
}

object MarketRun
extends
    Parseable[MarketRun]
{
    override val fields: Array[String] = Array[String] (
        "executionType",
        "marketApprovalTime",
        "marketApprovedStatus",
        "marketEndTime",
        "marketStartTime",
        "marketType",
        "reportedState",
        "runState",
        "Market",
        "MarketActualEvent",
        "PlannedMarket"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Market", "Market", "1", "0..*"),
        Relationship ("MarketActualEvent", "MarketActualEvent", "1..*", "0..1"),
        Relationship ("PlannedMarket", "PlannedMarket", "1", "0..*")
    )
    val executionType: Fielder = parse_attribute (attribute (cls, fields(0)))
    val marketApprovalTime: Fielder = parse_element (element (cls, fields(1)))
    val marketApprovedStatus: Fielder = parse_element (element (cls, fields(2)))
    val marketEndTime: Fielder = parse_element (element (cls, fields(3)))
    val marketStartTime: Fielder = parse_element (element (cls, fields(4)))
    val marketType: Fielder = parse_attribute (attribute (cls, fields(5)))
    val reportedState: Fielder = parse_element (element (cls, fields(6)))
    val runState: Fielder = parse_element (element (cls, fields(7)))
    val Market: Fielder = parse_attribute (attribute (cls, fields(8)))
    val MarketActualEvent: FielderMultiple = parse_attributes (attribute (cls, fields(9)))
    val PlannedMarket: Fielder = parse_attribute (attribute (cls, fields(10)))

    def parse (context: Context): MarketRun =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MarketRun (
            IdentifiedObject.parse (context),
            mask (executionType (), 0),
            mask (marketApprovalTime (), 1),
            toBoolean (mask (marketApprovedStatus (), 2)),
            mask (marketEndTime (), 3),
            mask (marketStartTime (), 4),
            mask (marketType (), 5),
            mask (reportedState (), 6),
            mask (runState (), 7),
            mask (Market (), 8),
            masks (MarketActualEvent (), 9),
            mask (PlannedMarket (), 10)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Represent a planned market.
 *
 * For example a planned DA/HA/RT market.
 *
 * @param sup Reference to the superclass object.
 * @param marketEndTime Market end time.
 * @param marketStartTime Market start time.
 * @param marketType Market type.
 * @param MarketPlan [[ch.ninecode.model.MarketPlan MarketPlan]] A market plan has a number of markets (DA, HA, RT).
 * @param MarketRun [[ch.ninecode.model.MarketRun MarketRun]] A planned market could have multiple market runs for the reason that a planned market could have a rerun.
 * @param PlannedMarketEvent [[ch.ninecode.model.PlannedMarketEvent PlannedMarketEvent]] A planned market shall have a set of planned events
 * @group MarketPlan
 * @groupname MarketPlan Package MarketPlan
 * @groupdesc MarketPlan Market plan definitions for planned markets, planned market events, actual market runs, actual market events.
 */
case class PlannedMarket
(
    override val sup: BasicElement,
    marketEndTime: String,
    marketStartTime: String,
    marketType: String,
    MarketPlan: String,
    MarketRun: List[String],
    PlannedMarketEvent: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PlannedMarket.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PlannedMarket.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PlannedMarket.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (PlannedMarket.fields (position), x))
        emitelem (0, marketEndTime)
        emitelem (1, marketStartTime)
        emitattr (2, marketType)
        emitattr (3, MarketPlan)
        emitattrs (4, MarketRun)
        emitattrs (5, PlannedMarketEvent)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PlannedMarket rdf:ID=\"%s\">\n%s\t</cim:PlannedMarket>".format (id, export_fields)
    }
}

object PlannedMarket
extends
    Parseable[PlannedMarket]
{
    override val fields: Array[String] = Array[String] (
        "marketEndTime",
        "marketStartTime",
        "marketType",
        "MarketPlan",
        "MarketRun",
        "PlannedMarketEvent"
    )
    override val relations: List[Relationship] = List (
        Relationship ("MarketPlan", "MarketPlan", "1", "1..*"),
        Relationship ("MarketRun", "MarketRun", "0..*", "1"),
        Relationship ("PlannedMarketEvent", "PlannedMarketEvent", "1..*", "0..*")
    )
    val marketEndTime: Fielder = parse_element (element (cls, fields(0)))
    val marketStartTime: Fielder = parse_element (element (cls, fields(1)))
    val marketType: Fielder = parse_attribute (attribute (cls, fields(2)))
    val MarketPlan: Fielder = parse_attribute (attribute (cls, fields(3)))
    val MarketRun: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val PlannedMarketEvent: FielderMultiple = parse_attributes (attribute (cls, fields(5)))

    def parse (context: Context): PlannedMarket =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = PlannedMarket (
            BasicElement.parse (context),
            mask (marketEndTime (), 0),
            mask (marketStartTime (), 1),
            mask (marketType (), 2),
            mask (MarketPlan (), 3),
            masks (MarketRun (), 4),
            masks (PlannedMarketEvent (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * This class represents planned events.
 *
 * Used to model the various planned events in a market (closing time, clearing time, etc.)
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param eventType Planned event type.
 * @param plannedTime This is relative time so that this attribute can be used by more than one planned market.
 *        For example the bid submission is 10am everyday.
 * @param MarketActualEvent [[ch.ninecode.model.MarketActualEvent MarketActualEvent]] All actual events that execute this planned event.
 * @param PlannedMarket [[ch.ninecode.model.PlannedMarket PlannedMarket]] A planned market shall have a set of planned events
 * @group MarketPlan
 * @groupname MarketPlan Package MarketPlan
 * @groupdesc MarketPlan Market plan definitions for planned markets, planned market events, actual market runs, actual market events.
 */
case class PlannedMarketEvent
(
    override val sup: IdentifiedObject,
    eventType: String,
    plannedTime: Int,
    MarketActualEvent: List[String],
    PlannedMarket: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0, List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PlannedMarketEvent.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PlannedMarketEvent.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (PlannedMarketEvent.fields (position), x))
        emitelem (0, eventType)
        emitelem (1, plannedTime)
        emitattrs (2, MarketActualEvent)
        emitattrs (3, PlannedMarket)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PlannedMarketEvent rdf:ID=\"%s\">\n%s\t</cim:PlannedMarketEvent>".format (id, export_fields)
    }
}

object PlannedMarketEvent
extends
    Parseable[PlannedMarketEvent]
{
    override val fields: Array[String] = Array[String] (
        "eventType",
        "plannedTime",
        "MarketActualEvent",
        "PlannedMarket"
    )
    override val relations: List[Relationship] = List (
        Relationship ("MarketActualEvent", "MarketActualEvent", "1..*", "0..1"),
        Relationship ("PlannedMarket", "PlannedMarket", "0..*", "1..*")
    )
    val eventType: Fielder = parse_element (element (cls, fields(0)))
    val plannedTime: Fielder = parse_element (element (cls, fields(1)))
    val MarketActualEvent: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val PlannedMarket: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: Context): PlannedMarketEvent =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = PlannedMarketEvent (
            IdentifiedObject.parse (context),
            mask (eventType (), 0),
            toInteger (mask (plannedTime (), 1)),
            masks (MarketActualEvent (), 2),
            masks (PlannedMarket (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _MarketPlan
{
    def register: List[ClassInfo] =
    {
        List (
            CRRMarket.register,
            CommodityDefinition.register,
            DistributedResourceActualEvent.register,
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