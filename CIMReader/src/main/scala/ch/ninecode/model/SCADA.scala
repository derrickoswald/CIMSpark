package ch.ninecode.model

import com.esotericsoftware.kryo.Kryo
import com.esotericsoftware.kryo.Serializer
import com.esotericsoftware.kryo.io.Input
import com.esotericsoftware.kryo.io.Output
import org.apache.spark.sql.Row

import ch.ninecode.cim.CIMClassInfo
import ch.ninecode.cim.CIMContext
import ch.ninecode.cim.CIMParseable
import ch.ninecode.cim.CIMRelationship
import ch.ninecode.cim.CIMSerializer

/**
 * The connection to remote units is through one or more communication links.
 *
 * Reduntant links may exist. The CommunicationLink class inherits PowerSystemResource. The intention is to allow CommunicationLinks to have Measurements. These Measurements can be used to model link status as operational, out of service, unit failure etc.
 *
 * @param PowerSystemResource    [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param BilateralExchangeActor [[ch.ninecode.model.BilateralExchangeActor BilateralExchangeActor]] ICCP data provider or consumer using communication addressing for a Bilateral table.
 * @param RemoteUnits            [[ch.ninecode.model.RemoteUnit RemoteUnit]] RTUs may be attached to communication links.
 * @group SCADA
 * @groupname SCADA Package SCADA
 * @groupdesc SCADA Contains entities to model information used by Supervisory Control and Data Acquisition (SCADA) applications. Supervisory control supports operator control of equipment, such as opening or closing a breaker. Data acquisition gathers telemetered data from various sources.  The subtypes of the Telemetry entity deliberately match the UCA and IEC 61850 definitions. 
 *            This package also supports alarm presentation but it is not expected to be used by other applications.
 */
final case class CommunicationLink
(
    PowerSystemResource: PowerSystemResource = null,
    BilateralExchangeActor: String = null,
    RemoteUnits: List[String] = null
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
    override def sup: PowerSystemResource = PowerSystemResource

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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CommunicationLink.cls

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CommunicationLink.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (CommunicationLink.fields (position), x))

        emitattr (0, BilateralExchangeActor)
        emitattrs (1, RemoteUnits)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:CommunicationLink rdf:ID=\"%s\">\n%s\t</cim:CommunicationLink>".format (id, export_fields)
    }
}

object CommunicationLink
    extends
        CIMParseable[CommunicationLink]
{
    override val fields: Array[String] = Array [String](
        "BilateralExchangeActor",
        "RemoteUnits"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("BilateralExchangeActor", "BilateralExchangeActor", "0..1", "0..n"),
        CIMRelationship ("RemoteUnits", "RemoteUnit", "0..*", "1..*")
    )
    val BilateralExchangeActor: Fielder = parse_attribute (attribute (cls, fields (0)))
    val RemoteUnits: FielderMultiple = parse_attributes (attribute (cls, fields (1)))

    def parse (context: CIMContext): CommunicationLink =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = CommunicationLink (
            PowerSystemResource.parse (context),
            mask (BilateralExchangeActor (), 0),
            masks (RemoteUnits (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[CommunicationLink] = CommunicationLinkSerializer
}

object CommunicationLinkSerializer extends CIMSerializer[CommunicationLink]
{
    def write (kryo: Kryo, output: Output, obj: CommunicationLink): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.BilateralExchangeActor),
            () => writeList (obj.RemoteUnits, output)
        )
        PowerSystemResourceSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CommunicationLink]): CommunicationLink =
    {
        val parent = PowerSystemResourceSerializer.read (kryo, input, classOf [PowerSystemResource])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = CommunicationLink (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Remote controls are outputs that are sent by the remote unit to actuators in the process.
 *
 * @param RemotePoint      [[ch.ninecode.model.RemotePoint RemotePoint]] Reference to the superclass object.
 * @param actuatorMaximum  The maximum set point value accepted by the remote control point.
 * @param actuatorMinimum  The minimum set point value accepted by the remote control point.
 * @param remoteControlled Set to true if the actuator is remotely controlled.
 * @param Control          [[ch.ninecode.model.Control Control]] The Control for the RemoteControl point.
 * @group SCADA
 * @groupname SCADA Package SCADA
 * @groupdesc SCADA Contains entities to model information used by Supervisory Control and Data Acquisition (SCADA) applications. Supervisory control supports operator control of equipment, such as opening or closing a breaker. Data acquisition gathers telemetered data from various sources.  The subtypes of the Telemetry entity deliberately match the UCA and IEC 61850 definitions. 
 *            This package also supports alarm presentation but it is not expected to be used by other applications.
 */
final case class RemoteControl
(
    RemotePoint: RemotePoint = null,
    actuatorMaximum: Double = 0.0,
    actuatorMinimum: Double = 0.0,
    remoteControlled: Boolean = false,
    Control: String = null
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
    override def sup: RemotePoint = RemotePoint

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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[RemoteControl]
{
    override val fields: Array[String] = Array [String](
        "actuatorMaximum",
        "actuatorMinimum",
        "remoteControlled",
        "Control"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Control", "Control", "1", "0..1")
    )
    val actuatorMaximum: Fielder = parse_element (element (cls, fields (0)))
    val actuatorMinimum: Fielder = parse_element (element (cls, fields (1)))
    val remoteControlled: Fielder = parse_element (element (cls, fields (2)))
    val Control: Fielder = parse_attribute (attribute (cls, fields (3)))

    def parse (context: CIMContext): RemoteControl =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
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

    def serializer: Serializer[RemoteControl] = RemoteControlSerializer
}

object RemoteControlSerializer extends CIMSerializer[RemoteControl]
{
    def write (kryo: Kryo, output: Output, obj: RemoteControl): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.actuatorMaximum),
            () => output.writeDouble (obj.actuatorMinimum),
            () => output.writeBoolean (obj.remoteControlled),
            () => output.writeString (obj.Control)
        )
        RemotePointSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[RemoteControl]): RemoteControl =
    {
        val parent = RemotePointSerializer.read (kryo, input, classOf [RemotePoint])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = RemoteControl (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readBoolean else false,
            if (isSet (3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * For an RTU, remote points correspond to telemetered values or control outputs.
 *
 * Other units (e.g. control centres) usually also contain calculated values.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param RemoteUnit       [[ch.ninecode.model.RemoteUnit RemoteUnit]] Remote unit this point belongs to.
 * @group SCADA
 * @groupname SCADA Package SCADA
 * @groupdesc SCADA Contains entities to model information used by Supervisory Control and Data Acquisition (SCADA) applications. Supervisory control supports operator control of equipment, such as opening or closing a breaker. Data acquisition gathers telemetered data from various sources.  The subtypes of the Telemetry entity deliberately match the UCA and IEC 61850 definitions. 
 *            This package also supports alarm presentation but it is not expected to be used by other applications.
 */
final case class RemotePoint
(
    IdentifiedObject: IdentifiedObject = null,
    RemoteUnit: String = null
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
    override def sup: IdentifiedObject = IdentifiedObject

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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[RemotePoint]
{
    override val fields: Array[String] = Array [String](
        "RemoteUnit"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("RemoteUnit", "RemoteUnit", "1", "0..*")
    )
    val RemoteUnit: Fielder = parse_attribute (attribute (cls, fields (0)))

    def parse (context: CIMContext): RemotePoint =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = RemotePoint (
            IdentifiedObject.parse (context),
            mask (RemoteUnit (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[RemotePoint] = RemotePointSerializer
}

object RemotePointSerializer extends CIMSerializer[RemotePoint]
{
    def write (kryo: Kryo, output: Output, obj: RemotePoint): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.RemoteUnit)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[RemotePoint]): RemotePoint =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf [IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = RemotePoint (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Remote sources are state variables that are telemetered or calculated within the remote unit.
 *
 * @param RemotePoint      [[ch.ninecode.model.RemotePoint RemotePoint]] Reference to the superclass object.
 * @param deadband         The smallest change in value to be reported.
 * @param scanInterval     The time interval between scans.
 * @param sensorMaximum    The maximum value the telemetry item can return.
 * @param sensorMinimum    The minimum value the telemetry item can return.
 * @param MeasurementValue [[ch.ninecode.model.MeasurementValue MeasurementValue]] Link to the physical telemetered point associated with this measurement.
 * @group SCADA
 * @groupname SCADA Package SCADA
 * @groupdesc SCADA Contains entities to model information used by Supervisory Control and Data Acquisition (SCADA) applications. Supervisory control supports operator control of equipment, such as opening or closing a breaker. Data acquisition gathers telemetered data from various sources.  The subtypes of the Telemetry entity deliberately match the UCA and IEC 61850 definitions. 
 *            This package also supports alarm presentation but it is not expected to be used by other applications.
 */
final case class RemoteSource
(
    RemotePoint: RemotePoint = null,
    deadband: Double = 0.0,
    scanInterval: Double = 0.0,
    sensorMaximum: Double = 0.0,
    sensorMinimum: Double = 0.0,
    MeasurementValue: String = null
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
    override def sup: RemotePoint = RemotePoint

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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[RemoteSource]
{
    override val fields: Array[String] = Array [String](
        "deadband",
        "scanInterval",
        "sensorMaximum",
        "sensorMinimum",
        "MeasurementValue"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("MeasurementValue", "MeasurementValue", "1", "0..1")
    )
    val deadband: Fielder = parse_element (element (cls, fields (0)))
    val scanInterval: Fielder = parse_element (element (cls, fields (1)))
    val sensorMaximum: Fielder = parse_element (element (cls, fields (2)))
    val sensorMinimum: Fielder = parse_element (element (cls, fields (3)))
    val MeasurementValue: Fielder = parse_attribute (attribute (cls, fields (4)))

    def parse (context: CIMContext): RemoteSource =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
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

    def serializer: Serializer[RemoteSource] = RemoteSourceSerializer
}

object RemoteSourceSerializer extends CIMSerializer[RemoteSource]
{
    def write (kryo: Kryo, output: Output, obj: RemoteSource): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.deadband),
            () => output.writeDouble (obj.scanInterval),
            () => output.writeDouble (obj.sensorMaximum),
            () => output.writeDouble (obj.sensorMinimum),
            () => output.writeString (obj.MeasurementValue)
        )
        RemotePointSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[RemoteSource]): RemoteSource =
    {
        val parent = RemotePointSerializer.read (kryo, input, classOf [RemotePoint])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = RemoteSource (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A remote unit can be an RTU, IED, substation control system, control centre, etc.
 *
 * The communication with the remote unit can be through various standard protocols (e.g. IEC 61870, IEC 61850) or non standard protocols (e.g. DNP, RP570, etc.). A remote unit contains remote data points that might be telemetered, collected or calculated. The RemoteUnit class inherits PowerSystemResource. The intention is to allow RemoteUnits to have Measurements. These Measurements can be used to model unit status as operational, out of service, unit failure, etc.
 *
 * @param PowerSystemResource [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param remoteUnitType      Type of remote unit.
 * @param CommunicationLinks  [[ch.ninecode.model.CommunicationLink CommunicationLink]] RTUs may be attached to communication links.
 * @param RemotePoints        [[ch.ninecode.model.RemotePoint RemotePoint]] Remote points this Remote unit contains.
 * @group SCADA
 * @groupname SCADA Package SCADA
 * @groupdesc SCADA Contains entities to model information used by Supervisory Control and Data Acquisition (SCADA) applications. Supervisory control supports operator control of equipment, such as opening or closing a breaker. Data acquisition gathers telemetered data from various sources.  The subtypes of the Telemetry entity deliberately match the UCA and IEC 61850 definitions. 
 *            This package also supports alarm presentation but it is not expected to be used by other applications.
 */
final case class RemoteUnit
(
    PowerSystemResource: PowerSystemResource = null,
    remoteUnitType: String = null,
    CommunicationLinks: List[String] = null,
    RemotePoints: List[String] = null
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
    override def sup: PowerSystemResource = PowerSystemResource

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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = RemoteUnit.cls

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RemoteUnit.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (RemoteUnit.fields (position), x))

        emitattr (0, remoteUnitType)
        emitattrs (1, CommunicationLinks)
        emitattrs (2, RemotePoints)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:RemoteUnit rdf:ID=\"%s\">\n%s\t</cim:RemoteUnit>".format (id, export_fields)
    }
}

object RemoteUnit
    extends
        CIMParseable[RemoteUnit]
{
    override val fields: Array[String] = Array [String](
        "remoteUnitType",
        "CommunicationLinks",
        "RemotePoints"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("CommunicationLinks", "CommunicationLink", "1..*", "0..*"),
        CIMRelationship ("RemotePoints", "RemotePoint", "0..*", "1")
    )
    val remoteUnitType: Fielder = parse_attribute (attribute (cls, fields (0)))
    val CommunicationLinks: FielderMultiple = parse_attributes (attribute (cls, fields (1)))
    val RemotePoints: FielderMultiple = parse_attributes (attribute (cls, fields (2)))

    def parse (context: CIMContext): RemoteUnit =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = RemoteUnit (
            PowerSystemResource.parse (context),
            mask (remoteUnitType (), 0),
            masks (CommunicationLinks (), 1),
            masks (RemotePoints (), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[RemoteUnit] = RemoteUnitSerializer
}

object RemoteUnitSerializer extends CIMSerializer[RemoteUnit]
{
    def write (kryo: Kryo, output: Output, obj: RemoteUnit): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.remoteUnitType),
            () => writeList (obj.CommunicationLinks, output),
            () => writeList (obj.RemotePoints, output)
        )
        PowerSystemResourceSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[RemoteUnit]): RemoteUnit =
    {
        val parent = PowerSystemResourceSerializer.read (kryo, input, classOf [PowerSystemResource])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = RemoteUnit (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _SCADA
{
    def register: List[CIMClassInfo] =
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