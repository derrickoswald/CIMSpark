package ch.ninecode.cim

import org.apache.spark.rdd.RDD
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions
import org.apache.spark.sql.SparkSession
import org.apache.spark.storage.StorageLevel
import org.slf4j.LoggerFactory

import ch.ninecode.model._

/**
 * Join CIM files from NIS Strom and SAP ISU.
 *
 * Resolve ServiceLocation objects based on the Name user attribute.
 *
 * @param spark The session with CIM RDD defined, for which the topology should be calculated
 * @param storage The storage level for new and replaced CIM RDD.
 */
class CIMJoin (spark: SparkSession, storage: StorageLevel) extends CIMRDD with Serializable
{
    implicit val session = spark
    implicit val level: StorageLevel = storage
    implicit val log = LoggerFactory.getLogger (getClass)

    def unbundle (a: ((Name,ServiceLocation), (Name,ServiceLocation))): (String, (ServiceLocation, ServiceLocation)) =
    {
        (a._2._2.id, (a._1._2, a._2._2))
    }

    def edit_service_location (a: (ServiceLocation, Option[(String, (ServiceLocation, ServiceLocation))])): ServiceLocation =
    {
        a._2 match
        {
            case (Some (x)) ⇒
                // for ISU ServiceLocation with a matching NIS ServiceLocation, make a merged one
                val isu = x._2._1
                val nis = x._2._2
                val element = BasicElement (
                    null,
                    isu.WorkLocation.Location.IdentifiedObject.mRID
                )
                val id = IdentifiedObject (
                    element,
                    nis.WorkLocation.Location.IdentifiedObject.aliasName, // aliasName, e.g. ######:nis_el_meter_point
                    isu.WorkLocation.Location.IdentifiedObject.aliasName, // description, e.g. Anschlussobjekt
                    element.mRID,                            // mRID
                    nis.WorkLocation.Location.IdentifiedObject.name,       // name, e.g. MST###
                    nis.WorkLocation.Location.IdentifiedObject.DiagramObjects,
                    nis.WorkLocation.Location.IdentifiedObject.Names
                )
                val location = Location (
                    sup = id,
                    direction = isu.WorkLocation.Location.direction,
                    electronicAddress = isu.WorkLocation.Location.electronicAddress,
                    geoInfoReference = isu.WorkLocation.Location.geoInfoReference,
                    mainAddress = isu.WorkLocation.Location.mainAddress,
                    phone1 = isu.WorkLocation.Location.phone1,
                    phone2 = isu.WorkLocation.Location.phone2,
                    secondaryAddress = nis.WorkLocation.Location.secondaryAddress, // take any NIS address it might have
                    status = isu.WorkLocation.Location.status,
                    `type` = nis.WorkLocation.Location.`type`,               // e.g. geographic
                    Assets = isu.WorkLocation.Location.Assets,
                    ConfigurationEvents = isu.WorkLocation.Location.ConfigurationEvents,
                    CoordinateSystem = nis.WorkLocation.Location.CoordinateSystem,  // e.g. wgs_84
                    Crews = isu.WorkLocation.Location.Crews,
                    Hazards = isu.WorkLocation.Location.Hazards,
                    LandProperties = isu.WorkLocation.Location.LandProperties,
                    Measurements = isu.WorkLocation.Location.Measurements,
                    PositionPoints = nis.WorkLocation.Location.PositionPoints,
                    PowerSystemResources = nis.WorkLocation.Location.PowerSystemResources,
                    Routes = isu.WorkLocation.Location.Routes
                )
                val worklocation = WorkLocation (
                    location,
                    BaseWorks = isu.WorkLocation.BaseWorks,
                    isu.WorkLocation.DesignLocations,
                    isu.WorkLocation.OneCallRequest
                )
                ServiceLocation (
                    worklocation,
                    accessMethod = isu.accessMethod,
                    needsInspection = isu.needsInspection,
                    siteAccessProblem = isu.siteAccessProblem,
                    CustomerAgreements = isu.CustomerAgreements,
                    EndDevices = isu.EndDevices,
                    UsagePoints = isu.UsagePoints
                )
            case (None) ⇒
                // the default action is to keep the original ServiceLocation (both NIS and ISU) where there isn't a match
                a._1
        }
    }

    def delete_service_location (a: (ServiceLocation, Option[(ServiceLocation, ServiceLocation)])): Boolean =
    {
        a._2 match
        {
            // delete ServiceLocation that match (they were edited already and new ones have an ISU mRID)
            case (Some (_)) ⇒ false
            // keep ServiceLocation without a match
            case (None) ⇒ true
        }
    }

    def edit_position_point (a: (PositionPoint, Option[(ServiceLocation, ServiceLocation)])): PositionPoint =
    {
        a._2 match
        {
            // for PositionPoint with a NIS ServiceLocation, make a new one with the ISU ServiceLocation
            case (Some (x)) ⇒
                PositionPoint (
                    BasicElement (null, a._1.id),
                    a._1.sequenceNumber,
                    a._1.xPosition,
                    a._1.yPosition,
                    a._1.zPosition,
                    x._1.id)
            // default is to keep the original PositionPoint where there isn't a match
            case (None) ⇒ a._1
        }
    }

    def edit_user_attribute (a: (UserAttribute, Option[(ServiceLocation, ServiceLocation)])): UserAttribute =
    {
        a._2 match
        {
            // for UserAttribute with a name of a NIS ServiceLocation, make a new one with the name of the ISU ServiceLocation
            case (Some (x)) ⇒
                UserAttribute (
                    sup = BasicElement (null, a._1.id),
                    name = x._1.id,
                    sequenceNumber = a._1.sequenceNumber,
                    value = a._1.value,
                    ErpInvoiceLineItems = a._1.ErpInvoiceLineItems,
                    ErpLedgerEntries = a._1.ErpLedgerEntries,
                    ProcedureDataSets = a._1.ProcedureDataSets,
                    PropertySpecification = a._1.PropertySpecification,
                    RatingSpecification = a._1.RatingSpecification,
                    Transaction = a._1.Transaction
                    )

            // default is to keep the original UserAttribute where there isn't a match
            case (None) ⇒ a._1
        }
    }

    def delete_name (a: (Name, Option[(ServiceLocation, ServiceLocation)])): Boolean =
    {
        a._2 match
        {
            // delete Name that matches (it was used to perform the join already)
            case (Some (_)) ⇒ false
            // keep Name without a match
            case (None) ⇒ true
        }
    }

    /**
     * Join NIS CIM file with ISU CIM file.
     *
     * The join uses the Name objects that contain both the SAP ISU id and the NIS number.
     * The tasks are:
     *
 1. Create new (or edit) the SAP ServiceLocation objects with:
   - mRID (rdf:ID) is the SAP ISU number (unchanged)
   - IdentifiedObject.name is the NIS number
   - IdentifiedObject.aliasName is the NIS internal id and class name
   - IdentifiedObject.description is the ISU description (aliasName)
   - Location.mainAddress is the ISU address data (unchanged)
 1. Change the location attribute of the PositionPoint object for the NIS ServiceLocation
    to point to the ISU ServiceLocation (i.e. replace MST# with ISU#)
 1. Change the UserAttribute objects that link the EnergyConsumer to ServiceLocation
    to point to the new (or edited) SAP ServiceLocation (i.e. replace MST# with ISU#)
 1. Optionally delete the NIS ServiceLocation
 1. Optionally delete the old Name object referencing the NIS ServiceLocation
    (this should clean out the Name RDD I think)
 1. Create a new Name object with the reverse orientation
    (Name.name = NIS MST# and Name.IdentifiedObject = SAP ISU#)
    [Not required if NIS ServiceLocation is deleted]
     *
     * So, in summary, edit these RDD:
 - ServiceLocation (merge & delete)
 - PositionPoint (edit)
 - UserAttribute (edit)
 - Name (delete)
     *
     * @return The updated Elements RDD.
     */
    def do_join (): RDD[Element] =
    {
        log.info ("joining ISU and NIS")

        val names = get[Name]
        val service_locations = get[ServiceLocation]
        val points = get[PositionPoint]
        val attributes = get[UserAttribute]

        // get only the cim:Name objects pertaining to the ServiceLocation join
        val isusl = names.keyBy (_.name).join (service_locations.keyBy (_.id)).values
        val nissl = names.keyBy (_.IdentifiedObject).join (service_locations.keyBy (_.id)).values

        // construct a useful intermediate representation of the cim:Name objects
        val pairs = isusl.keyBy (_._1.id).join (nissl.keyBy (_._1.id)).values.map (unbundle)

        // step 1, edit (replace) ISU ServiceLocation that have a corresponding NIS ServiceLocation
        val temp_locations = service_locations.keyBy (_.id).leftOuterJoin (pairs.keyBy (_._2._1.id)).values.map (edit_service_location)
        // step 4, delete the NIS ServiceLocations that have a corresponding ISU ServiceLocation
        val updated_locations = temp_locations.keyBy (_.id).leftOuterJoin (pairs).values.filter (delete_service_location).map (_._1)
        put (service_locations)

        // step 2, change the Location attribute of affected PositionPoint
        val updated_points = points.keyBy (_.Location).leftOuterJoin (pairs).values.map (edit_position_point)
        put (updated_points)

        // step 3, change the name attribute of affected UserAttribute
        val updated_attributes = attributes.keyBy (_.name).leftOuterJoin (pairs).values.map (edit_user_attribute)
        put (updated_attributes)

        // step 5 and 6, delete the Name objects that are no longer needed
        val updated_names = names.keyBy (_.IdentifiedObject).leftOuterJoin (pairs).values.filter (delete_name).map (_._1)
        put (updated_names)

        // replace service locations in WorkLocation
        val old_work_loc = get[WorkLocation]
        val updated_worklocations_pairrdd = updated_locations.map (_.WorkLocation).keyBy (_.id)
        val new_work_loc = old_work_loc.keyBy (_.id).leftOuterJoin (updated_worklocations_pairrdd).
            values.flatMap (
                (arg: (WorkLocation, Option[WorkLocation])) =>
                    arg._2 match
                    {
                        case Some (x) => List(x)
                        case None => List (arg._1)
                    }
                )
        put (new_work_loc)

        // replace service locations in Location
        val old_loc = get[Location]
        val new_loc = old_loc.keyBy (_.id).leftOuterJoin (updated_locations.map (_.WorkLocation.Location).keyBy (_.id)).
            values.flatMap (
                (arg: (Location, Option[Location])) =>
                    arg._2 match
                    {
                        case Some (x) => List(x)
                        case None => List (arg._1)
                    }
                )
        put (new_loc)

        // new RDD as IdentifiedObject
        val idobj = old_loc.map (_.IdentifiedObject)

        // replace identified objects in IdentifiedObject
        val old_idobj = get[IdentifiedObject]
        val new_idobj = old_idobj.keyBy (_.id).leftOuterJoin (idobj.keyBy (_.id)).
            values.flatMap (
                (arg: (IdentifiedObject, Option[IdentifiedObject])) =>
                    arg._2 match
                    {
                        case Some (x) => List(x)
                        case None => List (arg._1)
                    }
                )
        put (new_idobj)

        // make a union of all new RDD as Element
        val newelem = updated_points.asInstanceOf[RDD[Element]].
            union (updated_attributes.asInstanceOf[RDD[Element]]).
            union (updated_names.asInstanceOf[RDD[Element]]).
            union (updated_locations.asInstanceOf[RDD[Element]])

        // replace elements in Elements
        val old_elements = get[Element]("Elements")
        val new_elements = old_elements.keyBy (_.id).leftOuterJoin (newelem.keyBy (_.id)).
            values.flatMap (
                (arg: (Element, Option[Element])) =>
                    arg._2 match
                    {
                        case Some (x) => List(x)
                        case None => List (arg._1)
                    }
                )

        // swap the old Elements RDD for the new one
        old_elements.name = "unjoined_Elements"
        new_elements.name = "Elements"
        new_elements.persist (storage)
        spark.sparkContext.getCheckpointDir match
        {
            case Some (_) => new_elements.checkpoint ()
            case None =>
        }

        new_elements
    }
}
