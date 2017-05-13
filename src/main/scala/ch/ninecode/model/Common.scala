package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * This package contains the information classes that support distribution management in general.
 */

/**
 * Records activity for an entity at a point in time; activity may be for an event that has already occurred or for a planned activity.
 * @param sup Reference to the superclass object.
 * @param createdDateTime Date and time this activity record has been created (different from the 'status.dateTime', which is the time of a status change of the associated object, if applicable).
 * @param reason Reason for event resulting in this activity record, typically supplied when user initiated.
 * @param severity Severity level of event resulting in this activity record.
 * @param status Information on consequence of event resulting in this activity record.
 * @param typ Type of event resulting in this activity record.
 */
case class ActivityRecord
(override val sup: IdentifiedObject,
val createdDateTime: String,
val reason: String,
val severity: String,
val status: String,
val typ: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ActivityRecord]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ActivityRecord
extends
    Parseable[ActivityRecord]
{
    val sup = IdentifiedObject.parse _
    val createdDateTime = parse_element (element ("""ActivityRecord.createdDateTime"""))_
    val reason = parse_element (element ("""ActivityRecord.reason"""))_
    val severity = parse_element (element ("""ActivityRecord.severity"""))_
    val status = parse_attribute (attribute ("""ActivityRecord.status"""))_
    val typ = parse_element (element ("""ActivityRecord.type"""))_
    def parse (context: Context): ActivityRecord =
    {
        ActivityRecord(
            sup (context),
            createdDateTime (context),
            reason (context),
            severity (context),
            status (context),
            typ (context)
        )
    }
}

/**
 * Formal agreement between two parties defining the terms and conditions for a set of services.
 * The specifics of the services are, in turn, defined via one or more service agreements.
 * @param sup Reference to the superclass object.
 * @param signDate Date this agreement was consummated among associated persons and/or organisations.
 * @param validityInterval Date and time interval this agreement is valid (from going into effect to termination).
 */
case class Agreement
(override val sup: Document,
val signDate: String,
val validityInterval: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { return (clone ().asInstanceOf[Agreement]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Agreement
extends
    Parseable[Agreement]
{
    val sup = Document.parse _
    val signDate = parse_element (element ("""Agreement.signDate"""))_
    val validityInterval = parse_attribute (attribute ("""Agreement.validityInterval"""))_
    def parse (context: Context): Agreement =
    {
        Agreement(
            sup (context),
            signDate (context),
            validityInterval (context)
        )
    }
}

/**
 * Meeting time and location.
 * @param sup Reference to the superclass object.
 * @param callAhead True if requested to call customer when someone is about to arrive at their premises.
 * @param meetingInterval Date and time reserved for appointment.
 * @param Works All works for this appointment.
 */
case class Appointment
(override val sup: IdentifiedObject,
val callAhead: Boolean,
val meetingInterval: String,
val Works: List[String]
)
extends
    Element
{
    def this () = { this (null, false, null, List()) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Appointment]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Appointment
extends
    Parseable[Appointment]
{
    val sup = IdentifiedObject.parse _
    val callAhead = parse_element (element ("""Appointment.callAhead"""))_
    val meetingInterval = parse_attribute (attribute ("""Appointment.meetingInterval"""))_
    val Works = parse_attributes (attribute ("""Appointment.Works"""))_
    def parse (context: Context): Appointment =
    {
        Appointment(
            sup (context),
            toBoolean (callAhead (context), context),
            meetingInterval (context),
            Works (context)
        )
    }
}

/**
 * Used to report details on creation, change or deletion of an entity or its configuration.
 * @param sup Reference to the superclass object.
 * @param effectiveDateTime Date and time this event has or will become effective.
 * @param modifiedBy Source/initiator of modification.
 * @param remark Free text remarks.
 * @param ChangedAsset Asset whose change resulted in this configuration event.
 * @param ChangedDocument Document whose change resulted in this configuration event.
 * @param ChangedLocation Location whose change resulted in this configuration event.
 * @param ChangedOrganisationRole Organisation role whose change resulted in this configuration event.
 * @param ChangedPersonRole Person role whose change resulted in this configuration event.
 * @param ChangedServiceCategory Service category whose change resulted in this configuration event.
 * @param ChangedUsagePoint Usage point whose change resulted in this configuration event.
 */
case class ConfigurationEvent
(override val sup: ActivityRecord,
val effectiveDateTime: String,
val modifiedBy: String,
val remark: String,
val ChangedAsset: String,
val ChangedDocument: String,
val ChangedLocation: String,
val ChangedOrganisationRole: String,
val ChangedPersonRole: String,
val ChangedServiceCategory: String,
val ChangedUsagePoint: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null) }
    def ActivityRecord: ActivityRecord = sup.asInstanceOf[ActivityRecord]
    override def copy (): Row = { return (clone ().asInstanceOf[ConfigurationEvent]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ConfigurationEvent
extends
    Parseable[ConfigurationEvent]
{
    val sup = ActivityRecord.parse _
    val effectiveDateTime = parse_element (element ("""ConfigurationEvent.effectiveDateTime"""))_
    val modifiedBy = parse_element (element ("""ConfigurationEvent.modifiedBy"""))_
    val remark = parse_element (element ("""ConfigurationEvent.remark"""))_
    val ChangedAsset = parse_attribute (attribute ("""ConfigurationEvent.ChangedAsset"""))_
    val ChangedDocument = parse_attribute (attribute ("""ConfigurationEvent.ChangedDocument"""))_
    val ChangedLocation = parse_attribute (attribute ("""ConfigurationEvent.ChangedLocation"""))_
    val ChangedOrganisationRole = parse_attribute (attribute ("""ConfigurationEvent.ChangedOrganisationRole"""))_
    val ChangedPersonRole = parse_attribute (attribute ("""ConfigurationEvent.ChangedPersonRole"""))_
    val ChangedServiceCategory = parse_attribute (attribute ("""ConfigurationEvent.ChangedServiceCategory"""))_
    val ChangedUsagePoint = parse_attribute (attribute ("""ConfigurationEvent.ChangedUsagePoint"""))_
    def parse (context: Context): ConfigurationEvent =
    {
        ConfigurationEvent(
            sup (context),
            effectiveDateTime (context),
            modifiedBy (context),
            remark (context),
            ChangedAsset (context),
            ChangedDocument (context),
            ChangedLocation (context),
            ChangedOrganisationRole (context),
            ChangedPersonRole (context),
            ChangedServiceCategory (context),
            ChangedUsagePoint (context)
        )
    }
}

/**
 * Coordinate reference system.
 * @param sup Reference to the superclass object.
 * @param crsUrn A Uniform Resource Name (URN) for the coordinate reference system (crs) used to define 'Location.
 *        PositionPoints'.
 */
case class CoordinateSystem
(override val sup: IdentifiedObject,
val crsUrn: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[CoordinateSystem]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CoordinateSystem
extends
    Parseable[CoordinateSystem]
{
    val sup = IdentifiedObject.parse _
    val crsUrn = parse_element (element ("""CoordinateSystem.crsUrn"""))_
    def parse (context: Context): CoordinateSystem =
    {
        CoordinateSystem(
            sup (context),
            crsUrn (context)
        )
    }
}

/**
 * Group of people with specific skills, tools, and vehicles.
 * @param sup Reference to the superclass object.
 * @param status Status of this crew.
 * @param CrewType Type of this crew.
 */
case class Crew
(override val sup: IdentifiedObject,
val status: String,
val CrewType: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Crew]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Crew
extends
    Parseable[Crew]
{
    val sup = IdentifiedObject.parse _
    val status = parse_attribute (attribute ("""Crew.status"""))_
    val CrewType = parse_attribute (attribute ("""Crew.CrewType"""))_
    def parse (context: Context): Crew =
    {
        Crew(
            sup (context),
            status (context),
            CrewType (context)
        )
    }
}

/**
 * Member of a crew.
 * @param sup Reference to the superclass object.
 * @param Crew Crew to which this crew member belongs.
 */
case class CrewMember
(override val sup: OperationPersonRole,
val Crew: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def OperationPersonRole: OperationPersonRole = sup.asInstanceOf[OperationPersonRole]
    override def copy (): Row = { return (clone ().asInstanceOf[CrewMember]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CrewMember
extends
    Parseable[CrewMember]
{
    val sup = OperationPersonRole.parse _
    val Crew = parse_attribute (attribute ("""CrewMember.Crew"""))_
    def parse (context: Context): CrewMember =
    {
        CrewMember(
            sup (context),
            Crew (context)
        )
    }
}

/**
 * Custom description of the type of crew.
 * This may be used to determine the type of work the crew can be assigned to. Examples include repair, tree trimming, switching, etc.
 * @param sup Reference to the superclass object.
 */
case class CrewType
(override val sup: IdentifiedObject
)
extends
    Element
{
    def this () = { this (null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[CrewType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CrewType
extends
    Parseable[CrewType]
{
    val sup = IdentifiedObject.parse _
    def parse (context: Context): CrewType =
    {
        CrewType(
            sup (context)
        )
    }
}

/**
 * Parent class for different groupings of information collected and managed as a part of a business process.
 * It will frequently contain references to other objects, such as assets, people and power system resources.
 * @param sup Reference to the superclass object.
 * @param authorName Name of the author of this document.
 * @param comment Free text comment.
 * @param createdDateTime Date and time that this document was created.
 * @param docStatus Status of this document.
 *        For status of subject matter this document represents (e.g., Agreement, Work), use 'status' attribute.
 * @param electronicAddress Electronic address.
 * @param lastModifiedDateTime Date and time this document was last modified.
 *        Documents may potentially be modified many times during their lifetime.
 * @param revisionNumber Revision number for this document.
 * @param status Status of subject matter (e.g., Agreement, Work) this document represents.
 *        For status of the document itself, use 'docStatus' attribute.
 * @param subject Document subject.
 * @param title Document title.
 * @param typ Utility-specific classification of this document, according to its corporate standards, practices, and existing IT systems (e.g., for management of assets, maintenance, work, outage, customers, etc.).
 */
case class Document
(override val sup: IdentifiedObject,
val authorName: String,
val comment: String,
val createdDateTime: String,
val docStatus: String,
val electronicAddress: String,
val lastModifiedDateTime: String,
val revisionNumber: String,
val status: String,
val subject: String,
val title: String,
val typ: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Document]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Document
extends
    Parseable[Document]
{
    val sup = IdentifiedObject.parse _
    val authorName = parse_element (element ("""Document.authorName"""))_
    val comment = parse_element (element ("""Document.comment"""))_
    val createdDateTime = parse_element (element ("""Document.createdDateTime"""))_
    val docStatus = parse_attribute (attribute ("""Document.docStatus"""))_
    val electronicAddress = parse_attribute (attribute ("""Document.electronicAddress"""))_
    val lastModifiedDateTime = parse_element (element ("""Document.lastModifiedDateTime"""))_
    val revisionNumber = parse_element (element ("""Document.revisionNumber"""))_
    val status = parse_attribute (attribute ("""Document.status"""))_
    val subject = parse_element (element ("""Document.subject"""))_
    val title = parse_element (element ("""Document.title"""))_
    val typ = parse_element (element ("""Document.type"""))_
    def parse (context: Context): Document =
    {
        Document(
            sup (context),
            authorName (context),
            comment (context),
            createdDateTime (context),
            docStatus (context),
            electronicAddress (context),
            lastModifiedDateTime (context),
            revisionNumber (context),
            status (context),
            subject (context),
            title (context),
            typ (context)
        )
    }
}

/**
 * Electronic address information.
 * @param sup Reference to the superclass object.
 * @param email1 Primary email address.
 * @param email2 Alternate email address.
 * @param lan Address on local area network.
 * @param mac MAC (Media Access Control) address.
 * @param password Password needed to log in.
 * @param radio Radio address.
 * @param userID User ID needed to log in, which can be for an individual person, an organisation, a location, etc.
 * @param web World wide web address.
 */
case class ElectronicAddress
(override val sup: BasicElement,
val email1: String,
val email2: String,
val lan: String,
val mac: String,
val password: String,
val radio: String,
val userID: String,
val web: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ElectronicAddress]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ElectronicAddress
extends
    Parseable[ElectronicAddress]
{
    val sup = BasicElement.parse _
    val email1 = parse_element (element ("""ElectronicAddress.email1"""))_
    val email2 = parse_element (element ("""ElectronicAddress.email2"""))_
    val lan = parse_element (element ("""ElectronicAddress.lan"""))_
    val mac = parse_element (element ("""ElectronicAddress.mac"""))_
    val password = parse_element (element ("""ElectronicAddress.password"""))_
    val radio = parse_element (element ("""ElectronicAddress.radio"""))_
    val userID = parse_element (element ("""ElectronicAddress.userID"""))_
    val web = parse_element (element ("""ElectronicAddress.web"""))_
    def parse (context: Context): ElectronicAddress =
    {
        ElectronicAddress(
            sup (context),
            email1 (context),
            email2 (context),
            lan (context),
            mac (context),
            password (context),
            radio (context),
            userID (context),
            web (context)
        )
    }
}

/**
 * An object or a condition that is a danger for causing loss or perils to an asset and/or people.
 * @param sup Reference to the superclass object.
 * @param status Status of this hazard.
 * @param typ Type of this hazard.
 */
case class Hazard
(override val sup: IdentifiedObject,
val status: String,
val typ: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Hazard]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Hazard
extends
    Parseable[Hazard]
{
    val sup = IdentifiedObject.parse _
    val status = parse_attribute (attribute ("""Hazard.status"""))_
    val typ = parse_element (element ("""Hazard.type"""))_
    def parse (context: Context): Hazard =
    {
        Hazard(
            sup (context),
            status (context),
            typ (context)
        )
    }
}

/**
 * The place, scene, or point of something where someone or something has been, is, and/or will be at a given moment in time.
 * It can be defined with one or more postition points (coordinates) in a given coordinate system.
 * @param sup Reference to the superclass object.
 * @param direction (if applicable) Direction that allows field crews to quickly find a given asset.
 *        For a given location, such as a street address, this is the relative direction in which to find the asset. For example, a streetlight may be located at the 'NW' (northwest) corner of the customer's site, or a usage point may be located on the second floor of an apartment building.
 * @param electronicAddress Electronic address.
 * @param geoInfoReference (if applicable) Reference to geographical information source, often external to the utility.
 * @param mainAddress Main address of the location.
 * @param phone1 Phone number.
 * @param phone2 Additional phone number.
 * @param secondaryAddress Secondary address of the location.
 *        For example, PO Box address may have different ZIP code than that in the 'mainAddress'.
 * @param status Status of this location.
 * @param typ Classification by utility's corporate standards and practices, relative to the location itself (e.g., geographical, functional accounting, etc., not a given property that happens to exist at that location).
 * @param CoordinateSystem Coordinate system used to describe position points of this location.
 * @param Measurements
 */
case class Location
(override val sup: IdentifiedObject,
val direction: String,
val electronicAddress: String,
val geoInfoReference: String,
val mainAddress: String,
val phone1: String,
val phone2: String,
val secondaryAddress: String,
val status: String,
val typ: String,
val CoordinateSystem: String,
val Measurements: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, List()) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Location]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Location
extends
    Parseable[Location]
{
    val sup = IdentifiedObject.parse _
    val direction = parse_element (element ("""Location.direction"""))_
    val electronicAddress = parse_attribute (attribute ("""Location.electronicAddress"""))_
    val geoInfoReference = parse_element (element ("""Location.geoInfoReference"""))_
    val mainAddress = parse_attribute (attribute ("""Location.mainAddress"""))_
    val phone1 = parse_attribute (attribute ("""Location.phone1"""))_
    val phone2 = parse_attribute (attribute ("""Location.phone2"""))_
    val secondaryAddress = parse_attribute (attribute ("""Location.secondaryAddress"""))_
    val status = parse_attribute (attribute ("""Location.status"""))_
    val typ = parse_element (element ("""Location.type"""))_
    val CoordinateSystem = parse_attribute (attribute ("""Location.CoordinateSystem"""))_
    val Measurements = parse_attributes (attribute ("""Location.Measurements"""))_
    def parse (context: Context): Location =
    {
        Location(
            sup (context),
            direction (context),
            electronicAddress (context),
            geoInfoReference (context),
            mainAddress (context),
            phone1 (context),
            phone2 (context),
            secondaryAddress (context),
            status (context),
            typ (context),
            CoordinateSystem (context),
            Measurements (context)
        )
    }
}

/**
 * Person role in the context of utility operations.
 * @param sup Reference to the superclass object.
 */
case class OperationPersonRole
(override val sup: PersonRole
)
extends
    Element
{
    def this () = { this (null) }
    def PersonRole: PersonRole = sup.asInstanceOf[PersonRole]
    override def copy (): Row = { return (clone ().asInstanceOf[OperationPersonRole]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OperationPersonRole
extends
    Parseable[OperationPersonRole]
{
    val sup = PersonRole.parse _
    def parse (context: Context): OperationPersonRole =
    {
        OperationPersonRole(
            sup (context)
        )
    }
}

/**
 * Control room operator.
 * @param sup Reference to the superclass object.
 */
case class Operator
(override val sup: OperationPersonRole
)
extends
    Element
{
    def this () = { this (null) }
    def OperationPersonRole: OperationPersonRole = sup.asInstanceOf[OperationPersonRole]
    override def copy (): Row = { return (clone ().asInstanceOf[Operator]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Operator
extends
    Parseable[Operator]
{
    val sup = OperationPersonRole.parse _
    def parse (context: Context): Operator =
    {
        Operator(
            sup (context)
        )
    }
}

/**
 * Organisation that might have roles as utility, contractor, supplier, manufacturer, customer, etc.
 * @param sup Reference to the superclass object.
 * @param electronicAddress Electronic address.
 * @param phone1 Phone number.
 * @param phone2 Additional phone number.
 * @param postalAddress Postal address, potentially different than 'streetAddress' (e.g., another city).
 * @param streetAddress Street address.
 * @param ActivityRecords
 */
case class Organisation
(override val sup: IdentifiedObject,
val electronicAddress: String,
val phone1: String,
val phone2: String,
val postalAddress: String,
val streetAddress: String,
val ActivityRecords: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, List()) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Organisation]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Organisation
extends
    Parseable[Organisation]
{
    val sup = IdentifiedObject.parse _
    val electronicAddress = parse_attribute (attribute ("""Organisation.electronicAddress"""))_
    val phone1 = parse_attribute (attribute ("""Organisation.phone1"""))_
    val phone2 = parse_attribute (attribute ("""Organisation.phone2"""))_
    val postalAddress = parse_attribute (attribute ("""Organisation.postalAddress"""))_
    val streetAddress = parse_attribute (attribute ("""Organisation.streetAddress"""))_
    val ActivityRecords = parse_attributes (attribute ("""Organisation.ActivityRecords"""))_
    def parse (context: Context): Organisation =
    {
        Organisation(
            sup (context),
            electronicAddress (context),
            phone1 (context),
            phone2 (context),
            postalAddress (context),
            streetAddress (context),
            ActivityRecords (context)
        )
    }
}

/**
 * Identifies a way in which an organisation may participate in the utility enterprise (e.g., customer, manufacturer, etc).
 * @param sup Reference to the superclass object.
 * @param Organisation Organisation having this role.
 */
case class OrganisationRole
(override val sup: IdentifiedObject,
val Organisation: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[OrganisationRole]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OrganisationRole
extends
    Parseable[OrganisationRole]
{
    val sup = IdentifiedObject.parse _
    val Organisation = parse_attribute (attribute ("""OrganisationRole.Organisation"""))_
    def parse (context: Context): OrganisationRole =
    {
        OrganisationRole(
            sup (context),
            Organisation (context)
        )
    }
}

/**
 * Ownership of e.g. asset.
 * @param sup Reference to the superclass object.
 * @param share Share of this ownership.
 * @param Asset Asset that is object of this ownership.
 * @param AssetOwner Asset owner that is subject in this ownership.
 */
case class Ownership
(override val sup: IdentifiedObject,
val share: Double,
val Asset: String,
val AssetOwner: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Ownership]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Ownership
extends
    Parseable[Ownership]
{
    val sup = IdentifiedObject.parse _
    val share = parse_element (element ("""Ownership.share"""))_
    val Asset = parse_attribute (attribute ("""Ownership.Asset"""))_
    val AssetOwner = parse_attribute (attribute ("""Ownership.AssetOwner"""))_
    def parse (context: Context): Ownership =
    {
        Ownership(
            sup (context),
            toDouble (share (context), context),
            Asset (context),
            AssetOwner (context)
        )
    }
}

/**
 * General purpose information for name and other information to contact people.
 * @param sup Reference to the superclass object.
 * @param electronicAddress Electronic address.
 * @param firstName Person's first name.
 * @param landlinePhone Landline phone number.
 * @param lastName Person's last (family, sir) name.
 * @param mName Middle name(s) or initial(s).
 * @param mobilePhone Mobile phone number.
 * @param prefix A prefix or title for the person's name, such as Miss, Mister, Doctor, etc.
 * @param specialNeed Special service needs for the person (contact) are described; examples include life support, etc.
 * @param suffix A suffix for the person's name, such as II, III, etc.
 */
case class Person
(override val sup: IdentifiedObject,
val electronicAddress: String,
val firstName: String,
val landlinePhone: String,
val lastName: String,
val mName: String,
val mobilePhone: String,
val prefix: String,
val specialNeed: String,
val suffix: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Person]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Person
extends
    Parseable[Person]
{
    val sup = IdentifiedObject.parse _
    val electronicAddress = parse_attribute (attribute ("""Person.electronicAddress"""))_
    val firstName = parse_element (element ("""Person.firstName"""))_
    val landlinePhone = parse_attribute (attribute ("""Person.landlinePhone"""))_
    val lastName = parse_element (element ("""Person.lastName"""))_
    val mName = parse_element (element ("""Person.mName"""))_
    val mobilePhone = parse_attribute (attribute ("""Person.mobilePhone"""))_
    val prefix = parse_element (element ("""Person.prefix"""))_
    val specialNeed = parse_element (element ("""Person.specialNeed"""))_
    val suffix = parse_element (element ("""Person.suffix"""))_
    def parse (context: Context): Person =
    {
        Person(
            sup (context),
            electronicAddress (context),
            firstName (context),
            landlinePhone (context),
            lastName (context),
            mName (context),
            mobilePhone (context),
            prefix (context),
            specialNeed (context),
            suffix (context)
        )
    }
}

case class PersonRole
(override val sup: IdentifiedObject,
val Appointments: List[String],
val Person: String
)
extends
    Element
{
    def this () = { this (null, List(), null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[PersonRole]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PersonRole
extends
    Parseable[PersonRole]
{
    val sup = IdentifiedObject.parse _
    val Appointments = parse_attributes (attribute ("""PersonRole.Appointments"""))_
    val Person = parse_attribute (attribute ("""PersonRole.Person"""))_
    def parse (context: Context): PersonRole =
    {
        PersonRole(
            sup (context),
            Appointments (context),
            Person (context)
        )
    }
}

/**
 * Set of spatial coordinates that determine a point, defined in the coordinate system specified in 'Location.
 * CoordinateSystem'. Use a single position point instance to desribe a point-oriented location. Use a sequence of position points to describe a line-oriented object (physical location of non-point oriented objects like cables or lines), or area of an object (like a substation or a geographical zone - in this case, have first and last position point with the same values).
 * @param sup Reference to the superclass object.
 * @param sequenceNumber Zero-relative sequence number of this point within a series of points.
 * @param xPosition X axis position.
 * @param yPosition Y axis position.
 * @param zPosition (if applicable) Z axis position.
 * @param Location Location described by this position point.
 */
case class PositionPoint
(override val sup: BasicElement,
val sequenceNumber: Int,
val xPosition: String,
val yPosition: String,
val zPosition: String,
val Location: String
)
extends
    Element
{
    def this () = { this (null, 0, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[PositionPoint]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PositionPoint
extends
    Parseable[PositionPoint]
{
    val sup = BasicElement.parse _
    val sequenceNumber = parse_element (element ("""PositionPoint.sequenceNumber"""))_
    val xPosition = parse_element (element ("""PositionPoint.xPosition"""))_
    val yPosition = parse_element (element ("""PositionPoint.yPosition"""))_
    val zPosition = parse_element (element ("""PositionPoint.zPosition"""))_
    val Location = parse_attribute (attribute ("""PositionPoint.Location"""))_
    def parse (context: Context): PositionPoint =
    {
        PositionPoint(
            sup (context),
            toInteger (sequenceNumber (context), context),
            xPosition (context),
            yPosition (context),
            zPosition (context),
            Location (context)
        )
    }
}

/**
 * General purpose postal address information.
 * @param sup Reference to the superclass object.
 * @param poBox Post office box.
 * @param postalCode Postal code for the address.
 * @param streetDetail Street detail.
 * @param townDetail Town detail.
 */
case class PostalAddress
(override val sup: BasicElement,
val poBox: String,
val postalCode: String,
val streetDetail: String,
val townDetail: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[PostalAddress]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PostalAddress
extends
    Parseable[PostalAddress]
{
    val sup = BasicElement.parse _
    val poBox = parse_element (element ("""PostalAddress.poBox"""))_
    val postalCode = parse_element (element ("""PostalAddress.postalCode"""))_
    val streetDetail = parse_attribute (attribute ("""PostalAddress.streetDetail"""))_
    val townDetail = parse_attribute (attribute ("""PostalAddress.townDetail"""))_
    def parse (context: Context): PostalAddress =
    {
        PostalAddress(
            sup (context),
            poBox (context),
            postalCode (context),
            streetDetail (context),
            townDetail (context)
        )
    }
}

/**
 * Priority definition.
 * @param sup Reference to the superclass object.
 * @param justification Justification for 'rank'.
 * @param rank Priority level; usually, lower number means high priority, but the details are provided in 'type'.
 * @param typ Type describing 'rank'; e.g., high, emergency, etc.
 */
case class Priority
(override val sup: BasicElement,
val justification: String,
val rank: Int,
val typ: String
)
extends
    Element
{
    def this () = { this (null, null, 0, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[Priority]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Priority
extends
    Parseable[Priority]
{
    val sup = BasicElement.parse _
    val justification = parse_element (element ("""Priority.justification"""))_
    val rank = parse_element (element ("""Priority.rank"""))_
    val typ = parse_element (element ("""Priority.type"""))_
    def parse (context: Context): Priority =
    {
        Priority(
            sup (context),
            justification (context),
            toInteger (rank (context), context),
            typ (context)
        )
    }
}

/**
 * An event to trigger one or more activities, such as reading a meter, recalculating a bill, requesting work, when generating units must be scheduled for maintenance, when a transformer is scheduled to be refurbished, etc.
 * @param sup Reference to the superclass object.
 * @param duration Duration of the scheduled event, for example, the time to ramp between values.
 * @param status
 * @param typ Type of scheduled event.
 * @param Assets
 * @param ScheduledEventData Specification for this scheduled event.
 */
case class ScheduledEvent
(override val sup: IdentifiedObject,
val duration: Double,
val status: String,
val typ: String,
val Assets: List[String],
val ScheduledEventData: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null, List(), null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ScheduledEvent]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ScheduledEvent
extends
    Parseable[ScheduledEvent]
{
    val sup = IdentifiedObject.parse _
    val duration = parse_element (element ("""ScheduledEvent.duration"""))_
    val status = parse_attribute (attribute ("""ScheduledEvent.status"""))_
    val typ = parse_element (element ("""ScheduledEvent.type"""))_
    val Assets = parse_attributes (attribute ("""ScheduledEvent.Assets"""))_
    val ScheduledEventData = parse_attribute (attribute ("""ScheduledEvent.ScheduledEventData"""))_
    def parse (context: Context): ScheduledEvent =
    {
        ScheduledEvent(
            sup (context),
            toDouble (duration (context), context),
            status (context),
            typ (context),
            Assets (context),
            ScheduledEventData (context)
        )
    }
}

/**
 * Schedule parameters for an activity that is to occur, is occurring, or has completed.
 * @param sup Reference to the superclass object.
 * @param estimatedWindow Estimated date and time for activity execution (with earliest possibility of activity initiation and latest possibility of activity completion).
 * @param requestedWindow Requested date and time interval for activity execution.
 * @param status
 * @param InspectionDataSet
 */
case class ScheduledEventData
(override val sup: BasicElement,
val estimatedWindow: String,
val requestedWindow: String,
val status: String,
val InspectionDataSet: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ScheduledEventData]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ScheduledEventData
extends
    Parseable[ScheduledEventData]
{
    val sup = BasicElement.parse _
    val estimatedWindow = parse_attribute (attribute ("""ScheduledEventData.estimatedWindow"""))_
    val requestedWindow = parse_attribute (attribute ("""ScheduledEventData.requestedWindow"""))_
    val status = parse_attribute (attribute ("""ScheduledEventData.status"""))_
    val InspectionDataSet = parse_attribute (attribute ("""ScheduledEventData.InspectionDataSet"""))_
    def parse (context: Context): ScheduledEventData =
    {
        ScheduledEventData(
            sup (context),
            estimatedWindow (context),
            requestedWindow (context),
            status (context),
            InspectionDataSet (context)
        )
    }
}

/**
 * Current status information relevant to an entity.
 * @param sup Reference to the superclass object.
 * @param dateTime Date and time for which status 'value' applies.
 * @param reason Reason code or explanation for why an object went to the current status 'value'.
 * @param remark Pertinent information regarding the current 'value', as free form text.
 * @param value Status value at 'dateTime'; prior status changes may have been kept in instances of activity records associated with the object to which this status applies.
 */
case class Status
(override val sup: BasicElement,
val dateTime: String,
val reason: String,
val remark: String,
val value: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[Status]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Status
extends
    Parseable[Status]
{
    val sup = BasicElement.parse _
    val dateTime = parse_element (element ("""Status.dateTime"""))_
    val reason = parse_element (element ("""Status.reason"""))_
    val remark = parse_element (element ("""Status.remark"""))_
    val value = parse_element (element ("""Status.value"""))_
    def parse (context: Context): Status =
    {
        Status(
            sup (context),
            dateTime (context),
            reason (context),
            remark (context),
            value (context)
        )
    }
}

/**
 * General purpose street address information.
 * @param sup Reference to the superclass object.
 * @param status Status of this address.
 * @param streetDetail Street detail.
 * @param townDetail Town detail.
 */
case class StreetAddress
(override val sup: BasicElement,
val status: String,
val streetDetail: String,
val townDetail: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[StreetAddress]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object StreetAddress
extends
    Parseable[StreetAddress]
{
    val sup = BasicElement.parse _
    val status = parse_attribute (attribute ("""StreetAddress.status"""))_
    val streetDetail = parse_attribute (attribute ("""StreetAddress.streetDetail"""))_
    val townDetail = parse_attribute (attribute ("""StreetAddress.townDetail"""))_
    def parse (context: Context): StreetAddress =
    {
        StreetAddress(
            sup (context),
            status (context),
            streetDetail (context),
            townDetail (context)
        )
    }
}

/**
 * Street details, in the context of address.
 * @param sup Reference to the superclass object.
 * @param addressGeneral Additional address information, for example a mailstop.
 * @param buildingName (if applicable) In certain cases the physical location of the place of interest does not have a direct point of entry from the street, but may be located inside a larger structure such as a building, complex, office block, apartment, etc.
 * @param code (if applicable) Utilities often make use of external reference systems, such as those of the town-planner's department or surveyor general's mapping system, that allocate global reference codes to streets.
 * @param name Name of the street.
 * @param number Designator of the specific location on the street.
 * @param prefix Prefix to the street name.
 *        For example: North, South, East, West.
 * @param suffix Suffix to the street name.
 *        For example: North, South, East, West.
 * @param suiteNumber Number of the apartment or suite.
 * @param typ Type of street.
 *        Examples include: street, circle, boulevard, avenue, road, drive, etc.
 * @param withinTownLimits True if this street is within the legal geographical boundaries of the specified town (default).
 */
case class StreetDetail
(override val sup: BasicElement,
val addressGeneral: String,
val buildingName: String,
val code: String,
val name: String,
val number: String,
val prefix: String,
val suffix: String,
val suiteNumber: String,
val typ: String,
val withinTownLimits: Boolean
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, false) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[StreetDetail]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object StreetDetail
extends
    Parseable[StreetDetail]
{
    val sup = BasicElement.parse _
    val addressGeneral = parse_element (element ("""StreetDetail.addressGeneral"""))_
    val buildingName = parse_element (element ("""StreetDetail.buildingName"""))_
    val code = parse_element (element ("""StreetDetail.code"""))_
    val name = parse_element (element ("""StreetDetail.name"""))_
    val number = parse_element (element ("""StreetDetail.number"""))_
    val prefix = parse_element (element ("""StreetDetail.prefix"""))_
    val suffix = parse_element (element ("""StreetDetail.suffix"""))_
    val suiteNumber = parse_element (element ("""StreetDetail.suiteNumber"""))_
    val typ = parse_element (element ("""StreetDetail.type"""))_
    val withinTownLimits = parse_element (element ("""StreetDetail.withinTownLimits"""))_
    def parse (context: Context): StreetDetail =
    {
        StreetDetail(
            sup (context),
            addressGeneral (context),
            buildingName (context),
            code (context),
            name (context),
            number (context),
            prefix (context),
            suffix (context),
            suiteNumber (context),
            typ (context),
            toBoolean (withinTownLimits (context), context)
        )
    }
}

/**
 * Telephone number.
 * @param sup Reference to the superclass object.
 * @param areaCode Area or region code.
 * @param cityCode (if applicable) City code.
 * @param countryCode Country code.
 * @param extension (if applicable) Extension for this telephone number.
 * @param localNumber Main (local) part of this telephone number.
 */
case class TelephoneNumber
(override val sup: BasicElement,
val areaCode: String,
val cityCode: String,
val countryCode: String,
val extension: String,
val localNumber: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[TelephoneNumber]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TelephoneNumber
extends
    Parseable[TelephoneNumber]
{
    val sup = BasicElement.parse _
    val areaCode = parse_element (element ("""TelephoneNumber.areaCode"""))_
    val cityCode = parse_element (element ("""TelephoneNumber.cityCode"""))_
    val countryCode = parse_element (element ("""TelephoneNumber.countryCode"""))_
    val extension = parse_element (element ("""TelephoneNumber.extension"""))_
    val localNumber = parse_element (element ("""TelephoneNumber.localNumber"""))_
    def parse (context: Context): TelephoneNumber =
    {
        TelephoneNumber(
            sup (context),
            areaCode (context),
            cityCode (context),
            countryCode (context),
            extension (context),
            localNumber (context)
        )
    }
}

/**
 * A point in time within a sequence of points in time relative to a time schedule.
 * @param sup Reference to the superclass object.
 * @param dateTime Absolute date and time for this time point.
 *        For calendar-based time point, it is typically manually entered, while for interval-based or sequence-based time point it is derived.
 * @param relativeTimeInterval (if interval-based) A point in time relative to scheduled start time in 'TimeSchedule.scheduleInterval.start'.
 * @param sequenceNumber (if sequence-based) Relative sequence number for this time point.
 * @param status Status of this time point.
 * @param window Interval defining the window of time that this time point is valid (for example, seasonal, only on weekends, not on weekends, only 8:00 am to 5:00 pm, etc.).
 * @param TimeSchedule Time schedule owning this time point.
 */
case class TimePoint
(override val sup: IdentifiedObject,
val dateTime: String,
val relativeTimeInterval: Double,
val sequenceNumber: Int,
val status: String,
val window: String,
val TimeSchedule: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, 0, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[TimePoint]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TimePoint
extends
    Parseable[TimePoint]
{
    val sup = IdentifiedObject.parse _
    val dateTime = parse_element (element ("""TimePoint.dateTime"""))_
    val relativeTimeInterval = parse_element (element ("""TimePoint.relativeTimeInterval"""))_
    val sequenceNumber = parse_element (element ("""TimePoint.sequenceNumber"""))_
    val status = parse_attribute (attribute ("""TimePoint.status"""))_
    val window = parse_attribute (attribute ("""TimePoint.window"""))_
    val TimeSchedule = parse_attribute (attribute ("""TimePoint.TimeSchedule"""))_
    def parse (context: Context): TimePoint =
    {
        TimePoint(
            sup (context),
            dateTime (context),
            toDouble (relativeTimeInterval (context), context),
            toInteger (sequenceNumber (context), context),
            status (context),
            window (context),
            TimeSchedule (context)
        )
    }
}

/**
 * Description of anything that changes through time.
 * Time schedule is used to perform a single-valued function of time. Use inherited 'type' attribute to give additional information on this schedule, such as: periodic (hourly, daily, weekly, monthly, etc.), day of the month, by date, calendar (specific times and dates).
 * @param sup Reference to the superclass object.
 * @param disabled True if this schedule is deactivated (disabled).
 * @param offset The offset from midnight (i.e., 0 h, 0 min, 0 s) for the periodic time points to begin.
 *        For example, for an interval meter that is set up for five minute intervals ('recurrencePeriod'=300=5 min), setting 'offset'=120=2 min would result in scheduled events to read the meter executing at 2 min, 7 min, 12 min, 17 min, 22 min, 27 min, 32 min, 37 min, 42 min, 47 min, 52 min, and 57 min past each hour.
 * @param recurrencePattern Interval at which the scheduled action repeats (e.g., first Monday of every month, last day of the month, etc.).
 * @param recurrencePeriod Duration between time points, from the beginning of one period to the beginning of the next period.
 *        Note that a device like a meter may have multiple interval periods (e.g., 1 min, 5 min, 15 min, 30 min, or 60 min).
 * @param scheduleInterval Schedule date and time interval.
 */
case class TimeSchedule
(override val sup: Document,
val disabled: Boolean,
val offset: Double,
val recurrencePattern: String,
val recurrencePeriod: Double,
val scheduleInterval: String
)
extends
    Element
{
    def this () = { this (null, false, 0.0, null, 0.0, null) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { return (clone ().asInstanceOf[TimeSchedule]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TimeSchedule
extends
    Parseable[TimeSchedule]
{
    val sup = Document.parse _
    val disabled = parse_element (element ("""TimeSchedule.disabled"""))_
    val offset = parse_element (element ("""TimeSchedule.offset"""))_
    val recurrencePattern = parse_element (element ("""TimeSchedule.recurrencePattern"""))_
    val recurrencePeriod = parse_element (element ("""TimeSchedule.recurrencePeriod"""))_
    val scheduleInterval = parse_attribute (attribute ("""TimeSchedule.scheduleInterval"""))_
    def parse (context: Context): TimeSchedule =
    {
        TimeSchedule(
            sup (context),
            toBoolean (disabled (context), context),
            toDouble (offset (context), context),
            recurrencePattern (context),
            toDouble (recurrencePeriod (context), context),
            scheduleInterval (context)
        )
    }
}

/**
 * Town details, in the context of address.
 * @param sup Reference to the superclass object.
 * @param code Town code.
 * @param country Name of the country.
 * @param name Town name.
 * @param section Town section.
 *        For example, it is common for there to be 36 sections per township.
 * @param stateOrProvince Name of the state or province.
 */
case class TownDetail
(override val sup: BasicElement,
val code: String,
val country: String,
val name: String,
val section: String,
val stateOrProvince: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[TownDetail]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TownDetail
extends
    Parseable[TownDetail]
{
    val sup = BasicElement.parse _
    val code = parse_element (element ("""TownDetail.code"""))_
    val country = parse_element (element ("""TownDetail.country"""))_
    val name = parse_element (element ("""TownDetail.name"""))_
    val section = parse_element (element ("""TownDetail.section"""))_
    val stateOrProvince = parse_element (element ("""TownDetail.stateOrProvince"""))_
    def parse (context: Context): TownDetail =
    {
        TownDetail(
            sup (context),
            code (context),
            country (context),
            name (context),
            section (context),
            stateOrProvince (context)
        )
    }
}

/**
 * Generic name-value pair class, with optional sequence number and units for value; can be used to model parts of information exchange when concrete types are not known in advance.
 * @param sup Reference to the superclass object.
 * @param name Name of an attribute.
 * @param sequenceNumber Sequence number for this attribute in a list of attributes.
 * @param value Value of an attribute, including unit information.
 * @param ProcedureDataSets
 * @param PropertySpecification
 * @param RatingSpecification
 * @param Transaction Transaction for which this snapshot has been recorded.
 */
case class UserAttribute
(override val sup: BasicElement,
val name: String,
val sequenceNumber: Int,
val value: String,
val ProcedureDataSets: List[String],
val PropertySpecification: String,
val RatingSpecification: String,
val Transaction: String
)
extends
    Element
{
    def this () = { this (null, null, 0, null, List(), null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[UserAttribute]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object UserAttribute
extends
    Parseable[UserAttribute]
{
    val sup = BasicElement.parse _
    val name = parse_element (element ("""UserAttribute.name"""))_
    val sequenceNumber = parse_element (element ("""UserAttribute.sequenceNumber"""))_
    val value = parse_attribute (attribute ("""UserAttribute.value"""))_
    val ProcedureDataSets = parse_attributes (attribute ("""UserAttribute.ProcedureDataSets"""))_
    val PropertySpecification = parse_attribute (attribute ("""UserAttribute.PropertySpecification"""))_
    val RatingSpecification = parse_attribute (attribute ("""UserAttribute.RatingSpecification"""))_
    val Transaction = parse_attribute (attribute ("""UserAttribute.Transaction"""))_
    def parse (context: Context): UserAttribute =
    {
        UserAttribute(
            sup (context),
            name (context),
            toInteger (sequenceNumber (context), context),
            value (context),
            ProcedureDataSets (context),
            PropertySpecification (context),
            RatingSpecification (context),
            Transaction (context)
        )
    }
}

object _Common
{
    def register: Unit =
    {
        ActivityRecord.register
        Agreement.register
        Appointment.register
        ConfigurationEvent.register
        CoordinateSystem.register
        Crew.register
        CrewMember.register
        CrewType.register
        Document.register
        ElectronicAddress.register
        Hazard.register
        Location.register
        OperationPersonRole.register
        Operator.register
        Organisation.register
        OrganisationRole.register
        Ownership.register
        Person.register
        PersonRole.register
        PositionPoint.register
        PostalAddress.register
        Priority.register
        ScheduledEvent.register
        ScheduledEventData.register
        Status.register
        StreetAddress.register
        StreetDetail.register
        TelephoneNumber.register
        TimePoint.register
        TimeSchedule.register
        TownDetail.register
        UserAttribute.register
    }
}