package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * This package contains the core information classes that support work management and network extension planning applications.
 */

/**
 * Common representation for work and work tasks.
 */
case class BaseWork
(

    override val sup: Document,

    /**
     * Kind of work.
     */
    val kind: String,

    /**
     * Priority of work.
     */
    val priority: String,

    /**
     * Kind of work status.
     */
    val statusKind: String,

    /**
     * Location for this work/task.
     */
    val WorkLocation: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { return (clone ().asInstanceOf[BaseWork]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BaseWork
extends
    Parseable[BaseWork]
{
    val sup = Document.parse _
    val kind = parse_attribute (attribute ("""BaseWork.kind"""))_
    val priority = parse_attribute (attribute ("""BaseWork.priority"""))_
    val statusKind = parse_attribute (attribute ("""BaseWork.statusKind"""))_
    val WorkLocation = parse_attribute (attribute ("""BaseWork.WorkLocation"""))_
    def parse (context: Context): BaseWork =
    {
        BaseWork(
            sup (context),
            kind (context),
            priority (context),
            statusKind (context),
            WorkLocation (context)
        )
    }
}

/**
 * Location where to perform maintenance work.
 */
case class MaintenanceLocation
(

    override val sup: WorkLocation,

    /**
     * (if applicable) Name, identifier, or description of the block in which work is to occur.
     */
    val block: String,

    /**
     * (if applicable) Name, identifier, or description of the lot in which work is to occur.
     */
    val lot: String,

    /**
     * The names of streets at the nearest intersection to work area.
     */
    val nearestIntersection: String,

    /**
     * (if applicable) Name, identifier, or description of the subdivision in which work is to occur.
     */
    val subdivision: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def WorkLocation: WorkLocation = sup.asInstanceOf[WorkLocation]
    override def copy (): Row = { return (clone ().asInstanceOf[MaintenanceLocation]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MaintenanceLocation
extends
    Parseable[MaintenanceLocation]
{
    val sup = WorkLocation.parse _
    val block = parse_element (element ("""MaintenanceLocation.block"""))_
    val lot = parse_element (element ("""MaintenanceLocation.lot"""))_
    val nearestIntersection = parse_element (element ("""MaintenanceLocation.nearestIntersection"""))_
    val subdivision = parse_element (element ("""MaintenanceLocation.subdivision"""))_
    def parse (context: Context): MaintenanceLocation =
    {
        MaintenanceLocation(
            sup (context),
            block (context),
            lot (context),
            nearestIntersection (context),
            subdivision (context)
        )
    }
}

/**
 * The physical consumable supply used for work and other purposes.
 * It includes items such as nuts, bolts, brackets, glue, etc.
 */
case class MaterialItem
(

    override val sup: IdentifiedObject,

    /**
     * Quantity of material used.
     */
    val quantity: String,

    val TypeMaterial: String,

    val WorkTask: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[MaterialItem]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MaterialItem
extends
    Parseable[MaterialItem]
{
    val sup = IdentifiedObject.parse _
    val quantity = parse_attribute (attribute ("""MaterialItem.quantity"""))_
    val TypeMaterial = parse_attribute (attribute ("""MaterialItem.TypeMaterial"""))_
    val WorkTask = parse_attribute (attribute ("""MaterialItem.WorkTask"""))_
    def parse (context: Context): MaterialItem =
    {
        MaterialItem(
            sup (context),
            quantity (context),
            TypeMaterial (context),
            WorkTask (context)
        )
    }
}

/**
 * Tool asset.
 */
case class Tool
(

    override val sup: WorkAsset,

    /**
     * (if applicable) Date the tool was last calibrated.
     */
    val lastCalibrationDate: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def WorkAsset: WorkAsset = sup.asInstanceOf[WorkAsset]
    override def copy (): Row = { return (clone ().asInstanceOf[Tool]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Tool
extends
    Parseable[Tool]
{
    val sup = WorkAsset.parse _
    val lastCalibrationDate = parse_element (element ("""Tool.lastCalibrationDate"""))_
    def parse (context: Context): Tool =
    {
        Tool(
            sup (context),
            lastCalibrationDate (context)
        )
    }
}

/**
 * Vehicle asset.
 */
case class Vehicle
(

    override val sup: WorkAsset,

    /**
     * Date and time the last odometer reading was recorded.
     */
    val odometerReadDateTime: String,

    /**
     * Odometer reading of this vehicle as of the 'odometerReadingDateTime'.
     * Refer to associated ActivityRecords for earlier readings.
     */
    val odometerReading: Double,

    /**
     * Kind of usage of the vehicle.
     */
    val usageKind: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, null) }
    def WorkAsset: WorkAsset = sup.asInstanceOf[WorkAsset]
    override def copy (): Row = { return (clone ().asInstanceOf[Vehicle]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Vehicle
extends
    Parseable[Vehicle]
{
    val sup = WorkAsset.parse _
    val odometerReadDateTime = parse_element (element ("""Vehicle.odometerReadDateTime"""))_
    val odometerReading = parse_element (element ("""Vehicle.odometerReading"""))_
    val usageKind = parse_attribute (attribute ("""Vehicle.usageKind"""))_
    def parse (context: Context): Vehicle =
    {
        Vehicle(
            sup (context),
            odometerReadDateTime (context),
            toDouble (odometerReading (context), context),
            usageKind (context)
        )
    }
}

/**
 * Usage of a vehicle.
 */
case class VehicleUsageKind
(

    override val sup: BasicElement,

    val contractor: String,

    val crew: String,

    val other: String,

    val user: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[VehicleUsageKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object VehicleUsageKind
extends
    Parseable[VehicleUsageKind]
{
    val sup = BasicElement.parse _
    val contractor = parse_attribute (attribute ("""VehicleUsageKind.contractor"""))_
    val crew = parse_attribute (attribute ("""VehicleUsageKind.crew"""))_
    val other = parse_attribute (attribute ("""VehicleUsageKind.other"""))_
    val user = parse_attribute (attribute ("""VehicleUsageKind.user"""))_
    def parse (context: Context): VehicleUsageKind =
    {
        VehicleUsageKind(
            sup (context),
            contractor (context),
            crew (context),
            other (context),
            user (context)
        )
    }
}

/**
 * Document used to request, initiate, track and record work.
 */
case class Work
(

    override val sup: BaseWork,

    /**
     * Date and time work was requested.
     */
    val requestDateTime: String,

    val BusinessCase: String,

    val ErpProjectAccounting: String,

    val Project: String,

    val WorkBillingInfo: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def BaseWork: BaseWork = sup.asInstanceOf[BaseWork]
    override def copy (): Row = { return (clone ().asInstanceOf[Work]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Work
extends
    Parseable[Work]
{
    val sup = BaseWork.parse _
    val requestDateTime = parse_element (element ("""Work.requestDateTime"""))_
    val BusinessCase = parse_attribute (attribute ("""Work.BusinessCase"""))_
    val ErpProjectAccounting = parse_attribute (attribute ("""Work.ErpProjectAccounting"""))_
    val Project = parse_attribute (attribute ("""Work.Project"""))_
    val WorkBillingInfo = parse_attribute (attribute ("""Work.WorkBillingInfo"""))_
    def parse (context: Context): Work =
    {
        Work(
            sup (context),
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
 */
case class WorkAsset
(

    override val sup: Asset,

    /**
     * Crew using this work asset.
     */
    val Crew: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Asset: Asset = sup.asInstanceOf[Asset]
    override def copy (): Row = { return (clone ().asInstanceOf[WorkAsset]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WorkAsset
extends
    Parseable[WorkAsset]
{
    val sup = Asset.parse _
    val Crew = parse_attribute (attribute ("""WorkAsset.Crew"""))_
    def parse (context: Context): WorkAsset =
    {
        WorkAsset(
            sup (context),
            Crew (context)
        )
    }
}

/**
 * Kind of work.
 */
case class WorkKind
(

    override val sup: BasicElement,

    /**
     * Connect work.
     */
    val connect: String,

    /**
     * Construction work.
     */
    val construction: String,

    /**
     * Disconnect work.
     */
    val disconnect: String,

    /**
     * Inspection work.
     */
    val inspection: String,

    /**
     * Maintenance work.
     */
    val maintenance: String,

    /**
     * Other kind of work.
     */
    val other: String,

    /**
     * (use 'connect' instead) Reconnect work.
     */
    val reconnect: String,

    /**
     * Repair work.
     */
    val repair: String,

    /**
     * Service work.
     */
    val service: String,

    /**
     * Test work.
     */
    val test: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[WorkKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WorkKind
extends
    Parseable[WorkKind]
{
    val sup = BasicElement.parse _
    val connect = parse_attribute (attribute ("""WorkKind.connect"""))_
    val construction = parse_attribute (attribute ("""WorkKind.construction"""))_
    val disconnect = parse_attribute (attribute ("""WorkKind.disconnect"""))_
    val inspection = parse_attribute (attribute ("""WorkKind.inspection"""))_
    val maintenance = parse_attribute (attribute ("""WorkKind.maintenance"""))_
    val other = parse_attribute (attribute ("""WorkKind.other"""))_
    val reconnect = parse_attribute (attribute ("""WorkKind.reconnect"""))_
    val repair = parse_attribute (attribute ("""WorkKind.repair"""))_
    val service = parse_attribute (attribute ("""WorkKind.service"""))_
    val test = parse_attribute (attribute ("""WorkKind.test"""))_
    def parse (context: Context): WorkKind =
    {
        WorkKind(
            sup (context),
            connect (context),
            construction (context),
            disconnect (context),
            inspection (context),
            maintenance (context),
            other (context),
            reconnect (context),
            repair (context),
            service (context),
            test (context)
        )
    }
}

/**
 * Information about a particular location for various forms of work.
 */
case class WorkLocation
(

    override val sup: Location,

    val OneCallRequest: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Location: Location = sup.asInstanceOf[Location]
    override def copy (): Row = { return (clone ().asInstanceOf[WorkLocation]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WorkLocation
extends
    Parseable[WorkLocation]
{
    val sup = Location.parse _
    val OneCallRequest = parse_attribute (attribute ("""WorkLocation.OneCallRequest"""))_
    def parse (context: Context): WorkLocation =
    {
        WorkLocation(
            sup (context),
            OneCallRequest (context)
        )
    }
}

/**
 * Kind of status, specific to work.
 */
case class WorkStatusKind
(

    override val sup: BasicElement,

    /**
     * Work has been approved.
     */
    val approved: String,

    /**
     * Work has been canceled.
     */
    val cancelled: String,

    /**
     * Work has been closed (typically by a person responsible for work management) and is ready for billing.
     */
    val closed: String,

    /**
     * Work has been completed, i.e., crew can leave the work location and is available for another work.
     */
    val completed: String,

    /**
     * Crew has been dispatched.
     */
    val dispatched: String,

    /**
     * Crew is 'en route'.
     */
    val enroute: String,

    /**
     * Work is in progress.
     */
    val inProgress: String,

    /**
     * Crew is on the site.
     */
    val onSite: String,

    /**
     * Work has been scheduled.
     */
    val scheduled: String,

    /**
     * Work approval is pending.
     */
    val waitingOnApproval: String,

    /**
     * Work has been waiting on material.
     */
    val waitingOnMaterial: String,

    /**
     * Work needs to be scheduled.
     */
    val waitingToBeScheduled: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[WorkStatusKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WorkStatusKind
extends
    Parseable[WorkStatusKind]
{
    val sup = BasicElement.parse _
    val approved = parse_attribute (attribute ("""WorkStatusKind.approved"""))_
    val cancelled = parse_attribute (attribute ("""WorkStatusKind.cancelled"""))_
    val closed = parse_attribute (attribute ("""WorkStatusKind.closed"""))_
    val completed = parse_attribute (attribute ("""WorkStatusKind.completed"""))_
    val dispatched = parse_attribute (attribute ("""WorkStatusKind.dispatched"""))_
    val enroute = parse_attribute (attribute ("""WorkStatusKind.enroute"""))_
    val inProgress = parse_attribute (attribute ("""WorkStatusKind.inProgress"""))_
    val onSite = parse_attribute (attribute ("""WorkStatusKind.onSite"""))_
    val scheduled = parse_attribute (attribute ("""WorkStatusKind.scheduled"""))_
    val waitingOnApproval = parse_attribute (attribute ("""WorkStatusKind.waitingOnApproval"""))_
    val waitingOnMaterial = parse_attribute (attribute ("""WorkStatusKind.waitingOnMaterial"""))_
    val waitingToBeScheduled = parse_attribute (attribute ("""WorkStatusKind.waitingToBeScheduled"""))_
    def parse (context: Context): WorkStatusKind =
    {
        WorkStatusKind(
            sup (context),
            approved (context),
            cancelled (context),
            closed (context),
            completed (context),
            dispatched (context),
            enroute (context),
            inProgress (context),
            onSite (context),
            scheduled (context),
            waitingOnApproval (context),
            waitingOnMaterial (context),
            waitingToBeScheduled (context)
        )
    }
}

case class WorkTask
(

    override val sup: BaseWork,

    /**
     * Estimated time of arrival, so that customer or police/fire department can be informed when the crew will arrive.
     */
    val crewETA: String,

    /**
     * Instructions for performing this task.
     */
    val instruction: String,

    /**
     * If specified, override schedule and perform this task in accordance with instructions specified here.
     */
    val schedOverride: String,

    /**
     * Kind of work.
     */
    val taskKind: String,

    /**
     * All assets on which this non-replacement work task is performed.
     */
    val Assets: List[String],

    /**
     * All crews participating in this work task.
     */
    val Crews: List[String],

    /**
     * Old asset replaced by this work task.
     */
    val OldAsset: String,

    /**
     * Switching plan executed by this work task.
     */
    val SwitchingPlan: String,

    /**
     * Work this task belongs to.
     */
    val Work: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, List(), List(), null, null, null) }
    def BaseWork: BaseWork = sup.asInstanceOf[BaseWork]
    override def copy (): Row = { return (clone ().asInstanceOf[WorkTask]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WorkTask
extends
    Parseable[WorkTask]
{
    val sup = BaseWork.parse _
    val crewETA = parse_element (element ("""WorkTask.crewETA"""))_
    val instruction = parse_element (element ("""WorkTask.instruction"""))_
    val schedOverride = parse_element (element ("""WorkTask.schedOverride"""))_
    val taskKind = parse_attribute (attribute ("""WorkTask.taskKind"""))_
    val Assets = parse_attributes (attribute ("""WorkTask.Assets"""))_
    val Crews = parse_attributes (attribute ("""WorkTask.Crews"""))_
    val OldAsset = parse_attribute (attribute ("""WorkTask.OldAsset"""))_
    val SwitchingPlan = parse_attribute (attribute ("""WorkTask.SwitchingPlan"""))_
    val Work = parse_attribute (attribute ("""WorkTask.Work"""))_
    def parse (context: Context): WorkTask =
    {
        WorkTask(
            sup (context),
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

case class WorkTaskKind
(

    override val sup: BasicElement,

    /**
     * Work task deals with exchange of assets.
     */
    val exchange: String,

    /**
     * Work task deals with installation of assets.
     */
    val install: String,

    /**
     * Work task deals with investigation about assets.
     */
    val investigate: String,

    /**
     * Work task deals with removal of assets.
     */
    val remove: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[WorkTaskKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WorkTaskKind
extends
    Parseable[WorkTaskKind]
{
    val sup = BasicElement.parse _
    val exchange = parse_attribute (attribute ("""WorkTaskKind.exchange"""))_
    val install = parse_attribute (attribute ("""WorkTaskKind.install"""))_
    val investigate = parse_attribute (attribute ("""WorkTaskKind.investigate"""))_
    val remove = parse_attribute (attribute ("""WorkTaskKind.remove"""))_
    def parse (context: Context): WorkTaskKind =
    {
        WorkTaskKind(
            sup (context),
            exchange (context),
            install (context),
            investigate (context),
            remove (context)
        )
    }
}

/**
 * Time schedule specific to work.
 */
case class WorkTimeSchedule
(

    override val sup: TimeSchedule,

    /**
     * Kind of this work schedule.
     */
    val kind: String,

    /**
     * Time schedule for this work or work task.
     */
    val BaseWork: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def TimeSchedule: TimeSchedule = sup.asInstanceOf[TimeSchedule]
    override def copy (): Row = { return (clone ().asInstanceOf[WorkTimeSchedule]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WorkTimeSchedule
extends
    Parseable[WorkTimeSchedule]
{
    val sup = TimeSchedule.parse _
    val kind = parse_attribute (attribute ("""WorkTimeSchedule.kind"""))_
    val BaseWork = parse_attribute (attribute ("""WorkTimeSchedule.BaseWork"""))_
    def parse (context: Context): WorkTimeSchedule =
    {
        WorkTimeSchedule(
            sup (context),
            kind (context),
            BaseWork (context)
        )
    }
}

/**
 * Kind of work schedule.
 */
case class WorkTimeScheduleKind
(

    override val sup: BasicElement,

    val actual: String,

    val earliest: String,

    val estimate: String,

    val latest: String,

    val request: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[WorkTimeScheduleKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WorkTimeScheduleKind
extends
    Parseable[WorkTimeScheduleKind]
{
    val sup = BasicElement.parse _
    val actual = parse_attribute (attribute ("""WorkTimeScheduleKind.actual"""))_
    val earliest = parse_attribute (attribute ("""WorkTimeScheduleKind.earliest"""))_
    val estimate = parse_attribute (attribute ("""WorkTimeScheduleKind.estimate"""))_
    val latest = parse_attribute (attribute ("""WorkTimeScheduleKind.latest"""))_
    val request = parse_attribute (attribute ("""WorkTimeScheduleKind.request"""))_
    def parse (context: Context): WorkTimeScheduleKind =
    {
        WorkTimeScheduleKind(
            sup (context),
            actual (context),
            earliest (context),
            estimate (context),
            latest (context),
            request (context)
        )
    }
}

object _Work
{
    def register: Unit =
    {
        BaseWork.register
        MaintenanceLocation.register
        MaterialItem.register
        Tool.register
        Vehicle.register
        VehicleUsageKind.register
        Work.register
        WorkAsset.register
        WorkKind.register
        WorkLocation.register
        WorkStatusKind.register
        WorkTask.register
        WorkTaskKind.register
        WorkTimeSchedule.register
        WorkTimeScheduleKind.register
    }
}