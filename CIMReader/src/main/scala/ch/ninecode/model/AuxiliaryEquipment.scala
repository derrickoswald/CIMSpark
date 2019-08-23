package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * AuxiliaryEquipment describe equipment that is not performing any primary functions but support for the equipment performing the primary function.
 *
 * AuxiliaryEquipment is attached to primary equipment via an association with Terminal.
 *
 * @param sup [[ch.ninecode.model.Equipment Equipment]] Reference to the superclass object.
 * @param Terminal [[ch.ninecode.model.Terminal Terminal]] The Terminal at the equipment where the AuxiliaryEquipment is attached.
 * @group AuxiliaryEquipment
 * @groupname AuxiliaryEquipment Package AuxiliaryEquipment
 * @groupdesc AuxiliaryEquipment Contains equipment which is not normal conducting equipment such as sensors, fault locators, and surge protectors.  These devices do not define power carrying topological connections as conducting equipment, but are associated to terminals of other conducting equipment.
 */
final case class AuxiliaryEquipment
(
    override val sup: Equipment,
    Terminal: String
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
    def Equipment: Equipment = sup.asInstanceOf[Equipment]
    override def copy (): Row = { clone ().asInstanceOf[AuxiliaryEquipment] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = AuxiliaryEquipment.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AuxiliaryEquipment.fields (position), value)
        emitattr (0, Terminal)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AuxiliaryEquipment rdf:ID=\"%s\">\n%s\t</cim:AuxiliaryEquipment>".format (id, export_fields)
    }
}

object AuxiliaryEquipment
extends
    Parseable[AuxiliaryEquipment]
{
    override val fields: Array[String] = Array[String] (
        "Terminal"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Terminal", "Terminal", "1", "0..*")
    )
    val Terminal: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): AuxiliaryEquipment =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = AuxiliaryEquipment (
            Equipment.parse (context),
            mask (Terminal (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Instrument transformer used to measure electrical qualities of the circuit that is being protected and/or monitored.
 *
 * Typically used as current transducer for the purpose of metering or protection. A typical secondary current rating would be 5A.
 *
 * @param sup [[ch.ninecode.model.Sensor Sensor]] Reference to the superclass object.
 * @param accuracyClass CT accuracy classification.
 * @param accuracyLimit Percent of rated current for which the CT remains accurate within specified limits.
 * @param coreBurden Power burden of the CT core.
 * @param ctClass CT classification; i.e. class 10P.
 * @param usage Intended usage of the CT; i.e. metering, protection.
 * @group AuxiliaryEquipment
 * @groupname AuxiliaryEquipment Package AuxiliaryEquipment
 * @groupdesc AuxiliaryEquipment Contains equipment which is not normal conducting equipment such as sensors, fault locators, and surge protectors.  These devices do not define power carrying topological connections as conducting equipment, but are associated to terminals of other conducting equipment.
 */
final case class CurrentTransformer
(
    override val sup: Sensor,
    accuracyClass: String,
    accuracyLimit: Double,
    coreBurden: Double,
    ctClass: String,
    usage: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, 0.0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Sensor: Sensor = sup.asInstanceOf[Sensor]
    override def copy (): Row = { clone ().asInstanceOf[CurrentTransformer] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CurrentTransformer.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CurrentTransformer.fields (position), value)
        emitelem (0, accuracyClass)
        emitelem (1, accuracyLimit)
        emitelem (2, coreBurden)
        emitelem (3, ctClass)
        emitelem (4, usage)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CurrentTransformer rdf:ID=\"%s\">\n%s\t</cim:CurrentTransformer>".format (id, export_fields)
    }
}

object CurrentTransformer
extends
    Parseable[CurrentTransformer]
{
    override val fields: Array[String] = Array[String] (
        "accuracyClass",
        "accuracyLimit",
        "coreBurden",
        "ctClass",
        "usage"
    )
    val accuracyClass: Fielder = parse_element (element (cls, fields(0)))
    val accuracyLimit: Fielder = parse_element (element (cls, fields(1)))
    val coreBurden: Fielder = parse_element (element (cls, fields(2)))
    val ctClass: Fielder = parse_element (element (cls, fields(3)))
    val usage: Fielder = parse_element (element (cls, fields(4)))

    def parse (context: Context): CurrentTransformer =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = CurrentTransformer (
            Sensor.parse (context),
            mask (accuracyClass (), 0),
            toDouble (mask (accuracyLimit (), 1)),
            toDouble (mask (coreBurden (), 2)),
            mask (ctClass (), 3),
            mask (usage (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A FaultIndicator is typically only an indicator (which may or may not be remotely monitored), and not a piece of equipment that actually initiates a protection event.
 *
 * It is used for FLISR (Fault Location, Isolation and Restoration) purposes, assisting with the dispatch of crews to "most likely" part of the network (i.e. assists with determining circuit section where the fault most likely happened).
 *
 * @param sup [[ch.ninecode.model.AuxiliaryEquipment AuxiliaryEquipment]] Reference to the superclass object.
 * @group AuxiliaryEquipment
 * @groupname AuxiliaryEquipment Package AuxiliaryEquipment
 * @groupdesc AuxiliaryEquipment Contains equipment which is not normal conducting equipment such as sensors, fault locators, and surge protectors.  These devices do not define power carrying topological connections as conducting equipment, but are associated to terminals of other conducting equipment.
 */
final case class FaultIndicator
(
    override val sup: AuxiliaryEquipment
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
    def AuxiliaryEquipment: AuxiliaryEquipment = sup.asInstanceOf[AuxiliaryEquipment]
    override def copy (): Row = { clone ().asInstanceOf[FaultIndicator] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:FaultIndicator rdf:ID=\"%s\">\n%s\t</cim:FaultIndicator>".format (id, export_fields)
    }
}

object FaultIndicator
extends
    Parseable[FaultIndicator]
{

    def parse (context: Context): FaultIndicator =
    {
        implicit val ctx: Context = context
        val ret = FaultIndicator (
            AuxiliaryEquipment.parse (context)
        )
        ret
    }
}

/**
 * Represents a two terminal and power conducting device of negligible impedance that senses flow through the device.
 *
 * @param sup [[ch.ninecode.model.ConductingEquipment ConductingEquipment]] Reference to the superclass object.
 * @group AuxiliaryEquipment
 * @groupname AuxiliaryEquipment Package AuxiliaryEquipment
 * @groupdesc AuxiliaryEquipment Contains equipment which is not normal conducting equipment such as sensors, fault locators, and surge protectors.  These devices do not define power carrying topological connections as conducting equipment, but are associated to terminals of other conducting equipment.
 */
final case class FlowSensor
(
    override val sup: ConductingEquipment
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
    def ConductingEquipment: ConductingEquipment = sup.asInstanceOf[ConductingEquipment]
    override def copy (): Row = { clone ().asInstanceOf[FlowSensor] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:FlowSensor rdf:ID=\"%s\">\n%s\t</cim:FlowSensor>".format (id, export_fields)
    }
}

object FlowSensor
extends
    Parseable[FlowSensor]
{

    def parse (context: Context): FlowSensor =
    {
        implicit val ctx: Context = context
        val ret = FlowSensor (
            ConductingEquipment.parse (context)
        )
        ret
    }
}

/**
 * A sensor used mainly in overhead distribution networks as the source of both current and voltage measurements.
 *
 * @param sup [[ch.ninecode.model.Sensor Sensor]] Reference to the superclass object.
 * @group AuxiliaryEquipment
 * @groupname AuxiliaryEquipment Package AuxiliaryEquipment
 * @groupdesc AuxiliaryEquipment Contains equipment which is not normal conducting equipment such as sensors, fault locators, and surge protectors.  These devices do not define power carrying topological connections as conducting equipment, but are associated to terminals of other conducting equipment.
 */
final case class PostLineSensor
(
    override val sup: Sensor
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
    def Sensor: Sensor = sup.asInstanceOf[Sensor]
    override def copy (): Row = { clone ().asInstanceOf[PostLineSensor] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:PostLineSensor rdf:ID=\"%s\">\n%s\t</cim:PostLineSensor>".format (id, export_fields)
    }
}

object PostLineSensor
extends
    Parseable[PostLineSensor]
{

    def parse (context: Context): PostLineSensor =
    {
        implicit val ctx: Context = context
        val ret = PostLineSensor (
            Sensor.parse (context)
        )
        ret
    }
}

/**
 * Instrument transformer (also known as Voltage Transformer) used to measure electrical qualities of the circuit that is being protected and/or monitored.
 *
 * Typically used as voltage transducer for the purpose of metering, protection, or sometimes auxiliary substation supply. A typical secondary voltage rating would be 120V.
 *
 * @param sup [[ch.ninecode.model.Sensor Sensor]] Reference to the superclass object.
 * @param accuracyClass PT accuracy classification.
 * @param nominalRatio Nominal ratio between the primary and secondary voltage.
 * @param ptClass Potential transformer (PT) classification covering burden.
 * @param type Potential transformer construction type.
 * @group AuxiliaryEquipment
 * @groupname AuxiliaryEquipment Package AuxiliaryEquipment
 * @groupdesc AuxiliaryEquipment Contains equipment which is not normal conducting equipment such as sensors, fault locators, and surge protectors.  These devices do not define power carrying topological connections as conducting equipment, but are associated to terminals of other conducting equipment.
 */
final case class PotentialTransformer
(
    override val sup: Sensor,
    accuracyClass: String,
    nominalRatio: Double,
    ptClass: String,
    `type`: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Sensor: Sensor = sup.asInstanceOf[Sensor]
    override def copy (): Row = { clone ().asInstanceOf[PotentialTransformer] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PotentialTransformer.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PotentialTransformer.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PotentialTransformer.fields (position), value)
        emitelem (0, accuracyClass)
        emitelem (1, nominalRatio)
        emitelem (2, ptClass)
        emitattr (3, `type`)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PotentialTransformer rdf:ID=\"%s\">\n%s\t</cim:PotentialTransformer>".format (id, export_fields)
    }
}

object PotentialTransformer
extends
    Parseable[PotentialTransformer]
{
    override val fields: Array[String] = Array[String] (
        "accuracyClass",
        "nominalRatio",
        "ptClass",
        "type"
    )
    val accuracyClass: Fielder = parse_element (element (cls, fields(0)))
    val nominalRatio: Fielder = parse_element (element (cls, fields(1)))
    val ptClass: Fielder = parse_element (element (cls, fields(2)))
    val `type`: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): PotentialTransformer =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = PotentialTransformer (
            Sensor.parse (context),
            mask (accuracyClass (), 0),
            toDouble (mask (nominalRatio (), 1)),
            mask (ptClass (), 2),
            mask (`type` (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * This class describe devices that transform a measured quantity into signals that can be presented at displays, used in control or be recorded.
 *
 * @param sup [[ch.ninecode.model.AuxiliaryEquipment AuxiliaryEquipment]] Reference to the superclass object.
 * @group AuxiliaryEquipment
 * @groupname AuxiliaryEquipment Package AuxiliaryEquipment
 * @groupdesc AuxiliaryEquipment Contains equipment which is not normal conducting equipment such as sensors, fault locators, and surge protectors.  These devices do not define power carrying topological connections as conducting equipment, but are associated to terminals of other conducting equipment.
 */
final case class Sensor
(
    override val sup: AuxiliaryEquipment
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
    def AuxiliaryEquipment: AuxiliaryEquipment = sup.asInstanceOf[AuxiliaryEquipment]
    override def copy (): Row = { clone ().asInstanceOf[Sensor] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:Sensor rdf:ID=\"%s\">\n%s\t</cim:Sensor>".format (id, export_fields)
    }
}

object Sensor
extends
    Parseable[Sensor]
{

    def parse (context: Context): Sensor =
    {
        implicit val ctx: Context = context
        val ret = Sensor (
            AuxiliaryEquipment.parse (context)
        )
        ret
    }
}

/**
 * Shunt device, installed on the network, usually in the proximity of electrical equipment in order to protect the said equipment against transient voltage transients caused by lightning or switching activity.
 *
 * @param sup [[ch.ninecode.model.AuxiliaryEquipment AuxiliaryEquipment]] Reference to the superclass object.
 * @group AuxiliaryEquipment
 * @groupname AuxiliaryEquipment Package AuxiliaryEquipment
 * @groupdesc AuxiliaryEquipment Contains equipment which is not normal conducting equipment such as sensors, fault locators, and surge protectors.  These devices do not define power carrying topological connections as conducting equipment, but are associated to terminals of other conducting equipment.
 */
final case class SurgeArrester
(
    override val sup: AuxiliaryEquipment
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
    def AuxiliaryEquipment: AuxiliaryEquipment = sup.asInstanceOf[AuxiliaryEquipment]
    override def copy (): Row = { clone ().asInstanceOf[SurgeArrester] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:SurgeArrester rdf:ID=\"%s\">\n%s\t</cim:SurgeArrester>".format (id, export_fields)
    }
}

object SurgeArrester
extends
    Parseable[SurgeArrester]
{

    def parse (context: Context): SurgeArrester =
    {
        implicit val ctx: Context = context
        val ret = SurgeArrester (
            AuxiliaryEquipment.parse (context)
        )
        ret
    }
}

/**
 * Line traps are devices that impede high frequency power line carrier signals yet present a negligible impedance at the main power frequency.
 *
 * @param sup [[ch.ninecode.model.AuxiliaryEquipment AuxiliaryEquipment]] Reference to the superclass object.
 * @group AuxiliaryEquipment
 * @groupname AuxiliaryEquipment Package AuxiliaryEquipment
 * @groupdesc AuxiliaryEquipment Contains equipment which is not normal conducting equipment such as sensors, fault locators, and surge protectors.  These devices do not define power carrying topological connections as conducting equipment, but are associated to terminals of other conducting equipment.
 */
final case class WaveTrap
(
    override val sup: AuxiliaryEquipment
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
    def AuxiliaryEquipment: AuxiliaryEquipment = sup.asInstanceOf[AuxiliaryEquipment]
    override def copy (): Row = { clone ().asInstanceOf[WaveTrap] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:WaveTrap rdf:ID=\"%s\">\n%s\t</cim:WaveTrap>".format (id, export_fields)
    }
}

object WaveTrap
extends
    Parseable[WaveTrap]
{

    def parse (context: Context): WaveTrap =
    {
        implicit val ctx: Context = context
        val ret = WaveTrap (
            AuxiliaryEquipment.parse (context)
        )
        ret
    }
}

private[ninecode] object _AuxiliaryEquipment
{
    def register: List[ClassInfo] =
    {
        List (
            AuxiliaryEquipment.register,
            CurrentTransformer.register,
            FaultIndicator.register,
            FlowSensor.register,
            PostLineSensor.register,
            PotentialTransformer.register,
            Sensor.register,
            SurgeArrester.register,
            WaveTrap.register
        )
    }
}