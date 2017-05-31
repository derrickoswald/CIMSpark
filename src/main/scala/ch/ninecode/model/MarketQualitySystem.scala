package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * Post-market accounting, calculation and meter data corrections to reduce invoicing errors and disputes.
 * Reduces manual validation, verification and correction of transactional data that could affect market settlements. Republishing of market results with affected data corrected.
 */

/**
 * Models Market clearing results.
 * Indicates market horizon, interval based. Used by a market quality system for billing and settlement purposes
 * @param sup Reference to the superclass object.
 * @param intervalStartTime
 * @param updateTimeStamp
 * @param updateUser
 */
case class AllocationResult
(
    override val sup: BasicElement,
    val intervalStartTime: String,
    val updateTimeStamp: String,
    val updateUser: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[AllocationResult]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AllocationResult
extends
    Parseable[AllocationResult]
{
    val sup = BasicElement.parse _
    val intervalStartTime = parse_element (element ("""AllocationResult.intervalStartTime"""))
    val updateTimeStamp = parse_element (element ("""AllocationResult.updateTimeStamp"""))
    val updateUser = parse_element (element ("""AllocationResult.updateUser"""))
    def parse (context: Context): AllocationResult =
    {
        AllocationResult(
            sup (context),
            intervalStartTime (context),
            updateTimeStamp (context),
            updateUser (context)
        )
    }
}

/**
 * Models Market clearing results in terms of price and MW values
 * @param sup Reference to the superclass object.
 * @param aggregateType "1" --  "Detail",
"2" --  "Aggregate by Market service type", in which case, the "AllocationEnergyType" field will not be filled;
 *        "3" --  "Aggregate by "AllocationEnergyType", in which case "MarketServiceType" will not be filled.
 * @param allocationMwHour
 * @param allocationPrice
 * @param energyTypeCode
 * @param marketServiceType Choices are: 
ME - Market Energy Capacity; 
SR - Spinning Reserve Capacity; 
NR - Non-Spinning Reserve Capacity; 
DAC - Day Ahead Capacity;
 *        DEC - Derate Capacity
 * @param AllocationResult
 * @param RegisteredResource
 */
case class AllocationResultValues
(
    override val sup: BasicElement,
    val aggregateType: String,
    val allocationMwHour: Double,
    val allocationPrice: Double,
    val energyTypeCode: String,
    val marketServiceType: String,
    val AllocationResult: String,
    val RegisteredResource: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, 0.0, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[AllocationResultValues]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AllocationResultValues
extends
    Parseable[AllocationResultValues]
{
    val sup = BasicElement.parse _
    val aggregateType = parse_element (element ("""AllocationResultValues.aggregateType"""))
    val allocationMwHour = parse_element (element ("""AllocationResultValues.allocationMwHour"""))
    val allocationPrice = parse_element (element ("""AllocationResultValues.allocationPrice"""))
    val energyTypeCode = parse_element (element ("""AllocationResultValues.energyTypeCode"""))
    val marketServiceType = parse_element (element ("""AllocationResultValues.marketServiceType"""))
    val AllocationResult = parse_attribute (attribute ("""AllocationResultValues.AllocationResult"""))
    val RegisteredResource = parse_attribute (attribute ("""AllocationResultValues.RegisteredResource"""))
    def parse (context: Context): AllocationResultValues =
    {
        AllocationResultValues(
            sup (context),
            aggregateType (context),
            toDouble (allocationMwHour (context), context),
            toDouble (allocationPrice (context), context),
            energyTypeCode (context),
            marketServiceType (context),
            AllocationResult (context),
            RegisteredResource (context)
        )
    }
}

/**
 * Models Market clearing results for Auxillary costs
 * @param sup Reference to the superclass object.
 * @param intervalStartTime
 * @param marketType
 * @param updateTimeStamp
 * @param updateUser
 */
case class AuxiliaryCost
(
    override val sup: BasicElement,
    val intervalStartTime: String,
    val marketType: String,
    val updateTimeStamp: String,
    val updateUser: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[AuxiliaryCost]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AuxiliaryCost
extends
    Parseable[AuxiliaryCost]
{
    val sup = BasicElement.parse _
    val intervalStartTime = parse_element (element ("""AuxiliaryCost.intervalStartTime"""))
    val marketType = parse_attribute (attribute ("""AuxiliaryCost.marketType"""))
    val updateTimeStamp = parse_element (element ("""AuxiliaryCost.updateTimeStamp"""))
    val updateUser = parse_element (element ("""AuxiliaryCost.updateUser"""))
    def parse (context: Context): AuxiliaryCost =
    {
        AuxiliaryCost(
            sup (context),
            intervalStartTime (context),
            marketType (context),
            updateTimeStamp (context),
            updateUser (context)
        )
    }
}

/**
 * Models Auxillary Values
 * @param sup Reference to the superclass object.
 * @param RegisteredGenerator
 * @param RegisteredLoad
 */
case class AuxiliaryObject
(
    override val sup: BasicElement,
    val RegisteredGenerator: String,
    val RegisteredLoad: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[AuxiliaryObject]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AuxiliaryObject
extends
    Parseable[AuxiliaryObject]
{
    val sup = BasicElement.parse _
    val RegisteredGenerator = parse_attribute (attribute ("""AuxiliaryObject.RegisteredGenerator"""))
    val RegisteredLoad = parse_attribute (attribute ("""AuxiliaryObject.RegisteredLoad"""))
    def parse (context: Context): AuxiliaryObject =
    {
        AuxiliaryObject(
            sup (context),
            RegisteredGenerator (context),
            RegisteredLoad (context)
        )
    }
}

/**
 * Models Auxillary Values
 * @param sup Reference to the superclass object.
 * @param availUndispatchedQ
 * @param incrementalORAvail
 * @param maxExpostCapacity
 * @param minExpostCapacity
 * @param noLoadCost
 * @param noLoadCostEligibilityFlag
 * @param startUpCost
 * @param startUpCostEligibilityFlag
 * @param AuxillaryCost
 * @param FiveMinAuxillaryData
 * @param TenMinAuxillaryData
 */
case class AuxiliaryValues
(
    override val sup: AuxiliaryObject,
    val availUndispatchedQ: Double,
    val incrementalORAvail: Double,
    val maxExpostCapacity: Double,
    val minExpostCapacity: Double,
    val noLoadCost: Double,
    val noLoadCostEligibilityFlag: String,
    val startUpCost: Double,
    val startUpCostEligibilityFlag: String,
    val AuxillaryCost: String,
    val FiveMinAuxillaryData: String,
    val TenMinAuxillaryData: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, null, 0.0, null, null, null, null) }
    def AuxiliaryObject: AuxiliaryObject = sup.asInstanceOf[AuxiliaryObject]
    override def copy (): Row = { return (clone ().asInstanceOf[AuxiliaryValues]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AuxiliaryValues
extends
    Parseable[AuxiliaryValues]
{
    val sup = AuxiliaryObject.parse _
    val availUndispatchedQ = parse_element (element ("""AuxiliaryValues.availUndispatchedQ"""))
    val incrementalORAvail = parse_element (element ("""AuxiliaryValues.incrementalORAvail"""))
    val maxExpostCapacity = parse_element (element ("""AuxiliaryValues.maxExpostCapacity"""))
    val minExpostCapacity = parse_element (element ("""AuxiliaryValues.minExpostCapacity"""))
    val noLoadCost = parse_element (element ("""AuxiliaryValues.noLoadCost"""))
    val noLoadCostEligibilityFlag = parse_attribute (attribute ("""AuxiliaryValues.noLoadCostEligibilityFlag"""))
    val startUpCost = parse_element (element ("""AuxiliaryValues.startUpCost"""))
    val startUpCostEligibilityFlag = parse_attribute (attribute ("""AuxiliaryValues.startUpCostEligibilityFlag"""))
    val AuxillaryCost = parse_attribute (attribute ("""AuxiliaryValues.AuxillaryCost"""))
    val FiveMinAuxillaryData = parse_attribute (attribute ("""AuxiliaryValues.FiveMinAuxillaryData"""))
    val TenMinAuxillaryData = parse_attribute (attribute ("""AuxiliaryValues.TenMinAuxillaryData"""))
    def parse (context: Context): AuxiliaryValues =
    {
        AuxiliaryValues(
            sup (context),
            toDouble (availUndispatchedQ (context), context),
            toDouble (incrementalORAvail (context), context),
            toDouble (maxExpostCapacity (context), context),
            toDouble (minExpostCapacity (context), context),
            toDouble (noLoadCost (context), context),
            noLoadCostEligibilityFlag (context),
            toDouble (startUpCost (context), context),
            startUpCostEligibilityFlag (context),
            AuxillaryCost (context),
            FiveMinAuxillaryData (context),
            TenMinAuxillaryData (context)
        )
    }
}

/**
 * Model Expected Energy  from Market Clearing, interval based
 * @param sup Reference to the superclass object.
 * @param intervalStartTime
 * @param updateTimeStamp
 * @param updateUser
 */
case class ExpectedEnergy
(
    override val sup: BasicElement,
    val intervalStartTime: String,
    val updateTimeStamp: String,
    val updateUser: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ExpectedEnergy]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExpectedEnergy
extends
    Parseable[ExpectedEnergy]
{
    val sup = BasicElement.parse _
    val intervalStartTime = parse_element (element ("""ExpectedEnergy.intervalStartTime"""))
    val updateTimeStamp = parse_element (element ("""ExpectedEnergy.updateTimeStamp"""))
    val updateUser = parse_element (element ("""ExpectedEnergy.updateUser"""))
    def parse (context: Context): ExpectedEnergy =
    {
        ExpectedEnergy(
            sup (context),
            intervalStartTime (context),
            updateTimeStamp (context),
            updateUser (context)
        )
    }
}

/**
 * Model Expected Energy  from Market Clearing
 * @param sup Reference to the superclass object.
 * @param energyTypeCode
 * @param expectedMwh
 * @param ExpectedEnergy
 * @param RegisteredResource
 */
case class ExpectedEnergyValues
(
    override val sup: BasicElement,
    val energyTypeCode: String,
    val expectedMwh: Double,
    val ExpectedEnergy: String,
    val RegisteredResource: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ExpectedEnergyValues]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExpectedEnergyValues
extends
    Parseable[ExpectedEnergyValues]
{
    val sup = BasicElement.parse _
    val energyTypeCode = parse_element (element ("""ExpectedEnergyValues.energyTypeCode"""))
    val expectedMwh = parse_element (element ("""ExpectedEnergyValues.expectedMwh"""))
    val ExpectedEnergy = parse_attribute (attribute ("""ExpectedEnergyValues.ExpectedEnergy"""))
    val RegisteredResource = parse_attribute (attribute ("""ExpectedEnergyValues.RegisteredResource"""))
    def parse (context: Context): ExpectedEnergyValues =
    {
        ExpectedEnergyValues(
            sup (context),
            energyTypeCode (context),
            toDouble (expectedMwh (context), context),
            ExpectedEnergy (context),
            RegisteredResource (context)
        )
    }
}

/**
 * Models 5-Minutes Auxillary Data
 * @param sup Reference to the superclass object.
 * @param intervalStartTime
 * @param updateTimeStamp
 * @param updateUser
 */
case class FiveMinAuxiliaryData
(
    override val sup: BasicElement,
    val intervalStartTime: String,
    val updateTimeStamp: String,
    val updateUser: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[FiveMinAuxiliaryData]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object FiveMinAuxiliaryData
extends
    Parseable[FiveMinAuxiliaryData]
{
    val sup = BasicElement.parse _
    val intervalStartTime = parse_element (element ("""FiveMinAuxiliaryData.intervalStartTime"""))
    val updateTimeStamp = parse_element (element ("""FiveMinAuxiliaryData.updateTimeStamp"""))
    val updateUser = parse_element (element ("""FiveMinAuxiliaryData.updateUser"""))
    def parse (context: Context): FiveMinAuxiliaryData =
    {
        FiveMinAuxiliaryData(
            sup (context),
            intervalStartTime (context),
            updateTimeStamp (context),
            updateUser (context)
        )
    }
}

/**
 * Models 10-Minutes Auxillary Data
 * @param sup Reference to the superclass object.
 * @param intervalStartTime
 * @param updateTimeStamp
 * @param updateUser
 */
case class TenMinAuxiliaryData
(
    override val sup: BasicElement,
    val intervalStartTime: String,
    val updateTimeStamp: String,
    val updateUser: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[TenMinAuxiliaryData]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TenMinAuxiliaryData
extends
    Parseable[TenMinAuxiliaryData]
{
    val sup = BasicElement.parse _
    val intervalStartTime = parse_element (element ("""TenMinAuxiliaryData.intervalStartTime"""))
    val updateTimeStamp = parse_element (element ("""TenMinAuxiliaryData.updateTimeStamp"""))
    val updateUser = parse_element (element ("""TenMinAuxiliaryData.updateUser"""))
    def parse (context: Context): TenMinAuxiliaryData =
    {
        TenMinAuxiliaryData(
            sup (context),
            intervalStartTime (context),
            updateTimeStamp (context),
            updateUser (context)
        )
    }
}

/**
 * Models prices at Trading Hubs, interval based
 * @param sup Reference to the superclass object.
 * @param intervalStartTime
 * @param marketType
 * @param updateTimeStamp
 * @param updateUser
 */
case class TradingHubPrice
(
    override val sup: BasicElement,
    val intervalStartTime: String,
    val marketType: String,
    val updateTimeStamp: String,
    val updateUser: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[TradingHubPrice]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TradingHubPrice
extends
    Parseable[TradingHubPrice]
{
    val sup = BasicElement.parse _
    val intervalStartTime = parse_element (element ("""TradingHubPrice.intervalStartTime"""))
    val marketType = parse_attribute (attribute ("""TradingHubPrice.marketType"""))
    val updateTimeStamp = parse_element (element ("""TradingHubPrice.updateTimeStamp"""))
    val updateUser = parse_element (element ("""TradingHubPrice.updateUser"""))
    def parse (context: Context): TradingHubPrice =
    {
        TradingHubPrice(
            sup (context),
            intervalStartTime (context),
            marketType (context),
            updateTimeStamp (context),
            updateUser (context)
        )
    }
}

/**
 * Models prices at Trading Hubs
 * @param sup Reference to the superclass object.
 * @param price Utilizes the Market type.
 *        For DA, the price is hourly. For RTM the price is a 5 minute price.
 * @param AggregatedPnode
 * @param TradingHubPrice
 */
case class TradingHubValues
(
    override val sup: BasicElement,
    val price: Double,
    val AggregatedPnode: String,
    val TradingHubPrice: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[TradingHubValues]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TradingHubValues
extends
    Parseable[TradingHubValues]
{
    val sup = BasicElement.parse _
    val price = parse_element (element ("""TradingHubValues.price"""))
    val AggregatedPnode = parse_attribute (attribute ("""TradingHubValues.AggregatedPnode"""))
    val TradingHubPrice = parse_attribute (attribute ("""TradingHubValues.TradingHubPrice"""))
    def parse (context: Context): TradingHubValues =
    {
        TradingHubValues(
            sup (context),
            toDouble (price (context), context),
            AggregatedPnode (context),
            TradingHubPrice (context)
        )
    }
}

object _MarketQualitySystem
{
    def register: Unit =
    {
        AllocationResult.register
        AllocationResultValues.register
        AuxiliaryCost.register
        AuxiliaryObject.register
        AuxiliaryValues.register
        ExpectedEnergy.register
        ExpectedEnergyValues.register
        FiveMinAuxiliaryData.register
        TenMinAuxiliaryData.register
        TradingHubPrice.register
        TradingHubValues.register
    }
}