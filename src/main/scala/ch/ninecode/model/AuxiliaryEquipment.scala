package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * Contains equipment which is not normal conducting equipment such as sensors, fault locators, and surge protectors.
 * These devices do not define power carrying topological connections as conducting equipment, but are associated to terminals of other conducting equipment.
 */

/**
 * AuxiliaryEquipment describe equipment that is not performing any primary functions but support for the equipment performing the primary function.
 * AuxiliaryEquipment is attached to primary eqipment via an association with Terminal.
 * @param sup Reference to the superclass object.
 * @param Terminal The Terminal at the equipment where the AuxiliaryEquipment is attached.
 */
case class AuxiliaryEquipment
(override val sup: Equipment,
val Terminal: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Equipment: Equipment = sup.asInstanceOf[Equipment]
    override def copy (): Row = { return (clone ().asInstanceOf[AuxiliaryEquipment]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AuxiliaryEquipment
extends
    Parseable[AuxiliaryEquipment]
{
    val sup = Equipment.parse _
    val Terminal = parse_attribute (attribute ("""AuxiliaryEquipment.Terminal"""))_
    def parse (context: Context): AuxiliaryEquipment =
    {
        AuxiliaryEquipment(
            sup (context),
            Terminal (context)
        )
    }
}

/**
 * Instrument transformer used to measure electrical qualities of the circuit that is being protected and/or monitored.
 * Typically used as current transducer for the purpose of metering or protection. A typical secondary current rating would be 5A.
 * @param sup Reference to the superclass object.
 * @param accuracyClass CT accuracy classification.
 * @param accuracyLimit Percent of rated current for which the CT remains accurate within specified limits.
 * @param coreBurden Power burden of the CT core.
 * @param ctClass CT classification; i.e. class 10P.
 * @param usage Intended usage of the CT; i.e. metering, protection.
 */
case class CurrentTransformer
(override val sup: Sensor,
val accuracyClass: String,
val accuracyLimit: Double,
val coreBurden: Double,
val ctClass: String,
val usage: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, 0.0, null, null) }
    def Sensor: Sensor = sup.asInstanceOf[Sensor]
    override def copy (): Row = { return (clone ().asInstanceOf[CurrentTransformer]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CurrentTransformer
extends
    Parseable[CurrentTransformer]
{
    val sup = Sensor.parse _
    val accuracyClass = parse_element (element ("""CurrentTransformer.accuracyClass"""))_
    val accuracyLimit = parse_element (element ("""CurrentTransformer.accuracyLimit"""))_
    val coreBurden = parse_element (element ("""CurrentTransformer.coreBurden"""))_
    val ctClass = parse_element (element ("""CurrentTransformer.ctClass"""))_
    val usage = parse_element (element ("""CurrentTransformer.usage"""))_
    def parse (context: Context): CurrentTransformer =
    {
        CurrentTransformer(
            sup (context),
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
 * It is used for FLISR (Fault Location, Isolation and Restoration) purposes, assisting with the dispatch of crews to "most likely" part of the network (i.e. assists with determining circuit section where the fault most likely happened).
 * @param sup Reference to the superclass object.
 */
case class FaultIndicator
(override val sup: AuxiliaryEquipment
)
extends
    Element
{
    def this () = { this (null) }
    def AuxiliaryEquipment: AuxiliaryEquipment = sup.asInstanceOf[AuxiliaryEquipment]
    override def copy (): Row = { return (clone ().asInstanceOf[FaultIndicator]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object FaultIndicator
extends
    Parseable[FaultIndicator]
{
    val sup = AuxiliaryEquipment.parse _
    def parse (context: Context): FaultIndicator =
    {
        FaultIndicator(
            sup (context)
        )
    }
}

/**
 * A sensor used mainly in overhead distribution networks as the source of both current and voltage measurements.
 * @param sup Reference to the superclass object.
 */
case class PostLineSensor
(override val sup: Sensor
)
extends
    Element
{
    def this () = { this (null) }
    def Sensor: Sensor = sup.asInstanceOf[Sensor]
    override def copy (): Row = { return (clone ().asInstanceOf[PostLineSensor]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PostLineSensor
extends
    Parseable[PostLineSensor]
{
    val sup = Sensor.parse _
    def parse (context: Context): PostLineSensor =
    {
        PostLineSensor(
            sup (context)
        )
    }
}

/**
 * Instrument transformer (also known as Voltage Transformer) used to measure electrical qualities of the circuit that is being protected and/or monitored.
 * Typically used as voltage transducer for the purpose of metering, protection, or sometimes auxiliary substation supply. A typical secondary voltage rating would be 120V.
 * @param sup Reference to the superclass object.
 * @param accuracyClass PT accuracy classification.
 * @param nominalRatio Nominal ratio between the primary and secondary voltage.
 * @param ptClass Potential transformer (PT) classification covering burden.
 * @param typ Potential transformer construction type.
 */
case class PotentialTransformer
(override val sup: Sensor,
val accuracyClass: String,
val nominalRatio: Double,
val ptClass: String,
val typ: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, null, null) }
    def Sensor: Sensor = sup.asInstanceOf[Sensor]
    override def copy (): Row = { return (clone ().asInstanceOf[PotentialTransformer]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PotentialTransformer
extends
    Parseable[PotentialTransformer]
{
    val sup = Sensor.parse _
    val accuracyClass = parse_element (element ("""PotentialTransformer.accuracyClass"""))_
    val nominalRatio = parse_element (element ("""PotentialTransformer.nominalRatio"""))_
    val ptClass = parse_element (element ("""PotentialTransformer.ptClass"""))_
    val typ = parse_attribute (attribute ("""PotentialTransformer.type"""))_
    def parse (context: Context): PotentialTransformer =
    {
        PotentialTransformer(
            sup (context),
            accuracyClass (context),
            toDouble (nominalRatio (context), context),
            ptClass (context),
            typ (context)
        )
    }
}

/**
 * The construction kind of the potential transformer.
 * @param sup Reference to the superclass object.
 * @param capacitiveCoupling The potential transformer is using capacitive coupling to create secondary voltage.
 * @param inductive The potential transformer is using induction coils to create secondary voltage.
 */
case class PotentialTransformerKind
(override val sup: BasicElement,
val capacitiveCoupling: String,
val inductive: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[PotentialTransformerKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PotentialTransformerKind
extends
    Parseable[PotentialTransformerKind]
{
    val sup = BasicElement.parse _
    val capacitiveCoupling = parse_attribute (attribute ("""PotentialTransformerKind.capacitiveCoupling"""))_
    val inductive = parse_attribute (attribute ("""PotentialTransformerKind.inductive"""))_
    def parse (context: Context): PotentialTransformerKind =
    {
        PotentialTransformerKind(
            sup (context),
            capacitiveCoupling (context),
            inductive (context)
        )
    }
}

/**
 * This class describe devices that transform a measured quantity into signals that can be presented at displays, used in control or be recorded.
 * @param sup Reference to the superclass object.
 */
case class Sensor
(override val sup: AuxiliaryEquipment
)
extends
    Element
{
    def this () = { this (null) }
    def AuxiliaryEquipment: AuxiliaryEquipment = sup.asInstanceOf[AuxiliaryEquipment]
    override def copy (): Row = { return (clone ().asInstanceOf[Sensor]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Sensor
extends
    Parseable[Sensor]
{
    val sup = AuxiliaryEquipment.parse _
    def parse (context: Context): Sensor =
    {
        Sensor(
            sup (context)
        )
    }
}

/**
 * Shunt device, installed on the network, usually in the proximity of electrical equipment in order to protect the said equipment against transient voltage transients caused by lightning or switching activity.
 * @param sup Reference to the superclass object.
 */
case class SurgeArrester
(override val sup: AuxiliaryEquipment
)
extends
    Element
{
    def this () = { this (null) }
    def AuxiliaryEquipment: AuxiliaryEquipment = sup.asInstanceOf[AuxiliaryEquipment]
    override def copy (): Row = { return (clone ().asInstanceOf[SurgeArrester]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SurgeArrester
extends
    Parseable[SurgeArrester]
{
    val sup = AuxiliaryEquipment.parse _
    def parse (context: Context): SurgeArrester =
    {
        SurgeArrester(
            sup (context)
        )
    }
}

/**
 * Line traps are devices that impede high frequency power line carrier signals yet present a negligible impedance at the main power frequency.
 * @param sup Reference to the superclass object.
 */
case class WaveTrap
(override val sup: AuxiliaryEquipment
)
extends
    Element
{
    def this () = { this (null) }
    def AuxiliaryEquipment: AuxiliaryEquipment = sup.asInstanceOf[AuxiliaryEquipment]
    override def copy (): Row = { return (clone ().asInstanceOf[WaveTrap]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WaveTrap
extends
    Parseable[WaveTrap]
{
    val sup = AuxiliaryEquipment.parse _
    def parse (context: Context): WaveTrap =
    {
        WaveTrap(
            sup (context)
        )
    }
}

object _AuxiliaryEquipment
{
    def register: Unit =
    {
        AuxiliaryEquipment.register
        CurrentTransformer.register
        FaultIndicator.register
        PostLineSensor.register
        PotentialTransformer.register
        PotentialTransformerKind.register
        Sensor.register
        SurgeArrester.register
        WaveTrap.register
    }
}