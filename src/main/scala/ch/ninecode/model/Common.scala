package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

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
    override def copy (): Row = { return (clone ().asInstanceOf[ActivityRecord]); }
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
    val createdDateTime = parse_element (element ("""ActivityRecord.createdDateTime"""))_
    val reason = parse_element (element ("""ActivityRecord.reason"""))_
    val severity = parse_element (element ("""ActivityRecord.severity"""))_
    val typ = parse_element (element ("""ActivityRecord.type"""))_
    val status = parse_attribute (attribute ("""ActivityRecord.status"""))_
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
    override def copy (): Row = { return (clone ().asInstanceOf[Agreement]); }
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
    val signDate = parse_element (element ("""Agreement.signDate"""))_
    val validityInterval = parse_attribute (attribute ("""Agreement.validityInterval"""))_
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
    override def copy (): Row = { return (clone ().asInstanceOf[Appointment]); }
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
    val callAhead = parse_element (element ("""Appointment.callAhead"""))_
    val meetingInterval = parse_attribute (attribute ("""Appointment.meetingInterval"""))_
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
    override def copy (): Row = { return (clone ().asInstanceOf[ConfigurationEvent]); }
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
    override def copy (): Row = { return (clone ().asInstanceOf[CoordinateSystem]); }
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
    val crsUrn = parse_element (element ("""CoordinateSystem.crsUrn"""))_
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
    override def copy (): Row = { return (clone ().asInstanceOf[Crew]); }
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
    val CrewType = parse_attribute (attribute ("""Crew.CrewType"""))_
    val status = parse_attribute (attribute ("""Crew.status"""))_
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
    override def copy (): Row = { return (clone ().asInstanceOf[CrewMember]); }
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
    val Crew = parse_attribute (attribute ("""CrewMember.Crew"""))_
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
    override def copy (): Row = { return (clone ().asInstanceOf[CrewType]); }
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
    override def copy (): Row = { return (clone ().asInstanceOf[Document]); }
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
    val authorName = parse_element (element ("""Document.authorName"""))_
    val comment = parse_element (element ("""Document.comment"""))_
    val createdDateTime = parse_element (element ("""Document.createdDateTime"""))_
    val lastModifiedDateTime = parse_element (element ("""Document.lastModifiedDateTime"""))_
    val revisionNumber = parse_element (element ("""Document.revisionNumber"""))_
    val subject = parse_element (element ("""Document.subject"""))_
    val title = parse_element (element ("""Document.title"""))_
    val typ = parse_element (element ("""Document.type"""))_
    val docStatus = parse_attribute (attribute ("""Document.docStatus"""))_
    val electronicAddress = parse_attribute (attribute ("""Document.electronicAddress"""))_
    val status = parse_attribute (attribute ("""Document.status"""))_
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
    override val sup: Element,
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
    override def copy (): Row = { return (clone ().asInstanceOf[ElectronicAddress]); }
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
    override def copy (): Row = { return (clone ().asInstanceOf[Hazard]); }
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
    val typ = parse_element (element ("""Hazard.type"""))_
    val status = parse_attribute (attribute ("""Hazard.status"""))_
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
    override def copy (): Row = { return (clone ().asInstanceOf[Location]); }
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
    val direction = parse_element (element ("""Location.direction"""))_
    val geoInfoReference = parse_element (element ("""Location.geoInfoReference"""))_
    val typ = parse_element (element ("""Location.type"""))_
    val CoordinateSystem = parse_attribute (attribute ("""Location.CoordinateSystem"""))_
    val electronicAddress = parse_attribute (attribute ("""Location.electronicAddress"""))_
    val mainAddress = parse_attribute (attribute ("""Location.mainAddress"""))_
    val phone1 = parse_attribute (attribute ("""Location.phone1"""))_
    val phone2 = parse_attribute (attribute ("""Location.phone2"""))_
    val secondaryAddress = parse_attribute (attribute ("""Location.secondaryAddress"""))_
    val status = parse_attribute (attribute ("""Location.status"""))_

    val mainAddress_noncompliant = parse_element (element ("""Location.mainAddress"""))_
    val secondaryAddress_noncompliant = parse_element (element ("""Location.secondaryAddress"""))_

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
    override def copy (): Row = { return (clone ().asInstanceOf[OperationPersonRole]); }
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
    override def copy (): Row = { return (clone ().asInstanceOf[Operator]); }
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
    override def copy (): Row = { return (clone ().asInstanceOf[Organisation]); }
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
    val electronicAddress = parse_attribute (attribute ("""Organisation.electronicAddress"""))_
    val phone1 = parse_attribute (attribute ("""Organisation.phone1"""))_
    val phone2 = parse_attribute (attribute ("""Organisation.phone2"""))_
    val postalAddress = parse_attribute (attribute ("""Organisation.postalAddress"""))_
    val streetAddress = parse_attribute (attribute ("""Organisation.streetAddress"""))_
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
    override def copy (): Row = { return (clone ().asInstanceOf[OrganisationRole]); }
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
    val Organisation = parse_attribute (attribute ("""OrganisationRole.Organisation"""))_
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
    override def copy (): Row = { return (clone ().asInstanceOf[Ownership]); }
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
    val share = parse_element (element ("""Ownership.share"""))_
    val Asset = parse_attribute (attribute ("""Ownership.Asset"""))_
    val AssetOwner = parse_attribute (attribute ("""Ownership.AssetOwner"""))_
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
    override def copy (): Row = { return (clone ().asInstanceOf[Person]); }
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
    val firstName = parse_element (element ("""Person.firstName"""))_
    val lastName = parse_element (element ("""Person.lastName"""))_
    val mName = parse_element (element ("""Person.mName"""))_
    val prefix = parse_element (element ("""Person.prefix"""))_
    val specialNeed = parse_element (element ("""Person.specialNeed"""))_
    val suffix = parse_element (element ("""Person.suffix"""))_
    val electronicAddress = parse_attribute (attribute ("""Person.electronicAddress"""))_
    val landlinePhone = parse_attribute (attribute ("""Person.landlinePhone"""))_
    val mobilePhone = parse_attribute (attribute ("""Person.mobilePhone"""))_
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
    override def copy (): Row = { return (clone ().asInstanceOf[PersonRole]); }
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
    val Person = parse_attribute (attribute ("""PersonRole.Person"""))_
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
    override val sup: Element,
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
    override def copy (): Row = { return (clone ().asInstanceOf[PositionPoint]); }
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
    val sequenceNumber = parse_element (element ("""PositionPoint.sequenceNumber"""))_
    val xPosition = parse_element (element ("""PositionPoint.xPosition"""))_
    val yPosition = parse_element (element ("""PositionPoint.yPosition"""))_
    val zPosition = parse_element (element ("""PositionPoint.zPosition"""))_
    val Location = parse_attribute (attribute ("""PositionPoint.Location"""))_
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
    override val sup: Element,
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
    override def copy (): Row = { return (clone ().asInstanceOf[PostalAddress]); }
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
    val poBox = parse_element (element ("""PostalAddress.poBox"""))_
    val postalCode = parse_element (element ("""PostalAddress.postalCode"""))_
    val streetDetail = parse_attribute (attribute ("""PostalAddress.streetDetail"""))_
    val townDetail = parse_attribute (attribute ("""PostalAddress.townDetail"""))_
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
    override val sup: Element,
    justification: String,
    rank: Int,
    typ: String
)
extends
    Element
{
    def this () = { this (null, null, 0, null) }
    def Element: Element = sup
    override def copy (): Row = { return (clone ().asInstanceOf[Priority]); }
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
    val justification = parse_element (element ("""Priority.justification"""))_
    val rank = parse_element (element ("""Priority.rank"""))_
    val typ = parse_element (element ("""Priority.type"""))_
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
    override def copy (): Row = { return (clone ().asInstanceOf[ScheduledEvent]); }
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
    val duration = parse_element (element ("""ScheduledEvent.duration"""))_
    val typ = parse_element (element ("""ScheduledEvent.type"""))_
    val ScheduledEventData = parse_attribute (attribute ("""ScheduledEvent.ScheduledEventData"""))_
    val status = parse_attribute (attribute ("""ScheduledEvent.status"""))_
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
    override val sup: Element,
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
    override def copy (): Row = { return (clone ().asInstanceOf[ScheduledEventData]); }
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
    val InspectionDataSet = parse_attribute (attribute ("""ScheduledEventData.InspectionDataSet"""))_
    val estimatedWindow = parse_attribute (attribute ("""ScheduledEventData.estimatedWindow"""))_
    val requestedWindow = parse_attribute (attribute ("""ScheduledEventData.requestedWindow"""))_
    val status = parse_attribute (attribute ("""ScheduledEventData.status"""))_
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
    override val sup: Element,
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
    override def copy (): Row = { return (clone ().asInstanceOf[Status]); }
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
    val dateTime = parse_element (element ("""Status.dateTime"""))_
    val reason = parse_element (element ("""Status.reason"""))_
    val remark = parse_element (element ("""Status.remark"""))_
    val value = parse_element (element ("""Status.value"""))_
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
    override val sup: Element,
    status: String,
    streetDetail: String,
    townDetail: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup
    override def copy (): Row = { return (clone ().asInstanceOf[StreetAddress]); }
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
    val status = parse_attribute (attribute ("""StreetAddress.status"""))_
    val streetDetail = parse_attribute (attribute ("""StreetAddress.streetDetail"""))_
    val townDetail = parse_attribute (attribute ("""StreetAddress.townDetail"""))_
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
    override val sup: Element,
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
    override def copy (): Row = { return (clone ().asInstanceOf[StreetDetail]); }
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
    override val sup: Element,
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
    override def copy (): Row = { return (clone ().asInstanceOf[TelephoneNumber]); }
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
    val areaCode = parse_element (element ("""TelephoneNumber.areaCode"""))_
    val cityCode = parse_element (element ("""TelephoneNumber.cityCode"""))_
    val countryCode = parse_element (element ("""TelephoneNumber.countryCode"""))_
    val extension = parse_element (element ("""TelephoneNumber.extension"""))_
    val localNumber = parse_element (element ("""TelephoneNumber.localNumber"""))_
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
    override def copy (): Row = { return (clone ().asInstanceOf[TimePoint]); }
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
    val dateTime = parse_element (element ("""TimePoint.dateTime"""))_
    val relativeTimeInterval = parse_element (element ("""TimePoint.relativeTimeInterval"""))_
    val sequenceNumber = parse_element (element ("""TimePoint.sequenceNumber"""))_
    val TimeSchedule = parse_attribute (attribute ("""TimePoint.TimeSchedule"""))_
    val status = parse_attribute (attribute ("""TimePoint.status"""))_
    val window = parse_attribute (attribute ("""TimePoint.window"""))_
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
    override def copy (): Row = { return (clone ().asInstanceOf[TimeSchedule]); }
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
    val disabled = parse_element (element ("""TimeSchedule.disabled"""))_
    val offset = parse_element (element ("""TimeSchedule.offset"""))_
    val recurrencePattern = parse_element (element ("""TimeSchedule.recurrencePattern"""))_
    val recurrencePeriod = parse_element (element ("""TimeSchedule.recurrencePeriod"""))_
    val scheduleInterval = parse_attribute (attribute ("""TimeSchedule.scheduleInterval"""))_
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
    override val sup: Element,
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
    override def copy (): Row = { return (clone ().asInstanceOf[TownDetail]); }
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
    val code = parse_element (element ("""TownDetail.code"""))_
    val country = parse_element (element ("""TownDetail.country"""))_
    val name = parse_element (element ("""TownDetail.name"""))_
    val section = parse_element (element ("""TownDetail.section"""))_
    val stateOrProvince = parse_element (element ("""TownDetail.stateOrProvince"""))_
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
    override val sup: Element,
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
    override def copy (): Row = { return (clone ().asInstanceOf[UserAttribute]); }
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
    val name = parse_element (element ("""UserAttribute.name"""))_
    val sequenceNumber = parse_element (element ("""UserAttribute.sequenceNumber"""))_
    val PropertySpecification = parse_attribute (attribute ("""UserAttribute.PropertySpecification"""))_
    val RatingSpecification = parse_attribute (attribute ("""UserAttribute.RatingSpecification"""))_
    val Transaction = parse_attribute (attribute ("""UserAttribute.Transaction"""))_
    val value = parse_attribute (attribute ("""UserAttribute.value"""))_
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

object Common
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

