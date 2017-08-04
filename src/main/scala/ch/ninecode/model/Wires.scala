package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks.
 * This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */

/**
 * A wire or combination of wires, with consistent electrical characteristics, building a single electrical system, used to carry alternating current between points in the power system.
 * For symmetrical, transposed 3ph lines, it is sufficient to use  attributes of the line segment, which describe impedances and admittances for the entire length of the segment.  Additionally impedances can be computed by using length and associated per length impedances.
 * @param sup Reference to the superclass object.
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
 * @param LineGroundingAction Ground action involving clamp usage (for the case when the ground is applied along the line segment instead of at its terminals).
 * @param LineJumpingAction Jumper action involving clamp usage (for the case when the jumper is applied along the line segment instead of at its terminals).
 * @param PerLengthImpedance Per-length impedance of this line segment.
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
    LineGroundingAction: String,
    LineJumpingAction: String,
    PerLengthImpedance: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, null) }
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
        sup.export_fields +
        "\t\t<cim:ACLineSegment.b0ch>" + b0ch + "</cim:ACLineSegment.b0ch>\n" +
        "\t\t<cim:ACLineSegment.bch>" + bch + "</cim:ACLineSegment.bch>\n" +
        "\t\t<cim:ACLineSegment.g0ch>" + g0ch + "</cim:ACLineSegment.g0ch>\n" +
        "\t\t<cim:ACLineSegment.gch>" + gch + "</cim:ACLineSegment.gch>\n" +
        "\t\t<cim:ACLineSegment.r>" + r + "</cim:ACLineSegment.r>\n" +
        "\t\t<cim:ACLineSegment.r0>" + r0 + "</cim:ACLineSegment.r0>\n" +
        "\t\t<cim:ACLineSegment.shortCircuitEndTemperature>" + shortCircuitEndTemperature + "</cim:ACLineSegment.shortCircuitEndTemperature>\n" +
        "\t\t<cim:ACLineSegment.x>" + x + "</cim:ACLineSegment.x>\n" +
        "\t\t<cim:ACLineSegment.x0>" + x0 + "</cim:ACLineSegment.x0>\n" +
        (if (null != LineGroundingAction) "\t\t<cim:ACLineSegment.LineGroundingAction rdf:resource=\"#" + LineGroundingAction + "\"/>\n" else "") +
        (if (null != LineJumpingAction) "\t\t<cim:ACLineSegment.LineJumpingAction rdf:resource=\"#" + LineJumpingAction + "\"/>\n" else "") +
        (if (null != PerLengthImpedance) "\t\t<cim:ACLineSegment.PerLengthImpedance rdf:resource=\"#" + PerLengthImpedance + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ACLineSegment rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ACLineSegment>\n"
    }
}

object ACLineSegment
extends
    Parseable[ACLineSegment]
{
    val b0ch: (Context) => String = parse_element (element ("""ACLineSegment.b0ch"""))
    val bch: (Context) => String = parse_element (element ("""ACLineSegment.bch"""))
    val g0ch: (Context) => String = parse_element (element ("""ACLineSegment.g0ch"""))
    val gch: (Context) => String = parse_element (element ("""ACLineSegment.gch"""))
    val r: (Context) => String = parse_element (element ("""ACLineSegment.r"""))
    val r0: (Context) => String = parse_element (element ("""ACLineSegment.r0"""))
    val shortCircuitEndTemperature: (Context) => String = parse_element (element ("""ACLineSegment.shortCircuitEndTemperature"""))
    val x: (Context) => String = parse_element (element ("""ACLineSegment.x"""))
    val x0: (Context) => String = parse_element (element ("""ACLineSegment.x0"""))
    val LineGroundingAction: (Context) => String = parse_attribute (attribute ("""ACLineSegment.LineGroundingAction"""))
    val LineJumpingAction: (Context) => String = parse_attribute (attribute ("""ACLineSegment.LineJumpingAction"""))
    val PerLengthImpedance: (Context) => String = parse_attribute (attribute ("""ACLineSegment.PerLengthImpedance"""))
    def parse (context: Context): ACLineSegment =
    {
        ACLineSegment(
            Conductor.parse (context),
            toDouble (b0ch (context), context),
            toDouble (bch (context), context),
            toDouble (g0ch (context), context),
            toDouble (gch (context), context),
            toDouble (r (context), context),
            toDouble (r0 (context), context),
            toDouble (shortCircuitEndTemperature (context), context),
            toDouble (x (context), context),
            toDouble (x0 (context), context),
            LineGroundingAction (context),
            LineJumpingAction (context),
            PerLengthImpedance (context)
        )
    }
}

/**
 * Represents a single wire of an alternating current line segment.
 * @param sup Reference to the superclass object.
 * @param phase The phase connection of the wire at both ends.
 * @param ACLineSegment The line segment to which the phase belongs.
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
    def this () = { this (null, null, null) }
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
        sup.export_fields +
        (if (null != phase) "\t\t<cim:ACLineSegmentPhase.phase rdf:resource=\"#" + phase + "\"/>\n" else "") +
        (if (null != ACLineSegment) "\t\t<cim:ACLineSegmentPhase.ACLineSegment rdf:resource=\"#" + ACLineSegment + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ACLineSegmentPhase rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ACLineSegmentPhase>\n"
    }
}

object ACLineSegmentPhase
extends
    Parseable[ACLineSegmentPhase]
{
    val phase: (Context) => String = parse_attribute (attribute ("""ACLineSegmentPhase.phase"""))
    val ACLineSegment: (Context) => String = parse_attribute (attribute ("""ACLineSegmentPhase.ACLineSegment"""))
    def parse (context: Context): ACLineSegmentPhase =
    {
        ACLineSegmentPhase(
            PowerSystemResource.parse (context),
            phase (context),
            ACLineSegment (context)
        )
    }
}

/**
 * A rotating machine whose shaft rotates asynchronously with the electrical field.
 * Also known as an induction machine with no external connection to the rotor windings, e.g squirrel-cage induction machine.
 * @param sup Reference to the superclass object.
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
 * @param AsynchronousMachineDynamics Asynchronous machine dynamics model used to describe dynamic behavior of this asynchronous machine.
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
    def this () = { this (null, null, false, 0.0, 0.0, 0.0, 0.0, 0, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null) }
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
        sup.export_fields +
        (if (null != asynchronousMachineType) "\t\t<cim:AsynchronousMachine.asynchronousMachineType rdf:resource=\"#" + asynchronousMachineType + "\"/>\n" else "") +
        "\t\t<cim:AsynchronousMachine.converterFedDrive>" + converterFedDrive + "</cim:AsynchronousMachine.converterFedDrive>\n" +
        "\t\t<cim:AsynchronousMachine.efficiency>" + efficiency + "</cim:AsynchronousMachine.efficiency>\n" +
        "\t\t<cim:AsynchronousMachine.iaIrRatio>" + iaIrRatio + "</cim:AsynchronousMachine.iaIrRatio>\n" +
        "\t\t<cim:AsynchronousMachine.nominalFrequency>" + nominalFrequency + "</cim:AsynchronousMachine.nominalFrequency>\n" +
        "\t\t<cim:AsynchronousMachine.nominalSpeed>" + nominalSpeed + "</cim:AsynchronousMachine.nominalSpeed>\n" +
        "\t\t<cim:AsynchronousMachine.polePairNumber>" + polePairNumber + "</cim:AsynchronousMachine.polePairNumber>\n" +
        "\t\t<cim:AsynchronousMachine.ratedMechanicalPower>" + ratedMechanicalPower + "</cim:AsynchronousMachine.ratedMechanicalPower>\n" +
        "\t\t<cim:AsynchronousMachine.reversible>" + reversible + "</cim:AsynchronousMachine.reversible>\n" +
        "\t\t<cim:AsynchronousMachine.rr1>" + rr1 + "</cim:AsynchronousMachine.rr1>\n" +
        "\t\t<cim:AsynchronousMachine.rr2>" + rr2 + "</cim:AsynchronousMachine.rr2>\n" +
        "\t\t<cim:AsynchronousMachine.rxLockedRotorRatio>" + rxLockedRotorRatio + "</cim:AsynchronousMachine.rxLockedRotorRatio>\n" +
        "\t\t<cim:AsynchronousMachine.tpo>" + tpo + "</cim:AsynchronousMachine.tpo>\n" +
        "\t\t<cim:AsynchronousMachine.tppo>" + tppo + "</cim:AsynchronousMachine.tppo>\n" +
        "\t\t<cim:AsynchronousMachine.xlr1>" + xlr1 + "</cim:AsynchronousMachine.xlr1>\n" +
        "\t\t<cim:AsynchronousMachine.xlr2>" + xlr2 + "</cim:AsynchronousMachine.xlr2>\n" +
        "\t\t<cim:AsynchronousMachine.xm>" + xm + "</cim:AsynchronousMachine.xm>\n" +
        "\t\t<cim:AsynchronousMachine.xp>" + xp + "</cim:AsynchronousMachine.xp>\n" +
        "\t\t<cim:AsynchronousMachine.xpp>" + xpp + "</cim:AsynchronousMachine.xpp>\n" +
        "\t\t<cim:AsynchronousMachine.xs>" + xs + "</cim:AsynchronousMachine.xs>\n" +
        (if (null != AsynchronousMachineDynamics) "\t\t<cim:AsynchronousMachine.AsynchronousMachineDynamics rdf:resource=\"#" + AsynchronousMachineDynamics + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AsynchronousMachine rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AsynchronousMachine>\n"
    }
}

object AsynchronousMachine
extends
    Parseable[AsynchronousMachine]
{
    val asynchronousMachineType: (Context) => String = parse_attribute (attribute ("""AsynchronousMachine.asynchronousMachineType"""))
    val converterFedDrive: (Context) => String = parse_element (element ("""AsynchronousMachine.converterFedDrive"""))
    val efficiency: (Context) => String = parse_element (element ("""AsynchronousMachine.efficiency"""))
    val iaIrRatio: (Context) => String = parse_element (element ("""AsynchronousMachine.iaIrRatio"""))
    val nominalFrequency: (Context) => String = parse_element (element ("""AsynchronousMachine.nominalFrequency"""))
    val nominalSpeed: (Context) => String = parse_element (element ("""AsynchronousMachine.nominalSpeed"""))
    val polePairNumber: (Context) => String = parse_element (element ("""AsynchronousMachine.polePairNumber"""))
    val ratedMechanicalPower: (Context) => String = parse_element (element ("""AsynchronousMachine.ratedMechanicalPower"""))
    val reversible: (Context) => String = parse_element (element ("""AsynchronousMachine.reversible"""))
    val rr1: (Context) => String = parse_element (element ("""AsynchronousMachine.rr1"""))
    val rr2: (Context) => String = parse_element (element ("""AsynchronousMachine.rr2"""))
    val rxLockedRotorRatio: (Context) => String = parse_element (element ("""AsynchronousMachine.rxLockedRotorRatio"""))
    val tpo: (Context) => String = parse_element (element ("""AsynchronousMachine.tpo"""))
    val tppo: (Context) => String = parse_element (element ("""AsynchronousMachine.tppo"""))
    val xlr1: (Context) => String = parse_element (element ("""AsynchronousMachine.xlr1"""))
    val xlr2: (Context) => String = parse_element (element ("""AsynchronousMachine.xlr2"""))
    val xm: (Context) => String = parse_element (element ("""AsynchronousMachine.xm"""))
    val xp: (Context) => String = parse_element (element ("""AsynchronousMachine.xp"""))
    val xpp: (Context) => String = parse_element (element ("""AsynchronousMachine.xpp"""))
    val xs: (Context) => String = parse_element (element ("""AsynchronousMachine.xs"""))
    val AsynchronousMachineDynamics: (Context) => String = parse_attribute (attribute ("""AsynchronousMachine.AsynchronousMachineDynamics"""))
    def parse (context: Context): AsynchronousMachine =
    {
        AsynchronousMachine(
            RotatingMachine.parse (context),
            asynchronousMachineType (context),
            toBoolean (converterFedDrive (context), context),
            toDouble (efficiency (context), context),
            toDouble (iaIrRatio (context), context),
            toDouble (nominalFrequency (context), context),
            toDouble (nominalSpeed (context), context),
            toInteger (polePairNumber (context), context),
            toDouble (ratedMechanicalPower (context), context),
            toBoolean (reversible (context), context),
            toDouble (rr1 (context), context),
            toDouble (rr2 (context), context),
            toDouble (rxLockedRotorRatio (context), context),
            toDouble (tpo (context), context),
            toDouble (tppo (context), context),
            toDouble (xlr1 (context), context),
            toDouble (xlr2 (context), context),
            toDouble (xm (context), context),
            toDouble (xp (context), context),
            toDouble (xpp (context), context),
            toDouble (xs (context), context),
            AsynchronousMachineDynamics (context)
        )
    }
}

/**
 * Kind of Asynchronous Machine.
 * @param sup Reference to the superclass object.
 * @param generator The Asynchronous Machine is a generator.
 * @param motor The Asynchronous Machine is a motor.
 */
case class AsynchronousMachineKind
(
    override val sup: BasicElement,
    generator: String,
    motor: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[AsynchronousMachineKind] }
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
        (if (null != generator) "\t\t<cim:AsynchronousMachineKind.generator rdf:resource=\"#" + generator + "\"/>\n" else "") +
        (if (null != motor) "\t\t<cim:AsynchronousMachineKind.motor rdf:resource=\"#" + motor + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AsynchronousMachineKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AsynchronousMachineKind>\n"
    }
}

object AsynchronousMachineKind
extends
    Parseable[AsynchronousMachineKind]
{
    val generator: (Context) => String = parse_attribute (attribute ("""AsynchronousMachineKind.generator"""))
    val motor: (Context) => String = parse_attribute (attribute ("""AsynchronousMachineKind.motor"""))
    def parse (context: Context): AsynchronousMachineKind =
    {
        AsynchronousMachineKind(
            BasicElement.parse (context),
            generator (context),
            motor (context)
        )
    }
}

/**
 * A mechanical switching device capable of making, carrying, and breaking currents under normal circuit conditions and also making, carrying for a specified time, and breaking currents under specified abnormal circuit conditions e.g.  those of short circuit.
 * @param sup Reference to the superclass object.
 * @param inTransitTime The transition time from open to close.
 */
case class Breaker
(
    override val sup: ProtectedSwitch,
    inTransitTime: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
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
        sup.export_fields +
        "\t\t<cim:Breaker.inTransitTime>" + inTransitTime + "</cim:Breaker.inTransitTime>\n"
    }
    override def export: String =
    {
        "\t<cim:Breaker rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Breaker>\n"
    }
}

object Breaker
extends
    Parseable[Breaker]
{
    val inTransitTime: (Context) => String = parse_element (element ("""Breaker.inTransitTime"""))
    def parse (context: Context): Breaker =
    {
        Breaker(
            ProtectedSwitch.parse (context),
            toDouble (inTransitTime (context), context)
        )
    }
}

/**
 * A conductor, or group of conductors, with negligible impedance, that serve to connect other conducting equipment within a single substation.
 * Voltage measurements are typically obtained from VoltageTransformers that are connected to busbar sections. A bus bar section may have many physical terminals but for analysis is modelled with exactly one logical terminal.
 * @param sup Reference to the superclass object.
 * @param ipMax Maximum allowable peak short-circuit current of busbar (Ipmax in the IEC 60909-0).
 *        Mechanical limit of the busbar in the substation itself. Used for short circuit data exchange according to IEC 60909
 * @param VoltageControlZone A VoltageControlZone is controlled by a designated BusbarSection.
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
    def this () = { this (null, 0.0, null) }
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
        sup.export_fields +
        "\t\t<cim:BusbarSection.ipMax>" + ipMax + "</cim:BusbarSection.ipMax>\n" +
        (if (null != VoltageControlZone) "\t\t<cim:BusbarSection.VoltageControlZone rdf:resource=\"#" + VoltageControlZone + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:BusbarSection rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:BusbarSection>\n"
    }
}

object BusbarSection
extends
    Parseable[BusbarSection]
{
    val ipMax: (Context) => String = parse_element (element ("""BusbarSection.ipMax"""))
    val VoltageControlZone: (Context) => String = parse_attribute (attribute ("""BusbarSection.VoltageControlZone"""))
    def parse (context: Context): BusbarSection =
    {
        BusbarSection(
            Connector.parse (context),
            toDouble (ipMax (context), context),
            VoltageControlZone (context)
        )
    }
}

/**
 * A Clamp is a galvanic connection at a line segment where other equipment is connected.
 * A Clamp does not cut the line segment.
 * @param sup Reference to the superclass object.
 * @param lengthFromTerminal1 The length to the place where the clamp is located starting from side one of the line segment, i.e. the line segment terminal with sequence number equal to 1.
 * @param ACLineSegment The line segment to which the clamp is connected.
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
    def this () = { this (null, 0.0, null) }
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
        sup.export_fields +
        "\t\t<cim:Clamp.lengthFromTerminal1>" + lengthFromTerminal1 + "</cim:Clamp.lengthFromTerminal1>\n" +
        (if (null != ACLineSegment) "\t\t<cim:Clamp.ACLineSegment rdf:resource=\"#" + ACLineSegment + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Clamp rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Clamp>\n"
    }
}

object Clamp
extends
    Parseable[Clamp]
{
    val lengthFromTerminal1: (Context) => String = parse_element (element ("""Clamp.lengthFromTerminal1"""))
    val ACLineSegment: (Context) => String = parse_attribute (attribute ("""Clamp.ACLineSegment"""))
    def parse (context: Context): Clamp =
    {
        Clamp(
            ConductingEquipment.parse (context),
            toDouble (lengthFromTerminal1 (context), context),
            ACLineSegment (context)
        )
    }
}

/**
 * A model of a set of individual Switches normally enclosed within the same cabinet and possibly with interlocks that restrict the combination of switch positions.
 * These are typically found in medium voltage distribution networks.
 * @param sup Reference to the superclass object.
 * @param compositeSwitchType An alphanumeric code that can be used as a reference to extra information such as the description of the interlocking scheme if any.
 */
case class CompositeSwitch
(
    override val sup: Equipment,
    compositeSwitchType: String
)
extends
    Element
{
    def this () = { this (null, null) }
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
        sup.export_fields +
        (if (null != compositeSwitchType) "\t\t<cim:CompositeSwitch.compositeSwitchType>" + compositeSwitchType + "</cim:CompositeSwitch.compositeSwitchType>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:CompositeSwitch rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CompositeSwitch>\n"
    }
}

object CompositeSwitch
extends
    Parseable[CompositeSwitch]
{
    val compositeSwitchType: (Context) => String = parse_element (element ("""CompositeSwitch.compositeSwitchType"""))
    def parse (context: Context): CompositeSwitch =
    {
        CompositeSwitch(
            Equipment.parse (context),
            compositeSwitchType (context)
        )
    }
}

/**
 * Combination of conducting material with consistent electrical characteristics, building a single electrical system, used to carry current between points in the power system.
 * @param sup Reference to the superclass object.
 * @param len Segment length for calculating line section capabilities
 */
case class Conductor
(
    override val sup: ConductingEquipment,
    len: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
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
        sup.export_fields +
        "\t\t<cim:Conductor.length>" + len + "</cim:Conductor.length>\n"
    }
    override def export: String =
    {
        "\t<cim:Conductor rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Conductor>\n"
    }
}

object Conductor
extends
    Parseable[Conductor]
{
    val len: (Context) => String = parse_element (element ("""Conductor.length"""))
    def parse (context: Context): Conductor =
    {
        Conductor(
            ConductingEquipment.parse (context),
            toDouble (len (context), context)
        )
    }
}

/**
 * A conductor, or group of conductors, with negligible impedance, that serve to connect other conducting equipment within a single substation and are modelled with a single logical terminal.
 * @param sup Reference to the superclass object.
 */
case class Connector
(
    override val sup: ConductingEquipment
)
extends
    Element
{
    def this () = { this (null) }
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:Connector rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Connector>\n"
    }
}

object Connector
extends
    Parseable[Connector]
{
    def parse (context: Context): Connector =
    {
        Connector(
            ConductingEquipment.parse (context)
        )
    }
}

/**
 * Method of cooling a machine.
 * @param sup Reference to the superclass object.
 * @param air Air.
 * @param hydrogenGas Hydrogen gas.
 * @param water Water.
 */
case class CoolantType
(
    override val sup: BasicElement,
    air: String,
    hydrogenGas: String,
    water: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[CoolantType] }
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
        (if (null != air) "\t\t<cim:CoolantType.air rdf:resource=\"#" + air + "\"/>\n" else "") +
        (if (null != hydrogenGas) "\t\t<cim:CoolantType.hydrogenGas rdf:resource=\"#" + hydrogenGas + "\"/>\n" else "") +
        (if (null != water) "\t\t<cim:CoolantType.water rdf:resource=\"#" + water + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:CoolantType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CoolantType>\n"
    }
}

object CoolantType
extends
    Parseable[CoolantType]
{
    val air: (Context) => String = parse_attribute (attribute ("""CoolantType.air"""))
    val hydrogenGas: (Context) => String = parse_attribute (attribute ("""CoolantType.hydrogenGas"""))
    val water: (Context) => String = parse_attribute (attribute ("""CoolantType.water"""))
    def parse (context: Context): CoolantType =
    {
        CoolantType(
            BasicElement.parse (context),
            air (context),
            hydrogenGas (context),
            water (context)
        )
    }
}

/**
 * A cut separates a line segment into two parts.
 * The cut appears as a switch inserted between these two parts and connects them together. As the cut is normally open there is no galvanic connection between the two line segment parts. But it is possible to close the cut to get galvanic connection.
 * @param sup Reference to the superclass object.
 * @param lengthFromTerminal1 The length to the place where the cut is located starting from side one of the cut line segment, i.e. the line segment Terminal with sequenceNumber equal to 1.
 * @param ACLineSegment The line segment to which the cut is applied.
 * @param CutAction Action taken with this cut.
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
    def this () = { this (null, 0.0, null, null) }
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
        sup.export_fields +
        "\t\t<cim:Cut.lengthFromTerminal1>" + lengthFromTerminal1 + "</cim:Cut.lengthFromTerminal1>\n" +
        (if (null != ACLineSegment) "\t\t<cim:Cut.ACLineSegment rdf:resource=\"#" + ACLineSegment + "\"/>\n" else "") +
        (if (null != CutAction) "\t\t<cim:Cut.CutAction rdf:resource=\"#" + CutAction + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Cut rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Cut>\n"
    }
}

object Cut
extends
    Parseable[Cut]
{
    val lengthFromTerminal1: (Context) => String = parse_element (element ("""Cut.lengthFromTerminal1"""))
    val ACLineSegment: (Context) => String = parse_attribute (attribute ("""Cut.ACLineSegment"""))
    val CutAction: (Context) => String = parse_attribute (attribute ("""Cut.CutAction"""))
    def parse (context: Context): Cut =
    {
        Cut(
            Switch.parse (context),
            toDouble (lengthFromTerminal1 (context), context),
            ACLineSegment (context),
            CutAction (context)
        )
    }
}

/**
 * A manually operated or motor operated mechanical switching device used for changing the connections in a circuit, or for isolating a circuit or equipment from a source of power.
 * It is required to open or close circuits when negligible current is broken or made.
 * @param sup Reference to the superclass object.
 */
case class Disconnector
(
    override val sup: Switch
)
extends
    Element
{
    def this () = { this (null) }
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:Disconnector rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Disconnector>\n"
    }
}

object Disconnector
extends
    Parseable[Disconnector]
{
    def parse (context: Context): Disconnector =
    {
        Disconnector(
            Switch.parse (context)
        )
    }
}

/**
 * A conducting equipment used to represent a connection to ground which is typically used to compensate earth faults..
 * An earth fault compensator device modeled with a single terminal implies a second terminal solidly connected to ground.  If two terminals are modeled, the ground is not assumed and normal connection rules apply.
 * @param sup Reference to the superclass object.
 * @param r Nominal resistance of device.
 */
case class EarthFaultCompensator
(
    override val sup: ConductingEquipment,
    r: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
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
        sup.export_fields +
        "\t\t<cim:EarthFaultCompensator.r>" + r + "</cim:EarthFaultCompensator.r>\n"
    }
    override def export: String =
    {
        "\t<cim:EarthFaultCompensator rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:EarthFaultCompensator>\n"
    }
}

object EarthFaultCompensator
extends
    Parseable[EarthFaultCompensator]
{
    val r: (Context) => String = parse_element (element ("""EarthFaultCompensator.r"""))
    def parse (context: Context): EarthFaultCompensator =
    {
        EarthFaultCompensator(
            ConductingEquipment.parse (context),
            toDouble (r (context), context)
        )
    }
}

/**
 * Generic user of energy - a  point of consumption on the power system model.
 * @param sup Reference to the superclass object.
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
 * @param LoadDynamics Load dynamics model used to describe dynamic behavior of this energy consumer.
 * @param LoadResponse The load response characteristic of this load.
 *        If missing, this load is assumed to be constant power.
 * @param PowerCutZone The  energy consumer is assigned to this power cut zone.
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
    LoadDynamics: String,
    LoadResponse: String,
    PowerCutZone: String
)
extends
    Element
{
    def this () = { this (null, 0, false, 0.0, 0.0, 0.0, null, 0.0, 0.0, 0.0, null, null, null) }
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
        sup.export_fields +
        "\t\t<cim:EnergyConsumer.customerCount>" + customerCount + "</cim:EnergyConsumer.customerCount>\n" +
        "\t\t<cim:EnergyConsumer.grounded>" + grounded + "</cim:EnergyConsumer.grounded>\n" +
        "\t\t<cim:EnergyConsumer.p>" + p + "</cim:EnergyConsumer.p>\n" +
        "\t\t<cim:EnergyConsumer.pfixed>" + pfixed + "</cim:EnergyConsumer.pfixed>\n" +
        "\t\t<cim:EnergyConsumer.pfixedPct>" + pfixedPct + "</cim:EnergyConsumer.pfixedPct>\n" +
        (if (null != phaseConnection) "\t\t<cim:EnergyConsumer.phaseConnection rdf:resource=\"#" + phaseConnection + "\"/>\n" else "") +
        "\t\t<cim:EnergyConsumer.q>" + q + "</cim:EnergyConsumer.q>\n" +
        "\t\t<cim:EnergyConsumer.qfixed>" + qfixed + "</cim:EnergyConsumer.qfixed>\n" +
        "\t\t<cim:EnergyConsumer.qfixedPct>" + qfixedPct + "</cim:EnergyConsumer.qfixedPct>\n" +
        (if (null != LoadDynamics) "\t\t<cim:EnergyConsumer.LoadDynamics rdf:resource=\"#" + LoadDynamics + "\"/>\n" else "") +
        (if (null != LoadResponse) "\t\t<cim:EnergyConsumer.LoadResponse rdf:resource=\"#" + LoadResponse + "\"/>\n" else "") +
        (if (null != PowerCutZone) "\t\t<cim:EnergyConsumer.PowerCutZone rdf:resource=\"#" + PowerCutZone + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:EnergyConsumer rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:EnergyConsumer>\n"
    }
}

object EnergyConsumer
extends
    Parseable[EnergyConsumer]
{
    val customerCount: (Context) => String = parse_element (element ("""EnergyConsumer.customerCount"""))
    val grounded: (Context) => String = parse_element (element ("""EnergyConsumer.grounded"""))
    val p: (Context) => String = parse_element (element ("""EnergyConsumer.p"""))
    val pfixed: (Context) => String = parse_element (element ("""EnergyConsumer.pfixed"""))
    val pfixedPct: (Context) => String = parse_element (element ("""EnergyConsumer.pfixedPct"""))
    val phaseConnection: (Context) => String = parse_attribute (attribute ("""EnergyConsumer.phaseConnection"""))
    val q: (Context) => String = parse_element (element ("""EnergyConsumer.q"""))
    val qfixed: (Context) => String = parse_element (element ("""EnergyConsumer.qfixed"""))
    val qfixedPct: (Context) => String = parse_element (element ("""EnergyConsumer.qfixedPct"""))
    val LoadDynamics: (Context) => String = parse_attribute (attribute ("""EnergyConsumer.LoadDynamics"""))
    val LoadResponse: (Context) => String = parse_attribute (attribute ("""EnergyConsumer.LoadResponse"""))
    val PowerCutZone: (Context) => String = parse_attribute (attribute ("""EnergyConsumer.PowerCutZone"""))
    def parse (context: Context): EnergyConsumer =
    {
        EnergyConsumer(
            ConductingEquipment.parse (context),
            toInteger (customerCount (context), context),
            toBoolean (grounded (context), context),
            toDouble (p (context), context),
            toDouble (pfixed (context), context),
            toDouble (pfixedPct (context), context),
            phaseConnection (context),
            toDouble (q (context), context),
            toDouble (qfixed (context), context),
            toDouble (qfixedPct (context), context),
            LoadDynamics (context),
            LoadResponse (context),
            PowerCutZone (context)
        )
    }
}

/**
 * A single phase of an energy consumer.
 * @param sup Reference to the superclass object.
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
 * @param EnergyConsumer The energy consumer to which this phase belongs.
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
    def this () = { this (null, 0.0, 0.0, null, 0.0, 0.0, null) }
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
        sup.export_fields +
        "\t\t<cim:EnergyConsumerPhase.pfixed>" + pfixed + "</cim:EnergyConsumerPhase.pfixed>\n" +
        "\t\t<cim:EnergyConsumerPhase.pfixedPct>" + pfixedPct + "</cim:EnergyConsumerPhase.pfixedPct>\n" +
        (if (null != phase) "\t\t<cim:EnergyConsumerPhase.phase rdf:resource=\"#" + phase + "\"/>\n" else "") +
        "\t\t<cim:EnergyConsumerPhase.qfixed>" + qfixed + "</cim:EnergyConsumerPhase.qfixed>\n" +
        "\t\t<cim:EnergyConsumerPhase.qfixedPct>" + qfixedPct + "</cim:EnergyConsumerPhase.qfixedPct>\n" +
        (if (null != EnergyConsumer) "\t\t<cim:EnergyConsumerPhase.EnergyConsumer rdf:resource=\"#" + EnergyConsumer + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:EnergyConsumerPhase rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:EnergyConsumerPhase>\n"
    }
}

object EnergyConsumerPhase
extends
    Parseable[EnergyConsumerPhase]
{
    val pfixed: (Context) => String = parse_element (element ("""EnergyConsumerPhase.pfixed"""))
    val pfixedPct: (Context) => String = parse_element (element ("""EnergyConsumerPhase.pfixedPct"""))
    val phase: (Context) => String = parse_attribute (attribute ("""EnergyConsumerPhase.phase"""))
    val qfixed: (Context) => String = parse_element (element ("""EnergyConsumerPhase.qfixed"""))
    val qfixedPct: (Context) => String = parse_element (element ("""EnergyConsumerPhase.qfixedPct"""))
    val EnergyConsumer: (Context) => String = parse_attribute (attribute ("""EnergyConsumerPhase.EnergyConsumer"""))
    def parse (context: Context): EnergyConsumerPhase =
    {
        EnergyConsumerPhase(
            PowerSystemResource.parse (context),
            toDouble (pfixed (context), context),
            toDouble (pfixedPct (context), context),
            phase (context),
            toDouble (qfixed (context), context),
            toDouble (qfixedPct (context), context),
            EnergyConsumer (context)
        )
    }
}

/**
 * A generic equivalent for an energy supplier on a transmission or distribution voltage level.
 * @param sup Reference to the superclass object.
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
 * @param EnergySchedulingType Energy Scheduling Type of an Energy Source
 * @param EnergySourceAction Action taken with this energy source.
 * @param WindTurbineType3or4Dynamics Wind generator Type 3 or 4 dynamics model associated with this energy source.
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
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, null) }
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
        sup.export_fields +
        "\t\t<cim:EnergySource.activePower>" + activePower + "</cim:EnergySource.activePower>\n" +
        "\t\t<cim:EnergySource.nominalVoltage>" + nominalVoltage + "</cim:EnergySource.nominalVoltage>\n" +
        "\t\t<cim:EnergySource.r>" + r + "</cim:EnergySource.r>\n" +
        "\t\t<cim:EnergySource.r0>" + r0 + "</cim:EnergySource.r0>\n" +
        "\t\t<cim:EnergySource.reactivePower>" + reactivePower + "</cim:EnergySource.reactivePower>\n" +
        "\t\t<cim:EnergySource.rn>" + rn + "</cim:EnergySource.rn>\n" +
        "\t\t<cim:EnergySource.voltageAngle>" + voltageAngle + "</cim:EnergySource.voltageAngle>\n" +
        "\t\t<cim:EnergySource.voltageMagnitude>" + voltageMagnitude + "</cim:EnergySource.voltageMagnitude>\n" +
        "\t\t<cim:EnergySource.x>" + x + "</cim:EnergySource.x>\n" +
        "\t\t<cim:EnergySource.x0>" + x0 + "</cim:EnergySource.x0>\n" +
        "\t\t<cim:EnergySource.xn>" + xn + "</cim:EnergySource.xn>\n" +
        (if (null != EnergySchedulingType) "\t\t<cim:EnergySource.EnergySchedulingType rdf:resource=\"#" + EnergySchedulingType + "\"/>\n" else "") +
        (if (null != EnergySourceAction) "\t\t<cim:EnergySource.EnergySourceAction rdf:resource=\"#" + EnergySourceAction + "\"/>\n" else "") +
        (if (null != WindTurbineType3or4Dynamics) "\t\t<cim:EnergySource.WindTurbineType3or4Dynamics rdf:resource=\"#" + WindTurbineType3or4Dynamics + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:EnergySource rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:EnergySource>\n"
    }
}

object EnergySource
extends
    Parseable[EnergySource]
{
    val activePower: (Context) => String = parse_element (element ("""EnergySource.activePower"""))
    val nominalVoltage: (Context) => String = parse_element (element ("""EnergySource.nominalVoltage"""))
    val r: (Context) => String = parse_element (element ("""EnergySource.r"""))
    val r0: (Context) => String = parse_element (element ("""EnergySource.r0"""))
    val reactivePower: (Context) => String = parse_element (element ("""EnergySource.reactivePower"""))
    val rn: (Context) => String = parse_element (element ("""EnergySource.rn"""))
    val voltageAngle: (Context) => String = parse_element (element ("""EnergySource.voltageAngle"""))
    val voltageMagnitude: (Context) => String = parse_element (element ("""EnergySource.voltageMagnitude"""))
    val x: (Context) => String = parse_element (element ("""EnergySource.x"""))
    val x0: (Context) => String = parse_element (element ("""EnergySource.x0"""))
    val xn: (Context) => String = parse_element (element ("""EnergySource.xn"""))
    val EnergySchedulingType: (Context) => String = parse_attribute (attribute ("""EnergySource.EnergySchedulingType"""))
    val EnergySourceAction: (Context) => String = parse_attribute (attribute ("""EnergySource.EnergySourceAction"""))
    val WindTurbineType3or4Dynamics: (Context) => String = parse_attribute (attribute ("""EnergySource.WindTurbineType3or4Dynamics"""))
    def parse (context: Context): EnergySource =
    {
        EnergySource(
            ConductingEquipment.parse (context),
            toDouble (activePower (context), context),
            toDouble (nominalVoltage (context), context),
            toDouble (r (context), context),
            toDouble (r0 (context), context),
            toDouble (reactivePower (context), context),
            toDouble (rn (context), context),
            toDouble (voltageAngle (context), context),
            toDouble (voltageMagnitude (context), context),
            toDouble (x (context), context),
            toDouble (x0 (context), context),
            toDouble (xn (context), context),
            EnergySchedulingType (context),
            EnergySourceAction (context),
            WindTurbineType3or4Dynamics (context)
        )
    }
}

/**
 * This class represents external network and it is used for IEC 60909 calculations.
 * @param sup Reference to the superclass object.
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
    def this () = { this (null, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0, 0.0) }
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
        sup.export_fields +
        "\t\t<cim:ExternalNetworkInjection.governorSCD>" + governorSCD + "</cim:ExternalNetworkInjection.governorSCD>\n" +
        "\t\t<cim:ExternalNetworkInjection.ikSecond>" + ikSecond + "</cim:ExternalNetworkInjection.ikSecond>\n" +
        "\t\t<cim:ExternalNetworkInjection.maxInitialSymShCCurrent>" + maxInitialSymShCCurrent + "</cim:ExternalNetworkInjection.maxInitialSymShCCurrent>\n" +
        "\t\t<cim:ExternalNetworkInjection.maxP>" + maxP + "</cim:ExternalNetworkInjection.maxP>\n" +
        "\t\t<cim:ExternalNetworkInjection.maxQ>" + maxQ + "</cim:ExternalNetworkInjection.maxQ>\n" +
        "\t\t<cim:ExternalNetworkInjection.maxR0ToX0Ratio>" + maxR0ToX0Ratio + "</cim:ExternalNetworkInjection.maxR0ToX0Ratio>\n" +
        "\t\t<cim:ExternalNetworkInjection.maxR1ToX1Ratio>" + maxR1ToX1Ratio + "</cim:ExternalNetworkInjection.maxR1ToX1Ratio>\n" +
        "\t\t<cim:ExternalNetworkInjection.maxZ0ToZ1Ratio>" + maxZ0ToZ1Ratio + "</cim:ExternalNetworkInjection.maxZ0ToZ1Ratio>\n" +
        "\t\t<cim:ExternalNetworkInjection.minInitialSymShCCurrent>" + minInitialSymShCCurrent + "</cim:ExternalNetworkInjection.minInitialSymShCCurrent>\n" +
        "\t\t<cim:ExternalNetworkInjection.minP>" + minP + "</cim:ExternalNetworkInjection.minP>\n" +
        "\t\t<cim:ExternalNetworkInjection.minQ>" + minQ + "</cim:ExternalNetworkInjection.minQ>\n" +
        "\t\t<cim:ExternalNetworkInjection.minR0ToX0Ratio>" + minR0ToX0Ratio + "</cim:ExternalNetworkInjection.minR0ToX0Ratio>\n" +
        "\t\t<cim:ExternalNetworkInjection.minR1ToX1Ratio>" + minR1ToX1Ratio + "</cim:ExternalNetworkInjection.minR1ToX1Ratio>\n" +
        "\t\t<cim:ExternalNetworkInjection.minZ0ToZ1Ratio>" + minZ0ToZ1Ratio + "</cim:ExternalNetworkInjection.minZ0ToZ1Ratio>\n" +
        "\t\t<cim:ExternalNetworkInjection.p>" + p + "</cim:ExternalNetworkInjection.p>\n" +
        "\t\t<cim:ExternalNetworkInjection.q>" + q + "</cim:ExternalNetworkInjection.q>\n" +
        "\t\t<cim:ExternalNetworkInjection.referencePriority>" + referencePriority + "</cim:ExternalNetworkInjection.referencePriority>\n" +
        "\t\t<cim:ExternalNetworkInjection.voltageFactor>" + voltageFactor + "</cim:ExternalNetworkInjection.voltageFactor>\n"
    }
    override def export: String =
    {
        "\t<cim:ExternalNetworkInjection rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ExternalNetworkInjection>\n"
    }
}

object ExternalNetworkInjection
extends
    Parseable[ExternalNetworkInjection]
{
    val governorSCD: (Context) => String = parse_element (element ("""ExternalNetworkInjection.governorSCD"""))
    val ikSecond: (Context) => String = parse_element (element ("""ExternalNetworkInjection.ikSecond"""))
    val maxInitialSymShCCurrent: (Context) => String = parse_element (element ("""ExternalNetworkInjection.maxInitialSymShCCurrent"""))
    val maxP: (Context) => String = parse_element (element ("""ExternalNetworkInjection.maxP"""))
    val maxQ: (Context) => String = parse_element (element ("""ExternalNetworkInjection.maxQ"""))
    val maxR0ToX0Ratio: (Context) => String = parse_element (element ("""ExternalNetworkInjection.maxR0ToX0Ratio"""))
    val maxR1ToX1Ratio: (Context) => String = parse_element (element ("""ExternalNetworkInjection.maxR1ToX1Ratio"""))
    val maxZ0ToZ1Ratio: (Context) => String = parse_element (element ("""ExternalNetworkInjection.maxZ0ToZ1Ratio"""))
    val minInitialSymShCCurrent: (Context) => String = parse_element (element ("""ExternalNetworkInjection.minInitialSymShCCurrent"""))
    val minP: (Context) => String = parse_element (element ("""ExternalNetworkInjection.minP"""))
    val minQ: (Context) => String = parse_element (element ("""ExternalNetworkInjection.minQ"""))
    val minR0ToX0Ratio: (Context) => String = parse_element (element ("""ExternalNetworkInjection.minR0ToX0Ratio"""))
    val minR1ToX1Ratio: (Context) => String = parse_element (element ("""ExternalNetworkInjection.minR1ToX1Ratio"""))
    val minZ0ToZ1Ratio: (Context) => String = parse_element (element ("""ExternalNetworkInjection.minZ0ToZ1Ratio"""))
    val p: (Context) => String = parse_element (element ("""ExternalNetworkInjection.p"""))
    val q: (Context) => String = parse_element (element ("""ExternalNetworkInjection.q"""))
    val referencePriority: (Context) => String = parse_element (element ("""ExternalNetworkInjection.referencePriority"""))
    val voltageFactor: (Context) => String = parse_element (element ("""ExternalNetworkInjection.voltageFactor"""))
    def parse (context: Context): ExternalNetworkInjection =
    {
        ExternalNetworkInjection(
            RegulatingCondEq.parse (context),
            toDouble (governorSCD (context), context),
            toBoolean (ikSecond (context), context),
            toDouble (maxInitialSymShCCurrent (context), context),
            toDouble (maxP (context), context),
            toDouble (maxQ (context), context),
            toDouble (maxR0ToX0Ratio (context), context),
            toDouble (maxR1ToX1Ratio (context), context),
            toDouble (maxZ0ToZ1Ratio (context), context),
            toDouble (minInitialSymShCCurrent (context), context),
            toDouble (minP (context), context),
            toDouble (minQ (context), context),
            toDouble (minR0ToX0Ratio (context), context),
            toDouble (minR1ToX1Ratio (context), context),
            toDouble (minZ0ToZ1Ratio (context), context),
            toDouble (p (context), context),
            toDouble (q (context), context),
            toInteger (referencePriority (context), context),
            toDouble (voltageFactor (context), context)
        )
    }
}

/**
 * A device to convert from one frequency to another (e.g., frequency F1 to F2) comprises a pair of FrequencyConverter instances.
 * One converts from F1 to DC, the other converts the DC to F2.
 * @param sup Reference to the superclass object.
 * @param frequency Frequency on the AC side.
 * @param maxP The maximum active power on the DC side at which the frequence converter should operate.
 * @param maxU The maximum voltage on the DC side at which the frequency converter should operate.
 * @param minP The minimum active power on the DC side at which the frequence converter should operate.
 * @param minU The minimum voltage on the DC side at which the frequency converter should operate.
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
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0) }
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
        sup.export_fields +
        "\t\t<cim:FrequencyConverter.frequency>" + frequency + "</cim:FrequencyConverter.frequency>\n" +
        "\t\t<cim:FrequencyConverter.maxP>" + maxP + "</cim:FrequencyConverter.maxP>\n" +
        "\t\t<cim:FrequencyConverter.maxU>" + maxU + "</cim:FrequencyConverter.maxU>\n" +
        "\t\t<cim:FrequencyConverter.minP>" + minP + "</cim:FrequencyConverter.minP>\n" +
        "\t\t<cim:FrequencyConverter.minU>" + minU + "</cim:FrequencyConverter.minU>\n"
    }
    override def export: String =
    {
        "\t<cim:FrequencyConverter rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:FrequencyConverter>\n"
    }
}

object FrequencyConverter
extends
    Parseable[FrequencyConverter]
{
    val frequency: (Context) => String = parse_element (element ("""FrequencyConverter.frequency"""))
    val maxP: (Context) => String = parse_element (element ("""FrequencyConverter.maxP"""))
    val maxU: (Context) => String = parse_element (element ("""FrequencyConverter.maxU"""))
    val minP: (Context) => String = parse_element (element ("""FrequencyConverter.minP"""))
    val minU: (Context) => String = parse_element (element ("""FrequencyConverter.minU"""))
    def parse (context: Context): FrequencyConverter =
    {
        FrequencyConverter(
            RegulatingCondEq.parse (context),
            toDouble (frequency (context), context),
            toDouble (maxP (context), context),
            toDouble (maxU (context), context),
            toDouble (minP (context), context),
            toDouble (minU (context), context)
        )
    }
}

/**
 * An overcurrent protective device with a circuit opening fusible part that is heated and severed by the passage of overcurrent through it.
 * A fuse is considered a switching device because it breaks current.
 * @param sup Reference to the superclass object.
 */
case class Fuse
(
    override val sup: Switch
)
extends
    Element
{
    def this () = { this (null) }
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:Fuse rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Fuse>\n"
    }
}

object Fuse
extends
    Parseable[Fuse]
{
    def parse (context: Context): Fuse =
    {
        Fuse(
            Switch.parse (context)
        )
    }
}

/**
 * A point where the system is grounded used for connecting conducting equipment to ground.
 * The power system model can have any number of grounds.
 * @param sup Reference to the superclass object.
 * @param GroundAction Action taken with this ground.
 */
case class Ground
(
    override val sup: ConductingEquipment,
    GroundAction: String
)
extends
    Element
{
    def this () = { this (null, null) }
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
        sup.export_fields +
        (if (null != GroundAction) "\t\t<cim:Ground.GroundAction rdf:resource=\"#" + GroundAction + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Ground rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Ground>\n"
    }
}

object Ground
extends
    Parseable[Ground]
{
    val GroundAction: (Context) => String = parse_attribute (attribute ("""Ground.GroundAction"""))
    def parse (context: Context): Ground =
    {
        Ground(
            ConductingEquipment.parse (context),
            GroundAction (context)
        )
    }
}

/**
 * A manually operated or motor operated mechanical switching device used for isolating a circuit or equipment from ground.
 * @param sup Reference to the superclass object.
 */
case class GroundDisconnector
(
    override val sup: Switch
)
extends
    Element
{
    def this () = { this (null) }
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:GroundDisconnector rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GroundDisconnector>\n"
    }
}

object GroundDisconnector
extends
    Parseable[GroundDisconnector]
{
    def parse (context: Context): GroundDisconnector =
    {
        GroundDisconnector(
            Switch.parse (context)
        )
    }
}

/**
 * A fixed impedance device used for grounding.
 * @param sup Reference to the superclass object.
 * @param x Reactance of device.
 */
case class GroundingImpedance
(
    override val sup: EarthFaultCompensator,
    x: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
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
        sup.export_fields +
        "\t\t<cim:GroundingImpedance.x>" + x + "</cim:GroundingImpedance.x>\n"
    }
    override def export: String =
    {
        "\t<cim:GroundingImpedance rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GroundingImpedance>\n"
    }
}

object GroundingImpedance
extends
    Parseable[GroundingImpedance]
{
    val x: (Context) => String = parse_element (element ("""GroundingImpedance.x"""))
    def parse (context: Context): GroundingImpedance =
    {
        GroundingImpedance(
            EarthFaultCompensator.parse (context),
            toDouble (x (context), context)
        )
    }
}

/**
 * A short section of conductor with negligible impedance which can be manually removed and replaced if the circuit is de-energized.
 * Note that zero-impedance branches can potentially be modeled by other equipment types.
 * @param sup Reference to the superclass object.
 * @param JumperAction Action taken with this jumper.
 */
case class Jumper
(
    override val sup: Switch,
    JumperAction: String
)
extends
    Element
{
    def this () = { this (null, null) }
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
        sup.export_fields +
        (if (null != JumperAction) "\t\t<cim:Jumper.JumperAction rdf:resource=\"#" + JumperAction + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Jumper rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Jumper>\n"
    }
}

object Jumper
extends
    Parseable[Jumper]
{
    val JumperAction: (Context) => String = parse_attribute (attribute ("""Jumper.JumperAction"""))
    def parse (context: Context): Jumper =
    {
        Jumper(
            Switch.parse (context),
            JumperAction (context)
        )
    }
}

/**
 * A point where one or more conducting equipments are connected with zero resistance.
 * @param sup Reference to the superclass object.
 */
case class Junction
(
    override val sup: Connector
)
extends
    Element
{
    def this () = { this (null) }
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:Junction rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Junction>\n"
    }
}

object Junction
extends
    Parseable[Junction]
{
    def parse (context: Context): Junction =
    {
        Junction(
            Connector.parse (context)
        )
    }
}

/**
 * Contains equipment beyond a substation belonging to a power transmission line.
 * @param sup Reference to the superclass object.
 * @param Region The sub-geographical region of the line.
 */
case class Line
(
    override val sup: EquipmentContainer,
    Region: String
)
extends
    Element
{
    def this () = { this (null, null) }
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
        sup.export_fields +
        (if (null != Region) "\t\t<cim:Line.Region rdf:resource=\"#" + Region + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Line rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Line>\n"
    }
}

object Line
extends
    Parseable[Line]
{
    val Region: (Context) => String = parse_attribute (attribute ("""Line.Region"""))
    def parse (context: Context): Line =
    {
        Line(
            EquipmentContainer.parse (context),
            Region (context)
        )
    }
}

/**
 * A linear shunt compensator has banks or sections with equal admittance values.
 * @param sup Reference to the superclass object.
 * @param b0PerSection Zero sequence shunt (charging) susceptance per section
 * @param bPerSection Positive sequence shunt (charging) susceptance per section
 * @param g0PerSection Zero sequence shunt (charging) conductance per section
 * @param gPerSection Positive sequence shunt (charging) conductance per section
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
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0) }
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
        sup.export_fields +
        "\t\t<cim:LinearShuntCompensator.b0PerSection>" + b0PerSection + "</cim:LinearShuntCompensator.b0PerSection>\n" +
        "\t\t<cim:LinearShuntCompensator.bPerSection>" + bPerSection + "</cim:LinearShuntCompensator.bPerSection>\n" +
        "\t\t<cim:LinearShuntCompensator.g0PerSection>" + g0PerSection + "</cim:LinearShuntCompensator.g0PerSection>\n" +
        "\t\t<cim:LinearShuntCompensator.gPerSection>" + gPerSection + "</cim:LinearShuntCompensator.gPerSection>\n"
    }
    override def export: String =
    {
        "\t<cim:LinearShuntCompensator rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:LinearShuntCompensator>\n"
    }
}

object LinearShuntCompensator
extends
    Parseable[LinearShuntCompensator]
{
    val b0PerSection: (Context) => String = parse_element (element ("""LinearShuntCompensator.b0PerSection"""))
    val bPerSection: (Context) => String = parse_element (element ("""LinearShuntCompensator.bPerSection"""))
    val g0PerSection: (Context) => String = parse_element (element ("""LinearShuntCompensator.g0PerSection"""))
    val gPerSection: (Context) => String = parse_element (element ("""LinearShuntCompensator.gPerSection"""))
    def parse (context: Context): LinearShuntCompensator =
    {
        LinearShuntCompensator(
            ShuntCompensator.parse (context),
            toDouble (b0PerSection (context), context),
            toDouble (bPerSection (context), context),
            toDouble (g0PerSection (context), context),
            toDouble (gPerSection (context), context)
        )
    }
}

/**
 * A per phase linear shunt compensator has banks or sections with equal admittance values.
 * @param sup Reference to the superclass object.
 * @param bPerSection Susceptance per section of the phase if shunt compensator is wye connected.
 *        Susceptance per section phase to phase if shunt compensator is delta connected.
 * @param gPerSection Conductance per section for this phase if shunt compensator is wye connected.
 *        Conductance per section phase to phase if shunt compensator is delta connected.
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
    def this () = { this (null, 0.0, 0.0) }
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
        sup.export_fields +
        "\t\t<cim:LinearShuntCompensatorPhase.bPerSection>" + bPerSection + "</cim:LinearShuntCompensatorPhase.bPerSection>\n" +
        "\t\t<cim:LinearShuntCompensatorPhase.gPerSection>" + gPerSection + "</cim:LinearShuntCompensatorPhase.gPerSection>\n"
    }
    override def export: String =
    {
        "\t<cim:LinearShuntCompensatorPhase rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:LinearShuntCompensatorPhase>\n"
    }
}

object LinearShuntCompensatorPhase
extends
    Parseable[LinearShuntCompensatorPhase]
{
    val bPerSection: (Context) => String = parse_element (element ("""LinearShuntCompensatorPhase.bPerSection"""))
    val gPerSection: (Context) => String = parse_element (element ("""LinearShuntCompensatorPhase.gPerSection"""))
    def parse (context: Context): LinearShuntCompensatorPhase =
    {
        LinearShuntCompensatorPhase(
            ShuntCompensatorPhase.parse (context),
            toDouble (bPerSection (context), context),
            toDouble (gPerSection (context), context)
        )
    }
}

/**
 * A mechanical switching device capable of making, carrying, and breaking currents under normal operating conditions.
 * @param sup Reference to the superclass object.
 */
case class LoadBreakSwitch
(
    override val sup: ProtectedSwitch
)
extends
    Element
{
    def this () = { this (null) }
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:LoadBreakSwitch rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:LoadBreakSwitch>\n"
    }
}

object LoadBreakSwitch
extends
    Parseable[LoadBreakSwitch]
{
    def parse (context: Context): LoadBreakSwitch =
    {
        LoadBreakSwitch(
            ProtectedSwitch.parse (context)
        )
    }
}

/**
 * This class represents the zero sequence line mutual coupling.
 * @param sup Reference to the superclass object.
 * @param b0ch Zero sequence mutual coupling shunt (charging) susceptance, uniformly distributed, of the entire line section.
 * @param distance11 Distance to the start of the coupled region from the first line's terminal having sequence number equal to 1.
 * @param distance12 Distance to the end of the coupled region from the first line's terminal with sequence number equal to 1.
 * @param distance21 Distance to the start of coupled region from the second line's terminal with sequence number equal to 1.
 * @param distance22 Distance to the end of coupled region from the second line's terminal with sequence number equal to 1.
 * @param g0ch Zero sequence mutual coupling shunt (charging) conductance, uniformly distributed, of the entire line section.
 * @param r0 Zero sequence branch-to-branch mutual impedance coupling, resistance.
 * @param x0 Zero sequence branch-to-branch mutual impedance coupling, reactance.
 * @param First_Terminal The starting terminal for the calculation of distances along the first branch of the mutual coupling.
 *        Normally MutualCoupling would only be used for terminals of AC line segments.  The first and second terminals of a mutual coupling should point to different AC line segments.
 * @param Second_Terminal The starting terminal for the calculation of distances along the second branch of the mutual coupling.
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
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, null) }
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
        sup.export_fields +
        "\t\t<cim:MutualCoupling.b0ch>" + b0ch + "</cim:MutualCoupling.b0ch>\n" +
        "\t\t<cim:MutualCoupling.distance11>" + distance11 + "</cim:MutualCoupling.distance11>\n" +
        "\t\t<cim:MutualCoupling.distance12>" + distance12 + "</cim:MutualCoupling.distance12>\n" +
        "\t\t<cim:MutualCoupling.distance21>" + distance21 + "</cim:MutualCoupling.distance21>\n" +
        "\t\t<cim:MutualCoupling.distance22>" + distance22 + "</cim:MutualCoupling.distance22>\n" +
        "\t\t<cim:MutualCoupling.g0ch>" + g0ch + "</cim:MutualCoupling.g0ch>\n" +
        "\t\t<cim:MutualCoupling.r0>" + r0 + "</cim:MutualCoupling.r0>\n" +
        "\t\t<cim:MutualCoupling.x0>" + x0 + "</cim:MutualCoupling.x0>\n" +
        (if (null != First_Terminal) "\t\t<cim:MutualCoupling.First_Terminal rdf:resource=\"#" + First_Terminal + "\"/>\n" else "") +
        (if (null != Second_Terminal) "\t\t<cim:MutualCoupling.Second_Terminal rdf:resource=\"#" + Second_Terminal + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MutualCoupling rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MutualCoupling>\n"
    }
}

object MutualCoupling
extends
    Parseable[MutualCoupling]
{
    val b0ch: (Context) => String = parse_element (element ("""MutualCoupling.b0ch"""))
    val distance11: (Context) => String = parse_element (element ("""MutualCoupling.distance11"""))
    val distance12: (Context) => String = parse_element (element ("""MutualCoupling.distance12"""))
    val distance21: (Context) => String = parse_element (element ("""MutualCoupling.distance21"""))
    val distance22: (Context) => String = parse_element (element ("""MutualCoupling.distance22"""))
    val g0ch: (Context) => String = parse_element (element ("""MutualCoupling.g0ch"""))
    val r0: (Context) => String = parse_element (element ("""MutualCoupling.r0"""))
    val x0: (Context) => String = parse_element (element ("""MutualCoupling.x0"""))
    val First_Terminal: (Context) => String = parse_attribute (attribute ("""MutualCoupling.First_Terminal"""))
    val Second_Terminal: (Context) => String = parse_attribute (attribute ("""MutualCoupling.Second_Terminal"""))
    def parse (context: Context): MutualCoupling =
    {
        MutualCoupling(
            IdentifiedObject.parse (context),
            toDouble (b0ch (context), context),
            toDouble (distance11 (context), context),
            toDouble (distance12 (context), context),
            toDouble (distance21 (context), context),
            toDouble (distance22 (context), context),
            toDouble (g0ch (context), context),
            toDouble (r0 (context), context),
            toDouble (x0 (context), context),
            First_Terminal (context),
            Second_Terminal (context)
        )
    }
}

/**
 * A non linear shunt compensator has bank or section admittance values that differs.
 * @param sup Reference to the superclass object.
 */
case class NonlinearShuntCompensator
(
    override val sup: ShuntCompensator
)
extends
    Element
{
    def this () = { this (null) }
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:NonlinearShuntCompensator rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:NonlinearShuntCompensator>\n"
    }
}

object NonlinearShuntCompensator
extends
    Parseable[NonlinearShuntCompensator]
{
    def parse (context: Context): NonlinearShuntCompensator =
    {
        NonlinearShuntCompensator(
            ShuntCompensator.parse (context)
        )
    }
}

/**
 * A per phase non linear shunt compensator has bank or section admittance values that differs.
 * @param sup Reference to the superclass object.
 */
case class NonlinearShuntCompensatorPhase
(
    override val sup: ShuntCompensatorPhase
)
extends
    Element
{
    def this () = { this (null) }
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:NonlinearShuntCompensatorPhase rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:NonlinearShuntCompensatorPhase>\n"
    }
}

object NonlinearShuntCompensatorPhase
extends
    Parseable[NonlinearShuntCompensatorPhase]
{
    def parse (context: Context): NonlinearShuntCompensatorPhase =
    {
        NonlinearShuntCompensatorPhase(
            ShuntCompensatorPhase.parse (context)
        )
    }
}

/**
 * A per phase non linear shunt compensator bank or section admittance value.
 * @param sup Reference to the superclass object.
 * @param b Positive sequence shunt (charging) susceptance per section
 * @param g Positive sequence shunt (charging) conductance per section
 * @param sectionNumber The number of the section.
 * @param NonlinearShuntCompensatorPhase Non-linear shunt compensator phase owning this point.
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
    def this () = { this (null, 0.0, 0.0, 0, null) }
    def Element: Element = sup.asInstanceOf[Element]
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
        sup.export_fields +
        "\t\t<cim:NonlinearShuntCompensatorPhasePoint.b>" + b + "</cim:NonlinearShuntCompensatorPhasePoint.b>\n" +
        "\t\t<cim:NonlinearShuntCompensatorPhasePoint.g>" + g + "</cim:NonlinearShuntCompensatorPhasePoint.g>\n" +
        "\t\t<cim:NonlinearShuntCompensatorPhasePoint.sectionNumber>" + sectionNumber + "</cim:NonlinearShuntCompensatorPhasePoint.sectionNumber>\n" +
        (if (null != NonlinearShuntCompensatorPhase) "\t\t<cim:NonlinearShuntCompensatorPhasePoint.NonlinearShuntCompensatorPhase rdf:resource=\"#" + NonlinearShuntCompensatorPhase + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:NonlinearShuntCompensatorPhasePoint rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:NonlinearShuntCompensatorPhasePoint>\n"
    }
}

object NonlinearShuntCompensatorPhasePoint
extends
    Parseable[NonlinearShuntCompensatorPhasePoint]
{
    val b: (Context) => String = parse_element (element ("""NonlinearShuntCompensatorPhasePoint.b"""))
    val g: (Context) => String = parse_element (element ("""NonlinearShuntCompensatorPhasePoint.g"""))
    val sectionNumber: (Context) => String = parse_element (element ("""NonlinearShuntCompensatorPhasePoint.sectionNumber"""))
    val NonlinearShuntCompensatorPhase: (Context) => String = parse_attribute (attribute ("""NonlinearShuntCompensatorPhasePoint.NonlinearShuntCompensatorPhase"""))
    def parse (context: Context): NonlinearShuntCompensatorPhasePoint =
    {
        NonlinearShuntCompensatorPhasePoint(
            BasicElement.parse (context),
            toDouble (b (context), context),
            toDouble (g (context), context),
            toInteger (sectionNumber (context), context),
            NonlinearShuntCompensatorPhase (context)
        )
    }
}

/**
 * A non linear shunt compensator bank or section admittance value.
 * @param sup Reference to the superclass object.
 * @param b Positive sequence shunt (charging) susceptance per section
 * @param b0 Zero sequence shunt (charging) susceptance per section
 * @param g Positive sequence shunt (charging) conductance per section
 * @param g0 Zero sequence shunt (charging) conductance per section
 * @param sectionNumber The number of the section.
 * @param NonlinearShuntCompensator Non-linear shunt compensator owning this point.
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
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0, null) }
    def Element: Element = sup.asInstanceOf[Element]
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
        sup.export_fields +
        "\t\t<cim:NonlinearShuntCompensatorPoint.b>" + b + "</cim:NonlinearShuntCompensatorPoint.b>\n" +
        "\t\t<cim:NonlinearShuntCompensatorPoint.b0>" + b0 + "</cim:NonlinearShuntCompensatorPoint.b0>\n" +
        "\t\t<cim:NonlinearShuntCompensatorPoint.g>" + g + "</cim:NonlinearShuntCompensatorPoint.g>\n" +
        "\t\t<cim:NonlinearShuntCompensatorPoint.g0>" + g0 + "</cim:NonlinearShuntCompensatorPoint.g0>\n" +
        "\t\t<cim:NonlinearShuntCompensatorPoint.sectionNumber>" + sectionNumber + "</cim:NonlinearShuntCompensatorPoint.sectionNumber>\n" +
        (if (null != NonlinearShuntCompensator) "\t\t<cim:NonlinearShuntCompensatorPoint.NonlinearShuntCompensator rdf:resource=\"#" + NonlinearShuntCompensator + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:NonlinearShuntCompensatorPoint rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:NonlinearShuntCompensatorPoint>\n"
    }
}

object NonlinearShuntCompensatorPoint
extends
    Parseable[NonlinearShuntCompensatorPoint]
{
    val b: (Context) => String = parse_element (element ("""NonlinearShuntCompensatorPoint.b"""))
    val b0: (Context) => String = parse_element (element ("""NonlinearShuntCompensatorPoint.b0"""))
    val g: (Context) => String = parse_element (element ("""NonlinearShuntCompensatorPoint.g"""))
    val g0: (Context) => String = parse_element (element ("""NonlinearShuntCompensatorPoint.g0"""))
    val sectionNumber: (Context) => String = parse_element (element ("""NonlinearShuntCompensatorPoint.sectionNumber"""))
    val NonlinearShuntCompensator: (Context) => String = parse_attribute (attribute ("""NonlinearShuntCompensatorPoint.NonlinearShuntCompensator"""))
    def parse (context: Context): NonlinearShuntCompensatorPoint =
    {
        NonlinearShuntCompensatorPoint(
            BasicElement.parse (context),
            toDouble (b (context), context),
            toDouble (b0 (context), context),
            toDouble (g (context), context),
            toDouble (g0 (context), context),
            toInteger (sectionNumber (context), context),
            NonlinearShuntCompensator (context)
        )
    }
}

/**
 * Common type for per-length impedance electrical catalogues.
 * @param sup Reference to the superclass object.
 */
case class PerLengthImpedance
(
    override val sup: PerLengthLineParameter
)
extends
    Element
{
    def this () = { this (null) }
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:PerLengthImpedance rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PerLengthImpedance>\n"
    }
}

object PerLengthImpedance
extends
    Parseable[PerLengthImpedance]
{
    def parse (context: Context): PerLengthImpedance =
    {
        PerLengthImpedance(
            PerLengthLineParameter.parse (context)
        )
    }
}

/**
 * Common type for per-length electrical catalogues describing line parameters.
 * @param sup Reference to the superclass object.
 * @param WireSpacingInfo Wire spacing datasheet used to calculate this per-length parameter.
 */
case class PerLengthLineParameter
(
    override val sup: IdentifiedObject,
    WireSpacingInfo: String
)
extends
    Element
{
    def this () = { this (null, null) }
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
        sup.export_fields +
        (if (null != WireSpacingInfo) "\t\t<cim:PerLengthLineParameter.WireSpacingInfo rdf:resource=\"#" + WireSpacingInfo + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:PerLengthLineParameter rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PerLengthLineParameter>\n"
    }
}

object PerLengthLineParameter
extends
    Parseable[PerLengthLineParameter]
{
    val WireSpacingInfo: (Context) => String = parse_attribute (attribute ("""PerLengthLineParameter.WireSpacingInfo"""))
    def parse (context: Context): PerLengthLineParameter =
    {
        PerLengthLineParameter(
            IdentifiedObject.parse (context),
            WireSpacingInfo (context)
        )
    }
}

/**
 * Impedance and admittance parameters per unit length for n-wire unbalanced lines, in matrix form.
 * @param sup Reference to the superclass object.
 * @param conductorCount Number of phase, neutral, and other wires retained.
 *        Constrains the number of matrix elements and the phase codes that can be used with this matrix.
 */
case class PerLengthPhaseImpedance
(
    override val sup: PerLengthImpedance,
    conductorCount: Int
)
extends
    Element
{
    def this () = { this (null, 0) }
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
        sup.export_fields +
        "\t\t<cim:PerLengthPhaseImpedance.conductorCount>" + conductorCount + "</cim:PerLengthPhaseImpedance.conductorCount>\n"
    }
    override def export: String =
    {
        "\t<cim:PerLengthPhaseImpedance rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PerLengthPhaseImpedance>\n"
    }
}

object PerLengthPhaseImpedance
extends
    Parseable[PerLengthPhaseImpedance]
{
    val conductorCount: (Context) => String = parse_element (element ("""PerLengthPhaseImpedance.conductorCount"""))
    def parse (context: Context): PerLengthPhaseImpedance =
    {
        PerLengthPhaseImpedance(
            PerLengthImpedance.parse (context),
            toInteger (conductorCount (context), context)
        )
    }
}

/**
 * Sequence impedance and admittance parameters per unit length, for transposed lines of 1, 2, or 3 phases.
 * For 1-phase lines, define x=x0=xself. For 2-phase lines, define x=xs-xm and x0=xs+xm.
 * @param sup Reference to the superclass object.
 * @param b0ch Zero sequence shunt (charging) susceptance, per unit of length.
 * @param bch Positive sequence shunt (charging) susceptance, per unit of length.
 * @param g0ch Zero sequence shunt (charging) conductance, per unit of length.
 * @param gch Positive sequence shunt (charging) conductance, per unit of length.
 * @param r Positive sequence series resistance, per unit of length.
 * @param r0 Zero sequence series resistance, per unit of length.
 * @param x Positive sequence series reactance, per unit of length.
 * @param x0 Zero sequence series reactance, per unit of length.
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
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
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
        sup.export_fields +
        "\t\t<cim:PerLengthSequenceImpedance.b0ch>" + b0ch + "</cim:PerLengthSequenceImpedance.b0ch>\n" +
        "\t\t<cim:PerLengthSequenceImpedance.bch>" + bch + "</cim:PerLengthSequenceImpedance.bch>\n" +
        "\t\t<cim:PerLengthSequenceImpedance.g0ch>" + g0ch + "</cim:PerLengthSequenceImpedance.g0ch>\n" +
        "\t\t<cim:PerLengthSequenceImpedance.gch>" + gch + "</cim:PerLengthSequenceImpedance.gch>\n" +
        "\t\t<cim:PerLengthSequenceImpedance.r>" + r + "</cim:PerLengthSequenceImpedance.r>\n" +
        "\t\t<cim:PerLengthSequenceImpedance.r0>" + r0 + "</cim:PerLengthSequenceImpedance.r0>\n" +
        "\t\t<cim:PerLengthSequenceImpedance.x>" + x + "</cim:PerLengthSequenceImpedance.x>\n" +
        "\t\t<cim:PerLengthSequenceImpedance.x0>" + x0 + "</cim:PerLengthSequenceImpedance.x0>\n"
    }
    override def export: String =
    {
        "\t<cim:PerLengthSequenceImpedance rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PerLengthSequenceImpedance>\n"
    }
}

object PerLengthSequenceImpedance
extends
    Parseable[PerLengthSequenceImpedance]
{
    val b0ch: (Context) => String = parse_element (element ("""PerLengthSequenceImpedance.b0ch"""))
    val bch: (Context) => String = parse_element (element ("""PerLengthSequenceImpedance.bch"""))
    val g0ch: (Context) => String = parse_element (element ("""PerLengthSequenceImpedance.g0ch"""))
    val gch: (Context) => String = parse_element (element ("""PerLengthSequenceImpedance.gch"""))
    val r: (Context) => String = parse_element (element ("""PerLengthSequenceImpedance.r"""))
    val r0: (Context) => String = parse_element (element ("""PerLengthSequenceImpedance.r0"""))
    val x: (Context) => String = parse_element (element ("""PerLengthSequenceImpedance.x"""))
    val x0: (Context) => String = parse_element (element ("""PerLengthSequenceImpedance.x0"""))
    def parse (context: Context): PerLengthSequenceImpedance =
    {
        PerLengthSequenceImpedance(
            PerLengthImpedance.parse (context),
            toDouble (b0ch (context), context),
            toDouble (bch (context), context),
            toDouble (g0ch (context), context),
            toDouble (gch (context), context),
            toDouble (r (context), context),
            toDouble (r0 (context), context),
            toDouble (x (context), context),
            toDouble (x0 (context), context)
        )
    }
}

/**
 * A tunable impedance device normally used to offset line charging during single line faults in an ungrounded section of network.
 * @param sup Reference to the superclass object.
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
    def this () = { this (null, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
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
        sup.export_fields +
        (if (null != mode) "\t\t<cim:PetersenCoil.mode rdf:resource=\"#" + mode + "\"/>\n" else "") +
        "\t\t<cim:PetersenCoil.nominalU>" + nominalU + "</cim:PetersenCoil.nominalU>\n" +
        "\t\t<cim:PetersenCoil.offsetCurrent>" + offsetCurrent + "</cim:PetersenCoil.offsetCurrent>\n" +
        "\t\t<cim:PetersenCoil.positionCurrent>" + positionCurrent + "</cim:PetersenCoil.positionCurrent>\n" +
        "\t\t<cim:PetersenCoil.xGroundMax>" + xGroundMax + "</cim:PetersenCoil.xGroundMax>\n" +
        "\t\t<cim:PetersenCoil.xGroundMin>" + xGroundMin + "</cim:PetersenCoil.xGroundMin>\n" +
        "\t\t<cim:PetersenCoil.xGroundNominal>" + xGroundNominal + "</cim:PetersenCoil.xGroundNominal>\n"
    }
    override def export: String =
    {
        "\t<cim:PetersenCoil rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PetersenCoil>\n"
    }
}

object PetersenCoil
extends
    Parseable[PetersenCoil]
{
    val mode: (Context) => String = parse_attribute (attribute ("""PetersenCoil.mode"""))
    val nominalU: (Context) => String = parse_element (element ("""PetersenCoil.nominalU"""))
    val offsetCurrent: (Context) => String = parse_element (element ("""PetersenCoil.offsetCurrent"""))
    val positionCurrent: (Context) => String = parse_element (element ("""PetersenCoil.positionCurrent"""))
    val xGroundMax: (Context) => String = parse_element (element ("""PetersenCoil.xGroundMax"""))
    val xGroundMin: (Context) => String = parse_element (element ("""PetersenCoil.xGroundMin"""))
    val xGroundNominal: (Context) => String = parse_element (element ("""PetersenCoil.xGroundNominal"""))
    def parse (context: Context): PetersenCoil =
    {
        PetersenCoil(
            EarthFaultCompensator.parse (context),
            mode (context),
            toDouble (nominalU (context), context),
            toDouble (offsetCurrent (context), context),
            toDouble (positionCurrent (context), context),
            toDouble (xGroundMax (context), context),
            toDouble (xGroundMin (context), context),
            toDouble (xGroundNominal (context), context)
        )
    }
}

/**
 * The mode of operation for a Petersen coil.
 * @param sup Reference to the superclass object.
 * @param automaticPositioning Automatic positioning.
 * @param fixed Fixed position.
 * @param manual Manual positioning.
 */
case class PetersenCoilModeKind
(
    override val sup: BasicElement,
    automaticPositioning: String,
    fixed: String,
    manual: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[PetersenCoilModeKind] }
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
        (if (null != automaticPositioning) "\t\t<cim:PetersenCoilModeKind.automaticPositioning rdf:resource=\"#" + automaticPositioning + "\"/>\n" else "") +
        (if (null != fixed) "\t\t<cim:PetersenCoilModeKind.fixed rdf:resource=\"#" + fixed + "\"/>\n" else "") +
        (if (null != manual) "\t\t<cim:PetersenCoilModeKind.manual rdf:resource=\"#" + manual + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:PetersenCoilModeKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PetersenCoilModeKind>\n"
    }
}

object PetersenCoilModeKind
extends
    Parseable[PetersenCoilModeKind]
{
    val automaticPositioning: (Context) => String = parse_attribute (attribute ("""PetersenCoilModeKind.automaticPositioning"""))
    val fixed: (Context) => String = parse_attribute (attribute ("""PetersenCoilModeKind.fixed"""))
    val manual: (Context) => String = parse_attribute (attribute ("""PetersenCoilModeKind.manual"""))
    def parse (context: Context): PetersenCoilModeKind =
    {
        PetersenCoilModeKind(
            BasicElement.parse (context),
            automaticPositioning (context),
            fixed (context),
            manual (context)
        )
    }
}

/**
 * Triplet of resistance, reactance, and susceptance matrix element values.
 * @param sup Reference to the superclass object.
 * @param b Susceptance matrix element value, per length of unit.
 * @param r Resistance matrix element value, per length of unit.
 * @param sequenceNumber Column-wise element index, assuming a symmetrical matrix.
 *        Ranges from 1 to N + N*(N-1)/2.
 * @param x Reactance matrix element value, per length of unit.
 * @param PhaseImpedance Conductor phase impedance to which this data belongs.
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
    def this () = { this (null, 0.0, 0.0, 0, 0.0, null) }
    def Element: Element = sup.asInstanceOf[Element]
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
        sup.export_fields +
        "\t\t<cim:PhaseImpedanceData.b>" + b + "</cim:PhaseImpedanceData.b>\n" +
        "\t\t<cim:PhaseImpedanceData.r>" + r + "</cim:PhaseImpedanceData.r>\n" +
        "\t\t<cim:PhaseImpedanceData.sequenceNumber>" + sequenceNumber + "</cim:PhaseImpedanceData.sequenceNumber>\n" +
        "\t\t<cim:PhaseImpedanceData.x>" + x + "</cim:PhaseImpedanceData.x>\n" +
        (if (null != PhaseImpedance) "\t\t<cim:PhaseImpedanceData.PhaseImpedance rdf:resource=\"#" + PhaseImpedance + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:PhaseImpedanceData rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PhaseImpedanceData>\n"
    }
}

object PhaseImpedanceData
extends
    Parseable[PhaseImpedanceData]
{
    val b: (Context) => String = parse_element (element ("""PhaseImpedanceData.b"""))
    val r: (Context) => String = parse_element (element ("""PhaseImpedanceData.r"""))
    val sequenceNumber: (Context) => String = parse_element (element ("""PhaseImpedanceData.sequenceNumber"""))
    val x: (Context) => String = parse_element (element ("""PhaseImpedanceData.x"""))
    val PhaseImpedance: (Context) => String = parse_attribute (attribute ("""PhaseImpedanceData.PhaseImpedance"""))
    def parse (context: Context): PhaseImpedanceData =
    {
        PhaseImpedanceData(
            BasicElement.parse (context),
            toDouble (b (context), context),
            toDouble (r (context), context),
            toInteger (sequenceNumber (context), context),
            toDouble (x (context), context),
            PhaseImpedance (context)
        )
    }
}

/**
 * The configuration of phase connections for a single terminal device such as a load or capactitor.
 * @param sup Reference to the superclass object.
 * @param D Delta connection.
 * @param I Independent winding, for single-phase connections.
 * @param Y Wye connection.
 * @param Yn Wye, with neutral brought out for grounding.
 */
case class PhaseShuntConnectionKind
(
    override val sup: BasicElement,
    D: String,
    I: String,
    Y: String,
    Yn: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[PhaseShuntConnectionKind] }
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
        (if (null != D) "\t\t<cim:PhaseShuntConnectionKind.D rdf:resource=\"#" + D + "\"/>\n" else "") +
        (if (null != I) "\t\t<cim:PhaseShuntConnectionKind.I rdf:resource=\"#" + I + "\"/>\n" else "") +
        (if (null != Y) "\t\t<cim:PhaseShuntConnectionKind.Y rdf:resource=\"#" + Y + "\"/>\n" else "") +
        (if (null != Yn) "\t\t<cim:PhaseShuntConnectionKind.Yn rdf:resource=\"#" + Yn + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:PhaseShuntConnectionKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PhaseShuntConnectionKind>\n"
    }
}

object PhaseShuntConnectionKind
extends
    Parseable[PhaseShuntConnectionKind]
{
    val D: (Context) => String = parse_attribute (attribute ("""PhaseShuntConnectionKind.D"""))
    val I: (Context) => String = parse_attribute (attribute ("""PhaseShuntConnectionKind.I"""))
    val Y: (Context) => String = parse_attribute (attribute ("""PhaseShuntConnectionKind.Y"""))
    val Yn: (Context) => String = parse_attribute (attribute ("""PhaseShuntConnectionKind.Yn"""))
    def parse (context: Context): PhaseShuntConnectionKind =
    {
        PhaseShuntConnectionKind(
            BasicElement.parse (context),
            D (context),
            I (context),
            Y (context),
            Yn (context)
        )
    }
}

/**
 * A transformer phase shifting tap model that controls the phase angle difference across the power transformer and potentially the active power flow through the power transformer.
 * This phase tap model may also impact the voltage magnitude.
 * @param sup Reference to the superclass object.
 * @param TransformerEnd Transformer end to which this phase tap changer belongs.
 */
case class PhaseTapChanger
(
    override val sup: TapChanger,
    TransformerEnd: String
)
extends
    Element
{
    def this () = { this (null, null) }
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
        sup.export_fields +
        (if (null != TransformerEnd) "\t\t<cim:PhaseTapChanger.TransformerEnd rdf:resource=\"#" + TransformerEnd + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:PhaseTapChanger rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PhaseTapChanger>\n"
    }
}

object PhaseTapChanger
extends
    Parseable[PhaseTapChanger]
{
    val TransformerEnd: (Context) => String = parse_attribute (attribute ("""PhaseTapChanger.TransformerEnd"""))
    def parse (context: Context): PhaseTapChanger =
    {
        PhaseTapChanger(
            TapChanger.parse (context),
            TransformerEnd (context)
        )
    }
}

/**
 * Describes the tap model for an asymmetrical phase shifting transformer in which the difference voltage vector adds to the primary side voltage.
 * The angle between the primary side voltage and the difference voltage is named the winding connection angle. The phase shift depends on both the difference voltage magnitude and the winding connection angle.
 * @param sup Reference to the superclass object.
 * @param windingConnectionAngle The phase angle between the in-phase winding and the out-of -phase winding used for creating phase shift.
 *        The out-of-phase winding produces what is known as the difference voltage.  Setting this angle to 90 degrees is not the same as a symmemtrical transformer.
 */
case class PhaseTapChangerAsymmetrical
(
    override val sup: PhaseTapChangerNonLinear,
    windingConnectionAngle: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
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
        sup.export_fields +
        "\t\t<cim:PhaseTapChangerAsymmetrical.windingConnectionAngle>" + windingConnectionAngle + "</cim:PhaseTapChangerAsymmetrical.windingConnectionAngle>\n"
    }
    override def export: String =
    {
        "\t<cim:PhaseTapChangerAsymmetrical rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PhaseTapChangerAsymmetrical>\n"
    }
}

object PhaseTapChangerAsymmetrical
extends
    Parseable[PhaseTapChangerAsymmetrical]
{
    val windingConnectionAngle: (Context) => String = parse_element (element ("""PhaseTapChangerAsymmetrical.windingConnectionAngle"""))
    def parse (context: Context): PhaseTapChangerAsymmetrical =
    {
        PhaseTapChangerAsymmetrical(
            PhaseTapChangerNonLinear.parse (context),
            toDouble (windingConnectionAngle (context), context)
        )
    }
}

/**
 * Describes a tap changer with a linear relation between the tap step and the phase angle difference across the transformer.
 * This is a mathematical model that is an approximation of a real phase tap changer.
 * @param sup Reference to the superclass object.
 * @param stepPhaseShiftIncrement Phase shift per step position.
 *        A positive value indicates a positive phase shift from the winding where the tap is located to the other winding (for a two-winding transformer).
 * @param xMax The reactance depend on the tap position according to a "u" shaped curve.
 *        The maximum reactance (xMax) appear at the low and high tap positions.
 * @param xMin The reactance depend on the tap position according to a "u" shaped curve.
 *        The minimum reactance (xMin) appear at the mid tap position.
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
    def this () = { this (null, 0.0, 0.0, 0.0) }
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
        sup.export_fields +
        "\t\t<cim:PhaseTapChangerLinear.stepPhaseShiftIncrement>" + stepPhaseShiftIncrement + "</cim:PhaseTapChangerLinear.stepPhaseShiftIncrement>\n" +
        "\t\t<cim:PhaseTapChangerLinear.xMax>" + xMax + "</cim:PhaseTapChangerLinear.xMax>\n" +
        "\t\t<cim:PhaseTapChangerLinear.xMin>" + xMin + "</cim:PhaseTapChangerLinear.xMin>\n"
    }
    override def export: String =
    {
        "\t<cim:PhaseTapChangerLinear rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PhaseTapChangerLinear>\n"
    }
}

object PhaseTapChangerLinear
extends
    Parseable[PhaseTapChangerLinear]
{
    val stepPhaseShiftIncrement: (Context) => String = parse_element (element ("""PhaseTapChangerLinear.stepPhaseShiftIncrement"""))
    val xMax: (Context) => String = parse_element (element ("""PhaseTapChangerLinear.xMax"""))
    val xMin: (Context) => String = parse_element (element ("""PhaseTapChangerLinear.xMin"""))
    def parse (context: Context): PhaseTapChangerLinear =
    {
        PhaseTapChangerLinear(
            PhaseTapChanger.parse (context),
            toDouble (stepPhaseShiftIncrement (context), context),
            toDouble (xMax (context), context),
            toDouble (xMin (context), context)
        )
    }
}

/**
 * The non-linear phase tap changer describes the non-linear behavior of a phase tap changer.
 * This is a base class for the symmetrical and asymmetrical phase tap changer models. The details of these models can be found in the IEC 61970-301 document.
 * @param sup Reference to the superclass object.
 * @param voltageStepIncrement The voltage step increment on the out of phase winding specified in percent of nominal voltage of the transformer end.
 * @param xMax The reactance depend on the tap position according to a "u" shaped curve.
 *        The maximum reactance (xMax) appear at the low and high tap positions.
 * @param xMin The reactance depend on the tap position according to a "u" shaped curve.
 *        The minimum reactance (xMin) appear at the mid tap position.
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
    def this () = { this (null, 0.0, 0.0, 0.0) }
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
        sup.export_fields +
        "\t\t<cim:PhaseTapChangerNonLinear.voltageStepIncrement>" + voltageStepIncrement + "</cim:PhaseTapChangerNonLinear.voltageStepIncrement>\n" +
        "\t\t<cim:PhaseTapChangerNonLinear.xMax>" + xMax + "</cim:PhaseTapChangerNonLinear.xMax>\n" +
        "\t\t<cim:PhaseTapChangerNonLinear.xMin>" + xMin + "</cim:PhaseTapChangerNonLinear.xMin>\n"
    }
    override def export: String =
    {
        "\t<cim:PhaseTapChangerNonLinear rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PhaseTapChangerNonLinear>\n"
    }
}

object PhaseTapChangerNonLinear
extends
    Parseable[PhaseTapChangerNonLinear]
{
    val voltageStepIncrement: (Context) => String = parse_element (element ("""PhaseTapChangerNonLinear.voltageStepIncrement"""))
    val xMax: (Context) => String = parse_element (element ("""PhaseTapChangerNonLinear.xMax"""))
    val xMin: (Context) => String = parse_element (element ("""PhaseTapChangerNonLinear.xMin"""))
    def parse (context: Context): PhaseTapChangerNonLinear =
    {
        PhaseTapChangerNonLinear(
            PhaseTapChanger.parse (context),
            toDouble (voltageStepIncrement (context), context),
            toDouble (xMax (context), context),
            toDouble (xMin (context), context)
        )
    }
}

/**
 * Describes a symmetrical phase shifting transformer tap model in which the secondary side voltage magnitude is the same as at the primary side.
 * The difference voltage magnitude is the base in an equal-sided triangle where the sides corresponds to the primary and secondary voltages. The phase angle difference corresponds to the top angle and can be expressed as twice the arctangent of half the total difference voltage.
 * @param sup Reference to the superclass object.
 */
case class PhaseTapChangerSymmetrical
(
    override val sup: PhaseTapChangerNonLinear
)
extends
    Element
{
    def this () = { this (null) }
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:PhaseTapChangerSymmetrical rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PhaseTapChangerSymmetrical>\n"
    }
}

object PhaseTapChangerSymmetrical
extends
    Parseable[PhaseTapChangerSymmetrical]
{
    def parse (context: Context): PhaseTapChangerSymmetrical =
    {
        PhaseTapChangerSymmetrical(
            PhaseTapChangerNonLinear.parse (context)
        )
    }
}

/**
 * Describes a tabular curve for how the phase angle difference and impedance varies with the tap step.
 * @param sup Reference to the superclass object.
 */
case class PhaseTapChangerTable
(
    override val sup: IdentifiedObject
)
extends
    Element
{
    def this () = { this (null) }
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:PhaseTapChangerTable rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PhaseTapChangerTable>\n"
    }
}

object PhaseTapChangerTable
extends
    Parseable[PhaseTapChangerTable]
{
    def parse (context: Context): PhaseTapChangerTable =
    {
        PhaseTapChangerTable(
            IdentifiedObject.parse (context)
        )
    }
}

/**
 * Describes each tap step in the phase tap changer tabular curve.
 * @param sup Reference to the superclass object.
 * @param angle The angle difference in degrees.
 * @param PhaseTapChangerTable The table of this point.
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
    def this () = { this (null, 0.0, null) }
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
        sup.export_fields +
        "\t\t<cim:PhaseTapChangerTablePoint.angle>" + angle + "</cim:PhaseTapChangerTablePoint.angle>\n" +
        (if (null != PhaseTapChangerTable) "\t\t<cim:PhaseTapChangerTablePoint.PhaseTapChangerTable rdf:resource=\"#" + PhaseTapChangerTable + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:PhaseTapChangerTablePoint rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PhaseTapChangerTablePoint>\n"
    }
}

object PhaseTapChangerTablePoint
extends
    Parseable[PhaseTapChangerTablePoint]
{
    val angle: (Context) => String = parse_element (element ("""PhaseTapChangerTablePoint.angle"""))
    val PhaseTapChangerTable: (Context) => String = parse_attribute (attribute ("""PhaseTapChangerTablePoint.PhaseTapChangerTable"""))
    def parse (context: Context): PhaseTapChangerTablePoint =
    {
        PhaseTapChangerTablePoint(
            TapChangerTablePoint.parse (context),
            toDouble (angle (context), context),
            PhaseTapChangerTable (context)
        )
    }
}

case class PhaseTapChangerTabular
(
    override val sup: PhaseTapChanger,
    PhaseTapChangerTable: String
)
extends
    Element
{
    def this () = { this (null, null) }
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
        sup.export_fields +
        (if (null != PhaseTapChangerTable) "\t\t<cim:PhaseTapChangerTabular.PhaseTapChangerTable rdf:resource=\"#" + PhaseTapChangerTable + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:PhaseTapChangerTabular rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PhaseTapChangerTabular>\n"
    }
}

object PhaseTapChangerTabular
extends
    Parseable[PhaseTapChangerTabular]
{
    val PhaseTapChangerTable: (Context) => String = parse_attribute (attribute ("""PhaseTapChangerTabular.PhaseTapChangerTable"""))
    def parse (context: Context): PhaseTapChangerTabular =
    {
        PhaseTapChangerTabular(
            PhaseTapChanger.parse (context),
            PhaseTapChangerTable (context)
        )
    }
}

/**
 * A Plant is a collection of equipment for purposes of generation.
 * @param sup Reference to the superclass object.
 */
case class Plant
(
    override val sup: EquipmentContainer
)
extends
    Element
{
    def this () = { this (null) }
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:Plant rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Plant>\n"
    }
}

object Plant
extends
    Parseable[Plant]
{
    def parse (context: Context): Plant =
    {
        Plant(
            EquipmentContainer.parse (context)
        )
    }
}

/**
 * An electrical device consisting of  two or more coupled windings, with or without a magnetic core, for introducing mutual coupling between electric circuits.
 * Transformers can be used to control voltage and phase shift (active power flow).
 * @param sup Reference to the superclass object.
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
    vectorGroup: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, false, false, null) }
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
        sup.export_fields +
        "\t\t<cim:PowerTransformer.beforeShCircuitHighestOperatingCurrent>" + beforeShCircuitHighestOperatingCurrent + "</cim:PowerTransformer.beforeShCircuitHighestOperatingCurrent>\n" +
        "\t\t<cim:PowerTransformer.beforeShCircuitHighestOperatingVoltage>" + beforeShCircuitHighestOperatingVoltage + "</cim:PowerTransformer.beforeShCircuitHighestOperatingVoltage>\n" +
        "\t\t<cim:PowerTransformer.beforeShortCircuitAnglePf>" + beforeShortCircuitAnglePf + "</cim:PowerTransformer.beforeShortCircuitAnglePf>\n" +
        "\t\t<cim:PowerTransformer.highSideMinOperatingU>" + highSideMinOperatingU + "</cim:PowerTransformer.highSideMinOperatingU>\n" +
        "\t\t<cim:PowerTransformer.isPartOfGeneratorUnit>" + isPartOfGeneratorUnit + "</cim:PowerTransformer.isPartOfGeneratorUnit>\n" +
        "\t\t<cim:PowerTransformer.operationalValuesConsidered>" + operationalValuesConsidered + "</cim:PowerTransformer.operationalValuesConsidered>\n" +
        (if (null != vectorGroup) "\t\t<cim:PowerTransformer.vectorGroup>" + vectorGroup + "</cim:PowerTransformer.vectorGroup>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:PowerTransformer rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PowerTransformer>\n"
    }
}

object PowerTransformer
extends
    Parseable[PowerTransformer]
{
    val beforeShCircuitHighestOperatingCurrent: (Context) => String = parse_element (element ("""PowerTransformer.beforeShCircuitHighestOperatingCurrent"""))
    val beforeShCircuitHighestOperatingVoltage: (Context) => String = parse_element (element ("""PowerTransformer.beforeShCircuitHighestOperatingVoltage"""))
    val beforeShortCircuitAnglePf: (Context) => String = parse_element (element ("""PowerTransformer.beforeShortCircuitAnglePf"""))
    val highSideMinOperatingU: (Context) => String = parse_element (element ("""PowerTransformer.highSideMinOperatingU"""))
    val isPartOfGeneratorUnit: (Context) => String = parse_element (element ("""PowerTransformer.isPartOfGeneratorUnit"""))
    val operationalValuesConsidered: (Context) => String = parse_element (element ("""PowerTransformer.operationalValuesConsidered"""))
    val vectorGroup: (Context) => String = parse_element (element ("""PowerTransformer.vectorGroup"""))
    def parse (context: Context): PowerTransformer =
    {
        PowerTransformer(
            ConductingEquipment.parse (context),
            toDouble (beforeShCircuitHighestOperatingCurrent (context), context),
            toDouble (beforeShCircuitHighestOperatingVoltage (context), context),
            toDouble (beforeShortCircuitAnglePf (context), context),
            toDouble (highSideMinOperatingU (context), context),
            toBoolean (isPartOfGeneratorUnit (context), context),
            toBoolean (operationalValuesConsidered (context), context),
            vectorGroup (context)
        )
    }
}

/**
 * A PowerTransformerEnd is associated with each Terminal of a PowerTransformer.
 * The impedance values r, r0, x, and x0 of a PowerTransformerEnd represents a star equivalent as follows
 * @param sup Reference to the superclass object.
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
 * @param PowerTransformer The power transformer of this power transformer end.
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
    def this () = { this (null, 0.0, 0.0, null, 0.0, 0.0, 0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null) }
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
        sup.export_fields +
        "\t\t<cim:PowerTransformerEnd.b>" + b + "</cim:PowerTransformerEnd.b>\n" +
        "\t\t<cim:PowerTransformerEnd.b0>" + b0 + "</cim:PowerTransformerEnd.b0>\n" +
        (if (null != connectionKind) "\t\t<cim:PowerTransformerEnd.connectionKind rdf:resource=\"#" + connectionKind + "\"/>\n" else "") +
        "\t\t<cim:PowerTransformerEnd.g>" + g + "</cim:PowerTransformerEnd.g>\n" +
        "\t\t<cim:PowerTransformerEnd.g0>" + g0 + "</cim:PowerTransformerEnd.g0>\n" +
        "\t\t<cim:PowerTransformerEnd.phaseAngleClock>" + phaseAngleClock + "</cim:PowerTransformerEnd.phaseAngleClock>\n" +
        "\t\t<cim:PowerTransformerEnd.r>" + r + "</cim:PowerTransformerEnd.r>\n" +
        "\t\t<cim:PowerTransformerEnd.r0>" + r0 + "</cim:PowerTransformerEnd.r0>\n" +
        "\t\t<cim:PowerTransformerEnd.ratedS>" + ratedS + "</cim:PowerTransformerEnd.ratedS>\n" +
        "\t\t<cim:PowerTransformerEnd.ratedU>" + ratedU + "</cim:PowerTransformerEnd.ratedU>\n" +
        "\t\t<cim:PowerTransformerEnd.x>" + x + "</cim:PowerTransformerEnd.x>\n" +
        "\t\t<cim:PowerTransformerEnd.x0>" + x0 + "</cim:PowerTransformerEnd.x0>\n" +
        (if (null != PowerTransformer) "\t\t<cim:PowerTransformerEnd.PowerTransformer rdf:resource=\"#" + PowerTransformer + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:PowerTransformerEnd rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PowerTransformerEnd>\n"
    }
}

object PowerTransformerEnd
extends
    Parseable[PowerTransformerEnd]
{
    val b: (Context) => String = parse_element (element ("""PowerTransformerEnd.b"""))
    val b0: (Context) => String = parse_element (element ("""PowerTransformerEnd.b0"""))
    val connectionKind: (Context) => String = parse_attribute (attribute ("""PowerTransformerEnd.connectionKind"""))
    val g: (Context) => String = parse_element (element ("""PowerTransformerEnd.g"""))
    val g0: (Context) => String = parse_element (element ("""PowerTransformerEnd.g0"""))
    val phaseAngleClock: (Context) => String = parse_element (element ("""PowerTransformerEnd.phaseAngleClock"""))
    val r: (Context) => String = parse_element (element ("""PowerTransformerEnd.r"""))
    val r0: (Context) => String = parse_element (element ("""PowerTransformerEnd.r0"""))
    val ratedS: (Context) => String = parse_element (element ("""PowerTransformerEnd.ratedS"""))
    val ratedU: (Context) => String = parse_element (element ("""PowerTransformerEnd.ratedU"""))
    val x: (Context) => String = parse_element (element ("""PowerTransformerEnd.x"""))
    val x0: (Context) => String = parse_element (element ("""PowerTransformerEnd.x0"""))
    val PowerTransformer: (Context) => String = parse_attribute (attribute ("""PowerTransformerEnd.PowerTransformer"""))
    def parse (context: Context): PowerTransformerEnd =
    {
        PowerTransformerEnd(
            TransformerEnd.parse (context),
            toDouble (b (context), context),
            toDouble (b0 (context), context),
            connectionKind (context),
            toDouble (g (context), context),
            toDouble (g0 (context), context),
            toInteger (phaseAngleClock (context), context),
            toDouble (r (context), context),
            toDouble (r0 (context), context),
            toDouble (ratedS (context), context),
            toDouble (ratedU (context), context),
            toDouble (x (context), context),
            toDouble (x0 (context), context),
            PowerTransformer (context)
        )
    }
}

/**
 * A ProtectedSwitch is a switching device that can be operated by ProtectionEquipment.
 * @param sup Reference to the superclass object.
 * @param breakingCapacity The maximum fault current a breaking device can break safely under prescribed conditions of use.
 */
case class ProtectedSwitch
(
    override val sup: Switch,
    breakingCapacity: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
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
        sup.export_fields +
        "\t\t<cim:ProtectedSwitch.breakingCapacity>" + breakingCapacity + "</cim:ProtectedSwitch.breakingCapacity>\n"
    }
    override def export: String =
    {
        "\t<cim:ProtectedSwitch rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ProtectedSwitch>\n"
    }
}

object ProtectedSwitch
extends
    Parseable[ProtectedSwitch]
{
    val breakingCapacity: (Context) => String = parse_element (element ("""ProtectedSwitch.breakingCapacity"""))
    def parse (context: Context): ProtectedSwitch =
    {
        ProtectedSwitch(
            Switch.parse (context),
            toDouble (breakingCapacity (context), context)
        )
    }
}

/**
 * A tap changer that changes the voltage ratio impacting the voltage magnitude but not the phase angle across the transformer.
 * @param sup Reference to the superclass object.
 * @param stepVoltageIncrement Tap step increment, in per cent of nominal voltage, per step position.
 * @param tculControlMode Specifies the regulation control mode (voltage or reactive) of the RatioTapChanger.
 * @param RatioTapChangerTable The tap ratio table for this ratio  tap changer.
 * @param TransformerEnd Transformer end to which this ratio tap changer belongs.
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
    def this () = { this (null, 0.0, null, null, null) }
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
        sup.export_fields +
        "\t\t<cim:RatioTapChanger.stepVoltageIncrement>" + stepVoltageIncrement + "</cim:RatioTapChanger.stepVoltageIncrement>\n" +
        (if (null != tculControlMode) "\t\t<cim:RatioTapChanger.tculControlMode rdf:resource=\"#" + tculControlMode + "\"/>\n" else "") +
        (if (null != RatioTapChangerTable) "\t\t<cim:RatioTapChanger.RatioTapChangerTable rdf:resource=\"#" + RatioTapChangerTable + "\"/>\n" else "") +
        (if (null != TransformerEnd) "\t\t<cim:RatioTapChanger.TransformerEnd rdf:resource=\"#" + TransformerEnd + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:RatioTapChanger rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RatioTapChanger>\n"
    }
}

object RatioTapChanger
extends
    Parseable[RatioTapChanger]
{
    val stepVoltageIncrement: (Context) => String = parse_element (element ("""RatioTapChanger.stepVoltageIncrement"""))
    val tculControlMode: (Context) => String = parse_attribute (attribute ("""RatioTapChanger.tculControlMode"""))
    val RatioTapChangerTable: (Context) => String = parse_attribute (attribute ("""RatioTapChanger.RatioTapChangerTable"""))
    val TransformerEnd: (Context) => String = parse_attribute (attribute ("""RatioTapChanger.TransformerEnd"""))
    def parse (context: Context): RatioTapChanger =
    {
        RatioTapChanger(
            TapChanger.parse (context),
            toDouble (stepVoltageIncrement (context), context),
            tculControlMode (context),
            RatioTapChangerTable (context),
            TransformerEnd (context)
        )
    }
}

/**
 * Describes a curve for how the voltage magnitude and impedance varies with the tap step.
 * @param sup Reference to the superclass object.
 */
case class RatioTapChangerTable
(
    override val sup: IdentifiedObject
)
extends
    Element
{
    def this () = { this (null) }
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:RatioTapChangerTable rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RatioTapChangerTable>\n"
    }
}

object RatioTapChangerTable
extends
    Parseable[RatioTapChangerTable]
{
    def parse (context: Context): RatioTapChangerTable =
    {
        RatioTapChangerTable(
            IdentifiedObject.parse (context)
        )
    }
}

/**
 * Describes each tap step in the ratio tap changer tabular curve.
 * @param sup Reference to the superclass object.
 * @param RatioTapChangerTable Table of this point.
 */
case class RatioTapChangerTablePoint
(
    override val sup: TapChangerTablePoint,
    RatioTapChangerTable: String
)
extends
    Element
{
    def this () = { this (null, null) }
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
        sup.export_fields +
        (if (null != RatioTapChangerTable) "\t\t<cim:RatioTapChangerTablePoint.RatioTapChangerTable rdf:resource=\"#" + RatioTapChangerTable + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:RatioTapChangerTablePoint rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RatioTapChangerTablePoint>\n"
    }
}

object RatioTapChangerTablePoint
extends
    Parseable[RatioTapChangerTablePoint]
{
    val RatioTapChangerTable: (Context) => String = parse_attribute (attribute ("""RatioTapChangerTablePoint.RatioTapChangerTable"""))
    def parse (context: Context): RatioTapChangerTablePoint =
    {
        RatioTapChangerTablePoint(
            TapChangerTablePoint.parse (context),
            RatioTapChangerTable (context)
        )
    }
}

/**
 * Reactive power rating envelope versus the synchronous machine's active power, in both the generating and motoring modes.
 * For each active power value there is a corresponding high and low reactive power limit  value. Typically there will be a separate curve for each coolant condition, such as hydrogen pressure.  The Y1 axis values represent reactive minimum and the Y2 axis values represent reactive maximum.
 * @param sup Reference to the superclass object.
 * @param coolantTemperature The machine's coolant temperature (e.g., ambient air or stator circulating water).
 * @param hydrogenPressure The hydrogen coolant pressure
 */
case class ReactiveCapabilityCurve
(
    override val sup: Curve,
    coolantTemperature: Double,
    hydrogenPressure: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0) }
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
        sup.export_fields +
        "\t\t<cim:ReactiveCapabilityCurve.coolantTemperature>" + coolantTemperature + "</cim:ReactiveCapabilityCurve.coolantTemperature>\n" +
        "\t\t<cim:ReactiveCapabilityCurve.hydrogenPressure>" + hydrogenPressure + "</cim:ReactiveCapabilityCurve.hydrogenPressure>\n"
    }
    override def export: String =
    {
        "\t<cim:ReactiveCapabilityCurve rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ReactiveCapabilityCurve>\n"
    }
}

object ReactiveCapabilityCurve
extends
    Parseable[ReactiveCapabilityCurve]
{
    val coolantTemperature: (Context) => String = parse_element (element ("""ReactiveCapabilityCurve.coolantTemperature"""))
    val hydrogenPressure: (Context) => String = parse_element (element ("""ReactiveCapabilityCurve.hydrogenPressure"""))
    def parse (context: Context): ReactiveCapabilityCurve =
    {
        ReactiveCapabilityCurve(
            Curve.parse (context),
            toDouble (coolantTemperature (context), context),
            toDouble (hydrogenPressure (context), context)
        )
    }
}

/**
 * Pole-mounted fault interrupter with built-in phase and ground relays, current transformer (CT), and supplemental controls.
 * @param sup Reference to the superclass object.
 */
case class Recloser
(
    override val sup: ProtectedSwitch
)
extends
    Element
{
    def this () = { this (null) }
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:Recloser rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Recloser>\n"
    }
}

object Recloser
extends
    Parseable[Recloser]
{
    def parse (context: Context): Recloser =
    {
        Recloser(
            ProtectedSwitch.parse (context)
        )
    }
}

/**
 * A type of conducting equipment that can regulate a quantity (i.e. voltage or flow) at a specific point in the network.
 * @param sup Reference to the superclass object.
 * @param controlEnabled Specifies the regulation status of the equipment.
 *        True is regulating, false is not regulating.
 * @param RegulatingControl The regulating control scheme in which this equipment participates.
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
    def this () = { this (null, false, null) }
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
        sup.export_fields +
        "\t\t<cim:RegulatingCondEq.controlEnabled>" + controlEnabled + "</cim:RegulatingCondEq.controlEnabled>\n" +
        (if (null != RegulatingControl) "\t\t<cim:RegulatingCondEq.RegulatingControl rdf:resource=\"#" + RegulatingControl + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:RegulatingCondEq rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RegulatingCondEq>\n"
    }
}

object RegulatingCondEq
extends
    Parseable[RegulatingCondEq]
{
    val controlEnabled: (Context) => String = parse_element (element ("""RegulatingCondEq.controlEnabled"""))
    val RegulatingControl: (Context) => String = parse_attribute (attribute ("""RegulatingCondEq.RegulatingControl"""))
    def parse (context: Context): RegulatingCondEq =
    {
        RegulatingCondEq(
            ConductingEquipment.parse (context),
            toBoolean (controlEnabled (context), context),
            RegulatingControl (context)
        )
    }
}

/**
 * Specifies a set of equipment that works together to control a power system quantity such as voltage or flow.
 * Remote bus voltage control is possible by specifying the controlled terminal located at some place remote from the controlling equipment.
 * @param sup Reference to the superclass object.
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
 * @param Terminal The terminal associated with this regulating control.
 *        The terminal is associated instead of a node, since the terminal could connect into either a topological node (bus in bus-branch model) or a connectivity node (detailed switch model).  Sometimes it is useful to model regulation at a terminal of a bus bar object since the bus bar can be present in both a bus-branch model or a model with switch detail.
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
    Terminal: String
)
extends
    Element
{
    def this () = { this (null, false, false, null, null, 0.0, 0.0, null, null) }
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
        sup.export_fields +
        "\t\t<cim:RegulatingControl.discrete>" + discrete + "</cim:RegulatingControl.discrete>\n" +
        "\t\t<cim:RegulatingControl.enabled>" + enabled + "</cim:RegulatingControl.enabled>\n" +
        (if (null != mode) "\t\t<cim:RegulatingControl.mode rdf:resource=\"#" + mode + "\"/>\n" else "") +
        (if (null != monitoredPhase) "\t\t<cim:RegulatingControl.monitoredPhase rdf:resource=\"#" + monitoredPhase + "\"/>\n" else "") +
        "\t\t<cim:RegulatingControl.targetDeadband>" + targetDeadband + "</cim:RegulatingControl.targetDeadband>\n" +
        "\t\t<cim:RegulatingControl.targetValue>" + targetValue + "</cim:RegulatingControl.targetValue>\n" +
        (if (null != targetValueUnitMultiplier) "\t\t<cim:RegulatingControl.targetValueUnitMultiplier rdf:resource=\"#" + targetValueUnitMultiplier + "\"/>\n" else "") +
        (if (null != Terminal) "\t\t<cim:RegulatingControl.Terminal rdf:resource=\"#" + Terminal + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:RegulatingControl rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RegulatingControl>\n"
    }
}

object RegulatingControl
extends
    Parseable[RegulatingControl]
{
    val discrete: (Context) => String = parse_element (element ("""RegulatingControl.discrete"""))
    val enabled: (Context) => String = parse_element (element ("""RegulatingControl.enabled"""))
    val mode: (Context) => String = parse_attribute (attribute ("""RegulatingControl.mode"""))
    val monitoredPhase: (Context) => String = parse_attribute (attribute ("""RegulatingControl.monitoredPhase"""))
    val targetDeadband: (Context) => String = parse_element (element ("""RegulatingControl.targetDeadband"""))
    val targetValue: (Context) => String = parse_element (element ("""RegulatingControl.targetValue"""))
    val targetValueUnitMultiplier: (Context) => String = parse_attribute (attribute ("""RegulatingControl.targetValueUnitMultiplier"""))
    val Terminal: (Context) => String = parse_attribute (attribute ("""RegulatingControl.Terminal"""))
    def parse (context: Context): RegulatingControl =
    {
        RegulatingControl(
            PowerSystemResource.parse (context),
            toBoolean (discrete (context), context),
            toBoolean (enabled (context), context),
            mode (context),
            monitoredPhase (context),
            toDouble (targetDeadband (context), context),
            toDouble (targetValue (context), context),
            targetValueUnitMultiplier (context),
            Terminal (context)
        )
    }
}

/**
 * The kind of regulation model.
 * For example regulating voltage, reactive power, active power, etc.
 * @param sup Reference to the superclass object.
 * @param activePower Active power is specified.
 * @param admittance Admittance is specified.
 * @param currentFlow Current flow is specified.
 * @param powerFactor Power factor is specified.
 * @param reactivePower Reactive power is specified.
 * @param temperature Control switches on/off based on the local temperature (i.e., a thermostat).
 * @param timeScheduled Control switches on/off by time of day.
 *        The times may change on the weekend, or in different seasons.
 * @param voltage Voltage is specified.
 */
case class RegulatingControlModeKind
(
    override val sup: BasicElement,
    activePower: String,
    admittance: String,
    currentFlow: String,
    powerFactor: String,
    reactivePower: String,
    temperature: String,
    timeScheduled: String,
    voltage: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[RegulatingControlModeKind] }
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
        (if (null != activePower) "\t\t<cim:RegulatingControlModeKind.activePower rdf:resource=\"#" + activePower + "\"/>\n" else "") +
        (if (null != admittance) "\t\t<cim:RegulatingControlModeKind.admittance rdf:resource=\"#" + admittance + "\"/>\n" else "") +
        (if (null != currentFlow) "\t\t<cim:RegulatingControlModeKind.currentFlow rdf:resource=\"#" + currentFlow + "\"/>\n" else "") +
        (if (null != powerFactor) "\t\t<cim:RegulatingControlModeKind.powerFactor rdf:resource=\"#" + powerFactor + "\"/>\n" else "") +
        (if (null != reactivePower) "\t\t<cim:RegulatingControlModeKind.reactivePower rdf:resource=\"#" + reactivePower + "\"/>\n" else "") +
        (if (null != temperature) "\t\t<cim:RegulatingControlModeKind.temperature rdf:resource=\"#" + temperature + "\"/>\n" else "") +
        (if (null != timeScheduled) "\t\t<cim:RegulatingControlModeKind.timeScheduled rdf:resource=\"#" + timeScheduled + "\"/>\n" else "") +
        (if (null != voltage) "\t\t<cim:RegulatingControlModeKind.voltage rdf:resource=\"#" + voltage + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:RegulatingControlModeKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RegulatingControlModeKind>\n"
    }
}

object RegulatingControlModeKind
extends
    Parseable[RegulatingControlModeKind]
{
    val activePower: (Context) => String = parse_attribute (attribute ("""RegulatingControlModeKind.activePower"""))
    val admittance: (Context) => String = parse_attribute (attribute ("""RegulatingControlModeKind.admittance"""))
    val currentFlow: (Context) => String = parse_attribute (attribute ("""RegulatingControlModeKind.currentFlow"""))
    val powerFactor: (Context) => String = parse_attribute (attribute ("""RegulatingControlModeKind.powerFactor"""))
    val reactivePower: (Context) => String = parse_attribute (attribute ("""RegulatingControlModeKind.reactivePower"""))
    val temperature: (Context) => String = parse_attribute (attribute ("""RegulatingControlModeKind.temperature"""))
    val timeScheduled: (Context) => String = parse_attribute (attribute ("""RegulatingControlModeKind.timeScheduled"""))
    val voltage: (Context) => String = parse_attribute (attribute ("""RegulatingControlModeKind.voltage"""))
    def parse (context: Context): RegulatingControlModeKind =
    {
        RegulatingControlModeKind(
            BasicElement.parse (context),
            activePower (context),
            admittance (context),
            currentFlow (context),
            powerFactor (context),
            reactivePower (context),
            temperature (context),
            timeScheduled (context),
            voltage (context)
        )
    }
}

/**
 * A pre-established pattern over time for a controlled variable, e.g., busbar voltage.
 * @param sup Reference to the superclass object.
 * @param RegulatingControl Regulating controls that have this Schedule.
 */
case class RegulationSchedule
(
    override val sup: SeasonDayTypeSchedule,
    RegulatingControl: String
)
extends
    Element
{
    def this () = { this (null, null) }
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
        sup.export_fields +
        (if (null != RegulatingControl) "\t\t<cim:RegulationSchedule.RegulatingControl rdf:resource=\"#" + RegulatingControl + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:RegulationSchedule rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RegulationSchedule>\n"
    }
}

object RegulationSchedule
extends
    Parseable[RegulationSchedule]
{
    val RegulatingControl: (Context) => String = parse_attribute (attribute ("""RegulationSchedule.RegulatingControl"""))
    def parse (context: Context): RegulationSchedule =
    {
        RegulationSchedule(
            SeasonDayTypeSchedule.parse (context),
            RegulatingControl (context)
        )
    }
}

/**
 * A rotating machine which may be used as a generator or motor.
 * @param sup Reference to the superclass object.
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
 * @param GeneratingUnit A synchronous machine may operate as a generator and as such becomes a member of a generating unit.
 * @param HydroPump The synchronous machine drives the turbine which moves the water from a low elevation to a higher elevation.
 *        The direction of machine rotation for pumping may or may not be the same as for generating.
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
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, null, null) }
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
        sup.export_fields +
        "\t\t<cim:RotatingMachine.p>" + p + "</cim:RotatingMachine.p>\n" +
        "\t\t<cim:RotatingMachine.q>" + q + "</cim:RotatingMachine.q>\n" +
        "\t\t<cim:RotatingMachine.ratedPowerFactor>" + ratedPowerFactor + "</cim:RotatingMachine.ratedPowerFactor>\n" +
        "\t\t<cim:RotatingMachine.ratedS>" + ratedS + "</cim:RotatingMachine.ratedS>\n" +
        "\t\t<cim:RotatingMachine.ratedU>" + ratedU + "</cim:RotatingMachine.ratedU>\n" +
        (if (null != GeneratingUnit) "\t\t<cim:RotatingMachine.GeneratingUnit rdf:resource=\"#" + GeneratingUnit + "\"/>\n" else "") +
        (if (null != HydroPump) "\t\t<cim:RotatingMachine.HydroPump rdf:resource=\"#" + HydroPump + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:RotatingMachine rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RotatingMachine>\n"
    }
}

object RotatingMachine
extends
    Parseable[RotatingMachine]
{
    val p: (Context) => String = parse_element (element ("""RotatingMachine.p"""))
    val q: (Context) => String = parse_element (element ("""RotatingMachine.q"""))
    val ratedPowerFactor: (Context) => String = parse_element (element ("""RotatingMachine.ratedPowerFactor"""))
    val ratedS: (Context) => String = parse_element (element ("""RotatingMachine.ratedS"""))
    val ratedU: (Context) => String = parse_element (element ("""RotatingMachine.ratedU"""))
    val GeneratingUnit: (Context) => String = parse_attribute (attribute ("""RotatingMachine.GeneratingUnit"""))
    val HydroPump: (Context) => String = parse_attribute (attribute ("""RotatingMachine.HydroPump"""))
    def parse (context: Context): RotatingMachine =
    {
        RotatingMachine(
            RegulatingCondEq.parse (context),
            toDouble (p (context), context),
            toDouble (q (context), context),
            toDouble (ratedPowerFactor (context), context),
            toDouble (ratedS (context), context),
            toDouble (ratedU (context), context),
            GeneratingUnit (context),
            HydroPump (context)
        )
    }
}

/**
 * Static VAr Compensator control mode.
 * @param sup Reference to the superclass object.
 * @param reactivePower <em>undocumented</em>
 * @param voltage <em>undocumented</em>
 */
case class SVCControlMode
(
    override val sup: BasicElement,
    reactivePower: String,
    voltage: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[SVCControlMode] }
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
        (if (null != reactivePower) "\t\t<cim:SVCControlMode.reactivePower rdf:resource=\"#" + reactivePower + "\"/>\n" else "") +
        (if (null != voltage) "\t\t<cim:SVCControlMode.voltage rdf:resource=\"#" + voltage + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SVCControlMode rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SVCControlMode>\n"
    }
}

object SVCControlMode
extends
    Parseable[SVCControlMode]
{
    val reactivePower: (Context) => String = parse_attribute (attribute ("""SVCControlMode.reactivePower"""))
    val voltage: (Context) => String = parse_attribute (attribute ("""SVCControlMode.voltage"""))
    def parse (context: Context): SVCControlMode =
    {
        SVCControlMode(
            BasicElement.parse (context),
            reactivePower (context),
            voltage (context)
        )
    }
}

/**
 * Automatic switch that will lock open to isolate a faulted section.
 * It may, or may not, have load breaking capability. Its primary purpose is to provide fault sectionalising at locations where the fault current is either too high, or too low, for proper coordination of fuses.
 * @param sup Reference to the superclass object.
 */
case class Sectionaliser
(
    override val sup: Switch
)
extends
    Element
{
    def this () = { this (null) }
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:Sectionaliser rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Sectionaliser>\n"
    }
}

object Sectionaliser
extends
    Parseable[Sectionaliser]
{
    def parse (context: Context): Sectionaliser =
    {
        Sectionaliser(
            Switch.parse (context)
        )
    }
}

/**
 * A Series Compensator is a series capacitor or reactor or an AC transmission line without charging susceptance.
 * It is a two terminal device.
 * @param sup Reference to the superclass object.
 * @param r Positive sequence resistance.
 * @param r0 Zero sequence resistance.
 * @param varistorPresent Describe if a metal oxide varistor (mov) for over voltage protection is configured at the series compensator.
 * @param varistorRatedCurrent The maximum current the varistor is designed to handle at specified duration.
 * @param varistorVoltageThreshold The dc voltage at which the varistor start conducting.
 * @param x Positive sequence reactance.
 * @param x0 Zero sequence reactance.
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
    def this () = { this (null, 0.0, 0.0, false, 0.0, 0.0, 0.0, 0.0) }
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
        sup.export_fields +
        "\t\t<cim:SeriesCompensator.r>" + r + "</cim:SeriesCompensator.r>\n" +
        "\t\t<cim:SeriesCompensator.r0>" + r0 + "</cim:SeriesCompensator.r0>\n" +
        "\t\t<cim:SeriesCompensator.varistorPresent>" + varistorPresent + "</cim:SeriesCompensator.varistorPresent>\n" +
        "\t\t<cim:SeriesCompensator.varistorRatedCurrent>" + varistorRatedCurrent + "</cim:SeriesCompensator.varistorRatedCurrent>\n" +
        "\t\t<cim:SeriesCompensator.varistorVoltageThreshold>" + varistorVoltageThreshold + "</cim:SeriesCompensator.varistorVoltageThreshold>\n" +
        "\t\t<cim:SeriesCompensator.x>" + x + "</cim:SeriesCompensator.x>\n" +
        "\t\t<cim:SeriesCompensator.x0>" + x0 + "</cim:SeriesCompensator.x0>\n"
    }
    override def export: String =
    {
        "\t<cim:SeriesCompensator rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SeriesCompensator>\n"
    }
}

object SeriesCompensator
extends
    Parseable[SeriesCompensator]
{
    val r: (Context) => String = parse_element (element ("""SeriesCompensator.r"""))
    val r0: (Context) => String = parse_element (element ("""SeriesCompensator.r0"""))
    val varistorPresent: (Context) => String = parse_element (element ("""SeriesCompensator.varistorPresent"""))
    val varistorRatedCurrent: (Context) => String = parse_element (element ("""SeriesCompensator.varistorRatedCurrent"""))
    val varistorVoltageThreshold: (Context) => String = parse_element (element ("""SeriesCompensator.varistorVoltageThreshold"""))
    val x: (Context) => String = parse_element (element ("""SeriesCompensator.x"""))
    val x0: (Context) => String = parse_element (element ("""SeriesCompensator.x0"""))
    def parse (context: Context): SeriesCompensator =
    {
        SeriesCompensator(
            ConductingEquipment.parse (context),
            toDouble (r (context), context),
            toDouble (r0 (context), context),
            toBoolean (varistorPresent (context), context),
            toDouble (varistorRatedCurrent (context), context),
            toDouble (varistorVoltageThreshold (context), context),
            toDouble (x (context), context),
            toDouble (x0 (context), context)
        )
    }
}

/**
 * Type of rotor, used by short circuit applications.
 * @param sup Reference to the superclass object.
 * @param salientPole1 Salient pole 1 in the IEC 60909
 * @param salientPole2 Salient pole 2 in IEC 60909
 * @param turboSeries1 Turbo Series 1 in the IEC 60909
 * @param turboSeries2 Turbo series 2 in IEC 60909
 */
case class ShortCircuitRotorKind
(
    override val sup: BasicElement,
    salientPole1: String,
    salientPole2: String,
    turboSeries1: String,
    turboSeries2: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ShortCircuitRotorKind] }
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
        (if (null != salientPole1) "\t\t<cim:ShortCircuitRotorKind.salientPole1 rdf:resource=\"#" + salientPole1 + "\"/>\n" else "") +
        (if (null != salientPole2) "\t\t<cim:ShortCircuitRotorKind.salientPole2 rdf:resource=\"#" + salientPole2 + "\"/>\n" else "") +
        (if (null != turboSeries1) "\t\t<cim:ShortCircuitRotorKind.turboSeries1 rdf:resource=\"#" + turboSeries1 + "\"/>\n" else "") +
        (if (null != turboSeries2) "\t\t<cim:ShortCircuitRotorKind.turboSeries2 rdf:resource=\"#" + turboSeries2 + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ShortCircuitRotorKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ShortCircuitRotorKind>\n"
    }
}

object ShortCircuitRotorKind
extends
    Parseable[ShortCircuitRotorKind]
{
    val salientPole1: (Context) => String = parse_attribute (attribute ("""ShortCircuitRotorKind.salientPole1"""))
    val salientPole2: (Context) => String = parse_attribute (attribute ("""ShortCircuitRotorKind.salientPole2"""))
    val turboSeries1: (Context) => String = parse_attribute (attribute ("""ShortCircuitRotorKind.turboSeries1"""))
    val turboSeries2: (Context) => String = parse_attribute (attribute ("""ShortCircuitRotorKind.turboSeries2"""))
    def parse (context: Context): ShortCircuitRotorKind =
    {
        ShortCircuitRotorKind(
            BasicElement.parse (context),
            salientPole1 (context),
            salientPole2 (context),
            turboSeries1 (context),
            turboSeries2 (context)
        )
    }
}

/**
 * A shunt capacitor or reactor or switchable bank of shunt capacitors or reactors.
 * A section of a shunt compensator is an individual capacitor or reactor.  A negative value for reactivePerSection indicates that the compensator is a reactor. ShuntCompensator is a single terminal device.  Ground is implied.
 * @param sup Reference to the superclass object.
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
 * @param SvShuntCompensatorSections The state for the number of shunt compensator sections in service.
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
    SvShuntCompensatorSections: String
)
extends
    Element
{
    def this () = { this (null, 0.0, false, 0, 0.0, 0, null, 0.0, 0, null, 0.0, null) }
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
        sup.export_fields +
        "\t\t<cim:ShuntCompensator.aVRDelay>" + aVRDelay + "</cim:ShuntCompensator.aVRDelay>\n" +
        "\t\t<cim:ShuntCompensator.grounded>" + grounded + "</cim:ShuntCompensator.grounded>\n" +
        "\t\t<cim:ShuntCompensator.maximumSections>" + maximumSections + "</cim:ShuntCompensator.maximumSections>\n" +
        "\t\t<cim:ShuntCompensator.nomU>" + nomU + "</cim:ShuntCompensator.nomU>\n" +
        "\t\t<cim:ShuntCompensator.normalSections>" + normalSections + "</cim:ShuntCompensator.normalSections>\n" +
        (if (null != phaseConnection) "\t\t<cim:ShuntCompensator.phaseConnection rdf:resource=\"#" + phaseConnection + "\"/>\n" else "") +
        "\t\t<cim:ShuntCompensator.sections>" + sections + "</cim:ShuntCompensator.sections>\n" +
        "\t\t<cim:ShuntCompensator.switchOnCount>" + switchOnCount + "</cim:ShuntCompensator.switchOnCount>\n" +
        (if (null != switchOnDate) "\t\t<cim:ShuntCompensator.switchOnDate>" + switchOnDate + "</cim:ShuntCompensator.switchOnDate>\n" else "") +
        "\t\t<cim:ShuntCompensator.voltageSensitivity>" + voltageSensitivity + "</cim:ShuntCompensator.voltageSensitivity>\n" +
        (if (null != SvShuntCompensatorSections) "\t\t<cim:ShuntCompensator.SvShuntCompensatorSections rdf:resource=\"#" + SvShuntCompensatorSections + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ShuntCompensator rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ShuntCompensator>\n"
    }
}

object ShuntCompensator
extends
    Parseable[ShuntCompensator]
{
    val aVRDelay: (Context) => String = parse_element (element ("""ShuntCompensator.aVRDelay"""))
    val grounded: (Context) => String = parse_element (element ("""ShuntCompensator.grounded"""))
    val maximumSections: (Context) => String = parse_element (element ("""ShuntCompensator.maximumSections"""))
    val nomU: (Context) => String = parse_element (element ("""ShuntCompensator.nomU"""))
    val normalSections: (Context) => String = parse_element (element ("""ShuntCompensator.normalSections"""))
    val phaseConnection: (Context) => String = parse_attribute (attribute ("""ShuntCompensator.phaseConnection"""))
    val sections: (Context) => String = parse_element (element ("""ShuntCompensator.sections"""))
    val switchOnCount: (Context) => String = parse_element (element ("""ShuntCompensator.switchOnCount"""))
    val switchOnDate: (Context) => String = parse_element (element ("""ShuntCompensator.switchOnDate"""))
    val voltageSensitivity: (Context) => String = parse_element (element ("""ShuntCompensator.voltageSensitivity"""))
    val SvShuntCompensatorSections: (Context) => String = parse_attribute (attribute ("""ShuntCompensator.SvShuntCompensatorSections"""))
    def parse (context: Context): ShuntCompensator =
    {
        ShuntCompensator(
            RegulatingCondEq.parse (context),
            toDouble (aVRDelay (context), context),
            toBoolean (grounded (context), context),
            toInteger (maximumSections (context), context),
            toDouble (nomU (context), context),
            toInteger (normalSections (context), context),
            phaseConnection (context),
            toDouble (sections (context), context),
            toInteger (switchOnCount (context), context),
            switchOnDate (context),
            toDouble (voltageSensitivity (context), context),
            SvShuntCompensatorSections (context)
        )
    }
}

/**
 * Single phase of a multi-phase shunt compensator when its attributes might be different per phase.
 * @param sup Reference to the superclass object.
 * @param maximumSections The maximum number of sections that may be switched in for this phase.
 * @param normalSections For the capacitor phase, the normal number of sections switched in.
 * @param phase Phase of this shunt compensator component.
 *        If the shunt compensator is wye connected, the connection is from the indicated phase to the central ground or neutral point.  If the shunt compensator is delta connected, the phase indicates a shunt compensator connected from the indicated phase to the next logical non-neutral phase.
 * @param ShuntCompensator Shunt compensator of this shunt compensator phase.
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
    def this () = { this (null, 0, 0, null, null) }
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
        sup.export_fields +
        "\t\t<cim:ShuntCompensatorPhase.maximumSections>" + maximumSections + "</cim:ShuntCompensatorPhase.maximumSections>\n" +
        "\t\t<cim:ShuntCompensatorPhase.normalSections>" + normalSections + "</cim:ShuntCompensatorPhase.normalSections>\n" +
        (if (null != phase) "\t\t<cim:ShuntCompensatorPhase.phase rdf:resource=\"#" + phase + "\"/>\n" else "") +
        (if (null != ShuntCompensator) "\t\t<cim:ShuntCompensatorPhase.ShuntCompensator rdf:resource=\"#" + ShuntCompensator + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ShuntCompensatorPhase rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ShuntCompensatorPhase>\n"
    }
}

object ShuntCompensatorPhase
extends
    Parseable[ShuntCompensatorPhase]
{
    val maximumSections: (Context) => String = parse_element (element ("""ShuntCompensatorPhase.maximumSections"""))
    val normalSections: (Context) => String = parse_element (element ("""ShuntCompensatorPhase.normalSections"""))
    val phase: (Context) => String = parse_attribute (attribute ("""ShuntCompensatorPhase.phase"""))
    val ShuntCompensator: (Context) => String = parse_attribute (attribute ("""ShuntCompensatorPhase.ShuntCompensator"""))
    def parse (context: Context): ShuntCompensatorPhase =
    {
        ShuntCompensatorPhase(
            PowerSystemResource.parse (context),
            toInteger (maximumSections (context), context),
            toInteger (normalSections (context), context),
            phase (context),
            ShuntCompensator (context)
        )
    }
}

/**
 * Enumeration of single phase identifiers.
 * Allows designation of single phases for both transmission and distribution equipment, circuits and loads.
 * @param sup Reference to the superclass object.
 * @param s1 Secondary phase 1.
 * @param s2 Secondary phase 2.
 * @param A Phase A.
 * @param B Phase B.
 * @param C Phase C.
 * @param N Neutral.
 */
case class SinglePhaseKind
(
    override val sup: BasicElement,
    s1: String,
    s2: String,
    A: String,
    B: String,
    C: String,
    N: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[SinglePhaseKind] }
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
        (if (null != s1) "\t\t<cim:SinglePhaseKind.s1 rdf:resource=\"#" + s1 + "\"/>\n" else "") +
        (if (null != s2) "\t\t<cim:SinglePhaseKind.s2 rdf:resource=\"#" + s2 + "\"/>\n" else "") +
        (if (null != A) "\t\t<cim:SinglePhaseKind.A rdf:resource=\"#" + A + "\"/>\n" else "") +
        (if (null != B) "\t\t<cim:SinglePhaseKind.B rdf:resource=\"#" + B + "\"/>\n" else "") +
        (if (null != C) "\t\t<cim:SinglePhaseKind.C rdf:resource=\"#" + C + "\"/>\n" else "") +
        (if (null != N) "\t\t<cim:SinglePhaseKind.N rdf:resource=\"#" + N + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SinglePhaseKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SinglePhaseKind>\n"
    }
}

object SinglePhaseKind
extends
    Parseable[SinglePhaseKind]
{
    val s1: (Context) => String = parse_attribute (attribute ("""SinglePhaseKind.s1"""))
    val s2: (Context) => String = parse_attribute (attribute ("""SinglePhaseKind.s2"""))
    val A: (Context) => String = parse_attribute (attribute ("""SinglePhaseKind.A"""))
    val B: (Context) => String = parse_attribute (attribute ("""SinglePhaseKind.B"""))
    val C: (Context) => String = parse_attribute (attribute ("""SinglePhaseKind.C"""))
    val N: (Context) => String = parse_attribute (attribute ("""SinglePhaseKind.N"""))
    def parse (context: Context): SinglePhaseKind =
    {
        SinglePhaseKind(
            BasicElement.parse (context),
            s1 (context),
            s2 (context),
            A (context),
            B (context),
            C (context),
            N (context)
        )
    }
}

/**
 * A facility for providing variable and controllable shunt reactive power.
 * The SVC typically consists of a stepdown transformer, filter, thyristor-controlled reactor, and thyristor-switched capacitor arms.
 * @param sup Reference to the superclass object.
 * @param capacitiveRating Maximum available capacitive reactance.
 * @param inductiveRating Maximum available inductive reactance.
 * @param q Reactive power injection.
 *        Load sign convention is used, i.e. positive sign means flow out from a node.
 * @param sVCControlMode SVC control mode.
 * @param slope The characteristics slope of an SVC defines how the reactive power output changes in proportion to the difference between the regulated bus voltage and the voltage setpoint.
 * @param voltageSetPoint The reactive power output of the SVC is proportional to the difference between the voltage at the regulated bus and the voltage setpoint.
 *        When the regulated bus voltage is equal to the voltage setpoint, the reactive power output is zero.
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
    def this () = { this (null, 0.0, 0.0, 0.0, null, 0.0, 0.0) }
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
        sup.export_fields +
        "\t\t<cim:StaticVarCompensator.capacitiveRating>" + capacitiveRating + "</cim:StaticVarCompensator.capacitiveRating>\n" +
        "\t\t<cim:StaticVarCompensator.inductiveRating>" + inductiveRating + "</cim:StaticVarCompensator.inductiveRating>\n" +
        "\t\t<cim:StaticVarCompensator.q>" + q + "</cim:StaticVarCompensator.q>\n" +
        (if (null != sVCControlMode) "\t\t<cim:StaticVarCompensator.sVCControlMode rdf:resource=\"#" + sVCControlMode + "\"/>\n" else "") +
        "\t\t<cim:StaticVarCompensator.slope>" + slope + "</cim:StaticVarCompensator.slope>\n" +
        "\t\t<cim:StaticVarCompensator.voltageSetPoint>" + voltageSetPoint + "</cim:StaticVarCompensator.voltageSetPoint>\n"
    }
    override def export: String =
    {
        "\t<cim:StaticVarCompensator rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:StaticVarCompensator>\n"
    }
}

object StaticVarCompensator
extends
    Parseable[StaticVarCompensator]
{
    val capacitiveRating: (Context) => String = parse_element (element ("""StaticVarCompensator.capacitiveRating"""))
    val inductiveRating: (Context) => String = parse_element (element ("""StaticVarCompensator.inductiveRating"""))
    val q: (Context) => String = parse_element (element ("""StaticVarCompensator.q"""))
    val sVCControlMode: (Context) => String = parse_attribute (attribute ("""StaticVarCompensator.sVCControlMode"""))
    val slope: (Context) => String = parse_element (element ("""StaticVarCompensator.slope"""))
    val voltageSetPoint: (Context) => String = parse_element (element ("""StaticVarCompensator.voltageSetPoint"""))
    def parse (context: Context): StaticVarCompensator =
    {
        StaticVarCompensator(
            RegulatingCondEq.parse (context),
            toDouble (capacitiveRating (context), context),
            toDouble (inductiveRating (context), context),
            toDouble (q (context), context),
            sVCControlMode (context),
            toDouble (slope (context), context),
            toDouble (voltageSetPoint (context), context)
        )
    }
}

/**
 * A generic device designed to close, or open, or both, one or more electric circuits.
 * All switches are two terminal devices including grounding switches.
 * @param sup Reference to the superclass object.
 * @param normalOpen The attribute is used in cases when no Measurement for the status value is present.
 *        If the Switch has a status measurement the Discrete.normalValue is expected to match with the Switch.normalOpen.
 * @param open The attribute tells if the switch is considered open when used as input to topology processing.
 * @param ratedCurrent The maximum continuous current carrying capacity in amps governed by the device material and construction.
 * @param retained Branch is retained in a bus branch model.
 *        The flow through retained switches will normally be calculated in power flow.
 * @param switchOnCount The switch on count since the switch was last reset or initialized.
 * @param switchOnDate The date and time when the switch was last switched on.
 * @param CompositeSwitch Composite switch to which this Switch belongs.
 * @param Outage Current outage of this protective device.
 * @param SwitchAction Action changing status of this switch.
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
    Outage: String,
    SwitchAction: String
)
extends
    Element
{
    def this () = { this (null, false, false, 0.0, false, 0, null, null, null, null) }
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
        sup.export_fields +
        "\t\t<cim:Switch.normalOpen>" + normalOpen + "</cim:Switch.normalOpen>\n" +
        "\t\t<cim:Switch.open>" + open + "</cim:Switch.open>\n" +
        "\t\t<cim:Switch.ratedCurrent>" + ratedCurrent + "</cim:Switch.ratedCurrent>\n" +
        "\t\t<cim:Switch.retained>" + retained + "</cim:Switch.retained>\n" +
        "\t\t<cim:Switch.switchOnCount>" + switchOnCount + "</cim:Switch.switchOnCount>\n" +
        (if (null != switchOnDate) "\t\t<cim:Switch.switchOnDate>" + switchOnDate + "</cim:Switch.switchOnDate>\n" else "") +
        (if (null != CompositeSwitch) "\t\t<cim:Switch.CompositeSwitch rdf:resource=\"#" + CompositeSwitch + "\"/>\n" else "") +
        (if (null != Outage) "\t\t<cim:Switch.Outage rdf:resource=\"#" + Outage + "\"/>\n" else "") +
        (if (null != SwitchAction) "\t\t<cim:Switch.SwitchAction rdf:resource=\"#" + SwitchAction + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Switch rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Switch>\n"
    }
}

object Switch
extends
    Parseable[Switch]
{
    val normalOpen: (Context) => String = parse_element (element ("""Switch.normalOpen"""))
    val open: (Context) => String = parse_element (element ("""Switch.open"""))
    val ratedCurrent: (Context) => String = parse_element (element ("""Switch.ratedCurrent"""))
    val retained: (Context) => String = parse_element (element ("""Switch.retained"""))
    val switchOnCount: (Context) => String = parse_element (element ("""Switch.switchOnCount"""))
    val switchOnDate: (Context) => String = parse_element (element ("""Switch.switchOnDate"""))
    val CompositeSwitch: (Context) => String = parse_attribute (attribute ("""Switch.CompositeSwitch"""))
    val Outage: (Context) => String = parse_attribute (attribute ("""Switch.Outage"""))
    val SwitchAction: (Context) => String = parse_attribute (attribute ("""Switch.SwitchAction"""))
    def parse (context: Context): Switch =
    {
        Switch(
            ConductingEquipment.parse (context),
            toBoolean (normalOpen (context), context),
            toBoolean (open (context), context),
            toDouble (ratedCurrent (context), context),
            toBoolean (retained (context), context),
            toInteger (switchOnCount (context), context),
            switchOnDate (context),
            CompositeSwitch (context),
            Outage (context),
            SwitchAction (context)
        )
    }
}

/**
 * Single phase of a multi-phase switch when its attributes might be different per phase.
 * @param sup Reference to the superclass object.
 * @param closed The attribute tells if the switch is considered closed when used as input to topology processing.
 * @param normalOpen Used in cases when no Measurement for the status value is present.
 *        If the SwitchPhase has a status measurement the Discrete.normalValue is expected to match with this value.
 * @param phaseSide1 Phase of this SwitchPhase on the side with terminal sequence number equal 1.
 *        Should be a phase contained in that terminal&rsquo;s phases attribute.
 * @param phaseSide2 Phase of this SwitchPhase on the side with terminal sequence number equal 2.
 *        Should be a phase contained in that terminal&rsquo;s Terminal.phases attribute.
 * @param Switch The switch of the switch phase.
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
    def this () = { this (null, false, false, null, null, null) }
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
        sup.export_fields +
        "\t\t<cim:SwitchPhase.closed>" + closed + "</cim:SwitchPhase.closed>\n" +
        "\t\t<cim:SwitchPhase.normalOpen>" + normalOpen + "</cim:SwitchPhase.normalOpen>\n" +
        (if (null != phaseSide1) "\t\t<cim:SwitchPhase.phaseSide1 rdf:resource=\"#" + phaseSide1 + "\"/>\n" else "") +
        (if (null != phaseSide2) "\t\t<cim:SwitchPhase.phaseSide2 rdf:resource=\"#" + phaseSide2 + "\"/>\n" else "") +
        (if (null != Switch) "\t\t<cim:SwitchPhase.Switch rdf:resource=\"#" + Switch + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SwitchPhase rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SwitchPhase>\n"
    }
}

object SwitchPhase
extends
    Parseable[SwitchPhase]
{
    val closed: (Context) => String = parse_element (element ("""SwitchPhase.closed"""))
    val normalOpen: (Context) => String = parse_element (element ("""SwitchPhase.normalOpen"""))
    val phaseSide1: (Context) => String = parse_attribute (attribute ("""SwitchPhase.phaseSide1"""))
    val phaseSide2: (Context) => String = parse_attribute (attribute ("""SwitchPhase.phaseSide2"""))
    val Switch: (Context) => String = parse_attribute (attribute ("""SwitchPhase.Switch"""))
    def parse (context: Context): SwitchPhase =
    {
        SwitchPhase(
            PowerSystemResource.parse (context),
            toBoolean (closed (context), context),
            toBoolean (normalOpen (context), context),
            phaseSide1 (context),
            phaseSide2 (context),
            Switch (context)
        )
    }
}

/**
 * A schedule of switch positions.
 * If RegularTimePoint.value1 is 0, the switch is open.  If 1, the switch is closed.
 * @param sup Reference to the superclass object.
 * @param Switch A SwitchSchedule is associated with a Switch.
 */
case class SwitchSchedule
(
    override val sup: SeasonDayTypeSchedule,
    Switch: String
)
extends
    Element
{
    def this () = { this (null, null) }
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
        sup.export_fields +
        (if (null != Switch) "\t\t<cim:SwitchSchedule.Switch rdf:resource=\"#" + Switch + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SwitchSchedule rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SwitchSchedule>\n"
    }
}

object SwitchSchedule
extends
    Parseable[SwitchSchedule]
{
    val Switch: (Context) => String = parse_attribute (attribute ("""SwitchSchedule.Switch"""))
    def parse (context: Context): SwitchSchedule =
    {
        SwitchSchedule(
            SeasonDayTypeSchedule.parse (context),
            Switch (context)
        )
    }
}

/**
 * An electromechanical device that operates with shaft rotating synchronously with the network.
 * It is a single machine operating either as a generator or synchronous condenser or pump.
 * @param sup Reference to the superclass object.
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
- Ikk=0: Generator with no compound excitation.
- Ikk?0: Generator with compound excitation.
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
 * @param typ Modes that this synchronous machine can operate in.
 * @param voltageRegulationRange Range of generator voltage regulation (PG in the IEC 60909-0) used for calculation of the impedance correction factor KG defined in IEC 60909-0
 *        This attribute is used to describe the operating voltage of the generating unit.
 * @param x0 Zero sequence reactance of the synchronous machine.
 * @param x2 Negative sequence reactance.
 * @param InitialReactiveCapabilityCurve The default reactive capability curve for use by a synchronous machine.
 * @param SynchronousMachineDynamics Synchronous machine dynamics model used to describe dynamic behavior of this synchronous machine.
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
    typ: String,
    voltageRegulationRange: Double,
    x0: Double,
    x2: Double,
    InitialReactiveCapabilityCurve: String,
    SynchronousMachineDynamics: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, null, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, 0.0, 0.0, 0.0, 0.0, 0, 0.0, 0.0, 0.0, null, null, 0.0, 0.0, 0.0, null, null) }
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
        sup.export_fields +
        "\t\t<cim:SynchronousMachine.aVRToManualLag>" + aVRToManualLag + "</cim:SynchronousMachine.aVRToManualLag>\n" +
        "\t\t<cim:SynchronousMachine.aVRToManualLead>" + aVRToManualLead + "</cim:SynchronousMachine.aVRToManualLead>\n" +
        "\t\t<cim:SynchronousMachine.baseQ>" + baseQ + "</cim:SynchronousMachine.baseQ>\n" +
        "\t\t<cim:SynchronousMachine.condenserP>" + condenserP + "</cim:SynchronousMachine.condenserP>\n" +
        "\t\t<cim:SynchronousMachine.coolantCondition>" + coolantCondition + "</cim:SynchronousMachine.coolantCondition>\n" +
        (if (null != coolantType) "\t\t<cim:SynchronousMachine.coolantType rdf:resource=\"#" + coolantType + "\"/>\n" else "") +
        "\t\t<cim:SynchronousMachine.earthing>" + earthing + "</cim:SynchronousMachine.earthing>\n" +
        "\t\t<cim:SynchronousMachine.earthingStarPointR>" + earthingStarPointR + "</cim:SynchronousMachine.earthingStarPointR>\n" +
        "\t\t<cim:SynchronousMachine.earthingStarPointX>" + earthingStarPointX + "</cim:SynchronousMachine.earthingStarPointX>\n" +
        "\t\t<cim:SynchronousMachine.ikk>" + ikk + "</cim:SynchronousMachine.ikk>\n" +
        "\t\t<cim:SynchronousMachine.manualToAVR>" + manualToAVR + "</cim:SynchronousMachine.manualToAVR>\n" +
        "\t\t<cim:SynchronousMachine.maxQ>" + maxQ + "</cim:SynchronousMachine.maxQ>\n" +
        "\t\t<cim:SynchronousMachine.maxU>" + maxU + "</cim:SynchronousMachine.maxU>\n" +
        "\t\t<cim:SynchronousMachine.minQ>" + minQ + "</cim:SynchronousMachine.minQ>\n" +
        "\t\t<cim:SynchronousMachine.minU>" + minU + "</cim:SynchronousMachine.minU>\n" +
        "\t\t<cim:SynchronousMachine.mu>" + mu + "</cim:SynchronousMachine.mu>\n" +
        (if (null != operatingMode) "\t\t<cim:SynchronousMachine.operatingMode rdf:resource=\"#" + operatingMode + "\"/>\n" else "") +
        "\t\t<cim:SynchronousMachine.qPercent>" + qPercent + "</cim:SynchronousMachine.qPercent>\n" +
        "\t\t<cim:SynchronousMachine.r>" + r + "</cim:SynchronousMachine.r>\n" +
        "\t\t<cim:SynchronousMachine.r0>" + r0 + "</cim:SynchronousMachine.r0>\n" +
        "\t\t<cim:SynchronousMachine.r2>" + r2 + "</cim:SynchronousMachine.r2>\n" +
        "\t\t<cim:SynchronousMachine.referencePriority>" + referencePriority + "</cim:SynchronousMachine.referencePriority>\n" +
        "\t\t<cim:SynchronousMachine.satDirectSubtransX>" + satDirectSubtransX + "</cim:SynchronousMachine.satDirectSubtransX>\n" +
        "\t\t<cim:SynchronousMachine.satDirectSyncX>" + satDirectSyncX + "</cim:SynchronousMachine.satDirectSyncX>\n" +
        "\t\t<cim:SynchronousMachine.satDirectTransX>" + satDirectTransX + "</cim:SynchronousMachine.satDirectTransX>\n" +
        (if (null != shortCircuitRotorType) "\t\t<cim:SynchronousMachine.shortCircuitRotorType rdf:resource=\"#" + shortCircuitRotorType + "\"/>\n" else "") +
        (if (null != typ) "\t\t<cim:SynchronousMachine.type rdf:resource=\"#" + typ + "\"/>\n" else "") +
        "\t\t<cim:SynchronousMachine.voltageRegulationRange>" + voltageRegulationRange + "</cim:SynchronousMachine.voltageRegulationRange>\n" +
        "\t\t<cim:SynchronousMachine.x0>" + x0 + "</cim:SynchronousMachine.x0>\n" +
        "\t\t<cim:SynchronousMachine.x2>" + x2 + "</cim:SynchronousMachine.x2>\n" +
        (if (null != InitialReactiveCapabilityCurve) "\t\t<cim:SynchronousMachine.InitialReactiveCapabilityCurve rdf:resource=\"#" + InitialReactiveCapabilityCurve + "\"/>\n" else "") +
        (if (null != SynchronousMachineDynamics) "\t\t<cim:SynchronousMachine.SynchronousMachineDynamics rdf:resource=\"#" + SynchronousMachineDynamics + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SynchronousMachine rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SynchronousMachine>\n"
    }
}

object SynchronousMachine
extends
    Parseable[SynchronousMachine]
{
    val aVRToManualLag: (Context) => String = parse_element (element ("""SynchronousMachine.aVRToManualLag"""))
    val aVRToManualLead: (Context) => String = parse_element (element ("""SynchronousMachine.aVRToManualLead"""))
    val baseQ: (Context) => String = parse_element (element ("""SynchronousMachine.baseQ"""))
    val condenserP: (Context) => String = parse_element (element ("""SynchronousMachine.condenserP"""))
    val coolantCondition: (Context) => String = parse_element (element ("""SynchronousMachine.coolantCondition"""))
    val coolantType: (Context) => String = parse_attribute (attribute ("""SynchronousMachine.coolantType"""))
    val earthing: (Context) => String = parse_element (element ("""SynchronousMachine.earthing"""))
    val earthingStarPointR: (Context) => String = parse_element (element ("""SynchronousMachine.earthingStarPointR"""))
    val earthingStarPointX: (Context) => String = parse_element (element ("""SynchronousMachine.earthingStarPointX"""))
    val ikk: (Context) => String = parse_element (element ("""SynchronousMachine.ikk"""))
    val manualToAVR: (Context) => String = parse_element (element ("""SynchronousMachine.manualToAVR"""))
    val maxQ: (Context) => String = parse_element (element ("""SynchronousMachine.maxQ"""))
    val maxU: (Context) => String = parse_element (element ("""SynchronousMachine.maxU"""))
    val minQ: (Context) => String = parse_element (element ("""SynchronousMachine.minQ"""))
    val minU: (Context) => String = parse_element (element ("""SynchronousMachine.minU"""))
    val mu: (Context) => String = parse_element (element ("""SynchronousMachine.mu"""))
    val operatingMode: (Context) => String = parse_attribute (attribute ("""SynchronousMachine.operatingMode"""))
    val qPercent: (Context) => String = parse_element (element ("""SynchronousMachine.qPercent"""))
    val r: (Context) => String = parse_element (element ("""SynchronousMachine.r"""))
    val r0: (Context) => String = parse_element (element ("""SynchronousMachine.r0"""))
    val r2: (Context) => String = parse_element (element ("""SynchronousMachine.r2"""))
    val referencePriority: (Context) => String = parse_element (element ("""SynchronousMachine.referencePriority"""))
    val satDirectSubtransX: (Context) => String = parse_element (element ("""SynchronousMachine.satDirectSubtransX"""))
    val satDirectSyncX: (Context) => String = parse_element (element ("""SynchronousMachine.satDirectSyncX"""))
    val satDirectTransX: (Context) => String = parse_element (element ("""SynchronousMachine.satDirectTransX"""))
    val shortCircuitRotorType: (Context) => String = parse_attribute (attribute ("""SynchronousMachine.shortCircuitRotorType"""))
    val typ: (Context) => String = parse_attribute (attribute ("""SynchronousMachine.type"""))
    val voltageRegulationRange: (Context) => String = parse_element (element ("""SynchronousMachine.voltageRegulationRange"""))
    val x0: (Context) => String = parse_element (element ("""SynchronousMachine.x0"""))
    val x2: (Context) => String = parse_element (element ("""SynchronousMachine.x2"""))
    val InitialReactiveCapabilityCurve: (Context) => String = parse_attribute (attribute ("""SynchronousMachine.InitialReactiveCapabilityCurve"""))
    val SynchronousMachineDynamics: (Context) => String = parse_attribute (attribute ("""SynchronousMachine.SynchronousMachineDynamics"""))
    def parse (context: Context): SynchronousMachine =
    {
        SynchronousMachine(
            RotatingMachine.parse (context),
            toDouble (aVRToManualLag (context), context),
            toDouble (aVRToManualLead (context), context),
            toDouble (baseQ (context), context),
            toDouble (condenserP (context), context),
            toDouble (coolantCondition (context), context),
            coolantType (context),
            toBoolean (earthing (context), context),
            toDouble (earthingStarPointR (context), context),
            toDouble (earthingStarPointX (context), context),
            toDouble (ikk (context), context),
            toDouble (manualToAVR (context), context),
            toDouble (maxQ (context), context),
            toDouble (maxU (context), context),
            toDouble (minQ (context), context),
            toDouble (minU (context), context),
            toDouble (mu (context), context),
            operatingMode (context),
            toDouble (qPercent (context), context),
            toDouble (r (context), context),
            toDouble (r0 (context), context),
            toDouble (r2 (context), context),
            toInteger (referencePriority (context), context),
            toDouble (satDirectSubtransX (context), context),
            toDouble (satDirectSyncX (context), context),
            toDouble (satDirectTransX (context), context),
            shortCircuitRotorType (context),
            typ (context),
            toDouble (voltageRegulationRange (context), context),
            toDouble (x0 (context), context),
            toDouble (x2 (context), context),
            InitialReactiveCapabilityCurve (context),
            SynchronousMachineDynamics (context)
        )
    }
}

/**
 * Synchronous machine type.
 * @param sup Reference to the superclass object.
 * @param condenser <em>undocumented</em>
 * @param generator <em>undocumented</em>
 * @param generatorOrCondenser <em>undocumented</em>
 * @param generatorOrCondenserOrMotor <em>undocumented</em>
 * @param generatorOrMotor <em>undocumented</em>
 * @param motor <em>undocumented</em>
 * @param motorOrCondenser <em>undocumented</em>
 */
case class SynchronousMachineKind
(
    override val sup: BasicElement,
    condenser: String,
    generator: String,
    generatorOrCondenser: String,
    generatorOrCondenserOrMotor: String,
    generatorOrMotor: String,
    motor: String,
    motorOrCondenser: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[SynchronousMachineKind] }
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
        (if (null != condenser) "\t\t<cim:SynchronousMachineKind.condenser rdf:resource=\"#" + condenser + "\"/>\n" else "") +
        (if (null != generator) "\t\t<cim:SynchronousMachineKind.generator rdf:resource=\"#" + generator + "\"/>\n" else "") +
        (if (null != generatorOrCondenser) "\t\t<cim:SynchronousMachineKind.generatorOrCondenser rdf:resource=\"#" + generatorOrCondenser + "\"/>\n" else "") +
        (if (null != generatorOrCondenserOrMotor) "\t\t<cim:SynchronousMachineKind.generatorOrCondenserOrMotor rdf:resource=\"#" + generatorOrCondenserOrMotor + "\"/>\n" else "") +
        (if (null != generatorOrMotor) "\t\t<cim:SynchronousMachineKind.generatorOrMotor rdf:resource=\"#" + generatorOrMotor + "\"/>\n" else "") +
        (if (null != motor) "\t\t<cim:SynchronousMachineKind.motor rdf:resource=\"#" + motor + "\"/>\n" else "") +
        (if (null != motorOrCondenser) "\t\t<cim:SynchronousMachineKind.motorOrCondenser rdf:resource=\"#" + motorOrCondenser + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SynchronousMachineKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SynchronousMachineKind>\n"
    }
}

object SynchronousMachineKind
extends
    Parseable[SynchronousMachineKind]
{
    val condenser: (Context) => String = parse_attribute (attribute ("""SynchronousMachineKind.condenser"""))
    val generator: (Context) => String = parse_attribute (attribute ("""SynchronousMachineKind.generator"""))
    val generatorOrCondenser: (Context) => String = parse_attribute (attribute ("""SynchronousMachineKind.generatorOrCondenser"""))
    val generatorOrCondenserOrMotor: (Context) => String = parse_attribute (attribute ("""SynchronousMachineKind.generatorOrCondenserOrMotor"""))
    val generatorOrMotor: (Context) => String = parse_attribute (attribute ("""SynchronousMachineKind.generatorOrMotor"""))
    val motor: (Context) => String = parse_attribute (attribute ("""SynchronousMachineKind.motor"""))
    val motorOrCondenser: (Context) => String = parse_attribute (attribute ("""SynchronousMachineKind.motorOrCondenser"""))
    def parse (context: Context): SynchronousMachineKind =
    {
        SynchronousMachineKind(
            BasicElement.parse (context),
            condenser (context),
            generator (context),
            generatorOrCondenser (context),
            generatorOrCondenserOrMotor (context),
            generatorOrMotor (context),
            motor (context),
            motorOrCondenser (context)
        )
    }
}

/**
 * Synchronous machine operating mode.
 * @param sup Reference to the superclass object.
 * @param condenser <em>undocumented</em>
 * @param generator <em>undocumented</em>
 * @param motor <em>undocumented</em>
 */
case class SynchronousMachineOperatingMode
(
    override val sup: BasicElement,
    condenser: String,
    generator: String,
    motor: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[SynchronousMachineOperatingMode] }
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
        (if (null != condenser) "\t\t<cim:SynchronousMachineOperatingMode.condenser rdf:resource=\"#" + condenser + "\"/>\n" else "") +
        (if (null != generator) "\t\t<cim:SynchronousMachineOperatingMode.generator rdf:resource=\"#" + generator + "\"/>\n" else "") +
        (if (null != motor) "\t\t<cim:SynchronousMachineOperatingMode.motor rdf:resource=\"#" + motor + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SynchronousMachineOperatingMode rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SynchronousMachineOperatingMode>\n"
    }
}

object SynchronousMachineOperatingMode
extends
    Parseable[SynchronousMachineOperatingMode]
{
    val condenser: (Context) => String = parse_attribute (attribute ("""SynchronousMachineOperatingMode.condenser"""))
    val generator: (Context) => String = parse_attribute (attribute ("""SynchronousMachineOperatingMode.generator"""))
    val motor: (Context) => String = parse_attribute (attribute ("""SynchronousMachineOperatingMode.motor"""))
    def parse (context: Context): SynchronousMachineOperatingMode =
    {
        SynchronousMachineOperatingMode(
            BasicElement.parse (context),
            condenser (context),
            generator (context),
            motor (context)
        )
    }
}

/**
 * Mechanism for changing transformer winding tap positions.
 * @param sup Reference to the superclass object.
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
 * @param SvTapStep The tap step state associated with the tap changer.
 * @param TapChangerControl The regulating control scheme in which this tap changer participates.
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
    TapChangerControl: String
)
extends
    Element
{
    def this () = { this (null, false, 0, 0.0, 0, false, 0, 0.0, 0, 0.0, 0.0, null, null) }
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
        sup.export_fields +
        "\t\t<cim:TapChanger.controlEnabled>" + controlEnabled + "</cim:TapChanger.controlEnabled>\n" +
        "\t\t<cim:TapChanger.highStep>" + highStep + "</cim:TapChanger.highStep>\n" +
        "\t\t<cim:TapChanger.initialDelay>" + initialDelay + "</cim:TapChanger.initialDelay>\n" +
        "\t\t<cim:TapChanger.lowStep>" + lowStep + "</cim:TapChanger.lowStep>\n" +
        "\t\t<cim:TapChanger.ltcFlag>" + ltcFlag + "</cim:TapChanger.ltcFlag>\n" +
        "\t\t<cim:TapChanger.neutralStep>" + neutralStep + "</cim:TapChanger.neutralStep>\n" +
        "\t\t<cim:TapChanger.neutralU>" + neutralU + "</cim:TapChanger.neutralU>\n" +
        "\t\t<cim:TapChanger.normalStep>" + normalStep + "</cim:TapChanger.normalStep>\n" +
        "\t\t<cim:TapChanger.step>" + step + "</cim:TapChanger.step>\n" +
        "\t\t<cim:TapChanger.subsequentDelay>" + subsequentDelay + "</cim:TapChanger.subsequentDelay>\n" +
        (if (null != SvTapStep) "\t\t<cim:TapChanger.SvTapStep rdf:resource=\"#" + SvTapStep + "\"/>\n" else "") +
        (if (null != TapChangerControl) "\t\t<cim:TapChanger.TapChangerControl rdf:resource=\"#" + TapChangerControl + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TapChanger rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TapChanger>\n"
    }
}

object TapChanger
extends
    Parseable[TapChanger]
{
    val controlEnabled: (Context) => String = parse_element (element ("""TapChanger.controlEnabled"""))
    val highStep: (Context) => String = parse_element (element ("""TapChanger.highStep"""))
    val initialDelay: (Context) => String = parse_element (element ("""TapChanger.initialDelay"""))
    val lowStep: (Context) => String = parse_element (element ("""TapChanger.lowStep"""))
    val ltcFlag: (Context) => String = parse_element (element ("""TapChanger.ltcFlag"""))
    val neutralStep: (Context) => String = parse_element (element ("""TapChanger.neutralStep"""))
    val neutralU: (Context) => String = parse_element (element ("""TapChanger.neutralU"""))
    val normalStep: (Context) => String = parse_element (element ("""TapChanger.normalStep"""))
    val step: (Context) => String = parse_element (element ("""TapChanger.step"""))
    val subsequentDelay: (Context) => String = parse_element (element ("""TapChanger.subsequentDelay"""))
    val SvTapStep: (Context) => String = parse_attribute (attribute ("""TapChanger.SvTapStep"""))
    val TapChangerControl: (Context) => String = parse_attribute (attribute ("""TapChanger.TapChangerControl"""))
    def parse (context: Context): TapChanger =
    {
        TapChanger(
            PowerSystemResource.parse (context),
            toBoolean (controlEnabled (context), context),
            toInteger (highStep (context), context),
            toDouble (initialDelay (context), context),
            toInteger (lowStep (context), context),
            toBoolean (ltcFlag (context), context),
            toInteger (neutralStep (context), context),
            toDouble (neutralU (context), context),
            toInteger (normalStep (context), context),
            toDouble (step (context), context),
            toDouble (subsequentDelay (context), context),
            SvTapStep (context),
            TapChangerControl (context)
        )
    }
}

/**
 * Describes behavior specific to tap changers, e.g. how the voltage at the end of a line varies with the load level and compensation of the voltage drop by tap adjustment.
 * @param sup Reference to the superclass object.
 * @param limitVoltage Maximum allowed regulated voltage on the PT secondary, regardless of line drop compensation.
 *        Sometimes referred to as first-house protection.
 * @param lineDropCompensation If true, the line drop compensation is to be applied.
 * @param lineDropR Line drop compensator resistance setting for normal (forward) power flow.
 * @param lineDropX Line drop compensator reactance setting for normal (forward) power flow.
 * @param reverseLineDropR Line drop compensator resistance setting for reverse power flow.
 * @param reverseLineDropX Line drop compensator reactance setting for reverse power flow.
 */
case class TapChangerControl
(
    override val sup: RegulatingControl,
    limitVoltage: Double,
    lineDropCompensation: Boolean,
    lineDropR: Double,
    lineDropX: Double,
    reverseLineDropR: Double,
    reverseLineDropX: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, false, 0.0, 0.0, 0.0, 0.0) }
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
        sup.export_fields +
        "\t\t<cim:TapChangerControl.limitVoltage>" + limitVoltage + "</cim:TapChangerControl.limitVoltage>\n" +
        "\t\t<cim:TapChangerControl.lineDropCompensation>" + lineDropCompensation + "</cim:TapChangerControl.lineDropCompensation>\n" +
        "\t\t<cim:TapChangerControl.lineDropR>" + lineDropR + "</cim:TapChangerControl.lineDropR>\n" +
        "\t\t<cim:TapChangerControl.lineDropX>" + lineDropX + "</cim:TapChangerControl.lineDropX>\n" +
        "\t\t<cim:TapChangerControl.reverseLineDropR>" + reverseLineDropR + "</cim:TapChangerControl.reverseLineDropR>\n" +
        "\t\t<cim:TapChangerControl.reverseLineDropX>" + reverseLineDropX + "</cim:TapChangerControl.reverseLineDropX>\n"
    }
    override def export: String =
    {
        "\t<cim:TapChangerControl rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TapChangerControl>\n"
    }
}

object TapChangerControl
extends
    Parseable[TapChangerControl]
{
    val limitVoltage: (Context) => String = parse_element (element ("""TapChangerControl.limitVoltage"""))
    val lineDropCompensation: (Context) => String = parse_element (element ("""TapChangerControl.lineDropCompensation"""))
    val lineDropR: (Context) => String = parse_element (element ("""TapChangerControl.lineDropR"""))
    val lineDropX: (Context) => String = parse_element (element ("""TapChangerControl.lineDropX"""))
    val reverseLineDropR: (Context) => String = parse_element (element ("""TapChangerControl.reverseLineDropR"""))
    val reverseLineDropX: (Context) => String = parse_element (element ("""TapChangerControl.reverseLineDropX"""))
    def parse (context: Context): TapChangerControl =
    {
        TapChangerControl(
            RegulatingControl.parse (context),
            toDouble (limitVoltage (context), context),
            toBoolean (lineDropCompensation (context), context),
            toDouble (lineDropR (context), context),
            toDouble (lineDropX (context), context),
            toDouble (reverseLineDropR (context), context),
            toDouble (reverseLineDropX (context), context)
        )
    }
}

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
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0, 0.0) }
    def Element: Element = sup.asInstanceOf[Element]
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
        sup.export_fields +
        "\t\t<cim:TapChangerTablePoint.b>" + b + "</cim:TapChangerTablePoint.b>\n" +
        "\t\t<cim:TapChangerTablePoint.g>" + g + "</cim:TapChangerTablePoint.g>\n" +
        "\t\t<cim:TapChangerTablePoint.r>" + r + "</cim:TapChangerTablePoint.r>\n" +
        "\t\t<cim:TapChangerTablePoint.ratio>" + ratio + "</cim:TapChangerTablePoint.ratio>\n" +
        "\t\t<cim:TapChangerTablePoint.step>" + step + "</cim:TapChangerTablePoint.step>\n" +
        "\t\t<cim:TapChangerTablePoint.x>" + x + "</cim:TapChangerTablePoint.x>\n"
    }
    override def export: String =
    {
        "\t<cim:TapChangerTablePoint rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TapChangerTablePoint>\n"
    }
}

object TapChangerTablePoint
extends
    Parseable[TapChangerTablePoint]
{
    val b: (Context) => String = parse_element (element ("""TapChangerTablePoint.b"""))
    val g: (Context) => String = parse_element (element ("""TapChangerTablePoint.g"""))
    val r: (Context) => String = parse_element (element ("""TapChangerTablePoint.r"""))
    val ratio: (Context) => String = parse_element (element ("""TapChangerTablePoint.ratio"""))
    val step: (Context) => String = parse_element (element ("""TapChangerTablePoint.step"""))
    val x: (Context) => String = parse_element (element ("""TapChangerTablePoint.x"""))
    def parse (context: Context): TapChangerTablePoint =
    {
        TapChangerTablePoint(
            BasicElement.parse (context),
            toDouble (b (context), context),
            toDouble (g (context), context),
            toDouble (r (context), context),
            toDouble (ratio (context), context),
            toInteger (step (context), context),
            toDouble (x (context), context)
        )
    }
}

/**
 * A pre-established pattern over time for a tap step.
 * @param sup Reference to the superclass object.
 * @param TapChanger A TapSchedule is associated with a TapChanger.
 */
case class TapSchedule
(
    override val sup: SeasonDayTypeSchedule,
    TapChanger: String
)
extends
    Element
{
    def this () = { this (null, null) }
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
        sup.export_fields +
        (if (null != TapChanger) "\t\t<cim:TapSchedule.TapChanger rdf:resource=\"#" + TapChanger + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TapSchedule rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TapSchedule>\n"
    }
}

object TapSchedule
extends
    Parseable[TapSchedule]
{
    val TapChanger: (Context) => String = parse_attribute (attribute ("""TapSchedule.TapChanger"""))
    def parse (context: Context): TapSchedule =
    {
        TapSchedule(
            SeasonDayTypeSchedule.parse (context),
            TapChanger (context)
        )
    }
}

/**
 * Control modes for a transformer.
 * @param sup Reference to the superclass object.
 * @param reactive Reactive power flow control
 * @param volt Voltage control
 */
case class TransformerControlMode
(
    override val sup: BasicElement,
    reactive: String,
    volt: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[TransformerControlMode] }
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
        (if (null != reactive) "\t\t<cim:TransformerControlMode.reactive rdf:resource=\"#" + reactive + "\"/>\n" else "") +
        (if (null != volt) "\t\t<cim:TransformerControlMode.volt rdf:resource=\"#" + volt + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TransformerControlMode rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TransformerControlMode>\n"
    }
}

object TransformerControlMode
extends
    Parseable[TransformerControlMode]
{
    val reactive: (Context) => String = parse_attribute (attribute ("""TransformerControlMode.reactive"""))
    val volt: (Context) => String = parse_attribute (attribute ("""TransformerControlMode.volt"""))
    def parse (context: Context): TransformerControlMode =
    {
        TransformerControlMode(
            BasicElement.parse (context),
            reactive (context),
            volt (context)
        )
    }
}

/**
 * The transformer core admittance.
 * Used to specify the core admittance of a transformer in a manner that can be shared among power transformers.
 * @param sup Reference to the superclass object.
 * @param b Magnetizing branch susceptance (B mag).
 *        The value can be positive or negative.
 * @param b0 Zero sequence magnetizing branch susceptance.
 * @param g Magnetizing branch conductance (G mag).
 * @param g0 Zero sequence magnetizing branch conductance.
 * @param TransformerEndInfo Transformer end datasheet used to calculate this core admittance.
 */
case class TransformerCoreAdmittance
(
    override val sup: IdentifiedObject,
    b: Double,
    b0: Double,
    g: Double,
    g0: Double,
    TransformerEndInfo: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, null) }
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
        sup.export_fields +
        "\t\t<cim:TransformerCoreAdmittance.b>" + b + "</cim:TransformerCoreAdmittance.b>\n" +
        "\t\t<cim:TransformerCoreAdmittance.b0>" + b0 + "</cim:TransformerCoreAdmittance.b0>\n" +
        "\t\t<cim:TransformerCoreAdmittance.g>" + g + "</cim:TransformerCoreAdmittance.g>\n" +
        "\t\t<cim:TransformerCoreAdmittance.g0>" + g0 + "</cim:TransformerCoreAdmittance.g0>\n" +
        (if (null != TransformerEndInfo) "\t\t<cim:TransformerCoreAdmittance.TransformerEndInfo rdf:resource=\"#" + TransformerEndInfo + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TransformerCoreAdmittance rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TransformerCoreAdmittance>\n"
    }
}

object TransformerCoreAdmittance
extends
    Parseable[TransformerCoreAdmittance]
{
    val b: (Context) => String = parse_element (element ("""TransformerCoreAdmittance.b"""))
    val b0: (Context) => String = parse_element (element ("""TransformerCoreAdmittance.b0"""))
    val g: (Context) => String = parse_element (element ("""TransformerCoreAdmittance.g"""))
    val g0: (Context) => String = parse_element (element ("""TransformerCoreAdmittance.g0"""))
    val TransformerEndInfo: (Context) => String = parse_attribute (attribute ("""TransformerCoreAdmittance.TransformerEndInfo"""))
    def parse (context: Context): TransformerCoreAdmittance =
    {
        TransformerCoreAdmittance(
            IdentifiedObject.parse (context),
            toDouble (b (context), context),
            toDouble (b0 (context), context),
            toDouble (g (context), context),
            toDouble (g0 (context), context),
            TransformerEndInfo (context)
        )
    }
}

/**
 * A conducting connection point of a power transformer.
 * It corresponds to a physical transformer winding terminal.  In earlier CIM versions, the TransformerWinding class served a similar purpose, but this class is more flexible because it associates to terminal but is not a specialization of ConductingEquipment.
 * @param sup Reference to the superclass object.
 * @param bmagSat Core shunt magnetizing susceptance in the saturation region.
 * @param endNumber Number for this transformer end, corresponding to the end's order in the power transformer vector group or phase angle clock number.
 *        Highest voltage winding should be 1.  Each end within a power transformer should have a unique subsequent end number.   Note the transformer end number need not match the terminal sequence number.
 * @param grounded (for Yn and Zn connections) True if the neutral is solidly grounded.
 * @param magBaseU The reference voltage at which the magnetizing saturation measurements were made
 * @param magSatFlux Core magnetizing saturation curve knee flux level.
 * @param rground (for Yn and Zn connections) Resistance part of neutral impedance where 'grounded' is true.
 * @param xground (for Yn and Zn connections) Reactive part of neutral impedance where 'grounded' is true.
 * @param BaseVoltage Base voltage of the transformer end.
 *        This is essential for PU calculation.
 * @param CoreAdmittance Core admittance of this transformer end, representing magnetising current and core losses.
 *        The full values of the transformer should be supplied for one transformer end only.
 * @param PhaseTapChanger Phase tap changer associated with this transformer end.
 * @param RatioTapChanger Ratio tap changer associated with this transformer end.
 * @param StarImpedance (accurate for 2- or 3-winding transformers only) Pi-model impedances of this transformer end.
 *        By convention, for a two winding transformer, the full values of the transformer should be entered on the high voltage end (endNumber=1).
 * @param Terminal Terminal of the power transformer to which this transformer end belongs.
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
    PhaseTapChanger: String,
    RatioTapChanger: String,
    StarImpedance: String,
    Terminal: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0, false, 0.0, 0.0, 0.0, 0.0, null, null, null, null, null, null) }
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
        sup.export_fields +
        "\t\t<cim:TransformerEnd.bmagSat>" + bmagSat + "</cim:TransformerEnd.bmagSat>\n" +
        "\t\t<cim:TransformerEnd.endNumber>" + endNumber + "</cim:TransformerEnd.endNumber>\n" +
        "\t\t<cim:TransformerEnd.grounded>" + grounded + "</cim:TransformerEnd.grounded>\n" +
        "\t\t<cim:TransformerEnd.magBaseU>" + magBaseU + "</cim:TransformerEnd.magBaseU>\n" +
        "\t\t<cim:TransformerEnd.magSatFlux>" + magSatFlux + "</cim:TransformerEnd.magSatFlux>\n" +
        "\t\t<cim:TransformerEnd.rground>" + rground + "</cim:TransformerEnd.rground>\n" +
        "\t\t<cim:TransformerEnd.xground>" + xground + "</cim:TransformerEnd.xground>\n" +
        (if (null != BaseVoltage) "\t\t<cim:TransformerEnd.BaseVoltage rdf:resource=\"#" + BaseVoltage + "\"/>\n" else "") +
        (if (null != CoreAdmittance) "\t\t<cim:TransformerEnd.CoreAdmittance rdf:resource=\"#" + CoreAdmittance + "\"/>\n" else "") +
        (if (null != PhaseTapChanger) "\t\t<cim:TransformerEnd.PhaseTapChanger rdf:resource=\"#" + PhaseTapChanger + "\"/>\n" else "") +
        (if (null != RatioTapChanger) "\t\t<cim:TransformerEnd.RatioTapChanger rdf:resource=\"#" + RatioTapChanger + "\"/>\n" else "") +
        (if (null != StarImpedance) "\t\t<cim:TransformerEnd.StarImpedance rdf:resource=\"#" + StarImpedance + "\"/>\n" else "") +
        (if (null != Terminal) "\t\t<cim:TransformerEnd.Terminal rdf:resource=\"#" + Terminal + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TransformerEnd rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TransformerEnd>\n"
    }
}

object TransformerEnd
extends
    Parseable[TransformerEnd]
{
    val bmagSat: (Context) => String = parse_element (element ("""TransformerEnd.bmagSat"""))
    val endNumber: (Context) => String = parse_element (element ("""TransformerEnd.endNumber"""))
    val grounded: (Context) => String = parse_element (element ("""TransformerEnd.grounded"""))
    val magBaseU: (Context) => String = parse_element (element ("""TransformerEnd.magBaseU"""))
    val magSatFlux: (Context) => String = parse_element (element ("""TransformerEnd.magSatFlux"""))
    val rground: (Context) => String = parse_element (element ("""TransformerEnd.rground"""))
    val xground: (Context) => String = parse_element (element ("""TransformerEnd.xground"""))
    val BaseVoltage: (Context) => String = parse_attribute (attribute ("""TransformerEnd.BaseVoltage"""))
    val CoreAdmittance: (Context) => String = parse_attribute (attribute ("""TransformerEnd.CoreAdmittance"""))
    val PhaseTapChanger: (Context) => String = parse_attribute (attribute ("""TransformerEnd.PhaseTapChanger"""))
    val RatioTapChanger: (Context) => String = parse_attribute (attribute ("""TransformerEnd.RatioTapChanger"""))
    val StarImpedance: (Context) => String = parse_attribute (attribute ("""TransformerEnd.StarImpedance"""))
    val Terminal: (Context) => String = parse_attribute (attribute ("""TransformerEnd.Terminal"""))
    def parse (context: Context): TransformerEnd =
    {
        TransformerEnd(
            IdentifiedObject.parse (context),
            toDouble (bmagSat (context), context),
            toInteger (endNumber (context), context),
            toBoolean (grounded (context), context),
            toDouble (magBaseU (context), context),
            toDouble (magSatFlux (context), context),
            toDouble (rground (context), context),
            toDouble (xground (context), context),
            BaseVoltage (context),
            CoreAdmittance (context),
            PhaseTapChanger (context),
            RatioTapChanger (context),
            StarImpedance (context),
            Terminal (context)
        )
    }
}

/**
 * Transformer mesh impedance (Delta-model) between transformer ends.
 * The typical case is that this class describes the impedance between two transformer ends pair-wise, i.e. the cardinalities at both tranformer end associations are 1. But in cases where two or more transformer ends are modeled the cardinalities are larger than 1.
 * @param sup Reference to the superclass object.
 * @param r Resistance between the 'from' and the 'to' end, seen from the 'from' end.
 * @param r0 Zero-sequence resistance between the 'from' and the 'to' end, seen from the 'from' end.
 * @param x Reactance between the 'from' and the 'to' end, seen from the 'from' end.
 * @param x0 Zero-sequence reactance between the 'from' and the 'to' end, seen from the 'from' end.
 * @param FromTransformerEnd From end this mesh impedance is connected to.
 *        It determines the voltage reference.
 * @param FromTransformerEndInfo 'from' transformer end datasheet this mesh impedance is calculated from.
 *        It determines the voltage reference.
 */
case class TransformerMeshImpedance
(
    override val sup: IdentifiedObject,
    r: Double,
    r0: Double,
    x: Double,
    x0: Double,
    FromTransformerEnd: String,
    FromTransformerEndInfo: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, null, null) }
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
        sup.export_fields +
        "\t\t<cim:TransformerMeshImpedance.r>" + r + "</cim:TransformerMeshImpedance.r>\n" +
        "\t\t<cim:TransformerMeshImpedance.r0>" + r0 + "</cim:TransformerMeshImpedance.r0>\n" +
        "\t\t<cim:TransformerMeshImpedance.x>" + x + "</cim:TransformerMeshImpedance.x>\n" +
        "\t\t<cim:TransformerMeshImpedance.x0>" + x0 + "</cim:TransformerMeshImpedance.x0>\n" +
        (if (null != FromTransformerEnd) "\t\t<cim:TransformerMeshImpedance.FromTransformerEnd rdf:resource=\"#" + FromTransformerEnd + "\"/>\n" else "") +
        (if (null != FromTransformerEndInfo) "\t\t<cim:TransformerMeshImpedance.FromTransformerEndInfo rdf:resource=\"#" + FromTransformerEndInfo + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TransformerMeshImpedance rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TransformerMeshImpedance>\n"
    }
}

object TransformerMeshImpedance
extends
    Parseable[TransformerMeshImpedance]
{
    val r: (Context) => String = parse_element (element ("""TransformerMeshImpedance.r"""))
    val r0: (Context) => String = parse_element (element ("""TransformerMeshImpedance.r0"""))
    val x: (Context) => String = parse_element (element ("""TransformerMeshImpedance.x"""))
    val x0: (Context) => String = parse_element (element ("""TransformerMeshImpedance.x0"""))
    val FromTransformerEnd: (Context) => String = parse_attribute (attribute ("""TransformerMeshImpedance.FromTransformerEnd"""))
    val FromTransformerEndInfo: (Context) => String = parse_attribute (attribute ("""TransformerMeshImpedance.FromTransformerEndInfo"""))
    def parse (context: Context): TransformerMeshImpedance =
    {
        TransformerMeshImpedance(
            IdentifiedObject.parse (context),
            toDouble (r (context), context),
            toDouble (r0 (context), context),
            toDouble (x (context), context),
            toDouble (x0 (context), context),
            FromTransformerEnd (context),
            FromTransformerEndInfo (context)
        )
    }
}

/**
 * Transformer star impedance (Pi-model) that accurately reflects impedance for transformers with 2 or 3 windings.
 * For transformers with 4 or more windings, you must use TransformerMeshImpedance class.
 * @param sup Reference to the superclass object.
 * @param r Resistance of the transformer end.
 * @param r0 Zero sequence series resistance of the transformer end.
 * @param x Positive sequence series reactance of the transformer end.
 * @param x0 Zero sequence series reactance of the transformer end.
 * @param TransformerEndInfo Transformer end datasheet used to calculate this transformer star impedance.
 */
case class TransformerStarImpedance
(
    override val sup: IdentifiedObject,
    r: Double,
    r0: Double,
    x: Double,
    x0: Double,
    TransformerEndInfo: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, null) }
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
        sup.export_fields +
        "\t\t<cim:TransformerStarImpedance.r>" + r + "</cim:TransformerStarImpedance.r>\n" +
        "\t\t<cim:TransformerStarImpedance.r0>" + r0 + "</cim:TransformerStarImpedance.r0>\n" +
        "\t\t<cim:TransformerStarImpedance.x>" + x + "</cim:TransformerStarImpedance.x>\n" +
        "\t\t<cim:TransformerStarImpedance.x0>" + x0 + "</cim:TransformerStarImpedance.x0>\n" +
        (if (null != TransformerEndInfo) "\t\t<cim:TransformerStarImpedance.TransformerEndInfo rdf:resource=\"#" + TransformerEndInfo + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TransformerStarImpedance rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TransformerStarImpedance>\n"
    }
}

object TransformerStarImpedance
extends
    Parseable[TransformerStarImpedance]
{
    val r: (Context) => String = parse_element (element ("""TransformerStarImpedance.r"""))
    val r0: (Context) => String = parse_element (element ("""TransformerStarImpedance.r0"""))
    val x: (Context) => String = parse_element (element ("""TransformerStarImpedance.x"""))
    val x0: (Context) => String = parse_element (element ("""TransformerStarImpedance.x0"""))
    val TransformerEndInfo: (Context) => String = parse_attribute (attribute ("""TransformerStarImpedance.TransformerEndInfo"""))
    def parse (context: Context): TransformerStarImpedance =
    {
        TransformerStarImpedance(
            IdentifiedObject.parse (context),
            toDouble (r (context), context),
            toDouble (r0 (context), context),
            toDouble (x (context), context),
            toDouble (x0 (context), context),
            TransformerEndInfo (context)
        )
    }
}

/**
 * An assembly of two or more coupled windings that transform electrical power between voltage levels.
 * These windings are bound on a common core and place in the same tank. Transformer tank can be used to model both single-phase and 3-phase transformers.
 * @param sup Reference to the superclass object.
 * @param PowerTransformer Bank this transformer belongs to.
 */
case class TransformerTank
(
    override val sup: Equipment,
    PowerTransformer: String
)
extends
    Element
{
    def this () = { this (null, null) }
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
        sup.export_fields +
        (if (null != PowerTransformer) "\t\t<cim:TransformerTank.PowerTransformer rdf:resource=\"#" + PowerTransformer + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TransformerTank rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TransformerTank>\n"
    }
}

object TransformerTank
extends
    Parseable[TransformerTank]
{
    val PowerTransformer: (Context) => String = parse_attribute (attribute ("""TransformerTank.PowerTransformer"""))
    def parse (context: Context): TransformerTank =
    {
        TransformerTank(
            Equipment.parse (context),
            PowerTransformer (context)
        )
    }
}

/**
 * Transformer tank end represents an individual winding for unbalanced models or for transformer tanks connected into a bank (and bank is modelled with the PowerTransformer).
 * @param sup Reference to the superclass object.
 * @param phases Describes the phases carried by a conducting equipment.
 * @param TransformerTank Transformer this winding belongs to.
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
    def this () = { this (null, null, null) }
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
        sup.export_fields +
        (if (null != phases) "\t\t<cim:TransformerTankEnd.phases rdf:resource=\"#" + phases + "\"/>\n" else "") +
        (if (null != TransformerTank) "\t\t<cim:TransformerTankEnd.TransformerTank rdf:resource=\"#" + TransformerTank + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TransformerTankEnd rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TransformerTankEnd>\n"
    }
}

object TransformerTankEnd
extends
    Parseable[TransformerTankEnd]
{
    val phases: (Context) => String = parse_attribute (attribute ("""TransformerTankEnd.phases"""))
    val TransformerTank: (Context) => String = parse_attribute (attribute ("""TransformerTankEnd.TransformerTank"""))
    def parse (context: Context): TransformerTankEnd =
    {
        TransformerTankEnd(
            TransformerEnd.parse (context),
            phases (context),
            TransformerTank (context)
        )
    }
}

/**
 * An area of the power system network which is defined for secondary voltage control purposes.
 * A voltage control zone consists of a collection of substations with a designated bus bar section whose voltage will be controlled.
 * @param sup Reference to the superclass object.
 * @param BusbarSection A VoltageControlZone is controlled by a designated BusbarSection.
 * @param RegulationSchedule A VoltageControlZone may have a  voltage regulation schedule.
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
    def this () = { this (null, null, null) }
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
        sup.export_fields +
        (if (null != BusbarSection) "\t\t<cim:VoltageControlZone.BusbarSection rdf:resource=\"#" + BusbarSection + "\"/>\n" else "") +
        (if (null != RegulationSchedule) "\t\t<cim:VoltageControlZone.RegulationSchedule rdf:resource=\"#" + RegulationSchedule + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:VoltageControlZone rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:VoltageControlZone>\n"
    }
}

object VoltageControlZone
extends
    Parseable[VoltageControlZone]
{
    val BusbarSection: (Context) => String = parse_attribute (attribute ("""VoltageControlZone.BusbarSection"""))
    val RegulationSchedule: (Context) => String = parse_attribute (attribute ("""VoltageControlZone.RegulationSchedule"""))
    def parse (context: Context): VoltageControlZone =
    {
        VoltageControlZone(
            PowerSystemResource.parse (context),
            BusbarSection (context),
            RegulationSchedule (context)
        )
    }
}

/**
 * Winding connection type.
 * @param sup Reference to the superclass object.
 * @param A Autotransformer common winding
 * @param D Delta
 * @param I Independent winding, for single-phase connections
 * @param Y Wye
 * @param Yn Wye, with neutral brought out for grounding.
 * @param Z ZigZag
 * @param Zn ZigZag, with neutral brought out for grounding.
 */
case class WindingConnection
(
    override val sup: BasicElement,
    A: String,
    D: String,
    I: String,
    Y: String,
    Yn: String,
    Z: String,
    Zn: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[WindingConnection] }
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
        (if (null != A) "\t\t<cim:WindingConnection.A rdf:resource=\"#" + A + "\"/>\n" else "") +
        (if (null != D) "\t\t<cim:WindingConnection.D rdf:resource=\"#" + D + "\"/>\n" else "") +
        (if (null != I) "\t\t<cim:WindingConnection.I rdf:resource=\"#" + I + "\"/>\n" else "") +
        (if (null != Y) "\t\t<cim:WindingConnection.Y rdf:resource=\"#" + Y + "\"/>\n" else "") +
        (if (null != Yn) "\t\t<cim:WindingConnection.Yn rdf:resource=\"#" + Yn + "\"/>\n" else "") +
        (if (null != Z) "\t\t<cim:WindingConnection.Z rdf:resource=\"#" + Z + "\"/>\n" else "") +
        (if (null != Zn) "\t\t<cim:WindingConnection.Zn rdf:resource=\"#" + Zn + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WindingConnection rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WindingConnection>\n"
    }
}

object WindingConnection
extends
    Parseable[WindingConnection]
{
    val A: (Context) => String = parse_attribute (attribute ("""WindingConnection.A"""))
    val D: (Context) => String = parse_attribute (attribute ("""WindingConnection.D"""))
    val I: (Context) => String = parse_attribute (attribute ("""WindingConnection.I"""))
    val Y: (Context) => String = parse_attribute (attribute ("""WindingConnection.Y"""))
    val Yn: (Context) => String = parse_attribute (attribute ("""WindingConnection.Yn"""))
    val Z: (Context) => String = parse_attribute (attribute ("""WindingConnection.Z"""))
    val Zn: (Context) => String = parse_attribute (attribute ("""WindingConnection.Zn"""))
    def parse (context: Context): WindingConnection =
    {
        WindingConnection(
            BasicElement.parse (context),
            A (context),
            D (context),
            I (context),
            Y (context),
            Yn (context),
            Z (context),
            Zn (context)
        )
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
            AsynchronousMachineKind.register,
            Breaker.register,
            BusbarSection.register,
            Clamp.register,
            CompositeSwitch.register,
            Conductor.register,
            Connector.register,
            CoolantType.register,
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
            PetersenCoilModeKind.register,
            PhaseImpedanceData.register,
            PhaseShuntConnectionKind.register,
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
            RegulatingControlModeKind.register,
            RegulationSchedule.register,
            RotatingMachine.register,
            SVCControlMode.register,
            Sectionaliser.register,
            SeriesCompensator.register,
            ShortCircuitRotorKind.register,
            ShuntCompensator.register,
            ShuntCompensatorPhase.register,
            SinglePhaseKind.register,
            StaticVarCompensator.register,
            Switch.register,
            SwitchPhase.register,
            SwitchSchedule.register,
            SynchronousMachine.register,
            SynchronousMachineKind.register,
            SynchronousMachineOperatingMode.register,
            TapChanger.register,
            TapChangerControl.register,
            TapChangerTablePoint.register,
            TapSchedule.register,
            TransformerControlMode.register,
            TransformerCoreAdmittance.register,
            TransformerEnd.register,
            TransformerMeshImpedance.register,
            TransformerStarImpedance.register,
            TransformerTank.register,
            TransformerTankEnd.register,
            VoltageControlZone.register,
            WindingConnection.register
        )
    }
}