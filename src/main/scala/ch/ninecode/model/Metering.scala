package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * This package contains the core information classes that support end device applications with specialized classes for metering and premises area network devices, and remote reading functions.
 * These classes are generally associated with the point where a service is delivered to the customer.
 */

/**
 * Lifecycle states of the metering installation at a usage point with respect to readiness for billing via advanced metering infrastructure reads.
 * @param sup Reference to the superclass object.
 * @param amiCapable Usage point is equipped with an AMI capable meter that is not yet currently equipped with a communications module.
 * @param amiDisabled Usage point is equipped with an AMI capable meter; however, the AMI functionality has been disabled or is not being used.
 * @param billingApproved Usage point is equipped with an operating AMI capable meter and accuracy has been certified for billing purposes.
 * @param enabled Usage point is equipped with an AMI capable meter having communications capability.
 * @param nonAmi Usage point is equipped with a non AMI capable meter.
 * @param nonMetered Usage point is not currently equipped with a meter.
 * @param operable Usage point is equipped with an AMI capable meter that is functioning and communicating with the AMI network.
 */
case class AmiBillingReadyKind
(
    override val sup: BasicElement,
    val amiCapable: String,
    val amiDisabled: String,
    val billingApproved: String,
    val enabled: String,
    val nonAmi: String,
    val nonMetered: String,
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
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != amiCapable) "\t\t<cim:AmiBillingReadyKind.amiCapable rdf:resource=\"#" + amiCapable + "\"/>\n" else "") +
        (if (null != amiDisabled) "\t\t<cim:AmiBillingReadyKind.amiDisabled rdf:resource=\"#" + amiDisabled + "\"/>\n" else "") +
        (if (null != billingApproved) "\t\t<cim:AmiBillingReadyKind.billingApproved rdf:resource=\"#" + billingApproved + "\"/>\n" else "") +
        (if (null != enabled) "\t\t<cim:AmiBillingReadyKind.enabled rdf:resource=\"#" + enabled + "\"/>\n" else "") +
        (if (null != nonAmi) "\t\t<cim:AmiBillingReadyKind.nonAmi rdf:resource=\"#" + nonAmi + "\"/>\n" else "") +
        (if (null != nonMetered) "\t\t<cim:AmiBillingReadyKind.nonMetered rdf:resource=\"#" + nonMetered + "\"/>\n" else "") +
        (if (null != operable) "\t\t<cim:AmiBillingReadyKind.operable rdf:resource=\"#" + operable + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AmiBillingReadyKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AmiBillingReadyKind>\n"
    }
}

object AmiBillingReadyKind
extends
    Parseable[AmiBillingReadyKind]
{
    val amiCapable = parse_attribute (attribute ("""AmiBillingReadyKind.amiCapable"""))
    val amiDisabled = parse_attribute (attribute ("""AmiBillingReadyKind.amiDisabled"""))
    val billingApproved = parse_attribute (attribute ("""AmiBillingReadyKind.billingApproved"""))
    val enabled = parse_attribute (attribute ("""AmiBillingReadyKind.enabled"""))
    val nonAmi = parse_attribute (attribute ("""AmiBillingReadyKind.nonAmi"""))
    val nonMetered = parse_attribute (attribute ("""AmiBillingReadyKind.nonMetered"""))
    val operable = parse_attribute (attribute ("""AmiBillingReadyKind.operable"""))
    def parse (context: Context): AmiBillingReadyKind =
    {
        AmiBillingReadyKind(
            BasicElement.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param reportedDateTime (used only when there are detailed auditing requirements) Date and time at which the reading was first delivered to the metering system.
 * @param source System that originally supplied the reading (e.g., customer, AMI system, handheld reading system, another enterprise system, etc.).
 * @param timePeriod Start and end of the period for those readings whose type has a time attribute such as 'billing', seasonal' or 'forTheSpecifiedPeriod'.
 * @param value Value of this reading.
 */
case class BaseReading
(
    override val sup: MeasurementValue,
    val reportedDateTime: String,
    val source: String,
    val timePeriod: String,
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
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != reportedDateTime) "\t\t<cim:BaseReading.reportedDateTime>" + reportedDateTime + "</cim:BaseReading.reportedDateTime>\n" else "") +
        (if (null != source) "\t\t<cim:BaseReading.source>" + source + "</cim:BaseReading.source>\n" else "") +
        (if (null != timePeriod) "\t\t<cim:BaseReading.timePeriod rdf:resource=\"#" + timePeriod + "\"/>\n" else "") +
        (if (null != value) "\t\t<cim:BaseReading.value>" + value + "</cim:BaseReading.value>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:BaseReading rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:BaseReading>\n"
    }
}

object BaseReading
extends
    Parseable[BaseReading]
{
    val reportedDateTime = parse_element (element ("""BaseReading.reportedDateTime"""))
    val source = parse_element (element ("""BaseReading.source"""))
    val timePeriod = parse_attribute (attribute ("""BaseReading.timePeriod"""))
    val value = parse_element (element ("""BaseReading.value"""))
    def parse (context: Context): BaseReading =
    {
        BaseReading(
            MeasurementValue.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param isVirtual If true, the data is being calculated by an enterprise system rather than metered directly.
 * @param ReadingType Reading type for register values reported/collected by this channel.
 * @param Register Register whose values are collected/reported by this channel.
 */
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
    override def copy (): Row = { return (clone ().asInstanceOf[Channel]) }
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
        "\t\t<cim:Channel.isVirtual>" + isVirtual + "</cim:Channel.isVirtual>\n" +
        (if (null != ReadingType) "\t\t<cim:Channel.ReadingType rdf:resource=\"#" + ReadingType + "\"/>\n" else "") +
        (if (null != Register) "\t\t<cim:Channel.Register rdf:resource=\"#" + Register + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Channel rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Channel>\n"
    }
}

object Channel
extends
    Parseable[Channel]
{
    val isVirtual = parse_element (element ("""Channel.isVirtual"""))
    val ReadingType = parse_attribute (attribute ("""Channel.ReadingType"""))
    val Register = parse_attribute (attribute ("""Channel.Register"""))
    def parse (context: Context): Channel =
    {
        Channel(
            IdentifiedObject.parse (context),
            toBoolean (isVirtual (context), context),
            ReadingType (context),
            Register (context)
        )
    }
}

/**
 * Kind of communication direction.
 * @param sup Reference to the superclass object.
 * @param biDirectional Communication with the device is bi-directional.
 * @param fromDevice Communication is from device.
 * @param toDevice Communication is to device.
 */
case class ComDirectionKind
(
    override val sup: BasicElement,
    val biDirectional: String,
    val fromDevice: String,
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
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != biDirectional) "\t\t<cim:ComDirectionKind.biDirectional rdf:resource=\"#" + biDirectional + "\"/>\n" else "") +
        (if (null != fromDevice) "\t\t<cim:ComDirectionKind.fromDevice rdf:resource=\"#" + fromDevice + "\"/>\n" else "") +
        (if (null != toDevice) "\t\t<cim:ComDirectionKind.toDevice rdf:resource=\"#" + toDevice + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ComDirectionKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ComDirectionKind>\n"
    }
}

object ComDirectionKind
extends
    Parseable[ComDirectionKind]
{
    val biDirectional = parse_attribute (attribute ("""ComDirectionKind.biDirectional"""))
    val fromDevice = parse_attribute (attribute ("""ComDirectionKind.fromDevice"""))
    val toDevice = parse_attribute (attribute ("""ComDirectionKind.toDevice"""))
    def parse (context: Context): ComDirectionKind =
    {
        ComDirectionKind(
            BasicElement.parse (context),
            biDirectional (context),
            fromDevice (context),
            toDevice (context)
        )
    }
}

/**
 * Communication function of communication equipment or a device such as a meter.
 * @param sup Reference to the superclass object.
 * @param amrAddress Communication ID number (e.g. serial number, IP address, telephone number, etc.) of the AMR module which serves this meter.
 * @param amrRouter Communication ID number (e.g. port number, serial number, data collector ID, etc.) of the parent device associated to this AMR module.
 * @param direction Kind of communication direction.
 * @param technology Kind of communication technology.
 * @param ComModule Module performing this communication function.
 */
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
    override def copy (): Row = { return (clone ().asInstanceOf[ComFunction]) }
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
        (if (null != amrAddress) "\t\t<cim:ComFunction.amrAddress>" + amrAddress + "</cim:ComFunction.amrAddress>\n" else "") +
        (if (null != amrRouter) "\t\t<cim:ComFunction.amrRouter>" + amrRouter + "</cim:ComFunction.amrRouter>\n" else "") +
        (if (null != direction) "\t\t<cim:ComFunction.direction rdf:resource=\"#" + direction + "\"/>\n" else "") +
        (if (null != technology) "\t\t<cim:ComFunction.technology rdf:resource=\"#" + technology + "\"/>\n" else "") +
        (if (null != ComModule) "\t\t<cim:ComFunction.ComModule rdf:resource=\"#" + ComModule + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ComFunction rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ComFunction>\n"
    }
}

object ComFunction
extends
    Parseable[ComFunction]
{
    val amrAddress = parse_element (element ("""ComFunction.amrAddress"""))
    val amrRouter = parse_element (element ("""ComFunction.amrRouter"""))
    val direction = parse_attribute (attribute ("""ComFunction.direction"""))
    val technology = parse_attribute (attribute ("""ComFunction.technology"""))
    val ComModule = parse_attribute (attribute ("""ComFunction.ComModule"""))
    def parse (context: Context): ComFunction =
    {
        ComFunction(
            EndDeviceFunction.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param amrSystem Automated meter reading (AMR) system communicating with this com module.
 * @param supportsAutonomousDst If true, autonomous daylight saving time (DST) function is supported.
 * @param timeZoneOffset Time zone offset relative to GMT for the location of this com module.
 */
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
    override def copy (): Row = { return (clone ().asInstanceOf[ComModule]) }
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
        (if (null != amrSystem) "\t\t<cim:ComModule.amrSystem>" + amrSystem + "</cim:ComModule.amrSystem>\n" else "") +
        "\t\t<cim:ComModule.supportsAutonomousDst>" + supportsAutonomousDst + "</cim:ComModule.supportsAutonomousDst>\n" +
        "\t\t<cim:ComModule.timeZoneOffset>" + timeZoneOffset + "</cim:ComModule.timeZoneOffset>\n"
    }
    override def export: String =
    {
        "\t<cim:ComModule rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ComModule>\n"
    }
}

object ComModule
extends
    Parseable[ComModule]
{
    val amrSystem = parse_element (element ("""ComModule.amrSystem"""))
    val supportsAutonomousDst = parse_element (element ("""ComModule.supportsAutonomousDst"""))
    val timeZoneOffset = parse_element (element ("""ComModule.timeZoneOffset"""))
    def parse (context: Context): ComModule =
    {
        ComModule(
            Asset.parse (context),
            amrSystem (context),
            toBoolean (supportsAutonomousDst (context), context),
            toDouble (timeZoneOffset (context), context)
        )
    }
}

/**
 * Kind of communication technology.
 * @param sup Reference to the superclass object.
 * @param cellular Communicates using a public cellular radio network.
 *        A specific variant of 'rf'.
 * @param ethernet Communicates using one or more of a family of frame-based computer networking technologies conforming to the IEEE 802.3 standard.
 * @param homePlug Communicates using power line communication technologies conforming to the standards established by the HomePlug Powerline Alliance.
 *        A specific variant of 'plc'.
 * @param pager Communicates using a public one-way or two-way radio-based paging network.
 *        A specific variant of 'rf'.
 * @param phone Communicates using a basic, wireline telephone system.
 * @param plc Communicates using power line communication technologies.
 * @param rf Communicates using private or public radio-based technology.
 * @param rfMesh Communicates using a mesh radio technology.
 *        A specific variant of 'rf'.
 * @param zigbee Communicates using radio communication technologies conforming to the standards established by the ZigBee.
 *        A specific variant of 'rf'.
 */
case class ComTechnologyKind
(
    override val sup: BasicElement,
    val cellular: String,
    val ethernet: String,
    val homePlug: String,
    val pager: String,
    val phone: String,
    val plc: String,
    val rf: String,
    val rfMesh: String,
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
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != cellular) "\t\t<cim:ComTechnologyKind.cellular rdf:resource=\"#" + cellular + "\"/>\n" else "") +
        (if (null != ethernet) "\t\t<cim:ComTechnologyKind.ethernet rdf:resource=\"#" + ethernet + "\"/>\n" else "") +
        (if (null != homePlug) "\t\t<cim:ComTechnologyKind.homePlug rdf:resource=\"#" + homePlug + "\"/>\n" else "") +
        (if (null != pager) "\t\t<cim:ComTechnologyKind.pager rdf:resource=\"#" + pager + "\"/>\n" else "") +
        (if (null != phone) "\t\t<cim:ComTechnologyKind.phone rdf:resource=\"#" + phone + "\"/>\n" else "") +
        (if (null != plc) "\t\t<cim:ComTechnologyKind.plc rdf:resource=\"#" + plc + "\"/>\n" else "") +
        (if (null != rf) "\t\t<cim:ComTechnologyKind.rf rdf:resource=\"#" + rf + "\"/>\n" else "") +
        (if (null != rfMesh) "\t\t<cim:ComTechnologyKind.rfMesh rdf:resource=\"#" + rfMesh + "\"/>\n" else "") +
        (if (null != zigbee) "\t\t<cim:ComTechnologyKind.zigbee rdf:resource=\"#" + zigbee + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ComTechnologyKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ComTechnologyKind>\n"
    }
}

object ComTechnologyKind
extends
    Parseable[ComTechnologyKind]
{
    val cellular = parse_attribute (attribute ("""ComTechnologyKind.cellular"""))
    val ethernet = parse_attribute (attribute ("""ComTechnologyKind.ethernet"""))
    val homePlug = parse_attribute (attribute ("""ComTechnologyKind.homePlug"""))
    val pager = parse_attribute (attribute ("""ComTechnologyKind.pager"""))
    val phone = parse_attribute (attribute ("""ComTechnologyKind.phone"""))
    val plc = parse_attribute (attribute ("""ComTechnologyKind.plc"""))
    val rf = parse_attribute (attribute ("""ComTechnologyKind.rf"""))
    val rfMesh = parse_attribute (attribute ("""ComTechnologyKind.rfMesh"""))
    val zigbee = parse_attribute (attribute ("""ComTechnologyKind.zigbee"""))
    def parse (context: Context): ComTechnologyKind =
    {
        ComTechnologyKind(
            BasicElement.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param isElectricVehicle True if the appliance is an electric vehicle.
 * @param isExteriorLighting True if the appliance is exterior lighting.
 * @param isGenerationSystem True if the appliance is a generation system.
 * @param isHvacCompressorOrFurnace True if the appliance is HVAC compressor or furnace.
 * @param isInteriorLighting True if the appliance is interior lighting.
 * @param isIrrigationPump True if the appliance is an irrigation pump.
 * @param isManagedCommercialIndustrialLoad True if the appliance is managed commercial or industrial load.
 * @param isPoolPumpSpaJacuzzi True if the appliance is a pool, pump, spa or jacuzzi.
 * @param isSimpleMiscLoad True if the appliance is a simple miscellaneous load.
 * @param isSmartAppliance True if the appliance is a smart appliance.
 * @param isStripAndBaseboardHeater True if the appliance is a stip or baseboard heater.
 * @param isWaterHeater True if the appliance is a water heater.
 */
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
    override def copy (): Row = { return (clone ().asInstanceOf[ControlledAppliance]) }
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
        "\t\t<cim:ControlledAppliance.isElectricVehicle>" + isElectricVehicle + "</cim:ControlledAppliance.isElectricVehicle>\n" +
        "\t\t<cim:ControlledAppliance.isExteriorLighting>" + isExteriorLighting + "</cim:ControlledAppliance.isExteriorLighting>\n" +
        "\t\t<cim:ControlledAppliance.isGenerationSystem>" + isGenerationSystem + "</cim:ControlledAppliance.isGenerationSystem>\n" +
        "\t\t<cim:ControlledAppliance.isHvacCompressorOrFurnace>" + isHvacCompressorOrFurnace + "</cim:ControlledAppliance.isHvacCompressorOrFurnace>\n" +
        "\t\t<cim:ControlledAppliance.isInteriorLighting>" + isInteriorLighting + "</cim:ControlledAppliance.isInteriorLighting>\n" +
        "\t\t<cim:ControlledAppliance.isIrrigationPump>" + isIrrigationPump + "</cim:ControlledAppliance.isIrrigationPump>\n" +
        "\t\t<cim:ControlledAppliance.isManagedCommercialIndustrialLoad>" + isManagedCommercialIndustrialLoad + "</cim:ControlledAppliance.isManagedCommercialIndustrialLoad>\n" +
        "\t\t<cim:ControlledAppliance.isPoolPumpSpaJacuzzi>" + isPoolPumpSpaJacuzzi + "</cim:ControlledAppliance.isPoolPumpSpaJacuzzi>\n" +
        "\t\t<cim:ControlledAppliance.isSimpleMiscLoad>" + isSimpleMiscLoad + "</cim:ControlledAppliance.isSimpleMiscLoad>\n" +
        "\t\t<cim:ControlledAppliance.isSmartAppliance>" + isSmartAppliance + "</cim:ControlledAppliance.isSmartAppliance>\n" +
        "\t\t<cim:ControlledAppliance.isStripAndBaseboardHeater>" + isStripAndBaseboardHeater + "</cim:ControlledAppliance.isStripAndBaseboardHeater>\n" +
        "\t\t<cim:ControlledAppliance.isWaterHeater>" + isWaterHeater + "</cim:ControlledAppliance.isWaterHeater>\n"
    }
    override def export: String =
    {
        "\t<cim:ControlledAppliance rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ControlledAppliance>\n"
    }
}

object ControlledAppliance
extends
    Parseable[ControlledAppliance]
{
    val isElectricVehicle = parse_element (element ("""ControlledAppliance.isElectricVehicle"""))
    val isExteriorLighting = parse_element (element ("""ControlledAppliance.isExteriorLighting"""))
    val isGenerationSystem = parse_element (element ("""ControlledAppliance.isGenerationSystem"""))
    val isHvacCompressorOrFurnace = parse_element (element ("""ControlledAppliance.isHvacCompressorOrFurnace"""))
    val isInteriorLighting = parse_element (element ("""ControlledAppliance.isInteriorLighting"""))
    val isIrrigationPump = parse_element (element ("""ControlledAppliance.isIrrigationPump"""))
    val isManagedCommercialIndustrialLoad = parse_element (element ("""ControlledAppliance.isManagedCommercialIndustrialLoad"""))
    val isPoolPumpSpaJacuzzi = parse_element (element ("""ControlledAppliance.isPoolPumpSpaJacuzzi"""))
    val isSimpleMiscLoad = parse_element (element ("""ControlledAppliance.isSimpleMiscLoad"""))
    val isSmartAppliance = parse_element (element ("""ControlledAppliance.isSmartAppliance"""))
    val isStripAndBaseboardHeater = parse_element (element ("""ControlledAppliance.isStripAndBaseboardHeater"""))
    val isWaterHeater = parse_element (element ("""ControlledAppliance.isWaterHeater"""))
    def parse (context: Context): ControlledAppliance =
    {
        ControlledAppliance(
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
    }
}

/**
 * Demand response program.
 * @param sup Reference to the superclass object.
 * @param typ Type of demand response program; examples are CPP (critical-peak pricing), RTP (real-time pricing), DLC (direct load control), DBP (demand bidding program), BIP (base interruptible program).
 *        Note that possible types change a lot and it would be impossible to enumerate them all.
 * @param validityInterval Interval within which the program is valid.
 * @param CustomerAgreements All customer agreements through which the customer is enrolled in this demand response program.
 * @param EndDeviceGroups All groups of end devices enrolled in this demand response program.
 * @param UsagePointGroups All usage point groups enrolled in this demand response program.
 */
case class DemandResponseProgram
(
    override val sup: IdentifiedObject,
    val typ: String,
    val validityInterval: String,
    val CustomerAgreements: List[String],
    val EndDeviceGroups: List[String],
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
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != typ) "\t\t<cim:DemandResponseProgram.type>" + typ + "</cim:DemandResponseProgram.type>\n" else "") +
        (if (null != validityInterval) "\t\t<cim:DemandResponseProgram.validityInterval rdf:resource=\"#" + validityInterval + "\"/>\n" else "") +
        (if (null != CustomerAgreements) CustomerAgreements.map (x => "\t\t<cim:DemandResponseProgram.CustomerAgreements rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != EndDeviceGroups) EndDeviceGroups.map (x => "\t\t<cim:DemandResponseProgram.EndDeviceGroups rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != UsagePointGroups) UsagePointGroups.map (x => "\t\t<cim:DemandResponseProgram.UsagePointGroups rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:DemandResponseProgram rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DemandResponseProgram>\n"
    }
}

object DemandResponseProgram
extends
    Parseable[DemandResponseProgram]
{
    val typ = parse_element (element ("""DemandResponseProgram.type"""))
    val validityInterval = parse_attribute (attribute ("""DemandResponseProgram.validityInterval"""))
    val CustomerAgreements = parse_attributes (attribute ("""DemandResponseProgram.CustomerAgreements"""))
    val EndDeviceGroups = parse_attributes (attribute ("""DemandResponseProgram.EndDeviceGroups"""))
    val UsagePointGroups = parse_attributes (attribute ("""DemandResponseProgram.UsagePointGroups"""))
    def parse (context: Context): DemandResponseProgram =
    {
        DemandResponseProgram(
            IdentifiedObject.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param amrSystem Automated meter reading (AMR) or other communication system responsible for communications to this end device.
 * @param installCode Installation code.
 * @param isPan If true, this is a premises area network (PAN) device.
 * @param isVirtual If true, there is no physical device.
 *        As an example, a virtual meter can be defined to aggregate the consumption for two or more physical meters. Otherwise, this is a physical hardware device.
 * @param timeZoneOffset Time zone offset relative to GMT for the location of this end device.
 * @param Customer Customer owning this end device.
 * @param EndDeviceInfo End device data.
 * @param ServiceLocation Service location whose service delivery is measured by this end device.
 * @param UsagePoint Usage point to which this end device belongs.
 */
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
    override def copy (): Row = { return (clone ().asInstanceOf[EndDevice]) }
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
        (if (null != amrSystem) "\t\t<cim:EndDevice.amrSystem>" + amrSystem + "</cim:EndDevice.amrSystem>\n" else "") +
        (if (null != installCode) "\t\t<cim:EndDevice.installCode>" + installCode + "</cim:EndDevice.installCode>\n" else "") +
        "\t\t<cim:EndDevice.isPan>" + isPan + "</cim:EndDevice.isPan>\n" +
        "\t\t<cim:EndDevice.isVirtual>" + isVirtual + "</cim:EndDevice.isVirtual>\n" +
        "\t\t<cim:EndDevice.timeZoneOffset>" + timeZoneOffset + "</cim:EndDevice.timeZoneOffset>\n" +
        (if (null != Customer) "\t\t<cim:EndDevice.Customer rdf:resource=\"#" + Customer + "\"/>\n" else "") +
        (if (null != EndDeviceInfo) "\t\t<cim:EndDevice.EndDeviceInfo rdf:resource=\"#" + EndDeviceInfo + "\"/>\n" else "") +
        (if (null != ServiceLocation) "\t\t<cim:EndDevice.ServiceLocation rdf:resource=\"#" + ServiceLocation + "\"/>\n" else "") +
        (if (null != UsagePoint) "\t\t<cim:EndDevice.UsagePoint rdf:resource=\"#" + UsagePoint + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:EndDevice rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:EndDevice>\n"
    }
}

object EndDevice
extends
    Parseable[EndDevice]
{
    val amrSystem = parse_element (element ("""EndDevice.amrSystem"""))
    val installCode = parse_element (element ("""EndDevice.installCode"""))
    val isPan = parse_element (element ("""EndDevice.isPan"""))
    val isVirtual = parse_element (element ("""EndDevice.isVirtual"""))
    val timeZoneOffset = parse_element (element ("""EndDevice.timeZoneOffset"""))
    val Customer = parse_attribute (attribute ("""EndDevice.Customer"""))
    val EndDeviceInfo = parse_attribute (attribute ("""EndDevice.EndDeviceInfo"""))
    val ServiceLocation = parse_attribute (attribute ("""EndDevice.ServiceLocation"""))
    val UsagePoint = parse_attribute (attribute ("""EndDevice.UsagePoint"""))
    def parse (context: Context): EndDevice =
    {
        EndDevice(
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
    }
}

/**
 * Action/command performed by an end device on a device other than the end device.
 * @param sup Reference to the superclass object.
 * @param command Command text.
 * @param duration Amount of time the action of this control is to remain active.
 * @param durationIndefinite True if the action of this control is indefinite.
 * @param startDateTime Start date and time for action of this control.
 * @param EndDeviceControl End device control issuing this end device action.
 */
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
    override def copy (): Row = { return (clone ().asInstanceOf[EndDeviceAction]) }
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
        (if (null != command) "\t\t<cim:EndDeviceAction.command>" + command + "</cim:EndDeviceAction.command>\n" else "") +
        "\t\t<cim:EndDeviceAction.duration>" + duration + "</cim:EndDeviceAction.duration>\n" +
        "\t\t<cim:EndDeviceAction.durationIndefinite>" + durationIndefinite + "</cim:EndDeviceAction.durationIndefinite>\n" +
        (if (null != startDateTime) "\t\t<cim:EndDeviceAction.startDateTime>" + startDateTime + "</cim:EndDeviceAction.startDateTime>\n" else "") +
        (if (null != EndDeviceControl) "\t\t<cim:EndDeviceAction.EndDeviceControl rdf:resource=\"#" + EndDeviceControl + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:EndDeviceAction rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:EndDeviceAction>\n"
    }
}

object EndDeviceAction
extends
    Parseable[EndDeviceAction]
{
    val command = parse_element (element ("""EndDeviceAction.command"""))
    val duration = parse_element (element ("""EndDeviceAction.duration"""))
    val durationIndefinite = parse_element (element ("""EndDeviceAction.durationIndefinite"""))
    val startDateTime = parse_element (element ("""EndDeviceAction.startDateTime"""))
    val EndDeviceControl = parse_attribute (attribute ("""EndDeviceAction.EndDeviceControl"""))
    def parse (context: Context): EndDeviceAction =
    {
        EndDeviceAction(
            BasicElement.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param autonomousDst True if autonomous DST (daylight saving time) function is supported.
 * @param communication True if communication function is supported.
 * @param connectDisconnect True if connect and disconnect function is supported.
 * @param demandResponse True if demand response function is supported.
 * @param electricMetering True if electric metering function is supported.
 * @param gasMetering True if gas metering function is supported.
 * @param metrology True if metrology function is supported.
 * @param onRequestRead True if on request read function is supported.
 * @param outageHistory True if outage history function is supported.
 * @param pressureCompensation True if device performs pressure compensation for metered quantities.
 * @param pricingInfo True if pricing information is supported.
 * @param pulseOutput True if device produces pulse outputs.
 * @param relaysProgramming True if relays programming function is supported.
 * @param reverseFlow True if reverse flow function is supported.
 * @param superCompressibilityCompensation True if device performs super compressibility compensation for metered quantities.
 * @param temperatureCompensation True if device performs temperature compensation for metered quantities.
 * @param textMessage True if the displaying of text messages is supported.
 * @param waterMetering True if water metering function is supported.
 */
case class EndDeviceCapability
(
    override val sup: BasicElement,
    val autonomousDst: Boolean,
    val communication: Boolean,
    val connectDisconnect: Boolean,
    val demandResponse: Boolean,
    val electricMetering: Boolean,
    val gasMetering: Boolean,
    val metrology: Boolean,
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
    override def copy (): Row = { return (clone ().asInstanceOf[EndDeviceCapability]) }
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
        "\t\t<cim:EndDeviceCapability.autonomousDst>" + autonomousDst + "</cim:EndDeviceCapability.autonomousDst>\n" +
        "\t\t<cim:EndDeviceCapability.communication>" + communication + "</cim:EndDeviceCapability.communication>\n" +
        "\t\t<cim:EndDeviceCapability.connectDisconnect>" + connectDisconnect + "</cim:EndDeviceCapability.connectDisconnect>\n" +
        "\t\t<cim:EndDeviceCapability.demandResponse>" + demandResponse + "</cim:EndDeviceCapability.demandResponse>\n" +
        "\t\t<cim:EndDeviceCapability.electricMetering>" + electricMetering + "</cim:EndDeviceCapability.electricMetering>\n" +
        "\t\t<cim:EndDeviceCapability.gasMetering>" + gasMetering + "</cim:EndDeviceCapability.gasMetering>\n" +
        "\t\t<cim:EndDeviceCapability.metrology>" + metrology + "</cim:EndDeviceCapability.metrology>\n" +
        "\t\t<cim:EndDeviceCapability.onRequestRead>" + onRequestRead + "</cim:EndDeviceCapability.onRequestRead>\n" +
        "\t\t<cim:EndDeviceCapability.outageHistory>" + outageHistory + "</cim:EndDeviceCapability.outageHistory>\n" +
        "\t\t<cim:EndDeviceCapability.pressureCompensation>" + pressureCompensation + "</cim:EndDeviceCapability.pressureCompensation>\n" +
        "\t\t<cim:EndDeviceCapability.pricingInfo>" + pricingInfo + "</cim:EndDeviceCapability.pricingInfo>\n" +
        "\t\t<cim:EndDeviceCapability.pulseOutput>" + pulseOutput + "</cim:EndDeviceCapability.pulseOutput>\n" +
        "\t\t<cim:EndDeviceCapability.relaysProgramming>" + relaysProgramming + "</cim:EndDeviceCapability.relaysProgramming>\n" +
        "\t\t<cim:EndDeviceCapability.reverseFlow>" + reverseFlow + "</cim:EndDeviceCapability.reverseFlow>\n" +
        "\t\t<cim:EndDeviceCapability.superCompressibilityCompensation>" + superCompressibilityCompensation + "</cim:EndDeviceCapability.superCompressibilityCompensation>\n" +
        "\t\t<cim:EndDeviceCapability.temperatureCompensation>" + temperatureCompensation + "</cim:EndDeviceCapability.temperatureCompensation>\n" +
        "\t\t<cim:EndDeviceCapability.textMessage>" + textMessage + "</cim:EndDeviceCapability.textMessage>\n" +
        "\t\t<cim:EndDeviceCapability.waterMetering>" + waterMetering + "</cim:EndDeviceCapability.waterMetering>\n"
    }
    override def export: String =
    {
        "\t<cim:EndDeviceCapability rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:EndDeviceCapability>\n"
    }
}

object EndDeviceCapability
extends
    Parseable[EndDeviceCapability]
{
    val autonomousDst = parse_element (element ("""EndDeviceCapability.autonomousDst"""))
    val communication = parse_element (element ("""EndDeviceCapability.communication"""))
    val connectDisconnect = parse_element (element ("""EndDeviceCapability.connectDisconnect"""))
    val demandResponse = parse_element (element ("""EndDeviceCapability.demandResponse"""))
    val electricMetering = parse_element (element ("""EndDeviceCapability.electricMetering"""))
    val gasMetering = parse_element (element ("""EndDeviceCapability.gasMetering"""))
    val metrology = parse_element (element ("""EndDeviceCapability.metrology"""))
    val onRequestRead = parse_element (element ("""EndDeviceCapability.onRequestRead"""))
    val outageHistory = parse_element (element ("""EndDeviceCapability.outageHistory"""))
    val pressureCompensation = parse_element (element ("""EndDeviceCapability.pressureCompensation"""))
    val pricingInfo = parse_element (element ("""EndDeviceCapability.pricingInfo"""))
    val pulseOutput = parse_element (element ("""EndDeviceCapability.pulseOutput"""))
    val relaysProgramming = parse_element (element ("""EndDeviceCapability.relaysProgramming"""))
    val reverseFlow = parse_element (element ("""EndDeviceCapability.reverseFlow"""))
    val superCompressibilityCompensation = parse_element (element ("""EndDeviceCapability.superCompressibilityCompensation"""))
    val temperatureCompensation = parse_element (element ("""EndDeviceCapability.temperatureCompensation"""))
    val textMessage = parse_element (element ("""EndDeviceCapability.textMessage"""))
    val waterMetering = parse_element (element ("""EndDeviceCapability.waterMetering"""))
    def parse (context: Context): EndDeviceCapability =
    {
        EndDeviceCapability(
            BasicElement.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param drProgramLevel Level of a demand response program request, where 0=emergency.
 *        Note: Attribute is not defined on DemandResponseProgram as it is not its inherent property (it serves to control it).
 * @param drProgramMandatory Whether a demand response program request is mandatory.
 *        Note: Attribute is not defined on DemandResponseProgram as it is not its inherent property (it serves to control it).
 * @param issuerID Unique identifier of the business entity originating an end device control.
 * @param issuerTrackingID Identifier assigned by the initiator (e.g. retail electric provider) of an end device control action to uniquely identify the demand response event, text message, or other subject of the control action.
 *        Can be used when cancelling an event or text message request or to identify the originating event or text message in a consequential end device event.
 * @param priceSignal (if applicable) Price signal used as parameter for this end device control.
 * @param primaryDeviceTiming Timing for the control actions performed on the device identified in the end device control.
 * @param reason Reason for the control action that allows to determine how to continue processing.
 *        For example, disconnect meter command may require different processing by the receiving system if it has been issued for a network-related reason (protection) or for a payment-related reason.
 * @param scheduledInterval (if control has scheduled duration) Date and time interval the control has been scheduled to execute within.
 * @param secondaryDeviceTiming Timing for the control actions performed by devices that are responding to event related information sent to the primary device indicated in the end device control.
 *        For example, load control actions performed by a PAN device in response to demand response event information sent to a PAN gateway server.
 * @param EndDeviceAction End device action issued by this end device control.
 * @param EndDeviceControlType Type of this end device control.
 * @param EndDevices All end devices receiving commands from this end device control.
 * @param UsagePointGroups All usage point groups receiving commands from this end device control.
 * @param UsagePoints All usage points receiving commands from this end device control.
 */
case class EndDeviceControl
(
    override val sup: IdentifiedObject,
    val drProgramLevel: Int,
    val drProgramMandatory: Boolean,
    val issuerID: String,
    val issuerTrackingID: String,
    val priceSignal: String,
    val primaryDeviceTiming: String,
    val reason: String,
    val scheduledInterval: String,
    val secondaryDeviceTiming: String,
    val EndDeviceAction: String,
    val EndDeviceControlType: String,
    val EndDevices: List[String],
    val UsagePointGroups: List[String],
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
    override def export_fields: String =
    {
        sup.export_fields +
        "\t\t<cim:EndDeviceControl.drProgramLevel>" + drProgramLevel + "</cim:EndDeviceControl.drProgramLevel>\n" +
        "\t\t<cim:EndDeviceControl.drProgramMandatory>" + drProgramMandatory + "</cim:EndDeviceControl.drProgramMandatory>\n" +
        (if (null != issuerID) "\t\t<cim:EndDeviceControl.issuerID>" + issuerID + "</cim:EndDeviceControl.issuerID>\n" else "") +
        (if (null != issuerTrackingID) "\t\t<cim:EndDeviceControl.issuerTrackingID>" + issuerTrackingID + "</cim:EndDeviceControl.issuerTrackingID>\n" else "") +
        (if (null != priceSignal) "\t\t<cim:EndDeviceControl.priceSignal rdf:resource=\"#" + priceSignal + "\"/>\n" else "") +
        (if (null != primaryDeviceTiming) "\t\t<cim:EndDeviceControl.primaryDeviceTiming rdf:resource=\"#" + primaryDeviceTiming + "\"/>\n" else "") +
        (if (null != reason) "\t\t<cim:EndDeviceControl.reason>" + reason + "</cim:EndDeviceControl.reason>\n" else "") +
        (if (null != scheduledInterval) "\t\t<cim:EndDeviceControl.scheduledInterval rdf:resource=\"#" + scheduledInterval + "\"/>\n" else "") +
        (if (null != secondaryDeviceTiming) "\t\t<cim:EndDeviceControl.secondaryDeviceTiming rdf:resource=\"#" + secondaryDeviceTiming + "\"/>\n" else "") +
        (if (null != EndDeviceAction) "\t\t<cim:EndDeviceControl.EndDeviceAction rdf:resource=\"#" + EndDeviceAction + "\"/>\n" else "") +
        (if (null != EndDeviceControlType) "\t\t<cim:EndDeviceControl.EndDeviceControlType rdf:resource=\"#" + EndDeviceControlType + "\"/>\n" else "") +
        (if (null != EndDevices) EndDevices.map (x => "\t\t<cim:EndDeviceControl.EndDevices rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != UsagePointGroups) UsagePointGroups.map (x => "\t\t<cim:EndDeviceControl.UsagePointGroups rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != UsagePoints) UsagePoints.map (x => "\t\t<cim:EndDeviceControl.UsagePoints rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:EndDeviceControl rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:EndDeviceControl>\n"
    }
}

object EndDeviceControl
extends
    Parseable[EndDeviceControl]
{
    val drProgramLevel = parse_element (element ("""EndDeviceControl.drProgramLevel"""))
    val drProgramMandatory = parse_element (element ("""EndDeviceControl.drProgramMandatory"""))
    val issuerID = parse_element (element ("""EndDeviceControl.issuerID"""))
    val issuerTrackingID = parse_element (element ("""EndDeviceControl.issuerTrackingID"""))
    val priceSignal = parse_attribute (attribute ("""EndDeviceControl.priceSignal"""))
    val primaryDeviceTiming = parse_attribute (attribute ("""EndDeviceControl.primaryDeviceTiming"""))
    val reason = parse_element (element ("""EndDeviceControl.reason"""))
    val scheduledInterval = parse_attribute (attribute ("""EndDeviceControl.scheduledInterval"""))
    val secondaryDeviceTiming = parse_attribute (attribute ("""EndDeviceControl.secondaryDeviceTiming"""))
    val EndDeviceAction = parse_attribute (attribute ("""EndDeviceControl.EndDeviceAction"""))
    val EndDeviceControlType = parse_attribute (attribute ("""EndDeviceControl.EndDeviceControlType"""))
    val EndDevices = parse_attributes (attribute ("""EndDeviceControl.EndDevices"""))
    val UsagePointGroups = parse_attributes (attribute ("""EndDeviceControl.UsagePointGroups"""))
    val UsagePoints = parse_attributes (attribute ("""EndDeviceControl.UsagePoints"""))
    def parse (context: Context): EndDeviceControl =
    {
        EndDeviceControl(
            IdentifiedObject.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param domain High-level nature of the control.
 * @param eventOrAction The most specific part of this control type.
 *        It is mainly in the form of a verb that gives action to the control that just occurred.
 * @param subDomain More specific nature of the control, as a further sub-categorisation of 'domain'.
 * @param typ Type of physical device from which the control was created.
 *        A value of zero (0) can be used when the source is unknown.
 */
case class EndDeviceControlType
(
    override val sup: IdentifiedObject,
    val domain: String,
    val eventOrAction: String,
    val subDomain: String,
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
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != domain) "\t\t<cim:EndDeviceControlType.domain>" + domain + "</cim:EndDeviceControlType.domain>\n" else "") +
        (if (null != eventOrAction) "\t\t<cim:EndDeviceControlType.eventOrAction>" + eventOrAction + "</cim:EndDeviceControlType.eventOrAction>\n" else "") +
        (if (null != subDomain) "\t\t<cim:EndDeviceControlType.subDomain>" + subDomain + "</cim:EndDeviceControlType.subDomain>\n" else "") +
        (if (null != typ) "\t\t<cim:EndDeviceControlType.type>" + typ + "</cim:EndDeviceControlType.type>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:EndDeviceControlType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:EndDeviceControlType>\n"
    }
}

object EndDeviceControlType
extends
    Parseable[EndDeviceControlType]
{
    val domain = parse_element (element ("""EndDeviceControlType.domain"""))
    val eventOrAction = parse_element (element ("""EndDeviceControlType.eventOrAction"""))
    val subDomain = parse_element (element ("""EndDeviceControlType.subDomain"""))
    val typ = parse_element (element ("""EndDeviceControlType.type"""))
    def parse (context: Context): EndDeviceControlType =
    {
        EndDeviceControlType(
            IdentifiedObject.parse (context),
            domain (context),
            eventOrAction (context),
            subDomain (context),
            typ (context)
        )
    }
}

/**
 * Event detected by a device function associated with the end device.
 * @param sup Reference to the superclass object.
 * @param issuerID Unique identifier of the business entity originating an end device control.
 * @param issuerTrackingID Identifier assigned by the initiator (e.g. retail electric provider) of an end device control action to uniquely identify the demand response event, text message, or other subject of the control action.
 *        Can be used when cancelling an event or text message request or to identify the originating event or text message in a consequential end device event.
 * @param userID (if user initiated) ID of user who initiated this end device event.
 * @param EndDevice End device that reported this end device event.
 * @param EndDeviceEventType Type of this end device event.
 * @param MeterReading Set of measured values to which this event applies.
 * @param UsagePoint Usage point for which this end device event is reported.
 */
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
    override def copy (): Row = { return (clone ().asInstanceOf[EndDeviceEvent]) }
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
        (if (null != issuerID) "\t\t<cim:EndDeviceEvent.issuerID>" + issuerID + "</cim:EndDeviceEvent.issuerID>\n" else "") +
        (if (null != issuerTrackingID) "\t\t<cim:EndDeviceEvent.issuerTrackingID>" + issuerTrackingID + "</cim:EndDeviceEvent.issuerTrackingID>\n" else "") +
        (if (null != userID) "\t\t<cim:EndDeviceEvent.userID>" + userID + "</cim:EndDeviceEvent.userID>\n" else "") +
        (if (null != EndDevice) "\t\t<cim:EndDeviceEvent.EndDevice rdf:resource=\"#" + EndDevice + "\"/>\n" else "") +
        (if (null != EndDeviceEventType) "\t\t<cim:EndDeviceEvent.EndDeviceEventType rdf:resource=\"#" + EndDeviceEventType + "\"/>\n" else "") +
        (if (null != MeterReading) "\t\t<cim:EndDeviceEvent.MeterReading rdf:resource=\"#" + MeterReading + "\"/>\n" else "") +
        (if (null != UsagePoint) "\t\t<cim:EndDeviceEvent.UsagePoint rdf:resource=\"#" + UsagePoint + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:EndDeviceEvent rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:EndDeviceEvent>\n"
    }
}

object EndDeviceEvent
extends
    Parseable[EndDeviceEvent]
{
    val issuerID = parse_element (element ("""EndDeviceEvent.issuerID"""))
    val issuerTrackingID = parse_element (element ("""EndDeviceEvent.issuerTrackingID"""))
    val userID = parse_element (element ("""EndDeviceEvent.userID"""))
    val EndDevice = parse_attribute (attribute ("""EndDeviceEvent.EndDevice"""))
    val EndDeviceEventType = parse_attribute (attribute ("""EndDeviceEvent.EndDeviceEventType"""))
    val MeterReading = parse_attribute (attribute ("""EndDeviceEvent.MeterReading"""))
    val UsagePoint = parse_attribute (attribute ("""EndDeviceEvent.UsagePoint"""))
    def parse (context: Context): EndDeviceEvent =
    {
        EndDeviceEvent(
            ActivityRecord.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param name Name.
 * @param value Value, including unit information.
 * @param EndDeviceEvent End device owning this detail.
 */
case class EndDeviceEventDetail
(
    override val sup: BasicElement,
    val name: String,
    val value: String,
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
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != name) "\t\t<cim:EndDeviceEventDetail.name>" + name + "</cim:EndDeviceEventDetail.name>\n" else "") +
        (if (null != value) "\t\t<cim:EndDeviceEventDetail.value rdf:resource=\"#" + value + "\"/>\n" else "") +
        (if (null != EndDeviceEvent) "\t\t<cim:EndDeviceEventDetail.EndDeviceEvent rdf:resource=\"#" + EndDeviceEvent + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:EndDeviceEventDetail rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:EndDeviceEventDetail>\n"
    }
}

object EndDeviceEventDetail
extends
    Parseable[EndDeviceEventDetail]
{
    val name = parse_element (element ("""EndDeviceEventDetail.name"""))
    val value = parse_attribute (attribute ("""EndDeviceEventDetail.value"""))
    val EndDeviceEvent = parse_attribute (attribute ("""EndDeviceEventDetail.EndDeviceEvent"""))
    def parse (context: Context): EndDeviceEventDetail =
    {
        EndDeviceEventDetail(
            BasicElement.parse (context),
            name (context),
            value (context),
            EndDeviceEvent (context)
        )
    }
}

/**
 * Detailed description for an event produced by an end device.
 * Values in attributes allow for creation of recommended codes to be used for identifying end device events as follows: &lt;type&gt;.&lt;domain&gt;.&lt;subDomain&gt;.&lt;eventOrAction&gt;.
 * @param sup Reference to the superclass object.
 * @param domain High-level nature of the event.
 *        By properly classifying events by a small set of domain codes, a system can more easily run reports based on the types of events that have occurred or been received.
 * @param eventOrAction The most specific part of this event type.
 *        It is mainly in the form of a verb that gives action to the event that just occurred.
 * @param subDomain More specific nature of the event, as a further sub-categorisation of 'domain'.
 * @param typ Type of physical device from which the event was created.
 *        A value of zero (0) can be used when the source is unknown.
 */
case class EndDeviceEventType
(
    override val sup: IdentifiedObject,
    val domain: String,
    val eventOrAction: String,
    val subDomain: String,
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
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != domain) "\t\t<cim:EndDeviceEventType.domain>" + domain + "</cim:EndDeviceEventType.domain>\n" else "") +
        (if (null != eventOrAction) "\t\t<cim:EndDeviceEventType.eventOrAction>" + eventOrAction + "</cim:EndDeviceEventType.eventOrAction>\n" else "") +
        (if (null != subDomain) "\t\t<cim:EndDeviceEventType.subDomain>" + subDomain + "</cim:EndDeviceEventType.subDomain>\n" else "") +
        (if (null != typ) "\t\t<cim:EndDeviceEventType.type>" + typ + "</cim:EndDeviceEventType.type>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:EndDeviceEventType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:EndDeviceEventType>\n"
    }
}

object EndDeviceEventType
extends
    Parseable[EndDeviceEventType]
{
    val domain = parse_element (element ("""EndDeviceEventType.domain"""))
    val eventOrAction = parse_element (element ("""EndDeviceEventType.eventOrAction"""))
    val subDomain = parse_element (element ("""EndDeviceEventType.subDomain"""))
    val typ = parse_element (element ("""EndDeviceEventType.type"""))
    def parse (context: Context): EndDeviceEventType =
    {
        EndDeviceEventType(
            IdentifiedObject.parse (context),
            domain (context),
            eventOrAction (context),
            subDomain (context),
            typ (context)
        )
    }
}

/**
 * Function performed by an end device such as a meter, communication equipment, controllers, etc.
 * @param sup Reference to the superclass object.
 * @param enabled True if the function is enabled.
 * @param EndDevice End device that performs this function.
 */
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
    override def copy (): Row = { return (clone ().asInstanceOf[EndDeviceFunction]) }
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
        "\t\t<cim:EndDeviceFunction.enabled>" + enabled + "</cim:EndDeviceFunction.enabled>\n" +
        (if (null != EndDevice) "\t\t<cim:EndDeviceFunction.EndDevice rdf:resource=\"#" + EndDevice + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:EndDeviceFunction rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:EndDeviceFunction>\n"
    }
}

object EndDeviceFunction
extends
    Parseable[EndDeviceFunction]
{
    val enabled = parse_element (element ("""EndDeviceFunction.enabled"""))
    val EndDevice = parse_attribute (attribute ("""EndDeviceFunction.EndDevice"""))
    def parse (context: Context): EndDeviceFunction =
    {
        EndDeviceFunction(
            AssetFunction.parse (context),
            toBoolean (enabled (context), context),
            EndDevice (context)
        )
    }
}

/**
 * Kind of end device function.
 * @param sup Reference to the superclass object.
 * @param autonomousDst Autonomous application of daylight saving time (DST).
 * @param demandResponse Demand response functions.
 * @param electricMetering Electricity metering.
 * @param gasMetering Gas metering.
 * @param metrology Presentation of metered values to a user or another system (always a function of a meter, but might not be supported by a load control unit).
 * @param onRequestRead On-request reads.
 * @param outageHistory Reporting historical power interruption data.
 * @param relaysProgramming Support for one or more relays that may be programmable in the meter (and tied to TOU, time pulse, load control or other functions).
 * @param reverseFlow Detection and monitoring of reverse flow.
 * @param waterMetering Water metering.
 */
case class EndDeviceFunctionKind
(
    override val sup: BasicElement,
    val autonomousDst: String,
    val demandResponse: String,
    val electricMetering: String,
    val gasMetering: String,
    val metrology: String,
    val onRequestRead: String,
    val outageHistory: String,
    val relaysProgramming: String,
    val reverseFlow: String,
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
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != autonomousDst) "\t\t<cim:EndDeviceFunctionKind.autonomousDst rdf:resource=\"#" + autonomousDst + "\"/>\n" else "") +
        (if (null != demandResponse) "\t\t<cim:EndDeviceFunctionKind.demandResponse rdf:resource=\"#" + demandResponse + "\"/>\n" else "") +
        (if (null != electricMetering) "\t\t<cim:EndDeviceFunctionKind.electricMetering rdf:resource=\"#" + electricMetering + "\"/>\n" else "") +
        (if (null != gasMetering) "\t\t<cim:EndDeviceFunctionKind.gasMetering rdf:resource=\"#" + gasMetering + "\"/>\n" else "") +
        (if (null != metrology) "\t\t<cim:EndDeviceFunctionKind.metrology rdf:resource=\"#" + metrology + "\"/>\n" else "") +
        (if (null != onRequestRead) "\t\t<cim:EndDeviceFunctionKind.onRequestRead rdf:resource=\"#" + onRequestRead + "\"/>\n" else "") +
        (if (null != outageHistory) "\t\t<cim:EndDeviceFunctionKind.outageHistory rdf:resource=\"#" + outageHistory + "\"/>\n" else "") +
        (if (null != relaysProgramming) "\t\t<cim:EndDeviceFunctionKind.relaysProgramming rdf:resource=\"#" + relaysProgramming + "\"/>\n" else "") +
        (if (null != reverseFlow) "\t\t<cim:EndDeviceFunctionKind.reverseFlow rdf:resource=\"#" + reverseFlow + "\"/>\n" else "") +
        (if (null != waterMetering) "\t\t<cim:EndDeviceFunctionKind.waterMetering rdf:resource=\"#" + waterMetering + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:EndDeviceFunctionKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:EndDeviceFunctionKind>\n"
    }
}

object EndDeviceFunctionKind
extends
    Parseable[EndDeviceFunctionKind]
{
    val autonomousDst = parse_attribute (attribute ("""EndDeviceFunctionKind.autonomousDst"""))
    val demandResponse = parse_attribute (attribute ("""EndDeviceFunctionKind.demandResponse"""))
    val electricMetering = parse_attribute (attribute ("""EndDeviceFunctionKind.electricMetering"""))
    val gasMetering = parse_attribute (attribute ("""EndDeviceFunctionKind.gasMetering"""))
    val metrology = parse_attribute (attribute ("""EndDeviceFunctionKind.metrology"""))
    val onRequestRead = parse_attribute (attribute ("""EndDeviceFunctionKind.onRequestRead"""))
    val outageHistory = parse_attribute (attribute ("""EndDeviceFunctionKind.outageHistory"""))
    val relaysProgramming = parse_attribute (attribute ("""EndDeviceFunctionKind.relaysProgramming"""))
    val reverseFlow = parse_attribute (attribute ("""EndDeviceFunctionKind.reverseFlow"""))
    val waterMetering = parse_attribute (attribute ("""EndDeviceFunctionKind.waterMetering"""))
    def parse (context: Context): EndDeviceFunctionKind =
    {
        EndDeviceFunctionKind(
            BasicElement.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param typ Type of this group.
 * @param EndDeviceControls All end device controls sending commands to this end device group.
 * @param EndDevices All end devices this end device group refers to.
 */
case class EndDeviceGroup
(
    override val sup: IdentifiedObject,
    val typ: String,
    val EndDeviceControls: List[String],
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
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != typ) "\t\t<cim:EndDeviceGroup.type>" + typ + "</cim:EndDeviceGroup.type>\n" else "") +
        (if (null != EndDeviceControls) EndDeviceControls.map (x => "\t\t<cim:EndDeviceGroup.EndDeviceControls rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != EndDevices) EndDevices.map (x => "\t\t<cim:EndDeviceGroup.EndDevices rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:EndDeviceGroup rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:EndDeviceGroup>\n"
    }
}

object EndDeviceGroup
extends
    Parseable[EndDeviceGroup]
{
    val typ = parse_element (element ("""EndDeviceGroup.type"""))
    val EndDeviceControls = parse_attributes (attribute ("""EndDeviceGroup.EndDeviceControls"""))
    val EndDevices = parse_attributes (attribute ("""EndDeviceGroup.EndDevices"""))
    def parse (context: Context): EndDeviceGroup =
    {
        EndDeviceGroup(
            IdentifiedObject.parse (context),
            typ (context),
            EndDeviceControls (context),
            EndDevices (context)
        )
    }
}

/**
 * End device data.
 * @param sup Reference to the superclass object.
 * @param capability Inherent capabilities of the device (i.e., the functions it supports).
 * @param isSolidState If true, this is a solid state end device (as opposed to a mechanical or electromechanical device).
 * @param phaseCount Number of potential phases the end device supports, typically 0, 1 or 3.
 * @param ratedCurrent Rated current.
 * @param ratedVoltage Rated voltage.
 */
case class EndDeviceInfo
(
    override val sup: AssetInfo,
    val capability: String,
    val isSolidState: Boolean,
    val phaseCount: Int,
    val ratedCurrent: Double,
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
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != capability) "\t\t<cim:EndDeviceInfo.capability rdf:resource=\"#" + capability + "\"/>\n" else "") +
        "\t\t<cim:EndDeviceInfo.isSolidState>" + isSolidState + "</cim:EndDeviceInfo.isSolidState>\n" +
        "\t\t<cim:EndDeviceInfo.phaseCount>" + phaseCount + "</cim:EndDeviceInfo.phaseCount>\n" +
        "\t\t<cim:EndDeviceInfo.ratedCurrent>" + ratedCurrent + "</cim:EndDeviceInfo.ratedCurrent>\n" +
        "\t\t<cim:EndDeviceInfo.ratedVoltage>" + ratedVoltage + "</cim:EndDeviceInfo.ratedVoltage>\n"
    }
    override def export: String =
    {
        "\t<cim:EndDeviceInfo rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:EndDeviceInfo>\n"
    }
}

object EndDeviceInfo
extends
    Parseable[EndDeviceInfo]
{
    val capability = parse_attribute (attribute ("""EndDeviceInfo.capability"""))
    val isSolidState = parse_element (element ("""EndDeviceInfo.isSolidState"""))
    val phaseCount = parse_element (element ("""EndDeviceInfo.phaseCount"""))
    val ratedCurrent = parse_element (element ("""EndDeviceInfo.ratedCurrent"""))
    val ratedVoltage = parse_element (element ("""EndDeviceInfo.ratedVoltage"""))
    def parse (context: Context): EndDeviceInfo =
    {
        EndDeviceInfo(
            AssetInfo.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param duration Duration of the end device control action or the business event that is the subject of the end device control.
 * @param durationIndefinite True if 'duration' is indefinite.
 * @param interval Start and end time of an interval during which end device control actions are to be executed.
 * @param randomisation Kind of randomisation to be applied to the end device control actions to be executed.
 */
case class EndDeviceTiming
(
    override val sup: BasicElement,
    val duration: Double,
    val durationIndefinite: Boolean,
    val interval: String,
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
    override def export_fields: String =
    {
        sup.export_fields +
        "\t\t<cim:EndDeviceTiming.duration>" + duration + "</cim:EndDeviceTiming.duration>\n" +
        "\t\t<cim:EndDeviceTiming.durationIndefinite>" + durationIndefinite + "</cim:EndDeviceTiming.durationIndefinite>\n" +
        (if (null != interval) "\t\t<cim:EndDeviceTiming.interval rdf:resource=\"#" + interval + "\"/>\n" else "") +
        (if (null != randomisation) "\t\t<cim:EndDeviceTiming.randomisation rdf:resource=\"#" + randomisation + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:EndDeviceTiming rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:EndDeviceTiming>\n"
    }
}

object EndDeviceTiming
extends
    Parseable[EndDeviceTiming]
{
    val duration = parse_element (element ("""EndDeviceTiming.duration"""))
    val durationIndefinite = parse_element (element ("""EndDeviceTiming.durationIndefinite"""))
    val interval = parse_attribute (attribute ("""EndDeviceTiming.interval"""))
    val randomisation = parse_attribute (attribute ("""EndDeviceTiming.randomisation"""))
    def parse (context: Context): EndDeviceTiming =
    {
        EndDeviceTiming(
            BasicElement.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param IntervalReadings Interval reading contained in this block.
 * @param MeterReading Meter reading containing this interval block.
 * @param PendingCalculation Pending calculation to apply to interval reading values contained by this block (after which the resulting reading type is different than the original because it reflects the conversion result).
 * @param ReadingType Type information for interval reading values contained in this block.
 */
case class IntervalBlock
(
    override val sup: BasicElement,
    val IntervalReadings: List[String],
    val MeterReading: String,
    val PendingCalculation: String,
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
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != IntervalReadings) IntervalReadings.map (x => "\t\t<cim:IntervalBlock.IntervalReadings rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != MeterReading) "\t\t<cim:IntervalBlock.MeterReading rdf:resource=\"#" + MeterReading + "\"/>\n" else "") +
        (if (null != PendingCalculation) "\t\t<cim:IntervalBlock.PendingCalculation rdf:resource=\"#" + PendingCalculation + "\"/>\n" else "") +
        (if (null != ReadingType) "\t\t<cim:IntervalBlock.ReadingType rdf:resource=\"#" + ReadingType + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:IntervalBlock rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:IntervalBlock>\n"
    }
}

object IntervalBlock
extends
    Parseable[IntervalBlock]
{
    val IntervalReadings = parse_attributes (attribute ("""IntervalBlock.IntervalReadings"""))
    val MeterReading = parse_attribute (attribute ("""IntervalBlock.MeterReading"""))
    val PendingCalculation = parse_attribute (attribute ("""IntervalBlock.PendingCalculation"""))
    val ReadingType = parse_attribute (attribute ("""IntervalBlock.ReadingType"""))
    def parse (context: Context): IntervalBlock =
    {
        IntervalBlock(
            BasicElement.parse (context),
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
 * @param sup Reference to the superclass object.
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
    override def export_fields: String =
    {
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:IntervalReading rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:IntervalReading>\n"
    }
}

object IntervalReading
extends
    Parseable[IntervalReading]
{
    def parse (context: Context): IntervalReading =
    {
        IntervalReading(
            BaseReading.parse (context)
        )
    }
}

/**
 * Physical asset that performs the metering role of the usage point.
 * Used for measuring consumption and detection of events.
 * @param sup Reference to the superclass object.
 * @param formNumber Meter form designation per ANSI C12.10 or other applicable standard.
 *        An alphanumeric designation denoting the circuit arrangement for which the meter is applicable and its specific terminal arrangement.
 */
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
    override def copy (): Row = { return (clone ().asInstanceOf[Meter]) }
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
        (if (null != formNumber) "\t\t<cim:Meter.formNumber>" + formNumber + "</cim:Meter.formNumber>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Meter rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Meter>\n"
    }
}

object Meter
extends
    Parseable[Meter]
{
    val formNumber = parse_element (element ("""Meter.formNumber"""))
    def parse (context: Context): Meter =
    {
        Meter(
            EndDevice.parse (context),
            formNumber (context)
        )
    }
}

/**
 * Multiplier applied at the meter.
 * @param sup Reference to the superclass object.
 * @param kind Kind of multiplier.
 * @param value Multiplier value.
 * @param Meter Meter applying this multiplier.
 */
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
    override def copy (): Row = { return (clone ().asInstanceOf[MeterMultiplier]) }
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
        (if (null != kind) "\t\t<cim:MeterMultiplier.kind rdf:resource=\"#" + kind + "\"/>\n" else "") +
        "\t\t<cim:MeterMultiplier.value>" + value + "</cim:MeterMultiplier.value>\n" +
        (if (null != Meter) "\t\t<cim:MeterMultiplier.Meter rdf:resource=\"#" + Meter + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MeterMultiplier rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MeterMultiplier>\n"
    }
}

object MeterMultiplier
extends
    Parseable[MeterMultiplier]
{
    val kind = parse_attribute (attribute ("""MeterMultiplier.kind"""))
    val value = parse_element (element ("""MeterMultiplier.value"""))
    val Meter = parse_attribute (attribute ("""MeterMultiplier.Meter"""))
    def parse (context: Context): MeterMultiplier =
    {
        MeterMultiplier(
            IdentifiedObject.parse (context),
            kind (context),
            toDouble (value (context), context),
            Meter (context)
        )
    }
}

/**
 * Kind of meter multiplier.
 * @param sup Reference to the superclass object.
 * @param ctRatio Current transformer ratio used to convert associated quantities to real measurements.
 * @param kE Test constant.
 * @param kH Meter kh (watthour) constant.
 *        The number of watthours that must be applied to the meter to cause one disk revolution for an electromechanical meter or the number of watthours represented by one increment pulse for an electronic meter.
 * @param kR Register multiplier.
 *        The number to multiply the register reading by in order to get kWh.
 * @param ptRatio Potential transformer ratio used to convert associated quantities to real measurements.
 * @param transformerRatio Product of the CT ratio and PT ratio.
 */
case class MeterMultiplierKind
(
    override val sup: BasicElement,
    val ctRatio: String,
    val kE: String,
    val kH: String,
    val kR: String,
    val ptRatio: String,
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
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != ctRatio) "\t\t<cim:MeterMultiplierKind.ctRatio rdf:resource=\"#" + ctRatio + "\"/>\n" else "") +
        (if (null != kE) "\t\t<cim:MeterMultiplierKind.kE rdf:resource=\"#" + kE + "\"/>\n" else "") +
        (if (null != kH) "\t\t<cim:MeterMultiplierKind.kH rdf:resource=\"#" + kH + "\"/>\n" else "") +
        (if (null != kR) "\t\t<cim:MeterMultiplierKind.kR rdf:resource=\"#" + kR + "\"/>\n" else "") +
        (if (null != ptRatio) "\t\t<cim:MeterMultiplierKind.ptRatio rdf:resource=\"#" + ptRatio + "\"/>\n" else "") +
        (if (null != transformerRatio) "\t\t<cim:MeterMultiplierKind.transformerRatio rdf:resource=\"#" + transformerRatio + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MeterMultiplierKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MeterMultiplierKind>\n"
    }
}

object MeterMultiplierKind
extends
    Parseable[MeterMultiplierKind]
{
    val ctRatio = parse_attribute (attribute ("""MeterMultiplierKind.ctRatio"""))
    val kE = parse_attribute (attribute ("""MeterMultiplierKind.kE"""))
    val kH = parse_attribute (attribute ("""MeterMultiplierKind.kH"""))
    val kR = parse_attribute (attribute ("""MeterMultiplierKind.kR"""))
    val ptRatio = parse_attribute (attribute ("""MeterMultiplierKind.ptRatio"""))
    val transformerRatio = parse_attribute (attribute ("""MeterMultiplierKind.transformerRatio"""))
    def parse (context: Context): MeterMultiplierKind =
    {
        MeterMultiplierKind(
            BasicElement.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param isCoincidentTrigger If true, this meter reading is the meter reading for which other coincident meter readings are requested or provided.
 * @param valuesInterval Date and time interval of the data items contained within this meter reading.
 * @param CustomerAgreement (could be deprecated in the future) Customer agreement for this meter reading.
 * @param Meter Meter providing this reading.
 * @param UsagePoint Usage point from which this meter reading (set of values) has been obtained.
 */
case class MeterReading
(
    override val sup: IdentifiedObject,
    val isCoincidentTrigger: Boolean,
    val valuesInterval: String,
    val CustomerAgreement: String,
    val Meter: String,
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
    override def export_fields: String =
    {
        sup.export_fields +
        "\t\t<cim:MeterReading.isCoincidentTrigger>" + isCoincidentTrigger + "</cim:MeterReading.isCoincidentTrigger>\n" +
        (if (null != valuesInterval) "\t\t<cim:MeterReading.valuesInterval rdf:resource=\"#" + valuesInterval + "\"/>\n" else "") +
        (if (null != CustomerAgreement) "\t\t<cim:MeterReading.CustomerAgreement rdf:resource=\"#" + CustomerAgreement + "\"/>\n" else "") +
        (if (null != Meter) "\t\t<cim:MeterReading.Meter rdf:resource=\"#" + Meter + "\"/>\n" else "") +
        (if (null != UsagePoint) "\t\t<cim:MeterReading.UsagePoint rdf:resource=\"#" + UsagePoint + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MeterReading rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MeterReading>\n"
    }
}

object MeterReading
extends
    Parseable[MeterReading]
{
    val isCoincidentTrigger = parse_element (element ("""MeterReading.isCoincidentTrigger"""))
    val valuesInterval = parse_attribute (attribute ("""MeterReading.valuesInterval"""))
    val CustomerAgreement = parse_attribute (attribute ("""MeterReading.CustomerAgreement"""))
    val Meter = parse_attribute (attribute ("""MeterReading.Meter"""))
    val UsagePoint = parse_attribute (attribute ("""MeterReading.UsagePoint"""))
    def parse (context: Context): MeterReading =
    {
        MeterReading(
            IdentifiedObject.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param Meter Meter on which this non-replacement work is performed.
 * @param OldMeter Old meter replaced by this work.
 * @param UsagePoint Usage point to which this meter service work applies.
 */
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
    override def copy (): Row = { return (clone ().asInstanceOf[MeterServiceWork]) }
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
        (if (null != Meter) "\t\t<cim:MeterServiceWork.Meter rdf:resource=\"#" + Meter + "\"/>\n" else "") +
        (if (null != OldMeter) "\t\t<cim:MeterServiceWork.OldMeter rdf:resource=\"#" + OldMeter + "\"/>\n" else "") +
        (if (null != UsagePoint) "\t\t<cim:MeterServiceWork.UsagePoint rdf:resource=\"#" + UsagePoint + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MeterServiceWork rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MeterServiceWork>\n"
    }
}

object MeterServiceWork
extends
    Parseable[MeterServiceWork]
{
    val Meter = parse_attribute (attribute ("""MeterServiceWork.Meter"""))
    val OldMeter = parse_attribute (attribute ("""MeterServiceWork.OldMeter"""))
    val UsagePoint = parse_attribute (attribute ("""MeterServiceWork.UsagePoint"""))
    def parse (context: Context): MeterServiceWork =
    {
        MeterServiceWork(
            Work.parse (context),
            Meter (context),
            OldMeter (context),
            UsagePoint (context)
        )
    }
}

/**
 * A specification of the metering requirements for a particular point within a network.
 * @param sup Reference to the superclass object.
 * @param reason Reason for this metrology requirement being specified.
 * @param UsagePoints All usage points having this metrology requirement.
 */
case class MetrologyRequirement
(
    override val sup: IdentifiedObject,
    val reason: String,
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
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != reason) "\t\t<cim:MetrologyRequirement.reason rdf:resource=\"#" + reason + "\"/>\n" else "") +
        (if (null != UsagePoints) UsagePoints.map (x => "\t\t<cim:MetrologyRequirement.UsagePoints rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:MetrologyRequirement rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MetrologyRequirement>\n"
    }
}

object MetrologyRequirement
extends
    Parseable[MetrologyRequirement]
{
    val reason = parse_attribute (attribute ("""MetrologyRequirement.reason"""))
    val UsagePoints = parse_attributes (attribute ("""MetrologyRequirement.UsagePoints"""))
    def parse (context: Context): MetrologyRequirement =
    {
        MetrologyRequirement(
            IdentifiedObject.parse (context),
            reason (context),
            UsagePoints (context)
        )
    }
}

/**
 * PAN control used to issue action/command to PAN devices during a demand response/load control event.
 * @param sup Reference to the superclass object.
 * @param appliance Appliance being controlled.
 * @param avgLoadAdjustment Used to define a maximum energy usage limit as a percentage of the client implementations specific average energy usage.
 *        The load adjustment percentage is added to 100% creating a percentage limit applied to the client implementations specific average energy usage. A -10% load adjustment percentage will establish an energy usage limit equal to 90% of the client implementations specific average energy usage. Each load adjustment percentage is referenced to the client implementations specific average energy usage. There are no cumulative effects.
 * @param cancelControlMode Encoding of cancel control.
 * @param cancelDateTime Timestamp when a canceling of the event is scheduled to start.
 * @param cancelNow If true, a canceling of the event should start immediately.
 * @param coolingOffset Requested offset to apply to the normal cooling setpoint at the time of the start of the event.
 *        It represents a temperature change that will be applied to the associated cooling set point. The temperature offsets will be calculated per the local temperature in the thermostat. The calculated temperature will be interpreted as the number of degrees to be added to the cooling set point. Sequential demand response events are not cumulative. The offset shall be applied to the normal setpoint.
 * @param coolingSetpoint Requested cooling set point.
 *        Temperature set point is typically defined and calculated based on local temperature.
 * @param criticalityLevel Level of criticality for the action of this control.
 *        The action taken by load control devices for an event can be solely based on this value, or in combination with other load control event fields supported by the device.
 * @param dutyCycle Maximum "on" state duty cycle as a percentage of time.
 *        For example, if the value is 80, the device would be in an "on" state for 80% of the time for the duration of the action.
 * @param enrollmentGroup Provides a mechanism to direct load control actions to groups of PAN devices.
 *        It can be used in conjunction with the PAN device types.
 * @param heatingOffset Requested offset to apply to the normal heating setpoint at the time of the start of the event.
 *        It represents a temperature change that will be applied to the associated heating set point. The temperature offsets will be calculated per the local temperature in the thermostat. The calculated temperature will be interpreted as the number of degrees to be subtracted from the heating set point. Sequential demand response events are not cumulative. The offset shall be applied to the normal setpoint.
 * @param heatingSetpoint Requested heating set point.
 *        Temperature set point is typically defined and calculated based on local temperature.
 */
case class PanDemandResponse
(
    override val sup: EndDeviceAction,
    val appliance: String,
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
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != appliance) "\t\t<cim:PanDemandResponse.appliance rdf:resource=\"#" + appliance + "\"/>\n" else "") +
        "\t\t<cim:PanDemandResponse.avgLoadAdjustment>" + avgLoadAdjustment + "</cim:PanDemandResponse.avgLoadAdjustment>\n" +
        (if (null != cancelControlMode) "\t\t<cim:PanDemandResponse.cancelControlMode>" + cancelControlMode + "</cim:PanDemandResponse.cancelControlMode>\n" else "") +
        (if (null != cancelDateTime) "\t\t<cim:PanDemandResponse.cancelDateTime>" + cancelDateTime + "</cim:PanDemandResponse.cancelDateTime>\n" else "") +
        "\t\t<cim:PanDemandResponse.cancelNow>" + cancelNow + "</cim:PanDemandResponse.cancelNow>\n" +
        "\t\t<cim:PanDemandResponse.coolingOffset>" + coolingOffset + "</cim:PanDemandResponse.coolingOffset>\n" +
        "\t\t<cim:PanDemandResponse.coolingSetpoint>" + coolingSetpoint + "</cim:PanDemandResponse.coolingSetpoint>\n" +
        (if (null != criticalityLevel) "\t\t<cim:PanDemandResponse.criticalityLevel>" + criticalityLevel + "</cim:PanDemandResponse.criticalityLevel>\n" else "") +
        "\t\t<cim:PanDemandResponse.dutyCycle>" + dutyCycle + "</cim:PanDemandResponse.dutyCycle>\n" +
        (if (null != enrollmentGroup) "\t\t<cim:PanDemandResponse.enrollmentGroup>" + enrollmentGroup + "</cim:PanDemandResponse.enrollmentGroup>\n" else "") +
        "\t\t<cim:PanDemandResponse.heatingOffset>" + heatingOffset + "</cim:PanDemandResponse.heatingOffset>\n" +
        "\t\t<cim:PanDemandResponse.heatingSetpoint>" + heatingSetpoint + "</cim:PanDemandResponse.heatingSetpoint>\n"
    }
    override def export: String =
    {
        "\t<cim:PanDemandResponse rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PanDemandResponse>\n"
    }
}

object PanDemandResponse
extends
    Parseable[PanDemandResponse]
{
    val appliance = parse_attribute (attribute ("""PanDemandResponse.appliance"""))
    val avgLoadAdjustment = parse_element (element ("""PanDemandResponse.avgLoadAdjustment"""))
    val cancelControlMode = parse_element (element ("""PanDemandResponse.cancelControlMode"""))
    val cancelDateTime = parse_element (element ("""PanDemandResponse.cancelDateTime"""))
    val cancelNow = parse_element (element ("""PanDemandResponse.cancelNow"""))
    val coolingOffset = parse_element (element ("""PanDemandResponse.coolingOffset"""))
    val coolingSetpoint = parse_element (element ("""PanDemandResponse.coolingSetpoint"""))
    val criticalityLevel = parse_element (element ("""PanDemandResponse.criticalityLevel"""))
    val dutyCycle = parse_element (element ("""PanDemandResponse.dutyCycle"""))
    val enrollmentGroup = parse_element (element ("""PanDemandResponse.enrollmentGroup"""))
    val heatingOffset = parse_element (element ("""PanDemandResponse.heatingOffset"""))
    val heatingSetpoint = parse_element (element ("""PanDemandResponse.heatingSetpoint"""))
    def parse (context: Context): PanDemandResponse =
    {
        PanDemandResponse(
            EndDeviceAction.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param confirmationRequired If true, the requesting entity (e.g. retail electric provider) requires confirmation of the successful display of the text message.
 * @param priority Priority associated with the text message to be displayed.
 * @param textMessage Text to be displayed by a PAN device.
 * @param transmissionMode Transmission mode to be used for this PAN display control.
 */
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
    override def copy (): Row = { return (clone ().asInstanceOf[PanDisplay]) }
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
        "\t\t<cim:PanDisplay.confirmationRequired>" + confirmationRequired + "</cim:PanDisplay.confirmationRequired>\n" +
        (if (null != priority) "\t\t<cim:PanDisplay.priority>" + priority + "</cim:PanDisplay.priority>\n" else "") +
        (if (null != textMessage) "\t\t<cim:PanDisplay.textMessage>" + textMessage + "</cim:PanDisplay.textMessage>\n" else "") +
        (if (null != transmissionMode) "\t\t<cim:PanDisplay.transmissionMode rdf:resource=\"#" + transmissionMode + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:PanDisplay rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PanDisplay>\n"
    }
}

object PanDisplay
extends
    Parseable[PanDisplay]
{
    val confirmationRequired = parse_element (element ("""PanDisplay.confirmationRequired"""))
    val priority = parse_element (element ("""PanDisplay.priority"""))
    val textMessage = parse_element (element ("""PanDisplay.textMessage"""))
    val transmissionMode = parse_attribute (attribute ("""PanDisplay.transmissionMode"""))
    def parse (context: Context): PanDisplay =
    {
        PanDisplay(
            EndDeviceAction.parse (context),
            toBoolean (confirmationRequired (context), context),
            priority (context),
            textMessage (context),
            transmissionMode (context)
        )
    }
}

/**
 * PAN action/command used to issue pricing information to a PAN device.
 * @param sup Reference to the superclass object.
 * @param providerID Unique identifier for the commodity provider.
 */
case class PanPricing
(
    override val sup: EndDeviceAction,
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
    override def export_fields: String =
    {
        sup.export_fields +
        "\t\t<cim:PanPricing.providerID>" + providerID + "</cim:PanPricing.providerID>\n"
    }
    override def export: String =
    {
        "\t<cim:PanPricing rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PanPricing>\n"
    }
}

object PanPricing
extends
    Parseable[PanPricing]
{
    val providerID = parse_element (element ("""PanPricing.providerID"""))
    def parse (context: Context): PanPricing =
    {
        PanPricing(
            EndDeviceAction.parse (context),
            toInteger (providerID (context), context)
        )
    }
}

/**
 * Detail for a single price command/action.
 * @param sup Reference to the superclass object.
 * @param alternateCostDelivered Alternative measure of the cost of the energy consumed.
 *        An example might be the emissions of CO2 for each kWh of electricity consumed providing a measure of the environmental cost.
 * @param alternateCostUnit Cost unit for the alternate cost delivered field.
 *        One example is kg of CO2 per unit of measure.
 * @param currentTimeDate Current time as determined by a PAN device.
 * @param generationPrice Price of the commodity measured in base unit of currency per 'unitOfMeasure'.
 * @param generationPriceRatio Ratio of 'generationPrice' to the "normal" price chosen by the commodity provider.
 * @param price Price of the commodity measured in base unit of currency per 'unitOfMeasure'.
 * @param priceRatio Ratio of 'price' to the "normal" price chosen by the commodity provider.
 * @param priceTier Pricing tier as chosen by the commodity provider.
 * @param priceTierCount Maximum number of price tiers available.
 * @param priceTierLabel Label for price tier.
 * @param rateLabel Label of the current billing rate specified by commodity provider.
 * @param registerTier Register tier accumulating usage information.
 * @param unitOfMeasure Defines commodity as well as its base unit of measure.
 * @param PanPricing PAN pricing command/action issuing this price detail.
 */
case class PanPricingDetail
(
    override val sup: BasicElement,
    val alternateCostDelivered: Double,
    val alternateCostUnit: String,
    val currentTimeDate: String,
    val generationPrice: Double,
    val generationPriceRatio: Double,
    val price: Double,
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
    override def export_fields: String =
    {
        sup.export_fields +
        "\t\t<cim:PanPricingDetail.alternateCostDelivered>" + alternateCostDelivered + "</cim:PanPricingDetail.alternateCostDelivered>\n" +
        (if (null != alternateCostUnit) "\t\t<cim:PanPricingDetail.alternateCostUnit>" + alternateCostUnit + "</cim:PanPricingDetail.alternateCostUnit>\n" else "") +
        (if (null != currentTimeDate) "\t\t<cim:PanPricingDetail.currentTimeDate>" + currentTimeDate + "</cim:PanPricingDetail.currentTimeDate>\n" else "") +
        "\t\t<cim:PanPricingDetail.generationPrice>" + generationPrice + "</cim:PanPricingDetail.generationPrice>\n" +
        "\t\t<cim:PanPricingDetail.generationPriceRatio>" + generationPriceRatio + "</cim:PanPricingDetail.generationPriceRatio>\n" +
        "\t\t<cim:PanPricingDetail.price>" + price + "</cim:PanPricingDetail.price>\n" +
        "\t\t<cim:PanPricingDetail.priceRatio>" + priceRatio + "</cim:PanPricingDetail.priceRatio>\n" +
        "\t\t<cim:PanPricingDetail.priceTier>" + priceTier + "</cim:PanPricingDetail.priceTier>\n" +
        "\t\t<cim:PanPricingDetail.priceTierCount>" + priceTierCount + "</cim:PanPricingDetail.priceTierCount>\n" +
        (if (null != priceTierLabel) "\t\t<cim:PanPricingDetail.priceTierLabel>" + priceTierLabel + "</cim:PanPricingDetail.priceTierLabel>\n" else "") +
        (if (null != rateLabel) "\t\t<cim:PanPricingDetail.rateLabel>" + rateLabel + "</cim:PanPricingDetail.rateLabel>\n" else "") +
        (if (null != registerTier) "\t\t<cim:PanPricingDetail.registerTier>" + registerTier + "</cim:PanPricingDetail.registerTier>\n" else "") +
        (if (null != unitOfMeasure) "\t\t<cim:PanPricingDetail.unitOfMeasure>" + unitOfMeasure + "</cim:PanPricingDetail.unitOfMeasure>\n" else "") +
        (if (null != PanPricing) "\t\t<cim:PanPricingDetail.PanPricing rdf:resource=\"#" + PanPricing + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:PanPricingDetail rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PanPricingDetail>\n"
    }
}

object PanPricingDetail
extends
    Parseable[PanPricingDetail]
{
    val alternateCostDelivered = parse_element (element ("""PanPricingDetail.alternateCostDelivered"""))
    val alternateCostUnit = parse_element (element ("""PanPricingDetail.alternateCostUnit"""))
    val currentTimeDate = parse_element (element ("""PanPricingDetail.currentTimeDate"""))
    val generationPrice = parse_element (element ("""PanPricingDetail.generationPrice"""))
    val generationPriceRatio = parse_element (element ("""PanPricingDetail.generationPriceRatio"""))
    val price = parse_element (element ("""PanPricingDetail.price"""))
    val priceRatio = parse_element (element ("""PanPricingDetail.priceRatio"""))
    val priceTier = parse_element (element ("""PanPricingDetail.priceTier"""))
    val priceTierCount = parse_element (element ("""PanPricingDetail.priceTierCount"""))
    val priceTierLabel = parse_element (element ("""PanPricingDetail.priceTierLabel"""))
    val rateLabel = parse_element (element ("""PanPricingDetail.rateLabel"""))
    val registerTier = parse_element (element ("""PanPricingDetail.registerTier"""))
    val unitOfMeasure = parse_element (element ("""PanPricingDetail.unitOfMeasure"""))
    val PanPricing = parse_attribute (attribute ("""PanPricingDetail.PanPricing"""))
    def parse (context: Context): PanPricingDetail =
    {
        PanPricingDetail(
            BasicElement.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param multiplyBeforeAdd Whether scalars should be applied before adding the 'offset'.
 * @param offset (if applicable) Offset to be added as well as multiplication using scalars.
 * @param scalarDenominator (if scalar is rational number) When 'IntervalReading.value' is multiplied by 'scalarNumerator' and divided by this value, it causes a unit of measure conversion to occur, resulting in the 'ReadingType.unit'.
 * @param scalarFloat (if scalar is floating number) When multiplied with 'IntervalReading.value', it causes a unit of measure conversion to occur, according to the 'ReadingType.unit'.
 * @param scalarNumerator (if scalar is integer or rational number)  When the scalar is a simple integer, and this attribute is presented alone and multiplied with 'IntervalReading.value', it causes a unit of measure conversion to occur, resulting in the 'ReadingType.unit'.
 *        It is never used in conjunction with 'scalarFloat', only with 'scalarDenominator'.
 * @param ReadingType Reading type resulting from this pending conversion.
 */
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
    override def copy (): Row = { return (clone ().asInstanceOf[PendingCalculation]) }
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
        "\t\t<cim:PendingCalculation.multiplyBeforeAdd>" + multiplyBeforeAdd + "</cim:PendingCalculation.multiplyBeforeAdd>\n" +
        "\t\t<cim:PendingCalculation.offset>" + offset + "</cim:PendingCalculation.offset>\n" +
        "\t\t<cim:PendingCalculation.scalarDenominator>" + scalarDenominator + "</cim:PendingCalculation.scalarDenominator>\n" +
        "\t\t<cim:PendingCalculation.scalarFloat>" + scalarFloat + "</cim:PendingCalculation.scalarFloat>\n" +
        "\t\t<cim:PendingCalculation.scalarNumerator>" + scalarNumerator + "</cim:PendingCalculation.scalarNumerator>\n" +
        (if (null != ReadingType) "\t\t<cim:PendingCalculation.ReadingType rdf:resource=\"#" + ReadingType + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:PendingCalculation rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PendingCalculation>\n"
    }
}

object PendingCalculation
extends
    Parseable[PendingCalculation]
{
    val multiplyBeforeAdd = parse_element (element ("""PendingCalculation.multiplyBeforeAdd"""))
    val offset = parse_element (element ("""PendingCalculation.offset"""))
    val scalarDenominator = parse_element (element ("""PendingCalculation.scalarDenominator"""))
    val scalarFloat = parse_element (element ("""PendingCalculation.scalarFloat"""))
    val scalarNumerator = parse_element (element ("""PendingCalculation.scalarNumerator"""))
    val ReadingType = parse_attribute (attribute ("""PendingCalculation.ReadingType"""))
    def parse (context: Context): PendingCalculation =
    {
        PendingCalculation(
            BasicElement.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param default Randomisation of start and/or end times involving the operation of one or more devices is controlled by default settings for the device(s).
 * @param end End time of an event or control action affecting one or more devices is randomised to prevent simultaneous operation.
 * @param none Neither the start time nor the end time of an event or control action affecting one or more devices is randomised.
 * @param start Start time of an event or control action affecting one or more multiple devices is randomised.
 * @param startAndEnd Both the start time and the end time of an event or control action affecting one or more devices are randomised to prevent simultaneous operation.
 */
case class RandomisationKind
(
    override val sup: BasicElement,
    val default: String,
    val end: String,
    val none: String,
    val start: String,
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
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != default) "\t\t<cim:RandomisationKind.default rdf:resource=\"#" + default + "\"/>\n" else "") +
        (if (null != end) "\t\t<cim:RandomisationKind.end rdf:resource=\"#" + end + "\"/>\n" else "") +
        (if (null != none) "\t\t<cim:RandomisationKind.none rdf:resource=\"#" + none + "\"/>\n" else "") +
        (if (null != start) "\t\t<cim:RandomisationKind.start rdf:resource=\"#" + start + "\"/>\n" else "") +
        (if (null != startAndEnd) "\t\t<cim:RandomisationKind.startAndEnd rdf:resource=\"#" + startAndEnd + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:RandomisationKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RandomisationKind>\n"
    }
}

object RandomisationKind
extends
    Parseable[RandomisationKind]
{
    val default = parse_attribute (attribute ("""RandomisationKind.default"""))
    val end = parse_attribute (attribute ("""RandomisationKind.end"""))
    val none = parse_attribute (attribute ("""RandomisationKind.none"""))
    val start = parse_attribute (attribute ("""RandomisationKind.start"""))
    val startAndEnd = parse_attribute (attribute ("""RandomisationKind.startAndEnd"""))
    def parse (context: Context): RandomisationKind =
    {
        RandomisationKind(
            BasicElement.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param denominator Denominator.
 *        Value 1 indicates the number is a simple integer.
 * @param numerator Numerator.
 */
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
    override def copy (): Row = { return (clone ().asInstanceOf[RationalNumber]) }
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
        "\t\t<cim:RationalNumber.denominator>" + denominator + "</cim:RationalNumber.denominator>\n" +
        "\t\t<cim:RationalNumber.numerator>" + numerator + "</cim:RationalNumber.numerator>\n"
    }
    override def export: String =
    {
        "\t<cim:RationalNumber rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RationalNumber>\n"
    }
}

object RationalNumber
extends
    Parseable[RationalNumber]
{
    val denominator = parse_element (element ("""RationalNumber.denominator"""))
    val numerator = parse_element (element ("""RationalNumber.numerator"""))
    def parse (context: Context): RationalNumber =
    {
        RationalNumber(
            BasicElement.parse (context),
            toInteger (denominator (context), context),
            toInteger (numerator (context), context)
        )
    }
}

/**
 * Specific value measured by a meter or other asset, or calculated by a system.
 * Each Reading is associated with a specific ReadingType.
 * @param sup Reference to the superclass object.
 * @param reason Reason for this reading being taken.
 * @param MeterReadings All meter readings (sets of values) containing this reading value.
 * @param ReadingType Type information for this reading value.
 */
case class Reading
(
    override val sup: BaseReading,
    val reason: String,
    val MeterReadings: List[String],
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
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != reason) "\t\t<cim:Reading.reason rdf:resource=\"#" + reason + "\"/>\n" else "") +
        (if (null != MeterReadings) MeterReadings.map (x => "\t\t<cim:Reading.MeterReadings rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != ReadingType) "\t\t<cim:Reading.ReadingType rdf:resource=\"#" + ReadingType + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Reading rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Reading>\n"
    }
}

object Reading
extends
    Parseable[Reading]
{
    val reason = parse_attribute (attribute ("""Reading.reason"""))
    val MeterReadings = parse_attributes (attribute ("""Reading.MeterReadings"""))
    val ReadingType = parse_attribute (attribute ("""Reading.ReadingType"""))
    def parse (context: Context): Reading =
    {
        Reading(
            BaseReading.parse (context),
            reason (context),
            MeterReadings (context),
            ReadingType (context)
        )
    }
}

/**
 * Interharmonics are represented as a rational number 'numerator' / 'denominator', and harmonics are represented using the same mechanism and identified by 'denominator'=1.
 * @param sup Reference to the superclass object.
 * @param denominator Interharmonic denominator.
 *        Value 0 means not applicable. Value 2 is used in combination with 'numerator'=1 to represent interharmonic 1/2. Finally, value 1 indicates the harmonic of the order specified with 'numerator'.
 * @param numerator Interharmonic numerator.
 *        Value 0 means not applicable. Value 1 is used in combination with 'denominator'=2 to represent interharmonic 1/2, and with 'denominator'=1 it represents fundamental frequency. Finally, values greater than 1 indicate the harmonic of that order (e.g., 'numerator'=5 is the fifth harmonic).
 */
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
    override def copy (): Row = { return (clone ().asInstanceOf[ReadingInterharmonic]) }
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
        "\t\t<cim:ReadingInterharmonic.denominator>" + denominator + "</cim:ReadingInterharmonic.denominator>\n" +
        "\t\t<cim:ReadingInterharmonic.numerator>" + numerator + "</cim:ReadingInterharmonic.numerator>\n"
    }
    override def export: String =
    {
        "\t<cim:ReadingInterharmonic rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ReadingInterharmonic>\n"
    }
}

object ReadingInterharmonic
extends
    Parseable[ReadingInterharmonic]
{
    val denominator = parse_element (element ("""ReadingInterharmonic.denominator"""))
    val numerator = parse_element (element ("""ReadingInterharmonic.numerator"""))
    def parse (context: Context): ReadingInterharmonic =
    {
        ReadingInterharmonic(
            BasicElement.parse (context),
            toInteger (denominator (context), context),
            toInteger (numerator (context), context)
        )
    }
}

/**
 * Quality of a specific reading value or interval reading value.
 * Note that more than one quality may be applicable to a given reading. Typically not used unless problems or unusual conditions occur (i.e., quality for each reading is assumed to be good unless stated otherwise in associated reading quality type). It can also be used with the corresponding reading quality type to indicate that the validation has been performed and succeeded.
 * @param sup Reference to the superclass object.
 * @param comment Elaboration on the quality code.
 * @param source System acting as the source of the quality code.
 * @param timeStamp Date and time at which the quality code was assigned or ascertained.
 * @param Reading Reading value to which this quality applies.
 * @param ReadingQualityType Type of this reading quality.
 */
case class ReadingQuality
(
    override val sup: BasicElement,
    val comment: String,
    val source: String,
    val timeStamp: String,
    val Reading: String,
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
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != comment) "\t\t<cim:ReadingQuality.comment>" + comment + "</cim:ReadingQuality.comment>\n" else "") +
        (if (null != source) "\t\t<cim:ReadingQuality.source>" + source + "</cim:ReadingQuality.source>\n" else "") +
        (if (null != timeStamp) "\t\t<cim:ReadingQuality.timeStamp>" + timeStamp + "</cim:ReadingQuality.timeStamp>\n" else "") +
        (if (null != Reading) "\t\t<cim:ReadingQuality.Reading rdf:resource=\"#" + Reading + "\"/>\n" else "") +
        (if (null != ReadingQualityType) "\t\t<cim:ReadingQuality.ReadingQualityType rdf:resource=\"#" + ReadingQualityType + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ReadingQuality rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ReadingQuality>\n"
    }
}

object ReadingQuality
extends
    Parseable[ReadingQuality]
{
    val comment = parse_element (element ("""ReadingQuality.comment"""))
    val source = parse_element (element ("""ReadingQuality.source"""))
    val timeStamp = parse_element (element ("""ReadingQuality.timeStamp"""))
    val Reading = parse_attribute (attribute ("""ReadingQuality.Reading"""))
    val ReadingQualityType = parse_attribute (attribute ("""ReadingQuality.ReadingQualityType"""))
    def parse (context: Context): ReadingQuality =
    {
        ReadingQuality(
            BasicElement.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param category High-level nature of the reading value quality.
 * @param subCategory More specific nature of the reading value quality, as a further sub-categorisation of 'category'.
 * @param systemId Identification of the system which has declared the issue with the data or provided commentary on the data.
 */
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
    override def copy (): Row = { return (clone ().asInstanceOf[ReadingQualityType]) }
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
        (if (null != category) "\t\t<cim:ReadingQualityType.category>" + category + "</cim:ReadingQualityType.category>\n" else "") +
        (if (null != subCategory) "\t\t<cim:ReadingQualityType.subCategory>" + subCategory + "</cim:ReadingQualityType.subCategory>\n" else "") +
        (if (null != systemId) "\t\t<cim:ReadingQualityType.systemId>" + systemId + "</cim:ReadingQualityType.systemId>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ReadingQualityType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ReadingQualityType>\n"
    }
}

object ReadingQualityType
extends
    Parseable[ReadingQualityType]
{
    val category = parse_element (element ("""ReadingQualityType.category"""))
    val subCategory = parse_element (element ("""ReadingQualityType.subCategory"""))
    val systemId = parse_element (element ("""ReadingQualityType.systemId"""))
    def parse (context: Context): ReadingQualityType =
    {
        ReadingQualityType(
            IdentifiedObject.parse (context),
            category (context),
            subCategory (context),
            systemId (context)
        )
    }
}

/**
 * Reason for the reading being taken.
 * @param sup Reference to the superclass object.
 * @param billing Reading(s) taken or to be taken in response to a billing-related inquiry by a customer or other party.
 *        A variant of 'inquiry'.
 * @param demandReset Reading(s) taken or to be taken in conjunction with the resetting of one or more demand registers in a meter.
 * @param inquiry Reading(s) taken or to be taken in response to an inquiry by a customer or other party.
 * @param installation Reading(s) taken or to be taken in conjunction with installation of a meter.
 * @param loadManagement Reading(s) taken or to be taken to support management of loads on distribution networks or devices.
 * @param loadResearch Reading(s) taken or to be taken to support research and analysis of loads on distribution networks or devices.
 * @param moveIn Reading(s) taken or to be taken in conjunction with a customer move-in event.
 * @param moveOut Reading(s) taken or to be taken in conjunction with a customer move-out event.
 * @param other Reading(s) taken or to be taken for some other reason or purpose.
 * @param removal Reading(s) taken or to be taken in conjunction with removal of a meter.
 * @param serviceConnect Reading(s) taken or to be taken in conjunction with a connection or re-connection of service.
 * @param serviceDisconnect Reading(s) taken or to be taken in conjunction with a disconnection of service.
 */
case class ReadingReasonKind
(
    override val sup: BasicElement,
    val billing: String,
    val demandReset: String,
    val inquiry: String,
    val installation: String,
    val loadManagement: String,
    val loadResearch: String,
    val moveIn: String,
    val moveOut: String,
    val other: String,
    val removal: String,
    val serviceConnect: String,
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
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != billing) "\t\t<cim:ReadingReasonKind.billing rdf:resource=\"#" + billing + "\"/>\n" else "") +
        (if (null != demandReset) "\t\t<cim:ReadingReasonKind.demandReset rdf:resource=\"#" + demandReset + "\"/>\n" else "") +
        (if (null != inquiry) "\t\t<cim:ReadingReasonKind.inquiry rdf:resource=\"#" + inquiry + "\"/>\n" else "") +
        (if (null != installation) "\t\t<cim:ReadingReasonKind.installation rdf:resource=\"#" + installation + "\"/>\n" else "") +
        (if (null != loadManagement) "\t\t<cim:ReadingReasonKind.loadManagement rdf:resource=\"#" + loadManagement + "\"/>\n" else "") +
        (if (null != loadResearch) "\t\t<cim:ReadingReasonKind.loadResearch rdf:resource=\"#" + loadResearch + "\"/>\n" else "") +
        (if (null != moveIn) "\t\t<cim:ReadingReasonKind.moveIn rdf:resource=\"#" + moveIn + "\"/>\n" else "") +
        (if (null != moveOut) "\t\t<cim:ReadingReasonKind.moveOut rdf:resource=\"#" + moveOut + "\"/>\n" else "") +
        (if (null != other) "\t\t<cim:ReadingReasonKind.other rdf:resource=\"#" + other + "\"/>\n" else "") +
        (if (null != removal) "\t\t<cim:ReadingReasonKind.removal rdf:resource=\"#" + removal + "\"/>\n" else "") +
        (if (null != serviceConnect) "\t\t<cim:ReadingReasonKind.serviceConnect rdf:resource=\"#" + serviceConnect + "\"/>\n" else "") +
        (if (null != serviceDisconnect) "\t\t<cim:ReadingReasonKind.serviceDisconnect rdf:resource=\"#" + serviceDisconnect + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ReadingReasonKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ReadingReasonKind>\n"
    }
}

object ReadingReasonKind
extends
    Parseable[ReadingReasonKind]
{
    val billing = parse_attribute (attribute ("""ReadingReasonKind.billing"""))
    val demandReset = parse_attribute (attribute ("""ReadingReasonKind.demandReset"""))
    val inquiry = parse_attribute (attribute ("""ReadingReasonKind.inquiry"""))
    val installation = parse_attribute (attribute ("""ReadingReasonKind.installation"""))
    val loadManagement = parse_attribute (attribute ("""ReadingReasonKind.loadManagement"""))
    val loadResearch = parse_attribute (attribute ("""ReadingReasonKind.loadResearch"""))
    val moveIn = parse_attribute (attribute ("""ReadingReasonKind.moveIn"""))
    val moveOut = parse_attribute (attribute ("""ReadingReasonKind.moveOut"""))
    val other = parse_attribute (attribute ("""ReadingReasonKind.other"""))
    val removal = parse_attribute (attribute ("""ReadingReasonKind.removal"""))
    val serviceConnect = parse_attribute (attribute ("""ReadingReasonKind.serviceConnect"""))
    val serviceDisconnect = parse_attribute (attribute ("""ReadingReasonKind.serviceDisconnect"""))
    def parse (context: Context): ReadingReasonKind =
    {
        ReadingReasonKind(
            BasicElement.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param accumulation Accumulation behaviour of a reading over time, usually 'measuringPeriod', to be used with individual endpoints (as opposed to 'macroPeriod' and 'aggregate' that are used to describe aggregations of data from individual endpoints).
 * @param aggregate Salient attribute of the reading data aggregated from individual endpoints.
 *        This is mainly used to define a mathematical operation carried out over 'macroPeriod', but may also be used to describe an attribute of the data when the 'macroPeriod' is not defined.
 * @param argument Argument used to introduce numbers into the unit of measure description where they are needed (e.g., 4 where the measure needs an argument such as CEMI(n=4)).
 *        Most arguments used in practice however will be integers (i.e., 'denominator'=1).
 * @param commodity Commodity being measured.
 * @param consumptionTier In case of common flat-rate pricing for power, in which all purchases are at a given rate, 'consumptionTier'=0.
 *        Otherwise, the value indicates the consumption tier, which can be used in conjunction with TOU or CPP pricing.
 * @param cpp Critical peak period (CPP) bucket the reading value is attributed to.
 *        Value 0 means not applicable. Even though CPP is usually considered a specialised form of time of use 'tou', this attribute is defined explicitly for flexibility.
 * @param currency Metering-specific currency.
 * @param flowDirection Flow direction for a reading where the direction of flow of the commodity is important (for electricity measurements this includes current, energy, power, and demand).
 * @param interharmonic Indication of a "harmonic" or "interharmonic" basis for the measurement.
 *        Value 0 in 'numerator' and 'denominator' means not applicable.
 * @param macroPeriod Time period of interest that reflects how the reading is viewed or captured over a long period of time.
 * @param measurementKind Identifies "what" is being measured, as refinement of 'commodity'.
 *        When combined with 'unit', it provides detail to the unit of measure. For example, 'energy' with a unit of measure of 'kWh' indicates to the user that active energy is being measured, while with 'kVAh' or 'kVArh', it indicates apparent energy and reactive energy, respectively. 'power' can be combined in a similar way with various power units of measure: Distortion power ('distortionVoltAmperes') with 'kVA' is different from 'power' with 'kVA'.
 * @param measuringPeriod Time attribute inherent or fundamental to the reading value (as opposed to 'macroPeriod' that supplies an "adjective" to describe aspects of a time period with regard to the measurement).
 *        It refers to the way the value was originally measured and not to the frequency at which it is reported or presented. For example, an hourly interval of consumption data would have value 'hourly' as an attribute. However in the case of an hourly sampled voltage value, the meterReadings schema would carry the 'hourly' interval size information.
 * @param multiplier Metering-specific multiplier.
 * @param phases Metering-specific phase code.
 * @param tou Time of use (TOU) bucket the reading value is attributed to.
 *        Value 0 means not applicable.
 * @param unit Metering-specific unit.
 * @param Channel Channel reporting/collecting register values with this type information.
 * @param PendingCalculation Pending calculation that produced this reading type.
 */
case class ReadingType
(
    override val sup: IdentifiedObject,
    val accumulation: String,
    val aggregate: String,
    val argument: String,
    val commodity: String,
    val consumptionTier: Int,
    val cpp: Int,
    val currency: String,
    val flowDirection: String,
    val interharmonic: String,
    val macroPeriod: String,
    val measurementKind: String,
    val measuringPeriod: String,
    val multiplier: String,
    val phases: String,
    val tou: Int,
    val unit: String,
    val Channel: String,
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
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != accumulation) "\t\t<cim:ReadingType.accumulation>" + accumulation + "</cim:ReadingType.accumulation>\n" else "") +
        (if (null != aggregate) "\t\t<cim:ReadingType.aggregate>" + aggregate + "</cim:ReadingType.aggregate>\n" else "") +
        (if (null != argument) "\t\t<cim:ReadingType.argument rdf:resource=\"#" + argument + "\"/>\n" else "") +
        (if (null != commodity) "\t\t<cim:ReadingType.commodity>" + commodity + "</cim:ReadingType.commodity>\n" else "") +
        "\t\t<cim:ReadingType.consumptionTier>" + consumptionTier + "</cim:ReadingType.consumptionTier>\n" +
        "\t\t<cim:ReadingType.cpp>" + cpp + "</cim:ReadingType.cpp>\n" +
        (if (null != currency) "\t\t<cim:ReadingType.currency>" + currency + "</cim:ReadingType.currency>\n" else "") +
        (if (null != flowDirection) "\t\t<cim:ReadingType.flowDirection>" + flowDirection + "</cim:ReadingType.flowDirection>\n" else "") +
        (if (null != interharmonic) "\t\t<cim:ReadingType.interharmonic rdf:resource=\"#" + interharmonic + "\"/>\n" else "") +
        (if (null != macroPeriod) "\t\t<cim:ReadingType.macroPeriod>" + macroPeriod + "</cim:ReadingType.macroPeriod>\n" else "") +
        (if (null != measurementKind) "\t\t<cim:ReadingType.measurementKind>" + measurementKind + "</cim:ReadingType.measurementKind>\n" else "") +
        (if (null != measuringPeriod) "\t\t<cim:ReadingType.measuringPeriod>" + measuringPeriod + "</cim:ReadingType.measuringPeriod>\n" else "") +
        (if (null != multiplier) "\t\t<cim:ReadingType.multiplier>" + multiplier + "</cim:ReadingType.multiplier>\n" else "") +
        (if (null != phases) "\t\t<cim:ReadingType.phases>" + phases + "</cim:ReadingType.phases>\n" else "") +
        "\t\t<cim:ReadingType.tou>" + tou + "</cim:ReadingType.tou>\n" +
        (if (null != unit) "\t\t<cim:ReadingType.unit>" + unit + "</cim:ReadingType.unit>\n" else "") +
        (if (null != Channel) "\t\t<cim:ReadingType.Channel rdf:resource=\"#" + Channel + "\"/>\n" else "") +
        (if (null != PendingCalculation) "\t\t<cim:ReadingType.PendingCalculation rdf:resource=\"#" + PendingCalculation + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ReadingType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ReadingType>\n"
    }
}

object ReadingType
extends
    Parseable[ReadingType]
{
    val accumulation = parse_element (element ("""ReadingType.accumulation"""))
    val aggregate = parse_element (element ("""ReadingType.aggregate"""))
    val argument = parse_attribute (attribute ("""ReadingType.argument"""))
    val commodity = parse_element (element ("""ReadingType.commodity"""))
    val consumptionTier = parse_element (element ("""ReadingType.consumptionTier"""))
    val cpp = parse_element (element ("""ReadingType.cpp"""))
    val currency = parse_element (element ("""ReadingType.currency"""))
    val flowDirection = parse_element (element ("""ReadingType.flowDirection"""))
    val interharmonic = parse_attribute (attribute ("""ReadingType.interharmonic"""))
    val macroPeriod = parse_element (element ("""ReadingType.macroPeriod"""))
    val measurementKind = parse_element (element ("""ReadingType.measurementKind"""))
    val measuringPeriod = parse_element (element ("""ReadingType.measuringPeriod"""))
    val multiplier = parse_element (element ("""ReadingType.multiplier"""))
    val phases = parse_element (element ("""ReadingType.phases"""))
    val tou = parse_element (element ("""ReadingType.tou"""))
    val unit = parse_element (element ("""ReadingType.unit"""))
    val Channel = parse_attribute (attribute ("""ReadingType.Channel"""))
    val PendingCalculation = parse_attribute (attribute ("""ReadingType.PendingCalculation"""))
    def parse (context: Context): ReadingType =
    {
        ReadingType(
            IdentifiedObject.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param isVirtual If true, the data it produces is  calculated or measured by a device other than a physical end device/meter.
 *        Otherwise, any data streams it produces are measured by the hardware of the end device/meter itself.
 * @param leftDigitCount Number of digits (dials on a mechanical meter) to the left of the decimal place; default is normally 5.
 * @param rightDigitCount Number of digits (dials on a mechanical meter) to the right of the decimal place.
 * @param touTier Clock time interval for register to beging/cease accumulating time of usage (e.g., start at 8:00 am, stop at 5:00 pm).
 * @param touTierName Name used for the time of use tier (also known as bin or bucket).
 *        For example, "peak", "off-peak", "TOU Category A", etc.
 * @param EndDeviceFunction End device function metering quantities displayed by this register.
 */
case class Register
(
    override val sup: IdentifiedObject,
    val isVirtual: Boolean,
    val leftDigitCount: Int,
    val rightDigitCount: Int,
    val touTier: String,
    val touTierName: String,
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
    override def export_fields: String =
    {
        sup.export_fields +
        "\t\t<cim:Register.isVirtual>" + isVirtual + "</cim:Register.isVirtual>\n" +
        "\t\t<cim:Register.leftDigitCount>" + leftDigitCount + "</cim:Register.leftDigitCount>\n" +
        "\t\t<cim:Register.rightDigitCount>" + rightDigitCount + "</cim:Register.rightDigitCount>\n" +
        (if (null != touTier) "\t\t<cim:Register.touTier rdf:resource=\"#" + touTier + "\"/>\n" else "") +
        (if (null != touTierName) "\t\t<cim:Register.touTierName>" + touTierName + "</cim:Register.touTierName>\n" else "") +
        (if (null != EndDeviceFunction) "\t\t<cim:Register.EndDeviceFunction rdf:resource=\"#" + EndDeviceFunction + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Register rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Register>\n"
    }
}

object Register
extends
    Parseable[Register]
{
    val isVirtual = parse_element (element ("""Register.isVirtual"""))
    val leftDigitCount = parse_element (element ("""Register.leftDigitCount"""))
    val rightDigitCount = parse_element (element ("""Register.rightDigitCount"""))
    val touTier = parse_attribute (attribute ("""Register.touTier"""))
    val touTierName = parse_element (element ("""Register.touTierName"""))
    val EndDeviceFunction = parse_attribute (attribute ("""Register.EndDeviceFunction"""))
    def parse (context: Context): Register =
    {
        Register(
            IdentifiedObject.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param kind Kind of multiplier.
 * @param value Multiplier value.
 * @param UsagePoint Usage point applying this multiplier.
 */
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
    override def copy (): Row = { return (clone ().asInstanceOf[ServiceMultiplier]) }
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
        (if (null != kind) "\t\t<cim:ServiceMultiplier.kind rdf:resource=\"#" + kind + "\"/>\n" else "") +
        "\t\t<cim:ServiceMultiplier.value>" + value + "</cim:ServiceMultiplier.value>\n" +
        (if (null != UsagePoint) "\t\t<cim:ServiceMultiplier.UsagePoint rdf:resource=\"#" + UsagePoint + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ServiceMultiplier rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ServiceMultiplier>\n"
    }
}

object ServiceMultiplier
extends
    Parseable[ServiceMultiplier]
{
    val kind = parse_attribute (attribute ("""ServiceMultiplier.kind"""))
    val value = parse_element (element ("""ServiceMultiplier.value"""))
    val UsagePoint = parse_attribute (attribute ("""ServiceMultiplier.UsagePoint"""))
    def parse (context: Context): ServiceMultiplier =
    {
        ServiceMultiplier(
            IdentifiedObject.parse (context),
            kind (context),
            toDouble (value (context), context),
            UsagePoint (context)
        )
    }
}

/**
 * Kind of service multiplier.
 * @param sup Reference to the superclass object.
 * @param ctRatio Current transformer ratio used to convert associated quantities to real measurements.
 * @param ptRatio Voltage transformer ratio used to convert associated quantities to real measurements.
 * @param transformerRatio Product of the CT ratio and PT ratio.
 */
case class ServiceMultiplierKind
(
    override val sup: BasicElement,
    val ctRatio: String,
    val ptRatio: String,
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
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != ctRatio) "\t\t<cim:ServiceMultiplierKind.ctRatio rdf:resource=\"#" + ctRatio + "\"/>\n" else "") +
        (if (null != ptRatio) "\t\t<cim:ServiceMultiplierKind.ptRatio rdf:resource=\"#" + ptRatio + "\"/>\n" else "") +
        (if (null != transformerRatio) "\t\t<cim:ServiceMultiplierKind.transformerRatio rdf:resource=\"#" + transformerRatio + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ServiceMultiplierKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ServiceMultiplierKind>\n"
    }
}

object ServiceMultiplierKind
extends
    Parseable[ServiceMultiplierKind]
{
    val ctRatio = parse_attribute (attribute ("""ServiceMultiplierKind.ctRatio"""))
    val ptRatio = parse_attribute (attribute ("""ServiceMultiplierKind.ptRatio"""))
    val transformerRatio = parse_attribute (attribute ("""ServiceMultiplierKind.transformerRatio"""))
    def parse (context: Context): ServiceMultiplierKind =
    {
        ServiceMultiplierKind(
            BasicElement.parse (context),
            ctRatio (context),
            ptRatio (context),
            transformerRatio (context)
        )
    }
}

/**
 * Simple end device function distinguished by 'kind'.
 * Use this class for instances that cannot be represented by another end device function specialisations.
 * @param sup Reference to the superclass object.
 * @param kind Kind of this function.
 */
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
    override def copy (): Row = { return (clone ().asInstanceOf[SimpleEndDeviceFunction]) }
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
        (if (null != kind) "\t\t<cim:SimpleEndDeviceFunction.kind rdf:resource=\"#" + kind + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SimpleEndDeviceFunction rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SimpleEndDeviceFunction>\n"
    }
}

object SimpleEndDeviceFunction
extends
    Parseable[SimpleEndDeviceFunction]
{
    val kind = parse_attribute (attribute ("""SimpleEndDeviceFunction.kind"""))
    def parse (context: Context): SimpleEndDeviceFunction =
    {
        SimpleEndDeviceFunction(
            EndDeviceFunction.parse (context),
            kind (context)
        )
    }
}

/**
 * Transmission mode for end device display controls, applicable to premises area network (PAN) devices.
 * @param sup Reference to the superclass object.
 * @param anonymous Message transmission mode whereby messages or commands are broadcast to unspecified devices listening for such communications.
 * @param both Message transmission mode whereby messages or commands are sent by both 'normal' and 'anonymous' methods.
 * @param normal Message transmission mode whereby messages or commands are sent to specific devices.
 */
case class TransmissionModeKind
(
    override val sup: BasicElement,
    val anonymous: String,
    val both: String,
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
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != anonymous) "\t\t<cim:TransmissionModeKind.anonymous rdf:resource=\"#" + anonymous + "\"/>\n" else "") +
        (if (null != both) "\t\t<cim:TransmissionModeKind.both rdf:resource=\"#" + both + "\"/>\n" else "") +
        (if (null != normal) "\t\t<cim:TransmissionModeKind.normal rdf:resource=\"#" + normal + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TransmissionModeKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TransmissionModeKind>\n"
    }
}

object TransmissionModeKind
extends
    Parseable[TransmissionModeKind]
{
    val anonymous = parse_attribute (attribute ("""TransmissionModeKind.anonymous"""))
    val both = parse_attribute (attribute ("""TransmissionModeKind.both"""))
    val normal = parse_attribute (attribute ("""TransmissionModeKind.normal"""))
    def parse (context: Context): TransmissionModeKind =
    {
        TransmissionModeKind(
            BasicElement.parse (context),
            anonymous (context),
            both (context),
            normal (context)
        )
    }
}

/**
 * Logical or physical point in the network to which readings or events may be attributed.
 * Used at the place where a physical or virtual meter may be located; however, it is not required that a meter be present.
 * @param sup Reference to the superclass object.
 * @param amiBillingReady Tracks the lifecycle of the metering installation at a usage point with respect to readiness for billing via advanced metering infrastructure reads.
 * @param checkBilling True if as a result of an inspection or otherwise, there is a reason to suspect that a previous billing may have been performed with erroneous data.
 *        Value should be reset once this potential discrepancy has been resolved.
 * @param connectionState State of the usage point with respect to connection to the network.
 * @param estimatedLoad Estimated load.
 * @param grounded True if grounded.
 * @param isSdp If true, this usage point is a service delivery point, i.e., a usage point where the ownership of the service changes hands.
 * @param isVirtual If true, this usage point is virtual, i.e., no physical location exists in the network where a meter could be located to collect the meter readings.
 *        For example, one may define a virtual usage point to serve as an aggregation of usage for all of a company's premises distributed widely across the distribution territory. Otherwise, the usage point is physical, i.e., there is a logical point in the network where a meter could be located to collect meter readings.
 * @param minimalUsageExpected If true, minimal or zero usage is expected at this usage point for situations such as premises vacancy, logical or physical disconnect.
 *        It is used for readings validation and estimation.
 * @param nominalServiceVoltage Nominal service voltage.
 * @param outageRegion Outage region in which this usage point is located.
 * @param phaseCode Phase code.
 *        Number of wires and specific nominal phases can be deduced from enumeration literal values. For example, ABCN is three-phase, four-wire, s12n (splitSecondary12N) is single-phase, three-wire, and s1n and s2n are single-phase, two-wire.
 * @param ratedCurrent Current flow that this usage point is configured to deliver.
 * @param ratedPower Active power that this usage point is configured to deliver.
 * @param readCycle Cycle day on which the meter for this usage point will normally be read.
 *        Usually correlated with the billing cycle.
 * @param readRoute Identifier of the route to which this usage point is assigned for purposes of meter reading.
 *        Typically used to configure hand held meter reading systems prior to collection of reads.
 * @param serviceDeliveryRemark Remarks about this usage point, for example the reason for it being rated with a non-nominal priority.
 * @param servicePriority Priority of service for this usage point.
 *        Note that usage points at the same service location can have different priorities.
 * @param CustomerAgreement Customer agreement regulating this service delivery point.
 * @param Equipments All equipment connecting this usage point to the electrical grid.
 * @param ServiceCategory Service category delivered by this usage point.
 * @param ServiceLocation Service location where the service delivered by this usage point is consumed.
 * @param ServiceSupplier ServiceSupplier (utility) utilising this usage point to deliver a service.
 * @param UsagePointLocation Location of this usage point.
 */
case class UsagePoint
(
    override val sup: IdentifiedObject,
    val amiBillingReady: String,
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
    val Equipments: List[String],
    val ServiceCategory: String,
    val ServiceLocation: String,
    val ServiceSupplier: String,
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
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != amiBillingReady) "\t\t<cim:UsagePoint.amiBillingReady rdf:resource=\"#" + amiBillingReady + "\"/>\n" else "") +
        "\t\t<cim:UsagePoint.checkBilling>" + checkBilling + "</cim:UsagePoint.checkBilling>\n" +
        (if (null != connectionState) "\t\t<cim:UsagePoint.connectionState rdf:resource=\"#" + connectionState + "\"/>\n" else "") +
        "\t\t<cim:UsagePoint.estimatedLoad>" + estimatedLoad + "</cim:UsagePoint.estimatedLoad>\n" +
        "\t\t<cim:UsagePoint.grounded>" + grounded + "</cim:UsagePoint.grounded>\n" +
        "\t\t<cim:UsagePoint.isSdp>" + isSdp + "</cim:UsagePoint.isSdp>\n" +
        "\t\t<cim:UsagePoint.isVirtual>" + isVirtual + "</cim:UsagePoint.isVirtual>\n" +
        "\t\t<cim:UsagePoint.minimalUsageExpected>" + minimalUsageExpected + "</cim:UsagePoint.minimalUsageExpected>\n" +
        "\t\t<cim:UsagePoint.nominalServiceVoltage>" + nominalServiceVoltage + "</cim:UsagePoint.nominalServiceVoltage>\n" +
        (if (null != outageRegion) "\t\t<cim:UsagePoint.outageRegion>" + outageRegion + "</cim:UsagePoint.outageRegion>\n" else "") +
        (if (null != phaseCode) "\t\t<cim:UsagePoint.phaseCode rdf:resource=\"#" + phaseCode + "\"/>\n" else "") +
        "\t\t<cim:UsagePoint.ratedCurrent>" + ratedCurrent + "</cim:UsagePoint.ratedCurrent>\n" +
        "\t\t<cim:UsagePoint.ratedPower>" + ratedPower + "</cim:UsagePoint.ratedPower>\n" +
        (if (null != readCycle) "\t\t<cim:UsagePoint.readCycle>" + readCycle + "</cim:UsagePoint.readCycle>\n" else "") +
        (if (null != readRoute) "\t\t<cim:UsagePoint.readRoute>" + readRoute + "</cim:UsagePoint.readRoute>\n" else "") +
        (if (null != serviceDeliveryRemark) "\t\t<cim:UsagePoint.serviceDeliveryRemark>" + serviceDeliveryRemark + "</cim:UsagePoint.serviceDeliveryRemark>\n" else "") +
        (if (null != servicePriority) "\t\t<cim:UsagePoint.servicePriority>" + servicePriority + "</cim:UsagePoint.servicePriority>\n" else "") +
        (if (null != CustomerAgreement) "\t\t<cim:UsagePoint.CustomerAgreement rdf:resource=\"#" + CustomerAgreement + "\"/>\n" else "") +
        (if (null != Equipments) Equipments.map (x => "\t\t<cim:UsagePoint.Equipments rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != ServiceCategory) "\t\t<cim:UsagePoint.ServiceCategory rdf:resource=\"#" + ServiceCategory + "\"/>\n" else "") +
        (if (null != ServiceLocation) "\t\t<cim:UsagePoint.ServiceLocation rdf:resource=\"#" + ServiceLocation + "\"/>\n" else "") +
        (if (null != ServiceSupplier) "\t\t<cim:UsagePoint.ServiceSupplier rdf:resource=\"#" + ServiceSupplier + "\"/>\n" else "") +
        (if (null != UsagePointLocation) "\t\t<cim:UsagePoint.UsagePointLocation rdf:resource=\"#" + UsagePointLocation + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:UsagePoint rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:UsagePoint>\n"
    }
}

object UsagePoint
extends
    Parseable[UsagePoint]
{
    val amiBillingReady = parse_attribute (attribute ("""UsagePoint.amiBillingReady"""))
    val checkBilling = parse_element (element ("""UsagePoint.checkBilling"""))
    val connectionState = parse_attribute (attribute ("""UsagePoint.connectionState"""))
    val estimatedLoad = parse_element (element ("""UsagePoint.estimatedLoad"""))
    val grounded = parse_element (element ("""UsagePoint.grounded"""))
    val isSdp = parse_element (element ("""UsagePoint.isSdp"""))
    val isVirtual = parse_element (element ("""UsagePoint.isVirtual"""))
    val minimalUsageExpected = parse_element (element ("""UsagePoint.minimalUsageExpected"""))
    val nominalServiceVoltage = parse_element (element ("""UsagePoint.nominalServiceVoltage"""))
    val outageRegion = parse_element (element ("""UsagePoint.outageRegion"""))
    val phaseCode = parse_attribute (attribute ("""UsagePoint.phaseCode"""))
    val ratedCurrent = parse_element (element ("""UsagePoint.ratedCurrent"""))
    val ratedPower = parse_element (element ("""UsagePoint.ratedPower"""))
    val readCycle = parse_element (element ("""UsagePoint.readCycle"""))
    val readRoute = parse_element (element ("""UsagePoint.readRoute"""))
    val serviceDeliveryRemark = parse_element (element ("""UsagePoint.serviceDeliveryRemark"""))
    val servicePriority = parse_element (element ("""UsagePoint.servicePriority"""))
    val CustomerAgreement = parse_attribute (attribute ("""UsagePoint.CustomerAgreement"""))
    val Equipments = parse_attributes (attribute ("""UsagePoint.Equipments"""))
    val ServiceCategory = parse_attribute (attribute ("""UsagePoint.ServiceCategory"""))
    val ServiceLocation = parse_attribute (attribute ("""UsagePoint.ServiceLocation"""))
    val ServiceSupplier = parse_attribute (attribute ("""UsagePoint.ServiceSupplier"""))
    val UsagePointLocation = parse_attribute (attribute ("""UsagePoint.UsagePointLocation"""))
    def parse (context: Context): UsagePoint =
    {
        UsagePoint(
            IdentifiedObject.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param connected The usage point is connected to the network and able to receive or send the applicable commodity (electricity, gas, water, etc.).
 * @param logicallyDisconnected The usage point has been disconnected through operation of a disconnect function within the meter present at the usage point.
 *        The usage point is unable to receive or send the applicable commodity (electricity, gas, water, etc.)  A logical disconnect can often be achieved without utilising a field crew.
 * @param physicallyDisconnected The usage point has been disconnected from the network at a point upstream of the meter.
 *        The usage point is unable to receive or send the applicable commodity (electricity, gas, water, etc.). A physical disconnect is often achieved by utilising a field crew.
 */
case class UsagePointConnectedKind
(
    override val sup: BasicElement,
    val connected: String,
    val logicallyDisconnected: String,
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
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != connected) "\t\t<cim:UsagePointConnectedKind.connected rdf:resource=\"#" + connected + "\"/>\n" else "") +
        (if (null != logicallyDisconnected) "\t\t<cim:UsagePointConnectedKind.logicallyDisconnected rdf:resource=\"#" + logicallyDisconnected + "\"/>\n" else "") +
        (if (null != physicallyDisconnected) "\t\t<cim:UsagePointConnectedKind.physicallyDisconnected rdf:resource=\"#" + physicallyDisconnected + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:UsagePointConnectedKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:UsagePointConnectedKind>\n"
    }
}

object UsagePointConnectedKind
extends
    Parseable[UsagePointConnectedKind]
{
    val connected = parse_attribute (attribute ("""UsagePointConnectedKind.connected"""))
    val logicallyDisconnected = parse_attribute (attribute ("""UsagePointConnectedKind.logicallyDisconnected"""))
    val physicallyDisconnected = parse_attribute (attribute ("""UsagePointConnectedKind.physicallyDisconnected"""))
    def parse (context: Context): UsagePointConnectedKind =
    {
        UsagePointConnectedKind(
            BasicElement.parse (context),
            connected (context),
            logicallyDisconnected (context),
            physicallyDisconnected (context)
        )
    }
}

/**
 * Abstraction for management of group communications within a two-way AMR system or the data for a group of related usage points.
 * Commands can be issued to all of the usage points that belong to a usage point group using a defined group address and the underlying AMR communication infrastructure.
 * @param sup Reference to the superclass object.
 * @param typ Type of this group.
 * @param UsagePoints All usage points in this group.
 */
case class UsagePointGroup
(
    override val sup: IdentifiedObject,
    val typ: String,
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
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != typ) "\t\t<cim:UsagePointGroup.type>" + typ + "</cim:UsagePointGroup.type>\n" else "") +
        (if (null != UsagePoints) UsagePoints.map (x => "\t\t<cim:UsagePointGroup.UsagePoints rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:UsagePointGroup rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:UsagePointGroup>\n"
    }
}

object UsagePointGroup
extends
    Parseable[UsagePointGroup]
{
    val typ = parse_element (element ("""UsagePointGroup.type"""))
    val UsagePoints = parse_attributes (attribute ("""UsagePointGroup.UsagePoints"""))
    def parse (context: Context): UsagePointGroup =
    {
        UsagePointGroup(
            IdentifiedObject.parse (context),
            typ (context),
            UsagePoints (context)
        )
    }
}

/**
 * Location of an individual usage point.
 * @param sup Reference to the superclass object.
 * @param accessMethod Method for the service person to access this usage point location.
 *        For example, a description of where to obtain a key if the facility is unmanned and secured.
 * @param remark Remarks about this location.
 * @param siteAccessProblem Problems previously encountered when visiting or performing work at this location.
 *        Examples include: bad dog, violent customer, verbally abusive occupant, obstructions, safety hazards, etc.
 */
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
    override def copy (): Row = { return (clone ().asInstanceOf[UsagePointLocation]) }
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
        (if (null != accessMethod) "\t\t<cim:UsagePointLocation.accessMethod>" + accessMethod + "</cim:UsagePointLocation.accessMethod>\n" else "") +
        (if (null != remark) "\t\t<cim:UsagePointLocation.remark>" + remark + "</cim:UsagePointLocation.remark>\n" else "") +
        (if (null != siteAccessProblem) "\t\t<cim:UsagePointLocation.siteAccessProblem>" + siteAccessProblem + "</cim:UsagePointLocation.siteAccessProblem>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:UsagePointLocation rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:UsagePointLocation>\n"
    }
}

object UsagePointLocation
extends
    Parseable[UsagePointLocation]
{
    val accessMethod = parse_element (element ("""UsagePointLocation.accessMethod"""))
    val remark = parse_element (element ("""UsagePointLocation.remark"""))
    val siteAccessProblem = parse_element (element ("""UsagePointLocation.siteAccessProblem"""))
    def parse (context: Context): UsagePointLocation =
    {
        UsagePointLocation(
            Location.parse (context),
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