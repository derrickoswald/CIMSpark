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
 * A model operation argument referencing a dataset instance.
 *
 * @param ModelOperationArg              [[ch.ninecode.model.ModelOperationArg ModelOperationArg]] Reference to the superclass object.
 * @param Dataset                        [[ch.ninecode.model.InstanceSet InstanceSet]] Dataset referenced by this argument of a model operation..
 * @param OperationDatasetArgDescription [[ch.ninecode.model.DatasetArgDescription DatasetArgDescription]] The type of role for this dataset role.
 *                                       Should only reference role types that belong to the operation type of the associated operation.
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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[DatasetArg]
{
    override val fields: Array[String] = Array [String](
        "Dataset",
        "OperationDatasetArgDescription"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Dataset", "InstanceSet", "1", "0..*"),
        CIMRelationship ("OperationDatasetArgDescription", "DatasetArgDescription", "1", "0..*")
    )
    val Dataset: Fielder = parse_attribute (attribute (cls, fields (0)))
    val OperationDatasetArgDescription: Fielder = parse_attribute (attribute (cls, fields (1)))

    def parse (context: CIMContext): DatasetArg =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = DatasetArg (
            ModelOperationArg.parse (context),
            mask (Dataset (), 0),
            mask (OperationDatasetArgDescription (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[DatasetArg] = DatasetArgSerializer
}

object DatasetArgSerializer extends CIMSerializer[DatasetArg]
{
    def write (kryo: Kryo, output: Output, obj: DatasetArg): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.Dataset),
            () => output.writeString (obj.OperationDatasetArgDescription)
        )
        ModelOperationArgSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DatasetArg]): DatasetArg =
    {
        val parent = ModelOperationArgSerializer.read (kryo, input, classOf [ModelOperationArg])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = DatasetArg (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[DatasetArgDescription]
{
    override val fields: Array[String] = Array [String](
        "OperationDatasetArg"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("OperationDatasetArg", "DatasetArg", "0..*", "1")
    )
    val OperationDatasetArg: FielderMultiple = parse_attributes (attribute (cls, fields (0)))

    def parse (context: CIMContext): DatasetArgDescription =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = DatasetArgDescription (
            ModelOperationArgDescription.parse (context),
            masks (OperationDatasetArg (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[DatasetArgDescription] = DatasetArgDescriptionSerializer
}

object DatasetArgDescriptionSerializer extends CIMSerializer[DatasetArgDescription]
{
    def write (kryo: Kryo, output: Output, obj: DatasetArgDescription): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.OperationDatasetArg, output)
        )
        ModelOperationArgDescriptionSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DatasetArgDescription]): DatasetArgDescription =
    {
        val parent = ModelOperationArgDescriptionSerializer.read (kryo, input, classOf [ModelOperationArgDescription])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = DatasetArgDescription (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A generic model operation argument referencing an incremental change description.
 *
 * @param ModelOperationArg                [[ch.ninecode.model.ModelOperationArg ModelOperationArg]] Reference to the superclass object.
 * @param IncrementalDataset               [[ch.ninecode.model.ChangeSet ChangeSet]] <em>undocumented</em>
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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[IncrementalDatasetArg]
{
    override val fields: Array[String] = Array [String](
        "IncrementalDataset",
        "IncrementalDatasetArgDescription"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("IncrementalDataset", "ChangeSet", "1", "0..*"),
        CIMRelationship ("IncrementalDatasetArgDescription", "IncrementalDatasetArgDescription", "1", "0..*")
    )
    val IncrementalDataset: Fielder = parse_attribute (attribute (cls, fields (0)))
    val IncrementalDatasetArgDescription: Fielder = parse_attribute (attribute (cls, fields (1)))

    def parse (context: CIMContext): IncrementalDatasetArg =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = IncrementalDatasetArg (
            ModelOperationArg.parse (context),
            mask (IncrementalDataset (), 0),
            mask (IncrementalDatasetArgDescription (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[IncrementalDatasetArg] = IncrementalDatasetArgSerializer
}

object IncrementalDatasetArgSerializer extends CIMSerializer[IncrementalDatasetArg]
{
    def write (kryo: Kryo, output: Output, obj: IncrementalDatasetArg): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.IncrementalDataset),
            () => output.writeString (obj.IncrementalDatasetArgDescription)
        )
        ModelOperationArgSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[IncrementalDatasetArg]): IncrementalDatasetArg =
    {
        val parent = ModelOperationArgSerializer.read (kryo, input, classOf [ModelOperationArg])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = IncrementalDatasetArg (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[IncrementalDatasetArgDescription]
{
    override val fields: Array[String] = Array [String](
        "IncrementalDatasetArg"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("IncrementalDatasetArg", "IncrementalDatasetArg", "0..*", "1")
    )
    val IncrementalDatasetArg: FielderMultiple = parse_attributes (attribute (cls, fields (0)))

    def parse (context: CIMContext): IncrementalDatasetArgDescription =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = IncrementalDatasetArgDescription (
            ModelOperationArgDescription.parse (context),
            masks (IncrementalDatasetArg (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[IncrementalDatasetArgDescription] = IncrementalDatasetArgDescriptionSerializer
}

object IncrementalDatasetArgDescriptionSerializer extends CIMSerializer[IncrementalDatasetArgDescription]
{
    def write (kryo: Kryo, output: Output, obj: IncrementalDatasetArgDescription): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.IncrementalDatasetArg, output)
        )
        ModelOperationArgDescriptionSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[IncrementalDatasetArgDescription]): IncrementalDatasetArgDescription =
    {
        val parent = ModelOperationArgDescriptionSerializer.read (kryo, input, classOf [ModelOperationArgDescription])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = IncrementalDatasetArgDescription (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * An operation performed on models.
 *
 * @param IdentifiedObject          [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param sequenceNumber            Sequence number within a operation sequence, lower is first.
 *                                  Normally starts with 1.
 * @param ModelOperationArg         [[ch.ninecode.model.ModelOperationArg ModelOperationArg]] Arguments of the operation.
 * @param ModelOperationDescription [[ch.ninecode.model.ModelOperationDescription ModelOperationDescription]] The type of the model operation.
 * @param OperationSequence         [[ch.ninecode.model.ModelOperationSequence ModelOperationSequence]] <em>undocumented</em>
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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[ModelOperation]
{
    override val fields: Array[String] = Array [String](
        "sequenceNumber",
        "ModelOperationArg",
        "ModelOperationDescription",
        "OperationSequence"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ModelOperationArg", "ModelOperationArg", "0..*", "1"),
        CIMRelationship ("ModelOperationDescription", "ModelOperationDescription", "1", "0..*"),
        CIMRelationship ("OperationSequence", "ModelOperationSequence", "1", "0..*")
    )
    val sequenceNumber: Fielder = parse_element (element (cls, fields (0)))
    val ModelOperationArg: FielderMultiple = parse_attributes (attribute (cls, fields (1)))
    val ModelOperationDescription: Fielder = parse_attribute (attribute (cls, fields (2)))
    val OperationSequence: Fielder = parse_attribute (attribute (cls, fields (3)))

    def parse (context: CIMContext): ModelOperation =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
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

    def serializer: Serializer[ModelOperation] = ModelOperationSerializer
}

object ModelOperationSerializer extends CIMSerializer[ModelOperation]
{
    def write (kryo: Kryo, output: Output, obj: ModelOperation): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeInt (obj.sequenceNumber),
            () => writeList (obj.ModelOperationArg, output),
            () => output.writeString (obj.ModelOperationDescription),
            () => output.writeString (obj.OperationSequence)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ModelOperation]): ModelOperation =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf [IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ModelOperation (
            parent,
            if (isSet (0)) input.readInt else 0,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Describes the role a dataset plays in a model operation.
 *
 * The role is applicable only in the context of a single operation.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param sequenceNumber   The sequence number of the argument in an operation.
 *                         Argument entries are considered in numerical order where the operation requires an ordering.
 * @param ModelOperation   [[ch.ninecode.model.ModelOperation ModelOperation]] The opeation for the operation argument.
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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[ModelOperationArg]
{
    override val fields: Array[String] = Array [String](
        "sequenceNumber",
        "ModelOperation"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ModelOperation", "ModelOperation", "1", "0..*")
    )
    val sequenceNumber: Fielder = parse_element (element (cls, fields (0)))
    val ModelOperation: Fielder = parse_attribute (attribute (cls, fields (1)))

    def parse (context: CIMContext): ModelOperationArg =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = ModelOperationArg (
            IdentifiedObject.parse (context),
            toInteger (mask (sequenceNumber (), 0)),
            mask (ModelOperation (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ModelOperationArg] = ModelOperationArgSerializer
}

object ModelOperationArgSerializer extends CIMSerializer[ModelOperationArg]
{
    def write (kryo: Kryo, output: Output, obj: ModelOperationArg): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeInt (obj.sequenceNumber),
            () => output.writeString (obj.ModelOperation)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ModelOperationArg]): ModelOperationArg =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf [IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ModelOperationArg (
            parent,
            if (isSet (0)) input.readInt else 0,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The type of custom operation dataset role for an operation description.
 *
 * @param IdentifiedObject         [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param multiplicityMaximum      The maximum multiplicity of the instance arguments that should be supplied for a single operation.
 *                                 Use -1 to indicate unlimited.
 * @param multiplicityMinimum      The minimum multiplicity of the instance arguments that should be supplied for a single operation.
 *                                 Use zero to indicate optional.
 * @param ModelOperationDefinition [[ch.ninecode.model.ModelOperationDescription ModelOperationDescription]] The type of operation for this type of dataset role.
 *                                 Operations referencing the dataset role type should only belong to operations that reference the operation type.
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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[ModelOperationArgDescription]
{
    override val fields: Array[String] = Array [String](
        "multiplicityMaximum",
        "multiplicityMinimum",
        "ModelOperationDefinition"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ModelOperationDefinition", "ModelOperationDescription", "1", "0..*")
    )
    val multiplicityMaximum: Fielder = parse_element (element (cls, fields (0)))
    val multiplicityMinimum: Fielder = parse_element (element (cls, fields (1)))
    val ModelOperationDefinition: Fielder = parse_attribute (attribute (cls, fields (2)))

    def parse (context: CIMContext): ModelOperationArgDescription =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = ModelOperationArgDescription (
            IdentifiedObject.parse (context),
            toInteger (mask (multiplicityMaximum (), 0)),
            toInteger (mask (multiplicityMinimum (), 1)),
            mask (ModelOperationDefinition (), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ModelOperationArgDescription] = ModelOperationArgDescriptionSerializer
}

object ModelOperationArgDescriptionSerializer extends CIMSerializer[ModelOperationArgDescription]
{
    def write (kryo: Kryo, output: Output, obj: ModelOperationArgDescription): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeInt (obj.multiplicityMaximum),
            () => output.writeInt (obj.multiplicityMinimum),
            () => output.writeString (obj.ModelOperationDefinition)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ModelOperationArgDescription]): ModelOperationArgDescription =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf [IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ModelOperationArgDescription (
            parent,
            if (isSet (0)) input.readInt else 0,
            if (isSet (1)) input.readInt else 0,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The type of model operation.
 *
 * This class is referenced by model operations and defines the kind of operation.
 *
 * @param IdentifiedObject               [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param ModelOperation                 [[ch.ninecode.model.ModelOperation ModelOperation]] The instances of operations that conform to this operation type.
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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[ModelOperationDescription]
{
    override val fields: Array[String] = Array [String](
        "ModelOperation",
        "OperationDatasetArgDescription"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ModelOperation", "ModelOperation", "0..*", "1"),
        CIMRelationship ("OperationDatasetArgDescription", "ModelOperationArgDescription", "0..*", "1")
    )
    val ModelOperation: FielderMultiple = parse_attributes (attribute (cls, fields (0)))
    val OperationDatasetArgDescription: FielderMultiple = parse_attributes (attribute (cls, fields (1)))

    def parse (context: CIMContext): ModelOperationDescription =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = ModelOperationDescription (
            IdentifiedObject.parse (context),
            masks (ModelOperation (), 0),
            masks (OperationDatasetArgDescription (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ModelOperationDescription] = ModelOperationDescriptionSerializer
}

object ModelOperationDescriptionSerializer extends CIMSerializer[ModelOperationDescription]
{
    def write (kryo: Kryo, output: Output, obj: ModelOperationDescription): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.ModelOperation, output),
            () => writeList (obj.OperationDatasetArgDescription, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ModelOperationDescription]): ModelOperationDescription =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf [IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ModelOperationDescription (
            parent,
            if (isSet (0)) readList (input) else null,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A concrete sequence of operations.
 *
 * For example, this may be used to describe a specific audit trail, a script or other specific set of actions on specific datasets.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param ModelOperation   [[ch.ninecode.model.ModelOperation ModelOperation]] <em>undocumented</em>
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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[ModelOperationSequence]
{
    override val fields: Array[String] = Array [String](
        "ModelOperation"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ModelOperation", "ModelOperation", "0..*", "1")
    )
    val ModelOperation: FielderMultiple = parse_attributes (attribute (cls, fields (0)))

    def parse (context: CIMContext): ModelOperationSequence =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = ModelOperationSequence (
            IdentifiedObject.parse (context),
            masks (ModelOperation (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ModelOperationSequence] = ModelOperationSequenceSerializer
}

object ModelOperationSequenceSerializer extends CIMSerializer[ModelOperationSequence]
{
    def write (kryo: Kryo, output: Output, obj: ModelOperationSequence): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.ModelOperation, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ModelOperationSequence]): ModelOperationSequence =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf [IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ModelOperationSequence (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _ModelOperations
{
    def register: List[CIMClassInfo] =
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