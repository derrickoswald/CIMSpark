package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Supports connection to a terminal associated with a remote bus from which an input signal of a specific type is coming.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param remoteSignalType Type of input signal.
 * @param DiscontinuousExcitationControlDynamics [[ch.ninecode.model.DiscontinuousExcitationControlDynamics DiscontinuousExcitationControlDynamics]] Discontinuous excitation control model using this remote input signal.
 * @param PFVArControllerType1Dynamics [[ch.ninecode.model.PFVArControllerType1Dynamics PFVArControllerType1Dynamics]] Power factor or VAr controller type 1 model using this remote input signal.
 * @param PowerSystemStabilizerDynamics [[ch.ninecode.model.PowerSystemStabilizerDynamics PowerSystemStabilizerDynamics]] Power system stabilizer model using this remote input signal.
 * @param Terminal [[ch.ninecode.model.Terminal Terminal]] Remote terminal with which this input signal is associated.
 * @param UnderexcitationLimiterDynamics [[ch.ninecode.model.UnderexcitationLimiterDynamics UnderexcitationLimiterDynamics]] Underexcitation limiter model using this remote input signal.
 * @param VoltageCompensatorDynamics [[ch.ninecode.model.VoltageCompensatorDynamics VoltageCompensatorDynamics]] Voltage compensator model using this remote input signal.
 * @param WindPlantDynamics [[ch.ninecode.model.WindPlantDynamics WindPlantDynamics]] The wind plant using the remote signal.
 * @param WindTurbineType1or2Dynamics [[ch.ninecode.model.WindTurbineType1or2Dynamics WindTurbineType1or2Dynamics]] Wind generator type 1 or type 2 model using this remote input signal.
 * @param WindTurbineType3or4Dynamics [[ch.ninecode.model.WindTurbineType3or4Dynamics WindTurbineType3or4Dynamics]] Wind turbine type 3 or type 4 models using this remote input signal.
 * @group StandardInterconnections
 * @groupname StandardInterconnections Package StandardInterconnections
 * @groupdesc StandardInterconnections This subclause describes the standard interconnections for various types of equipment. These interconnections are understood by the application programs and can be identified based on the presence of one of the key classes with a relationship to the static power flow model: SynchronousMachineDynamics, AsynchronousMachineDynamics, EnergyConsumerDynamics or WindTurbineType3or4Dynamics. 
The relationships between classes expressed in the interconnection diagrams are intended to support dynamic behaviour described by either standard models or user-defined models.
In the interconnection diagrams, boxes which are black in colour represent function blocks whose functionality can be provided by one of many standard models or by a user-defined model. Blue boxes represent specific standard models.  A dashed box means that the function block or specific standard model is optional.
 */
final case class RemoteInputSignal
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
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[RemoteInputSignal] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = RemoteInputSignal.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RemoteInputSignal.fields (position), value)
        emitattr (0, remoteSignalType)
        emitattr (1, DiscontinuousExcitationControlDynamics)
        emitattr (2, PFVArControllerType1Dynamics)
        emitattr (3, PowerSystemStabilizerDynamics)
        emitattr (4, Terminal)
        emitattr (5, UnderexcitationLimiterDynamics)
        emitattr (6, VoltageCompensatorDynamics)
        emitattr (7, WindPlantDynamics)
        emitattr (8, WindTurbineType1or2Dynamics)
        emitattr (9, WindTurbineType3or4Dynamics)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RemoteInputSignal rdf:ID=\"%s\">\n%s\t</cim:RemoteInputSignal>".format (id, export_fields)
    }
}

object RemoteInputSignal
extends
    Parseable[RemoteInputSignal]
{
    override val fields: Array[String] = Array[String] (
        "remoteSignalType",
        "DiscontinuousExcitationControlDynamics",
        "PFVArControllerType1Dynamics",
        "PowerSystemStabilizerDynamics",
        "Terminal",
        "UnderexcitationLimiterDynamics",
        "VoltageCompensatorDynamics",
        "WindPlantDynamics",
        "WindTurbineType1or2Dynamics",
        "WindTurbineType3or4Dynamics"
    )
    override val relations: List[Relationship] = List (
        Relationship ("DiscontinuousExcitationControlDynamics", "DiscontinuousExcitationControlDynamics", "0..1", "0..1"),
        Relationship ("PFVArControllerType1Dynamics", "PFVArControllerType1Dynamics", "0..1", "0..1"),
        Relationship ("PowerSystemStabilizerDynamics", "PowerSystemStabilizerDynamics", "0..1", "0..*"),
        Relationship ("Terminal", "Terminal", "1", "0..*"),
        Relationship ("UnderexcitationLimiterDynamics", "UnderexcitationLimiterDynamics", "0..1", "0..1"),
        Relationship ("VoltageCompensatorDynamics", "VoltageCompensatorDynamics", "0..1", "0..1"),
        Relationship ("WindPlantDynamics", "WindPlantDynamics", "0..1", "0..1"),
        Relationship ("WindTurbineType1or2Dynamics", "WindTurbineType1or2Dynamics", "0..1", "0..1"),
        Relationship ("WindTurbineType3or4Dynamics", "WindTurbineType3or4Dynamics", "0..1", "0..1")
    )
    val remoteSignalType: Fielder = parse_attribute (attribute (cls, fields(0)))
    val DiscontinuousExcitationControlDynamics: Fielder = parse_attribute (attribute (cls, fields(1)))
    val PFVArControllerType1Dynamics: Fielder = parse_attribute (attribute (cls, fields(2)))
    val PowerSystemStabilizerDynamics: Fielder = parse_attribute (attribute (cls, fields(3)))
    val Terminal: Fielder = parse_attribute (attribute (cls, fields(4)))
    val UnderexcitationLimiterDynamics: Fielder = parse_attribute (attribute (cls, fields(5)))
    val VoltageCompensatorDynamics: Fielder = parse_attribute (attribute (cls, fields(6)))
    val WindPlantDynamics: Fielder = parse_attribute (attribute (cls, fields(7)))
    val WindTurbineType1or2Dynamics: Fielder = parse_attribute (attribute (cls, fields(8)))
    val WindTurbineType3or4Dynamics: Fielder = parse_attribute (attribute (cls, fields(9)))

    def parse (context: Context): RemoteInputSignal =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = RemoteInputSignal (
            IdentifiedObject.parse (context),
            mask (remoteSignalType (), 0),
            mask (DiscontinuousExcitationControlDynamics (), 1),
            mask (PFVArControllerType1Dynamics (), 2),
            mask (PowerSystemStabilizerDynamics (), 3),
            mask (Terminal (), 4),
            mask (UnderexcitationLimiterDynamics (), 5),
            mask (VoltageCompensatorDynamics (), 6),
            mask (WindPlantDynamics (), 7),
            mask (WindTurbineType1or2Dynamics (), 8),
            mask (WindTurbineType3or4Dynamics (), 9)
        )
        ret.bitfields = bitfields
        ret
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