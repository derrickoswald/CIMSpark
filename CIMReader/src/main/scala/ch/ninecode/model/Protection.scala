package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

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
final case class CurrentRelay
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
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CurrentRelay.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CurrentRelay.fields (position), value)
        emitelem (0, currentLimit1)
        emitelem (1, currentLimit2)
        emitelem (2, currentLimit3)
        emitelem (3, inverseTimeFlag)
        emitelem (4, timeDelay1)
        emitelem (5, timeDelay2)
        emitelem (6, timeDelay3)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CurrentRelay rdf:ID=\"%s\">\n%s\t</cim:CurrentRelay>".format (id, export_fields)
    }
}

object CurrentRelay
extends
    Parseable[CurrentRelay]
{
    override val fields: Array[String] = Array[String] (
        "currentLimit1",
        "currentLimit2",
        "currentLimit3",
        "inverseTimeFlag",
        "timeDelay1",
        "timeDelay2",
        "timeDelay3"
    )
    val currentLimit1: Fielder = parse_element (element (cls, fields(0)))
    val currentLimit2: Fielder = parse_element (element (cls, fields(1)))
    val currentLimit3: Fielder = parse_element (element (cls, fields(2)))
    val inverseTimeFlag: Fielder = parse_element (element (cls, fields(3)))
    val timeDelay1: Fielder = parse_element (element (cls, fields(4)))
    val timeDelay2: Fielder = parse_element (element (cls, fields(5)))
    val timeDelay3: Fielder = parse_element (element (cls, fields(6)))

    def parse (context: Context): CurrentRelay =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CurrentRelay (
            ProtectionEquipment.parse (context),
            toDouble (mask (currentLimit1 (), 0)),
            toDouble (mask (currentLimit2 (), 1)),
            toDouble (mask (currentLimit3 (), 2)),
            toBoolean (mask (inverseTimeFlag (), 3)),
            toDouble (mask (timeDelay1 (), 4)),
            toDouble (mask (timeDelay2 (), 5)),
            toDouble (mask (timeDelay3 (), 6))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * An electrical device designed to respond to input conditions in a prescribed manner and after specified conditions are met to cause contact operation or similar abrupt change in associated electric control circuits, or simply to display the detected condition.
 *
 * Protection equipment is associated with conducting equipment and usually operate circuit breakers.
 *
 * @param sup [[ch.ninecode.model.Equipment Equipment]] Reference to the superclass object.
 * @param highLimit The maximum allowable value.
 * @param lowLimit The minimum allowable value.
 * @param powerDirectionFlag Direction same as positive active power flow value.
 * @param relayDelayTime The time delay from detection of abnormal conditions to relay operation.
 * @param unitMultiplier The unit multiplier of the value.
 * @param unitSymbol The unit of measure of the value.
 * @param ConductingEquipments [[ch.ninecode.model.ConductingEquipment ConductingEquipment]] Protection equipment may be used to protect specific conducting equipment.
 * @param ProtectedSwitches [[ch.ninecode.model.ProtectedSwitch ProtectedSwitch]] Protected switches operated by this ProtectionEquipment.
 * @param ProtectiveAction [[ch.ninecode.model.ProtectiveAction ProtectiveAction]] Protective action can emulate the action done by one or more protection equipment.
 *        In a node breaker model were protective equipment is model this association will be used.
 * @group Protection
 * @groupname Protection Package Protection
 * @groupdesc Protection An extension to the Core and Wires packages that models information for protection equipment such as relays. These entities are used within training simulators and distribution network fault location applications.
 */
final case class ProtectionEquipment
(
    override val sup: Equipment,
    highLimit: Double,
    lowLimit: Double,
    powerDirectionFlag: Boolean,
    relayDelayTime: Double,
    unitMultiplier: String,
    unitSymbol: String,
    ConductingEquipments: List[String],
    ProtectedSwitches: List[String],
    ProtectiveAction: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, false, 0.0, null, null, List(), List(), List()) }
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
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ProtectionEquipment.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ProtectionEquipment.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ProtectionEquipment.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ProtectionEquipment.fields (position), x))
        emitelem (0, highLimit)
        emitelem (1, lowLimit)
        emitelem (2, powerDirectionFlag)
        emitelem (3, relayDelayTime)
        emitattr (4, unitMultiplier)
        emitattr (5, unitSymbol)
        emitattrs (6, ConductingEquipments)
        emitattrs (7, ProtectedSwitches)
        emitattrs (8, ProtectiveAction)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ProtectionEquipment rdf:ID=\"%s\">\n%s\t</cim:ProtectionEquipment>".format (id, export_fields)
    }
}

object ProtectionEquipment
extends
    Parseable[ProtectionEquipment]
{
    override val fields: Array[String] = Array[String] (
        "highLimit",
        "lowLimit",
        "powerDirectionFlag",
        "relayDelayTime",
        "unitMultiplier",
        "unitSymbol",
        "ConductingEquipments",
        "ProtectedSwitches",
        "ProtectiveAction"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ConductingEquipments", "ConductingEquipment", "0..*", "0..*"),
        Relationship ("ProtectedSwitches", "ProtectedSwitch", "0..*", "0..*"),
        Relationship ("ProtectiveAction", "ProtectiveAction", "0..*", "0..1")
    )
    val highLimit: Fielder = parse_element (element (cls, fields(0)))
    val lowLimit: Fielder = parse_element (element (cls, fields(1)))
    val powerDirectionFlag: Fielder = parse_element (element (cls, fields(2)))
    val relayDelayTime: Fielder = parse_element (element (cls, fields(3)))
    val unitMultiplier: Fielder = parse_attribute (attribute (cls, fields(4)))
    val unitSymbol: Fielder = parse_attribute (attribute (cls, fields(5)))
    val ConductingEquipments: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val ProtectedSwitches: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val ProtectiveAction: FielderMultiple = parse_attributes (attribute (cls, fields(8)))

    def parse (context: Context): ProtectionEquipment =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ProtectionEquipment (
            Equipment.parse (context),
            toDouble (mask (highLimit (), 0)),
            toDouble (mask (lowLimit (), 1)),
            toBoolean (mask (powerDirectionFlag (), 2)),
            toDouble (mask (relayDelayTime (), 3)),
            mask (unitMultiplier (), 4),
            mask (unitSymbol (), 5),
            masks (ConductingEquipments (), 6),
            masks (ProtectedSwitches (), 7),
            masks (ProtectiveAction (), 8)
        )
        ret.bitfields = bitfields
        ret
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
final case class RecloseSequence
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
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = RecloseSequence.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (RecloseSequence.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RecloseSequence.fields (position), value)
        emitelem (0, recloseDelay)
        emitelem (1, recloseStep)
        emitattr (2, ProtectedSwitch)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RecloseSequence rdf:ID=\"%s\">\n%s\t</cim:RecloseSequence>".format (id, export_fields)
    }
}

object RecloseSequence
extends
    Parseable[RecloseSequence]
{
    override val fields: Array[String] = Array[String] (
        "recloseDelay",
        "recloseStep",
        "ProtectedSwitch"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ProtectedSwitch", "ProtectedSwitch", "1", "0..*")
    )
    val recloseDelay: Fielder = parse_element (element (cls, fields(0)))
    val recloseStep: Fielder = parse_element (element (cls, fields(1)))
    val ProtectedSwitch: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): RecloseSequence =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = RecloseSequence (
            IdentifiedObject.parse (context),
            toDouble (mask (recloseDelay (), 0)),
            toInteger (mask (recloseStep (), 1)),
            mask (ProtectedSwitch (), 2)
        )
        ret.bitfields = bitfields
        ret
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
final case class SynchrocheckRelay
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
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = SynchrocheckRelay.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SynchrocheckRelay.fields (position), value)
        emitelem (0, maxAngleDiff)
        emitelem (1, maxFreqDiff)
        emitelem (2, maxVoltDiff)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SynchrocheckRelay rdf:ID=\"%s\">\n%s\t</cim:SynchrocheckRelay>".format (id, export_fields)
    }
}

object SynchrocheckRelay
extends
    Parseable[SynchrocheckRelay]
{
    override val fields: Array[String] = Array[String] (
        "maxAngleDiff",
        "maxFreqDiff",
        "maxVoltDiff"
    )
    val maxAngleDiff: Fielder = parse_element (element (cls, fields(0)))
    val maxFreqDiff: Fielder = parse_element (element (cls, fields(1)))
    val maxVoltDiff: Fielder = parse_element (element (cls, fields(2)))

    def parse (context: Context): SynchrocheckRelay =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SynchrocheckRelay (
            ProtectionEquipment.parse (context),
            toDouble (mask (maxAngleDiff (), 0)),
            toDouble (mask (maxFreqDiff (), 1)),
            toDouble (mask (maxVoltDiff (), 2))
        )
        ret.bitfields = bitfields
        ret
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