package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context


/**
 * SVC asset allows the capacitive and inductive ratings for each phase to be specified individually if required.
 */
case class SVC
(

    override val sup: ShuntCompensator,

    /**
     * Maximum capacitive reactive power.
     */
    val capacitiveRating: Double,

    /**
     * Maximum inductive reactive power.
     */
    val inductiveRating: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0) }
    def ShuntCompensator: ShuntCompensator = sup.asInstanceOf[ShuntCompensator]
    override def copy (): Row = { return (clone ().asInstanceOf[SVC]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SVC
extends
    Parseable[SVC]
{
    val sup = ShuntCompensator.parse _
    val capacitiveRating = parse_element (element ("""SVC.capacitiveRating"""))_
    val inductiveRating = parse_element (element ("""SVC.inductiveRating"""))_
    def parse (context: Context): SVC =
    {
        SVC(
            sup (context),
            toDouble (capacitiveRating (context), context),
            toDouble (inductiveRating (context), context)
        )
    }
}

/**
 * Distribution capacitor bank control settings.
 */
case class ShuntCompensatorControl
(

    override val sup: RegulatingControl,

    /**
     * For VAR, amp, or power factor locally controlled shunt impedances, the flow direction: in, out.
     */
    val branchDirect: Int,

    /**
     * The size of the individual units that make up the bank.
     */
    val cellSize: Double,

    /**
     * Kind of control (if any).
     */
    val controlKind: String,

    /**
     * For locally controlled shunt impedances which have a voltage override feature, the high voltage override value.
     * If the voltage is above this value, the shunt impedance will be turned off regardless of the other local controller settings.
     */
    val highVoltageOverride: Double,

    /**
     * Kind of local controller.
     */
    val localControlKind: String,

    /**
     * Upper control setting.
     */
    val localOffLevel: String,

    /**
     * Lower control setting.
     */
    val localOnLevel: String,

    /**
     * True if the locally controlled capacitor has voltage override capability.
     */
    val localOverride: Boolean,

    /**
     * For locally controlled shunt impedances which have a voltage override feature, the low voltage override value.
     * If the voltage is below this value, the shunt impedance will be turned on regardless of the other local controller settings.
     */
    val lowVoltageOverride: Double,

    /**
     * IdmsShuntImpedanceData.maxNumSwitchOps.
     */
    val maxSwitchOperationCount: Int,

    /**
     * True if open is normal status for a fixed capacitor bank, otherwise normal status is closed.
     */
    val normalOpen: Boolean,

    /**
     * For VAR, amp, or power factor locally controlled shunt impedances, the index of the regulation branch.
     */
    val regBranch: String,

    /**
     * For VAR, amp, or power factor locally controlled shunt impedances, the end of the branch that is regulated.
     * The field has the following values: from side, to side, and tertiary (only if the branch is a transformer).
     */
    val regBranchEnd: Int,

    /**
     * (For VAR, amp, or power factor locally controlled shunt impedances) Kind of regulation branch.
     */
    val regBranchKind: String,

    /**
     * Phases that are measured for controlling the device.
     */
    val sensingPhaseCode: String,

    /**
     * Time interval between consecutive switching operations.
     */
    val switchOperationCycle: Double,

    /**
     * True if regulated voltages are measured line to line, otherwise they are measured line to ground.
     */
    val vRegLineLine: Boolean,

    val ShuntCompensatorInfo: String
)
extends
    Element
{
    def this () = { this (null, 0, 0.0, null, 0.0, null, null, null, false, 0.0, 0, false, null, 0, null, null, 0.0, false, null) }
    def RegulatingControl: RegulatingControl = sup.asInstanceOf[RegulatingControl]
    override def copy (): Row = { return (clone ().asInstanceOf[ShuntCompensatorControl]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ShuntCompensatorControl
extends
    Parseable[ShuntCompensatorControl]
{
    val sup = RegulatingControl.parse _
    val branchDirect = parse_element (element ("""ShuntCompensatorControl.branchDirect"""))_
    val cellSize = parse_element (element ("""ShuntCompensatorControl.cellSize"""))_
    val controlKind = parse_attribute (attribute ("""ShuntCompensatorControl.controlKind"""))_
    val highVoltageOverride = parse_element (element ("""ShuntCompensatorControl.highVoltageOverride"""))_
    val localControlKind = parse_attribute (attribute ("""ShuntCompensatorControl.localControlKind"""))_
    val localOffLevel = parse_element (element ("""ShuntCompensatorControl.localOffLevel"""))_
    val localOnLevel = parse_element (element ("""ShuntCompensatorControl.localOnLevel"""))_
    val localOverride = parse_element (element ("""ShuntCompensatorControl.localOverride"""))_
    val lowVoltageOverride = parse_element (element ("""ShuntCompensatorControl.lowVoltageOverride"""))_
    val maxSwitchOperationCount = parse_element (element ("""ShuntCompensatorControl.maxSwitchOperationCount"""))_
    val normalOpen = parse_element (element ("""ShuntCompensatorControl.normalOpen"""))_
    val regBranch = parse_element (element ("""ShuntCompensatorControl.regBranch"""))_
    val regBranchEnd = parse_element (element ("""ShuntCompensatorControl.regBranchEnd"""))_
    val regBranchKind = parse_attribute (attribute ("""ShuntCompensatorControl.regBranchKind"""))_
    val sensingPhaseCode = parse_attribute (attribute ("""ShuntCompensatorControl.sensingPhaseCode"""))_
    val switchOperationCycle = parse_element (element ("""ShuntCompensatorControl.switchOperationCycle"""))_
    val vRegLineLine = parse_element (element ("""ShuntCompensatorControl.vRegLineLine"""))_
    val ShuntCompensatorInfo = parse_attribute (attribute ("""ShuntCompensatorControl.ShuntCompensatorInfo"""))_
    def parse (context: Context): ShuntCompensatorControl =
    {
        ShuntCompensatorControl(
            sup (context),
            toInteger (branchDirect (context), context),
            toDouble (cellSize (context), context),
            controlKind (context),
            toDouble (highVoltageOverride (context), context),
            localControlKind (context),
            localOffLevel (context),
            localOnLevel (context),
            toBoolean (localOverride (context), context),
            toDouble (lowVoltageOverride (context), context),
            toInteger (maxSwitchOperationCount (context), context),
            toBoolean (normalOpen (context), context),
            regBranch (context),
            toInteger (regBranchEnd (context), context),
            regBranchKind (context),
            sensingPhaseCode (context),
            toDouble (switchOperationCycle (context), context),
            toBoolean (vRegLineLine (context), context),
            ShuntCompensatorInfo (context)
        )
    }
}

object _InfWiresExt
{
    def register: Unit =
    {
        SVC.register
        ShuntCompensatorControl.register
    }
}