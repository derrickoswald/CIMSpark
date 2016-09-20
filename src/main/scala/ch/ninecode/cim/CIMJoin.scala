package ch.ninecode.cim

import org.apache.spark.rdd.RDD
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.types.SQLUserDefinedType
import org.apache.spark.storage.StorageLevel

import ch.ninecode.model._

class CIMJoin (val sqlContext: SQLContext, val storage: StorageLevel) extends Serializable
{
    def get (name: String): RDD[Element] =
    {
        val rdds = sqlContext.sparkContext.getPersistentRDDs
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
        return ((a._1._1.id, (a._1._2, a._2._2)))
    }

    def edit_service_location (a: Tuple2[ServiceLocation, Option[(String, (ServiceLocation, ServiceLocation))]]): ServiceLocation =
    {
        return (
            a._2 match
            {
                case (Some (x)) ⇒
                {
                    // for ISU ServiceLocation with a matching NIS ServiceLocation, make a merged one
                    val nis = x._2._1
                    val isu = x._2._2
                    val id = IdentifiedObject (
                        null,
                        nis.Location.IdentifiedObject.aliasName, // aliasName, e.g. ######:nis_el_meter_point
                        isu.Location.IdentifiedObject.aliasName, // description, e.g. Anschlussobjekt
                        isu.Location.IdentifiedObject.mRID,      // mRID
                        nis.Location.IdentifiedObject.name       // name, e.g. MST###
                    )
                    val location = Location (
                        id,
                        isu.Location.direction,
                        isu.Location.geoInfoReference,
                        nis.Location.typ,               // e.g. geographic
                        nis.Location.CoordinateSystem,  // e.g. wgs_84
                        isu.Location.electronicAddress,
                        isu.Location.mainAddress,
                        isu.Location.phone1,
                        isu.Location.phone2,
                        isu.Location.secondaryAddress,
                        isu.Location.status
                    )
                    ServiceLocation (
                        location,
                        isu.accessMethod,
                        isu.needsInspection,
                        isu.siteAccessProblem
                    )
                }
                case (None) ⇒
                {
                    // default is to keep the original ServiceLocation (both NIS and ISU) where there isn't a match
                    a._1
                }
            }
        )
    }


    def delete_service_location (a: Tuple2[ServiceLocation, Option[(String, (ServiceLocation, ServiceLocation))]]): Boolean =
    {
        return (
            a._2 match
            {
                case (Some (x)) ⇒
                {
                    // delete ServiceLocation that match (they were edited already and new ones have an ISU mRID)
                    false
                }
                case (None) ⇒
                {
                    // keep ServiceLocation without a match
                    true
                }
            }
        )
    }

    def edit_position_point (a: Tuple2[PositionPoint, Option[(String, (ServiceLocation, ServiceLocation))]]): PositionPoint =
    {
        return (
            a._2 match
            {
                case (Some (x)) ⇒
                {
                    // for PositionPoint with a NIS ServiceLocation, make a new one with the ISU ServiceLocation
                    PositionPoint (
                        BasicElement (null, a._1.id),
                        a._1.sequenceNumber,
                        a._1.xPosition,
                        a._1.yPosition,
                        a._1.zPosition,
                        x._2._2.id)
                }
                case (None) ⇒
                {
                    // default is to keep the original PositionPoint where there isn't a match
                    a._1
                }
            }
        )
    }

    def edit_user_attribute (a: Tuple2[UserAttribute, Option[(String, (ServiceLocation, ServiceLocation))]]): UserAttribute =
    {
        return (
            a._2 match
            {
                case (Some (x)) ⇒
                {
                    // for UserAttribute with a name of a NIS ServiceLocation, make a new one with the name of the ISU ServiceLocation
                    UserAttribute (
                        BasicElement (null, a._1.id),
                        x._2._2.id,
                        a._1.sequenceNumber,
                        a._1.PropertySpecification,
                        a._1.RatingSpecification,
                        a._1.Transaction,
                        a._1.value)
                }
                case (None) ⇒
                {
                    // default is to keep the original UserAttribute where there isn't a match
                    a._1
                }
            }
        )
    }

    def delete_name (a: Tuple2[Name, Option[(String, (ServiceLocation, ServiceLocation))]]): Boolean =
    {
        return (
            a._2 match
            {
                case (Some (x)) ⇒
                {
                    // delete Name that matches (it was used to perform the join already)
                    false
                }
                case (None) ⇒
                {
                    // keep Name without a match
                    true
                }
            }
        )
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
    def do_join ()
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
        val temp_locations = locations.keyBy (_.id).leftOuterJoin (pairs.keyBy (_._2._2.id)).values.map (edit_service_location)
        // step 4, delete the NIS ServiceLocations that have a corresponding ISU ServiceLocation
        val updated_locations = temp_locations.keyBy (_.id).leftOuterJoin (pairs.keyBy (_._2._1.id)).values.filter (delete_service_location).map (_._1)

        // step 2, change the Location attribute of affected PositionPoint
        val updated_points = points.keyBy (_.Location).leftOuterJoin (pairs.keyBy (_._2._2.id)).values.map (edit_position_point)

        // step 3, change the name attribute of affected UserAttribute
        val updated_attributes = attributes.keyBy (_.name).leftOuterJoin (pairs.keyBy (_._2._2.id)).values.map (edit_user_attribute)

        // step 5 and 6, delete the Name objects that are no longer needed
        val updated_names = names.keyBy (_.IdentifiedObj).leftOuterJoin (pairs.keyBy (_._2._2.id)).values.filter (delete_name).map (_._1)

        // swap the old for the new

        names.name = "trash_names"
        names.unpersist (false)
        updated_names.name = "Name"
        updated_names.persist (storage)
        sqlContext.createDataFrame (updated_names).registerTempTable ("Name")

        locations.name = "trash_locations"
        locations.unpersist (false)
        updated_locations.name = "ServiceLocation"
        updated_locations.persist (storage)
        sqlContext.createDataFrame (updated_locations).registerTempTable ("ServiceLocation")

        points.name = "trash_points"
        points.unpersist (false)
        updated_points.name = "PositionPoint"
        updated_points.persist (storage)
        sqlContext.createDataFrame (updated_points).registerTempTable ("PositionPoint")

        attributes.name = "trash_attributes"
        attributes.unpersist (false)
        updated_attributes.name = "UserAttribute"
        updated_attributes.persist (storage)
        sqlContext.createDataFrame (updated_attributes).registerTempTable ("UserAttribute")

    }
}
