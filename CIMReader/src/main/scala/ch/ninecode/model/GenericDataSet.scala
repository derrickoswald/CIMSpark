package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.CIMClassInfo
import ch.ninecode.cim.CIMContext
import ch.ninecode.cim.CIMParseable
import ch.ninecode.cim.CIMRelationship

/**
 * Describes a set of changes that can be applied in different situations.
 *
 * A given registered target object  MRID may only be referenced once by the contained change set members.
 *
 * @param DataSet [[ch.ninecode.model.DataSet DataSet]] Reference to the superclass object.
 * @param ChangeSetMember [[ch.ninecode.model.ChangeSetMember ChangeSetMember]] Data objects contained in the dataset.
 * @param IncrementalDatasetArg [[ch.ninecode.model.IncrementalDatasetArg IncrementalDatasetArg]] <em>undocumented</em>
 * @param NMProjectStage [[ch.ninecode.model.NetworkModelProjectStage NetworkModelProjectStage]] <em>undocumented</em>
 * @param NetworkModelProjectChangeVersion [[ch.ninecode.model.NetworkModelProjectChangeVersion NetworkModelProjectChangeVersion]] The project of the details of model changes.
 * @group GenericDataSet
 * @groupname GenericDataSet Package GenericDataSet
 * @groupdesc GenericDataSet Contains classes used for generic dataset modelling.
 */
final case class ChangeSet
(
    DataSet: DataSet = null,
    ChangeSetMember: List[String] = null,
    IncrementalDatasetArg: List[String] = null,
    NMProjectStage: String = null,
    NetworkModelProjectChangeVersion: List[String] = null
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
    override def sup: DataSet = DataSet

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
        implicit val clz: String = ChangeSet.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ChangeSet.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ChangeSet.fields (position), x))
        emitattrs (0, ChangeSetMember)
        emitattrs (1, IncrementalDatasetArg)
        emitattr (2, NMProjectStage)
        emitattrs (3, NetworkModelProjectChangeVersion)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ChangeSet rdf:ID=\"%s\">\n%s\t</cim:ChangeSet>".format (id, export_fields)
    }
}

object ChangeSet
extends
    CIMParseable[ChangeSet]
{
    override val fields: Array[String] = Array[String] (
        "ChangeSetMember",
        "IncrementalDatasetArg",
        "NMProjectStage",
        "NetworkModelProjectChangeVersion"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ChangeSetMember", "ChangeSetMember", "0..*", "0..1"),
        CIMRelationship ("IncrementalDatasetArg", "IncrementalDatasetArg", "0..*", "1"),
        CIMRelationship ("NMProjectStage", "NetworkModelProjectStage", "0..1", "1..*"),
        CIMRelationship ("NetworkModelProjectChangeVersion", "NetworkModelProjectChangeVersion", "0..*", "0..1")
    )
    val ChangeSetMember: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val IncrementalDatasetArg: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val NMProjectStage: Fielder = parse_attribute (attribute (cls, fields(2)))
    val NetworkModelProjectChangeVersion: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: CIMContext): ChangeSet =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ChangeSet (
            DataSet.parse (context),
            masks (ChangeSetMember (), 0),
            masks (IncrementalDatasetArg (), 1),
            mask (NMProjectStage (), 2),
            masks (NetworkModelProjectChangeVersion (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A CRUD-style data object.
 *
 * @param Element Reference to the superclass object.
 * @param Changeset [[ch.ninecode.model.ChangeSet ChangeSet]] Dataset containing the data objects.
 * @param PropertiesObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] The CIM object holding the properties of this dataset context.
 *        Sometimes properties are not required and only the reference to the registered object is required.
 * @param TargetObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] The registered CIM object.
 * @group GenericDataSet
 * @groupname GenericDataSet Package GenericDataSet
 * @groupdesc GenericDataSet Contains classes used for generic dataset modelling.
 */
final case class ChangeSetMember
(
    Element: BasicElement = null,
    Changeset: String = null,
    PropertiesObject: String = null,
    TargetObject: String = null
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
        implicit val clz: String = ChangeSetMember.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ChangeSetMember.fields (position), value)
        emitattr (0, Changeset)
        emitattr (1, PropertiesObject)
        emitattr (2, TargetObject)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ChangeSetMember rdf:ID=\"%s\">\n%s\t</cim:ChangeSetMember>".format (id, export_fields)
    }
}

object ChangeSetMember
extends
    CIMParseable[ChangeSetMember]
{
    override val fields: Array[String] = Array[String] (
        "Changeset",
        "PropertiesObject",
        "TargetObject"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Changeset", "ChangeSet", "0..1", "0..*"),
        CIMRelationship ("PropertiesObject", "IdentifiedObject", "0..1", "0..1"),
        CIMRelationship ("TargetObject", "IdentifiedObject", "1", "0..*")
    )
    val Changeset: Fielder = parse_attribute (attribute (cls, fields(0)))
    val PropertiesObject: Fielder = parse_attribute (attribute (cls, fields(1)))
    val TargetObject: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: CIMContext): ChangeSetMember =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ChangeSetMember (
            BasicElement.parse (context),
            mask (Changeset (), 0),
            mask (PropertiesObject (), 1),
            mask (TargetObject (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A generic container of a version of instance data.
 *
 * The MRID can be used in an audit trail, not in reusable script intended to work with new versions of data.
 * A dataset could be serialized multiple times and in multiple technologies, yet retain the same identity.
 *
 * @param Element Reference to the superclass object.
 * @param description The description is a free human readable text describing or naming the object.
 *        It may be non unique and may not correlate to a naming hierarchy.
 * @param mRID Master resource identifier issued by a model authority.
 *        The mRID is unique within an exchange context. Global uniqueness is easily achieved by using a UUID,  as specified in RFC 4122, for the mRID. The use of UUID is strongly recommended.
 *        For CIMXML data files in RDF syntax conforming to IEC 61970-552 Edition 1, the mRID is mapped to rdf:ID or rdf:about attributes that identify CIM object elements.
 * @param name The name is any free human readable and possibly non unique text naming the object.
 * @param AlternateModel [[ch.ninecode.model.AlternateModel AlternateModel]] The alternate model using the data.
 * @param Profile [[ch.ninecode.model.Profile2 Profile2]] The profiles that describe the contents of the data set and the rules governing the contents of the data set.
 * @group GenericDataSet
 * @groupname GenericDataSet Package GenericDataSet
 * @groupdesc GenericDataSet Contains classes used for generic dataset modelling.
 */
final case class DataSet
(
    Element: BasicElement = null,
    description: String = null,
    mRID: String = null,
    name: String = null,
    AlternateModel: String = null,
    Profile: List[String] = null
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
        implicit val clz: String = DataSet.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DataSet.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DataSet.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (DataSet.fields (position), x))
        emitelem (0, description)
        emitelem (1, mRID)
        emitelem (2, name)
        emitattr (3, AlternateModel)
        emitattrs (4, Profile)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DataSet rdf:ID=\"%s\">\n%s\t</cim:DataSet>".format (id, export_fields)
    }
}

object DataSet
extends
    CIMParseable[DataSet]
{
    override val fields: Array[String] = Array[String] (
        "description",
        "mRID",
        "name",
        "AlternateModel",
        "Profile"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AlternateModel", "AlternateModel", "0..1", "1"),
        CIMRelationship ("Profile", "Profile2", "1..*", "0..*")
    )
    val description: Fielder = parse_element (element (cls, fields(0)))
    val mRID: Fielder = parse_element (element (cls, fields(1)))
    val name: Fielder = parse_element (element (cls, fields(2)))
    val AlternateModel: Fielder = parse_attribute (attribute (cls, fields(3)))
    val Profile: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: CIMContext): DataSet =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DataSet (
            BasicElement.parse (context),
            mask (description (), 0),
            mask (mRID (), 1),
            mask (name (), 2),
            mask (AlternateModel (), 3),
            masks (Profile (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * @group GenericDataSet
 * @groupname GenericDataSet Package GenericDataSet
 * @groupdesc GenericDataSet Contains classes used for generic dataset modelling.
 */
final case class GenericDataSetVersion
(
    Element: BasicElement = null,
    majorVersion: String = null,
    minorVersion: String = null,
    published: String = null
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
        implicit val clz: String = GenericDataSetVersion.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GenericDataSetVersion.fields (position), value)
        emitelem (0, majorVersion)
        emitelem (1, minorVersion)
        emitelem (2, published)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GenericDataSetVersion rdf:ID=\"%s\">\n%s\t</cim:GenericDataSetVersion>".format (id, export_fields)
    }
}

object GenericDataSetVersion
extends
    CIMParseable[GenericDataSetVersion]
{
    override val fields: Array[String] = Array[String] (
        "majorVersion",
        "minorVersion",
        "published"
    )
    val majorVersion: Fielder = parse_element (element (cls, fields(0)))
    val minorVersion: Fielder = parse_element (element (cls, fields(1)))
    val published: Fielder = parse_element (element (cls, fields(2)))

    def parse (context: CIMContext): GenericDataSetVersion =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = GenericDataSetVersion (
            BasicElement.parse (context),
            mask (majorVersion (), 0),
            mask (minorVersion (), 1),
            mask (published (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Instance of a version of a model part.
 *
 * This corresponds to a payload of instance data.
 *
 * @param DataSet [[ch.ninecode.model.DataSet DataSet]] Reference to the superclass object.
 * @param DatasetArg [[ch.ninecode.model.DatasetArg DatasetArg]] The role of a dataset in the context of an operation.
 * @param InstanceSetMember [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Data objects contained in the dataset.
 * @group GenericDataSet
 * @groupname GenericDataSet Package GenericDataSet
 * @groupdesc GenericDataSet Contains classes used for generic dataset modelling.
 */
final case class InstanceSet
(
    DataSet: DataSet = null,
    DatasetArg: List[String] = null,
    InstanceSetMember: List[String] = null
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
    override def sup: DataSet = DataSet

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
        implicit val clz: String = InstanceSet.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (InstanceSet.fields (position), x))
        emitattrs (0, DatasetArg)
        emitattrs (1, InstanceSetMember)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:InstanceSet rdf:ID=\"%s\">\n%s\t</cim:InstanceSet>".format (id, export_fields)
    }
}

object InstanceSet
extends
    CIMParseable[InstanceSet]
{
    override val fields: Array[String] = Array[String] (
        "DatasetArg",
        "InstanceSetMember"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("DatasetArg", "DatasetArg", "0..*", "1"),
        CIMRelationship ("InstanceSetMember", "IdentifiedObject", "0..*", "1")
    )
    val DatasetArg: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val InstanceSetMember: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): InstanceSet =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = InstanceSet (
            DataSet.parse (context),
            masks (DatasetArg (), 0),
            masks (InstanceSetMember (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * An object is to be created in the context.
 *
 * @param ChangeSetMember [[ch.ninecode.model.ChangeSetMember ChangeSetMember]] Reference to the superclass object.
 * @group GenericDataSet
 * @groupname GenericDataSet Package GenericDataSet
 * @groupdesc GenericDataSet Contains classes used for generic dataset modelling.
 */
final case class ObjectCreation
(
    ChangeSetMember: ChangeSetMember = null
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
    override def sup: ChangeSetMember = ChangeSetMember

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
        "\t<cim:ObjectCreation rdf:ID=\"%s\">\n%s\t</cim:ObjectCreation>".format (id, export_fields)
    }
}

object ObjectCreation
extends
    CIMParseable[ObjectCreation]
{

    def parse (context: CIMContext): ObjectCreation =
    {
        val ret = ObjectCreation (
            ChangeSetMember.parse (context)
        )
        ret
    }
}

/**
 * An object is to be deleted in the context.
 *
 * @param ChangeSetMember [[ch.ninecode.model.ChangeSetMember ChangeSetMember]] Reference to the superclass object.
 * @group GenericDataSet
 * @groupname GenericDataSet Package GenericDataSet
 * @groupdesc GenericDataSet Contains classes used for generic dataset modelling.
 */
final case class ObjectDeletion
(
    ChangeSetMember: ChangeSetMember = null
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
    override def sup: ChangeSetMember = ChangeSetMember

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
        "\t<cim:ObjectDeletion rdf:ID=\"%s\">\n%s\t</cim:ObjectDeletion>".format (id, export_fields)
    }
}

object ObjectDeletion
extends
    CIMParseable[ObjectDeletion]
{

    def parse (context: CIMContext): ObjectDeletion =
    {
        val ret = ObjectDeletion (
            ChangeSetMember.parse (context)
        )
        ret
    }
}

/**
 * The object already exists and is to be modified.
 *
 * @param ChangeSetMember [[ch.ninecode.model.ChangeSetMember ChangeSetMember]] Reference to the superclass object.
 * @param ObjectReverseModification [[ch.ninecode.model.ObjectReverseModification ObjectReverseModification]] The data object holding preconditions of updates.
 * @group GenericDataSet
 * @groupname GenericDataSet Package GenericDataSet
 * @groupdesc GenericDataSet Contains classes used for generic dataset modelling.
 */
final case class ObjectModification
(
    ChangeSetMember: ChangeSetMember = null,
    ObjectReverseModification: String = null
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
    override def sup: ChangeSetMember = ChangeSetMember

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
        implicit val clz: String = ObjectModification.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ObjectModification.fields (position), value)
        emitattr (0, ObjectReverseModification)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ObjectModification rdf:ID=\"%s\">\n%s\t</cim:ObjectModification>".format (id, export_fields)
    }
}

object ObjectModification
extends
    CIMParseable[ObjectModification]
{
    override val fields: Array[String] = Array[String] (
        "ObjectReverseModification"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ObjectReverseModification", "ObjectReverseModification", "0..1", "0..1")
    )
    val ObjectReverseModification: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): ObjectModification =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ObjectModification (
            ChangeSetMember.parse (context),
            mask (ObjectReverseModification (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Used to specify precondition properties for a preconditioned update.
 *
 * @param ChangeSetMember [[ch.ninecode.model.ChangeSetMember ChangeSetMember]] Reference to the superclass object.
 * @param ObjectModification [[ch.ninecode.model.ObjectModification ObjectModification]] The associated data object representing the update.
 *        Normally the associaiton is specifed, but in the case of a proxy object where the association is removed, we might not reference any data object as it would only reference a proxy data object with no associations.
 * @group GenericDataSet
 * @groupname GenericDataSet Package GenericDataSet
 * @groupdesc GenericDataSet Contains classes used for generic dataset modelling.
 */
final case class ObjectReverseModification
(
    ChangeSetMember: ChangeSetMember = null,
    ObjectModification: String = null
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
    override def sup: ChangeSetMember = ChangeSetMember

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
        implicit val clz: String = ObjectReverseModification.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ObjectReverseModification.fields (position), value)
        emitattr (0, ObjectModification)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ObjectReverseModification rdf:ID=\"%s\">\n%s\t</cim:ObjectReverseModification>".format (id, export_fields)
    }
}

object ObjectReverseModification
extends
    CIMParseable[ObjectReverseModification]
{
    override val fields: Array[String] = Array[String] (
        "ObjectModification"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ObjectModification", "ObjectModification", "0..1", "0..1")
    )
    val ObjectModification: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): ObjectReverseModification =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ObjectReverseModification (
            ChangeSetMember.parse (context),
            mask (ObjectModification (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Describes the existence of a profile.
 *
 * The MRID is usually defined as a static value by the document or artifact that defines the contents of the profile and the rules for using the profile.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param DataSet [[ch.ninecode.model.DataSet DataSet]] The data sets that make use of the profile.
 * @group GenericDataSet
 * @groupname GenericDataSet Package GenericDataSet
 * @groupdesc GenericDataSet Contains classes used for generic dataset modelling.
 */
final case class Profile2
(
    IdentifiedObject: IdentifiedObject = null,
    DataSet: List[String] = null
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
        implicit val clz: String = Profile2.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Profile2.fields (position), x))
        emitattrs (0, DataSet)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Profile2 rdf:ID=\"%s\">\n%s\t</cim:Profile2>".format (id, export_fields)
    }
}

object Profile2
extends
    CIMParseable[Profile2]
{
    override val fields: Array[String] = Array[String] (
        "DataSet"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("DataSet", "DataSet", "0..*", "1..*")
    )
    val DataSet: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): Profile2 =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Profile2 (
            IdentifiedObject.parse (context),
            masks (DataSet (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _GenericDataSet
{
    def register: List[CIMClassInfo] =
    {
        List (
            ChangeSet.register,
            ChangeSetMember.register,
            DataSet.register,
            GenericDataSetVersion.register,
            InstanceSet.register,
            ObjectCreation.register,
            ObjectDeletion.register,
            ObjectModification.register,
            ObjectReverseModification.register,
            Profile2.register
        )
    }
}