package ch.ninecode.model

import com.esotericsoftware.kryo.Kryo
import com.esotericsoftware.kryo.Serializer
import com.esotericsoftware.kryo.io.Input
import com.esotericsoftware.kryo.io.Output
import org.apache.spark.sql.Row

import ch.ninecode.cim.CIMClassInfo
import ch.ninecode.cim.CIMContext
import ch.ninecode.cim.CIMParseable
import ch.ninecode.cim.CIMRelationship
import ch.ninecode.cim.CIMSerializer

/**
 * Supports connection to a terminal associated with a remote bus from which an input signal of a specific type is coming.
 *
 * @param IdentifiedObject                       [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param remoteSignalType                       Type of input signal.
 * @param DiscontinuousExcitationControlDynamics [[ch.ninecode.model.DiscontinuousExcitationControlDynamics DiscontinuousExcitationControlDynamics]] Discontinuous excitation control model using this remote input signal.
 * @param PFVArControllerType1Dynamics           [[ch.ninecode.model.PFVArControllerType1Dynamics PFVArControllerType1Dynamics]] Power factor or VAr controller type 1 model using this remote input signal.
 * @param PowerSystemStabilizerDynamics          [[ch.ninecode.model.PowerSystemStabilizerDynamics PowerSystemStabilizerDynamics]] Power system stabilizer model using this remote input signal.
 * @param Terminal                               [[ch.ninecode.model.Terminal Terminal]] Remote terminal with which this input signal is associated.
 * @param UnderexcitationLimiterDynamics         [[ch.ninecode.model.UnderexcitationLimiterDynamics UnderexcitationLimiterDynamics]] Underexcitation limiter model using this remote input signal.
 * @param VoltageCompensatorDynamics             [[ch.ninecode.model.VoltageCompensatorDynamics VoltageCompensatorDynamics]] Voltage compensator model using this remote input signal.
 * @param WindPlantDynamics                      [[ch.ninecode.model.WindPlantDynamics WindPlantDynamics]] The wind plant using the remote signal.
 * @param WindTurbineType1or2Dynamics            [[ch.ninecode.model.WindTurbineType1or2Dynamics WindTurbineType1or2Dynamics]] Wind generator type 1 or type 2 model using this remote input signal.
 * @param WindTurbineType3or4Dynamics            [[ch.ninecode.model.WindTurbineType3or4Dynamics WindTurbineType3or4Dynamics]] Wind turbine type 3 or type 4 models using this remote input signal.
 * @group StandardInterconnections
 * @groupname StandardInterconnections Package StandardInterconnections
 * @groupdesc StandardInterconnections This subclause describes the standard interconnections for various types of equipment. These interconnections are understood by the application programs and can be identified based on the presence of one of the key classes with a relationship to the static power flow model: SynchronousMachineDynamics, AsynchronousMachineDynamics, EnergyConsumerDynamics or WindTurbineType3or4Dynamics. 
 *            The relationships between classes expressed in the interconnection diagrams are intended to support dynamic behaviour described by either standard models or user-defined models.
 *            In the interconnection diagrams, boxes which are black in colour represent function blocks whose functionality can be provided by one of many standard models or by a user-defined model. Blue boxes represent specific standard models.  A dashed box means that the function block or specific standard model is optional.
 */
final case class RemoteInputSignal
(
    IdentifiedObject: IdentifiedObject = null,
    remoteSignalType: String = null,
    DiscontinuousExcitationControlDynamics: String = null,
    PFVArControllerType1Dynamics: String = null,
    PowerSystemStabilizerDynamics: String = null,
    Terminal: String = null,
    UnderexcitationLimiterDynamics: String = null,
    VoltageCompensatorDynamics: String = null,
    WindPlantDynamics: String = null,
    WindTurbineType1or2Dynamics: String = null,
    WindTurbineType3or4Dynamics: String = null
)
    extends
        Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: IdentifiedObject = IdentifiedObject

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row =
    {
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = RemoteInputSignal.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(RemoteInputSignal.fields(position), value)

        emitattr(0, remoteSignalType)
        emitattr(1, DiscontinuousExcitationControlDynamics)
        emitattr(2, PFVArControllerType1Dynamics)
        emitattr(3, PowerSystemStabilizerDynamics)
        emitattr(4, Terminal)
        emitattr(5, UnderexcitationLimiterDynamics)
        emitattr(6, VoltageCompensatorDynamics)
        emitattr(7, WindPlantDynamics)
        emitattr(8, WindTurbineType1or2Dynamics)
        emitattr(9, WindTurbineType3or4Dynamics)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:RemoteInputSignal rdf:%s=\"%s\">\n%s\t</cim:RemoteInputSignal>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object RemoteInputSignal
    extends
        CIMParseable[RemoteInputSignal]
{
    override val fields: Array[String] = Array[String](
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
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("DiscontinuousExcitationControlDynamics", "DiscontinuousExcitationControlDynamics", "0..1", "0..1"),
        CIMRelationship("PFVArControllerType1Dynamics", "PFVArControllerType1Dynamics", "0..1", "0..1"),
        CIMRelationship("PowerSystemStabilizerDynamics", "PowerSystemStabilizerDynamics", "0..1", "0..*"),
        CIMRelationship("Terminal", "Terminal", "1", "0..*"),
        CIMRelationship("UnderexcitationLimiterDynamics", "UnderexcitationLimiterDynamics", "0..1", "0..1"),
        CIMRelationship("VoltageCompensatorDynamics", "VoltageCompensatorDynamics", "0..1", "0..1"),
        CIMRelationship("WindPlantDynamics", "WindPlantDynamics", "0..1", "0..1"),
        CIMRelationship("WindTurbineType1or2Dynamics", "WindTurbineType1or2Dynamics", "0..1", "0..1"),
        CIMRelationship("WindTurbineType3or4Dynamics", "WindTurbineType3or4Dynamics", "0..1", "0..1")
    )
    val remoteSignalType: Fielder = parse_attribute(attribute(cls, fields(0)))
    val DiscontinuousExcitationControlDynamics: Fielder = parse_attribute(attribute(cls, fields(1)))
    val PFVArControllerType1Dynamics: Fielder = parse_attribute(attribute(cls, fields(2)))
    val PowerSystemStabilizerDynamics: Fielder = parse_attribute(attribute(cls, fields(3)))
    val Terminal: Fielder = parse_attribute(attribute(cls, fields(4)))
    val UnderexcitationLimiterDynamics: Fielder = parse_attribute(attribute(cls, fields(5)))
    val VoltageCompensatorDynamics: Fielder = parse_attribute(attribute(cls, fields(6)))
    val WindPlantDynamics: Fielder = parse_attribute(attribute(cls, fields(7)))
    val WindTurbineType1or2Dynamics: Fielder = parse_attribute(attribute(cls, fields(8)))
    val WindTurbineType3or4Dynamics: Fielder = parse_attribute(attribute(cls, fields(9)))

    def parse (context: CIMContext): RemoteInputSignal =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = RemoteInputSignal(
            IdentifiedObject.parse(context),
            mask(remoteSignalType(), 0),
            mask(DiscontinuousExcitationControlDynamics(), 1),
            mask(PFVArControllerType1Dynamics(), 2),
            mask(PowerSystemStabilizerDynamics(), 3),
            mask(Terminal(), 4),
            mask(UnderexcitationLimiterDynamics(), 5),
            mask(VoltageCompensatorDynamics(), 6),
            mask(WindPlantDynamics(), 7),
            mask(WindTurbineType1or2Dynamics(), 8),
            mask(WindTurbineType3or4Dynamics(), 9)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[RemoteInputSignal] = RemoteInputSignalSerializer
}

object RemoteInputSignalSerializer extends CIMSerializer[RemoteInputSignal]
{
    def write (kryo: Kryo, output: Output, obj: RemoteInputSignal): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.remoteSignalType),
            () => output.writeString(obj.DiscontinuousExcitationControlDynamics),
            () => output.writeString(obj.PFVArControllerType1Dynamics),
            () => output.writeString(obj.PowerSystemStabilizerDynamics),
            () => output.writeString(obj.Terminal),
            () => output.writeString(obj.UnderexcitationLimiterDynamics),
            () => output.writeString(obj.VoltageCompensatorDynamics),
            () => output.writeString(obj.WindPlantDynamics),
            () => output.writeString(obj.WindTurbineType1or2Dynamics),
            () => output.writeString(obj.WindTurbineType3or4Dynamics)
        )
        IdentifiedObjectSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[RemoteInputSignal]): RemoteInputSignal =
    {
        val parent = IdentifiedObjectSerializer.read(kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = RemoteInputSignal(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readString else null,
            if (isSet(2)) input.readString else null,
            if (isSet(3)) input.readString else null,
            if (isSet(4)) input.readString else null,
            if (isSet(5)) input.readString else null,
            if (isSet(6)) input.readString else null,
            if (isSet(7)) input.readString else null,
            if (isSet(8)) input.readString else null,
            if (isSet(9)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _StandardInterconnections
{
    def register: List[CIMClassInfo] =
    {
        List(
            RemoteInputSignal.register
        )
    }
}