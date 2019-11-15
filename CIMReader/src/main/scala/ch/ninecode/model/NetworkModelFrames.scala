package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * A description for how to assemble model parts for a specific purpose.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param ModelSpecification [[ch.ninecode.model.ModelPartSpecification ModelPartSpecification]] The models that are part of the assembly descrption.
 * @group NetworkModelFrames
 * @groupname NetworkModelFrames Package NetworkModelFrames
 */
final case class AssemblyDescription
(
    override val sup: IdentifiedObject = null,
    ModelSpecification: List[String] = List()
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
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[AssemblyDescription] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[AssemblyDescription]
{
    override val fields: Array[String] = Array[String] (
        "ModelSpecification"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ModelSpecification", "ModelPartSpecification", "0..*", "0..*")
    )
    val ModelSpecification: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): AssemblyDescription =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AssemblyDescription (
            IdentifiedObject.parse (context),
            masks (ModelSpecification (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A collection of model parts when combined form a case or part of a case.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @group NetworkModelFrames
 * @groupname NetworkModelFrames Package NetworkModelFrames
 */
final case class AssemblyManifest
(
    override val sup: IdentifiedObject = null
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
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[AssemblyManifest] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[AssemblyManifest]
{

    def parse (context: Context): AssemblyManifest =
    {
        implicit val ctx: Context = context
        val ret = AssemblyManifest (
            IdentifiedObject.parse (context)
        )
        ret
    }
}

/**
 * A complete model can be used in applications to perform meaningful calculations, e.g. a study case in offline tools or a real time model in a SCADA/EMS.
 *
 * @param sup [[ch.ninecode.model.ModelToBeDeleted ModelToBeDeleted]] Reference to the superclass object.
 * @group NetworkModelFrames
 * @groupname NetworkModelFrames Package NetworkModelFrames
 */
final case class CompleteModelToBeDeleted
(
    override val sup: ModelToBeDeleted = null
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
    def ModelToBeDeleted: ModelToBeDeleted = sup.asInstanceOf[ModelToBeDeleted]
    override def copy (): Row = { clone ().asInstanceOf[CompleteModelToBeDeleted] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[CompleteModelToBeDeleted]
{

    def parse (context: Context): CompleteModelToBeDeleted =
    {
        implicit val ctx: Context = context
        val ret = CompleteModelToBeDeleted (
            ModelToBeDeleted.parse (context)
        )
        ret
    }
}

/**
 * The type of alternate model frame.
 *
 * For example, it could be generator group used to represent generators in state estimator, planning, planning dynamics, short circuit, or real-time dynamics etc., but does not specifically represent any one alternative model. This need to know what objects to be removed in the realization of any one alternate model.
 *
 * @param sup [[ch.ninecode.model.ModelAuthoritySet ModelAuthoritySet]] Reference to the superclass object.
 * @param Frame [[ch.ninecode.model.NetworkFrame NetworkFrame]] <em>undocumented</em>
 * @param ModelFrameType [[ch.ninecode.model.ModelFrameType ModelFrameType]] Model frame type of the model frame.
 * @group NetworkModelFrames
 * @groupname NetworkModelFrames Package NetworkModelFrames
 */
final case class FrameworkPart
(
    override val sup: ModelAuthoritySet = null,
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
    def ModelAuthoritySet: ModelAuthoritySet = sup.asInstanceOf[ModelAuthoritySet]
    override def copy (): Row = { clone ().asInstanceOf[FrameworkPart] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[FrameworkPart]
{
    override val fields: Array[String] = Array[String] (
        "Frame",
        "ModelFrameType"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Frame", "NetworkFrame", "0..1", "0..*"),
        Relationship ("ModelFrameType", "ModelFrameType", "1", "0..*")
    )
    val Frame: Fielder = parse_attribute (attribute (cls, fields(0)))
    val ModelFrameType: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): FrameworkPart =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = FrameworkPart (
            ModelAuthoritySet.parse (context),
            mask (Frame (), 0),
            mask (ModelFrameType (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Load a model part version.
 *
 * @param sup Reference to the superclass object.
 * @group NetworkModelFrames
 * @groupname NetworkModelFrames Package NetworkModelFrames
 */
final case class LoadModelPartVersion
(
    override val sup: BasicElement = null
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
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[LoadModelPartVersion] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[LoadModelPartVersion]
{

    def parse (context: Context): LoadModelPartVersion =
    {
        implicit val ctx: Context = context
        val ret = LoadModelPartVersion (
            BasicElement.parse (context)
        )
        ret
    }
}

/**
 * A Modeling Authority is an entity responsible for supplying and maintaining the data defining a specific set of objects in a network model.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param ModelingAuthoritySets [[ch.ninecode.model.ModelAuthoritySet ModelAuthoritySet]] Modeling Authority Sets supplied and maintained by this Modeling Authority.
 * @group NetworkModelFrames
 * @groupname NetworkModelFrames Package NetworkModelFrames
 */
final case class ModelAuthority
(
    override val sup: IdentifiedObject = null,
    ModelingAuthoritySets: List[String] = List()
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
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ModelAuthority] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[ModelAuthority]
{
    override val fields: Array[String] = Array[String] (
        "ModelingAuthoritySets"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ModelingAuthoritySets", "ModelAuthoritySet", "1..*", "1")
    )
    val ModelingAuthoritySets: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): ModelAuthority =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ModelAuthority (
            IdentifiedObject.parse (context),
            masks (ModelingAuthoritySets (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A Modeling Authority Set is a group of objects in a network model where the data is supplied and maintained by the same Modeling Authority.
 *
 * This class is typically not included in instance data exchange as this information is tracked by other mechanisms in the exchange.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param ModelSpecification [[ch.ninecode.model.ModelPartSpecification ModelPartSpecification]] Models of the model frame.
 * @param ModelingAuthority [[ch.ninecode.model.ModelAuthority ModelAuthority]] Modeling Authority suppliying and maintaining the data for the objects in this Modeling Authority Set.
 * @group NetworkModelFrames
 * @groupname NetworkModelFrames Package NetworkModelFrames
 */
final case class ModelAuthoritySet
(
    override val sup: IdentifiedObject = null,
    ModelSpecification: List[String] = List(),
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
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ModelAuthoritySet] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[ModelAuthoritySet]
{
    override val fields: Array[String] = Array[String] (
        "ModelSpecification",
        "ModelingAuthority"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ModelSpecification", "ModelPartSpecification", "0..*", "0..1"),
        Relationship ("ModelingAuthority", "ModelAuthority", "1", "1..*")
    )
    val ModelSpecification: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val ModelingAuthority: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): ModelAuthoritySet =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ModelAuthoritySet (
            IdentifiedObject.parse (context),
            masks (ModelSpecification (), 0),
            mask (ModelingAuthority (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The type of model.
 *
 * For example,  state estimator, planning, planning dynamics, short circuit, or real-time dynamics etc.     The model must conform to a profile.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param AssemblyDescription [[ch.ninecode.model.AssemblyDescription AssemblyDescription]] The assembly description into which model parts should be included.
 * @param FrameworkPart [[ch.ninecode.model.ModelAuthoritySet ModelAuthoritySet]] Model frame of the model part.
 * @param Model [[ch.ninecode.model.ModelPartVersion ModelPartVersion]] Modle parts conforming to the model part specification.
 * @group NetworkModelFrames
 * @groupname NetworkModelFrames Package NetworkModelFrames
 */
final case class ModelPartSpecification
(
    override val sup: IdentifiedObject = null,
    AssemblyDescription: List[String] = List(),
    FrameworkPart: String = null,
    Model: List[String] = List()
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
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ModelPartSpecification] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[ModelPartSpecification]
{
    override val fields: Array[String] = Array[String] (
        "AssemblyDescription",
        "FrameworkPart",
        "Model"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AssemblyDescription", "AssemblyDescription", "0..*", "0..*"),
        Relationship ("FrameworkPart", "ModelAuthoritySet", "0..1", "0..*"),
        Relationship ("Model", "ModelPartVersion", "0..*", "1")
    )
    val AssemblyDescription: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val FrameworkPart: Fielder = parse_attribute (attribute (cls, fields(1)))
    val Model: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: Context): ModelPartSpecification =
    {
        implicit val ctx: Context = context
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
}

/**
 * This is a version of a part of a model.
 *
 * New instances of this class with new identity are instantiated upon changes to the content of this class or changes to the associated data set.  Instances of this class are considered immutable.  The case audit trail can reference this immutable data to exactly reproduce a case.
 *
 * @param sup [[ch.ninecode.model.ModelToBeDeleted ModelToBeDeleted]] Reference to the superclass object.
 * @param ModelSpecification [[ch.ninecode.model.ModelPartSpecification ModelPartSpecification]] Model specification of the modelt.
 * @group NetworkModelFrames
 * @groupname NetworkModelFrames Package NetworkModelFrames
 */
final case class ModelPartVersion
(
    override val sup: ModelToBeDeleted = null,
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
    def ModelToBeDeleted: ModelToBeDeleted = sup.asInstanceOf[ModelToBeDeleted]
    override def copy (): Row = { clone ().asInstanceOf[ModelPartVersion] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[ModelPartVersion]
{
    override val fields: Array[String] = Array[String] (
        "ModelSpecification"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ModelSpecification", "ModelPartSpecification", "1", "0..*")
    )
    val ModelSpecification: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): ModelPartVersion =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ModelPartVersion (
            ModelToBeDeleted.parse (context),
            mask (ModelSpecification (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A Model is a collection of Datasets.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @group NetworkModelFrames
 * @groupname NetworkModelFrames Package NetworkModelFrames
 */
final case class ModelToBeDeleted
(
    override val sup: IdentifiedObject = null
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
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ModelToBeDeleted] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[ModelToBeDeleted]
{

    def parse (context: Context): ModelToBeDeleted =
    {
        implicit val ctx: Context = context
        val ret = ModelToBeDeleted (
            IdentifiedObject.parse (context)
        )
        ret
    }
}

/**
 * A framework part that is a boundary between 2 frames.
 *
 * @param sup [[ch.ninecode.model.FrameworkPart FrameworkPart]] Reference to the superclass object.
 * @group NetworkModelFrames
 * @groupname NetworkModelFrames Package NetworkModelFrames
 */
final case class NetworkBoundary
(
    override val sup: FrameworkPart = null
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
    def FrameworkPart: FrameworkPart = sup.asInstanceOf[FrameworkPart]
    override def copy (): Row = { clone ().asInstanceOf[NetworkBoundary] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[NetworkBoundary]
{

    def parse (context: Context): NetworkBoundary =
    {
        implicit val ctx: Context = context
        val ret = NetworkBoundary (
            FrameworkPart.parse (context)
        )
        ret
    }
}

/**
 * A region isolated by boundaries.
 *
 * @param sup [[ch.ninecode.model.FrameworkPart FrameworkPart]] Reference to the superclass object.
 * @param FrameworkPart [[ch.ninecode.model.FrameworkPart FrameworkPart]] <em>undocumented</em>
 * @group NetworkModelFrames
 * @groupname NetworkModelFrames Package NetworkModelFrames
 */
final case class NetworkFrame
(
    override val sup: FrameworkPart = null,
    FrameworkPart_attr: List[String] = List()
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
    def FrameworkPart: FrameworkPart = sup.asInstanceOf[FrameworkPart]
    override def copy (): Row = { clone ().asInstanceOf[NetworkFrame] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[NetworkFrame]
{
    override val fields: Array[String] = Array[String] (
        "FrameworkPart"
    )
    override val relations: List[Relationship] = List (
        Relationship ("FrameworkPart_attr", "FrameworkPart", "0..*", "0..1")
    )
    val FrameworkPart_attr: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): NetworkFrame =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = NetworkFrame (
            FrameworkPart.parse (context),
            masks (FrameworkPart_attr (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Instructions to build a network model case, including when appropriate the results.
 *
 * @param sup Reference to the superclass object.
 * @group NetworkModelFrames
 * @groupname NetworkModelFrames Package NetworkModelFrames
 */
final case class NetworkModelCaseDefinition
(
    override val sup: BasicElement = null
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
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[NetworkModelCaseDefinition] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[NetworkModelCaseDefinition]
{

    def parse (context: Context): NetworkModelCaseDefinition =
    {
        implicit val ctx: Context = context
        val ret = NetworkModelCaseDefinition (
            BasicElement.parse (context)
        )
        ret
    }
}

/**

 * @group NetworkModelFrames
 * @groupname NetworkModelFrames Package NetworkModelFrames
 */
final case class Operation
(
    override val sup: BasicElement = null
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
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[Operation] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[Operation]
{

    def parse (context: Context): Operation =
    {
        implicit val ctx: Context = context
        val ret = Operation (
            BasicElement.parse (context)
        )
        ret
    }
}

private[ninecode] object _NetworkModelFrames
{
    def register: List[ClassInfo] =
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