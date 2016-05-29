package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.Context

case class ACLineSegment
(
    override val sup: Element,
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
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[ACLineSegment]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ACLineSegment
extends
    Parseable[ACLineSegment]
with
    Parser
{
    val b0ch = parse_element (element ("""ACLineSegment.b0ch"""))_
    val bch = parse_element (element ("""ACLineSegment.bch"""))_
    val g0ch = parse_element (element ("""ACLineSegment.g0ch"""))_
    val gch = parse_element (element ("""ACLineSegment.gch"""))_
    val r0 = parse_element (element ("""ACLineSegment.r0"""))_
    val r = parse_element (element ("""ACLineSegment.r"""))_
    val shortCircuitEndTemperature = parse_element (element ("""ACLineSegment.shortCircuitEndTemperature"""))_
    val x0 = parse_element (element ("""ACLineSegment.x0"""))_
    val x = parse_element (element ("""ACLineSegment.x"""))_
    val LineGroundingAction = parse_attribute (attribute ("""ACLineSegment.LineGroundingAction"""))_
    val LineJumpingAction = parse_attribute (attribute ("""ACLineSegment.LineJumpingAction"""))_
    val PerLengthImpedance = parse_attribute (attribute ("""ACLineSegment.PerLengthImpedance"""))_
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
    override val sup: Element,
    val phase: String,
    val ACLineSegment: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[ACLineSegmentPhase]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ACLineSegmentPhase
extends
    Parseable[ACLineSegmentPhase]
with
    Parser
{
    val phase = parse_attribute (attribute ("""ACLineSegmentPhase.phase"""))_
    val ACLineSegment = parse_attribute (attribute ("""ACLineSegmentPhase.ACLineSegment"""))_
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

case class BusbarSection
(
    override val sup: Element,
    val ipMax: Double
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[BusbarSection]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BusbarSection
extends
    Parseable[BusbarSection]
with
    Parser
{
    val ipMax = parse_element (element ("""BusbarSection.ipMax"""))_
    def parse (context: Context): BusbarSection =
    {
        return (
            BusbarSection
            (
                Connector.parse (context),
                toDouble (ipMax (context), context)
            )
        )
    }
}

case class Conductor
(
    override val sup: Element,
    val len: Double
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[Conductor]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Conductor
extends
    Parseable[Conductor]
with
    Parser
{
    val len = parse_element (element ("""Conductor.length"""))_
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
    override val sup: Element
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[Connector]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Connector
extends
    Parseable[Connector]
with
    Parser
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

case class Disconnector
(
    override val sup: Element
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[Disconnector]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Disconnector
extends
    Parseable[Disconnector]
with
    Parser
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

case class EnergyConsumer
(
    override val sup: Element,
    val customerCount: Integer,
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
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[EnergyConsumer]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EnergyConsumer
extends
    Parseable[EnergyConsumer]
with
    Parser
{
    val customerCount = parse_element (element ("""EnergyConsumer.customerCount"""))_
    val grounded = parse_element (element ("""EnergyConsumer.grounded"""))_
    val p = parse_element (element ("""EnergyConsumer.p"""))_
    val pfixed = parse_element (element ("""EnergyConsumer.pfixed"""))_
    val pfixedPct = parse_element (element ("""EnergyConsumer.pfixedPct"""))_
    val phaseConnection = parse_attribute (attribute ("""EnergyConsumer.phaseConnection"""))_
    val q = parse_element (element ("""EnergyConsumer.q"""))_
    val qfixed = parse_element (element ("""EnergyConsumer.qfixed"""))_
    val qfixedPct = parse_element (element ("""EnergyConsumer.qfixedPct"""))_
    val LoadDynamics = parse_attribute (attribute ("""EnergyConsumer.LoadDynamics"""))_
    val LoadResponse = parse_attribute (attribute ("""EnergyConsumer.LoadResponse"""))_
    val PowerCutZone = parse_attribute (attribute ("""EnergyConsumer.PowerCutZone"""))_
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

case class Fuse
(
    override val sup: Element
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[Fuse]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Fuse
extends
    Parseable[Fuse]
with
    Parser
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

case class GroundDisconnector
(
    override val sup: Element
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[GroundDisconnector]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GroundDisconnector
extends
    Parseable[GroundDisconnector]
with
    Parser
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

case class Junction
(
    override val sup: Element
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[Junction]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Junction
extends
    Parseable[Junction]
with
    Parser
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
    override val sup: Element,
    val Region: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[Line]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Line
extends
    Parseable[Line]
with
    Parser
{
    val Region = parse_attribute (attribute ("""Line.Region"""))_
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

case class PowerTransformer
(
    override val sup: Element,
    val beforeShCircuitHighestOperatingCurrent: Double,
    val beforeShCircuitHighestOperatingVoltage: Double,
    val beforeShortCircuitAnglePf: Double,
    val highSideMinOperatingU: Double,
    val isPartOfGeneratorUnit: Boolean,
    val operationalValuesConsidered: Boolean,
    val vectorGroup: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[PowerTransformer]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PowerTransformer
extends
    Parseable[PowerTransformer]
with
    Parser
{
    val beforeShCircuitHighestOperatingCurrent = parse_element (element ("""PowerTransformer.beforeShCircuitHighestOperatingCurrent"""))_
    val beforeShCircuitHighestOperatingVoltage = parse_element (element ("""PowerTransformer.beforeShCircuitHighestOperatingVoltage"""))_
    val beforeShortCircuitAnglePf = parse_element (element ("""PowerTransformer.beforeShortCircuitAnglePf"""))_
    val highSideMinOperatingU = parse_element (element ("""PowerTransformer.highSideMinOperatingU"""))_
    val isPartOfGeneratorUnit = parse_element (element ("""PowerTransformer.isPartOfGeneratorUnit"""))_
    val operationalValuesConsidered = parse_element (element ("""PowerTransformer.operationalValuesConsidered"""))_
    val vectorGroup = parse_element (element ("""PowerTransformer.vectorGroup"""))_
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
    override val sup: Element,
    val b0: Double,
    val b: Double,
    val connectionKind: String,
    val g0: Double,
    val g: Double,
    val phaseAngleClock: Integer,
    val r0: Double,
    val r: Double,
    val ratedS: Double,
    val ratedU: Double,
    val x0: Double,
    val x: Double,
    val PowerTransformer: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[PowerTransformer]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PowerTransformerEnd
extends
    Parseable[PowerTransformerEnd]
with
    Parser
{
    val b0 = parse_element (element ("""PowerTransformerEnd.b0"""))_
    val b = parse_element (element ("""PowerTransformerEnd.b"""))_
    val connectionKind = parse_attribute (attribute ("""PowerTransformerEnd.connectionKind"""))_
    val g0 = parse_element (element ("""PowerTransformerEnd.g0"""))_
    val g = parse_element (element ("""PowerTransformerEnd.g"""))_
    val phaseAngleClock = parse_element (element ("""PowerTransformerEnd.phaseAngleClock"""))_
    val r0 = parse_element (element ("""PowerTransformerEnd.r0"""))_
    val r = parse_element (element ("""PowerTransformerEnd.r"""))_
    val ratedS = parse_element (element ("""PowerTransformerEnd.ratedS"""))_
    val ratedU = parse_element (element ("""PowerTransformerEnd.ratedU"""))_
    val x0 = parse_element (element ("""PowerTransformerEnd.x0"""))_
    val x = parse_element (element ("""PowerTransformerEnd.x"""))_
    val PowerTransformer = parse_attribute (attribute ("""PowerTransformerEnd.PowerTransformer"""))_
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

case class Switch
(
    override val sup: Element,
    val normalOpen: Boolean,
    val open: Boolean,
    // ToDo: should be Double
    val ratedCurrent: String,
    val retained: Boolean,
    val switchOnCount: Integer,
    // ToDo: Date handlien
    //val switchOnDate: Date
    val CompositeSwitch: String,
    val Outage: String,
    val SwitchAction: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[Switch]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Switch
extends
    Parseable[Switch]
with
    Parser
{
    val normalOpen = parse_element (element ("""Switch.normalOpen"""))_
    val open = parse_element (element ("""Switch.open"""))_
    val ratedCurrent = parse_element (element ("""Switch.ratedCurrent"""))_
    val retained = parse_element (element ("""Switch.retained"""))_
    val switchOnCount = parse_element (element ("""Switch.switchOnCount"""))_
    val CompositeSwitch = parse_attribute (attribute ("""Switch.CompositeSwitch"""))_
    val Outage = parse_attribute (attribute ("""Switch.Outage"""))_
    val SwitchAction = parse_attribute (attribute ("""Switch.SwitchAction"""))_
    def parse (context: Context): Switch =
    {
        return (
            Switch
            (
                ConductingEquipment.parse (context),
                toBoolean (normalOpen (context), context),
                toBoolean (open (context), context),
                ratedCurrent (context),
                toBoolean (retained (context), context),
                toInteger (switchOnCount (context), context),
                CompositeSwitch (context),
                Outage (context),
                SwitchAction (context)
            )
        )
    }
}

case class TransformerEnd
(
    override val sup: Element,
    val bmagSat: Double,
    val endNumber: Integer,
    val grounded: Boolean,
    val magBaseU: Double,
    val magSatFlux: Double,
    val rground: Double,
    val xground: Double,
    val BaseVoltage: String,
    val CoreAdmittance: String,
    val FromMeshImpedance: String,
    val FromWindingInsulations: String,
    val PhaseTapChanger: String,
    val RatioTapChanger: String,
    val StarImpedance: String,
    val Terminal: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[TransformerEnd]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TransformerEnd
extends
    Parseable[TransformerEnd]
with
    Parser
{
    val bmagSat = parse_element (element ("""TransformerEnd.bmagSat"""))_
    val endNumber = parse_element (element ("""TransformerEnd.endNumber"""))_
    val grounded = parse_element (element ("""TransformerEnd.grounded"""))_
    val magBaseU = parse_element (element ("""TransformerEnd.magBaseU"""))_
    val magSatFlux = parse_element (element ("""TransformerEnd.magSatFlux"""))_
    val rground = parse_element (element ("""TransformerEnd.rground"""))_
    val xground = parse_element (element ("""TransformerEnd.xground"""))_
    val BaseVoltage = parse_element (element ("""TransformerEnd.BaseVoltage"""))_
    val CoreAdmittance = parse_element (element ("""TransformerEnd.CoreAdmittance"""))_
    val FromMeshImpedance = parse_element (element ("""TransformerEnd.FromMeshImpedance"""))_
    val FromWindingInsulations = parse_element (element ("""TransformerEnd.FromWindingInsulations"""))_
    val PhaseTapChanger = parse_element (element ("""TransformerEnd.PhaseTapChanger"""))_
    val RatioTapChanger = parse_element (element ("""TransformerEnd.RatioTapChanger"""))_
    val StarImpedance = parse_element (element ("""TransformerEnd.StarImpedance"""))_
    val Terminal = parse_element (element ("""TransformerEnd.Terminal"""))_
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
                FromMeshImpedance (context),
                FromWindingInsulations (context),
                PhaseTapChanger (context),
                RatioTapChanger (context),
                StarImpedance (context),
                Terminal (context)
            )
        )
    }
}

case class TransformerTank
(
    override val sup: Element,
    PowerTransformer: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[TransformerTank]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TransformerTank
extends
    Parseable[TransformerTank]
with
    Parser
{
    val PowerTransformer = parse_attribute (attribute ("""TransformerTank.PowerTransformer"""))_
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
    override val sup: Element,
    val phases: String,
    val TransformerTank: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[TransformerTankEnd]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TransformerTankEnd
extends
    Parseable[TransformerTankEnd]
with
    Parser
{
    val phases = parse_attribute (attribute ("""TransformerTankEnd.phases"""))_
    val TransformerTank = parse_attribute (attribute ("""TransformerTankEnd.TransformerTank"""))_
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

object Wires
{
    def register: Unit =
    {
        ACLineSegment.register
        ACLineSegmentPhase.register
        BusbarSection.register
        Conductor.register
        Connector.register
        Disconnector.register
        EnergyConsumer.register
        Fuse.register
        GroundDisconnector.register
        Junction.register
        Line.register
        PowerTransformer.register
        PowerTransformerEnd.register
        Switch.register
        TransformerEnd.register
        TransformerTank.register
        TransformerTankEnd.register
    }
}
