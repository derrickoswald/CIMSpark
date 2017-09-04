package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * A device that checks current flow values in any direction or designated direction.
 *
 * @param sup [[ch.ninecode.model.ProtectionEquipment ProtectionEquipment]] Reference to the superclass object.
 * @param currentLimit1 Current limit number one 1 for inverse time pickup.
 * @param currentLimit2 Current limit number 2 for inverse time pickup.
 * @param currentLimit3 Current limit number 3 for inverse time pickup.
 * @param inverseTimeFlag Set true if the current relay has inverse time characteristic.
 * @param timeDelay1 Inverse time delay number 1 for current limit number 1.
 * @param timeDelay2 Inverse time delay number 2 for current limit number 2.
 * @param timeDelay3 Inverse time delay number 3 for current limit number 3.
 * @group Protection
 * @groupname Protection Package Protection
 * @groupdesc Protection An extension to the Core and Wires packages that models information for protection equipment such as relays. These entities are used within training simulators and distribution network fault location applications.
 */
case class CurrentRelay
(
    override val sup: ProtectionEquipment,
    currentLimit1: Double,
    currentLimit2: Double,
    currentLimit3: Double,
    inverseTimeFlag: Boolean,
    timeDelay1: Double,
    timeDelay2: Double,
    timeDelay3: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, false, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ProtectionEquipment: ProtectionEquipment = sup.asInstanceOf[ProtectionEquipment]
    override def copy (): Row = { clone ().asInstanceOf[CurrentRelay] }
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
        "\t\t<cim:CurrentRelay.currentLimit1>" + currentLimit1 + "</cim:CurrentRelay.currentLimit1>\n" +
        "\t\t<cim:CurrentRelay.currentLimit2>" + currentLimit2 + "</cim:CurrentRelay.currentLimit2>\n" +
        "\t\t<cim:CurrentRelay.currentLimit3>" + currentLimit3 + "</cim:CurrentRelay.currentLimit3>\n" +
        "\t\t<cim:CurrentRelay.inverseTimeFlag>" + inverseTimeFlag + "</cim:CurrentRelay.inverseTimeFlag>\n" +
        "\t\t<cim:CurrentRelay.timeDelay1>" + timeDelay1 + "</cim:CurrentRelay.timeDelay1>\n" +
        "\t\t<cim:CurrentRelay.timeDelay2>" + timeDelay2 + "</cim:CurrentRelay.timeDelay2>\n" +
        "\t\t<cim:CurrentRelay.timeDelay3>" + timeDelay3 + "</cim:CurrentRelay.timeDelay3>\n"
    }
    override def export: String =
    {
        "\t<cim:CurrentRelay rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CurrentRelay>"
    }
}

object CurrentRelay
extends
    Parseable[CurrentRelay]
{
    val currentLimit1 = parse_element (element ("""CurrentRelay.currentLimit1"""))
    val currentLimit2 = parse_element (element ("""CurrentRelay.currentLimit2"""))
    val currentLimit3 = parse_element (element ("""CurrentRelay.currentLimit3"""))
    val inverseTimeFlag = parse_element (element ("""CurrentRelay.inverseTimeFlag"""))
    val timeDelay1 = parse_element (element ("""CurrentRelay.timeDelay1"""))
    val timeDelay2 = parse_element (element ("""CurrentRelay.timeDelay2"""))
    val timeDelay3 = parse_element (element ("""CurrentRelay.timeDelay3"""))
    def parse (context: Context): CurrentRelay =
    {
        CurrentRelay(
            ProtectionEquipment.parse (context),
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
 *
 * Protection equipment are associated with conducting equipment and usually operate circuit breakers.
 *
 * @param sup [[ch.ninecode.model.Equipment Equipment]] Reference to the superclass object.
 * @param highLimit The maximum allowable value.
 * @param lowLimit The minimum allowable value.
 * @param powerDirectionFlag Direction same as positive active power flow value.
 * @param relayDelayTime The time delay from detection of abnormal conditions to relay operation.
 * @param unitMultiplier The unit multiplier of the value.
 * @param unitSymbol The unit of measure of the value.
 * @param ConductingEquipments Protection equipment may be used to protect specific conducting equipment.
 * @param ProtectedSwitches Protected switches operated by this ProtectionEquipment.
 * @group Protection
 * @groupname Protection Package Protection
 * @groupdesc Protection An extension to the Core and Wires packages that models information for protection equipment such as relays. These entities are used within training simulators and distribution network fault location applications.
 */
case class ProtectionEquipment
(
    override val sup: Equipment,
    highLimit: Double,
    lowLimit: Double,
    powerDirectionFlag: Boolean,
    relayDelayTime: Double,
    unitMultiplier: String,
    unitSymbol: String,
    ConductingEquipments: List[String],
    ProtectedSwitches: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, false, 0.0, null, null, List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Equipment: Equipment = sup.asInstanceOf[Equipment]
    override def copy (): Row = { clone ().asInstanceOf[ProtectionEquipment] }
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
        "\t\t<cim:ProtectionEquipment.highLimit>" + highLimit + "</cim:ProtectionEquipment.highLimit>\n" +
        "\t\t<cim:ProtectionEquipment.lowLimit>" + lowLimit + "</cim:ProtectionEquipment.lowLimit>\n" +
        "\t\t<cim:ProtectionEquipment.powerDirectionFlag>" + powerDirectionFlag + "</cim:ProtectionEquipment.powerDirectionFlag>\n" +
        "\t\t<cim:ProtectionEquipment.relayDelayTime>" + relayDelayTime + "</cim:ProtectionEquipment.relayDelayTime>\n" +
        (if (null != unitMultiplier) "\t\t<cim:ProtectionEquipment.unitMultiplier rdf:resource=\"#" + unitMultiplier + "\"/>\n" else "") +
        (if (null != unitSymbol) "\t\t<cim:ProtectionEquipment.unitSymbol rdf:resource=\"#" + unitSymbol + "\"/>\n" else "") +
        (if (null != ConductingEquipments) ConductingEquipments.map (x => "\t\t<cim:ProtectionEquipment.ConductingEquipments rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != ProtectedSwitches) ProtectedSwitches.map (x => "\t\t<cim:ProtectionEquipment.ProtectedSwitches rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:ProtectionEquipment rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ProtectionEquipment>"
    }
}

object ProtectionEquipment
extends
    Parseable[ProtectionEquipment]
{
    val highLimit = parse_element (element ("""ProtectionEquipment.highLimit"""))
    val lowLimit = parse_element (element ("""ProtectionEquipment.lowLimit"""))
    val powerDirectionFlag = parse_element (element ("""ProtectionEquipment.powerDirectionFlag"""))
    val relayDelayTime = parse_element (element ("""ProtectionEquipment.relayDelayTime"""))
    val unitMultiplier = parse_attribute (attribute ("""ProtectionEquipment.unitMultiplier"""))
    val unitSymbol = parse_attribute (attribute ("""ProtectionEquipment.unitSymbol"""))
    val ConductingEquipments = parse_attributes (attribute ("""ProtectionEquipment.ConductingEquipments"""))
    val ProtectedSwitches = parse_attributes (attribute ("""ProtectionEquipment.ProtectedSwitches"""))
    def parse (context: Context): ProtectionEquipment =
    {
        ProtectionEquipment(
            Equipment.parse (context),
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
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param recloseDelay Indicates the time lapse before the reclose step will execute a reclose.
 * @param recloseStep Indicates the ordinal position of the reclose step relative to other steps in the sequence.
 * @param ProtectedSwitch [[ch.ninecode.model.ProtectedSwitch ProtectedSwitch]] A breaker may have zero or more automatic reclosures after a trip occurs.
 * @group Protection
 * @groupname Protection Package Protection
 * @groupdesc Protection An extension to the Core and Wires packages that models information for protection equipment such as relays. These entities are used within training simulators and distribution network fault location applications.
 */
case class RecloseSequence
(
    override val sup: IdentifiedObject,
    recloseDelay: Double,
    recloseStep: Int,
    ProtectedSwitch: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[RecloseSequence] }
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
        "\t\t<cim:RecloseSequence.recloseDelay>" + recloseDelay + "</cim:RecloseSequence.recloseDelay>\n" +
        "\t\t<cim:RecloseSequence.recloseStep>" + recloseStep + "</cim:RecloseSequence.recloseStep>\n" +
        (if (null != ProtectedSwitch) "\t\t<cim:RecloseSequence.ProtectedSwitch rdf:resource=\"#" + ProtectedSwitch + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:RecloseSequence rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RecloseSequence>"
    }
}

object RecloseSequence
extends
    Parseable[RecloseSequence]
{
    val recloseDelay = parse_element (element ("""RecloseSequence.recloseDelay"""))
    val recloseStep = parse_element (element ("""RecloseSequence.recloseStep"""))
    val ProtectedSwitch = parse_attribute (attribute ("""RecloseSequence.ProtectedSwitch"""))
    def parse (context: Context): RecloseSequence =
    {
        RecloseSequence(
            IdentifiedObject.parse (context),
            toDouble (recloseDelay (context), context),
            toInteger (recloseStep (context), context),
            ProtectedSwitch (context)
        )
    }
}

/**
 * A device that operates when two AC circuits are within the desired limits of frequency, phase angle, and voltage, to permit or to cause the paralleling of these two circuits.
 *
 * Used to prevent the paralleling of non-synchronous topological islands.
 *
 * @param sup [[ch.ninecode.model.ProtectionEquipment ProtectionEquipment]] Reference to the superclass object.
 * @param maxAngleDiff The maximum allowable voltage vector phase angle difference across the open device.
 * @param maxFreqDiff The maximum allowable frequency difference across the open device.
 * @param maxVoltDiff The maximum allowable difference voltage across the open device.
 * @group Protection
 * @groupname Protection Package Protection
 * @groupdesc Protection An extension to the Core and Wires packages that models information for protection equipment such as relays. These entities are used within training simulators and distribution network fault location applications.
 */
case class SynchrocheckRelay
(
    override val sup: ProtectionEquipment,
    maxAngleDiff: Double,
    maxFreqDiff: Double,
    maxVoltDiff: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ProtectionEquipment: ProtectionEquipment = sup.asInstanceOf[ProtectionEquipment]
    override def copy (): Row = { clone ().asInstanceOf[SynchrocheckRelay] }
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
        "\t\t<cim:SynchrocheckRelay.maxAngleDiff>" + maxAngleDiff + "</cim:SynchrocheckRelay.maxAngleDiff>\n" +
        "\t\t<cim:SynchrocheckRelay.maxFreqDiff>" + maxFreqDiff + "</cim:SynchrocheckRelay.maxFreqDiff>\n" +
        "\t\t<cim:SynchrocheckRelay.maxVoltDiff>" + maxVoltDiff + "</cim:SynchrocheckRelay.maxVoltDiff>\n"
    }
    override def export: String =
    {
        "\t<cim:SynchrocheckRelay rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SynchrocheckRelay>"
    }
}

object SynchrocheckRelay
extends
    Parseable[SynchrocheckRelay]
{
    val maxAngleDiff = parse_element (element ("""SynchrocheckRelay.maxAngleDiff"""))
    val maxFreqDiff = parse_element (element ("""SynchrocheckRelay.maxFreqDiff"""))
    val maxVoltDiff = parse_element (element ("""SynchrocheckRelay.maxVoltDiff"""))
    def parse (context: Context): SynchrocheckRelay =
    {
        SynchrocheckRelay(
            ProtectionEquipment.parse (context),
            toDouble (maxAngleDiff (context), context),
            toDouble (maxFreqDiff (context), context),
            toDouble (maxVoltDiff (context), context)
        )
    }
}

private[ninecode] object _Protection
{
    def register: List[ClassInfo] =
    {
        List (
            CurrentRelay.register,
            ProtectionEquipment.register,
            RecloseSequence.register,
            SynchrocheckRelay.register
        )
    }
}