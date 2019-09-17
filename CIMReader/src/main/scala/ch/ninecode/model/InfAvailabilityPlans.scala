package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * The collection of all the availability schedules for a given time range.
 *
 * Only one availability plan shall be valid for the same period.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param validPeriod The period of time for which the plan is valid.
 * @group InfAvailabilityPlans
 * @groupname InfAvailabilityPlans Package InfAvailabilityPlans
 * @groupdesc InfAvailabilityPlans Contains the planned schedules for equipment availability, primarily intended for future studies.
 */
final case class AvailablityPlan
(
    override val sup: IdentifiedObject,
    validPeriod: String
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
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[AvailablityPlan] }
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
        implicit val clz: String = AvailablityPlan.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AvailablityPlan.fields (position), value)
        emitattr (0, validPeriod)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AvailablityPlan rdf:ID=\"%s\">\n%s\t</cim:AvailablityPlan>".format (id, export_fields)
    }
}

object AvailablityPlan
extends
    Parseable[AvailablityPlan]
{
    override val fields: Array[String] = Array[String] (
        "validPeriod"
    )
    val validPeriod: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): AvailablityPlan =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AvailablityPlan (
            IdentifiedObject.parse (context),
            mask (validPeriod (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group InfAvailabilityPlans
 * @groupname InfAvailabilityPlans Package InfAvailabilityPlans
 * @groupdesc InfAvailabilityPlans Contains the planned schedules for equipment availability, primarily intended for future studies.
 */
final case class EquipmentUnavailabilitySchedule
(
    override val sup: IdentifiedObject
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[EquipmentUnavailabilitySchedule] }
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
        "\t<cim:EquipmentUnavailabilitySchedule rdf:ID=\"%s\">\n%s\t</cim:EquipmentUnavailabilitySchedule>".format (id, export_fields)
    }
}

object EquipmentUnavailabilitySchedule
extends
    Parseable[EquipmentUnavailabilitySchedule]
{

    def parse (context: Context): EquipmentUnavailabilitySchedule =
    {
        implicit val ctx: Context = context
        val ret = EquipmentUnavailabilitySchedule (
            IdentifiedObject.parse (context)
        )
        ret
    }
}

/**

 * @group InfAvailabilityPlans
 * @groupname InfAvailabilityPlans Package InfAvailabilityPlans
 * @groupdesc InfAvailabilityPlans Contains the planned schedules for equipment availability, primarily intended for future studies.
 */
final case class UnavailabilityScheduleDependency
(
    override val sup: IdentifiedObject,
    UnavailabilityScheduleDependsOn: String,
    UnavailabilityScheduleImpacts: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[UnavailabilityScheduleDependency] }
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
        implicit val clz: String = UnavailabilityScheduleDependency.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (UnavailabilityScheduleDependency.fields (position), value)
        emitattr (0, UnavailabilityScheduleDependsOn)
        emitattr (1, UnavailabilityScheduleImpacts)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:UnavailabilityScheduleDependency rdf:ID=\"%s\">\n%s\t</cim:UnavailabilityScheduleDependency>".format (id, export_fields)
    }
}

object UnavailabilityScheduleDependency
extends
    Parseable[UnavailabilityScheduleDependency]
{
    override val fields: Array[String] = Array[String] (
        "UnavailabilityScheduleDependsOn",
        "UnavailabilityScheduleImpacts"
    )
    override val relations: List[Relationship] = List (
        Relationship ("UnavailabilityScheduleDependsOn", "UnavailablitySchedule", "1", "0..*"),
        Relationship ("UnavailabilityScheduleImpacts", "UnavailablitySchedule", "1", "0..*")
    )
    val UnavailabilityScheduleDependsOn: Fielder = parse_attribute (attribute (cls, fields(0)))
    val UnavailabilityScheduleImpacts: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): UnavailabilityScheduleDependency =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = UnavailabilityScheduleDependency (
            IdentifiedObject.parse (context),
            mask (UnavailabilityScheduleDependsOn (), 0),
            mask (UnavailabilityScheduleImpacts (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Relevant switching action for supporting the availability (or unavailability) plans.
 *
 * This could open or close a switch that is not directly connected to the unavailable equipment .
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param open The switch is to be open during the scheduled period.
 * @group InfAvailabilityPlans
 * @groupname InfAvailabilityPlans Package InfAvailabilityPlans
 * @groupdesc InfAvailabilityPlans Contains the planned schedules for equipment availability, primarily intended for future studies.
 */
final case class UnavailabilitySwitchAction
(
    override val sup: IdentifiedObject,
    open: Boolean
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[UnavailabilitySwitchAction] }
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
        implicit val clz: String = UnavailabilitySwitchAction.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (UnavailabilitySwitchAction.fields (position), value)
        emitelem (0, open)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:UnavailabilitySwitchAction rdf:ID=\"%s\">\n%s\t</cim:UnavailabilitySwitchAction>".format (id, export_fields)
    }
}

object UnavailabilitySwitchAction
extends
    Parseable[UnavailabilitySwitchAction]
{
    override val fields: Array[String] = Array[String] (
        "open"
    )
    val open: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): UnavailabilitySwitchAction =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = UnavailabilitySwitchAction (
            IdentifiedObject.parse (context),
            toBoolean (mask (open (), 0))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A schedule of unavailability for one or more specified equipment that need to follow the same scheduling periods.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param DependsOn [[ch.ninecode.model.UnavailabilityScheduleDependency UnavailabilityScheduleDependency]] <em>undocumented</em>
 * @param Impacts [[ch.ninecode.model.UnavailabilityScheduleDependency UnavailabilityScheduleDependency]] <em>undocumented</em>
 * @group InfAvailabilityPlans
 * @groupname InfAvailabilityPlans Package InfAvailabilityPlans
 * @groupdesc InfAvailabilityPlans Contains the planned schedules for equipment availability, primarily intended for future studies.
 */
final case class UnavailablitySchedule
(
    override val sup: IdentifiedObject,
    DependsOn: List[String],
    Impacts: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[UnavailablitySchedule] }
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
        implicit val clz: String = UnavailablitySchedule.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (UnavailablitySchedule.fields (position), x))
        emitattrs (0, DependsOn)
        emitattrs (1, Impacts)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:UnavailablitySchedule rdf:ID=\"%s\">\n%s\t</cim:UnavailablitySchedule>".format (id, export_fields)
    }
}

object UnavailablitySchedule
extends
    Parseable[UnavailablitySchedule]
{
    override val fields: Array[String] = Array[String] (
        "DependsOn",
        "Impacts"
    )
    override val relations: List[Relationship] = List (
        Relationship ("DependsOn", "UnavailabilityScheduleDependency", "0..*", "1"),
        Relationship ("Impacts", "UnavailabilityScheduleDependency", "0..*", "1")
    )
    val DependsOn: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val Impacts: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): UnavailablitySchedule =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = UnavailablitySchedule (
            IdentifiedObject.parse (context),
            masks (DependsOn (), 0),
            masks (Impacts (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _InfAvailabilityPlans
{
    def register: List[ClassInfo] =
    {
        List (
            AvailablityPlan.register,
            EquipmentUnavailabilitySchedule.register,
            UnavailabilityScheduleDependency.register,
            UnavailabilitySwitchAction.register,
            UnavailablitySchedule.register
        )
    }
}