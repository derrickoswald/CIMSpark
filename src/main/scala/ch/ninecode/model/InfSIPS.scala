package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * System Integrity Protection Schemes (SIPS) (IEC terminology).
 * Other names used are: Remedial Action Schemes (RAS) or System Protection Schemes (SPS)
 */

/**
 * Categories of analog to digital (or logical result) comparison.
 */
case class AnalogToDigitalLogicKind
(

    override val sup: BasicElement,

    /**
     * Equal (like) comparison operation.
     */
    val eq: String,

    /**
     * Greater or equal comparison operation.
     */
    val ge: String,

    /**
     * Greater than comparison operation.
     */
    val gt: String,

    /**
     * Less or equal comparison operation.
     */
    val le: String,

    /**
     * Less than comparison operation.
     */
    val lt: String,

    /**
     * Not equal (unlike) comparison operation.
     */
    val ne: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[AnalogToDigitalLogicKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AnalogToDigitalLogicKind
extends
    Parseable[AnalogToDigitalLogicKind]
{
    val sup = BasicElement.parse _
    val eq = parse_attribute (attribute ("""AnalogToDigitalLogicKind.eq"""))_
    val ge = parse_attribute (attribute ("""AnalogToDigitalLogicKind.ge"""))_
    val gt = parse_attribute (attribute ("""AnalogToDigitalLogicKind.gt"""))_
    val le = parse_attribute (attribute ("""AnalogToDigitalLogicKind.le"""))_
    val lt = parse_attribute (attribute ("""AnalogToDigitalLogicKind.lt"""))_
    val ne = parse_attribute (attribute ("""AnalogToDigitalLogicKind.ne"""))_
    def parse (context: Context): AnalogToDigitalLogicKind =
    {
        AnalogToDigitalLogicKind(
            sup (context),
            eq (context),
            ge (context),
            gt (context),
            le (context),
            lt (context),
            ne (context)
        )
    }
}

/**
 * Categorisation of calculation operation that can be done to Measurement.
 */
case class CalculationKind
(

    override val sup: BasicElement,

    /**
     * Division operation the input values (operands).
     */
    val div: String,

    /**
     * Multiplication operation the input values (operands).
     */
    val mul: String,

    /**
     * Square root operator - only one input value (operands).
     */
    val sqrt: String,

    /**
     * Summation operation over the input values (operands).
     */
    val sum: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[CalculationKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CalculationKind
extends
    Parseable[CalculationKind]
{
    val sup = BasicElement.parse _
    val div = parse_attribute (attribute ("""CalculationKind.div"""))_
    val mul = parse_attribute (attribute ("""CalculationKind.mul"""))_
    val sqrt = parse_attribute (attribute ("""CalculationKind.sqrt"""))_
    val sum = parse_attribute (attribute ("""CalculationKind.sum"""))_
    def parse (context: Context): CalculationKind =
    {
        CalculationKind(
            sup (context),
            div (context),
            mul (context),
            sqrt (context),
            sum (context)
        )
    }
}

/**
 * Logical gate than support logical operation based on the input.
 */
case class Gate
(

    override val sup: IdentifiedObject,

    /**
     * The logical operation of the gate.
     */
    val kind: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Gate]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Gate
extends
    Parseable[Gate]
{
    val sup = IdentifiedObject.parse _
    val kind = parse_attribute (attribute ("""Gate.kind"""))_
    def parse (context: Context): Gate =
    {
        Gate(
            sup (context),
            kind (context)
        )
    }
}

/**
 * Input pin for a logical gate.
 * The condition described in the input pin will give a logical true or false. Result from measurement and calculation are converted to a true or false.
 */
case class GateInputPin
(

    override val sup: IdentifiedObject,

    /**
     * The compare operation.
     */
    val aDLogicKind: String,

    /**
     * If true, use the absolute value for compare..
     */
    val absoluteValue: Boolean,

    /**
     * The duration the compare condition need to be present before given a true.
     * Default is 0 seconds.
     */
    val duration: Double,

    /**
     * Invert/negate the result of the compare.
     */
    val negate: Boolean,

    /**
     * The threshold percentage that should be used for compare with the percentage change between input value and threshold value.
     */
    val thresholdPercentage: Double,

    /**
     * The threshold value that should be used for compare with the input value.
     */
    val thresholdValue: Double,

    val Gate: String
)
extends
    Element
{
    def this () = { this (null, null, false, 0.0, false, 0.0, 0.0, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[GateInputPin]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GateInputPin
extends
    Parseable[GateInputPin]
{
    val sup = IdentifiedObject.parse _
    val aDLogicKind = parse_attribute (attribute ("""GateInputPin.aDLogicKind"""))_
    val absoluteValue = parse_element (element ("""GateInputPin.absoluteValue"""))_
    val duration = parse_element (element ("""GateInputPin.duration"""))_
    val negate = parse_element (element ("""GateInputPin.negate"""))_
    val thresholdPercentage = parse_element (element ("""GateInputPin.thresholdPercentage"""))_
    val thresholdValue = parse_element (element ("""GateInputPin.thresholdValue"""))_
    val Gate = parse_attribute (attribute ("""GateInputPin.Gate"""))_
    def parse (context: Context): GateInputPin =
    {
        GateInputPin(
            sup (context),
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
 * Define the different logical operations.
 */
case class GateLogicKind
(

    override val sup: BasicElement,

    /**
     * A logical AND operation.
     * True when all input are true.
     */
    val and: String,

    /**
     * A logical NAND operation.
     * False when all input are true.
     */
    val nand: String,

    /**
     * A logical NOR operation.
     * False when one or more input are true.
     */
    val nor: String,

    /**
     * A logical NOT operation.
     * Only one input and true input will give false out and false in will give true out. An inverter.
     */
    val not: String,

    /**
     * A logical OR operation.
     * True when one or more input are true.
     */
    val or: String,

    /**
     * A logical XNOR operation.
     * The function is the inverse of the exclusive OR (XOR) gate. All input false or true will give true. Otherwise false.
     */
    val xnor: String,

    /**
     * A logical XOR operation.
     * All input false or true will give false. Otherwise true.
     */
    val xor: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[GateLogicKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GateLogicKind
extends
    Parseable[GateLogicKind]
{
    val sup = BasicElement.parse _
    val and = parse_attribute (attribute ("""GateLogicKind.and"""))_
    val nand = parse_attribute (attribute ("""GateLogicKind.nand"""))_
    val nor = parse_attribute (attribute ("""GateLogicKind.nor"""))_
    val not = parse_attribute (attribute ("""GateLogicKind.not"""))_
    val or = parse_attribute (attribute ("""GateLogicKind.or"""))_
    val xnor = parse_attribute (attribute ("""GateLogicKind.xnor"""))_
    val xor = parse_attribute (attribute ("""GateLogicKind.xor"""))_
    def parse (context: Context): GateLogicKind =
    {
        GateLogicKind(
            sup (context),
            and (context),
            nand (context),
            nor (context),
            not (context),
            or (context),
            xnor (context),
            xor (context)
        )
    }
}

/**
 * Result of a calculation of one or more measurement.
 */
case class MeasurementCalculator
(

    override val sup: IdentifiedObject,

    /**
     * Calculation operation executed on the operants.
     */
    val kind: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[MeasurementCalculator]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MeasurementCalculator
extends
    Parseable[MeasurementCalculator]
{
    val sup = IdentifiedObject.parse _
    val kind = parse_attribute (attribute ("""MeasurementCalculator.kind"""))_
    def parse (context: Context): MeasurementCalculator =
    {
        MeasurementCalculator(
            sup (context),
            kind (context)
        )
    }
}

/**
 * Input to measurement calculation.
 * Support Analog, Discrete and Accumulator.
 */
case class MeasurementCalculatorInput
(

    override val sup: IdentifiedObject,

    /**
     * If true, use the absolute value for the calculation.
     */
    val absoluteValue: Boolean,

    /**
     * Positive number that defines the order of the operant in the calculation. 0 = default.
     * The order is not relevant (e.g. summation).
     */
    val order: Int,

    val Measurement: String,

    val MeasurementCalculator: String
)
extends
    Element
{
    def this () = { this (null, false, 0, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[MeasurementCalculatorInput]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MeasurementCalculatorInput
extends
    Parseable[MeasurementCalculatorInput]
{
    val sup = IdentifiedObject.parse _
    val absoluteValue = parse_element (element ("""MeasurementCalculatorInput.absoluteValue"""))_
    val order = parse_element (element ("""MeasurementCalculatorInput.order"""))_
    val Measurement = parse_attribute (attribute ("""MeasurementCalculatorInput.Measurement"""))_
    val MeasurementCalculator = parse_attribute (attribute ("""MeasurementCalculatorInput.MeasurementCalculator"""))_
    def parse (context: Context): MeasurementCalculatorInput =
    {
        MeasurementCalculatorInput(
            sup (context),
            toBoolean (absoluteValue (context), context),
            toInteger (order (context), context),
            Measurement (context),
            MeasurementCalculator (context)
        )
    }
}

/**
 * Value associated with branch group is used as compare.
 */
case class PinBranchGroup
(

    override val sup: GateInputPin,

    /**
     * The compare operation done on the branch group.
     */
    val kind: String,

    val BranchGroup: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def GateInputPin: GateInputPin = sup.asInstanceOf[GateInputPin]
    override def copy (): Row = { return (clone ().asInstanceOf[PinBranchGroup]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PinBranchGroup
extends
    Parseable[PinBranchGroup]
{
    val sup = GateInputPin.parse _
    val kind = parse_attribute (attribute ("""PinBranchGroup.kind"""))_
    val BranchGroup = parse_attribute (attribute ("""PinBranchGroup.BranchGroup"""))_
    def parse (context: Context): PinBranchGroup =
    {
        PinBranchGroup(
            sup (context),
            kind (context),
            BranchGroup (context)
        )
    }
}

/**
 * Categorisation of type of compare done on a branch group.
 */
case class PinBranchGroupKind
(

    override val sup: BasicElement,

    /**
     * Active power in the branch group.
     */
    val activePower: String,

    /**
     * reactive power in the branch group.
     */
    val reactivePower: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[PinBranchGroupKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PinBranchGroupKind
extends
    Parseable[PinBranchGroupKind]
{
    val sup = BasicElement.parse _
    val activePower = parse_attribute (attribute ("""PinBranchGroupKind.activePower"""))_
    val reactivePower = parse_attribute (attribute ("""PinBranchGroupKind.reactivePower"""))_
    def parse (context: Context): PinBranchGroupKind =
    {
        PinBranchGroupKind(
            sup (context),
            activePower (context),
            reactivePower (context)
        )
    }
}

/**
 * Value associated with Equipment is used as compare.
 */
case class PinEquipment
(

    override val sup: GateInputPin,

    /**
     * The compare operation done on the equipment.
     */
    val kind: String,

    val Equipment: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def GateInputPin: GateInputPin = sup.asInstanceOf[GateInputPin]
    override def copy (): Row = { return (clone ().asInstanceOf[PinEquipment]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PinEquipment
extends
    Parseable[PinEquipment]
{
    val sup = GateInputPin.parse _
    val kind = parse_attribute (attribute ("""PinEquipment.kind"""))_
    val Equipment = parse_attribute (attribute ("""PinEquipment.Equipment"""))_
    def parse (context: Context): PinEquipment =
    {
        PinEquipment(
            sup (context),
            kind (context),
            Equipment (context)
        )
    }
}

/**
 * Categorisation of type of compare done on Equipment.
 */
case class PinEquipmentKind
(

    override val sup: BasicElement,

    /**
     * Compare load flow result against the active limit for active power for the given equipment.
     */
    val activePowerLimit: String,

    /**
     * Compare load flow result against the active limit for apparent power for the given equipment.
     */
    val apparentPowerLimit: String,

    /**
     * Check if all terminal on the equipment is connected.
     */
    val connected: String,

    /**
     * Compare load flow result against the active current limit for the equipment.
     */
    val currentLimit: String,

    /**
     * Check if equipment is in service, True if in service otherwise false.
     */
    val inService: String,

    /**
     * Compare load flow result against rated current on the equipment (switch).
     */
    val ratedCurrent: String,

    /**
     * Compare load flow result against the active voltage limit for the equipment.
     */
    val voltageLimit: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[PinEquipmentKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PinEquipmentKind
extends
    Parseable[PinEquipmentKind]
{
    val sup = BasicElement.parse _
    val activePowerLimit = parse_attribute (attribute ("""PinEquipmentKind.activePowerLimit"""))_
    val apparentPowerLimit = parse_attribute (attribute ("""PinEquipmentKind.apparentPowerLimit"""))_
    val connected = parse_attribute (attribute ("""PinEquipmentKind.connected"""))_
    val currentLimit = parse_attribute (attribute ("""PinEquipmentKind.currentLimit"""))_
    val inService = parse_attribute (attribute ("""PinEquipmentKind.inService"""))_
    val ratedCurrent = parse_attribute (attribute ("""PinEquipmentKind.ratedCurrent"""))_
    val voltageLimit = parse_attribute (attribute ("""PinEquipmentKind.voltageLimit"""))_
    def parse (context: Context): PinEquipmentKind =
    {
        PinEquipmentKind(
            sup (context),
            activePowerLimit (context),
            apparentPowerLimit (context),
            connected (context),
            currentLimit (context),
            inService (context),
            ratedCurrent (context),
            voltageLimit (context)
        )
    }
}

/**
 * An output from one gate represent an input to another gate.
 */
case class PinGate
(

    override val sup: GateInputPin,

    val GateOutput: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def GateInputPin: GateInputPin = sup.asInstanceOf[GateInputPin]
    override def copy (): Row = { return (clone ().asInstanceOf[PinGate]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PinGate
extends
    Parseable[PinGate]
{
    val sup = GateInputPin.parse _
    val GateOutput = parse_attribute (attribute ("""PinGate.GateOutput"""))_
    def parse (context: Context): PinGate =
    {
        PinGate(
            sup (context),
            GateOutput (context)
        )
    }
}

/**
 * Gate input pin that is associated with a Measurement or a calculation of Measurement.
 */
case class PinMeasurement
(

    override val sup: GateInputPin,

    val Measurement: String,

    val MeasurementCalculator: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def GateInputPin: GateInputPin = sup.asInstanceOf[GateInputPin]
    override def copy (): Row = { return (clone ().asInstanceOf[PinMeasurement]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PinMeasurement
extends
    Parseable[PinMeasurement]
{
    val sup = GateInputPin.parse _
    val Measurement = parse_attribute (attribute ("""PinMeasurement.Measurement"""))_
    val MeasurementCalculator = parse_attribute (attribute ("""PinMeasurement.MeasurementCalculator"""))_
    def parse (context: Context): PinMeasurement =
    {
        PinMeasurement(
            sup (context),
            Measurement (context),
            MeasurementCalculator (context)
        )
    }
}

/**
 * Value associated with Terminal is used as compare.
 */
case class PinTerminal
(

    override val sup: GateInputPin,

    /**
     * The compare operation done on the terminal.
     */
    val kind: String,

    val Terminal: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def GateInputPin: GateInputPin = sup.asInstanceOf[GateInputPin]
    override def copy (): Row = { return (clone ().asInstanceOf[PinTerminal]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PinTerminal
extends
    Parseable[PinTerminal]
{
    val sup = GateInputPin.parse _
    val kind = parse_attribute (attribute ("""PinTerminal.kind"""))_
    val Terminal = parse_attribute (attribute ("""PinTerminal.Terminal"""))_
    def parse (context: Context): PinTerminal =
    {
        PinTerminal(
            sup (context),
            kind (context),
            Terminal (context)
        )
    }
}

/**
 * Categorisation of type of compare done on Terminal.
 */
case class PinTerminalKind
(

    override val sup: BasicElement,

    /**
     * Active Power on the Terminal.
     */
    val activePower: String,

    /**
     * Apparent Power on the Terminal.
     */
    val apparentPower: String,

    /**
     * Reactive Power on the Terminal.
     */
    val reactivePower: String,

    /**
     * Voltage on the Terminal.
     */
    val voltage: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[PinTerminalKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PinTerminalKind
extends
    Parseable[PinTerminalKind]
{
    val sup = BasicElement.parse _
    val activePower = parse_attribute (attribute ("""PinTerminalKind.activePower"""))_
    val apparentPower = parse_attribute (attribute ("""PinTerminalKind.apparentPower"""))_
    val reactivePower = parse_attribute (attribute ("""PinTerminalKind.reactivePower"""))_
    val voltage = parse_attribute (attribute ("""PinTerminalKind.voltage"""))_
    def parse (context: Context): PinTerminalKind =
    {
        PinTerminalKind(
            sup (context),
            activePower (context),
            apparentPower (context),
            reactivePower (context),
            voltage (context)
        )
    }
}

/**
 * A protective action for supporting the integrity of the power system.
 */
case class ProtectiveAction
(

    override val sup: IdentifiedObject,

    /**
     * The status of the class set by operation or by signal.
     * Optional field that will override other status fields.
     */
    val enabled: Boolean,

    /**
     * The default/normal value used when other active signal/values are missing.
     */
    val normalEnabled: Boolean,

    val GateComCondition: String,

    val GateEnabledCondition: String,

    val ProtectionEquipment: String,

    val ProtectiveActionCollection: String
)
extends
    Element
{
    def this () = { this (null, false, false, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ProtectiveAction]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ProtectiveAction
extends
    Parseable[ProtectiveAction]
{
    val sup = IdentifiedObject.parse _
    val enabled = parse_element (element ("""ProtectiveAction.enabled"""))_
    val normalEnabled = parse_element (element ("""ProtectiveAction.normalEnabled"""))_
    val GateComCondition = parse_attribute (attribute ("""ProtectiveAction.GateComCondition"""))_
    val GateEnabledCondition = parse_attribute (attribute ("""ProtectiveAction.GateEnabledCondition"""))_
    val ProtectionEquipment = parse_attribute (attribute ("""ProtectiveAction.ProtectionEquipment"""))_
    val ProtectiveActionCollection = parse_attribute (attribute ("""ProtectiveAction.ProtectiveActionCollection"""))_
    def parse (context: Context): ProtectiveAction =
    {
        ProtectiveAction(
            sup (context),
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
 * The operating condition is adjusted.
 */
case class ProtectiveActionAdjustment
(

    override val sup: ProtectiveAction,

    /**
     * The adjustment is given in percent of the active value.
     */
    val byPercentage: Double,

    /**
     * The adjustment is given in value of the active value.
     */
    val byValue: Double,

    /**
     * Defines the kind of adjustment that should be done.
     * With this value the correct attribute containing the value needs to be used.
     */
    val kind: String,

    /**
     * If true, the adjusted value is an reduction.
     * Other wise it is an increase in the value.
     */
    val reduce: Boolean,

    /**
     * The adjustment is given by a new active value.
     */
    val setValue: Double,

    val ConductingEquipment: String,

    val DCConductingEquipment: String,

    val Measurement: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null, false, 0.0, null, null, null) }
    def ProtectiveAction: ProtectiveAction = sup.asInstanceOf[ProtectiveAction]
    override def copy (): Row = { return (clone ().asInstanceOf[ProtectiveActionAdjustment]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ProtectiveActionAdjustment
extends
    Parseable[ProtectiveActionAdjustment]
{
    val sup = ProtectiveAction.parse _
    val byPercentage = parse_element (element ("""ProtectiveActionAdjustment.byPercentage"""))_
    val byValue = parse_element (element ("""ProtectiveActionAdjustment.byValue"""))_
    val kind = parse_attribute (attribute ("""ProtectiveActionAdjustment.kind"""))_
    val reduce = parse_element (element ("""ProtectiveActionAdjustment.reduce"""))_
    val setValue = parse_element (element ("""ProtectiveActionAdjustment.setValue"""))_
    val ConductingEquipment = parse_attribute (attribute ("""ProtectiveActionAdjustment.ConductingEquipment"""))_
    val DCConductingEquipment = parse_attribute (attribute ("""ProtectiveActionAdjustment.DCConductingEquipment"""))_
    val Measurement = parse_attribute (attribute ("""ProtectiveActionAdjustment.Measurement"""))_
    def parse (context: Context): ProtectiveActionAdjustment =
    {
        ProtectiveActionAdjustment(
            sup (context),
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
 * Categorisation of different protective action adjustments that can be performed on equipment.
 */
case class ProtectiveActionAdjustmentKind
(

    override val sup: BasicElement,

    /**
     * The adjustment is in percentage of the active value.
     */
    val byPercentage: String,

    /**
     * The adjustment is in given by a value that defined the changes that will be done to the active value.
     */
    val byValue: String,

    /**
     * The equipment will operating on a value given by a measurement.
     */
    val measurement: String,

    /**
     * The equipment will operate on the new value.
     */
    val setValue: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ProtectiveActionAdjustmentKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ProtectiveActionAdjustmentKind
extends
    Parseable[ProtectiveActionAdjustmentKind]
{
    val sup = BasicElement.parse _
    val byPercentage = parse_attribute (attribute ("""ProtectiveActionAdjustmentKind.byPercentage"""))_
    val byValue = parse_attribute (attribute ("""ProtectiveActionAdjustmentKind.byValue"""))_
    val measurement = parse_attribute (attribute ("""ProtectiveActionAdjustmentKind.measurement"""))_
    val setValue = parse_attribute (attribute ("""ProtectiveActionAdjustmentKind.setValue"""))_
    def parse (context: Context): ProtectiveActionAdjustmentKind =
    {
        ProtectiveActionAdjustmentKind(
            sup (context),
            byPercentage (context),
            byValue (context),
            measurement (context),
            setValue (context)
        )
    }
}

/**
 * A collection of protective actions to protect the integrity of the power system.
 */
case class ProtectiveActionCollection
(

    override val sup: IdentifiedObject
)
extends
    Element
{
    def this () = { this (null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ProtectiveActionCollection]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ProtectiveActionCollection
extends
    Parseable[ProtectiveActionCollection]
{
    val sup = IdentifiedObject.parse _
    def parse (context: Context): ProtectiveActionCollection =
    {
        ProtectiveActionCollection(
            sup (context)
        )
    }
}

/**
 * Protective action to put an Equipment in-service/out-of-service.
 */
case class ProtectiveActionEquipment
(

    override val sup: ProtectiveAction,

    /**
     * If true the equipment is put in-service, otherwise out-of-service.
     */
    val inService: Boolean,

    val Equipment: String
)
extends
    Element
{
    def this () = { this (null, false, null) }
    def ProtectiveAction: ProtectiveAction = sup.asInstanceOf[ProtectiveAction]
    override def copy (): Row = { return (clone ().asInstanceOf[ProtectiveActionEquipment]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ProtectiveActionEquipment
extends
    Parseable[ProtectiveActionEquipment]
{
    val sup = ProtectiveAction.parse _
    val inService = parse_element (element ("""ProtectiveActionEquipment.inService"""))_
    val Equipment = parse_attribute (attribute ("""ProtectiveActionEquipment.Equipment"""))_
    def parse (context: Context): ProtectiveActionEquipment =
    {
        ProtectiveActionEquipment(
            sup (context),
            toBoolean (inService (context), context),
            Equipment (context)
        )
    }
}

/**
 * Protective action to change regulation to Equipment.
 */
case class ProtectiveActionRegulation
(

    override val sup: ProtectiveAction,

    /**
     * If true the regulator is put in-service, otherwise out-of-service (no regulation).
     */
    val isRegulating: Boolean,

    /**
     * The target value specified the new case input for the regulator.
     * The value has the units appropriate to the mode attribute. The protective action does not change the mode attribute.
     */
    val targetValue: Double,

    val RegulatingControl: String
)
extends
    Element
{
    def this () = { this (null, false, 0.0, null) }
    def ProtectiveAction: ProtectiveAction = sup.asInstanceOf[ProtectiveAction]
    override def copy (): Row = { return (clone ().asInstanceOf[ProtectiveActionRegulation]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ProtectiveActionRegulation
extends
    Parseable[ProtectiveActionRegulation]
{
    val sup = ProtectiveAction.parse _
    val isRegulating = parse_element (element ("""ProtectiveActionRegulation.isRegulating"""))_
    val targetValue = parse_element (element ("""ProtectiveActionRegulation.targetValue"""))_
    val RegulatingControl = parse_attribute (attribute ("""ProtectiveActionRegulation.RegulatingControl"""))_
    def parse (context: Context): ProtectiveActionRegulation =
    {
        ProtectiveActionRegulation(
            sup (context),
            toBoolean (isRegulating (context), context),
            toDouble (targetValue (context), context),
            RegulatingControl (context)
        )
    }
}

/**
 * Remedial Action Scheme (RAS), Special Protection Schemes (SPS), System Protection Schemes (SPS) or System Integrity Protection Schemes (SIPS).
 */
case class RemedialActionScheme
(

    override val sup: PowerSystemResource,

    /**
     * The status of the class set by operation or by signal.
     * Optional field that will override other status fields.
     */
    val armed: Boolean,

    /**
     * Kind of Remedial Action Scheme (RAS)
     */
    val kind: String,

    /**
     * The default/normal value used when other active signal/values are missing.
     */
    val normalArmed: Boolean,

    val GateArmed: String
)
extends
    Element
{
    def this () = { this (null, false, null, false, null) }
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { return (clone ().asInstanceOf[RemedialActionScheme]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RemedialActionScheme
extends
    Parseable[RemedialActionScheme]
{
    val sup = PowerSystemResource.parse _
    val armed = parse_element (element ("""RemedialActionScheme.armed"""))_
    val kind = parse_attribute (attribute ("""RemedialActionScheme.kind"""))_
    val normalArmed = parse_element (element ("""RemedialActionScheme.normalArmed"""))_
    val GateArmed = parse_attribute (attribute ("""RemedialActionScheme.GateArmed"""))_
    def parse (context: Context): RemedialActionScheme =
    {
        RemedialActionScheme(
            sup (context),
            toBoolean (armed (context), context),
            kind (context),
            toBoolean (normalArmed (context), context),
            GateArmed (context)
        )
    }
}

/**
 * Classification of Remedial Action Scheme.
 */
case class RemedialActionSchemeKind
(

    override val sup: BasicElement,

    /**
     * Remedial Action Plan (RAP)
     */
    val rAP: String,

    /**
     * Remedial Action Scheme (RAS).
     */
    val rAS: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[RemedialActionSchemeKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RemedialActionSchemeKind
extends
    Parseable[RemedialActionSchemeKind]
{
    val sup = BasicElement.parse _
    val rAP = parse_attribute (attribute ("""RemedialActionSchemeKind.rAP"""))_
    val rAS = parse_attribute (attribute ("""RemedialActionSchemeKind.rAS"""))_
    def parse (context: Context): RemedialActionSchemeKind =
    {
        RemedialActionSchemeKind(
            sup (context),
            rAP (context),
            rAS (context)
        )
    }
}

/**
 * Stage of a remedial action scheme.
 */
case class Stage
(

    override val sup: IdentifiedObject,

    /**
     * The priority of the stage.   0 = don t care (default) 1 = highest priority. 2 is less than 1 and so on.
     * A stage with higher priority needs be activated before a lower stage can be activated.
     */
    val priority: Int,

    val RemedialActionScheme: String
)
extends
    Element
{
    def this () = { this (null, 0, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Stage]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Stage
extends
    Parseable[Stage]
{
    val sup = IdentifiedObject.parse _
    val priority = parse_element (element ("""Stage.priority"""))_
    val RemedialActionScheme = parse_attribute (attribute ("""Stage.RemedialActionScheme"""))_
    def parse (context: Context): Stage =
    {
        Stage(
            sup (context),
            toInteger (priority (context), context),
            RemedialActionScheme (context)
        )
    }
}

/**
 * Condition that is triggered either by TriggerCondition of by gate condition within a stage and has remedial action-s.
 */
case class StageTrigger
(

    override val sup: IdentifiedObject,

    /**
     * The status of the class set by operation or by signal.
     * Optional field that will override other status fields.
     */
    val armed: Boolean,

    /**
     * The default/normal value used when other active signal/values are missing.
     */
    val normalArmed: Boolean,

    /**
     * Priority of trigger. 0 = don t care (default) 1 = highest priority. 2 is less than 1 and so on.
     * A trigger with the highest priority will trigger first.
     */
    val priority: Int,

    val GateArmed: String,

    val GateComCondition: String,

    val GateTrigger: String,

    val ProtectiveActionCollection: String,

    val Stage: String
)
extends
    Element
{
    def this () = { this (null, false, false, 0, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[StageTrigger]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object StageTrigger
extends
    Parseable[StageTrigger]
{
    val sup = IdentifiedObject.parse _
    val armed = parse_element (element ("""StageTrigger.armed"""))_
    val normalArmed = parse_element (element ("""StageTrigger.normalArmed"""))_
    val priority = parse_element (element ("""StageTrigger.priority"""))_
    val GateArmed = parse_attribute (attribute ("""StageTrigger.GateArmed"""))_
    val GateComCondition = parse_attribute (attribute ("""StageTrigger.GateComCondition"""))_
    val GateTrigger = parse_attribute (attribute ("""StageTrigger.GateTrigger"""))_
    val ProtectiveActionCollection = parse_attribute (attribute ("""StageTrigger.ProtectiveActionCollection"""))_
    val Stage = parse_attribute (attribute ("""StageTrigger.Stage"""))_
    def parse (context: Context): StageTrigger =
    {
        StageTrigger(
            sup (context),
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
 */
case class TriggerCondition
(

    override val sup: IdentifiedObject,

    val GateTrigger: String,

    val RemedialActionScheme: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[TriggerCondition]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TriggerCondition
extends
    Parseable[TriggerCondition]
{
    val sup = IdentifiedObject.parse _
    val GateTrigger = parse_attribute (attribute ("""TriggerCondition.GateTrigger"""))_
    val RemedialActionScheme = parse_attribute (attribute ("""TriggerCondition.RemedialActionScheme"""))_
    def parse (context: Context): TriggerCondition =
    {
        TriggerCondition(
            sup (context),
            GateTrigger (context),
            RemedialActionScheme (context)
        )
    }
}

object _InfSIPS
{
    def register: Unit =
    {
        AnalogToDigitalLogicKind.register
        CalculationKind.register
        Gate.register
        GateInputPin.register
        GateLogicKind.register
        MeasurementCalculator.register
        MeasurementCalculatorInput.register
        PinBranchGroup.register
        PinBranchGroupKind.register
        PinEquipment.register
        PinEquipmentKind.register
        PinGate.register
        PinMeasurement.register
        PinTerminal.register
        PinTerminalKind.register
        ProtectiveAction.register
        ProtectiveActionAdjustment.register
        ProtectiveActionAdjustmentKind.register
        ProtectiveActionCollection.register
        ProtectiveActionEquipment.register
        ProtectiveActionRegulation.register
        RemedialActionScheme.register
        RemedialActionSchemeKind.register
        Stage.register
        StageTrigger.register
        TriggerCondition.register
    }
}