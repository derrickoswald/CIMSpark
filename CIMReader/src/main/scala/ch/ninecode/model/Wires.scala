package ch.ninecode.model

import com.esotericsoftware.kryo.Kryo
import com.esotericsoftware.kryo.io.Input
import com.esotericsoftware.kryo.io.Output
import org.apache.spark.sql.Row

import ch.ninecode.cim.CIMClassInfo
import ch.ninecode.cim.CIMContext
import ch.ninecode.cim.CIMParseable
import ch.ninecode.cim.CIMRelationship
import ch.ninecode.cim.CIMSerializer

/**
 * A wire or combination of wires, with consistent electrical characteristics, building a single electrical system, used to carry alternating current between points in the power system.
 *
 * For symmetrical, transposed three phase lines, it is sufficient to use attributes of the line segment, which describe impedances and admittances for the entire length of the segment.  Additionally impedances can be computed by using length and associated per length impedances.
 * The BaseVoltage at the two ends of ACLineSegments in a Line shall have the same BaseVoltage.nominalVoltage. However, boundary lines may have slightly different BaseVoltage.nominalVoltages and variation is allowed. Larger voltage difference in general requires use of an equivalent branch.
 *
 * @param Conductor [[ch.ninecode.model.Conductor Conductor]] Reference to the superclass object.
 * @param b0ch Zero sequence shunt (charging) susceptance, uniformly distributed, of the entire line section.
 * @param bch Positive sequence shunt (charging) susceptance, uniformly distributed, of the entire line section.
 *        This value represents the full charging over the full length of the line.
 * @param g0ch Zero sequence shunt (charging) conductance, uniformly distributed, of the entire line section.
 * @param gch Positive sequence shunt (charging) conductance, uniformly distributed, of the entire line section.
 * @param r Positive sequence series resistance of the entire line section.
 * @param r0 Zero sequence series resistance of the entire line section.
 * @param shortCircuitEndTemperature Maximum permitted temperature at the end of SC for the calculation of minimum short-circuit currents.
 *        Used for short circuit data exchange according to IEC 60909.
 * @param x Positive sequence series reactance of the entire line section.
 * @param x0 Zero sequence series reactance of the entire line section.
 * @param ACLineSegmentPhases [[ch.ninecode.model.ACLineSegmentPhase ACLineSegmentPhase]] The line segment phases which belong to the line segment.
 * @param Clamp [[ch.ninecode.model.Clamp Clamp]] The clamps connected to the line segment.
 * @param Cut [[ch.ninecode.model.Cut Cut]] Cuts applied to the line segment.
 * @param LineFaults [[ch.ninecode.model.LineFault LineFault]] The line faults of the line segment.
 * @param LineGroundingAction [[ch.ninecode.model.GroundAction GroundAction]] Ground action involving clamp usage (for the case when the ground is applied along the line segment instead of at its terminals).
 * @param LineJumpingAction [[ch.ninecode.model.JumperAction JumperAction]] Jumper action involving clamp usage (for the case when the jumper is applied along the line segment instead of at its terminals).
 * @param PerLengthImpedance [[ch.ninecode.model.PerLengthImpedance PerLengthImpedance]] Per-length impedance of this line segment.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class ACLineSegment
(
    Conductor: Conductor = null,
    b0ch: Double = 0.0,
    bch: Double = 0.0,
    g0ch: Double = 0.0,
    gch: Double = 0.0,
    r: Double = 0.0,
    r0: Double = 0.0,
    shortCircuitEndTemperature: Double = 0.0,
    x: Double = 0.0,
    x0: Double = 0.0,
    ACLineSegmentPhases: List[String] = null,
    Clamp: List[String] = null,
    Cut: List[String] = null,
    LineFaults: List[String] = null,
    LineGroundingAction: String = null,
    LineJumpingAction: String = null,
    PerLengthImpedance: String = null
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
    override def sup: Conductor = Conductor

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
        implicit val clz: String = ACLineSegment.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ACLineSegment.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ACLineSegment.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ACLineSegment.fields (position), x))
        emitelem (0, b0ch)
        emitelem (1, bch)
        emitelem (2, g0ch)
        emitelem (3, gch)
        emitelem (4, r)
        emitelem (5, r0)
        emitelem (6, shortCircuitEndTemperature)
        emitelem (7, x)
        emitelem (8, x0)
        emitattrs (9, ACLineSegmentPhases)
        emitattrs (10, Clamp)
        emitattrs (11, Cut)
        emitattrs (12, LineFaults)
        emitattr (13, LineGroundingAction)
        emitattr (14, LineJumpingAction)
        emitattr (15, PerLengthImpedance)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ACLineSegment rdf:ID=\"%s\">\n%s\t</cim:ACLineSegment>".format (id, export_fields)
    }
}

object ACLineSegment
extends
    CIMParseable[ACLineSegment]
{
    override val fields: Array[String] = Array[String] (
        "b0ch",
        "bch",
        "g0ch",
        "gch",
        "r",
        "r0",
        "shortCircuitEndTemperature",
        "x",
        "x0",
        "ACLineSegmentPhases",
        "Clamp",
        "Cut",
        "LineFaults",
        "LineGroundingAction",
        "LineJumpingAction",
        "PerLengthImpedance"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ACLineSegmentPhases", "ACLineSegmentPhase", "0..*", "1"),
        CIMRelationship ("Clamp", "Clamp", "0..*", "1"),
        CIMRelationship ("Cut", "Cut", "0..*", "1"),
        CIMRelationship ("LineFaults", "LineFault", "0..*", "0..1"),
        CIMRelationship ("LineGroundingAction", "GroundAction", "0..1", "0..1"),
        CIMRelationship ("LineJumpingAction", "JumperAction", "0..1", "0..*"),
        CIMRelationship ("PerLengthImpedance", "PerLengthImpedance", "0..1", "0..*")
    )
    val b0ch: Fielder = parse_element (element (cls, fields(0)))
    val bch: Fielder = parse_element (element (cls, fields(1)))
    val g0ch: Fielder = parse_element (element (cls, fields(2)))
    val gch: Fielder = parse_element (element (cls, fields(3)))
    val r: Fielder = parse_element (element (cls, fields(4)))
    val r0: Fielder = parse_element (element (cls, fields(5)))
    val shortCircuitEndTemperature: Fielder = parse_element (element (cls, fields(6)))
    val x: Fielder = parse_element (element (cls, fields(7)))
    val x0: Fielder = parse_element (element (cls, fields(8)))
    val ACLineSegmentPhases: FielderMultiple = parse_attributes (attribute (cls, fields(9)))
    val Clamp: FielderMultiple = parse_attributes (attribute (cls, fields(10)))
    val Cut: FielderMultiple = parse_attributes (attribute (cls, fields(11)))
    val LineFaults: FielderMultiple = parse_attributes (attribute (cls, fields(12)))
    val LineGroundingAction: Fielder = parse_attribute (attribute (cls, fields(13)))
    val LineJumpingAction: Fielder = parse_attribute (attribute (cls, fields(14)))
    val PerLengthImpedance: Fielder = parse_attribute (attribute (cls, fields(15)))

    def parse (context: CIMContext): ACLineSegment =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ACLineSegment (
            Conductor.parse (context),
            toDouble (mask (b0ch (), 0)),
            toDouble (mask (bch (), 1)),
            toDouble (mask (g0ch (), 2)),
            toDouble (mask (gch (), 3)),
            toDouble (mask (r (), 4)),
            toDouble (mask (r0 (), 5)),
            toDouble (mask (shortCircuitEndTemperature (), 6)),
            toDouble (mask (x (), 7)),
            toDouble (mask (x0 (), 8)),
            masks (ACLineSegmentPhases (), 9),
            masks (Clamp (), 10),
            masks (Cut (), 11),
            masks (LineFaults (), 12),
            mask (LineGroundingAction (), 13),
            mask (LineJumpingAction (), 14),
            mask (PerLengthImpedance (), 15)
        )
        ret.bitfields = bitfields
        ret
    }
}

object ACLineSegmentSerializer extends CIMSerializer[ACLineSegment]
{
    def write (kryo: Kryo, output: Output, obj: ACLineSegment): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.b0ch),
            () => output.writeDouble (obj.bch),
            () => output.writeDouble (obj.g0ch),
            () => output.writeDouble (obj.gch),
            () => output.writeDouble (obj.r),
            () => output.writeDouble (obj.r0),
            () => output.writeDouble (obj.shortCircuitEndTemperature),
            () => output.writeDouble (obj.x),
            () => output.writeDouble (obj.x0),
            () => writeList (obj.ACLineSegmentPhases, output),
            () => writeList (obj.Clamp, output),
            () => writeList (obj.Cut, output),
            () => writeList (obj.LineFaults, output),
            () => output.writeString (obj.LineGroundingAction),
            () => output.writeString (obj.LineJumpingAction),
            () => output.writeString (obj.PerLengthImpedance)
        )
        ConductorSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ACLineSegment]): ACLineSegment =
    {
        val parent = ConductorSerializer.read (kryo, input, classOf[Conductor])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ACLineSegment (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readDouble else 0.0,
            if (isSet (6)) input.readDouble else 0.0,
            if (isSet (7)) input.readDouble else 0.0,
            if (isSet (8)) input.readDouble else 0.0,
            if (isSet (9)) readList (input) else null,
            if (isSet (10)) readList (input) else null,
            if (isSet (11)) readList (input) else null,
            if (isSet (12)) readList (input) else null,
            if (isSet (13)) input.readString else null,
            if (isSet (14)) input.readString else null,
            if (isSet (15)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Represents a single wire of an alternating current line segment.
 *
 * @param PowerSystemResource [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param phase The phase connection of the wire at both ends.
 * @param sequenceNumber Number designation for this line segment phase.
 *        Each line segment phase within a line segment should have a unique sequence number. This is useful for unbalanced modelling to bind the mathematical model (PhaseImpedanceData of PerLengthPhaseImpedance) with the connectivity model (this class) and the physical model (WirePosition) without tight coupling.
 * @param ACLineSegment [[ch.ninecode.model.ACLineSegment ACLineSegment]] The line segment to which the phase belongs.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class ACLineSegmentPhase
(
    PowerSystemResource: PowerSystemResource = null,
    phase: String = null,
    sequenceNumber: Int = 0,
    ACLineSegment: String = null
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
        implicit val clz: String = ACLineSegmentPhase.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ACLineSegmentPhase.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ACLineSegmentPhase.fields (position), value)
        emitattr (0, phase)
        emitelem (1, sequenceNumber)
        emitattr (2, ACLineSegment)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ACLineSegmentPhase rdf:ID=\"%s\">\n%s\t</cim:ACLineSegmentPhase>".format (id, export_fields)
    }
}

object ACLineSegmentPhase
extends
    CIMParseable[ACLineSegmentPhase]
{
    override val fields: Array[String] = Array[String] (
        "phase",
        "sequenceNumber",
        "ACLineSegment"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ACLineSegment", "ACLineSegment", "1", "0..*")
    )
    val phase: Fielder = parse_attribute (attribute (cls, fields(0)))
    val sequenceNumber: Fielder = parse_element (element (cls, fields(1)))
    val ACLineSegment: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: CIMContext): ACLineSegmentPhase =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ACLineSegmentPhase (
            PowerSystemResource.parse (context),
            mask (phase (), 0),
            toInteger (mask (sequenceNumber (), 1)),
            mask (ACLineSegment (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

object ACLineSegmentPhaseSerializer extends CIMSerializer[ACLineSegmentPhase]
{
    def write (kryo: Kryo, output: Output, obj: ACLineSegmentPhase): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.phase),
            () => output.writeInt (obj.sequenceNumber),
            () => output.writeString (obj.ACLineSegment)
        )
        PowerSystemResourceSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ACLineSegmentPhase]): ACLineSegmentPhase =
    {
        val parent = PowerSystemResourceSerializer.read (kryo, input, classOf[PowerSystemResource])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ACLineSegmentPhase (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readInt else 0,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A rotating machine whose shaft rotates asynchronously with the electrical field.
 *
 * Also known as an induction machine with no external connection to the rotor windings, e.g. squirrel-cage induction machine.
 *
 * @param RotatingMachine [[ch.ninecode.model.RotatingMachine RotatingMachine]] Reference to the superclass object.
 * @param asynchronousMachineType Indicates the type of Asynchronous Machine (motor or generator).
 * @param converterFedDrive Indicates whether the machine is a converter fed drive.
 *        Used for short circuit data exchange according to IEC 60909.
 * @param efficiency Efficiency of the asynchronous machine at nominal operation as a percentage.
 *        Indicator for converter drive motors. Used for short circuit data exchange according to IEC 60909.
 * @param iaIrRatio Ratio of locked-rotor current to the rated current of the motor (Ia/Ir).
 *        Used for short circuit data exchange according to IEC 60909.
 * @param nominalFrequency Nameplate data indicates if the machine is 50 Hz or 60 Hz.
 * @param nominalSpeed Nameplate data.
 *        Depends on the slip and number of pole pairs.
 * @param polePairNumber Number of pole pairs of stator.
 *        Used for short circuit data exchange according to IEC 60909.
 * @param ratedMechanicalPower Rated mechanical power (Pr in IEC 60909-0).
 *        Used for short circuit data exchange according to IEC 60909.
 * @param reversible Indicates for converter drive motors if the power can be reversible.
 *        Used for short circuit data exchange according to IEC 60909.
 * @param rr1 Damper 1 winding resistance.
 * @param rr2 Damper 2 winding resistance.
 * @param rxLockedRotorRatio Locked rotor ratio (R/X).
 *        Used for short circuit data exchange according to IEC 60909.
 * @param tpo Transient rotor time constant (greater than tppo).
 * @param tppo Sub-transient rotor time constant (greater than 0).
 * @param xlr1 Damper 1 winding leakage reactance.
 * @param xlr2 Damper 2 winding leakage reactance.
 * @param xm Magnetizing reactance.
 * @param xp Transient reactance (unsaturated) (greater than or equal to xpp).
 * @param xpp Sub-transient reactance (unsaturated).
 * @param xs Synchronous reactance (greater than xp).
 * @param AsynchronousMachineDynamics [[ch.ninecode.model.AsynchronousMachineDynamics AsynchronousMachineDynamics]] Asynchronous machine dynamics model used to describe dynamic behaviour of this asynchronous machine.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class AsynchronousMachine
(
    RotatingMachine: RotatingMachine = null,
    asynchronousMachineType: String = null,
    converterFedDrive: Boolean = false,
    efficiency: Double = 0.0,
    iaIrRatio: Double = 0.0,
    nominalFrequency: Double = 0.0,
    nominalSpeed: Double = 0.0,
    polePairNumber: Int = 0,
    ratedMechanicalPower: Double = 0.0,
    reversible: Boolean = false,
    rr1: Double = 0.0,
    rr2: Double = 0.0,
    rxLockedRotorRatio: Double = 0.0,
    tpo: Double = 0.0,
    tppo: Double = 0.0,
    xlr1: Double = 0.0,
    xlr2: Double = 0.0,
    xm: Double = 0.0,
    xp: Double = 0.0,
    xpp: Double = 0.0,
    xs: Double = 0.0,
    AsynchronousMachineDynamics: String = null
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
    override def sup: RotatingMachine = RotatingMachine

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
        implicit val clz: String = AsynchronousMachine.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AsynchronousMachine.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AsynchronousMachine.fields (position), value)
        emitattr (0, asynchronousMachineType)
        emitelem (1, converterFedDrive)
        emitelem (2, efficiency)
        emitelem (3, iaIrRatio)
        emitelem (4, nominalFrequency)
        emitelem (5, nominalSpeed)
        emitelem (6, polePairNumber)
        emitelem (7, ratedMechanicalPower)
        emitelem (8, reversible)
        emitelem (9, rr1)
        emitelem (10, rr2)
        emitelem (11, rxLockedRotorRatio)
        emitelem (12, tpo)
        emitelem (13, tppo)
        emitelem (14, xlr1)
        emitelem (15, xlr2)
        emitelem (16, xm)
        emitelem (17, xp)
        emitelem (18, xpp)
        emitelem (19, xs)
        emitattr (20, AsynchronousMachineDynamics)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AsynchronousMachine rdf:ID=\"%s\">\n%s\t</cim:AsynchronousMachine>".format (id, export_fields)
    }
}

object AsynchronousMachine
extends
    CIMParseable[AsynchronousMachine]
{
    override val fields: Array[String] = Array[String] (
        "asynchronousMachineType",
        "converterFedDrive",
        "efficiency",
        "iaIrRatio",
        "nominalFrequency",
        "nominalSpeed",
        "polePairNumber",
        "ratedMechanicalPower",
        "reversible",
        "rr1",
        "rr2",
        "rxLockedRotorRatio",
        "tpo",
        "tppo",
        "xlr1",
        "xlr2",
        "xm",
        "xp",
        "xpp",
        "xs",
        "AsynchronousMachineDynamics"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AsynchronousMachineDynamics", "AsynchronousMachineDynamics", "0..1", "1")
    )
    val asynchronousMachineType: Fielder = parse_attribute (attribute (cls, fields(0)))
    val converterFedDrive: Fielder = parse_element (element (cls, fields(1)))
    val efficiency: Fielder = parse_element (element (cls, fields(2)))
    val iaIrRatio: Fielder = parse_element (element (cls, fields(3)))
    val nominalFrequency: Fielder = parse_element (element (cls, fields(4)))
    val nominalSpeed: Fielder = parse_element (element (cls, fields(5)))
    val polePairNumber: Fielder = parse_element (element (cls, fields(6)))
    val ratedMechanicalPower: Fielder = parse_element (element (cls, fields(7)))
    val reversible: Fielder = parse_element (element (cls, fields(8)))
    val rr1: Fielder = parse_element (element (cls, fields(9)))
    val rr2: Fielder = parse_element (element (cls, fields(10)))
    val rxLockedRotorRatio: Fielder = parse_element (element (cls, fields(11)))
    val tpo: Fielder = parse_element (element (cls, fields(12)))
    val tppo: Fielder = parse_element (element (cls, fields(13)))
    val xlr1: Fielder = parse_element (element (cls, fields(14)))
    val xlr2: Fielder = parse_element (element (cls, fields(15)))
    val xm: Fielder = parse_element (element (cls, fields(16)))
    val xp: Fielder = parse_element (element (cls, fields(17)))
    val xpp: Fielder = parse_element (element (cls, fields(18)))
    val xs: Fielder = parse_element (element (cls, fields(19)))
    val AsynchronousMachineDynamics: Fielder = parse_attribute (attribute (cls, fields(20)))

    def parse (context: CIMContext): AsynchronousMachine =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AsynchronousMachine (
            RotatingMachine.parse (context),
            mask (asynchronousMachineType (), 0),
            toBoolean (mask (converterFedDrive (), 1)),
            toDouble (mask (efficiency (), 2)),
            toDouble (mask (iaIrRatio (), 3)),
            toDouble (mask (nominalFrequency (), 4)),
            toDouble (mask (nominalSpeed (), 5)),
            toInteger (mask (polePairNumber (), 6)),
            toDouble (mask (ratedMechanicalPower (), 7)),
            toBoolean (mask (reversible (), 8)),
            toDouble (mask (rr1 (), 9)),
            toDouble (mask (rr2 (), 10)),
            toDouble (mask (rxLockedRotorRatio (), 11)),
            toDouble (mask (tpo (), 12)),
            toDouble (mask (tppo (), 13)),
            toDouble (mask (xlr1 (), 14)),
            toDouble (mask (xlr2 (), 15)),
            toDouble (mask (xm (), 16)),
            toDouble (mask (xp (), 17)),
            toDouble (mask (xpp (), 18)),
            toDouble (mask (xs (), 19)),
            mask (AsynchronousMachineDynamics (), 20)
        )
        ret.bitfields = bitfields
        ret
    }
}

object AsynchronousMachineSerializer extends CIMSerializer[AsynchronousMachine]
{
    def write (kryo: Kryo, output: Output, obj: AsynchronousMachine): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.asynchronousMachineType),
            () => output.writeBoolean (obj.converterFedDrive),
            () => output.writeDouble (obj.efficiency),
            () => output.writeDouble (obj.iaIrRatio),
            () => output.writeDouble (obj.nominalFrequency),
            () => output.writeDouble (obj.nominalSpeed),
            () => output.writeInt (obj.polePairNumber),
            () => output.writeDouble (obj.ratedMechanicalPower),
            () => output.writeBoolean (obj.reversible),
            () => output.writeDouble (obj.rr1),
            () => output.writeDouble (obj.rr2),
            () => output.writeDouble (obj.rxLockedRotorRatio),
            () => output.writeDouble (obj.tpo),
            () => output.writeDouble (obj.tppo),
            () => output.writeDouble (obj.xlr1),
            () => output.writeDouble (obj.xlr2),
            () => output.writeDouble (obj.xm),
            () => output.writeDouble (obj.xp),
            () => output.writeDouble (obj.xpp),
            () => output.writeDouble (obj.xs),
            () => output.writeString (obj.AsynchronousMachineDynamics)
        )
        RotatingMachineSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AsynchronousMachine]): AsynchronousMachine =
    {
        val parent = RotatingMachineSerializer.read (kryo, input, classOf[RotatingMachine])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = AsynchronousMachine (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readBoolean else false,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readDouble else 0.0,
            if (isSet (6)) input.readInt else 0,
            if (isSet (7)) input.readDouble else 0.0,
            if (isSet (8)) input.readBoolean else false,
            if (isSet (9)) input.readDouble else 0.0,
            if (isSet (10)) input.readDouble else 0.0,
            if (isSet (11)) input.readDouble else 0.0,
            if (isSet (12)) input.readDouble else 0.0,
            if (isSet (13)) input.readDouble else 0.0,
            if (isSet (14)) input.readDouble else 0.0,
            if (isSet (15)) input.readDouble else 0.0,
            if (isSet (16)) input.readDouble else 0.0,
            if (isSet (17)) input.readDouble else 0.0,
            if (isSet (18)) input.readDouble else 0.0,
            if (isSet (19)) input.readDouble else 0.0,
            if (isSet (20)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A mechanical switching device capable of making, carrying, and breaking currents under normal circuit conditions and also making, carrying for a specified time, and breaking currents under specified abnormal circuit conditions e.g.  those of short circuit.
 *
 * @param ProtectedSwitch [[ch.ninecode.model.ProtectedSwitch ProtectedSwitch]] Reference to the superclass object.
 * @param inTransitTime The transition time from open to close.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class Breaker
(
    ProtectedSwitch: ProtectedSwitch = null,
    inTransitTime: Double = 0.0
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
    override def sup: ProtectedSwitch = ProtectedSwitch

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
        implicit val clz: String = Breaker.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Breaker.fields (position), value)
        emitelem (0, inTransitTime)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Breaker rdf:ID=\"%s\">\n%s\t</cim:Breaker>".format (id, export_fields)
    }
}

object Breaker
extends
    CIMParseable[Breaker]
{
    override val fields: Array[String] = Array[String] (
        "inTransitTime"
    )
    val inTransitTime: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: CIMContext): Breaker =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Breaker (
            ProtectedSwitch.parse (context),
            toDouble (mask (inTransitTime (), 0))
        )
        ret.bitfields = bitfields
        ret
    }
}

object BreakerSerializer extends CIMSerializer[Breaker]
{
    def write (kryo: Kryo, output: Output, obj: Breaker): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.inTransitTime)
        )
        ProtectedSwitchSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Breaker]): Breaker =
    {
        val parent = ProtectedSwitchSerializer.read (kryo, input, classOf[ProtectedSwitch])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Breaker (
            parent,
            if (isSet (0)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A conductor, or group of conductors, with negligible impedance, that serve to connect other conducting equipment within a single substation.
 *
 * Voltage measurements are typically obtained from voltage transformers that are connected to busbar sections. A bus bar section may have many physical terminals but for analysis is modelled with exactly one logical terminal.
 *
 * @param Connector [[ch.ninecode.model.Connector Connector]] Reference to the superclass object.
 * @param ipMax Maximum allowable peak short-circuit current of busbar (Ipmax in IEC 60909-0).
 *        Mechanical limit of the busbar in the substation itself. Used for short circuit data exchange according to IEC 60909.
 * @param VoltageControlZone [[ch.ninecode.model.VoltageControlZone VoltageControlZone]] A VoltageControlZone is controlled by a designated BusbarSection.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class BusbarSection
(
    Connector: Connector = null,
    ipMax: Double = 0.0,
    VoltageControlZone: String = null
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
    override def sup: Connector = Connector

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
        implicit val clz: String = BusbarSection.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (BusbarSection.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (BusbarSection.fields (position), value)
        emitelem (0, ipMax)
        emitattr (1, VoltageControlZone)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:BusbarSection rdf:ID=\"%s\">\n%s\t</cim:BusbarSection>".format (id, export_fields)
    }
}

object BusbarSection
extends
    CIMParseable[BusbarSection]
{
    override val fields: Array[String] = Array[String] (
        "ipMax",
        "VoltageControlZone"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("VoltageControlZone", "VoltageControlZone", "0..1", "1")
    )
    val ipMax: Fielder = parse_element (element (cls, fields(0)))
    val VoltageControlZone: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): BusbarSection =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = BusbarSection (
            Connector.parse (context),
            toDouble (mask (ipMax (), 0)),
            mask (VoltageControlZone (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

object BusbarSectionSerializer extends CIMSerializer[BusbarSection]
{
    def write (kryo: Kryo, output: Output, obj: BusbarSection): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.ipMax),
            () => output.writeString (obj.VoltageControlZone)
        )
        ConnectorSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[BusbarSection]): BusbarSection =
    {
        val parent = ConnectorSerializer.read (kryo, input, classOf[Connector])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = BusbarSection (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A Clamp is a galvanic connection at a line segment where other equipment is connected.
 *
 * A Clamp does not cut the line segment.
 * A Clamp is ConductingEquipment and has one Terminal with an associated ConnectivityNode. Any other ConductingEquipment can be connected to the Clamp ConnectivityNode.
 *
 * @param ConductingEquipment [[ch.ninecode.model.ConductingEquipment ConductingEquipment]] Reference to the superclass object.
 * @param lengthFromTerminal1 The length to the place where the clamp is located starting from side one of the line segment, i.e. the line segment terminal with sequence number equal to 1.
 * @param ACLineSegment [[ch.ninecode.model.ACLineSegment ACLineSegment]] The line segment to which the clamp is connected.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class Clamp
(
    ConductingEquipment: ConductingEquipment = null,
    lengthFromTerminal1: Double = 0.0,
    ACLineSegment: String = null
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
    override def sup: ConductingEquipment = ConductingEquipment

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
        implicit val clz: String = Clamp.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Clamp.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Clamp.fields (position), value)
        emitelem (0, lengthFromTerminal1)
        emitattr (1, ACLineSegment)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Clamp rdf:ID=\"%s\">\n%s\t</cim:Clamp>".format (id, export_fields)
    }
}

object Clamp
extends
    CIMParseable[Clamp]
{
    override val fields: Array[String] = Array[String] (
        "lengthFromTerminal1",
        "ACLineSegment"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ACLineSegment", "ACLineSegment", "1", "0..*")
    )
    val lengthFromTerminal1: Fielder = parse_element (element (cls, fields(0)))
    val ACLineSegment: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): Clamp =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Clamp (
            ConductingEquipment.parse (context),
            toDouble (mask (lengthFromTerminal1 (), 0)),
            mask (ACLineSegment (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

object ClampSerializer extends CIMSerializer[Clamp]
{
    def write (kryo: Kryo, output: Output, obj: Clamp): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.lengthFromTerminal1),
            () => output.writeString (obj.ACLineSegment)
        )
        ConductingEquipmentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Clamp]): Clamp =
    {
        val parent = ConductingEquipmentSerializer.read (kryo, input, classOf[ConductingEquipment])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Clamp (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A model of a set of individual Switches normally enclosed within the same cabinet and possibly with interlocks that restrict the combination of switch positions.
 *
 * These are typically found in medium voltage distribution networks.
 * A CompositeSwitch could represent a Ring-Main-Unit (RMU), or pad-mounted switchgear, with primitive internal devices such as an internal bus-bar plus 3 or 4 internal switches each of which may individually be open or closed. A CompositeSwitch and a set of contained Switches can also be used to represent a multi-position switch e.g. a switch that can connect a circuit to Ground, Open or Busbar.
 *
 * @param Equipment [[ch.ninecode.model.Equipment Equipment]] Reference to the superclass object.
 * @param compositeSwitchType An alphanumeric code that can be used as a reference to extra information such as the description of the interlocking scheme if any.
 * @param Switches [[ch.ninecode.model.Switch Switch]] Switches contained in this Composite switch.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class CompositeSwitch
(
    Equipment: Equipment = null,
    compositeSwitchType: String = null,
    Switches: List[String] = null
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
    override def sup: Equipment = Equipment

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
        implicit val clz: String = CompositeSwitch.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CompositeSwitch.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (CompositeSwitch.fields (position), x))
        emitelem (0, compositeSwitchType)
        emitattrs (1, Switches)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CompositeSwitch rdf:ID=\"%s\">\n%s\t</cim:CompositeSwitch>".format (id, export_fields)
    }
}

object CompositeSwitch
extends
    CIMParseable[CompositeSwitch]
{
    override val fields: Array[String] = Array[String] (
        "compositeSwitchType",
        "Switches"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Switches", "Switch", "0..*", "0..1")
    )
    val compositeSwitchType: Fielder = parse_element (element (cls, fields(0)))
    val Switches: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): CompositeSwitch =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CompositeSwitch (
            Equipment.parse (context),
            mask (compositeSwitchType (), 0),
            masks (Switches (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

object CompositeSwitchSerializer extends CIMSerializer[CompositeSwitch]
{
    def write (kryo: Kryo, output: Output, obj: CompositeSwitch): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.compositeSwitchType),
            () => writeList (obj.Switches, output)
        )
        EquipmentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CompositeSwitch]): CompositeSwitch =
    {
        val parent = EquipmentSerializer.read (kryo, input, classOf[Equipment])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = CompositeSwitch (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Combination of conducting material with consistent electrical characteristics, building a single electrical system, used to carry current between points in the power system.
 *
 * @param ConductingEquipment [[ch.ninecode.model.ConductingEquipment ConductingEquipment]] Reference to the superclass object.
 * @param len Segment length for calculating line section capabilities.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class Conductor
(
    ConductingEquipment: ConductingEquipment = null,
    len: Double = 0.0
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
    override def sup: ConductingEquipment = ConductingEquipment

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
        implicit val clz: String = Conductor.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Conductor.fields (position), value)
        emitelem (0, len)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Conductor rdf:ID=\"%s\">\n%s\t</cim:Conductor>".format (id, export_fields)
    }
}

object Conductor
extends
    CIMParseable[Conductor]
{
    override val fields: Array[String] = Array[String] (
        "length"
    )
    val len: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: CIMContext): Conductor =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Conductor (
            ConductingEquipment.parse (context),
            toDouble (mask (len (), 0))
        )
        ret.bitfields = bitfields
        ret
    }
}

object ConductorSerializer extends CIMSerializer[Conductor]
{
    def write (kryo: Kryo, output: Output, obj: Conductor): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.len)
        )
        ConductingEquipmentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Conductor]): Conductor =
    {
        val parent = ConductingEquipmentSerializer.read (kryo, input, classOf[ConductingEquipment])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Conductor (
            parent,
            if (isSet (0)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A conductor, or group of conductors, with negligible impedance, that serve to connect other conducting equipment within a single substation and are modelled with a single logical terminal.
 *
 * @param ConductingEquipment [[ch.ninecode.model.ConductingEquipment ConductingEquipment]] Reference to the superclass object.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class Connector
(
    ConductingEquipment: ConductingEquipment = null
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
    override def sup: ConductingEquipment = ConductingEquipment

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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:Connector rdf:ID=\"%s\">\n%s\t</cim:Connector>".format (id, export_fields)
    }
}

object Connector
extends
    CIMParseable[Connector]
{

    def parse (context: CIMContext): Connector =
    {
        val ret = Connector (
            ConductingEquipment.parse (context)
        )
        ret
    }
}

object ConnectorSerializer extends CIMSerializer[Connector]
{
    def write (kryo: Kryo, output: Output, obj: Connector): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        ConductingEquipmentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Connector]): Connector =
    {
        val parent = ConductingEquipmentSerializer.read (kryo, input, classOf[ConductingEquipment])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Connector (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A cut separates a line segment into two parts.
 *
 * The cut appears as a switch inserted between these two parts and connects them together. As the cut is normally open there is no galvanic connection between the two line segment parts. But it is possible to close the cut to get galvanic connection.
 * The cut terminals are oriented towards the line segment terminals with the same sequence number. Hence the cut terminal with sequence number equal to 1 is oriented to the line segment's terminal with sequence number equal to 1.
 * The cut terminals also act as connection points for jumpers and other equipment, e.g. a mobile generator. To enable this, connectivity nodes are placed at the cut terminals. Once the connectivity nodes are in place any conducting equipment can be connected at them.
 *
 * @param Switch [[ch.ninecode.model.Switch Switch]] Reference to the superclass object.
 * @param lengthFromTerminal1 The length to the place where the cut is located starting from side one of the cut line segment, i.e. the line segment Terminal with sequenceNumber equal to 1.
 * @param ACLineSegment [[ch.ninecode.model.ACLineSegment ACLineSegment]] The line segment to which the cut is applied.
 * @param CutAction [[ch.ninecode.model.CutAction CutAction]] Action taken with this cut.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class Cut
(
    Switch: Switch = null,
    lengthFromTerminal1: Double = 0.0,
    ACLineSegment: String = null,
    CutAction: String = null
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
    override def sup: Switch = Switch

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
        implicit val clz: String = Cut.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Cut.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Cut.fields (position), value)
        emitelem (0, lengthFromTerminal1)
        emitattr (1, ACLineSegment)
        emitattr (2, CutAction)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Cut rdf:ID=\"%s\">\n%s\t</cim:Cut>".format (id, export_fields)
    }
}

object Cut
extends
    CIMParseable[Cut]
{
    override val fields: Array[String] = Array[String] (
        "lengthFromTerminal1",
        "ACLineSegment",
        "CutAction"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ACLineSegment", "ACLineSegment", "1", "0..*"),
        CIMRelationship ("CutAction", "CutAction", "0..1", "0..1")
    )
    val lengthFromTerminal1: Fielder = parse_element (element (cls, fields(0)))
    val ACLineSegment: Fielder = parse_attribute (attribute (cls, fields(1)))
    val CutAction: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: CIMContext): Cut =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Cut (
            Switch.parse (context),
            toDouble (mask (lengthFromTerminal1 (), 0)),
            mask (ACLineSegment (), 1),
            mask (CutAction (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

object CutSerializer extends CIMSerializer[Cut]
{
    def write (kryo: Kryo, output: Output, obj: Cut): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.lengthFromTerminal1),
            () => output.writeString (obj.ACLineSegment),
            () => output.writeString (obj.CutAction)
        )
        SwitchSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Cut]): Cut =
    {
        val parent = SwitchSerializer.read (kryo, input, classOf[Switch])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Cut (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A manually operated or motor operated mechanical switching device used for changing the connections in a circuit, or for isolating a circuit or equipment from a source of power.
 *
 * It is required to open or close circuits when negligible current is broken or made.
 *
 * @param Switch [[ch.ninecode.model.Switch Switch]] Reference to the superclass object.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class Disconnector
(
    Switch: Switch = null
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
    override def sup: Switch = Switch

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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:Disconnector rdf:ID=\"%s\">\n%s\t</cim:Disconnector>".format (id, export_fields)
    }
}

object Disconnector
extends
    CIMParseable[Disconnector]
{

    def parse (context: CIMContext): Disconnector =
    {
        val ret = Disconnector (
            Switch.parse (context)
        )
        ret
    }
}

object DisconnectorSerializer extends CIMSerializer[Disconnector]
{
    def write (kryo: Kryo, output: Output, obj: Disconnector): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        SwitchSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Disconnector]): Disconnector =
    {
        val parent = SwitchSerializer.read (kryo, input, classOf[Switch])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Disconnector (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A conducting equipment used to represent a connection to ground which is typically used to compensate earth faults.
 *
 * An earth fault compensator device modelled with a single terminal implies a second terminal solidly connected to ground.  If two terminals are modelled, the ground is not assumed and normal connection rules apply.
 *
 * @param ConductingEquipment [[ch.ninecode.model.ConductingEquipment ConductingEquipment]] Reference to the superclass object.
 * @param r Nominal resistance of device.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class EarthFaultCompensator
(
    ConductingEquipment: ConductingEquipment = null,
    r: Double = 0.0
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
    override def sup: ConductingEquipment = ConductingEquipment

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
        implicit val clz: String = EarthFaultCompensator.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (EarthFaultCompensator.fields (position), value)
        emitelem (0, r)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EarthFaultCompensator rdf:ID=\"%s\">\n%s\t</cim:EarthFaultCompensator>".format (id, export_fields)
    }
}

object EarthFaultCompensator
extends
    CIMParseable[EarthFaultCompensator]
{
    override val fields: Array[String] = Array[String] (
        "r"
    )
    val r: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: CIMContext): EarthFaultCompensator =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EarthFaultCompensator (
            ConductingEquipment.parse (context),
            toDouble (mask (r (), 0))
        )
        ret.bitfields = bitfields
        ret
    }
}

object EarthFaultCompensatorSerializer extends CIMSerializer[EarthFaultCompensator]
{
    def write (kryo: Kryo, output: Output, obj: EarthFaultCompensator): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.r)
        )
        ConductingEquipmentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[EarthFaultCompensator]): EarthFaultCompensator =
    {
        val parent = ConductingEquipmentSerializer.read (kryo, input, classOf[ConductingEquipment])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = EarthFaultCompensator (
            parent,
            if (isSet (0)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A connection of energy generation or consumption on the power system model.
 *
 * @param ConductingEquipment [[ch.ninecode.model.ConductingEquipment ConductingEquipment]] Reference to the superclass object.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class EnergyConnection
(
    ConductingEquipment: ConductingEquipment = null
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
    override def sup: ConductingEquipment = ConductingEquipment

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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:EnergyConnection rdf:ID=\"%s\">\n%s\t</cim:EnergyConnection>".format (id, export_fields)
    }
}

object EnergyConnection
extends
    CIMParseable[EnergyConnection]
{

    def parse (context: CIMContext): EnergyConnection =
    {
        val ret = EnergyConnection (
            ConductingEquipment.parse (context)
        )
        ret
    }
}

object EnergyConnectionSerializer extends CIMSerializer[EnergyConnection]
{
    def write (kryo: Kryo, output: Output, obj: EnergyConnection): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        ConductingEquipmentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[EnergyConnection]): EnergyConnection =
    {
        val parent = ConductingEquipmentSerializer.read (kryo, input, classOf[ConductingEquipment])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = EnergyConnection (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Generic user of energy - a  point of consumption on the power system model.
 *
 * @param EnergyConnection [[ch.ninecode.model.EnergyConnection EnergyConnection]] Reference to the superclass object.
 * @param customerCount Number of individual customers represented by this demand.
 * @param grounded Used for Yn and Zn connections.
 *        True if the neutral is solidly grounded.
 * @param p Active power of the load.
 *        Load sign convention is used, i.e. positive sign means flow out from a node.
 *        For voltage dependent loads the value is at rated voltage.
 *        Starting value for a steady state solution.
 * @param pfixed Active power of the load that is a fixed quantity.
 *        Load sign convention is used, i.e. positive sign means flow out from a node.
 * @param pfixedPct Fixed active power as a percentage of load group fixed active power.
 *        Used to represent the time-varying components.  Load sign convention is used, i.e. positive sign means flow out from a node.
 * @param phaseConnection The type of phase connection, such as wye or delta.
 * @param q Reactive power of the load.
 *        Load sign convention is used, i.e. positive sign means flow out from a node.
 *        For voltage dependent loads the value is at rated voltage.
 *        Starting value for a steady state solution.
 * @param qfixed Reactive power of the load that is a fixed quantity.
 *        Load sign convention is used, i.e. positive sign means flow out from a node.
 * @param qfixedPct Fixed reactive power as a percentage of load group fixed reactive power.
 *        Used to represent the time-varying components.  Load sign convention is used, i.e. positive sign means flow out from a node.
 * @param EnergyConsumerPhase [[ch.ninecode.model.EnergyConsumerPhase EnergyConsumerPhase]] The individual phase models for this energy consumer.
 * @param LoadDynamics [[ch.ninecode.model.LoadDynamics LoadDynamics]] Load dynamics model used to describe dynamic behaviour of this energy consumer.
 * @param LoadResponse [[ch.ninecode.model.LoadResponseCharacteristic LoadResponseCharacteristic]] The load response characteristic of this load.
 *        If missing, this load is assumed to be constant power.
 * @param PowerCutZone [[ch.ninecode.model.PowerCutZone PowerCutZone]] The  energy consumer is assigned to this power cut zone.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class EnergyConsumer
(
    EnergyConnection: EnergyConnection = null,
    customerCount: Int = 0,
    grounded: Boolean = false,
    p: Double = 0.0,
    pfixed: Double = 0.0,
    pfixedPct: Double = 0.0,
    phaseConnection: String = null,
    q: Double = 0.0,
    qfixed: Double = 0.0,
    qfixedPct: Double = 0.0,
    EnergyConsumerPhase: List[String] = null,
    LoadDynamics: String = null,
    LoadResponse: String = null,
    PowerCutZone: String = null
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
    override def sup: EnergyConnection = EnergyConnection

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
        implicit val clz: String = EnergyConsumer.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (EnergyConsumer.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EnergyConsumer.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (EnergyConsumer.fields (position), x))
        emitelem (0, customerCount)
        emitelem (1, grounded)
        emitelem (2, p)
        emitelem (3, pfixed)
        emitelem (4, pfixedPct)
        emitattr (5, phaseConnection)
        emitelem (6, q)
        emitelem (7, qfixed)
        emitelem (8, qfixedPct)
        emitattrs (9, EnergyConsumerPhase)
        emitattr (10, LoadDynamics)
        emitattr (11, LoadResponse)
        emitattr (12, PowerCutZone)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EnergyConsumer rdf:ID=\"%s\">\n%s\t</cim:EnergyConsumer>".format (id, export_fields)
    }
}

object EnergyConsumer
extends
    CIMParseable[EnergyConsumer]
{
    override val fields: Array[String] = Array[String] (
        "customerCount",
        "grounded",
        "p",
        "pfixed",
        "pfixedPct",
        "phaseConnection",
        "q",
        "qfixed",
        "qfixedPct",
        "EnergyConsumerPhase",
        "LoadDynamics",
        "LoadResponse",
        "PowerCutZone"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("EnergyConsumerPhase", "EnergyConsumerPhase", "0..*", "1"),
        CIMRelationship ("LoadDynamics", "LoadDynamics", "0..1", "0..*"),
        CIMRelationship ("LoadResponse", "LoadResponseCharacteristic", "0..1", "0..*"),
        CIMRelationship ("PowerCutZone", "PowerCutZone", "0..1", "1..*")
    )
    val customerCount: Fielder = parse_element (element (cls, fields(0)))
    val grounded: Fielder = parse_element (element (cls, fields(1)))
    val p: Fielder = parse_element (element (cls, fields(2)))
    val pfixed: Fielder = parse_element (element (cls, fields(3)))
    val pfixedPct: Fielder = parse_element (element (cls, fields(4)))
    val phaseConnection: Fielder = parse_attribute (attribute (cls, fields(5)))
    val q: Fielder = parse_element (element (cls, fields(6)))
    val qfixed: Fielder = parse_element (element (cls, fields(7)))
    val qfixedPct: Fielder = parse_element (element (cls, fields(8)))
    val EnergyConsumerPhase: FielderMultiple = parse_attributes (attribute (cls, fields(9)))
    val LoadDynamics: Fielder = parse_attribute (attribute (cls, fields(10)))
    val LoadResponse: Fielder = parse_attribute (attribute (cls, fields(11)))
    val PowerCutZone: Fielder = parse_attribute (attribute (cls, fields(12)))

    def parse (context: CIMContext): EnergyConsumer =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EnergyConsumer (
            EnergyConnection.parse (context),
            toInteger (mask (customerCount (), 0)),
            toBoolean (mask (grounded (), 1)),
            toDouble (mask (p (), 2)),
            toDouble (mask (pfixed (), 3)),
            toDouble (mask (pfixedPct (), 4)),
            mask (phaseConnection (), 5),
            toDouble (mask (q (), 6)),
            toDouble (mask (qfixed (), 7)),
            toDouble (mask (qfixedPct (), 8)),
            masks (EnergyConsumerPhase (), 9),
            mask (LoadDynamics (), 10),
            mask (LoadResponse (), 11),
            mask (PowerCutZone (), 12)
        )
        ret.bitfields = bitfields
        ret
    }
}

object EnergyConsumerSerializer extends CIMSerializer[EnergyConsumer]
{
    def write (kryo: Kryo, output: Output, obj: EnergyConsumer): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeInt (obj.customerCount),
            () => output.writeBoolean (obj.grounded),
            () => output.writeDouble (obj.p),
            () => output.writeDouble (obj.pfixed),
            () => output.writeDouble (obj.pfixedPct),
            () => output.writeString (obj.phaseConnection),
            () => output.writeDouble (obj.q),
            () => output.writeDouble (obj.qfixed),
            () => output.writeDouble (obj.qfixedPct),
            () => writeList (obj.EnergyConsumerPhase, output),
            () => output.writeString (obj.LoadDynamics),
            () => output.writeString (obj.LoadResponse),
            () => output.writeString (obj.PowerCutZone)
        )
        EnergyConnectionSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[EnergyConsumer]): EnergyConsumer =
    {
        val parent = EnergyConnectionSerializer.read (kryo, input, classOf[EnergyConnection])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = EnergyConsumer (
            parent,
            if (isSet (0)) input.readInt else 0,
            if (isSet (1)) input.readBoolean else false,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readDouble else 0.0,
            if (isSet (7)) input.readDouble else 0.0,
            if (isSet (8)) input.readDouble else 0.0,
            if (isSet (9)) readList (input) else null,
            if (isSet (10)) input.readString else null,
            if (isSet (11)) input.readString else null,
            if (isSet (12)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A single phase of an energy consumer.
 *
 * @param PowerSystemResource [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param p Active power of the load.
 *        Load sign convention is used, i.e. positive sign means flow out from a node.
 *        For voltage dependent loads the value is at rated voltage.
 *        Starting value for a steady state solution.
 * @param pfixed Active power of the load that is a fixed quantity.
 *        Load sign convention is used, i.e. positive sign means flow out from a node.
 * @param pfixedPct Fixed active power as per cent of load group fixed active power.
 *        Load sign convention is used, i.e. positive sign means flow out from a node.
 * @param phase Phase of this energy consumer component.
 *        If the energy consumer is wye connected, the connection is from the indicated phase to the central ground or neutral point.  If the energy consumer is delta connected, the phase indicates an energy consumer connected from the indicated phase to the next logical non-neutral phase.
 * @param q Reactive power of the load.
 *        Load sign convention is used, i.e. positive sign means flow out from a node.
 *        For voltage dependent loads the value is at rated voltage.
 *        Starting value for a steady state solution.
 * @param qfixed Reactive power of the load that is a fixed quantity.
 *        Load sign convention is used, i.e. positive sign means flow out from a node.
 * @param qfixedPct Fixed reactive power as per cent of load group fixed reactive power.
 *        Load sign convention is used, i.e. positive sign means flow out from a node.
 * @param EnergyConsumer [[ch.ninecode.model.EnergyConsumer EnergyConsumer]] The energy consumer to which this phase belongs.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class EnergyConsumerPhase
(
    PowerSystemResource: PowerSystemResource = null,
    p: Double = 0.0,
    pfixed: Double = 0.0,
    pfixedPct: Double = 0.0,
    phase: String = null,
    q: Double = 0.0,
    qfixed: Double = 0.0,
    qfixedPct: Double = 0.0,
    EnergyConsumer: String = null
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
        implicit val clz: String = EnergyConsumerPhase.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (EnergyConsumerPhase.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EnergyConsumerPhase.fields (position), value)
        emitelem (0, p)
        emitelem (1, pfixed)
        emitelem (2, pfixedPct)
        emitattr (3, phase)
        emitelem (4, q)
        emitelem (5, qfixed)
        emitelem (6, qfixedPct)
        emitattr (7, EnergyConsumer)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EnergyConsumerPhase rdf:ID=\"%s\">\n%s\t</cim:EnergyConsumerPhase>".format (id, export_fields)
    }
}

object EnergyConsumerPhase
extends
    CIMParseable[EnergyConsumerPhase]
{
    override val fields: Array[String] = Array[String] (
        "p",
        "pfixed",
        "pfixedPct",
        "phase",
        "q",
        "qfixed",
        "qfixedPct",
        "EnergyConsumer"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("EnergyConsumer", "EnergyConsumer", "1", "0..*")
    )
    val p: Fielder = parse_element (element (cls, fields(0)))
    val pfixed: Fielder = parse_element (element (cls, fields(1)))
    val pfixedPct: Fielder = parse_element (element (cls, fields(2)))
    val phase: Fielder = parse_attribute (attribute (cls, fields(3)))
    val q: Fielder = parse_element (element (cls, fields(4)))
    val qfixed: Fielder = parse_element (element (cls, fields(5)))
    val qfixedPct: Fielder = parse_element (element (cls, fields(6)))
    val EnergyConsumer: Fielder = parse_attribute (attribute (cls, fields(7)))

    def parse (context: CIMContext): EnergyConsumerPhase =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EnergyConsumerPhase (
            PowerSystemResource.parse (context),
            toDouble (mask (p (), 0)),
            toDouble (mask (pfixed (), 1)),
            toDouble (mask (pfixedPct (), 2)),
            mask (phase (), 3),
            toDouble (mask (q (), 4)),
            toDouble (mask (qfixed (), 5)),
            toDouble (mask (qfixedPct (), 6)),
            mask (EnergyConsumer (), 7)
        )
        ret.bitfields = bitfields
        ret
    }
}

object EnergyConsumerPhaseSerializer extends CIMSerializer[EnergyConsumerPhase]
{
    def write (kryo: Kryo, output: Output, obj: EnergyConsumerPhase): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.p),
            () => output.writeDouble (obj.pfixed),
            () => output.writeDouble (obj.pfixedPct),
            () => output.writeString (obj.phase),
            () => output.writeDouble (obj.q),
            () => output.writeDouble (obj.qfixed),
            () => output.writeDouble (obj.qfixedPct),
            () => output.writeString (obj.EnergyConsumer)
        )
        PowerSystemResourceSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[EnergyConsumerPhase]): EnergyConsumerPhase =
    {
        val parent = PowerSystemResourceSerializer.read (kryo, input, classOf[PowerSystemResource])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = EnergyConsumerPhase (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readDouble else 0.0,
            if (isSet (6)) input.readDouble else 0.0,
            if (isSet (7)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Used to define the type of generation for scheduling purposes.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param EnergySource [[ch.ninecode.model.EnergySource EnergySource]] Energy Source of a particular Energy Scheduling Type.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class EnergySchedulingType
(
    IdentifiedObject: IdentifiedObject = null,
    EnergySource: List[String] = null
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
        implicit val clz: String = EnergySchedulingType.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (EnergySchedulingType.fields (position), x))
        emitattrs (0, EnergySource)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EnergySchedulingType rdf:ID=\"%s\">\n%s\t</cim:EnergySchedulingType>".format (id, export_fields)
    }
}

object EnergySchedulingType
extends
    CIMParseable[EnergySchedulingType]
{
    override val fields: Array[String] = Array[String] (
        "EnergySource"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("EnergySource", "EnergySource", "0..*", "0..1")
    )
    val EnergySource: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): EnergySchedulingType =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EnergySchedulingType (
            IdentifiedObject.parse (context),
            masks (EnergySource (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

object EnergySchedulingTypeSerializer extends CIMSerializer[EnergySchedulingType]
{
    def write (kryo: Kryo, output: Output, obj: EnergySchedulingType): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.EnergySource, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[EnergySchedulingType]): EnergySchedulingType =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = EnergySchedulingType (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A generic equivalent for an energy supplier on a transmission or distribution voltage level.
 *
 * @param EnergyConnection [[ch.ninecode.model.EnergyConnection EnergyConnection]] Reference to the superclass object.
 * @param activePower High voltage source active injection.
 *        Load sign convention is used, i.e. positive sign means flow out from a node.
 *        Starting value for steady state solutions.
 * @param nominalVoltage Phase-to-phase nominal voltage.
 * @param pMax This is the maximum active power that can be produced by the source.
 *        Load sign convention is used, i.e. positive sign means flow out from a TopologicalNode (bus) into the conducting equipment.
 * @param pMin This is the minimum active power that can be produced by the source.
 *        Load sign convention is used, i.e. positive sign means flow out from a TopologicalNode (bus) into the conducting equipment.
 * @param r Positive sequence Thevenin resistance.
 * @param r0 Zero sequence Thevenin resistance.
 * @param reactivePower High voltage source reactive injection.
 *        Load sign convention is used, i.e. positive sign means flow out from a node.
 *        Starting value for steady state solutions.
 * @param rn Negative sequence Thevenin resistance.
 * @param voltageAngle Phase angle of a-phase open circuit used when voltage characteristics need to be imposed at the node associated with the terminal of the energy source, such as when voltages and angles from the transmission level are used as input to the distribution network.
 * @param voltageMagnitude Phase-to-phase open circuit voltage magnitude used when voltage characteristics need to be imposed at the node associated with the terminal of the energy source, such as when voltages and angles from the transmission level are used as input to the distribution network.
 * @param x Positive sequence Thevenin reactance.
 * @param x0 Zero sequence Thevenin reactance.
 * @param xn Negative sequence Thevenin reactance.
 * @param EnergySchedulingType [[ch.ninecode.model.EnergySchedulingType EnergySchedulingType]] Energy Scheduling Type of an Energy Source.
 * @param EnergySourceAction [[ch.ninecode.model.EnergySourceAction EnergySourceAction]] Action taken with this energy source.
 * @param EnergySourcePhase [[ch.ninecode.model.EnergySourcePhase EnergySourcePhase]] The individual phase information of the energy source.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class EnergySource
(
    EnergyConnection: EnergyConnection = null,
    activePower: Double = 0.0,
    nominalVoltage: Double = 0.0,
    pMax: Double = 0.0,
    pMin: Double = 0.0,
    r: Double = 0.0,
    r0: Double = 0.0,
    reactivePower: Double = 0.0,
    rn: Double = 0.0,
    voltageAngle: Double = 0.0,
    voltageMagnitude: Double = 0.0,
    x: Double = 0.0,
    x0: Double = 0.0,
    xn: Double = 0.0,
    EnergySchedulingType: String = null,
    EnergySourceAction: String = null,
    EnergySourcePhase: List[String] = null
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
    override def sup: EnergyConnection = EnergyConnection

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
        implicit val clz: String = EnergySource.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (EnergySource.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EnergySource.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (EnergySource.fields (position), x))
        emitelem (0, activePower)
        emitelem (1, nominalVoltage)
        emitelem (2, pMax)
        emitelem (3, pMin)
        emitelem (4, r)
        emitelem (5, r0)
        emitelem (6, reactivePower)
        emitelem (7, rn)
        emitelem (8, voltageAngle)
        emitelem (9, voltageMagnitude)
        emitelem (10, x)
        emitelem (11, x0)
        emitelem (12, xn)
        emitattr (13, EnergySchedulingType)
        emitattr (14, EnergySourceAction)
        emitattrs (15, EnergySourcePhase)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EnergySource rdf:ID=\"%s\">\n%s\t</cim:EnergySource>".format (id, export_fields)
    }
}

object EnergySource
extends
    CIMParseable[EnergySource]
{
    override val fields: Array[String] = Array[String] (
        "activePower",
        "nominalVoltage",
        "pMax",
        "pMin",
        "r",
        "r0",
        "reactivePower",
        "rn",
        "voltageAngle",
        "voltageMagnitude",
        "x",
        "x0",
        "xn",
        "EnergySchedulingType",
        "EnergySourceAction",
        "EnergySourcePhase"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("EnergySchedulingType", "EnergySchedulingType", "0..1", "0..*"),
        CIMRelationship ("EnergySourceAction", "EnergySourceAction", "0..1", "0..1"),
        CIMRelationship ("EnergySourcePhase", "EnergySourcePhase", "0..*", "1")
    )
    val activePower: Fielder = parse_element (element (cls, fields(0)))
    val nominalVoltage: Fielder = parse_element (element (cls, fields(1)))
    val pMax: Fielder = parse_element (element (cls, fields(2)))
    val pMin: Fielder = parse_element (element (cls, fields(3)))
    val r: Fielder = parse_element (element (cls, fields(4)))
    val r0: Fielder = parse_element (element (cls, fields(5)))
    val reactivePower: Fielder = parse_element (element (cls, fields(6)))
    val rn: Fielder = parse_element (element (cls, fields(7)))
    val voltageAngle: Fielder = parse_element (element (cls, fields(8)))
    val voltageMagnitude: Fielder = parse_element (element (cls, fields(9)))
    val x: Fielder = parse_element (element (cls, fields(10)))
    val x0: Fielder = parse_element (element (cls, fields(11)))
    val xn: Fielder = parse_element (element (cls, fields(12)))
    val EnergySchedulingType: Fielder = parse_attribute (attribute (cls, fields(13)))
    val EnergySourceAction: Fielder = parse_attribute (attribute (cls, fields(14)))
    val EnergySourcePhase: FielderMultiple = parse_attributes (attribute (cls, fields(15)))

    def parse (context: CIMContext): EnergySource =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EnergySource (
            EnergyConnection.parse (context),
            toDouble (mask (activePower (), 0)),
            toDouble (mask (nominalVoltage (), 1)),
            toDouble (mask (pMax (), 2)),
            toDouble (mask (pMin (), 3)),
            toDouble (mask (r (), 4)),
            toDouble (mask (r0 (), 5)),
            toDouble (mask (reactivePower (), 6)),
            toDouble (mask (rn (), 7)),
            toDouble (mask (voltageAngle (), 8)),
            toDouble (mask (voltageMagnitude (), 9)),
            toDouble (mask (x (), 10)),
            toDouble (mask (x0 (), 11)),
            toDouble (mask (xn (), 12)),
            mask (EnergySchedulingType (), 13),
            mask (EnergySourceAction (), 14),
            masks (EnergySourcePhase (), 15)
        )
        ret.bitfields = bitfields
        ret
    }
}

object EnergySourceSerializer extends CIMSerializer[EnergySource]
{
    def write (kryo: Kryo, output: Output, obj: EnergySource): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.activePower),
            () => output.writeDouble (obj.nominalVoltage),
            () => output.writeDouble (obj.pMax),
            () => output.writeDouble (obj.pMin),
            () => output.writeDouble (obj.r),
            () => output.writeDouble (obj.r0),
            () => output.writeDouble (obj.reactivePower),
            () => output.writeDouble (obj.rn),
            () => output.writeDouble (obj.voltageAngle),
            () => output.writeDouble (obj.voltageMagnitude),
            () => output.writeDouble (obj.x),
            () => output.writeDouble (obj.x0),
            () => output.writeDouble (obj.xn),
            () => output.writeString (obj.EnergySchedulingType),
            () => output.writeString (obj.EnergySourceAction),
            () => writeList (obj.EnergySourcePhase, output)
        )
        EnergyConnectionSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[EnergySource]): EnergySource =
    {
        val parent = EnergyConnectionSerializer.read (kryo, input, classOf[EnergyConnection])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = EnergySource (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readDouble else 0.0,
            if (isSet (6)) input.readDouble else 0.0,
            if (isSet (7)) input.readDouble else 0.0,
            if (isSet (8)) input.readDouble else 0.0,
            if (isSet (9)) input.readDouble else 0.0,
            if (isSet (10)) input.readDouble else 0.0,
            if (isSet (11)) input.readDouble else 0.0,
            if (isSet (12)) input.readDouble else 0.0,
            if (isSet (13)) input.readString else null,
            if (isSet (14)) input.readString else null,
            if (isSet (15)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Represents the single phase information of an unbalanced energy source.
 *
 * @param PowerSystemResource [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param phase Phase of this energy source component.
 *        If the energy source wye connected, the connection is from the indicated phase to the central ground or neutral point.  If the energy source is delta connected, the phase indicates an energy source connected from the indicated phase to the next logical non-neutral phase.
 * @param EnergySource [[ch.ninecode.model.EnergySource EnergySource]] The energy sourceto which the phase belongs.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class EnergySourcePhase
(
    PowerSystemResource: PowerSystemResource = null,
    phase: String = null,
    EnergySource: String = null
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
        implicit val clz: String = EnergySourcePhase.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EnergySourcePhase.fields (position), value)
        emitattr (0, phase)
        emitattr (1, EnergySource)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EnergySourcePhase rdf:ID=\"%s\">\n%s\t</cim:EnergySourcePhase>".format (id, export_fields)
    }
}

object EnergySourcePhase
extends
    CIMParseable[EnergySourcePhase]
{
    override val fields: Array[String] = Array[String] (
        "phase",
        "EnergySource"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("EnergySource", "EnergySource", "1", "0..*")
    )
    val phase: Fielder = parse_attribute (attribute (cls, fields(0)))
    val EnergySource: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): EnergySourcePhase =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EnergySourcePhase (
            PowerSystemResource.parse (context),
            mask (phase (), 0),
            mask (EnergySource (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

object EnergySourcePhaseSerializer extends CIMSerializer[EnergySourcePhase]
{
    def write (kryo: Kryo, output: Output, obj: EnergySourcePhase): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.phase),
            () => output.writeString (obj.EnergySource)
        )
        PowerSystemResourceSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[EnergySourcePhase]): EnergySourcePhase =
    {
        val parent = PowerSystemResourceSerializer.read (kryo, input, classOf[PowerSystemResource])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = EnergySourcePhase (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * This class represents the external network and it is used for IEC 60909 calculations.
 *
 * @param RegulatingCondEq [[ch.ninecode.model.RegulatingCondEq RegulatingCondEq]] Reference to the superclass object.
 * @param governorSCD Power Frequency Bias.
 *        This is the change in power injection divided by the change in frequency and negated.  A positive value of the power frequency bias provides additional power injection upon a drop in frequency.
 * @param ikSecond Indicates whether initial symmetrical short-circuit current and power have been calculated according to IEC (Ik").
 *        Used only if short circuit calculations are done according to superposition method.
 * @param maxInitialSymShCCurrent Maximum initial symmetrical short-circuit currents (Ik" max) in A (Ik" = Sk"/(SQRT(3) Un)).
 *        Used for short circuit data exchange according to IEC 60909.
 * @param maxP Maximum active power of the injection.
 * @param maxQ Not for short circuit modelling; It is used for modelling of infeed for load flow exchange.
 *        If maxQ and minQ are not used ReactiveCapabilityCurve can be used.
 * @param maxR0ToX0Ratio Maximum ratio of zero sequence resistance of Network Feeder to its zero sequence reactance (R(0)/X(0) max).
 *        Used for short circuit data exchange according to IEC 60909.
 * @param maxR1ToX1Ratio Maximum ratio of positive sequence resistance of Network Feeder to its positive sequence reactance (R(1)/X(1) max).
 *        Used for short circuit data exchange according to IEC 60909.
 * @param maxZ0ToZ1Ratio Maximum ratio of zero sequence impedance to its positive sequence impedance (Z(0)/Z(1) max).
 *        Used for short circuit data exchange according to IEC 60909.
 * @param minInitialSymShCCurrent Minimum initial symmetrical short-circuit currents (Ik" min) in A (Ik" = Sk"/(SQRT(3) Un)).
 *        Used for short circuit data exchange according to IEC 60909.
 * @param minP Minimum active power of the injection.
 * @param minQ Not for short circuit modelling; It is used for modelling of infeed for load flow exchange.
 *        If maxQ and minQ are not used ReactiveCapabilityCurve can be used.
 * @param minR0ToX0Ratio Indicates whether initial symmetrical short-circuit current and power have been calculated according to IEC (Ik").
 *        Used for short circuit data exchange according to IEC 6090.
 * @param minR1ToX1Ratio Minimum ratio of positive sequence resistance of Network Feeder to its positive sequence reactance (R(1)/X(1) min).
 *        Used for short circuit data exchange according to IEC 60909.
 * @param minZ0ToZ1Ratio Minimum ratio of zero sequence impedance to its positive sequence impedance (Z(0)/Z(1) min).
 *        Used for short circuit data exchange according to IEC 60909.
 * @param p Active power injection.
 *        Load sign convention is used, i.e. positive sign means flow out from a node.
 *        Starting value for steady state solutions.
 * @param q Reactive power injection.
 *        Load sign convention is used, i.e. positive sign means flow out from a node.
 *        Starting value for steady state solutions.
 * @param referencePriority Priority of unit for use as powerflow voltage phase angle reference bus selection. 0 = don t care (default) 1 = highest priority. 2 is less than 1 and so on.
 * @param voltageFactor Voltage factor in pu, which was used to calculate short-circuit current Ik" and power Sk".
 *        Used only if short circuit calculations are done according to superposition method.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class ExternalNetworkInjection
(
    RegulatingCondEq: RegulatingCondEq = null,
    governorSCD: Double = 0.0,
    ikSecond: Boolean = false,
    maxInitialSymShCCurrent: Double = 0.0,
    maxP: Double = 0.0,
    maxQ: Double = 0.0,
    maxR0ToX0Ratio: Double = 0.0,
    maxR1ToX1Ratio: Double = 0.0,
    maxZ0ToZ1Ratio: Double = 0.0,
    minInitialSymShCCurrent: Double = 0.0,
    minP: Double = 0.0,
    minQ: Double = 0.0,
    minR0ToX0Ratio: Double = 0.0,
    minR1ToX1Ratio: Double = 0.0,
    minZ0ToZ1Ratio: Double = 0.0,
    p: Double = 0.0,
    q: Double = 0.0,
    referencePriority: Int = 0,
    voltageFactor: Double = 0.0
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
    override def sup: RegulatingCondEq = RegulatingCondEq

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
        implicit val clz: String = ExternalNetworkInjection.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExternalNetworkInjection.fields (position), value)
        emitelem (0, governorSCD)
        emitelem (1, ikSecond)
        emitelem (2, maxInitialSymShCCurrent)
        emitelem (3, maxP)
        emitelem (4, maxQ)
        emitelem (5, maxR0ToX0Ratio)
        emitelem (6, maxR1ToX1Ratio)
        emitelem (7, maxZ0ToZ1Ratio)
        emitelem (8, minInitialSymShCCurrent)
        emitelem (9, minP)
        emitelem (10, minQ)
        emitelem (11, minR0ToX0Ratio)
        emitelem (12, minR1ToX1Ratio)
        emitelem (13, minZ0ToZ1Ratio)
        emitelem (14, p)
        emitelem (15, q)
        emitelem (16, referencePriority)
        emitelem (17, voltageFactor)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExternalNetworkInjection rdf:ID=\"%s\">\n%s\t</cim:ExternalNetworkInjection>".format (id, export_fields)
    }
}

object ExternalNetworkInjection
extends
    CIMParseable[ExternalNetworkInjection]
{
    override val fields: Array[String] = Array[String] (
        "governorSCD",
        "ikSecond",
        "maxInitialSymShCCurrent",
        "maxP",
        "maxQ",
        "maxR0ToX0Ratio",
        "maxR1ToX1Ratio",
        "maxZ0ToZ1Ratio",
        "minInitialSymShCCurrent",
        "minP",
        "minQ",
        "minR0ToX0Ratio",
        "minR1ToX1Ratio",
        "minZ0ToZ1Ratio",
        "p",
        "q",
        "referencePriority",
        "voltageFactor"
    )
    val governorSCD: Fielder = parse_element (element (cls, fields(0)))
    val ikSecond: Fielder = parse_element (element (cls, fields(1)))
    val maxInitialSymShCCurrent: Fielder = parse_element (element (cls, fields(2)))
    val maxP: Fielder = parse_element (element (cls, fields(3)))
    val maxQ: Fielder = parse_element (element (cls, fields(4)))
    val maxR0ToX0Ratio: Fielder = parse_element (element (cls, fields(5)))
    val maxR1ToX1Ratio: Fielder = parse_element (element (cls, fields(6)))
    val maxZ0ToZ1Ratio: Fielder = parse_element (element (cls, fields(7)))
    val minInitialSymShCCurrent: Fielder = parse_element (element (cls, fields(8)))
    val minP: Fielder = parse_element (element (cls, fields(9)))
    val minQ: Fielder = parse_element (element (cls, fields(10)))
    val minR0ToX0Ratio: Fielder = parse_element (element (cls, fields(11)))
    val minR1ToX1Ratio: Fielder = parse_element (element (cls, fields(12)))
    val minZ0ToZ1Ratio: Fielder = parse_element (element (cls, fields(13)))
    val p: Fielder = parse_element (element (cls, fields(14)))
    val q: Fielder = parse_element (element (cls, fields(15)))
    val referencePriority: Fielder = parse_element (element (cls, fields(16)))
    val voltageFactor: Fielder = parse_element (element (cls, fields(17)))

    def parse (context: CIMContext): ExternalNetworkInjection =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ExternalNetworkInjection (
            RegulatingCondEq.parse (context),
            toDouble (mask (governorSCD (), 0)),
            toBoolean (mask (ikSecond (), 1)),
            toDouble (mask (maxInitialSymShCCurrent (), 2)),
            toDouble (mask (maxP (), 3)),
            toDouble (mask (maxQ (), 4)),
            toDouble (mask (maxR0ToX0Ratio (), 5)),
            toDouble (mask (maxR1ToX1Ratio (), 6)),
            toDouble (mask (maxZ0ToZ1Ratio (), 7)),
            toDouble (mask (minInitialSymShCCurrent (), 8)),
            toDouble (mask (minP (), 9)),
            toDouble (mask (minQ (), 10)),
            toDouble (mask (minR0ToX0Ratio (), 11)),
            toDouble (mask (minR1ToX1Ratio (), 12)),
            toDouble (mask (minZ0ToZ1Ratio (), 13)),
            toDouble (mask (p (), 14)),
            toDouble (mask (q (), 15)),
            toInteger (mask (referencePriority (), 16)),
            toDouble (mask (voltageFactor (), 17))
        )
        ret.bitfields = bitfields
        ret
    }
}

object ExternalNetworkInjectionSerializer extends CIMSerializer[ExternalNetworkInjection]
{
    def write (kryo: Kryo, output: Output, obj: ExternalNetworkInjection): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.governorSCD),
            () => output.writeBoolean (obj.ikSecond),
            () => output.writeDouble (obj.maxInitialSymShCCurrent),
            () => output.writeDouble (obj.maxP),
            () => output.writeDouble (obj.maxQ),
            () => output.writeDouble (obj.maxR0ToX0Ratio),
            () => output.writeDouble (obj.maxR1ToX1Ratio),
            () => output.writeDouble (obj.maxZ0ToZ1Ratio),
            () => output.writeDouble (obj.minInitialSymShCCurrent),
            () => output.writeDouble (obj.minP),
            () => output.writeDouble (obj.minQ),
            () => output.writeDouble (obj.minR0ToX0Ratio),
            () => output.writeDouble (obj.minR1ToX1Ratio),
            () => output.writeDouble (obj.minZ0ToZ1Ratio),
            () => output.writeDouble (obj.p),
            () => output.writeDouble (obj.q),
            () => output.writeInt (obj.referencePriority),
            () => output.writeDouble (obj.voltageFactor)
        )
        RegulatingCondEqSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ExternalNetworkInjection]): ExternalNetworkInjection =
    {
        val parent = RegulatingCondEqSerializer.read (kryo, input, classOf[RegulatingCondEq])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ExternalNetworkInjection (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readBoolean else false,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readDouble else 0.0,
            if (isSet (6)) input.readDouble else 0.0,
            if (isSet (7)) input.readDouble else 0.0,
            if (isSet (8)) input.readDouble else 0.0,
            if (isSet (9)) input.readDouble else 0.0,
            if (isSet (10)) input.readDouble else 0.0,
            if (isSet (11)) input.readDouble else 0.0,
            if (isSet (12)) input.readDouble else 0.0,
            if (isSet (13)) input.readDouble else 0.0,
            if (isSet (14)) input.readDouble else 0.0,
            if (isSet (15)) input.readDouble else 0.0,
            if (isSet (16)) input.readInt else 0,
            if (isSet (17)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A device to convert from one frequency to another (e.g., frequency F1 to F2) comprises a pair of FrequencyConverter instances.
 *
 * One converts from F1 to DC, the other converts the DC to F2.
 *
 * @param RegulatingCondEq [[ch.ninecode.model.RegulatingCondEq RegulatingCondEq]] Reference to the superclass object.
 * @param frequency Frequency on the AC side.
 * @param maxP The maximum active power on the DC side at which the frequency converter should operate.
 * @param maxU The maximum voltage on the DC side at which the frequency converter should operate.
 * @param minP The minimum active power on the DC side at which the frequency converter should operate.
 * @param minU The minimum voltage on the DC side at which the frequency converter should operate.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class FrequencyConverter
(
    RegulatingCondEq: RegulatingCondEq = null,
    frequency: Double = 0.0,
    maxP: Double = 0.0,
    maxU: Double = 0.0,
    minP: Double = 0.0,
    minU: Double = 0.0
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
    override def sup: RegulatingCondEq = RegulatingCondEq

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
        implicit val clz: String = FrequencyConverter.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (FrequencyConverter.fields (position), value)
        emitelem (0, frequency)
        emitelem (1, maxP)
        emitelem (2, maxU)
        emitelem (3, minP)
        emitelem (4, minU)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:FrequencyConverter rdf:ID=\"%s\">\n%s\t</cim:FrequencyConverter>".format (id, export_fields)
    }
}

object FrequencyConverter
extends
    CIMParseable[FrequencyConverter]
{
    override val fields: Array[String] = Array[String] (
        "frequency",
        "maxP",
        "maxU",
        "minP",
        "minU"
    )
    val frequency: Fielder = parse_element (element (cls, fields(0)))
    val maxP: Fielder = parse_element (element (cls, fields(1)))
    val maxU: Fielder = parse_element (element (cls, fields(2)))
    val minP: Fielder = parse_element (element (cls, fields(3)))
    val minU: Fielder = parse_element (element (cls, fields(4)))

    def parse (context: CIMContext): FrequencyConverter =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = FrequencyConverter (
            RegulatingCondEq.parse (context),
            toDouble (mask (frequency (), 0)),
            toDouble (mask (maxP (), 1)),
            toDouble (mask (maxU (), 2)),
            toDouble (mask (minP (), 3)),
            toDouble (mask (minU (), 4))
        )
        ret.bitfields = bitfields
        ret
    }
}

object FrequencyConverterSerializer extends CIMSerializer[FrequencyConverter]
{
    def write (kryo: Kryo, output: Output, obj: FrequencyConverter): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.frequency),
            () => output.writeDouble (obj.maxP),
            () => output.writeDouble (obj.maxU),
            () => output.writeDouble (obj.minP),
            () => output.writeDouble (obj.minU)
        )
        RegulatingCondEqSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[FrequencyConverter]): FrequencyConverter =
    {
        val parent = RegulatingCondEqSerializer.read (kryo, input, classOf[RegulatingCondEq])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = FrequencyConverter (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * An overcurrent protective device with a circuit opening fusible part that is heated and severed by the passage of overcurrent through it.
 *
 * A fuse is considered a switching device because it breaks current.
 *
 * @param Switch [[ch.ninecode.model.Switch Switch]] Reference to the superclass object.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class Fuse
(
    Switch: Switch = null
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
    override def sup: Switch = Switch

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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:Fuse rdf:ID=\"%s\">\n%s\t</cim:Fuse>".format (id, export_fields)
    }
}

object Fuse
extends
    CIMParseable[Fuse]
{

    def parse (context: CIMContext): Fuse =
    {
        val ret = Fuse (
            Switch.parse (context)
        )
        ret
    }
}

object FuseSerializer extends CIMSerializer[Fuse]
{
    def write (kryo: Kryo, output: Output, obj: Fuse): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        SwitchSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Fuse]): Fuse =
    {
        val parent = SwitchSerializer.read (kryo, input, classOf[Switch])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Fuse (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A point where the system is grounded used for connecting conducting equipment to ground.
 *
 * The power system model can have any number of grounds.
 *
 * @param ConductingEquipment [[ch.ninecode.model.ConductingEquipment ConductingEquipment]] Reference to the superclass object.
 * @param GroundAction [[ch.ninecode.model.GroundAction GroundAction]] Action taken with this ground.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class Ground
(
    ConductingEquipment: ConductingEquipment = null,
    GroundAction: String = null
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
    override def sup: ConductingEquipment = ConductingEquipment

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
        implicit val clz: String = Ground.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Ground.fields (position), value)
        emitattr (0, GroundAction)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Ground rdf:ID=\"%s\">\n%s\t</cim:Ground>".format (id, export_fields)
    }
}

object Ground
extends
    CIMParseable[Ground]
{
    override val fields: Array[String] = Array[String] (
        "GroundAction"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("GroundAction", "GroundAction", "0..1", "0..1")
    )
    val GroundAction: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): Ground =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Ground (
            ConductingEquipment.parse (context),
            mask (GroundAction (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

object GroundSerializer extends CIMSerializer[Ground]
{
    def write (kryo: Kryo, output: Output, obj: Ground): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.GroundAction)
        )
        ConductingEquipmentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Ground]): Ground =
    {
        val parent = ConductingEquipmentSerializer.read (kryo, input, classOf[ConductingEquipment])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Ground (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A manually operated or motor operated mechanical switching device used for isolating a circuit or equipment from ground.
 *
 * @param Switch [[ch.ninecode.model.Switch Switch]] Reference to the superclass object.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class GroundDisconnector
(
    Switch: Switch = null
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
    override def sup: Switch = Switch

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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:GroundDisconnector rdf:ID=\"%s\">\n%s\t</cim:GroundDisconnector>".format (id, export_fields)
    }
}

object GroundDisconnector
extends
    CIMParseable[GroundDisconnector]
{

    def parse (context: CIMContext): GroundDisconnector =
    {
        val ret = GroundDisconnector (
            Switch.parse (context)
        )
        ret
    }
}

object GroundDisconnectorSerializer extends CIMSerializer[GroundDisconnector]
{
    def write (kryo: Kryo, output: Output, obj: GroundDisconnector): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        SwitchSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[GroundDisconnector]): GroundDisconnector =
    {
        val parent = SwitchSerializer.read (kryo, input, classOf[Switch])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = GroundDisconnector (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A fixed impedance device used for grounding.
 *
 * @param EarthFaultCompensator [[ch.ninecode.model.EarthFaultCompensator EarthFaultCompensator]] Reference to the superclass object.
 * @param x Reactance of device.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class GroundingImpedance
(
    EarthFaultCompensator: EarthFaultCompensator = null,
    x: Double = 0.0
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
    override def sup: EarthFaultCompensator = EarthFaultCompensator

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
        implicit val clz: String = GroundingImpedance.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GroundingImpedance.fields (position), value)
        emitelem (0, x)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GroundingImpedance rdf:ID=\"%s\">\n%s\t</cim:GroundingImpedance>".format (id, export_fields)
    }
}

object GroundingImpedance
extends
    CIMParseable[GroundingImpedance]
{
    override val fields: Array[String] = Array[String] (
        "x"
    )
    val x: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: CIMContext): GroundingImpedance =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = GroundingImpedance (
            EarthFaultCompensator.parse (context),
            toDouble (mask (x (), 0))
        )
        ret.bitfields = bitfields
        ret
    }
}

object GroundingImpedanceSerializer extends CIMSerializer[GroundingImpedance]
{
    def write (kryo: Kryo, output: Output, obj: GroundingImpedance): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.x)
        )
        EarthFaultCompensatorSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[GroundingImpedance]): GroundingImpedance =
    {
        val parent = EarthFaultCompensatorSerializer.read (kryo, input, classOf[EarthFaultCompensator])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = GroundingImpedance (
            parent,
            if (isSet (0)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A short section of conductor with negligible impedance which can be manually removed and replaced if the circuit is de-energized.
 *
 * Note that zero-impedance branches can potentially be modelled by other equipment types.
 *
 * @param Switch [[ch.ninecode.model.Switch Switch]] Reference to the superclass object.
 * @param JumperAction [[ch.ninecode.model.JumperAction JumperAction]] Action taken with this jumper.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class Jumper
(
    Switch: Switch = null,
    JumperAction: String = null
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
    override def sup: Switch = Switch

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
        implicit val clz: String = Jumper.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Jumper.fields (position), value)
        emitattr (0, JumperAction)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Jumper rdf:ID=\"%s\">\n%s\t</cim:Jumper>".format (id, export_fields)
    }
}

object Jumper
extends
    CIMParseable[Jumper]
{
    override val fields: Array[String] = Array[String] (
        "JumperAction"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("JumperAction", "JumperAction", "0..1", "0..1")
    )
    val JumperAction: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): Jumper =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Jumper (
            Switch.parse (context),
            mask (JumperAction (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

object JumperSerializer extends CIMSerializer[Jumper]
{
    def write (kryo: Kryo, output: Output, obj: Jumper): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.JumperAction)
        )
        SwitchSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Jumper]): Jumper =
    {
        val parent = SwitchSerializer.read (kryo, input, classOf[Switch])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Jumper (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A point where one or more conducting equipments are connected with zero resistance.
 *
 * @param Connector [[ch.ninecode.model.Connector Connector]] Reference to the superclass object.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class Junction
(
    Connector: Connector = null
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
    override def sup: Connector = Connector

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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:Junction rdf:ID=\"%s\">\n%s\t</cim:Junction>".format (id, export_fields)
    }
}

object Junction
extends
    CIMParseable[Junction]
{

    def parse (context: CIMContext): Junction =
    {
        val ret = Junction (
            Connector.parse (context)
        )
        ret
    }
}

object JunctionSerializer extends CIMSerializer[Junction]
{
    def write (kryo: Kryo, output: Output, obj: Junction): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        ConnectorSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Junction]): Junction =
    {
        val parent = ConnectorSerializer.read (kryo, input, classOf[Connector])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Junction (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Contains equipment beyond a substation belonging to a power transmission line.
 *
 * @param EquipmentContainer [[ch.ninecode.model.EquipmentContainer EquipmentContainer]] Reference to the superclass object.
 * @param Region [[ch.ninecode.model.SubGeographicalRegion SubGeographicalRegion]] The sub-geographical region of the line.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class Line
(
    EquipmentContainer: EquipmentContainer = null,
    Region: String = null
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
    override def sup: EquipmentContainer = EquipmentContainer

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
        implicit val clz: String = Line.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Line.fields (position), value)
        emitattr (0, Region)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Line rdf:ID=\"%s\">\n%s\t</cim:Line>".format (id, export_fields)
    }
}

object Line
extends
    CIMParseable[Line]
{
    override val fields: Array[String] = Array[String] (
        "Region"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Region", "SubGeographicalRegion", "0..1", "0..*")
    )
    val Region: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): Line =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Line (
            EquipmentContainer.parse (context),
            mask (Region (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

object LineSerializer extends CIMSerializer[Line]
{
    def write (kryo: Kryo, output: Output, obj: Line): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.Region)
        )
        EquipmentContainerSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Line]): Line =
    {
        val parent = EquipmentContainerSerializer.read (kryo, input, classOf[EquipmentContainer])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Line (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A linear shunt compensator has banks or sections with equal admittance values.
 *
 * @param ShuntCompensator [[ch.ninecode.model.ShuntCompensator ShuntCompensator]] Reference to the superclass object.
 * @param b0PerSection Zero sequence shunt (charging) susceptance per section.
 * @param bPerSection Positive sequence shunt (charging) susceptance per section.
 * @param g0PerSection Zero sequence shunt (charging) conductance per section.
 * @param gPerSection Positive sequence shunt (charging) conductance per section.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class LinearShuntCompensator
(
    ShuntCompensator: ShuntCompensator = null,
    b0PerSection: Double = 0.0,
    bPerSection: Double = 0.0,
    g0PerSection: Double = 0.0,
    gPerSection: Double = 0.0
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
        implicit val clz: String = LinearShuntCompensator.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (LinearShuntCompensator.fields (position), value)
        emitelem (0, b0PerSection)
        emitelem (1, bPerSection)
        emitelem (2, g0PerSection)
        emitelem (3, gPerSection)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:LinearShuntCompensator rdf:ID=\"%s\">\n%s\t</cim:LinearShuntCompensator>".format (id, export_fields)
    }
}

object LinearShuntCompensator
extends
    CIMParseable[LinearShuntCompensator]
{
    override val fields: Array[String] = Array[String] (
        "b0PerSection",
        "bPerSection",
        "g0PerSection",
        "gPerSection"
    )
    val b0PerSection: Fielder = parse_element (element (cls, fields(0)))
    val bPerSection: Fielder = parse_element (element (cls, fields(1)))
    val g0PerSection: Fielder = parse_element (element (cls, fields(2)))
    val gPerSection: Fielder = parse_element (element (cls, fields(3)))

    def parse (context: CIMContext): LinearShuntCompensator =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = LinearShuntCompensator (
            ShuntCompensator.parse (context),
            toDouble (mask (b0PerSection (), 0)),
            toDouble (mask (bPerSection (), 1)),
            toDouble (mask (g0PerSection (), 2)),
            toDouble (mask (gPerSection (), 3))
        )
        ret.bitfields = bitfields
        ret
    }
}

object LinearShuntCompensatorSerializer extends CIMSerializer[LinearShuntCompensator]
{
    def write (kryo: Kryo, output: Output, obj: LinearShuntCompensator): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.b0PerSection),
            () => output.writeDouble (obj.bPerSection),
            () => output.writeDouble (obj.g0PerSection),
            () => output.writeDouble (obj.gPerSection)
        )
        ShuntCompensatorSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[LinearShuntCompensator]): LinearShuntCompensator =
    {
        val parent = ShuntCompensatorSerializer.read (kryo, input, classOf[ShuntCompensator])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = LinearShuntCompensator (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A per phase linear shunt compensator has banks or sections with equal admittance values.
 *
 * @param ShuntCompensatorPhase [[ch.ninecode.model.ShuntCompensatorPhase ShuntCompensatorPhase]] Reference to the superclass object.
 * @param bPerSection Susceptance per section of the phase if shunt compensator is wye connected.
 *        Susceptance per section phase to phase if shunt compensator is delta connected.
 * @param gPerSection Conductance per section for this phase if shunt compensator is wye connected.
 *        Conductance per section phase to phase if shunt compensator is delta connected.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class LinearShuntCompensatorPhase
(
    ShuntCompensatorPhase: ShuntCompensatorPhase = null,
    bPerSection: Double = 0.0,
    gPerSection: Double = 0.0
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
    override def sup: ShuntCompensatorPhase = ShuntCompensatorPhase

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
        implicit val clz: String = LinearShuntCompensatorPhase.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (LinearShuntCompensatorPhase.fields (position), value)
        emitelem (0, bPerSection)
        emitelem (1, gPerSection)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:LinearShuntCompensatorPhase rdf:ID=\"%s\">\n%s\t</cim:LinearShuntCompensatorPhase>".format (id, export_fields)
    }
}

object LinearShuntCompensatorPhase
extends
    CIMParseable[LinearShuntCompensatorPhase]
{
    override val fields: Array[String] = Array[String] (
        "bPerSection",
        "gPerSection"
    )
    val bPerSection: Fielder = parse_element (element (cls, fields(0)))
    val gPerSection: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: CIMContext): LinearShuntCompensatorPhase =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = LinearShuntCompensatorPhase (
            ShuntCompensatorPhase.parse (context),
            toDouble (mask (bPerSection (), 0)),
            toDouble (mask (gPerSection (), 1))
        )
        ret.bitfields = bitfields
        ret
    }
}

object LinearShuntCompensatorPhaseSerializer extends CIMSerializer[LinearShuntCompensatorPhase]
{
    def write (kryo: Kryo, output: Output, obj: LinearShuntCompensatorPhase): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.bPerSection),
            () => output.writeDouble (obj.gPerSection)
        )
        ShuntCompensatorPhaseSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[LinearShuntCompensatorPhase]): LinearShuntCompensatorPhase =
    {
        val parent = ShuntCompensatorPhaseSerializer.read (kryo, input, classOf[ShuntCompensatorPhase])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = LinearShuntCompensatorPhase (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A mechanical switching device capable of making, carrying, and breaking currents under normal operating conditions.
 *
 * @param ProtectedSwitch [[ch.ninecode.model.ProtectedSwitch ProtectedSwitch]] Reference to the superclass object.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class LoadBreakSwitch
(
    ProtectedSwitch: ProtectedSwitch = null
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
    override def sup: ProtectedSwitch = ProtectedSwitch

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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:LoadBreakSwitch rdf:ID=\"%s\">\n%s\t</cim:LoadBreakSwitch>".format (id, export_fields)
    }
}

object LoadBreakSwitch
extends
    CIMParseable[LoadBreakSwitch]
{

    def parse (context: CIMContext): LoadBreakSwitch =
    {
        val ret = LoadBreakSwitch (
            ProtectedSwitch.parse (context)
        )
        ret
    }
}

object LoadBreakSwitchSerializer extends CIMSerializer[LoadBreakSwitch]
{
    def write (kryo: Kryo, output: Output, obj: LoadBreakSwitch): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        ProtectedSwitchSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[LoadBreakSwitch]): LoadBreakSwitch =
    {
        val parent = ProtectedSwitchSerializer.read (kryo, input, classOf[ProtectedSwitch])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = LoadBreakSwitch (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * This class represents the zero sequence line mutual coupling.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param b0ch Zero sequence mutual coupling shunt (charging) susceptance, uniformly distributed, of the entire line section.
 * @param distance11 Distance to the start of the coupled region from the first line's terminal having sequence number equal to 1.
 * @param distance12 Distance to the end of the coupled region from the first line's terminal with sequence number equal to 1.
 * @param distance21 Distance to the start of coupled region from the second line's terminal with sequence number equal to 1.
 * @param distance22 Distance to the end of coupled region from the second line's terminal with sequence number equal to 1.
 * @param g0ch Zero sequence mutual coupling shunt (charging) conductance, uniformly distributed, of the entire line section.
 * @param r0 Zero sequence branch-to-branch mutual impedance coupling, resistance.
 * @param x0 Zero sequence branch-to-branch mutual impedance coupling, reactance.
 * @param First_Terminal [[ch.ninecode.model.Terminal Terminal]] The starting terminal for the calculation of distances along the first branch of the mutual coupling.
 *        Normally MutualCoupling would only be used for terminals of AC line segments.  The first and second terminals of a mutual coupling should point to different AC line segments.
 * @param Second_Terminal [[ch.ninecode.model.Terminal Terminal]] The starting terminal for the calculation of distances along the second branch of the mutual coupling.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class MutualCoupling
(
    IdentifiedObject: IdentifiedObject = null,
    b0ch: Double = 0.0,
    distance11: Double = 0.0,
    distance12: Double = 0.0,
    distance21: Double = 0.0,
    distance22: Double = 0.0,
    g0ch: Double = 0.0,
    r0: Double = 0.0,
    x0: Double = 0.0,
    First_Terminal: String = null,
    Second_Terminal: String = null
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
        implicit val clz: String = MutualCoupling.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MutualCoupling.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MutualCoupling.fields (position), value)
        emitelem (0, b0ch)
        emitelem (1, distance11)
        emitelem (2, distance12)
        emitelem (3, distance21)
        emitelem (4, distance22)
        emitelem (5, g0ch)
        emitelem (6, r0)
        emitelem (7, x0)
        emitattr (8, First_Terminal)
        emitattr (9, Second_Terminal)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MutualCoupling rdf:ID=\"%s\">\n%s\t</cim:MutualCoupling>".format (id, export_fields)
    }
}

object MutualCoupling
extends
    CIMParseable[MutualCoupling]
{
    override val fields: Array[String] = Array[String] (
        "b0ch",
        "distance11",
        "distance12",
        "distance21",
        "distance22",
        "g0ch",
        "r0",
        "x0",
        "First_Terminal",
        "Second_Terminal"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("First_Terminal", "Terminal", "1", "0..*"),
        CIMRelationship ("Second_Terminal", "Terminal", "1", "0..*")
    )
    val b0ch: Fielder = parse_element (element (cls, fields(0)))
    val distance11: Fielder = parse_element (element (cls, fields(1)))
    val distance12: Fielder = parse_element (element (cls, fields(2)))
    val distance21: Fielder = parse_element (element (cls, fields(3)))
    val distance22: Fielder = parse_element (element (cls, fields(4)))
    val g0ch: Fielder = parse_element (element (cls, fields(5)))
    val r0: Fielder = parse_element (element (cls, fields(6)))
    val x0: Fielder = parse_element (element (cls, fields(7)))
    val First_Terminal: Fielder = parse_attribute (attribute (cls, fields(8)))
    val Second_Terminal: Fielder = parse_attribute (attribute (cls, fields(9)))

    def parse (context: CIMContext): MutualCoupling =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MutualCoupling (
            IdentifiedObject.parse (context),
            toDouble (mask (b0ch (), 0)),
            toDouble (mask (distance11 (), 1)),
            toDouble (mask (distance12 (), 2)),
            toDouble (mask (distance21 (), 3)),
            toDouble (mask (distance22 (), 4)),
            toDouble (mask (g0ch (), 5)),
            toDouble (mask (r0 (), 6)),
            toDouble (mask (x0 (), 7)),
            mask (First_Terminal (), 8),
            mask (Second_Terminal (), 9)
        )
        ret.bitfields = bitfields
        ret
    }
}

object MutualCouplingSerializer extends CIMSerializer[MutualCoupling]
{
    def write (kryo: Kryo, output: Output, obj: MutualCoupling): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.b0ch),
            () => output.writeDouble (obj.distance11),
            () => output.writeDouble (obj.distance12),
            () => output.writeDouble (obj.distance21),
            () => output.writeDouble (obj.distance22),
            () => output.writeDouble (obj.g0ch),
            () => output.writeDouble (obj.r0),
            () => output.writeDouble (obj.x0),
            () => output.writeString (obj.First_Terminal),
            () => output.writeString (obj.Second_Terminal)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MutualCoupling]): MutualCoupling =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = MutualCoupling (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readDouble else 0.0,
            if (isSet (6)) input.readDouble else 0.0,
            if (isSet (7)) input.readDouble else 0.0,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A non linear shunt compensator has bank or section admittance values that differ.
 *
 * @param ShuntCompensator [[ch.ninecode.model.ShuntCompensator ShuntCompensator]] Reference to the superclass object.
 * @param NonlinearShuntCompensatorPoints [[ch.ninecode.model.NonlinearShuntCompensatorPoint NonlinearShuntCompensatorPoint]] All points of the non-linear shunt compensator.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class NonlinearShuntCompensator
(
    ShuntCompensator: ShuntCompensator = null,
    NonlinearShuntCompensatorPoints: List[String] = null
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
        implicit val clz: String = NonlinearShuntCompensator.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (NonlinearShuntCompensator.fields (position), x))
        emitattrs (0, NonlinearShuntCompensatorPoints)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:NonlinearShuntCompensator rdf:ID=\"%s\">\n%s\t</cim:NonlinearShuntCompensator>".format (id, export_fields)
    }
}

object NonlinearShuntCompensator
extends
    CIMParseable[NonlinearShuntCompensator]
{
    override val fields: Array[String] = Array[String] (
        "NonlinearShuntCompensatorPoints"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("NonlinearShuntCompensatorPoints", "NonlinearShuntCompensatorPoint", "1..*", "1")
    )
    val NonlinearShuntCompensatorPoints: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): NonlinearShuntCompensator =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = NonlinearShuntCompensator (
            ShuntCompensator.parse (context),
            masks (NonlinearShuntCompensatorPoints (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

object NonlinearShuntCompensatorSerializer extends CIMSerializer[NonlinearShuntCompensator]
{
    def write (kryo: Kryo, output: Output, obj: NonlinearShuntCompensator): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.NonlinearShuntCompensatorPoints, output)
        )
        ShuntCompensatorSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[NonlinearShuntCompensator]): NonlinearShuntCompensator =
    {
        val parent = ShuntCompensatorSerializer.read (kryo, input, classOf[ShuntCompensator])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = NonlinearShuntCompensator (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A per phase non linear shunt compensator has bank or section admittance values that differ.
 *
 * @param ShuntCompensatorPhase [[ch.ninecode.model.ShuntCompensatorPhase ShuntCompensatorPhase]] Reference to the superclass object.
 * @param NonlinearShuntCompensatorPhasePoints [[ch.ninecode.model.NonlinearShuntCompensatorPhasePoint NonlinearShuntCompensatorPhasePoint]] All points of the non-linear shunt compensator phase.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class NonlinearShuntCompensatorPhase
(
    ShuntCompensatorPhase: ShuntCompensatorPhase = null,
    NonlinearShuntCompensatorPhasePoints: List[String] = null
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
    override def sup: ShuntCompensatorPhase = ShuntCompensatorPhase

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
        implicit val clz: String = NonlinearShuntCompensatorPhase.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (NonlinearShuntCompensatorPhase.fields (position), x))
        emitattrs (0, NonlinearShuntCompensatorPhasePoints)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:NonlinearShuntCompensatorPhase rdf:ID=\"%s\">\n%s\t</cim:NonlinearShuntCompensatorPhase>".format (id, export_fields)
    }
}

object NonlinearShuntCompensatorPhase
extends
    CIMParseable[NonlinearShuntCompensatorPhase]
{
    override val fields: Array[String] = Array[String] (
        "NonlinearShuntCompensatorPhasePoints"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("NonlinearShuntCompensatorPhasePoints", "NonlinearShuntCompensatorPhasePoint", "1..*", "1")
    )
    val NonlinearShuntCompensatorPhasePoints: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): NonlinearShuntCompensatorPhase =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = NonlinearShuntCompensatorPhase (
            ShuntCompensatorPhase.parse (context),
            masks (NonlinearShuntCompensatorPhasePoints (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

object NonlinearShuntCompensatorPhaseSerializer extends CIMSerializer[NonlinearShuntCompensatorPhase]
{
    def write (kryo: Kryo, output: Output, obj: NonlinearShuntCompensatorPhase): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.NonlinearShuntCompensatorPhasePoints, output)
        )
        ShuntCompensatorPhaseSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[NonlinearShuntCompensatorPhase]): NonlinearShuntCompensatorPhase =
    {
        val parent = ShuntCompensatorPhaseSerializer.read (kryo, input, classOf[ShuntCompensatorPhase])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = NonlinearShuntCompensatorPhase (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A per phase non linear shunt compensator bank or section admittance value.
 *
 * @param Element Reference to the superclass object.
 * @param b Positive sequence shunt (charging) susceptance per section.
 * @param g Positive sequence shunt (charging) conductance per section.
 * @param sectionNumber The number of the section.
 * @param NonlinearShuntCompensatorPhase [[ch.ninecode.model.NonlinearShuntCompensatorPhase NonlinearShuntCompensatorPhase]] Non-linear shunt compensator phase owning this point.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class NonlinearShuntCompensatorPhasePoint
(
    Element: BasicElement = null,
    b: Double = 0.0,
    g: Double = 0.0,
    sectionNumber: Int = 0,
    NonlinearShuntCompensatorPhase: String = null
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
    override def sup: Element = Element

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
        implicit val clz: String = NonlinearShuntCompensatorPhasePoint.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (NonlinearShuntCompensatorPhasePoint.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (NonlinearShuntCompensatorPhasePoint.fields (position), value)
        emitelem (0, b)
        emitelem (1, g)
        emitelem (2, sectionNumber)
        emitattr (3, NonlinearShuntCompensatorPhase)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:NonlinearShuntCompensatorPhasePoint rdf:ID=\"%s\">\n%s\t</cim:NonlinearShuntCompensatorPhasePoint>".format (id, export_fields)
    }
}

object NonlinearShuntCompensatorPhasePoint
extends
    CIMParseable[NonlinearShuntCompensatorPhasePoint]
{
    override val fields: Array[String] = Array[String] (
        "b",
        "g",
        "sectionNumber",
        "NonlinearShuntCompensatorPhase"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("NonlinearShuntCompensatorPhase", "NonlinearShuntCompensatorPhase", "1", "1..*")
    )
    val b: Fielder = parse_element (element (cls, fields(0)))
    val g: Fielder = parse_element (element (cls, fields(1)))
    val sectionNumber: Fielder = parse_element (element (cls, fields(2)))
    val NonlinearShuntCompensatorPhase: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: CIMContext): NonlinearShuntCompensatorPhasePoint =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = NonlinearShuntCompensatorPhasePoint (
            BasicElement.parse (context),
            toDouble (mask (b (), 0)),
            toDouble (mask (g (), 1)),
            toInteger (mask (sectionNumber (), 2)),
            mask (NonlinearShuntCompensatorPhase (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

object NonlinearShuntCompensatorPhasePointSerializer extends CIMSerializer[NonlinearShuntCompensatorPhasePoint]
{
    def write (kryo: Kryo, output: Output, obj: NonlinearShuntCompensatorPhasePoint): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.b),
            () => output.writeDouble (obj.g),
            () => output.writeInt (obj.sectionNumber),
            () => output.writeString (obj.NonlinearShuntCompensatorPhase)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[NonlinearShuntCompensatorPhasePoint]): NonlinearShuntCompensatorPhasePoint =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = NonlinearShuntCompensatorPhasePoint (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readInt else 0,
            if (isSet (3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A non linear shunt compensator bank or section admittance value.
 *
 * @param Element Reference to the superclass object.
 * @param b Positive sequence shunt (charging) susceptance per section.
 * @param b0 Zero sequence shunt (charging) susceptance per section.
 * @param g Positive sequence shunt (charging) conductance per section.
 * @param g0 Zero sequence shunt (charging) conductance per section.
 * @param sectionNumber The number of the section.
 * @param NonlinearShuntCompensator [[ch.ninecode.model.NonlinearShuntCompensator NonlinearShuntCompensator]] Non-linear shunt compensator owning this point.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class NonlinearShuntCompensatorPoint
(
    Element: BasicElement = null,
    b: Double = 0.0,
    b0: Double = 0.0,
    g: Double = 0.0,
    g0: Double = 0.0,
    sectionNumber: Int = 0,
    NonlinearShuntCompensator: String = null
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
    override def sup: Element = Element

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
        implicit val clz: String = NonlinearShuntCompensatorPoint.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (NonlinearShuntCompensatorPoint.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (NonlinearShuntCompensatorPoint.fields (position), value)
        emitelem (0, b)
        emitelem (1, b0)
        emitelem (2, g)
        emitelem (3, g0)
        emitelem (4, sectionNumber)
        emitattr (5, NonlinearShuntCompensator)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:NonlinearShuntCompensatorPoint rdf:ID=\"%s\">\n%s\t</cim:NonlinearShuntCompensatorPoint>".format (id, export_fields)
    }
}

object NonlinearShuntCompensatorPoint
extends
    CIMParseable[NonlinearShuntCompensatorPoint]
{
    override val fields: Array[String] = Array[String] (
        "b",
        "b0",
        "g",
        "g0",
        "sectionNumber",
        "NonlinearShuntCompensator"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("NonlinearShuntCompensator", "NonlinearShuntCompensator", "1", "1..*")
    )
    val b: Fielder = parse_element (element (cls, fields(0)))
    val b0: Fielder = parse_element (element (cls, fields(1)))
    val g: Fielder = parse_element (element (cls, fields(2)))
    val g0: Fielder = parse_element (element (cls, fields(3)))
    val sectionNumber: Fielder = parse_element (element (cls, fields(4)))
    val NonlinearShuntCompensator: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: CIMContext): NonlinearShuntCompensatorPoint =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = NonlinearShuntCompensatorPoint (
            BasicElement.parse (context),
            toDouble (mask (b (), 0)),
            toDouble (mask (b0 (), 1)),
            toDouble (mask (g (), 2)),
            toDouble (mask (g0 (), 3)),
            toInteger (mask (sectionNumber (), 4)),
            mask (NonlinearShuntCompensator (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

object NonlinearShuntCompensatorPointSerializer extends CIMSerializer[NonlinearShuntCompensatorPoint]
{
    def write (kryo: Kryo, output: Output, obj: NonlinearShuntCompensatorPoint): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.b),
            () => output.writeDouble (obj.b0),
            () => output.writeDouble (obj.g),
            () => output.writeDouble (obj.g0),
            () => output.writeInt (obj.sectionNumber),
            () => output.writeString (obj.NonlinearShuntCompensator)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[NonlinearShuntCompensatorPoint]): NonlinearShuntCompensatorPoint =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = NonlinearShuntCompensatorPoint (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readInt else 0,
            if (isSet (5)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Common type for per-length impedance electrical catalogues.
 *
 * @param PerLengthLineParameter [[ch.ninecode.model.PerLengthLineParameter PerLengthLineParameter]] Reference to the superclass object.
 * @param ACLineSegments [[ch.ninecode.model.ACLineSegment ACLineSegment]] All line segments described by this per-length impedance.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class PerLengthImpedance
(
    PerLengthLineParameter: PerLengthLineParameter = null,
    ACLineSegments: List[String] = null
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
    override def sup: PerLengthLineParameter = PerLengthLineParameter

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
        implicit val clz: String = PerLengthImpedance.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (PerLengthImpedance.fields (position), x))
        emitattrs (0, ACLineSegments)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PerLengthImpedance rdf:ID=\"%s\">\n%s\t</cim:PerLengthImpedance>".format (id, export_fields)
    }
}

object PerLengthImpedance
extends
    CIMParseable[PerLengthImpedance]
{
    override val fields: Array[String] = Array[String] (
        "ACLineSegments"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ACLineSegments", "ACLineSegment", "0..*", "0..1")
    )
    val ACLineSegments: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): PerLengthImpedance =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PerLengthImpedance (
            PerLengthLineParameter.parse (context),
            masks (ACLineSegments (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

object PerLengthImpedanceSerializer extends CIMSerializer[PerLengthImpedance]
{
    def write (kryo: Kryo, output: Output, obj: PerLengthImpedance): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.ACLineSegments, output)
        )
        PerLengthLineParameterSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PerLengthImpedance]): PerLengthImpedance =
    {
        val parent = PerLengthLineParameterSerializer.read (kryo, input, classOf[PerLengthLineParameter])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PerLengthImpedance (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Common type for per-length electrical catalogues describing line parameters.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param WireAssemblyInfo [[ch.ninecode.model.WireAssemblyInfo WireAssemblyInfo]] <em>undocumented</em>
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class PerLengthLineParameter
(
    IdentifiedObject: IdentifiedObject = null,
    WireAssemblyInfo: String = null
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
        implicit val clz: String = PerLengthLineParameter.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PerLengthLineParameter.fields (position), value)
        emitattr (0, WireAssemblyInfo)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PerLengthLineParameter rdf:ID=\"%s\">\n%s\t</cim:PerLengthLineParameter>".format (id, export_fields)
    }
}

object PerLengthLineParameter
extends
    CIMParseable[PerLengthLineParameter]
{
    override val fields: Array[String] = Array[String] (
        "WireAssemblyInfo"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("WireAssemblyInfo", "WireAssemblyInfo", "0..1", "0..*")
    )
    val WireAssemblyInfo: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): PerLengthLineParameter =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PerLengthLineParameter (
            IdentifiedObject.parse (context),
            mask (WireAssemblyInfo (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

object PerLengthLineParameterSerializer extends CIMSerializer[PerLengthLineParameter]
{
    def write (kryo: Kryo, output: Output, obj: PerLengthLineParameter): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.WireAssemblyInfo)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PerLengthLineParameter]): PerLengthLineParameter =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PerLengthLineParameter (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Impedance and admittance parameters per unit length for n-wire unbalanced lines, in matrix form.
 *
 * @param PerLengthImpedance [[ch.ninecode.model.PerLengthImpedance PerLengthImpedance]] Reference to the superclass object.
 * @param conductorCount Number of phase, neutral, and other wires retained.
 *        Constrains the number of matrix elements and the phase codes that can be used with this matrix.
 * @param PhaseImpedanceData [[ch.ninecode.model.PhaseImpedanceData PhaseImpedanceData]] All data that belong to this conductor phase impedance.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class PerLengthPhaseImpedance
(
    PerLengthImpedance: PerLengthImpedance = null,
    conductorCount: Int = 0,
    PhaseImpedanceData: List[String] = null
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
    override def sup: PerLengthImpedance = PerLengthImpedance

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
        implicit val clz: String = PerLengthPhaseImpedance.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PerLengthPhaseImpedance.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (PerLengthPhaseImpedance.fields (position), x))
        emitelem (0, conductorCount)
        emitattrs (1, PhaseImpedanceData)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PerLengthPhaseImpedance rdf:ID=\"%s\">\n%s\t</cim:PerLengthPhaseImpedance>".format (id, export_fields)
    }
}

object PerLengthPhaseImpedance
extends
    CIMParseable[PerLengthPhaseImpedance]
{
    override val fields: Array[String] = Array[String] (
        "conductorCount",
        "PhaseImpedanceData"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("PhaseImpedanceData", "PhaseImpedanceData", "1..*", "1")
    )
    val conductorCount: Fielder = parse_element (element (cls, fields(0)))
    val PhaseImpedanceData: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): PerLengthPhaseImpedance =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PerLengthPhaseImpedance (
            PerLengthImpedance.parse (context),
            toInteger (mask (conductorCount (), 0)),
            masks (PhaseImpedanceData (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

object PerLengthPhaseImpedanceSerializer extends CIMSerializer[PerLengthPhaseImpedance]
{
    def write (kryo: Kryo, output: Output, obj: PerLengthPhaseImpedance): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeInt (obj.conductorCount),
            () => writeList (obj.PhaseImpedanceData, output)
        )
        PerLengthImpedanceSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PerLengthPhaseImpedance]): PerLengthPhaseImpedance =
    {
        val parent = PerLengthImpedanceSerializer.read (kryo, input, classOf[PerLengthImpedance])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PerLengthPhaseImpedance (
            parent,
            if (isSet (0)) input.readInt else 0,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Sequence impedance and admittance parameters per unit length, for transposed lines of 1, 2, or 3 phases.
 *
 * For 1-phase lines, define x=x0=xself. For 2-phase lines, define x=xs-xm and x0=xs+xm.
 *
 * @param PerLengthImpedance [[ch.ninecode.model.PerLengthImpedance PerLengthImpedance]] Reference to the superclass object.
 * @param b0ch Zero sequence shunt (charging) susceptance, per unit of length.
 * @param bch Positive sequence shunt (charging) susceptance, per unit of length.
 * @param g0ch Zero sequence shunt (charging) conductance, per unit of length.
 * @param gch Positive sequence shunt (charging) conductance, per unit of length.
 * @param r Positive sequence series resistance, per unit of length.
 * @param r0 Zero sequence series resistance, per unit of length.
 * @param x Positive sequence series reactance, per unit of length.
 * @param x0 Zero sequence series reactance, per unit of length.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class PerLengthSequenceImpedance
(
    PerLengthImpedance: PerLengthImpedance = null,
    b0ch: Double = 0.0,
    bch: Double = 0.0,
    g0ch: Double = 0.0,
    gch: Double = 0.0,
    r: Double = 0.0,
    r0: Double = 0.0,
    x: Double = 0.0,
    x0: Double = 0.0
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
    override def sup: PerLengthImpedance = PerLengthImpedance

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
        implicit val clz: String = PerLengthSequenceImpedance.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PerLengthSequenceImpedance.fields (position), value)
        emitelem (0, b0ch)
        emitelem (1, bch)
        emitelem (2, g0ch)
        emitelem (3, gch)
        emitelem (4, r)
        emitelem (5, r0)
        emitelem (6, x)
        emitelem (7, x0)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PerLengthSequenceImpedance rdf:ID=\"%s\">\n%s\t</cim:PerLengthSequenceImpedance>".format (id, export_fields)
    }
}

object PerLengthSequenceImpedance
extends
    CIMParseable[PerLengthSequenceImpedance]
{
    override val fields: Array[String] = Array[String] (
        "b0ch",
        "bch",
        "g0ch",
        "gch",
        "r",
        "r0",
        "x",
        "x0"
    )
    val b0ch: Fielder = parse_element (element (cls, fields(0)))
    val bch: Fielder = parse_element (element (cls, fields(1)))
    val g0ch: Fielder = parse_element (element (cls, fields(2)))
    val gch: Fielder = parse_element (element (cls, fields(3)))
    val r: Fielder = parse_element (element (cls, fields(4)))
    val r0: Fielder = parse_element (element (cls, fields(5)))
    val x: Fielder = parse_element (element (cls, fields(6)))
    val x0: Fielder = parse_element (element (cls, fields(7)))

    def parse (context: CIMContext): PerLengthSequenceImpedance =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PerLengthSequenceImpedance (
            PerLengthImpedance.parse (context),
            toDouble (mask (b0ch (), 0)),
            toDouble (mask (bch (), 1)),
            toDouble (mask (g0ch (), 2)),
            toDouble (mask (gch (), 3)),
            toDouble (mask (r (), 4)),
            toDouble (mask (r0 (), 5)),
            toDouble (mask (x (), 6)),
            toDouble (mask (x0 (), 7))
        )
        ret.bitfields = bitfields
        ret
    }
}

object PerLengthSequenceImpedanceSerializer extends CIMSerializer[PerLengthSequenceImpedance]
{
    def write (kryo: Kryo, output: Output, obj: PerLengthSequenceImpedance): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.b0ch),
            () => output.writeDouble (obj.bch),
            () => output.writeDouble (obj.g0ch),
            () => output.writeDouble (obj.gch),
            () => output.writeDouble (obj.r),
            () => output.writeDouble (obj.r0),
            () => output.writeDouble (obj.x),
            () => output.writeDouble (obj.x0)
        )
        PerLengthImpedanceSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PerLengthSequenceImpedance]): PerLengthSequenceImpedance =
    {
        val parent = PerLengthImpedanceSerializer.read (kryo, input, classOf[PerLengthImpedance])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PerLengthSequenceImpedance (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readDouble else 0.0,
            if (isSet (6)) input.readDouble else 0.0,
            if (isSet (7)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A variable impedance device normally used to offset line charging during single line faults in an ungrounded section of network.
 *
 * @param EarthFaultCompensator [[ch.ninecode.model.EarthFaultCompensator EarthFaultCompensator]] Reference to the superclass object.
 * @param mode The mode of operation of the Petersen coil.
 * @param nominalU The nominal voltage for which the coil is designed.
 * @param offsetCurrent The offset current that the Petersen coil controller is operating from the resonant point.
 *        This is normally a fixed amount for which the controller is configured and could be positive or negative.  Typically 0 to 60 A depending on voltage and resonance conditions.
 * @param positionCurrent The control current used to control the Petersen coil also known as the position current.
 *        Typically in the range of 20 mA to 200 mA.
 * @param xGroundMax The maximum reactance.
 * @param xGroundMin The minimum reactance.
 * @param xGroundNominal The nominal reactance.
 *        This is the operating point (normally over compensation) that is defined based on the resonance point in the healthy network condition.  The impedance is calculated based on nominal voltage divided by position current.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class PetersenCoil
(
    EarthFaultCompensator: EarthFaultCompensator = null,
    mode: String = null,
    nominalU: Double = 0.0,
    offsetCurrent: Double = 0.0,
    positionCurrent: Double = 0.0,
    xGroundMax: Double = 0.0,
    xGroundMin: Double = 0.0,
    xGroundNominal: Double = 0.0
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
    override def sup: EarthFaultCompensator = EarthFaultCompensator

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
        implicit val clz: String = PetersenCoil.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PetersenCoil.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PetersenCoil.fields (position), value)
        emitattr (0, mode)
        emitelem (1, nominalU)
        emitelem (2, offsetCurrent)
        emitelem (3, positionCurrent)
        emitelem (4, xGroundMax)
        emitelem (5, xGroundMin)
        emitelem (6, xGroundNominal)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PetersenCoil rdf:ID=\"%s\">\n%s\t</cim:PetersenCoil>".format (id, export_fields)
    }
}

object PetersenCoil
extends
    CIMParseable[PetersenCoil]
{
    override val fields: Array[String] = Array[String] (
        "mode",
        "nominalU",
        "offsetCurrent",
        "positionCurrent",
        "xGroundMax",
        "xGroundMin",
        "xGroundNominal"
    )
    val mode: Fielder = parse_attribute (attribute (cls, fields(0)))
    val nominalU: Fielder = parse_element (element (cls, fields(1)))
    val offsetCurrent: Fielder = parse_element (element (cls, fields(2)))
    val positionCurrent: Fielder = parse_element (element (cls, fields(3)))
    val xGroundMax: Fielder = parse_element (element (cls, fields(4)))
    val xGroundMin: Fielder = parse_element (element (cls, fields(5)))
    val xGroundNominal: Fielder = parse_element (element (cls, fields(6)))

    def parse (context: CIMContext): PetersenCoil =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PetersenCoil (
            EarthFaultCompensator.parse (context),
            mask (mode (), 0),
            toDouble (mask (nominalU (), 1)),
            toDouble (mask (offsetCurrent (), 2)),
            toDouble (mask (positionCurrent (), 3)),
            toDouble (mask (xGroundMax (), 4)),
            toDouble (mask (xGroundMin (), 5)),
            toDouble (mask (xGroundNominal (), 6))
        )
        ret.bitfields = bitfields
        ret
    }
}

object PetersenCoilSerializer extends CIMSerializer[PetersenCoil]
{
    def write (kryo: Kryo, output: Output, obj: PetersenCoil): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.mode),
            () => output.writeDouble (obj.nominalU),
            () => output.writeDouble (obj.offsetCurrent),
            () => output.writeDouble (obj.positionCurrent),
            () => output.writeDouble (obj.xGroundMax),
            () => output.writeDouble (obj.xGroundMin),
            () => output.writeDouble (obj.xGroundNominal)
        )
        EarthFaultCompensatorSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PetersenCoil]): PetersenCoil =
    {
        val parent = EarthFaultCompensatorSerializer.read (kryo, input, classOf[EarthFaultCompensator])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PetersenCoil (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readDouble else 0.0,
            if (isSet (6)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Impedance and conductance matrix element values.
 *
 * The diagonal elements are described by the elements having the same toPhase and fromPhase value and the off diagonal elements have different toPhase and fromPhase values.  The matrix can also be stored in symmetric lower triangular format using the row and column attributes, which map to ACLineSegmentPhase.sequenceNumber.
 *
 * @param Element Reference to the superclass object.
 * @param b Susceptance matrix element value, per length of unit.
 * @param column The matrix element’s column number, in the range row to PerLengthPhaseImpedance.conductorCount.
 *        Only the lower triangle needs to be stored. This column number matches ACLineSegmentPhase.sequenceNumber.
 * @param fromPhase Refer to the class description.
 * @param g Conductance matrix element value, per length of unit.
 * @param r Resistance matrix element value, per length of unit.
 * @param row The matrix element’s row number, in the range 1 to PerLengthPhaseImpedance.conductorCount.
 *        Only the lower triangle needs to be stored. This row number matches ACLineSegmentPhase.sequenceNumber.
 * @param toPhase Refer to the class description.
 * @param x Reactance matrix element value, per length of unit.
 * @param PhaseImpedance [[ch.ninecode.model.PerLengthPhaseImpedance PerLengthPhaseImpedance]] Conductor phase impedance to which this data belongs.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class PhaseImpedanceData
(
    Element: BasicElement = null,
    b: Double = 0.0,
    column: Int = 0,
    fromPhase: String = null,
    g: Double = 0.0,
    r: Double = 0.0,
    row: Int = 0,
    toPhase: String = null,
    x: Double = 0.0,
    PhaseImpedance: String = null
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
    override def sup: Element = Element

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
        implicit val clz: String = PhaseImpedanceData.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PhaseImpedanceData.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PhaseImpedanceData.fields (position), value)
        emitelem (0, b)
        emitelem (1, column)
        emitattr (2, fromPhase)
        emitelem (3, g)
        emitelem (4, r)
        emitelem (5, row)
        emitattr (6, toPhase)
        emitelem (7, x)
        emitattr (8, PhaseImpedance)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PhaseImpedanceData rdf:ID=\"%s\">\n%s\t</cim:PhaseImpedanceData>".format (id, export_fields)
    }
}

object PhaseImpedanceData
extends
    CIMParseable[PhaseImpedanceData]
{
    override val fields: Array[String] = Array[String] (
        "b",
        "column",
        "fromPhase",
        "g",
        "r",
        "row",
        "toPhase",
        "x",
        "PhaseImpedance"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("PhaseImpedance", "PerLengthPhaseImpedance", "1", "1..*")
    )
    val b: Fielder = parse_element (element (cls, fields(0)))
    val column: Fielder = parse_element (element (cls, fields(1)))
    val fromPhase: Fielder = parse_attribute (attribute (cls, fields(2)))
    val g: Fielder = parse_element (element (cls, fields(3)))
    val r: Fielder = parse_element (element (cls, fields(4)))
    val row: Fielder = parse_element (element (cls, fields(5)))
    val toPhase: Fielder = parse_attribute (attribute (cls, fields(6)))
    val x: Fielder = parse_element (element (cls, fields(7)))
    val PhaseImpedance: Fielder = parse_attribute (attribute (cls, fields(8)))

    def parse (context: CIMContext): PhaseImpedanceData =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PhaseImpedanceData (
            BasicElement.parse (context),
            toDouble (mask (b (), 0)),
            toInteger (mask (column (), 1)),
            mask (fromPhase (), 2),
            toDouble (mask (g (), 3)),
            toDouble (mask (r (), 4)),
            toInteger (mask (row (), 5)),
            mask (toPhase (), 6),
            toDouble (mask (x (), 7)),
            mask (PhaseImpedance (), 8)
        )
        ret.bitfields = bitfields
        ret
    }
}

object PhaseImpedanceDataSerializer extends CIMSerializer[PhaseImpedanceData]
{
    def write (kryo: Kryo, output: Output, obj: PhaseImpedanceData): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.b),
            () => output.writeInt (obj.column),
            () => output.writeString (obj.fromPhase),
            () => output.writeDouble (obj.g),
            () => output.writeDouble (obj.r),
            () => output.writeInt (obj.row),
            () => output.writeString (obj.toPhase),
            () => output.writeDouble (obj.x),
            () => output.writeString (obj.PhaseImpedance)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PhaseImpedanceData]): PhaseImpedanceData =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PhaseImpedanceData (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readInt else 0,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readInt else 0,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) input.readDouble else 0.0,
            if (isSet (8)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A transformer phase shifting tap model that controls the phase angle difference across the power transformer and potentially the active power flow through the power transformer.
 *
 * This phase tap model may also impact the voltage magnitude.
 *
 * @param TapChanger [[ch.ninecode.model.TapChanger TapChanger]] Reference to the superclass object.
 * @param TransformerEnd [[ch.ninecode.model.TransformerEnd TransformerEnd]] Transformer end to which this phase tap changer belongs.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class PhaseTapChanger
(
    TapChanger: TapChanger = null,
    TransformerEnd: String = null
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
    override def sup: TapChanger = TapChanger

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
        implicit val clz: String = PhaseTapChanger.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PhaseTapChanger.fields (position), value)
        emitattr (0, TransformerEnd)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PhaseTapChanger rdf:ID=\"%s\">\n%s\t</cim:PhaseTapChanger>".format (id, export_fields)
    }
}

object PhaseTapChanger
extends
    CIMParseable[PhaseTapChanger]
{
    override val fields: Array[String] = Array[String] (
        "TransformerEnd"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("TransformerEnd", "TransformerEnd", "1", "0..1")
    )
    val TransformerEnd: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): PhaseTapChanger =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PhaseTapChanger (
            TapChanger.parse (context),
            mask (TransformerEnd (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

object PhaseTapChangerSerializer extends CIMSerializer[PhaseTapChanger]
{
    def write (kryo: Kryo, output: Output, obj: PhaseTapChanger): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.TransformerEnd)
        )
        TapChangerSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PhaseTapChanger]): PhaseTapChanger =
    {
        val parent = TapChangerSerializer.read (kryo, input, classOf[TapChanger])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PhaseTapChanger (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Describes the tap model for an asymmetrical phase shifting transformer in which the difference voltage vector adds to the primary side voltage.
 *
 * The angle between the primary side voltage and the difference voltage is named the winding connection angle. The phase shift depends on both the difference voltage magnitude and the winding connection angle.
 *
 * @param PhaseTapChangerNonLinear [[ch.ninecode.model.PhaseTapChangerNonLinear PhaseTapChangerNonLinear]] Reference to the superclass object.
 * @param windingConnectionAngle The phase angle between the in-phase winding and the out-of -phase winding used for creating phase shift.
 *        The out-of-phase winding produces what is known as the difference voltage.  Setting this angle to 90 degrees is not the same as a symmetrical transformer.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class PhaseTapChangerAsymmetrical
(
    PhaseTapChangerNonLinear: PhaseTapChangerNonLinear = null,
    windingConnectionAngle: Double = 0.0
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
    override def sup: PhaseTapChangerNonLinear = PhaseTapChangerNonLinear

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
        implicit val clz: String = PhaseTapChangerAsymmetrical.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PhaseTapChangerAsymmetrical.fields (position), value)
        emitelem (0, windingConnectionAngle)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PhaseTapChangerAsymmetrical rdf:ID=\"%s\">\n%s\t</cim:PhaseTapChangerAsymmetrical>".format (id, export_fields)
    }
}

object PhaseTapChangerAsymmetrical
extends
    CIMParseable[PhaseTapChangerAsymmetrical]
{
    override val fields: Array[String] = Array[String] (
        "windingConnectionAngle"
    )
    val windingConnectionAngle: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: CIMContext): PhaseTapChangerAsymmetrical =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PhaseTapChangerAsymmetrical (
            PhaseTapChangerNonLinear.parse (context),
            toDouble (mask (windingConnectionAngle (), 0))
        )
        ret.bitfields = bitfields
        ret
    }
}

object PhaseTapChangerAsymmetricalSerializer extends CIMSerializer[PhaseTapChangerAsymmetrical]
{
    def write (kryo: Kryo, output: Output, obj: PhaseTapChangerAsymmetrical): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.windingConnectionAngle)
        )
        PhaseTapChangerNonLinearSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PhaseTapChangerAsymmetrical]): PhaseTapChangerAsymmetrical =
    {
        val parent = PhaseTapChangerNonLinearSerializer.read (kryo, input, classOf[PhaseTapChangerNonLinear])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PhaseTapChangerAsymmetrical (
            parent,
            if (isSet (0)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Describes a tap changer with a linear relation between the tap step and the phase angle difference across the transformer.
 *
 * This is a mathematical model that is an approximation of a real phase tap changer.
 * The phase angle is computed as stepPhaseShiftIncrement times the tap position.
 * The secondary side voltage magnitude is the same as at the primary side.
 *
 * @param PhaseTapChanger [[ch.ninecode.model.PhaseTapChanger PhaseTapChanger]] Reference to the superclass object.
 * @param stepPhaseShiftIncrement Phase shift per step position.
 *        A positive value indicates a positive phase shift from the winding where the tap is located to the other winding (for a two-winding transformer).
 *        The actual phase shift increment might be more accurately computed from the symmetrical or asymmetrical models or a tap step table lookup if those are available.
 * @param xMax The reactance depends on the tap position according to a "u" shaped curve.
 *        The maximum reactance (xMax) appears at the low and high tap positions.
 * @param xMin The reactance depends on the tap position according to a "u" shaped curve.
 *        The minimum reactance (xMin) appears at the mid tap position.  PowerTransformerEnd.x shall be consistent with PhaseTapChangerLinear.xMin and PhaseTapChangerNonLinear.xMin. In case of inconsistency, PowerTransformerEnd.x shall be used.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class PhaseTapChangerLinear
(
    PhaseTapChanger: PhaseTapChanger = null,
    stepPhaseShiftIncrement: Double = 0.0,
    xMax: Double = 0.0,
    xMin: Double = 0.0
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
    override def sup: PhaseTapChanger = PhaseTapChanger

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
        implicit val clz: String = PhaseTapChangerLinear.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PhaseTapChangerLinear.fields (position), value)
        emitelem (0, stepPhaseShiftIncrement)
        emitelem (1, xMax)
        emitelem (2, xMin)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PhaseTapChangerLinear rdf:ID=\"%s\">\n%s\t</cim:PhaseTapChangerLinear>".format (id, export_fields)
    }
}

object PhaseTapChangerLinear
extends
    CIMParseable[PhaseTapChangerLinear]
{
    override val fields: Array[String] = Array[String] (
        "stepPhaseShiftIncrement",
        "xMax",
        "xMin"
    )
    val stepPhaseShiftIncrement: Fielder = parse_element (element (cls, fields(0)))
    val xMax: Fielder = parse_element (element (cls, fields(1)))
    val xMin: Fielder = parse_element (element (cls, fields(2)))

    def parse (context: CIMContext): PhaseTapChangerLinear =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PhaseTapChangerLinear (
            PhaseTapChanger.parse (context),
            toDouble (mask (stepPhaseShiftIncrement (), 0)),
            toDouble (mask (xMax (), 1)),
            toDouble (mask (xMin (), 2))
        )
        ret.bitfields = bitfields
        ret
    }
}

object PhaseTapChangerLinearSerializer extends CIMSerializer[PhaseTapChangerLinear]
{
    def write (kryo: Kryo, output: Output, obj: PhaseTapChangerLinear): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.stepPhaseShiftIncrement),
            () => output.writeDouble (obj.xMax),
            () => output.writeDouble (obj.xMin)
        )
        PhaseTapChangerSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PhaseTapChangerLinear]): PhaseTapChangerLinear =
    {
        val parent = PhaseTapChangerSerializer.read (kryo, input, classOf[PhaseTapChanger])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PhaseTapChangerLinear (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The non-linear phase tap changer describes the non-linear behaviour of a phase tap changer.
 *
 * This is a base class for the symmetrical and asymmetrical phase tap changer models. The details of these models can be found in IEC 61970-301.
 *
 * @param PhaseTapChanger [[ch.ninecode.model.PhaseTapChanger PhaseTapChanger]] Reference to the superclass object.
 * @param voltageStepIncrement The voltage step increment on the out of phase winding specified in percent of rated voltage of the power transformer end.
 *        When the increment is negative, the voltage decreases when the tap step increases.
 * @param xMax The reactance depend on the tap position according to a "u" shaped curve.
 *        The maximum reactance (xMax) appear at the low and high tap positions.
 * @param xMin The reactance depend on the tap position according to a "u" shaped curve.
 *        The minimum reactance (xMin) appear at the mid tap position.   PowerTransformerEnd.x shall be consistent with PhaseTapChangerLinear.xMin and PhaseTapChangerNonLinear.xMin. In case of inconsistency, PowerTransformerEnd.x shall be used.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class PhaseTapChangerNonLinear
(
    PhaseTapChanger: PhaseTapChanger = null,
    voltageStepIncrement: Double = 0.0,
    xMax: Double = 0.0,
    xMin: Double = 0.0
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
    override def sup: PhaseTapChanger = PhaseTapChanger

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
        implicit val clz: String = PhaseTapChangerNonLinear.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PhaseTapChangerNonLinear.fields (position), value)
        emitelem (0, voltageStepIncrement)
        emitelem (1, xMax)
        emitelem (2, xMin)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PhaseTapChangerNonLinear rdf:ID=\"%s\">\n%s\t</cim:PhaseTapChangerNonLinear>".format (id, export_fields)
    }
}

object PhaseTapChangerNonLinear
extends
    CIMParseable[PhaseTapChangerNonLinear]
{
    override val fields: Array[String] = Array[String] (
        "voltageStepIncrement",
        "xMax",
        "xMin"
    )
    val voltageStepIncrement: Fielder = parse_element (element (cls, fields(0)))
    val xMax: Fielder = parse_element (element (cls, fields(1)))
    val xMin: Fielder = parse_element (element (cls, fields(2)))

    def parse (context: CIMContext): PhaseTapChangerNonLinear =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PhaseTapChangerNonLinear (
            PhaseTapChanger.parse (context),
            toDouble (mask (voltageStepIncrement (), 0)),
            toDouble (mask (xMax (), 1)),
            toDouble (mask (xMin (), 2))
        )
        ret.bitfields = bitfields
        ret
    }
}

object PhaseTapChangerNonLinearSerializer extends CIMSerializer[PhaseTapChangerNonLinear]
{
    def write (kryo: Kryo, output: Output, obj: PhaseTapChangerNonLinear): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.voltageStepIncrement),
            () => output.writeDouble (obj.xMax),
            () => output.writeDouble (obj.xMin)
        )
        PhaseTapChangerSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PhaseTapChangerNonLinear]): PhaseTapChangerNonLinear =
    {
        val parent = PhaseTapChangerSerializer.read (kryo, input, classOf[PhaseTapChanger])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PhaseTapChangerNonLinear (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Describes a symmetrical phase shifting transformer tap model in which the secondary side voltage magnitude is the same as at the primary side.
 *
 * The difference voltage magnitude is the base in an equal-sided triangle where the sides corresponds to the primary and secondary voltages. The phase angle difference corresponds to the top angle and can be expressed as twice the arctangent of half the total difference voltage.
 *
 * @param PhaseTapChangerNonLinear [[ch.ninecode.model.PhaseTapChangerNonLinear PhaseTapChangerNonLinear]] Reference to the superclass object.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class PhaseTapChangerSymmetrical
(
    PhaseTapChangerNonLinear: PhaseTapChangerNonLinear = null
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
    override def sup: PhaseTapChangerNonLinear = PhaseTapChangerNonLinear

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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:PhaseTapChangerSymmetrical rdf:ID=\"%s\">\n%s\t</cim:PhaseTapChangerSymmetrical>".format (id, export_fields)
    }
}

object PhaseTapChangerSymmetrical
extends
    CIMParseable[PhaseTapChangerSymmetrical]
{

    def parse (context: CIMContext): PhaseTapChangerSymmetrical =
    {
        val ret = PhaseTapChangerSymmetrical (
            PhaseTapChangerNonLinear.parse (context)
        )
        ret
    }
}

object PhaseTapChangerSymmetricalSerializer extends CIMSerializer[PhaseTapChangerSymmetrical]
{
    def write (kryo: Kryo, output: Output, obj: PhaseTapChangerSymmetrical): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        PhaseTapChangerNonLinearSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PhaseTapChangerSymmetrical]): PhaseTapChangerSymmetrical =
    {
        val parent = PhaseTapChangerNonLinearSerializer.read (kryo, input, classOf[PhaseTapChangerNonLinear])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PhaseTapChangerSymmetrical (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Describes a tabular curve for how the phase angle difference and impedance varies with the tap step.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param PhaseTapChangerTablePoint [[ch.ninecode.model.PhaseTapChangerTablePoint PhaseTapChangerTablePoint]] The points of this table.
 * @param PhaseTapChangerTabular [[ch.ninecode.model.PhaseTapChangerTabular PhaseTapChangerTabular]] The phase tap changers to which this phase tap table applies.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class PhaseTapChangerTable
(
    IdentifiedObject: IdentifiedObject = null,
    PhaseTapChangerTablePoint: List[String] = null,
    PhaseTapChangerTabular: List[String] = null
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
        implicit val clz: String = PhaseTapChangerTable.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (PhaseTapChangerTable.fields (position), x))
        emitattrs (0, PhaseTapChangerTablePoint)
        emitattrs (1, PhaseTapChangerTabular)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PhaseTapChangerTable rdf:ID=\"%s\">\n%s\t</cim:PhaseTapChangerTable>".format (id, export_fields)
    }
}

object PhaseTapChangerTable
extends
    CIMParseable[PhaseTapChangerTable]
{
    override val fields: Array[String] = Array[String] (
        "PhaseTapChangerTablePoint",
        "PhaseTapChangerTabular"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("PhaseTapChangerTablePoint", "PhaseTapChangerTablePoint", "1..*", "1"),
        CIMRelationship ("PhaseTapChangerTabular", "PhaseTapChangerTabular", "0..*", "0..1")
    )
    val PhaseTapChangerTablePoint: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val PhaseTapChangerTabular: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): PhaseTapChangerTable =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PhaseTapChangerTable (
            IdentifiedObject.parse (context),
            masks (PhaseTapChangerTablePoint (), 0),
            masks (PhaseTapChangerTabular (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

object PhaseTapChangerTableSerializer extends CIMSerializer[PhaseTapChangerTable]
{
    def write (kryo: Kryo, output: Output, obj: PhaseTapChangerTable): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.PhaseTapChangerTablePoint, output),
            () => writeList (obj.PhaseTapChangerTabular, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PhaseTapChangerTable]): PhaseTapChangerTable =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PhaseTapChangerTable (
            parent,
            if (isSet (0)) readList (input) else null,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Describes each tap step in the phase tap changer tabular curve.
 *
 * @param TapChangerTablePoint [[ch.ninecode.model.TapChangerTablePoint TapChangerTablePoint]] Reference to the superclass object.
 * @param angle The angle difference in degrees.
 *        A positive value indicates a positive phase shift from the winding where the tap is located to the other winding (for a two-winding transformer).
 * @param PhaseTapChangerTable [[ch.ninecode.model.PhaseTapChangerTable PhaseTapChangerTable]] The table of this point.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class PhaseTapChangerTablePoint
(
    TapChangerTablePoint: TapChangerTablePoint = null,
    angle: Double = 0.0,
    PhaseTapChangerTable: String = null
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
    override def sup: TapChangerTablePoint = TapChangerTablePoint

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
        implicit val clz: String = PhaseTapChangerTablePoint.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PhaseTapChangerTablePoint.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PhaseTapChangerTablePoint.fields (position), value)
        emitelem (0, angle)
        emitattr (1, PhaseTapChangerTable)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PhaseTapChangerTablePoint rdf:ID=\"%s\">\n%s\t</cim:PhaseTapChangerTablePoint>".format (id, export_fields)
    }
}

object PhaseTapChangerTablePoint
extends
    CIMParseable[PhaseTapChangerTablePoint]
{
    override val fields: Array[String] = Array[String] (
        "angle",
        "PhaseTapChangerTable"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("PhaseTapChangerTable", "PhaseTapChangerTable", "1", "1..*")
    )
    val angle: Fielder = parse_element (element (cls, fields(0)))
    val PhaseTapChangerTable: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): PhaseTapChangerTablePoint =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PhaseTapChangerTablePoint (
            TapChangerTablePoint.parse (context),
            toDouble (mask (angle (), 0)),
            mask (PhaseTapChangerTable (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

object PhaseTapChangerTablePointSerializer extends CIMSerializer[PhaseTapChangerTablePoint]
{
    def write (kryo: Kryo, output: Output, obj: PhaseTapChangerTablePoint): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.angle),
            () => output.writeString (obj.PhaseTapChangerTable)
        )
        TapChangerTablePointSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PhaseTapChangerTablePoint]): PhaseTapChangerTablePoint =
    {
        val parent = TapChangerTablePointSerializer.read (kryo, input, classOf[TapChangerTablePoint])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PhaseTapChangerTablePoint (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Describes a tap changer with a table defining the relation between the tap step and the phase angle difference across the transformer.
 *
 * @param PhaseTapChanger [[ch.ninecode.model.PhaseTapChanger PhaseTapChanger]] Reference to the superclass object.
 * @param PhaseTapChangerTable [[ch.ninecode.model.PhaseTapChangerTable PhaseTapChangerTable]] The phase tap changer table for this phase tap changer.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class PhaseTapChangerTabular
(
    PhaseTapChanger: PhaseTapChanger = null,
    PhaseTapChangerTable: String = null
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
    override def sup: PhaseTapChanger = PhaseTapChanger

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
        implicit val clz: String = PhaseTapChangerTabular.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PhaseTapChangerTabular.fields (position), value)
        emitattr (0, PhaseTapChangerTable)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PhaseTapChangerTabular rdf:ID=\"%s\">\n%s\t</cim:PhaseTapChangerTabular>".format (id, export_fields)
    }
}

object PhaseTapChangerTabular
extends
    CIMParseable[PhaseTapChangerTabular]
{
    override val fields: Array[String] = Array[String] (
        "PhaseTapChangerTable"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("PhaseTapChangerTable", "PhaseTapChangerTable", "0..1", "0..*")
    )
    val PhaseTapChangerTable: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): PhaseTapChangerTabular =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PhaseTapChangerTabular (
            PhaseTapChanger.parse (context),
            mask (PhaseTapChangerTable (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

object PhaseTapChangerTabularSerializer extends CIMSerializer[PhaseTapChangerTabular]
{
    def write (kryo: Kryo, output: Output, obj: PhaseTapChangerTabular): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.PhaseTapChangerTable)
        )
        PhaseTapChangerSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PhaseTapChangerTabular]): PhaseTapChangerTabular =
    {
        val parent = PhaseTapChangerSerializer.read (kryo, input, classOf[PhaseTapChanger])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PhaseTapChangerTabular (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A Plant is a collection of equipment for purposes of generation.
 *
 * @param EquipmentContainer [[ch.ninecode.model.EquipmentContainer EquipmentContainer]] Reference to the superclass object.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class Plant
(
    EquipmentContainer: EquipmentContainer = null
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
    override def sup: EquipmentContainer = EquipmentContainer

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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:Plant rdf:ID=\"%s\">\n%s\t</cim:Plant>".format (id, export_fields)
    }
}

object Plant
extends
    CIMParseable[Plant]
{

    def parse (context: CIMContext): Plant =
    {
        val ret = Plant (
            EquipmentContainer.parse (context)
        )
        ret
    }
}

object PlantSerializer extends CIMSerializer[Plant]
{
    def write (kryo: Kryo, output: Output, obj: Plant): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        EquipmentContainerSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Plant]): Plant =
    {
        val parent = EquipmentContainerSerializer.read (kryo, input, classOf[EquipmentContainer])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Plant (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A connection to the AC network for energy production or consumption that uses power electronics rather than rotating machines.
 *
 * @param RegulatingCondEq [[ch.ninecode.model.RegulatingCondEq RegulatingCondEq]] Reference to the superclass object.
 * @param maxIFault Maximum fault current this device will contribute, in per-unit of rated current, before the converter protection will trip or bypass.
 * @param maxQ Maximum reactive power limit.
 *        This is the maximum (nameplate) limit for the unit.
 * @param minQ Minimum reactive power limit for the unit.
 *        This is the minimum (nameplate) limit for the unit.
 * @param p Active power injection.
 *        Load sign convention is used, i.e. positive sign means flow out from a node.
 *        Starting value for a steady state solution.
 * @param q Reactive power injection.
 *        Load sign convention is used, i.e. positive sign means flow out from a node.
 *        Starting value for a steady state solution.
 * @param r Equivalent resistance (RG) of generator.
 *        RG is considered for the calculation of all currents, except for the calculation of the peak current ip. Used for short circuit data exchange according to IEC 60909.
 * @param r0 Zero sequence resistance of the synchronous machine.
 * @param ratedS Nameplate apparent power rating for the unit.
 *        The attribute shall have a positive value.
 * @param ratedU Rated voltage (nameplate data, Ur in IEC 60909-0).
 *        It is primarily used for short circuit data exchange according to IEC 60909.
 * @param rn Negative sequence Thevenin resistance.
 * @param x Positive sequence Thevenin reactance.
 * @param x0 Zero sequence Thevenin reactance.
 * @param xn Negative sequence Thevenin reactance.
 * @param PowerElectronicsConnectionPhase [[ch.ninecode.model.PowerElectronicsConnectionPhase PowerElectronicsConnectionPhase]] The individual phases models for the power electronics connection.
 * @param PowerElectronicsUnit [[ch.ninecode.model.PowerElectronicsUnit PowerElectronicsUnit]] An AC network connection may have several power electronics units connecting through it.
 * @param WindTurbineType3or4Dynamics [[ch.ninecode.model.WindTurbineType3or4Dynamics WindTurbineType3or4Dynamics]] The wind turbine type 3 or type 4 dynamics model associated with this power electronics connection.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class PowerElectronicsConnection
(
    RegulatingCondEq: RegulatingCondEq = null,
    maxIFault: Double = 0.0,
    maxQ: Double = 0.0,
    minQ: Double = 0.0,
    p: Double = 0.0,
    q: Double = 0.0,
    r: Double = 0.0,
    r0: Double = 0.0,
    ratedS: Double = 0.0,
    ratedU: Double = 0.0,
    rn: Double = 0.0,
    x: Double = 0.0,
    x0: Double = 0.0,
    xn: Double = 0.0,
    PowerElectronicsConnectionPhase: List[String] = null,
    PowerElectronicsUnit: List[String] = null,
    WindTurbineType3or4Dynamics: String = null
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
    override def sup: RegulatingCondEq = RegulatingCondEq

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
        implicit val clz: String = PowerElectronicsConnection.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PowerElectronicsConnection.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PowerElectronicsConnection.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (PowerElectronicsConnection.fields (position), x))
        emitelem (0, maxIFault)
        emitelem (1, maxQ)
        emitelem (2, minQ)
        emitelem (3, p)
        emitelem (4, q)
        emitelem (5, r)
        emitelem (6, r0)
        emitelem (7, ratedS)
        emitelem (8, ratedU)
        emitelem (9, rn)
        emitelem (10, x)
        emitelem (11, x0)
        emitelem (12, xn)
        emitattrs (13, PowerElectronicsConnectionPhase)
        emitattrs (14, PowerElectronicsUnit)
        emitattr (15, WindTurbineType3or4Dynamics)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PowerElectronicsConnection rdf:ID=\"%s\">\n%s\t</cim:PowerElectronicsConnection>".format (id, export_fields)
    }
}

object PowerElectronicsConnection
extends
    CIMParseable[PowerElectronicsConnection]
{
    override val fields: Array[String] = Array[String] (
        "maxIFault",
        "maxQ",
        "minQ",
        "p",
        "q",
        "r",
        "r0",
        "ratedS",
        "ratedU",
        "rn",
        "x",
        "x0",
        "xn",
        "PowerElectronicsConnectionPhase",
        "PowerElectronicsUnit",
        "WindTurbineType3or4Dynamics"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("PowerElectronicsConnectionPhase", "PowerElectronicsConnectionPhase", "0..*", "1"),
        CIMRelationship ("PowerElectronicsUnit", "PowerElectronicsUnit", "0..*", "1"),
        CIMRelationship ("WindTurbineType3or4Dynamics", "WindTurbineType3or4Dynamics", "0..1", "1")
    )
    val maxIFault: Fielder = parse_element (element (cls, fields(0)))
    val maxQ: Fielder = parse_element (element (cls, fields(1)))
    val minQ: Fielder = parse_element (element (cls, fields(2)))
    val p: Fielder = parse_element (element (cls, fields(3)))
    val q: Fielder = parse_element (element (cls, fields(4)))
    val r: Fielder = parse_element (element (cls, fields(5)))
    val r0: Fielder = parse_element (element (cls, fields(6)))
    val ratedS: Fielder = parse_element (element (cls, fields(7)))
    val ratedU: Fielder = parse_element (element (cls, fields(8)))
    val rn: Fielder = parse_element (element (cls, fields(9)))
    val x: Fielder = parse_element (element (cls, fields(10)))
    val x0: Fielder = parse_element (element (cls, fields(11)))
    val xn: Fielder = parse_element (element (cls, fields(12)))
    val PowerElectronicsConnectionPhase: FielderMultiple = parse_attributes (attribute (cls, fields(13)))
    val PowerElectronicsUnit: FielderMultiple = parse_attributes (attribute (cls, fields(14)))
    val WindTurbineType3or4Dynamics: Fielder = parse_attribute (attribute (cls, fields(15)))

    def parse (context: CIMContext): PowerElectronicsConnection =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PowerElectronicsConnection (
            RegulatingCondEq.parse (context),
            toDouble (mask (maxIFault (), 0)),
            toDouble (mask (maxQ (), 1)),
            toDouble (mask (minQ (), 2)),
            toDouble (mask (p (), 3)),
            toDouble (mask (q (), 4)),
            toDouble (mask (r (), 5)),
            toDouble (mask (r0 (), 6)),
            toDouble (mask (ratedS (), 7)),
            toDouble (mask (ratedU (), 8)),
            toDouble (mask (rn (), 9)),
            toDouble (mask (x (), 10)),
            toDouble (mask (x0 (), 11)),
            toDouble (mask (xn (), 12)),
            masks (PowerElectronicsConnectionPhase (), 13),
            masks (PowerElectronicsUnit (), 14),
            mask (WindTurbineType3or4Dynamics (), 15)
        )
        ret.bitfields = bitfields
        ret
    }
}

object PowerElectronicsConnectionSerializer extends CIMSerializer[PowerElectronicsConnection]
{
    def write (kryo: Kryo, output: Output, obj: PowerElectronicsConnection): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.maxIFault),
            () => output.writeDouble (obj.maxQ),
            () => output.writeDouble (obj.minQ),
            () => output.writeDouble (obj.p),
            () => output.writeDouble (obj.q),
            () => output.writeDouble (obj.r),
            () => output.writeDouble (obj.r0),
            () => output.writeDouble (obj.ratedS),
            () => output.writeDouble (obj.ratedU),
            () => output.writeDouble (obj.rn),
            () => output.writeDouble (obj.x),
            () => output.writeDouble (obj.x0),
            () => output.writeDouble (obj.xn),
            () => writeList (obj.PowerElectronicsConnectionPhase, output),
            () => writeList (obj.PowerElectronicsUnit, output),
            () => output.writeString (obj.WindTurbineType3or4Dynamics)
        )
        RegulatingCondEqSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PowerElectronicsConnection]): PowerElectronicsConnection =
    {
        val parent = RegulatingCondEqSerializer.read (kryo, input, classOf[RegulatingCondEq])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PowerElectronicsConnection (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readDouble else 0.0,
            if (isSet (6)) input.readDouble else 0.0,
            if (isSet (7)) input.readDouble else 0.0,
            if (isSet (8)) input.readDouble else 0.0,
            if (isSet (9)) input.readDouble else 0.0,
            if (isSet (10)) input.readDouble else 0.0,
            if (isSet (11)) input.readDouble else 0.0,
            if (isSet (12)) input.readDouble else 0.0,
            if (isSet (13)) readList (input) else null,
            if (isSet (14)) readList (input) else null,
            if (isSet (15)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A single phase of a power electronics connection.
 *
 * @param PowerSystemResource [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param p Active power injection.
 *        Load sign convention is used, i.e. positive sign means flow into the equipment from the network.
 * @param phase Phase of this energy producer component.
 *        If the energy producer is wye connected, the connection is from the indicated phase to the central ground or neutral point.  If the energy producer is delta connected, the phase indicates an energy producer connected from the indicated phase to the next logical non-neutral phase.
 * @param q Reactive power injection.
 *        Load sign convention is used, i.e. positive sign means flow into the equipment from the network.
 * @param PowerElectronicsConnection [[ch.ninecode.model.PowerElectronicsConnection PowerElectronicsConnection]] Power electronics connection of this power electronics connection phase.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class PowerElectronicsConnectionPhase
(
    PowerSystemResource: PowerSystemResource = null,
    p: Double = 0.0,
    phase: String = null,
    q: Double = 0.0,
    PowerElectronicsConnection: String = null
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
        implicit val clz: String = PowerElectronicsConnectionPhase.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PowerElectronicsConnectionPhase.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PowerElectronicsConnectionPhase.fields (position), value)
        emitelem (0, p)
        emitattr (1, phase)
        emitelem (2, q)
        emitattr (3, PowerElectronicsConnection)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PowerElectronicsConnectionPhase rdf:ID=\"%s\">\n%s\t</cim:PowerElectronicsConnectionPhase>".format (id, export_fields)
    }
}

object PowerElectronicsConnectionPhase
extends
    CIMParseable[PowerElectronicsConnectionPhase]
{
    override val fields: Array[String] = Array[String] (
        "p",
        "phase",
        "q",
        "PowerElectronicsConnection"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("PowerElectronicsConnection", "PowerElectronicsConnection", "1", "0..*")
    )
    val p: Fielder = parse_element (element (cls, fields(0)))
    val phase: Fielder = parse_attribute (attribute (cls, fields(1)))
    val q: Fielder = parse_element (element (cls, fields(2)))
    val PowerElectronicsConnection: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: CIMContext): PowerElectronicsConnectionPhase =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PowerElectronicsConnectionPhase (
            PowerSystemResource.parse (context),
            toDouble (mask (p (), 0)),
            mask (phase (), 1),
            toDouble (mask (q (), 2)),
            mask (PowerElectronicsConnection (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

object PowerElectronicsConnectionPhaseSerializer extends CIMSerializer[PowerElectronicsConnectionPhase]
{
    def write (kryo: Kryo, output: Output, obj: PowerElectronicsConnectionPhase): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.p),
            () => output.writeString (obj.phase),
            () => output.writeDouble (obj.q),
            () => output.writeString (obj.PowerElectronicsConnection)
        )
        PowerSystemResourceSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PowerElectronicsConnectionPhase]): PowerElectronicsConnectionPhase =
    {
        val parent = PowerSystemResourceSerializer.read (kryo, input, classOf[PowerSystemResource])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PowerElectronicsConnectionPhase (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * An electrical device consisting of  two or more coupled windings, with or without a magnetic core, for introducing mutual coupling between electric circuits.
 *
 * Transformers can be used to control voltage and phase shift (active power flow).
 * A power transformer may be composed of separate transformer tanks that need not be identical.
 * A power transformer can be modelled with or without tanks and is intended for use in both balanced and unbalanced representations.   A power transformer typically has two terminals, but may have one (grounding), three or more terminals.
 * The inherited association ConductingEquipment.BaseVoltage should not be used.  The association from TransformerEnd to BaseVoltage should be used instead.
 *
 * @param ConductingEquipment [[ch.ninecode.model.ConductingEquipment ConductingEquipment]] Reference to the superclass object.
 * @param beforeShCircuitHighestOperatingCurrent The highest operating current (Ib in IEC 60909-0) before short circuit (depends on network configuration and relevant reliability philosophy).
 *        It is used for calculation of the impedance correction factor KT defined in IEC 60909-0.
 * @param beforeShCircuitHighestOperatingVoltage The highest operating voltage (Ub in IEC 60909-0) before short circuit.
 *        It is used for calculation of the impedance correction factor KT defined in IEC 60909-0. This is worst case voltage on the low side winding (3.7.1 of IEC 60909:2001). Used to define operating conditions.
 * @param beforeShortCircuitAnglePf The angle of power factor before short circuit (phib in IEC 60909-0).
 *        It is used for calculation of the impedance correction factor KT defined in IEC 60909-0. This is the worst case power factor. Used to define operating conditions.
 * @param highSideMinOperatingU The minimum operating voltage (uQmin in IEC 60909-0) at the high voltage side (Q side) of the unit transformer of the power station unit.
 *        A value well established from long-term operating experience of the system. It is used for calculation of the impedance correction factor KG defined in IEC 60909-0.
 * @param isPartOfGeneratorUnit Indicates whether the machine is part of a power station unit.
 *        Used for short circuit data exchange according to IEC 60909.  It has an impact on how the correction factors are calculated for transformers, since the transformer is not necessarily part of a synchronous machine and generating unit. It is not always possible to derive this information from the model. This is why the attribute is necessary.
 * @param operationalValuesConsidered It is used to define if the data (other attributes related to short circuit data exchange) defines long term operational conditions or not.
 *        Used for short circuit data exchange according to IEC 60909.
 * @param vectorGroup Vector group of the transformer for protective relaying, e.g., Dyn1.
 *        For unbalanced transformers, this may not be simply determined from the constituent winding connections and phase angle displacements.
 *        
 *        The vectorGroup string consists of the following components in the order listed: high voltage winding connection, mid voltage winding connection (for three winding transformers), phase displacement clock number from 0 to 11,  low voltage winding connection
 *        phase displacement clock number from 0 to 11.   The winding connections are D (delta), Y (wye), YN (wye with neutral), Z (zigzag), ZN (zigzag with neutral), A (auto transformer). Upper case means the high voltage, lower case mid or low. The high voltage winding always has clock position 0 and is not included in the vector group string.  Some examples: YNy0 (two winding wye to wye with no phase displacement), YNd11 (two winding wye to delta with 330 degrees phase displacement), YNyn0d5 (three winding transformer wye with neutral high voltage, wye with neutral mid voltage and no phase displacement, delta low voltage with 150 degrees displacement).
 *        
 *        Phase displacement is defined as the angular difference between the phasors representing the voltages between the neutral point (real or imaginary) and the corresponding terminals of two windings, a positive sequence voltage system being applied to the high-voltage terminals, following each other in alphabetical sequence if they are lettered, or in numerical sequence if they are numbered: the phasors are assumed to rotate in a counter-clockwise sense.
 * @param PowerTransformerEnd [[ch.ninecode.model.PowerTransformerEnd PowerTransformerEnd]] The ends of this power transformer.
 * @param TransformerTanks [[ch.ninecode.model.TransformerTank TransformerTank]] All transformers that belong to this bank.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class PowerTransformer
(
    ConductingEquipment: ConductingEquipment = null,
    beforeShCircuitHighestOperatingCurrent: Double = 0.0,
    beforeShCircuitHighestOperatingVoltage: Double = 0.0,
    beforeShortCircuitAnglePf: Double = 0.0,
    highSideMinOperatingU: Double = 0.0,
    isPartOfGeneratorUnit: Boolean = false,
    operationalValuesConsidered: Boolean = false,
    vectorGroup: String = null,
    PowerTransformerEnd: List[String] = null,
    TransformerTanks: List[String] = null
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
    override def sup: ConductingEquipment = ConductingEquipment

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
        implicit val clz: String = PowerTransformer.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PowerTransformer.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (PowerTransformer.fields (position), x))
        emitelem (0, beforeShCircuitHighestOperatingCurrent)
        emitelem (1, beforeShCircuitHighestOperatingVoltage)
        emitelem (2, beforeShortCircuitAnglePf)
        emitelem (3, highSideMinOperatingU)
        emitelem (4, isPartOfGeneratorUnit)
        emitelem (5, operationalValuesConsidered)
        emitelem (6, vectorGroup)
        emitattrs (7, PowerTransformerEnd)
        emitattrs (8, TransformerTanks)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PowerTransformer rdf:ID=\"%s\">\n%s\t</cim:PowerTransformer>".format (id, export_fields)
    }
}

object PowerTransformer
extends
    CIMParseable[PowerTransformer]
{
    override val fields: Array[String] = Array[String] (
        "beforeShCircuitHighestOperatingCurrent",
        "beforeShCircuitHighestOperatingVoltage",
        "beforeShortCircuitAnglePf",
        "highSideMinOperatingU",
        "isPartOfGeneratorUnit",
        "operationalValuesConsidered",
        "vectorGroup",
        "PowerTransformerEnd",
        "TransformerTanks"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("PowerTransformerEnd", "PowerTransformerEnd", "0..*", "0..1"),
        CIMRelationship ("TransformerTanks", "TransformerTank", "0..*", "0..1")
    )
    val beforeShCircuitHighestOperatingCurrent: Fielder = parse_element (element (cls, fields(0)))
    val beforeShCircuitHighestOperatingVoltage: Fielder = parse_element (element (cls, fields(1)))
    val beforeShortCircuitAnglePf: Fielder = parse_element (element (cls, fields(2)))
    val highSideMinOperatingU: Fielder = parse_element (element (cls, fields(3)))
    val isPartOfGeneratorUnit: Fielder = parse_element (element (cls, fields(4)))
    val operationalValuesConsidered: Fielder = parse_element (element (cls, fields(5)))
    val vectorGroup: Fielder = parse_element (element (cls, fields(6)))
    val PowerTransformerEnd: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val TransformerTanks: FielderMultiple = parse_attributes (attribute (cls, fields(8)))

    def parse (context: CIMContext): PowerTransformer =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PowerTransformer (
            ConductingEquipment.parse (context),
            toDouble (mask (beforeShCircuitHighestOperatingCurrent (), 0)),
            toDouble (mask (beforeShCircuitHighestOperatingVoltage (), 1)),
            toDouble (mask (beforeShortCircuitAnglePf (), 2)),
            toDouble (mask (highSideMinOperatingU (), 3)),
            toBoolean (mask (isPartOfGeneratorUnit (), 4)),
            toBoolean (mask (operationalValuesConsidered (), 5)),
            mask (vectorGroup (), 6),
            masks (PowerTransformerEnd (), 7),
            masks (TransformerTanks (), 8)
        )
        ret.bitfields = bitfields
        ret
    }
}

object PowerTransformerSerializer extends CIMSerializer[PowerTransformer]
{
    def write (kryo: Kryo, output: Output, obj: PowerTransformer): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.beforeShCircuitHighestOperatingCurrent),
            () => output.writeDouble (obj.beforeShCircuitHighestOperatingVoltage),
            () => output.writeDouble (obj.beforeShortCircuitAnglePf),
            () => output.writeDouble (obj.highSideMinOperatingU),
            () => output.writeBoolean (obj.isPartOfGeneratorUnit),
            () => output.writeBoolean (obj.operationalValuesConsidered),
            () => output.writeString (obj.vectorGroup),
            () => writeList (obj.PowerTransformerEnd, output),
            () => writeList (obj.TransformerTanks, output)
        )
        ConductingEquipmentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PowerTransformer]): PowerTransformer =
    {
        val parent = ConductingEquipmentSerializer.read (kryo, input, classOf[ConductingEquipment])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PowerTransformer (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readBoolean else false,
            if (isSet (5)) input.readBoolean else false,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) readList (input) else null,
            if (isSet (8)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A PowerTransformerEnd is associated with each Terminal of a PowerTransformer.
 *
 * The impedance values r, r0, x, and x0 of a PowerTransformerEnd represents a star equivalent as follows.
 * 1) for a two Terminal PowerTransformer the high voltage (TransformerEnd.endNumber=1) PowerTransformerEnd has non zero values on r, r0, x, and x0 while the low voltage (TransformerEnd.endNumber=2) PowerTransformerEnd has zero values for r, r0, x, and x0.  Parameters are always provided, even if the PowerTransformerEnds have the same rated voltage.  In this case, the parameters are provided at the PowerTransformerEnd which has TransformerEnd.endNumber equal to 1.
 * 2) for a three Terminal PowerTransformer the three PowerTransformerEnds represent a star equivalent with each leg in the star represented by r, r0, x, and x0 values.
 * 3) For a three Terminal transformer each PowerTransformerEnd shall have g, g0, b and b0 values corresponding to the no load losses distributed on the three PowerTransformerEnds. The total no load loss shunt impedances may also be placed at one of the PowerTransformerEnds, preferably the end numbered 1, having the shunt values on end 1.  This is the preferred way.
 * 4) for a PowerTransformer with more than three Terminals the PowerTransformerEnd impedance values cannot be used. Instead use the TransformerMeshImpedance or split the transformer into multiple PowerTransformers.
 * Each PowerTransformerEnd must be contained by a PowerTransformer. Because a PowerTransformerEnd (or any other object) can not be contained by more than one parent, a PowerTransformerEnd can not have an association to an EquipmentContainer (Substation, VoltageLevel, etc).
 *
 * @param TransformerEnd [[ch.ninecode.model.TransformerEnd TransformerEnd]] Reference to the superclass object.
 * @param b Magnetizing branch susceptance (B mag).
 *        The value can be positive or negative.
 * @param b0 Zero sequence magnetizing branch susceptance.
 * @param connectionKind Kind of connection.
 * @param g Magnetizing branch conductance.
 * @param g0 Zero sequence magnetizing branch conductance (star-model).
 * @param phaseAngleClock Terminal voltage phase angle displacement where 360 degrees are represented with clock hours.
 *        The valid values are 0 to 11. For example, for the secondary side end of a transformer with vector group code of 'Dyn11', specify the connection kind as wye with neutral and specify the phase angle of the clock as 11.  The clock value of the transformer end number specified as 1, is assumed to be zero.  Note the transformer end number is not assumed to be the same as the terminal sequence number.
 * @param r Resistance (star-model) of the transformer end.
 *        The attribute shall be equal to or greater than zero for non-equivalent transformers.
 * @param r0 Zero sequence series resistance (star-model) of the transformer end.
 * @param ratedS Normal apparent power rating.
 *        The attribute shall be a positive value. For a two-winding transformer the values for the high and low voltage sides shall be identical.
 * @param ratedU Rated voltage: phase-phase for three-phase windings, and either phase-phase or phase-neutral for single-phase windings.
 *        A high voltage side, as given by TransformerEnd.endNumber, shall have a ratedU that is greater than or equal to ratedU for the lower voltage sides.
 * @param x Positive sequence series reactance (star-model) of the transformer end.
 * @param x0 Zero sequence series reactance of the transformer end.
 * @param PowerTransformer [[ch.ninecode.model.PowerTransformer PowerTransformer]] The power transformer of this power transformer end.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class PowerTransformerEnd
(
    TransformerEnd: TransformerEnd = null,
    b: Double = 0.0,
    b0: Double = 0.0,
    connectionKind: String = null,
    g: Double = 0.0,
    g0: Double = 0.0,
    phaseAngleClock: Int = 0,
    r: Double = 0.0,
    r0: Double = 0.0,
    ratedS: Double = 0.0,
    ratedU: Double = 0.0,
    x: Double = 0.0,
    x0: Double = 0.0,
    PowerTransformer: String = null
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
    override def sup: TransformerEnd = TransformerEnd

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
        implicit val clz: String = PowerTransformerEnd.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PowerTransformerEnd.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PowerTransformerEnd.fields (position), value)
        emitelem (0, b)
        emitelem (1, b0)
        emitattr (2, connectionKind)
        emitelem (3, g)
        emitelem (4, g0)
        emitelem (5, phaseAngleClock)
        emitelem (6, r)
        emitelem (7, r0)
        emitelem (8, ratedS)
        emitelem (9, ratedU)
        emitelem (10, x)
        emitelem (11, x0)
        emitattr (12, PowerTransformer)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PowerTransformerEnd rdf:ID=\"%s\">\n%s\t</cim:PowerTransformerEnd>".format (id, export_fields)
    }
}

object PowerTransformerEnd
extends
    CIMParseable[PowerTransformerEnd]
{
    override val fields: Array[String] = Array[String] (
        "b",
        "b0",
        "connectionKind",
        "g",
        "g0",
        "phaseAngleClock",
        "r",
        "r0",
        "ratedS",
        "ratedU",
        "x",
        "x0",
        "PowerTransformer"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("PowerTransformer", "PowerTransformer", "0..1", "0..*")
    )
    val b: Fielder = parse_element (element (cls, fields(0)))
    val b0: Fielder = parse_element (element (cls, fields(1)))
    val connectionKind: Fielder = parse_attribute (attribute (cls, fields(2)))
    val g: Fielder = parse_element (element (cls, fields(3)))
    val g0: Fielder = parse_element (element (cls, fields(4)))
    val phaseAngleClock: Fielder = parse_element (element (cls, fields(5)))
    val r: Fielder = parse_element (element (cls, fields(6)))
    val r0: Fielder = parse_element (element (cls, fields(7)))
    val ratedS: Fielder = parse_element (element (cls, fields(8)))
    val ratedU: Fielder = parse_element (element (cls, fields(9)))
    val x: Fielder = parse_element (element (cls, fields(10)))
    val x0: Fielder = parse_element (element (cls, fields(11)))
    val PowerTransformer: Fielder = parse_attribute (attribute (cls, fields(12)))

    def parse (context: CIMContext): PowerTransformerEnd =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PowerTransformerEnd (
            TransformerEnd.parse (context),
            toDouble (mask (b (), 0)),
            toDouble (mask (b0 (), 1)),
            mask (connectionKind (), 2),
            toDouble (mask (g (), 3)),
            toDouble (mask (g0 (), 4)),
            toInteger (mask (phaseAngleClock (), 5)),
            toDouble (mask (r (), 6)),
            toDouble (mask (r0 (), 7)),
            toDouble (mask (ratedS (), 8)),
            toDouble (mask (ratedU (), 9)),
            toDouble (mask (x (), 10)),
            toDouble (mask (x0 (), 11)),
            mask (PowerTransformer (), 12)
        )
        ret.bitfields = bitfields
        ret
    }
}

object PowerTransformerEndSerializer extends CIMSerializer[PowerTransformerEnd]
{
    def write (kryo: Kryo, output: Output, obj: PowerTransformerEnd): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.b),
            () => output.writeDouble (obj.b0),
            () => output.writeString (obj.connectionKind),
            () => output.writeDouble (obj.g),
            () => output.writeDouble (obj.g0),
            () => output.writeInt (obj.phaseAngleClock),
            () => output.writeDouble (obj.r),
            () => output.writeDouble (obj.r0),
            () => output.writeDouble (obj.ratedS),
            () => output.writeDouble (obj.ratedU),
            () => output.writeDouble (obj.x),
            () => output.writeDouble (obj.x0),
            () => output.writeString (obj.PowerTransformer)
        )
        TransformerEndSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PowerTransformerEnd]): PowerTransformerEnd =
    {
        val parent = TransformerEndSerializer.read (kryo, input, classOf[TransformerEnd])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PowerTransformerEnd (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readInt else 0,
            if (isSet (6)) input.readDouble else 0.0,
            if (isSet (7)) input.readDouble else 0.0,
            if (isSet (8)) input.readDouble else 0.0,
            if (isSet (9)) input.readDouble else 0.0,
            if (isSet (10)) input.readDouble else 0.0,
            if (isSet (11)) input.readDouble else 0.0,
            if (isSet (12)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A ProtectedSwitch is a switching device that can be operated by ProtectionEquipment.
 *
 * @param Switch [[ch.ninecode.model.Switch Switch]] Reference to the superclass object.
 * @param breakingCapacity The maximum fault current a breaking device can break safely under prescribed conditions of use.
 * @param OperatedByProtectionEquipment [[ch.ninecode.model.ProtectionEquipment ProtectionEquipment]] Protection equipments that operate this ProtectedSwitch.
 * @param RecloseSequences [[ch.ninecode.model.RecloseSequence RecloseSequence]] A breaker may have zero or more automatic reclosures after a trip occurs.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class ProtectedSwitch
(
    Switch: Switch = null,
    breakingCapacity: Double = 0.0,
    OperatedByProtectionEquipment: List[String] = null,
    RecloseSequences: List[String] = null
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
    override def sup: Switch = Switch

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
        implicit val clz: String = ProtectedSwitch.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ProtectedSwitch.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ProtectedSwitch.fields (position), x))
        emitelem (0, breakingCapacity)
        emitattrs (1, OperatedByProtectionEquipment)
        emitattrs (2, RecloseSequences)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ProtectedSwitch rdf:ID=\"%s\">\n%s\t</cim:ProtectedSwitch>".format (id, export_fields)
    }
}

object ProtectedSwitch
extends
    CIMParseable[ProtectedSwitch]
{
    override val fields: Array[String] = Array[String] (
        "breakingCapacity",
        "OperatedByProtectionEquipment",
        "RecloseSequences"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("OperatedByProtectionEquipment", "ProtectionEquipment", "0..*", "0..*"),
        CIMRelationship ("RecloseSequences", "RecloseSequence", "0..*", "1")
    )
    val breakingCapacity: Fielder = parse_element (element (cls, fields(0)))
    val OperatedByProtectionEquipment: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val RecloseSequences: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: CIMContext): ProtectedSwitch =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ProtectedSwitch (
            Switch.parse (context),
            toDouble (mask (breakingCapacity (), 0)),
            masks (OperatedByProtectionEquipment (), 1),
            masks (RecloseSequences (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

object ProtectedSwitchSerializer extends CIMSerializer[ProtectedSwitch]
{
    def write (kryo: Kryo, output: Output, obj: ProtectedSwitch): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.breakingCapacity),
            () => writeList (obj.OperatedByProtectionEquipment, output),
            () => writeList (obj.RecloseSequences, output)
        )
        SwitchSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ProtectedSwitch]): ProtectedSwitch =
    {
        val parent = SwitchSerializer.read (kryo, input, classOf[Switch])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ProtectedSwitch (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A tap changer that changes the voltage ratio impacting the voltage magnitude but not the phase angle across the transformer.
 *
 * Angle sign convention (general): Positive value indicates a positive phase shift from the winding where the tap is located to the other winding (for a two-winding transformer).
 *
 * @param TapChanger [[ch.ninecode.model.TapChanger TapChanger]] Reference to the superclass object.
 * @param stepVoltageIncrement Tap step increment, in per cent of rated voltage of the power transformer end, per step position.
 *        When the increment is negative, the voltage decreases when the tap step increases.
 * @param tculControlMode Specifies the regulation control mode (voltage or reactive) of the RatioTapChanger.
 * @param RatioTapChangerTable [[ch.ninecode.model.RatioTapChangerTable RatioTapChangerTable]] The tap ratio table for this ratio  tap changer.
 * @param TransformerEnd [[ch.ninecode.model.TransformerEnd TransformerEnd]] Transformer end to which this ratio tap changer belongs.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class RatioTapChanger
(
    TapChanger: TapChanger = null,
    stepVoltageIncrement: Double = 0.0,
    tculControlMode: String = null,
    RatioTapChangerTable: String = null,
    TransformerEnd: String = null
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
    override def sup: TapChanger = TapChanger

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
        implicit val clz: String = RatioTapChanger.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (RatioTapChanger.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RatioTapChanger.fields (position), value)
        emitelem (0, stepVoltageIncrement)
        emitattr (1, tculControlMode)
        emitattr (2, RatioTapChangerTable)
        emitattr (3, TransformerEnd)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RatioTapChanger rdf:ID=\"%s\">\n%s\t</cim:RatioTapChanger>".format (id, export_fields)
    }
}

object RatioTapChanger
extends
    CIMParseable[RatioTapChanger]
{
    override val fields: Array[String] = Array[String] (
        "stepVoltageIncrement",
        "tculControlMode",
        "RatioTapChangerTable",
        "TransformerEnd"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("RatioTapChangerTable", "RatioTapChangerTable", "0..1", "0..*"),
        CIMRelationship ("TransformerEnd", "TransformerEnd", "1", "0..1")
    )
    val stepVoltageIncrement: Fielder = parse_element (element (cls, fields(0)))
    val tculControlMode: Fielder = parse_attribute (attribute (cls, fields(1)))
    val RatioTapChangerTable: Fielder = parse_attribute (attribute (cls, fields(2)))
    val TransformerEnd: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: CIMContext): RatioTapChanger =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = RatioTapChanger (
            TapChanger.parse (context),
            toDouble (mask (stepVoltageIncrement (), 0)),
            mask (tculControlMode (), 1),
            mask (RatioTapChangerTable (), 2),
            mask (TransformerEnd (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

object RatioTapChangerSerializer extends CIMSerializer[RatioTapChanger]
{
    def write (kryo: Kryo, output: Output, obj: RatioTapChanger): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.stepVoltageIncrement),
            () => output.writeString (obj.tculControlMode),
            () => output.writeString (obj.RatioTapChangerTable),
            () => output.writeString (obj.TransformerEnd)
        )
        TapChangerSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[RatioTapChanger]): RatioTapChanger =
    {
        val parent = TapChangerSerializer.read (kryo, input, classOf[TapChanger])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = RatioTapChanger (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Describes a curve for how the voltage magnitude and impedance varies with the tap step.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param RatioTapChanger [[ch.ninecode.model.RatioTapChanger RatioTapChanger]] The ratio tap changer of this tap ratio table.
 * @param RatioTapChangerTablePoint [[ch.ninecode.model.RatioTapChangerTablePoint RatioTapChangerTablePoint]] Points of this table.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class RatioTapChangerTable
(
    IdentifiedObject: IdentifiedObject = null,
    RatioTapChanger: List[String] = null,
    RatioTapChangerTablePoint: List[String] = null
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
        implicit val clz: String = RatioTapChangerTable.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (RatioTapChangerTable.fields (position), x))
        emitattrs (0, RatioTapChanger)
        emitattrs (1, RatioTapChangerTablePoint)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RatioTapChangerTable rdf:ID=\"%s\">\n%s\t</cim:RatioTapChangerTable>".format (id, export_fields)
    }
}

object RatioTapChangerTable
extends
    CIMParseable[RatioTapChangerTable]
{
    override val fields: Array[String] = Array[String] (
        "RatioTapChanger",
        "RatioTapChangerTablePoint"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("RatioTapChanger", "RatioTapChanger", "0..*", "0..1"),
        CIMRelationship ("RatioTapChangerTablePoint", "RatioTapChangerTablePoint", "1..*", "1")
    )
    val RatioTapChanger: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val RatioTapChangerTablePoint: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): RatioTapChangerTable =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = RatioTapChangerTable (
            IdentifiedObject.parse (context),
            masks (RatioTapChanger (), 0),
            masks (RatioTapChangerTablePoint (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

object RatioTapChangerTableSerializer extends CIMSerializer[RatioTapChangerTable]
{
    def write (kryo: Kryo, output: Output, obj: RatioTapChangerTable): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.RatioTapChanger, output),
            () => writeList (obj.RatioTapChangerTablePoint, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[RatioTapChangerTable]): RatioTapChangerTable =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = RatioTapChangerTable (
            parent,
            if (isSet (0)) readList (input) else null,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Describes each tap step in the ratio tap changer tabular curve.
 *
 * @param TapChangerTablePoint [[ch.ninecode.model.TapChangerTablePoint TapChangerTablePoint]] Reference to the superclass object.
 * @param RatioTapChangerTable [[ch.ninecode.model.RatioTapChangerTable RatioTapChangerTable]] Table of this point.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class RatioTapChangerTablePoint
(
    TapChangerTablePoint: TapChangerTablePoint = null,
    RatioTapChangerTable: String = null
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
    override def sup: TapChangerTablePoint = TapChangerTablePoint

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
        implicit val clz: String = RatioTapChangerTablePoint.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RatioTapChangerTablePoint.fields (position), value)
        emitattr (0, RatioTapChangerTable)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RatioTapChangerTablePoint rdf:ID=\"%s\">\n%s\t</cim:RatioTapChangerTablePoint>".format (id, export_fields)
    }
}

object RatioTapChangerTablePoint
extends
    CIMParseable[RatioTapChangerTablePoint]
{
    override val fields: Array[String] = Array[String] (
        "RatioTapChangerTable"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("RatioTapChangerTable", "RatioTapChangerTable", "1", "1..*")
    )
    val RatioTapChangerTable: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): RatioTapChangerTablePoint =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = RatioTapChangerTablePoint (
            TapChangerTablePoint.parse (context),
            mask (RatioTapChangerTable (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

object RatioTapChangerTablePointSerializer extends CIMSerializer[RatioTapChangerTablePoint]
{
    def write (kryo: Kryo, output: Output, obj: RatioTapChangerTablePoint): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.RatioTapChangerTable)
        )
        TapChangerTablePointSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[RatioTapChangerTablePoint]): RatioTapChangerTablePoint =
    {
        val parent = TapChangerTablePointSerializer.read (kryo, input, classOf[TapChangerTablePoint])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = RatioTapChangerTablePoint (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Reactive power rating envelope versus the synchronous machine's active power, in both the generating and motoring modes.
 *
 * For each active power value there is a corresponding high and low reactive power limit  value. Typically there will be a separate curve for each coolant condition, such as hydrogen pressure.  The Y1 axis values represent reactive minimum and the Y2 axis values represent reactive maximum.
 *
 * @param Curve [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param coolantTemperature The machine's coolant temperature (e.g., ambient air or stator circulating water).
 * @param hydrogenPressure The hydrogen coolant pressure.
 * @param EquivalentInjection [[ch.ninecode.model.EquivalentInjection EquivalentInjection]] The equivalent injection using this reactive capability curve.
 * @param InitiallyUsedBySynchronousMachines [[ch.ninecode.model.SynchronousMachine SynchronousMachine]] Synchronous machines using this curve as default.
 * @param SynchronousMachines [[ch.ninecode.model.SynchronousMachine SynchronousMachine]] Synchronous machines using this curve.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class ReactiveCapabilityCurve
(
    Curve: Curve = null,
    coolantTemperature: Double = 0.0,
    hydrogenPressure: Double = 0.0,
    EquivalentInjection: List[String] = null,
    InitiallyUsedBySynchronousMachines: List[String] = null,
    SynchronousMachines: List[String] = null
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
    override def sup: Curve = Curve

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
        implicit val clz: String = ReactiveCapabilityCurve.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ReactiveCapabilityCurve.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ReactiveCapabilityCurve.fields (position), x))
        emitelem (0, coolantTemperature)
        emitelem (1, hydrogenPressure)
        emitattrs (2, EquivalentInjection)
        emitattrs (3, InitiallyUsedBySynchronousMachines)
        emitattrs (4, SynchronousMachines)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ReactiveCapabilityCurve rdf:ID=\"%s\">\n%s\t</cim:ReactiveCapabilityCurve>".format (id, export_fields)
    }
}

object ReactiveCapabilityCurve
extends
    CIMParseable[ReactiveCapabilityCurve]
{
    override val fields: Array[String] = Array[String] (
        "coolantTemperature",
        "hydrogenPressure",
        "EquivalentInjection",
        "InitiallyUsedBySynchronousMachines",
        "SynchronousMachines"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("EquivalentInjection", "EquivalentInjection", "0..*", "0..1"),
        CIMRelationship ("InitiallyUsedBySynchronousMachines", "SynchronousMachine", "1..*", "0..1"),
        CIMRelationship ("SynchronousMachines", "SynchronousMachine", "1..*", "0..*")
    )
    val coolantTemperature: Fielder = parse_element (element (cls, fields(0)))
    val hydrogenPressure: Fielder = parse_element (element (cls, fields(1)))
    val EquivalentInjection: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val InitiallyUsedBySynchronousMachines: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val SynchronousMachines: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: CIMContext): ReactiveCapabilityCurve =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ReactiveCapabilityCurve (
            Curve.parse (context),
            toDouble (mask (coolantTemperature (), 0)),
            toDouble (mask (hydrogenPressure (), 1)),
            masks (EquivalentInjection (), 2),
            masks (InitiallyUsedBySynchronousMachines (), 3),
            masks (SynchronousMachines (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

object ReactiveCapabilityCurveSerializer extends CIMSerializer[ReactiveCapabilityCurve]
{
    def write (kryo: Kryo, output: Output, obj: ReactiveCapabilityCurve): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.coolantTemperature),
            () => output.writeDouble (obj.hydrogenPressure),
            () => writeList (obj.EquivalentInjection, output),
            () => writeList (obj.InitiallyUsedBySynchronousMachines, output),
            () => writeList (obj.SynchronousMachines, output)
        )
        CurveSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ReactiveCapabilityCurve]): ReactiveCapabilityCurve =
    {
        val parent = CurveSerializer.read (kryo, input, classOf[Curve])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ReactiveCapabilityCurve (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) readList (input) else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Pole-mounted fault interrupter with built-in phase and ground relays, current transformer (CT), and supplemental controls.
 *
 * @param ProtectedSwitch [[ch.ninecode.model.ProtectedSwitch ProtectedSwitch]] Reference to the superclass object.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class Recloser
(
    ProtectedSwitch: ProtectedSwitch = null
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
    override def sup: ProtectedSwitch = ProtectedSwitch

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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:Recloser rdf:ID=\"%s\">\n%s\t</cim:Recloser>".format (id, export_fields)
    }
}

object Recloser
extends
    CIMParseable[Recloser]
{

    def parse (context: CIMContext): Recloser =
    {
        val ret = Recloser (
            ProtectedSwitch.parse (context)
        )
        ret
    }
}

object RecloserSerializer extends CIMSerializer[Recloser]
{
    def write (kryo: Kryo, output: Output, obj: Recloser): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        ProtectedSwitchSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Recloser]): Recloser =
    {
        val parent = ProtectedSwitchSerializer.read (kryo, input, classOf[ProtectedSwitch])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Recloser (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A type of conducting equipment that can regulate a quantity (i.e. voltage or flow) at a specific point in the network.
 *
 * @param EnergyConnection [[ch.ninecode.model.EnergyConnection EnergyConnection]] Reference to the superclass object.
 * @param controlEnabled Specifies the regulation status of the equipment.
 *        True is regulating, false is not regulating.
 * @param RegulatingControl [[ch.ninecode.model.RegulatingControl RegulatingControl]] The regulating control scheme in which this equipment participates.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class RegulatingCondEq
(
    EnergyConnection: EnergyConnection = null,
    controlEnabled: Boolean = false,
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
    override def sup: EnergyConnection = EnergyConnection

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
        implicit val clz: String = RegulatingCondEq.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (RegulatingCondEq.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RegulatingCondEq.fields (position), value)
        emitelem (0, controlEnabled)
        emitattr (1, RegulatingControl)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RegulatingCondEq rdf:ID=\"%s\">\n%s\t</cim:RegulatingCondEq>".format (id, export_fields)
    }
}

object RegulatingCondEq
extends
    CIMParseable[RegulatingCondEq]
{
    override val fields: Array[String] = Array[String] (
        "controlEnabled",
        "RegulatingControl"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("RegulatingControl", "RegulatingControl", "0..1", "0..*")
    )
    val controlEnabled: Fielder = parse_element (element (cls, fields(0)))
    val RegulatingControl: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): RegulatingCondEq =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = RegulatingCondEq (
            EnergyConnection.parse (context),
            toBoolean (mask (controlEnabled (), 0)),
            mask (RegulatingControl (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

object RegulatingCondEqSerializer extends CIMSerializer[RegulatingCondEq]
{
    def write (kryo: Kryo, output: Output, obj: RegulatingCondEq): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeBoolean (obj.controlEnabled),
            () => output.writeString (obj.RegulatingControl)
        )
        EnergyConnectionSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[RegulatingCondEq]): RegulatingCondEq =
    {
        val parent = EnergyConnectionSerializer.read (kryo, input, classOf[EnergyConnection])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = RegulatingCondEq (
            parent,
            if (isSet (0)) input.readBoolean else false,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Specifies a set of equipment that works together to control a power system quantity such as voltage or flow.
 *
 * Remote bus voltage control is possible by specifying the controlled terminal located at some place remote from the controlling equipment.
 * In case multiple equipment, possibly of different types, control the same terminal, there shall be only one RegulatingControl at that terminal. The specified terminal shall be associated with the connectivity node of the controlled point.  The most specific subtype of RegulatingControl shall be used in case such equipment participate in the control, e.g. TapChangerControl for tap changers.
 * For flow control, load sign convention is used, i.e. positive sign means flow out from a TopologicalNode (bus) into the conducting equipment.
 *
 * @param PowerSystemResource [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param discrete The regulation is performed in a discrete mode.
 *        This applies to equipment with discrete controls, e.g. tap changers and shunt compensators.
 * @param enabled The flag tells if regulation is enabled.
 * @param mode The regulating control mode presently available.
 *        This specification allows for determining the kind of regulation without need for obtaining the units from a schedule.
 * @param monitoredPhase Phase voltage controlling this regulator, measured at regulator location.
 * @param targetDeadband This is a deadband used with discrete control to avoid excessive update of controls like tap changers and shunt compensator banks while regulating.
 *        The units of those appropriate for the mode.  It is primarily used if the RegulatingControl.discrete is set to "true". Tools should handle cases in which RegulatingControl.targetDeadband has a value if RegulatingControl.discrete is set to "false" or cases in which RegulatingControl.targetDeadband equals zero.
 *        Note that for instance, if the targetValue is 100 kV and the targetDeadband is 2 kV the range is from 99 to 101 kV.
 * @param targetValue The target value specified for case input.
 *        This value can be used for the target value without the use of schedules. The value has the units appropriate to the mode attribute.
 * @param targetValueUnitMultiplier Specify the multiplier for used for the targetValue.
 * @param ProtectiveActionRegulation [[ch.ninecode.model.ProtectiveActionRegulation ProtectiveActionRegulation]] Enable/disable a regulating control or set new target value.
 * @param RegulatingCondEq [[ch.ninecode.model.RegulatingCondEq RegulatingCondEq]] The equipment that participates in this regulating control scheme.
 * @param RegulationSchedule [[ch.ninecode.model.RegulationSchedule RegulationSchedule]] Schedule for this regulating control.
 * @param Terminal [[ch.ninecode.model.Terminal Terminal]] The terminal associated with this regulating control.
 *        The terminal is associated instead of a node, since the terminal could connect into either a topological node or a connectivity node.  Sometimes it is useful to model regulation at a terminal of a bus bar object.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class RegulatingControl
(
    PowerSystemResource: PowerSystemResource = null,
    discrete: Boolean = false,
    enabled: Boolean = false,
    mode: String = null,
    monitoredPhase: String = null,
    targetDeadband: Double = 0.0,
    targetValue: Double = 0.0,
    targetValueUnitMultiplier: String = null,
    ProtectiveActionRegulation: List[String] = null,
    RegulatingCondEq: List[String] = null,
    RegulationSchedule: List[String] = null,
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
        implicit val clz: String = RegulatingControl.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (RegulatingControl.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RegulatingControl.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (RegulatingControl.fields (position), x))
        emitelem (0, discrete)
        emitelem (1, enabled)
        emitattr (2, mode)
        emitattr (3, monitoredPhase)
        emitelem (4, targetDeadband)
        emitelem (5, targetValue)
        emitattr (6, targetValueUnitMultiplier)
        emitattrs (7, ProtectiveActionRegulation)
        emitattrs (8, RegulatingCondEq)
        emitattrs (9, RegulationSchedule)
        emitattr (10, Terminal)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RegulatingControl rdf:ID=\"%s\">\n%s\t</cim:RegulatingControl>".format (id, export_fields)
    }
}

object RegulatingControl
extends
    CIMParseable[RegulatingControl]
{
    override val fields: Array[String] = Array[String] (
        "discrete",
        "enabled",
        "mode",
        "monitoredPhase",
        "targetDeadband",
        "targetValue",
        "targetValueUnitMultiplier",
        "ProtectiveActionRegulation",
        "RegulatingCondEq",
        "RegulationSchedule",
        "Terminal"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ProtectiveActionRegulation", "ProtectiveActionRegulation", "0..*", "1"),
        CIMRelationship ("RegulatingCondEq", "RegulatingCondEq", "0..*", "0..1"),
        CIMRelationship ("RegulationSchedule", "RegulationSchedule", "0..*", "1"),
        CIMRelationship ("Terminal", "Terminal", "0..1", "0..*")
    )
    val discrete: Fielder = parse_element (element (cls, fields(0)))
    val enabled: Fielder = parse_element (element (cls, fields(1)))
    val mode: Fielder = parse_attribute (attribute (cls, fields(2)))
    val monitoredPhase: Fielder = parse_attribute (attribute (cls, fields(3)))
    val targetDeadband: Fielder = parse_element (element (cls, fields(4)))
    val targetValue: Fielder = parse_element (element (cls, fields(5)))
    val targetValueUnitMultiplier: Fielder = parse_attribute (attribute (cls, fields(6)))
    val ProtectiveActionRegulation: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val RegulatingCondEq: FielderMultiple = parse_attributes (attribute (cls, fields(8)))
    val RegulationSchedule: FielderMultiple = parse_attributes (attribute (cls, fields(9)))
    val Terminal: Fielder = parse_attribute (attribute (cls, fields(10)))

    def parse (context: CIMContext): RegulatingControl =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = RegulatingControl (
            PowerSystemResource.parse (context),
            toBoolean (mask (discrete (), 0)),
            toBoolean (mask (enabled (), 1)),
            mask (mode (), 2),
            mask (monitoredPhase (), 3),
            toDouble (mask (targetDeadband (), 4)),
            toDouble (mask (targetValue (), 5)),
            mask (targetValueUnitMultiplier (), 6),
            masks (ProtectiveActionRegulation (), 7),
            masks (RegulatingCondEq (), 8),
            masks (RegulationSchedule (), 9),
            mask (Terminal (), 10)
        )
        ret.bitfields = bitfields
        ret
    }
}

object RegulatingControlSerializer extends CIMSerializer[RegulatingControl]
{
    def write (kryo: Kryo, output: Output, obj: RegulatingControl): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeBoolean (obj.discrete),
            () => output.writeBoolean (obj.enabled),
            () => output.writeString (obj.mode),
            () => output.writeString (obj.monitoredPhase),
            () => output.writeDouble (obj.targetDeadband),
            () => output.writeDouble (obj.targetValue),
            () => output.writeString (obj.targetValueUnitMultiplier),
            () => writeList (obj.ProtectiveActionRegulation, output),
            () => writeList (obj.RegulatingCondEq, output),
            () => writeList (obj.RegulationSchedule, output),
            () => output.writeString (obj.Terminal)
        )
        PowerSystemResourceSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[RegulatingControl]): RegulatingControl =
    {
        val parent = PowerSystemResourceSerializer.read (kryo, input, classOf[PowerSystemResource])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = RegulatingControl (
            parent,
            if (isSet (0)) input.readBoolean else false,
            if (isSet (1)) input.readBoolean else false,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readDouble else 0.0,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) readList (input) else null,
            if (isSet (8)) readList (input) else null,
            if (isSet (9)) readList (input) else null,
            if (isSet (10)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A pre-established pattern over time for a controlled variable, e.g., busbar voltage.
 *
 * @param SeasonDayTypeSchedule [[ch.ninecode.model.SeasonDayTypeSchedule SeasonDayTypeSchedule]] Reference to the superclass object.
 * @param RegulatingControl [[ch.ninecode.model.RegulatingControl RegulatingControl]] Regulating controls that have this schedule.
 * @param VoltageControlZones [[ch.ninecode.model.VoltageControlZone VoltageControlZone]] A VoltageControlZone may have a  voltage regulation schedule.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class RegulationSchedule
(
    SeasonDayTypeSchedule: SeasonDayTypeSchedule = null,
    RegulatingControl: String = null,
    VoltageControlZones: List[String] = null
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
    override def sup: SeasonDayTypeSchedule = SeasonDayTypeSchedule

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
        implicit val clz: String = RegulationSchedule.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RegulationSchedule.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (RegulationSchedule.fields (position), x))
        emitattr (0, RegulatingControl)
        emitattrs (1, VoltageControlZones)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RegulationSchedule rdf:ID=\"%s\">\n%s\t</cim:RegulationSchedule>".format (id, export_fields)
    }
}

object RegulationSchedule
extends
    CIMParseable[RegulationSchedule]
{
    override val fields: Array[String] = Array[String] (
        "RegulatingControl",
        "VoltageControlZones"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("RegulatingControl", "RegulatingControl", "1", "0..*"),
        CIMRelationship ("VoltageControlZones", "VoltageControlZone", "0..*", "0..1")
    )
    val RegulatingControl: Fielder = parse_attribute (attribute (cls, fields(0)))
    val VoltageControlZones: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): RegulationSchedule =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = RegulationSchedule (
            SeasonDayTypeSchedule.parse (context),
            mask (RegulatingControl (), 0),
            masks (VoltageControlZones (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

object RegulationScheduleSerializer extends CIMSerializer[RegulationSchedule]
{
    def write (kryo: Kryo, output: Output, obj: RegulationSchedule): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.RegulatingControl),
            () => writeList (obj.VoltageControlZones, output)
        )
        SeasonDayTypeScheduleSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[RegulationSchedule]): RegulationSchedule =
    {
        val parent = SeasonDayTypeScheduleSerializer.read (kryo, input, classOf[SeasonDayTypeSchedule])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = RegulationSchedule (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A rotating machine which may be used as a generator or motor.
 *
 * @param RegulatingCondEq [[ch.ninecode.model.RegulatingCondEq RegulatingCondEq]] Reference to the superclass object.
 * @param p Active power injection.
 *        Load sign convention is used, i.e. positive sign means flow out from a node.
 *        Starting value for a steady state solution.
 * @param q Reactive power injection.
 *        Load sign convention is used, i.e. positive sign means flow out from a node.
 *        Starting value for a steady state solution.
 * @param ratedPowerFactor Power factor (nameplate data).
 *        It is primarily used for short circuit data exchange according to IEC 60909.
 * @param ratedS Nameplate apparent power rating for the unit.
 *        The attribute shall have a positive value.
 * @param ratedU Rated voltage (nameplate data, Ur in IEC 60909-0).
 *        It is primarily used for short circuit data exchange according to IEC 60909.
 * @param GeneratingUnit [[ch.ninecode.model.GeneratingUnit GeneratingUnit]] A synchronous machine may operate as a generator and as such becomes a member of a generating unit.
 * @param HydroPump [[ch.ninecode.model.HydroPump HydroPump]] The synchronous machine drives the turbine which moves the water from a low elevation to a higher elevation.
 *        The direction of machine rotation for pumping may or may not be the same as for generating.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class RotatingMachine
(
    RegulatingCondEq: RegulatingCondEq = null,
    p: Double = 0.0,
    q: Double = 0.0,
    ratedPowerFactor: Double = 0.0,
    ratedS: Double = 0.0,
    ratedU: Double = 0.0,
    GeneratingUnit: String = null,
    HydroPump: String = null
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
    override def sup: RegulatingCondEq = RegulatingCondEq

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
        implicit val clz: String = RotatingMachine.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (RotatingMachine.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RotatingMachine.fields (position), value)
        emitelem (0, p)
        emitelem (1, q)
        emitelem (2, ratedPowerFactor)
        emitelem (3, ratedS)
        emitelem (4, ratedU)
        emitattr (5, GeneratingUnit)
        emitattr (6, HydroPump)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RotatingMachine rdf:ID=\"%s\">\n%s\t</cim:RotatingMachine>".format (id, export_fields)
    }
}

object RotatingMachine
extends
    CIMParseable[RotatingMachine]
{
    override val fields: Array[String] = Array[String] (
        "p",
        "q",
        "ratedPowerFactor",
        "ratedS",
        "ratedU",
        "GeneratingUnit",
        "HydroPump"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("GeneratingUnit", "GeneratingUnit", "0..1", "0..*"),
        CIMRelationship ("HydroPump", "HydroPump", "0..1", "1")
    )
    val p: Fielder = parse_element (element (cls, fields(0)))
    val q: Fielder = parse_element (element (cls, fields(1)))
    val ratedPowerFactor: Fielder = parse_element (element (cls, fields(2)))
    val ratedS: Fielder = parse_element (element (cls, fields(3)))
    val ratedU: Fielder = parse_element (element (cls, fields(4)))
    val GeneratingUnit: Fielder = parse_attribute (attribute (cls, fields(5)))
    val HydroPump: Fielder = parse_attribute (attribute (cls, fields(6)))

    def parse (context: CIMContext): RotatingMachine =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = RotatingMachine (
            RegulatingCondEq.parse (context),
            toDouble (mask (p (), 0)),
            toDouble (mask (q (), 1)),
            toDouble (mask (ratedPowerFactor (), 2)),
            toDouble (mask (ratedS (), 3)),
            toDouble (mask (ratedU (), 4)),
            mask (GeneratingUnit (), 5),
            mask (HydroPump (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
}

object RotatingMachineSerializer extends CIMSerializer[RotatingMachine]
{
    def write (kryo: Kryo, output: Output, obj: RotatingMachine): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.p),
            () => output.writeDouble (obj.q),
            () => output.writeDouble (obj.ratedPowerFactor),
            () => output.writeDouble (obj.ratedS),
            () => output.writeDouble (obj.ratedU),
            () => output.writeString (obj.GeneratingUnit),
            () => output.writeString (obj.HydroPump)
        )
        RegulatingCondEqSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[RotatingMachine]): RotatingMachine =
    {
        val parent = RegulatingCondEqSerializer.read (kryo, input, classOf[RegulatingCondEq])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = RotatingMachine (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Automatic switch that will lock open to isolate a faulted section.
 *
 * It may, or may not, have load breaking capability. Its primary purpose is to provide fault sectionalising at locations where the fault current is either too high, or too low, for proper coordination of fuses.
 *
 * @param Switch [[ch.ninecode.model.Switch Switch]] Reference to the superclass object.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class Sectionaliser
(
    Switch: Switch = null
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
    override def sup: Switch = Switch

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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:Sectionaliser rdf:ID=\"%s\">\n%s\t</cim:Sectionaliser>".format (id, export_fields)
    }
}

object Sectionaliser
extends
    CIMParseable[Sectionaliser]
{

    def parse (context: CIMContext): Sectionaliser =
    {
        val ret = Sectionaliser (
            Switch.parse (context)
        )
        ret
    }
}

object SectionaliserSerializer extends CIMSerializer[Sectionaliser]
{
    def write (kryo: Kryo, output: Output, obj: Sectionaliser): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        SwitchSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Sectionaliser]): Sectionaliser =
    {
        val parent = SwitchSerializer.read (kryo, input, classOf[Switch])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Sectionaliser (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A Series Compensator is a series capacitor or reactor or an AC transmission line without charging susceptance.
 *
 * It is a two terminal device.
 *
 * @param ConductingEquipment [[ch.ninecode.model.ConductingEquipment ConductingEquipment]] Reference to the superclass object.
 * @param r Positive sequence resistance.
 * @param r0 Zero sequence resistance.
 * @param varistorPresent Describe if a metal oxide varistor (mov) for over voltage protection is configured at the series compensator.
 * @param varistorRatedCurrent The maximum current the varistor is designed to handle at specified duration.
 * @param varistorVoltageThreshold The dc voltage at which the varistor starts conducting.
 * @param x Positive sequence reactance.
 * @param x0 Zero sequence reactance.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class SeriesCompensator
(
    ConductingEquipment: ConductingEquipment = null,
    r: Double = 0.0,
    r0: Double = 0.0,
    varistorPresent: Boolean = false,
    varistorRatedCurrent: Double = 0.0,
    varistorVoltageThreshold: Double = 0.0,
    x: Double = 0.0,
    x0: Double = 0.0
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
    override def sup: ConductingEquipment = ConductingEquipment

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
        implicit val clz: String = SeriesCompensator.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SeriesCompensator.fields (position), value)
        emitelem (0, r)
        emitelem (1, r0)
        emitelem (2, varistorPresent)
        emitelem (3, varistorRatedCurrent)
        emitelem (4, varistorVoltageThreshold)
        emitelem (5, x)
        emitelem (6, x0)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SeriesCompensator rdf:ID=\"%s\">\n%s\t</cim:SeriesCompensator>".format (id, export_fields)
    }
}

object SeriesCompensator
extends
    CIMParseable[SeriesCompensator]
{
    override val fields: Array[String] = Array[String] (
        "r",
        "r0",
        "varistorPresent",
        "varistorRatedCurrent",
        "varistorVoltageThreshold",
        "x",
        "x0"
    )
    val r: Fielder = parse_element (element (cls, fields(0)))
    val r0: Fielder = parse_element (element (cls, fields(1)))
    val varistorPresent: Fielder = parse_element (element (cls, fields(2)))
    val varistorRatedCurrent: Fielder = parse_element (element (cls, fields(3)))
    val varistorVoltageThreshold: Fielder = parse_element (element (cls, fields(4)))
    val x: Fielder = parse_element (element (cls, fields(5)))
    val x0: Fielder = parse_element (element (cls, fields(6)))

    def parse (context: CIMContext): SeriesCompensator =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SeriesCompensator (
            ConductingEquipment.parse (context),
            toDouble (mask (r (), 0)),
            toDouble (mask (r0 (), 1)),
            toBoolean (mask (varistorPresent (), 2)),
            toDouble (mask (varistorRatedCurrent (), 3)),
            toDouble (mask (varistorVoltageThreshold (), 4)),
            toDouble (mask (x (), 5)),
            toDouble (mask (x0 (), 6))
        )
        ret.bitfields = bitfields
        ret
    }
}

object SeriesCompensatorSerializer extends CIMSerializer[SeriesCompensator]
{
    def write (kryo: Kryo, output: Output, obj: SeriesCompensator): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.r),
            () => output.writeDouble (obj.r0),
            () => output.writeBoolean (obj.varistorPresent),
            () => output.writeDouble (obj.varistorRatedCurrent),
            () => output.writeDouble (obj.varistorVoltageThreshold),
            () => output.writeDouble (obj.x),
            () => output.writeDouble (obj.x0)
        )
        ConductingEquipmentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[SeriesCompensator]): SeriesCompensator =
    {
        val parent = ConductingEquipmentSerializer.read (kryo, input, classOf[ConductingEquipment])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = SeriesCompensator (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readBoolean else false,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readDouble else 0.0,
            if (isSet (6)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A shunt capacitor or reactor or switchable bank of shunt capacitors or reactors.
 *
 * A section of a shunt compensator is an individual capacitor or reactor.  A negative value for reactivePerSection indicates that the compensator is a reactor. ShuntCompensator is a single terminal device.  Ground is implied.
 *
 * @param RegulatingCondEq [[ch.ninecode.model.RegulatingCondEq RegulatingCondEq]] Reference to the superclass object.
 * @param aVRDelay Time delay required for the device to be connected or disconnected by automatic voltage regulation (AVR).
 * @param grounded Used for Yn and Zn connections.
 *        True if the neutral is solidly grounded.
 * @param maximumSections The maximum number of sections that may be switched in.
 * @param nomU The voltage at which the nominal reactive power may be calculated.
 *        This should normally be within 10% of the voltage at which the capacitor is connected to the network.
 * @param normalSections The normal number of sections switched in.
 * @param phaseConnection The type of phase connection, such as wye or delta.
 * @param sections Shunt compensator sections in use.
 *        Starting value for steady state solution. Non integer values are allowed to support continuous variables. The reasons for continuous value are to support study cases where no discrete shunt compensators has yet been designed, a solutions where a narrow voltage band force the sections to oscillate or accommodate for a continuous solution as input.
 * @param switchOnCount The switch on count since the capacitor count was last reset or initialized.
 * @param switchOnDate The date and time when the capacitor bank was last switched on.
 * @param voltageSensitivity Voltage sensitivity required for the device to regulate the bus voltage, in voltage/reactive power.
 * @param ShuntCompensatorPhase [[ch.ninecode.model.ShuntCompensatorPhase ShuntCompensatorPhase]] The individual phases models for the shunt compensator.
 * @param SvShuntCompensatorSections [[ch.ninecode.model.SvShuntCompensatorSections SvShuntCompensatorSections]] The state for the number of shunt compensator sections in service.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class ShuntCompensator
(
    RegulatingCondEq: RegulatingCondEq = null,
    aVRDelay: Double = 0.0,
    grounded: Boolean = false,
    maximumSections: Int = 0,
    nomU: Double = 0.0,
    normalSections: Int = 0,
    phaseConnection: String = null,
    sections: Double = 0.0,
    switchOnCount: Int = 0,
    switchOnDate: String = null,
    voltageSensitivity: Double = 0.0,
    ShuntCompensatorPhase: List[String] = null,
    SvShuntCompensatorSections: List[String] = null
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
    override def sup: RegulatingCondEq = RegulatingCondEq

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
        implicit val clz: String = ShuntCompensator.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ShuntCompensator.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ShuntCompensator.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ShuntCompensator.fields (position), x))
        emitelem (0, aVRDelay)
        emitelem (1, grounded)
        emitelem (2, maximumSections)
        emitelem (3, nomU)
        emitelem (4, normalSections)
        emitattr (5, phaseConnection)
        emitelem (6, sections)
        emitelem (7, switchOnCount)
        emitelem (8, switchOnDate)
        emitelem (9, voltageSensitivity)
        emitattrs (10, ShuntCompensatorPhase)
        emitattrs (11, SvShuntCompensatorSections)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ShuntCompensator rdf:ID=\"%s\">\n%s\t</cim:ShuntCompensator>".format (id, export_fields)
    }
}

object ShuntCompensator
extends
    CIMParseable[ShuntCompensator]
{
    override val fields: Array[String] = Array[String] (
        "aVRDelay",
        "grounded",
        "maximumSections",
        "nomU",
        "normalSections",
        "phaseConnection",
        "sections",
        "switchOnCount",
        "switchOnDate",
        "voltageSensitivity",
        "ShuntCompensatorPhase",
        "SvShuntCompensatorSections"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ShuntCompensatorPhase", "ShuntCompensatorPhase", "0..*", "1"),
        CIMRelationship ("SvShuntCompensatorSections", "SvShuntCompensatorSections", "0..*", "1")
    )
    val aVRDelay: Fielder = parse_element (element (cls, fields(0)))
    val grounded: Fielder = parse_element (element (cls, fields(1)))
    val maximumSections: Fielder = parse_element (element (cls, fields(2)))
    val nomU: Fielder = parse_element (element (cls, fields(3)))
    val normalSections: Fielder = parse_element (element (cls, fields(4)))
    val phaseConnection: Fielder = parse_attribute (attribute (cls, fields(5)))
    val sections: Fielder = parse_element (element (cls, fields(6)))
    val switchOnCount: Fielder = parse_element (element (cls, fields(7)))
    val switchOnDate: Fielder = parse_element (element (cls, fields(8)))
    val voltageSensitivity: Fielder = parse_element (element (cls, fields(9)))
    val ShuntCompensatorPhase: FielderMultiple = parse_attributes (attribute (cls, fields(10)))
    val SvShuntCompensatorSections: FielderMultiple = parse_attributes (attribute (cls, fields(11)))

    def parse (context: CIMContext): ShuntCompensator =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ShuntCompensator (
            RegulatingCondEq.parse (context),
            toDouble (mask (aVRDelay (), 0)),
            toBoolean (mask (grounded (), 1)),
            toInteger (mask (maximumSections (), 2)),
            toDouble (mask (nomU (), 3)),
            toInteger (mask (normalSections (), 4)),
            mask (phaseConnection (), 5),
            toDouble (mask (sections (), 6)),
            toInteger (mask (switchOnCount (), 7)),
            mask (switchOnDate (), 8),
            toDouble (mask (voltageSensitivity (), 9)),
            masks (ShuntCompensatorPhase (), 10),
            masks (SvShuntCompensatorSections (), 11)
        )
        ret.bitfields = bitfields
        ret
    }
}

object ShuntCompensatorSerializer extends CIMSerializer[ShuntCompensator]
{
    def write (kryo: Kryo, output: Output, obj: ShuntCompensator): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.aVRDelay),
            () => output.writeBoolean (obj.grounded),
            () => output.writeInt (obj.maximumSections),
            () => output.writeDouble (obj.nomU),
            () => output.writeInt (obj.normalSections),
            () => output.writeString (obj.phaseConnection),
            () => output.writeDouble (obj.sections),
            () => output.writeInt (obj.switchOnCount),
            () => output.writeString (obj.switchOnDate),
            () => output.writeDouble (obj.voltageSensitivity),
            () => writeList (obj.ShuntCompensatorPhase, output),
            () => writeList (obj.SvShuntCompensatorSections, output)
        )
        RegulatingCondEqSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ShuntCompensator]): ShuntCompensator =
    {
        val parent = RegulatingCondEqSerializer.read (kryo, input, classOf[RegulatingCondEq])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ShuntCompensator (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readBoolean else false,
            if (isSet (2)) input.readInt else 0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readInt else 0,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readDouble else 0.0,
            if (isSet (7)) input.readInt else 0,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) input.readDouble else 0.0,
            if (isSet (10)) readList (input) else null,
            if (isSet (11)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Single phase of a multi-phase shunt compensator when its attributes might be different per phase.
 *
 * @param PowerSystemResource [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param maximumSections The maximum number of sections that may be switched in for this phase.
 * @param normalSections For the capacitor phase, the normal number of sections switched in.
 * @param phase Phase of this shunt compensator component.
 *        If the shunt compensator is wye connected, the connection is from the indicated phase to the central ground or neutral point.  If the shunt compensator is delta connected, the phase indicates a shunt compensator connected from the indicated phase to the next logical non-neutral phase.
 * @param ShuntCompensator [[ch.ninecode.model.ShuntCompensator ShuntCompensator]] Shunt compensator of this shunt compensator phase.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class ShuntCompensatorPhase
(
    PowerSystemResource: PowerSystemResource = null,
    maximumSections: Int = 0,
    normalSections: Int = 0,
    phase: String = null,
    ShuntCompensator: String = null
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
        implicit val clz: String = ShuntCompensatorPhase.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ShuntCompensatorPhase.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ShuntCompensatorPhase.fields (position), value)
        emitelem (0, maximumSections)
        emitelem (1, normalSections)
        emitattr (2, phase)
        emitattr (3, ShuntCompensator)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ShuntCompensatorPhase rdf:ID=\"%s\">\n%s\t</cim:ShuntCompensatorPhase>".format (id, export_fields)
    }
}

object ShuntCompensatorPhase
extends
    CIMParseable[ShuntCompensatorPhase]
{
    override val fields: Array[String] = Array[String] (
        "maximumSections",
        "normalSections",
        "phase",
        "ShuntCompensator"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ShuntCompensator", "ShuntCompensator", "1", "0..*")
    )
    val maximumSections: Fielder = parse_element (element (cls, fields(0)))
    val normalSections: Fielder = parse_element (element (cls, fields(1)))
    val phase: Fielder = parse_attribute (attribute (cls, fields(2)))
    val ShuntCompensator: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: CIMContext): ShuntCompensatorPhase =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ShuntCompensatorPhase (
            PowerSystemResource.parse (context),
            toInteger (mask (maximumSections (), 0)),
            toInteger (mask (normalSections (), 1)),
            mask (phase (), 2),
            mask (ShuntCompensator (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

object ShuntCompensatorPhaseSerializer extends CIMSerializer[ShuntCompensatorPhase]
{
    def write (kryo: Kryo, output: Output, obj: ShuntCompensatorPhase): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeInt (obj.maximumSections),
            () => output.writeInt (obj.normalSections),
            () => output.writeString (obj.phase),
            () => output.writeString (obj.ShuntCompensator)
        )
        PowerSystemResourceSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ShuntCompensatorPhase]): ShuntCompensatorPhase =
    {
        val parent = PowerSystemResourceSerializer.read (kryo, input, classOf[PowerSystemResource])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ShuntCompensatorPhase (
            parent,
            if (isSet (0)) input.readInt else 0,
            if (isSet (1)) input.readInt else 0,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A facility for providing variable and controllable shunt reactive power.
 *
 * The SVC typically consists of a stepdown transformer, filter, thyristor-controlled reactor, and thyristor-switched capacitor arms.
 *
 * The SVC may operate in fixed MVar output mode or in voltage control mode. When in voltage control mode, the output of the SVC will be proportional to the deviation of voltage at the controlled bus from the voltage setpoint.  The SVC characteristic slope defines the proportion.  If the voltage at the controlled bus is equal to the voltage setpoint, the SVC MVar output is zero.
 *
 * @param RegulatingCondEq [[ch.ninecode.model.RegulatingCondEq RegulatingCondEq]] Reference to the superclass object.
 * @param capacitiveRating Capacitive reactance at maximum capacitive reactive power.
 *        Shall always be positive.
 * @param inductiveRating Inductive reactance at maximum inductive reactive power.
 *        Shall always be negative.
 * @param q Reactive power injection.
 *        Load sign convention is used, i.e. positive sign means flow out from a node.
 *        Starting value for a steady state solution.
 * @param sVCControlMode SVC control mode.
 * @param slope The characteristics slope of an SVC defines how the reactive power output changes in proportion to the difference between the regulated bus voltage and the voltage setpoint.
 * @param voltageSetPoint The reactive power output of the SVC is proportional to the difference between the voltage at the regulated bus and the voltage setpoint.
 *        When the regulated bus voltage is equal to the voltage setpoint, the reactive power output is zero.
 * @param StaticVarCompensatorDynamics [[ch.ninecode.model.StaticVarCompensatorDynamics StaticVarCompensatorDynamics]] Static Var Compensator dynamics model used to describe dynamic behaviour of this Static Var Compensator.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class StaticVarCompensator
(
    RegulatingCondEq: RegulatingCondEq = null,
    capacitiveRating: Double = 0.0,
    inductiveRating: Double = 0.0,
    q: Double = 0.0,
    sVCControlMode: String = null,
    slope: Double = 0.0,
    voltageSetPoint: Double = 0.0,
    StaticVarCompensatorDynamics: String = null
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
    override def sup: RegulatingCondEq = RegulatingCondEq

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
        implicit val clz: String = StaticVarCompensator.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (StaticVarCompensator.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (StaticVarCompensator.fields (position), value)
        emitelem (0, capacitiveRating)
        emitelem (1, inductiveRating)
        emitelem (2, q)
        emitattr (3, sVCControlMode)
        emitelem (4, slope)
        emitelem (5, voltageSetPoint)
        emitattr (6, StaticVarCompensatorDynamics)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:StaticVarCompensator rdf:ID=\"%s\">\n%s\t</cim:StaticVarCompensator>".format (id, export_fields)
    }
}

object StaticVarCompensator
extends
    CIMParseable[StaticVarCompensator]
{
    override val fields: Array[String] = Array[String] (
        "capacitiveRating",
        "inductiveRating",
        "q",
        "sVCControlMode",
        "slope",
        "voltageSetPoint",
        "StaticVarCompensatorDynamics"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("StaticVarCompensatorDynamics", "StaticVarCompensatorDynamics", "0..1", "1")
    )
    val capacitiveRating: Fielder = parse_element (element (cls, fields(0)))
    val inductiveRating: Fielder = parse_element (element (cls, fields(1)))
    val q: Fielder = parse_element (element (cls, fields(2)))
    val sVCControlMode: Fielder = parse_attribute (attribute (cls, fields(3)))
    val slope: Fielder = parse_element (element (cls, fields(4)))
    val voltageSetPoint: Fielder = parse_element (element (cls, fields(5)))
    val StaticVarCompensatorDynamics: Fielder = parse_attribute (attribute (cls, fields(6)))

    def parse (context: CIMContext): StaticVarCompensator =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = StaticVarCompensator (
            RegulatingCondEq.parse (context),
            toDouble (mask (capacitiveRating (), 0)),
            toDouble (mask (inductiveRating (), 1)),
            toDouble (mask (q (), 2)),
            mask (sVCControlMode (), 3),
            toDouble (mask (slope (), 4)),
            toDouble (mask (voltageSetPoint (), 5)),
            mask (StaticVarCompensatorDynamics (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
}

object StaticVarCompensatorSerializer extends CIMSerializer[StaticVarCompensator]
{
    def write (kryo: Kryo, output: Output, obj: StaticVarCompensator): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.capacitiveRating),
            () => output.writeDouble (obj.inductiveRating),
            () => output.writeDouble (obj.q),
            () => output.writeString (obj.sVCControlMode),
            () => output.writeDouble (obj.slope),
            () => output.writeDouble (obj.voltageSetPoint),
            () => output.writeString (obj.StaticVarCompensatorDynamics)
        )
        RegulatingCondEqSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[StaticVarCompensator]): StaticVarCompensator =
    {
        val parent = RegulatingCondEqSerializer.read (kryo, input, classOf[RegulatingCondEq])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = StaticVarCompensator (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readDouble else 0.0,
            if (isSet (6)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A generic device designed to close, or open, or both, one or more electric circuits.
 *
 * All switches are two terminal devices including grounding switches.
 *
 * @param ConductingEquipment [[ch.ninecode.model.ConductingEquipment ConductingEquipment]] Reference to the superclass object.
 * @param normalOpen The attribute is used in cases when no Measurement for the status value is present.
 *        If the Switch has a status measurement the Discrete.normalValue is expected to match with the Switch.normalOpen.
 * @param open The attribute tells if the switch is considered open when used as input to topology processing.
 * @param ratedCurrent The maximum continuous current carrying capacity in amps governed by the device material and construction.
 * @param retained Branch is retained in the topological solution.
 *        The flow through retained switches will normally be calculated in power flow.
 * @param switchOnCount The switch on count since the switch was last reset or initialized.
 * @param switchOnDate The date and time when the switch was last switched on.
 * @param CompositeSwitch [[ch.ninecode.model.CompositeSwitch CompositeSwitch]] Composite switch to which this Switch belongs.
 * @param ConnectDisconnectFunctions [[ch.ninecode.model.ConnectDisconnectFunction ConnectDisconnectFunction]] <em>undocumented</em>
 * @param Outage [[ch.ninecode.model.Outage Outage]] Current outage of this protective device.
 * @param SvSwitch [[ch.ninecode.model.SvSwitch SvSwitch]] The switch state associated with the switch.
 * @param SwitchAction [[ch.ninecode.model.SwitchAction SwitchAction]] Action changing status of this switch.
 * @param SwitchPhase [[ch.ninecode.model.SwitchPhase SwitchPhase]] The individual switch phases for the switch.
 * @param SwitchSchedules [[ch.ninecode.model.SwitchSchedule SwitchSchedule]] A Switch can be associated with SwitchSchedules.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class Switch
(
    ConductingEquipment: ConductingEquipment = null,
    normalOpen: Boolean = false,
    open: Boolean = false,
    ratedCurrent: Double = 0.0,
    retained: Boolean = false,
    switchOnCount: Int = 0,
    switchOnDate: String = null,
    CompositeSwitch: String = null,
    ConnectDisconnectFunctions: List[String] = null,
    Outage: String = null,
    SvSwitch: List[String] = null,
    SwitchAction: String = null,
    SwitchPhase: List[String] = null,
    SwitchSchedules: List[String] = null
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
    override def sup: ConductingEquipment = ConductingEquipment

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
        implicit val clz: String = Switch.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Switch.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Switch.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Switch.fields (position), x))
        emitelem (0, normalOpen)
        emitelem (1, open)
        emitelem (2, ratedCurrent)
        emitelem (3, retained)
        emitelem (4, switchOnCount)
        emitelem (5, switchOnDate)
        emitattr (6, CompositeSwitch)
        emitattrs (7, ConnectDisconnectFunctions)
        emitattr (8, Outage)
        emitattrs (9, SvSwitch)
        emitattr (10, SwitchAction)
        emitattrs (11, SwitchPhase)
        emitattrs (12, SwitchSchedules)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Switch rdf:ID=\"%s\">\n%s\t</cim:Switch>".format (id, export_fields)
    }
}

object Switch
extends
    CIMParseable[Switch]
{
    override val fields: Array[String] = Array[String] (
        "normalOpen",
        "open",
        "ratedCurrent",
        "retained",
        "switchOnCount",
        "switchOnDate",
        "CompositeSwitch",
        "ConnectDisconnectFunctions",
        "Outage",
        "SvSwitch",
        "SwitchAction",
        "SwitchPhase",
        "SwitchSchedules"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("CompositeSwitch", "CompositeSwitch", "0..1", "0..*"),
        CIMRelationship ("ConnectDisconnectFunctions", "ConnectDisconnectFunction", "0..*", "0..*"),
        CIMRelationship ("Outage", "Outage", "0..1", "0..*"),
        CIMRelationship ("SvSwitch", "SvSwitch", "0..*", "1"),
        CIMRelationship ("SwitchAction", "SwitchAction", "0..1", "0..1"),
        CIMRelationship ("SwitchPhase", "SwitchPhase", "0..*", "1"),
        CIMRelationship ("SwitchSchedules", "SwitchSchedule", "0..*", "1")
    )
    val normalOpen: Fielder = parse_element (element (cls, fields(0)))
    val open: Fielder = parse_element (element (cls, fields(1)))
    val ratedCurrent: Fielder = parse_element (element (cls, fields(2)))
    val retained: Fielder = parse_element (element (cls, fields(3)))
    val switchOnCount: Fielder = parse_element (element (cls, fields(4)))
    val switchOnDate: Fielder = parse_element (element (cls, fields(5)))
    val CompositeSwitch: Fielder = parse_attribute (attribute (cls, fields(6)))
    val ConnectDisconnectFunctions: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val Outage: Fielder = parse_attribute (attribute (cls, fields(8)))
    val SvSwitch: FielderMultiple = parse_attributes (attribute (cls, fields(9)))
    val SwitchAction: Fielder = parse_attribute (attribute (cls, fields(10)))
    val SwitchPhase: FielderMultiple = parse_attributes (attribute (cls, fields(11)))
    val SwitchSchedules: FielderMultiple = parse_attributes (attribute (cls, fields(12)))

    def parse (context: CIMContext): Switch =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Switch (
            ConductingEquipment.parse (context),
            toBoolean (mask (normalOpen (), 0)),
            toBoolean (mask (open (), 1)),
            toDouble (mask (ratedCurrent (), 2)),
            toBoolean (mask (retained (), 3)),
            toInteger (mask (switchOnCount (), 4)),
            mask (switchOnDate (), 5),
            mask (CompositeSwitch (), 6),
            masks (ConnectDisconnectFunctions (), 7),
            mask (Outage (), 8),
            masks (SvSwitch (), 9),
            mask (SwitchAction (), 10),
            masks (SwitchPhase (), 11),
            masks (SwitchSchedules (), 12)
        )
        ret.bitfields = bitfields
        ret
    }
}

object SwitchSerializer extends CIMSerializer[Switch]
{
    def write (kryo: Kryo, output: Output, obj: Switch): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeBoolean (obj.normalOpen),
            () => output.writeBoolean (obj.open),
            () => output.writeDouble (obj.ratedCurrent),
            () => output.writeBoolean (obj.retained),
            () => output.writeInt (obj.switchOnCount),
            () => output.writeString (obj.switchOnDate),
            () => output.writeString (obj.CompositeSwitch),
            () => writeList (obj.ConnectDisconnectFunctions, output),
            () => output.writeString (obj.Outage),
            () => writeList (obj.SvSwitch, output),
            () => output.writeString (obj.SwitchAction),
            () => writeList (obj.SwitchPhase, output),
            () => writeList (obj.SwitchSchedules, output)
        )
        ConductingEquipmentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Switch]): Switch =
    {
        val parent = ConductingEquipmentSerializer.read (kryo, input, classOf[ConductingEquipment])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Switch (
            parent,
            if (isSet (0)) input.readBoolean else false,
            if (isSet (1)) input.readBoolean else false,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readBoolean else false,
            if (isSet (4)) input.readInt else 0,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) readList (input) else null,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) readList (input) else null,
            if (isSet (10)) input.readString else null,
            if (isSet (11)) readList (input) else null,
            if (isSet (12)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Single phase of a multi-phase switch when its attributes might be different per phase.
 *
 * @param PowerSystemResource [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param closed The attribute tells if the switch is considered closed when used as input to topology processing.
 * @param normalOpen Used in cases when no Measurement for the status value is present.
 *        If the SwitchPhase has a status measurement the Discrete.normalValue is expected to match with this value.
 * @param phaseSide1 Phase of this SwitchPhase on the side with terminal sequence number equal to 1.
 *        Should be a phase contained in that terminal’s phases attribute.
 * @param phaseSide2 Phase of this SwitchPhase on the side with terminal sequence number equal to 2.
 *        Should be a phase contained in that terminal’s Terminal.phases attribute.
 * @param ratedCurrent The maximum continuous current carrying capacity in amps governed by the device material and construction.
 * @param Switch [[ch.ninecode.model.Switch Switch]] The switch of the switch phase.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class SwitchPhase
(
    PowerSystemResource: PowerSystemResource = null,
    closed: Boolean = false,
    normalOpen: Boolean = false,
    phaseSide1: String = null,
    phaseSide2: String = null,
    ratedCurrent: Double = 0.0,
    Switch: String = null
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
        implicit val clz: String = SwitchPhase.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SwitchPhase.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SwitchPhase.fields (position), value)
        emitelem (0, closed)
        emitelem (1, normalOpen)
        emitattr (2, phaseSide1)
        emitattr (3, phaseSide2)
        emitelem (4, ratedCurrent)
        emitattr (5, Switch)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SwitchPhase rdf:ID=\"%s\">\n%s\t</cim:SwitchPhase>".format (id, export_fields)
    }
}

object SwitchPhase
extends
    CIMParseable[SwitchPhase]
{
    override val fields: Array[String] = Array[String] (
        "closed",
        "normalOpen",
        "phaseSide1",
        "phaseSide2",
        "ratedCurrent",
        "Switch"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Switch", "Switch", "1", "0..*")
    )
    val closed: Fielder = parse_element (element (cls, fields(0)))
    val normalOpen: Fielder = parse_element (element (cls, fields(1)))
    val phaseSide1: Fielder = parse_attribute (attribute (cls, fields(2)))
    val phaseSide2: Fielder = parse_attribute (attribute (cls, fields(3)))
    val ratedCurrent: Fielder = parse_element (element (cls, fields(4)))
    val Switch: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: CIMContext): SwitchPhase =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SwitchPhase (
            PowerSystemResource.parse (context),
            toBoolean (mask (closed (), 0)),
            toBoolean (mask (normalOpen (), 1)),
            mask (phaseSide1 (), 2),
            mask (phaseSide2 (), 3),
            toDouble (mask (ratedCurrent (), 4)),
            mask (Switch (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

object SwitchPhaseSerializer extends CIMSerializer[SwitchPhase]
{
    def write (kryo: Kryo, output: Output, obj: SwitchPhase): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeBoolean (obj.closed),
            () => output.writeBoolean (obj.normalOpen),
            () => output.writeString (obj.phaseSide1),
            () => output.writeString (obj.phaseSide2),
            () => output.writeDouble (obj.ratedCurrent),
            () => output.writeString (obj.Switch)
        )
        PowerSystemResourceSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[SwitchPhase]): SwitchPhase =
    {
        val parent = PowerSystemResourceSerializer.read (kryo, input, classOf[PowerSystemResource])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = SwitchPhase (
            parent,
            if (isSet (0)) input.readBoolean else false,
            if (isSet (1)) input.readBoolean else false,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A schedule of switch positions.
 *
 * If RegularTimePoint.value1 is 0, the switch is open.  If 1, the switch is closed.
 *
 * @param SeasonDayTypeSchedule [[ch.ninecode.model.SeasonDayTypeSchedule SeasonDayTypeSchedule]] Reference to the superclass object.
 * @param Switch [[ch.ninecode.model.Switch Switch]] A SwitchSchedule is associated with a Switch.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class SwitchSchedule
(
    SeasonDayTypeSchedule: SeasonDayTypeSchedule = null,
    Switch: String = null
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
    override def sup: SeasonDayTypeSchedule = SeasonDayTypeSchedule

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
        implicit val clz: String = SwitchSchedule.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SwitchSchedule.fields (position), value)
        emitattr (0, Switch)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SwitchSchedule rdf:ID=\"%s\">\n%s\t</cim:SwitchSchedule>".format (id, export_fields)
    }
}

object SwitchSchedule
extends
    CIMParseable[SwitchSchedule]
{
    override val fields: Array[String] = Array[String] (
        "Switch"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Switch", "Switch", "1", "0..*")
    )
    val Switch: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): SwitchSchedule =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SwitchSchedule (
            SeasonDayTypeSchedule.parse (context),
            mask (Switch (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

object SwitchScheduleSerializer extends CIMSerializer[SwitchSchedule]
{
    def write (kryo: Kryo, output: Output, obj: SwitchSchedule): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.Switch)
        )
        SeasonDayTypeScheduleSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[SwitchSchedule]): SwitchSchedule =
    {
        val parent = SeasonDayTypeScheduleSerializer.read (kryo, input, classOf[SeasonDayTypeSchedule])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = SwitchSchedule (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * An electromechanical device that operates with shaft rotating synchronously with the network.
 *
 * It is a single machine operating either as a generator or synchronous condenser or pump.
 *
 * @param RotatingMachine [[ch.ninecode.model.RotatingMachine RotatingMachine]] Reference to the superclass object.
 * @param aVRToManualLag Time delay required when switching from Automatic Voltage Regulation (AVR) to Manual for a lagging MVAr violation.
 * @param aVRToManualLead Time delay required when switching from Automatic Voltage Regulation (AVR) to Manual for a leading MVAr violation.
 * @param baseQ Default base reactive power value.
 *        This value represents the initial reactive power that can be used by any application function.
 * @param condenserP Active power consumed when in condenser mode operation.
 * @param coolantCondition Temperature or pressure of coolant medium.
 * @param coolantType Method of cooling the machine.
 * @param earthing Indicates whether or not the generator is earthed.
 *        Used for short circuit data exchange according to IEC 60909.
 * @param earthingStarPointR Generator star point earthing resistance (Re).
 *        Used for short circuit data exchange according to IEC 60909.
 * @param earthingStarPointX Generator star point earthing reactance (Xe).
 *        Used for short circuit data exchange according to IEC 60909.
 * @param ikk Steady-state short-circuit current (in A for the profile) of generator with compound excitation during 3-phase short circuit.
 *        - Ikk=0: Generator with no compound excitation.
 *        - Ikk&lt;&gt;0: Generator with compound excitation.
 *        Ikk is used to calculate the minimum steady-state short-circuit current for generators with compound excitation.
 *        (4.6.1.2 in IEC 60909-0:2001).
 *        Used only for single fed short circuit on a generator. (4.3.4.2. in IEC 60909-0:2001).
 * @param manualToAVR Time delay required when switching from Manual to Automatic Voltage Regulation.
 *        This value is used in the accelerating power reference frame for powerflow solutions.
 * @param maxQ Maximum reactive power limit.
 *        This is the maximum (nameplate) limit for the unit.
 * @param maxU Maximum voltage limit for the unit.
 * @param minQ Minimum reactive power limit for the unit.
 * @param minU Minimum voltage  limit for the unit.
 * @param mu Factor to calculate the breaking current (Section 4.5.2.1 in IEC 60909-0).
 *        Used only for single fed short circuit on a generator (Section 4.3.4.2. in IEC 60909-0).
 * @param operatingMode Current mode of operation.
 * @param qPercent Part of the coordinated reactive control that comes from this machine.
 *        The attribute is used as a participation factor not necessarily summing up to 100% for the participating devices in the control.
 * @param r Equivalent resistance (RG) of generator.
 *        RG is considered for the calculation of all currents, except for the calculation of the peak current ip. Used for short circuit data exchange according to IEC 60909.
 * @param r0 Zero sequence resistance of the synchronous machine.
 * @param r2 Negative sequence resistance.
 * @param referencePriority Priority of unit for use as powerflow voltage phase angle reference bus selection. 0 = don t care (default) 1 = highest priority. 2 is less than 1 and so on.
 * @param satDirectSubtransX Direct-axis subtransient reactance saturated, also known as Xd"sat.
 * @param satDirectSyncX Direct-axes saturated synchronous reactance (xdsat); reciprocal of short-circuit ration.
 *        Used for short circuit data exchange, only for single fed short circuit on a generator. (4.3.4.2. in IEC 60909-0:2001).
 * @param satDirectTransX Saturated Direct-axis transient reactance.
 *        The attribute is primarily used for short circuit calculations according to ANSI.
 * @param shortCircuitRotorType Type of rotor, used by short circuit applications, only for single fed short circuit according to IEC 60909.
 * @param type Modes that this synchronous machine can operate in.
 * @param voltageRegulationRange Range of generator voltage regulation (PG in IEC 60909-0) used for calculation of the impedance correction factor KG defined in IEC 60909-0.
 *        This attribute is used to describe the operating voltage of the generating unit.
 * @param x0 Zero sequence reactance of the synchronous machine.
 * @param x2 Negative sequence reactance.
 * @param InitialReactiveCapabilityCurve [[ch.ninecode.model.ReactiveCapabilityCurve ReactiveCapabilityCurve]] The default reactive capability curve for use by a synchronous machine.
 * @param PrimeMovers [[ch.ninecode.model.PrimeMover PrimeMover]] Prime movers that drive this SynchronousMachine.
 * @param ReactiveCapabilityCurves [[ch.ninecode.model.ReactiveCapabilityCurve ReactiveCapabilityCurve]] All available reactive capability curves for this synchronous machine.
 * @param SynchronousMachineDynamics [[ch.ninecode.model.SynchronousMachineDynamics SynchronousMachineDynamics]] Synchronous machine dynamics model used to describe dynamic behaviour of this synchronous machine.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class SynchronousMachine
(
    RotatingMachine: RotatingMachine = null,
    aVRToManualLag: Double = 0.0,
    aVRToManualLead: Double = 0.0,
    baseQ: Double = 0.0,
    condenserP: Double = 0.0,
    coolantCondition: Double = 0.0,
    coolantType: String = null,
    earthing: Boolean = false,
    earthingStarPointR: Double = 0.0,
    earthingStarPointX: Double = 0.0,
    ikk: Double = 0.0,
    manualToAVR: Double = 0.0,
    maxQ: Double = 0.0,
    maxU: Double = 0.0,
    minQ: Double = 0.0,
    minU: Double = 0.0,
    mu: Double = 0.0,
    operatingMode: String = null,
    qPercent: Double = 0.0,
    r: Double = 0.0,
    r0: Double = 0.0,
    r2: Double = 0.0,
    referencePriority: Int = 0,
    satDirectSubtransX: Double = 0.0,
    satDirectSyncX: Double = 0.0,
    satDirectTransX: Double = 0.0,
    shortCircuitRotorType: String = null,
    `type`: String = null,
    voltageRegulationRange: Double = 0.0,
    x0: Double = 0.0,
    x2: Double = 0.0,
    InitialReactiveCapabilityCurve: String = null,
    PrimeMovers: List[String] = null,
    ReactiveCapabilityCurves: List[String] = null,
    SynchronousMachineDynamics: String = null
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
    override def sup: RotatingMachine = RotatingMachine

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
        implicit val clz: String = SynchronousMachine.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SynchronousMachine.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SynchronousMachine.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (SynchronousMachine.fields (position), x))
        emitelem (0, aVRToManualLag)
        emitelem (1, aVRToManualLead)
        emitelem (2, baseQ)
        emitelem (3, condenserP)
        emitelem (4, coolantCondition)
        emitattr (5, coolantType)
        emitelem (6, earthing)
        emitelem (7, earthingStarPointR)
        emitelem (8, earthingStarPointX)
        emitelem (9, ikk)
        emitelem (10, manualToAVR)
        emitelem (11, maxQ)
        emitelem (12, maxU)
        emitelem (13, minQ)
        emitelem (14, minU)
        emitelem (15, mu)
        emitattr (16, operatingMode)
        emitelem (17, qPercent)
        emitelem (18, r)
        emitelem (19, r0)
        emitelem (20, r2)
        emitelem (21, referencePriority)
        emitelem (22, satDirectSubtransX)
        emitelem (23, satDirectSyncX)
        emitelem (24, satDirectTransX)
        emitattr (25, shortCircuitRotorType)
        emitattr (26, `type`)
        emitelem (27, voltageRegulationRange)
        emitelem (28, x0)
        emitelem (29, x2)
        emitattr (30, InitialReactiveCapabilityCurve)
        emitattrs (31, PrimeMovers)
        emitattrs (32, ReactiveCapabilityCurves)
        emitattr (33, SynchronousMachineDynamics)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SynchronousMachine rdf:ID=\"%s\">\n%s\t</cim:SynchronousMachine>".format (id, export_fields)
    }
}

object SynchronousMachine
extends
    CIMParseable[SynchronousMachine]
{
    override val fields: Array[String] = Array[String] (
        "aVRToManualLag",
        "aVRToManualLead",
        "baseQ",
        "condenserP",
        "coolantCondition",
        "coolantType",
        "earthing",
        "earthingStarPointR",
        "earthingStarPointX",
        "ikk",
        "manualToAVR",
        "maxQ",
        "maxU",
        "minQ",
        "minU",
        "mu",
        "operatingMode",
        "qPercent",
        "r",
        "r0",
        "r2",
        "referencePriority",
        "satDirectSubtransX",
        "satDirectSyncX",
        "satDirectTransX",
        "shortCircuitRotorType",
        "type",
        "voltageRegulationRange",
        "x0",
        "x2",
        "InitialReactiveCapabilityCurve",
        "PrimeMovers",
        "ReactiveCapabilityCurves",
        "SynchronousMachineDynamics"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("InitialReactiveCapabilityCurve", "ReactiveCapabilityCurve", "0..1", "1..*"),
        CIMRelationship ("PrimeMovers", "PrimeMover", "0..*", "0..*"),
        CIMRelationship ("ReactiveCapabilityCurves", "ReactiveCapabilityCurve", "0..*", "1..*"),
        CIMRelationship ("SynchronousMachineDynamics", "SynchronousMachineDynamics", "0..1", "1")
    )
    val aVRToManualLag: Fielder = parse_element (element (cls, fields(0)))
    val aVRToManualLead: Fielder = parse_element (element (cls, fields(1)))
    val baseQ: Fielder = parse_element (element (cls, fields(2)))
    val condenserP: Fielder = parse_element (element (cls, fields(3)))
    val coolantCondition: Fielder = parse_element (element (cls, fields(4)))
    val coolantType: Fielder = parse_attribute (attribute (cls, fields(5)))
    val earthing: Fielder = parse_element (element (cls, fields(6)))
    val earthingStarPointR: Fielder = parse_element (element (cls, fields(7)))
    val earthingStarPointX: Fielder = parse_element (element (cls, fields(8)))
    val ikk: Fielder = parse_element (element (cls, fields(9)))
    val manualToAVR: Fielder = parse_element (element (cls, fields(10)))
    val maxQ: Fielder = parse_element (element (cls, fields(11)))
    val maxU: Fielder = parse_element (element (cls, fields(12)))
    val minQ: Fielder = parse_element (element (cls, fields(13)))
    val minU: Fielder = parse_element (element (cls, fields(14)))
    val mu: Fielder = parse_element (element (cls, fields(15)))
    val operatingMode: Fielder = parse_attribute (attribute (cls, fields(16)))
    val qPercent: Fielder = parse_element (element (cls, fields(17)))
    val r: Fielder = parse_element (element (cls, fields(18)))
    val r0: Fielder = parse_element (element (cls, fields(19)))
    val r2: Fielder = parse_element (element (cls, fields(20)))
    val referencePriority: Fielder = parse_element (element (cls, fields(21)))
    val satDirectSubtransX: Fielder = parse_element (element (cls, fields(22)))
    val satDirectSyncX: Fielder = parse_element (element (cls, fields(23)))
    val satDirectTransX: Fielder = parse_element (element (cls, fields(24)))
    val shortCircuitRotorType: Fielder = parse_attribute (attribute (cls, fields(25)))
    val `type`: Fielder = parse_attribute (attribute (cls, fields(26)))
    val voltageRegulationRange: Fielder = parse_element (element (cls, fields(27)))
    val x0: Fielder = parse_element (element (cls, fields(28)))
    val x2: Fielder = parse_element (element (cls, fields(29)))
    val InitialReactiveCapabilityCurve: Fielder = parse_attribute (attribute (cls, fields(30)))
    val PrimeMovers: FielderMultiple = parse_attributes (attribute (cls, fields(31)))
    val ReactiveCapabilityCurves: FielderMultiple = parse_attributes (attribute (cls, fields(32)))
    val SynchronousMachineDynamics: Fielder = parse_attribute (attribute (cls, fields(33)))

    def parse (context: CIMContext): SynchronousMachine =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0,0)
        val ret = SynchronousMachine (
            RotatingMachine.parse (context),
            toDouble (mask (aVRToManualLag (), 0)),
            toDouble (mask (aVRToManualLead (), 1)),
            toDouble (mask (baseQ (), 2)),
            toDouble (mask (condenserP (), 3)),
            toDouble (mask (coolantCondition (), 4)),
            mask (coolantType (), 5),
            toBoolean (mask (earthing (), 6)),
            toDouble (mask (earthingStarPointR (), 7)),
            toDouble (mask (earthingStarPointX (), 8)),
            toDouble (mask (ikk (), 9)),
            toDouble (mask (manualToAVR (), 10)),
            toDouble (mask (maxQ (), 11)),
            toDouble (mask (maxU (), 12)),
            toDouble (mask (minQ (), 13)),
            toDouble (mask (minU (), 14)),
            toDouble (mask (mu (), 15)),
            mask (operatingMode (), 16),
            toDouble (mask (qPercent (), 17)),
            toDouble (mask (r (), 18)),
            toDouble (mask (r0 (), 19)),
            toDouble (mask (r2 (), 20)),
            toInteger (mask (referencePriority (), 21)),
            toDouble (mask (satDirectSubtransX (), 22)),
            toDouble (mask (satDirectSyncX (), 23)),
            toDouble (mask (satDirectTransX (), 24)),
            mask (shortCircuitRotorType (), 25),
            mask (`type` (), 26),
            toDouble (mask (voltageRegulationRange (), 27)),
            toDouble (mask (x0 (), 28)),
            toDouble (mask (x2 (), 29)),
            mask (InitialReactiveCapabilityCurve (), 30),
            masks (PrimeMovers (), 31),
            masks (ReactiveCapabilityCurves (), 32),
            mask (SynchronousMachineDynamics (), 33)
        )
        ret.bitfields = bitfields
        ret
    }
}

object SynchronousMachineSerializer extends CIMSerializer[SynchronousMachine]
{
    def write (kryo: Kryo, output: Output, obj: SynchronousMachine): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.aVRToManualLag),
            () => output.writeDouble (obj.aVRToManualLead),
            () => output.writeDouble (obj.baseQ),
            () => output.writeDouble (obj.condenserP),
            () => output.writeDouble (obj.coolantCondition),
            () => output.writeString (obj.coolantType),
            () => output.writeBoolean (obj.earthing),
            () => output.writeDouble (obj.earthingStarPointR),
            () => output.writeDouble (obj.earthingStarPointX),
            () => output.writeDouble (obj.ikk),
            () => output.writeDouble (obj.manualToAVR),
            () => output.writeDouble (obj.maxQ),
            () => output.writeDouble (obj.maxU),
            () => output.writeDouble (obj.minQ),
            () => output.writeDouble (obj.minU),
            () => output.writeDouble (obj.mu),
            () => output.writeString (obj.operatingMode),
            () => output.writeDouble (obj.qPercent),
            () => output.writeDouble (obj.r),
            () => output.writeDouble (obj.r0),
            () => output.writeDouble (obj.r2),
            () => output.writeInt (obj.referencePriority),
            () => output.writeDouble (obj.satDirectSubtransX),
            () => output.writeDouble (obj.satDirectSyncX),
            () => output.writeDouble (obj.satDirectTransX),
            () => output.writeString (obj.shortCircuitRotorType),
            () => output.writeString (obj.`type`),
            () => output.writeDouble (obj.voltageRegulationRange),
            () => output.writeDouble (obj.x0),
            () => output.writeDouble (obj.x2),
            () => output.writeString (obj.InitialReactiveCapabilityCurve),
            () => writeList (obj.PrimeMovers, output),
            () => writeList (obj.ReactiveCapabilityCurves, output),
            () => output.writeString (obj.SynchronousMachineDynamics)
        )
        RotatingMachineSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[SynchronousMachine]): SynchronousMachine =
    {
        val parent = RotatingMachineSerializer.read (kryo, input, classOf[RotatingMachine])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = SynchronousMachine (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readBoolean else false,
            if (isSet (7)) input.readDouble else 0.0,
            if (isSet (8)) input.readDouble else 0.0,
            if (isSet (9)) input.readDouble else 0.0,
            if (isSet (10)) input.readDouble else 0.0,
            if (isSet (11)) input.readDouble else 0.0,
            if (isSet (12)) input.readDouble else 0.0,
            if (isSet (13)) input.readDouble else 0.0,
            if (isSet (14)) input.readDouble else 0.0,
            if (isSet (15)) input.readDouble else 0.0,
            if (isSet (16)) input.readString else null,
            if (isSet (17)) input.readDouble else 0.0,
            if (isSet (18)) input.readDouble else 0.0,
            if (isSet (19)) input.readDouble else 0.0,
            if (isSet (20)) input.readDouble else 0.0,
            if (isSet (21)) input.readInt else 0,
            if (isSet (22)) input.readDouble else 0.0,
            if (isSet (23)) input.readDouble else 0.0,
            if (isSet (24)) input.readDouble else 0.0,
            if (isSet (25)) input.readString else null,
            if (isSet (26)) input.readString else null,
            if (isSet (27)) input.readDouble else 0.0,
            if (isSet (28)) input.readDouble else 0.0,
            if (isSet (29)) input.readDouble else 0.0,
            if (isSet (30)) input.readString else null,
            if (isSet (31)) readList (input) else null,
            if (isSet (32)) readList (input) else null,
            if (isSet (33)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Mechanism for changing transformer winding tap positions.
 *
 * @param PowerSystemResource [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param controlEnabled Specifies the regulation status of the equipment.
 *        True is regulating, false is not regulating.
 * @param highStep Highest possible tap step position, advance from neutral.
 *        The attribute shall be greater than lowStep.
 * @param initialDelay For an LTC, the delay for initial tap changer operation (first step change).
 * @param lowStep Lowest possible tap step position, retard from neutral.
 * @param ltcFlag Specifies whether or not a TapChanger has load tap changing capabilities.
 * @param neutralStep The neutral tap step position for this winding.
 *        The attribute shall be equal to or greater than lowStep and equal or less than highStep.
 *        It is the step position where the voltage is neutralU when the other terminals of the transformer are at the ratedU.  If there are other tap changers on the transformer those taps are kept constant at their neutralStep.
 * @param neutralU Voltage at which the winding operates at the neutral tap setting.
 *        It is the voltage at the terminal of the PowerTransformerEnd associated with the tap changer when all tap changers on the transformer are at their neutralStep position.  Normally neutralU of the tap changer is the same as ratedU of the PowerTransformerEnd, but it can differ in special cases such as when the tapping mechanism is separate from the winding more common on lower voltage transformers.
 *        This attribute is not relevant for PhaseTapChangerAsymmetrical, PhaseTapChangerSymmetrical and PhaseTapChangerLinear.
 * @param normalStep The tap step position used in "normal" network operation for this winding.
 *        For a "Fixed" tap changer indicates the current physical tap setting.
 *        The attribute shall be equal to or greater than lowStep and equal to or less than highStep.
 * @param step Tap changer position.
 *        Starting step for a steady state solution. Non integer values are allowed to support continuous tap variables. The reasons for continuous value are to support study cases where no discrete tap changer has yet been designed, a solution where a narrow voltage band forces the tap step to oscillate or to accommodate for a continuous solution as input.
 *        The attribute shall be equal to or greater than lowStep and equal to or less than highStep.
 * @param subsequentDelay For an LTC, the delay for subsequent tap changer operation (second and later step changes).
 * @param SvTapStep [[ch.ninecode.model.SvTapStep SvTapStep]] The tap step state associated with the tap changer.
 * @param TapChangerControl [[ch.ninecode.model.TapChangerControl TapChangerControl]] The regulating control scheme in which this tap changer participates.
 * @param TapSchedules [[ch.ninecode.model.TapSchedule TapSchedule]] A TapChanger can have TapSchedules.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class TapChanger
(
    PowerSystemResource: PowerSystemResource = null,
    controlEnabled: Boolean = false,
    highStep: Int = 0,
    initialDelay: Double = 0.0,
    lowStep: Int = 0,
    ltcFlag: Boolean = false,
    neutralStep: Int = 0,
    neutralU: Double = 0.0,
    normalStep: Int = 0,
    step: Double = 0.0,
    subsequentDelay: Double = 0.0,
    SvTapStep: String = null,
    TapChangerControl: String = null,
    TapSchedules: List[String] = null
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
        implicit val clz: String = TapChanger.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TapChanger.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TapChanger.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (TapChanger.fields (position), x))
        emitelem (0, controlEnabled)
        emitelem (1, highStep)
        emitelem (2, initialDelay)
        emitelem (3, lowStep)
        emitelem (4, ltcFlag)
        emitelem (5, neutralStep)
        emitelem (6, neutralU)
        emitelem (7, normalStep)
        emitelem (8, step)
        emitelem (9, subsequentDelay)
        emitattr (10, SvTapStep)
        emitattr (11, TapChangerControl)
        emitattrs (12, TapSchedules)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TapChanger rdf:ID=\"%s\">\n%s\t</cim:TapChanger>".format (id, export_fields)
    }
}

object TapChanger
extends
    CIMParseable[TapChanger]
{
    override val fields: Array[String] = Array[String] (
        "controlEnabled",
        "highStep",
        "initialDelay",
        "lowStep",
        "ltcFlag",
        "neutralStep",
        "neutralU",
        "normalStep",
        "step",
        "subsequentDelay",
        "SvTapStep",
        "TapChangerControl",
        "TapSchedules"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("SvTapStep", "SvTapStep", "0..1", "1"),
        CIMRelationship ("TapChangerControl", "TapChangerControl", "0..1", "0..*"),
        CIMRelationship ("TapSchedules", "TapSchedule", "0..*", "1")
    )
    val controlEnabled: Fielder = parse_element (element (cls, fields(0)))
    val highStep: Fielder = parse_element (element (cls, fields(1)))
    val initialDelay: Fielder = parse_element (element (cls, fields(2)))
    val lowStep: Fielder = parse_element (element (cls, fields(3)))
    val ltcFlag: Fielder = parse_element (element (cls, fields(4)))
    val neutralStep: Fielder = parse_element (element (cls, fields(5)))
    val neutralU: Fielder = parse_element (element (cls, fields(6)))
    val normalStep: Fielder = parse_element (element (cls, fields(7)))
    val step: Fielder = parse_element (element (cls, fields(8)))
    val subsequentDelay: Fielder = parse_element (element (cls, fields(9)))
    val SvTapStep: Fielder = parse_attribute (attribute (cls, fields(10)))
    val TapChangerControl: Fielder = parse_attribute (attribute (cls, fields(11)))
    val TapSchedules: FielderMultiple = parse_attributes (attribute (cls, fields(12)))

    def parse (context: CIMContext): TapChanger =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TapChanger (
            PowerSystemResource.parse (context),
            toBoolean (mask (controlEnabled (), 0)),
            toInteger (mask (highStep (), 1)),
            toDouble (mask (initialDelay (), 2)),
            toInteger (mask (lowStep (), 3)),
            toBoolean (mask (ltcFlag (), 4)),
            toInteger (mask (neutralStep (), 5)),
            toDouble (mask (neutralU (), 6)),
            toInteger (mask (normalStep (), 7)),
            toDouble (mask (step (), 8)),
            toDouble (mask (subsequentDelay (), 9)),
            mask (SvTapStep (), 10),
            mask (TapChangerControl (), 11),
            masks (TapSchedules (), 12)
        )
        ret.bitfields = bitfields
        ret
    }
}

object TapChangerSerializer extends CIMSerializer[TapChanger]
{
    def write (kryo: Kryo, output: Output, obj: TapChanger): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeBoolean (obj.controlEnabled),
            () => output.writeInt (obj.highStep),
            () => output.writeDouble (obj.initialDelay),
            () => output.writeInt (obj.lowStep),
            () => output.writeBoolean (obj.ltcFlag),
            () => output.writeInt (obj.neutralStep),
            () => output.writeDouble (obj.neutralU),
            () => output.writeInt (obj.normalStep),
            () => output.writeDouble (obj.step),
            () => output.writeDouble (obj.subsequentDelay),
            () => output.writeString (obj.SvTapStep),
            () => output.writeString (obj.TapChangerControl),
            () => writeList (obj.TapSchedules, output)
        )
        PowerSystemResourceSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TapChanger]): TapChanger =
    {
        val parent = PowerSystemResourceSerializer.read (kryo, input, classOf[PowerSystemResource])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = TapChanger (
            parent,
            if (isSet (0)) input.readBoolean else false,
            if (isSet (1)) input.readInt else 0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readInt else 0,
            if (isSet (4)) input.readBoolean else false,
            if (isSet (5)) input.readInt else 0,
            if (isSet (6)) input.readDouble else 0.0,
            if (isSet (7)) input.readInt else 0,
            if (isSet (8)) input.readDouble else 0.0,
            if (isSet (9)) input.readDouble else 0.0,
            if (isSet (10)) input.readString else null,
            if (isSet (11)) input.readString else null,
            if (isSet (12)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Describes behaviour specific to tap changers, e.g. how the voltage at the end of a line varies with the load level and compensation of the voltage drop by tap adjustment.
 *
 * @param RegulatingControl [[ch.ninecode.model.RegulatingControl RegulatingControl]] Reference to the superclass object.
 * @param limitVoltage Maximum allowed regulated voltage on the PT secondary, regardless of line drop compensation.
 *        Sometimes referred to as first-house protection.
 * @param lineDropCompensation If true, the line drop compensation is to be applied.
 * @param lineDropR Line drop compensator resistance setting for normal (forward) power flow.
 * @param lineDropX Line drop compensator reactance setting for normal (forward) power flow.
 * @param reverseLineDropR Line drop compensator resistance setting for reverse power flow.
 * @param reverseLineDropX Line drop compensator reactance setting for reverse power flow.
 * @param TapChanger [[ch.ninecode.model.TapChanger TapChanger]] The tap changers that participates in this regulating tap control scheme.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class TapChangerControl
(
    RegulatingControl: RegulatingControl = null,
    limitVoltage: Double = 0.0,
    lineDropCompensation: Boolean = false,
    lineDropR: Double = 0.0,
    lineDropX: Double = 0.0,
    reverseLineDropR: Double = 0.0,
    reverseLineDropX: Double = 0.0,
    TapChanger: List[String] = null
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
        implicit val clz: String = TapChangerControl.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TapChangerControl.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (TapChangerControl.fields (position), x))
        emitelem (0, limitVoltage)
        emitelem (1, lineDropCompensation)
        emitelem (2, lineDropR)
        emitelem (3, lineDropX)
        emitelem (4, reverseLineDropR)
        emitelem (5, reverseLineDropX)
        emitattrs (6, TapChanger)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TapChangerControl rdf:ID=\"%s\">\n%s\t</cim:TapChangerControl>".format (id, export_fields)
    }
}

object TapChangerControl
extends
    CIMParseable[TapChangerControl]
{
    override val fields: Array[String] = Array[String] (
        "limitVoltage",
        "lineDropCompensation",
        "lineDropR",
        "lineDropX",
        "reverseLineDropR",
        "reverseLineDropX",
        "TapChanger"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("TapChanger", "TapChanger", "0..*", "0..1")
    )
    val limitVoltage: Fielder = parse_element (element (cls, fields(0)))
    val lineDropCompensation: Fielder = parse_element (element (cls, fields(1)))
    val lineDropR: Fielder = parse_element (element (cls, fields(2)))
    val lineDropX: Fielder = parse_element (element (cls, fields(3)))
    val reverseLineDropR: Fielder = parse_element (element (cls, fields(4)))
    val reverseLineDropX: Fielder = parse_element (element (cls, fields(5)))
    val TapChanger: FielderMultiple = parse_attributes (attribute (cls, fields(6)))

    def parse (context: CIMContext): TapChangerControl =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TapChangerControl (
            RegulatingControl.parse (context),
            toDouble (mask (limitVoltage (), 0)),
            toBoolean (mask (lineDropCompensation (), 1)),
            toDouble (mask (lineDropR (), 2)),
            toDouble (mask (lineDropX (), 3)),
            toDouble (mask (reverseLineDropR (), 4)),
            toDouble (mask (reverseLineDropX (), 5)),
            masks (TapChanger (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
}

object TapChangerControlSerializer extends CIMSerializer[TapChangerControl]
{
    def write (kryo: Kryo, output: Output, obj: TapChangerControl): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.limitVoltage),
            () => output.writeBoolean (obj.lineDropCompensation),
            () => output.writeDouble (obj.lineDropR),
            () => output.writeDouble (obj.lineDropX),
            () => output.writeDouble (obj.reverseLineDropR),
            () => output.writeDouble (obj.reverseLineDropX),
            () => writeList (obj.TapChanger, output)
        )
        RegulatingControlSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TapChangerControl]): TapChangerControl =
    {
        val parent = RegulatingControlSerializer.read (kryo, input, classOf[RegulatingControl])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = TapChangerControl (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readBoolean else false,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readDouble else 0.0,
            if (isSet (6)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Describes each tap step in the tabular curve.
 *
 * @param Element Reference to the superclass object.
 * @param b The magnetizing branch susceptance deviation as a percentage of nominal value.
 *        The actual susceptance is calculated as follows:
 *        calculated magnetizing susceptance = b(nominal) * (1 + b(from this class)/100).   The b(nominal) is defined as the static magnetizing susceptance on the associated power transformer end or ends.  This model assumes the star impedance (pi model) form.
 * @param g The magnetizing branch conductance deviation as a percentage of nominal value.
 *        The actual conductance is calculated as follows:
 *        calculated magnetizing conductance = g(nominal) * (1 + g(from this class)/100).   The g(nominal) is defined as the static magnetizing conductance on the associated power transformer end or ends.  This model assumes the star impedance (pi model) form.
 * @param r The resistance deviation as a percentage of nominal value.
 *        The actual reactance is calculated as follows:
 *        calculated resistance = r(nominal) * (1 + r(from this class)/100).   The r(nominal) is defined as the static resistance on the associated power transformer end or ends.  This model assumes the star impedance (pi model) form.
 * @param ratio The voltage at the tap step divided by rated voltage of the transformer end having the tap changer.
 *        Hence this is a value close to one.
 *        For example, if the ratio at step 1 is 1.01, and the rated voltage of the transformer end is 110kV, then the voltage obtained by setting the tap changer to step 1 to is 111.1kV.
 * @param step The tap step.
 * @param x The series reactance deviation as a percentage of nominal value.
 *        The actual reactance is calculated as follows:
 *        calculated reactance = x(nominal) * (1 + x(from this class)/100).   The x(nominal) is defined as the static series reactance on the associated power transformer end or ends.  This model assumes the star impedance (pi model) form.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class TapChangerTablePoint
(
    Element: BasicElement = null,
    b: Double = 0.0,
    g: Double = 0.0,
    r: Double = 0.0,
    ratio: Double = 0.0,
    step: Int = 0,
    x: Double = 0.0
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
    override def sup: Element = Element

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
        implicit val clz: String = TapChangerTablePoint.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TapChangerTablePoint.fields (position), value)
        emitelem (0, b)
        emitelem (1, g)
        emitelem (2, r)
        emitelem (3, ratio)
        emitelem (4, step)
        emitelem (5, x)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TapChangerTablePoint rdf:ID=\"%s\">\n%s\t</cim:TapChangerTablePoint>".format (id, export_fields)
    }
}

object TapChangerTablePoint
extends
    CIMParseable[TapChangerTablePoint]
{
    override val fields: Array[String] = Array[String] (
        "b",
        "g",
        "r",
        "ratio",
        "step",
        "x"
    )
    val b: Fielder = parse_element (element (cls, fields(0)))
    val g: Fielder = parse_element (element (cls, fields(1)))
    val r: Fielder = parse_element (element (cls, fields(2)))
    val ratio: Fielder = parse_element (element (cls, fields(3)))
    val step: Fielder = parse_element (element (cls, fields(4)))
    val x: Fielder = parse_element (element (cls, fields(5)))

    def parse (context: CIMContext): TapChangerTablePoint =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TapChangerTablePoint (
            BasicElement.parse (context),
            toDouble (mask (b (), 0)),
            toDouble (mask (g (), 1)),
            toDouble (mask (r (), 2)),
            toDouble (mask (ratio (), 3)),
            toInteger (mask (step (), 4)),
            toDouble (mask (x (), 5))
        )
        ret.bitfields = bitfields
        ret
    }
}

object TapChangerTablePointSerializer extends CIMSerializer[TapChangerTablePoint]
{
    def write (kryo: Kryo, output: Output, obj: TapChangerTablePoint): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.b),
            () => output.writeDouble (obj.g),
            () => output.writeDouble (obj.r),
            () => output.writeDouble (obj.ratio),
            () => output.writeInt (obj.step),
            () => output.writeDouble (obj.x)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TapChangerTablePoint]): TapChangerTablePoint =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = TapChangerTablePoint (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readInt else 0,
            if (isSet (5)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A pre-established pattern over time for a tap step.
 *
 * @param SeasonDayTypeSchedule [[ch.ninecode.model.SeasonDayTypeSchedule SeasonDayTypeSchedule]] Reference to the superclass object.
 * @param TapChanger [[ch.ninecode.model.TapChanger TapChanger]] A TapSchedule is associated with a TapChanger.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class TapSchedule
(
    SeasonDayTypeSchedule: SeasonDayTypeSchedule = null,
    TapChanger: String = null
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
    override def sup: SeasonDayTypeSchedule = SeasonDayTypeSchedule

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
        implicit val clz: String = TapSchedule.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TapSchedule.fields (position), value)
        emitattr (0, TapChanger)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TapSchedule rdf:ID=\"%s\">\n%s\t</cim:TapSchedule>".format (id, export_fields)
    }
}

object TapSchedule
extends
    CIMParseable[TapSchedule]
{
    override val fields: Array[String] = Array[String] (
        "TapChanger"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("TapChanger", "TapChanger", "1", "0..*")
    )
    val TapChanger: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): TapSchedule =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TapSchedule (
            SeasonDayTypeSchedule.parse (context),
            mask (TapChanger (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

object TapScheduleSerializer extends CIMSerializer[TapSchedule]
{
    def write (kryo: Kryo, output: Output, obj: TapSchedule): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.TapChanger)
        )
        SeasonDayTypeScheduleSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TapSchedule]): TapSchedule =
    {
        val parent = SeasonDayTypeScheduleSerializer.read (kryo, input, classOf[SeasonDayTypeSchedule])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = TapSchedule (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The transformer core admittance.
 *
 * Used to specify the core admittance of a transformer in a manner that can be shared among power transformers.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param b Magnetizing branch susceptance (B mag).
 *        The value can be positive or negative.
 * @param b0 Zero sequence magnetizing branch susceptance.
 * @param g Magnetizing branch conductance (G mag).
 * @param g0 Zero sequence magnetizing branch conductance.
 * @param TransformerEnd [[ch.ninecode.model.TransformerEnd TransformerEnd]] All transformer ends having this core admittance.
 * @param TransformerEndInfo [[ch.ninecode.model.TransformerEndInfo TransformerEndInfo]] Transformer end datasheet used to calculate this core admittance.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class TransformerCoreAdmittance
(
    IdentifiedObject: IdentifiedObject = null,
    b: Double = 0.0,
    b0: Double = 0.0,
    g: Double = 0.0,
    g0: Double = 0.0,
    TransformerEnd: List[String] = null,
    TransformerEndInfo: String = null
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
        implicit val clz: String = TransformerCoreAdmittance.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TransformerCoreAdmittance.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TransformerCoreAdmittance.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (TransformerCoreAdmittance.fields (position), x))
        emitelem (0, b)
        emitelem (1, b0)
        emitelem (2, g)
        emitelem (3, g0)
        emitattrs (4, TransformerEnd)
        emitattr (5, TransformerEndInfo)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TransformerCoreAdmittance rdf:ID=\"%s\">\n%s\t</cim:TransformerCoreAdmittance>".format (id, export_fields)
    }
}

object TransformerCoreAdmittance
extends
    CIMParseable[TransformerCoreAdmittance]
{
    override val fields: Array[String] = Array[String] (
        "b",
        "b0",
        "g",
        "g0",
        "TransformerEnd",
        "TransformerEndInfo"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("TransformerEnd", "TransformerEnd", "0..*", "0..1"),
        CIMRelationship ("TransformerEndInfo", "TransformerEndInfo", "0..1", "0..1")
    )
    val b: Fielder = parse_element (element (cls, fields(0)))
    val b0: Fielder = parse_element (element (cls, fields(1)))
    val g: Fielder = parse_element (element (cls, fields(2)))
    val g0: Fielder = parse_element (element (cls, fields(3)))
    val TransformerEnd: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val TransformerEndInfo: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: CIMContext): TransformerCoreAdmittance =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TransformerCoreAdmittance (
            IdentifiedObject.parse (context),
            toDouble (mask (b (), 0)),
            toDouble (mask (b0 (), 1)),
            toDouble (mask (g (), 2)),
            toDouble (mask (g0 (), 3)),
            masks (TransformerEnd (), 4),
            mask (TransformerEndInfo (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

object TransformerCoreAdmittanceSerializer extends CIMSerializer[TransformerCoreAdmittance]
{
    def write (kryo: Kryo, output: Output, obj: TransformerCoreAdmittance): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.b),
            () => output.writeDouble (obj.b0),
            () => output.writeDouble (obj.g),
            () => output.writeDouble (obj.g0),
            () => writeList (obj.TransformerEnd, output),
            () => output.writeString (obj.TransformerEndInfo)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TransformerCoreAdmittance]): TransformerCoreAdmittance =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = TransformerCoreAdmittance (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) readList (input) else null,
            if (isSet (5)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A conducting connection point of a power transformer.
 *
 * It corresponds to a physical transformer winding terminal.  In earlier CIM versions, the TransformerWinding class served a similar purpose, but this class is more flexible because it associates to terminal but is not a specialization of ConductingEquipment.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param bmagSat Core shunt magnetizing susceptance in the saturation region.
 * @param endNumber Number for this transformer end, corresponding to the end's order in the power transformer vector group or phase angle clock number.
 *        Highest voltage winding should be 1.  Each end within a power transformer should have a unique subsequent end number.   Note the transformer end number need not match the terminal sequence number.
 * @param grounded (for Yn and Zn connections) True if the neutral is solidly grounded.
 * @param magBaseU The reference voltage at which the magnetizing saturation measurements were made.
 * @param magSatFlux Core magnetizing saturation curve knee flux level.
 * @param rground (for Yn and Zn connections) Resistance part of neutral impedance where 'grounded' is true.
 * @param xground (for Yn and Zn connections) Reactive part of neutral impedance where 'grounded' is true.
 * @param BaseVoltage [[ch.ninecode.model.BaseVoltage BaseVoltage]] Base voltage of the transformer end.
 *        This is essential for PU calculation.
 * @param CoreAdmittance [[ch.ninecode.model.TransformerCoreAdmittance TransformerCoreAdmittance]] Core admittance of this transformer end, representing magnetising current and core losses.
 *        The full values of the transformer should be supplied for one transformer end only.
 * @param FromMeshImpedance [[ch.ninecode.model.TransformerMeshImpedance TransformerMeshImpedance]] All mesh impedances between this 'to' and other 'from' transformer ends.
 * @param FromWindingInsulations [[ch.ninecode.model.WindingInsulation WindingInsulation]] <em>undocumented</em>
 * @param PhaseTapChanger [[ch.ninecode.model.PhaseTapChanger PhaseTapChanger]] Phase tap changer associated with this transformer end.
 * @param RatioTapChanger [[ch.ninecode.model.RatioTapChanger RatioTapChanger]] Ratio tap changer associated with this transformer end.
 * @param StarImpedance [[ch.ninecode.model.TransformerStarImpedance TransformerStarImpedance]] (accurate for 2- or 3-winding transformers only) Pi-model impedances of this transformer end.
 *        By convention, for a two winding transformer, the full values of the transformer should be entered on the high voltage end (endNumber=1).
 * @param Terminal [[ch.ninecode.model.Terminal Terminal]] Terminal of the power transformer to which this transformer end belongs.
 * @param ToMeshImpedance [[ch.ninecode.model.TransformerMeshImpedance TransformerMeshImpedance]] All mesh impedances between this 'from' and other 'to' transformer ends.
 * @param ToWindingInsulations [[ch.ninecode.model.WindingInsulation WindingInsulation]] <em>undocumented</em>
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class TransformerEnd
(
    IdentifiedObject: IdentifiedObject = null,
    bmagSat: Double = 0.0,
    endNumber: Int = 0,
    grounded: Boolean = false,
    magBaseU: Double = 0.0,
    magSatFlux: Double = 0.0,
    rground: Double = 0.0,
    xground: Double = 0.0,
    BaseVoltage: String = null,
    CoreAdmittance: String = null,
    FromMeshImpedance: List[String] = null,
    FromWindingInsulations: List[String] = null,
    PhaseTapChanger: String = null,
    RatioTapChanger: String = null,
    StarImpedance: String = null,
    Terminal: String = null,
    ToMeshImpedance: List[String] = null,
    ToWindingInsulations: List[String] = null
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
        implicit val clz: String = TransformerEnd.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TransformerEnd.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TransformerEnd.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (TransformerEnd.fields (position), x))
        emitelem (0, bmagSat)
        emitelem (1, endNumber)
        emitelem (2, grounded)
        emitelem (3, magBaseU)
        emitelem (4, magSatFlux)
        emitelem (5, rground)
        emitelem (6, xground)
        emitattr (7, BaseVoltage)
        emitattr (8, CoreAdmittance)
        emitattrs (9, FromMeshImpedance)
        emitattrs (10, FromWindingInsulations)
        emitattr (11, PhaseTapChanger)
        emitattr (12, RatioTapChanger)
        emitattr (13, StarImpedance)
        emitattr (14, Terminal)
        emitattrs (15, ToMeshImpedance)
        emitattrs (16, ToWindingInsulations)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TransformerEnd rdf:ID=\"%s\">\n%s\t</cim:TransformerEnd>".format (id, export_fields)
    }
}

object TransformerEnd
extends
    CIMParseable[TransformerEnd]
{
    override val fields: Array[String] = Array[String] (
        "bmagSat",
        "endNumber",
        "grounded",
        "magBaseU",
        "magSatFlux",
        "rground",
        "xground",
        "BaseVoltage",
        "CoreAdmittance",
        "FromMeshImpedance",
        "FromWindingInsulations",
        "PhaseTapChanger",
        "RatioTapChanger",
        "StarImpedance",
        "Terminal",
        "ToMeshImpedance",
        "ToWindingInsulations"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("BaseVoltage", "BaseVoltage", "0..1", "0..*"),
        CIMRelationship ("CoreAdmittance", "TransformerCoreAdmittance", "0..1", "0..*"),
        CIMRelationship ("FromMeshImpedance", "TransformerMeshImpedance", "0..*", "1"),
        CIMRelationship ("FromWindingInsulations", "WindingInsulation", "0..*", "1"),
        CIMRelationship ("PhaseTapChanger", "PhaseTapChanger", "0..1", "1"),
        CIMRelationship ("RatioTapChanger", "RatioTapChanger", "0..1", "1"),
        CIMRelationship ("StarImpedance", "TransformerStarImpedance", "0..1", "0..*"),
        CIMRelationship ("Terminal", "Terminal", "0..1", "0..*"),
        CIMRelationship ("ToMeshImpedance", "TransformerMeshImpedance", "0..*", "1..*"),
        CIMRelationship ("ToWindingInsulations", "WindingInsulation", "0..*", "1")
    )
    val bmagSat: Fielder = parse_element (element (cls, fields(0)))
    val endNumber: Fielder = parse_element (element (cls, fields(1)))
    val grounded: Fielder = parse_element (element (cls, fields(2)))
    val magBaseU: Fielder = parse_element (element (cls, fields(3)))
    val magSatFlux: Fielder = parse_element (element (cls, fields(4)))
    val rground: Fielder = parse_element (element (cls, fields(5)))
    val xground: Fielder = parse_element (element (cls, fields(6)))
    val BaseVoltage: Fielder = parse_attribute (attribute (cls, fields(7)))
    val CoreAdmittance: Fielder = parse_attribute (attribute (cls, fields(8)))
    val FromMeshImpedance: FielderMultiple = parse_attributes (attribute (cls, fields(9)))
    val FromWindingInsulations: FielderMultiple = parse_attributes (attribute (cls, fields(10)))
    val PhaseTapChanger: Fielder = parse_attribute (attribute (cls, fields(11)))
    val RatioTapChanger: Fielder = parse_attribute (attribute (cls, fields(12)))
    val StarImpedance: Fielder = parse_attribute (attribute (cls, fields(13)))
    val Terminal: Fielder = parse_attribute (attribute (cls, fields(14)))
    val ToMeshImpedance: FielderMultiple = parse_attributes (attribute (cls, fields(15)))
    val ToWindingInsulations: FielderMultiple = parse_attributes (attribute (cls, fields(16)))

    def parse (context: CIMContext): TransformerEnd =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TransformerEnd (
            IdentifiedObject.parse (context),
            toDouble (mask (bmagSat (), 0)),
            toInteger (mask (endNumber (), 1)),
            toBoolean (mask (grounded (), 2)),
            toDouble (mask (magBaseU (), 3)),
            toDouble (mask (magSatFlux (), 4)),
            toDouble (mask (rground (), 5)),
            toDouble (mask (xground (), 6)),
            mask (BaseVoltage (), 7),
            mask (CoreAdmittance (), 8),
            masks (FromMeshImpedance (), 9),
            masks (FromWindingInsulations (), 10),
            mask (PhaseTapChanger (), 11),
            mask (RatioTapChanger (), 12),
            mask (StarImpedance (), 13),
            mask (Terminal (), 14),
            masks (ToMeshImpedance (), 15),
            masks (ToWindingInsulations (), 16)
        )
        ret.bitfields = bitfields
        ret
    }
}

object TransformerEndSerializer extends CIMSerializer[TransformerEnd]
{
    def write (kryo: Kryo, output: Output, obj: TransformerEnd): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.bmagSat),
            () => output.writeInt (obj.endNumber),
            () => output.writeBoolean (obj.grounded),
            () => output.writeDouble (obj.magBaseU),
            () => output.writeDouble (obj.magSatFlux),
            () => output.writeDouble (obj.rground),
            () => output.writeDouble (obj.xground),
            () => output.writeString (obj.BaseVoltage),
            () => output.writeString (obj.CoreAdmittance),
            () => writeList (obj.FromMeshImpedance, output),
            () => writeList (obj.FromWindingInsulations, output),
            () => output.writeString (obj.PhaseTapChanger),
            () => output.writeString (obj.RatioTapChanger),
            () => output.writeString (obj.StarImpedance),
            () => output.writeString (obj.Terminal),
            () => writeList (obj.ToMeshImpedance, output),
            () => writeList (obj.ToWindingInsulations, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TransformerEnd]): TransformerEnd =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = TransformerEnd (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readInt else 0,
            if (isSet (2)) input.readBoolean else false,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readDouble else 0.0,
            if (isSet (6)) input.readDouble else 0.0,
            if (isSet (7)) input.readString else null,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) readList (input) else null,
            if (isSet (10)) readList (input) else null,
            if (isSet (11)) input.readString else null,
            if (isSet (12)) input.readString else null,
            if (isSet (13)) input.readString else null,
            if (isSet (14)) input.readString else null,
            if (isSet (15)) readList (input) else null,
            if (isSet (16)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Transformer mesh impedance (Delta-model) between transformer ends.
 *
 * The typical case is that this class describes the impedance between two transformer ends pair-wise, i.e. the cardinalities at both transformer end associations are 1. However, in cases where two or more transformer ends are modelled the cardinalities are larger than 1.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param r Resistance between the 'from' and the 'to' end, seen from the 'from' end.
 * @param r0 Zero-sequence resistance between the 'from' and the 'to' end, seen from the 'from' end.
 * @param x Reactance between the 'from' and the 'to' end, seen from the 'from' end.
 * @param x0 Zero-sequence reactance between the 'from' and the 'to' end, seen from the 'from' end.
 * @param FromTransformerEnd [[ch.ninecode.model.TransformerEnd TransformerEnd]] From end this mesh impedance is connected to.
 *        It determines the voltage reference.
 * @param FromTransformerEndInfo [[ch.ninecode.model.TransformerEndInfo TransformerEndInfo]] 'from' transformer end datasheet this mesh impedance is calculated from.
 *        It determines the voltage reference.
 * @param ToTransformerEnd [[ch.ninecode.model.TransformerEnd TransformerEnd]] All transformer ends this mesh impedance is connected to.
 * @param ToTransformerEndInfos [[ch.ninecode.model.TransformerEndInfo TransformerEndInfo]] All 'to' transformer end datasheets this mesh impedance for 'from' transformer end is calculated from.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class TransformerMeshImpedance
(
    IdentifiedObject: IdentifiedObject = null,
    r: Double = 0.0,
    r0: Double = 0.0,
    x: Double = 0.0,
    x0: Double = 0.0,
    FromTransformerEnd: String = null,
    FromTransformerEndInfo: String = null,
    ToTransformerEnd: List[String] = null,
    ToTransformerEndInfos: List[String] = null
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
        implicit val clz: String = TransformerMeshImpedance.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TransformerMeshImpedance.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TransformerMeshImpedance.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (TransformerMeshImpedance.fields (position), x))
        emitelem (0, r)
        emitelem (1, r0)
        emitelem (2, x)
        emitelem (3, x0)
        emitattr (4, FromTransformerEnd)
        emitattr (5, FromTransformerEndInfo)
        emitattrs (6, ToTransformerEnd)
        emitattrs (7, ToTransformerEndInfos)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TransformerMeshImpedance rdf:ID=\"%s\">\n%s\t</cim:TransformerMeshImpedance>".format (id, export_fields)
    }
}

object TransformerMeshImpedance
extends
    CIMParseable[TransformerMeshImpedance]
{
    override val fields: Array[String] = Array[String] (
        "r",
        "r0",
        "x",
        "x0",
        "FromTransformerEnd",
        "FromTransformerEndInfo",
        "ToTransformerEnd",
        "ToTransformerEndInfos"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("FromTransformerEnd", "TransformerEnd", "1", "0..*"),
        CIMRelationship ("FromTransformerEndInfo", "TransformerEndInfo", "0..1", "0..*"),
        CIMRelationship ("ToTransformerEnd", "TransformerEnd", "1..*", "0..*"),
        CIMRelationship ("ToTransformerEndInfos", "TransformerEndInfo", "0..*", "0..*")
    )
    val r: Fielder = parse_element (element (cls, fields(0)))
    val r0: Fielder = parse_element (element (cls, fields(1)))
    val x: Fielder = parse_element (element (cls, fields(2)))
    val x0: Fielder = parse_element (element (cls, fields(3)))
    val FromTransformerEnd: Fielder = parse_attribute (attribute (cls, fields(4)))
    val FromTransformerEndInfo: Fielder = parse_attribute (attribute (cls, fields(5)))
    val ToTransformerEnd: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val ToTransformerEndInfos: FielderMultiple = parse_attributes (attribute (cls, fields(7)))

    def parse (context: CIMContext): TransformerMeshImpedance =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TransformerMeshImpedance (
            IdentifiedObject.parse (context),
            toDouble (mask (r (), 0)),
            toDouble (mask (r0 (), 1)),
            toDouble (mask (x (), 2)),
            toDouble (mask (x0 (), 3)),
            mask (FromTransformerEnd (), 4),
            mask (FromTransformerEndInfo (), 5),
            masks (ToTransformerEnd (), 6),
            masks (ToTransformerEndInfos (), 7)
        )
        ret.bitfields = bitfields
        ret
    }
}

object TransformerMeshImpedanceSerializer extends CIMSerializer[TransformerMeshImpedance]
{
    def write (kryo: Kryo, output: Output, obj: TransformerMeshImpedance): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.r),
            () => output.writeDouble (obj.r0),
            () => output.writeDouble (obj.x),
            () => output.writeDouble (obj.x0),
            () => output.writeString (obj.FromTransformerEnd),
            () => output.writeString (obj.FromTransformerEndInfo),
            () => writeList (obj.ToTransformerEnd, output),
            () => writeList (obj.ToTransformerEndInfos, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TransformerMeshImpedance]): TransformerMeshImpedance =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = TransformerMeshImpedance (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) readList (input) else null,
            if (isSet (7)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Transformer star impedance (Pi-model) that accurately reflects impedance for transformers with 2 or 3 windings.
 *
 * For transformers with 4 or more windings, TransformerMeshImpedance class shall be used.
 * For transmission networks use PowerTransformerEnd impedances (r, r0, x, x0, b, b0, g and g0).
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param r Resistance of the transformer end.
 * @param r0 Zero sequence series resistance of the transformer end.
 * @param x Positive sequence series reactance of the transformer end.
 * @param x0 Zero sequence series reactance of the transformer end.
 * @param TransformerEnd [[ch.ninecode.model.TransformerEnd TransformerEnd]] All transformer ends having this star impedance.
 * @param TransformerEndInfo [[ch.ninecode.model.TransformerEndInfo TransformerEndInfo]] Transformer end datasheet used to calculate this transformer star impedance.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class TransformerStarImpedance
(
    IdentifiedObject: IdentifiedObject = null,
    r: Double = 0.0,
    r0: Double = 0.0,
    x: Double = 0.0,
    x0: Double = 0.0,
    TransformerEnd: List[String] = null,
    TransformerEndInfo: String = null
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
        implicit val clz: String = TransformerStarImpedance.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TransformerStarImpedance.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TransformerStarImpedance.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (TransformerStarImpedance.fields (position), x))
        emitelem (0, r)
        emitelem (1, r0)
        emitelem (2, x)
        emitelem (3, x0)
        emitattrs (4, TransformerEnd)
        emitattr (5, TransformerEndInfo)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TransformerStarImpedance rdf:ID=\"%s\">\n%s\t</cim:TransformerStarImpedance>".format (id, export_fields)
    }
}

object TransformerStarImpedance
extends
    CIMParseable[TransformerStarImpedance]
{
    override val fields: Array[String] = Array[String] (
        "r",
        "r0",
        "x",
        "x0",
        "TransformerEnd",
        "TransformerEndInfo"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("TransformerEnd", "TransformerEnd", "0..*", "0..1"),
        CIMRelationship ("TransformerEndInfo", "TransformerEndInfo", "0..1", "0..1")
    )
    val r: Fielder = parse_element (element (cls, fields(0)))
    val r0: Fielder = parse_element (element (cls, fields(1)))
    val x: Fielder = parse_element (element (cls, fields(2)))
    val x0: Fielder = parse_element (element (cls, fields(3)))
    val TransformerEnd: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val TransformerEndInfo: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: CIMContext): TransformerStarImpedance =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TransformerStarImpedance (
            IdentifiedObject.parse (context),
            toDouble (mask (r (), 0)),
            toDouble (mask (r0 (), 1)),
            toDouble (mask (x (), 2)),
            toDouble (mask (x0 (), 3)),
            masks (TransformerEnd (), 4),
            mask (TransformerEndInfo (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

object TransformerStarImpedanceSerializer extends CIMSerializer[TransformerStarImpedance]
{
    def write (kryo: Kryo, output: Output, obj: TransformerStarImpedance): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.r),
            () => output.writeDouble (obj.r0),
            () => output.writeDouble (obj.x),
            () => output.writeDouble (obj.x0),
            () => writeList (obj.TransformerEnd, output),
            () => output.writeString (obj.TransformerEndInfo)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TransformerStarImpedance]): TransformerStarImpedance =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = TransformerStarImpedance (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) readList (input) else null,
            if (isSet (5)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * An assembly of two or more coupled windings that transform electrical power between voltage levels.
 *
 * These windings are bound on a common core and placed in the same tank. Transformer tank can be used to model both single-phase and 3-phase transformers.
 *
 * @param Equipment [[ch.ninecode.model.Equipment Equipment]] Reference to the superclass object.
 * @param PowerTransformer [[ch.ninecode.model.PowerTransformer PowerTransformer]] Bank this transformer belongs to.
 * @param TransformerObservations [[ch.ninecode.model.TransformerObservation TransformerObservation]] <em>undocumented</em>
 * @param TransformerTankEnds [[ch.ninecode.model.TransformerTankEnd TransformerTankEnd]] All windings of this transformer.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class TransformerTank
(
    Equipment: Equipment = null,
    PowerTransformer: String = null,
    TransformerObservations: List[String] = null,
    TransformerTankEnds: List[String] = null
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
    override def sup: Equipment = Equipment

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
        implicit val clz: String = TransformerTank.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TransformerTank.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (TransformerTank.fields (position), x))
        emitattr (0, PowerTransformer)
        emitattrs (1, TransformerObservations)
        emitattrs (2, TransformerTankEnds)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TransformerTank rdf:ID=\"%s\">\n%s\t</cim:TransformerTank>".format (id, export_fields)
    }
}

object TransformerTank
extends
    CIMParseable[TransformerTank]
{
    override val fields: Array[String] = Array[String] (
        "PowerTransformer",
        "TransformerObservations",
        "TransformerTankEnds"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("PowerTransformer", "PowerTransformer", "0..1", "0..*"),
        CIMRelationship ("TransformerObservations", "TransformerObservation", "0..*", "0..1"),
        CIMRelationship ("TransformerTankEnds", "TransformerTankEnd", "1..*", "0..1")
    )
    val PowerTransformer: Fielder = parse_attribute (attribute (cls, fields(0)))
    val TransformerObservations: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val TransformerTankEnds: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: CIMContext): TransformerTank =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TransformerTank (
            Equipment.parse (context),
            mask (PowerTransformer (), 0),
            masks (TransformerObservations (), 1),
            masks (TransformerTankEnds (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

object TransformerTankSerializer extends CIMSerializer[TransformerTank]
{
    def write (kryo: Kryo, output: Output, obj: TransformerTank): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.PowerTransformer),
            () => writeList (obj.TransformerObservations, output),
            () => writeList (obj.TransformerTankEnds, output)
        )
        EquipmentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TransformerTank]): TransformerTank =
    {
        val parent = EquipmentSerializer.read (kryo, input, classOf[Equipment])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = TransformerTank (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Transformer tank end represents an individual winding for unbalanced models or for transformer tanks connected into a bank (and bank is modelled with the PowerTransformer).
 *
 * @param TransformerEnd [[ch.ninecode.model.TransformerEnd TransformerEnd]] Reference to the superclass object.
 * @param phases Describes the phases carried by a conducting equipment.
 * @param TransformerTank [[ch.ninecode.model.TransformerTank TransformerTank]] Transformer this winding belongs to.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class TransformerTankEnd
(
    TransformerEnd: TransformerEnd = null,
    phases: String = null,
    TransformerTank: String = null
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
    override def sup: TransformerEnd = TransformerEnd

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
        implicit val clz: String = TransformerTankEnd.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TransformerTankEnd.fields (position), value)
        emitattr (0, phases)
        emitattr (1, TransformerTank)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TransformerTankEnd rdf:ID=\"%s\">\n%s\t</cim:TransformerTankEnd>".format (id, export_fields)
    }
}

object TransformerTankEnd
extends
    CIMParseable[TransformerTankEnd]
{
    override val fields: Array[String] = Array[String] (
        "phases",
        "TransformerTank"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("TransformerTank", "TransformerTank", "0..1", "1..*")
    )
    val phases: Fielder = parse_attribute (attribute (cls, fields(0)))
    val TransformerTank: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): TransformerTankEnd =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TransformerTankEnd (
            TransformerEnd.parse (context),
            mask (phases (), 0),
            mask (TransformerTank (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

object TransformerTankEndSerializer extends CIMSerializer[TransformerTankEnd]
{
    def write (kryo: Kryo, output: Output, obj: TransformerTankEnd): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.phases),
            () => output.writeString (obj.TransformerTank)
        )
        TransformerEndSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TransformerTankEnd]): TransformerTankEnd =
    {
        val parent = TransformerEndSerializer.read (kryo, input, classOf[TransformerEnd])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = TransformerTankEnd (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * An area of the power system network which is defined for secondary voltage control purposes.
 *
 * A voltage control zone consists of a collection of substations with a designated bus bar section whose voltage will be controlled.
 *
 * @param PowerSystemResource [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param BusbarSection [[ch.ninecode.model.BusbarSection BusbarSection]] A VoltageControlZone is controlled by a designated BusbarSection.
 * @param RegulationSchedule [[ch.ninecode.model.RegulationSchedule RegulationSchedule]] A VoltageControlZone may have a  voltage regulation schedule.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
final case class VoltageControlZone
(
    PowerSystemResource: PowerSystemResource = null,
    BusbarSection: String = null,
    RegulationSchedule: String = null
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
        implicit val clz: String = VoltageControlZone.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (VoltageControlZone.fields (position), value)
        emitattr (0, BusbarSection)
        emitattr (1, RegulationSchedule)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:VoltageControlZone rdf:ID=\"%s\">\n%s\t</cim:VoltageControlZone>".format (id, export_fields)
    }
}

object VoltageControlZone
extends
    CIMParseable[VoltageControlZone]
{
    override val fields: Array[String] = Array[String] (
        "BusbarSection",
        "RegulationSchedule"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("BusbarSection", "BusbarSection", "1", "0..1"),
        CIMRelationship ("RegulationSchedule", "RegulationSchedule", "0..1", "0..*")
    )
    val BusbarSection: Fielder = parse_attribute (attribute (cls, fields(0)))
    val RegulationSchedule: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): VoltageControlZone =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = VoltageControlZone (
            PowerSystemResource.parse (context),
            mask (BusbarSection (), 0),
            mask (RegulationSchedule (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

object VoltageControlZoneSerializer extends CIMSerializer[VoltageControlZone]
{
    def write (kryo: Kryo, output: Output, obj: VoltageControlZone): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.BusbarSection),
            () => output.writeString (obj.RegulationSchedule)
        )
        PowerSystemResourceSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[VoltageControlZone]): VoltageControlZone =
    {
        val parent = PowerSystemResourceSerializer.read (kryo, input, classOf[PowerSystemResource])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = VoltageControlZone (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _Wires
{
    def register: List[CIMClassInfo] =
    {
        List (
            ACLineSegment.register,
            ACLineSegmentPhase.register,
            AsynchronousMachine.register,
            Breaker.register,
            BusbarSection.register,
            Clamp.register,
            CompositeSwitch.register,
            Conductor.register,
            Connector.register,
            Cut.register,
            Disconnector.register,
            EarthFaultCompensator.register,
            EnergyConnection.register,
            EnergyConsumer.register,
            EnergyConsumerPhase.register,
            EnergySchedulingType.register,
            EnergySource.register,
            EnergySourcePhase.register,
            ExternalNetworkInjection.register,
            FrequencyConverter.register,
            Fuse.register,
            Ground.register,
            GroundDisconnector.register,
            GroundingImpedance.register,
            Jumper.register,
            Junction.register,
            Line.register,
            LinearShuntCompensator.register,
            LinearShuntCompensatorPhase.register,
            LoadBreakSwitch.register,
            MutualCoupling.register,
            NonlinearShuntCompensator.register,
            NonlinearShuntCompensatorPhase.register,
            NonlinearShuntCompensatorPhasePoint.register,
            NonlinearShuntCompensatorPoint.register,
            PerLengthImpedance.register,
            PerLengthLineParameter.register,
            PerLengthPhaseImpedance.register,
            PerLengthSequenceImpedance.register,
            PetersenCoil.register,
            PhaseImpedanceData.register,
            PhaseTapChanger.register,
            PhaseTapChangerAsymmetrical.register,
            PhaseTapChangerLinear.register,
            PhaseTapChangerNonLinear.register,
            PhaseTapChangerSymmetrical.register,
            PhaseTapChangerTable.register,
            PhaseTapChangerTablePoint.register,
            PhaseTapChangerTabular.register,
            Plant.register,
            PowerElectronicsConnection.register,
            PowerElectronicsConnectionPhase.register,
            PowerTransformer.register,
            PowerTransformerEnd.register,
            ProtectedSwitch.register,
            RatioTapChanger.register,
            RatioTapChangerTable.register,
            RatioTapChangerTablePoint.register,
            ReactiveCapabilityCurve.register,
            Recloser.register,
            RegulatingCondEq.register,
            RegulatingControl.register,
            RegulationSchedule.register,
            RotatingMachine.register,
            Sectionaliser.register,
            SeriesCompensator.register,
            ShuntCompensator.register,
            ShuntCompensatorPhase.register,
            StaticVarCompensator.register,
            Switch.register,
            SwitchPhase.register,
            SwitchSchedule.register,
            SynchronousMachine.register,
            TapChanger.register,
            TapChangerControl.register,
            TapChangerTablePoint.register,
            TapSchedule.register,
            TransformerCoreAdmittance.register,
            TransformerEnd.register,
            TransformerMeshImpedance.register,
            TransformerStarImpedance.register,
            TransformerTank.register,
            TransformerTankEnd.register,
            VoltageControlZone.register
        )
    }
}