package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * Results from the execution of a market.
 */

/**
 * Model of results of market clearing with respect to  Ancillary Service products
 * @param sup Reference to the superclass object.
 * @param MarketCaseClearing
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
    val MarketCaseClearing = parse_attribute (attribute ("""AncillaryServiceClearing.MarketCaseClearing"""))
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
 * @param sup Reference to the superclass object.
 * @param calculationLevel Level in charge calculation order.
 * @param configVersion The version of configuration of calculation logic in the settlement.
 * @param deleteStatus
 * @param effectiveDate
 * @param exception
 * @param factor
 * @param frequency
 * @param numberInterval Number of intervals of bill determiant in trade day, eg 300 for five minute intervals.
 * @param offset
 * @param precisionLevel The level of precision in the current value.
 * @param primaryYN
 * @param referenceFlag
 * @param reportable
 * @param roundOff
 * @param source
 * @param terminationDate
 * @param unitOfMeasure The UOM for the current value of the Bill Determinant.
 * @param ChargeProfile
 * @param MktUserAttribute
 */
case class BillDeterminant
(
    override val sup: Document,
    val calculationLevel: String,
    val configVersion: String,
    val deleteStatus: String,
    val effectiveDate: String,
    val exception: String,
    val factor: String,
    val frequency: String,
    val numberInterval: Int,
    val offset: String,
    val precisionLevel: String,
    val primaryYN: String,
    val referenceFlag: String,
    val reportable: String,
    val roundOff: String,
    val source: String,
    val terminationDate: String,
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
    val calculationLevel = parse_element (element ("""BillDeterminant.calculationLevel"""))
    val configVersion = parse_element (element ("""BillDeterminant.configVersion"""))
    val deleteStatus = parse_element (element ("""BillDeterminant.deleteStatus"""))
    val effectiveDate = parse_element (element ("""BillDeterminant.effectiveDate"""))
    val exception = parse_element (element ("""BillDeterminant.exception"""))
    val factor = parse_element (element ("""BillDeterminant.factor"""))
    val frequency = parse_element (element ("""BillDeterminant.frequency"""))
    val numberInterval = parse_element (element ("""BillDeterminant.numberInterval"""))
    val offset = parse_element (element ("""BillDeterminant.offset"""))
    val precisionLevel = parse_element (element ("""BillDeterminant.precisionLevel"""))
    val primaryYN = parse_element (element ("""BillDeterminant.primaryYN"""))
    val referenceFlag = parse_element (element ("""BillDeterminant.referenceFlag"""))
    val reportable = parse_element (element ("""BillDeterminant.reportable"""))
    val roundOff = parse_element (element ("""BillDeterminant.roundOff"""))
    val source = parse_element (element ("""BillDeterminant.source"""))
    val terminationDate = parse_element (element ("""BillDeterminant.terminationDate"""))
    val unitOfMeasure = parse_element (element ("""BillDeterminant.unitOfMeasure"""))
    val ChargeProfile = parse_attribute (attribute ("""BillDeterminant.ChargeProfile"""))
    val MktUserAttribute = parse_attributes (attribute ("""BillDeterminant.MktUserAttribute"""))
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
 * @param sup Reference to the superclass object.
 * @param frequency The calculation frequency, daily or monthly.
 * @param numberInterval The number of intervals in the profile data.
 * @param typ The type of profile.
 *        It could be amount, price, or quantity.
 * @param unitOfMeasure The unit of measure applied to the value attribute of the profile data.
 * @param Bid
 * @param BillDeterminant
 * @param PassTroughBill
 */
case class ChargeProfile
(
    override val sup: Profile,
    val frequency: String,
    val numberInterval: Int,
    val typ: String,
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
    val frequency = parse_element (element ("""ChargeProfile.frequency"""))
    val numberInterval = parse_element (element ("""ChargeProfile.numberInterval"""))
    val typ = parse_element (element ("""ChargeProfile.type"""))
    val unitOfMeasure = parse_element (element ("""ChargeProfile.unitOfMeasure"""))
    val Bid = parse_attribute (attribute ("""ChargeProfile.Bid"""))
    val BillDeterminant = parse_attribute (attribute ("""ChargeProfile.BillDeterminant"""))
    val PassTroughBill = parse_attribute (attribute ("""ChargeProfile.PassTroughBill"""))
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
 * @param sup Reference to the superclass object.
 * @param sequence The sequence number of the profile.
 * @param timeStamp The date and time of an interval.
 * @param value The value of an interval given a profile type (amount, price, or quantity), subject to the UOM.
 * @param BillDeterminant
 * @param ChargeProfile
 */
case class ChargeProfileData
(
    override val sup: BasicElement,
    val sequence: Int,
    val timeStamp: String,
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
    val sequence = parse_element (element ("""ChargeProfileData.sequence"""))
    val timeStamp = parse_element (element ("""ChargeProfileData.timeStamp"""))
    val value = parse_element (element ("""ChargeProfileData.value"""))
    val BillDeterminant = parse_attribute (attribute ("""ChargeProfileData.BillDeterminant"""))
    val ChargeProfile = parse_attribute (attribute ("""ChargeProfileData.ChargeProfile"""))
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
 * @param sup Reference to the superclass object.
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
 * @param sup Reference to the superclass object.
 * @param commitmentType the type of UC status (self commitment, ISO commitment, or SCUC commitment)
 * @param instructionCost Total cost associated with changing the status of the resource.
 * @param instructionType Indicator of either a Start-Up or a Shut-Down.
 * @param intervalEndTime End time for the commitment period.
 *        This will be on an interval boundary.
 * @param intervalStartTime Start time for the commitment period.
 *        This will be on an interval boundary.
 * @param minStatusChangeTime SCUC commitment period start-up time.
 *        Calculated start up time based on the StartUpTimeCurve provided with the Bid.
 * @param noLoadCost Unit no load cost in case of energy commodity
 * @param updateTimeStamp
 * @param updateType
 * @param updateUser
 * @param RegisteredResource
 */
case class Commitments
(
    override val sup: BasicElement,
    val commitmentType: String,
    val instructionCost: Double,
    val instructionType: String,
    val intervalEndTime: String,
    val intervalStartTime: String,
    val minStatusChangeTime: Int,
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
    val commitmentType = parse_attribute (attribute ("""Commitments.commitmentType"""))
    val instructionCost = parse_element (element ("""Commitments.instructionCost"""))
    val instructionType = parse_attribute (attribute ("""Commitments.instructionType"""))
    val intervalEndTime = parse_element (element ("""Commitments.intervalEndTime"""))
    val intervalStartTime = parse_element (element ("""Commitments.intervalStartTime"""))
    val minStatusChangeTime = parse_element (element ("""Commitments.minStatusChangeTime"""))
    val noLoadCost = parse_element (element ("""Commitments.noLoadCost"""))
    val updateTimeStamp = parse_element (element ("""Commitments.updateTimeStamp"""))
    val updateType = parse_attribute (attribute ("""Commitments.updateType"""))
    val updateUser = parse_element (element ("""Commitments.updateUser"""))
    val RegisteredResource = parse_attribute (attribute ("""Commitments.RegisteredResource"""))
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
 * @param sup Reference to the superclass object.
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
 * @param sup Reference to the superclass object.
 * @param baseFlow Branch base Power Flow.
 * @param bindingLimit MW Limit.
 * @param clearedValue Cleared MW.
 * @param competitivePathConstraint Non-competitive path constraint Flag"(Y/N)  indicating whether the shadow price on a non-competitive path was non-zero.
 * @param constraintType Type of constraint.
 * @param limitFlag Limit flag ('Maximum', 'Minimum').
 * @param optimizationFlag Included in optimization Y/N.
 * @param overloadMW Transmission overload MW.
 * @param percentMW Actual MW flow as percent of limit.
 * @param shadowPrice Shadow Price ($/MW) for the commodity.
 *        Shadow price for the corresponding constraint.
 * @param updateTimeStamp Update time stamp.
 * @param updateType MQS change type.
 * @param updateUser Updated user.
 * @param BGLimit This value is determined in DA and RTM.
 *        The SCUC optimization ensures that the MW flow on the Branch Group will not exceed this limit in the relevant direction.
 * @param BGTRResCap Branch Group TR Reservation Capacity - This value is determined in DA and RTM.
 *        It is the amount of spare transmission capacity that is left for the TR holder to use.
 * @param ConstraintClearing
 * @param Flowgate
 * @param MktContingency
 */
case class ConstraintResults
(
    override val sup: IdentifiedObject,
    val baseFlow: Double,
    val bindingLimit: Double,
    val clearedValue: Double,
    val competitivePathConstraint: String,
    val constraintType: String,
    val limitFlag: String,
    val optimizationFlag: String,
    val overloadMW: Double,
    val percentMW: Double,
    val shadowPrice: Double,
    val updateTimeStamp: String,
    val updateType: String,
    val updateUser: String,
    val BGLimit: Double,
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
    val baseFlow = parse_element (element ("""ConstraintResults.baseFlow"""))
    val bindingLimit = parse_element (element ("""ConstraintResults.bindingLimit"""))
    val clearedValue = parse_element (element ("""ConstraintResults.clearedValue"""))
    val competitivePathConstraint = parse_attribute (attribute ("""ConstraintResults.competitivePathConstraint"""))
    val constraintType = parse_attribute (attribute ("""ConstraintResults.constraintType"""))
    val limitFlag = parse_attribute (attribute ("""ConstraintResults.limitFlag"""))
    val optimizationFlag = parse_attribute (attribute ("""ConstraintResults.optimizationFlag"""))
    val overloadMW = parse_element (element ("""ConstraintResults.overloadMW"""))
    val percentMW = parse_element (element ("""ConstraintResults.percentMW"""))
    val shadowPrice = parse_element (element ("""ConstraintResults.shadowPrice"""))
    val updateTimeStamp = parse_element (element ("""ConstraintResults.updateTimeStamp"""))
    val updateType = parse_attribute (attribute ("""ConstraintResults.updateType"""))
    val updateUser = parse_element (element ("""ConstraintResults.updateUser"""))
    val BGLimit = parse_element (element ("""ConstraintResults.BGLimit"""))
    val BGTRResCap = parse_element (element ("""ConstraintResults.BGTRResCap"""))
    val ConstraintClearing = parse_attribute (attribute ("""ConstraintResults.ConstraintClearing"""))
    val Flowgate = parse_attribute (attribute ("""ConstraintResults.Flowgate"""))
    val MktContingency = parse_attribute (attribute ("""ConstraintResults.MktContingency"""))
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
 * @param sup Reference to the superclass object.
 * @param mwDOP Dispatched Operating Point (MW)
 * @param plotPriority A value used to establish priority of the DOP when plotting.
 *        This is only applicable when two DOPs exist for the same time, but with different MW values.  E.g. when indicating a step in the curve.  Its used to determine if the curve steps up or down.
 * @param runIndicatorDOP Indication of DOP validity.
 *        Shows the DOP is calculated from the latest run (YES). A NO indicator shows that the DOP is copied from a previous execution.
 * @param timestampDOP DOP time stamp
 * @param updateTimeStamp
 * @param updateType
 * @param updateUser
 * @param RegisteredResouce
 */
case class DopInstruction
(
    override val sup: BasicElement,
    val mwDOP: Double,
    val plotPriority: Int,
    val runIndicatorDOP: String,
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
    val mwDOP = parse_element (element ("""DopInstruction.mwDOP"""))
    val plotPriority = parse_element (element ("""DopInstruction.plotPriority"""))
    val runIndicatorDOP = parse_attribute (attribute ("""DopInstruction.runIndicatorDOP"""))
    val timestampDOP = parse_element (element ("""DopInstruction.timestampDOP"""))
    val updateTimeStamp = parse_element (element ("""DopInstruction.updateTimeStamp"""))
    val updateType = parse_attribute (attribute ("""DopInstruction.updateType"""))
    val updateUser = parse_element (element ("""DopInstruction.updateUser"""))
    val RegisteredResouce = parse_attribute (attribute ("""DopInstruction.RegisteredResouce"""))
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
 * @param sup Reference to the superclass object.
 * @param actualRampRate Actual ramp rate.
 * @param compliantIndicator Flag indicating whether or not the resource was in compliance with the instruction (plus/minus 10%).
 *        Directs if a unit is allowed to set the price (ex-post pricing).
 * @param economicMaxOverride Economic Max Limit override for unit, this value is null, if it is not, this value overrides the Energy column value.
 *        Allows dispatcher to override the unit's energy value.
 * @param expectedEnergy Expected energy.
 * @param generatorPerformanceDegree The Degree of Generator Performance (DGP) used for the unit.
 *        Measure of how a generator responds to raise /lower signals.  Calculated every five minutes.
 * @param hourAheadSchedEnergy HASP results.
 * @param hourlySchedule Hourly Schedule (DA Energy Schedule).
 * @param instructionTime The date/time for the instruction.
 * @param maximumEmergencyInd True if maximum emergency limit activated; false otherwise.
 *        If unit is requested  to move up to its max emergency limit., this flag is set to true.
 * @param meterLoadFollowing Meter Sub System Load Following.
 * @param nonRampRestrictedMW Desired MW that is not ramp restricted.
 *        If no ramp rate limit existed for the unit, this is the MW value tha t the unit was requested to move to.
 * @param nonSpinReserve Non Spin Reserve used to procure energy.
 * @param previousDOTTimeStamp Timestamp when the previous DOT value was issued.
 * @param rampRateLimit The ramp rate limit for the unit in MWs per minute.
 *        Participant bidding data.
 * @param regulationStatus Regulation Status (Yes/No).
 * @param spinReserve Spin Reserve used to procure energy.
 * @param standardRampEnergy Standard ramping energy (MWH).
 * @param supplementalEnergy Supplemental Energy procure by Real Time Dispatch.
 * @param unitStatus Output results from the case identifying the reason the unit was committed by the software.
 * @param DOT Dispatch operating target value.
 * @param RegisteredResource
 */
case class DotInstruction
(
    override val sup: BasicElement,
    val actualRampRate: Double,
    val compliantIndicator: String,
    val economicMaxOverride: Double,
    val expectedEnergy: Double,
    val generatorPerformanceDegree: Double,
    val hourAheadSchedEnergy: Double,
    val hourlySchedule: Double,
    val instructionTime: String,
    val maximumEmergencyInd: Boolean,
    val meterLoadFollowing: Double,
    val nonRampRestrictedMW: Double,
    val nonSpinReserve: Double,
    val previousDOTTimeStamp: String,
    val rampRateLimit: Double,
    val regulationStatus: String,
    val spinReserve: Double,
    val standardRampEnergy: Double,
    val supplementalEnergy: Double,
    val unitStatus: Int,
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
    val actualRampRate = parse_element (element ("""DotInstruction.actualRampRate"""))
    val compliantIndicator = parse_attribute (attribute ("""DotInstruction.compliantIndicator"""))
    val economicMaxOverride = parse_element (element ("""DotInstruction.economicMaxOverride"""))
    val expectedEnergy = parse_element (element ("""DotInstruction.expectedEnergy"""))
    val generatorPerformanceDegree = parse_element (element ("""DotInstruction.generatorPerformanceDegree"""))
    val hourAheadSchedEnergy = parse_element (element ("""DotInstruction.hourAheadSchedEnergy"""))
    val hourlySchedule = parse_element (element ("""DotInstruction.hourlySchedule"""))
    val instructionTime = parse_element (element ("""DotInstruction.instructionTime"""))
    val maximumEmergencyInd = parse_element (element ("""DotInstruction.maximumEmergencyInd"""))
    val meterLoadFollowing = parse_element (element ("""DotInstruction.meterLoadFollowing"""))
    val nonRampRestrictedMW = parse_element (element ("""DotInstruction.nonRampRestrictedMW"""))
    val nonSpinReserve = parse_element (element ("""DotInstruction.nonSpinReserve"""))
    val previousDOTTimeStamp = parse_element (element ("""DotInstruction.previousDOTTimeStamp"""))
    val rampRateLimit = parse_element (element ("""DotInstruction.rampRateLimit"""))
    val regulationStatus = parse_attribute (attribute ("""DotInstruction.regulationStatus"""))
    val spinReserve = parse_element (element ("""DotInstruction.spinReserve"""))
    val standardRampEnergy = parse_element (element ("""DotInstruction.standardRampEnergy"""))
    val supplementalEnergy = parse_element (element ("""DotInstruction.supplementalEnergy"""))
    val unitStatus = parse_element (element ("""DotInstruction.unitStatus"""))
    val DOT = parse_element (element ("""DotInstruction.DOT"""))
    val RegisteredResource = parse_attribute (attribute ("""DotInstruction.RegisteredResource"""))
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
 * @param sup Reference to the superclass object.
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
 * @param sup Reference to the superclass object.
 * @param ehvLossMW EHV MW losses in the company
 *        Attribute Usage: Information purposes - Output of LPA engine.
 * @param totalLossMW Total MW losses in the company
 *        Attribute Usage: Information purposes - Output of LPA engine.
 * @param ExPostLoss
 * @param SubControlArea
 */
case class ExPostLossResults
(
    override val sup: BasicElement,
    val ehvLossMW: Double,
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
    val ehvLossMW = parse_element (element ("""ExPostLossResults.ehvLossMW"""))
    val totalLossMW = parse_element (element ("""ExPostLossResults.totalLossMW"""))
    val ExPostLoss = parse_attribute (attribute ("""ExPostLossResults.ExPostLoss"""))
    val SubControlArea = parse_attribute (attribute ("""ExPostLossResults.SubControlArea"""))
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
 * @param sup Reference to the superclass object.
 * @param ExPostMarketRegionResults
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
    val ExPostMarketRegionResults = parse_attribute (attribute ("""ExPostMarketRegion.ExPostMarketRegionResults"""))
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
 * @param sup Reference to the superclass object.
 * @param exPostClearedPrice
 * @param ExPostMarketRegion
 * @param MarketRegion
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
    val exPostClearedPrice = parse_element (element ("""ExPostMarketRegionResults.exPostClearedPrice"""))
    val ExPostMarketRegion = parse_attribute (attribute ("""ExPostMarketRegionResults.ExPostMarketRegion"""))
    val MarketRegion = parse_attribute (attribute ("""ExPostMarketRegionResults.MarketRegion"""))
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
 * @param sup Reference to the superclass object.
 * @param energyPrice market energy price
 */
case class ExPostPricing
(
    override val sup: MarketFactors,
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
    val energyPrice = parse_element (element ("""ExPostPricing.energyPrice"""))
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
 * @param sup Reference to the superclass object.
 * @param congestLMP Congestion component of Location Marginal Price (LMP) in monetary units per MW; congestion component of the hourly LMP at a specific pricing node
 *        Attribute Usage: Result of the Security, Pricing, and Dispatch(SPD)/Simultaneous Feasibility Test(SFT) software and denotes the hourly congestion component of LMP for each pricing node.
 * @param lmp 5 min weighted average LMP; the Location Marginal Price of the Pnode for which price calculation is carried out.
 *        Attribute Usage: 5 min weighted average LMP  to be displayed on UI
 * @param lossLMP Loss component of Location Marginal Price (LMP) in monetary units per MW; loss component of the hourly LMP at a specific pricing node
 *        Attribute Usage: Result of the Security, Pricing, and Dispatch(SPD)/Simultaneous Feasibility Test(SFT) software and denotes the hourly loss component of LMP for each pricing node.
 * @param ExPostPricing
 * @param Pnode
 */
case class ExPostPricingResults
(
    override val sup: BasicElement,
    val congestLMP: Double,
    val lmp: Double,
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
    val congestLMP = parse_element (element ("""ExPostPricingResults.congestLMP"""))
    val lmp = parse_element (element ("""ExPostPricingResults.lmp"""))
    val lossLMP = parse_element (element ("""ExPostPricingResults.lossLMP"""))
    val ExPostPricing = parse_attribute (attribute ("""ExPostPricingResults.ExPostPricing"""))
    val Pnode = parse_attribute (attribute ("""ExPostPricingResults.Pnode"""))
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
 * @param sup Reference to the superclass object.
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
 * @param sup Reference to the superclass object.
 * @param congestionLMP LMP component in USD (deprecated)
 * @param desiredMW Desired output of unit
 * @param dispatchRate Unit Dispatch rate from real time unit dispatch.
 * @param lmp LMP (Local Marginal Price) in USD at the equipment (deprecated)
 * @param lossLMP loss lmp (deprecated)
 * @param maxEconomicMW Economic Maximum MW
 * @param minEconomicMW Economic Minimum MW
 * @param resourceMW Current MW output of the equipment
 *        Attribute Usage: Information purposes - Information purposes - Output of LPA engine.
 * @param status Status of equipment
 * @param ExPostResource
 * @param RegisteredResource
 */
case class ExPostResourceResults
(
    override val sup: BasicElement,
    val congestionLMP: Double,
    val desiredMW: Double,
    val dispatchRate: Double,
    val lmp: Double,
    val lossLMP: Double,
    val maxEconomicMW: Double,
    val minEconomicMW: Double,
    val resourceMW: Double,
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
    val congestionLMP = parse_element (element ("""ExPostResourceResults.congestionLMP"""))
    val desiredMW = parse_element (element ("""ExPostResourceResults.desiredMW"""))
    val dispatchRate = parse_element (element ("""ExPostResourceResults.dispatchRate"""))
    val lmp = parse_element (element ("""ExPostResourceResults.lmp"""))
    val lossLMP = parse_element (element ("""ExPostResourceResults.lossLMP"""))
    val maxEconomicMW = parse_element (element ("""ExPostResourceResults.maxEconomicMW"""))
    val minEconomicMW = parse_element (element ("""ExPostResourceResults.minEconomicMW"""))
    val resourceMW = parse_element (element ("""ExPostResourceResults.resourceMW"""))
    val status = parse_attribute (attribute ("""ExPostResourceResults.status"""))
    val ExPostResource = parse_attribute (attribute ("""ExPostResourceResults.ExPostResource"""))
    val RegisteredResource = parse_attribute (attribute ("""ExPostResourceResults.RegisteredResource"""))
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
 * @param sup Reference to the superclass object.
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
 * @param sup Reference to the superclass object.
 * @param loadForecast Load Prediction/Forecast (MW), by Time Period (5', 10', 15')
 * @param totalLoad Amount of load in the control zone
 *        Attribute Usage: hourly load value for the specific area
 * @param totalNetInterchange Amount of interchange for the control zone
 *        Attribute Usage: hourly interchange value for the specific area
 * @param GeneralClearing
 * @param SubControlArea
 */
case class GeneralClearingResults
(
    override val sup: BasicElement,
    val loadForecast: Double,
    val totalLoad: Double,
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
    val loadForecast = parse_element (element ("""GeneralClearingResults.loadForecast"""))
    val totalLoad = parse_element (element ("""GeneralClearingResults.totalLoad"""))
    val totalNetInterchange = parse_element (element ("""GeneralClearingResults.totalNetInterchange"""))
    val GeneralClearing = parse_attribute (attribute ("""GeneralClearingResults.GeneralClearing"""))
    val SubControlArea = parse_attribute (attribute ("""GeneralClearingResults.SubControlArea"""))
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
 * @param sup Reference to the superclass object.
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
 * @param sup Reference to the superclass object.
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
 * @param sup Reference to the superclass object.
 * @param contingencyActive Indication that the system is currently operating in a contingency mode.
 * @param dispatchMode
 */
case class InstructionClearingDOT
(
    override val sup: MarketFactors,
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
    val contingencyActive = parse_attribute (attribute ("""InstructionClearingDOT.contingencyActive"""))
    val dispatchMode = parse_attribute (attribute ("""InstructionClearingDOT.dispatchMode"""))
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
 * @param sup Reference to the superclass object.
 * @param bindingDOT
 * @param bindingInstruction
 * @param instructionCost Total cost associated with changing the status of the resource.
 * @param instructionSource instruction source for market quality results (INS, ACT)
 * @param instructionStartTime Time the resource should be at Pmin (for start ups).
 *        Time the resource is off line.
 * @param instructionType Indicator of either a Start-Up or a Shut-Down.
 * @param manuallyBlocked Manually Blocked Indicator (Yes/No).
 *        The instruction has been blocked by an Operator.
 * @param minStatusChangeTime Minimum start up time required to bring the unit online (minutes).
 *        SCUC commitment period start-up time. Calculated start up time based on the StartUpTimeCurve provided with the Bid.
 * @param updateTimeStamp
 * @param updateType
 * @param updateUser
 * @param RegisteredResource
 */
case class Instructions
(
    override val sup: BasicElement,
    val bindingDOT: Double,
    val bindingInstruction: String,
    val instructionCost: Double,
    val instructionSource: String,
    val instructionStartTime: String,
    val instructionType: String,
    val manuallyBlocked: String,
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
    val bindingDOT = parse_element (element ("""Instructions.bindingDOT"""))
    val bindingInstruction = parse_attribute (attribute ("""Instructions.bindingInstruction"""))
    val instructionCost = parse_element (element ("""Instructions.instructionCost"""))
    val instructionSource = parse_attribute (attribute ("""Instructions.instructionSource"""))
    val instructionStartTime = parse_element (element ("""Instructions.instructionStartTime"""))
    val instructionType = parse_attribute (attribute ("""Instructions.instructionType"""))
    val manuallyBlocked = parse_attribute (attribute ("""Instructions.manuallyBlocked"""))
    val minStatusChangeTime = parse_element (element ("""Instructions.minStatusChangeTime"""))
    val updateTimeStamp = parse_element (element ("""Instructions.updateTimeStamp"""))
    val updateType = parse_attribute (attribute ("""Instructions.updateType"""))
    val updateUser = parse_element (element ("""Instructions.updateUser"""))
    val RegisteredResource = parse_attribute (attribute ("""Instructions.RegisteredResource"""))
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
 * @param sup Reference to the superclass object.
 * @param dataEntryTimeStamp Time the data entry was performed
 * @param tempLoadFollowingDownManualCap temporarily manually entered LFD capacity
 * @param tempLoadFollowingUpManualCap temporarily manually entered LFU capacity.
 * @param updateTimeStamp
 * @param updateType
 * @param updateUser
 * @param RegisteredResource
 */
case class LoadFollowingOperatorInput
(
    override val sup: BasicElement,
    val dataEntryTimeStamp: String,
    val tempLoadFollowingDownManualCap: Double,
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
    val dataEntryTimeStamp = parse_element (element ("""LoadFollowingOperatorInput.dataEntryTimeStamp"""))
    val tempLoadFollowingDownManualCap = parse_element (element ("""LoadFollowingOperatorInput.tempLoadFollowingDownManualCap"""))
    val tempLoadFollowingUpManualCap = parse_element (element ("""LoadFollowingOperatorInput.tempLoadFollowingUpManualCap"""))
    val updateTimeStamp = parse_element (element ("""LoadFollowingOperatorInput.updateTimeStamp"""))
    val updateType = parse_attribute (attribute ("""LoadFollowingOperatorInput.updateType"""))
    val updateUser = parse_element (element ("""LoadFollowingOperatorInput.updateUser"""))
    val RegisteredResource = parse_attribute (attribute ("""LoadFollowingOperatorInput.RegisteredResource"""))
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
 * @param sup Reference to the superclass object.
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
 * @param sup Reference to the superclass object.
 * @param lossMW
 * @param HostControlArea
 * @param LossClearing
 * @param RUCZone
 * @param SubControlArea
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
    val lossMW = parse_element (element ("""LossClearingResults.lossMW"""))
    val HostControlArea = parse_attribute (attribute ("""LossClearingResults.HostControlArea"""))
    val LossClearing = parse_attribute (attribute ("""LossClearingResults.LossClearing"""))
    val RUCZone = parse_attribute (attribute ("""LossClearingResults.RUCZone"""))
    val SubControlArea = parse_attribute (attribute ("""LossClearingResults.SubControlArea"""))
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
 * @param sup Reference to the superclass object.
 * @param mitigationOccuredFlag
 * @param LMPMFinalFlag
 * @param SMPMFinalFlag
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
    val mitigationOccuredFlag = parse_attribute (attribute ("""MPMClearing.mitigationOccuredFlag"""))
    val LMPMFinalFlag = parse_attribute (attribute ("""MPMClearing.LMPMFinalFlag"""))
    val SMPMFinalFlag = parse_attribute (attribute ("""MPMClearing.SMPMFinalFlag"""))
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
 * @param sup Reference to the superclass object.
 * @param resourceStatus Interval Test Status
 *        'N' - not applicable
 * @param MPMTestCategory
 * @param RegisteredResource
 */
case class MPMResourceStatus
(
    override val sup: BasicElement,
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
    val resourceStatus = parse_element (element ("""MPMResourceStatus.resourceStatus"""))
    val MPMTestCategory = parse_attribute (attribute ("""MPMResourceStatus.MPMTestCategory"""))
    val RegisteredResource = parse_attribute (attribute ("""MPMResourceStatus.RegisteredResource"""))
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
 * @param sup Reference to the superclass object.
 * @param marginPercent Used to show the Margin % result of the Impact test
 * @param outcome The results of the test.
 *        For the Price, Impact, and Conduct tests, typical values are NA, Pass, Fail, Disable, or Skip.
 * @param AggregatedPnode
 * @param MPMClearing
 * @param MPMTestCategory
 */
case class MPMTestResults
(
    override val sup: BasicElement,
    val marginPercent: Double,
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
    val marginPercent = parse_element (element ("""MPMTestResults.marginPercent"""))
    val outcome = parse_attribute (attribute ("""MPMTestResults.outcome"""))
    val AggregatedPnode = parse_attribute (attribute ("""MPMTestResults.AggregatedPnode"""))
    val MPMClearing = parse_attribute (attribute ("""MPMTestResults.MPMClearing"""))
    val MPMTestCategory = parse_attribute (attribute ("""MPMTestResults.MPMTestCategory"""))
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
 * @param sup Reference to the superclass object.
 * @param clearedMW Cleared generation Value in MW.
 *        For AS, this value is clearedMW = AS Total.  For AS, clearedMW - selfScheduleMW = AS Procured
 * @param clearedPrice Marginal Price ($/MW) for the commodity (Energy, Regulation Up, Regulation Down, Spinning Reserve, or Non-spinning reserve) based on the pricing run.
 * @param dispatchCtMW Dispatchable MW for Combustion units.
 * @param dispatchHydroMW Dispatchable MW for Hydro units.
 * @param dispatchRate Dispatch rate in MW/minutes.
 * @param dispatchSteamMW Dispatchable MW for Steam units.
 * @param imbalanceEnergyBias Imbalance Energy Bias (MW) by Time Period (5' only)
 * @param limitFlag Locational AS Flags indicating whether the Upper or Lower Bound limit of the AS regional procurment is binding
 * @param lumpyIndicator The "Lumpy Flag"(Y/N)  indicates whether the resource that sets the price is a lumpy generator by hour over the time horizon.
 *        Only applicable for the Day Ahead Market
 * @param maxSufficiencyIndex Region requirement maximum limit
 * @param minSufficiencyIndex Region requirement minimum limit
 * @param reqMaxMW Region requirement maximum limit
 * @param reqMinMW Region requirement minimum limit
 * @param selfScheduleMW Aof AS, selfScheduleMW = AS Self-Provided
 * @param AncillaryServiceClearing
 * @param MarketProduct
 * @param MarketRegion
 */
case class MarketRegionResults
(
    override val sup: BasicElement,
    val clearedMW: Double,
    val clearedPrice: Double,
    val dispatchCtMW: Double,
    val dispatchHydroMW: Double,
    val dispatchRate: Double,
    val dispatchSteamMW: Double,
    val imbalanceEnergyBias: Double,
    val limitFlag: String,
    val lumpyIndicator: String,
    val maxSufficiencyIndex: Double,
    val minSufficiencyIndex: Double,
    val reqMaxMW: Double,
    val reqMinMW: Double,
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
    val clearedMW = parse_element (element ("""MarketRegionResults.clearedMW"""))
    val clearedPrice = parse_element (element ("""MarketRegionResults.clearedPrice"""))
    val dispatchCtMW = parse_element (element ("""MarketRegionResults.dispatchCtMW"""))
    val dispatchHydroMW = parse_element (element ("""MarketRegionResults.dispatchHydroMW"""))
    val dispatchRate = parse_element (element ("""MarketRegionResults.dispatchRate"""))
    val dispatchSteamMW = parse_element (element ("""MarketRegionResults.dispatchSteamMW"""))
    val imbalanceEnergyBias = parse_element (element ("""MarketRegionResults.imbalanceEnergyBias"""))
    val limitFlag = parse_attribute (attribute ("""MarketRegionResults.limitFlag"""))
    val lumpyIndicator = parse_attribute (attribute ("""MarketRegionResults.lumpyIndicator"""))
    val maxSufficiencyIndex = parse_element (element ("""MarketRegionResults.maxSufficiencyIndex"""))
    val minSufficiencyIndex = parse_element (element ("""MarketRegionResults.minSufficiencyIndex"""))
    val reqMaxMW = parse_element (element ("""MarketRegionResults.reqMaxMW"""))
    val reqMinMW = parse_element (element ("""MarketRegionResults.reqMinMW"""))
    val selfScheduleMW = parse_element (element ("""MarketRegionResults.selfScheduleMW"""))
    val AncillaryServiceClearing = parse_attribute (attribute ("""MarketRegionResults.AncillaryServiceClearing"""))
    val MarketProduct = parse_attribute (attribute ("""MarketRegionResults.MarketProduct"""))
    val MarketRegion = parse_attribute (attribute ("""MarketRegionResults.MarketRegion"""))
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
 * @param sup Reference to the superclass object.
 * @param ancillarySvcCost Total  AS Cost (i.e., payment) ($) over the time horizon
 * @param contingentOperatingResAvail Global Contingent Operating Reserve Availability Indicator (Yes/No)
 * @param energyCost Total Energy Cost ($) over the time horizon
 * @param minimumLoadCost Total Minimum Load Cost ($) over the time horizon
 * @param startUpCost Total Start-up Cost ($) over the time horizon
 * @param totalCost Total Cost (Energy + AS) cost ($) by over the time horizon
 * @param totalRucCost The total RUC capacity cost for this interval
 * @param EnergyMarket
 */
case class MarketResults
(
    override val sup: BasicElement,
    val ancillarySvcCost: Double,
    val contingentOperatingResAvail: String,
    val energyCost: Double,
    val minimumLoadCost: Double,
    val startUpCost: Double,
    val totalCost: Double,
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
    val ancillarySvcCost = parse_element (element ("""MarketResults.ancillarySvcCost"""))
    val contingentOperatingResAvail = parse_attribute (attribute ("""MarketResults.contingentOperatingResAvail"""))
    val energyCost = parse_element (element ("""MarketResults.energyCost"""))
    val minimumLoadCost = parse_element (element ("""MarketResults.minimumLoadCost"""))
    val startUpCost = parse_element (element ("""MarketResults.startUpCost"""))
    val totalCost = parse_element (element ("""MarketResults.totalCost"""))
    val totalRucCost = parse_element (element ("""MarketResults.totalRucCost"""))
    val EnergyMarket = parse_attribute (attribute ("""MarketResults.EnergyMarket"""))
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
 * @param sup Reference to the superclass object.
 * @param end The end of a bill period.
 * @param referenceNumber The version number of previous statement (in the case of true up).
 * @param start The start of a bill period.
 * @param tradeDate The date of which Settlement is run.
 * @param transactionDate The date of which this statement is issued.
 */
case class MarketStatement
(
    override val sup: Document,
    val end: String,
    val referenceNumber: String,
    val start: String,
    val tradeDate: String,
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
    val end = parse_element (element ("""MarketStatement.end"""))
    val referenceNumber = parse_element (element ("""MarketStatement.referenceNumber"""))
    val start = parse_element (element ("""MarketStatement.start"""))
    val tradeDate = parse_element (element ("""MarketStatement.tradeDate"""))
    val transactionDate = parse_element (element ("""MarketStatement.transactionDate"""))
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
 * @param sup Reference to the superclass object.
 * @param currentAmount Current settlement amount.
 * @param currentISOAmount Current ISO settlement amount.
 * @param currentISOQuantity Current ISO settlement quantity.
 * @param currentPrice Current settlement price.
 * @param currentQuantity Current settlement quantity, subject to the UOM.
 * @param intervalDate The date of which the settlement is run.
 * @param intervalNumber The number of intervals.
 * @param netAmount Net settlement amount.
 * @param netISOAmount Net ISO settlement amount.
 * @param netISOQuantity Net ISO settlement quantity.
 * @param netPrice Net settlement price.
 * @param netQuantity Net settlement quantity, subject to the UOM.
 * @param previousAmount Previous settlement amount.
 * @param previousISOAmount Previous ISO settlement amount.
 * @param previousISOQuantity Previous ISO settlement quantity.
 * @param previousQuantity Previous settlement quantity, subject to the UOM.
 * @param previsouPrice Previous settlement price.
 * @param quantityUOM The unit of measure for the quantity element of the line item.
 * @param ContainerMarketStatementLineItem
 * @param MarketStatement
 * @param MktUserAttribute
 * @param PassThroughBill
 */
case class MarketStatementLineItem
(
    override val sup: IdentifiedObject,
    val currentAmount: Double,
    val currentISOAmount: Double,
    val currentISOQuantity: Double,
    val currentPrice: Double,
    val currentQuantity: Double,
    val intervalDate: String,
    val intervalNumber: String,
    val netAmount: Double,
    val netISOAmount: Double,
    val netISOQuantity: Double,
    val netPrice: Double,
    val netQuantity: Double,
    val previousAmount: Double,
    val previousISOAmount: Double,
    val previousISOQuantity: Double,
    val previousQuantity: Double,
    val previsouPrice: Double,
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
    val currentAmount = parse_element (element ("""MarketStatementLineItem.currentAmount"""))
    val currentISOAmount = parse_element (element ("""MarketStatementLineItem.currentISOAmount"""))
    val currentISOQuantity = parse_element (element ("""MarketStatementLineItem.currentISOQuantity"""))
    val currentPrice = parse_element (element ("""MarketStatementLineItem.currentPrice"""))
    val currentQuantity = parse_element (element ("""MarketStatementLineItem.currentQuantity"""))
    val intervalDate = parse_element (element ("""MarketStatementLineItem.intervalDate"""))
    val intervalNumber = parse_element (element ("""MarketStatementLineItem.intervalNumber"""))
    val netAmount = parse_element (element ("""MarketStatementLineItem.netAmount"""))
    val netISOAmount = parse_element (element ("""MarketStatementLineItem.netISOAmount"""))
    val netISOQuantity = parse_element (element ("""MarketStatementLineItem.netISOQuantity"""))
    val netPrice = parse_element (element ("""MarketStatementLineItem.netPrice"""))
    val netQuantity = parse_element (element ("""MarketStatementLineItem.netQuantity"""))
    val previousAmount = parse_element (element ("""MarketStatementLineItem.previousAmount"""))
    val previousISOAmount = parse_element (element ("""MarketStatementLineItem.previousISOAmount"""))
    val previousISOQuantity = parse_element (element ("""MarketStatementLineItem.previousISOQuantity"""))
    val previousQuantity = parse_element (element ("""MarketStatementLineItem.previousQuantity"""))
    val previsouPrice = parse_element (element ("""MarketStatementLineItem.previsouPrice"""))
    val quantityUOM = parse_element (element ("""MarketStatementLineItem.quantityUOM"""))
    val ContainerMarketStatementLineItem = parse_attribute (attribute ("""MarketStatementLineItem.ContainerMarketStatementLineItem"""))
    val MarketStatement = parse_attribute (attribute ("""MarketStatementLineItem.MarketStatement"""))
    val MktUserAttribute = parse_attributes (attribute ("""MarketStatementLineItem.MktUserAttribute"""))
    val PassThroughBill = parse_attribute (attribute ("""MarketStatementLineItem.PassThroughBill"""))
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
 * @param sup Reference to the superclass object.
 * @param Bid
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
    val Bid = parse_attribute (attribute ("""MitigatedBid.Bid"""))
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
 * @param sup Reference to the superclass object.
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
 * @param sup Reference to the superclass object.
 * @param intervalStartTime
 * @param segmentMW Mitigated bid segment MW value
 * @param segmentNumber Mitigated Bid Segment Number
 * @param thresholdType
 * @param Bid
 */
case class MitigatedBidSegment
(
    override val sup: BasicElement,
    val intervalStartTime: String,
    val segmentMW: Double,
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
    val intervalStartTime = parse_element (element ("""MitigatedBidSegment.intervalStartTime"""))
    val segmentMW = parse_element (element ("""MitigatedBidSegment.segmentMW"""))
    val segmentNumber = parse_element (element ("""MitigatedBidSegment.segmentNumber"""))
    val thresholdType = parse_element (element ("""MitigatedBidSegment.thresholdType"""))
    val Bid = parse_attribute (attribute ("""MitigatedBidSegment.Bid"""))
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
 * @param sup Reference to the superclass object.
 * @param adjustedAmount
 * @param amount The charge amount of the product/service.
 * @param billEnd Bill period end date
 * @param billRunType The settlement run type, for example: prelim, final, and rerun.
 * @param billStart Bill period start date
 * @param billedTo The company to which the PTB transaction is billed.
 * @param effectiveDate The effective date of the transaction
 * @param isDisputed Disputed transaction indicator
 * @param isProfiled A flag indicating whether there is a profile data associated with the PTB.
 * @param paidTo The company to which the PTB transaction is paid.
 * @param previousEnd The previous bill period end date
 * @param previousStart The previous bill period start date
 * @param price The price of product/service.
 * @param productCode The product identifier for determining the charge type of the transaction.
 * @param providedBy The company by which the PTB transaction service is provided.
 * @param quantity The product quantity.
 * @param serviceEnd The end date of service provided, if periodic.
 * @param serviceStart The start date of service provided, if periodic.
 * @param soldTo The company to which the PTB transaction is sold.
 * @param taxAmount The tax on services taken.
 * @param timeZone The time zone code
 * @param tradeDate The trade date
 * @param transactionDate The date the transaction occurs.
 * @param transactionType The type of transaction.
 *        For example, charge customer, bill customer, matching AR/AP, or bill determinant
 * @param MarketStatementLineItem
 * @param MktUserAttribute
 */
case class PassThroughBill
(
    override val sup: Document,
    val adjustedAmount: Double,
    val amount: Double,
    val billEnd: String,
    val billRunType: String,
    val billStart: String,
    val billedTo: String,
    val effectiveDate: String,
    val isDisputed: Boolean,
    val isProfiled: Boolean,
    val paidTo: String,
    val previousEnd: String,
    val previousStart: String,
    val price: Double,
    val productCode: String,
    val providedBy: String,
    val quantity: String,
    val serviceEnd: String,
    val serviceStart: String,
    val soldTo: String,
    val taxAmount: Double,
    val timeZone: String,
    val tradeDate: String,
    val transactionDate: String,
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
    val adjustedAmount = parse_element (element ("""PassThroughBill.adjustedAmount"""))
    val amount = parse_element (element ("""PassThroughBill.amount"""))
    val billEnd = parse_element (element ("""PassThroughBill.billEnd"""))
    val billRunType = parse_element (element ("""PassThroughBill.billRunType"""))
    val billStart = parse_element (element ("""PassThroughBill.billStart"""))
    val billedTo = parse_element (element ("""PassThroughBill.billedTo"""))
    val effectiveDate = parse_element (element ("""PassThroughBill.effectiveDate"""))
    val isDisputed = parse_element (element ("""PassThroughBill.isDisputed"""))
    val isProfiled = parse_element (element ("""PassThroughBill.isProfiled"""))
    val paidTo = parse_element (element ("""PassThroughBill.paidTo"""))
    val previousEnd = parse_element (element ("""PassThroughBill.previousEnd"""))
    val previousStart = parse_element (element ("""PassThroughBill.previousStart"""))
    val price = parse_element (element ("""PassThroughBill.price"""))
    val productCode = parse_element (element ("""PassThroughBill.productCode"""))
    val providedBy = parse_element (element ("""PassThroughBill.providedBy"""))
    val quantity = parse_attribute (attribute ("""PassThroughBill.quantity"""))
    val serviceEnd = parse_element (element ("""PassThroughBill.serviceEnd"""))
    val serviceStart = parse_element (element ("""PassThroughBill.serviceStart"""))
    val soldTo = parse_element (element ("""PassThroughBill.soldTo"""))
    val taxAmount = parse_element (element ("""PassThroughBill.taxAmount"""))
    val timeZone = parse_element (element ("""PassThroughBill.timeZone"""))
    val tradeDate = parse_element (element ("""PassThroughBill.tradeDate"""))
    val transactionDate = parse_element (element ("""PassThroughBill.transactionDate"""))
    val transactionType = parse_element (element ("""PassThroughBill.transactionType"""))
    val MarketStatementLineItem = parse_attribute (attribute ("""PassThroughBill.MarketStatementLineItem"""))
    val MktUserAttribute = parse_attributes (attribute ("""PassThroughBill.MktUserAttribute"""))
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
 * @param sup Reference to the superclass object.
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
 * @param sup Reference to the superclass object.
 * @param congestLMP Congestion component of Location Marginal Price (LMP) in monetary units per MW.
 * @param costLMP Cost component of Locational Marginal Pricing (LMP) in monetary units per MW.
 * @param lossLMP Loss component of Location Marginal Price (LMP) in monetary units per MW.
 * @param marginalClearingPrice Locational Marginal Price (LMP) ($/MWh)
 * @param scheduledMW total MW schedule at the pnode
 * @param updateTimeStamp
 * @param updateType
 * @param updateUser
 * @param Pnode
 * @param PnodeClearing
 */
case class PnodeResults
(
    override val sup: BasicElement,
    val congestLMP: Double,
    val costLMP: Double,
    val lossLMP: Double,
    val marginalClearingPrice: Double,
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
    val congestLMP = parse_element (element ("""PnodeResults.congestLMP"""))
    val costLMP = parse_element (element ("""PnodeResults.costLMP"""))
    val lossLMP = parse_element (element ("""PnodeResults.lossLMP"""))
    val marginalClearingPrice = parse_element (element ("""PnodeResults.marginalClearingPrice"""))
    val scheduledMW = parse_element (element ("""PnodeResults.scheduledMW"""))
    val updateTimeStamp = parse_element (element ("""PnodeResults.updateTimeStamp"""))
    val updateType = parse_attribute (attribute ("""PnodeResults.updateType"""))
    val updateUser = parse_element (element ("""PnodeResults.updateUser"""))
    val Pnode = parse_attribute (attribute ("""PnodeResults.Pnode"""))
    val PnodeClearing = parse_attribute (attribute ("""PnodeResults.PnodeClearing"""))
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
 * @param sup Reference to the superclass object.
 * @param Bid
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
    val Bid = parse_attribute (attribute ("""RMRDetermination.Bid"""))
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
 * @param sup Reference to the superclass object.
 * @param manuallySchedRMRMw The lower of the original pre-dispatch or the AC run schedule (Also known as the RMR Reguirement) becomes the pre-dispatch value.
 * @param updateTimeStamp
 * @param updateType
 * @param updateUser
 * @param RegisteredResource
 */
case class RMROperatorInput
(
    override val sup: MarketFactors,
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
    val manuallySchedRMRMw = parse_element (element ("""RMROperatorInput.manuallySchedRMRMw"""))
    val updateTimeStamp = parse_element (element ("""RMROperatorInput.updateTimeStamp"""))
    val updateType = parse_attribute (attribute ("""RMROperatorInput.updateType"""))
    val updateUser = parse_element (element ("""RMROperatorInput.updateUser"""))
    val RegisteredResource = parse_attribute (attribute ("""RMROperatorInput.RegisteredResource"""))
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
 * @param sup Reference to the superclass object.
 * @param clearedPrice Marginal Price ($/MW) for the commodity (Regulation Up, Regulation Down, Spinning Reserve, or Non-spinning reserve) for pricing run.
 * @param marketProductType major product type may include the following but not limited to:

Energy
Regulation Up
Regulation Dn
Spinning Reserve
Non-Spinning Reserve
 *        Operating Reserve
 * @param updateTimeStamp
 * @param updateType
 * @param updateUser
 * @param RUCAward The RUC Award of a resource is the portion of the RUC Capacity that is not under RA or RMR contracts.
 *        The RUC Award of a resource is the portion of the RUC Capacity that is eligible for RUC Availability payment.
 * @param RUCCapacity The RUC Capacity of a resource is the difference between (i) the RUC Schedule and (ii) the higher of the DA Schedule and the Minimum Load.
 * @param RUCSchedule The RUC Schedule of a resource is its output level that balances the load forecast used in RUC.
 *        The RUC Schedule in RUC is similar to the DA Schedule in DAM.
 * @param RegisteredResource
 */
case class RUCAwardInstruction
(
    override val sup: BasicElement,
    val clearedPrice: Double,
    val marketProductType: String,
    val updateTimeStamp: String,
    val updateType: String,
    val updateUser: String,
    val RUCAward: Double,
    val RUCCapacity: Double,
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
    val clearedPrice = parse_element (element ("""RUCAwardInstruction.clearedPrice"""))
    val marketProductType = parse_attribute (attribute ("""RUCAwardInstruction.marketProductType"""))
    val updateTimeStamp = parse_element (element ("""RUCAwardInstruction.updateTimeStamp"""))
    val updateType = parse_attribute (attribute ("""RUCAwardInstruction.updateType"""))
    val updateUser = parse_element (element ("""RUCAwardInstruction.updateUser"""))
    val RUCAward = parse_element (element ("""RUCAwardInstruction.RUCAward"""))
    val RUCCapacity = parse_element (element ("""RUCAwardInstruction.RUCCapacity"""))
    val RUCSchedule = parse_element (element ("""RUCAwardInstruction.RUCSchedule"""))
    val RegisteredResource = parse_attribute (attribute ("""RUCAwardInstruction.RegisteredResource"""))
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
 * @param sup Reference to the superclass object.
 * @param contingencyActive Indication that the system is currently operating in a contingency mode.
 * @param dispatchMode
 */
case class ResourceAwardClearing
(
    override val sup: MarketFactors,
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
    val contingencyActive = parse_attribute (attribute ("""ResourceAwardClearing.contingencyActive"""))
    val dispatchMode = parse_attribute (attribute ("""ResourceAwardClearing.dispatchMode"""))
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
 * @param sup Reference to the superclass object.
 * @param awardMW For DA Energy: Not Applicable;   

For DA AS: DA AS market award;   

For RT Energy: Not Applicable;
 *        For RT AS: RT AS market award (excluding DA AS market or self-proviison awards)
 * @param clearedMW For DA Energy: Total Schedule = DA market schedule + DA self-schedule award;   

For DA AS: DA Ancillary Service Awards = DA AS market award + DA AS self-provision award;   

For RT Energy: Total Schedule = RT market schedule + RT self-schedule award;
 *        For RT AS: RT Ancillary Service Awards = RT AS self-provision award + RT AS market award + DA AS market award + DA AS self-provision award;
 * @param clearedPrice Marginal Price ($/MW) for the commodity (Regulation Up, Regulation Down, Spinning Reserve, or Non-spinning reserve) for pricing run.
 * @param congestLMP Congestion component of Location Marginal Price (LMP) in monetary units per MW.
 * @param costLMP Cost component of Locational Marginal Pricing (LMP) in monetary units per MW.
 * @param dispatcherAddedMW The tier2 mw added by dispatcher action
 *        Market results of the synchronized reserve market
 * @param economicMax Unit max output for dispatch; bid in economic maximum
 * @param economicMin Unit min output for dispatch; bid in economic minimum
 * @param effRegulationDownLimit Effective Regulation Down Limit (MW)
 * @param effRegulationUpLimit Effective Regulation Up Limit
 * @param lmp Locational marginal price value
 * @param lossLMP Loss component of Location Marginal Price (LMP) in monetary units per MW.
 * @param manuallyBlocked Indicates if an award was manually blocked (Y/N).
 *        Valid for Spinning and Non-spinning.
 * @param marginalResourceIndicator Indicator (Yes / No) that this resource set the price for this dispatch / schedule.
 * @param mustRunInd Identifes if the unit was set to must run by the market participant responsible for bidding in the unit
 * @param noLoadCost Unit no-load cost in case of energy commodity
 * @param optimalBidCost Optimal Bid cost
 * @param optimalBidPay Optimal Bid production payment based on LMP
 * @param optimalMargin Optimal Bid production margin
 * @param overrideTimeStamp Time the manual data entry occured.
 * @param overrideValue Provides the ability for the grid operator to override items, such as spin capacity requirements, prior to running the algorithm.
 *        This value is market product based (spin, non-spin, reg up, reg down, or RUC).
 * @param selfSchedMW For DA Energy: DA total self-schedule award;   
For DA AS: DA AS self-provision award;   
For RT Energy: RT total self-schedule award;
 *        For RT AS: RT AS self-provision award (excluding DA AS market or self-provision awards)
 * @param startUpCost Unit start up cost in case of energy commodity
 * @param status In or out status of resource
 * @param totalRevenue Total bid revenue (startup_cost + no_load_cost + bid_pay)
 * @param updateTimeStamp
 * @param updateType
 * @param updateUser
 * @param MarketProduct
 * @param RegisteredResource
 */
case class ResourceAwardInstruction
(
    override val sup: BasicElement,
    val awardMW: Double,
    val clearedMW: Double,
    val clearedPrice: Double,
    val congestLMP: Double,
    val costLMP: Double,
    val dispatcherAddedMW: Double,
    val economicMax: Double,
    val economicMin: Double,
    val effRegulationDownLimit: Double,
    val effRegulationUpLimit: Double,
    val lmp: Double,
    val lossLMP: Double,
    val manuallyBlocked: String,
    val marginalResourceIndicator: String,
    val mustRunInd: Boolean,
    val noLoadCost: Double,
    val optimalBidCost: Double,
    val optimalBidPay: Double,
    val optimalMargin: Double,
    val overrideTimeStamp: String,
    val overrideValue: Double,
    val selfSchedMW: Double,
    val startUpCost: Double,
    val status: String,
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
    val awardMW = parse_element (element ("""ResourceAwardInstruction.awardMW"""))
    val clearedMW = parse_element (element ("""ResourceAwardInstruction.clearedMW"""))
    val clearedPrice = parse_element (element ("""ResourceAwardInstruction.clearedPrice"""))
    val congestLMP = parse_element (element ("""ResourceAwardInstruction.congestLMP"""))
    val costLMP = parse_element (element ("""ResourceAwardInstruction.costLMP"""))
    val dispatcherAddedMW = parse_element (element ("""ResourceAwardInstruction.dispatcherAddedMW"""))
    val economicMax = parse_element (element ("""ResourceAwardInstruction.economicMax"""))
    val economicMin = parse_element (element ("""ResourceAwardInstruction.economicMin"""))
    val effRegulationDownLimit = parse_element (element ("""ResourceAwardInstruction.effRegulationDownLimit"""))
    val effRegulationUpLimit = parse_element (element ("""ResourceAwardInstruction.effRegulationUpLimit"""))
    val lmp = parse_element (element ("""ResourceAwardInstruction.lmp"""))
    val lossLMP = parse_element (element ("""ResourceAwardInstruction.lossLMP"""))
    val manuallyBlocked = parse_attribute (attribute ("""ResourceAwardInstruction.manuallyBlocked"""))
    val marginalResourceIndicator = parse_attribute (attribute ("""ResourceAwardInstruction.marginalResourceIndicator"""))
    val mustRunInd = parse_element (element ("""ResourceAwardInstruction.mustRunInd"""))
    val noLoadCost = parse_element (element ("""ResourceAwardInstruction.noLoadCost"""))
    val optimalBidCost = parse_element (element ("""ResourceAwardInstruction.optimalBidCost"""))
    val optimalBidPay = parse_element (element ("""ResourceAwardInstruction.optimalBidPay"""))
    val optimalMargin = parse_element (element ("""ResourceAwardInstruction.optimalMargin"""))
    val overrideTimeStamp = parse_element (element ("""ResourceAwardInstruction.overrideTimeStamp"""))
    val overrideValue = parse_element (element ("""ResourceAwardInstruction.overrideValue"""))
    val selfSchedMW = parse_element (element ("""ResourceAwardInstruction.selfSchedMW"""))
    val startUpCost = parse_element (element ("""ResourceAwardInstruction.startUpCost"""))
    val status = parse_element (element ("""ResourceAwardInstruction.status"""))
    val totalRevenue = parse_element (element ("""ResourceAwardInstruction.totalRevenue"""))
    val updateTimeStamp = parse_element (element ("""ResourceAwardInstruction.updateTimeStamp"""))
    val updateType = parse_attribute (attribute ("""ResourceAwardInstruction.updateType"""))
    val updateUser = parse_element (element ("""ResourceAwardInstruction.updateUser"""))
    val MarketProduct = parse_attribute (attribute ("""ResourceAwardInstruction.MarketProduct"""))
    val RegisteredResource = parse_attribute (attribute ("""ResourceAwardInstruction.RegisteredResource"""))
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
 * @param sup Reference to the superclass object.
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
 * @param sup Reference to the superclass object.
 * @param blockedDispatch Blocked Dispatch Indicator (Yes/No)
 * @param blockedPublishDOP Block sending DOP to ADS (Y/N)
 * @param contingencyFlag Contingent Operating Reserve Indicator (Yes/No).
 *        Resource participating with AS capacity in contingency dispatch.
 * @param limitIndicator indicate which limit is the constraints
 * @param lowerLimit resource energy ramping lower limit
 * @param maxRampRate maximum ramp rate
 * @param operatingLimitHigh The upper operating limit incorporating any derate used by the RTD for the Binding Interval.
 * @param operatingLimitLow The lower operating limit incorporating any derate used by the RTD for the Binding Interval.
 * @param penaltyDispatchIndicator Penalty Dispatch Indicator (Yes / No) indicating an un-economic adjustment.
 * @param regulatingLimitHigh The upper regulating limit incorporating any derate used by the RTD for the Binding Interval.
 * @param regulatingLimitLow The lower regulating limit incorporating any derate used by the RTD for the Binding Interval.
 * @param resourceStatus Unit Commitment Status (On/Off/Starting)
 * @param totalSchedule Resource total upward schedule.  total schedule = En + all AS per resource per interval
 * @param updateTimeStamp
 * @param updateType
 * @param updateUser
 * @param upperLimit resource energy ramping upper limit
 * @param RegisteredResource
 * @param ResourceClearing
 */
case class ResourceDispatchResults
(
    override val sup: BasicElement,
    val blockedDispatch: String,
    val blockedPublishDOP: String,
    val contingencyFlag: String,
    val limitIndicator: String,
    val lowerLimit: Double,
    val maxRampRate: Double,
    val operatingLimitHigh: Double,
    val operatingLimitLow: Double,
    val penaltyDispatchIndicator: String,
    val regulatingLimitHigh: Double,
    val regulatingLimitLow: Double,
    val resourceStatus: String,
    val totalSchedule: Double,
    val updateTimeStamp: String,
    val updateType: String,
    val updateUser: String,
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
    val blockedDispatch = parse_element (element ("""ResourceDispatchResults.blockedDispatch"""))
    val blockedPublishDOP = parse_element (element ("""ResourceDispatchResults.blockedPublishDOP"""))
    val contingencyFlag = parse_attribute (attribute ("""ResourceDispatchResults.contingencyFlag"""))
    val limitIndicator = parse_element (element ("""ResourceDispatchResults.limitIndicator"""))
    val lowerLimit = parse_element (element ("""ResourceDispatchResults.lowerLimit"""))
    val maxRampRate = parse_element (element ("""ResourceDispatchResults.maxRampRate"""))
    val operatingLimitHigh = parse_element (element ("""ResourceDispatchResults.operatingLimitHigh"""))
    val operatingLimitLow = parse_element (element ("""ResourceDispatchResults.operatingLimitLow"""))
    val penaltyDispatchIndicator = parse_attribute (attribute ("""ResourceDispatchResults.penaltyDispatchIndicator"""))
    val regulatingLimitHigh = parse_element (element ("""ResourceDispatchResults.regulatingLimitHigh"""))
    val regulatingLimitLow = parse_element (element ("""ResourceDispatchResults.regulatingLimitLow"""))
    val resourceStatus = parse_element (element ("""ResourceDispatchResults.resourceStatus"""))
    val totalSchedule = parse_element (element ("""ResourceDispatchResults.totalSchedule"""))
    val updateTimeStamp = parse_element (element ("""ResourceDispatchResults.updateTimeStamp"""))
    val updateType = parse_attribute (attribute ("""ResourceDispatchResults.updateType"""))
    val updateUser = parse_element (element ("""ResourceDispatchResults.updateUser"""))
    val upperLimit = parse_element (element ("""ResourceDispatchResults.upperLimit"""))
    val RegisteredResource = parse_attribute (attribute ("""ResourceDispatchResults.RegisteredResource"""))
    val ResourceClearing = parse_attribute (attribute ("""ResourceDispatchResults.ResourceClearing"""))
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
 * @param sup Reference to the superclass object.
 * @param calcLoadFollowingMW weighted average for RTPD and RTCD and same for RTID
 * @param dispWindowHighLimt
 * @param dispWindowLowLimt
 * @param instructionID Unique instruction id per instruction, assigned by the SC and provided to ADS.
 *        ADS passes through.
 * @param intervalStartTime The start of the time interval for which requirement is defined.
 * @param RegisteredResource
 * @param ResourceClearing
 */
case class ResourceLoadFollowingInst
(
    override val sup: BasicElement,
    val calcLoadFollowingMW: Double,
    val dispWindowHighLimt: Double,
    val dispWindowLowLimt: Double,
    val instructionID: String,
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
    val calcLoadFollowingMW = parse_element (element ("""ResourceLoadFollowingInst.calcLoadFollowingMW"""))
    val dispWindowHighLimt = parse_element (element ("""ResourceLoadFollowingInst.dispWindowHighLimt"""))
    val dispWindowLowLimt = parse_element (element ("""ResourceLoadFollowingInst.dispWindowLowLimt"""))
    val instructionID = parse_element (element ("""ResourceLoadFollowingInst.instructionID"""))
    val intervalStartTime = parse_element (element ("""ResourceLoadFollowingInst.intervalStartTime"""))
    val RegisteredResource = parse_attribute (attribute ("""ResourceLoadFollowingInst.RegisteredResource"""))
    val ResourceClearing = parse_attribute (attribute ("""ResourceLoadFollowingInst.ResourceClearing"""))
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
 * @param sup Reference to the superclass object.
 * @param selfSchedMW Cleared value for the specific self schedule type listed.
 * @param selfSchedType Self schedule breakdown type.
 * @param ResourceAwardInstruction
 */
case class SelfScheduleBreakdown
(
    override val sup: BasicElement,
    val selfSchedMW: Double,
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
    val selfSchedMW = parse_element (element ("""SelfScheduleBreakdown.selfSchedMW"""))
    val selfSchedType = parse_attribute (attribute ("""SelfScheduleBreakdown.selfSchedType"""))
    val ResourceAwardInstruction = parse_attribute (attribute ("""SelfScheduleBreakdown.ResourceAwardInstruction"""))
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
 * @param sup Reference to the superclass object.
 * @param tradeDate The trade date on which the settlement is run.
 * @param EnergyMarket
 */
case class Settlement
(
    override val sup: Document,
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
    val tradeDate = parse_element (element ("""Settlement.tradeDate"""))
    val EnergyMarket = parse_attribute (attribute ("""Settlement.EnergyMarket"""))
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
 * @param sup Reference to the superclass object.
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
 * @param sup Reference to the superclass object.
 * @param clearedMW The market transaction megawatt
 * @param clearedPrice The price of the market transaction
 * @param TransactionBid
 * @param TransactionBidClearing
 */
case class TransactionBidResults
(
    override val sup: IdentifiedObject,
    val clearedMW: Double,
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
    val clearedMW = parse_element (element ("""TransactionBidResults.clearedMW"""))
    val clearedPrice = parse_element (element ("""TransactionBidResults.clearedPrice"""))
    val TransactionBid = parse_attribute (attribute ("""TransactionBidResults.TransactionBid"""))
    val TransactionBidClearing = parse_attribute (attribute ("""TransactionBidResults.TransactionBidClearing"""))
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