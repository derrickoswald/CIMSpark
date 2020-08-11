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
 * An electrical connection point (AC or DC) to a piece of conducting equipment.
 *
 * Terminals are connected at physical connection points called connectivity nodes.
 *
 * @param IdentifiedObject    [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param connected           The connected status is related to a bus-branch model and the topological node to terminal relation.
 *                            True implies the terminal is connected to the related topological node and false implies it is not.
 *                            In a bus-branch model, the connected status is used to tell if equipment is disconnected without having to change the connectivity described by the topological node to terminal relation. A valid case is that conducting equipment can be connected in one end and open in the other. In particular for an AC line segment, where the reactive line charging can be significant, this is a relevant case.
 * @param sequenceNumber      The orientation of the terminal connections for a multiple terminal conducting equipment.
 *                            The sequence numbering starts with 1 and additional terminals should follow in increasing order.   The first terminal is the "starting point" for a two terminal branch.
 * @param BusNameMarker       [[ch.ninecode.model.BusNameMarker BusNameMarker]] The bus name marker used to name the bus (topological node).
 * @param Measurements        [[ch.ninecode.model.Measurement Measurement]] Measurements associated with this terminal defining  where the measurement is placed in the network topology.
 *                            It may be used, for instance, to capture the sensor position, such as a voltage transformer (PT) at a busbar or a current transformer (CT) at the bar between a breaker and an isolator.
 * @param OperationalLimitSet [[ch.ninecode.model.OperationalLimitSet OperationalLimitSet]] The operational limit sets at the terminal.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
final case class ACDCTerminal
(
    IdentifiedObject: IdentifiedObject = null,
    connected: Boolean = false,
    sequenceNumber: Int = 0,
    BusNameMarker: String = null,
    Measurements: List[String] = null,
    OperationalLimitSet: List[String] = null
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
        implicit val clz: String = ACDCTerminal.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ACDCTerminal.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ACDCTerminal.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ACDCTerminal.fields (position), x))

        emitelem (0, connected)
        emitelem (1, sequenceNumber)
        emitattr (2, BusNameMarker)
        emitattrs (3, Measurements)
        emitattrs (4, OperationalLimitSet)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ACDCTerminal rdf:ID=\"%s\">\n%s\t</cim:ACDCTerminal>".format (id, export_fields)
    }
}

object ACDCTerminal
    extends
        CIMParseable[ACDCTerminal]
{
    override val fields: Array[String] = Array [String](
        "connected",
        "sequenceNumber",
        "BusNameMarker",
        "Measurements",
        "OperationalLimitSet"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("BusNameMarker", "BusNameMarker", "0..1", "1..*"),
        CIMRelationship ("Measurements", "Measurement", "0..*", "0..1"),
        CIMRelationship ("OperationalLimitSet", "OperationalLimitSet", "0..*", "0..1")
    )
    val connected: Fielder = parse_element (element (cls, fields (0)))
    val sequenceNumber: Fielder = parse_element (element (cls, fields (1)))
    val BusNameMarker: Fielder = parse_attribute (attribute (cls, fields (2)))
    val Measurements: FielderMultiple = parse_attributes (attribute (cls, fields (3)))
    val OperationalLimitSet: FielderMultiple = parse_attributes (attribute (cls, fields (4)))

    def parse (context: CIMContext): ACDCTerminal =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = ACDCTerminal (
            IdentifiedObject.parse (context),
            toBoolean (mask (connected (), 0)),
            toInteger (mask (sequenceNumber (), 1)),
            mask (BusNameMarker (), 2),
            masks (Measurements (), 3),
            masks (OperationalLimitSet (), 4)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ACDCTerminal] = ACDCTerminalSerializer
}

object ACDCTerminalSerializer extends CIMSerializer[ACDCTerminal]
{
    def write (kryo: Kryo, output: Output, obj: ACDCTerminal): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeBoolean (obj.connected),
            () => output.writeInt (obj.sequenceNumber),
            () => output.writeString (obj.BusNameMarker),
            () => writeList (obj.Measurements, output),
            () => writeList (obj.OperationalLimitSet, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ACDCTerminal]): ACDCTerminal =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf [IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ACDCTerminal (
            parent,
            if (isSet (0)) input.readBoolean else false,
            if (isSet (1)) input.readInt else 0,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The BaseFrequency class describes a base frequency for a power system network.
 *
 * In case of multiple power networks with different frequencies, e.g. 50 Hz or 60 Hz each network will have its own base frequency class. Hence it is assumed that power system objects having different base frequencies appear in separate documents where each document has a single base frequency instance.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param frequency        The base frequency.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
final case class BaseFrequency
(
    IdentifiedObject: IdentifiedObject = null,
    frequency: Double = 0.0
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
        implicit val clz: String = BaseFrequency.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (BaseFrequency.fields (position), value)

        emitelem (0, frequency)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:BaseFrequency rdf:ID=\"%s\">\n%s\t</cim:BaseFrequency>".format (id, export_fields)
    }
}

object BaseFrequency
    extends
        CIMParseable[BaseFrequency]
{
    override val fields: Array[String] = Array [String](
        "frequency"
    )
    val frequency: Fielder = parse_element (element (cls, fields (0)))

    def parse (context: CIMContext): BaseFrequency =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = BaseFrequency (
            IdentifiedObject.parse (context),
            toDouble (mask (frequency (), 0))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[BaseFrequency] = BaseFrequencySerializer
}

object BaseFrequencySerializer extends CIMSerializer[BaseFrequency]
{
    def write (kryo: Kryo, output: Output, obj: BaseFrequency): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.frequency)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[BaseFrequency]): BaseFrequency =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf [IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = BaseFrequency (
            parent,
            if (isSet (0)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The BasePower class defines the base power used in the per unit calculations.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param basePower        Value used as base power.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
final case class BasePower
(
    IdentifiedObject: IdentifiedObject = null,
    basePower: Double = 0.0
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
        implicit val clz: String = BasePower.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (BasePower.fields (position), value)

        emitelem (0, basePower)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:BasePower rdf:ID=\"%s\">\n%s\t</cim:BasePower>".format (id, export_fields)
    }
}

object BasePower
    extends
        CIMParseable[BasePower]
{
    override val fields: Array[String] = Array [String](
        "basePower"
    )
    val basePower: Fielder = parse_element (element (cls, fields (0)))

    def parse (context: CIMContext): BasePower =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = BasePower (
            IdentifiedObject.parse (context),
            toDouble (mask (basePower (), 0))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[BasePower] = BasePowerSerializer
}

object BasePowerSerializer extends CIMSerializer[BasePower]
{
    def write (kryo: Kryo, output: Output, obj: BasePower): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.basePower)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[BasePower]): BasePower =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf [IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = BasePower (
            parent,
            if (isSet (0)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Defines a system base voltage which is referenced.
 *
 * @param IdentifiedObject       [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param nominalVoltage         The power system resource's base voltage.
 *                               Shall be a positive value and not zero.
 * @param ConductingEquipment    [[ch.ninecode.model.ConductingEquipment ConductingEquipment]] All conducting equipment with this base voltage.
 *                               Use only when there is no voltage level container used and only one base voltage applies.  For example, not used for transformers.
 * @param NetworkAssetDeployment [[ch.ninecode.model.AssetDeployment AssetDeployment]] A network asset deployment at this base voltage level.
 * @param TopologicalNode        [[ch.ninecode.model.TopologicalNode TopologicalNode]] The topological nodes at the base voltage.
 * @param TransformerEnds        [[ch.ninecode.model.TransformerEnd TransformerEnd]] Transformer ends at the base voltage.
 *                               This is essential for PU calculation.
 * @param VoltageLevel           [[ch.ninecode.model.VoltageLevel VoltageLevel]] The voltage levels having this base voltage.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
final case class BaseVoltage
(
    IdentifiedObject: IdentifiedObject = null,
    nominalVoltage: Double = 0.0,
    ConductingEquipment: List[String] = null,
    NetworkAssetDeployment: List[String] = null,
    TopologicalNode: List[String] = null,
    TransformerEnds: List[String] = null,
    VoltageLevel: List[String] = null
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
        implicit val clz: String = BaseVoltage.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (BaseVoltage.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (BaseVoltage.fields (position), x))

        emitelem (0, nominalVoltage)
        emitattrs (1, ConductingEquipment)
        emitattrs (2, NetworkAssetDeployment)
        emitattrs (3, TopologicalNode)
        emitattrs (4, TransformerEnds)
        emitattrs (5, VoltageLevel)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:BaseVoltage rdf:ID=\"%s\">\n%s\t</cim:BaseVoltage>".format (id, export_fields)
    }
}

object BaseVoltage
    extends
        CIMParseable[BaseVoltage]
{
    override val fields: Array[String] = Array [String](
        "nominalVoltage",
        "ConductingEquipment",
        "NetworkAssetDeployment",
        "TopologicalNode",
        "TransformerEnds",
        "VoltageLevel"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ConductingEquipment", "ConductingEquipment", "0..*", "0..1"),
        CIMRelationship ("NetworkAssetDeployment", "AssetDeployment", "0..*", "1"),
        CIMRelationship ("TopologicalNode", "TopologicalNode", "0..*", "0..1"),
        CIMRelationship ("TransformerEnds", "TransformerEnd", "0..*", "0..1"),
        CIMRelationship ("VoltageLevel", "VoltageLevel", "0..*", "1")
    )
    val nominalVoltage: Fielder = parse_element (element (cls, fields (0)))
    val ConductingEquipment: FielderMultiple = parse_attributes (attribute (cls, fields (1)))
    val NetworkAssetDeployment: FielderMultiple = parse_attributes (attribute (cls, fields (2)))
    val TopologicalNode: FielderMultiple = parse_attributes (attribute (cls, fields (3)))
    val TransformerEnds: FielderMultiple = parse_attributes (attribute (cls, fields (4)))
    val VoltageLevel: FielderMultiple = parse_attributes (attribute (cls, fields (5)))

    def parse (context: CIMContext): BaseVoltage =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = BaseVoltage (
            IdentifiedObject.parse (context),
            toDouble (mask (nominalVoltage (), 0)),
            masks (ConductingEquipment (), 1),
            masks (NetworkAssetDeployment (), 2),
            masks (TopologicalNode (), 3),
            masks (TransformerEnds (), 4),
            masks (VoltageLevel (), 5)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[BaseVoltage] = BaseVoltageSerializer
}

object BaseVoltageSerializer extends CIMSerializer[BaseVoltage]
{
    def write (kryo: Kryo, output: Output, obj: BaseVoltage): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.nominalVoltage),
            () => writeList (obj.ConductingEquipment, output),
            () => writeList (obj.NetworkAssetDeployment, output),
            () => writeList (obj.TopologicalNode, output),
            () => writeList (obj.TransformerEnds, output),
            () => writeList (obj.VoltageLevel, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[BaseVoltage]): BaseVoltage =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf [IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = BaseVoltage (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) readList (input) else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) readList (input) else null,
            if (isSet (5)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Schedule of values at points in time.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param startTime        The time for the first time point.
 *                         The value can be a time of day, not a specific date.
 * @param value1Multiplier Multiplier for value1.
 * @param value1Unit       Value1 units of measure.
 * @param value2Multiplier Multiplier for value2.
 * @param value2Unit       Value2 units of measure.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
final case class BasicIntervalSchedule
(
    IdentifiedObject: IdentifiedObject = null,
    startTime: String = null,
    value1Multiplier: String = null,
    value1Unit: String = null,
    value2Multiplier: String = null,
    value2Unit: String = null
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
        implicit val clz: String = BasicIntervalSchedule.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (BasicIntervalSchedule.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (BasicIntervalSchedule.fields (position), value)

        emitelem (0, startTime)
        emitattr (1, value1Multiplier)
        emitattr (2, value1Unit)
        emitattr (3, value2Multiplier)
        emitattr (4, value2Unit)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:BasicIntervalSchedule rdf:ID=\"%s\">\n%s\t</cim:BasicIntervalSchedule>".format (id, export_fields)
    }
}

object BasicIntervalSchedule
    extends
        CIMParseable[BasicIntervalSchedule]
{
    override val fields: Array[String] = Array [String](
        "startTime",
        "value1Multiplier",
        "value1Unit",
        "value2Multiplier",
        "value2Unit"
    )
    val startTime: Fielder = parse_element (element (cls, fields (0)))
    val value1Multiplier: Fielder = parse_attribute (attribute (cls, fields (1)))
    val value1Unit: Fielder = parse_attribute (attribute (cls, fields (2)))
    val value2Multiplier: Fielder = parse_attribute (attribute (cls, fields (3)))
    val value2Unit: Fielder = parse_attribute (attribute (cls, fields (4)))

    def parse (context: CIMContext): BasicIntervalSchedule =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = BasicIntervalSchedule (
            IdentifiedObject.parse (context),
            mask (startTime (), 0),
            mask (value1Multiplier (), 1),
            mask (value1Unit (), 2),
            mask (value2Multiplier (), 3),
            mask (value2Unit (), 4)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[BasicIntervalSchedule] = BasicIntervalScheduleSerializer
}

object BasicIntervalScheduleSerializer extends CIMSerializer[BasicIntervalSchedule]
{
    def write (kryo: Kryo, output: Output, obj: BasicIntervalSchedule): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.startTime),
            () => output.writeString (obj.value1Multiplier),
            () => output.writeString (obj.value1Unit),
            () => output.writeString (obj.value2Multiplier),
            () => output.writeString (obj.value2Unit)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[BasicIntervalSchedule]): BasicIntervalSchedule =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf [IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = BasicIntervalSchedule (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A collection of power system resources (within a given substation) including conducting equipment, protection relays, measurements, and telemetry.
 *
 * A bay typically represents a physical grouping related to modularization of equipment.
 *
 * @param EquipmentContainer   [[ch.ninecode.model.EquipmentContainer EquipmentContainer]] Reference to the superclass object.
 * @param bayEnergyMeasFlag    Indicates the presence/absence of energy measurements.
 * @param bayPowerMeasFlag     Indicates the presence/absence of active/reactive power measurements.
 * @param breakerConfiguration Breaker configuration.
 * @param busBarConfiguration  Busbar configuration.
 * @param Circuit              [[ch.ninecode.model.Circuit Circuit]] <em>undocumented</em>
 * @param Substation           [[ch.ninecode.model.Substation Substation]] Substation containing the bay.
 * @param VoltageLevel         [[ch.ninecode.model.VoltageLevel VoltageLevel]] The voltage level containing this bay.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
final case class Bay
(
    EquipmentContainer: EquipmentContainer = null,
    bayEnergyMeasFlag: Boolean = false,
    bayPowerMeasFlag: Boolean = false,
    breakerConfiguration: String = null,
    busBarConfiguration: String = null,
    Circuit: String = null,
    Substation: String = null,
    VoltageLevel: String = null
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
    override def sup: EquipmentContainer = EquipmentContainer

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
        implicit val clz: String = Bay.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Bay.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Bay.fields (position), value)

        emitelem (0, bayEnergyMeasFlag)
        emitelem (1, bayPowerMeasFlag)
        emitattr (2, breakerConfiguration)
        emitattr (3, busBarConfiguration)
        emitattr (4, Circuit)
        emitattr (5, Substation)
        emitattr (6, VoltageLevel)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:Bay rdf:ID=\"%s\">\n%s\t</cim:Bay>".format (id, export_fields)
    }
}

object Bay
    extends
        CIMParseable[Bay]
{
    override val fields: Array[String] = Array [String](
        "bayEnergyMeasFlag",
        "bayPowerMeasFlag",
        "breakerConfiguration",
        "busBarConfiguration",
        "Circuit",
        "Substation",
        "VoltageLevel"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Circuit", "Circuit", "0..1", "0..*"),
        CIMRelationship ("Substation", "Substation", "0..1", "0..*"),
        CIMRelationship ("VoltageLevel", "VoltageLevel", "0..1", "0..*")
    )
    val bayEnergyMeasFlag: Fielder = parse_element (element (cls, fields (0)))
    val bayPowerMeasFlag: Fielder = parse_element (element (cls, fields (1)))
    val breakerConfiguration: Fielder = parse_attribute (attribute (cls, fields (2)))
    val busBarConfiguration: Fielder = parse_attribute (attribute (cls, fields (3)))
    val Circuit: Fielder = parse_attribute (attribute (cls, fields (4)))
    val Substation: Fielder = parse_attribute (attribute (cls, fields (5)))
    val VoltageLevel: Fielder = parse_attribute (attribute (cls, fields (6)))

    def parse (context: CIMContext): Bay =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = Bay (
            EquipmentContainer.parse (context),
            toBoolean (mask (bayEnergyMeasFlag (), 0)),
            toBoolean (mask (bayPowerMeasFlag (), 1)),
            mask (breakerConfiguration (), 2),
            mask (busBarConfiguration (), 3),
            mask (Circuit (), 4),
            mask (Substation (), 5),
            mask (VoltageLevel (), 6)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Bay] = BaySerializer
}

object BaySerializer extends CIMSerializer[Bay]
{
    def write (kryo: Kryo, output: Output, obj: Bay): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeBoolean (obj.bayEnergyMeasFlag),
            () => output.writeBoolean (obj.bayPowerMeasFlag),
            () => output.writeString (obj.breakerConfiguration),
            () => output.writeString (obj.busBarConfiguration),
            () => output.writeString (obj.Circuit),
            () => output.writeString (obj.Substation),
            () => output.writeString (obj.VoltageLevel)
        )
        EquipmentContainerSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Bay]): Bay =
    {
        val parent = EquipmentContainerSerializer.read (kryo, input, classOf [EquipmentContainer])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Bay (
            parent,
            if (isSet (0)) input.readBoolean else false,
            if (isSet (1)) input.readBoolean else false,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The parts of the AC power system that are designed to carry current or that are conductively connected through terminals.
 *
 * @param Equipment                  [[ch.ninecode.model.Equipment Equipment]] Reference to the superclass object.
 * @param BaseVoltage                [[ch.ninecode.model.BaseVoltage BaseVoltage]] Base voltage of this conducting equipment.
 *                                   Use only when there is no voltage level container used and only one base voltage applies.  For example, not used for transformers.
 * @param GroundingAction            [[ch.ninecode.model.GroundAction GroundAction]] Action involving grounding operation on this conducting equipment.
 * @param JumpingAction              [[ch.ninecode.model.JumperAction JumperAction]] Jumper action involving jumping operation on this conducting equipment.
 * @param Outage                     [[ch.ninecode.model.Outage Outage]] <em>undocumented</em>
 * @param ProtectionEquipments       [[ch.ninecode.model.ProtectionEquipment ProtectionEquipment]] Protection equipment  used to protect specific conducting equipment.
 * @param ProtectiveActionAdjustment [[ch.ninecode.model.ProtectiveActionAdjustment ProtectiveActionAdjustment]] The operating condition to the Conducting Equipment is changed when protective action adjustment is activated.
 *                                   For ShuntCompensator or other conducting equipment that operates on discrete values (integer), the values given in float will be rounded.
 * @param SvStatus                   [[ch.ninecode.model.SvStatus SvStatus]] The status state variable associated with this conducting equipment.
 * @param Terminals                  [[ch.ninecode.model.Terminal Terminal]] Conducting equipment have terminals that may be connected to other conducting equipment terminals via connectivity nodes or topological nodes.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
final case class ConductingEquipment
(
    Equipment: Equipment = null,
    BaseVoltage: String = null,
    GroundingAction: String = null,
    JumpingAction: String = null,
    Outage: String = null,
    ProtectionEquipments: List[String] = null,
    ProtectiveActionAdjustment: List[String] = null,
    SvStatus: List[String] = null,
    Terminals: List[String] = null
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
    override def sup: Equipment = Equipment

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
        implicit val clz: String = ConductingEquipment.cls

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ConductingEquipment.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ConductingEquipment.fields (position), x))

        emitattr (0, BaseVoltage)
        emitattr (1, GroundingAction)
        emitattr (2, JumpingAction)
        emitattr (3, Outage)
        emitattrs (4, ProtectionEquipments)
        emitattrs (5, ProtectiveActionAdjustment)
        emitattrs (6, SvStatus)
        emitattrs (7, Terminals)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ConductingEquipment rdf:ID=\"%s\">\n%s\t</cim:ConductingEquipment>".format (id, export_fields)
    }
}

object ConductingEquipment
    extends
        CIMParseable[ConductingEquipment]
{
    override val fields: Array[String] = Array [String](
        "BaseVoltage",
        "GroundingAction",
        "JumpingAction",
        "Outage",
        "ProtectionEquipments",
        "ProtectiveActionAdjustment",
        "SvStatus",
        "Terminals"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("BaseVoltage", "BaseVoltage", "0..1", "0..*"),
        CIMRelationship ("GroundingAction", "GroundAction", "0..1", "0..1"),
        CIMRelationship ("JumpingAction", "JumperAction", "0..1", "0..*"),
        CIMRelationship ("Outage", "Outage", "0..1", "0..*"),
        CIMRelationship ("ProtectionEquipments", "ProtectionEquipment", "0..*", "0..*"),
        CIMRelationship ("ProtectiveActionAdjustment", "ProtectiveActionAdjustment", "0..*", "1"),
        CIMRelationship ("SvStatus", "SvStatus", "0..*", "1"),
        CIMRelationship ("Terminals", "Terminal", "0..*", "1")
    )
    val BaseVoltage: Fielder = parse_attribute (attribute (cls, fields (0)))
    val GroundingAction: Fielder = parse_attribute (attribute (cls, fields (1)))
    val JumpingAction: Fielder = parse_attribute (attribute (cls, fields (2)))
    val Outage: Fielder = parse_attribute (attribute (cls, fields (3)))
    val ProtectionEquipments: FielderMultiple = parse_attributes (attribute (cls, fields (4)))
    val ProtectiveActionAdjustment: FielderMultiple = parse_attributes (attribute (cls, fields (5)))
    val SvStatus: FielderMultiple = parse_attributes (attribute (cls, fields (6)))
    val Terminals: FielderMultiple = parse_attributes (attribute (cls, fields (7)))

    def parse (context: CIMContext): ConductingEquipment =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = ConductingEquipment (
            Equipment.parse (context),
            mask (BaseVoltage (), 0),
            mask (GroundingAction (), 1),
            mask (JumpingAction (), 2),
            mask (Outage (), 3),
            masks (ProtectionEquipments (), 4),
            masks (ProtectiveActionAdjustment (), 5),
            masks (SvStatus (), 6),
            masks (Terminals (), 7)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ConductingEquipment] = ConductingEquipmentSerializer
}

object ConductingEquipmentSerializer extends CIMSerializer[ConductingEquipment]
{
    def write (kryo: Kryo, output: Output, obj: ConductingEquipment): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.BaseVoltage),
            () => output.writeString (obj.GroundingAction),
            () => output.writeString (obj.JumpingAction),
            () => output.writeString (obj.Outage),
            () => writeList (obj.ProtectionEquipments, output),
            () => writeList (obj.ProtectiveActionAdjustment, output),
            () => writeList (obj.SvStatus, output),
            () => writeList (obj.Terminals, output)
        )
        EquipmentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ConductingEquipment]): ConductingEquipment =
    {
        val parent = EquipmentSerializer.read (kryo, input, classOf [Equipment])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ConductingEquipment (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) readList (input) else null,
            if (isSet (5)) readList (input) else null,
            if (isSet (6)) readList (input) else null,
            if (isSet (7)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Connectivity nodes are points where terminals of AC conducting equipment are connected together with zero impedance.
 *
 * @param IdentifiedObject          [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param ConnectivityNodeContainer [[ch.ninecode.model.ConnectivityNodeContainer ConnectivityNodeContainer]] Container of this connectivity node.
 * @param Terminals                 [[ch.ninecode.model.Terminal Terminal]] Terminals interconnected with zero impedance at a this connectivity node.
 * @param TopologicalNode           [[ch.ninecode.model.TopologicalNode TopologicalNode]] The topological node to which this connectivity node is assigned.
 *                                  May depend on the current state of switches in the network.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
final case class ConnectivityNode
(
    IdentifiedObject: IdentifiedObject = null,
    ConnectivityNodeContainer: String = null,
    Terminals: List[String] = null,
    TopologicalNode: String = null
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
        implicit val clz: String = ConnectivityNode.cls

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ConnectivityNode.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ConnectivityNode.fields (position), x))

        emitattr (0, ConnectivityNodeContainer)
        emitattrs (1, Terminals)
        emitattr (2, TopologicalNode)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ConnectivityNode rdf:ID=\"%s\">\n%s\t</cim:ConnectivityNode>".format (id, export_fields)
    }
}

object ConnectivityNode
    extends
        CIMParseable[ConnectivityNode]
{
    override val fields: Array[String] = Array [String](
        "ConnectivityNodeContainer",
        "Terminals",
        "TopologicalNode"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ConnectivityNodeContainer", "ConnectivityNodeContainer", "1", "0..*"),
        CIMRelationship ("Terminals", "Terminal", "0..*", "0..1"),
        CIMRelationship ("TopologicalNode", "TopologicalNode", "0..1", "0..*")
    )
    val ConnectivityNodeContainer: Fielder = parse_attribute (attribute (cls, fields (0)))
    val Terminals: FielderMultiple = parse_attributes (attribute (cls, fields (1)))
    val TopologicalNode: Fielder = parse_attribute (attribute (cls, fields (2)))

    def parse (context: CIMContext): ConnectivityNode =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = ConnectivityNode (
            IdentifiedObject.parse (context),
            mask (ConnectivityNodeContainer (), 0),
            masks (Terminals (), 1),
            mask (TopologicalNode (), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ConnectivityNode] = ConnectivityNodeSerializer
}

object ConnectivityNodeSerializer extends CIMSerializer[ConnectivityNode]
{
    def write (kryo: Kryo, output: Output, obj: ConnectivityNode): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.ConnectivityNodeContainer),
            () => writeList (obj.Terminals, output),
            () => output.writeString (obj.TopologicalNode)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ConnectivityNode]): ConnectivityNode =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf [IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ConnectivityNode (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A base class for all objects that may contain connectivity nodes or topological nodes.
 *
 * @param PowerSystemResource [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param ConnectivityNodes   [[ch.ninecode.model.ConnectivityNode ConnectivityNode]] Connectivity nodes which belong to this connectivity node container.
 * @param TopologicalNode     [[ch.ninecode.model.TopologicalNode TopologicalNode]] The topological nodes which belong to this connectivity node container.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
final case class ConnectivityNodeContainer
(
    PowerSystemResource: PowerSystemResource = null,
    ConnectivityNodes: List[String] = null,
    TopologicalNode: List[String] = null
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
        implicit val clz: String = ConnectivityNodeContainer.cls

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ConnectivityNodeContainer.fields (position), x))

        emitattrs (0, ConnectivityNodes)
        emitattrs (1, TopologicalNode)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ConnectivityNodeContainer rdf:ID=\"%s\">\n%s\t</cim:ConnectivityNodeContainer>".format (id, export_fields)
    }
}

object ConnectivityNodeContainer
    extends
        CIMParseable[ConnectivityNodeContainer]
{
    override val fields: Array[String] = Array [String](
        "ConnectivityNodes",
        "TopologicalNode"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ConnectivityNodes", "ConnectivityNode", "0..*", "1"),
        CIMRelationship ("TopologicalNode", "TopologicalNode", "0..*", "0..1")
    )
    val ConnectivityNodes: FielderMultiple = parse_attributes (attribute (cls, fields (0)))
    val TopologicalNode: FielderMultiple = parse_attributes (attribute (cls, fields (1)))

    def parse (context: CIMContext): ConnectivityNodeContainer =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = ConnectivityNodeContainer (
            PowerSystemResource.parse (context),
            masks (ConnectivityNodes (), 0),
            masks (TopologicalNode (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ConnectivityNodeContainer] = ConnectivityNodeContainerSerializer
}

object ConnectivityNodeContainerSerializer extends CIMSerializer[ConnectivityNodeContainer]
{
    def write (kryo: Kryo, output: Output, obj: ConnectivityNodeContainer): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.ConnectivityNodes, output),
            () => writeList (obj.TopologicalNode, output)
        )
        PowerSystemResourceSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ConnectivityNodeContainer]): ConnectivityNodeContainer =
    {
        val parent = PowerSystemResourceSerializer.read (kryo, input, classOf [PowerSystemResource])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ConnectivityNodeContainer (
            parent,
            if (isSet (0)) readList (input) else null,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A multi-purpose curve or functional relationship between an independent variable (X-axis) and dependent (Y-axis) variables.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param curveStyle       The style or shape of the curve.
 * @param xMultiplier      Multiplier for X-axis.
 * @param xUnit            The X-axis units of measure.
 * @param y1Multiplier     Multiplier for Y1-axis.
 * @param y1Unit           The Y1-axis units of measure.
 * @param y2Multiplier     Multiplier for Y2-axis.
 * @param y2Unit           The Y2-axis units of measure.
 * @param y3Multiplier     Multiplier for Y3-axis.
 * @param y3Unit           The Y3-axis units of measure.
 * @param CurveDatas       [[ch.ninecode.model.CurveData CurveData]] The point data values that define this curve.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
final case class Curve
(
    IdentifiedObject: IdentifiedObject = null,
    curveStyle: String = null,
    xMultiplier: String = null,
    xUnit: String = null,
    y1Multiplier: String = null,
    y1Unit: String = null,
    y2Multiplier: String = null,
    y2Unit: String = null,
    y3Multiplier: String = null,
    y3Unit: String = null,
    CurveDatas: List[String] = null
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
        implicit val clz: String = Curve.cls

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Curve.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Curve.fields (position), x))

        emitattr (0, curveStyle)
        emitattr (1, xMultiplier)
        emitattr (2, xUnit)
        emitattr (3, y1Multiplier)
        emitattr (4, y1Unit)
        emitattr (5, y2Multiplier)
        emitattr (6, y2Unit)
        emitattr (7, y3Multiplier)
        emitattr (8, y3Unit)
        emitattrs (9, CurveDatas)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:Curve rdf:ID=\"%s\">\n%s\t</cim:Curve>".format (id, export_fields)
    }
}

object Curve
    extends
        CIMParseable[Curve]
{
    override val fields: Array[String] = Array [String](
        "curveStyle",
        "xMultiplier",
        "xUnit",
        "y1Multiplier",
        "y1Unit",
        "y2Multiplier",
        "y2Unit",
        "y3Multiplier",
        "y3Unit",
        "CurveDatas"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("CurveDatas", "CurveData", "0..*", "1")
    )
    val curveStyle: Fielder = parse_attribute (attribute (cls, fields (0)))
    val xMultiplier: Fielder = parse_attribute (attribute (cls, fields (1)))
    val xUnit: Fielder = parse_attribute (attribute (cls, fields (2)))
    val y1Multiplier: Fielder = parse_attribute (attribute (cls, fields (3)))
    val y1Unit: Fielder = parse_attribute (attribute (cls, fields (4)))
    val y2Multiplier: Fielder = parse_attribute (attribute (cls, fields (5)))
    val y2Unit: Fielder = parse_attribute (attribute (cls, fields (6)))
    val y3Multiplier: Fielder = parse_attribute (attribute (cls, fields (7)))
    val y3Unit: Fielder = parse_attribute (attribute (cls, fields (8)))
    val CurveDatas: FielderMultiple = parse_attributes (attribute (cls, fields (9)))

    def parse (context: CIMContext): Curve =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = Curve (
            IdentifiedObject.parse (context),
            mask (curveStyle (), 0),
            mask (xMultiplier (), 1),
            mask (xUnit (), 2),
            mask (y1Multiplier (), 3),
            mask (y1Unit (), 4),
            mask (y2Multiplier (), 5),
            mask (y2Unit (), 6),
            mask (y3Multiplier (), 7),
            mask (y3Unit (), 8),
            masks (CurveDatas (), 9)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Curve] = CurveSerializer
}

object CurveSerializer extends CIMSerializer[Curve]
{
    def write (kryo: Kryo, output: Output, obj: Curve): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.curveStyle),
            () => output.writeString (obj.xMultiplier),
            () => output.writeString (obj.xUnit),
            () => output.writeString (obj.y1Multiplier),
            () => output.writeString (obj.y1Unit),
            () => output.writeString (obj.y2Multiplier),
            () => output.writeString (obj.y2Unit),
            () => output.writeString (obj.y3Multiplier),
            () => output.writeString (obj.y3Unit),
            () => writeList (obj.CurveDatas, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Curve]): Curve =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf [IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Curve (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) input.readString else null,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Multi-purpose data points for defining a curve.
 *
 * The use of this generic class is discouraged if a more specific class can be used to specify the X and Y axis values along with their specific data types.
 *
 * @param Element Reference to the superclass object.
 * @param xvalue  The data value of the X-axis variable,  depending on the X-axis units.
 * @param y1value The data value of the  first Y-axis variable, depending on the Y-axis units.
 * @param y2value The data value of the second Y-axis variable (if present), depending on the Y-axis units.
 * @param y3value The data value of the third Y-axis variable (if present), depending on the Y-axis units.
 * @param Curve   [[ch.ninecode.model.Curve Curve]] The curve of  this curve data point.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
final case class CurveData
(
    Element: BasicElement = null,
    xvalue: Double = 0.0,
    y1value: Double = 0.0,
    y2value: Double = 0.0,
    y3value: Double = 0.0,
    Curve: String = null
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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CurveData.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CurveData.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CurveData.fields (position), value)

        emitelem (0, xvalue)
        emitelem (1, y1value)
        emitelem (2, y2value)
        emitelem (3, y3value)
        emitattr (4, Curve)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:CurveData rdf:ID=\"%s\">\n%s\t</cim:CurveData>".format (id, export_fields)
    }
}

object CurveData
    extends
        CIMParseable[CurveData]
{
    override val fields: Array[String] = Array [String](
        "xvalue",
        "y1value",
        "y2value",
        "y3value",
        "Curve"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Curve", "Curve", "1", "0..*")
    )
    val xvalue: Fielder = parse_element (element (cls, fields (0)))
    val y1value: Fielder = parse_element (element (cls, fields (1)))
    val y2value: Fielder = parse_element (element (cls, fields (2)))
    val y3value: Fielder = parse_element (element (cls, fields (3)))
    val Curve: Fielder = parse_attribute (attribute (cls, fields (4)))

    def parse (context: CIMContext): CurveData =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = CurveData (
            BasicElement.parse (context),
            toDouble (mask (xvalue (), 0)),
            toDouble (mask (y1value (), 1)),
            toDouble (mask (y2value (), 2)),
            toDouble (mask (y3value (), 3)),
            mask (Curve (), 4)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[CurveData] = CurveDataSerializer
}

object CurveDataSerializer extends CIMSerializer[CurveData]
{
    def write (kryo: Kryo, output: Output, obj: CurveData): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.xvalue),
            () => output.writeDouble (obj.y1value),
            () => output.writeDouble (obj.y2value),
            () => output.writeDouble (obj.y3value),
            () => output.writeString (obj.Curve)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf [BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CurveData]): CurveData =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf [BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = CurveData (
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
 * The parts of a power system that are physical devices, electronic or mechanical.
 *
 * @param PowerSystemResource           [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param aggregate                     The aggregate flag provides an alternative way of representing an aggregated (equivalent) element.
 *                                      It is applicable in cases when the dedicated classes for equivalent equipment do not have all of the attributes necessary to represent the required level of detail.  In case the flag is set to “true” the single instance of equipment represents multiple pieces of equipment that have been modelled together as an aggregate equivalent obtained by a network reduction procedure. Examples would be power transformers or synchronous machines operating in parallel modelled as a single aggregate power transformer or aggregate synchronous machine.
 *                                      The attribute is not used for EquivalentBranch, EquivalentShunt and EquivalentInjection.
 * @param inService                     Specifies the availability of the equipment.
 *                                      True means the equipment is available for topology processing, which determines if the equipment is energized or not. False means that the equipment is treated by network applications as if it is not in the model.
 * @param networkAnalysisEnabled        The equipment is enabled to participate in network analysis.
 *                                      If unspecified, the value is assumed to be true.
 * @param normallyInService             Specifies the availability of the equipment under normal operating conditions.
 *                                      True means the equipment is available for topology processing, which determines if the equipment is energized or not. False means that the equipment is treated by network applications as if it is not in the model.
 * @param AdditionalEquipmentContainer  [[ch.ninecode.model.EquipmentContainer EquipmentContainer]] Additional equipment container beyond the primary equipment container.
 *                                      The equipment is contained in another equipment container, but also grouped with this equipment container.
 * @param ContingencyEquipment          [[ch.ninecode.model.ContingencyEquipment ContingencyEquipment]] The contingency equipments in which this equipment participates.
 * @param EqiupmentLimitSeriesComponent [[ch.ninecode.model.EquipmentLimitSeriesComponent EquipmentLimitSeriesComponent]] Equipment limit series calculation component to which this equipment contributes.
 * @param EquipmentContainer            [[ch.ninecode.model.EquipmentContainer EquipmentContainer]] Container of this equipment.
 * @param Faults                        [[ch.ninecode.model.Fault Fault]] All faults on this equipment.
 * @param LimitDependencyModel          [[ch.ninecode.model.LimitDependency LimitDependency]] Limit dependencymodels organized under this equipment as a means for organizing the model in a tree view.
 * @param OperationalLimitSet           [[ch.ninecode.model.OperationalLimitSet OperationalLimitSet]] The operational limit sets associated with this equipment.
 * @param OperationalRestrictions       [[ch.ninecode.model.OperationalRestriction OperationalRestriction]] All operational restrictions for this equipment.
 * @param Outages                       [[ch.ninecode.model.Outage Outage]] All outages in which this equipment is involved.
 * @param PinEquipment                  [[ch.ninecode.model.PinEquipment PinEquipment]] <em>undocumented</em>
 * @param ProtectiveActionEquipment     [[ch.ninecode.model.ProtectiveActionEquipment ProtectiveActionEquipment]] Protective action is controlling equipment.
 *                                      This can be direct signals from the control center, or emulation of action done by protection equipment.
 * @param UsagePoints                   [[ch.ninecode.model.UsagePoint UsagePoint]] All usage points connected to the electrical grid through this equipment.
 * @param WeatherStation                [[ch.ninecode.model.WeatherStation WeatherStation]] <em>undocumented</em>
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
final case class Equipment
(
    PowerSystemResource: PowerSystemResource = null,
    aggregate: Boolean = false,
    inService: Boolean = false,
    networkAnalysisEnabled: Boolean = false,
    normallyInService: Boolean = false,
    AdditionalEquipmentContainer: List[String] = null,
    ContingencyEquipment: List[String] = null,
    EqiupmentLimitSeriesComponent: List[String] = null,
    EquipmentContainer: String = null,
    Faults: List[String] = null,
    LimitDependencyModel: List[String] = null,
    OperationalLimitSet: List[String] = null,
    OperationalRestrictions: List[String] = null,
    Outages: List[String] = null,
    PinEquipment: List[String] = null,
    ProtectiveActionEquipment: List[String] = null,
    UsagePoints: List[String] = null,
    WeatherStation: List[String] = null
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
        implicit val clz: String = Equipment.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Equipment.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Equipment.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Equipment.fields (position), x))

        emitelem (0, aggregate)
        emitelem (1, inService)
        emitelem (2, networkAnalysisEnabled)
        emitelem (3, normallyInService)
        emitattrs (4, AdditionalEquipmentContainer)
        emitattrs (5, ContingencyEquipment)
        emitattrs (6, EqiupmentLimitSeriesComponent)
        emitattr (7, EquipmentContainer)
        emitattrs (8, Faults)
        emitattrs (9, LimitDependencyModel)
        emitattrs (10, OperationalLimitSet)
        emitattrs (11, OperationalRestrictions)
        emitattrs (12, Outages)
        emitattrs (13, PinEquipment)
        emitattrs (14, ProtectiveActionEquipment)
        emitattrs (15, UsagePoints)
        emitattrs (16, WeatherStation)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:Equipment rdf:ID=\"%s\">\n%s\t</cim:Equipment>".format (id, export_fields)
    }
}

object Equipment
    extends
        CIMParseable[Equipment]
{
    override val fields: Array[String] = Array [String](
        "aggregate",
        "inService",
        "networkAnalysisEnabled",
        "normallyInService",
        "AdditionalEquipmentContainer",
        "ContingencyEquipment",
        "EqiupmentLimitSeriesComponent",
        "EquipmentContainer",
        "Faults",
        "LimitDependencyModel",
        "OperationalLimitSet",
        "OperationalRestrictions",
        "Outages",
        "PinEquipment",
        "ProtectiveActionEquipment",
        "UsagePoints",
        "WeatherStation"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AdditionalEquipmentContainer", "EquipmentContainer", "0..*", "0..*"),
        CIMRelationship ("ContingencyEquipment", "ContingencyEquipment", "0..*", "1"),
        CIMRelationship ("EqiupmentLimitSeriesComponent", "EquipmentLimitSeriesComponent", "0..*", "1"),
        CIMRelationship ("EquipmentContainer", "EquipmentContainer", "0..1", "0..*"),
        CIMRelationship ("Faults", "Fault", "0..*", "0..1"),
        CIMRelationship ("LimitDependencyModel", "LimitDependency", "0..*", "0..1"),
        CIMRelationship ("OperationalLimitSet", "OperationalLimitSet", "0..*", "0..1"),
        CIMRelationship ("OperationalRestrictions", "OperationalRestriction", "0..*", "0..*"),
        CIMRelationship ("Outages", "Outage", "0..*", "0..*"),
        CIMRelationship ("PinEquipment", "PinEquipment", "0..*", "1"),
        CIMRelationship ("ProtectiveActionEquipment", "ProtectiveActionEquipment", "0..*", "1"),
        CIMRelationship ("UsagePoints", "UsagePoint", "0..*", "0..*"),
        CIMRelationship ("WeatherStation", "WeatherStation", "0..*", "0..*")
    )
    val aggregate: Fielder = parse_element (element (cls, fields (0)))
    val inService: Fielder = parse_element (element (cls, fields (1)))
    val networkAnalysisEnabled: Fielder = parse_element (element (cls, fields (2)))
    val normallyInService: Fielder = parse_element (element (cls, fields (3)))
    val AdditionalEquipmentContainer: FielderMultiple = parse_attributes (attribute (cls, fields (4)))
    val ContingencyEquipment: FielderMultiple = parse_attributes (attribute (cls, fields (5)))
    val EqiupmentLimitSeriesComponent: FielderMultiple = parse_attributes (attribute (cls, fields (6)))
    val EquipmentContainer: Fielder = parse_attribute (attribute (cls, fields (7)))
    val Faults: FielderMultiple = parse_attributes (attribute (cls, fields (8)))
    val LimitDependencyModel: FielderMultiple = parse_attributes (attribute (cls, fields (9)))
    val OperationalLimitSet: FielderMultiple = parse_attributes (attribute (cls, fields (10)))
    val OperationalRestrictions: FielderMultiple = parse_attributes (attribute (cls, fields (11)))
    val Outages: FielderMultiple = parse_attributes (attribute (cls, fields (12)))
    val PinEquipment: FielderMultiple = parse_attributes (attribute (cls, fields (13)))
    val ProtectiveActionEquipment: FielderMultiple = parse_attributes (attribute (cls, fields (14)))
    val UsagePoints: FielderMultiple = parse_attributes (attribute (cls, fields (15)))
    val WeatherStation: FielderMultiple = parse_attributes (attribute (cls, fields (16)))

    def parse (context: CIMContext): Equipment =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = Equipment (
            PowerSystemResource.parse (context),
            toBoolean (mask (aggregate (), 0)),
            toBoolean (mask (inService (), 1)),
            toBoolean (mask (networkAnalysisEnabled (), 2)),
            toBoolean (mask (normallyInService (), 3)),
            masks (AdditionalEquipmentContainer (), 4),
            masks (ContingencyEquipment (), 5),
            masks (EqiupmentLimitSeriesComponent (), 6),
            mask (EquipmentContainer (), 7),
            masks (Faults (), 8),
            masks (LimitDependencyModel (), 9),
            masks (OperationalLimitSet (), 10),
            masks (OperationalRestrictions (), 11),
            masks (Outages (), 12),
            masks (PinEquipment (), 13),
            masks (ProtectiveActionEquipment (), 14),
            masks (UsagePoints (), 15),
            masks (WeatherStation (), 16)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Equipment] = EquipmentSerializer
}

object EquipmentSerializer extends CIMSerializer[Equipment]
{
    def write (kryo: Kryo, output: Output, obj: Equipment): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeBoolean (obj.aggregate),
            () => output.writeBoolean (obj.inService),
            () => output.writeBoolean (obj.networkAnalysisEnabled),
            () => output.writeBoolean (obj.normallyInService),
            () => writeList (obj.AdditionalEquipmentContainer, output),
            () => writeList (obj.ContingencyEquipment, output),
            () => writeList (obj.EqiupmentLimitSeriesComponent, output),
            () => output.writeString (obj.EquipmentContainer),
            () => writeList (obj.Faults, output),
            () => writeList (obj.LimitDependencyModel, output),
            () => writeList (obj.OperationalLimitSet, output),
            () => writeList (obj.OperationalRestrictions, output),
            () => writeList (obj.Outages, output),
            () => writeList (obj.PinEquipment, output),
            () => writeList (obj.ProtectiveActionEquipment, output),
            () => writeList (obj.UsagePoints, output),
            () => writeList (obj.WeatherStation, output)
        )
        PowerSystemResourceSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Equipment]): Equipment =
    {
        val parent = PowerSystemResourceSerializer.read (kryo, input, classOf [PowerSystemResource])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Equipment (
            parent,
            if (isSet (0)) input.readBoolean else false,
            if (isSet (1)) input.readBoolean else false,
            if (isSet (2)) input.readBoolean else false,
            if (isSet (3)) input.readBoolean else false,
            if (isSet (4)) readList (input) else null,
            if (isSet (5)) readList (input) else null,
            if (isSet (6)) readList (input) else null,
            if (isSet (7)) input.readString else null,
            if (isSet (8)) readList (input) else null,
            if (isSet (9)) readList (input) else null,
            if (isSet (10)) readList (input) else null,
            if (isSet (11)) readList (input) else null,
            if (isSet (12)) readList (input) else null,
            if (isSet (13)) readList (input) else null,
            if (isSet (14)) readList (input) else null,
            if (isSet (15)) readList (input) else null,
            if (isSet (16)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A modelling construct to provide a root class for containing equipment.
 *
 * @param ConnectivityNodeContainer  [[ch.ninecode.model.ConnectivityNodeContainer ConnectivityNodeContainer]] Reference to the superclass object.
 * @param AdditionalGroupedEquipment [[ch.ninecode.model.Equipment Equipment]] The additonal contained equipment.
 *                                   The equipment belong to the equipment container. The equipment is contained in another equipment container, but also grouped with this equipment container.  Examples include when a switch contained in a substation is also desired to be grouped with a line contianer or when a switch is included in a secondary substation and also grouped in a feeder.
 * @param Equipments                 [[ch.ninecode.model.Equipment Equipment]] Contained equipment.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
final case class EquipmentContainer
(
    ConnectivityNodeContainer: ConnectivityNodeContainer = null,
    AdditionalGroupedEquipment: List[String] = null,
    Equipments: List[String] = null
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
    override def sup: ConnectivityNodeContainer = ConnectivityNodeContainer

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
        implicit val clz: String = EquipmentContainer.cls

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (EquipmentContainer.fields (position), x))

        emitattrs (0, AdditionalGroupedEquipment)
        emitattrs (1, Equipments)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:EquipmentContainer rdf:ID=\"%s\">\n%s\t</cim:EquipmentContainer>".format (id, export_fields)
    }
}

object EquipmentContainer
    extends
        CIMParseable[EquipmentContainer]
{
    override val fields: Array[String] = Array [String](
        "AdditionalGroupedEquipment",
        "Equipments"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AdditionalGroupedEquipment", "Equipment", "0..*", "0..*"),
        CIMRelationship ("Equipments", "Equipment", "0..*", "0..1")
    )
    val AdditionalGroupedEquipment: FielderMultiple = parse_attributes (attribute (cls, fields (0)))
    val Equipments: FielderMultiple = parse_attributes (attribute (cls, fields (1)))

    def parse (context: CIMContext): EquipmentContainer =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = EquipmentContainer (
            ConnectivityNodeContainer.parse (context),
            masks (AdditionalGroupedEquipment (), 0),
            masks (Equipments (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[EquipmentContainer] = EquipmentContainerSerializer
}

object EquipmentContainerSerializer extends CIMSerializer[EquipmentContainer]
{
    def write (kryo: Kryo, output: Output, obj: EquipmentContainer): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.AdditionalGroupedEquipment, output),
            () => writeList (obj.Equipments, output)
        )
        ConnectivityNodeContainerSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[EquipmentContainer]): EquipmentContainer =
    {
        val parent = ConnectivityNodeContainerSerializer.read (kryo, input, classOf [ConnectivityNodeContainer])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = EquipmentContainer (
            parent,
            if (isSet (0)) readList (input) else null,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A collection of equipment for organizational purposes, used for grouping distribution resources.
 *
 * The organization a feeder does not necessarily reflect connectivity or current operation state.
 *
 * @param EquipmentContainer         [[ch.ninecode.model.EquipmentContainer EquipmentContainer]] Reference to the superclass object.
 * @param NamingSecondarySubstation  [[ch.ninecode.model.Substation Substation]] The secondary substations that are normally energized from the feeder.
 *                                   Used for naming purposes.   Should be consistent with the other associations for energizing terminal specification and the feeder energization specification.
 * @param NormalEnergizedSubstation  [[ch.ninecode.model.Substation Substation]] The substations that are normally energized by the feeder.
 * @param NormalEnergizingSubstation [[ch.ninecode.model.Substation Substation]] The substation that nominally energizes the feeder.
 *                                   Also used for naming purposes.
 * @param NormalHeadTerminal         [[ch.ninecode.model.Terminal Terminal]] The normal head terminal or terminals of the feeder.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
final case class Feeder
(
    EquipmentContainer: EquipmentContainer = null,
    NamingSecondarySubstation: List[String] = null,
    NormalEnergizedSubstation: List[String] = null,
    NormalEnergizingSubstation: String = null,
    NormalHeadTerminal: List[String] = null
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
    override def sup: EquipmentContainer = EquipmentContainer

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
        implicit val clz: String = Feeder.cls

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Feeder.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Feeder.fields (position), x))

        emitattrs (0, NamingSecondarySubstation)
        emitattrs (1, NormalEnergizedSubstation)
        emitattr (2, NormalEnergizingSubstation)
        emitattrs (3, NormalHeadTerminal)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:Feeder rdf:ID=\"%s\">\n%s\t</cim:Feeder>".format (id, export_fields)
    }
}

object Feeder
    extends
        CIMParseable[Feeder]
{
    override val fields: Array[String] = Array [String](
        "NamingSecondarySubstation",
        "NormalEnergizedSubstation",
        "NormalEnergizingSubstation",
        "NormalHeadTerminal"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("NamingSecondarySubstation", "Substation", "0..*", "0..1"),
        CIMRelationship ("NormalEnergizedSubstation", "Substation", "0..*", "0..*"),
        CIMRelationship ("NormalEnergizingSubstation", "Substation", "0..1", "0..*"),
        CIMRelationship ("NormalHeadTerminal", "Terminal", "1..*", "0..1")
    )
    val NamingSecondarySubstation: FielderMultiple = parse_attributes (attribute (cls, fields (0)))
    val NormalEnergizedSubstation: FielderMultiple = parse_attributes (attribute (cls, fields (1)))
    val NormalEnergizingSubstation: Fielder = parse_attribute (attribute (cls, fields (2)))
    val NormalHeadTerminal: FielderMultiple = parse_attributes (attribute (cls, fields (3)))

    def parse (context: CIMContext): Feeder =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = Feeder (
            EquipmentContainer.parse (context),
            masks (NamingSecondarySubstation (), 0),
            masks (NormalEnergizedSubstation (), 1),
            mask (NormalEnergizingSubstation (), 2),
            masks (NormalHeadTerminal (), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Feeder] = FeederSerializer
}

object FeederSerializer extends CIMSerializer[Feeder]
{
    def write (kryo: Kryo, output: Output, obj: Feeder): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.NamingSecondarySubstation, output),
            () => writeList (obj.NormalEnergizedSubstation, output),
            () => output.writeString (obj.NormalEnergizingSubstation),
            () => writeList (obj.NormalHeadTerminal, output)
        )
        EquipmentContainerSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Feeder]): Feeder =
    {
        val parent = EquipmentContainerSerializer.read (kryo, input, classOf [EquipmentContainer])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Feeder (
            parent,
            if (isSet (0)) readList (input) else null,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A geographical region of a power system network model.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param Regions          [[ch.ninecode.model.SubGeographicalRegion SubGeographicalRegion]] All sub-geographical regions within this geographical region.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
final case class GeographicalRegion
(
    IdentifiedObject: IdentifiedObject = null,
    Regions: List[String] = null
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
        implicit val clz: String = GeographicalRegion.cls

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (GeographicalRegion.fields (position), x))

        emitattrs (0, Regions)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:GeographicalRegion rdf:ID=\"%s\">\n%s\t</cim:GeographicalRegion>".format (id, export_fields)
    }
}

object GeographicalRegion
    extends
        CIMParseable[GeographicalRegion]
{
    override val fields: Array[String] = Array [String](
        "Regions"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Regions", "SubGeographicalRegion", "0..*", "0..1")
    )
    val Regions: FielderMultiple = parse_attributes (attribute (cls, fields (0)))

    def parse (context: CIMContext): GeographicalRegion =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = GeographicalRegion (
            IdentifiedObject.parse (context),
            masks (Regions (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[GeographicalRegion] = GeographicalRegionSerializer
}

object GeographicalRegionSerializer extends CIMSerializer[GeographicalRegion]
{
    def write (kryo: Kryo, output: Output, obj: GeographicalRegion): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.Regions, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[GeographicalRegion]): GeographicalRegion =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf [IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = GeographicalRegion (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * This is a root class to provide common identification for all classes needing identification and naming attributes.
 *
 * @param Element                 Reference to the superclass object.
 * @param aliasName               The aliasName is free text human readable name of the object alternative to IdentifiedObject.name.
 *                                It may be non unique and may not correlate to a naming hierarchy.
 *                                The attribute aliasName is retained because of backwards compatibility between CIM relases. It is however recommended to replace aliasName with the Name class as aliasName is planned for retirement at a future time.
 * @param description             The description is a free human readable text describing or naming the object.
 *                                It may be non unique and may not correlate to a naming hierarchy.
 * @param mRID                    Master resource identifier issued by a model authority.
 *                                The mRID is unique within an exchange context. Global uniqueness is easily achieved by using a UUID, as specified in RFC 4122, for the mRID. The use of UUID is strongly recommended.
 *                                For CIMXML data files in RDF syntax conforming to IEC 61970-552, the mRID is mapped to rdf:ID or rdf:about attributes that identify CIM object elements.
 * @param name                    The name is any free human readable and possibly non unique text naming the object.
 * @param DiagramObjects          [[ch.ninecode.model.DiagramObject DiagramObject]] The diagram objects that are associated with the domain object.
 * @param InstanceSet             [[ch.ninecode.model.InstanceSet InstanceSet]] Dataset containing the data objects.
 * @param Names                   [[ch.ninecode.model.Name Name]] All names of this identified object.
 * @param PropertiesCIMDataObject [[ch.ninecode.model.ChangeSetMember ChangeSetMember]] The single CIM data object in the appropriate dataset context.
 * @param TargetingCIMDataObject  [[ch.ninecode.model.ChangeSetMember ChangeSetMember]] Data objects registered.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
final case class IdentifiedObject
(
    Element: BasicElement = null,
    aliasName: String = null,
    description: String = null,
    mRID: String = null,
    name: String = null,
    DiagramObjects: List[String] = null,
    InstanceSet: String = null,
    Names: List[String] = null,
    PropertiesCIMDataObject: String = null,
    TargetingCIMDataObject: List[String] = null
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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = IdentifiedObject.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (IdentifiedObject.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (IdentifiedObject.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (IdentifiedObject.fields (position), x))

        emitelem (0, aliasName)
        emitelem (1, description)
        emitelem (2, mRID)
        emitelem (3, name)
        emitattrs (4, DiagramObjects)
        emitattr (5, InstanceSet)
        emitattrs (6, Names)
        emitattr (7, PropertiesCIMDataObject)
        emitattrs (8, TargetingCIMDataObject)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:IdentifiedObject rdf:ID=\"%s\">\n%s\t</cim:IdentifiedObject>".format (id, export_fields)
    }
}

object IdentifiedObject
    extends
        CIMParseable[IdentifiedObject]
{
    override val fields: Array[String] = Array [String](
        "aliasName",
        "description",
        "mRID",
        "name",
        "DiagramObjects",
        "InstanceSet",
        "Names",
        "PropertiesCIMDataObject",
        "TargetingCIMDataObject"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("DiagramObjects", "DiagramObject", "0..*", "0..1"),
        CIMRelationship ("InstanceSet", "InstanceSet", "1", "0..*"),
        CIMRelationship ("Names", "Name", "0..*", "1"),
        CIMRelationship ("PropertiesCIMDataObject", "ChangeSetMember", "0..1", "0..1"),
        CIMRelationship ("TargetingCIMDataObject", "ChangeSetMember", "0..*", "1")
    )
    val aliasName: Fielder = parse_element (element (cls, fields (0)))
    val description: Fielder = parse_element (element (cls, fields (1)))
    val mRID: Fielder = parse_element (element (cls, fields (2)))
    val name: Fielder = parse_element (element (cls, fields (3)))
    val DiagramObjects: FielderMultiple = parse_attributes (attribute (cls, fields (4)))
    val InstanceSet: Fielder = parse_attribute (attribute (cls, fields (5)))
    val Names: FielderMultiple = parse_attributes (attribute (cls, fields (6)))
    val PropertiesCIMDataObject: Fielder = parse_attribute (attribute (cls, fields (7)))
    val TargetingCIMDataObject: FielderMultiple = parse_attributes (attribute (cls, fields (8)))

    def parse (context: CIMContext): IdentifiedObject =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val base = BasicElement.parse (context)
        val ret = IdentifiedObject (
            base,
            mask (aliasName (), 0),
            mask (description (), 1),
            {
                val _ = mask (mRID (), 2); base.id
            },
            mask (name (), 3),
            masks (DiagramObjects (), 4),
            mask (InstanceSet (), 5),
            masks (Names (), 6),
            mask (PropertiesCIMDataObject (), 7),
            masks (TargetingCIMDataObject (), 8)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[IdentifiedObject] = IdentifiedObjectSerializer
}

object IdentifiedObjectSerializer extends CIMSerializer[IdentifiedObject]
{
    def write (kryo: Kryo, output: Output, obj: IdentifiedObject): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.aliasName),
            () => output.writeString (obj.description),
            () => Unit,
            () => output.writeString (obj.name),
            () => writeList (obj.DiagramObjects, output),
            () => output.writeString (obj.InstanceSet),
            () => writeList (obj.Names, output),
            () => output.writeString (obj.PropertiesCIMDataObject),
            () => writeList (obj.TargetingCIMDataObject, output)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf [BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[IdentifiedObject]): IdentifiedObject =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf [BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = IdentifiedObject (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            parent.mRID,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) readList (input) else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) readList (input) else null,
            if (isSet (7)) input.readString else null,
            if (isSet (8)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The schedule has time points where the time between them varies.
 *
 * @param BasicIntervalSchedule [[ch.ninecode.model.BasicIntervalSchedule BasicIntervalSchedule]] Reference to the superclass object.
 * @param TimePoints            [[ch.ninecode.model.IrregularTimePoint IrregularTimePoint]] The point data values that define a curve.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
final case class IrregularIntervalSchedule
(
    BasicIntervalSchedule: BasicIntervalSchedule = null,
    TimePoints: List[String] = null
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
    override def sup: BasicIntervalSchedule = BasicIntervalSchedule

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
        implicit val clz: String = IrregularIntervalSchedule.cls

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (IrregularIntervalSchedule.fields (position), x))

        emitattrs (0, TimePoints)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:IrregularIntervalSchedule rdf:ID=\"%s\">\n%s\t</cim:IrregularIntervalSchedule>".format (id, export_fields)
    }
}

object IrregularIntervalSchedule
    extends
        CIMParseable[IrregularIntervalSchedule]
{
    override val fields: Array[String] = Array [String](
        "TimePoints"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("TimePoints", "IrregularTimePoint", "1..*", "1")
    )
    val TimePoints: FielderMultiple = parse_attributes (attribute (cls, fields (0)))

    def parse (context: CIMContext): IrregularIntervalSchedule =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = IrregularIntervalSchedule (
            BasicIntervalSchedule.parse (context),
            masks (TimePoints (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[IrregularIntervalSchedule] = IrregularIntervalScheduleSerializer
}

object IrregularIntervalScheduleSerializer extends CIMSerializer[IrregularIntervalSchedule]
{
    def write (kryo: Kryo, output: Output, obj: IrregularIntervalSchedule): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.TimePoints, output)
        )
        BasicIntervalScheduleSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[IrregularIntervalSchedule]): IrregularIntervalSchedule =
    {
        val parent = BasicIntervalScheduleSerializer.read (kryo, input, classOf [BasicIntervalSchedule])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = IrregularIntervalSchedule (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * TimePoints for a schedule where the time between the points varies.
 *
 * @param Element          Reference to the superclass object.
 * @param time             The time is relative to the schedule starting time.
 * @param value1           The first value at the time.
 *                         The meaning of the value is defined by the derived type of the associated schedule.
 * @param value2           The second value at the time.
 *                         The meaning of the value is defined by the derived type of the associated schedule.
 * @param IntervalSchedule [[ch.ninecode.model.IrregularIntervalSchedule IrregularIntervalSchedule]] An IrregularTimePoint belongs to an IrregularIntervalSchedule.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
final case class IrregularTimePoint
(
    Element: BasicElement = null,
    time: Double = 0.0,
    value1: Double = 0.0,
    value2: Double = 0.0,
    IntervalSchedule: String = null
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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = IrregularTimePoint.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (IrregularTimePoint.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (IrregularTimePoint.fields (position), value)

        emitelem (0, time)
        emitelem (1, value1)
        emitelem (2, value2)
        emitattr (3, IntervalSchedule)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:IrregularTimePoint rdf:ID=\"%s\">\n%s\t</cim:IrregularTimePoint>".format (id, export_fields)
    }
}

object IrregularTimePoint
    extends
        CIMParseable[IrregularTimePoint]
{
    override val fields: Array[String] = Array [String](
        "time",
        "value1",
        "value2",
        "IntervalSchedule"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("IntervalSchedule", "IrregularIntervalSchedule", "1", "1..*")
    )
    val time: Fielder = parse_element (element (cls, fields (0)))
    val value1: Fielder = parse_element (element (cls, fields (1)))
    val value2: Fielder = parse_element (element (cls, fields (2)))
    val IntervalSchedule: Fielder = parse_attribute (attribute (cls, fields (3)))

    def parse (context: CIMContext): IrregularTimePoint =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = IrregularTimePoint (
            BasicElement.parse (context),
            toDouble (mask (time (), 0)),
            toDouble (mask (value1 (), 1)),
            toDouble (mask (value2 (), 2)),
            mask (IntervalSchedule (), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[IrregularTimePoint] = IrregularTimePointSerializer
}

object IrregularTimePointSerializer extends CIMSerializer[IrregularTimePoint]
{
    def write (kryo: Kryo, output: Output, obj: IrregularTimePoint): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.time),
            () => output.writeDouble (obj.value1),
            () => output.writeDouble (obj.value2),
            () => output.writeString (obj.IntervalSchedule)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf [BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[IrregularTimePoint]): IrregularTimePoint =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf [BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = IrregularTimePoint (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The Name class provides the means to define any number of human readable  names for an object.
 *
 * A name is <b>not</b> to be used for defining inter-object relationships. For inter-object relationships instead use the object identification 'mRID'.
 *
 * @param Element          Reference to the superclass object.
 * @param name             Any free text that name the object.
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Identified object that this name designates.
 * @param NameType         [[ch.ninecode.model.NameType NameType]] Type of this name.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
final case class Name
(
    Element: BasicElement = null,
    name: String = null,
    IdentifiedObject: String = null,
    NameType: String = null
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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Name.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Name.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Name.fields (position), value)

        emitelem (0, name)
        emitattr (1, IdentifiedObject)
        emitattr (2, NameType)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:Name rdf:ID=\"%s\">\n%s\t</cim:Name>".format (id, export_fields)
    }
}

object Name
    extends
        CIMParseable[Name]
{
    override val fields: Array[String] = Array [String](
        "name",
        "IdentifiedObject",
        "NameType"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("IdentifiedObject", "IdentifiedObject", "1", "0..*"),
        CIMRelationship ("NameType", "NameType", "1", "0..*")
    )
    val name: Fielder = parse_element (element (cls, fields (0)))
    val IdentifiedObject: Fielder = parse_attribute (attribute (cls, fields (1)))
    val NameType: Fielder = parse_attribute (attribute (cls, fields (2)))

    def parse (context: CIMContext): Name =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = Name (
            BasicElement.parse (context),
            mask (name (), 0),
            mask (IdentifiedObject (), 1),
            mask (NameType (), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Name] = NameSerializer
}

object NameSerializer extends CIMSerializer[Name]
{
    def write (kryo: Kryo, output: Output, obj: Name): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.name),
            () => output.writeString (obj.IdentifiedObject),
            () => output.writeString (obj.NameType)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf [BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Name]): Name =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf [BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Name (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Type of name.
 *
 * Possible values for attribute 'name' are implementation dependent but standard profiles may specify types. An enterprise may have multiple IT systems each having its own local name for the same object, e.g. a planning system may have different names from an EMS. An object may also have different names within the same IT system, e.g. localName as defined in CIM version 14. The definition from CIM14 is:
 * The localName is a human readable name of the object. It is a free text name local to a node in a naming hierarchy similar to a file directory structure. A power system related naming hierarchy may be: Substation, VoltageLevel, Equipment etc. Children of the same parent in such a hierarchy have names that typically are unique among them.
 *
 * @param Element           Reference to the superclass object.
 * @param description       Description of the name type.
 * @param name              Name of the name type.
 * @param NameTypeAuthority [[ch.ninecode.model.NameTypeAuthority NameTypeAuthority]] Authority responsible for managing names of this type.
 * @param Names             [[ch.ninecode.model.Name Name]] All names of this type.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
final case class NameType
(
    Element: BasicElement = null,
    description: String = null,
    name: String = null,
    NameTypeAuthority: String = null,
    Names: List[String] = null
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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = NameType.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (NameType.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (NameType.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (NameType.fields (position), x))

        emitelem (0, description)
        emitelem (1, name)
        emitattr (2, NameTypeAuthority)
        emitattrs (3, Names)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:NameType rdf:ID=\"%s\">\n%s\t</cim:NameType>".format (id, export_fields)
    }
}

object NameType
    extends
        CIMParseable[NameType]
{
    override val fields: Array[String] = Array [String](
        "description",
        "name",
        "NameTypeAuthority",
        "Names"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("NameTypeAuthority", "NameTypeAuthority", "0..1", "0..*"),
        CIMRelationship ("Names", "Name", "0..*", "1")
    )
    val description: Fielder = parse_element (element (cls, fields (0)))
    val name: Fielder = parse_element (element (cls, fields (1)))
    val NameTypeAuthority: Fielder = parse_attribute (attribute (cls, fields (2)))
    val Names: FielderMultiple = parse_attributes (attribute (cls, fields (3)))

    def parse (context: CIMContext): NameType =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = NameType (
            BasicElement.parse (context),
            mask (description (), 0),
            mask (name (), 1),
            mask (NameTypeAuthority (), 2),
            masks (Names (), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[NameType] = NameTypeSerializer
}

object NameTypeSerializer extends CIMSerializer[NameType]
{
    def write (kryo: Kryo, output: Output, obj: NameType): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.description),
            () => output.writeString (obj.name),
            () => output.writeString (obj.NameTypeAuthority),
            () => writeList (obj.Names, output)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf [BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[NameType]): NameType =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf [BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = NameType (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Authority responsible for creation and management of names of a given type; typically an organization or an enterprise system.
 *
 * @param Element     Reference to the superclass object.
 * @param description Description of the name type authority.
 * @param name        Name of the name type authority.
 * @param NameTypes   [[ch.ninecode.model.NameType NameType]] All name types managed by this authority.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
final case class NameTypeAuthority
(
    Element: BasicElement = null,
    description: String = null,
    name: String = null,
    NameTypes: List[String] = null
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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = NameTypeAuthority.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (NameTypeAuthority.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (NameTypeAuthority.fields (position), x))

        emitelem (0, description)
        emitelem (1, name)
        emitattrs (2, NameTypes)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:NameTypeAuthority rdf:ID=\"%s\">\n%s\t</cim:NameTypeAuthority>".format (id, export_fields)
    }
}

object NameTypeAuthority
    extends
        CIMParseable[NameTypeAuthority]
{
    override val fields: Array[String] = Array [String](
        "description",
        "name",
        "NameTypes"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("NameTypes", "NameType", "0..*", "0..1")
    )
    val description: Fielder = parse_element (element (cls, fields (0)))
    val name: Fielder = parse_element (element (cls, fields (1)))
    val NameTypes: FielderMultiple = parse_attributes (attribute (cls, fields (2)))

    def parse (context: CIMContext): NameTypeAuthority =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = NameTypeAuthority (
            BasicElement.parse (context),
            mask (description (), 0),
            mask (name (), 1),
            masks (NameTypes (), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[NameTypeAuthority] = NameTypeAuthoritySerializer
}

object NameTypeAuthoritySerializer extends CIMSerializer[NameTypeAuthority]
{
    def write (kryo: Kryo, output: Output, obj: NameTypeAuthority): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.description),
            () => output.writeString (obj.name),
            () => writeList (obj.NameTypes, output)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf [BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[NameTypeAuthority]): NameTypeAuthority =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf [BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = NameTypeAuthority (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * An operator of multiple power system resource objects.
 *
 * Note multple operating participants may operate the same power system resource object.   This can be used for modeling jointly owned units where each owner operates as a contractual share.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param OperatingShare   [[ch.ninecode.model.OperatingShare OperatingShare]] The operating shares of this operating participant.
 *                         An operating participant can be resused for any number of power system resources.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
final case class OperatingParticipant
(
    IdentifiedObject: IdentifiedObject = null,
    OperatingShare: List[String] = null
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
        implicit val clz: String = OperatingParticipant.cls

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (OperatingParticipant.fields (position), x))

        emitattrs (0, OperatingShare)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:OperatingParticipant rdf:ID=\"%s\">\n%s\t</cim:OperatingParticipant>".format (id, export_fields)
    }
}

object OperatingParticipant
    extends
        CIMParseable[OperatingParticipant]
{
    override val fields: Array[String] = Array [String](
        "OperatingShare"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("OperatingShare", "OperatingShare", "0..*", "1")
    )
    val OperatingShare: FielderMultiple = parse_attributes (attribute (cls, fields (0)))

    def parse (context: CIMContext): OperatingParticipant =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = OperatingParticipant (
            IdentifiedObject.parse (context),
            masks (OperatingShare (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[OperatingParticipant] = OperatingParticipantSerializer
}

object OperatingParticipantSerializer extends CIMSerializer[OperatingParticipant]
{
    def write (kryo: Kryo, output: Output, obj: OperatingParticipant): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.OperatingShare, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OperatingParticipant]): OperatingParticipant =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf [IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = OperatingParticipant (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Specifies the operations contract relationship between a power system resource and a contract participant.
 *
 * @param Element              Reference to the superclass object.
 * @param percentage           Percentage operational ownership between the pair (power system resource and operating participant) associated with this share.
 *                             The total percentage ownership for a power system resource should add to 100%.
 * @param OperatingParticipant [[ch.ninecode.model.OperatingParticipant OperatingParticipant]] The operating participant having this share with the associated power system resource.
 * @param PowerSystemResource  [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] The power system resource to which the share applies.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
final case class OperatingShare
(
    Element: BasicElement = null,
    percentage: Double = 0.0,
    OperatingParticipant: String = null,
    PowerSystemResource: String = null
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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = OperatingShare.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (OperatingShare.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OperatingShare.fields (position), value)

        emitelem (0, percentage)
        emitattr (1, OperatingParticipant)
        emitattr (2, PowerSystemResource)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:OperatingShare rdf:ID=\"%s\">\n%s\t</cim:OperatingShare>".format (id, export_fields)
    }
}

object OperatingShare
    extends
        CIMParseable[OperatingShare]
{
    override val fields: Array[String] = Array [String](
        "percentage",
        "OperatingParticipant",
        "PowerSystemResource"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("OperatingParticipant", "OperatingParticipant", "1", "0..*"),
        CIMRelationship ("PowerSystemResource", "PowerSystemResource", "1", "0..*")
    )
    val percentage: Fielder = parse_element (element (cls, fields (0)))
    val OperatingParticipant: Fielder = parse_attribute (attribute (cls, fields (1)))
    val PowerSystemResource: Fielder = parse_attribute (attribute (cls, fields (2)))

    def parse (context: CIMContext): OperatingShare =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = OperatingShare (
            BasicElement.parse (context),
            toDouble (mask (percentage (), 0)),
            mask (OperatingParticipant (), 1),
            mask (PowerSystemResource (), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[OperatingShare] = OperatingShareSerializer
}

object OperatingShareSerializer extends CIMSerializer[OperatingShare]
{
    def write (kryo: Kryo, output: Output, obj: OperatingShare): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.percentage),
            () => output.writeString (obj.OperatingParticipant),
            () => output.writeString (obj.PowerSystemResource)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf [BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OperatingShare]): OperatingShare =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf [BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = OperatingShare (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Classifying instances of the same class, e.g. overhead and underground ACLineSegments.
 *
 * This classification mechanism is intended to provide flexibility outside the scope of this document, i.e. provide customisation that is non standard.
 *
 * @param IdentifiedObject     [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param PowerSystemResources [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Power system resources classified with this power system resource type.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
final case class PSRType
(
    IdentifiedObject: IdentifiedObject = null,
    PowerSystemResources: List[String] = null
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
        implicit val clz: String = PSRType.cls

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (PSRType.fields (position), x))

        emitattrs (0, PowerSystemResources)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:PSRType rdf:ID=\"%s\">\n%s\t</cim:PSRType>".format (id, export_fields)
    }
}

object PSRType
    extends
        CIMParseable[PSRType]
{
    override val fields: Array[String] = Array [String](
        "PowerSystemResources"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("PowerSystemResources", "PowerSystemResource", "0..*", "0..1")
    )
    val PowerSystemResources: FielderMultiple = parse_attributes (attribute (cls, fields (0)))

    def parse (context: CIMContext): PSRType =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = PSRType (
            IdentifiedObject.parse (context),
            masks (PowerSystemResources (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[PSRType] = PSRTypeSerializer
}

object PSRTypeSerializer extends CIMSerializer[PSRType]
{
    def write (kryo: Kryo, output: Output, obj: PSRType): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.PowerSystemResources, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PSRType]): PSRType =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf [IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PSRType (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A power system resource (PSR) can be an item of equipment such as a switch, an equipment container containing many individual items of equipment such as a substation, or an organisational entity such as sub-control area.
 *
 * Power system resources can have measurements associated.
 *
 * @param IdentifiedObject   [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param AssetDatasheet     [[ch.ninecode.model.AssetInfo AssetInfo]] Datasheet information for this power system resource.
 * @param Assets             [[ch.ninecode.model.Asset Asset]] All assets represented by this power system resource.
 *                           For example, multiple conductor assets are electrically modelled as a single AC line segment.
 * @param Clearances         [[ch.ninecode.model.ClearanceDocument ClearanceDocument]] All clearances applicable to this power system resource.
 * @param ConfigurationEvent [[ch.ninecode.model.ConfigurationEvent ConfigurationEvent]] <em>undocumented</em>
 * @param Controls           [[ch.ninecode.model.Control Control]] The controller outputs used to actually govern a regulating device, e.g. the magnetization of a synchronous machine or capacitor bank breaker actuator.
 * @param GenericAction      [[ch.ninecode.model.GenericAction GenericAction]] <em>undocumented</em>
 * @param Location           [[ch.ninecode.model.Location Location]] Location of this power system resource.
 * @param Measurements       [[ch.ninecode.model.Measurement Measurement]] The measurements associated with this power system resource.
 * @param OperatingShare     [[ch.ninecode.model.OperatingShare OperatingShare]] The operating shares of this power system resource.
 * @param OperationalTags    [[ch.ninecode.model.OperationalTag OperationalTag]] All operational tags placed on this power system resource.
 * @param PSREvents          [[ch.ninecode.model.PSREvent PSREvent]] All events associated with this power system resource.
 * @param PSRType            [[ch.ninecode.model.PSRType PSRType]] Custom classification for this power system resource.
 * @param ReportingGroup     [[ch.ninecode.model.ReportingGroup ReportingGroup]] Reporting groups to which this power system resource belongs.
 * @param VerificationAction [[ch.ninecode.model.VerificationAction VerificationAction]] <em>undocumented</em>
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
final case class PowerSystemResource
(
    IdentifiedObject: IdentifiedObject = null,
    AssetDatasheet: String = null,
    Assets: List[String] = null,
    Clearances: List[String] = null,
    ConfigurationEvent: List[String] = null,
    Controls: List[String] = null,
    GenericAction: List[String] = null,
    Location: String = null,
    Measurements: List[String] = null,
    OperatingShare: List[String] = null,
    OperationalTags: List[String] = null,
    PSREvents: List[String] = null,
    PSRType: String = null,
    ReportingGroup: List[String] = null,
    VerificationAction: List[String] = null
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
        implicit val clz: String = PowerSystemResource.cls

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PowerSystemResource.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (PowerSystemResource.fields (position), x))

        emitattr (0, AssetDatasheet)
        emitattrs (1, Assets)
        emitattrs (2, Clearances)
        emitattrs (3, ConfigurationEvent)
        emitattrs (4, Controls)
        emitattrs (5, GenericAction)
        emitattr (6, Location)
        emitattrs (7, Measurements)
        emitattrs (8, OperatingShare)
        emitattrs (9, OperationalTags)
        emitattrs (10, PSREvents)
        emitattr (11, PSRType)
        emitattrs (12, ReportingGroup)
        emitattrs (13, VerificationAction)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:PowerSystemResource rdf:ID=\"%s\">\n%s\t</cim:PowerSystemResource>".format (id, export_fields)
    }
}

object PowerSystemResource
    extends
        CIMParseable[PowerSystemResource]
{
    override val fields: Array[String] = Array [String](
        "AssetDatasheet",
        "Assets",
        "Clearances",
        "ConfigurationEvent",
        "Controls",
        "GenericAction",
        "Location",
        "Measurements",
        "OperatingShare",
        "OperationalTags",
        "PSREvents",
        "PSRType",
        "ReportingGroup",
        "VerificationAction"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AssetDatasheet", "AssetInfo", "0..1", "0..*"),
        CIMRelationship ("Assets", "Asset", "0..*", "0..*"),
        CIMRelationship ("Clearances", "ClearanceDocument", "0..*", "0..*"),
        CIMRelationship ("ConfigurationEvent", "ConfigurationEvent", "0..*", "0..1"),
        CIMRelationship ("Controls", "Control", "0..*", "0..1"),
        CIMRelationship ("GenericAction", "GenericAction", "0..*", "0..1"),
        CIMRelationship ("Location", "Location", "0..1", "0..*"),
        CIMRelationship ("Measurements", "Measurement", "0..*", "0..1"),
        CIMRelationship ("OperatingShare", "OperatingShare", "0..*", "1"),
        CIMRelationship ("OperationalTags", "OperationalTag", "0..*", "0..1"),
        CIMRelationship ("PSREvents", "PSREvent", "0..*", "0..1"),
        CIMRelationship ("PSRType", "PSRType", "0..1", "0..*"),
        CIMRelationship ("ReportingGroup", "ReportingGroup", "0..*", "0..*"),
        CIMRelationship ("VerificationAction", "VerificationAction", "0..*", "0..1")
    )
    val AssetDatasheet: Fielder = parse_attribute (attribute (cls, fields (0)))
    val Assets: FielderMultiple = parse_attributes (attribute (cls, fields (1)))
    val Clearances: FielderMultiple = parse_attributes (attribute (cls, fields (2)))
    val ConfigurationEvent: FielderMultiple = parse_attributes (attribute (cls, fields (3)))
    val Controls: FielderMultiple = parse_attributes (attribute (cls, fields (4)))
    val GenericAction: FielderMultiple = parse_attributes (attribute (cls, fields (5)))
    val Location: Fielder = parse_attribute (attribute (cls, fields (6)))
    val Measurements: FielderMultiple = parse_attributes (attribute (cls, fields (7)))
    val OperatingShare: FielderMultiple = parse_attributes (attribute (cls, fields (8)))
    val OperationalTags: FielderMultiple = parse_attributes (attribute (cls, fields (9)))
    val PSREvents: FielderMultiple = parse_attributes (attribute (cls, fields (10)))
    val PSRType: Fielder = parse_attribute (attribute (cls, fields (11)))
    val ReportingGroup: FielderMultiple = parse_attributes (attribute (cls, fields (12)))
    val VerificationAction: FielderMultiple = parse_attributes (attribute (cls, fields (13)))

    def parse (context: CIMContext): PowerSystemResource =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = PowerSystemResource (
            IdentifiedObject.parse (context),
            mask (AssetDatasheet (), 0),
            masks (Assets (), 1),
            masks (Clearances (), 2),
            masks (ConfigurationEvent (), 3),
            masks (Controls (), 4),
            masks (GenericAction (), 5),
            mask (Location (), 6),
            masks (Measurements (), 7),
            masks (OperatingShare (), 8),
            masks (OperationalTags (), 9),
            masks (PSREvents (), 10),
            mask (PSRType (), 11),
            masks (ReportingGroup (), 12),
            masks (VerificationAction (), 13)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[PowerSystemResource] = PowerSystemResourceSerializer
}

object PowerSystemResourceSerializer extends CIMSerializer[PowerSystemResource]
{
    def write (kryo: Kryo, output: Output, obj: PowerSystemResource): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.AssetDatasheet),
            () => writeList (obj.Assets, output),
            () => writeList (obj.Clearances, output),
            () => writeList (obj.ConfigurationEvent, output),
            () => writeList (obj.Controls, output),
            () => writeList (obj.GenericAction, output),
            () => output.writeString (obj.Location),
            () => writeList (obj.Measurements, output),
            () => writeList (obj.OperatingShare, output),
            () => writeList (obj.OperationalTags, output),
            () => writeList (obj.PSREvents, output),
            () => output.writeString (obj.PSRType),
            () => writeList (obj.ReportingGroup, output),
            () => writeList (obj.VerificationAction, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PowerSystemResource]): PowerSystemResource =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf [IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PowerSystemResource (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) readList (input) else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) readList (input) else null,
            if (isSet (5)) readList (input) else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) readList (input) else null,
            if (isSet (8)) readList (input) else null,
            if (isSet (9)) readList (input) else null,
            if (isSet (10)) readList (input) else null,
            if (isSet (11)) input.readString else null,
            if (isSet (12)) readList (input) else null,
            if (isSet (13)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The schedule has time points where the time between them is constant.
 *
 * @param BasicIntervalSchedule [[ch.ninecode.model.BasicIntervalSchedule BasicIntervalSchedule]] Reference to the superclass object.
 * @param endTime               The time for the last time point.
 *                              The value can be a time of day, not a specific date.
 * @param timeStep              The time between each pair of subsequent regular time points in sequence order.
 * @param TimePoints            [[ch.ninecode.model.RegularTimePoint RegularTimePoint]] The regular interval time point data values that define this schedule.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
final case class RegularIntervalSchedule
(
    BasicIntervalSchedule: BasicIntervalSchedule = null,
    endTime: String = null,
    timeStep: Double = 0.0,
    TimePoints: List[String] = null
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
    override def sup: BasicIntervalSchedule = BasicIntervalSchedule

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
        implicit val clz: String = RegularIntervalSchedule.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (RegularIntervalSchedule.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (RegularIntervalSchedule.fields (position), x))

        emitelem (0, endTime)
        emitelem (1, timeStep)
        emitattrs (2, TimePoints)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:RegularIntervalSchedule rdf:ID=\"%s\">\n%s\t</cim:RegularIntervalSchedule>".format (id, export_fields)
    }
}

object RegularIntervalSchedule
    extends
        CIMParseable[RegularIntervalSchedule]
{
    override val fields: Array[String] = Array [String](
        "endTime",
        "timeStep",
        "TimePoints"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("TimePoints", "RegularTimePoint", "1..*", "1")
    )
    val endTime: Fielder = parse_element (element (cls, fields (0)))
    val timeStep: Fielder = parse_element (element (cls, fields (1)))
    val TimePoints: FielderMultiple = parse_attributes (attribute (cls, fields (2)))

    def parse (context: CIMContext): RegularIntervalSchedule =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = RegularIntervalSchedule (
            BasicIntervalSchedule.parse (context),
            mask (endTime (), 0),
            toDouble (mask (timeStep (), 1)),
            masks (TimePoints (), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[RegularIntervalSchedule] = RegularIntervalScheduleSerializer
}

object RegularIntervalScheduleSerializer extends CIMSerializer[RegularIntervalSchedule]
{
    def write (kryo: Kryo, output: Output, obj: RegularIntervalSchedule): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.endTime),
            () => output.writeDouble (obj.timeStep),
            () => writeList (obj.TimePoints, output)
        )
        BasicIntervalScheduleSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[RegularIntervalSchedule]): RegularIntervalSchedule =
    {
        val parent = BasicIntervalScheduleSerializer.read (kryo, input, classOf [BasicIntervalSchedule])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = RegularIntervalSchedule (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Time point for a schedule where the time between the consecutive points is constant.
 *
 * @param Element          Reference to the superclass object.
 * @param sequenceNumber   The position of the regular time point in the sequence.
 *                         Note that time points don't have to be sequential, i.e. time points may be omitted. The actual time for a RegularTimePoint is computed by multiplying the associated regular interval schedule's time step with the regular time point sequence number and adding the associated schedules start time. To specify values for the start time, use sequence number 0.  The sequence number cannot be negative.
 * @param value1           The first value at the time.
 *                         The meaning of the value is defined by the derived type of the associated schedule.
 * @param value2           The second value at the time.
 *                         The meaning of the value is defined by the derived type of the associated schedule.
 * @param IntervalSchedule [[ch.ninecode.model.RegularIntervalSchedule RegularIntervalSchedule]] Regular interval schedule containing this time point.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
final case class RegularTimePoint
(
    Element: BasicElement = null,
    sequenceNumber: Int = 0,
    value1: Double = 0.0,
    value2: Double = 0.0,
    IntervalSchedule: String = null
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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = RegularTimePoint.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (RegularTimePoint.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RegularTimePoint.fields (position), value)

        emitelem (0, sequenceNumber)
        emitelem (1, value1)
        emitelem (2, value2)
        emitattr (3, IntervalSchedule)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:RegularTimePoint rdf:ID=\"%s\">\n%s\t</cim:RegularTimePoint>".format (id, export_fields)
    }
}

object RegularTimePoint
    extends
        CIMParseable[RegularTimePoint]
{
    override val fields: Array[String] = Array [String](
        "sequenceNumber",
        "value1",
        "value2",
        "IntervalSchedule"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("IntervalSchedule", "RegularIntervalSchedule", "1", "1..*")
    )
    val sequenceNumber: Fielder = parse_element (element (cls, fields (0)))
    val value1: Fielder = parse_element (element (cls, fields (1)))
    val value2: Fielder = parse_element (element (cls, fields (2)))
    val IntervalSchedule: Fielder = parse_attribute (attribute (cls, fields (3)))

    def parse (context: CIMContext): RegularTimePoint =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = RegularTimePoint (
            BasicElement.parse (context),
            toInteger (mask (sequenceNumber (), 0)),
            toDouble (mask (value1 (), 1)),
            toDouble (mask (value2 (), 2)),
            mask (IntervalSchedule (), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[RegularTimePoint] = RegularTimePointSerializer
}

object RegularTimePointSerializer extends CIMSerializer[RegularTimePoint]
{
    def write (kryo: Kryo, output: Output, obj: RegularTimePoint): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeInt (obj.sequenceNumber),
            () => output.writeDouble (obj.value1),
            () => output.writeDouble (obj.value2),
            () => output.writeString (obj.IntervalSchedule)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf [BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[RegularTimePoint]): RegularTimePoint =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf [BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = RegularTimePoint (
            parent,
            if (isSet (0)) input.readInt else 0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A reporting group is used for various ad-hoc groupings used for reporting.
 *
 * @param IdentifiedObject    [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param BusNameMarker       [[ch.ninecode.model.BusNameMarker BusNameMarker]] The bus name markers that belong to this reporting group.
 * @param PowerSystemResource [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Power system resources which belong to this reporting group.
 * @param ReportingSuperGroup [[ch.ninecode.model.ReportingSuperGroup ReportingSuperGroup]] Reporting super group to which this reporting group belongs.
 * @param TopologicalNode     [[ch.ninecode.model.TopologicalNode TopologicalNode]] The topological nodes that belong to the reporting group.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
final case class ReportingGroup
(
    IdentifiedObject: IdentifiedObject = null,
    BusNameMarker: List[String] = null,
    PowerSystemResource: List[String] = null,
    ReportingSuperGroup: String = null,
    TopologicalNode: List[String] = null
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
        implicit val clz: String = ReportingGroup.cls

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ReportingGroup.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ReportingGroup.fields (position), x))

        emitattrs (0, BusNameMarker)
        emitattrs (1, PowerSystemResource)
        emitattr (2, ReportingSuperGroup)
        emitattrs (3, TopologicalNode)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ReportingGroup rdf:ID=\"%s\">\n%s\t</cim:ReportingGroup>".format (id, export_fields)
    }
}

object ReportingGroup
    extends
        CIMParseable[ReportingGroup]
{
    override val fields: Array[String] = Array [String](
        "BusNameMarker",
        "PowerSystemResource",
        "ReportingSuperGroup",
        "TopologicalNode"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("BusNameMarker", "BusNameMarker", "0..*", "0..1"),
        CIMRelationship ("PowerSystemResource", "PowerSystemResource", "0..*", "0..*"),
        CIMRelationship ("ReportingSuperGroup", "ReportingSuperGroup", "0..1", "0..*"),
        CIMRelationship ("TopologicalNode", "TopologicalNode", "0..*", "0..1")
    )
    val BusNameMarker: FielderMultiple = parse_attributes (attribute (cls, fields (0)))
    val PowerSystemResource: FielderMultiple = parse_attributes (attribute (cls, fields (1)))
    val ReportingSuperGroup: Fielder = parse_attribute (attribute (cls, fields (2)))
    val TopologicalNode: FielderMultiple = parse_attributes (attribute (cls, fields (3)))

    def parse (context: CIMContext): ReportingGroup =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = ReportingGroup (
            IdentifiedObject.parse (context),
            masks (BusNameMarker (), 0),
            masks (PowerSystemResource (), 1),
            mask (ReportingSuperGroup (), 2),
            masks (TopologicalNode (), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ReportingGroup] = ReportingGroupSerializer
}

object ReportingGroupSerializer extends CIMSerializer[ReportingGroup]
{
    def write (kryo: Kryo, output: Output, obj: ReportingGroup): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.BusNameMarker, output),
            () => writeList (obj.PowerSystemResource, output),
            () => output.writeString (obj.ReportingSuperGroup),
            () => writeList (obj.TopologicalNode, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ReportingGroup]): ReportingGroup =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf [IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ReportingGroup (
            parent,
            if (isSet (0)) readList (input) else null,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A reporting super group, groups reporting groups for a higher level report.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param ReportingGroup   [[ch.ninecode.model.ReportingGroup ReportingGroup]] Reporting groups that are grouped under this super group.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
final case class ReportingSuperGroup
(
    IdentifiedObject: IdentifiedObject = null,
    ReportingGroup: List[String] = null
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
        implicit val clz: String = ReportingSuperGroup.cls

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ReportingSuperGroup.fields (position), x))

        emitattrs (0, ReportingGroup)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ReportingSuperGroup rdf:ID=\"%s\">\n%s\t</cim:ReportingSuperGroup>".format (id, export_fields)
    }
}

object ReportingSuperGroup
    extends
        CIMParseable[ReportingSuperGroup]
{
    override val fields: Array[String] = Array [String](
        "ReportingGroup"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ReportingGroup", "ReportingGroup", "0..*", "0..1")
    )
    val ReportingGroup: FielderMultiple = parse_attributes (attribute (cls, fields (0)))

    def parse (context: CIMContext): ReportingSuperGroup =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = ReportingSuperGroup (
            IdentifiedObject.parse (context),
            masks (ReportingGroup (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ReportingSuperGroup] = ReportingSuperGroupSerializer
}

object ReportingSuperGroupSerializer extends CIMSerializer[ReportingSuperGroup]
{
    def write (kryo: Kryo, output: Output, obj: ReportingSuperGroup): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.ReportingGroup, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ReportingSuperGroup]): ReportingSuperGroup =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf [IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ReportingSuperGroup (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A subset of a geographical region of a power system network model.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param DCLines          [[ch.ninecode.model.DCLine DCLine]] The DC lines in this sub-geographical region.
 * @param Lines            [[ch.ninecode.model.Line Line]] The lines within the sub-geographical region.
 * @param Region           [[ch.ninecode.model.GeographicalRegion GeographicalRegion]] The geographical region which this sub-geographical region is within.
 * @param Substations      [[ch.ninecode.model.Substation Substation]] The substations in this sub-geographical region.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
final case class SubGeographicalRegion
(
    IdentifiedObject: IdentifiedObject = null,
    DCLines: List[String] = null,
    Lines: List[String] = null,
    Region: String = null,
    Substations: List[String] = null
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
        implicit val clz: String = SubGeographicalRegion.cls

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SubGeographicalRegion.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (SubGeographicalRegion.fields (position), x))

        emitattrs (0, DCLines)
        emitattrs (1, Lines)
        emitattr (2, Region)
        emitattrs (3, Substations)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:SubGeographicalRegion rdf:ID=\"%s\">\n%s\t</cim:SubGeographicalRegion>".format (id, export_fields)
    }
}

object SubGeographicalRegion
    extends
        CIMParseable[SubGeographicalRegion]
{
    override val fields: Array[String] = Array [String](
        "DCLines",
        "Lines",
        "Region",
        "Substations"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("DCLines", "DCLine", "0..*", "0..1"),
        CIMRelationship ("Lines", "Line", "0..*", "0..1"),
        CIMRelationship ("Region", "GeographicalRegion", "0..1", "0..*"),
        CIMRelationship ("Substations", "Substation", "0..*", "0..1")
    )
    val DCLines: FielderMultiple = parse_attributes (attribute (cls, fields (0)))
    val Lines: FielderMultiple = parse_attributes (attribute (cls, fields (1)))
    val Region: Fielder = parse_attribute (attribute (cls, fields (2)))
    val Substations: FielderMultiple = parse_attributes (attribute (cls, fields (3)))

    def parse (context: CIMContext): SubGeographicalRegion =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = SubGeographicalRegion (
            IdentifiedObject.parse (context),
            masks (DCLines (), 0),
            masks (Lines (), 1),
            mask (Region (), 2),
            masks (Substations (), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[SubGeographicalRegion] = SubGeographicalRegionSerializer
}

object SubGeographicalRegionSerializer extends CIMSerializer[SubGeographicalRegion]
{
    def write (kryo: Kryo, output: Output, obj: SubGeographicalRegion): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.DCLines, output),
            () => writeList (obj.Lines, output),
            () => output.writeString (obj.Region),
            () => writeList (obj.Substations, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[SubGeographicalRegion]): SubGeographicalRegion =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf [IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = SubGeographicalRegion (
            parent,
            if (isSet (0)) readList (input) else null,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A collection of equipment for purposes other than generation or utilization, through which electric energy in bulk is passed for the purposes of switching or modifying its characteristics.
 *
 * @param EquipmentContainer     [[ch.ninecode.model.EquipmentContainer EquipmentContainer]] Reference to the superclass object.
 * @param Bays                   [[ch.ninecode.model.Bay Bay]] Bays contained in the substation.
 * @param DCConverterUnit        [[ch.ninecode.model.DCConverterUnit DCConverterUnit]] The DC converter unit belonging of the substation.
 * @param NamingFeeder           [[ch.ninecode.model.Feeder Feeder]] The primary feeder that normally energizes the secondary substation.
 *                               Used for naming purposes.  Either this association or the substation to subgeographical region should be used for hierarchical containment specification.
 * @param NormalEnergizedFeeder  [[ch.ninecode.model.Feeder Feeder]] The normal energized feeders of the substation.
 *                               Also used for naming purposes.
 * @param NormalEnergizingFeeder [[ch.ninecode.model.Feeder Feeder]] The feeders that potentially energize  the downstream substation.
 *                               Should be consistent with the associations that describe the naming hierarchy.
 * @param Region                 [[ch.ninecode.model.SubGeographicalRegion SubGeographicalRegion]] The SubGeographicalRegion containing the substation.
 * @param VoltageLevels          [[ch.ninecode.model.VoltageLevel VoltageLevel]] The voltage levels within this substation.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
final case class Substation
(
    EquipmentContainer: EquipmentContainer = null,
    Bays: List[String] = null,
    DCConverterUnit: List[String] = null,
    NamingFeeder: String = null,
    NormalEnergizedFeeder: List[String] = null,
    NormalEnergizingFeeder: List[String] = null,
    Region: String = null,
    VoltageLevels: List[String] = null
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
    override def sup: EquipmentContainer = EquipmentContainer

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
        implicit val clz: String = Substation.cls

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Substation.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Substation.fields (position), x))

        emitattrs (0, Bays)
        emitattrs (1, DCConverterUnit)
        emitattr (2, NamingFeeder)
        emitattrs (3, NormalEnergizedFeeder)
        emitattrs (4, NormalEnergizingFeeder)
        emitattr (5, Region)
        emitattrs (6, VoltageLevels)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:Substation rdf:ID=\"%s\">\n%s\t</cim:Substation>".format (id, export_fields)
    }
}

object Substation
    extends
        CIMParseable[Substation]
{
    override val fields: Array[String] = Array [String](
        "Bays",
        "DCConverterUnit",
        "NamingFeeder",
        "NormalEnergizedFeeder",
        "NormalEnergizingFeeder",
        "Region",
        "VoltageLevels"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Bays", "Bay", "0..*", "0..1"),
        CIMRelationship ("DCConverterUnit", "DCConverterUnit", "0..*", "0..1"),
        CIMRelationship ("NamingFeeder", "Feeder", "0..1", "0..*"),
        CIMRelationship ("NormalEnergizedFeeder", "Feeder", "0..*", "0..1"),
        CIMRelationship ("NormalEnergizingFeeder", "Feeder", "0..*", "0..*"),
        CIMRelationship ("Region", "SubGeographicalRegion", "0..1", "0..*"),
        CIMRelationship ("VoltageLevels", "VoltageLevel", "0..*", "1")
    )
    val Bays: FielderMultiple = parse_attributes (attribute (cls, fields (0)))
    val DCConverterUnit: FielderMultiple = parse_attributes (attribute (cls, fields (1)))
    val NamingFeeder: Fielder = parse_attribute (attribute (cls, fields (2)))
    val NormalEnergizedFeeder: FielderMultiple = parse_attributes (attribute (cls, fields (3)))
    val NormalEnergizingFeeder: FielderMultiple = parse_attributes (attribute (cls, fields (4)))
    val Region: Fielder = parse_attribute (attribute (cls, fields (5)))
    val VoltageLevels: FielderMultiple = parse_attributes (attribute (cls, fields (6)))

    def parse (context: CIMContext): Substation =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = Substation (
            EquipmentContainer.parse (context),
            masks (Bays (), 0),
            masks (DCConverterUnit (), 1),
            mask (NamingFeeder (), 2),
            masks (NormalEnergizedFeeder (), 3),
            masks (NormalEnergizingFeeder (), 4),
            mask (Region (), 5),
            masks (VoltageLevels (), 6)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Substation] = SubstationSerializer
}

object SubstationSerializer extends CIMSerializer[Substation]
{
    def write (kryo: Kryo, output: Output, obj: Substation): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.Bays, output),
            () => writeList (obj.DCConverterUnit, output),
            () => output.writeString (obj.NamingFeeder),
            () => writeList (obj.NormalEnergizedFeeder, output),
            () => writeList (obj.NormalEnergizingFeeder, output),
            () => output.writeString (obj.Region),
            () => writeList (obj.VoltageLevels, output)
        )
        EquipmentContainerSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Substation]): Substation =
    {
        val parent = EquipmentContainerSerializer.read (kryo, input, classOf [EquipmentContainer])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Substation (
            parent,
            if (isSet (0)) readList (input) else null,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) readList (input) else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * An AC electrical connection point to a piece of conducting equipment.
 *
 * Terminals are connected at physical connection points called connectivity nodes.
 *
 * @param ACDCTerminal            [[ch.ninecode.model.ACDCTerminal ACDCTerminal]] Reference to the superclass object.
 * @param phases                  Represents the normal network phasing condition.
 *                                If the attribute is missing, three phases (ABC) shall be assumed, except for terminals of grounding classes (specializations of EarthFaultCompensator, GroundDisconnector, GroundSwitch, and Ground) which will be assumed to be N. Therefore, phase code ABCN is explicitly declared when needed, e.g. for star point grounding equipment.
 *                                The phase code on terminals connecting same ConnectivityNode or same TopologicalNode as well as for equipment between two terminals shall be consistent.
 * @param AuxiliaryEquipment      [[ch.ninecode.model.AuxiliaryEquipment AuxiliaryEquipment]] The auxiliary equipment connected to the terminal.
 * @param BranchGroupTerminal     [[ch.ninecode.model.BranchGroupTerminal BranchGroupTerminal]] The directed branch group terminals for which this terminal is monitored.
 * @param Bushing                 [[ch.ninecode.model.Bushing Bushing]] <em>undocumented</em>
 * @param Circuit                 [[ch.ninecode.model.Circuit Circuit]] <em>undocumented</em>
 * @param ConductingEquipment     [[ch.ninecode.model.ConductingEquipment ConductingEquipment]] The conducting equipment of the terminal.
 *                                Conducting equipment have  terminals that may be connected to other conducting equipment terminals via connectivity nodes or topological nodes.
 * @param ConnectivityNode        [[ch.ninecode.model.ConnectivityNode ConnectivityNode]] The connectivity node to which this terminal connects with zero impedance.
 * @param ConverterDCSides        [[ch.ninecode.model.ACDCConverter ACDCConverter]] All converters' DC sides linked to this point of common coupling terminal.
 * @param EquipmentFaults         [[ch.ninecode.model.EquipmentFault EquipmentFault]] The equipment faults at this terminal.
 * @param HasFirstMutualCoupling  [[ch.ninecode.model.MutualCoupling MutualCoupling]] Mutual couplings associated with the branch as the first branch.
 * @param HasSecondMutualCoupling [[ch.ninecode.model.MutualCoupling MutualCoupling]] Mutual couplings with the branch associated as the first branch.
 * @param NormalHeadFeeder        [[ch.ninecode.model.Feeder Feeder]] The feeder that this terminal normally feeds.
 *                                Only specified for the terminals at head of feeders.
 * @param PinTerminal             [[ch.ninecode.model.PinTerminal PinTerminal]] <em>undocumented</em>
 * @param RegulatingControl       [[ch.ninecode.model.RegulatingControl RegulatingControl]] The controls regulating this terminal.
 * @param RemoteInputSignal       [[ch.ninecode.model.RemoteInputSignal RemoteInputSignal]] Input signal coming from this terminal.
 * @param SvPowerFlow             [[ch.ninecode.model.SvPowerFlow SvPowerFlow]] The power flow state variable associated with the terminal.
 * @param TieFlow                 [[ch.ninecode.model.TieFlow TieFlow]] The control area tie flows to which this terminal associates.
 * @param TopologicalNode         [[ch.ninecode.model.TopologicalNode TopologicalNode]] The topological node associated with the terminal.
 *                                This can be used as an alternative to the connectivity node path to topological node, thus making it unnecessary to model connectivity nodes in some cases.   Note that the if connectivity nodes are in the model, this association would probably not be used as an input specification.
 * @param TransformerEnd          [[ch.ninecode.model.TransformerEnd TransformerEnd]] All transformer ends connected at this terminal.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
final case class Terminal
(
    ACDCTerminal: ACDCTerminal = null,
    phases: String = null,
    AuxiliaryEquipment: List[String] = null,
    BranchGroupTerminal: List[String] = null,
    Bushing: String = null,
    Circuit: String = null,
    ConductingEquipment: String = null,
    ConnectivityNode: String = null,
    ConverterDCSides: List[String] = null,
    EquipmentFaults: List[String] = null,
    HasFirstMutualCoupling: List[String] = null,
    HasSecondMutualCoupling: List[String] = null,
    NormalHeadFeeder: String = null,
    PinTerminal: List[String] = null,
    RegulatingControl: List[String] = null,
    RemoteInputSignal: List[String] = null,
    SvPowerFlow: List[String] = null,
    TieFlow: List[String] = null,
    TopologicalNode: String = null,
    TransformerEnd: List[String] = null
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
    override def sup: ACDCTerminal = ACDCTerminal

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
        implicit val clz: String = Terminal.cls

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Terminal.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Terminal.fields (position), x))

        emitattr (0, phases)
        emitattrs (1, AuxiliaryEquipment)
        emitattrs (2, BranchGroupTerminal)
        emitattr (3, Bushing)
        emitattr (4, Circuit)
        emitattr (5, ConductingEquipment)
        emitattr (6, ConnectivityNode)
        emitattrs (7, ConverterDCSides)
        emitattrs (8, EquipmentFaults)
        emitattrs (9, HasFirstMutualCoupling)
        emitattrs (10, HasSecondMutualCoupling)
        emitattr (11, NormalHeadFeeder)
        emitattrs (12, PinTerminal)
        emitattrs (13, RegulatingControl)
        emitattrs (14, RemoteInputSignal)
        emitattrs (15, SvPowerFlow)
        emitattrs (16, TieFlow)
        emitattr (17, TopologicalNode)
        emitattrs (18, TransformerEnd)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:Terminal rdf:ID=\"%s\">\n%s\t</cim:Terminal>".format (id, export_fields)
    }
}

object Terminal
    extends
        CIMParseable[Terminal]
{
    override val fields: Array[String] = Array [String](
        "phases",
        "AuxiliaryEquipment",
        "BranchGroupTerminal",
        "Bushing",
        "Circuit",
        "ConductingEquipment",
        "ConnectivityNode",
        "ConverterDCSides",
        "EquipmentFaults",
        "HasFirstMutualCoupling",
        "HasSecondMutualCoupling",
        "NormalHeadFeeder",
        "PinTerminal",
        "RegulatingControl",
        "RemoteInputSignal",
        "SvPowerFlow",
        "TieFlow",
        "TopologicalNode",
        "TransformerEnd"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AuxiliaryEquipment", "AuxiliaryEquipment", "0..*", "1"),
        CIMRelationship ("BranchGroupTerminal", "BranchGroupTerminal", "0..*", "1"),
        CIMRelationship ("Bushing", "Bushing", "0..1", "0..1"),
        CIMRelationship ("Circuit", "Circuit", "0..1", "0..*"),
        CIMRelationship ("ConductingEquipment", "ConductingEquipment", "1", "0..*"),
        CIMRelationship ("ConnectivityNode", "ConnectivityNode", "0..1", "0..*"),
        CIMRelationship ("ConverterDCSides", "ACDCConverter", "0..*", "0..1"),
        CIMRelationship ("EquipmentFaults", "EquipmentFault", "0..*", "0..1"),
        CIMRelationship ("HasFirstMutualCoupling", "MutualCoupling", "0..*", "1"),
        CIMRelationship ("HasSecondMutualCoupling", "MutualCoupling", "0..*", "1"),
        CIMRelationship ("NormalHeadFeeder", "Feeder", "0..1", "1..*"),
        CIMRelationship ("PinTerminal", "PinTerminal", "0..*", "1"),
        CIMRelationship ("RegulatingControl", "RegulatingControl", "0..*", "0..1"),
        CIMRelationship ("RemoteInputSignal", "RemoteInputSignal", "0..*", "1"),
        CIMRelationship ("SvPowerFlow", "SvPowerFlow", "0..*", "1"),
        CIMRelationship ("TieFlow", "TieFlow", "0..2", "1"),
        CIMRelationship ("TopologicalNode", "TopologicalNode", "0..1", "0..*"),
        CIMRelationship ("TransformerEnd", "TransformerEnd", "0..*", "0..1")
    )
    val phases: Fielder = parse_attribute (attribute (cls, fields (0)))
    val AuxiliaryEquipment: FielderMultiple = parse_attributes (attribute (cls, fields (1)))
    val BranchGroupTerminal: FielderMultiple = parse_attributes (attribute (cls, fields (2)))
    val Bushing: Fielder = parse_attribute (attribute (cls, fields (3)))
    val Circuit: Fielder = parse_attribute (attribute (cls, fields (4)))
    val ConductingEquipment: Fielder = parse_attribute (attribute (cls, fields (5)))
    val ConnectivityNode: Fielder = parse_attribute (attribute (cls, fields (6)))
    val ConverterDCSides: FielderMultiple = parse_attributes (attribute (cls, fields (7)))
    val EquipmentFaults: FielderMultiple = parse_attributes (attribute (cls, fields (8)))
    val HasFirstMutualCoupling: FielderMultiple = parse_attributes (attribute (cls, fields (9)))
    val HasSecondMutualCoupling: FielderMultiple = parse_attributes (attribute (cls, fields (10)))
    val NormalHeadFeeder: Fielder = parse_attribute (attribute (cls, fields (11)))
    val PinTerminal: FielderMultiple = parse_attributes (attribute (cls, fields (12)))
    val RegulatingControl: FielderMultiple = parse_attributes (attribute (cls, fields (13)))
    val RemoteInputSignal: FielderMultiple = parse_attributes (attribute (cls, fields (14)))
    val SvPowerFlow: FielderMultiple = parse_attributes (attribute (cls, fields (15)))
    val TieFlow: FielderMultiple = parse_attributes (attribute (cls, fields (16)))
    val TopologicalNode: Fielder = parse_attribute (attribute (cls, fields (17)))
    val TransformerEnd: FielderMultiple = parse_attributes (attribute (cls, fields (18)))

    def parse (context: CIMContext): Terminal =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = Terminal (
            ACDCTerminal.parse (context),
            mask (phases (), 0),
            masks (AuxiliaryEquipment (), 1),
            masks (BranchGroupTerminal (), 2),
            mask (Bushing (), 3),
            mask (Circuit (), 4),
            mask (ConductingEquipment (), 5),
            mask (ConnectivityNode (), 6),
            masks (ConverterDCSides (), 7),
            masks (EquipmentFaults (), 8),
            masks (HasFirstMutualCoupling (), 9),
            masks (HasSecondMutualCoupling (), 10),
            mask (NormalHeadFeeder (), 11),
            masks (PinTerminal (), 12),
            masks (RegulatingControl (), 13),
            masks (RemoteInputSignal (), 14),
            masks (SvPowerFlow (), 15),
            masks (TieFlow (), 16),
            mask (TopologicalNode (), 17),
            masks (TransformerEnd (), 18)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Terminal] = TerminalSerializer
}

object TerminalSerializer extends CIMSerializer[Terminal]
{
    def write (kryo: Kryo, output: Output, obj: Terminal): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.phases),
            () => writeList (obj.AuxiliaryEquipment, output),
            () => writeList (obj.BranchGroupTerminal, output),
            () => output.writeString (obj.Bushing),
            () => output.writeString (obj.Circuit),
            () => output.writeString (obj.ConductingEquipment),
            () => output.writeString (obj.ConnectivityNode),
            () => writeList (obj.ConverterDCSides, output),
            () => writeList (obj.EquipmentFaults, output),
            () => writeList (obj.HasFirstMutualCoupling, output),
            () => writeList (obj.HasSecondMutualCoupling, output),
            () => output.writeString (obj.NormalHeadFeeder),
            () => writeList (obj.PinTerminal, output),
            () => writeList (obj.RegulatingControl, output),
            () => writeList (obj.RemoteInputSignal, output),
            () => writeList (obj.SvPowerFlow, output),
            () => writeList (obj.TieFlow, output),
            () => output.writeString (obj.TopologicalNode),
            () => writeList (obj.TransformerEnd, output)
        )
        ACDCTerminalSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Terminal]): Terminal =
    {
        val parent = ACDCTerminalSerializer.read (kryo, input, classOf [ACDCTerminal])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Terminal (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) readList (input) else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) readList (input) else null,
            if (isSet (8)) readList (input) else null,
            if (isSet (9)) readList (input) else null,
            if (isSet (10)) readList (input) else null,
            if (isSet (11)) input.readString else null,
            if (isSet (12)) readList (input) else null,
            if (isSet (13)) readList (input) else null,
            if (isSet (14)) readList (input) else null,
            if (isSet (15)) readList (input) else null,
            if (isSet (16)) readList (input) else null,
            if (isSet (17)) input.readString else null,
            if (isSet (18)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A collection of equipment at one common system voltage forming a switchgear.
 *
 * The equipment typically consists of breakers, busbars, instrumentation, control, regulation and protection devices as well as assemblies of all these.
 *
 * @param EquipmentContainer [[ch.ninecode.model.EquipmentContainer EquipmentContainer]] Reference to the superclass object.
 * @param highVoltageLimit   The bus bar's high voltage limit.
 *                           The limit applies to all equipment and nodes contained in a given VoltageLevel. It is not required that it is exchanged in pair with lowVoltageLimit. It is preferable to use operational VoltageLimit, which prevails, if present.
 * @param lowVoltageLimit    The bus bar's low voltage limit.
 *                           The limit applies to all equipment and nodes contained in a given VoltageLevel. It is not required that it is exchanged in pair with highVoltageLimit. It is preferable to use operational VoltageLimit, which prevails, if present.
 * @param BaseVoltage        [[ch.ninecode.model.BaseVoltage BaseVoltage]] The base voltage used for all equipment within the voltage level.
 * @param Bays               [[ch.ninecode.model.Bay Bay]] The bays within this voltage level.
 * @param Substation         [[ch.ninecode.model.Substation Substation]] The substation of the voltage level.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
final case class VoltageLevel
(
    EquipmentContainer: EquipmentContainer = null,
    highVoltageLimit: Double = 0.0,
    lowVoltageLimit: Double = 0.0,
    BaseVoltage: String = null,
    Bays: List[String] = null,
    Substation: String = null
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
    override def sup: EquipmentContainer = EquipmentContainer

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
        implicit val clz: String = VoltageLevel.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (VoltageLevel.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (VoltageLevel.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (VoltageLevel.fields (position), x))

        emitelem (0, highVoltageLimit)
        emitelem (1, lowVoltageLimit)
        emitattr (2, BaseVoltage)
        emitattrs (3, Bays)
        emitattr (4, Substation)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:VoltageLevel rdf:ID=\"%s\">\n%s\t</cim:VoltageLevel>".format (id, export_fields)
    }
}

object VoltageLevel
    extends
        CIMParseable[VoltageLevel]
{
    override val fields: Array[String] = Array [String](
        "highVoltageLimit",
        "lowVoltageLimit",
        "BaseVoltage",
        "Bays",
        "Substation"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("BaseVoltage", "BaseVoltage", "1", "0..*"),
        CIMRelationship ("Bays", "Bay", "0..*", "0..1"),
        CIMRelationship ("Substation", "Substation", "1", "0..*")
    )
    val highVoltageLimit: Fielder = parse_element (element (cls, fields (0)))
    val lowVoltageLimit: Fielder = parse_element (element (cls, fields (1)))
    val BaseVoltage: Fielder = parse_attribute (attribute (cls, fields (2)))
    val Bays: FielderMultiple = parse_attributes (attribute (cls, fields (3)))
    val Substation: Fielder = parse_attribute (attribute (cls, fields (4)))

    def parse (context: CIMContext): VoltageLevel =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = VoltageLevel (
            EquipmentContainer.parse (context),
            toDouble (mask (highVoltageLimit (), 0)),
            toDouble (mask (lowVoltageLimit (), 1)),
            mask (BaseVoltage (), 2),
            masks (Bays (), 3),
            mask (Substation (), 4)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[VoltageLevel] = VoltageLevelSerializer
}

object VoltageLevelSerializer extends CIMSerializer[VoltageLevel]
{
    def write (kryo: Kryo, output: Output, obj: VoltageLevel): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.highVoltageLimit),
            () => output.writeDouble (obj.lowVoltageLimit),
            () => output.writeString (obj.BaseVoltage),
            () => writeList (obj.Bays, output),
            () => output.writeString (obj.Substation)
        )
        EquipmentContainerSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[VoltageLevel]): VoltageLevel =
    {
        val parent = EquipmentContainerSerializer.read (kryo, input, classOf [EquipmentContainer])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = VoltageLevel (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _Core
{
    def register: List[CIMClassInfo] =
    {
        List (
            ACDCTerminal.register,
            BaseFrequency.register,
            BasePower.register,
            BaseVoltage.register,
            BasicIntervalSchedule.register,
            Bay.register,
            ConductingEquipment.register,
            ConnectivityNode.register,
            ConnectivityNodeContainer.register,
            Curve.register,
            CurveData.register,
            Equipment.register,
            EquipmentContainer.register,
            Feeder.register,
            GeographicalRegion.register,
            IdentifiedObject.register,
            IrregularIntervalSchedule.register,
            IrregularTimePoint.register,
            Name.register,
            NameType.register,
            NameTypeAuthority.register,
            OperatingParticipant.register,
            OperatingShare.register,
            PSRType.register,
            PowerSystemResource.register,
            RegularIntervalSchedule.register,
            RegularTimePoint.register,
            ReportingGroup.register,
            ReportingSuperGroup.register,
            SubGeographicalRegion.register,
            Substation.register,
            Terminal.register,
            VoltageLevel.register
        )
    }
}