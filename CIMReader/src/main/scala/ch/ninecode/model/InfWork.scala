package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * A permit is sometimes needed to provide legal access to land or equipment.
 *
 * For example, local authority permission for road works.
 *
 * @param sup [[ch.ninecode.model.WorkDocument WorkDocument]] Reference to the superclass object.
 * @param applicationNumber Permit application number that is used by municipality, state, province, etc.
 * @param effectiveDate Date that permit became official.
 * @param expirationDate Permit expiration date.
 * @param payment Total cost of permit.
 * @param permitID Permit identifier.
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Work package is used to define classes related to work. There are several different aspects of work.
The Work Initiation (Work, Project, Request).
The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
This package is used for inspection and maintenance (InspectionDataSet, Procedure).
The WorkService package defines Appointment class".
 */
final case class AccessPermit
(
    override val sup: WorkDocument = null,
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
    def WorkDocument: WorkDocument = sup.asInstanceOf[WorkDocument]
    override def copy (): Row = { clone ().asInstanceOf[AccessPermit] }
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
    Parseable[AccessPermit]
{
    override val fields: Array[String] = Array[String] (
        "applicationNumber",
        "effectiveDate",
        "expirationDate",
        "payment",
        "permitID"
    )
    val applicationNumber: Fielder = parse_element (element (cls, fields(0)))
    val effectiveDate: Fielder = parse_element (element (cls, fields(1)))
    val expirationDate: Fielder = parse_element (element (cls, fields(2)))
    val payment: Fielder = parse_element (element (cls, fields(3)))
    val permitID: Fielder = parse_element (element (cls, fields(4)))

    def parse (context: Context): AccessPermit =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
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
}

/**
 * An assignment is given to an ErpPerson, Crew, Organisation, Equipment Item, Tool, etc. and may be used to perform Work, WorkTasks, Procedures, etc.
 *
 * TimeSchedules may be set up directly for Assignments or indirectly via the associated WorkTask. Note that these associations are all inherited through the recursive relationship on Document.
 *
 * @param sup [[ch.ninecode.model.WorkDocument WorkDocument]] Reference to the superclass object.
 * @param effectivePeriod Period between the assignment becoming effective and its expiration.
 * @param Crews [[ch.ninecode.model.OldCrew OldCrew]] All Crews having this Assignment.
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Work package is used to define classes related to work. There are several different aspects of work.
The Work Initiation (Work, Project, Request).
The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
This package is used for inspection and maintenance (InspectionDataSet, Procedure).
The WorkService package defines Appointment class".
 */
final case class Assignment
(
    override val sup: WorkDocument = null,
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
    def WorkDocument: WorkDocument = sup.asInstanceOf[WorkDocument]
    override def copy (): Row = { clone ().asInstanceOf[Assignment] }
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
    Parseable[Assignment]
{
    override val fields: Array[String] = Array[String] (
        "effectivePeriod",
        "Crews"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Crews", "OldCrew", "0..*", "0..*")
    )
    val effectivePeriod: Fielder = parse_attribute (attribute (cls, fields(0)))
    val Crews: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): Assignment =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Assignment (
            WorkDocument.parse (context),
            mask (effectivePeriod (), 0),
            masks (Crews (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Business justification for capital expenditures, usually addressing operations and maintenance costs as well.
 *
 * @param sup [[ch.ninecode.model.WorkDocument WorkDocument]] Reference to the superclass object.
 * @param corporateCode A codified representation of the business case (i.e., codes for highway relocation, replace substation transformers, etc.).
 * @param Projects [[ch.ninecode.model.Project Project]] <em>undocumented</em>
 * @param Works [[ch.ninecode.model.Work Work]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Work package is used to define classes related to work. There are several different aspects of work.
The Work Initiation (Work, Project, Request).
The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
This package is used for inspection and maintenance (InspectionDataSet, Procedure).
The WorkService package defines Appointment class".
 */
final case class BusinessCase
(
    override val sup: WorkDocument = null,
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
    def WorkDocument: WorkDocument = sup.asInstanceOf[WorkDocument]
    override def copy (): Row = { clone ().asInstanceOf[BusinessCase] }
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
    Parseable[BusinessCase]
{
    override val fields: Array[String] = Array[String] (
        "corporateCode",
        "Projects",
        "Works"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Projects", "Project", "0..*", "0..1"),
        Relationship ("Works", "Work", "0..*", "0..1")
    )
    val corporateCode: Fielder = parse_element (element (cls, fields(0)))
    val Projects: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val Works: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: Context): BusinessCase =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = BusinessCase (
            WorkDocument.parse (context),
            mask (corporateCode (), 0),
            masks (Projects (), 1),
            masks (Works (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Allowed actions: Install, Remove, Transfer, Abandon, etc.
 *
 * @param sup [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param status <em>undocumented</em>
 * @param CompatibleUnits [[ch.ninecode.model.CompatibleUnit CompatibleUnit]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Work package is used to define classes related to work. There are several different aspects of work.
The Work Initiation (Work, Project, Request).
The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
This package is used for inspection and maintenance (InspectionDataSet, Procedure).
The WorkService package defines Appointment class".
 */
final case class CUAllowableAction
(
    override val sup: WorkIdentifiedObject = null,
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
    def WorkIdentifiedObject: WorkIdentifiedObject = sup.asInstanceOf[WorkIdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[CUAllowableAction] }
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
    Parseable[CUAllowableAction]
{
    override val fields: Array[String] = Array[String] (
        "status",
        "CompatibleUnits"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CompatibleUnits", "CompatibleUnit", "0..*", "0..1")
    )
    val status: Fielder = parse_attribute (attribute (cls, fields(0)))
    val CompatibleUnits: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): CUAllowableAction =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CUAllowableAction (
            WorkIdentifiedObject.parse (context),
            mask (status (), 0),
            masks (CompatibleUnits (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Compatible unit contractor item.
 *
 * @param sup [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param activityCode Activity code identifies a specific and distinguishable unit of work.
 * @param bidAmount The amount that a given contractor will charge for performing this unit of work.
 * @param status <em>undocumented</em>
 * @param CompatibleUnits [[ch.ninecode.model.CompatibleUnit CompatibleUnit]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Work package is used to define classes related to work. There are several different aspects of work.
The Work Initiation (Work, Project, Request).
The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
This package is used for inspection and maintenance (InspectionDataSet, Procedure).
The WorkService package defines Appointment class".
 */
final case class CUContractorItem
(
    override val sup: WorkIdentifiedObject = null,
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
    def WorkIdentifiedObject: WorkIdentifiedObject = sup.asInstanceOf[WorkIdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[CUContractorItem] }
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
    Parseable[CUContractorItem]
{
    override val fields: Array[String] = Array[String] (
        "activityCode",
        "bidAmount",
        "status",
        "CompatibleUnits"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CompatibleUnits", "CompatibleUnit", "0..*", "0..*")
    )
    val activityCode: Fielder = parse_element (element (cls, fields(0)))
    val bidAmount: Fielder = parse_element (element (cls, fields(1)))
    val status: Fielder = parse_attribute (attribute (cls, fields(2)))
    val CompatibleUnits: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: Context): CUContractorItem =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
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
}

/**
 * A Compatible Unit Group identifies a set of compatible units which may be jointly utilized for estimating and designating jobs.
 *
 * @param sup [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param status <em>undocumented</em>
 * @param ChildCUGroups [[ch.ninecode.model.CUGroup CUGroup]] <em>undocumented</em>
 * @param CompatibleUnits [[ch.ninecode.model.CompatibleUnit CompatibleUnit]] <em>undocumented</em>
 * @param DesignLocationCUs [[ch.ninecode.model.DesignLocationCU DesignLocationCU]] <em>undocumented</em>
 * @param ParentCUGroups [[ch.ninecode.model.CUGroup CUGroup]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Work package is used to define classes related to work. There are several different aspects of work.
The Work Initiation (Work, Project, Request).
The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
This package is used for inspection and maintenance (InspectionDataSet, Procedure).
The WorkService package defines Appointment class".
 */
final case class CUGroup
(
    override val sup: WorkIdentifiedObject = null,
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
    def WorkIdentifiedObject: WorkIdentifiedObject = sup.asInstanceOf[WorkIdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[CUGroup] }
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
    Parseable[CUGroup]
{
    override val fields: Array[String] = Array[String] (
        "status",
        "ChildCUGroups",
        "CompatibleUnits",
        "DesignLocationCUs",
        "ParentCUGroups"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ChildCUGroups", "CUGroup", "0..*", "0..*"),
        Relationship ("CompatibleUnits", "CompatibleUnit", "0..*", "0..1"),
        Relationship ("DesignLocationCUs", "DesignLocationCU", "0..*", "0..*"),
        Relationship ("ParentCUGroups", "CUGroup", "0..*", "0..*")
    )
    val status: Fielder = parse_attribute (attribute (cls, fields(0)))
    val ChildCUGroups: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val CompatibleUnits: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val DesignLocationCUs: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val ParentCUGroups: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: Context): CUGroup =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
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
}

/**
 * Labor code associated with various compatible unit labor items.
 *
 * @param sup [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param code Labor code.
 * @param status <em>undocumented</em>
 * @param CULaborItems [[ch.ninecode.model.CULaborItem CULaborItem]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Work package is used to define classes related to work. There are several different aspects of work.
The Work Initiation (Work, Project, Request).
The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
This package is used for inspection and maintenance (InspectionDataSet, Procedure).
The WorkService package defines Appointment class".
 */
final case class CULaborCode
(
    override val sup: WorkIdentifiedObject = null,
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
    def WorkIdentifiedObject: WorkIdentifiedObject = sup.asInstanceOf[WorkIdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[CULaborCode] }
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
    Parseable[CULaborCode]
{
    override val fields: Array[String] = Array[String] (
        "code",
        "status",
        "CULaborItems"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CULaborItems", "CULaborItem", "0..*", "0..1")
    )
    val code: Fielder = parse_element (element (cls, fields(0)))
    val status: Fielder = parse_attribute (attribute (cls, fields(1)))
    val CULaborItems: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: Context): CULaborCode =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CULaborCode (
            WorkIdentifiedObject.parse (context),
            mask (code (), 0),
            mask (status (), 1),
            masks (CULaborItems (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Compatible unit labor item.
 *
 * @param sup [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param activityCode Activity code identifies a specific and distinguishable unit of work.
 * @param laborDuration Estimated time to perform work.
 * @param laborRate The labor rate applied for work.
 * @param status <em>undocumented</em>
 * @param CULaborCode [[ch.ninecode.model.CULaborCode CULaborCode]] <em>undocumented</em>
 * @param CompatibleUnits [[ch.ninecode.model.CompatibleUnit CompatibleUnit]] <em>undocumented</em>
 * @param QualificationRequirements [[ch.ninecode.model.QualificationRequirement QualificationRequirement]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Work package is used to define classes related to work. There are several different aspects of work.
The Work Initiation (Work, Project, Request).
The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
This package is used for inspection and maintenance (InspectionDataSet, Procedure).
The WorkService package defines Appointment class".
 */
final case class CULaborItem
(
    override val sup: WorkIdentifiedObject = null,
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
    def WorkIdentifiedObject: WorkIdentifiedObject = sup.asInstanceOf[WorkIdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[CULaborItem] }
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
    Parseable[CULaborItem]
{
    override val fields: Array[String] = Array[String] (
        "activityCode",
        "laborDuration",
        "laborRate",
        "status",
        "CULaborCode",
        "CompatibleUnits",
        "QualificationRequirements"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CULaborCode", "CULaborCode", "0..1", "0..*"),
        Relationship ("CompatibleUnits", "CompatibleUnit", "0..*", "0..*"),
        Relationship ("QualificationRequirements", "QualificationRequirement", "0..*", "0..*")
    )
    val activityCode: Fielder = parse_element (element (cls, fields(0)))
    val laborDuration: Fielder = parse_element (element (cls, fields(1)))
    val laborRate: Fielder = parse_element (element (cls, fields(2)))
    val status: Fielder = parse_attribute (attribute (cls, fields(3)))
    val CULaborCode: Fielder = parse_attribute (attribute (cls, fields(4)))
    val CompatibleUnits: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val QualificationRequirements: FielderMultiple = parse_attributes (attribute (cls, fields(6)))

    def parse (context: Context): CULaborItem =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
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
}

/**
 * Compatible unit of a consumable supply item.
 *
 * For example, nuts, bolts, brackets, glue, etc.
 *
 * @param sup [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param corporateCode Code for material.
 * @param quantity Quantity of the TypeMaterial for this CU, used to determine estimated costs based on a per unit cost or a cost per unit length specified in the TypeMaterial.
 * @param status <em>undocumented</em>
 * @param CompatibleUnits [[ch.ninecode.model.CompatibleUnit CompatibleUnit]] <em>undocumented</em>
 * @param PropertyUnits [[ch.ninecode.model.PropertyUnit PropertyUnit]] <em>undocumented</em>
 * @param TypeMaterial [[ch.ninecode.model.TypeMaterial TypeMaterial]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Work package is used to define classes related to work. There are several different aspects of work.
The Work Initiation (Work, Project, Request).
The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
This package is used for inspection and maintenance (InspectionDataSet, Procedure).
The WorkService package defines Appointment class".
 */
final case class CUMaterialItem
(
    override val sup: WorkIdentifiedObject = null,
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
    def WorkIdentifiedObject: WorkIdentifiedObject = sup.asInstanceOf[WorkIdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[CUMaterialItem] }
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
    Parseable[CUMaterialItem]
{
    override val fields: Array[String] = Array[String] (
        "corporateCode",
        "quantity",
        "status",
        "CompatibleUnits",
        "PropertyUnits",
        "TypeMaterial"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CompatibleUnits", "CompatibleUnit", "0..*", "0..*"),
        Relationship ("PropertyUnits", "PropertyUnit", "0..*", "0..*"),
        Relationship ("TypeMaterial", "TypeMaterial", "0..1", "0..*")
    )
    val corporateCode: Fielder = parse_element (element (cls, fields(0)))
    val quantity: Fielder = parse_attribute (attribute (cls, fields(1)))
    val status: Fielder = parse_attribute (attribute (cls, fields(2)))
    val CompatibleUnits: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val PropertyUnits: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val TypeMaterial: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: Context): CUMaterialItem =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
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
}

/**
 * Compatible unit for various types of WorkEquipmentAssets, including vehicles.
 *
 * @param sup [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param equipCode The equipment type code.
 * @param rate Standard usage rate for the type of vehicle.
 * @param status <em>undocumented</em>
 * @param CompatibleUnits [[ch.ninecode.model.CompatibleUnit CompatibleUnit]] <em>undocumented</em>
 * @param TypeAsset [[ch.ninecode.model.WorkAsset WorkAsset]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Work package is used to define classes related to work. There are several different aspects of work.
The Work Initiation (Work, Project, Request).
The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
This package is used for inspection and maintenance (InspectionDataSet, Procedure).
The WorkService package defines Appointment class".
 */
final case class CUWorkEquipmentItem
(
    override val sup: WorkIdentifiedObject = null,
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
    def WorkIdentifiedObject: WorkIdentifiedObject = sup.asInstanceOf[WorkIdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[CUWorkEquipmentItem] }
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
    Parseable[CUWorkEquipmentItem]
{
    override val fields: Array[String] = Array[String] (
        "equipCode",
        "rate",
        "status",
        "CompatibleUnits",
        "TypeAsset"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CompatibleUnits", "CompatibleUnit", "0..*", "0..*"),
        Relationship ("TypeAsset", "WorkAsset", "0..1", "0..1")
    )
    val equipCode: Fielder = parse_element (element (cls, fields(0)))
    val rate: Fielder = parse_element (element (cls, fields(1)))
    val status: Fielder = parse_attribute (attribute (cls, fields(2)))
    val CompatibleUnits: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val TypeAsset: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): CUWorkEquipmentItem =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
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
}

/**
 * Capabilities of a crew.
 *
 * @param sup [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param performanceFactor Capability performance factor.
 * @param status <em>undocumented</em>
 * @param type Classification by utility's work management standards and practices.
 * @param validityInterval Date and time interval for which this capability is valid (when it became effective and when it expires).
 * @param Crafts [[ch.ninecode.model.Craft Craft]] <em>undocumented</em>
 * @param Crew [[ch.ninecode.model.OldCrew OldCrew]] <em>undocumented</em>
 * @param WorkTasks [[ch.ninecode.model.OldWorkTask OldWorkTask]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Work package is used to define classes related to work. There are several different aspects of work.
The Work Initiation (Work, Project, Request).
The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
This package is used for inspection and maintenance (InspectionDataSet, Procedure).
The WorkService package defines Appointment class".
 */
final case class Capability
(
    override val sup: WorkIdentifiedObject = null,
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
    def WorkIdentifiedObject: WorkIdentifiedObject = sup.asInstanceOf[WorkIdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Capability] }
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
    Parseable[Capability]
{
    override val fields: Array[String] = Array[String] (
        "performanceFactor",
        "status",
        "type",
        "validityInterval",
        "Crafts",
        "Crew",
        "WorkTasks"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Crafts", "Craft", "0..*", "0..*"),
        Relationship ("Crew", "OldCrew", "0..1", "0..*"),
        Relationship ("WorkTasks", "OldWorkTask", "0..*", "0..*")
    )
    val performanceFactor: Fielder = parse_element (element (cls, fields(0)))
    val status: Fielder = parse_attribute (attribute (cls, fields(1)))
    val `type`: Fielder = parse_element (element (cls, fields(2)))
    val validityInterval: Fielder = parse_attribute (attribute (cls, fields(3)))
    val Crafts: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val Crew: Fielder = parse_attribute (attribute (cls, fields(5)))
    val WorkTasks: FielderMultiple = parse_attributes (attribute (cls, fields(6)))

    def parse (context: Context): Capability =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
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
}

/**
 * A pre-planned job model containing labor, material, and accounting requirements for standardized job planning.
 *
 * @param sup [[ch.ninecode.model.WorkDocument WorkDocument]] Reference to the superclass object.
 * @param estCost Estimated total cost for perfoming CU.
 * @param quantity The quantity, unit of measure, and multiplier at the CU level that applies to the materials.
 * @param CUAllowableAction [[ch.ninecode.model.CUAllowableAction CUAllowableAction]] <em>undocumented</em>
 * @param CUContractorItems [[ch.ninecode.model.CUContractorItem CUContractorItem]] <em>undocumented</em>
 * @param CUGroup [[ch.ninecode.model.CUGroup CUGroup]] <em>undocumented</em>
 * @param CULaborItems [[ch.ninecode.model.CULaborItem CULaborItem]] <em>undocumented</em>
 * @param CUMaterialItems [[ch.ninecode.model.CUMaterialItem CUMaterialItem]] <em>undocumented</em>
 * @param CUWorkEquipmentItems [[ch.ninecode.model.CUWorkEquipmentItem CUWorkEquipmentItem]] <em>undocumented</em>
 * @param CostType [[ch.ninecode.model.CostType CostType]] <em>undocumented</em>
 * @param DesignLocationCUs [[ch.ninecode.model.DesignLocationCU DesignLocationCU]] <em>undocumented</em>
 * @param GenericAssetModel [[ch.ninecode.model.CatalogAssetType CatalogAssetType]] <em>undocumented</em>
 * @param Procedures [[ch.ninecode.model.Procedure Procedure]] <em>undocumented</em>
 * @param PropertyUnit [[ch.ninecode.model.PropertyUnit PropertyUnit]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Work package is used to define classes related to work. There are several different aspects of work.
The Work Initiation (Work, Project, Request).
The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
This package is used for inspection and maintenance (InspectionDataSet, Procedure).
The WorkService package defines Appointment class".
 */
final case class CompatibleUnit
(
    override val sup: WorkDocument = null,
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
    def WorkDocument: WorkDocument = sup.asInstanceOf[WorkDocument]
    override def copy (): Row = { clone ().asInstanceOf[CompatibleUnit] }
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
    Parseable[CompatibleUnit]
{
    override val fields: Array[String] = Array[String] (
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
    override val relations: List[Relationship] = List (
        Relationship ("CUAllowableAction", "CUAllowableAction", "0..1", "0..*"),
        Relationship ("CUContractorItems", "CUContractorItem", "0..*", "0..*"),
        Relationship ("CUGroup", "CUGroup", "0..1", "0..*"),
        Relationship ("CULaborItems", "CULaborItem", "0..*", "0..*"),
        Relationship ("CUMaterialItems", "CUMaterialItem", "0..*", "0..*"),
        Relationship ("CUWorkEquipmentItems", "CUWorkEquipmentItem", "0..*", "0..*"),
        Relationship ("CostType", "CostType", "0..1", "0..*"),
        Relationship ("DesignLocationCUs", "DesignLocationCU", "0..*", "0..*"),
        Relationship ("GenericAssetModel", "CatalogAssetType", "0..1", "0..*"),
        Relationship ("Procedures", "Procedure", "0..*", "0..*"),
        Relationship ("PropertyUnit", "PropertyUnit", "0..1", "0..*")
    )
    val estCost: Fielder = parse_element (element (cls, fields(0)))
    val quantity: Fielder = parse_element (element (cls, fields(1)))
    val CUAllowableAction: Fielder = parse_attribute (attribute (cls, fields(2)))
    val CUContractorItems: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val CUGroup: Fielder = parse_attribute (attribute (cls, fields(4)))
    val CULaborItems: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val CUMaterialItems: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val CUWorkEquipmentItems: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val CostType: Fielder = parse_attribute (attribute (cls, fields(8)))
    val DesignLocationCUs: FielderMultiple = parse_attributes (attribute (cls, fields(9)))
    val GenericAssetModel: Fielder = parse_attribute (attribute (cls, fields(10)))
    val Procedures: FielderMultiple = parse_attributes (attribute (cls, fields(11)))
    val PropertyUnit: Fielder = parse_attribute (attribute (cls, fields(12)))

    def parse (context: Context): CompatibleUnit =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
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
}

/**
 * This is to specify the various condition factors for a design that may alter the cost estimate or the allocation.
 *
 * @param sup [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param cfValue The actual value of the condition factor, such as labor flat fee or percentage.
 * @param kind Kind of this condition factor.
 * @param status <em>undocumented</em>
 * @param DesignLocationCUs [[ch.ninecode.model.DesignLocationCU DesignLocationCU]] <em>undocumented</em>
 * @param DesignLocations [[ch.ninecode.model.DesignLocation DesignLocation]] <em>undocumented</em>
 * @param Designs [[ch.ninecode.model.Design Design]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Work package is used to define classes related to work. There are several different aspects of work.
The Work Initiation (Work, Project, Request).
The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
This package is used for inspection and maintenance (InspectionDataSet, Procedure).
The WorkService package defines Appointment class".
 */
final case class ConditionFactor
(
    override val sup: WorkIdentifiedObject = null,
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
    def WorkIdentifiedObject: WorkIdentifiedObject = sup.asInstanceOf[WorkIdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ConditionFactor] }
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
    Parseable[ConditionFactor]
{
    override val fields: Array[String] = Array[String] (
        "cfValue",
        "kind",
        "status",
        "DesignLocationCUs",
        "DesignLocations",
        "Designs"
    )
    override val relations: List[Relationship] = List (
        Relationship ("DesignLocationCUs", "DesignLocationCU", "0..*", "0..*"),
        Relationship ("DesignLocations", "DesignLocation", "0..*", "0..*"),
        Relationship ("Designs", "Design", "0..*", "0..*")
    )
    val cfValue: Fielder = parse_element (element (cls, fields(0)))
    val kind: Fielder = parse_attribute (attribute (cls, fields(1)))
    val status: Fielder = parse_attribute (attribute (cls, fields(2)))
    val DesignLocationCUs: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val DesignLocations: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val Designs: FielderMultiple = parse_attributes (attribute (cls, fields(5)))

    def parse (context: Context): ConditionFactor =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
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
}

/**
 * Contractor information for work task.
 *
 * @param sup [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param activityCode Activity code identifies a specific and distinguishable unit of work.
 * @param bidAmount The amount that a given contractor will charge for performing this unit of work.
 * @param cost The total amount charged.
 * @param status <em>undocumented</em>
 * @param ErpPayables [[ch.ninecode.model.ErpPayable ErpPayable]] <em>undocumented</em>
 * @param WorkCostDetail [[ch.ninecode.model.WorkCostDetail WorkCostDetail]] <em>undocumented</em>
 * @param WorkTask [[ch.ninecode.model.OldWorkTask OldWorkTask]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Work package is used to define classes related to work. There are several different aspects of work.
The Work Initiation (Work, Project, Request).
The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
This package is used for inspection and maintenance (InspectionDataSet, Procedure).
The WorkService package defines Appointment class".
 */
final case class ContractorItem
(
    override val sup: WorkIdentifiedObject = null,
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
    def WorkIdentifiedObject: WorkIdentifiedObject = sup.asInstanceOf[WorkIdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ContractorItem] }
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
    Parseable[ContractorItem]
{
    override val fields: Array[String] = Array[String] (
        "activityCode",
        "bidAmount",
        "cost",
        "status",
        "ErpPayables",
        "WorkCostDetail",
        "WorkTask"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ErpPayables", "ErpPayable", "0..*", "0..*"),
        Relationship ("WorkCostDetail", "WorkCostDetail", "1", "0..*"),
        Relationship ("WorkTask", "OldWorkTask", "0..1", "0..*")
    )
    val activityCode: Fielder = parse_element (element (cls, fields(0)))
    val bidAmount: Fielder = parse_element (element (cls, fields(1)))
    val cost: Fielder = parse_element (element (cls, fields(2)))
    val status: Fielder = parse_attribute (attribute (cls, fields(3)))
    val ErpPayables: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val WorkCostDetail: Fielder = parse_attribute (attribute (cls, fields(5)))
    val WorkTask: Fielder = parse_attribute (attribute (cls, fields(6)))

    def parse (context: Context): ContractorItem =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
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
}

/**
 * A categorization for resources, often costs, in accounting transactions.
 *
 * Examples include: material components, building in service, coal sales, overhead, etc.
 *
 * @param sup [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param amountAssignable True if an amount can be assigned to the resource element (e.g., building in service, transmission plant, software development capital); false otherwise (e.g., internal labor, material components).
 * @param code A codified representation of the resource element.
 * @param level The level of the resource element in the hierarchy of resource elements (recursive relationship).
 * @param stage The stage for which this costType applies: estimated design, estimated actual or actual actual.
 * @param status <em>undocumented</em>
 * @param ChildCostTypes [[ch.ninecode.model.CostType CostType]] <em>undocumented</em>
 * @param CompatibleUnits [[ch.ninecode.model.CompatibleUnit CompatibleUnit]] <em>undocumented</em>
 * @param ErpJournalEntries [[ch.ninecode.model.ErpJournalEntry ErpJournalEntry]] <em>undocumented</em>
 * @param ParentCostType [[ch.ninecode.model.CostType CostType]] <em>undocumented</em>
 * @param WorkCostDetails [[ch.ninecode.model.WorkCostDetail WorkCostDetail]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Work package is used to define classes related to work. There are several different aspects of work.
The Work Initiation (Work, Project, Request).
The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
This package is used for inspection and maintenance (InspectionDataSet, Procedure).
The WorkService package defines Appointment class".
 */
final case class CostType
(
    override val sup: WorkIdentifiedObject = null,
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
    def WorkIdentifiedObject: WorkIdentifiedObject = sup.asInstanceOf[WorkIdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[CostType] }
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
    Parseable[CostType]
{
    override val fields: Array[String] = Array[String] (
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
    override val relations: List[Relationship] = List (
        Relationship ("ChildCostTypes", "CostType", "0..*", "0..1"),
        Relationship ("CompatibleUnits", "CompatibleUnit", "0..*", "0..1"),
        Relationship ("ErpJournalEntries", "ErpJournalEntry", "0..*", "0..*"),
        Relationship ("ParentCostType", "CostType", "0..1", "0..*"),
        Relationship ("WorkCostDetails", "WorkCostDetail", "0..*", "1")
    )
    val amountAssignable: Fielder = parse_element (element (cls, fields(0)))
    val code: Fielder = parse_element (element (cls, fields(1)))
    val level: Fielder = parse_element (element (cls, fields(2)))
    val stage: Fielder = parse_element (element (cls, fields(3)))
    val status: Fielder = parse_attribute (attribute (cls, fields(4)))
    val ChildCostTypes: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val CompatibleUnits: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val ErpJournalEntries: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val ParentCostType: Fielder = parse_attribute (attribute (cls, fields(8)))
    val WorkCostDetails: FielderMultiple = parse_attributes (attribute (cls, fields(9)))

    def parse (context: Context): CostType =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
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
}

/**
 * A design for consideration by customers, potential customers, or internal work.
 *
 * Note that the Version of design is the revision attribute that is inherited from Document.
 *
 * @param sup [[ch.ninecode.model.WorkDocument WorkDocument]] Reference to the superclass object.
 * @param costEstimate Estimated cost (not price) of design.
 * @param kind Kind of this design.
 * @param price Price to customer for implementing design.
 * @param ConditionFactors [[ch.ninecode.model.ConditionFactor ConditionFactor]] <em>undocumented</em>
 * @param DesignLocations [[ch.ninecode.model.DesignLocation DesignLocation]] <em>undocumented</em>
 * @param DesignLocationsCUs [[ch.ninecode.model.DesignLocationCU DesignLocationCU]] <em>undocumented</em>
 * @param ErpBOMs [[ch.ninecode.model.ErpBOM ErpBOM]] <em>undocumented</em>
 * @param ErpQuoteLineItem [[ch.ninecode.model.ErpQuoteLineItem ErpQuoteLineItem]] <em>undocumented</em>
 * @param Work [[ch.ninecode.model.Work Work]] <em>undocumented</em>
 * @param WorkCostDetails [[ch.ninecode.model.WorkCostDetail WorkCostDetail]] <em>undocumented</em>
 * @param WorkTasks [[ch.ninecode.model.OldWorkTask OldWorkTask]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Work package is used to define classes related to work. There are several different aspects of work.
The Work Initiation (Work, Project, Request).
The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
This package is used for inspection and maintenance (InspectionDataSet, Procedure).
The WorkService package defines Appointment class".
 */
final case class Design
(
    override val sup: WorkDocument = null,
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
    def WorkDocument: WorkDocument = sup.asInstanceOf[WorkDocument]
    override def copy (): Row = { clone ().asInstanceOf[Design] }
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
    Parseable[Design]
{
    override val fields: Array[String] = Array[String] (
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
    override val relations: List[Relationship] = List (
        Relationship ("ConditionFactors", "ConditionFactor", "0..*", "0..*"),
        Relationship ("DesignLocations", "DesignLocation", "0..*", "1..*"),
        Relationship ("DesignLocationsCUs", "DesignLocationCU", "0..*", "0..*"),
        Relationship ("ErpBOMs", "ErpBOM", "0..*", "0..1"),
        Relationship ("ErpQuoteLineItem", "ErpQuoteLineItem", "0..1", "0..1"),
        Relationship ("Work", "Work", "0..1", "0..*"),
        Relationship ("WorkCostDetails", "WorkCostDetail", "0..*", "0..1"),
        Relationship ("WorkTasks", "OldWorkTask", "0..*", "0..1")
    )
    val costEstimate: Fielder = parse_element (element (cls, fields(0)))
    val kind: Fielder = parse_attribute (attribute (cls, fields(1)))
    val price: Fielder = parse_element (element (cls, fields(2)))
    val ConditionFactors: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val DesignLocations: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val DesignLocationsCUs: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val ErpBOMs: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val ErpQuoteLineItem: Fielder = parse_attribute (attribute (cls, fields(7)))
    val Work: Fielder = parse_attribute (attribute (cls, fields(8)))
    val WorkCostDetails: FielderMultiple = parse_attributes (attribute (cls, fields(9)))
    val WorkTasks: FielderMultiple = parse_attributes (attribute (cls, fields(10)))

    def parse (context: Context): Design =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
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
}

/**
 * A logical part of the design (e.g., pole and all equipment on a pole).
 *
 * This includes points and spans.
 *
 * @param sup [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param spanLength The legth of the span from the previous pole to this pole.
 * @param status <em>undocumented</em>
 * @param ConditionFactors [[ch.ninecode.model.ConditionFactor ConditionFactor]] <em>undocumented</em>
 * @param DesignLocationCUs [[ch.ninecode.model.DesignLocationCU DesignLocationCU]] <em>undocumented</em>
 * @param Designs [[ch.ninecode.model.Design Design]] <em>undocumented</em>
 * @param ErpBomItemDatas [[ch.ninecode.model.ErpBomItemData ErpBomItemData]] <em>undocumented</em>
 * @param MiscCostItems [[ch.ninecode.model.MiscCostItem MiscCostItem]] <em>undocumented</em>
 * @param WorkLocations [[ch.ninecode.model.WorkLocation WorkLocation]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Work package is used to define classes related to work. There are several different aspects of work.
The Work Initiation (Work, Project, Request).
The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
This package is used for inspection and maintenance (InspectionDataSet, Procedure).
The WorkService package defines Appointment class".
 */
final case class DesignLocation
(
    override val sup: WorkIdentifiedObject = null,
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
    def WorkIdentifiedObject: WorkIdentifiedObject = sup.asInstanceOf[WorkIdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[DesignLocation] }
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
    Parseable[DesignLocation]
{
    override val fields: Array[String] = Array[String] (
        "spanLength",
        "status",
        "ConditionFactors",
        "DesignLocationCUs",
        "Designs",
        "ErpBomItemDatas",
        "MiscCostItems",
        "WorkLocations"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ConditionFactors", "ConditionFactor", "0..*", "0..*"),
        Relationship ("DesignLocationCUs", "DesignLocationCU", "0..*", "0..1"),
        Relationship ("Designs", "Design", "1..*", "0..*"),
        Relationship ("ErpBomItemDatas", "ErpBomItemData", "0..*", "0..1"),
        Relationship ("MiscCostItems", "MiscCostItem", "0..*", "0..1"),
        Relationship ("WorkLocations", "WorkLocation", "1..*", "0..*")
    )
    val spanLength: Fielder = parse_element (element (cls, fields(0)))
    val status: Fielder = parse_attribute (attribute (cls, fields(1)))
    val ConditionFactors: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val DesignLocationCUs: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val Designs: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val ErpBomItemDatas: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val MiscCostItems: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val WorkLocations: FielderMultiple = parse_attributes (attribute (cls, fields(7)))

    def parse (context: Context): DesignLocation =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
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
}

/**
 * Compatible unit at a given design location.
 *
 * @param sup [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param cuAccount A code that helps direct accounting (capital, expense, or accounting treatment).
 * @param cuAction A code that instructs the crew what action to perform.
 * @param cuQuantity The quantity of the CU being assigned to this location.
 * @param cuUsage As the same CU can be used for different purposes and accounting purposes, usage must be specified.
 *        Examples include: distribution, transmission, substation.
 * @param removalDate Year when a CU that represents an asset is removed.
 * @param status <em>undocumented</em>
 * @param toBeEnergised True if associated electrical equipment is intended to be energized while work is being performed.
 * @param CUGroups [[ch.ninecode.model.CUGroup CUGroup]] <em>undocumented</em>
 * @param CompatibleUnits [[ch.ninecode.model.CompatibleUnit CompatibleUnit]] <em>undocumented</em>
 * @param ConditionFactors [[ch.ninecode.model.ConditionFactor ConditionFactor]] <em>undocumented</em>
 * @param DesignLocation [[ch.ninecode.model.DesignLocation DesignLocation]] <em>undocumented</em>
 * @param Designs [[ch.ninecode.model.Design Design]] <em>undocumented</em>
 * @param WorkTasks [[ch.ninecode.model.OldWorkTask OldWorkTask]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Work package is used to define classes related to work. There are several different aspects of work.
The Work Initiation (Work, Project, Request).
The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
This package is used for inspection and maintenance (InspectionDataSet, Procedure).
The WorkService package defines Appointment class".
 */
final case class DesignLocationCU
(
    override val sup: WorkIdentifiedObject = null,
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
    def WorkIdentifiedObject: WorkIdentifiedObject = sup.asInstanceOf[WorkIdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[DesignLocationCU] }
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
    Parseable[DesignLocationCU]
{
    override val fields: Array[String] = Array[String] (
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
    override val relations: List[Relationship] = List (
        Relationship ("CUGroups", "CUGroup", "0..*", "0..*"),
        Relationship ("CompatibleUnits", "CompatibleUnit", "0..*", "0..*"),
        Relationship ("ConditionFactors", "ConditionFactor", "0..*", "0..*"),
        Relationship ("DesignLocation", "DesignLocation", "0..1", "0..*"),
        Relationship ("Designs", "Design", "0..*", "0..*"),
        Relationship ("WorkTasks", "OldWorkTask", "0..*", "0..*")
    )
    val cuAccount: Fielder = parse_element (element (cls, fields(0)))
    val cuAction: Fielder = parse_attribute (attribute (cls, fields(1)))
    val cuQuantity: Fielder = parse_attribute (attribute (cls, fields(2)))
    val cuUsage: Fielder = parse_element (element (cls, fields(3)))
    val removalDate: Fielder = parse_element (element (cls, fields(4)))
    val status: Fielder = parse_attribute (attribute (cls, fields(5)))
    val toBeEnergised: Fielder = parse_element (element (cls, fields(6)))
    val CUGroups: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val CompatibleUnits: FielderMultiple = parse_attributes (attribute (cls, fields(8)))
    val ConditionFactors: FielderMultiple = parse_attributes (attribute (cls, fields(9)))
    val DesignLocation: Fielder = parse_attribute (attribute (cls, fields(10)))
    val Designs: FielderMultiple = parse_attributes (attribute (cls, fields(11)))
    val WorkTasks: FielderMultiple = parse_attributes (attribute (cls, fields(12)))

    def parse (context: Context): DesignLocationCU =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
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
}

/**
 * Questions and answers associated with a type of document for purposes of clarification.
 *
 * Questions may be predefined or ad hoc.
 *
 * @param sup [[ch.ninecode.model.WorkDocument WorkDocument]] Reference to the superclass object.
 * @param answer Answer to question.
 * @param answerDateTime The date and time the quesiton was answered.
 * @param answerRemark Remarks to qualify the answer.
 * @param questionCode The question code.
 *        If blank, refer to questionText.
 * @param questionRemark Remarks to qualify the question in this situation.
 * @param questionText For non-coded questions, the question is provided here.
 * @param questionType The type of the question.
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Work package is used to define classes related to work. There are several different aspects of work.
The Work Initiation (Work, Project, Request).
The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
This package is used for inspection and maintenance (InspectionDataSet, Procedure).
The WorkService package defines Appointment class".
 */
final case class InfoQuestion
(
    override val sup: WorkDocument = null,
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
    def WorkDocument: WorkDocument = sup.asInstanceOf[WorkDocument]
    override def copy (): Row = { clone ().asInstanceOf[InfoQuestion] }
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
    Parseable[InfoQuestion]
{
    override val fields: Array[String] = Array[String] (
        "answer",
        "answerDateTime",
        "answerRemark",
        "questionCode",
        "questionRemark",
        "questionText",
        "questionType"
    )
    val answer: Fielder = parse_element (element (cls, fields(0)))
    val answerDateTime: Fielder = parse_element (element (cls, fields(1)))
    val answerRemark: Fielder = parse_element (element (cls, fields(2)))
    val questionCode: Fielder = parse_element (element (cls, fields(3)))
    val questionRemark: Fielder = parse_element (element (cls, fields(4)))
    val questionText: Fielder = parse_element (element (cls, fields(5)))
    val questionType: Fielder = parse_element (element (cls, fields(6)))

    def parse (context: Context): InfoQuestion =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
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
}

/**
 * Labor used for work order.
 *
 * @param sup [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param activityCode Activity code identifies a specific and distinguishable unit of work.
 * @param cost Total cost for labor.
 *        Note that this may not be able to be derived from labor rate and time charged.
 * @param laborDuration Time required to perform work.
 * @param laborRate The labor rate applied for work.
 * @param status <em>undocumented</em>
 * @param ErpPersons [[ch.ninecode.model.OldPerson OldPerson]] <em>undocumented</em>
 * @param WorkCostDetail [[ch.ninecode.model.WorkCostDetail WorkCostDetail]] <em>undocumented</em>
 * @param WorkTask [[ch.ninecode.model.OldWorkTask OldWorkTask]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Work package is used to define classes related to work. There are several different aspects of work.
The Work Initiation (Work, Project, Request).
The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
This package is used for inspection and maintenance (InspectionDataSet, Procedure).
The WorkService package defines Appointment class".
 */
final case class LaborItem
(
    override val sup: WorkIdentifiedObject = null,
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
    def WorkIdentifiedObject: WorkIdentifiedObject = sup.asInstanceOf[WorkIdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[LaborItem] }
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
    Parseable[LaborItem]
{
    override val fields: Array[String] = Array[String] (
        "activityCode",
        "cost",
        "laborDuration",
        "laborRate",
        "status",
        "ErpPersons",
        "WorkCostDetail",
        "WorkTask"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ErpPersons", "OldPerson", "0..*", "0..*"),
        Relationship ("WorkCostDetail", "WorkCostDetail", "1", "0..*"),
        Relationship ("WorkTask", "OldWorkTask", "0..1", "0..*")
    )
    val activityCode: Fielder = parse_element (element (cls, fields(0)))
    val cost: Fielder = parse_element (element (cls, fields(1)))
    val laborDuration: Fielder = parse_element (element (cls, fields(2)))
    val laborRate: Fielder = parse_element (element (cls, fields(3)))
    val status: Fielder = parse_attribute (attribute (cls, fields(4)))
    val ErpPersons: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val WorkCostDetail: Fielder = parse_attribute (attribute (cls, fields(6)))
    val WorkTask: Fielder = parse_attribute (attribute (cls, fields(7)))

    def parse (context: Context): LaborItem =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
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
}

/**
 * Various cost items that are not associated with compatible units.
 *
 * Examples include rental equipment, labor, materials, contractor costs, permits - anything not covered in a CU.
 *
 * @param sup [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param account This drives the accounting treatment for this misc. item.
 * @param costPerUnit The cost per unit for this misc. item.
 * @param costType The cost type for accounting, such as material, labor, vehicle, contractor, equipment, overhead.
 * @param externalRefID External reference identifier (e.g. purchase order number, serial number) .
 * @param quantity The quantity of the misc. item being assigned to this location.
 * @param status <em>undocumented</em>
 * @param DesignLocation [[ch.ninecode.model.DesignLocation DesignLocation]] <em>undocumented</em>
 * @param WorkCostDetail [[ch.ninecode.model.WorkCostDetail WorkCostDetail]] <em>undocumented</em>
 * @param WorkTask [[ch.ninecode.model.OldWorkTask OldWorkTask]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Work package is used to define classes related to work. There are several different aspects of work.
The Work Initiation (Work, Project, Request).
The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
This package is used for inspection and maintenance (InspectionDataSet, Procedure).
The WorkService package defines Appointment class".
 */
final case class MiscCostItem
(
    override val sup: WorkIdentifiedObject = null,
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
    def WorkIdentifiedObject: WorkIdentifiedObject = sup.asInstanceOf[WorkIdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[MiscCostItem] }
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
    Parseable[MiscCostItem]
{
    override val fields: Array[String] = Array[String] (
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
    override val relations: List[Relationship] = List (
        Relationship ("DesignLocation", "DesignLocation", "0..1", "0..*"),
        Relationship ("WorkCostDetail", "WorkCostDetail", "0..1", "0..*"),
        Relationship ("WorkTask", "OldWorkTask", "0..1", "0..*")
    )
    val account: Fielder = parse_element (element (cls, fields(0)))
    val costPerUnit: Fielder = parse_element (element (cls, fields(1)))
    val costType: Fielder = parse_element (element (cls, fields(2)))
    val externalRefID: Fielder = parse_element (element (cls, fields(3)))
    val quantity: Fielder = parse_attribute (attribute (cls, fields(4)))
    val status: Fielder = parse_attribute (attribute (cls, fields(5)))
    val DesignLocation: Fielder = parse_attribute (attribute (cls, fields(6)))
    val WorkCostDetail: Fielder = parse_attribute (attribute (cls, fields(7)))
    val WorkTask: Fielder = parse_attribute (attribute (cls, fields(8)))

    def parse (context: Context): MiscCostItem =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
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
}

/**
 * This document provides information for non-standard items like customer contributions (e.g., customer digs trench), vouchers (e.g., credit), and contractor bids.
 *
 * @param sup [[ch.ninecode.model.WorkDocument WorkDocument]] Reference to the superclass object.
 * @param amount The projected cost for this item.
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Work package is used to define classes related to work. There are several different aspects of work.
The Work Initiation (Work, Project, Request).
The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
This package is used for inspection and maintenance (InspectionDataSet, Procedure).
The WorkService package defines Appointment class".
 */
final case class NonStandardItem
(
    override val sup: WorkDocument = null,
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
    def WorkDocument: WorkDocument = sup.asInstanceOf[WorkDocument]
    override def copy (): Row = { clone ().asInstanceOf[NonStandardItem] }
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
    Parseable[NonStandardItem]
{
    override val fields: Array[String] = Array[String] (
        "amount"
    )
    val amount: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): NonStandardItem =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = NonStandardItem (
            WorkDocument.parse (context),
            toDouble (mask (amount (), 0))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A set of tasks is required to implement a design.
 *
 * @param sup [[ch.ninecode.model.WorkTask WorkTask]] Reference to the superclass object.
 * @param Capabilities [[ch.ninecode.model.Capability Capability]] <em>undocumented</em>
 * @param ContractorItems [[ch.ninecode.model.ContractorItem ContractorItem]] <em>undocumented</em>
 * @param Design [[ch.ninecode.model.Design Design]] <em>undocumented</em>
 * @param DesignLocationCUs [[ch.ninecode.model.DesignLocationCU DesignLocationCU]] <em>undocumented</em>
 * @param LaborItems [[ch.ninecode.model.LaborItem LaborItem]] <em>undocumented</em>
 * @param MiscCostItems [[ch.ninecode.model.MiscCostItem MiscCostItem]] <em>undocumented</em>
 * @param OverheadCost [[ch.ninecode.model.OverheadCost OverheadCost]] <em>undocumented</em>
 * @param QualificationRequirements [[ch.ninecode.model.QualificationRequirement QualificationRequirement]] <em>undocumented</em>
 * @param Usages [[ch.ninecode.model.Usage Usage]] <em>undocumented</em>
 * @param WorkCostDetails [[ch.ninecode.model.WorkCostDetail WorkCostDetail]] <em>undocumented</em>
 * @param WorkFlowStep [[ch.ninecode.model.WorkFlowStep WorkFlowStep]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Work package is used to define classes related to work. There are several different aspects of work.
The Work Initiation (Work, Project, Request).
The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
This package is used for inspection and maintenance (InspectionDataSet, Procedure).
The WorkService package defines Appointment class".
 */
final case class OldWorkTask
(
    override val sup: WorkTask = null,
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
    def WorkTask: WorkTask = sup.asInstanceOf[WorkTask]
    override def copy (): Row = { clone ().asInstanceOf[OldWorkTask] }
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
    Parseable[OldWorkTask]
{
    override val fields: Array[String] = Array[String] (
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
    override val relations: List[Relationship] = List (
        Relationship ("Capabilities", "Capability", "0..*", "0..*"),
        Relationship ("ContractorItems", "ContractorItem", "0..*", "0..1"),
        Relationship ("Design", "Design", "0..1", "0..*"),
        Relationship ("DesignLocationCUs", "DesignLocationCU", "0..*", "0..*"),
        Relationship ("LaborItems", "LaborItem", "0..*", "0..1"),
        Relationship ("MiscCostItems", "MiscCostItem", "0..*", "0..1"),
        Relationship ("OverheadCost", "OverheadCost", "0..1", "0..*"),
        Relationship ("QualificationRequirements", "QualificationRequirement", "0..*", "0..*"),
        Relationship ("Usages", "Usage", "0..*", "0..1"),
        Relationship ("WorkCostDetails", "WorkCostDetail", "0..*", "0..1"),
        Relationship ("WorkFlowStep", "WorkFlowStep", "0..1", "0..*")
    )
    val Capabilities: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val ContractorItems: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val Design: Fielder = parse_attribute (attribute (cls, fields(2)))
    val DesignLocationCUs: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val LaborItems: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val MiscCostItems: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val OverheadCost: Fielder = parse_attribute (attribute (cls, fields(6)))
    val QualificationRequirements: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val Usages: FielderMultiple = parse_attributes (attribute (cls, fields(8)))
    val WorkCostDetails: FielderMultiple = parse_attributes (attribute (cls, fields(9)))
    val WorkFlowStep: Fielder = parse_attribute (attribute (cls, fields(10)))

    def parse (context: Context): OldWorkTask =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
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
}

/**
 * A request for other utilities to mark their underground facilities prior to commencement of construction and/or maintenance.
 *
 * @param sup [[ch.ninecode.model.WorkDocument WorkDocument]] Reference to the superclass object.
 * @param explosivesUsed True if explosives have been or are planned to be used.
 * @param markedIndicator True if work location has been marked, for example for a dig area.
 * @param markingInstruction Instructions for marking a dig area, if applicable.
 * @param WorkLocations [[ch.ninecode.model.WorkLocation WorkLocation]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Work package is used to define classes related to work. There are several different aspects of work.
The Work Initiation (Work, Project, Request).
The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
This package is used for inspection and maintenance (InspectionDataSet, Procedure).
The WorkService package defines Appointment class".
 */
final case class OneCallRequest
(
    override val sup: WorkDocument = null,
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
    def WorkDocument: WorkDocument = sup.asInstanceOf[WorkDocument]
    override def copy (): Row = { clone ().asInstanceOf[OneCallRequest] }
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
    Parseable[OneCallRequest]
{
    override val fields: Array[String] = Array[String] (
        "explosivesUsed",
        "markedIndicator",
        "markingInstruction",
        "WorkLocations"
    )
    override val relations: List[Relationship] = List (
        Relationship ("WorkLocations", "WorkLocation", "0..*", "0..1")
    )
    val explosivesUsed: Fielder = parse_element (element (cls, fields(0)))
    val markedIndicator: Fielder = parse_element (element (cls, fields(1)))
    val markingInstruction: Fielder = parse_element (element (cls, fields(2)))
    val WorkLocations: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: Context): OneCallRequest =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
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
}

/**
 * Overhead cost applied to work order.
 *
 * @param sup [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param code Overhead code.
 * @param cost The overhead cost to be applied.
 * @param status <em>undocumented</em>
 * @param WorkCostDetails [[ch.ninecode.model.WorkCostDetail WorkCostDetail]] <em>undocumented</em>
 * @param WorkTasks [[ch.ninecode.model.OldWorkTask OldWorkTask]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Work package is used to define classes related to work. There are several different aspects of work.
The Work Initiation (Work, Project, Request).
The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
This package is used for inspection and maintenance (InspectionDataSet, Procedure).
The WorkService package defines Appointment class".
 */
final case class OverheadCost
(
    override val sup: WorkIdentifiedObject = null,
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
    def WorkIdentifiedObject: WorkIdentifiedObject = sup.asInstanceOf[WorkIdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[OverheadCost] }
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
    Parseable[OverheadCost]
{
    override val fields: Array[String] = Array[String] (
        "code",
        "cost",
        "status",
        "WorkCostDetails",
        "WorkTasks"
    )
    override val relations: List[Relationship] = List (
        Relationship ("WorkCostDetails", "WorkCostDetail", "0..*", "0..1"),
        Relationship ("WorkTasks", "OldWorkTask", "0..*", "0..1")
    )
    val code: Fielder = parse_element (element (cls, fields(0)))
    val cost: Fielder = parse_element (element (cls, fields(1)))
    val status: Fielder = parse_attribute (attribute (cls, fields(2)))
    val WorkCostDetails: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val WorkTasks: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: Context): OverheadCost =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
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
}

/**
 * A collection of related work.
 *
 * For construction projects and maintenance projects, multiple phases may be performed.
 *
 * @param sup [[ch.ninecode.model.WorkDocument WorkDocument]] Reference to the superclass object.
 * @param budget Overall project budget.
 * @param BusinessCase [[ch.ninecode.model.BusinessCase BusinessCase]] <em>undocumented</em>
 * @param ErpProjectAccounting [[ch.ninecode.model.ErpProjectAccounting ErpProjectAccounting]] <em>undocumented</em>
 * @param ParentProject [[ch.ninecode.model.Project Project]] <em>undocumented</em>
 * @param SubProjects [[ch.ninecode.model.Project Project]] <em>undocumented</em>
 * @param Works [[ch.ninecode.model.Work Work]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Work package is used to define classes related to work. There are several different aspects of work.
The Work Initiation (Work, Project, Request).
The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
This package is used for inspection and maintenance (InspectionDataSet, Procedure).
The WorkService package defines Appointment class".
 */
final case class Project
(
    override val sup: WorkDocument = null,
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
    def WorkDocument: WorkDocument = sup.asInstanceOf[WorkDocument]
    override def copy (): Row = { clone ().asInstanceOf[Project] }
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
    Parseable[Project]
{
    override val fields: Array[String] = Array[String] (
        "budget",
        "BusinessCase",
        "ErpProjectAccounting",
        "ParentProject",
        "SubProjects",
        "Works"
    )
    override val relations: List[Relationship] = List (
        Relationship ("BusinessCase", "BusinessCase", "0..1", "0..*"),
        Relationship ("ErpProjectAccounting", "ErpProjectAccounting", "1", "0..*"),
        Relationship ("ParentProject", "Project", "0..1", "0..*"),
        Relationship ("SubProjects", "Project", "0..*", "0..1"),
        Relationship ("Works", "Work", "0..*", "0..1")
    )
    val budget: Fielder = parse_element (element (cls, fields(0)))
    val BusinessCase: Fielder = parse_attribute (attribute (cls, fields(1)))
    val ErpProjectAccounting: Fielder = parse_attribute (attribute (cls, fields(2)))
    val ParentProject: Fielder = parse_attribute (attribute (cls, fields(3)))
    val SubProjects: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val Works: FielderMultiple = parse_attributes (attribute (cls, fields(5)))

    def parse (context: Context): Project =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
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
}

/**
 * Unit of property for reporting purposes.
 *
 * @param sup [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param accountingUsage A code that identifies appropriate type of property accounts such as distribution, streetlgihts, communications.
 * @param activityCode Activity code identifies a specific and distinguishable work action.
 * @param propertyAccount Used for property record accounting.
 *        For example, in the USA, this would be a FERC account.
 * @param status <em>undocumented</em>
 * @param CUMaterialItems [[ch.ninecode.model.CUMaterialItem CUMaterialItem]] <em>undocumented</em>
 * @param CompatibleUnits [[ch.ninecode.model.CompatibleUnit CompatibleUnit]] <em>undocumented</em>
 * @param WorkCostDetails [[ch.ninecode.model.WorkCostDetail WorkCostDetail]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Work package is used to define classes related to work. There are several different aspects of work.
The Work Initiation (Work, Project, Request).
The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
This package is used for inspection and maintenance (InspectionDataSet, Procedure).
The WorkService package defines Appointment class".
 */
final case class PropertyUnit
(
    override val sup: WorkIdentifiedObject = null,
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
    def WorkIdentifiedObject: WorkIdentifiedObject = sup.asInstanceOf[WorkIdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[PropertyUnit] }
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
    Parseable[PropertyUnit]
{
    override val fields: Array[String] = Array[String] (
        "accountingUsage",
        "activityCode",
        "propertyAccount",
        "status",
        "CUMaterialItems",
        "CompatibleUnits",
        "WorkCostDetails"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CUMaterialItems", "CUMaterialItem", "0..*", "0..*"),
        Relationship ("CompatibleUnits", "CompatibleUnit", "0..*", "0..1"),
        Relationship ("WorkCostDetails", "WorkCostDetail", "0..*", "0..*")
    )
    val accountingUsage: Fielder = parse_element (element (cls, fields(0)))
    val activityCode: Fielder = parse_attribute (attribute (cls, fields(1)))
    val propertyAccount: Fielder = parse_element (element (cls, fields(2)))
    val status: Fielder = parse_attribute (attribute (cls, fields(3)))
    val CUMaterialItems: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val CompatibleUnits: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val WorkCostDetails: FielderMultiple = parse_attributes (attribute (cls, fields(6)))

    def parse (context: Context): PropertyUnit =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
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
}

/**
 * Certain skills are required and must be certified in order for a person (typically a member of a crew) to be qualified to work on types of equipment.
 *
 * @param sup [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param qualificationID Qualification identifier.
 * @param CULaborItems [[ch.ninecode.model.CULaborItem CULaborItem]] <em>undocumented</em>
 * @param Skills [[ch.ninecode.model.Skill Skill]] <em>undocumented</em>
 * @param Specifications [[ch.ninecode.model.Specification Specification]] <em>undocumented</em>
 * @param WorkTasks [[ch.ninecode.model.OldWorkTask OldWorkTask]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Work package is used to define classes related to work. There are several different aspects of work.
The Work Initiation (Work, Project, Request).
The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
This package is used for inspection and maintenance (InspectionDataSet, Procedure).
The WorkService package defines Appointment class".
 */
final case class QualificationRequirement
(
    override val sup: WorkIdentifiedObject = null,
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
    def WorkIdentifiedObject: WorkIdentifiedObject = sup.asInstanceOf[WorkIdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[QualificationRequirement] }
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
    Parseable[QualificationRequirement]
{
    override val fields: Array[String] = Array[String] (
        "qualificationID",
        "CULaborItems",
        "Skills",
        "Specifications",
        "WorkTasks"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CULaborItems", "CULaborItem", "0..*", "0..*"),
        Relationship ("Skills", "Skill", "0..*", "0..*"),
        Relationship ("Specifications", "Specification", "0..*", "0..*"),
        Relationship ("WorkTasks", "OldWorkTask", "0..*", "0..*")
    )
    val qualificationID: Fielder = parse_element (element (cls, fields(0)))
    val CULaborItems: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val Skills: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val Specifications: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val WorkTasks: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: Context): QualificationRequirement =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
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
}

/**
 * Special requirements and/or regulations may pertain to certain types of assets or work.
 *
 * For example, fire protection and scaffolding.
 *
 * @param sup [[ch.ninecode.model.WorkDocument WorkDocument]] Reference to the superclass object.
 * @param referenceNumber External reference to regulation, if applicable.
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Work package is used to define classes related to work. There are several different aspects of work.
The Work Initiation (Work, Project, Request).
The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
This package is used for inspection and maintenance (InspectionDataSet, Procedure).
The WorkService package defines Appointment class".
 */
final case class Regulation
(
    override val sup: WorkDocument = null,
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
    def WorkDocument: WorkDocument = sup.asInstanceOf[WorkDocument]
    override def copy (): Row = { clone ().asInstanceOf[Regulation] }
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
    Parseable[Regulation]
{
    override val fields: Array[String] = Array[String] (
        "referenceNumber"
    )
    val referenceNumber: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): Regulation =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Regulation (
            WorkDocument.parse (context),
            mask (referenceNumber (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The patterns of shifts worked by people or crews.
 *
 * @param sup [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param assignmentType Type of assignement intended to be worked on this shift, for example, temporary, standard, etc.
 * @param cycleCount Number of cycles for a temporary shift.
 * @param status <em>undocumented</em>
 * @param validityInterval Date and time interval for which this shift pattern is valid (when it became effective and when it expires).
 * @param Crews [[ch.ninecode.model.OldCrew OldCrew]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Work package is used to define classes related to work. There are several different aspects of work.
The Work Initiation (Work, Project, Request).
The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
This package is used for inspection and maintenance (InspectionDataSet, Procedure).
The WorkService package defines Appointment class".
 */
final case class ShiftPattern
(
    override val sup: WorkIdentifiedObject = null,
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
    def WorkIdentifiedObject: WorkIdentifiedObject = sup.asInstanceOf[WorkIdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ShiftPattern] }
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
    Parseable[ShiftPattern]
{
    override val fields: Array[String] = Array[String] (
        "assignmentType",
        "cycleCount",
        "status",
        "validityInterval",
        "Crews"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Crews", "OldCrew", "0..*", "0..*")
    )
    val assignmentType: Fielder = parse_element (element (cls, fields(0)))
    val cycleCount: Fielder = parse_element (element (cls, fields(1)))
    val status: Fielder = parse_attribute (attribute (cls, fields(2)))
    val validityInterval: Fielder = parse_attribute (attribute (cls, fields(3)))
    val Crews: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: Context): ShiftPattern =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
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
}

/**
 * Documentation for a generic material item that may be used for design, work and other purposes.
 *
 * Any number of MaterialItems manufactured by various vendors may be used to perform this TypeMaterial.
 * Note that class analagous to "AssetModel" is not used for material items. This is because in some cases, for example, a utility sets up a Master material record for a 3 inch long half inch diameter steel bolt and they do not necessarily care what specific supplier is providing the material item. As different vendors are used to supply the part, the Stock Code of the material item can stay the same. In other cases, each time the vendor changes, a new stock code is set up so they can track material used by vendor. Therefore a Material Item "Model" is not typically needed.
 *
 * @param sup [[ch.ninecode.model.WorkDocument WorkDocument]] Reference to the superclass object.
 * @param costType The type of cost to which this Material Item belongs.
 * @param estUnitCost The estimated unit cost of this type of material, either for a unit cost or cost per unit length.
 *        Cost is for material or asset only and does not include labor to install/construct or configure it.
 * @param quantity The value, unit of measure, and multiplier for the quantity.
 * @param stockItem True if item is a stock item (default).
 * @param CUMaterialItems [[ch.ninecode.model.CUMaterialItem CUMaterialItem]] <em>undocumented</em>
 * @param ErpIssueInventories [[ch.ninecode.model.ErpIssueInventory ErpIssueInventory]] <em>undocumented</em>
 * @param ErpReqLineItems [[ch.ninecode.model.ErpReqLineItem ErpReqLineItem]] <em>undocumented</em>
 * @param MaterialItems [[ch.ninecode.model.MaterialItem MaterialItem]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Work package is used to define classes related to work. There are several different aspects of work.
The Work Initiation (Work, Project, Request).
The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
This package is used for inspection and maintenance (InspectionDataSet, Procedure).
The WorkService package defines Appointment class".
 */
final case class TypeMaterial
(
    override val sup: WorkDocument = null,
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
    def WorkDocument: WorkDocument = sup.asInstanceOf[WorkDocument]
    override def copy (): Row = { clone ().asInstanceOf[TypeMaterial] }
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
    Parseable[TypeMaterial]
{
    override val fields: Array[String] = Array[String] (
        "costType",
        "estUnitCost",
        "quantity",
        "stockItem",
        "CUMaterialItems",
        "ErpIssueInventories",
        "ErpReqLineItems",
        "MaterialItems"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CUMaterialItems", "CUMaterialItem", "0..*", "0..1"),
        Relationship ("ErpIssueInventories", "ErpIssueInventory", "0..*", "0..1"),
        Relationship ("ErpReqLineItems", "ErpReqLineItem", "0..*", "0..1"),
        Relationship ("MaterialItems", "MaterialItem", "0..*", "0..1")
    )
    val costType: Fielder = parse_element (element (cls, fields(0)))
    val estUnitCost: Fielder = parse_element (element (cls, fields(1)))
    val quantity: Fielder = parse_element (element (cls, fields(2)))
    val stockItem: Fielder = parse_element (element (cls, fields(3)))
    val CUMaterialItems: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val ErpIssueInventories: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val ErpReqLineItems: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val MaterialItems: FielderMultiple = parse_attributes (attribute (cls, fields(7)))

    def parse (context: Context): TypeMaterial =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
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
}

/**
 * The way material and assets are used to perform a certain type of work task.
 *
 * The way is described in text in the inheritied description attribute.
 *
 * @param sup [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param status <em>undocumented</em>
 * @param WorkTask [[ch.ninecode.model.OldWorkTask OldWorkTask]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Work package is used to define classes related to work. There are several different aspects of work.
The Work Initiation (Work, Project, Request).
The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
This package is used for inspection and maintenance (InspectionDataSet, Procedure).
The WorkService package defines Appointment class".
 */
final case class Usage
(
    override val sup: WorkIdentifiedObject = null,
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
    def WorkIdentifiedObject: WorkIdentifiedObject = sup.asInstanceOf[WorkIdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Usage] }
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
    Parseable[Usage]
{
    override val fields: Array[String] = Array[String] (
        "status",
        "WorkTask"
    )
    override val relations: List[Relationship] = List (
        Relationship ("WorkTask", "OldWorkTask", "0..1", "0..*")
    )
    val status: Fielder = parse_attribute (attribute (cls, fields(0)))
    val WorkTask: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): Usage =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Usage (
            WorkIdentifiedObject.parse (context),
            mask (status (), 0),
            mask (WorkTask (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A collection of all of the individual cost items collected from multiple sources.
 *
 * @param sup [[ch.ninecode.model.WorkDocument WorkDocument]] Reference to the superclass object.
 * @param amount Amount in designated currency for work, either a total or an individual element.
 *        As defined in the attribute "type," multiple instances are applicable to each work for: planned cost, actual cost, authorized cost, budgeted cost, forecasted cost, other.
 * @param isDebit True if 'amount' is a debit, false if it is a credit.
 * @param transactionDateTime Date and time that 'amount' is posted to the work.
 * @param ContractorItems [[ch.ninecode.model.ContractorItem ContractorItem]] <em>undocumented</em>
 * @param CostType [[ch.ninecode.model.CostType CostType]] <em>undocumented</em>
 * @param Design [[ch.ninecode.model.Design Design]] <em>undocumented</em>
 * @param ErpProjectAccounting [[ch.ninecode.model.ErpProjectAccounting ErpProjectAccounting]] <em>undocumented</em>
 * @param LaborItems [[ch.ninecode.model.LaborItem LaborItem]] <em>undocumented</em>
 * @param MiscCostItems [[ch.ninecode.model.MiscCostItem MiscCostItem]] <em>undocumented</em>
 * @param OverheadCost [[ch.ninecode.model.OverheadCost OverheadCost]] <em>undocumented</em>
 * @param PropertyUnits [[ch.ninecode.model.PropertyUnit PropertyUnit]] <em>undocumented</em>
 * @param WorkCostSummary [[ch.ninecode.model.WorkCostSummary WorkCostSummary]] <em>undocumented</em>
 * @param WorkTask [[ch.ninecode.model.OldWorkTask OldWorkTask]] <em>undocumented</em>
 * @param Works [[ch.ninecode.model.Work Work]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Work package is used to define classes related to work. There are several different aspects of work.
The Work Initiation (Work, Project, Request).
The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
This package is used for inspection and maintenance (InspectionDataSet, Procedure).
The WorkService package defines Appointment class".
 */
final case class WorkCostDetail
(
    override val sup: WorkDocument = null,
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
    def WorkDocument: WorkDocument = sup.asInstanceOf[WorkDocument]
    override def copy (): Row = { clone ().asInstanceOf[WorkCostDetail] }
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
    Parseable[WorkCostDetail]
{
    override val fields: Array[String] = Array[String] (
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
    override val relations: List[Relationship] = List (
        Relationship ("ContractorItems", "ContractorItem", "0..*", "1"),
        Relationship ("CostType", "CostType", "1", "0..*"),
        Relationship ("Design", "Design", "0..1", "0..*"),
        Relationship ("ErpProjectAccounting", "ErpProjectAccounting", "1", "0..*"),
        Relationship ("LaborItems", "LaborItem", "0..*", "1"),
        Relationship ("MiscCostItems", "MiscCostItem", "0..*", "0..1"),
        Relationship ("OverheadCost", "OverheadCost", "0..1", "0..*"),
        Relationship ("PropertyUnits", "PropertyUnit", "0..*", "0..*"),
        Relationship ("WorkCostSummary", "WorkCostSummary", "0..1", "0..1"),
        Relationship ("WorkTask", "OldWorkTask", "0..1", "0..*"),
        Relationship ("Works", "Work", "0..*", "0..*")
    )
    val amount: Fielder = parse_element (element (cls, fields(0)))
    val isDebit: Fielder = parse_element (element (cls, fields(1)))
    val transactionDateTime: Fielder = parse_element (element (cls, fields(2)))
    val ContractorItems: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val CostType: Fielder = parse_attribute (attribute (cls, fields(4)))
    val Design: Fielder = parse_attribute (attribute (cls, fields(5)))
    val ErpProjectAccounting: Fielder = parse_attribute (attribute (cls, fields(6)))
    val LaborItems: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val MiscCostItems: FielderMultiple = parse_attributes (attribute (cls, fields(8)))
    val OverheadCost: Fielder = parse_attribute (attribute (cls, fields(9)))
    val PropertyUnits: FielderMultiple = parse_attributes (attribute (cls, fields(10)))
    val WorkCostSummary: Fielder = parse_attribute (attribute (cls, fields(11)))
    val WorkTask: Fielder = parse_attribute (attribute (cls, fields(12)))
    val Works: FielderMultiple = parse_attributes (attribute (cls, fields(13)))

    def parse (context: Context): WorkCostDetail =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
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
}

/**
 * A roll up by cost type for the entire cost of a work order.
 *
 * For example, total labor.
 *
 * @param sup [[ch.ninecode.model.WorkDocument WorkDocument]] Reference to the superclass object.
 * @param WorkCostDetail [[ch.ninecode.model.WorkCostDetail WorkCostDetail]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Work package is used to define classes related to work. There are several different aspects of work.
The Work Initiation (Work, Project, Request).
The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
This package is used for inspection and maintenance (InspectionDataSet, Procedure).
The WorkService package defines Appointment class".
 */
final case class WorkCostSummary
(
    override val sup: WorkDocument = null,
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
    def WorkDocument: WorkDocument = sup.asInstanceOf[WorkDocument]
    override def copy (): Row = { clone ().asInstanceOf[WorkCostSummary] }
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
    Parseable[WorkCostSummary]
{
    override val fields: Array[String] = Array[String] (
        "WorkCostDetail"
    )
    override val relations: List[Relationship] = List (
        Relationship ("WorkCostDetail", "WorkCostDetail", "0..1", "0..1")
    )
    val WorkCostDetail: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): WorkCostSummary =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WorkCostSummary (
            WorkDocument.parse (context),
            mask (WorkCostDetail (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Shadow class for Document, to isolate subclassing from this package.
 *
 * If any subclass gets normative and needs inheritance, it will inherit directly from Document.
 *
 * @param sup [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Work package is used to define classes related to work. There are several different aspects of work.
The Work Initiation (Work, Project, Request).
The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
This package is used for inspection and maintenance (InspectionDataSet, Procedure).
The WorkService package defines Appointment class".
 */
final case class WorkDocument
(
    override val sup: Document = null
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
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[WorkDocument] }
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
        "\t<cim:WorkDocument rdf:ID=\"%s\">\n%s\t</cim:WorkDocument>".format (id, export_fields)
    }
}

object WorkDocument
extends
    Parseable[WorkDocument]
{

    def parse (context: Context): WorkDocument =
    {
        implicit val ctx: Context = context
        val ret = WorkDocument (
            Document.parse (context)
        )
        ret
    }
}

/**
 * A pre-defined set of work steps for a given type of work.
 *
 * @param sup [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param sequenceNumber Used to define dependencies of each work flow step, which is for the instance of WorkTask associated with a given instance of WorkFlow.
 * @param status <em>undocumented</em>
 * @param Work [[ch.ninecode.model.Work Work]] <em>undocumented</em>
 * @param WorkTasks [[ch.ninecode.model.OldWorkTask OldWorkTask]] <em>undocumented</em>
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Work package is used to define classes related to work. There are several different aspects of work.
The Work Initiation (Work, Project, Request).
The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
This package is used for inspection and maintenance (InspectionDataSet, Procedure).
The WorkService package defines Appointment class".
 */
final case class WorkFlowStep
(
    override val sup: WorkIdentifiedObject = null,
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
    def WorkIdentifiedObject: WorkIdentifiedObject = sup.asInstanceOf[WorkIdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[WorkFlowStep] }
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
    Parseable[WorkFlowStep]
{
    override val fields: Array[String] = Array[String] (
        "sequenceNumber",
        "status",
        "Work",
        "WorkTasks"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Work", "Work", "0..1", "0..*"),
        Relationship ("WorkTasks", "OldWorkTask", "0..*", "0..1")
    )
    val sequenceNumber: Fielder = parse_element (element (cls, fields(0)))
    val status: Fielder = parse_attribute (attribute (cls, fields(1)))
    val Work: Fielder = parse_attribute (attribute (cls, fields(2)))
    val WorkTasks: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: Context): WorkFlowStep =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
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
}

/**
 * Shadow class for IdentifiedObject, to isolate subclassing from this package.
 *
 * If any subclass gets normative and needs inheritance, it will inherit directly from IdentifiedObject.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @group InfWork
 * @groupname InfWork Package InfWork
 * @groupdesc InfWork The package covers all types of work, including inspection, maintenance, repair, restoration, and construction. It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Work package is used to define classes related to work. There are several different aspects of work.
The Work Initiation (Work, Project, Request).
The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
This package is used for inspection and maintenance (InspectionDataSet, Procedure).
The WorkService package defines Appointment class".
 */
final case class WorkIdentifiedObject
(
    override val sup: IdentifiedObject = null
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
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[WorkIdentifiedObject] }
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
        "\t<cim:WorkIdentifiedObject rdf:ID=\"%s\">\n%s\t</cim:WorkIdentifiedObject>".format (id, export_fields)
    }
}

object WorkIdentifiedObject
extends
    Parseable[WorkIdentifiedObject]
{

    def parse (context: Context): WorkIdentifiedObject =
    {
        implicit val ctx: Context = context
        val ret = WorkIdentifiedObject (
            IdentifiedObject.parse (context)
        )
        ret
    }
}

private[ninecode] object _InfWork
{
    def register: List[ClassInfo] =
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