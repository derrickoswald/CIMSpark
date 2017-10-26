package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Logical gate than support logical operation based on the input.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param kind The logical operation of the gate.
 * @group InfSIPS
 * @groupname InfSIPS Package InfSIPS
 * @groupdesc InfSIPS System Integrity Protection Schemes (SIPS) (IEC terminology). Other names used are: Remedial Action Schemes (RAS) or System Protection Schemes (SPS)
 */
case class Gate
(
    override val sup: IdentifiedObject,
    kind: String
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
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Gate] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Gate.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Gate.fields (position), value)
        emitattr (0, kind)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Gate rdf:ID=\"%s\">\n%s\t</cim:Gate>".format (id, export_fields)
    }
}

object Gate
extends
    Parseable[Gate]
{
    val fields: Array[String] = Array[String] (
        "kind"
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): Gate =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Gate (
            IdentifiedObject.parse (context),
            mask (kind (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Input pin for a logical gate.
 *
 * The condition described in the input pin will give a logical true or false. Result from measurement and calculation are converted to a true or false.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
 * @groupdesc InfSIPS System Integrity Protection Schemes (SIPS) (IEC terminology). Other names used are: Remedial Action Schemes (RAS) or System Protection Schemes (SPS)
 */
case class GateInputPin
(
    override val sup: IdentifiedObject,
    aDLogicKind: String,
    absoluteValue: Boolean,
    duration: Double,
    negate: Boolean,
    thresholdPercentage: Double,
    thresholdValue: Double,
    Gate: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, false, 0.0, false, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[GateInputPin] }
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
    Parseable[GateInputPin]
{
    val fields: Array[String] = Array[String] (
        "aDLogicKind",
        "absoluteValue",
        "duration",
        "negate",
        "thresholdPercentage",
        "thresholdValue",
        "Gate"
    )
    val aDLogicKind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val absoluteValue: Fielder = parse_element (element (cls, fields(1)))
    val duration: Fielder = parse_element (element (cls, fields(2)))
    val negate: Fielder = parse_element (element (cls, fields(3)))
    val thresholdPercentage: Fielder = parse_element (element (cls, fields(4)))
    val thresholdValue: Fielder = parse_element (element (cls, fields(5)))
    val Gate: Fielder = parse_attribute (attribute (cls, fields(6)))

    def parse (context: Context): GateInputPin =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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
    val relations: List[Relationship] = List (
        Relationship ("Gate", "Gate", false)
    )
}

/**
 * Result of a calculation of one or more measurement.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param kind Calculation operation executed on the operants.
 * @group InfSIPS
 * @groupname InfSIPS Package InfSIPS
 * @groupdesc InfSIPS System Integrity Protection Schemes (SIPS) (IEC terminology). Other names used are: Remedial Action Schemes (RAS) or System Protection Schemes (SPS)
 */
case class MeasurementCalculator
(
    override val sup: IdentifiedObject,
    kind: String
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
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[MeasurementCalculator] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MeasurementCalculator.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MeasurementCalculator.fields (position), value)
        emitattr (0, kind)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MeasurementCalculator rdf:ID=\"%s\">\n%s\t</cim:MeasurementCalculator>".format (id, export_fields)
    }
}

object MeasurementCalculator
extends
    Parseable[MeasurementCalculator]
{
    val fields: Array[String] = Array[String] (
        "kind"
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): MeasurementCalculator =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MeasurementCalculator (
            IdentifiedObject.parse (context),
            mask (kind (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Input to measurement calculation.
 *
 * Support Analog, Discrete and Accumulator.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param absoluteValue If true, use the absolute value for the calculation.
 * @param order Positive number that defines the order of the operant in the calculation. 0 = default.
 *        The order is not relevant (e.g. summation).
 * @param Measurement [[ch.ninecode.model.Measurement Measurement]] <em>undocumented</em>
 * @param MeasurementCalculator [[ch.ninecode.model.MeasurementCalculator MeasurementCalculator]] <em>undocumented</em>
 * @group InfSIPS
 * @groupname InfSIPS Package InfSIPS
 * @groupdesc InfSIPS System Integrity Protection Schemes (SIPS) (IEC terminology). Other names used are: Remedial Action Schemes (RAS) or System Protection Schemes (SPS)
 */
case class MeasurementCalculatorInput
(
    override val sup: IdentifiedObject,
    absoluteValue: Boolean,
    order: Int,
    Measurement: String,
    MeasurementCalculator: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, 0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[MeasurementCalculatorInput] }
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
    Parseable[MeasurementCalculatorInput]
{
    val fields: Array[String] = Array[String] (
        "absoluteValue",
        "order",
        "Measurement",
        "MeasurementCalculator"
    )
    val absoluteValue: Fielder = parse_element (element (cls, fields(0)))
    val order: Fielder = parse_element (element (cls, fields(1)))
    val Measurement: Fielder = parse_attribute (attribute (cls, fields(2)))
    val MeasurementCalculator: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): MeasurementCalculatorInput =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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
    val relations: List[Relationship] = List (
        Relationship ("Measurement", "Measurement", false),
        Relationship ("MeasurementCalculator", "MeasurementCalculator", false)
    )
}

/**
 * Value associated with branch group is used as compare.
 *
 * @param sup [[ch.ninecode.model.GateInputPin GateInputPin]] Reference to the superclass object.
 * @param kind The compare operation done on the branch group.
 * @param BranchGroup [[ch.ninecode.model.BranchGroup BranchGroup]] <em>undocumented</em>
 * @group InfSIPS
 * @groupname InfSIPS Package InfSIPS
 * @groupdesc InfSIPS System Integrity Protection Schemes (SIPS) (IEC terminology). Other names used are: Remedial Action Schemes (RAS) or System Protection Schemes (SPS)
 */
case class PinBranchGroup
(
    override val sup: GateInputPin,
    kind: String,
    BranchGroup: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def GateInputPin: GateInputPin = sup.asInstanceOf[GateInputPin]
    override def copy (): Row = { clone ().asInstanceOf[PinBranchGroup] }
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
    Parseable[PinBranchGroup]
{
    val fields: Array[String] = Array[String] (
        "kind",
        "BranchGroup"
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val BranchGroup: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): PinBranchGroup =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = PinBranchGroup (
            GateInputPin.parse (context),
            mask (kind (), 0),
            mask (BranchGroup (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("BranchGroup", "BranchGroup", false)
    )
}

/**
 * Value associated with Equipment is used as compare.
 *
 * @param sup [[ch.ninecode.model.GateInputPin GateInputPin]] Reference to the superclass object.
 * @param kind The compare operation done on the equipment.
 * @param Equipment [[ch.ninecode.model.Equipment Equipment]] <em>undocumented</em>
 * @group InfSIPS
 * @groupname InfSIPS Package InfSIPS
 * @groupdesc InfSIPS System Integrity Protection Schemes (SIPS) (IEC terminology). Other names used are: Remedial Action Schemes (RAS) or System Protection Schemes (SPS)
 */
case class PinEquipment
(
    override val sup: GateInputPin,
    kind: String,
    Equipment: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def GateInputPin: GateInputPin = sup.asInstanceOf[GateInputPin]
    override def copy (): Row = { clone ().asInstanceOf[PinEquipment] }
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
    Parseable[PinEquipment]
{
    val fields: Array[String] = Array[String] (
        "kind",
        "Equipment"
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val Equipment: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): PinEquipment =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = PinEquipment (
            GateInputPin.parse (context),
            mask (kind (), 0),
            mask (Equipment (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Equipment", "Equipment", false)
    )
}

/**
 * An output from one gate represent an input to another gate.
 *
 * @param sup [[ch.ninecode.model.GateInputPin GateInputPin]] Reference to the superclass object.
 * @param GateOutput [[ch.ninecode.model.Gate Gate]] <em>undocumented</em>
 * @group InfSIPS
 * @groupname InfSIPS Package InfSIPS
 * @groupdesc InfSIPS System Integrity Protection Schemes (SIPS) (IEC terminology). Other names used are: Remedial Action Schemes (RAS) or System Protection Schemes (SPS)
 */
case class PinGate
(
    override val sup: GateInputPin,
    GateOutput: String
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
    def GateInputPin: GateInputPin = sup.asInstanceOf[GateInputPin]
    override def copy (): Row = { clone ().asInstanceOf[PinGate] }
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
    Parseable[PinGate]
{
    val fields: Array[String] = Array[String] (
        "GateOutput"
    )
    val GateOutput: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): PinGate =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = PinGate (
            GateInputPin.parse (context),
            mask (GateOutput (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("GateOutput", "Gate", false)
    )
}

/**
 * Gate input pin that is associated with a Measurement or a calculation of Measurement.
 *
 * @param sup [[ch.ninecode.model.GateInputPin GateInputPin]] Reference to the superclass object.
 * @param Measurement [[ch.ninecode.model.Measurement Measurement]] <em>undocumented</em>
 * @param MeasurementCalculator [[ch.ninecode.model.MeasurementCalculator MeasurementCalculator]] <em>undocumented</em>
 * @group InfSIPS
 * @groupname InfSIPS Package InfSIPS
 * @groupdesc InfSIPS System Integrity Protection Schemes (SIPS) (IEC terminology). Other names used are: Remedial Action Schemes (RAS) or System Protection Schemes (SPS)
 */
case class PinMeasurement
(
    override val sup: GateInputPin,
    Measurement: String,
    MeasurementCalculator: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def GateInputPin: GateInputPin = sup.asInstanceOf[GateInputPin]
    override def copy (): Row = { clone ().asInstanceOf[PinMeasurement] }
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
    Parseable[PinMeasurement]
{
    val fields: Array[String] = Array[String] (
        "Measurement",
        "MeasurementCalculator"
    )
    val Measurement: Fielder = parse_attribute (attribute (cls, fields(0)))
    val MeasurementCalculator: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): PinMeasurement =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = PinMeasurement (
            GateInputPin.parse (context),
            mask (Measurement (), 0),
            mask (MeasurementCalculator (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Measurement", "Measurement", false),
        Relationship ("MeasurementCalculator", "MeasurementCalculator", false)
    )
}

/**
 * Value associated with Terminal is used as compare.
 *
 * @param sup [[ch.ninecode.model.GateInputPin GateInputPin]] Reference to the superclass object.
 * @param kind The compare operation done on the terminal.
 * @param Terminal [[ch.ninecode.model.Terminal Terminal]] <em>undocumented</em>
 * @group InfSIPS
 * @groupname InfSIPS Package InfSIPS
 * @groupdesc InfSIPS System Integrity Protection Schemes (SIPS) (IEC terminology). Other names used are: Remedial Action Schemes (RAS) or System Protection Schemes (SPS)
 */
case class PinTerminal
(
    override val sup: GateInputPin,
    kind: String,
    Terminal: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def GateInputPin: GateInputPin = sup.asInstanceOf[GateInputPin]
    override def copy (): Row = { clone ().asInstanceOf[PinTerminal] }
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
    Parseable[PinTerminal]
{
    val fields: Array[String] = Array[String] (
        "kind",
        "Terminal"
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val Terminal: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): PinTerminal =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = PinTerminal (
            GateInputPin.parse (context),
            mask (kind (), 0),
            mask (Terminal (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Terminal", "Terminal", false)
    )
}

/**
 * A protective action for supporting the integrity of the power system.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param enabled The status of the class set by operation or by signal.
 *        Optional field that will override other status fields.
 * @param normalEnabled The default/normal value used when other active signal/values are missing.
 * @param GateComCondition [[ch.ninecode.model.Gate Gate]] <em>undocumented</em>
 * @param GateEnabledCondition [[ch.ninecode.model.Gate Gate]] <em>undocumented</em>
 * @param ProtectionEquipment [[ch.ninecode.model.ProtectionEquipment ProtectionEquipment]] <em>undocumented</em>
 * @param ProtectiveActionCollection [[ch.ninecode.model.ProtectiveActionCollection ProtectiveActionCollection]] <em>undocumented</em>
 * @group InfSIPS
 * @groupname InfSIPS Package InfSIPS
 * @groupdesc InfSIPS System Integrity Protection Schemes (SIPS) (IEC terminology). Other names used are: Remedial Action Schemes (RAS) or System Protection Schemes (SPS)
 */
case class ProtectiveAction
(
    override val sup: IdentifiedObject,
    enabled: Boolean,
    normalEnabled: Boolean,
    GateComCondition: String,
    GateEnabledCondition: String,
    ProtectionEquipment: String,
    ProtectiveActionCollection: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, false, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ProtectiveAction] }
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
    Parseable[ProtectiveAction]
{
    val fields: Array[String] = Array[String] (
        "enabled",
        "normalEnabled",
        "GateComCondition",
        "GateEnabledCondition",
        "ProtectionEquipment",
        "ProtectiveActionCollection"
    )
    val enabled: Fielder = parse_element (element (cls, fields(0)))
    val normalEnabled: Fielder = parse_element (element (cls, fields(1)))
    val GateComCondition: Fielder = parse_attribute (attribute (cls, fields(2)))
    val GateEnabledCondition: Fielder = parse_attribute (attribute (cls, fields(3)))
    val ProtectionEquipment: Fielder = parse_attribute (attribute (cls, fields(4)))
    val ProtectiveActionCollection: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: Context): ProtectiveAction =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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
    val relations: List[Relationship] = List (
        Relationship ("GateComCondition", "Gate", false),
        Relationship ("GateEnabledCondition", "Gate", false),
        Relationship ("ProtectionEquipment", "ProtectionEquipment", false),
        Relationship ("ProtectiveActionCollection", "ProtectiveActionCollection", false)
    )
}

/**
 * Protective actions on non-switching equipment.
 *
 * The operating condition is adjusted.
 *
 * @param sup [[ch.ninecode.model.ProtectiveAction ProtectiveAction]] Reference to the superclass object.
 * @param byPercentage The adjustment is given in percent of the active value.
 * @param byValue The adjustment is given in value of the active value.
 * @param kind Defines the kind of adjustment that should be done.
 *        With this value the correct attribute containing the value needs to be used.
 * @param reduce If true, the adjusted value is an reduction.
 *        Other wise it is an increase in the value.
 * @param setValue The adjustment is given by a new active value.
 * @param ConductingEquipment [[ch.ninecode.model.ConductingEquipment ConductingEquipment]] <em>undocumented</em>
 * @param DCConductingEquipment [[ch.ninecode.model.DCConductingEquipment DCConductingEquipment]] <em>undocumented</em>
 * @param Measurement [[ch.ninecode.model.Measurement Measurement]] <em>undocumented</em>
 * @group InfSIPS
 * @groupname InfSIPS Package InfSIPS
 * @groupdesc InfSIPS System Integrity Protection Schemes (SIPS) (IEC terminology). Other names used are: Remedial Action Schemes (RAS) or System Protection Schemes (SPS)
 */
case class ProtectiveActionAdjustment
(
    override val sup: ProtectiveAction,
    byPercentage: Double,
    byValue: Double,
    kind: String,
    reduce: Boolean,
    setValue: Double,
    ConductingEquipment: String,
    DCConductingEquipment: String,
    Measurement: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, null, false, 0.0, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ProtectiveAction: ProtectiveAction = sup.asInstanceOf[ProtectiveAction]
    override def copy (): Row = { clone ().asInstanceOf[ProtectiveActionAdjustment] }
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
    Parseable[ProtectiveActionAdjustment]
{
    val fields: Array[String] = Array[String] (
        "byPercentage",
        "byValue",
        "kind",
        "reduce",
        "setValue",
        "ConductingEquipment",
        "DCConductingEquipment",
        "Measurement"
    )
    val byPercentage: Fielder = parse_element (element (cls, fields(0)))
    val byValue: Fielder = parse_element (element (cls, fields(1)))
    val kind: Fielder = parse_attribute (attribute (cls, fields(2)))
    val reduce: Fielder = parse_element (element (cls, fields(3)))
    val setValue: Fielder = parse_element (element (cls, fields(4)))
    val ConductingEquipment: Fielder = parse_attribute (attribute (cls, fields(5)))
    val DCConductingEquipment: Fielder = parse_attribute (attribute (cls, fields(6)))
    val Measurement: Fielder = parse_attribute (attribute (cls, fields(7)))

    def parse (context: Context): ProtectiveActionAdjustment =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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
    val relations: List[Relationship] = List (
        Relationship ("ConductingEquipment", "ConductingEquipment", false),
        Relationship ("DCConductingEquipment", "DCConductingEquipment", false),
        Relationship ("Measurement", "Measurement", false)
    )
}

/**
 * A collection of protective actions to protect the integrity of the power system.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @group InfSIPS
 * @groupname InfSIPS Package InfSIPS
 * @groupdesc InfSIPS System Integrity Protection Schemes (SIPS) (IEC terminology). Other names used are: Remedial Action Schemes (RAS) or System Protection Schemes (SPS)
 */
case class ProtectiveActionCollection
(
    override val sup: IdentifiedObject
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
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ProtectiveActionCollection] }
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:ProtectiveActionCollection rdf:ID=\"%s\">\n%s\t</cim:ProtectiveActionCollection>".format (id, export_fields)
    }
}

object ProtectiveActionCollection
extends
    Parseable[ProtectiveActionCollection]
{

    def parse (context: Context): ProtectiveActionCollection =
    {
        implicit val ctx: Context = context
        val ret = ProtectiveActionCollection (
            IdentifiedObject.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Protective action to put an Equipment in-service/out-of-service.
 *
 * @param sup [[ch.ninecode.model.ProtectiveAction ProtectiveAction]] Reference to the superclass object.
 * @param inService If true the equipment is put in-service, otherwise out-of-service.
 * @param Equipment [[ch.ninecode.model.Equipment Equipment]] <em>undocumented</em>
 * @group InfSIPS
 * @groupname InfSIPS Package InfSIPS
 * @groupdesc InfSIPS System Integrity Protection Schemes (SIPS) (IEC terminology). Other names used are: Remedial Action Schemes (RAS) or System Protection Schemes (SPS)
 */
case class ProtectiveActionEquipment
(
    override val sup: ProtectiveAction,
    inService: Boolean,
    Equipment: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ProtectiveAction: ProtectiveAction = sup.asInstanceOf[ProtectiveAction]
    override def copy (): Row = { clone ().asInstanceOf[ProtectiveActionEquipment] }
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
    Parseable[ProtectiveActionEquipment]
{
    val fields: Array[String] = Array[String] (
        "inService",
        "Equipment"
    )
    val inService: Fielder = parse_element (element (cls, fields(0)))
    val Equipment: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): ProtectiveActionEquipment =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ProtectiveActionEquipment (
            ProtectiveAction.parse (context),
            toBoolean (mask (inService (), 0)),
            mask (Equipment (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Equipment", "Equipment", false)
    )
}

/**
 * Protective action to change regulation to Equipment.
 *
 * @param sup [[ch.ninecode.model.ProtectiveAction ProtectiveAction]] Reference to the superclass object.
 * @param isRegulating If true the regulator is put in-service, otherwise out-of-service (no regulation).
 * @param targetValue The target value specified the new case input for the regulator.
 *        The value has the units appropriate to the mode attribute. The protective action does not change the mode attribute.
 * @param RegulatingControl [[ch.ninecode.model.RegulatingControl RegulatingControl]] <em>undocumented</em>
 * @group InfSIPS
 * @groupname InfSIPS Package InfSIPS
 * @groupdesc InfSIPS System Integrity Protection Schemes (SIPS) (IEC terminology). Other names used are: Remedial Action Schemes (RAS) or System Protection Schemes (SPS)
 */
case class ProtectiveActionRegulation
(
    override val sup: ProtectiveAction,
    isRegulating: Boolean,
    targetValue: Double,
    RegulatingControl: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ProtectiveAction: ProtectiveAction = sup.asInstanceOf[ProtectiveAction]
    override def copy (): Row = { clone ().asInstanceOf[ProtectiveActionRegulation] }
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
    Parseable[ProtectiveActionRegulation]
{
    val fields: Array[String] = Array[String] (
        "isRegulating",
        "targetValue",
        "RegulatingControl"
    )
    val isRegulating: Fielder = parse_element (element (cls, fields(0)))
    val targetValue: Fielder = parse_element (element (cls, fields(1)))
    val RegulatingControl: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): ProtectiveActionRegulation =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ProtectiveActionRegulation (
            ProtectiveAction.parse (context),
            toBoolean (mask (isRegulating (), 0)),
            toDouble (mask (targetValue (), 1)),
            mask (RegulatingControl (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("RegulatingControl", "RegulatingControl", false)
    )
}

/**
 * Remedial Action Scheme (RAS), Special Protection Schemes (SPS), System Protection Schemes (SPS) or System Integrity Protection Schemes (SIPS).
 *
 * @param sup [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param armed The status of the class set by operation or by signal.
 *        Optional field that will override other status fields.
 * @param kind Kind of Remedial Action Scheme (RAS)
 * @param normalArmed The default/normal value used when other active signal/values are missing.
 * @param GateArmed [[ch.ninecode.model.Gate Gate]] <em>undocumented</em>
 * @group InfSIPS
 * @groupname InfSIPS Package InfSIPS
 * @groupdesc InfSIPS System Integrity Protection Schemes (SIPS) (IEC terminology). Other names used are: Remedial Action Schemes (RAS) or System Protection Schemes (SPS)
 */
case class RemedialActionScheme
(
    override val sup: PowerSystemResource,
    armed: Boolean,
    kind: String,
    normalArmed: Boolean,
    GateArmed: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, null, false, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { clone ().asInstanceOf[RemedialActionScheme] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = RemedialActionScheme.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (RemedialActionScheme.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RemedialActionScheme.fields (position), value)
        emitelem (0, armed)
        emitattr (1, kind)
        emitelem (2, normalArmed)
        emitattr (3, GateArmed)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RemedialActionScheme rdf:ID=\"%s\">\n%s\t</cim:RemedialActionScheme>".format (id, export_fields)
    }
}

object RemedialActionScheme
extends
    Parseable[RemedialActionScheme]
{
    val fields: Array[String] = Array[String] (
        "armed",
        "kind",
        "normalArmed",
        "GateArmed"
    )
    val armed: Fielder = parse_element (element (cls, fields(0)))
    val kind: Fielder = parse_attribute (attribute (cls, fields(1)))
    val normalArmed: Fielder = parse_element (element (cls, fields(2)))
    val GateArmed: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): RemedialActionScheme =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = RemedialActionScheme (
            PowerSystemResource.parse (context),
            toBoolean (mask (armed (), 0)),
            mask (kind (), 1),
            toBoolean (mask (normalArmed (), 2)),
            mask (GateArmed (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("GateArmed", "Gate", false)
    )
}

/**
 * Stage of a remedial action scheme.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param priority The priority of the stage.   0 = don t care (default) 1 = highest priority. 2 is less than 1 and so on.
 *        A stage with higher priority needs be activated before a lower stage can be activated.
 * @param RemedialActionScheme [[ch.ninecode.model.RemedialActionScheme RemedialActionScheme]] <em>undocumented</em>
 * @group InfSIPS
 * @groupname InfSIPS Package InfSIPS
 * @groupdesc InfSIPS System Integrity Protection Schemes (SIPS) (IEC terminology). Other names used are: Remedial Action Schemes (RAS) or System Protection Schemes (SPS)
 */
case class Stage
(
    override val sup: IdentifiedObject,
    priority: Int,
    RemedialActionScheme: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Stage] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Stage.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Stage.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Stage.fields (position), value)
        emitelem (0, priority)
        emitattr (1, RemedialActionScheme)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Stage rdf:ID=\"%s\">\n%s\t</cim:Stage>".format (id, export_fields)
    }
}

object Stage
extends
    Parseable[Stage]
{
    val fields: Array[String] = Array[String] (
        "priority",
        "RemedialActionScheme"
    )
    val priority: Fielder = parse_element (element (cls, fields(0)))
    val RemedialActionScheme: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): Stage =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Stage (
            IdentifiedObject.parse (context),
            toInteger (mask (priority (), 0)),
            mask (RemedialActionScheme (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("RemedialActionScheme", "RemedialActionScheme", false)
    )
}

/**
 * Condition that is triggered either by TriggerCondition of by gate condition within a stage and has remedial action-s.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param armed The status of the class set by operation or by signal.
 *        Optional field that will override other status fields.
 * @param normalArmed The default/normal value used when other active signal/values are missing.
 * @param priority Priority of trigger. 0 = don t care (default) 1 = highest priority. 2 is less than 1 and so on.
 *        A trigger with the highest priority will trigger first.
 * @param GateArmed [[ch.ninecode.model.Gate Gate]] <em>undocumented</em>
 * @param GateComCondition [[ch.ninecode.model.Gate Gate]] <em>undocumented</em>
 * @param GateTrigger [[ch.ninecode.model.Gate Gate]] <em>undocumented</em>
 * @param ProtectiveActionCollection [[ch.ninecode.model.ProtectiveActionCollection ProtectiveActionCollection]] <em>undocumented</em>
 * @param Stage [[ch.ninecode.model.Stage Stage]] <em>undocumented</em>
 * @group InfSIPS
 * @groupname InfSIPS Package InfSIPS
 * @groupdesc InfSIPS System Integrity Protection Schemes (SIPS) (IEC terminology). Other names used are: Remedial Action Schemes (RAS) or System Protection Schemes (SPS)
 */
case class StageTrigger
(
    override val sup: IdentifiedObject,
    armed: Boolean,
    normalArmed: Boolean,
    priority: Int,
    GateArmed: String,
    GateComCondition: String,
    GateTrigger: String,
    ProtectiveActionCollection: String,
    Stage: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, false, 0, null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[StageTrigger] }
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
    Parseable[StageTrigger]
{
    val fields: Array[String] = Array[String] (
        "armed",
        "normalArmed",
        "priority",
        "GateArmed",
        "GateComCondition",
        "GateTrigger",
        "ProtectiveActionCollection",
        "Stage"
    )
    val armed: Fielder = parse_element (element (cls, fields(0)))
    val normalArmed: Fielder = parse_element (element (cls, fields(1)))
    val priority: Fielder = parse_element (element (cls, fields(2)))
    val GateArmed: Fielder = parse_attribute (attribute (cls, fields(3)))
    val GateComCondition: Fielder = parse_attribute (attribute (cls, fields(4)))
    val GateTrigger: Fielder = parse_attribute (attribute (cls, fields(5)))
    val ProtectiveActionCollection: Fielder = parse_attribute (attribute (cls, fields(6)))
    val Stage: Fielder = parse_attribute (attribute (cls, fields(7)))

    def parse (context: Context): StageTrigger =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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
    val relations: List[Relationship] = List (
        Relationship ("GateArmed", "Gate", false),
        Relationship ("GateComCondition", "Gate", false),
        Relationship ("GateTrigger", "Gate", false),
        Relationship ("ProtectiveActionCollection", "ProtectiveActionCollection", false),
        Relationship ("Stage", "Stage", false)
    )
}

/**
 * A conditions that can trigger remedial actions.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param GateTrigger [[ch.ninecode.model.Gate Gate]] <em>undocumented</em>
 * @param RemedialActionScheme [[ch.ninecode.model.RemedialActionScheme RemedialActionScheme]] <em>undocumented</em>
 * @group InfSIPS
 * @groupname InfSIPS Package InfSIPS
 * @groupdesc InfSIPS System Integrity Protection Schemes (SIPS) (IEC terminology). Other names used are: Remedial Action Schemes (RAS) or System Protection Schemes (SPS)
 */
case class TriggerCondition
(
    override val sup: IdentifiedObject,
    GateTrigger: String,
    RemedialActionScheme: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[TriggerCondition] }
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
    Parseable[TriggerCondition]
{
    val fields: Array[String] = Array[String] (
        "GateTrigger",
        "RemedialActionScheme"
    )
    val GateTrigger: Fielder = parse_attribute (attribute (cls, fields(0)))
    val RemedialActionScheme: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): TriggerCondition =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = TriggerCondition (
            IdentifiedObject.parse (context),
            mask (GateTrigger (), 0),
            mask (RemedialActionScheme (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("GateTrigger", "Gate", false),
        Relationship ("RemedialActionScheme", "RemedialActionScheme", false)
    )
}

private[ninecode] object _InfSIPS
{
    def register: List[ClassInfo] =
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