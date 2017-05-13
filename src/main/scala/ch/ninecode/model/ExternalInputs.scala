package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * Inputs to the market system from external sources.
 */

/**
 * Models Ancillary Service Requirements.
 * Describes interval for which the requirement is applicable.
 * @param sup Reference to the superclass object.
 * @param intervalStartTime The start of the time interval for which requirement is defined.
 */
case class ASRequirements
(override val sup: BasicElement,
val intervalStartTime: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ASRequirements]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ASRequirements
extends
    Parseable[ASRequirements]
{
    val sup = BasicElement.parse _
    val intervalStartTime = parse_element (element ("""ASRequirements.intervalStartTime"""))_
    def parse (context: Context): ASRequirements =
    {
        ASRequirements(
            sup (context),
            intervalStartTime (context)
        )
    }
}

/**
 * Measurement quality flags for Analog Values.
 * @param sup Reference to the superclass object.
 * @param scadaQualityCode The quality code for the given Analog Value.
 * @param MktAnalogValue
 */
case class AnalogMeasurementValueQuality
(override val sup: MeasurementValueQuality,
val scadaQualityCode: String,
val MktAnalogValue: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def MeasurementValueQuality: MeasurementValueQuality = sup.asInstanceOf[MeasurementValueQuality]
    override def copy (): Row = { return (clone ().asInstanceOf[AnalogMeasurementValueQuality]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AnalogMeasurementValueQuality
extends
    Parseable[AnalogMeasurementValueQuality]
{
    val sup = MeasurementValueQuality.parse _
    val scadaQualityCode = parse_element (element ("""AnalogMeasurementValueQuality.scadaQualityCode"""))_
    val MktAnalogValue = parse_attribute (attribute ("""AnalogMeasurementValueQuality.MktAnalogValue"""))_
    def parse (context: Context): AnalogMeasurementValueQuality =
    {
        AnalogMeasurementValueQuality(
            sup (context),
            scadaQualityCode (context),
            MktAnalogValue (context)
        )
    }
}

/**
 * Area load curve definition.
 * @param sup Reference to the superclass object.
 * @param forecastType Load forecast area type.
 * @param AggregateNode
 * @param MktLoadArea
 * @param TACArea
 */
case class AreaLoadCurve
(override val sup: RegularIntervalSchedule,
val forecastType: String,
val AggregateNode: String,
val MktLoadArea: String,
val TACArea: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def RegularIntervalSchedule: RegularIntervalSchedule = sup.asInstanceOf[RegularIntervalSchedule]
    override def copy (): Row = { return (clone ().asInstanceOf[AreaLoadCurve]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AreaLoadCurve
extends
    Parseable[AreaLoadCurve]
{
    val sup = RegularIntervalSchedule.parse _
    val forecastType = parse_attribute (attribute ("""AreaLoadCurve.forecastType"""))_
    val AggregateNode = parse_attribute (attribute ("""AreaLoadCurve.AggregateNode"""))_
    val MktLoadArea = parse_attribute (attribute ("""AreaLoadCurve.MktLoadArea"""))_
    val TACArea = parse_attribute (attribute ("""AreaLoadCurve.TACArea"""))_
    def parse (context: Context): AreaLoadCurve =
    {
        AreaLoadCurve(
            sup (context),
            forecastType (context),
            AggregateNode (context),
            MktLoadArea (context),
            TACArea (context)
        )
    }
}

/**
 * Possibly time-varying max MW or MVA and optionally Min MW limit or MVA limit (Y1 and Y2, respectively) assigned to a contingency analysis base case.
 * Use CurveSchedule XAxisUnits to specify MW or MVA. To be used only if the BaseCaseConstraintLimit differs from the DefaultConstraintLimit.
 * @param sup Reference to the superclass object.
 * @param SecurityConstraintSum
 */
case class BaseCaseConstraintLimit
(override val sup: Curve,
val SecurityConstraintSum: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { return (clone ().asInstanceOf[BaseCaseConstraintLimit]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BaseCaseConstraintLimit
extends
    Parseable[BaseCaseConstraintLimit]
{
    val sup = Curve.parse _
    val SecurityConstraintSum = parse_attribute (attribute ("""BaseCaseConstraintLimit.SecurityConstraintSum"""))_
    def parse (context: Context): BaseCaseConstraintLimit =
    {
        BaseCaseConstraintLimit(
            sup (context),
            SecurityConstraintSum (context)
        )
    }
}

/**
 * Dynamic flows and ratings associated with a branch end.
 * @param sup Reference to the superclass object.
 * @param loadDumpRating The Load Dump Rating for the branch
 * @param longTermRating The Long Term Rating for the branch
 * @param mVARFlow The MVAR flow on the branch
 *        Attribute Usage: Reactive power flow at the series device, transformer, phase shifter, or line end
 * @param mwFlow The MW flow on the branch
 *        Attribute Usage: Active power flow at the series device, transformer, phase shifter, or line end
 * @param normalRating The Normal Rating for the branch
 * @param shortTermRating The Short Term Rating for the branch
 */
case class BranchEndFlow
(override val sup: BasicElement,
val loadDumpRating: Double,
val longTermRating: Double,
val mVARFlow: Double,
val mwFlow: Double,
val normalRating: Double,
val shortTermRating: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[BranchEndFlow]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BranchEndFlow
extends
    Parseable[BranchEndFlow]
{
    val sup = BasicElement.parse _
    val loadDumpRating = parse_element (element ("""BranchEndFlow.loadDumpRating"""))_
    val longTermRating = parse_element (element ("""BranchEndFlow.longTermRating"""))_
    val mVARFlow = parse_element (element ("""BranchEndFlow.mVARFlow"""))_
    val mwFlow = parse_element (element ("""BranchEndFlow.mwFlow"""))_
    val normalRating = parse_element (element ("""BranchEndFlow.normalRating"""))_
    val shortTermRating = parse_element (element ("""BranchEndFlow.shortTermRating"""))_
    def parse (context: Context): BranchEndFlow =
    {
        BranchEndFlow(
            sup (context),
            toDouble (loadDumpRating (context), context),
            toDouble (longTermRating (context), context),
            toDouble (mVARFlow (context), context),
            toDouble (mwFlow (context), context),
            toDouble (normalRating (context), context),
            toDouble (shortTermRating (context), context)
        )
    }
}

/**
 * A constraint term is one element of a linear constraint.
 * @param sup Reference to the superclass object.
 * @param factor
 * @param function The function is an enumerated value that can be 'active', 'reactive', or 'VA' to indicate the type of flow.
 * @param SecurityConstraintSum
 */
case class ConstraintTerm
(override val sup: IdentifiedObject,
val factor: String,
val function: String,
val SecurityConstraintSum: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ConstraintTerm]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ConstraintTerm
extends
    Parseable[ConstraintTerm]
{
    val sup = IdentifiedObject.parse _
    val factor = parse_element (element ("""ConstraintTerm.factor"""))_
    val function = parse_element (element ("""ConstraintTerm.function"""))_
    val SecurityConstraintSum = parse_attribute (attribute ("""ConstraintTerm.SecurityConstraintSum"""))_
    def parse (context: Context): ConstraintTerm =
    {
        ConstraintTerm(
            sup (context),
            factor (context),
            function (context),
            SecurityConstraintSum (context)
        )
    }
}

/**
 * Possibly time-varying max MW or MVA and optionally Min MW limit or MVA limit (Y1 and Y2, respectively) assigned to a constraint for a specific contingency.
 * Use CurveSchedule XAxisUnits to specify MW or MVA.
 * @param sup Reference to the superclass object.
 * @param MWLimitSchedules
 * @param MktContingency
 * @param SecurityConstraintSum
 */
case class ContingencyConstraintLimit
(override val sup: Curve,
val MWLimitSchedules: String,
val MktContingency: String,
val SecurityConstraintSum: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { return (clone ().asInstanceOf[ContingencyConstraintLimit]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ContingencyConstraintLimit
extends
    Parseable[ContingencyConstraintLimit]
{
    val sup = Curve.parse _
    val MWLimitSchedules = parse_attribute (attribute ("""ContingencyConstraintLimit.MWLimitSchedules"""))_
    val MktContingency = parse_attribute (attribute ("""ContingencyConstraintLimit.MktContingency"""))_
    val SecurityConstraintSum = parse_attribute (attribute ("""ContingencyConstraintLimit.SecurityConstraintSum"""))_
    def parse (context: Context): ContingencyConstraintLimit =
    {
        ContingencyConstraintLimit(
            sup (context),
            MWLimitSchedules (context),
            MktContingency (context),
            SecurityConstraintSum (context)
        )
    }
}

/**
 * State Estimator Solution Pool Interchange and Losses
 * @param sup Reference to the superclass object.
 * @param solvedInterchange Pool MW Interchange
 *        Attribute Usage: The active power interchange of the pool
 * @param solvedLosses Pool Losses MW
 *        Attribute Usage: The active power losses of the pool in MW
 * @param MktControlArea
 */
case class ControlAreaSolutionData
(override val sup: BasicElement,
val solvedInterchange: Double,
val solvedLosses: Double,
val MktControlArea: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ControlAreaSolutionData]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ControlAreaSolutionData
extends
    Parseable[ControlAreaSolutionData]
{
    val sup = BasicElement.parse _
    val solvedInterchange = parse_element (element ("""ControlAreaSolutionData.solvedInterchange"""))_
    val solvedLosses = parse_element (element ("""ControlAreaSolutionData.solvedLosses"""))_
    val MktControlArea = parse_attribute (attribute ("""ControlAreaSolutionData.MktControlArea"""))_
    def parse (context: Context): ControlAreaSolutionData =
    {
        ControlAreaSolutionData(
            sup (context),
            toDouble (solvedInterchange (context), context),
            toDouble (solvedLosses (context), context),
            MktControlArea (context)
        )
    }
}

/**
 * DefaultBid is a generic class to hold Default Energy Bid, Default Startup Bid, and Default Minimum Load Bid:

Default Energy Bid
A Default Energy Bid is a monotonically increasing staircase function consisting at maximum 10 economic bid segments, or 10 ($/MW, MW) pairs.
 * There are three methods for determining the Default Energy Bid:
 * @param sup Reference to the superclass object.
 * @param bidType Default bid type such as Default Energy Bid, Default Minimum Load Bid, and Default Startup Bid
 * @param minLoadCost Minimum load cost in $/hr
 * @param peakFlag on-peak, off-peak, or all
 * @param DefaultBidCurve
 * @param RegisteredResource
 */
case class DefaultBid
(override val sup: Bid,
val bidType: String,
val minLoadCost: Double,
val peakFlag: String,
val DefaultBidCurve: String,
val RegisteredResource: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, null, null, null) }
    def Bid: Bid = sup.asInstanceOf[Bid]
    override def copy (): Row = { return (clone ().asInstanceOf[DefaultBid]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DefaultBid
extends
    Parseable[DefaultBid]
{
    val sup = Bid.parse _
    val bidType = parse_attribute (attribute ("""DefaultBid.bidType"""))_
    val minLoadCost = parse_element (element ("""DefaultBid.minLoadCost"""))_
    val peakFlag = parse_attribute (attribute ("""DefaultBid.peakFlag"""))_
    val DefaultBidCurve = parse_attribute (attribute ("""DefaultBid.DefaultBidCurve"""))_
    val RegisteredResource = parse_attribute (attribute ("""DefaultBid.RegisteredResource"""))_
    def parse (context: Context): DefaultBid =
    {
        DefaultBid(
            sup (context),
            bidType (context),
            toDouble (minLoadCost (context), context),
            peakFlag (context),
            DefaultBidCurve (context),
            RegisteredResource (context)
        )
    }
}

/**
 * Default bid curve for default energy bid curve and default startup curves (cost and time)
 * @param sup Reference to the superclass object.
 * @param curveType To indicate a type used for a default energy bid curve, such as LMP, cost or consultative based.
 * @param debAdderFlag Default energy bid adder flag
 * @param DefaultBid
 */
case class DefaultBidCurve
(override val sup: Curve,
val curveType: String,
val debAdderFlag: String,
val DefaultBid: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { return (clone ().asInstanceOf[DefaultBidCurve]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DefaultBidCurve
extends
    Parseable[DefaultBidCurve]
{
    val sup = Curve.parse _
    val curveType = parse_element (element ("""DefaultBidCurve.curveType"""))_
    val debAdderFlag = parse_attribute (attribute ("""DefaultBidCurve.debAdderFlag"""))_
    val DefaultBid = parse_attribute (attribute ("""DefaultBidCurve.DefaultBid"""))_
    def parse (context: Context): DefaultBidCurve =
    {
        DefaultBidCurve(
            sup (context),
            curveType (context),
            debAdderFlag (context),
            DefaultBid (context)
        )
    }
}

/**
 * Curve data for default bid curve and startup cost curve.
 * @param sup Reference to the superclass object.
 * @param bidSegmentCalcType Type of calculation basis used to define the default bid segment curve.
 */
case class DefaultBidCurveData
(override val sup: CurveData,
val bidSegmentCalcType: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def CurveData: CurveData = sup.asInstanceOf[CurveData]
    override def copy (): Row = { return (clone ().asInstanceOf[DefaultBidCurveData]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DefaultBidCurveData
extends
    Parseable[DefaultBidCurveData]
{
    val sup = CurveData.parse _
    val bidSegmentCalcType = parse_attribute (attribute ("""DefaultBidCurveData.bidSegmentCalcType"""))_
    def parse (context: Context): DefaultBidCurveData =
    {
        DefaultBidCurveData(
            sup (context),
            bidSegmentCalcType (context)
        )
    }
}

/**
 * Possibly time-varying max MW or MVA and optionally Min MW limit or MVA limit (Y1 and Y2, respectively) applied as a default value if no specific constraint limits are specified for a contingency analysis.
 * Use CurveSchedule XAxisUnits to specify MW or MVA.
 * @param sup Reference to the superclass object.
 * @param SecurityConstraintSum
 */
case class DefaultConstraintLimit
(override val sup: Curve,
val SecurityConstraintSum: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { return (clone ().asInstanceOf[DefaultConstraintLimit]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DefaultConstraintLimit
extends
    Parseable[DefaultConstraintLimit]
{
    val sup = Curve.parse _
    val SecurityConstraintSum = parse_attribute (attribute ("""DefaultConstraintLimit.SecurityConstraintSum"""))_
    def parse (context: Context): DefaultConstraintLimit =
    {
        DefaultConstraintLimit(
            sup (context),
            SecurityConstraintSum (context)
        )
    }
}

/**
 * Measurement quality flags for Discrete Values.
 * @param sup Reference to the superclass object.
 * @param manualReplaceIndicator Switch Manual Replace Indicator.
 *        Flag indicating that the switch is manual replace.
 * @param removeFromOperationIndicator Removed From Operation Indicator.
 *        Flag indicating that the switch is removed from operation.
 * @param MktDiscreteValue
 */
case class DiscreteMeasurementValueQuality
(override val sup: MeasurementValueQuality,
val manualReplaceIndicator: Boolean,
val removeFromOperationIndicator: Boolean,
val MktDiscreteValue: String
)
extends
    Element
{
    def this () = { this (null, false, false, null) }
    def MeasurementValueQuality: MeasurementValueQuality = sup.asInstanceOf[MeasurementValueQuality]
    override def copy (): Row = { return (clone ().asInstanceOf[DiscreteMeasurementValueQuality]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DiscreteMeasurementValueQuality
extends
    Parseable[DiscreteMeasurementValueQuality]
{
    val sup = MeasurementValueQuality.parse _
    val manualReplaceIndicator = parse_element (element ("""DiscreteMeasurementValueQuality.manualReplaceIndicator"""))_
    val removeFromOperationIndicator = parse_element (element ("""DiscreteMeasurementValueQuality.removeFromOperationIndicator"""))_
    val MktDiscreteValue = parse_attribute (attribute ("""DiscreteMeasurementValueQuality.MktDiscreteValue"""))_
    def parse (context: Context): DiscreteMeasurementValueQuality =
    {
        DiscreteMeasurementValueQuality(
            sup (context),
            toBoolean (manualReplaceIndicator (context), context),
            toBoolean (removeFromOperationIndicator (context), context),
            MktDiscreteValue (context)
        )
    }
}

/**
 * A containing class that groups all the distribution factors within a market.
 * This is calculated daily for DA factors and hourly for RT factors.
 * @param sup Reference to the superclass object.
 * @param intervalEndTime The end of the time interval for which requirement is defined.
 * @param intervalStartTime The start of the time interval for which requirement is defined.
 * @param marketType
 * @param GenDistributionFactor
 * @param LoadDistributionFactor
 * @param SysLoadDistribuFactor
 */
case class DistributionFactorSet
(override val sup: BasicElement,
val intervalEndTime: String,
val intervalStartTime: String,
val marketType: String,
val GenDistributionFactor: List[String],
val LoadDistributionFactor: List[String],
val SysLoadDistribuFactor: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, null, List(), List(), List()) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[DistributionFactorSet]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DistributionFactorSet
extends
    Parseable[DistributionFactorSet]
{
    val sup = BasicElement.parse _
    val intervalEndTime = parse_element (element ("""DistributionFactorSet.intervalEndTime"""))_
    val intervalStartTime = parse_element (element ("""DistributionFactorSet.intervalStartTime"""))_
    val marketType = parse_attribute (attribute ("""DistributionFactorSet.marketType"""))_
    val GenDistributionFactor = parse_attributes (attribute ("""DistributionFactorSet.GenDistributionFactor"""))_
    val LoadDistributionFactor = parse_attributes (attribute ("""DistributionFactorSet.LoadDistributionFactor"""))_
    val SysLoadDistribuFactor = parse_attributes (attribute ("""DistributionFactorSet.SysLoadDistribuFactor"""))_
    def parse (context: Context): DistributionFactorSet =
    {
        DistributionFactorSet(
            sup (context),
            intervalEndTime (context),
            intervalStartTime (context),
            marketType (context),
            GenDistributionFactor (context),
            LoadDistributionFactor (context),
            SysLoadDistribuFactor (context)
        )
    }
}

/**
 * Optimal Power Flow or State Estimator Load Data for OTS.
 * This is used for RealTime, Study and Maintenance Users
 * @param sup Reference to the superclass object.
 * @param loadMVAR The MVAR load
 *        Attribute Usage: The reactive power consumption of the load in MW
 * @param loadMW The active power consumption of the load in MW
 * @param MktEnergyConsumer
 */
case class EnergyConsumerData
(override val sup: BasicElement,
val loadMVAR: Double,
val loadMW: Double,
val MktEnergyConsumer: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[EnergyConsumerData]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EnergyConsumerData
extends
    Parseable[EnergyConsumerData]
{
    val sup = BasicElement.parse _
    val loadMVAR = parse_element (element ("""EnergyConsumerData.loadMVAR"""))_
    val loadMW = parse_element (element ("""EnergyConsumerData.loadMW"""))_
    val MktEnergyConsumer = parse_attribute (attribute ("""EnergyConsumerData.MktEnergyConsumer"""))_
    def parse (context: Context): EnergyConsumerData =
    {
        EnergyConsumerData(
            sup (context),
            toDouble (loadMVAR (context), context),
            toDouble (loadMW (context), context),
            MktEnergyConsumer (context)
        )
    }
}

/**
 * An Energy Price Index for each Resource is valid for a period (e.g. daily) that is identified by a Valid Period Start Time and a Valid Period End Time.
 * An Energy Price Index is in $/MWh.
 * @param sup Reference to the superclass object.
 * @param endEffectiveDate End effective date
 * @param energyPriceIndex Energy price index
 * @param energyPriceIndexType EPI type such as wholesale or retail
 * @param lastModified Time updated
 * @param startEffectiveDate Start effective date
 * @param RegisteredGenerator
 */
case class EnergyPriceIndex
(override val sup: IdentifiedObject,
val endEffectiveDate: String,
val energyPriceIndex: Double,
val energyPriceIndexType: String,
val lastModified: String,
val startEffectiveDate: String,
val RegisteredGenerator: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[EnergyPriceIndex]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EnergyPriceIndex
extends
    Parseable[EnergyPriceIndex]
{
    val sup = IdentifiedObject.parse _
    val endEffectiveDate = parse_element (element ("""EnergyPriceIndex.endEffectiveDate"""))_
    val energyPriceIndex = parse_element (element ("""EnergyPriceIndex.energyPriceIndex"""))_
    val energyPriceIndexType = parse_attribute (attribute ("""EnergyPriceIndex.energyPriceIndexType"""))_
    val lastModified = parse_element (element ("""EnergyPriceIndex.lastModified"""))_
    val startEffectiveDate = parse_element (element ("""EnergyPriceIndex.startEffectiveDate"""))_
    val RegisteredGenerator = parse_attribute (attribute ("""EnergyPriceIndex.RegisteredGenerator"""))_
    def parse (context: Context): EnergyPriceIndex =
    {
        EnergyPriceIndex(
            sup (context),
            endEffectiveDate (context),
            toDouble (energyPriceIndex (context), context),
            energyPriceIndexType (context),
            lastModified (context),
            startEffectiveDate (context),
            RegisteredGenerator (context)
        )
    }
}

/**
 * Specifies the start time, stop time, level for an EnergyTransaction.
 * @param sup Reference to the superclass object.
 * @param EnergyTransaction An EnergyTransaction shall have at least one EnergyProfile.
 * @param TransactionBid
 */
case class EnergyProfile
(override val sup: Profile,
val EnergyTransaction: String,
val TransactionBid: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Profile: Profile = sup.asInstanceOf[Profile]
    override def copy (): Row = { return (clone ().asInstanceOf[EnergyProfile]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EnergyProfile
extends
    Parseable[EnergyProfile]
{
    val sup = Profile.parse _
    val EnergyTransaction = parse_attribute (attribute ("""EnergyProfile.EnergyTransaction"""))_
    val TransactionBid = parse_attribute (attribute ("""EnergyProfile.TransactionBid"""))_
    def parse (context: Context): EnergyProfile =
    {
        EnergyProfile(
            sup (context),
            EnergyTransaction (context),
            TransactionBid (context)
        )
    }
}

/**
 * Specifies the schedule for energy transfers between interchange areas that are necessary to satisfy the associated interchange transaction.
 * @param sup Reference to the superclass object.
 * @param capacityBacked Interchange capacity flag.
 *        When the flag is set to true, it indicates a transaction is capacity backed.
 * @param congestChargeMax Maximum congestion charges in monetary units.
 * @param deliveryPointP Delivery point active power.
 * @param energyMin Transaction minimum active power if dispatchable.
 * @param firmInterchangeFlag Firm interchange flag indicates whether or not this energy transaction can be changed without potential financial consequences.
 * @param payCongestion Willing to Pay congestion flag
 * @param reason Reason for energy transaction.
 * @param receiptPointP Receipt point active power.
 * @param state { Approve | Deny | Study }
 * @param EnergyPriceCurves
 * @param EnergyProduct The "Source" for an EnergyTransaction is an EnergyProduct which is injected into a ControlArea.
 *        Typically this is a ServicePoint.
 * @param Export_SubControlArea Energy is transferred between interchange areas
 * @param Import_SubControlArea Energy is transferred between interchange areas
 * @param TransmissionReservation
 */
case class EnergyTransaction
(override val sup: Document,
val capacityBacked: Boolean,
val congestChargeMax: Double,
val deliveryPointP: Double,
val energyMin: Double,
val firmInterchangeFlag: Boolean,
val payCongestion: Boolean,
val reason: String,
val receiptPointP: Double,
val state: String,
val EnergyPriceCurves: List[String],
val EnergyProduct: String,
val Export_SubControlArea: String,
val Import_SubControlArea: String,
val TransmissionReservation: String
)
extends
    Element
{
    def this () = { this (null, false, 0.0, 0.0, 0.0, false, false, null, 0.0, null, List(), null, null, null, null) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { return (clone ().asInstanceOf[EnergyTransaction]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EnergyTransaction
extends
    Parseable[EnergyTransaction]
{
    val sup = Document.parse _
    val capacityBacked = parse_element (element ("""EnergyTransaction.capacityBacked"""))_
    val congestChargeMax = parse_element (element ("""EnergyTransaction.congestChargeMax"""))_
    val deliveryPointP = parse_element (element ("""EnergyTransaction.deliveryPointP"""))_
    val energyMin = parse_element (element ("""EnergyTransaction.energyMin"""))_
    val firmInterchangeFlag = parse_element (element ("""EnergyTransaction.firmInterchangeFlag"""))_
    val payCongestion = parse_element (element ("""EnergyTransaction.payCongestion"""))_
    val reason = parse_element (element ("""EnergyTransaction.reason"""))_
    val receiptPointP = parse_element (element ("""EnergyTransaction.receiptPointP"""))_
    val state = parse_attribute (attribute ("""EnergyTransaction.state"""))_
    val EnergyPriceCurves = parse_attributes (attribute ("""EnergyTransaction.EnergyPriceCurves"""))_
    val EnergyProduct = parse_attribute (attribute ("""EnergyTransaction.EnergyProduct"""))_
    val Export_SubControlArea = parse_attribute (attribute ("""EnergyTransaction.Export_SubControlArea"""))_
    val Import_SubControlArea = parse_attribute (attribute ("""EnergyTransaction.Import_SubControlArea"""))_
    val TransmissionReservation = parse_attribute (attribute ("""EnergyTransaction.TransmissionReservation"""))_
    def parse (context: Context): EnergyTransaction =
    {
        EnergyTransaction(
            sup (context),
            toBoolean (capacityBacked (context), context),
            toDouble (congestChargeMax (context), context),
            toDouble (deliveryPointP (context), context),
            toDouble (energyMin (context), context),
            toBoolean (firmInterchangeFlag (context), context),
            toBoolean (payCongestion (context), context),
            reason (context),
            toDouble (receiptPointP (context), context),
            state (context),
            EnergyPriceCurves (context),
            EnergyProduct (context),
            Export_SubControlArea (context),
            Import_SubControlArea (context),
            TransmissionReservation (context)
        )
    }
}

/**
 * This class models the generation distribution factors.
 * This class needs to be used along with the AggregatedPnode and the IndividualPnode to show the distriubtion of each individual party.
 * @param sup Reference to the superclass object.
 * @param factor Used to calculate generation "participation" of an individual pnond in an AggregatePnode.
 * @param AggregatedPnode
 * @param IndividualPnode
 */
case class GenDistributionFactor
(override val sup: BasicElement,
val factor: Double,
val AggregatedPnode: String,
val IndividualPnode: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[GenDistributionFactor]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GenDistributionFactor
extends
    Parseable[GenDistributionFactor]
{
    val sup = BasicElement.parse _
    val factor = parse_element (element ("""GenDistributionFactor.factor"""))_
    val AggregatedPnode = parse_attribute (attribute ("""GenDistributionFactor.AggregatedPnode"""))_
    val IndividualPnode = parse_attribute (attribute ("""GenDistributionFactor.IndividualPnode"""))_
    def parse (context: Context): GenDistributionFactor =
    {
        GenDistributionFactor(
            sup (context),
            toDouble (factor (context), context),
            AggregatedPnode (context),
            IndividualPnode (context)
        )
    }
}

/**
 * Optimal Power Flow or State Estimator Unit Data for Operator Training Simulator.
 * This is used for RealTime, Study and Maintenance Users
 * @param sup Reference to the superclass object.
 * @param lossFactor Loss Factor
 * @param mVAR Unit reactive power generation in MVAR
 * @param maximumMW The maximum active power generation of the unit in MW
 * @param minimumMW The minimum active power generation of the unit in MW
 * @param mw Unit active power generation in MW
 * @param sensitivity Unit sencivity factor.
 *        The distribution factors (DFAX) for the unit
 * @param Flowgate
 * @param MktGeneratingUnit
 */
case class GeneratingUnitDynamicValues
(override val sup: BasicElement,
val lossFactor: Double,
val mVAR: Double,
val maximumMW: Double,
val minimumMW: Double,
val mw: Double,
val sensitivity: Double,
val Flowgate: String,
val MktGeneratingUnit: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[GeneratingUnitDynamicValues]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GeneratingUnitDynamicValues
extends
    Parseable[GeneratingUnitDynamicValues]
{
    val sup = BasicElement.parse _
    val lossFactor = parse_element (element ("""GeneratingUnitDynamicValues.lossFactor"""))_
    val mVAR = parse_element (element ("""GeneratingUnitDynamicValues.mVAR"""))_
    val maximumMW = parse_element (element ("""GeneratingUnitDynamicValues.maximumMW"""))_
    val minimumMW = parse_element (element ("""GeneratingUnitDynamicValues.minimumMW"""))_
    val mw = parse_element (element ("""GeneratingUnitDynamicValues.mw"""))_
    val sensitivity = parse_element (element ("""GeneratingUnitDynamicValues.sensitivity"""))_
    val Flowgate = parse_attribute (attribute ("""GeneratingUnitDynamicValues.Flowgate"""))_
    val MktGeneratingUnit = parse_attribute (attribute ("""GeneratingUnitDynamicValues.MktGeneratingUnit"""))_
    def parse (context: Context): GeneratingUnitDynamicValues =
    {
        GeneratingUnitDynamicValues(
            sup (context),
            toDouble (lossFactor (context), context),
            toDouble (mVAR (context), context),
            toDouble (maximumMW (context), context),
            toDouble (minimumMW (context), context),
            toDouble (mw (context), context),
            toDouble (sensitivity (context), context),
            Flowgate (context),
            MktGeneratingUnit (context)
        )
    }
}

/**
 * Generic constraints can represent secure areas, voltage profile, transient stability and voltage collapse limits.
 * The generic constraints can be one of the following forms:
 * @param sup Reference to the superclass object.
 * @param intervalEndTime Interval End Time
 * @param intervalStartTime Interval Start Time
 * @param maxLimit Maximum Limit (MW)
 * @param minLimit Minimum Limit (MW)
 */
case class GenericConstraints
(override val sup: IdentifiedObject,
val intervalEndTime: String,
val intervalStartTime: String,
val maxLimit: Double,
val minLimit: Double
)
extends
    Element
{
    def this () = { this (null, null, null, 0.0, 0.0) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[GenericConstraints]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GenericConstraints
extends
    Parseable[GenericConstraints]
{
    val sup = IdentifiedObject.parse _
    val intervalEndTime = parse_element (element ("""GenericConstraints.intervalEndTime"""))_
    val intervalStartTime = parse_element (element ("""GenericConstraints.intervalStartTime"""))_
    val maxLimit = parse_element (element ("""GenericConstraints.maxLimit"""))_
    val minLimit = parse_element (element ("""GenericConstraints.minLimit"""))_
    def parse (context: Context): GenericConstraints =
    {
        GenericConstraints(
            sup (context),
            intervalEndTime (context),
            intervalStartTime (context),
            toDouble (maxLimit (context), context),
            toDouble (minLimit (context), context)
        )
    }
}

/**
 * Existing Transmission Contract data for an interchange schedule
 * @param sup Reference to the superclass object.
 * @param contractNumber Existing transmission contract number
 * @param usageMW Existing transmission contract usage MW value
 * @param InterchangeSchedule
 */
case class InterchangeETCData
(override val sup: BasicElement,
val contractNumber: String,
val usageMW: Double,
val InterchangeSchedule: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[InterchangeETCData]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object InterchangeETCData
extends
    Parseable[InterchangeETCData]
{
    val sup = BasicElement.parse _
    val contractNumber = parse_element (element ("""InterchangeETCData.contractNumber"""))_
    val usageMW = parse_element (element ("""InterchangeETCData.usageMW"""))_
    val InterchangeSchedule = parse_attribute (attribute ("""InterchangeETCData.InterchangeSchedule"""))_
    def parse (context: Context): InterchangeETCData =
    {
        InterchangeETCData(
            sup (context),
            contractNumber (context),
            toDouble (usageMW (context), context),
            InterchangeSchedule (context)
        )
    }
}

/**
 * Interchange schedule class to hold information for interchange schedules such as import export type, energy type, and etc.
 * @param sup Reference to the superclass object.
 * @param checkOutType To indicate a check out type such as adjusted capacity or dispatch capacity.
 * @param directionType Import or export.
 * @param energyType Energy product type.
 * @param intervalLength Interval length.
 * @param marketType Market type.
 * @param operatingDate Operating date, hour.
 * @param outOfMarketType To indicate an out-of-market (OOM) schedule.
 * @param scheduleType Schedule type.
 * @param wcrID Wheeling Counter-Resource ID (required when Schedule Type=Wheel).
 * @param InterTie
 * @param RegisteredInterTie
 */
case class InterchangeSchedule
(override val sup: Curve,
val checkOutType: String,
val directionType: String,
val energyType: String,
val intervalLength: Int,
val marketType: String,
val operatingDate: String,
val outOfMarketType: Boolean,
val scheduleType: String,
val wcrID: String,
val InterTie: String,
val RegisteredInterTie: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, 0, null, null, false, null, null, null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { return (clone ().asInstanceOf[InterchangeSchedule]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object InterchangeSchedule
extends
    Parseable[InterchangeSchedule]
{
    val sup = Curve.parse _
    val checkOutType = parse_attribute (attribute ("""InterchangeSchedule.checkOutType"""))_
    val directionType = parse_attribute (attribute ("""InterchangeSchedule.directionType"""))_
    val energyType = parse_attribute (attribute ("""InterchangeSchedule.energyType"""))_
    val intervalLength = parse_element (element ("""InterchangeSchedule.intervalLength"""))_
    val marketType = parse_attribute (attribute ("""InterchangeSchedule.marketType"""))_
    val operatingDate = parse_element (element ("""InterchangeSchedule.operatingDate"""))_
    val outOfMarketType = parse_element (element ("""InterchangeSchedule.outOfMarketType"""))_
    val scheduleType = parse_attribute (attribute ("""InterchangeSchedule.scheduleType"""))_
    val wcrID = parse_element (element ("""InterchangeSchedule.wcrID"""))_
    val InterTie = parse_attribute (attribute ("""InterchangeSchedule.InterTie"""))_
    val RegisteredInterTie = parse_attribute (attribute ("""InterchangeSchedule.RegisteredInterTie"""))_
    def parse (context: Context): InterchangeSchedule =
    {
        InterchangeSchedule(
            sup (context),
            checkOutType (context),
            directionType (context),
            energyType (context),
            toInteger (intervalLength (context), context),
            marketType (context),
            operatingDate (context),
            toBoolean (outOfMarketType (context), context),
            scheduleType (context),
            wcrID (context),
            InterTie (context),
            RegisteredInterTie (context)
        )
    }
}

/**
 * Indicates whether unit is eligible for treatment as a intermittent variable renewable resource
 * @param sup Reference to the superclass object.
 * @param eligibilityStatus Indicates whether a resource is eligible for PIRP program for a given hour
 * @param RegisteredResource
 */
case class IntermittentResourceEligibility
(override val sup: MarketFactors,
val eligibilityStatus: String,
val RegisteredResource: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { return (clone ().asInstanceOf[IntermittentResourceEligibility]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object IntermittentResourceEligibility
extends
    Parseable[IntermittentResourceEligibility]
{
    val sup = MarketFactors.parse _
    val eligibilityStatus = parse_element (element ("""IntermittentResourceEligibility.eligibilityStatus"""))_
    val RegisteredResource = parse_attribute (attribute ("""IntermittentResourceEligibility.RegisteredResource"""))_
    def parse (context: Context): IntermittentResourceEligibility =
    {
        IntermittentResourceEligibility(
            sup (context),
            eligibilityStatus (context),
            RegisteredResource (context)
        )
    }
}

/**
 * This class models the load distribution factors.
 * This class should be used in one of two ways:
 * @param sup Reference to the superclass object.
 * @param pDistFactor Real power (MW) load distribution factor
 * @param qDistFactor Reactive power (MVAr) load distribution factor
 * @param AggregatedPnode
 * @param IndividualPnode
 */
case class LoadDistributionFactor
(override val sup: BasicElement,
val pDistFactor: Double,
val qDistFactor: Double,
val AggregatedPnode: String,
val IndividualPnode: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[LoadDistributionFactor]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object LoadDistributionFactor
extends
    Parseable[LoadDistributionFactor]
{
    val sup = BasicElement.parse _
    val pDistFactor = parse_element (element ("""LoadDistributionFactor.pDistFactor"""))_
    val qDistFactor = parse_element (element ("""LoadDistributionFactor.qDistFactor"""))_
    val AggregatedPnode = parse_attribute (attribute ("""LoadDistributionFactor.AggregatedPnode"""))_
    val IndividualPnode = parse_attribute (attribute ("""LoadDistributionFactor.IndividualPnode"""))_
    def parse (context: Context): LoadDistributionFactor =
    {
        LoadDistributionFactor(
            sup (context),
            toDouble (pDistFactor (context), context),
            toDouble (qDistFactor (context), context),
            AggregatedPnode (context),
            IndividualPnode (context)
        )
    }
}

/**
 * Loss sensitivity applied to a ConnectivityNode for a given time interval.
 * @param sup Reference to the superclass object.
 * @param lossFactor Loss penalty factor.
 *        Defined as: 1 / ( 1 - Incremental Transmission Loss); with the Incremental Transmission Loss expressed as a plus or minus value. The typical range of penalty factors is (0,9 to 1,1).
 * @param MktConnectivityNode
 */
case class LossSensitivity
(override val sup: MarketFactors,
val lossFactor: Double,
val MktConnectivityNode: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null) }
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { return (clone ().asInstanceOf[LossSensitivity]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object LossSensitivity
extends
    Parseable[LossSensitivity]
{
    val sup = MarketFactors.parse _
    val lossFactor = parse_element (element ("""LossSensitivity.lossFactor"""))_
    val MktConnectivityNode = parse_attribute (attribute ("""LossSensitivity.MktConnectivityNode"""))_
    def parse (context: Context): LossSensitivity =
    {
        LossSensitivity(
            sup (context),
            toDouble (lossFactor (context), context),
            MktConnectivityNode (context)
        )
    }
}

/**
 * Maximum MW and optionally Minimum MW (Y1 and Y2, respectively)
 * @param sup Reference to the superclass object.
 * @param SecurityConstraintLimit
 */
case class MWLimitSchedule
(override val sup: BasicElement,
val SecurityConstraintLimit: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[MWLimitSchedule]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MWLimitSchedule
extends
    Parseable[MWLimitSchedule]
{
    val sup = BasicElement.parse _
    val SecurityConstraintLimit = parse_attribute (attribute ("""MWLimitSchedule.SecurityConstraintLimit"""))_
    def parse (context: Context): MWLimitSchedule =
    {
        MWLimitSchedule(
            sup (context),
            SecurityConstraintLimit (context)
        )
    }
}

/**
 * Subclass of IEC61970:Wires:ACLineSegment
 * @param sup Reference to the superclass object.
 * @param EndAFlow
 * @param EndBFlow
 */
case class MktACLineSegment
(override val sup: ACLineSegment,
val EndAFlow: String,
val EndBFlow: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def ACLineSegment: ACLineSegment = sup.asInstanceOf[ACLineSegment]
    override def copy (): Row = { return (clone ().asInstanceOf[MktACLineSegment]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MktACLineSegment
extends
    Parseable[MktACLineSegment]
{
    val sup = ACLineSegment.parse _
    val EndAFlow = parse_attribute (attribute ("""MktACLineSegment.EndAFlow"""))_
    val EndBFlow = parse_attribute (attribute ("""MktACLineSegment.EndBFlow"""))_
    def parse (context: Context): MktACLineSegment =
    {
        MktACLineSegment(
            sup (context),
            EndAFlow (context),
            EndBFlow (context)
        )
    }
}

/**
 * Subclass of IEC61970:Meas:AnalogLimit
 * @param sup Reference to the superclass object.
 * @param exceededLimit true if limit exceeded
 * @param limitType The type of limit the value represents
Branch Limit Types:
Short Term
Medium Term
Long Term
Voltage Limits:
High
 *        Low
 */
case class MktAnalogLimit
(override val sup: AnalogLimit,
val exceededLimit: Boolean,
val limitType: String
)
extends
    Element
{
    def this () = { this (null, false, null) }
    def AnalogLimit: AnalogLimit = sup.asInstanceOf[AnalogLimit]
    override def copy (): Row = { return (clone ().asInstanceOf[MktAnalogLimit]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MktAnalogLimit
extends
    Parseable[MktAnalogLimit]
{
    val sup = AnalogLimit.parse _
    val exceededLimit = parse_element (element ("""MktAnalogLimit.exceededLimit"""))_
    val limitType = parse_attribute (attribute ("""MktAnalogLimit.limitType"""))_
    def parse (context: Context): MktAnalogLimit =
    {
        MktAnalogLimit(
            sup (context),
            toBoolean (exceededLimit (context), context),
            limitType (context)
        )
    }
}

/**
 * Subclass of IEC61970:Meas:AnalogLimitSet
 * @param sup Reference to the superclass object.
 * @param ratingSet Rating set numbers
 */
case class MktAnalogLimitSet
(override val sup: AnalogLimitSet,
val ratingSet: Int
)
extends
    Element
{
    def this () = { this (null, 0) }
    def AnalogLimitSet: AnalogLimitSet = sup.asInstanceOf[AnalogLimitSet]
    override def copy (): Row = { return (clone ().asInstanceOf[MktAnalogLimitSet]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MktAnalogLimitSet
extends
    Parseable[MktAnalogLimitSet]
{
    val sup = AnalogLimitSet.parse _
    val ratingSet = parse_element (element ("""MktAnalogLimitSet.ratingSet"""))_
    def parse (context: Context): MktAnalogLimitSet =
    {
        MktAnalogLimitSet(
            sup (context),
            toInteger (ratingSet (context), context)
        )
    }
}

/**
 * Subclass of IEC61970:Meas:AnalogValue
 * @param sup Reference to the superclass object.
 */
case class MktAnalogValue
(override val sup: AnalogValue
)
extends
    Element
{
    def this () = { this (null) }
    def AnalogValue: AnalogValue = sup.asInstanceOf[AnalogValue]
    override def copy (): Row = { return (clone ().asInstanceOf[MktAnalogValue]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MktAnalogValue
extends
    Parseable[MktAnalogValue]
{
    val sup = AnalogValue.parse _
    def parse (context: Context): MktAnalogValue =
    {
        MktAnalogValue(
            sup (context)
        )
    }
}

/**
 * Market subclass of IEC61970:ControlArea
 * @param sup Reference to the superclass object.
 */
case class MktControlArea
(override val sup: ControlArea
)
extends
    Element
{
    def this () = { this (null) }
    def ControlArea: ControlArea = sup.asInstanceOf[ControlArea]
    override def copy (): Row = { return (clone ().asInstanceOf[MktControlArea]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MktControlArea
extends
    Parseable[MktControlArea]
{
    val sup = ControlArea.parse _
    def parse (context: Context): MktControlArea =
    {
        MktControlArea(
            sup (context)
        )
    }
}

/**
 * Subclass of IEC61970:Meas:DiscreteValue
 * @param sup Reference to the superclass object.
 */
case class MktDiscreteValue
(override val sup: DiscreteValue
)
extends
    Element
{
    def this () = { this (null) }
    def DiscreteValue: DiscreteValue = sup.asInstanceOf[DiscreteValue]
    override def copy (): Row = { return (clone ().asInstanceOf[MktDiscreteValue]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MktDiscreteValue
extends
    Parseable[MktDiscreteValue]
{
    val sup = DiscreteValue.parse _
    def parse (context: Context): MktDiscreteValue =
    {
        MktDiscreteValue(
            sup (context)
        )
    }
}

/**
 * Subclass of IEC61970:Wires:SeriesCompensator
 * @param sup Reference to the superclass object.
 * @param EndAFlow
 * @param EndBFlow
 */
case class MktSeriesCompensator
(override val sup: SeriesCompensator,
val EndAFlow: String,
val EndBFlow: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def SeriesCompensator: SeriesCompensator = sup.asInstanceOf[SeriesCompensator]
    override def copy (): Row = { return (clone ().asInstanceOf[MktSeriesCompensator]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MktSeriesCompensator
extends
    Parseable[MktSeriesCompensator]
{
    val sup = SeriesCompensator.parse _
    val EndAFlow = parse_attribute (attribute ("""MktSeriesCompensator.EndAFlow"""))_
    val EndBFlow = parse_attribute (attribute ("""MktSeriesCompensator.EndBFlow"""))_
    def parse (context: Context): MktSeriesCompensator =
    {
        MktSeriesCompensator(
            sup (context),
            EndAFlow (context),
            EndBFlow (context)
        )
    }
}

/**
 * Subclass of IEC61970:Wires:ShuntCompensator
 * @param sup Reference to the superclass object.
 */
case class MktShuntCompensator
(override val sup: ShuntCompensator
)
extends
    Element
{
    def this () = { this (null) }
    def ShuntCompensator: ShuntCompensator = sup.asInstanceOf[ShuntCompensator]
    override def copy (): Row = { return (clone ().asInstanceOf[MktShuntCompensator]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MktShuntCompensator
extends
    Parseable[MktShuntCompensator]
{
    val sup = ShuntCompensator.parse _
    def parse (context: Context): MktShuntCompensator =
    {
        MktShuntCompensator(
            sup (context)
        )
    }
}

/**
 * Subclass of IEC61970:Wires:Switch
 * @param sup Reference to the superclass object.
 */
case class MktSwitch
(override val sup: Switch
)
extends
    Element
{
    def this () = { this (null) }
    def Switch: Switch = sup.asInstanceOf[Switch]
    override def copy (): Row = { return (clone ().asInstanceOf[MktSwitch]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MktSwitch
extends
    Parseable[MktSwitch]
{
    val sup = Switch.parse _
    def parse (context: Context): MktSwitch =
    {
        MktSwitch(
            sup (context)
        )
    }
}

/**
 * Subclass of IEC61970:Wires:TapChanger
 * @param sup Reference to the superclass object.
 */
case class MktTapChanger
(override val sup: TapChanger
)
extends
    Element
{
    def this () = { this (null) }
    def TapChanger: TapChanger = sup.asInstanceOf[TapChanger]
    override def copy (): Row = { return (clone ().asInstanceOf[MktTapChanger]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MktTapChanger
extends
    Parseable[MktTapChanger]
{
    val sup = TapChanger.parse _
    def parse (context: Context): MktTapChanger =
    {
        MktTapChanger(
            sup (context)
        )
    }
}

/**
 * To be used only to constrain a quantity that cannot be associated with a terminal.
 * For example, a registered generating unit that is not electrically connected to the network.
 * @param sup Reference to the superclass object.
 * @param MktConnectivityNode
 */
case class NodeConstraintTerm
(override val sup: ConstraintTerm,
val MktConnectivityNode: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def ConstraintTerm: ConstraintTerm = sup.asInstanceOf[ConstraintTerm]
    override def copy (): Row = { return (clone ().asInstanceOf[NodeConstraintTerm]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object NodeConstraintTerm
extends
    Parseable[NodeConstraintTerm]
{
    val sup = ConstraintTerm.parse _
    val MktConnectivityNode = parse_attribute (attribute ("""NodeConstraintTerm.MktConnectivityNode"""))_
    def parse (context: Context): NodeConstraintTerm =
    {
        NodeConstraintTerm(
            sup (context),
            MktConnectivityNode (context)
        )
    }
}

/**
 * A profile is a simpler curve type.
 * @param sup Reference to the superclass object.
 */
case class Profile
(override val sup: IdentifiedObject
)
extends
    Element
{
    def this () = { this (null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Profile]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Profile
extends
    Parseable[Profile]
{
    val sup = IdentifiedObject.parse _
    def parse (context: Context): Profile =
    {
        Profile(
            sup (context)
        )
    }
}

/**
 * Data for profile.
 * @param sup Reference to the superclass object.
 * @param bidPrice Bid price associated with contract
 * @param capacityLevel Capacity level for the profile, in MW.
 * @param energyLevel Energy level for the profile, in MWH.
 * @param minimumLevel Minimum MW value of contract
 * @param sequenceNumber Sequence to provide item numbering for the profile. { greater than or equal to 1 }
 * @param startDateTime Start date/time for this profile.
 * @param stopDateTime Stop date/time for this profile.
 * @param Profile A profile has profile data associated with it.
 */
case class ProfileData
(override val sup: BasicElement,
val bidPrice: Double,
val capacityLevel: Double,
val energyLevel: Double,
val minimumLevel: Double,
val sequenceNumber: Int,
val startDateTime: String,
val stopDateTime: String,
val Profile: List[String]
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0, null, null, List()) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ProfileData]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ProfileData
extends
    Parseable[ProfileData]
{
    val sup = BasicElement.parse _
    val bidPrice = parse_element (element ("""ProfileData.bidPrice"""))_
    val capacityLevel = parse_element (element ("""ProfileData.capacityLevel"""))_
    val energyLevel = parse_element (element ("""ProfileData.energyLevel"""))_
    val minimumLevel = parse_element (element ("""ProfileData.minimumLevel"""))_
    val sequenceNumber = parse_element (element ("""ProfileData.sequenceNumber"""))_
    val startDateTime = parse_element (element ("""ProfileData.startDateTime"""))_
    val stopDateTime = parse_element (element ("""ProfileData.stopDateTime"""))_
    val Profile = parse_attributes (attribute ("""ProfileData.Profile"""))_
    def parse (context: Context): ProfileData =
    {
        ProfileData(
            sup (context),
            toDouble (bidPrice (context), context),
            toDouble (capacityLevel (context), context),
            toDouble (energyLevel (context), context),
            toDouble (minimumLevel (context), context),
            toInteger (sequenceNumber (context), context),
            startDateTime (context),
            stopDateTime (context),
            Profile (context)
        )
    }
}

/**
 * Reserve demand curve.
 * Models maximum quantities of reserve required per Market Region and models a reserve demand curve for the minimum quantities of reserve. The ReserveDemandCurve is a relationship between unit operating reserve price in $/MWhr (Y-axis) and unit reserves in MW (X-axis).
 * @param sup Reference to the superclass object.
 * @param reqMaxMW Region requirement maximum limit
 * @param reserveRequirementType Reserve requirement type that the max and curve apply to.
 *        For example, operating reserve, regulation and contingency.
 * @param ASRequirements
 * @param MarketRegion
 */
case class ReserveDemandCurve
(override val sup: Curve,
val reqMaxMW: Double,
val reserveRequirementType: String,
val ASRequirements: String,
val MarketRegion: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { return (clone ().asInstanceOf[ReserveDemandCurve]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ReserveDemandCurve
extends
    Parseable[ReserveDemandCurve]
{
    val sup = Curve.parse _
    val reqMaxMW = parse_element (element ("""ReserveDemandCurve.reqMaxMW"""))_
    val reserveRequirementType = parse_attribute (attribute ("""ReserveDemandCurve.reserveRequirementType"""))_
    val ASRequirements = parse_attribute (attribute ("""ReserveDemandCurve.ASRequirements"""))_
    val MarketRegion = parse_attribute (attribute ("""ReserveDemandCurve.MarketRegion"""))_
    def parse (context: Context): ReserveDemandCurve =
    {
        ReserveDemandCurve(
            sup (context),
            toDouble (reqMaxMW (context), context),
            reserveRequirementType (context),
            ASRequirements (context),
            MarketRegion (context)
        )
    }
}

/**
 * Contains information about the update from SCADA
 * @param sup Reference to the superclass object.
 * @param timeStamp time of the update from SCADA
 */
case class SCADAInformation
(override val sup: BasicElement,
val timeStamp: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[SCADAInformation]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SCADAInformation
extends
    Parseable[SCADAInformation]
{
    val sup = BasicElement.parse _
    val timeStamp = parse_element (element ("""SCADAInformation.timeStamp"""))_
    def parse (context: Context): SCADAInformation =
    {
        SCADAInformation(
            sup (context),
            timeStamp (context)
        )
    }
}

/**
 * Typically provided by RTO systems, constraints identified in both base case and critical contingency cases have to be transferred.
 * A constraint has N (&gt;=1) constraint terms. A term is represented by an
 * @param sup Reference to the superclass object.
 * @param BaseCaseConstraintLimit
 * @param DefaultConstraintLimit
 * @param RTO
 */
case class SecurityConstraintSum
(override val sup: MarketFactors,
val BaseCaseConstraintLimit: String,
val DefaultConstraintLimit: String,
val RTO: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { return (clone ().asInstanceOf[SecurityConstraintSum]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SecurityConstraintSum
extends
    Parseable[SecurityConstraintSum]
{
    val sup = MarketFactors.parse _
    val BaseCaseConstraintLimit = parse_attribute (attribute ("""SecurityConstraintSum.BaseCaseConstraintLimit"""))_
    val DefaultConstraintLimit = parse_attribute (attribute ("""SecurityConstraintSum.DefaultConstraintLimit"""))_
    val RTO = parse_attribute (attribute ("""SecurityConstraintSum.RTO"""))_
    def parse (context: Context): SecurityConstraintSum =
    {
        SecurityConstraintSum(
            sup (context),
            BaseCaseConstraintLimit (context),
            DefaultConstraintLimit (context),
            RTO (context)
        )
    }
}

/**
 * Typical for regional transmission operators (RTOs), these constraints include transmission as well as generation group constraints identified in both base case and critical contingency cases.
 * @param sup Reference to the superclass object.
 * @param actualMW Actual branch or group of branches MW flow (only for transmission constraints)
 * @param maxMW Maximum MW limit
 * @param minMW Minimum MW limit (only for transmission constraints).
 * @param Flowgate
 * @param GeneratingBid
 * @param RTO
 */
case class SecurityConstraints
(override val sup: IdentifiedObject,
val actualMW: Double,
val maxMW: Double,
val minMW: Double,
val Flowgate: String,
val GeneratingBid: String,
val RTO: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[SecurityConstraints]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SecurityConstraints
extends
    Parseable[SecurityConstraints]
{
    val sup = IdentifiedObject.parse _
    val actualMW = parse_element (element ("""SecurityConstraints.actualMW"""))_
    val maxMW = parse_element (element ("""SecurityConstraints.maxMW"""))_
    val minMW = parse_element (element ("""SecurityConstraints.minMW"""))_
    val Flowgate = parse_attribute (attribute ("""SecurityConstraints.Flowgate"""))_
    val GeneratingBid = parse_attribute (attribute ("""SecurityConstraints.GeneratingBid"""))_
    val RTO = parse_attribute (attribute ("""SecurityConstraints.RTO"""))_
    def parse (context: Context): SecurityConstraints =
    {
        SecurityConstraints(
            sup (context),
            toDouble (actualMW (context), context),
            toDouble (maxMW (context), context),
            toDouble (minMW (context), context),
            Flowgate (context),
            GeneratingBid (context),
            RTO (context)
        )
    }
}

/**
 * The defined termination points of a transmission path (down to distribution level or to a customer - generation or consumption or both).
 * Service points are defined from the viewpoint of the transmission service. Each service point is contained within (or on the boundary of) an interchange area. A service point is source or destination of a transaction.
 * @param sup Reference to the superclass object.
 */
case class ServicePoint
(override val sup: IdentifiedObject
)
extends
    Element
{
    def this () = { this (null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ServicePoint]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ServicePoint
extends
    Parseable[ServicePoint]
{
    val sup = IdentifiedObject.parse _
    def parse (context: Context): ServicePoint =
    {
        ServicePoint(
            sup (context)
        )
    }
}

/**
 * Optimal Power Flow or State Estimator Filter Bank Data for OTS.
 * This is used for RealTime, Study and Maintenance Users
 * @param sup Reference to the superclass object.
 * @param connectionStatus The current status for the Voltage Control Capacitor 1= Connected 0 = Disconnected
 * @param desiredVoltage The desired voltage for the Voltage Control Capacitor
 * @param mVARInjection The injection of reactive power of the filter bank in the NA solution or VCS reactive power production
 * @param stepPosition Voltage control capacitor step position
 * @param voltageRegulationStatus Indicator if the voltage control this is regulating True = Yes, False = No
 * @param MktShuntCompensator
 */
case class ShuntCompensatorDynamicData
(override val sup: BasicElement,
val connectionStatus: Int,
val desiredVoltage: Double,
val mVARInjection: Double,
val stepPosition: Int,
val voltageRegulationStatus: Boolean,
val MktShuntCompensator: String
)
extends
    Element
{
    def this () = { this (null, 0, 0.0, 0.0, 0, false, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ShuntCompensatorDynamicData]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ShuntCompensatorDynamicData
extends
    Parseable[ShuntCompensatorDynamicData]
{
    val sup = BasicElement.parse _
    val connectionStatus = parse_element (element ("""ShuntCompensatorDynamicData.connectionStatus"""))_
    val desiredVoltage = parse_element (element ("""ShuntCompensatorDynamicData.desiredVoltage"""))_
    val mVARInjection = parse_element (element ("""ShuntCompensatorDynamicData.mVARInjection"""))_
    val stepPosition = parse_element (element ("""ShuntCompensatorDynamicData.stepPosition"""))_
    val voltageRegulationStatus = parse_element (element ("""ShuntCompensatorDynamicData.voltageRegulationStatus"""))_
    val MktShuntCompensator = parse_attribute (attribute ("""ShuntCompensatorDynamicData.MktShuntCompensator"""))_
    def parse (context: Context): ShuntCompensatorDynamicData =
    {
        ShuntCompensatorDynamicData(
            sup (context),
            toInteger (connectionStatus (context), context),
            toDouble (desiredVoltage (context), context),
            toDouble (mVARInjection (context), context),
            toInteger (stepPosition (context), context),
            toBoolean (voltageRegulationStatus (context), context),
            MktShuntCompensator (context)
        )
    }
}

/**
 * Optimal Power Flow or State Estimator Circuit Breaker Status.
 * @param sup Reference to the superclass object.
 * @param switchStatus Circuit Breaker Status (closed or open) of the circuit breaker from the power flow.
 * @param MktSwitch
 */
case class SwitchStatus
(override val sup: BasicElement,
val switchStatus: String,
val MktSwitch: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[SwitchStatus]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SwitchStatus
extends
    Parseable[SwitchStatus]
{
    val sup = BasicElement.parse _
    val switchStatus = parse_attribute (attribute ("""SwitchStatus.switchStatus"""))_
    val MktSwitch = parse_attribute (attribute ("""SwitchStatus.MktSwitch"""))_
    def parse (context: Context): SwitchStatus =
    {
        SwitchStatus(
            sup (context),
            switchStatus (context),
            MktSwitch (context)
        )
    }
}

/**
 * This class models the system distribution factors.
 * This class needs to be used along with the HostControlArea and the ConnectivityNode to show the distribution of each individual party.
 * @param sup Reference to the superclass object.
 * @param factor Used to calculate load "participation" of a connectivity node in an host control area
 * @param HostControlArea
 * @param MktConnectivityNode
 */
case class SysLoadDistributionFactor
(override val sup: BasicElement,
val factor: Double,
val HostControlArea: String,
val MktConnectivityNode: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[SysLoadDistributionFactor]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SysLoadDistributionFactor
extends
    Parseable[SysLoadDistributionFactor]
{
    val sup = BasicElement.parse _
    val factor = parse_element (element ("""SysLoadDistributionFactor.factor"""))_
    val HostControlArea = parse_attribute (attribute ("""SysLoadDistributionFactor.HostControlArea"""))_
    val MktConnectivityNode = parse_attribute (attribute ("""SysLoadDistributionFactor.MktConnectivityNode"""))_
    def parse (context: Context): SysLoadDistributionFactor =
    {
        SysLoadDistributionFactor(
            sup (context),
            toDouble (factor (context), context),
            HostControlArea (context),
            MktConnectivityNode (context)
        )
    }
}

/**
 * A Transmission Right(TR) can be a chain of TR's or on individual.
 * When a transmission right is not a chain, this is formally the ETC/TOR Entitlement for each ETC/TOR contract with the inclusion of CVR(Converted Rights) as an ETC. This is the sum of all entitlements on all related transmission interfaces for the same TR.
 * @param sup Reference to the superclass object.
 * @param entitlement The entitlement
 * @param startOperatingDate Operating date and hour when the entitlement applies
 * @param TransmissionContractRight
 */
case class TREntitlement
(override val sup: BasicElement,
val entitlement: Double,
val startOperatingDate: String,
val TransmissionContractRight: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[TREntitlement]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TREntitlement
extends
    Parseable[TREntitlement]
{
    val sup = BasicElement.parse _
    val entitlement = parse_element (element ("""TREntitlement.entitlement"""))_
    val startOperatingDate = parse_element (element ("""TREntitlement.startOperatingDate"""))_
    val TransmissionContractRight = parse_attribute (attribute ("""TREntitlement.TransmissionContractRight"""))_
    def parse (context: Context): TREntitlement =
    {
        TREntitlement(
            sup (context),
            toDouble (entitlement (context), context),
            startOperatingDate (context),
            TransmissionContractRight (context)
        )
    }
}

/**
 * Optimal Power Flow or State Estimator Phase Shifter Data.
 * This is used for RealTime, Study and Maintenance Users. SE Solution Phase Shifter Measurements from the last run of SE
 * @param sup Reference to the superclass object.
 * @param angleRegulationStatus True means the phase shifter is regulating.
 * @param desiredMW Phase Shifter Desired MW.
 *        The active power regulation setpoint of the phase shifter
 * @param desiredVoltage The desired voltage for the LTC
 * @param maximumAngle The maximum phase angle shift of the phase shifter
 * @param minimumAngle The minimum phase angle shift of the phase shifter
 * @param solvedAngle Phase Shifter Angle.
 *        The solved phase angle shift of the phase shifter
 * @param tapPosition Tap position of the phase shifter, high-side tap position of the transformer, or  low-side tap position of the transformer
 * @param voltageRegulationStatus Indicator if the LTC transformer is regulating True = Yes, False = No
 * @param MktTapChanger
 */
case class TapChangerDynamicData
(override val sup: BasicElement,
val angleRegulationStatus: Boolean,
val desiredMW: Double,
val desiredVoltage: Double,
val maximumAngle: Double,
val minimumAngle: Double,
val solvedAngle: Double,
val tapPosition: Double,
val voltageRegulationStatus: Boolean,
val MktTapChanger: String
)
extends
    Element
{
    def this () = { this (null, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[TapChangerDynamicData]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TapChangerDynamicData
extends
    Parseable[TapChangerDynamicData]
{
    val sup = BasicElement.parse _
    val angleRegulationStatus = parse_element (element ("""TapChangerDynamicData.angleRegulationStatus"""))_
    val desiredMW = parse_element (element ("""TapChangerDynamicData.desiredMW"""))_
    val desiredVoltage = parse_element (element ("""TapChangerDynamicData.desiredVoltage"""))_
    val maximumAngle = parse_element (element ("""TapChangerDynamicData.maximumAngle"""))_
    val minimumAngle = parse_element (element ("""TapChangerDynamicData.minimumAngle"""))_
    val solvedAngle = parse_element (element ("""TapChangerDynamicData.solvedAngle"""))_
    val tapPosition = parse_element (element ("""TapChangerDynamicData.tapPosition"""))_
    val voltageRegulationStatus = parse_element (element ("""TapChangerDynamicData.voltageRegulationStatus"""))_
    val MktTapChanger = parse_attribute (attribute ("""TapChangerDynamicData.MktTapChanger"""))_
    def parse (context: Context): TapChangerDynamicData =
    {
        TapChangerDynamicData(
            sup (context),
            toBoolean (angleRegulationStatus (context), context),
            toDouble (desiredMW (context), context),
            toDouble (desiredVoltage (context), context),
            toDouble (maximumAngle (context), context),
            toDouble (minimumAngle (context), context),
            toDouble (solvedAngle (context), context),
            toDouble (tapPosition (context), context),
            toBoolean (voltageRegulationStatus (context), context),
            MktTapChanger (context)
        )
    }
}

/**
 * A constraint term associated with a specific terminal on a physical piece of equipment.
 * @param sup Reference to the superclass object.
 * @param MktTerminal
 */
case class TerminalConstraintTerm
(override val sup: ConstraintTerm,
val MktTerminal: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def ConstraintTerm: ConstraintTerm = sup.asInstanceOf[ConstraintTerm]
    override def copy (): Row = { return (clone ().asInstanceOf[TerminalConstraintTerm]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TerminalConstraintTerm
extends
    Parseable[TerminalConstraintTerm]
{
    val sup = ConstraintTerm.parse _
    val MktTerminal = parse_attribute (attribute ("""TerminalConstraintTerm.MktTerminal"""))_
    def parse (context: Context): TerminalConstraintTerm =
    {
        TerminalConstraintTerm(
            sup (context),
            MktTerminal (context)
        )
    }
}

/**
 * A Transfer Interface is made up of branches such as transmission lines and transformers.
 * @param sup Reference to the superclass object.
 * @param HostControlArea
 * @param TransferInterfaceSolution
 */
case class TransferInterface
(override val sup: IdentifiedObject,
val HostControlArea: String,
val TransferInterfaceSolution: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[TransferInterface]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TransferInterface
extends
    Parseable[TransferInterface]
{
    val sup = IdentifiedObject.parse _
    val HostControlArea = parse_attribute (attribute ("""TransferInterface.HostControlArea"""))_
    val TransferInterfaceSolution = parse_attribute (attribute ("""TransferInterface.TransferInterfaceSolution"""))_
    def parse (context: Context): TransferInterface =
    {
        TransferInterface(
            sup (context),
            HostControlArea (context),
            TransferInterfaceSolution (context)
        )
    }
}

/**
 * TNA Interface Definitions from OPF for VSA
 * @param sup Reference to the superclass object.
 * @param interfaceMargin The margin for the interface
 * @param postTransferMW Post Transfer MW for step
 * @param transferLimit Transfer Interface + Limit 
Attribute Usage: The absoloute of the maximum flow on the transfer interface.
 *        This is a positive MW value.
 * @param MktContingencyB
 * @param TransferInterface
 * @param _MktContingencyA
 */
case class TransferInterfaceSolution
(override val sup: BasicElement,
val interfaceMargin: Double,
val postTransferMW: Double,
val transferLimit: Double,
val MktContingencyB: String,
val TransferInterface: String,
val _MktContingencyA: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[TransferInterfaceSolution]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TransferInterfaceSolution
extends
    Parseable[TransferInterfaceSolution]
{
    val sup = BasicElement.parse _
    val interfaceMargin = parse_element (element ("""TransferInterfaceSolution.interfaceMargin"""))_
    val postTransferMW = parse_element (element ("""TransferInterfaceSolution.postTransferMW"""))_
    val transferLimit = parse_element (element ("""TransferInterfaceSolution.transferLimit"""))_
    val MktContingencyB = parse_attribute (attribute ("""TransferInterfaceSolution.MktContingencyB"""))_
    val TransferInterface = parse_attribute (attribute ("""TransferInterfaceSolution.TransferInterface"""))_
    val _MktContingencyA = parse_attribute (attribute ("""TransferInterfaceSolution. MktContingencyA"""))_
    def parse (context: Context): TransferInterfaceSolution =
    {
        TransferInterfaceSolution(
            sup (context),
            toDouble (interfaceMargin (context), context),
            toDouble (postTransferMW (context), context),
            toDouble (transferLimit (context), context),
            MktContingencyB (context),
            TransferInterface (context),
            _MktContingencyA (context)
        )
    }
}

/**
 * This class models the transmission (either a transmission interface or a POR/POD pair) capacity including Total Transfer Capacity (TTC), Operating Transfer Capacity (OTC), and Capacity Benefit Margin (CBM)
 * @param sup Reference to the superclass object.
 * @param capacityBenefitMargin Capacity Benefit Margin (CBM) is used by Markets to calculate the transmission interface limits.
 *        This number could be manually or procedurally determined. The CBM is defined per transmission interface (branch group).
 * @param operationalTransmissionCapacity The Operational Transmission Capacity (OTC) is the transmission capacity under the operating condition during a specific time period, incorporating the effects of derates and current settings of operation controls.
 *        The OTCs for all transmission interface (branch group) are always provided regardless of outage or switching conditions.
 * @param startOperatingDate Operating date &amp; hour when the entitlement applies
 * @param totalTransmissionCapacity Total Transmission Capacity
 * @param Flowgate
 * @param GenericConstraints
 * @param OTC15min_emergency The Operational Transmission Capacity (OTC) 15 minute Emergency Limit
 * @param OTCemergency The Operational Transmission Capacity (OTC) Emergency Limit.
 * @param POD point of delivery
 * @param POR point of receipt
 */
case class TransmissionCapacity
(override val sup: BasicElement,
val capacityBenefitMargin: Double,
val operationalTransmissionCapacity: Double,
val startOperatingDate: String,
val totalTransmissionCapacity: Double,
val Flowgate: String,
val GenericConstraints: String,
val OTC15min_emergency: Double,
val OTCemergency: Double,
val POD: String,
val POR: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null, 0.0, null, null, 0.0, 0.0, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[TransmissionCapacity]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TransmissionCapacity
extends
    Parseable[TransmissionCapacity]
{
    val sup = BasicElement.parse _
    val capacityBenefitMargin = parse_element (element ("""TransmissionCapacity.capacityBenefitMargin"""))_
    val operationalTransmissionCapacity = parse_element (element ("""TransmissionCapacity.operationalTransmissionCapacity"""))_
    val startOperatingDate = parse_element (element ("""TransmissionCapacity.startOperatingDate"""))_
    val totalTransmissionCapacity = parse_element (element ("""TransmissionCapacity.totalTransmissionCapacity"""))_
    val Flowgate = parse_attribute (attribute ("""TransmissionCapacity.Flowgate"""))_
    val GenericConstraints = parse_attribute (attribute ("""TransmissionCapacity.GenericConstraints"""))_
    val OTC15min_emergency = parse_element (element ("""TransmissionCapacity.OTC15min_emergency"""))_
    val OTCemergency = parse_element (element ("""TransmissionCapacity.OTCemergency"""))_
    val POD = parse_element (element ("""TransmissionCapacity.POD"""))_
    val POR = parse_element (element ("""TransmissionCapacity.POR"""))_
    def parse (context: Context): TransmissionCapacity =
    {
        TransmissionCapacity(
            sup (context),
            toDouble (capacityBenefitMargin (context), context),
            toDouble (operationalTransmissionCapacity (context), context),
            startOperatingDate (context),
            toDouble (totalTransmissionCapacity (context), context),
            Flowgate (context),
            GenericConstraints (context),
            toDouble (OTC15min_emergency (context), context),
            toDouble (OTCemergency (context), context),
            POD (context),
            POR (context)
        )
    }
}

/**
 * This is formally called the branch group ETC/TOR entitlement with the inclusion of CVR as ETC.
 * Is used to represent the entitlements. This could be also used to represent the TR entitlement on a POR/POD.
 * @param sup Reference to the superclass object.
 * @param entitlement the entitlement
 * @param startOperatingDate Operating date and hour when the entitlement applies
 * @param ContractRight
 * @param Flowgate
 * @param POD point of delivery
 * @param POR point of receipt
 */
case class TransmissionInterfaceRightEntitlement
(override val sup: BasicElement,
val entitlement: Double,
val startOperatingDate: String,
val ContractRight: String,
val Flowgate: String,
val POD: String,
val POR: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[TransmissionInterfaceRightEntitlement]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TransmissionInterfaceRightEntitlement
extends
    Parseable[TransmissionInterfaceRightEntitlement]
{
    val sup = BasicElement.parse _
    val entitlement = parse_element (element ("""TransmissionInterfaceRightEntitlement.entitlement"""))_
    val startOperatingDate = parse_element (element ("""TransmissionInterfaceRightEntitlement.startOperatingDate"""))_
    val ContractRight = parse_attribute (attribute ("""TransmissionInterfaceRightEntitlement.ContractRight"""))_
    val Flowgate = parse_attribute (attribute ("""TransmissionInterfaceRightEntitlement.Flowgate"""))_
    val POD = parse_element (element ("""TransmissionInterfaceRightEntitlement.POD"""))_
    val POR = parse_element (element ("""TransmissionInterfaceRightEntitlement.POR"""))_
    def parse (context: Context): TransmissionInterfaceRightEntitlement =
    {
        TransmissionInterfaceRightEntitlement(
            sup (context),
            toDouble (entitlement (context), context),
            startOperatingDate (context),
            ContractRight (context),
            Flowgate (context),
            POD (context),
            POR (context)
        )
    }
}

/**
 * An electrical connection, link, or line consisting of one or more parallel transmission elements between two areas of the interconnected electric systems, or portions thereof.
 * TransmissionCorridor and TransmissionRightOfWay refer to legal aspects. The TransmissionPath refers to the segments between a TransmissionProvider's ServicePoints.
 * @param sup Reference to the superclass object.
 * @param availTransferCapability The available transmission capability of a transmission path for the reference direction.
 * @param parallelPathFlag Flag which indicates if the transmission path is also a designated interconnection "parallel path".
 * @param totalTransferCapability The total transmission capability of a transmission path in the reference direction.
 * @param DeliveryPoint A transmission path has a "point-of-delivery" service point
 * @param For A TransmissionPath is contained in a TransmissionCorridor.
 * @param PointOfReceipt A transmission path has a "point-of-receipt" service point
 */
case class TransmissionPath
(override val sup: IdentifiedObject,
val availTransferCapability: Double,
val parallelPathFlag: Boolean,
val totalTransferCapability: Double,
val DeliveryPoint: String,
val For: String,
val PointOfReceipt: String
)
extends
    Element
{
    def this () = { this (null, 0.0, false, 0.0, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[TransmissionPath]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TransmissionPath
extends
    Parseable[TransmissionPath]
{
    val sup = IdentifiedObject.parse _
    val availTransferCapability = parse_element (element ("""TransmissionPath.availTransferCapability"""))_
    val parallelPathFlag = parse_element (element ("""TransmissionPath.parallelPathFlag"""))_
    val totalTransferCapability = parse_element (element ("""TransmissionPath.totalTransferCapability"""))_
    val DeliveryPoint = parse_attribute (attribute ("""TransmissionPath.DeliveryPoint"""))_
    val For = parse_attribute (attribute ("""TransmissionPath.For"""))_
    val PointOfReceipt = parse_attribute (attribute ("""TransmissionPath.PointOfReceipt"""))_
    def parse (context: Context): TransmissionPath =
    {
        TransmissionPath(
            sup (context),
            toDouble (availTransferCapability (context), context),
            toBoolean (parallelPathFlag (context), context),
            toDouble (totalTransferCapability (context), context),
            DeliveryPoint (context),
            For (context),
            PointOfReceipt (context)
        )
    }
}

/**
 * A transmission reservation is obtained from the OASIS system to reserve transmission for a specified time period, transmission path and transmission product.
 * @param sup Reference to the superclass object.
 * @param EnergyTransaction
 * @param Sink
 * @param Source
 * @param TransactionBid
 * @param TransmissionPath
 */
case class TransmissionReservation
(override val sup: BasicElement,
val EnergyTransaction: String,
val Sink: String,
val Source: String,
val TransactionBid: String,
val TransmissionPath: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[TransmissionReservation]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TransmissionReservation
extends
    Parseable[TransmissionReservation]
{
    val sup = BasicElement.parse _
    val EnergyTransaction = parse_attribute (attribute ("""TransmissionReservation.EnergyTransaction"""))_
    val Sink = parse_attribute (attribute ("""TransmissionReservation.Sink"""))_
    val Source = parse_attribute (attribute ("""TransmissionReservation.Source"""))_
    val TransactionBid = parse_attribute (attribute ("""TransmissionReservation.TransactionBid"""))_
    val TransmissionPath = parse_attribute (attribute ("""TransmissionReservation.TransmissionPath"""))_
    def parse (context: Context): TransmissionReservation =
    {
        TransmissionReservation(
            sup (context),
            EnergyTransaction (context),
            Sink (context),
            Source (context),
            TransactionBid (context),
            TransmissionPath (context)
        )
    }
}

/**
 * Resource status at the end of a given clearing period.
 * @param sup Reference to the superclass object.
 * @param cumEnergy Cumulative energy production over trading period.
 * @param cumStatusChanges Cumulative number of status changes of the resource.
 * @param numberOfStartups Number of start ups in the Operating Day until the end of previous hour.
 * @param onlineStatus 'true' if the GeneratingUnit is currently On-Line
 * @param resourceMW Resource MW output at the end of previous clearing period.
 * @param resourceStatus Resource status at the end of previous clearing period:
0 - off-line
1 - on-line production
2 - in shutdown process
 *        3 - in startup process
 * @param statusDate Time and date for resourceStatus
 * @param timeInStatus Time in market trading intervals the resource is in the state as of the end of the previous clearing period.
 * @param timeInterval Time interval
 * @param GeneratingUnit
 */
case class UnitInitialConditions
(override val sup: IdentifiedObject,
val cumEnergy: Double,
val cumStatusChanges: Int,
val numberOfStartups: Int,
val onlineStatus: Boolean,
val resourceMW: Double,
val resourceStatus: Int,
val statusDate: String,
val timeInStatus: Double,
val timeInterval: String,
val GeneratingUnit: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0, 0, false, 0.0, 0, null, 0.0, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[UnitInitialConditions]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object UnitInitialConditions
extends
    Parseable[UnitInitialConditions]
{
    val sup = IdentifiedObject.parse _
    val cumEnergy = parse_element (element ("""UnitInitialConditions.cumEnergy"""))_
    val cumStatusChanges = parse_element (element ("""UnitInitialConditions.cumStatusChanges"""))_
    val numberOfStartups = parse_element (element ("""UnitInitialConditions.numberOfStartups"""))_
    val onlineStatus = parse_element (element ("""UnitInitialConditions.onlineStatus"""))_
    val resourceMW = parse_element (element ("""UnitInitialConditions.resourceMW"""))_
    val resourceStatus = parse_element (element ("""UnitInitialConditions.resourceStatus"""))_
    val statusDate = parse_element (element ("""UnitInitialConditions.statusDate"""))_
    val timeInStatus = parse_element (element ("""UnitInitialConditions.timeInStatus"""))_
    val timeInterval = parse_element (element ("""UnitInitialConditions.timeInterval"""))_
    val GeneratingUnit = parse_attribute (attribute ("""UnitInitialConditions.GeneratingUnit"""))_
    def parse (context: Context): UnitInitialConditions =
    {
        UnitInitialConditions(
            sup (context),
            toDouble (cumEnergy (context), context),
            toInteger (cumStatusChanges (context), context),
            toInteger (numberOfStartups (context), context),
            toBoolean (onlineStatus (context), context),
            toDouble (resourceMW (context), context),
            toInteger (resourceStatus (context), context),
            statusDate (context),
            toDouble (timeInStatus (context), context),
            timeInterval (context),
            GeneratingUnit (context)
        )
    }
}

object _ExternalInputs
{
    def register: Unit =
    {
        ASRequirements.register
        AnalogMeasurementValueQuality.register
        AreaLoadCurve.register
        BaseCaseConstraintLimit.register
        BranchEndFlow.register
        ConstraintTerm.register
        ContingencyConstraintLimit.register
        ControlAreaSolutionData.register
        DefaultBid.register
        DefaultBidCurve.register
        DefaultBidCurveData.register
        DefaultConstraintLimit.register
        DiscreteMeasurementValueQuality.register
        DistributionFactorSet.register
        EnergyConsumerData.register
        EnergyPriceIndex.register
        EnergyProfile.register
        EnergyTransaction.register
        GenDistributionFactor.register
        GeneratingUnitDynamicValues.register
        GenericConstraints.register
        InterchangeETCData.register
        InterchangeSchedule.register
        IntermittentResourceEligibility.register
        LoadDistributionFactor.register
        LossSensitivity.register
        MWLimitSchedule.register
        MktACLineSegment.register
        MktAnalogLimit.register
        MktAnalogLimitSet.register
        MktAnalogValue.register
        MktControlArea.register
        MktDiscreteValue.register
        MktSeriesCompensator.register
        MktShuntCompensator.register
        MktSwitch.register
        MktTapChanger.register
        NodeConstraintTerm.register
        Profile.register
        ProfileData.register
        ReserveDemandCurve.register
        SCADAInformation.register
        SecurityConstraintSum.register
        SecurityConstraints.register
        ServicePoint.register
        ShuntCompensatorDynamicData.register
        SwitchStatus.register
        SysLoadDistributionFactor.register
        TREntitlement.register
        TapChangerDynamicData.register
        TerminalConstraintTerm.register
        TransferInterface.register
        TransferInterfaceSolution.register
        TransmissionCapacity.register
        TransmissionInterfaceRightEntitlement.register
        TransmissionPath.register
        TransmissionReservation.register
        UnitInitialConditions.register
    }
}