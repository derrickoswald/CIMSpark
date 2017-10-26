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
 * @param WorkLocation [[ch.ninecode.model.WorkLocation WorkLocation]] Location for this work/task.
 * @group Work
 * @groupname Work Package Work
 * @groupdesc Work This package contains the core information classes that support work management and network extension planning applications.
 */
case class BaseWork
(
    override val sup: Document,
    kind: String,
    priority: String,
    statusKind: String,
    WorkLocation: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[BaseWork] }
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
        implicit val clz: String = BaseWork.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (BaseWork.fields (position), value)
        emitattr (0, kind)
        emitattr (1, priority)
        emitattr (2, statusKind)
        emitattr (3, WorkLocation)
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
    val fields: Array[String] = Array[String] (
        "kind",
        "priority",
        "statusKind",
        "WorkLocation"
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val priority: Fielder = parse_attribute (attribute (cls, fields(1)))
    val statusKind: Fielder = parse_attribute (attribute (cls, fields(2)))
    val WorkLocation: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): BaseWork =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = BaseWork (
            Document.parse (context),
            mask (kind (), 0),
            mask (priority (), 1),
            mask (statusKind (), 2),
            mask (WorkLocation (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("WorkLocation", "WorkLocation", false)
    )
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
case class MaintenanceLocation
(
    override val sup: WorkLocation,
    block: String,
    lot: String,
    nearestIntersection: String,
    subdivision: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def WorkLocation: WorkLocation = sup.asInstanceOf[WorkLocation]
    override def copy (): Row = { clone ().asInstanceOf[MaintenanceLocation] }
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
    val fields: Array[String] = Array[String] (
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
        implicit var bitfields: Array[Int] = Array(0)
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
    val relations: List[Relationship] = List (

    )
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
case class MaterialItem
(
    override val sup: IdentifiedObject,
    quantity: String,
    TypeMaterial: String,
    WorkTask: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[MaterialItem] }
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
    val fields: Array[String] = Array[String] (
        "quantity",
        "TypeMaterial",
        "WorkTask"
    )
    val quantity: Fielder = parse_attribute (attribute (cls, fields(0)))
    val TypeMaterial: Fielder = parse_attribute (attribute (cls, fields(1)))
    val WorkTask: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): MaterialItem =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MaterialItem (
            IdentifiedObject.parse (context),
            mask (quantity (), 0),
            mask (TypeMaterial (), 1),
            mask (WorkTask (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("TypeMaterial", "TypeMaterial", false),
        Relationship ("WorkTask", "WorkTask", false)
    )
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
case class Tool
(
    override val sup: WorkAsset,
    lastCalibrationDate: String
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
    def WorkAsset: WorkAsset = sup.asInstanceOf[WorkAsset]
    override def copy (): Row = { clone ().asInstanceOf[Tool] }
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
    val fields: Array[String] = Array[String] (
        "lastCalibrationDate"
    )
    val lastCalibrationDate: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): Tool =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Tool (
            WorkAsset.parse (context),
            mask (lastCalibrationDate (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
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
case class Vehicle
(
    override val sup: WorkAsset,
    odometerReadDateTime: String,
    odometerReading: Double,
    usageKind: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def WorkAsset: WorkAsset = sup.asInstanceOf[WorkAsset]
    override def copy (): Row = { clone ().asInstanceOf[Vehicle] }
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
    val fields: Array[String] = Array[String] (
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
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Vehicle (
            WorkAsset.parse (context),
            mask (odometerReadDateTime (), 0),
            toDouble (mask (odometerReading (), 1)),
            mask (usageKind (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Document used to request, initiate, track and record work.
 *
 * @param sup [[ch.ninecode.model.BaseWork BaseWork]] Reference to the superclass object.
 * @param requestDateTime Date and time work was requested.
 * @param BusinessCase [[ch.ninecode.model.BusinessCase BusinessCase]] <em>undocumented</em>
 * @param ErpProjectAccounting [[ch.ninecode.model.ErpProjectAccounting ErpProjectAccounting]] <em>undocumented</em>
 * @param Project [[ch.ninecode.model.Project Project]] <em>undocumented</em>
 * @param WorkBillingInfo [[ch.ninecode.model.WorkBillingInfo WorkBillingInfo]] <em>undocumented</em>
 * @group Work
 * @groupname Work Package Work
 * @groupdesc Work This package contains the core information classes that support work management and network extension planning applications.
 */
case class Work
(
    override val sup: BaseWork,
    requestDateTime: String,
    BusinessCase: String,
    ErpProjectAccounting: String,
    Project: String,
    WorkBillingInfo: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def BaseWork: BaseWork = sup.asInstanceOf[BaseWork]
    override def copy (): Row = { clone ().asInstanceOf[Work] }
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
        implicit val clz: String = Work.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Work.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Work.fields (position), value)
        emitelem (0, requestDateTime)
        emitattr (1, BusinessCase)
        emitattr (2, ErpProjectAccounting)
        emitattr (3, Project)
        emitattr (4, WorkBillingInfo)
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
    val fields: Array[String] = Array[String] (
        "requestDateTime",
        "BusinessCase",
        "ErpProjectAccounting",
        "Project",
        "WorkBillingInfo"
    )
    val requestDateTime: Fielder = parse_element (element (cls, fields(0)))
    val BusinessCase: Fielder = parse_attribute (attribute (cls, fields(1)))
    val ErpProjectAccounting: Fielder = parse_attribute (attribute (cls, fields(2)))
    val Project: Fielder = parse_attribute (attribute (cls, fields(3)))
    val WorkBillingInfo: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): Work =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Work (
            BaseWork.parse (context),
            mask (requestDateTime (), 0),
            mask (BusinessCase (), 1),
            mask (ErpProjectAccounting (), 2),
            mask (Project (), 3),
            mask (WorkBillingInfo (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("BusinessCase", "BusinessCase", false),
        Relationship ("ErpProjectAccounting", "ErpProjectAccounting", false),
        Relationship ("Project", "Project", false),
        Relationship ("WorkBillingInfo", "WorkBillingInfo", false)
    )
}

/**
 * Asset used to perform work.
 *
 * @param sup [[ch.ninecode.model.Asset Asset]] Reference to the superclass object.
 * @param Crew [[ch.ninecode.model.Crew Crew]] Crew using this work asset.
 * @group Work
 * @groupname Work Package Work
 * @groupdesc Work This package contains the core information classes that support work management and network extension planning applications.
 */
case class WorkAsset
(
    override val sup: Asset,
    Crew: String
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
    def Asset: Asset = sup.asInstanceOf[Asset]
    override def copy (): Row = { clone ().asInstanceOf[WorkAsset] }
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
        implicit val clz: String = WorkAsset.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WorkAsset.fields (position), value)
        emitattr (0, Crew)
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
    val fields: Array[String] = Array[String] (
        "Crew"
    )
    val Crew: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): WorkAsset =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = WorkAsset (
            Asset.parse (context),
            mask (Crew (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Crew", "Crew", false)
    )
}

/**
 * Information about a particular location for various forms of work.
 *
 * @param sup [[ch.ninecode.model.Location Location]] Reference to the superclass object.
 * @param OneCallRequest [[ch.ninecode.model.OneCallRequest OneCallRequest]] <em>undocumented</em>
 * @group Work
 * @groupname Work Package Work
 * @groupdesc Work This package contains the core information classes that support work management and network extension planning applications.
 */
case class WorkLocation
(
    override val sup: Location,
    OneCallRequest: String
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
    def Location: Location = sup.asInstanceOf[Location]
    override def copy (): Row = { clone ().asInstanceOf[WorkLocation] }
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
        implicit val clz: String = WorkLocation.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WorkLocation.fields (position), value)
        emitattr (0, OneCallRequest)
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
    val fields: Array[String] = Array[String] (
        "OneCallRequest"
    )
    val OneCallRequest: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): WorkLocation =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = WorkLocation (
            Location.parse (context),
            mask (OneCallRequest (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("OneCallRequest", "OneCallRequest", false)
    )
}

/**

 * @group Work
 * @groupname Work Package Work
 * @groupdesc Work This package contains the core information classes that support work management and network extension planning applications.
 */
case class WorkTask
(
    override val sup: BaseWork,
    crewETA: String,
    instruction: String,
    schedOverride: String,
    taskKind: String,
    Assets: List[String],
    Crews: List[String],
    OldAsset: String,
    SwitchingPlan: String,
    Work: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, List(), List(), null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def BaseWork: BaseWork = sup.asInstanceOf[BaseWork]
    override def copy (): Row = { clone ().asInstanceOf[WorkTask] }
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
        implicit val clz: String = WorkTask.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (WorkTask.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WorkTask.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (WorkTask.fields (position), x))
        emitelem (0, crewETA)
        emitelem (1, instruction)
        emitelem (2, schedOverride)
        emitattr (3, taskKind)
        emitattrs (4, Assets)
        emitattrs (5, Crews)
        emitattr (6, OldAsset)
        emitattr (7, SwitchingPlan)
        emitattr (8, Work)
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
    val fields: Array[String] = Array[String] (
        "crewETA",
        "instruction",
        "schedOverride",
        "taskKind",
        "Assets",
        "Crews",
        "OldAsset",
        "SwitchingPlan",
        "Work"
    )
    val crewETA: Fielder = parse_element (element (cls, fields(0)))
    val instruction: Fielder = parse_element (element (cls, fields(1)))
    val schedOverride: Fielder = parse_element (element (cls, fields(2)))
    val taskKind: Fielder = parse_attribute (attribute (cls, fields(3)))
    val Assets: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val Crews: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val OldAsset: Fielder = parse_attribute (attribute (cls, fields(6)))
    val SwitchingPlan: Fielder = parse_attribute (attribute (cls, fields(7)))
    val Work: Fielder = parse_attribute (attribute (cls, fields(8)))

    def parse (context: Context): WorkTask =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = WorkTask (
            BaseWork.parse (context),
            mask (crewETA (), 0),
            mask (instruction (), 1),
            mask (schedOverride (), 2),
            mask (taskKind (), 3),
            masks (Assets (), 4),
            masks (Crews (), 5),
            mask (OldAsset (), 6),
            mask (SwitchingPlan (), 7),
            mask (Work (), 8)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Assets", "Asset", true),
        Relationship ("Crews", "Crew", true),
        Relationship ("OldAsset", "Asset", false),
        Relationship ("SwitchingPlan", "SwitchingPlan", false),
        Relationship ("Work", "Work", false)
    )
}

/**
 * Time schedule specific to work.
 *
 * @param sup [[ch.ninecode.model.TimeSchedule TimeSchedule]] Reference to the superclass object.
 * @param kind Kind of this work schedule.
 * @param BaseWork [[ch.ninecode.model.BaseWork BaseWork]] Time schedule for this work or work task.
 * @group Work
 * @groupname Work Package Work
 * @groupdesc Work This package contains the core information classes that support work management and network extension planning applications.
 */
case class WorkTimeSchedule
(
    override val sup: TimeSchedule,
    kind: String,
    BaseWork: String
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
    def TimeSchedule: TimeSchedule = sup.asInstanceOf[TimeSchedule]
    override def copy (): Row = { clone ().asInstanceOf[WorkTimeSchedule] }
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
    val fields: Array[String] = Array[String] (
        "kind",
        "BaseWork"
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val BaseWork: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): WorkTimeSchedule =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = WorkTimeSchedule (
            TimeSchedule.parse (context),
            mask (kind (), 0),
            mask (BaseWork (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("BaseWork", "BaseWork", false)
    )
}

private[ninecode] object _Work
{
    def register: List[ClassInfo] =
    {
        List (
            BaseWork.register,
            MaintenanceLocation.register,
            MaterialItem.register,
            Tool.register,
            Vehicle.register,
            Work.register,
            WorkAsset.register,
            WorkLocation.register,
            WorkTask.register,
            WorkTimeSchedule.register
        )
    }
}