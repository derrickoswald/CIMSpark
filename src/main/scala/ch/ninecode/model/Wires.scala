package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/*
 * Package: Wires
 */

case class ACLineSegment
(
    override val sup: Conductor,
    val b0ch: Double,
    val bch: Double,
    val g0ch: Double,
    val gch: Double,
    val r0: Double,
    val r: Double,
    val shortCircuitEndTemperature: Double,
    val x0: Double,
    val x: Double,
    val LineGroundingAction: String,
    val LineJumpingAction: String,
    val PerLengthImpedance: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, null) }
    def Conductor: Conductor = sup.asInstanceOf[Conductor]
    override def copy (): Row = { return (clone ().asInstanceOf[ACLineSegment]); }
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
    val b0ch = parse_element (element ("""ACLineSegment.b0ch"""))
    val bch = parse_element (element ("""ACLineSegment.bch"""))
    val g0ch = parse_element (element ("""ACLineSegment.g0ch"""))
    val gch = parse_element (element ("""ACLineSegment.gch"""))
    val r0 = parse_element (element ("""ACLineSegment.r0"""))
    val r = parse_element (element ("""ACLineSegment.r"""))
    val shortCircuitEndTemperature = parse_element (element ("""ACLineSegment.shortCircuitEndTemperature"""))
    val x0 = parse_element (element ("""ACLineSegment.x0"""))
    val x = parse_element (element ("""ACLineSegment.x"""))
    val LineGroundingAction = parse_attribute (attribute ("""ACLineSegment.LineGroundingAction"""))
    val LineJumpingAction = parse_attribute (attribute ("""ACLineSegment.LineJumpingAction"""))
    val PerLengthImpedance = parse_attribute (attribute ("""ACLineSegment.PerLengthImpedance"""))
    def parse (context: Context): ACLineSegment =
    {
        return (
            ACLineSegment
            (
                Conductor.parse (context),
                toDouble (b0ch (context), context),
                toDouble (bch (context), context),
                toDouble (g0ch (context), context),
                toDouble (gch (context), context),
                toDouble (r0 (context), context),
                toDouble (r (context), context),
                toDouble (shortCircuitEndTemperature (context), context),
                toDouble (x0 (context), context),
                toDouble (x (context), context),
                LineGroundingAction (context),
                LineJumpingAction (context),
                PerLengthImpedance (context)
            )
        )
    }
}

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
    override def copy (): Row = { return (clone ().asInstanceOf[ACLineSegmentPhase]); }
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
    val phase = parse_attribute (attribute ("""ACLineSegmentPhase.phase"""))
    val ACLineSegment = parse_attribute (attribute ("""ACLineSegmentPhase.ACLineSegment"""))
    def parse (context: Context): ACLineSegmentPhase =
    {
        return (
            ACLineSegmentPhase
            (
                PowerSystemResource.parse (context),
                phase (context),
                ACLineSegment (context)
            )
        )
    }
}

case class AsynchronousMachine
(
    override val sup: RotatingMachine,
    val AsynchronousMachineType: String,
    val converterFedDrive: Boolean,
    val efficiency: Double,
    val ialrRatio: Double,
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
    override def copy (): Row = { return (clone ().asInstanceOf[AsynchronousMachine]); }
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
    val AsynchronousMachineType = parse_attribute (attribute ("""AsynchronousMachine.AsynchronousMachineType"""))
    val converterFedDrive = parse_element (element ("""AsynchronousMachine.converterFedDrive"""))
    val efficiency = parse_element (element ("""AsynchronousMachine.efficiency"""))
    val ialrRatio = parse_element (element ("""AsynchronousMachine.ialrRatio"""))
    val nominalFrequency = parse_element (element ("""AsynchronousMachine.nominalFrequency"""))
    val nominalSpeed = parse_element (element ("""AsynchronousMachine.nominalSpeed"""))
    val polePairNumber = parse_element (element ("""AsynchronousMachine.polePairNumber"""))
    val ratedMechanicalPower = parse_element (element ("""AsynchronousMachine.ratedMechanicalPower"""))
    val reversible = parse_element (element ("""AsynchronousMachine.reversible"""))
    val rr1 = parse_element (element ("""AsynchronousMachinerr1.rr1"""))
    val rr2 = parse_element (element ("""AsynchronousMachinerr1.rr2"""))
    val rxLockedRotorRatio = parse_element (element ("""AsynchronousMachinerr1.rxLockedRotorRatio"""))
    val tpo = parse_element (element ("""AsynchronousMachinerr1.tpo"""))
    val tppo = parse_element (element ("""AsynchronousMachinerr1.tppo"""))
    val xlr1 = parse_element (element ("""AsynchronousMachinerr1.xlr1"""))
    val xlr2 = parse_element (element ("""AsynchronousMachinerr1.xlr2"""))
    val xm = parse_element (element ("""AsynchronousMachinerr1.xm"""))
    val xp = parse_element (element ("""AsynchronousMachinerr1.xp"""))
    val xpp = parse_element (element ("""AsynchronousMachinerr1.xpp"""))
    val xs = parse_element (element ("""AsynchronousMachinerr1.xs"""))
    val AsynchronousMachineDynamics = parse_attribute (attribute ("""AsynchronousMachine.AsynchronousMachineDynamics"""))
    def parse (context: Context): AsynchronousMachine =
    {
        return (
            AsynchronousMachine
            (
                RotatingMachine.parse (context),
                AsynchronousMachineType (context),
                toBoolean (converterFedDrive (context), context),
                toDouble (efficiency (context), context),
                toDouble (ialrRatio (context), context),
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
        )
    }
}

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
    override def copy (): Row = { return (clone ().asInstanceOf[Breaker]); }
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
    val inTransitTime = parse_element (element ("""Breaker.inTransitTime"""))
    def parse (context: Context): Breaker =
    {
        return (
            Breaker
            (
                ProtectedSwitch.parse (context),
                toDouble (inTransitTime (context), context)
            )
        )
    }
}


// From SparkR package:
//busbars = sql (sqlContext, "select * from BusbarSection")
//rbusbars = SparkR::collect (busbars, stringsAsFactors=FALSE)
//# first busbar
//b = rbusbars[1,]
//# sup - first column = list of 1
//b = rbusbars[1,][[1]]
//# Connector
//b = rbusbars[1,][[1]][[1]]
//# ConductingEquipment
//b = rbusbars[1,][[1]][[1]][[1]]
//# Equipment
//b = rbusbars[1,][[1]][[1]][[1]][[1]]
//# PowerSystemResource
//b = rbusbars[1,][[1]][[1]][[1]][[1]][[1]]
//# IdentifiedObject
//b = rbusbars[1,][[1]][[1]][[1]][[1]][[1]][[1]]

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
    override def copy (): Row = { return (clone ().asInstanceOf[BusbarSection]); }
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
    val ipMax = parse_element (element ("""BusbarSection.ipMax"""))
    val VoltageControlZone = parse_attribute (attribute ("""BusbarSection.VoltageControlZone"""))
    def parse (context: Context): BusbarSection =
    {
        return (
            BusbarSection
            (
                Connector.parse (context),
                toDouble (ipMax (context), context),
                VoltageControlZone (context)
            )
        )
    }
}

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
    override def copy (): Row = { return (clone ().asInstanceOf[Clamp]); }
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
    val lengthFromTerminal1 = parse_element (element ("""Clamp.lengthFromTerminal1"""))
    val ACLineSegment = parse_attribute (attribute ("""Clamp.ACLineSegment"""))
    def parse (context: Context): Clamp =
    {
        return (
            Clamp
            (
                ConductingEquipment.parse (context),
                toDouble (lengthFromTerminal1 (context), context),
                ACLineSegment (context)
            )
        )
    }
}

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
    override def copy (): Row = { return (clone ().asInstanceOf[CompositeSwitch]); }
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
    val compositeSwitchType = parse_element (element ("""CompositeSwitch.compositeSwitchType"""))
    def parse (context: Context): CompositeSwitch =
    {
        return (
            CompositeSwitch
            (
                Equipment.parse (context),
                compositeSwitchType (context)
            )
        )
    }
}

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
    override def copy (): Row = { return (clone ().asInstanceOf[Conductor]); }
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
    val len = parse_element (element ("""Conductor.length"""))
    def parse (context: Context): Conductor =
    {
        return (
            Conductor
            (
                ConductingEquipment.parse (context),
                toDouble (len (context), context)
            )
        )
    }
}

case class Connector
(
    override val sup: ConductingEquipment
)
extends
    Element
{
    def this () = { this (null) }
    def ConductingEquipment: ConductingEquipment = sup.asInstanceOf[ConductingEquipment]
    override def copy (): Row = { return (clone ().asInstanceOf[Connector]); }
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
    def parse (context: Context): Connector =
    {
        return (
            Connector
            (
                ConductingEquipment.parse (context)
            )
        )
    }
}

case class Cut
(
    override val sup: Switch,
    val lengthFromTerminal: Double,
    val ACLineSegment: String,
    val CutAction: String

)
extends
    Element
{
    def this () = { this (null, 0.0, null, null) }
    def Switch: Switch = sup.asInstanceOf[Switch]
    override def copy (): Row = { return (clone ().asInstanceOf[Cut]); }
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
    val lengthFromTerminal = parse_element (element ("""Cut.lengthFromTerminal"""))
    val ACLineSegment = parse_attribute (attribute ("""Cut.ACLineSegment"""))
    val CutAction = parse_attribute (attribute ("""Cut.CutAction"""))
    def parse (context: Context): Cut =
    {
        return (
            Cut
            (
                Switch.parse (context),
                toDouble (lengthFromTerminal (context), context),
                ACLineSegment (context),
                CutAction (context)
            )
        )
    }
}

case class Disconnector
(
    override val sup: Switch
)
extends
    Element
{
    def this () = { this (null) }
    def Switch: Switch = sup.asInstanceOf[Switch]
    override def copy (): Row = { return (clone ().asInstanceOf[Disconnector]); }
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
    def parse (context: Context): Disconnector =
    {
        return (
            Disconnector
            (
                Switch.parse (context)
            )
        )
    }
}

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
    override def copy (): Row = { return (clone ().asInstanceOf[EarthFaultCompensator]); }
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
    val r = parse_element (element ("""EarthFaultCompensator.r"""))
    def parse (context: Context): EarthFaultCompensator =
    {
        return (
            EarthFaultCompensator
            (
                ConductingEquipment.parse (context),
                toDouble (r (context), context)
            )
        )
    }
}

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
    override def copy (): Row = { return (clone ().asInstanceOf[EnergyConsumer]); }
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
        return (
            EnergyConsumer
            (
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
        )
    }
}

case class EnergyConsumerPhase
(
    override val sup: PowerSystemResource,
    val pfixed: Double,
    val pfixedPct: Double,
    val SinglePhaseKind: String,
    val qfixed: Double,
    val qfixedPct: Double,
    val EnergyConsumer: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null, 0.0, 0.0, null) }
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { return (clone ().asInstanceOf[EnergyConsumerPhase]); }
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
    val pfixed = parse_element (element ("""EnergyConsumerPhase.pfixed"""))
    val pfixedPct = parse_element (element ("""EnergyConsumerPhase.pfixedPct"""))
    val SinglePhaseKind = parse_attribute (attribute ("""EnergyConsumerPhase.SinglePhaseKind"""))
    val qfixed = parse_element (element ("""EnergyConsumerPhase.qfixed"""))
    val qfixedPct = parse_element (element ("""EnergyConsumerPhase.qfixedPct"""))
    val EnergyConsumer = parse_attribute (attribute ("""EnergyConsumerPhase.EnergyConsumer"""))
    def parse (context: Context): EnergyConsumerPhase =
    {
        return (
            EnergyConsumerPhase
            (
                PowerSystemResource.parse (context),
                toDouble (pfixed (context), context),
                toDouble (pfixedPct (context), context),
                SinglePhaseKind (context),
                toDouble (qfixed (context), context),
                toDouble (qfixedPct (context), context),
                EnergyConsumer (context)
            )
        )
    }
}

case class EnergySource
(
    override val sup: ConductingEquipment,
    val activePower: Double,
    val nominalVoltage: Double,
    val r0: Double,
    val r: Double,
    val reactivePower: Double,
    val rn: Double,
    val voltageAngle: Double,
    val voltageMagnitude: Double,
    val x0: Double,
    val x: Double,
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
    override def copy (): Row = { return (clone ().asInstanceOf[EnergySource]); }
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
    val activePower = parse_element (element ("""EnergySource.activePower"""))
    val nominalVoltage = parse_element (element ("""EnergySource.nominalVoltage"""))
    val r0 = parse_element (element ("""EnergySource.r0"""))
    val r = parse_element (element ("""EnergySource.r"""))
    val reactivePower = parse_element (element ("""EnergySource.reactivePower"""))
    val rn = parse_element (element ("""EnergySource.rn"""))
    val voltageAngle = parse_element (element ("""EnergySource.voltageAngle"""))
    val voltageMagnitude = parse_element (element ("""EnergySource.voltageMagnitude"""))
    val x0 = parse_element (element ("""EnergySource.x0"""))
    val x = parse_element (element ("""EnergySource.x"""))
    val xn = parse_element (element ("""EnergySource.xn"""))
    val EnergySchedulingType = parse_attribute (attribute ("""EnergySource.EnergySchedulingType"""))
    val EnergySourceAction = parse_attribute (attribute ("""EnergySource.EnergySourceAction"""))
    val WindTurbineType3or4Dynamics = parse_attribute (attribute ("""EnergySource.WindTurbineType3or4Dynamics"""))
    def parse (context: Context): EnergySource =
    {
        return (
            EnergySource
            (
                ConductingEquipment.parse (context),
                toDouble (activePower (context), context),
                toDouble (nominalVoltage (context), context),
                toDouble (r0 (context), context),
                toDouble (r (context), context),
                toDouble (reactivePower (context), context),
                toDouble (rn (context), context),
                toDouble (voltageAngle (context), context),
                toDouble (voltageMagnitude (context), context),
                toDouble (x0 (context), context),
                toDouble (x (context), context),
                toDouble (xn (context), context),
                EnergySchedulingType (context),
                EnergySourceAction (context),
                WindTurbineType3or4Dynamics (context)
            )
        )
    }
}

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
    override def copy (): Row = { return (clone ().asInstanceOf[ExternalNetworkInjection]); }
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
        return (
            ExternalNetworkInjection
            (
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
        )
    }
}

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
    override def copy (): Row = { return (clone ().asInstanceOf[FrequencyConverter]); }
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
    val frequency = parse_element (element ("""FrequencyConverter.frequency"""))
    val maxP = parse_element (element ("""FrequencyConverter.maxP"""))
    val maxU = parse_element (element ("""FrequencyConverter.maxU"""))
    val minP = parse_element (element ("""FrequencyConverter.minP"""))
    val minU = parse_element (element ("""FrequencyConverter.minU"""))
    def parse (context: Context): FrequencyConverter =
    {
        return (
            FrequencyConverter
            (
                RegulatingCondEq.parse (context),
                toDouble (frequency (context), context),
                toDouble (maxP (context), context),
                toDouble (maxU (context), context),
                toDouble (minP (context), context),
                toDouble (minU (context), context)
            )
        )
    }
}

case class Fuse
(
    override val sup: Switch
)
extends
    Element
{
    def this () = { this (null) }
    def Switch: Switch = sup.asInstanceOf[Switch]
    override def copy (): Row = { return (clone ().asInstanceOf[Fuse]); }
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
    def parse (context: Context): Fuse =
    {
        return (
            Fuse
            (
                Switch.parse (context)
            )
        )
    }
}

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
    override def copy (): Row = { return (clone ().asInstanceOf[Ground]); }
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
    val GroundAction = parse_attribute (attribute ("""Ground.GroundAction"""))
    def parse (context: Context): Ground =
    {
        return (
            Ground
            (
                ConductingEquipment.parse (context),
                GroundAction (context)
            )
        )
    }
}

case class GroundDisconnector
(
    override val sup: Switch
)
extends
    Element
{
    def this () = { this (null) }
    def Switch: Switch = sup.asInstanceOf[Switch]
    override def copy (): Row = { return (clone ().asInstanceOf[GroundDisconnector]); }
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
    def parse (context: Context): GroundDisconnector =
    {
        return (
            GroundDisconnector
            (
                Switch.parse (context)
            )
        )
    }
}

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
    override def copy (): Row = { return (clone ().asInstanceOf[GroundingImpedance]); }
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
    val x = parse_element (element ("""GroundingImpedance.x"""))
    def parse (context: Context): GroundingImpedance =
    {
        return (
            GroundingImpedance
            (
                EarthFaultCompensator.parse (context),
                toDouble (x (context), context)
            )
        )
    }
}

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
    override def copy (): Row = { return (clone ().asInstanceOf[Jumper]); }
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
    val JumperAction = parse_attribute (attribute ("""Jumper.JumperAction"""))
    def parse (context: Context): Jumper =
    {
        return (
            Jumper
            (
                Switch.parse (context),
                JumperAction (context)
            )
        )
    }
}

case class Junction
(
    override val sup: Connector
)
extends
    Element
{
    def this () = { this (null) }
    def Connector: Connector = sup.asInstanceOf[Connector]
    override def copy (): Row = { return (clone ().asInstanceOf[Junction]); }
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
    def parse (context: Context): Junction =
    {
        return (
            Junction
            (
                Connector.parse (context)
            )
        )
    }
}

case class Line
(
    override val sup: ConnectivityNodeContainer,
    val Region: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def ConnectivityNodeContainer: ConnectivityNodeContainer = sup.asInstanceOf[ConnectivityNodeContainer]
    override def copy (): Row = { return (clone ().asInstanceOf[Line]); }
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
    val Region = parse_attribute (attribute ("""Line.Region"""))
    def parse (context: Context): Line =
    {
        return (
            Line
            (
                ConnectivityNodeContainer.parse (context),
                Region (context)
            )
        )
    }
}

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
    override def copy (): Row = { return (clone ().asInstanceOf[LinearShuntCompensator]); }
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
    val b0PerSection = parse_element (element ("""LinearShuntCompensator.b0PerSection"""))
    val bPerSection = parse_element (element ("""LinearShuntCompensator.bPerSection"""))
    val g0PerSection = parse_element (element ("""LinearShuntCompensator.g0PerSection"""))
    val gPerSection = parse_element (element ("""LinearShuntCompensator.gPerSection"""))
    def parse (context: Context): LinearShuntCompensator =
    {
        return (
            LinearShuntCompensator
            (
                ShuntCompensator.parse (context),
                toDouble (b0PerSection (context), context),
                toDouble (bPerSection (context), context),
                toDouble (g0PerSection (context), context),
                toDouble (gPerSection (context), context)
            )
        )
    }
}

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
    override def copy (): Row = { return (clone ().asInstanceOf[LinearShuntCompensatorPhase]); }
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
    val bPerSection = parse_element (element ("""LinearShuntCompensatorPhase.bPerSection"""))
    val gPerSection = parse_element (element ("""LinearShuntCompensatorPhase.gPerSection"""))
    def parse (context: Context): LinearShuntCompensatorPhase =
    {
        return (
            LinearShuntCompensatorPhase
            (
                ShuntCompensatorPhase.parse (context),
                toDouble (bPerSection (context), context),
                toDouble (gPerSection (context), context)
            )
        )
    }
}

case class LoadBreakSwitch
(
    override val sup: ProtectedSwitch
)
extends
    Element
{
    def this () = { this (null) }
    def ProtectedSwitch: ProtectedSwitch = sup.asInstanceOf[ProtectedSwitch]
    override def copy (): Row = { return (clone ().asInstanceOf[LoadBreakSwitch]); }
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
    def parse (context: Context): LoadBreakSwitch =
    {
        return (
            LoadBreakSwitch
            (
                ProtectedSwitch.parse (context)
            )
        )
    }
}

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
    override def copy (): Row = { return (clone ().asInstanceOf[MutualCoupling]); }
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
        return (
            MutualCoupling
            (
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
        )
    }
}

case class NonLinearShuntCompensator
(
    override val sup: ShuntCompensator
)
extends
    Element
{
    def this () = { this (null) }
    def ShuntCompensator: ShuntCompensator = sup.asInstanceOf[ShuntCompensator]
    override def copy (): Row = { return (clone ().asInstanceOf[NonLinearShuntCompensator]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object NonLinearShuntCompensator
extends
    Parseable[NonLinearShuntCompensator]
{
    def parse (context: Context): NonLinearShuntCompensator =
    {
        return (
            NonLinearShuntCompensator
            (
                ShuntCompensator.parse (context)
            )
        )
    }
}

case class NonLinearShuntCompensatorPhase
(
    override val sup: ShuntCompensatorPhase
)
extends
    Element
{
    def this () = { this (null) }
    def ShuntCompensatorPhase: ShuntCompensatorPhase = sup.asInstanceOf[ShuntCompensatorPhase]
    override def copy (): Row = { return (clone ().asInstanceOf[NonLinearShuntCompensatorPhase]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object NonLinearShuntCompensatorPhase
extends
    Parseable[NonLinearShuntCompensatorPhase]
{
    def parse (context: Context): NonLinearShuntCompensatorPhase =
    {
        return (
            NonLinearShuntCompensatorPhase
            (
                ShuntCompensatorPhase.parse (context)
            )
        )
    }
}

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
    override def copy (): Row = { return (clone ().asInstanceOf[NonlinearShuntCompensatorPhasePoint]); }
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
    val b = parse_element (element ("""NonlinearShuntCompensatorPhasePoint.b"""))
    val g = parse_element (element ("""NonlinearShuntCompensatorPhasePoint.g"""))
    val sectionNumber = parse_element (element ("""NonlinearShuntCompensatorPhasePoint.sectionNumber"""))
    def parse (context: Context): NonlinearShuntCompensatorPhasePoint =
    {
        return (
            NonlinearShuntCompensatorPhasePoint
            (
                BasicElement.parse (context),
                toDouble (b (context), context),
                toDouble (g (context), context),
                toInteger (sectionNumber (context), context)
            )
        )
    }
}

case class NonlinearShuntCompensatorPoint
(
    override val sup: BasicElement,
    val b0: Double,
    val b: Double,
    val g0: Double,
    val g: Double,
    val sectionNumber: Int
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[NonlinearShuntCompensatorPoint]); }
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
    val b = parse_element (element ("""NonlinearShuntCompensatorPoint.b"""))
    val b0 = parse_element (element ("""NonlinearShuntCompensatorPoint.b0"""))
    val g = parse_element (element ("""NonlinearShuntCompensatorPoint.g"""))
    val g0 = parse_element (element ("""NonlinearShuntCompensatorPoint.g0"""))
    val sectionNumber = parse_element (element ("""NonlinearShuntCompensatorPoint.sectionNumber"""))
    def parse (context: Context): NonlinearShuntCompensatorPoint =
    {
        return (
            NonlinearShuntCompensatorPoint
            (
                BasicElement.parse (context),
                toDouble (b (context), context),
                toDouble (b0 (context), context),
                toDouble (g (context), context),
                toDouble (g0 (context), context),
                toInteger (sectionNumber (context), context)
            )
        )
    }
}

case class PerLengthImpedance
(
    override val sup: PerLengthLineParameter
)
extends
    Element
{
    def this () = { this (null) }
    def PerLengthLineParameter: PerLengthLineParameter = sup.asInstanceOf[PerLengthLineParameter]
    override def copy (): Row = { return (clone ().asInstanceOf[PerLengthImpedance]); }
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
    def parse (context: Context): PerLengthImpedance =
    {
        return (
            PerLengthImpedance
            (
                PerLengthLineParameter.parse (context)
            )
        )
    }
}

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
    override def copy (): Row = { return (clone ().asInstanceOf[PerLengthLineParameter]); }
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
    val WireSpacingInfo = parse_attribute (attribute ("""PerLengthLineParameter.WireSpacingInfo"""))
    def parse (context: Context): PerLengthLineParameter =
    {
        return (
            PerLengthLineParameter
            (
                IdentifiedObject.parse (context),
                WireSpacingInfo (context)
            )
        )
    }
}

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
    override def copy (): Row = { return (clone ().asInstanceOf[PerLengthPhaseImpedance]); }
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
    val conductorCount = parse_element (element ("""PerLengthPhaseImpedance.conductorCount"""))
    def parse (context: Context): PerLengthPhaseImpedance =
    {
        return (
            PerLengthPhaseImpedance
            (
                PerLengthImpedance.parse (context),
                toInteger (conductorCount (context), context)
            )
        )
    }
}

case class PerLengthSequenceImpedance
(
    override val sup: PerLengthImpedance,
    val b0ch: Double,
    val bch: Double,
    val g0ch: Double,
    val gch: Double,
    val r0: Double,
    val r: Double,
    val x0: Double,
    val x: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def PerLengthImpedance: PerLengthImpedance = sup.asInstanceOf[PerLengthImpedance]
    override def copy (): Row = { return (clone ().asInstanceOf[PerLengthSequenceImpedance]); }
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
    val b0ch = parse_element (element ("""PerLengthSequenceImpedance.b0ch"""))
    val bch = parse_element (element ("""PerLengthSequenceImpedance.bch"""))
    val g0ch = parse_element (element ("""PerLengthSequenceImpedance.g0ch"""))
    val gch = parse_element (element ("""PerLengthSequenceImpedance.gch"""))
    val r0 = parse_element (element ("""PerLengthSequenceImpedance.r0"""))
    val r = parse_element (element ("""PerLengthSequenceImpedance.r"""))
    val x0 = parse_element (element ("""PerLengthSequenceImpedance.x0"""))
    val x = parse_element (element ("""PerLengthSequenceImpedance.x"""))
    def parse (context: Context): PerLengthSequenceImpedance =
    {
        return (
            PerLengthSequenceImpedance
            (
                PerLengthImpedance.parse (context),
                toDouble (b0ch (context), context),
                toDouble (bch (context), context),
                toDouble (g0ch (context), context),
                toDouble (gch (context), context),
                toDouble (r0 (context), context),
                toDouble (r (context), context),
                toDouble (x0 (context), context),
                toDouble (x (context), context)
            )
        )
    }
}

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
    override def copy (): Row = { return (clone ().asInstanceOf[PetersenCoil]); }
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
    val mode = parse_attribute (attribute ("""PetersenCoil.mode"""))
    val nominalU = parse_element (element ("""PetersenCoil.nominalU"""))
    val offsetCurrent = parse_element (element ("""PetersenCoil.offsetCurrent"""))
    val positionCurrent = parse_element (element ("""PetersenCoil.positionCurrent"""))
    val xGroundMax = parse_element (element ("""PetersenCoil.xGroundMax"""))
    val xGroundMin = parse_element (element ("""PetersenCoil.xGroundMin"""))
    val xGroundNominal = parse_element (element ("""PetersenCoil.xGroundNominal"""))
    def parse (context: Context): PetersenCoil =
    {
        return (
            PetersenCoil
            (
                EarthFaultCompensator.parse (context),
                mode (context),
                toDouble (nominalU (context), context),
                toDouble (offsetCurrent (context), context),
                toDouble (positionCurrent (context), context),
                toDouble (xGroundMax (context), context),
                toDouble (xGroundMin (context), context),
                toDouble (xGroundNominal (context), context)
            )
        )
    }
}

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
    override def copy (): Row = { return (clone ().asInstanceOf[PhaseImpedanceData]); }
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
    val b = parse_element (element ("""PhaseImpedanceData.b"""))
    val r = parse_element (element ("""PhaseImpedanceData.r"""))
    val sequenceNumber = parse_element (element ("""PhaseImpedanceData.sequenceNumber"""))
    val x = parse_element (element ("""PhaseImpedanceData.x"""))
    val PhaseImpedance = parse_attribute (attribute ("""PhaseImpedanceData.PhaseImpedance"""))
    def parse (context: Context): PhaseImpedanceData =
    {
        return (
            PhaseImpedanceData
            (
                BasicElement.parse (context),
                toDouble (b (context), context),
                toDouble (r (context), context),
                toInteger (sequenceNumber (context), context),
                toDouble (x (context), context),
                PhaseImpedance (context)
            )
        )
    }
}

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
    override def copy (): Row = { return (clone ().asInstanceOf[PhaseTapChanger]); }
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
    val TransformerEnd = parse_attribute (attribute ("""PhaseTapChanger.TransformerEnd"""))
    def parse (context: Context): PhaseTapChanger =
    {
        return (
            PhaseTapChanger
            (
                TapChanger.parse (context),
                TransformerEnd (context)
            )
        )
    }
}

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
    override def copy (): Row = { return (clone ().asInstanceOf[PhaseTapChangerAsymmetrical]); }
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
    val windingConnectionAngle = parse_element (element ("""PhaseTapChangerAsymmetrical.windingConnectionAngle"""))
    def parse (context: Context): PhaseTapChangerAsymmetrical =
    {
        return (
            PhaseTapChangerAsymmetrical
            (
                PhaseTapChangerNonLinear.parse (context),
                toDouble (windingConnectionAngle (context), context)
            )
        )
    }
}

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
    override def copy (): Row = { return (clone ().asInstanceOf[PhaseTapChangerLinear]); }
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
    val stepPhaseShiftIncrement = parse_element (element ("""PhaseTapChangerLinear.stepPhaseShiftIncrement"""))
    val xMax = parse_element (element ("""PhaseTapChangerLinear.xMax"""))
    val xMin = parse_element (element ("""PhaseTapChangerLinear.xMin"""))
    def parse (context: Context): PhaseTapChangerLinear =
    {
        return (
            PhaseTapChangerLinear
            (
                PhaseTapChanger.parse (context),
                toDouble (stepPhaseShiftIncrement (context), context),
                toDouble (xMax (context), context),
                toDouble (xMin (context), context)
            )
        )
    }
}

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
    override def copy (): Row = { return (clone ().asInstanceOf[PhaseTapChangerNonLinear]); }
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
    val voltageStepIncrement = parse_element (element ("""PhaseTapChangerNonLinear.voltageStepIncrement"""))
    val xMax = parse_element (element ("""PhaseTapChangerNonLinear.xMax"""))
    val xMin = parse_element (element ("""PhaseTapChangerNonLinear.xMin"""))
    def parse (context: Context): PhaseTapChangerNonLinear =
    {
        return (
            PhaseTapChangerNonLinear
            (
                PhaseTapChanger.parse (context),
                toDouble (voltageStepIncrement (context), context),
                toDouble (xMax (context), context),
                toDouble (xMin (context), context)
            )
        )
    }
}

case class PhaseTapChangerSymmetrical
(
    override val sup: PhaseTapChangerNonLinear
)
extends
    Element
{
    def this () = { this (null) }
    def PhaseTapChangerNonLinear: PhaseTapChangerNonLinear = sup.asInstanceOf[PhaseTapChangerNonLinear]
    override def copy (): Row = { return (clone ().asInstanceOf[PhaseTapChangerSymmetrical]); }
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
    def parse (context: Context): PhaseTapChangerSymmetrical =
    {
        return (
            PhaseTapChangerSymmetrical
            (
                PhaseTapChangerNonLinear.parse (context)
            )
        )
    }
}

case class PhaseTapChangerTable
(
    override val sup: IdentifiedObject
)
extends
    Element
{
    def this () = { this (null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[PhaseTapChangerTable]); }
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
    def parse (context: Context): PhaseTapChangerTable =
    {
        return (
            PhaseTapChangerTable
            (
                IdentifiedObject.parse (context)
            )
        )
    }
}

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
    override def copy (): Row = { return (clone ().asInstanceOf[PhaseTapChangerTablePoint]); }
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
    val angle = parse_element (element ("""PhaseTapChangerTablePoint.angle"""))
    val PhaseTapChangerTable = parse_attribute (attribute ("""PhaseTapChangerTablePoint.PhaseTapChangerTable"""))
    def parse (context: Context): PhaseTapChangerTablePoint =
    {
        return (
            PhaseTapChangerTablePoint
            (
                TapChangerTablePoint.parse (context),
                toDouble (angle (context), context),
                PhaseTapChangerTable (context)
            )
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
    override def copy (): Row = { return (clone ().asInstanceOf[PhaseTapChangerTabular]); }
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
    val PhaseTapChangerTable = parse_attribute (attribute ("""PhaseTapChangerTabular.PhaseTapChangerTable"""))
    def parse (context: Context): PhaseTapChangerTabular =
    {
        return (
            PhaseTapChangerTabular
            (
                PhaseTapChanger.parse (context),
                PhaseTapChangerTable (context)
            )
        )
    }
}

case class Plant
(
    override val sup: EquipmentContainer
)
extends
    Element
{
    def this () = { this (null) }
    def EquipmentContainer: EquipmentContainer = sup.asInstanceOf[EquipmentContainer]
    override def copy (): Row = { return (clone ().asInstanceOf[Plant]); }
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
    def parse (context: Context): Plant =
    {
        return (
            Plant
            (
                EquipmentContainer.parse (context)
            )
        )
    }
}

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
    override def copy (): Row = { return (clone ().asInstanceOf[PowerTransformer]); }
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
    val beforeShCircuitHighestOperatingCurrent = parse_element (element ("""PowerTransformer.beforeShCircuitHighestOperatingCurrent"""))
    val beforeShCircuitHighestOperatingVoltage = parse_element (element ("""PowerTransformer.beforeShCircuitHighestOperatingVoltage"""))
    val beforeShortCircuitAnglePf = parse_element (element ("""PowerTransformer.beforeShortCircuitAnglePf"""))
    val highSideMinOperatingU = parse_element (element ("""PowerTransformer.highSideMinOperatingU"""))
    val isPartOfGeneratorUnit = parse_element (element ("""PowerTransformer.isPartOfGeneratorUnit"""))
    val operationalValuesConsidered = parse_element (element ("""PowerTransformer.operationalValuesConsidered"""))
    val vectorGroup = parse_element (element ("""PowerTransformer.vectorGroup"""))
    def parse (context: Context): PowerTransformer =
    {
        return (
            PowerTransformer
            (
                ConductingEquipment.parse (context),
                toDouble (beforeShCircuitHighestOperatingCurrent (context), context),
                toDouble (beforeShCircuitHighestOperatingVoltage (context), context),
                toDouble (beforeShortCircuitAnglePf (context), context),
                toDouble (highSideMinOperatingU (context), context),
                toBoolean (isPartOfGeneratorUnit (context), context),
                toBoolean (operationalValuesConsidered (context), context),
                vectorGroup (context)
            )
        )
    }
}

case class PowerTransformerEnd
(
    override val sup: TransformerEnd,
    val b0: Double,
    val b: Double,
    val connectionKind: String,
    val g0: Double,
    val g: Double,
    val phaseAngleClock: Int,
    val r0: Double,
    val r: Double,
    val ratedS: Double,
    val ratedU: Double,
    val x0: Double,
    val x: Double,
    val PowerTransformer: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null, 0.0, 0.0, 0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null) }
    def TransformerEnd: TransformerEnd = sup.asInstanceOf[TransformerEnd]
    override def copy (): Row = { return (clone ().asInstanceOf[PowerTransformerEnd]); }
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
    val b0 = parse_element (element ("""PowerTransformerEnd.b0"""))
    val b = parse_element (element ("""PowerTransformerEnd.b"""))
    val connectionKind = parse_attribute (attribute ("""PowerTransformerEnd.connectionKind"""))
    val g0 = parse_element (element ("""PowerTransformerEnd.g0"""))
    val g = parse_element (element ("""PowerTransformerEnd.g"""))
    val phaseAngleClock = parse_element (element ("""PowerTransformerEnd.phaseAngleClock"""))
    val r0 = parse_element (element ("""PowerTransformerEnd.r0"""))
    val r = parse_element (element ("""PowerTransformerEnd.r"""))
    val ratedS = parse_element (element ("""PowerTransformerEnd.ratedS"""))
    val ratedU = parse_element (element ("""PowerTransformerEnd.ratedU"""))
    val x0 = parse_element (element ("""PowerTransformerEnd.x0"""))
    val x = parse_element (element ("""PowerTransformerEnd.x"""))
    val PowerTransformer = parse_attribute (attribute ("""PowerTransformerEnd.PowerTransformer"""))
    def parse (context: Context): PowerTransformerEnd =
    {
        return (
            PowerTransformerEnd
            (
                TransformerEnd.parse (context),
                toDouble (b0 (context), context),
                toDouble (b (context), context),
                connectionKind (context),
                toDouble (g0 (context), context),
                toDouble (g (context), context),
                toInteger (phaseAngleClock (context), context),
                toDouble (r0 (context), context),
                toDouble (r (context), context),
                toDouble (ratedS (context), context),
                toDouble (ratedU (context), context),
                toDouble (x0 (context), context),
                toDouble (x (context), context),
                PowerTransformer (context)
            )
        )
    }
}

case class ProtectedSwitch
(
    override val sup: Switch,
    val breakingCapacity: Double
    // ToDo: RecloseSequences
)
extends
    Element
{
    def this () = { this (null, 0.0) }
    def Switch: Switch = sup.asInstanceOf[Switch]
    override def copy (): Row = { return (clone ().asInstanceOf[ProtectedSwitch]); }
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
    val breakingCapacity = parse_attribute (attribute ("""ProtectedSwitch.breakingCapacity"""))
    def parse (context: Context): ProtectedSwitch =
    {
        return (
            ProtectedSwitch
            (
                Switch.parse (context),
                toDouble (breakingCapacity (context), context)
            )
        )
    }
}

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
    override def copy (): Row = { return (clone ().asInstanceOf[RatioTapChanger]); }
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
    val stepVoltageIncrement = parse_element (element ("""RatioTapChanger.stepVoltageIncrement"""))
    val tculControlMode = parse_attribute (attribute ("""RatioTapChanger.tculControlMode"""))
    val RatioTapChangerTable = parse_attribute (attribute ("""RatioTapChanger.RatioTapChangerTable"""))
    val TransformerEnd = parse_attribute (attribute ("""RatioTapChanger.TransformerEnd"""))
    def parse (context: Context): RatioTapChanger =
    {
        return (
            RatioTapChanger
            (
                TapChanger.parse (context),
                toDouble (stepVoltageIncrement (context), context),
                tculControlMode (context),
                RatioTapChangerTable (context),
                TransformerEnd (context)
            )
        )
    }
}

case class RatioTapChangerTable
(
    override val sup: IdentifiedObject
)
extends
    Element
{
    def this () = { this (null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[RatioTapChangerTable]); }
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
    def parse (context: Context): RatioTapChangerTable =
    {
        return (
            RatioTapChangerTable
            (
                IdentifiedObject.parse (context)
            )
        )
    }
}

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
    override def copy (): Row = { return (clone ().asInstanceOf[RatioTapChangerTablePoint]); }
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
    val RatioTapChangerTable = parse_attribute (attribute ("""RatioTapChangerTablePoint.RatioTapChangerTable"""))
    def parse (context: Context): RatioTapChangerTablePoint =
    {
        return (
            RatioTapChangerTablePoint
            (
                TapChangerTablePoint.parse (context),
                RatioTapChangerTable (context)
            )
        )
    }
}

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
    override def copy (): Row = { return (clone ().asInstanceOf[ReactiveCapabilityCurve]); }
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
    val coolantTemperature = parse_element (element ("""ReactiveCapabilityCurve.coolantTemperature"""))
    val hydrogenPressure = parse_element (element ("""ReactiveCapabilityCurve.hydrogenPressure"""))
    def parse (context: Context): ReactiveCapabilityCurve =
    {
        return (
            ReactiveCapabilityCurve
            (
                Curve.parse (context),
                toDouble (coolantTemperature (context), context),
                toDouble (hydrogenPressure (context), context)
            )
        )
    }
}

case class Recloser
(
    override val sup: ProtectedSwitch
)
extends
    Element
{
    def this () = { this (null) }
    def ProtectedSwitch: ProtectedSwitch = sup.asInstanceOf[ProtectedSwitch]
    override def copy (): Row = { return (clone ().asInstanceOf[Recloser]); }
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
    def parse (context: Context): Recloser =
    {
        return (
            Recloser
            (
                ProtectedSwitch.parse (context)
            )
        )
    }
}

case class RegulatingCondEq
(
    override val sup: ConductingEquipment,
    val controlledEnabled: Boolean,
    val RegulatingControl: String
)
extends
    Element
{
    def this () = { this (null, false, null) }
    def ConductingEquipment: ConductingEquipment = sup.asInstanceOf[ConductingEquipment]
    override def copy (): Row = { return (clone ().asInstanceOf[RegulatingCondEq]); }
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
    val controlledEnabled = parse_element (element ("""RegulatingCondEq.controlledEnabled"""))
    val RegulatingControl = parse_attribute (attribute ("""RegulatingCondEq.RegulatingControl"""))
    def parse (context: Context): RegulatingCondEq =
    {
        return (
            RegulatingCondEq
            (
                ConductingEquipment.parse (context),
                toBoolean (controlledEnabled (context), context),
                RegulatingControl (context)
            )
        )
    }
}

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
    override def copy (): Row = { return (clone ().asInstanceOf[RegulatingControl]); }
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
        return (
            RegulatingControl
            (
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
        )
    }
}

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
    override def copy (): Row = { return (clone ().asInstanceOf[RegulationSchedule]); }
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
    val RegulatingControl = parse_attribute (attribute ("""RegulationSchedule.RegulatingControl"""))
    def parse (context: Context): RegulationSchedule =
    {
        return (
            RegulationSchedule
            (
                SeasonDayTypeSchedule.parse (context),
                RegulatingControl (context)
            )
        )
    }
}

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
    override def copy (): Row = { return (clone ().asInstanceOf[RotatingMachine]); }
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
    val p = parse_element (element ("""RotatingMachine.p"""))
    val q = parse_element (element ("""RotatingMachine.q"""))
    val ratedPowerFactor = parse_element (element ("""RotatingMachine.ratedPowerFactor"""))
    val ratedS = parse_element (element ("""RotatingMachine.ratedS"""))
    val ratedU = parse_element (element ("""RotatingMachine.ratedU"""))
    val GeneratingUnit = parse_attribute (attribute ("""RotatingMachine.GeneratingUnit"""))
    val HydroPump = parse_attribute (attribute ("""RotatingMachine.HydroPump"""))
    def parse (context: Context): RotatingMachine =
    {
        return (
            RotatingMachine
            (
                RegulatingCondEq.parse (context),
                toDouble (p (context), context),
                toDouble (q (context), context),
                toDouble (ratedPowerFactor (context), context),
                toDouble (ratedS (context), context),
                toDouble (ratedU (context), context),
                GeneratingUnit (context),
                HydroPump (context)
            )
        )
    }
}

case class Sectionaliser
(
    override val sup: Switch
)
extends
    Element
{
    def this () = { this (null) }
    def Switch: Switch = sup.asInstanceOf[Switch]
    override def copy (): Row = { return (clone ().asInstanceOf[Sectionaliser]); }
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
    def parse (context: Context): Sectionaliser =
    {
        return (
            Sectionaliser
            (
                Switch.parse (context)
            )
        )
    }
}

case class SeriesCompensator
(
    override val sup: ConductingEquipment,
    val r0: Double,
    val r: Double,
    val varistorPresent: Boolean,
    val varistorRatedCurrent: Double,
    val varistorVoltageThreshold: Double,
    val x0: Double,
    val x: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, false, 0.0, 0.0, 0.0, 0.0) }
    def ConductingEquipment: ConductingEquipment = sup.asInstanceOf[ConductingEquipment]
    override def copy (): Row = { return (clone ().asInstanceOf[SeriesCompensator]); }
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
    val r0 = parse_element (element ("""SeriesCompensator.r0"""))
    val r = parse_element (element ("""SeriesCompensator.r"""))
    val varistorPresent = parse_element (element ("""SeriesCompensator.varistorPresent"""))
    val varistorRatedCurrent = parse_element (element ("""SeriesCompensator.varistorRatedCurrent"""))
    val varistorVoltageThreshold = parse_element (element ("""SeriesCompensator.varistorVoltageThreshold"""))
    val x0 = parse_element (element ("""SeriesCompensator.x0"""))
    val x = parse_element (element ("""SeriesCompensator.x"""))
    def parse (context: Context): SeriesCompensator =
    {
        return (
            SeriesCompensator
            (
                ConductingEquipment.parse (context),
                toDouble (r0 (context), context),
                toDouble (r (context), context),
                toBoolean (varistorPresent (context), context),
                toDouble (varistorRatedCurrent (context), context),
                toDouble (varistorVoltageThreshold (context), context),
                toDouble (x0 (context), context),
                toDouble (x (context), context)
            )
        )
    }
}

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
    override def copy (): Row = { return (clone ().asInstanceOf[ShuntCompensator]); }
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
        return (
            ShuntCompensator
            (
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
        )
    }
}

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
    override def copy (): Row = { return (clone ().asInstanceOf[ShuntCompensatorPhase]); }
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
    val maximumSections = parse_element (element ("""ShuntCompensatorPhase.maximumSections"""))
    val normalSections = parse_element (element ("""ShuntCompensatorPhase.normalSections"""))
    val phase = parse_attribute (attribute ("""ShuntCompensatorPhase.phase"""))
    val ShuntCompensator = parse_attribute (attribute ("""ShuntCompensatorPhase.ShuntCompensator"""))
    def parse (context: Context): ShuntCompensatorPhase =
    {
        return (
            ShuntCompensatorPhase
            (
                PowerSystemResource.parse (context),
                toInteger (maximumSections (context), context),
                toInteger (normalSections (context), context),
                phase (context),
                ShuntCompensator (context)
            )
        )
    }
}

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
    override def copy (): Row = { return (clone ().asInstanceOf[StaticVarCompensator]); }
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
    val capacitiveRating = parse_element (element ("""StaticVarCompensator.capacitiveRating"""))
    val inductiveRating = parse_element (element ("""StaticVarCompensator.inductiveRating"""))
    val q = parse_element (element ("""StaticVarCompensator.q"""))
    val sVCControlMode = parse_attribute (attribute ("""StaticVarCompensator.sVCControlMode"""))
    val slope = parse_element (element ("""StaticVarCompensator.slope"""))
    val voltageSetPoint = parse_element (element ("""StaticVarCompensator.voltageSetPoint"""))
    def parse (context: Context): StaticVarCompensator =
    {
        return (
            StaticVarCompensator
            (
                RegulatingCondEq.parse (context),
                toDouble (capacitiveRating (context), context),
                toDouble (inductiveRating (context), context),
                toDouble (q (context), context),
                sVCControlMode (context),
                toDouble (slope (context), context),
                toDouble (voltageSetPoint (context), context)
            )
        )
    }
}

case class Switch
(
    override val sup: ConductingEquipment,
    val normalOpen: Boolean,
    val open: Boolean,
    val ratedCurrent: Double,
    val retained: Boolean,
    val switchOnCount: Int,
    // ToDo: Date handling
    //val switchOnDate: Date
    val CompositeSwitch: String,
    val Outage: String,
    val SwitchAction: String
)
extends
    Element
{
    def this () = { this (null, false, false, 0.0, false, 0, null, null, null) }
    def ConductingEquipment: ConductingEquipment = sup.asInstanceOf[ConductingEquipment]
    override def copy (): Row = { return (clone ().asInstanceOf[Switch]); }
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
    val normalOpen = parse_element (element ("""Switch.normalOpen"""))
    val open = parse_element (element ("""Switch.open"""))
    val ratedCurrent = parse_element (element ("""Switch.ratedCurrent"""))
    val retained = parse_element (element ("""Switch.retained"""))
    val switchOnCount = parse_element (element ("""Switch.switchOnCount"""))
    val CompositeSwitch = parse_attribute (attribute ("""Switch.CompositeSwitch"""))
    val Outage = parse_attribute (attribute ("""Switch.Outage"""))
    val SwitchAction = parse_attribute (attribute ("""Switch.SwitchAction"""))
    def parse (context: Context): Switch =
    {
        return (
            Switch
            (
                ConductingEquipment.parse (context),
                toBoolean (normalOpen (context), context),
                toBoolean (open (context), context),
                toDouble (ratedCurrent (context), context),
                toBoolean (retained (context), context),
                toInteger (switchOnCount (context), context),
                CompositeSwitch (context),
                Outage (context),
                SwitchAction (context)
            )
        )
    }
}

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
    override def copy (): Row = { return (clone ().asInstanceOf[SwitchPhase]); }
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
    val closed = parse_element (element ("""SwitchPhase.closed"""))
    val normalOpen = parse_element (element ("""SwitchPhase.normalOpen"""))
    val phaseSide1 = parse_attribute (attribute ("""SwitchPhase.phaseSide1"""))
    val phaseSide2 = parse_attribute (attribute ("""SwitchPhase.phaseSide2"""))
    val Switch = parse_attribute (attribute ("""SwitchPhase.Switch"""))
    def parse (context: Context): SwitchPhase =
    {
        return (
            SwitchPhase
            (
                PowerSystemResource.parse (context),
                toBoolean (closed (context), context),
                toBoolean (normalOpen (context), context),
                phaseSide1 (context),
                phaseSide2 (context),
                Switch (context)
            )
        )
    }
}

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
    override def copy (): Row = { return (clone ().asInstanceOf[SwitchSchedule]); }
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
    val Switch = parse_attribute (attribute ("""SwitchSchedule.Switch"""))
    def parse (context: Context): SwitchSchedule =
    {
        return (
            SwitchSchedule
            (
                SeasonDayTypeSchedule.parse (context),
                Switch (context)
            )
        )
    }
}

case class SynchronousMachine
(
    // remove some parameters: error: Implementation restriction: case classes cannot have more than 22 parameters.

    override val sup: RotatingMachine,
    val aVRToManualLag: Double,
    val aVRToManualLead: Double,
    val baseQ: Double,
    // val condenserP: Double,
    // val coolantCondition: Double,
    val coolantType: String,
    // val earthing: Boolean,
    // val earthingStarPointR: Double,
    // val earthingStarPointX: Double,
    val ikk: Double,
    // val manualToAVR: Double,
    val maxQ: Double,
    val maxU: Double,
    val minQ: Double,
    val minU: Double,
    val mu: Double,
    val operatingMode: String,
    val qPercent: Double,
    val r0: Double,
    val r2: Double,
    val r: Double,
    val referencePriority: Int,
    // val satDirectSubtransX: Double,
    // val satDirectSyncX: Double,
    // val satDirectTransX: Double,
    // val shortCircuitRotorType: String,
    val typ: String, // cannot use type
    // val voltageRegulationRange: Double,
    val x0: Double,
    val x2: Double,
    val InitialReactiveCapabilityCurve: String,
    val SynchronousMachineDynamics: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, /* 0.0, 0.0, */ null,
        /* false, 0.0, 0.0, */ 0.0, /* 0.0, */ 0.0, 0.0, 0.0, 0.0, 0.0, null, 0.0, 0.0, 0.0, 0.0, 0,
        /* 0.0, 0.0, 0.0, null, */ null, /* 0.0, */ 0.0, 0.0, null, null) }
    def RotatingMachine: RotatingMachine = sup.asInstanceOf[RotatingMachine]
    override def copy (): Row = { return (clone ().asInstanceOf[SynchronousMachine]); }
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
    val r0 = parse_element (element ("""SynchronousMachine.r0"""))
    val r2 = parse_element (element ("""SynchronousMachine.r2"""))
    val r = parse_element (element ("""SynchronousMachine.r"""))
    val referencePriority = parse_element (element ("""SynchronousMachine.referencePriority"""))
    val satDirectSubtransX = parse_element (element ("""SynchronousMachine.satDirectSubtransX"""))
    val satDirectSyncX = parse_element (element ("""SynchronousMachine.satDirectSyncX"""))
    val satDirectTransX = parse_element (element ("""SynchronousMachine.satDirectTransX"""))
    val shortCircuitRotorType = parse_attribute (attribute ("""SynchronousMachine.shortCircuitRotorType"""))
    val typ = parse_attribute (attribute ("""SynchronousMachine.typ"""))
    val voltageRegulationRange = parse_element (element ("""SynchronousMachine.voltageRegulationRange"""))
    val x0 = parse_element (element ("""SynchronousMachine.x0"""))
    val x2 = parse_element (element ("""SynchronousMachine.x2"""))
    val InitialReactiveCapabilityCurve = parse_attribute (attribute ("""SynchronousMachine.InitialReactiveCapabilityCurve"""))
    val SynchronousMachineDynamics = parse_attribute (attribute ("""SynchronousMachine.SynchronousMachineDynamics"""))
    def parse (context: Context): SynchronousMachine =
    {
        return (
            SynchronousMachine
            (
                RotatingMachine.parse (context),
                toDouble (aVRToManualLag (context), context),
                toDouble (aVRToManualLead (context), context),
                toDouble (baseQ (context), context),
                // toDouble (condenserP (context), context),
                // toDouble (coolantCondition (context), context),
                coolantType (context),
                // toBoolean (earthing (context), context),
                // toDouble (earthingStarPointR (context), context),
                // toDouble (earthingStarPointX (context), context),
                toDouble (ikk (context), context),
                // toDouble (manualToAVR (context), context),
                toDouble (maxQ (context), context),
                toDouble (maxU (context), context),
                toDouble (minQ (context), context),
                toDouble (minU (context), context),
                toDouble (mu (context), context),
                operatingMode (context),
                toDouble (qPercent (context), context),
                toDouble (r0 (context), context),
                toDouble (r2 (context), context),
                toDouble (r (context), context),
                toInteger (referencePriority (context), context),
                // toDouble (satDirectSubtransX (context), context),
                // toDouble (satDirectSyncX (context), context),
                // toDouble (satDirectTransX (context), context),
                // shortCircuitRotorType (context),
                typ (context),
                // toDouble (voltageRegulationRange (context), context),
                toDouble (x0 (context), context),
                toDouble (x2 (context), context),
                InitialReactiveCapabilityCurve (context),
                SynchronousMachineDynamics (context)
            )
        )
    }
}

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
    override def copy (): Row = { return (clone ().asInstanceOf[TapChanger]); }
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
        return (
            TapChanger
            (
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
        )
    }
}

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
    override def copy (): Row = { return (clone ().asInstanceOf[TapChangerControl]); }
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
    val limitVoltage = parse_element (element ("""TapChangerControl.limitVoltage"""))
    val lineDropCompensation = parse_element (element ("""TapChangerControl.lineDropCompensation"""))
    val lineDropR = parse_element (element ("""TapChangerControl.lineDropR"""))
    val lineDropX = parse_element (element ("""TapChangerControl.lineDropX"""))
    val reverseLineDropR = parse_element (element ("""TapChangerControl.reverseLineDropR"""))
    val reverseLineDropX = parse_element (element ("""TapChangerControl.reverseLineDropX"""))
    def parse (context: Context): TapChangerControl =
    {
        return (
            TapChangerControl
            (
                RegulatingControl.parse (context),
                toDouble (limitVoltage (context), context),
                toBoolean (lineDropCompensation (context), context),
                toDouble (lineDropR (context), context),
                toDouble (lineDropX (context), context),
                toDouble (reverseLineDropR (context), context),
                toDouble (reverseLineDropX (context), context)
            )
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
    override def copy (): Row = { return (clone ().asInstanceOf[TapChangerTablePoint]); }
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
    val b = parse_element (element ("""TapChangerTablePoint.b"""))
    val g = parse_element (element ("""TapChangerTablePoint.g"""))
    val r = parse_element (element ("""TapChangerTablePoint.r"""))
    val ratio = parse_element (element ("""TapChangerTablePoint.ratio"""))
    val step = parse_element (element ("""TapChangerTablePoint.step"""))
    val x = parse_element (element ("""TapChangerTablePoint.x"""))
    def parse (context: Context): TapChangerTablePoint =
    {
        return (
            TapChangerTablePoint
            (
                BasicElement.parse (context),
                toDouble (b (context), context),
                toDouble (g (context), context),
                toDouble (r (context), context),
                toDouble (ratio (context), context),
                toInteger (step (context), context),
                toDouble (x (context), context)
            )
        )
    }
}

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
    override def copy (): Row = { return (clone ().asInstanceOf[TapSchedule]); }
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
    val TapChanger = parse_attribute (attribute ("""TapSchedule.TapChanger"""))
    def parse (context: Context): TapSchedule =
    {
        return (
            TapSchedule
            (
                SeasonDayTypeSchedule.parse (context),
                TapChanger (context)
            )
        )
    }
}

case class TransformerCoreAdmittance
(
    override val sup: IdentifiedObject,
    val b0: Double,
    val b: Double,
    val g0: Double,
    val g: Double,
    val TransformerEndInfo: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[TransformerCoreAdmittance]); }
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
    val b0 = parse_element (element ("""TransformerCoreAdmittance.b0"""))
    val b = parse_element (element ("""TransformerCoreAdmittance.b"""))
    val g0 = parse_element (element ("""TransformerCoreAdmittance.g0"""))
    val g = parse_element (element ("""TransformerCoreAdmittance.g"""))
    val TransformerEndInfo = parse_attribute (attribute ("""TransformerCoreAdmittance.TransformerEndInfo"""))
    def parse (context: Context): TransformerCoreAdmittance =
    {
        return (
            TransformerCoreAdmittance
            (
                IdentifiedObject.parse (context),
                toDouble (b0 (context), context),
                toDouble (b (context), context),
                toDouble (g0 (context), context),
                toDouble (g (context), context),
                TransformerEndInfo (context)
            )
        )
    }
}

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
    override def copy (): Row = { return (clone ().asInstanceOf[TransformerEnd]); }
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
        return (
            TransformerEnd
            (
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
        )
    }
}

case class TransformerMeshImpedance
(
    override val sup: IdentifiedObject,
    val r0: Double,
    val r: Double,
    val x0: Double,
    val x: Double,
    val FromTransformerEnd: String,
    val FromTransformerEndInfo: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[TransformerMeshImpedance]); }
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
    val r0 = parse_element (element ("""TransformerMeshImpedance.r0"""))
    val r = parse_element (element ("""TransformerMeshImpedance.r"""))
    val x0 = parse_element (element ("""TransformerMeshImpedance.x0"""))
    val x = parse_element (element ("""TransformerMeshImpedance.x"""))
    val FromTransformerEnd = parse_attribute (attribute ("""TransformerMeshImpedance.FromTransformerEnd"""))
    val FromTransformerEndInfo = parse_attribute (attribute ("""TransformerMeshImpedance.FromTransformerEndInfo"""))
    def parse (context: Context): TransformerMeshImpedance =
    {
        return (
            TransformerMeshImpedance
            (
                IdentifiedObject.parse (context),
                toDouble (r0 (context), context),
                toDouble (r (context), context),
                toDouble (x0 (context), context),
                toDouble (x (context), context),
                FromTransformerEnd (context),
                FromTransformerEndInfo (context)
            )
        )
    }
}

case class TransformerStarImpedance
(
    override val sup: IdentifiedObject,
    val r0: Double,
    val r: Double,
    val x0: Double,
    val x: Double,
    val TransformerEndInfo: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[TransformerStarImpedance]); }
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
    val r0 = parse_element (element ("""TransformerStarImpedance.r0"""))
    val r = parse_element (element ("""TransformerStarImpedance.r"""))
    val x0 = parse_element (element ("""TransformerStarImpedance.x0"""))
    val x = parse_element (element ("""TransformerStarImpedance.x"""))
    val TransformerEndInfo = parse_attribute (attribute ("""TransformerStarImpedance.TransformerEndInfo"""))
    def parse (context: Context): TransformerStarImpedance =
    {
        return (
            TransformerStarImpedance
            (
                IdentifiedObject.parse (context),
                toDouble (r0 (context), context),
                toDouble (r (context), context),
                toDouble (x0 (context), context),
                toDouble (x (context), context),
                TransformerEndInfo (context)
            )
        )
    }
}

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
    override def copy (): Row = { return (clone ().asInstanceOf[TransformerTank]); }
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
    val PowerTransformer = parse_attribute (attribute ("""TransformerTank.PowerTransformer"""))
    def parse (context: Context): TransformerTank =
    {
        return (
            TransformerTank
            (
                Equipment.parse (context),
                PowerTransformer (context)
            )
        )
    }
}

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
    override def copy (): Row = { return (clone ().asInstanceOf[TransformerTankEnd]); }
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
    val phases = parse_attribute (attribute ("""TransformerTankEnd.phases"""))
    val TransformerTank = parse_attribute (attribute ("""TransformerTankEnd.TransformerTank"""))
    def parse (context: Context): TransformerTankEnd =
    {
        return (
            TransformerTankEnd
            (
                TransformerEnd.parse (context),
                phases (context),
                TransformerTank (context)
            )
        )
    }
}

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
    override def copy (): Row = { return (clone ().asInstanceOf[VoltageControlZone]); }
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
    val BusbarSection = parse_attribute (attribute ("""VoltageControlZone.BusbarSection"""))
    val RegulationSchedule = parse_attribute (attribute ("""VoltageControlZone.RegulationSchedule"""))
    def parse (context: Context): VoltageControlZone =
    {
        return (
            VoltageControlZone
            (
                PowerSystemResource.parse (context),
                BusbarSection (context),
                RegulationSchedule (context)
            )
        )
    }
}

object Wires
{
    def register: Unit =
    {
        ACLineSegment.register
        ACLineSegmentPhase.register
        AsynchronousMachine.register
        Breaker.register
        BusbarSection.register
        Clamp.register
        CompositeSwitch.register
        Conductor.register
        Connector.register
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
        NonLinearShuntCompensator.register
        NonLinearShuntCompensatorPhase.register
        NonlinearShuntCompensatorPhasePoint.register
        NonlinearShuntCompensatorPoint.register
        PerLengthImpedance.register
        PerLengthLineParameter.register
        PerLengthPhaseImpedance.register
        PerLengthSequenceImpedance.register
        PetersenCoil.register
        PhaseImpedanceData.register
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
        RegulationSchedule.register
        RotatingMachine.register
        Sectionaliser.register
        SeriesCompensator.register
        ShuntCompensator.register
        ShuntCompensatorPhase.register
        StaticVarCompensator.register
        Switch.register
        SwitchPhase.register
        SwitchSchedule.register
        SynchronousMachine.register
        TapChanger.register
        TapChangerControl.register
        TapChangerTablePoint.register
        TapSchedule.register
        TransformerCoreAdmittance.register
        TransformerEnd.register
        TransformerMeshImpedance.register
        TransformerStarImpedance.register
        TransformerTank.register
        TransformerTankEnd.register
        VoltageControlZone.register
    }
}
