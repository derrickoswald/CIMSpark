package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * This package contains the core information classes that support work management and network extension planning applications.
 */

/**
 * Common representation for work and work tasks.
 * @param sup Reference to the superclass object.
 * @param kind Kind of work.
 * @param priority Priority of work.
 * @param statusKind Kind of work status.
 * @param WorkLocation Location for this work/task.
 */
case class BaseWork
(
    override val sup: Document,
    val kind: String,
    val priority: String,
    val statusKind: String,
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
    val kind = parse_attribute (attribute ("""BaseWork.kind"""))
    val priority = parse_attribute (attribute ("""BaseWork.priority"""))
    val statusKind = parse_attribute (attribute ("""BaseWork.statusKind"""))
    val WorkLocation = parse_attribute (attribute ("""BaseWork.WorkLocation"""))
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
 * @param sup Reference to the superclass object.
 * @param block (if applicable) Name, identifier, or description of the block in which work is to occur.
 * @param lot (if applicable) Name, identifier, or description of the lot in which work is to occur.
 * @param nearestIntersection The names of streets at the nearest intersection to work area.
 * @param subdivision (if applicable) Name, identifier, or description of the subdivision in which work is to occur.
 */
case class MaintenanceLocation
(
    override val sup: WorkLocation,
    val block: String,
    val lot: String,
    val nearestIntersection: String,
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
    val block = parse_element (element ("""MaintenanceLocation.block"""))
    val lot = parse_element (element ("""MaintenanceLocation.lot"""))
    val nearestIntersection = parse_element (element ("""MaintenanceLocation.nearestIntersection"""))
    val subdivision = parse_element (element ("""MaintenanceLocation.subdivision"""))
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
 * @param sup Reference to the superclass object.
 * @param quantity Quantity of material used.
 * @param TypeMaterial
 * @param WorkTask
 */
case class MaterialItem
(
    override val sup: IdentifiedObject,
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
    val quantity = parse_attribute (attribute ("""MaterialItem.quantity"""))
    val TypeMaterial = parse_attribute (attribute ("""MaterialItem.TypeMaterial"""))
    val WorkTask = parse_attribute (attribute ("""MaterialItem.WorkTask"""))
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
 * @param sup Reference to the superclass object.
 * @param lastCalibrationDate (if applicable) Date the tool was last calibrated.
 */
case class Tool
(
    override val sup: WorkAsset,
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
    val lastCalibrationDate = parse_element (element ("""Tool.lastCalibrationDate"""))
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
 * @param sup Reference to the superclass object.
 * @param odometerReadDateTime Date and time the last odometer reading was recorded.
 * @param odometerReading Odometer reading of this vehicle as of the 'odometerReadingDateTime'.
 *        Refer to associated ActivityRecords for earlier readings.
 * @param usageKind Kind of usage of the vehicle.
 */
case class Vehicle
(
    override val sup: WorkAsset,
    val odometerReadDateTime: String,
    val odometerReading: Double,
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
    val odometerReadDateTime = parse_element (element ("""Vehicle.odometerReadDateTime"""))
    val odometerReading = parse_element (element ("""Vehicle.odometerReading"""))
    val usageKind = parse_attribute (attribute ("""Vehicle.usageKind"""))
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
 * @param sup Reference to the superclass object.
 * @param contractor
 * @param crew
 * @param other
 * @param user
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
    val contractor = parse_attribute (attribute ("""VehicleUsageKind.contractor"""))
    val crew = parse_attribute (attribute ("""VehicleUsageKind.crew"""))
    val other = parse_attribute (attribute ("""VehicleUsageKind.other"""))
    val user = parse_attribute (attribute ("""VehicleUsageKind.user"""))
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
 * @param sup Reference to the superclass object.
 * @param requestDateTime Date and time work was requested.
 * @param BusinessCase
 * @param ErpProjectAccounting
 * @param Project
 * @param WorkBillingInfo
 */
case class Work
(
    override val sup: BaseWork,
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
    val requestDateTime = parse_element (element ("""Work.requestDateTime"""))
    val BusinessCase = parse_attribute (attribute ("""Work.BusinessCase"""))
    val ErpProjectAccounting = parse_attribute (attribute ("""Work.ErpProjectAccounting"""))
    val Project = parse_attribute (attribute ("""Work.Project"""))
    val WorkBillingInfo = parse_attribute (attribute ("""Work.WorkBillingInfo"""))
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
 * @param sup Reference to the superclass object.
 * @param Crew Crew using this work asset.
 */
case class WorkAsset
(
    override val sup: Asset,
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
    val Crew = parse_attribute (attribute ("""WorkAsset.Crew"""))
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
 * @param sup Reference to the superclass object.
 * @param connect Connect work.
 * @param construction Construction work.
 * @param disconnect Disconnect work.
 * @param inspection Inspection work.
 * @param maintenance Maintenance work.
 * @param other Other kind of work.
 * @param reconnect (use 'connect' instead) Reconnect work.
 * @param repair Repair work.
 * @param service Service work.
 * @param test Test work.
 */
case class WorkKind
(
    override val sup: BasicElement,
    val connect: String,
    val construction: String,
    val disconnect: String,
    val inspection: String,
    val maintenance: String,
    val other: String,
    val reconnect: String,
    val repair: String,
    val service: String,
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
    val connect = parse_attribute (attribute ("""WorkKind.connect"""))
    val construction = parse_attribute (attribute ("""WorkKind.construction"""))
    val disconnect = parse_attribute (attribute ("""WorkKind.disconnect"""))
    val inspection = parse_attribute (attribute ("""WorkKind.inspection"""))
    val maintenance = parse_attribute (attribute ("""WorkKind.maintenance"""))
    val other = parse_attribute (attribute ("""WorkKind.other"""))
    val reconnect = parse_attribute (attribute ("""WorkKind.reconnect"""))
    val repair = parse_attribute (attribute ("""WorkKind.repair"""))
    val service = parse_attribute (attribute ("""WorkKind.service"""))
    val test = parse_attribute (attribute ("""WorkKind.test"""))
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
 * @param sup Reference to the superclass object.
 * @param OneCallRequest
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
    val OneCallRequest = parse_attribute (attribute ("""WorkLocation.OneCallRequest"""))
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
 * @param sup Reference to the superclass object.
 * @param approved Work has been approved.
 * @param cancelled Work has been canceled.
 * @param closed Work has been closed (typically by a person responsible for work management) and is ready for billing.
 * @param completed Work has been completed, i.e., crew can leave the work location and is available for another work.
 * @param dispatched Crew has been dispatched.
 * @param enroute Crew is 'en route'.
 * @param inProgress Work is in progress.
 * @param onSite Crew is on the site.
 * @param scheduled Work has been scheduled.
 * @param waitingOnApproval Work approval is pending.
 * @param waitingOnMaterial Work has been waiting on material.
 * @param waitingToBeScheduled Work needs to be scheduled.
 */
case class WorkStatusKind
(
    override val sup: BasicElement,
    val approved: String,
    val cancelled: String,
    val closed: String,
    val completed: String,
    val dispatched: String,
    val enroute: String,
    val inProgress: String,
    val onSite: String,
    val scheduled: String,
    val waitingOnApproval: String,
    val waitingOnMaterial: String,
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
    val approved = parse_attribute (attribute ("""WorkStatusKind.approved"""))
    val cancelled = parse_attribute (attribute ("""WorkStatusKind.cancelled"""))
    val closed = parse_attribute (attribute ("""WorkStatusKind.closed"""))
    val completed = parse_attribute (attribute ("""WorkStatusKind.completed"""))
    val dispatched = parse_attribute (attribute ("""WorkStatusKind.dispatched"""))
    val enroute = parse_attribute (attribute ("""WorkStatusKind.enroute"""))
    val inProgress = parse_attribute (attribute ("""WorkStatusKind.inProgress"""))
    val onSite = parse_attribute (attribute ("""WorkStatusKind.onSite"""))
    val scheduled = parse_attribute (attribute ("""WorkStatusKind.scheduled"""))
    val waitingOnApproval = parse_attribute (attribute ("""WorkStatusKind.waitingOnApproval"""))
    val waitingOnMaterial = parse_attribute (attribute ("""WorkStatusKind.waitingOnMaterial"""))
    val waitingToBeScheduled = parse_attribute (attribute ("""WorkStatusKind.waitingToBeScheduled"""))
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
    val crewETA: String,
    val instruction: String,
    val schedOverride: String,
    val taskKind: String,
    val Assets: List[String],
    val Crews: List[String],
    val OldAsset: String,
    val SwitchingPlan: String,
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
    val exchange: String,
    val install: String,
    val investigate: String,
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
    val exchange = parse_attribute (attribute ("""WorkTaskKind.exchange"""))
    val install = parse_attribute (attribute ("""WorkTaskKind.install"""))
    val investigate = parse_attribute (attribute ("""WorkTaskKind.investigate"""))
    val remove = parse_attribute (attribute ("""WorkTaskKind.remove"""))
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
 * @param sup Reference to the superclass object.
 * @param kind Kind of this work schedule.
 * @param BaseWork Time schedule for this work or work task.
 */
case class WorkTimeSchedule
(
    override val sup: TimeSchedule,
    val kind: String,
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
    val kind = parse_attribute (attribute ("""WorkTimeSchedule.kind"""))
    val BaseWork = parse_attribute (attribute ("""WorkTimeSchedule.BaseWork"""))
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
 * @param sup Reference to the superclass object.
 * @param actual
 * @param earliest
 * @param estimate
 * @param latest
 * @param request
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
    val actual = parse_attribute (attribute ("""WorkTimeScheduleKind.actual"""))
    val earliest = parse_attribute (attribute ("""WorkTimeScheduleKind.earliest"""))
    val estimate = parse_attribute (attribute ("""WorkTimeScheduleKind.estimate"""))
    val latest = parse_attribute (attribute ("""WorkTimeScheduleKind.latest"""))
    val request = parse_attribute (attribute ("""WorkTimeScheduleKind.request"""))
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