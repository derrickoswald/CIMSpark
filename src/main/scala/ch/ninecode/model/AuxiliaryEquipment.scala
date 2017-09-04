package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * AuxiliaryEquipment describe equipment that is not performing any primary functions but support for the equipment performing the primary function.
 *
 * AuxiliaryEquipment is attached to primary eqipment via an association with Terminal.
 *
 * @param sup [[ch.ninecode.model.Equipment Equipment]] Reference to the superclass object.
 * @param Terminal [[ch.ninecode.model.Terminal Terminal]] The Terminal at the equipment where the AuxiliaryEquipment is attached.
 * @group AuxiliaryEquipment
 * @groupname AuxiliaryEquipment Package AuxiliaryEquipment
 * @groupdesc AuxiliaryEquipment Contains equipment which is not normal conducting equipment such as sensors, fault locators, and surge protectors.  These devices do not define power carrying topological connections as conducting equipment, but are associated to terminals of other conducting equipment.
 */
case class AuxiliaryEquipment
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != Terminal) "\t\t<cim:AuxiliaryEquipment.Terminal rdf:resource=\"#" + Terminal + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AuxiliaryEquipment rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AuxiliaryEquipment>"
    }
}

object AuxiliaryEquipment
extends
    Parseable[AuxiliaryEquipment]
{
    val Terminal = parse_attribute (attribute ("""AuxiliaryEquipment.Terminal"""))
    def parse (context: Context): AuxiliaryEquipment =
    {
        AuxiliaryEquipment(
            Equipment.parse (context),
            Terminal (context)
        )
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
case class CurrentTransformer
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != accuracyClass) "\t\t<cim:CurrentTransformer.accuracyClass>" + accuracyClass + "</cim:CurrentTransformer.accuracyClass>\n" else "") +
        "\t\t<cim:CurrentTransformer.accuracyLimit>" + accuracyLimit + "</cim:CurrentTransformer.accuracyLimit>\n" +
        "\t\t<cim:CurrentTransformer.coreBurden>" + coreBurden + "</cim:CurrentTransformer.coreBurden>\n" +
        (if (null != ctClass) "\t\t<cim:CurrentTransformer.ctClass>" + ctClass + "</cim:CurrentTransformer.ctClass>\n" else "") +
        (if (null != usage) "\t\t<cim:CurrentTransformer.usage>" + usage + "</cim:CurrentTransformer.usage>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:CurrentTransformer rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CurrentTransformer>"
    }
}

object CurrentTransformer
extends
    Parseable[CurrentTransformer]
{
    val accuracyClass = parse_element (element ("""CurrentTransformer.accuracyClass"""))
    val accuracyLimit = parse_element (element ("""CurrentTransformer.accuracyLimit"""))
    val coreBurden = parse_element (element ("""CurrentTransformer.coreBurden"""))
    val ctClass = parse_element (element ("""CurrentTransformer.ctClass"""))
    val usage = parse_element (element ("""CurrentTransformer.usage"""))
    def parse (context: Context): CurrentTransformer =
    {
        CurrentTransformer(
            Sensor.parse (context),
            accuracyClass (context),
            toDouble (accuracyLimit (context), context),
            toDouble (coreBurden (context), context),
            ctClass (context),
            usage (context)
        )
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
case class FaultIndicator
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
        "\t<cim:FaultIndicator rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:FaultIndicator>"
    }
}

object FaultIndicator
extends
    Parseable[FaultIndicator]
{
    def parse (context: Context): FaultIndicator =
    {
        FaultIndicator(
            AuxiliaryEquipment.parse (context)
        )
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
case class PostLineSensor
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
        "\t<cim:PostLineSensor rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PostLineSensor>"
    }
}

object PostLineSensor
extends
    Parseable[PostLineSensor]
{
    def parse (context: Context): PostLineSensor =
    {
        PostLineSensor(
            Sensor.parse (context)
        )
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
 * @param typ Potential transformer construction type.
 * @group AuxiliaryEquipment
 * @groupname AuxiliaryEquipment Package AuxiliaryEquipment
 * @groupdesc AuxiliaryEquipment Contains equipment which is not normal conducting equipment such as sensors, fault locators, and surge protectors.  These devices do not define power carrying topological connections as conducting equipment, but are associated to terminals of other conducting equipment.
 */
case class PotentialTransformer
(
    override val sup: Sensor,
    accuracyClass: String,
    nominalRatio: Double,
    ptClass: String,
    typ: String
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != accuracyClass) "\t\t<cim:PotentialTransformer.accuracyClass>" + accuracyClass + "</cim:PotentialTransformer.accuracyClass>\n" else "") +
        "\t\t<cim:PotentialTransformer.nominalRatio>" + nominalRatio + "</cim:PotentialTransformer.nominalRatio>\n" +
        (if (null != ptClass) "\t\t<cim:PotentialTransformer.ptClass>" + ptClass + "</cim:PotentialTransformer.ptClass>\n" else "") +
        (if (null != typ) "\t\t<cim:PotentialTransformer.type rdf:resource=\"#" + typ + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:PotentialTransformer rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PotentialTransformer>"
    }
}

object PotentialTransformer
extends
    Parseable[PotentialTransformer]
{
    val accuracyClass = parse_element (element ("""PotentialTransformer.accuracyClass"""))
    val nominalRatio = parse_element (element ("""PotentialTransformer.nominalRatio"""))
    val ptClass = parse_element (element ("""PotentialTransformer.ptClass"""))
    val typ = parse_attribute (attribute ("""PotentialTransformer.type"""))
    def parse (context: Context): PotentialTransformer =
    {
        PotentialTransformer(
            Sensor.parse (context),
            accuracyClass (context),
            toDouble (nominalRatio (context), context),
            ptClass (context),
            typ (context)
        )
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
case class Sensor
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
        "\t<cim:Sensor rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Sensor>"
    }
}

object Sensor
extends
    Parseable[Sensor]
{
    def parse (context: Context): Sensor =
    {
        Sensor(
            AuxiliaryEquipment.parse (context)
        )
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
case class SurgeArrester
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
        "\t<cim:SurgeArrester rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SurgeArrester>"
    }
}

object SurgeArrester
extends
    Parseable[SurgeArrester]
{
    def parse (context: Context): SurgeArrester =
    {
        SurgeArrester(
            AuxiliaryEquipment.parse (context)
        )
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
case class WaveTrap
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
        "\t<cim:WaveTrap rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WaveTrap>"
    }
}

object WaveTrap
extends
    Parseable[WaveTrap]
{
    def parse (context: Context): WaveTrap =
    {
        WaveTrap(
            AuxiliaryEquipment.parse (context)
        )
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
            PostLineSensor.register,
            PotentialTransformer.register,
            Sensor.register,
            SurgeArrester.register,
            WaveTrap.register
        )
    }
}