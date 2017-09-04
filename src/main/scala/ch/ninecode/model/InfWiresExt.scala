package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * SVC asset allows the capacitive and inductive ratings for each phase to be specified individually if required.
 *
 * @param sup [[ch.ninecode.model.ShuntCompensator ShuntCompensator]] Reference to the superclass object.
 * @param capacitiveRating Maximum capacitive reactive power.
 * @param inductiveRating Maximum inductive reactive power.
 * @group InfWiresExt
 * @groupname InfWiresExt Package InfWiresExt
 */
case class SVC
(
    override val sup: ShuntCompensator,
    capacitiveRating: Double,
    inductiveRating: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ShuntCompensator: ShuntCompensator = sup.asInstanceOf[ShuntCompensator]
    override def copy (): Row = { clone ().asInstanceOf[SVC] }
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
        "\t\t<cim:SVC.capacitiveRating>" + capacitiveRating + "</cim:SVC.capacitiveRating>\n" +
        "\t\t<cim:SVC.inductiveRating>" + inductiveRating + "</cim:SVC.inductiveRating>\n"
    }
    override def export: String =
    {
        "\t<cim:SVC rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SVC>"
    }
}

object SVC
extends
    Parseable[SVC]
{
    val capacitiveRating = parse_element (element ("""SVC.capacitiveRating"""))
    val inductiveRating = parse_element (element ("""SVC.inductiveRating"""))
    def parse (context: Context): SVC =
    {
        SVC(
            ShuntCompensator.parse (context),
            toDouble (capacitiveRating (context), context),
            toDouble (inductiveRating (context), context)
        )
    }
}

/**
 * Distribution capacitor bank control settings.
 *
 * @param sup [[ch.ninecode.model.RegulatingControl RegulatingControl]] Reference to the superclass object.
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
 * @param ShuntCompensatorInfo [[ch.ninecode.model.ShuntCompensatorInfo ShuntCompensatorInfo]] <em>undocumented</em>
 * @group InfWiresExt
 * @groupname InfWiresExt Package InfWiresExt
 */
case class ShuntCompensatorControl
(
    override val sup: RegulatingControl,
    branchDirect: Int,
    cellSize: Double,
    controlKind: String,
    highVoltageOverride: Double,
    localControlKind: String,
    localOffLevel: String,
    localOnLevel: String,
    localOverride: Boolean,
    lowVoltageOverride: Double,
    maxSwitchOperationCount: Int,
    normalOpen: Boolean,
    regBranch: String,
    regBranchEnd: Int,
    regBranchKind: String,
    sensingPhaseCode: String,
    switchOperationCycle: Double,
    vRegLineLine: Boolean,
    ShuntCompensatorInfo: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0, 0.0, null, 0.0, null, null, null, false, 0.0, 0, false, null, 0, null, null, 0.0, false, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def RegulatingControl: RegulatingControl = sup.asInstanceOf[RegulatingControl]
    override def copy (): Row = { clone ().asInstanceOf[ShuntCompensatorControl] }
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
        "\t\t<cim:ShuntCompensatorControl.branchDirect>" + branchDirect + "</cim:ShuntCompensatorControl.branchDirect>\n" +
        "\t\t<cim:ShuntCompensatorControl.cellSize>" + cellSize + "</cim:ShuntCompensatorControl.cellSize>\n" +
        (if (null != controlKind) "\t\t<cim:ShuntCompensatorControl.controlKind rdf:resource=\"#" + controlKind + "\"/>\n" else "") +
        "\t\t<cim:ShuntCompensatorControl.highVoltageOverride>" + highVoltageOverride + "</cim:ShuntCompensatorControl.highVoltageOverride>\n" +
        (if (null != localControlKind) "\t\t<cim:ShuntCompensatorControl.localControlKind rdf:resource=\"#" + localControlKind + "\"/>\n" else "") +
        (if (null != localOffLevel) "\t\t<cim:ShuntCompensatorControl.localOffLevel>" + localOffLevel + "</cim:ShuntCompensatorControl.localOffLevel>\n" else "") +
        (if (null != localOnLevel) "\t\t<cim:ShuntCompensatorControl.localOnLevel>" + localOnLevel + "</cim:ShuntCompensatorControl.localOnLevel>\n" else "") +
        "\t\t<cim:ShuntCompensatorControl.localOverride>" + localOverride + "</cim:ShuntCompensatorControl.localOverride>\n" +
        "\t\t<cim:ShuntCompensatorControl.lowVoltageOverride>" + lowVoltageOverride + "</cim:ShuntCompensatorControl.lowVoltageOverride>\n" +
        "\t\t<cim:ShuntCompensatorControl.maxSwitchOperationCount>" + maxSwitchOperationCount + "</cim:ShuntCompensatorControl.maxSwitchOperationCount>\n" +
        "\t\t<cim:ShuntCompensatorControl.normalOpen>" + normalOpen + "</cim:ShuntCompensatorControl.normalOpen>\n" +
        (if (null != regBranch) "\t\t<cim:ShuntCompensatorControl.regBranch>" + regBranch + "</cim:ShuntCompensatorControl.regBranch>\n" else "") +
        "\t\t<cim:ShuntCompensatorControl.regBranchEnd>" + regBranchEnd + "</cim:ShuntCompensatorControl.regBranchEnd>\n" +
        (if (null != regBranchKind) "\t\t<cim:ShuntCompensatorControl.regBranchKind rdf:resource=\"#" + regBranchKind + "\"/>\n" else "") +
        (if (null != sensingPhaseCode) "\t\t<cim:ShuntCompensatorControl.sensingPhaseCode rdf:resource=\"#" + sensingPhaseCode + "\"/>\n" else "") +
        "\t\t<cim:ShuntCompensatorControl.switchOperationCycle>" + switchOperationCycle + "</cim:ShuntCompensatorControl.switchOperationCycle>\n" +
        "\t\t<cim:ShuntCompensatorControl.vRegLineLine>" + vRegLineLine + "</cim:ShuntCompensatorControl.vRegLineLine>\n" +
        (if (null != ShuntCompensatorInfo) "\t\t<cim:ShuntCompensatorControl.ShuntCompensatorInfo rdf:resource=\"#" + ShuntCompensatorInfo + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ShuntCompensatorControl rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ShuntCompensatorControl>"
    }
}

object ShuntCompensatorControl
extends
    Parseable[ShuntCompensatorControl]
{
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
            RegulatingControl.parse (context),
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

private[ninecode] object _InfWiresExt
{
    def register: List[ClassInfo] =
    {
        List (
            SVC.register,
            ShuntCompensatorControl.register
        )
    }
}