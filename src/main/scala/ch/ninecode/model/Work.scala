package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * Common representation for work and work tasks.
 *
 * @param sup Reference to the superclass object.
 * @param kind Kind of work.
 * @param priority Priority of work.
 * @param statusKind Kind of work status.
 * @param WorkLocation Location for this work/task.
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
        sup.export_fields +
        (if (null != kind) "\t\t<cim:BaseWork.kind rdf:resource=\"#" + kind + "\"/>\n" else "") +
        (if (null != priority) "\t\t<cim:BaseWork.priority rdf:resource=\"#" + priority + "\"/>\n" else "") +
        (if (null != statusKind) "\t\t<cim:BaseWork.statusKind rdf:resource=\"#" + statusKind + "\"/>\n" else "") +
        (if (null != WorkLocation) "\t\t<cim:BaseWork.WorkLocation rdf:resource=\"#" + WorkLocation + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:BaseWork rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:BaseWork>"
    }
}

object BaseWork
extends
    Parseable[BaseWork]
{
    val kind = parse_attribute (attribute ("""BaseWork.kind"""))
    val priority = parse_attribute (attribute ("""BaseWork.priority"""))
    val statusKind = parse_attribute (attribute ("""BaseWork.statusKind"""))
    val WorkLocation = parse_attribute (attribute ("""BaseWork.WorkLocation"""))
    def parse (context: Context): BaseWork =
    {
        BaseWork(
            Document.parse (context),
            kind (context),
            priority (context),
            statusKind (context),
            WorkLocation (context)
        )
    }
}

/**
 * Location where to perform maintenance work.
 *
 * @param sup Reference to the superclass object.
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
        sup.export_fields +
        (if (null != block) "\t\t<cim:MaintenanceLocation.block>" + block + "</cim:MaintenanceLocation.block>\n" else "") +
        (if (null != lot) "\t\t<cim:MaintenanceLocation.lot>" + lot + "</cim:MaintenanceLocation.lot>\n" else "") +
        (if (null != nearestIntersection) "\t\t<cim:MaintenanceLocation.nearestIntersection>" + nearestIntersection + "</cim:MaintenanceLocation.nearestIntersection>\n" else "") +
        (if (null != subdivision) "\t\t<cim:MaintenanceLocation.subdivision>" + subdivision + "</cim:MaintenanceLocation.subdivision>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MaintenanceLocation rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MaintenanceLocation>"
    }
}

object MaintenanceLocation
extends
    Parseable[MaintenanceLocation]
{
    val block = parse_element (element ("""MaintenanceLocation.block"""))
    val lot = parse_element (element ("""MaintenanceLocation.lot"""))
    val nearestIntersection = parse_element (element ("""MaintenanceLocation.nearestIntersection"""))
    val subdivision = parse_element (element ("""MaintenanceLocation.subdivision"""))
    def parse (context: Context): MaintenanceLocation =
    {
        MaintenanceLocation(
            WorkLocation.parse (context),
            block (context),
            lot (context),
            nearestIntersection (context),
            subdivision (context)
        )
    }
}

/**
 * The physical consumable supply used for work and other purposes.
 *
 * It includes items such as nuts, bolts, brackets, glue, etc.
 *
 * @param sup Reference to the superclass object.
 * @param quantity Quantity of material used.
 * @param TypeMaterial <em>undocumented</em>
 * @param WorkTask <em>undocumented</em>
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
        sup.export_fields +
        (if (null != quantity) "\t\t<cim:MaterialItem.quantity rdf:resource=\"#" + quantity + "\"/>\n" else "") +
        (if (null != TypeMaterial) "\t\t<cim:MaterialItem.TypeMaterial rdf:resource=\"#" + TypeMaterial + "\"/>\n" else "") +
        (if (null != WorkTask) "\t\t<cim:MaterialItem.WorkTask rdf:resource=\"#" + WorkTask + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MaterialItem rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MaterialItem>"
    }
}

object MaterialItem
extends
    Parseable[MaterialItem]
{
    val quantity = parse_attribute (attribute ("""MaterialItem.quantity"""))
    val TypeMaterial = parse_attribute (attribute ("""MaterialItem.TypeMaterial"""))
    val WorkTask = parse_attribute (attribute ("""MaterialItem.WorkTask"""))
    def parse (context: Context): MaterialItem =
    {
        MaterialItem(
            IdentifiedObject.parse (context),
            quantity (context),
            TypeMaterial (context),
            WorkTask (context)
        )
    }
}

/**
 * Tool asset.
 *
 * @param sup Reference to the superclass object.
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
        sup.export_fields +
        (if (null != lastCalibrationDate) "\t\t<cim:Tool.lastCalibrationDate>" + lastCalibrationDate + "</cim:Tool.lastCalibrationDate>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Tool rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Tool>"
    }
}

object Tool
extends
    Parseable[Tool]
{
    val lastCalibrationDate = parse_element (element ("""Tool.lastCalibrationDate"""))
    def parse (context: Context): Tool =
    {
        Tool(
            WorkAsset.parse (context),
            lastCalibrationDate (context)
        )
    }
}

/**
 * Vehicle asset.
 *
 * @param sup Reference to the superclass object.
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
        sup.export_fields +
        (if (null != odometerReadDateTime) "\t\t<cim:Vehicle.odometerReadDateTime>" + odometerReadDateTime + "</cim:Vehicle.odometerReadDateTime>\n" else "") +
        "\t\t<cim:Vehicle.odometerReading>" + odometerReading + "</cim:Vehicle.odometerReading>\n" +
        (if (null != usageKind) "\t\t<cim:Vehicle.usageKind rdf:resource=\"#" + usageKind + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Vehicle rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Vehicle>"
    }
}

object Vehicle
extends
    Parseable[Vehicle]
{
    val odometerReadDateTime = parse_element (element ("""Vehicle.odometerReadDateTime"""))
    val odometerReading = parse_element (element ("""Vehicle.odometerReading"""))
    val usageKind = parse_attribute (attribute ("""Vehicle.usageKind"""))
    def parse (context: Context): Vehicle =
    {
        Vehicle(
            WorkAsset.parse (context),
            odometerReadDateTime (context),
            toDouble (odometerReading (context), context),
            usageKind (context)
        )
    }
}

/**
 * Document used to request, initiate, track and record work.
 *
 * @param sup Reference to the superclass object.
 * @param requestDateTime Date and time work was requested.
 * @param BusinessCase <em>undocumented</em>
 * @param ErpProjectAccounting <em>undocumented</em>
 * @param Project <em>undocumented</em>
 * @param WorkBillingInfo <em>undocumented</em>
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
        sup.export_fields +
        (if (null != requestDateTime) "\t\t<cim:Work.requestDateTime>" + requestDateTime + "</cim:Work.requestDateTime>\n" else "") +
        (if (null != BusinessCase) "\t\t<cim:Work.BusinessCase rdf:resource=\"#" + BusinessCase + "\"/>\n" else "") +
        (if (null != ErpProjectAccounting) "\t\t<cim:Work.ErpProjectAccounting rdf:resource=\"#" + ErpProjectAccounting + "\"/>\n" else "") +
        (if (null != Project) "\t\t<cim:Work.Project rdf:resource=\"#" + Project + "\"/>\n" else "") +
        (if (null != WorkBillingInfo) "\t\t<cim:Work.WorkBillingInfo rdf:resource=\"#" + WorkBillingInfo + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Work rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Work>"
    }
}

object Work
extends
    Parseable[Work]
{
    val requestDateTime = parse_element (element ("""Work.requestDateTime"""))
    val BusinessCase = parse_attribute (attribute ("""Work.BusinessCase"""))
    val ErpProjectAccounting = parse_attribute (attribute ("""Work.ErpProjectAccounting"""))
    val Project = parse_attribute (attribute ("""Work.Project"""))
    val WorkBillingInfo = parse_attribute (attribute ("""Work.WorkBillingInfo"""))
    def parse (context: Context): Work =
    {
        Work(
            BaseWork.parse (context),
            requestDateTime (context),
            BusinessCase (context),
            ErpProjectAccounting (context),
            Project (context),
            WorkBillingInfo (context)
        )
    }
}

/**
 * Asset used to perform work.
 *
 * @param sup Reference to the superclass object.
 * @param Crew Crew using this work asset.
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
        sup.export_fields +
        (if (null != Crew) "\t\t<cim:WorkAsset.Crew rdf:resource=\"#" + Crew + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WorkAsset rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WorkAsset>"
    }
}

object WorkAsset
extends
    Parseable[WorkAsset]
{
    val Crew = parse_attribute (attribute ("""WorkAsset.Crew"""))
    def parse (context: Context): WorkAsset =
    {
        WorkAsset(
            Asset.parse (context),
            Crew (context)
        )
    }
}

/**
 * Information about a particular location for various forms of work.
 *
 * @param sup Reference to the superclass object.
 * @param OneCallRequest <em>undocumented</em>
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
        sup.export_fields +
        (if (null != OneCallRequest) "\t\t<cim:WorkLocation.OneCallRequest rdf:resource=\"#" + OneCallRequest + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WorkLocation rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WorkLocation>"
    }
}

object WorkLocation
extends
    Parseable[WorkLocation]
{
    val OneCallRequest = parse_attribute (attribute ("""WorkLocation.OneCallRequest"""))
    def parse (context: Context): WorkLocation =
    {
        WorkLocation(
            Location.parse (context),
            OneCallRequest (context)
        )
    }
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
        sup.export_fields +
        (if (null != crewETA) "\t\t<cim:WorkTask.crewETA>" + crewETA + "</cim:WorkTask.crewETA>\n" else "") +
        (if (null != instruction) "\t\t<cim:WorkTask.instruction>" + instruction + "</cim:WorkTask.instruction>\n" else "") +
        (if (null != schedOverride) "\t\t<cim:WorkTask.schedOverride>" + schedOverride + "</cim:WorkTask.schedOverride>\n" else "") +
        (if (null != taskKind) "\t\t<cim:WorkTask.taskKind rdf:resource=\"#" + taskKind + "\"/>\n" else "") +
        (if (null != Assets) Assets.map (x => "\t\t<cim:WorkTask.Assets rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != Crews) Crews.map (x => "\t\t<cim:WorkTask.Crews rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != OldAsset) "\t\t<cim:WorkTask.OldAsset rdf:resource=\"#" + OldAsset + "\"/>\n" else "") +
        (if (null != SwitchingPlan) "\t\t<cim:WorkTask.SwitchingPlan rdf:resource=\"#" + SwitchingPlan + "\"/>\n" else "") +
        (if (null != Work) "\t\t<cim:WorkTask.Work rdf:resource=\"#" + Work + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WorkTask rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WorkTask>"
    }
}

object WorkTask
extends
    Parseable[WorkTask]
{
    val crewETA = parse_element (element ("""WorkTask.crewETA"""))
    val instruction = parse_element (element ("""WorkTask.instruction"""))
    val schedOverride = parse_element (element ("""WorkTask.schedOverride"""))
    val taskKind = parse_attribute (attribute ("""WorkTask.taskKind"""))
    val Assets = parse_attributes (attribute ("""WorkTask.Assets"""))
    val Crews = parse_attributes (attribute ("""WorkTask.Crews"""))
    val OldAsset = parse_attribute (attribute ("""WorkTask.OldAsset"""))
    val SwitchingPlan = parse_attribute (attribute ("""WorkTask.SwitchingPlan"""))
    val Work = parse_attribute (attribute ("""WorkTask.Work"""))
    def parse (context: Context): WorkTask =
    {
        WorkTask(
            BaseWork.parse (context),
            crewETA (context),
            instruction (context),
            schedOverride (context),
            taskKind (context),
            Assets (context),
            Crews (context),
            OldAsset (context),
            SwitchingPlan (context),
            Work (context)
        )
    }
}

/**
 * Time schedule specific to work.
 *
 * @param sup Reference to the superclass object.
 * @param kind Kind of this work schedule.
 * @param BaseWork Time schedule for this work or work task.
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
        sup.export_fields +
        (if (null != kind) "\t\t<cim:WorkTimeSchedule.kind rdf:resource=\"#" + kind + "\"/>\n" else "") +
        (if (null != BaseWork) "\t\t<cim:WorkTimeSchedule.BaseWork rdf:resource=\"#" + BaseWork + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WorkTimeSchedule rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WorkTimeSchedule>"
    }
}

object WorkTimeSchedule
extends
    Parseable[WorkTimeSchedule]
{
    val kind = parse_attribute (attribute ("""WorkTimeSchedule.kind"""))
    val BaseWork = parse_attribute (attribute ("""WorkTimeSchedule.BaseWork"""))
    def parse (context: Context): WorkTimeSchedule =
    {
        WorkTimeSchedule(
            TimeSchedule.parse (context),
            kind (context),
            BaseWork (context)
        )
    }
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