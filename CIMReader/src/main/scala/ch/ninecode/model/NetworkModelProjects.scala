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
 * @group NetworkModelProjects
 * @groupname NetworkModelProjects Package NetworkModelProjects
 * @groupdesc NetworkModelProjects Defining meta-data for a change set in the functional Power System model.
 */
final case class AnnotatedProjectDependency
(
    IdentifiedObject: IdentifiedObject = null,
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
        CIMParseable[AnnotatedProjectDependency]
{
    override val fields: Array[String] = Array [String](
        "dependencyType",
        "DependentOnStage",
        "DependingStage"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("DependentOnStage", "NetworkModelProjectStage", "1", "0..1"),
        CIMRelationship ("DependingStage", "NetworkModelProjectStage", "1", "0..*")
    )
    val dependencyType: Fielder = parse_attribute (attribute (cls, fields (0)))
    val DependentOnStage: Fielder = parse_attribute (attribute (cls, fields (1)))
    val DependingStage: Fielder = parse_attribute (attribute (cls, fields (2)))

    def parse (context: CIMContext): AnnotatedProjectDependency =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = AnnotatedProjectDependency (
            IdentifiedObject.parse (context),
            mask (dependencyType (), 0),
            mask (DependentOnStage (), 1),
            mask (DependingStage (), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[AnnotatedProjectDependency] = AnnotatedProjectDependencySerializer
}

object AnnotatedProjectDependencySerializer extends CIMSerializer[AnnotatedProjectDependency]
{
    def write (kryo: Kryo, output: Output, obj: AnnotatedProjectDependency): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.dependencyType),
            () => output.writeString (obj.DependentOnStage),
            () => output.writeString (obj.DependingStage)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AnnotatedProjectDependency]): AnnotatedProjectDependency =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf [IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = AnnotatedProjectDependency (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group NetworkModelProjects
 * @groupname NetworkModelProjects Package NetworkModelProjects
 * @groupdesc NetworkModelProjects Defining meta-data for a change set in the functional Power System model.
 */
final case class CurrentState
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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[CurrentState]
{

    def parse (context: CIMContext): CurrentState =
    {
        val ret = CurrentState (
            IdentifiedObject.parse (context)
        )
        ret
    }

    def serializer: Serializer[CurrentState] = CurrentStateSerializer
}

object CurrentStateSerializer extends CIMSerializer[CurrentState]
{
    def write (kryo: Kryo, output: Output, obj: CurrentState): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CurrentState]): CurrentState =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf [IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = CurrentState (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A set of statements describing the changes in the network model.
 *
 * The statement is defined in the incremental model.
 *
 * @param Element Reference to the superclass object.
 * @group NetworkModelProjects
 * @groupname NetworkModelProjects Package NetworkModelProjects
 * @groupdesc NetworkModelProjects Defining meta-data for a change set in the functional Power System model.
 */
final case class DifferentialModel
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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[DifferentialModel]
{

    def parse (context: CIMContext): DifferentialModel =
    {
        val ret = DifferentialModel (
            BasicElement.parse (context)
        )
        ret
    }

    def serializer: Serializer[DifferentialModel] = DifferentialModelSerializer
}

object DifferentialModelSerializer extends CIMSerializer[DifferentialModel]
{
    def write (kryo: Kryo, output: Output, obj: DifferentialModel): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf [BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DifferentialModel]): DifferentialModel =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf [BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = DifferentialModel (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A grouping of network model change descriptions.
 *
 * Primarily used to organize the phases of an overall project.
 *
 * @param NetworkModelProjectComponent [[ch.ninecode.model.NetworkModelProjectComponent NetworkModelProjectComponent]] Reference to the superclass object.
 * @param ContainedProject             [[ch.ninecode.model.NetworkModelProjectComponent NetworkModelProjectComponent]] Projects that are included in this parent project.
 * @group NetworkModelProjects
 * @groupname NetworkModelProjects Package NetworkModelProjects
 * @groupdesc NetworkModelProjects Defining meta-data for a change set in the functional Power System model.
 */
final case class NetworkModelProject
(
    NetworkModelProjectComponent: NetworkModelProjectComponent = null,
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
    override def sup: NetworkModelProjectComponent = NetworkModelProjectComponent

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
        CIMParseable[NetworkModelProject]
{
    override val fields: Array[String] = Array [String](
        "ContainedProject"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ContainedProject", "NetworkModelProjectComponent", "0..*", "1")
    )
    val ContainedProject: FielderMultiple = parse_attributes (attribute (cls, fields (0)))

    def parse (context: CIMContext): NetworkModelProject =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = NetworkModelProject (
            NetworkModelProjectComponent.parse (context),
            masks (ContainedProject (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[NetworkModelProject] = NetworkModelProjectSerializer
}

object NetworkModelProjectSerializer extends CIMSerializer[NetworkModelProject]
{
    def write (kryo: Kryo, output: Output, obj: NetworkModelProject): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.ContainedProject, output)
        )
        NetworkModelProjectComponentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[NetworkModelProject]): NetworkModelProject =
    {
        val parent = NetworkModelProjectComponentSerializer.read (kryo, input, classOf [NetworkModelProjectComponent])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = NetworkModelProject (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group NetworkModelProjects
 * @groupname NetworkModelProjects Package NetworkModelProjects
 * @groupdesc NetworkModelProjects Defining meta-data for a change set in the functional Power System model.
 */
final case class NetworkModelProject2
(
    NetworkModelProjectComponent2: NetworkModelProjectComponent2 = null,
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
    override def sup: NetworkModelProjectComponent2 = NetworkModelProjectComponent2

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
        CIMParseable[NetworkModelProject2]
{
    override val fields: Array[String] = Array [String](
        "Child"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Child", "NetworkModelProjectComponent2", "0..*", "0..1")
    )
    val Child: FielderMultiple = parse_attributes (attribute (cls, fields (0)))

    def parse (context: CIMContext): NetworkModelProject2 =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = NetworkModelProject2 (
            NetworkModelProjectComponent2.parse (context),
            masks (Child (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[NetworkModelProject2] = NetworkModelProject2Serializer
}

object NetworkModelProject2Serializer extends CIMSerializer[NetworkModelProject2]
{
    def write (kryo: Kryo, output: Output, obj: NetworkModelProject2): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.Child, output)
        )
        NetworkModelProjectComponent2Serializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[NetworkModelProject2]): NetworkModelProject2 =
    {
        val parent = NetworkModelProjectComponent2Serializer.read (kryo, input, classOf [NetworkModelProjectComponent2])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = NetworkModelProject2 (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Network model project change described by versions of an associated change set.
 *
 * Has persistent identity over multiple versions of the associated change set.
 *
 * @param NetworkModelProjectComponent     [[ch.ninecode.model.NetworkModelProjectComponent NetworkModelProjectComponent]] Reference to the superclass object.
 * @param NetworkModelProjectChangeVersion [[ch.ninecode.model.NetworkModelProjectChangeVersion NetworkModelProjectChangeVersion]] A specific version of the network model project change.
 * @group NetworkModelProjects
 * @groupname NetworkModelProjects Package NetworkModelProjects
 * @groupdesc NetworkModelProjects Defining meta-data for a change set in the functional Power System model.
 */
final case class NetworkModelProjectChange
(
    NetworkModelProjectComponent: NetworkModelProjectComponent = null,
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
    override def sup: NetworkModelProjectComponent = NetworkModelProjectComponent

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
        CIMParseable[NetworkModelProjectChange]
{
    override val fields: Array[String] = Array [String](
        "NetworkModelProjectChangeVersion"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("NetworkModelProjectChangeVersion", "NetworkModelProjectChangeVersion", "1..*", "1")
    )
    val NetworkModelProjectChangeVersion: FielderMultiple = parse_attributes (attribute (cls, fields (0)))

    def parse (context: CIMContext): NetworkModelProjectChange =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = NetworkModelProjectChange (
            NetworkModelProjectComponent.parse (context),
            masks (NetworkModelProjectChangeVersion (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[NetworkModelProjectChange] = NetworkModelProjectChangeSerializer
}

object NetworkModelProjectChangeSerializer extends CIMSerializer[NetworkModelProjectChange]
{
    def write (kryo: Kryo, output: Output, obj: NetworkModelProjectChange): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.NetworkModelProjectChangeVersion, output)
        )
        NetworkModelProjectComponentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[NetworkModelProjectChange]): NetworkModelProjectChange =
    {
        val parent = NetworkModelProjectComponentSerializer.read (kryo, input, classOf [NetworkModelProjectComponent])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = NetworkModelProjectChange (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Describes the status and the planned implementation of the associated change set into the as-built model.
 *
 * New instances of this class with new identity are instantiated upon changes to the content of this class or changes to the associated change set.  Instances of this class are considered immutable.  The case audit trail can reference this immutable data to exactly reproduce a case.
 *
 * @param IdentifiedObject          [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param comment                   A user provided comment describing the changes in this version from the previous version.
 * @param effectiveDateTime         The date/time the change set is included in the model.
 * @param timeStamp                 The date/time this version was finalized and thus made immutable.
 * @param ChangeSet                 [[ch.ninecode.model.ChangeSet ChangeSet]] The details of model changes for this project.
 *                                  The change set should have a new identifier if it changes.
 * @param NetworkModelProjectChange [[ch.ninecode.model.NetworkModelProjectChange NetworkModelProjectChange]] The persistent network model project change to which this version applies.
 * @param NetworkModelProjectState  [[ch.ninecode.model.NetworkModelProjectState NetworkModelProjectState]] The state of this network model project version.
 * @param SupercededBy              [[ch.ninecode.model.NetworkModelProjectChangeVersion NetworkModelProjectChangeVersion]] The project version that will supercede this project version.
 * @param Supercedes                [[ch.ninecode.model.NetworkModelProjectChangeVersion NetworkModelProjectChangeVersion]] Project version that is being superceded.
 * @group NetworkModelProjects
 * @groupname NetworkModelProjects Package NetworkModelProjects
 * @groupdesc NetworkModelProjects Defining meta-data for a change set in the functional Power System model.
 */
final case class NetworkModelProjectChangeVersion
(
    IdentifiedObject: IdentifiedObject = null,
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
        CIMParseable[NetworkModelProjectChangeVersion]
{
    override val fields: Array[String] = Array [String](
        "comment",
        "effectiveDateTime",
        "timeStamp",
        "ChangeSet",
        "NetworkModelProjectChange",
        "NetworkModelProjectState",
        "SupercededBy",
        "Supercedes"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ChangeSet", "ChangeSet", "0..1", "0..*"),
        CIMRelationship ("NetworkModelProjectChange", "NetworkModelProjectChange", "1", "1..*"),
        CIMRelationship ("NetworkModelProjectState", "NetworkModelProjectState", "0..1", "0..*"),
        CIMRelationship ("SupercededBy", "NetworkModelProjectChangeVersion", "0..1", "0..1"),
        CIMRelationship ("Supercedes", "NetworkModelProjectChangeVersion", "0..1", "0..1")
    )
    val comment: Fielder = parse_element (element (cls, fields (0)))
    val effectiveDateTime: Fielder = parse_element (element (cls, fields (1)))
    val timeStamp: Fielder = parse_element (element (cls, fields (2)))
    val ChangeSet: Fielder = parse_attribute (attribute (cls, fields (3)))
    val NetworkModelProjectChange: Fielder = parse_attribute (attribute (cls, fields (4)))
    val NetworkModelProjectState: Fielder = parse_attribute (attribute (cls, fields (5)))
    val SupercededBy: Fielder = parse_attribute (attribute (cls, fields (6)))
    val Supercedes: Fielder = parse_attribute (attribute (cls, fields (7)))

    def parse (context: CIMContext): NetworkModelProjectChangeVersion =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
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

    def serializer: Serializer[NetworkModelProjectChangeVersion] = NetworkModelProjectChangeVersionSerializer
}

object NetworkModelProjectChangeVersionSerializer extends CIMSerializer[NetworkModelProjectChangeVersion]
{
    def write (kryo: Kryo, output: Output, obj: NetworkModelProjectChangeVersion): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.comment),
            () => output.writeString (obj.effectiveDateTime),
            () => output.writeString (obj.timeStamp),
            () => output.writeString (obj.ChangeSet),
            () => output.writeString (obj.NetworkModelProjectChange),
            () => output.writeString (obj.NetworkModelProjectState),
            () => output.writeString (obj.SupercededBy),
            () => output.writeString (obj.Supercedes)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[NetworkModelProjectChangeVersion]): NetworkModelProjectChangeVersion =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf [IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = NetworkModelProjectChangeVersion (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group NetworkModelProjects
 * @groupname NetworkModelProjects Package NetworkModelProjects
 * @groupdesc NetworkModelProjects Defining meta-data for a change set in the functional Power System model.
 */
final case class NetworkModelProjectCollection
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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[NetworkModelProjectCollection]
{

    def parse (context: CIMContext): NetworkModelProjectCollection =
    {
        val ret = NetworkModelProjectCollection (
            BasicElement.parse (context)
        )
        ret
    }

    def serializer: Serializer[NetworkModelProjectCollection] = NetworkModelProjectCollectionSerializer
}

object NetworkModelProjectCollectionSerializer extends CIMSerializer[NetworkModelProjectCollection]
{
    def write (kryo: Kryo, output: Output, obj: NetworkModelProjectCollection): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf [BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[NetworkModelProjectCollection]): NetworkModelProjectCollection =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf [BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = NetworkModelProjectCollection (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Abstract class for both a network model project and network model change.
 *
 * @param IdentifiedObject      [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param ContainingProject     [[ch.ninecode.model.NetworkModelProject NetworkModelProject]] The parent project of this project.
 * @param ProjectARelationships [[ch.ninecode.model.NetworkModelProjectRelationship NetworkModelProjectRelationship]] <em>undocumented</em>
 * @param ProjectBRelationships [[ch.ninecode.model.NetworkModelProjectRelationship NetworkModelProjectRelationship]] <em>undocumented</em>
 * @group NetworkModelProjects
 * @groupname NetworkModelProjects Package NetworkModelProjects
 * @groupdesc NetworkModelProjects Defining meta-data for a change set in the functional Power System model.
 */
final case class NetworkModelProjectComponent
(
    IdentifiedObject: IdentifiedObject = null,
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
        CIMParseable[NetworkModelProjectComponent]
{
    override val fields: Array[String] = Array [String](
        "ContainingProject",
        "ProjectARelationships",
        "ProjectBRelationships"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ContainingProject", "NetworkModelProject", "1", "0..*"),
        CIMRelationship ("ProjectARelationships", "NetworkModelProjectRelationship", "0..*", "1"),
        CIMRelationship ("ProjectBRelationships", "NetworkModelProjectRelationship", "0..*", "1")
    )
    val ContainingProject: Fielder = parse_attribute (attribute (cls, fields (0)))
    val ProjectARelationships: FielderMultiple = parse_attributes (attribute (cls, fields (1)))
    val ProjectBRelationships: FielderMultiple = parse_attributes (attribute (cls, fields (2)))

    def parse (context: CIMContext): NetworkModelProjectComponent =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = NetworkModelProjectComponent (
            IdentifiedObject.parse (context),
            mask (ContainingProject (), 0),
            masks (ProjectARelationships (), 1),
            masks (ProjectBRelationships (), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[NetworkModelProjectComponent] = NetworkModelProjectComponentSerializer
}

object NetworkModelProjectComponentSerializer extends CIMSerializer[NetworkModelProjectComponent]
{
    def write (kryo: Kryo, output: Output, obj: NetworkModelProjectComponent): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.ContainingProject),
            () => writeList (obj.ProjectARelationships, output),
            () => writeList (obj.ProjectBRelationships, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[NetworkModelProjectComponent]): NetworkModelProjectComponent =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf [IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = NetworkModelProjectComponent (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group NetworkModelProjects
 * @groupname NetworkModelProjects Package NetworkModelProjects
 * @groupdesc NetworkModelProjects Defining meta-data for a change set in the functional Power System model.
 */
final case class NetworkModelProjectComponent2
(
    IdentifiedObject: IdentifiedObject = null,
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
        CIMParseable[NetworkModelProjectComponent2]
{
    override val fields: Array[String] = Array [String](
        "closed",
        "created",
        "updated",
        "version",
        "Parent"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Parent", "NetworkModelProject2", "0..1", "0..*")
    )
    val closed: Fielder = parse_element (element (cls, fields (0)))
    val created: Fielder = parse_element (element (cls, fields (1)))
    val updated: Fielder = parse_element (element (cls, fields (2)))
    val version: Fielder = parse_element (element (cls, fields (3)))
    val Parent: Fielder = parse_attribute (attribute (cls, fields (4)))

    def parse (context: CIMContext): NetworkModelProjectComponent2 =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
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

    def serializer: Serializer[NetworkModelProjectComponent2] = NetworkModelProjectComponent2Serializer
}

object NetworkModelProjectComponent2Serializer extends CIMSerializer[NetworkModelProjectComponent2]
{
    def write (kryo: Kryo, output: Output, obj: NetworkModelProjectComponent2): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.closed),
            () => output.writeString (obj.created),
            () => output.writeString (obj.updated),
            () => output.writeInt (obj.version),
            () => output.writeString (obj.Parent)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[NetworkModelProjectComponent2]): NetworkModelProjectComponent2 =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf [IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = NetworkModelProjectComponent2 (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readInt else 0,
            if (isSet (4)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group NetworkModelProjects
 * @groupname NetworkModelProjects Package NetworkModelProjects
 * @groupdesc NetworkModelProjects Defining meta-data for a change set in the functional Power System model.
 */
final case class NetworkModelProjectDocument
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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[NetworkModelProjectDocument]
{

    def parse (context: CIMContext): NetworkModelProjectDocument =
    {
        val ret = NetworkModelProjectDocument (
            BasicElement.parse (context)
        )
        ret
    }

    def serializer: Serializer[NetworkModelProjectDocument] = NetworkModelProjectDocumentSerializer
}

object NetworkModelProjectDocumentSerializer extends CIMSerializer[NetworkModelProjectDocument]
{
    def write (kryo: Kryo, output: Output, obj: NetworkModelProjectDocument): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf [BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[NetworkModelProjectDocument]): NetworkModelProjectDocument =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf [BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = NetworkModelProjectDocument (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A relationship that assists humans and software building cases by assembling project changes in the correct sequence.
 *
 * This class may be specialized to create specific types of relationships.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param ProjectA         [[ch.ninecode.model.NetworkModelProjectComponent NetworkModelProjectComponent]] <em>undocumented</em>
 * @param ProjectB         [[ch.ninecode.model.NetworkModelProjectComponent NetworkModelProjectComponent]] <em>undocumented</em>
 * @group NetworkModelProjects
 * @groupname NetworkModelProjects Package NetworkModelProjects
 * @groupdesc NetworkModelProjects Defining meta-data for a change set in the functional Power System model.
 */
final case class NetworkModelProjectRelationship
(
    IdentifiedObject: IdentifiedObject = null,
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
        CIMParseable[NetworkModelProjectRelationship]
{
    override val fields: Array[String] = Array [String](
        "ProjectA",
        "ProjectB"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ProjectA", "NetworkModelProjectComponent", "1", "0..*"),
        CIMRelationship ("ProjectB", "NetworkModelProjectComponent", "1", "0..*")
    )
    val ProjectA: Fielder = parse_attribute (attribute (cls, fields (0)))
    val ProjectB: Fielder = parse_attribute (attribute (cls, fields (1)))

    def parse (context: CIMContext): NetworkModelProjectRelationship =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = NetworkModelProjectRelationship (
            IdentifiedObject.parse (context),
            mask (ProjectA (), 0),
            mask (ProjectB (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[NetworkModelProjectRelationship] = NetworkModelProjectRelationshipSerializer
}

object NetworkModelProjectRelationshipSerializer extends CIMSerializer[NetworkModelProjectRelationship]
{
    def write (kryo: Kryo, output: Output, obj: NetworkModelProjectRelationship): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.ProjectA),
            () => output.writeString (obj.ProjectB)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[NetworkModelProjectRelationship]): NetworkModelProjectRelationship =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf [IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = NetworkModelProjectRelationship (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group NetworkModelProjects
 * @groupname NetworkModelProjects Package NetworkModelProjects
 * @groupdesc NetworkModelProjects Defining meta-data for a change set in the functional Power System model.
 */
final case class NetworkModelProjectStage
(
    NetworkModelProjectComponent2: NetworkModelProjectComponent2 = null,
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
    override def sup: NetworkModelProjectComponent2 = NetworkModelProjectComponent2

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
        CIMParseable[NetworkModelProjectStage]
{
    override val fields: Array[String] = Array [String](
        "changesetVersion",
        "commissionedDate",
        "plannedCommissionedDate",
        "ChangeSets",
        "DenpendecyDependingStage",
        "DependencyDependentOnStage"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ChangeSets", "ChangeSet", "1..*", "0..1"),
        CIMRelationship ("DenpendecyDependingStage", "AnnotatedProjectDependency", "0..*", "1"),
        CIMRelationship ("DependencyDependentOnStage", "AnnotatedProjectDependency", "0..1", "1")
    )
    val changesetVersion: Fielder = parse_element (element (cls, fields (0)))
    val commissionedDate: Fielder = parse_element (element (cls, fields (1)))
    val plannedCommissionedDate: Fielder = parse_element (element (cls, fields (2)))
    val ChangeSets: FielderMultiple = parse_attributes (attribute (cls, fields (3)))
    val DenpendecyDependingStage: FielderMultiple = parse_attributes (attribute (cls, fields (4)))
    val DependencyDependentOnStage: Fielder = parse_attribute (attribute (cls, fields (5)))

    def parse (context: CIMContext): NetworkModelProjectStage =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
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

    def serializer: Serializer[NetworkModelProjectStage] = NetworkModelProjectStageSerializer
}

object NetworkModelProjectStageSerializer extends CIMSerializer[NetworkModelProjectStage]
{
    def write (kryo: Kryo, output: Output, obj: NetworkModelProjectStage): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeInt (obj.changesetVersion),
            () => output.writeString (obj.commissionedDate),
            () => output.writeString (obj.plannedCommissionedDate),
            () => writeList (obj.ChangeSets, output),
            () => writeList (obj.DenpendecyDependingStage, output),
            () => output.writeString (obj.DependencyDependentOnStage)
        )
        NetworkModelProjectComponent2Serializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[NetworkModelProjectStage]): NetworkModelProjectStage =
    {
        val parent = NetworkModelProjectComponent2Serializer.read (kryo, input, classOf [NetworkModelProjectComponent2])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = NetworkModelProjectStage (
            parent,
            if (isSet (0)) input.readInt else 0,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) readList (input) else null,
            if (isSet (5)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A network model project version state.
 *
 * States are agreed upon by the exchange community.  Examples are "approved", "proposed", "withdrawn", "committed" etc.
 *
 * @param IdentifiedObject                 [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param NetworkModelProjectChangeVersion [[ch.ninecode.model.NetworkModelProjectChangeVersion NetworkModelProjectChangeVersion]] The change versions that are at this state.
 * @group NetworkModelProjects
 * @groupname NetworkModelProjects Package NetworkModelProjects
 * @groupdesc NetworkModelProjects Defining meta-data for a change set in the functional Power System model.
 */
final case class NetworkModelProjectState
(
    IdentifiedObject: IdentifiedObject = null,
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
        CIMParseable[NetworkModelProjectState]
{
    override val fields: Array[String] = Array [String](
        "NetworkModelProjectChangeVersion"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("NetworkModelProjectChangeVersion", "NetworkModelProjectChangeVersion", "0..*", "0..1")
    )
    val NetworkModelProjectChangeVersion: FielderMultiple = parse_attributes (attribute (cls, fields (0)))

    def parse (context: CIMContext): NetworkModelProjectState =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = NetworkModelProjectState (
            IdentifiedObject.parse (context),
            masks (NetworkModelProjectChangeVersion (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[NetworkModelProjectState] = NetworkModelProjectStateSerializer
}

object NetworkModelProjectStateSerializer extends CIMSerializer[NetworkModelProjectState]
{
    def write (kryo: Kryo, output: Output, obj: NetworkModelProjectState): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.NetworkModelProjectChangeVersion, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[NetworkModelProjectState]): NetworkModelProjectState =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf [IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = NetworkModelProjectState (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Represent the base lifecycle of a functional model change that could be a construction of new elements.
 *
 * @param Element   Reference to the superclass object.
 * @param cancelled The date the Power System Project is in cancelled stage.
 * @param committed The date Power System Project is in committed stage.
 * @param inBuild   The date Power System Project is in build stage.
 * @param inPlan    The date Power System Project is in planning stage.
 * @group NetworkModelProjects
 * @groupname NetworkModelProjects Package NetworkModelProjects
 * @groupdesc NetworkModelProjects Defining meta-data for a change set in the functional Power System model.
 */
final case class PowerSystemProjectLifecycleToBeDeleted
(
    Element: BasicElement = null,
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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[PowerSystemProjectLifecycleToBeDeleted]
{
    override val fields: Array[String] = Array [String](
        "cancelled",
        "committed",
        "inBuild",
        "inPlan"
    )
    val cancelled: Fielder = parse_element (element (cls, fields (0)))
    val committed: Fielder = parse_element (element (cls, fields (1)))
    val inBuild: Fielder = parse_element (element (cls, fields (2)))
    val inPlan: Fielder = parse_element (element (cls, fields (3)))

    def parse (context: CIMContext): PowerSystemProjectLifecycleToBeDeleted =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
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

    def serializer: Serializer[PowerSystemProjectLifecycleToBeDeleted] = PowerSystemProjectLifecycleToBeDeletedSerializer
}

object PowerSystemProjectLifecycleToBeDeletedSerializer extends CIMSerializer[PowerSystemProjectLifecycleToBeDeleted]
{
    def write (kryo: Kryo, output: Output, obj: PowerSystemProjectLifecycleToBeDeleted): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.cancelled),
            () => output.writeString (obj.committed),
            () => output.writeString (obj.inBuild),
            () => output.writeString (obj.inPlan)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf [BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PowerSystemProjectLifecycleToBeDeleted]): PowerSystemProjectLifecycleToBeDeleted =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf [BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PowerSystemProjectLifecycleToBeDeleted (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Project B is an alternative to project A.
 *
 * Project A is the primary alternative.
 * Multiple project alternatives should not be selected into a single network study case.
 *
 * @param NetworkModelProjectRelationship [[ch.ninecode.model.NetworkModelProjectRelationship NetworkModelProjectRelationship]] Reference to the superclass object.
 * @group NetworkModelProjects
 * @groupname NetworkModelProjects Package NetworkModelProjects
 * @groupdesc NetworkModelProjects Defining meta-data for a change set in the functional Power System model.
 */
final case class ProjectAlternative
(
    NetworkModelProjectRelationship: NetworkModelProjectRelationship = null
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
    override def sup: NetworkModelProjectRelationship = NetworkModelProjectRelationship

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
        sup.export_fields
    }

    override def export: String =
    {
        "\t<cim:ProjectAlternative rdf:ID=\"%s\">\n%s\t</cim:ProjectAlternative>".format (id, export_fields)
    }
}

object ProjectAlternative
    extends
        CIMParseable[ProjectAlternative]
{

    def parse (context: CIMContext): ProjectAlternative =
    {
        val ret = ProjectAlternative (
            NetworkModelProjectRelationship.parse (context)
        )
        ret
    }

    def serializer: Serializer[ProjectAlternative] = ProjectAlternativeSerializer
}

object ProjectAlternativeSerializer extends CIMSerializer[ProjectAlternative]
{
    def write (kryo: Kryo, output: Output, obj: ProjectAlternative): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        NetworkModelProjectRelationshipSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ProjectAlternative]): ProjectAlternative =
    {
        val parent = NetworkModelProjectRelationshipSerializer.read (kryo, input, classOf [NetworkModelProjectRelationship])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ProjectAlternative (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Project A change sets should be applied before Project B during case creation.
 *
 * @param NetworkModelProjectRelationship [[ch.ninecode.model.NetworkModelProjectRelationship NetworkModelProjectRelationship]] Reference to the superclass object.
 * @group NetworkModelProjects
 * @groupname NetworkModelProjects Package NetworkModelProjects
 * @groupdesc NetworkModelProjects Defining meta-data for a change set in the functional Power System model.
 */
final case class ProjectDependency
(
    NetworkModelProjectRelationship: NetworkModelProjectRelationship = null
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
    override def sup: NetworkModelProjectRelationship = NetworkModelProjectRelationship

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
        sup.export_fields
    }

    override def export: String =
    {
        "\t<cim:ProjectDependency rdf:ID=\"%s\">\n%s\t</cim:ProjectDependency>".format (id, export_fields)
    }
}

object ProjectDependency
    extends
        CIMParseable[ProjectDependency]
{

    def parse (context: CIMContext): ProjectDependency =
    {
        val ret = ProjectDependency (
            NetworkModelProjectRelationship.parse (context)
        )
        ret
    }

    def serializer: Serializer[ProjectDependency] = ProjectDependencySerializer
}

object ProjectDependencySerializer extends CIMSerializer[ProjectDependency]
{
    def write (kryo: Kryo, output: Output, obj: ProjectDependency): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        NetworkModelProjectRelationshipSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ProjectDependency]): ProjectDependency =
    {
        val parent = NetworkModelProjectRelationshipSerializer.read (kryo, input, classOf [NetworkModelProjectRelationship])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ProjectDependency (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _NetworkModelProjects
{
    def register: List[CIMClassInfo] =
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