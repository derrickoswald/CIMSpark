package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

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
(
    override val sup: IdentifiedObject,
    remoteSignalType: String,
    DiscontinuousExcitationControlDynamics: String,
    PFVArControllerType1Dynamics: String,
    PowerSystemStabilizerDynamics: String,
    Terminal: String,
    UnderexcitationLimiterDynamics: String,
    VoltageCompensatorDynamics: String,
    WindPlantDynamics: String,
    WindTurbineType1or2Dynamics: String,
    WindTurbineType3or4Dynamics: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[RemoteInputSignal] }
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
        (if (null != remoteSignalType) "\t\t<cim:RemoteInputSignal.remoteSignalType rdf:resource=\"#" + remoteSignalType + "\"/>\n" else "") +
        (if (null != DiscontinuousExcitationControlDynamics) "\t\t<cim:RemoteInputSignal.DiscontinuousExcitationControlDynamics rdf:resource=\"#" + DiscontinuousExcitationControlDynamics + "\"/>\n" else "") +
        (if (null != PFVArControllerType1Dynamics) "\t\t<cim:RemoteInputSignal.PFVArControllerType1Dynamics rdf:resource=\"#" + PFVArControllerType1Dynamics + "\"/>\n" else "") +
        (if (null != PowerSystemStabilizerDynamics) "\t\t<cim:RemoteInputSignal.PowerSystemStabilizerDynamics rdf:resource=\"#" + PowerSystemStabilizerDynamics + "\"/>\n" else "") +
        (if (null != Terminal) "\t\t<cim:RemoteInputSignal.Terminal rdf:resource=\"#" + Terminal + "\"/>\n" else "") +
        (if (null != UnderexcitationLimiterDynamics) "\t\t<cim:RemoteInputSignal.UnderexcitationLimiterDynamics rdf:resource=\"#" + UnderexcitationLimiterDynamics + "\"/>\n" else "") +
        (if (null != VoltageCompensatorDynamics) "\t\t<cim:RemoteInputSignal.VoltageCompensatorDynamics rdf:resource=\"#" + VoltageCompensatorDynamics + "\"/>\n" else "") +
        (if (null != WindPlantDynamics) "\t\t<cim:RemoteInputSignal.WindPlantDynamics rdf:resource=\"#" + WindPlantDynamics + "\"/>\n" else "") +
        (if (null != WindTurbineType1or2Dynamics) "\t\t<cim:RemoteInputSignal.WindTurbineType1or2Dynamics rdf:resource=\"#" + WindTurbineType1or2Dynamics + "\"/>\n" else "") +
        (if (null != WindTurbineType3or4Dynamics) "\t\t<cim:RemoteInputSignal.WindTurbineType3or4Dynamics rdf:resource=\"#" + WindTurbineType3or4Dynamics + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:RemoteInputSignal rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RemoteInputSignal>\n"
    }
}

object RemoteInputSignal
extends
    Parseable[RemoteInputSignal]
{
    val remoteSignalType: (Context) => String = parse_attribute (attribute ("""RemoteInputSignal.remoteSignalType"""))
    val DiscontinuousExcitationControlDynamics: (Context) => String = parse_attribute (attribute ("""RemoteInputSignal.DiscontinuousExcitationControlDynamics"""))
    val PFVArControllerType1Dynamics: (Context) => String = parse_attribute (attribute ("""RemoteInputSignal.PFVArControllerType1Dynamics"""))
    val PowerSystemStabilizerDynamics: (Context) => String = parse_attribute (attribute ("""RemoteInputSignal.PowerSystemStabilizerDynamics"""))
    val Terminal: (Context) => String = parse_attribute (attribute ("""RemoteInputSignal.Terminal"""))
    val UnderexcitationLimiterDynamics: (Context) => String = parse_attribute (attribute ("""RemoteInputSignal.UnderexcitationLimiterDynamics"""))
    val VoltageCompensatorDynamics: (Context) => String = parse_attribute (attribute ("""RemoteInputSignal.VoltageCompensatorDynamics"""))
    val WindPlantDynamics: (Context) => String = parse_attribute (attribute ("""RemoteInputSignal.WindPlantDynamics"""))
    val WindTurbineType1or2Dynamics: (Context) => String = parse_attribute (attribute ("""RemoteInputSignal.WindTurbineType1or2Dynamics"""))
    val WindTurbineType3or4Dynamics: (Context) => String = parse_attribute (attribute ("""RemoteInputSignal.WindTurbineType3or4Dynamics"""))
    def parse (context: Context): RemoteInputSignal =
    {
        RemoteInputSignal(
            IdentifiedObject.parse (context),
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
(
    override val sup: BasicElement,
    remoteBranchCurrentAmplitude: String,
    remoteBusFrequency: String,
    remoteBusFrequencyDeviation: String,
    remoteBusVoltage: String,
    remoteBusVoltageAmplitude: String,
    remoteBusVoltageAmplitudeDerivative: String,
    remoteBusVoltageFrequency: String,
    remoteBusVoltageFrequencyDeviation: String,
    remotePuBusVoltageDerivative: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[RemoteSignalKind] }
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
        (if (null != remoteBranchCurrentAmplitude) "\t\t<cim:RemoteSignalKind.remoteBranchCurrentAmplitude rdf:resource=\"#" + remoteBranchCurrentAmplitude + "\"/>\n" else "") +
        (if (null != remoteBusFrequency) "\t\t<cim:RemoteSignalKind.remoteBusFrequency rdf:resource=\"#" + remoteBusFrequency + "\"/>\n" else "") +
        (if (null != remoteBusFrequencyDeviation) "\t\t<cim:RemoteSignalKind.remoteBusFrequencyDeviation rdf:resource=\"#" + remoteBusFrequencyDeviation + "\"/>\n" else "") +
        (if (null != remoteBusVoltage) "\t\t<cim:RemoteSignalKind.remoteBusVoltage rdf:resource=\"#" + remoteBusVoltage + "\"/>\n" else "") +
        (if (null != remoteBusVoltageAmplitude) "\t\t<cim:RemoteSignalKind.remoteBusVoltageAmplitude rdf:resource=\"#" + remoteBusVoltageAmplitude + "\"/>\n" else "") +
        (if (null != remoteBusVoltageAmplitudeDerivative) "\t\t<cim:RemoteSignalKind.remoteBusVoltageAmplitudeDerivative rdf:resource=\"#" + remoteBusVoltageAmplitudeDerivative + "\"/>\n" else "") +
        (if (null != remoteBusVoltageFrequency) "\t\t<cim:RemoteSignalKind.remoteBusVoltageFrequency rdf:resource=\"#" + remoteBusVoltageFrequency + "\"/>\n" else "") +
        (if (null != remoteBusVoltageFrequencyDeviation) "\t\t<cim:RemoteSignalKind.remoteBusVoltageFrequencyDeviation rdf:resource=\"#" + remoteBusVoltageFrequencyDeviation + "\"/>\n" else "") +
        (if (null != remotePuBusVoltageDerivative) "\t\t<cim:RemoteSignalKind.remotePuBusVoltageDerivative rdf:resource=\"#" + remotePuBusVoltageDerivative + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:RemoteSignalKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RemoteSignalKind>\n"
    }
}

object RemoteSignalKind
extends
    Parseable[RemoteSignalKind]
{
    val remoteBranchCurrentAmplitude: (Context) => String = parse_attribute (attribute ("""RemoteSignalKind.remoteBranchCurrentAmplitude"""))
    val remoteBusFrequency: (Context) => String = parse_attribute (attribute ("""RemoteSignalKind.remoteBusFrequency"""))
    val remoteBusFrequencyDeviation: (Context) => String = parse_attribute (attribute ("""RemoteSignalKind.remoteBusFrequencyDeviation"""))
    val remoteBusVoltage: (Context) => String = parse_attribute (attribute ("""RemoteSignalKind.remoteBusVoltage"""))
    val remoteBusVoltageAmplitude: (Context) => String = parse_attribute (attribute ("""RemoteSignalKind.remoteBusVoltageAmplitude"""))
    val remoteBusVoltageAmplitudeDerivative: (Context) => String = parse_attribute (attribute ("""RemoteSignalKind.remoteBusVoltageAmplitudeDerivative"""))
    val remoteBusVoltageFrequency: (Context) => String = parse_attribute (attribute ("""RemoteSignalKind.remoteBusVoltageFrequency"""))
    val remoteBusVoltageFrequencyDeviation: (Context) => String = parse_attribute (attribute ("""RemoteSignalKind.remoteBusVoltageFrequencyDeviation"""))
    val remotePuBusVoltageDerivative: (Context) => String = parse_attribute (attribute ("""RemoteSignalKind.remotePuBusVoltageDerivative"""))
    def parse (context: Context): RemoteSignalKind =
    {
        RemoteSignalKind(
            BasicElement.parse (context),
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

private[ninecode] object _StandardInterconnections
{
    def register: List[ClassInfo] =
    {
        List (
            RemoteInputSignal.register,
            RemoteSignalKind.register
        )
    }
}