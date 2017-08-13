package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * Results from the execution of a market.
 */

/**
 * Model of results of market clearing with respect to  Ancillary Service products
 * @param sup Reference to the superclass object.
 * @param MarketCaseClearing <em>undocumented</em>
 */
case class AncillaryServiceClearing
(
    override val sup: MarketFactors,
    MarketCaseClearing: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { clone ().asInstanceOf[AncillaryServiceClearing] }
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
        (if (null != MarketCaseClearing) "\t\t<cim:AncillaryServiceClearing.MarketCaseClearing rdf:resource=\"#" + MarketCaseClearing + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AncillaryServiceClearing rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AncillaryServiceClearing>"
    }
}

object AncillaryServiceClearing
extends
    Parseable[AncillaryServiceClearing]
{
    val MarketCaseClearing = parse_attribute (attribute ("""AncillaryServiceClearing.MarketCaseClearing"""))
    def parse (context: Context): AncillaryServiceClearing =
    {
        AncillaryServiceClearing(
            MarketFactors.parse (context),
            MarketCaseClearing (context)
        )
    }
}

/**
 * Model various charges to support billing and settlement of
 * @param sup Reference to the superclass object.
 * @param calculationLevel Level in charge calculation order.
 * @param configVersion The version of configuration of calculation logic in the settlement.
 * @param deleteStatus <em>undocumented</em>
 * @param effectiveDate <em>undocumented</em>
 * @param exception <em>undocumented</em>
 * @param factor <em>undocumented</em>
 * @param frequency <em>undocumented</em>
 * @param numberInterval Number of intervals of bill determiant in trade day, eg 300 for five minute intervals.
 * @param offset <em>undocumented</em>
 * @param precisionLevel The level of precision in the current value.
 * @param primaryYN <em>undocumented</em>
 * @param referenceFlag <em>undocumented</em>
 * @param reportable <em>undocumented</em>
 * @param roundOff <em>undocumented</em>
 * @param source <em>undocumented</em>
 * @param terminationDate <em>undocumented</em>
 * @param unitOfMeasure The UOM for the current value of the Bill Determinant.
 * @param ChargeProfile <em>undocumented</em>
 * @param MktUserAttribute <em>undocumented</em>
 */
case class BillDeterminant
(
    override val sup: Document,
    calculationLevel: String,
    configVersion: String,
    deleteStatus: String,
    effectiveDate: String,
    exception: String,
    factor: String,
    frequency: String,
    numberInterval: Int,
    offset: String,
    precisionLevel: String,
    primaryYN: String,
    referenceFlag: String,
    reportable: String,
    roundOff: String,
    source: String,
    terminationDate: String,
    unitOfMeasure: String,
    ChargeProfile: String,
    MktUserAttribute: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, List()) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[BillDeterminant] }
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
        (if (null != calculationLevel) "\t\t<cim:BillDeterminant.calculationLevel>" + calculationLevel + "</cim:BillDeterminant.calculationLevel>\n" else "") +
        (if (null != configVersion) "\t\t<cim:BillDeterminant.configVersion>" + configVersion + "</cim:BillDeterminant.configVersion>\n" else "") +
        (if (null != deleteStatus) "\t\t<cim:BillDeterminant.deleteStatus>" + deleteStatus + "</cim:BillDeterminant.deleteStatus>\n" else "") +
        (if (null != effectiveDate) "\t\t<cim:BillDeterminant.effectiveDate>" + effectiveDate + "</cim:BillDeterminant.effectiveDate>\n" else "") +
        (if (null != exception) "\t\t<cim:BillDeterminant.exception>" + exception + "</cim:BillDeterminant.exception>\n" else "") +
        (if (null != factor) "\t\t<cim:BillDeterminant.factor>" + factor + "</cim:BillDeterminant.factor>\n" else "") +
        (if (null != frequency) "\t\t<cim:BillDeterminant.frequency>" + frequency + "</cim:BillDeterminant.frequency>\n" else "") +
        "\t\t<cim:BillDeterminant.numberInterval>" + numberInterval + "</cim:BillDeterminant.numberInterval>\n" +
        (if (null != offset) "\t\t<cim:BillDeterminant.offset>" + offset + "</cim:BillDeterminant.offset>\n" else "") +
        (if (null != precisionLevel) "\t\t<cim:BillDeterminant.precisionLevel>" + precisionLevel + "</cim:BillDeterminant.precisionLevel>\n" else "") +
        (if (null != primaryYN) "\t\t<cim:BillDeterminant.primaryYN>" + primaryYN + "</cim:BillDeterminant.primaryYN>\n" else "") +
        (if (null != referenceFlag) "\t\t<cim:BillDeterminant.referenceFlag>" + referenceFlag + "</cim:BillDeterminant.referenceFlag>\n" else "") +
        (if (null != reportable) "\t\t<cim:BillDeterminant.reportable>" + reportable + "</cim:BillDeterminant.reportable>\n" else "") +
        (if (null != roundOff) "\t\t<cim:BillDeterminant.roundOff>" + roundOff + "</cim:BillDeterminant.roundOff>\n" else "") +
        (if (null != source) "\t\t<cim:BillDeterminant.source>" + source + "</cim:BillDeterminant.source>\n" else "") +
        (if (null != terminationDate) "\t\t<cim:BillDeterminant.terminationDate>" + terminationDate + "</cim:BillDeterminant.terminationDate>\n" else "") +
        (if (null != unitOfMeasure) "\t\t<cim:BillDeterminant.unitOfMeasure>" + unitOfMeasure + "</cim:BillDeterminant.unitOfMeasure>\n" else "") +
        (if (null != ChargeProfile) "\t\t<cim:BillDeterminant.ChargeProfile rdf:resource=\"#" + ChargeProfile + "\"/>\n" else "") +
        (if (null != MktUserAttribute) MktUserAttribute.map (x => "\t\t<cim:BillDeterminant.MktUserAttribute rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:BillDeterminant rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:BillDeterminant>"
    }
}

object BillDeterminant
extends
    Parseable[BillDeterminant]
{
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
            Document.parse (context),
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
 * @param Bid <em>undocumented</em>
 * @param BillDeterminant <em>undocumented</em>
 * @param PassTroughBill <em>undocumented</em>
 */
case class ChargeProfile
(
    override val sup: Profile,
    frequency: String,
    numberInterval: Int,
    typ: String,
    unitOfMeasure: String,
    Bid: String,
    BillDeterminant: String,
    PassTroughBill: String
)
extends
    Element
{
    def this () = { this (null, null, 0, null, null, null, null, null) }
    def Profile: Profile = sup.asInstanceOf[Profile]
    override def copy (): Row = { clone ().asInstanceOf[ChargeProfile] }
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
        (if (null != frequency) "\t\t<cim:ChargeProfile.frequency>" + frequency + "</cim:ChargeProfile.frequency>\n" else "") +
        "\t\t<cim:ChargeProfile.numberInterval>" + numberInterval + "</cim:ChargeProfile.numberInterval>\n" +
        (if (null != typ) "\t\t<cim:ChargeProfile.type>" + typ + "</cim:ChargeProfile.type>\n" else "") +
        (if (null != unitOfMeasure) "\t\t<cim:ChargeProfile.unitOfMeasure>" + unitOfMeasure + "</cim:ChargeProfile.unitOfMeasure>\n" else "") +
        (if (null != Bid) "\t\t<cim:ChargeProfile.Bid rdf:resource=\"#" + Bid + "\"/>\n" else "") +
        (if (null != BillDeterminant) "\t\t<cim:ChargeProfile.BillDeterminant rdf:resource=\"#" + BillDeterminant + "\"/>\n" else "") +
        (if (null != PassTroughBill) "\t\t<cim:ChargeProfile.PassTroughBill rdf:resource=\"#" + PassTroughBill + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ChargeProfile rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ChargeProfile>"
    }
}

object ChargeProfile
extends
    Parseable[ChargeProfile]
{
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
            Profile.parse (context),
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
 * @param BillDeterminant <em>undocumented</em>
 * @param ChargeProfile <em>undocumented</em>
 */
case class ChargeProfileData
(
    override val sup: BasicElement,
    sequence: Int,
    timeStamp: String,
    value: Double,
    BillDeterminant: String,
    ChargeProfile: String
)
extends
    Element
{
    def this () = { this (null, 0, null, 0.0, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ChargeProfileData] }
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
        "\t\t<cim:ChargeProfileData.sequence>" + sequence + "</cim:ChargeProfileData.sequence>\n" +
        (if (null != timeStamp) "\t\t<cim:ChargeProfileData.timeStamp>" + timeStamp + "</cim:ChargeProfileData.timeStamp>\n" else "") +
        "\t\t<cim:ChargeProfileData.value>" + value + "</cim:ChargeProfileData.value>\n" +
        (if (null != BillDeterminant) "\t\t<cim:ChargeProfileData.BillDeterminant rdf:resource=\"#" + BillDeterminant + "\"/>\n" else "") +
        (if (null != ChargeProfile) "\t\t<cim:ChargeProfileData.ChargeProfile rdf:resource=\"#" + ChargeProfile + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ChargeProfileData rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ChargeProfileData>"
    }
}

object ChargeProfileData
extends
    Parseable[ChargeProfileData]
{
    val sequence = parse_element (element ("""ChargeProfileData.sequence"""))
    val timeStamp = parse_element (element ("""ChargeProfileData.timeStamp"""))
    val value = parse_element (element ("""ChargeProfileData.value"""))
    val BillDeterminant = parse_attribute (attribute ("""ChargeProfileData.BillDeterminant"""))
    val ChargeProfile = parse_attribute (attribute ("""ChargeProfileData.ChargeProfile"""))
    def parse (context: Context): ChargeProfileData =
    {
        ChargeProfileData(
            BasicElement.parse (context),
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
    override def copy (): Row = { clone ().asInstanceOf[CommitmentClearing] }
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
        "\t<cim:CommitmentClearing rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CommitmentClearing>"
    }
}

object CommitmentClearing
extends
    Parseable[CommitmentClearing]
{
    def parse (context: Context): CommitmentClearing =
    {
        CommitmentClearing(
            MarketFactors.parse (context)
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
 * @param updateTimeStamp <em>undocumented</em>
 * @param updateType <em>undocumented</em>
 * @param updateUser <em>undocumented</em>
 * @param RegisteredResource <em>undocumented</em>
 */
case class Commitments
(
    override val sup: BasicElement,
    commitmentType: String,
    instructionCost: Double,
    instructionType: String,
    intervalEndTime: String,
    intervalStartTime: String,
    minStatusChangeTime: Int,
    noLoadCost: Double,
    updateTimeStamp: String,
    updateType: String,
    updateUser: String,
    RegisteredResource: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, null, null, null, 0, 0.0, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[Commitments] }
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
        (if (null != commitmentType) "\t\t<cim:Commitments.commitmentType rdf:resource=\"#" + commitmentType + "\"/>\n" else "") +
        "\t\t<cim:Commitments.instructionCost>" + instructionCost + "</cim:Commitments.instructionCost>\n" +
        (if (null != instructionType) "\t\t<cim:Commitments.instructionType rdf:resource=\"#" + instructionType + "\"/>\n" else "") +
        (if (null != intervalEndTime) "\t\t<cim:Commitments.intervalEndTime>" + intervalEndTime + "</cim:Commitments.intervalEndTime>\n" else "") +
        (if (null != intervalStartTime) "\t\t<cim:Commitments.intervalStartTime>" + intervalStartTime + "</cim:Commitments.intervalStartTime>\n" else "") +
        "\t\t<cim:Commitments.minStatusChangeTime>" + minStatusChangeTime + "</cim:Commitments.minStatusChangeTime>\n" +
        "\t\t<cim:Commitments.noLoadCost>" + noLoadCost + "</cim:Commitments.noLoadCost>\n" +
        (if (null != updateTimeStamp) "\t\t<cim:Commitments.updateTimeStamp>" + updateTimeStamp + "</cim:Commitments.updateTimeStamp>\n" else "") +
        (if (null != updateType) "\t\t<cim:Commitments.updateType rdf:resource=\"#" + updateType + "\"/>\n" else "") +
        (if (null != updateUser) "\t\t<cim:Commitments.updateUser>" + updateUser + "</cim:Commitments.updateUser>\n" else "") +
        (if (null != RegisteredResource) "\t\t<cim:Commitments.RegisteredResource rdf:resource=\"#" + RegisteredResource + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Commitments rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Commitments>"
    }
}

object Commitments
extends
    Parseable[Commitments]
{
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
            BasicElement.parse (context),
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
    override def copy (): Row = { clone ().asInstanceOf[ConstraintClearing] }
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
        "\t<cim:ConstraintClearing rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ConstraintClearing>"
    }
}

object ConstraintClearing
extends
    Parseable[ConstraintClearing]
{
    def parse (context: Context): ConstraintClearing =
    {
        ConstraintClearing(
            MarketFactors.parse (context)
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
 * @param ConstraintClearing <em>undocumented</em>
 * @param Flowgate <em>undocumented</em>
 * @param MktContingency <em>undocumented</em>
 */
case class ConstraintResults
(
    override val sup: IdentifiedObject,
    baseFlow: Double,
    bindingLimit: Double,
    clearedValue: Double,
    competitivePathConstraint: String,
    constraintType: String,
    limitFlag: String,
    optimizationFlag: String,
    overloadMW: Double,
    percentMW: Double,
    shadowPrice: Double,
    updateTimeStamp: String,
    updateType: String,
    updateUser: String,
    BGLimit: Double,
    BGTRResCap: Double,
    ConstraintClearing: String,
    Flowgate: String,
    MktContingency: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, null, null, null, null, 0.0, 0.0, 0.0, null, null, null, 0.0, 0.0, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ConstraintResults] }
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
        "\t\t<cim:ConstraintResults.baseFlow>" + baseFlow + "</cim:ConstraintResults.baseFlow>\n" +
        "\t\t<cim:ConstraintResults.bindingLimit>" + bindingLimit + "</cim:ConstraintResults.bindingLimit>\n" +
        "\t\t<cim:ConstraintResults.clearedValue>" + clearedValue + "</cim:ConstraintResults.clearedValue>\n" +
        (if (null != competitivePathConstraint) "\t\t<cim:ConstraintResults.competitivePathConstraint rdf:resource=\"#" + competitivePathConstraint + "\"/>\n" else "") +
        (if (null != constraintType) "\t\t<cim:ConstraintResults.constraintType rdf:resource=\"#" + constraintType + "\"/>\n" else "") +
        (if (null != limitFlag) "\t\t<cim:ConstraintResults.limitFlag rdf:resource=\"#" + limitFlag + "\"/>\n" else "") +
        (if (null != optimizationFlag) "\t\t<cim:ConstraintResults.optimizationFlag rdf:resource=\"#" + optimizationFlag + "\"/>\n" else "") +
        "\t\t<cim:ConstraintResults.overloadMW>" + overloadMW + "</cim:ConstraintResults.overloadMW>\n" +
        "\t\t<cim:ConstraintResults.percentMW>" + percentMW + "</cim:ConstraintResults.percentMW>\n" +
        "\t\t<cim:ConstraintResults.shadowPrice>" + shadowPrice + "</cim:ConstraintResults.shadowPrice>\n" +
        (if (null != updateTimeStamp) "\t\t<cim:ConstraintResults.updateTimeStamp>" + updateTimeStamp + "</cim:ConstraintResults.updateTimeStamp>\n" else "") +
        (if (null != updateType) "\t\t<cim:ConstraintResults.updateType rdf:resource=\"#" + updateType + "\"/>\n" else "") +
        (if (null != updateUser) "\t\t<cim:ConstraintResults.updateUser>" + updateUser + "</cim:ConstraintResults.updateUser>\n" else "") +
        "\t\t<cim:ConstraintResults.BGLimit>" + BGLimit + "</cim:ConstraintResults.BGLimit>\n" +
        "\t\t<cim:ConstraintResults.BGTRResCap>" + BGTRResCap + "</cim:ConstraintResults.BGTRResCap>\n" +
        (if (null != ConstraintClearing) "\t\t<cim:ConstraintResults.ConstraintClearing rdf:resource=\"#" + ConstraintClearing + "\"/>\n" else "") +
        (if (null != Flowgate) "\t\t<cim:ConstraintResults.Flowgate rdf:resource=\"#" + Flowgate + "\"/>\n" else "") +
        (if (null != MktContingency) "\t\t<cim:ConstraintResults.MktContingency rdf:resource=\"#" + MktContingency + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ConstraintResults rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ConstraintResults>"
    }
}

object ConstraintResults
extends
    Parseable[ConstraintResults]
{
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
            IdentifiedObject.parse (context),
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
 * @param updateTimeStamp <em>undocumented</em>
 * @param updateType <em>undocumented</em>
 * @param updateUser <em>undocumented</em>
 * @param RegisteredResouce <em>undocumented</em>
 */
case class DopInstruction
(
    override val sup: BasicElement,
    mwDOP: Double,
    plotPriority: Int,
    runIndicatorDOP: String,
    timestampDOP: String,
    updateTimeStamp: String,
    updateType: String,
    updateUser: String,
    RegisteredResouce: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[DopInstruction] }
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
        "\t\t<cim:DopInstruction.mwDOP>" + mwDOP + "</cim:DopInstruction.mwDOP>\n" +
        "\t\t<cim:DopInstruction.plotPriority>" + plotPriority + "</cim:DopInstruction.plotPriority>\n" +
        (if (null != runIndicatorDOP) "\t\t<cim:DopInstruction.runIndicatorDOP rdf:resource=\"#" + runIndicatorDOP + "\"/>\n" else "") +
        (if (null != timestampDOP) "\t\t<cim:DopInstruction.timestampDOP>" + timestampDOP + "</cim:DopInstruction.timestampDOP>\n" else "") +
        (if (null != updateTimeStamp) "\t\t<cim:DopInstruction.updateTimeStamp>" + updateTimeStamp + "</cim:DopInstruction.updateTimeStamp>\n" else "") +
        (if (null != updateType) "\t\t<cim:DopInstruction.updateType rdf:resource=\"#" + updateType + "\"/>\n" else "") +
        (if (null != updateUser) "\t\t<cim:DopInstruction.updateUser>" + updateUser + "</cim:DopInstruction.updateUser>\n" else "") +
        (if (null != RegisteredResouce) "\t\t<cim:DopInstruction.RegisteredResouce rdf:resource=\"#" + RegisteredResouce + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:DopInstruction rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DopInstruction>"
    }
}

object DopInstruction
extends
    Parseable[DopInstruction]
{
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
            BasicElement.parse (context),
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
 * @param RegisteredResource <em>undocumented</em>
 */
case class DotInstruction
(
    override val sup: BasicElement,
    actualRampRate: Double,
    compliantIndicator: String,
    economicMaxOverride: Double,
    expectedEnergy: Double,
    generatorPerformanceDegree: Double,
    hourAheadSchedEnergy: Double,
    hourlySchedule: Double,
    instructionTime: String,
    maximumEmergencyInd: Boolean,
    meterLoadFollowing: Double,
    nonRampRestrictedMW: Double,
    nonSpinReserve: Double,
    previousDOTTimeStamp: String,
    rampRateLimit: Double,
    regulationStatus: String,
    spinReserve: Double,
    standardRampEnergy: Double,
    supplementalEnergy: Double,
    unitStatus: Int,
    DOT: Double,
    RegisteredResource: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, 0.0, 0.0, 0.0, 0.0, 0.0, null, false, 0.0, 0.0, 0.0, null, 0.0, null, 0.0, 0.0, 0.0, 0, 0.0, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[DotInstruction] }
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
        "\t\t<cim:DotInstruction.actualRampRate>" + actualRampRate + "</cim:DotInstruction.actualRampRate>\n" +
        (if (null != compliantIndicator) "\t\t<cim:DotInstruction.compliantIndicator rdf:resource=\"#" + compliantIndicator + "\"/>\n" else "") +
        "\t\t<cim:DotInstruction.economicMaxOverride>" + economicMaxOverride + "</cim:DotInstruction.economicMaxOverride>\n" +
        "\t\t<cim:DotInstruction.expectedEnergy>" + expectedEnergy + "</cim:DotInstruction.expectedEnergy>\n" +
        "\t\t<cim:DotInstruction.generatorPerformanceDegree>" + generatorPerformanceDegree + "</cim:DotInstruction.generatorPerformanceDegree>\n" +
        "\t\t<cim:DotInstruction.hourAheadSchedEnergy>" + hourAheadSchedEnergy + "</cim:DotInstruction.hourAheadSchedEnergy>\n" +
        "\t\t<cim:DotInstruction.hourlySchedule>" + hourlySchedule + "</cim:DotInstruction.hourlySchedule>\n" +
        (if (null != instructionTime) "\t\t<cim:DotInstruction.instructionTime>" + instructionTime + "</cim:DotInstruction.instructionTime>\n" else "") +
        "\t\t<cim:DotInstruction.maximumEmergencyInd>" + maximumEmergencyInd + "</cim:DotInstruction.maximumEmergencyInd>\n" +
        "\t\t<cim:DotInstruction.meterLoadFollowing>" + meterLoadFollowing + "</cim:DotInstruction.meterLoadFollowing>\n" +
        "\t\t<cim:DotInstruction.nonRampRestrictedMW>" + nonRampRestrictedMW + "</cim:DotInstruction.nonRampRestrictedMW>\n" +
        "\t\t<cim:DotInstruction.nonSpinReserve>" + nonSpinReserve + "</cim:DotInstruction.nonSpinReserve>\n" +
        (if (null != previousDOTTimeStamp) "\t\t<cim:DotInstruction.previousDOTTimeStamp>" + previousDOTTimeStamp + "</cim:DotInstruction.previousDOTTimeStamp>\n" else "") +
        "\t\t<cim:DotInstruction.rampRateLimit>" + rampRateLimit + "</cim:DotInstruction.rampRateLimit>\n" +
        (if (null != regulationStatus) "\t\t<cim:DotInstruction.regulationStatus rdf:resource=\"#" + regulationStatus + "\"/>\n" else "") +
        "\t\t<cim:DotInstruction.spinReserve>" + spinReserve + "</cim:DotInstruction.spinReserve>\n" +
        "\t\t<cim:DotInstruction.standardRampEnergy>" + standardRampEnergy + "</cim:DotInstruction.standardRampEnergy>\n" +
        "\t\t<cim:DotInstruction.supplementalEnergy>" + supplementalEnergy + "</cim:DotInstruction.supplementalEnergy>\n" +
        "\t\t<cim:DotInstruction.unitStatus>" + unitStatus + "</cim:DotInstruction.unitStatus>\n" +
        "\t\t<cim:DotInstruction.DOT>" + DOT + "</cim:DotInstruction.DOT>\n" +
        (if (null != RegisteredResource) "\t\t<cim:DotInstruction.RegisteredResource rdf:resource=\"#" + RegisteredResource + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:DotInstruction rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DotInstruction>"
    }
}

object DotInstruction
extends
    Parseable[DotInstruction]
{
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
            BasicElement.parse (context),
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
    override def copy (): Row = { clone ().asInstanceOf[ExPostLoss] }
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
        "\t<cim:ExPostLoss rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ExPostLoss>"
    }
}

object ExPostLoss
extends
    Parseable[ExPostLoss]
{
    def parse (context: Context): ExPostLoss =
    {
        ExPostLoss(
            MarketFactors.parse (context)
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
 * @param ExPostLoss <em>undocumented</em>
 * @param SubControlArea <em>undocumented</em>
 */
case class ExPostLossResults
(
    override val sup: BasicElement,
    ehvLossMW: Double,
    totalLossMW: Double,
    ExPostLoss: String,
    SubControlArea: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ExPostLossResults] }
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
        "\t\t<cim:ExPostLossResults.ehvLossMW>" + ehvLossMW + "</cim:ExPostLossResults.ehvLossMW>\n" +
        "\t\t<cim:ExPostLossResults.totalLossMW>" + totalLossMW + "</cim:ExPostLossResults.totalLossMW>\n" +
        (if (null != ExPostLoss) "\t\t<cim:ExPostLossResults.ExPostLoss rdf:resource=\"#" + ExPostLoss + "\"/>\n" else "") +
        (if (null != SubControlArea) "\t\t<cim:ExPostLossResults.SubControlArea rdf:resource=\"#" + SubControlArea + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ExPostLossResults rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ExPostLossResults>"
    }
}

object ExPostLossResults
extends
    Parseable[ExPostLossResults]
{
    val ehvLossMW = parse_element (element ("""ExPostLossResults.ehvLossMW"""))
    val totalLossMW = parse_element (element ("""ExPostLossResults.totalLossMW"""))
    val ExPostLoss = parse_attribute (attribute ("""ExPostLossResults.ExPostLoss"""))
    val SubControlArea = parse_attribute (attribute ("""ExPostLossResults.SubControlArea"""))
    def parse (context: Context): ExPostLossResults =
    {
        ExPostLossResults(
            BasicElement.parse (context),
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
 * @param ExPostMarketRegionResults <em>undocumented</em>
 */
case class ExPostMarketRegion
(
    override val sup: MarketFactors,
    ExPostMarketRegionResults: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { clone ().asInstanceOf[ExPostMarketRegion] }
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
        (if (null != ExPostMarketRegionResults) "\t\t<cim:ExPostMarketRegion.ExPostMarketRegionResults rdf:resource=\"#" + ExPostMarketRegionResults + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ExPostMarketRegion rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ExPostMarketRegion>"
    }
}

object ExPostMarketRegion
extends
    Parseable[ExPostMarketRegion]
{
    val ExPostMarketRegionResults = parse_attribute (attribute ("""ExPostMarketRegion.ExPostMarketRegionResults"""))
    def parse (context: Context): ExPostMarketRegion =
    {
        ExPostMarketRegion(
            MarketFactors.parse (context),
            ExPostMarketRegionResults (context)
        )
    }
}

/**
 * Model of expost calculation of cleared MW on a region basis.
 * Includes cleared price
 * @param sup Reference to the superclass object.
 * @param exPostClearedPrice <em>undocumented</em>
 * @param ExPostMarketRegion <em>undocumented</em>
 * @param MarketRegion <em>undocumented</em>
 */
case class ExPostMarketRegionResults
(
    override val sup: BasicElement,
    exPostClearedPrice: Double,
    ExPostMarketRegion: String,
    MarketRegion: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ExPostMarketRegionResults] }
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
        "\t\t<cim:ExPostMarketRegionResults.exPostClearedPrice>" + exPostClearedPrice + "</cim:ExPostMarketRegionResults.exPostClearedPrice>\n" +
        (if (null != ExPostMarketRegion) "\t\t<cim:ExPostMarketRegionResults.ExPostMarketRegion rdf:resource=\"#" + ExPostMarketRegion + "\"/>\n" else "") +
        (if (null != MarketRegion) "\t\t<cim:ExPostMarketRegionResults.MarketRegion rdf:resource=\"#" + MarketRegion + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ExPostMarketRegionResults rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ExPostMarketRegionResults>"
    }
}

object ExPostMarketRegionResults
extends
    Parseable[ExPostMarketRegionResults]
{
    val exPostClearedPrice = parse_element (element ("""ExPostMarketRegionResults.exPostClearedPrice"""))
    val ExPostMarketRegion = parse_attribute (attribute ("""ExPostMarketRegionResults.ExPostMarketRegion"""))
    val MarketRegion = parse_attribute (attribute ("""ExPostMarketRegionResults.MarketRegion"""))
    def parse (context: Context): ExPostMarketRegionResults =
    {
        ExPostMarketRegionResults(
            BasicElement.parse (context),
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
    energyPrice: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { clone ().asInstanceOf[ExPostPricing] }
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
        "\t\t<cim:ExPostPricing.energyPrice>" + energyPrice + "</cim:ExPostPricing.energyPrice>\n"
    }
    override def export: String =
    {
        "\t<cim:ExPostPricing rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ExPostPricing>"
    }
}

object ExPostPricing
extends
    Parseable[ExPostPricing]
{
    val energyPrice = parse_element (element ("""ExPostPricing.energyPrice"""))
    def parse (context: Context): ExPostPricing =
    {
        ExPostPricing(
            MarketFactors.parse (context),
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
 * @param ExPostPricing <em>undocumented</em>
 * @param Pnode <em>undocumented</em>
 */
case class ExPostPricingResults
(
    override val sup: BasicElement,
    congestLMP: Double,
    lmp: Double,
    lossLMP: Double,
    ExPostPricing: String,
    Pnode: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ExPostPricingResults] }
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
        "\t\t<cim:ExPostPricingResults.congestLMP>" + congestLMP + "</cim:ExPostPricingResults.congestLMP>\n" +
        "\t\t<cim:ExPostPricingResults.lmp>" + lmp + "</cim:ExPostPricingResults.lmp>\n" +
        "\t\t<cim:ExPostPricingResults.lossLMP>" + lossLMP + "</cim:ExPostPricingResults.lossLMP>\n" +
        (if (null != ExPostPricing) "\t\t<cim:ExPostPricingResults.ExPostPricing rdf:resource=\"#" + ExPostPricing + "\"/>\n" else "") +
        (if (null != Pnode) "\t\t<cim:ExPostPricingResults.Pnode rdf:resource=\"#" + Pnode + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ExPostPricingResults rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ExPostPricingResults>"
    }
}

object ExPostPricingResults
extends
    Parseable[ExPostPricingResults]
{
    val congestLMP = parse_element (element ("""ExPostPricingResults.congestLMP"""))
    val lmp = parse_element (element ("""ExPostPricingResults.lmp"""))
    val lossLMP = parse_element (element ("""ExPostPricingResults.lossLMP"""))
    val ExPostPricing = parse_attribute (attribute ("""ExPostPricingResults.ExPostPricing"""))
    val Pnode = parse_attribute (attribute ("""ExPostPricingResults.Pnode"""))
    def parse (context: Context): ExPostPricingResults =
    {
        ExPostPricingResults(
            BasicElement.parse (context),
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
    override def copy (): Row = { clone ().asInstanceOf[ExPostResource] }
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
        "\t<cim:ExPostResource rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ExPostResource>"
    }
}

object ExPostResource
extends
    Parseable[ExPostResource]
{
    def parse (context: Context): ExPostResource =
    {
        ExPostResource(
            MarketFactors.parse (context)
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
 * @param ExPostResource <em>undocumented</em>
 * @param RegisteredResource <em>undocumented</em>
 */
case class ExPostResourceResults
(
    override val sup: BasicElement,
    congestionLMP: Double,
    desiredMW: Double,
    dispatchRate: Double,
    lmp: Double,
    lossLMP: Double,
    maxEconomicMW: Double,
    minEconomicMW: Double,
    resourceMW: Double,
    status: String,
    ExPostResource: String,
    RegisteredResource: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ExPostResourceResults] }
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
        "\t\t<cim:ExPostResourceResults.congestionLMP>" + congestionLMP + "</cim:ExPostResourceResults.congestionLMP>\n" +
        "\t\t<cim:ExPostResourceResults.desiredMW>" + desiredMW + "</cim:ExPostResourceResults.desiredMW>\n" +
        "\t\t<cim:ExPostResourceResults.dispatchRate>" + dispatchRate + "</cim:ExPostResourceResults.dispatchRate>\n" +
        "\t\t<cim:ExPostResourceResults.lmp>" + lmp + "</cim:ExPostResourceResults.lmp>\n" +
        "\t\t<cim:ExPostResourceResults.lossLMP>" + lossLMP + "</cim:ExPostResourceResults.lossLMP>\n" +
        "\t\t<cim:ExPostResourceResults.maxEconomicMW>" + maxEconomicMW + "</cim:ExPostResourceResults.maxEconomicMW>\n" +
        "\t\t<cim:ExPostResourceResults.minEconomicMW>" + minEconomicMW + "</cim:ExPostResourceResults.minEconomicMW>\n" +
        "\t\t<cim:ExPostResourceResults.resourceMW>" + resourceMW + "</cim:ExPostResourceResults.resourceMW>\n" +
        (if (null != status) "\t\t<cim:ExPostResourceResults.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != ExPostResource) "\t\t<cim:ExPostResourceResults.ExPostResource rdf:resource=\"#" + ExPostResource + "\"/>\n" else "") +
        (if (null != RegisteredResource) "\t\t<cim:ExPostResourceResults.RegisteredResource rdf:resource=\"#" + RegisteredResource + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ExPostResourceResults rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ExPostResourceResults>"
    }
}

object ExPostResourceResults
extends
    Parseable[ExPostResourceResults]
{
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
            BasicElement.parse (context),
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
    override def copy (): Row = { clone ().asInstanceOf[GeneralClearing] }
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
        "\t<cim:GeneralClearing rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GeneralClearing>"
    }
}

object GeneralClearing
extends
    Parseable[GeneralClearing]
{
    def parse (context: Context): GeneralClearing =
    {
        GeneralClearing(
            MarketFactors.parse (context)
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
 * @param GeneralClearing <em>undocumented</em>
 * @param SubControlArea <em>undocumented</em>
 */
case class GeneralClearingResults
(
    override val sup: BasicElement,
    loadForecast: Double,
    totalLoad: Double,
    totalNetInterchange: Double,
    GeneralClearing: String,
    SubControlArea: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[GeneralClearingResults] }
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
        "\t\t<cim:GeneralClearingResults.loadForecast>" + loadForecast + "</cim:GeneralClearingResults.loadForecast>\n" +
        "\t\t<cim:GeneralClearingResults.totalLoad>" + totalLoad + "</cim:GeneralClearingResults.totalLoad>\n" +
        "\t\t<cim:GeneralClearingResults.totalNetInterchange>" + totalNetInterchange + "</cim:GeneralClearingResults.totalNetInterchange>\n" +
        (if (null != GeneralClearing) "\t\t<cim:GeneralClearingResults.GeneralClearing rdf:resource=\"#" + GeneralClearing + "\"/>\n" else "") +
        (if (null != SubControlArea) "\t\t<cim:GeneralClearingResults.SubControlArea rdf:resource=\"#" + SubControlArea + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:GeneralClearingResults rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GeneralClearingResults>"
    }
}

object GeneralClearingResults
extends
    Parseable[GeneralClearingResults]
{
    val loadForecast = parse_element (element ("""GeneralClearingResults.loadForecast"""))
    val totalLoad = parse_element (element ("""GeneralClearingResults.totalLoad"""))
    val totalNetInterchange = parse_element (element ("""GeneralClearingResults.totalNetInterchange"""))
    val GeneralClearing = parse_attribute (attribute ("""GeneralClearingResults.GeneralClearing"""))
    val SubControlArea = parse_attribute (attribute ("""GeneralClearingResults.SubControlArea"""))
    def parse (context: Context): GeneralClearingResults =
    {
        GeneralClearingResults(
            BasicElement.parse (context),
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
    override def copy (): Row = { clone ().asInstanceOf[InstructionClearing] }
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
        "\t<cim:InstructionClearing rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:InstructionClearing>"
    }
}

object InstructionClearing
extends
    Parseable[InstructionClearing]
{
    def parse (context: Context): InstructionClearing =
    {
        InstructionClearing(
            MarketFactors.parse (context)
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
    override def copy (): Row = { clone ().asInstanceOf[InstructionClearingDOP] }
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
        "\t<cim:InstructionClearingDOP rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:InstructionClearingDOP>"
    }
}

object InstructionClearingDOP
extends
    Parseable[InstructionClearingDOP]
{
    def parse (context: Context): InstructionClearingDOP =
    {
        InstructionClearingDOP(
            MarketFactors.parse (context)
        )
    }
}

/**
 * Model of market clearing, related to Dispatch Operating Target (model of anticipatory dispatch).
 * Identifies interval
 * @param sup Reference to the superclass object.
 * @param contingencyActive Indication that the system is currently operating in a contingency mode.
 * @param dispatchMode <em>undocumented</em>
 */
case class InstructionClearingDOT
(
    override val sup: MarketFactors,
    contingencyActive: String,
    dispatchMode: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { clone ().asInstanceOf[InstructionClearingDOT] }
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
        (if (null != contingencyActive) "\t\t<cim:InstructionClearingDOT.contingencyActive rdf:resource=\"#" + contingencyActive + "\"/>\n" else "") +
        (if (null != dispatchMode) "\t\t<cim:InstructionClearingDOT.dispatchMode rdf:resource=\"#" + dispatchMode + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:InstructionClearingDOT rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:InstructionClearingDOT>"
    }
}

object InstructionClearingDOT
extends
    Parseable[InstructionClearingDOT]
{
    val contingencyActive = parse_attribute (attribute ("""InstructionClearingDOT.contingencyActive"""))
    val dispatchMode = parse_attribute (attribute ("""InstructionClearingDOT.dispatchMode"""))
    def parse (context: Context): InstructionClearingDOT =
    {
        InstructionClearingDOT(
            MarketFactors.parse (context),
            contingencyActive (context),
            dispatchMode (context)
        )
    }
}

/**
 * Provides the necessary information (on a resource basis) to capture the Startup/Shutdown instruction results.
 * This information is relevant to the DA Market (RUC only) as well as the RT Market (HASP, Pre-dispatch, and Interval).
 * @param sup Reference to the superclass object.
 * @param bindingDOT <em>undocumented</em>
 * @param bindingInstruction <em>undocumented</em>
 * @param instructionCost Total cost associated with changing the status of the resource.
 * @param instructionSource instruction source for market quality results (INS, ACT)
 * @param instructionStartTime Time the resource should be at Pmin (for start ups).
 *        Time the resource is off line.
 * @param instructionType Indicator of either a Start-Up or a Shut-Down.
 * @param manuallyBlocked Manually Blocked Indicator (Yes/No).
 *        The instruction has been blocked by an Operator.
 * @param minStatusChangeTime Minimum start up time required to bring the unit online (minutes).
 *        SCUC commitment period start-up time. Calculated start up time based on the StartUpTimeCurve provided with the Bid.
 * @param updateTimeStamp <em>undocumented</em>
 * @param updateType <em>undocumented</em>
 * @param updateUser <em>undocumented</em>
 * @param RegisteredResource <em>undocumented</em>
 */
case class Instructions
(
    override val sup: BasicElement,
    bindingDOT: Double,
    bindingInstruction: String,
    instructionCost: Double,
    instructionSource: String,
    instructionStartTime: String,
    instructionType: String,
    manuallyBlocked: String,
    minStatusChangeTime: Int,
    updateTimeStamp: String,
    updateType: String,
    updateUser: String,
    RegisteredResource: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, 0.0, null, null, null, null, 0, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[Instructions] }
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
        "\t\t<cim:Instructions.bindingDOT>" + bindingDOT + "</cim:Instructions.bindingDOT>\n" +
        (if (null != bindingInstruction) "\t\t<cim:Instructions.bindingInstruction rdf:resource=\"#" + bindingInstruction + "\"/>\n" else "") +
        "\t\t<cim:Instructions.instructionCost>" + instructionCost + "</cim:Instructions.instructionCost>\n" +
        (if (null != instructionSource) "\t\t<cim:Instructions.instructionSource rdf:resource=\"#" + instructionSource + "\"/>\n" else "") +
        (if (null != instructionStartTime) "\t\t<cim:Instructions.instructionStartTime>" + instructionStartTime + "</cim:Instructions.instructionStartTime>\n" else "") +
        (if (null != instructionType) "\t\t<cim:Instructions.instructionType rdf:resource=\"#" + instructionType + "\"/>\n" else "") +
        (if (null != manuallyBlocked) "\t\t<cim:Instructions.manuallyBlocked rdf:resource=\"#" + manuallyBlocked + "\"/>\n" else "") +
        "\t\t<cim:Instructions.minStatusChangeTime>" + minStatusChangeTime + "</cim:Instructions.minStatusChangeTime>\n" +
        (if (null != updateTimeStamp) "\t\t<cim:Instructions.updateTimeStamp>" + updateTimeStamp + "</cim:Instructions.updateTimeStamp>\n" else "") +
        (if (null != updateType) "\t\t<cim:Instructions.updateType rdf:resource=\"#" + updateType + "\"/>\n" else "") +
        (if (null != updateUser) "\t\t<cim:Instructions.updateUser>" + updateUser + "</cim:Instructions.updateUser>\n" else "") +
        (if (null != RegisteredResource) "\t\t<cim:Instructions.RegisteredResource rdf:resource=\"#" + RegisteredResource + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Instructions rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Instructions>"
    }
}

object Instructions
extends
    Parseable[Instructions]
{
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
            BasicElement.parse (context),
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
 * @param updateTimeStamp <em>undocumented</em>
 * @param updateType <em>undocumented</em>
 * @param updateUser <em>undocumented</em>
 * @param RegisteredResource <em>undocumented</em>
 */
case class LoadFollowingOperatorInput
(
    override val sup: BasicElement,
    dataEntryTimeStamp: String,
    tempLoadFollowingDownManualCap: Double,
    tempLoadFollowingUpManualCap: Double,
    updateTimeStamp: String,
    updateType: String,
    updateUser: String,
    RegisteredResource: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, 0.0, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[LoadFollowingOperatorInput] }
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
        (if (null != dataEntryTimeStamp) "\t\t<cim:LoadFollowingOperatorInput.dataEntryTimeStamp>" + dataEntryTimeStamp + "</cim:LoadFollowingOperatorInput.dataEntryTimeStamp>\n" else "") +
        "\t\t<cim:LoadFollowingOperatorInput.tempLoadFollowingDownManualCap>" + tempLoadFollowingDownManualCap + "</cim:LoadFollowingOperatorInput.tempLoadFollowingDownManualCap>\n" +
        "\t\t<cim:LoadFollowingOperatorInput.tempLoadFollowingUpManualCap>" + tempLoadFollowingUpManualCap + "</cim:LoadFollowingOperatorInput.tempLoadFollowingUpManualCap>\n" +
        (if (null != updateTimeStamp) "\t\t<cim:LoadFollowingOperatorInput.updateTimeStamp>" + updateTimeStamp + "</cim:LoadFollowingOperatorInput.updateTimeStamp>\n" else "") +
        (if (null != updateType) "\t\t<cim:LoadFollowingOperatorInput.updateType rdf:resource=\"#" + updateType + "\"/>\n" else "") +
        (if (null != updateUser) "\t\t<cim:LoadFollowingOperatorInput.updateUser>" + updateUser + "</cim:LoadFollowingOperatorInput.updateUser>\n" else "") +
        (if (null != RegisteredResource) "\t\t<cim:LoadFollowingOperatorInput.RegisteredResource rdf:resource=\"#" + RegisteredResource + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:LoadFollowingOperatorInput rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:LoadFollowingOperatorInput>"
    }
}

object LoadFollowingOperatorInput
extends
    Parseable[LoadFollowingOperatorInput]
{
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
            BasicElement.parse (context),
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
    override def copy (): Row = { clone ().asInstanceOf[LossClearing] }
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
        "\t<cim:LossClearing rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:LossClearing>"
    }
}

object LossClearing
extends
    Parseable[LossClearing]
{
    def parse (context: Context): LossClearing =
    {
        LossClearing(
            MarketFactors.parse (context)
        )
    }
}

/**
 * Provides the MW loss for RUC Zones, subcontrol areas, and the total loss.
 * @param sup Reference to the superclass object.
 * @param lossMW <em>undocumented</em>
 * @param HostControlArea <em>undocumented</em>
 * @param LossClearing <em>undocumented</em>
 * @param RUCZone <em>undocumented</em>
 * @param SubControlArea <em>undocumented</em>
 */
case class LossClearingResults
(
    override val sup: BasicElement,
    lossMW: Double,
    HostControlArea: String,
    LossClearing: String,
    RUCZone: String,
    SubControlArea: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[LossClearingResults] }
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
        "\t\t<cim:LossClearingResults.lossMW>" + lossMW + "</cim:LossClearingResults.lossMW>\n" +
        (if (null != HostControlArea) "\t\t<cim:LossClearingResults.HostControlArea rdf:resource=\"#" + HostControlArea + "\"/>\n" else "") +
        (if (null != LossClearing) "\t\t<cim:LossClearingResults.LossClearing rdf:resource=\"#" + LossClearing + "\"/>\n" else "") +
        (if (null != RUCZone) "\t\t<cim:LossClearingResults.RUCZone rdf:resource=\"#" + RUCZone + "\"/>\n" else "") +
        (if (null != SubControlArea) "\t\t<cim:LossClearingResults.SubControlArea rdf:resource=\"#" + SubControlArea + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:LossClearingResults rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:LossClearingResults>"
    }
}

object LossClearingResults
extends
    Parseable[LossClearingResults]
{
    val lossMW = parse_element (element ("""LossClearingResults.lossMW"""))
    val HostControlArea = parse_attribute (attribute ("""LossClearingResults.HostControlArea"""))
    val LossClearing = parse_attribute (attribute ("""LossClearingResults.LossClearing"""))
    val RUCZone = parse_attribute (attribute ("""LossClearingResults.RUCZone"""))
    val SubControlArea = parse_attribute (attribute ("""LossClearingResults.SubControlArea"""))
    def parse (context: Context): LossClearingResults =
    {
        LossClearingResults(
            BasicElement.parse (context),
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
 * @param mitigationOccuredFlag <em>undocumented</em>
 * @param LMPMFinalFlag <em>undocumented</em>
 * @param SMPMFinalFlag <em>undocumented</em>
 */
case class MPMClearing
(
    override val sup: MarketFactors,
    mitigationOccuredFlag: String,
    LMPMFinalFlag: String,
    SMPMFinalFlag: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { clone ().asInstanceOf[MPMClearing] }
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
        (if (null != mitigationOccuredFlag) "\t\t<cim:MPMClearing.mitigationOccuredFlag rdf:resource=\"#" + mitigationOccuredFlag + "\"/>\n" else "") +
        (if (null != LMPMFinalFlag) "\t\t<cim:MPMClearing.LMPMFinalFlag rdf:resource=\"#" + LMPMFinalFlag + "\"/>\n" else "") +
        (if (null != SMPMFinalFlag) "\t\t<cim:MPMClearing.SMPMFinalFlag rdf:resource=\"#" + SMPMFinalFlag + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MPMClearing rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MPMClearing>"
    }
}

object MPMClearing
extends
    Parseable[MPMClearing]
{
    val mitigationOccuredFlag = parse_attribute (attribute ("""MPMClearing.mitigationOccuredFlag"""))
    val LMPMFinalFlag = parse_attribute (attribute ("""MPMClearing.LMPMFinalFlag"""))
    val SMPMFinalFlag = parse_attribute (attribute ("""MPMClearing.SMPMFinalFlag"""))
    def parse (context: Context): MPMClearing =
    {
        MPMClearing(
            MarketFactors.parse (context),
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
 * @param MPMTestCategory <em>undocumented</em>
 * @param RegisteredResource <em>undocumented</em>
 */
case class MPMResourceStatus
(
    override val sup: BasicElement,
    resourceStatus: String,
    MPMTestCategory: String,
    RegisteredResource: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[MPMResourceStatus] }
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
        (if (null != resourceStatus) "\t\t<cim:MPMResourceStatus.resourceStatus>" + resourceStatus + "</cim:MPMResourceStatus.resourceStatus>\n" else "") +
        (if (null != MPMTestCategory) "\t\t<cim:MPMResourceStatus.MPMTestCategory rdf:resource=\"#" + MPMTestCategory + "\"/>\n" else "") +
        (if (null != RegisteredResource) "\t\t<cim:MPMResourceStatus.RegisteredResource rdf:resource=\"#" + RegisteredResource + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MPMResourceStatus rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MPMResourceStatus>"
    }
}

object MPMResourceStatus
extends
    Parseable[MPMResourceStatus]
{
    val resourceStatus = parse_element (element ("""MPMResourceStatus.resourceStatus"""))
    val MPMTestCategory = parse_attribute (attribute ("""MPMResourceStatus.MPMTestCategory"""))
    val RegisteredResource = parse_attribute (attribute ("""MPMResourceStatus.RegisteredResource"""))
    def parse (context: Context): MPMResourceStatus =
    {
        MPMResourceStatus(
            BasicElement.parse (context),
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
 * @param AggregatedPnode <em>undocumented</em>
 * @param MPMClearing <em>undocumented</em>
 * @param MPMTestCategory <em>undocumented</em>
 */
case class MPMTestResults
(
    override val sup: BasicElement,
    marginPercent: Double,
    outcome: String,
    AggregatedPnode: String,
    MPMClearing: String,
    MPMTestCategory: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[MPMTestResults] }
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
        "\t\t<cim:MPMTestResults.marginPercent>" + marginPercent + "</cim:MPMTestResults.marginPercent>\n" +
        (if (null != outcome) "\t\t<cim:MPMTestResults.outcome rdf:resource=\"#" + outcome + "\"/>\n" else "") +
        (if (null != AggregatedPnode) "\t\t<cim:MPMTestResults.AggregatedPnode rdf:resource=\"#" + AggregatedPnode + "\"/>\n" else "") +
        (if (null != MPMClearing) "\t\t<cim:MPMTestResults.MPMClearing rdf:resource=\"#" + MPMClearing + "\"/>\n" else "") +
        (if (null != MPMTestCategory) "\t\t<cim:MPMTestResults.MPMTestCategory rdf:resource=\"#" + MPMTestCategory + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MPMTestResults rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MPMTestResults>"
    }
}

object MPMTestResults
extends
    Parseable[MPMTestResults]
{
    val marginPercent = parse_element (element ("""MPMTestResults.marginPercent"""))
    val outcome = parse_attribute (attribute ("""MPMTestResults.outcome"""))
    val AggregatedPnode = parse_attribute (attribute ("""MPMTestResults.AggregatedPnode"""))
    val MPMClearing = parse_attribute (attribute ("""MPMTestResults.MPMClearing"""))
    val MPMTestCategory = parse_attribute (attribute ("""MPMTestResults.MPMTestCategory"""))
    def parse (context: Context): MPMTestResults =
    {
        MPMTestResults(
            BasicElement.parse (context),
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
 * @param AncillaryServiceClearing <em>undocumented</em>
 * @param MarketProduct <em>undocumented</em>
 * @param MarketRegion <em>undocumented</em>
 */
case class MarketRegionResults
(
    override val sup: BasicElement,
    clearedMW: Double,
    clearedPrice: Double,
    dispatchCtMW: Double,
    dispatchHydroMW: Double,
    dispatchRate: Double,
    dispatchSteamMW: Double,
    imbalanceEnergyBias: Double,
    limitFlag: String,
    lumpyIndicator: String,
    maxSufficiencyIndex: Double,
    minSufficiencyIndex: Double,
    reqMaxMW: Double,
    reqMinMW: Double,
    selfScheduleMW: Double,
    AncillaryServiceClearing: String,
    MarketProduct: String,
    MarketRegion: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[MarketRegionResults] }
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
        "\t\t<cim:MarketRegionResults.clearedMW>" + clearedMW + "</cim:MarketRegionResults.clearedMW>\n" +
        "\t\t<cim:MarketRegionResults.clearedPrice>" + clearedPrice + "</cim:MarketRegionResults.clearedPrice>\n" +
        "\t\t<cim:MarketRegionResults.dispatchCtMW>" + dispatchCtMW + "</cim:MarketRegionResults.dispatchCtMW>\n" +
        "\t\t<cim:MarketRegionResults.dispatchHydroMW>" + dispatchHydroMW + "</cim:MarketRegionResults.dispatchHydroMW>\n" +
        "\t\t<cim:MarketRegionResults.dispatchRate>" + dispatchRate + "</cim:MarketRegionResults.dispatchRate>\n" +
        "\t\t<cim:MarketRegionResults.dispatchSteamMW>" + dispatchSteamMW + "</cim:MarketRegionResults.dispatchSteamMW>\n" +
        "\t\t<cim:MarketRegionResults.imbalanceEnergyBias>" + imbalanceEnergyBias + "</cim:MarketRegionResults.imbalanceEnergyBias>\n" +
        (if (null != limitFlag) "\t\t<cim:MarketRegionResults.limitFlag rdf:resource=\"#" + limitFlag + "\"/>\n" else "") +
        (if (null != lumpyIndicator) "\t\t<cim:MarketRegionResults.lumpyIndicator rdf:resource=\"#" + lumpyIndicator + "\"/>\n" else "") +
        "\t\t<cim:MarketRegionResults.maxSufficiencyIndex>" + maxSufficiencyIndex + "</cim:MarketRegionResults.maxSufficiencyIndex>\n" +
        "\t\t<cim:MarketRegionResults.minSufficiencyIndex>" + minSufficiencyIndex + "</cim:MarketRegionResults.minSufficiencyIndex>\n" +
        "\t\t<cim:MarketRegionResults.reqMaxMW>" + reqMaxMW + "</cim:MarketRegionResults.reqMaxMW>\n" +
        "\t\t<cim:MarketRegionResults.reqMinMW>" + reqMinMW + "</cim:MarketRegionResults.reqMinMW>\n" +
        "\t\t<cim:MarketRegionResults.selfScheduleMW>" + selfScheduleMW + "</cim:MarketRegionResults.selfScheduleMW>\n" +
        (if (null != AncillaryServiceClearing) "\t\t<cim:MarketRegionResults.AncillaryServiceClearing rdf:resource=\"#" + AncillaryServiceClearing + "\"/>\n" else "") +
        (if (null != MarketProduct) "\t\t<cim:MarketRegionResults.MarketProduct rdf:resource=\"#" + MarketProduct + "\"/>\n" else "") +
        (if (null != MarketRegion) "\t\t<cim:MarketRegionResults.MarketRegion rdf:resource=\"#" + MarketRegion + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MarketRegionResults rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MarketRegionResults>"
    }
}

object MarketRegionResults
extends
    Parseable[MarketRegionResults]
{
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
            BasicElement.parse (context),
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
 * @param EnergyMarket <em>undocumented</em>
 */
case class MarketResults
(
    override val sup: BasicElement,
    ancillarySvcCost: Double,
    contingentOperatingResAvail: String,
    energyCost: Double,
    minimumLoadCost: Double,
    startUpCost: Double,
    totalCost: Double,
    totalRucCost: Double,
    EnergyMarket: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, 0.0, 0.0, 0.0, 0.0, 0.0, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[MarketResults] }
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
        "\t\t<cim:MarketResults.ancillarySvcCost>" + ancillarySvcCost + "</cim:MarketResults.ancillarySvcCost>\n" +
        (if (null != contingentOperatingResAvail) "\t\t<cim:MarketResults.contingentOperatingResAvail rdf:resource=\"#" + contingentOperatingResAvail + "\"/>\n" else "") +
        "\t\t<cim:MarketResults.energyCost>" + energyCost + "</cim:MarketResults.energyCost>\n" +
        "\t\t<cim:MarketResults.minimumLoadCost>" + minimumLoadCost + "</cim:MarketResults.minimumLoadCost>\n" +
        "\t\t<cim:MarketResults.startUpCost>" + startUpCost + "</cim:MarketResults.startUpCost>\n" +
        "\t\t<cim:MarketResults.totalCost>" + totalCost + "</cim:MarketResults.totalCost>\n" +
        "\t\t<cim:MarketResults.totalRucCost>" + totalRucCost + "</cim:MarketResults.totalRucCost>\n" +
        (if (null != EnergyMarket) "\t\t<cim:MarketResults.EnergyMarket rdf:resource=\"#" + EnergyMarket + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MarketResults rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MarketResults>"
    }
}

object MarketResults
extends
    Parseable[MarketResults]
{
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
            BasicElement.parse (context),
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
    end: String,
    referenceNumber: String,
    start: String,
    tradeDate: String,
    transactionDate: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[MarketStatement] }
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
        (if (null != end) "\t\t<cim:MarketStatement.end>" + end + "</cim:MarketStatement.end>\n" else "") +
        (if (null != referenceNumber) "\t\t<cim:MarketStatement.referenceNumber>" + referenceNumber + "</cim:MarketStatement.referenceNumber>\n" else "") +
        (if (null != start) "\t\t<cim:MarketStatement.start>" + start + "</cim:MarketStatement.start>\n" else "") +
        (if (null != tradeDate) "\t\t<cim:MarketStatement.tradeDate>" + tradeDate + "</cim:MarketStatement.tradeDate>\n" else "") +
        (if (null != transactionDate) "\t\t<cim:MarketStatement.transactionDate>" + transactionDate + "</cim:MarketStatement.transactionDate>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MarketStatement rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MarketStatement>"
    }
}

object MarketStatement
extends
    Parseable[MarketStatement]
{
    val end = parse_element (element ("""MarketStatement.end"""))
    val referenceNumber = parse_element (element ("""MarketStatement.referenceNumber"""))
    val start = parse_element (element ("""MarketStatement.start"""))
    val tradeDate = parse_element (element ("""MarketStatement.tradeDate"""))
    val transactionDate = parse_element (element ("""MarketStatement.transactionDate"""))
    def parse (context: Context): MarketStatement =
    {
        MarketStatement(
            Document.parse (context),
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
 * @param ContainerMarketStatementLineItem <em>undocumented</em>
 * @param MarketStatement <em>undocumented</em>
 * @param MktUserAttribute <em>undocumented</em>
 * @param PassThroughBill <em>undocumented</em>
 */
case class MarketStatementLineItem
(
    override val sup: IdentifiedObject,
    currentAmount: Double,
    currentISOAmount: Double,
    currentISOQuantity: Double,
    currentPrice: Double,
    currentQuantity: Double,
    intervalDate: String,
    intervalNumber: String,
    netAmount: Double,
    netISOAmount: Double,
    netISOQuantity: Double,
    netPrice: Double,
    netQuantity: Double,
    previousAmount: Double,
    previousISOAmount: Double,
    previousISOQuantity: Double,
    previousQuantity: Double,
    previsouPrice: Double,
    quantityUOM: String,
    ContainerMarketStatementLineItem: String,
    MarketStatement: String,
    MktUserAttribute: List[String],
    PassThroughBill: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, null, List(), null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[MarketStatementLineItem] }
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
        "\t\t<cim:MarketStatementLineItem.currentAmount>" + currentAmount + "</cim:MarketStatementLineItem.currentAmount>\n" +
        "\t\t<cim:MarketStatementLineItem.currentISOAmount>" + currentISOAmount + "</cim:MarketStatementLineItem.currentISOAmount>\n" +
        "\t\t<cim:MarketStatementLineItem.currentISOQuantity>" + currentISOQuantity + "</cim:MarketStatementLineItem.currentISOQuantity>\n" +
        "\t\t<cim:MarketStatementLineItem.currentPrice>" + currentPrice + "</cim:MarketStatementLineItem.currentPrice>\n" +
        "\t\t<cim:MarketStatementLineItem.currentQuantity>" + currentQuantity + "</cim:MarketStatementLineItem.currentQuantity>\n" +
        (if (null != intervalDate) "\t\t<cim:MarketStatementLineItem.intervalDate>" + intervalDate + "</cim:MarketStatementLineItem.intervalDate>\n" else "") +
        (if (null != intervalNumber) "\t\t<cim:MarketStatementLineItem.intervalNumber>" + intervalNumber + "</cim:MarketStatementLineItem.intervalNumber>\n" else "") +
        "\t\t<cim:MarketStatementLineItem.netAmount>" + netAmount + "</cim:MarketStatementLineItem.netAmount>\n" +
        "\t\t<cim:MarketStatementLineItem.netISOAmount>" + netISOAmount + "</cim:MarketStatementLineItem.netISOAmount>\n" +
        "\t\t<cim:MarketStatementLineItem.netISOQuantity>" + netISOQuantity + "</cim:MarketStatementLineItem.netISOQuantity>\n" +
        "\t\t<cim:MarketStatementLineItem.netPrice>" + netPrice + "</cim:MarketStatementLineItem.netPrice>\n" +
        "\t\t<cim:MarketStatementLineItem.netQuantity>" + netQuantity + "</cim:MarketStatementLineItem.netQuantity>\n" +
        "\t\t<cim:MarketStatementLineItem.previousAmount>" + previousAmount + "</cim:MarketStatementLineItem.previousAmount>\n" +
        "\t\t<cim:MarketStatementLineItem.previousISOAmount>" + previousISOAmount + "</cim:MarketStatementLineItem.previousISOAmount>\n" +
        "\t\t<cim:MarketStatementLineItem.previousISOQuantity>" + previousISOQuantity + "</cim:MarketStatementLineItem.previousISOQuantity>\n" +
        "\t\t<cim:MarketStatementLineItem.previousQuantity>" + previousQuantity + "</cim:MarketStatementLineItem.previousQuantity>\n" +
        "\t\t<cim:MarketStatementLineItem.previsouPrice>" + previsouPrice + "</cim:MarketStatementLineItem.previsouPrice>\n" +
        (if (null != quantityUOM) "\t\t<cim:MarketStatementLineItem.quantityUOM>" + quantityUOM + "</cim:MarketStatementLineItem.quantityUOM>\n" else "") +
        (if (null != ContainerMarketStatementLineItem) "\t\t<cim:MarketStatementLineItem.ContainerMarketStatementLineItem rdf:resource=\"#" + ContainerMarketStatementLineItem + "\"/>\n" else "") +
        (if (null != MarketStatement) "\t\t<cim:MarketStatementLineItem.MarketStatement rdf:resource=\"#" + MarketStatement + "\"/>\n" else "") +
        (if (null != MktUserAttribute) MktUserAttribute.map (x => "\t\t<cim:MarketStatementLineItem.MktUserAttribute rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != PassThroughBill) "\t\t<cim:MarketStatementLineItem.PassThroughBill rdf:resource=\"#" + PassThroughBill + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MarketStatementLineItem rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MarketStatementLineItem>"
    }
}

object MarketStatementLineItem
extends
    Parseable[MarketStatementLineItem]
{
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
            IdentifiedObject.parse (context),
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
 * @param Bid <em>undocumented</em>
 */
case class MitigatedBid
(
    override val sup: IdentifiedObject,
    Bid: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[MitigatedBid] }
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
        (if (null != Bid) "\t\t<cim:MitigatedBid.Bid rdf:resource=\"#" + Bid + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MitigatedBid rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MitigatedBid>"
    }
}

object MitigatedBid
extends
    Parseable[MitigatedBid]
{
    val Bid = parse_attribute (attribute ("""MitigatedBid.Bid"""))
    def parse (context: Context): MitigatedBid =
    {
        MitigatedBid(
            IdentifiedObject.parse (context),
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
    override def copy (): Row = { clone ().asInstanceOf[MitigatedBidClearing] }
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
        "\t<cim:MitigatedBidClearing rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MitigatedBidClearing>"
    }
}

object MitigatedBidClearing
extends
    Parseable[MitigatedBidClearing]
{
    def parse (context: Context): MitigatedBidClearing =
    {
        MitigatedBidClearing(
            MarketFactors.parse (context)
        )
    }
}

/**
 * Model of mitigated bid.
 * Indicates segment of piece-wise linear bid, that has been mitigated
 * @param sup Reference to the superclass object.
 * @param intervalStartTime <em>undocumented</em>
 * @param segmentMW Mitigated bid segment MW value
 * @param segmentNumber Mitigated Bid Segment Number
 * @param thresholdType <em>undocumented</em>
 * @param Bid <em>undocumented</em>
 */
case class MitigatedBidSegment
(
    override val sup: BasicElement,
    intervalStartTime: String,
    segmentMW: Double,
    segmentNumber: Int,
    thresholdType: String,
    Bid: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, 0, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[MitigatedBidSegment] }
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
        (if (null != intervalStartTime) "\t\t<cim:MitigatedBidSegment.intervalStartTime>" + intervalStartTime + "</cim:MitigatedBidSegment.intervalStartTime>\n" else "") +
        "\t\t<cim:MitigatedBidSegment.segmentMW>" + segmentMW + "</cim:MitigatedBidSegment.segmentMW>\n" +
        "\t\t<cim:MitigatedBidSegment.segmentNumber>" + segmentNumber + "</cim:MitigatedBidSegment.segmentNumber>\n" +
        (if (null != thresholdType) "\t\t<cim:MitigatedBidSegment.thresholdType>" + thresholdType + "</cim:MitigatedBidSegment.thresholdType>\n" else "") +
        (if (null != Bid) "\t\t<cim:MitigatedBidSegment.Bid rdf:resource=\"#" + Bid + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MitigatedBidSegment rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MitigatedBidSegment>"
    }
}

object MitigatedBidSegment
extends
    Parseable[MitigatedBidSegment]
{
    val intervalStartTime = parse_element (element ("""MitigatedBidSegment.intervalStartTime"""))
    val segmentMW = parse_element (element ("""MitigatedBidSegment.segmentMW"""))
    val segmentNumber = parse_element (element ("""MitigatedBidSegment.segmentNumber"""))
    val thresholdType = parse_element (element ("""MitigatedBidSegment.thresholdType"""))
    val Bid = parse_attribute (attribute ("""MitigatedBidSegment.Bid"""))
    def parse (context: Context): MitigatedBidSegment =
    {
        MitigatedBidSegment(
            BasicElement.parse (context),
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
 * @param adjustedAmount <em>undocumented</em>
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
 * @param MarketStatementLineItem <em>undocumented</em>
 * @param MktUserAttribute <em>undocumented</em>
 */
case class PassThroughBill
(
    override val sup: Document,
    adjustedAmount: Double,
    amount: Double,
    billEnd: String,
    billRunType: String,
    billStart: String,
    billedTo: String,
    effectiveDate: String,
    isDisputed: Boolean,
    isProfiled: Boolean,
    paidTo: String,
    previousEnd: String,
    previousStart: String,
    price: Double,
    productCode: String,
    providedBy: String,
    quantity: String,
    serviceEnd: String,
    serviceStart: String,
    soldTo: String,
    taxAmount: Double,
    timeZone: String,
    tradeDate: String,
    transactionDate: String,
    transactionType: String,
    MarketStatementLineItem: String,
    MktUserAttribute: List[String]
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null, null, null, null, null, false, false, null, null, null, 0.0, null, null, null, null, null, null, 0.0, null, null, null, null, null, List()) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[PassThroughBill] }
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
        "\t\t<cim:PassThroughBill.adjustedAmount>" + adjustedAmount + "</cim:PassThroughBill.adjustedAmount>\n" +
        "\t\t<cim:PassThroughBill.amount>" + amount + "</cim:PassThroughBill.amount>\n" +
        (if (null != billEnd) "\t\t<cim:PassThroughBill.billEnd>" + billEnd + "</cim:PassThroughBill.billEnd>\n" else "") +
        (if (null != billRunType) "\t\t<cim:PassThroughBill.billRunType>" + billRunType + "</cim:PassThroughBill.billRunType>\n" else "") +
        (if (null != billStart) "\t\t<cim:PassThroughBill.billStart>" + billStart + "</cim:PassThroughBill.billStart>\n" else "") +
        (if (null != billedTo) "\t\t<cim:PassThroughBill.billedTo>" + billedTo + "</cim:PassThroughBill.billedTo>\n" else "") +
        (if (null != effectiveDate) "\t\t<cim:PassThroughBill.effectiveDate>" + effectiveDate + "</cim:PassThroughBill.effectiveDate>\n" else "") +
        "\t\t<cim:PassThroughBill.isDisputed>" + isDisputed + "</cim:PassThroughBill.isDisputed>\n" +
        "\t\t<cim:PassThroughBill.isProfiled>" + isProfiled + "</cim:PassThroughBill.isProfiled>\n" +
        (if (null != paidTo) "\t\t<cim:PassThroughBill.paidTo>" + paidTo + "</cim:PassThroughBill.paidTo>\n" else "") +
        (if (null != previousEnd) "\t\t<cim:PassThroughBill.previousEnd>" + previousEnd + "</cim:PassThroughBill.previousEnd>\n" else "") +
        (if (null != previousStart) "\t\t<cim:PassThroughBill.previousStart>" + previousStart + "</cim:PassThroughBill.previousStart>\n" else "") +
        "\t\t<cim:PassThroughBill.price>" + price + "</cim:PassThroughBill.price>\n" +
        (if (null != productCode) "\t\t<cim:PassThroughBill.productCode>" + productCode + "</cim:PassThroughBill.productCode>\n" else "") +
        (if (null != providedBy) "\t\t<cim:PassThroughBill.providedBy>" + providedBy + "</cim:PassThroughBill.providedBy>\n" else "") +
        (if (null != quantity) "\t\t<cim:PassThroughBill.quantity rdf:resource=\"#" + quantity + "\"/>\n" else "") +
        (if (null != serviceEnd) "\t\t<cim:PassThroughBill.serviceEnd>" + serviceEnd + "</cim:PassThroughBill.serviceEnd>\n" else "") +
        (if (null != serviceStart) "\t\t<cim:PassThroughBill.serviceStart>" + serviceStart + "</cim:PassThroughBill.serviceStart>\n" else "") +
        (if (null != soldTo) "\t\t<cim:PassThroughBill.soldTo>" + soldTo + "</cim:PassThroughBill.soldTo>\n" else "") +
        "\t\t<cim:PassThroughBill.taxAmount>" + taxAmount + "</cim:PassThroughBill.taxAmount>\n" +
        (if (null != timeZone) "\t\t<cim:PassThroughBill.timeZone>" + timeZone + "</cim:PassThroughBill.timeZone>\n" else "") +
        (if (null != tradeDate) "\t\t<cim:PassThroughBill.tradeDate>" + tradeDate + "</cim:PassThroughBill.tradeDate>\n" else "") +
        (if (null != transactionDate) "\t\t<cim:PassThroughBill.transactionDate>" + transactionDate + "</cim:PassThroughBill.transactionDate>\n" else "") +
        (if (null != transactionType) "\t\t<cim:PassThroughBill.transactionType>" + transactionType + "</cim:PassThroughBill.transactionType>\n" else "") +
        (if (null != MarketStatementLineItem) "\t\t<cim:PassThroughBill.MarketStatementLineItem rdf:resource=\"#" + MarketStatementLineItem + "\"/>\n" else "") +
        (if (null != MktUserAttribute) MktUserAttribute.map (x => "\t\t<cim:PassThroughBill.MktUserAttribute rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:PassThroughBill rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PassThroughBill>"
    }
}

object PassThroughBill
extends
    Parseable[PassThroughBill]
{
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
            Document.parse (context),
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
    override def copy (): Row = { clone ().asInstanceOf[PnodeClearing] }
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
        "\t<cim:PnodeClearing rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PnodeClearing>"
    }
}

object PnodeClearing
extends
    Parseable[PnodeClearing]
{
    def parse (context: Context): PnodeClearing =
    {
        PnodeClearing(
            MarketFactors.parse (context)
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
 * @param updateTimeStamp <em>undocumented</em>
 * @param updateType <em>undocumented</em>
 * @param updateUser <em>undocumented</em>
 * @param Pnode <em>undocumented</em>
 * @param PnodeClearing <em>undocumented</em>
 */
case class PnodeResults
(
    override val sup: BasicElement,
    congestLMP: Double,
    costLMP: Double,
    lossLMP: Double,
    marginalClearingPrice: Double,
    scheduledMW: Double,
    updateTimeStamp: String,
    updateType: String,
    updateUser: String,
    Pnode: String,
    PnodeClearing: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[PnodeResults] }
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
        "\t\t<cim:PnodeResults.congestLMP>" + congestLMP + "</cim:PnodeResults.congestLMP>\n" +
        "\t\t<cim:PnodeResults.costLMP>" + costLMP + "</cim:PnodeResults.costLMP>\n" +
        "\t\t<cim:PnodeResults.lossLMP>" + lossLMP + "</cim:PnodeResults.lossLMP>\n" +
        "\t\t<cim:PnodeResults.marginalClearingPrice>" + marginalClearingPrice + "</cim:PnodeResults.marginalClearingPrice>\n" +
        "\t\t<cim:PnodeResults.scheduledMW>" + scheduledMW + "</cim:PnodeResults.scheduledMW>\n" +
        (if (null != updateTimeStamp) "\t\t<cim:PnodeResults.updateTimeStamp>" + updateTimeStamp + "</cim:PnodeResults.updateTimeStamp>\n" else "") +
        (if (null != updateType) "\t\t<cim:PnodeResults.updateType rdf:resource=\"#" + updateType + "\"/>\n" else "") +
        (if (null != updateUser) "\t\t<cim:PnodeResults.updateUser>" + updateUser + "</cim:PnodeResults.updateUser>\n" else "") +
        (if (null != Pnode) "\t\t<cim:PnodeResults.Pnode rdf:resource=\"#" + Pnode + "\"/>\n" else "") +
        (if (null != PnodeClearing) "\t\t<cim:PnodeResults.PnodeClearing rdf:resource=\"#" + PnodeClearing + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:PnodeResults rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PnodeResults>"
    }
}

object PnodeResults
extends
    Parseable[PnodeResults]
{
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
            BasicElement.parse (context),
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
 * @param Bid <em>undocumented</em>
 */
case class RMRDetermination
(
    override val sup: BasicElement,
    Bid: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[RMRDetermination] }
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
        (if (null != Bid) "\t\t<cim:RMRDetermination.Bid rdf:resource=\"#" + Bid + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:RMRDetermination rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RMRDetermination>"
    }
}

object RMRDetermination
extends
    Parseable[RMRDetermination]
{
    val Bid = parse_attribute (attribute ("""RMRDetermination.Bid"""))
    def parse (context: Context): RMRDetermination =
    {
        RMRDetermination(
            BasicElement.parse (context),
            Bid (context)
        )
    }
}

/**
 * RMR Operator's entry of the RMR requirement per market interval.
 * @param sup Reference to the superclass object.
 * @param manuallySchedRMRMw The lower of the original pre-dispatch or the AC run schedule (Also known as the RMR Reguirement) becomes the pre-dispatch value.
 * @param updateTimeStamp <em>undocumented</em>
 * @param updateType <em>undocumented</em>
 * @param updateUser <em>undocumented</em>
 * @param RegisteredResource <em>undocumented</em>
 */
case class RMROperatorInput
(
    override val sup: MarketFactors,
    manuallySchedRMRMw: Double,
    updateTimeStamp: String,
    updateType: String,
    updateUser: String,
    RegisteredResource: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null, null, null) }
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { clone ().asInstanceOf[RMROperatorInput] }
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
        "\t\t<cim:RMROperatorInput.manuallySchedRMRMw>" + manuallySchedRMRMw + "</cim:RMROperatorInput.manuallySchedRMRMw>\n" +
        (if (null != updateTimeStamp) "\t\t<cim:RMROperatorInput.updateTimeStamp>" + updateTimeStamp + "</cim:RMROperatorInput.updateTimeStamp>\n" else "") +
        (if (null != updateType) "\t\t<cim:RMROperatorInput.updateType rdf:resource=\"#" + updateType + "\"/>\n" else "") +
        (if (null != updateUser) "\t\t<cim:RMROperatorInput.updateUser>" + updateUser + "</cim:RMROperatorInput.updateUser>\n" else "") +
        (if (null != RegisteredResource) "\t\t<cim:RMROperatorInput.RegisteredResource rdf:resource=\"#" + RegisteredResource + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:RMROperatorInput rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RMROperatorInput>"
    }
}

object RMROperatorInput
extends
    Parseable[RMROperatorInput]
{
    val manuallySchedRMRMw = parse_element (element ("""RMROperatorInput.manuallySchedRMRMw"""))
    val updateTimeStamp = parse_element (element ("""RMROperatorInput.updateTimeStamp"""))
    val updateType = parse_attribute (attribute ("""RMROperatorInput.updateType"""))
    val updateUser = parse_element (element ("""RMROperatorInput.updateUser"""))
    val RegisteredResource = parse_attribute (attribute ("""RMROperatorInput.RegisteredResource"""))
    def parse (context: Context): RMROperatorInput =
    {
        RMROperatorInput(
            MarketFactors.parse (context),
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
 * @param updateTimeStamp <em>undocumented</em>
 * @param updateType <em>undocumented</em>
 * @param updateUser <em>undocumented</em>
 * @param RUCAward The RUC Award of a resource is the portion of the RUC Capacity that is not under RA or RMR contracts.
 *        The RUC Award of a resource is the portion of the RUC Capacity that is eligible for RUC Availability payment.
 * @param RUCCapacity The RUC Capacity of a resource is the difference between (i) the RUC Schedule and (ii) the higher of the DA Schedule and the Minimum Load.
 * @param RUCSchedule The RUC Schedule of a resource is its output level that balances the load forecast used in RUC.
 *        The RUC Schedule in RUC is similar to the DA Schedule in DAM.
 * @param RegisteredResource <em>undocumented</em>
 */
case class RUCAwardInstruction
(
    override val sup: BasicElement,
    clearedPrice: Double,
    marketProductType: String,
    updateTimeStamp: String,
    updateType: String,
    updateUser: String,
    RUCAward: Double,
    RUCCapacity: Double,
    RUCSchedule: Double,
    RegisteredResource: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null, null, null, 0.0, 0.0, 0.0, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[RUCAwardInstruction] }
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
        "\t\t<cim:RUCAwardInstruction.clearedPrice>" + clearedPrice + "</cim:RUCAwardInstruction.clearedPrice>\n" +
        (if (null != marketProductType) "\t\t<cim:RUCAwardInstruction.marketProductType rdf:resource=\"#" + marketProductType + "\"/>\n" else "") +
        (if (null != updateTimeStamp) "\t\t<cim:RUCAwardInstruction.updateTimeStamp>" + updateTimeStamp + "</cim:RUCAwardInstruction.updateTimeStamp>\n" else "") +
        (if (null != updateType) "\t\t<cim:RUCAwardInstruction.updateType rdf:resource=\"#" + updateType + "\"/>\n" else "") +
        (if (null != updateUser) "\t\t<cim:RUCAwardInstruction.updateUser>" + updateUser + "</cim:RUCAwardInstruction.updateUser>\n" else "") +
        "\t\t<cim:RUCAwardInstruction.RUCAward>" + RUCAward + "</cim:RUCAwardInstruction.RUCAward>\n" +
        "\t\t<cim:RUCAwardInstruction.RUCCapacity>" + RUCCapacity + "</cim:RUCAwardInstruction.RUCCapacity>\n" +
        "\t\t<cim:RUCAwardInstruction.RUCSchedule>" + RUCSchedule + "</cim:RUCAwardInstruction.RUCSchedule>\n" +
        (if (null != RegisteredResource) "\t\t<cim:RUCAwardInstruction.RegisteredResource rdf:resource=\"#" + RegisteredResource + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:RUCAwardInstruction rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RUCAwardInstruction>"
    }
}

object RUCAwardInstruction
extends
    Parseable[RUCAwardInstruction]
{
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
            BasicElement.parse (context),
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
 * @param dispatchMode <em>undocumented</em>
 */
case class ResourceAwardClearing
(
    override val sup: MarketFactors,
    contingencyActive: String,
    dispatchMode: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { clone ().asInstanceOf[ResourceAwardClearing] }
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
        (if (null != contingencyActive) "\t\t<cim:ResourceAwardClearing.contingencyActive rdf:resource=\"#" + contingencyActive + "\"/>\n" else "") +
        (if (null != dispatchMode) "\t\t<cim:ResourceAwardClearing.dispatchMode rdf:resource=\"#" + dispatchMode + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ResourceAwardClearing rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ResourceAwardClearing>"
    }
}

object ResourceAwardClearing
extends
    Parseable[ResourceAwardClearing]
{
    val contingencyActive = parse_attribute (attribute ("""ResourceAwardClearing.contingencyActive"""))
    val dispatchMode = parse_attribute (attribute ("""ResourceAwardClearing.dispatchMode"""))
    def parse (context: Context): ResourceAwardClearing =
    {
        ResourceAwardClearing(
            MarketFactors.parse (context),
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
 * @param updateTimeStamp <em>undocumented</em>
 * @param updateType <em>undocumented</em>
 * @param updateUser <em>undocumented</em>
 * @param MarketProduct <em>undocumented</em>
 * @param RegisteredResource <em>undocumented</em>
 */
case class ResourceAwardInstruction
(
    override val sup: BasicElement,
    awardMW: Double,
    clearedMW: Double,
    clearedPrice: Double,
    congestLMP: Double,
    costLMP: Double,
    dispatcherAddedMW: Double,
    economicMax: Double,
    economicMin: Double,
    effRegulationDownLimit: Double,
    effRegulationUpLimit: Double,
    lmp: Double,
    lossLMP: Double,
    manuallyBlocked: String,
    marginalResourceIndicator: String,
    mustRunInd: Boolean,
    noLoadCost: Double,
    optimalBidCost: Double,
    optimalBidPay: Double,
    optimalMargin: Double,
    overrideTimeStamp: String,
    overrideValue: Double,
    selfSchedMW: Double,
    startUpCost: Double,
    status: String,
    totalRevenue: Double,
    updateTimeStamp: String,
    updateType: String,
    updateUser: String,
    MarketProduct: String,
    RegisteredResource: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, false, 0.0, 0.0, 0.0, 0.0, null, 0.0, 0.0, 0.0, null, 0.0, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ResourceAwardInstruction] }
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
        "\t\t<cim:ResourceAwardInstruction.awardMW>" + awardMW + "</cim:ResourceAwardInstruction.awardMW>\n" +
        "\t\t<cim:ResourceAwardInstruction.clearedMW>" + clearedMW + "</cim:ResourceAwardInstruction.clearedMW>\n" +
        "\t\t<cim:ResourceAwardInstruction.clearedPrice>" + clearedPrice + "</cim:ResourceAwardInstruction.clearedPrice>\n" +
        "\t\t<cim:ResourceAwardInstruction.congestLMP>" + congestLMP + "</cim:ResourceAwardInstruction.congestLMP>\n" +
        "\t\t<cim:ResourceAwardInstruction.costLMP>" + costLMP + "</cim:ResourceAwardInstruction.costLMP>\n" +
        "\t\t<cim:ResourceAwardInstruction.dispatcherAddedMW>" + dispatcherAddedMW + "</cim:ResourceAwardInstruction.dispatcherAddedMW>\n" +
        "\t\t<cim:ResourceAwardInstruction.economicMax>" + economicMax + "</cim:ResourceAwardInstruction.economicMax>\n" +
        "\t\t<cim:ResourceAwardInstruction.economicMin>" + economicMin + "</cim:ResourceAwardInstruction.economicMin>\n" +
        "\t\t<cim:ResourceAwardInstruction.effRegulationDownLimit>" + effRegulationDownLimit + "</cim:ResourceAwardInstruction.effRegulationDownLimit>\n" +
        "\t\t<cim:ResourceAwardInstruction.effRegulationUpLimit>" + effRegulationUpLimit + "</cim:ResourceAwardInstruction.effRegulationUpLimit>\n" +
        "\t\t<cim:ResourceAwardInstruction.lmp>" + lmp + "</cim:ResourceAwardInstruction.lmp>\n" +
        "\t\t<cim:ResourceAwardInstruction.lossLMP>" + lossLMP + "</cim:ResourceAwardInstruction.lossLMP>\n" +
        (if (null != manuallyBlocked) "\t\t<cim:ResourceAwardInstruction.manuallyBlocked rdf:resource=\"#" + manuallyBlocked + "\"/>\n" else "") +
        (if (null != marginalResourceIndicator) "\t\t<cim:ResourceAwardInstruction.marginalResourceIndicator rdf:resource=\"#" + marginalResourceIndicator + "\"/>\n" else "") +
        "\t\t<cim:ResourceAwardInstruction.mustRunInd>" + mustRunInd + "</cim:ResourceAwardInstruction.mustRunInd>\n" +
        "\t\t<cim:ResourceAwardInstruction.noLoadCost>" + noLoadCost + "</cim:ResourceAwardInstruction.noLoadCost>\n" +
        "\t\t<cim:ResourceAwardInstruction.optimalBidCost>" + optimalBidCost + "</cim:ResourceAwardInstruction.optimalBidCost>\n" +
        "\t\t<cim:ResourceAwardInstruction.optimalBidPay>" + optimalBidPay + "</cim:ResourceAwardInstruction.optimalBidPay>\n" +
        "\t\t<cim:ResourceAwardInstruction.optimalMargin>" + optimalMargin + "</cim:ResourceAwardInstruction.optimalMargin>\n" +
        (if (null != overrideTimeStamp) "\t\t<cim:ResourceAwardInstruction.overrideTimeStamp>" + overrideTimeStamp + "</cim:ResourceAwardInstruction.overrideTimeStamp>\n" else "") +
        "\t\t<cim:ResourceAwardInstruction.overrideValue>" + overrideValue + "</cim:ResourceAwardInstruction.overrideValue>\n" +
        "\t\t<cim:ResourceAwardInstruction.selfSchedMW>" + selfSchedMW + "</cim:ResourceAwardInstruction.selfSchedMW>\n" +
        "\t\t<cim:ResourceAwardInstruction.startUpCost>" + startUpCost + "</cim:ResourceAwardInstruction.startUpCost>\n" +
        (if (null != status) "\t\t<cim:ResourceAwardInstruction.status>" + status + "</cim:ResourceAwardInstruction.status>\n" else "") +
        "\t\t<cim:ResourceAwardInstruction.totalRevenue>" + totalRevenue + "</cim:ResourceAwardInstruction.totalRevenue>\n" +
        (if (null != updateTimeStamp) "\t\t<cim:ResourceAwardInstruction.updateTimeStamp>" + updateTimeStamp + "</cim:ResourceAwardInstruction.updateTimeStamp>\n" else "") +
        (if (null != updateType) "\t\t<cim:ResourceAwardInstruction.updateType rdf:resource=\"#" + updateType + "\"/>\n" else "") +
        (if (null != updateUser) "\t\t<cim:ResourceAwardInstruction.updateUser>" + updateUser + "</cim:ResourceAwardInstruction.updateUser>\n" else "") +
        (if (null != MarketProduct) "\t\t<cim:ResourceAwardInstruction.MarketProduct rdf:resource=\"#" + MarketProduct + "\"/>\n" else "") +
        (if (null != RegisteredResource) "\t\t<cim:ResourceAwardInstruction.RegisteredResource rdf:resource=\"#" + RegisteredResource + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ResourceAwardInstruction rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ResourceAwardInstruction>"
    }
}

object ResourceAwardInstruction
extends
    Parseable[ResourceAwardInstruction]
{
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
            BasicElement.parse (context),
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
    override def copy (): Row = { clone ().asInstanceOf[ResourceClearing] }
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
        "\t<cim:ResourceClearing rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ResourceClearing>"
    }
}

object ResourceClearing
extends
    Parseable[ResourceClearing]
{
    def parse (context: Context): ResourceClearing =
    {
        ResourceClearing(
            MarketFactors.parse (context)
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
 * @param updateTimeStamp <em>undocumented</em>
 * @param updateType <em>undocumented</em>
 * @param updateUser <em>undocumented</em>
 * @param upperLimit resource energy ramping upper limit
 * @param RegisteredResource <em>undocumented</em>
 * @param ResourceClearing <em>undocumented</em>
 */
case class ResourceDispatchResults
(
    override val sup: BasicElement,
    blockedDispatch: String,
    blockedPublishDOP: String,
    contingencyFlag: String,
    limitIndicator: String,
    lowerLimit: Double,
    maxRampRate: Double,
    operatingLimitHigh: Double,
    operatingLimitLow: Double,
    penaltyDispatchIndicator: String,
    regulatingLimitHigh: Double,
    regulatingLimitLow: Double,
    resourceStatus: String,
    totalSchedule: Double,
    updateTimeStamp: String,
    updateType: String,
    updateUser: String,
    upperLimit: Double,
    RegisteredResource: String,
    ResourceClearing: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, 0.0, 0.0, 0.0, 0.0, null, 0.0, 0.0, null, 0.0, null, null, null, 0.0, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ResourceDispatchResults] }
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
        (if (null != blockedDispatch) "\t\t<cim:ResourceDispatchResults.blockedDispatch>" + blockedDispatch + "</cim:ResourceDispatchResults.blockedDispatch>\n" else "") +
        (if (null != blockedPublishDOP) "\t\t<cim:ResourceDispatchResults.blockedPublishDOP>" + blockedPublishDOP + "</cim:ResourceDispatchResults.blockedPublishDOP>\n" else "") +
        (if (null != contingencyFlag) "\t\t<cim:ResourceDispatchResults.contingencyFlag rdf:resource=\"#" + contingencyFlag + "\"/>\n" else "") +
        (if (null != limitIndicator) "\t\t<cim:ResourceDispatchResults.limitIndicator>" + limitIndicator + "</cim:ResourceDispatchResults.limitIndicator>\n" else "") +
        "\t\t<cim:ResourceDispatchResults.lowerLimit>" + lowerLimit + "</cim:ResourceDispatchResults.lowerLimit>\n" +
        "\t\t<cim:ResourceDispatchResults.maxRampRate>" + maxRampRate + "</cim:ResourceDispatchResults.maxRampRate>\n" +
        "\t\t<cim:ResourceDispatchResults.operatingLimitHigh>" + operatingLimitHigh + "</cim:ResourceDispatchResults.operatingLimitHigh>\n" +
        "\t\t<cim:ResourceDispatchResults.operatingLimitLow>" + operatingLimitLow + "</cim:ResourceDispatchResults.operatingLimitLow>\n" +
        (if (null != penaltyDispatchIndicator) "\t\t<cim:ResourceDispatchResults.penaltyDispatchIndicator rdf:resource=\"#" + penaltyDispatchIndicator + "\"/>\n" else "") +
        "\t\t<cim:ResourceDispatchResults.regulatingLimitHigh>" + regulatingLimitHigh + "</cim:ResourceDispatchResults.regulatingLimitHigh>\n" +
        "\t\t<cim:ResourceDispatchResults.regulatingLimitLow>" + regulatingLimitLow + "</cim:ResourceDispatchResults.regulatingLimitLow>\n" +
        (if (null != resourceStatus) "\t\t<cim:ResourceDispatchResults.resourceStatus>" + resourceStatus + "</cim:ResourceDispatchResults.resourceStatus>\n" else "") +
        "\t\t<cim:ResourceDispatchResults.totalSchedule>" + totalSchedule + "</cim:ResourceDispatchResults.totalSchedule>\n" +
        (if (null != updateTimeStamp) "\t\t<cim:ResourceDispatchResults.updateTimeStamp>" + updateTimeStamp + "</cim:ResourceDispatchResults.updateTimeStamp>\n" else "") +
        (if (null != updateType) "\t\t<cim:ResourceDispatchResults.updateType rdf:resource=\"#" + updateType + "\"/>\n" else "") +
        (if (null != updateUser) "\t\t<cim:ResourceDispatchResults.updateUser>" + updateUser + "</cim:ResourceDispatchResults.updateUser>\n" else "") +
        "\t\t<cim:ResourceDispatchResults.upperLimit>" + upperLimit + "</cim:ResourceDispatchResults.upperLimit>\n" +
        (if (null != RegisteredResource) "\t\t<cim:ResourceDispatchResults.RegisteredResource rdf:resource=\"#" + RegisteredResource + "\"/>\n" else "") +
        (if (null != ResourceClearing) "\t\t<cim:ResourceDispatchResults.ResourceClearing rdf:resource=\"#" + ResourceClearing + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ResourceDispatchResults rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ResourceDispatchResults>"
    }
}

object ResourceDispatchResults
extends
    Parseable[ResourceDispatchResults]
{
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
            BasicElement.parse (context),
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
 * @param dispWindowHighLimt <em>undocumented</em>
 * @param dispWindowLowLimt <em>undocumented</em>
 * @param instructionID Unique instruction id per instruction, assigned by the SC and provided to ADS.
 *        ADS passes through.
 * @param intervalStartTime The start of the time interval for which requirement is defined.
 * @param RegisteredResource <em>undocumented</em>
 * @param ResourceClearing <em>undocumented</em>
 */
case class ResourceLoadFollowingInst
(
    override val sup: BasicElement,
    calcLoadFollowingMW: Double,
    dispWindowHighLimt: Double,
    dispWindowLowLimt: Double,
    instructionID: String,
    intervalStartTime: String,
    RegisteredResource: String,
    ResourceClearing: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ResourceLoadFollowingInst] }
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
        "\t\t<cim:ResourceLoadFollowingInst.calcLoadFollowingMW>" + calcLoadFollowingMW + "</cim:ResourceLoadFollowingInst.calcLoadFollowingMW>\n" +
        "\t\t<cim:ResourceLoadFollowingInst.dispWindowHighLimt>" + dispWindowHighLimt + "</cim:ResourceLoadFollowingInst.dispWindowHighLimt>\n" +
        "\t\t<cim:ResourceLoadFollowingInst.dispWindowLowLimt>" + dispWindowLowLimt + "</cim:ResourceLoadFollowingInst.dispWindowLowLimt>\n" +
        (if (null != instructionID) "\t\t<cim:ResourceLoadFollowingInst.instructionID>" + instructionID + "</cim:ResourceLoadFollowingInst.instructionID>\n" else "") +
        (if (null != intervalStartTime) "\t\t<cim:ResourceLoadFollowingInst.intervalStartTime>" + intervalStartTime + "</cim:ResourceLoadFollowingInst.intervalStartTime>\n" else "") +
        (if (null != RegisteredResource) "\t\t<cim:ResourceLoadFollowingInst.RegisteredResource rdf:resource=\"#" + RegisteredResource + "\"/>\n" else "") +
        (if (null != ResourceClearing) "\t\t<cim:ResourceLoadFollowingInst.ResourceClearing rdf:resource=\"#" + ResourceClearing + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ResourceLoadFollowingInst rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ResourceLoadFollowingInst>"
    }
}

object ResourceLoadFollowingInst
extends
    Parseable[ResourceLoadFollowingInst]
{
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
            BasicElement.parse (context),
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
 * @param ResourceAwardInstruction <em>undocumented</em>
 */
case class SelfScheduleBreakdown
(
    override val sup: BasicElement,
    selfSchedMW: Double,
    selfSchedType: String,
    ResourceAwardInstruction: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[SelfScheduleBreakdown] }
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
        "\t\t<cim:SelfScheduleBreakdown.selfSchedMW>" + selfSchedMW + "</cim:SelfScheduleBreakdown.selfSchedMW>\n" +
        (if (null != selfSchedType) "\t\t<cim:SelfScheduleBreakdown.selfSchedType rdf:resource=\"#" + selfSchedType + "\"/>\n" else "") +
        (if (null != ResourceAwardInstruction) "\t\t<cim:SelfScheduleBreakdown.ResourceAwardInstruction rdf:resource=\"#" + ResourceAwardInstruction + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SelfScheduleBreakdown rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SelfScheduleBreakdown>"
    }
}

object SelfScheduleBreakdown
extends
    Parseable[SelfScheduleBreakdown]
{
    val selfSchedMW = parse_element (element ("""SelfScheduleBreakdown.selfSchedMW"""))
    val selfSchedType = parse_attribute (attribute ("""SelfScheduleBreakdown.selfSchedType"""))
    val ResourceAwardInstruction = parse_attribute (attribute ("""SelfScheduleBreakdown.ResourceAwardInstruction"""))
    def parse (context: Context): SelfScheduleBreakdown =
    {
        SelfScheduleBreakdown(
            BasicElement.parse (context),
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
 * @param EnergyMarket <em>undocumented</em>
 */
case class Settlement
(
    override val sup: Document,
    tradeDate: String,
    EnergyMarket: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[Settlement] }
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
        (if (null != tradeDate) "\t\t<cim:Settlement.tradeDate>" + tradeDate + "</cim:Settlement.tradeDate>\n" else "") +
        (if (null != EnergyMarket) "\t\t<cim:Settlement.EnergyMarket rdf:resource=\"#" + EnergyMarket + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Settlement rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Settlement>"
    }
}

object Settlement
extends
    Parseable[Settlement]
{
    val tradeDate = parse_element (element ("""Settlement.tradeDate"""))
    val EnergyMarket = parse_attribute (attribute ("""Settlement.EnergyMarket"""))
    def parse (context: Context): Settlement =
    {
        Settlement(
            Document.parse (context),
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
    override def copy (): Row = { clone ().asInstanceOf[TransactionBidClearing] }
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
        "\t<cim:TransactionBidClearing rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TransactionBidClearing>"
    }
}

object TransactionBidClearing
extends
    Parseable[TransactionBidClearing]
{
    def parse (context: Context): TransactionBidClearing =
    {
        TransactionBidClearing(
            MarketFactors.parse (context)
        )
    }
}

/**
 * Contains the cleared results for each TransactionBid submitted to and accepted by the market.
 * @param sup Reference to the superclass object.
 * @param clearedMW The market transaction megawatt
 * @param clearedPrice The price of the market transaction
 * @param TransactionBid <em>undocumented</em>
 * @param TransactionBidClearing <em>undocumented</em>
 */
case class TransactionBidResults
(
    override val sup: IdentifiedObject,
    clearedMW: Double,
    clearedPrice: Double,
    TransactionBid: String,
    TransactionBidClearing: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[TransactionBidResults] }
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
        "\t\t<cim:TransactionBidResults.clearedMW>" + clearedMW + "</cim:TransactionBidResults.clearedMW>\n" +
        "\t\t<cim:TransactionBidResults.clearedPrice>" + clearedPrice + "</cim:TransactionBidResults.clearedPrice>\n" +
        (if (null != TransactionBid) "\t\t<cim:TransactionBidResults.TransactionBid rdf:resource=\"#" + TransactionBid + "\"/>\n" else "") +
        (if (null != TransactionBidClearing) "\t\t<cim:TransactionBidResults.TransactionBidClearing rdf:resource=\"#" + TransactionBidClearing + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TransactionBidResults rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TransactionBidResults>"
    }
}

object TransactionBidResults
extends
    Parseable[TransactionBidResults]
{
    val clearedMW = parse_element (element ("""TransactionBidResults.clearedMW"""))
    val clearedPrice = parse_element (element ("""TransactionBidResults.clearedPrice"""))
    val TransactionBid = parse_attribute (attribute ("""TransactionBidResults.TransactionBid"""))
    val TransactionBidClearing = parse_attribute (attribute ("""TransactionBidResults.TransactionBidClearing"""))
    def parse (context: Context): TransactionBidResults =
    {
        TransactionBidResults(
            IdentifiedObject.parse (context),
            toDouble (clearedMW (context), context),
            toDouble (clearedPrice (context), context),
            TransactionBid (context),
            TransactionBidClearing (context)
        )
    }
}

private[ninecode] object _MarketResults
{
    def register: List[ClassInfo] =
    {
        List (
            AncillaryServiceClearing.register,
            BillDeterminant.register,
            ChargeProfile.register,
            ChargeProfileData.register,
            CommitmentClearing.register,
            Commitments.register,
            ConstraintClearing.register,
            ConstraintResults.register,
            DopInstruction.register,
            DotInstruction.register,
            ExPostLoss.register,
            ExPostLossResults.register,
            ExPostMarketRegion.register,
            ExPostMarketRegionResults.register,
            ExPostPricing.register,
            ExPostPricingResults.register,
            ExPostResource.register,
            ExPostResourceResults.register,
            GeneralClearing.register,
            GeneralClearingResults.register,
            InstructionClearing.register,
            InstructionClearingDOP.register,
            InstructionClearingDOT.register,
            Instructions.register,
            LoadFollowingOperatorInput.register,
            LossClearing.register,
            LossClearingResults.register,
            MPMClearing.register,
            MPMResourceStatus.register,
            MPMTestResults.register,
            MarketRegionResults.register,
            MarketResults.register,
            MarketStatement.register,
            MarketStatementLineItem.register,
            MitigatedBid.register,
            MitigatedBidClearing.register,
            MitigatedBidSegment.register,
            PassThroughBill.register,
            PnodeClearing.register,
            PnodeResults.register,
            RMRDetermination.register,
            RMROperatorInput.register,
            RUCAwardInstruction.register,
            ResourceAwardClearing.register,
            ResourceAwardInstruction.register,
            ResourceClearing.register,
            ResourceDispatchResults.register,
            ResourceLoadFollowingInst.register,
            SelfScheduleBreakdown.register,
            Settlement.register,
            TransactionBidClearing.register,
            TransactionBidResults.register
        )
    }
}