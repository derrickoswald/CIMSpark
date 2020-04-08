package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**

 * @group NetworkModelProjects
 * @groupname NetworkModelProjects Package NetworkModelProjects
 * @groupdesc NetworkModelProjects Defining meta-data for a change set in the functional Power System model.
 */
final case class AnnotatedProjectDependency
(
    override val sup: IdentifiedObject = null,
    dependencyType: String = null,
    DependentOnStage: String = null,
    DependingStage: String = null
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
    def IdentifiedObject: IdentifiedObject = sup
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
        implicit val clz: String = AnnotatedProjectDependency.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AnnotatedProjectDependency.fields (position), value)
        emitattr (0, dependencyType)
        emitattr (1, DependentOnStage)
        emitattr (2, DependingStage)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AnnotatedProjectDependency rdf:ID=\"%s\">\n%s\t</cim:AnnotatedProjectDependency>".format (id, export_fields)
    }
}

object AnnotatedProjectDependency
extends
    Parseable[AnnotatedProjectDependency]
{
    override val fields: Array[String] = Array[String] (
        "dependencyType",
        "DependentOnStage",
        "DependingStage"
    )
    override val relations: List[Relationship] = List (
        Relationship ("DependentOnStage", "NetworkModelProjectStage", "1", "0..1"),
        Relationship ("DependingStage", "NetworkModelProjectStage", "1", "0..*")
    )
    val dependencyType: Fielder = parse_attribute (attribute (cls, fields(0)))
    val DependentOnStage: Fielder = parse_attribute (attribute (cls, fields(1)))
    val DependingStage: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): AnnotatedProjectDependency =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AnnotatedProjectDependency (
            IdentifiedObject.parse (context),
            mask (dependencyType (), 0),
            mask (DependentOnStage (), 1),
            mask (DependingStage (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group NetworkModelProjects
 * @groupname NetworkModelProjects Package NetworkModelProjects
 * @groupdesc NetworkModelProjects Defining meta-data for a change set in the functional Power System model.
 */
final case class CurrentState
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
    def IdentifiedObject: IdentifiedObject = sup
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
        "\t<cim:CurrentState rdf:ID=\"%s\">\n%s\t</cim:CurrentState>".format (id, export_fields)
    }
}

object CurrentState
extends
    Parseable[CurrentState]
{

    def parse (context: Context): CurrentState =
    {
        val ret = CurrentState (
            IdentifiedObject.parse (context)
        )
        ret
    }
}

/**
 * A set of statements describing the changes in the network model.
 *
 * The statement is defined in the incremental model.
 *
 * @param sup Reference to the superclass object.
 * @group NetworkModelProjects
 * @groupname NetworkModelProjects Package NetworkModelProjects
 * @groupdesc NetworkModelProjects Defining meta-data for a change set in the functional Power System model.
 */
final case class DifferentialModel
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
        "\t<cim:DifferentialModel rdf:ID=\"%s\">\n%s\t</cim:DifferentialModel>".format (id, export_fields)
    }
}

object DifferentialModel
extends
    Parseable[DifferentialModel]
{

    def parse (context: Context): DifferentialModel =
    {
        val ret = DifferentialModel (
            BasicElement.parse (context)
        )
        ret
    }
}

/**
 * A grouping of network model change descriptions.
 *
 * Primarily used to organize the phases of an overall project.
 *
 * @param sup [[ch.ninecode.model.NetworkModelProjectComponent NetworkModelProjectComponent]] Reference to the superclass object.
 * @param ContainedProject [[ch.ninecode.model.NetworkModelProjectComponent NetworkModelProjectComponent]] Projects that are included in this parent project.
 * @group NetworkModelProjects
 * @groupname NetworkModelProjects Package NetworkModelProjects
 * @groupdesc NetworkModelProjects Defining meta-data for a change set in the functional Power System model.
 */
final case class NetworkModelProject
(
    override val sup: NetworkModelProjectComponent = null,
    ContainedProject: List[String] = null
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
    def NetworkModelProjectComponent: NetworkModelProjectComponent = sup
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
        implicit val clz: String = NetworkModelProject.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (NetworkModelProject.fields (position), x))
        emitattrs (0, ContainedProject)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:NetworkModelProject rdf:ID=\"%s\">\n%s\t</cim:NetworkModelProject>".format (id, export_fields)
    }
}

object NetworkModelProject
extends
    Parseable[NetworkModelProject]
{
    override val fields: Array[String] = Array[String] (
        "ContainedProject"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ContainedProject", "NetworkModelProjectComponent", "0..*", "1")
    )
    val ContainedProject: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): NetworkModelProject =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = NetworkModelProject (
            NetworkModelProjectComponent.parse (context),
            masks (ContainedProject (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group NetworkModelProjects
 * @groupname NetworkModelProjects Package NetworkModelProjects
 * @groupdesc NetworkModelProjects Defining meta-data for a change set in the functional Power System model.
 */
final case class NetworkModelProject2
(
    override val sup: NetworkModelProjectComponent2 = null,
    Child: List[String] = null
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
    def NetworkModelProjectComponent2: NetworkModelProjectComponent2 = sup
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
        implicit val clz: String = NetworkModelProject2.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (NetworkModelProject2.fields (position), x))
        emitattrs (0, Child)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:NetworkModelProject2 rdf:ID=\"%s\">\n%s\t</cim:NetworkModelProject2>".format (id, export_fields)
    }
}

object NetworkModelProject2
extends
    Parseable[NetworkModelProject2]
{
    override val fields: Array[String] = Array[String] (
        "Child"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Child", "NetworkModelProjectComponent2", "0..*", "0..1")
    )
    val Child: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): NetworkModelProject2 =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = NetworkModelProject2 (
            NetworkModelProjectComponent2.parse (context),
            masks (Child (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Network model project change described by versions of an associated change set.
 *
 * Has persistent identity over multiple versions of the associated change set.
 *
 * @param sup [[ch.ninecode.model.NetworkModelProjectComponent NetworkModelProjectComponent]] Reference to the superclass object.
 * @param NetworkModelProjectChangeVersion [[ch.ninecode.model.NetworkModelProjectChangeVersion NetworkModelProjectChangeVersion]] A specific version of the network model project change.
 * @group NetworkModelProjects
 * @groupname NetworkModelProjects Package NetworkModelProjects
 * @groupdesc NetworkModelProjects Defining meta-data for a change set in the functional Power System model.
 */
final case class NetworkModelProjectChange
(
    override val sup: NetworkModelProjectComponent = null,
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
    def NetworkModelProjectComponent: NetworkModelProjectComponent = sup
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
        implicit val clz: String = NetworkModelProjectChange.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (NetworkModelProjectChange.fields (position), x))
        emitattrs (0, NetworkModelProjectChangeVersion)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:NetworkModelProjectChange rdf:ID=\"%s\">\n%s\t</cim:NetworkModelProjectChange>".format (id, export_fields)
    }
}

object NetworkModelProjectChange
extends
    Parseable[NetworkModelProjectChange]
{
    override val fields: Array[String] = Array[String] (
        "NetworkModelProjectChangeVersion"
    )
    override val relations: List[Relationship] = List (
        Relationship ("NetworkModelProjectChangeVersion", "NetworkModelProjectChangeVersion", "1..*", "1")
    )
    val NetworkModelProjectChangeVersion: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): NetworkModelProjectChange =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = NetworkModelProjectChange (
            NetworkModelProjectComponent.parse (context),
            masks (NetworkModelProjectChangeVersion (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Describes the status and the planned implementation of the associated change set into the as-built model.
 *
 * New instances of this class with new identity are instantiated upon changes to the content of this class or changes to the associated change set.  Instances of this class are considered immutable.  The case audit trail can reference this immutable data to exactly reproduce a case.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param comment A user provided comment describing the changes in this version from the previous version.
 * @param effectiveDateTime The date/time the change set is included in the model.
 * @param timeStamp The date/time this version was finalized and thus made immutable.
 * @param ChangeSet [[ch.ninecode.model.ChangeSet ChangeSet]] The details of model changes for this project.
 *        The change set should have a new identifier if it changes.
 * @param NetworkModelProjectChange [[ch.ninecode.model.NetworkModelProjectChange NetworkModelProjectChange]] The persistent network model project change to which this version applies.
 * @param NetworkModelProjectState [[ch.ninecode.model.NetworkModelProjectState NetworkModelProjectState]] The state of this network model project version.
 * @param SupercededBy [[ch.ninecode.model.NetworkModelProjectChangeVersion NetworkModelProjectChangeVersion]] The project version that will supercede this project version.
 * @param Supercedes [[ch.ninecode.model.NetworkModelProjectChangeVersion NetworkModelProjectChangeVersion]] Project version that is being superceded.
 * @group NetworkModelProjects
 * @groupname NetworkModelProjects Package NetworkModelProjects
 * @groupdesc NetworkModelProjects Defining meta-data for a change set in the functional Power System model.
 */
final case class NetworkModelProjectChangeVersion
(
    override val sup: IdentifiedObject = null,
    comment: String = null,
    effectiveDateTime: String = null,
    timeStamp: String = null,
    ChangeSet: String = null,
    NetworkModelProjectChange: String = null,
    NetworkModelProjectState: String = null,
    SupercededBy: String = null,
    Supercedes: String = null
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
    def IdentifiedObject: IdentifiedObject = sup
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
        implicit val clz: String = NetworkModelProjectChangeVersion.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (NetworkModelProjectChangeVersion.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (NetworkModelProjectChangeVersion.fields (position), value)
        emitelem (0, comment)
        emitelem (1, effectiveDateTime)
        emitelem (2, timeStamp)
        emitattr (3, ChangeSet)
        emitattr (4, NetworkModelProjectChange)
        emitattr (5, NetworkModelProjectState)
        emitattr (6, SupercededBy)
        emitattr (7, Supercedes)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:NetworkModelProjectChangeVersion rdf:ID=\"%s\">\n%s\t</cim:NetworkModelProjectChangeVersion>".format (id, export_fields)
    }
}

object NetworkModelProjectChangeVersion
extends
    Parseable[NetworkModelProjectChangeVersion]
{
    override val fields: Array[String] = Array[String] (
        "comment",
        "effectiveDateTime",
        "timeStamp",
        "ChangeSet",
        "NetworkModelProjectChange",
        "NetworkModelProjectState",
        "SupercededBy",
        "Supercedes"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ChangeSet", "ChangeSet", "0..1", "0..*"),
        Relationship ("NetworkModelProjectChange", "NetworkModelProjectChange", "1", "1..*"),
        Relationship ("NetworkModelProjectState", "NetworkModelProjectState", "0..1", "0..*"),
        Relationship ("SupercededBy", "NetworkModelProjectChangeVersion", "0..1", "0..1"),
        Relationship ("Supercedes", "NetworkModelProjectChangeVersion", "0..1", "0..1")
    )
    val comment: Fielder = parse_element (element (cls, fields(0)))
    val effectiveDateTime: Fielder = parse_element (element (cls, fields(1)))
    val timeStamp: Fielder = parse_element (element (cls, fields(2)))
    val ChangeSet: Fielder = parse_attribute (attribute (cls, fields(3)))
    val NetworkModelProjectChange: Fielder = parse_attribute (attribute (cls, fields(4)))
    val NetworkModelProjectState: Fielder = parse_attribute (attribute (cls, fields(5)))
    val SupercededBy: Fielder = parse_attribute (attribute (cls, fields(6)))
    val Supercedes: Fielder = parse_attribute (attribute (cls, fields(7)))

    def parse (context: Context): NetworkModelProjectChangeVersion =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = NetworkModelProjectChangeVersion (
            IdentifiedObject.parse (context),
            mask (comment (), 0),
            mask (effectiveDateTime (), 1),
            mask (timeStamp (), 2),
            mask (ChangeSet (), 3),
            mask (NetworkModelProjectChange (), 4),
            mask (NetworkModelProjectState (), 5),
            mask (SupercededBy (), 6),
            mask (Supercedes (), 7)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group NetworkModelProjects
 * @groupname NetworkModelProjects Package NetworkModelProjects
 * @groupdesc NetworkModelProjects Defining meta-data for a change set in the functional Power System model.
 */
final case class NetworkModelProjectCollection
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
        "\t<cim:NetworkModelProjectCollection rdf:ID=\"%s\">\n%s\t</cim:NetworkModelProjectCollection>".format (id, export_fields)
    }
}

object NetworkModelProjectCollection
extends
    Parseable[NetworkModelProjectCollection]
{

    def parse (context: Context): NetworkModelProjectCollection =
    {
        val ret = NetworkModelProjectCollection (
            BasicElement.parse (context)
        )
        ret
    }
}

/**
 * Abstract class for both a network model project and network model change.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param ContainingProject [[ch.ninecode.model.NetworkModelProject NetworkModelProject]] The parent project of this project.
 * @param ProjectARelationships [[ch.ninecode.model.NetworkModelProjectRelationship NetworkModelProjectRelationship]] <em>undocumented</em>
 * @param ProjectBRelationships [[ch.ninecode.model.NetworkModelProjectRelationship NetworkModelProjectRelationship]] <em>undocumented</em>
 * @group NetworkModelProjects
 * @groupname NetworkModelProjects Package NetworkModelProjects
 * @groupdesc NetworkModelProjects Defining meta-data for a change set in the functional Power System model.
 */
final case class NetworkModelProjectComponent
(
    override val sup: IdentifiedObject = null,
    ContainingProject: String = null,
    ProjectARelationships: List[String] = null,
    ProjectBRelationships: List[String] = null
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
    def IdentifiedObject: IdentifiedObject = sup
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
        implicit val clz: String = NetworkModelProjectComponent.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (NetworkModelProjectComponent.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (NetworkModelProjectComponent.fields (position), x))
        emitattr (0, ContainingProject)
        emitattrs (1, ProjectARelationships)
        emitattrs (2, ProjectBRelationships)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:NetworkModelProjectComponent rdf:ID=\"%s\">\n%s\t</cim:NetworkModelProjectComponent>".format (id, export_fields)
    }
}

object NetworkModelProjectComponent
extends
    Parseable[NetworkModelProjectComponent]
{
    override val fields: Array[String] = Array[String] (
        "ContainingProject",
        "ProjectARelationships",
        "ProjectBRelationships"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ContainingProject", "NetworkModelProject", "1", "0..*"),
        Relationship ("ProjectARelationships", "NetworkModelProjectRelationship", "0..*", "1"),
        Relationship ("ProjectBRelationships", "NetworkModelProjectRelationship", "0..*", "1")
    )
    val ContainingProject: Fielder = parse_attribute (attribute (cls, fields(0)))
    val ProjectARelationships: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val ProjectBRelationships: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: Context): NetworkModelProjectComponent =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = NetworkModelProjectComponent (
            IdentifiedObject.parse (context),
            mask (ContainingProject (), 0),
            masks (ProjectARelationships (), 1),
            masks (ProjectBRelationships (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group NetworkModelProjects
 * @groupname NetworkModelProjects Package NetworkModelProjects
 * @groupdesc NetworkModelProjects Defining meta-data for a change set in the functional Power System model.
 */
final case class NetworkModelProjectComponent2
(
    override val sup: IdentifiedObject = null,
    closed: String = null,
    created: String = null,
    updated: String = null,
    version: Int = 0,
    Parent: String = null
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
    def IdentifiedObject: IdentifiedObject = sup
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
        implicit val clz: String = NetworkModelProjectComponent2.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (NetworkModelProjectComponent2.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (NetworkModelProjectComponent2.fields (position), value)
        emitelem (0, closed)
        emitelem (1, created)
        emitelem (2, updated)
        emitelem (3, version)
        emitattr (4, Parent)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:NetworkModelProjectComponent2 rdf:ID=\"%s\">\n%s\t</cim:NetworkModelProjectComponent2>".format (id, export_fields)
    }
}

object NetworkModelProjectComponent2
extends
    Parseable[NetworkModelProjectComponent2]
{
    override val fields: Array[String] = Array[String] (
        "closed",
        "created",
        "updated",
        "version",
        "Parent"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Parent", "NetworkModelProject2", "0..1", "0..*")
    )
    val closed: Fielder = parse_element (element (cls, fields(0)))
    val created: Fielder = parse_element (element (cls, fields(1)))
    val updated: Fielder = parse_element (element (cls, fields(2)))
    val version: Fielder = parse_element (element (cls, fields(3)))
    val Parent: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): NetworkModelProjectComponent2 =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = NetworkModelProjectComponent2 (
            IdentifiedObject.parse (context),
            mask (closed (), 0),
            mask (created (), 1),
            mask (updated (), 2),
            toInteger (mask (version (), 3)),
            mask (Parent (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group NetworkModelProjects
 * @groupname NetworkModelProjects Package NetworkModelProjects
 * @groupdesc NetworkModelProjects Defining meta-data for a change set in the functional Power System model.
 */
final case class NetworkModelProjectDocument
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
        "\t<cim:NetworkModelProjectDocument rdf:ID=\"%s\">\n%s\t</cim:NetworkModelProjectDocument>".format (id, export_fields)
    }
}

object NetworkModelProjectDocument
extends
    Parseable[NetworkModelProjectDocument]
{

    def parse (context: Context): NetworkModelProjectDocument =
    {
        val ret = NetworkModelProjectDocument (
            BasicElement.parse (context)
        )
        ret
    }
}

/**
 * A relationship that assists humans and software building cases by assembling project changes in the correct sequence.
 *
 * This class may be specialized to create specific types of relationships.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param ProjectA [[ch.ninecode.model.NetworkModelProjectComponent NetworkModelProjectComponent]] <em>undocumented</em>
 * @param ProjectB [[ch.ninecode.model.NetworkModelProjectComponent NetworkModelProjectComponent]] <em>undocumented</em>
 * @group NetworkModelProjects
 * @groupname NetworkModelProjects Package NetworkModelProjects
 * @groupdesc NetworkModelProjects Defining meta-data for a change set in the functional Power System model.
 */
final case class NetworkModelProjectRelationship
(
    override val sup: IdentifiedObject = null,
    ProjectA: String = null,
    ProjectB: String = null
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
    def IdentifiedObject: IdentifiedObject = sup
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
        implicit val clz: String = NetworkModelProjectRelationship.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (NetworkModelProjectRelationship.fields (position), value)
        emitattr (0, ProjectA)
        emitattr (1, ProjectB)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:NetworkModelProjectRelationship rdf:ID=\"%s\">\n%s\t</cim:NetworkModelProjectRelationship>".format (id, export_fields)
    }
}

object NetworkModelProjectRelationship
extends
    Parseable[NetworkModelProjectRelationship]
{
    override val fields: Array[String] = Array[String] (
        "ProjectA",
        "ProjectB"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ProjectA", "NetworkModelProjectComponent", "1", "0..*"),
        Relationship ("ProjectB", "NetworkModelProjectComponent", "1", "0..*")
    )
    val ProjectA: Fielder = parse_attribute (attribute (cls, fields(0)))
    val ProjectB: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): NetworkModelProjectRelationship =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = NetworkModelProjectRelationship (
            IdentifiedObject.parse (context),
            mask (ProjectA (), 0),
            mask (ProjectB (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group NetworkModelProjects
 * @groupname NetworkModelProjects Package NetworkModelProjects
 * @groupdesc NetworkModelProjects Defining meta-data for a change set in the functional Power System model.
 */
final case class NetworkModelProjectStage
(
    override val sup: NetworkModelProjectComponent2 = null,
    changesetVersion: Int = 0,
    commissionedDate: String = null,
    plannedCommissionedDate: String = null,
    ChangeSets: List[String] = null,
    DenpendecyDependingStage: List[String] = null,
    DependencyDependentOnStage: String = null
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
    def NetworkModelProjectComponent2: NetworkModelProjectComponent2 = sup
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
        implicit val clz: String = NetworkModelProjectStage.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (NetworkModelProjectStage.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (NetworkModelProjectStage.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (NetworkModelProjectStage.fields (position), x))
        emitelem (0, changesetVersion)
        emitelem (1, commissionedDate)
        emitelem (2, plannedCommissionedDate)
        emitattrs (3, ChangeSets)
        emitattrs (4, DenpendecyDependingStage)
        emitattr (5, DependencyDependentOnStage)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:NetworkModelProjectStage rdf:ID=\"%s\">\n%s\t</cim:NetworkModelProjectStage>".format (id, export_fields)
    }
}

object NetworkModelProjectStage
extends
    Parseable[NetworkModelProjectStage]
{
    override val fields: Array[String] = Array[String] (
        "changesetVersion",
        "commissionedDate",
        "plannedCommissionedDate",
        "ChangeSets",
        "DenpendecyDependingStage",
        "DependencyDependentOnStage"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ChangeSets", "ChangeSet", "1..*", "0..1"),
        Relationship ("DenpendecyDependingStage", "AnnotatedProjectDependency", "0..*", "1"),
        Relationship ("DependencyDependentOnStage", "AnnotatedProjectDependency", "0..1", "1")
    )
    val changesetVersion: Fielder = parse_element (element (cls, fields(0)))
    val commissionedDate: Fielder = parse_element (element (cls, fields(1)))
    val plannedCommissionedDate: Fielder = parse_element (element (cls, fields(2)))
    val ChangeSets: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val DenpendecyDependingStage: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val DependencyDependentOnStage: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: Context): NetworkModelProjectStage =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = NetworkModelProjectStage (
            NetworkModelProjectComponent2.parse (context),
            toInteger (mask (changesetVersion (), 0)),
            mask (commissionedDate (), 1),
            mask (plannedCommissionedDate (), 2),
            masks (ChangeSets (), 3),
            masks (DenpendecyDependingStage (), 4),
            mask (DependencyDependentOnStage (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A network model project version state.
 *
 * States are agreed upon by the exchange community.  Examples are "approved", "proposed", "withdrawn", "committed" etc.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param NetworkModelProjectChangeVersion [[ch.ninecode.model.NetworkModelProjectChangeVersion NetworkModelProjectChangeVersion]] The change versions that are at this state.
 * @group NetworkModelProjects
 * @groupname NetworkModelProjects Package NetworkModelProjects
 * @groupdesc NetworkModelProjects Defining meta-data for a change set in the functional Power System model.
 */
final case class NetworkModelProjectState
(
    override val sup: IdentifiedObject = null,
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
    def IdentifiedObject: IdentifiedObject = sup
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
        implicit val clz: String = NetworkModelProjectState.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (NetworkModelProjectState.fields (position), x))
        emitattrs (0, NetworkModelProjectChangeVersion)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:NetworkModelProjectState rdf:ID=\"%s\">\n%s\t</cim:NetworkModelProjectState>".format (id, export_fields)
    }
}

object NetworkModelProjectState
extends
    Parseable[NetworkModelProjectState]
{
    override val fields: Array[String] = Array[String] (
        "NetworkModelProjectChangeVersion"
    )
    override val relations: List[Relationship] = List (
        Relationship ("NetworkModelProjectChangeVersion", "NetworkModelProjectChangeVersion", "0..*", "0..1")
    )
    val NetworkModelProjectChangeVersion: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): NetworkModelProjectState =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = NetworkModelProjectState (
            IdentifiedObject.parse (context),
            masks (NetworkModelProjectChangeVersion (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Represent the base lifecycle of a functional model change that could be a construction of new elements.
 *
 * @param sup Reference to the superclass object.
 * @param cancelled The date the Power System Project is in cancelled stage.
 * @param committed The date Power System Project is in committed stage.
 * @param inBuild The date Power System Project is in build stage.
 * @param inPlan The date Power System Project is in planning stage.
 * @group NetworkModelProjects
 * @groupname NetworkModelProjects Package NetworkModelProjects
 * @groupdesc NetworkModelProjects Defining meta-data for a change set in the functional Power System model.
 */
final case class PowerSystemProjectLifecycleToBeDeleted
(
    override val sup: BasicElement = null,
    cancelled: String = null,
    committed: String = null,
    inBuild: String = null,
    inPlan: String = null
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
        implicit val clz: String = PowerSystemProjectLifecycleToBeDeleted.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PowerSystemProjectLifecycleToBeDeleted.fields (position), value)
        emitelem (0, cancelled)
        emitelem (1, committed)
        emitelem (2, inBuild)
        emitelem (3, inPlan)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PowerSystemProjectLifecycleToBeDeleted rdf:ID=\"%s\">\n%s\t</cim:PowerSystemProjectLifecycleToBeDeleted>".format (id, export_fields)
    }
}

object PowerSystemProjectLifecycleToBeDeleted
extends
    Parseable[PowerSystemProjectLifecycleToBeDeleted]
{
    override val fields: Array[String] = Array[String] (
        "cancelled",
        "committed",
        "inBuild",
        "inPlan"
    )
    val cancelled: Fielder = parse_element (element (cls, fields(0)))
    val committed: Fielder = parse_element (element (cls, fields(1)))
    val inBuild: Fielder = parse_element (element (cls, fields(2)))
    val inPlan: Fielder = parse_element (element (cls, fields(3)))

    def parse (context: Context): PowerSystemProjectLifecycleToBeDeleted =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PowerSystemProjectLifecycleToBeDeleted (
            BasicElement.parse (context),
            mask (cancelled (), 0),
            mask (committed (), 1),
            mask (inBuild (), 2),
            mask (inPlan (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Project B is an alternative to project A.
 *
 * Project A is the primary alternative.
 * Multiple project alternatives should not be selected into a single network study case.
 *
 * @param sup [[ch.ninecode.model.NetworkModelProjectRelationship NetworkModelProjectRelationship]] Reference to the superclass object.
 * @group NetworkModelProjects
 * @groupname NetworkModelProjects Package NetworkModelProjects
 * @groupdesc NetworkModelProjects Defining meta-data for a change set in the functional Power System model.
 */
final case class ProjectAlternative
(
    override val sup: NetworkModelProjectRelationship = null
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
    def NetworkModelProjectRelationship: NetworkModelProjectRelationship = sup
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
        "\t<cim:ProjectAlternative rdf:ID=\"%s\">\n%s\t</cim:ProjectAlternative>".format (id, export_fields)
    }
}

object ProjectAlternative
extends
    Parseable[ProjectAlternative]
{

    def parse (context: Context): ProjectAlternative =
    {
        val ret = ProjectAlternative (
            NetworkModelProjectRelationship.parse (context)
        )
        ret
    }
}

/**
 * Project A change sets should be applied before Project B during case creation.
 *
 * @param sup [[ch.ninecode.model.NetworkModelProjectRelationship NetworkModelProjectRelationship]] Reference to the superclass object.
 * @group NetworkModelProjects
 * @groupname NetworkModelProjects Package NetworkModelProjects
 * @groupdesc NetworkModelProjects Defining meta-data for a change set in the functional Power System model.
 */
final case class ProjectDependency
(
    override val sup: NetworkModelProjectRelationship = null
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
    def NetworkModelProjectRelationship: NetworkModelProjectRelationship = sup
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
        "\t<cim:ProjectDependency rdf:ID=\"%s\">\n%s\t</cim:ProjectDependency>".format (id, export_fields)
    }
}

object ProjectDependency
extends
    Parseable[ProjectDependency]
{

    def parse (context: Context): ProjectDependency =
    {
        val ret = ProjectDependency (
            NetworkModelProjectRelationship.parse (context)
        )
        ret
    }
}

private[ninecode] object _NetworkModelProjects
{
    def register: List[ClassInfo] =
    {
        List (
            AnnotatedProjectDependency.register,
            CurrentState.register,
            DifferentialModel.register,
            NetworkModelProject.register,
            NetworkModelProject2.register,
            NetworkModelProjectChange.register,
            NetworkModelProjectChangeVersion.register,
            NetworkModelProjectCollection.register,
            NetworkModelProjectComponent.register,
            NetworkModelProjectComponent2.register,
            NetworkModelProjectDocument.register,
            NetworkModelProjectRelationship.register,
            NetworkModelProjectStage.register,
            NetworkModelProjectState.register,
            PowerSystemProjectLifecycleToBeDeleted.register,
            ProjectAlternative.register,
            ProjectDependency.register
        )
    }
}