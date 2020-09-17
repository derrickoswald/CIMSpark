package ch.ninecode.model

import com.esotericsoftware.kryo.Kryo
import com.esotericsoftware.kryo.Serializer
import com.esotericsoftware.kryo.io.Input
import com.esotericsoftware.kryo.io.Output
import org.apache.spark.sql.Row

import ch.ninecode.cim.CIMClassInfo
import ch.ninecode.cim.CIMContext
import ch.ninecode.cim.CIMParseable
import ch.ninecode.cim.CIMRelationship
import ch.ninecode.cim.CIMSerializer

/**
 * Model that describes the Congestion Revenue Rights Auction Market.
 *
 * @param Market [[ch.ninecode.model.Market Market]] Reference to the superclass object.
 * @param labelID labelID - an ID for a set of apnodes/pnodes used in a CRR market
 * @param CongestionRevenueRight [[ch.ninecode.model.CongestionRevenueRight CongestionRevenueRight]] <em>undocumented</em>
 * @group MarketPlan
 * @groupname MarketPlan Package MarketPlan
 * @groupdesc MarketPlan Market plan definitions for planned markets, planned market events, actual market runs, actual market events.
 */
final case class CRRMarket
(
    Market: Market = null,
    labelID: String = null,
    CongestionRevenueRight: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Market = Market

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CRRMarket.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CRRMarket.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (CRRMarket.fields (position), x))
        emitelem (0, labelID)
        emitattrs (1, CongestionRevenueRight)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CRRMarket rdf:%s=\"%s\">\n%s\t</cim:CRRMarket>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object CRRMarket
extends
    CIMParseable[CRRMarket]
{
    override val fields: Array[String] = Array[String] (
        "labelID",
        "CongestionRevenueRight"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("CongestionRevenueRight", "CongestionRevenueRight", "1..*", "1")
    )
    val labelID: Fielder = parse_element (element (cls, fields(0)))
    val CongestionRevenueRight: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): CRRMarket =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CRRMarket (
            Market.parse (context),
            mask (labelID (), 0),
            masks (CongestionRevenueRight (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[CRRMarket] = CRRMarketSerializer
}

object CRRMarketSerializer extends CIMSerializer[CRRMarket]
{
    def write (kryo: Kryo, output: Output, obj: CRRMarket): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.labelID),
            () => writeList (obj.CongestionRevenueRight, output)
        )
        MarketSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CRRMarket]): CRRMarket =
    {
        val parent = MarketSerializer.read (kryo, input, classOf[Market])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = CRRMarket (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Commodities in the context of IEC 62325 are MarketProducts (energy, regulation, reserve, etc) traded at a specific location, which in this case is a Pnode (either a specific pricing node or a pricing area or zone defined as a collection of pricing nodes).
 *
 * The CommodityDefinition is a container for these two parameters, plus the unit of measure and the currency in which the Commodity is traded.  Each CommodityDefinition should be relatively static; defined once and rarely changed.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
final case class CommodityDefinition
(
    IdentifiedObject: IdentifiedObject = null,
    commodityCurrency: String = null,
    commodityUnit: String = null,
    commodityUnitMultiplier: String = null,
    CommodityPrice: List[String] = null,
    MarketProduct: String = null,
    Pnode: String = null,
    RTO: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: IdentifiedObject = IdentifiedObject

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CommodityDefinition.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CommodityDefinition.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (CommodityDefinition.fields (position), x))
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
        "\t<cim:CommodityDefinition rdf:%s=\"%s\">\n%s\t</cim:CommodityDefinition>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object CommodityDefinition
extends
    CIMParseable[CommodityDefinition]
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("CommodityPrice", "CommodityPrice", "1..*", "1"),
        CIMRelationship ("MarketProduct", "MarketProduct", "1", "0..*"),
        CIMRelationship ("Pnode", "Pnode", "1", "0..*"),
        CIMRelationship ("RTO", "RTO", "1", "0..*")
    )
    val commodityCurrency: Fielder = parse_attribute (attribute (cls, fields(0)))
    val commodityUnit: Fielder = parse_attribute (attribute (cls, fields(1)))
    val commodityUnitMultiplier: Fielder = parse_attribute (attribute (cls, fields(2)))
    val CommodityPrice: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val MarketProduct: Fielder = parse_attribute (attribute (cls, fields(4)))
    val Pnode: Fielder = parse_attribute (attribute (cls, fields(5)))
    val RTO: Fielder = parse_attribute (attribute (cls, fields(6)))

    def parse (context: CIMContext): CommodityDefinition =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[CommodityDefinition] = CommodityDefinitionSerializer
}

object CommodityDefinitionSerializer extends CIMSerializer[CommodityDefinition]
{
    def write (kryo: Kryo, output: Output, obj: CommodityDefinition): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.commodityCurrency),
            () => output.writeString (obj.commodityUnit),
            () => output.writeString (obj.commodityUnitMultiplier),
            () => writeList (obj.CommodityPrice, output),
            () => output.writeString (obj.MarketProduct),
            () => output.writeString (obj.Pnode),
            () => output.writeString (obj.RTO)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CommodityDefinition]): CommodityDefinition =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = CommodityDefinition (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A demand response event is created when there is a need to call upon resources to respond to demand adjustment requests.
 *
 * These events are created by ISO/RTO system operations and managed  by a demand response management system (DRMS). These events may or may not be coordinated with the Market Events and a defined Energy Market. The event will call for the deployment of a number of registered resources, or for deployment of resources within a zone (an organizational area within the power system that contains a number of resources).
 *
 * @param MarketActualEvent [[ch.ninecode.model.MarketActualEvent MarketActualEvent]] Reference to the superclass object.
 * @param totalPowerAdjustment Total active power adjustment (e.g. load reduction) requested for this demand response event.
 * @param InstructionClearing [[ch.ninecode.model.InstructionClearing InstructionClearing]] ActualDemandResponseEvents may exist that are not part of a coordinated MarketActualEvent associated to a Market.
 *        These ActualDemandResponseEvents can have many InstructionClearing Instructions for specified RegisteredResources or DemandResponse AggregateNodes.
 * @param InstructionClearingDOT [[ch.ninecode.model.InstructionClearingDOT InstructionClearingDOT]] <em>undocumented</em>
 * @param ResourcePerformanceEvaluations [[ch.ninecode.model.ResourcePerformanceEvaluation ResourcePerformanceEvaluation]] <em>undocumented</em>
 * @group MarketPlan
 * @groupname MarketPlan Package MarketPlan
 * @groupdesc MarketPlan Market plan definitions for planned markets, planned market events, actual market runs, actual market events.
 */
final case class DistributedResourceActualEvent
(
    MarketActualEvent: MarketActualEvent = null,
    totalPowerAdjustment: Double = 0.0,
    InstructionClearing: List[String] = null,
    InstructionClearingDOT: List[String] = null,
    ResourcePerformanceEvaluations: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: MarketActualEvent = MarketActualEvent

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = DistributedResourceActualEvent.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DistributedResourceActualEvent.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (DistributedResourceActualEvent.fields (position), x))
        emitelem (0, totalPowerAdjustment)
        emitattrs (1, InstructionClearing)
        emitattrs (2, InstructionClearingDOT)
        emitattrs (3, ResourcePerformanceEvaluations)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DistributedResourceActualEvent rdf:%s=\"%s\">\n%s\t</cim:DistributedResourceActualEvent>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object DistributedResourceActualEvent
extends
    CIMParseable[DistributedResourceActualEvent]
{
    override val fields: Array[String] = Array[String] (
        "totalPowerAdjustment",
        "InstructionClearing",
        "InstructionClearingDOT",
        "ResourcePerformanceEvaluations"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("InstructionClearing", "InstructionClearing", "0..*", "0..1"),
        CIMRelationship ("InstructionClearingDOT", "InstructionClearingDOT", "0..*", "0..1"),
        CIMRelationship ("ResourcePerformanceEvaluations", "ResourcePerformanceEvaluation", "0..*", "1")
    )
    val totalPowerAdjustment: Fielder = parse_element (element (cls, fields(0)))
    val InstructionClearing: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val InstructionClearingDOT: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val ResourcePerformanceEvaluations: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: CIMContext): DistributedResourceActualEvent =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[DistributedResourceActualEvent] = DistributedResourceActualEventSerializer
}

object DistributedResourceActualEventSerializer extends CIMSerializer[DistributedResourceActualEvent]
{
    def write (kryo: Kryo, output: Output, obj: DistributedResourceActualEvent): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.totalPowerAdjustment),
            () => writeList (obj.InstructionClearing, output),
            () => writeList (obj.InstructionClearingDOT, output),
            () => writeList (obj.ResourcePerformanceEvaluations, output)
        )
        MarketActualEventSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DistributedResourceActualEvent]): DistributedResourceActualEvent =
    {
        val parent = MarketActualEventSerializer.read (kryo, input, classOf[MarketActualEvent])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = DistributedResourceActualEvent (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) readList (input) else null,
            if (isSet (3)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Energy and Ancillary Market (e.g.
 *
 * Energy, Spinning Reserve, Non-Spinning Reserve) with a description of the Market operation control parameters.
 *
 * @param Market [[ch.ninecode.model.Market Market]] Reference to the superclass object.
 * @param Bids [[ch.ninecode.model.Bid Bid]] <em>undocumented</em>
 * @param MarketResults [[ch.ninecode.model.MarketResults MarketResults]] <em>undocumented</em>
 * @param RTO [[ch.ninecode.model.RTO RTO]] <em>undocumented</em>
 * @param RegisteredResources [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @param Settlements [[ch.ninecode.model.Settlement Settlement]] <em>undocumented</em>
 * @group MarketPlan
 * @groupname MarketPlan Package MarketPlan
 * @groupdesc MarketPlan Market plan definitions for planned markets, planned market events, actual market runs, actual market events.
 */
final case class EnergyMarket
(
    Market: Market = null,
    Bids: List[String] = null,
    MarketResults: String = null,
    RTO: String = null,
    RegisteredResources: List[String] = null,
    Settlements: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Market = Market

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = EnergyMarket.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EnergyMarket.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (EnergyMarket.fields (position), x))
        emitattrs (0, Bids)
        emitattr (1, MarketResults)
        emitattr (2, RTO)
        emitattrs (3, RegisteredResources)
        emitattrs (4, Settlements)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EnergyMarket rdf:%s=\"%s\">\n%s\t</cim:EnergyMarket>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object EnergyMarket
extends
    CIMParseable[EnergyMarket]
{
    override val fields: Array[String] = Array[String] (
        "Bids",
        "MarketResults",
        "RTO",
        "RegisteredResources",
        "Settlements"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Bids", "Bid", "0..*", "1"),
        CIMRelationship ("MarketResults", "MarketResults", "0..1", "1"),
        CIMRelationship ("RTO", "RTO", "0..1", "0..*"),
        CIMRelationship ("RegisteredResources", "RegisteredResource", "0..*", "0..*"),
        CIMRelationship ("Settlements", "Settlement", "0..*", "0..1")
    )
    val Bids: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val MarketResults: Fielder = parse_attribute (attribute (cls, fields(1)))
    val RTO: Fielder = parse_attribute (attribute (cls, fields(2)))
    val RegisteredResources: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val Settlements: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: CIMContext): EnergyMarket =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[EnergyMarket] = EnergyMarketSerializer
}

object EnergyMarketSerializer extends CIMSerializer[EnergyMarket]
{
    def write (kryo: Kryo, output: Output, obj: EnergyMarket): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.Bids, output),
            () => output.writeString (obj.MarketResults),
            () => output.writeString (obj.RTO),
            () => writeList (obj.RegisteredResources, output),
            () => writeList (obj.Settlements, output)
        )
        MarketSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[EnergyMarket]): EnergyMarket =
    {
        val parent = MarketSerializer.read (kryo, input, classOf[Market])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = EnergyMarket (
            parent,
            if (isSet (0)) readList (input) else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Market (e.g.
 *
 * Day Ahead Market, Real Time Market) with a description of the Market operation control parameters.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
final case class Market
(
    IdentifiedObject: IdentifiedObject = null,
    actualEnd: String = null,
    actualStart: String = null,
    dst: Boolean = false,
    end: String = null,
    localTimeZone: String = null,
    start: String = null,
    status: String = null,
    timeIntervalLength: Double = 0.0,
    tradingDay: String = null,
    tradingPeriod: String = null,
    MarketFactors: List[String] = null,
    MarketProducts: List[String] = null,
    MarketRun: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: IdentifiedObject = IdentifiedObject

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Market.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Market.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Market.fields (position), x))
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
        "\t<cim:Market rdf:%s=\"%s\">\n%s\t</cim:Market>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object Market
extends
    CIMParseable[Market]
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("MarketFactors", "MarketFactors", "0..*", "0..1"),
        CIMRelationship ("MarketProducts", "MarketProduct", "1..*", "0..1"),
        CIMRelationship ("MarketRun", "MarketRun", "0..*", "1")
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

    def parse (context: CIMContext): Market =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[Market] = MarketSerializer
}

object MarketSerializer extends CIMSerializer[Market]
{
    def write (kryo: Kryo, output: Output, obj: Market): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.actualEnd),
            () => output.writeString (obj.actualStart),
            () => output.writeBoolean (obj.dst),
            () => output.writeString (obj.end),
            () => output.writeString (obj.localTimeZone),
            () => output.writeString (obj.start),
            () => output.writeString (obj.status),
            () => output.writeDouble (obj.timeIntervalLength),
            () => output.writeString (obj.tradingDay),
            () => output.writeString (obj.tradingPeriod),
            () => writeList (obj.MarketFactors, output),
            () => writeList (obj.MarketProducts, output),
            () => writeList (obj.MarketRun, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Market]): Market =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Market (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readBoolean else false,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) input.readDouble else 0.0,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) input.readString else null,
            if (isSet (10)) readList (input) else null,
            if (isSet (11)) readList (input) else null,
            if (isSet (12)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * This class represents the actual instance of an event.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
final case class MarketActualEvent
(
    IdentifiedObject: IdentifiedObject = null,
    eventComments: String = null,
    eventEndTime: String = null,
    eventStartTime: String = null,
    eventStatus: String = null,
    eventType: String = null,
    MarketRun: String = null,
    PlannedMarketEvent: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: IdentifiedObject = IdentifiedObject

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
        "\t<cim:MarketActualEvent rdf:%s=\"%s\">\n%s\t</cim:MarketActualEvent>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object MarketActualEvent
extends
    CIMParseable[MarketActualEvent]
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("MarketRun", "MarketRun", "0..1", "1..*"),
        CIMRelationship ("PlannedMarketEvent", "PlannedMarketEvent", "0..1", "1..*")
    )
    val eventComments: Fielder = parse_element (element (cls, fields(0)))
    val eventEndTime: Fielder = parse_element (element (cls, fields(1)))
    val eventStartTime: Fielder = parse_element (element (cls, fields(2)))
    val eventStatus: Fielder = parse_attribute (attribute (cls, fields(3)))
    val eventType: Fielder = parse_element (element (cls, fields(4)))
    val MarketRun: Fielder = parse_attribute (attribute (cls, fields(5)))
    val PlannedMarketEvent: Fielder = parse_attribute (attribute (cls, fields(6)))

    def parse (context: CIMContext): MarketActualEvent =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[MarketActualEvent] = MarketActualEventSerializer
}

object MarketActualEventSerializer extends CIMSerializer[MarketActualEvent]
{
    def write (kryo: Kryo, output: Output, obj: MarketActualEvent): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.eventComments),
            () => output.writeString (obj.eventEndTime),
            () => output.writeString (obj.eventStartTime),
            () => output.writeString (obj.eventStatus),
            () => output.writeString (obj.eventType),
            () => output.writeString (obj.MarketRun),
            () => output.writeString (obj.PlannedMarketEvent)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MarketActualEvent]): MarketActualEvent =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = MarketActualEvent (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Aggregation of market information relative for a specific time interval.
 *
 * @param Document [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param intervalEndTime The end of the time interval for which requirement is defined.
 * @param intervalStartTime The start of the time interval for which requirement is defined.
 * @param Market [[ch.ninecode.model.Market Market]] <em>undocumented</em>
 * @param MktActivityRecord [[ch.ninecode.model.MktActivityRecord MktActivityRecord]] <em>undocumented</em>
 * @group MarketPlan
 * @groupname MarketPlan Package MarketPlan
 * @groupdesc MarketPlan Market plan definitions for planned markets, planned market events, actual market runs, actual market events.
 */
final case class MarketFactors
(
    Document: Document = null,
    intervalEndTime: String = null,
    intervalStartTime: String = null,
    Market: String = null,
    MktActivityRecord: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Document = Document

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MarketFactors.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MarketFactors.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MarketFactors.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MarketFactors.fields (position), x))
        emitelem (0, intervalEndTime)
        emitelem (1, intervalStartTime)
        emitattr (2, Market)
        emitattrs (3, MktActivityRecord)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MarketFactors rdf:%s=\"%s\">\n%s\t</cim:MarketFactors>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object MarketFactors
extends
    CIMParseable[MarketFactors]
{
    override val fields: Array[String] = Array[String] (
        "intervalEndTime",
        "intervalStartTime",
        "Market",
        "MktActivityRecord"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Market", "Market", "0..1", "0..*"),
        CIMRelationship ("MktActivityRecord", "MktActivityRecord", "0..*", "0..*")
    )
    val intervalEndTime: Fielder = parse_element (element (cls, fields(0)))
    val intervalStartTime: Fielder = parse_element (element (cls, fields(1)))
    val Market: Fielder = parse_attribute (attribute (cls, fields(2)))
    val MktActivityRecord: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: CIMContext): MarketFactors =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[MarketFactors] = MarketFactorsSerializer
}

object MarketFactorsSerializer extends CIMSerializer[MarketFactors]
{
    def write (kryo: Kryo, output: Output, obj: MarketFactors): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.intervalEndTime),
            () => output.writeString (obj.intervalStartTime),
            () => output.writeString (obj.Market),
            () => writeList (obj.MktActivityRecord, output)
        )
        DocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MarketFactors]): MarketFactors =
    {
        val parent = DocumentSerializer.read (kryo, input, classOf[Document])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = MarketFactors (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * This class identifies a set of planned markets.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param tradingDay Planned market trading day.
 * @param PlannedMarket [[ch.ninecode.model.PlannedMarket PlannedMarket]] A market plan has a number of markets (DA, HA, RT).
 * @group MarketPlan
 * @groupname MarketPlan Package MarketPlan
 * @groupdesc MarketPlan Market plan definitions for planned markets, planned market events, actual market runs, actual market events.
 */
final case class MarketPlan
(
    IdentifiedObject: IdentifiedObject = null,
    tradingDay: String = null,
    PlannedMarket: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: IdentifiedObject = IdentifiedObject

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MarketPlan.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MarketPlan.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MarketPlan.fields (position), x))
        emitelem (0, tradingDay)
        emitattrs (1, PlannedMarket)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MarketPlan rdf:%s=\"%s\">\n%s\t</cim:MarketPlan>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object MarketPlan
extends
    CIMParseable[MarketPlan]
{
    override val fields: Array[String] = Array[String] (
        "tradingDay",
        "PlannedMarket"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("PlannedMarket", "PlannedMarket", "1..*", "1")
    )
    val tradingDay: Fielder = parse_element (element (cls, fields(0)))
    val PlannedMarket: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): MarketPlan =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MarketPlan (
            IdentifiedObject.parse (context),
            mask (tradingDay (), 0),
            masks (PlannedMarket (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[MarketPlan] = MarketPlanSerializer
}

object MarketPlanSerializer extends CIMSerializer[MarketPlan]
{
    def write (kryo: Kryo, output: Output, obj: MarketPlan): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.tradingDay),
            () => writeList (obj.PlannedMarket, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MarketPlan]): MarketPlan =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = MarketPlan (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A product traded by an RTO (e.g. energy, 10 minute spinning reserve).
 *
 * Ancillary service product examples include: Regulation, Regulation Up, Regulation Down, Spinning Reserve, Non-Spinning Reserve, etc.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
final case class MarketProduct
(
    IdentifiedObject: IdentifiedObject = null,
    marketProductType: String = null,
    rampInterval: Double = 0.0,
    BidError: List[String] = null,
    BidPriceCap: List[String] = null,
    CommodityDefinition: List[String] = null,
    Market: String = null,
    MarketRegionResults: String = null,
    ProductBids: List[String] = null,
    ReserveReqs: List[String] = null,
    ResourceAwardInstruction: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: IdentifiedObject = IdentifiedObject

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MarketProduct.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MarketProduct.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MarketProduct.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MarketProduct.fields (position), x))
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
        "\t<cim:MarketProduct rdf:%s=\"%s\">\n%s\t</cim:MarketProduct>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object MarketProduct
extends
    CIMParseable[MarketProduct]
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("BidError", "BidError", "0..*", "0..1"),
        CIMRelationship ("BidPriceCap", "BidPriceCap", "0..*", "0..1"),
        CIMRelationship ("CommodityDefinition", "CommodityDefinition", "0..*", "1"),
        CIMRelationship ("Market", "Market", "0..1", "1..*"),
        CIMRelationship ("MarketRegionResults", "MarketRegionResults", "0..1", "0..1"),
        CIMRelationship ("ProductBids", "ProductBid", "0..*", "1"),
        CIMRelationship ("ReserveReqs", "ReserveReq", "0..*", "1"),
        CIMRelationship ("ResourceAwardInstruction", "ResourceAwardInstruction", "0..*", "1")
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

    def parse (context: CIMContext): MarketProduct =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[MarketProduct] = MarketProductSerializer
}

object MarketProductSerializer extends CIMSerializer[MarketProduct]
{
    def write (kryo: Kryo, output: Output, obj: MarketProduct): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.marketProductType),
            () => output.writeDouble (obj.rampInterval),
            () => writeList (obj.BidError, output),
            () => writeList (obj.BidPriceCap, output),
            () => writeList (obj.CommodityDefinition, output),
            () => output.writeString (obj.Market),
            () => output.writeString (obj.MarketRegionResults),
            () => writeList (obj.ProductBids, output),
            () => writeList (obj.ReserveReqs, output),
            () => writeList (obj.ResourceAwardInstruction, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MarketProduct]): MarketProduct =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = MarketProduct (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) readList (input) else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) readList (input) else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) readList (input) else null,
            if (isSet (8)) readList (input) else null,
            if (isSet (9)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * This class represents an actual instance of a planned market.
 *
 * For example, a Day Ahead market opens with the Bid Submission, ends with the closing of the Bid Submission. The market run represent the whole process. MarketRuns can be defined for markets such as Day Ahead Market, Real Time Market, Hour Ahead Market, Week Ahead Market, etc.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
final case class MarketRun
(
    IdentifiedObject: IdentifiedObject = null,
    executionType: String = null,
    marketApprovalTime: String = null,
    marketApprovedStatus: Boolean = false,
    marketEndTime: String = null,
    marketStartTime: String = null,
    marketType: String = null,
    reportedState: String = null,
    runState: String = null,
    Market: String = null,
    MarketActualEvent: List[String] = null,
    PlannedMarket: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: IdentifiedObject = IdentifiedObject

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MarketRun.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MarketRun.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MarketRun.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MarketRun.fields (position), x))
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
        "\t<cim:MarketRun rdf:%s=\"%s\">\n%s\t</cim:MarketRun>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object MarketRun
extends
    CIMParseable[MarketRun]
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Market", "Market", "1", "0..*"),
        CIMRelationship ("MarketActualEvent", "MarketActualEvent", "1..*", "0..1"),
        CIMRelationship ("PlannedMarket", "PlannedMarket", "1", "0..*")
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

    def parse (context: CIMContext): MarketRun =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[MarketRun] = MarketRunSerializer
}

object MarketRunSerializer extends CIMSerializer[MarketRun]
{
    def write (kryo: Kryo, output: Output, obj: MarketRun): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.executionType),
            () => output.writeString (obj.marketApprovalTime),
            () => output.writeBoolean (obj.marketApprovedStatus),
            () => output.writeString (obj.marketEndTime),
            () => output.writeString (obj.marketStartTime),
            () => output.writeString (obj.marketType),
            () => output.writeString (obj.reportedState),
            () => output.writeString (obj.runState),
            () => output.writeString (obj.Market),
            () => writeList (obj.MarketActualEvent, output),
            () => output.writeString (obj.PlannedMarket)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MarketRun]): MarketRun =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = MarketRun (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readBoolean else false,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) input.readString else null,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) readList (input) else null,
            if (isSet (10)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Represent a planned market.
 *
 * For example a planned DA/HA/RT market.
 *
 * @param Element Reference to the superclass object.
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
final case class PlannedMarket
(
    Element: BasicElement = null,
    marketEndTime: String = null,
    marketStartTime: String = null,
    marketType: String = null,
    MarketPlan: String = null,
    MarketRun: List[String] = null,
    PlannedMarketEvent: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Element = Element

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PlannedMarket.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PlannedMarket.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PlannedMarket.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (PlannedMarket.fields (position), x))
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
        "\t<cim:PlannedMarket rdf:%s=\"%s\">\n%s\t</cim:PlannedMarket>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object PlannedMarket
extends
    CIMParseable[PlannedMarket]
{
    override val fields: Array[String] = Array[String] (
        "marketEndTime",
        "marketStartTime",
        "marketType",
        "MarketPlan",
        "MarketRun",
        "PlannedMarketEvent"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("MarketPlan", "MarketPlan", "1", "1..*"),
        CIMRelationship ("MarketRun", "MarketRun", "0..*", "1"),
        CIMRelationship ("PlannedMarketEvent", "PlannedMarketEvent", "1..*", "0..*")
    )
    val marketEndTime: Fielder = parse_element (element (cls, fields(0)))
    val marketStartTime: Fielder = parse_element (element (cls, fields(1)))
    val marketType: Fielder = parse_attribute (attribute (cls, fields(2)))
    val MarketPlan: Fielder = parse_attribute (attribute (cls, fields(3)))
    val MarketRun: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val PlannedMarketEvent: FielderMultiple = parse_attributes (attribute (cls, fields(5)))

    def parse (context: CIMContext): PlannedMarket =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[PlannedMarket] = PlannedMarketSerializer
}

object PlannedMarketSerializer extends CIMSerializer[PlannedMarket]
{
    def write (kryo: Kryo, output: Output, obj: PlannedMarket): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.marketEndTime),
            () => output.writeString (obj.marketStartTime),
            () => output.writeString (obj.marketType),
            () => output.writeString (obj.MarketPlan),
            () => writeList (obj.MarketRun, output),
            () => writeList (obj.PlannedMarketEvent, output)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PlannedMarket]): PlannedMarket =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PlannedMarket (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) readList (input) else null,
            if (isSet (5)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * This class represents planned events.
 *
 * Used to model the various planned events in a market (closing time, clearing time, etc.)
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param eventType Planned event type.
 * @param plannedTime This is relative time so that this attribute can be used by more than one planned market.
 *        For example the bid submission is 10am everyday.
 * @param MarketActualEvent [[ch.ninecode.model.MarketActualEvent MarketActualEvent]] All actual events that execute this planned event.
 * @param PlannedMarket [[ch.ninecode.model.PlannedMarket PlannedMarket]] A planned market shall have a set of planned events
 * @group MarketPlan
 * @groupname MarketPlan Package MarketPlan
 * @groupdesc MarketPlan Market plan definitions for planned markets, planned market events, actual market runs, actual market events.
 */
final case class PlannedMarketEvent
(
    IdentifiedObject: IdentifiedObject = null,
    eventType: String = null,
    plannedTime: Int = 0,
    MarketActualEvent: List[String] = null,
    PlannedMarket: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: IdentifiedObject = IdentifiedObject

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PlannedMarketEvent.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PlannedMarketEvent.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (PlannedMarketEvent.fields (position), x))
        emitelem (0, eventType)
        emitelem (1, plannedTime)
        emitattrs (2, MarketActualEvent)
        emitattrs (3, PlannedMarket)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PlannedMarketEvent rdf:%s=\"%s\">\n%s\t</cim:PlannedMarketEvent>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object PlannedMarketEvent
extends
    CIMParseable[PlannedMarketEvent]
{
    override val fields: Array[String] = Array[String] (
        "eventType",
        "plannedTime",
        "MarketActualEvent",
        "PlannedMarket"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("MarketActualEvent", "MarketActualEvent", "1..*", "0..1"),
        CIMRelationship ("PlannedMarket", "PlannedMarket", "0..*", "1..*")
    )
    val eventType: Fielder = parse_element (element (cls, fields(0)))
    val plannedTime: Fielder = parse_element (element (cls, fields(1)))
    val MarketActualEvent: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val PlannedMarket: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: CIMContext): PlannedMarketEvent =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[PlannedMarketEvent] = PlannedMarketEventSerializer
}

object PlannedMarketEventSerializer extends CIMSerializer[PlannedMarketEvent]
{
    def write (kryo: Kryo, output: Output, obj: PlannedMarketEvent): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.eventType),
            () => output.writeInt (obj.plannedTime),
            () => writeList (obj.MarketActualEvent, output),
            () => writeList (obj.PlannedMarket, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PlannedMarketEvent]): PlannedMarketEvent =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PlannedMarketEvent (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readInt else 0,
            if (isSet (2)) readList (input) else null,
            if (isSet (3)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _MarketPlan
{
    def register: List[CIMClassInfo] =
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