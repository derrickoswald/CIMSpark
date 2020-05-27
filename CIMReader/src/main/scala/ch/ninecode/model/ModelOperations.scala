package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * A model operation argument referencing a dataset instance.
 *
 * @param ModelOperationArg [[ch.ninecode.model.ModelOperationArg ModelOperationArg]] Reference to the superclass object.
 * @param Dataset [[ch.ninecode.model.InstanceSet InstanceSet]] Dataset referenced by this argument of a model operation..
 * @param OperationDatasetArgDescription [[ch.ninecode.model.DatasetArgDescription DatasetArgDescription]] The type of role for this dataset role.
 *        Should only reference role types that belong to the operation type of the associated operation.
 * @group ModelOperations
 * @groupname ModelOperations Package ModelOperations
 */
final case class DatasetArg
(
    ModelOperationArg: ModelOperationArg = null,
    Dataset: String = null,
    OperationDatasetArgDescription: String = null
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
    override def sup: ModelOperationArg = ModelOperationArg

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
        implicit val clz: String = DatasetArg.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DatasetArg.fields (position), value)
        emitattr (0, Dataset)
        emitattr (1, OperationDatasetArgDescription)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DatasetArg rdf:ID=\"%s\">\n%s\t</cim:DatasetArg>".format (id, export_fields)
    }
}

object DatasetArg
extends
    Parseable[DatasetArg]
{
    override val fields: Array[String] = Array[String] (
        "Dataset",
        "OperationDatasetArgDescription"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Dataset", "InstanceSet", "1", "0..*"),
        Relationship ("OperationDatasetArgDescription", "DatasetArgDescription", "1", "0..*")
    )
    val Dataset: Fielder = parse_attribute (attribute (cls, fields(0)))
    val OperationDatasetArgDescription: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): DatasetArg =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DatasetArg (
            ModelOperationArg.parse (context),
            mask (Dataset (), 0),
            mask (OperationDatasetArgDescription (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * @group ModelOperations
 * @groupname ModelOperations Package ModelOperations
 */
final case class DatasetArgDescription
(
    ModelOperationArgDescription: ModelOperationArgDescription = null,
    OperationDatasetArg: List[String] = null
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
    override def sup: ModelOperationArgDescription = ModelOperationArgDescription

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
        implicit val clz: String = DatasetArgDescription.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (DatasetArgDescription.fields (position), x))
        emitattrs (0, OperationDatasetArg)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DatasetArgDescription rdf:ID=\"%s\">\n%s\t</cim:DatasetArgDescription>".format (id, export_fields)
    }
}

object DatasetArgDescription
extends
    Parseable[DatasetArgDescription]
{
    override val fields: Array[String] = Array[String] (
        "OperationDatasetArg"
    )
    override val relations: List[Relationship] = List (
        Relationship ("OperationDatasetArg", "DatasetArg", "0..*", "1")
    )
    val OperationDatasetArg: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): DatasetArgDescription =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DatasetArgDescription (
            ModelOperationArgDescription.parse (context),
            masks (OperationDatasetArg (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A generic model operation argument referencing an incremental change description.
 *
 * @param ModelOperationArg [[ch.ninecode.model.ModelOperationArg ModelOperationArg]] Reference to the superclass object.
 * @param IncrementalDataset [[ch.ninecode.model.ChangeSet ChangeSet]] <em>undocumented</em>
 * @param IncrementalDatasetArgDescription [[ch.ninecode.model.IncrementalDatasetArgDescription IncrementalDatasetArgDescription]] <em>undocumented</em>
 * @group ModelOperations
 * @groupname ModelOperations Package ModelOperations
 */
final case class IncrementalDatasetArg
(
    ModelOperationArg: ModelOperationArg = null,
    IncrementalDataset: String = null,
    IncrementalDatasetArgDescription: String = null
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
    override def sup: ModelOperationArg = ModelOperationArg

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
        implicit val clz: String = IncrementalDatasetArg.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (IncrementalDatasetArg.fields (position), value)
        emitattr (0, IncrementalDataset)
        emitattr (1, IncrementalDatasetArgDescription)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:IncrementalDatasetArg rdf:ID=\"%s\">\n%s\t</cim:IncrementalDatasetArg>".format (id, export_fields)
    }
}

object IncrementalDatasetArg
extends
    Parseable[IncrementalDatasetArg]
{
    override val fields: Array[String] = Array[String] (
        "IncrementalDataset",
        "IncrementalDatasetArgDescription"
    )
    override val relations: List[Relationship] = List (
        Relationship ("IncrementalDataset", "ChangeSet", "1", "0..*"),
        Relationship ("IncrementalDatasetArgDescription", "IncrementalDatasetArgDescription", "1", "0..*")
    )
    val IncrementalDataset: Fielder = parse_attribute (attribute (cls, fields(0)))
    val IncrementalDatasetArgDescription: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): IncrementalDatasetArg =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = IncrementalDatasetArg (
            ModelOperationArg.parse (context),
            mask (IncrementalDataset (), 0),
            mask (IncrementalDatasetArgDescription (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * @group ModelOperations
 * @groupname ModelOperations Package ModelOperations
 */
final case class IncrementalDatasetArgDescription
(
    ModelOperationArgDescription: ModelOperationArgDescription = null,
    IncrementalDatasetArg: List[String] = null
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
    override def sup: ModelOperationArgDescription = ModelOperationArgDescription

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
        implicit val clz: String = IncrementalDatasetArgDescription.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (IncrementalDatasetArgDescription.fields (position), x))
        emitattrs (0, IncrementalDatasetArg)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:IncrementalDatasetArgDescription rdf:ID=\"%s\">\n%s\t</cim:IncrementalDatasetArgDescription>".format (id, export_fields)
    }
}

object IncrementalDatasetArgDescription
extends
    Parseable[IncrementalDatasetArgDescription]
{
    override val fields: Array[String] = Array[String] (
        "IncrementalDatasetArg"
    )
    override val relations: List[Relationship] = List (
        Relationship ("IncrementalDatasetArg", "IncrementalDatasetArg", "0..*", "1")
    )
    val IncrementalDatasetArg: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): IncrementalDatasetArgDescription =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = IncrementalDatasetArgDescription (
            ModelOperationArgDescription.parse (context),
            masks (IncrementalDatasetArg (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * An operation performed on models.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param sequenceNumber Sequence number within a operation sequence, lower is first.
 *        Normally starts with 1.
 * @param ModelOperationArg [[ch.ninecode.model.ModelOperationArg ModelOperationArg]] Arguments of the operation.
 * @param ModelOperationDescription [[ch.ninecode.model.ModelOperationDescription ModelOperationDescription]] The type of the model operation.
 * @param OperationSequence [[ch.ninecode.model.ModelOperationSequence ModelOperationSequence]] <em>undocumented</em>
 * @group ModelOperations
 * @groupname ModelOperations Package ModelOperations
 */
final case class ModelOperation
(
    IdentifiedObject: IdentifiedObject = null,
    sequenceNumber: Int = 0,
    ModelOperationArg: List[String] = null,
    ModelOperationDescription: String = null,
    OperationSequence: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ModelOperation.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ModelOperation.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ModelOperation.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ModelOperation.fields (position), x))
        emitelem (0, sequenceNumber)
        emitattrs (1, ModelOperationArg)
        emitattr (2, ModelOperationDescription)
        emitattr (3, OperationSequence)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ModelOperation rdf:ID=\"%s\">\n%s\t</cim:ModelOperation>".format (id, export_fields)
    }
}

object ModelOperation
extends
    Parseable[ModelOperation]
{
    override val fields: Array[String] = Array[String] (
        "sequenceNumber",
        "ModelOperationArg",
        "ModelOperationDescription",
        "OperationSequence"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ModelOperationArg", "ModelOperationArg", "0..*", "1"),
        Relationship ("ModelOperationDescription", "ModelOperationDescription", "1", "0..*"),
        Relationship ("OperationSequence", "ModelOperationSequence", "1", "0..*")
    )
    val sequenceNumber: Fielder = parse_element (element (cls, fields(0)))
    val ModelOperationArg: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val ModelOperationDescription: Fielder = parse_attribute (attribute (cls, fields(2)))
    val OperationSequence: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): ModelOperation =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ModelOperation (
            IdentifiedObject.parse (context),
            toInteger (mask (sequenceNumber (), 0)),
            masks (ModelOperationArg (), 1),
            mask (ModelOperationDescription (), 2),
            mask (OperationSequence (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Describes the role a dataset plays in a model operation.
 *
 * The role is applicable only in the context of a single operation.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param sequenceNumber The sequence number of the argument in an operation.
 *        Argument entries are considered in numerical order where the operation requires an ordering.
 * @param ModelOperation [[ch.ninecode.model.ModelOperation ModelOperation]] The opeation for the operation argument.
 * @group ModelOperations
 * @groupname ModelOperations Package ModelOperations
 */
final case class ModelOperationArg
(
    IdentifiedObject: IdentifiedObject = null,
    sequenceNumber: Int = 0,
    ModelOperation: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ModelOperationArg.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ModelOperationArg.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ModelOperationArg.fields (position), value)
        emitelem (0, sequenceNumber)
        emitattr (1, ModelOperation)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ModelOperationArg rdf:ID=\"%s\">\n%s\t</cim:ModelOperationArg>".format (id, export_fields)
    }
}

object ModelOperationArg
extends
    Parseable[ModelOperationArg]
{
    override val fields: Array[String] = Array[String] (
        "sequenceNumber",
        "ModelOperation"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ModelOperation", "ModelOperation", "1", "0..*")
    )
    val sequenceNumber: Fielder = parse_element (element (cls, fields(0)))
    val ModelOperation: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): ModelOperationArg =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ModelOperationArg (
            IdentifiedObject.parse (context),
            toInteger (mask (sequenceNumber (), 0)),
            mask (ModelOperation (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The type of custom operation dataset role for an operation description.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param multiplicityMaximum The maximum multiplicity of the instance arguments that should be supplied for a single operation.
 *        Use -1 to indicate unlimited.
 * @param multiplicityMinimum The minimum multiplicity of the instance arguments that should be supplied for a single operation.
 *        Use zero to indicate optional.
 * @param ModelOperationDefinition [[ch.ninecode.model.ModelOperationDescription ModelOperationDescription]] The type of operation for this type of dataset role.
 *        Operations referencing the dataset role type should only belong to operations that reference the operation type.
 * @group ModelOperations
 * @groupname ModelOperations Package ModelOperations
 */
final case class ModelOperationArgDescription
(
    IdentifiedObject: IdentifiedObject = null,
    multiplicityMaximum: Int = 0,
    multiplicityMinimum: Int = 0,
    ModelOperationDefinition: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ModelOperationArgDescription.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ModelOperationArgDescription.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ModelOperationArgDescription.fields (position), value)
        emitelem (0, multiplicityMaximum)
        emitelem (1, multiplicityMinimum)
        emitattr (2, ModelOperationDefinition)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ModelOperationArgDescription rdf:ID=\"%s\">\n%s\t</cim:ModelOperationArgDescription>".format (id, export_fields)
    }
}

object ModelOperationArgDescription
extends
    Parseable[ModelOperationArgDescription]
{
    override val fields: Array[String] = Array[String] (
        "multiplicityMaximum",
        "multiplicityMinimum",
        "ModelOperationDefinition"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ModelOperationDefinition", "ModelOperationDescription", "1", "0..*")
    )
    val multiplicityMaximum: Fielder = parse_element (element (cls, fields(0)))
    val multiplicityMinimum: Fielder = parse_element (element (cls, fields(1)))
    val ModelOperationDefinition: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): ModelOperationArgDescription =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ModelOperationArgDescription (
            IdentifiedObject.parse (context),
            toInteger (mask (multiplicityMaximum (), 0)),
            toInteger (mask (multiplicityMinimum (), 1)),
            mask (ModelOperationDefinition (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The type of model operation.
 *
 * This class is referenced by model operations and defines the kind of operation.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param ModelOperation [[ch.ninecode.model.ModelOperation ModelOperation]] The instances of operations that conform to this operation type.
 * @param OperationDatasetArgDescription [[ch.ninecode.model.ModelOperationArgDescription ModelOperationArgDescription]] The type of dataset roles that can be used for a type of general model operation.
 * @group ModelOperations
 * @groupname ModelOperations Package ModelOperations
 */
final case class ModelOperationDescription
(
    IdentifiedObject: IdentifiedObject = null,
    ModelOperation: List[String] = null,
    OperationDatasetArgDescription: List[String] = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ModelOperationDescription.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ModelOperationDescription.fields (position), x))
        emitattrs (0, ModelOperation)
        emitattrs (1, OperationDatasetArgDescription)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ModelOperationDescription rdf:ID=\"%s\">\n%s\t</cim:ModelOperationDescription>".format (id, export_fields)
    }
}

object ModelOperationDescription
extends
    Parseable[ModelOperationDescription]
{
    override val fields: Array[String] = Array[String] (
        "ModelOperation",
        "OperationDatasetArgDescription"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ModelOperation", "ModelOperation", "0..*", "1"),
        Relationship ("OperationDatasetArgDescription", "ModelOperationArgDescription", "0..*", "1")
    )
    val ModelOperation: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val OperationDatasetArgDescription: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): ModelOperationDescription =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ModelOperationDescription (
            IdentifiedObject.parse (context),
            masks (ModelOperation (), 0),
            masks (OperationDatasetArgDescription (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A concrete sequence of operations.
 *
 * For example, this may be used to describe a specific audit trail, a script or other specific set of actions on specific datasets.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param ModelOperation [[ch.ninecode.model.ModelOperation ModelOperation]] <em>undocumented</em>
 * @group ModelOperations
 * @groupname ModelOperations Package ModelOperations
 */
final case class ModelOperationSequence
(
    IdentifiedObject: IdentifiedObject = null,
    ModelOperation: List[String] = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ModelOperationSequence.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ModelOperationSequence.fields (position), x))
        emitattrs (0, ModelOperation)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ModelOperationSequence rdf:ID=\"%s\">\n%s\t</cim:ModelOperationSequence>".format (id, export_fields)
    }
}

object ModelOperationSequence
extends
    Parseable[ModelOperationSequence]
{
    override val fields: Array[String] = Array[String] (
        "ModelOperation"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ModelOperation", "ModelOperation", "0..*", "1")
    )
    val ModelOperation: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): ModelOperationSequence =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ModelOperationSequence (
            IdentifiedObject.parse (context),
            masks (ModelOperation (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _ModelOperations
{
    def register: List[ClassInfo] =
    {
        List (
            DatasetArg.register,
            DatasetArgDescription.register,
            IncrementalDatasetArg.register,
            IncrementalDatasetArgDescription.register,
            ModelOperation.register,
            ModelOperationArg.register,
            ModelOperationArgDescription.register,
            ModelOperationDescription.register,
            ModelOperationSequence.register
        )
    }
}