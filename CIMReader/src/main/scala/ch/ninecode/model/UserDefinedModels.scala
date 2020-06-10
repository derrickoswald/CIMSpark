package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.CIMClassInfo
import ch.ninecode.cim.CIMContext
import ch.ninecode.cim.CIMParseable
import ch.ninecode.cim.CIMRelationship

/**
 * Asynchronous machine whose dynamic behaviour is described by a user-defined model.
 *
 * @param AsynchronousMachineDynamics [[ch.ninecode.model.AsynchronousMachineDynamics AsynchronousMachineDynamics]] Reference to the superclass object.
 * @param proprietary Behaviour is based on a proprietary model as opposed to a detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @param ProprietaryParameterDynamics [[ch.ninecode.model.ProprietaryParameterDynamics ProprietaryParameterDynamics]] Parameter of this proprietary user-defined model.
 * @group UserDefinedModels
 * @groupname UserDefinedModels Package UserDefinedModels
 * @groupdesc UserDefinedModels This subclause contains user-defined dynamic model classes to support the exchange of both proprietary and explicitly defined user-defined models.  
<u>Proprietary models</u> represent behaviour which, while not defined by a standard model class, is mutually understood by the sending and receiving applications based on the name passed in the .name attribute of the appropriate xxxUserDefined class.  Proprietary model parameters are passed as general attributes using as many instances of the ProprietaryParameterDynamics class as there are parameters.
<u>Explicitly defined models</u> describe dynamic behaviour in detail in terms of control blocks and their input and output signals.  Note that the classes to support explicitly defined modelling are not currently defined - it is future work intended to also be supported by the family of xxxUserDefined classes.
Both types of user-defined models use the family of xxxUserDefined classes, which allow a user-defined model to be used:
- as the model for an individual standard function block (such as a turbine-governor or power system stabilizer) in a standard interconnection model whose other function blocks could be either standard or user-defined.  For an illustration of this form of usage for a proprietary model, see the ExampleFunctionBlockProprietaryModel diagram in subclause 5.5.
- as the complete representation of a dynamic behaviour model (for an entire synchronous machine, for example) where standard function blocks and standard interconnections are not used at all. For an illustration of this form of usage for a proprietary model, see the ExampleCompleteProprietaryModel diagram in subclause 5.5.
 */
final case class AsynchronousMachineUserDefined
(
    AsynchronousMachineDynamics: AsynchronousMachineDynamics = null,
    proprietary: Boolean = false,
    ProprietaryParameterDynamics: List[String] = null
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
    override def sup: AsynchronousMachineDynamics = AsynchronousMachineDynamics

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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = AsynchronousMachineUserDefined.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AsynchronousMachineUserDefined.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (AsynchronousMachineUserDefined.fields (position), x))
        emitelem (0, proprietary)
        emitattrs (1, ProprietaryParameterDynamics)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AsynchronousMachineUserDefined rdf:ID=\"%s\">\n%s\t</cim:AsynchronousMachineUserDefined>".format (id, export_fields)
    }
}

object AsynchronousMachineUserDefined
extends
    CIMParseable[AsynchronousMachineUserDefined]
{
    override val fields: Array[String] = Array[String] (
        "proprietary",
        "ProprietaryParameterDynamics"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ProprietaryParameterDynamics", "ProprietaryParameterDynamics", "0..*", "0..1")
    )
    val proprietary: Fielder = parse_element (element (cls, fields(0)))
    val ProprietaryParameterDynamics: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): AsynchronousMachineUserDefined =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AsynchronousMachineUserDefined (
            AsynchronousMachineDynamics.parse (context),
            toBoolean (mask (proprietary (), 0)),
            masks (ProprietaryParameterDynamics (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Current source converter (CSC) function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 *
 * @param CSCDynamics [[ch.ninecode.model.CSCDynamics CSCDynamics]] Reference to the superclass object.
 * @param proprietary Behaviour is based on a proprietary model as opposed to a detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @param ProprietaryParameterDynamics [[ch.ninecode.model.ProprietaryParameterDynamics ProprietaryParameterDynamics]] Parameter of this proprietary user-defined model.
 * @group UserDefinedModels
 * @groupname UserDefinedModels Package UserDefinedModels
 * @groupdesc UserDefinedModels This subclause contains user-defined dynamic model classes to support the exchange of both proprietary and explicitly defined user-defined models.  
<u>Proprietary models</u> represent behaviour which, while not defined by a standard model class, is mutually understood by the sending and receiving applications based on the name passed in the .name attribute of the appropriate xxxUserDefined class.  Proprietary model parameters are passed as general attributes using as many instances of the ProprietaryParameterDynamics class as there are parameters.
<u>Explicitly defined models</u> describe dynamic behaviour in detail in terms of control blocks and their input and output signals.  Note that the classes to support explicitly defined modelling are not currently defined - it is future work intended to also be supported by the family of xxxUserDefined classes.
Both types of user-defined models use the family of xxxUserDefined classes, which allow a user-defined model to be used:
- as the model for an individual standard function block (such as a turbine-governor or power system stabilizer) in a standard interconnection model whose other function blocks could be either standard or user-defined.  For an illustration of this form of usage for a proprietary model, see the ExampleFunctionBlockProprietaryModel diagram in subclause 5.5.
- as the complete representation of a dynamic behaviour model (for an entire synchronous machine, for example) where standard function blocks and standard interconnections are not used at all. For an illustration of this form of usage for a proprietary model, see the ExampleCompleteProprietaryModel diagram in subclause 5.5.
 */
final case class CSCUserDefined
(
    CSCDynamics: CSCDynamics = null,
    proprietary: Boolean = false,
    ProprietaryParameterDynamics: List[String] = null
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
    override def sup: CSCDynamics = CSCDynamics

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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CSCUserDefined.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CSCUserDefined.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (CSCUserDefined.fields (position), x))
        emitelem (0, proprietary)
        emitattrs (1, ProprietaryParameterDynamics)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CSCUserDefined rdf:ID=\"%s\">\n%s\t</cim:CSCUserDefined>".format (id, export_fields)
    }
}

object CSCUserDefined
extends
    CIMParseable[CSCUserDefined]
{
    override val fields: Array[String] = Array[String] (
        "proprietary",
        "ProprietaryParameterDynamics"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ProprietaryParameterDynamics", "ProprietaryParameterDynamics", "0..*", "0..1")
    )
    val proprietary: Fielder = parse_element (element (cls, fields(0)))
    val ProprietaryParameterDynamics: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): CSCUserDefined =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CSCUserDefined (
            CSCDynamics.parse (context),
            toBoolean (mask (proprietary (), 0)),
            masks (ProprietaryParameterDynamics (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Discontinuous excitation control function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 *
 * @param DiscontinuousExcitationControlDynamics [[ch.ninecode.model.DiscontinuousExcitationControlDynamics DiscontinuousExcitationControlDynamics]] Reference to the superclass object.
 * @param proprietary Behaviour is based on a proprietary model as opposed to a detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @param ProprietaryParameterDynamics [[ch.ninecode.model.ProprietaryParameterDynamics ProprietaryParameterDynamics]] Parameter of this proprietary user-defined model.
 * @group UserDefinedModels
 * @groupname UserDefinedModels Package UserDefinedModels
 * @groupdesc UserDefinedModels This subclause contains user-defined dynamic model classes to support the exchange of both proprietary and explicitly defined user-defined models.  
<u>Proprietary models</u> represent behaviour which, while not defined by a standard model class, is mutually understood by the sending and receiving applications based on the name passed in the .name attribute of the appropriate xxxUserDefined class.  Proprietary model parameters are passed as general attributes using as many instances of the ProprietaryParameterDynamics class as there are parameters.
<u>Explicitly defined models</u> describe dynamic behaviour in detail in terms of control blocks and their input and output signals.  Note that the classes to support explicitly defined modelling are not currently defined - it is future work intended to also be supported by the family of xxxUserDefined classes.
Both types of user-defined models use the family of xxxUserDefined classes, which allow a user-defined model to be used:
- as the model for an individual standard function block (such as a turbine-governor or power system stabilizer) in a standard interconnection model whose other function blocks could be either standard or user-defined.  For an illustration of this form of usage for a proprietary model, see the ExampleFunctionBlockProprietaryModel diagram in subclause 5.5.
- as the complete representation of a dynamic behaviour model (for an entire synchronous machine, for example) where standard function blocks and standard interconnections are not used at all. For an illustration of this form of usage for a proprietary model, see the ExampleCompleteProprietaryModel diagram in subclause 5.5.
 */
final case class DiscontinuousExcitationControlUserDefined
(
    DiscontinuousExcitationControlDynamics: DiscontinuousExcitationControlDynamics = null,
    proprietary: Boolean = false,
    ProprietaryParameterDynamics: List[String] = null
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
    override def sup: DiscontinuousExcitationControlDynamics = DiscontinuousExcitationControlDynamics

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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = DiscontinuousExcitationControlUserDefined.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DiscontinuousExcitationControlUserDefined.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (DiscontinuousExcitationControlUserDefined.fields (position), x))
        emitelem (0, proprietary)
        emitattrs (1, ProprietaryParameterDynamics)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DiscontinuousExcitationControlUserDefined rdf:ID=\"%s\">\n%s\t</cim:DiscontinuousExcitationControlUserDefined>".format (id, export_fields)
    }
}

object DiscontinuousExcitationControlUserDefined
extends
    CIMParseable[DiscontinuousExcitationControlUserDefined]
{
    override val fields: Array[String] = Array[String] (
        "proprietary",
        "ProprietaryParameterDynamics"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ProprietaryParameterDynamics", "ProprietaryParameterDynamics", "0..*", "0..1")
    )
    val proprietary: Fielder = parse_element (element (cls, fields(0)))
    val ProprietaryParameterDynamics: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): DiscontinuousExcitationControlUserDefined =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DiscontinuousExcitationControlUserDefined (
            DiscontinuousExcitationControlDynamics.parse (context),
            toBoolean (mask (proprietary (), 0)),
            masks (ProprietaryParameterDynamics (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Excitation system function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 *
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param proprietary Behaviour is based on a proprietary model as opposed to a detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @param ProprietaryParameterDynamics [[ch.ninecode.model.ProprietaryParameterDynamics ProprietaryParameterDynamics]] Parameter of this proprietary user-defined model.
 * @group UserDefinedModels
 * @groupname UserDefinedModels Package UserDefinedModels
 * @groupdesc UserDefinedModels This subclause contains user-defined dynamic model classes to support the exchange of both proprietary and explicitly defined user-defined models.  
<u>Proprietary models</u> represent behaviour which, while not defined by a standard model class, is mutually understood by the sending and receiving applications based on the name passed in the .name attribute of the appropriate xxxUserDefined class.  Proprietary model parameters are passed as general attributes using as many instances of the ProprietaryParameterDynamics class as there are parameters.
<u>Explicitly defined models</u> describe dynamic behaviour in detail in terms of control blocks and their input and output signals.  Note that the classes to support explicitly defined modelling are not currently defined - it is future work intended to also be supported by the family of xxxUserDefined classes.
Both types of user-defined models use the family of xxxUserDefined classes, which allow a user-defined model to be used:
- as the model for an individual standard function block (such as a turbine-governor or power system stabilizer) in a standard interconnection model whose other function blocks could be either standard or user-defined.  For an illustration of this form of usage for a proprietary model, see the ExampleFunctionBlockProprietaryModel diagram in subclause 5.5.
- as the complete representation of a dynamic behaviour model (for an entire synchronous machine, for example) where standard function blocks and standard interconnections are not used at all. For an illustration of this form of usage for a proprietary model, see the ExampleCompleteProprietaryModel diagram in subclause 5.5.
 */
final case class ExcitationSystemUserDefined
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    proprietary: Boolean = false,
    ProprietaryParameterDynamics: List[String] = null
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcitationSystemUserDefined.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcitationSystemUserDefined.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ExcitationSystemUserDefined.fields (position), x))
        emitelem (0, proprietary)
        emitattrs (1, ProprietaryParameterDynamics)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcitationSystemUserDefined rdf:ID=\"%s\">\n%s\t</cim:ExcitationSystemUserDefined>".format (id, export_fields)
    }
}

object ExcitationSystemUserDefined
extends
    CIMParseable[ExcitationSystemUserDefined]
{
    override val fields: Array[String] = Array[String] (
        "proprietary",
        "ProprietaryParameterDynamics"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ProprietaryParameterDynamics", "ProprietaryParameterDynamics", "0..*", "0..1")
    )
    val proprietary: Fielder = parse_element (element (cls, fields(0)))
    val ProprietaryParameterDynamics: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): ExcitationSystemUserDefined =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ExcitationSystemUserDefined (
            ExcitationSystemDynamics.parse (context),
            toBoolean (mask (proprietary (), 0)),
            masks (ProprietaryParameterDynamics (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Load whose dynamic behaviour is described by a user-defined model.
 *
 * @param LoadDynamics [[ch.ninecode.model.LoadDynamics LoadDynamics]] Reference to the superclass object.
 * @param proprietary Behaviour is based on a proprietary model as opposed to a detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @param ProprietaryParameterDynamics [[ch.ninecode.model.ProprietaryParameterDynamics ProprietaryParameterDynamics]] Parameter of this proprietary user-defined model.
 * @group UserDefinedModels
 * @groupname UserDefinedModels Package UserDefinedModels
 * @groupdesc UserDefinedModels This subclause contains user-defined dynamic model classes to support the exchange of both proprietary and explicitly defined user-defined models.  
<u>Proprietary models</u> represent behaviour which, while not defined by a standard model class, is mutually understood by the sending and receiving applications based on the name passed in the .name attribute of the appropriate xxxUserDefined class.  Proprietary model parameters are passed as general attributes using as many instances of the ProprietaryParameterDynamics class as there are parameters.
<u>Explicitly defined models</u> describe dynamic behaviour in detail in terms of control blocks and their input and output signals.  Note that the classes to support explicitly defined modelling are not currently defined - it is future work intended to also be supported by the family of xxxUserDefined classes.
Both types of user-defined models use the family of xxxUserDefined classes, which allow a user-defined model to be used:
- as the model for an individual standard function block (such as a turbine-governor or power system stabilizer) in a standard interconnection model whose other function blocks could be either standard or user-defined.  For an illustration of this form of usage for a proprietary model, see the ExampleFunctionBlockProprietaryModel diagram in subclause 5.5.
- as the complete representation of a dynamic behaviour model (for an entire synchronous machine, for example) where standard function blocks and standard interconnections are not used at all. For an illustration of this form of usage for a proprietary model, see the ExampleCompleteProprietaryModel diagram in subclause 5.5.
 */
final case class LoadUserDefined
(
    LoadDynamics: LoadDynamics = null,
    proprietary: Boolean = false,
    ProprietaryParameterDynamics: List[String] = null
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
    override def sup: LoadDynamics = LoadDynamics

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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = LoadUserDefined.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (LoadUserDefined.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (LoadUserDefined.fields (position), x))
        emitelem (0, proprietary)
        emitattrs (1, ProprietaryParameterDynamics)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:LoadUserDefined rdf:ID=\"%s\">\n%s\t</cim:LoadUserDefined>".format (id, export_fields)
    }
}

object LoadUserDefined
extends
    CIMParseable[LoadUserDefined]
{
    override val fields: Array[String] = Array[String] (
        "proprietary",
        "ProprietaryParameterDynamics"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ProprietaryParameterDynamics", "ProprietaryParameterDynamics", "0..*", "0..1")
    )
    val proprietary: Fielder = parse_element (element (cls, fields(0)))
    val ProprietaryParameterDynamics: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): LoadUserDefined =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = LoadUserDefined (
            LoadDynamics.parse (context),
            toBoolean (mask (proprietary (), 0)),
            masks (ProprietaryParameterDynamics (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Mechanical load function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 *
 * @param MechanicalLoadDynamics [[ch.ninecode.model.MechanicalLoadDynamics MechanicalLoadDynamics]] Reference to the superclass object.
 * @param proprietary Behaviour is based on a proprietary model as opposed to a detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @param ProprietaryParameterDynamics [[ch.ninecode.model.ProprietaryParameterDynamics ProprietaryParameterDynamics]] Parameter of this proprietary user-defined model.
 * @group UserDefinedModels
 * @groupname UserDefinedModels Package UserDefinedModels
 * @groupdesc UserDefinedModels This subclause contains user-defined dynamic model classes to support the exchange of both proprietary and explicitly defined user-defined models.  
<u>Proprietary models</u> represent behaviour which, while not defined by a standard model class, is mutually understood by the sending and receiving applications based on the name passed in the .name attribute of the appropriate xxxUserDefined class.  Proprietary model parameters are passed as general attributes using as many instances of the ProprietaryParameterDynamics class as there are parameters.
<u>Explicitly defined models</u> describe dynamic behaviour in detail in terms of control blocks and their input and output signals.  Note that the classes to support explicitly defined modelling are not currently defined - it is future work intended to also be supported by the family of xxxUserDefined classes.
Both types of user-defined models use the family of xxxUserDefined classes, which allow a user-defined model to be used:
- as the model for an individual standard function block (such as a turbine-governor or power system stabilizer) in a standard interconnection model whose other function blocks could be either standard or user-defined.  For an illustration of this form of usage for a proprietary model, see the ExampleFunctionBlockProprietaryModel diagram in subclause 5.5.
- as the complete representation of a dynamic behaviour model (for an entire synchronous machine, for example) where standard function blocks and standard interconnections are not used at all. For an illustration of this form of usage for a proprietary model, see the ExampleCompleteProprietaryModel diagram in subclause 5.5.
 */
final case class MechanicalLoadUserDefined
(
    MechanicalLoadDynamics: MechanicalLoadDynamics = null,
    proprietary: Boolean = false,
    ProprietaryParameterDynamics: List[String] = null
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
    override def sup: MechanicalLoadDynamics = MechanicalLoadDynamics

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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MechanicalLoadUserDefined.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MechanicalLoadUserDefined.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MechanicalLoadUserDefined.fields (position), x))
        emitelem (0, proprietary)
        emitattrs (1, ProprietaryParameterDynamics)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MechanicalLoadUserDefined rdf:ID=\"%s\">\n%s\t</cim:MechanicalLoadUserDefined>".format (id, export_fields)
    }
}

object MechanicalLoadUserDefined
extends
    CIMParseable[MechanicalLoadUserDefined]
{
    override val fields: Array[String] = Array[String] (
        "proprietary",
        "ProprietaryParameterDynamics"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ProprietaryParameterDynamics", "ProprietaryParameterDynamics", "0..*", "0..1")
    )
    val proprietary: Fielder = parse_element (element (cls, fields(0)))
    val ProprietaryParameterDynamics: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): MechanicalLoadUserDefined =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MechanicalLoadUserDefined (
            MechanicalLoadDynamics.parse (context),
            toBoolean (mask (proprietary (), 0)),
            masks (ProprietaryParameterDynamics (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Overexcitation limiter system function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 *
 * @param OverexcitationLimiterDynamics [[ch.ninecode.model.OverexcitationLimiterDynamics OverexcitationLimiterDynamics]] Reference to the superclass object.
 * @param proprietary Behaviour is based on a proprietary model as opposed to a detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @param ProprietaryParameterDynamics [[ch.ninecode.model.ProprietaryParameterDynamics ProprietaryParameterDynamics]] Parameter of this proprietary user-defined model.
 * @group UserDefinedModels
 * @groupname UserDefinedModels Package UserDefinedModels
 * @groupdesc UserDefinedModels This subclause contains user-defined dynamic model classes to support the exchange of both proprietary and explicitly defined user-defined models.  
<u>Proprietary models</u> represent behaviour which, while not defined by a standard model class, is mutually understood by the sending and receiving applications based on the name passed in the .name attribute of the appropriate xxxUserDefined class.  Proprietary model parameters are passed as general attributes using as many instances of the ProprietaryParameterDynamics class as there are parameters.
<u>Explicitly defined models</u> describe dynamic behaviour in detail in terms of control blocks and their input and output signals.  Note that the classes to support explicitly defined modelling are not currently defined - it is future work intended to also be supported by the family of xxxUserDefined classes.
Both types of user-defined models use the family of xxxUserDefined classes, which allow a user-defined model to be used:
- as the model for an individual standard function block (such as a turbine-governor or power system stabilizer) in a standard interconnection model whose other function blocks could be either standard or user-defined.  For an illustration of this form of usage for a proprietary model, see the ExampleFunctionBlockProprietaryModel diagram in subclause 5.5.
- as the complete representation of a dynamic behaviour model (for an entire synchronous machine, for example) where standard function blocks and standard interconnections are not used at all. For an illustration of this form of usage for a proprietary model, see the ExampleCompleteProprietaryModel diagram in subclause 5.5.
 */
final case class OverexcitationLimiterUserDefined
(
    OverexcitationLimiterDynamics: OverexcitationLimiterDynamics = null,
    proprietary: Boolean = false,
    ProprietaryParameterDynamics: List[String] = null
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
    override def sup: OverexcitationLimiterDynamics = OverexcitationLimiterDynamics

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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = OverexcitationLimiterUserDefined.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (OverexcitationLimiterUserDefined.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (OverexcitationLimiterUserDefined.fields (position), x))
        emitelem (0, proprietary)
        emitattrs (1, ProprietaryParameterDynamics)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OverexcitationLimiterUserDefined rdf:ID=\"%s\">\n%s\t</cim:OverexcitationLimiterUserDefined>".format (id, export_fields)
    }
}

object OverexcitationLimiterUserDefined
extends
    CIMParseable[OverexcitationLimiterUserDefined]
{
    override val fields: Array[String] = Array[String] (
        "proprietary",
        "ProprietaryParameterDynamics"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ProprietaryParameterDynamics", "ProprietaryParameterDynamics", "0..*", "0..1")
    )
    val proprietary: Fielder = parse_element (element (cls, fields(0)))
    val ProprietaryParameterDynamics: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): OverexcitationLimiterUserDefined =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OverexcitationLimiterUserDefined (
            OverexcitationLimiterDynamics.parse (context),
            toBoolean (mask (proprietary (), 0)),
            masks (ProprietaryParameterDynamics (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Power factor or VAr controller type 1 function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 *
 * @param PFVArControllerType1Dynamics [[ch.ninecode.model.PFVArControllerType1Dynamics PFVArControllerType1Dynamics]] Reference to the superclass object.
 * @param proprietary Behaviour is based on a proprietary model as opposed to a detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @param ProprietaryParameterDynamics [[ch.ninecode.model.ProprietaryParameterDynamics ProprietaryParameterDynamics]] Parameter of this proprietary user-defined model.
 * @group UserDefinedModels
 * @groupname UserDefinedModels Package UserDefinedModels
 * @groupdesc UserDefinedModels This subclause contains user-defined dynamic model classes to support the exchange of both proprietary and explicitly defined user-defined models.  
<u>Proprietary models</u> represent behaviour which, while not defined by a standard model class, is mutually understood by the sending and receiving applications based on the name passed in the .name attribute of the appropriate xxxUserDefined class.  Proprietary model parameters are passed as general attributes using as many instances of the ProprietaryParameterDynamics class as there are parameters.
<u>Explicitly defined models</u> describe dynamic behaviour in detail in terms of control blocks and their input and output signals.  Note that the classes to support explicitly defined modelling are not currently defined - it is future work intended to also be supported by the family of xxxUserDefined classes.
Both types of user-defined models use the family of xxxUserDefined classes, which allow a user-defined model to be used:
- as the model for an individual standard function block (such as a turbine-governor or power system stabilizer) in a standard interconnection model whose other function blocks could be either standard or user-defined.  For an illustration of this form of usage for a proprietary model, see the ExampleFunctionBlockProprietaryModel diagram in subclause 5.5.
- as the complete representation of a dynamic behaviour model (for an entire synchronous machine, for example) where standard function blocks and standard interconnections are not used at all. For an illustration of this form of usage for a proprietary model, see the ExampleCompleteProprietaryModel diagram in subclause 5.5.
 */
final case class PFVArControllerType1UserDefined
(
    PFVArControllerType1Dynamics: PFVArControllerType1Dynamics = null,
    proprietary: Boolean = false,
    ProprietaryParameterDynamics: List[String] = null
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
    override def sup: PFVArControllerType1Dynamics = PFVArControllerType1Dynamics

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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PFVArControllerType1UserDefined.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PFVArControllerType1UserDefined.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (PFVArControllerType1UserDefined.fields (position), x))
        emitelem (0, proprietary)
        emitattrs (1, ProprietaryParameterDynamics)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PFVArControllerType1UserDefined rdf:ID=\"%s\">\n%s\t</cim:PFVArControllerType1UserDefined>".format (id, export_fields)
    }
}

object PFVArControllerType1UserDefined
extends
    CIMParseable[PFVArControllerType1UserDefined]
{
    override val fields: Array[String] = Array[String] (
        "proprietary",
        "ProprietaryParameterDynamics"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ProprietaryParameterDynamics", "ProprietaryParameterDynamics", "0..*", "0..1")
    )
    val proprietary: Fielder = parse_element (element (cls, fields(0)))
    val ProprietaryParameterDynamics: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): PFVArControllerType1UserDefined =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PFVArControllerType1UserDefined (
            PFVArControllerType1Dynamics.parse (context),
            toBoolean (mask (proprietary (), 0)),
            masks (ProprietaryParameterDynamics (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Power factor or VAr controller type 2 function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 *
 * @param PFVArControllerType2Dynamics [[ch.ninecode.model.PFVArControllerType2Dynamics PFVArControllerType2Dynamics]] Reference to the superclass object.
 * @param proprietary Behaviour is based on a proprietary model as opposed to a detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @param ProprietaryParameterDynamics [[ch.ninecode.model.ProprietaryParameterDynamics ProprietaryParameterDynamics]] Parameter of this proprietary user-defined model.
 * @group UserDefinedModels
 * @groupname UserDefinedModels Package UserDefinedModels
 * @groupdesc UserDefinedModels This subclause contains user-defined dynamic model classes to support the exchange of both proprietary and explicitly defined user-defined models.  
<u>Proprietary models</u> represent behaviour which, while not defined by a standard model class, is mutually understood by the sending and receiving applications based on the name passed in the .name attribute of the appropriate xxxUserDefined class.  Proprietary model parameters are passed as general attributes using as many instances of the ProprietaryParameterDynamics class as there are parameters.
<u>Explicitly defined models</u> describe dynamic behaviour in detail in terms of control blocks and their input and output signals.  Note that the classes to support explicitly defined modelling are not currently defined - it is future work intended to also be supported by the family of xxxUserDefined classes.
Both types of user-defined models use the family of xxxUserDefined classes, which allow a user-defined model to be used:
- as the model for an individual standard function block (such as a turbine-governor or power system stabilizer) in a standard interconnection model whose other function blocks could be either standard or user-defined.  For an illustration of this form of usage for a proprietary model, see the ExampleFunctionBlockProprietaryModel diagram in subclause 5.5.
- as the complete representation of a dynamic behaviour model (for an entire synchronous machine, for example) where standard function blocks and standard interconnections are not used at all. For an illustration of this form of usage for a proprietary model, see the ExampleCompleteProprietaryModel diagram in subclause 5.5.
 */
final case class PFVArControllerType2UserDefined
(
    PFVArControllerType2Dynamics: PFVArControllerType2Dynamics = null,
    proprietary: Boolean = false,
    ProprietaryParameterDynamics: List[String] = null
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
    override def sup: PFVArControllerType2Dynamics = PFVArControllerType2Dynamics

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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PFVArControllerType2UserDefined.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PFVArControllerType2UserDefined.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (PFVArControllerType2UserDefined.fields (position), x))
        emitelem (0, proprietary)
        emitattrs (1, ProprietaryParameterDynamics)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PFVArControllerType2UserDefined rdf:ID=\"%s\">\n%s\t</cim:PFVArControllerType2UserDefined>".format (id, export_fields)
    }
}

object PFVArControllerType2UserDefined
extends
    CIMParseable[PFVArControllerType2UserDefined]
{
    override val fields: Array[String] = Array[String] (
        "proprietary",
        "ProprietaryParameterDynamics"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ProprietaryParameterDynamics", "ProprietaryParameterDynamics", "0..*", "0..1")
    )
    val proprietary: Fielder = parse_element (element (cls, fields(0)))
    val ProprietaryParameterDynamics: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): PFVArControllerType2UserDefined =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PFVArControllerType2UserDefined (
            PFVArControllerType2Dynamics.parse (context),
            toBoolean (mask (proprietary (), 0)),
            masks (ProprietaryParameterDynamics (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * <font color="#0f0f0f">Power system stabilizer</font> function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 *
 * @param PowerSystemStabilizerDynamics [[ch.ninecode.model.PowerSystemStabilizerDynamics PowerSystemStabilizerDynamics]] Reference to the superclass object.
 * @param proprietary Behaviour is based on a proprietary model as opposed to a detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @param ProprietaryParameterDynamics [[ch.ninecode.model.ProprietaryParameterDynamics ProprietaryParameterDynamics]] Parameter of this proprietary user-defined model.
 * @group UserDefinedModels
 * @groupname UserDefinedModels Package UserDefinedModels
 * @groupdesc UserDefinedModels This subclause contains user-defined dynamic model classes to support the exchange of both proprietary and explicitly defined user-defined models.  
<u>Proprietary models</u> represent behaviour which, while not defined by a standard model class, is mutually understood by the sending and receiving applications based on the name passed in the .name attribute of the appropriate xxxUserDefined class.  Proprietary model parameters are passed as general attributes using as many instances of the ProprietaryParameterDynamics class as there are parameters.
<u>Explicitly defined models</u> describe dynamic behaviour in detail in terms of control blocks and their input and output signals.  Note that the classes to support explicitly defined modelling are not currently defined - it is future work intended to also be supported by the family of xxxUserDefined classes.
Both types of user-defined models use the family of xxxUserDefined classes, which allow a user-defined model to be used:
- as the model for an individual standard function block (such as a turbine-governor or power system stabilizer) in a standard interconnection model whose other function blocks could be either standard or user-defined.  For an illustration of this form of usage for a proprietary model, see the ExampleFunctionBlockProprietaryModel diagram in subclause 5.5.
- as the complete representation of a dynamic behaviour model (for an entire synchronous machine, for example) where standard function blocks and standard interconnections are not used at all. For an illustration of this form of usage for a proprietary model, see the ExampleCompleteProprietaryModel diagram in subclause 5.5.
 */
final case class PowerSystemStabilizerUserDefined
(
    PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = null,
    proprietary: Boolean = false,
    ProprietaryParameterDynamics: List[String] = null
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
    override def sup: PowerSystemStabilizerDynamics = PowerSystemStabilizerDynamics

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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PowerSystemStabilizerUserDefined.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PowerSystemStabilizerUserDefined.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (PowerSystemStabilizerUserDefined.fields (position), x))
        emitelem (0, proprietary)
        emitattrs (1, ProprietaryParameterDynamics)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PowerSystemStabilizerUserDefined rdf:ID=\"%s\">\n%s\t</cim:PowerSystemStabilizerUserDefined>".format (id, export_fields)
    }
}

object PowerSystemStabilizerUserDefined
extends
    CIMParseable[PowerSystemStabilizerUserDefined]
{
    override val fields: Array[String] = Array[String] (
        "proprietary",
        "ProprietaryParameterDynamics"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ProprietaryParameterDynamics", "ProprietaryParameterDynamics", "0..*", "0..1")
    )
    val proprietary: Fielder = parse_element (element (cls, fields(0)))
    val ProprietaryParameterDynamics: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): PowerSystemStabilizerUserDefined =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PowerSystemStabilizerUserDefined (
            PowerSystemStabilizerDynamics.parse (context),
            toBoolean (mask (proprietary (), 0)),
            masks (ProprietaryParameterDynamics (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Supports definition of one or more parameters of several different datatypes for use by proprietary user-defined models.
 *
 * This class does not inherit from IdentifiedObject since it is not intended that a single instance of it be referenced by more than one proprietary user-defined model instance.
 *
 * @param Element Reference to the superclass object.
 * @param booleanParameterValue Boolean parameter value.
 *        If this attribute is populated, integerParameterValue and floatParameterValue will not be.
 * @param floatParameterValue Floating point parameter value.
 *        If this attribute is populated, booleanParameterValue and integerParameterValue will not be.
 * @param integerParameterValue Integer parameter value.
 *        If this attribute is populated, booleanParameterValue and floatParameterValue will not be.
 * @param parameterNumber Sequence number of the parameter among the set of parameters associated with the related proprietary user-defined model.
 * @param AsynchronousMachineUserDefined [[ch.ninecode.model.AsynchronousMachineUserDefined AsynchronousMachineUserDefined]] Proprietary user-defined model with which this parameter is associated.
 * @param CSCUserDefined [[ch.ninecode.model.CSCUserDefined CSCUserDefined]] Proprietary user-defined model with which this parameter is associated.
 * @param DiscontinuousExcitationControlUserDefined [[ch.ninecode.model.DiscontinuousExcitationControlUserDefined DiscontinuousExcitationControlUserDefined]] Proprietary user-defined model with which this parameter is associated.
 * @param ExcitationSystemUserDefined [[ch.ninecode.model.ExcitationSystemUserDefined ExcitationSystemUserDefined]] Proprietary user-defined model with which this parameter is associated.
 * @param LoadUserDefined [[ch.ninecode.model.LoadUserDefined LoadUserDefined]] Proprietary user-defined model with which this parameter is associated.
 * @param MechanicalLoadUserDefined [[ch.ninecode.model.MechanicalLoadUserDefined MechanicalLoadUserDefined]] Proprietary user-defined model with which this parameter is associated.
 * @param OverexcitationLimiterUserDefined [[ch.ninecode.model.OverexcitationLimiterUserDefined OverexcitationLimiterUserDefined]] Proprietary user-defined model with which this parameter is associated.
 * @param PFVArControllerType1UserDefined [[ch.ninecode.model.PFVArControllerType1UserDefined PFVArControllerType1UserDefined]] Proprietary user-defined model with which this parameter is associated.
 * @param PFVArControllerType2UserDefined [[ch.ninecode.model.PFVArControllerType2UserDefined PFVArControllerType2UserDefined]] Proprietary user-defined model with which this parameter is associated.
 * @param PowerSystemStabilizerUserDefined [[ch.ninecode.model.PowerSystemStabilizerUserDefined PowerSystemStabilizerUserDefined]] Proprietary user-defined model with which this parameter is associated.
 * @param SVCUserDefined [[ch.ninecode.model.SVCUserDefined SVCUserDefined]] Proprietary user-defined model with which this parameter is associated.
 * @param SynchronousMachineUserDefined [[ch.ninecode.model.SynchronousMachineUserDefined SynchronousMachineUserDefined]] Proprietary user-defined model with which this parameter is associated.
 * @param TurbineGovernorUserDefined [[ch.ninecode.model.TurbineGovernorUserDefined TurbineGovernorUserDefined]] Proprietary user-defined model with which this parameter is associated.
 * @param TurbineLoadControllerUserDefined [[ch.ninecode.model.TurbineLoadControllerUserDefined TurbineLoadControllerUserDefined]] Proprietary user-defined model with which this parameter is associated.
 * @param UnderexcitationLimiterUserDefined [[ch.ninecode.model.UnderexcitationLimiterUserDefined UnderexcitationLimiterUserDefined]] Proprietary user-defined model with which this parameter is associated.
 * @param VSCUserDefined [[ch.ninecode.model.VSCUserDefined VSCUserDefined]] Proprietary user-defined model with which this parameter is associated.
 * @param VoltageAdjusterUserDefined [[ch.ninecode.model.VoltageAdjusterUserDefined VoltageAdjusterUserDefined]] Proprietary user-defined model with which this parameter is associated.
 * @param VoltageCompensatorUserDefined [[ch.ninecode.model.VoltageCompensatorUserDefined VoltageCompensatorUserDefined]] Proprietary user-defined model with which this parameter is associated.
 * @param WindPlantUserDefined [[ch.ninecode.model.WindPlantUserDefined WindPlantUserDefined]] Proprietary user-defined model with which this parameter is associated.
 * @param WindType1or2UserDefined [[ch.ninecode.model.WindType1or2UserDefined WindType1or2UserDefined]] Proprietary user-defined model with which this parameter is associated.
 * @param WindType3or4UserDefined [[ch.ninecode.model.WindType3or4UserDefined WindType3or4UserDefined]] Proprietary user-defined model with which this parameter is associated.
 * @group UserDefinedModels
 * @groupname UserDefinedModels Package UserDefinedModels
 * @groupdesc UserDefinedModels This subclause contains user-defined dynamic model classes to support the exchange of both proprietary and explicitly defined user-defined models.  
<u>Proprietary models</u> represent behaviour which, while not defined by a standard model class, is mutually understood by the sending and receiving applications based on the name passed in the .name attribute of the appropriate xxxUserDefined class.  Proprietary model parameters are passed as general attributes using as many instances of the ProprietaryParameterDynamics class as there are parameters.
<u>Explicitly defined models</u> describe dynamic behaviour in detail in terms of control blocks and their input and output signals.  Note that the classes to support explicitly defined modelling are not currently defined - it is future work intended to also be supported by the family of xxxUserDefined classes.
Both types of user-defined models use the family of xxxUserDefined classes, which allow a user-defined model to be used:
- as the model for an individual standard function block (such as a turbine-governor or power system stabilizer) in a standard interconnection model whose other function blocks could be either standard or user-defined.  For an illustration of this form of usage for a proprietary model, see the ExampleFunctionBlockProprietaryModel diagram in subclause 5.5.
- as the complete representation of a dynamic behaviour model (for an entire synchronous machine, for example) where standard function blocks and standard interconnections are not used at all. For an illustration of this form of usage for a proprietary model, see the ExampleCompleteProprietaryModel diagram in subclause 5.5.
 */
final case class ProprietaryParameterDynamics
(
    Element: BasicElement = null,
    booleanParameterValue: Boolean = false,
    floatParameterValue: Double = 0.0,
    integerParameterValue: Int = 0,
    parameterNumber: Int = 0,
    AsynchronousMachineUserDefined: String = null,
    CSCUserDefined: String = null,
    DiscontinuousExcitationControlUserDefined: String = null,
    ExcitationSystemUserDefined: String = null,
    LoadUserDefined: String = null,
    MechanicalLoadUserDefined: String = null,
    OverexcitationLimiterUserDefined: String = null,
    PFVArControllerType1UserDefined: String = null,
    PFVArControllerType2UserDefined: String = null,
    PowerSystemStabilizerUserDefined: String = null,
    SVCUserDefined: String = null,
    SynchronousMachineUserDefined: String = null,
    TurbineGovernorUserDefined: String = null,
    TurbineLoadControllerUserDefined: String = null,
    UnderexcitationLimiterUserDefined: String = null,
    VSCUserDefined: String = null,
    VoltageAdjusterUserDefined: String = null,
    VoltageCompensatorUserDefined: String = null,
    WindPlantUserDefined: String = null,
    WindType1or2UserDefined: String = null,
    WindType3or4UserDefined: String = null
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
    override def sup: Element = Element

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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ProprietaryParameterDynamics.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ProprietaryParameterDynamics.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ProprietaryParameterDynamics.fields (position), value)
        emitelem (0, booleanParameterValue)
        emitelem (1, floatParameterValue)
        emitelem (2, integerParameterValue)
        emitelem (3, parameterNumber)
        emitattr (4, AsynchronousMachineUserDefined)
        emitattr (5, CSCUserDefined)
        emitattr (6, DiscontinuousExcitationControlUserDefined)
        emitattr (7, ExcitationSystemUserDefined)
        emitattr (8, LoadUserDefined)
        emitattr (9, MechanicalLoadUserDefined)
        emitattr (10, OverexcitationLimiterUserDefined)
        emitattr (11, PFVArControllerType1UserDefined)
        emitattr (12, PFVArControllerType2UserDefined)
        emitattr (13, PowerSystemStabilizerUserDefined)
        emitattr (14, SVCUserDefined)
        emitattr (15, SynchronousMachineUserDefined)
        emitattr (16, TurbineGovernorUserDefined)
        emitattr (17, TurbineLoadControllerUserDefined)
        emitattr (18, UnderexcitationLimiterUserDefined)
        emitattr (19, VSCUserDefined)
        emitattr (20, VoltageAdjusterUserDefined)
        emitattr (21, VoltageCompensatorUserDefined)
        emitattr (22, WindPlantUserDefined)
        emitattr (23, WindType1or2UserDefined)
        emitattr (24, WindType3or4UserDefined)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ProprietaryParameterDynamics rdf:ID=\"%s\">\n%s\t</cim:ProprietaryParameterDynamics>".format (id, export_fields)
    }
}

object ProprietaryParameterDynamics
extends
    CIMParseable[ProprietaryParameterDynamics]
{
    override val fields: Array[String] = Array[String] (
        "booleanParameterValue",
        "floatParameterValue",
        "integerParameterValue",
        "parameterNumber",
        "AsynchronousMachineUserDefined",
        "CSCUserDefined",
        "DiscontinuousExcitationControlUserDefined",
        "ExcitationSystemUserDefined",
        "LoadUserDefined",
        "MechanicalLoadUserDefined",
        "OverexcitationLimiterUserDefined",
        "PFVArControllerType1UserDefined",
        "PFVArControllerType2UserDefined",
        "PowerSystemStabilizerUserDefined",
        "SVCUserDefined",
        "SynchronousMachineUserDefined",
        "TurbineGovernorUserDefined",
        "TurbineLoadControllerUserDefined",
        "UnderexcitationLimiterUserDefined",
        "VSCUserDefined",
        "VoltageAdjusterUserDefined",
        "VoltageCompensatorUserDefined",
        "WindPlantUserDefined",
        "WindType1or2UserDefined",
        "WindType3or4UserDefined"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AsynchronousMachineUserDefined", "AsynchronousMachineUserDefined", "0..1", "0..*"),
        CIMRelationship ("CSCUserDefined", "CSCUserDefined", "0..1", "0..*"),
        CIMRelationship ("DiscontinuousExcitationControlUserDefined", "DiscontinuousExcitationControlUserDefined", "0..1", "0..*"),
        CIMRelationship ("ExcitationSystemUserDefined", "ExcitationSystemUserDefined", "0..1", "0..*"),
        CIMRelationship ("LoadUserDefined", "LoadUserDefined", "0..1", "0..*"),
        CIMRelationship ("MechanicalLoadUserDefined", "MechanicalLoadUserDefined", "0..1", "0..*"),
        CIMRelationship ("OverexcitationLimiterUserDefined", "OverexcitationLimiterUserDefined", "0..1", "0..*"),
        CIMRelationship ("PFVArControllerType1UserDefined", "PFVArControllerType1UserDefined", "0..1", "0..*"),
        CIMRelationship ("PFVArControllerType2UserDefined", "PFVArControllerType2UserDefined", "0..1", "0..*"),
        CIMRelationship ("PowerSystemStabilizerUserDefined", "PowerSystemStabilizerUserDefined", "0..1", "0..*"),
        CIMRelationship ("SVCUserDefined", "SVCUserDefined", "0..1", "0..*"),
        CIMRelationship ("SynchronousMachineUserDefined", "SynchronousMachineUserDefined", "0..1", "0..*"),
        CIMRelationship ("TurbineGovernorUserDefined", "TurbineGovernorUserDefined", "0..1", "0..*"),
        CIMRelationship ("TurbineLoadControllerUserDefined", "TurbineLoadControllerUserDefined", "0..1", "0..*"),
        CIMRelationship ("UnderexcitationLimiterUserDefined", "UnderexcitationLimiterUserDefined", "0..1", "0..*"),
        CIMRelationship ("VSCUserDefined", "VSCUserDefined", "0..1", "0..*"),
        CIMRelationship ("VoltageAdjusterUserDefined", "VoltageAdjusterUserDefined", "0..1", "0..*"),
        CIMRelationship ("VoltageCompensatorUserDefined", "VoltageCompensatorUserDefined", "0..1", "0..*"),
        CIMRelationship ("WindPlantUserDefined", "WindPlantUserDefined", "0..1", "0..*"),
        CIMRelationship ("WindType1or2UserDefined", "WindType1or2UserDefined", "0..1", "0..*"),
        CIMRelationship ("WindType3or4UserDefined", "WindType3or4UserDefined", "0..1", "0..*")
    )
    val booleanParameterValue: Fielder = parse_element (element (cls, fields(0)))
    val floatParameterValue: Fielder = parse_element (element (cls, fields(1)))
    val integerParameterValue: Fielder = parse_element (element (cls, fields(2)))
    val parameterNumber: Fielder = parse_element (element (cls, fields(3)))
    val AsynchronousMachineUserDefined: Fielder = parse_attribute (attribute (cls, fields(4)))
    val CSCUserDefined: Fielder = parse_attribute (attribute (cls, fields(5)))
    val DiscontinuousExcitationControlUserDefined: Fielder = parse_attribute (attribute (cls, fields(6)))
    val ExcitationSystemUserDefined: Fielder = parse_attribute (attribute (cls, fields(7)))
    val LoadUserDefined: Fielder = parse_attribute (attribute (cls, fields(8)))
    val MechanicalLoadUserDefined: Fielder = parse_attribute (attribute (cls, fields(9)))
    val OverexcitationLimiterUserDefined: Fielder = parse_attribute (attribute (cls, fields(10)))
    val PFVArControllerType1UserDefined: Fielder = parse_attribute (attribute (cls, fields(11)))
    val PFVArControllerType2UserDefined: Fielder = parse_attribute (attribute (cls, fields(12)))
    val PowerSystemStabilizerUserDefined: Fielder = parse_attribute (attribute (cls, fields(13)))
    val SVCUserDefined: Fielder = parse_attribute (attribute (cls, fields(14)))
    val SynchronousMachineUserDefined: Fielder = parse_attribute (attribute (cls, fields(15)))
    val TurbineGovernorUserDefined: Fielder = parse_attribute (attribute (cls, fields(16)))
    val TurbineLoadControllerUserDefined: Fielder = parse_attribute (attribute (cls, fields(17)))
    val UnderexcitationLimiterUserDefined: Fielder = parse_attribute (attribute (cls, fields(18)))
    val VSCUserDefined: Fielder = parse_attribute (attribute (cls, fields(19)))
    val VoltageAdjusterUserDefined: Fielder = parse_attribute (attribute (cls, fields(20)))
    val VoltageCompensatorUserDefined: Fielder = parse_attribute (attribute (cls, fields(21)))
    val WindPlantUserDefined: Fielder = parse_attribute (attribute (cls, fields(22)))
    val WindType1or2UserDefined: Fielder = parse_attribute (attribute (cls, fields(23)))
    val WindType3or4UserDefined: Fielder = parse_attribute (attribute (cls, fields(24)))

    def parse (context: CIMContext): ProprietaryParameterDynamics =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ProprietaryParameterDynamics (
            BasicElement.parse (context),
            toBoolean (mask (booleanParameterValue (), 0)),
            toDouble (mask (floatParameterValue (), 1)),
            toInteger (mask (integerParameterValue (), 2)),
            toInteger (mask (parameterNumber (), 3)),
            mask (AsynchronousMachineUserDefined (), 4),
            mask (CSCUserDefined (), 5),
            mask (DiscontinuousExcitationControlUserDefined (), 6),
            mask (ExcitationSystemUserDefined (), 7),
            mask (LoadUserDefined (), 8),
            mask (MechanicalLoadUserDefined (), 9),
            mask (OverexcitationLimiterUserDefined (), 10),
            mask (PFVArControllerType1UserDefined (), 11),
            mask (PFVArControllerType2UserDefined (), 12),
            mask (PowerSystemStabilizerUserDefined (), 13),
            mask (SVCUserDefined (), 14),
            mask (SynchronousMachineUserDefined (), 15),
            mask (TurbineGovernorUserDefined (), 16),
            mask (TurbineLoadControllerUserDefined (), 17),
            mask (UnderexcitationLimiterUserDefined (), 18),
            mask (VSCUserDefined (), 19),
            mask (VoltageAdjusterUserDefined (), 20),
            mask (VoltageCompensatorUserDefined (), 21),
            mask (WindPlantUserDefined (), 22),
            mask (WindType1or2UserDefined (), 23),
            mask (WindType3or4UserDefined (), 24)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Static var compensator (SVC) function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 *
 * @param StaticVarCompensatorDynamics [[ch.ninecode.model.StaticVarCompensatorDynamics StaticVarCompensatorDynamics]] Reference to the superclass object.
 * @param proprietary Behaviour is based on a proprietary model as opposed to a detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @param ProprietaryParameterDynamics [[ch.ninecode.model.ProprietaryParameterDynamics ProprietaryParameterDynamics]] Parameter of this proprietary user-defined model.
 * @group UserDefinedModels
 * @groupname UserDefinedModels Package UserDefinedModels
 * @groupdesc UserDefinedModels This subclause contains user-defined dynamic model classes to support the exchange of both proprietary and explicitly defined user-defined models.  
<u>Proprietary models</u> represent behaviour which, while not defined by a standard model class, is mutually understood by the sending and receiving applications based on the name passed in the .name attribute of the appropriate xxxUserDefined class.  Proprietary model parameters are passed as general attributes using as many instances of the ProprietaryParameterDynamics class as there are parameters.
<u>Explicitly defined models</u> describe dynamic behaviour in detail in terms of control blocks and their input and output signals.  Note that the classes to support explicitly defined modelling are not currently defined - it is future work intended to also be supported by the family of xxxUserDefined classes.
Both types of user-defined models use the family of xxxUserDefined classes, which allow a user-defined model to be used:
- as the model for an individual standard function block (such as a turbine-governor or power system stabilizer) in a standard interconnection model whose other function blocks could be either standard or user-defined.  For an illustration of this form of usage for a proprietary model, see the ExampleFunctionBlockProprietaryModel diagram in subclause 5.5.
- as the complete representation of a dynamic behaviour model (for an entire synchronous machine, for example) where standard function blocks and standard interconnections are not used at all. For an illustration of this form of usage for a proprietary model, see the ExampleCompleteProprietaryModel diagram in subclause 5.5.
 */
final case class SVCUserDefined
(
    StaticVarCompensatorDynamics: StaticVarCompensatorDynamics = null,
    proprietary: Boolean = false,
    ProprietaryParameterDynamics: List[String] = null
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
    override def sup: StaticVarCompensatorDynamics = StaticVarCompensatorDynamics

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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = SVCUserDefined.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SVCUserDefined.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (SVCUserDefined.fields (position), x))
        emitelem (0, proprietary)
        emitattrs (1, ProprietaryParameterDynamics)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SVCUserDefined rdf:ID=\"%s\">\n%s\t</cim:SVCUserDefined>".format (id, export_fields)
    }
}

object SVCUserDefined
extends
    CIMParseable[SVCUserDefined]
{
    override val fields: Array[String] = Array[String] (
        "proprietary",
        "ProprietaryParameterDynamics"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ProprietaryParameterDynamics", "ProprietaryParameterDynamics", "0..*", "0..1")
    )
    val proprietary: Fielder = parse_element (element (cls, fields(0)))
    val ProprietaryParameterDynamics: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): SVCUserDefined =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SVCUserDefined (
            StaticVarCompensatorDynamics.parse (context),
            toBoolean (mask (proprietary (), 0)),
            masks (ProprietaryParameterDynamics (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Synchronous machine whose dynamic behaviour is described by a user-defined model.
 *
 * @param SynchronousMachineDynamics [[ch.ninecode.model.SynchronousMachineDynamics SynchronousMachineDynamics]] Reference to the superclass object.
 * @param proprietary Behaviour is based on a proprietary model as opposed to a detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @param ProprietaryParameterDynamics [[ch.ninecode.model.ProprietaryParameterDynamics ProprietaryParameterDynamics]] Parameter of this proprietary user-defined model.
 * @group UserDefinedModels
 * @groupname UserDefinedModels Package UserDefinedModels
 * @groupdesc UserDefinedModels This subclause contains user-defined dynamic model classes to support the exchange of both proprietary and explicitly defined user-defined models.  
<u>Proprietary models</u> represent behaviour which, while not defined by a standard model class, is mutually understood by the sending and receiving applications based on the name passed in the .name attribute of the appropriate xxxUserDefined class.  Proprietary model parameters are passed as general attributes using as many instances of the ProprietaryParameterDynamics class as there are parameters.
<u>Explicitly defined models</u> describe dynamic behaviour in detail in terms of control blocks and their input and output signals.  Note that the classes to support explicitly defined modelling are not currently defined - it is future work intended to also be supported by the family of xxxUserDefined classes.
Both types of user-defined models use the family of xxxUserDefined classes, which allow a user-defined model to be used:
- as the model for an individual standard function block (such as a turbine-governor or power system stabilizer) in a standard interconnection model whose other function blocks could be either standard or user-defined.  For an illustration of this form of usage for a proprietary model, see the ExampleFunctionBlockProprietaryModel diagram in subclause 5.5.
- as the complete representation of a dynamic behaviour model (for an entire synchronous machine, for example) where standard function blocks and standard interconnections are not used at all. For an illustration of this form of usage for a proprietary model, see the ExampleCompleteProprietaryModel diagram in subclause 5.5.
 */
final case class SynchronousMachineUserDefined
(
    SynchronousMachineDynamics: SynchronousMachineDynamics = null,
    proprietary: Boolean = false,
    ProprietaryParameterDynamics: List[String] = null
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
    override def sup: SynchronousMachineDynamics = SynchronousMachineDynamics

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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = SynchronousMachineUserDefined.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SynchronousMachineUserDefined.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (SynchronousMachineUserDefined.fields (position), x))
        emitelem (0, proprietary)
        emitattrs (1, ProprietaryParameterDynamics)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SynchronousMachineUserDefined rdf:ID=\"%s\">\n%s\t</cim:SynchronousMachineUserDefined>".format (id, export_fields)
    }
}

object SynchronousMachineUserDefined
extends
    CIMParseable[SynchronousMachineUserDefined]
{
    override val fields: Array[String] = Array[String] (
        "proprietary",
        "ProprietaryParameterDynamics"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ProprietaryParameterDynamics", "ProprietaryParameterDynamics", "0..*", "0..1")
    )
    val proprietary: Fielder = parse_element (element (cls, fields(0)))
    val ProprietaryParameterDynamics: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): SynchronousMachineUserDefined =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SynchronousMachineUserDefined (
            SynchronousMachineDynamics.parse (context),
            toBoolean (mask (proprietary (), 0)),
            masks (ProprietaryParameterDynamics (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Turbine-governor function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 *
 * @param TurbineGovernorDynamics [[ch.ninecode.model.TurbineGovernorDynamics TurbineGovernorDynamics]] Reference to the superclass object.
 * @param proprietary Behaviour is based on a proprietary model as opposed to a detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @param ProprietaryParameterDynamics [[ch.ninecode.model.ProprietaryParameterDynamics ProprietaryParameterDynamics]] Parameter of this proprietary user-defined model.
 * @group UserDefinedModels
 * @groupname UserDefinedModels Package UserDefinedModels
 * @groupdesc UserDefinedModels This subclause contains user-defined dynamic model classes to support the exchange of both proprietary and explicitly defined user-defined models.  
<u>Proprietary models</u> represent behaviour which, while not defined by a standard model class, is mutually understood by the sending and receiving applications based on the name passed in the .name attribute of the appropriate xxxUserDefined class.  Proprietary model parameters are passed as general attributes using as many instances of the ProprietaryParameterDynamics class as there are parameters.
<u>Explicitly defined models</u> describe dynamic behaviour in detail in terms of control blocks and their input and output signals.  Note that the classes to support explicitly defined modelling are not currently defined - it is future work intended to also be supported by the family of xxxUserDefined classes.
Both types of user-defined models use the family of xxxUserDefined classes, which allow a user-defined model to be used:
- as the model for an individual standard function block (such as a turbine-governor or power system stabilizer) in a standard interconnection model whose other function blocks could be either standard or user-defined.  For an illustration of this form of usage for a proprietary model, see the ExampleFunctionBlockProprietaryModel diagram in subclause 5.5.
- as the complete representation of a dynamic behaviour model (for an entire synchronous machine, for example) where standard function blocks and standard interconnections are not used at all. For an illustration of this form of usage for a proprietary model, see the ExampleCompleteProprietaryModel diagram in subclause 5.5.
 */
final case class TurbineGovernorUserDefined
(
    TurbineGovernorDynamics: TurbineGovernorDynamics = null,
    proprietary: Boolean = false,
    ProprietaryParameterDynamics: List[String] = null
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
    override def sup: TurbineGovernorDynamics = TurbineGovernorDynamics

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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TurbineGovernorUserDefined.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TurbineGovernorUserDefined.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (TurbineGovernorUserDefined.fields (position), x))
        emitelem (0, proprietary)
        emitattrs (1, ProprietaryParameterDynamics)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TurbineGovernorUserDefined rdf:ID=\"%s\">\n%s\t</cim:TurbineGovernorUserDefined>".format (id, export_fields)
    }
}

object TurbineGovernorUserDefined
extends
    CIMParseable[TurbineGovernorUserDefined]
{
    override val fields: Array[String] = Array[String] (
        "proprietary",
        "ProprietaryParameterDynamics"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ProprietaryParameterDynamics", "ProprietaryParameterDynamics", "0..*", "0..1")
    )
    val proprietary: Fielder = parse_element (element (cls, fields(0)))
    val ProprietaryParameterDynamics: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): TurbineGovernorUserDefined =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TurbineGovernorUserDefined (
            TurbineGovernorDynamics.parse (context),
            toBoolean (mask (proprietary (), 0)),
            masks (ProprietaryParameterDynamics (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Turbine load controller function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 *
 * @param TurbineLoadControllerDynamics [[ch.ninecode.model.TurbineLoadControllerDynamics TurbineLoadControllerDynamics]] Reference to the superclass object.
 * @param proprietary Behaviour is based on a proprietary model as opposed to a detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @param ProprietaryParameterDynamics [[ch.ninecode.model.ProprietaryParameterDynamics ProprietaryParameterDynamics]] Parameter of this proprietary user-defined model.
 * @group UserDefinedModels
 * @groupname UserDefinedModels Package UserDefinedModels
 * @groupdesc UserDefinedModels This subclause contains user-defined dynamic model classes to support the exchange of both proprietary and explicitly defined user-defined models.  
<u>Proprietary models</u> represent behaviour which, while not defined by a standard model class, is mutually understood by the sending and receiving applications based on the name passed in the .name attribute of the appropriate xxxUserDefined class.  Proprietary model parameters are passed as general attributes using as many instances of the ProprietaryParameterDynamics class as there are parameters.
<u>Explicitly defined models</u> describe dynamic behaviour in detail in terms of control blocks and their input and output signals.  Note that the classes to support explicitly defined modelling are not currently defined - it is future work intended to also be supported by the family of xxxUserDefined classes.
Both types of user-defined models use the family of xxxUserDefined classes, which allow a user-defined model to be used:
- as the model for an individual standard function block (such as a turbine-governor or power system stabilizer) in a standard interconnection model whose other function blocks could be either standard or user-defined.  For an illustration of this form of usage for a proprietary model, see the ExampleFunctionBlockProprietaryModel diagram in subclause 5.5.
- as the complete representation of a dynamic behaviour model (for an entire synchronous machine, for example) where standard function blocks and standard interconnections are not used at all. For an illustration of this form of usage for a proprietary model, see the ExampleCompleteProprietaryModel diagram in subclause 5.5.
 */
final case class TurbineLoadControllerUserDefined
(
    TurbineLoadControllerDynamics: TurbineLoadControllerDynamics = null,
    proprietary: Boolean = false,
    ProprietaryParameterDynamics: List[String] = null
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
    override def sup: TurbineLoadControllerDynamics = TurbineLoadControllerDynamics

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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TurbineLoadControllerUserDefined.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TurbineLoadControllerUserDefined.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (TurbineLoadControllerUserDefined.fields (position), x))
        emitelem (0, proprietary)
        emitattrs (1, ProprietaryParameterDynamics)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TurbineLoadControllerUserDefined rdf:ID=\"%s\">\n%s\t</cim:TurbineLoadControllerUserDefined>".format (id, export_fields)
    }
}

object TurbineLoadControllerUserDefined
extends
    CIMParseable[TurbineLoadControllerUserDefined]
{
    override val fields: Array[String] = Array[String] (
        "proprietary",
        "ProprietaryParameterDynamics"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ProprietaryParameterDynamics", "ProprietaryParameterDynamics", "0..*", "0..1")
    )
    val proprietary: Fielder = parse_element (element (cls, fields(0)))
    val ProprietaryParameterDynamics: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): TurbineLoadControllerUserDefined =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TurbineLoadControllerUserDefined (
            TurbineLoadControllerDynamics.parse (context),
            toBoolean (mask (proprietary (), 0)),
            masks (ProprietaryParameterDynamics (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Underexcitation limiter function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 *
 * @param UnderexcitationLimiterDynamics [[ch.ninecode.model.UnderexcitationLimiterDynamics UnderexcitationLimiterDynamics]] Reference to the superclass object.
 * @param proprietary Behaviour is based on a proprietary model as opposed to a detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @param ProprietaryParameterDynamics [[ch.ninecode.model.ProprietaryParameterDynamics ProprietaryParameterDynamics]] Parameter of this proprietary user-defined model.
 * @group UserDefinedModels
 * @groupname UserDefinedModels Package UserDefinedModels
 * @groupdesc UserDefinedModels This subclause contains user-defined dynamic model classes to support the exchange of both proprietary and explicitly defined user-defined models.  
<u>Proprietary models</u> represent behaviour which, while not defined by a standard model class, is mutually understood by the sending and receiving applications based on the name passed in the .name attribute of the appropriate xxxUserDefined class.  Proprietary model parameters are passed as general attributes using as many instances of the ProprietaryParameterDynamics class as there are parameters.
<u>Explicitly defined models</u> describe dynamic behaviour in detail in terms of control blocks and their input and output signals.  Note that the classes to support explicitly defined modelling are not currently defined - it is future work intended to also be supported by the family of xxxUserDefined classes.
Both types of user-defined models use the family of xxxUserDefined classes, which allow a user-defined model to be used:
- as the model for an individual standard function block (such as a turbine-governor or power system stabilizer) in a standard interconnection model whose other function blocks could be either standard or user-defined.  For an illustration of this form of usage for a proprietary model, see the ExampleFunctionBlockProprietaryModel diagram in subclause 5.5.
- as the complete representation of a dynamic behaviour model (for an entire synchronous machine, for example) where standard function blocks and standard interconnections are not used at all. For an illustration of this form of usage for a proprietary model, see the ExampleCompleteProprietaryModel diagram in subclause 5.5.
 */
final case class UnderexcitationLimiterUserDefined
(
    UnderexcitationLimiterDynamics: UnderexcitationLimiterDynamics = null,
    proprietary: Boolean = false,
    ProprietaryParameterDynamics: List[String] = null
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
    override def sup: UnderexcitationLimiterDynamics = UnderexcitationLimiterDynamics

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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = UnderexcitationLimiterUserDefined.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (UnderexcitationLimiterUserDefined.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (UnderexcitationLimiterUserDefined.fields (position), x))
        emitelem (0, proprietary)
        emitattrs (1, ProprietaryParameterDynamics)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:UnderexcitationLimiterUserDefined rdf:ID=\"%s\">\n%s\t</cim:UnderexcitationLimiterUserDefined>".format (id, export_fields)
    }
}

object UnderexcitationLimiterUserDefined
extends
    CIMParseable[UnderexcitationLimiterUserDefined]
{
    override val fields: Array[String] = Array[String] (
        "proprietary",
        "ProprietaryParameterDynamics"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ProprietaryParameterDynamics", "ProprietaryParameterDynamics", "0..*", "0..1")
    )
    val proprietary: Fielder = parse_element (element (cls, fields(0)))
    val ProprietaryParameterDynamics: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): UnderexcitationLimiterUserDefined =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = UnderexcitationLimiterUserDefined (
            UnderexcitationLimiterDynamics.parse (context),
            toBoolean (mask (proprietary (), 0)),
            masks (ProprietaryParameterDynamics (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Voltage source converter (VSC) function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 *
 * @param VSCDynamics [[ch.ninecode.model.VSCDynamics VSCDynamics]] Reference to the superclass object.
 * @param proprietary Behaviour is based on a proprietary model as opposed to a detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @param ProprietaryParameterDynamics [[ch.ninecode.model.ProprietaryParameterDynamics ProprietaryParameterDynamics]] Parameter of this proprietary user-defined model.
 * @group UserDefinedModels
 * @groupname UserDefinedModels Package UserDefinedModels
 * @groupdesc UserDefinedModels This subclause contains user-defined dynamic model classes to support the exchange of both proprietary and explicitly defined user-defined models.  
<u>Proprietary models</u> represent behaviour which, while not defined by a standard model class, is mutually understood by the sending and receiving applications based on the name passed in the .name attribute of the appropriate xxxUserDefined class.  Proprietary model parameters are passed as general attributes using as many instances of the ProprietaryParameterDynamics class as there are parameters.
<u>Explicitly defined models</u> describe dynamic behaviour in detail in terms of control blocks and their input and output signals.  Note that the classes to support explicitly defined modelling are not currently defined - it is future work intended to also be supported by the family of xxxUserDefined classes.
Both types of user-defined models use the family of xxxUserDefined classes, which allow a user-defined model to be used:
- as the model for an individual standard function block (such as a turbine-governor or power system stabilizer) in a standard interconnection model whose other function blocks could be either standard or user-defined.  For an illustration of this form of usage for a proprietary model, see the ExampleFunctionBlockProprietaryModel diagram in subclause 5.5.
- as the complete representation of a dynamic behaviour model (for an entire synchronous machine, for example) where standard function blocks and standard interconnections are not used at all. For an illustration of this form of usage for a proprietary model, see the ExampleCompleteProprietaryModel diagram in subclause 5.5.
 */
final case class VSCUserDefined
(
    VSCDynamics: VSCDynamics = null,
    proprietary: Boolean = false,
    ProprietaryParameterDynamics: List[String] = null
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
    override def sup: VSCDynamics = VSCDynamics

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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = VSCUserDefined.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (VSCUserDefined.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (VSCUserDefined.fields (position), x))
        emitelem (0, proprietary)
        emitattrs (1, ProprietaryParameterDynamics)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:VSCUserDefined rdf:ID=\"%s\">\n%s\t</cim:VSCUserDefined>".format (id, export_fields)
    }
}

object VSCUserDefined
extends
    CIMParseable[VSCUserDefined]
{
    override val fields: Array[String] = Array[String] (
        "proprietary",
        "ProprietaryParameterDynamics"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ProprietaryParameterDynamics", "ProprietaryParameterDynamics", "0..*", "0..1")
    )
    val proprietary: Fielder = parse_element (element (cls, fields(0)))
    val ProprietaryParameterDynamics: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): VSCUserDefined =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = VSCUserDefined (
            VSCDynamics.parse (context),
            toBoolean (mask (proprietary (), 0)),
            masks (ProprietaryParameterDynamics (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * <font color="#0f0f0f">Voltage adjuster</font> function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 *
 * @param VoltageAdjusterDynamics [[ch.ninecode.model.VoltageAdjusterDynamics VoltageAdjusterDynamics]] Reference to the superclass object.
 * @param proprietary Behaviour is based on a proprietary model as opposed to a detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @param ProprietaryParameterDynamics [[ch.ninecode.model.ProprietaryParameterDynamics ProprietaryParameterDynamics]] Parameter of this proprietary user-defined model.
 * @group UserDefinedModels
 * @groupname UserDefinedModels Package UserDefinedModels
 * @groupdesc UserDefinedModels This subclause contains user-defined dynamic model classes to support the exchange of both proprietary and explicitly defined user-defined models.  
<u>Proprietary models</u> represent behaviour which, while not defined by a standard model class, is mutually understood by the sending and receiving applications based on the name passed in the .name attribute of the appropriate xxxUserDefined class.  Proprietary model parameters are passed as general attributes using as many instances of the ProprietaryParameterDynamics class as there are parameters.
<u>Explicitly defined models</u> describe dynamic behaviour in detail in terms of control blocks and their input and output signals.  Note that the classes to support explicitly defined modelling are not currently defined - it is future work intended to also be supported by the family of xxxUserDefined classes.
Both types of user-defined models use the family of xxxUserDefined classes, which allow a user-defined model to be used:
- as the model for an individual standard function block (such as a turbine-governor or power system stabilizer) in a standard interconnection model whose other function blocks could be either standard or user-defined.  For an illustration of this form of usage for a proprietary model, see the ExampleFunctionBlockProprietaryModel diagram in subclause 5.5.
- as the complete representation of a dynamic behaviour model (for an entire synchronous machine, for example) where standard function blocks and standard interconnections are not used at all. For an illustration of this form of usage for a proprietary model, see the ExampleCompleteProprietaryModel diagram in subclause 5.5.
 */
final case class VoltageAdjusterUserDefined
(
    VoltageAdjusterDynamics: VoltageAdjusterDynamics = null,
    proprietary: Boolean = false,
    ProprietaryParameterDynamics: List[String] = null
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
    override def sup: VoltageAdjusterDynamics = VoltageAdjusterDynamics

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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = VoltageAdjusterUserDefined.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (VoltageAdjusterUserDefined.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (VoltageAdjusterUserDefined.fields (position), x))
        emitelem (0, proprietary)
        emitattrs (1, ProprietaryParameterDynamics)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:VoltageAdjusterUserDefined rdf:ID=\"%s\">\n%s\t</cim:VoltageAdjusterUserDefined>".format (id, export_fields)
    }
}

object VoltageAdjusterUserDefined
extends
    CIMParseable[VoltageAdjusterUserDefined]
{
    override val fields: Array[String] = Array[String] (
        "proprietary",
        "ProprietaryParameterDynamics"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ProprietaryParameterDynamics", "ProprietaryParameterDynamics", "0..*", "0..1")
    )
    val proprietary: Fielder = parse_element (element (cls, fields(0)))
    val ProprietaryParameterDynamics: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): VoltageAdjusterUserDefined =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = VoltageAdjusterUserDefined (
            VoltageAdjusterDynamics.parse (context),
            toBoolean (mask (proprietary (), 0)),
            masks (ProprietaryParameterDynamics (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Voltage compensator function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 *
 * @param VoltageCompensatorDynamics [[ch.ninecode.model.VoltageCompensatorDynamics VoltageCompensatorDynamics]] Reference to the superclass object.
 * @param proprietary Behaviour is based on a proprietary model as opposed to a detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @param ProprietaryParameterDynamics [[ch.ninecode.model.ProprietaryParameterDynamics ProprietaryParameterDynamics]] Parameter of this proprietary user-defined model.
 * @group UserDefinedModels
 * @groupname UserDefinedModels Package UserDefinedModels
 * @groupdesc UserDefinedModels This subclause contains user-defined dynamic model classes to support the exchange of both proprietary and explicitly defined user-defined models.  
<u>Proprietary models</u> represent behaviour which, while not defined by a standard model class, is mutually understood by the sending and receiving applications based on the name passed in the .name attribute of the appropriate xxxUserDefined class.  Proprietary model parameters are passed as general attributes using as many instances of the ProprietaryParameterDynamics class as there are parameters.
<u>Explicitly defined models</u> describe dynamic behaviour in detail in terms of control blocks and their input and output signals.  Note that the classes to support explicitly defined modelling are not currently defined - it is future work intended to also be supported by the family of xxxUserDefined classes.
Both types of user-defined models use the family of xxxUserDefined classes, which allow a user-defined model to be used:
- as the model for an individual standard function block (such as a turbine-governor or power system stabilizer) in a standard interconnection model whose other function blocks could be either standard or user-defined.  For an illustration of this form of usage for a proprietary model, see the ExampleFunctionBlockProprietaryModel diagram in subclause 5.5.
- as the complete representation of a dynamic behaviour model (for an entire synchronous machine, for example) where standard function blocks and standard interconnections are not used at all. For an illustration of this form of usage for a proprietary model, see the ExampleCompleteProprietaryModel diagram in subclause 5.5.
 */
final case class VoltageCompensatorUserDefined
(
    VoltageCompensatorDynamics: VoltageCompensatorDynamics = null,
    proprietary: Boolean = false,
    ProprietaryParameterDynamics: List[String] = null
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
    override def sup: VoltageCompensatorDynamics = VoltageCompensatorDynamics

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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = VoltageCompensatorUserDefined.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (VoltageCompensatorUserDefined.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (VoltageCompensatorUserDefined.fields (position), x))
        emitelem (0, proprietary)
        emitattrs (1, ProprietaryParameterDynamics)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:VoltageCompensatorUserDefined rdf:ID=\"%s\">\n%s\t</cim:VoltageCompensatorUserDefined>".format (id, export_fields)
    }
}

object VoltageCompensatorUserDefined
extends
    CIMParseable[VoltageCompensatorUserDefined]
{
    override val fields: Array[String] = Array[String] (
        "proprietary",
        "ProprietaryParameterDynamics"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ProprietaryParameterDynamics", "ProprietaryParameterDynamics", "0..*", "0..1")
    )
    val proprietary: Fielder = parse_element (element (cls, fields(0)))
    val ProprietaryParameterDynamics: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): VoltageCompensatorUserDefined =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = VoltageCompensatorUserDefined (
            VoltageCompensatorDynamics.parse (context),
            toBoolean (mask (proprietary (), 0)),
            masks (ProprietaryParameterDynamics (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Wind plant function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 *
 * @param WindPlantDynamics [[ch.ninecode.model.WindPlantDynamics WindPlantDynamics]] Reference to the superclass object.
 * @param proprietary Behaviour is based on a proprietary model as opposed to a detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @param ProprietaryParameterDynamics [[ch.ninecode.model.ProprietaryParameterDynamics ProprietaryParameterDynamics]] Parameter of this proprietary user-defined model.
 * @group UserDefinedModels
 * @groupname UserDefinedModels Package UserDefinedModels
 * @groupdesc UserDefinedModels This subclause contains user-defined dynamic model classes to support the exchange of both proprietary and explicitly defined user-defined models.  
<u>Proprietary models</u> represent behaviour which, while not defined by a standard model class, is mutually understood by the sending and receiving applications based on the name passed in the .name attribute of the appropriate xxxUserDefined class.  Proprietary model parameters are passed as general attributes using as many instances of the ProprietaryParameterDynamics class as there are parameters.
<u>Explicitly defined models</u> describe dynamic behaviour in detail in terms of control blocks and their input and output signals.  Note that the classes to support explicitly defined modelling are not currently defined - it is future work intended to also be supported by the family of xxxUserDefined classes.
Both types of user-defined models use the family of xxxUserDefined classes, which allow a user-defined model to be used:
- as the model for an individual standard function block (such as a turbine-governor or power system stabilizer) in a standard interconnection model whose other function blocks could be either standard or user-defined.  For an illustration of this form of usage for a proprietary model, see the ExampleFunctionBlockProprietaryModel diagram in subclause 5.5.
- as the complete representation of a dynamic behaviour model (for an entire synchronous machine, for example) where standard function blocks and standard interconnections are not used at all. For an illustration of this form of usage for a proprietary model, see the ExampleCompleteProprietaryModel diagram in subclause 5.5.
 */
final case class WindPlantUserDefined
(
    WindPlantDynamics: WindPlantDynamics = null,
    proprietary: Boolean = false,
    ProprietaryParameterDynamics: List[String] = null
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
    override def sup: WindPlantDynamics = WindPlantDynamics

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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = WindPlantUserDefined.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (WindPlantUserDefined.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (WindPlantUserDefined.fields (position), x))
        emitelem (0, proprietary)
        emitattrs (1, ProprietaryParameterDynamics)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WindPlantUserDefined rdf:ID=\"%s\">\n%s\t</cim:WindPlantUserDefined>".format (id, export_fields)
    }
}

object WindPlantUserDefined
extends
    CIMParseable[WindPlantUserDefined]
{
    override val fields: Array[String] = Array[String] (
        "proprietary",
        "ProprietaryParameterDynamics"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ProprietaryParameterDynamics", "ProprietaryParameterDynamics", "0..*", "0..1")
    )
    val proprietary: Fielder = parse_element (element (cls, fields(0)))
    val ProprietaryParameterDynamics: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): WindPlantUserDefined =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WindPlantUserDefined (
            WindPlantDynamics.parse (context),
            toBoolean (mask (proprietary (), 0)),
            masks (ProprietaryParameterDynamics (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Wind type 1 or type 2 function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 *
 * @param WindTurbineType1or2Dynamics [[ch.ninecode.model.WindTurbineType1or2Dynamics WindTurbineType1or2Dynamics]] Reference to the superclass object.
 * @param proprietary Behaviour is based on a proprietary model as opposed to a detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @param ProprietaryParameterDynamics [[ch.ninecode.model.ProprietaryParameterDynamics ProprietaryParameterDynamics]] Parameter of this proprietary user-defined model.
 * @group UserDefinedModels
 * @groupname UserDefinedModels Package UserDefinedModels
 * @groupdesc UserDefinedModels This subclause contains user-defined dynamic model classes to support the exchange of both proprietary and explicitly defined user-defined models.  
<u>Proprietary models</u> represent behaviour which, while not defined by a standard model class, is mutually understood by the sending and receiving applications based on the name passed in the .name attribute of the appropriate xxxUserDefined class.  Proprietary model parameters are passed as general attributes using as many instances of the ProprietaryParameterDynamics class as there are parameters.
<u>Explicitly defined models</u> describe dynamic behaviour in detail in terms of control blocks and their input and output signals.  Note that the classes to support explicitly defined modelling are not currently defined - it is future work intended to also be supported by the family of xxxUserDefined classes.
Both types of user-defined models use the family of xxxUserDefined classes, which allow a user-defined model to be used:
- as the model for an individual standard function block (such as a turbine-governor or power system stabilizer) in a standard interconnection model whose other function blocks could be either standard or user-defined.  For an illustration of this form of usage for a proprietary model, see the ExampleFunctionBlockProprietaryModel diagram in subclause 5.5.
- as the complete representation of a dynamic behaviour model (for an entire synchronous machine, for example) where standard function blocks and standard interconnections are not used at all. For an illustration of this form of usage for a proprietary model, see the ExampleCompleteProprietaryModel diagram in subclause 5.5.
 */
final case class WindType1or2UserDefined
(
    WindTurbineType1or2Dynamics: WindTurbineType1or2Dynamics = null,
    proprietary: Boolean = false,
    ProprietaryParameterDynamics: List[String] = null
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
    override def sup: WindTurbineType1or2Dynamics = WindTurbineType1or2Dynamics

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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = WindType1or2UserDefined.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (WindType1or2UserDefined.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (WindType1or2UserDefined.fields (position), x))
        emitelem (0, proprietary)
        emitattrs (1, ProprietaryParameterDynamics)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WindType1or2UserDefined rdf:ID=\"%s\">\n%s\t</cim:WindType1or2UserDefined>".format (id, export_fields)
    }
}

object WindType1or2UserDefined
extends
    CIMParseable[WindType1or2UserDefined]
{
    override val fields: Array[String] = Array[String] (
        "proprietary",
        "ProprietaryParameterDynamics"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ProprietaryParameterDynamics", "ProprietaryParameterDynamics", "0..*", "0..1")
    )
    val proprietary: Fielder = parse_element (element (cls, fields(0)))
    val ProprietaryParameterDynamics: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): WindType1or2UserDefined =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WindType1or2UserDefined (
            WindTurbineType1or2Dynamics.parse (context),
            toBoolean (mask (proprietary (), 0)),
            masks (ProprietaryParameterDynamics (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Wind type 3 or type 4 function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 *
 * @param WindTurbineType3or4Dynamics [[ch.ninecode.model.WindTurbineType3or4Dynamics WindTurbineType3or4Dynamics]] Reference to the superclass object.
 * @param proprietary Behaviour is based on a proprietary model as opposed to a detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @param ProprietaryParameterDynamics [[ch.ninecode.model.ProprietaryParameterDynamics ProprietaryParameterDynamics]] Parameter of this proprietary user-defined model.
 * @group UserDefinedModels
 * @groupname UserDefinedModels Package UserDefinedModels
 * @groupdesc UserDefinedModels This subclause contains user-defined dynamic model classes to support the exchange of both proprietary and explicitly defined user-defined models.  
<u>Proprietary models</u> represent behaviour which, while not defined by a standard model class, is mutually understood by the sending and receiving applications based on the name passed in the .name attribute of the appropriate xxxUserDefined class.  Proprietary model parameters are passed as general attributes using as many instances of the ProprietaryParameterDynamics class as there are parameters.
<u>Explicitly defined models</u> describe dynamic behaviour in detail in terms of control blocks and their input and output signals.  Note that the classes to support explicitly defined modelling are not currently defined - it is future work intended to also be supported by the family of xxxUserDefined classes.
Both types of user-defined models use the family of xxxUserDefined classes, which allow a user-defined model to be used:
- as the model for an individual standard function block (such as a turbine-governor or power system stabilizer) in a standard interconnection model whose other function blocks could be either standard or user-defined.  For an illustration of this form of usage for a proprietary model, see the ExampleFunctionBlockProprietaryModel diagram in subclause 5.5.
- as the complete representation of a dynamic behaviour model (for an entire synchronous machine, for example) where standard function blocks and standard interconnections are not used at all. For an illustration of this form of usage for a proprietary model, see the ExampleCompleteProprietaryModel diagram in subclause 5.5.
 */
final case class WindType3or4UserDefined
(
    WindTurbineType3or4Dynamics: WindTurbineType3or4Dynamics = null,
    proprietary: Boolean = false,
    ProprietaryParameterDynamics: List[String] = null
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
    override def sup: WindTurbineType3or4Dynamics = WindTurbineType3or4Dynamics

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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = WindType3or4UserDefined.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (WindType3or4UserDefined.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (WindType3or4UserDefined.fields (position), x))
        emitelem (0, proprietary)
        emitattrs (1, ProprietaryParameterDynamics)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WindType3or4UserDefined rdf:ID=\"%s\">\n%s\t</cim:WindType3or4UserDefined>".format (id, export_fields)
    }
}

object WindType3or4UserDefined
extends
    CIMParseable[WindType3or4UserDefined]
{
    override val fields: Array[String] = Array[String] (
        "proprietary",
        "ProprietaryParameterDynamics"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ProprietaryParameterDynamics", "ProprietaryParameterDynamics", "0..*", "0..1")
    )
    val proprietary: Fielder = parse_element (element (cls, fields(0)))
    val ProprietaryParameterDynamics: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): WindType3or4UserDefined =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WindType3or4UserDefined (
            WindTurbineType3or4Dynamics.parse (context),
            toBoolean (mask (proprietary (), 0)),
            masks (ProprietaryParameterDynamics (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _UserDefinedModels
{
    def register: List[CIMClassInfo] =
    {
        List (
            AsynchronousMachineUserDefined.register,
            CSCUserDefined.register,
            DiscontinuousExcitationControlUserDefined.register,
            ExcitationSystemUserDefined.register,
            LoadUserDefined.register,
            MechanicalLoadUserDefined.register,
            OverexcitationLimiterUserDefined.register,
            PFVArControllerType1UserDefined.register,
            PFVArControllerType2UserDefined.register,
            PowerSystemStabilizerUserDefined.register,
            ProprietaryParameterDynamics.register,
            SVCUserDefined.register,
            SynchronousMachineUserDefined.register,
            TurbineGovernorUserDefined.register,
            TurbineLoadControllerUserDefined.register,
            UnderexcitationLimiterUserDefined.register,
            VSCUserDefined.register,
            VoltageAdjusterUserDefined.register,
            VoltageCompensatorUserDefined.register,
            WindPlantUserDefined.register,
            WindType1or2UserDefined.register,
            WindType3or4UserDefined.register
        )
    }
}