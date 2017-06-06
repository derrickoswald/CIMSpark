package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/*
 * Package: Metering
 */

case class BaseReading
(
    override val sup: MeasurementValue,
    val reportedDateTime: String,
    val source: String,
    val value: String,
    val timePeriod: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def MeasurementValue: MeasurementValue = sup.asInstanceOf[MeasurementValue]
    override def copy (): Row = { return (clone ().asInstanceOf[BaseReading]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BaseReading
extends
    Parseable[BaseReading]
{
    val reportedDateTime = parse_element (element ("""BaseReading.reportedDateTime"""))_
    val source = parse_element (element ("""BaseReading.source"""))_
    val value = parse_element (element ("""BaseReading.value"""))_
    val timePeriod = parse_attribute (attribute ("""BaseReading.timePeriod"""))_
    def parse (context: Context): BaseReading =
    {
        return (
            BaseReading
            (
                MeasurementValue.parse (context),
                reportedDateTime (context),
                source (context),
                value (context),
                timePeriod (context)
            )
        )
    }
}

case class Channel
(
    override val sup: IdentifiedObject,
    val isVirtual: Boolean,
    val ReadingType: String,
    val Register: String
)
extends
    Element
{
    def this () = { this (null, false, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Channel]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Channel
extends
    Parseable[Channel]
{
    val isVirtual = parse_element (element ("""Channel.isVirtual"""))_
    val ReadingType = parse_attribute (attribute ("""Channel.ReadingType"""))_
    val Register = parse_attribute (attribute ("""Channel.Register"""))_
    def parse (context: Context): Channel =
    {
        return (
            Channel
            (
                IdentifiedObject.parse (context),
                toBoolean (isVirtual (context), context),
                ReadingType (context),
                Register (context)
            )
        )
    }
}

case class ComFunction
(
    override val sup: EndDeviceFunction,
    val amrAddress: String,
    val amrRouter: String,
    val direction: String,
    val technology: String,
    val ComModule: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def EndDeviceFunction: EndDeviceFunction = sup.asInstanceOf[EndDeviceFunction]
    override def copy (): Row = { return (clone ().asInstanceOf[ComFunction]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ComFunction
extends
    Parseable[ComFunction]
{
    val amrAddress = parse_element (element ("""ComFunction.amrAddress"""))_
    val amrRouter = parse_element (element ("""ComFunction.amrRouter"""))_
    val direction = parse_attribute (attribute ("""ComFunction.direction"""))_
    val technology = parse_attribute (attribute ("""ComFunction.technology"""))_
    val ComModule = parse_attribute (attribute ("""ComFunction.ComModule"""))_
    def parse (context: Context): ComFunction =
    {
        return (
            ComFunction
            (
                EndDeviceFunction.parse (context),
                amrAddress (context),
                amrRouter (context),
                direction (context),
                technology (context),
                ComModule (context)
            )
        )
    }
}

case class ComModule
(
    override val sup: Asset,
    val amrSystem: String,
    val supportsAutonomousDst: Boolean,
    val timeZoneOffset: Double
)
extends
    Element
{
    def this () = { this (null, null, false, 0.0) }
    def Asset: Asset = sup.asInstanceOf[Asset]
    override def copy (): Row = { return (clone ().asInstanceOf[ComModule]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ComModule
extends
    Parseable[ComModule]
{
    val amrSystem = parse_element (element ("""ComModule.amrSystem"""))_
    val supportsAutonomousDst = parse_element (element ("""ComModule.supportsAutonomousDst"""))_
    val timeZoneOffset = parse_element (element ("""ComModule.timeZoneOffset"""))_
    def parse (context: Context): ComModule =
    {
        return (
            ComModule
            (
                Asset.parse (context),
                amrSystem (context),
                toBoolean (supportsAutonomousDst (context), context),
                toDouble (timeZoneOffset (context), context)
            )
        )
    }
}

case class ControlledAppliance
(
    override val sup: BasicElement,
    val isElectricVehicle: Boolean,
    val isExteriorLighting: Boolean,
    val isGenerationSystem: Boolean,
    val isHvacCompressorOrFurnace: Boolean,
    val isInteriorLighting: Boolean,
    val isIrrigationPump: Boolean,
    val isManagedCommercialIndustrialLoad: Boolean,
    val isPoolPumpSpaJacuzzi: Boolean,
    val isSimpleMiscLoad: Boolean,
    val isSmartAppliance: Boolean,
    val isStripAndBaseboardHeater: Boolean,
    val isWaterHeater: Boolean
)
extends
    Element
{
    def this () = { this (null, false, false, false, false, false, false, false, false, false, false, false, false) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ControlledAppliance]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ControlledAppliance
extends
    Parseable[ControlledAppliance]
{
    val isElectricVehicle = parse_element (element ("""ControlledAppliance.isElectricVehicle"""))_
    val isExteriorLighting = parse_element (element ("""ControlledAppliance.isExteriorLighting"""))_
    val isGenerationSystem = parse_element (element ("""ControlledAppliance.isGenerationSystem"""))_
    val isHvacCompressorOrFurnace = parse_element (element ("""ControlledAppliance.isHvacCompressorOrFurnace"""))_
    val isInteriorLighting = parse_element (element ("""ControlledAppliance.isInteriorLighting"""))_
    val isIrrigationPump = parse_element (element ("""ControlledAppliance.isIrrigationPump"""))_
    val isManagedCommercialIndustrialLoad = parse_element (element ("""ControlledAppliance.isManagedCommercialIndustrialLoad"""))_
    val isPoolPumpSpaJacuzzi = parse_element (element ("""ControlledAppliance.isPoolPumpSpaJacuzzi"""))_
    val isSimpleMiscLoad = parse_element (element ("""ControlledAppliance.isSimpleMiscLoad"""))_
    val isSmartAppliance = parse_element (element ("""ControlledAppliance.isSmartAppliance"""))_
    val isStripAndBaseboardHeater = parse_element (element ("""ControlledAppliance.isStripAndBaseboardHeater"""))_
    val isWaterHeater = parse_element (element ("""ControlledAppliance.isWaterHeater"""))_
    def parse (context: Context): ControlledAppliance =
    {
        return (
            ControlledAppliance
            (
                BasicElement.parse (context),
                toBoolean (isElectricVehicle (context), context),
                toBoolean (isExteriorLighting (context), context),
                toBoolean (isGenerationSystem (context), context),
                toBoolean (isHvacCompressorOrFurnace (context), context),
                toBoolean (isInteriorLighting (context), context),
                toBoolean (isIrrigationPump (context), context),
                toBoolean (isManagedCommercialIndustrialLoad (context), context),
                toBoolean (isPoolPumpSpaJacuzzi (context), context),
                toBoolean (isSimpleMiscLoad (context), context),
                toBoolean (isSmartAppliance (context), context),
                toBoolean (isStripAndBaseboardHeater (context), context),
                toBoolean (isWaterHeater (context), context)
            )
        )
    }
}

case class DemandResponseProgram
(
    override val sup: IdentifiedObject,
    val typ: String, // type
    val validityInterval: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[DemandResponseProgram]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DemandResponseProgram
extends
    Parseable[DemandResponseProgram]
{
    val typ = parse_element (element ("""DemandResponseProgram.typ"""))_
    val validityInterval = parse_attribute (attribute ("""DemandResponseProgram.validityInterval"""))_
    def parse (context: Context): DemandResponseProgram =
    {
        return (
            DemandResponseProgram
            (
                IdentifiedObject.parse (context),
                typ (context),
                validityInterval (context)
            )
        )
    }
}

case class EndDevice
(
    override val sup: AssetContainer,
    val amrSystem: String,
    val installCode: String,
    val isPan: Boolean,
    val isVirtual: Boolean,
    val timeZoneOffset: Double,
    val Customer: String,
    val EndDeviceInfo: String,
    val ServiceLocation: String,
    val UsagePoint: String
)
extends
    Element
{
    def this () = { this (null, null, null, false, false, 0.0, null, null, null, null) }
    def AssetContainer: AssetContainer = sup.asInstanceOf[AssetContainer]
    override def copy (): Row = { return (clone ().asInstanceOf[EndDevice]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EndDevice
extends
    Parseable[EndDevice]
{
    val amrSystem = parse_element (element ("""EndDevice.amrSystem"""))_
    val installCode = parse_element (element ("""EndDevice.installCode"""))_
    val isPan = parse_element (element ("""EndDevice.isPan"""))_
    val isVirtual = parse_element (element ("""EndDevice.isVirtual"""))_
    val timeZoneOffset = parse_element (element ("""EndDevice.timeZoneOffset"""))_
    val Customer = parse_attribute (attribute ("""EndDevice.Customer"""))_
    val EndDeviceInfo = parse_attribute (attribute ("""EndDevice.EndDeviceInfo"""))_
    val ServiceLocation = parse_attribute (attribute ("""EndDevice.ServiceLocation"""))_
    val UsagePoint = parse_attribute (attribute ("""EndDevice.UsagePoint"""))_
    def parse (context: Context): EndDevice =
    {
        return (
            EndDevice
            (
                AssetContainer.parse (context),
                amrSystem (context),
                installCode (context),
                toBoolean (isPan (context), context),
                toBoolean (isVirtual (context), context),
                toDouble (timeZoneOffset (context), context),
                Customer (context),
                EndDeviceInfo (context),
                ServiceLocation (context),
                UsagePoint (context)
            )
        )
    }
}

case class EndDeviceAction
(
    override val sup: BasicElement,
    val command: String,
    val duration: Double,
    val durationIndefinite: Boolean,
    val startDateTime: String,
    val EndDeviceControl: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, false, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[EndDeviceAction]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EndDeviceAction
extends
    Parseable[EndDeviceAction]
{
    val command = parse_element (element ("""EndDeviceAction.command"""))_
    val duration = parse_element (element ("""EndDeviceAction.duration"""))_
    val durationIndefinite = parse_element (element ("""EndDeviceAction.durationIndefinite"""))_
    val startDateTime = parse_element (element ("""EndDeviceAction.startDateTime"""))_
    val EndDeviceControl = parse_attribute (attribute ("""EndDeviceAction.EndDeviceControl"""))_
    def parse (context: Context): EndDeviceAction =
    {
        return (
            EndDeviceAction
            (
                BasicElement.parse (context),
                command (context),
                toDouble (duration (context), context),
                toBoolean (durationIndefinite (context), context),
                startDateTime (context),
                EndDeviceControl (context)
            )
        )
    }
}

case class EndDeviceCapability
(
    override val sup: BasicElement,
    val autonomousDst: Boolean,
    val communication: Boolean,
    val connectDisconnect: Boolean,
    val demandResponse: Boolean,
    val electricMetering: Boolean,
    val gasMetering: Boolean,
    val metrolgy: Boolean,
    val onRequestRead: Boolean,
    val outageHistory: Boolean,
    val pressureCompensation: Boolean,
    val pricingInfo: Boolean,
    val pulseOutput: Boolean,
    val relaysProgramming: Boolean,
    val reverseFlow: Boolean,
    val superCompressibilityCompensation: Boolean,
    val temperatureCompensation: Boolean,
    val textMessage: Boolean,
    val waterMetering: Boolean
)
extends
    Element
{
    def this () = { this (null, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[EndDeviceCapability]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EndDeviceCapability
extends
    Parseable[EndDeviceCapability]
{
    val autonomousDst = parse_element (element ("""EndDeviceCapability.autonomousDst"""))_
    val communication = parse_element (element ("""EndDeviceCapability.communication"""))_
    val connectDisconnect = parse_element (element ("""EndDeviceCapability.connectDisconnect"""))_
    val demandResponse = parse_element (element ("""EndDeviceCapability.demandResponse"""))_
    val electricMetering = parse_element (element ("""EndDeviceCapability.electricMetering"""))_
    val gasMetering = parse_element (element ("""EndDeviceCapability.gasMetering"""))_
    val metrolgy = parse_element (element ("""EndDeviceCapability.metrolgy"""))_
    val onRequestRead = parse_element (element ("""EndDeviceCapability.onRequestRead"""))_
    val outageHistory = parse_element (element ("""EndDeviceCapability.outageHistory"""))_
    val pressureCompensation = parse_element (element ("""EndDeviceCapability.pressureCompensation"""))_
    val pricingInfo = parse_element (element ("""EndDeviceCapability.pricingInfo"""))_
    val pulseOutput = parse_element (element ("""EndDeviceCapability.pulseOutput"""))_
    val relaysProgramming = parse_element (element ("""EndDeviceCapability.relaysProgramming"""))_
    val reverseFlow = parse_element (element ("""EndDeviceCapability.reverseFlow"""))_
    val superCompressibilityCompensation = parse_element (element ("""EndDeviceCapability.superCompressibilityCompensation"""))_
    val temperatureCompensation = parse_element (element ("""EndDeviceCapability.temperatureCompensation"""))_
    val textMessage = parse_element (element ("""EndDeviceCapability.textMessage"""))_
    val waterMetering = parse_element (element ("""EndDeviceCapability.waterMetering"""))_
    def parse (context: Context): EndDeviceCapability =
    {
        return (
            EndDeviceCapability
            (
                BasicElement.parse (context),
                toBoolean (autonomousDst (context), context),
                toBoolean (communication (context), context),
                toBoolean (connectDisconnect (context), context),
                toBoolean (demandResponse (context), context),
                toBoolean (electricMetering (context), context),
                toBoolean (gasMetering (context), context),
                toBoolean (metrolgy (context), context),
                toBoolean (onRequestRead (context), context),
                toBoolean (outageHistory (context), context),
                toBoolean (pressureCompensation (context), context),
                toBoolean (pricingInfo (context), context),
                toBoolean (pulseOutput (context), context),
                toBoolean (relaysProgramming (context), context),
                toBoolean (reverseFlow (context), context),
                toBoolean (superCompressibilityCompensation (context), context),
                toBoolean (temperatureCompensation (context), context),
                toBoolean (textMessage (context), context),
                toBoolean (waterMetering (context), context)
            )
        )
    }
}

case class EndDeviceControl
(
    override val sup: IdentifiedObject,
    val drProgramLevel: Int,
    val drProgramMandatory: Boolean,
    val issuerID: String,
    val issuerTrackingID: String,
    val reason: String,
    val EndDeviceAction: String,
    val EndDeviceControlType: String,
    val priceSignal: Double,
    val primaryDeviceTiming: String,
    val scheduledInterval: String,
    val secondaryDeviceTiming: String
)
extends
    Element
{
    def this () = { this (null, 0, false, null, null, null, null, null, 0.0, null, null, null ) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[EndDeviceControl]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EndDeviceControl
extends
    Parseable[EndDeviceControl]
{
    val drProgramLevel = parse_element (element ("""EndDeviceControl.drProgramLevel"""))_
    val drProgramMandatory = parse_element (element ("""EndDeviceControl.drProgramMandatory"""))_
    val issuerID = parse_element (element ("""EndDeviceControl.issuerID"""))_
    val issuerTrackingID = parse_element (element ("""EndDeviceControl.issuerTrackingID"""))_
    val reason = parse_element (element ("""EndDeviceControl.reason"""))_
    val EndDeviceAction = parse_attribute (attribute ("""EndDeviceControl.EndDeviceAction"""))_
    val EndDeviceControlType = parse_attribute (attribute ("""EndDeviceControl.EndDeviceControlType"""))_
    val priceSignal = parse_attribute (attribute ("""EndDeviceControl.priceSignal"""))_
    val primaryDeviceTiming = parse_attribute (attribute ("""EndDeviceControl.primaryDeviceTiming"""))_
    val scheduledInterval = parse_attribute (attribute ("""EndDeviceControl.scheduledInterval"""))_
    val secondaryDeviceTiming = parse_attribute (attribute ("""EndDeviceControl.secondaryDeviceTiming"""))_
    def parse (context: Context): EndDeviceControl =
    {
        return (
            EndDeviceControl
            (
                IdentifiedObject.parse (context),
                toInteger (drProgramLevel (context), context),
                toBoolean (drProgramMandatory (context), context),
                issuerID (context),
                issuerTrackingID (context),
                reason (context),
                EndDeviceAction (context),
                EndDeviceControlType (context),
                toDouble (priceSignal (context), context),
                primaryDeviceTiming (context),
                scheduledInterval (context),
                secondaryDeviceTiming (context)
            )
        )
    }
}

case class EndDeviceControlType
(
    override val sup: IdentifiedObject,
    val domain: String,
    val eventOrAction: String,
    val subDomain: String,
    val typ: String  // type
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[EndDeviceControlType]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EndDeviceControlType
extends
    Parseable[EndDeviceControlType]
{
    val domain = parse_element (element ("""EndDeviceControlType.domain"""))_
    val eventOrAction = parse_element (element ("""EndDeviceControlType.eventOrAction"""))_
    val subDomain = parse_element (element ("""EndDeviceControlType.subDomain"""))_
    val typ = parse_element (element ("""EndDeviceControlType.typ"""))_
    def parse (context: Context): EndDeviceControlType =
    {
        return (
            EndDeviceControlType
            (
                IdentifiedObject.parse (context),
                domain (context),
                eventOrAction (context),
                subDomain (context),
                typ (context)
            )
        )
    }
}

case class EndDeviceEvent
(
    override val sup: ActivityRecord,
    val issuerID: String,
    val issuerTrackingID: String,
    val userID: String,
    val EndDevice: String,
    val EndDeviceEventType: String,
    val MeterReading: String,
    val UsagePoint: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null) }
    def ActivityRecord: ActivityRecord = sup.asInstanceOf[ActivityRecord]
    override def copy (): Row = { return (clone ().asInstanceOf[EndDeviceEvent]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EndDeviceEvent
extends
    Parseable[EndDeviceEvent]
{
    val issuerID = parse_element (element ("""EndDeviceEvent.issuerID"""))_
    val issuerTrackingID = parse_element (element ("""EndDeviceEvent.issuerTrackingID"""))_
    val userID = parse_element (element ("""EndDeviceEvent.userID"""))_
    val EndDevice = parse_attribute (attribute ("""EndDeviceEvent.EndDevice"""))_
    val EndDeviceEventType = parse_attribute (attribute ("""EndDeviceEvent.EndDeviceEventType"""))_
    val MeterReading = parse_attribute (attribute ("""EndDeviceEvent.MeterReading"""))_
    val UsagePoint = parse_attribute (attribute ("""EndDeviceEvent.UsagePoint"""))_
    def parse (context: Context): EndDeviceEvent =
    {
        return (
            EndDeviceEvent
            (
                ActivityRecord.parse (context),
                issuerID (context),
                issuerTrackingID (context),
                userID (context),
                EndDevice (context),
                EndDeviceEventType (context),
                MeterReading (context),
                UsagePoint (context)
            )
        )
    }
}

case class EndDeviceEventDetail
(
    override val sup: BasicElement,
    val name: String,
    val EndDeviceEvent: String,
    val value: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[EndDeviceEventDetail]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EndDeviceEventDetail
extends
    Parseable[EndDeviceEventDetail]
{
    val name = parse_element (element ("""EndDeviceEventDetail.name"""))_
    val EndDeviceEvent = parse_attribute (attribute ("""EndDeviceEventDetail.EndDeviceEvent"""))_
    val value = parse_attribute (attribute ("""EndDeviceEventDetail.value"""))_
    def parse (context: Context): EndDeviceEventDetail =
    {
        return (
            EndDeviceEventDetail
            (
                BasicElement.parse (context),
                name (context),
                EndDeviceEvent (context),
                value (context)
            )
        )
    }
}

case class EndDeviceEventType
(
    override val sup: IdentifiedObject,
    val domain: String,
    val eventOrAction: String,
    val subDomain: String,
    val typ: String  // type
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[EndDeviceEventType]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EndDeviceEventType
extends
    Parseable[EndDeviceEventType]
{
    val domain = parse_element (element ("""EndDeviceEventType.domain"""))_
    val eventOrAction = parse_element (element ("""EndDeviceEventType.eventOrAction"""))_
    val subDomain = parse_element (element ("""EndDeviceEventType.subDomain"""))_
    val typ = parse_element (element ("""EndDeviceEventType.typ"""))_
    def parse (context: Context): EndDeviceEventType =
    {
        return (
            EndDeviceEventType
            (
                IdentifiedObject.parse (context),
                domain (context),
                eventOrAction (context),
                subDomain (context),
                typ (context)
            )
        )
    }
}

case class EndDeviceFunction
(
    override val sup: AssetFunction,
    val enabled: Boolean,
    val EndDevice: String
)
extends
    Element
{
    def this () = { this (null, false, null) }
    def AssetFunction: AssetFunction = sup.asInstanceOf[AssetFunction]
    override def copy (): Row = { return (clone ().asInstanceOf[EndDeviceFunction]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EndDeviceFunction
extends
    Parseable[EndDeviceFunction]
{
    val enabled = parse_element (element ("""EndDeviceFunction.enabled"""))_
    val EndDevice = parse_attribute (attribute ("""EndDeviceFunction.EndDevice"""))_
    def parse (context: Context): EndDeviceFunction =
    {
        return (
            EndDeviceFunction
            (
                AssetFunction.parse (context),
                toBoolean (enabled (context), context),
                EndDevice (context)
            )
        )
    }
}

case class EndDeviceGroup
(
    override val sup: IdentifiedObject,
    val typ: String  // type
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[EndDeviceGroup]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EndDeviceGroup
extends
    Parseable[EndDeviceGroup]
{
    val typ = parse_element (element ("""EndDeviceGroup.typ"""))_
    def parse (context: Context): EndDeviceGroup =
    {
        return (
            EndDeviceGroup
            (
                IdentifiedObject.parse (context),
                typ (context)
            )
        )
    }
}

case class EndDeviceInfo
(
    override val sup: AssetInfo,
    val isSolidState: Boolean,
    val phaseCount: Int,
    val ratedCurrent: Double,
    val ratedVoltage: Double,
    val capability: String    
)
extends
    Element
{
    def this () = { this (null, false, 0, 0.0, 0.0, null) }
    def AssetInfo: AssetInfo = sup.asInstanceOf[AssetInfo]
    override def copy (): Row = { return (clone ().asInstanceOf[EndDeviceInfo]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EndDeviceInfo
extends
    Parseable[EndDeviceInfo]
{
    val isSolidState = parse_element (element ("""EndDeviceInfo.isSolidState"""))_
    val phaseCount = parse_element (element ("""EndDeviceInfo.phaseCount"""))_
    val ratedCurrent = parse_element (element ("""EndDeviceInfo.ratedCurrent"""))_
    val ratedVoltage = parse_element (element ("""EndDeviceInfo.ratedVoltage"""))_
    val capability = parse_attribute (attribute ("""EndDeviceInfo.capability"""))_
    def parse (context: Context): EndDeviceInfo =
    {
        return (
            EndDeviceInfo
            (
                AssetInfo.parse (context),
                toBoolean (isSolidState (context), context),
                toInteger (phaseCount (context), context),
                toDouble (ratedCurrent (context), context),
                toDouble (ratedVoltage (context), context),
                capability (context)
            )
        )
    }
}

case class EndDeviceTiming
(
    override val sup: BasicElement,
    val duration: Double,
    val durationIndefinite: Boolean,
    val randomisation: String,
    val interval: String
)
extends
    Element
{
    def this () = { this (null, 0.0, false, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[EndDeviceTiming]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EndDeviceTiming
extends
    Parseable[EndDeviceTiming]
{
    val duration = parse_element (element ("""EndDeviceTiming.duration"""))_
    val durationIndefinite = parse_element (element ("""EndDeviceTiming.durationIndefinite"""))_
    val randomisation = parse_attribute (attribute ("""EndDeviceTiming.randomisation"""))_
    val interval = parse_attribute (attribute ("""EndDeviceTiming.interval"""))_
    def parse (context: Context): EndDeviceTiming =
    {
        return (
            EndDeviceTiming
            (
                BasicElement.parse (context),
                toDouble (duration (context), context),
                toBoolean (durationIndefinite (context), context),
                randomisation (context),
                interval (context)
            )
        )
    }
}

case class IntervalBlock
(
    override val sup: BasicElement,
    val MeterReading: String,
    val PendingCalculation: String,
    val ReadingType: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[IntervalBlock]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object IntervalBlock
extends
    Parseable[IntervalBlock]
{
    val MeterReading = parse_attribute (attribute ("""IntervalBlock.ReadingType"""))_
    val PendingCalculation = parse_attribute (attribute ("""IntervalBlock.ReadingType"""))_
    val ReadingType = parse_attribute (attribute ("""IntervalBlock.ReadingType"""))_
    def parse (context: Context): IntervalBlock =
    {
        return (
            IntervalBlock
            (
                BasicElement.parse (context),
                MeterReading (context),
                PendingCalculation (context),
                ReadingType (context)
            )
        )
    }
}

case class IntervalReading
(
    override val sup: BaseReading
)
extends
    Element
{
    def this () = { this (null) }
    def BaseReading: BaseReading = sup.asInstanceOf[BaseReading]
    override def copy (): Row = { return (clone ().asInstanceOf[IntervalReading]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object IntervalReading
extends
    Parseable[IntervalReading]
{
    def parse (context: Context): IntervalReading =
    {
        return (
            IntervalReading
            (
                BaseReading.parse (context)
            )
        )
    }
}

case class Meter
(
    override val sup: EndDevice,
    val formNumber: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def EndDevice: EndDevice = sup.asInstanceOf[EndDevice]
    override def copy (): Row = { return (clone ().asInstanceOf[Meter]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Meter
extends
    Parseable[Meter]
{
    val formNumber = parse_element (element ("""Meter.formNumber"""))_
    def parse (context: Context): Meter =
    {
        return (
            Meter
            (
                EndDevice.parse (context),
                formNumber (context)
            )
        )
    }
}

case class MeterMultiplier
(
    override val sup: IdentifiedObject,
    val kind: String,
    val value: Double,
    val Meter: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[MeterMultiplier]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MeterMultiplier
extends
    Parseable[MeterMultiplier]
{
    val kind = parse_attribute (attribute ("""MeterMultiplier.kind"""))_
    val value = parse_element (element ("""MeterMultiplier.value"""))_
    val Meter = parse_attribute (attribute ("""MeterMultiplier.Meter"""))_
    def parse (context: Context): MeterMultiplier =
    {
        return (
            MeterMultiplier
            (
                IdentifiedObject.parse (context),
                kind (context),
                toDouble (value (context), context),
                Meter (context)
            )
        )
    }
}

case class MeterReading
(
    override val sup: IdentifiedObject,
    val isCoincidentTrigger: Boolean,
    val CustomerAgreement: String,
    val Meter: String,
    val UsagePoint: String,
    val valuesInterval: String
)
extends
    Element
{
    def this () = { this (null, false, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[MeterReading]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MeterReading
extends
    Parseable[MeterReading]
{
    val isCoincidentTrigger = parse_element (element ("""MeterReading.isCoincidentTrigger"""))_
    val CustomerAgreement = parse_attribute (attribute ("""MeterReading.CustomerAgreement"""))_
    val Meter = parse_attribute (attribute ("""MeterReading.Meter"""))_
    val UsagePoint = parse_attribute (attribute ("""MeterReading.UsagePoint"""))_
    val valuesInterval = parse_attribute (attribute ("""MeterReading.valuesInterval"""))_
    def parse (context: Context): MeterReading =
    {
        return (
            MeterReading
            (
                IdentifiedObject.parse (context),
                toBoolean (isCoincidentTrigger (context), context),
                CustomerAgreement (context),
                Meter (context),
                UsagePoint (context),
                valuesInterval (context)
            )
        )
    }
}

case class MeterServiceWork
(
    override val sup: Work,
    val Meter: String,
    val OldMeter: String,
    val UsagePoint: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Work: Work = sup.asInstanceOf[Work]
    override def copy (): Row = { return (clone ().asInstanceOf[MeterServiceWork]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MeterServiceWork
extends
    Parseable[MeterServiceWork]
{
    val Meter = parse_attribute (attribute ("""MeterServiceWork.Meter"""))_
    val OldMeter = parse_attribute (attribute ("""MeterServiceWork.OldMeter"""))_
    val UsagePoint = parse_attribute (attribute ("""MeterServiceWork.UsagePoint"""))_
    def parse (context: Context): MeterServiceWork =
    {
        return (
            MeterServiceWork
            (
                Work.parse (context),
                Meter (context),
                OldMeter (context),
                UsagePoint (context)
            )
        )
    }
}

case class MetrologyRequirement
(
    override val sup: IdentifiedObject,
    val reason: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[MetrologyRequirement]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MetrologyRequirement
extends
    Parseable[MetrologyRequirement]
{
    val reason = parse_attribute (attribute ("""MetrologyRequirement.reason"""))_
    def parse (context: Context): MetrologyRequirement =
    {
        return (
            MetrologyRequirement
            (
                IdentifiedObject.parse (context),
                reason (context)
            )
        )
    }
}

case class PanDemandResponse
(
    override val sup: EndDeviceAction,
    val avgLoadAdjustment: Double,
    val cancelControlMode: String,
    val cancelDateTime: String,
    val cancelNow: Boolean,
    val coolingOffset: Double,
    val coolingSetpoint: Double,
    val criticalityLevel: String,
    val dutyCycle: Double,
    val enrollmentGroup: String,
    val heatingOffset: Double,
    val heatingSetpoint: Double,
    val appliance: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null, false, 0.0, 0.0, null, 0.0, null, 0.0, 0.0, null) }
    def EndDeviceAction: EndDeviceAction = sup.asInstanceOf[EndDeviceAction]
    override def copy (): Row = { return (clone ().asInstanceOf[PanDemandResponse]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PanDemandResponse
extends
    Parseable[PanDemandResponse]
{
    val avgLoadAdjustment = parse_element (element ("""PanDemandResponse.avgLoadAdjustment"""))_
    val cancelControlMode = parse_element (element ("""PanDemandResponse.cancelControlMode"""))_
    val cancelDateTime = parse_element (element ("""PanDemandResponse.cancelDateTime"""))_
    val cancelNow = parse_element (element ("""PanDemandResponse.cancelNow"""))_
    val coolingOffset = parse_element (element ("""PanDemandResponse.coolingOffset"""))_
    val coolingSetpoint = parse_element (element ("""PanDemandResponse.coolingSetpoint"""))_
    val criticalityLevel = parse_element (element ("""PanDemandResponse.criticalityLevel"""))_
    val dutyCycle = parse_element (element ("""PanDemandResponse.dutyCycle"""))_
    val enrollmentGroup = parse_element (element ("""PanDemandResponse.enrollmentGroup"""))_
    val heatingOffset = parse_element (element ("""PanDemandResponse.heatingOffset"""))_
    val heatingSetpoint = parse_element (element ("""PanDemandResponse.heatingSetpoint"""))_
    val appliance = parse_attribute (attribute ("""PanDemandResponse.appliance"""))_
    def parse (context: Context): PanDemandResponse =
    {
        return (
            PanDemandResponse
            (
                EndDeviceAction.parse (context),
                toDouble (avgLoadAdjustment (context), context),
                cancelControlMode (context),
                cancelDateTime (context),
                toBoolean (cancelNow (context), context),
                toDouble (coolingOffset (context), context),
                toDouble (coolingSetpoint (context), context),
                criticalityLevel (context),
                toDouble (dutyCycle (context), context),
                enrollmentGroup (context),
                toDouble (heatingOffset (context), context),
                toDouble (heatingSetpoint (context), context),
                appliance (context)
            )
        )
    }
}

case class PanDisplay
(
    override val sup: EndDeviceAction,
    val confirmationRequired: Boolean,
    val priority: String,
    val textMessage: String,
    val transmissionMode: String
)
extends
    Element
{
    def this () = { this (null, false, null, null, null) }
    def EndDeviceAction: EndDeviceAction = sup.asInstanceOf[EndDeviceAction]
    override def copy (): Row = { return (clone ().asInstanceOf[PanDisplay]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PanDisplay
extends
    Parseable[PanDisplay]
{
    val confirmationRequired = parse_element (element ("""PanDisplay.confirmationRequired"""))_
    val priority = parse_element (element ("""PanDisplay.priority"""))_
    val textMessage = parse_element (element ("""PanDisplay.textMessage"""))_
    val transmissionMode = parse_attribute (attribute ("""PanDisplay.transmissionMode"""))_
    def parse (context: Context): PanDisplay =
    {
        return (
            PanDisplay
            (
                EndDeviceAction.parse (context),
                toBoolean (confirmationRequired (context), context),
                priority (context),
                textMessage (context),
                transmissionMode (context)
            )
        )
    }
}

case class PanPricing
(
    override val sup: EndDeviceAction,
    val providerID: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def EndDeviceAction: EndDeviceAction = sup.asInstanceOf[EndDeviceAction]
    override def copy (): Row = { return (clone ().asInstanceOf[PanPricing]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PanPricing
extends
    Parseable[PanPricing]
{
    val providerID = parse_element (element ("""PanPricing.providerID"""))_
    def parse (context: Context): PanPricing =
    {
        return (
            PanPricing
            (
                EndDeviceAction.parse (context),
                providerID (context)
            )
        )
    }
}

case class PanPricingDetail
(
    override val sup: BasicElement,
    val alternateCostDelivered: Double,
    val alternateCostUnit: String,
    val currentTimeDate: String,
    val generationPrice: String,
    val generationPriceRatio: Double,
    val price: String,
    val priceRatio: Double,
    val priceTier: Int,
    val priceTierCount: Int,
    val priceTierLabel: String,
    val rateLabel: String,
    val registerTier: String,
    val unitOfMeasure: String,
    val PanPricing: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null, null, 0.0, null, 0.0, 0, 0, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[PanPricingDetail]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PanPricingDetail
extends
    Parseable[PanPricingDetail]
{
    val alternateCostDelivered = parse_element (element ("""PanPricingDetail.alternateCostDelivered"""))_
    val alternateCostUnit = parse_element (element ("""PanPricingDetail.alternateCostUnit"""))_
    val currentTimeDate = parse_element (element ("""PanPricingDetail.currentTimeDate"""))_
    val generationPrice = parse_element (element ("""PanPricingDetail.generationPrice"""))_
    val generationPriceRatio = parse_element (element ("""PanPricingDetail.generationPriceRatio"""))_    
    val price = parse_element (element ("""PanPricingDetail.price"""))_
    val priceRatio = parse_element (element ("""PanPricingDetail.priceRatio"""))_
    val priceTier = parse_element (element ("""PanPricingDetail.priceTier"""))_
    val priceTierCount = parse_element (element ("""PanPricingDetail.priceTierCount"""))_
    val priceTierLabel = parse_element (element ("""PanPricingDetail.priceTierLabel"""))_
    val rateLabel = parse_element (element ("""PanPricingDetail.rateLabel"""))_
    val registerTier = parse_element (element ("""PanPricingDetail.registerTier"""))_
    val unitOfMeasure = parse_element (element ("""PanPricingDetail.unitOfMeasure"""))_
    val PanPricing = parse_attribute (attribute ("""PanPricingDetail.PanPricing"""))_
    def parse (context: Context): PanPricingDetail =
    {
        return (
            PanPricingDetail
            (
                BasicElement.parse (context),
                toDouble (alternateCostDelivered (context), context),
                alternateCostUnit (context),
                currentTimeDate (context),
                generationPrice (context),
                toDouble (generationPriceRatio (context), context),
                price (context),
                toDouble (priceRatio (context), context),
                toInteger (priceTier (context), context),
                toInteger (priceTierCount (context), context),
                priceTierLabel (context),
                rateLabel (context),
                registerTier (context),
                unitOfMeasure (context),
                PanPricing (context)
            )
        )
    }
}

case class PendingCalculation
(
    override val sup: BasicElement,
    val multiplyBeforeAdd: Boolean,
    val offset: Int,
    val scalarDenominator: Int,
    val scalarFloat: Double,
    val scalarNumerator: Int,
    val ReadingType: String
)
extends
    Element
{
    def this () = { this (null, false, 0, 0, 0.0, 0, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[PendingCalculation]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PendingCalculation
extends
    Parseable[PendingCalculation]
{
    val multiplyBeforeAdd = parse_element (element ("""PendingCalculation.multiplyBeforeAdd"""))_
    val offset = parse_element (element ("""PendingCalculation.offset"""))_
    val scalarDenominator = parse_element (element ("""PendingCalculation.scalarDenominator"""))_
    val scalarFloat = parse_element (element ("""PendingCalculation.scalarFloat"""))_
    val scalarNumerator = parse_element (element ("""PendingCalculation.scalarNumerator"""))_
    val ReadingType = parse_attribute (attribute ("""PendingCalculation.ReadingType"""))_
    def parse (context: Context): PendingCalculation =
    {
        return (
            PendingCalculation
            (
                BasicElement.parse (context),
                toBoolean (multiplyBeforeAdd (context), context),
                toInteger (offset (context), context),
                toInteger (scalarDenominator (context), context),
                toDouble (scalarFloat (context), context),
                toInteger (scalarNumerator (context), context),
                ReadingType (context)
            )
        )
    }
}

case class RationalNumber
(
    override val sup: BasicElement,
    val denominator: Int,
    val numerator: Int
)
extends
    Element
{
    def this () = { this (null, 0, 0) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[RationalNumber]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RationalNumber
extends
    Parseable[RationalNumber]
{
    val denominator = parse_element (element ("""RationalNumber.denominator"""))_
    val numerator = parse_element (element ("""RationalNumber.numerator"""))_
    def parse (context: Context): RationalNumber =
    {
        return (
            RationalNumber
            (
                BasicElement.parse (context),
                toInteger (denominator (context), context),
                toInteger (numerator (context), context)
            )
        )
    }
}

case class Reading
(
    override val sup: BaseReading,
    val reason: String,
    val ReadingType: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def BaseReading: BaseReading = sup.asInstanceOf[BaseReading]
    override def copy (): Row = { return (clone ().asInstanceOf[Reading]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Reading
extends
    Parseable[Reading]
{
    val reason = parse_attribute (attribute ("""Reading.reason"""))_
    val ReadingType = parse_attribute (attribute ("""Reading.ReadingType"""))_
    def parse (context: Context): Reading =
    {
        return (
            Reading
            (
                BaseReading.parse (context),
                reason (context),
                ReadingType (context)
            )
        )
    }
}

case class ReadingInterharmonic
(
    override val sup: BasicElement,
    val denominator: Int,
    val numerator: Int
)
extends
    Element
{
    def this () = { this (null, 0, 0) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ReadingInterharmonic]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ReadingInterharmonic
extends
    Parseable[ReadingInterharmonic]
{
    val denominator = parse_element (element ("""ReadingInterharmonic.denominator"""))_
    val numerator = parse_element (element ("""ReadingInterharmonic.numerator"""))_
    def parse (context: Context): ReadingInterharmonic =
    {
        return (
            ReadingInterharmonic
            (
                BasicElement.parse (context),
                toInteger (denominator (context), context),
                toInteger (numerator (context), context)
            )
        )
    }
}

case class ReadingQuality
(
    override val sup: BasicElement,
    val comment: String,
    val source: String,
    val timeStamp: String,  // dateTime
    val Reading: String,
    val ReadingQualityType: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ReadingQuality]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ReadingQuality
extends
    Parseable[ReadingQuality]
{
    val comment = parse_element (element ("""ReadingQuality.comment"""))_
    val source = parse_element (element ("""ReadingQuality.source"""))_
    val timeStamp = parse_element (element ("""ReadingQuality.timeStamp"""))_
    val Reading = parse_attribute (attribute ("""ReadingQuality.Reading"""))_
    val ReadingQualityType = parse_attribute (attribute ("""ReadingQuality.ReadingQualityType"""))_
    def parse (context: Context): ReadingQuality =
    {
        return (
            ReadingQuality
            (
                BasicElement.parse (context),
                comment (context),
                source (context),
                timeStamp (context),
                Reading (context),
                ReadingQualityType (context)
            )
        )
    }
}

case class ReadingQualityType
(
    override val sup: IdentifiedObject,
    val category: String,
    val subCategory: String,
    val systemId: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ReadingQualityType]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ReadingQualityType
extends
    Parseable[ReadingQualityType]
{
    val category = parse_element (element ("""ReadingQualityType.category"""))_
    val subCategory = parse_element (element ("""ReadingQualityType.subCategory"""))_
    val systemId = parse_element (element ("""ReadingQualityType.systemId"""))_
    def parse (context: Context): ReadingQualityType =
    {
        return (
            ReadingQualityType
            (
                IdentifiedObject.parse (context),
                category (context),
                subCategory (context),
                systemId (context)
            )
        )
    }
}

case class ReadingType
(
    override val sup: IdentifiedObject,
    val accumulation: String,
    val aggregate: String,
    val commodity: String,
    val consumptionTier: Int,
    val cpp: Int,
    val currency: String,
    val flowDirection: String,
    val macroPeriod: String,
    val measurementKind: String,
    val measuringPeriod: String,
    val multiplier: String,
    val phases: String,
    val tou: Int,
    val unit: String,
    val Channel: String,
    val PendingCalculation: String,
    val argument: String,  // RationalNumber
    val interharmonic: String  // ReadingInterharmonic
    
)
extends
    Element
{
    def this () = { this (null, null, null, null, 0, 0, null, null, null, null, null, null, null, 0, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ReadingType]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ReadingType
extends
    Parseable[ReadingType]
{
    val accumulation = parse_element (element ("""ReadingType.accumulation"""))_
    val aggregate = parse_element (element ("""ReadingType.aggregate"""))_
    val commodity = parse_element (element ("""ReadingType.commodity"""))_
    val consumptionTier = parse_element (element ("""ReadingType.consumptionTier"""))_
    val cpp = parse_element (element ("""ReadingType.cpp"""))_
    val currency = parse_element (element ("""ReadingType.currency"""))_
    val flowDirection = parse_element (element ("""ReadingType.flowDirection"""))_
    val macroPeriod = parse_element (element ("""ReadingType.macroPeriod"""))_
    val measurementKind = parse_element (element ("""ReadingType.measurementKind"""))_
    val measuringPeriod = parse_element (element ("""ReadingType.measuringPeriod"""))_
    val multiplier = parse_element (element ("""ReadingType.multiplier"""))_
    val phases = parse_element (element ("""ReadingType.phases"""))_
    val tou = parse_element (element ("""ReadingType.tou"""))_
    val unit = parse_element (element ("""ReadingType.unit"""))_
    val Channel = parse_attribute (attribute ("""ReadingType.Channel"""))_
    val PendingCalculation = parse_attribute (attribute ("""ReadingType.PendingCalculation"""))_
    val argument = parse_attribute (attribute ("""ReadingType.argument"""))_
    val interharmonic = parse_attribute (attribute ("""ReadingType.interharmonic"""))_
    def parse (context: Context): ReadingType =
    {
        return (
            ReadingType
            (
                IdentifiedObject.parse (context),
                accumulation (context),
                aggregate (context),
                commodity (context),
                toInteger (consumptionTier (context), context),
                toInteger (cpp (context), context),
                currency (context),
                flowDirection (context),
                macroPeriod (context),
                measurementKind (context),
                measuringPeriod (context),
                multiplier (context),
                phases (context),
                toInteger (tou (context), context),
                unit (context),
                Channel (context),
                PendingCalculation (context),
                argument (context),
                interharmonic (context)
            )
        )
    }
}

case class Register
(
    override val sup: IdentifiedObject,
    val isVirtual: Boolean,
    val leftDigitCount: Int,
    val rightDigitCount: Int,
    val touTierName: String,
    val EndDeviceFunction: String,
    val touTier: String  // TimeInterval
)
extends
    Element
{
    def this () = { this (null, false, 0, 0, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Register]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Register
extends
    Parseable[Register]
{
    val isVirtual = parse_element (element ("""Register.isVirtual"""))_
    val leftDigitCount = parse_element (element ("""Register.leftDigitCount"""))_
    val rightDigitCount = parse_element (element ("""Register.rightDigitCount"""))_
    val touTierName = parse_element (element ("""Register.touTierName"""))_
    val EndDeviceFunction = parse_attribute (attribute ("""Register.EndDeviceFunction"""))_
    val touTier = parse_attribute (attribute ("""Register.touTier"""))_
    def parse (context: Context): Register =
    {
        return (
            Register
            (
                IdentifiedObject.parse (context),
                toBoolean (isVirtual (context), context),
                toInteger (leftDigitCount (context), context),
                toInteger (rightDigitCount (context), context),
                touTierName (context),
                EndDeviceFunction (context),
                touTier (context)
            )
        )
    }
}

case class ServiceMultiplier
(
    override val sup: IdentifiedObject,
    val kind: String,
    val value: Double,
    val UsagePoint: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ServiceMultiplier]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ServiceMultiplier
extends
    Parseable[ServiceMultiplier]
{
    val kind = parse_attribute (attribute ("""ServiceMultiplier.kind"""))_
    val value = parse_element (element ("""ServiceMultiplier.value"""))_
    val UsagePoint = parse_attribute (attribute ("""ServiceMultiplier.UsagePoint"""))_
    def parse (context: Context): ServiceMultiplier =
    {
        return (
            ServiceMultiplier
            (
                IdentifiedObject.parse (context),
                kind (context),
                toDouble (value (context), context),
                UsagePoint (context)
            )
        )
    }
}

case class SimpleEndDeviceFunction
(
    override val sup: EndDeviceFunction,
    val kind: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def EndDeviceFunction: EndDeviceFunction = sup.asInstanceOf[EndDeviceFunction]
    override def copy (): Row = { return (clone ().asInstanceOf[SimpleEndDeviceFunction]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SimpleEndDeviceFunction
extends
    Parseable[SimpleEndDeviceFunction]
{
    val kind = parse_attribute (attribute ("""SimpleEndDeviceFunction.kind"""))_
    def parse (context: Context): SimpleEndDeviceFunction =
    {
        return (
            SimpleEndDeviceFunction
            (
                EndDeviceFunction.parse (context),
                kind (context)
            )
        )
    }
}

case class UsagePoint
(
    override val sup: IdentifiedObject,
    // val amiBillingReady: String, Implementation restriction: case  classes cannot have more than 22 parameters.
    val checkBilling: Boolean,
    val connectionState: String,
    val estimatedLoad: Double,
    val grounded: Boolean,
    val isSdp: Boolean,
    val isVirtual: Boolean,
    val minimalUsageExpected: Boolean,
    val nominalServiceVoltage: Double,
    val outageRegion: String,
    val phaseCode: String,
    val ratedCurrent: Double,
    val ratedPower: Double,
    val readCycle: String,
    val readRoute: String,
    val serviceDeliveryRemark: String,
    val servicePriority: String,
    val CustomerAgreement: String,
    val ServiceCategory: String,
    val ServiceLocation: String,
    val ServiceSupplier: String,
    val UsagePointLocation: String
)
extends
    Element
{
    def this () = { this (null, false, null, 0.0, false, false, false, false, 0.0, null, null, 0.0, 0.0, null, null, null, null, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[UsagePoint]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object UsagePoint
extends
    Parseable[UsagePoint]
{
    //val amiBillingReady = parse_element (element ("""UsagePoint.amiBillingReady"""))_
    val checkBilling = parse_element (element ("""UsagePoint.checkBilling"""))_
    val connectionState = parse_element (element ("""UsagePoint.connectionState"""))_
    val estimatedLoad = parse_element (element ("""UsagePoint.estimatedLoad"""))_
    val grounded = parse_element (element ("""UsagePoint.grounded"""))_
    val isSdp = parse_element (element ("""UsagePoint.isSdp"""))_
    val isVirtual = parse_element (element ("""UsagePoint.isSdp"""))_
    val minimalUsageExpected = parse_element (element ("""UsagePoint.minimalUsageExpected"""))_
    val nominalServiceVoltage = parse_element (element ("""UsagePoint.nominalServiceVoltage"""))_
    val outageRegion = parse_element (element ("""UsagePoint.outageRegion"""))_
    val phaseCode = parse_element (element ("""UsagePoint.phaseCode"""))_
    val ratedCurrent = parse_element (element ("""UsagePoint.ratedCurrent"""))_
    val ratedPower = parse_element (element ("""UsagePoint.ratedPower"""))_
    val readCycle = parse_element (element ("""UsagePoint.readCycle"""))_
    val readRoute = parse_element (element ("""UsagePoint.readRoute"""))_
    val serviceDeliveryRemark = parse_element (element ("""UsagePoint.serviceDeliveryRemark"""))_
    val servicePriority = parse_element (element ("""UsagePoint.servicePriority"""))_
    val CustomerAgreement = parse_attribute (attribute ("""UsagePoint.CustomerAgreement"""))_
    val ServiceCategory = parse_attribute (attribute ("""UsagePoint.ServiceCategory"""))_
    val ServiceLocation = parse_attribute (attribute ("""UsagePoint.ServiceLocation"""))_
    val ServiceSupplier = parse_attribute (attribute ("""UsagePoint.ServiceSupplier"""))_
    val UsagePointLocation = parse_attribute (attribute ("""UsagePoint.UsagePointLocation"""))_
    def parse (context: Context): UsagePoint =
    {
        return (
            UsagePoint
            (
                IdentifiedObject.parse (context),
                //amiBillingReady (context),
                toBoolean (checkBilling (context), context),
                connectionState (context),
                toDouble (estimatedLoad (context), context),
                toBoolean (grounded (context), context),
                toBoolean (isSdp (context), context),
                toBoolean (isVirtual (context), context),
                toBoolean (minimalUsageExpected (context), context),
                toDouble (nominalServiceVoltage (context), context),
                outageRegion (context),
                phaseCode (context),
                toDouble (ratedCurrent (context), context),
                toDouble (ratedPower (context), context),
                readCycle (context),
                readRoute (context),
                serviceDeliveryRemark (context),
                servicePriority (context),
                CustomerAgreement (context),
                ServiceCategory (context),
                ServiceLocation (context),
                ServiceSupplier (context),
                UsagePointLocation (context)
            )
        )
    }
}

case class UsagePointGroup
(
    override val sup: IdentifiedObject,
    val typ: String  // type
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[UsagePointGroup]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object UsagePointGroup
extends
    Parseable[UsagePointGroup]
{
    val typ = parse_element (element ("""UsagePointGroup.typ"""))_
    def parse (context: Context): UsagePointGroup =
    {
        return (
            UsagePointGroup
            (
                IdentifiedObject.parse (context),
                typ (context)
            )
        )
    }
}

case class UsagePointLocation
(
    override val sup: Location,
    val accessMethod: String,
    val remark: String,
    val siteAccessProblem: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Location: Location = sup.asInstanceOf[Location]
    override def copy (): Row = { return (clone ().asInstanceOf[UsagePointLocation]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object UsagePointLocation
extends
    Parseable[UsagePointLocation]
{
    val accessMethod = parse_element (element ("""UsagePointLocation.accessMethod"""))_
    val remark = parse_element (element ("""UsagePointLocation.remark"""))_
    val siteAccessProblem = parse_element (element ("""UsagePointLocation.siteAccessProblem"""))_
    def parse (context: Context): UsagePointLocation =
    {
        return (
            UsagePointLocation
            (
                Location.parse (context),
                accessMethod (context),
                remark (context),
                siteAccessProblem (context)
            )
        )
    }
}

object Metering
{
    def register: Unit =
    {
        BaseReading.register
        Channel.register
        ComFunction.register
        ComModule.register
        ControlledAppliance.register
        DemandResponseProgram.register
        EndDevice.register
        EndDeviceAction.register
        EndDeviceCapability.register
        EndDeviceControl.register
        EndDeviceControlType.register
        EndDeviceEvent.register
        EndDeviceEventDetail.register
        EndDeviceEventType.register
        EndDeviceFunction.register
        EndDeviceGroup.register
        EndDeviceInfo.register
        EndDeviceTiming.register
        IntervalBlock.register
        IntervalReading.register
        Meter.register
        MeterMultiplier.register
        MeterReading.register
        MeterServiceWork.register
        MetrologyRequirement.register
        PanDemandResponse.register
        PanDisplay.register
        PanPricing.register
        PanPricingDetail.register
        PendingCalculation.register
        RationalNumber.register
        Reading.register
        ReadingInterharmonic.register
        ReadingQuality.register
        ReadingQualityType.register
        ReadingType.register
        Register.register
        ServiceMultiplier.register
        SimpleEndDeviceFunction.register        
        UsagePoint.register
        UsagePointGroup.register
        UsagePointLocation.register
    }
}
