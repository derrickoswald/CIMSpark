package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Asynchronous machine whose dynamic behaviour is described by a user-defined model.
 *
 * @param sup [[ch.ninecode.model.AsynchronousMachineDynamics AsynchronousMachineDynamics]] Reference to the superclass object.
 * @param proprietary Behaviour is based on proprietary model as opposed to detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @param ProprietaryParameterDynamics [[ch.ninecode.model.ProprietaryParameterDynamics ProprietaryParameterDynamics]] Parameter of this proprietary user-defined model.
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
    proprietary: Boolean,
    ProprietaryParameterDynamics: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, List()) }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = AsynchronousMachineUserDefined.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AsynchronousMachineUserDefined.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (AsynchronousMachineUserDefined.fields (position), x))
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
    Parseable[AsynchronousMachineUserDefined]
{
    override val fields: Array[String] = Array[String] (
        "proprietary",
        "ProprietaryParameterDynamics"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ProprietaryParameterDynamics", "ProprietaryParameterDynamics", "0..*", "0..1")
    )
    val proprietary: Fielder = parse_element (element (cls, fields(0)))
    val ProprietaryParameterDynamics: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): AsynchronousMachineUserDefined =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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
 * Discontinuous excitation control function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 *
 * @param sup [[ch.ninecode.model.DiscontinuousExcitationControlDynamics DiscontinuousExcitationControlDynamics]] Reference to the superclass object.
 * @param proprietary Behaviour is based on proprietary model as opposed to detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @param ProprietaryParameterDynamics [[ch.ninecode.model.ProprietaryParameterDynamics ProprietaryParameterDynamics]] Parameter of this proprietary user-defined model.
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
    proprietary: Boolean,
    ProprietaryParameterDynamics: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, List()) }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = DiscontinuousExcitationControlUserDefined.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DiscontinuousExcitationControlUserDefined.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (DiscontinuousExcitationControlUserDefined.fields (position), x))
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
    Parseable[DiscontinuousExcitationControlUserDefined]
{
    override val fields: Array[String] = Array[String] (
        "proprietary",
        "ProprietaryParameterDynamics"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ProprietaryParameterDynamics", "ProprietaryParameterDynamics", "0..*", "0..1")
    )
    val proprietary: Fielder = parse_element (element (cls, fields(0)))
    val ProprietaryParameterDynamics: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): DiscontinuousExcitationControlUserDefined =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param proprietary Behaviour is based on proprietary model as opposed to detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @param ProprietaryParameterDynamics [[ch.ninecode.model.ProprietaryParameterDynamics ProprietaryParameterDynamics]] Parameter of this proprietary user-defined model.
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
    proprietary: Boolean,
    ProprietaryParameterDynamics: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, List()) }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcitationSystemUserDefined.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcitationSystemUserDefined.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (ExcitationSystemUserDefined.fields (position), x))
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
    Parseable[ExcitationSystemUserDefined]
{
    override val fields: Array[String] = Array[String] (
        "proprietary",
        "ProprietaryParameterDynamics"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ProprietaryParameterDynamics", "ProprietaryParameterDynamics", "0..*", "0..1")
    )
    val proprietary: Fielder = parse_element (element (cls, fields(0)))
    val ProprietaryParameterDynamics: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): ExcitationSystemUserDefined =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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
 * @param sup [[ch.ninecode.model.LoadDynamics LoadDynamics]] Reference to the superclass object.
 * @param proprietary Behaviour is based on proprietary model as opposed to detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @param ProprietaryParameterDynamics [[ch.ninecode.model.ProprietaryParameterDynamics ProprietaryParameterDynamics]] Parameter of this proprietary user-defined model.
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
    proprietary: Boolean,
    ProprietaryParameterDynamics: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, List()) }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = LoadUserDefined.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (LoadUserDefined.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (LoadUserDefined.fields (position), x))
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
    Parseable[LoadUserDefined]
{
    override val fields: Array[String] = Array[String] (
        "proprietary",
        "ProprietaryParameterDynamics"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ProprietaryParameterDynamics", "ProprietaryParameterDynamics", "0..*", "0..1")
    )
    val proprietary: Fielder = parse_element (element (cls, fields(0)))
    val ProprietaryParameterDynamics: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): LoadUserDefined =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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
 * @param sup [[ch.ninecode.model.MechanicalLoadDynamics MechanicalLoadDynamics]] Reference to the superclass object.
 * @param proprietary Behaviour is based on proprietary model as opposed to detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @param ProprietaryParameterDynamics [[ch.ninecode.model.ProprietaryParameterDynamics ProprietaryParameterDynamics]] Parameter of this proprietary user-defined model.
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
    proprietary: Boolean,
    ProprietaryParameterDynamics: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, List()) }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MechanicalLoadUserDefined.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MechanicalLoadUserDefined.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (MechanicalLoadUserDefined.fields (position), x))
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
    Parseable[MechanicalLoadUserDefined]
{
    override val fields: Array[String] = Array[String] (
        "proprietary",
        "ProprietaryParameterDynamics"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ProprietaryParameterDynamics", "ProprietaryParameterDynamics", "0..*", "0..1")
    )
    val proprietary: Fielder = parse_element (element (cls, fields(0)))
    val ProprietaryParameterDynamics: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): MechanicalLoadUserDefined =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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
 * @param sup [[ch.ninecode.model.OverexcitationLimiterDynamics OverexcitationLimiterDynamics]] Reference to the superclass object.
 * @param proprietary Behaviour is based on proprietary model as opposed to detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @param ProprietaryParameterDynamics [[ch.ninecode.model.ProprietaryParameterDynamics ProprietaryParameterDynamics]] Parameter of this proprietary user-defined model.
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
    proprietary: Boolean,
    ProprietaryParameterDynamics: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, List()) }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = OverexcitationLimiterUserDefined.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (OverexcitationLimiterUserDefined.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (OverexcitationLimiterUserDefined.fields (position), x))
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
    Parseable[OverexcitationLimiterUserDefined]
{
    override val fields: Array[String] = Array[String] (
        "proprietary",
        "ProprietaryParameterDynamics"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ProprietaryParameterDynamics", "ProprietaryParameterDynamics", "0..*", "0..1")
    )
    val proprietary: Fielder = parse_element (element (cls, fields(0)))
    val ProprietaryParameterDynamics: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): OverexcitationLimiterUserDefined =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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
 * Power Factor or VAr controller Type I function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 *
 * @param sup [[ch.ninecode.model.PFVArControllerType1Dynamics PFVArControllerType1Dynamics]] Reference to the superclass object.
 * @param proprietary Behaviour is based on proprietary model as opposed to detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @param ProprietaryParameterDynamics [[ch.ninecode.model.ProprietaryParameterDynamics ProprietaryParameterDynamics]] Parameter of this proprietary user-defined model.
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
    proprietary: Boolean,
    ProprietaryParameterDynamics: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, List()) }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PFVArControllerType1UserDefined.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PFVArControllerType1UserDefined.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (PFVArControllerType1UserDefined.fields (position), x))
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
    Parseable[PFVArControllerType1UserDefined]
{
    override val fields: Array[String] = Array[String] (
        "proprietary",
        "ProprietaryParameterDynamics"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ProprietaryParameterDynamics", "ProprietaryParameterDynamics", "0..*", "0..1")
    )
    val proprietary: Fielder = parse_element (element (cls, fields(0)))
    val ProprietaryParameterDynamics: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): PFVArControllerType1UserDefined =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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
 * Power Factor or VAr controller Type II function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 *
 * @param sup [[ch.ninecode.model.PFVArControllerType2Dynamics PFVArControllerType2Dynamics]] Reference to the superclass object.
 * @param proprietary Behaviour is based on proprietary model as opposed to detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @param ProprietaryParameterDynamics [[ch.ninecode.model.ProprietaryParameterDynamics ProprietaryParameterDynamics]] Parameter of this proprietary user-defined model.
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
    proprietary: Boolean,
    ProprietaryParameterDynamics: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, List()) }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PFVArControllerType2UserDefined.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PFVArControllerType2UserDefined.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (PFVArControllerType2UserDefined.fields (position), x))
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
    Parseable[PFVArControllerType2UserDefined]
{
    override val fields: Array[String] = Array[String] (
        "proprietary",
        "ProprietaryParameterDynamics"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ProprietaryParameterDynamics", "ProprietaryParameterDynamics", "0..*", "0..1")
    )
    val proprietary: Fielder = parse_element (element (cls, fields(0)))
    val ProprietaryParameterDynamics: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): PFVArControllerType2UserDefined =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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
 * @param sup [[ch.ninecode.model.PowerSystemStabilizerDynamics PowerSystemStabilizerDynamics]] Reference to the superclass object.
 * @param proprietary Behaviour is based on proprietary model as opposed to detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @param ProprietaryParameterDynamics [[ch.ninecode.model.ProprietaryParameterDynamics ProprietaryParameterDynamics]] Parameter of this proprietary user-defined model.
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
    proprietary: Boolean,
    ProprietaryParameterDynamics: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, List()) }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PowerSystemStabilizerUserDefined.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PowerSystemStabilizerUserDefined.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (PowerSystemStabilizerUserDefined.fields (position), x))
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
    Parseable[PowerSystemStabilizerUserDefined]
{
    override val fields: Array[String] = Array[String] (
        "proprietary",
        "ProprietaryParameterDynamics"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ProprietaryParameterDynamics", "ProprietaryParameterDynamics", "0..*", "0..1")
    )
    val proprietary: Fielder = parse_element (element (cls, fields(0)))
    val ProprietaryParameterDynamics: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): PowerSystemStabilizerUserDefined =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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
 * @param AsynchronousMachineUserDefined [[ch.ninecode.model.AsynchronousMachineUserDefined AsynchronousMachineUserDefined]] Proprietary user-defined model with which this parameter is associated.
 * @param DiscontinuousExcitationControlUserDefined [[ch.ninecode.model.DiscontinuousExcitationControlUserDefined DiscontinuousExcitationControlUserDefined]] Proprietary user-defined model with which this parameter is associated.
 * @param ExcitationSystemUserDefined [[ch.ninecode.model.ExcitationSystemUserDefined ExcitationSystemUserDefined]] Proprietary user-defined model with which this parameter is associated.
 * @param LoadUserDefined [[ch.ninecode.model.LoadUserDefined LoadUserDefined]] Proprietary user-defined model with which this parameter is associated.
 * @param MechanicalLoadUserDefined [[ch.ninecode.model.MechanicalLoadUserDefined MechanicalLoadUserDefined]] Proprietary user-defined model with which this parameter is associated.
 * @param OverexcitationLimiterUserDefined [[ch.ninecode.model.OverexcitationLimiterUserDefined OverexcitationLimiterUserDefined]] Proprietary user-defined model with which this parameter is associated.
 * @param PFVArControllerType1UserDefined [[ch.ninecode.model.PFVArControllerType1UserDefined PFVArControllerType1UserDefined]] Proprietary user-defined model with which this parameter is associated.
 * @param PFVArControllerType2UserDefined [[ch.ninecode.model.PFVArControllerType2UserDefined PFVArControllerType2UserDefined]] Proprietary user-defined model with which this parameter is associated.
 * @param PowerSystemStabilizerUserDefined [[ch.ninecode.model.PowerSystemStabilizerUserDefined PowerSystemStabilizerUserDefined]] Proprietary user-defined model with which this parameter is associated.
 * @param SynchronousMachineUserDefined [[ch.ninecode.model.SynchronousMachineUserDefined SynchronousMachineUserDefined]] Proprietary user-defined model with which this parameter is associated.
 * @param TurbineGovernorUserDefined [[ch.ninecode.model.TurbineGovernorUserDefined TurbineGovernorUserDefined]] Proprietary user-defined model with which this parameter is associated.
 * @param TurbineLoadControllerUserDefined [[ch.ninecode.model.TurbineLoadControllerUserDefined TurbineLoadControllerUserDefined]] Proprietary user-defined model with which this parameter is associated.
 * @param UnderexcitationLimiterUserDefined [[ch.ninecode.model.UnderexcitationLimiterUserDefined UnderexcitationLimiterUserDefined]] Proprietary user-defined model with which this parameter is associated.
 * @param VoltageAdjusterUserDefined [[ch.ninecode.model.VoltageAdjusterUserDefined VoltageAdjusterUserDefined]] Proprietary user-defined model with which this parameter is associated.
 * @param VoltageCompensatorUserDefined [[ch.ninecode.model.VoltageCompensatorUserDefined VoltageCompensatorUserDefined]] Proprietary user-defined model with which this parameter is associated.
 * @param WindPlantUserDefined [[ch.ninecode.model.WindPlantUserDefined WindPlantUserDefined]] Proprietary user-defined model with which this parameter is associated.
 * @param WindType1or2UserDefined [[ch.ninecode.model.WindType1or2UserDefined WindType1or2UserDefined]] Proprietary user-defined model with which this parameter is associated.
 * @param WindType3or4UserDefined [[ch.ninecode.model.WindType3or4UserDefined WindType3or4UserDefined]] Proprietary user-defined model with which this parameter is associated.
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ProprietaryParameterDynamics.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ProprietaryParameterDynamics.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ProprietaryParameterDynamics.fields (position), value)
        emitelem (0, booleanParameterValue)
        emitelem (1, floatParameterValue)
        emitelem (2, integerParameterValue)
        emitelem (3, parameterNumber)
        emitattr (4, AsynchronousMachineUserDefined)
        emitattr (5, DiscontinuousExcitationControlUserDefined)
        emitattr (6, ExcitationSystemUserDefined)
        emitattr (7, LoadUserDefined)
        emitattr (8, MechanicalLoadUserDefined)
        emitattr (9, OverexcitationLimiterUserDefined)
        emitattr (10, PFVArControllerType1UserDefined)
        emitattr (11, PFVArControllerType2UserDefined)
        emitattr (12, PowerSystemStabilizerUserDefined)
        emitattr (13, SynchronousMachineUserDefined)
        emitattr (14, TurbineGovernorUserDefined)
        emitattr (15, TurbineLoadControllerUserDefined)
        emitattr (16, UnderexcitationLimiterUserDefined)
        emitattr (17, VoltageAdjusterUserDefined)
        emitattr (18, VoltageCompensatorUserDefined)
        emitattr (19, WindPlantUserDefined)
        emitattr (20, WindType1or2UserDefined)
        emitattr (21, WindType3or4UserDefined)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ProprietaryParameterDynamics rdf:ID=\"%s\">\n%s\t</cim:ProprietaryParameterDynamics>".format (id, export_fields)
    }
}

object ProprietaryParameterDynamics
extends
    Parseable[ProprietaryParameterDynamics]
{
    override val fields: Array[String] = Array[String] (
        "booleanParameterValue",
        "floatParameterValue",
        "integerParameterValue",
        "parameterNumber",
        "AsynchronousMachineUserDefined",
        "DiscontinuousExcitationControlUserDefined",
        "ExcitationSystemUserDefined",
        "LoadUserDefined",
        "MechanicalLoadUserDefined",
        "OverexcitationLimiterUserDefined",
        "PFVArControllerType1UserDefined",
        "PFVArControllerType2UserDefined",
        "PowerSystemStabilizerUserDefined",
        "SynchronousMachineUserDefined",
        "TurbineGovernorUserDefined",
        "TurbineLoadControllerUserDefined",
        "UnderexcitationLimiterUserDefined",
        "VoltageAdjusterUserDefined",
        "VoltageCompensatorUserDefined",
        "WindPlantUserDefined",
        "WindType1or2UserDefined",
        "WindType3or4UserDefined"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AsynchronousMachineUserDefined", "AsynchronousMachineUserDefined", "0..1", "0..*"),
        Relationship ("DiscontinuousExcitationControlUserDefined", "DiscontinuousExcitationControlUserDefined", "0..1", "0..*"),
        Relationship ("ExcitationSystemUserDefined", "ExcitationSystemUserDefined", "0..1", "0..*"),
        Relationship ("LoadUserDefined", "LoadUserDefined", "0..1", "0..*"),
        Relationship ("MechanicalLoadUserDefined", "MechanicalLoadUserDefined", "0..1", "0..*"),
        Relationship ("OverexcitationLimiterUserDefined", "OverexcitationLimiterUserDefined", "0..1", "0..*"),
        Relationship ("PFVArControllerType1UserDefined", "PFVArControllerType1UserDefined", "0..1", "0..*"),
        Relationship ("PFVArControllerType2UserDefined", "PFVArControllerType2UserDefined", "0..1", "0..*"),
        Relationship ("PowerSystemStabilizerUserDefined", "PowerSystemStabilizerUserDefined", "0..1", "0..*"),
        Relationship ("SynchronousMachineUserDefined", "SynchronousMachineUserDefined", "0..1", "0..*"),
        Relationship ("TurbineGovernorUserDefined", "TurbineGovernorUserDefined", "0..1", "0..*"),
        Relationship ("TurbineLoadControllerUserDefined", "TurbineLoadControllerUserDefined", "0..1", "0..*"),
        Relationship ("UnderexcitationLimiterUserDefined", "UnderexcitationLimiterUserDefined", "0..1", "0..*"),
        Relationship ("VoltageAdjusterUserDefined", "VoltageAdjusterUserDefined", "0..1", "0..*"),
        Relationship ("VoltageCompensatorUserDefined", "VoltageCompensatorUserDefined", "0..1", "0..*"),
        Relationship ("WindPlantUserDefined", "WindPlantUserDefined", "0..1", "0..*"),
        Relationship ("WindType1or2UserDefined", "WindType1or2UserDefined", "0..1", "0..*"),
        Relationship ("WindType3or4UserDefined", "WindType3or4UserDefined", "0..1", "0..*")
    )
    val booleanParameterValue: Fielder = parse_element (element (cls, fields(0)))
    val floatParameterValue: Fielder = parse_element (element (cls, fields(1)))
    val integerParameterValue: Fielder = parse_element (element (cls, fields(2)))
    val parameterNumber: Fielder = parse_element (element (cls, fields(3)))
    val AsynchronousMachineUserDefined: Fielder = parse_attribute (attribute (cls, fields(4)))
    val DiscontinuousExcitationControlUserDefined: Fielder = parse_attribute (attribute (cls, fields(5)))
    val ExcitationSystemUserDefined: Fielder = parse_attribute (attribute (cls, fields(6)))
    val LoadUserDefined: Fielder = parse_attribute (attribute (cls, fields(7)))
    val MechanicalLoadUserDefined: Fielder = parse_attribute (attribute (cls, fields(8)))
    val OverexcitationLimiterUserDefined: Fielder = parse_attribute (attribute (cls, fields(9)))
    val PFVArControllerType1UserDefined: Fielder = parse_attribute (attribute (cls, fields(10)))
    val PFVArControllerType2UserDefined: Fielder = parse_attribute (attribute (cls, fields(11)))
    val PowerSystemStabilizerUserDefined: Fielder = parse_attribute (attribute (cls, fields(12)))
    val SynchronousMachineUserDefined: Fielder = parse_attribute (attribute (cls, fields(13)))
    val TurbineGovernorUserDefined: Fielder = parse_attribute (attribute (cls, fields(14)))
    val TurbineLoadControllerUserDefined: Fielder = parse_attribute (attribute (cls, fields(15)))
    val UnderexcitationLimiterUserDefined: Fielder = parse_attribute (attribute (cls, fields(16)))
    val VoltageAdjusterUserDefined: Fielder = parse_attribute (attribute (cls, fields(17)))
    val VoltageCompensatorUserDefined: Fielder = parse_attribute (attribute (cls, fields(18)))
    val WindPlantUserDefined: Fielder = parse_attribute (attribute (cls, fields(19)))
    val WindType1or2UserDefined: Fielder = parse_attribute (attribute (cls, fields(20)))
    val WindType3or4UserDefined: Fielder = parse_attribute (attribute (cls, fields(21)))

    def parse (context: Context): ProprietaryParameterDynamics =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ProprietaryParameterDynamics (
            BasicElement.parse (context),
            toBoolean (mask (booleanParameterValue (), 0)),
            toDouble (mask (floatParameterValue (), 1)),
            toInteger (mask (integerParameterValue (), 2)),
            toInteger (mask (parameterNumber (), 3)),
            mask (AsynchronousMachineUserDefined (), 4),
            mask (DiscontinuousExcitationControlUserDefined (), 5),
            mask (ExcitationSystemUserDefined (), 6),
            mask (LoadUserDefined (), 7),
            mask (MechanicalLoadUserDefined (), 8),
            mask (OverexcitationLimiterUserDefined (), 9),
            mask (PFVArControllerType1UserDefined (), 10),
            mask (PFVArControllerType2UserDefined (), 11),
            mask (PowerSystemStabilizerUserDefined (), 12),
            mask (SynchronousMachineUserDefined (), 13),
            mask (TurbineGovernorUserDefined (), 14),
            mask (TurbineLoadControllerUserDefined (), 15),
            mask (UnderexcitationLimiterUserDefined (), 16),
            mask (VoltageAdjusterUserDefined (), 17),
            mask (VoltageCompensatorUserDefined (), 18),
            mask (WindPlantUserDefined (), 19),
            mask (WindType1or2UserDefined (), 20),
            mask (WindType3or4UserDefined (), 21)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Synchronous machine whose dynamic behaviour is described by a user-defined model.
 *
 * @param sup [[ch.ninecode.model.SynchronousMachineDynamics SynchronousMachineDynamics]] Reference to the superclass object.
 * @param proprietary Behaviour is based on proprietary model as opposed to detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @param ProprietaryParameterDynamics [[ch.ninecode.model.ProprietaryParameterDynamics ProprietaryParameterDynamics]] Parameter of this proprietary user-defined model.
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
    proprietary: Boolean,
    ProprietaryParameterDynamics: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, List()) }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = SynchronousMachineUserDefined.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SynchronousMachineUserDefined.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (SynchronousMachineUserDefined.fields (position), x))
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
    Parseable[SynchronousMachineUserDefined]
{
    override val fields: Array[String] = Array[String] (
        "proprietary",
        "ProprietaryParameterDynamics"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ProprietaryParameterDynamics", "ProprietaryParameterDynamics", "0..*", "0..1")
    )
    val proprietary: Fielder = parse_element (element (cls, fields(0)))
    val ProprietaryParameterDynamics: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): SynchronousMachineUserDefined =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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
 * @param sup [[ch.ninecode.model.TurbineGovernorDynamics TurbineGovernorDynamics]] Reference to the superclass object.
 * @param proprietary Behaviour is based on proprietary model as opposed to detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @param ProprietaryParameterDynamics [[ch.ninecode.model.ProprietaryParameterDynamics ProprietaryParameterDynamics]] Parameter of this proprietary user-defined model.
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
    proprietary: Boolean,
    ProprietaryParameterDynamics: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, List()) }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TurbineGovernorUserDefined.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TurbineGovernorUserDefined.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (TurbineGovernorUserDefined.fields (position), x))
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
    Parseable[TurbineGovernorUserDefined]
{
    override val fields: Array[String] = Array[String] (
        "proprietary",
        "ProprietaryParameterDynamics"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ProprietaryParameterDynamics", "ProprietaryParameterDynamics", "0..*", "0..1")
    )
    val proprietary: Fielder = parse_element (element (cls, fields(0)))
    val ProprietaryParameterDynamics: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): TurbineGovernorUserDefined =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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
 * @param sup [[ch.ninecode.model.TurbineLoadControllerDynamics TurbineLoadControllerDynamics]] Reference to the superclass object.
 * @param proprietary Behaviour is based on proprietary model as opposed to detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @param ProprietaryParameterDynamics [[ch.ninecode.model.ProprietaryParameterDynamics ProprietaryParameterDynamics]] Parameter of this proprietary user-defined model.
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
    proprietary: Boolean,
    ProprietaryParameterDynamics: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, List()) }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TurbineLoadControllerUserDefined.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TurbineLoadControllerUserDefined.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (TurbineLoadControllerUserDefined.fields (position), x))
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
    Parseable[TurbineLoadControllerUserDefined]
{
    override val fields: Array[String] = Array[String] (
        "proprietary",
        "ProprietaryParameterDynamics"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ProprietaryParameterDynamics", "ProprietaryParameterDynamics", "0..*", "0..1")
    )
    val proprietary: Fielder = parse_element (element (cls, fields(0)))
    val ProprietaryParameterDynamics: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): TurbineLoadControllerUserDefined =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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
 * @param sup [[ch.ninecode.model.UnderexcitationLimiterDynamics UnderexcitationLimiterDynamics]] Reference to the superclass object.
 * @param proprietary Behaviour is based on proprietary model as opposed to detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @param ProprietaryParameterDynamics [[ch.ninecode.model.ProprietaryParameterDynamics ProprietaryParameterDynamics]] Parameter of this proprietary user-defined model.
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
    proprietary: Boolean,
    ProprietaryParameterDynamics: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, List()) }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = UnderexcitationLimiterUserDefined.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (UnderexcitationLimiterUserDefined.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (UnderexcitationLimiterUserDefined.fields (position), x))
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
    Parseable[UnderexcitationLimiterUserDefined]
{
    override val fields: Array[String] = Array[String] (
        "proprietary",
        "ProprietaryParameterDynamics"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ProprietaryParameterDynamics", "ProprietaryParameterDynamics", "0..*", "0..1")
    )
    val proprietary: Fielder = parse_element (element (cls, fields(0)))
    val ProprietaryParameterDynamics: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): UnderexcitationLimiterUserDefined =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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
 * <font color="#0f0f0f">Voltage adjuster</font> function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 *
 * @param sup [[ch.ninecode.model.VoltageAdjusterDynamics VoltageAdjusterDynamics]] Reference to the superclass object.
 * @param proprietary Behaviour is based on proprietary model as opposed to detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @param ProprietaryParameterDynamics [[ch.ninecode.model.ProprietaryParameterDynamics ProprietaryParameterDynamics]] Parameter of this proprietary user-defined model.
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
    proprietary: Boolean,
    ProprietaryParameterDynamics: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, List()) }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = VoltageAdjusterUserDefined.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (VoltageAdjusterUserDefined.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (VoltageAdjusterUserDefined.fields (position), x))
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
    Parseable[VoltageAdjusterUserDefined]
{
    override val fields: Array[String] = Array[String] (
        "proprietary",
        "ProprietaryParameterDynamics"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ProprietaryParameterDynamics", "ProprietaryParameterDynamics", "0..*", "0..1")
    )
    val proprietary: Fielder = parse_element (element (cls, fields(0)))
    val ProprietaryParameterDynamics: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): VoltageAdjusterUserDefined =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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
 * @param sup [[ch.ninecode.model.VoltageCompensatorDynamics VoltageCompensatorDynamics]] Reference to the superclass object.
 * @param proprietary Behaviour is based on proprietary model as opposed to detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @param ProprietaryParameterDynamics [[ch.ninecode.model.ProprietaryParameterDynamics ProprietaryParameterDynamics]] Parameter of this proprietary user-defined model.
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
    proprietary: Boolean,
    ProprietaryParameterDynamics: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, List()) }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = VoltageCompensatorUserDefined.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (VoltageCompensatorUserDefined.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (VoltageCompensatorUserDefined.fields (position), x))
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
    Parseable[VoltageCompensatorUserDefined]
{
    override val fields: Array[String] = Array[String] (
        "proprietary",
        "ProprietaryParameterDynamics"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ProprietaryParameterDynamics", "ProprietaryParameterDynamics", "0..*", "0..1")
    )
    val proprietary: Fielder = parse_element (element (cls, fields(0)))
    val ProprietaryParameterDynamics: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): VoltageCompensatorUserDefined =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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
 * @param sup [[ch.ninecode.model.WindPlantDynamics WindPlantDynamics]] Reference to the superclass object.
 * @param proprietary Behaviour is based on proprietary model as opposed to detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @param ProprietaryParameterDynamics [[ch.ninecode.model.ProprietaryParameterDynamics ProprietaryParameterDynamics]] Parameter of this proprietary user-defined model.
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
    proprietary: Boolean,
    ProprietaryParameterDynamics: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, List()) }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = WindPlantUserDefined.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (WindPlantUserDefined.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (WindPlantUserDefined.fields (position), x))
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
    Parseable[WindPlantUserDefined]
{
    override val fields: Array[String] = Array[String] (
        "proprietary",
        "ProprietaryParameterDynamics"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ProprietaryParameterDynamics", "ProprietaryParameterDynamics", "0..*", "0..1")
    )
    val proprietary: Fielder = parse_element (element (cls, fields(0)))
    val ProprietaryParameterDynamics: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): WindPlantUserDefined =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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
 * Wind Type 1 or Type 2 function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 *
 * @param sup [[ch.ninecode.model.WindTurbineType1or2Dynamics WindTurbineType1or2Dynamics]] Reference to the superclass object.
 * @param proprietary Behaviour is based on proprietary model as opposed to detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @param ProprietaryParameterDynamics [[ch.ninecode.model.ProprietaryParameterDynamics ProprietaryParameterDynamics]] Parameter of this proprietary user-defined model.
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
    proprietary: Boolean,
    ProprietaryParameterDynamics: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, List()) }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = WindType1or2UserDefined.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (WindType1or2UserDefined.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (WindType1or2UserDefined.fields (position), x))
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
    Parseable[WindType1or2UserDefined]
{
    override val fields: Array[String] = Array[String] (
        "proprietary",
        "ProprietaryParameterDynamics"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ProprietaryParameterDynamics", "ProprietaryParameterDynamics", "0..*", "0..1")
    )
    val proprietary: Fielder = parse_element (element (cls, fields(0)))
    val ProprietaryParameterDynamics: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): WindType1or2UserDefined =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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
 * Wind Type 3 or Type 4 function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 *
 * @param sup [[ch.ninecode.model.WindTurbineType3or4Dynamics WindTurbineType3or4Dynamics]] Reference to the superclass object.
 * @param proprietary Behaviour is based on proprietary model as opposed to detailed model.
 *        true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
 *        false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
 * @param ProprietaryParameterDynamics [[ch.ninecode.model.ProprietaryParameterDynamics ProprietaryParameterDynamics]] Parameter of this proprietary user-defined model.
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
    proprietary: Boolean,
    ProprietaryParameterDynamics: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, List()) }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = WindType3or4UserDefined.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (WindType3or4UserDefined.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (WindType3or4UserDefined.fields (position), x))
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
    Parseable[WindType3or4UserDefined]
{
    override val fields: Array[String] = Array[String] (
        "proprietary",
        "ProprietaryParameterDynamics"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ProprietaryParameterDynamics", "ProprietaryParameterDynamics", "0..*", "0..1")
    )
    val proprietary: Fielder = parse_element (element (cls, fields(0)))
    val ProprietaryParameterDynamics: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): WindType3or4UserDefined =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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