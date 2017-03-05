package ch.ninecode.cim

import org.apache.spark.rdd.RDD
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.SQLUserDefinedType
import org.apache.spark.storage.StorageLevel

import org.apache.spark.sql.types._
import ch.ninecode.model._

class CIMJoin (session: SparkSession, storage: StorageLevel) extends Serializable
{
    def get (name: String): RDD[Element] =
    {
        val rdds = session.sparkContext.getPersistentRDDs
        for (key <- rdds.keys)
        {
            val rdd = rdds (key)
            if (rdd.name == name)
                return (rdd.asInstanceOf[RDD[Element]])
        }
        return (null)
    }

    def unbundle (a: Tuple2[Tuple2[Name,ServiceLocation], Tuple2[Name,ServiceLocation]]): Tuple2[String, Tuple2[ServiceLocation, ServiceLocation]] =
    {
        return ((a._2._2.id, (a._1._2, a._2._2)))
    }

    def edit_service_location (a: Tuple2[ServiceLocation, Option[(String, (ServiceLocation, ServiceLocation))]]): ServiceLocation =
    {
        return (
            a._2 match
            {
                case (Some (x)) ⇒
                {
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
                        nis.WorkLocation.Location.IdentifiedObject.name       // name, e.g. MST###
                    )
                    val location = Location (
                        id,
                        isu.WorkLocation.Location.direction,
                        isu.WorkLocation.Location.geoInfoReference,
                        nis.WorkLocation.Location.typ,               // e.g. geographic
                        nis.WorkLocation.Location.CoordinateSystem,  // e.g. wgs_84
                        isu.WorkLocation.Location.electronicAddress,
                        isu.WorkLocation.Location.mainAddress,
                        isu.WorkLocation.Location.phone1,
                        isu.WorkLocation.Location.phone2,
                        nis.WorkLocation.Location.secondaryAddress, // take any NIS address it might have
                        isu.WorkLocation.Location.status
                    )
                    val worklocation = WorkLocation (
                        location,
                        isu.WorkLocation.OneCallRequest
                    )
                    ServiceLocation (
                        worklocation,
                        isu.accessMethod,
                        isu.needsInspection,
                        isu.siteAccessProblem
                    )
                }
                case (None) ⇒
                {
                    // the default action is to keep the original ServiceLocation (both NIS and ISU) where there isn't a match
                    a._1
                }
            }
        )
    }

    def delete_service_location (a: Tuple2[ServiceLocation, Option[(ServiceLocation, ServiceLocation)]]): Boolean =
    {
        a._2 match
        {
            // delete ServiceLocation that match (they were edited already and new ones have an ISU mRID)
            case (Some (x)) ⇒ false
            // keep ServiceLocation without a match
            case (None) ⇒ true
        }
    }

    def edit_position_point (a: Tuple2[PositionPoint, Option[(ServiceLocation, ServiceLocation)]]): PositionPoint =
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

    def edit_user_attribute (a: Tuple2[UserAttribute, Option[(ServiceLocation, ServiceLocation)]]): UserAttribute =
    {
        a._2 match
        {
            // for UserAttribute with a name of a NIS ServiceLocation, make a new one with the name of the ISU ServiceLocation
            case (Some (x)) ⇒
                UserAttribute (
                    BasicElement (null, a._1.id),
                    x._1.id,
                    a._1.sequenceNumber,
                    a._1.PropertySpecification,
                    a._1.RatingSpecification,
                    a._1.Transaction,
                    a._1.value)
            // default is to keep the original UserAttribute where there isn't a match
            case (None) ⇒ a._1
        }
    }

    def delete_name (a: Tuple2[Name, Option[(ServiceLocation, ServiceLocation)]]): Boolean =
    {
        a._2 match
        {
            // delete Name that matches (it was used to perform the join already)
            case (Some (x)) ⇒ false
            // keep Name without a match
            case (None) ⇒ true
        }
    }

    /**
     * Join NIS CIM file with ISU CIM file.
     *
     * The join uses the Name objects that contain both the SAP ISU id and the NIS number.
     * The tasks are:
     * 1) Create new (or edit) the SAP ServiceLocation objects with:
     *   - mRID (rdf:ID) is the SAP ISU number (unchanged)
     *   - IdentifiedObject.name is the NIS number
     *   - IdentifiedObject.aliasName is the NIS internal id and class name
     *   - IdentifiedObject.description is the ISU description (aliasName)
     *   - Location.mainAddress is the ISU address data (unchanged)
     * 2) Change the location attribute of the PositionPoint object for the NIS ServiceLocation
     *    to point to the ISU ServiceLocation (i.e. replace MST# with ISU#)
     * 3) Change the UserAttribute objects that link the EnergyConsumer to ServiceLocation
     *    to point to the new (or edited) SAP ServiceLocation (i.e. replace MST# with ISU#)
     * 4) Optionally delete the NIS ServiceLocation
     * 5) Optionally delete the old Name object referencing the NIS ServiceLocation
     *    (this should clean out the Name RDD I think)
     * 6) Create a new Name object with the reverse orientation
     *    (Name.name = NIS MST# and Name.IdentifiedObject = SAP ISU#)
     *    [Not required if NIS ServiceLocation is deleted]
     *
     * So, in summary, edit these RDD:
     *    ServiceLocation (merge & delete)
     *    PositionPoint (edit)
     *    UserAttribute (edit)
     *    Name (delete)
     */
    def do_join (): RDD[Element] =
    {
        val names = get ("Name").asInstanceOf[RDD[Name]]
        val locations = get ("ServiceLocation").asInstanceOf[RDD[ServiceLocation]]
        val points = get ("PositionPoint").asInstanceOf[RDD[PositionPoint]]
        val attributes = get ("UserAttribute").asInstanceOf[RDD[UserAttribute]]

        // get only the cim:Name objects pertaining to the ServiceLocation join
        val isusl = names.keyBy (_.name).join (locations.keyBy (_.id)).values
        val nissl = names.keyBy (_.IdentifiedObj).join (locations.keyBy (_.id)).values

        // construct a useful intermediate representation of the cim:Name objects
        val pairs = isusl.keyBy (_._1.id).join (nissl.keyBy (_._1.id)).values.map (unbundle)

        // step 1, edit (replace) ISU ServiceLocation that have a corresponding NIS ServiceLocation
        val temp_locations = locations.keyBy (_.id).leftOuterJoin (pairs.keyBy (_._2._1.id)).values.map (edit_service_location)
        // step 4, delete the NIS ServiceLocations that have a corresponding ISU ServiceLocation
        val updated_locations = temp_locations.keyBy (_.id).leftOuterJoin (pairs).values.filter (delete_service_location).map (_._1)

        // step 2, change the Location attribute of affected PositionPoint
        val updated_points = points.keyBy (_.Location).leftOuterJoin (pairs).values.map (edit_position_point)

        // swap the old PositionPoint RDD for the new one
        points.name = null
        updated_points.name = "PositionPoint"
        updated_points.persist (storage)
        session.sparkContext.getCheckpointDir match
        {
            case Some (dir) => updated_points.checkpoint ()
            case None =>
        }
        session.createDataFrame (updated_points).createOrReplaceTempView ("PositionPoint")

        // step 3, change the name attribute of affected UserAttribute
        val updated_attributes = attributes.keyBy (_.name).leftOuterJoin (pairs).values.map (edit_user_attribute)

        // swap the old UserAttribute RDD for the new one
        attributes.name = null
        updated_attributes.name = "UserAttribute"
        updated_attributes.persist (storage)
        session.sparkContext.getCheckpointDir match
        {
            case Some (dir) => updated_attributes.checkpoint ()
            case None =>
        }
        session.createDataFrame (updated_attributes).createOrReplaceTempView ("UserAttribute")

        // step 5 and 6, delete the Name objects that are no longer needed
        val updated_names = names.keyBy (_.IdentifiedObj).leftOuterJoin (pairs).values.filter (delete_name).map (_._1)

        // swap the old Name RDD for the new one
        names.name = null
        updated_names.name = "Name"
        updated_names.persist (storage)
        session.sparkContext.getCheckpointDir match
        {
            case Some (dir) => updated_names.checkpoint ()
            case None =>
        }
        session.createDataFrame (updated_names).createOrReplaceTempView ("Name")

        // swap the old ServiceLocation RDD for the new one
        locations.name = null
        updated_locations.name = "ServiceLocation"
        updated_locations.persist (storage)
        session.sparkContext.getCheckpointDir match
        {
            case Some (dir) => updated_locations.checkpoint ()
            case None =>
        }
        session.createDataFrame (updated_locations).createOrReplaceTempView ("ServiceLocation")

        // replace service locations in WorkLocation
        val old_work_loc = get ("WorkLocation").asInstanceOf[RDD[WorkLocation]]
        val updated_worklocations_pairrdd = updated_locations.map (_.WorkLocation).keyBy (_.id)
        val new_work_loc = old_work_loc.keyBy (_.id).leftOuterJoin (updated_locations.map (_.WorkLocation).keyBy (_.id)).
            values.flatMap (
                (arg: Tuple2[WorkLocation, Option[WorkLocation]]) =>
                    arg._2 match
                    {
                        case Some (x) => List(x)
                        case None => List (arg._1)
                    }
                )

        // swap the old WorkLocation RDD for the new one
        old_work_loc.name = null
        new_work_loc.name = "WorkLocation"
        new_work_loc.persist (storage)
        session.sparkContext.getCheckpointDir match
        {
            case Some (dir) => new_work_loc.checkpoint ()
            case None =>
        }
        session.createDataFrame (new_work_loc).createOrReplaceTempView ("WorkLocation")

        // replace service locations in Location
        val old_loc = get ("Location").asInstanceOf[RDD[Location]]
        val new_loc = old_loc.keyBy (_.id).leftOuterJoin (updated_locations.map (_.WorkLocation.Location).keyBy (_.id)).
            values.flatMap (
                (arg: Tuple2[Location, Option[Location]]) =>
                    arg._2 match
                    {
                        case Some (x) => List(x)
                        case None => List (arg._1)
                    }
                )

        // swap the old Location RDD for the new one
        old_loc.name = null
        new_loc.name = "Location"
        new_loc.persist (storage)
        session.sparkContext.getCheckpointDir match
        {
            case Some (dir) => new_loc.checkpoint ()
            case None =>
        }
        session.createDataFrame (new_loc).createOrReplaceTempView ("Location")

        // make a union of all new RDD as IdentifiedObject
        val idobj = updated_names.map (_.IdentifiedObject).
            union (old_loc.map (_.IdentifiedObject))

        // replace identified objects in IdentifiedObject
        val old_idobj = get ("IdentifiedObject").asInstanceOf[RDD[IdentifiedObject]]
        val new_idobj = old_idobj.keyBy (_.id).leftOuterJoin (idobj.keyBy (_.id)).
            values.flatMap (
                (arg: Tuple2[IdentifiedObject, Option[IdentifiedObject]]) =>
                    arg._2 match
                    {
                        case Some (x) => List(x)
                        case None => List (arg._1)
                    }
                )

        // swap the old IdentifiedObject RDD for the new one
        old_idobj.name = null
        new_idobj.name = "IdentifiedObject"
        new_idobj.persist (storage)
        session.sparkContext.getCheckpointDir match
        {
            case Some (dir) => new_idobj.checkpoint ()
            case None =>
        }
        session.createDataFrame (new_idobj).createOrReplaceTempView ("IdentifiedObject")

        // make a union of all new RDD as Element
        val newelem = updated_points.asInstanceOf[RDD[Element]].
            union (updated_attributes.asInstanceOf[RDD[Element]]).
            union (updated_names.asInstanceOf[RDD[Element]]).
            union (updated_locations.asInstanceOf[RDD[Element]])

        // replace elements in Elements
        val old_elements = get ("Elements").asInstanceOf[RDD[Element]]
        val new_elements = old_elements.keyBy (_.id).leftOuterJoin (newelem.keyBy (_.id)).
            values.flatMap (
                (arg: Tuple2[Element, Option[Element]]) =>
                    arg._2 match
                    {
                        case Some (x) => List(x)
                        case None => List (arg._1)
                    }
                )

        // swap the old Elements RDD for the new one
        old_elements.name = null
        new_elements.name = "Elements"
        new_elements.persist (storage)
        session.sparkContext.getCheckpointDir match
        {
            case Some (dir) => new_elements.checkpoint ()
            case None =>
        }

        new_elements
    }
}
