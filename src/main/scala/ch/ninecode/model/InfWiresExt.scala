package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context


/**
 * SVC asset allows the capacitive and inductive ratings for each phase to be specified individually if required.
 * @param sup Reference to the superclass object.
 * @param capacitiveRating Maximum capacitive reactive power.
 * @param inductiveRating Maximum inductive reactive power.
 */
case class SVC
(
    override val sup: ShuntCompensator,
    val capacitiveRating: Double,
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
    val capacitiveRating = parse_element (element ("""SVC.capacitiveRating"""))
    val inductiveRating = parse_element (element ("""SVC.inductiveRating"""))
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
 * @param sup Reference to the superclass object.
 * @param branchDirect For VAR, amp, or power factor locally controlled shunt impedances, the flow direction: in, out.
 * @param cellSize The size of the individual units that make up the bank.
 * @param controlKind Kind of control (if any).
 * @param highVoltageOverride For locally controlled shunt impedances which have a voltage override feature, the high voltage override value.
 *        If the voltage is above this value, the shunt impedance will be turned off regardless of the other local controller settings.
 * @param localControlKind Kind of local controller.
 * @param localOffLevel Upper control setting.
 * @param localOnLevel Lower control setting.
 * @param localOverride True if the locally controlled capacitor has voltage override capability.
 * @param lowVoltageOverride For locally controlled shunt impedances which have a voltage override feature, the low voltage override value.
 *        If the voltage is below this value, the shunt impedance will be turned on regardless of the other local controller settings.
 * @param maxSwitchOperationCount IdmsShuntImpedanceData.maxNumSwitchOps.
 * @param normalOpen True if open is normal status for a fixed capacitor bank, otherwise normal status is closed.
 * @param regBranch For VAR, amp, or power factor locally controlled shunt impedances, the index of the regulation branch.
 * @param regBranchEnd For VAR, amp, or power factor locally controlled shunt impedances, the end of the branch that is regulated.
 *        The field has the following values: from side, to side, and tertiary (only if the branch is a transformer).
 * @param regBranchKind (For VAR, amp, or power factor locally controlled shunt impedances) Kind of regulation branch.
 * @param sensingPhaseCode Phases that are measured for controlling the device.
 * @param switchOperationCycle Time interval between consecutive switching operations.
 * @param vRegLineLine True if regulated voltages are measured line to line, otherwise they are measured line to ground.
 * @param ShuntCompensatorInfo
 */
case class ShuntCompensatorControl
(
    override val sup: RegulatingControl,
    val branchDirect: Int,
    val cellSize: Double,
    val controlKind: String,
    val highVoltageOverride: Double,
    val localControlKind: String,
    val localOffLevel: String,
    val localOnLevel: String,
    val localOverride: Boolean,
    val lowVoltageOverride: Double,
    val maxSwitchOperationCount: Int,
    val normalOpen: Boolean,
    val regBranch: String,
    val regBranchEnd: Int,
    val regBranchKind: String,
    val sensingPhaseCode: String,
    val switchOperationCycle: Double,
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
    val branchDirect = parse_element (element ("""ShuntCompensatorControl.branchDirect"""))
    val cellSize = parse_element (element ("""ShuntCompensatorControl.cellSize"""))
    val controlKind = parse_attribute (attribute ("""ShuntCompensatorControl.controlKind"""))
    val highVoltageOverride = parse_element (element ("""ShuntCompensatorControl.highVoltageOverride"""))
    val localControlKind = parse_attribute (attribute ("""ShuntCompensatorControl.localControlKind"""))
    val localOffLevel = parse_element (element ("""ShuntCompensatorControl.localOffLevel"""))
    val localOnLevel = parse_element (element ("""ShuntCompensatorControl.localOnLevel"""))
    val localOverride = parse_element (element ("""ShuntCompensatorControl.localOverride"""))
    val lowVoltageOverride = parse_element (element ("""ShuntCompensatorControl.lowVoltageOverride"""))
    val maxSwitchOperationCount = parse_element (element ("""ShuntCompensatorControl.maxSwitchOperationCount"""))
    val normalOpen = parse_element (element ("""ShuntCompensatorControl.normalOpen"""))
    val regBranch = parse_element (element ("""ShuntCompensatorControl.regBranch"""))
    val regBranchEnd = parse_element (element ("""ShuntCompensatorControl.regBranchEnd"""))
    val regBranchKind = parse_attribute (attribute ("""ShuntCompensatorControl.regBranchKind"""))
    val sensingPhaseCode = parse_attribute (attribute ("""ShuntCompensatorControl.sensingPhaseCode"""))
    val switchOperationCycle = parse_element (element ("""ShuntCompensatorControl.switchOperationCycle"""))
    val vRegLineLine = parse_element (element ("""ShuntCompensatorControl.vRegLineLine"""))
    val ShuntCompensatorInfo = parse_attribute (attribute ("""ShuntCompensatorControl.ShuntCompensatorInfo"""))
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