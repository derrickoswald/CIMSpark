package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * An extension to the Core and Wires packages that models information for protection equipment such as relays.
 * These entities are used within training simulators and distribution network fault location applications.
 */

/**
 * A device that checks current flow values in any direction or designated direction.
 */
case class CurrentRelay
(

    override val sup: ProtectionEquipment,

    /**
     * Current limit number one 1 for inverse time pickup.
     */
    val currentLimit1: Double,

    /**
     * Current limit number 2 for inverse time pickup.
     */
    val currentLimit2: Double,

    /**
     * Current limit number 3 for inverse time pickup.
     */
    val currentLimit3: Double,

    /**
     * Set true if the current relay has inverse time characteristic.
     */
    val inverseTimeFlag: Boolean,

    /**
     * Inverse time delay number 1 for current limit number 1.
     */
    val timeDelay1: Double,

    /**
     * Inverse time delay number 2 for current limit number 2.
     */
    val timeDelay2: Double,

    /**
     * Inverse time delay number 3 for current limit number 3.
     */
    val timeDelay3: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, false, 0.0, 0.0, 0.0) }
    def ProtectionEquipment: ProtectionEquipment = sup.asInstanceOf[ProtectionEquipment]
    override def copy (): Row = { return (clone ().asInstanceOf[CurrentRelay]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CurrentRelay
extends
    Parseable[CurrentRelay]
{
    val sup = ProtectionEquipment.parse _
    val currentLimit1 = parse_element (element ("""CurrentRelay.currentLimit1"""))_
    val currentLimit2 = parse_element (element ("""CurrentRelay.currentLimit2"""))_
    val currentLimit3 = parse_element (element ("""CurrentRelay.currentLimit3"""))_
    val inverseTimeFlag = parse_element (element ("""CurrentRelay.inverseTimeFlag"""))_
    val timeDelay1 = parse_element (element ("""CurrentRelay.timeDelay1"""))_
    val timeDelay2 = parse_element (element ("""CurrentRelay.timeDelay2"""))_
    val timeDelay3 = parse_element (element ("""CurrentRelay.timeDelay3"""))_
    def parse (context: Context): CurrentRelay =
    {
        CurrentRelay(
            sup (context),
            toDouble (currentLimit1 (context), context),
            toDouble (currentLimit2 (context), context),
            toDouble (currentLimit3 (context), context),
            toBoolean (inverseTimeFlag (context), context),
            toDouble (timeDelay1 (context), context),
            toDouble (timeDelay2 (context), context),
            toDouble (timeDelay3 (context), context)
        )
    }
}

/**
 * An electrical device designed to respond to input conditions in a prescribed manner and after specified conditions are met to cause contact operation or similar abrupt change in associated electric control circuits, or simply to display the detected condition.
 * Protection equipment are associated with conducting equipment and usually operate circuit breakers.
 */
case class ProtectionEquipment
(

    override val sup: Equipment,

    /**
     * The maximum allowable value.
     */
    val highLimit: Double,

    /**
     * The minimum allowable value.
     */
    val lowLimit: Double,

    /**
     * Direction same as positive active power flow value.
     */
    val powerDirectionFlag: Boolean,

    /**
     * The time delay from detection of abnormal conditions to relay operation.
     */
    val relayDelayTime: Double,

    /**
     * The unit multiplier of the value.
     */
    val unitMultiplier: String,

    /**
     * The unit of measure of the value.
     */
    val unitSymbol: String,

    /**
     * Protection equipment may be used to protect specific conducting equipment.
     */
    val ConductingEquipments: List[String],

    /**
     * Protected switches operated by this ProtectionEquipment.
     */
    val ProtectedSwitches: List[String]
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, false, 0.0, null, null, List(), List()) }
    def Equipment: Equipment = sup.asInstanceOf[Equipment]
    override def copy (): Row = { return (clone ().asInstanceOf[ProtectionEquipment]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ProtectionEquipment
extends
    Parseable[ProtectionEquipment]
{
    val sup = Equipment.parse _
    val highLimit = parse_element (element ("""ProtectionEquipment.highLimit"""))_
    val lowLimit = parse_element (element ("""ProtectionEquipment.lowLimit"""))_
    val powerDirectionFlag = parse_element (element ("""ProtectionEquipment.powerDirectionFlag"""))_
    val relayDelayTime = parse_element (element ("""ProtectionEquipment.relayDelayTime"""))_
    val unitMultiplier = parse_attribute (attribute ("""ProtectionEquipment.unitMultiplier"""))_
    val unitSymbol = parse_attribute (attribute ("""ProtectionEquipment.unitSymbol"""))_
    val ConductingEquipments = parse_attributes (attribute ("""ProtectionEquipment.ConductingEquipments"""))_
    val ProtectedSwitches = parse_attributes (attribute ("""ProtectionEquipment.ProtectedSwitches"""))_
    def parse (context: Context): ProtectionEquipment =
    {
        ProtectionEquipment(
            sup (context),
            toDouble (highLimit (context), context),
            toDouble (lowLimit (context), context),
            toBoolean (powerDirectionFlag (context), context),
            toDouble (relayDelayTime (context), context),
            unitMultiplier (context),
            unitSymbol (context),
            ConductingEquipments (context),
            ProtectedSwitches (context)
        )
    }
}

/**
 * A reclose sequence (open and close) is defined for each possible reclosure of a breaker.
 */
case class RecloseSequence
(

    override val sup: IdentifiedObject,

    /**
     * Indicates the time lapse before the reclose step will execute a reclose.
     */
    val recloseDelay: Double,

    /**
     * Indicates the ordinal position of the reclose step relative to other steps in the sequence.
     */
    val recloseStep: Int,

    /**
     * A breaker may have zero or more automatic reclosures after a trip occurs.
     */
    val ProtectedSwitch: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[RecloseSequence]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RecloseSequence
extends
    Parseable[RecloseSequence]
{
    val sup = IdentifiedObject.parse _
    val recloseDelay = parse_element (element ("""RecloseSequence.recloseDelay"""))_
    val recloseStep = parse_element (element ("""RecloseSequence.recloseStep"""))_
    val ProtectedSwitch = parse_attribute (attribute ("""RecloseSequence.ProtectedSwitch"""))_
    def parse (context: Context): RecloseSequence =
    {
        RecloseSequence(
            sup (context),
            toDouble (recloseDelay (context), context),
            toInteger (recloseStep (context), context),
            ProtectedSwitch (context)
        )
    }
}

/**
 * A device that operates when two AC circuits are within the desired limits of frequency, phase angle, and voltage, to permit or to cause the paralleling of these two circuits.
 * Used to prevent the paralleling of non-synchronous topological islands.
 */
case class SynchrocheckRelay
(

    override val sup: ProtectionEquipment,

    /**
     * The maximum allowable voltage vector phase angle difference across the open device.
     */
    val maxAngleDiff: Double,

    /**
     * The maximum allowable frequency difference across the open device.
     */
    val maxFreqDiff: Double,

    /**
     * The maximum allowable difference voltage across the open device.
     */
    val maxVoltDiff: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0) }
    def ProtectionEquipment: ProtectionEquipment = sup.asInstanceOf[ProtectionEquipment]
    override def copy (): Row = { return (clone ().asInstanceOf[SynchrocheckRelay]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SynchrocheckRelay
extends
    Parseable[SynchrocheckRelay]
{
    val sup = ProtectionEquipment.parse _
    val maxAngleDiff = parse_element (element ("""SynchrocheckRelay.maxAngleDiff"""))_
    val maxFreqDiff = parse_element (element ("""SynchrocheckRelay.maxFreqDiff"""))_
    val maxVoltDiff = parse_element (element ("""SynchrocheckRelay.maxVoltDiff"""))_
    def parse (context: Context): SynchrocheckRelay =
    {
        SynchrocheckRelay(
            sup (context),
            toDouble (maxAngleDiff (context), context),
            toDouble (maxFreqDiff (context), context),
            toDouble (maxVoltDiff (context), context)
        )
    }
}

object _Protection
{
    def register: Unit =
    {
        CurrentRelay.register
        ProtectionEquipment.register
        RecloseSequence.register
        SynchrocheckRelay.register
    }
}