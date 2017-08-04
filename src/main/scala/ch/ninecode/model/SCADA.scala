package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

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
    override val sup: PowerSystemResource
)
extends
    Element
{
    def this () = { this (null) }
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { clone ().asInstanceOf[CommunicationLink] }
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
        "\t<cim:CommunicationLink rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CommunicationLink>\n"
    }
}

object CommunicationLink
extends
    Parseable[CommunicationLink]
{
    def parse (context: Context): CommunicationLink =
    {
        CommunicationLink(
            PowerSystemResource.parse (context)
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
    override val sup: RemotePoint,
    actuatorMaximum: Double,
    actuatorMinimum: Double,
    remoteControlled: Boolean,
    Control: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, false, null) }
    def RemotePoint: RemotePoint = sup.asInstanceOf[RemotePoint]
    override def copy (): Row = { clone ().asInstanceOf[RemoteControl] }
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
        "\t\t<cim:RemoteControl.actuatorMaximum>" + actuatorMaximum + "</cim:RemoteControl.actuatorMaximum>\n" +
        "\t\t<cim:RemoteControl.actuatorMinimum>" + actuatorMinimum + "</cim:RemoteControl.actuatorMinimum>\n" +
        "\t\t<cim:RemoteControl.remoteControlled>" + remoteControlled + "</cim:RemoteControl.remoteControlled>\n" +
        (if (null != Control) "\t\t<cim:RemoteControl.Control rdf:resource=\"#" + Control + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:RemoteControl rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RemoteControl>\n"
    }
}

object RemoteControl
extends
    Parseable[RemoteControl]
{
    val actuatorMaximum: (Context) => String = parse_element (element ("""RemoteControl.actuatorMaximum"""))
    val actuatorMinimum: (Context) => String = parse_element (element ("""RemoteControl.actuatorMinimum"""))
    val remoteControlled: (Context) => String = parse_element (element ("""RemoteControl.remoteControlled"""))
    val Control: (Context) => String = parse_attribute (attribute ("""RemoteControl.Control"""))
    def parse (context: Context): RemoteControl =
    {
        RemoteControl(
            RemotePoint.parse (context),
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
    override val sup: IdentifiedObject,
    RemoteUnit: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[RemotePoint] }
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
        (if (null != RemoteUnit) "\t\t<cim:RemotePoint.RemoteUnit rdf:resource=\"#" + RemoteUnit + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:RemotePoint rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RemotePoint>\n"
    }
}

object RemotePoint
extends
    Parseable[RemotePoint]
{
    val RemoteUnit: (Context) => String = parse_attribute (attribute ("""RemotePoint.RemoteUnit"""))
    def parse (context: Context): RemotePoint =
    {
        RemotePoint(
            IdentifiedObject.parse (context),
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
    override val sup: RemotePoint,
    deadband: Double,
    scanInterval: Double,
    sensorMaximum: Double,
    sensorMinimum: Double,
    MeasurementValue: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, null) }
    def RemotePoint: RemotePoint = sup.asInstanceOf[RemotePoint]
    override def copy (): Row = { clone ().asInstanceOf[RemoteSource] }
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
        "\t\t<cim:RemoteSource.deadband>" + deadband + "</cim:RemoteSource.deadband>\n" +
        "\t\t<cim:RemoteSource.scanInterval>" + scanInterval + "</cim:RemoteSource.scanInterval>\n" +
        "\t\t<cim:RemoteSource.sensorMaximum>" + sensorMaximum + "</cim:RemoteSource.sensorMaximum>\n" +
        "\t\t<cim:RemoteSource.sensorMinimum>" + sensorMinimum + "</cim:RemoteSource.sensorMinimum>\n" +
        (if (null != MeasurementValue) "\t\t<cim:RemoteSource.MeasurementValue rdf:resource=\"#" + MeasurementValue + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:RemoteSource rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RemoteSource>\n"
    }
}

object RemoteSource
extends
    Parseable[RemoteSource]
{
    val deadband: (Context) => String = parse_element (element ("""RemoteSource.deadband"""))
    val scanInterval: (Context) => String = parse_element (element ("""RemoteSource.scanInterval"""))
    val sensorMaximum: (Context) => String = parse_element (element ("""RemoteSource.sensorMaximum"""))
    val sensorMinimum: (Context) => String = parse_element (element ("""RemoteSource.sensorMinimum"""))
    val MeasurementValue: (Context) => String = parse_attribute (attribute ("""RemoteSource.MeasurementValue"""))
    def parse (context: Context): RemoteSource =
    {
        RemoteSource(
            RemotePoint.parse (context),
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
    override val sup: PowerSystemResource,
    remoteUnitType: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { clone ().asInstanceOf[RemoteUnit] }
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
        (if (null != remoteUnitType) "\t\t<cim:RemoteUnit.remoteUnitType rdf:resource=\"#" + remoteUnitType + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:RemoteUnit rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RemoteUnit>\n"
    }
}

object RemoteUnit
extends
    Parseable[RemoteUnit]
{
    val remoteUnitType: (Context) => String = parse_attribute (attribute ("""RemoteUnit.remoteUnitType"""))
    def parse (context: Context): RemoteUnit =
    {
        RemoteUnit(
            PowerSystemResource.parse (context),
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
    override val sup: BasicElement,
    ControlCenter: String,
    IED: String,
    RTU: String,
    SubstationControlSystem: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[RemoteUnitType] }
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
        (if (null != ControlCenter) "\t\t<cim:RemoteUnitType.ControlCenter rdf:resource=\"#" + ControlCenter + "\"/>\n" else "") +
        (if (null != IED) "\t\t<cim:RemoteUnitType.IED rdf:resource=\"#" + IED + "\"/>\n" else "") +
        (if (null != RTU) "\t\t<cim:RemoteUnitType.RTU rdf:resource=\"#" + RTU + "\"/>\n" else "") +
        (if (null != SubstationControlSystem) "\t\t<cim:RemoteUnitType.SubstationControlSystem rdf:resource=\"#" + SubstationControlSystem + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:RemoteUnitType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RemoteUnitType>\n"
    }
}

object RemoteUnitType
extends
    Parseable[RemoteUnitType]
{
    val ControlCenter: (Context) => String = parse_attribute (attribute ("""RemoteUnitType.ControlCenter"""))
    val IED: (Context) => String = parse_attribute (attribute ("""RemoteUnitType.IED"""))
    val RTU: (Context) => String = parse_attribute (attribute ("""RemoteUnitType.RTU"""))
    val SubstationControlSystem: (Context) => String = parse_attribute (attribute ("""RemoteUnitType.SubstationControlSystem"""))
    def parse (context: Context): RemoteUnitType =
    {
        RemoteUnitType(
            BasicElement.parse (context),
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
    override val sup: BasicElement,
    DEFAULTED: String,
    PROCESS: String,
    SUBSTITUTED: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[Source] }
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
        (if (null != DEFAULTED) "\t\t<cim:Source.DEFAULTED rdf:resource=\"#" + DEFAULTED + "\"/>\n" else "") +
        (if (null != PROCESS) "\t\t<cim:Source.PROCESS rdf:resource=\"#" + PROCESS + "\"/>\n" else "") +
        (if (null != SUBSTITUTED) "\t\t<cim:Source.SUBSTITUTED rdf:resource=\"#" + SUBSTITUTED + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Source rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Source>\n"
    }
}

object Source
extends
    Parseable[Source]
{
    val DEFAULTED: (Context) => String = parse_attribute (attribute ("""Source.DEFAULTED"""))
    val PROCESS: (Context) => String = parse_attribute (attribute ("""Source.PROCESS"""))
    val SUBSTITUTED: (Context) => String = parse_attribute (attribute ("""Source.SUBSTITUTED"""))
    def parse (context: Context): Source =
    {
        Source(
            BasicElement.parse (context),
            DEFAULTED (context),
            PROCESS (context),
            SUBSTITUTED (context)
        )
    }
}

private[ninecode] object _SCADA
{
    def register: List[ClassInfo] =
    {
        List (
            CommunicationLink.register,
            RemoteControl.register,
            RemotePoint.register,
            RemoteSource.register,
            RemoteUnit.register,
            RemoteUnitType.register,
            Source.register
        )
    }
}