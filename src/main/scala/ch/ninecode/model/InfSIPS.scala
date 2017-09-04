package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

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
        sup.export_fields +
        (if (null != kind) "\t\t<cim:Gate.kind rdf:resource=\"#" + kind + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Gate rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Gate>"
    }
}

object Gate
extends
    Parseable[Gate]
{
    val kind = parse_attribute (attribute ("""Gate.kind"""))
    def parse (context: Context): Gate =
    {
        Gate(
            IdentifiedObject.parse (context),
            kind (context)
        )
    }
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
        sup.export_fields +
        (if (null != aDLogicKind) "\t\t<cim:GateInputPin.aDLogicKind rdf:resource=\"#" + aDLogicKind + "\"/>\n" else "") +
        "\t\t<cim:GateInputPin.absoluteValue>" + absoluteValue + "</cim:GateInputPin.absoluteValue>\n" +
        "\t\t<cim:GateInputPin.duration>" + duration + "</cim:GateInputPin.duration>\n" +
        "\t\t<cim:GateInputPin.negate>" + negate + "</cim:GateInputPin.negate>\n" +
        "\t\t<cim:GateInputPin.thresholdPercentage>" + thresholdPercentage + "</cim:GateInputPin.thresholdPercentage>\n" +
        "\t\t<cim:GateInputPin.thresholdValue>" + thresholdValue + "</cim:GateInputPin.thresholdValue>\n" +
        (if (null != Gate) "\t\t<cim:GateInputPin.Gate rdf:resource=\"#" + Gate + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:GateInputPin rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GateInputPin>"
    }
}

object GateInputPin
extends
    Parseable[GateInputPin]
{
    val aDLogicKind = parse_attribute (attribute ("""GateInputPin.aDLogicKind"""))
    val absoluteValue = parse_element (element ("""GateInputPin.absoluteValue"""))
    val duration = parse_element (element ("""GateInputPin.duration"""))
    val negate = parse_element (element ("""GateInputPin.negate"""))
    val thresholdPercentage = parse_element (element ("""GateInputPin.thresholdPercentage"""))
    val thresholdValue = parse_element (element ("""GateInputPin.thresholdValue"""))
    val Gate = parse_attribute (attribute ("""GateInputPin.Gate"""))
    def parse (context: Context): GateInputPin =
    {
        GateInputPin(
            IdentifiedObject.parse (context),
            aDLogicKind (context),
            toBoolean (absoluteValue (context), context),
            toDouble (duration (context), context),
            toBoolean (negate (context), context),
            toDouble (thresholdPercentage (context), context),
            toDouble (thresholdValue (context), context),
            Gate (context)
        )
    }
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
        sup.export_fields +
        (if (null != kind) "\t\t<cim:MeasurementCalculator.kind rdf:resource=\"#" + kind + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MeasurementCalculator rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MeasurementCalculator>"
    }
}

object MeasurementCalculator
extends
    Parseable[MeasurementCalculator]
{
    val kind = parse_attribute (attribute ("""MeasurementCalculator.kind"""))
    def parse (context: Context): MeasurementCalculator =
    {
        MeasurementCalculator(
            IdentifiedObject.parse (context),
            kind (context)
        )
    }
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
        sup.export_fields +
        "\t\t<cim:MeasurementCalculatorInput.absoluteValue>" + absoluteValue + "</cim:MeasurementCalculatorInput.absoluteValue>\n" +
        "\t\t<cim:MeasurementCalculatorInput.order>" + order + "</cim:MeasurementCalculatorInput.order>\n" +
        (if (null != Measurement) "\t\t<cim:MeasurementCalculatorInput.Measurement rdf:resource=\"#" + Measurement + "\"/>\n" else "") +
        (if (null != MeasurementCalculator) "\t\t<cim:MeasurementCalculatorInput.MeasurementCalculator rdf:resource=\"#" + MeasurementCalculator + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MeasurementCalculatorInput rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MeasurementCalculatorInput>"
    }
}

object MeasurementCalculatorInput
extends
    Parseable[MeasurementCalculatorInput]
{
    val absoluteValue = parse_element (element ("""MeasurementCalculatorInput.absoluteValue"""))
    val order = parse_element (element ("""MeasurementCalculatorInput.order"""))
    val Measurement = parse_attribute (attribute ("""MeasurementCalculatorInput.Measurement"""))
    val MeasurementCalculator = parse_attribute (attribute ("""MeasurementCalculatorInput.MeasurementCalculator"""))
    def parse (context: Context): MeasurementCalculatorInput =
    {
        MeasurementCalculatorInput(
            IdentifiedObject.parse (context),
            toBoolean (absoluteValue (context), context),
            toInteger (order (context), context),
            Measurement (context),
            MeasurementCalculator (context)
        )
    }
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
        sup.export_fields +
        (if (null != kind) "\t\t<cim:PinBranchGroup.kind rdf:resource=\"#" + kind + "\"/>\n" else "") +
        (if (null != BranchGroup) "\t\t<cim:PinBranchGroup.BranchGroup rdf:resource=\"#" + BranchGroup + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:PinBranchGroup rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PinBranchGroup>"
    }
}

object PinBranchGroup
extends
    Parseable[PinBranchGroup]
{
    val kind = parse_attribute (attribute ("""PinBranchGroup.kind"""))
    val BranchGroup = parse_attribute (attribute ("""PinBranchGroup.BranchGroup"""))
    def parse (context: Context): PinBranchGroup =
    {
        PinBranchGroup(
            GateInputPin.parse (context),
            kind (context),
            BranchGroup (context)
        )
    }
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
        sup.export_fields +
        (if (null != kind) "\t\t<cim:PinEquipment.kind rdf:resource=\"#" + kind + "\"/>\n" else "") +
        (if (null != Equipment) "\t\t<cim:PinEquipment.Equipment rdf:resource=\"#" + Equipment + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:PinEquipment rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PinEquipment>"
    }
}

object PinEquipment
extends
    Parseable[PinEquipment]
{
    val kind = parse_attribute (attribute ("""PinEquipment.kind"""))
    val Equipment = parse_attribute (attribute ("""PinEquipment.Equipment"""))
    def parse (context: Context): PinEquipment =
    {
        PinEquipment(
            GateInputPin.parse (context),
            kind (context),
            Equipment (context)
        )
    }
}

/**
 * An output from one gate represent an input to another gate.
 *
 * @param sup [[ch.ninecode.model.GateInputPin GateInputPin]] Reference to the superclass object.
 * @param GateOutput <em>undocumented</em>
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
        sup.export_fields +
        (if (null != GateOutput) "\t\t<cim:PinGate.GateOutput rdf:resource=\"#" + GateOutput + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:PinGate rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PinGate>"
    }
}

object PinGate
extends
    Parseable[PinGate]
{
    val GateOutput = parse_attribute (attribute ("""PinGate.GateOutput"""))
    def parse (context: Context): PinGate =
    {
        PinGate(
            GateInputPin.parse (context),
            GateOutput (context)
        )
    }
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
        sup.export_fields +
        (if (null != Measurement) "\t\t<cim:PinMeasurement.Measurement rdf:resource=\"#" + Measurement + "\"/>\n" else "") +
        (if (null != MeasurementCalculator) "\t\t<cim:PinMeasurement.MeasurementCalculator rdf:resource=\"#" + MeasurementCalculator + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:PinMeasurement rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PinMeasurement>"
    }
}

object PinMeasurement
extends
    Parseable[PinMeasurement]
{
    val Measurement = parse_attribute (attribute ("""PinMeasurement.Measurement"""))
    val MeasurementCalculator = parse_attribute (attribute ("""PinMeasurement.MeasurementCalculator"""))
    def parse (context: Context): PinMeasurement =
    {
        PinMeasurement(
            GateInputPin.parse (context),
            Measurement (context),
            MeasurementCalculator (context)
        )
    }
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
        sup.export_fields +
        (if (null != kind) "\t\t<cim:PinTerminal.kind rdf:resource=\"#" + kind + "\"/>\n" else "") +
        (if (null != Terminal) "\t\t<cim:PinTerminal.Terminal rdf:resource=\"#" + Terminal + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:PinTerminal rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PinTerminal>"
    }
}

object PinTerminal
extends
    Parseable[PinTerminal]
{
    val kind = parse_attribute (attribute ("""PinTerminal.kind"""))
    val Terminal = parse_attribute (attribute ("""PinTerminal.Terminal"""))
    def parse (context: Context): PinTerminal =
    {
        PinTerminal(
            GateInputPin.parse (context),
            kind (context),
            Terminal (context)
        )
    }
}

/**
 * A protective action for supporting the integrity of the power system.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param enabled The status of the class set by operation or by signal.
 *        Optional field that will override other status fields.
 * @param normalEnabled The default/normal value used when other active signal/values are missing.
 * @param GateComCondition <em>undocumented</em>
 * @param GateEnabledCondition <em>undocumented</em>
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
        sup.export_fields +
        "\t\t<cim:ProtectiveAction.enabled>" + enabled + "</cim:ProtectiveAction.enabled>\n" +
        "\t\t<cim:ProtectiveAction.normalEnabled>" + normalEnabled + "</cim:ProtectiveAction.normalEnabled>\n" +
        (if (null != GateComCondition) "\t\t<cim:ProtectiveAction.GateComCondition rdf:resource=\"#" + GateComCondition + "\"/>\n" else "") +
        (if (null != GateEnabledCondition) "\t\t<cim:ProtectiveAction.GateEnabledCondition rdf:resource=\"#" + GateEnabledCondition + "\"/>\n" else "") +
        (if (null != ProtectionEquipment) "\t\t<cim:ProtectiveAction.ProtectionEquipment rdf:resource=\"#" + ProtectionEquipment + "\"/>\n" else "") +
        (if (null != ProtectiveActionCollection) "\t\t<cim:ProtectiveAction.ProtectiveActionCollection rdf:resource=\"#" + ProtectiveActionCollection + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ProtectiveAction rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ProtectiveAction>"
    }
}

object ProtectiveAction
extends
    Parseable[ProtectiveAction]
{
    val enabled = parse_element (element ("""ProtectiveAction.enabled"""))
    val normalEnabled = parse_element (element ("""ProtectiveAction.normalEnabled"""))
    val GateComCondition = parse_attribute (attribute ("""ProtectiveAction.GateComCondition"""))
    val GateEnabledCondition = parse_attribute (attribute ("""ProtectiveAction.GateEnabledCondition"""))
    val ProtectionEquipment = parse_attribute (attribute ("""ProtectiveAction.ProtectionEquipment"""))
    val ProtectiveActionCollection = parse_attribute (attribute ("""ProtectiveAction.ProtectiveActionCollection"""))
    def parse (context: Context): ProtectiveAction =
    {
        ProtectiveAction(
            IdentifiedObject.parse (context),
            toBoolean (enabled (context), context),
            toBoolean (normalEnabled (context), context),
            GateComCondition (context),
            GateEnabledCondition (context),
            ProtectionEquipment (context),
            ProtectiveActionCollection (context)
        )
    }
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
        sup.export_fields +
        "\t\t<cim:ProtectiveActionAdjustment.byPercentage>" + byPercentage + "</cim:ProtectiveActionAdjustment.byPercentage>\n" +
        "\t\t<cim:ProtectiveActionAdjustment.byValue>" + byValue + "</cim:ProtectiveActionAdjustment.byValue>\n" +
        (if (null != kind) "\t\t<cim:ProtectiveActionAdjustment.kind rdf:resource=\"#" + kind + "\"/>\n" else "") +
        "\t\t<cim:ProtectiveActionAdjustment.reduce>" + reduce + "</cim:ProtectiveActionAdjustment.reduce>\n" +
        "\t\t<cim:ProtectiveActionAdjustment.setValue>" + setValue + "</cim:ProtectiveActionAdjustment.setValue>\n" +
        (if (null != ConductingEquipment) "\t\t<cim:ProtectiveActionAdjustment.ConductingEquipment rdf:resource=\"#" + ConductingEquipment + "\"/>\n" else "") +
        (if (null != DCConductingEquipment) "\t\t<cim:ProtectiveActionAdjustment.DCConductingEquipment rdf:resource=\"#" + DCConductingEquipment + "\"/>\n" else "") +
        (if (null != Measurement) "\t\t<cim:ProtectiveActionAdjustment.Measurement rdf:resource=\"#" + Measurement + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ProtectiveActionAdjustment rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ProtectiveActionAdjustment>"
    }
}

object ProtectiveActionAdjustment
extends
    Parseable[ProtectiveActionAdjustment]
{
    val byPercentage = parse_element (element ("""ProtectiveActionAdjustment.byPercentage"""))
    val byValue = parse_element (element ("""ProtectiveActionAdjustment.byValue"""))
    val kind = parse_attribute (attribute ("""ProtectiveActionAdjustment.kind"""))
    val reduce = parse_element (element ("""ProtectiveActionAdjustment.reduce"""))
    val setValue = parse_element (element ("""ProtectiveActionAdjustment.setValue"""))
    val ConductingEquipment = parse_attribute (attribute ("""ProtectiveActionAdjustment.ConductingEquipment"""))
    val DCConductingEquipment = parse_attribute (attribute ("""ProtectiveActionAdjustment.DCConductingEquipment"""))
    val Measurement = parse_attribute (attribute ("""ProtectiveActionAdjustment.Measurement"""))
    def parse (context: Context): ProtectiveActionAdjustment =
    {
        ProtectiveActionAdjustment(
            ProtectiveAction.parse (context),
            toDouble (byPercentage (context), context),
            toDouble (byValue (context), context),
            kind (context),
            toBoolean (reduce (context), context),
            toDouble (setValue (context), context),
            ConductingEquipment (context),
            DCConductingEquipment (context),
            Measurement (context)
        )
    }
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:ProtectiveActionCollection rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ProtectiveActionCollection>"
    }
}

object ProtectiveActionCollection
extends
    Parseable[ProtectiveActionCollection]
{
    def parse (context: Context): ProtectiveActionCollection =
    {
        ProtectiveActionCollection(
            IdentifiedObject.parse (context)
        )
    }
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
        sup.export_fields +
        "\t\t<cim:ProtectiveActionEquipment.inService>" + inService + "</cim:ProtectiveActionEquipment.inService>\n" +
        (if (null != Equipment) "\t\t<cim:ProtectiveActionEquipment.Equipment rdf:resource=\"#" + Equipment + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ProtectiveActionEquipment rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ProtectiveActionEquipment>"
    }
}

object ProtectiveActionEquipment
extends
    Parseable[ProtectiveActionEquipment]
{
    val inService = parse_element (element ("""ProtectiveActionEquipment.inService"""))
    val Equipment = parse_attribute (attribute ("""ProtectiveActionEquipment.Equipment"""))
    def parse (context: Context): ProtectiveActionEquipment =
    {
        ProtectiveActionEquipment(
            ProtectiveAction.parse (context),
            toBoolean (inService (context), context),
            Equipment (context)
        )
    }
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
        sup.export_fields +
        "\t\t<cim:ProtectiveActionRegulation.isRegulating>" + isRegulating + "</cim:ProtectiveActionRegulation.isRegulating>\n" +
        "\t\t<cim:ProtectiveActionRegulation.targetValue>" + targetValue + "</cim:ProtectiveActionRegulation.targetValue>\n" +
        (if (null != RegulatingControl) "\t\t<cim:ProtectiveActionRegulation.RegulatingControl rdf:resource=\"#" + RegulatingControl + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ProtectiveActionRegulation rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ProtectiveActionRegulation>"
    }
}

object ProtectiveActionRegulation
extends
    Parseable[ProtectiveActionRegulation]
{
    val isRegulating = parse_element (element ("""ProtectiveActionRegulation.isRegulating"""))
    val targetValue = parse_element (element ("""ProtectiveActionRegulation.targetValue"""))
    val RegulatingControl = parse_attribute (attribute ("""ProtectiveActionRegulation.RegulatingControl"""))
    def parse (context: Context): ProtectiveActionRegulation =
    {
        ProtectiveActionRegulation(
            ProtectiveAction.parse (context),
            toBoolean (isRegulating (context), context),
            toDouble (targetValue (context), context),
            RegulatingControl (context)
        )
    }
}

/**
 * Remedial Action Scheme (RAS), Special Protection Schemes (SPS), System Protection Schemes (SPS) or System Integrity Protection Schemes (SIPS).
 *
 * @param sup [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param armed The status of the class set by operation or by signal.
 *        Optional field that will override other status fields.
 * @param kind Kind of Remedial Action Scheme (RAS)
 * @param normalArmed The default/normal value used when other active signal/values are missing.
 * @param GateArmed <em>undocumented</em>
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
        sup.export_fields +
        "\t\t<cim:RemedialActionScheme.armed>" + armed + "</cim:RemedialActionScheme.armed>\n" +
        (if (null != kind) "\t\t<cim:RemedialActionScheme.kind rdf:resource=\"#" + kind + "\"/>\n" else "") +
        "\t\t<cim:RemedialActionScheme.normalArmed>" + normalArmed + "</cim:RemedialActionScheme.normalArmed>\n" +
        (if (null != GateArmed) "\t\t<cim:RemedialActionScheme.GateArmed rdf:resource=\"#" + GateArmed + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:RemedialActionScheme rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RemedialActionScheme>"
    }
}

object RemedialActionScheme
extends
    Parseable[RemedialActionScheme]
{
    val armed = parse_element (element ("""RemedialActionScheme.armed"""))
    val kind = parse_attribute (attribute ("""RemedialActionScheme.kind"""))
    val normalArmed = parse_element (element ("""RemedialActionScheme.normalArmed"""))
    val GateArmed = parse_attribute (attribute ("""RemedialActionScheme.GateArmed"""))
    def parse (context: Context): RemedialActionScheme =
    {
        RemedialActionScheme(
            PowerSystemResource.parse (context),
            toBoolean (armed (context), context),
            kind (context),
            toBoolean (normalArmed (context), context),
            GateArmed (context)
        )
    }
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
        sup.export_fields +
        "\t\t<cim:Stage.priority>" + priority + "</cim:Stage.priority>\n" +
        (if (null != RemedialActionScheme) "\t\t<cim:Stage.RemedialActionScheme rdf:resource=\"#" + RemedialActionScheme + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Stage rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Stage>"
    }
}

object Stage
extends
    Parseable[Stage]
{
    val priority = parse_element (element ("""Stage.priority"""))
    val RemedialActionScheme = parse_attribute (attribute ("""Stage.RemedialActionScheme"""))
    def parse (context: Context): Stage =
    {
        Stage(
            IdentifiedObject.parse (context),
            toInteger (priority (context), context),
            RemedialActionScheme (context)
        )
    }
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
 * @param GateArmed <em>undocumented</em>
 * @param GateComCondition <em>undocumented</em>
 * @param GateTrigger <em>undocumented</em>
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
        sup.export_fields +
        "\t\t<cim:StageTrigger.armed>" + armed + "</cim:StageTrigger.armed>\n" +
        "\t\t<cim:StageTrigger.normalArmed>" + normalArmed + "</cim:StageTrigger.normalArmed>\n" +
        "\t\t<cim:StageTrigger.priority>" + priority + "</cim:StageTrigger.priority>\n" +
        (if (null != GateArmed) "\t\t<cim:StageTrigger.GateArmed rdf:resource=\"#" + GateArmed + "\"/>\n" else "") +
        (if (null != GateComCondition) "\t\t<cim:StageTrigger.GateComCondition rdf:resource=\"#" + GateComCondition + "\"/>\n" else "") +
        (if (null != GateTrigger) "\t\t<cim:StageTrigger.GateTrigger rdf:resource=\"#" + GateTrigger + "\"/>\n" else "") +
        (if (null != ProtectiveActionCollection) "\t\t<cim:StageTrigger.ProtectiveActionCollection rdf:resource=\"#" + ProtectiveActionCollection + "\"/>\n" else "") +
        (if (null != Stage) "\t\t<cim:StageTrigger.Stage rdf:resource=\"#" + Stage + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:StageTrigger rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:StageTrigger>"
    }
}

object StageTrigger
extends
    Parseable[StageTrigger]
{
    val armed = parse_element (element ("""StageTrigger.armed"""))
    val normalArmed = parse_element (element ("""StageTrigger.normalArmed"""))
    val priority = parse_element (element ("""StageTrigger.priority"""))
    val GateArmed = parse_attribute (attribute ("""StageTrigger.GateArmed"""))
    val GateComCondition = parse_attribute (attribute ("""StageTrigger.GateComCondition"""))
    val GateTrigger = parse_attribute (attribute ("""StageTrigger.GateTrigger"""))
    val ProtectiveActionCollection = parse_attribute (attribute ("""StageTrigger.ProtectiveActionCollection"""))
    val Stage = parse_attribute (attribute ("""StageTrigger.Stage"""))
    def parse (context: Context): StageTrigger =
    {
        StageTrigger(
            IdentifiedObject.parse (context),
            toBoolean (armed (context), context),
            toBoolean (normalArmed (context), context),
            toInteger (priority (context), context),
            GateArmed (context),
            GateComCondition (context),
            GateTrigger (context),
            ProtectiveActionCollection (context),
            Stage (context)
        )
    }
}

/**
 * A conditions that can trigger remedial actions.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param GateTrigger <em>undocumented</em>
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
        sup.export_fields +
        (if (null != GateTrigger) "\t\t<cim:TriggerCondition.GateTrigger rdf:resource=\"#" + GateTrigger + "\"/>\n" else "") +
        (if (null != RemedialActionScheme) "\t\t<cim:TriggerCondition.RemedialActionScheme rdf:resource=\"#" + RemedialActionScheme + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TriggerCondition rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TriggerCondition>"
    }
}

object TriggerCondition
extends
    Parseable[TriggerCondition]
{
    val GateTrigger = parse_attribute (attribute ("""TriggerCondition.GateTrigger"""))
    val RemedialActionScheme = parse_attribute (attribute ("""TriggerCondition.RemedialActionScheme"""))
    def parse (context: Context): TriggerCondition =
    {
        TriggerCondition(
            IdentifiedObject.parse (context),
            GateTrigger (context),
            RemedialActionScheme (context)
        )
    }
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