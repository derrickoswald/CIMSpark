package ch.ninecode.model

import com.esotericsoftware.kryo.Kryo
import com.esotericsoftware.kryo.io.Input
import com.esotericsoftware.kryo.io.Output
import org.apache.spark.sql.Row

import ch.ninecode.cim.CIMClassInfo
import ch.ninecode.cim.CIMContext
import ch.ninecode.cim.CIMParseable
import ch.ninecode.cim.CIMRelationship
import ch.ninecode.cim.CIMSerializer

/**
 * The collection of all the availability schedules for a given time range.
 *
 * Only one availability plan shall be valid for the same period.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param validPeriod The period of time for which the plan is valid.
 * @group InfAvailabilityPlans
 * @groupname InfAvailabilityPlans Package InfAvailabilityPlans
 * @groupdesc InfAvailabilityPlans Contains the planned schedules for equipment availability, primarily intended for future studies.
 */
final case class AvailablityPlan
(
    IdentifiedObject: IdentifiedObject = null,
    validPeriod: String = null
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
    CIMParseable[AvailablityPlan]
{
    override val fields: Array[String] = Array[String] (
        "validPeriod"
    )
    val validPeriod: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): AvailablityPlan =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AvailablityPlan (
            IdentifiedObject.parse (context),
            mask (validPeriod (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

object AvailablityPlanSerializer extends CIMSerializer[AvailablityPlan]
{
    def write (kryo: Kryo, output: Output, obj: AvailablityPlan): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.validPeriod)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AvailablityPlan]): AvailablityPlan =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = AvailablityPlan (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group InfAvailabilityPlans
 * @groupname InfAvailabilityPlans Package InfAvailabilityPlans
 * @groupdesc InfAvailabilityPlans Contains the planned schedules for equipment availability, primarily intended for future studies.
 */
final case class EquipmentUnavailabilitySchedule
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
        "\t<cim:EquipmentUnavailabilitySchedule rdf:ID=\"%s\">\n%s\t</cim:EquipmentUnavailabilitySchedule>".format (id, export_fields)
    }
}

object EquipmentUnavailabilitySchedule
extends
    CIMParseable[EquipmentUnavailabilitySchedule]
{

    def parse (context: CIMContext): EquipmentUnavailabilitySchedule =
    {
        val ret = EquipmentUnavailabilitySchedule (
            IdentifiedObject.parse (context)
        )
        ret
    }
}

object EquipmentUnavailabilityScheduleSerializer extends CIMSerializer[EquipmentUnavailabilitySchedule]
{
    def write (kryo: Kryo, output: Output, obj: EquipmentUnavailabilitySchedule): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[EquipmentUnavailabilitySchedule]): EquipmentUnavailabilitySchedule =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = EquipmentUnavailabilitySchedule (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group InfAvailabilityPlans
 * @groupname InfAvailabilityPlans Package InfAvailabilityPlans
 * @groupdesc InfAvailabilityPlans Contains the planned schedules for equipment availability, primarily intended for future studies.
 */
final case class UnavailabilityScheduleDependency
(
    IdentifiedObject: IdentifiedObject = null,
    UnavailabilityScheduleDependsOn: String = null,
    UnavailabilityScheduleImpacts: String = null
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
    CIMParseable[UnavailabilityScheduleDependency]
{
    override val fields: Array[String] = Array[String] (
        "UnavailabilityScheduleDependsOn",
        "UnavailabilityScheduleImpacts"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("UnavailabilityScheduleDependsOn", "UnavailablitySchedule", "1", "0..*"),
        CIMRelationship ("UnavailabilityScheduleImpacts", "UnavailablitySchedule", "1", "0..*")
    )
    val UnavailabilityScheduleDependsOn: Fielder = parse_attribute (attribute (cls, fields(0)))
    val UnavailabilityScheduleImpacts: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): UnavailabilityScheduleDependency =
    {
        implicit val ctx: CIMContext = context
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

object UnavailabilityScheduleDependencySerializer extends CIMSerializer[UnavailabilityScheduleDependency]
{
    def write (kryo: Kryo, output: Output, obj: UnavailabilityScheduleDependency): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.UnavailabilityScheduleDependsOn),
            () => output.writeString (obj.UnavailabilityScheduleImpacts)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[UnavailabilityScheduleDependency]): UnavailabilityScheduleDependency =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = UnavailabilityScheduleDependency (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Relevant switching action for supporting the availability (or unavailability) plans.
 *
 * This could open or close a switch that is not directly connected to the unavailable equipment .
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param open The switch is to be open during the scheduled period.
 * @group InfAvailabilityPlans
 * @groupname InfAvailabilityPlans Package InfAvailabilityPlans
 * @groupdesc InfAvailabilityPlans Contains the planned schedules for equipment availability, primarily intended for future studies.
 */
final case class UnavailabilitySwitchAction
(
    IdentifiedObject: IdentifiedObject = null,
    open: Boolean = false
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
    CIMParseable[UnavailabilitySwitchAction]
{
    override val fields: Array[String] = Array[String] (
        "open"
    )
    val open: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: CIMContext): UnavailabilitySwitchAction =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = UnavailabilitySwitchAction (
            IdentifiedObject.parse (context),
            toBoolean (mask (open (), 0))
        )
        ret.bitfields = bitfields
        ret
    }
}

object UnavailabilitySwitchActionSerializer extends CIMSerializer[UnavailabilitySwitchAction]
{
    def write (kryo: Kryo, output: Output, obj: UnavailabilitySwitchAction): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeBoolean (obj.open)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[UnavailabilitySwitchAction]): UnavailabilitySwitchAction =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = UnavailabilitySwitchAction (
            parent,
            if (isSet (0)) input.readBoolean else false
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A schedule of unavailability for one or more specified equipment that need to follow the same scheduling periods.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param DependsOn [[ch.ninecode.model.UnavailabilityScheduleDependency UnavailabilityScheduleDependency]] <em>undocumented</em>
 * @param Impacts [[ch.ninecode.model.UnavailabilityScheduleDependency UnavailabilityScheduleDependency]] <em>undocumented</em>
 * @group InfAvailabilityPlans
 * @groupname InfAvailabilityPlans Package InfAvailabilityPlans
 * @groupdesc InfAvailabilityPlans Contains the planned schedules for equipment availability, primarily intended for future studies.
 */
final case class UnavailablitySchedule
(
    IdentifiedObject: IdentifiedObject = null,
    DependsOn: List[String] = null,
    Impacts: List[String] = null
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
    CIMParseable[UnavailablitySchedule]
{
    override val fields: Array[String] = Array[String] (
        "DependsOn",
        "Impacts"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("DependsOn", "UnavailabilityScheduleDependency", "0..*", "1"),
        CIMRelationship ("Impacts", "UnavailabilityScheduleDependency", "0..*", "1")
    )
    val DependsOn: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val Impacts: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): UnavailablitySchedule =
    {
        implicit val ctx: CIMContext = context
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

object UnavailablityScheduleSerializer extends CIMSerializer[UnavailablitySchedule]
{
    def write (kryo: Kryo, output: Output, obj: UnavailablitySchedule): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.DependsOn, output),
            () => writeList (obj.Impacts, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[UnavailablitySchedule]): UnavailablitySchedule =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = UnavailablitySchedule (
            parent,
            if (isSet (0)) readList (input) else null,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _InfAvailabilityPlans
{
    def register: List[CIMClassInfo] =
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