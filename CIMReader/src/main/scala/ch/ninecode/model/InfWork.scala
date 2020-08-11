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
 * A permit is sometimes needed to provide legal access to land or equipment.
 *
 * For example, local authority permission for road works.
 *
 * @param WorkDocument      [[ch.ninecode.model.WorkDocument WorkDocument]] Reference to the superclass object.
 * @param applicationNumber Permit application number that is used by municipality, state, province, etc.
 * @param effectiveDate     Date that permit became official.
 * @param expirationDate    Permit expiration date.
 * @param payment           Total cost of permit.
 * @param permitID          Permit identifier.
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Work package is used to define classes related to work. There are several different aspects of work.
 *            The Work Initiation (Work, Project, Request).
 *            The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
 *            The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
 *            The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
 *            The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
 *            This package is used for inspection and maintenance (InspectionDataSet, Procedure).
 *            The WorkService package defines Appointment class".
 */
final case class AccessPermit
(
    WorkDocument: WorkDocument = null,
    applicationNumber: String = null,
    effectiveDate: String = null,
    expirationDate: String = null,
    payment: Double = 0.0,
    permitID: String = null
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
    override def sup: WorkDocument = WorkDocument

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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = AccessPermit.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AccessPermit.fields (position), value)

        emitelem (0, applicationNumber)
        emitelem (1, effectiveDate)
        emitelem (2, expirationDate)
        emitelem (3, payment)
        emitelem (4, permitID)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:AccessPermit rdf:ID=\"%s\">\n%s\t</cim:AccessPermit>".format (id, export_fields)
    }
}

object AccessPermit
    extends
        CIMParseable[AccessPermit]
{
    override val fields: Array[String] = Array [String](
        "applicationNumber",
        "effectiveDate",
        "expirationDate",
        "payment",
        "permitID"
    )
    val applicationNumber: Fielder = parse_element (element (cls, fields (0)))
    val effectiveDate: Fielder = parse_element (element (cls, fields (1)))
    val expirationDate: Fielder = parse_element (element (cls, fields (2)))
    val payment: Fielder = parse_element (element (cls, fields (3)))
    val permitID: Fielder = parse_element (element (cls, fields (4)))

    def parse (context: CIMContext): AccessPermit =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = AccessPermit (
            WorkDocument.parse (context),
            mask (applicationNumber (), 0),
            mask (effectiveDate (), 1),
            mask (expirationDate (), 2),
            toDouble (mask (payment (), 3)),
            mask (permitID (), 4)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[AccessPermit] = AccessPermitSerializer
}

object AccessPermitSerializer extends CIMSerializer[AccessPermit]
{
    def write (kryo: Kryo, output: Output, obj: AccessPermit): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.applicationNumber),
            () => output.writeString (obj.effectiveDate),
            () => output.writeString (obj.expirationDate),
            () => output.writeDouble (obj.payment),
            () => output.writeString (obj.permitID)
        )
        WorkDocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AccessPermit]): AccessPermit =
    {
        val parent = WorkDocumentSerializer.read (kryo, input, classOf [WorkDocument])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = AccessPermit (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * An assignment is given to an ErpPerson, Crew, Organisation, Equipment Item, Tool, etc. and may be used to perform Work, WorkTasks, Procedures, etc.
 *
 * TimeSchedules may be set up directly for Assignments or indirectly via the associated WorkTask. Note that these associations are all inherited through the recursive relationship on Document.
 *
 * @param WorkDocument    [[ch.ninecode.model.WorkDocument WorkDocument]] Reference to the superclass object.
 * @param effectivePeriod Period between the assignment becoming effective and its expiration.
 * @param Crews           [[ch.ninecode.model.OldCrew OldCrew]] All Crews having this Assignment.
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Work package is used to define classes related to work. There are several different aspects of work.
 *            The Work Initiation (Work, Project, Request).
 *            The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
 *            The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
 *            The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
 *            The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
 *            This package is used for inspection and maintenance (InspectionDataSet, Procedure).
 *            The WorkService package defines Appointment class".
 */
final case class Assignment
(
    WorkDocument: WorkDocument = null,
    effectivePeriod: String = null,
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
    override def sup: WorkDocument = WorkDocument

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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Assignment.cls

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Assignment.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Assignment.fields (position), x))

        emitattr (0, effectivePeriod)
        emitattrs (1, Crews)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:Assignment rdf:ID=\"%s\">\n%s\t</cim:Assignment>".format (id, export_fields)
    }
}

object Assignment
    extends
        CIMParseable[Assignment]
{
    override val fields: Array[String] = Array [String](
        "effectivePeriod",
        "Crews"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Crews", "OldCrew", "0..*", "0..*")
    )
    val effectivePeriod: Fielder = parse_attribute (attribute (cls, fields (0)))
    val Crews: FielderMultiple = parse_attributes (attribute (cls, fields (1)))

    def parse (context: CIMContext): Assignment =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = Assignment (
            WorkDocument.parse (context),
            mask (effectivePeriod (), 0),
            masks (Crews (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Assignment] = AssignmentSerializer
}

object AssignmentSerializer extends CIMSerializer[Assignment]
{
    def write (kryo: Kryo, output: Output, obj: Assignment): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.effectivePeriod),
            () => writeList (obj.Crews, output)
        )
        WorkDocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Assignment]): Assignment =
    {
        val parent = WorkDocumentSerializer.read (kryo, input, classOf [WorkDocument])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Assignment (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Business justification for capital expenditures, usually addressing operations and maintenance costs as well.
 *
 * @param WorkDocument  [[ch.ninecode.model.WorkDocument WorkDocument]] Reference to the superclass object.
 * @param corporateCode A codified representation of the business case (i.e., codes for highway relocation, replace substation transformers, etc.).
 * @param Projects      [[ch.ninecode.model.Project Project]] <em>undocumented</em>
 * @param Works         [[ch.ninecode.model.Work Work]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Work package is used to define classes related to work. There are several different aspects of work.
 *            The Work Initiation (Work, Project, Request).
 *            The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
 *            The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
 *            The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
 *            The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
 *            This package is used for inspection and maintenance (InspectionDataSet, Procedure).
 *            The WorkService package defines Appointment class".
 */
final case class BusinessCase
(
    WorkDocument: WorkDocument = null,
    corporateCode: String = null,
    Projects: List[String] = null,
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
    override def sup: WorkDocument = WorkDocument

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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = BusinessCase.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (BusinessCase.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (BusinessCase.fields (position), x))

        emitelem (0, corporateCode)
        emitattrs (1, Projects)
        emitattrs (2, Works)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:BusinessCase rdf:ID=\"%s\">\n%s\t</cim:BusinessCase>".format (id, export_fields)
    }
}

object BusinessCase
    extends
        CIMParseable[BusinessCase]
{
    override val fields: Array[String] = Array [String](
        "corporateCode",
        "Projects",
        "Works"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Projects", "Project", "0..*", "0..1"),
        CIMRelationship ("Works", "Work", "0..*", "0..1")
    )
    val corporateCode: Fielder = parse_element (element (cls, fields (0)))
    val Projects: FielderMultiple = parse_attributes (attribute (cls, fields (1)))
    val Works: FielderMultiple = parse_attributes (attribute (cls, fields (2)))

    def parse (context: CIMContext): BusinessCase =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = BusinessCase (
            WorkDocument.parse (context),
            mask (corporateCode (), 0),
            masks (Projects (), 1),
            masks (Works (), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[BusinessCase] = BusinessCaseSerializer
}

object BusinessCaseSerializer extends CIMSerializer[BusinessCase]
{
    def write (kryo: Kryo, output: Output, obj: BusinessCase): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.corporateCode),
            () => writeList (obj.Projects, output),
            () => writeList (obj.Works, output)
        )
        WorkDocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[BusinessCase]): BusinessCase =
    {
        val parent = WorkDocumentSerializer.read (kryo, input, classOf [WorkDocument])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = BusinessCase (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Allowed actions: Install, Remove, Transfer, Abandon, etc.
 *
 * @param WorkIdentifiedObject [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param status               <em>undocumented</em>
 * @param CompatibleUnits      [[ch.ninecode.model.CompatibleUnit CompatibleUnit]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Work package is used to define classes related to work. There are several different aspects of work.
 *            The Work Initiation (Work, Project, Request).
 *            The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
 *            The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
 *            The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
 *            The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
 *            This package is used for inspection and maintenance (InspectionDataSet, Procedure).
 *            The WorkService package defines Appointment class".
 */
final case class CUAllowableAction
(
    WorkIdentifiedObject: WorkIdentifiedObject = null,
    status: String = null,
    CompatibleUnits: List[String] = null
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
    override def sup: WorkIdentifiedObject = WorkIdentifiedObject

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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CUAllowableAction.cls

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CUAllowableAction.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (CUAllowableAction.fields (position), x))

        emitattr (0, status)
        emitattrs (1, CompatibleUnits)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:CUAllowableAction rdf:ID=\"%s\">\n%s\t</cim:CUAllowableAction>".format (id, export_fields)
    }
}

object CUAllowableAction
    extends
        CIMParseable[CUAllowableAction]
{
    override val fields: Array[String] = Array [String](
        "status",
        "CompatibleUnits"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("CompatibleUnits", "CompatibleUnit", "0..*", "0..1")
    )
    val status: Fielder = parse_attribute (attribute (cls, fields (0)))
    val CompatibleUnits: FielderMultiple = parse_attributes (attribute (cls, fields (1)))

    def parse (context: CIMContext): CUAllowableAction =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = CUAllowableAction (
            WorkIdentifiedObject.parse (context),
            mask (status (), 0),
            masks (CompatibleUnits (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[CUAllowableAction] = CUAllowableActionSerializer
}

object CUAllowableActionSerializer extends CIMSerializer[CUAllowableAction]
{
    def write (kryo: Kryo, output: Output, obj: CUAllowableAction): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.status),
            () => writeList (obj.CompatibleUnits, output)
        )
        WorkIdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CUAllowableAction]): CUAllowableAction =
    {
        val parent = WorkIdentifiedObjectSerializer.read (kryo, input, classOf [WorkIdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = CUAllowableAction (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Compatible unit contractor item.
 *
 * @param WorkIdentifiedObject [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param activityCode         Activity code identifies a specific and distinguishable unit of work.
 * @param bidAmount            The amount that a given contractor will charge for performing this unit of work.
 * @param status               <em>undocumented</em>
 * @param CompatibleUnits      [[ch.ninecode.model.CompatibleUnit CompatibleUnit]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Work package is used to define classes related to work. There are several different aspects of work.
 *            The Work Initiation (Work, Project, Request).
 *            The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
 *            The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
 *            The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
 *            The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
 *            This package is used for inspection and maintenance (InspectionDataSet, Procedure).
 *            The WorkService package defines Appointment class".
 */
final case class CUContractorItem
(
    WorkIdentifiedObject: WorkIdentifiedObject = null,
    activityCode: String = null,
    bidAmount: Double = 0.0,
    status: String = null,
    CompatibleUnits: List[String] = null
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
    override def sup: WorkIdentifiedObject = WorkIdentifiedObject

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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CUContractorItem.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CUContractorItem.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CUContractorItem.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (CUContractorItem.fields (position), x))

        emitelem (0, activityCode)
        emitelem (1, bidAmount)
        emitattr (2, status)
        emitattrs (3, CompatibleUnits)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:CUContractorItem rdf:ID=\"%s\">\n%s\t</cim:CUContractorItem>".format (id, export_fields)
    }
}

object CUContractorItem
    extends
        CIMParseable[CUContractorItem]
{
    override val fields: Array[String] = Array [String](
        "activityCode",
        "bidAmount",
        "status",
        "CompatibleUnits"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("CompatibleUnits", "CompatibleUnit", "0..*", "0..*")
    )
    val activityCode: Fielder = parse_element (element (cls, fields (0)))
    val bidAmount: Fielder = parse_element (element (cls, fields (1)))
    val status: Fielder = parse_attribute (attribute (cls, fields (2)))
    val CompatibleUnits: FielderMultiple = parse_attributes (attribute (cls, fields (3)))

    def parse (context: CIMContext): CUContractorItem =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = CUContractorItem (
            WorkIdentifiedObject.parse (context),
            mask (activityCode (), 0),
            toDouble (mask (bidAmount (), 1)),
            mask (status (), 2),
            masks (CompatibleUnits (), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[CUContractorItem] = CUContractorItemSerializer
}

object CUContractorItemSerializer extends CIMSerializer[CUContractorItem]
{
    def write (kryo: Kryo, output: Output, obj: CUContractorItem): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.activityCode),
            () => output.writeDouble (obj.bidAmount),
            () => output.writeString (obj.status),
            () => writeList (obj.CompatibleUnits, output)
        )
        WorkIdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CUContractorItem]): CUContractorItem =
    {
        val parent = WorkIdentifiedObjectSerializer.read (kryo, input, classOf [WorkIdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = CUContractorItem (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A Compatible Unit Group identifies a set of compatible units which may be jointly utilized for estimating and designating jobs.
 *
 * @param WorkIdentifiedObject [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param status               <em>undocumented</em>
 * @param ChildCUGroups        [[ch.ninecode.model.CUGroup CUGroup]] <em>undocumented</em>
 * @param CompatibleUnits      [[ch.ninecode.model.CompatibleUnit CompatibleUnit]] <em>undocumented</em>
 * @param DesignLocationCUs    [[ch.ninecode.model.DesignLocationCU DesignLocationCU]] <em>undocumented</em>
 * @param ParentCUGroups       [[ch.ninecode.model.CUGroup CUGroup]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Work package is used to define classes related to work. There are several different aspects of work.
 *            The Work Initiation (Work, Project, Request).
 *            The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
 *            The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
 *            The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
 *            The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
 *            This package is used for inspection and maintenance (InspectionDataSet, Procedure).
 *            The WorkService package defines Appointment class".
 */
final case class CUGroup
(
    WorkIdentifiedObject: WorkIdentifiedObject = null,
    status: String = null,
    ChildCUGroups: List[String] = null,
    CompatibleUnits: List[String] = null,
    DesignLocationCUs: List[String] = null,
    ParentCUGroups: List[String] = null
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
    override def sup: WorkIdentifiedObject = WorkIdentifiedObject

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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CUGroup.cls

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CUGroup.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (CUGroup.fields (position), x))

        emitattr (0, status)
        emitattrs (1, ChildCUGroups)
        emitattrs (2, CompatibleUnits)
        emitattrs (3, DesignLocationCUs)
        emitattrs (4, ParentCUGroups)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:CUGroup rdf:ID=\"%s\">\n%s\t</cim:CUGroup>".format (id, export_fields)
    }
}

object CUGroup
    extends
        CIMParseable[CUGroup]
{
    override val fields: Array[String] = Array [String](
        "status",
        "ChildCUGroups",
        "CompatibleUnits",
        "DesignLocationCUs",
        "ParentCUGroups"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ChildCUGroups", "CUGroup", "0..*", "0..*"),
        CIMRelationship ("CompatibleUnits", "CompatibleUnit", "0..*", "0..1"),
        CIMRelationship ("DesignLocationCUs", "DesignLocationCU", "0..*", "0..*"),
        CIMRelationship ("ParentCUGroups", "CUGroup", "0..*", "0..*")
    )
    val status: Fielder = parse_attribute (attribute (cls, fields (0)))
    val ChildCUGroups: FielderMultiple = parse_attributes (attribute (cls, fields (1)))
    val CompatibleUnits: FielderMultiple = parse_attributes (attribute (cls, fields (2)))
    val DesignLocationCUs: FielderMultiple = parse_attributes (attribute (cls, fields (3)))
    val ParentCUGroups: FielderMultiple = parse_attributes (attribute (cls, fields (4)))

    def parse (context: CIMContext): CUGroup =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = CUGroup (
            WorkIdentifiedObject.parse (context),
            mask (status (), 0),
            masks (ChildCUGroups (), 1),
            masks (CompatibleUnits (), 2),
            masks (DesignLocationCUs (), 3),
            masks (ParentCUGroups (), 4)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[CUGroup] = CUGroupSerializer
}

object CUGroupSerializer extends CIMSerializer[CUGroup]
{
    def write (kryo: Kryo, output: Output, obj: CUGroup): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.status),
            () => writeList (obj.ChildCUGroups, output),
            () => writeList (obj.CompatibleUnits, output),
            () => writeList (obj.DesignLocationCUs, output),
            () => writeList (obj.ParentCUGroups, output)
        )
        WorkIdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CUGroup]): CUGroup =
    {
        val parent = WorkIdentifiedObjectSerializer.read (kryo, input, classOf [WorkIdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = CUGroup (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) readList (input) else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Labor code associated with various compatible unit labor items.
 *
 * @param WorkIdentifiedObject [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param code                 Labor code.
 * @param status               <em>undocumented</em>
 * @param CULaborItems         [[ch.ninecode.model.CULaborItem CULaborItem]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Work package is used to define classes related to work. There are several different aspects of work.
 *            The Work Initiation (Work, Project, Request).
 *            The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
 *            The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
 *            The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
 *            The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
 *            This package is used for inspection and maintenance (InspectionDataSet, Procedure).
 *            The WorkService package defines Appointment class".
 */
final case class CULaborCode
(
    WorkIdentifiedObject: WorkIdentifiedObject = null,
    code: String = null,
    status: String = null,
    CULaborItems: List[String] = null
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
    override def sup: WorkIdentifiedObject = WorkIdentifiedObject

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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CULaborCode.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CULaborCode.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CULaborCode.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (CULaborCode.fields (position), x))

        emitelem (0, code)
        emitattr (1, status)
        emitattrs (2, CULaborItems)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:CULaborCode rdf:ID=\"%s\">\n%s\t</cim:CULaborCode>".format (id, export_fields)
    }
}

object CULaborCode
    extends
        CIMParseable[CULaborCode]
{
    override val fields: Array[String] = Array [String](
        "code",
        "status",
        "CULaborItems"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("CULaborItems", "CULaborItem", "0..*", "0..1")
    )
    val code: Fielder = parse_element (element (cls, fields (0)))
    val status: Fielder = parse_attribute (attribute (cls, fields (1)))
    val CULaborItems: FielderMultiple = parse_attributes (attribute (cls, fields (2)))

    def parse (context: CIMContext): CULaborCode =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = CULaborCode (
            WorkIdentifiedObject.parse (context),
            mask (code (), 0),
            mask (status (), 1),
            masks (CULaborItems (), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[CULaborCode] = CULaborCodeSerializer
}

object CULaborCodeSerializer extends CIMSerializer[CULaborCode]
{
    def write (kryo: Kryo, output: Output, obj: CULaborCode): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.code),
            () => output.writeString (obj.status),
            () => writeList (obj.CULaborItems, output)
        )
        WorkIdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CULaborCode]): CULaborCode =
    {
        val parent = WorkIdentifiedObjectSerializer.read (kryo, input, classOf [WorkIdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = CULaborCode (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Compatible unit labor item.
 *
 * @param WorkIdentifiedObject      [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param activityCode              Activity code identifies a specific and distinguishable unit of work.
 * @param laborDuration             Estimated time to perform work.
 * @param laborRate                 The labor rate applied for work.
 * @param status                    <em>undocumented</em>
 * @param CULaborCode               [[ch.ninecode.model.CULaborCode CULaborCode]] <em>undocumented</em>
 * @param CompatibleUnits           [[ch.ninecode.model.CompatibleUnit CompatibleUnit]] <em>undocumented</em>
 * @param QualificationRequirements [[ch.ninecode.model.QualificationRequirement QualificationRequirement]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Work package is used to define classes related to work. There are several different aspects of work.
 *            The Work Initiation (Work, Project, Request).
 *            The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
 *            The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
 *            The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
 *            The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
 *            This package is used for inspection and maintenance (InspectionDataSet, Procedure).
 *            The WorkService package defines Appointment class".
 */
final case class CULaborItem
(
    WorkIdentifiedObject: WorkIdentifiedObject = null,
    activityCode: String = null,
    laborDuration: Double = 0.0,
    laborRate: Double = 0.0,
    status: String = null,
    CULaborCode: String = null,
    CompatibleUnits: List[String] = null,
    QualificationRequirements: List[String] = null
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
    override def sup: WorkIdentifiedObject = WorkIdentifiedObject

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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CULaborItem.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CULaborItem.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CULaborItem.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (CULaborItem.fields (position), x))

        emitelem (0, activityCode)
        emitelem (1, laborDuration)
        emitelem (2, laborRate)
        emitattr (3, status)
        emitattr (4, CULaborCode)
        emitattrs (5, CompatibleUnits)
        emitattrs (6, QualificationRequirements)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:CULaborItem rdf:ID=\"%s\">\n%s\t</cim:CULaborItem>".format (id, export_fields)
    }
}

object CULaborItem
    extends
        CIMParseable[CULaborItem]
{
    override val fields: Array[String] = Array [String](
        "activityCode",
        "laborDuration",
        "laborRate",
        "status",
        "CULaborCode",
        "CompatibleUnits",
        "QualificationRequirements"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("CULaborCode", "CULaborCode", "0..1", "0..*"),
        CIMRelationship ("CompatibleUnits", "CompatibleUnit", "0..*", "0..*"),
        CIMRelationship ("QualificationRequirements", "QualificationRequirement", "0..*", "0..*")
    )
    val activityCode: Fielder = parse_element (element (cls, fields (0)))
    val laborDuration: Fielder = parse_element (element (cls, fields (1)))
    val laborRate: Fielder = parse_element (element (cls, fields (2)))
    val status: Fielder = parse_attribute (attribute (cls, fields (3)))
    val CULaborCode: Fielder = parse_attribute (attribute (cls, fields (4)))
    val CompatibleUnits: FielderMultiple = parse_attributes (attribute (cls, fields (5)))
    val QualificationRequirements: FielderMultiple = parse_attributes (attribute (cls, fields (6)))

    def parse (context: CIMContext): CULaborItem =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = CULaborItem (
            WorkIdentifiedObject.parse (context),
            mask (activityCode (), 0),
            toDouble (mask (laborDuration (), 1)),
            toDouble (mask (laborRate (), 2)),
            mask (status (), 3),
            mask (CULaborCode (), 4),
            masks (CompatibleUnits (), 5),
            masks (QualificationRequirements (), 6)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[CULaborItem] = CULaborItemSerializer
}

object CULaborItemSerializer extends CIMSerializer[CULaborItem]
{
    def write (kryo: Kryo, output: Output, obj: CULaborItem): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.activityCode),
            () => output.writeDouble (obj.laborDuration),
            () => output.writeDouble (obj.laborRate),
            () => output.writeString (obj.status),
            () => output.writeString (obj.CULaborCode),
            () => writeList (obj.CompatibleUnits, output),
            () => writeList (obj.QualificationRequirements, output)
        )
        WorkIdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CULaborItem]): CULaborItem =
    {
        val parent = WorkIdentifiedObjectSerializer.read (kryo, input, classOf [WorkIdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = CULaborItem (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) readList (input) else null,
            if (isSet (6)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Compatible unit of a consumable supply item.
 *
 * For example, nuts, bolts, brackets, glue, etc.
 *
 * @param WorkIdentifiedObject [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param corporateCode        Code for material.
 * @param quantity             Quantity of the TypeMaterial for this CU, used to determine estimated costs based on a per unit cost or a cost per unit length specified in the TypeMaterial.
 * @param status               <em>undocumented</em>
 * @param CompatibleUnits      [[ch.ninecode.model.CompatibleUnit CompatibleUnit]] <em>undocumented</em>
 * @param PropertyUnits        [[ch.ninecode.model.PropertyUnit PropertyUnit]] <em>undocumented</em>
 * @param TypeMaterial         [[ch.ninecode.model.TypeMaterial TypeMaterial]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Work package is used to define classes related to work. There are several different aspects of work.
 *            The Work Initiation (Work, Project, Request).
 *            The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
 *            The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
 *            The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
 *            The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
 *            This package is used for inspection and maintenance (InspectionDataSet, Procedure).
 *            The WorkService package defines Appointment class".
 */
final case class CUMaterialItem
(
    WorkIdentifiedObject: WorkIdentifiedObject = null,
    corporateCode: String = null,
    quantity: String = null,
    status: String = null,
    CompatibleUnits: List[String] = null,
    PropertyUnits: List[String] = null,
    TypeMaterial: String = null
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
    override def sup: WorkIdentifiedObject = WorkIdentifiedObject

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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CUMaterialItem.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CUMaterialItem.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CUMaterialItem.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (CUMaterialItem.fields (position), x))

        emitelem (0, corporateCode)
        emitattr (1, quantity)
        emitattr (2, status)
        emitattrs (3, CompatibleUnits)
        emitattrs (4, PropertyUnits)
        emitattr (5, TypeMaterial)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:CUMaterialItem rdf:ID=\"%s\">\n%s\t</cim:CUMaterialItem>".format (id, export_fields)
    }
}

object CUMaterialItem
    extends
        CIMParseable[CUMaterialItem]
{
    override val fields: Array[String] = Array [String](
        "corporateCode",
        "quantity",
        "status",
        "CompatibleUnits",
        "PropertyUnits",
        "TypeMaterial"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("CompatibleUnits", "CompatibleUnit", "0..*", "0..*"),
        CIMRelationship ("PropertyUnits", "PropertyUnit", "0..*", "0..*"),
        CIMRelationship ("TypeMaterial", "TypeMaterial", "0..1", "0..*")
    )
    val corporateCode: Fielder = parse_element (element (cls, fields (0)))
    val quantity: Fielder = parse_attribute (attribute (cls, fields (1)))
    val status: Fielder = parse_attribute (attribute (cls, fields (2)))
    val CompatibleUnits: FielderMultiple = parse_attributes (attribute (cls, fields (3)))
    val PropertyUnits: FielderMultiple = parse_attributes (attribute (cls, fields (4)))
    val TypeMaterial: Fielder = parse_attribute (attribute (cls, fields (5)))

    def parse (context: CIMContext): CUMaterialItem =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = CUMaterialItem (
            WorkIdentifiedObject.parse (context),
            mask (corporateCode (), 0),
            mask (quantity (), 1),
            mask (status (), 2),
            masks (CompatibleUnits (), 3),
            masks (PropertyUnits (), 4),
            mask (TypeMaterial (), 5)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[CUMaterialItem] = CUMaterialItemSerializer
}

object CUMaterialItemSerializer extends CIMSerializer[CUMaterialItem]
{
    def write (kryo: Kryo, output: Output, obj: CUMaterialItem): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.corporateCode),
            () => output.writeString (obj.quantity),
            () => output.writeString (obj.status),
            () => writeList (obj.CompatibleUnits, output),
            () => writeList (obj.PropertyUnits, output),
            () => output.writeString (obj.TypeMaterial)
        )
        WorkIdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CUMaterialItem]): CUMaterialItem =
    {
        val parent = WorkIdentifiedObjectSerializer.read (kryo, input, classOf [WorkIdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = CUMaterialItem (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) readList (input) else null,
            if (isSet (5)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Compatible unit for various types of WorkEquipmentAssets, including vehicles.
 *
 * @param WorkIdentifiedObject [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param equipCode            The equipment type code.
 * @param rate                 Standard usage rate for the type of vehicle.
 * @param status               <em>undocumented</em>
 * @param CompatibleUnits      [[ch.ninecode.model.CompatibleUnit CompatibleUnit]] <em>undocumented</em>
 * @param TypeAsset            [[ch.ninecode.model.WorkAsset WorkAsset]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Work package is used to define classes related to work. There are several different aspects of work.
 *            The Work Initiation (Work, Project, Request).
 *            The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
 *            The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
 *            The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
 *            The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
 *            This package is used for inspection and maintenance (InspectionDataSet, Procedure).
 *            The WorkService package defines Appointment class".
 */
final case class CUWorkEquipmentItem
(
    WorkIdentifiedObject: WorkIdentifiedObject = null,
    equipCode: String = null,
    rate: Double = 0.0,
    status: String = null,
    CompatibleUnits: List[String] = null,
    TypeAsset: String = null
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
    override def sup: WorkIdentifiedObject = WorkIdentifiedObject

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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CUWorkEquipmentItem.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CUWorkEquipmentItem.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CUWorkEquipmentItem.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (CUWorkEquipmentItem.fields (position), x))

        emitelem (0, equipCode)
        emitelem (1, rate)
        emitattr (2, status)
        emitattrs (3, CompatibleUnits)
        emitattr (4, TypeAsset)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:CUWorkEquipmentItem rdf:ID=\"%s\">\n%s\t</cim:CUWorkEquipmentItem>".format (id, export_fields)
    }
}

object CUWorkEquipmentItem
    extends
        CIMParseable[CUWorkEquipmentItem]
{
    override val fields: Array[String] = Array [String](
        "equipCode",
        "rate",
        "status",
        "CompatibleUnits",
        "TypeAsset"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("CompatibleUnits", "CompatibleUnit", "0..*", "0..*"),
        CIMRelationship ("TypeAsset", "WorkAsset", "0..1", "0..1")
    )
    val equipCode: Fielder = parse_element (element (cls, fields (0)))
    val rate: Fielder = parse_element (element (cls, fields (1)))
    val status: Fielder = parse_attribute (attribute (cls, fields (2)))
    val CompatibleUnits: FielderMultiple = parse_attributes (attribute (cls, fields (3)))
    val TypeAsset: Fielder = parse_attribute (attribute (cls, fields (4)))

    def parse (context: CIMContext): CUWorkEquipmentItem =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = CUWorkEquipmentItem (
            WorkIdentifiedObject.parse (context),
            mask (equipCode (), 0),
            toDouble (mask (rate (), 1)),
            mask (status (), 2),
            masks (CompatibleUnits (), 3),
            mask (TypeAsset (), 4)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[CUWorkEquipmentItem] = CUWorkEquipmentItemSerializer
}

object CUWorkEquipmentItemSerializer extends CIMSerializer[CUWorkEquipmentItem]
{
    def write (kryo: Kryo, output: Output, obj: CUWorkEquipmentItem): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.equipCode),
            () => output.writeDouble (obj.rate),
            () => output.writeString (obj.status),
            () => writeList (obj.CompatibleUnits, output),
            () => output.writeString (obj.TypeAsset)
        )
        WorkIdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CUWorkEquipmentItem]): CUWorkEquipmentItem =
    {
        val parent = WorkIdentifiedObjectSerializer.read (kryo, input, classOf [WorkIdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = CUWorkEquipmentItem (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Capabilities of a crew.
 *
 * @param WorkIdentifiedObject [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param performanceFactor    Capability performance factor.
 * @param status               <em>undocumented</em>
 * @param type                 Classification by utility's work management standards and practices.
 * @param validityInterval     Date and time interval for which this capability is valid (when it became effective and when it expires).
 * @param Crafts               [[ch.ninecode.model.Craft Craft]] <em>undocumented</em>
 * @param Crew                 [[ch.ninecode.model.OldCrew OldCrew]] <em>undocumented</em>
 * @param WorkTasks            [[ch.ninecode.model.OldWorkTask OldWorkTask]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Work package is used to define classes related to work. There are several different aspects of work.
 *            The Work Initiation (Work, Project, Request).
 *            The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
 *            The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
 *            The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
 *            The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
 *            This package is used for inspection and maintenance (InspectionDataSet, Procedure).
 *            The WorkService package defines Appointment class".
 */
final case class Capability
(
    WorkIdentifiedObject: WorkIdentifiedObject = null,
    performanceFactor: String = null,
    status: String = null,
    `type`: String = null,
    validityInterval: String = null,
    Crafts: List[String] = null,
    Crew: String = null,
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
    override def sup: WorkIdentifiedObject = WorkIdentifiedObject

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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Capability.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Capability.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Capability.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Capability.fields (position), x))

        emitelem (0, performanceFactor)
        emitattr (1, status)
        emitelem (2, `type`)
        emitattr (3, validityInterval)
        emitattrs (4, Crafts)
        emitattr (5, Crew)
        emitattrs (6, WorkTasks)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:Capability rdf:ID=\"%s\">\n%s\t</cim:Capability>".format (id, export_fields)
    }
}

object Capability
    extends
        CIMParseable[Capability]
{
    override val fields: Array[String] = Array [String](
        "performanceFactor",
        "status",
        "type",
        "validityInterval",
        "Crafts",
        "Crew",
        "WorkTasks"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Crafts", "Craft", "0..*", "0..*"),
        CIMRelationship ("Crew", "OldCrew", "0..1", "0..*"),
        CIMRelationship ("WorkTasks", "OldWorkTask", "0..*", "0..*")
    )
    val performanceFactor: Fielder = parse_element (element (cls, fields (0)))
    val status: Fielder = parse_attribute (attribute (cls, fields (1)))
    val `type`: Fielder = parse_element (element (cls, fields (2)))
    val validityInterval: Fielder = parse_attribute (attribute (cls, fields (3)))
    val Crafts: FielderMultiple = parse_attributes (attribute (cls, fields (4)))
    val Crew: Fielder = parse_attribute (attribute (cls, fields (5)))
    val WorkTasks: FielderMultiple = parse_attributes (attribute (cls, fields (6)))

    def parse (context: CIMContext): Capability =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = Capability (
            WorkIdentifiedObject.parse (context),
            mask (performanceFactor (), 0),
            mask (status (), 1),
            mask (`type` (), 2),
            mask (validityInterval (), 3),
            masks (Crafts (), 4),
            mask (Crew (), 5),
            masks (WorkTasks (), 6)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Capability] = CapabilitySerializer
}

object CapabilitySerializer extends CIMSerializer[Capability]
{
    def write (kryo: Kryo, output: Output, obj: Capability): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.performanceFactor),
            () => output.writeString (obj.status),
            () => output.writeString (obj.`type`),
            () => output.writeString (obj.validityInterval),
            () => writeList (obj.Crafts, output),
            () => output.writeString (obj.Crew),
            () => writeList (obj.WorkTasks, output)
        )
        WorkIdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Capability]): Capability =
    {
        val parent = WorkIdentifiedObjectSerializer.read (kryo, input, classOf [WorkIdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Capability (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) readList (input) else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A pre-planned job model containing labor, material, and accounting requirements for standardized job planning.
 *
 * @param WorkDocument         [[ch.ninecode.model.WorkDocument WorkDocument]] Reference to the superclass object.
 * @param estCost              Estimated total cost for perfoming CU.
 * @param quantity             The quantity, unit of measure, and multiplier at the CU level that applies to the materials.
 * @param CUAllowableAction    [[ch.ninecode.model.CUAllowableAction CUAllowableAction]] <em>undocumented</em>
 * @param CUContractorItems    [[ch.ninecode.model.CUContractorItem CUContractorItem]] <em>undocumented</em>
 * @param CUGroup              [[ch.ninecode.model.CUGroup CUGroup]] <em>undocumented</em>
 * @param CULaborItems         [[ch.ninecode.model.CULaborItem CULaborItem]] <em>undocumented</em>
 * @param CUMaterialItems      [[ch.ninecode.model.CUMaterialItem CUMaterialItem]] <em>undocumented</em>
 * @param CUWorkEquipmentItems [[ch.ninecode.model.CUWorkEquipmentItem CUWorkEquipmentItem]] <em>undocumented</em>
 * @param CostType             [[ch.ninecode.model.CostType CostType]] <em>undocumented</em>
 * @param DesignLocationCUs    [[ch.ninecode.model.DesignLocationCU DesignLocationCU]] <em>undocumented</em>
 * @param GenericAssetModel    [[ch.ninecode.model.CatalogAssetType CatalogAssetType]] <em>undocumented</em>
 * @param Procedures           [[ch.ninecode.model.Procedure Procedure]] <em>undocumented</em>
 * @param PropertyUnit         [[ch.ninecode.model.PropertyUnit PropertyUnit]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Work package is used to define classes related to work. There are several different aspects of work.
 *            The Work Initiation (Work, Project, Request).
 *            The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
 *            The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
 *            The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
 *            The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
 *            This package is used for inspection and maintenance (InspectionDataSet, Procedure).
 *            The WorkService package defines Appointment class".
 */
final case class CompatibleUnit
(
    WorkDocument: WorkDocument = null,
    estCost: Double = 0.0,
    quantity: String = null,
    CUAllowableAction: String = null,
    CUContractorItems: List[String] = null,
    CUGroup: String = null,
    CULaborItems: List[String] = null,
    CUMaterialItems: List[String] = null,
    CUWorkEquipmentItems: List[String] = null,
    CostType: String = null,
    DesignLocationCUs: List[String] = null,
    GenericAssetModel: String = null,
    Procedures: List[String] = null,
    PropertyUnit: String = null
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
    override def sup: WorkDocument = WorkDocument

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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CompatibleUnit.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CompatibleUnit.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CompatibleUnit.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (CompatibleUnit.fields (position), x))

        emitelem (0, estCost)
        emitelem (1, quantity)
        emitattr (2, CUAllowableAction)
        emitattrs (3, CUContractorItems)
        emitattr (4, CUGroup)
        emitattrs (5, CULaborItems)
        emitattrs (6, CUMaterialItems)
        emitattrs (7, CUWorkEquipmentItems)
        emitattr (8, CostType)
        emitattrs (9, DesignLocationCUs)
        emitattr (10, GenericAssetModel)
        emitattrs (11, Procedures)
        emitattr (12, PropertyUnit)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:CompatibleUnit rdf:ID=\"%s\">\n%s\t</cim:CompatibleUnit>".format (id, export_fields)
    }
}

object CompatibleUnit
    extends
        CIMParseable[CompatibleUnit]
{
    override val fields: Array[String] = Array [String](
        "estCost",
        "quantity",
        "CUAllowableAction",
        "CUContractorItems",
        "CUGroup",
        "CULaborItems",
        "CUMaterialItems",
        "CUWorkEquipmentItems",
        "CostType",
        "DesignLocationCUs",
        "GenericAssetModel",
        "Procedures",
        "PropertyUnit"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("CUAllowableAction", "CUAllowableAction", "0..1", "0..*"),
        CIMRelationship ("CUContractorItems", "CUContractorItem", "0..*", "0..*"),
        CIMRelationship ("CUGroup", "CUGroup", "0..1", "0..*"),
        CIMRelationship ("CULaborItems", "CULaborItem", "0..*", "0..*"),
        CIMRelationship ("CUMaterialItems", "CUMaterialItem", "0..*", "0..*"),
        CIMRelationship ("CUWorkEquipmentItems", "CUWorkEquipmentItem", "0..*", "0..*"),
        CIMRelationship ("CostType", "CostType", "0..1", "0..*"),
        CIMRelationship ("DesignLocationCUs", "DesignLocationCU", "0..*", "0..*"),
        CIMRelationship ("GenericAssetModel", "CatalogAssetType", "0..1", "0..*"),
        CIMRelationship ("Procedures", "Procedure", "0..*", "0..*"),
        CIMRelationship ("PropertyUnit", "PropertyUnit", "0..1", "0..*")
    )
    val estCost: Fielder = parse_element (element (cls, fields (0)))
    val quantity: Fielder = parse_element (element (cls, fields (1)))
    val CUAllowableAction: Fielder = parse_attribute (attribute (cls, fields (2)))
    val CUContractorItems: FielderMultiple = parse_attributes (attribute (cls, fields (3)))
    val CUGroup: Fielder = parse_attribute (attribute (cls, fields (4)))
    val CULaborItems: FielderMultiple = parse_attributes (attribute (cls, fields (5)))
    val CUMaterialItems: FielderMultiple = parse_attributes (attribute (cls, fields (6)))
    val CUWorkEquipmentItems: FielderMultiple = parse_attributes (attribute (cls, fields (7)))
    val CostType: Fielder = parse_attribute (attribute (cls, fields (8)))
    val DesignLocationCUs: FielderMultiple = parse_attributes (attribute (cls, fields (9)))
    val GenericAssetModel: Fielder = parse_attribute (attribute (cls, fields (10)))
    val Procedures: FielderMultiple = parse_attributes (attribute (cls, fields (11)))
    val PropertyUnit: Fielder = parse_attribute (attribute (cls, fields (12)))

    def parse (context: CIMContext): CompatibleUnit =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = CompatibleUnit (
            WorkDocument.parse (context),
            toDouble (mask (estCost (), 0)),
            mask (quantity (), 1),
            mask (CUAllowableAction (), 2),
            masks (CUContractorItems (), 3),
            mask (CUGroup (), 4),
            masks (CULaborItems (), 5),
            masks (CUMaterialItems (), 6),
            masks (CUWorkEquipmentItems (), 7),
            mask (CostType (), 8),
            masks (DesignLocationCUs (), 9),
            mask (GenericAssetModel (), 10),
            masks (Procedures (), 11),
            mask (PropertyUnit (), 12)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[CompatibleUnit] = CompatibleUnitSerializer
}

object CompatibleUnitSerializer extends CIMSerializer[CompatibleUnit]
{
    def write (kryo: Kryo, output: Output, obj: CompatibleUnit): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.estCost),
            () => output.writeString (obj.quantity),
            () => output.writeString (obj.CUAllowableAction),
            () => writeList (obj.CUContractorItems, output),
            () => output.writeString (obj.CUGroup),
            () => writeList (obj.CULaborItems, output),
            () => writeList (obj.CUMaterialItems, output),
            () => writeList (obj.CUWorkEquipmentItems, output),
            () => output.writeString (obj.CostType),
            () => writeList (obj.DesignLocationCUs, output),
            () => output.writeString (obj.GenericAssetModel),
            () => writeList (obj.Procedures, output),
            () => output.writeString (obj.PropertyUnit)
        )
        WorkDocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CompatibleUnit]): CompatibleUnit =
    {
        val parent = WorkDocumentSerializer.read (kryo, input, classOf [WorkDocument])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = CompatibleUnit (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) readList (input) else null,
            if (isSet (6)) readList (input) else null,
            if (isSet (7)) readList (input) else null,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) readList (input) else null,
            if (isSet (10)) input.readString else null,
            if (isSet (11)) readList (input) else null,
            if (isSet (12)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * This is to specify the various condition factors for a design that may alter the cost estimate or the allocation.
 *
 * @param WorkIdentifiedObject [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param cfValue              The actual value of the condition factor, such as labor flat fee or percentage.
 * @param kind                 Kind of this condition factor.
 * @param status               <em>undocumented</em>
 * @param DesignLocationCUs    [[ch.ninecode.model.DesignLocationCU DesignLocationCU]] <em>undocumented</em>
 * @param DesignLocations      [[ch.ninecode.model.DesignLocation DesignLocation]] <em>undocumented</em>
 * @param Designs              [[ch.ninecode.model.Design Design]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Work package is used to define classes related to work. There are several different aspects of work.
 *            The Work Initiation (Work, Project, Request).
 *            The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
 *            The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
 *            The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
 *            The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
 *            This package is used for inspection and maintenance (InspectionDataSet, Procedure).
 *            The WorkService package defines Appointment class".
 */
final case class ConditionFactor
(
    WorkIdentifiedObject: WorkIdentifiedObject = null,
    cfValue: String = null,
    kind: String = null,
    status: String = null,
    DesignLocationCUs: List[String] = null,
    DesignLocations: List[String] = null,
    Designs: List[String] = null
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
    override def sup: WorkIdentifiedObject = WorkIdentifiedObject

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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ConditionFactor.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ConditionFactor.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ConditionFactor.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ConditionFactor.fields (position), x))

        emitelem (0, cfValue)
        emitattr (1, kind)
        emitattr (2, status)
        emitattrs (3, DesignLocationCUs)
        emitattrs (4, DesignLocations)
        emitattrs (5, Designs)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ConditionFactor rdf:ID=\"%s\">\n%s\t</cim:ConditionFactor>".format (id, export_fields)
    }
}

object ConditionFactor
    extends
        CIMParseable[ConditionFactor]
{
    override val fields: Array[String] = Array [String](
        "cfValue",
        "kind",
        "status",
        "DesignLocationCUs",
        "DesignLocations",
        "Designs"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("DesignLocationCUs", "DesignLocationCU", "0..*", "0..*"),
        CIMRelationship ("DesignLocations", "DesignLocation", "0..*", "0..*"),
        CIMRelationship ("Designs", "Design", "0..*", "0..*")
    )
    val cfValue: Fielder = parse_element (element (cls, fields (0)))
    val kind: Fielder = parse_attribute (attribute (cls, fields (1)))
    val status: Fielder = parse_attribute (attribute (cls, fields (2)))
    val DesignLocationCUs: FielderMultiple = parse_attributes (attribute (cls, fields (3)))
    val DesignLocations: FielderMultiple = parse_attributes (attribute (cls, fields (4)))
    val Designs: FielderMultiple = parse_attributes (attribute (cls, fields (5)))

    def parse (context: CIMContext): ConditionFactor =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = ConditionFactor (
            WorkIdentifiedObject.parse (context),
            mask (cfValue (), 0),
            mask (kind (), 1),
            mask (status (), 2),
            masks (DesignLocationCUs (), 3),
            masks (DesignLocations (), 4),
            masks (Designs (), 5)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ConditionFactor] = ConditionFactorSerializer
}

object ConditionFactorSerializer extends CIMSerializer[ConditionFactor]
{
    def write (kryo: Kryo, output: Output, obj: ConditionFactor): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.cfValue),
            () => output.writeString (obj.kind),
            () => output.writeString (obj.status),
            () => writeList (obj.DesignLocationCUs, output),
            () => writeList (obj.DesignLocations, output),
            () => writeList (obj.Designs, output)
        )
        WorkIdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ConditionFactor]): ConditionFactor =
    {
        val parent = WorkIdentifiedObjectSerializer.read (kryo, input, classOf [WorkIdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ConditionFactor (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) readList (input) else null,
            if (isSet (5)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Contractor information for work task.
 *
 * @param WorkIdentifiedObject [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param activityCode         Activity code identifies a specific and distinguishable unit of work.
 * @param bidAmount            The amount that a given contractor will charge for performing this unit of work.
 * @param cost                 The total amount charged.
 * @param status               <em>undocumented</em>
 * @param ErpPayables          [[ch.ninecode.model.ErpPayable ErpPayable]] <em>undocumented</em>
 * @param WorkCostDetail       [[ch.ninecode.model.WorkCostDetail WorkCostDetail]] <em>undocumented</em>
 * @param WorkTask             [[ch.ninecode.model.OldWorkTask OldWorkTask]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Work package is used to define classes related to work. There are several different aspects of work.
 *            The Work Initiation (Work, Project, Request).
 *            The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
 *            The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
 *            The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
 *            The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
 *            This package is used for inspection and maintenance (InspectionDataSet, Procedure).
 *            The WorkService package defines Appointment class".
 */
final case class ContractorItem
(
    WorkIdentifiedObject: WorkIdentifiedObject = null,
    activityCode: String = null,
    bidAmount: Double = 0.0,
    cost: Double = 0.0,
    status: String = null,
    ErpPayables: List[String] = null,
    WorkCostDetail: String = null,
    WorkTask: String = null
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
    override def sup: WorkIdentifiedObject = WorkIdentifiedObject

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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ContractorItem.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ContractorItem.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ContractorItem.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ContractorItem.fields (position), x))

        emitelem (0, activityCode)
        emitelem (1, bidAmount)
        emitelem (2, cost)
        emitattr (3, status)
        emitattrs (4, ErpPayables)
        emitattr (5, WorkCostDetail)
        emitattr (6, WorkTask)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ContractorItem rdf:ID=\"%s\">\n%s\t</cim:ContractorItem>".format (id, export_fields)
    }
}

object ContractorItem
    extends
        CIMParseable[ContractorItem]
{
    override val fields: Array[String] = Array [String](
        "activityCode",
        "bidAmount",
        "cost",
        "status",
        "ErpPayables",
        "WorkCostDetail",
        "WorkTask"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ErpPayables", "ErpPayable", "0..*", "0..*"),
        CIMRelationship ("WorkCostDetail", "WorkCostDetail", "1", "0..*"),
        CIMRelationship ("WorkTask", "OldWorkTask", "0..1", "0..*")
    )
    val activityCode: Fielder = parse_element (element (cls, fields (0)))
    val bidAmount: Fielder = parse_element (element (cls, fields (1)))
    val cost: Fielder = parse_element (element (cls, fields (2)))
    val status: Fielder = parse_attribute (attribute (cls, fields (3)))
    val ErpPayables: FielderMultiple = parse_attributes (attribute (cls, fields (4)))
    val WorkCostDetail: Fielder = parse_attribute (attribute (cls, fields (5)))
    val WorkTask: Fielder = parse_attribute (attribute (cls, fields (6)))

    def parse (context: CIMContext): ContractorItem =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = ContractorItem (
            WorkIdentifiedObject.parse (context),
            mask (activityCode (), 0),
            toDouble (mask (bidAmount (), 1)),
            toDouble (mask (cost (), 2)),
            mask (status (), 3),
            masks (ErpPayables (), 4),
            mask (WorkCostDetail (), 5),
            mask (WorkTask (), 6)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ContractorItem] = ContractorItemSerializer
}

object ContractorItemSerializer extends CIMSerializer[ContractorItem]
{
    def write (kryo: Kryo, output: Output, obj: ContractorItem): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.activityCode),
            () => output.writeDouble (obj.bidAmount),
            () => output.writeDouble (obj.cost),
            () => output.writeString (obj.status),
            () => writeList (obj.ErpPayables, output),
            () => output.writeString (obj.WorkCostDetail),
            () => output.writeString (obj.WorkTask)
        )
        WorkIdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ContractorItem]): ContractorItem =
    {
        val parent = WorkIdentifiedObjectSerializer.read (kryo, input, classOf [WorkIdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ContractorItem (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) readList (input) else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A categorization for resources, often costs, in accounting transactions.
 *
 * Examples include: material components, building in service, coal sales, overhead, etc.
 *
 * @param WorkIdentifiedObject [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param amountAssignable     True if an amount can be assigned to the resource element (e.g., building in service, transmission plant, software development capital); false otherwise (e.g., internal labor, material components).
 * @param code                 A codified representation of the resource element.
 * @param level                The level of the resource element in the hierarchy of resource elements (recursive relationship).
 * @param stage                The stage for which this costType applies: estimated design, estimated actual or actual actual.
 * @param status               <em>undocumented</em>
 * @param ChildCostTypes       [[ch.ninecode.model.CostType CostType]] <em>undocumented</em>
 * @param CompatibleUnits      [[ch.ninecode.model.CompatibleUnit CompatibleUnit]] <em>undocumented</em>
 * @param ErpJournalEntries    [[ch.ninecode.model.ErpJournalEntry ErpJournalEntry]] <em>undocumented</em>
 * @param ParentCostType       [[ch.ninecode.model.CostType CostType]] <em>undocumented</em>
 * @param WorkCostDetails      [[ch.ninecode.model.WorkCostDetail WorkCostDetail]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Work package is used to define classes related to work. There are several different aspects of work.
 *            The Work Initiation (Work, Project, Request).
 *            The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
 *            The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
 *            The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
 *            The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
 *            This package is used for inspection and maintenance (InspectionDataSet, Procedure).
 *            The WorkService package defines Appointment class".
 */
final case class CostType
(
    WorkIdentifiedObject: WorkIdentifiedObject = null,
    amountAssignable: Boolean = false,
    code: String = null,
    level: String = null,
    stage: String = null,
    status: String = null,
    ChildCostTypes: List[String] = null,
    CompatibleUnits: List[String] = null,
    ErpJournalEntries: List[String] = null,
    ParentCostType: String = null,
    WorkCostDetails: List[String] = null
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
    override def sup: WorkIdentifiedObject = WorkIdentifiedObject

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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CostType.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CostType.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CostType.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (CostType.fields (position), x))

        emitelem (0, amountAssignable)
        emitelem (1, code)
        emitelem (2, level)
        emitelem (3, stage)
        emitattr (4, status)
        emitattrs (5, ChildCostTypes)
        emitattrs (6, CompatibleUnits)
        emitattrs (7, ErpJournalEntries)
        emitattr (8, ParentCostType)
        emitattrs (9, WorkCostDetails)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:CostType rdf:ID=\"%s\">\n%s\t</cim:CostType>".format (id, export_fields)
    }
}

object CostType
    extends
        CIMParseable[CostType]
{
    override val fields: Array[String] = Array [String](
        "amountAssignable",
        "code",
        "level",
        "stage",
        "status",
        "ChildCostTypes",
        "CompatibleUnits",
        "ErpJournalEntries",
        "ParentCostType",
        "WorkCostDetails"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ChildCostTypes", "CostType", "0..*", "0..1"),
        CIMRelationship ("CompatibleUnits", "CompatibleUnit", "0..*", "0..1"),
        CIMRelationship ("ErpJournalEntries", "ErpJournalEntry", "0..*", "0..*"),
        CIMRelationship ("ParentCostType", "CostType", "0..1", "0..*"),
        CIMRelationship ("WorkCostDetails", "WorkCostDetail", "0..*", "1")
    )
    val amountAssignable: Fielder = parse_element (element (cls, fields (0)))
    val code: Fielder = parse_element (element (cls, fields (1)))
    val level: Fielder = parse_element (element (cls, fields (2)))
    val stage: Fielder = parse_element (element (cls, fields (3)))
    val status: Fielder = parse_attribute (attribute (cls, fields (4)))
    val ChildCostTypes: FielderMultiple = parse_attributes (attribute (cls, fields (5)))
    val CompatibleUnits: FielderMultiple = parse_attributes (attribute (cls, fields (6)))
    val ErpJournalEntries: FielderMultiple = parse_attributes (attribute (cls, fields (7)))
    val ParentCostType: Fielder = parse_attribute (attribute (cls, fields (8)))
    val WorkCostDetails: FielderMultiple = parse_attributes (attribute (cls, fields (9)))

    def parse (context: CIMContext): CostType =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = CostType (
            WorkIdentifiedObject.parse (context),
            toBoolean (mask (amountAssignable (), 0)),
            mask (code (), 1),
            mask (level (), 2),
            mask (stage (), 3),
            mask (status (), 4),
            masks (ChildCostTypes (), 5),
            masks (CompatibleUnits (), 6),
            masks (ErpJournalEntries (), 7),
            mask (ParentCostType (), 8),
            masks (WorkCostDetails (), 9)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[CostType] = CostTypeSerializer
}

object CostTypeSerializer extends CIMSerializer[CostType]
{
    def write (kryo: Kryo, output: Output, obj: CostType): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeBoolean (obj.amountAssignable),
            () => output.writeString (obj.code),
            () => output.writeString (obj.level),
            () => output.writeString (obj.stage),
            () => output.writeString (obj.status),
            () => writeList (obj.ChildCostTypes, output),
            () => writeList (obj.CompatibleUnits, output),
            () => writeList (obj.ErpJournalEntries, output),
            () => output.writeString (obj.ParentCostType),
            () => writeList (obj.WorkCostDetails, output)
        )
        WorkIdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CostType]): CostType =
    {
        val parent = WorkIdentifiedObjectSerializer.read (kryo, input, classOf [WorkIdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = CostType (
            parent,
            if (isSet (0)) input.readBoolean else false,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) readList (input) else null,
            if (isSet (6)) readList (input) else null,
            if (isSet (7)) readList (input) else null,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A design for consideration by customers, potential customers, or internal work.
 *
 * Note that the Version of design is the revision attribute that is inherited from Document.
 *
 * @param WorkDocument       [[ch.ninecode.model.WorkDocument WorkDocument]] Reference to the superclass object.
 * @param costEstimate       Estimated cost (not price) of design.
 * @param kind               Kind of this design.
 * @param price              Price to customer for implementing design.
 * @param ConditionFactors   [[ch.ninecode.model.ConditionFactor ConditionFactor]] <em>undocumented</em>
 * @param DesignLocations    [[ch.ninecode.model.DesignLocation DesignLocation]] <em>undocumented</em>
 * @param DesignLocationsCUs [[ch.ninecode.model.DesignLocationCU DesignLocationCU]] <em>undocumented</em>
 * @param ErpBOMs            [[ch.ninecode.model.ErpBOM ErpBOM]] <em>undocumented</em>
 * @param ErpQuoteLineItem   [[ch.ninecode.model.ErpQuoteLineItem ErpQuoteLineItem]] <em>undocumented</em>
 * @param Work               [[ch.ninecode.model.Work Work]] <em>undocumented</em>
 * @param WorkCostDetails    [[ch.ninecode.model.WorkCostDetail WorkCostDetail]] <em>undocumented</em>
 * @param WorkTasks          [[ch.ninecode.model.OldWorkTask OldWorkTask]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Work package is used to define classes related to work. There are several different aspects of work.
 *            The Work Initiation (Work, Project, Request).
 *            The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
 *            The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
 *            The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
 *            The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
 *            This package is used for inspection and maintenance (InspectionDataSet, Procedure).
 *            The WorkService package defines Appointment class".
 */
final case class Design
(
    WorkDocument: WorkDocument = null,
    costEstimate: Double = 0.0,
    kind: String = null,
    price: Double = 0.0,
    ConditionFactors: List[String] = null,
    DesignLocations: List[String] = null,
    DesignLocationsCUs: List[String] = null,
    ErpBOMs: List[String] = null,
    ErpQuoteLineItem: String = null,
    Work: String = null,
    WorkCostDetails: List[String] = null,
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
    override def sup: WorkDocument = WorkDocument

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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Design.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Design.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Design.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Design.fields (position), x))

        emitelem (0, costEstimate)
        emitattr (1, kind)
        emitelem (2, price)
        emitattrs (3, ConditionFactors)
        emitattrs (4, DesignLocations)
        emitattrs (5, DesignLocationsCUs)
        emitattrs (6, ErpBOMs)
        emitattr (7, ErpQuoteLineItem)
        emitattr (8, Work)
        emitattrs (9, WorkCostDetails)
        emitattrs (10, WorkTasks)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:Design rdf:ID=\"%s\">\n%s\t</cim:Design>".format (id, export_fields)
    }
}

object Design
    extends
        CIMParseable[Design]
{
    override val fields: Array[String] = Array [String](
        "costEstimate",
        "kind",
        "price",
        "ConditionFactors",
        "DesignLocations",
        "DesignLocationsCUs",
        "ErpBOMs",
        "ErpQuoteLineItem",
        "Work",
        "WorkCostDetails",
        "WorkTasks"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ConditionFactors", "ConditionFactor", "0..*", "0..*"),
        CIMRelationship ("DesignLocations", "DesignLocation", "0..*", "1..*"),
        CIMRelationship ("DesignLocationsCUs", "DesignLocationCU", "0..*", "0..*"),
        CIMRelationship ("ErpBOMs", "ErpBOM", "0..*", "0..1"),
        CIMRelationship ("ErpQuoteLineItem", "ErpQuoteLineItem", "0..1", "0..1"),
        CIMRelationship ("Work", "Work", "0..1", "0..*"),
        CIMRelationship ("WorkCostDetails", "WorkCostDetail", "0..*", "0..1"),
        CIMRelationship ("WorkTasks", "OldWorkTask", "0..*", "0..1")
    )
    val costEstimate: Fielder = parse_element (element (cls, fields (0)))
    val kind: Fielder = parse_attribute (attribute (cls, fields (1)))
    val price: Fielder = parse_element (element (cls, fields (2)))
    val ConditionFactors: FielderMultiple = parse_attributes (attribute (cls, fields (3)))
    val DesignLocations: FielderMultiple = parse_attributes (attribute (cls, fields (4)))
    val DesignLocationsCUs: FielderMultiple = parse_attributes (attribute (cls, fields (5)))
    val ErpBOMs: FielderMultiple = parse_attributes (attribute (cls, fields (6)))
    val ErpQuoteLineItem: Fielder = parse_attribute (attribute (cls, fields (7)))
    val Work: Fielder = parse_attribute (attribute (cls, fields (8)))
    val WorkCostDetails: FielderMultiple = parse_attributes (attribute (cls, fields (9)))
    val WorkTasks: FielderMultiple = parse_attributes (attribute (cls, fields (10)))

    def parse (context: CIMContext): Design =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = Design (
            WorkDocument.parse (context),
            toDouble (mask (costEstimate (), 0)),
            mask (kind (), 1),
            toDouble (mask (price (), 2)),
            masks (ConditionFactors (), 3),
            masks (DesignLocations (), 4),
            masks (DesignLocationsCUs (), 5),
            masks (ErpBOMs (), 6),
            mask (ErpQuoteLineItem (), 7),
            mask (Work (), 8),
            masks (WorkCostDetails (), 9),
            masks (WorkTasks (), 10)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Design] = DesignSerializer
}

object DesignSerializer extends CIMSerializer[Design]
{
    def write (kryo: Kryo, output: Output, obj: Design): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.costEstimate),
            () => output.writeString (obj.kind),
            () => output.writeDouble (obj.price),
            () => writeList (obj.ConditionFactors, output),
            () => writeList (obj.DesignLocations, output),
            () => writeList (obj.DesignLocationsCUs, output),
            () => writeList (obj.ErpBOMs, output),
            () => output.writeString (obj.ErpQuoteLineItem),
            () => output.writeString (obj.Work),
            () => writeList (obj.WorkCostDetails, output),
            () => writeList (obj.WorkTasks, output)
        )
        WorkDocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Design]): Design =
    {
        val parent = WorkDocumentSerializer.read (kryo, input, classOf [WorkDocument])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Design (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) readList (input) else null,
            if (isSet (5)) readList (input) else null,
            if (isSet (6)) readList (input) else null,
            if (isSet (7)) input.readString else null,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) readList (input) else null,
            if (isSet (10)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A logical part of the design (e.g., pole and all equipment on a pole).
 *
 * This includes points and spans.
 *
 * @param WorkIdentifiedObject [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param spanLength           The legth of the span from the previous pole to this pole.
 * @param status               <em>undocumented</em>
 * @param ConditionFactors     [[ch.ninecode.model.ConditionFactor ConditionFactor]] <em>undocumented</em>
 * @param DesignLocationCUs    [[ch.ninecode.model.DesignLocationCU DesignLocationCU]] <em>undocumented</em>
 * @param Designs              [[ch.ninecode.model.Design Design]] <em>undocumented</em>
 * @param ErpBomItemDatas      [[ch.ninecode.model.ErpBomItemData ErpBomItemData]] <em>undocumented</em>
 * @param MiscCostItems        [[ch.ninecode.model.MiscCostItem MiscCostItem]] <em>undocumented</em>
 * @param WorkLocations        [[ch.ninecode.model.WorkLocation WorkLocation]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Work package is used to define classes related to work. There are several different aspects of work.
 *            The Work Initiation (Work, Project, Request).
 *            The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
 *            The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
 *            The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
 *            The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
 *            This package is used for inspection and maintenance (InspectionDataSet, Procedure).
 *            The WorkService package defines Appointment class".
 */
final case class DesignLocation
(
    WorkIdentifiedObject: WorkIdentifiedObject = null,
    spanLength: Double = 0.0,
    status: String = null,
    ConditionFactors: List[String] = null,
    DesignLocationCUs: List[String] = null,
    Designs: List[String] = null,
    ErpBomItemDatas: List[String] = null,
    MiscCostItems: List[String] = null,
    WorkLocations: List[String] = null
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
    override def sup: WorkIdentifiedObject = WorkIdentifiedObject

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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = DesignLocation.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DesignLocation.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DesignLocation.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (DesignLocation.fields (position), x))

        emitelem (0, spanLength)
        emitattr (1, status)
        emitattrs (2, ConditionFactors)
        emitattrs (3, DesignLocationCUs)
        emitattrs (4, Designs)
        emitattrs (5, ErpBomItemDatas)
        emitattrs (6, MiscCostItems)
        emitattrs (7, WorkLocations)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:DesignLocation rdf:ID=\"%s\">\n%s\t</cim:DesignLocation>".format (id, export_fields)
    }
}

object DesignLocation
    extends
        CIMParseable[DesignLocation]
{
    override val fields: Array[String] = Array [String](
        "spanLength",
        "status",
        "ConditionFactors",
        "DesignLocationCUs",
        "Designs",
        "ErpBomItemDatas",
        "MiscCostItems",
        "WorkLocations"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ConditionFactors", "ConditionFactor", "0..*", "0..*"),
        CIMRelationship ("DesignLocationCUs", "DesignLocationCU", "0..*", "0..1"),
        CIMRelationship ("Designs", "Design", "1..*", "0..*"),
        CIMRelationship ("ErpBomItemDatas", "ErpBomItemData", "0..*", "0..1"),
        CIMRelationship ("MiscCostItems", "MiscCostItem", "0..*", "0..1"),
        CIMRelationship ("WorkLocations", "WorkLocation", "1..*", "0..*")
    )
    val spanLength: Fielder = parse_element (element (cls, fields (0)))
    val status: Fielder = parse_attribute (attribute (cls, fields (1)))
    val ConditionFactors: FielderMultiple = parse_attributes (attribute (cls, fields (2)))
    val DesignLocationCUs: FielderMultiple = parse_attributes (attribute (cls, fields (3)))
    val Designs: FielderMultiple = parse_attributes (attribute (cls, fields (4)))
    val ErpBomItemDatas: FielderMultiple = parse_attributes (attribute (cls, fields (5)))
    val MiscCostItems: FielderMultiple = parse_attributes (attribute (cls, fields (6)))
    val WorkLocations: FielderMultiple = parse_attributes (attribute (cls, fields (7)))

    def parse (context: CIMContext): DesignLocation =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = DesignLocation (
            WorkIdentifiedObject.parse (context),
            toDouble (mask (spanLength (), 0)),
            mask (status (), 1),
            masks (ConditionFactors (), 2),
            masks (DesignLocationCUs (), 3),
            masks (Designs (), 4),
            masks (ErpBomItemDatas (), 5),
            masks (MiscCostItems (), 6),
            masks (WorkLocations (), 7)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[DesignLocation] = DesignLocationSerializer
}

object DesignLocationSerializer extends CIMSerializer[DesignLocation]
{
    def write (kryo: Kryo, output: Output, obj: DesignLocation): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.spanLength),
            () => output.writeString (obj.status),
            () => writeList (obj.ConditionFactors, output),
            () => writeList (obj.DesignLocationCUs, output),
            () => writeList (obj.Designs, output),
            () => writeList (obj.ErpBomItemDatas, output),
            () => writeList (obj.MiscCostItems, output),
            () => writeList (obj.WorkLocations, output)
        )
        WorkIdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DesignLocation]): DesignLocation =
    {
        val parent = WorkIdentifiedObjectSerializer.read (kryo, input, classOf [WorkIdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = DesignLocation (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) readList (input) else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) readList (input) else null,
            if (isSet (5)) readList (input) else null,
            if (isSet (6)) readList (input) else null,
            if (isSet (7)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Compatible unit at a given design location.
 *
 * @param WorkIdentifiedObject [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param cuAccount            A code that helps direct accounting (capital, expense, or accounting treatment).
 * @param cuAction             A code that instructs the crew what action to perform.
 * @param cuQuantity           The quantity of the CU being assigned to this location.
 * @param cuUsage              As the same CU can be used for different purposes and accounting purposes, usage must be specified.
 *                             Examples include: distribution, transmission, substation.
 * @param removalDate          Year when a CU that represents an asset is removed.
 * @param status               <em>undocumented</em>
 * @param toBeEnergised        True if associated electrical equipment is intended to be energized while work is being performed.
 * @param CUGroups             [[ch.ninecode.model.CUGroup CUGroup]] <em>undocumented</em>
 * @param CompatibleUnits      [[ch.ninecode.model.CompatibleUnit CompatibleUnit]] <em>undocumented</em>
 * @param ConditionFactors     [[ch.ninecode.model.ConditionFactor ConditionFactor]] <em>undocumented</em>
 * @param DesignLocation       [[ch.ninecode.model.DesignLocation DesignLocation]] <em>undocumented</em>
 * @param Designs              [[ch.ninecode.model.Design Design]] <em>undocumented</em>
 * @param WorkTasks            [[ch.ninecode.model.OldWorkTask OldWorkTask]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Work package is used to define classes related to work. There are several different aspects of work.
 *            The Work Initiation (Work, Project, Request).
 *            The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
 *            The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
 *            The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
 *            The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
 *            This package is used for inspection and maintenance (InspectionDataSet, Procedure).
 *            The WorkService package defines Appointment class".
 */
final case class DesignLocationCU
(
    WorkIdentifiedObject: WorkIdentifiedObject = null,
    cuAccount: String = null,
    cuAction: String = null,
    cuQuantity: String = null,
    cuUsage: String = null,
    removalDate: String = null,
    status: String = null,
    toBeEnergised: Boolean = false,
    CUGroups: List[String] = null,
    CompatibleUnits: List[String] = null,
    ConditionFactors: List[String] = null,
    DesignLocation: String = null,
    Designs: List[String] = null,
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
    override def sup: WorkIdentifiedObject = WorkIdentifiedObject

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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = DesignLocationCU.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DesignLocationCU.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DesignLocationCU.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (DesignLocationCU.fields (position), x))

        emitelem (0, cuAccount)
        emitattr (1, cuAction)
        emitattr (2, cuQuantity)
        emitelem (3, cuUsage)
        emitelem (4, removalDate)
        emitattr (5, status)
        emitelem (6, toBeEnergised)
        emitattrs (7, CUGroups)
        emitattrs (8, CompatibleUnits)
        emitattrs (9, ConditionFactors)
        emitattr (10, DesignLocation)
        emitattrs (11, Designs)
        emitattrs (12, WorkTasks)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:DesignLocationCU rdf:ID=\"%s\">\n%s\t</cim:DesignLocationCU>".format (id, export_fields)
    }
}

object DesignLocationCU
    extends
        CIMParseable[DesignLocationCU]
{
    override val fields: Array[String] = Array [String](
        "cuAccount",
        "cuAction",
        "cuQuantity",
        "cuUsage",
        "removalDate",
        "status",
        "toBeEnergised",
        "CUGroups",
        "CompatibleUnits",
        "ConditionFactors",
        "DesignLocation",
        "Designs",
        "WorkTasks"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("CUGroups", "CUGroup", "0..*", "0..*"),
        CIMRelationship ("CompatibleUnits", "CompatibleUnit", "0..*", "0..*"),
        CIMRelationship ("ConditionFactors", "ConditionFactor", "0..*", "0..*"),
        CIMRelationship ("DesignLocation", "DesignLocation", "0..1", "0..*"),
        CIMRelationship ("Designs", "Design", "0..*", "0..*"),
        CIMRelationship ("WorkTasks", "OldWorkTask", "0..*", "0..*")
    )
    val cuAccount: Fielder = parse_element (element (cls, fields (0)))
    val cuAction: Fielder = parse_attribute (attribute (cls, fields (1)))
    val cuQuantity: Fielder = parse_attribute (attribute (cls, fields (2)))
    val cuUsage: Fielder = parse_element (element (cls, fields (3)))
    val removalDate: Fielder = parse_element (element (cls, fields (4)))
    val status: Fielder = parse_attribute (attribute (cls, fields (5)))
    val toBeEnergised: Fielder = parse_element (element (cls, fields (6)))
    val CUGroups: FielderMultiple = parse_attributes (attribute (cls, fields (7)))
    val CompatibleUnits: FielderMultiple = parse_attributes (attribute (cls, fields (8)))
    val ConditionFactors: FielderMultiple = parse_attributes (attribute (cls, fields (9)))
    val DesignLocation: Fielder = parse_attribute (attribute (cls, fields (10)))
    val Designs: FielderMultiple = parse_attributes (attribute (cls, fields (11)))
    val WorkTasks: FielderMultiple = parse_attributes (attribute (cls, fields (12)))

    def parse (context: CIMContext): DesignLocationCU =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = DesignLocationCU (
            WorkIdentifiedObject.parse (context),
            mask (cuAccount (), 0),
            mask (cuAction (), 1),
            mask (cuQuantity (), 2),
            mask (cuUsage (), 3),
            mask (removalDate (), 4),
            mask (status (), 5),
            toBoolean (mask (toBeEnergised (), 6)),
            masks (CUGroups (), 7),
            masks (CompatibleUnits (), 8),
            masks (ConditionFactors (), 9),
            mask (DesignLocation (), 10),
            masks (Designs (), 11),
            masks (WorkTasks (), 12)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[DesignLocationCU] = DesignLocationCUSerializer
}

object DesignLocationCUSerializer extends CIMSerializer[DesignLocationCU]
{
    def write (kryo: Kryo, output: Output, obj: DesignLocationCU): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.cuAccount),
            () => output.writeString (obj.cuAction),
            () => output.writeString (obj.cuQuantity),
            () => output.writeString (obj.cuUsage),
            () => output.writeString (obj.removalDate),
            () => output.writeString (obj.status),
            () => output.writeBoolean (obj.toBeEnergised),
            () => writeList (obj.CUGroups, output),
            () => writeList (obj.CompatibleUnits, output),
            () => writeList (obj.ConditionFactors, output),
            () => output.writeString (obj.DesignLocation),
            () => writeList (obj.Designs, output),
            () => writeList (obj.WorkTasks, output)
        )
        WorkIdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DesignLocationCU]): DesignLocationCU =
    {
        val parent = WorkIdentifiedObjectSerializer.read (kryo, input, classOf [WorkIdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = DesignLocationCU (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readBoolean else false,
            if (isSet (7)) readList (input) else null,
            if (isSet (8)) readList (input) else null,
            if (isSet (9)) readList (input) else null,
            if (isSet (10)) input.readString else null,
            if (isSet (11)) readList (input) else null,
            if (isSet (12)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Questions and answers associated with a type of document for purposes of clarification.
 *
 * Questions may be predefined or ad hoc.
 *
 * @param WorkDocument   [[ch.ninecode.model.WorkDocument WorkDocument]] Reference to the superclass object.
 * @param answer         Answer to question.
 * @param answerDateTime The date and time the quesiton was answered.
 * @param answerRemark   Remarks to qualify the answer.
 * @param questionCode   The question code.
 *                       If blank, refer to questionText.
 * @param questionRemark Remarks to qualify the question in this situation.
 * @param questionText   For non-coded questions, the question is provided here.
 * @param questionType   The type of the question.
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Work package is used to define classes related to work. There are several different aspects of work.
 *            The Work Initiation (Work, Project, Request).
 *            The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
 *            The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
 *            The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
 *            The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
 *            This package is used for inspection and maintenance (InspectionDataSet, Procedure).
 *            The WorkService package defines Appointment class".
 */
final case class InfoQuestion
(
    WorkDocument: WorkDocument = null,
    answer: String = null,
    answerDateTime: String = null,
    answerRemark: String = null,
    questionCode: String = null,
    questionRemark: String = null,
    questionText: String = null,
    questionType: String = null
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
    override def sup: WorkDocument = WorkDocument

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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = InfoQuestion.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (InfoQuestion.fields (position), value)

        emitelem (0, answer)
        emitelem (1, answerDateTime)
        emitelem (2, answerRemark)
        emitelem (3, questionCode)
        emitelem (4, questionRemark)
        emitelem (5, questionText)
        emitelem (6, questionType)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:InfoQuestion rdf:ID=\"%s\">\n%s\t</cim:InfoQuestion>".format (id, export_fields)
    }
}

object InfoQuestion
    extends
        CIMParseable[InfoQuestion]
{
    override val fields: Array[String] = Array [String](
        "answer",
        "answerDateTime",
        "answerRemark",
        "questionCode",
        "questionRemark",
        "questionText",
        "questionType"
    )
    val answer: Fielder = parse_element (element (cls, fields (0)))
    val answerDateTime: Fielder = parse_element (element (cls, fields (1)))
    val answerRemark: Fielder = parse_element (element (cls, fields (2)))
    val questionCode: Fielder = parse_element (element (cls, fields (3)))
    val questionRemark: Fielder = parse_element (element (cls, fields (4)))
    val questionText: Fielder = parse_element (element (cls, fields (5)))
    val questionType: Fielder = parse_element (element (cls, fields (6)))

    def parse (context: CIMContext): InfoQuestion =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = InfoQuestion (
            WorkDocument.parse (context),
            mask (answer (), 0),
            mask (answerDateTime (), 1),
            mask (answerRemark (), 2),
            mask (questionCode (), 3),
            mask (questionRemark (), 4),
            mask (questionText (), 5),
            mask (questionType (), 6)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[InfoQuestion] = InfoQuestionSerializer
}

object InfoQuestionSerializer extends CIMSerializer[InfoQuestion]
{
    def write (kryo: Kryo, output: Output, obj: InfoQuestion): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.answer),
            () => output.writeString (obj.answerDateTime),
            () => output.writeString (obj.answerRemark),
            () => output.writeString (obj.questionCode),
            () => output.writeString (obj.questionRemark),
            () => output.writeString (obj.questionText),
            () => output.writeString (obj.questionType)
        )
        WorkDocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[InfoQuestion]): InfoQuestion =
    {
        val parent = WorkDocumentSerializer.read (kryo, input, classOf [WorkDocument])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = InfoQuestion (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Labor used for work order.
 *
 * @param WorkIdentifiedObject [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param activityCode         Activity code identifies a specific and distinguishable unit of work.
 * @param cost                 Total cost for labor.
 *                             Note that this may not be able to be derived from labor rate and time charged.
 * @param laborDuration        Time required to perform work.
 * @param laborRate            The labor rate applied for work.
 * @param status               <em>undocumented</em>
 * @param ErpPersons           [[ch.ninecode.model.OldPerson OldPerson]] <em>undocumented</em>
 * @param WorkCostDetail       [[ch.ninecode.model.WorkCostDetail WorkCostDetail]] <em>undocumented</em>
 * @param WorkTask             [[ch.ninecode.model.OldWorkTask OldWorkTask]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Work package is used to define classes related to work. There are several different aspects of work.
 *            The Work Initiation (Work, Project, Request).
 *            The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
 *            The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
 *            The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
 *            The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
 *            This package is used for inspection and maintenance (InspectionDataSet, Procedure).
 *            The WorkService package defines Appointment class".
 */
final case class LaborItem
(
    WorkIdentifiedObject: WorkIdentifiedObject = null,
    activityCode: String = null,
    cost: Double = 0.0,
    laborDuration: Double = 0.0,
    laborRate: Double = 0.0,
    status: String = null,
    ErpPersons: List[String] = null,
    WorkCostDetail: String = null,
    WorkTask: String = null
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
    override def sup: WorkIdentifiedObject = WorkIdentifiedObject

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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = LaborItem.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (LaborItem.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (LaborItem.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (LaborItem.fields (position), x))

        emitelem (0, activityCode)
        emitelem (1, cost)
        emitelem (2, laborDuration)
        emitelem (3, laborRate)
        emitattr (4, status)
        emitattrs (5, ErpPersons)
        emitattr (6, WorkCostDetail)
        emitattr (7, WorkTask)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:LaborItem rdf:ID=\"%s\">\n%s\t</cim:LaborItem>".format (id, export_fields)
    }
}

object LaborItem
    extends
        CIMParseable[LaborItem]
{
    override val fields: Array[String] = Array [String](
        "activityCode",
        "cost",
        "laborDuration",
        "laborRate",
        "status",
        "ErpPersons",
        "WorkCostDetail",
        "WorkTask"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ErpPersons", "OldPerson", "0..*", "0..*"),
        CIMRelationship ("WorkCostDetail", "WorkCostDetail", "1", "0..*"),
        CIMRelationship ("WorkTask", "OldWorkTask", "0..1", "0..*")
    )
    val activityCode: Fielder = parse_element (element (cls, fields (0)))
    val cost: Fielder = parse_element (element (cls, fields (1)))
    val laborDuration: Fielder = parse_element (element (cls, fields (2)))
    val laborRate: Fielder = parse_element (element (cls, fields (3)))
    val status: Fielder = parse_attribute (attribute (cls, fields (4)))
    val ErpPersons: FielderMultiple = parse_attributes (attribute (cls, fields (5)))
    val WorkCostDetail: Fielder = parse_attribute (attribute (cls, fields (6)))
    val WorkTask: Fielder = parse_attribute (attribute (cls, fields (7)))

    def parse (context: CIMContext): LaborItem =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = LaborItem (
            WorkIdentifiedObject.parse (context),
            mask (activityCode (), 0),
            toDouble (mask (cost (), 1)),
            toDouble (mask (laborDuration (), 2)),
            toDouble (mask (laborRate (), 3)),
            mask (status (), 4),
            masks (ErpPersons (), 5),
            mask (WorkCostDetail (), 6),
            mask (WorkTask (), 7)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[LaborItem] = LaborItemSerializer
}

object LaborItemSerializer extends CIMSerializer[LaborItem]
{
    def write (kryo: Kryo, output: Output, obj: LaborItem): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.activityCode),
            () => output.writeDouble (obj.cost),
            () => output.writeDouble (obj.laborDuration),
            () => output.writeDouble (obj.laborRate),
            () => output.writeString (obj.status),
            () => writeList (obj.ErpPersons, output),
            () => output.writeString (obj.WorkCostDetail),
            () => output.writeString (obj.WorkTask)
        )
        WorkIdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[LaborItem]): LaborItem =
    {
        val parent = WorkIdentifiedObjectSerializer.read (kryo, input, classOf [WorkIdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = LaborItem (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) readList (input) else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Various cost items that are not associated with compatible units.
 *
 * Examples include rental equipment, labor, materials, contractor costs, permits - anything not covered in a CU.
 *
 * @param WorkIdentifiedObject [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param account              This drives the accounting treatment for this misc. item.
 * @param costPerUnit          The cost per unit for this misc. item.
 * @param costType             The cost type for accounting, such as material, labor, vehicle, contractor, equipment, overhead.
 * @param externalRefID        External reference identifier (e.g. purchase order number, serial number) .
 * @param quantity             The quantity of the misc. item being assigned to this location.
 * @param status               <em>undocumented</em>
 * @param DesignLocation       [[ch.ninecode.model.DesignLocation DesignLocation]] <em>undocumented</em>
 * @param WorkCostDetail       [[ch.ninecode.model.WorkCostDetail WorkCostDetail]] <em>undocumented</em>
 * @param WorkTask             [[ch.ninecode.model.OldWorkTask OldWorkTask]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Work package is used to define classes related to work. There are several different aspects of work.
 *            The Work Initiation (Work, Project, Request).
 *            The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
 *            The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
 *            The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
 *            The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
 *            This package is used for inspection and maintenance (InspectionDataSet, Procedure).
 *            The WorkService package defines Appointment class".
 */
final case class MiscCostItem
(
    WorkIdentifiedObject: WorkIdentifiedObject = null,
    account: String = null,
    costPerUnit: Double = 0.0,
    costType: String = null,
    externalRefID: String = null,
    quantity: String = null,
    status: String = null,
    DesignLocation: String = null,
    WorkCostDetail: String = null,
    WorkTask: String = null
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
    override def sup: WorkIdentifiedObject = WorkIdentifiedObject

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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MiscCostItem.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MiscCostItem.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MiscCostItem.fields (position), value)

        emitelem (0, account)
        emitelem (1, costPerUnit)
        emitelem (2, costType)
        emitelem (3, externalRefID)
        emitattr (4, quantity)
        emitattr (5, status)
        emitattr (6, DesignLocation)
        emitattr (7, WorkCostDetail)
        emitattr (8, WorkTask)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:MiscCostItem rdf:ID=\"%s\">\n%s\t</cim:MiscCostItem>".format (id, export_fields)
    }
}

object MiscCostItem
    extends
        CIMParseable[MiscCostItem]
{
    override val fields: Array[String] = Array [String](
        "account",
        "costPerUnit",
        "costType",
        "externalRefID",
        "quantity",
        "status",
        "DesignLocation",
        "WorkCostDetail",
        "WorkTask"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("DesignLocation", "DesignLocation", "0..1", "0..*"),
        CIMRelationship ("WorkCostDetail", "WorkCostDetail", "0..1", "0..*"),
        CIMRelationship ("WorkTask", "OldWorkTask", "0..1", "0..*")
    )
    val account: Fielder = parse_element (element (cls, fields (0)))
    val costPerUnit: Fielder = parse_element (element (cls, fields (1)))
    val costType: Fielder = parse_element (element (cls, fields (2)))
    val externalRefID: Fielder = parse_element (element (cls, fields (3)))
    val quantity: Fielder = parse_attribute (attribute (cls, fields (4)))
    val status: Fielder = parse_attribute (attribute (cls, fields (5)))
    val DesignLocation: Fielder = parse_attribute (attribute (cls, fields (6)))
    val WorkCostDetail: Fielder = parse_attribute (attribute (cls, fields (7)))
    val WorkTask: Fielder = parse_attribute (attribute (cls, fields (8)))

    def parse (context: CIMContext): MiscCostItem =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = MiscCostItem (
            WorkIdentifiedObject.parse (context),
            mask (account (), 0),
            toDouble (mask (costPerUnit (), 1)),
            mask (costType (), 2),
            mask (externalRefID (), 3),
            mask (quantity (), 4),
            mask (status (), 5),
            mask (DesignLocation (), 6),
            mask (WorkCostDetail (), 7),
            mask (WorkTask (), 8)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[MiscCostItem] = MiscCostItemSerializer
}

object MiscCostItemSerializer extends CIMSerializer[MiscCostItem]
{
    def write (kryo: Kryo, output: Output, obj: MiscCostItem): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.account),
            () => output.writeDouble (obj.costPerUnit),
            () => output.writeString (obj.costType),
            () => output.writeString (obj.externalRefID),
            () => output.writeString (obj.quantity),
            () => output.writeString (obj.status),
            () => output.writeString (obj.DesignLocation),
            () => output.writeString (obj.WorkCostDetail),
            () => output.writeString (obj.WorkTask)
        )
        WorkIdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MiscCostItem]): MiscCostItem =
    {
        val parent = WorkIdentifiedObjectSerializer.read (kryo, input, classOf [WorkIdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = MiscCostItem (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) input.readString else null,
            if (isSet (8)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * This document provides information for non-standard items like customer contributions (e.g., customer digs trench), vouchers (e.g., credit), and contractor bids.
 *
 * @param WorkDocument [[ch.ninecode.model.WorkDocument WorkDocument]] Reference to the superclass object.
 * @param amount       The projected cost for this item.
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Work package is used to define classes related to work. There are several different aspects of work.
 *            The Work Initiation (Work, Project, Request).
 *            The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
 *            The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
 *            The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
 *            The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
 *            This package is used for inspection and maintenance (InspectionDataSet, Procedure).
 *            The WorkService package defines Appointment class".
 */
final case class NonStandardItem
(
    WorkDocument: WorkDocument = null,
    amount: Double = 0.0
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
    override def sup: WorkDocument = WorkDocument

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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = NonStandardItem.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (NonStandardItem.fields (position), value)

        emitelem (0, amount)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:NonStandardItem rdf:ID=\"%s\">\n%s\t</cim:NonStandardItem>".format (id, export_fields)
    }
}

object NonStandardItem
    extends
        CIMParseable[NonStandardItem]
{
    override val fields: Array[String] = Array [String](
        "amount"
    )
    val amount: Fielder = parse_element (element (cls, fields (0)))

    def parse (context: CIMContext): NonStandardItem =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = NonStandardItem (
            WorkDocument.parse (context),
            toDouble (mask (amount (), 0))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[NonStandardItem] = NonStandardItemSerializer
}

object NonStandardItemSerializer extends CIMSerializer[NonStandardItem]
{
    def write (kryo: Kryo, output: Output, obj: NonStandardItem): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.amount)
        )
        WorkDocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[NonStandardItem]): NonStandardItem =
    {
        val parent = WorkDocumentSerializer.read (kryo, input, classOf [WorkDocument])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = NonStandardItem (
            parent,
            if (isSet (0)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A set of tasks is required to implement a design.
 *
 * @param WorkTask                  [[ch.ninecode.model.WorkTask WorkTask]] Reference to the superclass object.
 * @param Capabilities              [[ch.ninecode.model.Capability Capability]] <em>undocumented</em>
 * @param ContractorItems           [[ch.ninecode.model.ContractorItem ContractorItem]] <em>undocumented</em>
 * @param Design                    [[ch.ninecode.model.Design Design]] <em>undocumented</em>
 * @param DesignLocationCUs         [[ch.ninecode.model.DesignLocationCU DesignLocationCU]] <em>undocumented</em>
 * @param LaborItems                [[ch.ninecode.model.LaborItem LaborItem]] <em>undocumented</em>
 * @param MiscCostItems             [[ch.ninecode.model.MiscCostItem MiscCostItem]] <em>undocumented</em>
 * @param OverheadCost              [[ch.ninecode.model.OverheadCost OverheadCost]] <em>undocumented</em>
 * @param QualificationRequirements [[ch.ninecode.model.QualificationRequirement QualificationRequirement]] <em>undocumented</em>
 * @param Usages                    [[ch.ninecode.model.Usage Usage]] <em>undocumented</em>
 * @param WorkCostDetails           [[ch.ninecode.model.WorkCostDetail WorkCostDetail]] <em>undocumented</em>
 * @param WorkFlowStep              [[ch.ninecode.model.WorkFlowStep WorkFlowStep]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Work package is used to define classes related to work. There are several different aspects of work.
 *            The Work Initiation (Work, Project, Request).
 *            The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
 *            The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
 *            The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
 *            The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
 *            This package is used for inspection and maintenance (InspectionDataSet, Procedure).
 *            The WorkService package defines Appointment class".
 */
final case class OldWorkTask
(
    WorkTask: WorkTask = null,
    Capabilities: List[String] = null,
    ContractorItems: List[String] = null,
    Design: String = null,
    DesignLocationCUs: List[String] = null,
    LaborItems: List[String] = null,
    MiscCostItems: List[String] = null,
    OverheadCost: String = null,
    QualificationRequirements: List[String] = null,
    Usages: List[String] = null,
    WorkCostDetails: List[String] = null,
    WorkFlowStep: String = null
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
    override def sup: WorkTask = WorkTask

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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = OldWorkTask.cls

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OldWorkTask.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (OldWorkTask.fields (position), x))

        emitattrs (0, Capabilities)
        emitattrs (1, ContractorItems)
        emitattr (2, Design)
        emitattrs (3, DesignLocationCUs)
        emitattrs (4, LaborItems)
        emitattrs (5, MiscCostItems)
        emitattr (6, OverheadCost)
        emitattrs (7, QualificationRequirements)
        emitattrs (8, Usages)
        emitattrs (9, WorkCostDetails)
        emitattr (10, WorkFlowStep)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:OldWorkTask rdf:ID=\"%s\">\n%s\t</cim:OldWorkTask>".format (id, export_fields)
    }
}

object OldWorkTask
    extends
        CIMParseable[OldWorkTask]
{
    override val fields: Array[String] = Array [String](
        "Capabilities",
        "ContractorItems",
        "Design",
        "DesignLocationCUs",
        "LaborItems",
        "MiscCostItems",
        "OverheadCost",
        "QualificationRequirements",
        "Usages",
        "WorkCostDetails",
        "WorkFlowStep"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Capabilities", "Capability", "0..*", "0..*"),
        CIMRelationship ("ContractorItems", "ContractorItem", "0..*", "0..1"),
        CIMRelationship ("Design", "Design", "0..1", "0..*"),
        CIMRelationship ("DesignLocationCUs", "DesignLocationCU", "0..*", "0..*"),
        CIMRelationship ("LaborItems", "LaborItem", "0..*", "0..1"),
        CIMRelationship ("MiscCostItems", "MiscCostItem", "0..*", "0..1"),
        CIMRelationship ("OverheadCost", "OverheadCost", "0..1", "0..*"),
        CIMRelationship ("QualificationRequirements", "QualificationRequirement", "0..*", "0..*"),
        CIMRelationship ("Usages", "Usage", "0..*", "0..1"),
        CIMRelationship ("WorkCostDetails", "WorkCostDetail", "0..*", "0..1"),
        CIMRelationship ("WorkFlowStep", "WorkFlowStep", "0..1", "0..*")
    )
    val Capabilities: FielderMultiple = parse_attributes (attribute (cls, fields (0)))
    val ContractorItems: FielderMultiple = parse_attributes (attribute (cls, fields (1)))
    val Design: Fielder = parse_attribute (attribute (cls, fields (2)))
    val DesignLocationCUs: FielderMultiple = parse_attributes (attribute (cls, fields (3)))
    val LaborItems: FielderMultiple = parse_attributes (attribute (cls, fields (4)))
    val MiscCostItems: FielderMultiple = parse_attributes (attribute (cls, fields (5)))
    val OverheadCost: Fielder = parse_attribute (attribute (cls, fields (6)))
    val QualificationRequirements: FielderMultiple = parse_attributes (attribute (cls, fields (7)))
    val Usages: FielderMultiple = parse_attributes (attribute (cls, fields (8)))
    val WorkCostDetails: FielderMultiple = parse_attributes (attribute (cls, fields (9)))
    val WorkFlowStep: Fielder = parse_attribute (attribute (cls, fields (10)))

    def parse (context: CIMContext): OldWorkTask =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = OldWorkTask (
            WorkTask.parse (context),
            masks (Capabilities (), 0),
            masks (ContractorItems (), 1),
            mask (Design (), 2),
            masks (DesignLocationCUs (), 3),
            masks (LaborItems (), 4),
            masks (MiscCostItems (), 5),
            mask (OverheadCost (), 6),
            masks (QualificationRequirements (), 7),
            masks (Usages (), 8),
            masks (WorkCostDetails (), 9),
            mask (WorkFlowStep (), 10)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[OldWorkTask] = OldWorkTaskSerializer
}

object OldWorkTaskSerializer extends CIMSerializer[OldWorkTask]
{
    def write (kryo: Kryo, output: Output, obj: OldWorkTask): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.Capabilities, output),
            () => writeList (obj.ContractorItems, output),
            () => output.writeString (obj.Design),
            () => writeList (obj.DesignLocationCUs, output),
            () => writeList (obj.LaborItems, output),
            () => writeList (obj.MiscCostItems, output),
            () => output.writeString (obj.OverheadCost),
            () => writeList (obj.QualificationRequirements, output),
            () => writeList (obj.Usages, output),
            () => writeList (obj.WorkCostDetails, output),
            () => output.writeString (obj.WorkFlowStep)
        )
        WorkTaskSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OldWorkTask]): OldWorkTask =
    {
        val parent = WorkTaskSerializer.read (kryo, input, classOf [WorkTask])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = OldWorkTask (
            parent,
            if (isSet (0)) readList (input) else null,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) readList (input) else null,
            if (isSet (5)) readList (input) else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) readList (input) else null,
            if (isSet (8)) readList (input) else null,
            if (isSet (9)) readList (input) else null,
            if (isSet (10)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A request for other utilities to mark their underground facilities prior to commencement of construction and/or maintenance.
 *
 * @param WorkDocument       [[ch.ninecode.model.WorkDocument WorkDocument]] Reference to the superclass object.
 * @param explosivesUsed     True if explosives have been or are planned to be used.
 * @param markedIndicator    True if work location has been marked, for example for a dig area.
 * @param markingInstruction Instructions for marking a dig area, if applicable.
 * @param WorkLocations      [[ch.ninecode.model.WorkLocation WorkLocation]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Work package is used to define classes related to work. There are several different aspects of work.
 *            The Work Initiation (Work, Project, Request).
 *            The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
 *            The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
 *            The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
 *            The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
 *            This package is used for inspection and maintenance (InspectionDataSet, Procedure).
 *            The WorkService package defines Appointment class".
 */
final case class OneCallRequest
(
    WorkDocument: WorkDocument = null,
    explosivesUsed: Boolean = false,
    markedIndicator: Boolean = false,
    markingInstruction: String = null,
    WorkLocations: List[String] = null
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
    override def sup: WorkDocument = WorkDocument

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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = OneCallRequest.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (OneCallRequest.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (OneCallRequest.fields (position), x))

        emitelem (0, explosivesUsed)
        emitelem (1, markedIndicator)
        emitelem (2, markingInstruction)
        emitattrs (3, WorkLocations)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:OneCallRequest rdf:ID=\"%s\">\n%s\t</cim:OneCallRequest>".format (id, export_fields)
    }
}

object OneCallRequest
    extends
        CIMParseable[OneCallRequest]
{
    override val fields: Array[String] = Array [String](
        "explosivesUsed",
        "markedIndicator",
        "markingInstruction",
        "WorkLocations"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("WorkLocations", "WorkLocation", "0..*", "0..1")
    )
    val explosivesUsed: Fielder = parse_element (element (cls, fields (0)))
    val markedIndicator: Fielder = parse_element (element (cls, fields (1)))
    val markingInstruction: Fielder = parse_element (element (cls, fields (2)))
    val WorkLocations: FielderMultiple = parse_attributes (attribute (cls, fields (3)))

    def parse (context: CIMContext): OneCallRequest =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = OneCallRequest (
            WorkDocument.parse (context),
            toBoolean (mask (explosivesUsed (), 0)),
            toBoolean (mask (markedIndicator (), 1)),
            mask (markingInstruction (), 2),
            masks (WorkLocations (), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[OneCallRequest] = OneCallRequestSerializer
}

object OneCallRequestSerializer extends CIMSerializer[OneCallRequest]
{
    def write (kryo: Kryo, output: Output, obj: OneCallRequest): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeBoolean (obj.explosivesUsed),
            () => output.writeBoolean (obj.markedIndicator),
            () => output.writeString (obj.markingInstruction),
            () => writeList (obj.WorkLocations, output)
        )
        WorkDocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OneCallRequest]): OneCallRequest =
    {
        val parent = WorkDocumentSerializer.read (kryo, input, classOf [WorkDocument])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = OneCallRequest (
            parent,
            if (isSet (0)) input.readBoolean else false,
            if (isSet (1)) input.readBoolean else false,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Overhead cost applied to work order.
 *
 * @param WorkIdentifiedObject [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param code                 Overhead code.
 * @param cost                 The overhead cost to be applied.
 * @param status               <em>undocumented</em>
 * @param WorkCostDetails      [[ch.ninecode.model.WorkCostDetail WorkCostDetail]] <em>undocumented</em>
 * @param WorkTasks            [[ch.ninecode.model.OldWorkTask OldWorkTask]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Work package is used to define classes related to work. There are several different aspects of work.
 *            The Work Initiation (Work, Project, Request).
 *            The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
 *            The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
 *            The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
 *            The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
 *            This package is used for inspection and maintenance (InspectionDataSet, Procedure).
 *            The WorkService package defines Appointment class".
 */
final case class OverheadCost
(
    WorkIdentifiedObject: WorkIdentifiedObject = null,
    code: String = null,
    cost: Double = 0.0,
    status: String = null,
    WorkCostDetails: List[String] = null,
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
    override def sup: WorkIdentifiedObject = WorkIdentifiedObject

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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = OverheadCost.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (OverheadCost.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OverheadCost.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (OverheadCost.fields (position), x))

        emitelem (0, code)
        emitelem (1, cost)
        emitattr (2, status)
        emitattrs (3, WorkCostDetails)
        emitattrs (4, WorkTasks)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:OverheadCost rdf:ID=\"%s\">\n%s\t</cim:OverheadCost>".format (id, export_fields)
    }
}

object OverheadCost
    extends
        CIMParseable[OverheadCost]
{
    override val fields: Array[String] = Array [String](
        "code",
        "cost",
        "status",
        "WorkCostDetails",
        "WorkTasks"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("WorkCostDetails", "WorkCostDetail", "0..*", "0..1"),
        CIMRelationship ("WorkTasks", "OldWorkTask", "0..*", "0..1")
    )
    val code: Fielder = parse_element (element (cls, fields (0)))
    val cost: Fielder = parse_element (element (cls, fields (1)))
    val status: Fielder = parse_attribute (attribute (cls, fields (2)))
    val WorkCostDetails: FielderMultiple = parse_attributes (attribute (cls, fields (3)))
    val WorkTasks: FielderMultiple = parse_attributes (attribute (cls, fields (4)))

    def parse (context: CIMContext): OverheadCost =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = OverheadCost (
            WorkIdentifiedObject.parse (context),
            mask (code (), 0),
            toDouble (mask (cost (), 1)),
            mask (status (), 2),
            masks (WorkCostDetails (), 3),
            masks (WorkTasks (), 4)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[OverheadCost] = OverheadCostSerializer
}

object OverheadCostSerializer extends CIMSerializer[OverheadCost]
{
    def write (kryo: Kryo, output: Output, obj: OverheadCost): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.code),
            () => output.writeDouble (obj.cost),
            () => output.writeString (obj.status),
            () => writeList (obj.WorkCostDetails, output),
            () => writeList (obj.WorkTasks, output)
        )
        WorkIdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OverheadCost]): OverheadCost =
    {
        val parent = WorkIdentifiedObjectSerializer.read (kryo, input, classOf [WorkIdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = OverheadCost (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A collection of related work.
 *
 * For construction projects and maintenance projects, multiple phases may be performed.
 *
 * @param WorkDocument         [[ch.ninecode.model.WorkDocument WorkDocument]] Reference to the superclass object.
 * @param budget               Overall project budget.
 * @param BusinessCase         [[ch.ninecode.model.BusinessCase BusinessCase]] <em>undocumented</em>
 * @param ErpProjectAccounting [[ch.ninecode.model.ErpProjectAccounting ErpProjectAccounting]] <em>undocumented</em>
 * @param ParentProject        [[ch.ninecode.model.Project Project]] <em>undocumented</em>
 * @param SubProjects          [[ch.ninecode.model.Project Project]] <em>undocumented</em>
 * @param Works                [[ch.ninecode.model.Work Work]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Work package is used to define classes related to work. There are several different aspects of work.
 *            The Work Initiation (Work, Project, Request).
 *            The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
 *            The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
 *            The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
 *            The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
 *            This package is used for inspection and maintenance (InspectionDataSet, Procedure).
 *            The WorkService package defines Appointment class".
 */
final case class Project
(
    WorkDocument: WorkDocument = null,
    budget: Double = 0.0,
    BusinessCase: String = null,
    ErpProjectAccounting: String = null,
    ParentProject: String = null,
    SubProjects: List[String] = null,
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
    override def sup: WorkDocument = WorkDocument

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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Project.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Project.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Project.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Project.fields (position), x))

        emitelem (0, budget)
        emitattr (1, BusinessCase)
        emitattr (2, ErpProjectAccounting)
        emitattr (3, ParentProject)
        emitattrs (4, SubProjects)
        emitattrs (5, Works)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:Project rdf:ID=\"%s\">\n%s\t</cim:Project>".format (id, export_fields)
    }
}

object Project
    extends
        CIMParseable[Project]
{
    override val fields: Array[String] = Array [String](
        "budget",
        "BusinessCase",
        "ErpProjectAccounting",
        "ParentProject",
        "SubProjects",
        "Works"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("BusinessCase", "BusinessCase", "0..1", "0..*"),
        CIMRelationship ("ErpProjectAccounting", "ErpProjectAccounting", "1", "0..*"),
        CIMRelationship ("ParentProject", "Project", "0..1", "0..*"),
        CIMRelationship ("SubProjects", "Project", "0..*", "0..1"),
        CIMRelationship ("Works", "Work", "0..*", "0..1")
    )
    val budget: Fielder = parse_element (element (cls, fields (0)))
    val BusinessCase: Fielder = parse_attribute (attribute (cls, fields (1)))
    val ErpProjectAccounting: Fielder = parse_attribute (attribute (cls, fields (2)))
    val ParentProject: Fielder = parse_attribute (attribute (cls, fields (3)))
    val SubProjects: FielderMultiple = parse_attributes (attribute (cls, fields (4)))
    val Works: FielderMultiple = parse_attributes (attribute (cls, fields (5)))

    def parse (context: CIMContext): Project =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = Project (
            WorkDocument.parse (context),
            toDouble (mask (budget (), 0)),
            mask (BusinessCase (), 1),
            mask (ErpProjectAccounting (), 2),
            mask (ParentProject (), 3),
            masks (SubProjects (), 4),
            masks (Works (), 5)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Project] = ProjectSerializer
}

object ProjectSerializer extends CIMSerializer[Project]
{
    def write (kryo: Kryo, output: Output, obj: Project): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.budget),
            () => output.writeString (obj.BusinessCase),
            () => output.writeString (obj.ErpProjectAccounting),
            () => output.writeString (obj.ParentProject),
            () => writeList (obj.SubProjects, output),
            () => writeList (obj.Works, output)
        )
        WorkDocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Project]): Project =
    {
        val parent = WorkDocumentSerializer.read (kryo, input, classOf [WorkDocument])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Project (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) readList (input) else null,
            if (isSet (5)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Unit of property for reporting purposes.
 *
 * @param WorkIdentifiedObject [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param accountingUsage      A code that identifies appropriate type of property accounts such as distribution, streetlgihts, communications.
 * @param activityCode         Activity code identifies a specific and distinguishable work action.
 * @param propertyAccount      Used for property record accounting.
 *                             For example, in the USA, this would be a FERC account.
 * @param status               <em>undocumented</em>
 * @param CUMaterialItems      [[ch.ninecode.model.CUMaterialItem CUMaterialItem]] <em>undocumented</em>
 * @param CompatibleUnits      [[ch.ninecode.model.CompatibleUnit CompatibleUnit]] <em>undocumented</em>
 * @param WorkCostDetails      [[ch.ninecode.model.WorkCostDetail WorkCostDetail]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Work package is used to define classes related to work. There are several different aspects of work.
 *            The Work Initiation (Work, Project, Request).
 *            The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
 *            The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
 *            The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
 *            The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
 *            This package is used for inspection and maintenance (InspectionDataSet, Procedure).
 *            The WorkService package defines Appointment class".
 */
final case class PropertyUnit
(
    WorkIdentifiedObject: WorkIdentifiedObject = null,
    accountingUsage: String = null,
    activityCode: String = null,
    propertyAccount: String = null,
    status: String = null,
    CUMaterialItems: List[String] = null,
    CompatibleUnits: List[String] = null,
    WorkCostDetails: List[String] = null
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
    override def sup: WorkIdentifiedObject = WorkIdentifiedObject

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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PropertyUnit.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PropertyUnit.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PropertyUnit.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (PropertyUnit.fields (position), x))

        emitelem (0, accountingUsage)
        emitattr (1, activityCode)
        emitelem (2, propertyAccount)
        emitattr (3, status)
        emitattrs (4, CUMaterialItems)
        emitattrs (5, CompatibleUnits)
        emitattrs (6, WorkCostDetails)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:PropertyUnit rdf:ID=\"%s\">\n%s\t</cim:PropertyUnit>".format (id, export_fields)
    }
}

object PropertyUnit
    extends
        CIMParseable[PropertyUnit]
{
    override val fields: Array[String] = Array [String](
        "accountingUsage",
        "activityCode",
        "propertyAccount",
        "status",
        "CUMaterialItems",
        "CompatibleUnits",
        "WorkCostDetails"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("CUMaterialItems", "CUMaterialItem", "0..*", "0..*"),
        CIMRelationship ("CompatibleUnits", "CompatibleUnit", "0..*", "0..1"),
        CIMRelationship ("WorkCostDetails", "WorkCostDetail", "0..*", "0..*")
    )
    val accountingUsage: Fielder = parse_element (element (cls, fields (0)))
    val activityCode: Fielder = parse_attribute (attribute (cls, fields (1)))
    val propertyAccount: Fielder = parse_element (element (cls, fields (2)))
    val status: Fielder = parse_attribute (attribute (cls, fields (3)))
    val CUMaterialItems: FielderMultiple = parse_attributes (attribute (cls, fields (4)))
    val CompatibleUnits: FielderMultiple = parse_attributes (attribute (cls, fields (5)))
    val WorkCostDetails: FielderMultiple = parse_attributes (attribute (cls, fields (6)))

    def parse (context: CIMContext): PropertyUnit =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = PropertyUnit (
            WorkIdentifiedObject.parse (context),
            mask (accountingUsage (), 0),
            mask (activityCode (), 1),
            mask (propertyAccount (), 2),
            mask (status (), 3),
            masks (CUMaterialItems (), 4),
            masks (CompatibleUnits (), 5),
            masks (WorkCostDetails (), 6)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[PropertyUnit] = PropertyUnitSerializer
}

object PropertyUnitSerializer extends CIMSerializer[PropertyUnit]
{
    def write (kryo: Kryo, output: Output, obj: PropertyUnit): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.accountingUsage),
            () => output.writeString (obj.activityCode),
            () => output.writeString (obj.propertyAccount),
            () => output.writeString (obj.status),
            () => writeList (obj.CUMaterialItems, output),
            () => writeList (obj.CompatibleUnits, output),
            () => writeList (obj.WorkCostDetails, output)
        )
        WorkIdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PropertyUnit]): PropertyUnit =
    {
        val parent = WorkIdentifiedObjectSerializer.read (kryo, input, classOf [WorkIdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PropertyUnit (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) readList (input) else null,
            if (isSet (5)) readList (input) else null,
            if (isSet (6)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Certain skills are required and must be certified in order for a person (typically a member of a crew) to be qualified to work on types of equipment.
 *
 * @param WorkIdentifiedObject [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param qualificationID      Qualification identifier.
 * @param CULaborItems         [[ch.ninecode.model.CULaborItem CULaborItem]] <em>undocumented</em>
 * @param Skills               [[ch.ninecode.model.Skill Skill]] <em>undocumented</em>
 * @param Specifications       [[ch.ninecode.model.Specification Specification]] <em>undocumented</em>
 * @param WorkTasks            [[ch.ninecode.model.OldWorkTask OldWorkTask]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Work package is used to define classes related to work. There are several different aspects of work.
 *            The Work Initiation (Work, Project, Request).
 *            The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
 *            The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
 *            The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
 *            The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
 *            This package is used for inspection and maintenance (InspectionDataSet, Procedure).
 *            The WorkService package defines Appointment class".
 */
final case class QualificationRequirement
(
    WorkIdentifiedObject: WorkIdentifiedObject = null,
    qualificationID: String = null,
    CULaborItems: List[String] = null,
    Skills: List[String] = null,
    Specifications: List[String] = null,
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
    override def sup: WorkIdentifiedObject = WorkIdentifiedObject

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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = QualificationRequirement.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (QualificationRequirement.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (QualificationRequirement.fields (position), x))

        emitelem (0, qualificationID)
        emitattrs (1, CULaborItems)
        emitattrs (2, Skills)
        emitattrs (3, Specifications)
        emitattrs (4, WorkTasks)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:QualificationRequirement rdf:ID=\"%s\">\n%s\t</cim:QualificationRequirement>".format (id, export_fields)
    }
}

object QualificationRequirement
    extends
        CIMParseable[QualificationRequirement]
{
    override val fields: Array[String] = Array [String](
        "qualificationID",
        "CULaborItems",
        "Skills",
        "Specifications",
        "WorkTasks"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("CULaborItems", "CULaborItem", "0..*", "0..*"),
        CIMRelationship ("Skills", "Skill", "0..*", "0..*"),
        CIMRelationship ("Specifications", "Specification", "0..*", "0..*"),
        CIMRelationship ("WorkTasks", "OldWorkTask", "0..*", "0..*")
    )
    val qualificationID: Fielder = parse_element (element (cls, fields (0)))
    val CULaborItems: FielderMultiple = parse_attributes (attribute (cls, fields (1)))
    val Skills: FielderMultiple = parse_attributes (attribute (cls, fields (2)))
    val Specifications: FielderMultiple = parse_attributes (attribute (cls, fields (3)))
    val WorkTasks: FielderMultiple = parse_attributes (attribute (cls, fields (4)))

    def parse (context: CIMContext): QualificationRequirement =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = QualificationRequirement (
            WorkIdentifiedObject.parse (context),
            mask (qualificationID (), 0),
            masks (CULaborItems (), 1),
            masks (Skills (), 2),
            masks (Specifications (), 3),
            masks (WorkTasks (), 4)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[QualificationRequirement] = QualificationRequirementSerializer
}

object QualificationRequirementSerializer extends CIMSerializer[QualificationRequirement]
{
    def write (kryo: Kryo, output: Output, obj: QualificationRequirement): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.qualificationID),
            () => writeList (obj.CULaborItems, output),
            () => writeList (obj.Skills, output),
            () => writeList (obj.Specifications, output),
            () => writeList (obj.WorkTasks, output)
        )
        WorkIdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[QualificationRequirement]): QualificationRequirement =
    {
        val parent = WorkIdentifiedObjectSerializer.read (kryo, input, classOf [WorkIdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = QualificationRequirement (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) readList (input) else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Special requirements and/or regulations may pertain to certain types of assets or work.
 *
 * For example, fire protection and scaffolding.
 *
 * @param WorkDocument    [[ch.ninecode.model.WorkDocument WorkDocument]] Reference to the superclass object.
 * @param referenceNumber External reference to regulation, if applicable.
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Work package is used to define classes related to work. There are several different aspects of work.
 *            The Work Initiation (Work, Project, Request).
 *            The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
 *            The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
 *            The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
 *            The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
 *            This package is used for inspection and maintenance (InspectionDataSet, Procedure).
 *            The WorkService package defines Appointment class".
 */
final case class Regulation
(
    WorkDocument: WorkDocument = null,
    referenceNumber: String = null
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
    override def sup: WorkDocument = WorkDocument

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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Regulation.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Regulation.fields (position), value)

        emitelem (0, referenceNumber)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:Regulation rdf:ID=\"%s\">\n%s\t</cim:Regulation>".format (id, export_fields)
    }
}

object Regulation
    extends
        CIMParseable[Regulation]
{
    override val fields: Array[String] = Array [String](
        "referenceNumber"
    )
    val referenceNumber: Fielder = parse_element (element (cls, fields (0)))

    def parse (context: CIMContext): Regulation =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = Regulation (
            WorkDocument.parse (context),
            mask (referenceNumber (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Regulation] = RegulationSerializer
}

object RegulationSerializer extends CIMSerializer[Regulation]
{
    def write (kryo: Kryo, output: Output, obj: Regulation): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.referenceNumber)
        )
        WorkDocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Regulation]): Regulation =
    {
        val parent = WorkDocumentSerializer.read (kryo, input, classOf [WorkDocument])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Regulation (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The patterns of shifts worked by people or crews.
 *
 * @param WorkIdentifiedObject [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param assignmentType       Type of assignement intended to be worked on this shift, for example, temporary, standard, etc.
 * @param cycleCount           Number of cycles for a temporary shift.
 * @param status               <em>undocumented</em>
 * @param validityInterval     Date and time interval for which this shift pattern is valid (when it became effective and when it expires).
 * @param Crews                [[ch.ninecode.model.OldCrew OldCrew]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Work package is used to define classes related to work. There are several different aspects of work.
 *            The Work Initiation (Work, Project, Request).
 *            The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
 *            The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
 *            The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
 *            The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
 *            This package is used for inspection and maintenance (InspectionDataSet, Procedure).
 *            The WorkService package defines Appointment class".
 */
final case class ShiftPattern
(
    WorkIdentifiedObject: WorkIdentifiedObject = null,
    assignmentType: String = null,
    cycleCount: Int = 0,
    status: String = null,
    validityInterval: String = null,
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
    override def sup: WorkIdentifiedObject = WorkIdentifiedObject

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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ShiftPattern.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ShiftPattern.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ShiftPattern.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ShiftPattern.fields (position), x))

        emitelem (0, assignmentType)
        emitelem (1, cycleCount)
        emitattr (2, status)
        emitattr (3, validityInterval)
        emitattrs (4, Crews)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ShiftPattern rdf:ID=\"%s\">\n%s\t</cim:ShiftPattern>".format (id, export_fields)
    }
}

object ShiftPattern
    extends
        CIMParseable[ShiftPattern]
{
    override val fields: Array[String] = Array [String](
        "assignmentType",
        "cycleCount",
        "status",
        "validityInterval",
        "Crews"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Crews", "OldCrew", "0..*", "0..*")
    )
    val assignmentType: Fielder = parse_element (element (cls, fields (0)))
    val cycleCount: Fielder = parse_element (element (cls, fields (1)))
    val status: Fielder = parse_attribute (attribute (cls, fields (2)))
    val validityInterval: Fielder = parse_attribute (attribute (cls, fields (3)))
    val Crews: FielderMultiple = parse_attributes (attribute (cls, fields (4)))

    def parse (context: CIMContext): ShiftPattern =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = ShiftPattern (
            WorkIdentifiedObject.parse (context),
            mask (assignmentType (), 0),
            toInteger (mask (cycleCount (), 1)),
            mask (status (), 2),
            mask (validityInterval (), 3),
            masks (Crews (), 4)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ShiftPattern] = ShiftPatternSerializer
}

object ShiftPatternSerializer extends CIMSerializer[ShiftPattern]
{
    def write (kryo: Kryo, output: Output, obj: ShiftPattern): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.assignmentType),
            () => output.writeInt (obj.cycleCount),
            () => output.writeString (obj.status),
            () => output.writeString (obj.validityInterval),
            () => writeList (obj.Crews, output)
        )
        WorkIdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ShiftPattern]): ShiftPattern =
    {
        val parent = WorkIdentifiedObjectSerializer.read (kryo, input, classOf [WorkIdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ShiftPattern (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readInt else 0,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Documentation for a generic material item that may be used for design, work and other purposes.
 *
 * Any number of MaterialItems manufactured by various vendors may be used to perform this TypeMaterial.
 * Note that class analagous to "AssetModel" is not used for material items. This is because in some cases, for example, a utility sets up a Master material record for a 3 inch long half inch diameter steel bolt and they do not necessarily care what specific supplier is providing the material item. As different vendors are used to supply the part, the Stock Code of the material item can stay the same. In other cases, each time the vendor changes, a new stock code is set up so they can track material used by vendor. Therefore a Material Item "Model" is not typically needed.
 *
 * @param WorkDocument        [[ch.ninecode.model.WorkDocument WorkDocument]] Reference to the superclass object.
 * @param costType            The type of cost to which this Material Item belongs.
 * @param estUnitCost         The estimated unit cost of this type of material, either for a unit cost or cost per unit length.
 *                            Cost is for material or asset only and does not include labor to install/construct or configure it.
 * @param quantity            The value, unit of measure, and multiplier for the quantity.
 * @param stockItem           True if item is a stock item (default).
 * @param CUMaterialItems     [[ch.ninecode.model.CUMaterialItem CUMaterialItem]] <em>undocumented</em>
 * @param ErpIssueInventories [[ch.ninecode.model.ErpIssueInventory ErpIssueInventory]] <em>undocumented</em>
 * @param ErpReqLineItems     [[ch.ninecode.model.ErpReqLineItem ErpReqLineItem]] <em>undocumented</em>
 * @param MaterialItems       [[ch.ninecode.model.MaterialItem MaterialItem]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Work package is used to define classes related to work. There are several different aspects of work.
 *            The Work Initiation (Work, Project, Request).
 *            The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
 *            The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
 *            The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
 *            The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
 *            This package is used for inspection and maintenance (InspectionDataSet, Procedure).
 *            The WorkService package defines Appointment class".
 */
final case class TypeMaterial
(
    WorkDocument: WorkDocument = null,
    costType: String = null,
    estUnitCost: Double = 0.0,
    quantity: String = null,
    stockItem: Boolean = false,
    CUMaterialItems: List[String] = null,
    ErpIssueInventories: List[String] = null,
    ErpReqLineItems: List[String] = null,
    MaterialItems: List[String] = null
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
    override def sup: WorkDocument = WorkDocument

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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TypeMaterial.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TypeMaterial.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (TypeMaterial.fields (position), x))

        emitelem (0, costType)
        emitelem (1, estUnitCost)
        emitelem (2, quantity)
        emitelem (3, stockItem)
        emitattrs (4, CUMaterialItems)
        emitattrs (5, ErpIssueInventories)
        emitattrs (6, ErpReqLineItems)
        emitattrs (7, MaterialItems)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:TypeMaterial rdf:ID=\"%s\">\n%s\t</cim:TypeMaterial>".format (id, export_fields)
    }
}

object TypeMaterial
    extends
        CIMParseable[TypeMaterial]
{
    override val fields: Array[String] = Array [String](
        "costType",
        "estUnitCost",
        "quantity",
        "stockItem",
        "CUMaterialItems",
        "ErpIssueInventories",
        "ErpReqLineItems",
        "MaterialItems"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("CUMaterialItems", "CUMaterialItem", "0..*", "0..1"),
        CIMRelationship ("ErpIssueInventories", "ErpIssueInventory", "0..*", "0..1"),
        CIMRelationship ("ErpReqLineItems", "ErpReqLineItem", "0..*", "0..1"),
        CIMRelationship ("MaterialItems", "MaterialItem", "0..*", "0..1")
    )
    val costType: Fielder = parse_element (element (cls, fields (0)))
    val estUnitCost: Fielder = parse_element (element (cls, fields (1)))
    val quantity: Fielder = parse_element (element (cls, fields (2)))
    val stockItem: Fielder = parse_element (element (cls, fields (3)))
    val CUMaterialItems: FielderMultiple = parse_attributes (attribute (cls, fields (4)))
    val ErpIssueInventories: FielderMultiple = parse_attributes (attribute (cls, fields (5)))
    val ErpReqLineItems: FielderMultiple = parse_attributes (attribute (cls, fields (6)))
    val MaterialItems: FielderMultiple = parse_attributes (attribute (cls, fields (7)))

    def parse (context: CIMContext): TypeMaterial =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = TypeMaterial (
            WorkDocument.parse (context),
            mask (costType (), 0),
            toDouble (mask (estUnitCost (), 1)),
            mask (quantity (), 2),
            toBoolean (mask (stockItem (), 3)),
            masks (CUMaterialItems (), 4),
            masks (ErpIssueInventories (), 5),
            masks (ErpReqLineItems (), 6),
            masks (MaterialItems (), 7)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[TypeMaterial] = TypeMaterialSerializer
}

object TypeMaterialSerializer extends CIMSerializer[TypeMaterial]
{
    def write (kryo: Kryo, output: Output, obj: TypeMaterial): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.costType),
            () => output.writeDouble (obj.estUnitCost),
            () => output.writeString (obj.quantity),
            () => output.writeBoolean (obj.stockItem),
            () => writeList (obj.CUMaterialItems, output),
            () => writeList (obj.ErpIssueInventories, output),
            () => writeList (obj.ErpReqLineItems, output),
            () => writeList (obj.MaterialItems, output)
        )
        WorkDocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TypeMaterial]): TypeMaterial =
    {
        val parent = WorkDocumentSerializer.read (kryo, input, classOf [WorkDocument])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = TypeMaterial (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readBoolean else false,
            if (isSet (4)) readList (input) else null,
            if (isSet (5)) readList (input) else null,
            if (isSet (6)) readList (input) else null,
            if (isSet (7)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The way material and assets are used to perform a certain type of work task.
 *
 * The way is described in text in the inheritied description attribute.
 *
 * @param WorkIdentifiedObject [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param status               <em>undocumented</em>
 * @param WorkTask             [[ch.ninecode.model.OldWorkTask OldWorkTask]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Work package is used to define classes related to work. There are several different aspects of work.
 *            The Work Initiation (Work, Project, Request).
 *            The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
 *            The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
 *            The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
 *            The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
 *            This package is used for inspection and maintenance (InspectionDataSet, Procedure).
 *            The WorkService package defines Appointment class".
 */
final case class Usage
(
    WorkIdentifiedObject: WorkIdentifiedObject = null,
    status: String = null,
    WorkTask: String = null
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
    override def sup: WorkIdentifiedObject = WorkIdentifiedObject

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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Usage.cls

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Usage.fields (position), value)

        emitattr (0, status)
        emitattr (1, WorkTask)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:Usage rdf:ID=\"%s\">\n%s\t</cim:Usage>".format (id, export_fields)
    }
}

object Usage
    extends
        CIMParseable[Usage]
{
    override val fields: Array[String] = Array [String](
        "status",
        "WorkTask"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("WorkTask", "OldWorkTask", "0..1", "0..*")
    )
    val status: Fielder = parse_attribute (attribute (cls, fields (0)))
    val WorkTask: Fielder = parse_attribute (attribute (cls, fields (1)))

    def parse (context: CIMContext): Usage =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = Usage (
            WorkIdentifiedObject.parse (context),
            mask (status (), 0),
            mask (WorkTask (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Usage] = UsageSerializer
}

object UsageSerializer extends CIMSerializer[Usage]
{
    def write (kryo: Kryo, output: Output, obj: Usage): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.status),
            () => output.writeString (obj.WorkTask)
        )
        WorkIdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Usage]): Usage =
    {
        val parent = WorkIdentifiedObjectSerializer.read (kryo, input, classOf [WorkIdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Usage (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A collection of all of the individual cost items collected from multiple sources.
 *
 * @param WorkDocument         [[ch.ninecode.model.WorkDocument WorkDocument]] Reference to the superclass object.
 * @param amount               Amount in designated currency for work, either a total or an individual element.
 *                             As defined in the attribute "type," multiple instances are applicable to each work for: planned cost, actual cost, authorized cost, budgeted cost, forecasted cost, other.
 * @param isDebit              True if 'amount' is a debit, false if it is a credit.
 * @param transactionDateTime  Date and time that 'amount' is posted to the work.
 * @param ContractorItems      [[ch.ninecode.model.ContractorItem ContractorItem]] <em>undocumented</em>
 * @param CostType             [[ch.ninecode.model.CostType CostType]] <em>undocumented</em>
 * @param Design               [[ch.ninecode.model.Design Design]] <em>undocumented</em>
 * @param ErpProjectAccounting [[ch.ninecode.model.ErpProjectAccounting ErpProjectAccounting]] <em>undocumented</em>
 * @param LaborItems           [[ch.ninecode.model.LaborItem LaborItem]] <em>undocumented</em>
 * @param MiscCostItems        [[ch.ninecode.model.MiscCostItem MiscCostItem]] <em>undocumented</em>
 * @param OverheadCost         [[ch.ninecode.model.OverheadCost OverheadCost]] <em>undocumented</em>
 * @param PropertyUnits        [[ch.ninecode.model.PropertyUnit PropertyUnit]] <em>undocumented</em>
 * @param WorkCostSummary      [[ch.ninecode.model.WorkCostSummary WorkCostSummary]] <em>undocumented</em>
 * @param WorkTask             [[ch.ninecode.model.OldWorkTask OldWorkTask]] <em>undocumented</em>
 * @param Works                [[ch.ninecode.model.Work Work]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Work package is used to define classes related to work. There are several different aspects of work.
 *            The Work Initiation (Work, Project, Request).
 *            The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
 *            The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
 *            The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
 *            The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
 *            This package is used for inspection and maintenance (InspectionDataSet, Procedure).
 *            The WorkService package defines Appointment class".
 */
final case class WorkCostDetail
(
    WorkDocument: WorkDocument = null,
    amount: Double = 0.0,
    isDebit: Boolean = false,
    transactionDateTime: String = null,
    ContractorItems: List[String] = null,
    CostType: String = null,
    Design: String = null,
    ErpProjectAccounting: String = null,
    LaborItems: List[String] = null,
    MiscCostItems: List[String] = null,
    OverheadCost: String = null,
    PropertyUnits: List[String] = null,
    WorkCostSummary: String = null,
    WorkTask: String = null,
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
    override def sup: WorkDocument = WorkDocument

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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = WorkCostDetail.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (WorkCostDetail.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WorkCostDetail.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (WorkCostDetail.fields (position), x))

        emitelem (0, amount)
        emitelem (1, isDebit)
        emitelem (2, transactionDateTime)
        emitattrs (3, ContractorItems)
        emitattr (4, CostType)
        emitattr (5, Design)
        emitattr (6, ErpProjectAccounting)
        emitattrs (7, LaborItems)
        emitattrs (8, MiscCostItems)
        emitattr (9, OverheadCost)
        emitattrs (10, PropertyUnits)
        emitattr (11, WorkCostSummary)
        emitattr (12, WorkTask)
        emitattrs (13, Works)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:WorkCostDetail rdf:ID=\"%s\">\n%s\t</cim:WorkCostDetail>".format (id, export_fields)
    }
}

object WorkCostDetail
    extends
        CIMParseable[WorkCostDetail]
{
    override val fields: Array[String] = Array [String](
        "amount",
        "isDebit",
        "transactionDateTime",
        "ContractorItems",
        "CostType",
        "Design",
        "ErpProjectAccounting",
        "LaborItems",
        "MiscCostItems",
        "OverheadCost",
        "PropertyUnits",
        "WorkCostSummary",
        "WorkTask",
        "Works"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ContractorItems", "ContractorItem", "0..*", "1"),
        CIMRelationship ("CostType", "CostType", "1", "0..*"),
        CIMRelationship ("Design", "Design", "0..1", "0..*"),
        CIMRelationship ("ErpProjectAccounting", "ErpProjectAccounting", "1", "0..*"),
        CIMRelationship ("LaborItems", "LaborItem", "0..*", "1"),
        CIMRelationship ("MiscCostItems", "MiscCostItem", "0..*", "0..1"),
        CIMRelationship ("OverheadCost", "OverheadCost", "0..1", "0..*"),
        CIMRelationship ("PropertyUnits", "PropertyUnit", "0..*", "0..*"),
        CIMRelationship ("WorkCostSummary", "WorkCostSummary", "0..1", "0..1"),
        CIMRelationship ("WorkTask", "OldWorkTask", "0..1", "0..*"),
        CIMRelationship ("Works", "Work", "0..*", "0..*")
    )
    val amount: Fielder = parse_element (element (cls, fields (0)))
    val isDebit: Fielder = parse_element (element (cls, fields (1)))
    val transactionDateTime: Fielder = parse_element (element (cls, fields (2)))
    val ContractorItems: FielderMultiple = parse_attributes (attribute (cls, fields (3)))
    val CostType: Fielder = parse_attribute (attribute (cls, fields (4)))
    val Design: Fielder = parse_attribute (attribute (cls, fields (5)))
    val ErpProjectAccounting: Fielder = parse_attribute (attribute (cls, fields (6)))
    val LaborItems: FielderMultiple = parse_attributes (attribute (cls, fields (7)))
    val MiscCostItems: FielderMultiple = parse_attributes (attribute (cls, fields (8)))
    val OverheadCost: Fielder = parse_attribute (attribute (cls, fields (9)))
    val PropertyUnits: FielderMultiple = parse_attributes (attribute (cls, fields (10)))
    val WorkCostSummary: Fielder = parse_attribute (attribute (cls, fields (11)))
    val WorkTask: Fielder = parse_attribute (attribute (cls, fields (12)))
    val Works: FielderMultiple = parse_attributes (attribute (cls, fields (13)))

    def parse (context: CIMContext): WorkCostDetail =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = WorkCostDetail (
            WorkDocument.parse (context),
            toDouble (mask (amount (), 0)),
            toBoolean (mask (isDebit (), 1)),
            mask (transactionDateTime (), 2),
            masks (ContractorItems (), 3),
            mask (CostType (), 4),
            mask (Design (), 5),
            mask (ErpProjectAccounting (), 6),
            masks (LaborItems (), 7),
            masks (MiscCostItems (), 8),
            mask (OverheadCost (), 9),
            masks (PropertyUnits (), 10),
            mask (WorkCostSummary (), 11),
            mask (WorkTask (), 12),
            masks (Works (), 13)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[WorkCostDetail] = WorkCostDetailSerializer
}

object WorkCostDetailSerializer extends CIMSerializer[WorkCostDetail]
{
    def write (kryo: Kryo, output: Output, obj: WorkCostDetail): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.amount),
            () => output.writeBoolean (obj.isDebit),
            () => output.writeString (obj.transactionDateTime),
            () => writeList (obj.ContractorItems, output),
            () => output.writeString (obj.CostType),
            () => output.writeString (obj.Design),
            () => output.writeString (obj.ErpProjectAccounting),
            () => writeList (obj.LaborItems, output),
            () => writeList (obj.MiscCostItems, output),
            () => output.writeString (obj.OverheadCost),
            () => writeList (obj.PropertyUnits, output),
            () => output.writeString (obj.WorkCostSummary),
            () => output.writeString (obj.WorkTask),
            () => writeList (obj.Works, output)
        )
        WorkDocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[WorkCostDetail]): WorkCostDetail =
    {
        val parent = WorkDocumentSerializer.read (kryo, input, classOf [WorkDocument])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = WorkCostDetail (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readBoolean else false,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) readList (input) else null,
            if (isSet (8)) readList (input) else null,
            if (isSet (9)) input.readString else null,
            if (isSet (10)) readList (input) else null,
            if (isSet (11)) input.readString else null,
            if (isSet (12)) input.readString else null,
            if (isSet (13)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A roll up by cost type for the entire cost of a work order.
 *
 * For example, total labor.
 *
 * @param WorkDocument   [[ch.ninecode.model.WorkDocument WorkDocument]] Reference to the superclass object.
 * @param WorkCostDetail [[ch.ninecode.model.WorkCostDetail WorkCostDetail]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Work package is used to define classes related to work. There are several different aspects of work.
 *            The Work Initiation (Work, Project, Request).
 *            The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
 *            The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
 *            The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
 *            The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
 *            This package is used for inspection and maintenance (InspectionDataSet, Procedure).
 *            The WorkService package defines Appointment class".
 */
final case class WorkCostSummary
(
    WorkDocument: WorkDocument = null,
    WorkCostDetail: String = null
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
    override def sup: WorkDocument = WorkDocument

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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = WorkCostSummary.cls

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WorkCostSummary.fields (position), value)

        emitattr (0, WorkCostDetail)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:WorkCostSummary rdf:ID=\"%s\">\n%s\t</cim:WorkCostSummary>".format (id, export_fields)
    }
}

object WorkCostSummary
    extends
        CIMParseable[WorkCostSummary]
{
    override val fields: Array[String] = Array [String](
        "WorkCostDetail"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("WorkCostDetail", "WorkCostDetail", "0..1", "0..1")
    )
    val WorkCostDetail: Fielder = parse_attribute (attribute (cls, fields (0)))

    def parse (context: CIMContext): WorkCostSummary =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = WorkCostSummary (
            WorkDocument.parse (context),
            mask (WorkCostDetail (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[WorkCostSummary] = WorkCostSummarySerializer
}

object WorkCostSummarySerializer extends CIMSerializer[WorkCostSummary]
{
    def write (kryo: Kryo, output: Output, obj: WorkCostSummary): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.WorkCostDetail)
        )
        WorkDocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[WorkCostSummary]): WorkCostSummary =
    {
        val parent = WorkDocumentSerializer.read (kryo, input, classOf [WorkDocument])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = WorkCostSummary (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Shadow class for Document, to isolate subclassing from this package.
 *
 * If any subclass gets normative and needs inheritance, it will inherit directly from Document.
 *
 * @param Document [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Work package is used to define classes related to work. There are several different aspects of work.
 *            The Work Initiation (Work, Project, Request).
 *            The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
 *            The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
 *            The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
 *            The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
 *            This package is used for inspection and maintenance (InspectionDataSet, Procedure).
 *            The WorkService package defines Appointment class".
 */
final case class WorkDocument
(
    Document: Document = null
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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        sup.export_fields
    }

    override def export: String =
    {
        "\t<cim:WorkDocument rdf:ID=\"%s\">\n%s\t</cim:WorkDocument>".format (id, export_fields)
    }
}

object WorkDocument
    extends
        CIMParseable[WorkDocument]
{

    def parse (context: CIMContext): WorkDocument =
    {
        val ret = WorkDocument (
            Document.parse (context)
        )
        ret
    }

    def serializer: Serializer[WorkDocument] = WorkDocumentSerializer
}

object WorkDocumentSerializer extends CIMSerializer[WorkDocument]
{
    def write (kryo: Kryo, output: Output, obj: WorkDocument): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        DocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[WorkDocument]): WorkDocument =
    {
        val parent = DocumentSerializer.read (kryo, input, classOf [Document])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = WorkDocument (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A pre-defined set of work steps for a given type of work.
 *
 * @param WorkIdentifiedObject [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param sequenceNumber       Used to define dependencies of each work flow step, which is for the instance of WorkTask associated with a given instance of WorkFlow.
 * @param status               <em>undocumented</em>
 * @param Work                 [[ch.ninecode.model.Work Work]] <em>undocumented</em>
 * @param WorkTasks            [[ch.ninecode.model.OldWorkTask OldWorkTask]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Work package is used to define classes related to work. There are several different aspects of work.
 *            The Work Initiation (Work, Project, Request).
 *            The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
 *            The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
 *            The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
 *            The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
 *            This package is used for inspection and maintenance (InspectionDataSet, Procedure).
 *            The WorkService package defines Appointment class".
 */
final case class WorkFlowStep
(
    WorkIdentifiedObject: WorkIdentifiedObject = null,
    sequenceNumber: Int = 0,
    status: String = null,
    Work: String = null,
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
    override def sup: WorkIdentifiedObject = WorkIdentifiedObject

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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = WorkFlowStep.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (WorkFlowStep.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WorkFlowStep.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (WorkFlowStep.fields (position), x))

        emitelem (0, sequenceNumber)
        emitattr (1, status)
        emitattr (2, Work)
        emitattrs (3, WorkTasks)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:WorkFlowStep rdf:ID=\"%s\">\n%s\t</cim:WorkFlowStep>".format (id, export_fields)
    }
}

object WorkFlowStep
    extends
        CIMParseable[WorkFlowStep]
{
    override val fields: Array[String] = Array [String](
        "sequenceNumber",
        "status",
        "Work",
        "WorkTasks"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Work", "Work", "0..1", "0..*"),
        CIMRelationship ("WorkTasks", "OldWorkTask", "0..*", "0..1")
    )
    val sequenceNumber: Fielder = parse_element (element (cls, fields (0)))
    val status: Fielder = parse_attribute (attribute (cls, fields (1)))
    val Work: Fielder = parse_attribute (attribute (cls, fields (2)))
    val WorkTasks: FielderMultiple = parse_attributes (attribute (cls, fields (3)))

    def parse (context: CIMContext): WorkFlowStep =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = WorkFlowStep (
            WorkIdentifiedObject.parse (context),
            toInteger (mask (sequenceNumber (), 0)),
            mask (status (), 1),
            mask (Work (), 2),
            masks (WorkTasks (), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[WorkFlowStep] = WorkFlowStepSerializer
}

object WorkFlowStepSerializer extends CIMSerializer[WorkFlowStep]
{
    def write (kryo: Kryo, output: Output, obj: WorkFlowStep): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeInt (obj.sequenceNumber),
            () => output.writeString (obj.status),
            () => output.writeString (obj.Work),
            () => writeList (obj.WorkTasks, output)
        )
        WorkIdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[WorkFlowStep]): WorkFlowStep =
    {
        val parent = WorkIdentifiedObjectSerializer.read (kryo, input, classOf [WorkIdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = WorkFlowStep (
            parent,
            if (isSet (0)) input.readInt else 0,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Shadow class for IdentifiedObject, to isolate subclassing from this package.
 *
 * If any subclass gets normative and needs inheritance, it will inherit directly from IdentifiedObject.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Work package is used to define classes related to work. There are several different aspects of work.
 *            The Work Initiation (Work, Project, Request).
 *            The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
 *            The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
 *            The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
 *            The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
 *            This package is used for inspection and maintenance (InspectionDataSet, Procedure).
 *            The WorkService package defines Appointment class".
 */
final case class WorkIdentifiedObject
(
    IdentifiedObject: IdentifiedObject = null
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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        sup.export_fields
    }

    override def export: String =
    {
        "\t<cim:WorkIdentifiedObject rdf:ID=\"%s\">\n%s\t</cim:WorkIdentifiedObject>".format (id, export_fields)
    }
}

object WorkIdentifiedObject
    extends
        CIMParseable[WorkIdentifiedObject]
{

    def parse (context: CIMContext): WorkIdentifiedObject =
    {
        val ret = WorkIdentifiedObject (
            IdentifiedObject.parse (context)
        )
        ret
    }

    def serializer: Serializer[WorkIdentifiedObject] = WorkIdentifiedObjectSerializer
}

object WorkIdentifiedObjectSerializer extends CIMSerializer[WorkIdentifiedObject]
{
    def write (kryo: Kryo, output: Output, obj: WorkIdentifiedObject): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[WorkIdentifiedObject]): WorkIdentifiedObject =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf [IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = WorkIdentifiedObject (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _InfWork
{
    def register: List[CIMClassInfo] =
    {
        List (
            AccessPermit.register,
            Assignment.register,
            BusinessCase.register,
            CUAllowableAction.register,
            CUContractorItem.register,
            CUGroup.register,
            CULaborCode.register,
            CULaborItem.register,
            CUMaterialItem.register,
            CUWorkEquipmentItem.register,
            Capability.register,
            CompatibleUnit.register,
            ConditionFactor.register,
            ContractorItem.register,
            CostType.register,
            Design.register,
            DesignLocation.register,
            DesignLocationCU.register,
            InfoQuestion.register,
            LaborItem.register,
            MiscCostItem.register,
            NonStandardItem.register,
            OldWorkTask.register,
            OneCallRequest.register,
            OverheadCost.register,
            Project.register,
            PropertyUnit.register,
            QualificationRequirement.register,
            Regulation.register,
            ShiftPattern.register,
            TypeMaterial.register,
            Usage.register,
            WorkCostDetail.register,
            WorkCostSummary.register,
            WorkDocument.register,
            WorkFlowStep.register,
            WorkIdentifiedObject.register
        )
    }
}