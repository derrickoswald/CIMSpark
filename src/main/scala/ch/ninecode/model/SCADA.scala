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
 * @param sup Reference to the superclass object.
 */
case class CommunicationLink
(
    override val sup: Element
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
 * @param sup Reference to the superclass object.
 * @param actuatorMaximum The maximum set point value accepted by the remote control point.
 * @param actuatorMinimum The minimum set point value accepted by the remote control point.
 * @param remoteControlled Set to true if the actuator is remotely controlled.
 * @param Control The Control for the RemoteControl point.
 */
case class RemoteControl
(
    override val sup: Element,
    val actuatorMaximum: Double,
    val actuatorMinimum: Double,
    val remoteControlled: Boolean,
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
    val actuatorMaximum = parse_element (element ("""RemoteControl.actuatorMaximum"""))
    val actuatorMinimum = parse_element (element ("""RemoteControl.actuatorMinimum"""))
    val remoteControlled = parse_element (element ("""RemoteControl.remoteControlled"""))
    val Control = parse_attribute (attribute ("""RemoteControl.Control"""))
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
 * @param sup Reference to the superclass object.
 * @param RemoteUnit Remote unit this point belongs to.
 */
case class RemotePoint
(
    override val sup: Element,
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
    val RemoteUnit = parse_attribute (attribute ("""RemotePoint.RemoteUnit"""))
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
 * @param sup Reference to the superclass object.
 * @param deadband The smallest change in value to be reported.
 * @param scanInterval The time interval between scans.
 * @param sensorMaximum The maximum value the telemetry item can return.
 * @param sensorMinimum The minimum value the telemetry item can return.
 * @param MeasurementValue Link to the physical telemetered point associated with this measurement.
 */
case class RemoteSource
(
    override val sup: Element,
    val deadband: Double,
    val scanInterval: Double,
    val sensorMaximum: Double,
    val sensorMinimum: Double,
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
    val deadband = parse_element (element ("""RemoteSource.deadband"""))
    val scanInterval = parse_element (element ("""RemoteSource.scanInterval"""))
    val sensorMaximum = parse_element (element ("""RemoteSource.sensorMaximum"""))
    val sensorMinimum = parse_element (element ("""RemoteSource.sensorMinimum"""))
    val MeasurementValue = parse_attribute (attribute ("""RemoteSource.MeasurementValue"""))
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
 * @param sup Reference to the superclass object.
 * @param remoteUnitType Type of remote unit.
 */
case class RemoteUnit
(
    override val sup: Element,
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
    val remoteUnitType = parse_attribute (attribute ("""RemoteUnit.remoteUnitType"""))
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
 * @param sup Reference to the superclass object.
 * @param ControlCenter Control center.
 * @param IED Intelligent electronic device (IED).
 * @param RTU Remote terminal unit.
 * @param SubstationControlSystem Substation control system.
 */
case class RemoteUnitType
(
    override val sup: Element,
    val ControlCenter: String,
    val IED: String,
    val RTU: String,
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
    val ControlCenter = parse_attribute (attribute ("""RemoteUnitType.ControlCenter"""))
    val IED = parse_attribute (attribute ("""RemoteUnitType.IED"""))
    val RTU = parse_attribute (attribute ("""RemoteUnitType.RTU"""))
    val SubstationControlSystem = parse_attribute (attribute ("""RemoteUnitType.SubstationControlSystem"""))
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
 * @param sup Reference to the superclass object.
 * @param DEFAULTED The value contains a default value.
 * @param PROCESS The value is provided by input from the process I/O or being calculated from some function.
 * @param SUBSTITUTED The value is provided by input of an operator or by an automatic source.
 */
case class Source
(
    override val sup: Element,
    val DEFAULTED: String,
    val PROCESS: String,
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
    val DEFAULTED = parse_attribute (attribute ("""Source.DEFAULTED"""))
    val PROCESS = parse_attribute (attribute ("""Source.PROCESS"""))
    val SUBSTITUTED = parse_attribute (attribute ("""Source.SUBSTITUTED"""))
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