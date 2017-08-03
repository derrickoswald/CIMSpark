package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

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
    kind: String,
    priority: String,
    statusKind: String,
    WorkLocation: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
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
        "\t</cim:BaseWork>\n"
    }
}

object BaseWork
extends
    Parseable[BaseWork]
{
    val kind: (Context) => String = parse_attribute (attribute ("""BaseWork.kind"""))
    val priority: (Context) => String = parse_attribute (attribute ("""BaseWork.priority"""))
    val statusKind: (Context) => String = parse_attribute (attribute ("""BaseWork.statusKind"""))
    val WorkLocation: (Context) => String = parse_attribute (attribute ("""BaseWork.WorkLocation"""))
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
 * @param sup Reference to the superclass object.
 * @param block (if applicable) Name, identifier, or description of the block in which work is to occur.
 * @param lot (if applicable) Name, identifier, or description of the lot in which work is to occur.
 * @param nearestIntersection The names of streets at the nearest intersection to work area.
 * @param subdivision (if applicable) Name, identifier, or description of the subdivision in which work is to occur.
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
    def this () = { this (null, null, null, null, null) }
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
        "\t</cim:MaintenanceLocation>\n"
    }
}

object MaintenanceLocation
extends
    Parseable[MaintenanceLocation]
{
    val block: (Context) => String = parse_element (element ("""MaintenanceLocation.block"""))
    val lot: (Context) => String = parse_element (element ("""MaintenanceLocation.lot"""))
    val nearestIntersection: (Context) => String = parse_element (element ("""MaintenanceLocation.nearestIntersection"""))
    val subdivision: (Context) => String = parse_element (element ("""MaintenanceLocation.subdivision"""))
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
 * It includes items such as nuts, bolts, brackets, glue, etc.
 * @param sup Reference to the superclass object.
 * @param quantity Quantity of material used.
 * @param TypeMaterial <em>undocumented</em>
 * @param WorkTask <em>undocumented</em>
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
    def this () = { this (null, null, null, null) }
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
        "\t</cim:MaterialItem>\n"
    }
}

object MaterialItem
extends
    Parseable[MaterialItem]
{
    val quantity: (Context) => String = parse_attribute (attribute ("""MaterialItem.quantity"""))
    val TypeMaterial: (Context) => String = parse_attribute (attribute ("""MaterialItem.TypeMaterial"""))
    val WorkTask: (Context) => String = parse_attribute (attribute ("""MaterialItem.WorkTask"""))
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
 * @param sup Reference to the superclass object.
 * @param lastCalibrationDate (if applicable) Date the tool was last calibrated.
 */
case class Tool
(
    override val sup: WorkAsset,
    lastCalibrationDate: String
)
extends
    Element
{
    def this () = { this (null, null) }
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
        "\t</cim:Tool>\n"
    }
}

object Tool
extends
    Parseable[Tool]
{
    val lastCalibrationDate: (Context) => String = parse_element (element ("""Tool.lastCalibrationDate"""))
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
 * @param sup Reference to the superclass object.
 * @param odometerReadDateTime Date and time the last odometer reading was recorded.
 * @param odometerReading Odometer reading of this vehicle as of the 'odometerReadingDateTime'.
 *        Refer to associated ActivityRecords for earlier readings.
 * @param usageKind Kind of usage of the vehicle.
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
    def this () = { this (null, null, 0.0, null) }
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
        "\t</cim:Vehicle>\n"
    }
}

object Vehicle
extends
    Parseable[Vehicle]
{
    val odometerReadDateTime: (Context) => String = parse_element (element ("""Vehicle.odometerReadDateTime"""))
    val odometerReading: (Context) => String = parse_element (element ("""Vehicle.odometerReading"""))
    val usageKind: (Context) => String = parse_attribute (attribute ("""Vehicle.usageKind"""))
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
 * Usage of a vehicle.
 * @param sup Reference to the superclass object.
 * @param contractor <em>undocumented</em>
 * @param crew <em>undocumented</em>
 * @param other <em>undocumented</em>
 * @param user <em>undocumented</em>
 */
case class VehicleUsageKind
(
    override val sup: BasicElement,
    contractor: String,
    crew: String,
    other: String,
    user: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[VehicleUsageKind] }
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
        (if (null != contractor) "\t\t<cim:VehicleUsageKind.contractor rdf:resource=\"#" + contractor + "\"/>\n" else "") +
        (if (null != crew) "\t\t<cim:VehicleUsageKind.crew rdf:resource=\"#" + crew + "\"/>\n" else "") +
        (if (null != other) "\t\t<cim:VehicleUsageKind.other rdf:resource=\"#" + other + "\"/>\n" else "") +
        (if (null != user) "\t\t<cim:VehicleUsageKind.user rdf:resource=\"#" + user + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:VehicleUsageKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:VehicleUsageKind>\n"
    }
}

object VehicleUsageKind
extends
    Parseable[VehicleUsageKind]
{
    val contractor: (Context) => String = parse_attribute (attribute ("""VehicleUsageKind.contractor"""))
    val crew: (Context) => String = parse_attribute (attribute ("""VehicleUsageKind.crew"""))
    val other: (Context) => String = parse_attribute (attribute ("""VehicleUsageKind.other"""))
    val user: (Context) => String = parse_attribute (attribute ("""VehicleUsageKind.user"""))
    def parse (context: Context): VehicleUsageKind =
    {
        VehicleUsageKind(
            BasicElement.parse (context),
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
 * @param BusinessCase <em>undocumented</em>
 * @param ErpProjectAccounting <em>undocumented</em>
 * @param Project <em>undocumented</em>
 * @param WorkBillingInfo <em>undocumented</em>
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
    def this () = { this (null, null, null, null, null, null) }
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
        "\t</cim:Work>\n"
    }
}

object Work
extends
    Parseable[Work]
{
    val requestDateTime: (Context) => String = parse_element (element ("""Work.requestDateTime"""))
    val BusinessCase: (Context) => String = parse_attribute (attribute ("""Work.BusinessCase"""))
    val ErpProjectAccounting: (Context) => String = parse_attribute (attribute ("""Work.ErpProjectAccounting"""))
    val Project: (Context) => String = parse_attribute (attribute ("""Work.Project"""))
    val WorkBillingInfo: (Context) => String = parse_attribute (attribute ("""Work.WorkBillingInfo"""))
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
 * @param sup Reference to the superclass object.
 * @param Crew Crew using this work asset.
 */
case class WorkAsset
(
    override val sup: Asset,
    Crew: String
)
extends
    Element
{
    def this () = { this (null, null) }
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
        "\t</cim:WorkAsset>\n"
    }
}

object WorkAsset
extends
    Parseable[WorkAsset]
{
    val Crew: (Context) => String = parse_attribute (attribute ("""WorkAsset.Crew"""))
    def parse (context: Context): WorkAsset =
    {
        WorkAsset(
            Asset.parse (context),
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
    connect: String,
    construction: String,
    disconnect: String,
    inspection: String,
    maintenance: String,
    other: String,
    reconnect: String,
    repair: String,
    service: String,
    test: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[WorkKind] }
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
        (if (null != connect) "\t\t<cim:WorkKind.connect rdf:resource=\"#" + connect + "\"/>\n" else "") +
        (if (null != construction) "\t\t<cim:WorkKind.construction rdf:resource=\"#" + construction + "\"/>\n" else "") +
        (if (null != disconnect) "\t\t<cim:WorkKind.disconnect rdf:resource=\"#" + disconnect + "\"/>\n" else "") +
        (if (null != inspection) "\t\t<cim:WorkKind.inspection rdf:resource=\"#" + inspection + "\"/>\n" else "") +
        (if (null != maintenance) "\t\t<cim:WorkKind.maintenance rdf:resource=\"#" + maintenance + "\"/>\n" else "") +
        (if (null != other) "\t\t<cim:WorkKind.other rdf:resource=\"#" + other + "\"/>\n" else "") +
        (if (null != reconnect) "\t\t<cim:WorkKind.reconnect rdf:resource=\"#" + reconnect + "\"/>\n" else "") +
        (if (null != repair) "\t\t<cim:WorkKind.repair rdf:resource=\"#" + repair + "\"/>\n" else "") +
        (if (null != service) "\t\t<cim:WorkKind.service rdf:resource=\"#" + service + "\"/>\n" else "") +
        (if (null != test) "\t\t<cim:WorkKind.test rdf:resource=\"#" + test + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WorkKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WorkKind>\n"
    }
}

object WorkKind
extends
    Parseable[WorkKind]
{
    val connect: (Context) => String = parse_attribute (attribute ("""WorkKind.connect"""))
    val construction: (Context) => String = parse_attribute (attribute ("""WorkKind.construction"""))
    val disconnect: (Context) => String = parse_attribute (attribute ("""WorkKind.disconnect"""))
    val inspection: (Context) => String = parse_attribute (attribute ("""WorkKind.inspection"""))
    val maintenance: (Context) => String = parse_attribute (attribute ("""WorkKind.maintenance"""))
    val other: (Context) => String = parse_attribute (attribute ("""WorkKind.other"""))
    val reconnect: (Context) => String = parse_attribute (attribute ("""WorkKind.reconnect"""))
    val repair: (Context) => String = parse_attribute (attribute ("""WorkKind.repair"""))
    val service: (Context) => String = parse_attribute (attribute ("""WorkKind.service"""))
    val test: (Context) => String = parse_attribute (attribute ("""WorkKind.test"""))
    def parse (context: Context): WorkKind =
    {
        WorkKind(
            BasicElement.parse (context),
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
 * @param OneCallRequest <em>undocumented</em>
 */
case class WorkLocation
(
    override val sup: Location,
    OneCallRequest: String
)
extends
    Element
{
    def this () = { this (null, null) }
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
        "\t</cim:WorkLocation>\n"
    }
}

object WorkLocation
extends
    Parseable[WorkLocation]
{
    val OneCallRequest: (Context) => String = parse_attribute (attribute ("""WorkLocation.OneCallRequest"""))
    def parse (context: Context): WorkLocation =
    {
        WorkLocation(
            Location.parse (context),
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
    approved: String,
    cancelled: String,
    closed: String,
    completed: String,
    dispatched: String,
    enroute: String,
    inProgress: String,
    onSite: String,
    scheduled: String,
    waitingOnApproval: String,
    waitingOnMaterial: String,
    waitingToBeScheduled: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[WorkStatusKind] }
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
        (if (null != approved) "\t\t<cim:WorkStatusKind.approved rdf:resource=\"#" + approved + "\"/>\n" else "") +
        (if (null != cancelled) "\t\t<cim:WorkStatusKind.cancelled rdf:resource=\"#" + cancelled + "\"/>\n" else "") +
        (if (null != closed) "\t\t<cim:WorkStatusKind.closed rdf:resource=\"#" + closed + "\"/>\n" else "") +
        (if (null != completed) "\t\t<cim:WorkStatusKind.completed rdf:resource=\"#" + completed + "\"/>\n" else "") +
        (if (null != dispatched) "\t\t<cim:WorkStatusKind.dispatched rdf:resource=\"#" + dispatched + "\"/>\n" else "") +
        (if (null != enroute) "\t\t<cim:WorkStatusKind.enroute rdf:resource=\"#" + enroute + "\"/>\n" else "") +
        (if (null != inProgress) "\t\t<cim:WorkStatusKind.inProgress rdf:resource=\"#" + inProgress + "\"/>\n" else "") +
        (if (null != onSite) "\t\t<cim:WorkStatusKind.onSite rdf:resource=\"#" + onSite + "\"/>\n" else "") +
        (if (null != scheduled) "\t\t<cim:WorkStatusKind.scheduled rdf:resource=\"#" + scheduled + "\"/>\n" else "") +
        (if (null != waitingOnApproval) "\t\t<cim:WorkStatusKind.waitingOnApproval rdf:resource=\"#" + waitingOnApproval + "\"/>\n" else "") +
        (if (null != waitingOnMaterial) "\t\t<cim:WorkStatusKind.waitingOnMaterial rdf:resource=\"#" + waitingOnMaterial + "\"/>\n" else "") +
        (if (null != waitingToBeScheduled) "\t\t<cim:WorkStatusKind.waitingToBeScheduled rdf:resource=\"#" + waitingToBeScheduled + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WorkStatusKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WorkStatusKind>\n"
    }
}

object WorkStatusKind
extends
    Parseable[WorkStatusKind]
{
    val approved: (Context) => String = parse_attribute (attribute ("""WorkStatusKind.approved"""))
    val cancelled: (Context) => String = parse_attribute (attribute ("""WorkStatusKind.cancelled"""))
    val closed: (Context) => String = parse_attribute (attribute ("""WorkStatusKind.closed"""))
    val completed: (Context) => String = parse_attribute (attribute ("""WorkStatusKind.completed"""))
    val dispatched: (Context) => String = parse_attribute (attribute ("""WorkStatusKind.dispatched"""))
    val enroute: (Context) => String = parse_attribute (attribute ("""WorkStatusKind.enroute"""))
    val inProgress: (Context) => String = parse_attribute (attribute ("""WorkStatusKind.inProgress"""))
    val onSite: (Context) => String = parse_attribute (attribute ("""WorkStatusKind.onSite"""))
    val scheduled: (Context) => String = parse_attribute (attribute ("""WorkStatusKind.scheduled"""))
    val waitingOnApproval: (Context) => String = parse_attribute (attribute ("""WorkStatusKind.waitingOnApproval"""))
    val waitingOnMaterial: (Context) => String = parse_attribute (attribute ("""WorkStatusKind.waitingOnMaterial"""))
    val waitingToBeScheduled: (Context) => String = parse_attribute (attribute ("""WorkStatusKind.waitingToBeScheduled"""))
    def parse (context: Context): WorkStatusKind =
    {
        WorkStatusKind(
            BasicElement.parse (context),
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
    def this () = { this (null, null, null, null, null, List(), List(), null, null, null) }
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
        "\t</cim:WorkTask>\n"
    }
}

object WorkTask
extends
    Parseable[WorkTask]
{
    val crewETA: (Context) => String = parse_element (element ("""WorkTask.crewETA"""))
    val instruction: (Context) => String = parse_element (element ("""WorkTask.instruction"""))
    val schedOverride: (Context) => String = parse_element (element ("""WorkTask.schedOverride"""))
    val taskKind: (Context) => String = parse_attribute (attribute ("""WorkTask.taskKind"""))
    val Assets: (Context) => List[String] = parse_attributes (attribute ("""WorkTask.Assets"""))
    val Crews: (Context) => List[String] = parse_attributes (attribute ("""WorkTask.Crews"""))
    val OldAsset: (Context) => String = parse_attribute (attribute ("""WorkTask.OldAsset"""))
    val SwitchingPlan: (Context) => String = parse_attribute (attribute ("""WorkTask.SwitchingPlan"""))
    val Work: (Context) => String = parse_attribute (attribute ("""WorkTask.Work"""))
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

case class WorkTaskKind
(
    override val sup: BasicElement,
    exchange: String,
    install: String,
    investigate: String,
    remove: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[WorkTaskKind] }
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
        (if (null != exchange) "\t\t<cim:WorkTaskKind.exchange rdf:resource=\"#" + exchange + "\"/>\n" else "") +
        (if (null != install) "\t\t<cim:WorkTaskKind.install rdf:resource=\"#" + install + "\"/>\n" else "") +
        (if (null != investigate) "\t\t<cim:WorkTaskKind.investigate rdf:resource=\"#" + investigate + "\"/>\n" else "") +
        (if (null != remove) "\t\t<cim:WorkTaskKind.remove rdf:resource=\"#" + remove + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WorkTaskKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WorkTaskKind>\n"
    }
}

object WorkTaskKind
extends
    Parseable[WorkTaskKind]
{
    val exchange: (Context) => String = parse_attribute (attribute ("""WorkTaskKind.exchange"""))
    val install: (Context) => String = parse_attribute (attribute ("""WorkTaskKind.install"""))
    val investigate: (Context) => String = parse_attribute (attribute ("""WorkTaskKind.investigate"""))
    val remove: (Context) => String = parse_attribute (attribute ("""WorkTaskKind.remove"""))
    def parse (context: Context): WorkTaskKind =
    {
        WorkTaskKind(
            BasicElement.parse (context),
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
    kind: String,
    BaseWork: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
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
        "\t</cim:WorkTimeSchedule>\n"
    }
}

object WorkTimeSchedule
extends
    Parseable[WorkTimeSchedule]
{
    val kind: (Context) => String = parse_attribute (attribute ("""WorkTimeSchedule.kind"""))
    val BaseWork: (Context) => String = parse_attribute (attribute ("""WorkTimeSchedule.BaseWork"""))
    def parse (context: Context): WorkTimeSchedule =
    {
        WorkTimeSchedule(
            TimeSchedule.parse (context),
            kind (context),
            BaseWork (context)
        )
    }
}

/**
 * Kind of work schedule.
 * @param sup Reference to the superclass object.
 * @param actual <em>undocumented</em>
 * @param earliest <em>undocumented</em>
 * @param estimate <em>undocumented</em>
 * @param latest <em>undocumented</em>
 * @param request <em>undocumented</em>
 */
case class WorkTimeScheduleKind
(
    override val sup: BasicElement,
    actual: String,
    earliest: String,
    estimate: String,
    latest: String,
    request: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[WorkTimeScheduleKind] }
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
        (if (null != actual) "\t\t<cim:WorkTimeScheduleKind.actual rdf:resource=\"#" + actual + "\"/>\n" else "") +
        (if (null != earliest) "\t\t<cim:WorkTimeScheduleKind.earliest rdf:resource=\"#" + earliest + "\"/>\n" else "") +
        (if (null != estimate) "\t\t<cim:WorkTimeScheduleKind.estimate rdf:resource=\"#" + estimate + "\"/>\n" else "") +
        (if (null != latest) "\t\t<cim:WorkTimeScheduleKind.latest rdf:resource=\"#" + latest + "\"/>\n" else "") +
        (if (null != request) "\t\t<cim:WorkTimeScheduleKind.request rdf:resource=\"#" + request + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WorkTimeScheduleKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WorkTimeScheduleKind>\n"
    }
}

object WorkTimeScheduleKind
extends
    Parseable[WorkTimeScheduleKind]
{
    val actual: (Context) => String = parse_attribute (attribute ("""WorkTimeScheduleKind.actual"""))
    val earliest: (Context) => String = parse_attribute (attribute ("""WorkTimeScheduleKind.earliest"""))
    val estimate: (Context) => String = parse_attribute (attribute ("""WorkTimeScheduleKind.estimate"""))
    val latest: (Context) => String = parse_attribute (attribute ("""WorkTimeScheduleKind.latest"""))
    val request: (Context) => String = parse_attribute (attribute ("""WorkTimeScheduleKind.request"""))
    def parse (context: Context): WorkTimeScheduleKind =
    {
        WorkTimeScheduleKind(
            BasicElement.parse (context),
            actual (context),
            earliest (context),
            estimate (context),
            latest (context),
            request (context)
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
            VehicleUsageKind.register,
            Work.register,
            WorkAsset.register,
            WorkKind.register,
            WorkLocation.register,
            WorkStatusKind.register,
            WorkTask.register,
            WorkTaskKind.register,
            WorkTimeSchedule.register,
            WorkTimeScheduleKind.register
        )
    }
}