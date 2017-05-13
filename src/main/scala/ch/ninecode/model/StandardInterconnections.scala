package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * This section describes the standard interconnections for various types of equipment.
 * These interconnections are understood by the application programs and can be identified based on the presence of one of the key classes with a relationship to the static power flow model: SynchronousMachineDynamics, AsynchronousMachineDynamics, EnergyConsumerDynamics or WindTurbineType3or4Dynamics.
 */

/**
 * Supports connection to a terminal associated with a remote bus from which an input signal of a specific type is coming.
 */
case class RemoteInputSignal
(

    override val sup: IdentifiedObject,

    /**
     * Type of input signal.
     */
    val remoteSignalType: String,

    /**
     * Discontinuous excitation control model using this remote input signal.
     */
    val DiscontinuousExcitationControlDynamics: String,

    /**
     * Power Factor or VAr controller Type I model using this remote input signal.
     */
    val PFVArControllerType1Dynamics: String,

    /**
     * Power system stabilizer model using this remote input signal.
     */
    val PowerSystemStabilizerDynamics: String,

    /**
     * Remote terminal with which this input signal is associated.
     */
    val Terminal: String,

    /**
     * Underexcitation limiter model using this remote input signal.
     */
    val UnderexcitationLimiterDynamics: String,

    /**
     * Voltage compensator model using this remote input signal.
     */
    val VoltageCompensatorDynamics: String,

    /**
     * The wind plant using the remote signal.
     */
    val WindPlantDynamics: String,

    /**
     * Wind generator Type 1 or Type 2 model using this remote input signal.
     */
    val WindTurbineType1or2Dynamics: String,

    /**
     * Wind turbine Type 3 or 4 models using this remote input signal.
     */
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
 */
case class RemoteSignalKind
(

    override val sup: BasicElement,

    /**
     * Input is branch current amplitude from remote terminal bus.
     */
    val remoteBranchCurrentAmplitude: String,

    /**
     * Input is frequency from remote terminal bus.
     */
    val remoteBusFrequency: String,

    /**
     * Input is frequency deviation from remote terminal bus.
     */
    val remoteBusFrequencyDeviation: String,

    /**
     * Input is voltage from remote terminal bus.
     */
    val remoteBusVoltage: String,

    /**
     * Input is voltage amplitude from remote terminal bus.
     */
    val remoteBusVoltageAmplitude: String,

    /**
     * Input is branch current amplitude derivative from remote terminal bus.
     */
    val remoteBusVoltageAmplitudeDerivative: String,

    /**
     * Input is voltage frequency from remote terminal bus.
     */
    val remoteBusVoltageFrequency: String,

    /**
     * Input is voltage frequency deviation from remote terminal bus.
     */
    val remoteBusVoltageFrequencyDeviation: String,

    /**
     * Input is PU voltage derivative from remote terminal bus.
     */
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