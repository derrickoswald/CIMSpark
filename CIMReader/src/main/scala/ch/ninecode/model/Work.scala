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
 * Common representation for work and work tasks.
 *
 * @param Document [[ch.ninecode.model.Document Document]] Reference to the superclass object.
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
    Document: Document = null,
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
    override def sup: Document = Document

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
        "\t<cim:BaseWork rdf:%s=\"%s\">\n%s\t</cim:BaseWork>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object BaseWork
extends
    CIMParseable[BaseWork]
{
    override val fields: Array[String] = Array[String] (
        "kind",
        "priority",
        "statusKind",
        "TimeSchedules",
        "WorkActivityRecords",
        "WorkLocation"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("TimeSchedules", "WorkTimeSchedule", "0..*", "0..1"),
        CIMRelationship ("WorkActivityRecords", "WorkActivityRecord", "0..*", "0..1"),
        CIMRelationship ("WorkLocation", "WorkLocation", "0..1", "0..*")
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val priority: Fielder = parse_attribute (attribute (cls, fields(1)))
    val statusKind: Fielder = parse_attribute (attribute (cls, fields(2)))
    val TimeSchedules: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val WorkActivityRecords: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val WorkLocation: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: CIMContext): BaseWork =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[BaseWork] = BaseWorkSerializer
}

object BaseWorkSerializer extends CIMSerializer[BaseWork]
{
    def write (kryo: Kryo, output: Output, obj: BaseWork): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.kind),
            () => output.writeString (obj.priority),
            () => output.writeString (obj.statusKind),
            () => writeList (obj.TimeSchedules, output),
            () => writeList (obj.WorkActivityRecords, output),
            () => output.writeString (obj.WorkLocation)
        )
        DocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[BaseWork]): BaseWork =
    {
        val parent = DocumentSerializer.read (kryo, input, classOf[Document])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = BaseWork (
            parent,
            if (isSet (0)) input.readString else null,
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
 * Description of location internal to a building.
 *
 * @param WorkLocation [[ch.ninecode.model.WorkLocation WorkLocation]] Reference to the superclass object.
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
    WorkLocation: WorkLocation = null,
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
    override def sup: WorkLocation = WorkLocation

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
        "\t<cim:InternalLocation rdf:%s=\"%s\">\n%s\t</cim:InternalLocation>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object InternalLocation
extends
    CIMParseable[InternalLocation]
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

    def parse (context: CIMContext): InternalLocation =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[InternalLocation] = InternalLocationSerializer
}

object InternalLocationSerializer extends CIMSerializer[InternalLocation]
{
    def write (kryo: Kryo, output: Output, obj: InternalLocation): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.buildingName),
            () => output.writeString (obj.buildingNumber),
            () => output.writeInt (obj.floor),
            () => output.writeString (obj.roomNumber)
        )
        WorkLocationSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[InternalLocation]): InternalLocation =
    {
        val parent = WorkLocationSerializer.read (kryo, input, classOf[WorkLocation])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = InternalLocation (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readInt else 0,
            if (isSet (3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Location where to perform maintenance work.
 *
 * @param WorkLocation [[ch.ninecode.model.WorkLocation WorkLocation]] Reference to the superclass object.
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
    WorkLocation: WorkLocation = null,
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
    override def sup: WorkLocation = WorkLocation

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
        "\t<cim:MaintenanceLocation rdf:%s=\"%s\">\n%s\t</cim:MaintenanceLocation>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object MaintenanceLocation
extends
    CIMParseable[MaintenanceLocation]
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

    def parse (context: CIMContext): MaintenanceLocation =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[MaintenanceLocation] = MaintenanceLocationSerializer
}

object MaintenanceLocationSerializer extends CIMSerializer[MaintenanceLocation]
{
    def write (kryo: Kryo, output: Output, obj: MaintenanceLocation): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.block),
            () => output.writeString (obj.lot),
            () => output.writeString (obj.nearestIntersection),
            () => output.writeString (obj.subdivision)
        )
        WorkLocationSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MaintenanceLocation]): MaintenanceLocation =
    {
        val parent = WorkLocationSerializer.read (kryo, input, classOf[WorkLocation])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = MaintenanceLocation (
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
 * Maintenance work task.
 *
 * Costs associated with this are considered preventive maintenance (PM) costs.
 *
 * @param WorkTask [[ch.ninecode.model.WorkTask WorkTask]] Reference to the superclass object.
 * @param breakerMaintenanceKind Kind of breaker maintenance performed by this maintenance work task.
 * @param transformerMaintenanceKind Kind of transformer maintenance performed by this maintenance work task.
 * @group Work
 * @groupname Work Package Work
 * @groupdesc Work This package contains the core information classes that support work management and network extension planning applications.
 */
final case class MaintenanceWorkTask
(
    WorkTask: WorkTask = null,
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
    override def sup: WorkTask = WorkTask

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
        "\t<cim:MaintenanceWorkTask rdf:%s=\"%s\">\n%s\t</cim:MaintenanceWorkTask>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object MaintenanceWorkTask
extends
    CIMParseable[MaintenanceWorkTask]
{
    override val fields: Array[String] = Array[String] (
        "breakerMaintenanceKind",
        "transformerMaintenanceKind"
    )
    val breakerMaintenanceKind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val transformerMaintenanceKind: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): MaintenanceWorkTask =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MaintenanceWorkTask (
            WorkTask.parse (context),
            mask (breakerMaintenanceKind (), 0),
            mask (transformerMaintenanceKind (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[MaintenanceWorkTask] = MaintenanceWorkTaskSerializer
}

object MaintenanceWorkTaskSerializer extends CIMSerializer[MaintenanceWorkTask]
{
    def write (kryo: Kryo, output: Output, obj: MaintenanceWorkTask): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.breakerMaintenanceKind),
            () => output.writeString (obj.transformerMaintenanceKind)
        )
        WorkTaskSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MaintenanceWorkTask]): MaintenanceWorkTask =
    {
        val parent = WorkTaskSerializer.read (kryo, input, classOf[WorkTask])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = MaintenanceWorkTask (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The physical consumable supply used for work and other purposes.
 *
 * It includes items such as nuts, bolts, brackets, glue, etc.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param quantity Quantity of material used.
 * @param TypeMaterial [[ch.ninecode.model.TypeMaterial TypeMaterial]] <em>undocumented</em>
 * @param WorkTask [[ch.ninecode.model.WorkTask WorkTask]] <em>undocumented</em>
 * @group Work
 * @groupname Work Package Work
 * @groupdesc Work This package contains the core information classes that support work management and network extension planning applications.
 */
final case class MaterialItem
(
    IdentifiedObject: IdentifiedObject = null,
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
        implicit val clz: String = MaterialItem.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MaterialItem.fields (position), value)
        emitattr (0, quantity)
        emitattr (1, TypeMaterial)
        emitattr (2, WorkTask)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MaterialItem rdf:%s=\"%s\">\n%s\t</cim:MaterialItem>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object MaterialItem
extends
    CIMParseable[MaterialItem]
{
    override val fields: Array[String] = Array[String] (
        "quantity",
        "TypeMaterial",
        "WorkTask"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("TypeMaterial", "TypeMaterial", "0..1", "0..*"),
        CIMRelationship ("WorkTask", "WorkTask", "0..1", "0..*")
    )
    val quantity: Fielder = parse_attribute (attribute (cls, fields(0)))
    val TypeMaterial: Fielder = parse_attribute (attribute (cls, fields(1)))
    val WorkTask: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: CIMContext): MaterialItem =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[MaterialItem] = MaterialItemSerializer
}

object MaterialItemSerializer extends CIMSerializer[MaterialItem]
{
    def write (kryo: Kryo, output: Output, obj: MaterialItem): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.quantity),
            () => output.writeString (obj.TypeMaterial),
            () => output.writeString (obj.WorkTask)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MaterialItem]): MaterialItem =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = MaterialItem (
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
 * Asset component to be repaired or problem area to be corrected.
 *
 * @param Element Reference to the superclass object.
 * @param breakerRepairItem Breaker component or problem area which is the focus of this maintenance work task (for work tasks related to breakers only).
 * @param transformerRepairItem Transformer component or problem area which is the focus of this maintenance work task (for work tasks related to transformers only).
 * @param RepairWorkTask [[ch.ninecode.model.RepairWorkTask RepairWorkTask]] Repair work task under which breaker item of this type is repaired.
 * @group Work
 * @groupname Work Package Work
 * @groupdesc Work This package contains the core information classes that support work management and network extension planning applications.
 */
final case class RepairItem
(
    Element: BasicElement = null,
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
        "\t<cim:RepairItem rdf:%s=\"%s\">\n%s\t</cim:RepairItem>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object RepairItem
extends
    CIMParseable[RepairItem]
{
    override val fields: Array[String] = Array[String] (
        "breakerRepairItem",
        "transformerRepairItem",
        "RepairWorkTask"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("RepairWorkTask", "RepairWorkTask", "0..*", "0..*")
    )
    val breakerRepairItem: Fielder = parse_attribute (attribute (cls, fields(0)))
    val transformerRepairItem: Fielder = parse_attribute (attribute (cls, fields(1)))
    val RepairWorkTask: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: CIMContext): RepairItem =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[RepairItem] = RepairItemSerializer
}

object RepairItemSerializer extends CIMSerializer[RepairItem]
{
    def write (kryo: Kryo, output: Output, obj: RepairItem): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.breakerRepairItem),
            () => output.writeString (obj.transformerRepairItem),
            () => writeList (obj.RepairWorkTask, output)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[RepairItem]): RepairItem =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = RepairItem (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Work task for asset repair.
 *
 * Costs associated with this are considered corrective maintenance (CM) costs.
 *
 * @param WorkTask [[ch.ninecode.model.WorkTask WorkTask]] Reference to the superclass object.
 * @param emergency Repair work is emergency.
 * @param BreakerRepairItem [[ch.ninecode.model.RepairItem RepairItem]] Type of breaker item to be repaird by this repair work task.
 * @group Work
 * @groupname Work Package Work
 * @groupdesc Work This package contains the core information classes that support work management and network extension planning applications.
 */
final case class RepairWorkTask
(
    WorkTask: WorkTask = null,
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
    override def sup: WorkTask = WorkTask

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
        "\t<cim:RepairWorkTask rdf:%s=\"%s\">\n%s\t</cim:RepairWorkTask>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object RepairWorkTask
extends
    CIMParseable[RepairWorkTask]
{
    override val fields: Array[String] = Array[String] (
        "emergency",
        "BreakerRepairItem"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("BreakerRepairItem", "RepairItem", "0..*", "0..*")
    )
    val emergency: Fielder = parse_element (element (cls, fields(0)))
    val BreakerRepairItem: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): RepairWorkTask =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = RepairWorkTask (
            WorkTask.parse (context),
            toBoolean (mask (emergency (), 0)),
            masks (BreakerRepairItem (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[RepairWorkTask] = RepairWorkTaskSerializer
}

object RepairWorkTaskSerializer extends CIMSerializer[RepairWorkTask]
{
    def write (kryo: Kryo, output: Output, obj: RepairWorkTask): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeBoolean (obj.emergency),
            () => writeList (obj.BreakerRepairItem, output)
        )
        WorkTaskSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[RepairWorkTask]): RepairWorkTask =
    {
        val parent = WorkTaskSerializer.read (kryo, input, classOf[WorkTask])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = RepairWorkTask (
            parent,
            if (isSet (0)) input.readBoolean else false,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Tool asset.
 *
 * @param WorkAsset [[ch.ninecode.model.WorkAsset WorkAsset]] Reference to the superclass object.
 * @param lastCalibrationDate (if applicable) Date the tool was last calibrated.
 * @group Work
 * @groupname Work Package Work
 * @groupdesc Work This package contains the core information classes that support work management and network extension planning applications.
 */
final case class Tool
(
    WorkAsset: WorkAsset = null,
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
    override def sup: WorkAsset = WorkAsset

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
        "\t<cim:Tool rdf:%s=\"%s\">\n%s\t</cim:Tool>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object Tool
extends
    CIMParseable[Tool]
{
    override val fields: Array[String] = Array[String] (
        "lastCalibrationDate"
    )
    val lastCalibrationDate: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: CIMContext): Tool =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Tool (
            WorkAsset.parse (context),
            mask (lastCalibrationDate (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Tool] = ToolSerializer
}

object ToolSerializer extends CIMSerializer[Tool]
{
    def write (kryo: Kryo, output: Output, obj: Tool): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.lastCalibrationDate)
        )
        WorkAssetSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Tool]): Tool =
    {
        val parent = WorkAssetSerializer.read (kryo, input, classOf[WorkAsset])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Tool (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Vehicle asset.
 *
 * @param WorkAsset [[ch.ninecode.model.WorkAsset WorkAsset]] Reference to the superclass object.
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
    WorkAsset: WorkAsset = null,
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
    override def sup: WorkAsset = WorkAsset

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
        "\t<cim:Vehicle rdf:%s=\"%s\">\n%s\t</cim:Vehicle>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object Vehicle
extends
    CIMParseable[Vehicle]
{
    override val fields: Array[String] = Array[String] (
        "odometerReadDateTime",
        "odometerReading",
        "usageKind"
    )
    val odometerReadDateTime: Fielder = parse_element (element (cls, fields(0)))
    val odometerReading: Fielder = parse_element (element (cls, fields(1)))
    val usageKind: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: CIMContext): Vehicle =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[Vehicle] = VehicleSerializer
}

object VehicleSerializer extends CIMSerializer[Vehicle]
{
    def write (kryo: Kryo, output: Output, obj: Vehicle): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.odometerReadDateTime),
            () => output.writeDouble (obj.odometerReading),
            () => output.writeString (obj.usageKind)
        )
        WorkAssetSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Vehicle]): Vehicle =
    {
        val parent = WorkAssetSerializer.read (kryo, input, classOf[WorkAsset])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Vehicle (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Document used to request, initiate, track and record work.
 *
 * @param BaseWork [[ch.ninecode.model.BaseWork BaseWork]] Reference to the superclass object.
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
    BaseWork: BaseWork = null,
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
    override def sup: BaseWork = BaseWork

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
        "\t<cim:Work rdf:%s=\"%s\">\n%s\t</cim:Work>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object Work
extends
    CIMParseable[Work]
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Appointments", "Appointment", "0..*", "0..*"),
        CIMRelationship ("BusinessCase", "BusinessCase", "0..1", "0..*"),
        CIMRelationship ("Customers", "Customer", "0..*", "0..*"),
        CIMRelationship ("Designs", "Design", "0..*", "0..1"),
        CIMRelationship ("ErpProjectAccounting", "ErpProjectAccounting", "0..1", "0..*"),
        CIMRelationship ("Incidents", "Incident", "0..*", "0..*"),
        CIMRelationship ("Project", "Project", "0..1", "0..*"),
        CIMRelationship ("WorkBillingInfo", "WorkBillingInfo", "0..1", "0..*"),
        CIMRelationship ("WorkCostDetails", "WorkCostDetail", "0..*", "0..*"),
        CIMRelationship ("WorkFlowSteps", "WorkFlowStep", "0..*", "0..1"),
        CIMRelationship ("WorkTasks", "WorkTask", "0..*", "1")
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

    def parse (context: CIMContext): Work =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[Work] = WorkSerializer
}

object WorkSerializer extends CIMSerializer[Work]
{
    def write (kryo: Kryo, output: Output, obj: Work): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.requestDateTime),
            () => output.writeString (obj.workOrderNumber),
            () => writeList (obj.Appointments, output),
            () => output.writeString (obj.BusinessCase),
            () => writeList (obj.Customers, output),
            () => writeList (obj.Designs, output),
            () => output.writeString (obj.ErpProjectAccounting),
            () => writeList (obj.Incidents, output),
            () => output.writeString (obj.Project),
            () => output.writeString (obj.WorkBillingInfo),
            () => writeList (obj.WorkCostDetails, output),
            () => writeList (obj.WorkFlowSteps, output),
            () => writeList (obj.WorkTasks, output)
        )
        BaseWorkSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Work]): Work =
    {
        val parent = BaseWorkSerializer.read (kryo, input, classOf[BaseWork])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Work (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) readList (input) else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) readList (input) else null,
            if (isSet (5)) readList (input) else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) readList (input) else null,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) input.readString else null,
            if (isSet (10)) readList (input) else null,
            if (isSet (11)) readList (input) else null,
            if (isSet (12)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Records information about the status of work or work task at a point in time.
 *
 * @param ActivityRecord [[ch.ninecode.model.ActivityRecord ActivityRecord]] Reference to the superclass object.
 * @param percentComplete Estimated percentage of completion of this individual work task or overall work order.
 * @param BaseWork [[ch.ninecode.model.BaseWork BaseWork]] Base work that this activity record tracks.
 * @group Work
 * @groupname Work Package Work
 * @groupdesc Work This package contains the core information classes that support work management and network extension planning applications.
 */
final case class WorkActivityRecord
(
    ActivityRecord: ActivityRecord = null,
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
    override def sup: ActivityRecord = ActivityRecord

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
        "\t<cim:WorkActivityRecord rdf:%s=\"%s\">\n%s\t</cim:WorkActivityRecord>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object WorkActivityRecord
extends
    CIMParseable[WorkActivityRecord]
{
    override val fields: Array[String] = Array[String] (
        "percentComplete",
        "BaseWork"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("BaseWork", "BaseWork", "0..1", "0..*")
    )
    val percentComplete: Fielder = parse_element (element (cls, fields(0)))
    val BaseWork: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): WorkActivityRecord =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WorkActivityRecord (
            ActivityRecord.parse (context),
            toDouble (mask (percentComplete (), 0)),
            mask (BaseWork (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[WorkActivityRecord] = WorkActivityRecordSerializer
}

object WorkActivityRecordSerializer extends CIMSerializer[WorkActivityRecord]
{
    def write (kryo: Kryo, output: Output, obj: WorkActivityRecord): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.percentComplete),
            () => output.writeString (obj.BaseWork)
        )
        ActivityRecordSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[WorkActivityRecord]): WorkActivityRecord =
    {
        val parent = ActivityRecordSerializer.read (kryo, input, classOf[ActivityRecord])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = WorkActivityRecord (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Asset used to perform work.
 *
 * @param Asset [[ch.ninecode.model.Asset Asset]] Reference to the superclass object.
 * @param CUWorkEquipmentAsset [[ch.ninecode.model.CUWorkEquipmentItem CUWorkEquipmentItem]] <em>undocumented</em>
 * @param Crew [[ch.ninecode.model.Crew Crew]] Crew using this work asset.
 * @group Work
 * @groupname Work Package Work
 * @groupdesc Work This package contains the core information classes that support work management and network extension planning applications.
 */
final case class WorkAsset
(
    Asset: Asset = null,
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
    override def sup: Asset = Asset

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
        "\t<cim:WorkAsset rdf:%s=\"%s\">\n%s\t</cim:WorkAsset>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object WorkAsset
extends
    CIMParseable[WorkAsset]
{
    override val fields: Array[String] = Array[String] (
        "CUWorkEquipmentAsset",
        "Crew"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("CUWorkEquipmentAsset", "CUWorkEquipmentItem", "0..1", "0..1"),
        CIMRelationship ("Crew", "Crew", "0..1", "0..*")
    )
    val CUWorkEquipmentAsset: Fielder = parse_attribute (attribute (cls, fields(0)))
    val Crew: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): WorkAsset =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WorkAsset (
            Asset.parse (context),
            mask (CUWorkEquipmentAsset (), 0),
            mask (Crew (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[WorkAsset] = WorkAssetSerializer
}

object WorkAssetSerializer extends CIMSerializer[WorkAsset]
{
    def write (kryo: Kryo, output: Output, obj: WorkAsset): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.CUWorkEquipmentAsset),
            () => output.writeString (obj.Crew)
        )
        AssetSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[WorkAsset]): WorkAsset =
    {
        val parent = AssetSerializer.read (kryo, input, classOf[Asset])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = WorkAsset (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Information about a particular location for various forms of work.
 *
 * @param Location [[ch.ninecode.model.Location Location]] Reference to the superclass object.
 * @param BaseWorks [[ch.ninecode.model.BaseWork BaseWork]] All works/tasks at this location.
 * @param DesignLocations [[ch.ninecode.model.DesignLocation DesignLocation]] <em>undocumented</em>
 * @param OneCallRequest [[ch.ninecode.model.OneCallRequest OneCallRequest]] <em>undocumented</em>
 * @group Work
 * @groupname Work Package Work
 * @groupdesc Work This package contains the core information classes that support work management and network extension planning applications.
 */
final case class WorkLocation
(
    Location: Location = null,
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
    override def sup: Location = Location

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
        "\t<cim:WorkLocation rdf:%s=\"%s\">\n%s\t</cim:WorkLocation>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object WorkLocation
extends
    CIMParseable[WorkLocation]
{
    override val fields: Array[String] = Array[String] (
        "BaseWorks",
        "DesignLocations",
        "OneCallRequest"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("BaseWorks", "BaseWork", "0..*", "0..1"),
        CIMRelationship ("DesignLocations", "DesignLocation", "0..*", "1..*"),
        CIMRelationship ("OneCallRequest", "OneCallRequest", "0..1", "0..*")
    )
    val BaseWorks: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val DesignLocations: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val OneCallRequest: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: CIMContext): WorkLocation =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[WorkLocation] = WorkLocationSerializer
}

object WorkLocationSerializer extends CIMSerializer[WorkLocation]
{
    def write (kryo: Kryo, output: Output, obj: WorkLocation): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.BaseWorks, output),
            () => writeList (obj.DesignLocations, output),
            () => output.writeString (obj.OneCallRequest)
        )
        LocationSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[WorkLocation]): WorkLocation =
    {
        val parent = LocationSerializer.read (kryo, input, classOf[Location])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = WorkLocation (
            parent,
            if (isSet (0)) readList (input) else null,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A task within a set of work.
 *
 * @param BaseWork [[ch.ninecode.model.BaseWork BaseWork]] Reference to the superclass object.
 * @param completedDateTime Date and time work task was completed.
 * @param contractorCost Total contractor costs associated with the work task.
 * @param crewETA Estimated time of arrival, so that customer or police/fire department can be informed when the crew will arrive.
 * @param estimatedCompletionTime Time and Date when the work task will be completed.
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
 * @param TroubleOrder [[ch.ninecode.model.TroubleOrder TroubleOrder]] <em>undocumented</em>
 * @param Work [[ch.ninecode.model.Work Work]] Work this task belongs to.
 * @group Work
 * @groupname Work Package Work
 * @groupdesc Work This package contains the core information classes that support work management and network extension planning applications.
 */
final case class WorkTask
(
    BaseWork: BaseWork = null,
    completedDateTime: String = null,
    contractorCost: Double = 0.0,
    crewETA: String = null,
    estimatedCompletionTime: String = null,
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
    OldAsset: List[String] = null,
    ProcedureDataSet: List[String] = null,
    SwitchingPlan: String = null,
    TroubleOrder: String = null,
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
    override def sup: BaseWork = BaseWork

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
        emitelem (3, estimatedCompletionTime)
        emitelem (4, instruction)
        emitelem (5, laborCost)
        emitelem (6, laborHours)
        emitelem (7, materiallCost)
        emitelem (8, schedOverride)
        emitelem (9, startedDateTime)
        emitattr (10, taskKind)
        emitelem (11, toolCost)
        emitattrs (12, Assets)
        emitattrs (13, Crews)
        emitattrs (14, MaterialItems)
        emitattrs (15, OldAsset)
        emitattrs (16, ProcedureDataSet)
        emitattr (17, SwitchingPlan)
        emitattr (18, TroubleOrder)
        emitattr (19, Work)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WorkTask rdf:%s=\"%s\">\n%s\t</cim:WorkTask>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object WorkTask
extends
    CIMParseable[WorkTask]
{
    override val fields: Array[String] = Array[String] (
        "completedDateTime",
        "contractorCost",
        "crewETA",
        "estimatedCompletionTime",
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
        "TroubleOrder",
        "Work"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Assets", "Asset", "0..*", "0..*"),
        CIMRelationship ("Crews", "Crew", "0..*", "0..*"),
        CIMRelationship ("MaterialItems", "MaterialItem", "0..*", "0..1"),
        CIMRelationship ("OldAsset", "Asset", "0..*", "0..*"),
        CIMRelationship ("ProcedureDataSet", "ProcedureDataSet", "0..*", "0..1"),
        CIMRelationship ("SwitchingPlan", "SwitchingPlan", "0..1", "0..*"),
        CIMRelationship ("TroubleOrder", "TroubleOrder", "0..1", "0..*"),
        CIMRelationship ("Work", "Work", "1", "0..*")
    )
    val completedDateTime: Fielder = parse_element (element (cls, fields(0)))
    val contractorCost: Fielder = parse_element (element (cls, fields(1)))
    val crewETA: Fielder = parse_element (element (cls, fields(2)))
    val estimatedCompletionTime: Fielder = parse_element (element (cls, fields(3)))
    val instruction: Fielder = parse_element (element (cls, fields(4)))
    val laborCost: Fielder = parse_element (element (cls, fields(5)))
    val laborHours: Fielder = parse_element (element (cls, fields(6)))
    val materiallCost: Fielder = parse_element (element (cls, fields(7)))
    val schedOverride: Fielder = parse_element (element (cls, fields(8)))
    val startedDateTime: Fielder = parse_element (element (cls, fields(9)))
    val taskKind: Fielder = parse_attribute (attribute (cls, fields(10)))
    val toolCost: Fielder = parse_element (element (cls, fields(11)))
    val Assets: FielderMultiple = parse_attributes (attribute (cls, fields(12)))
    val Crews: FielderMultiple = parse_attributes (attribute (cls, fields(13)))
    val MaterialItems: FielderMultiple = parse_attributes (attribute (cls, fields(14)))
    val OldAsset: FielderMultiple = parse_attributes (attribute (cls, fields(15)))
    val ProcedureDataSet: FielderMultiple = parse_attributes (attribute (cls, fields(16)))
    val SwitchingPlan: Fielder = parse_attribute (attribute (cls, fields(17)))
    val TroubleOrder: Fielder = parse_attribute (attribute (cls, fields(18)))
    val Work: Fielder = parse_attribute (attribute (cls, fields(19)))

    def parse (context: CIMContext): WorkTask =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WorkTask (
            BaseWork.parse (context),
            mask (completedDateTime (), 0),
            toDouble (mask (contractorCost (), 1)),
            mask (crewETA (), 2),
            mask (estimatedCompletionTime (), 3),
            mask (instruction (), 4),
            toDouble (mask (laborCost (), 5)),
            toDouble (mask (laborHours (), 6)),
            toDouble (mask (materiallCost (), 7)),
            mask (schedOverride (), 8),
            mask (startedDateTime (), 9),
            mask (taskKind (), 10),
            toDouble (mask (toolCost (), 11)),
            masks (Assets (), 12),
            masks (Crews (), 13),
            masks (MaterialItems (), 14),
            masks (OldAsset (), 15),
            masks (ProcedureDataSet (), 16),
            mask (SwitchingPlan (), 17),
            mask (TroubleOrder (), 18),
            mask (Work (), 19)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[WorkTask] = WorkTaskSerializer
}

object WorkTaskSerializer extends CIMSerializer[WorkTask]
{
    def write (kryo: Kryo, output: Output, obj: WorkTask): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.completedDateTime),
            () => output.writeDouble (obj.contractorCost),
            () => output.writeString (obj.crewETA),
            () => output.writeString (obj.estimatedCompletionTime),
            () => output.writeString (obj.instruction),
            () => output.writeDouble (obj.laborCost),
            () => output.writeDouble (obj.laborHours),
            () => output.writeDouble (obj.materiallCost),
            () => output.writeString (obj.schedOverride),
            () => output.writeString (obj.startedDateTime),
            () => output.writeString (obj.taskKind),
            () => output.writeDouble (obj.toolCost),
            () => writeList (obj.Assets, output),
            () => writeList (obj.Crews, output),
            () => writeList (obj.MaterialItems, output),
            () => writeList (obj.OldAsset, output),
            () => writeList (obj.ProcedureDataSet, output),
            () => output.writeString (obj.SwitchingPlan),
            () => output.writeString (obj.TroubleOrder),
            () => output.writeString (obj.Work)
        )
        BaseWorkSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[WorkTask]): WorkTask =
    {
        val parent = BaseWorkSerializer.read (kryo, input, classOf[BaseWork])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = WorkTask (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readDouble else 0.0,
            if (isSet (6)) input.readDouble else 0.0,
            if (isSet (7)) input.readDouble else 0.0,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) input.readString else null,
            if (isSet (10)) input.readString else null,
            if (isSet (11)) input.readDouble else 0.0,
            if (isSet (12)) readList (input) else null,
            if (isSet (13)) readList (input) else null,
            if (isSet (14)) readList (input) else null,
            if (isSet (15)) readList (input) else null,
            if (isSet (16)) readList (input) else null,
            if (isSet (17)) input.readString else null,
            if (isSet (18)) input.readString else null,
            if (isSet (19)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Time schedule specific to work.
 *
 * @param TimeSchedule [[ch.ninecode.model.TimeSchedule TimeSchedule]] Reference to the superclass object.
 * @param kind [[ch.ninecode.model.WorkTimeScheduleKind WorkTimeScheduleKind]] Kind of this work schedule.
 * @param BaseWork [[ch.ninecode.model.BaseWork BaseWork]] Time schedule for this work or work task.
 * @group Work
 * @groupname Work Package Work
 * @groupdesc Work This package contains the core information classes that support work management and network extension planning applications.
 */
final case class WorkTimeSchedule
(
    TimeSchedule: TimeSchedule = null,
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
    override def sup: TimeSchedule = TimeSchedule

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
        "\t<cim:WorkTimeSchedule rdf:%s=\"%s\">\n%s\t</cim:WorkTimeSchedule>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object WorkTimeSchedule
extends
    CIMParseable[WorkTimeSchedule]
{
    override val fields: Array[String] = Array[String] (
        "kind",
        "BaseWork"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("kind", "WorkTimeScheduleKind", "0..1", "0..*"),
        CIMRelationship ("BaseWork", "BaseWork", "0..1", "0..*")
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val BaseWork: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): WorkTimeSchedule =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WorkTimeSchedule (
            TimeSchedule.parse (context),
            mask (kind (), 0),
            mask (BaseWork (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[WorkTimeSchedule] = WorkTimeScheduleSerializer
}

object WorkTimeScheduleSerializer extends CIMSerializer[WorkTimeSchedule]
{
    def write (kryo: Kryo, output: Output, obj: WorkTimeSchedule): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.kind),
            () => output.writeString (obj.BaseWork)
        )
        TimeScheduleSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[WorkTimeSchedule]): WorkTimeSchedule =
    {
        val parent = TimeScheduleSerializer.read (kryo, input, classOf[TimeSchedule])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = WorkTimeSchedule (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Kind of work schedule.
 *
 * @param Element Reference to the superclass object.
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
    Element: BasicElement = null,
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
        "\t<cim:WorkTimeScheduleKind rdf:%s=\"%s\">\n%s\t</cim:WorkTimeScheduleKind>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object WorkTimeScheduleKind
extends
    CIMParseable[WorkTimeScheduleKind]
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

    def parse (context: CIMContext): WorkTimeScheduleKind =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[WorkTimeScheduleKind] = WorkTimeScheduleKindSerializer
}

object WorkTimeScheduleKindSerializer extends CIMSerializer[WorkTimeScheduleKind]
{
    def write (kryo: Kryo, output: Output, obj: WorkTimeScheduleKind): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.actual),
            () => output.writeString (obj.earliest),
            () => output.writeString (obj.estimate),
            () => output.writeString (obj.immediate),
            () => output.writeString (obj.latest),
            () => output.writeString (obj.request)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[WorkTimeScheduleKind]): WorkTimeScheduleKind =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = WorkTimeScheduleKind (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _Work
{
    def register: List[CIMClassInfo] =
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