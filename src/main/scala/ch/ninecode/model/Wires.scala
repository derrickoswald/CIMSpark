package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * A wire or combination of wires, with consistent electrical characteristics, building a single electrical system, used to carry alternating current between points in the power system.
 *
 * For symmetrical, transposed 3ph lines, it is sufficient to use  attributes of the line segment, which describe impedances and admittances for the entire length of the segment.  Additionally impedances can be computed by using length and associated per length impedances.
 *
 * @param sup [[ch.ninecode.model.Conductor Conductor]] Reference to the superclass object.
 * @param b0ch Zero sequence shunt (charging) susceptance, uniformly distributed, of the entire line section.
 * @param bch Positive sequence shunt (charging) susceptance, uniformly distributed, of the entire line section.
 *        This value represents the full charging over the full length of the line.
 * @param g0ch Zero sequence shunt (charging) conductance, uniformly distributed, of the entire line section.
 * @param gch Positive sequence shunt (charging) conductance, uniformly distributed, of the entire line section.
 * @param r Positive sequence series resistance of the entire line section.
 * @param r0 Zero sequence series resistance of the entire line section.
 * @param shortCircuitEndTemperature Maximum permitted temperature at the end of SC for the calculation of minimum short-circuit currents.
 *        Used for short circuit data exchange according to IEC 60909
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
case class ACLineSegment
(
    override val sup: Conductor,
    b0ch: Double,
    bch: Double,
    g0ch: Double,
    gch: Double,
    r: Double,
    r0: Double,
    shortCircuitEndTemperature: Double,
    x: Double,
    x0: Double,
    ACLineSegmentPhases: List[String],
    Clamp: List[String],
    Cut: List[String],
    LineFaults: List[String],
    LineGroundingAction: String,
    LineJumpingAction: String,
    PerLengthImpedance: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, List(), List(), List(), List(), null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Conductor: Conductor = sup.asInstanceOf[Conductor]
    override def copy (): Row = { clone ().asInstanceOf[ACLineSegment] }
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
        implicit val clz: String = ACLineSegment.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ACLineSegment.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ACLineSegment.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (ACLineSegment.fields (position), x))
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
    Parseable[ACLineSegment]
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
    override val relations: List[Relationship] = List (
        Relationship ("ACLineSegmentPhases", "ACLineSegmentPhase", "0..*", "1"),
        Relationship ("Clamp", "Clamp", "0..*", "1"),
        Relationship ("Cut", "Cut", "0..*", "1"),
        Relationship ("LineFaults", "LineFault", "0..*", "0..1"),
        Relationship ("LineGroundingAction", "GroundAction", "0..1", "0..1"),
        Relationship ("LineJumpingAction", "JumperAction", "0..1", "0..*"),
        Relationship ("PerLengthImpedance", "PerLengthImpedance", "0..1", "0..*")
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

    def parse (context: Context): ACLineSegment =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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

/**
 * Represents a single wire of an alternating current line segment.
 *
 * @param sup [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param phase The phase connection of the wire at both ends.
 * @param ACLineSegment [[ch.ninecode.model.ACLineSegment ACLineSegment]] The line segment to which the phase belongs.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class ACLineSegmentPhase
(
    override val sup: PowerSystemResource,
    phase: String,
    ACLineSegment: String
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
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { clone ().asInstanceOf[ACLineSegmentPhase] }
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
        implicit val clz: String = ACLineSegmentPhase.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ACLineSegmentPhase.fields (position), value)
        emitattr (0, phase)
        emitattr (1, ACLineSegment)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ACLineSegmentPhase rdf:ID=\"%s\">\n%s\t</cim:ACLineSegmentPhase>".format (id, export_fields)
    }
}

object ACLineSegmentPhase
extends
    Parseable[ACLineSegmentPhase]
{
    override val fields: Array[String] = Array[String] (
        "phase",
        "ACLineSegment"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ACLineSegment", "ACLineSegment", "1", "0..*")
    )
    val phase: Fielder = parse_attribute (attribute (cls, fields(0)))
    val ACLineSegment: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): ACLineSegmentPhase =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ACLineSegmentPhase (
            PowerSystemResource.parse (context),
            mask (phase (), 0),
            mask (ACLineSegment (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A rotating machine whose shaft rotates asynchronously with the electrical field.
 *
 * Also known as an induction machine with no external connection to the rotor windings, e.g squirrel-cage induction machine.
 *
 * @param sup [[ch.ninecode.model.RotatingMachine RotatingMachine]] Reference to the superclass object.
 * @param asynchronousMachineType Indicates the type of Asynchronous Machine (motor or generator).
 * @param converterFedDrive Indicates whether the machine is a converter fed drive.
 *        Used for short circuit data exchange according to IEC 60909
 * @param efficiency Efficiency of the asynchronous machine at nominal operation in percent.
 *        Indicator for converter drive motors. Used for short circuit data exchange according to IEC 60909
 * @param iaIrRatio Ratio of locked-rotor current to the rated current of the motor (Ia/Ir).
 *        Used for short circuit data exchange according to IEC 60909
 * @param nominalFrequency Nameplate data indicates if the machine is 50 or 60 Hz.
 * @param nominalSpeed Nameplate data.
 *        Depends on the slip and number of pole pairs.
 * @param polePairNumber Number of pole pairs of stator.
 *        Used for short circuit data exchange according to IEC 60909
 * @param ratedMechanicalPower Rated mechanical power (Pr in the IEC 60909-0).
 *        Used for short circuit data exchange according to IEC 60909.
 * @param reversible Indicates for converter drive motors if the power can be reversible.
 *        Used for short circuit data exchange according to IEC 60909
 * @param rr1 Damper 1 winding resistance.
 * @param rr2 Damper 2 winding resistance.
 * @param rxLockedRotorRatio Locked rotor ratio (R/X).
 *        Used for short circuit data exchange according to IEC 60909
 * @param tpo Transient rotor time constant (greater than tppo).
 * @param tppo Sub-transient rotor time constant (greater than 0).
 * @param xlr1 Damper 1 winding leakage reactance.
 * @param xlr2 Damper 2 winding leakage reactance.
 * @param xm Magnetizing reactance.
 * @param xp Transient reactance (unsaturated) (greater than or equal to xpp).
 * @param xpp Sub-transient reactance (unsaturated) (greather than Xl).
 * @param xs Synchronous reactance (greather than xp).
 * @param AsynchronousMachineDynamics [[ch.ninecode.model.AsynchronousMachineDynamics AsynchronousMachineDynamics]] Asynchronous machine dynamics model used to describe dynamic behavior of this asynchronous machine.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class AsynchronousMachine
(
    override val sup: RotatingMachine,
    asynchronousMachineType: String,
    converterFedDrive: Boolean,
    efficiency: Double,
    iaIrRatio: Double,
    nominalFrequency: Double,
    nominalSpeed: Double,
    polePairNumber: Int,
    ratedMechanicalPower: Double,
    reversible: Boolean,
    rr1: Double,
    rr2: Double,
    rxLockedRotorRatio: Double,
    tpo: Double,
    tppo: Double,
    xlr1: Double,
    xlr2: Double,
    xm: Double,
    xp: Double,
    xpp: Double,
    xs: Double,
    AsynchronousMachineDynamics: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, false, 0.0, 0.0, 0.0, 0.0, 0, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def RotatingMachine: RotatingMachine = sup.asInstanceOf[RotatingMachine]
    override def copy (): Row = { clone ().asInstanceOf[AsynchronousMachine] }
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
    Parseable[AsynchronousMachine]
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
    override val relations: List[Relationship] = List (
        Relationship ("AsynchronousMachineDynamics", "AsynchronousMachineDynamics", "0..1", "1")
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

    def parse (context: Context): AsynchronousMachine =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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

/**
 * A mechanical switching device capable of making, carrying, and breaking currents under normal circuit conditions and also making, carrying for a specified time, and breaking currents under specified abnormal circuit conditions e.g.  those of short circuit.
 *
 * @param sup [[ch.ninecode.model.ProtectedSwitch ProtectedSwitch]] Reference to the superclass object.
 * @param inTransitTime The transition time from open to close.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class Breaker
(
    override val sup: ProtectedSwitch,
    inTransitTime: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ProtectedSwitch: ProtectedSwitch = sup.asInstanceOf[ProtectedSwitch]
    override def copy (): Row = { clone ().asInstanceOf[Breaker] }
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
    Parseable[Breaker]
{
    override val fields: Array[String] = Array[String] (
        "inTransitTime"
    )
    val inTransitTime: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): Breaker =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Breaker (
            ProtectedSwitch.parse (context),
            toDouble (mask (inTransitTime (), 0))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A conductor, or group of conductors, with negligible impedance, that serve to connect other conducting equipment within a single substation.
 *
 * Voltage measurements are typically obtained from VoltageTransformers that are connected to busbar sections. A bus bar section may have many physical terminals but for analysis is modelled with exactly one logical terminal.
 *
 * @param sup [[ch.ninecode.model.Connector Connector]] Reference to the superclass object.
 * @param ipMax Maximum allowable peak short-circuit current of busbar (Ipmax in the IEC 60909-0).
 *        Mechanical limit of the busbar in the substation itself. Used for short circuit data exchange according to IEC 60909
 * @param VoltageControlZone [[ch.ninecode.model.VoltageControlZone VoltageControlZone]] A VoltageControlZone is controlled by a designated BusbarSection.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class BusbarSection
(
    override val sup: Connector,
    ipMax: Double,
    VoltageControlZone: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Connector: Connector = sup.asInstanceOf[Connector]
    override def copy (): Row = { clone ().asInstanceOf[BusbarSection] }
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
    Parseable[BusbarSection]
{
    override val fields: Array[String] = Array[String] (
        "ipMax",
        "VoltageControlZone"
    )
    override val relations: List[Relationship] = List (
        Relationship ("VoltageControlZone", "VoltageControlZone", "0..1", "1")
    )
    val ipMax: Fielder = parse_element (element (cls, fields(0)))
    val VoltageControlZone: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): BusbarSection =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = BusbarSection (
            Connector.parse (context),
            toDouble (mask (ipMax (), 0)),
            mask (VoltageControlZone (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A Clamp is a galvanic connection at a line segment where other equipment is connected.
 *
 * A Clamp does not cut the line segment.
 *
 * @param sup [[ch.ninecode.model.ConductingEquipment ConductingEquipment]] Reference to the superclass object.
 * @param lengthFromTerminal1 The length to the place where the clamp is located starting from side one of the line segment, i.e. the line segment terminal with sequence number equal to 1.
 * @param ACLineSegment [[ch.ninecode.model.ACLineSegment ACLineSegment]] The line segment to which the clamp is connected.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class Clamp
(
    override val sup: ConductingEquipment,
    lengthFromTerminal1: Double,
    ACLineSegment: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ConductingEquipment: ConductingEquipment = sup.asInstanceOf[ConductingEquipment]
    override def copy (): Row = { clone ().asInstanceOf[Clamp] }
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
    Parseable[Clamp]
{
    override val fields: Array[String] = Array[String] (
        "lengthFromTerminal1",
        "ACLineSegment"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ACLineSegment", "ACLineSegment", "1", "0..*")
    )
    val lengthFromTerminal1: Fielder = parse_element (element (cls, fields(0)))
    val ACLineSegment: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): Clamp =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Clamp (
            ConductingEquipment.parse (context),
            toDouble (mask (lengthFromTerminal1 (), 0)),
            mask (ACLineSegment (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A model of a set of individual Switches normally enclosed within the same cabinet and possibly with interlocks that restrict the combination of switch positions.
 *
 * These are typically found in medium voltage distribution networks.
 *
 * @param sup [[ch.ninecode.model.Equipment Equipment]] Reference to the superclass object.
 * @param compositeSwitchType An alphanumeric code that can be used as a reference to extra information such as the description of the interlocking scheme if any.
 * @param Switches [[ch.ninecode.model.Switch Switch]] Switches contained in this Composite switch.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class CompositeSwitch
(
    override val sup: Equipment,
    compositeSwitchType: String,
    Switches: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Equipment: Equipment = sup.asInstanceOf[Equipment]
    override def copy (): Row = { clone ().asInstanceOf[CompositeSwitch] }
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
        implicit val clz: String = CompositeSwitch.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CompositeSwitch.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (CompositeSwitch.fields (position), x))
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
    Parseable[CompositeSwitch]
{
    override val fields: Array[String] = Array[String] (
        "compositeSwitchType",
        "Switches"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Switches", "Switch", "0..*", "0..1")
    )
    val compositeSwitchType: Fielder = parse_element (element (cls, fields(0)))
    val Switches: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): CompositeSwitch =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = CompositeSwitch (
            Equipment.parse (context),
            mask (compositeSwitchType (), 0),
            masks (Switches (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Combination of conducting material with consistent electrical characteristics, building a single electrical system, used to carry current between points in the power system.
 *
 * @param sup [[ch.ninecode.model.ConductingEquipment ConductingEquipment]] Reference to the superclass object.
 * @param len Segment length for calculating line section capabilities
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class Conductor
(
    override val sup: ConductingEquipment,
    len: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ConductingEquipment: ConductingEquipment = sup.asInstanceOf[ConductingEquipment]
    override def copy (): Row = { clone ().asInstanceOf[Conductor] }
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
    Parseable[Conductor]
{
    override val fields: Array[String] = Array[String] (
        "length"
    )
    val len: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): Conductor =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Conductor (
            ConductingEquipment.parse (context),
            toDouble (mask (len (), 0))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A conductor, or group of conductors, with negligible impedance, that serve to connect other conducting equipment within a single substation and are modelled with a single logical terminal.
 *
 * @param sup [[ch.ninecode.model.ConductingEquipment ConductingEquipment]] Reference to the superclass object.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class Connector
(
    override val sup: ConductingEquipment
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
    def ConductingEquipment: ConductingEquipment = sup.asInstanceOf[ConductingEquipment]
    override def copy (): Row = { clone ().asInstanceOf[Connector] }
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
        "\t<cim:Connector rdf:ID=\"%s\">\n%s\t</cim:Connector>".format (id, export_fields)
    }
}

object Connector
extends
    Parseable[Connector]
{

    def parse (context: Context): Connector =
    {
        implicit val ctx: Context = context
        val ret = Connector (
            ConductingEquipment.parse (context)
        )
        ret
    }
}

/**
 * A cut separates a line segment into two parts.
 *
 * The cut appears as a switch inserted between these two parts and connects them together. As the cut is normally open there is no galvanic connection between the two line segment parts. But it is possible to close the cut to get galvanic connection.
 *
 * @param sup [[ch.ninecode.model.Switch Switch]] Reference to the superclass object.
 * @param lengthFromTerminal1 The length to the place where the cut is located starting from side one of the cut line segment, i.e. the line segment Terminal with sequenceNumber equal to 1.
 * @param ACLineSegment [[ch.ninecode.model.ACLineSegment ACLineSegment]] The line segment to which the cut is applied.
 * @param CutAction [[ch.ninecode.model.CutAction CutAction]] Action taken with this cut.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class Cut
(
    override val sup: Switch,
    lengthFromTerminal1: Double,
    ACLineSegment: String,
    CutAction: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Switch: Switch = sup.asInstanceOf[Switch]
    override def copy (): Row = { clone ().asInstanceOf[Cut] }
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
    Parseable[Cut]
{
    override val fields: Array[String] = Array[String] (
        "lengthFromTerminal1",
        "ACLineSegment",
        "CutAction"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ACLineSegment", "ACLineSegment", "1", "0..*"),
        Relationship ("CutAction", "CutAction", "0..1", "0..1")
    )
    val lengthFromTerminal1: Fielder = parse_element (element (cls, fields(0)))
    val ACLineSegment: Fielder = parse_attribute (attribute (cls, fields(1)))
    val CutAction: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): Cut =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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

/**
 * A manually operated or motor operated mechanical switching device used for changing the connections in a circuit, or for isolating a circuit or equipment from a source of power.
 *
 * It is required to open or close circuits when negligible current is broken or made.
 *
 * @param sup [[ch.ninecode.model.Switch Switch]] Reference to the superclass object.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class Disconnector
(
    override val sup: Switch
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
    def Switch: Switch = sup.asInstanceOf[Switch]
    override def copy (): Row = { clone ().asInstanceOf[Disconnector] }
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
        "\t<cim:Disconnector rdf:ID=\"%s\">\n%s\t</cim:Disconnector>".format (id, export_fields)
    }
}

object Disconnector
extends
    Parseable[Disconnector]
{

    def parse (context: Context): Disconnector =
    {
        implicit val ctx: Context = context
        val ret = Disconnector (
            Switch.parse (context)
        )
        ret
    }
}

/**
 * A conducting equipment used to represent a connection to ground which is typically used to compensate earth faults..
 *
 * An earth fault compensator device modeled with a single terminal implies a second terminal solidly connected to ground.  If two terminals are modeled, the ground is not assumed and normal connection rules apply.
 *
 * @param sup [[ch.ninecode.model.ConductingEquipment ConductingEquipment]] Reference to the superclass object.
 * @param r Nominal resistance of device.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class EarthFaultCompensator
(
    override val sup: ConductingEquipment,
    r: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ConductingEquipment: ConductingEquipment = sup.asInstanceOf[ConductingEquipment]
    override def copy (): Row = { clone ().asInstanceOf[EarthFaultCompensator] }
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
    Parseable[EarthFaultCompensator]
{
    override val fields: Array[String] = Array[String] (
        "r"
    )
    val r: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): EarthFaultCompensator =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = EarthFaultCompensator (
            ConductingEquipment.parse (context),
            toDouble (mask (r (), 0))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Generic user of energy - a  point of consumption on the power system model.
 *
 * @param sup [[ch.ninecode.model.ConductingEquipment ConductingEquipment]] Reference to the superclass object.
 * @param customerCount Number of individual customers represented by this demand.
 * @param grounded Used for Yn and Zn connections.
 *        True if the neutral is solidly grounded.
 * @param p Active power of the load.
 *        Load sign convention is used, i.e. positive sign means flow out from a node.
 * @param pfixed Active power of the load that is a fixed quantity.
 *        Load sign convention is used, i.e. positive sign means flow out from a node.
 * @param pfixedPct Fixed active power as per cent of load group fixed active power.
 *        Load sign convention is used, i.e. positive sign means flow out from a node.
 * @param phaseConnection The type of phase connection, such as wye or delta.
 * @param q Reactive power of the load.
 *        Load sign convention is used, i.e. positive sign means flow out from a node.
 * @param qfixed Reactive power of the load that is a fixed quantity.
 *        Load sign convention is used, i.e. positive sign means flow out from a node.
 * @param qfixedPct Fixed reactive power as per cent of load group fixed reactive power.
 *        Load sign convention is used, i.e. positive sign means flow out from a node.
 * @param EnergyConsumerPhase [[ch.ninecode.model.EnergyConsumerPhase EnergyConsumerPhase]] The individual phase models for this energy consumer.
 * @param LoadDynamics [[ch.ninecode.model.LoadDynamics LoadDynamics]] Load dynamics model used to describe dynamic behavior of this energy consumer.
 * @param LoadResponse [[ch.ninecode.model.LoadResponseCharacteristic LoadResponseCharacteristic]] The load response characteristic of this load.
 *        If missing, this load is assumed to be constant power.
 * @param PowerCutZone [[ch.ninecode.model.PowerCutZone PowerCutZone]] The  energy consumer is assigned to this power cut zone.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class EnergyConsumer
(
    override val sup: ConductingEquipment,
    customerCount: Int,
    grounded: Boolean,
    p: Double,
    pfixed: Double,
    pfixedPct: Double,
    phaseConnection: String,
    q: Double,
    qfixed: Double,
    qfixedPct: Double,
    EnergyConsumerPhase: List[String],
    LoadDynamics: String,
    LoadResponse: String,
    PowerCutZone: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0, false, 0.0, 0.0, 0.0, null, 0.0, 0.0, 0.0, List(), null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ConductingEquipment: ConductingEquipment = sup.asInstanceOf[ConductingEquipment]
    override def copy (): Row = { clone ().asInstanceOf[EnergyConsumer] }
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
        implicit val clz: String = EnergyConsumer.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (EnergyConsumer.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EnergyConsumer.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (EnergyConsumer.fields (position), x))
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
    Parseable[EnergyConsumer]
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
    override val relations: List[Relationship] = List (
        Relationship ("EnergyConsumerPhase", "EnergyConsumerPhase", "0..*", "1"),
        Relationship ("LoadDynamics", "LoadDynamics", "0..1", "0..*"),
        Relationship ("LoadResponse", "LoadResponseCharacteristic", "0..1", "0..*"),
        Relationship ("PowerCutZone", "PowerCutZone", "0..1", "1..*")
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

    def parse (context: Context): EnergyConsumer =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = EnergyConsumer (
            ConductingEquipment.parse (context),
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

/**
 * A single phase of an energy consumer.
 *
 * @param sup [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param pfixed Active power of the load that is a fixed quantity.
 *        Load sign convention is used, i.e. positive sign means flow out from a node.
 * @param pfixedPct Fixed active power as per cent of load group fixed active power.
 *        Load sign convention is used, i.e. positive sign means flow out from a node.
 * @param phase Phase of this energy consumer component.
 *        If the energy consumer is wye connected, the connection is from the indicated phase to the central ground or neutral point.  If the energy consumer is delta connected, the phase indicates an energy consumer connected from the indicated phase to the next logical non-neutral phase.
 * @param qfixed Reactive power of the load that is a fixed quantity.
 *        Load sign convention is used, i.e. positive sign means flow out from a node.
 * @param qfixedPct Fixed reactive power as per cent of load group fixed reactive power.
 *        Load sign convention is used, i.e. positive sign means flow out from a node.
 * @param EnergyConsumer [[ch.ninecode.model.EnergyConsumer EnergyConsumer]] The energy consumer to which this phase belongs.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class EnergyConsumerPhase
(
    override val sup: PowerSystemResource,
    pfixed: Double,
    pfixedPct: Double,
    phase: String,
    qfixed: Double,
    qfixedPct: Double,
    EnergyConsumer: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, null, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { clone ().asInstanceOf[EnergyConsumerPhase] }
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
        implicit val clz: String = EnergyConsumerPhase.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (EnergyConsumerPhase.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EnergyConsumerPhase.fields (position), value)
        emitelem (0, pfixed)
        emitelem (1, pfixedPct)
        emitattr (2, phase)
        emitelem (3, qfixed)
        emitelem (4, qfixedPct)
        emitattr (5, EnergyConsumer)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EnergyConsumerPhase rdf:ID=\"%s\">\n%s\t</cim:EnergyConsumerPhase>".format (id, export_fields)
    }
}

object EnergyConsumerPhase
extends
    Parseable[EnergyConsumerPhase]
{
    override val fields: Array[String] = Array[String] (
        "pfixed",
        "pfixedPct",
        "phase",
        "qfixed",
        "qfixedPct",
        "EnergyConsumer"
    )
    override val relations: List[Relationship] = List (
        Relationship ("EnergyConsumer", "EnergyConsumer", "1", "0..*")
    )
    val pfixed: Fielder = parse_element (element (cls, fields(0)))
    val pfixedPct: Fielder = parse_element (element (cls, fields(1)))
    val phase: Fielder = parse_attribute (attribute (cls, fields(2)))
    val qfixed: Fielder = parse_element (element (cls, fields(3)))
    val qfixedPct: Fielder = parse_element (element (cls, fields(4)))
    val EnergyConsumer: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: Context): EnergyConsumerPhase =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = EnergyConsumerPhase (
            PowerSystemResource.parse (context),
            toDouble (mask (pfixed (), 0)),
            toDouble (mask (pfixedPct (), 1)),
            mask (phase (), 2),
            toDouble (mask (qfixed (), 3)),
            toDouble (mask (qfixedPct (), 4)),
            mask (EnergyConsumer (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A generic equivalent for an energy supplier on a transmission or distribution voltage level.
 *
 * @param sup [[ch.ninecode.model.ConductingEquipment ConductingEquipment]] Reference to the superclass object.
 * @param activePower High voltage source active injection.
 *        Load sign convention is used, i.e. positive sign means flow out from a node.
 * @param nominalVoltage Phase-to-phase nominal voltage.
 * @param r Positive sequence Thevenin resistance.
 * @param r0 Zero sequence Thevenin resistance.
 * @param reactivePower High voltage source reactive injection.
 *        Load sign convention is used, i.e. positive sign means flow out from a node.
 * @param rn Negative sequence Thevenin resistance.
 * @param voltageAngle Phase angle of a-phase open circuit.
 * @param voltageMagnitude Phase-to-phase open circuit voltage magnitude.
 * @param x Positive sequence Thevenin reactance.
 * @param x0 Zero sequence Thevenin reactance.
 * @param xn Negative sequence Thevenin reactance.
 * @param EnergySchedulingType [[ch.ninecode.model.EnergySchedulingType EnergySchedulingType]] Energy Scheduling Type of an Energy Source
 * @param EnergySourceAction [[ch.ninecode.model.EnergySourceAction EnergySourceAction]] Action taken with this energy source.
 * @param WindTurbineType3or4Dynamics [[ch.ninecode.model.WindTurbineType3or4Dynamics WindTurbineType3or4Dynamics]] Wind generator Type 3 or 4 dynamics model associated with this energy source.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class EnergySource
(
    override val sup: ConductingEquipment,
    activePower: Double,
    nominalVoltage: Double,
    r: Double,
    r0: Double,
    reactivePower: Double,
    rn: Double,
    voltageAngle: Double,
    voltageMagnitude: Double,
    x: Double,
    x0: Double,
    xn: Double,
    EnergySchedulingType: String,
    EnergySourceAction: String,
    WindTurbineType3or4Dynamics: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ConductingEquipment: ConductingEquipment = sup.asInstanceOf[ConductingEquipment]
    override def copy (): Row = { clone ().asInstanceOf[EnergySource] }
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
        implicit val clz: String = EnergySource.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (EnergySource.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EnergySource.fields (position), value)
        emitelem (0, activePower)
        emitelem (1, nominalVoltage)
        emitelem (2, r)
        emitelem (3, r0)
        emitelem (4, reactivePower)
        emitelem (5, rn)
        emitelem (6, voltageAngle)
        emitelem (7, voltageMagnitude)
        emitelem (8, x)
        emitelem (9, x0)
        emitelem (10, xn)
        emitattr (11, EnergySchedulingType)
        emitattr (12, EnergySourceAction)
        emitattr (13, WindTurbineType3or4Dynamics)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EnergySource rdf:ID=\"%s\">\n%s\t</cim:EnergySource>".format (id, export_fields)
    }
}

object EnergySource
extends
    Parseable[EnergySource]
{
    override val fields: Array[String] = Array[String] (
        "activePower",
        "nominalVoltage",
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
        "WindTurbineType3or4Dynamics"
    )
    override val relations: List[Relationship] = List (
        Relationship ("EnergySchedulingType", "EnergySchedulingType", "0..1", "0..*"),
        Relationship ("EnergySourceAction", "EnergySourceAction", "0..1", "0..1"),
        Relationship ("WindTurbineType3or4Dynamics", "WindTurbineType3or4Dynamics", "0..1", "1")
    )
    val activePower: Fielder = parse_element (element (cls, fields(0)))
    val nominalVoltage: Fielder = parse_element (element (cls, fields(1)))
    val r: Fielder = parse_element (element (cls, fields(2)))
    val r0: Fielder = parse_element (element (cls, fields(3)))
    val reactivePower: Fielder = parse_element (element (cls, fields(4)))
    val rn: Fielder = parse_element (element (cls, fields(5)))
    val voltageAngle: Fielder = parse_element (element (cls, fields(6)))
    val voltageMagnitude: Fielder = parse_element (element (cls, fields(7)))
    val x: Fielder = parse_element (element (cls, fields(8)))
    val x0: Fielder = parse_element (element (cls, fields(9)))
    val xn: Fielder = parse_element (element (cls, fields(10)))
    val EnergySchedulingType: Fielder = parse_attribute (attribute (cls, fields(11)))
    val EnergySourceAction: Fielder = parse_attribute (attribute (cls, fields(12)))
    val WindTurbineType3or4Dynamics: Fielder = parse_attribute (attribute (cls, fields(13)))

    def parse (context: Context): EnergySource =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = EnergySource (
            ConductingEquipment.parse (context),
            toDouble (mask (activePower (), 0)),
            toDouble (mask (nominalVoltage (), 1)),
            toDouble (mask (r (), 2)),
            toDouble (mask (r0 (), 3)),
            toDouble (mask (reactivePower (), 4)),
            toDouble (mask (rn (), 5)),
            toDouble (mask (voltageAngle (), 6)),
            toDouble (mask (voltageMagnitude (), 7)),
            toDouble (mask (x (), 8)),
            toDouble (mask (x0 (), 9)),
            toDouble (mask (xn (), 10)),
            mask (EnergySchedulingType (), 11),
            mask (EnergySourceAction (), 12),
            mask (WindTurbineType3or4Dynamics (), 13)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * This class represents external network and it is used for IEC 60909 calculations.
 *
 * @param sup [[ch.ninecode.model.RegulatingCondEq RegulatingCondEq]] Reference to the superclass object.
 * @param governorSCD Power Frequency Bias.
 *        This is the change in power injection divided by the change in frequency and negated.  A positive value of the power frequency bias provides additional power injection upon a drop in frequency.
 * @param ikSecond Indicates whether initial symmetrical short-circuit current and power have been calculated according to IEC (Ik").
 * @param maxInitialSymShCCurrent Maximum initial symmetrical short-circuit currents (Ik" max) in A (Ik" = Sk"/(SQRT(3) Un)).
 *        Used for short circuit data exchange according to IEC 60909
 * @param maxP Maximum active power of the injection.
 * @param maxQ Not for short circuit modelling; It is used for modelling of infeed for load flow exchange.
 *        If maxQ and minQ are not used ReactiveCapabilityCurve can be used
 * @param maxR0ToX0Ratio Maximum ratio of zero sequence resistance of Network Feeder to its zero sequence reactance (R(0)/X(0) max).
 *        Used for short circuit data exchange according to IEC 60909
 * @param maxR1ToX1Ratio Maximum ratio of positive sequence resistance of Network Feeder to its positive sequence reactance (R(1)/X(1) max).
 *        Used for short circuit data exchange according to IEC 60909
 * @param maxZ0ToZ1Ratio Maximum ratio of zero sequence impedance to its positive sequence impedance (Z(0)/Z(1) max).
 *        Used for short circuit data exchange according to IEC 60909
 * @param minInitialSymShCCurrent Minimum initial symmetrical short-circuit currents (Ik" min) in A (Ik" = Sk"/(SQRT(3) Un)).
 *        Used for short circuit data exchange according to IEC 60909
 * @param minP Minimum active power of the injection.
 * @param minQ Not for short circuit modelling; It is used for modelling of infeed for load flow exchange.
 *        If maxQ and minQ are not used ReactiveCapabilityCurve can be used
 * @param minR0ToX0Ratio Indicates whether initial symmetrical short-circuit current and power have been calculated according to IEC (Ik").
 *        Used for short circuit data exchange according to IEC 6090
 * @param minR1ToX1Ratio Minimum ratio of positive sequence resistance of Network Feeder to its positive sequence reactance (R(1)/X(1) min).
 *        Used for short circuit data exchange according to IEC 60909
 * @param minZ0ToZ1Ratio Minimum ratio of zero sequence impedance to its positive sequence impedance (Z(0)/Z(1) min).
 *        Used for short circuit data exchange according to IEC 60909
 * @param p Active power injection.
 *        Load sign convention is used, i.e. positive sign means flow out from a node.
 * @param q Reactive power injection.
 *        Load sign convention is used, i.e. positive sign means flow out from a node.
 * @param referencePriority Priority of unit for use as powerflow voltage phase angle reference bus selection. 0 = don t care (default) 1 = highest priority. 2 is less than 1 and so on.
 * @param voltageFactor Voltage factor in pu, which was used to calculate short-circuit current Ik" and power Sk".
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class ExternalNetworkInjection
(
    override val sup: RegulatingCondEq,
    governorSCD: Double,
    ikSecond: Boolean,
    maxInitialSymShCCurrent: Double,
    maxP: Double,
    maxQ: Double,
    maxR0ToX0Ratio: Double,
    maxR1ToX1Ratio: Double,
    maxZ0ToZ1Ratio: Double,
    minInitialSymShCCurrent: Double,
    minP: Double,
    minQ: Double,
    minR0ToX0Ratio: Double,
    minR1ToX1Ratio: Double,
    minZ0ToZ1Ratio: Double,
    p: Double,
    q: Double,
    referencePriority: Int,
    voltageFactor: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def RegulatingCondEq: RegulatingCondEq = sup.asInstanceOf[RegulatingCondEq]
    override def copy (): Row = { clone ().asInstanceOf[ExternalNetworkInjection] }
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
    Parseable[ExternalNetworkInjection]
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

    def parse (context: Context): ExternalNetworkInjection =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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

/**
 * A device to convert from one frequency to another (e.g., frequency F1 to F2) comprises a pair of FrequencyConverter instances.
 *
 * One converts from F1 to DC, the other converts the DC to F2.
 *
 * @param sup [[ch.ninecode.model.RegulatingCondEq RegulatingCondEq]] Reference to the superclass object.
 * @param frequency Frequency on the AC side.
 * @param maxP The maximum active power on the DC side at which the frequence converter should operate.
 * @param maxU The maximum voltage on the DC side at which the frequency converter should operate.
 * @param minP The minimum active power on the DC side at which the frequence converter should operate.
 * @param minU The minimum voltage on the DC side at which the frequency converter should operate.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class FrequencyConverter
(
    override val sup: RegulatingCondEq,
    frequency: Double,
    maxP: Double,
    maxU: Double,
    minP: Double,
    minU: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def RegulatingCondEq: RegulatingCondEq = sup.asInstanceOf[RegulatingCondEq]
    override def copy (): Row = { clone ().asInstanceOf[FrequencyConverter] }
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
    Parseable[FrequencyConverter]
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

    def parse (context: Context): FrequencyConverter =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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

/**
 * An overcurrent protective device with a circuit opening fusible part that is heated and severed by the passage of overcurrent through it.
 *
 * A fuse is considered a switching device because it breaks current.
 *
 * @param sup [[ch.ninecode.model.Switch Switch]] Reference to the superclass object.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class Fuse
(
    override val sup: Switch
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
    def Switch: Switch = sup.asInstanceOf[Switch]
    override def copy (): Row = { clone ().asInstanceOf[Fuse] }
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
        "\t<cim:Fuse rdf:ID=\"%s\">\n%s\t</cim:Fuse>".format (id, export_fields)
    }
}

object Fuse
extends
    Parseable[Fuse]
{

    def parse (context: Context): Fuse =
    {
        implicit val ctx: Context = context
        val ret = Fuse (
            Switch.parse (context)
        )
        ret
    }
}

/**
 * A point where the system is grounded used for connecting conducting equipment to ground.
 *
 * The power system model can have any number of grounds.
 *
 * @param sup [[ch.ninecode.model.ConductingEquipment ConductingEquipment]] Reference to the superclass object.
 * @param GroundAction [[ch.ninecode.model.GroundAction GroundAction]] Action taken with this ground.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class Ground
(
    override val sup: ConductingEquipment,
    GroundAction: String
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
    def ConductingEquipment: ConductingEquipment = sup.asInstanceOf[ConductingEquipment]
    override def copy (): Row = { clone ().asInstanceOf[Ground] }
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
    Parseable[Ground]
{
    override val fields: Array[String] = Array[String] (
        "GroundAction"
    )
    override val relations: List[Relationship] = List (
        Relationship ("GroundAction", "GroundAction", "0..1", "0..1")
    )
    val GroundAction: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): Ground =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Ground (
            ConductingEquipment.parse (context),
            mask (GroundAction (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A manually operated or motor operated mechanical switching device used for isolating a circuit or equipment from ground.
 *
 * @param sup [[ch.ninecode.model.Switch Switch]] Reference to the superclass object.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class GroundDisconnector
(
    override val sup: Switch
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
    def Switch: Switch = sup.asInstanceOf[Switch]
    override def copy (): Row = { clone ().asInstanceOf[GroundDisconnector] }
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
        "\t<cim:GroundDisconnector rdf:ID=\"%s\">\n%s\t</cim:GroundDisconnector>".format (id, export_fields)
    }
}

object GroundDisconnector
extends
    Parseable[GroundDisconnector]
{

    def parse (context: Context): GroundDisconnector =
    {
        implicit val ctx: Context = context
        val ret = GroundDisconnector (
            Switch.parse (context)
        )
        ret
    }
}

/**
 * A fixed impedance device used for grounding.
 *
 * @param sup [[ch.ninecode.model.EarthFaultCompensator EarthFaultCompensator]] Reference to the superclass object.
 * @param x Reactance of device.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class GroundingImpedance
(
    override val sup: EarthFaultCompensator,
    x: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def EarthFaultCompensator: EarthFaultCompensator = sup.asInstanceOf[EarthFaultCompensator]
    override def copy (): Row = { clone ().asInstanceOf[GroundingImpedance] }
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
    Parseable[GroundingImpedance]
{
    override val fields: Array[String] = Array[String] (
        "x"
    )
    val x: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): GroundingImpedance =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = GroundingImpedance (
            EarthFaultCompensator.parse (context),
            toDouble (mask (x (), 0))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A short section of conductor with negligible impedance which can be manually removed and replaced if the circuit is de-energized.
 *
 * Note that zero-impedance branches can potentially be modeled by other equipment types.
 *
 * @param sup [[ch.ninecode.model.Switch Switch]] Reference to the superclass object.
 * @param JumperAction [[ch.ninecode.model.JumperAction JumperAction]] Action taken with this jumper.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class Jumper
(
    override val sup: Switch,
    JumperAction: String
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
    def Switch: Switch = sup.asInstanceOf[Switch]
    override def copy (): Row = { clone ().asInstanceOf[Jumper] }
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
    Parseable[Jumper]
{
    override val fields: Array[String] = Array[String] (
        "JumperAction"
    )
    override val relations: List[Relationship] = List (
        Relationship ("JumperAction", "JumperAction", "0..1", "0..1")
    )
    val JumperAction: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): Jumper =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Jumper (
            Switch.parse (context),
            mask (JumperAction (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A point where one or more conducting equipments are connected with zero resistance.
 *
 * @param sup [[ch.ninecode.model.Connector Connector]] Reference to the superclass object.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class Junction
(
    override val sup: Connector
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
    def Connector: Connector = sup.asInstanceOf[Connector]
    override def copy (): Row = { clone ().asInstanceOf[Junction] }
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
        "\t<cim:Junction rdf:ID=\"%s\">\n%s\t</cim:Junction>".format (id, export_fields)
    }
}

object Junction
extends
    Parseable[Junction]
{

    def parse (context: Context): Junction =
    {
        implicit val ctx: Context = context
        val ret = Junction (
            Connector.parse (context)
        )
        ret
    }
}

/**
 * Contains equipment beyond a substation belonging to a power transmission line.
 *
 * @param sup [[ch.ninecode.model.EquipmentContainer EquipmentContainer]] Reference to the superclass object.
 * @param Region [[ch.ninecode.model.SubGeographicalRegion SubGeographicalRegion]] The sub-geographical region of the line.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class Line
(
    override val sup: EquipmentContainer,
    Region: String
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
    def EquipmentContainer: EquipmentContainer = sup.asInstanceOf[EquipmentContainer]
    override def copy (): Row = { clone ().asInstanceOf[Line] }
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
    Parseable[Line]
{
    override val fields: Array[String] = Array[String] (
        "Region"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Region", "SubGeographicalRegion", "0..1", "0..*")
    )
    val Region: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): Line =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Line (
            EquipmentContainer.parse (context),
            mask (Region (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A linear shunt compensator has banks or sections with equal admittance values.
 *
 * @param sup [[ch.ninecode.model.ShuntCompensator ShuntCompensator]] Reference to the superclass object.
 * @param b0PerSection Zero sequence shunt (charging) susceptance per section
 * @param bPerSection Positive sequence shunt (charging) susceptance per section
 * @param g0PerSection Zero sequence shunt (charging) conductance per section
 * @param gPerSection Positive sequence shunt (charging) conductance per section
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class LinearShuntCompensator
(
    override val sup: ShuntCompensator,
    b0PerSection: Double,
    bPerSection: Double,
    g0PerSection: Double,
    gPerSection: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ShuntCompensator: ShuntCompensator = sup.asInstanceOf[ShuntCompensator]
    override def copy (): Row = { clone ().asInstanceOf[LinearShuntCompensator] }
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
    Parseable[LinearShuntCompensator]
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

    def parse (context: Context): LinearShuntCompensator =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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

/**
 * A per phase linear shunt compensator has banks or sections with equal admittance values.
 *
 * @param sup [[ch.ninecode.model.ShuntCompensatorPhase ShuntCompensatorPhase]] Reference to the superclass object.
 * @param bPerSection Susceptance per section of the phase if shunt compensator is wye connected.
 *        Susceptance per section phase to phase if shunt compensator is delta connected.
 * @param gPerSection Conductance per section for this phase if shunt compensator is wye connected.
 *        Conductance per section phase to phase if shunt compensator is delta connected.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class LinearShuntCompensatorPhase
(
    override val sup: ShuntCompensatorPhase,
    bPerSection: Double,
    gPerSection: Double
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
    def ShuntCompensatorPhase: ShuntCompensatorPhase = sup.asInstanceOf[ShuntCompensatorPhase]
    override def copy (): Row = { clone ().asInstanceOf[LinearShuntCompensatorPhase] }
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
    Parseable[LinearShuntCompensatorPhase]
{
    override val fields: Array[String] = Array[String] (
        "bPerSection",
        "gPerSection"
    )
    val bPerSection: Fielder = parse_element (element (cls, fields(0)))
    val gPerSection: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: Context): LinearShuntCompensatorPhase =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = LinearShuntCompensatorPhase (
            ShuntCompensatorPhase.parse (context),
            toDouble (mask (bPerSection (), 0)),
            toDouble (mask (gPerSection (), 1))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A mechanical switching device capable of making, carrying, and breaking currents under normal operating conditions.
 *
 * @param sup [[ch.ninecode.model.ProtectedSwitch ProtectedSwitch]] Reference to the superclass object.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class LoadBreakSwitch
(
    override val sup: ProtectedSwitch
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
    def ProtectedSwitch: ProtectedSwitch = sup.asInstanceOf[ProtectedSwitch]
    override def copy (): Row = { clone ().asInstanceOf[LoadBreakSwitch] }
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
        "\t<cim:LoadBreakSwitch rdf:ID=\"%s\">\n%s\t</cim:LoadBreakSwitch>".format (id, export_fields)
    }
}

object LoadBreakSwitch
extends
    Parseable[LoadBreakSwitch]
{

    def parse (context: Context): LoadBreakSwitch =
    {
        implicit val ctx: Context = context
        val ret = LoadBreakSwitch (
            ProtectedSwitch.parse (context)
        )
        ret
    }
}

/**
 * This class represents the zero sequence line mutual coupling.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
case class MutualCoupling
(
    override val sup: IdentifiedObject,
    b0ch: Double,
    distance11: Double,
    distance12: Double,
    distance21: Double,
    distance22: Double,
    g0ch: Double,
    r0: Double,
    x0: Double,
    First_Terminal: String,
    Second_Terminal: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[MutualCoupling] }
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
    Parseable[MutualCoupling]
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
    override val relations: List[Relationship] = List (
        Relationship ("First_Terminal", "Terminal", "1", "0..*"),
        Relationship ("Second_Terminal", "Terminal", "1", "0..*")
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

    def parse (context: Context): MutualCoupling =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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

/**
 * A non linear shunt compensator has bank or section admittance values that differs.
 *
 * @param sup [[ch.ninecode.model.ShuntCompensator ShuntCompensator]] Reference to the superclass object.
 * @param NonlinearShuntCompensatorPoints [[ch.ninecode.model.NonlinearShuntCompensatorPoint NonlinearShuntCompensatorPoint]] All points of the non-linear shunt compensator.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class NonlinearShuntCompensator
(
    override val sup: ShuntCompensator,
    NonlinearShuntCompensatorPoints: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ShuntCompensator: ShuntCompensator = sup.asInstanceOf[ShuntCompensator]
    override def copy (): Row = { clone ().asInstanceOf[NonlinearShuntCompensator] }
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
        implicit val clz: String = NonlinearShuntCompensator.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (NonlinearShuntCompensator.fields (position), x))
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
    Parseable[NonlinearShuntCompensator]
{
    override val fields: Array[String] = Array[String] (
        "NonlinearShuntCompensatorPoints"
    )
    override val relations: List[Relationship] = List (
        Relationship ("NonlinearShuntCompensatorPoints", "NonlinearShuntCompensatorPoint", "1..*", "1")
    )
    val NonlinearShuntCompensatorPoints: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): NonlinearShuntCompensator =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = NonlinearShuntCompensator (
            ShuntCompensator.parse (context),
            masks (NonlinearShuntCompensatorPoints (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A per phase non linear shunt compensator has bank or section admittance values that differs.
 *
 * @param sup [[ch.ninecode.model.ShuntCompensatorPhase ShuntCompensatorPhase]] Reference to the superclass object.
 * @param NonlinearShuntCompensatorPhasePoints [[ch.ninecode.model.NonlinearShuntCompensatorPhasePoint NonlinearShuntCompensatorPhasePoint]] All points of the non-linear shunt compensator phase.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class NonlinearShuntCompensatorPhase
(
    override val sup: ShuntCompensatorPhase,
    NonlinearShuntCompensatorPhasePoints: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ShuntCompensatorPhase: ShuntCompensatorPhase = sup.asInstanceOf[ShuntCompensatorPhase]
    override def copy (): Row = { clone ().asInstanceOf[NonlinearShuntCompensatorPhase] }
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
        implicit val clz: String = NonlinearShuntCompensatorPhase.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (NonlinearShuntCompensatorPhase.fields (position), x))
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
    Parseable[NonlinearShuntCompensatorPhase]
{
    override val fields: Array[String] = Array[String] (
        "NonlinearShuntCompensatorPhasePoints"
    )
    override val relations: List[Relationship] = List (
        Relationship ("NonlinearShuntCompensatorPhasePoints", "NonlinearShuntCompensatorPhasePoint", "1..*", "1")
    )
    val NonlinearShuntCompensatorPhasePoints: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): NonlinearShuntCompensatorPhase =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = NonlinearShuntCompensatorPhase (
            ShuntCompensatorPhase.parse (context),
            masks (NonlinearShuntCompensatorPhasePoints (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A per phase non linear shunt compensator bank or section admittance value.
 *
 * @param sup Reference to the superclass object.
 * @param b Positive sequence shunt (charging) susceptance per section
 * @param g Positive sequence shunt (charging) conductance per section
 * @param sectionNumber The number of the section.
 * @param NonlinearShuntCompensatorPhase [[ch.ninecode.model.NonlinearShuntCompensatorPhase NonlinearShuntCompensatorPhase]] Non-linear shunt compensator phase owning this point.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class NonlinearShuntCompensatorPhasePoint
(
    override val sup: BasicElement,
    b: Double,
    g: Double,
    sectionNumber: Int,
    NonlinearShuntCompensatorPhase: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[NonlinearShuntCompensatorPhasePoint] }
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
    Parseable[NonlinearShuntCompensatorPhasePoint]
{
    override val fields: Array[String] = Array[String] (
        "b",
        "g",
        "sectionNumber",
        "NonlinearShuntCompensatorPhase"
    )
    override val relations: List[Relationship] = List (
        Relationship ("NonlinearShuntCompensatorPhase", "NonlinearShuntCompensatorPhase", "1", "1..*")
    )
    val b: Fielder = parse_element (element (cls, fields(0)))
    val g: Fielder = parse_element (element (cls, fields(1)))
    val sectionNumber: Fielder = parse_element (element (cls, fields(2)))
    val NonlinearShuntCompensatorPhase: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): NonlinearShuntCompensatorPhasePoint =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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

/**
 * A non linear shunt compensator bank or section admittance value.
 *
 * @param sup Reference to the superclass object.
 * @param b Positive sequence shunt (charging) susceptance per section
 * @param b0 Zero sequence shunt (charging) susceptance per section
 * @param g Positive sequence shunt (charging) conductance per section
 * @param g0 Zero sequence shunt (charging) conductance per section
 * @param sectionNumber The number of the section.
 * @param NonlinearShuntCompensator [[ch.ninecode.model.NonlinearShuntCompensator NonlinearShuntCompensator]] Non-linear shunt compensator owning this point.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class NonlinearShuntCompensatorPoint
(
    override val sup: BasicElement,
    b: Double,
    b0: Double,
    g: Double,
    g0: Double,
    sectionNumber: Int,
    NonlinearShuntCompensator: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[NonlinearShuntCompensatorPoint] }
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
    Parseable[NonlinearShuntCompensatorPoint]
{
    override val fields: Array[String] = Array[String] (
        "b",
        "b0",
        "g",
        "g0",
        "sectionNumber",
        "NonlinearShuntCompensator"
    )
    override val relations: List[Relationship] = List (
        Relationship ("NonlinearShuntCompensator", "NonlinearShuntCompensator", "1", "1..*")
    )
    val b: Fielder = parse_element (element (cls, fields(0)))
    val b0: Fielder = parse_element (element (cls, fields(1)))
    val g: Fielder = parse_element (element (cls, fields(2)))
    val g0: Fielder = parse_element (element (cls, fields(3)))
    val sectionNumber: Fielder = parse_element (element (cls, fields(4)))
    val NonlinearShuntCompensator: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: Context): NonlinearShuntCompensatorPoint =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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

/**
 * Common type for per-length impedance electrical catalogues.
 *
 * @param sup [[ch.ninecode.model.PerLengthLineParameter PerLengthLineParameter]] Reference to the superclass object.
 * @param ACLineSegments [[ch.ninecode.model.ACLineSegment ACLineSegment]] All line segments described by this per-length impedance.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class PerLengthImpedance
(
    override val sup: PerLengthLineParameter,
    ACLineSegments: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PerLengthLineParameter: PerLengthLineParameter = sup.asInstanceOf[PerLengthLineParameter]
    override def copy (): Row = { clone ().asInstanceOf[PerLengthImpedance] }
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
        implicit val clz: String = PerLengthImpedance.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (PerLengthImpedance.fields (position), x))
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
    Parseable[PerLengthImpedance]
{
    override val fields: Array[String] = Array[String] (
        "ACLineSegments"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ACLineSegments", "ACLineSegment", "0..*", "0..1")
    )
    val ACLineSegments: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): PerLengthImpedance =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = PerLengthImpedance (
            PerLengthLineParameter.parse (context),
            masks (ACLineSegments (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Common type for per-length electrical catalogues describing line parameters.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param WireInfos [[ch.ninecode.model.WireInfo WireInfo]] All wire datasheets used to calculate this per-length parameter.
 * @param WireSpacingInfo [[ch.ninecode.model.WireSpacingInfo WireSpacingInfo]] Wire spacing datasheet used to calculate this per-length parameter.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class PerLengthLineParameter
(
    override val sup: IdentifiedObject,
    WireInfos: List[String],
    WireSpacingInfo: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List(), null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[PerLengthLineParameter] }
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
        implicit val clz: String = PerLengthLineParameter.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PerLengthLineParameter.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (PerLengthLineParameter.fields (position), x))
        emitattrs (0, WireInfos)
        emitattr (1, WireSpacingInfo)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PerLengthLineParameter rdf:ID=\"%s\">\n%s\t</cim:PerLengthLineParameter>".format (id, export_fields)
    }
}

object PerLengthLineParameter
extends
    Parseable[PerLengthLineParameter]
{
    override val fields: Array[String] = Array[String] (
        "WireInfos",
        "WireSpacingInfo"
    )
    override val relations: List[Relationship] = List (
        Relationship ("WireInfos", "WireInfo", "0..*", "0..*"),
        Relationship ("WireSpacingInfo", "WireSpacingInfo", "0..1", "0..*")
    )
    val WireInfos: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val WireSpacingInfo: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): PerLengthLineParameter =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = PerLengthLineParameter (
            IdentifiedObject.parse (context),
            masks (WireInfos (), 0),
            mask (WireSpacingInfo (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Impedance and admittance parameters per unit length for n-wire unbalanced lines, in matrix form.
 *
 * @param sup [[ch.ninecode.model.PerLengthImpedance PerLengthImpedance]] Reference to the superclass object.
 * @param conductorCount Number of phase, neutral, and other wires retained.
 *        Constrains the number of matrix elements and the phase codes that can be used with this matrix.
 * @param PhaseImpedanceData [[ch.ninecode.model.PhaseImpedanceData PhaseImpedanceData]] All data that belong to this conductor phase impedance.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class PerLengthPhaseImpedance
(
    override val sup: PerLengthImpedance,
    conductorCount: Int,
    PhaseImpedanceData: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PerLengthImpedance: PerLengthImpedance = sup.asInstanceOf[PerLengthImpedance]
    override def copy (): Row = { clone ().asInstanceOf[PerLengthPhaseImpedance] }
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
        implicit val clz: String = PerLengthPhaseImpedance.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PerLengthPhaseImpedance.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (PerLengthPhaseImpedance.fields (position), x))
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
    Parseable[PerLengthPhaseImpedance]
{
    override val fields: Array[String] = Array[String] (
        "conductorCount",
        "PhaseImpedanceData"
    )
    override val relations: List[Relationship] = List (
        Relationship ("PhaseImpedanceData", "PhaseImpedanceData", "1..*", "1")
    )
    val conductorCount: Fielder = parse_element (element (cls, fields(0)))
    val PhaseImpedanceData: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): PerLengthPhaseImpedance =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = PerLengthPhaseImpedance (
            PerLengthImpedance.parse (context),
            toInteger (mask (conductorCount (), 0)),
            masks (PhaseImpedanceData (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Sequence impedance and admittance parameters per unit length, for transposed lines of 1, 2, or 3 phases.
 *
 * For 1-phase lines, define x=x0=xself. For 2-phase lines, define x=xs-xm and x0=xs+xm.
 *
 * @param sup [[ch.ninecode.model.PerLengthImpedance PerLengthImpedance]] Reference to the superclass object.
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
case class PerLengthSequenceImpedance
(
    override val sup: PerLengthImpedance,
    b0ch: Double,
    bch: Double,
    g0ch: Double,
    gch: Double,
    r: Double,
    r0: Double,
    x: Double,
    x0: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PerLengthImpedance: PerLengthImpedance = sup.asInstanceOf[PerLengthImpedance]
    override def copy (): Row = { clone ().asInstanceOf[PerLengthSequenceImpedance] }
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
    Parseable[PerLengthSequenceImpedance]
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

    def parse (context: Context): PerLengthSequenceImpedance =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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

/**
 * A tunable impedance device normally used to offset line charging during single line faults in an ungrounded section of network.
 *
 * @param sup [[ch.ninecode.model.EarthFaultCompensator EarthFaultCompensator]] Reference to the superclass object.
 * @param mode The mode of operation of the Petersen coil.
 * @param nominalU The nominal voltage for which the coil is designed.
 * @param offsetCurrent The offset current that the Petersen coil controller is operating from the resonant point.
 *        This is normally a fixed amount for which the controller is configured and could be positive or negative.  Typically 0 to 60 Amperes depending on voltage and resonance conditions.
 * @param positionCurrent The control current used to control the Petersen coil also known as the position current.
 *        Typically in the range of 20-200mA.
 * @param xGroundMax The maximum reactance.
 * @param xGroundMin The minimum reactance.
 * @param xGroundNominal The nominal reactance.
 *        This is the operating point (normally over compensation) that is defined based on the resonance point in the healthy network condition.  The impedance is calculated based on nominal voltage divided by position current.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class PetersenCoil
(
    override val sup: EarthFaultCompensator,
    mode: String,
    nominalU: Double,
    offsetCurrent: Double,
    positionCurrent: Double,
    xGroundMax: Double,
    xGroundMin: Double,
    xGroundNominal: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def EarthFaultCompensator: EarthFaultCompensator = sup.asInstanceOf[EarthFaultCompensator]
    override def copy (): Row = { clone ().asInstanceOf[PetersenCoil] }
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
    Parseable[PetersenCoil]
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

    def parse (context: Context): PetersenCoil =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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

/**
 * Triplet of resistance, reactance, and susceptance matrix element values.
 *
 * @param sup Reference to the superclass object.
 * @param b Susceptance matrix element value, per length of unit.
 * @param r Resistance matrix element value, per length of unit.
 * @param sequenceNumber Column-wise element index, assuming a symmetrical matrix.
 *        Ranges from 1 to N + N*(N-1)/2.
 * @param x Reactance matrix element value, per length of unit.
 * @param PhaseImpedance [[ch.ninecode.model.PerLengthPhaseImpedance PerLengthPhaseImpedance]] Conductor phase impedance to which this data belongs.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class PhaseImpedanceData
(
    override val sup: BasicElement,
    b: Double,
    r: Double,
    sequenceNumber: Int,
    x: Double,
    PhaseImpedance: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[PhaseImpedanceData] }
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
        implicit val clz: String = PhaseImpedanceData.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PhaseImpedanceData.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PhaseImpedanceData.fields (position), value)
        emitelem (0, b)
        emitelem (1, r)
        emitelem (2, sequenceNumber)
        emitelem (3, x)
        emitattr (4, PhaseImpedance)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PhaseImpedanceData rdf:ID=\"%s\">\n%s\t</cim:PhaseImpedanceData>".format (id, export_fields)
    }
}

object PhaseImpedanceData
extends
    Parseable[PhaseImpedanceData]
{
    override val fields: Array[String] = Array[String] (
        "b",
        "r",
        "sequenceNumber",
        "x",
        "PhaseImpedance"
    )
    override val relations: List[Relationship] = List (
        Relationship ("PhaseImpedance", "PerLengthPhaseImpedance", "1", "1..*")
    )
    val b: Fielder = parse_element (element (cls, fields(0)))
    val r: Fielder = parse_element (element (cls, fields(1)))
    val sequenceNumber: Fielder = parse_element (element (cls, fields(2)))
    val x: Fielder = parse_element (element (cls, fields(3)))
    val PhaseImpedance: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): PhaseImpedanceData =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = PhaseImpedanceData (
            BasicElement.parse (context),
            toDouble (mask (b (), 0)),
            toDouble (mask (r (), 1)),
            toInteger (mask (sequenceNumber (), 2)),
            toDouble (mask (x (), 3)),
            mask (PhaseImpedance (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A transformer phase shifting tap model that controls the phase angle difference across the power transformer and potentially the active power flow through the power transformer.
 *
 * This phase tap model may also impact the voltage magnitude.
 *
 * @param sup [[ch.ninecode.model.TapChanger TapChanger]] Reference to the superclass object.
 * @param TransformerEnd [[ch.ninecode.model.TransformerEnd TransformerEnd]] Transformer end to which this phase tap changer belongs.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class PhaseTapChanger
(
    override val sup: TapChanger,
    TransformerEnd: String
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
    def TapChanger: TapChanger = sup.asInstanceOf[TapChanger]
    override def copy (): Row = { clone ().asInstanceOf[PhaseTapChanger] }
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
    Parseable[PhaseTapChanger]
{
    override val fields: Array[String] = Array[String] (
        "TransformerEnd"
    )
    override val relations: List[Relationship] = List (
        Relationship ("TransformerEnd", "TransformerEnd", "1", "0..1")
    )
    val TransformerEnd: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): PhaseTapChanger =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = PhaseTapChanger (
            TapChanger.parse (context),
            mask (TransformerEnd (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Describes the tap model for an asymmetrical phase shifting transformer in which the difference voltage vector adds to the primary side voltage.
 *
 * The angle between the primary side voltage and the difference voltage is named the winding connection angle. The phase shift depends on both the difference voltage magnitude and the winding connection angle.
 *
 * @param sup [[ch.ninecode.model.PhaseTapChangerNonLinear PhaseTapChangerNonLinear]] Reference to the superclass object.
 * @param windingConnectionAngle The phase angle between the in-phase winding and the out-of -phase winding used for creating phase shift.
 *        The out-of-phase winding produces what is known as the difference voltage.  Setting this angle to 90 degrees is not the same as a symmemtrical transformer.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class PhaseTapChangerAsymmetrical
(
    override val sup: PhaseTapChangerNonLinear,
    windingConnectionAngle: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PhaseTapChangerNonLinear: PhaseTapChangerNonLinear = sup.asInstanceOf[PhaseTapChangerNonLinear]
    override def copy (): Row = { clone ().asInstanceOf[PhaseTapChangerAsymmetrical] }
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
    Parseable[PhaseTapChangerAsymmetrical]
{
    override val fields: Array[String] = Array[String] (
        "windingConnectionAngle"
    )
    val windingConnectionAngle: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): PhaseTapChangerAsymmetrical =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = PhaseTapChangerAsymmetrical (
            PhaseTapChangerNonLinear.parse (context),
            toDouble (mask (windingConnectionAngle (), 0))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Describes a tap changer with a linear relation between the tap step and the phase angle difference across the transformer.
 *
 * This is a mathematical model that is an approximation of a real phase tap changer.
 *
 * @param sup [[ch.ninecode.model.PhaseTapChanger PhaseTapChanger]] Reference to the superclass object.
 * @param stepPhaseShiftIncrement Phase shift per step position.
 *        A positive value indicates a positive phase shift from the winding where the tap is located to the other winding (for a two-winding transformer).
 * @param xMax The reactance depend on the tap position according to a "u" shaped curve.
 *        The maximum reactance (xMax) appear at the low and high tap positions.
 * @param xMin The reactance depend on the tap position according to a "u" shaped curve.
 *        The minimum reactance (xMin) appear at the mid tap position.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class PhaseTapChangerLinear
(
    override val sup: PhaseTapChanger,
    stepPhaseShiftIncrement: Double,
    xMax: Double,
    xMin: Double
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
    def PhaseTapChanger: PhaseTapChanger = sup.asInstanceOf[PhaseTapChanger]
    override def copy (): Row = { clone ().asInstanceOf[PhaseTapChangerLinear] }
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
    Parseable[PhaseTapChangerLinear]
{
    override val fields: Array[String] = Array[String] (
        "stepPhaseShiftIncrement",
        "xMax",
        "xMin"
    )
    val stepPhaseShiftIncrement: Fielder = parse_element (element (cls, fields(0)))
    val xMax: Fielder = parse_element (element (cls, fields(1)))
    val xMin: Fielder = parse_element (element (cls, fields(2)))

    def parse (context: Context): PhaseTapChangerLinear =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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

/**
 * The non-linear phase tap changer describes the non-linear behavior of a phase tap changer.
 *
 * This is a base class for the symmetrical and asymmetrical phase tap changer models. The details of these models can be found in the IEC 61970-301 document.
 *
 * @param sup [[ch.ninecode.model.PhaseTapChanger PhaseTapChanger]] Reference to the superclass object.
 * @param voltageStepIncrement The voltage step increment on the out of phase winding specified in percent of nominal voltage of the transformer end.
 * @param xMax The reactance depend on the tap position according to a "u" shaped curve.
 *        The maximum reactance (xMax) appear at the low and high tap positions.
 * @param xMin The reactance depend on the tap position according to a "u" shaped curve.
 *        The minimum reactance (xMin) appear at the mid tap position.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class PhaseTapChangerNonLinear
(
    override val sup: PhaseTapChanger,
    voltageStepIncrement: Double,
    xMax: Double,
    xMin: Double
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
    def PhaseTapChanger: PhaseTapChanger = sup.asInstanceOf[PhaseTapChanger]
    override def copy (): Row = { clone ().asInstanceOf[PhaseTapChangerNonLinear] }
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
    Parseable[PhaseTapChangerNonLinear]
{
    override val fields: Array[String] = Array[String] (
        "voltageStepIncrement",
        "xMax",
        "xMin"
    )
    val voltageStepIncrement: Fielder = parse_element (element (cls, fields(0)))
    val xMax: Fielder = parse_element (element (cls, fields(1)))
    val xMin: Fielder = parse_element (element (cls, fields(2)))

    def parse (context: Context): PhaseTapChangerNonLinear =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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

/**
 * Describes a symmetrical phase shifting transformer tap model in which the secondary side voltage magnitude is the same as at the primary side.
 *
 * The difference voltage magnitude is the base in an equal-sided triangle where the sides corresponds to the primary and secondary voltages. The phase angle difference corresponds to the top angle and can be expressed as twice the arctangent of half the total difference voltage.
 *
 * @param sup [[ch.ninecode.model.PhaseTapChangerNonLinear PhaseTapChangerNonLinear]] Reference to the superclass object.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class PhaseTapChangerSymmetrical
(
    override val sup: PhaseTapChangerNonLinear
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
    def PhaseTapChangerNonLinear: PhaseTapChangerNonLinear = sup.asInstanceOf[PhaseTapChangerNonLinear]
    override def copy (): Row = { clone ().asInstanceOf[PhaseTapChangerSymmetrical] }
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
        "\t<cim:PhaseTapChangerSymmetrical rdf:ID=\"%s\">\n%s\t</cim:PhaseTapChangerSymmetrical>".format (id, export_fields)
    }
}

object PhaseTapChangerSymmetrical
extends
    Parseable[PhaseTapChangerSymmetrical]
{

    def parse (context: Context): PhaseTapChangerSymmetrical =
    {
        implicit val ctx: Context = context
        val ret = PhaseTapChangerSymmetrical (
            PhaseTapChangerNonLinear.parse (context)
        )
        ret
    }
}

/**
 * Describes a tabular curve for how the phase angle difference and impedance varies with the tap step.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param PhaseTapChangerTablePoint [[ch.ninecode.model.PhaseTapChangerTablePoint PhaseTapChangerTablePoint]] The points of this table.
 * @param PhaseTapChangerTabular [[ch.ninecode.model.PhaseTapChangerTabular PhaseTapChangerTabular]] The phase tap changers to which this phase tap table applies.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class PhaseTapChangerTable
(
    override val sup: IdentifiedObject,
    PhaseTapChangerTablePoint: List[String],
    PhaseTapChangerTabular: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[PhaseTapChangerTable] }
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
        implicit val clz: String = PhaseTapChangerTable.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (PhaseTapChangerTable.fields (position), x))
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
    Parseable[PhaseTapChangerTable]
{
    override val fields: Array[String] = Array[String] (
        "PhaseTapChangerTablePoint",
        "PhaseTapChangerTabular"
    )
    override val relations: List[Relationship] = List (
        Relationship ("PhaseTapChangerTablePoint", "PhaseTapChangerTablePoint", "1..*", "1"),
        Relationship ("PhaseTapChangerTabular", "PhaseTapChangerTabular", "0..*", "0..1")
    )
    val PhaseTapChangerTablePoint: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val PhaseTapChangerTabular: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): PhaseTapChangerTable =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = PhaseTapChangerTable (
            IdentifiedObject.parse (context),
            masks (PhaseTapChangerTablePoint (), 0),
            masks (PhaseTapChangerTabular (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Describes each tap step in the phase tap changer tabular curve.
 *
 * @param sup [[ch.ninecode.model.TapChangerTablePoint TapChangerTablePoint]] Reference to the superclass object.
 * @param angle The angle difference in degrees.
 * @param PhaseTapChangerTable [[ch.ninecode.model.PhaseTapChangerTable PhaseTapChangerTable]] The table of this point.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class PhaseTapChangerTablePoint
(
    override val sup: TapChangerTablePoint,
    angle: Double,
    PhaseTapChangerTable: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def TapChangerTablePoint: TapChangerTablePoint = sup.asInstanceOf[TapChangerTablePoint]
    override def copy (): Row = { clone ().asInstanceOf[PhaseTapChangerTablePoint] }
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
    Parseable[PhaseTapChangerTablePoint]
{
    override val fields: Array[String] = Array[String] (
        "angle",
        "PhaseTapChangerTable"
    )
    override val relations: List[Relationship] = List (
        Relationship ("PhaseTapChangerTable", "PhaseTapChangerTable", "1", "1..*")
    )
    val angle: Fielder = parse_element (element (cls, fields(0)))
    val PhaseTapChangerTable: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): PhaseTapChangerTablePoint =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = PhaseTapChangerTablePoint (
            TapChangerTablePoint.parse (context),
            toDouble (mask (angle (), 0)),
            mask (PhaseTapChangerTable (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class PhaseTapChangerTabular
(
    override val sup: PhaseTapChanger,
    PhaseTapChangerTable: String
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
    def PhaseTapChanger: PhaseTapChanger = sup.asInstanceOf[PhaseTapChanger]
    override def copy (): Row = { clone ().asInstanceOf[PhaseTapChangerTabular] }
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
    Parseable[PhaseTapChangerTabular]
{
    override val fields: Array[String] = Array[String] (
        "PhaseTapChangerTable"
    )
    override val relations: List[Relationship] = List (
        Relationship ("PhaseTapChangerTable", "PhaseTapChangerTable", "0..1", "0..*")
    )
    val PhaseTapChangerTable: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): PhaseTapChangerTabular =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = PhaseTapChangerTabular (
            PhaseTapChanger.parse (context),
            mask (PhaseTapChangerTable (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A Plant is a collection of equipment for purposes of generation.
 *
 * @param sup [[ch.ninecode.model.EquipmentContainer EquipmentContainer]] Reference to the superclass object.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class Plant
(
    override val sup: EquipmentContainer
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
    def EquipmentContainer: EquipmentContainer = sup.asInstanceOf[EquipmentContainer]
    override def copy (): Row = { clone ().asInstanceOf[Plant] }
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
        "\t<cim:Plant rdf:ID=\"%s\">\n%s\t</cim:Plant>".format (id, export_fields)
    }
}

object Plant
extends
    Parseable[Plant]
{

    def parse (context: Context): Plant =
    {
        implicit val ctx: Context = context
        val ret = Plant (
            EquipmentContainer.parse (context)
        )
        ret
    }
}

/**
 * An electrical device consisting of  two or more coupled windings, with or without a magnetic core, for introducing mutual coupling between electric circuits.
 *
 * Transformers can be used to control voltage and phase shift (active power flow).
 *
 * @param sup [[ch.ninecode.model.ConductingEquipment ConductingEquipment]] Reference to the superclass object.
 * @param beforeShCircuitHighestOperatingCurrent The highest operating current (Ib in the IEC 60909-0) before short circuit (depends on network configuration and relevant reliability philosophy).
 *        It is used for calculation of the impedance correction factor KT defined in IEC 60909-0.
 * @param beforeShCircuitHighestOperatingVoltage The highest operating voltage (Ub in the IEC 60909-0) before short circuit.
 *        It is used for calculation of the impedance correction factor KT defined in IEC 60909-0. This is worst case voltage on the low side winding (Section 3.7.1 in the standard). Used to define operating conditions.
 * @param beforeShortCircuitAnglePf The angle of power factor before short circuit (phib in the IEC 60909-0).
 *        It is used for calculation of the impedance correction factor KT defined in IEC 60909-0. This is the worst case power factor. Used to define operating conditions.
 * @param highSideMinOperatingU The minimum operating voltage (uQmin in the IEC 60909-0) at the high voltage side (Q side) of the unit transformer of the power station unit.
 *        A value well established from long-term operating experience of the system. It is used for calculation of the impedance correction factor KG defined in IEC 60909-0
 * @param isPartOfGeneratorUnit Indicates whether the machine is part of a power station unit.
 *        Used for short circuit data exchange according to IEC 60909
 * @param operationalValuesConsidered It is used to define if the data (other attributes related to short circuit data exchange) defines long term operational conditions or not.
 *        Used for short circuit data exchange according to IEC 60909.
 * @param vectorGroup Vector group of the transformer for protective relaying, e.g., Dyn1.
 *        For unbalanced transformers, this may not be simply determined from the constituent winding connections and phase angle dispacements.
 * @param PowerTransformerEnd [[ch.ninecode.model.PowerTransformerEnd PowerTransformerEnd]] The ends of this power transformer.
 * @param TransformerTanks [[ch.ninecode.model.TransformerTank TransformerTank]] All transformers that belong to this bank.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class PowerTransformer
(
    override val sup: ConductingEquipment,
    beforeShCircuitHighestOperatingCurrent: Double,
    beforeShCircuitHighestOperatingVoltage: Double,
    beforeShortCircuitAnglePf: Double,
    highSideMinOperatingU: Double,
    isPartOfGeneratorUnit: Boolean,
    operationalValuesConsidered: Boolean,
    vectorGroup: String,
    PowerTransformerEnd: List[String],
    TransformerTanks: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, false, false, null, List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ConductingEquipment: ConductingEquipment = sup.asInstanceOf[ConductingEquipment]
    override def copy (): Row = { clone ().asInstanceOf[PowerTransformer] }
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
        implicit val clz: String = PowerTransformer.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PowerTransformer.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (PowerTransformer.fields (position), x))
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
    Parseable[PowerTransformer]
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
    override val relations: List[Relationship] = List (
        Relationship ("PowerTransformerEnd", "PowerTransformerEnd", "0..*", "0..1"),
        Relationship ("TransformerTanks", "TransformerTank", "0..*", "0..1")
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

    def parse (context: Context): PowerTransformer =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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

/**
 * A PowerTransformerEnd is associated with each Terminal of a PowerTransformer.
 *
 * The impedance values r, r0, x, and x0 of a PowerTransformerEnd represents a star equivalent as follows
 *
 * @param sup [[ch.ninecode.model.TransformerEnd TransformerEnd]] Reference to the superclass object.
 * @param b Magnetizing branch susceptance (B mag).
 *        The value can be positive or negative.
 * @param b0 Zero sequence magnetizing branch susceptance.
 * @param connectionKind Kind of connection.
 * @param g Magnetizing branch conductance.
 * @param g0 Zero sequence magnetizing branch conductance (star-model).
 * @param phaseAngleClock Terminal voltage phase angle displacement where 360 degrees are represented with clock hours.
 *        The valid values are 0 to 11. For example, for the secondary side end of a transformer with vector group code of 'Dyn11', specify the connection kind as wye with neutral and specify the phase angle of the clock as 11.  The clock value of the transformer end number specified as 1, is assumed to be zero.  Note the transformer end number is not assumed to be the same as the terminal sequence number.
 * @param r Resistance (star-model) of the transformer end.
 *        The attribute shall be equal or greater than zero for non-equivalent transformers.
 * @param r0 Zero sequence series resistance (star-model) of the transformer end.
 * @param ratedS Normal apparent power rating.
 *        The attribute shall be a positive value. For a two-winding transformer the values for the high and low voltage sides shall be identical.
 * @param ratedU Rated voltage: phase-phase for three-phase windings, and either phase-phase or phase-neutral for single-phase windings.
 *        A high voltage side, as given by TransformerEnd.endNumber, shall have a ratedU that is greater or equal than ratedU for the lower voltage sides.
 * @param x Positive sequence series reactance (star-model) of the transformer end.
 * @param x0 Zero sequence series reactance of the transformer end.
 * @param PowerTransformer [[ch.ninecode.model.PowerTransformer PowerTransformer]] The power transformer of this power transformer end.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class PowerTransformerEnd
(
    override val sup: TransformerEnd,
    b: Double,
    b0: Double,
    connectionKind: String,
    g: Double,
    g0: Double,
    phaseAngleClock: Int,
    r: Double,
    r0: Double,
    ratedS: Double,
    ratedU: Double,
    x: Double,
    x0: Double,
    PowerTransformer: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, null, 0.0, 0.0, 0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def TransformerEnd: TransformerEnd = sup.asInstanceOf[TransformerEnd]
    override def copy (): Row = { clone ().asInstanceOf[PowerTransformerEnd] }
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
    Parseable[PowerTransformerEnd]
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
    override val relations: List[Relationship] = List (
        Relationship ("PowerTransformer", "PowerTransformer", "0..1", "0..*")
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

    def parse (context: Context): PowerTransformerEnd =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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

/**
 * A ProtectedSwitch is a switching device that can be operated by ProtectionEquipment.
 *
 * @param sup [[ch.ninecode.model.Switch Switch]] Reference to the superclass object.
 * @param breakingCapacity The maximum fault current a breaking device can break safely under prescribed conditions of use.
 * @param OperatedByProtectionEquipment [[ch.ninecode.model.ProtectionEquipment ProtectionEquipment]] Protection equipments that operate this ProtectedSwitch.
 * @param RecloseSequences [[ch.ninecode.model.RecloseSequence RecloseSequence]] A breaker may have zero or more automatic reclosures after a trip occurs.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class ProtectedSwitch
(
    override val sup: Switch,
    breakingCapacity: Double,
    OperatedByProtectionEquipment: List[String],
    RecloseSequences: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Switch: Switch = sup.asInstanceOf[Switch]
    override def copy (): Row = { clone ().asInstanceOf[ProtectedSwitch] }
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
        implicit val clz: String = ProtectedSwitch.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ProtectedSwitch.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (ProtectedSwitch.fields (position), x))
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
    Parseable[ProtectedSwitch]
{
    override val fields: Array[String] = Array[String] (
        "breakingCapacity",
        "OperatedByProtectionEquipment",
        "RecloseSequences"
    )
    override val relations: List[Relationship] = List (
        Relationship ("OperatedByProtectionEquipment", "ProtectionEquipment", "0..*", "0..*"),
        Relationship ("RecloseSequences", "RecloseSequence", "0..*", "1")
    )
    val breakingCapacity: Fielder = parse_element (element (cls, fields(0)))
    val OperatedByProtectionEquipment: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val RecloseSequences: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: Context): ProtectedSwitch =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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

/**
 * A tap changer that changes the voltage ratio impacting the voltage magnitude but not the phase angle across the transformer.
 *
 * @param sup [[ch.ninecode.model.TapChanger TapChanger]] Reference to the superclass object.
 * @param stepVoltageIncrement Tap step increment, in per cent of nominal voltage, per step position.
 * @param tculControlMode Specifies the regulation control mode (voltage or reactive) of the RatioTapChanger.
 * @param RatioTapChangerTable [[ch.ninecode.model.RatioTapChangerTable RatioTapChangerTable]] The tap ratio table for this ratio  tap changer.
 * @param TransformerEnd [[ch.ninecode.model.TransformerEnd TransformerEnd]] Transformer end to which this ratio tap changer belongs.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class RatioTapChanger
(
    override val sup: TapChanger,
    stepVoltageIncrement: Double,
    tculControlMode: String,
    RatioTapChangerTable: String,
    TransformerEnd: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def TapChanger: TapChanger = sup.asInstanceOf[TapChanger]
    override def copy (): Row = { clone ().asInstanceOf[RatioTapChanger] }
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
    Parseable[RatioTapChanger]
{
    override val fields: Array[String] = Array[String] (
        "stepVoltageIncrement",
        "tculControlMode",
        "RatioTapChangerTable",
        "TransformerEnd"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RatioTapChangerTable", "RatioTapChangerTable", "0..1", "0..*"),
        Relationship ("TransformerEnd", "TransformerEnd", "1", "0..1")
    )
    val stepVoltageIncrement: Fielder = parse_element (element (cls, fields(0)))
    val tculControlMode: Fielder = parse_attribute (attribute (cls, fields(1)))
    val RatioTapChangerTable: Fielder = parse_attribute (attribute (cls, fields(2)))
    val TransformerEnd: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): RatioTapChanger =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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

/**
 * Describes a curve for how the voltage magnitude and impedance varies with the tap step.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param RatioTapChanger [[ch.ninecode.model.RatioTapChanger RatioTapChanger]] The ratio tap changer of this tap ratio table.
 * @param RatioTapChangerTablePoint [[ch.ninecode.model.RatioTapChangerTablePoint RatioTapChangerTablePoint]] Points of this table.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class RatioTapChangerTable
(
    override val sup: IdentifiedObject,
    RatioTapChanger: List[String],
    RatioTapChangerTablePoint: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[RatioTapChangerTable] }
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
        implicit val clz: String = RatioTapChangerTable.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (RatioTapChangerTable.fields (position), x))
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
    Parseable[RatioTapChangerTable]
{
    override val fields: Array[String] = Array[String] (
        "RatioTapChanger",
        "RatioTapChangerTablePoint"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RatioTapChanger", "RatioTapChanger", "0..*", "0..1"),
        Relationship ("RatioTapChangerTablePoint", "RatioTapChangerTablePoint", "1..*", "1")
    )
    val RatioTapChanger: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val RatioTapChangerTablePoint: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): RatioTapChangerTable =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = RatioTapChangerTable (
            IdentifiedObject.parse (context),
            masks (RatioTapChanger (), 0),
            masks (RatioTapChangerTablePoint (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Describes each tap step in the ratio tap changer tabular curve.
 *
 * @param sup [[ch.ninecode.model.TapChangerTablePoint TapChangerTablePoint]] Reference to the superclass object.
 * @param RatioTapChangerTable [[ch.ninecode.model.RatioTapChangerTable RatioTapChangerTable]] Table of this point.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class RatioTapChangerTablePoint
(
    override val sup: TapChangerTablePoint,
    RatioTapChangerTable: String
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
    def TapChangerTablePoint: TapChangerTablePoint = sup.asInstanceOf[TapChangerTablePoint]
    override def copy (): Row = { clone ().asInstanceOf[RatioTapChangerTablePoint] }
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
    Parseable[RatioTapChangerTablePoint]
{
    override val fields: Array[String] = Array[String] (
        "RatioTapChangerTable"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RatioTapChangerTable", "RatioTapChangerTable", "1", "1..*")
    )
    val RatioTapChangerTable: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): RatioTapChangerTablePoint =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = RatioTapChangerTablePoint (
            TapChangerTablePoint.parse (context),
            mask (RatioTapChangerTable (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Reactive power rating envelope versus the synchronous machine's active power, in both the generating and motoring modes.
 *
 * For each active power value there is a corresponding high and low reactive power limit  value. Typically there will be a separate curve for each coolant condition, such as hydrogen pressure.  The Y1 axis values represent reactive minimum and the Y2 axis values represent reactive maximum.
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param coolantTemperature The machine's coolant temperature (e.g., ambient air or stator circulating water).
 * @param hydrogenPressure The hydrogen coolant pressure
 * @param EquivalentInjection [[ch.ninecode.model.EquivalentInjection EquivalentInjection]] The equivalent injection using this reactive capability curve.
 * @param InitiallyUsedBySynchronousMachines [[ch.ninecode.model.SynchronousMachine SynchronousMachine]] Synchronous machines using this curve as default.
 * @param SynchronousMachines [[ch.ninecode.model.SynchronousMachine SynchronousMachine]] Synchronous machines using this curve.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class ReactiveCapabilityCurve
(
    override val sup: Curve,
    coolantTemperature: Double,
    hydrogenPressure: Double,
    EquivalentInjection: List[String],
    InitiallyUsedBySynchronousMachines: List[String],
    SynchronousMachines: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, List(), List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[ReactiveCapabilityCurve] }
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
        implicit val clz: String = ReactiveCapabilityCurve.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ReactiveCapabilityCurve.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (ReactiveCapabilityCurve.fields (position), x))
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
    Parseable[ReactiveCapabilityCurve]
{
    override val fields: Array[String] = Array[String] (
        "coolantTemperature",
        "hydrogenPressure",
        "EquivalentInjection",
        "InitiallyUsedBySynchronousMachines",
        "SynchronousMachines"
    )
    override val relations: List[Relationship] = List (
        Relationship ("EquivalentInjection", "EquivalentInjection", "0..*", "0..1"),
        Relationship ("InitiallyUsedBySynchronousMachines", "SynchronousMachine", "1..*", "0..1"),
        Relationship ("SynchronousMachines", "SynchronousMachine", "1..*", "0..*")
    )
    val coolantTemperature: Fielder = parse_element (element (cls, fields(0)))
    val hydrogenPressure: Fielder = parse_element (element (cls, fields(1)))
    val EquivalentInjection: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val InitiallyUsedBySynchronousMachines: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val SynchronousMachines: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: Context): ReactiveCapabilityCurve =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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

/**
 * Pole-mounted fault interrupter with built-in phase and ground relays, current transformer (CT), and supplemental controls.
 *
 * @param sup [[ch.ninecode.model.ProtectedSwitch ProtectedSwitch]] Reference to the superclass object.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class Recloser
(
    override val sup: ProtectedSwitch
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
    def ProtectedSwitch: ProtectedSwitch = sup.asInstanceOf[ProtectedSwitch]
    override def copy (): Row = { clone ().asInstanceOf[Recloser] }
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
        "\t<cim:Recloser rdf:ID=\"%s\">\n%s\t</cim:Recloser>".format (id, export_fields)
    }
}

object Recloser
extends
    Parseable[Recloser]
{

    def parse (context: Context): Recloser =
    {
        implicit val ctx: Context = context
        val ret = Recloser (
            ProtectedSwitch.parse (context)
        )
        ret
    }
}

/**
 * A type of conducting equipment that can regulate a quantity (i.e. voltage or flow) at a specific point in the network.
 *
 * @param sup [[ch.ninecode.model.ConductingEquipment ConductingEquipment]] Reference to the superclass object.
 * @param controlEnabled Specifies the regulation status of the equipment.
 *        True is regulating, false is not regulating.
 * @param RegulatingControl [[ch.ninecode.model.RegulatingControl RegulatingControl]] The regulating control scheme in which this equipment participates.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class RegulatingCondEq
(
    override val sup: ConductingEquipment,
    controlEnabled: Boolean,
    RegulatingControl: String
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
    def ConductingEquipment: ConductingEquipment = sup.asInstanceOf[ConductingEquipment]
    override def copy (): Row = { clone ().asInstanceOf[RegulatingCondEq] }
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
    Parseable[RegulatingCondEq]
{
    override val fields: Array[String] = Array[String] (
        "controlEnabled",
        "RegulatingControl"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RegulatingControl", "RegulatingControl", "0..1", "0..*")
    )
    val controlEnabled: Fielder = parse_element (element (cls, fields(0)))
    val RegulatingControl: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): RegulatingCondEq =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = RegulatingCondEq (
            ConductingEquipment.parse (context),
            toBoolean (mask (controlEnabled (), 0)),
            mask (RegulatingControl (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Specifies a set of equipment that works together to control a power system quantity such as voltage or flow.
 *
 * Remote bus voltage control is possible by specifying the controlled terminal located at some place remote from the controlling equipment.
 *
 * @param sup [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param discrete The regulation is performed in a discrete mode.
 *        This applies to equipment with discrete controls, e.g. tap changers and shunt compensators.
 * @param enabled The flag tells if regulation is enabled.
 * @param mode The regulating control mode presently available.
 *        This specification allows for determining the kind of regulation without need for obtaining the units from a schedule.
 * @param monitoredPhase Phase voltage controlling this regulator, measured at regulator location.
 * @param targetDeadband This is a deadband used with discrete control to avoid excessive update of controls like tap changers and shunt compensator banks while regulating.
 *        The units of those appropriate for the mode.
 * @param targetValue The target value specified for case input.
 *        This value can be used for the target value without the use of schedules. The value has the units appropriate to the mode attribute.
 * @param targetValueUnitMultiplier Specify the multiplier for used for the targetValue.
 * @param ProtectiveActionRegulation [[ch.ninecode.model.ProtectiveActionRegulation ProtectiveActionRegulation]] <em>undocumented</em>
 * @param RegulatingCondEq [[ch.ninecode.model.RegulatingCondEq RegulatingCondEq]] The equipment that participates in this regulating control scheme.
 * @param RegulationSchedule [[ch.ninecode.model.RegulationSchedule RegulationSchedule]] Schedule for this Regulating regulating control.
 * @param Terminal [[ch.ninecode.model.Terminal Terminal]] The terminal associated with this regulating control.
 *        The terminal is associated instead of a node, since the terminal could connect into either a topological node (bus in bus-branch model) or a connectivity node (detailed switch model).  Sometimes it is useful to model regulation at a terminal of a bus bar object since the bus bar can be present in both a bus-branch model or a model with switch detail.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class RegulatingControl
(
    override val sup: PowerSystemResource,
    discrete: Boolean,
    enabled: Boolean,
    mode: String,
    monitoredPhase: String,
    targetDeadband: Double,
    targetValue: Double,
    targetValueUnitMultiplier: String,
    ProtectiveActionRegulation: List[String],
    RegulatingCondEq: List[String],
    RegulationSchedule: List[String],
    Terminal: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, false, null, null, 0.0, 0.0, null, List(), List(), List(), null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { clone ().asInstanceOf[RegulatingControl] }
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
        implicit val clz: String = RegulatingControl.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (RegulatingControl.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RegulatingControl.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (RegulatingControl.fields (position), x))
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
    Parseable[RegulatingControl]
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
    override val relations: List[Relationship] = List (
        Relationship ("ProtectiveActionRegulation", "ProtectiveActionRegulation", "0..*", "1"),
        Relationship ("RegulatingCondEq", "RegulatingCondEq", "0..*", "0..1"),
        Relationship ("RegulationSchedule", "RegulationSchedule", "0..*", "1"),
        Relationship ("Terminal", "Terminal", "0..1", "0..*")
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

    def parse (context: Context): RegulatingControl =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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

/**
 * A pre-established pattern over time for a controlled variable, e.g., busbar voltage.
 *
 * @param sup [[ch.ninecode.model.SeasonDayTypeSchedule SeasonDayTypeSchedule]] Reference to the superclass object.
 * @param RegulatingControl [[ch.ninecode.model.RegulatingControl RegulatingControl]] Regulating controls that have this Schedule.
 * @param VoltageControlZones [[ch.ninecode.model.VoltageControlZone VoltageControlZone]] A VoltageControlZone may have a  voltage regulation schedule.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class RegulationSchedule
(
    override val sup: SeasonDayTypeSchedule,
    RegulatingControl: String,
    VoltageControlZones: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def SeasonDayTypeSchedule: SeasonDayTypeSchedule = sup.asInstanceOf[SeasonDayTypeSchedule]
    override def copy (): Row = { clone ().asInstanceOf[RegulationSchedule] }
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
        implicit val clz: String = RegulationSchedule.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RegulationSchedule.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (RegulationSchedule.fields (position), x))
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
    Parseable[RegulationSchedule]
{
    override val fields: Array[String] = Array[String] (
        "RegulatingControl",
        "VoltageControlZones"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RegulatingControl", "RegulatingControl", "1", "0..*"),
        Relationship ("VoltageControlZones", "VoltageControlZone", "0..*", "0..1")
    )
    val RegulatingControl: Fielder = parse_attribute (attribute (cls, fields(0)))
    val VoltageControlZones: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): RegulationSchedule =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = RegulationSchedule (
            SeasonDayTypeSchedule.parse (context),
            mask (RegulatingControl (), 0),
            masks (VoltageControlZones (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A rotating machine which may be used as a generator or motor.
 *
 * @param sup [[ch.ninecode.model.RegulatingCondEq RegulatingCondEq]] Reference to the superclass object.
 * @param p Active power injection.
 *        Load sign convention is used, i.e. positive sign means flow out from a node.
 * @param q Reactive power injection.
 *        Load sign convention is used, i.e. positive sign means flow out from a node.
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
case class RotatingMachine
(
    override val sup: RegulatingCondEq,
    p: Double,
    q: Double,
    ratedPowerFactor: Double,
    ratedS: Double,
    ratedU: Double,
    GeneratingUnit: String,
    HydroPump: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def RegulatingCondEq: RegulatingCondEq = sup.asInstanceOf[RegulatingCondEq]
    override def copy (): Row = { clone ().asInstanceOf[RotatingMachine] }
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
    Parseable[RotatingMachine]
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
    override val relations: List[Relationship] = List (
        Relationship ("GeneratingUnit", "GeneratingUnit", "0..1", "1..*"),
        Relationship ("HydroPump", "HydroPump", "0..1", "1")
    )
    val p: Fielder = parse_element (element (cls, fields(0)))
    val q: Fielder = parse_element (element (cls, fields(1)))
    val ratedPowerFactor: Fielder = parse_element (element (cls, fields(2)))
    val ratedS: Fielder = parse_element (element (cls, fields(3)))
    val ratedU: Fielder = parse_element (element (cls, fields(4)))
    val GeneratingUnit: Fielder = parse_attribute (attribute (cls, fields(5)))
    val HydroPump: Fielder = parse_attribute (attribute (cls, fields(6)))

    def parse (context: Context): RotatingMachine =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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

/**
 * Automatic switch that will lock open to isolate a faulted section.
 *
 * It may, or may not, have load breaking capability. Its primary purpose is to provide fault sectionalising at locations where the fault current is either too high, or too low, for proper coordination of fuses.
 *
 * @param sup [[ch.ninecode.model.Switch Switch]] Reference to the superclass object.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class Sectionaliser
(
    override val sup: Switch
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
    def Switch: Switch = sup.asInstanceOf[Switch]
    override def copy (): Row = { clone ().asInstanceOf[Sectionaliser] }
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
        "\t<cim:Sectionaliser rdf:ID=\"%s\">\n%s\t</cim:Sectionaliser>".format (id, export_fields)
    }
}

object Sectionaliser
extends
    Parseable[Sectionaliser]
{

    def parse (context: Context): Sectionaliser =
    {
        implicit val ctx: Context = context
        val ret = Sectionaliser (
            Switch.parse (context)
        )
        ret
    }
}

/**
 * A Series Compensator is a series capacitor or reactor or an AC transmission line without charging susceptance.
 *
 * It is a two terminal device.
 *
 * @param sup [[ch.ninecode.model.ConductingEquipment ConductingEquipment]] Reference to the superclass object.
 * @param r Positive sequence resistance.
 * @param r0 Zero sequence resistance.
 * @param varistorPresent Describe if a metal oxide varistor (mov) for over voltage protection is configured at the series compensator.
 * @param varistorRatedCurrent The maximum current the varistor is designed to handle at specified duration.
 * @param varistorVoltageThreshold The dc voltage at which the varistor start conducting.
 * @param x Positive sequence reactance.
 * @param x0 Zero sequence reactance.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class SeriesCompensator
(
    override val sup: ConductingEquipment,
    r: Double,
    r0: Double,
    varistorPresent: Boolean,
    varistorRatedCurrent: Double,
    varistorVoltageThreshold: Double,
    x: Double,
    x0: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, false, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ConductingEquipment: ConductingEquipment = sup.asInstanceOf[ConductingEquipment]
    override def copy (): Row = { clone ().asInstanceOf[SeriesCompensator] }
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
    Parseable[SeriesCompensator]
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

    def parse (context: Context): SeriesCompensator =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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

/**
 * A shunt capacitor or reactor or switchable bank of shunt capacitors or reactors.
 *
 * A section of a shunt compensator is an individual capacitor or reactor.  A negative value for reactivePerSection indicates that the compensator is a reactor. ShuntCompensator is a single terminal device.  Ground is implied.
 *
 * @param sup [[ch.ninecode.model.RegulatingCondEq RegulatingCondEq]] Reference to the superclass object.
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
case class ShuntCompensator
(
    override val sup: RegulatingCondEq,
    aVRDelay: Double,
    grounded: Boolean,
    maximumSections: Int,
    nomU: Double,
    normalSections: Int,
    phaseConnection: String,
    sections: Double,
    switchOnCount: Int,
    switchOnDate: String,
    voltageSensitivity: Double,
    ShuntCompensatorPhase: List[String],
    SvShuntCompensatorSections: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, false, 0, 0.0, 0, null, 0.0, 0, null, 0.0, List(), null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def RegulatingCondEq: RegulatingCondEq = sup.asInstanceOf[RegulatingCondEq]
    override def copy (): Row = { clone ().asInstanceOf[ShuntCompensator] }
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
        implicit val clz: String = ShuntCompensator.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ShuntCompensator.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ShuntCompensator.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (ShuntCompensator.fields (position), x))
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
        emitattr (11, SvShuntCompensatorSections)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ShuntCompensator rdf:ID=\"%s\">\n%s\t</cim:ShuntCompensator>".format (id, export_fields)
    }
}

object ShuntCompensator
extends
    Parseable[ShuntCompensator]
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
    override val relations: List[Relationship] = List (
        Relationship ("ShuntCompensatorPhase", "ShuntCompensatorPhase", "0..*", "1"),
        Relationship ("SvShuntCompensatorSections", "SvShuntCompensatorSections", "0..1", "1")
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
    val SvShuntCompensatorSections: Fielder = parse_attribute (attribute (cls, fields(11)))

    def parse (context: Context): ShuntCompensator =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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
            mask (SvShuntCompensatorSections (), 11)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Single phase of a multi-phase shunt compensator when its attributes might be different per phase.
 *
 * @param sup [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param maximumSections The maximum number of sections that may be switched in for this phase.
 * @param normalSections For the capacitor phase, the normal number of sections switched in.
 * @param phase Phase of this shunt compensator component.
 *        If the shunt compensator is wye connected, the connection is from the indicated phase to the central ground or neutral point.  If the shunt compensator is delta connected, the phase indicates a shunt compensator connected from the indicated phase to the next logical non-neutral phase.
 * @param ShuntCompensator [[ch.ninecode.model.ShuntCompensator ShuntCompensator]] Shunt compensator of this shunt compensator phase.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class ShuntCompensatorPhase
(
    override val sup: PowerSystemResource,
    maximumSections: Int,
    normalSections: Int,
    phase: String,
    ShuntCompensator: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0, 0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { clone ().asInstanceOf[ShuntCompensatorPhase] }
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
    Parseable[ShuntCompensatorPhase]
{
    override val fields: Array[String] = Array[String] (
        "maximumSections",
        "normalSections",
        "phase",
        "ShuntCompensator"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ShuntCompensator", "ShuntCompensator", "1", "0..*")
    )
    val maximumSections: Fielder = parse_element (element (cls, fields(0)))
    val normalSections: Fielder = parse_element (element (cls, fields(1)))
    val phase: Fielder = parse_attribute (attribute (cls, fields(2)))
    val ShuntCompensator: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): ShuntCompensatorPhase =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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

/**
 * A facility for providing variable and controllable shunt reactive power.
 *
 * The SVC typically consists of a stepdown transformer, filter, thyristor-controlled reactor, and thyristor-switched capacitor arms.
 *
 * @param sup [[ch.ninecode.model.RegulatingCondEq RegulatingCondEq]] Reference to the superclass object.
 * @param capacitiveRating Maximum available capacitive reactance.
 * @param inductiveRating Maximum available inductive reactance.
 * @param q Reactive power injection.
 *        Load sign convention is used, i.e. positive sign means flow out from a node.
 * @param sVCControlMode SVC control mode.
 * @param slope The characteristics slope of an SVC defines how the reactive power output changes in proportion to the difference between the regulated bus voltage and the voltage setpoint.
 * @param voltageSetPoint The reactive power output of the SVC is proportional to the difference between the voltage at the regulated bus and the voltage setpoint.
 *        When the regulated bus voltage is equal to the voltage setpoint, the reactive power output is zero.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class StaticVarCompensator
(
    override val sup: RegulatingCondEq,
    capacitiveRating: Double,
    inductiveRating: Double,
    q: Double,
    sVCControlMode: String,
    slope: Double,
    voltageSetPoint: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, null, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def RegulatingCondEq: RegulatingCondEq = sup.asInstanceOf[RegulatingCondEq]
    override def copy (): Row = { clone ().asInstanceOf[StaticVarCompensator] }
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
        implicit val clz: String = StaticVarCompensator.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (StaticVarCompensator.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (StaticVarCompensator.fields (position), value)
        emitelem (0, capacitiveRating)
        emitelem (1, inductiveRating)
        emitelem (2, q)
        emitattr (3, sVCControlMode)
        emitelem (4, slope)
        emitelem (5, voltageSetPoint)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:StaticVarCompensator rdf:ID=\"%s\">\n%s\t</cim:StaticVarCompensator>".format (id, export_fields)
    }
}

object StaticVarCompensator
extends
    Parseable[StaticVarCompensator]
{
    override val fields: Array[String] = Array[String] (
        "capacitiveRating",
        "inductiveRating",
        "q",
        "sVCControlMode",
        "slope",
        "voltageSetPoint"
    )
    val capacitiveRating: Fielder = parse_element (element (cls, fields(0)))
    val inductiveRating: Fielder = parse_element (element (cls, fields(1)))
    val q: Fielder = parse_element (element (cls, fields(2)))
    val sVCControlMode: Fielder = parse_attribute (attribute (cls, fields(3)))
    val slope: Fielder = parse_element (element (cls, fields(4)))
    val voltageSetPoint: Fielder = parse_element (element (cls, fields(5)))

    def parse (context: Context): StaticVarCompensator =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = StaticVarCompensator (
            RegulatingCondEq.parse (context),
            toDouble (mask (capacitiveRating (), 0)),
            toDouble (mask (inductiveRating (), 1)),
            toDouble (mask (q (), 2)),
            mask (sVCControlMode (), 3),
            toDouble (mask (slope (), 4)),
            toDouble (mask (voltageSetPoint (), 5))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A generic device designed to close, or open, or both, one or more electric circuits.
 *
 * All switches are two terminal devices including grounding switches.
 *
 * @param sup [[ch.ninecode.model.ConductingEquipment ConductingEquipment]] Reference to the superclass object.
 * @param normalOpen The attribute is used in cases when no Measurement for the status value is present.
 *        If the Switch has a status measurement the Discrete.normalValue is expected to match with the Switch.normalOpen.
 * @param open The attribute tells if the switch is considered open when used as input to topology processing.
 * @param ratedCurrent The maximum continuous current carrying capacity in amps governed by the device material and construction.
 * @param retained Branch is retained in a bus branch model.
 *        The flow through retained switches will normally be calculated in power flow.
 * @param switchOnCount The switch on count since the switch was last reset or initialized.
 * @param switchOnDate The date and time when the switch was last switched on.
 * @param CompositeSwitch [[ch.ninecode.model.CompositeSwitch CompositeSwitch]] Composite switch to which this Switch belongs.
 * @param ConnectDisconnectFunctions [[ch.ninecode.model.ConnectDisconnectFunction ConnectDisconnectFunction]] <em>undocumented</em>
 * @param Outage [[ch.ninecode.model.Outage Outage]] Current outage of this protective device.
 * @param SwitchAction [[ch.ninecode.model.SwitchAction SwitchAction]] Action changing status of this switch.
 * @param SwitchPhase [[ch.ninecode.model.SwitchPhase SwitchPhase]] The individual switch phases for the switch.
 * @param SwitchSchedules [[ch.ninecode.model.SwitchSchedule SwitchSchedule]] A Switch can be associated with SwitchSchedules.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class Switch
(
    override val sup: ConductingEquipment,
    normalOpen: Boolean,
    open: Boolean,
    ratedCurrent: Double,
    retained: Boolean,
    switchOnCount: Int,
    switchOnDate: String,
    CompositeSwitch: String,
    ConnectDisconnectFunctions: List[String],
    Outage: String,
    SwitchAction: String,
    SwitchPhase: List[String],
    SwitchSchedules: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, false, 0.0, false, 0, null, null, List(), null, null, List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ConductingEquipment: ConductingEquipment = sup.asInstanceOf[ConductingEquipment]
    override def copy (): Row = { clone ().asInstanceOf[Switch] }
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
        implicit val clz: String = Switch.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Switch.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Switch.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (Switch.fields (position), x))
        emitelem (0, normalOpen)
        emitelem (1, open)
        emitelem (2, ratedCurrent)
        emitelem (3, retained)
        emitelem (4, switchOnCount)
        emitelem (5, switchOnDate)
        emitattr (6, CompositeSwitch)
        emitattrs (7, ConnectDisconnectFunctions)
        emitattr (8, Outage)
        emitattr (9, SwitchAction)
        emitattrs (10, SwitchPhase)
        emitattrs (11, SwitchSchedules)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Switch rdf:ID=\"%s\">\n%s\t</cim:Switch>".format (id, export_fields)
    }
}

object Switch
extends
    Parseable[Switch]
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
        "SwitchAction",
        "SwitchPhase",
        "SwitchSchedules"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CompositeSwitch", "CompositeSwitch", "0..1", "0..*"),
        Relationship ("ConnectDisconnectFunctions", "ConnectDisconnectFunction", "0..*", "0..*"),
        Relationship ("Outage", "Outage", "0..1", "0..*"),
        Relationship ("SwitchAction", "SwitchAction", "0..1", "0..1"),
        Relationship ("SwitchPhase", "SwitchPhase", "0..*", "1"),
        Relationship ("SwitchSchedules", "SwitchSchedule", "0..*", "1")
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
    val SwitchAction: Fielder = parse_attribute (attribute (cls, fields(9)))
    val SwitchPhase: FielderMultiple = parse_attributes (attribute (cls, fields(10)))
    val SwitchSchedules: FielderMultiple = parse_attributes (attribute (cls, fields(11)))

    def parse (context: Context): Switch =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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
            mask (SwitchAction (), 9),
            masks (SwitchPhase (), 10),
            masks (SwitchSchedules (), 11)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Single phase of a multi-phase switch when its attributes might be different per phase.
 *
 * @param sup [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param closed The attribute tells if the switch is considered closed when used as input to topology processing.
 * @param normalOpen Used in cases when no Measurement for the status value is present.
 *        If the SwitchPhase has a status measurement the Discrete.normalValue is expected to match with this value.
 * @param phaseSide1 Phase of this SwitchPhase on the side with terminal sequence number equal 1.
 *        Should be a phase contained in that terminal&rsquo;s phases attribute.
 * @param phaseSide2 Phase of this SwitchPhase on the side with terminal sequence number equal 2.
 *        Should be a phase contained in that terminal&rsquo;s Terminal.phases attribute.
 * @param Switch [[ch.ninecode.model.Switch Switch]] The switch of the switch phase.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class SwitchPhase
(
    override val sup: PowerSystemResource,
    closed: Boolean,
    normalOpen: Boolean,
    phaseSide1: String,
    phaseSide2: String,
    Switch: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, false, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { clone ().asInstanceOf[SwitchPhase] }
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
        implicit val clz: String = SwitchPhase.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SwitchPhase.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SwitchPhase.fields (position), value)
        emitelem (0, closed)
        emitelem (1, normalOpen)
        emitattr (2, phaseSide1)
        emitattr (3, phaseSide2)
        emitattr (4, Switch)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SwitchPhase rdf:ID=\"%s\">\n%s\t</cim:SwitchPhase>".format (id, export_fields)
    }
}

object SwitchPhase
extends
    Parseable[SwitchPhase]
{
    override val fields: Array[String] = Array[String] (
        "closed",
        "normalOpen",
        "phaseSide1",
        "phaseSide2",
        "Switch"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Switch", "Switch", "1", "0..*")
    )
    val closed: Fielder = parse_element (element (cls, fields(0)))
    val normalOpen: Fielder = parse_element (element (cls, fields(1)))
    val phaseSide1: Fielder = parse_attribute (attribute (cls, fields(2)))
    val phaseSide2: Fielder = parse_attribute (attribute (cls, fields(3)))
    val Switch: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): SwitchPhase =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = SwitchPhase (
            PowerSystemResource.parse (context),
            toBoolean (mask (closed (), 0)),
            toBoolean (mask (normalOpen (), 1)),
            mask (phaseSide1 (), 2),
            mask (phaseSide2 (), 3),
            mask (Switch (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A schedule of switch positions.
 *
 * If RegularTimePoint.value1 is 0, the switch is open.  If 1, the switch is closed.
 *
 * @param sup [[ch.ninecode.model.SeasonDayTypeSchedule SeasonDayTypeSchedule]] Reference to the superclass object.
 * @param Switch [[ch.ninecode.model.Switch Switch]] A SwitchSchedule is associated with a Switch.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class SwitchSchedule
(
    override val sup: SeasonDayTypeSchedule,
    Switch: String
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
    def SeasonDayTypeSchedule: SeasonDayTypeSchedule = sup.asInstanceOf[SeasonDayTypeSchedule]
    override def copy (): Row = { clone ().asInstanceOf[SwitchSchedule] }
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
    Parseable[SwitchSchedule]
{
    override val fields: Array[String] = Array[String] (
        "Switch"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Switch", "Switch", "1", "0..*")
    )
    val Switch: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): SwitchSchedule =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = SwitchSchedule (
            SeasonDayTypeSchedule.parse (context),
            mask (Switch (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * An electromechanical device that operates with shaft rotating synchronously with the network.
 *
 * It is a single machine operating either as a generator or synchronous condenser or pump.
 *
 * @param sup [[ch.ninecode.model.RotatingMachine RotatingMachine]] Reference to the superclass object.
 * @param aVRToManualLag Time delay required when switching from Automatic Voltage Regulation (AVR) to Manual for a lagging MVAr violation.
 * @param aVRToManualLead Time delay required when switching from Automatic Voltage Regulation (AVR) to Manual for a leading MVAr violation.
 * @param baseQ Default base reactive power value.
 *        This value represents the initial reactive power that can be used by any application function.
 * @param condenserP Active power consumed when in condenser mode operation.
 * @param coolantCondition Temperature or pressure of coolant medium
 * @param coolantType Method of cooling the machine.
 * @param earthing Indicates whether or not the generator is earthed.
 *        Used for short circuit data exchange according to IEC 60909
 * @param earthingStarPointR Generator star point earthing resistance (Re).
 *        Used for short circuit data exchange according to IEC 60909
 * @param earthingStarPointX Generator star point earthing reactance (Xe).
 *        Used for short circuit data exchange according to IEC 60909
 * @param ikk Steady-state short-circuit current (in A for the profile) of generator with compound excitation during 3-phase short circuit.
 *        - Ikk=0: Generator with no compound excitation.
 *        - Ikk?0: Generator with compound excitation.
 *        Ikk is used to calculate the minimum steady-state short-circuit current for generators with compound excitation
 * @param manualToAVR Time delay required when switching from Manual to Automatic Voltage Regulation.
 *        This value is used in the accelerating power reference frame for powerflow solutions
 * @param maxQ Maximum reactive power limit.
 *        This is the maximum (nameplate) limit for the unit.
 * @param maxU Maximum voltage limit for the unit.
 * @param minQ Minimum reactive power limit for the unit.
 * @param minU Minimum voltage  limit for the unit.
 * @param mu Factor to calculate the breaking current (Section 4.5.2.1 in the IEC 60909-0).
 *        Used only for single fed short circuit on a generator (Section 4.3.4.2. in the IEC 60909-0).
 * @param operatingMode Current mode of operation.
 * @param qPercent Percent of the coordinated reactive control that comes from this machine.
 * @param r Equivalent resistance (RG) of generator.
 *        RG is considered for the calculation of all currents, except for the calculation of the peak current ip. Used for short circuit data exchange according to IEC 60909
 * @param r0 Zero sequence resistance of the synchronous machine.
 * @param r2 Negative sequence resistance.
 * @param referencePriority Priority of unit for use as powerflow voltage phase angle reference bus selection. 0 = don t care (default) 1 = highest priority. 2 is less than 1 and so on.
 * @param satDirectSubtransX Direct-axis subtransient reactance saturated, also known as Xd"sat.
 * @param satDirectSyncX Direct-axes saturated synchronous reactance (xdsat); reciprocal of short-circuit ration.
 *        Used for short circuit data exchange, only for single fed short circuit on a generator. (Section 4.3.4.2. in the IEC 60909-0).
 * @param satDirectTransX Saturated Direct-axis transient reactance.
 *        The attribute is primarily used for short circuit calculations according to ANSI.
 * @param shortCircuitRotorType Type of rotor, used by short circuit applications, only for single fed short circuit according to IEC 60909.
 * @param `type` Modes that this synchronous machine can operate in.
 * @param voltageRegulationRange Range of generator voltage regulation (PG in the IEC 60909-0) used for calculation of the impedance correction factor KG defined in IEC 60909-0
 *        This attribute is used to describe the operating voltage of the generating unit.
 * @param x0 Zero sequence reactance of the synchronous machine.
 * @param x2 Negative sequence reactance.
 * @param InitialReactiveCapabilityCurve [[ch.ninecode.model.ReactiveCapabilityCurve ReactiveCapabilityCurve]] The default reactive capability curve for use by a synchronous machine.
 * @param PrimeMovers [[ch.ninecode.model.PrimeMover PrimeMover]] Prime movers that drive this SynchronousMachine.
 * @param ReactiveCapabilityCurves [[ch.ninecode.model.ReactiveCapabilityCurve ReactiveCapabilityCurve]] All available reactive capability curves for this synchronous machine.
 * @param SynchronousMachineDynamics [[ch.ninecode.model.SynchronousMachineDynamics SynchronousMachineDynamics]] Synchronous machine dynamics model used to describe dynamic behavior of this synchronous machine.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class SynchronousMachine
(
    override val sup: RotatingMachine,
    aVRToManualLag: Double,
    aVRToManualLead: Double,
    baseQ: Double,
    condenserP: Double,
    coolantCondition: Double,
    coolantType: String,
    earthing: Boolean,
    earthingStarPointR: Double,
    earthingStarPointX: Double,
    ikk: Double,
    manualToAVR: Double,
    maxQ: Double,
    maxU: Double,
    minQ: Double,
    minU: Double,
    mu: Double,
    operatingMode: String,
    qPercent: Double,
    r: Double,
    r0: Double,
    r2: Double,
    referencePriority: Int,
    satDirectSubtransX: Double,
    satDirectSyncX: Double,
    satDirectTransX: Double,
    shortCircuitRotorType: String,
    `type`: String,
    voltageRegulationRange: Double,
    x0: Double,
    x2: Double,
    InitialReactiveCapabilityCurve: String,
    PrimeMovers: List[String],
    ReactiveCapabilityCurves: List[String],
    SynchronousMachineDynamics: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, null, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, 0.0, 0.0, 0.0, 0.0, 0, 0.0, 0.0, 0.0, null, null, 0.0, 0.0, 0.0, null, List(), List(), null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def RotatingMachine: RotatingMachine = sup.asInstanceOf[RotatingMachine]
    override def copy (): Row = { clone ().asInstanceOf[SynchronousMachine] }
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
        implicit val clz: String = SynchronousMachine.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SynchronousMachine.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SynchronousMachine.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (SynchronousMachine.fields (position), x))
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
    Parseable[SynchronousMachine]
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
    override val relations: List[Relationship] = List (
        Relationship ("InitialReactiveCapabilityCurve", "ReactiveCapabilityCurve", "0..1", "1..*"),
        Relationship ("PrimeMovers", "PrimeMover", "0..*", "0..*"),
        Relationship ("ReactiveCapabilityCurves", "ReactiveCapabilityCurve", "0..*", "1..*"),
        Relationship ("SynchronousMachineDynamics", "SynchronousMachineDynamics", "0..1", "1")
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

    def parse (context: Context): SynchronousMachine =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0,0)
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

/**
 * Mechanism for changing transformer winding tap positions.
 *
 * @param sup [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param controlEnabled Specifies the regulation status of the equipment.
 *        True is regulating, false is not regulating.
 * @param highStep Highest possible tap step position, advance from neutral.
 *        The attribute shall be greater than lowStep.
 * @param initialDelay For an LTC, the delay for initial tap changer operation (first step change)
 * @param lowStep Lowest possible tap step position, retard from neutral
 * @param ltcFlag Specifies whether or not a TapChanger has load tap changing capabilities.
 * @param neutralStep The neutral tap step position for this winding.
 *        The attribute shall be equal or greater than lowStep and equal or less than highStep.
 * @param neutralU Voltage at which the winding operates at the neutral tap setting.
 * @param normalStep The tap step position used in "normal" network operation for this winding.
 *        For a "Fixed" tap changer indicates the current physical tap setting.
 * @param step Tap changer position.
 *        Starting step for a steady state solution. Non integer values are allowed to support continuous tap variables. The reasons for continuous value are to support study cases where no discrete tap changers has yet been designed, a solutions where a narrow voltage band force the tap step to oscillate or accommodate for a continuous solution as input.
 * @param subsequentDelay For an LTC, the delay for subsequent tap changer operation (second and later step changes)
 * @param SvTapStep [[ch.ninecode.model.SvTapStep SvTapStep]] The tap step state associated with the tap changer.
 * @param TapChangerControl [[ch.ninecode.model.TapChangerControl TapChangerControl]] The regulating control scheme in which this tap changer participates.
 * @param TapSchedules [[ch.ninecode.model.TapSchedule TapSchedule]] A TapChanger can have TapSchedules.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class TapChanger
(
    override val sup: PowerSystemResource,
    controlEnabled: Boolean,
    highStep: Int,
    initialDelay: Double,
    lowStep: Int,
    ltcFlag: Boolean,
    neutralStep: Int,
    neutralU: Double,
    normalStep: Int,
    step: Double,
    subsequentDelay: Double,
    SvTapStep: String,
    TapChangerControl: String,
    TapSchedules: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, 0, 0.0, 0, false, 0, 0.0, 0, 0.0, 0.0, null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { clone ().asInstanceOf[TapChanger] }
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
        implicit val clz: String = TapChanger.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TapChanger.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TapChanger.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (TapChanger.fields (position), x))
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
    Parseable[TapChanger]
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
    override val relations: List[Relationship] = List (
        Relationship ("SvTapStep", "SvTapStep", "0..1", "1"),
        Relationship ("TapChangerControl", "TapChangerControl", "0..1", "0..*"),
        Relationship ("TapSchedules", "TapSchedule", "0..*", "1")
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

    def parse (context: Context): TapChanger =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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

/**
 * Describes behavior specific to tap changers, e.g. how the voltage at the end of a line varies with the load level and compensation of the voltage drop by tap adjustment.
 *
 * @param sup [[ch.ninecode.model.RegulatingControl RegulatingControl]] Reference to the superclass object.
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
case class TapChangerControl
(
    override val sup: RegulatingControl,
    limitVoltage: Double,
    lineDropCompensation: Boolean,
    lineDropR: Double,
    lineDropX: Double,
    reverseLineDropR: Double,
    reverseLineDropX: Double,
    TapChanger: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, false, 0.0, 0.0, 0.0, 0.0, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def RegulatingControl: RegulatingControl = sup.asInstanceOf[RegulatingControl]
    override def copy (): Row = { clone ().asInstanceOf[TapChangerControl] }
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
        implicit val clz: String = TapChangerControl.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TapChangerControl.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (TapChangerControl.fields (position), x))
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
    Parseable[TapChangerControl]
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
    override val relations: List[Relationship] = List (
        Relationship ("TapChanger", "TapChanger", "0..*", "0..1")
    )
    val limitVoltage: Fielder = parse_element (element (cls, fields(0)))
    val lineDropCompensation: Fielder = parse_element (element (cls, fields(1)))
    val lineDropR: Fielder = parse_element (element (cls, fields(2)))
    val lineDropX: Fielder = parse_element (element (cls, fields(3)))
    val reverseLineDropR: Fielder = parse_element (element (cls, fields(4)))
    val reverseLineDropX: Fielder = parse_element (element (cls, fields(5)))
    val TapChanger: FielderMultiple = parse_attributes (attribute (cls, fields(6)))

    def parse (context: Context): TapChangerControl =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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

/**

 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class TapChangerTablePoint
(
    override val sup: BasicElement,
    b: Double,
    g: Double,
    r: Double,
    ratio: Double,
    step: Int,
    x: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[TapChangerTablePoint] }
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
    Parseable[TapChangerTablePoint]
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

    def parse (context: Context): TapChangerTablePoint =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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

/**
 * A pre-established pattern over time for a tap step.
 *
 * @param sup [[ch.ninecode.model.SeasonDayTypeSchedule SeasonDayTypeSchedule]] Reference to the superclass object.
 * @param TapChanger [[ch.ninecode.model.TapChanger TapChanger]] A TapSchedule is associated with a TapChanger.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class TapSchedule
(
    override val sup: SeasonDayTypeSchedule,
    TapChanger: String
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
    def SeasonDayTypeSchedule: SeasonDayTypeSchedule = sup.asInstanceOf[SeasonDayTypeSchedule]
    override def copy (): Row = { clone ().asInstanceOf[TapSchedule] }
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
    Parseable[TapSchedule]
{
    override val fields: Array[String] = Array[String] (
        "TapChanger"
    )
    override val relations: List[Relationship] = List (
        Relationship ("TapChanger", "TapChanger", "1", "0..*")
    )
    val TapChanger: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): TapSchedule =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = TapSchedule (
            SeasonDayTypeSchedule.parse (context),
            mask (TapChanger (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The transformer core admittance.
 *
 * Used to specify the core admittance of a transformer in a manner that can be shared among power transformers.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
case class TransformerCoreAdmittance
(
    override val sup: IdentifiedObject,
    b: Double,
    b0: Double,
    g: Double,
    g0: Double,
    TransformerEnd: List[String],
    TransformerEndInfo: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, List(), null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[TransformerCoreAdmittance] }
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
        implicit val clz: String = TransformerCoreAdmittance.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TransformerCoreAdmittance.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TransformerCoreAdmittance.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (TransformerCoreAdmittance.fields (position), x))
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
    Parseable[TransformerCoreAdmittance]
{
    override val fields: Array[String] = Array[String] (
        "b",
        "b0",
        "g",
        "g0",
        "TransformerEnd",
        "TransformerEndInfo"
    )
    override val relations: List[Relationship] = List (
        Relationship ("TransformerEnd", "TransformerEnd", "0..*", "0..1"),
        Relationship ("TransformerEndInfo", "TransformerEndInfo", "0..1", "0..1")
    )
    val b: Fielder = parse_element (element (cls, fields(0)))
    val b0: Fielder = parse_element (element (cls, fields(1)))
    val g: Fielder = parse_element (element (cls, fields(2)))
    val g0: Fielder = parse_element (element (cls, fields(3)))
    val TransformerEnd: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val TransformerEndInfo: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: Context): TransformerCoreAdmittance =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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

/**
 * A conducting connection point of a power transformer.
 *
 * It corresponds to a physical transformer winding terminal.  In earlier CIM versions, the TransformerWinding class served a similar purpose, but this class is more flexible because it associates to terminal but is not a specialization of ConductingEquipment.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param bmagSat Core shunt magnetizing susceptance in the saturation region.
 * @param endNumber Number for this transformer end, corresponding to the end's order in the power transformer vector group or phase angle clock number.
 *        Highest voltage winding should be 1.  Each end within a power transformer should have a unique subsequent end number.   Note the transformer end number need not match the terminal sequence number.
 * @param grounded (for Yn and Zn connections) True if the neutral is solidly grounded.
 * @param magBaseU The reference voltage at which the magnetizing saturation measurements were made
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
case class TransformerEnd
(
    override val sup: IdentifiedObject,
    bmagSat: Double,
    endNumber: Int,
    grounded: Boolean,
    magBaseU: Double,
    magSatFlux: Double,
    rground: Double,
    xground: Double,
    BaseVoltage: String,
    CoreAdmittance: String,
    FromMeshImpedance: List[String],
    FromWindingInsulations: List[String],
    PhaseTapChanger: String,
    RatioTapChanger: String,
    StarImpedance: String,
    Terminal: String,
    ToMeshImpedance: List[String],
    ToWindingInsulations: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0, false, 0.0, 0.0, 0.0, 0.0, null, null, List(), List(), null, null, null, null, List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[TransformerEnd] }
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
        implicit val clz: String = TransformerEnd.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TransformerEnd.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TransformerEnd.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (TransformerEnd.fields (position), x))
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
    Parseable[TransformerEnd]
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
    override val relations: List[Relationship] = List (
        Relationship ("BaseVoltage", "BaseVoltage", "0..1", "0..*"),
        Relationship ("CoreAdmittance", "TransformerCoreAdmittance", "0..1", "0..*"),
        Relationship ("FromMeshImpedance", "TransformerMeshImpedance", "0..*", "1"),
        Relationship ("FromWindingInsulations", "WindingInsulation", "0..*", "1"),
        Relationship ("PhaseTapChanger", "PhaseTapChanger", "0..1", "1"),
        Relationship ("RatioTapChanger", "RatioTapChanger", "0..1", "1"),
        Relationship ("StarImpedance", "TransformerStarImpedance", "0..1", "0..*"),
        Relationship ("Terminal", "Terminal", "0..1", "0..*"),
        Relationship ("ToMeshImpedance", "TransformerMeshImpedance", "0..*", "1..*"),
        Relationship ("ToWindingInsulations", "WindingInsulation", "0..*", "1")
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

    def parse (context: Context): TransformerEnd =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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

/**
 * Transformer mesh impedance (Delta-model) between transformer ends.
 *
 * The typical case is that this class describes the impedance between two transformer ends pair-wise, i.e. the cardinalities at both tranformer end associations are 1. But in cases where two or more transformer ends are modeled the cardinalities are larger than 1.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
case class TransformerMeshImpedance
(
    override val sup: IdentifiedObject,
    r: Double,
    r0: Double,
    x: Double,
    x0: Double,
    FromTransformerEnd: String,
    FromTransformerEndInfo: String,
    ToTransformerEnd: List[String],
    ToTransformerEndInfos: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, null, null, List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[TransformerMeshImpedance] }
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
        implicit val clz: String = TransformerMeshImpedance.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TransformerMeshImpedance.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TransformerMeshImpedance.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (TransformerMeshImpedance.fields (position), x))
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
    Parseable[TransformerMeshImpedance]
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
    override val relations: List[Relationship] = List (
        Relationship ("FromTransformerEnd", "TransformerEnd", "1", "0..*"),
        Relationship ("FromTransformerEndInfo", "TransformerEndInfo", "0..1", "0..*"),
        Relationship ("ToTransformerEnd", "TransformerEnd", "1..*", "0..*"),
        Relationship ("ToTransformerEndInfos", "TransformerEndInfo", "0..*", "0..*")
    )
    val r: Fielder = parse_element (element (cls, fields(0)))
    val r0: Fielder = parse_element (element (cls, fields(1)))
    val x: Fielder = parse_element (element (cls, fields(2)))
    val x0: Fielder = parse_element (element (cls, fields(3)))
    val FromTransformerEnd: Fielder = parse_attribute (attribute (cls, fields(4)))
    val FromTransformerEndInfo: Fielder = parse_attribute (attribute (cls, fields(5)))
    val ToTransformerEnd: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val ToTransformerEndInfos: FielderMultiple = parse_attributes (attribute (cls, fields(7)))

    def parse (context: Context): TransformerMeshImpedance =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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

/**
 * Transformer star impedance (Pi-model) that accurately reflects impedance for transformers with 2 or 3 windings.
 *
 * For transformers with 4 or more windings, you must use TransformerMeshImpedance class.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
case class TransformerStarImpedance
(
    override val sup: IdentifiedObject,
    r: Double,
    r0: Double,
    x: Double,
    x0: Double,
    TransformerEnd: List[String],
    TransformerEndInfo: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, List(), null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[TransformerStarImpedance] }
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
        implicit val clz: String = TransformerStarImpedance.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TransformerStarImpedance.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TransformerStarImpedance.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (TransformerStarImpedance.fields (position), x))
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
    Parseable[TransformerStarImpedance]
{
    override val fields: Array[String] = Array[String] (
        "r",
        "r0",
        "x",
        "x0",
        "TransformerEnd",
        "TransformerEndInfo"
    )
    override val relations: List[Relationship] = List (
        Relationship ("TransformerEnd", "TransformerEnd", "0..*", "0..1"),
        Relationship ("TransformerEndInfo", "TransformerEndInfo", "0..1", "0..1")
    )
    val r: Fielder = parse_element (element (cls, fields(0)))
    val r0: Fielder = parse_element (element (cls, fields(1)))
    val x: Fielder = parse_element (element (cls, fields(2)))
    val x0: Fielder = parse_element (element (cls, fields(3)))
    val TransformerEnd: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val TransformerEndInfo: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: Context): TransformerStarImpedance =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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

/**
 * An assembly of two or more coupled windings that transform electrical power between voltage levels.
 *
 * These windings are bound on a common core and place in the same tank. Transformer tank can be used to model both single-phase and 3-phase transformers.
 *
 * @param sup [[ch.ninecode.model.Equipment Equipment]] Reference to the superclass object.
 * @param PowerTransformer [[ch.ninecode.model.PowerTransformer PowerTransformer]] Bank this transformer belongs to.
 * @param TransformerObservations [[ch.ninecode.model.TransformerObservation TransformerObservation]] <em>undocumented</em>
 * @param TransformerTankEnds [[ch.ninecode.model.TransformerTankEnd TransformerTankEnd]] All windings of this transformer.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class TransformerTank
(
    override val sup: Equipment,
    PowerTransformer: String,
    TransformerObservations: List[String],
    TransformerTankEnds: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Equipment: Equipment = sup.asInstanceOf[Equipment]
    override def copy (): Row = { clone ().asInstanceOf[TransformerTank] }
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
        implicit val clz: String = TransformerTank.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TransformerTank.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (TransformerTank.fields (position), x))
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
    Parseable[TransformerTank]
{
    override val fields: Array[String] = Array[String] (
        "PowerTransformer",
        "TransformerObservations",
        "TransformerTankEnds"
    )
    override val relations: List[Relationship] = List (
        Relationship ("PowerTransformer", "PowerTransformer", "0..1", "0..*"),
        Relationship ("TransformerObservations", "TransformerObservation", "0..*", "0..1"),
        Relationship ("TransformerTankEnds", "TransformerTankEnd", "1..*", "0..1")
    )
    val PowerTransformer: Fielder = parse_attribute (attribute (cls, fields(0)))
    val TransformerObservations: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val TransformerTankEnds: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: Context): TransformerTank =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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

/**
 * Transformer tank end represents an individual winding for unbalanced models or for transformer tanks connected into a bank (and bank is modelled with the PowerTransformer).
 *
 * @param sup [[ch.ninecode.model.TransformerEnd TransformerEnd]] Reference to the superclass object.
 * @param phases Describes the phases carried by a conducting equipment.
 * @param TransformerTank [[ch.ninecode.model.TransformerTank TransformerTank]] Transformer this winding belongs to.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class TransformerTankEnd
(
    override val sup: TransformerEnd,
    phases: String,
    TransformerTank: String
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
    def TransformerEnd: TransformerEnd = sup.asInstanceOf[TransformerEnd]
    override def copy (): Row = { clone ().asInstanceOf[TransformerTankEnd] }
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
    Parseable[TransformerTankEnd]
{
    override val fields: Array[String] = Array[String] (
        "phases",
        "TransformerTank"
    )
    override val relations: List[Relationship] = List (
        Relationship ("TransformerTank", "TransformerTank", "0..1", "1..*")
    )
    val phases: Fielder = parse_attribute (attribute (cls, fields(0)))
    val TransformerTank: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): TransformerTankEnd =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = TransformerTankEnd (
            TransformerEnd.parse (context),
            mask (phases (), 0),
            mask (TransformerTank (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * An area of the power system network which is defined for secondary voltage control purposes.
 *
 * A voltage control zone consists of a collection of substations with a designated bus bar section whose voltage will be controlled.
 *
 * @param sup [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param BusbarSection [[ch.ninecode.model.BusbarSection BusbarSection]] A VoltageControlZone is controlled by a designated BusbarSection.
 * @param RegulationSchedule [[ch.ninecode.model.RegulationSchedule RegulationSchedule]] A VoltageControlZone may have a  voltage regulation schedule.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class VoltageControlZone
(
    override val sup: PowerSystemResource,
    BusbarSection: String,
    RegulationSchedule: String
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
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { clone ().asInstanceOf[VoltageControlZone] }
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
    Parseable[VoltageControlZone]
{
    override val fields: Array[String] = Array[String] (
        "BusbarSection",
        "RegulationSchedule"
    )
    override val relations: List[Relationship] = List (
        Relationship ("BusbarSection", "BusbarSection", "1", "0..1"),
        Relationship ("RegulationSchedule", "RegulationSchedule", "0..1", "0..*")
    )
    val BusbarSection: Fielder = parse_attribute (attribute (cls, fields(0)))
    val RegulationSchedule: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): VoltageControlZone =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = VoltageControlZone (
            PowerSystemResource.parse (context),
            mask (BusbarSection (), 0),
            mask (RegulationSchedule (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _Wires
{
    def register: List[ClassInfo] =
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
            EnergyConsumer.register,
            EnergyConsumerPhase.register,
            EnergySource.register,
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