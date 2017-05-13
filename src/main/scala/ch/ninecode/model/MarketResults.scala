package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * Results from the execution of a market.
 */

/**
 * Model of results of market clearing with respect to  Ancillary Service products
 */
case class AncillaryServiceClearing
(

    override val sup: MarketFactors,

    val MarketCaseClearing: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { return (clone ().asInstanceOf[AncillaryServiceClearing]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AncillaryServiceClearing
extends
    Parseable[AncillaryServiceClearing]
{
    val sup = MarketFactors.parse _
    val MarketCaseClearing = parse_attribute (attribute ("""AncillaryServiceClearing.MarketCaseClearing"""))_
    def parse (context: Context): AncillaryServiceClearing =
    {
        AncillaryServiceClearing(
            sup (context),
            MarketCaseClearing (context)
        )
    }
}

/**
 * Model various charges to support billing and settlement of
 */
case class BillDeterminant
(

    override val sup: Document,

    /**
     * Level in charge calculation order.
     */
    val calculationLevel: String,

    /**
     * The version of configuration of calculation logic in the settlement.
     */
    val configVersion: String,

    val deleteStatus: String,

    val effectiveDate: String,

    val exception: String,

    val factor: String,

    val frequency: String,

    /**
     * Number of intervals of bill determiant in trade day, eg 300 for five minute intervals.
     */
    val numberInterval: Int,

    val offset: String,

    /**
     * The level of precision in the current value.
     */
    val precisionLevel: String,

    val primaryYN: String,

    val referenceFlag: String,

    val reportable: String,

    val roundOff: String,

    val source: String,

    val terminationDate: String,

    /**
     * The UOM for the current value of the Bill Determinant.
     */
    val unitOfMeasure: String,

    val ChargeProfile: String,

    val MktUserAttribute: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, List()) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { return (clone ().asInstanceOf[BillDeterminant]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BillDeterminant
extends
    Parseable[BillDeterminant]
{
    val sup = Document.parse _
    val calculationLevel = parse_element (element ("""BillDeterminant.calculationLevel"""))_
    val configVersion = parse_element (element ("""BillDeterminant.configVersion"""))_
    val deleteStatus = parse_element (element ("""BillDeterminant.deleteStatus"""))_
    val effectiveDate = parse_element (element ("""BillDeterminant.effectiveDate"""))_
    val exception = parse_element (element ("""BillDeterminant.exception"""))_
    val factor = parse_element (element ("""BillDeterminant.factor"""))_
    val frequency = parse_element (element ("""BillDeterminant.frequency"""))_
    val numberInterval = parse_element (element ("""BillDeterminant.numberInterval"""))_
    val offset = parse_element (element ("""BillDeterminant.offset"""))_
    val precisionLevel = parse_element (element ("""BillDeterminant.precisionLevel"""))_
    val primaryYN = parse_element (element ("""BillDeterminant.primaryYN"""))_
    val referenceFlag = parse_element (element ("""BillDeterminant.referenceFlag"""))_
    val reportable = parse_element (element ("""BillDeterminant.reportable"""))_
    val roundOff = parse_element (element ("""BillDeterminant.roundOff"""))_
    val source = parse_element (element ("""BillDeterminant.source"""))_
    val terminationDate = parse_element (element ("""BillDeterminant.terminationDate"""))_
    val unitOfMeasure = parse_element (element ("""BillDeterminant.unitOfMeasure"""))_
    val ChargeProfile = parse_attribute (attribute ("""BillDeterminant.ChargeProfile"""))_
    val MktUserAttribute = parse_attributes (attribute ("""BillDeterminant.MktUserAttribute"""))_
    def parse (context: Context): BillDeterminant =
    {
        BillDeterminant(
            sup (context),
            calculationLevel (context),
            configVersion (context),
            deleteStatus (context),
            effectiveDate (context),
            exception (context),
            factor (context),
            frequency (context),
            toInteger (numberInterval (context), context),
            offset (context),
            precisionLevel (context),
            primaryYN (context),
            referenceFlag (context),
            reportable (context),
            roundOff (context),
            source (context),
            terminationDate (context),
            unitOfMeasure (context),
            ChargeProfile (context),
            MktUserAttribute (context)
        )
    }
}

/**
 * A type of profile for financial charges
 */
case class ChargeProfile
(

    override val sup: Profile,

    /**
     * The calculation frequency, daily or monthly.
     */
    val frequency: String,

    /**
     * The number of intervals in the profile data.
     */
    val numberInterval: Int,

    /**
     * The type of profile.
     * It could be amount, price, or quantity.
     */
    val typ: String,

    /**
     * The unit of measure applied to the value attribute of the profile data.
     */
    val unitOfMeasure: String,

    val Bid: String,

    val BillDeterminant: String,

    val PassTroughBill: String
)
extends
    Element
{
    def this () = { this (null, null, 0, null, null, null, null, null) }
    def Profile: Profile = sup.asInstanceOf[Profile]
    override def copy (): Row = { return (clone ().asInstanceOf[ChargeProfile]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ChargeProfile
extends
    Parseable[ChargeProfile]
{
    val sup = Profile.parse _
    val frequency = parse_element (element ("""ChargeProfile.frequency"""))_
    val numberInterval = parse_element (element ("""ChargeProfile.numberInterval"""))_
    val typ = parse_element (element ("""ChargeProfile.type"""))_
    val unitOfMeasure = parse_element (element ("""ChargeProfile.unitOfMeasure"""))_
    val Bid = parse_attribute (attribute ("""ChargeProfile.Bid"""))_
    val BillDeterminant = parse_attribute (attribute ("""ChargeProfile.BillDeterminant"""))_
    val PassTroughBill = parse_attribute (attribute ("""ChargeProfile.PassTroughBill"""))_
    def parse (context: Context): ChargeProfile =
    {
        ChargeProfile(
            sup (context),
            frequency (context),
            toInteger (numberInterval (context), context),
            typ (context),
            unitOfMeasure (context),
            Bid (context),
            BillDeterminant (context),
            PassTroughBill (context)
        )
    }
}

/**
 * Model of various charges associated with an energy profile to support billing and settlement
 */
case class ChargeProfileData
(

    override val sup: BasicElement,

    /**
     * The sequence number of the profile.
     */
    val sequence: Int,

    /**
     * The date and time of an interval.
     */
    val timeStamp: String,

    /**
     * The value of an interval given a profile type (amount, price, or quantity), subject to the UOM.
     */
    val value: Double,

    val BillDeterminant: String,

    val ChargeProfile: String
)
extends
    Element
{
    def this () = { this (null, 0, null, 0.0, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ChargeProfileData]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ChargeProfileData
extends
    Parseable[ChargeProfileData]
{
    val sup = BasicElement.parse _
    val sequence = parse_element (element ("""ChargeProfileData.sequence"""))_
    val timeStamp = parse_element (element ("""ChargeProfileData.timeStamp"""))_
    val value = parse_element (element ("""ChargeProfileData.value"""))_
    val BillDeterminant = parse_attribute (attribute ("""ChargeProfileData.BillDeterminant"""))_
    val ChargeProfile = parse_attribute (attribute ("""ChargeProfileData.ChargeProfile"""))_
    def parse (context: Context): ChargeProfileData =
    {
        ChargeProfileData(
            sup (context),
            toInteger (sequence (context), context),
            timeStamp (context),
            toDouble (value (context), context),
            BillDeterminant (context),
            ChargeProfile (context)
        )
    }
}

/**
 * Models results of market clearing which call for commitment of units.
 */
case class CommitmentClearing
(

    override val sup: MarketFactors
)
extends
    Element
{
    def this () = { this (null) }
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { return (clone ().asInstanceOf[CommitmentClearing]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CommitmentClearing
extends
    Parseable[CommitmentClearing]
{
    val sup = MarketFactors.parse _
    def parse (context: Context): CommitmentClearing =
    {
        CommitmentClearing(
            sup (context)
        )
    }
}

/**
 * Provides the necessary information (on a resource basis) to capture the Startup/Shutdown commitment results.
 * This information is relevant to all markets.
 */
case class Commitments
(

    override val sup: BasicElement,

    /**
     * the type of UC status (self commitment, ISO commitment, or SCUC commitment)
     */
    val commitmentType: String,

    /**
     * Total cost associated with changing the status of the resource.
     */
    val instructionCost: Double,

    /**
     * Indicator of either a Start-Up or a Shut-Down.
     */
    val instructionType: String,

    /**
     * End time for the commitment period.
     * This will be on an interval boundary.
     */
    val intervalEndTime: String,

    /**
     * Start time for the commitment period.
     * This will be on an interval boundary.
     */
    val intervalStartTime: String,

    /**
     * SCUC commitment period start-up time.
     * Calculated start up time based on the StartUpTimeCurve provided with the Bid.
     */
    val minStatusChangeTime: Int,

    /**
     * Unit no load cost in case of energy commodity
     */
    val noLoadCost: Double,

    val updateTimeStamp: String,

    val updateType: String,

    val updateUser: String,

    val RegisteredResource: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, null, null, null, 0, 0.0, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[Commitments]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Commitments
extends
    Parseable[Commitments]
{
    val sup = BasicElement.parse _
    val commitmentType = parse_attribute (attribute ("""Commitments.commitmentType"""))_
    val instructionCost = parse_element (element ("""Commitments.instructionCost"""))_
    val instructionType = parse_attribute (attribute ("""Commitments.instructionType"""))_
    val intervalEndTime = parse_element (element ("""Commitments.intervalEndTime"""))_
    val intervalStartTime = parse_element (element ("""Commitments.intervalStartTime"""))_
    val minStatusChangeTime = parse_element (element ("""Commitments.minStatusChangeTime"""))_
    val noLoadCost = parse_element (element ("""Commitments.noLoadCost"""))_
    val updateTimeStamp = parse_element (element ("""Commitments.updateTimeStamp"""))_
    val updateType = parse_attribute (attribute ("""Commitments.updateType"""))_
    val updateUser = parse_element (element ("""Commitments.updateUser"""))_
    val RegisteredResource = parse_attribute (attribute ("""Commitments.RegisteredResource"""))_
    def parse (context: Context): Commitments =
    {
        Commitments(
            sup (context),
            commitmentType (context),
            toDouble (instructionCost (context), context),
            instructionType (context),
            intervalEndTime (context),
            intervalStartTime (context),
            toInteger (minStatusChangeTime (context), context),
            toDouble (noLoadCost (context), context),
            updateTimeStamp (context),
            updateType (context),
            updateUser (context),
            RegisteredResource (context)
        )
    }
}

/**
 * Groups all items associated with Binding Constraints and Constraint Violations per interval and market.
 */
case class ConstraintClearing
(

    override val sup: MarketFactors
)
extends
    Element
{
    def this () = { this (null) }
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { return (clone ().asInstanceOf[ConstraintClearing]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ConstraintClearing
extends
    Parseable[ConstraintClearing]
{
    val sup = MarketFactors.parse _
    def parse (context: Context): ConstraintClearing =
    {
        ConstraintClearing(
            sup (context)
        )
    }
}

/**
 * Provides the Market results for the constraint processing for either the DAM or RTM.
 * The data includes the constraint type (binding or violated), the solved value for the constraint, and the associated shadow price.
 */
case class ConstraintResults
(

    override val sup: IdentifiedObject,

    /**
     * Branch base Power Flow.
     */
    val baseFlow: Double,

    /**
     * MW Limit.
     */
    val bindingLimit: Double,

    /**
     * Cleared MW.
     */
    val clearedValue: Double,

    /**
     * Non-competitive path constraint Flag"(Y/N)  indicating whether the shadow price on a non-competitive path was non-zero.
     */
    val competitivePathConstraint: String,

    /**
     * Type of constraint.
     */
    val constraintType: String,

    /**
     * Limit flag ('Maximum', 'Minimum').
     */
    val limitFlag: String,

    /**
     * Included in optimization Y/N.
     */
    val optimizationFlag: String,

    /**
     * Transmission overload MW.
     */
    val overloadMW: Double,

    /**
     * Actual MW flow as percent of limit.
     */
    val percentMW: Double,

    /**
     * Shadow Price ($/MW) for the commodity.
     * Shadow price for the corresponding constraint.
     */
    val shadowPrice: Double,

    /**
     * Update time stamp.
     */
    val updateTimeStamp: String,

    /**
     * MQS change type.
     */
    val updateType: String,

    /**
     * Updated user.
     */
    val updateUser: String,

    /**
     * This value is determined in DA and RTM.
     * The SCUC optimization ensures that the MW flow on the Branch Group will not exceed this limit in the relevant direction.
     */
    val BGLimit: Double,

    /**
     * Branch Group TR Reservation Capacity - This value is determined in DA and RTM.
     * It is the amount of spare transmission capacity that is left for the TR holder to use.
     */
    val BGTRResCap: Double,

    val ConstraintClearing: String,

    val Flowgate: String,

    val MktContingency: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, null, null, null, null, 0.0, 0.0, 0.0, null, null, null, 0.0, 0.0, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ConstraintResults]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ConstraintResults
extends
    Parseable[ConstraintResults]
{
    val sup = IdentifiedObject.parse _
    val baseFlow = parse_element (element ("""ConstraintResults.baseFlow"""))_
    val bindingLimit = parse_element (element ("""ConstraintResults.bindingLimit"""))_
    val clearedValue = parse_element (element ("""ConstraintResults.clearedValue"""))_
    val competitivePathConstraint = parse_attribute (attribute ("""ConstraintResults.competitivePathConstraint"""))_
    val constraintType = parse_attribute (attribute ("""ConstraintResults.constraintType"""))_
    val limitFlag = parse_attribute (attribute ("""ConstraintResults.limitFlag"""))_
    val optimizationFlag = parse_attribute (attribute ("""ConstraintResults.optimizationFlag"""))_
    val overloadMW = parse_element (element ("""ConstraintResults.overloadMW"""))_
    val percentMW = parse_element (element ("""ConstraintResults.percentMW"""))_
    val shadowPrice = parse_element (element ("""ConstraintResults.shadowPrice"""))_
    val updateTimeStamp = parse_element (element ("""ConstraintResults.updateTimeStamp"""))_
    val updateType = parse_attribute (attribute ("""ConstraintResults.updateType"""))_
    val updateUser = parse_element (element ("""ConstraintResults.updateUser"""))_
    val BGLimit = parse_element (element ("""ConstraintResults.BGLimit"""))_
    val BGTRResCap = parse_element (element ("""ConstraintResults.BGTRResCap"""))_
    val ConstraintClearing = parse_attribute (attribute ("""ConstraintResults.ConstraintClearing"""))_
    val Flowgate = parse_attribute (attribute ("""ConstraintResults.Flowgate"""))_
    val MktContingency = parse_attribute (attribute ("""ConstraintResults.MktContingency"""))_
    def parse (context: Context): ConstraintResults =
    {
        ConstraintResults(
            sup (context),
            toDouble (baseFlow (context), context),
            toDouble (bindingLimit (context), context),
            toDouble (clearedValue (context), context),
            competitivePathConstraint (context),
            constraintType (context),
            limitFlag (context),
            optimizationFlag (context),
            toDouble (overloadMW (context), context),
            toDouble (percentMW (context), context),
            toDouble (shadowPrice (context), context),
            updateTimeStamp (context),
            updateType (context),
            updateUser (context),
            toDouble (BGLimit (context), context),
            toDouble (BGTRResCap (context), context),
            ConstraintClearing (context),
            Flowgate (context),
            MktContingency (context)
        )
    }
}

/**
 * Provides the necessary information (on a resource basis) to capture the Dispatch Operating Point (DOP) results on a Dispatch interval.
 * This information is only relevant to the RT interval market.
 */
case class DopInstruction
(

    override val sup: BasicElement,

    /**
     * Dispatched Operating Point (MW)
     */
    val mwDOP: Double,

    /**
     * A value used to establish priority of the DOP when plotting.
     * This is only applicable when two DOPs exist for the same time, but with different MW values.  E.g. when indicating a step in the curve.  Its used to determine if the curve steps up or down.
     */
    val plotPriority: Int,

    /**
     * Indication of DOP validity.
     * Shows the DOP is calculated from the latest run (YES). A NO indicator shows that the DOP is copied from a previous execution.
     */
    val runIndicatorDOP: String,

    /**
     * DOP time stamp
     */
    val timestampDOP: String,

    val updateTimeStamp: String,

    val updateType: String,

    val updateUser: String,

    val RegisteredResouce: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[DopInstruction]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DopInstruction
extends
    Parseable[DopInstruction]
{
    val sup = BasicElement.parse _
    val mwDOP = parse_element (element ("""DopInstruction.mwDOP"""))_
    val plotPriority = parse_element (element ("""DopInstruction.plotPriority"""))_
    val runIndicatorDOP = parse_attribute (attribute ("""DopInstruction.runIndicatorDOP"""))_
    val timestampDOP = parse_element (element ("""DopInstruction.timestampDOP"""))_
    val updateTimeStamp = parse_element (element ("""DopInstruction.updateTimeStamp"""))_
    val updateType = parse_attribute (attribute ("""DopInstruction.updateType"""))_
    val updateUser = parse_element (element ("""DopInstruction.updateUser"""))_
    val RegisteredResouce = parse_attribute (attribute ("""DopInstruction.RegisteredResouce"""))_
    def parse (context: Context): DopInstruction =
    {
        DopInstruction(
            sup (context),
            toDouble (mwDOP (context), context),
            toInteger (plotPriority (context), context),
            runIndicatorDOP (context),
            timestampDOP (context),
            updateTimeStamp (context),
            updateType (context),
            updateUser (context),
            RegisteredResouce (context)
        )
    }
}

/**
 * Provides the necessary information (on a resource basis) to capture the Dispatch Operating Target (DOT) results on a Dispatch interval.
 * This information is only relevant to the RT interval market.
 */
case class DotInstruction
(

    override val sup: BasicElement,

    /**
     * Actual ramp rate.
     */
    val actualRampRate: Double,

    /**
     * Flag indicating whether or not the resource was in compliance with the instruction (plus/minus 10%).
     * Directs if a unit is allowed to set the price (ex-post pricing).
     */
    val compliantIndicator: String,

    /**
     * Economic Max Limit override for unit, this value is null, if it is not, this value overrides the Energy column value.
     * Allows dispatcher to override the unit's energy value.
     */
    val economicMaxOverride: Double,

    /**
     * Expected energy.
     */
    val expectedEnergy: Double,

    /**
     * The Degree of Generator Performance (DGP) used for the unit.
     * Measure of how a generator responds to raise /lower signals.  Calculated every five minutes.
     */
    val generatorPerformanceDegree: Double,

    /**
     * HASP results.
     */
    val hourAheadSchedEnergy: Double,

    /**
     * Hourly Schedule (DA Energy Schedule).
     */
    val hourlySchedule: Double,

    /**
     * The date/time for the instruction.
     */
    val instructionTime: String,

    /**
     * True if maximum emergency limit activated; false otherwise.
     * If unit is requested  to move up to its max emergency limit., this flag is set to true.
     */
    val maximumEmergencyInd: Boolean,

    /**
     * Meter Sub System Load Following.
     */
    val meterLoadFollowing: Double,

    /**
     * Desired MW that is not ramp restricted.
     * If no ramp rate limit existed for the unit, this is the MW value tha t the unit was requested to move to.
     */
    val nonRampRestrictedMW: Double,

    /**
     * Non Spin Reserve used to procure energy.
     */
    val nonSpinReserve: Double,

    /**
     * Timestamp when the previous DOT value was issued.
     */
    val previousDOTTimeStamp: String,

    /**
     * The ramp rate limit for the unit in MWs per minute.
     * Participant bidding data.
     */
    val rampRateLimit: Double,

    /**
     * Regulation Status (Yes/No).
     */
    val regulationStatus: String,

    /**
     * Spin Reserve used to procure energy.
     */
    val spinReserve: Double,

    /**
     * Standard ramping energy (MWH).
     */
    val standardRampEnergy: Double,

    /**
     * Supplemental Energy procure by Real Time Dispatch.
     */
    val supplementalEnergy: Double,

    /**
     * Output results from the case identifying the reason the unit was committed by the software.
     */
    val unitStatus: Int,

    /**
     * Dispatch operating target value.
     */
    val DOT: Double,

    val RegisteredResource: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, 0.0, 0.0, 0.0, 0.0, 0.0, null, false, 0.0, 0.0, 0.0, null, 0.0, null, 0.0, 0.0, 0.0, 0, 0.0, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[DotInstruction]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DotInstruction
extends
    Parseable[DotInstruction]
{
    val sup = BasicElement.parse _
    val actualRampRate = parse_element (element ("""DotInstruction.actualRampRate"""))_
    val compliantIndicator = parse_attribute (attribute ("""DotInstruction.compliantIndicator"""))_
    val economicMaxOverride = parse_element (element ("""DotInstruction.economicMaxOverride"""))_
    val expectedEnergy = parse_element (element ("""DotInstruction.expectedEnergy"""))_
    val generatorPerformanceDegree = parse_element (element ("""DotInstruction.generatorPerformanceDegree"""))_
    val hourAheadSchedEnergy = parse_element (element ("""DotInstruction.hourAheadSchedEnergy"""))_
    val hourlySchedule = parse_element (element ("""DotInstruction.hourlySchedule"""))_
    val instructionTime = parse_element (element ("""DotInstruction.instructionTime"""))_
    val maximumEmergencyInd = parse_element (element ("""DotInstruction.maximumEmergencyInd"""))_
    val meterLoadFollowing = parse_element (element ("""DotInstruction.meterLoadFollowing"""))_
    val nonRampRestrictedMW = parse_element (element ("""DotInstruction.nonRampRestrictedMW"""))_
    val nonSpinReserve = parse_element (element ("""DotInstruction.nonSpinReserve"""))_
    val previousDOTTimeStamp = parse_element (element ("""DotInstruction.previousDOTTimeStamp"""))_
    val rampRateLimit = parse_element (element ("""DotInstruction.rampRateLimit"""))_
    val regulationStatus = parse_attribute (attribute ("""DotInstruction.regulationStatus"""))_
    val spinReserve = parse_element (element ("""DotInstruction.spinReserve"""))_
    val standardRampEnergy = parse_element (element ("""DotInstruction.standardRampEnergy"""))_
    val supplementalEnergy = parse_element (element ("""DotInstruction.supplementalEnergy"""))_
    val unitStatus = parse_element (element ("""DotInstruction.unitStatus"""))_
    val DOT = parse_element (element ("""DotInstruction.DOT"""))_
    val RegisteredResource = parse_attribute (attribute ("""DotInstruction.RegisteredResource"""))_
    def parse (context: Context): DotInstruction =
    {
        DotInstruction(
            sup (context),
            toDouble (actualRampRate (context), context),
            compliantIndicator (context),
            toDouble (economicMaxOverride (context), context),
            toDouble (expectedEnergy (context), context),
            toDouble (generatorPerformanceDegree (context), context),
            toDouble (hourAheadSchedEnergy (context), context),
            toDouble (hourlySchedule (context), context),
            instructionTime (context),
            toBoolean (maximumEmergencyInd (context), context),
            toDouble (meterLoadFollowing (context), context),
            toDouble (nonRampRestrictedMW (context), context),
            toDouble (nonSpinReserve (context), context),
            previousDOTTimeStamp (context),
            toDouble (rampRateLimit (context), context),
            regulationStatus (context),
            toDouble (spinReserve (context), context),
            toDouble (standardRampEnergy (context), context),
            toDouble (supplementalEnergy (context), context),
            toInteger (unitStatus (context), context),
            toDouble (DOT (context), context),
            RegisteredResource (context)
        )
    }
}

/**
 * Model of ex-post calcultion of MW losses.
 */
case class ExPostLoss
(

    override val sup: MarketFactors
)
extends
    Element
{
    def this () = { this (null) }
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { return (clone ().asInstanceOf[ExPostLoss]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExPostLoss
extends
    Parseable[ExPostLoss]
{
    val sup = MarketFactors.parse _
    def parse (context: Context): ExPostLoss =
    {
        ExPostLoss(
            sup (context)
        )
    }
}

/**
 * Model results of ex-post calculation of MW losses.
 * Summarizes loss in two categories losses on the the extra high voltage transmission and total losses. Calculated for each subcontrol area.
 */
case class ExPostLossResults
(

    override val sup: BasicElement,

    /**
     * EHV MW losses in the company
     * Attribute Usage: Information purposes - Output of LPA engine.
     */
    val ehvLossMW: Double,

    /**
     * Total MW losses in the company
     * Attribute Usage: Information purposes - Output of LPA engine.
     */
    val totalLossMW: Double,

    val ExPostLoss: String,

    val SubControlArea: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ExPostLossResults]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExPostLossResults
extends
    Parseable[ExPostLossResults]
{
    val sup = BasicElement.parse _
    val ehvLossMW = parse_element (element ("""ExPostLossResults.ehvLossMW"""))_
    val totalLossMW = parse_element (element ("""ExPostLossResults.totalLossMW"""))_
    val ExPostLoss = parse_attribute (attribute ("""ExPostLossResults.ExPostLoss"""))_
    val SubControlArea = parse_attribute (attribute ("""ExPostLossResults.SubControlArea"""))_
    def parse (context: Context): ExPostLossResults =
    {
        ExPostLossResults(
            sup (context),
            toDouble (ehvLossMW (context), context),
            toDouble (totalLossMW (context), context),
            ExPostLoss (context),
            SubControlArea (context)
        )
    }
}

/**
 * Model of ex-post calculation of cleared MW on a regional basis
 */
case class ExPostMarketRegion
(

    override val sup: MarketFactors,

    val ExPostMarketRegionResults: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { return (clone ().asInstanceOf[ExPostMarketRegion]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExPostMarketRegion
extends
    Parseable[ExPostMarketRegion]
{
    val sup = MarketFactors.parse _
    val ExPostMarketRegionResults = parse_attribute (attribute ("""ExPostMarketRegion.ExPostMarketRegionResults"""))_
    def parse (context: Context): ExPostMarketRegion =
    {
        ExPostMarketRegion(
            sup (context),
            ExPostMarketRegionResults (context)
        )
    }
}

/**
 * Model of expost calculation of cleared MW on a region basis.
 * Includes cleared price
 */
case class ExPostMarketRegionResults
(

    override val sup: BasicElement,

    val exPostClearedPrice: Double,

    val ExPostMarketRegion: String,

    val MarketRegion: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ExPostMarketRegionResults]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExPostMarketRegionResults
extends
    Parseable[ExPostMarketRegionResults]
{
    val sup = BasicElement.parse _
    val exPostClearedPrice = parse_element (element ("""ExPostMarketRegionResults.exPostClearedPrice"""))_
    val ExPostMarketRegion = parse_attribute (attribute ("""ExPostMarketRegionResults.ExPostMarketRegion"""))_
    val MarketRegion = parse_attribute (attribute ("""ExPostMarketRegionResults.MarketRegion"""))_
    def parse (context: Context): ExPostMarketRegionResults =
    {
        ExPostMarketRegionResults(
            sup (context),
            toDouble (exPostClearedPrice (context), context),
            ExPostMarketRegion (context),
            MarketRegion (context)
        )
    }
}

/**
 * Model of ex-post pricing of nodes
 */
case class ExPostPricing
(

    override val sup: MarketFactors,

    /**
     * market energy price
     */
    val energyPrice: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { return (clone ().asInstanceOf[ExPostPricing]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExPostPricing
extends
    Parseable[ExPostPricing]
{
    val sup = MarketFactors.parse _
    val energyPrice = parse_element (element ("""ExPostPricing.energyPrice"""))_
    def parse (context: Context): ExPostPricing =
    {
        ExPostPricing(
            sup (context),
            toDouble (energyPrice (context), context)
        )
    }
}

/**
 * Model of ex-post pricing of nodes.
 * Includes LMP information, pnode based.
 */
case class ExPostPricingResults
(

    override val sup: BasicElement,

    /**
     * Congestion component of Location Marginal Price (LMP) in monetary units per MW; congestion component of the hourly LMP at a specific pricing node
     * Attribute Usage: Result of the Security, Pricing, and Dispatch(SPD)/Simultaneous Feasibility Test(SFT) software and denotes the hourly congestion component of LMP for each pricing node.
     */
    val congestLMP: Double,

    /**
     * 5 min weighted average LMP; the Location Marginal Price of the Pnode for which price calculation is carried out.
     * Attribute Usage: 5 min weighted average LMP  to be displayed on UI
     */
    val lmp: Double,

    /**
     * Loss component of Location Marginal Price (LMP) in monetary units per MW; loss component of the hourly LMP at a specific pricing node
     * Attribute Usage: Result of the Security, Pricing, and Dispatch(SPD)/Simultaneous Feasibility Test(SFT) software and denotes the hourly loss component of LMP for each pricing node.
     */
    val lossLMP: Double,

    val ExPostPricing: String,

    val Pnode: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ExPostPricingResults]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExPostPricingResults
extends
    Parseable[ExPostPricingResults]
{
    val sup = BasicElement.parse _
    val congestLMP = parse_element (element ("""ExPostPricingResults.congestLMP"""))_
    val lmp = parse_element (element ("""ExPostPricingResults.lmp"""))_
    val lossLMP = parse_element (element ("""ExPostPricingResults.lossLMP"""))_
    val ExPostPricing = parse_attribute (attribute ("""ExPostPricingResults.ExPostPricing"""))_
    val Pnode = parse_attribute (attribute ("""ExPostPricingResults.Pnode"""))_
    def parse (context: Context): ExPostPricingResults =
    {
        ExPostPricingResults(
            sup (context),
            toDouble (congestLMP (context), context),
            toDouble (lmp (context), context),
            toDouble (lossLMP (context), context),
            ExPostPricing (context),
            Pnode (context)
        )
    }
}

/**
 * Model of ex-post pricing of resources.
 */
case class ExPostResource
(

    override val sup: MarketFactors
)
extends
    Element
{
    def this () = { this (null) }
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { return (clone ().asInstanceOf[ExPostResource]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExPostResource
extends
    Parseable[ExPostResource]
{
    val sup = MarketFactors.parse _
    def parse (context: Context): ExPostResource =
    {
        ExPostResource(
            sup (context)
        )
    }
}

/**
 * Model of ex-post pricing of resources contains components of LMPs: energy, congestion, loss.
 * Resource based.
 */
case class ExPostResourceResults
(

    override val sup: BasicElement,

    /**
     * LMP component in USD (deprecated)
     */
    val congestionLMP: Double,

    /**
     * Desired output of unit
     */
    val desiredMW: Double,

    /**
     * Unit Dispatch rate from real time unit dispatch.
     */
    val dispatchRate: Double,

    /**
     * LMP (Local Marginal Price) in USD at the equipment (deprecated)
     */
    val lmp: Double,

    /**
     * loss lmp (deprecated)
     */
    val lossLMP: Double,

    /**
     * Economic Maximum MW
     */
    val maxEconomicMW: Double,

    /**
     * Economic Minimum MW
     */
    val minEconomicMW: Double,

    /**
     * Current MW output of the equipment
     * Attribute Usage: Information purposes - Information purposes - Output of LPA engine.
     */
    val resourceMW: Double,

    /**
     * Status of equipment
     */
    val status: String,

    val ExPostResource: String,

    val RegisteredResource: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ExPostResourceResults]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExPostResourceResults
extends
    Parseable[ExPostResourceResults]
{
    val sup = BasicElement.parse _
    val congestionLMP = parse_element (element ("""ExPostResourceResults.congestionLMP"""))_
    val desiredMW = parse_element (element ("""ExPostResourceResults.desiredMW"""))_
    val dispatchRate = parse_element (element ("""ExPostResourceResults.dispatchRate"""))_
    val lmp = parse_element (element ("""ExPostResourceResults.lmp"""))_
    val lossLMP = parse_element (element ("""ExPostResourceResults.lossLMP"""))_
    val maxEconomicMW = parse_element (element ("""ExPostResourceResults.maxEconomicMW"""))_
    val minEconomicMW = parse_element (element ("""ExPostResourceResults.minEconomicMW"""))_
    val resourceMW = parse_element (element ("""ExPostResourceResults.resourceMW"""))_
    val status = parse_attribute (attribute ("""ExPostResourceResults.status"""))_
    val ExPostResource = parse_attribute (attribute ("""ExPostResourceResults.ExPostResource"""))_
    val RegisteredResource = parse_attribute (attribute ("""ExPostResourceResults.RegisteredResource"""))_
    def parse (context: Context): ExPostResourceResults =
    {
        ExPostResourceResults(
            sup (context),
            toDouble (congestionLMP (context), context),
            toDouble (desiredMW (context), context),
            toDouble (dispatchRate (context), context),
            toDouble (lmp (context), context),
            toDouble (lossLMP (context), context),
            toDouble (maxEconomicMW (context), context),
            toDouble (minEconomicMW (context), context),
            toDouble (resourceMW (context), context),
            status (context),
            ExPostResource (context),
            RegisteredResource (context)
        )
    }
}

/**
 * Model of clearing result of the market run at the market level.
 * Identifies interval
 */
case class GeneralClearing
(

    override val sup: MarketFactors
)
extends
    Element
{
    def this () = { this (null) }
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { return (clone ().asInstanceOf[GeneralClearing]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GeneralClearing
extends
    Parseable[GeneralClearing]
{
    val sup = MarketFactors.parse _
    def parse (context: Context): GeneralClearing =
    {
        GeneralClearing(
            sup (context)
        )
    }
}

/**
 * Provides the adjusted load forecast value on a load forecast zone basis.
 */
case class GeneralClearingResults
(

    override val sup: BasicElement,

    /**
     * Load Prediction/Forecast (MW), by Time Period (5', 10', 15')
     */
    val loadForecast: Double,

    /**
     * Amount of load in the control zone
     * Attribute Usage: hourly load value for the specific area
     */
    val totalLoad: Double,

    /**
     * Amount of interchange for the control zone
     * Attribute Usage: hourly interchange value for the specific area
     */
    val totalNetInterchange: Double,

    val GeneralClearing: String,

    val SubControlArea: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[GeneralClearingResults]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GeneralClearingResults
extends
    Parseable[GeneralClearingResults]
{
    val sup = BasicElement.parse _
    val loadForecast = parse_element (element ("""GeneralClearingResults.loadForecast"""))_
    val totalLoad = parse_element (element ("""GeneralClearingResults.totalLoad"""))_
    val totalNetInterchange = parse_element (element ("""GeneralClearingResults.totalNetInterchange"""))_
    val GeneralClearing = parse_attribute (attribute ("""GeneralClearingResults.GeneralClearing"""))_
    val SubControlArea = parse_attribute (attribute ("""GeneralClearingResults.SubControlArea"""))_
    def parse (context: Context): GeneralClearingResults =
    {
        GeneralClearingResults(
            sup (context),
            toDouble (loadForecast (context), context),
            toDouble (totalLoad (context), context),
            toDouble (totalNetInterchange (context), context),
            GeneralClearing (context),
            SubControlArea (context)
        )
    }
}

/**
 * Model of market clearing, relating to commitment instructions.
 * Identifies interval
 */
case class InstructionClearing
(

    override val sup: MarketFactors
)
extends
    Element
{
    def this () = { this (null) }
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { return (clone ().asInstanceOf[InstructionClearing]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object InstructionClearing
extends
    Parseable[InstructionClearing]
{
    val sup = MarketFactors.parse _
    def parse (context: Context): InstructionClearing =
    {
        InstructionClearing(
            sup (context)
        )
    }
}

/**
 * Model of market clearing, related to Dispatch Operating Point.
 * Identifies interval
 */
case class InstructionClearingDOP
(

    override val sup: MarketFactors
)
extends
    Element
{
    def this () = { this (null) }
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { return (clone ().asInstanceOf[InstructionClearingDOP]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object InstructionClearingDOP
extends
    Parseable[InstructionClearingDOP]
{
    val sup = MarketFactors.parse _
    def parse (context: Context): InstructionClearingDOP =
    {
        InstructionClearingDOP(
            sup (context)
        )
    }
}

/**
 * Model of market clearing, related to Dispatch Operating Target (model of anticipatory dispatch).
 * Identifies interval
 */
case class InstructionClearingDOT
(

    override val sup: MarketFactors,

    /**
     * Indication that the system is currently operating in a contingency mode.
     */
    val contingencyActive: String,

    val dispatchMode: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { return (clone ().asInstanceOf[InstructionClearingDOT]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object InstructionClearingDOT
extends
    Parseable[InstructionClearingDOT]
{
    val sup = MarketFactors.parse _
    val contingencyActive = parse_attribute (attribute ("""InstructionClearingDOT.contingencyActive"""))_
    val dispatchMode = parse_attribute (attribute ("""InstructionClearingDOT.dispatchMode"""))_
    def parse (context: Context): InstructionClearingDOT =
    {
        InstructionClearingDOT(
            sup (context),
            contingencyActive (context),
            dispatchMode (context)
        )
    }
}

/**
 * Provides the necessary information (on a resource basis) to capture the Startup/Shutdown instruction results.
 * This information is relevant to the DA Market (RUC only) as well as the RT Market (HASP, Pre-dispatch, and Interval).
 */
case class Instructions
(

    override val sup: BasicElement,

    val bindingDOT: Double,

    val bindingInstruction: String,

    /**
     * Total cost associated with changing the status of the resource.
     */
    val instructionCost: Double,

    /**
     * instruction source for market quality results (INS, ACT)
     */
    val instructionSource: String,

    /**
     * Time the resource should be at Pmin (for start ups).
     * Time the resource is off line.
     */
    val instructionStartTime: String,

    /**
     * Indicator of either a Start-Up or a Shut-Down.
     */
    val instructionType: String,

    /**
     * Manually Blocked Indicator (Yes/No).
     * The instruction has been blocked by an Operator.
     */
    val manuallyBlocked: String,

    /**
     * Minimum start up time required to bring the unit online (minutes).
     * SCUC commitment period start-up time. Calculated start up time based on the StartUpTimeCurve provided with the Bid.
     */
    val minStatusChangeTime: Int,

    val updateTimeStamp: String,

    val updateType: String,

    val updateUser: String,

    val RegisteredResource: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, 0.0, null, null, null, null, 0, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[Instructions]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Instructions
extends
    Parseable[Instructions]
{
    val sup = BasicElement.parse _
    val bindingDOT = parse_element (element ("""Instructions.bindingDOT"""))_
    val bindingInstruction = parse_attribute (attribute ("""Instructions.bindingInstruction"""))_
    val instructionCost = parse_element (element ("""Instructions.instructionCost"""))_
    val instructionSource = parse_attribute (attribute ("""Instructions.instructionSource"""))_
    val instructionStartTime = parse_element (element ("""Instructions.instructionStartTime"""))_
    val instructionType = parse_attribute (attribute ("""Instructions.instructionType"""))_
    val manuallyBlocked = parse_attribute (attribute ("""Instructions.manuallyBlocked"""))_
    val minStatusChangeTime = parse_element (element ("""Instructions.minStatusChangeTime"""))_
    val updateTimeStamp = parse_element (element ("""Instructions.updateTimeStamp"""))_
    val updateType = parse_attribute (attribute ("""Instructions.updateType"""))_
    val updateUser = parse_element (element ("""Instructions.updateUser"""))_
    val RegisteredResource = parse_attribute (attribute ("""Instructions.RegisteredResource"""))_
    def parse (context: Context): Instructions =
    {
        Instructions(
            sup (context),
            toDouble (bindingDOT (context), context),
            bindingInstruction (context),
            toDouble (instructionCost (context), context),
            instructionSource (context),
            instructionStartTime (context),
            instructionType (context),
            manuallyBlocked (context),
            toInteger (minStatusChangeTime (context), context),
            updateTimeStamp (context),
            updateType (context),
            updateUser (context),
            RegisteredResource (context)
        )
    }
}

/**
 * Model of load following capabilities that are entered by operators on a temporary basis.
 * Related to Registered Resources in Metered Subsystems
 */
case class LoadFollowingOperatorInput
(

    override val sup: BasicElement,

    /**
     * Time the data entry was performed
     */
    val dataEntryTimeStamp: String,

    /**
     * temporarily manually entered LFD capacity
     */
    val tempLoadFollowingDownManualCap: Double,

    /**
     * temporarily manually entered LFU capacity.
     */
    val tempLoadFollowingUpManualCap: Double,

    val updateTimeStamp: String,

    val updateType: String,

    val updateUser: String,

    val RegisteredResource: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, 0.0, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[LoadFollowingOperatorInput]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object LoadFollowingOperatorInput
extends
    Parseable[LoadFollowingOperatorInput]
{
    val sup = BasicElement.parse _
    val dataEntryTimeStamp = parse_element (element ("""LoadFollowingOperatorInput.dataEntryTimeStamp"""))_
    val tempLoadFollowingDownManualCap = parse_element (element ("""LoadFollowingOperatorInput.tempLoadFollowingDownManualCap"""))_
    val tempLoadFollowingUpManualCap = parse_element (element ("""LoadFollowingOperatorInput.tempLoadFollowingUpManualCap"""))_
    val updateTimeStamp = parse_element (element ("""LoadFollowingOperatorInput.updateTimeStamp"""))_
    val updateType = parse_attribute (attribute ("""LoadFollowingOperatorInput.updateType"""))_
    val updateUser = parse_element (element ("""LoadFollowingOperatorInput.updateUser"""))_
    val RegisteredResource = parse_attribute (attribute ("""LoadFollowingOperatorInput.RegisteredResource"""))_
    def parse (context: Context): LoadFollowingOperatorInput =
    {
        LoadFollowingOperatorInput(
            sup (context),
            dataEntryTimeStamp (context),
            toDouble (tempLoadFollowingDownManualCap (context), context),
            toDouble (tempLoadFollowingUpManualCap (context), context),
            updateTimeStamp (context),
            updateType (context),
            updateUser (context),
            RegisteredResource (context)
        )
    }
}

/**
 * RT only and is published on 5 minute intervals for the previous RT time interval results.
 */
case class LossClearing
(

    override val sup: MarketFactors
)
extends
    Element
{
    def this () = { this (null) }
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { return (clone ().asInstanceOf[LossClearing]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object LossClearing
extends
    Parseable[LossClearing]
{
    val sup = MarketFactors.parse _
    def parse (context: Context): LossClearing =
    {
        LossClearing(
            sup (context)
        )
    }
}

/**
 * Provides the MW loss for RUC Zones, subcontrol areas, and the total loss.
 */
case class LossClearingResults
(

    override val sup: BasicElement,

    val lossMW: Double,

    val HostControlArea: String,

    val LossClearing: String,

    val RUCZone: String,

    val SubControlArea: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[LossClearingResults]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object LossClearingResults
extends
    Parseable[LossClearingResults]
{
    val sup = BasicElement.parse _
    val lossMW = parse_element (element ("""LossClearingResults.lossMW"""))_
    val HostControlArea = parse_attribute (attribute ("""LossClearingResults.HostControlArea"""))_
    val LossClearing = parse_attribute (attribute ("""LossClearingResults.LossClearing"""))_
    val RUCZone = parse_attribute (attribute ("""LossClearingResults.RUCZone"""))_
    val SubControlArea = parse_attribute (attribute ("""LossClearingResults.SubControlArea"""))_
    def parse (context: Context): LossClearingResults =
    {
        LossClearingResults(
            sup (context),
            toDouble (lossMW (context), context),
            HostControlArea (context),
            LossClearing (context),
            RUCZone (context),
            SubControlArea (context)
        )
    }
}

/**
 * Model of results of Market Power tests, and possible mitigation.
 * Interval based
 */
case class MPMClearing
(

    override val sup: MarketFactors,

    val mitigationOccuredFlag: String,

    val LMPMFinalFlag: String,

    val SMPMFinalFlag: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { return (clone ().asInstanceOf[MPMClearing]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MPMClearing
extends
    Parseable[MPMClearing]
{
    val sup = MarketFactors.parse _
    val mitigationOccuredFlag = parse_attribute (attribute ("""MPMClearing.mitigationOccuredFlag"""))_
    val LMPMFinalFlag = parse_attribute (attribute ("""MPMClearing.LMPMFinalFlag"""))_
    val SMPMFinalFlag = parse_attribute (attribute ("""MPMClearing.SMPMFinalFlag"""))_
    def parse (context: Context): MPMClearing =
    {
        MPMClearing(
            sup (context),
            mitigationOccuredFlag (context),
            LMPMFinalFlag (context),
            SMPMFinalFlag (context)
        )
    }
}

/**
 * Model of results of Market Power tests, gives status of resource for the associated interval
 */
case class MPMResourceStatus
(

    override val sup: BasicElement,

    /**
     * Interval Test Status
     * 'N' - not applicable
     */
    val resourceStatus: String,

    val MPMTestCategory: String,

    val RegisteredResource: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[MPMResourceStatus]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MPMResourceStatus
extends
    Parseable[MPMResourceStatus]
{
    val sup = BasicElement.parse _
    val resourceStatus = parse_element (element ("""MPMResourceStatus.resourceStatus"""))_
    val MPMTestCategory = parse_attribute (attribute ("""MPMResourceStatus.MPMTestCategory"""))_
    val RegisteredResource = parse_attribute (attribute ("""MPMResourceStatus.RegisteredResource"""))_
    def parse (context: Context): MPMResourceStatus =
    {
        MPMResourceStatus(
            sup (context),
            resourceStatus (context),
            MPMTestCategory (context),
            RegisteredResource (context)
        )
    }
}

/**
 * Provides the outcome and margin percent (as appropriate) result data for the MPM tests.
 * There are relationships to Zone for Designated Congestion Area Tests, CurveSchedData for bid segment tests, to the SubControlArea for the system wide level tests, and Pnodes for the LMPM impact tests.
 */
case class MPMTestResults
(

    override val sup: BasicElement,

    /**
     * Used to show the Margin % result of the Impact test
     */
    val marginPercent: Double,

    /**
     * The results of the test.
     * For the Price, Impact, and Conduct tests, typical values are NA, Pass, Fail, Disable, or Skip.
     */
    val outcome: String,

    val AggregatedPnode: String,

    val MPMClearing: String,

    val MPMTestCategory: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[MPMTestResults]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MPMTestResults
extends
    Parseable[MPMTestResults]
{
    val sup = BasicElement.parse _
    val marginPercent = parse_element (element ("""MPMTestResults.marginPercent"""))_
    val outcome = parse_attribute (attribute ("""MPMTestResults.outcome"""))_
    val AggregatedPnode = parse_attribute (attribute ("""MPMTestResults.AggregatedPnode"""))_
    val MPMClearing = parse_attribute (attribute ("""MPMTestResults.MPMClearing"""))_
    val MPMTestCategory = parse_attribute (attribute ("""MPMTestResults.MPMTestCategory"""))_
    def parse (context: Context): MPMTestResults =
    {
        MPMTestResults(
            sup (context),
            toDouble (marginPercent (context), context),
            outcome (context),
            AggregatedPnode (context),
            MPMClearing (context),
            MPMTestCategory (context)
        )
    }
}

/**
 * Provides all Region Ancillary Service results for the DA and RT markets.
 * The specific data is commodity type (Regulation Up, Regulation Down, Spinning Reserve, Non-spinning Reserve, or Total Up reserves) based for the cleared MW, cleared price, and total capacity required for the region.
 */
case class MarketRegionResults
(

    override val sup: BasicElement,

    /**
     * Cleared generation Value in MW.
     * For AS, this value is clearedMW = AS Total.  For AS, clearedMW - selfScheduleMW = AS Procured
     */
    val clearedMW: Double,

    /**
     * Marginal Price ($/MW) for the commodity (Energy, Regulation Up, Regulation Down, Spinning Reserve, or Non-spinning reserve) based on the pricing run.
     */
    val clearedPrice: Double,

    /**
     * Dispatchable MW for Combustion units.
     */
    val dispatchCtMW: Double,

    /**
     * Dispatchable MW for Hydro units.
     */
    val dispatchHydroMW: Double,

    /**
     * Dispatch rate in MW/minutes.
     */
    val dispatchRate: Double,

    /**
     * Dispatchable MW for Steam units.
     */
    val dispatchSteamMW: Double,

    /**
     * Imbalance Energy Bias (MW) by Time Period (5' only)
     */
    val imbalanceEnergyBias: Double,

    /**
     * Locational AS Flags indicating whether the Upper or Lower Bound limit of the AS regional procurment is binding
     */
    val limitFlag: String,

    /**
     * The "Lumpy Flag"(Y/N)  indicates whether the resource that sets the price is a lumpy generator by hour over the time horizon.
     * Only applicable for the Day Ahead Market
     */
    val lumpyIndicator: String,

    /**
     * Region requirement maximum limit
     */
    val maxSufficiencyIndex: Double,

    /**
     * Region requirement minimum limit
     */
    val minSufficiencyIndex: Double,

    /**
     * Region requirement maximum limit
     */
    val reqMaxMW: Double,

    /**
     * Region requirement minimum limit
     */
    val reqMinMW: Double,

    /**
     * Aof AS, selfScheduleMW = AS Self-Provided
     */
    val selfScheduleMW: Double,

    val AncillaryServiceClearing: String,

    val MarketProduct: String,

    val MarketRegion: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[MarketRegionResults]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MarketRegionResults
extends
    Parseable[MarketRegionResults]
{
    val sup = BasicElement.parse _
    val clearedMW = parse_element (element ("""MarketRegionResults.clearedMW"""))_
    val clearedPrice = parse_element (element ("""MarketRegionResults.clearedPrice"""))_
    val dispatchCtMW = parse_element (element ("""MarketRegionResults.dispatchCtMW"""))_
    val dispatchHydroMW = parse_element (element ("""MarketRegionResults.dispatchHydroMW"""))_
    val dispatchRate = parse_element (element ("""MarketRegionResults.dispatchRate"""))_
    val dispatchSteamMW = parse_element (element ("""MarketRegionResults.dispatchSteamMW"""))_
    val imbalanceEnergyBias = parse_element (element ("""MarketRegionResults.imbalanceEnergyBias"""))_
    val limitFlag = parse_attribute (attribute ("""MarketRegionResults.limitFlag"""))_
    val lumpyIndicator = parse_attribute (attribute ("""MarketRegionResults.lumpyIndicator"""))_
    val maxSufficiencyIndex = parse_element (element ("""MarketRegionResults.maxSufficiencyIndex"""))_
    val minSufficiencyIndex = parse_element (element ("""MarketRegionResults.minSufficiencyIndex"""))_
    val reqMaxMW = parse_element (element ("""MarketRegionResults.reqMaxMW"""))_
    val reqMinMW = parse_element (element ("""MarketRegionResults.reqMinMW"""))_
    val selfScheduleMW = parse_element (element ("""MarketRegionResults.selfScheduleMW"""))_
    val AncillaryServiceClearing = parse_attribute (attribute ("""MarketRegionResults.AncillaryServiceClearing"""))_
    val MarketProduct = parse_attribute (attribute ("""MarketRegionResults.MarketProduct"""))_
    val MarketRegion = parse_attribute (attribute ("""MarketRegionResults.MarketRegion"""))_
    def parse (context: Context): MarketRegionResults =
    {
        MarketRegionResults(
            sup (context),
            toDouble (clearedMW (context), context),
            toDouble (clearedPrice (context), context),
            toDouble (dispatchCtMW (context), context),
            toDouble (dispatchHydroMW (context), context),
            toDouble (dispatchRate (context), context),
            toDouble (dispatchSteamMW (context), context),
            toDouble (imbalanceEnergyBias (context), context),
            limitFlag (context),
            lumpyIndicator (context),
            toDouble (maxSufficiencyIndex (context), context),
            toDouble (minSufficiencyIndex (context), context),
            toDouble (reqMaxMW (context), context),
            toDouble (reqMinMW (context), context),
            toDouble (selfScheduleMW (context), context),
            AncillaryServiceClearing (context),
            MarketProduct (context),
            MarketRegion (context)
        )
    }
}

/**
 * This class holds elements that are single values for the entire market time horizon.
 * That is, for the Day Ahead market, there is 1 value for each element, not hourly based.  Is a summary of the market run
 */
case class MarketResults
(

    override val sup: BasicElement,

    /**
     * Total  AS Cost (i.e., payment) ($) over the time horizon
     */
    val ancillarySvcCost: Double,

    /**
     * Global Contingent Operating Reserve Availability Indicator (Yes/No)
     */
    val contingentOperatingResAvail: String,

    /**
     * Total Energy Cost ($) over the time horizon
     */
    val energyCost: Double,

    /**
     * Total Minimum Load Cost ($) over the time horizon
     */
    val minimumLoadCost: Double,

    /**
     * Total Start-up Cost ($) over the time horizon
     */
    val startUpCost: Double,

    /**
     * Total Cost (Energy + AS) cost ($) by over the time horizon
     */
    val totalCost: Double,

    /**
     * The total RUC capacity cost for this interval
     */
    val totalRucCost: Double,

    val EnergyMarket: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, 0.0, 0.0, 0.0, 0.0, 0.0, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[MarketResults]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MarketResults
extends
    Parseable[MarketResults]
{
    val sup = BasicElement.parse _
    val ancillarySvcCost = parse_element (element ("""MarketResults.ancillarySvcCost"""))_
    val contingentOperatingResAvail = parse_attribute (attribute ("""MarketResults.contingentOperatingResAvail"""))_
    val energyCost = parse_element (element ("""MarketResults.energyCost"""))_
    val minimumLoadCost = parse_element (element ("""MarketResults.minimumLoadCost"""))_
    val startUpCost = parse_element (element ("""MarketResults.startUpCost"""))_
    val totalCost = parse_element (element ("""MarketResults.totalCost"""))_
    val totalRucCost = parse_element (element ("""MarketResults.totalRucCost"""))_
    val EnergyMarket = parse_attribute (attribute ("""MarketResults.EnergyMarket"""))_
    def parse (context: Context): MarketResults =
    {
        MarketResults(
            sup (context),
            toDouble (ancillarySvcCost (context), context),
            contingentOperatingResAvail (context),
            toDouble (energyCost (context), context),
            toDouble (minimumLoadCost (context), context),
            toDouble (startUpCost (context), context),
            toDouble (totalCost (context), context),
            toDouble (totalRucCost (context), context),
            EnergyMarket (context)
        )
    }
}

/**
 * A statement is a roll up of statement line items.
 * Each statement along with its line items provide the details of specific charges at any given time.  Used by Billing and Settlement
 */
case class MarketStatement
(

    override val sup: Document,

    /**
     * The end of a bill period.
     */
    val end: String,

    /**
     * The version number of previous statement (in the case of true up).
     */
    val referenceNumber: String,

    /**
     * The start of a bill period.
     */
    val start: String,

    /**
     * The date of which Settlement is run.
     */
    val tradeDate: String,

    /**
     * The date of which this statement is issued.
     */
    val transactionDate: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { return (clone ().asInstanceOf[MarketStatement]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MarketStatement
extends
    Parseable[MarketStatement]
{
    val sup = Document.parse _
    val end = parse_element (element ("""MarketStatement.end"""))_
    val referenceNumber = parse_element (element ("""MarketStatement.referenceNumber"""))_
    val start = parse_element (element ("""MarketStatement.start"""))_
    val tradeDate = parse_element (element ("""MarketStatement.tradeDate"""))_
    val transactionDate = parse_element (element ("""MarketStatement.transactionDate"""))_
    def parse (context: Context): MarketStatement =
    {
        MarketStatement(
            sup (context),
            end (context),
            referenceNumber (context),
            start (context),
            tradeDate (context),
            transactionDate (context)
        )
    }
}

/**
 * An individual line item on a statement.
 */
case class MarketStatementLineItem
(

    override val sup: IdentifiedObject,

    /**
     * Current settlement amount.
     */
    val currentAmount: Double,

    /**
     * Current ISO settlement amount.
     */
    val currentISOAmount: Double,

    /**
     * Current ISO settlement quantity.
     */
    val currentISOQuantity: Double,

    /**
     * Current settlement price.
     */
    val currentPrice: Double,

    /**
     * Current settlement quantity, subject to the UOM.
     */
    val currentQuantity: Double,

    /**
     * The date of which the settlement is run.
     */
    val intervalDate: String,

    /**
     * The number of intervals.
     */
    val intervalNumber: String,

    /**
     * Net settlement amount.
     */
    val netAmount: Double,

    /**
     * Net ISO settlement amount.
     */
    val netISOAmount: Double,

    /**
     * Net ISO settlement quantity.
     */
    val netISOQuantity: Double,

    /**
     * Net settlement price.
     */
    val netPrice: Double,

    /**
     * Net settlement quantity, subject to the UOM.
     */
    val netQuantity: Double,

    /**
     * Previous settlement amount.
     */
    val previousAmount: Double,

    /**
     * Previous ISO settlement amount.
     */
    val previousISOAmount: Double,

    /**
     * Previous ISO settlement quantity.
     */
    val previousISOQuantity: Double,

    /**
     * Previous settlement quantity, subject to the UOM.
     */
    val previousQuantity: Double,

    /**
     * Previous settlement price.
     */
    val previsouPrice: Double,

    /**
     * The unit of measure for the quantity element of the line item.
     */
    val quantityUOM: String,

    val ContainerMarketStatementLineItem: String,

    val MarketStatement: String,

    val MktUserAttribute: List[String],

    val PassThroughBill: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, null, List(), null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[MarketStatementLineItem]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MarketStatementLineItem
extends
    Parseable[MarketStatementLineItem]
{
    val sup = IdentifiedObject.parse _
    val currentAmount = parse_element (element ("""MarketStatementLineItem.currentAmount"""))_
    val currentISOAmount = parse_element (element ("""MarketStatementLineItem.currentISOAmount"""))_
    val currentISOQuantity = parse_element (element ("""MarketStatementLineItem.currentISOQuantity"""))_
    val currentPrice = parse_element (element ("""MarketStatementLineItem.currentPrice"""))_
    val currentQuantity = parse_element (element ("""MarketStatementLineItem.currentQuantity"""))_
    val intervalDate = parse_element (element ("""MarketStatementLineItem.intervalDate"""))_
    val intervalNumber = parse_element (element ("""MarketStatementLineItem.intervalNumber"""))_
    val netAmount = parse_element (element ("""MarketStatementLineItem.netAmount"""))_
    val netISOAmount = parse_element (element ("""MarketStatementLineItem.netISOAmount"""))_
    val netISOQuantity = parse_element (element ("""MarketStatementLineItem.netISOQuantity"""))_
    val netPrice = parse_element (element ("""MarketStatementLineItem.netPrice"""))_
    val netQuantity = parse_element (element ("""MarketStatementLineItem.netQuantity"""))_
    val previousAmount = parse_element (element ("""MarketStatementLineItem.previousAmount"""))_
    val previousISOAmount = parse_element (element ("""MarketStatementLineItem.previousISOAmount"""))_
    val previousISOQuantity = parse_element (element ("""MarketStatementLineItem.previousISOQuantity"""))_
    val previousQuantity = parse_element (element ("""MarketStatementLineItem.previousQuantity"""))_
    val previsouPrice = parse_element (element ("""MarketStatementLineItem.previsouPrice"""))_
    val quantityUOM = parse_element (element ("""MarketStatementLineItem.quantityUOM"""))_
    val ContainerMarketStatementLineItem = parse_attribute (attribute ("""MarketStatementLineItem.ContainerMarketStatementLineItem"""))_
    val MarketStatement = parse_attribute (attribute ("""MarketStatementLineItem.MarketStatement"""))_
    val MktUserAttribute = parse_attributes (attribute ("""MarketStatementLineItem.MktUserAttribute"""))_
    val PassThroughBill = parse_attribute (attribute ("""MarketStatementLineItem.PassThroughBill"""))_
    def parse (context: Context): MarketStatementLineItem =
    {
        MarketStatementLineItem(
            sup (context),
            toDouble (currentAmount (context), context),
            toDouble (currentISOAmount (context), context),
            toDouble (currentISOQuantity (context), context),
            toDouble (currentPrice (context), context),
            toDouble (currentQuantity (context), context),
            intervalDate (context),
            intervalNumber (context),
            toDouble (netAmount (context), context),
            toDouble (netISOAmount (context), context),
            toDouble (netISOQuantity (context), context),
            toDouble (netPrice (context), context),
            toDouble (netQuantity (context), context),
            toDouble (previousAmount (context), context),
            toDouble (previousISOAmount (context), context),
            toDouble (previousISOQuantity (context), context),
            toDouble (previousQuantity (context), context),
            toDouble (previsouPrice (context), context),
            quantityUOM (context),
            ContainerMarketStatementLineItem (context),
            MarketStatement (context),
            MktUserAttribute (context),
            PassThroughBill (context)
        )
    }
}

/**
 * Mitigated bid results posted for a given settlement period.
 */
case class MitigatedBid
(

    override val sup: IdentifiedObject,

    val Bid: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[MitigatedBid]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MitigatedBid
extends
    Parseable[MitigatedBid]
{
    val sup = IdentifiedObject.parse _
    val Bid = parse_attribute (attribute ("""MitigatedBid.Bid"""))_
    def parse (context: Context): MitigatedBid =
    {
        MitigatedBid(
            sup (context),
            Bid (context)
        )
    }
}

/**
 * Model of market power mitigation through reference or mitigated bids.
 * Interval based.
 */
case class MitigatedBidClearing
(

    override val sup: MarketFactors
)
extends
    Element
{
    def this () = { this (null) }
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { return (clone ().asInstanceOf[MitigatedBidClearing]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MitigatedBidClearing
extends
    Parseable[MitigatedBidClearing]
{
    val sup = MarketFactors.parse _
    def parse (context: Context): MitigatedBidClearing =
    {
        MitigatedBidClearing(
            sup (context)
        )
    }
}

/**
 * Model of mitigated bid.
 * Indicates segment of piece-wise linear bid, that has been mitigated
 */
case class MitigatedBidSegment
(

    override val sup: BasicElement,

    val intervalStartTime: String,

    /**
     * Mitigated bid segment MW value
     */
    val segmentMW: Double,

    /**
     * Mitigated Bid Segment Number
     */
    val segmentNumber: Int,

    val thresholdType: String,

    val Bid: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, 0, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[MitigatedBidSegment]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MitigatedBidSegment
extends
    Parseable[MitigatedBidSegment]
{
    val sup = BasicElement.parse _
    val intervalStartTime = parse_element (element ("""MitigatedBidSegment.intervalStartTime"""))_
    val segmentMW = parse_element (element ("""MitigatedBidSegment.segmentMW"""))_
    val segmentNumber = parse_element (element ("""MitigatedBidSegment.segmentNumber"""))_
    val thresholdType = parse_element (element ("""MitigatedBidSegment.thresholdType"""))_
    val Bid = parse_attribute (attribute ("""MitigatedBidSegment.Bid"""))_
    def parse (context: Context): MitigatedBidSegment =
    {
        MitigatedBidSegment(
            sup (context),
            intervalStartTime (context),
            toDouble (segmentMW (context), context),
            toInteger (segmentNumber (context), context),
            thresholdType (context),
            Bid (context)
        )
    }
}

/**
 * Pass Through Bill is used for:
1)Two sided charge transactions with or without ISO involvement (hence the ?pass thru?)
2) Specific direct charges or payments that are calculated outside or provided directly to settlements
 * 3) Specific charge bill determinants that are externally supplied and used in charge calculations
 */
case class PassThroughBill
(

    override val sup: Document,

    val adjustedAmount: Double,

    /**
     * The charge amount of the product/service.
     */
    val amount: Double,

    /**
     * Bill period end date
     */
    val billEnd: String,

    /**
     * The settlement run type, for example: prelim, final, and rerun.
     */
    val billRunType: String,

    /**
     * Bill period start date
     */
    val billStart: String,

    /**
     * The company to which the PTB transaction is billed.
     */
    val billedTo: String,

    /**
     * The effective date of the transaction
     */
    val effectiveDate: String,

    /**
     * Disputed transaction indicator
     */
    val isDisputed: Boolean,

    /**
     * A flag indicating whether there is a profile data associated with the PTB.
     */
    val isProfiled: Boolean,

    /**
     * The company to which the PTB transaction is paid.
     */
    val paidTo: String,

    /**
     * The previous bill period end date
     */
    val previousEnd: String,

    /**
     * The previous bill period start date
     */
    val previousStart: String,

    /**
     * The price of product/service.
     */
    val price: Double,

    /**
     * The product identifier for determining the charge type of the transaction.
     */
    val productCode: String,

    /**
     * The company by which the PTB transaction service is provided.
     */
    val providedBy: String,

    /**
     * The product quantity.
     */
    val quantity: String,

    /**
     * The end date of service provided, if periodic.
     */
    val serviceEnd: String,

    /**
     * The start date of service provided, if periodic.
     */
    val serviceStart: String,

    /**
     * The company to which the PTB transaction is sold.
     */
    val soldTo: String,

    /**
     * The tax on services taken.
     */
    val taxAmount: Double,

    /**
     * The time zone code
     */
    val timeZone: String,

    /**
     * The trade date
     */
    val tradeDate: String,

    /**
     * The date the transaction occurs.
     */
    val transactionDate: String,

    /**
     * The type of transaction.
     * For example, charge customer, bill customer, matching AR/AP, or bill determinant
     */
    val transactionType: String,

    val MarketStatementLineItem: String,

    val MktUserAttribute: List[String]
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null, null, null, null, null, false, false, null, null, null, 0.0, null, null, null, null, null, null, 0.0, null, null, null, null, null, List()) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { return (clone ().asInstanceOf[PassThroughBill]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PassThroughBill
extends
    Parseable[PassThroughBill]
{
    val sup = Document.parse _
    val adjustedAmount = parse_element (element ("""PassThroughBill.adjustedAmount"""))_
    val amount = parse_element (element ("""PassThroughBill.amount"""))_
    val billEnd = parse_element (element ("""PassThroughBill.billEnd"""))_
    val billRunType = parse_element (element ("""PassThroughBill.billRunType"""))_
    val billStart = parse_element (element ("""PassThroughBill.billStart"""))_
    val billedTo = parse_element (element ("""PassThroughBill.billedTo"""))_
    val effectiveDate = parse_element (element ("""PassThroughBill.effectiveDate"""))_
    val isDisputed = parse_element (element ("""PassThroughBill.isDisputed"""))_
    val isProfiled = parse_element (element ("""PassThroughBill.isProfiled"""))_
    val paidTo = parse_element (element ("""PassThroughBill.paidTo"""))_
    val previousEnd = parse_element (element ("""PassThroughBill.previousEnd"""))_
    val previousStart = parse_element (element ("""PassThroughBill.previousStart"""))_
    val price = parse_element (element ("""PassThroughBill.price"""))_
    val productCode = parse_element (element ("""PassThroughBill.productCode"""))_
    val providedBy = parse_element (element ("""PassThroughBill.providedBy"""))_
    val quantity = parse_attribute (attribute ("""PassThroughBill.quantity"""))_
    val serviceEnd = parse_element (element ("""PassThroughBill.serviceEnd"""))_
    val serviceStart = parse_element (element ("""PassThroughBill.serviceStart"""))_
    val soldTo = parse_element (element ("""PassThroughBill.soldTo"""))_
    val taxAmount = parse_element (element ("""PassThroughBill.taxAmount"""))_
    val timeZone = parse_element (element ("""PassThroughBill.timeZone"""))_
    val tradeDate = parse_element (element ("""PassThroughBill.tradeDate"""))_
    val transactionDate = parse_element (element ("""PassThroughBill.transactionDate"""))_
    val transactionType = parse_element (element ("""PassThroughBill.transactionType"""))_
    val MarketStatementLineItem = parse_attribute (attribute ("""PassThroughBill.MarketStatementLineItem"""))_
    val MktUserAttribute = parse_attributes (attribute ("""PassThroughBill.MktUserAttribute"""))_
    def parse (context: Context): PassThroughBill =
    {
        PassThroughBill(
            sup (context),
            toDouble (adjustedAmount (context), context),
            toDouble (amount (context), context),
            billEnd (context),
            billRunType (context),
            billStart (context),
            billedTo (context),
            effectiveDate (context),
            toBoolean (isDisputed (context), context),
            toBoolean (isProfiled (context), context),
            paidTo (context),
            previousEnd (context),
            previousStart (context),
            toDouble (price (context), context),
            productCode (context),
            providedBy (context),
            quantity (context),
            serviceEnd (context),
            serviceStart (context),
            soldTo (context),
            toDouble (taxAmount (context), context),
            timeZone (context),
            tradeDate (context),
            transactionDate (context),
            transactionType (context),
            MarketStatementLineItem (context),
            MktUserAttribute (context)
        )
    }
}

/**
 * Pricing node clearing results posted for a given settlement period.
 */
case class PnodeClearing
(

    override val sup: MarketFactors
)
extends
    Element
{
    def this () = { this (null) }
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { return (clone ().asInstanceOf[PnodeClearing]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PnodeClearing
extends
    Parseable[PnodeClearing]
{
    val sup = MarketFactors.parse _
    def parse (context: Context): PnodeClearing =
    {
        PnodeClearing(
            sup (context)
        )
    }
}

/**
 * Provides the total price, the cost component, the loss component, and the congestion component for Pnodes for the forward and real time markets.
 * There are several prices produced based on the run type (MPM, RUC, Pricing, or Scheduling/Dispatch).
 */
case class PnodeResults
(

    override val sup: BasicElement,

    /**
     * Congestion component of Location Marginal Price (LMP) in monetary units per MW.
     */
    val congestLMP: Double,

    /**
     * Cost component of Locational Marginal Pricing (LMP) in monetary units per MW.
     */
    val costLMP: Double,

    /**
     * Loss component of Location Marginal Price (LMP) in monetary units per MW.
     */
    val lossLMP: Double,

    /**
     * Locational Marginal Price (LMP) ($/MWh)
     */
    val marginalClearingPrice: Double,

    /**
     * total MW schedule at the pnode
     */
    val scheduledMW: Double,

    val updateTimeStamp: String,

    val updateType: String,

    val updateUser: String,

    val Pnode: String,

    val PnodeClearing: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[PnodeResults]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PnodeResults
extends
    Parseable[PnodeResults]
{
    val sup = BasicElement.parse _
    val congestLMP = parse_element (element ("""PnodeResults.congestLMP"""))_
    val costLMP = parse_element (element ("""PnodeResults.costLMP"""))_
    val lossLMP = parse_element (element ("""PnodeResults.lossLMP"""))_
    val marginalClearingPrice = parse_element (element ("""PnodeResults.marginalClearingPrice"""))_
    val scheduledMW = parse_element (element ("""PnodeResults.scheduledMW"""))_
    val updateTimeStamp = parse_element (element ("""PnodeResults.updateTimeStamp"""))_
    val updateType = parse_attribute (attribute ("""PnodeResults.updateType"""))_
    val updateUser = parse_element (element ("""PnodeResults.updateUser"""))_
    val Pnode = parse_attribute (attribute ("""PnodeResults.Pnode"""))_
    val PnodeClearing = parse_attribute (attribute ("""PnodeResults.PnodeClearing"""))_
    def parse (context: Context): PnodeResults =
    {
        PnodeResults(
            sup (context),
            toDouble (congestLMP (context), context),
            toDouble (costLMP (context), context),
            toDouble (lossLMP (context), context),
            toDouble (marginalClearingPrice (context), context),
            toDouble (scheduledMW (context), context),
            updateTimeStamp (context),
            updateType (context),
            updateUser (context),
            Pnode (context),
            PnodeClearing (context)
        )
    }
}

/**
 * Indicates whether unit is a reliablity must run unit: required to be on to satisfy Grid Code Reliablitiy criteria, load demand, or voltage support.
 */
case class RMRDetermination
(

    override val sup: BasicElement,

    val Bid: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[RMRDetermination]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RMRDetermination
extends
    Parseable[RMRDetermination]
{
    val sup = BasicElement.parse _
    val Bid = parse_attribute (attribute ("""RMRDetermination.Bid"""))_
    def parse (context: Context): RMRDetermination =
    {
        RMRDetermination(
            sup (context),
            Bid (context)
        )
    }
}

/**
 * RMR Operator's entry of the RMR requirement per market interval.
 */
case class RMROperatorInput
(

    override val sup: MarketFactors,

    /**
     * The lower of the original pre-dispatch or the AC run schedule (Also known as the RMR Reguirement) becomes the pre-dispatch value.
     */
    val manuallySchedRMRMw: Double,

    val updateTimeStamp: String,

    val updateType: String,

    val updateUser: String,

    val RegisteredResource: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null, null, null) }
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { return (clone ().asInstanceOf[RMROperatorInput]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RMROperatorInput
extends
    Parseable[RMROperatorInput]
{
    val sup = MarketFactors.parse _
    val manuallySchedRMRMw = parse_element (element ("""RMROperatorInput.manuallySchedRMRMw"""))_
    val updateTimeStamp = parse_element (element ("""RMROperatorInput.updateTimeStamp"""))_
    val updateType = parse_attribute (attribute ("""RMROperatorInput.updateType"""))_
    val updateUser = parse_element (element ("""RMROperatorInput.updateUser"""))_
    val RegisteredResource = parse_attribute (attribute ("""RMROperatorInput.RegisteredResource"""))_
    def parse (context: Context): RMROperatorInput =
    {
        RMROperatorInput(
            sup (context),
            toDouble (manuallySchedRMRMw (context), context),
            updateTimeStamp (context),
            updateType (context),
            updateUser (context),
            RegisteredResource (context)
        )
    }
}

/**
 * This class models the information about the RUC awards
 */
case class RUCAwardInstruction
(

    override val sup: BasicElement,

    /**
     * Marginal Price ($/MW) for the commodity (Regulation Up, Regulation Down, Spinning Reserve, or Non-spinning reserve) for pricing run.
     */
    val clearedPrice: Double,

    /**
     * major product type may include the following but not limited to:
    
    Energy
    Regulation Up
    Regulation Dn
    Spinning Reserve
    Non-Spinning Reserve
     * Operating Reserve
     */
    val marketProductType: String,

    val updateTimeStamp: String,

    val updateType: String,

    val updateUser: String,

    /**
     * The RUC Award of a resource is the portion of the RUC Capacity that is not under RA or RMR contracts.
     * The RUC Award of a resource is the portion of the RUC Capacity that is eligible for RUC Availability payment.
     */
    val RUCAward: Double,

    /**
     * The RUC Capacity of a resource is the difference between (i) the RUC Schedule and (ii) the higher of the DA Schedule and the Minimum Load.
     */
    val RUCCapacity: Double,

    /**
     * The RUC Schedule of a resource is its output level that balances the load forecast used in RUC.
     * The RUC Schedule in RUC is similar to the DA Schedule in DAM.
     */
    val RUCSchedule: Double,

    val RegisteredResource: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null, null, null, 0.0, 0.0, 0.0, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[RUCAwardInstruction]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RUCAwardInstruction
extends
    Parseable[RUCAwardInstruction]
{
    val sup = BasicElement.parse _
    val clearedPrice = parse_element (element ("""RUCAwardInstruction.clearedPrice"""))_
    val marketProductType = parse_attribute (attribute ("""RUCAwardInstruction.marketProductType"""))_
    val updateTimeStamp = parse_element (element ("""RUCAwardInstruction.updateTimeStamp"""))_
    val updateType = parse_attribute (attribute ("""RUCAwardInstruction.updateType"""))_
    val updateUser = parse_element (element ("""RUCAwardInstruction.updateUser"""))_
    val RUCAward = parse_element (element ("""RUCAwardInstruction.RUCAward"""))_
    val RUCCapacity = parse_element (element ("""RUCAwardInstruction.RUCCapacity"""))_
    val RUCSchedule = parse_element (element ("""RUCAwardInstruction.RUCSchedule"""))_
    val RegisteredResource = parse_attribute (attribute ("""RUCAwardInstruction.RegisteredResource"""))_
    def parse (context: Context): RUCAwardInstruction =
    {
        RUCAwardInstruction(
            sup (context),
            toDouble (clearedPrice (context), context),
            marketProductType (context),
            updateTimeStamp (context),
            updateType (context),
            updateUser (context),
            toDouble (RUCAward (context), context),
            toDouble (RUCCapacity (context), context),
            toDouble (RUCSchedule (context), context),
            RegisteredResource (context)
        )
    }
}

/**
 * Models details of bid and offer market clearing.
 * Class indicates whether a contingency is active and whether the automatic dispatching system is active for this interval of the market solution
 */
case class ResourceAwardClearing
(

    override val sup: MarketFactors,

    /**
     * Indication that the system is currently operating in a contingency mode.
     */
    val contingencyActive: String,

    val dispatchMode: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { return (clone ().asInstanceOf[ResourceAwardClearing]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ResourceAwardClearing
extends
    Parseable[ResourceAwardClearing]
{
    val sup = MarketFactors.parse _
    val contingencyActive = parse_attribute (attribute ("""ResourceAwardClearing.contingencyActive"""))_
    val dispatchMode = parse_attribute (attribute ("""ResourceAwardClearing.dispatchMode"""))_
    def parse (context: Context): ResourceAwardClearing =
    {
        ResourceAwardClearing(
            sup (context),
            contingencyActive (context),
            dispatchMode (context)
        )
    }
}

/**
 * Model of market results, instruction for resource.
 * Contains details of award as attributes
 */
case class ResourceAwardInstruction
(

    override val sup: BasicElement,

    /**
     * For DA Energy: Not Applicable;   
    
    For DA AS: DA AS market award;   
    
    For RT Energy: Not Applicable;
     * For RT AS: RT AS market award (excluding DA AS market or self-proviison awards)
     */
    val awardMW: Double,

    /**
     * For DA Energy: Total Schedule = DA market schedule + DA self-schedule award;   
    
    For DA AS: DA Ancillary Service Awards = DA AS market award + DA AS self-provision award;   
    
    For RT Energy: Total Schedule = RT market schedule + RT self-schedule award;
     * For RT AS: RT Ancillary Service Awards = RT AS self-provision award + RT AS market award + DA AS market award + DA AS self-provision award;
     */
    val clearedMW: Double,

    /**
     * Marginal Price ($/MW) for the commodity (Regulation Up, Regulation Down, Spinning Reserve, or Non-spinning reserve) for pricing run.
     */
    val clearedPrice: Double,

    /**
     * Congestion component of Location Marginal Price (LMP) in monetary units per MW.
     */
    val congestLMP: Double,

    /**
     * Cost component of Locational Marginal Pricing (LMP) in monetary units per MW.
     */
    val costLMP: Double,

    /**
     * The tier2 mw added by dispatcher action
     * Market results of the synchronized reserve market
     */
    val dispatcherAddedMW: Double,

    /**
     * Unit max output for dispatch; bid in economic maximum
     */
    val economicMax: Double,

    /**
     * Unit min output for dispatch; bid in economic minimum
     */
    val economicMin: Double,

    /**
     * Effective Regulation Down Limit (MW)
     */
    val effRegulationDownLimit: Double,

    /**
     * Effective Regulation Up Limit
     */
    val effRegulationUpLimit: Double,

    /**
     * Locational marginal price value
     */
    val lmp: Double,

    /**
     * Loss component of Location Marginal Price (LMP) in monetary units per MW.
     */
    val lossLMP: Double,

    /**
     * Indicates if an award was manually blocked (Y/N).
     * Valid for Spinning and Non-spinning.
     */
    val manuallyBlocked: String,

    /**
     * Indicator (Yes / No) that this resource set the price for this dispatch / schedule.
     */
    val marginalResourceIndicator: String,

    /**
     * Identifes if the unit was set to must run by the market participant responsible for bidding in the unit
     */
    val mustRunInd: Boolean,

    /**
     * Unit no-load cost in case of energy commodity
     */
    val noLoadCost: Double,

    /**
     * Optimal Bid cost
     */
    val optimalBidCost: Double,

    /**
     * Optimal Bid production payment based on LMP
     */
    val optimalBidPay: Double,

    /**
     * Optimal Bid production margin
     */
    val optimalMargin: Double,

    /**
     * Time the manual data entry occured.
     */
    val overrideTimeStamp: String,

    /**
     * Provides the ability for the grid operator to override items, such as spin capacity requirements, prior to running the algorithm.
     * This value is market product based (spin, non-spin, reg up, reg down, or RUC).
     */
    val overrideValue: Double,

    /**
     * For DA Energy: DA total self-schedule award;   
    For DA AS: DA AS self-provision award;   
    For RT Energy: RT total self-schedule award;
     * For RT AS: RT AS self-provision award (excluding DA AS market or self-provision awards)
     */
    val selfSchedMW: Double,

    /**
     * Unit start up cost in case of energy commodity
     */
    val startUpCost: Double,

    /**
     * In or out status of resource
     */
    val status: String,

    /**
     * Total bid revenue (startup_cost + no_load_cost + bid_pay)
     */
    val totalRevenue: Double,

    val updateTimeStamp: String,

    val updateType: String,

    val updateUser: String,

    val MarketProduct: String,

    val RegisteredResource: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, false, 0.0, 0.0, 0.0, 0.0, null, 0.0, 0.0, 0.0, null, 0.0, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ResourceAwardInstruction]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ResourceAwardInstruction
extends
    Parseable[ResourceAwardInstruction]
{
    val sup = BasicElement.parse _
    val awardMW = parse_element (element ("""ResourceAwardInstruction.awardMW"""))_
    val clearedMW = parse_element (element ("""ResourceAwardInstruction.clearedMW"""))_
    val clearedPrice = parse_element (element ("""ResourceAwardInstruction.clearedPrice"""))_
    val congestLMP = parse_element (element ("""ResourceAwardInstruction.congestLMP"""))_
    val costLMP = parse_element (element ("""ResourceAwardInstruction.costLMP"""))_
    val dispatcherAddedMW = parse_element (element ("""ResourceAwardInstruction.dispatcherAddedMW"""))_
    val economicMax = parse_element (element ("""ResourceAwardInstruction.economicMax"""))_
    val economicMin = parse_element (element ("""ResourceAwardInstruction.economicMin"""))_
    val effRegulationDownLimit = parse_element (element ("""ResourceAwardInstruction.effRegulationDownLimit"""))_
    val effRegulationUpLimit = parse_element (element ("""ResourceAwardInstruction.effRegulationUpLimit"""))_
    val lmp = parse_element (element ("""ResourceAwardInstruction.lmp"""))_
    val lossLMP = parse_element (element ("""ResourceAwardInstruction.lossLMP"""))_
    val manuallyBlocked = parse_attribute (attribute ("""ResourceAwardInstruction.manuallyBlocked"""))_
    val marginalResourceIndicator = parse_attribute (attribute ("""ResourceAwardInstruction.marginalResourceIndicator"""))_
    val mustRunInd = parse_element (element ("""ResourceAwardInstruction.mustRunInd"""))_
    val noLoadCost = parse_element (element ("""ResourceAwardInstruction.noLoadCost"""))_
    val optimalBidCost = parse_element (element ("""ResourceAwardInstruction.optimalBidCost"""))_
    val optimalBidPay = parse_element (element ("""ResourceAwardInstruction.optimalBidPay"""))_
    val optimalMargin = parse_element (element ("""ResourceAwardInstruction.optimalMargin"""))_
    val overrideTimeStamp = parse_element (element ("""ResourceAwardInstruction.overrideTimeStamp"""))_
    val overrideValue = parse_element (element ("""ResourceAwardInstruction.overrideValue"""))_
    val selfSchedMW = parse_element (element ("""ResourceAwardInstruction.selfSchedMW"""))_
    val startUpCost = parse_element (element ("""ResourceAwardInstruction.startUpCost"""))_
    val status = parse_element (element ("""ResourceAwardInstruction.status"""))_
    val totalRevenue = parse_element (element ("""ResourceAwardInstruction.totalRevenue"""))_
    val updateTimeStamp = parse_element (element ("""ResourceAwardInstruction.updateTimeStamp"""))_
    val updateType = parse_attribute (attribute ("""ResourceAwardInstruction.updateType"""))_
    val updateUser = parse_element (element ("""ResourceAwardInstruction.updateUser"""))_
    val MarketProduct = parse_attribute (attribute ("""ResourceAwardInstruction.MarketProduct"""))_
    val RegisteredResource = parse_attribute (attribute ("""ResourceAwardInstruction.RegisteredResource"""))_
    def parse (context: Context): ResourceAwardInstruction =
    {
        ResourceAwardInstruction(
            sup (context),
            toDouble (awardMW (context), context),
            toDouble (clearedMW (context), context),
            toDouble (clearedPrice (context), context),
            toDouble (congestLMP (context), context),
            toDouble (costLMP (context), context),
            toDouble (dispatcherAddedMW (context), context),
            toDouble (economicMax (context), context),
            toDouble (economicMin (context), context),
            toDouble (effRegulationDownLimit (context), context),
            toDouble (effRegulationUpLimit (context), context),
            toDouble (lmp (context), context),
            toDouble (lossLMP (context), context),
            manuallyBlocked (context),
            marginalResourceIndicator (context),
            toBoolean (mustRunInd (context), context),
            toDouble (noLoadCost (context), context),
            toDouble (optimalBidCost (context), context),
            toDouble (optimalBidPay (context), context),
            toDouble (optimalMargin (context), context),
            overrideTimeStamp (context),
            toDouble (overrideValue (context), context),
            toDouble (selfSchedMW (context), context),
            toDouble (startUpCost (context), context),
            status (context),
            toDouble (totalRevenue (context), context),
            updateTimeStamp (context),
            updateType (context),
            updateUser (context),
            MarketProduct (context),
            RegisteredResource (context)
        )
    }
}

/**
 * Model of market results, including cleaing result of resources.
 * Associated with ResourceDispatchResults.
 */
case class ResourceClearing
(

    override val sup: MarketFactors
)
extends
    Element
{
    def this () = { this (null) }
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { return (clone ().asInstanceOf[ResourceClearing]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ResourceClearing
extends
    Parseable[ResourceClearing]
{
    val sup = MarketFactors.parse _
    def parse (context: Context): ResourceClearing =
    {
        ResourceClearing(
            sup (context)
        )
    }
}

/**
 * The ResourceDispatchResults class provides market results that can be provided to a SC.
 * The specific data provided consists of several indicators such as contingency flags, blocked start up, and RMR dispatch. It also provides the projected overall and the regulating status of the resource.
 */
case class ResourceDispatchResults
(

    override val sup: BasicElement,

    /**
     * Blocked Dispatch Indicator (Yes/No)
     */
    val blockedDispatch: String,

    /**
     * Block sending DOP to ADS (Y/N)
     */
    val blockedPublishDOP: String,

    /**
     * Contingent Operating Reserve Indicator (Yes/No).
     * Resource participating with AS capacity in contingency dispatch.
     */
    val contingencyFlag: String,

    /**
     * indicate which limit is the constraints
     */
    val limitIndicator: String,

    /**
     * resource energy ramping lower limit
     */
    val lowerLimit: Double,

    /**
     * maximum ramp rate
     */
    val maxRampRate: Double,

    /**
     * The upper operating limit incorporating any derate used by the RTD for the Binding Interval.
     */
    val operatingLimitHigh: Double,

    /**
     * The lower operating limit incorporating any derate used by the RTD for the Binding Interval.
     */
    val operatingLimitLow: Double,

    /**
     * Penalty Dispatch Indicator (Yes / No) indicating an un-economic adjustment.
     */
    val penaltyDispatchIndicator: String,

    /**
     * The upper regulating limit incorporating any derate used by the RTD for the Binding Interval.
     */
    val regulatingLimitHigh: Double,

    /**
     * The lower regulating limit incorporating any derate used by the RTD for the Binding Interval.
     */
    val regulatingLimitLow: Double,

    /**
     * Unit Commitment Status (On/Off/Starting)
     */
    val resourceStatus: String,

    /**
     * Resource total upward schedule.  total schedule = En + all AS per resource per interval
     */
    val totalSchedule: Double,

    val updateTimeStamp: String,

    val updateType: String,

    val updateUser: String,

    /**
     * resource energy ramping upper limit
     */
    val upperLimit: Double,

    val RegisteredResource: String,

    val ResourceClearing: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, 0.0, 0.0, 0.0, 0.0, null, 0.0, 0.0, null, 0.0, null, null, null, 0.0, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ResourceDispatchResults]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ResourceDispatchResults
extends
    Parseable[ResourceDispatchResults]
{
    val sup = BasicElement.parse _
    val blockedDispatch = parse_element (element ("""ResourceDispatchResults.blockedDispatch"""))_
    val blockedPublishDOP = parse_element (element ("""ResourceDispatchResults.blockedPublishDOP"""))_
    val contingencyFlag = parse_attribute (attribute ("""ResourceDispatchResults.contingencyFlag"""))_
    val limitIndicator = parse_element (element ("""ResourceDispatchResults.limitIndicator"""))_
    val lowerLimit = parse_element (element ("""ResourceDispatchResults.lowerLimit"""))_
    val maxRampRate = parse_element (element ("""ResourceDispatchResults.maxRampRate"""))_
    val operatingLimitHigh = parse_element (element ("""ResourceDispatchResults.operatingLimitHigh"""))_
    val operatingLimitLow = parse_element (element ("""ResourceDispatchResults.operatingLimitLow"""))_
    val penaltyDispatchIndicator = parse_attribute (attribute ("""ResourceDispatchResults.penaltyDispatchIndicator"""))_
    val regulatingLimitHigh = parse_element (element ("""ResourceDispatchResults.regulatingLimitHigh"""))_
    val regulatingLimitLow = parse_element (element ("""ResourceDispatchResults.regulatingLimitLow"""))_
    val resourceStatus = parse_element (element ("""ResourceDispatchResults.resourceStatus"""))_
    val totalSchedule = parse_element (element ("""ResourceDispatchResults.totalSchedule"""))_
    val updateTimeStamp = parse_element (element ("""ResourceDispatchResults.updateTimeStamp"""))_
    val updateType = parse_attribute (attribute ("""ResourceDispatchResults.updateType"""))_
    val updateUser = parse_element (element ("""ResourceDispatchResults.updateUser"""))_
    val upperLimit = parse_element (element ("""ResourceDispatchResults.upperLimit"""))_
    val RegisteredResource = parse_attribute (attribute ("""ResourceDispatchResults.RegisteredResource"""))_
    val ResourceClearing = parse_attribute (attribute ("""ResourceDispatchResults.ResourceClearing"""))_
    def parse (context: Context): ResourceDispatchResults =
    {
        ResourceDispatchResults(
            sup (context),
            blockedDispatch (context),
            blockedPublishDOP (context),
            contingencyFlag (context),
            limitIndicator (context),
            toDouble (lowerLimit (context), context),
            toDouble (maxRampRate (context), context),
            toDouble (operatingLimitHigh (context), context),
            toDouble (operatingLimitLow (context), context),
            penaltyDispatchIndicator (context),
            toDouble (regulatingLimitHigh (context), context),
            toDouble (regulatingLimitLow (context), context),
            resourceStatus (context),
            toDouble (totalSchedule (context), context),
            updateTimeStamp (context),
            updateType (context),
            updateUser (context),
            toDouble (upperLimit (context), context),
            RegisteredResource (context),
            ResourceClearing (context)
        )
    }
}

/**
 * Model of market clearing results for resources that bid to follow load
 */
case class ResourceLoadFollowingInst
(

    override val sup: BasicElement,

    /**
     * weighted average for RTPD and RTCD and same for RTID
     */
    val calcLoadFollowingMW: Double,

    val dispWindowHighLimt: Double,

    val dispWindowLowLimt: Double,

    /**
     * Unique instruction id per instruction, assigned by the SC and provided to ADS.
     * ADS passes through.
     */
    val instructionID: String,

    /**
     * The start of the time interval for which requirement is defined.
     */
    val intervalStartTime: String,

    val RegisteredResource: String,

    val ResourceClearing: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ResourceLoadFollowingInst]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ResourceLoadFollowingInst
extends
    Parseable[ResourceLoadFollowingInst]
{
    val sup = BasicElement.parse _
    val calcLoadFollowingMW = parse_element (element ("""ResourceLoadFollowingInst.calcLoadFollowingMW"""))_
    val dispWindowHighLimt = parse_element (element ("""ResourceLoadFollowingInst.dispWindowHighLimt"""))_
    val dispWindowLowLimt = parse_element (element ("""ResourceLoadFollowingInst.dispWindowLowLimt"""))_
    val instructionID = parse_element (element ("""ResourceLoadFollowingInst.instructionID"""))_
    val intervalStartTime = parse_element (element ("""ResourceLoadFollowingInst.intervalStartTime"""))_
    val RegisteredResource = parse_attribute (attribute ("""ResourceLoadFollowingInst.RegisteredResource"""))_
    val ResourceClearing = parse_attribute (attribute ("""ResourceLoadFollowingInst.ResourceClearing"""))_
    def parse (context: Context): ResourceLoadFollowingInst =
    {
        ResourceLoadFollowingInst(
            sup (context),
            toDouble (calcLoadFollowingMW (context), context),
            toDouble (dispWindowHighLimt (context), context),
            toDouble (dispWindowLowLimt (context), context),
            instructionID (context),
            intervalStartTime (context),
            RegisteredResource (context),
            ResourceClearing (context)
        )
    }
}

/**
 * Model of Self Schedules Results.
 * Includes self schedule MW,and type of self schedule for each self schedule type included in total self schedule MW value found in ResourceAwardInstruction.
 */
case class SelfScheduleBreakdown
(

    override val sup: BasicElement,

    /**
     * Cleared value for the specific self schedule type listed.
     */
    val selfSchedMW: Double,

    /**
     * Self schedule breakdown type.
     */
    val selfSchedType: String,

    val ResourceAwardInstruction: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[SelfScheduleBreakdown]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SelfScheduleBreakdown
extends
    Parseable[SelfScheduleBreakdown]
{
    val sup = BasicElement.parse _
    val selfSchedMW = parse_element (element ("""SelfScheduleBreakdown.selfSchedMW"""))_
    val selfSchedType = parse_attribute (attribute ("""SelfScheduleBreakdown.selfSchedType"""))_
    val ResourceAwardInstruction = parse_attribute (attribute ("""SelfScheduleBreakdown.ResourceAwardInstruction"""))_
    def parse (context: Context): SelfScheduleBreakdown =
    {
        SelfScheduleBreakdown(
            sup (context),
            toDouble (selfSchedMW (context), context),
            selfSchedType (context),
            ResourceAwardInstruction (context)
        )
    }
}

/**
 * Specifies a settlement run.
 */
case class Settlement
(

    override val sup: Document,

    /**
     * The trade date on which the settlement is run.
     */
    val tradeDate: String,

    val EnergyMarket: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { return (clone ().asInstanceOf[Settlement]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Settlement
extends
    Parseable[Settlement]
{
    val sup = Document.parse _
    val tradeDate = parse_element (element ("""Settlement.tradeDate"""))_
    val EnergyMarket = parse_attribute (attribute ("""Settlement.EnergyMarket"""))_
    def parse (context: Context): Settlement =
    {
        Settlement(
            sup (context),
            tradeDate (context),
            EnergyMarket (context)
        )
    }
}

/**
 * Contains the intervals relavent for the associated TransactionBidResults.
 * For example, Day Ahead cleared results for the transaction bids for each interval of the market day.
 */
case class TransactionBidClearing
(

    override val sup: MarketFactors
)
extends
    Element
{
    def this () = { this (null) }
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { return (clone ().asInstanceOf[TransactionBidClearing]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TransactionBidClearing
extends
    Parseable[TransactionBidClearing]
{
    val sup = MarketFactors.parse _
    def parse (context: Context): TransactionBidClearing =
    {
        TransactionBidClearing(
            sup (context)
        )
    }
}

/**
 * Contains the cleared results for each TransactionBid submitted to and accepted by the market.
 */
case class TransactionBidResults
(

    override val sup: IdentifiedObject,

    /**
     * The market transaction megawatt
     */
    val clearedMW: Double,

    /**
     * The price of the market transaction
     */
    val clearedPrice: Double,

    val TransactionBid: String,

    val TransactionBidClearing: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[TransactionBidResults]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TransactionBidResults
extends
    Parseable[TransactionBidResults]
{
    val sup = IdentifiedObject.parse _
    val clearedMW = parse_element (element ("""TransactionBidResults.clearedMW"""))_
    val clearedPrice = parse_element (element ("""TransactionBidResults.clearedPrice"""))_
    val TransactionBid = parse_attribute (attribute ("""TransactionBidResults.TransactionBid"""))_
    val TransactionBidClearing = parse_attribute (attribute ("""TransactionBidResults.TransactionBidClearing"""))_
    def parse (context: Context): TransactionBidResults =
    {
        TransactionBidResults(
            sup (context),
            toDouble (clearedMW (context), context),
            toDouble (clearedPrice (context), context),
            TransactionBid (context),
            TransactionBidClearing (context)
        )
    }
}

object _MarketResults
{
    def register: Unit =
    {
        AncillaryServiceClearing.register
        BillDeterminant.register
        ChargeProfile.register
        ChargeProfileData.register
        CommitmentClearing.register
        Commitments.register
        ConstraintClearing.register
        ConstraintResults.register
        DopInstruction.register
        DotInstruction.register
        ExPostLoss.register
        ExPostLossResults.register
        ExPostMarketRegion.register
        ExPostMarketRegionResults.register
        ExPostPricing.register
        ExPostPricingResults.register
        ExPostResource.register
        ExPostResourceResults.register
        GeneralClearing.register
        GeneralClearingResults.register
        InstructionClearing.register
        InstructionClearingDOP.register
        InstructionClearingDOT.register
        Instructions.register
        LoadFollowingOperatorInput.register
        LossClearing.register
        LossClearingResults.register
        MPMClearing.register
        MPMResourceStatus.register
        MPMTestResults.register
        MarketRegionResults.register
        MarketResults.register
        MarketStatement.register
        MarketStatementLineItem.register
        MitigatedBid.register
        MitigatedBidClearing.register
        MitigatedBidSegment.register
        PassThroughBill.register
        PnodeClearing.register
        PnodeResults.register
        RMRDetermination.register
        RMROperatorInput.register
        RUCAwardInstruction.register
        ResourceAwardClearing.register
        ResourceAwardInstruction.register
        ResourceClearing.register
        ResourceDispatchResults.register
        ResourceLoadFollowingInst.register
        SelfScheduleBreakdown.register
        Settlement.register
        TransactionBidClearing.register
        TransactionBidResults.register
    }
}