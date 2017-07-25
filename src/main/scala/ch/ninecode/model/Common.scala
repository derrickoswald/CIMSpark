package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/*
 * Package: Common
 */

case class ActivityRecord
(
    override val sup: IdentifiedObject,
    val createdDateTime: String,
    val reason: String,
    val severity: String,
    val typ: String,
    val status: String
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
    val createdDateTime = parse_element (element ("""ActivityRecord.createdDateTime"""))
    val reason = parse_element (element ("""ActivityRecord.reason"""))
    val severity = parse_element (element ("""ActivityRecord.severity"""))
    val typ = parse_element (element ("""ActivityRecord.type"""))
    val status = parse_attribute (attribute ("""ActivityRecord.status"""))
    def parse (context: Context): ActivityRecord =
    {
        return (
            ActivityRecord
            (
                IdentifiedObject.parse (context),
                createdDateTime (context),
                reason (context),
                severity (context),
                typ (context),
                status (context)
            )
        )
    }
}

case class Agreement
(
    override val sup: Document,
    val signDate: String, // ToDo: Date handling
    val validityInterval: String // ToDo: DateTime handling
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
    val signDate = parse_element (element ("""Agreement.signDate"""))
    val validityInterval = parse_attribute (attribute ("""Agreement.validityInterval"""))
    def parse (context: Context): Agreement =
    {
        return (
            Agreement
            (
                Document.parse (context),
                signDate (context),
                validityInterval (context)
            )
        )
    }
}

case class Appointment
(
    override val sup: IdentifiedObject,
    val callAhead: Boolean,
    val meetingInterval: String
)
extends
    Element
{
    def this () = { this (null, false, null) }
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
    val callAhead = parse_element (element ("""Appointment.callAhead"""))
    val meetingInterval = parse_attribute (attribute ("""Appointment.meetingInterval"""))
    def parse (context: Context): Appointment =
    {
        return (
            Appointment
            (
                IdentifiedObject.parse (context),
                toBoolean (callAhead (context), context),
                meetingInterval (context)
            )
        )
    }
}

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
        return (
            ConfigurationEvent
            (
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
        )
    }
}

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
    val crsUrn = parse_element (element ("""CoordinateSystem.crsUrn"""))
    def parse (context: Context): CoordinateSystem =
    {
        return (
            CoordinateSystem
            (
                IdentifiedObject.parse (context),
                crsUrn (context)
            )
        )
    }
}

case class Crew
(
    override val sup: IdentifiedObject,
    val CrewType: String,
    val status: String
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
    val CrewType = parse_attribute (attribute ("""Crew.CrewType"""))
    val status = parse_attribute (attribute ("""Crew.status"""))
    def parse (context: Context): Crew =
    {
        return (
            Crew
            (
                IdentifiedObject.parse (context),
                CrewType (context),
                status (context)
            )
        )
    }
}

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
    val Crew = parse_attribute (attribute ("""CrewMember.Crew"""))
    def parse (context: Context): CrewMember =
    {
        return (
            CrewMember
            (
                OperationPersonRole.parse (context),
                Crew (context)
            )
        )
    }
}

case class CrewType
(
    override val sup: IdentifiedObject
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
    def parse (context: Context): CrewType =
    {
        return (
            CrewType
            (
                IdentifiedObject.parse (context)
            )
        )
    }
}

case class Document
(
    override val sup: IdentifiedObject,
    val authorName: String,
    val comment: String,
    val createdDateTime: String, // ToDo: DateTime handling
    val lastModifiedDateTime: String, // ToDo: DateTime handling
    val revisionNumber: String,
    val subject: String,
    val title: String,
    val typ: String,
    val docStatus: String,
    val electronicAddress: String,
    val status: String
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
    val authorName = parse_element (element ("""Document.authorName"""))
    val comment = parse_element (element ("""Document.comment"""))
    val createdDateTime = parse_element (element ("""Document.createdDateTime"""))
    val lastModifiedDateTime = parse_element (element ("""Document.lastModifiedDateTime"""))
    val revisionNumber = parse_element (element ("""Document.revisionNumber"""))
    val subject = parse_element (element ("""Document.subject"""))
    val title = parse_element (element ("""Document.title"""))
    val typ = parse_element (element ("""Document.type"""))
    val docStatus = parse_attribute (attribute ("""Document.docStatus"""))
    val electronicAddress = parse_attribute (attribute ("""Document.electronicAddress"""))
    val status = parse_attribute (attribute ("""Document.status"""))
    def parse (context: Context): Document =
    {
        return (
            Document
            (
                IdentifiedObject.parse (context),
                authorName (context),
                comment (context),
                createdDateTime (context),
                lastModifiedDateTime (context),
                revisionNumber (context),
                subject (context),
                title (context),
                typ (context),
                docStatus (context),
                electronicAddress (context),
                status (context)
            )
        )
    }
}

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
        return (
            ElectronicAddress
            (
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
        )
    }
}

case class Hazard
(
    override val sup: IdentifiedObject,
    val typ: String,
    val status: String
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
    val typ = parse_element (element ("""Hazard.type"""))
    val status = parse_attribute (attribute ("""Hazard.status"""))
    def parse (context: Context): Hazard =
    {
        return (
            Hazard
            (
                IdentifiedObject.parse (context),
                typ (context),
                status (context)
            )
        )
    }
}

case class Location
(
    override val sup: IdentifiedObject,
    val direction: String,
    val geoInfoReference: String,
    val typ: String,
    val CoordinateSystem: String,
    val electronicAddress: String,
    val mainAddress: String,
    val phone1: String,
    val phone2: String,
    val secondaryAddress: String,
    val status: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null) }
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
    val direction = parse_element (element ("""Location.direction"""))
    val geoInfoReference = parse_element (element ("""Location.geoInfoReference"""))
    val typ = parse_element (element ("""Location.type"""))
    val CoordinateSystem = parse_attribute (attribute ("""Location.CoordinateSystem"""))
    val electronicAddress = parse_attribute (attribute ("""Location.electronicAddress"""))
    val mainAddress = parse_attribute (attribute ("""Location.mainAddress"""))
    val phone1 = parse_attribute (attribute ("""Location.phone1"""))
    val phone2 = parse_attribute (attribute ("""Location.phone2"""))
    val secondaryAddress = parse_attribute (attribute ("""Location.secondaryAddress"""))
    val status = parse_attribute (attribute ("""Location.status"""))

    val mainAddress_noncompliant = parse_element (element ("""Location.mainAddress"""))
    val secondaryAddress_noncompliant = parse_element (element ("""Location.secondaryAddress"""))

    def parse (context: Context): Location =
    {
        // to handle addresses without generating StreetAddress, StreetDetail & TownDetail elements
        // we first try parsing the main and secondary addresses as simple strings
        // and if these have a value, then we use that instead
        // ToDo: clean this up and make CIM export from NIS compliant
        val main = mainAddress_noncompliant (context)
        val secondary = secondaryAddress_noncompliant (context)
        return (
            Location
            (
                IdentifiedObject.parse (context),
                direction (context),
                geoInfoReference (context),
                typ (context),
                CoordinateSystem (context),
                electronicAddress (context),
                if (null == main) mainAddress (context) else main,
                phone1 (context),
                phone2 (context),
                if (null == secondary) secondaryAddress (context) else secondary,
                status (context)
            )
        )
    }
}

case class OperationPersonRole
(
    override val sup: PersonRole
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
    def parse (context: Context): OperationPersonRole =
    {
        return (
            OperationPersonRole
            (
                PersonRole.parse (context)
            )
        )
    }
}

case class Operator
(
    override val sup: OperationPersonRole
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
    def parse (context: Context): Operator =
    {
        return (
            Operator
            (
                OperationPersonRole.parse (context)
            )
        )
    }
}

case class Organisation
(
    override val sup: IdentifiedObject,
    val electronicAddress: String,
    val phone1: String,
    val phone2: String,
    val postalAddress: String,
    val streetAddress: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
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
    val electronicAddress = parse_attribute (attribute ("""Organisation.electronicAddress"""))
    val phone1 = parse_attribute (attribute ("""Organisation.phone1"""))
    val phone2 = parse_attribute (attribute ("""Organisation.phone2"""))
    val postalAddress = parse_attribute (attribute ("""Organisation.postalAddress"""))
    val streetAddress = parse_attribute (attribute ("""Organisation.streetAddress"""))
    def parse (context: Context): Organisation =
    {
        return (
            Organisation
            (
                IdentifiedObject.parse (context),
                electronicAddress (context),
                phone1 (context),
                phone2 (context),
                postalAddress (context),
                streetAddress (context)
            )
        )
    }
}

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
    val Organisation = parse_attribute (attribute ("""OrganisationRole.Organisation"""))
    def parse (context: Context): OrganisationRole =
    {
        return (
            OrganisationRole
            (
                IdentifiedObject.parse (context),
                Organisation (context)
            )
        )
    }
}

case class Ownership
(
    override val sup: IdentifiedObject,
    val share: String,  // ToDo: PerCent handling
    val Asset: String,
    val AssetOwner: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
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
    val share = parse_element (element ("""Ownership.share"""))
    val Asset = parse_attribute (attribute ("""Ownership.Asset"""))
    val AssetOwner = parse_attribute (attribute ("""Ownership.AssetOwner"""))
    def parse (context: Context): Ownership =
    {
        return (
            Ownership
            (
                IdentifiedObject.parse (context),
                share (context),
                Asset (context),
                AssetOwner (context)
            )
        )
    }
}

case class Person
(
    override val sup: IdentifiedObject,
    val firstName: String,
    val lastName: String,
    val mName: String,
    val prefix: String,
    val specialNeed: String,
    val suffix: String,
    val electronicAddress: String,
    val landlinePhone: String,
    val mobilePhone: String
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
    val firstName = parse_element (element ("""Person.firstName"""))
    val lastName = parse_element (element ("""Person.lastName"""))
    val mName = parse_element (element ("""Person.mName"""))
    val prefix = parse_element (element ("""Person.prefix"""))
    val specialNeed = parse_element (element ("""Person.specialNeed"""))
    val suffix = parse_element (element ("""Person.suffix"""))
    val electronicAddress = parse_attribute (attribute ("""Person.electronicAddress"""))
    val landlinePhone = parse_attribute (attribute ("""Person.landlinePhone"""))
    val mobilePhone = parse_attribute (attribute ("""Person.mobilePhone"""))
    def parse (context: Context): Person =
    {
        return (
            Person
            (
                IdentifiedObject.parse (context),
                firstName (context),
                lastName (context),
                mName (context),
                prefix (context),
                specialNeed (context),
                suffix (context),
                electronicAddress (context),
                landlinePhone (context),
                mobilePhone (context)
            )
        )
    }
}

case class PersonRole
(
    override val sup: IdentifiedObject,
    val Person: String
)
extends
    Element
{
    def this () = { this (null, null) }
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
    val Person = parse_attribute (attribute ("""PersonRole.Person"""))
    def parse (context: Context): PersonRole =
    {
        return (
            PersonRole
            (
                IdentifiedObject.parse (context),
                Person (context)
            )
        )
    }
}

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
    def Element: Element = sup
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
    val sequenceNumber = parse_element (element ("""PositionPoint.sequenceNumber"""))
    val xPosition = parse_element (element ("""PositionPoint.xPosition"""))
    val yPosition = parse_element (element ("""PositionPoint.yPosition"""))
    val zPosition = parse_element (element ("""PositionPoint.zPosition"""))
    val Location = parse_attribute (attribute ("""PositionPoint.Location"""))
    def parse (context: Context): PositionPoint =
    {
        return (
            PositionPoint
            (
                // ToDo: PositionPoint need not have an id
                // If it doesn't have one it will need to be generated.
                BasicElement.parse (context),
                toInteger (sequenceNumber (context), context),
                xPosition (context),
                yPosition (context),
                zPosition (context),
                Location (context)
            )
        )
    }
}

case class PostalAddress
(
    override val sup: BasicElement,
    poBox: String,
    postalCode: String,
    streetDetail: String,
    townDetail: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup
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
    val poBox = parse_element (element ("""PostalAddress.poBox"""))
    val postalCode = parse_element (element ("""PostalAddress.postalCode"""))
    val streetDetail = parse_attribute (attribute ("""PostalAddress.streetDetail"""))
    val townDetail = parse_attribute (attribute ("""PostalAddress.townDetail"""))
    def parse (context: Context): PostalAddress =
    {
        return (
            PostalAddress
            (
                BasicElement.parse (context),
                poBox (context),
                postalCode (context),
                streetDetail (context),
                townDetail (context)
            )
        )
    }
}

case class Priority
(
    override val sup: BasicElement,
    justification: String,
    rank: Int,
    typ: String
)
extends
    Element
{
    def this () = { this (null, null, 0, null) }
    def Element: Element = sup
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
    val justification = parse_element (element ("""Priority.justification"""))
    val rank = parse_element (element ("""Priority.rank"""))
    val typ = parse_element (element ("""Priority.type"""))
    def parse (context: Context): Priority =
    {
        return (
            Priority
            (
                BasicElement.parse (context),
                justification (context),
                toInteger (rank (context), context),
                typ (context)
            )
        )
    }
}

case class ScheduledEvent
(
    override val sup: IdentifiedObject,
    val duration: Double,
    val typ: String,
    val ScheduledEventData: String,
    val status: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null, null) }
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
    val duration = parse_element (element ("""ScheduledEvent.duration"""))
    val typ = parse_element (element ("""ScheduledEvent.type"""))
    val ScheduledEventData = parse_attribute (attribute ("""ScheduledEvent.ScheduledEventData"""))
    val status = parse_attribute (attribute ("""ScheduledEvent.status"""))
    def parse (context: Context): ScheduledEvent =
    {
        return (
            ScheduledEvent
            (
                IdentifiedObject.parse (context),
                toDouble (duration (context), context),
                typ (context),
                ScheduledEventData (context),
                status (context)
            )
        )
    }
}

case class ScheduledEventData
(
    override val sup: BasicElement,
    val InspectionDataSet: String,
    val estimatedWindow: String,
    val requestedWindow: String,
    val status: String
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
    val InspectionDataSet = parse_attribute (attribute ("""ScheduledEventData.InspectionDataSet"""))
    val estimatedWindow = parse_attribute (attribute ("""ScheduledEventData.estimatedWindow"""))
    val requestedWindow = parse_attribute (attribute ("""ScheduledEventData.requestedWindow"""))
    val status = parse_attribute (attribute ("""ScheduledEventData.status"""))
    def parse (context: Context): ScheduledEventData =
    {
        return (
            ScheduledEventData
            (
                BasicElement.parse (context),
                InspectionDataSet (context),
                estimatedWindow (context),
                requestedWindow  (context),
                status (context)
            )
        )
    }
}

case class Status
(
    override val sup: BasicElement,
    dateTime: String,
    reason: String,
    remark: String,
    value: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup
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
    val dateTime = parse_element (element ("""Status.dateTime"""))
    val reason = parse_element (element ("""Status.reason"""))
    val remark = parse_element (element ("""Status.remark"""))
    val value = parse_element (element ("""Status.value"""))
    def parse (context: Context): Status =
    {
        return (
            Status
            (
                BasicElement.parse (context),
                dateTime (context),
                reason (context),
                remark (context),
                value (context)
            )
        )
    }
}

case class StreetAddress
(
    override val sup: BasicElement,
    status: String,
    streetDetail: String,
    townDetail: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup
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
    val status = parse_attribute (attribute ("""StreetAddress.status"""))
    val streetDetail = parse_attribute (attribute ("""StreetAddress.streetDetail"""))
    val townDetail = parse_attribute (attribute ("""StreetAddress.townDetail"""))
    def parse (context: Context): StreetAddress =
    {
        return (
            StreetAddress
            (
                BasicElement.parse (context),
                status (context),
                streetDetail (context),
                townDetail (context)
            )
        )
    }
}

case class StreetDetail
(
    override val sup: BasicElement,
    addressGeneral: String,
    buildingName: String,
    code: String,
    name: String,
    number: String,
    prefix: String,
    suffix: String,
    suiteNumber: String,
    typ: String,
    withinTownLimits: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup
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
        return (
            StreetDetail
            (
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
                withinTownLimits (context)
            )
        )
    }
}

case class TelephoneNumber
(
    override val sup: BasicElement,
    areaCode: String,
    cityCode: String,
    countryCode: String,
    extension: String,
    localNumber: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup
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
    val areaCode = parse_element (element ("""TelephoneNumber.areaCode"""))
    val cityCode = parse_element (element ("""TelephoneNumber.cityCode"""))
    val countryCode = parse_element (element ("""TelephoneNumber.countryCode"""))
    val extension = parse_element (element ("""TelephoneNumber.extension"""))
    val localNumber = parse_element (element ("""TelephoneNumber.localNumber"""))
    def parse (context: Context): TelephoneNumber =
    {
        return (
            TelephoneNumber
            (
                BasicElement.parse (context),
                areaCode (context),
                cityCode (context),
                countryCode (context),
                extension (context),
                localNumber (context)
            )
        )
    }
}

case class TimePoint
(
    override val sup: IdentifiedObject,
    val dateTime: String,
    val relativeTimeInterval: Double,
    val sequenceNumber: Int,
    val TimeSchedule: String,
    val status: String,
    val window: String
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
    val dateTime = parse_element (element ("""TimePoint.dateTime"""))
    val relativeTimeInterval = parse_element (element ("""TimePoint.relativeTimeInterval"""))
    val sequenceNumber = parse_element (element ("""TimePoint.sequenceNumber"""))
    val TimeSchedule = parse_attribute (attribute ("""TimePoint.TimeSchedule"""))
    val status = parse_attribute (attribute ("""TimePoint.status"""))
    val window = parse_attribute (attribute ("""TimePoint.window"""))
    def parse (context: Context): TimePoint =
    {
        return (
            TimePoint
            (
                IdentifiedObject.parse (context),
                dateTime (context),
                toDouble (relativeTimeInterval (context), context),
                toInteger (sequenceNumber (context), context),
                TimeSchedule (context),
                status (context),
                window (context)
            )
        )
    }
}

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
    val disabled = parse_element (element ("""TimeSchedule.disabled"""))
    val offset = parse_element (element ("""TimeSchedule.offset"""))
    val recurrencePattern = parse_element (element ("""TimeSchedule.recurrencePattern"""))
    val recurrencePeriod = parse_element (element ("""TimeSchedule.recurrencePeriod"""))
    val scheduleInterval = parse_attribute (attribute ("""TimeSchedule.scheduleInterval"""))
    def parse (context: Context): TimeSchedule =
    {
        return (
            TimeSchedule
            (
                Document.parse (context),
                toBoolean (disabled (context), context),
                toDouble (offset (context), context),
                recurrencePattern (context),
                toDouble (recurrencePeriod (context), context),
                scheduleInterval (context)
            )
        )
    }
}

case class TownDetail
(
    override val sup: BasicElement,
    code: String,
    country: String,
    name: String,
    section: String,
    stateOrProvince: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup
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
    val code = parse_element (element ("""TownDetail.code"""))
    val country = parse_element (element ("""TownDetail.country"""))
    val name = parse_element (element ("""TownDetail.name"""))
    val section = parse_element (element ("""TownDetail.section"""))
    val stateOrProvince = parse_element (element ("""TownDetail.stateOrProvince"""))
    def parse (context: Context): TownDetail =
    {
        return (
            TownDetail
            (
                BasicElement.parse (context),
                code (context),
                country (context),
                name (context),
                section (context),
                stateOrProvince (context)
            )
        )
    }
}

case class UserAttribute
(
    override val sup: BasicElement,
    val name: String,
    val sequenceNumber: Int,
    val PropertySpecification: String,
    val RatingSpecification: String,
    val Transaction: String,
    val value: String
)
extends
    Element
{
    def this () = { this (null, null, 0, null, null, null, null) }
    def Element: Element = sup
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
    val name = parse_element (element ("""UserAttribute.name"""))
    val sequenceNumber = parse_element (element ("""UserAttribute.sequenceNumber"""))
    val PropertySpecification = parse_attribute (attribute ("""UserAttribute.PropertySpecification"""))
    val RatingSpecification = parse_attribute (attribute ("""UserAttribute.RatingSpecification"""))
    val Transaction = parse_attribute (attribute ("""UserAttribute.Transaction"""))
    val value = parse_attribute (attribute ("""UserAttribute.value"""))
    def parse (context: Context): UserAttribute =
    {
        return (
            UserAttribute
            (
                BasicElement.parse (context),
                name (context),
                toInteger (sequenceNumber (context), context),
                PropertySpecification (context),
                RatingSpecification (context),
                Transaction (context),
                value (context)
            )
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

