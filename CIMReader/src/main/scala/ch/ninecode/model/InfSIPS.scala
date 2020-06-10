package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.CIMClassInfo
import ch.ninecode.cim.CIMContext
import ch.ninecode.cim.CIMParseable
import ch.ninecode.cim.CIMRelationship

/**
 * Logical gate than support logical operation based on the input.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param kind The logical operation of the gate.
 * @param GateInputPin [[ch.ninecode.model.GateInputPin GateInputPin]] Input to the gate.
 * @param PinGate [[ch.ninecode.model.PinGate PinGate]] <em>undocumented</em>
 * @param ProtectiveActionCom [[ch.ninecode.model.ProtectiveAction ProtectiveAction]] For the ProtectiveAction to be activated the condition for communication needs to be met (true).
 * @param ProtectiveActionEnabled [[ch.ninecode.model.ProtectiveAction ProtectiveAction]] <em>undocumented</em>
 * @param RemedialActionScheme [[ch.ninecode.model.RemedialActionScheme RemedialActionScheme]] <em>undocumented</em>
 * @param StageTrigger [[ch.ninecode.model.StageTrigger StageTrigger]] <em>undocumented</em>
 * @param StageTriggerArmed [[ch.ninecode.model.StageTrigger StageTrigger]] <em>undocumented</em>
 * @param StageTriggerCom [[ch.ninecode.model.StageTrigger StageTrigger]] <em>undocumented</em>
 * @param TriggerCondition [[ch.ninecode.model.TriggerCondition TriggerCondition]] <em>undocumented</em>
 * @group InfSIPS
 * @groupname InfSIPS Package InfSIPS
 * @groupdesc InfSIPS System Integrity Protection Schemes (SIPS) (IEC terminology). Other names used are: Remedial Action Schemes (RAS) or System Protection Schemes (SPS).
 */
final case class Gate
(
    IdentifiedObject: IdentifiedObject = null,
    kind: String = null,
    GateInputPin: List[String] = null,
    PinGate: List[String] = null,
    ProtectiveActionCom: List[String] = null,
    ProtectiveActionEnabled: List[String] = null,
    RemedialActionScheme: List[String] = null,
    StageTrigger: List[String] = null,
    StageTriggerArmed: List[String] = null,
    StageTriggerCom: List[String] = null,
    TriggerCondition: List[String] = null
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
        implicit val clz: String = Gate.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Gate.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Gate.fields (position), x))
        emitattr (0, kind)
        emitattrs (1, GateInputPin)
        emitattrs (2, PinGate)
        emitattrs (3, ProtectiveActionCom)
        emitattrs (4, ProtectiveActionEnabled)
        emitattrs (5, RemedialActionScheme)
        emitattrs (6, StageTrigger)
        emitattrs (7, StageTriggerArmed)
        emitattrs (8, StageTriggerCom)
        emitattrs (9, TriggerCondition)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Gate rdf:ID=\"%s\">\n%s\t</cim:Gate>".format (id, export_fields)
    }
}

object Gate
extends
    CIMParseable[Gate]
{
    override val fields: Array[String] = Array[String] (
        "kind",
        "GateInputPin",
        "PinGate",
        "ProtectiveActionCom",
        "ProtectiveActionEnabled",
        "RemedialActionScheme",
        "StageTrigger",
        "StageTriggerArmed",
        "StageTriggerCom",
        "TriggerCondition"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("GateInputPin", "GateInputPin", "1..*", "1"),
        CIMRelationship ("PinGate", "PinGate", "0..*", "1"),
        CIMRelationship ("ProtectiveActionCom", "ProtectiveAction", "0..*", "0..1"),
        CIMRelationship ("ProtectiveActionEnabled", "ProtectiveAction", "0..*", "0..1"),
        CIMRelationship ("RemedialActionScheme", "RemedialActionScheme", "0..*", "0..1"),
        CIMRelationship ("StageTrigger", "StageTrigger", "0..*", "0..1"),
        CIMRelationship ("StageTriggerArmed", "StageTrigger", "0..*", "0..1"),
        CIMRelationship ("StageTriggerCom", "StageTrigger", "0..*", "0..1"),
        CIMRelationship ("TriggerCondition", "TriggerCondition", "0..*", "1")
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val GateInputPin: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val PinGate: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val ProtectiveActionCom: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val ProtectiveActionEnabled: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val RemedialActionScheme: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val StageTrigger: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val StageTriggerArmed: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val StageTriggerCom: FielderMultiple = parse_attributes (attribute (cls, fields(8)))
    val TriggerCondition: FielderMultiple = parse_attributes (attribute (cls, fields(9)))

    def parse (context: CIMContext): Gate =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Gate (
            IdentifiedObject.parse (context),
            mask (kind (), 0),
            masks (GateInputPin (), 1),
            masks (PinGate (), 2),
            masks (ProtectiveActionCom (), 3),
            masks (ProtectiveActionEnabled (), 4),
            masks (RemedialActionScheme (), 5),
            masks (StageTrigger (), 6),
            masks (StageTriggerArmed (), 7),
            masks (StageTriggerCom (), 8),
            masks (TriggerCondition (), 9)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Input pin for a logical gate.
 *
 * The condition described in the input pin will give a logical true or false. Result from measurement and calculation are converted to a true or false.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param aDLogicKind The compare operation.
 * @param absoluteValue If true, use the absolute value for compare..
 * @param duration The duration the compare condition need to be present before given a true.
 *        Default is 0 seconds.
 * @param negate Invert/negate the result of the compare.
 * @param thresholdPercentage The threshold percentage that should be used for compare with the percentage change between input value and threshold value.
 * @param thresholdValue The threshold value that should be used for compare with the input value.
 * @param Gate [[ch.ninecode.model.Gate Gate]] <em>undocumented</em>
 * @group InfSIPS
 * @groupname InfSIPS Package InfSIPS
 * @groupdesc InfSIPS System Integrity Protection Schemes (SIPS) (IEC terminology). Other names used are: Remedial Action Schemes (RAS) or System Protection Schemes (SPS).
 */
final case class GateInputPin
(
    IdentifiedObject: IdentifiedObject = null,
    aDLogicKind: String = null,
    absoluteValue: Boolean = false,
    duration: Double = 0.0,
    negate: Boolean = false,
    thresholdPercentage: Double = 0.0,
    thresholdValue: Double = 0.0,
    Gate: String = null
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
        implicit val clz: String = GateInputPin.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GateInputPin.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (GateInputPin.fields (position), value)
        emitattr (0, aDLogicKind)
        emitelem (1, absoluteValue)
        emitelem (2, duration)
        emitelem (3, negate)
        emitelem (4, thresholdPercentage)
        emitelem (5, thresholdValue)
        emitattr (6, Gate)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GateInputPin rdf:ID=\"%s\">\n%s\t</cim:GateInputPin>".format (id, export_fields)
    }
}

object GateInputPin
extends
    CIMParseable[GateInputPin]
{
    override val fields: Array[String] = Array[String] (
        "aDLogicKind",
        "absoluteValue",
        "duration",
        "negate",
        "thresholdPercentage",
        "thresholdValue",
        "Gate"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Gate", "Gate", "1", "1..*")
    )
    val aDLogicKind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val absoluteValue: Fielder = parse_element (element (cls, fields(1)))
    val duration: Fielder = parse_element (element (cls, fields(2)))
    val negate: Fielder = parse_element (element (cls, fields(3)))
    val thresholdPercentage: Fielder = parse_element (element (cls, fields(4)))
    val thresholdValue: Fielder = parse_element (element (cls, fields(5)))
    val Gate: Fielder = parse_attribute (attribute (cls, fields(6)))

    def parse (context: CIMContext): GateInputPin =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = GateInputPin (
            IdentifiedObject.parse (context),
            mask (aDLogicKind (), 0),
            toBoolean (mask (absoluteValue (), 1)),
            toDouble (mask (duration (), 2)),
            toBoolean (mask (negate (), 3)),
            toDouble (mask (thresholdPercentage (), 4)),
            toDouble (mask (thresholdValue (), 5)),
            mask (Gate (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Result of a calculation of one or more measurement.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param kind Calculation operation executed on the operants.
 * @param MeasurementCalculatorInput [[ch.ninecode.model.MeasurementCalculatorInput MeasurementCalculatorInput]] Used in the calculation.
 * @param PinMeasurement [[ch.ninecode.model.PinMeasurement PinMeasurement]] <em>undocumented</em>
 * @group InfSIPS
 * @groupname InfSIPS Package InfSIPS
 * @groupdesc InfSIPS System Integrity Protection Schemes (SIPS) (IEC terminology). Other names used are: Remedial Action Schemes (RAS) or System Protection Schemes (SPS).
 */
final case class MeasurementCalculator
(
    IdentifiedObject: IdentifiedObject = null,
    kind: String = null,
    MeasurementCalculatorInput: List[String] = null,
    PinMeasurement: List[String] = null
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
        implicit val clz: String = MeasurementCalculator.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MeasurementCalculator.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MeasurementCalculator.fields (position), x))
        emitattr (0, kind)
        emitattrs (1, MeasurementCalculatorInput)
        emitattrs (2, PinMeasurement)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MeasurementCalculator rdf:ID=\"%s\">\n%s\t</cim:MeasurementCalculator>".format (id, export_fields)
    }
}

object MeasurementCalculator
extends
    CIMParseable[MeasurementCalculator]
{
    override val fields: Array[String] = Array[String] (
        "kind",
        "MeasurementCalculatorInput",
        "PinMeasurement"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("MeasurementCalculatorInput", "MeasurementCalculatorInput", "1..*", "1"),
        CIMRelationship ("PinMeasurement", "PinMeasurement", "0..*", "0..1")
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val MeasurementCalculatorInput: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val PinMeasurement: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: CIMContext): MeasurementCalculator =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MeasurementCalculator (
            IdentifiedObject.parse (context),
            mask (kind (), 0),
            masks (MeasurementCalculatorInput (), 1),
            masks (PinMeasurement (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Input to measurement calculation.
 *
 * Support Analog, Discrete and Accumulator.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param absoluteValue If true, use the absolute value for the calculation.
 * @param order Positive number that defines the order of the operant in the calculation. 0 = default.
 *        The order is not relevant (e.g. summation).
 * @param Measurement [[ch.ninecode.model.Measurement Measurement]] Measurement used as input to a calculation.
 * @param MeasurementCalculator [[ch.ninecode.model.MeasurementCalculator MeasurementCalculator]] <em>undocumented</em>
 * @group InfSIPS
 * @groupname InfSIPS Package InfSIPS
 * @groupdesc InfSIPS System Integrity Protection Schemes (SIPS) (IEC terminology). Other names used are: Remedial Action Schemes (RAS) or System Protection Schemes (SPS).
 */
final case class MeasurementCalculatorInput
(
    IdentifiedObject: IdentifiedObject = null,
    absoluteValue: Boolean = false,
    order: Int = 0,
    Measurement: String = null,
    MeasurementCalculator: String = null
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
        implicit val clz: String = MeasurementCalculatorInput.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MeasurementCalculatorInput.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MeasurementCalculatorInput.fields (position), value)
        emitelem (0, absoluteValue)
        emitelem (1, order)
        emitattr (2, Measurement)
        emitattr (3, MeasurementCalculator)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MeasurementCalculatorInput rdf:ID=\"%s\">\n%s\t</cim:MeasurementCalculatorInput>".format (id, export_fields)
    }
}

object MeasurementCalculatorInput
extends
    CIMParseable[MeasurementCalculatorInput]
{
    override val fields: Array[String] = Array[String] (
        "absoluteValue",
        "order",
        "Measurement",
        "MeasurementCalculator"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Measurement", "Measurement", "1", "0..*"),
        CIMRelationship ("MeasurementCalculator", "MeasurementCalculator", "1", "1..*")
    )
    val absoluteValue: Fielder = parse_element (element (cls, fields(0)))
    val order: Fielder = parse_element (element (cls, fields(1)))
    val Measurement: Fielder = parse_attribute (attribute (cls, fields(2)))
    val MeasurementCalculator: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: CIMContext): MeasurementCalculatorInput =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MeasurementCalculatorInput (
            IdentifiedObject.parse (context),
            toBoolean (mask (absoluteValue (), 0)),
            toInteger (mask (order (), 1)),
            mask (Measurement (), 2),
            mask (MeasurementCalculator (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Value associated with branch group is used as compare.
 *
 * @param GateInputPin [[ch.ninecode.model.GateInputPin GateInputPin]] Reference to the superclass object.
 * @param kind The compare operation done on the branch group.
 * @param BranchGroup [[ch.ninecode.model.BranchGroup BranchGroup]] The branch group that should be used in compare.
 * @group InfSIPS
 * @groupname InfSIPS Package InfSIPS
 * @groupdesc InfSIPS System Integrity Protection Schemes (SIPS) (IEC terminology). Other names used are: Remedial Action Schemes (RAS) or System Protection Schemes (SPS).
 */
final case class PinBranchGroup
(
    GateInputPin: GateInputPin = null,
    kind: String = null,
    BranchGroup: String = null
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
    override def sup: GateInputPin = GateInputPin

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
        implicit val clz: String = PinBranchGroup.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PinBranchGroup.fields (position), value)
        emitattr (0, kind)
        emitattr (1, BranchGroup)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PinBranchGroup rdf:ID=\"%s\">\n%s\t</cim:PinBranchGroup>".format (id, export_fields)
    }
}

object PinBranchGroup
extends
    CIMParseable[PinBranchGroup]
{
    override val fields: Array[String] = Array[String] (
        "kind",
        "BranchGroup"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("BranchGroup", "BranchGroup", "1", "0..*")
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val BranchGroup: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): PinBranchGroup =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PinBranchGroup (
            GateInputPin.parse (context),
            mask (kind (), 0),
            mask (BranchGroup (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Value associated with Equipment is used as compare.
 *
 * @param GateInputPin [[ch.ninecode.model.GateInputPin GateInputPin]] Reference to the superclass object.
 * @param kind The compare operation done on the equipment.
 * @param Equipment [[ch.ninecode.model.Equipment Equipment]] The Equipment that should be used in compare.
 * @group InfSIPS
 * @groupname InfSIPS Package InfSIPS
 * @groupdesc InfSIPS System Integrity Protection Schemes (SIPS) (IEC terminology). Other names used are: Remedial Action Schemes (RAS) or System Protection Schemes (SPS).
 */
final case class PinEquipment
(
    GateInputPin: GateInputPin = null,
    kind: String = null,
    Equipment: String = null
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
    override def sup: GateInputPin = GateInputPin

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
        implicit val clz: String = PinEquipment.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PinEquipment.fields (position), value)
        emitattr (0, kind)
        emitattr (1, Equipment)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PinEquipment rdf:ID=\"%s\">\n%s\t</cim:PinEquipment>".format (id, export_fields)
    }
}

object PinEquipment
extends
    CIMParseable[PinEquipment]
{
    override val fields: Array[String] = Array[String] (
        "kind",
        "Equipment"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Equipment", "Equipment", "1", "0..*")
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val Equipment: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): PinEquipment =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PinEquipment (
            GateInputPin.parse (context),
            mask (kind (), 0),
            mask (Equipment (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * An output from one gate represent an input to another gate.
 *
 * @param GateInputPin [[ch.ninecode.model.GateInputPin GateInputPin]] Reference to the superclass object.
 * @param GateOutput [[ch.ninecode.model.Gate Gate]] <em>undocumented</em>
 * @group InfSIPS
 * @groupname InfSIPS Package InfSIPS
 * @groupdesc InfSIPS System Integrity Protection Schemes (SIPS) (IEC terminology). Other names used are: Remedial Action Schemes (RAS) or System Protection Schemes (SPS).
 */
final case class PinGate
(
    GateInputPin: GateInputPin = null,
    GateOutput: String = null
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
    override def sup: GateInputPin = GateInputPin

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
        implicit val clz: String = PinGate.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PinGate.fields (position), value)
        emitattr (0, GateOutput)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PinGate rdf:ID=\"%s\">\n%s\t</cim:PinGate>".format (id, export_fields)
    }
}

object PinGate
extends
    CIMParseable[PinGate]
{
    override val fields: Array[String] = Array[String] (
        "GateOutput"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("GateOutput", "Gate", "1", "0..*")
    )
    val GateOutput: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): PinGate =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PinGate (
            GateInputPin.parse (context),
            mask (GateOutput (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Gate input pin that is associated with a Measurement or a calculation of Measurement.
 *
 * @param GateInputPin [[ch.ninecode.model.GateInputPin GateInputPin]] Reference to the superclass object.
 * @param Measurement [[ch.ninecode.model.Measurement Measurement]] The Measurement that should be used in compare.
 * @param MeasurementCalculator [[ch.ninecode.model.MeasurementCalculator MeasurementCalculator]] Result of the calculation used as input to a gate.
 * @group InfSIPS
 * @groupname InfSIPS Package InfSIPS
 * @groupdesc InfSIPS System Integrity Protection Schemes (SIPS) (IEC terminology). Other names used are: Remedial Action Schemes (RAS) or System Protection Schemes (SPS).
 */
final case class PinMeasurement
(
    GateInputPin: GateInputPin = null,
    Measurement: String = null,
    MeasurementCalculator: String = null
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
    override def sup: GateInputPin = GateInputPin

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
        implicit val clz: String = PinMeasurement.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PinMeasurement.fields (position), value)
        emitattr (0, Measurement)
        emitattr (1, MeasurementCalculator)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PinMeasurement rdf:ID=\"%s\">\n%s\t</cim:PinMeasurement>".format (id, export_fields)
    }
}

object PinMeasurement
extends
    CIMParseable[PinMeasurement]
{
    override val fields: Array[String] = Array[String] (
        "Measurement",
        "MeasurementCalculator"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Measurement", "Measurement", "0..1", "0..*"),
        CIMRelationship ("MeasurementCalculator", "MeasurementCalculator", "0..1", "0..*")
    )
    val Measurement: Fielder = parse_attribute (attribute (cls, fields(0)))
    val MeasurementCalculator: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): PinMeasurement =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PinMeasurement (
            GateInputPin.parse (context),
            mask (Measurement (), 0),
            mask (MeasurementCalculator (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Value associated with Terminal is used as compare.
 *
 * @param GateInputPin [[ch.ninecode.model.GateInputPin GateInputPin]] Reference to the superclass object.
 * @param kind The compare operation done on the terminal.
 * @param Terminal [[ch.ninecode.model.Terminal Terminal]] The Terminal that should be used in compare.
 * @group InfSIPS
 * @groupname InfSIPS Package InfSIPS
 * @groupdesc InfSIPS System Integrity Protection Schemes (SIPS) (IEC terminology). Other names used are: Remedial Action Schemes (RAS) or System Protection Schemes (SPS).
 */
final case class PinTerminal
(
    GateInputPin: GateInputPin = null,
    kind: String = null,
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
    override def sup: GateInputPin = GateInputPin

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
        implicit val clz: String = PinTerminal.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PinTerminal.fields (position), value)
        emitattr (0, kind)
        emitattr (1, Terminal)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PinTerminal rdf:ID=\"%s\">\n%s\t</cim:PinTerminal>".format (id, export_fields)
    }
}

object PinTerminal
extends
    CIMParseable[PinTerminal]
{
    override val fields: Array[String] = Array[String] (
        "kind",
        "Terminal"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Terminal", "Terminal", "1", "0..*")
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val Terminal: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): PinTerminal =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PinTerminal (
            GateInputPin.parse (context),
            mask (kind (), 0),
            mask (Terminal (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A protective action for supporting the integrity of the power system.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param enabled The status of the class set by operation or by signal.
 *        Optional field that will override other status fields.
 * @param normalEnabled The default/normal value used when other active signal/values are missing.
 * @param GateComCondition [[ch.ninecode.model.Gate Gate]] <em>undocumented</em>
 * @param GateEnabledCondition [[ch.ninecode.model.Gate Gate]] Association to a Gate that through a gate logic and input pin defines enabling of the ProtectiveAction.
 * @param ProtectionEquipment [[ch.ninecode.model.ProtectionEquipment ProtectionEquipment]] <em>undocumented</em>
 * @param ProtectiveActionCollection [[ch.ninecode.model.ProtectiveActionCollection ProtectiveActionCollection]] <em>undocumented</em>
 * @group InfSIPS
 * @groupname InfSIPS Package InfSIPS
 * @groupdesc InfSIPS System Integrity Protection Schemes (SIPS) (IEC terminology). Other names used are: Remedial Action Schemes (RAS) or System Protection Schemes (SPS).
 */
final case class ProtectiveAction
(
    IdentifiedObject: IdentifiedObject = null,
    enabled: Boolean = false,
    normalEnabled: Boolean = false,
    GateComCondition: String = null,
    GateEnabledCondition: String = null,
    ProtectionEquipment: String = null,
    ProtectiveActionCollection: String = null
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
        implicit val clz: String = ProtectiveAction.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ProtectiveAction.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ProtectiveAction.fields (position), value)
        emitelem (0, enabled)
        emitelem (1, normalEnabled)
        emitattr (2, GateComCondition)
        emitattr (3, GateEnabledCondition)
        emitattr (4, ProtectionEquipment)
        emitattr (5, ProtectiveActionCollection)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ProtectiveAction rdf:ID=\"%s\">\n%s\t</cim:ProtectiveAction>".format (id, export_fields)
    }
}

object ProtectiveAction
extends
    CIMParseable[ProtectiveAction]
{
    override val fields: Array[String] = Array[String] (
        "enabled",
        "normalEnabled",
        "GateComCondition",
        "GateEnabledCondition",
        "ProtectionEquipment",
        "ProtectiveActionCollection"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("GateComCondition", "Gate", "0..1", "0..*"),
        CIMRelationship ("GateEnabledCondition", "Gate", "0..1", "0..*"),
        CIMRelationship ("ProtectionEquipment", "ProtectionEquipment", "0..1", "0..*"),
        CIMRelationship ("ProtectiveActionCollection", "ProtectiveActionCollection", "1", "1..*")
    )
    val enabled: Fielder = parse_element (element (cls, fields(0)))
    val normalEnabled: Fielder = parse_element (element (cls, fields(1)))
    val GateComCondition: Fielder = parse_attribute (attribute (cls, fields(2)))
    val GateEnabledCondition: Fielder = parse_attribute (attribute (cls, fields(3)))
    val ProtectionEquipment: Fielder = parse_attribute (attribute (cls, fields(4)))
    val ProtectiveActionCollection: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: CIMContext): ProtectiveAction =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ProtectiveAction (
            IdentifiedObject.parse (context),
            toBoolean (mask (enabled (), 0)),
            toBoolean (mask (normalEnabled (), 1)),
            mask (GateComCondition (), 2),
            mask (GateEnabledCondition (), 3),
            mask (ProtectionEquipment (), 4),
            mask (ProtectiveActionCollection (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Protective actions on non-switching equipment.
 *
 * The operating condition is adjusted.
 *
 * @param ProtectiveAction [[ch.ninecode.model.ProtectiveAction ProtectiveAction]] Reference to the superclass object.
 * @param byPercentage The adjustment is given in percent of the active value.
 * @param byValue The adjustment is given in value of the active value.
 * @param kind Defines the kind of adjustment that should be done.
 *        With this value the correct attribute containing the value needs to be used.
 * @param reduce If true, the adjusted value is an reduction.
 *        Other wise it is an increase in the value.
 * @param setValue The adjustment is given by a new active value.
 * @param ConductingEquipment [[ch.ninecode.model.ConductingEquipment ConductingEquipment]] ConductingEquipment whose operating condition is changed when this protective action adjustment gets activated.
 * @param DCConductingEquipment [[ch.ninecode.model.DCConductingEquipment DCConductingEquipment]] The operating condition to the Conducting Equipment is changed when protective action adjustment is activated.
 * @param Measurement [[ch.ninecode.model.Measurement Measurement]] The measurement is used to control the operation of an equipment.
 * @group InfSIPS
 * @groupname InfSIPS Package InfSIPS
 * @groupdesc InfSIPS System Integrity Protection Schemes (SIPS) (IEC terminology). Other names used are: Remedial Action Schemes (RAS) or System Protection Schemes (SPS).
 */
final case class ProtectiveActionAdjustment
(
    ProtectiveAction: ProtectiveAction = null,
    byPercentage: Double = 0.0,
    byValue: Double = 0.0,
    kind: String = null,
    reduce: Boolean = false,
    setValue: Double = 0.0,
    ConductingEquipment: String = null,
    DCConductingEquipment: String = null,
    Measurement: String = null
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
    override def sup: ProtectiveAction = ProtectiveAction

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
        implicit val clz: String = ProtectiveActionAdjustment.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ProtectiveActionAdjustment.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ProtectiveActionAdjustment.fields (position), value)
        emitelem (0, byPercentage)
        emitelem (1, byValue)
        emitattr (2, kind)
        emitelem (3, reduce)
        emitelem (4, setValue)
        emitattr (5, ConductingEquipment)
        emitattr (6, DCConductingEquipment)
        emitattr (7, Measurement)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ProtectiveActionAdjustment rdf:ID=\"%s\">\n%s\t</cim:ProtectiveActionAdjustment>".format (id, export_fields)
    }
}

object ProtectiveActionAdjustment
extends
    CIMParseable[ProtectiveActionAdjustment]
{
    override val fields: Array[String] = Array[String] (
        "byPercentage",
        "byValue",
        "kind",
        "reduce",
        "setValue",
        "ConductingEquipment",
        "DCConductingEquipment",
        "Measurement"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ConductingEquipment", "ConductingEquipment", "1", "0..*"),
        CIMRelationship ("DCConductingEquipment", "DCConductingEquipment", "1", "0..*"),
        CIMRelationship ("Measurement", "Measurement", "0..1", "0..*")
    )
    val byPercentage: Fielder = parse_element (element (cls, fields(0)))
    val byValue: Fielder = parse_element (element (cls, fields(1)))
    val kind: Fielder = parse_attribute (attribute (cls, fields(2)))
    val reduce: Fielder = parse_element (element (cls, fields(3)))
    val setValue: Fielder = parse_element (element (cls, fields(4)))
    val ConductingEquipment: Fielder = parse_attribute (attribute (cls, fields(5)))
    val DCConductingEquipment: Fielder = parse_attribute (attribute (cls, fields(6)))
    val Measurement: Fielder = parse_attribute (attribute (cls, fields(7)))

    def parse (context: CIMContext): ProtectiveActionAdjustment =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ProtectiveActionAdjustment (
            ProtectiveAction.parse (context),
            toDouble (mask (byPercentage (), 0)),
            toDouble (mask (byValue (), 1)),
            mask (kind (), 2),
            toBoolean (mask (reduce (), 3)),
            toDouble (mask (setValue (), 4)),
            mask (ConductingEquipment (), 5),
            mask (DCConductingEquipment (), 6),
            mask (Measurement (), 7)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A collection of protective actions to protect the integrity of the power system.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param ProtectiveAction [[ch.ninecode.model.ProtectiveAction ProtectiveAction]] Set of ProtectiveAction belonging to a ProtectiveActionCollection.
 * @param StageTrigger [[ch.ninecode.model.StageTrigger StageTrigger]] When condition to the StageTrigger is met, the actions in the ProtectiveActionCollection are activated/triggered.
 * @group InfSIPS
 * @groupname InfSIPS Package InfSIPS
 * @groupdesc InfSIPS System Integrity Protection Schemes (SIPS) (IEC terminology). Other names used are: Remedial Action Schemes (RAS) or System Protection Schemes (SPS).
 */
final case class ProtectiveActionCollection
(
    IdentifiedObject: IdentifiedObject = null,
    ProtectiveAction: List[String] = null,
    StageTrigger: List[String] = null
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
        implicit val clz: String = ProtectiveActionCollection.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ProtectiveActionCollection.fields (position), x))
        emitattrs (0, ProtectiveAction)
        emitattrs (1, StageTrigger)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ProtectiveActionCollection rdf:ID=\"%s\">\n%s\t</cim:ProtectiveActionCollection>".format (id, export_fields)
    }
}

object ProtectiveActionCollection
extends
    CIMParseable[ProtectiveActionCollection]
{
    override val fields: Array[String] = Array[String] (
        "ProtectiveAction",
        "StageTrigger"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ProtectiveAction", "ProtectiveAction", "1..*", "1"),
        CIMRelationship ("StageTrigger", "StageTrigger", "0..*", "1")
    )
    val ProtectiveAction: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val StageTrigger: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): ProtectiveActionCollection =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ProtectiveActionCollection (
            IdentifiedObject.parse (context),
            masks (ProtectiveAction (), 0),
            masks (StageTrigger (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Protective action to put an Equipment in-service/out-of-service.
 *
 * @param ProtectiveAction [[ch.ninecode.model.ProtectiveAction ProtectiveAction]] Reference to the superclass object.
 * @param inService If true the equipment is put in-service, otherwise out-of-service.
 * @param Equipment [[ch.ninecode.model.Equipment Equipment]] <em>undocumented</em>
 * @group InfSIPS
 * @groupname InfSIPS Package InfSIPS
 * @groupdesc InfSIPS System Integrity Protection Schemes (SIPS) (IEC terminology). Other names used are: Remedial Action Schemes (RAS) or System Protection Schemes (SPS).
 */
final case class ProtectiveActionEquipment
(
    ProtectiveAction: ProtectiveAction = null,
    inService: Boolean = false,
    Equipment: String = null
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
    override def sup: ProtectiveAction = ProtectiveAction

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
        implicit val clz: String = ProtectiveActionEquipment.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ProtectiveActionEquipment.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ProtectiveActionEquipment.fields (position), value)
        emitelem (0, inService)
        emitattr (1, Equipment)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ProtectiveActionEquipment rdf:ID=\"%s\">\n%s\t</cim:ProtectiveActionEquipment>".format (id, export_fields)
    }
}

object ProtectiveActionEquipment
extends
    CIMParseable[ProtectiveActionEquipment]
{
    override val fields: Array[String] = Array[String] (
        "inService",
        "Equipment"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Equipment", "Equipment", "1", "0..*")
    )
    val inService: Fielder = parse_element (element (cls, fields(0)))
    val Equipment: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): ProtectiveActionEquipment =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ProtectiveActionEquipment (
            ProtectiveAction.parse (context),
            toBoolean (mask (inService (), 0)),
            mask (Equipment (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Protective action to change regulation to Equipment.
 *
 * @param ProtectiveAction [[ch.ninecode.model.ProtectiveAction ProtectiveAction]] Reference to the superclass object.
 * @param isRegulating If true the regulator is put in-service, otherwise out-of-service (no regulation).
 * @param targetValue The target value specified the new case input for the regulator.
 *        The value has the units appropriate to the mode attribute. The protective action does not change the mode attribute.
 * @param RegulatingControl [[ch.ninecode.model.RegulatingControl RegulatingControl]] <em>undocumented</em>
 * @group InfSIPS
 * @groupname InfSIPS Package InfSIPS
 * @groupdesc InfSIPS System Integrity Protection Schemes (SIPS) (IEC terminology). Other names used are: Remedial Action Schemes (RAS) or System Protection Schemes (SPS).
 */
final case class ProtectiveActionRegulation
(
    ProtectiveAction: ProtectiveAction = null,
    isRegulating: Boolean = false,
    targetValue: Double = 0.0,
    RegulatingControl: String = null
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
    override def sup: ProtectiveAction = ProtectiveAction

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
        implicit val clz: String = ProtectiveActionRegulation.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ProtectiveActionRegulation.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ProtectiveActionRegulation.fields (position), value)
        emitelem (0, isRegulating)
        emitelem (1, targetValue)
        emitattr (2, RegulatingControl)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ProtectiveActionRegulation rdf:ID=\"%s\">\n%s\t</cim:ProtectiveActionRegulation>".format (id, export_fields)
    }
}

object ProtectiveActionRegulation
extends
    CIMParseable[ProtectiveActionRegulation]
{
    override val fields: Array[String] = Array[String] (
        "isRegulating",
        "targetValue",
        "RegulatingControl"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("RegulatingControl", "RegulatingControl", "1", "0..*")
    )
    val isRegulating: Fielder = parse_element (element (cls, fields(0)))
    val targetValue: Fielder = parse_element (element (cls, fields(1)))
    val RegulatingControl: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: CIMContext): ProtectiveActionRegulation =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ProtectiveActionRegulation (
            ProtectiveAction.parse (context),
            toBoolean (mask (isRegulating (), 0)),
            toDouble (mask (targetValue (), 1)),
            mask (RegulatingControl (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Remedial Action Scheme (RAS), Special Protection Schemes (SPS), System Protection Schemes (SPS) or System Integrity Protection Schemes (SIPS).
 *
 * @param PowerSystemResource [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param armed The status of the class set by operation or by signal.
 *        Optional field that will override other status fields.
 * @param kind Kind of Remedial Action Scheme (RAS).
 * @param normalArmed The default/normal value used when other active signal/values are missing.
 * @param GateArmed [[ch.ninecode.model.Gate Gate]] Gate that through a gate logic and input pin defines arming of the Remedial Action Schemes (RAS).
 * @param Stage [[ch.ninecode.model.Stage Stage]] A Remedial Action Scheme (RAS) consist of one or more stage that are trigger and execute protection action.
 * @param TriggerCondition [[ch.ninecode.model.TriggerCondition TriggerCondition]] Triggering of the Remedial Action Schemes (RAS).
 * @group InfSIPS
 * @groupname InfSIPS Package InfSIPS
 * @groupdesc InfSIPS System Integrity Protection Schemes (SIPS) (IEC terminology). Other names used are: Remedial Action Schemes (RAS) or System Protection Schemes (SPS).
 */
final case class RemedialActionScheme
(
    PowerSystemResource: PowerSystemResource = null,
    armed: Boolean = false,
    kind: String = null,
    normalArmed: Boolean = false,
    GateArmed: String = null,
    Stage: List[String] = null,
    TriggerCondition: List[String] = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = RemedialActionScheme.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (RemedialActionScheme.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RemedialActionScheme.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (RemedialActionScheme.fields (position), x))
        emitelem (0, armed)
        emitattr (1, kind)
        emitelem (2, normalArmed)
        emitattr (3, GateArmed)
        emitattrs (4, Stage)
        emitattrs (5, TriggerCondition)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RemedialActionScheme rdf:ID=\"%s\">\n%s\t</cim:RemedialActionScheme>".format (id, export_fields)
    }
}

object RemedialActionScheme
extends
    CIMParseable[RemedialActionScheme]
{
    override val fields: Array[String] = Array[String] (
        "armed",
        "kind",
        "normalArmed",
        "GateArmed",
        "Stage",
        "TriggerCondition"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("GateArmed", "Gate", "0..1", "0..*"),
        CIMRelationship ("Stage", "Stage", "1..*", "1"),
        CIMRelationship ("TriggerCondition", "TriggerCondition", "0..*", "1")
    )
    val armed: Fielder = parse_element (element (cls, fields(0)))
    val kind: Fielder = parse_attribute (attribute (cls, fields(1)))
    val normalArmed: Fielder = parse_element (element (cls, fields(2)))
    val GateArmed: Fielder = parse_attribute (attribute (cls, fields(3)))
    val Stage: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val TriggerCondition: FielderMultiple = parse_attributes (attribute (cls, fields(5)))

    def parse (context: CIMContext): RemedialActionScheme =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = RemedialActionScheme (
            PowerSystemResource.parse (context),
            toBoolean (mask (armed (), 0)),
            mask (kind (), 1),
            toBoolean (mask (normalArmed (), 2)),
            mask (GateArmed (), 3),
            masks (Stage (), 4),
            masks (TriggerCondition (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Stage of a remedial action scheme.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param priority The priority of the stage.   0 = don t care (default) 1 = highest priority. 2 is less than 1 and so on.
 *        A stage with higher priority needs be activated before a lower stage can be activated.
 * @param RemedialActionScheme [[ch.ninecode.model.RemedialActionScheme RemedialActionScheme]] <em>undocumented</em>
 * @param StageTrigger [[ch.ninecode.model.StageTrigger StageTrigger]] A Stage consist of one or more StageTrigger.
 * @group InfSIPS
 * @groupname InfSIPS Package InfSIPS
 * @groupdesc InfSIPS System Integrity Protection Schemes (SIPS) (IEC terminology). Other names used are: Remedial Action Schemes (RAS) or System Protection Schemes (SPS).
 */
final case class Stage
(
    IdentifiedObject: IdentifiedObject = null,
    priority: Int = 0,
    RemedialActionScheme: String = null,
    StageTrigger: List[String] = null
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
        implicit val clz: String = Stage.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Stage.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Stage.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Stage.fields (position), x))
        emitelem (0, priority)
        emitattr (1, RemedialActionScheme)
        emitattrs (2, StageTrigger)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Stage rdf:ID=\"%s\">\n%s\t</cim:Stage>".format (id, export_fields)
    }
}

object Stage
extends
    CIMParseable[Stage]
{
    override val fields: Array[String] = Array[String] (
        "priority",
        "RemedialActionScheme",
        "StageTrigger"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("RemedialActionScheme", "RemedialActionScheme", "1", "1..*"),
        CIMRelationship ("StageTrigger", "StageTrigger", "1..*", "1")
    )
    val priority: Fielder = parse_element (element (cls, fields(0)))
    val RemedialActionScheme: Fielder = parse_attribute (attribute (cls, fields(1)))
    val StageTrigger: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: CIMContext): Stage =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Stage (
            IdentifiedObject.parse (context),
            toInteger (mask (priority (), 0)),
            mask (RemedialActionScheme (), 1),
            masks (StageTrigger (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Condition that is triggered either by TriggerCondition of by gate condition within a stage and has remedial action-s.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param armed The status of the class set by operation or by signal.
 *        Optional field that will override other status fields.
 * @param normalArmed The default/normal value used when other active signal/values are missing.
 * @param priority Priority of trigger. 0 = don t care (default) 1 = highest priority. 2 is less than 1 and so on.
 *        A trigger with the highest priority will trigger first.
 * @param GateArmed [[ch.ninecode.model.Gate Gate]] Association to a Gate that through a gate logic and input pin defines arming of the StageTrigger.
 * @param GateComCondition [[ch.ninecode.model.Gate Gate]] For the StageTrigger to active the set of protective actions the condition for communication needs to be met (true).
 * @param GateTrigger [[ch.ninecode.model.Gate Gate]] The Gate result that trigger the StageTrigger and thereby executing the a set of protective actions.
 * @param ProtectiveActionCollection [[ch.ninecode.model.ProtectiveActionCollection ProtectiveActionCollection]] <em>undocumented</em>
 * @param Stage [[ch.ninecode.model.Stage Stage]] <em>undocumented</em>
 * @group InfSIPS
 * @groupname InfSIPS Package InfSIPS
 * @groupdesc InfSIPS System Integrity Protection Schemes (SIPS) (IEC terminology). Other names used are: Remedial Action Schemes (RAS) or System Protection Schemes (SPS).
 */
final case class StageTrigger
(
    IdentifiedObject: IdentifiedObject = null,
    armed: Boolean = false,
    normalArmed: Boolean = false,
    priority: Int = 0,
    GateArmed: String = null,
    GateComCondition: String = null,
    GateTrigger: String = null,
    ProtectiveActionCollection: String = null,
    Stage: String = null
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
        implicit val clz: String = StageTrigger.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (StageTrigger.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (StageTrigger.fields (position), value)
        emitelem (0, armed)
        emitelem (1, normalArmed)
        emitelem (2, priority)
        emitattr (3, GateArmed)
        emitattr (4, GateComCondition)
        emitattr (5, GateTrigger)
        emitattr (6, ProtectiveActionCollection)
        emitattr (7, Stage)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:StageTrigger rdf:ID=\"%s\">\n%s\t</cim:StageTrigger>".format (id, export_fields)
    }
}

object StageTrigger
extends
    CIMParseable[StageTrigger]
{
    override val fields: Array[String] = Array[String] (
        "armed",
        "normalArmed",
        "priority",
        "GateArmed",
        "GateComCondition",
        "GateTrigger",
        "ProtectiveActionCollection",
        "Stage"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("GateArmed", "Gate", "0..1", "0..*"),
        CIMRelationship ("GateComCondition", "Gate", "0..1", "0..*"),
        CIMRelationship ("GateTrigger", "Gate", "0..1", "0..*"),
        CIMRelationship ("ProtectiveActionCollection", "ProtectiveActionCollection", "1", "0..*"),
        CIMRelationship ("Stage", "Stage", "1", "1..*")
    )
    val armed: Fielder = parse_element (element (cls, fields(0)))
    val normalArmed: Fielder = parse_element (element (cls, fields(1)))
    val priority: Fielder = parse_element (element (cls, fields(2)))
    val GateArmed: Fielder = parse_attribute (attribute (cls, fields(3)))
    val GateComCondition: Fielder = parse_attribute (attribute (cls, fields(4)))
    val GateTrigger: Fielder = parse_attribute (attribute (cls, fields(5)))
    val ProtectiveActionCollection: Fielder = parse_attribute (attribute (cls, fields(6)))
    val Stage: Fielder = parse_attribute (attribute (cls, fields(7)))

    def parse (context: CIMContext): StageTrigger =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = StageTrigger (
            IdentifiedObject.parse (context),
            toBoolean (mask (armed (), 0)),
            toBoolean (mask (normalArmed (), 1)),
            toInteger (mask (priority (), 2)),
            mask (GateArmed (), 3),
            mask (GateComCondition (), 4),
            mask (GateTrigger (), 5),
            mask (ProtectiveActionCollection (), 6),
            mask (Stage (), 7)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A conditions that can trigger remedial actions.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param GateTrigger [[ch.ninecode.model.Gate Gate]] The resulting Gate that is the condition for the Trigger.
 * @param RemedialActionScheme [[ch.ninecode.model.RemedialActionScheme RemedialActionScheme]] <em>undocumented</em>
 * @group InfSIPS
 * @groupname InfSIPS Package InfSIPS
 * @groupdesc InfSIPS System Integrity Protection Schemes (SIPS) (IEC terminology). Other names used are: Remedial Action Schemes (RAS) or System Protection Schemes (SPS).
 */
final case class TriggerCondition
(
    IdentifiedObject: IdentifiedObject = null,
    GateTrigger: String = null,
    RemedialActionScheme: String = null
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
        implicit val clz: String = TriggerCondition.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TriggerCondition.fields (position), value)
        emitattr (0, GateTrigger)
        emitattr (1, RemedialActionScheme)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TriggerCondition rdf:ID=\"%s\">\n%s\t</cim:TriggerCondition>".format (id, export_fields)
    }
}

object TriggerCondition
extends
    CIMParseable[TriggerCondition]
{
    override val fields: Array[String] = Array[String] (
        "GateTrigger",
        "RemedialActionScheme"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("GateTrigger", "Gate", "1", "0..*"),
        CIMRelationship ("RemedialActionScheme", "RemedialActionScheme", "1", "0..*")
    )
    val GateTrigger: Fielder = parse_attribute (attribute (cls, fields(0)))
    val RemedialActionScheme: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): TriggerCondition =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TriggerCondition (
            IdentifiedObject.parse (context),
            mask (GateTrigger (), 0),
            mask (RemedialActionScheme (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _InfSIPS
{
    def register: List[CIMClassInfo] =
    {
        List (
            Gate.register,
            GateInputPin.register,
            MeasurementCalculator.register,
            MeasurementCalculatorInput.register,
            PinBranchGroup.register,
            PinEquipment.register,
            PinGate.register,
            PinMeasurement.register,
            PinTerminal.register,
            ProtectiveAction.register,
            ProtectiveActionAdjustment.register,
            ProtectiveActionCollection.register,
            ProtectiveActionEquipment.register,
            ProtectiveActionRegulation.register,
            RemedialActionScheme.register,
            Stage.register,
            StageTrigger.register,
            TriggerCondition.register
        )
    }
}