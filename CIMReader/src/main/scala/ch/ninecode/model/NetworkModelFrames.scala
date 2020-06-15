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
 * A description for how to assemble model parts for a specific purpose.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param ModelSpecification [[ch.ninecode.model.ModelPartSpecification ModelPartSpecification]] The models that are part of the assembly descrption.
 * @group NetworkModelFrames
 * @groupname NetworkModelFrames Package NetworkModelFrames
 */
final case class AssemblyDescription
(
    IdentifiedObject: IdentifiedObject = null,
    ModelSpecification: List[String] = null
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
        implicit val clz: String = AssemblyDescription.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (AssemblyDescription.fields (position), x))
        emitattrs (0, ModelSpecification)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AssemblyDescription rdf:ID=\"%s\">\n%s\t</cim:AssemblyDescription>".format (id, export_fields)
    }
}

object AssemblyDescription
extends
    CIMParseable[AssemblyDescription]
{
    override val fields: Array[String] = Array[String] (
        "ModelSpecification"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ModelSpecification", "ModelPartSpecification", "0..*", "0..*")
    )
    val ModelSpecification: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): AssemblyDescription =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AssemblyDescription (
            IdentifiedObject.parse (context),
            masks (ModelSpecification (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[AssemblyDescription] = AssemblyDescriptionSerializer
}

object AssemblyDescriptionSerializer extends CIMSerializer[AssemblyDescription]
{
    def write (kryo: Kryo, output: Output, obj: AssemblyDescription): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.ModelSpecification, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AssemblyDescription]): AssemblyDescription =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = AssemblyDescription (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A collection of model parts when combined form a case or part of a case.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @group NetworkModelFrames
 * @groupname NetworkModelFrames Package NetworkModelFrames
 */
final case class AssemblyManifest
(
    IdentifiedObject: IdentifiedObject = null
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:AssemblyManifest rdf:ID=\"%s\">\n%s\t</cim:AssemblyManifest>".format (id, export_fields)
    }
}

object AssemblyManifest
extends
    CIMParseable[AssemblyManifest]
{

    def parse (context: CIMContext): AssemblyManifest =
    {
        val ret = AssemblyManifest (
            IdentifiedObject.parse (context)
        )
        ret
    }

    def serializer: Serializer[AssemblyManifest] = AssemblyManifestSerializer
}

object AssemblyManifestSerializer extends CIMSerializer[AssemblyManifest]
{
    def write (kryo: Kryo, output: Output, obj: AssemblyManifest): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AssemblyManifest]): AssemblyManifest =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = AssemblyManifest (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A complete model can be used in applications to perform meaningful calculations, e.g. a study case in offline tools or a real time model in a SCADA/EMS.
 *
 * @param ModelToBeDeleted [[ch.ninecode.model.ModelToBeDeleted ModelToBeDeleted]] Reference to the superclass object.
 * @group NetworkModelFrames
 * @groupname NetworkModelFrames Package NetworkModelFrames
 */
final case class CompleteModelToBeDeleted
(
    ModelToBeDeleted: ModelToBeDeleted = null
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
    override def sup: ModelToBeDeleted = ModelToBeDeleted

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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:CompleteModelToBeDeleted rdf:ID=\"%s\">\n%s\t</cim:CompleteModelToBeDeleted>".format (id, export_fields)
    }
}

object CompleteModelToBeDeleted
extends
    CIMParseable[CompleteModelToBeDeleted]
{

    def parse (context: CIMContext): CompleteModelToBeDeleted =
    {
        val ret = CompleteModelToBeDeleted (
            ModelToBeDeleted.parse (context)
        )
        ret
    }

    def serializer: Serializer[CompleteModelToBeDeleted] = CompleteModelToBeDeletedSerializer
}

object CompleteModelToBeDeletedSerializer extends CIMSerializer[CompleteModelToBeDeleted]
{
    def write (kryo: Kryo, output: Output, obj: CompleteModelToBeDeleted): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        ModelToBeDeletedSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CompleteModelToBeDeleted]): CompleteModelToBeDeleted =
    {
        val parent = ModelToBeDeletedSerializer.read (kryo, input, classOf[ModelToBeDeleted])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = CompleteModelToBeDeleted (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The type of alternate model frame.
 *
 * For example, it could be generator group used to represent generators in state estimator, planning, planning dynamics, short circuit, or real-time dynamics etc., but does not specifically represent any one alternative model. This need to know what objects to be removed in the realization of any one alternate model.
 *
 * @param ModelAuthoritySet [[ch.ninecode.model.ModelAuthoritySet ModelAuthoritySet]] Reference to the superclass object.
 * @param Frame [[ch.ninecode.model.NetworkFrame NetworkFrame]] <em>undocumented</em>
 * @param ModelFrameType [[ch.ninecode.model.ModelFrameType ModelFrameType]] Model frame type of the model frame.
 * @group NetworkModelFrames
 * @groupname NetworkModelFrames Package NetworkModelFrames
 */
final case class FrameworkPart
(
    ModelAuthoritySet: ModelAuthoritySet = null,
    Frame: String = null,
    ModelFrameType: String = null
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
    override def sup: ModelAuthoritySet = ModelAuthoritySet

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
        implicit val clz: String = FrameworkPart.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (FrameworkPart.fields (position), value)
        emitattr (0, Frame)
        emitattr (1, ModelFrameType)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:FrameworkPart rdf:ID=\"%s\">\n%s\t</cim:FrameworkPart>".format (id, export_fields)
    }
}

object FrameworkPart
extends
    CIMParseable[FrameworkPart]
{
    override val fields: Array[String] = Array[String] (
        "Frame",
        "ModelFrameType"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Frame", "NetworkFrame", "0..1", "0..*"),
        CIMRelationship ("ModelFrameType", "ModelFrameType", "1", "0..*")
    )
    val Frame: Fielder = parse_attribute (attribute (cls, fields(0)))
    val ModelFrameType: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): FrameworkPart =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = FrameworkPart (
            ModelAuthoritySet.parse (context),
            mask (Frame (), 0),
            mask (ModelFrameType (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[FrameworkPart] = FrameworkPartSerializer
}

object FrameworkPartSerializer extends CIMSerializer[FrameworkPart]
{
    def write (kryo: Kryo, output: Output, obj: FrameworkPart): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.Frame),
            () => output.writeString (obj.ModelFrameType)
        )
        ModelAuthoritySetSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[FrameworkPart]): FrameworkPart =
    {
        val parent = ModelAuthoritySetSerializer.read (kryo, input, classOf[ModelAuthoritySet])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = FrameworkPart (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Load a model part version.
 *
 * @param Element Reference to the superclass object.
 * @group NetworkModelFrames
 * @groupname NetworkModelFrames Package NetworkModelFrames
 */
final case class LoadModelPartVersion
(
    Element: BasicElement = null
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:LoadModelPartVersion rdf:ID=\"%s\">\n%s\t</cim:LoadModelPartVersion>".format (id, export_fields)
    }
}

object LoadModelPartVersion
extends
    CIMParseable[LoadModelPartVersion]
{

    def parse (context: CIMContext): LoadModelPartVersion =
    {
        val ret = LoadModelPartVersion (
            BasicElement.parse (context)
        )
        ret
    }

    def serializer: Serializer[LoadModelPartVersion] = LoadModelPartVersionSerializer
}

object LoadModelPartVersionSerializer extends CIMSerializer[LoadModelPartVersion]
{
    def write (kryo: Kryo, output: Output, obj: LoadModelPartVersion): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[LoadModelPartVersion]): LoadModelPartVersion =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = LoadModelPartVersion (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A Modeling Authority is an entity responsible for supplying and maintaining the data defining a specific set of objects in a network model.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param ModelingAuthoritySets [[ch.ninecode.model.ModelAuthoritySet ModelAuthoritySet]] Modeling Authority Sets supplied and maintained by this Modeling Authority.
 * @group NetworkModelFrames
 * @groupname NetworkModelFrames Package NetworkModelFrames
 */
final case class ModelAuthority
(
    IdentifiedObject: IdentifiedObject = null,
    ModelingAuthoritySets: List[String] = null
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
        implicit val clz: String = ModelAuthority.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ModelAuthority.fields (position), x))
        emitattrs (0, ModelingAuthoritySets)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ModelAuthority rdf:ID=\"%s\">\n%s\t</cim:ModelAuthority>".format (id, export_fields)
    }
}

object ModelAuthority
extends
    CIMParseable[ModelAuthority]
{
    override val fields: Array[String] = Array[String] (
        "ModelingAuthoritySets"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ModelingAuthoritySets", "ModelAuthoritySet", "1..*", "1")
    )
    val ModelingAuthoritySets: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): ModelAuthority =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ModelAuthority (
            IdentifiedObject.parse (context),
            masks (ModelingAuthoritySets (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ModelAuthority] = ModelAuthoritySerializer
}

object ModelAuthoritySerializer extends CIMSerializer[ModelAuthority]
{
    def write (kryo: Kryo, output: Output, obj: ModelAuthority): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.ModelingAuthoritySets, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ModelAuthority]): ModelAuthority =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ModelAuthority (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A Modeling Authority Set is a group of objects in a network model where the data is supplied and maintained by the same Modeling Authority.
 *
 * This class is typically not included in instance data exchange as this information is tracked by other mechanisms in the exchange.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param ModelSpecification [[ch.ninecode.model.ModelPartSpecification ModelPartSpecification]] Models of the model frame.
 * @param ModelingAuthority [[ch.ninecode.model.ModelAuthority ModelAuthority]] Modeling Authority suppliying and maintaining the data for the objects in this Modeling Authority Set.
 * @group NetworkModelFrames
 * @groupname NetworkModelFrames Package NetworkModelFrames
 */
final case class ModelAuthoritySet
(
    IdentifiedObject: IdentifiedObject = null,
    ModelSpecification: List[String] = null,
    ModelingAuthority: String = null
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
        implicit val clz: String = ModelAuthoritySet.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ModelAuthoritySet.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ModelAuthoritySet.fields (position), x))
        emitattrs (0, ModelSpecification)
        emitattr (1, ModelingAuthority)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ModelAuthoritySet rdf:ID=\"%s\">\n%s\t</cim:ModelAuthoritySet>".format (id, export_fields)
    }
}

object ModelAuthoritySet
extends
    CIMParseable[ModelAuthoritySet]
{
    override val fields: Array[String] = Array[String] (
        "ModelSpecification",
        "ModelingAuthority"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ModelSpecification", "ModelPartSpecification", "0..*", "0..1"),
        CIMRelationship ("ModelingAuthority", "ModelAuthority", "1", "1..*")
    )
    val ModelSpecification: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val ModelingAuthority: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): ModelAuthoritySet =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ModelAuthoritySet (
            IdentifiedObject.parse (context),
            masks (ModelSpecification (), 0),
            mask (ModelingAuthority (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ModelAuthoritySet] = ModelAuthoritySetSerializer
}

object ModelAuthoritySetSerializer extends CIMSerializer[ModelAuthoritySet]
{
    def write (kryo: Kryo, output: Output, obj: ModelAuthoritySet): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.ModelSpecification, output),
            () => output.writeString (obj.ModelingAuthority)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ModelAuthoritySet]): ModelAuthoritySet =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ModelAuthoritySet (
            parent,
            if (isSet (0)) readList (input) else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The type of model.
 *
 * For example,  state estimator, planning, planning dynamics, short circuit, or real-time dynamics etc.     The model must conform to a profile.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param AssemblyDescription [[ch.ninecode.model.AssemblyDescription AssemblyDescription]] The assembly description into which model parts should be included.
 * @param FrameworkPart [[ch.ninecode.model.ModelAuthoritySet ModelAuthoritySet]] Model frame of the model part.
 * @param Model [[ch.ninecode.model.ModelPartVersion ModelPartVersion]] Modle parts conforming to the model part specification.
 * @group NetworkModelFrames
 * @groupname NetworkModelFrames Package NetworkModelFrames
 */
final case class ModelPartSpecification
(
    IdentifiedObject: IdentifiedObject = null,
    AssemblyDescription: List[String] = null,
    FrameworkPart: String = null,
    Model: List[String] = null
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
        implicit val clz: String = ModelPartSpecification.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ModelPartSpecification.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ModelPartSpecification.fields (position), x))
        emitattrs (0, AssemblyDescription)
        emitattr (1, FrameworkPart)
        emitattrs (2, Model)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ModelPartSpecification rdf:ID=\"%s\">\n%s\t</cim:ModelPartSpecification>".format (id, export_fields)
    }
}

object ModelPartSpecification
extends
    CIMParseable[ModelPartSpecification]
{
    override val fields: Array[String] = Array[String] (
        "AssemblyDescription",
        "FrameworkPart",
        "Model"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AssemblyDescription", "AssemblyDescription", "0..*", "0..*"),
        CIMRelationship ("FrameworkPart", "ModelAuthoritySet", "0..1", "0..*"),
        CIMRelationship ("Model", "ModelPartVersion", "0..*", "1")
    )
    val AssemblyDescription: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val FrameworkPart: Fielder = parse_attribute (attribute (cls, fields(1)))
    val Model: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: CIMContext): ModelPartSpecification =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ModelPartSpecification (
            IdentifiedObject.parse (context),
            masks (AssemblyDescription (), 0),
            mask (FrameworkPart (), 1),
            masks (Model (), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ModelPartSpecification] = ModelPartSpecificationSerializer
}

object ModelPartSpecificationSerializer extends CIMSerializer[ModelPartSpecification]
{
    def write (kryo: Kryo, output: Output, obj: ModelPartSpecification): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.AssemblyDescription, output),
            () => output.writeString (obj.FrameworkPart),
            () => writeList (obj.Model, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ModelPartSpecification]): ModelPartSpecification =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ModelPartSpecification (
            parent,
            if (isSet (0)) readList (input) else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * This is a version of a part of a model.
 *
 * New instances of this class with new identity are instantiated upon changes to the content of this class or changes to the associated data set.  Instances of this class are considered immutable.  The case audit trail can reference this immutable data to exactly reproduce a case.
 *
 * @param ModelToBeDeleted [[ch.ninecode.model.ModelToBeDeleted ModelToBeDeleted]] Reference to the superclass object.
 * @param ModelSpecification [[ch.ninecode.model.ModelPartSpecification ModelPartSpecification]] Model specification of the modelt.
 * @group NetworkModelFrames
 * @groupname NetworkModelFrames Package NetworkModelFrames
 */
final case class ModelPartVersion
(
    ModelToBeDeleted: ModelToBeDeleted = null,
    ModelSpecification: String = null
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
    override def sup: ModelToBeDeleted = ModelToBeDeleted

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
        implicit val clz: String = ModelPartVersion.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ModelPartVersion.fields (position), value)
        emitattr (0, ModelSpecification)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ModelPartVersion rdf:ID=\"%s\">\n%s\t</cim:ModelPartVersion>".format (id, export_fields)
    }
}

object ModelPartVersion
extends
    CIMParseable[ModelPartVersion]
{
    override val fields: Array[String] = Array[String] (
        "ModelSpecification"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ModelSpecification", "ModelPartSpecification", "1", "0..*")
    )
    val ModelSpecification: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): ModelPartVersion =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ModelPartVersion (
            ModelToBeDeleted.parse (context),
            mask (ModelSpecification (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ModelPartVersion] = ModelPartVersionSerializer
}

object ModelPartVersionSerializer extends CIMSerializer[ModelPartVersion]
{
    def write (kryo: Kryo, output: Output, obj: ModelPartVersion): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.ModelSpecification)
        )
        ModelToBeDeletedSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ModelPartVersion]): ModelPartVersion =
    {
        val parent = ModelToBeDeletedSerializer.read (kryo, input, classOf[ModelToBeDeleted])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ModelPartVersion (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A Model is a collection of Datasets.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @group NetworkModelFrames
 * @groupname NetworkModelFrames Package NetworkModelFrames
 */
final case class ModelToBeDeleted
(
    IdentifiedObject: IdentifiedObject = null
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:ModelToBeDeleted rdf:ID=\"%s\">\n%s\t</cim:ModelToBeDeleted>".format (id, export_fields)
    }
}

object ModelToBeDeleted
extends
    CIMParseable[ModelToBeDeleted]
{

    def parse (context: CIMContext): ModelToBeDeleted =
    {
        val ret = ModelToBeDeleted (
            IdentifiedObject.parse (context)
        )
        ret
    }

    def serializer: Serializer[ModelToBeDeleted] = ModelToBeDeletedSerializer
}

object ModelToBeDeletedSerializer extends CIMSerializer[ModelToBeDeleted]
{
    def write (kryo: Kryo, output: Output, obj: ModelToBeDeleted): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ModelToBeDeleted]): ModelToBeDeleted =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ModelToBeDeleted (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A framework part that is a boundary between 2 frames.
 *
 * @param FrameworkPart [[ch.ninecode.model.FrameworkPart FrameworkPart]] Reference to the superclass object.
 * @group NetworkModelFrames
 * @groupname NetworkModelFrames Package NetworkModelFrames
 */
final case class NetworkBoundary
(
    FrameworkPart: FrameworkPart = null
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
    override def sup: FrameworkPart = FrameworkPart

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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:NetworkBoundary rdf:ID=\"%s\">\n%s\t</cim:NetworkBoundary>".format (id, export_fields)
    }
}

object NetworkBoundary
extends
    CIMParseable[NetworkBoundary]
{

    def parse (context: CIMContext): NetworkBoundary =
    {
        val ret = NetworkBoundary (
            FrameworkPart.parse (context)
        )
        ret
    }

    def serializer: Serializer[NetworkBoundary] = NetworkBoundarySerializer
}

object NetworkBoundarySerializer extends CIMSerializer[NetworkBoundary]
{
    def write (kryo: Kryo, output: Output, obj: NetworkBoundary): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        FrameworkPartSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[NetworkBoundary]): NetworkBoundary =
    {
        val parent = FrameworkPartSerializer.read (kryo, input, classOf[FrameworkPart])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = NetworkBoundary (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A region isolated by boundaries.
 *
 * @param FrameworkPart [[ch.ninecode.model.FrameworkPart FrameworkPart]] Reference to the superclass object.
 * @param FrameworkPart_attr [[ch.ninecode.model.FrameworkPart FrameworkPart]] <em>undocumented</em>
 * @group NetworkModelFrames
 * @groupname NetworkModelFrames Package NetworkModelFrames
 */
final case class NetworkFrame
(
    FrameworkPart: FrameworkPart = null,
    FrameworkPart_attr: List[String] = null
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
    override def sup: FrameworkPart = FrameworkPart

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
        implicit val clz: String = NetworkFrame.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (NetworkFrame.fields (position), x))
        emitattrs (0, FrameworkPart_attr)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:NetworkFrame rdf:ID=\"%s\">\n%s\t</cim:NetworkFrame>".format (id, export_fields)
    }
}

object NetworkFrame
extends
    CIMParseable[NetworkFrame]
{
    override val fields: Array[String] = Array[String] (
        "FrameworkPart"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("FrameworkPart_attr", "FrameworkPart", "0..*", "0..1")
    )
    val FrameworkPart_attr: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): NetworkFrame =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = NetworkFrame (
            FrameworkPart.parse (context),
            masks (FrameworkPart_attr (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[NetworkFrame] = NetworkFrameSerializer
}

object NetworkFrameSerializer extends CIMSerializer[NetworkFrame]
{
    def write (kryo: Kryo, output: Output, obj: NetworkFrame): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.FrameworkPart_attr, output)
        )
        FrameworkPartSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[NetworkFrame]): NetworkFrame =
    {
        val parent = FrameworkPartSerializer.read (kryo, input, classOf[FrameworkPart])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = NetworkFrame (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Instructions to build a network model case, including when appropriate the results.
 *
 * @param Element Reference to the superclass object.
 * @group NetworkModelFrames
 * @groupname NetworkModelFrames Package NetworkModelFrames
 */
final case class NetworkModelCaseDefinition
(
    Element: BasicElement = null
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:NetworkModelCaseDefinition rdf:ID=\"%s\">\n%s\t</cim:NetworkModelCaseDefinition>".format (id, export_fields)
    }
}

object NetworkModelCaseDefinition
extends
    CIMParseable[NetworkModelCaseDefinition]
{

    def parse (context: CIMContext): NetworkModelCaseDefinition =
    {
        val ret = NetworkModelCaseDefinition (
            BasicElement.parse (context)
        )
        ret
    }

    def serializer: Serializer[NetworkModelCaseDefinition] = NetworkModelCaseDefinitionSerializer
}

object NetworkModelCaseDefinitionSerializer extends CIMSerializer[NetworkModelCaseDefinition]
{
    def write (kryo: Kryo, output: Output, obj: NetworkModelCaseDefinition): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[NetworkModelCaseDefinition]): NetworkModelCaseDefinition =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = NetworkModelCaseDefinition (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group NetworkModelFrames
 * @groupname NetworkModelFrames Package NetworkModelFrames
 */
final case class Operation
(
    Element: BasicElement = null
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:Operation rdf:ID=\"%s\">\n%s\t</cim:Operation>".format (id, export_fields)
    }
}

object Operation
extends
    CIMParseable[Operation]
{

    def parse (context: CIMContext): Operation =
    {
        val ret = Operation (
            BasicElement.parse (context)
        )
        ret
    }

    def serializer: Serializer[Operation] = OperationSerializer
}

object OperationSerializer extends CIMSerializer[Operation]
{
    def write (kryo: Kryo, output: Output, obj: Operation): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Operation]): Operation =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Operation (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _NetworkModelFrames
{
    def register: List[CIMClassInfo] =
    {
        List (
            AssemblyDescription.register,
            AssemblyManifest.register,
            CompleteModelToBeDeleted.register,
            FrameworkPart.register,
            LoadModelPartVersion.register,
            ModelAuthority.register,
            ModelAuthoritySet.register,
            ModelPartSpecification.register,
            ModelPartVersion.register,
            ModelToBeDeleted.register,
            NetworkBoundary.register,
            NetworkFrame.register,
            NetworkModelCaseDefinition.register,
            Operation.register
        )
    }
}