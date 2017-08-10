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

private[ninecode] object _StandardInterconnections
{
    def register: List[ClassInfo] =
    {
        List (
            RemoteInputSignal.register
        )
    }
}