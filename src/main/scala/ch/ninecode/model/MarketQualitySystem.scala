package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * Post-market accounting, calculation and meter data corrections to reduce invoicing errors and disputes.
 * Reduces manual validation, verification and correction of transactional data that could affect market settlements. Republishing of market results with affected data corrected.
 */

/**
 * Models Market clearing results.
 * Indicates market horizon, interval based. Used by a market quality system for billing and settlement purposes
 * @param sup Reference to the superclass object.
 * @param intervalStartTime <em>undocumented</em>
 * @param updateTimeStamp <em>undocumented</em>
 * @param updateUser <em>undocumented</em>
 */
case class AllocationResult
(
    override val sup: BasicElement,
    intervalStartTime: String,
    updateTimeStamp: String,
    updateUser: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[AllocationResult] }
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
        (if (null != intervalStartTime) "\t\t<cim:AllocationResult.intervalStartTime>" + intervalStartTime + "</cim:AllocationResult.intervalStartTime>\n" else "") +
        (if (null != updateTimeStamp) "\t\t<cim:AllocationResult.updateTimeStamp>" + updateTimeStamp + "</cim:AllocationResult.updateTimeStamp>\n" else "") +
        (if (null != updateUser) "\t\t<cim:AllocationResult.updateUser>" + updateUser + "</cim:AllocationResult.updateUser>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AllocationResult rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AllocationResult>"
    }
}

object AllocationResult
extends
    Parseable[AllocationResult]
{
    val intervalStartTime = parse_element (element ("""AllocationResult.intervalStartTime"""))
    val updateTimeStamp = parse_element (element ("""AllocationResult.updateTimeStamp"""))
    val updateUser = parse_element (element ("""AllocationResult.updateUser"""))
    def parse (context: Context): AllocationResult =
    {
        AllocationResult(
            BasicElement.parse (context),
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
 *        "2" --  "Aggregate by Market service type", in which case, the "AllocationEnergyType" field will not be filled;
 *        "3" --  "Aggregate by "AllocationEnergyType", in which case "MarketServiceType" will not be filled.
 * @param allocationMwHour <em>undocumented</em>
 * @param allocationPrice <em>undocumented</em>
 * @param energyTypeCode <em>undocumented</em>
 * @param marketServiceType Choices are:
 *        ME - Market Energy Capacity;
 *        SR - Spinning Reserve Capacity;
 *        NR - Non-Spinning Reserve Capacity;
 *        DAC - Day Ahead Capacity;
 *        DEC - Derate Capacity
 * @param AllocationResult <em>undocumented</em>
 * @param RegisteredResource <em>undocumented</em>
 */
case class AllocationResultValues
(
    override val sup: BasicElement,
    aggregateType: String,
    allocationMwHour: Double,
    allocationPrice: Double,
    energyTypeCode: String,
    marketServiceType: String,
    AllocationResult: String,
    RegisteredResource: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, 0.0, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[AllocationResultValues] }
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
        (if (null != aggregateType) "\t\t<cim:AllocationResultValues.aggregateType>" + aggregateType + "</cim:AllocationResultValues.aggregateType>\n" else "") +
        "\t\t<cim:AllocationResultValues.allocationMwHour>" + allocationMwHour + "</cim:AllocationResultValues.allocationMwHour>\n" +
        "\t\t<cim:AllocationResultValues.allocationPrice>" + allocationPrice + "</cim:AllocationResultValues.allocationPrice>\n" +
        (if (null != energyTypeCode) "\t\t<cim:AllocationResultValues.energyTypeCode>" + energyTypeCode + "</cim:AllocationResultValues.energyTypeCode>\n" else "") +
        (if (null != marketServiceType) "\t\t<cim:AllocationResultValues.marketServiceType>" + marketServiceType + "</cim:AllocationResultValues.marketServiceType>\n" else "") +
        (if (null != AllocationResult) "\t\t<cim:AllocationResultValues.AllocationResult rdf:resource=\"#" + AllocationResult + "\"/>\n" else "") +
        (if (null != RegisteredResource) "\t\t<cim:AllocationResultValues.RegisteredResource rdf:resource=\"#" + RegisteredResource + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AllocationResultValues rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AllocationResultValues>"
    }
}

object AllocationResultValues
extends
    Parseable[AllocationResultValues]
{
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
            BasicElement.parse (context),
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
 * @param intervalStartTime <em>undocumented</em>
 * @param marketType <em>undocumented</em>
 * @param updateTimeStamp <em>undocumented</em>
 * @param updateUser <em>undocumented</em>
 */
case class AuxiliaryCost
(
    override val sup: BasicElement,
    intervalStartTime: String,
    marketType: String,
    updateTimeStamp: String,
    updateUser: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[AuxiliaryCost] }
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
        (if (null != intervalStartTime) "\t\t<cim:AuxiliaryCost.intervalStartTime>" + intervalStartTime + "</cim:AuxiliaryCost.intervalStartTime>\n" else "") +
        (if (null != marketType) "\t\t<cim:AuxiliaryCost.marketType rdf:resource=\"#" + marketType + "\"/>\n" else "") +
        (if (null != updateTimeStamp) "\t\t<cim:AuxiliaryCost.updateTimeStamp>" + updateTimeStamp + "</cim:AuxiliaryCost.updateTimeStamp>\n" else "") +
        (if (null != updateUser) "\t\t<cim:AuxiliaryCost.updateUser>" + updateUser + "</cim:AuxiliaryCost.updateUser>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AuxiliaryCost rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AuxiliaryCost>"
    }
}

object AuxiliaryCost
extends
    Parseable[AuxiliaryCost]
{
    val intervalStartTime = parse_element (element ("""AuxiliaryCost.intervalStartTime"""))
    val marketType = parse_attribute (attribute ("""AuxiliaryCost.marketType"""))
    val updateTimeStamp = parse_element (element ("""AuxiliaryCost.updateTimeStamp"""))
    val updateUser = parse_element (element ("""AuxiliaryCost.updateUser"""))
    def parse (context: Context): AuxiliaryCost =
    {
        AuxiliaryCost(
            BasicElement.parse (context),
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
 * @param RegisteredGenerator <em>undocumented</em>
 * @param RegisteredLoad <em>undocumented</em>
 */
case class AuxiliaryObject
(
    override val sup: BasicElement,
    RegisteredGenerator: String,
    RegisteredLoad: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[AuxiliaryObject] }
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
        (if (null != RegisteredGenerator) "\t\t<cim:AuxiliaryObject.RegisteredGenerator rdf:resource=\"#" + RegisteredGenerator + "\"/>\n" else "") +
        (if (null != RegisteredLoad) "\t\t<cim:AuxiliaryObject.RegisteredLoad rdf:resource=\"#" + RegisteredLoad + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AuxiliaryObject rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AuxiliaryObject>"
    }
}

object AuxiliaryObject
extends
    Parseable[AuxiliaryObject]
{
    val RegisteredGenerator = parse_attribute (attribute ("""AuxiliaryObject.RegisteredGenerator"""))
    val RegisteredLoad = parse_attribute (attribute ("""AuxiliaryObject.RegisteredLoad"""))
    def parse (context: Context): AuxiliaryObject =
    {
        AuxiliaryObject(
            BasicElement.parse (context),
            RegisteredGenerator (context),
            RegisteredLoad (context)
        )
    }
}

/**
 * Models Auxillary Values
 * @param sup Reference to the superclass object.
 * @param availUndispatchedQ <em>undocumented</em>
 * @param incrementalORAvail <em>undocumented</em>
 * @param maxExpostCapacity <em>undocumented</em>
 * @param minExpostCapacity <em>undocumented</em>
 * @param noLoadCost <em>undocumented</em>
 * @param noLoadCostEligibilityFlag <em>undocumented</em>
 * @param startUpCost <em>undocumented</em>
 * @param startUpCostEligibilityFlag <em>undocumented</em>
 * @param AuxillaryCost <em>undocumented</em>
 * @param FiveMinAuxillaryData <em>undocumented</em>
 * @param TenMinAuxillaryData <em>undocumented</em>
 */
case class AuxiliaryValues
(
    override val sup: AuxiliaryObject,
    availUndispatchedQ: Double,
    incrementalORAvail: Double,
    maxExpostCapacity: Double,
    minExpostCapacity: Double,
    noLoadCost: Double,
    noLoadCostEligibilityFlag: String,
    startUpCost: Double,
    startUpCostEligibilityFlag: String,
    AuxillaryCost: String,
    FiveMinAuxillaryData: String,
    TenMinAuxillaryData: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, null, 0.0, null, null, null, null) }
    def AuxiliaryObject: AuxiliaryObject = sup.asInstanceOf[AuxiliaryObject]
    override def copy (): Row = { clone ().asInstanceOf[AuxiliaryValues] }
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
        "\t\t<cim:AuxiliaryValues.availUndispatchedQ>" + availUndispatchedQ + "</cim:AuxiliaryValues.availUndispatchedQ>\n" +
        "\t\t<cim:AuxiliaryValues.incrementalORAvail>" + incrementalORAvail + "</cim:AuxiliaryValues.incrementalORAvail>\n" +
        "\t\t<cim:AuxiliaryValues.maxExpostCapacity>" + maxExpostCapacity + "</cim:AuxiliaryValues.maxExpostCapacity>\n" +
        "\t\t<cim:AuxiliaryValues.minExpostCapacity>" + minExpostCapacity + "</cim:AuxiliaryValues.minExpostCapacity>\n" +
        "\t\t<cim:AuxiliaryValues.noLoadCost>" + noLoadCost + "</cim:AuxiliaryValues.noLoadCost>\n" +
        (if (null != noLoadCostEligibilityFlag) "\t\t<cim:AuxiliaryValues.noLoadCostEligibilityFlag rdf:resource=\"#" + noLoadCostEligibilityFlag + "\"/>\n" else "") +
        "\t\t<cim:AuxiliaryValues.startUpCost>" + startUpCost + "</cim:AuxiliaryValues.startUpCost>\n" +
        (if (null != startUpCostEligibilityFlag) "\t\t<cim:AuxiliaryValues.startUpCostEligibilityFlag rdf:resource=\"#" + startUpCostEligibilityFlag + "\"/>\n" else "") +
        (if (null != AuxillaryCost) "\t\t<cim:AuxiliaryValues.AuxillaryCost rdf:resource=\"#" + AuxillaryCost + "\"/>\n" else "") +
        (if (null != FiveMinAuxillaryData) "\t\t<cim:AuxiliaryValues.FiveMinAuxillaryData rdf:resource=\"#" + FiveMinAuxillaryData + "\"/>\n" else "") +
        (if (null != TenMinAuxillaryData) "\t\t<cim:AuxiliaryValues.TenMinAuxillaryData rdf:resource=\"#" + TenMinAuxillaryData + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AuxiliaryValues rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AuxiliaryValues>"
    }
}

object AuxiliaryValues
extends
    Parseable[AuxiliaryValues]
{
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
            AuxiliaryObject.parse (context),
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
 * @param intervalStartTime <em>undocumented</em>
 * @param updateTimeStamp <em>undocumented</em>
 * @param updateUser <em>undocumented</em>
 */
case class ExpectedEnergy
(
    override val sup: BasicElement,
    intervalStartTime: String,
    updateTimeStamp: String,
    updateUser: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ExpectedEnergy] }
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
        (if (null != intervalStartTime) "\t\t<cim:ExpectedEnergy.intervalStartTime>" + intervalStartTime + "</cim:ExpectedEnergy.intervalStartTime>\n" else "") +
        (if (null != updateTimeStamp) "\t\t<cim:ExpectedEnergy.updateTimeStamp>" + updateTimeStamp + "</cim:ExpectedEnergy.updateTimeStamp>\n" else "") +
        (if (null != updateUser) "\t\t<cim:ExpectedEnergy.updateUser>" + updateUser + "</cim:ExpectedEnergy.updateUser>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ExpectedEnergy rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ExpectedEnergy>"
    }
}

object ExpectedEnergy
extends
    Parseable[ExpectedEnergy]
{
    val intervalStartTime = parse_element (element ("""ExpectedEnergy.intervalStartTime"""))
    val updateTimeStamp = parse_element (element ("""ExpectedEnergy.updateTimeStamp"""))
    val updateUser = parse_element (element ("""ExpectedEnergy.updateUser"""))
    def parse (context: Context): ExpectedEnergy =
    {
        ExpectedEnergy(
            BasicElement.parse (context),
            intervalStartTime (context),
            updateTimeStamp (context),
            updateUser (context)
        )
    }
}

/**
 * Model Expected Energy  from Market Clearing
 * @param sup Reference to the superclass object.
 * @param energyTypeCode <em>undocumented</em>
 * @param expectedMwh <em>undocumented</em>
 * @param ExpectedEnergy <em>undocumented</em>
 * @param RegisteredResource <em>undocumented</em>
 */
case class ExpectedEnergyValues
(
    override val sup: BasicElement,
    energyTypeCode: String,
    expectedMwh: Double,
    ExpectedEnergy: String,
    RegisteredResource: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ExpectedEnergyValues] }
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
        (if (null != energyTypeCode) "\t\t<cim:ExpectedEnergyValues.energyTypeCode>" + energyTypeCode + "</cim:ExpectedEnergyValues.energyTypeCode>\n" else "") +
        "\t\t<cim:ExpectedEnergyValues.expectedMwh>" + expectedMwh + "</cim:ExpectedEnergyValues.expectedMwh>\n" +
        (if (null != ExpectedEnergy) "\t\t<cim:ExpectedEnergyValues.ExpectedEnergy rdf:resource=\"#" + ExpectedEnergy + "\"/>\n" else "") +
        (if (null != RegisteredResource) "\t\t<cim:ExpectedEnergyValues.RegisteredResource rdf:resource=\"#" + RegisteredResource + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ExpectedEnergyValues rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ExpectedEnergyValues>"
    }
}

object ExpectedEnergyValues
extends
    Parseable[ExpectedEnergyValues]
{
    val energyTypeCode = parse_element (element ("""ExpectedEnergyValues.energyTypeCode"""))
    val expectedMwh = parse_element (element ("""ExpectedEnergyValues.expectedMwh"""))
    val ExpectedEnergy = parse_attribute (attribute ("""ExpectedEnergyValues.ExpectedEnergy"""))
    val RegisteredResource = parse_attribute (attribute ("""ExpectedEnergyValues.RegisteredResource"""))
    def parse (context: Context): ExpectedEnergyValues =
    {
        ExpectedEnergyValues(
            BasicElement.parse (context),
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
 * @param intervalStartTime <em>undocumented</em>
 * @param updateTimeStamp <em>undocumented</em>
 * @param updateUser <em>undocumented</em>
 */
case class FiveMinAuxiliaryData
(
    override val sup: BasicElement,
    intervalStartTime: String,
    updateTimeStamp: String,
    updateUser: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[FiveMinAuxiliaryData] }
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
        (if (null != intervalStartTime) "\t\t<cim:FiveMinAuxiliaryData.intervalStartTime>" + intervalStartTime + "</cim:FiveMinAuxiliaryData.intervalStartTime>\n" else "") +
        (if (null != updateTimeStamp) "\t\t<cim:FiveMinAuxiliaryData.updateTimeStamp>" + updateTimeStamp + "</cim:FiveMinAuxiliaryData.updateTimeStamp>\n" else "") +
        (if (null != updateUser) "\t\t<cim:FiveMinAuxiliaryData.updateUser>" + updateUser + "</cim:FiveMinAuxiliaryData.updateUser>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:FiveMinAuxiliaryData rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:FiveMinAuxiliaryData>"
    }
}

object FiveMinAuxiliaryData
extends
    Parseable[FiveMinAuxiliaryData]
{
    val intervalStartTime = parse_element (element ("""FiveMinAuxiliaryData.intervalStartTime"""))
    val updateTimeStamp = parse_element (element ("""FiveMinAuxiliaryData.updateTimeStamp"""))
    val updateUser = parse_element (element ("""FiveMinAuxiliaryData.updateUser"""))
    def parse (context: Context): FiveMinAuxiliaryData =
    {
        FiveMinAuxiliaryData(
            BasicElement.parse (context),
            intervalStartTime (context),
            updateTimeStamp (context),
            updateUser (context)
        )
    }
}

/**
 * Models 10-Minutes Auxillary Data
 * @param sup Reference to the superclass object.
 * @param intervalStartTime <em>undocumented</em>
 * @param updateTimeStamp <em>undocumented</em>
 * @param updateUser <em>undocumented</em>
 */
case class TenMinAuxiliaryData
(
    override val sup: BasicElement,
    intervalStartTime: String,
    updateTimeStamp: String,
    updateUser: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[TenMinAuxiliaryData] }
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
        (if (null != intervalStartTime) "\t\t<cim:TenMinAuxiliaryData.intervalStartTime>" + intervalStartTime + "</cim:TenMinAuxiliaryData.intervalStartTime>\n" else "") +
        (if (null != updateTimeStamp) "\t\t<cim:TenMinAuxiliaryData.updateTimeStamp>" + updateTimeStamp + "</cim:TenMinAuxiliaryData.updateTimeStamp>\n" else "") +
        (if (null != updateUser) "\t\t<cim:TenMinAuxiliaryData.updateUser>" + updateUser + "</cim:TenMinAuxiliaryData.updateUser>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TenMinAuxiliaryData rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TenMinAuxiliaryData>"
    }
}

object TenMinAuxiliaryData
extends
    Parseable[TenMinAuxiliaryData]
{
    val intervalStartTime = parse_element (element ("""TenMinAuxiliaryData.intervalStartTime"""))
    val updateTimeStamp = parse_element (element ("""TenMinAuxiliaryData.updateTimeStamp"""))
    val updateUser = parse_element (element ("""TenMinAuxiliaryData.updateUser"""))
    def parse (context: Context): TenMinAuxiliaryData =
    {
        TenMinAuxiliaryData(
            BasicElement.parse (context),
            intervalStartTime (context),
            updateTimeStamp (context),
            updateUser (context)
        )
    }
}

/**
 * Models prices at Trading Hubs, interval based
 * @param sup Reference to the superclass object.
 * @param intervalStartTime <em>undocumented</em>
 * @param marketType <em>undocumented</em>
 * @param updateTimeStamp <em>undocumented</em>
 * @param updateUser <em>undocumented</em>
 */
case class TradingHubPrice
(
    override val sup: BasicElement,
    intervalStartTime: String,
    marketType: String,
    updateTimeStamp: String,
    updateUser: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[TradingHubPrice] }
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
        (if (null != intervalStartTime) "\t\t<cim:TradingHubPrice.intervalStartTime>" + intervalStartTime + "</cim:TradingHubPrice.intervalStartTime>\n" else "") +
        (if (null != marketType) "\t\t<cim:TradingHubPrice.marketType rdf:resource=\"#" + marketType + "\"/>\n" else "") +
        (if (null != updateTimeStamp) "\t\t<cim:TradingHubPrice.updateTimeStamp>" + updateTimeStamp + "</cim:TradingHubPrice.updateTimeStamp>\n" else "") +
        (if (null != updateUser) "\t\t<cim:TradingHubPrice.updateUser>" + updateUser + "</cim:TradingHubPrice.updateUser>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TradingHubPrice rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TradingHubPrice>"
    }
}

object TradingHubPrice
extends
    Parseable[TradingHubPrice]
{
    val intervalStartTime = parse_element (element ("""TradingHubPrice.intervalStartTime"""))
    val marketType = parse_attribute (attribute ("""TradingHubPrice.marketType"""))
    val updateTimeStamp = parse_element (element ("""TradingHubPrice.updateTimeStamp"""))
    val updateUser = parse_element (element ("""TradingHubPrice.updateUser"""))
    def parse (context: Context): TradingHubPrice =
    {
        TradingHubPrice(
            BasicElement.parse (context),
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
 * @param AggregatedPnode <em>undocumented</em>
 * @param TradingHubPrice <em>undocumented</em>
 */
case class TradingHubValues
(
    override val sup: BasicElement,
    price: Double,
    AggregatedPnode: String,
    TradingHubPrice: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[TradingHubValues] }
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
        "\t\t<cim:TradingHubValues.price>" + price + "</cim:TradingHubValues.price>\n" +
        (if (null != AggregatedPnode) "\t\t<cim:TradingHubValues.AggregatedPnode rdf:resource=\"#" + AggregatedPnode + "\"/>\n" else "") +
        (if (null != TradingHubPrice) "\t\t<cim:TradingHubValues.TradingHubPrice rdf:resource=\"#" + TradingHubPrice + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TradingHubValues rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TradingHubValues>"
    }
}

object TradingHubValues
extends
    Parseable[TradingHubValues]
{
    val price = parse_element (element ("""TradingHubValues.price"""))
    val AggregatedPnode = parse_attribute (attribute ("""TradingHubValues.AggregatedPnode"""))
    val TradingHubPrice = parse_attribute (attribute ("""TradingHubValues.TradingHubPrice"""))
    def parse (context: Context): TradingHubValues =
    {
        TradingHubValues(
            BasicElement.parse (context),
            toDouble (price (context), context),
            AggregatedPnode (context),
            TradingHubPrice (context)
        )
    }
}

private[ninecode] object _MarketQualitySystem
{
    def register: List[ClassInfo] =
    {
        List (
            AllocationResult.register,
            AllocationResultValues.register,
            AuxiliaryCost.register,
            AuxiliaryObject.register,
            AuxiliaryValues.register,
            ExpectedEnergy.register,
            ExpectedEnergyValues.register,
            FiveMinAuxiliaryData.register,
            TenMinAuxiliaryData.register,
            TradingHubPrice.register,
            TradingHubValues.register
        )
    }
}