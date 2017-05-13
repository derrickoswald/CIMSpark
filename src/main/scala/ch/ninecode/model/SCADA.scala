package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * Contains entities to model information used by Supervisory Control and Data Acquisition (SCADA) applications.
 * Supervisory control supports operator control of equipment, such as opening or closing a breaker. Data acquisition gathers telemetered data from various sources.  The subtypes of the Telemetry entity deliberately match the UCA and IEC 61850 definitions.
 */

/**
 * The connection to remote units is through one or more communication links.
 * Reduntant links may exist. The CommunicationLink class inherit PowerSystemResource. The intention is to allow CommunicationLinks to have Measurements. These Measurements can be used to model link status as operational, out of service, unit failure etc.
 */
case class CommunicationLink
(

    override val sup: PowerSystemResource
)
extends
    Element
{
    def this () = { this (null) }
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { return (clone ().asInstanceOf[CommunicationLink]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CommunicationLink
extends
    Parseable[CommunicationLink]
{
    val sup = PowerSystemResource.parse _
    def parse (context: Context): CommunicationLink =
    {
        CommunicationLink(
            sup (context)
        )
    }
}

/**
 * Remote controls are ouputs that are sent by the remote unit to actuators in the process.
 */
case class RemoteControl
(

    override val sup: RemotePoint,

    /**
     * The maximum set point value accepted by the remote control point.
     */
    val actuatorMaximum: Double,

    /**
     * The minimum set point value accepted by the remote control point.
     */
    val actuatorMinimum: Double,

    /**
     * Set to true if the actuator is remotely controlled.
     */
    val remoteControlled: Boolean,

    /**
     * The Control for the RemoteControl point.
     */
    val Control: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, false, null) }
    def RemotePoint: RemotePoint = sup.asInstanceOf[RemotePoint]
    override def copy (): Row = { return (clone ().asInstanceOf[RemoteControl]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RemoteControl
extends
    Parseable[RemoteControl]
{
    val sup = RemotePoint.parse _
    val actuatorMaximum = parse_element (element ("""RemoteControl.actuatorMaximum"""))_
    val actuatorMinimum = parse_element (element ("""RemoteControl.actuatorMinimum"""))_
    val remoteControlled = parse_element (element ("""RemoteControl.remoteControlled"""))_
    val Control = parse_attribute (attribute ("""RemoteControl.Control"""))_
    def parse (context: Context): RemoteControl =
    {
        RemoteControl(
            sup (context),
            toDouble (actuatorMaximum (context), context),
            toDouble (actuatorMinimum (context), context),
            toBoolean (remoteControlled (context), context),
            Control (context)
        )
    }
}

/**
 * For a RTU remote points correspond to telemetered values or control outputs.
 * Other units (e.g. control centers) usually also contain calculated values.
 */
case class RemotePoint
(

    override val sup: IdentifiedObject,

    /**
     * Remote unit this point belongs to.
     */
    val RemoteUnit: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[RemotePoint]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RemotePoint
extends
    Parseable[RemotePoint]
{
    val sup = IdentifiedObject.parse _
    val RemoteUnit = parse_attribute (attribute ("""RemotePoint.RemoteUnit"""))_
    def parse (context: Context): RemotePoint =
    {
        RemotePoint(
            sup (context),
            RemoteUnit (context)
        )
    }
}

/**
 * Remote sources are state variables that are telemetered or calculated within the remote unit.
 */
case class RemoteSource
(

    override val sup: RemotePoint,

    /**
     * The smallest change in value to be reported.
     */
    val deadband: Double,

    /**
     * The time interval between scans.
     */
    val scanInterval: Double,

    /**
     * The maximum value the telemetry item can return.
     */
    val sensorMaximum: Double,

    /**
     * The minimum value the telemetry item can return.
     */
    val sensorMinimum: Double,

    /**
     * Link to the physical telemetered point associated with this measurement.
     */
    val MeasurementValue: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, null) }
    def RemotePoint: RemotePoint = sup.asInstanceOf[RemotePoint]
    override def copy (): Row = { return (clone ().asInstanceOf[RemoteSource]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RemoteSource
extends
    Parseable[RemoteSource]
{
    val sup = RemotePoint.parse _
    val deadband = parse_element (element ("""RemoteSource.deadband"""))_
    val scanInterval = parse_element (element ("""RemoteSource.scanInterval"""))_
    val sensorMaximum = parse_element (element ("""RemoteSource.sensorMaximum"""))_
    val sensorMinimum = parse_element (element ("""RemoteSource.sensorMinimum"""))_
    val MeasurementValue = parse_attribute (attribute ("""RemoteSource.MeasurementValue"""))_
    def parse (context: Context): RemoteSource =
    {
        RemoteSource(
            sup (context),
            toDouble (deadband (context), context),
            toDouble (scanInterval (context), context),
            toDouble (sensorMaximum (context), context),
            toDouble (sensorMinimum (context), context),
            MeasurementValue (context)
        )
    }
}

/**
 * A remote unit can be a RTU, IED, substation control system, control center etc.
 * The communication with the remote unit can be through various standard protocols (e.g. IEC 61870, IEC 61850) or non standard protocols (e.g. DNP, RP570 etc.). A remote unit contain remote data points that might be telemetered, collected or calculated. The RemoteUnit class inherit PowerSystemResource. The intention is to allow RemotUnits to have Measurements. These Measurements can be used to model unit status as operational, out of service, unit failure etc.
 */
case class RemoteUnit
(

    override val sup: PowerSystemResource,

    /**
     * Type of remote unit.
     */
    val remoteUnitType: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { return (clone ().asInstanceOf[RemoteUnit]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RemoteUnit
extends
    Parseable[RemoteUnit]
{
    val sup = PowerSystemResource.parse _
    val remoteUnitType = parse_attribute (attribute ("""RemoteUnit.remoteUnitType"""))_
    def parse (context: Context): RemoteUnit =
    {
        RemoteUnit(
            sup (context),
            remoteUnitType (context)
        )
    }
}

/**
 * Type of remote unit.
 */
case class RemoteUnitType
(

    override val sup: BasicElement,

    /**
     * Control center.
     */
    val ControlCenter: String,

    /**
     * Intelligent electronic device (IED).
     */
    val IED: String,

    /**
     * Remote terminal unit.
     */
    val RTU: String,

    /**
     * Substation control system.
     */
    val SubstationControlSystem: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[RemoteUnitType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RemoteUnitType
extends
    Parseable[RemoteUnitType]
{
    val sup = BasicElement.parse _
    val ControlCenter = parse_attribute (attribute ("""RemoteUnitType.ControlCenter"""))_
    val IED = parse_attribute (attribute ("""RemoteUnitType.IED"""))_
    val RTU = parse_attribute (attribute ("""RemoteUnitType.RTU"""))_
    val SubstationControlSystem = parse_attribute (attribute ("""RemoteUnitType.SubstationControlSystem"""))_
    def parse (context: Context): RemoteUnitType =
    {
        RemoteUnitType(
            sup (context),
            ControlCenter (context),
            IED (context),
            RTU (context),
            SubstationControlSystem (context)
        )
    }
}

/**
 * Source gives information related to the origin of a value.
 */
case class Source
(

    override val sup: BasicElement,

    /**
     * The value contains a default value.
     */
    val DEFAULTED: String,

    /**
     * The value is provided by input from the process I/O or being calculated from some function.
     */
    val PROCESS: String,

    /**
     * The value is provided by input of an operator or by an automatic source.
     */
    val SUBSTITUTED: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[Source]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Source
extends
    Parseable[Source]
{
    val sup = BasicElement.parse _
    val DEFAULTED = parse_attribute (attribute ("""Source.DEFAULTED"""))_
    val PROCESS = parse_attribute (attribute ("""Source.PROCESS"""))_
    val SUBSTITUTED = parse_attribute (attribute ("""Source.SUBSTITUTED"""))_
    def parse (context: Context): Source =
    {
        Source(
            sup (context),
            DEFAULTED (context),
            PROCESS (context),
            SUBSTITUTED (context)
        )
    }
}

object _SCADA
{
    def register: Unit =
    {
        CommunicationLink.register
        RemoteControl.register
        RemotePoint.register
        RemoteSource.register
        RemoteUnit.register
        RemoteUnitType.register
        Source.register
    }
}