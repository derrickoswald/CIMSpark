package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Records activity for an entity at a point in time; activity may be for an event that has already occurred or for a planned activity.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param createdDateTime Date and time this activity record has been created (different from the 'status.dateTime', which is the time of a status change of the associated object, if applicable).
 * @param reason Reason for event resulting in this activity record, typically supplied when user initiated.
 * @param severity Severity level of event resulting in this activity record.
 * @param status [[ch.ninecode.model.Status Status]] Information on consequence of event resulting in this activity record.
 * @param type Type of event resulting in this activity record.
 * @param Assets [[ch.ninecode.model.Asset Asset]] All assets for which this activity record has been created.
 * @param Author [[ch.ninecode.model.Author Author]] Author of this activity record.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class ActivityRecord
(
    override val sup: IdentifiedObject,
    createdDateTime: String,
    reason: String,
    severity: String,
    status: String,
    `type`: String,
    Assets: List[String],
    Author: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, List(), null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ActivityRecord] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ActivityRecord.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ActivityRecord.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ActivityRecord.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ActivityRecord.fields (position), x))
        emitelem (0, createdDateTime)
        emitelem (1, reason)
        emitelem (2, severity)
        emitattr (3, status)
        emitelem (4, `type`)
        emitattrs (5, Assets)
        emitattr (6, Author)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ActivityRecord rdf:ID=\"%s\">\n%s\t</cim:ActivityRecord>".format (id, export_fields)
    }
}

object ActivityRecord
extends
    Parseable[ActivityRecord]
{
    override val fields: Array[String] = Array[String] (
        "createdDateTime",
        "reason",
        "severity",
        "status",
        "type",
        "Assets",
        "Author"
    )
    override val relations: List[Relationship] = List (
        Relationship ("status", "Status", "0..1", "0..*"),
        Relationship ("Assets", "Asset", "0..*", "0..*"),
        Relationship ("Author", "Author", "0..1", "0..*")
    )
    val createdDateTime: Fielder = parse_element (element (cls, fields(0)))
    val reason: Fielder = parse_element (element (cls, fields(1)))
    val severity: Fielder = parse_element (element (cls, fields(2)))
    val status: Fielder = parse_attribute (attribute (cls, fields(3)))
    val `type`: Fielder = parse_element (element (cls, fields(4)))
    val Assets: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val Author: Fielder = parse_attribute (attribute (cls, fields(6)))

    def parse (context: Context): ActivityRecord =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ActivityRecord (
            IdentifiedObject.parse (context),
            mask (createdDateTime (), 0),
            mask (reason (), 1),
            mask (severity (), 2),
            mask (status (), 3),
            mask (`type` (), 4),
            masks (Assets (), 5),
            mask (Author (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Formal agreement between two parties defining the terms and conditions for a set of services.
 *
 * The specifics of the services are, in turn, defined via one or more service agreements.
 *
 * @param sup [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param signDate Date this agreement was consummated among associated persons and/or organisations.
 * @param validityInterval Date and time interval this agreement is valid (from going into effect to termination).
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class Agreement
(
    override val sup: Document,
    signDate: String,
    validityInterval: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[Agreement] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Agreement.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Agreement.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Agreement.fields (position), value)
        emitelem (0, signDate)
        emitattr (1, validityInterval)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Agreement rdf:ID=\"%s\">\n%s\t</cim:Agreement>".format (id, export_fields)
    }
}

object Agreement
extends
    Parseable[Agreement]
{
    override val fields: Array[String] = Array[String] (
        "signDate",
        "validityInterval"
    )
    val signDate: Fielder = parse_element (element (cls, fields(0)))
    val validityInterval: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): Agreement =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Agreement (
            Document.parse (context),
            mask (signDate (), 0),
            mask (validityInterval (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Meeting time and location.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param callAhead True if requested to call customer when someone is about to arrive at their premises.
 * @param meetingInterval Date and time reserved for appointment.
 * @param Persons [[ch.ninecode.model.PersonRole PersonRole]] All persons for this appointment.
 * @param Works [[ch.ninecode.model.Work Work]] All works for this appointment.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class Appointment
(
    override val sup: IdentifiedObject,
    callAhead: Boolean,
    meetingInterval: String,
    Persons: List[String],
    Works: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, null, List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Appointment] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Appointment.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Appointment.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Appointment.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Appointment.fields (position), x))
        emitelem (0, callAhead)
        emitattr (1, meetingInterval)
        emitattrs (2, Persons)
        emitattrs (3, Works)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Appointment rdf:ID=\"%s\">\n%s\t</cim:Appointment>".format (id, export_fields)
    }
}

object Appointment
extends
    Parseable[Appointment]
{
    override val fields: Array[String] = Array[String] (
        "callAhead",
        "meetingInterval",
        "Persons",
        "Works"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Persons", "PersonRole", "0..*", "0..*"),
        Relationship ("Works", "Work", "0..*", "0..*")
    )
    val callAhead: Fielder = parse_element (element (cls, fields(0)))
    val meetingInterval: Fielder = parse_attribute (attribute (cls, fields(1)))
    val Persons: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val Works: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: Context): Appointment =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Appointment (
            IdentifiedObject.parse (context),
            toBoolean (mask (callAhead (), 0)),
            mask (meetingInterval (), 1),
            masks (Persons (), 2),
            masks (Works (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Person who accepted/signed or rejected the document.
 *
 * @param sup [[ch.ninecode.model.DocumentPersonRole DocumentPersonRole]] Reference to the superclass object.
 * @param Documents [[ch.ninecode.model.Document Document]] All documents for this approver.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class Approver
(
    override val sup: DocumentPersonRole,
    Documents: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def DocumentPersonRole: DocumentPersonRole = sup.asInstanceOf[DocumentPersonRole]
    override def copy (): Row = { clone ().asInstanceOf[Approver] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Approver.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Approver.fields (position), x))
        emitattrs (0, Documents)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Approver rdf:ID=\"%s\">\n%s\t</cim:Approver>".format (id, export_fields)
    }
}

object Approver
extends
    Parseable[Approver]
{
    override val fields: Array[String] = Array[String] (
        "Documents"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Documents", "Document", "0..*", "0..1")
    )
    val Documents: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): Approver =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Approver (
            DocumentPersonRole.parse (context),
            masks (Documents (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Person who created document or activity record.
 *
 * @param sup [[ch.ninecode.model.DocumentPersonRole DocumentPersonRole]] Reference to the superclass object.
 * @param ActivityRecords [[ch.ninecode.model.ActivityRecord ActivityRecord]] All activity records with this author.
 * @param Documents [[ch.ninecode.model.Document Document]] All documents of this this author.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class Author
(
    override val sup: DocumentPersonRole,
    ActivityRecords: List[String],
    Documents: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def DocumentPersonRole: DocumentPersonRole = sup.asInstanceOf[DocumentPersonRole]
    override def copy (): Row = { clone ().asInstanceOf[Author] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Author.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Author.fields (position), x))
        emitattrs (0, ActivityRecords)
        emitattrs (1, Documents)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Author rdf:ID=\"%s\">\n%s\t</cim:Author>".format (id, export_fields)
    }
}

object Author
extends
    Parseable[Author]
{
    override val fields: Array[String] = Array[String] (
        "ActivityRecords",
        "Documents"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ActivityRecords", "ActivityRecord", "0..*", "0..1"),
        Relationship ("Documents", "Document", "0..*", "0..1")
    )
    val ActivityRecords: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val Documents: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): Author =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Author (
            DocumentPersonRole.parse (context),
            masks (ActivityRecords (), 0),
            masks (Documents (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Used to report details on creation, change or deletion of an entity or its configuration.
 *
 * @param sup [[ch.ninecode.model.ActivityRecord ActivityRecord]] Reference to the superclass object.
 * @param effectiveDateTime Date and time this event has or will become effective.
 * @param modifiedBy Source/initiator of modification.
 * @param remark Free text remarks.
 * @param ChangedAsset [[ch.ninecode.model.Asset Asset]] Asset whose change resulted in this configuration event.
 * @param ChangedDocument [[ch.ninecode.model.Document Document]] Document whose change resulted in this configuration event.
 * @param ChangedLocation [[ch.ninecode.model.Location Location]] Location whose change resulted in this configuration event.
 * @param ChangedOrganisationRole [[ch.ninecode.model.OrganisationRole OrganisationRole]] Organisation role whose change resulted in this configuration event.
 * @param ChangedPersonRole [[ch.ninecode.model.PersonRole PersonRole]] Person role whose change resulted in this configuration event.
 * @param ChangedServiceCategory [[ch.ninecode.model.ServiceCategory ServiceCategory]] Service category whose change resulted in this configuration event.
 * @param ChangedUsagePoint [[ch.ninecode.model.UsagePoint UsagePoint]] Usage point whose change resulted in this configuration event.
 * @param FaultCauseType [[ch.ninecode.model.FaultCauseType FaultCauseType]] <em>undocumented</em>
 * @param PowerSystemResource [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] <em>undocumented</em>
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class ConfigurationEvent
(
    override val sup: ActivityRecord,
    effectiveDateTime: String,
    modifiedBy: String,
    remark: String,
    ChangedAsset: String,
    ChangedDocument: String,
    ChangedLocation: String,
    ChangedOrganisationRole: String,
    ChangedPersonRole: String,
    ChangedServiceCategory: String,
    ChangedUsagePoint: String,
    FaultCauseType: String,
    PowerSystemResource: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ActivityRecord: ActivityRecord = sup.asInstanceOf[ActivityRecord]
    override def copy (): Row = { clone ().asInstanceOf[ConfigurationEvent] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ConfigurationEvent.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ConfigurationEvent.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ConfigurationEvent.fields (position), value)
        emitelem (0, effectiveDateTime)
        emitelem (1, modifiedBy)
        emitelem (2, remark)
        emitattr (3, ChangedAsset)
        emitattr (4, ChangedDocument)
        emitattr (5, ChangedLocation)
        emitattr (6, ChangedOrganisationRole)
        emitattr (7, ChangedPersonRole)
        emitattr (8, ChangedServiceCategory)
        emitattr (9, ChangedUsagePoint)
        emitattr (10, FaultCauseType)
        emitattr (11, PowerSystemResource)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ConfigurationEvent rdf:ID=\"%s\">\n%s\t</cim:ConfigurationEvent>".format (id, export_fields)
    }
}

object ConfigurationEvent
extends
    Parseable[ConfigurationEvent]
{
    override val fields: Array[String] = Array[String] (
        "effectiveDateTime",
        "modifiedBy",
        "remark",
        "ChangedAsset",
        "ChangedDocument",
        "ChangedLocation",
        "ChangedOrganisationRole",
        "ChangedPersonRole",
        "ChangedServiceCategory",
        "ChangedUsagePoint",
        "FaultCauseType",
        "PowerSystemResource"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ChangedAsset", "Asset", "0..1", "0..*"),
        Relationship ("ChangedDocument", "Document", "0..1", "0..*"),
        Relationship ("ChangedLocation", "Location", "0..1", "0..*"),
        Relationship ("ChangedOrganisationRole", "OrganisationRole", "0..1", "0..*"),
        Relationship ("ChangedPersonRole", "PersonRole", "0..1", "0..*"),
        Relationship ("ChangedServiceCategory", "ServiceCategory", "0..1", "0..*"),
        Relationship ("ChangedUsagePoint", "UsagePoint", "0..1", "0..*"),
        Relationship ("FaultCauseType", "FaultCauseType", "1", "0..*"),
        Relationship ("PowerSystemResource", "PowerSystemResource", "0..1", "0..*")
    )
    val effectiveDateTime: Fielder = parse_element (element (cls, fields(0)))
    val modifiedBy: Fielder = parse_element (element (cls, fields(1)))
    val remark: Fielder = parse_element (element (cls, fields(2)))
    val ChangedAsset: Fielder = parse_attribute (attribute (cls, fields(3)))
    val ChangedDocument: Fielder = parse_attribute (attribute (cls, fields(4)))
    val ChangedLocation: Fielder = parse_attribute (attribute (cls, fields(5)))
    val ChangedOrganisationRole: Fielder = parse_attribute (attribute (cls, fields(6)))
    val ChangedPersonRole: Fielder = parse_attribute (attribute (cls, fields(7)))
    val ChangedServiceCategory: Fielder = parse_attribute (attribute (cls, fields(8)))
    val ChangedUsagePoint: Fielder = parse_attribute (attribute (cls, fields(9)))
    val FaultCauseType: Fielder = parse_attribute (attribute (cls, fields(10)))
    val PowerSystemResource: Fielder = parse_attribute (attribute (cls, fields(11)))

    def parse (context: Context): ConfigurationEvent =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ConfigurationEvent (
            ActivityRecord.parse (context),
            mask (effectiveDateTime (), 0),
            mask (modifiedBy (), 1),
            mask (remark (), 2),
            mask (ChangedAsset (), 3),
            mask (ChangedDocument (), 4),
            mask (ChangedLocation (), 5),
            mask (ChangedOrganisationRole (), 6),
            mask (ChangedPersonRole (), 7),
            mask (ChangedServiceCategory (), 8),
            mask (ChangedUsagePoint (), 9),
            mask (FaultCauseType (), 10),
            mask (PowerSystemResource (), 11)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Coordinate reference system.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param crsUrn A Uniform Resource Name (URN) for the coordinate reference system (crs) used to define 'Location.
 *        PositionPoints'.
 *        An example would be the European Petroleum Survey Group (EPSG) code for a coordinate reference system, defined in URN under the Open Geospatial Consortium (OGC) namespace as: urn:ogc:def:crs:EPSG::XXXX, where XXXX is an EPSG code (a full list of codes can be found at the EPSG Registry web site http://www.epsg-registry.org/). To define the coordinate system as being WGS84 (latitude, longitude) using an EPSG OGC, this attribute would be urn:ogc:def:crs:EPSG::4236.
 *        A profile should limit this code to a set of allowed URNs agreed to by all sending and receiving parties.
 * @param Locations [[ch.ninecode.model.Location Location]] All locations described with position points in this coordinate system.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class CoordinateSystem
(
    override val sup: IdentifiedObject,
    crsUrn: String,
    Locations: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[CoordinateSystem] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CoordinateSystem.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CoordinateSystem.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (CoordinateSystem.fields (position), x))
        emitelem (0, crsUrn)
        emitattrs (1, Locations)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CoordinateSystem rdf:ID=\"%s\">\n%s\t</cim:CoordinateSystem>".format (id, export_fields)
    }
}

object CoordinateSystem
extends
    Parseable[CoordinateSystem]
{
    override val fields: Array[String] = Array[String] (
        "crsUrn",
        "Locations"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Locations", "Location", "0..*", "0..1")
    )
    val crsUrn: Fielder = parse_element (element (cls, fields(0)))
    val Locations: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): CoordinateSystem =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CoordinateSystem (
            IdentifiedObject.parse (context),
            mask (crsUrn (), 0),
            masks (Locations (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Group of people with specific skills, tools, and vehicles.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param status [[ch.ninecode.model.Status Status]] Status of this crew.
 * @param CrewMembers [[ch.ninecode.model.CrewMember CrewMember]] All members of this crew.
 * @param CrewType [[ch.ninecode.model.CrewType CrewType]] Type of this crew.
 * @param FieldDispatchHistory [[ch.ninecode.model.FieldDispatchHistory FieldDispatchHistory]] <em>undocumented</em>
 * @param Location [[ch.ninecode.model.Location Location]] <em>undocumented</em>
 * @param Outage [[ch.ninecode.model.Outage Outage]] <em>undocumented</em>
 * @param SwitchingAction [[ch.ninecode.model.SwitchingAction SwitchingAction]] <em>undocumented</em>
 * @param WorkAssets [[ch.ninecode.model.WorkAsset WorkAsset]] All work assets used by this crew.
 * @param WorkTasks [[ch.ninecode.model.WorkTask WorkTask]] All work tasks this crew participates in.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class Crew
(
    override val sup: IdentifiedObject,
    status: String,
    CrewMembers: List[String],
    CrewType: String,
    FieldDispatchHistory: List[String],
    Location: String,
    Outage: List[String],
    SwitchingAction: String,
    WorkAssets: List[String],
    WorkTasks: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, List(), null, List(), null, List(), null, List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Crew] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Crew.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Crew.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Crew.fields (position), x))
        emitattr (0, status)
        emitattrs (1, CrewMembers)
        emitattr (2, CrewType)
        emitattrs (3, FieldDispatchHistory)
        emitattr (4, Location)
        emitattrs (5, Outage)
        emitattr (6, SwitchingAction)
        emitattrs (7, WorkAssets)
        emitattrs (8, WorkTasks)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Crew rdf:ID=\"%s\">\n%s\t</cim:Crew>".format (id, export_fields)
    }
}

object Crew
extends
    Parseable[Crew]
{
    override val fields: Array[String] = Array[String] (
        "status",
        "CrewMembers",
        "CrewType",
        "FieldDispatchHistory",
        "Location",
        "Outage",
        "SwitchingAction",
        "WorkAssets",
        "WorkTasks"
    )
    override val relations: List[Relationship] = List (
        Relationship ("status", "Status", "0..1", "0..*"),
        Relationship ("CrewMembers", "CrewMember", "0..*", "0..1"),
        Relationship ("CrewType", "CrewType", "0..1", "0..*"),
        Relationship ("FieldDispatchHistory", "FieldDispatchHistory", "0..*", "0..1"),
        Relationship ("Location", "Location", "0..1", "0..*"),
        Relationship ("Outage", "Outage", "0..*", "0..*"),
        Relationship ("SwitchingAction", "SwitchingAction", "1", "0..*"),
        Relationship ("WorkAssets", "WorkAsset", "0..*", "0..1"),
        Relationship ("WorkTasks", "WorkTask", "0..*", "0..*")
    )
    val status: Fielder = parse_attribute (attribute (cls, fields(0)))
    val CrewMembers: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val CrewType: Fielder = parse_attribute (attribute (cls, fields(2)))
    val FieldDispatchHistory: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val Location: Fielder = parse_attribute (attribute (cls, fields(4)))
    val Outage: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val SwitchingAction: Fielder = parse_attribute (attribute (cls, fields(6)))
    val WorkAssets: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val WorkTasks: FielderMultiple = parse_attributes (attribute (cls, fields(8)))

    def parse (context: Context): Crew =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Crew (
            IdentifiedObject.parse (context),
            mask (status (), 0),
            masks (CrewMembers (), 1),
            mask (CrewType (), 2),
            masks (FieldDispatchHistory (), 3),
            mask (Location (), 4),
            masks (Outage (), 5),
            mask (SwitchingAction (), 6),
            masks (WorkAssets (), 7),
            masks (WorkTasks (), 8)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Member of a crew.
 *
 * @param sup [[ch.ninecode.model.OperationPersonRole OperationPersonRole]] Reference to the superclass object.
 * @param Crew [[ch.ninecode.model.Crew Crew]] Crew to which this crew member belongs.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class CrewMember
(
    override val sup: OperationPersonRole,
    Crew: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def OperationPersonRole: OperationPersonRole = sup.asInstanceOf[OperationPersonRole]
    override def copy (): Row = { clone ().asInstanceOf[CrewMember] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CrewMember.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CrewMember.fields (position), value)
        emitattr (0, Crew)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CrewMember rdf:ID=\"%s\">\n%s\t</cim:CrewMember>".format (id, export_fields)
    }
}

object CrewMember
extends
    Parseable[CrewMember]
{
    override val fields: Array[String] = Array[String] (
        "Crew"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Crew", "Crew", "0..1", "0..*")
    )
    val Crew: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): CrewMember =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CrewMember (
            OperationPersonRole.parse (context),
            mask (Crew (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Custom description of the type of crew.
 *
 * This may be used to determine the type of work the crew can be assigned to. Examples include repair, tree trimming, switching, etc.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param Crews [[ch.ninecode.model.Crew Crew]] All crews of this type.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class CrewType
(
    override val sup: IdentifiedObject,
    Crews: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[CrewType] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CrewType.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (CrewType.fields (position), x))
        emitattrs (0, Crews)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CrewType rdf:ID=\"%s\">\n%s\t</cim:CrewType>".format (id, export_fields)
    }
}

object CrewType
extends
    Parseable[CrewType]
{
    override val fields: Array[String] = Array[String] (
        "Crews"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Crews", "Crew", "0..*", "0..1")
    )
    val Crews: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): CrewType =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CrewType (
            IdentifiedObject.parse (context),
            masks (Crews (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Parent class for different groupings of information collected and managed as a part of a business process.
 *
 * It will frequently contain references to other objects, such as assets, people and power system resources.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param authorName Name of the author of this document.
 * @param comment Free text comment.
 * @param createdDateTime Date and time that this document was created.
 * @param docStatus [[ch.ninecode.model.Status Status]] Status of this document.
 *        For status of subject matter this document represents (e.g., Agreement, Work), use 'status' attribute.
 *        Example values for 'docStatus.status' are draft, approved, cancelled, etc.
 * @param electronicAddress [[ch.ninecode.model.ElectronicAddress ElectronicAddress]] Electronic address.
 * @param lastModifiedDateTime Date and time this document was last modified.
 *        Documents may potentially be modified many times during their lifetime.
 * @param revisionNumber Revision number for this document.
 * @param status [[ch.ninecode.model.Status Status]] Status of subject matter (e.g., Agreement, Work) this document represents.
 *        For status of the document itself, use 'docStatus' attribute.
 * @param subject Document subject.
 * @param title Document title.
 * @param type Utility-specific classification of this document, according to its corporate standards, practices, and existing IT systems (e.g., for management of assets, maintenance, work, outage, customers, etc.).
 * @param Approver [[ch.ninecode.model.Approver Approver]] Approver of this document.
 * @param Author [[ch.ninecode.model.Author Author]] Author of this document.
 * @param ConfigurationEvents [[ch.ninecode.model.ConfigurationEvent ConfigurationEvent]] All configuration events created for this document.
 * @param Editor [[ch.ninecode.model.Editor Editor]] Editor of this document.
 * @param Issuer [[ch.ninecode.model.Issuer Issuer]] Issuer of this document.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class Document
(
    override val sup: IdentifiedObject,
    authorName: String,
    comment: String,
    createdDateTime: String,
    docStatus: String,
    electronicAddress: String,
    lastModifiedDateTime: String,
    revisionNumber: String,
    status: String,
    subject: String,
    title: String,
    `type`: String,
    Approver: String,
    Author: String,
    ConfigurationEvents: List[String],
    Editor: String,
    Issuer: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null, null, List(), null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Document] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Document.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Document.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Document.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Document.fields (position), x))
        emitelem (0, authorName)
        emitelem (1, comment)
        emitelem (2, createdDateTime)
        emitattr (3, docStatus)
        emitattr (4, electronicAddress)
        emitelem (5, lastModifiedDateTime)
        emitelem (6, revisionNumber)
        emitattr (7, status)
        emitelem (8, subject)
        emitelem (9, title)
        emitelem (10, `type`)
        emitattr (11, Approver)
        emitattr (12, Author)
        emitattrs (13, ConfigurationEvents)
        emitattr (14, Editor)
        emitattr (15, Issuer)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Document rdf:ID=\"%s\">\n%s\t</cim:Document>".format (id, export_fields)
    }
}

object Document
extends
    Parseable[Document]
{
    override val fields: Array[String] = Array[String] (
        "authorName",
        "comment",
        "createdDateTime",
        "docStatus",
        "electronicAddress",
        "lastModifiedDateTime",
        "revisionNumber",
        "status",
        "subject",
        "title",
        "type",
        "Approver",
        "Author",
        "ConfigurationEvents",
        "Editor",
        "Issuer"
    )
    override val relations: List[Relationship] = List (
        Relationship ("docStatus", "Status", "0..1", "0..*"),
        Relationship ("electronicAddress", "ElectronicAddress", "0..1", "0..*"),
        Relationship ("status", "Status", "0..1", "0..*"),
        Relationship ("Approver", "Approver", "0..1", "0..*"),
        Relationship ("Author", "Author", "0..1", "0..*"),
        Relationship ("ConfigurationEvents", "ConfigurationEvent", "0..*", "0..1"),
        Relationship ("Editor", "Editor", "0..1", "0..*"),
        Relationship ("Issuer", "Issuer", "0..1", "0..*")
    )
    val authorName: Fielder = parse_element (element (cls, fields(0)))
    val comment: Fielder = parse_element (element (cls, fields(1)))
    val createdDateTime: Fielder = parse_element (element (cls, fields(2)))
    val docStatus: Fielder = parse_attribute (attribute (cls, fields(3)))
    val electronicAddress: Fielder = parse_attribute (attribute (cls, fields(4)))
    val lastModifiedDateTime: Fielder = parse_element (element (cls, fields(5)))
    val revisionNumber: Fielder = parse_element (element (cls, fields(6)))
    val status: Fielder = parse_attribute (attribute (cls, fields(7)))
    val subject: Fielder = parse_element (element (cls, fields(8)))
    val title: Fielder = parse_element (element (cls, fields(9)))
    val `type`: Fielder = parse_element (element (cls, fields(10)))
    val Approver: Fielder = parse_attribute (attribute (cls, fields(11)))
    val Author: Fielder = parse_attribute (attribute (cls, fields(12)))
    val ConfigurationEvents: FielderMultiple = parse_attributes (attribute (cls, fields(13)))
    val Editor: Fielder = parse_attribute (attribute (cls, fields(14)))
    val Issuer: Fielder = parse_attribute (attribute (cls, fields(15)))

    def parse (context: Context): Document =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Document (
            IdentifiedObject.parse (context),
            mask (authorName (), 0),
            mask (comment (), 1),
            mask (createdDateTime (), 2),
            mask (docStatus (), 3),
            mask (electronicAddress (), 4),
            mask (lastModifiedDateTime (), 5),
            mask (revisionNumber (), 6),
            mask (status (), 7),
            mask (subject (), 8),
            mask (title (), 9),
            mask (`type` (), 10),
            mask (Approver (), 11),
            mask (Author (), 12),
            masks (ConfigurationEvents (), 13),
            mask (Editor (), 14),
            mask (Issuer (), 15)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Person role with respect to documents.
 *
 * @param sup [[ch.ninecode.model.PersonRole PersonRole]] Reference to the superclass object.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class DocumentPersonRole
(
    override val sup: PersonRole
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PersonRole: PersonRole = sup.asInstanceOf[PersonRole]
    override def copy (): Row = { clone ().asInstanceOf[DocumentPersonRole] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:DocumentPersonRole rdf:ID=\"%s\">\n%s\t</cim:DocumentPersonRole>".format (id, export_fields)
    }
}

object DocumentPersonRole
extends
    Parseable[DocumentPersonRole]
{

    def parse (context: Context): DocumentPersonRole =
    {
        implicit val ctx: Context = context
        val ret = DocumentPersonRole (
            PersonRole.parse (context)
        )
        ret
    }
}

/**
 * Person who modified the document.
 *
 * @param sup [[ch.ninecode.model.DocumentPersonRole DocumentPersonRole]] Reference to the superclass object.
 * @param Documents [[ch.ninecode.model.Document Document]] All documents for this editor.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class Editor
(
    override val sup: DocumentPersonRole,
    Documents: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def DocumentPersonRole: DocumentPersonRole = sup.asInstanceOf[DocumentPersonRole]
    override def copy (): Row = { clone ().asInstanceOf[Editor] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Editor.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Editor.fields (position), x))
        emitattrs (0, Documents)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Editor rdf:ID=\"%s\">\n%s\t</cim:Editor>".format (id, export_fields)
    }
}

object Editor
extends
    Parseable[Editor]
{
    override val fields: Array[String] = Array[String] (
        "Documents"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Documents", "Document", "0..*", "0..1")
    )
    val Documents: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): Editor =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Editor (
            DocumentPersonRole.parse (context),
            masks (Documents (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Electronic address information.
 *
 * @param sup Reference to the superclass object.
 * @param email1 Primary email address.
 * @param email2 Alternate email address.
 * @param lan Address on local area network.
 * @param mac MAC (Media Access Control) address.
 * @param password Password needed to log in.
 * @param radio Radio address.
 * @param userID User ID needed to log in, which can be for an individual person, an organisation, a location, etc.
 * @param web World wide web address.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class ElectronicAddress
(
    override val sup: BasicElement,
    email1: String,
    email2: String,
    lan: String,
    mac: String,
    password: String,
    radio: String,
    userID: String,
    web: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ElectronicAddress] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ElectronicAddress.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ElectronicAddress.fields (position), value)
        emitelem (0, email1)
        emitelem (1, email2)
        emitelem (2, lan)
        emitelem (3, mac)
        emitelem (4, password)
        emitelem (5, radio)
        emitelem (6, userID)
        emitelem (7, web)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ElectronicAddress rdf:ID=\"%s\">\n%s\t</cim:ElectronicAddress>".format (id, export_fields)
    }
}

object ElectronicAddress
extends
    Parseable[ElectronicAddress]
{
    override val fields: Array[String] = Array[String] (
        "email1",
        "email2",
        "lan",
        "mac",
        "password",
        "radio",
        "userID",
        "web"
    )
    val email1: Fielder = parse_element (element (cls, fields(0)))
    val email2: Fielder = parse_element (element (cls, fields(1)))
    val lan: Fielder = parse_element (element (cls, fields(2)))
    val mac: Fielder = parse_element (element (cls, fields(3)))
    val password: Fielder = parse_element (element (cls, fields(4)))
    val radio: Fielder = parse_element (element (cls, fields(5)))
    val userID: Fielder = parse_element (element (cls, fields(6)))
    val web: Fielder = parse_element (element (cls, fields(7)))

    def parse (context: Context): ElectronicAddress =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ElectronicAddress (
            BasicElement.parse (context),
            mask (email1 (), 0),
            mask (email2 (), 1),
            mask (lan (), 2),
            mask (mac (), 3),
            mask (password (), 4),
            mask (radio (), 5),
            mask (userID (), 6),
            mask (web (), 7)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class ExtensionItem
(
    override val sup: BasicElement,
    extName: String,
    extType: String,
    extValue: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ExtensionItem] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExtensionItem.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExtensionItem.fields (position), value)
        emitelem (0, extName)
        emitelem (1, extType)
        emitelem (2, extValue)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExtensionItem rdf:ID=\"%s\">\n%s\t</cim:ExtensionItem>".format (id, export_fields)
    }
}

object ExtensionItem
extends
    Parseable[ExtensionItem]
{
    override val fields: Array[String] = Array[String] (
        "extName",
        "extType",
        "extValue"
    )
    val extName: Fielder = parse_element (element (cls, fields(0)))
    val extType: Fielder = parse_element (element (cls, fields(1)))
    val extValue: Fielder = parse_element (element (cls, fields(2)))

    def parse (context: Context): ExtensionItem =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ExtensionItem (
            BasicElement.parse (context),
            mask (extName (), 0),
            mask (extType (), 1),
            mask (extValue (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class ExtensionsList
(
    override val sup: BasicElement,
    extensionsItem: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ExtensionsList] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExtensionsList.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ExtensionsList.fields (position), value)
        emitattr (0, extensionsItem)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExtensionsList rdf:ID=\"%s\">\n%s\t</cim:ExtensionsList>".format (id, export_fields)
    }
}

object ExtensionsList
extends
    Parseable[ExtensionsList]
{
    override val fields: Array[String] = Array[String] (
        "extensionsItem"
    )
    override val relations: List[Relationship] = List (
        Relationship ("extensionsItem", "ExtensionItem", "0..1", "0..*")
    )
    val extensionsItem: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): ExtensionsList =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ExtensionsList (
            BasicElement.parse (context),
            mask (extensionsItem (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The history of field dispatch statuses for this work.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param Crew [[ch.ninecode.model.Crew Crew]] <em>undocumented</em>
 * @param FieldDispatchStep [[ch.ninecode.model.FieldDispatchStep FieldDispatchStep]] <em>undocumented</em>
 * @param PlannedOutage [[ch.ninecode.model.PlannedOutage PlannedOutage]] <em>undocumented</em>
 * @param UnplannedOutage [[ch.ninecode.model.UnplannedOutage UnplannedOutage]] <em>undocumented</em>
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class FieldDispatchHistory
(
    override val sup: IdentifiedObject,
    Crew: String,
    FieldDispatchStep: List[String],
    PlannedOutage: String,
    UnplannedOutage: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, List(), null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[FieldDispatchHistory] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = FieldDispatchHistory.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (FieldDispatchHistory.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (FieldDispatchHistory.fields (position), x))
        emitattr (0, Crew)
        emitattrs (1, FieldDispatchStep)
        emitattr (2, PlannedOutage)
        emitattr (3, UnplannedOutage)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:FieldDispatchHistory rdf:ID=\"%s\">\n%s\t</cim:FieldDispatchHistory>".format (id, export_fields)
    }
}

object FieldDispatchHistory
extends
    Parseable[FieldDispatchHistory]
{
    override val fields: Array[String] = Array[String] (
        "Crew",
        "FieldDispatchStep",
        "PlannedOutage",
        "UnplannedOutage"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Crew", "Crew", "0..1", "0..*"),
        Relationship ("FieldDispatchStep", "FieldDispatchStep", "0..*", "1"),
        Relationship ("PlannedOutage", "PlannedOutage", "0..1", "0..1"),
        Relationship ("UnplannedOutage", "UnplannedOutage", "0..1", "0..1")
    )
    val Crew: Fielder = parse_attribute (attribute (cls, fields(0)))
    val FieldDispatchStep: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val PlannedOutage: Fielder = parse_attribute (attribute (cls, fields(2)))
    val UnplannedOutage: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): FieldDispatchHistory =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = FieldDispatchHistory (
            IdentifiedObject.parse (context),
            mask (Crew (), 0),
            masks (FieldDispatchStep (), 1),
            mask (PlannedOutage (), 2),
            mask (UnplannedOutage (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Details of the step in the field dispatch history.
 *
 * @param sup Reference to the superclass object.
 * @param dispatchStatus The status of one or more crews dispatched to perform field work at one or more work sites
 * @param occurredDateTime The date and time at which the dispatch status occurred.
 * @param remarks freeform comments related to the dispatch to perform field work.
 * @param sequenceNumber The sequence number of the field dispatch step within the field dispatch history.
 *        Begins with 1 and increments up.
 * @param FieldDispatchHistory [[ch.ninecode.model.FieldDispatchHistory FieldDispatchHistory]] <em>undocumented</em>
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class FieldDispatchStep
(
    override val sup: BasicElement,
    dispatchStatus: String,
    occurredDateTime: String,
    remarks: String,
    sequenceNumber: Int,
    FieldDispatchHistory: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, 0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[FieldDispatchStep] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = FieldDispatchStep.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (FieldDispatchStep.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (FieldDispatchStep.fields (position), value)
        emitattr (0, dispatchStatus)
        emitelem (1, occurredDateTime)
        emitelem (2, remarks)
        emitelem (3, sequenceNumber)
        emitattr (4, FieldDispatchHistory)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:FieldDispatchStep rdf:ID=\"%s\">\n%s\t</cim:FieldDispatchStep>".format (id, export_fields)
    }
}

object FieldDispatchStep
extends
    Parseable[FieldDispatchStep]
{
    override val fields: Array[String] = Array[String] (
        "dispatchStatus",
        "occurredDateTime",
        "remarks",
        "sequenceNumber",
        "FieldDispatchHistory"
    )
    override val relations: List[Relationship] = List (
        Relationship ("FieldDispatchHistory", "FieldDispatchHistory", "1", "0..*")
    )
    val dispatchStatus: Fielder = parse_attribute (attribute (cls, fields(0)))
    val occurredDateTime: Fielder = parse_element (element (cls, fields(1)))
    val remarks: Fielder = parse_element (element (cls, fields(2)))
    val sequenceNumber: Fielder = parse_element (element (cls, fields(3)))
    val FieldDispatchHistory: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): FieldDispatchStep =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = FieldDispatchStep (
            BasicElement.parse (context),
            mask (dispatchStatus (), 0),
            mask (occurredDateTime (), 1),
            mask (remarks (), 2),
            toInteger (mask (sequenceNumber (), 3)),
            mask (FieldDispatchHistory (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * An object or a condition that is a danger for causing loss or perils to an asset and/or people.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param status [[ch.ninecode.model.Status Status]] Status of this hazard.
 * @param type Type of this hazard.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class Hazard
(
    override val sup: IdentifiedObject,
    status: String,
    `type`: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Hazard] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Hazard.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Hazard.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Hazard.fields (position), value)
        emitattr (0, status)
        emitelem (1, `type`)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Hazard rdf:ID=\"%s\">\n%s\t</cim:Hazard>".format (id, export_fields)
    }
}

object Hazard
extends
    Parseable[Hazard]
{
    override val fields: Array[String] = Array[String] (
        "status",
        "type"
    )
    override val relations: List[Relationship] = List (
        Relationship ("status", "Status", "0..1", "0..*")
    )
    val status: Fielder = parse_attribute (attribute (cls, fields(0)))
    val `type`: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: Context): Hazard =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Hazard (
            IdentifiedObject.parse (context),
            mask (status (), 0),
            mask (`type` (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Person who issued the document and is responsible for its content.
 *
 * @param sup [[ch.ninecode.model.DocumentPersonRole DocumentPersonRole]] Reference to the superclass object.
 * @param Documents [[ch.ninecode.model.Document Document]] All documents for this issuer.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class Issuer
(
    override val sup: DocumentPersonRole,
    Documents: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def DocumentPersonRole: DocumentPersonRole = sup.asInstanceOf[DocumentPersonRole]
    override def copy (): Row = { clone ().asInstanceOf[Issuer] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Issuer.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Issuer.fields (position), x))
        emitattrs (0, Documents)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Issuer rdf:ID=\"%s\">\n%s\t</cim:Issuer>".format (id, export_fields)
    }
}

object Issuer
extends
    Parseable[Issuer]
{
    override val fields: Array[String] = Array[String] (
        "Documents"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Documents", "Document", "0..*", "0..1")
    )
    val Documents: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): Issuer =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Issuer (
            DocumentPersonRole.parse (context),
            masks (Documents (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The place, scene, or point of something where someone or something has been, is, and/or will be at a given moment in time.
 *
 * It can be defined with one or more postition points (coordinates) in a given coordinate system.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param direction (if applicable) Direction that allows field crews to quickly find a given asset.
 *        For a given location, such as a street address, this is the relative direction in which to find the asset. For example, a streetlight may be located at the 'NW' (northwest) corner of the customer's site, or a usage point may be located on the second floor of an apartment building.
 * @param electronicAddress [[ch.ninecode.model.ElectronicAddress ElectronicAddress]] Electronic address.
 * @param geoInfoReference (if applicable) Reference to geographical information source, often external to the utility.
 * @param mainAddress [[ch.ninecode.model.StreetAddress StreetAddress]] Main address of the location.
 * @param phone1 [[ch.ninecode.model.TelephoneNumber TelephoneNumber]] Phone number.
 * @param phone2 [[ch.ninecode.model.TelephoneNumber TelephoneNumber]] Additional phone number.
 * @param secondaryAddress [[ch.ninecode.model.StreetAddress StreetAddress]] Secondary address of the location.
 *        For example, PO Box address may have different ZIP code than that in the 'mainAddress'.
 * @param status [[ch.ninecode.model.Status Status]] Status of this location.
 * @param type Classification by utility's corporate standards and practices, relative to the location itself (e.g., geographical, functional accounting, etc., not a given property that happens to exist at that location).
 * @param Assets [[ch.ninecode.model.Asset Asset]] All assets at this location.
 * @param ConfigurationEvents [[ch.ninecode.model.ConfigurationEvent ConfigurationEvent]] All configuration events created for this location.
 * @param CoordinateSystem [[ch.ninecode.model.CoordinateSystem CoordinateSystem]] Coordinate system used to describe position points of this location.
 * @param Crew [[ch.ninecode.model.Crew Crew]] <em>undocumented</em>
 * @param Crews [[ch.ninecode.model.OldCrew OldCrew]] <em>undocumented</em>
 * @param EnvironmentalLocationKind [[ch.ninecode.model.EnvironmentalLocationType EnvironmentalLocationType]] Kind of environmental location which this location is.
 * @param EnvironmentalMonitoringStation [[ch.ninecode.model.EnvironmentalMonitoringStation EnvironmentalMonitoringStation]] Monitoring station located at this location.
 * @param Fault [[ch.ninecode.model.Fault Fault]] <em>undocumented</em>
 * @param Hazards [[ch.ninecode.model.AssetLocationHazard AssetLocationHazard]] All asset hazards at this location.
 * @param Incident [[ch.ninecode.model.Incident Incident]] Incident at this location.
 * @param LandProperties [[ch.ninecode.model.LandProperty LandProperty]] <em>undocumented</em>
 * @param Measurements [[ch.ninecode.model.Measurement Measurement]] <em>undocumented</em>
 * @param OutageOrder [[ch.ninecode.model.OutageOrder OutageOrder]] <em>undocumented</em>
 * @param PositionPoints [[ch.ninecode.model.PositionPoint PositionPoint]] Sequence of position points describing this location, expressed in coordinate system 'Location.
 *        CoordinateSystem'.
 * @param PowerSystemResources [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] All power system resources at this location.
 * @param Routes [[ch.ninecode.model.Route Route]] <em>undocumented</em>
 * @param SwitchingOrder [[ch.ninecode.model.SwitchingOrder SwitchingOrder]] <em>undocumented</em>
 * @param TroubleOrder [[ch.ninecode.model.TroubleOrder TroubleOrder]] <em>undocumented</em>
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class Location
(
    override val sup: IdentifiedObject,
    direction: String,
    electronicAddress: String,
    geoInfoReference: String,
    mainAddress: String,
    phone1: String,
    phone2: String,
    secondaryAddress: String,
    status: String,
    `type`: String,
    Assets: List[String],
    ConfigurationEvents: List[String],
    CoordinateSystem: String,
    Crew: List[String],
    Crews: List[String],
    EnvironmentalLocationKind: List[String],
    EnvironmentalMonitoringStation: List[String],
    Fault: List[String],
    Hazards: List[String],
    Incident: String,
    LandProperties: List[String],
    Measurements: List[String],
    OutageOrder: String,
    PositionPoints: List[String],
    PowerSystemResources: List[String],
    Routes: List[String],
    SwitchingOrder: String,
    TroubleOrder: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null, null, null, null, List(), List(), null, List(), List(), List(), List(), List(), List(), null, List(), List(), null, List(), List(), List(), null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Location] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Location.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Location.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Location.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Location.fields (position), x))
        emitelem (0, direction)
        emitattr (1, electronicAddress)
        emitelem (2, geoInfoReference)
        emitattr (3, mainAddress)
        emitattr (4, phone1)
        emitattr (5, phone2)
        emitattr (6, secondaryAddress)
        emitattr (7, status)
        emitelem (8, `type`)
        emitattrs (9, Assets)
        emitattrs (10, ConfigurationEvents)
        emitattr (11, CoordinateSystem)
        emitattrs (12, Crew)
        emitattrs (13, Crews)
        emitattrs (14, EnvironmentalLocationKind)
        emitattrs (15, EnvironmentalMonitoringStation)
        emitattrs (16, Fault)
        emitattrs (17, Hazards)
        emitattr (18, Incident)
        emitattrs (19, LandProperties)
        emitattrs (20, Measurements)
        emitattr (21, OutageOrder)
        emitattrs (22, PositionPoints)
        emitattrs (23, PowerSystemResources)
        emitattrs (24, Routes)
        emitattr (25, SwitchingOrder)
        emitattr (26, TroubleOrder)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Location rdf:ID=\"%s\">\n%s\t</cim:Location>".format (id, export_fields)
    }
}

object Location
extends
    Parseable[Location]
{
    override val fields: Array[String] = Array[String] (
        "direction",
        "electronicAddress",
        "geoInfoReference",
        "mainAddress",
        "phone1",
        "phone2",
        "secondaryAddress",
        "status",
        "type",
        "Assets",
        "ConfigurationEvents",
        "CoordinateSystem",
        "Crew",
        "Crews",
        "EnvironmentalLocationKind",
        "EnvironmentalMonitoringStation",
        "Fault",
        "Hazards",
        "Incident",
        "LandProperties",
        "Measurements",
        "OutageOrder",
        "PositionPoints",
        "PowerSystemResources",
        "Routes",
        "SwitchingOrder",
        "TroubleOrder"
    )
    override val relations: List[Relationship] = List (
        Relationship ("electronicAddress", "ElectronicAddress", "0..1", "0..*"),
        Relationship ("mainAddress", "StreetAddress", "0..1", "0..*"),
        Relationship ("phone1", "TelephoneNumber", "0..1", "0..*"),
        Relationship ("phone2", "TelephoneNumber", "0..1", "0..*"),
        Relationship ("secondaryAddress", "StreetAddress", "0..1", "0..*"),
        Relationship ("status", "Status", "0..1", "0..*"),
        Relationship ("Assets", "Asset", "0..*", "0..1"),
        Relationship ("ConfigurationEvents", "ConfigurationEvent", "0..*", "0..1"),
        Relationship ("CoordinateSystem", "CoordinateSystem", "0..1", "0..*"),
        Relationship ("Crew", "Crew", "0..*", "0..1"),
        Relationship ("Crews", "OldCrew", "0..*", "0..*"),
        Relationship ("EnvironmentalLocationKind", "EnvironmentalLocationType", "0..*", "0..1"),
        Relationship ("EnvironmentalMonitoringStation", "EnvironmentalMonitoringStation", "0..*", "0..1"),
        Relationship ("Fault", "Fault", "0..*", "0..1"),
        Relationship ("Hazards", "AssetLocationHazard", "0..*", "0..*"),
        Relationship ("Incident", "Incident", "0..1", "0..1"),
        Relationship ("LandProperties", "LandProperty", "0..*", "0..*"),
        Relationship ("Measurements", "Measurement", "0..*", "0..*"),
        Relationship ("OutageOrder", "OutageOrder", "0..1", "0..*"),
        Relationship ("PositionPoints", "PositionPoint", "0..*", "1"),
        Relationship ("PowerSystemResources", "PowerSystemResource", "0..*", "0..1"),
        Relationship ("Routes", "Route", "0..*", "0..*"),
        Relationship ("SwitchingOrder", "SwitchingOrder", "0..1", "0..*"),
        Relationship ("TroubleOrder", "TroubleOrder", "0..1", "0..1")
    )
    val direction: Fielder = parse_element (element (cls, fields(0)))
    val electronicAddress: Fielder = parse_attribute (attribute (cls, fields(1)))
    val geoInfoReference: Fielder = parse_element (element (cls, fields(2)))
    val mainAddress: Fielder = parse_attribute (attribute (cls, fields(3)))
    val phone1: Fielder = parse_attribute (attribute (cls, fields(4)))
    val phone2: Fielder = parse_attribute (attribute (cls, fields(5)))
    val secondaryAddress: Fielder = parse_attribute (attribute (cls, fields(6)))
    val status: Fielder = parse_attribute (attribute (cls, fields(7)))
    val `type`: Fielder = parse_element (element (cls, fields(8)))
    val Assets: FielderMultiple = parse_attributes (attribute (cls, fields(9)))
    val ConfigurationEvents: FielderMultiple = parse_attributes (attribute (cls, fields(10)))
    val CoordinateSystem: Fielder = parse_attribute (attribute (cls, fields(11)))
    val Crew: FielderMultiple = parse_attributes (attribute (cls, fields(12)))
    val Crews: FielderMultiple = parse_attributes (attribute (cls, fields(13)))
    val EnvironmentalLocationKind: FielderMultiple = parse_attributes (attribute (cls, fields(14)))
    val EnvironmentalMonitoringStation: FielderMultiple = parse_attributes (attribute (cls, fields(15)))
    val Fault: FielderMultiple = parse_attributes (attribute (cls, fields(16)))
    val Hazards: FielderMultiple = parse_attributes (attribute (cls, fields(17)))
    val Incident: Fielder = parse_attribute (attribute (cls, fields(18)))
    val LandProperties: FielderMultiple = parse_attributes (attribute (cls, fields(19)))
    val Measurements: FielderMultiple = parse_attributes (attribute (cls, fields(20)))
    val OutageOrder: Fielder = parse_attribute (attribute (cls, fields(21)))
    val PositionPoints: FielderMultiple = parse_attributes (attribute (cls, fields(22)))
    val PowerSystemResources: FielderMultiple = parse_attributes (attribute (cls, fields(23)))
    val Routes: FielderMultiple = parse_attributes (attribute (cls, fields(24)))
    val SwitchingOrder: Fielder = parse_attribute (attribute (cls, fields(25)))
    val TroubleOrder: Fielder = parse_attribute (attribute (cls, fields(26)))

    def parse (context: Context): Location =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Location (
            IdentifiedObject.parse (context),
            mask (direction (), 0),
            mask (electronicAddress (), 1),
            mask (geoInfoReference (), 2),
            mask (mainAddress (), 3),
            mask (phone1 (), 4),
            mask (phone2 (), 5),
            mask (secondaryAddress (), 6),
            mask (status (), 7),
            mask (`type` (), 8),
            masks (Assets (), 9),
            masks (ConfigurationEvents (), 10),
            mask (CoordinateSystem (), 11),
            masks (Crew (), 12),
            masks (Crews (), 13),
            masks (EnvironmentalLocationKind (), 14),
            masks (EnvironmentalMonitoringStation (), 15),
            masks (Fault (), 16),
            masks (Hazards (), 17),
            mask (Incident (), 18),
            masks (LandProperties (), 19),
            masks (Measurements (), 20),
            mask (OutageOrder (), 21),
            masks (PositionPoints (), 22),
            masks (PowerSystemResources (), 23),
            masks (Routes (), 24),
            mask (SwitchingOrder (), 25),
            mask (TroubleOrder (), 26)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Person role in the context of utility operations.
 *
 * @param sup [[ch.ninecode.model.PersonRole PersonRole]] Reference to the superclass object.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class OperationPersonRole
(
    override val sup: PersonRole
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PersonRole: PersonRole = sup.asInstanceOf[PersonRole]
    override def copy (): Row = { clone ().asInstanceOf[OperationPersonRole] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:OperationPersonRole rdf:ID=\"%s\">\n%s\t</cim:OperationPersonRole>".format (id, export_fields)
    }
}

object OperationPersonRole
extends
    Parseable[OperationPersonRole]
{

    def parse (context: Context): OperationPersonRole =
    {
        implicit val ctx: Context = context
        val ret = OperationPersonRole (
            PersonRole.parse (context)
        )
        ret
    }
}

/**
 * Control room operator.
 *
 * @param sup [[ch.ninecode.model.OperationPersonRole OperationPersonRole]] Reference to the superclass object.
 * @param Incidents [[ch.ninecode.model.Incident Incident]] All incidents owned by this operator.
 * @param SwitchingSteps [[ch.ninecode.model.SwitchingAction SwitchingAction]] All switching steps this operator is responsible for.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class Operator
(
    override val sup: OperationPersonRole,
    Incidents: List[String],
    SwitchingSteps: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def OperationPersonRole: OperationPersonRole = sup.asInstanceOf[OperationPersonRole]
    override def copy (): Row = { clone ().asInstanceOf[Operator] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Operator.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Operator.fields (position), x))
        emitattrs (0, Incidents)
        emitattrs (1, SwitchingSteps)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Operator rdf:ID=\"%s\">\n%s\t</cim:Operator>".format (id, export_fields)
    }
}

object Operator
extends
    Parseable[Operator]
{
    override val fields: Array[String] = Array[String] (
        "Incidents",
        "SwitchingSteps"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Incidents", "Incident", "0..*", "0..1"),
        Relationship ("SwitchingSteps", "SwitchingAction", "0..*", "0..1")
    )
    val Incidents: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val SwitchingSteps: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): Operator =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Operator (
            OperationPersonRole.parse (context),
            masks (Incidents (), 0),
            masks (SwitchingSteps (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Organisation that might have roles as utility, contractor, supplier, manufacturer, customer, etc.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param electronicAddress [[ch.ninecode.model.ElectronicAddress ElectronicAddress]] Electronic address.
 * @param phone1 [[ch.ninecode.model.TelephoneNumber TelephoneNumber]] Phone number.
 * @param phone2 [[ch.ninecode.model.TelephoneNumber TelephoneNumber]] Additional phone number.
 * @param postalAddress [[ch.ninecode.model.StreetAddress StreetAddress]] Postal address, potentially different than 'streetAddress' (e.g., another city).
 * @param streetAddress [[ch.ninecode.model.StreetAddress StreetAddress]] Street address.
 * @param ParentOrganisation [[ch.ninecode.model.ParentOrganization ParentOrganization]] Parent organisation of this organisation.
 * @param Roles [[ch.ninecode.model.OrganisationRole OrganisationRole]] All roles of this organisation.
 * @param SwitchingPlanRequest [[ch.ninecode.model.SwitchingPlanRequest SwitchingPlanRequest]] <em>undocumented</em>
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class Organisation
(
    override val sup: IdentifiedObject,
    electronicAddress: String,
    phone1: String,
    phone2: String,
    postalAddress: String,
    streetAddress: String,
    ParentOrganisation: String,
    Roles: List[String],
    SwitchingPlanRequest: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null, List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Organisation] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Organisation.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Organisation.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Organisation.fields (position), x))
        emitattr (0, electronicAddress)
        emitattr (1, phone1)
        emitattr (2, phone2)
        emitattr (3, postalAddress)
        emitattr (4, streetAddress)
        emitattr (5, ParentOrganisation)
        emitattrs (6, Roles)
        emitattrs (7, SwitchingPlanRequest)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Organisation rdf:ID=\"%s\">\n%s\t</cim:Organisation>".format (id, export_fields)
    }
}

object Organisation
extends
    Parseable[Organisation]
{
    override val fields: Array[String] = Array[String] (
        "electronicAddress",
        "phone1",
        "phone2",
        "postalAddress",
        "streetAddress",
        "ParentOrganisation",
        "Roles",
        "SwitchingPlanRequest"
    )
    override val relations: List[Relationship] = List (
        Relationship ("electronicAddress", "ElectronicAddress", "0..1", "0..*"),
        Relationship ("phone1", "TelephoneNumber", "0..1", "0..*"),
        Relationship ("phone2", "TelephoneNumber", "0..1", "0..*"),
        Relationship ("postalAddress", "StreetAddress", "0..1", "0..*"),
        Relationship ("streetAddress", "StreetAddress", "0..1", "0..*"),
        Relationship ("ParentOrganisation", "ParentOrganization", "0..1", "0..*"),
        Relationship ("Roles", "OrganisationRole", "0..*", "0..1"),
        Relationship ("SwitchingPlanRequest", "SwitchingPlanRequest", "0..*", "0..1")
    )
    val electronicAddress: Fielder = parse_attribute (attribute (cls, fields(0)))
    val phone1: Fielder = parse_attribute (attribute (cls, fields(1)))
    val phone2: Fielder = parse_attribute (attribute (cls, fields(2)))
    val postalAddress: Fielder = parse_attribute (attribute (cls, fields(3)))
    val streetAddress: Fielder = parse_attribute (attribute (cls, fields(4)))
    val ParentOrganisation: Fielder = parse_attribute (attribute (cls, fields(5)))
    val Roles: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val SwitchingPlanRequest: FielderMultiple = parse_attributes (attribute (cls, fields(7)))

    def parse (context: Context): Organisation =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Organisation (
            IdentifiedObject.parse (context),
            mask (electronicAddress (), 0),
            mask (phone1 (), 1),
            mask (phone2 (), 2),
            mask (postalAddress (), 3),
            mask (streetAddress (), 4),
            mask (ParentOrganisation (), 5),
            masks (Roles (), 6),
            masks (SwitchingPlanRequest (), 7)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Identifies a way in which an organisation may participate in the utility enterprise (e.g., customer, manufacturer, etc).
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param ConfigurationEvents [[ch.ninecode.model.ConfigurationEvent ConfigurationEvent]] All configuration events created for this organisation role.
 * @param Organisation [[ch.ninecode.model.Organisation Organisation]] Organisation having this role.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class OrganisationRole
(
    override val sup: IdentifiedObject,
    ConfigurationEvents: List[String],
    Organisation: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List(), null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[OrganisationRole] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = OrganisationRole.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OrganisationRole.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (OrganisationRole.fields (position), x))
        emitattrs (0, ConfigurationEvents)
        emitattr (1, Organisation)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OrganisationRole rdf:ID=\"%s\">\n%s\t</cim:OrganisationRole>".format (id, export_fields)
    }
}

object OrganisationRole
extends
    Parseable[OrganisationRole]
{
    override val fields: Array[String] = Array[String] (
        "ConfigurationEvents",
        "Organisation"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ConfigurationEvents", "ConfigurationEvent", "0..*", "0..1"),
        Relationship ("Organisation", "Organisation", "0..1", "0..*")
    )
    val ConfigurationEvents: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val Organisation: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): OrganisationRole =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OrganisationRole (
            IdentifiedObject.parse (context),
            masks (ConfigurationEvents (), 0),
            mask (Organisation (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Ownership of e.g. asset.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param share Share of this ownership.
 * @param Asset [[ch.ninecode.model.Asset Asset]] Asset that is object of this ownership.
 * @param AssetOwner [[ch.ninecode.model.AssetOwner AssetOwner]] Asset owner that is subject in this ownership.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class Ownership
(
    override val sup: IdentifiedObject,
    share: Double,
    Asset: String,
    AssetOwner: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Ownership] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Ownership.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Ownership.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Ownership.fields (position), value)
        emitelem (0, share)
        emitattr (1, Asset)
        emitattr (2, AssetOwner)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Ownership rdf:ID=\"%s\">\n%s\t</cim:Ownership>".format (id, export_fields)
    }
}

object Ownership
extends
    Parseable[Ownership]
{
    override val fields: Array[String] = Array[String] (
        "share",
        "Asset",
        "AssetOwner"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Asset", "Asset", "0..1", "0..*"),
        Relationship ("AssetOwner", "AssetOwner", "0..1", "0..*")
    )
    val share: Fielder = parse_element (element (cls, fields(0)))
    val Asset: Fielder = parse_attribute (attribute (cls, fields(1)))
    val AssetOwner: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): Ownership =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Ownership (
            IdentifiedObject.parse (context),
            toDouble (mask (share (), 0)),
            mask (Asset (), 1),
            mask (AssetOwner (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class ParentOrganization
(
    override val sup: Organisation,
    Organisation_attr: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Organisation: Organisation = sup.asInstanceOf[Organisation]
    override def copy (): Row = { clone ().asInstanceOf[ParentOrganization] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ParentOrganization.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ParentOrganization.fields (position), x))
        emitattrs (0, Organisation_attr)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ParentOrganization rdf:ID=\"%s\">\n%s\t</cim:ParentOrganization>".format (id, export_fields)
    }
}

object ParentOrganization
extends
    Parseable[ParentOrganization]
{
    override val fields: Array[String] = Array[String] (
        "Organisation"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Organisation_attr", "Organisation", "0..*", "0..1")
    )
    val Organisation_attr: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): ParentOrganization =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ParentOrganization (
            Organisation.parse (context),
            masks (Organisation_attr (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * General purpose information for name and other information to contact people.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param electronicAddress [[ch.ninecode.model.ElectronicAddress ElectronicAddress]] Electronic address.
 * @param firstName Person's first name.
 * @param landlinePhone [[ch.ninecode.model.TelephoneNumber TelephoneNumber]] Landline phone number.
 * @param lastName Person's last (family, sir) name.
 * @param mName Middle name(s) or initial(s).
 * @param mobilePhone [[ch.ninecode.model.TelephoneNumber TelephoneNumber]] Mobile phone number.
 * @param prefix A prefix or title for the person's name, such as Miss, Mister, Doctor, etc.
 * @param specialNeed Special service needs for the person (contact) are described; examples include life support, etc.
 * @param suffix A suffix for the person's name, such as II, III, etc.
 * @param Roles [[ch.ninecode.model.PersonRole PersonRole]] All roles of this person.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class Person
(
    override val sup: IdentifiedObject,
    electronicAddress: String,
    firstName: String,
    landlinePhone: String,
    lastName: String,
    mName: String,
    mobilePhone: String,
    prefix: String,
    specialNeed: String,
    suffix: String,
    Roles: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null, null, null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Person] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Person.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Person.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Person.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Person.fields (position), x))
        emitattr (0, electronicAddress)
        emitelem (1, firstName)
        emitattr (2, landlinePhone)
        emitelem (3, lastName)
        emitelem (4, mName)
        emitattr (5, mobilePhone)
        emitelem (6, prefix)
        emitelem (7, specialNeed)
        emitelem (8, suffix)
        emitattrs (9, Roles)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Person rdf:ID=\"%s\">\n%s\t</cim:Person>".format (id, export_fields)
    }
}

object Person
extends
    Parseable[Person]
{
    override val fields: Array[String] = Array[String] (
        "electronicAddress",
        "firstName",
        "landlinePhone",
        "lastName",
        "mName",
        "mobilePhone",
        "prefix",
        "specialNeed",
        "suffix",
        "Roles"
    )
    override val relations: List[Relationship] = List (
        Relationship ("electronicAddress", "ElectronicAddress", "0..1", "0..*"),
        Relationship ("landlinePhone", "TelephoneNumber", "0..1", "0..*"),
        Relationship ("mobilePhone", "TelephoneNumber", "0..1", "0..*"),
        Relationship ("Roles", "PersonRole", "0..*", "0..1")
    )
    val electronicAddress: Fielder = parse_attribute (attribute (cls, fields(0)))
    val firstName: Fielder = parse_element (element (cls, fields(1)))
    val landlinePhone: Fielder = parse_attribute (attribute (cls, fields(2)))
    val lastName: Fielder = parse_element (element (cls, fields(3)))
    val mName: Fielder = parse_element (element (cls, fields(4)))
    val mobilePhone: Fielder = parse_attribute (attribute (cls, fields(5)))
    val prefix: Fielder = parse_element (element (cls, fields(6)))
    val specialNeed: Fielder = parse_element (element (cls, fields(7)))
    val suffix: Fielder = parse_element (element (cls, fields(8)))
    val Roles: FielderMultiple = parse_attributes (attribute (cls, fields(9)))

    def parse (context: Context): Person =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Person (
            IdentifiedObject.parse (context),
            mask (electronicAddress (), 0),
            mask (firstName (), 1),
            mask (landlinePhone (), 2),
            mask (lastName (), 3),
            mask (mName (), 4),
            mask (mobilePhone (), 5),
            mask (prefix (), 6),
            mask (specialNeed (), 7),
            mask (suffix (), 8),
            masks (Roles (), 9)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class PersonRole
(
    override val sup: IdentifiedObject,
    Appointments: List[String],
    ConfigurationEvents: List[String],
    Person: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List(), List(), null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[PersonRole] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PersonRole.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PersonRole.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (PersonRole.fields (position), x))
        emitattrs (0, Appointments)
        emitattrs (1, ConfigurationEvents)
        emitattr (2, Person)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PersonRole rdf:ID=\"%s\">\n%s\t</cim:PersonRole>".format (id, export_fields)
    }
}

object PersonRole
extends
    Parseable[PersonRole]
{
    override val fields: Array[String] = Array[String] (
        "Appointments",
        "ConfigurationEvents",
        "Person"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Appointments", "Appointment", "0..*", "0..*"),
        Relationship ("ConfigurationEvents", "ConfigurationEvent", "0..*", "0..1"),
        Relationship ("Person", "Person", "0..1", "0..*")
    )
    val Appointments: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val ConfigurationEvents: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val Person: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): PersonRole =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PersonRole (
            IdentifiedObject.parse (context),
            masks (Appointments (), 0),
            masks (ConfigurationEvents (), 1),
            mask (Person (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Set of spatial coordinates that determine a point, defined in the coordinate system specified in 'Location.
 *
 * CoordinateSystem'. Use a single position point instance to desribe a point-oriented location. Use a sequence of position points to describe a line-oriented object (physical location of non-point oriented objects like cables or lines), or area of an object (like a substation or a geographical zone - in this case, have first and last position point with the same values).
 *
 * @param sup Reference to the superclass object.
 * @param groupNumber Zero-relative sequence number of this group within a series of points; used when there is a need to express disjoint groups of points that are considered to be part of a single location.
 * @param sequenceNumber Zero-relative sequence number of this point within a series of points.
 * @param xPosition X axis position.
 * @param yPosition Y axis position.
 * @param zPosition (if applicable) Z axis position.
 * @param Location [[ch.ninecode.model.Location Location]] Location described by this position point.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class PositionPoint
(
    override val sup: BasicElement,
    groupNumber: Int,
    sequenceNumber: Int,
    xPosition: String,
    yPosition: String,
    zPosition: String,
    Location: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0, 0, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[PositionPoint] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PositionPoint.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PositionPoint.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PositionPoint.fields (position), value)
        emitelem (0, groupNumber)
        emitelem (1, sequenceNumber)
        emitelem (2, xPosition)
        emitelem (3, yPosition)
        emitelem (4, zPosition)
        emitattr (5, Location)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PositionPoint rdf:ID=\"%s\">\n%s\t</cim:PositionPoint>".format (id, export_fields)
    }
}

object PositionPoint
extends
    Parseable[PositionPoint]
{
    override val fields: Array[String] = Array[String] (
        "groupNumber",
        "sequenceNumber",
        "xPosition",
        "yPosition",
        "zPosition",
        "Location"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Location", "Location", "1", "0..*")
    )
    val groupNumber: Fielder = parse_element (element (cls, fields(0)))
    val sequenceNumber: Fielder = parse_element (element (cls, fields(1)))
    val xPosition: Fielder = parse_element (element (cls, fields(2)))
    val yPosition: Fielder = parse_element (element (cls, fields(3)))
    val zPosition: Fielder = parse_element (element (cls, fields(4)))
    val Location: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: Context): PositionPoint =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PositionPoint (
            BasicElement.parse (context),
            toInteger (mask (groupNumber (), 0)),
            toInteger (mask (sequenceNumber (), 1)),
            mask (xPosition (), 2),
            mask (yPosition (), 3),
            mask (zPosition (), 4),
            mask (Location (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Priority definition.
 *
 * @param sup Reference to the superclass object.
 * @param justification Justification for 'rank'.
 * @param rank Priority level; usually, lower number means high priority, but the details are provided in 'type'.
 * @param type Type describing 'rank'; e.g., high, emergency, etc.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class Priority
(
    override val sup: BasicElement,
    justification: String,
    rank: Int,
    `type`: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[Priority] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Priority.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Priority.fields (position), value)
        emitelem (0, justification)
        emitelem (1, rank)
        emitelem (2, `type`)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Priority rdf:ID=\"%s\">\n%s\t</cim:Priority>".format (id, export_fields)
    }
}

object Priority
extends
    Parseable[Priority]
{
    override val fields: Array[String] = Array[String] (
        "justification",
        "rank",
        "type"
    )
    val justification: Fielder = parse_element (element (cls, fields(0)))
    val rank: Fielder = parse_element (element (cls, fields(1)))
    val `type`: Fielder = parse_element (element (cls, fields(2)))

    def parse (context: Context): Priority =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Priority (
            BasicElement.parse (context),
            mask (justification (), 0),
            toInteger (mask (rank (), 1)),
            mask (`type` (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * An event to trigger one or more activities, such as reading a meter, recalculating a bill, requesting work, when generating units must be scheduled for maintenance, when a transformer is scheduled to be refurbished, etc.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param duration Duration of the scheduled event, for example, the time to ramp between values.
 * @param status [[ch.ninecode.model.Status Status]] <em>undocumented</em>
 * @param type Type of scheduled event.
 * @param Assets [[ch.ninecode.model.Asset Asset]] <em>undocumented</em>
 * @param ScheduledEventData [[ch.ninecode.model.ScheduledEventData ScheduledEventData]] Specification for this scheduled event.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class ScheduledEvent
(
    override val sup: IdentifiedObject,
    duration: Double,
    status: String,
    `type`: String,
    Assets: List[String],
    ScheduledEventData: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, null, List(), null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ScheduledEvent] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ScheduledEvent.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ScheduledEvent.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ScheduledEvent.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ScheduledEvent.fields (position), x))
        emitelem (0, duration)
        emitattr (1, status)
        emitelem (2, `type`)
        emitattrs (3, Assets)
        emitattr (4, ScheduledEventData)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ScheduledEvent rdf:ID=\"%s\">\n%s\t</cim:ScheduledEvent>".format (id, export_fields)
    }
}

object ScheduledEvent
extends
    Parseable[ScheduledEvent]
{
    override val fields: Array[String] = Array[String] (
        "duration",
        "status",
        "type",
        "Assets",
        "ScheduledEventData"
    )
    override val relations: List[Relationship] = List (
        Relationship ("status", "Status", "0..1", "0..*"),
        Relationship ("Assets", "Asset", "0..*", "0..*"),
        Relationship ("ScheduledEventData", "ScheduledEventData", "0..1", "0..*")
    )
    val duration: Fielder = parse_element (element (cls, fields(0)))
    val status: Fielder = parse_attribute (attribute (cls, fields(1)))
    val `type`: Fielder = parse_element (element (cls, fields(2)))
    val Assets: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val ScheduledEventData: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): ScheduledEvent =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ScheduledEvent (
            IdentifiedObject.parse (context),
            toDouble (mask (duration (), 0)),
            mask (status (), 1),
            mask (`type` (), 2),
            masks (Assets (), 3),
            mask (ScheduledEventData (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Schedule parameters for an activity that is to occur, is occurring, or has completed.
 *
 * @param sup Reference to the superclass object.
 * @param estimatedWindow Estimated date and time for activity execution (with earliest possibility of activity initiation and latest possibility of activity completion).
 * @param requestedWindow Requested date and time interval for activity execution.
 * @param status [[ch.ninecode.model.Status Status]] <em>undocumented</em>
 * @param InspectionDataSet [[ch.ninecode.model.InspectionDataSet InspectionDataSet]] <em>undocumented</em>
 * @param ScheduledEvents [[ch.ninecode.model.ScheduledEvent ScheduledEvent]] All scheduled events with this specification.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class ScheduledEventData
(
    override val sup: BasicElement,
    estimatedWindow: String,
    requestedWindow: String,
    status: String,
    InspectionDataSet: String,
    ScheduledEvents: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ScheduledEventData] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ScheduledEventData.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ScheduledEventData.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ScheduledEventData.fields (position), x))
        emitattr (0, estimatedWindow)
        emitattr (1, requestedWindow)
        emitattr (2, status)
        emitattr (3, InspectionDataSet)
        emitattrs (4, ScheduledEvents)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ScheduledEventData rdf:ID=\"%s\">\n%s\t</cim:ScheduledEventData>".format (id, export_fields)
    }
}

object ScheduledEventData
extends
    Parseable[ScheduledEventData]
{
    override val fields: Array[String] = Array[String] (
        "estimatedWindow",
        "requestedWindow",
        "status",
        "InspectionDataSet",
        "ScheduledEvents"
    )
    override val relations: List[Relationship] = List (
        Relationship ("status", "Status", "0..1", "0..*"),
        Relationship ("InspectionDataSet", "InspectionDataSet", "1", "0..*"),
        Relationship ("ScheduledEvents", "ScheduledEvent", "0..*", "0..1")
    )
    val estimatedWindow: Fielder = parse_attribute (attribute (cls, fields(0)))
    val requestedWindow: Fielder = parse_attribute (attribute (cls, fields(1)))
    val status: Fielder = parse_attribute (attribute (cls, fields(2)))
    val InspectionDataSet: Fielder = parse_attribute (attribute (cls, fields(3)))
    val ScheduledEvents: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: Context): ScheduledEventData =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ScheduledEventData (
            BasicElement.parse (context),
            mask (estimatedWindow (), 0),
            mask (requestedWindow (), 1),
            mask (status (), 2),
            mask (InspectionDataSet (), 3),
            masks (ScheduledEvents (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Current status information relevant to an entity.
 *
 * @param sup Reference to the superclass object.
 * @param dateTime Date and time for which status 'value' applies.
 * @param reason Reason code or explanation for why an object went to the current status 'value'.
 * @param remark Pertinent information regarding the current 'value', as free form text.
 * @param value Status value at 'dateTime'; prior status changes may have been kept in instances of activity records associated with the object to which this status applies.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class Status
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
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[Status] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Status.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Status.fields (position), value)
        emitelem (0, dateTime)
        emitelem (1, reason)
        emitelem (2, remark)
        emitelem (3, value)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Status rdf:ID=\"%s\">\n%s\t</cim:Status>".format (id, export_fields)
    }
}

object Status
extends
    Parseable[Status]
{
    override val fields: Array[String] = Array[String] (
        "dateTime",
        "reason",
        "remark",
        "value"
    )
    val dateTime: Fielder = parse_element (element (cls, fields(0)))
    val reason: Fielder = parse_element (element (cls, fields(1)))
    val remark: Fielder = parse_element (element (cls, fields(2)))
    val value: Fielder = parse_element (element (cls, fields(3)))

    def parse (context: Context): Status =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Status (
            BasicElement.parse (context),
            mask (dateTime (), 0),
            mask (reason (), 1),
            mask (remark (), 2),
            mask (value (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * General purpose street and postal address information.
 *
 * @param sup Reference to the superclass object.
 * @param language The language in which the address is specified, using ISO 639-1 two digit language code.
 * @param poBox Post office box.
 * @param postalCode Postal code for the address.
 * @param status [[ch.ninecode.model.Status Status]] Status of this address.
 * @param streetDetail [[ch.ninecode.model.StreetDetail StreetDetail]] Street detail.
 * @param townDetail [[ch.ninecode.model.TownDetail TownDetail]] Town detail.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class StreetAddress
(
    override val sup: BasicElement,
    language: String,
    poBox: String,
    postalCode: String,
    status: String,
    streetDetail: String,
    townDetail: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[StreetAddress] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = StreetAddress.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (StreetAddress.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (StreetAddress.fields (position), value)
        emitelem (0, language)
        emitelem (1, poBox)
        emitelem (2, postalCode)
        emitattr (3, status)
        emitattr (4, streetDetail)
        emitattr (5, townDetail)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:StreetAddress rdf:ID=\"%s\">\n%s\t</cim:StreetAddress>".format (id, export_fields)
    }
}

object StreetAddress
extends
    Parseable[StreetAddress]
{
    override val fields: Array[String] = Array[String] (
        "language",
        "poBox",
        "postalCode",
        "status",
        "streetDetail",
        "townDetail"
    )
    override val relations: List[Relationship] = List (
        Relationship ("status", "Status", "0..1", "0..*"),
        Relationship ("streetDetail", "StreetDetail", "0..1", "0..*"),
        Relationship ("townDetail", "TownDetail", "0..1", "0..*")
    )
    val language: Fielder = parse_element (element (cls, fields(0)))
    val poBox: Fielder = parse_element (element (cls, fields(1)))
    val postalCode: Fielder = parse_element (element (cls, fields(2)))
    val status: Fielder = parse_attribute (attribute (cls, fields(3)))
    val streetDetail: Fielder = parse_attribute (attribute (cls, fields(4)))
    val townDetail: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: Context): StreetAddress =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = StreetAddress (
            BasicElement.parse (context),
            mask (language (), 0),
            mask (poBox (), 1),
            mask (postalCode (), 2),
            mask (status (), 3),
            mask (streetDetail (), 4),
            mask (townDetail (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Street details, in the context of address.
 *
 * @param sup Reference to the superclass object.
 * @param addressGeneral First line of a free form address or some additional address information (for example a mail stop).
 * @param addressGeneral2 (if applicable) Second line of a free form address.
 * @param addressGeneral3 (if applicable) Third line of a free form address.
 * @param buildingName (if applicable) In certain cases the physical location of the place of interest does not have a direct point of entry from the street, but may be located inside a larger structure such as a building, complex, office block, apartment, etc.
 * @param code (if applicable) Utilities often make use of external reference systems, such as those of the town-planner's department or surveyor general's mapping system, that allocate global reference codes to streets.
 * @param floorIdentification The identification by name or number, expressed as text, of the floor in the building as part of this address.
 * @param name Name of the street.
 * @param number Designator of the specific location on the street.
 * @param prefix Prefix to the street name.
 *        For example: North, South, East, West.
 * @param suffix Suffix to the street name.
 *        For example: North, South, East, West.
 * @param suiteNumber Number of the apartment or suite.
 * @param type Type of street.
 *        Examples include: street, circle, boulevard, avenue, road, drive, etc.
 * @param withinTownLimits True if this street is within the legal geographical boundaries of the specified town (default).
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class StreetDetail
(
    override val sup: BasicElement,
    addressGeneral: String,
    addressGeneral2: String,
    addressGeneral3: String,
    buildingName: String,
    code: String,
    floorIdentification: String,
    name: String,
    number: String,
    prefix: String,
    suffix: String,
    suiteNumber: String,
    `type`: String,
    withinTownLimits: Boolean
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null, false) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[StreetDetail] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = StreetDetail.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (StreetDetail.fields (position), value)
        emitelem (0, addressGeneral)
        emitelem (1, addressGeneral2)
        emitelem (2, addressGeneral3)
        emitelem (3, buildingName)
        emitelem (4, code)
        emitelem (5, floorIdentification)
        emitelem (6, name)
        emitelem (7, number)
        emitelem (8, prefix)
        emitelem (9, suffix)
        emitelem (10, suiteNumber)
        emitelem (11, `type`)
        emitelem (12, withinTownLimits)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:StreetDetail rdf:ID=\"%s\">\n%s\t</cim:StreetDetail>".format (id, export_fields)
    }
}

object StreetDetail
extends
    Parseable[StreetDetail]
{
    override val fields: Array[String] = Array[String] (
        "addressGeneral",
        "addressGeneral2",
        "addressGeneral3",
        "buildingName",
        "code",
        "floorIdentification",
        "name",
        "number",
        "prefix",
        "suffix",
        "suiteNumber",
        "type",
        "withinTownLimits"
    )
    val addressGeneral: Fielder = parse_element (element (cls, fields(0)))
    val addressGeneral2: Fielder = parse_element (element (cls, fields(1)))
    val addressGeneral3: Fielder = parse_element (element (cls, fields(2)))
    val buildingName: Fielder = parse_element (element (cls, fields(3)))
    val code: Fielder = parse_element (element (cls, fields(4)))
    val floorIdentification: Fielder = parse_element (element (cls, fields(5)))
    val name: Fielder = parse_element (element (cls, fields(6)))
    val number: Fielder = parse_element (element (cls, fields(7)))
    val prefix: Fielder = parse_element (element (cls, fields(8)))
    val suffix: Fielder = parse_element (element (cls, fields(9)))
    val suiteNumber: Fielder = parse_element (element (cls, fields(10)))
    val `type`: Fielder = parse_element (element (cls, fields(11)))
    val withinTownLimits: Fielder = parse_element (element (cls, fields(12)))

    def parse (context: Context): StreetDetail =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = StreetDetail (
            BasicElement.parse (context),
            mask (addressGeneral (), 0),
            mask (addressGeneral2 (), 1),
            mask (addressGeneral3 (), 2),
            mask (buildingName (), 3),
            mask (code (), 4),
            mask (floorIdentification (), 5),
            mask (name (), 6),
            mask (number (), 7),
            mask (prefix (), 8),
            mask (suffix (), 9),
            mask (suiteNumber (), 10),
            mask (`type` (), 11),
            toBoolean (mask (withinTownLimits (), 12))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Telephone number.
 *
 * @param sup Reference to the superclass object.
 * @param areaCode (if applicable) Area or region code.
 * @param cityCode City code.
 * @param countryCode Country code.
 * @param dialOut (if applicable) Dial out code, for instance to call outside an enterprise.
 * @param extension (if applicable) Extension for this telephone number.
 * @param internationalPrefix (if applicable) Prefix used when calling an international number.
 * @param ituPhone Phone number according to ITU E.164.
 * @param localNumber Main (local) part of this telephone number.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class TelephoneNumber
(
    override val sup: BasicElement,
    areaCode: String,
    cityCode: String,
    countryCode: String,
    dialOut: String,
    extension: String,
    internationalPrefix: String,
    ituPhone: String,
    localNumber: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[TelephoneNumber] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TelephoneNumber.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TelephoneNumber.fields (position), value)
        emitelem (0, areaCode)
        emitelem (1, cityCode)
        emitelem (2, countryCode)
        emitelem (3, dialOut)
        emitelem (4, extension)
        emitelem (5, internationalPrefix)
        emitelem (6, ituPhone)
        emitelem (7, localNumber)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TelephoneNumber rdf:ID=\"%s\">\n%s\t</cim:TelephoneNumber>".format (id, export_fields)
    }
}

object TelephoneNumber
extends
    Parseable[TelephoneNumber]
{
    override val fields: Array[String] = Array[String] (
        "areaCode",
        "cityCode",
        "countryCode",
        "dialOut",
        "extension",
        "internationalPrefix",
        "ituPhone",
        "localNumber"
    )
    val areaCode: Fielder = parse_element (element (cls, fields(0)))
    val cityCode: Fielder = parse_element (element (cls, fields(1)))
    val countryCode: Fielder = parse_element (element (cls, fields(2)))
    val dialOut: Fielder = parse_element (element (cls, fields(3)))
    val extension: Fielder = parse_element (element (cls, fields(4)))
    val internationalPrefix: Fielder = parse_element (element (cls, fields(5)))
    val ituPhone: Fielder = parse_element (element (cls, fields(6)))
    val localNumber: Fielder = parse_element (element (cls, fields(7)))

    def parse (context: Context): TelephoneNumber =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TelephoneNumber (
            BasicElement.parse (context),
            mask (areaCode (), 0),
            mask (cityCode (), 1),
            mask (countryCode (), 2),
            mask (dialOut (), 3),
            mask (extension (), 4),
            mask (internationalPrefix (), 5),
            mask (ituPhone (), 6),
            mask (localNumber (), 7)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A point in time within a sequence of points in time relative to a time schedule.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param dateTime Absolute date and time for this time point.
 *        For calendar-based time point, it is typically manually entered, while for interval-based or sequence-based time point it is derived.
 * @param relativeTimeInterval (if interval-based) A point in time relative to scheduled start time in 'TimeSchedule.scheduleInterval.start'.
 * @param sequenceNumber (if sequence-based) Relative sequence number for this time point.
 * @param status [[ch.ninecode.model.Status Status]] Status of this time point.
 * @param window Interval defining the window of time that this time point is valid (for example, seasonal, only on weekends, not on weekends, only 8:00 am to 5:00 pm, etc.).
 * @param TimeSchedule [[ch.ninecode.model.TimeSchedule TimeSchedule]] Time schedule owning this time point.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class TimePoint
(
    override val sup: IdentifiedObject,
    dateTime: String,
    relativeTimeInterval: Double,
    sequenceNumber: Int,
    status: String,
    window: String,
    TimeSchedule: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, 0, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[TimePoint] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TimePoint.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TimePoint.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TimePoint.fields (position), value)
        emitelem (0, dateTime)
        emitelem (1, relativeTimeInterval)
        emitelem (2, sequenceNumber)
        emitattr (3, status)
        emitattr (4, window)
        emitattr (5, TimeSchedule)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TimePoint rdf:ID=\"%s\">\n%s\t</cim:TimePoint>".format (id, export_fields)
    }
}

object TimePoint
extends
    Parseable[TimePoint]
{
    override val fields: Array[String] = Array[String] (
        "dateTime",
        "relativeTimeInterval",
        "sequenceNumber",
        "status",
        "window",
        "TimeSchedule"
    )
    override val relations: List[Relationship] = List (
        Relationship ("status", "Status", "0..1", "0..*"),
        Relationship ("TimeSchedule", "TimeSchedule", "1", "0..*")
    )
    val dateTime: Fielder = parse_element (element (cls, fields(0)))
    val relativeTimeInterval: Fielder = parse_element (element (cls, fields(1)))
    val sequenceNumber: Fielder = parse_element (element (cls, fields(2)))
    val status: Fielder = parse_attribute (attribute (cls, fields(3)))
    val window: Fielder = parse_attribute (attribute (cls, fields(4)))
    val TimeSchedule: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: Context): TimePoint =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TimePoint (
            IdentifiedObject.parse (context),
            mask (dateTime (), 0),
            toDouble (mask (relativeTimeInterval (), 1)),
            toInteger (mask (sequenceNumber (), 2)),
            mask (status (), 3),
            mask (window (), 4),
            mask (TimeSchedule (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Description of anything that changes through time.
 *
 * Time schedule is used to perform a single-valued function of time. Use inherited 'type' attribute to give additional information on this schedule, such as: periodic (hourly, daily, weekly, monthly, etc.), day of the month, by date, calendar (specific times and dates).
 *
 * @param sup [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param disabled True if this schedule is deactivated (disabled).
 * @param offset The offset from midnight (i.e., 0 h, 0 min, 0 s) for the periodic time points to begin.
 *        For example, for an interval meter that is set up for five minute intervals ('recurrencePeriod'=300=5 min), setting 'offset'=120=2 min would result in scheduled events to read the meter executing at 2 min, 7 min, 12 min, 17 min, 22 min, 27 min, 32 min, 37 min, 42 min, 47 min, 52 min, and 57 min past each hour.
 * @param recurrencePattern Interval at which the scheduled action repeats (e.g., first Monday of every month, last day of the month, etc.).
 * @param recurrencePeriod Duration between time points, from the beginning of one period to the beginning of the next period.
 *        Note that a device like a meter may have multiple interval periods (e.g., 1 min, 5 min, 15 min, 30 min, or 60 min).
 * @param scheduleInterval Schedule date and time interval.
 * @param TimePoints [[ch.ninecode.model.TimePoint TimePoint]] Sequence of time points belonging to this time schedule.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class TimeSchedule
(
    override val sup: Document,
    disabled: Boolean,
    offset: Double,
    recurrencePattern: String,
    recurrencePeriod: Double,
    scheduleInterval: String,
    TimePoints: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, 0.0, null, 0.0, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[TimeSchedule] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TimeSchedule.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TimeSchedule.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TimeSchedule.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (TimeSchedule.fields (position), x))
        emitelem (0, disabled)
        emitelem (1, offset)
        emitelem (2, recurrencePattern)
        emitelem (3, recurrencePeriod)
        emitattr (4, scheduleInterval)
        emitattrs (5, TimePoints)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TimeSchedule rdf:ID=\"%s\">\n%s\t</cim:TimeSchedule>".format (id, export_fields)
    }
}

object TimeSchedule
extends
    Parseable[TimeSchedule]
{
    override val fields: Array[String] = Array[String] (
        "disabled",
        "offset",
        "recurrencePattern",
        "recurrencePeriod",
        "scheduleInterval",
        "TimePoints"
    )
    override val relations: List[Relationship] = List (
        Relationship ("TimePoints", "TimePoint", "0..*", "1")
    )
    val disabled: Fielder = parse_element (element (cls, fields(0)))
    val offset: Fielder = parse_element (element (cls, fields(1)))
    val recurrencePattern: Fielder = parse_element (element (cls, fields(2)))
    val recurrencePeriod: Fielder = parse_element (element (cls, fields(3)))
    val scheduleInterval: Fielder = parse_attribute (attribute (cls, fields(4)))
    val TimePoints: FielderMultiple = parse_attributes (attribute (cls, fields(5)))

    def parse (context: Context): TimeSchedule =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TimeSchedule (
            Document.parse (context),
            toBoolean (mask (disabled (), 0)),
            toDouble (mask (offset (), 1)),
            mask (recurrencePattern (), 2),
            toDouble (mask (recurrencePeriod (), 3)),
            mask (scheduleInterval (), 4),
            masks (TimePoints (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Town details, in the context of address.
 *
 * @param sup Reference to the superclass object.
 * @param code Town code.
 * @param country Name of the country.
 * @param name Town name.
 * @param section Town section.
 *        For example, it is common for there to be 36 sections per township.
 * @param stateOrProvince Name of the state or province.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class TownDetail
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
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[TownDetail] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TownDetail.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TownDetail.fields (position), value)
        emitelem (0, code)
        emitelem (1, country)
        emitelem (2, name)
        emitelem (3, section)
        emitelem (4, stateOrProvince)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TownDetail rdf:ID=\"%s\">\n%s\t</cim:TownDetail>".format (id, export_fields)
    }
}

object TownDetail
extends
    Parseable[TownDetail]
{
    override val fields: Array[String] = Array[String] (
        "code",
        "country",
        "name",
        "section",
        "stateOrProvince"
    )
    val code: Fielder = parse_element (element (cls, fields(0)))
    val country: Fielder = parse_element (element (cls, fields(1)))
    val name: Fielder = parse_element (element (cls, fields(2)))
    val section: Fielder = parse_element (element (cls, fields(3)))
    val stateOrProvince: Fielder = parse_element (element (cls, fields(4)))

    def parse (context: Context): TownDetail =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TownDetail (
            BasicElement.parse (context),
            mask (code (), 0),
            mask (country (), 1),
            mask (name (), 2),
            mask (section (), 3),
            mask (stateOrProvince (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Generic name-value pair class, with optional sequence number and units for value; can be used to model parts of information exchange when concrete types are not known in advance.
 *
 * @param sup Reference to the superclass object.
 * @param name Name of an attribute.
 * @param sequenceNumber Sequence number for this attribute in a list of attributes.
 * @param value Value of an attribute, including unit information.
 * @param ErpInvoiceLineItems [[ch.ninecode.model.ErpInvoiceLineItem ErpInvoiceLineItem]] <em>undocumented</em>
 * @param ErpLedgerEntries [[ch.ninecode.model.ErpLedgerEntry ErpLedgerEntry]] <em>undocumented</em>
 * @param ProcedureDataSets [[ch.ninecode.model.ProcedureDataSet ProcedureDataSet]] <em>undocumented</em>
 * @param PropertySpecification [[ch.ninecode.model.Specification Specification]] <em>undocumented</em>
 * @param RatingSpecification [[ch.ninecode.model.Specification Specification]] <em>undocumented</em>
 * @param Transaction [[ch.ninecode.model.Transaction Transaction]] Transaction for which this snapshot has been recorded.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class UserAttribute
(
    override val sup: BasicElement,
    name: String,
    sequenceNumber: Int,
    value: String,
    ErpInvoiceLineItems: List[String],
    ErpLedgerEntries: List[String],
    ProcedureDataSets: List[String],
    PropertySpecification: String,
    RatingSpecification: String,
    Transaction: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0, null, List(), List(), List(), null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[UserAttribute] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = UserAttribute.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (UserAttribute.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (UserAttribute.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (UserAttribute.fields (position), x))
        emitelem (0, name)
        emitelem (1, sequenceNumber)
        emitattr (2, value)
        emitattrs (3, ErpInvoiceLineItems)
        emitattrs (4, ErpLedgerEntries)
        emitattrs (5, ProcedureDataSets)
        emitattr (6, PropertySpecification)
        emitattr (7, RatingSpecification)
        emitattr (8, Transaction)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:UserAttribute rdf:ID=\"%s\">\n%s\t</cim:UserAttribute>".format (id, export_fields)
    }
}

object UserAttribute
extends
    Parseable[UserAttribute]
{
    override val fields: Array[String] = Array[String] (
        "name",
        "sequenceNumber",
        "value",
        "ErpInvoiceLineItems",
        "ErpLedgerEntries",
        "ProcedureDataSets",
        "PropertySpecification",
        "RatingSpecification",
        "Transaction"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ErpInvoiceLineItems", "ErpInvoiceLineItem", "0..*", "0..*"),
        Relationship ("ErpLedgerEntries", "ErpLedgerEntry", "0..*", "0..*"),
        Relationship ("ProcedureDataSets", "ProcedureDataSet", "0..*", "0..*"),
        Relationship ("PropertySpecification", "Specification", "0..1", "0..*"),
        Relationship ("RatingSpecification", "Specification", "0..1", "0..*"),
        Relationship ("Transaction", "Transaction", "0..1", "0..*")
    )
    val name: Fielder = parse_element (element (cls, fields(0)))
    val sequenceNumber: Fielder = parse_element (element (cls, fields(1)))
    val value: Fielder = parse_attribute (attribute (cls, fields(2)))
    val ErpInvoiceLineItems: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val ErpLedgerEntries: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val ProcedureDataSets: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val PropertySpecification: Fielder = parse_attribute (attribute (cls, fields(6)))
    val RatingSpecification: Fielder = parse_attribute (attribute (cls, fields(7)))
    val Transaction: Fielder = parse_attribute (attribute (cls, fields(8)))

    def parse (context: Context): UserAttribute =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = UserAttribute (
            BasicElement.parse (context),
            mask (name (), 0),
            toInteger (mask (sequenceNumber (), 1)),
            mask (value (), 2),
            masks (ErpInvoiceLineItems (), 3),
            masks (ErpLedgerEntries (), 4),
            masks (ProcedureDataSets (), 5),
            mask (PropertySpecification (), 6),
            mask (RatingSpecification (), 7),
            mask (Transaction (), 8)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * This is the version for a group of devices or objects.
 *
 * This could be used to track the version for any group of objects or devices over time. For example, for a DERGroup, the requesting system may want to get the details of a specific version of a DERGroup.
 *
 * @param sup Reference to the superclass object.
 * @param date date of this version
 * @param major major release level for this version
 * @param minor minor release level for this version
 * @param revision revision level for this version
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class Version
(
    override val sup: BasicElement,
    date: String,
    major: Int,
    minor: Int,
    revision: Int
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0, 0, 0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[Version] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Version.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Version.fields (position), value)
        emitelem (0, date)
        emitelem (1, major)
        emitelem (2, minor)
        emitelem (3, revision)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Version rdf:ID=\"%s\">\n%s\t</cim:Version>".format (id, export_fields)
    }
}

object Version
extends
    Parseable[Version]
{
    override val fields: Array[String] = Array[String] (
        "date",
        "major",
        "minor",
        "revision"
    )
    val date: Fielder = parse_element (element (cls, fields(0)))
    val major: Fielder = parse_element (element (cls, fields(1)))
    val minor: Fielder = parse_element (element (cls, fields(2)))
    val revision: Fielder = parse_element (element (cls, fields(3)))

    def parse (context: Context): Version =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Version (
            BasicElement.parse (context),
            mask (date (), 0),
            toInteger (mask (major (), 1)),
            toInteger (mask (minor (), 2)),
            toInteger (mask (revision (), 3))
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _Common
{
    def register: List[ClassInfo] =
    {
        List (
            ActivityRecord.register,
            Agreement.register,
            Appointment.register,
            Approver.register,
            Author.register,
            ConfigurationEvent.register,
            CoordinateSystem.register,
            Crew.register,
            CrewMember.register,
            CrewType.register,
            Document.register,
            DocumentPersonRole.register,
            Editor.register,
            ElectronicAddress.register,
            ExtensionItem.register,
            ExtensionsList.register,
            FieldDispatchHistory.register,
            FieldDispatchStep.register,
            Hazard.register,
            Issuer.register,
            Location.register,
            OperationPersonRole.register,
            Operator.register,
            Organisation.register,
            OrganisationRole.register,
            Ownership.register,
            ParentOrganization.register,
            Person.register,
            PersonRole.register,
            PositionPoint.register,
            Priority.register,
            ScheduledEvent.register,
            ScheduledEventData.register,
            Status.register,
            StreetAddress.register,
            StreetDetail.register,
            TelephoneNumber.register,
            TimePoint.register,
            TimeSchedule.register,
            TownDetail.register,
            UserAttribute.register,
            Version.register
        )
    }
}