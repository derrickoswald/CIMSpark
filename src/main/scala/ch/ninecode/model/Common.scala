package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

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
(
    override val sup: IdentifiedObject,
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
    override def copy (): Row = { clone ().asInstanceOf[ActivityRecord] }
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
        (if (null != createdDateTime) "\t\t<cim:ActivityRecord.createdDateTime>" + createdDateTime + "</cim:ActivityRecord.createdDateTime>\n" else "") +
        (if (null != reason) "\t\t<cim:ActivityRecord.reason>" + reason + "</cim:ActivityRecord.reason>\n" else "") +
        (if (null != severity) "\t\t<cim:ActivityRecord.severity>" + severity + "</cim:ActivityRecord.severity>\n" else "") +
        (if (null != status) "\t\t<cim:ActivityRecord.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != typ) "\t\t<cim:ActivityRecord.type>" + typ + "</cim:ActivityRecord.type>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ActivityRecord rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ActivityRecord>\n"
    }
}

object ActivityRecord
extends
    Parseable[ActivityRecord]
{
    val createdDateTime = parse_element (element ("""ActivityRecord.createdDateTime"""))
    val reason = parse_element (element ("""ActivityRecord.reason"""))
    val severity = parse_element (element ("""ActivityRecord.severity"""))
    val status = parse_attribute (attribute ("""ActivityRecord.status"""))
    val typ = parse_element (element ("""ActivityRecord.type"""))
    def parse (context: Context): ActivityRecord =
    {
        ActivityRecord(
            IdentifiedObject.parse (context),
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
(
    override val sup: Document,
    val signDate: String,
    val validityInterval: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[Agreement] }
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
        (if (null != signDate) "\t\t<cim:Agreement.signDate>" + signDate + "</cim:Agreement.signDate>\n" else "") +
        (if (null != validityInterval) "\t\t<cim:Agreement.validityInterval rdf:resource=\"#" + validityInterval + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Agreement rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Agreement>\n"
    }
}

object Agreement
extends
    Parseable[Agreement]
{
    val signDate = parse_element (element ("""Agreement.signDate"""))
    val validityInterval = parse_attribute (attribute ("""Agreement.validityInterval"""))
    def parse (context: Context): Agreement =
    {
        Agreement(
            Document.parse (context),
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
(
    override val sup: IdentifiedObject,
    val callAhead: Boolean,
    val meetingInterval: String,
    val Works: List[String]
)
extends
    Element
{
    def this () = { this (null, false, null, List()) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Appointment] }
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
        "\t\t<cim:Appointment.callAhead>" + callAhead + "</cim:Appointment.callAhead>\n" +
        (if (null != meetingInterval) "\t\t<cim:Appointment.meetingInterval rdf:resource=\"#" + meetingInterval + "\"/>\n" else "") +
        (if (null != Works) Works.map (x => "\t\t<cim:Appointment.Works rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:Appointment rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Appointment>\n"
    }
}

object Appointment
extends
    Parseable[Appointment]
{
    val callAhead = parse_element (element ("""Appointment.callAhead"""))
    val meetingInterval = parse_attribute (attribute ("""Appointment.meetingInterval"""))
    val Works = parse_attributes (attribute ("""Appointment.Works"""))
    def parse (context: Context): Appointment =
    {
        Appointment(
            IdentifiedObject.parse (context),
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
(
    override val sup: ActivityRecord,
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
    override def copy (): Row = { clone ().asInstanceOf[ConfigurationEvent] }
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
        (if (null != effectiveDateTime) "\t\t<cim:ConfigurationEvent.effectiveDateTime>" + effectiveDateTime + "</cim:ConfigurationEvent.effectiveDateTime>\n" else "") +
        (if (null != modifiedBy) "\t\t<cim:ConfigurationEvent.modifiedBy>" + modifiedBy + "</cim:ConfigurationEvent.modifiedBy>\n" else "") +
        (if (null != remark) "\t\t<cim:ConfigurationEvent.remark>" + remark + "</cim:ConfigurationEvent.remark>\n" else "") +
        (if (null != ChangedAsset) "\t\t<cim:ConfigurationEvent.ChangedAsset rdf:resource=\"#" + ChangedAsset + "\"/>\n" else "") +
        (if (null != ChangedDocument) "\t\t<cim:ConfigurationEvent.ChangedDocument rdf:resource=\"#" + ChangedDocument + "\"/>\n" else "") +
        (if (null != ChangedLocation) "\t\t<cim:ConfigurationEvent.ChangedLocation rdf:resource=\"#" + ChangedLocation + "\"/>\n" else "") +
        (if (null != ChangedOrganisationRole) "\t\t<cim:ConfigurationEvent.ChangedOrganisationRole rdf:resource=\"#" + ChangedOrganisationRole + "\"/>\n" else "") +
        (if (null != ChangedPersonRole) "\t\t<cim:ConfigurationEvent.ChangedPersonRole rdf:resource=\"#" + ChangedPersonRole + "\"/>\n" else "") +
        (if (null != ChangedServiceCategory) "\t\t<cim:ConfigurationEvent.ChangedServiceCategory rdf:resource=\"#" + ChangedServiceCategory + "\"/>\n" else "") +
        (if (null != ChangedUsagePoint) "\t\t<cim:ConfigurationEvent.ChangedUsagePoint rdf:resource=\"#" + ChangedUsagePoint + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ConfigurationEvent rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ConfigurationEvent>\n"
    }
}

object ConfigurationEvent
extends
    Parseable[ConfigurationEvent]
{
    val effectiveDateTime = parse_element (element ("""ConfigurationEvent.effectiveDateTime"""))
    val modifiedBy = parse_element (element ("""ConfigurationEvent.modifiedBy"""))
    val remark = parse_element (element ("""ConfigurationEvent.remark"""))
    val ChangedAsset = parse_attribute (attribute ("""ConfigurationEvent.ChangedAsset"""))
    val ChangedDocument = parse_attribute (attribute ("""ConfigurationEvent.ChangedDocument"""))
    val ChangedLocation = parse_attribute (attribute ("""ConfigurationEvent.ChangedLocation"""))
    val ChangedOrganisationRole = parse_attribute (attribute ("""ConfigurationEvent.ChangedOrganisationRole"""))
    val ChangedPersonRole = parse_attribute (attribute ("""ConfigurationEvent.ChangedPersonRole"""))
    val ChangedServiceCategory = parse_attribute (attribute ("""ConfigurationEvent.ChangedServiceCategory"""))
    val ChangedUsagePoint = parse_attribute (attribute ("""ConfigurationEvent.ChangedUsagePoint"""))
    def parse (context: Context): ConfigurationEvent =
    {
        ConfigurationEvent(
            ActivityRecord.parse (context),
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
(
    override val sup: IdentifiedObject,
    val crsUrn: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[CoordinateSystem] }
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
        (if (null != crsUrn) "\t\t<cim:CoordinateSystem.crsUrn>" + crsUrn + "</cim:CoordinateSystem.crsUrn>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:CoordinateSystem rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CoordinateSystem>\n"
    }
}

object CoordinateSystem
extends
    Parseable[CoordinateSystem]
{
    val crsUrn = parse_element (element ("""CoordinateSystem.crsUrn"""))
    def parse (context: Context): CoordinateSystem =
    {
        CoordinateSystem(
            IdentifiedObject.parse (context),
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
(
    override val sup: IdentifiedObject,
    val status: String,
    val CrewType: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Crew] }
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
        (if (null != status) "\t\t<cim:Crew.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != CrewType) "\t\t<cim:Crew.CrewType rdf:resource=\"#" + CrewType + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Crew rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Crew>\n"
    }
}

object Crew
extends
    Parseable[Crew]
{
    val status = parse_attribute (attribute ("""Crew.status"""))
    val CrewType = parse_attribute (attribute ("""Crew.CrewType"""))
    def parse (context: Context): Crew =
    {
        Crew(
            IdentifiedObject.parse (context),
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
(
    override val sup: OperationPersonRole,
    val Crew: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def OperationPersonRole: OperationPersonRole = sup.asInstanceOf[OperationPersonRole]
    override def copy (): Row = { clone ().asInstanceOf[CrewMember] }
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
        (if (null != Crew) "\t\t<cim:CrewMember.Crew rdf:resource=\"#" + Crew + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:CrewMember rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CrewMember>\n"
    }
}

object CrewMember
extends
    Parseable[CrewMember]
{
    val Crew = parse_attribute (attribute ("""CrewMember.Crew"""))
    def parse (context: Context): CrewMember =
    {
        CrewMember(
            OperationPersonRole.parse (context),
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
(
    override val sup: IdentifiedObject
)
extends
    Element
{
    def this () = { this (null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[CrewType] }
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
        ""
    }
    override def export: String =
    {
        "\t<cim:CrewType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CrewType>\n"
    }
}

object CrewType
extends
    Parseable[CrewType]
{
    def parse (context: Context): CrewType =
    {
        CrewType(
            IdentifiedObject.parse (context)
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
(
    override val sup: IdentifiedObject,
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
    override def copy (): Row = { clone ().asInstanceOf[Document] }
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
        (if (null != authorName) "\t\t<cim:Document.authorName>" + authorName + "</cim:Document.authorName>\n" else "") +
        (if (null != comment) "\t\t<cim:Document.comment>" + comment + "</cim:Document.comment>\n" else "") +
        (if (null != createdDateTime) "\t\t<cim:Document.createdDateTime>" + createdDateTime + "</cim:Document.createdDateTime>\n" else "") +
        (if (null != docStatus) "\t\t<cim:Document.docStatus rdf:resource=\"#" + docStatus + "\"/>\n" else "") +
        (if (null != electronicAddress) "\t\t<cim:Document.electronicAddress rdf:resource=\"#" + electronicAddress + "\"/>\n" else "") +
        (if (null != lastModifiedDateTime) "\t\t<cim:Document.lastModifiedDateTime>" + lastModifiedDateTime + "</cim:Document.lastModifiedDateTime>\n" else "") +
        (if (null != revisionNumber) "\t\t<cim:Document.revisionNumber>" + revisionNumber + "</cim:Document.revisionNumber>\n" else "") +
        (if (null != status) "\t\t<cim:Document.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != subject) "\t\t<cim:Document.subject>" + subject + "</cim:Document.subject>\n" else "") +
        (if (null != title) "\t\t<cim:Document.title>" + title + "</cim:Document.title>\n" else "") +
        (if (null != typ) "\t\t<cim:Document.type>" + typ + "</cim:Document.type>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Document rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Document>\n"
    }
}

object Document
extends
    Parseable[Document]
{
    val authorName = parse_element (element ("""Document.authorName"""))
    val comment = parse_element (element ("""Document.comment"""))
    val createdDateTime = parse_element (element ("""Document.createdDateTime"""))
    val docStatus = parse_attribute (attribute ("""Document.docStatus"""))
    val electronicAddress = parse_attribute (attribute ("""Document.electronicAddress"""))
    val lastModifiedDateTime = parse_element (element ("""Document.lastModifiedDateTime"""))
    val revisionNumber = parse_element (element ("""Document.revisionNumber"""))
    val status = parse_attribute (attribute ("""Document.status"""))
    val subject = parse_element (element ("""Document.subject"""))
    val title = parse_element (element ("""Document.title"""))
    val typ = parse_element (element ("""Document.type"""))
    def parse (context: Context): Document =
    {
        Document(
            IdentifiedObject.parse (context),
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
(
    override val sup: BasicElement,
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
    override def copy (): Row = { clone ().asInstanceOf[ElectronicAddress] }
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
        (if (null != email1) "\t\t<cim:ElectronicAddress.email1>" + email1 + "</cim:ElectronicAddress.email1>\n" else "") +
        (if (null != email2) "\t\t<cim:ElectronicAddress.email2>" + email2 + "</cim:ElectronicAddress.email2>\n" else "") +
        (if (null != lan) "\t\t<cim:ElectronicAddress.lan>" + lan + "</cim:ElectronicAddress.lan>\n" else "") +
        (if (null != mac) "\t\t<cim:ElectronicAddress.mac>" + mac + "</cim:ElectronicAddress.mac>\n" else "") +
        (if (null != password) "\t\t<cim:ElectronicAddress.password>" + password + "</cim:ElectronicAddress.password>\n" else "") +
        (if (null != radio) "\t\t<cim:ElectronicAddress.radio>" + radio + "</cim:ElectronicAddress.radio>\n" else "") +
        (if (null != userID) "\t\t<cim:ElectronicAddress.userID>" + userID + "</cim:ElectronicAddress.userID>\n" else "") +
        (if (null != web) "\t\t<cim:ElectronicAddress.web>" + web + "</cim:ElectronicAddress.web>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ElectronicAddress rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ElectronicAddress>\n"
    }
}

object ElectronicAddress
extends
    Parseable[ElectronicAddress]
{
    val email1 = parse_element (element ("""ElectronicAddress.email1"""))
    val email2 = parse_element (element ("""ElectronicAddress.email2"""))
    val lan = parse_element (element ("""ElectronicAddress.lan"""))
    val mac = parse_element (element ("""ElectronicAddress.mac"""))
    val password = parse_element (element ("""ElectronicAddress.password"""))
    val radio = parse_element (element ("""ElectronicAddress.radio"""))
    val userID = parse_element (element ("""ElectronicAddress.userID"""))
    val web = parse_element (element ("""ElectronicAddress.web"""))
    def parse (context: Context): ElectronicAddress =
    {
        ElectronicAddress(
            BasicElement.parse (context),
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
(
    override val sup: IdentifiedObject,
    val status: String,
    val typ: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Hazard] }
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
        (if (null != status) "\t\t<cim:Hazard.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != typ) "\t\t<cim:Hazard.type>" + typ + "</cim:Hazard.type>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Hazard rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Hazard>\n"
    }
}

object Hazard
extends
    Parseable[Hazard]
{
    val status = parse_attribute (attribute ("""Hazard.status"""))
    val typ = parse_element (element ("""Hazard.type"""))
    def parse (context: Context): Hazard =
    {
        Hazard(
            IdentifiedObject.parse (context),
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
(
    override val sup: IdentifiedObject,
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
    override def copy (): Row = { clone ().asInstanceOf[Location] }
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
        (if (null != direction) "\t\t<cim:Location.direction>" + direction + "</cim:Location.direction>\n" else "") +
        (if (null != electronicAddress) "\t\t<cim:Location.electronicAddress rdf:resource=\"#" + electronicAddress + "\"/>\n" else "") +
        (if (null != geoInfoReference) "\t\t<cim:Location.geoInfoReference>" + geoInfoReference + "</cim:Location.geoInfoReference>\n" else "") +
        (if (null != mainAddress) "\t\t<cim:Location.mainAddress rdf:resource=\"#" + mainAddress + "\"/>\n" else "") +
        (if (null != phone1) "\t\t<cim:Location.phone1 rdf:resource=\"#" + phone1 + "\"/>\n" else "") +
        (if (null != phone2) "\t\t<cim:Location.phone2 rdf:resource=\"#" + phone2 + "\"/>\n" else "") +
        (if (null != secondaryAddress) "\t\t<cim:Location.secondaryAddress rdf:resource=\"#" + secondaryAddress + "\"/>\n" else "") +
        (if (null != status) "\t\t<cim:Location.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != typ) "\t\t<cim:Location.type>" + typ + "</cim:Location.type>\n" else "") +
        (if (null != CoordinateSystem) "\t\t<cim:Location.CoordinateSystem rdf:resource=\"#" + CoordinateSystem + "\"/>\n" else "") +
        (if (null != Measurements) Measurements.map (x => "\t\t<cim:Location.Measurements rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:Location rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Location>\n"
    }
}

object Location
extends
    Parseable[Location]
{
    val direction = parse_element (element ("""Location.direction"""))
    val electronicAddress = parse_attribute (attribute ("""Location.electronicAddress"""))
    val geoInfoReference = parse_element (element ("""Location.geoInfoReference"""))
    val mainAddress = parse_attribute (attribute ("""Location.mainAddress"""))
    val phone1 = parse_attribute (attribute ("""Location.phone1"""))
    val phone2 = parse_attribute (attribute ("""Location.phone2"""))
    val secondaryAddress = parse_attribute (attribute ("""Location.secondaryAddress"""))
    val status = parse_attribute (attribute ("""Location.status"""))
    val typ = parse_element (element ("""Location.type"""))
    val CoordinateSystem = parse_attribute (attribute ("""Location.CoordinateSystem"""))
    val Measurements = parse_attributes (attribute ("""Location.Measurements"""))
    def parse (context: Context): Location =
    {
        Location(
            IdentifiedObject.parse (context),
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
(
    override val sup: PersonRole
)
extends
    Element
{
    def this () = { this (null) }
    def PersonRole: PersonRole = sup.asInstanceOf[PersonRole]
    override def copy (): Row = { clone ().asInstanceOf[OperationPersonRole] }
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
        ""
    }
    override def export: String =
    {
        "\t<cim:OperationPersonRole rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:OperationPersonRole>\n"
    }
}

object OperationPersonRole
extends
    Parseable[OperationPersonRole]
{
    def parse (context: Context): OperationPersonRole =
    {
        OperationPersonRole(
            PersonRole.parse (context)
        )
    }
}

/**
 * Control room operator.
 * @param sup Reference to the superclass object.
 */
case class Operator
(
    override val sup: OperationPersonRole
)
extends
    Element
{
    def this () = { this (null) }
    def OperationPersonRole: OperationPersonRole = sup.asInstanceOf[OperationPersonRole]
    override def copy (): Row = { clone ().asInstanceOf[Operator] }
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
        ""
    }
    override def export: String =
    {
        "\t<cim:Operator rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Operator>\n"
    }
}

object Operator
extends
    Parseable[Operator]
{
    def parse (context: Context): Operator =
    {
        Operator(
            OperationPersonRole.parse (context)
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
(
    override val sup: IdentifiedObject,
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
    override def copy (): Row = { clone ().asInstanceOf[Organisation] }
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
        (if (null != electronicAddress) "\t\t<cim:Organisation.electronicAddress rdf:resource=\"#" + electronicAddress + "\"/>\n" else "") +
        (if (null != phone1) "\t\t<cim:Organisation.phone1 rdf:resource=\"#" + phone1 + "\"/>\n" else "") +
        (if (null != phone2) "\t\t<cim:Organisation.phone2 rdf:resource=\"#" + phone2 + "\"/>\n" else "") +
        (if (null != postalAddress) "\t\t<cim:Organisation.postalAddress rdf:resource=\"#" + postalAddress + "\"/>\n" else "") +
        (if (null != streetAddress) "\t\t<cim:Organisation.streetAddress rdf:resource=\"#" + streetAddress + "\"/>\n" else "") +
        (if (null != ActivityRecords) ActivityRecords.map (x => "\t\t<cim:Organisation.ActivityRecords rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:Organisation rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Organisation>\n"
    }
}

object Organisation
extends
    Parseable[Organisation]
{
    val electronicAddress = parse_attribute (attribute ("""Organisation.electronicAddress"""))
    val phone1 = parse_attribute (attribute ("""Organisation.phone1"""))
    val phone2 = parse_attribute (attribute ("""Organisation.phone2"""))
    val postalAddress = parse_attribute (attribute ("""Organisation.postalAddress"""))
    val streetAddress = parse_attribute (attribute ("""Organisation.streetAddress"""))
    val ActivityRecords = parse_attributes (attribute ("""Organisation.ActivityRecords"""))
    def parse (context: Context): Organisation =
    {
        Organisation(
            IdentifiedObject.parse (context),
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
(
    override val sup: IdentifiedObject,
    val Organisation: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[OrganisationRole] }
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
        (if (null != Organisation) "\t\t<cim:OrganisationRole.Organisation rdf:resource=\"#" + Organisation + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:OrganisationRole rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:OrganisationRole>\n"
    }
}

object OrganisationRole
extends
    Parseable[OrganisationRole]
{
    val Organisation = parse_attribute (attribute ("""OrganisationRole.Organisation"""))
    def parse (context: Context): OrganisationRole =
    {
        OrganisationRole(
            IdentifiedObject.parse (context),
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
(
    override val sup: IdentifiedObject,
    val share: Double,
    val Asset: String,
    val AssetOwner: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Ownership] }
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
        "\t\t<cim:Ownership.share>" + share + "</cim:Ownership.share>\n" +
        (if (null != Asset) "\t\t<cim:Ownership.Asset rdf:resource=\"#" + Asset + "\"/>\n" else "") +
        (if (null != AssetOwner) "\t\t<cim:Ownership.AssetOwner rdf:resource=\"#" + AssetOwner + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Ownership rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Ownership>\n"
    }
}

object Ownership
extends
    Parseable[Ownership]
{
    val share = parse_element (element ("""Ownership.share"""))
    val Asset = parse_attribute (attribute ("""Ownership.Asset"""))
    val AssetOwner = parse_attribute (attribute ("""Ownership.AssetOwner"""))
    def parse (context: Context): Ownership =
    {
        Ownership(
            IdentifiedObject.parse (context),
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
(
    override val sup: IdentifiedObject,
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
    override def copy (): Row = { clone ().asInstanceOf[Person] }
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
        (if (null != electronicAddress) "\t\t<cim:Person.electronicAddress rdf:resource=\"#" + electronicAddress + "\"/>\n" else "") +
        (if (null != firstName) "\t\t<cim:Person.firstName>" + firstName + "</cim:Person.firstName>\n" else "") +
        (if (null != landlinePhone) "\t\t<cim:Person.landlinePhone rdf:resource=\"#" + landlinePhone + "\"/>\n" else "") +
        (if (null != lastName) "\t\t<cim:Person.lastName>" + lastName + "</cim:Person.lastName>\n" else "") +
        (if (null != mName) "\t\t<cim:Person.mName>" + mName + "</cim:Person.mName>\n" else "") +
        (if (null != mobilePhone) "\t\t<cim:Person.mobilePhone rdf:resource=\"#" + mobilePhone + "\"/>\n" else "") +
        (if (null != prefix) "\t\t<cim:Person.prefix>" + prefix + "</cim:Person.prefix>\n" else "") +
        (if (null != specialNeed) "\t\t<cim:Person.specialNeed>" + specialNeed + "</cim:Person.specialNeed>\n" else "") +
        (if (null != suffix) "\t\t<cim:Person.suffix>" + suffix + "</cim:Person.suffix>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Person rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Person>\n"
    }
}

object Person
extends
    Parseable[Person]
{
    val electronicAddress = parse_attribute (attribute ("""Person.electronicAddress"""))
    val firstName = parse_element (element ("""Person.firstName"""))
    val landlinePhone = parse_attribute (attribute ("""Person.landlinePhone"""))
    val lastName = parse_element (element ("""Person.lastName"""))
    val mName = parse_element (element ("""Person.mName"""))
    val mobilePhone = parse_attribute (attribute ("""Person.mobilePhone"""))
    val prefix = parse_element (element ("""Person.prefix"""))
    val specialNeed = parse_element (element ("""Person.specialNeed"""))
    val suffix = parse_element (element ("""Person.suffix"""))
    def parse (context: Context): Person =
    {
        Person(
            IdentifiedObject.parse (context),
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
(
    override val sup: IdentifiedObject,
    val Appointments: List[String],
    val Person: String
)
extends
    Element
{
    def this () = { this (null, List(), null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[PersonRole] }
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
        (if (null != Appointments) Appointments.map (x => "\t\t<cim:PersonRole.Appointments rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != Person) "\t\t<cim:PersonRole.Person rdf:resource=\"#" + Person + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:PersonRole rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PersonRole>\n"
    }
}

object PersonRole
extends
    Parseable[PersonRole]
{
    val Appointments = parse_attributes (attribute ("""PersonRole.Appointments"""))
    val Person = parse_attribute (attribute ("""PersonRole.Person"""))
    def parse (context: Context): PersonRole =
    {
        PersonRole(
            IdentifiedObject.parse (context),
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
(
    override val sup: BasicElement,
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
    override def copy (): Row = { clone ().asInstanceOf[PositionPoint] }
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
        "\t\t<cim:PositionPoint.sequenceNumber>" + sequenceNumber + "</cim:PositionPoint.sequenceNumber>\n" +
        (if (null != xPosition) "\t\t<cim:PositionPoint.xPosition>" + xPosition + "</cim:PositionPoint.xPosition>\n" else "") +
        (if (null != yPosition) "\t\t<cim:PositionPoint.yPosition>" + yPosition + "</cim:PositionPoint.yPosition>\n" else "") +
        (if (null != zPosition) "\t\t<cim:PositionPoint.zPosition>" + zPosition + "</cim:PositionPoint.zPosition>\n" else "") +
        (if (null != Location) "\t\t<cim:PositionPoint.Location rdf:resource=\"#" + Location + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:PositionPoint rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PositionPoint>\n"
    }
}

object PositionPoint
extends
    Parseable[PositionPoint]
{
    val sequenceNumber = parse_element (element ("""PositionPoint.sequenceNumber"""))
    val xPosition = parse_element (element ("""PositionPoint.xPosition"""))
    val yPosition = parse_element (element ("""PositionPoint.yPosition"""))
    val zPosition = parse_element (element ("""PositionPoint.zPosition"""))
    val Location = parse_attribute (attribute ("""PositionPoint.Location"""))
    def parse (context: Context): PositionPoint =
    {
        PositionPoint(
            BasicElement.parse (context),
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
(
    override val sup: BasicElement,
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
    override def copy (): Row = { clone ().asInstanceOf[PostalAddress] }
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
        (if (null != poBox) "\t\t<cim:PostalAddress.poBox>" + poBox + "</cim:PostalAddress.poBox>\n" else "") +
        (if (null != postalCode) "\t\t<cim:PostalAddress.postalCode>" + postalCode + "</cim:PostalAddress.postalCode>\n" else "") +
        (if (null != streetDetail) "\t\t<cim:PostalAddress.streetDetail rdf:resource=\"#" + streetDetail + "\"/>\n" else "") +
        (if (null != townDetail) "\t\t<cim:PostalAddress.townDetail rdf:resource=\"#" + townDetail + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:PostalAddress rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PostalAddress>\n"
    }
}

object PostalAddress
extends
    Parseable[PostalAddress]
{
    val poBox = parse_element (element ("""PostalAddress.poBox"""))
    val postalCode = parse_element (element ("""PostalAddress.postalCode"""))
    val streetDetail = parse_attribute (attribute ("""PostalAddress.streetDetail"""))
    val townDetail = parse_attribute (attribute ("""PostalAddress.townDetail"""))
    def parse (context: Context): PostalAddress =
    {
        PostalAddress(
            BasicElement.parse (context),
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
(
    override val sup: BasicElement,
    val justification: String,
    val rank: Int,
    val typ: String
)
extends
    Element
{
    def this () = { this (null, null, 0, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[Priority] }
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
        (if (null != justification) "\t\t<cim:Priority.justification>" + justification + "</cim:Priority.justification>\n" else "") +
        "\t\t<cim:Priority.rank>" + rank + "</cim:Priority.rank>\n" +
        (if (null != typ) "\t\t<cim:Priority.type>" + typ + "</cim:Priority.type>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Priority rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Priority>\n"
    }
}

object Priority
extends
    Parseable[Priority]
{
    val justification = parse_element (element ("""Priority.justification"""))
    val rank = parse_element (element ("""Priority.rank"""))
    val typ = parse_element (element ("""Priority.type"""))
    def parse (context: Context): Priority =
    {
        Priority(
            BasicElement.parse (context),
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
(
    override val sup: IdentifiedObject,
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
    override def copy (): Row = { clone ().asInstanceOf[ScheduledEvent] }
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
        "\t\t<cim:ScheduledEvent.duration>" + duration + "</cim:ScheduledEvent.duration>\n" +
        (if (null != status) "\t\t<cim:ScheduledEvent.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != typ) "\t\t<cim:ScheduledEvent.type>" + typ + "</cim:ScheduledEvent.type>\n" else "") +
        (if (null != Assets) Assets.map (x => "\t\t<cim:ScheduledEvent.Assets rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != ScheduledEventData) "\t\t<cim:ScheduledEvent.ScheduledEventData rdf:resource=\"#" + ScheduledEventData + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ScheduledEvent rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ScheduledEvent>\n"
    }
}

object ScheduledEvent
extends
    Parseable[ScheduledEvent]
{
    val duration = parse_element (element ("""ScheduledEvent.duration"""))
    val status = parse_attribute (attribute ("""ScheduledEvent.status"""))
    val typ = parse_element (element ("""ScheduledEvent.type"""))
    val Assets = parse_attributes (attribute ("""ScheduledEvent.Assets"""))
    val ScheduledEventData = parse_attribute (attribute ("""ScheduledEvent.ScheduledEventData"""))
    def parse (context: Context): ScheduledEvent =
    {
        ScheduledEvent(
            IdentifiedObject.parse (context),
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
(
    override val sup: BasicElement,
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
    override def copy (): Row = { clone ().asInstanceOf[ScheduledEventData] }
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
        (if (null != estimatedWindow) "\t\t<cim:ScheduledEventData.estimatedWindow rdf:resource=\"#" + estimatedWindow + "\"/>\n" else "") +
        (if (null != requestedWindow) "\t\t<cim:ScheduledEventData.requestedWindow rdf:resource=\"#" + requestedWindow + "\"/>\n" else "") +
        (if (null != status) "\t\t<cim:ScheduledEventData.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != InspectionDataSet) "\t\t<cim:ScheduledEventData.InspectionDataSet rdf:resource=\"#" + InspectionDataSet + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ScheduledEventData rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ScheduledEventData>\n"
    }
}

object ScheduledEventData
extends
    Parseable[ScheduledEventData]
{
    val estimatedWindow = parse_attribute (attribute ("""ScheduledEventData.estimatedWindow"""))
    val requestedWindow = parse_attribute (attribute ("""ScheduledEventData.requestedWindow"""))
    val status = parse_attribute (attribute ("""ScheduledEventData.status"""))
    val InspectionDataSet = parse_attribute (attribute ("""ScheduledEventData.InspectionDataSet"""))
    def parse (context: Context): ScheduledEventData =
    {
        ScheduledEventData(
            BasicElement.parse (context),
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
(
    override val sup: BasicElement,
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
    override def copy (): Row = { clone ().asInstanceOf[Status] }
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
        (if (null != dateTime) "\t\t<cim:Status.dateTime>" + dateTime + "</cim:Status.dateTime>\n" else "") +
        (if (null != reason) "\t\t<cim:Status.reason>" + reason + "</cim:Status.reason>\n" else "") +
        (if (null != remark) "\t\t<cim:Status.remark>" + remark + "</cim:Status.remark>\n" else "") +
        (if (null != value) "\t\t<cim:Status.value>" + value + "</cim:Status.value>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Status rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Status>\n"
    }
}

object Status
extends
    Parseable[Status]
{
    val dateTime = parse_element (element ("""Status.dateTime"""))
    val reason = parse_element (element ("""Status.reason"""))
    val remark = parse_element (element ("""Status.remark"""))
    val value = parse_element (element ("""Status.value"""))
    def parse (context: Context): Status =
    {
        Status(
            BasicElement.parse (context),
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
(
    override val sup: BasicElement,
    val status: String,
    val streetDetail: String,
    val townDetail: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[StreetAddress] }
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
        (if (null != status) "\t\t<cim:StreetAddress.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != streetDetail) "\t\t<cim:StreetAddress.streetDetail rdf:resource=\"#" + streetDetail + "\"/>\n" else "") +
        (if (null != townDetail) "\t\t<cim:StreetAddress.townDetail rdf:resource=\"#" + townDetail + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:StreetAddress rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:StreetAddress>\n"
    }
}

object StreetAddress
extends
    Parseable[StreetAddress]
{
    val status = parse_attribute (attribute ("""StreetAddress.status"""))
    val streetDetail = parse_attribute (attribute ("""StreetAddress.streetDetail"""))
    val townDetail = parse_attribute (attribute ("""StreetAddress.townDetail"""))
    def parse (context: Context): StreetAddress =
    {
        StreetAddress(
            BasicElement.parse (context),
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
(
    override val sup: BasicElement,
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
    override def copy (): Row = { clone ().asInstanceOf[StreetDetail] }
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
        (if (null != addressGeneral) "\t\t<cim:StreetDetail.addressGeneral>" + addressGeneral + "</cim:StreetDetail.addressGeneral>\n" else "") +
        (if (null != buildingName) "\t\t<cim:StreetDetail.buildingName>" + buildingName + "</cim:StreetDetail.buildingName>\n" else "") +
        (if (null != code) "\t\t<cim:StreetDetail.code>" + code + "</cim:StreetDetail.code>\n" else "") +
        (if (null != name) "\t\t<cim:StreetDetail.name>" + name + "</cim:StreetDetail.name>\n" else "") +
        (if (null != number) "\t\t<cim:StreetDetail.number>" + number + "</cim:StreetDetail.number>\n" else "") +
        (if (null != prefix) "\t\t<cim:StreetDetail.prefix>" + prefix + "</cim:StreetDetail.prefix>\n" else "") +
        (if (null != suffix) "\t\t<cim:StreetDetail.suffix>" + suffix + "</cim:StreetDetail.suffix>\n" else "") +
        (if (null != suiteNumber) "\t\t<cim:StreetDetail.suiteNumber>" + suiteNumber + "</cim:StreetDetail.suiteNumber>\n" else "") +
        (if (null != typ) "\t\t<cim:StreetDetail.type>" + typ + "</cim:StreetDetail.type>\n" else "") +
        "\t\t<cim:StreetDetail.withinTownLimits>" + withinTownLimits + "</cim:StreetDetail.withinTownLimits>\n"
    }
    override def export: String =
    {
        "\t<cim:StreetDetail rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:StreetDetail>\n"
    }
}

object StreetDetail
extends
    Parseable[StreetDetail]
{
    val addressGeneral = parse_element (element ("""StreetDetail.addressGeneral"""))
    val buildingName = parse_element (element ("""StreetDetail.buildingName"""))
    val code = parse_element (element ("""StreetDetail.code"""))
    val name = parse_element (element ("""StreetDetail.name"""))
    val number = parse_element (element ("""StreetDetail.number"""))
    val prefix = parse_element (element ("""StreetDetail.prefix"""))
    val suffix = parse_element (element ("""StreetDetail.suffix"""))
    val suiteNumber = parse_element (element ("""StreetDetail.suiteNumber"""))
    val typ = parse_element (element ("""StreetDetail.type"""))
    val withinTownLimits = parse_element (element ("""StreetDetail.withinTownLimits"""))
    def parse (context: Context): StreetDetail =
    {
        StreetDetail(
            BasicElement.parse (context),
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
(
    override val sup: BasicElement,
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
    override def copy (): Row = { clone ().asInstanceOf[TelephoneNumber] }
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
        (if (null != areaCode) "\t\t<cim:TelephoneNumber.areaCode>" + areaCode + "</cim:TelephoneNumber.areaCode>\n" else "") +
        (if (null != cityCode) "\t\t<cim:TelephoneNumber.cityCode>" + cityCode + "</cim:TelephoneNumber.cityCode>\n" else "") +
        (if (null != countryCode) "\t\t<cim:TelephoneNumber.countryCode>" + countryCode + "</cim:TelephoneNumber.countryCode>\n" else "") +
        (if (null != extension) "\t\t<cim:TelephoneNumber.extension>" + extension + "</cim:TelephoneNumber.extension>\n" else "") +
        (if (null != localNumber) "\t\t<cim:TelephoneNumber.localNumber>" + localNumber + "</cim:TelephoneNumber.localNumber>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TelephoneNumber rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TelephoneNumber>\n"
    }
}

object TelephoneNumber
extends
    Parseable[TelephoneNumber]
{
    val areaCode = parse_element (element ("""TelephoneNumber.areaCode"""))
    val cityCode = parse_element (element ("""TelephoneNumber.cityCode"""))
    val countryCode = parse_element (element ("""TelephoneNumber.countryCode"""))
    val extension = parse_element (element ("""TelephoneNumber.extension"""))
    val localNumber = parse_element (element ("""TelephoneNumber.localNumber"""))
    def parse (context: Context): TelephoneNumber =
    {
        TelephoneNumber(
            BasicElement.parse (context),
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
(
    override val sup: IdentifiedObject,
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
    override def copy (): Row = { clone ().asInstanceOf[TimePoint] }
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
        (if (null != dateTime) "\t\t<cim:TimePoint.dateTime>" + dateTime + "</cim:TimePoint.dateTime>\n" else "") +
        "\t\t<cim:TimePoint.relativeTimeInterval>" + relativeTimeInterval + "</cim:TimePoint.relativeTimeInterval>\n" +
        "\t\t<cim:TimePoint.sequenceNumber>" + sequenceNumber + "</cim:TimePoint.sequenceNumber>\n" +
        (if (null != status) "\t\t<cim:TimePoint.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != window) "\t\t<cim:TimePoint.window rdf:resource=\"#" + window + "\"/>\n" else "") +
        (if (null != TimeSchedule) "\t\t<cim:TimePoint.TimeSchedule rdf:resource=\"#" + TimeSchedule + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TimePoint rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TimePoint>\n"
    }
}

object TimePoint
extends
    Parseable[TimePoint]
{
    val dateTime = parse_element (element ("""TimePoint.dateTime"""))
    val relativeTimeInterval = parse_element (element ("""TimePoint.relativeTimeInterval"""))
    val sequenceNumber = parse_element (element ("""TimePoint.sequenceNumber"""))
    val status = parse_attribute (attribute ("""TimePoint.status"""))
    val window = parse_attribute (attribute ("""TimePoint.window"""))
    val TimeSchedule = parse_attribute (attribute ("""TimePoint.TimeSchedule"""))
    def parse (context: Context): TimePoint =
    {
        TimePoint(
            IdentifiedObject.parse (context),
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
(
    override val sup: Document,
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
    override def copy (): Row = { clone ().asInstanceOf[TimeSchedule] }
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
        "\t\t<cim:TimeSchedule.disabled>" + disabled + "</cim:TimeSchedule.disabled>\n" +
        "\t\t<cim:TimeSchedule.offset>" + offset + "</cim:TimeSchedule.offset>\n" +
        (if (null != recurrencePattern) "\t\t<cim:TimeSchedule.recurrencePattern>" + recurrencePattern + "</cim:TimeSchedule.recurrencePattern>\n" else "") +
        "\t\t<cim:TimeSchedule.recurrencePeriod>" + recurrencePeriod + "</cim:TimeSchedule.recurrencePeriod>\n" +
        (if (null != scheduleInterval) "\t\t<cim:TimeSchedule.scheduleInterval rdf:resource=\"#" + scheduleInterval + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TimeSchedule rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TimeSchedule>\n"
    }
}

object TimeSchedule
extends
    Parseable[TimeSchedule]
{
    val disabled = parse_element (element ("""TimeSchedule.disabled"""))
    val offset = parse_element (element ("""TimeSchedule.offset"""))
    val recurrencePattern = parse_element (element ("""TimeSchedule.recurrencePattern"""))
    val recurrencePeriod = parse_element (element ("""TimeSchedule.recurrencePeriod"""))
    val scheduleInterval = parse_attribute (attribute ("""TimeSchedule.scheduleInterval"""))
    def parse (context: Context): TimeSchedule =
    {
        TimeSchedule(
            Document.parse (context),
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
(
    override val sup: BasicElement,
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
    override def copy (): Row = { clone ().asInstanceOf[TownDetail] }
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
        (if (null != code) "\t\t<cim:TownDetail.code>" + code + "</cim:TownDetail.code>\n" else "") +
        (if (null != country) "\t\t<cim:TownDetail.country>" + country + "</cim:TownDetail.country>\n" else "") +
        (if (null != name) "\t\t<cim:TownDetail.name>" + name + "</cim:TownDetail.name>\n" else "") +
        (if (null != section) "\t\t<cim:TownDetail.section>" + section + "</cim:TownDetail.section>\n" else "") +
        (if (null != stateOrProvince) "\t\t<cim:TownDetail.stateOrProvince>" + stateOrProvince + "</cim:TownDetail.stateOrProvince>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TownDetail rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TownDetail>\n"
    }
}

object TownDetail
extends
    Parseable[TownDetail]
{
    val code = parse_element (element ("""TownDetail.code"""))
    val country = parse_element (element ("""TownDetail.country"""))
    val name = parse_element (element ("""TownDetail.name"""))
    val section = parse_element (element ("""TownDetail.section"""))
    val stateOrProvince = parse_element (element ("""TownDetail.stateOrProvince"""))
    def parse (context: Context): TownDetail =
    {
        TownDetail(
            BasicElement.parse (context),
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
(
    override val sup: BasicElement,
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
    override def copy (): Row = { clone ().asInstanceOf[UserAttribute] }
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
        (if (null != name) "\t\t<cim:UserAttribute.name>" + name + "</cim:UserAttribute.name>\n" else "") +
        "\t\t<cim:UserAttribute.sequenceNumber>" + sequenceNumber + "</cim:UserAttribute.sequenceNumber>\n" +
        (if (null != value) "\t\t<cim:UserAttribute.value rdf:resource=\"#" + value + "\"/>\n" else "") +
        (if (null != ProcedureDataSets) ProcedureDataSets.map (x => "\t\t<cim:UserAttribute.ProcedureDataSets rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != PropertySpecification) "\t\t<cim:UserAttribute.PropertySpecification rdf:resource=\"#" + PropertySpecification + "\"/>\n" else "") +
        (if (null != RatingSpecification) "\t\t<cim:UserAttribute.RatingSpecification rdf:resource=\"#" + RatingSpecification + "\"/>\n" else "") +
        (if (null != Transaction) "\t\t<cim:UserAttribute.Transaction rdf:resource=\"#" + Transaction + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:UserAttribute rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:UserAttribute>\n"
    }
}

object UserAttribute
extends
    Parseable[UserAttribute]
{
    val name = parse_element (element ("""UserAttribute.name"""))
    val sequenceNumber = parse_element (element ("""UserAttribute.sequenceNumber"""))
    val value = parse_attribute (attribute ("""UserAttribute.value"""))
    val ProcedureDataSets = parse_attributes (attribute ("""UserAttribute.ProcedureDataSets"""))
    val PropertySpecification = parse_attribute (attribute ("""UserAttribute.PropertySpecification"""))
    val RatingSpecification = parse_attribute (attribute ("""UserAttribute.RatingSpecification"""))
    val Transaction = parse_attribute (attribute ("""UserAttribute.Transaction"""))
    def parse (context: Context): UserAttribute =
    {
        UserAttribute(
            BasicElement.parse (context),
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