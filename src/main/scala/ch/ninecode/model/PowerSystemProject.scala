package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * The package describes how power system model data is managed and evolve over time in projects.
 */

/**
 * A (document/collection) that describe a set of changes to the network.
 */
case class PowerSystemProject
(

    override val sup: BasicElement,

    val attr: String,

    val description: String,

    val name: String,

    /**
     * Priority between competing projects.
     * Use 0 for don t care.  Use 1 for highest priority.  Use 2 as priority is less than 1 and so on.
     */
    val priority: Int,

    /**
     * Describes the state the project realisation are from starting planning until it is commissioned if not cancelled.
     */
    val state: String,

    /**
     * Type of project.
     */
    val typ: String,

    /**
     * Version of the project.
     * Changes to a project is not modeled. So the project with the highest version are the valid/latest project. Only positive numbers equal or higher than 1 are allowed.
     */
    val version: Int,

    val Project: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, 0, null, null, 0, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[PowerSystemProject]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PowerSystemProject
extends
    Parseable[PowerSystemProject]
{
    val sup = BasicElement.parse _
    val attr = parse_attribute (attribute ("""PowerSystemProject."""))_
    val description = parse_element (element ("""PowerSystemProject.description"""))_
    val name = parse_element (element ("""PowerSystemProject.name"""))_
    val priority = parse_element (element ("""PowerSystemProject.priority"""))_
    val state = parse_attribute (attribute ("""PowerSystemProject.state"""))_
    val typ = parse_element (element ("""PowerSystemProject.type"""))_
    val version = parse_element (element ("""PowerSystemProject.version"""))_
    val Project = parse_attribute (attribute ("""PowerSystemProject.Project"""))_
    def parse (context: Context): PowerSystemProject =
    {
        PowerSystemProject(
            sup (context),
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
}

case class PowerSystemProjectSchedule
(

    override val sup: BasicElement,

    /**
     * Actual date and time for when the project is commissioned and committed to the network model.
     */
    val actualEnd: String,

    /**
     * Actual date and time for when the project is commissioned and committed to the network model.
     */
    val actualStart: String,

    val attr: String,

    /**
     * Estimated date and time for when the project will be commissioned and committed to the network model.
     */
    val scheduledEnd: String,

    /**
     * Estimated date and time for when the project will be commissioned and committed to the network model.
     */
    val scheduledStart: String,

    val status: String,

    val stepType: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[PowerSystemProjectSchedule]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PowerSystemProjectSchedule
extends
    Parseable[PowerSystemProjectSchedule]
{
    val sup = BasicElement.parse _
    val actualEnd = parse_element (element ("""PowerSystemProjectSchedule.actualEnd"""))_
    val actualStart = parse_element (element ("""PowerSystemProjectSchedule.actualStart"""))_
    val attr = parse_attribute (attribute ("""PowerSystemProjectSchedule."""))_
    val scheduledEnd = parse_element (element ("""PowerSystemProjectSchedule.scheduledEnd"""))_
    val scheduledStart = parse_element (element ("""PowerSystemProjectSchedule.scheduledStart"""))_
    val status = parse_attribute (attribute ("""PowerSystemProjectSchedule.status"""))_
    val stepType = parse_attribute (attribute ("""PowerSystemProjectSchedule.stepType"""))_
    def parse (context: Context): PowerSystemProjectSchedule =
    {
        PowerSystemProjectSchedule(
            sup (context),
            actualEnd (context),
            actualStart (context),
            attr (context),
            scheduledEnd (context),
            scheduledStart (context),
            status (context),
            stepType (context)
        )
    }
}

/**
 * A collection of dependent projects.
 */
case class PowerSystemSubProject
(

    override val sup: PowerSystemProject,

    val Project: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def PowerSystemProject: PowerSystemProject = sup.asInstanceOf[PowerSystemProject]
    override def copy (): Row = { return (clone ().asInstanceOf[PowerSystemSubProject]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PowerSystemSubProject
extends
    Parseable[PowerSystemSubProject]
{
    val sup = PowerSystemProject.parse _
    val Project = parse_attribute (attribute ("""PowerSystemSubProject.Project"""))_
    def parse (context: Context): PowerSystemSubProject =
    {
        PowerSystemSubProject(
            sup (context),
            Project (context)
        )
    }
}

/**
 * The ProjectSteps are ordered by the actualStart and actualEnds so that  a dependent ProjectStep will have a actualStart after an actualEnd.
 */
case class ProjectStep
(

    override val sup: BasicElement,

    /**
     * Actual date and time for when the project is commissioned and committed to the network model.
     */
    val actualEnd: String,

    /**
     * Actual date and time for when the project is commissioned and committed to the network model.
     */
    val actualStart: String,

    /**
     * Estimated date and time for when the project will be commissioned and committed to the network model.
     */
    val scheduledEnd: String,

    /**
     * Estimated date and time for when the project will be commissioned and committed to the network model.
     */
    val scheduledStart: String,

    val status: String,

    val stepType: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ProjectStep]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ProjectStep
extends
    Parseable[ProjectStep]
{
    val sup = BasicElement.parse _
    val actualEnd = parse_element (element ("""ProjectStep.actualEnd"""))_
    val actualStart = parse_element (element ("""ProjectStep.actualStart"""))_
    val scheduledEnd = parse_element (element ("""ProjectStep.scheduledEnd"""))_
    val scheduledStart = parse_element (element ("""ProjectStep.scheduledStart"""))_
    val status = parse_attribute (attribute ("""ProjectStep.status"""))_
    val stepType = parse_attribute (attribute ("""ProjectStep.stepType"""))_
    def parse (context: Context): ProjectStep =
    {
        ProjectStep(
            sup (context),
            actualEnd (context),
            actualStart (context),
            scheduledEnd (context),
            scheduledStart (context),
            status (context),
            stepType (context)
        )
    }
}

case class ProjectStepStatusKind
(

    override val sup: BasicElement,

    val approved: String,

    val cancelled: String,

    val inProgress: String,

    val inactive: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ProjectStepStatusKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ProjectStepStatusKind
extends
    Parseable[ProjectStepStatusKind]
{
    val sup = BasicElement.parse _
    val approved = parse_attribute (attribute ("""ProjectStepStatusKind.approved"""))_
    val cancelled = parse_attribute (attribute ("""ProjectStepStatusKind.cancelled"""))_
    val inProgress = parse_attribute (attribute ("""ProjectStepStatusKind.inProgress"""))_
    val inactive = parse_attribute (attribute ("""ProjectStepStatusKind.inactive"""))_
    def parse (context: Context): ProjectStepStatusKind =
    {
        ProjectStepStatusKind(
            sup (context),
            approved (context),
            cancelled (context),
            inProgress (context),
            inactive (context)
        )
    }
}

/**
 * State of the project
 */
case class StepKind
(

    override val sup: BasicElement,

    /**
     * The project is commissioned and added to the network model.
     */
    val commissioning: String,

    /**
     * Project is approved for realisation and the construction is starting, under construction or in the state of being realist.
     */
    val design_and_construction: String,

    /**
     * First phase investigation and planning.
     */
    val planning: String,

    val revision: String,

    val ____list_incomplete__more_to_come: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[StepKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object StepKind
extends
    Parseable[StepKind]
{
    val sup = BasicElement.parse _
    val commissioning = parse_attribute (attribute ("""StepKind.commissioning"""))_
    val design_and_construction = parse_attribute (attribute ("""StepKind.design and construction"""))_
    val planning = parse_attribute (attribute ("""StepKind.planning"""))_
    val revision = parse_attribute (attribute ("""StepKind.revision"""))_
    val ____list_incomplete__more_to_come = parse_attribute (attribute ("""StepKind.... list incomplete, more to come"""))_
    def parse (context: Context): StepKind =
    {
        StepKind(
            sup (context),
            commissioning (context),
            design_and_construction (context),
            planning (context),
            revision (context),
            ____list_incomplete__more_to_come (context)
        )
    }
}

object _PowerSystemProject
{
    def register: Unit =
    {
        PowerSystemProject.register
        PowerSystemProjectSchedule.register
        PowerSystemSubProject.register
        ProjectStep.register
        ProjectStepStatusKind.register
        StepKind.register
    }
}