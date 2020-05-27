package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * SVC asset allows the capacitive and inductive ratings for each phase to be specified individually if required.
 *
 * @param ShuntCompensator [[ch.ninecode.model.ShuntCompensator ShuntCompensator]] Reference to the superclass object.
 * @param capacitiveRating Maximum capacitive reactive power.
 * @param inductiveRating Maximum inductive reactive power.
 * @group InfWiresExt
 * @groupname InfWiresExt Package InfWiresExt
 */
final case class SVC
(
    ShuntCompensator: ShuntCompensator = null,
    capacitiveRating: Double = 0.0,
    inductiveRating: Double = 0.0
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
    override def sup: ShuntCompensator = ShuntCompensator

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
        implicit val clz: String = SVC.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SVC.fields (position), value)
        emitelem (0, capacitiveRating)
        emitelem (1, inductiveRating)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SVC rdf:ID=\"%s\">\n%s\t</cim:SVC>".format (id, export_fields)
    }
}

object SVC
extends
    Parseable[SVC]
{
    override val fields: Array[String] = Array[String] (
        "capacitiveRating",
        "inductiveRating"
    )
    val capacitiveRating: Fielder = parse_element (element (cls, fields(0)))
    val inductiveRating: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: Context): SVC =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SVC (
            ShuntCompensator.parse (context),
            toDouble (mask (capacitiveRating (), 0)),
            toDouble (mask (inductiveRating (), 1))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Distribution capacitor bank control settings.
 *
 * @param RegulatingControl [[ch.ninecode.model.RegulatingControl RegulatingControl]] Reference to the superclass object.
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
final case class ShuntCompensatorControl
(
    RegulatingControl: RegulatingControl = null,
    branchDirect: Int = 0,
    cellSize: Double = 0.0,
    controlKind: String = null,
    highVoltageOverride: Double = 0.0,
    localControlKind: String = null,
    localOffLevel: String = null,
    localOnLevel: String = null,
    localOverride: Boolean = false,
    lowVoltageOverride: Double = 0.0,
    maxSwitchOperationCount: Int = 0,
    normalOpen: Boolean = false,
    regBranch: String = null,
    regBranchEnd: Int = 0,
    regBranchKind: String = null,
    sensingPhaseCode: String = null,
    switchOperationCycle: Double = 0.0,
    vRegLineLine: Boolean = false,
    ShuntCompensatorInfo: String = null
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
    override def sup: RegulatingControl = RegulatingControl

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
        implicit val clz: String = ShuntCompensatorControl.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ShuntCompensatorControl.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ShuntCompensatorControl.fields (position), value)
        emitelem (0, branchDirect)
        emitelem (1, cellSize)
        emitattr (2, controlKind)
        emitelem (3, highVoltageOverride)
        emitattr (4, localControlKind)
        emitelem (5, localOffLevel)
        emitelem (6, localOnLevel)
        emitelem (7, localOverride)
        emitelem (8, lowVoltageOverride)
        emitelem (9, maxSwitchOperationCount)
        emitelem (10, normalOpen)
        emitelem (11, regBranch)
        emitelem (12, regBranchEnd)
        emitattr (13, regBranchKind)
        emitattr (14, sensingPhaseCode)
        emitelem (15, switchOperationCycle)
        emitelem (16, vRegLineLine)
        emitattr (17, ShuntCompensatorInfo)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ShuntCompensatorControl rdf:ID=\"%s\">\n%s\t</cim:ShuntCompensatorControl>".format (id, export_fields)
    }
}

object ShuntCompensatorControl
extends
    Parseable[ShuntCompensatorControl]
{
    override val fields: Array[String] = Array[String] (
        "branchDirect",
        "cellSize",
        "controlKind",
        "highVoltageOverride",
        "localControlKind",
        "localOffLevel",
        "localOnLevel",
        "localOverride",
        "lowVoltageOverride",
        "maxSwitchOperationCount",
        "normalOpen",
        "regBranch",
        "regBranchEnd",
        "regBranchKind",
        "sensingPhaseCode",
        "switchOperationCycle",
        "vRegLineLine",
        "ShuntCompensatorInfo"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ShuntCompensatorInfo", "ShuntCompensatorInfo", "0..1", "0..1")
    )
    val branchDirect: Fielder = parse_element (element (cls, fields(0)))
    val cellSize: Fielder = parse_element (element (cls, fields(1)))
    val controlKind: Fielder = parse_attribute (attribute (cls, fields(2)))
    val highVoltageOverride: Fielder = parse_element (element (cls, fields(3)))
    val localControlKind: Fielder = parse_attribute (attribute (cls, fields(4)))
    val localOffLevel: Fielder = parse_element (element (cls, fields(5)))
    val localOnLevel: Fielder = parse_element (element (cls, fields(6)))
    val localOverride: Fielder = parse_element (element (cls, fields(7)))
    val lowVoltageOverride: Fielder = parse_element (element (cls, fields(8)))
    val maxSwitchOperationCount: Fielder = parse_element (element (cls, fields(9)))
    val normalOpen: Fielder = parse_element (element (cls, fields(10)))
    val regBranch: Fielder = parse_element (element (cls, fields(11)))
    val regBranchEnd: Fielder = parse_element (element (cls, fields(12)))
    val regBranchKind: Fielder = parse_attribute (attribute (cls, fields(13)))
    val sensingPhaseCode: Fielder = parse_attribute (attribute (cls, fields(14)))
    val switchOperationCycle: Fielder = parse_element (element (cls, fields(15)))
    val vRegLineLine: Fielder = parse_element (element (cls, fields(16)))
    val ShuntCompensatorInfo: Fielder = parse_attribute (attribute (cls, fields(17)))

    def parse (context: Context): ShuntCompensatorControl =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ShuntCompensatorControl (
            RegulatingControl.parse (context),
            toInteger (mask (branchDirect (), 0)),
            toDouble (mask (cellSize (), 1)),
            mask (controlKind (), 2),
            toDouble (mask (highVoltageOverride (), 3)),
            mask (localControlKind (), 4),
            mask (localOffLevel (), 5),
            mask (localOnLevel (), 6),
            toBoolean (mask (localOverride (), 7)),
            toDouble (mask (lowVoltageOverride (), 8)),
            toInteger (mask (maxSwitchOperationCount (), 9)),
            toBoolean (mask (normalOpen (), 10)),
            mask (regBranch (), 11),
            toInteger (mask (regBranchEnd (), 12)),
            mask (regBranchKind (), 13),
            mask (sensingPhaseCode (), 14),
            toDouble (mask (switchOperationCycle (), 15)),
            toBoolean (mask (vRegLineLine (), 16)),
            mask (ShuntCompensatorInfo (), 17)
        )
        ret.bitfields = bitfields
        ret
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