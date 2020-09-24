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
 * A fault applied at the terminal, external to the equipment.
 *
 * This class is not used to specify faults internal to the equipment.
 *
 * @param Fault [[ch.ninecode.model.Fault Fault]] Reference to the superclass object.
 * @param Terminal [[ch.ninecode.model.Terminal Terminal]] The terminal connecting to the bus to which the fault is applied.
 * @group Faults
 * @groupname Faults Package Faults
 * @groupdesc Faults The package describes faults that may happen to conducting equipment, e.g. tree falling on a power line.
 */
final case class EquipmentFault
(
    Fault: Fault = null,
    Terminal: String = null
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
    override def sup: Fault = Fault

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
        implicit val clz: String = EquipmentFault.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EquipmentFault.fields (position), value)
        emitattr (0, Terminal)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EquipmentFault rdf:%s=\"%s\">\n%s\t</cim:EquipmentFault>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object EquipmentFault
extends
    CIMParseable[EquipmentFault]
{
    override val fields: Array[String] = Array[String] (
        "Terminal"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Terminal", "Terminal", "0..1", "0..*")
    )
    val Terminal: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): EquipmentFault =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EquipmentFault (
            Fault.parse (context),
            mask (Terminal (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[EquipmentFault] = EquipmentFaultSerializer
}

object EquipmentFaultSerializer extends CIMSerializer[EquipmentFault]
{
    def write (kryo: Kryo, output: Output, obj: EquipmentFault): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.Terminal)
        )
        FaultSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[EquipmentFault]): EquipmentFault =
    {
        val parent = FaultSerializer.read (kryo, input, classOf[Fault])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = EquipmentFault (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Abnormal condition causing current flow through conducting equipment, such as caused by equipment failure or short circuits from objects not typically modelled (for example, a tree falling on a line).
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param impedance [[ch.ninecode.model.FaultImpedance FaultImpedance]] Fault impedance.
 *        Its usage is described by 'kind'.
 * @param kind The kind of phase fault.
 * @param occurredDateTime The date and time at which the fault occurred.
 * @param phases The phases participating in the fault.
 *        The fault connections into these phases are further specified by the type of fault.
 * @param FaultCauseTypes [[ch.ninecode.model.FaultCauseType FaultCauseType]] All types of fault cause.
 * @param FaultyEquipment [[ch.ninecode.model.Equipment Equipment]] Equipment carrying this fault.
 * @param Location [[ch.ninecode.model.Location Location]] <em>undocumented</em>
 * @param Outage [[ch.ninecode.model.Outage Outage]] Outage associated with this fault.
 * @group Faults
 * @groupname Faults Package Faults
 * @groupdesc Faults The package describes faults that may happen to conducting equipment, e.g. tree falling on a power line.
 */
final case class Fault
(
    IdentifiedObject: IdentifiedObject = null,
    impedance: String = null,
    kind: String = null,
    occurredDateTime: String = null,
    phases: String = null,
    FaultCauseTypes: List[String] = null,
    FaultyEquipment: String = null,
    Location: String = null,
    Outage: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Fault.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Fault.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Fault.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Fault.fields (position), x))
        emitattr (0, impedance)
        emitattr (1, kind)
        emitelem (2, occurredDateTime)
        emitattr (3, phases)
        emitattrs (4, FaultCauseTypes)
        emitattr (5, FaultyEquipment)
        emitattr (6, Location)
        emitattr (7, Outage)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Fault rdf:%s=\"%s\">\n%s\t</cim:Fault>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object Fault
extends
    CIMParseable[Fault]
{
    override val fields: Array[String] = Array[String] (
        "impedance",
        "kind",
        "occurredDateTime",
        "phases",
        "FaultCauseTypes",
        "FaultyEquipment",
        "Location",
        "Outage"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("impedance", "FaultImpedance", "0..1", "0..*"),
        CIMRelationship ("FaultCauseTypes", "FaultCauseType", "0..*", "0..*"),
        CIMRelationship ("FaultyEquipment", "Equipment", "0..1", "0..*"),
        CIMRelationship ("Location", "Location", "0..1", "0..*"),
        CIMRelationship ("Outage", "Outage", "0..1", "0..*")
    )
    val impedance: Fielder = parse_attribute (attribute (cls, fields(0)))
    val kind: Fielder = parse_attribute (attribute (cls, fields(1)))
    val occurredDateTime: Fielder = parse_element (element (cls, fields(2)))
    val phases: Fielder = parse_attribute (attribute (cls, fields(3)))
    val FaultCauseTypes: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val FaultyEquipment: Fielder = parse_attribute (attribute (cls, fields(5)))
    val Location: Fielder = parse_attribute (attribute (cls, fields(6)))
    val Outage: Fielder = parse_attribute (attribute (cls, fields(7)))

    def parse (context: CIMContext): Fault =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Fault (
            IdentifiedObject.parse (context),
            mask (impedance (), 0),
            mask (kind (), 1),
            mask (occurredDateTime (), 2),
            mask (phases (), 3),
            masks (FaultCauseTypes (), 4),
            mask (FaultyEquipment (), 5),
            mask (Location (), 6),
            mask (Outage (), 7)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Fault] = FaultSerializer
}

object FaultSerializer extends CIMSerializer[Fault]
{
    def write (kryo: Kryo, output: Output, obj: Fault): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.impedance),
            () => output.writeString (obj.kind),
            () => output.writeString (obj.occurredDateTime),
            () => output.writeString (obj.phases),
            () => writeList (obj.FaultCauseTypes, output),
            () => output.writeString (obj.FaultyEquipment),
            () => output.writeString (obj.Location),
            () => output.writeString (obj.Outage)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Fault]): Fault =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Fault (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) readList (input) else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Type of cause of the fault.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param ConfigurationEvent [[ch.ninecode.model.ConfigurationEvent ConfigurationEvent]] <em>undocumented</em>
 * @param Faults [[ch.ninecode.model.Fault Fault]] All faults with this cause type.
 * @group Faults
 * @groupname Faults Package Faults
 * @groupdesc Faults The package describes faults that may happen to conducting equipment, e.g. tree falling on a power line.
 */
final case class FaultCauseType
(
    IdentifiedObject: IdentifiedObject = null,
    ConfigurationEvent: List[String] = null,
    Faults: List[String] = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = FaultCauseType.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (FaultCauseType.fields (position), x))
        emitattrs (0, ConfigurationEvent)
        emitattrs (1, Faults)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:FaultCauseType rdf:%s=\"%s\">\n%s\t</cim:FaultCauseType>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object FaultCauseType
extends
    CIMParseable[FaultCauseType]
{
    override val fields: Array[String] = Array[String] (
        "ConfigurationEvent",
        "Faults"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ConfigurationEvent", "ConfigurationEvent", "0..*", "1"),
        CIMRelationship ("Faults", "Fault", "0..*", "0..*")
    )
    val ConfigurationEvent: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val Faults: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): FaultCauseType =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = FaultCauseType (
            IdentifiedObject.parse (context),
            masks (ConfigurationEvent (), 0),
            masks (Faults (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[FaultCauseType] = FaultCauseTypeSerializer
}

object FaultCauseTypeSerializer extends CIMSerializer[FaultCauseType]
{
    def write (kryo: Kryo, output: Output, obj: FaultCauseType): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.ConfigurationEvent, output),
            () => writeList (obj.Faults, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[FaultCauseType]): FaultCauseType =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = FaultCauseType (
            parent,
            if (isSet (0)) readList (input) else null,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Impedance description for the fault.
 *
 * @param Element Reference to the superclass object.
 * @param rGround The resistance of the fault between phases and ground.
 * @param rLineToLine The resistance of the fault between phases.
 * @param xGround The reactance of the fault between phases and ground.
 * @param xLineToLine The reactance of the fault between phases.
 * @group Faults
 * @groupname Faults Package Faults
 * @groupdesc Faults The package describes faults that may happen to conducting equipment, e.g. tree falling on a power line.
 */
final case class FaultImpedance
(
    Element: BasicElement = null,
    rGround: Double = 0.0,
    rLineToLine: Double = 0.0,
    xGround: Double = 0.0,
    xLineToLine: Double = 0.0
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
    override def sup: Element = Element

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
        implicit val clz: String = FaultImpedance.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (FaultImpedance.fields (position), value)
        emitelem (0, rGround)
        emitelem (1, rLineToLine)
        emitelem (2, xGround)
        emitelem (3, xLineToLine)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:FaultImpedance rdf:%s=\"%s\">\n%s\t</cim:FaultImpedance>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object FaultImpedance
extends
    CIMParseable[FaultImpedance]
{
    override val fields: Array[String] = Array[String] (
        "rGround",
        "rLineToLine",
        "xGround",
        "xLineToLine"
    )
    val rGround: Fielder = parse_element (element (cls, fields(0)))
    val rLineToLine: Fielder = parse_element (element (cls, fields(1)))
    val xGround: Fielder = parse_element (element (cls, fields(2)))
    val xLineToLine: Fielder = parse_element (element (cls, fields(3)))

    def parse (context: CIMContext): FaultImpedance =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = FaultImpedance (
            BasicElement.parse (context),
            toDouble (mask (rGround (), 0)),
            toDouble (mask (rLineToLine (), 1)),
            toDouble (mask (xGround (), 2)),
            toDouble (mask (xLineToLine (), 3))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[FaultImpedance] = FaultImpedanceSerializer
}

object FaultImpedanceSerializer extends CIMSerializer[FaultImpedance]
{
    def write (kryo: Kryo, output: Output, obj: FaultImpedance): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.rGround),
            () => output.writeDouble (obj.rLineToLine),
            () => output.writeDouble (obj.xGround),
            () => output.writeDouble (obj.xLineToLine)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[FaultImpedance]): FaultImpedance =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = FaultImpedance (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A fault that occurs on an AC line segment at some point along the length.
 *
 * @param Fault [[ch.ninecode.model.Fault Fault]] Reference to the superclass object.
 * @param lengthFromTerminal1 The length to the place where the fault is located starting from terminal with sequence number 1 of the faulted line segment.
 * @param ACLineSegment [[ch.ninecode.model.ACLineSegment ACLineSegment]] The line segment of this line fault.
 * @group Faults
 * @groupname Faults Package Faults
 * @groupdesc Faults The package describes faults that may happen to conducting equipment, e.g. tree falling on a power line.
 */
final case class LineFault
(
    Fault: Fault = null,
    lengthFromTerminal1: Double = 0.0,
    ACLineSegment: String = null
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
    override def sup: Fault = Fault

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
        implicit val clz: String = LineFault.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (LineFault.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (LineFault.fields (position), value)
        emitelem (0, lengthFromTerminal1)
        emitattr (1, ACLineSegment)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:LineFault rdf:%s=\"%s\">\n%s\t</cim:LineFault>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object LineFault
extends
    CIMParseable[LineFault]
{
    override val fields: Array[String] = Array[String] (
        "lengthFromTerminal1",
        "ACLineSegment"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ACLineSegment", "ACLineSegment", "0..1", "0..*")
    )
    val lengthFromTerminal1: Fielder = parse_element (element (cls, fields(0)))
    val ACLineSegment: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): LineFault =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = LineFault (
            Fault.parse (context),
            toDouble (mask (lengthFromTerminal1 (), 0)),
            mask (ACLineSegment (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[LineFault] = LineFaultSerializer
}

object LineFaultSerializer extends CIMSerializer[LineFault]
{
    def write (kryo: Kryo, output: Output, obj: LineFault): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.lengthFromTerminal1),
            () => output.writeString (obj.ACLineSegment)
        )
        FaultSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[LineFault]): LineFault =
    {
        val parent = FaultSerializer.read (kryo, input, classOf[Fault])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = LineFault (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _Faults
{
    def register: List[CIMClassInfo] =
    {
        List (
            EquipmentFault.register,
            Fault.register,
            FaultCauseType.register,
            FaultImpedance.register,
            LineFault.register
        )
    }
}