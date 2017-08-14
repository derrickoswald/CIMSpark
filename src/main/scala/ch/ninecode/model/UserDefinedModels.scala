package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * Asynchronous machine whose dynamic behaviour is described by a user-defined model.
 *
 * @param sup Reference to the superclass object.
 * @param proprietary Behaviour is based on proprietary model as opposed to detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @group UserDefinedModels
 * @groupname UserDefinedModels Package UserDefinedModels
 * @groupdesc UserDefinedModels This section contains user-defined dynamic model classes to support the exchange of both proprietary and explicitly defined user-defined models.  
<u>
</u><u>Proprietary models</u> represent behaviour which, while not defined by a standard model class, is mutually understood by the sending and receiving applications based on the name passed in the .name attribute of the appropriate xxxUserDefined class.  Proprietary model parameters are passed as general attributes using as many instances of the ProprietaryParameterDynamics class as there are parameters.
<u>
</u><u>Explicitly defined models</u> describe dynamic behaviour in detail in terms of control blocks and their input and output signals.  NOTE: The classes to support explicitly defined modelling are not currently defined - it is future work intended to also be supported by the family of xxxUserDefined classes.

Both types of user-defined models use the family of xxxUserDefined classes, which allow a user-defined model to be utilized:
<ul>
	<li>as the model for an individual standard function block (like turbine-governor or power system stabilizer) in a standard interconnection model whose other function blocks could be either standard or user-defined.  For an illustration of this form of usage for a proprietary model, see the ExampleFunctionBlockProprietaryModel diagram in the Examples section.</li>
</ul>
<ul>
	<li>as the complete representation of a dynamic behaviour model (for an entire synchronous machine, for example) where standard function blocks and standard interconnections are not used at all. For an illustration of this form of usage for a proprietary model, see the ExampleCompleteProprietaryModel diagram in the Examples section.</li>
</ul>
 */
case class AsynchronousMachineUserDefined
(
    override val sup: AsynchronousMachineDynamics,
    proprietary: Boolean
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def AsynchronousMachineDynamics: AsynchronousMachineDynamics = sup.asInstanceOf[AsynchronousMachineDynamics]
    override def copy (): Row = { clone ().asInstanceOf[AsynchronousMachineUserDefined] }
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
        "\t\t<cim:AsynchronousMachineUserDefined.proprietary>" + proprietary + "</cim:AsynchronousMachineUserDefined.proprietary>\n"
    }
    override def export: String =
    {
        "\t<cim:AsynchronousMachineUserDefined rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AsynchronousMachineUserDefined>"
    }
}

object AsynchronousMachineUserDefined
extends
    Parseable[AsynchronousMachineUserDefined]
{
    val proprietary = parse_element (element ("""AsynchronousMachineUserDefined.proprietary"""))
    def parse (context: Context): AsynchronousMachineUserDefined =
    {
        AsynchronousMachineUserDefined(
            AsynchronousMachineDynamics.parse (context),
            toBoolean (proprietary (context), context)
        )
    }
}

/**
 * Discontinuous excitation control function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 *
 * @param sup Reference to the superclass object.
 * @param proprietary Behaviour is based on proprietary model as opposed to detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @group UserDefinedModels
 * @groupname UserDefinedModels Package UserDefinedModels
 * @groupdesc UserDefinedModels This section contains user-defined dynamic model classes to support the exchange of both proprietary and explicitly defined user-defined models.  
<u>
</u><u>Proprietary models</u> represent behaviour which, while not defined by a standard model class, is mutually understood by the sending and receiving applications based on the name passed in the .name attribute of the appropriate xxxUserDefined class.  Proprietary model parameters are passed as general attributes using as many instances of the ProprietaryParameterDynamics class as there are parameters.
<u>
</u><u>Explicitly defined models</u> describe dynamic behaviour in detail in terms of control blocks and their input and output signals.  NOTE: The classes to support explicitly defined modelling are not currently defined - it is future work intended to also be supported by the family of xxxUserDefined classes.

Both types of user-defined models use the family of xxxUserDefined classes, which allow a user-defined model to be utilized:
<ul>
	<li>as the model for an individual standard function block (like turbine-governor or power system stabilizer) in a standard interconnection model whose other function blocks could be either standard or user-defined.  For an illustration of this form of usage for a proprietary model, see the ExampleFunctionBlockProprietaryModel diagram in the Examples section.</li>
</ul>
<ul>
	<li>as the complete representation of a dynamic behaviour model (for an entire synchronous machine, for example) where standard function blocks and standard interconnections are not used at all. For an illustration of this form of usage for a proprietary model, see the ExampleCompleteProprietaryModel diagram in the Examples section.</li>
</ul>
 */
case class DiscontinuousExcitationControlUserDefined
(
    override val sup: DiscontinuousExcitationControlDynamics,
    proprietary: Boolean
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def DiscontinuousExcitationControlDynamics: DiscontinuousExcitationControlDynamics = sup.asInstanceOf[DiscontinuousExcitationControlDynamics]
    override def copy (): Row = { clone ().asInstanceOf[DiscontinuousExcitationControlUserDefined] }
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
        "\t\t<cim:DiscontinuousExcitationControlUserDefined.proprietary>" + proprietary + "</cim:DiscontinuousExcitationControlUserDefined.proprietary>\n"
    }
    override def export: String =
    {
        "\t<cim:DiscontinuousExcitationControlUserDefined rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DiscontinuousExcitationControlUserDefined>"
    }
}

object DiscontinuousExcitationControlUserDefined
extends
    Parseable[DiscontinuousExcitationControlUserDefined]
{
    val proprietary = parse_element (element ("""DiscontinuousExcitationControlUserDefined.proprietary"""))
    def parse (context: Context): DiscontinuousExcitationControlUserDefined =
    {
        DiscontinuousExcitationControlUserDefined(
            DiscontinuousExcitationControlDynamics.parse (context),
            toBoolean (proprietary (context), context)
        )
    }
}

/**
 * Excitation system function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 *
 * @param sup Reference to the superclass object.
 * @param proprietary Behaviour is based on proprietary model as opposed to detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @group UserDefinedModels
 * @groupname UserDefinedModels Package UserDefinedModels
 * @groupdesc UserDefinedModels This section contains user-defined dynamic model classes to support the exchange of both proprietary and explicitly defined user-defined models.  
<u>
</u><u>Proprietary models</u> represent behaviour which, while not defined by a standard model class, is mutually understood by the sending and receiving applications based on the name passed in the .name attribute of the appropriate xxxUserDefined class.  Proprietary model parameters are passed as general attributes using as many instances of the ProprietaryParameterDynamics class as there are parameters.
<u>
</u><u>Explicitly defined models</u> describe dynamic behaviour in detail in terms of control blocks and their input and output signals.  NOTE: The classes to support explicitly defined modelling are not currently defined - it is future work intended to also be supported by the family of xxxUserDefined classes.

Both types of user-defined models use the family of xxxUserDefined classes, which allow a user-defined model to be utilized:
<ul>
	<li>as the model for an individual standard function block (like turbine-governor or power system stabilizer) in a standard interconnection model whose other function blocks could be either standard or user-defined.  For an illustration of this form of usage for a proprietary model, see the ExampleFunctionBlockProprietaryModel diagram in the Examples section.</li>
</ul>
<ul>
	<li>as the complete representation of a dynamic behaviour model (for an entire synchronous machine, for example) where standard function blocks and standard interconnections are not used at all. For an illustration of this form of usage for a proprietary model, see the ExampleCompleteProprietaryModel diagram in the Examples section.</li>
</ul>
 */
case class ExcitationSystemUserDefined
(
    override val sup: ExcitationSystemDynamics,
    proprietary: Boolean
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcitationSystemUserDefined] }
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
        "\t\t<cim:ExcitationSystemUserDefined.proprietary>" + proprietary + "</cim:ExcitationSystemUserDefined.proprietary>\n"
    }
    override def export: String =
    {
        "\t<cim:ExcitationSystemUserDefined rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ExcitationSystemUserDefined>"
    }
}

object ExcitationSystemUserDefined
extends
    Parseable[ExcitationSystemUserDefined]
{
    val proprietary = parse_element (element ("""ExcitationSystemUserDefined.proprietary"""))
    def parse (context: Context): ExcitationSystemUserDefined =
    {
        ExcitationSystemUserDefined(
            ExcitationSystemDynamics.parse (context),
            toBoolean (proprietary (context), context)
        )
    }
}

/**
 * Load whose dynamic behaviour is described by a user-defined model.
 *
 * @param sup Reference to the superclass object.
 * @param proprietary Behaviour is based on proprietary model as opposed to detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @group UserDefinedModels
 * @groupname UserDefinedModels Package UserDefinedModels
 * @groupdesc UserDefinedModels This section contains user-defined dynamic model classes to support the exchange of both proprietary and explicitly defined user-defined models.  
<u>
</u><u>Proprietary models</u> represent behaviour which, while not defined by a standard model class, is mutually understood by the sending and receiving applications based on the name passed in the .name attribute of the appropriate xxxUserDefined class.  Proprietary model parameters are passed as general attributes using as many instances of the ProprietaryParameterDynamics class as there are parameters.
<u>
</u><u>Explicitly defined models</u> describe dynamic behaviour in detail in terms of control blocks and their input and output signals.  NOTE: The classes to support explicitly defined modelling are not currently defined - it is future work intended to also be supported by the family of xxxUserDefined classes.

Both types of user-defined models use the family of xxxUserDefined classes, which allow a user-defined model to be utilized:
<ul>
	<li>as the model for an individual standard function block (like turbine-governor or power system stabilizer) in a standard interconnection model whose other function blocks could be either standard or user-defined.  For an illustration of this form of usage for a proprietary model, see the ExampleFunctionBlockProprietaryModel diagram in the Examples section.</li>
</ul>
<ul>
	<li>as the complete representation of a dynamic behaviour model (for an entire synchronous machine, for example) where standard function blocks and standard interconnections are not used at all. For an illustration of this form of usage for a proprietary model, see the ExampleCompleteProprietaryModel diagram in the Examples section.</li>
</ul>
 */
case class LoadUserDefined
(
    override val sup: LoadDynamics,
    proprietary: Boolean
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def LoadDynamics: LoadDynamics = sup.asInstanceOf[LoadDynamics]
    override def copy (): Row = { clone ().asInstanceOf[LoadUserDefined] }
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
        "\t\t<cim:LoadUserDefined.proprietary>" + proprietary + "</cim:LoadUserDefined.proprietary>\n"
    }
    override def export: String =
    {
        "\t<cim:LoadUserDefined rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:LoadUserDefined>"
    }
}

object LoadUserDefined
extends
    Parseable[LoadUserDefined]
{
    val proprietary = parse_element (element ("""LoadUserDefined.proprietary"""))
    def parse (context: Context): LoadUserDefined =
    {
        LoadUserDefined(
            LoadDynamics.parse (context),
            toBoolean (proprietary (context), context)
        )
    }
}

/**
 * Mechanical load function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 *
 * @param sup Reference to the superclass object.
 * @param proprietary Behaviour is based on proprietary model as opposed to detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @group UserDefinedModels
 * @groupname UserDefinedModels Package UserDefinedModels
 * @groupdesc UserDefinedModels This section contains user-defined dynamic model classes to support the exchange of both proprietary and explicitly defined user-defined models.  
<u>
</u><u>Proprietary models</u> represent behaviour which, while not defined by a standard model class, is mutually understood by the sending and receiving applications based on the name passed in the .name attribute of the appropriate xxxUserDefined class.  Proprietary model parameters are passed as general attributes using as many instances of the ProprietaryParameterDynamics class as there are parameters.
<u>
</u><u>Explicitly defined models</u> describe dynamic behaviour in detail in terms of control blocks and their input and output signals.  NOTE: The classes to support explicitly defined modelling are not currently defined - it is future work intended to also be supported by the family of xxxUserDefined classes.

Both types of user-defined models use the family of xxxUserDefined classes, which allow a user-defined model to be utilized:
<ul>
	<li>as the model for an individual standard function block (like turbine-governor or power system stabilizer) in a standard interconnection model whose other function blocks could be either standard or user-defined.  For an illustration of this form of usage for a proprietary model, see the ExampleFunctionBlockProprietaryModel diagram in the Examples section.</li>
</ul>
<ul>
	<li>as the complete representation of a dynamic behaviour model (for an entire synchronous machine, for example) where standard function blocks and standard interconnections are not used at all. For an illustration of this form of usage for a proprietary model, see the ExampleCompleteProprietaryModel diagram in the Examples section.</li>
</ul>
 */
case class MechanicalLoadUserDefined
(
    override val sup: MechanicalLoadDynamics,
    proprietary: Boolean
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def MechanicalLoadDynamics: MechanicalLoadDynamics = sup.asInstanceOf[MechanicalLoadDynamics]
    override def copy (): Row = { clone ().asInstanceOf[MechanicalLoadUserDefined] }
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
        "\t\t<cim:MechanicalLoadUserDefined.proprietary>" + proprietary + "</cim:MechanicalLoadUserDefined.proprietary>\n"
    }
    override def export: String =
    {
        "\t<cim:MechanicalLoadUserDefined rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MechanicalLoadUserDefined>"
    }
}

object MechanicalLoadUserDefined
extends
    Parseable[MechanicalLoadUserDefined]
{
    val proprietary = parse_element (element ("""MechanicalLoadUserDefined.proprietary"""))
    def parse (context: Context): MechanicalLoadUserDefined =
    {
        MechanicalLoadUserDefined(
            MechanicalLoadDynamics.parse (context),
            toBoolean (proprietary (context), context)
        )
    }
}

/**
 * Overexcitation limiter system function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 *
 * @param sup Reference to the superclass object.
 * @param proprietary Behaviour is based on proprietary model as opposed to detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @group UserDefinedModels
 * @groupname UserDefinedModels Package UserDefinedModels
 * @groupdesc UserDefinedModels This section contains user-defined dynamic model classes to support the exchange of both proprietary and explicitly defined user-defined models.  
<u>
</u><u>Proprietary models</u> represent behaviour which, while not defined by a standard model class, is mutually understood by the sending and receiving applications based on the name passed in the .name attribute of the appropriate xxxUserDefined class.  Proprietary model parameters are passed as general attributes using as many instances of the ProprietaryParameterDynamics class as there are parameters.
<u>
</u><u>Explicitly defined models</u> describe dynamic behaviour in detail in terms of control blocks and their input and output signals.  NOTE: The classes to support explicitly defined modelling are not currently defined - it is future work intended to also be supported by the family of xxxUserDefined classes.

Both types of user-defined models use the family of xxxUserDefined classes, which allow a user-defined model to be utilized:
<ul>
	<li>as the model for an individual standard function block (like turbine-governor or power system stabilizer) in a standard interconnection model whose other function blocks could be either standard or user-defined.  For an illustration of this form of usage for a proprietary model, see the ExampleFunctionBlockProprietaryModel diagram in the Examples section.</li>
</ul>
<ul>
	<li>as the complete representation of a dynamic behaviour model (for an entire synchronous machine, for example) where standard function blocks and standard interconnections are not used at all. For an illustration of this form of usage for a proprietary model, see the ExampleCompleteProprietaryModel diagram in the Examples section.</li>
</ul>
 */
case class OverexcitationLimiterUserDefined
(
    override val sup: OverexcitationLimiterDynamics,
    proprietary: Boolean
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def OverexcitationLimiterDynamics: OverexcitationLimiterDynamics = sup.asInstanceOf[OverexcitationLimiterDynamics]
    override def copy (): Row = { clone ().asInstanceOf[OverexcitationLimiterUserDefined] }
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
        "\t\t<cim:OverexcitationLimiterUserDefined.proprietary>" + proprietary + "</cim:OverexcitationLimiterUserDefined.proprietary>\n"
    }
    override def export: String =
    {
        "\t<cim:OverexcitationLimiterUserDefined rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:OverexcitationLimiterUserDefined>"
    }
}

object OverexcitationLimiterUserDefined
extends
    Parseable[OverexcitationLimiterUserDefined]
{
    val proprietary = parse_element (element ("""OverexcitationLimiterUserDefined.proprietary"""))
    def parse (context: Context): OverexcitationLimiterUserDefined =
    {
        OverexcitationLimiterUserDefined(
            OverexcitationLimiterDynamics.parse (context),
            toBoolean (proprietary (context), context)
        )
    }
}

/**
 * Power Factor or VAr controller Type I function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 *
 * @param sup Reference to the superclass object.
 * @param proprietary Behaviour is based on proprietary model as opposed to detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @group UserDefinedModels
 * @groupname UserDefinedModels Package UserDefinedModels
 * @groupdesc UserDefinedModels This section contains user-defined dynamic model classes to support the exchange of both proprietary and explicitly defined user-defined models.  
<u>
</u><u>Proprietary models</u> represent behaviour which, while not defined by a standard model class, is mutually understood by the sending and receiving applications based on the name passed in the .name attribute of the appropriate xxxUserDefined class.  Proprietary model parameters are passed as general attributes using as many instances of the ProprietaryParameterDynamics class as there are parameters.
<u>
</u><u>Explicitly defined models</u> describe dynamic behaviour in detail in terms of control blocks and their input and output signals.  NOTE: The classes to support explicitly defined modelling are not currently defined - it is future work intended to also be supported by the family of xxxUserDefined classes.

Both types of user-defined models use the family of xxxUserDefined classes, which allow a user-defined model to be utilized:
<ul>
	<li>as the model for an individual standard function block (like turbine-governor or power system stabilizer) in a standard interconnection model whose other function blocks could be either standard or user-defined.  For an illustration of this form of usage for a proprietary model, see the ExampleFunctionBlockProprietaryModel diagram in the Examples section.</li>
</ul>
<ul>
	<li>as the complete representation of a dynamic behaviour model (for an entire synchronous machine, for example) where standard function blocks and standard interconnections are not used at all. For an illustration of this form of usage for a proprietary model, see the ExampleCompleteProprietaryModel diagram in the Examples section.</li>
</ul>
 */
case class PFVArControllerType1UserDefined
(
    override val sup: PFVArControllerType1Dynamics,
    proprietary: Boolean
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PFVArControllerType1Dynamics: PFVArControllerType1Dynamics = sup.asInstanceOf[PFVArControllerType1Dynamics]
    override def copy (): Row = { clone ().asInstanceOf[PFVArControllerType1UserDefined] }
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
        "\t\t<cim:PFVArControllerType1UserDefined.proprietary>" + proprietary + "</cim:PFVArControllerType1UserDefined.proprietary>\n"
    }
    override def export: String =
    {
        "\t<cim:PFVArControllerType1UserDefined rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PFVArControllerType1UserDefined>"
    }
}

object PFVArControllerType1UserDefined
extends
    Parseable[PFVArControllerType1UserDefined]
{
    val proprietary = parse_element (element ("""PFVArControllerType1UserDefined.proprietary"""))
    def parse (context: Context): PFVArControllerType1UserDefined =
    {
        PFVArControllerType1UserDefined(
            PFVArControllerType1Dynamics.parse (context),
            toBoolean (proprietary (context), context)
        )
    }
}

/**
 * Power Factor or VAr controller Type II function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 *
 * @param sup Reference to the superclass object.
 * @param proprietary Behaviour is based on proprietary model as opposed to detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @group UserDefinedModels
 * @groupname UserDefinedModels Package UserDefinedModels
 * @groupdesc UserDefinedModels This section contains user-defined dynamic model classes to support the exchange of both proprietary and explicitly defined user-defined models.  
<u>
</u><u>Proprietary models</u> represent behaviour which, while not defined by a standard model class, is mutually understood by the sending and receiving applications based on the name passed in the .name attribute of the appropriate xxxUserDefined class.  Proprietary model parameters are passed as general attributes using as many instances of the ProprietaryParameterDynamics class as there are parameters.
<u>
</u><u>Explicitly defined models</u> describe dynamic behaviour in detail in terms of control blocks and their input and output signals.  NOTE: The classes to support explicitly defined modelling are not currently defined - it is future work intended to also be supported by the family of xxxUserDefined classes.

Both types of user-defined models use the family of xxxUserDefined classes, which allow a user-defined model to be utilized:
<ul>
	<li>as the model for an individual standard function block (like turbine-governor or power system stabilizer) in a standard interconnection model whose other function blocks could be either standard or user-defined.  For an illustration of this form of usage for a proprietary model, see the ExampleFunctionBlockProprietaryModel diagram in the Examples section.</li>
</ul>
<ul>
	<li>as the complete representation of a dynamic behaviour model (for an entire synchronous machine, for example) where standard function blocks and standard interconnections are not used at all. For an illustration of this form of usage for a proprietary model, see the ExampleCompleteProprietaryModel diagram in the Examples section.</li>
</ul>
 */
case class PFVArControllerType2UserDefined
(
    override val sup: PFVArControllerType2Dynamics,
    proprietary: Boolean
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PFVArControllerType2Dynamics: PFVArControllerType2Dynamics = sup.asInstanceOf[PFVArControllerType2Dynamics]
    override def copy (): Row = { clone ().asInstanceOf[PFVArControllerType2UserDefined] }
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
        "\t\t<cim:PFVArControllerType2UserDefined.proprietary>" + proprietary + "</cim:PFVArControllerType2UserDefined.proprietary>\n"
    }
    override def export: String =
    {
        "\t<cim:PFVArControllerType2UserDefined rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PFVArControllerType2UserDefined>"
    }
}

object PFVArControllerType2UserDefined
extends
    Parseable[PFVArControllerType2UserDefined]
{
    val proprietary = parse_element (element ("""PFVArControllerType2UserDefined.proprietary"""))
    def parse (context: Context): PFVArControllerType2UserDefined =
    {
        PFVArControllerType2UserDefined(
            PFVArControllerType2Dynamics.parse (context),
            toBoolean (proprietary (context), context)
        )
    }
}

/**
 * <font color="#0f0f0f">Power system stabilizer</font> function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 *
 * @param sup Reference to the superclass object.
 * @param proprietary Behaviour is based on proprietary model as opposed to detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @group UserDefinedModels
 * @groupname UserDefinedModels Package UserDefinedModels
 * @groupdesc UserDefinedModels This section contains user-defined dynamic model classes to support the exchange of both proprietary and explicitly defined user-defined models.  
<u>
</u><u>Proprietary models</u> represent behaviour which, while not defined by a standard model class, is mutually understood by the sending and receiving applications based on the name passed in the .name attribute of the appropriate xxxUserDefined class.  Proprietary model parameters are passed as general attributes using as many instances of the ProprietaryParameterDynamics class as there are parameters.
<u>
</u><u>Explicitly defined models</u> describe dynamic behaviour in detail in terms of control blocks and their input and output signals.  NOTE: The classes to support explicitly defined modelling are not currently defined - it is future work intended to also be supported by the family of xxxUserDefined classes.

Both types of user-defined models use the family of xxxUserDefined classes, which allow a user-defined model to be utilized:
<ul>
	<li>as the model for an individual standard function block (like turbine-governor or power system stabilizer) in a standard interconnection model whose other function blocks could be either standard or user-defined.  For an illustration of this form of usage for a proprietary model, see the ExampleFunctionBlockProprietaryModel diagram in the Examples section.</li>
</ul>
<ul>
	<li>as the complete representation of a dynamic behaviour model (for an entire synchronous machine, for example) where standard function blocks and standard interconnections are not used at all. For an illustration of this form of usage for a proprietary model, see the ExampleCompleteProprietaryModel diagram in the Examples section.</li>
</ul>
 */
case class PowerSystemStabilizerUserDefined
(
    override val sup: PowerSystemStabilizerDynamics,
    proprietary: Boolean
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf[PowerSystemStabilizerDynamics]
    override def copy (): Row = { clone ().asInstanceOf[PowerSystemStabilizerUserDefined] }
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
        "\t\t<cim:PowerSystemStabilizerUserDefined.proprietary>" + proprietary + "</cim:PowerSystemStabilizerUserDefined.proprietary>\n"
    }
    override def export: String =
    {
        "\t<cim:PowerSystemStabilizerUserDefined rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PowerSystemStabilizerUserDefined>"
    }
}

object PowerSystemStabilizerUserDefined
extends
    Parseable[PowerSystemStabilizerUserDefined]
{
    val proprietary = parse_element (element ("""PowerSystemStabilizerUserDefined.proprietary"""))
    def parse (context: Context): PowerSystemStabilizerUserDefined =
    {
        PowerSystemStabilizerUserDefined(
            PowerSystemStabilizerDynamics.parse (context),
            toBoolean (proprietary (context), context)
        )
    }
}

/**
 * Supports definition of one or more parameters of several different datatypes for use by proprietary user-defined models.
 * NOTE: This class does not inherit from IdentifiedObject since it is not intended that a single instance of it be referenced by more than one proprietary user-defined model instance.
 *
 * @param sup Reference to the superclass object.
 * @param booleanParameterValue Used for boolean parameter value.
 *        If this attribute is populated, integerParameterValue and floatParameterValue will not be.
 * @param floatParameterValue Used for floating point parameter value.
 *        If this attribute is populated, booleanParameterValue and integerParameterValue will not be.
 * @param integerParameterValue Used for integer parameter value.
 *        If this attribute is populated, booleanParameterValue and floatParameterValue will not be.
 * @param parameterNumber Sequence number of the parameter among the set of parameters associated with the related proprietary user-defined model.
 * @param AsynchronousMachineUserDefined Proprietary user-defined model with which this parameter is associated.
 * @param DiscontinuousExcitationControlUserDefined Proprietary user-defined model with which this parameter is associated.
 * @param ExcitationSystemUserDefined Proprietary user-defined model with which this parameter is associated.
 * @param LoadUserDefined Proprietary user-defined model with which this parameter is associated.
 * @param MechanicalLoadUserDefined Proprietary user-defined model with which this parameter is associated.
 * @param OverexcitationLimiterUserDefined Proprietary user-defined model with which this parameter is associated.
 * @param PFVArControllerType1UserDefined Proprietary user-defined model with which this parameter is associated.
 * @param PFVArControllerType2UserDefined Proprietary user-defined model with which this parameter is associated.
 * @param PowerSystemStabilizerUserDefined Proprietary user-defined model with which this parameter is associated.
 * @param SynchronousMachineUserDefined Proprietary user-defined model with which this parameter is associated.
 * @param TurbineGovernorUserDefined Proprietary user-defined model with which this parameter is associated.
 * @param TurbineLoadControllerUserDefined Proprietary user-defined model with which this parameter is associated.
 * @param UnderexcitationLimiterUserDefined Proprietary user-defined model with which this parameter is associated.
 * @param VoltageAdjusterUserDefined Proprietary user-defined model with which this parameter is associated.
 * @param VoltageCompensatorUserDefined Proprietary user-defined model with which this parameter is associated.
 * @param WindPlantUserDefined Proprietary user-defined model with which this parameter is associated.
 * @param WindType1or2UserDefined Proprietary user-defined model with which this parameter is associated.
 * @param WindType3or4UserDefined Proprietary user-defined model with which this parameter is associated.
 * @group UserDefinedModels
 * @groupname UserDefinedModels Package UserDefinedModels
 * @groupdesc UserDefinedModels This section contains user-defined dynamic model classes to support the exchange of both proprietary and explicitly defined user-defined models.  
<u>
</u><u>Proprietary models</u> represent behaviour which, while not defined by a standard model class, is mutually understood by the sending and receiving applications based on the name passed in the .name attribute of the appropriate xxxUserDefined class.  Proprietary model parameters are passed as general attributes using as many instances of the ProprietaryParameterDynamics class as there are parameters.
<u>
</u><u>Explicitly defined models</u> describe dynamic behaviour in detail in terms of control blocks and their input and output signals.  NOTE: The classes to support explicitly defined modelling are not currently defined - it is future work intended to also be supported by the family of xxxUserDefined classes.

Both types of user-defined models use the family of xxxUserDefined classes, which allow a user-defined model to be utilized:
<ul>
	<li>as the model for an individual standard function block (like turbine-governor or power system stabilizer) in a standard interconnection model whose other function blocks could be either standard or user-defined.  For an illustration of this form of usage for a proprietary model, see the ExampleFunctionBlockProprietaryModel diagram in the Examples section.</li>
</ul>
<ul>
	<li>as the complete representation of a dynamic behaviour model (for an entire synchronous machine, for example) where standard function blocks and standard interconnections are not used at all. For an illustration of this form of usage for a proprietary model, see the ExampleCompleteProprietaryModel diagram in the Examples section.</li>
</ul>
 */
case class ProprietaryParameterDynamics
(
    override val sup: BasicElement,
    booleanParameterValue: Boolean,
    floatParameterValue: Double,
    integerParameterValue: Int,
    parameterNumber: Int,
    AsynchronousMachineUserDefined: String,
    DiscontinuousExcitationControlUserDefined: String,
    ExcitationSystemUserDefined: String,
    LoadUserDefined: String,
    MechanicalLoadUserDefined: String,
    OverexcitationLimiterUserDefined: String,
    PFVArControllerType1UserDefined: String,
    PFVArControllerType2UserDefined: String,
    PowerSystemStabilizerUserDefined: String,
    SynchronousMachineUserDefined: String,
    TurbineGovernorUserDefined: String,
    TurbineLoadControllerUserDefined: String,
    UnderexcitationLimiterUserDefined: String,
    VoltageAdjusterUserDefined: String,
    VoltageCompensatorUserDefined: String,
    WindPlantUserDefined: String,
    WindType1or2UserDefined: String,
    WindType3or4UserDefined: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, 0.0, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ProprietaryParameterDynamics] }
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
        "\t\t<cim:ProprietaryParameterDynamics.booleanParameterValue>" + booleanParameterValue + "</cim:ProprietaryParameterDynamics.booleanParameterValue>\n" +
        "\t\t<cim:ProprietaryParameterDynamics.floatParameterValue>" + floatParameterValue + "</cim:ProprietaryParameterDynamics.floatParameterValue>\n" +
        "\t\t<cim:ProprietaryParameterDynamics.integerParameterValue>" + integerParameterValue + "</cim:ProprietaryParameterDynamics.integerParameterValue>\n" +
        "\t\t<cim:ProprietaryParameterDynamics.parameterNumber>" + parameterNumber + "</cim:ProprietaryParameterDynamics.parameterNumber>\n" +
        (if (null != AsynchronousMachineUserDefined) "\t\t<cim:ProprietaryParameterDynamics.AsynchronousMachineUserDefined rdf:resource=\"#" + AsynchronousMachineUserDefined + "\"/>\n" else "") +
        (if (null != DiscontinuousExcitationControlUserDefined) "\t\t<cim:ProprietaryParameterDynamics.DiscontinuousExcitationControlUserDefined rdf:resource=\"#" + DiscontinuousExcitationControlUserDefined + "\"/>\n" else "") +
        (if (null != ExcitationSystemUserDefined) "\t\t<cim:ProprietaryParameterDynamics.ExcitationSystemUserDefined rdf:resource=\"#" + ExcitationSystemUserDefined + "\"/>\n" else "") +
        (if (null != LoadUserDefined) "\t\t<cim:ProprietaryParameterDynamics.LoadUserDefined rdf:resource=\"#" + LoadUserDefined + "\"/>\n" else "") +
        (if (null != MechanicalLoadUserDefined) "\t\t<cim:ProprietaryParameterDynamics.MechanicalLoadUserDefined rdf:resource=\"#" + MechanicalLoadUserDefined + "\"/>\n" else "") +
        (if (null != OverexcitationLimiterUserDefined) "\t\t<cim:ProprietaryParameterDynamics.OverexcitationLimiterUserDefined rdf:resource=\"#" + OverexcitationLimiterUserDefined + "\"/>\n" else "") +
        (if (null != PFVArControllerType1UserDefined) "\t\t<cim:ProprietaryParameterDynamics.PFVArControllerType1UserDefined rdf:resource=\"#" + PFVArControllerType1UserDefined + "\"/>\n" else "") +
        (if (null != PFVArControllerType2UserDefined) "\t\t<cim:ProprietaryParameterDynamics.PFVArControllerType2UserDefined rdf:resource=\"#" + PFVArControllerType2UserDefined + "\"/>\n" else "") +
        (if (null != PowerSystemStabilizerUserDefined) "\t\t<cim:ProprietaryParameterDynamics.PowerSystemStabilizerUserDefined rdf:resource=\"#" + PowerSystemStabilizerUserDefined + "\"/>\n" else "") +
        (if (null != SynchronousMachineUserDefined) "\t\t<cim:ProprietaryParameterDynamics.SynchronousMachineUserDefined rdf:resource=\"#" + SynchronousMachineUserDefined + "\"/>\n" else "") +
        (if (null != TurbineGovernorUserDefined) "\t\t<cim:ProprietaryParameterDynamics.TurbineGovernorUserDefined rdf:resource=\"#" + TurbineGovernorUserDefined + "\"/>\n" else "") +
        (if (null != TurbineLoadControllerUserDefined) "\t\t<cim:ProprietaryParameterDynamics.TurbineLoadControllerUserDefined rdf:resource=\"#" + TurbineLoadControllerUserDefined + "\"/>\n" else "") +
        (if (null != UnderexcitationLimiterUserDefined) "\t\t<cim:ProprietaryParameterDynamics.UnderexcitationLimiterUserDefined rdf:resource=\"#" + UnderexcitationLimiterUserDefined + "\"/>\n" else "") +
        (if (null != VoltageAdjusterUserDefined) "\t\t<cim:ProprietaryParameterDynamics.VoltageAdjusterUserDefined rdf:resource=\"#" + VoltageAdjusterUserDefined + "\"/>\n" else "") +
        (if (null != VoltageCompensatorUserDefined) "\t\t<cim:ProprietaryParameterDynamics.VoltageCompensatorUserDefined rdf:resource=\"#" + VoltageCompensatorUserDefined + "\"/>\n" else "") +
        (if (null != WindPlantUserDefined) "\t\t<cim:ProprietaryParameterDynamics.WindPlantUserDefined rdf:resource=\"#" + WindPlantUserDefined + "\"/>\n" else "") +
        (if (null != WindType1or2UserDefined) "\t\t<cim:ProprietaryParameterDynamics.WindType1or2UserDefined rdf:resource=\"#" + WindType1or2UserDefined + "\"/>\n" else "") +
        (if (null != WindType3or4UserDefined) "\t\t<cim:ProprietaryParameterDynamics.WindType3or4UserDefined rdf:resource=\"#" + WindType3or4UserDefined + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ProprietaryParameterDynamics rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ProprietaryParameterDynamics>"
    }
}

object ProprietaryParameterDynamics
extends
    Parseable[ProprietaryParameterDynamics]
{
    val booleanParameterValue = parse_element (element ("""ProprietaryParameterDynamics.booleanParameterValue"""))
    val floatParameterValue = parse_element (element ("""ProprietaryParameterDynamics.floatParameterValue"""))
    val integerParameterValue = parse_element (element ("""ProprietaryParameterDynamics.integerParameterValue"""))
    val parameterNumber = parse_element (element ("""ProprietaryParameterDynamics.parameterNumber"""))
    val AsynchronousMachineUserDefined = parse_attribute (attribute ("""ProprietaryParameterDynamics.AsynchronousMachineUserDefined"""))
    val DiscontinuousExcitationControlUserDefined = parse_attribute (attribute ("""ProprietaryParameterDynamics.DiscontinuousExcitationControlUserDefined"""))
    val ExcitationSystemUserDefined = parse_attribute (attribute ("""ProprietaryParameterDynamics.ExcitationSystemUserDefined"""))
    val LoadUserDefined = parse_attribute (attribute ("""ProprietaryParameterDynamics.LoadUserDefined"""))
    val MechanicalLoadUserDefined = parse_attribute (attribute ("""ProprietaryParameterDynamics.MechanicalLoadUserDefined"""))
    val OverexcitationLimiterUserDefined = parse_attribute (attribute ("""ProprietaryParameterDynamics.OverexcitationLimiterUserDefined"""))
    val PFVArControllerType1UserDefined = parse_attribute (attribute ("""ProprietaryParameterDynamics.PFVArControllerType1UserDefined"""))
    val PFVArControllerType2UserDefined = parse_attribute (attribute ("""ProprietaryParameterDynamics.PFVArControllerType2UserDefined"""))
    val PowerSystemStabilizerUserDefined = parse_attribute (attribute ("""ProprietaryParameterDynamics.PowerSystemStabilizerUserDefined"""))
    val SynchronousMachineUserDefined = parse_attribute (attribute ("""ProprietaryParameterDynamics.SynchronousMachineUserDefined"""))
    val TurbineGovernorUserDefined = parse_attribute (attribute ("""ProprietaryParameterDynamics.TurbineGovernorUserDefined"""))
    val TurbineLoadControllerUserDefined = parse_attribute (attribute ("""ProprietaryParameterDynamics.TurbineLoadControllerUserDefined"""))
    val UnderexcitationLimiterUserDefined = parse_attribute (attribute ("""ProprietaryParameterDynamics.UnderexcitationLimiterUserDefined"""))
    val VoltageAdjusterUserDefined = parse_attribute (attribute ("""ProprietaryParameterDynamics.VoltageAdjusterUserDefined"""))
    val VoltageCompensatorUserDefined = parse_attribute (attribute ("""ProprietaryParameterDynamics.VoltageCompensatorUserDefined"""))
    val WindPlantUserDefined = parse_attribute (attribute ("""ProprietaryParameterDynamics.WindPlantUserDefined"""))
    val WindType1or2UserDefined = parse_attribute (attribute ("""ProprietaryParameterDynamics.WindType1or2UserDefined"""))
    val WindType3or4UserDefined = parse_attribute (attribute ("""ProprietaryParameterDynamics.WindType3or4UserDefined"""))
    def parse (context: Context): ProprietaryParameterDynamics =
    {
        ProprietaryParameterDynamics(
            BasicElement.parse (context),
            toBoolean (booleanParameterValue (context), context),
            toDouble (floatParameterValue (context), context),
            toInteger (integerParameterValue (context), context),
            toInteger (parameterNumber (context), context),
            AsynchronousMachineUserDefined (context),
            DiscontinuousExcitationControlUserDefined (context),
            ExcitationSystemUserDefined (context),
            LoadUserDefined (context),
            MechanicalLoadUserDefined (context),
            OverexcitationLimiterUserDefined (context),
            PFVArControllerType1UserDefined (context),
            PFVArControllerType2UserDefined (context),
            PowerSystemStabilizerUserDefined (context),
            SynchronousMachineUserDefined (context),
            TurbineGovernorUserDefined (context),
            TurbineLoadControllerUserDefined (context),
            UnderexcitationLimiterUserDefined (context),
            VoltageAdjusterUserDefined (context),
            VoltageCompensatorUserDefined (context),
            WindPlantUserDefined (context),
            WindType1or2UserDefined (context),
            WindType3or4UserDefined (context)
        )
    }
}

/**
 * Synchronous machine whose dynamic behaviour is described by a user-defined model.
 *
 * @param sup Reference to the superclass object.
 * @param proprietary Behaviour is based on proprietary model as opposed to detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @group UserDefinedModels
 * @groupname UserDefinedModels Package UserDefinedModels
 * @groupdesc UserDefinedModels This section contains user-defined dynamic model classes to support the exchange of both proprietary and explicitly defined user-defined models.  
<u>
</u><u>Proprietary models</u> represent behaviour which, while not defined by a standard model class, is mutually understood by the sending and receiving applications based on the name passed in the .name attribute of the appropriate xxxUserDefined class.  Proprietary model parameters are passed as general attributes using as many instances of the ProprietaryParameterDynamics class as there are parameters.
<u>
</u><u>Explicitly defined models</u> describe dynamic behaviour in detail in terms of control blocks and their input and output signals.  NOTE: The classes to support explicitly defined modelling are not currently defined - it is future work intended to also be supported by the family of xxxUserDefined classes.

Both types of user-defined models use the family of xxxUserDefined classes, which allow a user-defined model to be utilized:
<ul>
	<li>as the model for an individual standard function block (like turbine-governor or power system stabilizer) in a standard interconnection model whose other function blocks could be either standard or user-defined.  For an illustration of this form of usage for a proprietary model, see the ExampleFunctionBlockProprietaryModel diagram in the Examples section.</li>
</ul>
<ul>
	<li>as the complete representation of a dynamic behaviour model (for an entire synchronous machine, for example) where standard function blocks and standard interconnections are not used at all. For an illustration of this form of usage for a proprietary model, see the ExampleCompleteProprietaryModel diagram in the Examples section.</li>
</ul>
 */
case class SynchronousMachineUserDefined
(
    override val sup: SynchronousMachineDynamics,
    proprietary: Boolean
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def SynchronousMachineDynamics: SynchronousMachineDynamics = sup.asInstanceOf[SynchronousMachineDynamics]
    override def copy (): Row = { clone ().asInstanceOf[SynchronousMachineUserDefined] }
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
        "\t\t<cim:SynchronousMachineUserDefined.proprietary>" + proprietary + "</cim:SynchronousMachineUserDefined.proprietary>\n"
    }
    override def export: String =
    {
        "\t<cim:SynchronousMachineUserDefined rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SynchronousMachineUserDefined>"
    }
}

object SynchronousMachineUserDefined
extends
    Parseable[SynchronousMachineUserDefined]
{
    val proprietary = parse_element (element ("""SynchronousMachineUserDefined.proprietary"""))
    def parse (context: Context): SynchronousMachineUserDefined =
    {
        SynchronousMachineUserDefined(
            SynchronousMachineDynamics.parse (context),
            toBoolean (proprietary (context), context)
        )
    }
}

/**
 * Turbine-governor function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 *
 * @param sup Reference to the superclass object.
 * @param proprietary Behaviour is based on proprietary model as opposed to detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @group UserDefinedModels
 * @groupname UserDefinedModels Package UserDefinedModels
 * @groupdesc UserDefinedModels This section contains user-defined dynamic model classes to support the exchange of both proprietary and explicitly defined user-defined models.  
<u>
</u><u>Proprietary models</u> represent behaviour which, while not defined by a standard model class, is mutually understood by the sending and receiving applications based on the name passed in the .name attribute of the appropriate xxxUserDefined class.  Proprietary model parameters are passed as general attributes using as many instances of the ProprietaryParameterDynamics class as there are parameters.
<u>
</u><u>Explicitly defined models</u> describe dynamic behaviour in detail in terms of control blocks and their input and output signals.  NOTE: The classes to support explicitly defined modelling are not currently defined - it is future work intended to also be supported by the family of xxxUserDefined classes.

Both types of user-defined models use the family of xxxUserDefined classes, which allow a user-defined model to be utilized:
<ul>
	<li>as the model for an individual standard function block (like turbine-governor or power system stabilizer) in a standard interconnection model whose other function blocks could be either standard or user-defined.  For an illustration of this form of usage for a proprietary model, see the ExampleFunctionBlockProprietaryModel diagram in the Examples section.</li>
</ul>
<ul>
	<li>as the complete representation of a dynamic behaviour model (for an entire synchronous machine, for example) where standard function blocks and standard interconnections are not used at all. For an illustration of this form of usage for a proprietary model, see the ExampleCompleteProprietaryModel diagram in the Examples section.</li>
</ul>
 */
case class TurbineGovernorUserDefined
(
    override val sup: TurbineGovernorDynamics,
    proprietary: Boolean
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { clone ().asInstanceOf[TurbineGovernorUserDefined] }
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
        "\t\t<cim:TurbineGovernorUserDefined.proprietary>" + proprietary + "</cim:TurbineGovernorUserDefined.proprietary>\n"
    }
    override def export: String =
    {
        "\t<cim:TurbineGovernorUserDefined rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TurbineGovernorUserDefined>"
    }
}

object TurbineGovernorUserDefined
extends
    Parseable[TurbineGovernorUserDefined]
{
    val proprietary = parse_element (element ("""TurbineGovernorUserDefined.proprietary"""))
    def parse (context: Context): TurbineGovernorUserDefined =
    {
        TurbineGovernorUserDefined(
            TurbineGovernorDynamics.parse (context),
            toBoolean (proprietary (context), context)
        )
    }
}

/**
 * Turbine load controller function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 *
 * @param sup Reference to the superclass object.
 * @param proprietary Behaviour is based on proprietary model as opposed to detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @group UserDefinedModels
 * @groupname UserDefinedModels Package UserDefinedModels
 * @groupdesc UserDefinedModels This section contains user-defined dynamic model classes to support the exchange of both proprietary and explicitly defined user-defined models.  
<u>
</u><u>Proprietary models</u> represent behaviour which, while not defined by a standard model class, is mutually understood by the sending and receiving applications based on the name passed in the .name attribute of the appropriate xxxUserDefined class.  Proprietary model parameters are passed as general attributes using as many instances of the ProprietaryParameterDynamics class as there are parameters.
<u>
</u><u>Explicitly defined models</u> describe dynamic behaviour in detail in terms of control blocks and their input and output signals.  NOTE: The classes to support explicitly defined modelling are not currently defined - it is future work intended to also be supported by the family of xxxUserDefined classes.

Both types of user-defined models use the family of xxxUserDefined classes, which allow a user-defined model to be utilized:
<ul>
	<li>as the model for an individual standard function block (like turbine-governor or power system stabilizer) in a standard interconnection model whose other function blocks could be either standard or user-defined.  For an illustration of this form of usage for a proprietary model, see the ExampleFunctionBlockProprietaryModel diagram in the Examples section.</li>
</ul>
<ul>
	<li>as the complete representation of a dynamic behaviour model (for an entire synchronous machine, for example) where standard function blocks and standard interconnections are not used at all. For an illustration of this form of usage for a proprietary model, see the ExampleCompleteProprietaryModel diagram in the Examples section.</li>
</ul>
 */
case class TurbineLoadControllerUserDefined
(
    override val sup: TurbineLoadControllerDynamics,
    proprietary: Boolean
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def TurbineLoadControllerDynamics: TurbineLoadControllerDynamics = sup.asInstanceOf[TurbineLoadControllerDynamics]
    override def copy (): Row = { clone ().asInstanceOf[TurbineLoadControllerUserDefined] }
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
        "\t\t<cim:TurbineLoadControllerUserDefined.proprietary>" + proprietary + "</cim:TurbineLoadControllerUserDefined.proprietary>\n"
    }
    override def export: String =
    {
        "\t<cim:TurbineLoadControllerUserDefined rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TurbineLoadControllerUserDefined>"
    }
}

object TurbineLoadControllerUserDefined
extends
    Parseable[TurbineLoadControllerUserDefined]
{
    val proprietary = parse_element (element ("""TurbineLoadControllerUserDefined.proprietary"""))
    def parse (context: Context): TurbineLoadControllerUserDefined =
    {
        TurbineLoadControllerUserDefined(
            TurbineLoadControllerDynamics.parse (context),
            toBoolean (proprietary (context), context)
        )
    }
}

/**
 * Underexcitation limiter function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 *
 * @param sup Reference to the superclass object.
 * @param proprietary Behaviour is based on proprietary model as opposed to detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @group UserDefinedModels
 * @groupname UserDefinedModels Package UserDefinedModels
 * @groupdesc UserDefinedModels This section contains user-defined dynamic model classes to support the exchange of both proprietary and explicitly defined user-defined models.  
<u>
</u><u>Proprietary models</u> represent behaviour which, while not defined by a standard model class, is mutually understood by the sending and receiving applications based on the name passed in the .name attribute of the appropriate xxxUserDefined class.  Proprietary model parameters are passed as general attributes using as many instances of the ProprietaryParameterDynamics class as there are parameters.
<u>
</u><u>Explicitly defined models</u> describe dynamic behaviour in detail in terms of control blocks and their input and output signals.  NOTE: The classes to support explicitly defined modelling are not currently defined - it is future work intended to also be supported by the family of xxxUserDefined classes.

Both types of user-defined models use the family of xxxUserDefined classes, which allow a user-defined model to be utilized:
<ul>
	<li>as the model for an individual standard function block (like turbine-governor or power system stabilizer) in a standard interconnection model whose other function blocks could be either standard or user-defined.  For an illustration of this form of usage for a proprietary model, see the ExampleFunctionBlockProprietaryModel diagram in the Examples section.</li>
</ul>
<ul>
	<li>as the complete representation of a dynamic behaviour model (for an entire synchronous machine, for example) where standard function blocks and standard interconnections are not used at all. For an illustration of this form of usage for a proprietary model, see the ExampleCompleteProprietaryModel diagram in the Examples section.</li>
</ul>
 */
case class UnderexcitationLimiterUserDefined
(
    override val sup: UnderexcitationLimiterDynamics,
    proprietary: Boolean
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def UnderexcitationLimiterDynamics: UnderexcitationLimiterDynamics = sup.asInstanceOf[UnderexcitationLimiterDynamics]
    override def copy (): Row = { clone ().asInstanceOf[UnderexcitationLimiterUserDefined] }
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
        "\t\t<cim:UnderexcitationLimiterUserDefined.proprietary>" + proprietary + "</cim:UnderexcitationLimiterUserDefined.proprietary>\n"
    }
    override def export: String =
    {
        "\t<cim:UnderexcitationLimiterUserDefined rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:UnderexcitationLimiterUserDefined>"
    }
}

object UnderexcitationLimiterUserDefined
extends
    Parseable[UnderexcitationLimiterUserDefined]
{
    val proprietary = parse_element (element ("""UnderexcitationLimiterUserDefined.proprietary"""))
    def parse (context: Context): UnderexcitationLimiterUserDefined =
    {
        UnderexcitationLimiterUserDefined(
            UnderexcitationLimiterDynamics.parse (context),
            toBoolean (proprietary (context), context)
        )
    }
}

/**
 * <font color="#0f0f0f">Voltage adjuster</font> function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 *
 * @param sup Reference to the superclass object.
 * @param proprietary Behaviour is based on proprietary model as opposed to detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @group UserDefinedModels
 * @groupname UserDefinedModels Package UserDefinedModels
 * @groupdesc UserDefinedModels This section contains user-defined dynamic model classes to support the exchange of both proprietary and explicitly defined user-defined models.  
<u>
</u><u>Proprietary models</u> represent behaviour which, while not defined by a standard model class, is mutually understood by the sending and receiving applications based on the name passed in the .name attribute of the appropriate xxxUserDefined class.  Proprietary model parameters are passed as general attributes using as many instances of the ProprietaryParameterDynamics class as there are parameters.
<u>
</u><u>Explicitly defined models</u> describe dynamic behaviour in detail in terms of control blocks and their input and output signals.  NOTE: The classes to support explicitly defined modelling are not currently defined - it is future work intended to also be supported by the family of xxxUserDefined classes.

Both types of user-defined models use the family of xxxUserDefined classes, which allow a user-defined model to be utilized:
<ul>
	<li>as the model for an individual standard function block (like turbine-governor or power system stabilizer) in a standard interconnection model whose other function blocks could be either standard or user-defined.  For an illustration of this form of usage for a proprietary model, see the ExampleFunctionBlockProprietaryModel diagram in the Examples section.</li>
</ul>
<ul>
	<li>as the complete representation of a dynamic behaviour model (for an entire synchronous machine, for example) where standard function blocks and standard interconnections are not used at all. For an illustration of this form of usage for a proprietary model, see the ExampleCompleteProprietaryModel diagram in the Examples section.</li>
</ul>
 */
case class VoltageAdjusterUserDefined
(
    override val sup: VoltageAdjusterDynamics,
    proprietary: Boolean
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def VoltageAdjusterDynamics: VoltageAdjusterDynamics = sup.asInstanceOf[VoltageAdjusterDynamics]
    override def copy (): Row = { clone ().asInstanceOf[VoltageAdjusterUserDefined] }
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
        "\t\t<cim:VoltageAdjusterUserDefined.proprietary>" + proprietary + "</cim:VoltageAdjusterUserDefined.proprietary>\n"
    }
    override def export: String =
    {
        "\t<cim:VoltageAdjusterUserDefined rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:VoltageAdjusterUserDefined>"
    }
}

object VoltageAdjusterUserDefined
extends
    Parseable[VoltageAdjusterUserDefined]
{
    val proprietary = parse_element (element ("""VoltageAdjusterUserDefined.proprietary"""))
    def parse (context: Context): VoltageAdjusterUserDefined =
    {
        VoltageAdjusterUserDefined(
            VoltageAdjusterDynamics.parse (context),
            toBoolean (proprietary (context), context)
        )
    }
}

/**
 * Voltage compensator function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 *
 * @param sup Reference to the superclass object.
 * @param proprietary Behaviour is based on proprietary model as opposed to detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @group UserDefinedModels
 * @groupname UserDefinedModels Package UserDefinedModels
 * @groupdesc UserDefinedModels This section contains user-defined dynamic model classes to support the exchange of both proprietary and explicitly defined user-defined models.  
<u>
</u><u>Proprietary models</u> represent behaviour which, while not defined by a standard model class, is mutually understood by the sending and receiving applications based on the name passed in the .name attribute of the appropriate xxxUserDefined class.  Proprietary model parameters are passed as general attributes using as many instances of the ProprietaryParameterDynamics class as there are parameters.
<u>
</u><u>Explicitly defined models</u> describe dynamic behaviour in detail in terms of control blocks and their input and output signals.  NOTE: The classes to support explicitly defined modelling are not currently defined - it is future work intended to also be supported by the family of xxxUserDefined classes.

Both types of user-defined models use the family of xxxUserDefined classes, which allow a user-defined model to be utilized:
<ul>
	<li>as the model for an individual standard function block (like turbine-governor or power system stabilizer) in a standard interconnection model whose other function blocks could be either standard or user-defined.  For an illustration of this form of usage for a proprietary model, see the ExampleFunctionBlockProprietaryModel diagram in the Examples section.</li>
</ul>
<ul>
	<li>as the complete representation of a dynamic behaviour model (for an entire synchronous machine, for example) where standard function blocks and standard interconnections are not used at all. For an illustration of this form of usage for a proprietary model, see the ExampleCompleteProprietaryModel diagram in the Examples section.</li>
</ul>
 */
case class VoltageCompensatorUserDefined
(
    override val sup: VoltageCompensatorDynamics,
    proprietary: Boolean
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def VoltageCompensatorDynamics: VoltageCompensatorDynamics = sup.asInstanceOf[VoltageCompensatorDynamics]
    override def copy (): Row = { clone ().asInstanceOf[VoltageCompensatorUserDefined] }
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
        "\t\t<cim:VoltageCompensatorUserDefined.proprietary>" + proprietary + "</cim:VoltageCompensatorUserDefined.proprietary>\n"
    }
    override def export: String =
    {
        "\t<cim:VoltageCompensatorUserDefined rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:VoltageCompensatorUserDefined>"
    }
}

object VoltageCompensatorUserDefined
extends
    Parseable[VoltageCompensatorUserDefined]
{
    val proprietary = parse_element (element ("""VoltageCompensatorUserDefined.proprietary"""))
    def parse (context: Context): VoltageCompensatorUserDefined =
    {
        VoltageCompensatorUserDefined(
            VoltageCompensatorDynamics.parse (context),
            toBoolean (proprietary (context), context)
        )
    }
}

/**
 * Wind plant function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 *
 * @param sup Reference to the superclass object.
 * @param proprietary Behaviour is based on proprietary model as opposed to detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @group UserDefinedModels
 * @groupname UserDefinedModels Package UserDefinedModels
 * @groupdesc UserDefinedModels This section contains user-defined dynamic model classes to support the exchange of both proprietary and explicitly defined user-defined models.  
<u>
</u><u>Proprietary models</u> represent behaviour which, while not defined by a standard model class, is mutually understood by the sending and receiving applications based on the name passed in the .name attribute of the appropriate xxxUserDefined class.  Proprietary model parameters are passed as general attributes using as many instances of the ProprietaryParameterDynamics class as there are parameters.
<u>
</u><u>Explicitly defined models</u> describe dynamic behaviour in detail in terms of control blocks and their input and output signals.  NOTE: The classes to support explicitly defined modelling are not currently defined - it is future work intended to also be supported by the family of xxxUserDefined classes.

Both types of user-defined models use the family of xxxUserDefined classes, which allow a user-defined model to be utilized:
<ul>
	<li>as the model for an individual standard function block (like turbine-governor or power system stabilizer) in a standard interconnection model whose other function blocks could be either standard or user-defined.  For an illustration of this form of usage for a proprietary model, see the ExampleFunctionBlockProprietaryModel diagram in the Examples section.</li>
</ul>
<ul>
	<li>as the complete representation of a dynamic behaviour model (for an entire synchronous machine, for example) where standard function blocks and standard interconnections are not used at all. For an illustration of this form of usage for a proprietary model, see the ExampleCompleteProprietaryModel diagram in the Examples section.</li>
</ul>
 */
case class WindPlantUserDefined
(
    override val sup: WindPlantDynamics,
    proprietary: Boolean
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def WindPlantDynamics: WindPlantDynamics = sup.asInstanceOf[WindPlantDynamics]
    override def copy (): Row = { clone ().asInstanceOf[WindPlantUserDefined] }
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
        "\t\t<cim:WindPlantUserDefined.proprietary>" + proprietary + "</cim:WindPlantUserDefined.proprietary>\n"
    }
    override def export: String =
    {
        "\t<cim:WindPlantUserDefined rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WindPlantUserDefined>"
    }
}

object WindPlantUserDefined
extends
    Parseable[WindPlantUserDefined]
{
    val proprietary = parse_element (element ("""WindPlantUserDefined.proprietary"""))
    def parse (context: Context): WindPlantUserDefined =
    {
        WindPlantUserDefined(
            WindPlantDynamics.parse (context),
            toBoolean (proprietary (context), context)
        )
    }
}

/**
 * Wind Type 1 or Type 2 function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 *
 * @param sup Reference to the superclass object.
 * @param proprietary Behaviour is based on proprietary model as opposed to detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @group UserDefinedModels
 * @groupname UserDefinedModels Package UserDefinedModels
 * @groupdesc UserDefinedModels This section contains user-defined dynamic model classes to support the exchange of both proprietary and explicitly defined user-defined models.  
<u>
</u><u>Proprietary models</u> represent behaviour which, while not defined by a standard model class, is mutually understood by the sending and receiving applications based on the name passed in the .name attribute of the appropriate xxxUserDefined class.  Proprietary model parameters are passed as general attributes using as many instances of the ProprietaryParameterDynamics class as there are parameters.
<u>
</u><u>Explicitly defined models</u> describe dynamic behaviour in detail in terms of control blocks and their input and output signals.  NOTE: The classes to support explicitly defined modelling are not currently defined - it is future work intended to also be supported by the family of xxxUserDefined classes.

Both types of user-defined models use the family of xxxUserDefined classes, which allow a user-defined model to be utilized:
<ul>
	<li>as the model for an individual standard function block (like turbine-governor or power system stabilizer) in a standard interconnection model whose other function blocks could be either standard or user-defined.  For an illustration of this form of usage for a proprietary model, see the ExampleFunctionBlockProprietaryModel diagram in the Examples section.</li>
</ul>
<ul>
	<li>as the complete representation of a dynamic behaviour model (for an entire synchronous machine, for example) where standard function blocks and standard interconnections are not used at all. For an illustration of this form of usage for a proprietary model, see the ExampleCompleteProprietaryModel diagram in the Examples section.</li>
</ul>
 */
case class WindType1or2UserDefined
(
    override val sup: WindTurbineType1or2Dynamics,
    proprietary: Boolean
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def WindTurbineType1or2Dynamics: WindTurbineType1or2Dynamics = sup.asInstanceOf[WindTurbineType1or2Dynamics]
    override def copy (): Row = { clone ().asInstanceOf[WindType1or2UserDefined] }
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
        "\t\t<cim:WindType1or2UserDefined.proprietary>" + proprietary + "</cim:WindType1or2UserDefined.proprietary>\n"
    }
    override def export: String =
    {
        "\t<cim:WindType1or2UserDefined rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WindType1or2UserDefined>"
    }
}

object WindType1or2UserDefined
extends
    Parseable[WindType1or2UserDefined]
{
    val proprietary = parse_element (element ("""WindType1or2UserDefined.proprietary"""))
    def parse (context: Context): WindType1or2UserDefined =
    {
        WindType1or2UserDefined(
            WindTurbineType1or2Dynamics.parse (context),
            toBoolean (proprietary (context), context)
        )
    }
}

/**
 * Wind Type 3 or Type 4 function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 *
 * @param sup Reference to the superclass object.
 * @param proprietary Behaviour is based on proprietary model as opposed to detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @group UserDefinedModels
 * @groupname UserDefinedModels Package UserDefinedModels
 * @groupdesc UserDefinedModels This section contains user-defined dynamic model classes to support the exchange of both proprietary and explicitly defined user-defined models.  
<u>
</u><u>Proprietary models</u> represent behaviour which, while not defined by a standard model class, is mutually understood by the sending and receiving applications based on the name passed in the .name attribute of the appropriate xxxUserDefined class.  Proprietary model parameters are passed as general attributes using as many instances of the ProprietaryParameterDynamics class as there are parameters.
<u>
</u><u>Explicitly defined models</u> describe dynamic behaviour in detail in terms of control blocks and their input and output signals.  NOTE: The classes to support explicitly defined modelling are not currently defined - it is future work intended to also be supported by the family of xxxUserDefined classes.

Both types of user-defined models use the family of xxxUserDefined classes, which allow a user-defined model to be utilized:
<ul>
	<li>as the model for an individual standard function block (like turbine-governor or power system stabilizer) in a standard interconnection model whose other function blocks could be either standard or user-defined.  For an illustration of this form of usage for a proprietary model, see the ExampleFunctionBlockProprietaryModel diagram in the Examples section.</li>
</ul>
<ul>
	<li>as the complete representation of a dynamic behaviour model (for an entire synchronous machine, for example) where standard function blocks and standard interconnections are not used at all. For an illustration of this form of usage for a proprietary model, see the ExampleCompleteProprietaryModel diagram in the Examples section.</li>
</ul>
 */
case class WindType3or4UserDefined
(
    override val sup: WindTurbineType3or4Dynamics,
    proprietary: Boolean
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def WindTurbineType3or4Dynamics: WindTurbineType3or4Dynamics = sup.asInstanceOf[WindTurbineType3or4Dynamics]
    override def copy (): Row = { clone ().asInstanceOf[WindType3or4UserDefined] }
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
        "\t\t<cim:WindType3or4UserDefined.proprietary>" + proprietary + "</cim:WindType3or4UserDefined.proprietary>\n"
    }
    override def export: String =
    {
        "\t<cim:WindType3or4UserDefined rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WindType3or4UserDefined>"
    }
}

object WindType3or4UserDefined
extends
    Parseable[WindType3or4UserDefined]
{
    val proprietary = parse_element (element ("""WindType3or4UserDefined.proprietary"""))
    def parse (context: Context): WindType3or4UserDefined =
    {
        WindType3or4UserDefined(
            WindTurbineType3or4Dynamics.parse (context),
            toBoolean (proprietary (context), context)
        )
    }
}

private[ninecode] object _UserDefinedModels
{
    def register: List[ClassInfo] =
    {
        List (
            AsynchronousMachineUserDefined.register,
            DiscontinuousExcitationControlUserDefined.register,
            ExcitationSystemUserDefined.register,
            LoadUserDefined.register,
            MechanicalLoadUserDefined.register,
            OverexcitationLimiterUserDefined.register,
            PFVArControllerType1UserDefined.register,
            PFVArControllerType2UserDefined.register,
            PowerSystemStabilizerUserDefined.register,
            ProprietaryParameterDynamics.register,
            SynchronousMachineUserDefined.register,
            TurbineGovernorUserDefined.register,
            TurbineLoadControllerUserDefined.register,
            UnderexcitationLimiterUserDefined.register,
            VoltageAdjusterUserDefined.register,
            VoltageCompensatorUserDefined.register,
            WindPlantUserDefined.register,
            WindType1or2UserDefined.register,
            WindType3or4UserDefined.register
        )
    }
}