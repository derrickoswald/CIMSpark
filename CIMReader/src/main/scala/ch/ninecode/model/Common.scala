package ch.ninecode.model

import com.esotericsoftware.kryo.Kryo
import com.esotericsoftware.kryo.Serializer
import com.esotericsoftware.kryo.io.Input
import com.esotericsoftware.kryo.io.Output
import org.apache.spark.sql.Row

import ch.ninecode.cim.CIMClassInfo
import ch.ninecode.cim.CIMContext
import ch.ninecode.cim.CIMParseable
import ch.ninecode.cim.CIMRelationship
import ch.ninecode.cim.CIMSerializer

/**
 * Records activity for an entity at a point in time; activity may be for an event that has already occurred or for a planned activity.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
    IdentifiedObject: IdentifiedObject = null,
    createdDateTime: String = null,
    reason: String = null,
    severity: String = null,
    status: String = null,
    `type`: String = null,
    Assets: List[String] = null,
    Author: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: IdentifiedObject = IdentifiedObject

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[ActivityRecord]
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("status", "Status", "0..1", "0..*"),
        CIMRelationship ("Assets", "Asset", "0..*", "0..*"),
        CIMRelationship ("Author", "Author", "0..1", "0..*")
    )
    val createdDateTime: Fielder = parse_element (element (cls, fields(0)))
    val reason: Fielder = parse_element (element (cls, fields(1)))
    val severity: Fielder = parse_element (element (cls, fields(2)))
    val status: Fielder = parse_attribute (attribute (cls, fields(3)))
    val `type`: Fielder = parse_element (element (cls, fields(4)))
    val Assets: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val Author: Fielder = parse_attribute (attribute (cls, fields(6)))

    def parse (context: CIMContext): ActivityRecord =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[ActivityRecord] = ActivityRecordSerializer
}

object ActivityRecordSerializer extends CIMSerializer[ActivityRecord]
{
    def write (kryo: Kryo, output: Output, obj: ActivityRecord): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.createdDateTime),
            () => output.writeString (obj.reason),
            () => output.writeString (obj.severity),
            () => output.writeString (obj.status),
            () => output.writeString (obj.`type`),
            () => writeList (obj.Assets, output),
            () => output.writeString (obj.Author)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ActivityRecord]): ActivityRecord =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ActivityRecord (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) readList (input) else null,
            if (isSet (6)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Formal agreement between two parties defining the terms and conditions for a set of services.
 *
 * The specifics of the services are, in turn, defined via one or more service agreements.
 *
 * @param Document [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param signDate Date this agreement was consummated among associated persons and/or organisations.
 * @param validityInterval Date and time interval this agreement is valid (from going into effect to termination).
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class Agreement
(
    Document: Document = null,
    signDate: String = null,
    validityInterval: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Document = Document

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[Agreement]
{
    override val fields: Array[String] = Array[String] (
        "signDate",
        "validityInterval"
    )
    val signDate: Fielder = parse_element (element (cls, fields(0)))
    val validityInterval: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): Agreement =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Agreement (
            Document.parse (context),
            mask (signDate (), 0),
            mask (validityInterval (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Agreement] = AgreementSerializer
}

object AgreementSerializer extends CIMSerializer[Agreement]
{
    def write (kryo: Kryo, output: Output, obj: Agreement): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.signDate),
            () => output.writeString (obj.validityInterval)
        )
        DocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Agreement]): Agreement =
    {
        val parent = DocumentSerializer.read (kryo, input, classOf[Document])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Agreement (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Meeting time and location.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
    IdentifiedObject: IdentifiedObject = null,
    callAhead: Boolean = false,
    meetingInterval: String = null,
    Persons: List[String] = null,
    Works: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: IdentifiedObject = IdentifiedObject

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[Appointment]
{
    override val fields: Array[String] = Array[String] (
        "callAhead",
        "meetingInterval",
        "Persons",
        "Works"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Persons", "PersonRole", "0..*", "0..*"),
        CIMRelationship ("Works", "Work", "0..*", "0..*")
    )
    val callAhead: Fielder = parse_element (element (cls, fields(0)))
    val meetingInterval: Fielder = parse_attribute (attribute (cls, fields(1)))
    val Persons: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val Works: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: CIMContext): Appointment =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[Appointment] = AppointmentSerializer
}

object AppointmentSerializer extends CIMSerializer[Appointment]
{
    def write (kryo: Kryo, output: Output, obj: Appointment): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeBoolean (obj.callAhead),
            () => output.writeString (obj.meetingInterval),
            () => writeList (obj.Persons, output),
            () => writeList (obj.Works, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Appointment]): Appointment =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Appointment (
            parent,
            if (isSet (0)) input.readBoolean else false,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) readList (input) else null,
            if (isSet (3)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Person who accepted/signed or rejected the document.
 *
 * @param DocumentPersonRole [[ch.ninecode.model.DocumentPersonRole DocumentPersonRole]] Reference to the superclass object.
 * @param Documents [[ch.ninecode.model.Document Document]] All documents for this approver.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class Approver
(
    DocumentPersonRole: DocumentPersonRole = null,
    Documents: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: DocumentPersonRole = DocumentPersonRole

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[Approver]
{
    override val fields: Array[String] = Array[String] (
        "Documents"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Documents", "Document", "0..*", "0..1")
    )
    val Documents: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): Approver =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Approver (
            DocumentPersonRole.parse (context),
            masks (Documents (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Approver] = ApproverSerializer
}

object ApproverSerializer extends CIMSerializer[Approver]
{
    def write (kryo: Kryo, output: Output, obj: Approver): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.Documents, output)
        )
        DocumentPersonRoleSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Approver]): Approver =
    {
        val parent = DocumentPersonRoleSerializer.read (kryo, input, classOf[DocumentPersonRole])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Approver (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Person who created document or activity record.
 *
 * @param DocumentPersonRole [[ch.ninecode.model.DocumentPersonRole DocumentPersonRole]] Reference to the superclass object.
 * @param ActivityRecords [[ch.ninecode.model.ActivityRecord ActivityRecord]] All activity records with this author.
 * @param Documents [[ch.ninecode.model.Document Document]] All documents of this this author.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class Author
(
    DocumentPersonRole: DocumentPersonRole = null,
    ActivityRecords: List[String] = null,
    Documents: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: DocumentPersonRole = DocumentPersonRole

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[Author]
{
    override val fields: Array[String] = Array[String] (
        "ActivityRecords",
        "Documents"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ActivityRecords", "ActivityRecord", "0..*", "0..1"),
        CIMRelationship ("Documents", "Document", "0..*", "0..1")
    )
    val ActivityRecords: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val Documents: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): Author =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Author (
            DocumentPersonRole.parse (context),
            masks (ActivityRecords (), 0),
            masks (Documents (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Author] = AuthorSerializer
}

object AuthorSerializer extends CIMSerializer[Author]
{
    def write (kryo: Kryo, output: Output, obj: Author): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.ActivityRecords, output),
            () => writeList (obj.Documents, output)
        )
        DocumentPersonRoleSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Author]): Author =
    {
        val parent = DocumentPersonRoleSerializer.read (kryo, input, classOf[DocumentPersonRole])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Author (
            parent,
            if (isSet (0)) readList (input) else null,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Used to report details on creation, change or deletion of an entity or its configuration.
 *
 * @param ActivityRecord [[ch.ninecode.model.ActivityRecord ActivityRecord]] Reference to the superclass object.
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
    ActivityRecord: ActivityRecord = null,
    effectiveDateTime: String = null,
    modifiedBy: String = null,
    remark: String = null,
    ChangedAsset: String = null,
    ChangedDocument: String = null,
    ChangedLocation: String = null,
    ChangedOrganisationRole: String = null,
    ChangedPersonRole: String = null,
    ChangedServiceCategory: String = null,
    ChangedUsagePoint: String = null,
    FaultCauseType: String = null,
    PowerSystemResource: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: ActivityRecord = ActivityRecord

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[ConfigurationEvent]
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ChangedAsset", "Asset", "0..1", "0..*"),
        CIMRelationship ("ChangedDocument", "Document", "0..1", "0..*"),
        CIMRelationship ("ChangedLocation", "Location", "0..1", "0..*"),
        CIMRelationship ("ChangedOrganisationRole", "OrganisationRole", "0..1", "0..*"),
        CIMRelationship ("ChangedPersonRole", "PersonRole", "0..1", "0..*"),
        CIMRelationship ("ChangedServiceCategory", "ServiceCategory", "0..1", "0..*"),
        CIMRelationship ("ChangedUsagePoint", "UsagePoint", "0..1", "0..*"),
        CIMRelationship ("FaultCauseType", "FaultCauseType", "1", "0..*"),
        CIMRelationship ("PowerSystemResource", "PowerSystemResource", "0..1", "0..*")
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

    def parse (context: CIMContext): ConfigurationEvent =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[ConfigurationEvent] = ConfigurationEventSerializer
}

object ConfigurationEventSerializer extends CIMSerializer[ConfigurationEvent]
{
    def write (kryo: Kryo, output: Output, obj: ConfigurationEvent): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.effectiveDateTime),
            () => output.writeString (obj.modifiedBy),
            () => output.writeString (obj.remark),
            () => output.writeString (obj.ChangedAsset),
            () => output.writeString (obj.ChangedDocument),
            () => output.writeString (obj.ChangedLocation),
            () => output.writeString (obj.ChangedOrganisationRole),
            () => output.writeString (obj.ChangedPersonRole),
            () => output.writeString (obj.ChangedServiceCategory),
            () => output.writeString (obj.ChangedUsagePoint),
            () => output.writeString (obj.FaultCauseType),
            () => output.writeString (obj.PowerSystemResource)
        )
        ActivityRecordSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ConfigurationEvent]): ConfigurationEvent =
    {
        val parent = ActivityRecordSerializer.read (kryo, input, classOf[ActivityRecord])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ConfigurationEvent (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) input.readString else null,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) input.readString else null,
            if (isSet (10)) input.readString else null,
            if (isSet (11)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Coordinate reference system.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
    IdentifiedObject: IdentifiedObject = null,
    crsUrn: String = null,
    Locations: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: IdentifiedObject = IdentifiedObject

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[CoordinateSystem]
{
    override val fields: Array[String] = Array[String] (
        "crsUrn",
        "Locations"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Locations", "Location", "0..*", "0..1")
    )
    val crsUrn: Fielder = parse_element (element (cls, fields(0)))
    val Locations: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): CoordinateSystem =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CoordinateSystem (
            IdentifiedObject.parse (context),
            mask (crsUrn (), 0),
            masks (Locations (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[CoordinateSystem] = CoordinateSystemSerializer
}

object CoordinateSystemSerializer extends CIMSerializer[CoordinateSystem]
{
    def write (kryo: Kryo, output: Output, obj: CoordinateSystem): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.crsUrn),
            () => writeList (obj.Locations, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CoordinateSystem]): CoordinateSystem =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = CoordinateSystem (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Group of people with specific skills, tools, and vehicles.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
    IdentifiedObject: IdentifiedObject = null,
    status: String = null,
    CrewMembers: List[String] = null,
    CrewType: String = null,
    FieldDispatchHistory: List[String] = null,
    Location: String = null,
    Outage: List[String] = null,
    SwitchingAction: String = null,
    WorkAssets: List[String] = null,
    WorkTasks: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: IdentifiedObject = IdentifiedObject

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[Crew]
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("status", "Status", "0..1", "0..*"),
        CIMRelationship ("CrewMembers", "CrewMember", "0..*", "0..1"),
        CIMRelationship ("CrewType", "CrewType", "0..1", "0..*"),
        CIMRelationship ("FieldDispatchHistory", "FieldDispatchHistory", "0..*", "0..1"),
        CIMRelationship ("Location", "Location", "0..1", "0..*"),
        CIMRelationship ("Outage", "Outage", "0..*", "0..*"),
        CIMRelationship ("SwitchingAction", "SwitchingAction", "1", "0..*"),
        CIMRelationship ("WorkAssets", "WorkAsset", "0..*", "0..1"),
        CIMRelationship ("WorkTasks", "WorkTask", "0..*", "0..*")
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

    def parse (context: CIMContext): Crew =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[Crew] = CrewSerializer
}

object CrewSerializer extends CIMSerializer[Crew]
{
    def write (kryo: Kryo, output: Output, obj: Crew): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.status),
            () => writeList (obj.CrewMembers, output),
            () => output.writeString (obj.CrewType),
            () => writeList (obj.FieldDispatchHistory, output),
            () => output.writeString (obj.Location),
            () => writeList (obj.Outage, output),
            () => output.writeString (obj.SwitchingAction),
            () => writeList (obj.WorkAssets, output),
            () => writeList (obj.WorkTasks, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Crew]): Crew =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Crew (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) readList (input) else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) readList (input) else null,
            if (isSet (8)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Member of a crew.
 *
 * @param OperationPersonRole [[ch.ninecode.model.OperationPersonRole OperationPersonRole]] Reference to the superclass object.
 * @param Crew [[ch.ninecode.model.Crew Crew]] Crew to which this crew member belongs.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class CrewMember
(
    OperationPersonRole: OperationPersonRole = null,
    Crew: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: OperationPersonRole = OperationPersonRole

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[CrewMember]
{
    override val fields: Array[String] = Array[String] (
        "Crew"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Crew", "Crew", "0..1", "0..*")
    )
    val Crew: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): CrewMember =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CrewMember (
            OperationPersonRole.parse (context),
            mask (Crew (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[CrewMember] = CrewMemberSerializer
}

object CrewMemberSerializer extends CIMSerializer[CrewMember]
{
    def write (kryo: Kryo, output: Output, obj: CrewMember): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.Crew)
        )
        OperationPersonRoleSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CrewMember]): CrewMember =
    {
        val parent = OperationPersonRoleSerializer.read (kryo, input, classOf[OperationPersonRole])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = CrewMember (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Custom description of the type of crew.
 *
 * This may be used to determine the type of work the crew can be assigned to. Examples include repair, tree trimming, switching, etc.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param Crews [[ch.ninecode.model.Crew Crew]] All crews of this type.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class CrewType
(
    IdentifiedObject: IdentifiedObject = null,
    Crews: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: IdentifiedObject = IdentifiedObject

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[CrewType]
{
    override val fields: Array[String] = Array[String] (
        "Crews"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Crews", "Crew", "0..*", "0..1")
    )
    val Crews: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): CrewType =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CrewType (
            IdentifiedObject.parse (context),
            masks (Crews (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[CrewType] = CrewTypeSerializer
}

object CrewTypeSerializer extends CIMSerializer[CrewType]
{
    def write (kryo: Kryo, output: Output, obj: CrewType): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.Crews, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CrewType]): CrewType =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = CrewType (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Parent class for different groupings of information collected and managed as a part of a business process.
 *
 * It will frequently contain references to other objects, such as assets, people and power system resources.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
    IdentifiedObject: IdentifiedObject = null,
    authorName: String = null,
    comment: String = null,
    createdDateTime: String = null,
    docStatus: String = null,
    electronicAddress: String = null,
    lastModifiedDateTime: String = null,
    revisionNumber: String = null,
    status: String = null,
    subject: String = null,
    title: String = null,
    `type`: String = null,
    Approver: String = null,
    Author: String = null,
    ConfigurationEvents: List[String] = null,
    Editor: String = null,
    Issuer: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: IdentifiedObject = IdentifiedObject

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[Document]
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("docStatus", "Status", "0..1", "0..*"),
        CIMRelationship ("electronicAddress", "ElectronicAddress", "0..1", "0..*"),
        CIMRelationship ("status", "Status", "0..1", "0..*"),
        CIMRelationship ("Approver", "Approver", "0..1", "0..*"),
        CIMRelationship ("Author", "Author", "0..1", "0..*"),
        CIMRelationship ("ConfigurationEvents", "ConfigurationEvent", "0..*", "0..1"),
        CIMRelationship ("Editor", "Editor", "0..1", "0..*"),
        CIMRelationship ("Issuer", "Issuer", "0..1", "0..*")
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

    def parse (context: CIMContext): Document =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[Document] = DocumentSerializer
}

object DocumentSerializer extends CIMSerializer[Document]
{
    def write (kryo: Kryo, output: Output, obj: Document): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.authorName),
            () => output.writeString (obj.comment),
            () => output.writeString (obj.createdDateTime),
            () => output.writeString (obj.docStatus),
            () => output.writeString (obj.electronicAddress),
            () => output.writeString (obj.lastModifiedDateTime),
            () => output.writeString (obj.revisionNumber),
            () => output.writeString (obj.status),
            () => output.writeString (obj.subject),
            () => output.writeString (obj.title),
            () => output.writeString (obj.`type`),
            () => output.writeString (obj.Approver),
            () => output.writeString (obj.Author),
            () => writeList (obj.ConfigurationEvents, output),
            () => output.writeString (obj.Editor),
            () => output.writeString (obj.Issuer)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Document]): Document =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Document (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) input.readString else null,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) input.readString else null,
            if (isSet (10)) input.readString else null,
            if (isSet (11)) input.readString else null,
            if (isSet (12)) input.readString else null,
            if (isSet (13)) readList (input) else null,
            if (isSet (14)) input.readString else null,
            if (isSet (15)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Person role with respect to documents.
 *
 * @param PersonRole [[ch.ninecode.model.PersonRole PersonRole]] Reference to the superclass object.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class DocumentPersonRole
(
    PersonRole: PersonRole = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: PersonRole = PersonRole

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[DocumentPersonRole]
{

    def parse (context: CIMContext): DocumentPersonRole =
    {
        val ret = DocumentPersonRole (
            PersonRole.parse (context)
        )
        ret
    }

    def serializer: Serializer[DocumentPersonRole] = DocumentPersonRoleSerializer
}

object DocumentPersonRoleSerializer extends CIMSerializer[DocumentPersonRole]
{
    def write (kryo: Kryo, output: Output, obj: DocumentPersonRole): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        PersonRoleSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DocumentPersonRole]): DocumentPersonRole =
    {
        val parent = PersonRoleSerializer.read (kryo, input, classOf[PersonRole])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = DocumentPersonRole (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Person who modified the document.
 *
 * @param DocumentPersonRole [[ch.ninecode.model.DocumentPersonRole DocumentPersonRole]] Reference to the superclass object.
 * @param Documents [[ch.ninecode.model.Document Document]] All documents for this editor.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class Editor
(
    DocumentPersonRole: DocumentPersonRole = null,
    Documents: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: DocumentPersonRole = DocumentPersonRole

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[Editor]
{
    override val fields: Array[String] = Array[String] (
        "Documents"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Documents", "Document", "0..*", "0..1")
    )
    val Documents: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): Editor =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Editor (
            DocumentPersonRole.parse (context),
            masks (Documents (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Editor] = EditorSerializer
}

object EditorSerializer extends CIMSerializer[Editor]
{
    def write (kryo: Kryo, output: Output, obj: Editor): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.Documents, output)
        )
        DocumentPersonRoleSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Editor]): Editor =
    {
        val parent = DocumentPersonRoleSerializer.read (kryo, input, classOf[DocumentPersonRole])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Editor (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Electronic address information.
 *
 * @param Element Reference to the superclass object.
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
    Element: BasicElement = null,
    email1: String = null,
    email2: String = null,
    lan: String = null,
    mac: String = null,
    password: String = null,
    radio: String = null,
    userID: String = null,
    web: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Element = Element

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[ElectronicAddress]
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

    def parse (context: CIMContext): ElectronicAddress =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[ElectronicAddress] = ElectronicAddressSerializer
}

object ElectronicAddressSerializer extends CIMSerializer[ElectronicAddress]
{
    def write (kryo: Kryo, output: Output, obj: ElectronicAddress): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.email1),
            () => output.writeString (obj.email2),
            () => output.writeString (obj.lan),
            () => output.writeString (obj.mac),
            () => output.writeString (obj.password),
            () => output.writeString (obj.radio),
            () => output.writeString (obj.userID),
            () => output.writeString (obj.web)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ElectronicAddress]): ElectronicAddress =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ElectronicAddress (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class ExtensionItem
(
    Element: BasicElement = null,
    extName: String = null,
    extType: String = null,
    extValue: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Element = Element

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[ExtensionItem]
{
    override val fields: Array[String] = Array[String] (
        "extName",
        "extType",
        "extValue"
    )
    val extName: Fielder = parse_element (element (cls, fields(0)))
    val extType: Fielder = parse_element (element (cls, fields(1)))
    val extValue: Fielder = parse_element (element (cls, fields(2)))

    def parse (context: CIMContext): ExtensionItem =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[ExtensionItem] = ExtensionItemSerializer
}

object ExtensionItemSerializer extends CIMSerializer[ExtensionItem]
{
    def write (kryo: Kryo, output: Output, obj: ExtensionItem): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.extName),
            () => output.writeString (obj.extType),
            () => output.writeString (obj.extValue)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ExtensionItem]): ExtensionItem =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ExtensionItem (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class ExtensionsList
(
    Element: BasicElement = null,
    extensionsItem: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Element = Element

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[ExtensionsList]
{
    override val fields: Array[String] = Array[String] (
        "extensionsItem"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("extensionsItem", "ExtensionItem", "0..1", "0..*")
    )
    val extensionsItem: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): ExtensionsList =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ExtensionsList (
            BasicElement.parse (context),
            mask (extensionsItem (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ExtensionsList] = ExtensionsListSerializer
}

object ExtensionsListSerializer extends CIMSerializer[ExtensionsList]
{
    def write (kryo: Kryo, output: Output, obj: ExtensionsList): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.extensionsItem)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ExtensionsList]): ExtensionsList =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ExtensionsList (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The history of field dispatch statuses for this work.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
    IdentifiedObject: IdentifiedObject = null,
    Crew: String = null,
    FieldDispatchStep: List[String] = null,
    PlannedOutage: String = null,
    UnplannedOutage: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: IdentifiedObject = IdentifiedObject

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[FieldDispatchHistory]
{
    override val fields: Array[String] = Array[String] (
        "Crew",
        "FieldDispatchStep",
        "PlannedOutage",
        "UnplannedOutage"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Crew", "Crew", "0..1", "0..*"),
        CIMRelationship ("FieldDispatchStep", "FieldDispatchStep", "0..*", "1"),
        CIMRelationship ("PlannedOutage", "PlannedOutage", "0..1", "0..1"),
        CIMRelationship ("UnplannedOutage", "UnplannedOutage", "0..1", "0..1")
    )
    val Crew: Fielder = parse_attribute (attribute (cls, fields(0)))
    val FieldDispatchStep: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val PlannedOutage: Fielder = parse_attribute (attribute (cls, fields(2)))
    val UnplannedOutage: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: CIMContext): FieldDispatchHistory =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[FieldDispatchHistory] = FieldDispatchHistorySerializer
}

object FieldDispatchHistorySerializer extends CIMSerializer[FieldDispatchHistory]
{
    def write (kryo: Kryo, output: Output, obj: FieldDispatchHistory): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.Crew),
            () => writeList (obj.FieldDispatchStep, output),
            () => output.writeString (obj.PlannedOutage),
            () => output.writeString (obj.UnplannedOutage)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[FieldDispatchHistory]): FieldDispatchHistory =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = FieldDispatchHistory (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Details of the step in the field dispatch history.
 *
 * @param Element Reference to the superclass object.
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
    Element: BasicElement = null,
    dispatchStatus: String = null,
    occurredDateTime: String = null,
    remarks: String = null,
    sequenceNumber: Int = 0,
    FieldDispatchHistory: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Element = Element

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[FieldDispatchStep]
{
    override val fields: Array[String] = Array[String] (
        "dispatchStatus",
        "occurredDateTime",
        "remarks",
        "sequenceNumber",
        "FieldDispatchHistory"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("FieldDispatchHistory", "FieldDispatchHistory", "1", "0..*")
    )
    val dispatchStatus: Fielder = parse_attribute (attribute (cls, fields(0)))
    val occurredDateTime: Fielder = parse_element (element (cls, fields(1)))
    val remarks: Fielder = parse_element (element (cls, fields(2)))
    val sequenceNumber: Fielder = parse_element (element (cls, fields(3)))
    val FieldDispatchHistory: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: CIMContext): FieldDispatchStep =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[FieldDispatchStep] = FieldDispatchStepSerializer
}

object FieldDispatchStepSerializer extends CIMSerializer[FieldDispatchStep]
{
    def write (kryo: Kryo, output: Output, obj: FieldDispatchStep): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.dispatchStatus),
            () => output.writeString (obj.occurredDateTime),
            () => output.writeString (obj.remarks),
            () => output.writeInt (obj.sequenceNumber),
            () => output.writeString (obj.FieldDispatchHistory)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[FieldDispatchStep]): FieldDispatchStep =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = FieldDispatchStep (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readInt else 0,
            if (isSet (4)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * An object or a condition that is a danger for causing loss or perils to an asset and/or people.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param status [[ch.ninecode.model.Status Status]] Status of this hazard.
 * @param type Type of this hazard.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class Hazard
(
    IdentifiedObject: IdentifiedObject = null,
    status: String = null,
    `type`: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: IdentifiedObject = IdentifiedObject

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[Hazard]
{
    override val fields: Array[String] = Array[String] (
        "status",
        "type"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("status", "Status", "0..1", "0..*")
    )
    val status: Fielder = parse_attribute (attribute (cls, fields(0)))
    val `type`: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: CIMContext): Hazard =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Hazard (
            IdentifiedObject.parse (context),
            mask (status (), 0),
            mask (`type` (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Hazard] = HazardSerializer
}

object HazardSerializer extends CIMSerializer[Hazard]
{
    def write (kryo: Kryo, output: Output, obj: Hazard): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.status),
            () => output.writeString (obj.`type`)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Hazard]): Hazard =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Hazard (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Person who issued the document and is responsible for its content.
 *
 * @param DocumentPersonRole [[ch.ninecode.model.DocumentPersonRole DocumentPersonRole]] Reference to the superclass object.
 * @param Documents [[ch.ninecode.model.Document Document]] All documents for this issuer.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class Issuer
(
    DocumentPersonRole: DocumentPersonRole = null,
    Documents: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: DocumentPersonRole = DocumentPersonRole

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[Issuer]
{
    override val fields: Array[String] = Array[String] (
        "Documents"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Documents", "Document", "0..*", "0..1")
    )
    val Documents: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): Issuer =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Issuer (
            DocumentPersonRole.parse (context),
            masks (Documents (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Issuer] = IssuerSerializer
}

object IssuerSerializer extends CIMSerializer[Issuer]
{
    def write (kryo: Kryo, output: Output, obj: Issuer): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.Documents, output)
        )
        DocumentPersonRoleSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Issuer]): Issuer =
    {
        val parent = DocumentPersonRoleSerializer.read (kryo, input, classOf[DocumentPersonRole])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Issuer (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The place, scene, or point of something where someone or something has been, is, and/or will be at a given moment in time.
 *
 * It can be defined with one or more position points (coordinates) in a given coordinate system.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
    IdentifiedObject: IdentifiedObject = null,
    direction: String = null,
    electronicAddress: String = null,
    geoInfoReference: String = null,
    mainAddress: String = null,
    phone1: String = null,
    phone2: String = null,
    secondaryAddress: String = null,
    status: String = null,
    `type`: String = null,
    Assets: List[String] = null,
    ConfigurationEvents: List[String] = null,
    CoordinateSystem: String = null,
    Crew: List[String] = null,
    Crews: List[String] = null,
    EnvironmentalLocationKind: List[String] = null,
    EnvironmentalMonitoringStation: List[String] = null,
    Fault: List[String] = null,
    Hazards: List[String] = null,
    Incident: String = null,
    LandProperties: List[String] = null,
    Measurements: List[String] = null,
    OutageOrder: String = null,
    PositionPoints: List[String] = null,
    PowerSystemResources: List[String] = null,
    Routes: List[String] = null,
    SwitchingOrder: String = null,
    TroubleOrder: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: IdentifiedObject = IdentifiedObject

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[Location]
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("electronicAddress", "ElectronicAddress", "0..1", "0..*"),
        CIMRelationship ("mainAddress", "StreetAddress", "0..1", "0..*"),
        CIMRelationship ("phone1", "TelephoneNumber", "0..1", "0..*"),
        CIMRelationship ("phone2", "TelephoneNumber", "0..1", "0..*"),
        CIMRelationship ("secondaryAddress", "StreetAddress", "0..1", "0..*"),
        CIMRelationship ("status", "Status", "0..1", "0..*"),
        CIMRelationship ("Assets", "Asset", "0..*", "0..1"),
        CIMRelationship ("ConfigurationEvents", "ConfigurationEvent", "0..*", "0..1"),
        CIMRelationship ("CoordinateSystem", "CoordinateSystem", "0..1", "0..*"),
        CIMRelationship ("Crew", "Crew", "0..*", "0..1"),
        CIMRelationship ("Crews", "OldCrew", "0..*", "0..*"),
        CIMRelationship ("EnvironmentalLocationKind", "EnvironmentalLocationType", "0..*", "0..1"),
        CIMRelationship ("EnvironmentalMonitoringStation", "EnvironmentalMonitoringStation", "0..*", "0..1"),
        CIMRelationship ("Fault", "Fault", "0..*", "0..1"),
        CIMRelationship ("Hazards", "AssetLocationHazard", "0..*", "0..*"),
        CIMRelationship ("Incident", "Incident", "0..1", "0..1"),
        CIMRelationship ("LandProperties", "LandProperty", "0..*", "0..*"),
        CIMRelationship ("Measurements", "Measurement", "0..*", "0..*"),
        CIMRelationship ("OutageOrder", "OutageOrder", "0..1", "0..*"),
        CIMRelationship ("PositionPoints", "PositionPoint", "0..*", "1"),
        CIMRelationship ("PowerSystemResources", "PowerSystemResource", "0..*", "0..1"),
        CIMRelationship ("Routes", "Route", "0..*", "0..*"),
        CIMRelationship ("SwitchingOrder", "SwitchingOrder", "0..1", "0..*"),
        CIMRelationship ("TroubleOrder", "TroubleOrder", "0..1", "0..1")
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

    def parse (context: CIMContext): Location =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[Location] = LocationSerializer
}

object LocationSerializer extends CIMSerializer[Location]
{
    def write (kryo: Kryo, output: Output, obj: Location): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.direction),
            () => output.writeString (obj.electronicAddress),
            () => output.writeString (obj.geoInfoReference),
            () => output.writeString (obj.mainAddress),
            () => output.writeString (obj.phone1),
            () => output.writeString (obj.phone2),
            () => output.writeString (obj.secondaryAddress),
            () => output.writeString (obj.status),
            () => output.writeString (obj.`type`),
            () => writeList (obj.Assets, output),
            () => writeList (obj.ConfigurationEvents, output),
            () => output.writeString (obj.CoordinateSystem),
            () => writeList (obj.Crew, output),
            () => writeList (obj.Crews, output),
            () => writeList (obj.EnvironmentalLocationKind, output),
            () => writeList (obj.EnvironmentalMonitoringStation, output),
            () => writeList (obj.Fault, output),
            () => writeList (obj.Hazards, output),
            () => output.writeString (obj.Incident),
            () => writeList (obj.LandProperties, output),
            () => writeList (obj.Measurements, output),
            () => output.writeString (obj.OutageOrder),
            () => writeList (obj.PositionPoints, output),
            () => writeList (obj.PowerSystemResources, output),
            () => writeList (obj.Routes, output),
            () => output.writeString (obj.SwitchingOrder),
            () => output.writeString (obj.TroubleOrder)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Location]): Location =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Location (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) input.readString else null,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) readList (input) else null,
            if (isSet (10)) readList (input) else null,
            if (isSet (11)) input.readString else null,
            if (isSet (12)) readList (input) else null,
            if (isSet (13)) readList (input) else null,
            if (isSet (14)) readList (input) else null,
            if (isSet (15)) readList (input) else null,
            if (isSet (16)) readList (input) else null,
            if (isSet (17)) readList (input) else null,
            if (isSet (18)) input.readString else null,
            if (isSet (19)) readList (input) else null,
            if (isSet (20)) readList (input) else null,
            if (isSet (21)) input.readString else null,
            if (isSet (22)) readList (input) else null,
            if (isSet (23)) readList (input) else null,
            if (isSet (24)) readList (input) else null,
            if (isSet (25)) input.readString else null,
            if (isSet (26)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Person role in the context of utility operations.
 *
 * @param PersonRole [[ch.ninecode.model.PersonRole PersonRole]] Reference to the superclass object.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class OperationPersonRole
(
    PersonRole: PersonRole = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: PersonRole = PersonRole

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[OperationPersonRole]
{

    def parse (context: CIMContext): OperationPersonRole =
    {
        val ret = OperationPersonRole (
            PersonRole.parse (context)
        )
        ret
    }

    def serializer: Serializer[OperationPersonRole] = OperationPersonRoleSerializer
}

object OperationPersonRoleSerializer extends CIMSerializer[OperationPersonRole]
{
    def write (kryo: Kryo, output: Output, obj: OperationPersonRole): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        PersonRoleSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OperationPersonRole]): OperationPersonRole =
    {
        val parent = PersonRoleSerializer.read (kryo, input, classOf[PersonRole])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = OperationPersonRole (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Control room operator.
 *
 * @param OperationPersonRole [[ch.ninecode.model.OperationPersonRole OperationPersonRole]] Reference to the superclass object.
 * @param Incidents [[ch.ninecode.model.Incident Incident]] All incidents owned by this operator.
 * @param SwitchingSteps [[ch.ninecode.model.SwitchingAction SwitchingAction]] All switching steps this operator is responsible for.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class Operator
(
    OperationPersonRole: OperationPersonRole = null,
    Incidents: List[String] = null,
    SwitchingSteps: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: OperationPersonRole = OperationPersonRole

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[Operator]
{
    override val fields: Array[String] = Array[String] (
        "Incidents",
        "SwitchingSteps"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Incidents", "Incident", "0..*", "0..1"),
        CIMRelationship ("SwitchingSteps", "SwitchingAction", "0..*", "0..1")
    )
    val Incidents: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val SwitchingSteps: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): Operator =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Operator (
            OperationPersonRole.parse (context),
            masks (Incidents (), 0),
            masks (SwitchingSteps (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Operator] = OperatorSerializer
}

object OperatorSerializer extends CIMSerializer[Operator]
{
    def write (kryo: Kryo, output: Output, obj: Operator): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.Incidents, output),
            () => writeList (obj.SwitchingSteps, output)
        )
        OperationPersonRoleSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Operator]): Operator =
    {
        val parent = OperationPersonRoleSerializer.read (kryo, input, classOf[OperationPersonRole])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Operator (
            parent,
            if (isSet (0)) readList (input) else null,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Organisation that might have roles as utility, contractor, supplier, manufacturer, customer, etc.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
    IdentifiedObject: IdentifiedObject = null,
    electronicAddress: String = null,
    phone1: String = null,
    phone2: String = null,
    postalAddress: String = null,
    streetAddress: String = null,
    ParentOrganisation: String = null,
    Roles: List[String] = null,
    SwitchingPlanRequest: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: IdentifiedObject = IdentifiedObject

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[Organisation]
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("electronicAddress", "ElectronicAddress", "0..1", "0..*"),
        CIMRelationship ("phone1", "TelephoneNumber", "0..1", "0..*"),
        CIMRelationship ("phone2", "TelephoneNumber", "0..1", "0..*"),
        CIMRelationship ("postalAddress", "StreetAddress", "0..1", "0..*"),
        CIMRelationship ("streetAddress", "StreetAddress", "0..1", "0..*"),
        CIMRelationship ("ParentOrganisation", "ParentOrganization", "0..1", "0..*"),
        CIMRelationship ("Roles", "OrganisationRole", "0..*", "0..1"),
        CIMRelationship ("SwitchingPlanRequest", "SwitchingPlanRequest", "0..*", "0..1")
    )
    val electronicAddress: Fielder = parse_attribute (attribute (cls, fields(0)))
    val phone1: Fielder = parse_attribute (attribute (cls, fields(1)))
    val phone2: Fielder = parse_attribute (attribute (cls, fields(2)))
    val postalAddress: Fielder = parse_attribute (attribute (cls, fields(3)))
    val streetAddress: Fielder = parse_attribute (attribute (cls, fields(4)))
    val ParentOrganisation: Fielder = parse_attribute (attribute (cls, fields(5)))
    val Roles: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val SwitchingPlanRequest: FielderMultiple = parse_attributes (attribute (cls, fields(7)))

    def parse (context: CIMContext): Organisation =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[Organisation] = OrganisationSerializer
}

object OrganisationSerializer extends CIMSerializer[Organisation]
{
    def write (kryo: Kryo, output: Output, obj: Organisation): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.electronicAddress),
            () => output.writeString (obj.phone1),
            () => output.writeString (obj.phone2),
            () => output.writeString (obj.postalAddress),
            () => output.writeString (obj.streetAddress),
            () => output.writeString (obj.ParentOrganisation),
            () => writeList (obj.Roles, output),
            () => writeList (obj.SwitchingPlanRequest, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Organisation]): Organisation =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Organisation (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) readList (input) else null,
            if (isSet (7)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Identifies a way in which an organisation may participate in the utility enterprise (e.g., customer, manufacturer, etc).
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param ConfigurationEvents [[ch.ninecode.model.ConfigurationEvent ConfigurationEvent]] All configuration events created for this organisation role.
 * @param Organisation [[ch.ninecode.model.Organisation Organisation]] Organisation having this role.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class OrganisationRole
(
    IdentifiedObject: IdentifiedObject = null,
    ConfigurationEvents: List[String] = null,
    Organisation: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: IdentifiedObject = IdentifiedObject

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[OrganisationRole]
{
    override val fields: Array[String] = Array[String] (
        "ConfigurationEvents",
        "Organisation"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ConfigurationEvents", "ConfigurationEvent", "0..*", "0..1"),
        CIMRelationship ("Organisation", "Organisation", "0..1", "0..*")
    )
    val ConfigurationEvents: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val Organisation: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): OrganisationRole =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OrganisationRole (
            IdentifiedObject.parse (context),
            masks (ConfigurationEvents (), 0),
            mask (Organisation (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[OrganisationRole] = OrganisationRoleSerializer
}

object OrganisationRoleSerializer extends CIMSerializer[OrganisationRole]
{
    def write (kryo: Kryo, output: Output, obj: OrganisationRole): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.ConfigurationEvents, output),
            () => output.writeString (obj.Organisation)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OrganisationRole]): OrganisationRole =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = OrganisationRole (
            parent,
            if (isSet (0)) readList (input) else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Ownership of e.g. asset.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param share Share of this ownership.
 * @param Asset [[ch.ninecode.model.Asset Asset]] Asset that is object of this ownership.
 * @param AssetOwner [[ch.ninecode.model.AssetOwner AssetOwner]] Asset owner that is subject in this ownership.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class Ownership
(
    IdentifiedObject: IdentifiedObject = null,
    share: Double = 0.0,
    Asset: String = null,
    AssetOwner: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: IdentifiedObject = IdentifiedObject

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[Ownership]
{
    override val fields: Array[String] = Array[String] (
        "share",
        "Asset",
        "AssetOwner"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Asset", "Asset", "0..1", "0..*"),
        CIMRelationship ("AssetOwner", "AssetOwner", "0..1", "0..*")
    )
    val share: Fielder = parse_element (element (cls, fields(0)))
    val Asset: Fielder = parse_attribute (attribute (cls, fields(1)))
    val AssetOwner: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: CIMContext): Ownership =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[Ownership] = OwnershipSerializer
}

object OwnershipSerializer extends CIMSerializer[Ownership]
{
    def write (kryo: Kryo, output: Output, obj: Ownership): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.share),
            () => output.writeString (obj.Asset),
            () => output.writeString (obj.AssetOwner)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Ownership]): Ownership =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Ownership (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class ParentOrganization
(
    Organisation: Organisation = null,
    Organisation_attr: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Organisation = Organisation

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[ParentOrganization]
{
    override val fields: Array[String] = Array[String] (
        "Organisation"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Organisation_attr", "Organisation", "0..*", "0..1")
    )
    val Organisation_attr: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): ParentOrganization =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ParentOrganization (
            Organisation.parse (context),
            masks (Organisation_attr (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ParentOrganization] = ParentOrganizationSerializer
}

object ParentOrganizationSerializer extends CIMSerializer[ParentOrganization]
{
    def write (kryo: Kryo, output: Output, obj: ParentOrganization): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.Organisation_attr, output)
        )
        OrganisationSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ParentOrganization]): ParentOrganization =
    {
        val parent = OrganisationSerializer.read (kryo, input, classOf[Organisation])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ParentOrganization (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * General purpose information for name and other information to contact people.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
    IdentifiedObject: IdentifiedObject = null,
    electronicAddress: String = null,
    firstName: String = null,
    landlinePhone: String = null,
    lastName: String = null,
    mName: String = null,
    mobilePhone: String = null,
    prefix: String = null,
    specialNeed: String = null,
    suffix: String = null,
    Roles: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: IdentifiedObject = IdentifiedObject

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[Person]
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("electronicAddress", "ElectronicAddress", "0..1", "0..*"),
        CIMRelationship ("landlinePhone", "TelephoneNumber", "0..1", "0..*"),
        CIMRelationship ("mobilePhone", "TelephoneNumber", "0..1", "0..*"),
        CIMRelationship ("Roles", "PersonRole", "0..*", "0..1")
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

    def parse (context: CIMContext): Person =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[Person] = PersonSerializer
}

object PersonSerializer extends CIMSerializer[Person]
{
    def write (kryo: Kryo, output: Output, obj: Person): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.electronicAddress),
            () => output.writeString (obj.firstName),
            () => output.writeString (obj.landlinePhone),
            () => output.writeString (obj.lastName),
            () => output.writeString (obj.mName),
            () => output.writeString (obj.mobilePhone),
            () => output.writeString (obj.prefix),
            () => output.writeString (obj.specialNeed),
            () => output.writeString (obj.suffix),
            () => writeList (obj.Roles, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Person]): Person =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Person (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) input.readString else null,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class PersonRole
(
    IdentifiedObject: IdentifiedObject = null,
    Appointments: List[String] = null,
    ConfigurationEvents: List[String] = null,
    Person: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: IdentifiedObject = IdentifiedObject

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[PersonRole]
{
    override val fields: Array[String] = Array[String] (
        "Appointments",
        "ConfigurationEvents",
        "Person"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Appointments", "Appointment", "0..*", "0..*"),
        CIMRelationship ("ConfigurationEvents", "ConfigurationEvent", "0..*", "0..1"),
        CIMRelationship ("Person", "Person", "0..1", "0..*")
    )
    val Appointments: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val ConfigurationEvents: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val Person: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: CIMContext): PersonRole =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[PersonRole] = PersonRoleSerializer
}

object PersonRoleSerializer extends CIMSerializer[PersonRole]
{
    def write (kryo: Kryo, output: Output, obj: PersonRole): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.Appointments, output),
            () => writeList (obj.ConfigurationEvents, output),
            () => output.writeString (obj.Person)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PersonRole]): PersonRole =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PersonRole (
            parent,
            if (isSet (0)) readList (input) else null,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Set of spatial coordinates that determine a point, defined in the coordinate system specified in 'Location.
 *
 * CoordinateSystem'. Use a single position point instance to describe a point-oriented location. Use a sequence of position points to describe a line-oriented object (physical location of non-point oriented objects like cables or lines), or area of an object (like a substation or a geographical zone - in this case, have first and last position point with the same values).
 *
 * @param Element Reference to the superclass object.
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
    Element: BasicElement = null,
    groupNumber: Int = 0,
    sequenceNumber: Int = 0,
    xPosition: String = null,
    yPosition: String = null,
    zPosition: String = null,
    Location: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Element = Element

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[PositionPoint]
{
    override val fields: Array[String] = Array[String] (
        "groupNumber",
        "sequenceNumber",
        "xPosition",
        "yPosition",
        "zPosition",
        "Location"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Location", "Location", "1", "0..*")
    )
    val groupNumber: Fielder = parse_element (element (cls, fields(0)))
    val sequenceNumber: Fielder = parse_element (element (cls, fields(1)))
    val xPosition: Fielder = parse_element (element (cls, fields(2)))
    val yPosition: Fielder = parse_element (element (cls, fields(3)))
    val zPosition: Fielder = parse_element (element (cls, fields(4)))
    val Location: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: CIMContext): PositionPoint =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[PositionPoint] = PositionPointSerializer
}

object PositionPointSerializer extends CIMSerializer[PositionPoint]
{
    def write (kryo: Kryo, output: Output, obj: PositionPoint): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeInt (obj.groupNumber),
            () => output.writeInt (obj.sequenceNumber),
            () => output.writeString (obj.xPosition),
            () => output.writeString (obj.yPosition),
            () => output.writeString (obj.zPosition),
            () => output.writeString (obj.Location)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PositionPoint]): PositionPoint =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PositionPoint (
            parent,
            if (isSet (0)) input.readInt else 0,
            if (isSet (1)) input.readInt else 0,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Priority definition.
 *
 * @param Element Reference to the superclass object.
 * @param justification Justification for 'rank'.
 * @param rank Priority level; usually, lower number means high priority, but the details are provided in 'type'.
 * @param type Type describing 'rank'; e.g., high, emergency, etc.
 * @group Common
 * @groupname Common Package Common
 * @groupdesc Common This package contains the information classes that support distribution management in general.
 */
final case class Priority
(
    Element: BasicElement = null,
    justification: String = null,
    rank: Int = 0,
    `type`: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Element = Element

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[Priority]
{
    override val fields: Array[String] = Array[String] (
        "justification",
        "rank",
        "type"
    )
    val justification: Fielder = parse_element (element (cls, fields(0)))
    val rank: Fielder = parse_element (element (cls, fields(1)))
    val `type`: Fielder = parse_element (element (cls, fields(2)))

    def parse (context: CIMContext): Priority =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[Priority] = PrioritySerializer
}

object PrioritySerializer extends CIMSerializer[Priority]
{
    def write (kryo: Kryo, output: Output, obj: Priority): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.justification),
            () => output.writeInt (obj.rank),
            () => output.writeString (obj.`type`)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Priority]): Priority =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Priority (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readInt else 0,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * An event to trigger one or more activities, such as reading a meter, recalculating a bill, requesting work, when generating units must be scheduled for maintenance, when a transformer is scheduled to be refurbished, etc.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
    IdentifiedObject: IdentifiedObject = null,
    duration: Double = 0.0,
    status: String = null,
    `type`: String = null,
    Assets: List[String] = null,
    ScheduledEventData: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: IdentifiedObject = IdentifiedObject

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[ScheduledEvent]
{
    override val fields: Array[String] = Array[String] (
        "duration",
        "status",
        "type",
        "Assets",
        "ScheduledEventData"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("status", "Status", "0..1", "0..*"),
        CIMRelationship ("Assets", "Asset", "0..*", "0..*"),
        CIMRelationship ("ScheduledEventData", "ScheduledEventData", "0..1", "0..*")
    )
    val duration: Fielder = parse_element (element (cls, fields(0)))
    val status: Fielder = parse_attribute (attribute (cls, fields(1)))
    val `type`: Fielder = parse_element (element (cls, fields(2)))
    val Assets: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val ScheduledEventData: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: CIMContext): ScheduledEvent =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[ScheduledEvent] = ScheduledEventSerializer
}

object ScheduledEventSerializer extends CIMSerializer[ScheduledEvent]
{
    def write (kryo: Kryo, output: Output, obj: ScheduledEvent): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.duration),
            () => output.writeString (obj.status),
            () => output.writeString (obj.`type`),
            () => writeList (obj.Assets, output),
            () => output.writeString (obj.ScheduledEventData)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ScheduledEvent]): ScheduledEvent =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ScheduledEvent (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Schedule parameters for an activity that is to occur, is occurring, or has completed.
 *
 * @param Element Reference to the superclass object.
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
    Element: BasicElement = null,
    estimatedWindow: String = null,
    requestedWindow: String = null,
    status: String = null,
    InspectionDataSet: String = null,
    ScheduledEvents: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Element = Element

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[ScheduledEventData]
{
    override val fields: Array[String] = Array[String] (
        "estimatedWindow",
        "requestedWindow",
        "status",
        "InspectionDataSet",
        "ScheduledEvents"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("status", "Status", "0..1", "0..*"),
        CIMRelationship ("InspectionDataSet", "InspectionDataSet", "1", "0..*"),
        CIMRelationship ("ScheduledEvents", "ScheduledEvent", "0..*", "0..1")
    )
    val estimatedWindow: Fielder = parse_attribute (attribute (cls, fields(0)))
    val requestedWindow: Fielder = parse_attribute (attribute (cls, fields(1)))
    val status: Fielder = parse_attribute (attribute (cls, fields(2)))
    val InspectionDataSet: Fielder = parse_attribute (attribute (cls, fields(3)))
    val ScheduledEvents: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: CIMContext): ScheduledEventData =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[ScheduledEventData] = ScheduledEventDataSerializer
}

object ScheduledEventDataSerializer extends CIMSerializer[ScheduledEventData]
{
    def write (kryo: Kryo, output: Output, obj: ScheduledEventData): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.estimatedWindow),
            () => output.writeString (obj.requestedWindow),
            () => output.writeString (obj.status),
            () => output.writeString (obj.InspectionDataSet),
            () => writeList (obj.ScheduledEvents, output)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ScheduledEventData]): ScheduledEventData =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ScheduledEventData (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Current status information relevant to an entity.
 *
 * @param Element Reference to the superclass object.
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
    Element: BasicElement = null,
    dateTime: String = null,
    reason: String = null,
    remark: String = null,
    value: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Element = Element

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[Status]
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

    def parse (context: CIMContext): Status =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[Status] = StatusSerializer
}

object StatusSerializer extends CIMSerializer[Status]
{
    def write (kryo: Kryo, output: Output, obj: Status): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.dateTime),
            () => output.writeString (obj.reason),
            () => output.writeString (obj.remark),
            () => output.writeString (obj.value)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Status]): Status =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Status (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * General purpose street and postal address information.
 *
 * @param Element Reference to the superclass object.
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
    Element: BasicElement = null,
    language: String = null,
    poBox: String = null,
    postalCode: String = null,
    status: String = null,
    streetDetail: String = null,
    townDetail: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Element = Element

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[StreetAddress]
{
    override val fields: Array[String] = Array[String] (
        "language",
        "poBox",
        "postalCode",
        "status",
        "streetDetail",
        "townDetail"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("status", "Status", "0..1", "0..*"),
        CIMRelationship ("streetDetail", "StreetDetail", "0..1", "0..*"),
        CIMRelationship ("townDetail", "TownDetail", "0..1", "0..*")
    )
    val language: Fielder = parse_element (element (cls, fields(0)))
    val poBox: Fielder = parse_element (element (cls, fields(1)))
    val postalCode: Fielder = parse_element (element (cls, fields(2)))
    val status: Fielder = parse_attribute (attribute (cls, fields(3)))
    val streetDetail: Fielder = parse_attribute (attribute (cls, fields(4)))
    val townDetail: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: CIMContext): StreetAddress =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[StreetAddress] = StreetAddressSerializer
}

object StreetAddressSerializer extends CIMSerializer[StreetAddress]
{
    def write (kryo: Kryo, output: Output, obj: StreetAddress): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.language),
            () => output.writeString (obj.poBox),
            () => output.writeString (obj.postalCode),
            () => output.writeString (obj.status),
            () => output.writeString (obj.streetDetail),
            () => output.writeString (obj.townDetail)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[StreetAddress]): StreetAddress =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = StreetAddress (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Street details, in the context of address.
 *
 * @param Element Reference to the superclass object.
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
    Element: BasicElement = null,
    addressGeneral: String = null,
    addressGeneral2: String = null,
    addressGeneral3: String = null,
    buildingName: String = null,
    code: String = null,
    floorIdentification: String = null,
    name: String = null,
    number: String = null,
    prefix: String = null,
    suffix: String = null,
    suiteNumber: String = null,
    `type`: String = null,
    withinTownLimits: Boolean = false
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Element = Element

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[StreetDetail]
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

    def parse (context: CIMContext): StreetDetail =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[StreetDetail] = StreetDetailSerializer
}

object StreetDetailSerializer extends CIMSerializer[StreetDetail]
{
    def write (kryo: Kryo, output: Output, obj: StreetDetail): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.addressGeneral),
            () => output.writeString (obj.addressGeneral2),
            () => output.writeString (obj.addressGeneral3),
            () => output.writeString (obj.buildingName),
            () => output.writeString (obj.code),
            () => output.writeString (obj.floorIdentification),
            () => output.writeString (obj.name),
            () => output.writeString (obj.number),
            () => output.writeString (obj.prefix),
            () => output.writeString (obj.suffix),
            () => output.writeString (obj.suiteNumber),
            () => output.writeString (obj.`type`),
            () => output.writeBoolean (obj.withinTownLimits)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[StreetDetail]): StreetDetail =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = StreetDetail (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) input.readString else null,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) input.readString else null,
            if (isSet (10)) input.readString else null,
            if (isSet (11)) input.readString else null,
            if (isSet (12)) input.readBoolean else false
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Telephone number.
 *
 * @param Element Reference to the superclass object.
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
    Element: BasicElement = null,
    areaCode: String = null,
    cityCode: String = null,
    countryCode: String = null,
    dialOut: String = null,
    extension: String = null,
    internationalPrefix: String = null,
    ituPhone: String = null,
    localNumber: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Element = Element

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[TelephoneNumber]
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

    def parse (context: CIMContext): TelephoneNumber =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[TelephoneNumber] = TelephoneNumberSerializer
}

object TelephoneNumberSerializer extends CIMSerializer[TelephoneNumber]
{
    def write (kryo: Kryo, output: Output, obj: TelephoneNumber): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.areaCode),
            () => output.writeString (obj.cityCode),
            () => output.writeString (obj.countryCode),
            () => output.writeString (obj.dialOut),
            () => output.writeString (obj.extension),
            () => output.writeString (obj.internationalPrefix),
            () => output.writeString (obj.ituPhone),
            () => output.writeString (obj.localNumber)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TelephoneNumber]): TelephoneNumber =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = TelephoneNumber (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A point in time within a sequence of points in time relative to a time schedule.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
    IdentifiedObject: IdentifiedObject = null,
    dateTime: String = null,
    relativeTimeInterval: Double = 0.0,
    sequenceNumber: Int = 0,
    status: String = null,
    window: String = null,
    TimeSchedule: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: IdentifiedObject = IdentifiedObject

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[TimePoint]
{
    override val fields: Array[String] = Array[String] (
        "dateTime",
        "relativeTimeInterval",
        "sequenceNumber",
        "status",
        "window",
        "TimeSchedule"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("status", "Status", "0..1", "0..*"),
        CIMRelationship ("TimeSchedule", "TimeSchedule", "1", "0..*")
    )
    val dateTime: Fielder = parse_element (element (cls, fields(0)))
    val relativeTimeInterval: Fielder = parse_element (element (cls, fields(1)))
    val sequenceNumber: Fielder = parse_element (element (cls, fields(2)))
    val status: Fielder = parse_attribute (attribute (cls, fields(3)))
    val window: Fielder = parse_attribute (attribute (cls, fields(4)))
    val TimeSchedule: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: CIMContext): TimePoint =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[TimePoint] = TimePointSerializer
}

object TimePointSerializer extends CIMSerializer[TimePoint]
{
    def write (kryo: Kryo, output: Output, obj: TimePoint): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.dateTime),
            () => output.writeDouble (obj.relativeTimeInterval),
            () => output.writeInt (obj.sequenceNumber),
            () => output.writeString (obj.status),
            () => output.writeString (obj.window),
            () => output.writeString (obj.TimeSchedule)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TimePoint]): TimePoint =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = TimePoint (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readInt else 0,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Description of anything that changes through time.
 *
 * Time schedule is used to perform a single-valued function of time. Use inherited 'type' attribute to give additional information on this schedule, such as: periodic (hourly, daily, weekly, monthly, etc.), day of the month, by date, calendar (specific times and dates).
 *
 * @param Document [[ch.ninecode.model.Document Document]] Reference to the superclass object.
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
    Document: Document = null,
    disabled: Boolean = false,
    offset: Double = 0.0,
    recurrencePattern: String = null,
    recurrencePeriod: Double = 0.0,
    scheduleInterval: String = null,
    TimePoints: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Document = Document

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[TimeSchedule]
{
    override val fields: Array[String] = Array[String] (
        "disabled",
        "offset",
        "recurrencePattern",
        "recurrencePeriod",
        "scheduleInterval",
        "TimePoints"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("TimePoints", "TimePoint", "0..*", "1")
    )
    val disabled: Fielder = parse_element (element (cls, fields(0)))
    val offset: Fielder = parse_element (element (cls, fields(1)))
    val recurrencePattern: Fielder = parse_element (element (cls, fields(2)))
    val recurrencePeriod: Fielder = parse_element (element (cls, fields(3)))
    val scheduleInterval: Fielder = parse_attribute (attribute (cls, fields(4)))
    val TimePoints: FielderMultiple = parse_attributes (attribute (cls, fields(5)))

    def parse (context: CIMContext): TimeSchedule =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[TimeSchedule] = TimeScheduleSerializer
}

object TimeScheduleSerializer extends CIMSerializer[TimeSchedule]
{
    def write (kryo: Kryo, output: Output, obj: TimeSchedule): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeBoolean (obj.disabled),
            () => output.writeDouble (obj.offset),
            () => output.writeString (obj.recurrencePattern),
            () => output.writeDouble (obj.recurrencePeriod),
            () => output.writeString (obj.scheduleInterval),
            () => writeList (obj.TimePoints, output)
        )
        DocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TimeSchedule]): TimeSchedule =
    {
        val parent = DocumentSerializer.read (kryo, input, classOf[Document])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = TimeSchedule (
            parent,
            if (isSet (0)) input.readBoolean else false,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Town details, in the context of address.
 *
 * @param Element Reference to the superclass object.
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
    Element: BasicElement = null,
    code: String = null,
    country: String = null,
    name: String = null,
    section: String = null,
    stateOrProvince: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Element = Element

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[TownDetail]
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

    def parse (context: CIMContext): TownDetail =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[TownDetail] = TownDetailSerializer
}

object TownDetailSerializer extends CIMSerializer[TownDetail]
{
    def write (kryo: Kryo, output: Output, obj: TownDetail): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.code),
            () => output.writeString (obj.country),
            () => output.writeString (obj.name),
            () => output.writeString (obj.section),
            () => output.writeString (obj.stateOrProvince)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TownDetail]): TownDetail =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = TownDetail (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Generic name-value pair class, with optional sequence number and units for value; can be used to model parts of information exchange when concrete types are not known in advance.
 *
 * @param Element Reference to the superclass object.
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
    Element: BasicElement = null,
    name: String = null,
    sequenceNumber: Int = 0,
    value: String = null,
    ErpInvoiceLineItems: List[String] = null,
    ErpLedgerEntries: List[String] = null,
    ProcedureDataSets: List[String] = null,
    PropertySpecification: String = null,
    RatingSpecification: String = null,
    Transaction: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Element = Element

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[UserAttribute]
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ErpInvoiceLineItems", "ErpInvoiceLineItem", "0..*", "0..*"),
        CIMRelationship ("ErpLedgerEntries", "ErpLedgerEntry", "0..*", "0..*"),
        CIMRelationship ("ProcedureDataSets", "ProcedureDataSet", "0..*", "0..*"),
        CIMRelationship ("PropertySpecification", "Specification", "0..1", "0..*"),
        CIMRelationship ("RatingSpecification", "Specification", "0..1", "0..*"),
        CIMRelationship ("Transaction", "Transaction", "0..1", "0..*")
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

    def parse (context: CIMContext): UserAttribute =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[UserAttribute] = UserAttributeSerializer
}

object UserAttributeSerializer extends CIMSerializer[UserAttribute]
{
    def write (kryo: Kryo, output: Output, obj: UserAttribute): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.name),
            () => output.writeInt (obj.sequenceNumber),
            () => output.writeString (obj.value),
            () => writeList (obj.ErpInvoiceLineItems, output),
            () => writeList (obj.ErpLedgerEntries, output),
            () => writeList (obj.ProcedureDataSets, output),
            () => output.writeString (obj.PropertySpecification),
            () => output.writeString (obj.RatingSpecification),
            () => output.writeString (obj.Transaction)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[UserAttribute]): UserAttribute =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = UserAttribute (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readInt else 0,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) readList (input) else null,
            if (isSet (5)) readList (input) else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) input.readString else null,
            if (isSet (8)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * This is the version for a group of devices or objects.
 *
 * This could be used to track the version for any group of objects or devices over time. For example, for a DERGroup, the requesting system may want to get the details of a specific version of a DERGroup.
 *
 * @param Element Reference to the superclass object.
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
    Element: BasicElement = null,
    date: String = null,
    major: Int = 0,
    minor: Int = 0,
    revision: Int = 0
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Element = Element

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[Version]
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

    def parse (context: CIMContext): Version =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[Version] = VersionSerializer
}

object VersionSerializer extends CIMSerializer[Version]
{
    def write (kryo: Kryo, output: Output, obj: Version): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.date),
            () => output.writeInt (obj.major),
            () => output.writeInt (obj.minor),
            () => output.writeInt (obj.revision)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Version]): Version =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Version (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readInt else 0,
            if (isSet (2)) input.readInt else 0,
            if (isSet (3)) input.readInt else 0
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _Common
{
    def register: List[CIMClassInfo] =
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