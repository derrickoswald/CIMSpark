package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

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
    val b0ch: Double,
    val bch: Double,
    val g0ch: Double,
    val gch: Double,
    val r: Double,
    val r0: Double,
    val shortCircuitEndTemperature: Double,
    val x: Double,
    val x0: Double,
    val LineGroundingAction: String,
    val LineJumpingAction: String,
    val PerLengthImpedance: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, null) }
    def Conductor: Conductor = sup.asInstanceOf[Conductor]
    override def copy (): Row = { return (clone ().asInstanceOf[ACLineSegment]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ACLineSegment
extends
    Parseable[ACLineSegment]
{
    val sup = Conductor.parse _
    val b0ch = parse_element (element ("""ACLineSegment.b0ch"""))
    val bch = parse_element (element ("""ACLineSegment.bch"""))
    val g0ch = parse_element (element ("""ACLineSegment.g0ch"""))
    val gch = parse_element (element ("""ACLineSegment.gch"""))
    val r = parse_element (element ("""ACLineSegment.r"""))
    val r0 = parse_element (element ("""ACLineSegment.r0"""))
    val shortCircuitEndTemperature = parse_element (element ("""ACLineSegment.shortCircuitEndTemperature"""))
    val x = parse_element (element ("""ACLineSegment.x"""))
    val x0 = parse_element (element ("""ACLineSegment.x0"""))
    val LineGroundingAction = parse_attribute (attribute ("""ACLineSegment.LineGroundingAction"""))
    val LineJumpingAction = parse_attribute (attribute ("""ACLineSegment.LineJumpingAction"""))
    val PerLengthImpedance = parse_attribute (attribute ("""ACLineSegment.PerLengthImpedance"""))
    def parse (context: Context): ACLineSegment =
    {
        ACLineSegment(
            sup (context),
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
    val phase: String,
    val ACLineSegment: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { return (clone ().asInstanceOf[ACLineSegmentPhase]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ACLineSegmentPhase
extends
    Parseable[ACLineSegmentPhase]
{
    val sup = PowerSystemResource.parse _
    val phase = parse_attribute (attribute ("""ACLineSegmentPhase.phase"""))
    val ACLineSegment = parse_attribute (attribute ("""ACLineSegmentPhase.ACLineSegment"""))
    def parse (context: Context): ACLineSegmentPhase =
    {
        ACLineSegmentPhase(
            sup (context),
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
    val asynchronousMachineType: String,
    val converterFedDrive: Boolean,
    val efficiency: Double,
    val iaIrRatio: Double,
    val nominalFrequency: Double,
    val nominalSpeed: Double,
    val polePairNumber: Int,
    val ratedMechanicalPower: Double,
    val reversible: Boolean,
    val rr1: Double,
    val rr2: Double,
    val rxLockedRotorRatio: Double,
    val tpo: Double,
    val tppo: Double,
    val xlr1: Double,
    val xlr2: Double,
    val xm: Double,
    val xp: Double,
    val xpp: Double,
    val xs: Double,
    val AsynchronousMachineDynamics: String
)
extends
    Element
{
    def this () = { this (null, null, false, 0.0, 0.0, 0.0, 0.0, 0, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null) }
    def RotatingMachine: RotatingMachine = sup.asInstanceOf[RotatingMachine]
    override def copy (): Row = { return (clone ().asInstanceOf[AsynchronousMachine]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AsynchronousMachine
extends
    Parseable[AsynchronousMachine]
{
    val sup = RotatingMachine.parse _
    val asynchronousMachineType = parse_attribute (attribute ("""AsynchronousMachine.asynchronousMachineType"""))
    val converterFedDrive = parse_element (element ("""AsynchronousMachine.converterFedDrive"""))
    val efficiency = parse_element (element ("""AsynchronousMachine.efficiency"""))
    val iaIrRatio = parse_element (element ("""AsynchronousMachine.iaIrRatio"""))
    val nominalFrequency = parse_element (element ("""AsynchronousMachine.nominalFrequency"""))
    val nominalSpeed = parse_element (element ("""AsynchronousMachine.nominalSpeed"""))
    val polePairNumber = parse_element (element ("""AsynchronousMachine.polePairNumber"""))
    val ratedMechanicalPower = parse_element (element ("""AsynchronousMachine.ratedMechanicalPower"""))
    val reversible = parse_element (element ("""AsynchronousMachine.reversible"""))
    val rr1 = parse_element (element ("""AsynchronousMachine.rr1"""))
    val rr2 = parse_element (element ("""AsynchronousMachine.rr2"""))
    val rxLockedRotorRatio = parse_element (element ("""AsynchronousMachine.rxLockedRotorRatio"""))
    val tpo = parse_element (element ("""AsynchronousMachine.tpo"""))
    val tppo = parse_element (element ("""AsynchronousMachine.tppo"""))
    val xlr1 = parse_element (element ("""AsynchronousMachine.xlr1"""))
    val xlr2 = parse_element (element ("""AsynchronousMachine.xlr2"""))
    val xm = parse_element (element ("""AsynchronousMachine.xm"""))
    val xp = parse_element (element ("""AsynchronousMachine.xp"""))
    val xpp = parse_element (element ("""AsynchronousMachine.xpp"""))
    val xs = parse_element (element ("""AsynchronousMachine.xs"""))
    val AsynchronousMachineDynamics = parse_attribute (attribute ("""AsynchronousMachine.AsynchronousMachineDynamics"""))
    def parse (context: Context): AsynchronousMachine =
    {
        AsynchronousMachine(
            sup (context),
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
    val generator: String,
    val motor: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[AsynchronousMachineKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AsynchronousMachineKind
extends
    Parseable[AsynchronousMachineKind]
{
    val sup = BasicElement.parse _
    val generator = parse_attribute (attribute ("""AsynchronousMachineKind.generator"""))
    val motor = parse_attribute (attribute ("""AsynchronousMachineKind.motor"""))
    def parse (context: Context): AsynchronousMachineKind =
    {
        AsynchronousMachineKind(
            sup (context),
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
    val inTransitTime: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
    def ProtectedSwitch: ProtectedSwitch = sup.asInstanceOf[ProtectedSwitch]
    override def copy (): Row = { return (clone ().asInstanceOf[Breaker]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Breaker
extends
    Parseable[Breaker]
{
    val sup = ProtectedSwitch.parse _
    val inTransitTime = parse_element (element ("""Breaker.inTransitTime"""))
    def parse (context: Context): Breaker =
    {
        Breaker(
            sup (context),
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
    val ipMax: Double,
    val VoltageControlZone: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null) }
    def Connector: Connector = sup.asInstanceOf[Connector]
    override def copy (): Row = { return (clone ().asInstanceOf[BusbarSection]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BusbarSection
extends
    Parseable[BusbarSection]
{
    val sup = Connector.parse _
    val ipMax = parse_element (element ("""BusbarSection.ipMax"""))
    val VoltageControlZone = parse_attribute (attribute ("""BusbarSection.VoltageControlZone"""))
    def parse (context: Context): BusbarSection =
    {
        BusbarSection(
            sup (context),
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
    val lengthFromTerminal1: Double,
    val ACLineSegment: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null) }
    def ConductingEquipment: ConductingEquipment = sup.asInstanceOf[ConductingEquipment]
    override def copy (): Row = { return (clone ().asInstanceOf[Clamp]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Clamp
extends
    Parseable[Clamp]
{
    val sup = ConductingEquipment.parse _
    val lengthFromTerminal1 = parse_element (element ("""Clamp.lengthFromTerminal1"""))
    val ACLineSegment = parse_attribute (attribute ("""Clamp.ACLineSegment"""))
    def parse (context: Context): Clamp =
    {
        Clamp(
            sup (context),
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
    val compositeSwitchType: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Equipment: Equipment = sup.asInstanceOf[Equipment]
    override def copy (): Row = { return (clone ().asInstanceOf[CompositeSwitch]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CompositeSwitch
extends
    Parseable[CompositeSwitch]
{
    val sup = Equipment.parse _
    val compositeSwitchType = parse_element (element ("""CompositeSwitch.compositeSwitchType"""))
    def parse (context: Context): CompositeSwitch =
    {
        CompositeSwitch(
            sup (context),
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
    val len: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
    def ConductingEquipment: ConductingEquipment = sup.asInstanceOf[ConductingEquipment]
    override def copy (): Row = { return (clone ().asInstanceOf[Conductor]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Conductor
extends
    Parseable[Conductor]
{
    val sup = ConductingEquipment.parse _
    val len = parse_element (element ("""Conductor.length"""))
    def parse (context: Context): Conductor =
    {
        Conductor(
            sup (context),
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
    override def copy (): Row = { return (clone ().asInstanceOf[Connector]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Connector
extends
    Parseable[Connector]
{
    val sup = ConductingEquipment.parse _
    def parse (context: Context): Connector =
    {
        Connector(
            sup (context)
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
    val air: String,
    val hydrogenGas: String,
    val water: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[CoolantType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CoolantType
extends
    Parseable[CoolantType]
{
    val sup = BasicElement.parse _
    val air = parse_attribute (attribute ("""CoolantType.air"""))
    val hydrogenGas = parse_attribute (attribute ("""CoolantType.hydrogenGas"""))
    val water = parse_attribute (attribute ("""CoolantType.water"""))
    def parse (context: Context): CoolantType =
    {
        CoolantType(
            sup (context),
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
    val lengthFromTerminal1: Double,
    val ACLineSegment: String,
    val CutAction: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null) }
    def Switch: Switch = sup.asInstanceOf[Switch]
    override def copy (): Row = { return (clone ().asInstanceOf[Cut]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Cut
extends
    Parseable[Cut]
{
    val sup = Switch.parse _
    val lengthFromTerminal1 = parse_element (element ("""Cut.lengthFromTerminal1"""))
    val ACLineSegment = parse_attribute (attribute ("""Cut.ACLineSegment"""))
    val CutAction = parse_attribute (attribute ("""Cut.CutAction"""))
    def parse (context: Context): Cut =
    {
        Cut(
            sup (context),
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
    override def copy (): Row = { return (clone ().asInstanceOf[Disconnector]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Disconnector
extends
    Parseable[Disconnector]
{
    val sup = Switch.parse _
    def parse (context: Context): Disconnector =
    {
        Disconnector(
            sup (context)
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
    val r: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
    def ConductingEquipment: ConductingEquipment = sup.asInstanceOf[ConductingEquipment]
    override def copy (): Row = { return (clone ().asInstanceOf[EarthFaultCompensator]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EarthFaultCompensator
extends
    Parseable[EarthFaultCompensator]
{
    val sup = ConductingEquipment.parse _
    val r = parse_element (element ("""EarthFaultCompensator.r"""))
    def parse (context: Context): EarthFaultCompensator =
    {
        EarthFaultCompensator(
            sup (context),
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
    val customerCount: Int,
    val grounded: Boolean,
    val p: Double,
    val pfixed: Double,
    val pfixedPct: Double,
    val phaseConnection: String,
    val q: Double,
    val qfixed: Double,
    val qfixedPct: Double,
    val LoadDynamics: String,
    val LoadResponse: String,
    val PowerCutZone: String
)
extends
    Element
{
    def this () = { this (null, 0, false, 0.0, 0.0, 0.0, null, 0.0, 0.0, 0.0, null, null, null) }
    def ConductingEquipment: ConductingEquipment = sup.asInstanceOf[ConductingEquipment]
    override def copy (): Row = { return (clone ().asInstanceOf[EnergyConsumer]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EnergyConsumer
extends
    Parseable[EnergyConsumer]
{
    val sup = ConductingEquipment.parse _
    val customerCount = parse_element (element ("""EnergyConsumer.customerCount"""))
    val grounded = parse_element (element ("""EnergyConsumer.grounded"""))
    val p = parse_element (element ("""EnergyConsumer.p"""))
    val pfixed = parse_element (element ("""EnergyConsumer.pfixed"""))
    val pfixedPct = parse_element (element ("""EnergyConsumer.pfixedPct"""))
    val phaseConnection = parse_attribute (attribute ("""EnergyConsumer.phaseConnection"""))
    val q = parse_element (element ("""EnergyConsumer.q"""))
    val qfixed = parse_element (element ("""EnergyConsumer.qfixed"""))
    val qfixedPct = parse_element (element ("""EnergyConsumer.qfixedPct"""))
    val LoadDynamics = parse_attribute (attribute ("""EnergyConsumer.LoadDynamics"""))
    val LoadResponse = parse_attribute (attribute ("""EnergyConsumer.LoadResponse"""))
    val PowerCutZone = parse_attribute (attribute ("""EnergyConsumer.PowerCutZone"""))
    def parse (context: Context): EnergyConsumer =
    {
        EnergyConsumer(
            sup (context),
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
    val pfixed: Double,
    val pfixedPct: Double,
    val phase: String,
    val qfixed: Double,
    val qfixedPct: Double,
    val EnergyConsumer: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null, 0.0, 0.0, null) }
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { return (clone ().asInstanceOf[EnergyConsumerPhase]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EnergyConsumerPhase
extends
    Parseable[EnergyConsumerPhase]
{
    val sup = PowerSystemResource.parse _
    val pfixed = parse_element (element ("""EnergyConsumerPhase.pfixed"""))
    val pfixedPct = parse_element (element ("""EnergyConsumerPhase.pfixedPct"""))
    val phase = parse_attribute (attribute ("""EnergyConsumerPhase.phase"""))
    val qfixed = parse_element (element ("""EnergyConsumerPhase.qfixed"""))
    val qfixedPct = parse_element (element ("""EnergyConsumerPhase.qfixedPct"""))
    val EnergyConsumer = parse_attribute (attribute ("""EnergyConsumerPhase.EnergyConsumer"""))
    def parse (context: Context): EnergyConsumerPhase =
    {
        EnergyConsumerPhase(
            sup (context),
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
    val activePower: Double,
    val nominalVoltage: Double,
    val r: Double,
    val r0: Double,
    val reactivePower: Double,
    val rn: Double,
    val voltageAngle: Double,
    val voltageMagnitude: Double,
    val x: Double,
    val x0: Double,
    val xn: Double,
    val EnergySchedulingType: String,
    val EnergySourceAction: String,
    val WindTurbineType3or4Dynamics: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, null) }
    def ConductingEquipment: ConductingEquipment = sup.asInstanceOf[ConductingEquipment]
    override def copy (): Row = { return (clone ().asInstanceOf[EnergySource]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EnergySource
extends
    Parseable[EnergySource]
{
    val sup = ConductingEquipment.parse _
    val activePower = parse_element (element ("""EnergySource.activePower"""))
    val nominalVoltage = parse_element (element ("""EnergySource.nominalVoltage"""))
    val r = parse_element (element ("""EnergySource.r"""))
    val r0 = parse_element (element ("""EnergySource.r0"""))
    val reactivePower = parse_element (element ("""EnergySource.reactivePower"""))
    val rn = parse_element (element ("""EnergySource.rn"""))
    val voltageAngle = parse_element (element ("""EnergySource.voltageAngle"""))
    val voltageMagnitude = parse_element (element ("""EnergySource.voltageMagnitude"""))
    val x = parse_element (element ("""EnergySource.x"""))
    val x0 = parse_element (element ("""EnergySource.x0"""))
    val xn = parse_element (element ("""EnergySource.xn"""))
    val EnergySchedulingType = parse_attribute (attribute ("""EnergySource.EnergySchedulingType"""))
    val EnergySourceAction = parse_attribute (attribute ("""EnergySource.EnergySourceAction"""))
    val WindTurbineType3or4Dynamics = parse_attribute (attribute ("""EnergySource.WindTurbineType3or4Dynamics"""))
    def parse (context: Context): EnergySource =
    {
        EnergySource(
            sup (context),
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
    val governorSCD: Double,
    val ikSecond: Boolean,
    val maxInitialSymShCCurrent: Double,
    val maxP: Double,
    val maxQ: Double,
    val maxR0ToX0Ratio: Double,
    val maxR1ToX1Ratio: Double,
    val maxZ0ToZ1Ratio: Double,
    val minInitialSymShCCurrent: Double,
    val minP: Double,
    val minQ: Double,
    val minR0ToX0Ratio: Double,
    val minR1ToX1Ratio: Double,
    val minZ0ToZ1Ratio: Double,
    val p: Double,
    val q: Double,
    val referencePriority: Int,
    val voltageFactor: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0, 0.0) }
    def RegulatingCondEq: RegulatingCondEq = sup.asInstanceOf[RegulatingCondEq]
    override def copy (): Row = { return (clone ().asInstanceOf[ExternalNetworkInjection]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExternalNetworkInjection
extends
    Parseable[ExternalNetworkInjection]
{
    val sup = RegulatingCondEq.parse _
    val governorSCD = parse_element (element ("""ExternalNetworkInjection.governorSCD"""))
    val ikSecond = parse_element (element ("""ExternalNetworkInjection.ikSecond"""))
    val maxInitialSymShCCurrent = parse_element (element ("""ExternalNetworkInjection.maxInitialSymShCCurrent"""))
    val maxP = parse_element (element ("""ExternalNetworkInjection.maxP"""))
    val maxQ = parse_element (element ("""ExternalNetworkInjection.maxQ"""))
    val maxR0ToX0Ratio = parse_element (element ("""ExternalNetworkInjection.maxR0ToX0Ratio"""))
    val maxR1ToX1Ratio = parse_element (element ("""ExternalNetworkInjection.maxR1ToX1Ratio"""))
    val maxZ0ToZ1Ratio = parse_element (element ("""ExternalNetworkInjection.maxZ0ToZ1Ratio"""))
    val minInitialSymShCCurrent = parse_element (element ("""ExternalNetworkInjection.minInitialSymShCCurrent"""))
    val minP = parse_element (element ("""ExternalNetworkInjection.minP"""))
    val minQ = parse_element (element ("""ExternalNetworkInjection.minQ"""))
    val minR0ToX0Ratio = parse_element (element ("""ExternalNetworkInjection.minR0ToX0Ratio"""))
    val minR1ToX1Ratio = parse_element (element ("""ExternalNetworkInjection.minR1ToX1Ratio"""))
    val minZ0ToZ1Ratio = parse_element (element ("""ExternalNetworkInjection.minZ0ToZ1Ratio"""))
    val p = parse_element (element ("""ExternalNetworkInjection.p"""))
    val q = parse_element (element ("""ExternalNetworkInjection.q"""))
    val referencePriority = parse_element (element ("""ExternalNetworkInjection.referencePriority"""))
    val voltageFactor = parse_element (element ("""ExternalNetworkInjection.voltageFactor"""))
    def parse (context: Context): ExternalNetworkInjection =
    {
        ExternalNetworkInjection(
            sup (context),
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
    val frequency: Double,
    val maxP: Double,
    val maxU: Double,
    val minP: Double,
    val minU: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def RegulatingCondEq: RegulatingCondEq = sup.asInstanceOf[RegulatingCondEq]
    override def copy (): Row = { return (clone ().asInstanceOf[FrequencyConverter]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object FrequencyConverter
extends
    Parseable[FrequencyConverter]
{
    val sup = RegulatingCondEq.parse _
    val frequency = parse_element (element ("""FrequencyConverter.frequency"""))
    val maxP = parse_element (element ("""FrequencyConverter.maxP"""))
    val maxU = parse_element (element ("""FrequencyConverter.maxU"""))
    val minP = parse_element (element ("""FrequencyConverter.minP"""))
    val minU = parse_element (element ("""FrequencyConverter.minU"""))
    def parse (context: Context): FrequencyConverter =
    {
        FrequencyConverter(
            sup (context),
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
    override def copy (): Row = { return (clone ().asInstanceOf[Fuse]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Fuse
extends
    Parseable[Fuse]
{
    val sup = Switch.parse _
    def parse (context: Context): Fuse =
    {
        Fuse(
            sup (context)
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
    val GroundAction: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def ConductingEquipment: ConductingEquipment = sup.asInstanceOf[ConductingEquipment]
    override def copy (): Row = { return (clone ().asInstanceOf[Ground]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Ground
extends
    Parseable[Ground]
{
    val sup = ConductingEquipment.parse _
    val GroundAction = parse_attribute (attribute ("""Ground.GroundAction"""))
    def parse (context: Context): Ground =
    {
        Ground(
            sup (context),
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
    override def copy (): Row = { return (clone ().asInstanceOf[GroundDisconnector]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GroundDisconnector
extends
    Parseable[GroundDisconnector]
{
    val sup = Switch.parse _
    def parse (context: Context): GroundDisconnector =
    {
        GroundDisconnector(
            sup (context)
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
    val x: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
    def EarthFaultCompensator: EarthFaultCompensator = sup.asInstanceOf[EarthFaultCompensator]
    override def copy (): Row = { return (clone ().asInstanceOf[GroundingImpedance]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GroundingImpedance
extends
    Parseable[GroundingImpedance]
{
    val sup = EarthFaultCompensator.parse _
    val x = parse_element (element ("""GroundingImpedance.x"""))
    def parse (context: Context): GroundingImpedance =
    {
        GroundingImpedance(
            sup (context),
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
    val JumperAction: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Switch: Switch = sup.asInstanceOf[Switch]
    override def copy (): Row = { return (clone ().asInstanceOf[Jumper]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Jumper
extends
    Parseable[Jumper]
{
    val sup = Switch.parse _
    val JumperAction = parse_attribute (attribute ("""Jumper.JumperAction"""))
    def parse (context: Context): Jumper =
    {
        Jumper(
            sup (context),
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
    override def copy (): Row = { return (clone ().asInstanceOf[Junction]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Junction
extends
    Parseable[Junction]
{
    val sup = Connector.parse _
    def parse (context: Context): Junction =
    {
        Junction(
            sup (context)
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
    val Region: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def EquipmentContainer: EquipmentContainer = sup.asInstanceOf[EquipmentContainer]
    override def copy (): Row = { return (clone ().asInstanceOf[Line]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Line
extends
    Parseable[Line]
{
    val sup = EquipmentContainer.parse _
    val Region = parse_attribute (attribute ("""Line.Region"""))
    def parse (context: Context): Line =
    {
        Line(
            sup (context),
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
    val b0PerSection: Double,
    val bPerSection: Double,
    val g0PerSection: Double,
    val gPerSection: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0) }
    def ShuntCompensator: ShuntCompensator = sup.asInstanceOf[ShuntCompensator]
    override def copy (): Row = { return (clone ().asInstanceOf[LinearShuntCompensator]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object LinearShuntCompensator
extends
    Parseable[LinearShuntCompensator]
{
    val sup = ShuntCompensator.parse _
    val b0PerSection = parse_element (element ("""LinearShuntCompensator.b0PerSection"""))
    val bPerSection = parse_element (element ("""LinearShuntCompensator.bPerSection"""))
    val g0PerSection = parse_element (element ("""LinearShuntCompensator.g0PerSection"""))
    val gPerSection = parse_element (element ("""LinearShuntCompensator.gPerSection"""))
    def parse (context: Context): LinearShuntCompensator =
    {
        LinearShuntCompensator(
            sup (context),
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
    val bPerSection: Double,
    val gPerSection: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0) }
    def ShuntCompensatorPhase: ShuntCompensatorPhase = sup.asInstanceOf[ShuntCompensatorPhase]
    override def copy (): Row = { return (clone ().asInstanceOf[LinearShuntCompensatorPhase]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object LinearShuntCompensatorPhase
extends
    Parseable[LinearShuntCompensatorPhase]
{
    val sup = ShuntCompensatorPhase.parse _
    val bPerSection = parse_element (element ("""LinearShuntCompensatorPhase.bPerSection"""))
    val gPerSection = parse_element (element ("""LinearShuntCompensatorPhase.gPerSection"""))
    def parse (context: Context): LinearShuntCompensatorPhase =
    {
        LinearShuntCompensatorPhase(
            sup (context),
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
    override def copy (): Row = { return (clone ().asInstanceOf[LoadBreakSwitch]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object LoadBreakSwitch
extends
    Parseable[LoadBreakSwitch]
{
    val sup = ProtectedSwitch.parse _
    def parse (context: Context): LoadBreakSwitch =
    {
        LoadBreakSwitch(
            sup (context)
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
    val b0ch: Double,
    val distance11: Double,
    val distance12: Double,
    val distance21: Double,
    val distance22: Double,
    val g0ch: Double,
    val r0: Double,
    val x0: Double,
    val First_Terminal: String,
    val Second_Terminal: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[MutualCoupling]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MutualCoupling
extends
    Parseable[MutualCoupling]
{
    val sup = IdentifiedObject.parse _
    val b0ch = parse_element (element ("""MutualCoupling.b0ch"""))
    val distance11 = parse_element (element ("""MutualCoupling.distance11"""))
    val distance12 = parse_element (element ("""MutualCoupling.distance12"""))
    val distance21 = parse_element (element ("""MutualCoupling.distance21"""))
    val distance22 = parse_element (element ("""MutualCoupling.distance22"""))
    val g0ch = parse_element (element ("""MutualCoupling.g0ch"""))
    val r0 = parse_element (element ("""MutualCoupling.r0"""))
    val x0 = parse_element (element ("""MutualCoupling.x0"""))
    val First_Terminal = parse_attribute (attribute ("""MutualCoupling.First_Terminal"""))
    val Second_Terminal = parse_attribute (attribute ("""MutualCoupling.Second_Terminal"""))
    def parse (context: Context): MutualCoupling =
    {
        MutualCoupling(
            sup (context),
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
    override def copy (): Row = { return (clone ().asInstanceOf[NonlinearShuntCompensator]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object NonlinearShuntCompensator
extends
    Parseable[NonlinearShuntCompensator]
{
    val sup = ShuntCompensator.parse _
    def parse (context: Context): NonlinearShuntCompensator =
    {
        NonlinearShuntCompensator(
            sup (context)
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
    override def copy (): Row = { return (clone ().asInstanceOf[NonlinearShuntCompensatorPhase]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object NonlinearShuntCompensatorPhase
extends
    Parseable[NonlinearShuntCompensatorPhase]
{
    val sup = ShuntCompensatorPhase.parse _
    def parse (context: Context): NonlinearShuntCompensatorPhase =
    {
        NonlinearShuntCompensatorPhase(
            sup (context)
        )
    }
}

/**
 * A per phase non linear shunt compensator bank or section admittance value.
 * @param sup Reference to the superclass object.
 * @param b Positive sequence shunt (charging) susceptance per section
 * @param g Positive sequence shunt (charging) conductance per section
 * @param sectionNumber The number of the section.
 */
case class NonlinearShuntCompensatorPhasePoint
(
    override val sup: BasicElement,
    val b: Double,
    val g: Double,
    val sectionNumber: Int
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[NonlinearShuntCompensatorPhasePoint]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object NonlinearShuntCompensatorPhasePoint
extends
    Parseable[NonlinearShuntCompensatorPhasePoint]
{
    val sup = BasicElement.parse _
    val b = parse_element (element ("""NonlinearShuntCompensatorPhasePoint.b"""))
    val g = parse_element (element ("""NonlinearShuntCompensatorPhasePoint.g"""))
    val sectionNumber = parse_element (element ("""NonlinearShuntCompensatorPhasePoint.sectionNumber"""))
    def parse (context: Context): NonlinearShuntCompensatorPhasePoint =
    {
        NonlinearShuntCompensatorPhasePoint(
            sup (context),
            toDouble (b (context), context),
            toDouble (g (context), context),
            toInteger (sectionNumber (context), context)
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
 */
case class NonlinearShuntCompensatorPoint
(
    override val sup: BasicElement,
    val b: Double,
    val b0: Double,
    val g: Double,
    val g0: Double,
    val sectionNumber: Int
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[NonlinearShuntCompensatorPoint]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object NonlinearShuntCompensatorPoint
extends
    Parseable[NonlinearShuntCompensatorPoint]
{
    val sup = BasicElement.parse _
    val b = parse_element (element ("""NonlinearShuntCompensatorPoint.b"""))
    val b0 = parse_element (element ("""NonlinearShuntCompensatorPoint.b0"""))
    val g = parse_element (element ("""NonlinearShuntCompensatorPoint.g"""))
    val g0 = parse_element (element ("""NonlinearShuntCompensatorPoint.g0"""))
    val sectionNumber = parse_element (element ("""NonlinearShuntCompensatorPoint.sectionNumber"""))
    def parse (context: Context): NonlinearShuntCompensatorPoint =
    {
        NonlinearShuntCompensatorPoint(
            sup (context),
            toDouble (b (context), context),
            toDouble (b0 (context), context),
            toDouble (g (context), context),
            toDouble (g0 (context), context),
            toInteger (sectionNumber (context), context)
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
    override def copy (): Row = { return (clone ().asInstanceOf[PerLengthImpedance]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PerLengthImpedance
extends
    Parseable[PerLengthImpedance]
{
    val sup = PerLengthLineParameter.parse _
    def parse (context: Context): PerLengthImpedance =
    {
        PerLengthImpedance(
            sup (context)
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
    val WireSpacingInfo: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[PerLengthLineParameter]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PerLengthLineParameter
extends
    Parseable[PerLengthLineParameter]
{
    val sup = IdentifiedObject.parse _
    val WireSpacingInfo = parse_attribute (attribute ("""PerLengthLineParameter.WireSpacingInfo"""))
    def parse (context: Context): PerLengthLineParameter =
    {
        PerLengthLineParameter(
            sup (context),
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
    val conductorCount: Int
)
extends
    Element
{
    def this () = { this (null, 0) }
    def PerLengthImpedance: PerLengthImpedance = sup.asInstanceOf[PerLengthImpedance]
    override def copy (): Row = { return (clone ().asInstanceOf[PerLengthPhaseImpedance]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PerLengthPhaseImpedance
extends
    Parseable[PerLengthPhaseImpedance]
{
    val sup = PerLengthImpedance.parse _
    val conductorCount = parse_element (element ("""PerLengthPhaseImpedance.conductorCount"""))
    def parse (context: Context): PerLengthPhaseImpedance =
    {
        PerLengthPhaseImpedance(
            sup (context),
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
    val b0ch: Double,
    val bch: Double,
    val g0ch: Double,
    val gch: Double,
    val r: Double,
    val r0: Double,
    val x: Double,
    val x0: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def PerLengthImpedance: PerLengthImpedance = sup.asInstanceOf[PerLengthImpedance]
    override def copy (): Row = { return (clone ().asInstanceOf[PerLengthSequenceImpedance]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PerLengthSequenceImpedance
extends
    Parseable[PerLengthSequenceImpedance]
{
    val sup = PerLengthImpedance.parse _
    val b0ch = parse_element (element ("""PerLengthSequenceImpedance.b0ch"""))
    val bch = parse_element (element ("""PerLengthSequenceImpedance.bch"""))
    val g0ch = parse_element (element ("""PerLengthSequenceImpedance.g0ch"""))
    val gch = parse_element (element ("""PerLengthSequenceImpedance.gch"""))
    val r = parse_element (element ("""PerLengthSequenceImpedance.r"""))
    val r0 = parse_element (element ("""PerLengthSequenceImpedance.r0"""))
    val x = parse_element (element ("""PerLengthSequenceImpedance.x"""))
    val x0 = parse_element (element ("""PerLengthSequenceImpedance.x0"""))
    def parse (context: Context): PerLengthSequenceImpedance =
    {
        PerLengthSequenceImpedance(
            sup (context),
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
    val mode: String,
    val nominalU: Double,
    val offsetCurrent: Double,
    val positionCurrent: Double,
    val xGroundMax: Double,
    val xGroundMin: Double,
    val xGroundNominal: Double
)
extends
    Element
{
    def this () = { this (null, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def EarthFaultCompensator: EarthFaultCompensator = sup.asInstanceOf[EarthFaultCompensator]
    override def copy (): Row = { return (clone ().asInstanceOf[PetersenCoil]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PetersenCoil
extends
    Parseable[PetersenCoil]
{
    val sup = EarthFaultCompensator.parse _
    val mode = parse_attribute (attribute ("""PetersenCoil.mode"""))
    val nominalU = parse_element (element ("""PetersenCoil.nominalU"""))
    val offsetCurrent = parse_element (element ("""PetersenCoil.offsetCurrent"""))
    val positionCurrent = parse_element (element ("""PetersenCoil.positionCurrent"""))
    val xGroundMax = parse_element (element ("""PetersenCoil.xGroundMax"""))
    val xGroundMin = parse_element (element ("""PetersenCoil.xGroundMin"""))
    val xGroundNominal = parse_element (element ("""PetersenCoil.xGroundNominal"""))
    def parse (context: Context): PetersenCoil =
    {
        PetersenCoil(
            sup (context),
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
    val automaticPositioning: String,
    val fixed: String,
    val manual: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[PetersenCoilModeKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PetersenCoilModeKind
extends
    Parseable[PetersenCoilModeKind]
{
    val sup = BasicElement.parse _
    val automaticPositioning = parse_attribute (attribute ("""PetersenCoilModeKind.automaticPositioning"""))
    val fixed = parse_attribute (attribute ("""PetersenCoilModeKind.fixed"""))
    val manual = parse_attribute (attribute ("""PetersenCoilModeKind.manual"""))
    def parse (context: Context): PetersenCoilModeKind =
    {
        PetersenCoilModeKind(
            sup (context),
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
    val b: Double,
    val r: Double,
    val sequenceNumber: Int,
    val x: Double,
    val PhaseImpedance: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0, 0.0, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[PhaseImpedanceData]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PhaseImpedanceData
extends
    Parseable[PhaseImpedanceData]
{
    val sup = BasicElement.parse _
    val b = parse_element (element ("""PhaseImpedanceData.b"""))
    val r = parse_element (element ("""PhaseImpedanceData.r"""))
    val sequenceNumber = parse_element (element ("""PhaseImpedanceData.sequenceNumber"""))
    val x = parse_element (element ("""PhaseImpedanceData.x"""))
    val PhaseImpedance = parse_attribute (attribute ("""PhaseImpedanceData.PhaseImpedance"""))
    def parse (context: Context): PhaseImpedanceData =
    {
        PhaseImpedanceData(
            sup (context),
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
    val D: String,
    val I: String,
    val Y: String,
    val Yn: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[PhaseShuntConnectionKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PhaseShuntConnectionKind
extends
    Parseable[PhaseShuntConnectionKind]
{
    val sup = BasicElement.parse _
    val D = parse_attribute (attribute ("""PhaseShuntConnectionKind.D"""))
    val I = parse_attribute (attribute ("""PhaseShuntConnectionKind.I"""))
    val Y = parse_attribute (attribute ("""PhaseShuntConnectionKind.Y"""))
    val Yn = parse_attribute (attribute ("""PhaseShuntConnectionKind.Yn"""))
    def parse (context: Context): PhaseShuntConnectionKind =
    {
        PhaseShuntConnectionKind(
            sup (context),
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
    val TransformerEnd: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def TapChanger: TapChanger = sup.asInstanceOf[TapChanger]
    override def copy (): Row = { return (clone ().asInstanceOf[PhaseTapChanger]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PhaseTapChanger
extends
    Parseable[PhaseTapChanger]
{
    val sup = TapChanger.parse _
    val TransformerEnd = parse_attribute (attribute ("""PhaseTapChanger.TransformerEnd"""))
    def parse (context: Context): PhaseTapChanger =
    {
        PhaseTapChanger(
            sup (context),
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
    val windingConnectionAngle: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
    def PhaseTapChangerNonLinear: PhaseTapChangerNonLinear = sup.asInstanceOf[PhaseTapChangerNonLinear]
    override def copy (): Row = { return (clone ().asInstanceOf[PhaseTapChangerAsymmetrical]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PhaseTapChangerAsymmetrical
extends
    Parseable[PhaseTapChangerAsymmetrical]
{
    val sup = PhaseTapChangerNonLinear.parse _
    val windingConnectionAngle = parse_element (element ("""PhaseTapChangerAsymmetrical.windingConnectionAngle"""))
    def parse (context: Context): PhaseTapChangerAsymmetrical =
    {
        PhaseTapChangerAsymmetrical(
            sup (context),
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
    val stepPhaseShiftIncrement: Double,
    val xMax: Double,
    val xMin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0) }
    def PhaseTapChanger: PhaseTapChanger = sup.asInstanceOf[PhaseTapChanger]
    override def copy (): Row = { return (clone ().asInstanceOf[PhaseTapChangerLinear]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PhaseTapChangerLinear
extends
    Parseable[PhaseTapChangerLinear]
{
    val sup = PhaseTapChanger.parse _
    val stepPhaseShiftIncrement = parse_element (element ("""PhaseTapChangerLinear.stepPhaseShiftIncrement"""))
    val xMax = parse_element (element ("""PhaseTapChangerLinear.xMax"""))
    val xMin = parse_element (element ("""PhaseTapChangerLinear.xMin"""))
    def parse (context: Context): PhaseTapChangerLinear =
    {
        PhaseTapChangerLinear(
            sup (context),
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
    val voltageStepIncrement: Double,
    val xMax: Double,
    val xMin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0) }
    def PhaseTapChanger: PhaseTapChanger = sup.asInstanceOf[PhaseTapChanger]
    override def copy (): Row = { return (clone ().asInstanceOf[PhaseTapChangerNonLinear]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PhaseTapChangerNonLinear
extends
    Parseable[PhaseTapChangerNonLinear]
{
    val sup = PhaseTapChanger.parse _
    val voltageStepIncrement = parse_element (element ("""PhaseTapChangerNonLinear.voltageStepIncrement"""))
    val xMax = parse_element (element ("""PhaseTapChangerNonLinear.xMax"""))
    val xMin = parse_element (element ("""PhaseTapChangerNonLinear.xMin"""))
    def parse (context: Context): PhaseTapChangerNonLinear =
    {
        PhaseTapChangerNonLinear(
            sup (context),
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
    override def copy (): Row = { return (clone ().asInstanceOf[PhaseTapChangerSymmetrical]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PhaseTapChangerSymmetrical
extends
    Parseable[PhaseTapChangerSymmetrical]
{
    val sup = PhaseTapChangerNonLinear.parse _
    def parse (context: Context): PhaseTapChangerSymmetrical =
    {
        PhaseTapChangerSymmetrical(
            sup (context)
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
    override def copy (): Row = { return (clone ().asInstanceOf[PhaseTapChangerTable]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PhaseTapChangerTable
extends
    Parseable[PhaseTapChangerTable]
{
    val sup = IdentifiedObject.parse _
    def parse (context: Context): PhaseTapChangerTable =
    {
        PhaseTapChangerTable(
            sup (context)
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
    val angle: Double,
    val PhaseTapChangerTable: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null) }
    def TapChangerTablePoint: TapChangerTablePoint = sup.asInstanceOf[TapChangerTablePoint]
    override def copy (): Row = { return (clone ().asInstanceOf[PhaseTapChangerTablePoint]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PhaseTapChangerTablePoint
extends
    Parseable[PhaseTapChangerTablePoint]
{
    val sup = TapChangerTablePoint.parse _
    val angle = parse_element (element ("""PhaseTapChangerTablePoint.angle"""))
    val PhaseTapChangerTable = parse_attribute (attribute ("""PhaseTapChangerTablePoint.PhaseTapChangerTable"""))
    def parse (context: Context): PhaseTapChangerTablePoint =
    {
        PhaseTapChangerTablePoint(
            sup (context),
            toDouble (angle (context), context),
            PhaseTapChangerTable (context)
        )
    }
}

case class PhaseTapChangerTabular
(
    override val sup: PhaseTapChanger,
    val PhaseTapChangerTable: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def PhaseTapChanger: PhaseTapChanger = sup.asInstanceOf[PhaseTapChanger]
    override def copy (): Row = { return (clone ().asInstanceOf[PhaseTapChangerTabular]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PhaseTapChangerTabular
extends
    Parseable[PhaseTapChangerTabular]
{
    val sup = PhaseTapChanger.parse _
    val PhaseTapChangerTable = parse_attribute (attribute ("""PhaseTapChangerTabular.PhaseTapChangerTable"""))
    def parse (context: Context): PhaseTapChangerTabular =
    {
        PhaseTapChangerTabular(
            sup (context),
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
    override def copy (): Row = { return (clone ().asInstanceOf[Plant]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Plant
extends
    Parseable[Plant]
{
    val sup = EquipmentContainer.parse _
    def parse (context: Context): Plant =
    {
        Plant(
            sup (context)
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
    val beforeShCircuitHighestOperatingCurrent: Double,
    val beforeShCircuitHighestOperatingVoltage: Double,
    val beforeShortCircuitAnglePf: Double,
    val highSideMinOperatingU: Double,
    val isPartOfGeneratorUnit: Boolean,
    val operationalValuesConsidered: Boolean,
    val vectorGroup: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, false, false, null) }
    def ConductingEquipment: ConductingEquipment = sup.asInstanceOf[ConductingEquipment]
    override def copy (): Row = { return (clone ().asInstanceOf[PowerTransformer]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PowerTransformer
extends
    Parseable[PowerTransformer]
{
    val sup = ConductingEquipment.parse _
    val beforeShCircuitHighestOperatingCurrent = parse_element (element ("""PowerTransformer.beforeShCircuitHighestOperatingCurrent"""))
    val beforeShCircuitHighestOperatingVoltage = parse_element (element ("""PowerTransformer.beforeShCircuitHighestOperatingVoltage"""))
    val beforeShortCircuitAnglePf = parse_element (element ("""PowerTransformer.beforeShortCircuitAnglePf"""))
    val highSideMinOperatingU = parse_element (element ("""PowerTransformer.highSideMinOperatingU"""))
    val isPartOfGeneratorUnit = parse_element (element ("""PowerTransformer.isPartOfGeneratorUnit"""))
    val operationalValuesConsidered = parse_element (element ("""PowerTransformer.operationalValuesConsidered"""))
    val vectorGroup = parse_element (element ("""PowerTransformer.vectorGroup"""))
    def parse (context: Context): PowerTransformer =
    {
        PowerTransformer(
            sup (context),
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
    val b: Double,
    val b0: Double,
    val connectionKind: String,
    val g: Double,
    val g0: Double,
    val phaseAngleClock: Int,
    val r: Double,
    val r0: Double,
    val ratedS: Double,
    val ratedU: Double,
    val x: Double,
    val x0: Double,
    val PowerTransformer: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null, 0.0, 0.0, 0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null) }
    def TransformerEnd: TransformerEnd = sup.asInstanceOf[TransformerEnd]
    override def copy (): Row = { return (clone ().asInstanceOf[PowerTransformerEnd]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PowerTransformerEnd
extends
    Parseable[PowerTransformerEnd]
{
    val sup = TransformerEnd.parse _
    val b = parse_element (element ("""PowerTransformerEnd.b"""))
    val b0 = parse_element (element ("""PowerTransformerEnd.b0"""))
    val connectionKind = parse_attribute (attribute ("""PowerTransformerEnd.connectionKind"""))
    val g = parse_element (element ("""PowerTransformerEnd.g"""))
    val g0 = parse_element (element ("""PowerTransformerEnd.g0"""))
    val phaseAngleClock = parse_element (element ("""PowerTransformerEnd.phaseAngleClock"""))
    val r = parse_element (element ("""PowerTransformerEnd.r"""))
    val r0 = parse_element (element ("""PowerTransformerEnd.r0"""))
    val ratedS = parse_element (element ("""PowerTransformerEnd.ratedS"""))
    val ratedU = parse_element (element ("""PowerTransformerEnd.ratedU"""))
    val x = parse_element (element ("""PowerTransformerEnd.x"""))
    val x0 = parse_element (element ("""PowerTransformerEnd.x0"""))
    val PowerTransformer = parse_attribute (attribute ("""PowerTransformerEnd.PowerTransformer"""))
    def parse (context: Context): PowerTransformerEnd =
    {
        PowerTransformerEnd(
            sup (context),
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
    val breakingCapacity: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
    def Switch: Switch = sup.asInstanceOf[Switch]
    override def copy (): Row = { return (clone ().asInstanceOf[ProtectedSwitch]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ProtectedSwitch
extends
    Parseable[ProtectedSwitch]
{
    val sup = Switch.parse _
    val breakingCapacity = parse_element (element ("""ProtectedSwitch.breakingCapacity"""))
    def parse (context: Context): ProtectedSwitch =
    {
        ProtectedSwitch(
            sup (context),
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
    val stepVoltageIncrement: Double,
    val tculControlMode: String,
    val RatioTapChangerTable: String,
    val TransformerEnd: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null, null) }
    def TapChanger: TapChanger = sup.asInstanceOf[TapChanger]
    override def copy (): Row = { return (clone ().asInstanceOf[RatioTapChanger]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RatioTapChanger
extends
    Parseable[RatioTapChanger]
{
    val sup = TapChanger.parse _
    val stepVoltageIncrement = parse_element (element ("""RatioTapChanger.stepVoltageIncrement"""))
    val tculControlMode = parse_attribute (attribute ("""RatioTapChanger.tculControlMode"""))
    val RatioTapChangerTable = parse_attribute (attribute ("""RatioTapChanger.RatioTapChangerTable"""))
    val TransformerEnd = parse_attribute (attribute ("""RatioTapChanger.TransformerEnd"""))
    def parse (context: Context): RatioTapChanger =
    {
        RatioTapChanger(
            sup (context),
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
    override def copy (): Row = { return (clone ().asInstanceOf[RatioTapChangerTable]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RatioTapChangerTable
extends
    Parseable[RatioTapChangerTable]
{
    val sup = IdentifiedObject.parse _
    def parse (context: Context): RatioTapChangerTable =
    {
        RatioTapChangerTable(
            sup (context)
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
    val RatioTapChangerTable: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def TapChangerTablePoint: TapChangerTablePoint = sup.asInstanceOf[TapChangerTablePoint]
    override def copy (): Row = { return (clone ().asInstanceOf[RatioTapChangerTablePoint]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RatioTapChangerTablePoint
extends
    Parseable[RatioTapChangerTablePoint]
{
    val sup = TapChangerTablePoint.parse _
    val RatioTapChangerTable = parse_attribute (attribute ("""RatioTapChangerTablePoint.RatioTapChangerTable"""))
    def parse (context: Context): RatioTapChangerTablePoint =
    {
        RatioTapChangerTablePoint(
            sup (context),
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
    val coolantTemperature: Double,
    val hydrogenPressure: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { return (clone ().asInstanceOf[ReactiveCapabilityCurve]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ReactiveCapabilityCurve
extends
    Parseable[ReactiveCapabilityCurve]
{
    val sup = Curve.parse _
    val coolantTemperature = parse_element (element ("""ReactiveCapabilityCurve.coolantTemperature"""))
    val hydrogenPressure = parse_element (element ("""ReactiveCapabilityCurve.hydrogenPressure"""))
    def parse (context: Context): ReactiveCapabilityCurve =
    {
        ReactiveCapabilityCurve(
            sup (context),
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
    override def copy (): Row = { return (clone ().asInstanceOf[Recloser]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Recloser
extends
    Parseable[Recloser]
{
    val sup = ProtectedSwitch.parse _
    def parse (context: Context): Recloser =
    {
        Recloser(
            sup (context)
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
    val controlEnabled: Boolean,
    val RegulatingControl: String
)
extends
    Element
{
    def this () = { this (null, false, null) }
    def ConductingEquipment: ConductingEquipment = sup.asInstanceOf[ConductingEquipment]
    override def copy (): Row = { return (clone ().asInstanceOf[RegulatingCondEq]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RegulatingCondEq
extends
    Parseable[RegulatingCondEq]
{
    val sup = ConductingEquipment.parse _
    val controlEnabled = parse_element (element ("""RegulatingCondEq.controlEnabled"""))
    val RegulatingControl = parse_attribute (attribute ("""RegulatingCondEq.RegulatingControl"""))
    def parse (context: Context): RegulatingCondEq =
    {
        RegulatingCondEq(
            sup (context),
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
    val discrete: Boolean,
    val enabled: Boolean,
    val mode: String,
    val monitoredPhase: String,
    val targetDeadband: Double,
    val targetValue: Double,
    val targetValueUnitMultiplier: String,
    val Terminal: String
)
extends
    Element
{
    def this () = { this (null, false, false, null, null, 0.0, 0.0, null, null) }
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { return (clone ().asInstanceOf[RegulatingControl]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RegulatingControl
extends
    Parseable[RegulatingControl]
{
    val sup = PowerSystemResource.parse _
    val discrete = parse_element (element ("""RegulatingControl.discrete"""))
    val enabled = parse_element (element ("""RegulatingControl.enabled"""))
    val mode = parse_attribute (attribute ("""RegulatingControl.mode"""))
    val monitoredPhase = parse_attribute (attribute ("""RegulatingControl.monitoredPhase"""))
    val targetDeadband = parse_element (element ("""RegulatingControl.targetDeadband"""))
    val targetValue = parse_element (element ("""RegulatingControl.targetValue"""))
    val targetValueUnitMultiplier = parse_attribute (attribute ("""RegulatingControl.targetValueUnitMultiplier"""))
    val Terminal = parse_attribute (attribute ("""RegulatingControl.Terminal"""))
    def parse (context: Context): RegulatingControl =
    {
        RegulatingControl(
            sup (context),
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
    val activePower: String,
    val admittance: String,
    val currentFlow: String,
    val powerFactor: String,
    val reactivePower: String,
    val temperature: String,
    val timeScheduled: String,
    val voltage: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[RegulatingControlModeKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RegulatingControlModeKind
extends
    Parseable[RegulatingControlModeKind]
{
    val sup = BasicElement.parse _
    val activePower = parse_attribute (attribute ("""RegulatingControlModeKind.activePower"""))
    val admittance = parse_attribute (attribute ("""RegulatingControlModeKind.admittance"""))
    val currentFlow = parse_attribute (attribute ("""RegulatingControlModeKind.currentFlow"""))
    val powerFactor = parse_attribute (attribute ("""RegulatingControlModeKind.powerFactor"""))
    val reactivePower = parse_attribute (attribute ("""RegulatingControlModeKind.reactivePower"""))
    val temperature = parse_attribute (attribute ("""RegulatingControlModeKind.temperature"""))
    val timeScheduled = parse_attribute (attribute ("""RegulatingControlModeKind.timeScheduled"""))
    val voltage = parse_attribute (attribute ("""RegulatingControlModeKind.voltage"""))
    def parse (context: Context): RegulatingControlModeKind =
    {
        RegulatingControlModeKind(
            sup (context),
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
    val RegulatingControl: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def SeasonDayTypeSchedule: SeasonDayTypeSchedule = sup.asInstanceOf[SeasonDayTypeSchedule]
    override def copy (): Row = { return (clone ().asInstanceOf[RegulationSchedule]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RegulationSchedule
extends
    Parseable[RegulationSchedule]
{
    val sup = SeasonDayTypeSchedule.parse _
    val RegulatingControl = parse_attribute (attribute ("""RegulationSchedule.RegulatingControl"""))
    def parse (context: Context): RegulationSchedule =
    {
        RegulationSchedule(
            sup (context),
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
    val p: Double,
    val q: Double,
    val ratedPowerFactor: Double,
    val ratedS: Double,
    val ratedU: Double,
    val GeneratingUnit: String,
    val HydroPump: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, null, null) }
    def RegulatingCondEq: RegulatingCondEq = sup.asInstanceOf[RegulatingCondEq]
    override def copy (): Row = { return (clone ().asInstanceOf[RotatingMachine]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RotatingMachine
extends
    Parseable[RotatingMachine]
{
    val sup = RegulatingCondEq.parse _
    val p = parse_element (element ("""RotatingMachine.p"""))
    val q = parse_element (element ("""RotatingMachine.q"""))
    val ratedPowerFactor = parse_element (element ("""RotatingMachine.ratedPowerFactor"""))
    val ratedS = parse_element (element ("""RotatingMachine.ratedS"""))
    val ratedU = parse_element (element ("""RotatingMachine.ratedU"""))
    val GeneratingUnit = parse_attribute (attribute ("""RotatingMachine.GeneratingUnit"""))
    val HydroPump = parse_attribute (attribute ("""RotatingMachine.HydroPump"""))
    def parse (context: Context): RotatingMachine =
    {
        RotatingMachine(
            sup (context),
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
 * @param reactivePower
 * @param voltage
 */
case class SVCControlMode
(
    override val sup: BasicElement,
    val reactivePower: String,
    val voltage: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[SVCControlMode]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SVCControlMode
extends
    Parseable[SVCControlMode]
{
    val sup = BasicElement.parse _
    val reactivePower = parse_attribute (attribute ("""SVCControlMode.reactivePower"""))
    val voltage = parse_attribute (attribute ("""SVCControlMode.voltage"""))
    def parse (context: Context): SVCControlMode =
    {
        SVCControlMode(
            sup (context),
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
    override def copy (): Row = { return (clone ().asInstanceOf[Sectionaliser]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Sectionaliser
extends
    Parseable[Sectionaliser]
{
    val sup = Switch.parse _
    def parse (context: Context): Sectionaliser =
    {
        Sectionaliser(
            sup (context)
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
    val r: Double,
    val r0: Double,
    val varistorPresent: Boolean,
    val varistorRatedCurrent: Double,
    val varistorVoltageThreshold: Double,
    val x: Double,
    val x0: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, false, 0.0, 0.0, 0.0, 0.0) }
    def ConductingEquipment: ConductingEquipment = sup.asInstanceOf[ConductingEquipment]
    override def copy (): Row = { return (clone ().asInstanceOf[SeriesCompensator]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SeriesCompensator
extends
    Parseable[SeriesCompensator]
{
    val sup = ConductingEquipment.parse _
    val r = parse_element (element ("""SeriesCompensator.r"""))
    val r0 = parse_element (element ("""SeriesCompensator.r0"""))
    val varistorPresent = parse_element (element ("""SeriesCompensator.varistorPresent"""))
    val varistorRatedCurrent = parse_element (element ("""SeriesCompensator.varistorRatedCurrent"""))
    val varistorVoltageThreshold = parse_element (element ("""SeriesCompensator.varistorVoltageThreshold"""))
    val x = parse_element (element ("""SeriesCompensator.x"""))
    val x0 = parse_element (element ("""SeriesCompensator.x0"""))
    def parse (context: Context): SeriesCompensator =
    {
        SeriesCompensator(
            sup (context),
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
    val salientPole1: String,
    val salientPole2: String,
    val turboSeries1: String,
    val turboSeries2: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ShortCircuitRotorKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ShortCircuitRotorKind
extends
    Parseable[ShortCircuitRotorKind]
{
    val sup = BasicElement.parse _
    val salientPole1 = parse_attribute (attribute ("""ShortCircuitRotorKind.salientPole1"""))
    val salientPole2 = parse_attribute (attribute ("""ShortCircuitRotorKind.salientPole2"""))
    val turboSeries1 = parse_attribute (attribute ("""ShortCircuitRotorKind.turboSeries1"""))
    val turboSeries2 = parse_attribute (attribute ("""ShortCircuitRotorKind.turboSeries2"""))
    def parse (context: Context): ShortCircuitRotorKind =
    {
        ShortCircuitRotorKind(
            sup (context),
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
    val aVRDelay: Double,
    val grounded: Boolean,
    val maximumSections: Int,
    val nomU: Double,
    val normalSections: Int,
    val phaseConnection: String,
    val sections: Double,
    val switchOnCount: Int,
    val switchOnDate: String,
    val voltageSensitivity: Double,
    val SvShuntCompensatorSections: String
)
extends
    Element
{
    def this () = { this (null, 0.0, false, 0, 0.0, 0, null, 0.0, 0, null, 0.0, null) }
    def RegulatingCondEq: RegulatingCondEq = sup.asInstanceOf[RegulatingCondEq]
    override def copy (): Row = { return (clone ().asInstanceOf[ShuntCompensator]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ShuntCompensator
extends
    Parseable[ShuntCompensator]
{
    val sup = RegulatingCondEq.parse _
    val aVRDelay = parse_element (element ("""ShuntCompensator.aVRDelay"""))
    val grounded = parse_element (element ("""ShuntCompensator.grounded"""))
    val maximumSections = parse_element (element ("""ShuntCompensator.maximumSections"""))
    val nomU = parse_element (element ("""ShuntCompensator.nomU"""))
    val normalSections = parse_element (element ("""ShuntCompensator.normalSections"""))
    val phaseConnection = parse_attribute (attribute ("""ShuntCompensator.phaseConnection"""))
    val sections = parse_element (element ("""ShuntCompensator.sections"""))
    val switchOnCount = parse_element (element ("""ShuntCompensator.switchOnCount"""))
    val switchOnDate = parse_element (element ("""ShuntCompensator.switchOnDate"""))
    val voltageSensitivity = parse_element (element ("""ShuntCompensator.voltageSensitivity"""))
    val SvShuntCompensatorSections = parse_attribute (attribute ("""ShuntCompensator.SvShuntCompensatorSections"""))
    def parse (context: Context): ShuntCompensator =
    {
        ShuntCompensator(
            sup (context),
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
    val maximumSections: Int,
    val normalSections: Int,
    val phase: String,
    val ShuntCompensator: String
)
extends
    Element
{
    def this () = { this (null, 0, 0, null, null) }
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { return (clone ().asInstanceOf[ShuntCompensatorPhase]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ShuntCompensatorPhase
extends
    Parseable[ShuntCompensatorPhase]
{
    val sup = PowerSystemResource.parse _
    val maximumSections = parse_element (element ("""ShuntCompensatorPhase.maximumSections"""))
    val normalSections = parse_element (element ("""ShuntCompensatorPhase.normalSections"""))
    val phase = parse_attribute (attribute ("""ShuntCompensatorPhase.phase"""))
    val ShuntCompensator = parse_attribute (attribute ("""ShuntCompensatorPhase.ShuntCompensator"""))
    def parse (context: Context): ShuntCompensatorPhase =
    {
        ShuntCompensatorPhase(
            sup (context),
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
    val s1: String,
    val s2: String,
    val A: String,
    val B: String,
    val C: String,
    val N: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[SinglePhaseKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SinglePhaseKind
extends
    Parseable[SinglePhaseKind]
{
    val sup = BasicElement.parse _
    val s1 = parse_attribute (attribute ("""SinglePhaseKind.s1"""))
    val s2 = parse_attribute (attribute ("""SinglePhaseKind.s2"""))
    val A = parse_attribute (attribute ("""SinglePhaseKind.A"""))
    val B = parse_attribute (attribute ("""SinglePhaseKind.B"""))
    val C = parse_attribute (attribute ("""SinglePhaseKind.C"""))
    val N = parse_attribute (attribute ("""SinglePhaseKind.N"""))
    def parse (context: Context): SinglePhaseKind =
    {
        SinglePhaseKind(
            sup (context),
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
    val capacitiveRating: Double,
    val inductiveRating: Double,
    val q: Double,
    val sVCControlMode: String,
    val slope: Double,
    val voltageSetPoint: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, null, 0.0, 0.0) }
    def RegulatingCondEq: RegulatingCondEq = sup.asInstanceOf[RegulatingCondEq]
    override def copy (): Row = { return (clone ().asInstanceOf[StaticVarCompensator]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object StaticVarCompensator
extends
    Parseable[StaticVarCompensator]
{
    val sup = RegulatingCondEq.parse _
    val capacitiveRating = parse_element (element ("""StaticVarCompensator.capacitiveRating"""))
    val inductiveRating = parse_element (element ("""StaticVarCompensator.inductiveRating"""))
    val q = parse_element (element ("""StaticVarCompensator.q"""))
    val sVCControlMode = parse_attribute (attribute ("""StaticVarCompensator.sVCControlMode"""))
    val slope = parse_element (element ("""StaticVarCompensator.slope"""))
    val voltageSetPoint = parse_element (element ("""StaticVarCompensator.voltageSetPoint"""))
    def parse (context: Context): StaticVarCompensator =
    {
        StaticVarCompensator(
            sup (context),
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
    val normalOpen: Boolean,
    val open: Boolean,
    val ratedCurrent: Double,
    val retained: Boolean,
    val switchOnCount: Int,
    val switchOnDate: String,
    val CompositeSwitch: String,
    val Outage: String,
    val SwitchAction: String
)
extends
    Element
{
    def this () = { this (null, false, false, 0.0, false, 0, null, null, null, null) }
    def ConductingEquipment: ConductingEquipment = sup.asInstanceOf[ConductingEquipment]
    override def copy (): Row = { return (clone ().asInstanceOf[Switch]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Switch
extends
    Parseable[Switch]
{
    val sup = ConductingEquipment.parse _
    val normalOpen = parse_element (element ("""Switch.normalOpen"""))
    val open = parse_element (element ("""Switch.open"""))
    val ratedCurrent = parse_element (element ("""Switch.ratedCurrent"""))
    val retained = parse_element (element ("""Switch.retained"""))
    val switchOnCount = parse_element (element ("""Switch.switchOnCount"""))
    val switchOnDate = parse_element (element ("""Switch.switchOnDate"""))
    val CompositeSwitch = parse_attribute (attribute ("""Switch.CompositeSwitch"""))
    val Outage = parse_attribute (attribute ("""Switch.Outage"""))
    val SwitchAction = parse_attribute (attribute ("""Switch.SwitchAction"""))
    def parse (context: Context): Switch =
    {
        Switch(
            sup (context),
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
    val closed: Boolean,
    val normalOpen: Boolean,
    val phaseSide1: String,
    val phaseSide2: String,
    val Switch: String
)
extends
    Element
{
    def this () = { this (null, false, false, null, null, null) }
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { return (clone ().asInstanceOf[SwitchPhase]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SwitchPhase
extends
    Parseable[SwitchPhase]
{
    val sup = PowerSystemResource.parse _
    val closed = parse_element (element ("""SwitchPhase.closed"""))
    val normalOpen = parse_element (element ("""SwitchPhase.normalOpen"""))
    val phaseSide1 = parse_attribute (attribute ("""SwitchPhase.phaseSide1"""))
    val phaseSide2 = parse_attribute (attribute ("""SwitchPhase.phaseSide2"""))
    val Switch = parse_attribute (attribute ("""SwitchPhase.Switch"""))
    def parse (context: Context): SwitchPhase =
    {
        SwitchPhase(
            sup (context),
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
    val Switch: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def SeasonDayTypeSchedule: SeasonDayTypeSchedule = sup.asInstanceOf[SeasonDayTypeSchedule]
    override def copy (): Row = { return (clone ().asInstanceOf[SwitchSchedule]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SwitchSchedule
extends
    Parseable[SwitchSchedule]
{
    val sup = SeasonDayTypeSchedule.parse _
    val Switch = parse_attribute (attribute ("""SwitchSchedule.Switch"""))
    def parse (context: Context): SwitchSchedule =
    {
        SwitchSchedule(
            sup (context),
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
    val aVRToManualLag: Double,
    val aVRToManualLead: Double,
    val baseQ: Double,
    val condenserP: Double,
    val coolantCondition: Double,
    val coolantType: String,
    val earthing: Boolean,
    val earthingStarPointR: Double,
    val earthingStarPointX: Double,
    val ikk: Double,
    val manualToAVR: Double,
    val maxQ: Double,
    val maxU: Double,
    val minQ: Double,
    val minU: Double,
    val mu: Double,
    val operatingMode: String,
    val qPercent: Double,
    val r: Double,
    val r0: Double,
    val r2: Double,
    val referencePriority: Int,
    val satDirectSubtransX: Double,
    val satDirectSyncX: Double,
    val satDirectTransX: Double,
    val shortCircuitRotorType: String,
    val typ: String,
    val voltageRegulationRange: Double,
    val x0: Double,
    val x2: Double,
    val InitialReactiveCapabilityCurve: String,
    val SynchronousMachineDynamics: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, null, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, 0.0, 0.0, 0.0, 0.0, 0, 0.0, 0.0, 0.0, null, null, 0.0, 0.0, 0.0, null, null) }
    def RotatingMachine: RotatingMachine = sup.asInstanceOf[RotatingMachine]
    override def copy (): Row = { return (clone ().asInstanceOf[SynchronousMachine]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SynchronousMachine
extends
    Parseable[SynchronousMachine]
{
    val sup = RotatingMachine.parse _
    val aVRToManualLag = parse_element (element ("""SynchronousMachine.aVRToManualLag"""))
    val aVRToManualLead = parse_element (element ("""SynchronousMachine.aVRToManualLead"""))
    val baseQ = parse_element (element ("""SynchronousMachine.baseQ"""))
    val condenserP = parse_element (element ("""SynchronousMachine.condenserP"""))
    val coolantCondition = parse_element (element ("""SynchronousMachine.coolantCondition"""))
    val coolantType = parse_attribute (attribute ("""SynchronousMachine.coolantType"""))
    val earthing = parse_element (element ("""SynchronousMachine.earthing"""))
    val earthingStarPointR = parse_element (element ("""SynchronousMachine.earthingStarPointR"""))
    val earthingStarPointX = parse_element (element ("""SynchronousMachine.earthingStarPointX"""))
    val ikk = parse_element (element ("""SynchronousMachine.ikk"""))
    val manualToAVR = parse_element (element ("""SynchronousMachine.manualToAVR"""))
    val maxQ = parse_element (element ("""SynchronousMachine.maxQ"""))
    val maxU = parse_element (element ("""SynchronousMachine.maxU"""))
    val minQ = parse_element (element ("""SynchronousMachine.minQ"""))
    val minU = parse_element (element ("""SynchronousMachine.minU"""))
    val mu = parse_element (element ("""SynchronousMachine.mu"""))
    val operatingMode = parse_attribute (attribute ("""SynchronousMachine.operatingMode"""))
    val qPercent = parse_element (element ("""SynchronousMachine.qPercent"""))
    val r = parse_element (element ("""SynchronousMachine.r"""))
    val r0 = parse_element (element ("""SynchronousMachine.r0"""))
    val r2 = parse_element (element ("""SynchronousMachine.r2"""))
    val referencePriority = parse_element (element ("""SynchronousMachine.referencePriority"""))
    val satDirectSubtransX = parse_element (element ("""SynchronousMachine.satDirectSubtransX"""))
    val satDirectSyncX = parse_element (element ("""SynchronousMachine.satDirectSyncX"""))
    val satDirectTransX = parse_element (element ("""SynchronousMachine.satDirectTransX"""))
    val shortCircuitRotorType = parse_attribute (attribute ("""SynchronousMachine.shortCircuitRotorType"""))
    val typ = parse_attribute (attribute ("""SynchronousMachine.type"""))
    val voltageRegulationRange = parse_element (element ("""SynchronousMachine.voltageRegulationRange"""))
    val x0 = parse_element (element ("""SynchronousMachine.x0"""))
    val x2 = parse_element (element ("""SynchronousMachine.x2"""))
    val InitialReactiveCapabilityCurve = parse_attribute (attribute ("""SynchronousMachine.InitialReactiveCapabilityCurve"""))
    val SynchronousMachineDynamics = parse_attribute (attribute ("""SynchronousMachine.SynchronousMachineDynamics"""))
    def parse (context: Context): SynchronousMachine =
    {
        SynchronousMachine(
            sup (context),
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
 * @param condenser
 * @param generator
 * @param generatorOrCondenser
 * @param generatorOrCondenserOrMotor
 * @param generatorOrMotor
 * @param motor
 * @param motorOrCondenser
 */
case class SynchronousMachineKind
(
    override val sup: BasicElement,
    val condenser: String,
    val generator: String,
    val generatorOrCondenser: String,
    val generatorOrCondenserOrMotor: String,
    val generatorOrMotor: String,
    val motor: String,
    val motorOrCondenser: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[SynchronousMachineKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SynchronousMachineKind
extends
    Parseable[SynchronousMachineKind]
{
    val sup = BasicElement.parse _
    val condenser = parse_attribute (attribute ("""SynchronousMachineKind.condenser"""))
    val generator = parse_attribute (attribute ("""SynchronousMachineKind.generator"""))
    val generatorOrCondenser = parse_attribute (attribute ("""SynchronousMachineKind.generatorOrCondenser"""))
    val generatorOrCondenserOrMotor = parse_attribute (attribute ("""SynchronousMachineKind.generatorOrCondenserOrMotor"""))
    val generatorOrMotor = parse_attribute (attribute ("""SynchronousMachineKind.generatorOrMotor"""))
    val motor = parse_attribute (attribute ("""SynchronousMachineKind.motor"""))
    val motorOrCondenser = parse_attribute (attribute ("""SynchronousMachineKind.motorOrCondenser"""))
    def parse (context: Context): SynchronousMachineKind =
    {
        SynchronousMachineKind(
            sup (context),
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
 * @param condenser
 * @param generator
 * @param motor
 */
case class SynchronousMachineOperatingMode
(
    override val sup: BasicElement,
    val condenser: String,
    val generator: String,
    val motor: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[SynchronousMachineOperatingMode]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SynchronousMachineOperatingMode
extends
    Parseable[SynchronousMachineOperatingMode]
{
    val sup = BasicElement.parse _
    val condenser = parse_attribute (attribute ("""SynchronousMachineOperatingMode.condenser"""))
    val generator = parse_attribute (attribute ("""SynchronousMachineOperatingMode.generator"""))
    val motor = parse_attribute (attribute ("""SynchronousMachineOperatingMode.motor"""))
    def parse (context: Context): SynchronousMachineOperatingMode =
    {
        SynchronousMachineOperatingMode(
            sup (context),
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
    val controlEnabled: Boolean,
    val highStep: Int,
    val initialDelay: Double,
    val lowStep: Int,
    val ltcFlag: Boolean,
    val neutralStep: Int,
    val neutralU: Double,
    val normalStep: Int,
    val step: Double,
    val subsequentDelay: Double,
    val SvTapStep: String,
    val TapChangerControl: String
)
extends
    Element
{
    def this () = { this (null, false, 0, 0.0, 0, false, 0, 0.0, 0, 0.0, 0.0, null, null) }
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { return (clone ().asInstanceOf[TapChanger]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TapChanger
extends
    Parseable[TapChanger]
{
    val sup = PowerSystemResource.parse _
    val controlEnabled = parse_element (element ("""TapChanger.controlEnabled"""))
    val highStep = parse_element (element ("""TapChanger.highStep"""))
    val initialDelay = parse_element (element ("""TapChanger.initialDelay"""))
    val lowStep = parse_element (element ("""TapChanger.lowStep"""))
    val ltcFlag = parse_element (element ("""TapChanger.ltcFlag"""))
    val neutralStep = parse_element (element ("""TapChanger.neutralStep"""))
    val neutralU = parse_element (element ("""TapChanger.neutralU"""))
    val normalStep = parse_element (element ("""TapChanger.normalStep"""))
    val step = parse_element (element ("""TapChanger.step"""))
    val subsequentDelay = parse_element (element ("""TapChanger.subsequentDelay"""))
    val SvTapStep = parse_attribute (attribute ("""TapChanger.SvTapStep"""))
    val TapChangerControl = parse_attribute (attribute ("""TapChanger.TapChangerControl"""))
    def parse (context: Context): TapChanger =
    {
        TapChanger(
            sup (context),
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
    val limitVoltage: Double,
    val lineDropCompensation: Boolean,
    val lineDropR: Double,
    val lineDropX: Double,
    val reverseLineDropR: Double,
    val reverseLineDropX: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, false, 0.0, 0.0, 0.0, 0.0) }
    def RegulatingControl: RegulatingControl = sup.asInstanceOf[RegulatingControl]
    override def copy (): Row = { return (clone ().asInstanceOf[TapChangerControl]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TapChangerControl
extends
    Parseable[TapChangerControl]
{
    val sup = RegulatingControl.parse _
    val limitVoltage = parse_element (element ("""TapChangerControl.limitVoltage"""))
    val lineDropCompensation = parse_element (element ("""TapChangerControl.lineDropCompensation"""))
    val lineDropR = parse_element (element ("""TapChangerControl.lineDropR"""))
    val lineDropX = parse_element (element ("""TapChangerControl.lineDropX"""))
    val reverseLineDropR = parse_element (element ("""TapChangerControl.reverseLineDropR"""))
    val reverseLineDropX = parse_element (element ("""TapChangerControl.reverseLineDropX"""))
    def parse (context: Context): TapChangerControl =
    {
        TapChangerControl(
            sup (context),
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
    val b: Double,
    val g: Double,
    val r: Double,
    val ratio: Double,
    val step: Int,
    val x: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0, 0.0) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[TapChangerTablePoint]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TapChangerTablePoint
extends
    Parseable[TapChangerTablePoint]
{
    val sup = BasicElement.parse _
    val b = parse_element (element ("""TapChangerTablePoint.b"""))
    val g = parse_element (element ("""TapChangerTablePoint.g"""))
    val r = parse_element (element ("""TapChangerTablePoint.r"""))
    val ratio = parse_element (element ("""TapChangerTablePoint.ratio"""))
    val step = parse_element (element ("""TapChangerTablePoint.step"""))
    val x = parse_element (element ("""TapChangerTablePoint.x"""))
    def parse (context: Context): TapChangerTablePoint =
    {
        TapChangerTablePoint(
            sup (context),
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
    val TapChanger: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def SeasonDayTypeSchedule: SeasonDayTypeSchedule = sup.asInstanceOf[SeasonDayTypeSchedule]
    override def copy (): Row = { return (clone ().asInstanceOf[TapSchedule]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TapSchedule
extends
    Parseable[TapSchedule]
{
    val sup = SeasonDayTypeSchedule.parse _
    val TapChanger = parse_attribute (attribute ("""TapSchedule.TapChanger"""))
    def parse (context: Context): TapSchedule =
    {
        TapSchedule(
            sup (context),
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
    val reactive: String,
    val volt: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[TransformerControlMode]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TransformerControlMode
extends
    Parseable[TransformerControlMode]
{
    val sup = BasicElement.parse _
    val reactive = parse_attribute (attribute ("""TransformerControlMode.reactive"""))
    val volt = parse_attribute (attribute ("""TransformerControlMode.volt"""))
    def parse (context: Context): TransformerControlMode =
    {
        TransformerControlMode(
            sup (context),
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
    val b: Double,
    val b0: Double,
    val g: Double,
    val g0: Double,
    val TransformerEndInfo: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[TransformerCoreAdmittance]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TransformerCoreAdmittance
extends
    Parseable[TransformerCoreAdmittance]
{
    val sup = IdentifiedObject.parse _
    val b = parse_element (element ("""TransformerCoreAdmittance.b"""))
    val b0 = parse_element (element ("""TransformerCoreAdmittance.b0"""))
    val g = parse_element (element ("""TransformerCoreAdmittance.g"""))
    val g0 = parse_element (element ("""TransformerCoreAdmittance.g0"""))
    val TransformerEndInfo = parse_attribute (attribute ("""TransformerCoreAdmittance.TransformerEndInfo"""))
    def parse (context: Context): TransformerCoreAdmittance =
    {
        TransformerCoreAdmittance(
            sup (context),
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
    val bmagSat: Double,
    val endNumber: Int,
    val grounded: Boolean,
    val magBaseU: Double,
    val magSatFlux: Double,
    val rground: Double,
    val xground: Double,
    val BaseVoltage: String,
    val CoreAdmittance: String,
    val PhaseTapChanger: String,
    val RatioTapChanger: String,
    val StarImpedance: String,
    val Terminal: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0, false, 0.0, 0.0, 0.0, 0.0, null, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[TransformerEnd]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TransformerEnd
extends
    Parseable[TransformerEnd]
{
    val sup = IdentifiedObject.parse _
    val bmagSat = parse_element (element ("""TransformerEnd.bmagSat"""))
    val endNumber = parse_element (element ("""TransformerEnd.endNumber"""))
    val grounded = parse_element (element ("""TransformerEnd.grounded"""))
    val magBaseU = parse_element (element ("""TransformerEnd.magBaseU"""))
    val magSatFlux = parse_element (element ("""TransformerEnd.magSatFlux"""))
    val rground = parse_element (element ("""TransformerEnd.rground"""))
    val xground = parse_element (element ("""TransformerEnd.xground"""))
    val BaseVoltage = parse_attribute (attribute ("""TransformerEnd.BaseVoltage"""))
    val CoreAdmittance = parse_attribute (attribute ("""TransformerEnd.CoreAdmittance"""))
    val PhaseTapChanger = parse_attribute (attribute ("""TransformerEnd.PhaseTapChanger"""))
    val RatioTapChanger = parse_attribute (attribute ("""TransformerEnd.RatioTapChanger"""))
    val StarImpedance = parse_attribute (attribute ("""TransformerEnd.StarImpedance"""))
    val Terminal = parse_attribute (attribute ("""TransformerEnd.Terminal"""))
    def parse (context: Context): TransformerEnd =
    {
        TransformerEnd(
            sup (context),
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
    val r: Double,
    val r0: Double,
    val x: Double,
    val x0: Double,
    val FromTransformerEnd: String,
    val FromTransformerEndInfo: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[TransformerMeshImpedance]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TransformerMeshImpedance
extends
    Parseable[TransformerMeshImpedance]
{
    val sup = IdentifiedObject.parse _
    val r = parse_element (element ("""TransformerMeshImpedance.r"""))
    val r0 = parse_element (element ("""TransformerMeshImpedance.r0"""))
    val x = parse_element (element ("""TransformerMeshImpedance.x"""))
    val x0 = parse_element (element ("""TransformerMeshImpedance.x0"""))
    val FromTransformerEnd = parse_attribute (attribute ("""TransformerMeshImpedance.FromTransformerEnd"""))
    val FromTransformerEndInfo = parse_attribute (attribute ("""TransformerMeshImpedance.FromTransformerEndInfo"""))
    def parse (context: Context): TransformerMeshImpedance =
    {
        TransformerMeshImpedance(
            sup (context),
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
    val r: Double,
    val r0: Double,
    val x: Double,
    val x0: Double,
    val TransformerEndInfo: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[TransformerStarImpedance]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TransformerStarImpedance
extends
    Parseable[TransformerStarImpedance]
{
    val sup = IdentifiedObject.parse _
    val r = parse_element (element ("""TransformerStarImpedance.r"""))
    val r0 = parse_element (element ("""TransformerStarImpedance.r0"""))
    val x = parse_element (element ("""TransformerStarImpedance.x"""))
    val x0 = parse_element (element ("""TransformerStarImpedance.x0"""))
    val TransformerEndInfo = parse_attribute (attribute ("""TransformerStarImpedance.TransformerEndInfo"""))
    def parse (context: Context): TransformerStarImpedance =
    {
        TransformerStarImpedance(
            sup (context),
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
    val PowerTransformer: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Equipment: Equipment = sup.asInstanceOf[Equipment]
    override def copy (): Row = { return (clone ().asInstanceOf[TransformerTank]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TransformerTank
extends
    Parseable[TransformerTank]
{
    val sup = Equipment.parse _
    val PowerTransformer = parse_attribute (attribute ("""TransformerTank.PowerTransformer"""))
    def parse (context: Context): TransformerTank =
    {
        TransformerTank(
            sup (context),
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
    val phases: String,
    val TransformerTank: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def TransformerEnd: TransformerEnd = sup.asInstanceOf[TransformerEnd]
    override def copy (): Row = { return (clone ().asInstanceOf[TransformerTankEnd]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TransformerTankEnd
extends
    Parseable[TransformerTankEnd]
{
    val sup = TransformerEnd.parse _
    val phases = parse_attribute (attribute ("""TransformerTankEnd.phases"""))
    val TransformerTank = parse_attribute (attribute ("""TransformerTankEnd.TransformerTank"""))
    def parse (context: Context): TransformerTankEnd =
    {
        TransformerTankEnd(
            sup (context),
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
    val BusbarSection: String,
    val RegulationSchedule: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { return (clone ().asInstanceOf[VoltageControlZone]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object VoltageControlZone
extends
    Parseable[VoltageControlZone]
{
    val sup = PowerSystemResource.parse _
    val BusbarSection = parse_attribute (attribute ("""VoltageControlZone.BusbarSection"""))
    val RegulationSchedule = parse_attribute (attribute ("""VoltageControlZone.RegulationSchedule"""))
    def parse (context: Context): VoltageControlZone =
    {
        VoltageControlZone(
            sup (context),
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
    val A: String,
    val D: String,
    val I: String,
    val Y: String,
    val Yn: String,
    val Z: String,
    val Zn: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[WindingConnection]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WindingConnection
extends
    Parseable[WindingConnection]
{
    val sup = BasicElement.parse _
    val A = parse_attribute (attribute ("""WindingConnection.A"""))
    val D = parse_attribute (attribute ("""WindingConnection.D"""))
    val I = parse_attribute (attribute ("""WindingConnection.I"""))
    val Y = parse_attribute (attribute ("""WindingConnection.Y"""))
    val Yn = parse_attribute (attribute ("""WindingConnection.Yn"""))
    val Z = parse_attribute (attribute ("""WindingConnection.Z"""))
    val Zn = parse_attribute (attribute ("""WindingConnection.Zn"""))
    def parse (context: Context): WindingConnection =
    {
        WindingConnection(
            sup (context),
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

object _Wires
{
    def register: Unit =
    {
        ACLineSegment.register
        ACLineSegmentPhase.register
        AsynchronousMachine.register
        AsynchronousMachineKind.register
        Breaker.register
        BusbarSection.register
        Clamp.register
        CompositeSwitch.register
        Conductor.register
        Connector.register
        CoolantType.register
        Cut.register
        Disconnector.register
        EarthFaultCompensator.register
        EnergyConsumer.register
        EnergyConsumerPhase.register
        EnergySource.register
        ExternalNetworkInjection.register
        FrequencyConverter.register
        Fuse.register
        Ground.register
        GroundDisconnector.register
        GroundingImpedance.register
        Jumper.register
        Junction.register
        Line.register
        LinearShuntCompensator.register
        LinearShuntCompensatorPhase.register
        LoadBreakSwitch.register
        MutualCoupling.register
        NonlinearShuntCompensator.register
        NonlinearShuntCompensatorPhase.register
        NonlinearShuntCompensatorPhasePoint.register
        NonlinearShuntCompensatorPoint.register
        PerLengthImpedance.register
        PerLengthLineParameter.register
        PerLengthPhaseImpedance.register
        PerLengthSequenceImpedance.register
        PetersenCoil.register
        PetersenCoilModeKind.register
        PhaseImpedanceData.register
        PhaseShuntConnectionKind.register
        PhaseTapChanger.register
        PhaseTapChangerAsymmetrical.register
        PhaseTapChangerLinear.register
        PhaseTapChangerNonLinear.register
        PhaseTapChangerSymmetrical.register
        PhaseTapChangerTable.register
        PhaseTapChangerTablePoint.register
        PhaseTapChangerTabular.register
        Plant.register
        PowerTransformer.register
        PowerTransformerEnd.register
        ProtectedSwitch.register
        RatioTapChanger.register
        RatioTapChangerTable.register
        RatioTapChangerTablePoint.register
        ReactiveCapabilityCurve.register
        Recloser.register
        RegulatingCondEq.register
        RegulatingControl.register
        RegulatingControlModeKind.register
        RegulationSchedule.register
        RotatingMachine.register
        SVCControlMode.register
        Sectionaliser.register
        SeriesCompensator.register
        ShortCircuitRotorKind.register
        ShuntCompensator.register
        ShuntCompensatorPhase.register
        SinglePhaseKind.register
        StaticVarCompensator.register
        Switch.register
        SwitchPhase.register
        SwitchSchedule.register
        SynchronousMachine.register
        SynchronousMachineKind.register
        SynchronousMachineOperatingMode.register
        TapChanger.register
        TapChangerControl.register
        TapChangerTablePoint.register
        TapSchedule.register
        TransformerControlMode.register
        TransformerCoreAdmittance.register
        TransformerEnd.register
        TransformerMeshImpedance.register
        TransformerStarImpedance.register
        TransformerTank.register
        TransformerTankEnd.register
        VoltageControlZone.register
        WindingConnection.register
    }
}