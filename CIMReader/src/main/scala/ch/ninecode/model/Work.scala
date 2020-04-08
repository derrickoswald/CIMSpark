package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Common representation for work and work tasks.
 *
 * @param sup [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param kind Kind of work.
 * @param priority Priority of work.
 * @param statusKind Kind of work status.
 * @param TimeSchedules [[ch.ninecode.model.WorkTimeSchedule WorkTimeSchedule]] All time schedules for this work or work task.
 * @param WorkActivityRecords [[ch.ninecode.model.WorkActivityRecord WorkActivityRecord]] All activity records for this work or work task.
 * @param WorkLocation [[ch.ninecode.model.WorkLocation WorkLocation]] Location for this work/task.
 * @group Work
 * @groupname Work Package Work
 * @groupdesc Work This package contains the core information classes that support work management and network extension planning applications.
 */
final case class BaseWork
(
    override val sup: Document = null,
    kind: String = null,
    priority: String = null,
    statusKind: String = null,
    TimeSchedules: List[String] = null,
    WorkActivityRecords: List[String] = null,
    WorkLocation: String = null
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
    def Document: Document = sup
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
        implicit val clz: String = BaseWork.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (BaseWork.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (BaseWork.fields (position), x))
        emitattr (0, kind)
        emitattr (1, priority)
        emitattr (2, statusKind)
        emitattrs (3, TimeSchedules)
        emitattrs (4, WorkActivityRecords)
        emitattr (5, WorkLocation)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:BaseWork rdf:ID=\"%s\">\n%s\t</cim:BaseWork>".format (id, export_fields)
    }
}

object BaseWork
extends
    Parseable[BaseWork]
{
    override val fields: Array[String] = Array[String] (
        "kind",
        "priority",
        "statusKind",
        "TimeSchedules",
        "WorkActivityRecords",
        "WorkLocation"
    )
    override val relations: List[Relationship] = List (
        Relationship ("TimeSchedules", "WorkTimeSchedule", "0..*", "0..1"),
        Relationship ("WorkActivityRecords", "WorkActivityRecord", "0..*", "0..1"),
        Relationship ("WorkLocation", "WorkLocation", "0..1", "0..*")
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val priority: Fielder = parse_attribute (attribute (cls, fields(1)))
    val statusKind: Fielder = parse_attribute (attribute (cls, fields(2)))
    val TimeSchedules: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val WorkActivityRecords: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val WorkLocation: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: Context): BaseWork =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = BaseWork (
            Document.parse (context),
            mask (kind (), 0),
            mask (priority (), 1),
            mask (statusKind (), 2),
            masks (TimeSchedules (), 3),
            masks (WorkActivityRecords (), 4),
            mask (WorkLocation (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Description of location internal to a building.
 *
 * @param sup [[ch.ninecode.model.WorkLocation WorkLocation]] Reference to the superclass object.
 * @param buildingName Name of building where location is.
 * @param buildingNumber Number of building where location is.
 * @param floor Floor of location.
 * @param roomNumber Room number of location.
 * @group Work
 * @groupname Work Package Work
 * @groupdesc Work This package contains the core information classes that support work management and network extension planning applications.
 */
final case class InternalLocation
(
    override val sup: WorkLocation = null,
    buildingName: String = null,
    buildingNumber: String = null,
    floor: Int = 0,
    roomNumber: String = null
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
    def WorkLocation: WorkLocation = sup
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
        implicit val clz: String = InternalLocation.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (InternalLocation.fields (position), value)
        emitelem (0, buildingName)
        emitelem (1, buildingNumber)
        emitelem (2, floor)
        emitelem (3, roomNumber)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:InternalLocation rdf:ID=\"%s\">\n%s\t</cim:InternalLocation>".format (id, export_fields)
    }
}

object InternalLocation
extends
    Parseable[InternalLocation]
{
    override val fields: Array[String] = Array[String] (
        "buildingName",
        "buildingNumber",
        "floor",
        "roomNumber"
    )
    val buildingName: Fielder = parse_element (element (cls, fields(0)))
    val buildingNumber: Fielder = parse_element (element (cls, fields(1)))
    val floor: Fielder = parse_element (element (cls, fields(2)))
    val roomNumber: Fielder = parse_element (element (cls, fields(3)))

    def parse (context: Context): InternalLocation =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = InternalLocation (
            WorkLocation.parse (context),
            mask (buildingName (), 0),
            mask (buildingNumber (), 1),
            toInteger (mask (floor (), 2)),
            mask (roomNumber (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Location where to perform maintenance work.
 *
 * @param sup [[ch.ninecode.model.WorkLocation WorkLocation]] Reference to the superclass object.
 * @param block (if applicable) Name, identifier, or description of the block in which work is to occur.
 * @param lot (if applicable) Name, identifier, or description of the lot in which work is to occur.
 * @param nearestIntersection The names of streets at the nearest intersection to work area.
 * @param subdivision (if applicable) Name, identifier, or description of the subdivision in which work is to occur.
 * @group Work
 * @groupname Work Package Work
 * @groupdesc Work This package contains the core information classes that support work management and network extension planning applications.
 */
final case class MaintenanceLocation
(
    override val sup: WorkLocation = null,
    block: String = null,
    lot: String = null,
    nearestIntersection: String = null,
    subdivision: String = null
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
    def WorkLocation: WorkLocation = sup
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
        implicit val clz: String = MaintenanceLocation.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MaintenanceLocation.fields (position), value)
        emitelem (0, block)
        emitelem (1, lot)
        emitelem (2, nearestIntersection)
        emitelem (3, subdivision)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MaintenanceLocation rdf:ID=\"%s\">\n%s\t</cim:MaintenanceLocation>".format (id, export_fields)
    }
}

object MaintenanceLocation
extends
    Parseable[MaintenanceLocation]
{
    override val fields: Array[String] = Array[String] (
        "block",
        "lot",
        "nearestIntersection",
        "subdivision"
    )
    val block: Fielder = parse_element (element (cls, fields(0)))
    val lot: Fielder = parse_element (element (cls, fields(1)))
    val nearestIntersection: Fielder = parse_element (element (cls, fields(2)))
    val subdivision: Fielder = parse_element (element (cls, fields(3)))

    def parse (context: Context): MaintenanceLocation =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MaintenanceLocation (
            WorkLocation.parse (context),
            mask (block (), 0),
            mask (lot (), 1),
            mask (nearestIntersection (), 2),
            mask (subdivision (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Maintenance work task.
 *
 * Costs associated with this are considered preventive maintenance (PM) costs.
 *
 * @param sup [[ch.ninecode.model.WorkTask WorkTask]] Reference to the superclass object.
 * @param breakerMaintenanceKind Kind of breaker maintenance performed by this maintenance work task.
 * @param transformerMaintenanceKind Kind of transformer maintenance performed by this maintenance work task.
 * @group Work
 * @groupname Work Package Work
 * @groupdesc Work This package contains the core information classes that support work management and network extension planning applications.
 */
final case class MaintenanceWorkTask
(
    override val sup: WorkTask = null,
    breakerMaintenanceKind: String = null,
    transformerMaintenanceKind: String = null
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
    def WorkTask: WorkTask = sup
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
        implicit val clz: String = MaintenanceWorkTask.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MaintenanceWorkTask.fields (position), value)
        emitattr (0, breakerMaintenanceKind)
        emitattr (1, transformerMaintenanceKind)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MaintenanceWorkTask rdf:ID=\"%s\">\n%s\t</cim:MaintenanceWorkTask>".format (id, export_fields)
    }
}

object MaintenanceWorkTask
extends
    Parseable[MaintenanceWorkTask]
{
    override val fields: Array[String] = Array[String] (
        "breakerMaintenanceKind",
        "transformerMaintenanceKind"
    )
    val breakerMaintenanceKind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val transformerMaintenanceKind: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): MaintenanceWorkTask =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MaintenanceWorkTask (
            WorkTask.parse (context),
            mask (breakerMaintenanceKind (), 0),
            mask (transformerMaintenanceKind (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The physical consumable supply used for work and other purposes.
 *
 * It includes items such as nuts, bolts, brackets, glue, etc.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param quantity Quantity of material used.
 * @param TypeMaterial [[ch.ninecode.model.TypeMaterial TypeMaterial]] <em>undocumented</em>
 * @param WorkTask [[ch.ninecode.model.WorkTask WorkTask]] <em>undocumented</em>
 * @group Work
 * @groupname Work Package Work
 * @groupdesc Work This package contains the core information classes that support work management and network extension planning applications.
 */
final case class MaterialItem
(
    override val sup: IdentifiedObject = null,
    quantity: String = null,
    TypeMaterial: String = null,
    WorkTask: String = null
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
        implicit val clz: String = MaterialItem.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MaterialItem.fields (position), value)
        emitattr (0, quantity)
        emitattr (1, TypeMaterial)
        emitattr (2, WorkTask)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MaterialItem rdf:ID=\"%s\">\n%s\t</cim:MaterialItem>".format (id, export_fields)
    }
}

object MaterialItem
extends
    Parseable[MaterialItem]
{
    override val fields: Array[String] = Array[String] (
        "quantity",
        "TypeMaterial",
        "WorkTask"
    )
    override val relations: List[Relationship] = List (
        Relationship ("TypeMaterial", "TypeMaterial", "0..1", "0..*"),
        Relationship ("WorkTask", "WorkTask", "0..1", "0..*")
    )
    val quantity: Fielder = parse_attribute (attribute (cls, fields(0)))
    val TypeMaterial: Fielder = parse_attribute (attribute (cls, fields(1)))
    val WorkTask: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): MaterialItem =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MaterialItem (
            IdentifiedObject.parse (context),
            mask (quantity (), 0),
            mask (TypeMaterial (), 1),
            mask (WorkTask (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Asset component to be repaired or problem area to be corrected.
 *
 * @param sup Reference to the superclass object.
 * @param breakerRepairItem Breaker component or problem area which is the focus of this maintenance work task (for work tasks related to breakers only).
 * @param transformerRepairItem Transformer component or problem area which is the focus of this maintenance work task (for work tasks related to transformers only).
 * @param RepairWorkTask [[ch.ninecode.model.RepairWorkTask RepairWorkTask]] Repair work task under which breaker item of this type is repaired.
 * @group Work
 * @groupname Work Package Work
 * @groupdesc Work This package contains the core information classes that support work management and network extension planning applications.
 */
final case class RepairItem
(
    override val sup: BasicElement = null,
    breakerRepairItem: String = null,
    transformerRepairItem: String = null,
    RepairWorkTask: List[String] = null
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
        implicit val clz: String = RepairItem.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RepairItem.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (RepairItem.fields (position), x))
        emitattr (0, breakerRepairItem)
        emitattr (1, transformerRepairItem)
        emitattrs (2, RepairWorkTask)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RepairItem rdf:ID=\"%s\">\n%s\t</cim:RepairItem>".format (id, export_fields)
    }
}

object RepairItem
extends
    Parseable[RepairItem]
{
    override val fields: Array[String] = Array[String] (
        "breakerRepairItem",
        "transformerRepairItem",
        "RepairWorkTask"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RepairWorkTask", "RepairWorkTask", "0..*", "0..*")
    )
    val breakerRepairItem: Fielder = parse_attribute (attribute (cls, fields(0)))
    val transformerRepairItem: Fielder = parse_attribute (attribute (cls, fields(1)))
    val RepairWorkTask: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: Context): RepairItem =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = RepairItem (
            BasicElement.parse (context),
            mask (breakerRepairItem (), 0),
            mask (transformerRepairItem (), 1),
            masks (RepairWorkTask (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Work task for asset repair.
 *
 * Costs associated with this are considered corrective maintenance (CM) costs.
 *
 * @param sup [[ch.ninecode.model.WorkTask WorkTask]] Reference to the superclass object.
 * @param emergency Repair work is emergency.
 * @param BreakerRepairItem [[ch.ninecode.model.RepairItem RepairItem]] Type of breaker item to be repaird by this repair work task.
 * @group Work
 * @groupname Work Package Work
 * @groupdesc Work This package contains the core information classes that support work management and network extension planning applications.
 */
final case class RepairWorkTask
(
    override val sup: WorkTask = null,
    emergency: Boolean = false,
    BreakerRepairItem: List[String] = null
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
    def WorkTask: WorkTask = sup
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
        implicit val clz: String = RepairWorkTask.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (RepairWorkTask.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (RepairWorkTask.fields (position), x))
        emitelem (0, emergency)
        emitattrs (1, BreakerRepairItem)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RepairWorkTask rdf:ID=\"%s\">\n%s\t</cim:RepairWorkTask>".format (id, export_fields)
    }
}

object RepairWorkTask
extends
    Parseable[RepairWorkTask]
{
    override val fields: Array[String] = Array[String] (
        "emergency",
        "BreakerRepairItem"
    )
    override val relations: List[Relationship] = List (
        Relationship ("BreakerRepairItem", "RepairItem", "0..*", "0..*")
    )
    val emergency: Fielder = parse_element (element (cls, fields(0)))
    val BreakerRepairItem: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): RepairWorkTask =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = RepairWorkTask (
            WorkTask.parse (context),
            toBoolean (mask (emergency (), 0)),
            masks (BreakerRepairItem (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Tool asset.
 *
 * @param sup [[ch.ninecode.model.WorkAsset WorkAsset]] Reference to the superclass object.
 * @param lastCalibrationDate (if applicable) Date the tool was last calibrated.
 * @group Work
 * @groupname Work Package Work
 * @groupdesc Work This package contains the core information classes that support work management and network extension planning applications.
 */
final case class Tool
(
    override val sup: WorkAsset = null,
    lastCalibrationDate: String = null
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
    def WorkAsset: WorkAsset = sup
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
        implicit val clz: String = Tool.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Tool.fields (position), value)
        emitelem (0, lastCalibrationDate)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Tool rdf:ID=\"%s\">\n%s\t</cim:Tool>".format (id, export_fields)
    }
}

object Tool
extends
    Parseable[Tool]
{
    override val fields: Array[String] = Array[String] (
        "lastCalibrationDate"
    )
    val lastCalibrationDate: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): Tool =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Tool (
            WorkAsset.parse (context),
            mask (lastCalibrationDate (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Vehicle asset.
 *
 * @param sup [[ch.ninecode.model.WorkAsset WorkAsset]] Reference to the superclass object.
 * @param odometerReadDateTime Date and time the last odometer reading was recorded.
 * @param odometerReading Odometer reading of this vehicle as of the 'odometerReadingDateTime'.
 *        Refer to associated ActivityRecords for earlier readings.
 * @param usageKind Kind of usage of the vehicle.
 * @group Work
 * @groupname Work Package Work
 * @groupdesc Work This package contains the core information classes that support work management and network extension planning applications.
 */
final case class Vehicle
(
    override val sup: WorkAsset = null,
    odometerReadDateTime: String = null,
    odometerReading: Double = 0.0,
    usageKind: String = null
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
    def WorkAsset: WorkAsset = sup
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
        implicit val clz: String = Vehicle.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Vehicle.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Vehicle.fields (position), value)
        emitelem (0, odometerReadDateTime)
        emitelem (1, odometerReading)
        emitattr (2, usageKind)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Vehicle rdf:ID=\"%s\">\n%s\t</cim:Vehicle>".format (id, export_fields)
    }
}

object Vehicle
extends
    Parseable[Vehicle]
{
    override val fields: Array[String] = Array[String] (
        "odometerReadDateTime",
        "odometerReading",
        "usageKind"
    )
    val odometerReadDateTime: Fielder = parse_element (element (cls, fields(0)))
    val odometerReading: Fielder = parse_element (element (cls, fields(1)))
    val usageKind: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): Vehicle =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Vehicle (
            WorkAsset.parse (context),
            mask (odometerReadDateTime (), 0),
            toDouble (mask (odometerReading (), 1)),
            mask (usageKind (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Document used to request, initiate, track and record work.
 *
 * @param sup [[ch.ninecode.model.BaseWork BaseWork]] Reference to the superclass object.
 * @param requestDateTime Date and time work was requested.
 * @param workOrderNumber Work order number (or other unique identifying information) for this work.
 * @param Appointments [[ch.ninecode.model.Appointment Appointment]] All appointments for this work.
 * @param BusinessCase [[ch.ninecode.model.BusinessCase BusinessCase]] <em>undocumented</em>
 * @param Customers [[ch.ninecode.model.Customer Customer]] All the customers for which this work is performed.
 * @param Designs [[ch.ninecode.model.Design Design]] <em>undocumented</em>
 * @param ErpProjectAccounting [[ch.ninecode.model.ErpProjectAccounting ErpProjectAccounting]] <em>undocumented</em>
 * @param Incidents [[ch.ninecode.model.Incident Incident]] All incidents being addressed by this work.
 * @param Project [[ch.ninecode.model.Project Project]] <em>undocumented</em>
 * @param WorkBillingInfo [[ch.ninecode.model.WorkBillingInfo WorkBillingInfo]] <em>undocumented</em>
 * @param WorkCostDetails [[ch.ninecode.model.WorkCostDetail WorkCostDetail]] <em>undocumented</em>
 * @param WorkFlowSteps [[ch.ninecode.model.WorkFlowStep WorkFlowStep]] <em>undocumented</em>
 * @param WorkTasks [[ch.ninecode.model.WorkTask WorkTask]] All tasks in this work.
 * @group Work
 * @groupname Work Package Work
 * @groupdesc Work This package contains the core information classes that support work management and network extension planning applications.
 */
final case class Work
(
    override val sup: BaseWork = null,
    requestDateTime: String = null,
    workOrderNumber: String = null,
    Appointments: List[String] = null,
    BusinessCase: String = null,
    Customers: List[String] = null,
    Designs: List[String] = null,
    ErpProjectAccounting: String = null,
    Incidents: List[String] = null,
    Project: String = null,
    WorkBillingInfo: String = null,
    WorkCostDetails: List[String] = null,
    WorkFlowSteps: List[String] = null,
    WorkTasks: List[String] = null
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
    def BaseWork: BaseWork = sup
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
        implicit val clz: String = Work.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Work.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Work.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Work.fields (position), x))
        emitelem (0, requestDateTime)
        emitelem (1, workOrderNumber)
        emitattrs (2, Appointments)
        emitattr (3, BusinessCase)
        emitattrs (4, Customers)
        emitattrs (5, Designs)
        emitattr (6, ErpProjectAccounting)
        emitattrs (7, Incidents)
        emitattr (8, Project)
        emitattr (9, WorkBillingInfo)
        emitattrs (10, WorkCostDetails)
        emitattrs (11, WorkFlowSteps)
        emitattrs (12, WorkTasks)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Work rdf:ID=\"%s\">\n%s\t</cim:Work>".format (id, export_fields)
    }
}

object Work
extends
    Parseable[Work]
{
    override val fields: Array[String] = Array[String] (
        "requestDateTime",
        "workOrderNumber",
        "Appointments",
        "BusinessCase",
        "Customers",
        "Designs",
        "ErpProjectAccounting",
        "Incidents",
        "Project",
        "WorkBillingInfo",
        "WorkCostDetails",
        "WorkFlowSteps",
        "WorkTasks"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Appointments", "Appointment", "0..*", "0..*"),
        Relationship ("BusinessCase", "BusinessCase", "0..1", "0..*"),
        Relationship ("Customers", "Customer", "0..*", "0..*"),
        Relationship ("Designs", "Design", "0..*", "0..1"),
        Relationship ("ErpProjectAccounting", "ErpProjectAccounting", "0..1", "0..*"),
        Relationship ("Incidents", "Incident", "0..*", "0..*"),
        Relationship ("Project", "Project", "0..1", "0..*"),
        Relationship ("WorkBillingInfo", "WorkBillingInfo", "0..1", "0..*"),
        Relationship ("WorkCostDetails", "WorkCostDetail", "0..*", "0..*"),
        Relationship ("WorkFlowSteps", "WorkFlowStep", "0..*", "0..1"),
        Relationship ("WorkTasks", "WorkTask", "0..*", "1")
    )
    val requestDateTime: Fielder = parse_element (element (cls, fields(0)))
    val workOrderNumber: Fielder = parse_element (element (cls, fields(1)))
    val Appointments: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val BusinessCase: Fielder = parse_attribute (attribute (cls, fields(3)))
    val Customers: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val Designs: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val ErpProjectAccounting: Fielder = parse_attribute (attribute (cls, fields(6)))
    val Incidents: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val Project: Fielder = parse_attribute (attribute (cls, fields(8)))
    val WorkBillingInfo: Fielder = parse_attribute (attribute (cls, fields(9)))
    val WorkCostDetails: FielderMultiple = parse_attributes (attribute (cls, fields(10)))
    val WorkFlowSteps: FielderMultiple = parse_attributes (attribute (cls, fields(11)))
    val WorkTasks: FielderMultiple = parse_attributes (attribute (cls, fields(12)))

    def parse (context: Context): Work =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Work (
            BaseWork.parse (context),
            mask (requestDateTime (), 0),
            mask (workOrderNumber (), 1),
            masks (Appointments (), 2),
            mask (BusinessCase (), 3),
            masks (Customers (), 4),
            masks (Designs (), 5),
            mask (ErpProjectAccounting (), 6),
            masks (Incidents (), 7),
            mask (Project (), 8),
            mask (WorkBillingInfo (), 9),
            masks (WorkCostDetails (), 10),
            masks (WorkFlowSteps (), 11),
            masks (WorkTasks (), 12)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Records information about the status of work or work task at a point in time.
 *
 * @param sup [[ch.ninecode.model.ActivityRecord ActivityRecord]] Reference to the superclass object.
 * @param percentComplete Estimated percentage of completion of this individual work task or overall work order.
 * @param BaseWork [[ch.ninecode.model.BaseWork BaseWork]] Base work that this activity record tracks.
 * @group Work
 * @groupname Work Package Work
 * @groupdesc Work This package contains the core information classes that support work management and network extension planning applications.
 */
final case class WorkActivityRecord
(
    override val sup: ActivityRecord = null,
    percentComplete: Double = 0.0,
    BaseWork: String = null
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
    def ActivityRecord: ActivityRecord = sup
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
        implicit val clz: String = WorkActivityRecord.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (WorkActivityRecord.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WorkActivityRecord.fields (position), value)
        emitelem (0, percentComplete)
        emitattr (1, BaseWork)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WorkActivityRecord rdf:ID=\"%s\">\n%s\t</cim:WorkActivityRecord>".format (id, export_fields)
    }
}

object WorkActivityRecord
extends
    Parseable[WorkActivityRecord]
{
    override val fields: Array[String] = Array[String] (
        "percentComplete",
        "BaseWork"
    )
    override val relations: List[Relationship] = List (
        Relationship ("BaseWork", "BaseWork", "0..1", "0..*")
    )
    val percentComplete: Fielder = parse_element (element (cls, fields(0)))
    val BaseWork: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): WorkActivityRecord =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WorkActivityRecord (
            ActivityRecord.parse (context),
            toDouble (mask (percentComplete (), 0)),
            mask (BaseWork (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Asset used to perform work.
 *
 * @param sup [[ch.ninecode.model.Asset Asset]] Reference to the superclass object.
 * @param CUWorkEquipmentAsset [[ch.ninecode.model.CUWorkEquipmentItem CUWorkEquipmentItem]] <em>undocumented</em>
 * @param Crew [[ch.ninecode.model.Crew Crew]] Crew using this work asset.
 * @group Work
 * @groupname Work Package Work
 * @groupdesc Work This package contains the core information classes that support work management and network extension planning applications.
 */
final case class WorkAsset
(
    override val sup: Asset = null,
    CUWorkEquipmentAsset: String = null,
    Crew: String = null
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
    def Asset: Asset = sup
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
        implicit val clz: String = WorkAsset.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WorkAsset.fields (position), value)
        emitattr (0, CUWorkEquipmentAsset)
        emitattr (1, Crew)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WorkAsset rdf:ID=\"%s\">\n%s\t</cim:WorkAsset>".format (id, export_fields)
    }
}

object WorkAsset
extends
    Parseable[WorkAsset]
{
    override val fields: Array[String] = Array[String] (
        "CUWorkEquipmentAsset",
        "Crew"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CUWorkEquipmentAsset", "CUWorkEquipmentItem", "0..1", "0..1"),
        Relationship ("Crew", "Crew", "0..1", "0..*")
    )
    val CUWorkEquipmentAsset: Fielder = parse_attribute (attribute (cls, fields(0)))
    val Crew: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): WorkAsset =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WorkAsset (
            Asset.parse (context),
            mask (CUWorkEquipmentAsset (), 0),
            mask (Crew (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Information about a particular location for various forms of work.
 *
 * @param sup [[ch.ninecode.model.Location Location]] Reference to the superclass object.
 * @param BaseWorks [[ch.ninecode.model.BaseWork BaseWork]] All works/tasks at this location.
 * @param DesignLocations [[ch.ninecode.model.DesignLocation DesignLocation]] <em>undocumented</em>
 * @param OneCallRequest [[ch.ninecode.model.OneCallRequest OneCallRequest]] <em>undocumented</em>
 * @group Work
 * @groupname Work Package Work
 * @groupdesc Work This package contains the core information classes that support work management and network extension planning applications.
 */
final case class WorkLocation
(
    override val sup: Location = null,
    BaseWorks: List[String] = null,
    DesignLocations: List[String] = null,
    OneCallRequest: String = null
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
    def Location: Location = sup
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
        implicit val clz: String = WorkLocation.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WorkLocation.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (WorkLocation.fields (position), x))
        emitattrs (0, BaseWorks)
        emitattrs (1, DesignLocations)
        emitattr (2, OneCallRequest)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WorkLocation rdf:ID=\"%s\">\n%s\t</cim:WorkLocation>".format (id, export_fields)
    }
}

object WorkLocation
extends
    Parseable[WorkLocation]
{
    override val fields: Array[String] = Array[String] (
        "BaseWorks",
        "DesignLocations",
        "OneCallRequest"
    )
    override val relations: List[Relationship] = List (
        Relationship ("BaseWorks", "BaseWork", "0..*", "0..1"),
        Relationship ("DesignLocations", "DesignLocation", "0..*", "1..*"),
        Relationship ("OneCallRequest", "OneCallRequest", "0..1", "0..*")
    )
    val BaseWorks: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val DesignLocations: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val OneCallRequest: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): WorkLocation =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WorkLocation (
            Location.parse (context),
            masks (BaseWorks (), 0),
            masks (DesignLocations (), 1),
            mask (OneCallRequest (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A task within a set of work.
 *
 * @param sup [[ch.ninecode.model.BaseWork BaseWork]] Reference to the superclass object.
 * @param completedDateTime Date and time work task was completed.
 * @param contractorCost Total contractor costs associated with the work task.
 * @param crewETA Estimated time of arrival, so that customer or police/fire department can be informed when the crew will arrive.
 * @param instruction Instructions for performing this task.
 * @param laborCost Total labor costs associated with the work task.
 * @param laborHours Hours of labor expended under work task.
 * @param materiallCost Total material costs associated with the work task.
 * @param schedOverride If specified, override schedule and perform this task in accordance with instructions specified here.
 * @param startedDateTime Date and time work task was started.
 * @param taskKind Kind of work.
 * @param toolCost Total tool costs associated with the work task.
 * @param Assets [[ch.ninecode.model.Asset Asset]] All assets on which this non-replacement work task is performed.
 * @param Crews [[ch.ninecode.model.Crew Crew]] All crews participating in this work task.
 * @param MaterialItems [[ch.ninecode.model.MaterialItem MaterialItem]] <em>undocumented</em>
 * @param OldAsset [[ch.ninecode.model.Asset Asset]] Old asset replaced by this work task.
 * @param ProcedureDataSet [[ch.ninecode.model.ProcedureDataSet ProcedureDataSet]] Procedure data set associated with this work task.
 * @param SwitchingPlan [[ch.ninecode.model.SwitchingPlan SwitchingPlan]] Switching plan executed by this work task.
 * @param Work [[ch.ninecode.model.Work Work]] Work this task belongs to.
 * @group Work
 * @groupname Work Package Work
 * @groupdesc Work This package contains the core information classes that support work management and network extension planning applications.
 */
final case class WorkTask
(
    override val sup: BaseWork = null,
    completedDateTime: String = null,
    contractorCost: Double = 0.0,
    crewETA: String = null,
    instruction: String = null,
    laborCost: Double = 0.0,
    laborHours: Double = 0.0,
    materiallCost: Double = 0.0,
    schedOverride: String = null,
    startedDateTime: String = null,
    taskKind: String = null,
    toolCost: Double = 0.0,
    Assets: List[String] = null,
    Crews: List[String] = null,
    MaterialItems: List[String] = null,
    OldAsset: String = null,
    ProcedureDataSet: List[String] = null,
    SwitchingPlan: String = null,
    Work: String = null
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
    def BaseWork: BaseWork = sup
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
        implicit val clz: String = WorkTask.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (WorkTask.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WorkTask.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (WorkTask.fields (position), x))
        emitelem (0, completedDateTime)
        emitelem (1, contractorCost)
        emitelem (2, crewETA)
        emitelem (3, instruction)
        emitelem (4, laborCost)
        emitelem (5, laborHours)
        emitelem (6, materiallCost)
        emitelem (7, schedOverride)
        emitelem (8, startedDateTime)
        emitattr (9, taskKind)
        emitelem (10, toolCost)
        emitattrs (11, Assets)
        emitattrs (12, Crews)
        emitattrs (13, MaterialItems)
        emitattr (14, OldAsset)
        emitattrs (15, ProcedureDataSet)
        emitattr (16, SwitchingPlan)
        emitattr (17, Work)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WorkTask rdf:ID=\"%s\">\n%s\t</cim:WorkTask>".format (id, export_fields)
    }
}

object WorkTask
extends
    Parseable[WorkTask]
{
    override val fields: Array[String] = Array[String] (
        "completedDateTime",
        "contractorCost",
        "crewETA",
        "instruction",
        "laborCost",
        "laborHours",
        "materiallCost",
        "schedOverride",
        "startedDateTime",
        "taskKind",
        "toolCost",
        "Assets",
        "Crews",
        "MaterialItems",
        "OldAsset",
        "ProcedureDataSet",
        "SwitchingPlan",
        "Work"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Assets", "Asset", "0..*", "0..*"),
        Relationship ("Crews", "Crew", "0..*", "0..*"),
        Relationship ("MaterialItems", "MaterialItem", "0..*", "0..1"),
        Relationship ("OldAsset", "Asset", "0..1", "0..*"),
        Relationship ("ProcedureDataSet", "ProcedureDataSet", "0..*", "0..1"),
        Relationship ("SwitchingPlan", "SwitchingPlan", "0..1", "0..*"),
        Relationship ("Work", "Work", "1", "0..*")
    )
    val completedDateTime: Fielder = parse_element (element (cls, fields(0)))
    val contractorCost: Fielder = parse_element (element (cls, fields(1)))
    val crewETA: Fielder = parse_element (element (cls, fields(2)))
    val instruction: Fielder = parse_element (element (cls, fields(3)))
    val laborCost: Fielder = parse_element (element (cls, fields(4)))
    val laborHours: Fielder = parse_element (element (cls, fields(5)))
    val materiallCost: Fielder = parse_element (element (cls, fields(6)))
    val schedOverride: Fielder = parse_element (element (cls, fields(7)))
    val startedDateTime: Fielder = parse_element (element (cls, fields(8)))
    val taskKind: Fielder = parse_attribute (attribute (cls, fields(9)))
    val toolCost: Fielder = parse_element (element (cls, fields(10)))
    val Assets: FielderMultiple = parse_attributes (attribute (cls, fields(11)))
    val Crews: FielderMultiple = parse_attributes (attribute (cls, fields(12)))
    val MaterialItems: FielderMultiple = parse_attributes (attribute (cls, fields(13)))
    val OldAsset: Fielder = parse_attribute (attribute (cls, fields(14)))
    val ProcedureDataSet: FielderMultiple = parse_attributes (attribute (cls, fields(15)))
    val SwitchingPlan: Fielder = parse_attribute (attribute (cls, fields(16)))
    val Work: Fielder = parse_attribute (attribute (cls, fields(17)))

    def parse (context: Context): WorkTask =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WorkTask (
            BaseWork.parse (context),
            mask (completedDateTime (), 0),
            toDouble (mask (contractorCost (), 1)),
            mask (crewETA (), 2),
            mask (instruction (), 3),
            toDouble (mask (laborCost (), 4)),
            toDouble (mask (laborHours (), 5)),
            toDouble (mask (materiallCost (), 6)),
            mask (schedOverride (), 7),
            mask (startedDateTime (), 8),
            mask (taskKind (), 9),
            toDouble (mask (toolCost (), 10)),
            masks (Assets (), 11),
            masks (Crews (), 12),
            masks (MaterialItems (), 13),
            mask (OldAsset (), 14),
            masks (ProcedureDataSet (), 15),
            mask (SwitchingPlan (), 16),
            mask (Work (), 17)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Time schedule specific to work.
 *
 * @param sup [[ch.ninecode.model.TimeSchedule TimeSchedule]] Reference to the superclass object.
 * @param kind [[ch.ninecode.model.WorkTimeScheduleKind WorkTimeScheduleKind]] Kind of this work schedule.
 * @param BaseWork [[ch.ninecode.model.BaseWork BaseWork]] Time schedule for this work or work task.
 * @group Work
 * @groupname Work Package Work
 * @groupdesc Work This package contains the core information classes that support work management and network extension planning applications.
 */
final case class WorkTimeSchedule
(
    override val sup: TimeSchedule = null,
    kind: String = null,
    BaseWork: String = null
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
    def TimeSchedule: TimeSchedule = sup
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
        implicit val clz: String = WorkTimeSchedule.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WorkTimeSchedule.fields (position), value)
        emitattr (0, kind)
        emitattr (1, BaseWork)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WorkTimeSchedule rdf:ID=\"%s\">\n%s\t</cim:WorkTimeSchedule>".format (id, export_fields)
    }
}

object WorkTimeSchedule
extends
    Parseable[WorkTimeSchedule]
{
    override val fields: Array[String] = Array[String] (
        "kind",
        "BaseWork"
    )
    override val relations: List[Relationship] = List (
        Relationship ("kind", "WorkTimeScheduleKind", "0..1", "0..*"),
        Relationship ("BaseWork", "BaseWork", "0..1", "0..*")
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val BaseWork: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): WorkTimeSchedule =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WorkTimeSchedule (
            TimeSchedule.parse (context),
            mask (kind (), 0),
            mask (BaseWork (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Kind of work schedule.
 *
 * @param sup Reference to the superclass object.
 * @param actual Actual work time schedule.
 * @param earliest Earliest work time schedule.
 * @param estimate Estimate work time schedule.
 * @param immediate ??.
 * @param latest Latest work time schedule.
 * @param request Request work time schedule.
 * @group Work
 * @groupname Work Package Work
 * @groupdesc Work This package contains the core information classes that support work management and network extension planning applications.
 */
final case class WorkTimeScheduleKind
(
    override val sup: BasicElement = null,
    actual: String = null,
    earliest: String = null,
    estimate: String = null,
    immediate: String = null,
    latest: String = null,
    request: String = null
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
        implicit val clz: String = WorkTimeScheduleKind.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WorkTimeScheduleKind.fields (position), value)
        emitattr (0, actual)
        emitattr (1, earliest)
        emitattr (2, estimate)
        emitattr (3, immediate)
        emitattr (4, latest)
        emitattr (5, request)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WorkTimeScheduleKind rdf:ID=\"%s\">\n%s\t</cim:WorkTimeScheduleKind>".format (id, export_fields)
    }
}

object WorkTimeScheduleKind
extends
    Parseable[WorkTimeScheduleKind]
{
    override val fields: Array[String] = Array[String] (
        "actual",
        "earliest",
        "estimate",
        "immediate",
        "latest",
        "request"
    )
    val actual: Fielder = parse_attribute (attribute (cls, fields(0)))
    val earliest: Fielder = parse_attribute (attribute (cls, fields(1)))
    val estimate: Fielder = parse_attribute (attribute (cls, fields(2)))
    val immediate: Fielder = parse_attribute (attribute (cls, fields(3)))
    val latest: Fielder = parse_attribute (attribute (cls, fields(4)))
    val request: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: Context): WorkTimeScheduleKind =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WorkTimeScheduleKind (
            BasicElement.parse (context),
            mask (actual (), 0),
            mask (earliest (), 1),
            mask (estimate (), 2),
            mask (immediate (), 3),
            mask (latest (), 4),
            mask (request (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _Work
{
    def register: List[ClassInfo] =
    {
        List (
            BaseWork.register,
            InternalLocation.register,
            MaintenanceLocation.register,
            MaintenanceWorkTask.register,
            MaterialItem.register,
            RepairItem.register,
            RepairWorkTask.register,
            Tool.register,
            Vehicle.register,
            Work.register,
            WorkActivityRecord.register,
            WorkAsset.register,
            WorkLocation.register,
            WorkTask.register,
            WorkTimeSchedule.register,
            WorkTimeScheduleKind.register
        )
    }
}