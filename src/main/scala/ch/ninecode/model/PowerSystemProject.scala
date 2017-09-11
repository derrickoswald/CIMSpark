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
 * @param attr [[ch.ninecode.model.DifferenceModel DifferenceModel]] <em>undocumented</em>
 * @param description <em>undocumented</em>
 * @param name <em>undocumented</em>
 * @param priority Priority between competing projects.
 *        Use 0 for don t care.  Use 1 for highest priority.  Use 2 as priority is less than 1 and so on.
 * @param state Describes the state the project realisation are from starting planning until it is commissioned if not cancelled.
 * @param typ Type of project.
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
    attr: String,
    description: String,
    name: String,
    priority: Int,
    state: String,
    typ: String,
    version: Int,
    Project: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, 0, null, null, 0, null) }
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
        sup.export_fields +
        (if (null != attr) "\t\t<cim:PowerSystemProject. rdf:resource=\"#" + attr + "\"/>\n" else "") +
        (if (null != description) "\t\t<cim:PowerSystemProject.description>" + description + "</cim:PowerSystemProject.description>\n" else "") +
        (if (null != name) "\t\t<cim:PowerSystemProject.name>" + name + "</cim:PowerSystemProject.name>\n" else "") +
        "\t\t<cim:PowerSystemProject.priority>" + priority + "</cim:PowerSystemProject.priority>\n" +
        (if (null != state) "\t\t<cim:PowerSystemProject.state rdf:resource=\"#" + state + "\"/>\n" else "") +
        (if (null != typ) "\t\t<cim:PowerSystemProject.type>" + typ + "</cim:PowerSystemProject.type>\n" else "") +
        "\t\t<cim:PowerSystemProject.version>" + version + "</cim:PowerSystemProject.version>\n" +
        (if (null != Project) "\t\t<cim:PowerSystemProject.Project rdf:resource=\"#" + Project + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:PowerSystemProject rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PowerSystemProject>"
    }
}

object PowerSystemProject
extends
    Parseable[PowerSystemProject]
{
    val attr = parse_attribute (attribute ("""PowerSystemProject."""))
    val description = parse_element (element ("""PowerSystemProject.description"""))
    val name = parse_element (element ("""PowerSystemProject.name"""))
    val priority = parse_element (element ("""PowerSystemProject.priority"""))
    val state = parse_attribute (attribute ("""PowerSystemProject.state"""))
    val typ = parse_element (element ("""PowerSystemProject.type"""))
    val version = parse_element (element ("""PowerSystemProject.version"""))
    val Project = parse_attribute (attribute ("""PowerSystemProject.Project"""))
    def parse (context: Context): PowerSystemProject =
    {
        PowerSystemProject(
            BasicElement.parse (context),
            attr (context),
            description (context),
            name (context),
            toInteger (priority (context), context),
            state (context),
            typ (context),
            toInteger (version (context), context),
            Project (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("Project", "PowerSystemProject", false),
        Relationship ("attr", "DifferenceModel", false))
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
    attr: String,
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
    def this () = { this (null, null, null, null, null, null, null, null) }
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
        sup.export_fields +
        (if (null != actualEnd) "\t\t<cim:PowerSystemProjectSchedule.actualEnd>" + actualEnd + "</cim:PowerSystemProjectSchedule.actualEnd>\n" else "") +
        (if (null != actualStart) "\t\t<cim:PowerSystemProjectSchedule.actualStart>" + actualStart + "</cim:PowerSystemProjectSchedule.actualStart>\n" else "") +
        (if (null != attr) "\t\t<cim:PowerSystemProjectSchedule. rdf:resource=\"#" + attr + "\"/>\n" else "") +
        (if (null != scheduledEnd) "\t\t<cim:PowerSystemProjectSchedule.scheduledEnd>" + scheduledEnd + "</cim:PowerSystemProjectSchedule.scheduledEnd>\n" else "") +
        (if (null != scheduledStart) "\t\t<cim:PowerSystemProjectSchedule.scheduledStart>" + scheduledStart + "</cim:PowerSystemProjectSchedule.scheduledStart>\n" else "") +
        (if (null != status) "\t\t<cim:PowerSystemProjectSchedule.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != stepType) "\t\t<cim:PowerSystemProjectSchedule.stepType rdf:resource=\"#" + stepType + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:PowerSystemProjectSchedule rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PowerSystemProjectSchedule>"
    }
}

object PowerSystemProjectSchedule
extends
    Parseable[PowerSystemProjectSchedule]
{
    val actualEnd = parse_element (element ("""PowerSystemProjectSchedule.actualEnd"""))
    val actualStart = parse_element (element ("""PowerSystemProjectSchedule.actualStart"""))
    val attr = parse_attribute (attribute ("""PowerSystemProjectSchedule."""))
    val scheduledEnd = parse_element (element ("""PowerSystemProjectSchedule.scheduledEnd"""))
    val scheduledStart = parse_element (element ("""PowerSystemProjectSchedule.scheduledStart"""))
    val status = parse_attribute (attribute ("""PowerSystemProjectSchedule.status"""))
    val stepType = parse_attribute (attribute ("""PowerSystemProjectSchedule.stepType"""))
    def parse (context: Context): PowerSystemProjectSchedule =
    {
        PowerSystemProjectSchedule(
            BasicElement.parse (context),
            actualEnd (context),
            actualStart (context),
            attr (context),
            scheduledEnd (context),
            scheduledStart (context),
            status (context),
            stepType (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("attr", "PowerSystemProject", false))
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
        sup.export_fields +
        (if (null != Project) "\t\t<cim:PowerSystemSubProject.Project rdf:resource=\"#" + Project + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:PowerSystemSubProject rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PowerSystemSubProject>"
    }
}

object PowerSystemSubProject
extends
    Parseable[PowerSystemSubProject]
{
    val Project = parse_attribute (attribute ("""PowerSystemSubProject.Project"""))
    def parse (context: Context): PowerSystemSubProject =
    {
        PowerSystemSubProject(
            PowerSystemProject.parse (context),
            Project (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("Project", "PowerSystemProject", false))
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
        sup.export_fields +
        (if (null != actualEnd) "\t\t<cim:ProjectStep.actualEnd>" + actualEnd + "</cim:ProjectStep.actualEnd>\n" else "") +
        (if (null != actualStart) "\t\t<cim:ProjectStep.actualStart>" + actualStart + "</cim:ProjectStep.actualStart>\n" else "") +
        (if (null != scheduledEnd) "\t\t<cim:ProjectStep.scheduledEnd>" + scheduledEnd + "</cim:ProjectStep.scheduledEnd>\n" else "") +
        (if (null != scheduledStart) "\t\t<cim:ProjectStep.scheduledStart>" + scheduledStart + "</cim:ProjectStep.scheduledStart>\n" else "") +
        (if (null != status) "\t\t<cim:ProjectStep.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != stepType) "\t\t<cim:ProjectStep.stepType rdf:resource=\"#" + stepType + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ProjectStep rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ProjectStep>"
    }
}

object ProjectStep
extends
    Parseable[ProjectStep]
{
    val actualEnd = parse_element (element ("""ProjectStep.actualEnd"""))
    val actualStart = parse_element (element ("""ProjectStep.actualStart"""))
    val scheduledEnd = parse_element (element ("""ProjectStep.scheduledEnd"""))
    val scheduledStart = parse_element (element ("""ProjectStep.scheduledStart"""))
    val status = parse_attribute (attribute ("""ProjectStep.status"""))
    val stepType = parse_attribute (attribute ("""ProjectStep.stepType"""))
    def parse (context: Context): ProjectStep =
    {
        ProjectStep(
            BasicElement.parse (context),
            actualEnd (context),
            actualStart (context),
            scheduledEnd (context),
            scheduledStart (context),
            status (context),
            stepType (context)
        )
    }
    val relations: List[Relationship] = List ()
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