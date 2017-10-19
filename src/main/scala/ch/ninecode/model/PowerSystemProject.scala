package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * A (document/collection) that describe a set of changes to the network.
 *
 * @param sup Reference to the superclass object.
 * @param description <em>undocumented</em>
 * @param name <em>undocumented</em>
 * @param priority Priority between competing projects.
 *        Use 0 for don t care.  Use 1 for highest priority.  Use 2 as priority is less than 1 and so on.
 * @param state Describes the state the project realisation are from starting planning until it is commissioned if not cancelled.
 * @param typ Type of project.
 * @param unknown [[ch.ninecode.model.DifferenceModel DifferenceModel]] <em>undocumented</em>
 * @param version Version of the project.
 *        Changes to a project is not modeled. So the project with the highest version are the valid/latest project. Only positive numbers equal or higher than 1 are allowed.
 * @param Project [[ch.ninecode.model.PowerSystemProject PowerSystemProject]] <em>undocumented</em>
 * @group PowerSystemProject
 * @groupname PowerSystemProject Package PowerSystemProject
 * @groupdesc PowerSystemProject The package describes how power system model data is managed and evolve over time in projects.
 */
case class PowerSystemProject
(
    override val sup: BasicElement,
    description: String,
    name: String,
    priority: Int,
    state: String,
    typ: String,
    unknown: String,
    version: Int,
    Project: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, 0, null, null, null, 0, null) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[PowerSystemProject] }
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
        implicit val clz: String = PowerSystemProject.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PowerSystemProject.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PowerSystemProject.fields (position), value)
        emitelem (0, description)
        emitelem (1, name)
        emitelem (2, priority)
        emitattr (3, state)
        emitelem (4, typ)
        emitattr (5, unknown)
        emitelem (6, version)
        emitattr (7, Project)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PowerSystemProject rdf:ID=\"%s\">\n%s\t</cim:PowerSystemProject>".format (id, export_fields)
    }
}

object PowerSystemProject
extends
    Parseable[PowerSystemProject]
{
    val fields: Array[String] = Array[String] (
        "description",
        "name",
        "priority",
        "state",
        "type",
        "",
        "version",
        "Project"
    )
    val description: Fielder = parse_element (element (cls, fields(0)))
    val name: Fielder = parse_element (element (cls, fields(1)))
    val priority: Fielder = parse_element (element (cls, fields(2)))
    val state: Fielder = parse_attribute (attribute (cls, fields(3)))
    val typ: Fielder = parse_element (element (cls, fields(4)))
    val unknown: Fielder = parse_attribute (attribute (cls, fields(5)))
    val version: Fielder = parse_element (element (cls, fields(6)))
    val Project: Fielder = parse_attribute (attribute (cls, fields(7)))

    def parse (context: Context): PowerSystemProject =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = PowerSystemProject (
            BasicElement.parse (context),
            mask (description (), 0),
            mask (name (), 1),
            toInteger (mask (priority (), 2)),
            mask (state (), 3),
            mask (typ (), 4),
            mask (unknown (), 5),
            toInteger (mask (version (), 6)),
            mask (Project (), 7)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("unknown", "DifferenceModel", false),
        Relationship ("Project", "PowerSystemProject", false)
    )
}

/**

 * @group PowerSystemProject
 * @groupname PowerSystemProject Package PowerSystemProject
 * @groupdesc PowerSystemProject The package describes how power system model data is managed and evolve over time in projects.
 */
case class PowerSystemProjectSchedule
(
    override val sup: BasicElement,
    actualEnd: String,
    actualStart: String,
    scheduledEnd: String,
    scheduledStart: String,
    status: String,
    stepType: String,
    unknown: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null, null) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[PowerSystemProjectSchedule] }
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
        implicit val clz: String = PowerSystemProjectSchedule.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PowerSystemProjectSchedule.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PowerSystemProjectSchedule.fields (position), value)
        emitelem (0, actualEnd)
        emitelem (1, actualStart)
        emitelem (2, scheduledEnd)
        emitelem (3, scheduledStart)
        emitattr (4, status)
        emitattr (5, stepType)
        emitattr (6, unknown)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PowerSystemProjectSchedule rdf:ID=\"%s\">\n%s\t</cim:PowerSystemProjectSchedule>".format (id, export_fields)
    }
}

object PowerSystemProjectSchedule
extends
    Parseable[PowerSystemProjectSchedule]
{
    val fields: Array[String] = Array[String] (
        "actualEnd",
        "actualStart",
        "scheduledEnd",
        "scheduledStart",
        "status",
        "stepType",
        ""
    )
    val actualEnd: Fielder = parse_element (element (cls, fields(0)))
    val actualStart: Fielder = parse_element (element (cls, fields(1)))
    val scheduledEnd: Fielder = parse_element (element (cls, fields(2)))
    val scheduledStart: Fielder = parse_element (element (cls, fields(3)))
    val status: Fielder = parse_attribute (attribute (cls, fields(4)))
    val stepType: Fielder = parse_attribute (attribute (cls, fields(5)))
    val unknown: Fielder = parse_attribute (attribute (cls, fields(6)))

    def parse (context: Context): PowerSystemProjectSchedule =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = PowerSystemProjectSchedule (
            BasicElement.parse (context),
            mask (actualEnd (), 0),
            mask (actualStart (), 1),
            mask (scheduledEnd (), 2),
            mask (scheduledStart (), 3),
            mask (status (), 4),
            mask (stepType (), 5),
            mask (unknown (), 6)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("unknown", "PowerSystemProject", false)
    )
}

/**
 * A collection of dependent projects.
 *
 * @param sup [[ch.ninecode.model.PowerSystemProject PowerSystemProject]] Reference to the superclass object.
 * @param Project [[ch.ninecode.model.PowerSystemProject PowerSystemProject]] <em>undocumented</em>
 * @group PowerSystemProject
 * @groupname PowerSystemProject Package PowerSystemProject
 * @groupdesc PowerSystemProject The package describes how power system model data is managed and evolve over time in projects.
 */
case class PowerSystemSubProject
(
    override val sup: PowerSystemProject,
    Project: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PowerSystemProject: PowerSystemProject = sup.asInstanceOf[PowerSystemProject]
    override def copy (): Row = { clone ().asInstanceOf[PowerSystemSubProject] }
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
        implicit val clz: String = PowerSystemSubProject.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PowerSystemSubProject.fields (position), value)
        emitattr (0, Project)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PowerSystemSubProject rdf:ID=\"%s\">\n%s\t</cim:PowerSystemSubProject>".format (id, export_fields)
    }
}

object PowerSystemSubProject
extends
    Parseable[PowerSystemSubProject]
{
    val fields: Array[String] = Array[String] (
        "Project"
    )
    val Project: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): PowerSystemSubProject =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = PowerSystemSubProject (
            PowerSystemProject.parse (context),
            mask (Project (), 0)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Project", "PowerSystemProject", false)
    )
}

/**
 * The ProjectSteps are ordered by the actualStart and actualEnds so that  a dependent ProjectStep will have a actualStart after an actualEnd.
 *
 * @param sup Reference to the superclass object.
 * @param actualEnd Actual date and time for when the project is commissioned and committed to the network model.
 * @param actualStart Actual date and time for when the project is commissioned and committed to the network model.
 * @param scheduledEnd Estimated date and time for when the project will be commissioned and committed to the network model.
 * @param scheduledStart Estimated date and time for when the project will be commissioned and committed to the network model.
 * @param status <em>undocumented</em>
 * @param stepType <em>undocumented</em>
 * @group PowerSystemProject
 * @groupname PowerSystemProject Package PowerSystemProject
 * @groupdesc PowerSystemProject The package describes how power system model data is managed and evolve over time in projects.
 */
case class ProjectStep
(
    override val sup: BasicElement,
    actualEnd: String,
    actualStart: String,
    scheduledEnd: String,
    scheduledStart: String,
    status: String,
    stepType: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ProjectStep] }
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
        implicit val clz: String = ProjectStep.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ProjectStep.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ProjectStep.fields (position), value)
        emitelem (0, actualEnd)
        emitelem (1, actualStart)
        emitelem (2, scheduledEnd)
        emitelem (3, scheduledStart)
        emitattr (4, status)
        emitattr (5, stepType)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ProjectStep rdf:ID=\"%s\">\n%s\t</cim:ProjectStep>".format (id, export_fields)
    }
}

object ProjectStep
extends
    Parseable[ProjectStep]
{
    val fields: Array[String] = Array[String] (
        "actualEnd",
        "actualStart",
        "scheduledEnd",
        "scheduledStart",
        "status",
        "stepType"
    )
    val actualEnd: Fielder = parse_element (element (cls, fields(0)))
    val actualStart: Fielder = parse_element (element (cls, fields(1)))
    val scheduledEnd: Fielder = parse_element (element (cls, fields(2)))
    val scheduledStart: Fielder = parse_element (element (cls, fields(3)))
    val status: Fielder = parse_attribute (attribute (cls, fields(4)))
    val stepType: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: Context): ProjectStep =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = ProjectStep (
            BasicElement.parse (context),
            mask (actualEnd (), 0),
            mask (actualStart (), 1),
            mask (scheduledEnd (), 2),
            mask (scheduledStart (), 3),
            mask (status (), 4),
            mask (stepType (), 5)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

private[ninecode] object _PowerSystemProject
{
    def register: List[ClassInfo] =
    {
        List (
            PowerSystemProject.register,
            PowerSystemProjectSchedule.register,
            PowerSystemSubProject.register,
            ProjectStep.register
        )
    }
}