package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * This section describes the standard interconnections for various types of equipment.
 * These interconnections are understood by the application programs and can be identified based on the presence of one of the key classes with a relationship to the static power flow model: SynchronousMachineDynamics, AsynchronousMachineDynamics, EnergyConsumerDynamics or WindTurbineType3or4Dynamics.
 */

/**
 * Supports connection to a terminal associated with a remote bus from which an input signal of a specific type is coming.
 * @param sup Reference to the superclass object.
 * @param remoteSignalType Type of input signal.
 * @param DiscontinuousExcitationControlDynamics Discontinuous excitation control model using this remote input signal.
 * @param PFVArControllerType1Dynamics Power Factor or VAr controller Type I model using this remote input signal.
 * @param PowerSystemStabilizerDynamics Power system stabilizer model using this remote input signal.
 * @param Terminal Remote terminal with which this input signal is associated.
 * @param UnderexcitationLimiterDynamics Underexcitation limiter model using this remote input signal.
 * @param VoltageCompensatorDynamics Voltage compensator model using this remote input signal.
 * @param WindPlantDynamics The wind plant using the remote signal.
 * @param WindTurbineType1or2Dynamics Wind generator Type 1 or Type 2 model using this remote input signal.
 * @param WindTurbineType3or4Dynamics Wind turbine Type 3 or 4 models using this remote input signal.
 */
case class RemoteInputSignal
(override val sup: IdentifiedObject,
val remoteSignalType: String,
val DiscontinuousExcitationControlDynamics: String,
val PFVArControllerType1Dynamics: String,
val PowerSystemStabilizerDynamics: String,
val Terminal: String,
val UnderexcitationLimiterDynamics: String,
val VoltageCompensatorDynamics: String,
val WindPlantDynamics: String,
val WindTurbineType1or2Dynamics: String,
val WindTurbineType3or4Dynamics: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[RemoteInputSignal]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RemoteInputSignal
extends
    Parseable[RemoteInputSignal]
{
    val sup = IdentifiedObject.parse _
    val remoteSignalType = parse_attribute (attribute ("""RemoteInputSignal.remoteSignalType"""))_
    val DiscontinuousExcitationControlDynamics = parse_attribute (attribute ("""RemoteInputSignal.DiscontinuousExcitationControlDynamics"""))_
    val PFVArControllerType1Dynamics = parse_attribute (attribute ("""RemoteInputSignal.PFVArControllerType1Dynamics"""))_
    val PowerSystemStabilizerDynamics = parse_attribute (attribute ("""RemoteInputSignal.PowerSystemStabilizerDynamics"""))_
    val Terminal = parse_attribute (attribute ("""RemoteInputSignal.Terminal"""))_
    val UnderexcitationLimiterDynamics = parse_attribute (attribute ("""RemoteInputSignal.UnderexcitationLimiterDynamics"""))_
    val VoltageCompensatorDynamics = parse_attribute (attribute ("""RemoteInputSignal.VoltageCompensatorDynamics"""))_
    val WindPlantDynamics = parse_attribute (attribute ("""RemoteInputSignal.WindPlantDynamics"""))_
    val WindTurbineType1or2Dynamics = parse_attribute (attribute ("""RemoteInputSignal.WindTurbineType1or2Dynamics"""))_
    val WindTurbineType3or4Dynamics = parse_attribute (attribute ("""RemoteInputSignal.WindTurbineType3or4Dynamics"""))_
    def parse (context: Context): RemoteInputSignal =
    {
        RemoteInputSignal(
            sup (context),
            remoteSignalType (context),
            DiscontinuousExcitationControlDynamics (context),
            PFVArControllerType1Dynamics (context),
            PowerSystemStabilizerDynamics (context),
            Terminal (context),
            UnderexcitationLimiterDynamics (context),
            VoltageCompensatorDynamics (context),
            WindPlantDynamics (context),
            WindTurbineType1or2Dynamics (context),
            WindTurbineType3or4Dynamics (context)
        )
    }
}

/**
 * Type of input signal coming from remote bus.
 * @param sup Reference to the superclass object.
 * @param remoteBranchCurrentAmplitude Input is branch current amplitude from remote terminal bus.
 * @param remoteBusFrequency Input is frequency from remote terminal bus.
 * @param remoteBusFrequencyDeviation Input is frequency deviation from remote terminal bus.
 * @param remoteBusVoltage Input is voltage from remote terminal bus.
 * @param remoteBusVoltageAmplitude Input is voltage amplitude from remote terminal bus.
 * @param remoteBusVoltageAmplitudeDerivative Input is branch current amplitude derivative from remote terminal bus.
 * @param remoteBusVoltageFrequency Input is voltage frequency from remote terminal bus.
 * @param remoteBusVoltageFrequencyDeviation Input is voltage frequency deviation from remote terminal bus.
 * @param remotePuBusVoltageDerivative Input is PU voltage derivative from remote terminal bus.
 */
case class RemoteSignalKind
(override val sup: BasicElement,
val remoteBranchCurrentAmplitude: String,
val remoteBusFrequency: String,
val remoteBusFrequencyDeviation: String,
val remoteBusVoltage: String,
val remoteBusVoltageAmplitude: String,
val remoteBusVoltageAmplitudeDerivative: String,
val remoteBusVoltageFrequency: String,
val remoteBusVoltageFrequencyDeviation: String,
val remotePuBusVoltageDerivative: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[RemoteSignalKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RemoteSignalKind
extends
    Parseable[RemoteSignalKind]
{
    val sup = BasicElement.parse _
    val remoteBranchCurrentAmplitude = parse_attribute (attribute ("""RemoteSignalKind.remoteBranchCurrentAmplitude"""))_
    val remoteBusFrequency = parse_attribute (attribute ("""RemoteSignalKind.remoteBusFrequency"""))_
    val remoteBusFrequencyDeviation = parse_attribute (attribute ("""RemoteSignalKind.remoteBusFrequencyDeviation"""))_
    val remoteBusVoltage = parse_attribute (attribute ("""RemoteSignalKind.remoteBusVoltage"""))_
    val remoteBusVoltageAmplitude = parse_attribute (attribute ("""RemoteSignalKind.remoteBusVoltageAmplitude"""))_
    val remoteBusVoltageAmplitudeDerivative = parse_attribute (attribute ("""RemoteSignalKind.remoteBusVoltageAmplitudeDerivative"""))_
    val remoteBusVoltageFrequency = parse_attribute (attribute ("""RemoteSignalKind.remoteBusVoltageFrequency"""))_
    val remoteBusVoltageFrequencyDeviation = parse_attribute (attribute ("""RemoteSignalKind.remoteBusVoltageFrequencyDeviation"""))_
    val remotePuBusVoltageDerivative = parse_attribute (attribute ("""RemoteSignalKind.remotePuBusVoltageDerivative"""))_
    def parse (context: Context): RemoteSignalKind =
    {
        RemoteSignalKind(
            sup (context),
            remoteBranchCurrentAmplitude (context),
            remoteBusFrequency (context),
            remoteBusFrequencyDeviation (context),
            remoteBusVoltage (context),
            remoteBusVoltageAmplitude (context),
            remoteBusVoltageAmplitudeDerivative (context),
            remoteBusVoltageFrequency (context),
            remoteBusVoltageFrequencyDeviation (context),
            remotePuBusVoltageDerivative (context)
        )
    }
}

object _StandardInterconnections
{
    def register: Unit =
    {
        RemoteInputSignal.register
        RemoteSignalKind.register
    }
}