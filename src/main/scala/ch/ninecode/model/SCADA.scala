package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * The connection to remote units is through one or more communication links.
 *
 * Reduntant links may exist. The CommunicationLink class inherit PowerSystemResource. The intention is to allow CommunicationLinks to have Measurements. These Measurements can be used to model link status as operational, out of service, unit failure etc.
 *
 * @param sup [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @group SCADA
 * @groupname SCADA Package SCADA
 * @groupdesc SCADA Contains entities to model information used by Supervisory Control and Data Acquisition (SCADA) applications. Supervisory control supports operator control of equipment, such as opening or closing a breaker. Data acquisition gathers telemetered data from various sources.  The subtypes of the Telemetry entity deliberately match the UCA and IEC 61850 definitions. 
This package also supports alarm presentation but it is not expected to be used by other applications.
 */
case class CommunicationLink
(
    override val sup: PowerSystemResource
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        "\t</cim:CommunicationLink>"
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
 *
 * @param sup [[ch.ninecode.model.RemotePoint RemotePoint]] Reference to the superclass object.
 * @param actuatorMaximum The maximum set point value accepted by the remote control point.
 * @param actuatorMinimum The minimum set point value accepted by the remote control point.
 * @param remoteControlled Set to true if the actuator is remotely controlled.
 * @param Control [[ch.ninecode.model.Control Control]] The Control for the RemoteControl point.
 * @group SCADA
 * @groupname SCADA Package SCADA
 * @groupdesc SCADA Contains entities to model information used by Supervisory Control and Data Acquisition (SCADA) applications. Supervisory control supports operator control of equipment, such as opening or closing a breaker. Data acquisition gathers telemetered data from various sources.  The subtypes of the Telemetry entity deliberately match the UCA and IEC 61850 definitions. 
This package also supports alarm presentation but it is not expected to be used by other applications.
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
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, false, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        "\t</cim:RemoteControl>"
    }
}

object RemoteControl
extends
    Parseable[RemoteControl]
{
    val actuatorMaximum = parse_element (element ("""RemoteControl.actuatorMaximum"""))
    val actuatorMinimum = parse_element (element ("""RemoteControl.actuatorMinimum"""))
    val remoteControlled = parse_element (element ("""RemoteControl.remoteControlled"""))
    val Control = parse_attribute (attribute ("""RemoteControl.Control"""))
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
 *
 * Other units (e.g. control centers) usually also contain calculated values.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param RemoteUnit [[ch.ninecode.model.RemoteUnit RemoteUnit]] Remote unit this point belongs to.
 * @group SCADA
 * @groupname SCADA Package SCADA
 * @groupdesc SCADA Contains entities to model information used by Supervisory Control and Data Acquisition (SCADA) applications. Supervisory control supports operator control of equipment, such as opening or closing a breaker. Data acquisition gathers telemetered data from various sources.  The subtypes of the Telemetry entity deliberately match the UCA and IEC 61850 definitions. 
This package also supports alarm presentation but it is not expected to be used by other applications.
 */
case class RemotePoint
(
    override val sup: IdentifiedObject,
    RemoteUnit: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        "\t</cim:RemotePoint>"
    }
}

object RemotePoint
extends
    Parseable[RemotePoint]
{
    val RemoteUnit = parse_attribute (attribute ("""RemotePoint.RemoteUnit"""))
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
 *
 * @param sup [[ch.ninecode.model.RemotePoint RemotePoint]] Reference to the superclass object.
 * @param deadband The smallest change in value to be reported.
 * @param scanInterval The time interval between scans.
 * @param sensorMaximum The maximum value the telemetry item can return.
 * @param sensorMinimum The minimum value the telemetry item can return.
 * @param MeasurementValue [[ch.ninecode.model.MeasurementValue MeasurementValue]] Link to the physical telemetered point associated with this measurement.
 * @group SCADA
 * @groupname SCADA Package SCADA
 * @groupdesc SCADA Contains entities to model information used by Supervisory Control and Data Acquisition (SCADA) applications. Supervisory control supports operator control of equipment, such as opening or closing a breaker. Data acquisition gathers telemetered data from various sources.  The subtypes of the Telemetry entity deliberately match the UCA and IEC 61850 definitions. 
This package also supports alarm presentation but it is not expected to be used by other applications.
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
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        "\t</cim:RemoteSource>"
    }
}

object RemoteSource
extends
    Parseable[RemoteSource]
{
    val deadband = parse_element (element ("""RemoteSource.deadband"""))
    val scanInterval = parse_element (element ("""RemoteSource.scanInterval"""))
    val sensorMaximum = parse_element (element ("""RemoteSource.sensorMaximum"""))
    val sensorMinimum = parse_element (element ("""RemoteSource.sensorMinimum"""))
    val MeasurementValue = parse_attribute (attribute ("""RemoteSource.MeasurementValue"""))
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
 *
 * The communication with the remote unit can be through various standard protocols (e.g. IEC 61870, IEC 61850) or non standard protocols (e.g. DNP, RP570 etc.). A remote unit contain remote data points that might be telemetered, collected or calculated. The RemoteUnit class inherit PowerSystemResource. The intention is to allow RemotUnits to have Measurements. These Measurements can be used to model unit status as operational, out of service, unit failure etc.
 *
 * @param sup [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param remoteUnitType Type of remote unit.
 * @group SCADA
 * @groupname SCADA Package SCADA
 * @groupdesc SCADA Contains entities to model information used by Supervisory Control and Data Acquisition (SCADA) applications. Supervisory control supports operator control of equipment, such as opening or closing a breaker. Data acquisition gathers telemetered data from various sources.  The subtypes of the Telemetry entity deliberately match the UCA and IEC 61850 definitions. 
This package also supports alarm presentation but it is not expected to be used by other applications.
 */
case class RemoteUnit
(
    override val sup: PowerSystemResource,
    remoteUnitType: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        "\t</cim:RemoteUnit>"
    }
}

object RemoteUnit
extends
    Parseable[RemoteUnit]
{
    val remoteUnitType = parse_attribute (attribute ("""RemoteUnit.remoteUnitType"""))
    def parse (context: Context): RemoteUnit =
    {
        RemoteUnit(
            PowerSystemResource.parse (context),
            remoteUnitType (context)
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
            RemoteUnit.register
        )
    }
}