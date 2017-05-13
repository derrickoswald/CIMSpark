package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * This package contains the core information classes that support end device applications with specialized classes for metering and premises area network devices, and remote reading functions.
 * These classes are generally associated with the point where a service is delivered to the customer.
 */

/**
 * Lifecycle states of the metering installation at a usage point with respect to readiness for billing via advanced metering infrastructure reads.
 */
case class AmiBillingReadyKind
(

    override val sup: BasicElement,

    /**
     * Usage point is equipped with an AMI capable meter that is not yet currently equipped with a communications module.
     */
    val amiCapable: String,

    /**
     * Usage point is equipped with an AMI capable meter; however, the AMI functionality has been disabled or is not being used.
     */
    val amiDisabled: String,

    /**
     * Usage point is equipped with an operating AMI capable meter and accuracy has been certified for billing purposes.
     */
    val billingApproved: String,

    /**
     * Usage point is equipped with an AMI capable meter having communications capability.
     */
    val enabled: String,

    /**
     * Usage point is equipped with a non AMI capable meter.
     */
    val nonAmi: String,

    /**
     * Usage point is not currently equipped with a meter.
     */
    val nonMetered: String,

    /**
     * Usage point is equipped with an AMI capable meter that is functioning and communicating with the AMI network.
     */
    val operable: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[AmiBillingReadyKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AmiBillingReadyKind
extends
    Parseable[AmiBillingReadyKind]
{
    val sup = BasicElement.parse _
    val amiCapable = parse_attribute (attribute ("""AmiBillingReadyKind.amiCapable"""))_
    val amiDisabled = parse_attribute (attribute ("""AmiBillingReadyKind.amiDisabled"""))_
    val billingApproved = parse_attribute (attribute ("""AmiBillingReadyKind.billingApproved"""))_
    val enabled = parse_attribute (attribute ("""AmiBillingReadyKind.enabled"""))_
    val nonAmi = parse_attribute (attribute ("""AmiBillingReadyKind.nonAmi"""))_
    val nonMetered = parse_attribute (attribute ("""AmiBillingReadyKind.nonMetered"""))_
    val operable = parse_attribute (attribute ("""AmiBillingReadyKind.operable"""))_
    def parse (context: Context): AmiBillingReadyKind =
    {
        AmiBillingReadyKind(
            sup (context),
            amiCapable (context),
            amiDisabled (context),
            billingApproved (context),
            enabled (context),
            nonAmi (context),
            nonMetered (context),
            operable (context)
        )
    }
}

/**
 * Common representation for reading values.
 * Note that a reading value may have multiple qualities, as produced by various systems ('ReadingQuality.source').
 */
case class BaseReading
(

    override val sup: MeasurementValue,

    /**
     * (used only when there are detailed auditing requirements) Date and time at which the reading was first delivered to the metering system.
     */
    val reportedDateTime: String,

    /**
     * System that originally supplied the reading (e.g., customer, AMI system, handheld reading system, another enterprise system, etc.).
     */
    val source: String,

    /**
     * Start and end of the period for those readings whose type has a time attribute such as 'billing', seasonal' or 'forTheSpecifiedPeriod'.
     */
    val timePeriod: String,

    /**
     * Value of this reading.
     */
    val value: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def MeasurementValue: MeasurementValue = sup.asInstanceOf[MeasurementValue]
    override def copy (): Row = { return (clone ().asInstanceOf[BaseReading]) }
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
    val sup = MeasurementValue.parse _
    val reportedDateTime = parse_element (element ("""BaseReading.reportedDateTime"""))_
    val source = parse_element (element ("""BaseReading.source"""))_
    val timePeriod = parse_attribute (attribute ("""BaseReading.timePeriod"""))_
    val value = parse_element (element ("""BaseReading.value"""))_
    def parse (context: Context): BaseReading =
    {
        BaseReading(
            sup (context),
            reportedDateTime (context),
            source (context),
            timePeriod (context),
            value (context)
        )
    }
}

/**
 * A single path for the collection or reporting of register values over a period of time.
 * For example, a register which measures forward energy can have two channels, one providing bulk quantity readings and the other providing interval readings of a fixed interval size.
 */
case class Channel
(

    override val sup: IdentifiedObject,

    /**
     * If true, the data is being calculated by an enterprise system rather than metered directly.
     */
    val isVirtual: Boolean,

    /**
     * Reading type for register values reported/collected by this channel.
     */
    val ReadingType: String,

    /**
     * Register whose values are collected/reported by this channel.
     */
    val Register: String
)
extends
    Element
{
    def this () = { this (null, false, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Channel]) }
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
    val sup = IdentifiedObject.parse _
    val isVirtual = parse_element (element ("""Channel.isVirtual"""))_
    val ReadingType = parse_attribute (attribute ("""Channel.ReadingType"""))_
    val Register = parse_attribute (attribute ("""Channel.Register"""))_
    def parse (context: Context): Channel =
    {
        Channel(
            sup (context),
            toBoolean (isVirtual (context), context),
            ReadingType (context),
            Register (context)
        )
    }
}

/**
 * Kind of communication direction.
 */
case class ComDirectionKind
(

    override val sup: BasicElement,

    /**
     * Communication with the device is bi-directional.
     */
    val biDirectional: String,

    /**
     * Communication is from device.
     */
    val fromDevice: String,

    /**
     * Communication is to device.
     */
    val toDevice: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ComDirectionKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ComDirectionKind
extends
    Parseable[ComDirectionKind]
{
    val sup = BasicElement.parse _
    val biDirectional = parse_attribute (attribute ("""ComDirectionKind.biDirectional"""))_
    val fromDevice = parse_attribute (attribute ("""ComDirectionKind.fromDevice"""))_
    val toDevice = parse_attribute (attribute ("""ComDirectionKind.toDevice"""))_
    def parse (context: Context): ComDirectionKind =
    {
        ComDirectionKind(
            sup (context),
            biDirectional (context),
            fromDevice (context),
            toDevice (context)
        )
    }
}

/**
 * Communication function of communication equipment or a device such as a meter.
 */
case class ComFunction
(

    override val sup: EndDeviceFunction,

    /**
     * Communication ID number (e.g. serial number, IP address, telephone number, etc.) of the AMR module which serves this meter.
     */
    val amrAddress: String,

    /**
     * Communication ID number (e.g. port number, serial number, data collector ID, etc.) of the parent device associated to this AMR module.
     */
    val amrRouter: String,

    /**
     * Kind of communication direction.
     */
    val direction: String,

    /**
     * Kind of communication technology.
     */
    val technology: String,

    /**
     * Module performing this communication function.
     */
    val ComModule: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def EndDeviceFunction: EndDeviceFunction = sup.asInstanceOf[EndDeviceFunction]
    override def copy (): Row = { return (clone ().asInstanceOf[ComFunction]) }
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
    val sup = EndDeviceFunction.parse _
    val amrAddress = parse_element (element ("""ComFunction.amrAddress"""))_
    val amrRouter = parse_element (element ("""ComFunction.amrRouter"""))_
    val direction = parse_attribute (attribute ("""ComFunction.direction"""))_
    val technology = parse_attribute (attribute ("""ComFunction.technology"""))_
    val ComModule = parse_attribute (attribute ("""ComFunction.ComModule"""))_
    def parse (context: Context): ComFunction =
    {
        ComFunction(
            sup (context),
            amrAddress (context),
            amrRouter (context),
            direction (context),
            technology (context),
            ComModule (context)
        )
    }
}

/**
 * An asset having communications capabilities that can be paired with a meter or other end device to provide the device with communication ability, through associated communication function.
 * An end device that has communications capabilities through embedded hardware can use that function directly (without the communication module), or combine embedded communication function with additional communication functions provided through an external communication module (e.g. zigbee).
 */
case class ComModule
(

    override val sup: Asset,

    /**
     * Automated meter reading (AMR) system communicating with this com module.
     */
    val amrSystem: String,

    /**
     * If true, autonomous daylight saving time (DST) function is supported.
     */
    val supportsAutonomousDst: Boolean,

    /**
     * Time zone offset relative to GMT for the location of this com module.
     */
    val timeZoneOffset: Double
)
extends
    Element
{
    def this () = { this (null, null, false, 0.0) }
    def Asset: Asset = sup.asInstanceOf[Asset]
    override def copy (): Row = { return (clone ().asInstanceOf[ComModule]) }
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
    val sup = Asset.parse _
    val amrSystem = parse_element (element ("""ComModule.amrSystem"""))_
    val supportsAutonomousDst = parse_element (element ("""ComModule.supportsAutonomousDst"""))_
    val timeZoneOffset = parse_element (element ("""ComModule.timeZoneOffset"""))_
    def parse (context: Context): ComModule =
    {
        ComModule(
            sup (context),
            amrSystem (context),
            toBoolean (supportsAutonomousDst (context), context),
            toDouble (timeZoneOffset (context), context)
        )
    }
}

/**
 * Kind of communication technology.
 */
case class ComTechnologyKind
(

    override val sup: BasicElement,

    /**
     * Communicates using a public cellular radio network.
     * A specific variant of 'rf'.
     */
    val cellular: String,

    /**
     * Communicates using one or more of a family of frame-based computer networking technologies conforming to the IEEE 802.3 standard.
     */
    val ethernet: String,

    /**
     * Communicates using power line communication technologies conforming to the standards established by the HomePlug Powerline Alliance.
     * A specific variant of 'plc'.
     */
    val homePlug: String,

    /**
     * Communicates using a public one-way or two-way radio-based paging network.
     * A specific variant of 'rf'.
     */
    val pager: String,

    /**
     * Communicates using a basic, wireline telephone system.
     */
    val phone: String,

    /**
     * Communicates using power line communication technologies.
     */
    val plc: String,

    /**
     * Communicates using private or public radio-based technology.
     */
    val rf: String,

    /**
     * Communicates using a mesh radio technology.
     * A specific variant of 'rf'.
     */
    val rfMesh: String,

    /**
     * Communicates using radio communication technologies conforming to the standards established by the ZigBee.
     * A specific variant of 'rf'.
     */
    val zigbee: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ComTechnologyKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ComTechnologyKind
extends
    Parseable[ComTechnologyKind]
{
    val sup = BasicElement.parse _
    val cellular = parse_attribute (attribute ("""ComTechnologyKind.cellular"""))_
    val ethernet = parse_attribute (attribute ("""ComTechnologyKind.ethernet"""))_
    val homePlug = parse_attribute (attribute ("""ComTechnologyKind.homePlug"""))_
    val pager = parse_attribute (attribute ("""ComTechnologyKind.pager"""))_
    val phone = parse_attribute (attribute ("""ComTechnologyKind.phone"""))_
    val plc = parse_attribute (attribute ("""ComTechnologyKind.plc"""))_
    val rf = parse_attribute (attribute ("""ComTechnologyKind.rf"""))_
    val rfMesh = parse_attribute (attribute ("""ComTechnologyKind.rfMesh"""))_
    val zigbee = parse_attribute (attribute ("""ComTechnologyKind.zigbee"""))_
    def parse (context: Context): ComTechnologyKind =
    {
        ComTechnologyKind(
            sup (context),
            cellular (context),
            ethernet (context),
            homePlug (context),
            pager (context),
            phone (context),
            plc (context),
            rf (context),
            rfMesh (context),
            zigbee (context)
        )
    }
}

/**
 * Appliance controlled with a PAN device control.
 */
case class ControlledAppliance
(

    override val sup: BasicElement,

    /**
     * True if the appliance is an electric vehicle.
     */
    val isElectricVehicle: Boolean,

    /**
     * True if the appliance is exterior lighting.
     */
    val isExteriorLighting: Boolean,

    /**
     * True if the appliance is a generation system.
     */
    val isGenerationSystem: Boolean,

    /**
     * True if the appliance is HVAC compressor or furnace.
     */
    val isHvacCompressorOrFurnace: Boolean,

    /**
     * True if the appliance is interior lighting.
     */
    val isInteriorLighting: Boolean,

    /**
     * True if the appliance is an irrigation pump.
     */
    val isIrrigationPump: Boolean,

    /**
     * True if the appliance is managed commercial or industrial load.
     */
    val isManagedCommercialIndustrialLoad: Boolean,

    /**
     * True if the appliance is a pool, pump, spa or jacuzzi.
     */
    val isPoolPumpSpaJacuzzi: Boolean,

    /**
     * True if the appliance is a simple miscellaneous load.
     */
    val isSimpleMiscLoad: Boolean,

    /**
     * True if the appliance is a smart appliance.
     */
    val isSmartAppliance: Boolean,

    /**
     * True if the appliance is a stip or baseboard heater.
     */
    val isStripAndBaseboardHeater: Boolean,

    /**
     * True if the appliance is a water heater.
     */
    val isWaterHeater: Boolean
)
extends
    Element
{
    def this () = { this (null, false, false, false, false, false, false, false, false, false, false, false, false) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ControlledAppliance]) }
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
    val sup = BasicElement.parse _
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
        ControlledAppliance(
            sup (context),
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
    }
}

/**
 * Demand response program.
 */
case class DemandResponseProgram
(

    override val sup: IdentifiedObject,

    /**
     * Type of demand response program; examples are CPP (critical-peak pricing), RTP (real-time pricing), DLC (direct load control), DBP (demand bidding program), BIP (base interruptible program).
     * Note that possible types change a lot and it would be impossible to enumerate them all.
     */
    val typ: String,

    /**
     * Interval within which the program is valid.
     */
    val validityInterval: String,

    /**
     * All customer agreements through which the customer is enrolled in this demand response program.
     */
    val CustomerAgreements: List[String],

    /**
     * All groups of end devices enrolled in this demand response program.
     */
    val EndDeviceGroups: List[String],

    /**
     * All usage point groups enrolled in this demand response program.
     */
    val UsagePointGroups: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, List(), List(), List()) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[DemandResponseProgram]) }
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
    val sup = IdentifiedObject.parse _
    val typ = parse_element (element ("""DemandResponseProgram.type"""))_
    val validityInterval = parse_attribute (attribute ("""DemandResponseProgram.validityInterval"""))_
    val CustomerAgreements = parse_attributes (attribute ("""DemandResponseProgram.CustomerAgreements"""))_
    val EndDeviceGroups = parse_attributes (attribute ("""DemandResponseProgram.EndDeviceGroups"""))_
    val UsagePointGroups = parse_attributes (attribute ("""DemandResponseProgram.UsagePointGroups"""))_
    def parse (context: Context): DemandResponseProgram =
    {
        DemandResponseProgram(
            sup (context),
            typ (context),
            validityInterval (context),
            CustomerAgreements (context),
            EndDeviceGroups (context),
            UsagePointGroups (context)
        )
    }
}

/**
 * Asset container that performs one or more end device functions.
 * One type of end device is a meter which can perform metering, load management, connect/disconnect, accounting functions, etc. Some end devices, such as ones monitoring and controlling air conditioners, refrigerators, pool pumps may be connected to a meter. All end devices may have communication capability defined by the associated communication function(s). An end device may be owned by a consumer, a service provider, utility or otherwise.
 */
case class EndDevice
(

    override val sup: AssetContainer,

    /**
     * Automated meter reading (AMR) or other communication system responsible for communications to this end device.
     */
    val amrSystem: String,

    /**
     * Installation code.
     */
    val installCode: String,

    /**
     * If true, this is a premises area network (PAN) device.
     */
    val isPan: Boolean,

    /**
     * If true, there is no physical device.
     * As an example, a virtual meter can be defined to aggregate the consumption for two or more physical meters. Otherwise, this is a physical hardware device.
     */
    val isVirtual: Boolean,

    /**
     * Time zone offset relative to GMT for the location of this end device.
     */
    val timeZoneOffset: Double,

    /**
     * Customer owning this end device.
     */
    val Customer: String,

    /**
     * End device data.
     */
    val EndDeviceInfo: String,

    /**
     * Service location whose service delivery is measured by this end device.
     */
    val ServiceLocation: String,

    /**
     * Usage point to which this end device belongs.
     */
    val UsagePoint: String
)
extends
    Element
{
    def this () = { this (null, null, null, false, false, 0.0, null, null, null, null) }
    def AssetContainer: AssetContainer = sup.asInstanceOf[AssetContainer]
    override def copy (): Row = { return (clone ().asInstanceOf[EndDevice]) }
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
    val sup = AssetContainer.parse _
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
        EndDevice(
            sup (context),
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
    }
}

/**
 * Action/command performed by an end device on a device other than the end device.
 */
case class EndDeviceAction
(

    override val sup: BasicElement,

    /**
     * Command text.
     */
    val command: String,

    /**
     * Amount of time the action of this control is to remain active.
     */
    val duration: Double,

    /**
     * True if the action of this control is indefinite.
     */
    val durationIndefinite: Boolean,

    /**
     * Start date and time for action of this control.
     */
    val startDateTime: String,

    /**
     * End device control issuing this end device action.
     */
    val EndDeviceControl: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, false, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[EndDeviceAction]) }
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
    val sup = BasicElement.parse _
    val command = parse_element (element ("""EndDeviceAction.command"""))_
    val duration = parse_element (element ("""EndDeviceAction.duration"""))_
    val durationIndefinite = parse_element (element ("""EndDeviceAction.durationIndefinite"""))_
    val startDateTime = parse_element (element ("""EndDeviceAction.startDateTime"""))_
    val EndDeviceControl = parse_attribute (attribute ("""EndDeviceAction.EndDeviceControl"""))_
    def parse (context: Context): EndDeviceAction =
    {
        EndDeviceAction(
            sup (context),
            command (context),
            toDouble (duration (context), context),
            toBoolean (durationIndefinite (context), context),
            startDateTime (context),
            EndDeviceControl (context)
        )
    }
}

/**
 * Inherent capabilities of an end device (i.e., the functions it supports).
 */
case class EndDeviceCapability
(

    override val sup: BasicElement,

    /**
     * True if autonomous DST (daylight saving time) function is supported.
     */
    val autonomousDst: Boolean,

    /**
     * True if communication function is supported.
     */
    val communication: Boolean,

    /**
     * True if connect and disconnect function is supported.
     */
    val connectDisconnect: Boolean,

    /**
     * True if demand response function is supported.
     */
    val demandResponse: Boolean,

    /**
     * True if electric metering function is supported.
     */
    val electricMetering: Boolean,

    /**
     * True if gas metering function is supported.
     */
    val gasMetering: Boolean,

    /**
     * True if metrology function is supported.
     */
    val metrology: Boolean,

    /**
     * True if on request read function is supported.
     */
    val onRequestRead: Boolean,

    /**
     * True if outage history function is supported.
     */
    val outageHistory: Boolean,

    /**
     * True if device performs pressure compensation for metered quantities.
     */
    val pressureCompensation: Boolean,

    /**
     * True if pricing information is supported.
     */
    val pricingInfo: Boolean,

    /**
     * True if device produces pulse outputs.
     */
    val pulseOutput: Boolean,

    /**
     * True if relays programming function is supported.
     */
    val relaysProgramming: Boolean,

    /**
     * True if reverse flow function is supported.
     */
    val reverseFlow: Boolean,

    /**
     * True if device performs super compressibility compensation for metered quantities.
     */
    val superCompressibilityCompensation: Boolean,

    /**
     * True if device performs temperature compensation for metered quantities.
     */
    val temperatureCompensation: Boolean,

    /**
     * True if the displaying of text messages is supported.
     */
    val textMessage: Boolean,

    /**
     * True if water metering function is supported.
     */
    val waterMetering: Boolean
)
extends
    Element
{
    def this () = { this (null, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[EndDeviceCapability]) }
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
    val sup = BasicElement.parse _
    val autonomousDst = parse_element (element ("""EndDeviceCapability.autonomousDst"""))_
    val communication = parse_element (element ("""EndDeviceCapability.communication"""))_
    val connectDisconnect = parse_element (element ("""EndDeviceCapability.connectDisconnect"""))_
    val demandResponse = parse_element (element ("""EndDeviceCapability.demandResponse"""))_
    val electricMetering = parse_element (element ("""EndDeviceCapability.electricMetering"""))_
    val gasMetering = parse_element (element ("""EndDeviceCapability.gasMetering"""))_
    val metrology = parse_element (element ("""EndDeviceCapability.metrology"""))_
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
        EndDeviceCapability(
            sup (context),
            toBoolean (autonomousDst (context), context),
            toBoolean (communication (context), context),
            toBoolean (connectDisconnect (context), context),
            toBoolean (demandResponse (context), context),
            toBoolean (electricMetering (context), context),
            toBoolean (gasMetering (context), context),
            toBoolean (metrology (context), context),
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
    }
}

/**
 * Instructs an end device (or an end device group) to perform a specified action.
 */
case class EndDeviceControl
(

    override val sup: IdentifiedObject,

    /**
     * Level of a demand response program request, where 0=emergency.
     * Note: Attribute is not defined on DemandResponseProgram as it is not its inherent property (it serves to control it).
     */
    val drProgramLevel: Int,

    /**
     * Whether a demand response program request is mandatory.
     * Note: Attribute is not defined on DemandResponseProgram as it is not its inherent property (it serves to control it).
     */
    val drProgramMandatory: Boolean,

    /**
     * Unique identifier of the business entity originating an end device control.
     */
    val issuerID: String,

    /**
     * Identifier assigned by the initiator (e.g. retail electric provider) of an end device control action to uniquely identify the demand response event, text message, or other subject of the control action.
     * Can be used when cancelling an event or text message request or to identify the originating event or text message in a consequential end device event.
     */
    val issuerTrackingID: String,

    /**
     * (if applicable) Price signal used as parameter for this end device control.
     */
    val priceSignal: String,

    /**
     * Timing for the control actions performed on the device identified in the end device control.
     */
    val primaryDeviceTiming: String,

    /**
     * Reason for the control action that allows to determine how to continue processing.
     * For example, disconnect meter command may require different processing by the receiving system if it has been issued for a network-related reason (protection) or for a payment-related reason.
     */
    val reason: String,

    /**
     * (if control has scheduled duration) Date and time interval the control has been scheduled to execute within.
     */
    val scheduledInterval: String,

    /**
     * Timing for the control actions performed by devices that are responding to event related information sent to the primary device indicated in the end device control.
     * For example, load control actions performed by a PAN device in response to demand response event information sent to a PAN gateway server.
     */
    val secondaryDeviceTiming: String,

    /**
     * End device action issued by this end device control.
     */
    val EndDeviceAction: String,

    /**
     * Type of this end device control.
     */
    val EndDeviceControlType: String,

    /**
     * All end devices receiving commands from this end device control.
     */
    val EndDevices: List[String],

    /**
     * All usage point groups receiving commands from this end device control.
     */
    val UsagePointGroups: List[String],

    /**
     * All usage points receiving commands from this end device control.
     */
    val UsagePoints: List[String]
)
extends
    Element
{
    def this () = { this (null, 0, false, null, null, null, null, null, null, null, null, null, List(), List(), List()) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[EndDeviceControl]) }
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
    val sup = IdentifiedObject.parse _
    val drProgramLevel = parse_element (element ("""EndDeviceControl.drProgramLevel"""))_
    val drProgramMandatory = parse_element (element ("""EndDeviceControl.drProgramMandatory"""))_
    val issuerID = parse_element (element ("""EndDeviceControl.issuerID"""))_
    val issuerTrackingID = parse_element (element ("""EndDeviceControl.issuerTrackingID"""))_
    val priceSignal = parse_attribute (attribute ("""EndDeviceControl.priceSignal"""))_
    val primaryDeviceTiming = parse_attribute (attribute ("""EndDeviceControl.primaryDeviceTiming"""))_
    val reason = parse_element (element ("""EndDeviceControl.reason"""))_
    val scheduledInterval = parse_attribute (attribute ("""EndDeviceControl.scheduledInterval"""))_
    val secondaryDeviceTiming = parse_attribute (attribute ("""EndDeviceControl.secondaryDeviceTiming"""))_
    val EndDeviceAction = parse_attribute (attribute ("""EndDeviceControl.EndDeviceAction"""))_
    val EndDeviceControlType = parse_attribute (attribute ("""EndDeviceControl.EndDeviceControlType"""))_
    val EndDevices = parse_attributes (attribute ("""EndDeviceControl.EndDevices"""))_
    val UsagePointGroups = parse_attributes (attribute ("""EndDeviceControl.UsagePointGroups"""))_
    val UsagePoints = parse_attributes (attribute ("""EndDeviceControl.UsagePoints"""))_
    def parse (context: Context): EndDeviceControl =
    {
        EndDeviceControl(
            sup (context),
            toInteger (drProgramLevel (context), context),
            toBoolean (drProgramMandatory (context), context),
            issuerID (context),
            issuerTrackingID (context),
            priceSignal (context),
            primaryDeviceTiming (context),
            reason (context),
            scheduledInterval (context),
            secondaryDeviceTiming (context),
            EndDeviceAction (context),
            EndDeviceControlType (context),
            EndDevices (context),
            UsagePointGroups (context),
            UsagePoints (context)
        )
    }
}

/**
 * Detailed description for a control produced by an end device.
 * Values in attributes allow for creation of recommended codes to be used for identifying end device controls as follows: &lt;type&gt;.&lt;domain&gt;.&lt;subDomain&gt;.&lt;eventOrAction&gt;.
 */
case class EndDeviceControlType
(

    override val sup: IdentifiedObject,

    /**
     * High-level nature of the control.
     */
    val domain: String,

    /**
     * The most specific part of this control type.
     * It is mainly in the form of a verb that gives action to the control that just occurred.
     */
    val eventOrAction: String,

    /**
     * More specific nature of the control, as a further sub-categorisation of 'domain'.
     */
    val subDomain: String,

    /**
     * Type of physical device from which the control was created.
     * A value of zero (0) can be used when the source is unknown.
     */
    val typ: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[EndDeviceControlType]) }
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
    val sup = IdentifiedObject.parse _
    val domain = parse_element (element ("""EndDeviceControlType.domain"""))_
    val eventOrAction = parse_element (element ("""EndDeviceControlType.eventOrAction"""))_
    val subDomain = parse_element (element ("""EndDeviceControlType.subDomain"""))_
    val typ = parse_element (element ("""EndDeviceControlType.type"""))_
    def parse (context: Context): EndDeviceControlType =
    {
        EndDeviceControlType(
            sup (context),
            domain (context),
            eventOrAction (context),
            subDomain (context),
            typ (context)
        )
    }
}

/**
 * Event detected by a device function associated with the end device.
 */
case class EndDeviceEvent
(

    override val sup: ActivityRecord,

    /**
     * Unique identifier of the business entity originating an end device control.
     */
    val issuerID: String,

    /**
     * Identifier assigned by the initiator (e.g. retail electric provider) of an end device control action to uniquely identify the demand response event, text message, or other subject of the control action.
     * Can be used when cancelling an event or text message request or to identify the originating event or text message in a consequential end device event.
     */
    val issuerTrackingID: String,

    /**
     * (if user initiated) ID of user who initiated this end device event.
     */
    val userID: String,

    /**
     * End device that reported this end device event.
     */
    val EndDevice: String,

    /**
     * Type of this end device event.
     */
    val EndDeviceEventType: String,

    /**
     * Set of measured values to which this event applies.
     */
    val MeterReading: String,

    /**
     * Usage point for which this end device event is reported.
     */
    val UsagePoint: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null) }
    def ActivityRecord: ActivityRecord = sup.asInstanceOf[ActivityRecord]
    override def copy (): Row = { return (clone ().asInstanceOf[EndDeviceEvent]) }
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
    val sup = ActivityRecord.parse _
    val issuerID = parse_element (element ("""EndDeviceEvent.issuerID"""))_
    val issuerTrackingID = parse_element (element ("""EndDeviceEvent.issuerTrackingID"""))_
    val userID = parse_element (element ("""EndDeviceEvent.userID"""))_
    val EndDevice = parse_attribute (attribute ("""EndDeviceEvent.EndDevice"""))_
    val EndDeviceEventType = parse_attribute (attribute ("""EndDeviceEvent.EndDeviceEventType"""))_
    val MeterReading = parse_attribute (attribute ("""EndDeviceEvent.MeterReading"""))_
    val UsagePoint = parse_attribute (attribute ("""EndDeviceEvent.UsagePoint"""))_
    def parse (context: Context): EndDeviceEvent =
    {
        EndDeviceEvent(
            sup (context),
            issuerID (context),
            issuerTrackingID (context),
            userID (context),
            EndDevice (context),
            EndDeviceEventType (context),
            MeterReading (context),
            UsagePoint (context)
        )
    }
}

/**
 * Name-value pair, specific to end device events.
 */
case class EndDeviceEventDetail
(

    override val sup: BasicElement,

    /**
     * Name.
     */
    val name: String,

    /**
     * Value, including unit information.
     */
    val value: String,

    /**
     * End device owning this detail.
     */
    val EndDeviceEvent: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[EndDeviceEventDetail]) }
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
    val sup = BasicElement.parse _
    val name = parse_element (element ("""EndDeviceEventDetail.name"""))_
    val value = parse_attribute (attribute ("""EndDeviceEventDetail.value"""))_
    val EndDeviceEvent = parse_attribute (attribute ("""EndDeviceEventDetail.EndDeviceEvent"""))_
    def parse (context: Context): EndDeviceEventDetail =
    {
        EndDeviceEventDetail(
            sup (context),
            name (context),
            value (context),
            EndDeviceEvent (context)
        )
    }
}

/**
 * Detailed description for an event produced by an end device.
 * Values in attributes allow for creation of recommended codes to be used for identifying end device events as follows: &lt;type&gt;.&lt;domain&gt;.&lt;subDomain&gt;.&lt;eventOrAction&gt;.
 */
case class EndDeviceEventType
(

    override val sup: IdentifiedObject,

    /**
     * High-level nature of the event.
     * By properly classifying events by a small set of domain codes, a system can more easily run reports based on the types of events that have occurred or been received.
     */
    val domain: String,

    /**
     * The most specific part of this event type.
     * It is mainly in the form of a verb that gives action to the event that just occurred.
     */
    val eventOrAction: String,

    /**
     * More specific nature of the event, as a further sub-categorisation of 'domain'.
     */
    val subDomain: String,

    /**
     * Type of physical device from which the event was created.
     * A value of zero (0) can be used when the source is unknown.
     */
    val typ: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[EndDeviceEventType]) }
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
    val sup = IdentifiedObject.parse _
    val domain = parse_element (element ("""EndDeviceEventType.domain"""))_
    val eventOrAction = parse_element (element ("""EndDeviceEventType.eventOrAction"""))_
    val subDomain = parse_element (element ("""EndDeviceEventType.subDomain"""))_
    val typ = parse_element (element ("""EndDeviceEventType.type"""))_
    def parse (context: Context): EndDeviceEventType =
    {
        EndDeviceEventType(
            sup (context),
            domain (context),
            eventOrAction (context),
            subDomain (context),
            typ (context)
        )
    }
}

/**
 * Function performed by an end device such as a meter, communication equipment, controllers, etc.
 */
case class EndDeviceFunction
(

    override val sup: AssetFunction,

    /**
     * True if the function is enabled.
     */
    val enabled: Boolean,

    /**
     * End device that performs this function.
     */
    val EndDevice: String
)
extends
    Element
{
    def this () = { this (null, false, null) }
    def AssetFunction: AssetFunction = sup.asInstanceOf[AssetFunction]
    override def copy (): Row = { return (clone ().asInstanceOf[EndDeviceFunction]) }
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
    val sup = AssetFunction.parse _
    val enabled = parse_element (element ("""EndDeviceFunction.enabled"""))_
    val EndDevice = parse_attribute (attribute ("""EndDeviceFunction.EndDevice"""))_
    def parse (context: Context): EndDeviceFunction =
    {
        EndDeviceFunction(
            sup (context),
            toBoolean (enabled (context), context),
            EndDevice (context)
        )
    }
}

/**
 * Kind of end device function.
 */
case class EndDeviceFunctionKind
(

    override val sup: BasicElement,

    /**
     * Autonomous application of daylight saving time (DST).
     */
    val autonomousDst: String,

    /**
     * Demand response functions.
     */
    val demandResponse: String,

    /**
     * Electricity metering.
     */
    val electricMetering: String,

    /**
     * Gas metering.
     */
    val gasMetering: String,

    /**
     * Presentation of metered values to a user or another system (always a function of a meter, but might not be supported by a load control unit).
     */
    val metrology: String,

    /**
     * On-request reads.
     */
    val onRequestRead: String,

    /**
     * Reporting historical power interruption data.
     */
    val outageHistory: String,

    /**
     * Support for one or more relays that may be programmable in the meter (and tied to TOU, time pulse, load control or other functions).
     */
    val relaysProgramming: String,

    /**
     * Detection and monitoring of reverse flow.
     */
    val reverseFlow: String,

    /**
     * Water metering.
     */
    val waterMetering: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[EndDeviceFunctionKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EndDeviceFunctionKind
extends
    Parseable[EndDeviceFunctionKind]
{
    val sup = BasicElement.parse _
    val autonomousDst = parse_attribute (attribute ("""EndDeviceFunctionKind.autonomousDst"""))_
    val demandResponse = parse_attribute (attribute ("""EndDeviceFunctionKind.demandResponse"""))_
    val electricMetering = parse_attribute (attribute ("""EndDeviceFunctionKind.electricMetering"""))_
    val gasMetering = parse_attribute (attribute ("""EndDeviceFunctionKind.gasMetering"""))_
    val metrology = parse_attribute (attribute ("""EndDeviceFunctionKind.metrology"""))_
    val onRequestRead = parse_attribute (attribute ("""EndDeviceFunctionKind.onRequestRead"""))_
    val outageHistory = parse_attribute (attribute ("""EndDeviceFunctionKind.outageHistory"""))_
    val relaysProgramming = parse_attribute (attribute ("""EndDeviceFunctionKind.relaysProgramming"""))_
    val reverseFlow = parse_attribute (attribute ("""EndDeviceFunctionKind.reverseFlow"""))_
    val waterMetering = parse_attribute (attribute ("""EndDeviceFunctionKind.waterMetering"""))_
    def parse (context: Context): EndDeviceFunctionKind =
    {
        EndDeviceFunctionKind(
            sup (context),
            autonomousDst (context),
            demandResponse (context),
            electricMetering (context),
            gasMetering (context),
            metrology (context),
            onRequestRead (context),
            outageHistory (context),
            relaysProgramming (context),
            reverseFlow (context),
            waterMetering (context)
        )
    }
}

/**
 * Abstraction for management of group communications within a two-way AMR system or the data for a group of related end devices.
 * Commands can be issued to all of the end devices that belong to the group using a defined group address and the underlying AMR communication infrastructure.
 */
case class EndDeviceGroup
(

    override val sup: IdentifiedObject,

    /**
     * Type of this group.
     */
    val typ: String,

    /**
     * All end device controls sending commands to this end device group.
     */
    val EndDeviceControls: List[String],

    /**
     * All end devices this end device group refers to.
     */
    val EndDevices: List[String]
)
extends
    Element
{
    def this () = { this (null, null, List(), List()) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[EndDeviceGroup]) }
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
    val sup = IdentifiedObject.parse _
    val typ = parse_element (element ("""EndDeviceGroup.type"""))_
    val EndDeviceControls = parse_attributes (attribute ("""EndDeviceGroup.EndDeviceControls"""))_
    val EndDevices = parse_attributes (attribute ("""EndDeviceGroup.EndDevices"""))_
    def parse (context: Context): EndDeviceGroup =
    {
        EndDeviceGroup(
            sup (context),
            typ (context),
            EndDeviceControls (context),
            EndDevices (context)
        )
    }
}

/**
 * End device data.
 */
case class EndDeviceInfo
(

    override val sup: AssetInfo,

    /**
     * Inherent capabilities of the device (i.e., the functions it supports).
     */
    val capability: String,

    /**
     * If true, this is a solid state end device (as opposed to a mechanical or electromechanical device).
     */
    val isSolidState: Boolean,

    /**
     * Number of potential phases the end device supports, typically 0, 1 or 3.
     */
    val phaseCount: Int,

    /**
     * Rated current.
     */
    val ratedCurrent: Double,

    /**
     * Rated voltage.
     */
    val ratedVoltage: Double
)
extends
    Element
{
    def this () = { this (null, null, false, 0, 0.0, 0.0) }
    def AssetInfo: AssetInfo = sup.asInstanceOf[AssetInfo]
    override def copy (): Row = { return (clone ().asInstanceOf[EndDeviceInfo]) }
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
    val sup = AssetInfo.parse _
    val capability = parse_attribute (attribute ("""EndDeviceInfo.capability"""))_
    val isSolidState = parse_element (element ("""EndDeviceInfo.isSolidState"""))_
    val phaseCount = parse_element (element ("""EndDeviceInfo.phaseCount"""))_
    val ratedCurrent = parse_element (element ("""EndDeviceInfo.ratedCurrent"""))_
    val ratedVoltage = parse_element (element ("""EndDeviceInfo.ratedVoltage"""))_
    def parse (context: Context): EndDeviceInfo =
    {
        EndDeviceInfo(
            sup (context),
            capability (context),
            toBoolean (isSolidState (context), context),
            toInteger (phaseCount (context), context),
            toDouble (ratedCurrent (context), context),
            toDouble (ratedVoltage (context), context)
        )
    }
}

/**
 * Timing for the control actions of end devices.
 */
case class EndDeviceTiming
(

    override val sup: BasicElement,

    /**
     * Duration of the end device control action or the business event that is the subject of the end device control.
     */
    val duration: Double,

    /**
     * True if 'duration' is indefinite.
     */
    val durationIndefinite: Boolean,

    /**
     * Start and end time of an interval during which end device control actions are to be executed.
     */
    val interval: String,

    /**
     * Kind of randomisation to be applied to the end device control actions to be executed.
     */
    val randomisation: String
)
extends
    Element
{
    def this () = { this (null, 0.0, false, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[EndDeviceTiming]) }
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
    val sup = BasicElement.parse _
    val duration = parse_element (element ("""EndDeviceTiming.duration"""))_
    val durationIndefinite = parse_element (element ("""EndDeviceTiming.durationIndefinite"""))_
    val interval = parse_attribute (attribute ("""EndDeviceTiming.interval"""))_
    val randomisation = parse_attribute (attribute ("""EndDeviceTiming.randomisation"""))_
    def parse (context: Context): EndDeviceTiming =
    {
        EndDeviceTiming(
            sup (context),
            toDouble (duration (context), context),
            toBoolean (durationIndefinite (context), context),
            interval (context),
            randomisation (context)
        )
    }
}

/**
 * Time sequence of readings of the same reading type.
 * Contained interval readings may need conversion through the application of an offset and a scalar defined in associated pending.
 */
case class IntervalBlock
(

    override val sup: BasicElement,

    /**
     * Interval reading contained in this block.
     */
    val IntervalReadings: List[String],

    /**
     * Meter reading containing this interval block.
     */
    val MeterReading: String,

    /**
     * Pending calculation to apply to interval reading values contained by this block (after which the resulting reading type is different than the original because it reflects the conversion result).
     */
    val PendingCalculation: String,

    /**
     * Type information for interval reading values contained in this block.
     */
    val ReadingType: String
)
extends
    Element
{
    def this () = { this (null, List(), null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[IntervalBlock]) }
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
    val sup = BasicElement.parse _
    val IntervalReadings = parse_attributes (attribute ("""IntervalBlock.IntervalReadings"""))_
    val MeterReading = parse_attribute (attribute ("""IntervalBlock.MeterReading"""))_
    val PendingCalculation = parse_attribute (attribute ("""IntervalBlock.PendingCalculation"""))_
    val ReadingType = parse_attribute (attribute ("""IntervalBlock.ReadingType"""))_
    def parse (context: Context): IntervalBlock =
    {
        IntervalBlock(
            sup (context),
            IntervalReadings (context),
            MeterReading (context),
            PendingCalculation (context),
            ReadingType (context)
        )
    }
}

/**
 * Data captured at regular intervals of time.
 * Interval data could be captured as incremental data, absolute data, or relative data. The source for the data is usually a tariff quantity or an engineering quantity. Data is typically captured in time-tagged, uniform, fixed-length intervals of 5 min, 10 min, 15 min, 30 min, or 60 min.
 */
case class IntervalReading
(

    override val sup: BaseReading
)
extends
    Element
{
    def this () = { this (null) }
    def BaseReading: BaseReading = sup.asInstanceOf[BaseReading]
    override def copy (): Row = { return (clone ().asInstanceOf[IntervalReading]) }
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
    val sup = BaseReading.parse _
    def parse (context: Context): IntervalReading =
    {
        IntervalReading(
            sup (context)
        )
    }
}

/**
 * Physical asset that performs the metering role of the usage point.
 * Used for measuring consumption and detection of events.
 */
case class Meter
(

    override val sup: EndDevice,

    /**
     * Meter form designation per ANSI C12.10 or other applicable standard.
     * An alphanumeric designation denoting the circuit arrangement for which the meter is applicable and its specific terminal arrangement.
     */
    val formNumber: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def EndDevice: EndDevice = sup.asInstanceOf[EndDevice]
    override def copy (): Row = { return (clone ().asInstanceOf[Meter]) }
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
    val sup = EndDevice.parse _
    val formNumber = parse_element (element ("""Meter.formNumber"""))_
    def parse (context: Context): Meter =
    {
        Meter(
            sup (context),
            formNumber (context)
        )
    }
}

/**
 * Multiplier applied at the meter.
 */
case class MeterMultiplier
(

    override val sup: IdentifiedObject,

    /**
     * Kind of multiplier.
     */
    val kind: String,

    /**
     * Multiplier value.
     */
    val value: Double,

    /**
     * Meter applying this multiplier.
     */
    val Meter: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[MeterMultiplier]) }
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
    val sup = IdentifiedObject.parse _
    val kind = parse_attribute (attribute ("""MeterMultiplier.kind"""))_
    val value = parse_element (element ("""MeterMultiplier.value"""))_
    val Meter = parse_attribute (attribute ("""MeterMultiplier.Meter"""))_
    def parse (context: Context): MeterMultiplier =
    {
        MeterMultiplier(
            sup (context),
            kind (context),
            toDouble (value (context), context),
            Meter (context)
        )
    }
}

/**
 * Kind of meter multiplier.
 */
case class MeterMultiplierKind
(

    override val sup: BasicElement,

    /**
     * Current transformer ratio used to convert associated quantities to real measurements.
     */
    val ctRatio: String,

    /**
     * Test constant.
     */
    val kE: String,

    /**
     * Meter kh (watthour) constant.
     * The number of watthours that must be applied to the meter to cause one disk revolution for an electromechanical meter or the number of watthours represented by one increment pulse for an electronic meter.
     */
    val kH: String,

    /**
     * Register multiplier.
     * The number to multiply the register reading by in order to get kWh.
     */
    val kR: String,

    /**
     * Potential transformer ratio used to convert associated quantities to real measurements.
     */
    val ptRatio: String,

    /**
     * Product of the CT ratio and PT ratio.
     */
    val transformerRatio: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[MeterMultiplierKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MeterMultiplierKind
extends
    Parseable[MeterMultiplierKind]
{
    val sup = BasicElement.parse _
    val ctRatio = parse_attribute (attribute ("""MeterMultiplierKind.ctRatio"""))_
    val kE = parse_attribute (attribute ("""MeterMultiplierKind.kE"""))_
    val kH = parse_attribute (attribute ("""MeterMultiplierKind.kH"""))_
    val kR = parse_attribute (attribute ("""MeterMultiplierKind.kR"""))_
    val ptRatio = parse_attribute (attribute ("""MeterMultiplierKind.ptRatio"""))_
    val transformerRatio = parse_attribute (attribute ("""MeterMultiplierKind.transformerRatio"""))_
    def parse (context: Context): MeterMultiplierKind =
    {
        MeterMultiplierKind(
            sup (context),
            ctRatio (context),
            kE (context),
            kH (context),
            kR (context),
            ptRatio (context),
            transformerRatio (context)
        )
    }
}

/**
 * Set of values obtained from the meter.
 */
case class MeterReading
(

    override val sup: IdentifiedObject,

    /**
     * If true, this meter reading is the meter reading for which other coincident meter readings are requested or provided.
     */
    val isCoincidentTrigger: Boolean,

    /**
     * Date and time interval of the data items contained within this meter reading.
     */
    val valuesInterval: String,

    /**
     * (could be deprecated in the future) Customer agreement for this meter reading.
     */
    val CustomerAgreement: String,

    /**
     * Meter providing this reading.
     */
    val Meter: String,

    /**
     * Usage point from which this meter reading (set of values) has been obtained.
     */
    val UsagePoint: String
)
extends
    Element
{
    def this () = { this (null, false, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[MeterReading]) }
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
    val sup = IdentifiedObject.parse _
    val isCoincidentTrigger = parse_element (element ("""MeterReading.isCoincidentTrigger"""))_
    val valuesInterval = parse_attribute (attribute ("""MeterReading.valuesInterval"""))_
    val CustomerAgreement = parse_attribute (attribute ("""MeterReading.CustomerAgreement"""))_
    val Meter = parse_attribute (attribute ("""MeterReading.Meter"""))_
    val UsagePoint = parse_attribute (attribute ("""MeterReading.UsagePoint"""))_
    def parse (context: Context): MeterReading =
    {
        MeterReading(
            sup (context),
            toBoolean (isCoincidentTrigger (context), context),
            valuesInterval (context),
            CustomerAgreement (context),
            Meter (context),
            UsagePoint (context)
        )
    }
}

/**
 * Work involving meters.
 */
case class MeterServiceWork
(

    override val sup: Work,

    /**
     * Meter on which this non-replacement work is performed.
     */
    val Meter: String,

    /**
     * Old meter replaced by this work.
     */
    val OldMeter: String,

    /**
     * Usage point to which this meter service work applies.
     */
    val UsagePoint: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Work: Work = sup.asInstanceOf[Work]
    override def copy (): Row = { return (clone ().asInstanceOf[MeterServiceWork]) }
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
    val sup = Work.parse _
    val Meter = parse_attribute (attribute ("""MeterServiceWork.Meter"""))_
    val OldMeter = parse_attribute (attribute ("""MeterServiceWork.OldMeter"""))_
    val UsagePoint = parse_attribute (attribute ("""MeterServiceWork.UsagePoint"""))_
    def parse (context: Context): MeterServiceWork =
    {
        MeterServiceWork(
            sup (context),
            Meter (context),
            OldMeter (context),
            UsagePoint (context)
        )
    }
}

/**
 * A specification of the metering requirements for a particular point within a network.
 */
case class MetrologyRequirement
(

    override val sup: IdentifiedObject,

    /**
     * Reason for this metrology requirement being specified.
     */
    val reason: String,

    /**
     * All usage points having this metrology requirement.
     */
    val UsagePoints: List[String]
)
extends
    Element
{
    def this () = { this (null, null, List()) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[MetrologyRequirement]) }
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
    val sup = IdentifiedObject.parse _
    val reason = parse_attribute (attribute ("""MetrologyRequirement.reason"""))_
    val UsagePoints = parse_attributes (attribute ("""MetrologyRequirement.UsagePoints"""))_
    def parse (context: Context): MetrologyRequirement =
    {
        MetrologyRequirement(
            sup (context),
            reason (context),
            UsagePoints (context)
        )
    }
}

/**
 * PAN control used to issue action/command to PAN devices during a demand response/load control event.
 */
case class PanDemandResponse
(

    override val sup: EndDeviceAction,

    /**
     * Appliance being controlled.
     */
    val appliance: String,

    /**
     * Used to define a maximum energy usage limit as a percentage of the client implementations specific average energy usage.
     * The load adjustment percentage is added to 100% creating a percentage limit applied to the client implementations specific average energy usage. A -10% load adjustment percentage will establish an energy usage limit equal to 90% of the client implementations specific average energy usage. Each load adjustment percentage is referenced to the client implementations specific average energy usage. There are no cumulative effects.
     */
    val avgLoadAdjustment: Double,

    /**
     * Encoding of cancel control.
     */
    val cancelControlMode: String,

    /**
     * Timestamp when a canceling of the event is scheduled to start.
     */
    val cancelDateTime: String,

    /**
     * If true, a canceling of the event should start immediately.
     */
    val cancelNow: Boolean,

    /**
     * Requested offset to apply to the normal cooling setpoint at the time of the start of the event.
     * It represents a temperature change that will be applied to the associated cooling set point. The temperature offsets will be calculated per the local temperature in the thermostat. The calculated temperature will be interpreted as the number of degrees to be added to the cooling set point. Sequential demand response events are not cumulative. The offset shall be applied to the normal setpoint.
     */
    val coolingOffset: Double,

    /**
     * Requested cooling set point.
     * Temperature set point is typically defined and calculated based on local temperature.
     */
    val coolingSetpoint: Double,

    /**
     * Level of criticality for the action of this control.
     * The action taken by load control devices for an event can be solely based on this value, or in combination with other load control event fields supported by the device.
     */
    val criticalityLevel: String,

    /**
     * Maximum "on" state duty cycle as a percentage of time.
     * For example, if the value is 80, the device would be in an "on" state for 80% of the time for the duration of the action.
     */
    val dutyCycle: Double,

    /**
     * Provides a mechanism to direct load control actions to groups of PAN devices.
     * It can be used in conjunction with the PAN device types.
     */
    val enrollmentGroup: String,

    /**
     * Requested offset to apply to the normal heating setpoint at the time of the start of the event.
     * It represents a temperature change that will be applied to the associated heating set point. The temperature offsets will be calculated per the local temperature in the thermostat. The calculated temperature will be interpreted as the number of degrees to be subtracted from the heating set point. Sequential demand response events are not cumulative. The offset shall be applied to the normal setpoint.
     */
    val heatingOffset: Double,

    /**
     * Requested heating set point.
     * Temperature set point is typically defined and calculated based on local temperature.
     */
    val heatingSetpoint: Double
)
extends
    Element
{
    def this () = { this (null, null, 0.0, null, null, false, 0.0, 0.0, null, 0.0, null, 0.0, 0.0) }
    def EndDeviceAction: EndDeviceAction = sup.asInstanceOf[EndDeviceAction]
    override def copy (): Row = { return (clone ().asInstanceOf[PanDemandResponse]) }
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
    val sup = EndDeviceAction.parse _
    val appliance = parse_attribute (attribute ("""PanDemandResponse.appliance"""))_
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
    def parse (context: Context): PanDemandResponse =
    {
        PanDemandResponse(
            sup (context),
            appliance (context),
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
            toDouble (heatingSetpoint (context), context)
        )
    }
}

/**
 * PAN action/command used to issue the displaying of text messages on PAN devices.
 */
case class PanDisplay
(

    override val sup: EndDeviceAction,

    /**
     * If true, the requesting entity (e.g. retail electric provider) requires confirmation of the successful display of the text message.
     */
    val confirmationRequired: Boolean,

    /**
     * Priority associated with the text message to be displayed.
     */
    val priority: String,

    /**
     * Text to be displayed by a PAN device.
     */
    val textMessage: String,

    /**
     * Transmission mode to be used for this PAN display control.
     */
    val transmissionMode: String
)
extends
    Element
{
    def this () = { this (null, false, null, null, null) }
    def EndDeviceAction: EndDeviceAction = sup.asInstanceOf[EndDeviceAction]
    override def copy (): Row = { return (clone ().asInstanceOf[PanDisplay]) }
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
    val sup = EndDeviceAction.parse _
    val confirmationRequired = parse_element (element ("""PanDisplay.confirmationRequired"""))_
    val priority = parse_element (element ("""PanDisplay.priority"""))_
    val textMessage = parse_element (element ("""PanDisplay.textMessage"""))_
    val transmissionMode = parse_attribute (attribute ("""PanDisplay.transmissionMode"""))_
    def parse (context: Context): PanDisplay =
    {
        PanDisplay(
            sup (context),
            toBoolean (confirmationRequired (context), context),
            priority (context),
            textMessage (context),
            transmissionMode (context)
        )
    }
}

/**
 * PAN action/command used to issue pricing information to a PAN device.
 */
case class PanPricing
(

    override val sup: EndDeviceAction,

    /**
     * Unique identifier for the commodity provider.
     */
    val providerID: Int
)
extends
    Element
{
    def this () = { this (null, 0) }
    def EndDeviceAction: EndDeviceAction = sup.asInstanceOf[EndDeviceAction]
    override def copy (): Row = { return (clone ().asInstanceOf[PanPricing]) }
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
    val sup = EndDeviceAction.parse _
    val providerID = parse_element (element ("""PanPricing.providerID"""))_
    def parse (context: Context): PanPricing =
    {
        PanPricing(
            sup (context),
            toInteger (providerID (context), context)
        )
    }
}

/**
 * Detail for a single price command/action.
 */
case class PanPricingDetail
(

    override val sup: BasicElement,

    /**
     * Alternative measure of the cost of the energy consumed.
     * An example might be the emissions of CO2 for each kWh of electricity consumed providing a measure of the environmental cost.
     */
    val alternateCostDelivered: Double,

    /**
     * Cost unit for the alternate cost delivered field.
     * One example is kg of CO2 per unit of measure.
     */
    val alternateCostUnit: String,

    /**
     * Current time as determined by a PAN device.
     */
    val currentTimeDate: String,

    /**
     * Price of the commodity measured in base unit of currency per 'unitOfMeasure'.
     */
    val generationPrice: Double,

    /**
     * Ratio of 'generationPrice' to the "normal" price chosen by the commodity provider.
     */
    val generationPriceRatio: Double,

    /**
     * Price of the commodity measured in base unit of currency per 'unitOfMeasure'.
     */
    val price: Double,

    /**
     * Ratio of 'price' to the "normal" price chosen by the commodity provider.
     */
    val priceRatio: Double,

    /**
     * Pricing tier as chosen by the commodity provider.
     */
    val priceTier: Int,

    /**
     * Maximum number of price tiers available.
     */
    val priceTierCount: Int,

    /**
     * Label for price tier.
     */
    val priceTierLabel: String,

    /**
     * Label of the current billing rate specified by commodity provider.
     */
    val rateLabel: String,

    /**
     * Register tier accumulating usage information.
     */
    val registerTier: String,

    /**
     * Defines commodity as well as its base unit of measure.
     */
    val unitOfMeasure: String,

    /**
     * PAN pricing command/action issuing this price detail.
     */
    val PanPricing: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null, 0.0, 0.0, 0.0, 0.0, 0, 0, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[PanPricingDetail]) }
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
    val sup = BasicElement.parse _
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
        PanPricingDetail(
            sup (context),
            toDouble (alternateCostDelivered (context), context),
            alternateCostUnit (context),
            currentTimeDate (context),
            toDouble (generationPrice (context), context),
            toDouble (generationPriceRatio (context), context),
            toDouble (price (context), context),
            toDouble (priceRatio (context), context),
            toInteger (priceTier (context), context),
            toInteger (priceTierCount (context), context),
            priceTierLabel (context),
            rateLabel (context),
            registerTier (context),
            unitOfMeasure (context),
            PanPricing (context)
        )
    }
}

/**
 * When present, a scalar conversion that needs to be applied to every IntervalReading.value contained in IntervalBlock.
 * This conversion results in a new associated ReadingType, reflecting the true dimensions of IntervalReading values after the conversion.
 */
case class PendingCalculation
(

    override val sup: BasicElement,

    /**
     * Whether scalars should be applied before adding the 'offset'.
     */
    val multiplyBeforeAdd: Boolean,

    /**
     * (if applicable) Offset to be added as well as multiplication using scalars.
     */
    val offset: Int,

    /**
     * (if scalar is rational number) When 'IntervalReading.value' is multiplied by 'scalarNumerator' and divided by this value, it causes a unit of measure conversion to occur, resulting in the 'ReadingType.unit'.
     */
    val scalarDenominator: Int,

    /**
     * (if scalar is floating number) When multiplied with 'IntervalReading.value', it causes a unit of measure conversion to occur, according to the 'ReadingType.unit'.
     */
    val scalarFloat: Double,

    /**
     * (if scalar is integer or rational number)  When the scalar is a simple integer, and this attribute is presented alone and multiplied with 'IntervalReading.value', it causes a unit of measure conversion to occur, resulting in the 'ReadingType.unit'.
     * It is never used in conjunction with 'scalarFloat', only with 'scalarDenominator'.
     */
    val scalarNumerator: Int,

    /**
     * Reading type resulting from this pending conversion.
     */
    val ReadingType: String
)
extends
    Element
{
    def this () = { this (null, false, 0, 0, 0.0, 0, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[PendingCalculation]) }
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
    val sup = BasicElement.parse _
    val multiplyBeforeAdd = parse_element (element ("""PendingCalculation.multiplyBeforeAdd"""))_
    val offset = parse_element (element ("""PendingCalculation.offset"""))_
    val scalarDenominator = parse_element (element ("""PendingCalculation.scalarDenominator"""))_
    val scalarFloat = parse_element (element ("""PendingCalculation.scalarFloat"""))_
    val scalarNumerator = parse_element (element ("""PendingCalculation.scalarNumerator"""))_
    val ReadingType = parse_attribute (attribute ("""PendingCalculation.ReadingType"""))_
    def parse (context: Context): PendingCalculation =
    {
        PendingCalculation(
            sup (context),
            toBoolean (multiplyBeforeAdd (context), context),
            toInteger (offset (context), context),
            toInteger (scalarDenominator (context), context),
            toDouble (scalarFloat (context), context),
            toInteger (scalarNumerator (context), context),
            ReadingType (context)
        )
    }
}

/**
 * Kind of randomisation to be applied to control the timing of end device control commands and/or the definition of demand response and load control events.
 * Value other than 'none' is typically used to mitigate potential deleterious effects of simultaneous operation of multiple devices.
 */
case class RandomisationKind
(

    override val sup: BasicElement,

    /**
     * Randomisation of start and/or end times involving the operation of one or more devices is controlled by default settings for the device(s).
     */
    val default: String,

    /**
     * End time of an event or control action affecting one or more devices is randomised to prevent simultaneous operation.
     */
    val end: String,

    /**
     * Neither the start time nor the end time of an event or control action affecting one or more devices is randomised.
     */
    val none: String,

    /**
     * Start time of an event or control action affecting one or more multiple devices is randomised.
     */
    val start: String,

    /**
     * Both the start time and the end time of an event or control action affecting one or more devices are randomised to prevent simultaneous operation.
     */
    val startAndEnd: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[RandomisationKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RandomisationKind
extends
    Parseable[RandomisationKind]
{
    val sup = BasicElement.parse _
    val default = parse_attribute (attribute ("""RandomisationKind.default"""))_
    val end = parse_attribute (attribute ("""RandomisationKind.end"""))_
    val none = parse_attribute (attribute ("""RandomisationKind.none"""))_
    val start = parse_attribute (attribute ("""RandomisationKind.start"""))_
    val startAndEnd = parse_attribute (attribute ("""RandomisationKind.startAndEnd"""))_
    def parse (context: Context): RandomisationKind =
    {
        RandomisationKind(
            sup (context),
            default (context),
            end (context),
            none (context),
            start (context),
            startAndEnd (context)
        )
    }
}

/**
 * Rational number = 'numerator' / 'denominator'.
 */
case class RationalNumber
(

    override val sup: BasicElement,

    /**
     * Denominator.
     * Value 1 indicates the number is a simple integer.
     */
    val denominator: Int,

    /**
     * Numerator.
     */
    val numerator: Int
)
extends
    Element
{
    def this () = { this (null, 0, 0) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[RationalNumber]) }
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
    val sup = BasicElement.parse _
    val denominator = parse_element (element ("""RationalNumber.denominator"""))_
    val numerator = parse_element (element ("""RationalNumber.numerator"""))_
    def parse (context: Context): RationalNumber =
    {
        RationalNumber(
            sup (context),
            toInteger (denominator (context), context),
            toInteger (numerator (context), context)
        )
    }
}

/**
 * Specific value measured by a meter or other asset, or calculated by a system.
 * Each Reading is associated with a specific ReadingType.
 */
case class Reading
(

    override val sup: BaseReading,

    /**
     * Reason for this reading being taken.
     */
    val reason: String,

    /**
     * All meter readings (sets of values) containing this reading value.
     */
    val MeterReadings: List[String],

    /**
     * Type information for this reading value.
     */
    val ReadingType: String
)
extends
    Element
{
    def this () = { this (null, null, List(), null) }
    def BaseReading: BaseReading = sup.asInstanceOf[BaseReading]
    override def copy (): Row = { return (clone ().asInstanceOf[Reading]) }
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
    val sup = BaseReading.parse _
    val reason = parse_attribute (attribute ("""Reading.reason"""))_
    val MeterReadings = parse_attributes (attribute ("""Reading.MeterReadings"""))_
    val ReadingType = parse_attribute (attribute ("""Reading.ReadingType"""))_
    def parse (context: Context): Reading =
    {
        Reading(
            sup (context),
            reason (context),
            MeterReadings (context),
            ReadingType (context)
        )
    }
}

/**
 * Interharmonics are represented as a rational number 'numerator' / 'denominator', and harmonics are represented using the same mechanism and identified by 'denominator'=1.
 */
case class ReadingInterharmonic
(

    override val sup: BasicElement,

    /**
     * Interharmonic denominator.
     * Value 0 means not applicable. Value 2 is used in combination with 'numerator'=1 to represent interharmonic 1/2. Finally, value 1 indicates the harmonic of the order specified with 'numerator'.
     */
    val denominator: Int,

    /**
     * Interharmonic numerator.
     * Value 0 means not applicable. Value 1 is used in combination with 'denominator'=2 to represent interharmonic 1/2, and with 'denominator'=1 it represents fundamental frequency. Finally, values greater than 1 indicate the harmonic of that order (e.g., 'numerator'=5 is the fifth harmonic).
     */
    val numerator: Int
)
extends
    Element
{
    def this () = { this (null, 0, 0) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ReadingInterharmonic]) }
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
    val sup = BasicElement.parse _
    val denominator = parse_element (element ("""ReadingInterharmonic.denominator"""))_
    val numerator = parse_element (element ("""ReadingInterharmonic.numerator"""))_
    def parse (context: Context): ReadingInterharmonic =
    {
        ReadingInterharmonic(
            sup (context),
            toInteger (denominator (context), context),
            toInteger (numerator (context), context)
        )
    }
}

/**
 * Quality of a specific reading value or interval reading value.
 * Note that more than one quality may be applicable to a given reading. Typically not used unless problems or unusual conditions occur (i.e., quality for each reading is assumed to be good unless stated otherwise in associated reading quality type). It can also be used with the corresponding reading quality type to indicate that the validation has been performed and succeeded.
 */
case class ReadingQuality
(

    override val sup: BasicElement,

    /**
     * Elaboration on the quality code.
     */
    val comment: String,

    /**
     * System acting as the source of the quality code.
     */
    val source: String,

    /**
     * Date and time at which the quality code was assigned or ascertained.
     */
    val timeStamp: String,

    /**
     * Reading value to which this quality applies.
     */
    val Reading: String,

    /**
     * Type of this reading quality.
     */
    val ReadingQualityType: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ReadingQuality]) }
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
    val sup = BasicElement.parse _
    val comment = parse_element (element ("""ReadingQuality.comment"""))_
    val source = parse_element (element ("""ReadingQuality.source"""))_
    val timeStamp = parse_element (element ("""ReadingQuality.timeStamp"""))_
    val Reading = parse_attribute (attribute ("""ReadingQuality.Reading"""))_
    val ReadingQualityType = parse_attribute (attribute ("""ReadingQuality.ReadingQualityType"""))_
    def parse (context: Context): ReadingQuality =
    {
        ReadingQuality(
            sup (context),
            comment (context),
            source (context),
            timeStamp (context),
            Reading (context),
            ReadingQualityType (context)
        )
    }
}

/**
 * Detailed description for a quality of a reading value, produced by an end device or a system.
 * Values in attributes allow for creation of the recommended codes to be used for identifying reading value quality codes as follows: &lt;systemId&gt;.&lt;category&gt;.&lt;subCategory&gt;.
 */
case class ReadingQualityType
(

    override val sup: IdentifiedObject,

    /**
     * High-level nature of the reading value quality.
     */
    val category: String,

    /**
     * More specific nature of the reading value quality, as a further sub-categorisation of 'category'.
     */
    val subCategory: String,

    /**
     * Identification of the system which has declared the issue with the data or provided commentary on the data.
     */
    val systemId: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ReadingQualityType]) }
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
    val sup = IdentifiedObject.parse _
    val category = parse_element (element ("""ReadingQualityType.category"""))_
    val subCategory = parse_element (element ("""ReadingQualityType.subCategory"""))_
    val systemId = parse_element (element ("""ReadingQualityType.systemId"""))_
    def parse (context: Context): ReadingQualityType =
    {
        ReadingQualityType(
            sup (context),
            category (context),
            subCategory (context),
            systemId (context)
        )
    }
}

/**
 * Reason for the reading being taken.
 */
case class ReadingReasonKind
(

    override val sup: BasicElement,

    /**
     * Reading(s) taken or to be taken in response to a billing-related inquiry by a customer or other party.
     * A variant of 'inquiry'.
     */
    val billing: String,

    /**
     * Reading(s) taken or to be taken in conjunction with the resetting of one or more demand registers in a meter.
     */
    val demandReset: String,

    /**
     * Reading(s) taken or to be taken in response to an inquiry by a customer or other party.
     */
    val inquiry: String,

    /**
     * Reading(s) taken or to be taken in conjunction with installation of a meter.
     */
    val installation: String,

    /**
     * Reading(s) taken or to be taken to support management of loads on distribution networks or devices.
     */
    val loadManagement: String,

    /**
     * Reading(s) taken or to be taken to support research and analysis of loads on distribution networks or devices.
     */
    val loadResearch: String,

    /**
     * Reading(s) taken or to be taken in conjunction with a customer move-in event.
     */
    val moveIn: String,

    /**
     * Reading(s) taken or to be taken in conjunction with a customer move-out event.
     */
    val moveOut: String,

    /**
     * Reading(s) taken or to be taken for some other reason or purpose.
     */
    val other: String,

    /**
     * Reading(s) taken or to be taken in conjunction with removal of a meter.
     */
    val removal: String,

    /**
     * Reading(s) taken or to be taken in conjunction with a connection or re-connection of service.
     */
    val serviceConnect: String,

    /**
     * Reading(s) taken or to be taken in conjunction with a disconnection of service.
     */
    val serviceDisconnect: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ReadingReasonKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ReadingReasonKind
extends
    Parseable[ReadingReasonKind]
{
    val sup = BasicElement.parse _
    val billing = parse_attribute (attribute ("""ReadingReasonKind.billing"""))_
    val demandReset = parse_attribute (attribute ("""ReadingReasonKind.demandReset"""))_
    val inquiry = parse_attribute (attribute ("""ReadingReasonKind.inquiry"""))_
    val installation = parse_attribute (attribute ("""ReadingReasonKind.installation"""))_
    val loadManagement = parse_attribute (attribute ("""ReadingReasonKind.loadManagement"""))_
    val loadResearch = parse_attribute (attribute ("""ReadingReasonKind.loadResearch"""))_
    val moveIn = parse_attribute (attribute ("""ReadingReasonKind.moveIn"""))_
    val moveOut = parse_attribute (attribute ("""ReadingReasonKind.moveOut"""))_
    val other = parse_attribute (attribute ("""ReadingReasonKind.other"""))_
    val removal = parse_attribute (attribute ("""ReadingReasonKind.removal"""))_
    val serviceConnect = parse_attribute (attribute ("""ReadingReasonKind.serviceConnect"""))_
    val serviceDisconnect = parse_attribute (attribute ("""ReadingReasonKind.serviceDisconnect"""))_
    def parse (context: Context): ReadingReasonKind =
    {
        ReadingReasonKind(
            sup (context),
            billing (context),
            demandReset (context),
            inquiry (context),
            installation (context),
            loadManagement (context),
            loadResearch (context),
            moveIn (context),
            moveOut (context),
            other (context),
            removal (context),
            serviceConnect (context),
            serviceDisconnect (context)
        )
    }
}

/**
 * Detailed description for a type of a reading value.
 * Values in attributes allow for the creation of recommended codes to be used for identifying reading value types as follows: &lt;macroPeriod&gt;.&lt;aggregate&gt;.&lt;measuringPeriod&gt;.&lt;accumulation&gt;.&lt;flowDirection&gt;.&lt;commodity&gt;.&lt;measurementKind&gt;.&lt;interharmonic.numerator&gt;.&lt;interharmonic.denominator&gt;.&lt;argument.numerator&gt;.&lt;argument.denominator&gt;.&lt;tou&gt;.&lt;cpp&gt;.&lt;consumptionTier&gt;.&lt;phases&gt;.&lt;multiplier&gt;.&lt;unit&gt;.&lt;currency&gt;.
 */
case class ReadingType
(

    override val sup: IdentifiedObject,

    /**
     * Accumulation behaviour of a reading over time, usually 'measuringPeriod', to be used with individual endpoints (as opposed to 'macroPeriod' and 'aggregate' that are used to describe aggregations of data from individual endpoints).
     */
    val accumulation: String,

    /**
     * Salient attribute of the reading data aggregated from individual endpoints.
     * This is mainly used to define a mathematical operation carried out over 'macroPeriod', but may also be used to describe an attribute of the data when the 'macroPeriod' is not defined.
     */
    val aggregate: String,

    /**
     * Argument used to introduce numbers into the unit of measure description where they are needed (e.g., 4 where the measure needs an argument such as CEMI(n=4)).
     * Most arguments used in practice however will be integers (i.e., 'denominator'=1).
     */
    val argument: String,

    /**
     * Commodity being measured.
     */
    val commodity: String,

    /**
     * In case of common flat-rate pricing for power, in which all purchases are at a given rate, 'consumptionTier'=0.
     * Otherwise, the value indicates the consumption tier, which can be used in conjunction with TOU or CPP pricing.
     */
    val consumptionTier: Int,

    /**
     * Critical peak period (CPP) bucket the reading value is attributed to.
     * Value 0 means not applicable. Even though CPP is usually considered a specialised form of time of use 'tou', this attribute is defined explicitly for flexibility.
     */
    val cpp: Int,

    /**
     * Metering-specific currency.
     */
    val currency: String,

    /**
     * Flow direction for a reading where the direction of flow of the commodity is important (for electricity measurements this includes current, energy, power, and demand).
     */
    val flowDirection: String,

    /**
     * Indication of a "harmonic" or "interharmonic" basis for the measurement.
     * Value 0 in 'numerator' and 'denominator' means not applicable.
     */
    val interharmonic: String,

    /**
     * Time period of interest that reflects how the reading is viewed or captured over a long period of time.
     */
    val macroPeriod: String,

    /**
     * Identifies "what" is being measured, as refinement of 'commodity'.
     * When combined with 'unit', it provides detail to the unit of measure. For example, 'energy' with a unit of measure of 'kWh' indicates to the user that active energy is being measured, while with 'kVAh' or 'kVArh', it indicates apparent energy and reactive energy, respectively. 'power' can be combined in a similar way with various power units of measure: Distortion power ('distortionVoltAmperes') with 'kVA' is different from 'power' with 'kVA'.
     */
    val measurementKind: String,

    /**
     * Time attribute inherent or fundamental to the reading value (as opposed to 'macroPeriod' that supplies an "adjective" to describe aspects of a time period with regard to the measurement).
     * It refers to the way the value was originally measured and not to the frequency at which it is reported or presented. For example, an hourly interval of consumption data would have value 'hourly' as an attribute. However in the case of an hourly sampled voltage value, the meterReadings schema would carry the 'hourly' interval size information.
     */
    val measuringPeriod: String,

    /**
     * Metering-specific multiplier.
     */
    val multiplier: String,

    /**
     * Metering-specific phase code.
     */
    val phases: String,

    /**
     * Time of use (TOU) bucket the reading value is attributed to.
     * Value 0 means not applicable.
     */
    val tou: Int,

    /**
     * Metering-specific unit.
     */
    val unit: String,

    /**
     * Channel reporting/collecting register values with this type information.
     */
    val Channel: String,

    /**
     * Pending calculation that produced this reading type.
     */
    val PendingCalculation: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, 0, 0, null, null, null, null, null, null, null, null, 0, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ReadingType]) }
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
    val sup = IdentifiedObject.parse _
    val accumulation = parse_element (element ("""ReadingType.accumulation"""))_
    val aggregate = parse_element (element ("""ReadingType.aggregate"""))_
    val argument = parse_attribute (attribute ("""ReadingType.argument"""))_
    val commodity = parse_element (element ("""ReadingType.commodity"""))_
    val consumptionTier = parse_element (element ("""ReadingType.consumptionTier"""))_
    val cpp = parse_element (element ("""ReadingType.cpp"""))_
    val currency = parse_element (element ("""ReadingType.currency"""))_
    val flowDirection = parse_element (element ("""ReadingType.flowDirection"""))_
    val interharmonic = parse_attribute (attribute ("""ReadingType.interharmonic"""))_
    val macroPeriod = parse_element (element ("""ReadingType.macroPeriod"""))_
    val measurementKind = parse_element (element ("""ReadingType.measurementKind"""))_
    val measuringPeriod = parse_element (element ("""ReadingType.measuringPeriod"""))_
    val multiplier = parse_element (element ("""ReadingType.multiplier"""))_
    val phases = parse_element (element ("""ReadingType.phases"""))_
    val tou = parse_element (element ("""ReadingType.tou"""))_
    val unit = parse_element (element ("""ReadingType.unit"""))_
    val Channel = parse_attribute (attribute ("""ReadingType.Channel"""))_
    val PendingCalculation = parse_attribute (attribute ("""ReadingType.PendingCalculation"""))_
    def parse (context: Context): ReadingType =
    {
        ReadingType(
            sup (context),
            accumulation (context),
            aggregate (context),
            argument (context),
            commodity (context),
            toInteger (consumptionTier (context), context),
            toInteger (cpp (context), context),
            currency (context),
            flowDirection (context),
            interharmonic (context),
            macroPeriod (context),
            measurementKind (context),
            measuringPeriod (context),
            multiplier (context),
            phases (context),
            toInteger (tou (context), context),
            unit (context),
            Channel (context),
            PendingCalculation (context)
        )
    }
}

/**
 * A device that indicates or records units of the commodity or other quantity measured.
 */
case class Register
(

    override val sup: IdentifiedObject,

    /**
     * If true, the data it produces is  calculated or measured by a device other than a physical end device/meter.
     * Otherwise, any data streams it produces are measured by the hardware of the end device/meter itself.
     */
    val isVirtual: Boolean,

    /**
     * Number of digits (dials on a mechanical meter) to the left of the decimal place; default is normally 5.
     */
    val leftDigitCount: Int,

    /**
     * Number of digits (dials on a mechanical meter) to the right of the decimal place.
     */
    val rightDigitCount: Int,

    /**
     * Clock time interval for register to beging/cease accumulating time of usage (e.g., start at 8:00 am, stop at 5:00 pm).
     */
    val touTier: String,

    /**
     * Name used for the time of use tier (also known as bin or bucket).
     * For example, "peak", "off-peak", "TOU Category A", etc.
     */
    val touTierName: String,

    /**
     * End device function metering quantities displayed by this register.
     */
    val EndDeviceFunction: String
)
extends
    Element
{
    def this () = { this (null, false, 0, 0, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Register]) }
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
    val sup = IdentifiedObject.parse _
    val isVirtual = parse_element (element ("""Register.isVirtual"""))_
    val leftDigitCount = parse_element (element ("""Register.leftDigitCount"""))_
    val rightDigitCount = parse_element (element ("""Register.rightDigitCount"""))_
    val touTier = parse_attribute (attribute ("""Register.touTier"""))_
    val touTierName = parse_element (element ("""Register.touTierName"""))_
    val EndDeviceFunction = parse_attribute (attribute ("""Register.EndDeviceFunction"""))_
    def parse (context: Context): Register =
    {
        Register(
            sup (context),
            toBoolean (isVirtual (context), context),
            toInteger (leftDigitCount (context), context),
            toInteger (rightDigitCount (context), context),
            touTier (context),
            touTierName (context),
            EndDeviceFunction (context)
        )
    }
}

/**
 * Multiplier applied at the usage point.
 */
case class ServiceMultiplier
(

    override val sup: IdentifiedObject,

    /**
     * Kind of multiplier.
     */
    val kind: String,

    /**
     * Multiplier value.
     */
    val value: Double,

    /**
     * Usage point applying this multiplier.
     */
    val UsagePoint: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ServiceMultiplier]) }
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
    val sup = IdentifiedObject.parse _
    val kind = parse_attribute (attribute ("""ServiceMultiplier.kind"""))_
    val value = parse_element (element ("""ServiceMultiplier.value"""))_
    val UsagePoint = parse_attribute (attribute ("""ServiceMultiplier.UsagePoint"""))_
    def parse (context: Context): ServiceMultiplier =
    {
        ServiceMultiplier(
            sup (context),
            kind (context),
            toDouble (value (context), context),
            UsagePoint (context)
        )
    }
}

/**
 * Kind of service multiplier.
 */
case class ServiceMultiplierKind
(

    override val sup: BasicElement,

    /**
     * Current transformer ratio used to convert associated quantities to real measurements.
     */
    val ctRatio: String,

    /**
     * Voltage transformer ratio used to convert associated quantities to real measurements.
     */
    val ptRatio: String,

    /**
     * Product of the CT ratio and PT ratio.
     */
    val transformerRatio: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ServiceMultiplierKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ServiceMultiplierKind
extends
    Parseable[ServiceMultiplierKind]
{
    val sup = BasicElement.parse _
    val ctRatio = parse_attribute (attribute ("""ServiceMultiplierKind.ctRatio"""))_
    val ptRatio = parse_attribute (attribute ("""ServiceMultiplierKind.ptRatio"""))_
    val transformerRatio = parse_attribute (attribute ("""ServiceMultiplierKind.transformerRatio"""))_
    def parse (context: Context): ServiceMultiplierKind =
    {
        ServiceMultiplierKind(
            sup (context),
            ctRatio (context),
            ptRatio (context),
            transformerRatio (context)
        )
    }
}

/**
 * Simple end device function distinguished by 'kind'.
 * Use this class for instances that cannot be represented by another end device function specialisations.
 */
case class SimpleEndDeviceFunction
(

    override val sup: EndDeviceFunction,

    /**
     * Kind of this function.
     */
    val kind: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def EndDeviceFunction: EndDeviceFunction = sup.asInstanceOf[EndDeviceFunction]
    override def copy (): Row = { return (clone ().asInstanceOf[SimpleEndDeviceFunction]) }
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
    val sup = EndDeviceFunction.parse _
    val kind = parse_attribute (attribute ("""SimpleEndDeviceFunction.kind"""))_
    def parse (context: Context): SimpleEndDeviceFunction =
    {
        SimpleEndDeviceFunction(
            sup (context),
            kind (context)
        )
    }
}

/**
 * Transmission mode for end device display controls, applicable to premises area network (PAN) devices.
 */
case class TransmissionModeKind
(

    override val sup: BasicElement,

    /**
     * Message transmission mode whereby messages or commands are broadcast to unspecified devices listening for such communications.
     */
    val anonymous: String,

    /**
     * Message transmission mode whereby messages or commands are sent by both 'normal' and 'anonymous' methods.
     */
    val both: String,

    /**
     * Message transmission mode whereby messages or commands are sent to specific devices.
     */
    val normal: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[TransmissionModeKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TransmissionModeKind
extends
    Parseable[TransmissionModeKind]
{
    val sup = BasicElement.parse _
    val anonymous = parse_attribute (attribute ("""TransmissionModeKind.anonymous"""))_
    val both = parse_attribute (attribute ("""TransmissionModeKind.both"""))_
    val normal = parse_attribute (attribute ("""TransmissionModeKind.normal"""))_
    def parse (context: Context): TransmissionModeKind =
    {
        TransmissionModeKind(
            sup (context),
            anonymous (context),
            both (context),
            normal (context)
        )
    }
}

/**
 * Logical or physical point in the network to which readings or events may be attributed.
 * Used at the place where a physical or virtual meter may be located; however, it is not required that a meter be present.
 */
case class UsagePoint
(

    override val sup: IdentifiedObject,

    /**
     * Tracks the lifecycle of the metering installation at a usage point with respect to readiness for billing via advanced metering infrastructure reads.
     */
    val amiBillingReady: String,

    /**
     * True if as a result of an inspection or otherwise, there is a reason to suspect that a previous billing may have been performed with erroneous data.
     * Value should be reset once this potential discrepancy has been resolved.
     */
    val checkBilling: Boolean,

    /**
     * State of the usage point with respect to connection to the network.
     */
    val connectionState: String,

    /**
     * Estimated load.
     */
    val estimatedLoad: Double,

    /**
     * True if grounded.
     */
    val grounded: Boolean,

    /**
     * If true, this usage point is a service delivery point, i.e., a usage point where the ownership of the service changes hands.
     */
    val isSdp: Boolean,

    /**
     * If true, this usage point is virtual, i.e., no physical location exists in the network where a meter could be located to collect the meter readings.
     * For example, one may define a virtual usage point to serve as an aggregation of usage for all of a company's premises distributed widely across the distribution territory. Otherwise, the usage point is physical, i.e., there is a logical point in the network where a meter could be located to collect meter readings.
     */
    val isVirtual: Boolean,

    /**
     * If true, minimal or zero usage is expected at this usage point for situations such as premises vacancy, logical or physical disconnect.
     * It is used for readings validation and estimation.
     */
    val minimalUsageExpected: Boolean,

    /**
     * Nominal service voltage.
     */
    val nominalServiceVoltage: Double,

    /**
     * Outage region in which this usage point is located.
     */
    val outageRegion: String,

    /**
     * Phase code.
     * Number of wires and specific nominal phases can be deduced from enumeration literal values. For example, ABCN is three-phase, four-wire, s12n (splitSecondary12N) is single-phase, three-wire, and s1n and s2n are single-phase, two-wire.
     */
    val phaseCode: String,

    /**
     * Current flow that this usage point is configured to deliver.
     */
    val ratedCurrent: Double,

    /**
     * Active power that this usage point is configured to deliver.
     */
    val ratedPower: Double,

    /**
     * Cycle day on which the meter for this usage point will normally be read.
     * Usually correlated with the billing cycle.
     */
    val readCycle: String,

    /**
     * Identifier of the route to which this usage point is assigned for purposes of meter reading.
     * Typically used to configure hand held meter reading systems prior to collection of reads.
     */
    val readRoute: String,

    /**
     * Remarks about this usage point, for example the reason for it being rated with a non-nominal priority.
     */
    val serviceDeliveryRemark: String,

    /**
     * Priority of service for this usage point.
     * Note that usage points at the same service location can have different priorities.
     */
    val servicePriority: String,

    /**
     * Customer agreement regulating this service delivery point.
     */
    val CustomerAgreement: String,

    /**
     * All equipment connecting this usage point to the electrical grid.
     */
    val Equipments: List[String],

    /**
     * Service category delivered by this usage point.
     */
    val ServiceCategory: String,

    /**
     * Service location where the service delivered by this usage point is consumed.
     */
    val ServiceLocation: String,

    /**
     * ServiceSupplier (utility) utilising this usage point to deliver a service.
     */
    val ServiceSupplier: String,

    /**
     * Location of this usage point.
     */
    val UsagePointLocation: String
)
extends
    Element
{
    def this () = { this (null, null, false, null, 0.0, false, false, false, false, 0.0, null, null, 0.0, 0.0, null, null, null, null, null, List(), null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[UsagePoint]) }
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
    val sup = IdentifiedObject.parse _
    val amiBillingReady = parse_attribute (attribute ("""UsagePoint.amiBillingReady"""))_
    val checkBilling = parse_element (element ("""UsagePoint.checkBilling"""))_
    val connectionState = parse_attribute (attribute ("""UsagePoint.connectionState"""))_
    val estimatedLoad = parse_element (element ("""UsagePoint.estimatedLoad"""))_
    val grounded = parse_element (element ("""UsagePoint.grounded"""))_
    val isSdp = parse_element (element ("""UsagePoint.isSdp"""))_
    val isVirtual = parse_element (element ("""UsagePoint.isVirtual"""))_
    val minimalUsageExpected = parse_element (element ("""UsagePoint.minimalUsageExpected"""))_
    val nominalServiceVoltage = parse_element (element ("""UsagePoint.nominalServiceVoltage"""))_
    val outageRegion = parse_element (element ("""UsagePoint.outageRegion"""))_
    val phaseCode = parse_attribute (attribute ("""UsagePoint.phaseCode"""))_
    val ratedCurrent = parse_element (element ("""UsagePoint.ratedCurrent"""))_
    val ratedPower = parse_element (element ("""UsagePoint.ratedPower"""))_
    val readCycle = parse_element (element ("""UsagePoint.readCycle"""))_
    val readRoute = parse_element (element ("""UsagePoint.readRoute"""))_
    val serviceDeliveryRemark = parse_element (element ("""UsagePoint.serviceDeliveryRemark"""))_
    val servicePriority = parse_element (element ("""UsagePoint.servicePriority"""))_
    val CustomerAgreement = parse_attribute (attribute ("""UsagePoint.CustomerAgreement"""))_
    val Equipments = parse_attributes (attribute ("""UsagePoint.Equipments"""))_
    val ServiceCategory = parse_attribute (attribute ("""UsagePoint.ServiceCategory"""))_
    val ServiceLocation = parse_attribute (attribute ("""UsagePoint.ServiceLocation"""))_
    val ServiceSupplier = parse_attribute (attribute ("""UsagePoint.ServiceSupplier"""))_
    val UsagePointLocation = parse_attribute (attribute ("""UsagePoint.UsagePointLocation"""))_
    def parse (context: Context): UsagePoint =
    {
        UsagePoint(
            sup (context),
            amiBillingReady (context),
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
            Equipments (context),
            ServiceCategory (context),
            ServiceLocation (context),
            ServiceSupplier (context),
            UsagePointLocation (context)
        )
    }
}

/**
 * State of the usage point with respect to connection to the network.
 */
case class UsagePointConnectedKind
(

    override val sup: BasicElement,

    /**
     * The usage point is connected to the network and able to receive or send the applicable commodity (electricity, gas, water, etc.).
     */
    val connected: String,

    /**
     * The usage point has been disconnected through operation of a disconnect function within the meter present at the usage point.
     * The usage point is unable to receive or send the applicable commodity (electricity, gas, water, etc.)  A logical disconnect can often be achieved without utilising a field crew.
     */
    val logicallyDisconnected: String,

    /**
     * The usage point has been disconnected from the network at a point upstream of the meter.
     * The usage point is unable to receive or send the applicable commodity (electricity, gas, water, etc.). A physical disconnect is often achieved by utilising a field crew.
     */
    val physicallyDisconnected: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[UsagePointConnectedKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object UsagePointConnectedKind
extends
    Parseable[UsagePointConnectedKind]
{
    val sup = BasicElement.parse _
    val connected = parse_attribute (attribute ("""UsagePointConnectedKind.connected"""))_
    val logicallyDisconnected = parse_attribute (attribute ("""UsagePointConnectedKind.logicallyDisconnected"""))_
    val physicallyDisconnected = parse_attribute (attribute ("""UsagePointConnectedKind.physicallyDisconnected"""))_
    def parse (context: Context): UsagePointConnectedKind =
    {
        UsagePointConnectedKind(
            sup (context),
            connected (context),
            logicallyDisconnected (context),
            physicallyDisconnected (context)
        )
    }
}

/**
 * Abstraction for management of group communications within a two-way AMR system or the data for a group of related usage points.
 * Commands can be issued to all of the usage points that belong to a usage point group using a defined group address and the underlying AMR communication infrastructure.
 */
case class UsagePointGroup
(

    override val sup: IdentifiedObject,

    /**
     * Type of this group.
     */
    val typ: String,

    /**
     * All usage points in this group.
     */
    val UsagePoints: List[String]
)
extends
    Element
{
    def this () = { this (null, null, List()) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[UsagePointGroup]) }
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
    val sup = IdentifiedObject.parse _
    val typ = parse_element (element ("""UsagePointGroup.type"""))_
    val UsagePoints = parse_attributes (attribute ("""UsagePointGroup.UsagePoints"""))_
    def parse (context: Context): UsagePointGroup =
    {
        UsagePointGroup(
            sup (context),
            typ (context),
            UsagePoints (context)
        )
    }
}

/**
 * Location of an individual usage point.
 */
case class UsagePointLocation
(

    override val sup: Location,

    /**
     * Method for the service person to access this usage point location.
     * For example, a description of where to obtain a key if the facility is unmanned and secured.
     */
    val accessMethod: String,

    /**
     * Remarks about this location.
     */
    val remark: String,

    /**
     * Problems previously encountered when visiting or performing work at this location.
     * Examples include: bad dog, violent customer, verbally abusive occupant, obstructions, safety hazards, etc.
     */
    val siteAccessProblem: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Location: Location = sup.asInstanceOf[Location]
    override def copy (): Row = { return (clone ().asInstanceOf[UsagePointLocation]) }
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
    val sup = Location.parse _
    val accessMethod = parse_element (element ("""UsagePointLocation.accessMethod"""))_
    val remark = parse_element (element ("""UsagePointLocation.remark"""))_
    val siteAccessProblem = parse_element (element ("""UsagePointLocation.siteAccessProblem"""))_
    def parse (context: Context): UsagePointLocation =
    {
        UsagePointLocation(
            sup (context),
            accessMethod (context),
            remark (context),
            siteAccessProblem (context)
        )
    }
}

object _Metering
{
    def register: Unit =
    {
        AmiBillingReadyKind.register
        BaseReading.register
        Channel.register
        ComDirectionKind.register
        ComFunction.register
        ComModule.register
        ComTechnologyKind.register
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
        EndDeviceFunctionKind.register
        EndDeviceGroup.register
        EndDeviceInfo.register
        EndDeviceTiming.register
        IntervalBlock.register
        IntervalReading.register
        Meter.register
        MeterMultiplier.register
        MeterMultiplierKind.register
        MeterReading.register
        MeterServiceWork.register
        MetrologyRequirement.register
        PanDemandResponse.register
        PanDisplay.register
        PanPricing.register
        PanPricingDetail.register
        PendingCalculation.register
        RandomisationKind.register
        RationalNumber.register
        Reading.register
        ReadingInterharmonic.register
        ReadingQuality.register
        ReadingQualityType.register
        ReadingReasonKind.register
        ReadingType.register
        Register.register
        ServiceMultiplier.register
        ServiceMultiplierKind.register
        SimpleEndDeviceFunction.register
        TransmissionModeKind.register
        UsagePoint.register
        UsagePointConnectedKind.register
        UsagePointGroup.register
        UsagePointLocation.register
    }
}