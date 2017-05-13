package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * This package provides the capability to schedule and account for transactions for the exchange of electric power between companies.
 * It includes transations for megawatts which are generated, consumed, lost, passed through, sold and purchased. These classes are used by Accounting and Billing for Energy, Generation Capacity, Transmission, and Ancillary Services.
 */

/**
 * The control area's reserve specification.
 */
case class AreaReserveSpec
(

    override val sup: BasicElement,

    /**
     * Lower regulating margin requirement in MW, the amount of generation that can be dropped by control in 10 minutes
     */
    val lowerRegMarginReqt: Double,

    /**
     * Operating reserve requirement in MW, where operating reserve is the generating capability that is fully available within 30 minutes.
     * Operating reserve is composed of primary reserve (t less than 10 min) and secondary reserve (10 less than t less than 30 min).
     */
    val opReserveReqt: Double,

    /**
     * Primary reserve requirement in MW, where primary reserve is generating capability that is fully available within 10 minutes.
     * Primary reserve is composed of spinning reserve and quick-start reserve.
     */
    val primaryReserveReqt: Double,

    /**
     * Raise regulating margin requirement in MW, the amount of generation that can be picked up by control in 10 minutes
     */
    val raiseRegMarginReqt: Double,

    /**
     * Spinning reserve requirement in MW, spinning reserve is generating capability that is presently synchronized to the network and is fully available within 10 minutes
     */
    val spinningReserveReqt: Double,

    /**
     * Description of the object or instance.
     */
    val Description: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[AreaReserveSpec]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AreaReserveSpec
extends
    Parseable[AreaReserveSpec]
{
    val sup = BasicElement.parse _
    val lowerRegMarginReqt = parse_element (element ("""AreaReserveSpec.lowerRegMarginReqt"""))_
    val opReserveReqt = parse_element (element ("""AreaReserveSpec.opReserveReqt"""))_
    val primaryReserveReqt = parse_element (element ("""AreaReserveSpec.primaryReserveReqt"""))_
    val raiseRegMarginReqt = parse_element (element ("""AreaReserveSpec.raiseRegMarginReqt"""))_
    val spinningReserveReqt = parse_element (element ("""AreaReserveSpec.spinningReserveReqt"""))_
    val Description = parse_element (element ("""AreaReserveSpec.Description"""))_
    def parse (context: Context): AreaReserveSpec =
    {
        AreaReserveSpec(
            sup (context),
            toDouble (lowerRegMarginReqt (context), context),
            toDouble (opReserveReqt (context), context),
            toDouble (primaryReserveReqt (context), context),
            toDouble (raiseRegMarginReqt (context), context),
            toDouble (spinningReserveReqt (context), context),
            Description (context)
        )
    }
}

/**
 * Control area emergency schedules
 */
case class CurrentEmergencyScheduledInterchange
(

    override val sup: IdentifiedObject,

    /**
     * Net tie MW.
     * These are three entries, the current emergency schedule interchange and the two future schedules if they exist.
     */
    val emergencyScheduleMW: Double,

    /**
     * Ramp time, the ramping time for a schedule.
     * This is calculated as the remaining time to ramp if a schedule is ramping. Measured in seconds, but can be negattive.
     */
    val emergencyScheduleRampTime: Int,

    /**
     * Net tie time,  the start time for a schedule.
     * This is calculated as the current time if a schedule is ramping.
     */
    val emergencyScheduleStartTime: String,

    val InternalControlArea: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[CurrentEmergencyScheduledInterchange]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CurrentEmergencyScheduledInterchange
extends
    Parseable[CurrentEmergencyScheduledInterchange]
{
    val sup = IdentifiedObject.parse _
    val emergencyScheduleMW = parse_element (element ("""CurrentEmergencyScheduledInterchange.emergencyScheduleMW"""))_
    val emergencyScheduleRampTime = parse_element (element ("""CurrentEmergencyScheduledInterchange.emergencyScheduleRampTime"""))_
    val emergencyScheduleStartTime = parse_element (element ("""CurrentEmergencyScheduledInterchange.emergencyScheduleStartTime"""))_
    val InternalControlArea = parse_attribute (attribute ("""CurrentEmergencyScheduledInterchange.InternalControlArea"""))_
    def parse (context: Context): CurrentEmergencyScheduledInterchange =
    {
        CurrentEmergencyScheduledInterchange(
            sup (context),
            toDouble (emergencyScheduleMW (context), context),
            toInteger (emergencyScheduleRampTime (context), context),
            emergencyScheduleStartTime (context),
            InternalControlArea (context)
        )
    }
}

/**
 * Control area current net tie (scheduled interchange) sent to real time dispatch.
 */
case class CurrentScheduledInterchange
(

    override val sup: BasicElement,

    /**
     * Current control area net tie MW (the sum of the tie line flows, i.e the sum of flows into and out of the control area), the current instantaneous scheduled interchange.
     */
    val currentNetTieMW: Double,

    /**
     * Use Emergency Schedule
     * Attribute Usage: Emergency use indicator, false = Emergency Schedular OFF, true = Emergency Schedular ON.
     */
    val useEmergencySchedule: Boolean,

    val InternalControlArea: String
)
extends
    Element
{
    def this () = { this (null, 0.0, false, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[CurrentScheduledInterchange]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CurrentScheduledInterchange
extends
    Parseable[CurrentScheduledInterchange]
{
    val sup = BasicElement.parse _
    val currentNetTieMW = parse_element (element ("""CurrentScheduledInterchange.currentNetTieMW"""))_
    val useEmergencySchedule = parse_element (element ("""CurrentScheduledInterchange.useEmergencySchedule"""))_
    val InternalControlArea = parse_attribute (attribute ("""CurrentScheduledInterchange.InternalControlArea"""))_
    def parse (context: Context): CurrentScheduledInterchange =
    {
        CurrentScheduledInterchange(
            sup (context),
            toDouble (currentNetTieMW (context), context),
            toBoolean (useEmergencySchedule (context), context),
            InternalControlArea (context)
        )
    }
}

/**
 * Curtailing entity must be providing at least one service to the EnergyTransaction.
 * The CurtailmentProfile must be completely contained within the EnergyProfile timeframe for this EnergyTransaction.
 */
case class CurtailmentProfile
(

    override val sup: Profile,

    /**
     * An EnergyTransaction may be curtailed by any of the participating entities.
     */
    val EnergyTransaction: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Profile: Profile = sup.asInstanceOf[Profile]
    override def copy (): Row = { return (clone ().asInstanceOf[CurtailmentProfile]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CurtailmentProfile
extends
    Parseable[CurtailmentProfile]
{
    val sup = Profile.parse _
    val EnergyTransaction = parse_attribute (attribute ("""CurtailmentProfile.EnergyTransaction"""))_
    def parse (context: Context): CurtailmentProfile =
    {
        CurtailmentProfile(
            sup (context),
            EnergyTransaction (context)
        )
    }
}

/**
 * A continuously variable component of a control area's MW net interchange schedule.
 * Dynamic schedules are sent and received by control areas.
 */
case class DynamicSchedule
(

    override val sup: BasicIntervalSchedule,

    /**
     * Dynamic schedule sign reversal required (true/false)
     */
    val dynSchedSignRev: Boolean,

    /**
     * The "active" or "inactive" status of the dynamic schedule
     */
    val dynSchedStatus: String,

    val MktMeasurement: String,

    /**
     * A control area can receive dynamic schedules from other control areas
     */
    val Receive_SubControlArea: String,

    /**
     * A control area can send dynamic schedules to other control areas
     */
    val Send_SubControlArea: String
)
extends
    Element
{
    def this () = { this (null, false, null, null, null, null) }
    def BasicIntervalSchedule: BasicIntervalSchedule = sup.asInstanceOf[BasicIntervalSchedule]
    override def copy (): Row = { return (clone ().asInstanceOf[DynamicSchedule]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DynamicSchedule
extends
    Parseable[DynamicSchedule]
{
    val sup = BasicIntervalSchedule.parse _
    val dynSchedSignRev = parse_element (element ("""DynamicSchedule.dynSchedSignRev"""))_
    val dynSchedStatus = parse_element (element ("""DynamicSchedule.dynSchedStatus"""))_
    val MktMeasurement = parse_attribute (attribute ("""DynamicSchedule.MktMeasurement"""))_
    val Receive_SubControlArea = parse_attribute (attribute ("""DynamicSchedule.Receive_SubControlArea"""))_
    val Send_SubControlArea = parse_attribute (attribute ("""DynamicSchedule.Send_SubControlArea"""))_
    def parse (context: Context): DynamicSchedule =
    {
        DynamicSchedule(
            sup (context),
            toBoolean (dynSchedSignRev (context), context),
            dynSchedStatus (context),
            MktMeasurement (context),
            Receive_SubControlArea (context),
            Send_SubControlArea (context)
        )
    }
}

/**
 * An EnergyProduct is offered commercially as a ContractOrTariff.
 */
case class EnergyProduct
(

    override val sup: Agreement,

    val GenerationProvider: String,

    /**
     * A Marketer may resell an EnergyProduct.
     */
    val ResoldBy_Marketer: List[String],

    /**
     * A Marketer holds title to an EnergyProduct.
     */
    val TitleHeldBy_Marketer: String
)
extends
    Element
{
    def this () = { this (null, null, List(), null) }
    def Agreement: Agreement = sup.asInstanceOf[Agreement]
    override def copy (): Row = { return (clone ().asInstanceOf[EnergyProduct]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EnergyProduct
extends
    Parseable[EnergyProduct]
{
    val sup = Agreement.parse _
    val GenerationProvider = parse_attribute (attribute ("""EnergyProduct.GenerationProvider"""))_
    val ResoldBy_Marketer = parse_attributes (attribute ("""EnergyProduct.ResoldBy_Marketer"""))_
    val TitleHeldBy_Marketer = parse_attribute (attribute ("""EnergyProduct.TitleHeldBy_Marketer"""))_
    def parse (context: Context): EnergyProduct =
    {
        EnergyProduct(
            sup (context),
            GenerationProvider (context),
            ResoldBy_Marketer (context),
            TitleHeldBy_Marketer (context)
        )
    }
}

/**
 * An account for tracking inadvertent interchange versus time for each control area.
 * A control area may have more than one inadvertent account in order to track inadvertent over one or more specific tie points in addition to the usual overall net inadvertent. Separate accounts would also be used to track designated time periods, such as on-peak and off-peak.
 */
case class InadvertentAccount
(

    override val sup: BasicElement,

    /**
     * A control area can have one or more net inadvertent interchange accounts
     */
    val SubControlArea: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[InadvertentAccount]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object InadvertentAccount
extends
    Parseable[InadvertentAccount]
{
    val sup = BasicElement.parse _
    val SubControlArea = parse_attribute (attribute ("""InadvertentAccount.SubControlArea"""))_
    def parse (context: Context): InadvertentAccount =
    {
        InadvertentAccount(
            sup (context),
            SubControlArea (context)
        )
    }
}

/**
 * There is one internal control area in the system, which is the single control area in the primary network company.
 * Real time generation control affects only the internal control area.
 */
case class InternalControlArea
(

    override val sup: IdentifiedObject,

    val CurrentScheduledInterchange: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[InternalControlArea]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object InternalControlArea
extends
    Parseable[InternalControlArea]
{
    val sup = IdentifiedObject.parse _
    val CurrentScheduledInterchange = parse_attribute (attribute ("""InternalControlArea.CurrentScheduledInterchange"""))_
    def parse (context: Context): InternalControlArea =
    {
        InternalControlArea(
            sup (context),
            CurrentScheduledInterchange (context)
        )
    }
}

/**
 * LossProfile is associated with an EnerrgyTransaction and must be completely contained within the time frame of the EnergyProfile associated with this EnergyTransaction.
 */
case class LossProfile
(

    override val sup: Profile,

    /**
     * An EnergyTransaction may have a LossProfile.
     */
    val EnergyTransaction: String,

    /**
     * Part of the LossProfile for an EnergyTransaction may be a loss for a TransmissionProvider.
     * If so, the TransmissionProvider must be one of the participating entities in the EnergyTransaction.
     */
    val HasLoss_1: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Profile: Profile = sup.asInstanceOf[Profile]
    override def copy (): Row = { return (clone ().asInstanceOf[LossProfile]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object LossProfile
extends
    Parseable[LossProfile]
{
    val sup = Profile.parse _
    val EnergyTransaction = parse_attribute (attribute ("""LossProfile.EnergyTransaction"""))_
    val HasLoss_1 = parse_attribute (attribute ("""LossProfile.HasLoss_"""))_
    def parse (context: Context): LossProfile =
    {
        LossProfile(
            sup (context),
            EnergyTransaction (context),
            HasLoss_1 (context)
        )
    }
}

case class TieLine
(

    override val sup: IdentifiedObject,

    /**
     * A dynamic energy transaction can act as a pseudo tie line.
     */
    val EnergyTransaction: String,

    /**
     * A CustomerConsumer may ring its perimeter with metering, which can create a unique SubControlArea at the collection of metering points, called a TieLine.
     */
    val ParentOfB: String,

    /**
     * The SubControlArea is on the A side of a collection of metered points which define the SubControlArea's boundary for a ControlAreaOperator or CustomerConsumer.
     */
    val SideA_SubControlArea: String,

    /**
     * The SubControlArea is on the B side of a collection of metered points which define the SubControlArea's boundary for a ControlAreaOperator or CustomerConsumer.
     */
    val SideB_SubControlArea: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[TieLine]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TieLine
extends
    Parseable[TieLine]
{
    val sup = IdentifiedObject.parse _
    val EnergyTransaction = parse_attribute (attribute ("""TieLine.EnergyTransaction"""))_
    val ParentOfB = parse_attribute (attribute ("""TieLine.ParentOfB"""))_
    val SideA_SubControlArea = parse_attribute (attribute ("""TieLine.SideA_SubControlArea"""))_
    val SideB_SubControlArea = parse_attribute (attribute ("""TieLine.SideB_SubControlArea"""))_
    def parse (context: Context): TieLine =
    {
        TieLine(
            sup (context),
            EnergyTransaction (context),
            ParentOfB (context),
            SideA_SubControlArea (context),
            SideB_SubControlArea (context)
        )
    }
}

/**
 * A corridor containing one or more rights of way
 */
case class TransmissionCorridor
(

    override val sup: PowerSystemResource
)
extends
    Element
{
    def this () = { this (null) }
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { return (clone ().asInstanceOf[TransmissionCorridor]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TransmissionCorridor
extends
    Parseable[TransmissionCorridor]
{
    val sup = PowerSystemResource.parse _
    def parse (context: Context): TransmissionCorridor =
    {
        TransmissionCorridor(
            sup (context)
        )
    }
}

/**
 * A collection of transmission lines that are close proximity to each other.
 */
case class TransmissionRightOfWay
(

    override val sup: PowerSystemResource,

    /**
     * A transmission right-of-way is a member of a transmission corridor
     */
    val TransmissionCorridor: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { return (clone ().asInstanceOf[TransmissionRightOfWay]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TransmissionRightOfWay
extends
    Parseable[TransmissionRightOfWay]
{
    val sup = PowerSystemResource.parse _
    val TransmissionCorridor = parse_attribute (attribute ("""TransmissionRightOfWay.TransmissionCorridor"""))_
    def parse (context: Context): TransmissionRightOfWay =
    {
        TransmissionRightOfWay(
            sup (context),
            TransmissionCorridor (context)
        )
    }
}

object _InfEnergyScheduling
{
    def register: Unit =
    {
        AreaReserveSpec.register
        CurrentEmergencyScheduledInterchange.register
        CurrentScheduledInterchange.register
        CurtailmentProfile.register
        DynamicSchedule.register
        EnergyProduct.register
        InadvertentAccount.register
        InternalControlArea.register
        LossProfile.register
        TieLine.register
        TransmissionCorridor.register
        TransmissionRightOfWay.register
    }
}