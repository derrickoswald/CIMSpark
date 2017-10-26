package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:CommunicationLink rdf:ID=\"%s\">\n%s\t</cim:CommunicationLink>".format (id, export_fields)
    }
}

object CommunicationLink
extends
    Parseable[CommunicationLink]
{

    def parse (context: Context): CommunicationLink =
    {
        implicit val ctx: Context = context
        val ret = CommunicationLink (
            PowerSystemResource.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = RemoteControl.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (RemoteControl.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RemoteControl.fields (position), value)
        emitelem (0, actuatorMaximum)
        emitelem (1, actuatorMinimum)
        emitelem (2, remoteControlled)
        emitattr (3, Control)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RemoteControl rdf:ID=\"%s\">\n%s\t</cim:RemoteControl>".format (id, export_fields)
    }
}

object RemoteControl
extends
    Parseable[RemoteControl]
{
    val fields: Array[String] = Array[String] (
        "actuatorMaximum",
        "actuatorMinimum",
        "remoteControlled",
        "Control"
    )
    val actuatorMaximum: Fielder = parse_element (element (cls, fields(0)))
    val actuatorMinimum: Fielder = parse_element (element (cls, fields(1)))
    val remoteControlled: Fielder = parse_element (element (cls, fields(2)))
    val Control: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): RemoteControl =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = RemoteControl (
            RemotePoint.parse (context),
            toDouble (mask (actuatorMaximum (), 0)),
            toDouble (mask (actuatorMinimum (), 1)),
            toBoolean (mask (remoteControlled (), 2)),
            mask (Control (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Control", "Control", false)
    )
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = RemotePoint.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RemotePoint.fields (position), value)
        emitattr (0, RemoteUnit)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RemotePoint rdf:ID=\"%s\">\n%s\t</cim:RemotePoint>".format (id, export_fields)
    }
}

object RemotePoint
extends
    Parseable[RemotePoint]
{
    val fields: Array[String] = Array[String] (
        "RemoteUnit"
    )
    val RemoteUnit: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): RemotePoint =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = RemotePoint (
            IdentifiedObject.parse (context),
            mask (RemoteUnit (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("RemoteUnit", "RemoteUnit", false)
    )
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = RemoteSource.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (RemoteSource.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RemoteSource.fields (position), value)
        emitelem (0, deadband)
        emitelem (1, scanInterval)
        emitelem (2, sensorMaximum)
        emitelem (3, sensorMinimum)
        emitattr (4, MeasurementValue)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RemoteSource rdf:ID=\"%s\">\n%s\t</cim:RemoteSource>".format (id, export_fields)
    }
}

object RemoteSource
extends
    Parseable[RemoteSource]
{
    val fields: Array[String] = Array[String] (
        "deadband",
        "scanInterval",
        "sensorMaximum",
        "sensorMinimum",
        "MeasurementValue"
    )
    val deadband: Fielder = parse_element (element (cls, fields(0)))
    val scanInterval: Fielder = parse_element (element (cls, fields(1)))
    val sensorMaximum: Fielder = parse_element (element (cls, fields(2)))
    val sensorMinimum: Fielder = parse_element (element (cls, fields(3)))
    val MeasurementValue: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): RemoteSource =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = RemoteSource (
            RemotePoint.parse (context),
            toDouble (mask (deadband (), 0)),
            toDouble (mask (scanInterval (), 1)),
            toDouble (mask (sensorMaximum (), 2)),
            toDouble (mask (sensorMinimum (), 3)),
            mask (MeasurementValue (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("MeasurementValue", "MeasurementValue", false)
    )
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = RemoteUnit.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RemoteUnit.fields (position), value)
        emitattr (0, remoteUnitType)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RemoteUnit rdf:ID=\"%s\">\n%s\t</cim:RemoteUnit>".format (id, export_fields)
    }
}

object RemoteUnit
extends
    Parseable[RemoteUnit]
{
    val fields: Array[String] = Array[String] (
        "remoteUnitType"
    )
    val remoteUnitType: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): RemoteUnit =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = RemoteUnit (
            PowerSystemResource.parse (context),
            mask (remoteUnitType (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
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