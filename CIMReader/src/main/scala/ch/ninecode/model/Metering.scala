package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Common representation for reading values.
 *
 * Note that a reading value may have multiple qualities, as produced by various systems ('ReadingQuality.source').
 *
 * @param sup [[ch.ninecode.model.MeasurementValue MeasurementValue]] Reference to the superclass object.
 * @param reportedDateTime (used only when there are detailed auditing requirements) Date and time at which the reading was first delivered to the metering system.
 * @param source System that originally supplied the reading (e.g., customer, AMI system, handheld reading system, another enterprise system, etc.).
 * @param timePeriod Start and end of the period for those readings whose type has a time attribute such as 'billing', seasonal' or 'forTheSpecifiedPeriod'.
 * @param value Value of this reading.
 * @param ReadingQualities [[ch.ninecode.model.ReadingQuality ReadingQuality]] All qualities of this reading.
 * @group Metering
 * @groupname Metering Package Metering
 * @groupdesc Metering This package contains the core information classes that support end device applications with specialized classes for metering and premises area network devices, and remote reading functions. These classes are generally associated with the point where a service is delivered to the customer.
 */
final case class BaseReading
(
    override val sup: MeasurementValue = null,
    reportedDateTime: String = null,
    source: String = null,
    timePeriod: String = null,
    value: String = null,
    ReadingQualities: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def MeasurementValue: MeasurementValue = sup
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = BaseReading.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (BaseReading.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (BaseReading.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (BaseReading.fields (position), x))
        emitelem (0, reportedDateTime)
        emitelem (1, source)
        emitattr (2, timePeriod)
        emitelem (3, value)
        emitattrs (4, ReadingQualities)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:BaseReading rdf:ID=\"%s\">\n%s\t</cim:BaseReading>".format (id, export_fields)
    }
}

object BaseReading
extends
    Parseable[BaseReading]
{
    override val fields: Array[String] = Array[String] (
        "reportedDateTime",
        "source",
        "timePeriod",
        "value",
        "ReadingQualities"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ReadingQualities", "ReadingQuality", "0..*", "0..1")
    )
    val reportedDateTime: Fielder = parse_element (element (cls, fields(0)))
    val source: Fielder = parse_element (element (cls, fields(1)))
    val timePeriod: Fielder = parse_attribute (attribute (cls, fields(2)))
    val value: Fielder = parse_element (element (cls, fields(3)))
    val ReadingQualities: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: Context): BaseReading =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = BaseReading (
            MeasurementValue.parse (context),
            mask (reportedDateTime (), 0),
            mask (source (), 1),
            mask (timePeriod (), 2),
            mask (value (), 3),
            masks (ReadingQualities (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A single path for the collection or reporting of register values over a period of time.
 *
 * For example, a register which measures forward energy can have two channels, one providing bulk quantity readings and the other providing interval readings of a fixed interval size.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param isVirtual If true, the data is being calculated by an enterprise system rather than metered directly.
 * @param ReadingType [[ch.ninecode.model.ReadingType ReadingType]] Reading type for register values reported/collected by this channel.
 * @param Register [[ch.ninecode.model.Register Register]] Register whose values are collected/reported by this channel.
 * @group Metering
 * @groupname Metering Package Metering
 * @groupdesc Metering This package contains the core information classes that support end device applications with specialized classes for metering and premises area network devices, and remote reading functions. These classes are generally associated with the point where a service is delivered to the customer.
 */
final case class Channel
(
    override val sup: IdentifiedObject = null,
    isVirtual: Boolean = false,
    ReadingType: String = null,
    Register: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Channel.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Channel.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Channel.fields (position), value)
        emitelem (0, isVirtual)
        emitattr (1, ReadingType)
        emitattr (2, Register)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Channel rdf:ID=\"%s\">\n%s\t</cim:Channel>".format (id, export_fields)
    }
}

object Channel
extends
    Parseable[Channel]
{
    override val fields: Array[String] = Array[String] (
        "isVirtual",
        "ReadingType",
        "Register"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ReadingType", "ReadingType", "0..1", "0..1"),
        Relationship ("Register", "Register", "0..1", "0..*")
    )
    val isVirtual: Fielder = parse_element (element (cls, fields(0)))
    val ReadingType: Fielder = parse_attribute (attribute (cls, fields(1)))
    val Register: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): Channel =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Channel (
            IdentifiedObject.parse (context),
            toBoolean (mask (isVirtual (), 0)),
            mask (ReadingType (), 1),
            mask (Register (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Communication function of communication equipment or a device such as a meter.
 *
 * @param sup [[ch.ninecode.model.EndDeviceFunction EndDeviceFunction]] Reference to the superclass object.
 * @param amrAddress Communication ID number (e.g. serial number, IP address, telephone number, etc.) of the AMR module which serves this meter.
 * @param amrRouter Communication ID number (e.g. port number, serial number, data collector ID, etc.) of the parent device associated to this AMR module.
 * @param direction Kind of communication direction.
 * @param technology Kind of communication technology.
 * @param ComModule [[ch.ninecode.model.ComModule ComModule]] Module performing this communication function.
 * @group Metering
 * @groupname Metering Package Metering
 * @groupdesc Metering This package contains the core information classes that support end device applications with specialized classes for metering and premises area network devices, and remote reading functions. These classes are generally associated with the point where a service is delivered to the customer.
 */
final case class ComFunction
(
    override val sup: EndDeviceFunction = null,
    amrAddress: String = null,
    amrRouter: String = null,
    direction: String = null,
    technology: String = null,
    ComModule: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def EndDeviceFunction: EndDeviceFunction = sup
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ComFunction.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ComFunction.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ComFunction.fields (position), value)
        emitelem (0, amrAddress)
        emitelem (1, amrRouter)
        emitattr (2, direction)
        emitattr (3, technology)
        emitattr (4, ComModule)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ComFunction rdf:ID=\"%s\">\n%s\t</cim:ComFunction>".format (id, export_fields)
    }
}

object ComFunction
extends
    Parseable[ComFunction]
{
    override val fields: Array[String] = Array[String] (
        "amrAddress",
        "amrRouter",
        "direction",
        "technology",
        "ComModule"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ComModule", "ComModule", "0..1", "0..*")
    )
    val amrAddress: Fielder = parse_element (element (cls, fields(0)))
    val amrRouter: Fielder = parse_element (element (cls, fields(1)))
    val direction: Fielder = parse_attribute (attribute (cls, fields(2)))
    val technology: Fielder = parse_attribute (attribute (cls, fields(3)))
    val ComModule: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): ComFunction =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ComFunction (
            EndDeviceFunction.parse (context),
            mask (amrAddress (), 0),
            mask (amrRouter (), 1),
            mask (direction (), 2),
            mask (technology (), 3),
            mask (ComModule (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * An asset having communications capabilities that can be paired with a meter or other end device to provide the device with communication ability, through associated communication function.
 *
 * An end device that has communications capabilities through embedded hardware can use that function directly (without the communication module), or combine embedded communication function with additional communication functions provided through an external communication module (e.g. zigbee).
 *
 * @param sup [[ch.ninecode.model.Asset Asset]] Reference to the superclass object.
 * @param amrSystem Automated meter reading (AMR) system communicating with this com module.
 * @param supportsAutonomousDst If true, autonomous daylight saving time (DST) function is supported.
 * @param timeZoneOffset Time zone offset relative to GMT for the location of this com module.
 * @param ComFunctions [[ch.ninecode.model.ComFunction ComFunction]] All functions this communication module performs.
 * @group Metering
 * @groupname Metering Package Metering
 * @groupdesc Metering This package contains the core information classes that support end device applications with specialized classes for metering and premises area network devices, and remote reading functions. These classes are generally associated with the point where a service is delivered to the customer.
 */
final case class ComModule
(
    override val sup: Asset = null,
    amrSystem: String = null,
    supportsAutonomousDst: Boolean = false,
    timeZoneOffset: Double = 0.0,
    ComFunctions: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Asset: Asset = sup
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ComModule.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ComModule.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ComModule.fields (position), x))
        emitelem (0, amrSystem)
        emitelem (1, supportsAutonomousDst)
        emitelem (2, timeZoneOffset)
        emitattrs (3, ComFunctions)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ComModule rdf:ID=\"%s\">\n%s\t</cim:ComModule>".format (id, export_fields)
    }
}

object ComModule
extends
    Parseable[ComModule]
{
    override val fields: Array[String] = Array[String] (
        "amrSystem",
        "supportsAutonomousDst",
        "timeZoneOffset",
        "ComFunctions"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ComFunctions", "ComFunction", "0..*", "0..1")
    )
    val amrSystem: Fielder = parse_element (element (cls, fields(0)))
    val supportsAutonomousDst: Fielder = parse_element (element (cls, fields(1)))
    val timeZoneOffset: Fielder = parse_element (element (cls, fields(2)))
    val ComFunctions: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: Context): ComModule =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ComModule (
            Asset.parse (context),
            mask (amrSystem (), 0),
            toBoolean (mask (supportsAutonomousDst (), 1)),
            toDouble (mask (timeZoneOffset (), 2)),
            masks (ComFunctions (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Appliance controlled with a PAN device control.
 *
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
 * @group Metering
 * @groupname Metering Package Metering
 * @groupdesc Metering This package contains the core information classes that support end device applications with specialized classes for metering and premises area network devices, and remote reading functions. These classes are generally associated with the point where a service is delivered to the customer.
 */
final case class ControlledAppliance
(
    override val sup: BasicElement = null,
    isElectricVehicle: Boolean = false,
    isExteriorLighting: Boolean = false,
    isGenerationSystem: Boolean = false,
    isHvacCompressorOrFurnace: Boolean = false,
    isInteriorLighting: Boolean = false,
    isIrrigationPump: Boolean = false,
    isManagedCommercialIndustrialLoad: Boolean = false,
    isPoolPumpSpaJacuzzi: Boolean = false,
    isSimpleMiscLoad: Boolean = false,
    isSmartAppliance: Boolean = false,
    isStripAndBaseboardHeater: Boolean = false,
    isWaterHeater: Boolean = false
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ControlledAppliance.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ControlledAppliance.fields (position), value)
        emitelem (0, isElectricVehicle)
        emitelem (1, isExteriorLighting)
        emitelem (2, isGenerationSystem)
        emitelem (3, isHvacCompressorOrFurnace)
        emitelem (4, isInteriorLighting)
        emitelem (5, isIrrigationPump)
        emitelem (6, isManagedCommercialIndustrialLoad)
        emitelem (7, isPoolPumpSpaJacuzzi)
        emitelem (8, isSimpleMiscLoad)
        emitelem (9, isSmartAppliance)
        emitelem (10, isStripAndBaseboardHeater)
        emitelem (11, isWaterHeater)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ControlledAppliance rdf:ID=\"%s\">\n%s\t</cim:ControlledAppliance>".format (id, export_fields)
    }
}

object ControlledAppliance
extends
    Parseable[ControlledAppliance]
{
    override val fields: Array[String] = Array[String] (
        "isElectricVehicle",
        "isExteriorLighting",
        "isGenerationSystem",
        "isHvacCompressorOrFurnace",
        "isInteriorLighting",
        "isIrrigationPump",
        "isManagedCommercialIndustrialLoad",
        "isPoolPumpSpaJacuzzi",
        "isSimpleMiscLoad",
        "isSmartAppliance",
        "isStripAndBaseboardHeater",
        "isWaterHeater"
    )
    val isElectricVehicle: Fielder = parse_element (element (cls, fields(0)))
    val isExteriorLighting: Fielder = parse_element (element (cls, fields(1)))
    val isGenerationSystem: Fielder = parse_element (element (cls, fields(2)))
    val isHvacCompressorOrFurnace: Fielder = parse_element (element (cls, fields(3)))
    val isInteriorLighting: Fielder = parse_element (element (cls, fields(4)))
    val isIrrigationPump: Fielder = parse_element (element (cls, fields(5)))
    val isManagedCommercialIndustrialLoad: Fielder = parse_element (element (cls, fields(6)))
    val isPoolPumpSpaJacuzzi: Fielder = parse_element (element (cls, fields(7)))
    val isSimpleMiscLoad: Fielder = parse_element (element (cls, fields(8)))
    val isSmartAppliance: Fielder = parse_element (element (cls, fields(9)))
    val isStripAndBaseboardHeater: Fielder = parse_element (element (cls, fields(10)))
    val isWaterHeater: Fielder = parse_element (element (cls, fields(11)))

    def parse (context: Context): ControlledAppliance =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ControlledAppliance (
            BasicElement.parse (context),
            toBoolean (mask (isElectricVehicle (), 0)),
            toBoolean (mask (isExteriorLighting (), 1)),
            toBoolean (mask (isGenerationSystem (), 2)),
            toBoolean (mask (isHvacCompressorOrFurnace (), 3)),
            toBoolean (mask (isInteriorLighting (), 4)),
            toBoolean (mask (isIrrigationPump (), 5)),
            toBoolean (mask (isManagedCommercialIndustrialLoad (), 6)),
            toBoolean (mask (isPoolPumpSpaJacuzzi (), 7)),
            toBoolean (mask (isSimpleMiscLoad (), 8)),
            toBoolean (mask (isSmartAppliance (), 9)),
            toBoolean (mask (isStripAndBaseboardHeater (), 10)),
            toBoolean (mask (isWaterHeater (), 11))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Demand response program.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param type Type of demand response program; examples are CPP (critical-peak pricing), RTP (real-time pricing), DLC (direct load control), DBP (demand bidding program), BIP (base interruptible program).
 *        Note that possible types change a lot and it would be impossible to enumerate them all.
 * @param validityInterval Interval within which the program is valid.
 * @param CustomerAgreements [[ch.ninecode.model.CustomerAgreement CustomerAgreement]] All customer agreements through which the customer is enrolled in this demand response program.
 * @param EndDeviceGroups [[ch.ninecode.model.EndDeviceGroup EndDeviceGroup]] All groups of end devices enrolled in this demand response program.
 * @param UsagePointGroups [[ch.ninecode.model.UsagePointGroup UsagePointGroup]] All usage point groups enrolled in this demand response program.
 * @group Metering
 * @groupname Metering Package Metering
 * @groupdesc Metering This package contains the core information classes that support end device applications with specialized classes for metering and premises area network devices, and remote reading functions. These classes are generally associated with the point where a service is delivered to the customer.
 */
final case class DemandResponseProgram
(
    override val sup: IdentifiedObject = null,
    `type`: String = null,
    validityInterval: String = null,
    CustomerAgreements: List[String] = null,
    EndDeviceGroups: List[String] = null,
    UsagePointGroups: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = DemandResponseProgram.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DemandResponseProgram.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DemandResponseProgram.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (DemandResponseProgram.fields (position), x))
        emitelem (0, `type`)
        emitattr (1, validityInterval)
        emitattrs (2, CustomerAgreements)
        emitattrs (3, EndDeviceGroups)
        emitattrs (4, UsagePointGroups)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DemandResponseProgram rdf:ID=\"%s\">\n%s\t</cim:DemandResponseProgram>".format (id, export_fields)
    }
}

object DemandResponseProgram
extends
    Parseable[DemandResponseProgram]
{
    override val fields: Array[String] = Array[String] (
        "type",
        "validityInterval",
        "CustomerAgreements",
        "EndDeviceGroups",
        "UsagePointGroups"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CustomerAgreements", "CustomerAgreement", "0..*", "0..*"),
        Relationship ("EndDeviceGroups", "EndDeviceGroup", "0..*", "0..*"),
        Relationship ("UsagePointGroups", "UsagePointGroup", "0..*", "0..*")
    )
    val `type`: Fielder = parse_element (element (cls, fields(0)))
    val validityInterval: Fielder = parse_attribute (attribute (cls, fields(1)))
    val CustomerAgreements: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val EndDeviceGroups: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val UsagePointGroups: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: Context): DemandResponseProgram =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DemandResponseProgram (
            IdentifiedObject.parse (context),
            mask (`type` (), 0),
            mask (validityInterval (), 1),
            masks (CustomerAgreements (), 2),
            masks (EndDeviceGroups (), 3),
            masks (UsagePointGroups (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Asset container that performs one or more end device functions.
 *
 * One type of end device is a meter which can perform metering, load management, connect/disconnect, accounting functions, etc. Some end devices, such as ones monitoring and controlling air conditioners, refrigerators, pool pumps may be connected to a meter. All end devices may have communication capability defined by the associated communication function(s). An end device may be owned by a consumer, a service provider, utility or otherwise.
 * There may be a related end device function that identifies a sensor or control point within a metering application or communications systems (e.g., water, gas, electricity).
 * Some devices may use an optical port that conforms to the ANSI C12.18 standard for communications.
 *
 * @param sup [[ch.ninecode.model.AssetContainer AssetContainer]] Reference to the superclass object.
 * @param amrSystem Automated meter reading (AMR) or other communication system responsible for communications to this end device.
 * @param installCode Installation code.
 * @param isPan If true, this is a premises area network (PAN) device.
 * @param isSmartInverter <em>undocumented</em>
 * @param isVirtual If true, there is no physical device.
 *        As an example, a virtual meter can be defined to aggregate the consumption for two or more physical meters. Otherwise, this is a physical hardware device.
 * @param timeZoneOffset Time zone offset relative to GMT for the location of this end device.
 * @param Customer [[ch.ninecode.model.Customer Customer]] Customer owning this end device.
 * @param DispatchablePowerCapability [[ch.ninecode.model.DispatchablePowerCapability DispatchablePowerCapability]] <em>undocumented</em>
 * @param EndDeviceControls [[ch.ninecode.model.EndDeviceControl EndDeviceControl]] All end device controls sending commands to this end device.
 * @param EndDeviceEvents [[ch.ninecode.model.EndDeviceEvent EndDeviceEvent]] All events reported by this end device.
 * @param EndDeviceFunctions [[ch.ninecode.model.EndDeviceFunction EndDeviceFunction]] All end device functions this end device performs.
 * @param EndDeviceGroups [[ch.ninecode.model.EndDeviceGroup EndDeviceGroup]] All end device groups referring to this end device.
 * @param EndDeviceInfo [[ch.ninecode.model.EndDeviceInfo EndDeviceInfo]] End device data.
 * @param ServiceLocation [[ch.ninecode.model.ServiceLocation ServiceLocation]] Service location whose service delivery is measured by this end device.
 * @param UsagePoint [[ch.ninecode.model.UsagePoint UsagePoint]] Usage point to which this end device belongs.
 * @group Metering
 * @groupname Metering Package Metering
 * @groupdesc Metering This package contains the core information classes that support end device applications with specialized classes for metering and premises area network devices, and remote reading functions. These classes are generally associated with the point where a service is delivered to the customer.
 */
final case class EndDevice
(
    override val sup: AssetContainer = null,
    amrSystem: String = null,
    installCode: String = null,
    isPan: Boolean = false,
    isSmartInverter: Boolean = false,
    isVirtual: Boolean = false,
    timeZoneOffset: Double = 0.0,
    Customer: String = null,
    DispatchablePowerCapability: List[String] = null,
    EndDeviceControls: List[String] = null,
    EndDeviceEvents: List[String] = null,
    EndDeviceFunctions: List[String] = null,
    EndDeviceGroups: List[String] = null,
    EndDeviceInfo: String = null,
    ServiceLocation: String = null,
    UsagePoint: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def AssetContainer: AssetContainer = sup
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = EndDevice.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (EndDevice.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EndDevice.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (EndDevice.fields (position), x))
        emitelem (0, amrSystem)
        emitelem (1, installCode)
        emitelem (2, isPan)
        emitelem (3, isSmartInverter)
        emitelem (4, isVirtual)
        emitelem (5, timeZoneOffset)
        emitattr (6, Customer)
        emitattrs (7, DispatchablePowerCapability)
        emitattrs (8, EndDeviceControls)
        emitattrs (9, EndDeviceEvents)
        emitattrs (10, EndDeviceFunctions)
        emitattrs (11, EndDeviceGroups)
        emitattr (12, EndDeviceInfo)
        emitattr (13, ServiceLocation)
        emitattr (14, UsagePoint)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EndDevice rdf:ID=\"%s\">\n%s\t</cim:EndDevice>".format (id, export_fields)
    }
}

object EndDevice
extends
    Parseable[EndDevice]
{
    override val fields: Array[String] = Array[String] (
        "amrSystem",
        "installCode",
        "isPan",
        "isSmartInverter",
        "isVirtual",
        "timeZoneOffset",
        "Customer",
        "DispatchablePowerCapability",
        "EndDeviceControls",
        "EndDeviceEvents",
        "EndDeviceFunctions",
        "EndDeviceGroups",
        "EndDeviceInfo",
        "ServiceLocation",
        "UsagePoint"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Customer", "Customer", "0..1", "0..*"),
        Relationship ("DispatchablePowerCapability", "DispatchablePowerCapability", "0..*", "0..1"),
        Relationship ("EndDeviceControls", "EndDeviceControl", "0..*", "0..*"),
        Relationship ("EndDeviceEvents", "EndDeviceEvent", "0..*", "0..1"),
        Relationship ("EndDeviceFunctions", "EndDeviceFunction", "0..*", "0..1"),
        Relationship ("EndDeviceGroups", "EndDeviceGroup", "0..*", "0..*"),
        Relationship ("EndDeviceInfo", "EndDeviceInfo", "0..1", "0..*"),
        Relationship ("ServiceLocation", "ServiceLocation", "0..1", "0..*"),
        Relationship ("UsagePoint", "UsagePoint", "0..1", "0..*")
    )
    val amrSystem: Fielder = parse_element (element (cls, fields(0)))
    val installCode: Fielder = parse_element (element (cls, fields(1)))
    val isPan: Fielder = parse_element (element (cls, fields(2)))
    val isSmartInverter: Fielder = parse_element (element (cls, fields(3)))
    val isVirtual: Fielder = parse_element (element (cls, fields(4)))
    val timeZoneOffset: Fielder = parse_element (element (cls, fields(5)))
    val Customer: Fielder = parse_attribute (attribute (cls, fields(6)))
    val DispatchablePowerCapability: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val EndDeviceControls: FielderMultiple = parse_attributes (attribute (cls, fields(8)))
    val EndDeviceEvents: FielderMultiple = parse_attributes (attribute (cls, fields(9)))
    val EndDeviceFunctions: FielderMultiple = parse_attributes (attribute (cls, fields(10)))
    val EndDeviceGroups: FielderMultiple = parse_attributes (attribute (cls, fields(11)))
    val EndDeviceInfo: Fielder = parse_attribute (attribute (cls, fields(12)))
    val ServiceLocation: Fielder = parse_attribute (attribute (cls, fields(13)))
    val UsagePoint: Fielder = parse_attribute (attribute (cls, fields(14)))

    def parse (context: Context): EndDevice =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EndDevice (
            AssetContainer.parse (context),
            mask (amrSystem (), 0),
            mask (installCode (), 1),
            toBoolean (mask (isPan (), 2)),
            toBoolean (mask (isSmartInverter (), 3)),
            toBoolean (mask (isVirtual (), 4)),
            toDouble (mask (timeZoneOffset (), 5)),
            mask (Customer (), 6),
            masks (DispatchablePowerCapability (), 7),
            masks (EndDeviceControls (), 8),
            masks (EndDeviceEvents (), 9),
            masks (EndDeviceFunctions (), 10),
            masks (EndDeviceGroups (), 11),
            mask (EndDeviceInfo (), 12),
            mask (ServiceLocation (), 13),
            mask (UsagePoint (), 14)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Action/command performed by an end device on a device other than the end device.
 *
 * @param sup Reference to the superclass object.
 * @param command Command text.
 * @param duration Amount of time the action of this control is to remain active.
 * @param durationIndefinite True if the action of this control is indefinite.
 * @param startDateTime Start date and time for action of this control.
 * @param EndDeviceControl [[ch.ninecode.model.EndDeviceControl EndDeviceControl]] End device control issuing this end device action.
 * @group Metering
 * @groupname Metering Package Metering
 * @groupdesc Metering This package contains the core information classes that support end device applications with specialized classes for metering and premises area network devices, and remote reading functions. These classes are generally associated with the point where a service is delivered to the customer.
 */
final case class EndDeviceAction
(
    override val sup: BasicElement = null,
    command: String = null,
    duration: Double = 0.0,
    durationIndefinite: Boolean = false,
    startDateTime: String = null,
    EndDeviceControl: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = EndDeviceAction.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (EndDeviceAction.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EndDeviceAction.fields (position), value)
        emitelem (0, command)
        emitelem (1, duration)
        emitelem (2, durationIndefinite)
        emitelem (3, startDateTime)
        emitattr (4, EndDeviceControl)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EndDeviceAction rdf:ID=\"%s\">\n%s\t</cim:EndDeviceAction>".format (id, export_fields)
    }
}

object EndDeviceAction
extends
    Parseable[EndDeviceAction]
{
    override val fields: Array[String] = Array[String] (
        "command",
        "duration",
        "durationIndefinite",
        "startDateTime",
        "EndDeviceControl"
    )
    override val relations: List[Relationship] = List (
        Relationship ("EndDeviceControl", "EndDeviceControl", "0..1", "0..1")
    )
    val command: Fielder = parse_element (element (cls, fields(0)))
    val duration: Fielder = parse_element (element (cls, fields(1)))
    val durationIndefinite: Fielder = parse_element (element (cls, fields(2)))
    val startDateTime: Fielder = parse_element (element (cls, fields(3)))
    val EndDeviceControl: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): EndDeviceAction =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EndDeviceAction (
            BasicElement.parse (context),
            mask (command (), 0),
            toDouble (mask (duration (), 1)),
            toBoolean (mask (durationIndefinite (), 2)),
            mask (startDateTime (), 3),
            mask (EndDeviceControl (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Inherent capabilities of an end device (i.e., the functions it supports).
 *
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
 * @group Metering
 * @groupname Metering Package Metering
 * @groupdesc Metering This package contains the core information classes that support end device applications with specialized classes for metering and premises area network devices, and remote reading functions. These classes are generally associated with the point where a service is delivered to the customer.
 */
final case class EndDeviceCapability
(
    override val sup: BasicElement = null,
    autonomousDst: Boolean = false,
    communication: Boolean = false,
    connectDisconnect: Boolean = false,
    demandResponse: Boolean = false,
    electricMetering: Boolean = false,
    gasMetering: Boolean = false,
    metrology: Boolean = false,
    onRequestRead: Boolean = false,
    outageHistory: Boolean = false,
    pressureCompensation: Boolean = false,
    pricingInfo: Boolean = false,
    pulseOutput: Boolean = false,
    relaysProgramming: Boolean = false,
    reverseFlow: Boolean = false,
    superCompressibilityCompensation: Boolean = false,
    temperatureCompensation: Boolean = false,
    textMessage: Boolean = false,
    waterMetering: Boolean = false
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = EndDeviceCapability.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (EndDeviceCapability.fields (position), value)
        emitelem (0, autonomousDst)
        emitelem (1, communication)
        emitelem (2, connectDisconnect)
        emitelem (3, demandResponse)
        emitelem (4, electricMetering)
        emitelem (5, gasMetering)
        emitelem (6, metrology)
        emitelem (7, onRequestRead)
        emitelem (8, outageHistory)
        emitelem (9, pressureCompensation)
        emitelem (10, pricingInfo)
        emitelem (11, pulseOutput)
        emitelem (12, relaysProgramming)
        emitelem (13, reverseFlow)
        emitelem (14, superCompressibilityCompensation)
        emitelem (15, temperatureCompensation)
        emitelem (16, textMessage)
        emitelem (17, waterMetering)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EndDeviceCapability rdf:ID=\"%s\">\n%s\t</cim:EndDeviceCapability>".format (id, export_fields)
    }
}

object EndDeviceCapability
extends
    Parseable[EndDeviceCapability]
{
    override val fields: Array[String] = Array[String] (
        "autonomousDst",
        "communication",
        "connectDisconnect",
        "demandResponse",
        "electricMetering",
        "gasMetering",
        "metrology",
        "onRequestRead",
        "outageHistory",
        "pressureCompensation",
        "pricingInfo",
        "pulseOutput",
        "relaysProgramming",
        "reverseFlow",
        "superCompressibilityCompensation",
        "temperatureCompensation",
        "textMessage",
        "waterMetering"
    )
    val autonomousDst: Fielder = parse_element (element (cls, fields(0)))
    val communication: Fielder = parse_element (element (cls, fields(1)))
    val connectDisconnect: Fielder = parse_element (element (cls, fields(2)))
    val demandResponse: Fielder = parse_element (element (cls, fields(3)))
    val electricMetering: Fielder = parse_element (element (cls, fields(4)))
    val gasMetering: Fielder = parse_element (element (cls, fields(5)))
    val metrology: Fielder = parse_element (element (cls, fields(6)))
    val onRequestRead: Fielder = parse_element (element (cls, fields(7)))
    val outageHistory: Fielder = parse_element (element (cls, fields(8)))
    val pressureCompensation: Fielder = parse_element (element (cls, fields(9)))
    val pricingInfo: Fielder = parse_element (element (cls, fields(10)))
    val pulseOutput: Fielder = parse_element (element (cls, fields(11)))
    val relaysProgramming: Fielder = parse_element (element (cls, fields(12)))
    val reverseFlow: Fielder = parse_element (element (cls, fields(13)))
    val superCompressibilityCompensation: Fielder = parse_element (element (cls, fields(14)))
    val temperatureCompensation: Fielder = parse_element (element (cls, fields(15)))
    val textMessage: Fielder = parse_element (element (cls, fields(16)))
    val waterMetering: Fielder = parse_element (element (cls, fields(17)))

    def parse (context: Context): EndDeviceCapability =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EndDeviceCapability (
            BasicElement.parse (context),
            toBoolean (mask (autonomousDst (), 0)),
            toBoolean (mask (communication (), 1)),
            toBoolean (mask (connectDisconnect (), 2)),
            toBoolean (mask (demandResponse (), 3)),
            toBoolean (mask (electricMetering (), 4)),
            toBoolean (mask (gasMetering (), 5)),
            toBoolean (mask (metrology (), 6)),
            toBoolean (mask (onRequestRead (), 7)),
            toBoolean (mask (outageHistory (), 8)),
            toBoolean (mask (pressureCompensation (), 9)),
            toBoolean (mask (pricingInfo (), 10)),
            toBoolean (mask (pulseOutput (), 11)),
            toBoolean (mask (relaysProgramming (), 12)),
            toBoolean (mask (reverseFlow (), 13)),
            toBoolean (mask (superCompressibilityCompensation (), 14)),
            toBoolean (mask (temperatureCompensation (), 15)),
            toBoolean (mask (textMessage (), 16)),
            toBoolean (mask (waterMetering (), 17))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Instructs an end device (or an end device group) to perform a specified action.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param drProgramLevel Level of a demand response program request, where 0=emergency.
 *        Note: Attribute is not defined on DemandResponseProgram as it is not its inherent property (it serves to control it).
 * @param drProgramMandatory Whether a demand response program request is mandatory.
 *        Note: Attribute is not defined on DemandResponseProgram as it is not its inherent property (it serves to control it).
 * @param issuerID Unique identifier of the business entity originating an end device control.
 * @param issuerTrackingID Identifier assigned by the initiator (e.g. retail electric provider) of an end device control action to uniquely identify the demand response event, text message, or other subject of the control action.
 *        Can be used when cancelling an event or text message request or to identify the originating event or text message in a consequential end device event.
 * @param priceSignal (if applicable) Price signal used as parameter for this end device control.
 * @param primaryDeviceTiming [[ch.ninecode.model.EndDeviceTiming EndDeviceTiming]] Timing for the control actions performed on the device identified in the end device control.
 * @param reason Reason for the control action that allows to determine how to continue processing.
 *        For example, disconnect meter command may require different processing by the receiving system if it has been issued for a network-related reason (protection) or for a payment-related reason.
 * @param scheduledInterval (if control has scheduled duration) Date and time interval the control has been scheduled to execute within.
 * @param secondaryDeviceTiming [[ch.ninecode.model.EndDeviceTiming EndDeviceTiming]] Timing for the control actions performed by devices that are responding to event related information sent to the primary device indicated in the end device control.
 *        For example, load control actions performed by a PAN device in response to demand response event information sent to a PAN gateway server.
 * @param EndDeviceAction [[ch.ninecode.model.EndDeviceAction EndDeviceAction]] End device action issued by this end device control.
 * @param EndDeviceControlType [[ch.ninecode.model.EndDeviceControlType EndDeviceControlType]] Type of this end device control.
 * @param EndDeviceGroups [[ch.ninecode.model.EndDeviceGroup EndDeviceGroup]] All end device groups receiving commands from this end device control.
 * @param EndDevices [[ch.ninecode.model.EndDevice EndDevice]] All end devices receiving commands from this end device control.
 * @param UsagePointGroups [[ch.ninecode.model.UsagePointGroup UsagePointGroup]] All usage point groups receiving commands from this end device control.
 * @param UsagePoints [[ch.ninecode.model.UsagePoint UsagePoint]] All usage points receiving commands from this end device control.
 * @group Metering
 * @groupname Metering Package Metering
 * @groupdesc Metering This package contains the core information classes that support end device applications with specialized classes for metering and premises area network devices, and remote reading functions. These classes are generally associated with the point where a service is delivered to the customer.
 */
final case class EndDeviceControl
(
    override val sup: IdentifiedObject = null,
    drProgramLevel: Int = 0,
    drProgramMandatory: Boolean = false,
    issuerID: String = null,
    issuerTrackingID: String = null,
    priceSignal: String = null,
    primaryDeviceTiming: String = null,
    reason: String = null,
    scheduledInterval: String = null,
    secondaryDeviceTiming: String = null,
    EndDeviceAction: String = null,
    EndDeviceControlType: String = null,
    EndDeviceGroups: List[String] = null,
    EndDevices: List[String] = null,
    UsagePointGroups: List[String] = null,
    UsagePoints: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = EndDeviceControl.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (EndDeviceControl.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EndDeviceControl.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (EndDeviceControl.fields (position), x))
        emitelem (0, drProgramLevel)
        emitelem (1, drProgramMandatory)
        emitelem (2, issuerID)
        emitelem (3, issuerTrackingID)
        emitattr (4, priceSignal)
        emitattr (5, primaryDeviceTiming)
        emitelem (6, reason)
        emitattr (7, scheduledInterval)
        emitattr (8, secondaryDeviceTiming)
        emitattr (9, EndDeviceAction)
        emitattr (10, EndDeviceControlType)
        emitattrs (11, EndDeviceGroups)
        emitattrs (12, EndDevices)
        emitattrs (13, UsagePointGroups)
        emitattrs (14, UsagePoints)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EndDeviceControl rdf:ID=\"%s\">\n%s\t</cim:EndDeviceControl>".format (id, export_fields)
    }
}

object EndDeviceControl
extends
    Parseable[EndDeviceControl]
{
    override val fields: Array[String] = Array[String] (
        "drProgramLevel",
        "drProgramMandatory",
        "issuerID",
        "issuerTrackingID",
        "priceSignal",
        "primaryDeviceTiming",
        "reason",
        "scheduledInterval",
        "secondaryDeviceTiming",
        "EndDeviceAction",
        "EndDeviceControlType",
        "EndDeviceGroups",
        "EndDevices",
        "UsagePointGroups",
        "UsagePoints"
    )
    override val relations: List[Relationship] = List (
        Relationship ("primaryDeviceTiming", "EndDeviceTiming", "0..1", "0..*"),
        Relationship ("secondaryDeviceTiming", "EndDeviceTiming", "0..1", "0..*"),
        Relationship ("EndDeviceAction", "EndDeviceAction", "0..1", "0..1"),
        Relationship ("EndDeviceControlType", "EndDeviceControlType", "1", "0..*"),
        Relationship ("EndDeviceGroups", "EndDeviceGroup", "0..*", "0..*"),
        Relationship ("EndDevices", "EndDevice", "0..*", "0..*"),
        Relationship ("UsagePointGroups", "UsagePointGroup", "0..*", "0..*"),
        Relationship ("UsagePoints", "UsagePoint", "0..*", "0..*")
    )
    val drProgramLevel: Fielder = parse_element (element (cls, fields(0)))
    val drProgramMandatory: Fielder = parse_element (element (cls, fields(1)))
    val issuerID: Fielder = parse_element (element (cls, fields(2)))
    val issuerTrackingID: Fielder = parse_element (element (cls, fields(3)))
    val priceSignal: Fielder = parse_attribute (attribute (cls, fields(4)))
    val primaryDeviceTiming: Fielder = parse_attribute (attribute (cls, fields(5)))
    val reason: Fielder = parse_element (element (cls, fields(6)))
    val scheduledInterval: Fielder = parse_attribute (attribute (cls, fields(7)))
    val secondaryDeviceTiming: Fielder = parse_attribute (attribute (cls, fields(8)))
    val EndDeviceAction: Fielder = parse_attribute (attribute (cls, fields(9)))
    val EndDeviceControlType: Fielder = parse_attribute (attribute (cls, fields(10)))
    val EndDeviceGroups: FielderMultiple = parse_attributes (attribute (cls, fields(11)))
    val EndDevices: FielderMultiple = parse_attributes (attribute (cls, fields(12)))
    val UsagePointGroups: FielderMultiple = parse_attributes (attribute (cls, fields(13)))
    val UsagePoints: FielderMultiple = parse_attributes (attribute (cls, fields(14)))

    def parse (context: Context): EndDeviceControl =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EndDeviceControl (
            IdentifiedObject.parse (context),
            toInteger (mask (drProgramLevel (), 0)),
            toBoolean (mask (drProgramMandatory (), 1)),
            mask (issuerID (), 2),
            mask (issuerTrackingID (), 3),
            mask (priceSignal (), 4),
            mask (primaryDeviceTiming (), 5),
            mask (reason (), 6),
            mask (scheduledInterval (), 7),
            mask (secondaryDeviceTiming (), 8),
            mask (EndDeviceAction (), 9),
            mask (EndDeviceControlType (), 10),
            masks (EndDeviceGroups (), 11),
            masks (EndDevices (), 12),
            masks (UsagePointGroups (), 13),
            masks (UsagePoints (), 14)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Detailed description for a control produced by an end device.
 *
 * Values in attributes allow for creation of recommended codes to be used for identifying end device controls as follows: <type>.<domain>.<subDomain>.<eventOrAction>.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param domain High-level nature of the control.
 * @param eventOrAction The most specific part of this control type.
 *        It is mainly in the form of a verb that gives action to the control that just occurred.
 * @param subDomain More specific nature of the control, as a further sub-categorisation of 'domain'.
 * @param type Type of physical device from which the control was created.
 *        A value of zero (0) can be used when the source is unknown.
 * @param EndDeviceControls [[ch.ninecode.model.EndDeviceControl EndDeviceControl]] All end device controls of this type.
 * @group Metering
 * @groupname Metering Package Metering
 * @groupdesc Metering This package contains the core information classes that support end device applications with specialized classes for metering and premises area network devices, and remote reading functions. These classes are generally associated with the point where a service is delivered to the customer.
 */
final case class EndDeviceControlType
(
    override val sup: IdentifiedObject = null,
    domain: String = null,
    eventOrAction: String = null,
    subDomain: String = null,
    `type`: String = null,
    EndDeviceControls: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = EndDeviceControlType.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (EndDeviceControlType.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (EndDeviceControlType.fields (position), x))
        emitelem (0, domain)
        emitelem (1, eventOrAction)
        emitelem (2, subDomain)
        emitelem (3, `type`)
        emitattrs (4, EndDeviceControls)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EndDeviceControlType rdf:ID=\"%s\">\n%s\t</cim:EndDeviceControlType>".format (id, export_fields)
    }
}

object EndDeviceControlType
extends
    Parseable[EndDeviceControlType]
{
    override val fields: Array[String] = Array[String] (
        "domain",
        "eventOrAction",
        "subDomain",
        "type",
        "EndDeviceControls"
    )
    override val relations: List[Relationship] = List (
        Relationship ("EndDeviceControls", "EndDeviceControl", "0..*", "1")
    )
    val domain: Fielder = parse_element (element (cls, fields(0)))
    val eventOrAction: Fielder = parse_element (element (cls, fields(1)))
    val subDomain: Fielder = parse_element (element (cls, fields(2)))
    val `type`: Fielder = parse_element (element (cls, fields(3)))
    val EndDeviceControls: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: Context): EndDeviceControlType =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EndDeviceControlType (
            IdentifiedObject.parse (context),
            mask (domain (), 0),
            mask (eventOrAction (), 1),
            mask (subDomain (), 2),
            mask (`type` (), 3),
            masks (EndDeviceControls (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Event detected by a device function associated with the end device.
 *
 * @param sup [[ch.ninecode.model.ActivityRecord ActivityRecord]] Reference to the superclass object.
 * @param issuerID Unique identifier of the business entity originating an end device control.
 * @param issuerTrackingID Identifier assigned by the initiator (e.g. retail electric provider) of an end device control action to uniquely identify the demand response event, text message, or other subject of the control action.
 *        Can be used when cancelling an event or text message request or to identify the originating event or text message in a consequential end device event.
 * @param userID (if user initiated) ID of user who initiated this end device event.
 * @param EndDevice [[ch.ninecode.model.EndDevice EndDevice]] End device that reported this end device event.
 * @param EndDeviceEventDetails [[ch.ninecode.model.EndDeviceEventDetail EndDeviceEventDetail]] All details of this end device event.
 * @param EndDeviceEventType [[ch.ninecode.model.EndDeviceEventType EndDeviceEventType]] Type of this end device event.
 * @param MeterReading [[ch.ninecode.model.MeterReading MeterReading]] Set of measured values to which this event applies.
 * @param UsagePoint [[ch.ninecode.model.UsagePoint UsagePoint]] Usage point for which this end device event is reported.
 * @group Metering
 * @groupname Metering Package Metering
 * @groupdesc Metering This package contains the core information classes that support end device applications with specialized classes for metering and premises area network devices, and remote reading functions. These classes are generally associated with the point where a service is delivered to the customer.
 */
final case class EndDeviceEvent
(
    override val sup: ActivityRecord = null,
    issuerID: String = null,
    issuerTrackingID: String = null,
    userID: String = null,
    EndDevice: String = null,
    EndDeviceEventDetails: List[String] = null,
    EndDeviceEventType: String = null,
    MeterReading: String = null,
    UsagePoint: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ActivityRecord: ActivityRecord = sup
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = EndDeviceEvent.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (EndDeviceEvent.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EndDeviceEvent.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (EndDeviceEvent.fields (position), x))
        emitelem (0, issuerID)
        emitelem (1, issuerTrackingID)
        emitelem (2, userID)
        emitattr (3, EndDevice)
        emitattrs (4, EndDeviceEventDetails)
        emitattr (5, EndDeviceEventType)
        emitattr (6, MeterReading)
        emitattr (7, UsagePoint)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EndDeviceEvent rdf:ID=\"%s\">\n%s\t</cim:EndDeviceEvent>".format (id, export_fields)
    }
}

object EndDeviceEvent
extends
    Parseable[EndDeviceEvent]
{
    override val fields: Array[String] = Array[String] (
        "issuerID",
        "issuerTrackingID",
        "userID",
        "EndDevice",
        "EndDeviceEventDetails",
        "EndDeviceEventType",
        "MeterReading",
        "UsagePoint"
    )
    override val relations: List[Relationship] = List (
        Relationship ("EndDevice", "EndDevice", "0..1", "0..*"),
        Relationship ("EndDeviceEventDetails", "EndDeviceEventDetail", "0..*", "0..1"),
        Relationship ("EndDeviceEventType", "EndDeviceEventType", "1", "0..*"),
        Relationship ("MeterReading", "MeterReading", "0..1", "0..*"),
        Relationship ("UsagePoint", "UsagePoint", "0..1", "0..*")
    )
    val issuerID: Fielder = parse_element (element (cls, fields(0)))
    val issuerTrackingID: Fielder = parse_element (element (cls, fields(1)))
    val userID: Fielder = parse_element (element (cls, fields(2)))
    val EndDevice: Fielder = parse_attribute (attribute (cls, fields(3)))
    val EndDeviceEventDetails: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val EndDeviceEventType: Fielder = parse_attribute (attribute (cls, fields(5)))
    val MeterReading: Fielder = parse_attribute (attribute (cls, fields(6)))
    val UsagePoint: Fielder = parse_attribute (attribute (cls, fields(7)))

    def parse (context: Context): EndDeviceEvent =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EndDeviceEvent (
            ActivityRecord.parse (context),
            mask (issuerID (), 0),
            mask (issuerTrackingID (), 1),
            mask (userID (), 2),
            mask (EndDevice (), 3),
            masks (EndDeviceEventDetails (), 4),
            mask (EndDeviceEventType (), 5),
            mask (MeterReading (), 6),
            mask (UsagePoint (), 7)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Name-value pair, specific to end device events.
 *
 * @param sup Reference to the superclass object.
 * @param name Name.
 * @param value Value, including unit information.
 * @param EndDeviceEvent [[ch.ninecode.model.EndDeviceEvent EndDeviceEvent]] End device owning this detail.
 * @group Metering
 * @groupname Metering Package Metering
 * @groupdesc Metering This package contains the core information classes that support end device applications with specialized classes for metering and premises area network devices, and remote reading functions. These classes are generally associated with the point where a service is delivered to the customer.
 */
final case class EndDeviceEventDetail
(
    override val sup: BasicElement = null,
    name: String = null,
    value: String = null,
    EndDeviceEvent: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = EndDeviceEventDetail.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (EndDeviceEventDetail.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EndDeviceEventDetail.fields (position), value)
        emitelem (0, name)
        emitattr (1, value)
        emitattr (2, EndDeviceEvent)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EndDeviceEventDetail rdf:ID=\"%s\">\n%s\t</cim:EndDeviceEventDetail>".format (id, export_fields)
    }
}

object EndDeviceEventDetail
extends
    Parseable[EndDeviceEventDetail]
{
    override val fields: Array[String] = Array[String] (
        "name",
        "value",
        "EndDeviceEvent"
    )
    override val relations: List[Relationship] = List (
        Relationship ("EndDeviceEvent", "EndDeviceEvent", "0..1", "0..*")
    )
    val name: Fielder = parse_element (element (cls, fields(0)))
    val value: Fielder = parse_attribute (attribute (cls, fields(1)))
    val EndDeviceEvent: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): EndDeviceEventDetail =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EndDeviceEventDetail (
            BasicElement.parse (context),
            mask (name (), 0),
            mask (value (), 1),
            mask (EndDeviceEvent (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Detailed description for an event produced by an end device.
 *
 * Values in attributes allow for creation of recommended codes to be used for identifying end device events as follows: <type>.<domain>.<subDomain>.<eventOrAction>.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param domain High-level nature of the event.
 *        By properly classifying events by a small set of domain codes, a system can more easily run reports based on the types of events that have occurred or been received.
 * @param eventOrAction The most specific part of this event type.
 *        It is mainly in the form of a verb that gives action to the event that just occurred.
 * @param subDomain More specific nature of the event, as a further sub-categorisation of 'domain'.
 * @param type Type of physical device from which the event was created.
 *        A value of zero (0) can be used when the source is unknown.
 * @param EndDeviceEvents [[ch.ninecode.model.EndDeviceEvent EndDeviceEvent]] All end device events of this type.
 * @group Metering
 * @groupname Metering Package Metering
 * @groupdesc Metering This package contains the core information classes that support end device applications with specialized classes for metering and premises area network devices, and remote reading functions. These classes are generally associated with the point where a service is delivered to the customer.
 */
final case class EndDeviceEventType
(
    override val sup: IdentifiedObject = null,
    domain: String = null,
    eventOrAction: String = null,
    subDomain: String = null,
    `type`: String = null,
    EndDeviceEvents: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = EndDeviceEventType.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (EndDeviceEventType.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (EndDeviceEventType.fields (position), x))
        emitelem (0, domain)
        emitelem (1, eventOrAction)
        emitelem (2, subDomain)
        emitelem (3, `type`)
        emitattrs (4, EndDeviceEvents)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EndDeviceEventType rdf:ID=\"%s\">\n%s\t</cim:EndDeviceEventType>".format (id, export_fields)
    }
}

object EndDeviceEventType
extends
    Parseable[EndDeviceEventType]
{
    override val fields: Array[String] = Array[String] (
        "domain",
        "eventOrAction",
        "subDomain",
        "type",
        "EndDeviceEvents"
    )
    override val relations: List[Relationship] = List (
        Relationship ("EndDeviceEvents", "EndDeviceEvent", "0..*", "1")
    )
    val domain: Fielder = parse_element (element (cls, fields(0)))
    val eventOrAction: Fielder = parse_element (element (cls, fields(1)))
    val subDomain: Fielder = parse_element (element (cls, fields(2)))
    val `type`: Fielder = parse_element (element (cls, fields(3)))
    val EndDeviceEvents: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: Context): EndDeviceEventType =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EndDeviceEventType (
            IdentifiedObject.parse (context),
            mask (domain (), 0),
            mask (eventOrAction (), 1),
            mask (subDomain (), 2),
            mask (`type` (), 3),
            masks (EndDeviceEvents (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Function performed by an end device such as a meter, communication equipment, controllers, etc.
 *
 * @param sup [[ch.ninecode.model.AssetFunction AssetFunction]] Reference to the superclass object.
 * @param enabled True if the function is enabled.
 * @param EndDevice [[ch.ninecode.model.EndDevice EndDevice]] End device that performs this function.
 * @param Registers [[ch.ninecode.model.Register Register]] All registers for quantities metered by this end device function.
 * @group Metering
 * @groupname Metering Package Metering
 * @groupdesc Metering This package contains the core information classes that support end device applications with specialized classes for metering and premises area network devices, and remote reading functions. These classes are generally associated with the point where a service is delivered to the customer.
 */
final case class EndDeviceFunction
(
    override val sup: AssetFunction = null,
    enabled: Boolean = false,
    EndDevice: String = null,
    Registers: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def AssetFunction: AssetFunction = sup
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = EndDeviceFunction.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (EndDeviceFunction.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EndDeviceFunction.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (EndDeviceFunction.fields (position), x))
        emitelem (0, enabled)
        emitattr (1, EndDevice)
        emitattrs (2, Registers)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EndDeviceFunction rdf:ID=\"%s\">\n%s\t</cim:EndDeviceFunction>".format (id, export_fields)
    }
}

object EndDeviceFunction
extends
    Parseable[EndDeviceFunction]
{
    override val fields: Array[String] = Array[String] (
        "enabled",
        "EndDevice",
        "Registers"
    )
    override val relations: List[Relationship] = List (
        Relationship ("EndDevice", "EndDevice", "0..1", "0..*"),
        Relationship ("Registers", "Register", "0..*", "0..1")
    )
    val enabled: Fielder = parse_element (element (cls, fields(0)))
    val EndDevice: Fielder = parse_attribute (attribute (cls, fields(1)))
    val Registers: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: Context): EndDeviceFunction =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EndDeviceFunction (
            AssetFunction.parse (context),
            toBoolean (mask (enabled (), 0)),
            mask (EndDevice (), 1),
            masks (Registers (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Abstraction for management of group communications within a two-way AMR system or the data for a group of related end devices.
 *
 * Commands can be issued to all of the end devices that belong to the group using a defined group address and the underlying AMR communication infrastructure. A DERGroup and a PANDeviceGroup is an EndDeviceGroup.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param status <em>undocumented</em>
 * @param type Type of this group.
 * @param version <em>undocumented</em>
 * @param DERFunction [[ch.ninecode.model.DERFunction DERFunction]] <em>undocumented</em>
 * @param DERGroupDispatch [[ch.ninecode.model.DERGroupDispatch DERGroupDispatch]] <em>undocumented</em>
 * @param DERGroupForecast [[ch.ninecode.model.DERGroupForecast DERGroupForecast]] <em>undocumented</em>
 * @param DERMonitorableParameter [[ch.ninecode.model.DERMonitorableParameter DERMonitorableParameter]] <em>undocumented</em>
 * @param DemandResponsePrograms [[ch.ninecode.model.DemandResponseProgram DemandResponseProgram]] All demand response programs this group of end devices is enrolled in.
 * @param DispatchablePowerCapability [[ch.ninecode.model.DispatchablePowerCapability DispatchablePowerCapability]] <em>undocumented</em>
 * @param EndDeviceControls [[ch.ninecode.model.EndDeviceControl EndDeviceControl]] All end device controls sending commands to this end device group.
 * @param EndDevices [[ch.ninecode.model.EndDevice EndDevice]] All end devices this end device group refers to.
 * @group Metering
 * @groupname Metering Package Metering
 * @groupdesc Metering This package contains the core information classes that support end device applications with specialized classes for metering and premises area network devices, and remote reading functions. These classes are generally associated with the point where a service is delivered to the customer.
 */
final case class EndDeviceGroup
(
    override val sup: IdentifiedObject = null,
    status: String = null,
    `type`: String = null,
    version: String = null,
    DERFunction: String = null,
    DERGroupDispatch: List[String] = null,
    DERGroupForecast: List[String] = null,
    DERMonitorableParameter: List[String] = null,
    DemandResponsePrograms: List[String] = null,
    DispatchablePowerCapability: String = null,
    EndDeviceControls: List[String] = null,
    EndDevices: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = EndDeviceGroup.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (EndDeviceGroup.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EndDeviceGroup.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (EndDeviceGroup.fields (position), x))
        emitattr (0, status)
        emitelem (1, `type`)
        emitattr (2, version)
        emitattr (3, DERFunction)
        emitattrs (4, DERGroupDispatch)
        emitattrs (5, DERGroupForecast)
        emitattrs (6, DERMonitorableParameter)
        emitattrs (7, DemandResponsePrograms)
        emitattr (8, DispatchablePowerCapability)
        emitattrs (9, EndDeviceControls)
        emitattrs (10, EndDevices)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EndDeviceGroup rdf:ID=\"%s\">\n%s\t</cim:EndDeviceGroup>".format (id, export_fields)
    }
}

object EndDeviceGroup
extends
    Parseable[EndDeviceGroup]
{
    override val fields: Array[String] = Array[String] (
        "status",
        "type",
        "version",
        "DERFunction",
        "DERGroupDispatch",
        "DERGroupForecast",
        "DERMonitorableParameter",
        "DemandResponsePrograms",
        "DispatchablePowerCapability",
        "EndDeviceControls",
        "EndDevices"
    )
    override val relations: List[Relationship] = List (
        Relationship ("DERFunction", "DERFunction", "0..1", "0..*"),
        Relationship ("DERGroupDispatch", "DERGroupDispatch", "0..*", "0..*"),
        Relationship ("DERGroupForecast", "DERGroupForecast", "1..*", "1..*"),
        Relationship ("DERMonitorableParameter", "DERMonitorableParameter", "0..*", "0..*"),
        Relationship ("DemandResponsePrograms", "DemandResponseProgram", "0..*", "0..*"),
        Relationship ("DispatchablePowerCapability", "DispatchablePowerCapability", "0..1", "0..1"),
        Relationship ("EndDeviceControls", "EndDeviceControl", "0..*", "0..*"),
        Relationship ("EndDevices", "EndDevice", "0..*", "0..*")
    )
    val status: Fielder = parse_attribute (attribute (cls, fields(0)))
    val `type`: Fielder = parse_element (element (cls, fields(1)))
    val version: Fielder = parse_attribute (attribute (cls, fields(2)))
    val DERFunction: Fielder = parse_attribute (attribute (cls, fields(3)))
    val DERGroupDispatch: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val DERGroupForecast: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val DERMonitorableParameter: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val DemandResponsePrograms: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val DispatchablePowerCapability: Fielder = parse_attribute (attribute (cls, fields(8)))
    val EndDeviceControls: FielderMultiple = parse_attributes (attribute (cls, fields(9)))
    val EndDevices: FielderMultiple = parse_attributes (attribute (cls, fields(10)))

    def parse (context: Context): EndDeviceGroup =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EndDeviceGroup (
            IdentifiedObject.parse (context),
            mask (status (), 0),
            mask (`type` (), 1),
            mask (version (), 2),
            mask (DERFunction (), 3),
            masks (DERGroupDispatch (), 4),
            masks (DERGroupForecast (), 5),
            masks (DERMonitorableParameter (), 6),
            masks (DemandResponsePrograms (), 7),
            mask (DispatchablePowerCapability (), 8),
            masks (EndDeviceControls (), 9),
            masks (EndDevices (), 10)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * End device data.
 *
 * @param sup [[ch.ninecode.model.AssetInfo AssetInfo]] Reference to the superclass object.
 * @param capability [[ch.ninecode.model.EndDeviceCapability EndDeviceCapability]] Inherent capabilities of the device (i.e., the functions it supports).
 * @param isSolidState If true, this is a solid state end device (as opposed to a mechanical or electromechanical device).
 * @param phaseCount Number of potential phases the end device supports, typically 0, 1 or 3.
 * @param ratedCurrent Rated current.
 * @param ratedVoltage Rated voltage.
 * @param EndDevices [[ch.ninecode.model.EndDevice EndDevice]] All end devices described with this data.
 * @group Metering
 * @groupname Metering Package Metering
 * @groupdesc Metering This package contains the core information classes that support end device applications with specialized classes for metering and premises area network devices, and remote reading functions. These classes are generally associated with the point where a service is delivered to the customer.
 */
final case class EndDeviceInfo
(
    override val sup: AssetInfo = null,
    capability: String = null,
    isSolidState: Boolean = false,
    phaseCount: Int = 0,
    ratedCurrent: Double = 0.0,
    ratedVoltage: Double = 0.0,
    EndDevices: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def AssetInfo: AssetInfo = sup
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = EndDeviceInfo.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (EndDeviceInfo.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EndDeviceInfo.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (EndDeviceInfo.fields (position), x))
        emitattr (0, capability)
        emitelem (1, isSolidState)
        emitelem (2, phaseCount)
        emitelem (3, ratedCurrent)
        emitelem (4, ratedVoltage)
        emitattrs (5, EndDevices)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EndDeviceInfo rdf:ID=\"%s\">\n%s\t</cim:EndDeviceInfo>".format (id, export_fields)
    }
}

object EndDeviceInfo
extends
    Parseable[EndDeviceInfo]
{
    override val fields: Array[String] = Array[String] (
        "capability",
        "isSolidState",
        "phaseCount",
        "ratedCurrent",
        "ratedVoltage",
        "EndDevices"
    )
    override val relations: List[Relationship] = List (
        Relationship ("capability", "EndDeviceCapability", "0..1", "0..*"),
        Relationship ("EndDevices", "EndDevice", "0..*", "0..1")
    )
    val capability: Fielder = parse_attribute (attribute (cls, fields(0)))
    val isSolidState: Fielder = parse_element (element (cls, fields(1)))
    val phaseCount: Fielder = parse_element (element (cls, fields(2)))
    val ratedCurrent: Fielder = parse_element (element (cls, fields(3)))
    val ratedVoltage: Fielder = parse_element (element (cls, fields(4)))
    val EndDevices: FielderMultiple = parse_attributes (attribute (cls, fields(5)))

    def parse (context: Context): EndDeviceInfo =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EndDeviceInfo (
            AssetInfo.parse (context),
            mask (capability (), 0),
            toBoolean (mask (isSolidState (), 1)),
            toInteger (mask (phaseCount (), 2)),
            toDouble (mask (ratedCurrent (), 3)),
            toDouble (mask (ratedVoltage (), 4)),
            masks (EndDevices (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Timing for the control actions of end devices.
 *
 * @param sup Reference to the superclass object.
 * @param duration Duration of the end device control action or the business event that is the subject of the end device control.
 * @param durationIndefinite True if 'duration' is indefinite.
 * @param interval Start and end time of an interval during which end device control actions are to be executed.
 * @param randomisation Kind of randomisation to be applied to the end device control actions to be executed.
 * @group Metering
 * @groupname Metering Package Metering
 * @groupdesc Metering This package contains the core information classes that support end device applications with specialized classes for metering and premises area network devices, and remote reading functions. These classes are generally associated with the point where a service is delivered to the customer.
 */
final case class EndDeviceTiming
(
    override val sup: BasicElement = null,
    duration: Double = 0.0,
    durationIndefinite: Boolean = false,
    interval: String = null,
    randomisation: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = EndDeviceTiming.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (EndDeviceTiming.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EndDeviceTiming.fields (position), value)
        emitelem (0, duration)
        emitelem (1, durationIndefinite)
        emitattr (2, interval)
        emitattr (3, randomisation)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EndDeviceTiming rdf:ID=\"%s\">\n%s\t</cim:EndDeviceTiming>".format (id, export_fields)
    }
}

object EndDeviceTiming
extends
    Parseable[EndDeviceTiming]
{
    override val fields: Array[String] = Array[String] (
        "duration",
        "durationIndefinite",
        "interval",
        "randomisation"
    )
    val duration: Fielder = parse_element (element (cls, fields(0)))
    val durationIndefinite: Fielder = parse_element (element (cls, fields(1)))
    val interval: Fielder = parse_attribute (attribute (cls, fields(2)))
    val randomisation: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): EndDeviceTiming =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EndDeviceTiming (
            BasicElement.parse (context),
            toDouble (mask (duration (), 0)),
            toBoolean (mask (durationIndefinite (), 1)),
            mask (interval (), 2),
            mask (randomisation (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Time sequence of readings of the same reading type.
 *
 * Contained interval readings may need conversion through the application of an offset and a scalar defined in associated pending.
 * Table 548 shows all association ends of IntervalBlock with other classes.
 * Table 548 – Association ends of Metering::IntervalBlock with other classes
 * Associations
 * name
 * mult to
 * type
 * description
 * 
 * 0..*
 * PendingCalculation
 * 0..1
 * PendingCalculation
 * Pending calculation to apply to interval reading values contained by this block (after which the resulting reading type is different than the original because it reflects the conversion result).
 * 
 * 0..*
 * IntervalReadings
 * 0..*
 * IntervalReading
 * Interval reading contained in this block.
 * 
 * 0..*
 * ReadingType
 * 0..1
 * ReadingType
 * Type information for interval reading values contained in this block.
 * 
 * 0..*
 * MeterReading
 * 0..1
 * MeterReading
 * Meter reading containing this interval block.
 * 
 * 
 * IntervalReading
 * Data captured at regular intervals of time. Interval data could be captured as incremental data, absolute data, or relative data. The source for the data is usually a tariff quantity or an engineering quantity. Data is typically captured in time-tagged, uniform, fixed-length intervals of 5 min, 10 min, 15 min, 30 min, or 60 min.
 * Note: Interval Data is sometimes also called "Interval Data Readings" (IDR).
 *
 * @param sup Reference to the superclass object.
 * @param IntervalReadings [[ch.ninecode.model.IntervalReading IntervalReading]] Interval reading contained in this block.
 * @param MeterReading [[ch.ninecode.model.MeterReading MeterReading]] Meter reading containing this interval block.
 * @param PendingCalculation [[ch.ninecode.model.PendingCalculation PendingCalculation]] Pending calculation to apply to interval reading values contained by this block (after which the resulting reading type is different than the original because it reflects the conversion result).
 * @param ReadingType [[ch.ninecode.model.ReadingType ReadingType]] Type information for interval reading values contained in this block.
 * @group Metering
 * @groupname Metering Package Metering
 * @groupdesc Metering This package contains the core information classes that support end device applications with specialized classes for metering and premises area network devices, and remote reading functions. These classes are generally associated with the point where a service is delivered to the customer.
 */
final case class IntervalBlock
(
    override val sup: BasicElement = null,
    IntervalReadings: List[String] = null,
    MeterReading: String = null,
    PendingCalculation: String = null,
    ReadingType: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = IntervalBlock.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (IntervalBlock.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (IntervalBlock.fields (position), x))
        emitattrs (0, IntervalReadings)
        emitattr (1, MeterReading)
        emitattr (2, PendingCalculation)
        emitattr (3, ReadingType)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:IntervalBlock rdf:ID=\"%s\">\n%s\t</cim:IntervalBlock>".format (id, export_fields)
    }
}

object IntervalBlock
extends
    Parseable[IntervalBlock]
{
    override val fields: Array[String] = Array[String] (
        "IntervalReadings",
        "MeterReading",
        "PendingCalculation",
        "ReadingType"
    )
    override val relations: List[Relationship] = List (
        Relationship ("IntervalReadings", "IntervalReading", "0..*", "0..*"),
        Relationship ("MeterReading", "MeterReading", "0..1", "0..*"),
        Relationship ("PendingCalculation", "PendingCalculation", "0..1", "0..*"),
        Relationship ("ReadingType", "ReadingType", "0..1", "0..*")
    )
    val IntervalReadings: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val MeterReading: Fielder = parse_attribute (attribute (cls, fields(1)))
    val PendingCalculation: Fielder = parse_attribute (attribute (cls, fields(2)))
    val ReadingType: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): IntervalBlock =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = IntervalBlock (
            BasicElement.parse (context),
            masks (IntervalReadings (), 0),
            mask (MeterReading (), 1),
            mask (PendingCalculation (), 2),
            mask (ReadingType (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Data captured at regular intervals of time.
 *
 * Interval data could be captured as incremental data, absolute data, or relative data. The source for the data is usually a tariff quantity or an engineering quantity. Data is typically captured in time-tagged, uniform, fixed-length intervals of 5 min, 10 min, 15 min, 30 min, or 60 min.
 * Note: Interval Data is sometimes also called "Interval Data Readings" (IDR).
 *
 * @param sup [[ch.ninecode.model.BaseReading BaseReading]] Reference to the superclass object.
 * @param IntervalBlocks [[ch.ninecode.model.IntervalBlock IntervalBlock]] All blocks containing this interval reading.
 * @group Metering
 * @groupname Metering Package Metering
 * @groupdesc Metering This package contains the core information classes that support end device applications with specialized classes for metering and premises area network devices, and remote reading functions. These classes are generally associated with the point where a service is delivered to the customer.
 */
final case class IntervalReading
(
    override val sup: BaseReading = null,
    IntervalBlocks: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def BaseReading: BaseReading = sup
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = IntervalReading.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (IntervalReading.fields (position), x))
        emitattrs (0, IntervalBlocks)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:IntervalReading rdf:ID=\"%s\">\n%s\t</cim:IntervalReading>".format (id, export_fields)
    }
}

object IntervalReading
extends
    Parseable[IntervalReading]
{
    override val fields: Array[String] = Array[String] (
        "IntervalBlocks"
    )
    override val relations: List[Relationship] = List (
        Relationship ("IntervalBlocks", "IntervalBlock", "0..*", "0..*")
    )
    val IntervalBlocks: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): IntervalReading =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = IntervalReading (
            BaseReading.parse (context),
            masks (IntervalBlocks (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Physical asset that performs the metering role of the usage point.
 *
 * Used for measuring consumption and detection of events.
 *
 * @param sup [[ch.ninecode.model.EndDevice EndDevice]] Reference to the superclass object.
 * @param connectionCategory A code used to specify the connection category, e.g. low voltage, where the meter operates.
 * @param formNumber Meter form designation per ANSI C12.10 or other applicable standard.
 *        An alphanumeric designation denoting the circuit arrangement for which the meter is applicable and its specific terminal arrangement.
 * @param MeterMultipliers [[ch.ninecode.model.MeterMultiplier MeterMultiplier]] All multipliers applied at this meter.
 * @param MeterReadings [[ch.ninecode.model.MeterReading MeterReading]] All meter readings provided by this meter.
 * @param MeterReplacementWorkTasks [[ch.ninecode.model.MeterWorkTask MeterWorkTask]] All work tasks on replacement of this old meter.
 * @param MeterServiceWorkTask [[ch.ninecode.model.MeterWorkTask MeterWorkTask]] All non-replacement work tasks on this meter.
 * @param VendingTransactions [[ch.ninecode.model.Transaction Transaction]] All vending transactions on this meter.
 * @group Metering
 * @groupname Metering Package Metering
 * @groupdesc Metering This package contains the core information classes that support end device applications with specialized classes for metering and premises area network devices, and remote reading functions. These classes are generally associated with the point where a service is delivered to the customer.
 */
final case class Meter
(
    override val sup: EndDevice = null,
    connectionCategory: String = null,
    formNumber: String = null,
    MeterMultipliers: List[String] = null,
    MeterReadings: List[String] = null,
    MeterReplacementWorkTasks: List[String] = null,
    MeterServiceWorkTask: List[String] = null,
    VendingTransactions: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def EndDevice: EndDevice = sup
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Meter.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Meter.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Meter.fields (position), x))
        emitelem (0, connectionCategory)
        emitelem (1, formNumber)
        emitattrs (2, MeterMultipliers)
        emitattrs (3, MeterReadings)
        emitattrs (4, MeterReplacementWorkTasks)
        emitattrs (5, MeterServiceWorkTask)
        emitattrs (6, VendingTransactions)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Meter rdf:ID=\"%s\">\n%s\t</cim:Meter>".format (id, export_fields)
    }
}

object Meter
extends
    Parseable[Meter]
{
    override val fields: Array[String] = Array[String] (
        "connectionCategory",
        "formNumber",
        "MeterMultipliers",
        "MeterReadings",
        "MeterReplacementWorkTasks",
        "MeterServiceWorkTask",
        "VendingTransactions"
    )
    override val relations: List[Relationship] = List (
        Relationship ("MeterMultipliers", "MeterMultiplier", "0..*", "0..1"),
        Relationship ("MeterReadings", "MeterReading", "0..*", "0..1"),
        Relationship ("MeterReplacementWorkTasks", "MeterWorkTask", "0..*", "0..1"),
        Relationship ("MeterServiceWorkTask", "MeterWorkTask", "0..*", "0..1"),
        Relationship ("VendingTransactions", "Transaction", "0..*", "0..1")
    )
    val connectionCategory: Fielder = parse_element (element (cls, fields(0)))
    val formNumber: Fielder = parse_element (element (cls, fields(1)))
    val MeterMultipliers: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val MeterReadings: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val MeterReplacementWorkTasks: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val MeterServiceWorkTask: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val VendingTransactions: FielderMultiple = parse_attributes (attribute (cls, fields(6)))

    def parse (context: Context): Meter =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Meter (
            EndDevice.parse (context),
            mask (connectionCategory (), 0),
            mask (formNumber (), 1),
            masks (MeterMultipliers (), 2),
            masks (MeterReadings (), 3),
            masks (MeterReplacementWorkTasks (), 4),
            masks (MeterServiceWorkTask (), 5),
            masks (VendingTransactions (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Multiplier applied at the meter.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param kind Kind of multiplier.
 * @param value Multiplier value.
 * @param Meter [[ch.ninecode.model.Meter Meter]] Meter applying this multiplier.
 * @group Metering
 * @groupname Metering Package Metering
 * @groupdesc Metering This package contains the core information classes that support end device applications with specialized classes for metering and premises area network devices, and remote reading functions. These classes are generally associated with the point where a service is delivered to the customer.
 */
final case class MeterMultiplier
(
    override val sup: IdentifiedObject = null,
    kind: String = null,
    value: Double = 0.0,
    Meter: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MeterMultiplier.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MeterMultiplier.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MeterMultiplier.fields (position), value)
        emitattr (0, kind)
        emitelem (1, value)
        emitattr (2, Meter)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MeterMultiplier rdf:ID=\"%s\">\n%s\t</cim:MeterMultiplier>".format (id, export_fields)
    }
}

object MeterMultiplier
extends
    Parseable[MeterMultiplier]
{
    override val fields: Array[String] = Array[String] (
        "kind",
        "value",
        "Meter"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Meter", "Meter", "0..1", "0..*")
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val value: Fielder = parse_element (element (cls, fields(1)))
    val Meter: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): MeterMultiplier =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MeterMultiplier (
            IdentifiedObject.parse (context),
            mask (kind (), 0),
            toDouble (mask (value (), 1)),
            mask (Meter (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Set of values obtained from the meter.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param isCoincidentTrigger If true, this meter reading is the meter reading for which other coincident meter readings are requested or provided.
 * @param valuesInterval Date and time interval of the data items contained within this meter reading.
 * @param CustomerAgreement [[ch.ninecode.model.CustomerAgreement CustomerAgreement]] (could be deprecated in the future) Customer agreement for this meter reading.
 * @param EndDeviceEvents [[ch.ninecode.model.EndDeviceEvent EndDeviceEvent]] All end device events associated with this set of measured values.
 * @param IntervalBlocks [[ch.ninecode.model.IntervalBlock IntervalBlock]] All interval blocks contained in this meter reading.
 * @param Meter [[ch.ninecode.model.Meter Meter]] Meter providing this reading.
 * @param Readings [[ch.ninecode.model.Reading Reading]] All reading values contained within this meter reading.
 * @param UsagePoint [[ch.ninecode.model.UsagePoint UsagePoint]] Usage point from which this meter reading (set of values) has been obtained.
 * @group Metering
 * @groupname Metering Package Metering
 * @groupdesc Metering This package contains the core information classes that support end device applications with specialized classes for metering and premises area network devices, and remote reading functions. These classes are generally associated with the point where a service is delivered to the customer.
 */
final case class MeterReading
(
    override val sup: IdentifiedObject = null,
    isCoincidentTrigger: Boolean = false,
    valuesInterval: String = null,
    CustomerAgreement: String = null,
    EndDeviceEvents: List[String] = null,
    IntervalBlocks: List[String] = null,
    Meter: String = null,
    Readings: List[String] = null,
    UsagePoint: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MeterReading.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MeterReading.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MeterReading.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MeterReading.fields (position), x))
        emitelem (0, isCoincidentTrigger)
        emitattr (1, valuesInterval)
        emitattr (2, CustomerAgreement)
        emitattrs (3, EndDeviceEvents)
        emitattrs (4, IntervalBlocks)
        emitattr (5, Meter)
        emitattrs (6, Readings)
        emitattr (7, UsagePoint)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MeterReading rdf:ID=\"%s\">\n%s\t</cim:MeterReading>".format (id, export_fields)
    }
}

object MeterReading
extends
    Parseable[MeterReading]
{
    override val fields: Array[String] = Array[String] (
        "isCoincidentTrigger",
        "valuesInterval",
        "CustomerAgreement",
        "EndDeviceEvents",
        "IntervalBlocks",
        "Meter",
        "Readings",
        "UsagePoint"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CustomerAgreement", "CustomerAgreement", "0..1", "0..*"),
        Relationship ("EndDeviceEvents", "EndDeviceEvent", "0..*", "0..1"),
        Relationship ("IntervalBlocks", "IntervalBlock", "0..*", "0..1"),
        Relationship ("Meter", "Meter", "0..1", "0..*"),
        Relationship ("Readings", "Reading", "0..*", "0..*"),
        Relationship ("UsagePoint", "UsagePoint", "0..1", "0..*")
    )
    val isCoincidentTrigger: Fielder = parse_element (element (cls, fields(0)))
    val valuesInterval: Fielder = parse_attribute (attribute (cls, fields(1)))
    val CustomerAgreement: Fielder = parse_attribute (attribute (cls, fields(2)))
    val EndDeviceEvents: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val IntervalBlocks: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val Meter: Fielder = parse_attribute (attribute (cls, fields(5)))
    val Readings: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val UsagePoint: Fielder = parse_attribute (attribute (cls, fields(7)))

    def parse (context: Context): MeterReading =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MeterReading (
            IdentifiedObject.parse (context),
            toBoolean (mask (isCoincidentTrigger (), 0)),
            mask (valuesInterval (), 1),
            mask (CustomerAgreement (), 2),
            masks (EndDeviceEvents (), 3),
            masks (IntervalBlocks (), 4),
            mask (Meter (), 5),
            masks (Readings (), 6),
            mask (UsagePoint (), 7)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Work task involving meters.
 *
 * @param sup [[ch.ninecode.model.WorkTask WorkTask]] Reference to the superclass object.
 * @param Meter [[ch.ninecode.model.Meter Meter]] Meter on which this non-replacement work task is performed.
 * @param OldMeter [[ch.ninecode.model.Meter Meter]] Old meter replaced by this work task.
 * @param UsagePoint [[ch.ninecode.model.UsagePoint UsagePoint]] Usage point to which this meter service work task applies.
 * @group Metering
 * @groupname Metering Package Metering
 * @groupdesc Metering This package contains the core information classes that support end device applications with specialized classes for metering and premises area network devices, and remote reading functions. These classes are generally associated with the point where a service is delivered to the customer.
 */
final case class MeterWorkTask
(
    override val sup: WorkTask = null,
    Meter: String = null,
    OldMeter: String = null,
    UsagePoint: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def WorkTask: WorkTask = sup
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MeterWorkTask.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MeterWorkTask.fields (position), value)
        emitattr (0, Meter)
        emitattr (1, OldMeter)
        emitattr (2, UsagePoint)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MeterWorkTask rdf:ID=\"%s\">\n%s\t</cim:MeterWorkTask>".format (id, export_fields)
    }
}

object MeterWorkTask
extends
    Parseable[MeterWorkTask]
{
    override val fields: Array[String] = Array[String] (
        "Meter",
        "OldMeter",
        "UsagePoint"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Meter", "Meter", "0..1", "0..*"),
        Relationship ("OldMeter", "Meter", "0..1", "0..*"),
        Relationship ("UsagePoint", "UsagePoint", "0..1", "0..*")
    )
    val Meter: Fielder = parse_attribute (attribute (cls, fields(0)))
    val OldMeter: Fielder = parse_attribute (attribute (cls, fields(1)))
    val UsagePoint: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): MeterWorkTask =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MeterWorkTask (
            WorkTask.parse (context),
            mask (Meter (), 0),
            mask (OldMeter (), 1),
            mask (UsagePoint (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A specification of the metering requirements for a particular point within a network.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param reason Reason for this metrology requirement being specified.
 * @param ReadingTypes [[ch.ninecode.model.ReadingType ReadingType]] All reading types required to be collected by this metrology requirement.
 * @param UsagePoints [[ch.ninecode.model.UsagePoint UsagePoint]] All usage points having this metrology requirement.
 * @group Metering
 * @groupname Metering Package Metering
 * @groupdesc Metering This package contains the core information classes that support end device applications with specialized classes for metering and premises area network devices, and remote reading functions. These classes are generally associated with the point where a service is delivered to the customer.
 */
final case class MetrologyRequirement
(
    override val sup: IdentifiedObject = null,
    reason: String = null,
    ReadingTypes: List[String] = null,
    UsagePoints: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MetrologyRequirement.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MetrologyRequirement.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MetrologyRequirement.fields (position), x))
        emitattr (0, reason)
        emitattrs (1, ReadingTypes)
        emitattrs (2, UsagePoints)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MetrologyRequirement rdf:ID=\"%s\">\n%s\t</cim:MetrologyRequirement>".format (id, export_fields)
    }
}

object MetrologyRequirement
extends
    Parseable[MetrologyRequirement]
{
    override val fields: Array[String] = Array[String] (
        "reason",
        "ReadingTypes",
        "UsagePoints"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ReadingTypes", "ReadingType", "1..*", "0..*"),
        Relationship ("UsagePoints", "UsagePoint", "0..*", "0..*")
    )
    val reason: Fielder = parse_attribute (attribute (cls, fields(0)))
    val ReadingTypes: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val UsagePoints: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: Context): MetrologyRequirement =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MetrologyRequirement (
            IdentifiedObject.parse (context),
            mask (reason (), 0),
            masks (ReadingTypes (), 1),
            masks (UsagePoints (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * PAN control used to issue action/command to PAN devices during a demand response/load control event.
 *
 * @param sup [[ch.ninecode.model.EndDeviceAction EndDeviceAction]] Reference to the superclass object.
 * @param appliance [[ch.ninecode.model.ControlledAppliance ControlledAppliance]] Appliance being controlled.
 * @param avgLoadAdjustment Used to define a maximum energy usage limit as a percentage of the client implementations specific average energy usage.
 *        The load adjustment percentage is added to 100% creating a percentage limit applied to the client implementations specific average energy usage. A -10% load adjustment percentage will establish an energy usage limit equal to 90% of the client implementations specific average energy usage. Each load adjustment percentage is referenced to the client implementations specific average energy usage. There are no cumulative effects.
 *        The range of this field is -100% to +100% with a resolution of 1. A -100% value equals a total load shed. A +100% value will limit the energy usage to the client implementations specific average energy usage.
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
 * @group Metering
 * @groupname Metering Package Metering
 * @groupdesc Metering This package contains the core information classes that support end device applications with specialized classes for metering and premises area network devices, and remote reading functions. These classes are generally associated with the point where a service is delivered to the customer.
 */
final case class PanDemandResponse
(
    override val sup: EndDeviceAction = null,
    appliance: String = null,
    avgLoadAdjustment: Double = 0.0,
    cancelControlMode: String = null,
    cancelDateTime: String = null,
    cancelNow: Boolean = false,
    coolingOffset: Double = 0.0,
    coolingSetpoint: Double = 0.0,
    criticalityLevel: String = null,
    dutyCycle: Double = 0.0,
    enrollmentGroup: String = null,
    heatingOffset: Double = 0.0,
    heatingSetpoint: Double = 0.0
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def EndDeviceAction: EndDeviceAction = sup
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PanDemandResponse.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PanDemandResponse.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PanDemandResponse.fields (position), value)
        emitattr (0, appliance)
        emitelem (1, avgLoadAdjustment)
        emitelem (2, cancelControlMode)
        emitelem (3, cancelDateTime)
        emitelem (4, cancelNow)
        emitelem (5, coolingOffset)
        emitelem (6, coolingSetpoint)
        emitelem (7, criticalityLevel)
        emitelem (8, dutyCycle)
        emitelem (9, enrollmentGroup)
        emitelem (10, heatingOffset)
        emitelem (11, heatingSetpoint)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PanDemandResponse rdf:ID=\"%s\">\n%s\t</cim:PanDemandResponse>".format (id, export_fields)
    }
}

object PanDemandResponse
extends
    Parseable[PanDemandResponse]
{
    override val fields: Array[String] = Array[String] (
        "appliance",
        "avgLoadAdjustment",
        "cancelControlMode",
        "cancelDateTime",
        "cancelNow",
        "coolingOffset",
        "coolingSetpoint",
        "criticalityLevel",
        "dutyCycle",
        "enrollmentGroup",
        "heatingOffset",
        "heatingSetpoint"
    )
    override val relations: List[Relationship] = List (
        Relationship ("appliance", "ControlledAppliance", "0..1", "0..*")
    )
    val appliance: Fielder = parse_attribute (attribute (cls, fields(0)))
    val avgLoadAdjustment: Fielder = parse_element (element (cls, fields(1)))
    val cancelControlMode: Fielder = parse_element (element (cls, fields(2)))
    val cancelDateTime: Fielder = parse_element (element (cls, fields(3)))
    val cancelNow: Fielder = parse_element (element (cls, fields(4)))
    val coolingOffset: Fielder = parse_element (element (cls, fields(5)))
    val coolingSetpoint: Fielder = parse_element (element (cls, fields(6)))
    val criticalityLevel: Fielder = parse_element (element (cls, fields(7)))
    val dutyCycle: Fielder = parse_element (element (cls, fields(8)))
    val enrollmentGroup: Fielder = parse_element (element (cls, fields(9)))
    val heatingOffset: Fielder = parse_element (element (cls, fields(10)))
    val heatingSetpoint: Fielder = parse_element (element (cls, fields(11)))

    def parse (context: Context): PanDemandResponse =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PanDemandResponse (
            EndDeviceAction.parse (context),
            mask (appliance (), 0),
            toDouble (mask (avgLoadAdjustment (), 1)),
            mask (cancelControlMode (), 2),
            mask (cancelDateTime (), 3),
            toBoolean (mask (cancelNow (), 4)),
            toDouble (mask (coolingOffset (), 5)),
            toDouble (mask (coolingSetpoint (), 6)),
            mask (criticalityLevel (), 7),
            toDouble (mask (dutyCycle (), 8)),
            mask (enrollmentGroup (), 9),
            toDouble (mask (heatingOffset (), 10)),
            toDouble (mask (heatingSetpoint (), 11))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * PAN action/command used to issue the displaying of text messages on PAN devices.
 *
 * @param sup [[ch.ninecode.model.EndDeviceAction EndDeviceAction]] Reference to the superclass object.
 * @param confirmationRequired If true, the requesting entity (e.g. retail electric provider) requires confirmation of the successful display of the text message.
 * @param priority Priority associated with the text message to be displayed.
 * @param textMessage Text to be displayed by a PAN device.
 * @param transmissionMode Transmission mode to be used for this PAN display control.
 * @group Metering
 * @groupname Metering Package Metering
 * @groupdesc Metering This package contains the core information classes that support end device applications with specialized classes for metering and premises area network devices, and remote reading functions. These classes are generally associated with the point where a service is delivered to the customer.
 */
final case class PanDisplay
(
    override val sup: EndDeviceAction = null,
    confirmationRequired: Boolean = false,
    priority: String = null,
    textMessage: String = null,
    transmissionMode: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def EndDeviceAction: EndDeviceAction = sup
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PanDisplay.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PanDisplay.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PanDisplay.fields (position), value)
        emitelem (0, confirmationRequired)
        emitelem (1, priority)
        emitelem (2, textMessage)
        emitattr (3, transmissionMode)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PanDisplay rdf:ID=\"%s\">\n%s\t</cim:PanDisplay>".format (id, export_fields)
    }
}

object PanDisplay
extends
    Parseable[PanDisplay]
{
    override val fields: Array[String] = Array[String] (
        "confirmationRequired",
        "priority",
        "textMessage",
        "transmissionMode"
    )
    val confirmationRequired: Fielder = parse_element (element (cls, fields(0)))
    val priority: Fielder = parse_element (element (cls, fields(1)))
    val textMessage: Fielder = parse_element (element (cls, fields(2)))
    val transmissionMode: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): PanDisplay =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PanDisplay (
            EndDeviceAction.parse (context),
            toBoolean (mask (confirmationRequired (), 0)),
            mask (priority (), 1),
            mask (textMessage (), 2),
            mask (transmissionMode (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * PAN action/command used to issue pricing information to a PAN device.
 *
 * @param sup [[ch.ninecode.model.EndDeviceAction EndDeviceAction]] Reference to the superclass object.
 * @param providerID Unique identifier for the commodity provider.
 * @param PanPricingDetails [[ch.ninecode.model.PanPricingDetail PanPricingDetail]] All pricing details issued by this PAN pricing command/action.
 * @group Metering
 * @groupname Metering Package Metering
 * @groupdesc Metering This package contains the core information classes that support end device applications with specialized classes for metering and premises area network devices, and remote reading functions. These classes are generally associated with the point where a service is delivered to the customer.
 */
final case class PanPricing
(
    override val sup: EndDeviceAction = null,
    providerID: Int = 0,
    PanPricingDetails: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def EndDeviceAction: EndDeviceAction = sup
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PanPricing.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PanPricing.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (PanPricing.fields (position), x))
        emitelem (0, providerID)
        emitattrs (1, PanPricingDetails)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PanPricing rdf:ID=\"%s\">\n%s\t</cim:PanPricing>".format (id, export_fields)
    }
}

object PanPricing
extends
    Parseable[PanPricing]
{
    override val fields: Array[String] = Array[String] (
        "providerID",
        "PanPricingDetails"
    )
    override val relations: List[Relationship] = List (
        Relationship ("PanPricingDetails", "PanPricingDetail", "0..*", "0..1")
    )
    val providerID: Fielder = parse_element (element (cls, fields(0)))
    val PanPricingDetails: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): PanPricing =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PanPricing (
            EndDeviceAction.parse (context),
            toInteger (mask (providerID (), 0)),
            masks (PanPricingDetails (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Detail for a single price command/action.
 *
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
 * @param PanPricing [[ch.ninecode.model.PanPricing PanPricing]] PAN pricing command/action issuing this price detail.
 * @group Metering
 * @groupname Metering Package Metering
 * @groupdesc Metering This package contains the core information classes that support end device applications with specialized classes for metering and premises area network devices, and remote reading functions. These classes are generally associated with the point where a service is delivered to the customer.
 */
final case class PanPricingDetail
(
    override val sup: BasicElement = null,
    alternateCostDelivered: Double = 0.0,
    alternateCostUnit: String = null,
    currentTimeDate: String = null,
    generationPrice: Double = 0.0,
    generationPriceRatio: Double = 0.0,
    price: Double = 0.0,
    priceRatio: Double = 0.0,
    priceTier: Int = 0,
    priceTierCount: Int = 0,
    priceTierLabel: String = null,
    rateLabel: String = null,
    registerTier: String = null,
    unitOfMeasure: String = null,
    PanPricing: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PanPricingDetail.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PanPricingDetail.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PanPricingDetail.fields (position), value)
        emitelem (0, alternateCostDelivered)
        emitelem (1, alternateCostUnit)
        emitelem (2, currentTimeDate)
        emitelem (3, generationPrice)
        emitelem (4, generationPriceRatio)
        emitelem (5, price)
        emitelem (6, priceRatio)
        emitelem (7, priceTier)
        emitelem (8, priceTierCount)
        emitelem (9, priceTierLabel)
        emitelem (10, rateLabel)
        emitelem (11, registerTier)
        emitelem (12, unitOfMeasure)
        emitattr (13, PanPricing)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PanPricingDetail rdf:ID=\"%s\">\n%s\t</cim:PanPricingDetail>".format (id, export_fields)
    }
}

object PanPricingDetail
extends
    Parseable[PanPricingDetail]
{
    override val fields: Array[String] = Array[String] (
        "alternateCostDelivered",
        "alternateCostUnit",
        "currentTimeDate",
        "generationPrice",
        "generationPriceRatio",
        "price",
        "priceRatio",
        "priceTier",
        "priceTierCount",
        "priceTierLabel",
        "rateLabel",
        "registerTier",
        "unitOfMeasure",
        "PanPricing"
    )
    override val relations: List[Relationship] = List (
        Relationship ("PanPricing", "PanPricing", "0..1", "0..*")
    )
    val alternateCostDelivered: Fielder = parse_element (element (cls, fields(0)))
    val alternateCostUnit: Fielder = parse_element (element (cls, fields(1)))
    val currentTimeDate: Fielder = parse_element (element (cls, fields(2)))
    val generationPrice: Fielder = parse_element (element (cls, fields(3)))
    val generationPriceRatio: Fielder = parse_element (element (cls, fields(4)))
    val price: Fielder = parse_element (element (cls, fields(5)))
    val priceRatio: Fielder = parse_element (element (cls, fields(6)))
    val priceTier: Fielder = parse_element (element (cls, fields(7)))
    val priceTierCount: Fielder = parse_element (element (cls, fields(8)))
    val priceTierLabel: Fielder = parse_element (element (cls, fields(9)))
    val rateLabel: Fielder = parse_element (element (cls, fields(10)))
    val registerTier: Fielder = parse_element (element (cls, fields(11)))
    val unitOfMeasure: Fielder = parse_element (element (cls, fields(12)))
    val PanPricing: Fielder = parse_attribute (attribute (cls, fields(13)))

    def parse (context: Context): PanPricingDetail =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PanPricingDetail (
            BasicElement.parse (context),
            toDouble (mask (alternateCostDelivered (), 0)),
            mask (alternateCostUnit (), 1),
            mask (currentTimeDate (), 2),
            toDouble (mask (generationPrice (), 3)),
            toDouble (mask (generationPriceRatio (), 4)),
            toDouble (mask (price (), 5)),
            toDouble (mask (priceRatio (), 6)),
            toInteger (mask (priceTier (), 7)),
            toInteger (mask (priceTierCount (), 8)),
            mask (priceTierLabel (), 9),
            mask (rateLabel (), 10),
            mask (registerTier (), 11),
            mask (unitOfMeasure (), 12),
            mask (PanPricing (), 13)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * When present, a scalar conversion that needs to be applied to every IntervalReading.value contained in IntervalBlock.
 *
 * This conversion results in a new associated ReadingType, reflecting the true dimensions of IntervalReading values after the conversion.
 *
 * @param sup Reference to the superclass object.
 * @param multiplyBeforeAdd Whether scalars should be applied before adding the 'offset'.
 * @param offset (if applicable) Offset to be added as well as multiplication using scalars.
 * @param scalarDenominator (if scalar is rational number) When 'IntervalReading.value' is multiplied by 'scalarNumerator' and divided by this value, it causes a unit of measure conversion to occur, resulting in the 'ReadingType.unit'.
 * @param scalarFloat (if scalar is floating number) When multiplied with 'IntervalReading.value', it causes a unit of measure conversion to occur, according to the 'ReadingType.unit'.
 * @param scalarNumerator (if scalar is integer or rational number)  When the scalar is a simple integer, and this attribute is presented alone and multiplied with 'IntervalReading.value', it causes a unit of measure conversion to occur, resulting in the 'ReadingType.unit'.
 *        It is never used in conjunction with 'scalarFloat', only with 'scalarDenominator'.
 * @param IntervalBlocks [[ch.ninecode.model.IntervalBlock IntervalBlock]] All blocks of interval reading values to which this pending conversion applies.
 * @param ReadingType [[ch.ninecode.model.ReadingType ReadingType]] Reading type resulting from this pending conversion.
 * @group Metering
 * @groupname Metering Package Metering
 * @groupdesc Metering This package contains the core information classes that support end device applications with specialized classes for metering and premises area network devices, and remote reading functions. These classes are generally associated with the point where a service is delivered to the customer.
 */
final case class PendingCalculation
(
    override val sup: BasicElement = null,
    multiplyBeforeAdd: Boolean = false,
    offset: Int = 0,
    scalarDenominator: Int = 0,
    scalarFloat: Double = 0.0,
    scalarNumerator: Int = 0,
    IntervalBlocks: List[String] = null,
    ReadingType: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PendingCalculation.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PendingCalculation.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PendingCalculation.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (PendingCalculation.fields (position), x))
        emitelem (0, multiplyBeforeAdd)
        emitelem (1, offset)
        emitelem (2, scalarDenominator)
        emitelem (3, scalarFloat)
        emitelem (4, scalarNumerator)
        emitattrs (5, IntervalBlocks)
        emitattr (6, ReadingType)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PendingCalculation rdf:ID=\"%s\">\n%s\t</cim:PendingCalculation>".format (id, export_fields)
    }
}

object PendingCalculation
extends
    Parseable[PendingCalculation]
{
    override val fields: Array[String] = Array[String] (
        "multiplyBeforeAdd",
        "offset",
        "scalarDenominator",
        "scalarFloat",
        "scalarNumerator",
        "IntervalBlocks",
        "ReadingType"
    )
    override val relations: List[Relationship] = List (
        Relationship ("IntervalBlocks", "IntervalBlock", "0..*", "0..1"),
        Relationship ("ReadingType", "ReadingType", "1", "0..1")
    )
    val multiplyBeforeAdd: Fielder = parse_element (element (cls, fields(0)))
    val offset: Fielder = parse_element (element (cls, fields(1)))
    val scalarDenominator: Fielder = parse_element (element (cls, fields(2)))
    val scalarFloat: Fielder = parse_element (element (cls, fields(3)))
    val scalarNumerator: Fielder = parse_element (element (cls, fields(4)))
    val IntervalBlocks: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val ReadingType: Fielder = parse_attribute (attribute (cls, fields(6)))

    def parse (context: Context): PendingCalculation =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PendingCalculation (
            BasicElement.parse (context),
            toBoolean (mask (multiplyBeforeAdd (), 0)),
            toInteger (mask (offset (), 1)),
            toInteger (mask (scalarDenominator (), 2)),
            toDouble (mask (scalarFloat (), 3)),
            toInteger (mask (scalarNumerator (), 4)),
            masks (IntervalBlocks (), 5),
            mask (ReadingType (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Rational number = 'numerator' / 'denominator'.
 *
 * @param sup Reference to the superclass object.
 * @param denominator Denominator.
 *        Value 1 indicates the number is a simple integer.
 * @param numerator Numerator.
 * @group Metering
 * @groupname Metering Package Metering
 * @groupdesc Metering This package contains the core information classes that support end device applications with specialized classes for metering and premises area network devices, and remote reading functions. These classes are generally associated with the point where a service is delivered to the customer.
 */
final case class RationalNumber
(
    override val sup: BasicElement = null,
    denominator: Int = 0,
    numerator: Int = 0
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = RationalNumber.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (RationalNumber.fields (position), value)
        emitelem (0, denominator)
        emitelem (1, numerator)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RationalNumber rdf:ID=\"%s\">\n%s\t</cim:RationalNumber>".format (id, export_fields)
    }
}

object RationalNumber
extends
    Parseable[RationalNumber]
{
    override val fields: Array[String] = Array[String] (
        "denominator",
        "numerator"
    )
    val denominator: Fielder = parse_element (element (cls, fields(0)))
    val numerator: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: Context): RationalNumber =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = RationalNumber (
            BasicElement.parse (context),
            toInteger (mask (denominator (), 0)),
            toInteger (mask (numerator (), 1))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Specific value measured by a meter or other asset, or calculated by a system.
 *
 * Each Reading is associated with a specific ReadingType.
 *
 * @param sup [[ch.ninecode.model.BaseReading BaseReading]] Reference to the superclass object.
 * @param position A sequential value representing the relative position within a given time interval.
 * @param reason Reason for this reading being taken.
 * @param valueMissing The indication of whether or not the quantity of this reading is missing.
 * @param MeterReadings [[ch.ninecode.model.MeterReading MeterReading]] All meter readings (sets of values) containing this reading value.
 * @param ReadingType [[ch.ninecode.model.ReadingType ReadingType]] Type information for this reading value.
 * @group Metering
 * @groupname Metering Package Metering
 * @groupdesc Metering This package contains the core information classes that support end device applications with specialized classes for metering and premises area network devices, and remote reading functions. These classes are generally associated with the point where a service is delivered to the customer.
 */
final case class Reading
(
    override val sup: BaseReading = null,
    position: Int = 0,
    reason: String = null,
    valueMissing: Boolean = false,
    MeterReadings: List[String] = null,
    ReadingType: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def BaseReading: BaseReading = sup
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Reading.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Reading.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Reading.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Reading.fields (position), x))
        emitelem (0, position)
        emitattr (1, reason)
        emitelem (2, valueMissing)
        emitattrs (3, MeterReadings)
        emitattr (4, ReadingType)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Reading rdf:ID=\"%s\">\n%s\t</cim:Reading>".format (id, export_fields)
    }
}

object Reading
extends
    Parseable[Reading]
{
    override val fields: Array[String] = Array[String] (
        "position",
        "reason",
        "valueMissing",
        "MeterReadings",
        "ReadingType"
    )
    override val relations: List[Relationship] = List (
        Relationship ("MeterReadings", "MeterReading", "0..*", "0..*"),
        Relationship ("ReadingType", "ReadingType", "1", "0..*")
    )
    val position: Fielder = parse_element (element (cls, fields(0)))
    val reason: Fielder = parse_attribute (attribute (cls, fields(1)))
    val valueMissing: Fielder = parse_element (element (cls, fields(2)))
    val MeterReadings: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val ReadingType: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): Reading =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Reading (
            BaseReading.parse (context),
            toInteger (mask (position (), 0)),
            mask (reason (), 1),
            toBoolean (mask (valueMissing (), 2)),
            masks (MeterReadings (), 3),
            mask (ReadingType (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Interharmonics are represented as a rational number 'numerator' / 'denominator', and harmonics are represented using the same mechanism and identified by 'denominator'=1.
 *
 * @param sup Reference to the superclass object.
 * @param denominator Interharmonic denominator.
 *        Value 0 means not applicable. Value 2 is used in combination with 'numerator'=1 to represent interharmonic 1/2. Finally, value 1 indicates the harmonic of the order specified with 'numerator'.
 * @param numerator Interharmonic numerator.
 *        Value 0 means not applicable. Value 1 is used in combination with 'denominator'=2 to represent interharmonic 1/2, and with 'denominator'=1 it represents fundamental frequency. Finally, values greater than 1 indicate the harmonic of that order (e.g., 'numerator'=5 is the fifth harmonic).
 * @group Metering
 * @groupname Metering Package Metering
 * @groupdesc Metering This package contains the core information classes that support end device applications with specialized classes for metering and premises area network devices, and remote reading functions. These classes are generally associated with the point where a service is delivered to the customer.
 */
final case class ReadingInterharmonic
(
    override val sup: BasicElement = null,
    denominator: Int = 0,
    numerator: Int = 0
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ReadingInterharmonic.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ReadingInterharmonic.fields (position), value)
        emitelem (0, denominator)
        emitelem (1, numerator)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ReadingInterharmonic rdf:ID=\"%s\">\n%s\t</cim:ReadingInterharmonic>".format (id, export_fields)
    }
}

object ReadingInterharmonic
extends
    Parseable[ReadingInterharmonic]
{
    override val fields: Array[String] = Array[String] (
        "denominator",
        "numerator"
    )
    val denominator: Fielder = parse_element (element (cls, fields(0)))
    val numerator: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: Context): ReadingInterharmonic =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ReadingInterharmonic (
            BasicElement.parse (context),
            toInteger (mask (denominator (), 0)),
            toInteger (mask (numerator (), 1))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Quality of a specific reading value or interval reading value.
 *
 * Note that more than one quality may be applicable to a given reading. Typically not used unless problems or unusual conditions occur (i.e., quality for each reading is assumed to be good unless stated otherwise in associated reading quality type). It can also be used with the corresponding reading quality type to indicate that the validation has been performed and succeeded.
 *
 * @param sup Reference to the superclass object.
 * @param comment Elaboration on the quality code.
 * @param source System acting as the source of the quality code.
 * @param timeStamp Date and time at which the quality code was assigned or ascertained.
 * @param Reading [[ch.ninecode.model.BaseReading BaseReading]] Reading value to which this quality applies.
 * @param ReadingQualityType [[ch.ninecode.model.ReadingQualityType ReadingQualityType]] Type of this reading quality.
 * @group Metering
 * @groupname Metering Package Metering
 * @groupdesc Metering This package contains the core information classes that support end device applications with specialized classes for metering and premises area network devices, and remote reading functions. These classes are generally associated with the point where a service is delivered to the customer.
 */
final case class ReadingQuality
(
    override val sup: BasicElement = null,
    comment: String = null,
    source: String = null,
    timeStamp: String = null,
    Reading: String = null,
    ReadingQualityType: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ReadingQuality.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ReadingQuality.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ReadingQuality.fields (position), value)
        emitelem (0, comment)
        emitelem (1, source)
        emitelem (2, timeStamp)
        emitattr (3, Reading)
        emitattr (4, ReadingQualityType)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ReadingQuality rdf:ID=\"%s\">\n%s\t</cim:ReadingQuality>".format (id, export_fields)
    }
}

object ReadingQuality
extends
    Parseable[ReadingQuality]
{
    override val fields: Array[String] = Array[String] (
        "comment",
        "source",
        "timeStamp",
        "Reading",
        "ReadingQualityType"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Reading", "BaseReading", "0..1", "0..*"),
        Relationship ("ReadingQualityType", "ReadingQualityType", "1", "0..*")
    )
    val comment: Fielder = parse_element (element (cls, fields(0)))
    val source: Fielder = parse_element (element (cls, fields(1)))
    val timeStamp: Fielder = parse_element (element (cls, fields(2)))
    val Reading: Fielder = parse_attribute (attribute (cls, fields(3)))
    val ReadingQualityType: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): ReadingQuality =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ReadingQuality (
            BasicElement.parse (context),
            mask (comment (), 0),
            mask (source (), 1),
            mask (timeStamp (), 2),
            mask (Reading (), 3),
            mask (ReadingQualityType (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Detailed description for a quality of a reading value, produced by an end device or a system.
 *
 * Values in attributes allow for creation of the recommended codes to be used for identifying reading value quality codes as follows: <systemId>.<category>.<subCategory>.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param category High-level nature of the reading value quality.
 * @param subCategory More specific nature of the reading value quality, as a further sub-categorisation of 'category'.
 * @param systemId Identification of the system which has declared the issue with the data or provided commentary on the data.
 * @param ReadingQualities [[ch.ninecode.model.ReadingQuality ReadingQuality]] All reading qualities of this type.
 * @group Metering
 * @groupname Metering Package Metering
 * @groupdesc Metering This package contains the core information classes that support end device applications with specialized classes for metering and premises area network devices, and remote reading functions. These classes are generally associated with the point where a service is delivered to the customer.
 */
final case class ReadingQualityType
(
    override val sup: IdentifiedObject = null,
    category: String = null,
    subCategory: String = null,
    systemId: String = null,
    ReadingQualities: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ReadingQualityType.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ReadingQualityType.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ReadingQualityType.fields (position), x))
        emitelem (0, category)
        emitelem (1, subCategory)
        emitelem (2, systemId)
        emitattrs (3, ReadingQualities)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ReadingQualityType rdf:ID=\"%s\">\n%s\t</cim:ReadingQualityType>".format (id, export_fields)
    }
}

object ReadingQualityType
extends
    Parseable[ReadingQualityType]
{
    override val fields: Array[String] = Array[String] (
        "category",
        "subCategory",
        "systemId",
        "ReadingQualities"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ReadingQualities", "ReadingQuality", "0..*", "1")
    )
    val category: Fielder = parse_element (element (cls, fields(0)))
    val subCategory: Fielder = parse_element (element (cls, fields(1)))
    val systemId: Fielder = parse_element (element (cls, fields(2)))
    val ReadingQualities: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: Context): ReadingQualityType =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ReadingQualityType (
            IdentifiedObject.parse (context),
            mask (category (), 0),
            mask (subCategory (), 1),
            mask (systemId (), 2),
            masks (ReadingQualities (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Detailed description for a type of a reading value.
 *
 * Values in attributes allow for the creation of recommended codes to be used for identifying reading value types as follows: <macroPeriod>.<aggregate>.<measuringPeriod>.<accumulation>.<flowDirection>.<commodity>.<measurementKind>.<interharmonic.numerator>.<interharmonic.denominator>.<argument.numerator>.<argument.denominator>.<tou>.<cpp>.<consumptionTier>.<phases>.<multiplier>.<unit>.<currency>.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param accumulation Accumulation behaviour of a reading over time, usually 'measuringPeriod', to be used with individual endpoints (as opposed to 'macroPeriod' and 'aggregate' that are used to describe aggregations of data from individual endpoints).
 * @param aggregate Salient attribute of the reading data aggregated from individual endpoints.
 *        This is mainly used to define a mathematical operation carried out over 'macroPeriod', but may also be used to describe an attribute of the data when the 'macroPeriod' is not defined.
 * @param argument [[ch.ninecode.model.RationalNumber RationalNumber]] Argument used to introduce numbers into the unit of measure description where they are needed (e.g., 4 where the measure needs an argument such as CEMI(n=4)).
 *        Most arguments used in practice however will be integers (i.e., 'denominator'=1).
 *        Value 0 in 'numerator' and 'denominator' means not applicable.
 * @param commodity Commodity being measured.
 * @param consumptionTier In case of common flat-rate pricing for power, in which all purchases are at a given rate, 'consumptionTier'=0.
 *        Otherwise, the value indicates the consumption tier, which can be used in conjunction with TOU or CPP pricing.
 *        Consumption tier pricing refers to the method of billing in which a certain "block" of energy is purchased/sold at one price, after which the next block of energy is purchased at another price, and so on, all throughout a defined period. At the start of the defined period, consumption is initially zero, and any usage is measured against the first consumption tier ('consumptionTier'=1). If this block of energy is consumed before the end of the period, energy consumption moves to be reconed against the second consumption tier ('consumptionTier'=2), and so on. At the end of the defined period, the consumption accumulator is reset, and usage within the 'consumptionTier'=1 restarts.
 * @param cpp Critical peak period (CPP) bucket the reading value is attributed to.
 *        Value 0 means not applicable. Even though CPP is usually considered a specialised form of time of use 'tou', this attribute is defined explicitly for flexibility.
 * @param currency Metering-specific currency.
 * @param flowDirection Flow direction for a reading where the direction of flow of the commodity is important (for electricity measurements this includes current, energy, power, and demand).
 * @param interharmonic [[ch.ninecode.model.ReadingInterharmonic ReadingInterharmonic]] Indication of a "harmonic" or "interharmonic" basis for the measurement.
 *        Value 0 in 'numerator' and 'denominator' means not applicable.
 * @param macroPeriod Time period of interest that reflects how the reading is viewed or captured over a long period of time.
 * @param measurementKind Identifies "what" is being measured, as refinement of 'commodity'.
 *        When combined with 'unit', it provides detail to the unit of measure. For example, 'energy' with a unit of measure of 'kWh' indicates to the user that active energy is being measured, while with 'kVAh' or 'kVArh', it indicates apparent energy and reactive energy, respectively. 'power' can be combined in a similar way with various power units of measure: Distortion power ('distortionVoltAmperes') with 'kVA' is different from 'power' with 'kVA'.
 * @param measuringPeriod Time attribute inherent or fundamental to the reading value (as opposed to 'macroPeriod' that supplies an "adjective" to describe aspects of a time period with regard to the measurement).
 *        It refers to the way the value was originally measured and not to the frequency at which it is reported or presented. For example, an hourly interval of consumption data would have value 'hourly' as an attribute. However in the case of an hourly sampled voltage value, the meterReadings schema would carry the 'hourly' interval size information.
 *        It is common for meters to report demand in a form that is measured over the course of a portion of an hour, while enterprise applications however commonly assume the demand (in kW or kVAr) normalised to 1 hour. The system that receives readings directly from the meter therefore shall perform this transformation before publishing readings for use by the other enterprise systems. The scalar used is chosen based on the block size (not any sub-interval size).
 * @param multiplier Metering-specific multiplier.
 * @param phases Metering-specific phase code.
 * @param tou Time of use (TOU) bucket the reading value is attributed to.
 *        Value 0 means not applicable.
 * @param unit Metering-specific unit.
 * @param Channel [[ch.ninecode.model.Channel Channel]] Channel reporting/collecting register values with this type information.
 * @param ConsumptionTariffIntervals [[ch.ninecode.model.ConsumptionTariffInterval ConsumptionTariffInterval]] All tariff intervals with consumption described by this reading type.
 * @param IntervalBlocks [[ch.ninecode.model.IntervalBlock IntervalBlock]] All blocks containing interval reading values with this type information.
 * @param MetrologyRequirements [[ch.ninecode.model.MetrologyRequirement MetrologyRequirement]] All metrology requirements that require this reading type to be collected.
 * @param PendingCalculation [[ch.ninecode.model.PendingCalculation PendingCalculation]] Pending calculation that produced this reading type.
 * @param Readings [[ch.ninecode.model.Reading Reading]] All reading values with this type information.
 * @group Metering
 * @groupname Metering Package Metering
 * @groupdesc Metering This package contains the core information classes that support end device applications with specialized classes for metering and premises area network devices, and remote reading functions. These classes are generally associated with the point where a service is delivered to the customer.
 */
final case class ReadingType
(
    override val sup: IdentifiedObject = null,
    accumulation: String = null,
    aggregate: String = null,
    argument: String = null,
    commodity: String = null,
    consumptionTier: Int = 0,
    cpp: Int = 0,
    currency: String = null,
    flowDirection: String = null,
    interharmonic: String = null,
    macroPeriod: String = null,
    measurementKind: String = null,
    measuringPeriod: String = null,
    multiplier: String = null,
    phases: String = null,
    tou: Int = 0,
    unit: String = null,
    Channel: String = null,
    ConsumptionTariffIntervals: List[String] = null,
    IntervalBlocks: List[String] = null,
    MetrologyRequirements: List[String] = null,
    PendingCalculation: String = null,
    Readings: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ReadingType.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ReadingType.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ReadingType.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ReadingType.fields (position), x))
        emitattr (0, accumulation)
        emitattr (1, aggregate)
        emitattr (2, argument)
        emitattr (3, commodity)
        emitelem (4, consumptionTier)
        emitelem (5, cpp)
        emitattr (6, currency)
        emitattr (7, flowDirection)
        emitattr (8, interharmonic)
        emitattr (9, macroPeriod)
        emitattr (10, measurementKind)
        emitattr (11, measuringPeriod)
        emitattr (12, multiplier)
        emitattr (13, phases)
        emitelem (14, tou)
        emitattr (15, unit)
        emitattr (16, Channel)
        emitattrs (17, ConsumptionTariffIntervals)
        emitattrs (18, IntervalBlocks)
        emitattrs (19, MetrologyRequirements)
        emitattr (20, PendingCalculation)
        emitattrs (21, Readings)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ReadingType rdf:ID=\"%s\">\n%s\t</cim:ReadingType>".format (id, export_fields)
    }
}

object ReadingType
extends
    Parseable[ReadingType]
{
    override val fields: Array[String] = Array[String] (
        "accumulation",
        "aggregate",
        "argument",
        "commodity",
        "consumptionTier",
        "cpp",
        "currency",
        "flowDirection",
        "interharmonic",
        "macroPeriod",
        "measurementKind",
        "measuringPeriod",
        "multiplier",
        "phases",
        "tou",
        "unit",
        "Channel",
        "ConsumptionTariffIntervals",
        "IntervalBlocks",
        "MetrologyRequirements",
        "PendingCalculation",
        "Readings"
    )
    override val relations: List[Relationship] = List (
        Relationship ("argument", "RationalNumber", "0..1", "0..*"),
        Relationship ("interharmonic", "ReadingInterharmonic", "0..1", "0..*"),
        Relationship ("Channel", "Channel", "0..1", "0..1"),
        Relationship ("ConsumptionTariffIntervals", "ConsumptionTariffInterval", "0..*", "0..1"),
        Relationship ("IntervalBlocks", "IntervalBlock", "0..*", "0..1"),
        Relationship ("MetrologyRequirements", "MetrologyRequirement", "0..*", "1..*"),
        Relationship ("PendingCalculation", "PendingCalculation", "0..1", "1"),
        Relationship ("Readings", "Reading", "0..*", "1")
    )
    val accumulation: Fielder = parse_attribute (attribute (cls, fields(0)))
    val aggregate: Fielder = parse_attribute (attribute (cls, fields(1)))
    val argument: Fielder = parse_attribute (attribute (cls, fields(2)))
    val commodity: Fielder = parse_attribute (attribute (cls, fields(3)))
    val consumptionTier: Fielder = parse_element (element (cls, fields(4)))
    val cpp: Fielder = parse_element (element (cls, fields(5)))
    val currency: Fielder = parse_attribute (attribute (cls, fields(6)))
    val flowDirection: Fielder = parse_attribute (attribute (cls, fields(7)))
    val interharmonic: Fielder = parse_attribute (attribute (cls, fields(8)))
    val macroPeriod: Fielder = parse_attribute (attribute (cls, fields(9)))
    val measurementKind: Fielder = parse_attribute (attribute (cls, fields(10)))
    val measuringPeriod: Fielder = parse_attribute (attribute (cls, fields(11)))
    val multiplier: Fielder = parse_attribute (attribute (cls, fields(12)))
    val phases: Fielder = parse_attribute (attribute (cls, fields(13)))
    val tou: Fielder = parse_element (element (cls, fields(14)))
    val unit: Fielder = parse_attribute (attribute (cls, fields(15)))
    val Channel: Fielder = parse_attribute (attribute (cls, fields(16)))
    val ConsumptionTariffIntervals: FielderMultiple = parse_attributes (attribute (cls, fields(17)))
    val IntervalBlocks: FielderMultiple = parse_attributes (attribute (cls, fields(18)))
    val MetrologyRequirements: FielderMultiple = parse_attributes (attribute (cls, fields(19)))
    val PendingCalculation: Fielder = parse_attribute (attribute (cls, fields(20)))
    val Readings: FielderMultiple = parse_attributes (attribute (cls, fields(21)))

    def parse (context: Context): ReadingType =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ReadingType (
            IdentifiedObject.parse (context),
            mask (accumulation (), 0),
            mask (aggregate (), 1),
            mask (argument (), 2),
            mask (commodity (), 3),
            toInteger (mask (consumptionTier (), 4)),
            toInteger (mask (cpp (), 5)),
            mask (currency (), 6),
            mask (flowDirection (), 7),
            mask (interharmonic (), 8),
            mask (macroPeriod (), 9),
            mask (measurementKind (), 10),
            mask (measuringPeriod (), 11),
            mask (multiplier (), 12),
            mask (phases (), 13),
            toInteger (mask (tou (), 14)),
            mask (unit (), 15),
            mask (Channel (), 16),
            masks (ConsumptionTariffIntervals (), 17),
            masks (IntervalBlocks (), 18),
            masks (MetrologyRequirements (), 19),
            mask (PendingCalculation (), 20),
            masks (Readings (), 21)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A device that indicates or records units of the commodity or other quantity measured.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param isVirtual If true, the data it produces is  calculated or measured by a device other than a physical end device/meter.
 *        Otherwise, any data streams it produces are measured by the hardware of the end device/meter itself.
 * @param leftDigitCount Number of digits (dials on a mechanical meter) to the left of the decimal place; default is normally 5.
 * @param rightDigitCount Number of digits (dials on a mechanical meter) to the right of the decimal place.
 * @param touTier Clock time interval for register to beging/cease accumulating time of usage (e.g., start at 8:00 am, stop at 5:00 pm).
 * @param touTierName Name used for the time of use tier (also known as bin or bucket).
 *        For example, "peak", "off-peak", "TOU Category A", etc.
 * @param Channels [[ch.ninecode.model.Channel Channel]] All channels that collect/report values from this register.
 * @param EndDeviceFunction [[ch.ninecode.model.EndDeviceFunction EndDeviceFunction]] End device function metering quantities displayed by this register.
 * @param Usage Point [[ch.ninecode.model.UsagePoint UsagePoint]] <em>undocumented</em>
 * @group Metering
 * @groupname Metering Package Metering
 * @groupdesc Metering This package contains the core information classes that support end device applications with specialized classes for metering and premises area network devices, and remote reading functions. These classes are generally associated with the point where a service is delivered to the customer.
 */
final case class Register
(
    override val sup: IdentifiedObject = null,
    isVirtual: Boolean = false,
    leftDigitCount: Int = 0,
    rightDigitCount: Int = 0,
    touTier: String = null,
    touTierName: String = null,
    Channels: List[String] = null,
    EndDeviceFunction: String = null,
    Usage_Point: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Register.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Register.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Register.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Register.fields (position), x))
        emitelem (0, isVirtual)
        emitelem (1, leftDigitCount)
        emitelem (2, rightDigitCount)
        emitattr (3, touTier)
        emitelem (4, touTierName)
        emitattrs (5, Channels)
        emitattr (6, EndDeviceFunction)
        emitattr (7, Usage_Point)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Register rdf:ID=\"%s\">\n%s\t</cim:Register>".format (id, export_fields)
    }
}

object Register
extends
    Parseable[Register]
{
    override val fields: Array[String] = Array[String] (
        "isVirtual",
        "leftDigitCount",
        "rightDigitCount",
        "touTier",
        "touTierName",
        "Channels",
        "EndDeviceFunction",
        "Usage Point"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Channels", "Channel", "0..*", "0..1"),
        Relationship ("EndDeviceFunction", "EndDeviceFunction", "0..1", "0..*"),
        Relationship ("Usage_Point", "UsagePoint", "0..1", "0..*")
    )
    val isVirtual: Fielder = parse_element (element (cls, fields(0)))
    val leftDigitCount: Fielder = parse_element (element (cls, fields(1)))
    val rightDigitCount: Fielder = parse_element (element (cls, fields(2)))
    val touTier: Fielder = parse_attribute (attribute (cls, fields(3)))
    val touTierName: Fielder = parse_element (element (cls, fields(4)))
    val Channels: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val EndDeviceFunction: Fielder = parse_attribute (attribute (cls, fields(6)))
    val Usage_Point: Fielder = parse_attribute (attribute (cls, fields(7)))

    def parse (context: Context): Register =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Register (
            IdentifiedObject.parse (context),
            toBoolean (mask (isVirtual (), 0)),
            toInteger (mask (leftDigitCount (), 1)),
            toInteger (mask (rightDigitCount (), 2)),
            mask (touTier (), 3),
            mask (touTierName (), 4),
            masks (Channels (), 5),
            mask (EndDeviceFunction (), 6),
            mask (Usage_Point (), 7)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Multiplier applied at the usage point.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param kind Kind of multiplier.
 * @param value Multiplier value.
 * @param UsagePoint [[ch.ninecode.model.UsagePoint UsagePoint]] Usage point applying this multiplier.
 * @group Metering
 * @groupname Metering Package Metering
 * @groupdesc Metering This package contains the core information classes that support end device applications with specialized classes for metering and premises area network devices, and remote reading functions. These classes are generally associated with the point where a service is delivered to the customer.
 */
final case class ServiceMultiplier
(
    override val sup: IdentifiedObject = null,
    kind: String = null,
    value: Double = 0.0,
    UsagePoint: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ServiceMultiplier.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ServiceMultiplier.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ServiceMultiplier.fields (position), value)
        emitattr (0, kind)
        emitelem (1, value)
        emitattr (2, UsagePoint)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ServiceMultiplier rdf:ID=\"%s\">\n%s\t</cim:ServiceMultiplier>".format (id, export_fields)
    }
}

object ServiceMultiplier
extends
    Parseable[ServiceMultiplier]
{
    override val fields: Array[String] = Array[String] (
        "kind",
        "value",
        "UsagePoint"
    )
    override val relations: List[Relationship] = List (
        Relationship ("UsagePoint", "UsagePoint", "0..1", "0..*")
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val value: Fielder = parse_element (element (cls, fields(1)))
    val UsagePoint: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): ServiceMultiplier =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ServiceMultiplier (
            IdentifiedObject.parse (context),
            mask (kind (), 0),
            toDouble (mask (value (), 1)),
            mask (UsagePoint (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Simple end device function distinguished by 'kind'.
 *
 * Use this class for instances that cannot be represented by another end device function specialisations.
 *
 * @param sup [[ch.ninecode.model.EndDeviceFunction EndDeviceFunction]] Reference to the superclass object.
 * @param kind Kind of this function.
 * @group Metering
 * @groupname Metering Package Metering
 * @groupdesc Metering This package contains the core information classes that support end device applications with specialized classes for metering and premises area network devices, and remote reading functions. These classes are generally associated with the point where a service is delivered to the customer.
 */
final case class SimpleEndDeviceFunction
(
    override val sup: EndDeviceFunction = null,
    kind: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def EndDeviceFunction: EndDeviceFunction = sup
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = SimpleEndDeviceFunction.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SimpleEndDeviceFunction.fields (position), value)
        emitattr (0, kind)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SimpleEndDeviceFunction rdf:ID=\"%s\">\n%s\t</cim:SimpleEndDeviceFunction>".format (id, export_fields)
    }
}

object SimpleEndDeviceFunction
extends
    Parseable[SimpleEndDeviceFunction]
{
    override val fields: Array[String] = Array[String] (
        "kind"
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): SimpleEndDeviceFunction =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SimpleEndDeviceFunction (
            EndDeviceFunction.parse (context),
            mask (kind (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Logical or physical point in the network to which readings or events may be attributed.
 *
 * Used at the place where a physical or virtual meter may be located; however, it is not required that a meter be present.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param amiBillingReady Tracks the lifecycle of the metering installation at a usage point with respect to readiness for billing via advanced metering infrastructure reads.
 * @param checkBilling True if as a result of an inspection or otherwise, there is a reason to suspect that a previous billing may have been performed with erroneous data.
 *        Value should be reset once this potential discrepancy has been resolved.
 * @param connectionCategory A code used to specify the connection category, e.g., low voltage, where the usage point is defined.
 * @param connectionState State of the usage point with respect to connection to the network.
 * @param disconnectionMethod Is an indication of how the usage point is physically connected or disconnected.
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
 * @param physicalConnectionCapacity Quantitative information about the maximum physical capacity of the connection for the usage point.
 * @param ratedCurrent Current flow that this usage point is configured to deliver.
 * @param ratedPower Active power that this usage point is configured to deliver.
 * @param readCycle Cycle day on which the meter for this usage point will normally be read.
 *        Usually correlated with the billing cycle.
 * @param readRoute Identifier of the route to which this usage point is assigned for purposes of meter reading.
 *        Typically used to configure hand held meter reading systems prior to collection of reads.
 * @param serviceDeliveryRemark Remarks about this usage point, for example the reason for it being rated with a non-nominal priority.
 * @param servicePriority Priority of service for this usage point.
 *        Note that usage points at the same service location can have different priorities.
 * @param ConfigurationEvents [[ch.ninecode.model.ConfigurationEvent ConfigurationEvent]] All configuration events created for this usage point.
 * @param CustomerAgreement [[ch.ninecode.model.CustomerAgreement CustomerAgreement]] Customer agreement regulating this service delivery point.
 * @param EndDeviceControls [[ch.ninecode.model.EndDeviceControl EndDeviceControl]] All end device controls sending commands to this usage point.
 * @param EndDeviceEvents [[ch.ninecode.model.EndDeviceEvent EndDeviceEvent]] All end device events reported for this usage point.
 * @param EndDevices [[ch.ninecode.model.EndDevice EndDevice]] All end devices at this usage point.
 * @param EnvironmentalMonitoringStation [[ch.ninecode.model.EnvironmentalMonitoringStation EnvironmentalMonitoringStation]] <em>undocumented</em>
 * @param Equipments [[ch.ninecode.model.Equipment Equipment]] All equipment connecting this usage point to the electrical grid.
 * @param MeterReadings [[ch.ninecode.model.MeterReading MeterReading]] All meter readings obtained from this usage point.
 * @param MeterServiceWorkTasks [[ch.ninecode.model.MeterWorkTask MeterWorkTask]] All meter service work tasks at this usage point.
 * @param MetrologyRequirements [[ch.ninecode.model.MetrologyRequirement MetrologyRequirement]] All metrology requirements for this usage point.
 * @param Outage [[ch.ninecode.model.Outage Outage]] All outages at this usage point.
 * @param PricingStructures [[ch.ninecode.model.PricingStructure PricingStructure]] All pricing structures applicable to this service delivery point (with prepayment meter running as a stand-alone device, with no CustomerAgreement or Customer).
 * @param Register [[ch.ninecode.model.Register Register]] <em>undocumented</em>
 * @param ServiceCategory [[ch.ninecode.model.ServiceCategory ServiceCategory]] Service category delivered by this usage point.
 * @param ServiceLocation [[ch.ninecode.model.ServiceLocation ServiceLocation]] Service location where the service delivered by this usage point is consumed.
 * @param ServiceMultipliers [[ch.ninecode.model.ServiceMultiplier ServiceMultiplier]] All multipliers applied at this usage point.
 * @param ServiceSupplier [[ch.ninecode.model.ServiceSupplier ServiceSupplier]] ServiceSupplier (utility) utilising this usage point to deliver a service.
 * @param UsagePointGroups [[ch.ninecode.model.UsagePointGroup UsagePointGroup]] All groups to which this usage point belongs.
 * @param UsagePointLocation [[ch.ninecode.model.UsagePointLocation UsagePointLocation]] Location of this usage point.
 * @group Metering
 * @groupname Metering Package Metering
 * @groupdesc Metering This package contains the core information classes that support end device applications with specialized classes for metering and premises area network devices, and remote reading functions. These classes are generally associated with the point where a service is delivered to the customer.
 */
final case class UsagePoint
(
    override val sup: IdentifiedObject = null,
    amiBillingReady: String = null,
    checkBilling: Boolean = false,
    connectionCategory: String = null,
    connectionState: String = null,
    disconnectionMethod: String = null,
    estimatedLoad: Double = 0.0,
    grounded: Boolean = false,
    isSdp: Boolean = false,
    isVirtual: Boolean = false,
    minimalUsageExpected: Boolean = false,
    nominalServiceVoltage: Double = 0.0,
    outageRegion: String = null,
    phaseCode: String = null,
    physicalConnectionCapacity: Double = 0.0,
    ratedCurrent: Double = 0.0,
    ratedPower: Double = 0.0,
    readCycle: String = null,
    readRoute: String = null,
    serviceDeliveryRemark: String = null,
    servicePriority: String = null,
    ConfigurationEvents: List[String] = null,
    CustomerAgreement: String = null,
    EndDeviceControls: List[String] = null,
    EndDeviceEvents: List[String] = null,
    EndDevices: List[String] = null,
    EnvironmentalMonitoringStation: String = null,
    Equipments: List[String] = null,
    MeterReadings: List[String] = null,
    MeterServiceWorkTasks: List[String] = null,
    MetrologyRequirements: List[String] = null,
    Outage: List[String] = null,
    PricingStructures: List[String] = null,
    Register: List[String] = null,
    ServiceCategory: String = null,
    ServiceLocation: String = null,
    ServiceMultipliers: List[String] = null,
    ServiceSupplier: String = null,
    UsagePointGroups: List[String] = null,
    UsagePointLocation: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = UsagePoint.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (UsagePoint.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (UsagePoint.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (UsagePoint.fields (position), x))
        emitattr (0, amiBillingReady)
        emitelem (1, checkBilling)
        emitelem (2, connectionCategory)
        emitattr (3, connectionState)
        emitelem (4, disconnectionMethod)
        emitelem (5, estimatedLoad)
        emitelem (6, grounded)
        emitelem (7, isSdp)
        emitelem (8, isVirtual)
        emitelem (9, minimalUsageExpected)
        emitelem (10, nominalServiceVoltage)
        emitelem (11, outageRegion)
        emitattr (12, phaseCode)
        emitelem (13, physicalConnectionCapacity)
        emitelem (14, ratedCurrent)
        emitelem (15, ratedPower)
        emitelem (16, readCycle)
        emitelem (17, readRoute)
        emitelem (18, serviceDeliveryRemark)
        emitelem (19, servicePriority)
        emitattrs (20, ConfigurationEvents)
        emitattr (21, CustomerAgreement)
        emitattrs (22, EndDeviceControls)
        emitattrs (23, EndDeviceEvents)
        emitattrs (24, EndDevices)
        emitattr (25, EnvironmentalMonitoringStation)
        emitattrs (26, Equipments)
        emitattrs (27, MeterReadings)
        emitattrs (28, MeterServiceWorkTasks)
        emitattrs (29, MetrologyRequirements)
        emitattrs (30, Outage)
        emitattrs (31, PricingStructures)
        emitattrs (32, Register)
        emitattr (33, ServiceCategory)
        emitattr (34, ServiceLocation)
        emitattrs (35, ServiceMultipliers)
        emitattr (36, ServiceSupplier)
        emitattrs (37, UsagePointGroups)
        emitattr (38, UsagePointLocation)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:UsagePoint rdf:ID=\"%s\">\n%s\t</cim:UsagePoint>".format (id, export_fields)
    }
}

object UsagePoint
extends
    Parseable[UsagePoint]
{
    override val fields: Array[String] = Array[String] (
        "amiBillingReady",
        "checkBilling",
        "connectionCategory",
        "connectionState",
        "disconnectionMethod",
        "estimatedLoad",
        "grounded",
        "isSdp",
        "isVirtual",
        "minimalUsageExpected",
        "nominalServiceVoltage",
        "outageRegion",
        "phaseCode",
        "physicalConnectionCapacity",
        "ratedCurrent",
        "ratedPower",
        "readCycle",
        "readRoute",
        "serviceDeliveryRemark",
        "servicePriority",
        "ConfigurationEvents",
        "CustomerAgreement",
        "EndDeviceControls",
        "EndDeviceEvents",
        "EndDevices",
        "EnvironmentalMonitoringStation",
        "Equipments",
        "MeterReadings",
        "MeterServiceWorkTasks",
        "MetrologyRequirements",
        "Outage",
        "PricingStructures",
        "Register",
        "ServiceCategory",
        "ServiceLocation",
        "ServiceMultipliers",
        "ServiceSupplier",
        "UsagePointGroups",
        "UsagePointLocation"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ConfigurationEvents", "ConfigurationEvent", "0..*", "0..1"),
        Relationship ("CustomerAgreement", "CustomerAgreement", "0..1", "0..*"),
        Relationship ("EndDeviceControls", "EndDeviceControl", "0..*", "0..*"),
        Relationship ("EndDeviceEvents", "EndDeviceEvent", "0..*", "0..1"),
        Relationship ("EndDevices", "EndDevice", "0..*", "0..1"),
        Relationship ("EnvironmentalMonitoringStation", "EnvironmentalMonitoringStation", "0..1", "0..*"),
        Relationship ("Equipments", "Equipment", "0..*", "0..*"),
        Relationship ("MeterReadings", "MeterReading", "0..*", "0..1"),
        Relationship ("MeterServiceWorkTasks", "MeterWorkTask", "0..*", "0..1"),
        Relationship ("MetrologyRequirements", "MetrologyRequirement", "0..*", "0..*"),
        Relationship ("Outage", "Outage", "0..*", "0..*"),
        Relationship ("PricingStructures", "PricingStructure", "0..*", "0..*"),
        Relationship ("Register", "Register", "0..*", "0..1"),
        Relationship ("ServiceCategory", "ServiceCategory", "0..1", "0..*"),
        Relationship ("ServiceLocation", "ServiceLocation", "0..1", "0..*"),
        Relationship ("ServiceMultipliers", "ServiceMultiplier", "0..*", "0..1"),
        Relationship ("ServiceSupplier", "ServiceSupplier", "0..1", "0..*"),
        Relationship ("UsagePointGroups", "UsagePointGroup", "0..*", "0..*"),
        Relationship ("UsagePointLocation", "UsagePointLocation", "0..1", "0..*")
    )
    val amiBillingReady: Fielder = parse_attribute (attribute (cls, fields(0)))
    val checkBilling: Fielder = parse_element (element (cls, fields(1)))
    val connectionCategory: Fielder = parse_element (element (cls, fields(2)))
    val connectionState: Fielder = parse_attribute (attribute (cls, fields(3)))
    val disconnectionMethod: Fielder = parse_element (element (cls, fields(4)))
    val estimatedLoad: Fielder = parse_element (element (cls, fields(5)))
    val grounded: Fielder = parse_element (element (cls, fields(6)))
    val isSdp: Fielder = parse_element (element (cls, fields(7)))
    val isVirtual: Fielder = parse_element (element (cls, fields(8)))
    val minimalUsageExpected: Fielder = parse_element (element (cls, fields(9)))
    val nominalServiceVoltage: Fielder = parse_element (element (cls, fields(10)))
    val outageRegion: Fielder = parse_element (element (cls, fields(11)))
    val phaseCode: Fielder = parse_attribute (attribute (cls, fields(12)))
    val physicalConnectionCapacity: Fielder = parse_element (element (cls, fields(13)))
    val ratedCurrent: Fielder = parse_element (element (cls, fields(14)))
    val ratedPower: Fielder = parse_element (element (cls, fields(15)))
    val readCycle: Fielder = parse_element (element (cls, fields(16)))
    val readRoute: Fielder = parse_element (element (cls, fields(17)))
    val serviceDeliveryRemark: Fielder = parse_element (element (cls, fields(18)))
    val servicePriority: Fielder = parse_element (element (cls, fields(19)))
    val ConfigurationEvents: FielderMultiple = parse_attributes (attribute (cls, fields(20)))
    val CustomerAgreement: Fielder = parse_attribute (attribute (cls, fields(21)))
    val EndDeviceControls: FielderMultiple = parse_attributes (attribute (cls, fields(22)))
    val EndDeviceEvents: FielderMultiple = parse_attributes (attribute (cls, fields(23)))
    val EndDevices: FielderMultiple = parse_attributes (attribute (cls, fields(24)))
    val EnvironmentalMonitoringStation: Fielder = parse_attribute (attribute (cls, fields(25)))
    val Equipments: FielderMultiple = parse_attributes (attribute (cls, fields(26)))
    val MeterReadings: FielderMultiple = parse_attributes (attribute (cls, fields(27)))
    val MeterServiceWorkTasks: FielderMultiple = parse_attributes (attribute (cls, fields(28)))
    val MetrologyRequirements: FielderMultiple = parse_attributes (attribute (cls, fields(29)))
    val Outage: FielderMultiple = parse_attributes (attribute (cls, fields(30)))
    val PricingStructures: FielderMultiple = parse_attributes (attribute (cls, fields(31)))
    val Register: FielderMultiple = parse_attributes (attribute (cls, fields(32)))
    val ServiceCategory: Fielder = parse_attribute (attribute (cls, fields(33)))
    val ServiceLocation: Fielder = parse_attribute (attribute (cls, fields(34)))
    val ServiceMultipliers: FielderMultiple = parse_attributes (attribute (cls, fields(35)))
    val ServiceSupplier: Fielder = parse_attribute (attribute (cls, fields(36)))
    val UsagePointGroups: FielderMultiple = parse_attributes (attribute (cls, fields(37)))
    val UsagePointLocation: Fielder = parse_attribute (attribute (cls, fields(38)))

    def parse (context: Context): UsagePoint =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0,0)
        val ret = UsagePoint (
            IdentifiedObject.parse (context),
            mask (amiBillingReady (), 0),
            toBoolean (mask (checkBilling (), 1)),
            mask (connectionCategory (), 2),
            mask (connectionState (), 3),
            mask (disconnectionMethod (), 4),
            toDouble (mask (estimatedLoad (), 5)),
            toBoolean (mask (grounded (), 6)),
            toBoolean (mask (isSdp (), 7)),
            toBoolean (mask (isVirtual (), 8)),
            toBoolean (mask (minimalUsageExpected (), 9)),
            toDouble (mask (nominalServiceVoltage (), 10)),
            mask (outageRegion (), 11),
            mask (phaseCode (), 12),
            toDouble (mask (physicalConnectionCapacity (), 13)),
            toDouble (mask (ratedCurrent (), 14)),
            toDouble (mask (ratedPower (), 15)),
            mask (readCycle (), 16),
            mask (readRoute (), 17),
            mask (serviceDeliveryRemark (), 18),
            mask (servicePriority (), 19),
            masks (ConfigurationEvents (), 20),
            mask (CustomerAgreement (), 21),
            masks (EndDeviceControls (), 22),
            masks (EndDeviceEvents (), 23),
            masks (EndDevices (), 24),
            mask (EnvironmentalMonitoringStation (), 25),
            masks (Equipments (), 26),
            masks (MeterReadings (), 27),
            masks (MeterServiceWorkTasks (), 28),
            masks (MetrologyRequirements (), 29),
            masks (Outage (), 30),
            masks (PricingStructures (), 31),
            masks (Register (), 32),
            mask (ServiceCategory (), 33),
            mask (ServiceLocation (), 34),
            masks (ServiceMultipliers (), 35),
            mask (ServiceSupplier (), 36),
            masks (UsagePointGroups (), 37),
            mask (UsagePointLocation (), 38)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Abstraction for management of group communications within a two-way AMR system or the data for a group of related usage points.
 *
 * Commands can be issued to all of the usage points that belong to a usage point group using a defined group address and the underlying AMR communication infrastructure.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param type Type of this group.
 * @param DemandResponsePrograms [[ch.ninecode.model.DemandResponseProgram DemandResponseProgram]] All demand response programs this usage point group is enrolled in.
 * @param EndDeviceControls [[ch.ninecode.model.EndDeviceControl EndDeviceControl]] All end device controls sending commands to this usage point group.
 * @param UsagePoints [[ch.ninecode.model.UsagePoint UsagePoint]] All usage points in this group.
 * @group Metering
 * @groupname Metering Package Metering
 * @groupdesc Metering This package contains the core information classes that support end device applications with specialized classes for metering and premises area network devices, and remote reading functions. These classes are generally associated with the point where a service is delivered to the customer.
 */
final case class UsagePointGroup
(
    override val sup: IdentifiedObject = null,
    `type`: String = null,
    DemandResponsePrograms: List[String] = null,
    EndDeviceControls: List[String] = null,
    UsagePoints: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = UsagePointGroup.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (UsagePointGroup.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (UsagePointGroup.fields (position), x))
        emitelem (0, `type`)
        emitattrs (1, DemandResponsePrograms)
        emitattrs (2, EndDeviceControls)
        emitattrs (3, UsagePoints)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:UsagePointGroup rdf:ID=\"%s\">\n%s\t</cim:UsagePointGroup>".format (id, export_fields)
    }
}

object UsagePointGroup
extends
    Parseable[UsagePointGroup]
{
    override val fields: Array[String] = Array[String] (
        "type",
        "DemandResponsePrograms",
        "EndDeviceControls",
        "UsagePoints"
    )
    override val relations: List[Relationship] = List (
        Relationship ("DemandResponsePrograms", "DemandResponseProgram", "0..*", "0..*"),
        Relationship ("EndDeviceControls", "EndDeviceControl", "0..*", "0..*"),
        Relationship ("UsagePoints", "UsagePoint", "0..*", "0..*")
    )
    val `type`: Fielder = parse_element (element (cls, fields(0)))
    val DemandResponsePrograms: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val EndDeviceControls: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val UsagePoints: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: Context): UsagePointGroup =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = UsagePointGroup (
            IdentifiedObject.parse (context),
            mask (`type` (), 0),
            masks (DemandResponsePrograms (), 1),
            masks (EndDeviceControls (), 2),
            masks (UsagePoints (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Location of an individual usage point.
 *
 * @param sup [[ch.ninecode.model.Location Location]] Reference to the superclass object.
 * @param accessMethod Method for the service person to access this usage point location.
 *        For example, a description of where to obtain a key if the facility is unmanned and secured.
 * @param remark Remarks about this location.
 * @param siteAccessProblem Problems previously encountered when visiting or performing work at this location.
 *        Examples include: bad dog, violent customer, verbally abusive occupant, obstructions, safety hazards, etc.
 * @param UsagePoints [[ch.ninecode.model.UsagePoint UsagePoint]] All usage points at this location.
 * @group Metering
 * @groupname Metering Package Metering
 * @groupdesc Metering This package contains the core information classes that support end device applications with specialized classes for metering and premises area network devices, and remote reading functions. These classes are generally associated with the point where a service is delivered to the customer.
 */
final case class UsagePointLocation
(
    override val sup: Location = null,
    accessMethod: String = null,
    remark: String = null,
    siteAccessProblem: String = null,
    UsagePoints: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Location: Location = sup
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = UsagePointLocation.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (UsagePointLocation.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (UsagePointLocation.fields (position), x))
        emitelem (0, accessMethod)
        emitelem (1, remark)
        emitelem (2, siteAccessProblem)
        emitattrs (3, UsagePoints)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:UsagePointLocation rdf:ID=\"%s\">\n%s\t</cim:UsagePointLocation>".format (id, export_fields)
    }
}

object UsagePointLocation
extends
    Parseable[UsagePointLocation]
{
    override val fields: Array[String] = Array[String] (
        "accessMethod",
        "remark",
        "siteAccessProblem",
        "UsagePoints"
    )
    override val relations: List[Relationship] = List (
        Relationship ("UsagePoints", "UsagePoint", "0..*", "0..1")
    )
    val accessMethod: Fielder = parse_element (element (cls, fields(0)))
    val remark: Fielder = parse_element (element (cls, fields(1)))
    val siteAccessProblem: Fielder = parse_element (element (cls, fields(2)))
    val UsagePoints: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: Context): UsagePointLocation =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = UsagePointLocation (
            Location.parse (context),
            mask (accessMethod (), 0),
            mask (remark (), 1),
            mask (siteAccessProblem (), 2),
            masks (UsagePoints (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _Metering
{
    def register: List[ClassInfo] =
    {
        List (
            BaseReading.register,
            Channel.register,
            ComFunction.register,
            ComModule.register,
            ControlledAppliance.register,
            DemandResponseProgram.register,
            EndDevice.register,
            EndDeviceAction.register,
            EndDeviceCapability.register,
            EndDeviceControl.register,
            EndDeviceControlType.register,
            EndDeviceEvent.register,
            EndDeviceEventDetail.register,
            EndDeviceEventType.register,
            EndDeviceFunction.register,
            EndDeviceGroup.register,
            EndDeviceInfo.register,
            EndDeviceTiming.register,
            IntervalBlock.register,
            IntervalReading.register,
            Meter.register,
            MeterMultiplier.register,
            MeterReading.register,
            MeterWorkTask.register,
            MetrologyRequirement.register,
            PanDemandResponse.register,
            PanDisplay.register,
            PanPricing.register,
            PanPricingDetail.register,
            PendingCalculation.register,
            RationalNumber.register,
            Reading.register,
            ReadingInterharmonic.register,
            ReadingQuality.register,
            ReadingQualityType.register,
            ReadingType.register,
            Register.register,
            ServiceMultiplier.register,
            SimpleEndDeviceFunction.register,
            UsagePoint.register,
            UsagePointGroup.register,
            UsagePointLocation.register
        )
    }
}