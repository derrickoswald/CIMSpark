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
case class AccessPermit
(
    override val sup: WorkDocument,
    applicationNumber: String,
    effectiveDate: String,
    expirationDate: String,
    payment: Double,
    permitID: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, 0.0, null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
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
    val fields: Array[String] = Array[String] (
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
        implicit var bitfields: Array[Int] = Array(0)
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
    val relations: List[Relationship] = List (

    )
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
case class Assignment
(
    override val sup: WorkDocument,
    effectivePeriod: String,
    Crews: List[String]
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
    def WorkDocument: WorkDocument = sup.asInstanceOf[WorkDocument]
    override def copy (): Row = { clone ().asInstanceOf[Assignment] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Assignment.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Assignment.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (Assignment.fields (position), x))
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
    val fields: Array[String] = Array[String] (
        "effectivePeriod",
        "Crews"
    )
    val effectivePeriod: Fielder = parse_attribute (attribute (cls, fields(0)))
    val Crews: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): Assignment =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Assignment (
            WorkDocument.parse (context),
            mask (effectivePeriod (), 0),
            masks (Crews (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Crews", "OldCrew", true)
    )
}

/**
 * Business justification for capital expenditures, usually addressing operations and maintenance costs as well.
 *
 * @param sup [[ch.ninecode.model.WorkDocument WorkDocument]] Reference to the superclass object.
 * @param corporateCode A codified representation of the business case (i.e., codes for highway relocation, replace substation transformers, etc.).
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
case class BusinessCase
(
    override val sup: WorkDocument,
    corporateCode: String
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
    def WorkDocument: WorkDocument = sup.asInstanceOf[WorkDocument]
    override def copy (): Row = { clone ().asInstanceOf[BusinessCase] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = BusinessCase.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (BusinessCase.fields (position), value)
        emitelem (0, corporateCode)
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
    val fields: Array[String] = Array[String] (
        "corporateCode"
    )
    val corporateCode: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): BusinessCase =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = BusinessCase (
            WorkDocument.parse (context),
            mask (corporateCode (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Allowed actions: Install, Remove, Transfer, Abandon, etc.
 *
 * @param sup [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param status <em>undocumented</em>
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
case class CUAllowableAction
(
    override val sup: WorkIdentifiedObject,
    status: String
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
    def WorkIdentifiedObject: WorkIdentifiedObject = sup.asInstanceOf[WorkIdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[CUAllowableAction] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CUAllowableAction.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CUAllowableAction.fields (position), value)
        emitattr (0, status)
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
    val fields: Array[String] = Array[String] (
        "status"
    )
    val status: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): CUAllowableAction =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = CUAllowableAction (
            WorkIdentifiedObject.parse (context),
            mask (status (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Compatible unit for various types of assets such as transformers switches, substation fences, poles, etc..
 *
 * @param sup [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param quantity Quantity of the type asset within the CU.
 * @param status <em>undocumented</em>
 * @param typeAssetCode The code for this type of asset.
 * @param CompatibleUnits [[ch.ninecode.model.CompatibleUnit CompatibleUnit]] <em>undocumented</em>
 * @param TypeAsset [[ch.ninecode.model.GenericAssetModelOrMaterial GenericAssetModelOrMaterial]] <em>undocumented</em>
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
case class CUAsset
(
    override val sup: WorkIdentifiedObject,
    quantity: String,
    status: String,
    typeAssetCode: String,
    CompatibleUnits: List[String],
    TypeAsset: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, List(), null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def WorkIdentifiedObject: WorkIdentifiedObject = sup.asInstanceOf[WorkIdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[CUAsset] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CUAsset.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CUAsset.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CUAsset.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (CUAsset.fields (position), x))
        emitattr (0, quantity)
        emitattr (1, status)
        emitelem (2, typeAssetCode)
        emitattrs (3, CompatibleUnits)
        emitattr (4, TypeAsset)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CUAsset rdf:ID=\"%s\">\n%s\t</cim:CUAsset>".format (id, export_fields)
    }
}

object CUAsset
extends
    Parseable[CUAsset]
{
    val fields: Array[String] = Array[String] (
        "quantity",
        "status",
        "typeAssetCode",
        "CompatibleUnits",
        "TypeAsset"
    )
    val quantity: Fielder = parse_attribute (attribute (cls, fields(0)))
    val status: Fielder = parse_attribute (attribute (cls, fields(1)))
    val typeAssetCode: Fielder = parse_element (element (cls, fields(2)))
    val CompatibleUnits: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val TypeAsset: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): CUAsset =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = CUAsset (
            WorkIdentifiedObject.parse (context),
            mask (quantity (), 0),
            mask (status (), 1),
            mask (typeAssetCode (), 2),
            masks (CompatibleUnits (), 3),
            mask (TypeAsset (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("CompatibleUnits", "CompatibleUnit", true),
        Relationship ("TypeAsset", "GenericAssetModelOrMaterial", false)
    )
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
case class CUContractorItem
(
    override val sup: WorkIdentifiedObject,
    activityCode: String,
    bidAmount: Double,
    status: String,
    CompatibleUnits: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, null, List()) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CUContractorItem.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CUContractorItem.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CUContractorItem.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (CUContractorItem.fields (position), x))
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
    val fields: Array[String] = Array[String] (
        "activityCode",
        "bidAmount",
        "status",
        "CompatibleUnits"
    )
    val activityCode: Fielder = parse_element (element (cls, fields(0)))
    val bidAmount: Fielder = parse_element (element (cls, fields(1)))
    val status: Fielder = parse_attribute (attribute (cls, fields(2)))
    val CompatibleUnits: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: Context): CUContractorItem =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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
    val relations: List[Relationship] = List (
        Relationship ("CompatibleUnits", "CompatibleUnit", true)
    )
}

/**
 * A Compatible Unit Group identifies a set of compatible units which may be jointly utilized for estimating and designating jobs.
 *
 * @param sup [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param status <em>undocumented</em>
 * @param ChildCUGroups [[ch.ninecode.model.CUGroup CUGroup]] <em>undocumented</em>
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
case class CUGroup
(
    override val sup: WorkIdentifiedObject,
    status: String,
    ChildCUGroups: List[String],
    DesignLocationCUs: List[String],
    ParentCUGroups: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, List(), List(), List()) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CUGroup.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CUGroup.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (CUGroup.fields (position), x))
        emitattr (0, status)
        emitattrs (1, ChildCUGroups)
        emitattrs (2, DesignLocationCUs)
        emitattrs (3, ParentCUGroups)
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
    val fields: Array[String] = Array[String] (
        "status",
        "ChildCUGroups",
        "DesignLocationCUs",
        "ParentCUGroups"
    )
    val status: Fielder = parse_attribute (attribute (cls, fields(0)))
    val ChildCUGroups: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val DesignLocationCUs: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val ParentCUGroups: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: Context): CUGroup =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = CUGroup (
            WorkIdentifiedObject.parse (context),
            mask (status (), 0),
            masks (ChildCUGroups (), 1),
            masks (DesignLocationCUs (), 2),
            masks (ParentCUGroups (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ChildCUGroups", "CUGroup", true),
        Relationship ("DesignLocationCUs", "DesignLocationCU", true),
        Relationship ("ParentCUGroups", "CUGroup", true)
    )
}

/**
 * Labor code associated with various compatible unit labor items.
 *
 * @param sup [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param code Labor code.
 * @param status <em>undocumented</em>
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
case class CULaborCode
(
    override val sup: WorkIdentifiedObject,
    code: String,
    status: String
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
    def WorkIdentifiedObject: WorkIdentifiedObject = sup.asInstanceOf[WorkIdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[CULaborCode] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CULaborCode.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CULaborCode.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CULaborCode.fields (position), value)
        emitelem (0, code)
        emitattr (1, status)
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
    val fields: Array[String] = Array[String] (
        "code",
        "status"
    )
    val code: Fielder = parse_element (element (cls, fields(0)))
    val status: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): CULaborCode =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = CULaborCode (
            WorkIdentifiedObject.parse (context),
            mask (code (), 0),
            mask (status (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
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
case class CULaborItem
(
    override val sup: WorkIdentifiedObject,
    activityCode: String,
    laborDuration: Double,
    laborRate: Double,
    status: String,
    CULaborCode: String,
    CompatibleUnits: List[String],
    QualificationRequirements: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, 0.0, null, null, List(), List()) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CULaborItem.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CULaborItem.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CULaborItem.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (CULaborItem.fields (position), x))
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
    val fields: Array[String] = Array[String] (
        "activityCode",
        "laborDuration",
        "laborRate",
        "status",
        "CULaborCode",
        "CompatibleUnits",
        "QualificationRequirements"
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
        implicit var bitfields: Array[Int] = Array(0)
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
    val relations: List[Relationship] = List (
        Relationship ("CULaborCode", "CULaborCode", false),
        Relationship ("CompatibleUnits", "CompatibleUnit", true),
        Relationship ("QualificationRequirements", "QualificationRequirement", true)
    )
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
case class CUMaterialItem
(
    override val sup: WorkIdentifiedObject,
    corporateCode: String,
    quantity: String,
    status: String,
    CompatibleUnits: List[String],
    PropertyUnits: List[String],
    TypeMaterial: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, List(), List(), null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CUMaterialItem.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CUMaterialItem.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CUMaterialItem.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (CUMaterialItem.fields (position), x))
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
    val fields: Array[String] = Array[String] (
        "corporateCode",
        "quantity",
        "status",
        "CompatibleUnits",
        "PropertyUnits",
        "TypeMaterial"
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
        implicit var bitfields: Array[Int] = Array(0)
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
    val relations: List[Relationship] = List (
        Relationship ("CompatibleUnits", "CompatibleUnit", true),
        Relationship ("PropertyUnits", "PropertyUnit", true),
        Relationship ("TypeMaterial", "TypeMaterial", false)
    )
}

/**
 * Compatible unit for various types of WorkEquipmentAssets, including vehicles.
 *
 * @param sup [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param equipCode The equipment type code.
 * @param rate Standard usage rate for the type of vehicle.
 * @param status <em>undocumented</em>
 * @param CompatibleUnits [[ch.ninecode.model.CompatibleUnit CompatibleUnit]] <em>undocumented</em>
 * @param TypeAsset [[ch.ninecode.model.GenericAssetModelOrMaterial GenericAssetModelOrMaterial]] <em>undocumented</em>
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
case class CUWorkEquipmentItem
(
    override val sup: WorkIdentifiedObject,
    equipCode: String,
    rate: Double,
    status: String,
    CompatibleUnits: List[String],
    TypeAsset: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, null, List(), null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CUWorkEquipmentItem.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CUWorkEquipmentItem.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CUWorkEquipmentItem.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (CUWorkEquipmentItem.fields (position), x))
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
    val fields: Array[String] = Array[String] (
        "equipCode",
        "rate",
        "status",
        "CompatibleUnits",
        "TypeAsset"
    )
    val equipCode: Fielder = parse_element (element (cls, fields(0)))
    val rate: Fielder = parse_element (element (cls, fields(1)))
    val status: Fielder = parse_attribute (attribute (cls, fields(2)))
    val CompatibleUnits: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val TypeAsset: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): CUWorkEquipmentItem =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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
    val relations: List[Relationship] = List (
        Relationship ("CompatibleUnits", "CompatibleUnit", true),
        Relationship ("TypeAsset", "GenericAssetModelOrMaterial", false)
    )
}

/**
 * Capabilities of a crew.
 *
 * @param sup [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param performanceFactor Capability performance factor.
 * @param status <em>undocumented</em>
 * @param validityInterval Date and time interval for which this capability is valid (when it became effective and when it expires).
 * @param Crafts [[ch.ninecode.model.Craft Craft]] <em>undocumented</em>
 * @param Crew [[ch.ninecode.model.OldCrew OldCrew]] <em>undocumented</em>
 * @param WorkTasks [[ch.ninecode.model.OldWorkTask OldWorkTask]] <em>undocumented</em>
 * @param `type` Classification by utility's work management standards and practices.
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
case class Capability
(
    override val sup: WorkIdentifiedObject,
    performanceFactor: String,
    status: String,
    validityInterval: String,
    Crafts: List[String],
    Crew: String,
    WorkTasks: List[String],
    `type`: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, List(), null, List(), null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Capability.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Capability.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Capability.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (Capability.fields (position), x))
        emitelem (0, performanceFactor)
        emitattr (1, status)
        emitattr (2, validityInterval)
        emitattrs (3, Crafts)
        emitattr (4, Crew)
        emitattrs (5, WorkTasks)
        emitelem (6, `type`)
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
    val fields: Array[String] = Array[String] (
        "performanceFactor",
        "status",
        "validityInterval",
        "Crafts",
        "Crew",
        "WorkTasks",
        "type"
    )
    val performanceFactor: Fielder = parse_element (element (cls, fields(0)))
    val status: Fielder = parse_attribute (attribute (cls, fields(1)))
    val validityInterval: Fielder = parse_attribute (attribute (cls, fields(2)))
    val Crafts: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val Crew: Fielder = parse_attribute (attribute (cls, fields(4)))
    val WorkTasks: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val `type`: Fielder = parse_element (element (cls, fields(6)))

    def parse (context: Context): Capability =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Capability (
            WorkIdentifiedObject.parse (context),
            mask (performanceFactor (), 0),
            mask (status (), 1),
            mask (validityInterval (), 2),
            masks (Crafts (), 3),
            mask (Crew (), 4),
            masks (WorkTasks (), 5),
            mask (`type` (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Crafts", "Craft", true),
        Relationship ("Crew", "OldCrew", false),
        Relationship ("WorkTasks", "OldWorkTask", true)
    )
}

/**
 * A pre-planned job model containing labor, material, and accounting requirements for standardized job planning.
 *
 * @param sup [[ch.ninecode.model.WorkDocument WorkDocument]] Reference to the superclass object.
 * @param estCost Estimated total cost for perfoming CU.
 * @param quantity The quantity, unit of measure, and multiplier at the CU level that applies to the materials.
 * @param CUAllowableAction [[ch.ninecode.model.CUAllowableAction CUAllowableAction]] <em>undocumented</em>
 * @param CUAssets [[ch.ninecode.model.CUAsset CUAsset]] <em>undocumented</em>
 * @param CUContractorItems [[ch.ninecode.model.CUContractorItem CUContractorItem]] <em>undocumented</em>
 * @param CUGroup [[ch.ninecode.model.CUGroup CUGroup]] <em>undocumented</em>
 * @param CULaborItems [[ch.ninecode.model.CULaborItem CULaborItem]] <em>undocumented</em>
 * @param CUMaterialItems [[ch.ninecode.model.CUMaterialItem CUMaterialItem]] <em>undocumented</em>
 * @param CUWorkEquipmentItems [[ch.ninecode.model.CUWorkEquipmentItem CUWorkEquipmentItem]] <em>undocumented</em>
 * @param CostType [[ch.ninecode.model.CostType CostType]] <em>undocumented</em>
 * @param DesignLocationCUs [[ch.ninecode.model.DesignLocationCU DesignLocationCU]] <em>undocumented</em>
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
case class CompatibleUnit
(
    override val sup: WorkDocument,
    estCost: Double,
    quantity: String,
    CUAllowableAction: String,
    CUAssets: List[String],
    CUContractorItems: List[String],
    CUGroup: String,
    CULaborItems: List[String],
    CUMaterialItems: List[String],
    CUWorkEquipmentItems: List[String],
    CostType: String,
    DesignLocationCUs: List[String],
    Procedures: List[String],
    PropertyUnit: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, null, List(), List(), null, List(), List(), List(), null, List(), List(), null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CompatibleUnit.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CompatibleUnit.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CompatibleUnit.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (CompatibleUnit.fields (position), x))
        emitelem (0, estCost)
        emitelem (1, quantity)
        emitattr (2, CUAllowableAction)
        emitattrs (3, CUAssets)
        emitattrs (4, CUContractorItems)
        emitattr (5, CUGroup)
        emitattrs (6, CULaborItems)
        emitattrs (7, CUMaterialItems)
        emitattrs (8, CUWorkEquipmentItems)
        emitattr (9, CostType)
        emitattrs (10, DesignLocationCUs)
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
    val fields: Array[String] = Array[String] (
        "estCost",
        "quantity",
        "CUAllowableAction",
        "CUAssets",
        "CUContractorItems",
        "CUGroup",
        "CULaborItems",
        "CUMaterialItems",
        "CUWorkEquipmentItems",
        "CostType",
        "DesignLocationCUs",
        "Procedures",
        "PropertyUnit"
    )
    val estCost: Fielder = parse_element (element (cls, fields(0)))
    val quantity: Fielder = parse_element (element (cls, fields(1)))
    val CUAllowableAction: Fielder = parse_attribute (attribute (cls, fields(2)))
    val CUAssets: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val CUContractorItems: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val CUGroup: Fielder = parse_attribute (attribute (cls, fields(5)))
    val CULaborItems: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val CUMaterialItems: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val CUWorkEquipmentItems: FielderMultiple = parse_attributes (attribute (cls, fields(8)))
    val CostType: Fielder = parse_attribute (attribute (cls, fields(9)))
    val DesignLocationCUs: FielderMultiple = parse_attributes (attribute (cls, fields(10)))
    val Procedures: FielderMultiple = parse_attributes (attribute (cls, fields(11)))
    val PropertyUnit: Fielder = parse_attribute (attribute (cls, fields(12)))

    def parse (context: Context): CompatibleUnit =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = CompatibleUnit (
            WorkDocument.parse (context),
            toDouble (mask (estCost (), 0)),
            mask (quantity (), 1),
            mask (CUAllowableAction (), 2),
            masks (CUAssets (), 3),
            masks (CUContractorItems (), 4),
            mask (CUGroup (), 5),
            masks (CULaborItems (), 6),
            masks (CUMaterialItems (), 7),
            masks (CUWorkEquipmentItems (), 8),
            mask (CostType (), 9),
            masks (DesignLocationCUs (), 10),
            masks (Procedures (), 11),
            mask (PropertyUnit (), 12)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("CUAllowableAction", "CUAllowableAction", false),
        Relationship ("CUAssets", "CUAsset", true),
        Relationship ("CUContractorItems", "CUContractorItem", true),
        Relationship ("CUGroup", "CUGroup", false),
        Relationship ("CULaborItems", "CULaborItem", true),
        Relationship ("CUMaterialItems", "CUMaterialItem", true),
        Relationship ("CUWorkEquipmentItems", "CUWorkEquipmentItem", true),
        Relationship ("CostType", "CostType", false),
        Relationship ("DesignLocationCUs", "DesignLocationCU", true),
        Relationship ("Procedures", "Procedure", true),
        Relationship ("PropertyUnit", "PropertyUnit", false)
    )
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
case class ConditionFactor
(
    override val sup: WorkIdentifiedObject,
    cfValue: String,
    kind: String,
    status: String,
    DesignLocationCUs: List[String],
    DesignLocations: List[String],
    Designs: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, List(), List(), List()) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ConditionFactor.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ConditionFactor.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ConditionFactor.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (ConditionFactor.fields (position), x))
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
    val fields: Array[String] = Array[String] (
        "cfValue",
        "kind",
        "status",
        "DesignLocationCUs",
        "DesignLocations",
        "Designs"
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
        implicit var bitfields: Array[Int] = Array(0)
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
    val relations: List[Relationship] = List (
        Relationship ("DesignLocationCUs", "DesignLocationCU", true),
        Relationship ("DesignLocations", "DesignLocation", true),
        Relationship ("Designs", "Design", true)
    )
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
case class ContractorItem
(
    override val sup: WorkIdentifiedObject,
    activityCode: String,
    bidAmount: Double,
    cost: Double,
    status: String,
    ErpPayables: List[String],
    WorkCostDetail: String,
    WorkTask: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, 0.0, null, List(), null, null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ContractorItem.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ContractorItem.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ContractorItem.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (ContractorItem.fields (position), x))
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
    val fields: Array[String] = Array[String] (
        "activityCode",
        "bidAmount",
        "cost",
        "status",
        "ErpPayables",
        "WorkCostDetail",
        "WorkTask"
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
        implicit var bitfields: Array[Int] = Array(0)
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
    val relations: List[Relationship] = List (
        Relationship ("ErpPayables", "ErpPayable", true),
        Relationship ("WorkCostDetail", "WorkCostDetail", false),
        Relationship ("WorkTask", "OldWorkTask", false)
    )
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
 * @param ErpJournalEntries [[ch.ninecode.model.ErpJournalEntry ErpJournalEntry]] <em>undocumented</em>
 * @param ParentCostType [[ch.ninecode.model.CostType CostType]] <em>undocumented</em>
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
case class CostType
(
    override val sup: WorkIdentifiedObject,
    amountAssignable: Boolean,
    code: String,
    level: String,
    stage: String,
    status: String,
    ErpJournalEntries: List[String],
    ParentCostType: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, null, null, null, null, List(), null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CostType.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CostType.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CostType.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (CostType.fields (position), x))
        emitelem (0, amountAssignable)
        emitelem (1, code)
        emitelem (2, level)
        emitelem (3, stage)
        emitattr (4, status)
        emitattrs (5, ErpJournalEntries)
        emitattr (6, ParentCostType)
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
    val fields: Array[String] = Array[String] (
        "amountAssignable",
        "code",
        "level",
        "stage",
        "status",
        "ErpJournalEntries",
        "ParentCostType"
    )
    val amountAssignable: Fielder = parse_element (element (cls, fields(0)))
    val code: Fielder = parse_element (element (cls, fields(1)))
    val level: Fielder = parse_element (element (cls, fields(2)))
    val stage: Fielder = parse_element (element (cls, fields(3)))
    val status: Fielder = parse_attribute (attribute (cls, fields(4)))
    val ErpJournalEntries: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val ParentCostType: Fielder = parse_attribute (attribute (cls, fields(6)))

    def parse (context: Context): CostType =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = CostType (
            WorkIdentifiedObject.parse (context),
            toBoolean (mask (amountAssignable (), 0)),
            mask (code (), 1),
            mask (level (), 2),
            mask (stage (), 3),
            mask (status (), 4),
            masks (ErpJournalEntries (), 5),
            mask (ParentCostType (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ErpJournalEntries", "ErpJournalEntry", true),
        Relationship ("ParentCostType", "CostType", false)
    )
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
 * @param ErpQuoteLineItem [[ch.ninecode.model.ErpQuoteLineItem ErpQuoteLineItem]] <em>undocumented</em>
 * @param Work [[ch.ninecode.model.Work Work]] <em>undocumented</em>
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
case class Design
(
    override val sup: WorkDocument,
    costEstimate: Double,
    kind: String,
    price: Double,
    ConditionFactors: List[String],
    DesignLocations: List[String],
    DesignLocationsCUs: List[String],
    ErpQuoteLineItem: String,
    Work: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, 0.0, List(), List(), List(), null, null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Design.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Design.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Design.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (Design.fields (position), x))
        emitelem (0, costEstimate)
        emitattr (1, kind)
        emitelem (2, price)
        emitattrs (3, ConditionFactors)
        emitattrs (4, DesignLocations)
        emitattrs (5, DesignLocationsCUs)
        emitattr (6, ErpQuoteLineItem)
        emitattr (7, Work)
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
    val fields: Array[String] = Array[String] (
        "costEstimate",
        "kind",
        "price",
        "ConditionFactors",
        "DesignLocations",
        "DesignLocationsCUs",
        "ErpQuoteLineItem",
        "Work"
    )
    val costEstimate: Fielder = parse_element (element (cls, fields(0)))
    val kind: Fielder = parse_attribute (attribute (cls, fields(1)))
    val price: Fielder = parse_element (element (cls, fields(2)))
    val ConditionFactors: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val DesignLocations: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val DesignLocationsCUs: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val ErpQuoteLineItem: Fielder = parse_attribute (attribute (cls, fields(6)))
    val Work: Fielder = parse_attribute (attribute (cls, fields(7)))

    def parse (context: Context): Design =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Design (
            WorkDocument.parse (context),
            toDouble (mask (costEstimate (), 0)),
            mask (kind (), 1),
            toDouble (mask (price (), 2)),
            masks (ConditionFactors (), 3),
            masks (DesignLocations (), 4),
            masks (DesignLocationsCUs (), 5),
            mask (ErpQuoteLineItem (), 6),
            mask (Work (), 7)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ConditionFactors", "ConditionFactor", true),
        Relationship ("DesignLocations", "DesignLocation", true),
        Relationship ("DesignLocationsCUs", "DesignLocationCU", true),
        Relationship ("ErpQuoteLineItem", "ErpQuoteLineItem", false),
        Relationship ("Work", "Work", false)
    )
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
 * @param Designs [[ch.ninecode.model.Design Design]] <em>undocumented</em>
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
case class DesignLocation
(
    override val sup: WorkIdentifiedObject,
    spanLength: Double,
    status: String,
    ConditionFactors: List[String],
    Designs: List[String],
    WorkLocations: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, List(), List(), List()) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = DesignLocation.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DesignLocation.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DesignLocation.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (DesignLocation.fields (position), x))
        emitelem (0, spanLength)
        emitattr (1, status)
        emitattrs (2, ConditionFactors)
        emitattrs (3, Designs)
        emitattrs (4, WorkLocations)
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
    val fields: Array[String] = Array[String] (
        "spanLength",
        "status",
        "ConditionFactors",
        "Designs",
        "WorkLocations"
    )
    val spanLength: Fielder = parse_element (element (cls, fields(0)))
    val status: Fielder = parse_attribute (attribute (cls, fields(1)))
    val ConditionFactors: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val Designs: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val WorkLocations: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: Context): DesignLocation =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = DesignLocation (
            WorkIdentifiedObject.parse (context),
            toDouble (mask (spanLength (), 0)),
            mask (status (), 1),
            masks (ConditionFactors (), 2),
            masks (Designs (), 3),
            masks (WorkLocations (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ConditionFactors", "ConditionFactor", true),
        Relationship ("Designs", "Design", true),
        Relationship ("WorkLocations", "WorkLocation", true)
    )
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
case class DesignLocationCU
(
    override val sup: WorkIdentifiedObject,
    cuAccount: String,
    cuAction: String,
    cuQuantity: String,
    cuUsage: String,
    removalDate: String,
    status: String,
    toBeEnergised: Boolean,
    CUGroups: List[String],
    CompatibleUnits: List[String],
    ConditionFactors: List[String],
    DesignLocation: String,
    Designs: List[String],
    WorkTasks: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null, false, List(), List(), List(), null, List(), List()) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = DesignLocationCU.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DesignLocationCU.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DesignLocationCU.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (DesignLocationCU.fields (position), x))
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
    val fields: Array[String] = Array[String] (
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
        implicit var bitfields: Array[Int] = Array(0)
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
    val relations: List[Relationship] = List (
        Relationship ("CUGroups", "CUGroup", true),
        Relationship ("CompatibleUnits", "CompatibleUnit", true),
        Relationship ("ConditionFactors", "ConditionFactor", true),
        Relationship ("DesignLocation", "DesignLocation", false),
        Relationship ("Designs", "Design", true),
        Relationship ("WorkTasks", "OldWorkTask", true)
    )
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
case class InfoQuestion
(
    override val sup: WorkDocument,
    answer: String,
    answerDateTime: String,
    answerRemark: String,
    questionCode: String,
    questionRemark: String,
    questionText: String,
    questionType: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null, null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
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
    val fields: Array[String] = Array[String] (
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
        implicit var bitfields: Array[Int] = Array(0)
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
    val relations: List[Relationship] = List (

    )
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
case class LaborItem
(
    override val sup: WorkIdentifiedObject,
    activityCode: String,
    cost: Double,
    laborDuration: Double,
    laborRate: Double,
    status: String,
    ErpPersons: List[String],
    WorkCostDetail: String,
    WorkTask: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, 0.0, 0.0, null, List(), null, null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = LaborItem.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (LaborItem.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (LaborItem.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (LaborItem.fields (position), x))
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
    val fields: Array[String] = Array[String] (
        "activityCode",
        "cost",
        "laborDuration",
        "laborRate",
        "status",
        "ErpPersons",
        "WorkCostDetail",
        "WorkTask"
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
        implicit var bitfields: Array[Int] = Array(0)
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
    val relations: List[Relationship] = List (
        Relationship ("ErpPersons", "OldPerson", true),
        Relationship ("WorkCostDetail", "WorkCostDetail", false),
        Relationship ("WorkTask", "OldWorkTask", false)
    )
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
case class MiscCostItem
(
    override val sup: WorkIdentifiedObject,
    account: String,
    costPerUnit: Double,
    costType: String,
    externalRefID: String,
    quantity: String,
    status: String,
    DesignLocation: String,
    WorkCostDetail: String,
    WorkTask: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, null, null, null, null, null, null, null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
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
    val fields: Array[String] = Array[String] (
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
        implicit var bitfields: Array[Int] = Array(0)
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
    val relations: List[Relationship] = List (
        Relationship ("DesignLocation", "DesignLocation", false),
        Relationship ("WorkCostDetail", "WorkCostDetail", false),
        Relationship ("WorkTask", "OldWorkTask", false)
    )
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
case class NonStandardItem
(
    override val sup: WorkDocument,
    amount: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
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
    val fields: Array[String] = Array[String] (
        "amount"
    )
    val amount: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): NonStandardItem =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = NonStandardItem (
            WorkDocument.parse (context),
            toDouble (mask (amount (), 0))
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * A set of tasks is required to implement a design.
 *
 * @param sup [[ch.ninecode.model.WorkTask WorkTask]] Reference to the superclass object.
 * @param Capabilities [[ch.ninecode.model.Capability Capability]] <em>undocumented</em>
 * @param Design [[ch.ninecode.model.Design Design]] <em>undocumented</em>
 * @param DesignLocationCUs [[ch.ninecode.model.DesignLocationCU DesignLocationCU]] <em>undocumented</em>
 * @param OverheadCost [[ch.ninecode.model.OverheadCost OverheadCost]] <em>undocumented</em>
 * @param QualificationRequirements [[ch.ninecode.model.QualificationRequirement QualificationRequirement]] <em>undocumented</em>
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
case class OldWorkTask
(
    override val sup: WorkTask,
    Capabilities: List[String],
    Design: String,
    DesignLocationCUs: List[String],
    OverheadCost: String,
    QualificationRequirements: List[String],
    WorkFlowStep: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List(), null, List(), null, List(), null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = OldWorkTask.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OldWorkTask.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (OldWorkTask.fields (position), x))
        emitattrs (0, Capabilities)
        emitattr (1, Design)
        emitattrs (2, DesignLocationCUs)
        emitattr (3, OverheadCost)
        emitattrs (4, QualificationRequirements)
        emitattr (5, WorkFlowStep)
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
    val fields: Array[String] = Array[String] (
        "Capabilities",
        "Design",
        "DesignLocationCUs",
        "OverheadCost",
        "QualificationRequirements",
        "WorkFlowStep"
    )
    val Capabilities: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val Design: Fielder = parse_attribute (attribute (cls, fields(1)))
    val DesignLocationCUs: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val OverheadCost: Fielder = parse_attribute (attribute (cls, fields(3)))
    val QualificationRequirements: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val WorkFlowStep: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: Context): OldWorkTask =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = OldWorkTask (
            WorkTask.parse (context),
            masks (Capabilities (), 0),
            mask (Design (), 1),
            masks (DesignLocationCUs (), 2),
            mask (OverheadCost (), 3),
            masks (QualificationRequirements (), 4),
            mask (WorkFlowStep (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Capabilities", "Capability", true),
        Relationship ("Design", "Design", false),
        Relationship ("DesignLocationCUs", "DesignLocationCU", true),
        Relationship ("OverheadCost", "OverheadCost", false),
        Relationship ("QualificationRequirements", "QualificationRequirement", true),
        Relationship ("WorkFlowStep", "WorkFlowStep", false)
    )
}

/**
 * A request for other utilities to mark their underground facilities prior to commencement of construction and/or maintenance.
 *
 * @param sup [[ch.ninecode.model.WorkDocument WorkDocument]] Reference to the superclass object.
 * @param explosivesUsed True if explosives have been or are planned to be used.
 * @param markedIndicator True if work location has been marked, for example for a dig area.
 * @param markingInstruction Instructions for marking a dig area, if applicable.
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
case class OneCallRequest
(
    override val sup: WorkDocument,
    explosivesUsed: Boolean,
    markedIndicator: Boolean,
    markingInstruction: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, false, null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = OneCallRequest.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (OneCallRequest.fields (position), value)
        emitelem (0, explosivesUsed)
        emitelem (1, markedIndicator)
        emitelem (2, markingInstruction)
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
    val fields: Array[String] = Array[String] (
        "explosivesUsed",
        "markedIndicator",
        "markingInstruction"
    )
    val explosivesUsed: Fielder = parse_element (element (cls, fields(0)))
    val markedIndicator: Fielder = parse_element (element (cls, fields(1)))
    val markingInstruction: Fielder = parse_element (element (cls, fields(2)))

    def parse (context: Context): OneCallRequest =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = OneCallRequest (
            WorkDocument.parse (context),
            toBoolean (mask (explosivesUsed (), 0)),
            toBoolean (mask (markedIndicator (), 1)),
            mask (markingInstruction (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Overhead cost applied to work order.
 *
 * @param sup [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param code Overhead code.
 * @param cost The overhead cost to be applied.
 * @param status <em>undocumented</em>
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
case class OverheadCost
(
    override val sup: WorkIdentifiedObject,
    code: String,
    cost: Double,
    status: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = OverheadCost.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (OverheadCost.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OverheadCost.fields (position), value)
        emitelem (0, code)
        emitelem (1, cost)
        emitattr (2, status)
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
    val fields: Array[String] = Array[String] (
        "code",
        "cost",
        "status"
    )
    val code: Fielder = parse_element (element (cls, fields(0)))
    val cost: Fielder = parse_element (element (cls, fields(1)))
    val status: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): OverheadCost =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = OverheadCost (
            WorkIdentifiedObject.parse (context),
            mask (code (), 0),
            toDouble (mask (cost (), 1)),
            mask (status (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
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
case class Project
(
    override val sup: WorkDocument,
    budget: Double,
    BusinessCase: String,
    ErpProjectAccounting: String,
    ParentProject: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, null, null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Project.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Project.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Project.fields (position), value)
        emitelem (0, budget)
        emitattr (1, BusinessCase)
        emitattr (2, ErpProjectAccounting)
        emitattr (3, ParentProject)
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
    val fields: Array[String] = Array[String] (
        "budget",
        "BusinessCase",
        "ErpProjectAccounting",
        "ParentProject"
    )
    val budget: Fielder = parse_element (element (cls, fields(0)))
    val BusinessCase: Fielder = parse_attribute (attribute (cls, fields(1)))
    val ErpProjectAccounting: Fielder = parse_attribute (attribute (cls, fields(2)))
    val ParentProject: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): Project =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Project (
            WorkDocument.parse (context),
            toDouble (mask (budget (), 0)),
            mask (BusinessCase (), 1),
            mask (ErpProjectAccounting (), 2),
            mask (ParentProject (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("BusinessCase", "BusinessCase", false),
        Relationship ("ErpProjectAccounting", "ErpProjectAccounting", false),
        Relationship ("ParentProject", "Project", false)
    )
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
case class PropertyUnit
(
    override val sup: WorkIdentifiedObject,
    accountingUsage: String,
    activityCode: String,
    propertyAccount: String,
    status: String,
    CUMaterialItems: List[String],
    WorkCostDetails: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, List(), List()) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PropertyUnit.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PropertyUnit.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PropertyUnit.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (PropertyUnit.fields (position), x))
        emitelem (0, accountingUsage)
        emitattr (1, activityCode)
        emitelem (2, propertyAccount)
        emitattr (3, status)
        emitattrs (4, CUMaterialItems)
        emitattrs (5, WorkCostDetails)
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
    val fields: Array[String] = Array[String] (
        "accountingUsage",
        "activityCode",
        "propertyAccount",
        "status",
        "CUMaterialItems",
        "WorkCostDetails"
    )
    val accountingUsage: Fielder = parse_element (element (cls, fields(0)))
    val activityCode: Fielder = parse_attribute (attribute (cls, fields(1)))
    val propertyAccount: Fielder = parse_element (element (cls, fields(2)))
    val status: Fielder = parse_attribute (attribute (cls, fields(3)))
    val CUMaterialItems: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val WorkCostDetails: FielderMultiple = parse_attributes (attribute (cls, fields(5)))

    def parse (context: Context): PropertyUnit =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = PropertyUnit (
            WorkIdentifiedObject.parse (context),
            mask (accountingUsage (), 0),
            mask (activityCode (), 1),
            mask (propertyAccount (), 2),
            mask (status (), 3),
            masks (CUMaterialItems (), 4),
            masks (WorkCostDetails (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("CUMaterialItems", "CUMaterialItem", true),
        Relationship ("WorkCostDetails", "WorkCostDetail", true)
    )
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
case class QualificationRequirement
(
    override val sup: WorkIdentifiedObject,
    qualificationID: String,
    CULaborItems: List[String],
    Skills: List[String],
    Specifications: List[String],
    WorkTasks: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, List(), List(), List(), List()) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = QualificationRequirement.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (QualificationRequirement.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (QualificationRequirement.fields (position), x))
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
    val fields: Array[String] = Array[String] (
        "qualificationID",
        "CULaborItems",
        "Skills",
        "Specifications",
        "WorkTasks"
    )
    val qualificationID: Fielder = parse_element (element (cls, fields(0)))
    val CULaborItems: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val Skills: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val Specifications: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val WorkTasks: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: Context): QualificationRequirement =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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
    val relations: List[Relationship] = List (
        Relationship ("CULaborItems", "CULaborItem", true),
        Relationship ("Skills", "Skill", true),
        Relationship ("Specifications", "Specification", true),
        Relationship ("WorkTasks", "OldWorkTask", true)
    )
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
case class Regulation
(
    override val sup: WorkDocument,
    referenceNumber: String
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
    def WorkDocument: WorkDocument = sup.asInstanceOf[WorkDocument]
    override def copy (): Row = { clone ().asInstanceOf[Regulation] }
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
    val fields: Array[String] = Array[String] (
        "referenceNumber"
    )
    val referenceNumber: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): Regulation =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Regulation (
            WorkDocument.parse (context),
            mask (referenceNumber (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
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
case class ShiftPattern
(
    override val sup: WorkIdentifiedObject,
    assignmentType: String,
    cycleCount: Int,
    status: String,
    validityInterval: String,
    Crews: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0, null, null, List()) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ShiftPattern.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ShiftPattern.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ShiftPattern.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (ShiftPattern.fields (position), x))
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
    val fields: Array[String] = Array[String] (
        "assignmentType",
        "cycleCount",
        "status",
        "validityInterval",
        "Crews"
    )
    val assignmentType: Fielder = parse_element (element (cls, fields(0)))
    val cycleCount: Fielder = parse_element (element (cls, fields(1)))
    val status: Fielder = parse_attribute (attribute (cls, fields(2)))
    val validityInterval: Fielder = parse_attribute (attribute (cls, fields(3)))
    val Crews: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: Context): ShiftPattern =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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
    val relations: List[Relationship] = List (
        Relationship ("Crews", "OldCrew", true)
    )
}

/**
 * Documentation for a generic material item that may be used for design, work and other purposes.
 *
 * Any number of MaterialItems manufactured by various vendors may be used to perform this TypeMaterial.
 *
 * @param sup [[ch.ninecode.model.WorkDocument WorkDocument]] Reference to the superclass object.
 * @param costType The type of cost to which this Material Item belongs.
 * @param estUnitCost The estimated unit cost of this type of material, either for a unit cost or cost per unit length.
 *        Cost is for material or asset only and does not include labor to install/construct or configure it.
 * @param quantity The value, unit of measure, and multiplier for the quantity.
 * @param stockItem True if item is a stock item (default).
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
case class TypeMaterial
(
    override val sup: WorkDocument,
    costType: String,
    estUnitCost: Double,
    quantity: String,
    stockItem: Boolean
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, null, false) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TypeMaterial.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TypeMaterial.fields (position), value)
        emitelem (0, costType)
        emitelem (1, estUnitCost)
        emitelem (2, quantity)
        emitelem (3, stockItem)
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
    val fields: Array[String] = Array[String] (
        "costType",
        "estUnitCost",
        "quantity",
        "stockItem"
    )
    val costType: Fielder = parse_element (element (cls, fields(0)))
    val estUnitCost: Fielder = parse_element (element (cls, fields(1)))
    val quantity: Fielder = parse_element (element (cls, fields(2)))
    val stockItem: Fielder = parse_element (element (cls, fields(3)))

    def parse (context: Context): TypeMaterial =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = TypeMaterial (
            WorkDocument.parse (context),
            mask (costType (), 0),
            toDouble (mask (estUnitCost (), 1)),
            mask (quantity (), 2),
            toBoolean (mask (stockItem (), 3))
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
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
case class Usage
(
    override val sup: WorkIdentifiedObject,
    status: String,
    WorkTask: String
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
    def WorkIdentifiedObject: WorkIdentifiedObject = sup.asInstanceOf[WorkIdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Usage] }
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
    val fields: Array[String] = Array[String] (
        "status",
        "WorkTask"
    )
    val status: Fielder = parse_attribute (attribute (cls, fields(0)))
    val WorkTask: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): Usage =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Usage (
            WorkIdentifiedObject.parse (context),
            mask (status (), 0),
            mask (WorkTask (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("WorkTask", "OldWorkTask", false)
    )
}

/**
 * A collection of all of the individual cost items collected from multiple sources.
 *
 * @param sup [[ch.ninecode.model.WorkDocument WorkDocument]] Reference to the superclass object.
 * @param amount Amount in designated currency for work, either a total or an individual element.
 *        As defined in the attribute "type," multiple instances are applicable to each work for: planned cost, actual cost, authorized cost, budgeted cost, forecasted cost, other.
 * @param isDebit True if 'amount' is a debit, false if it is a credit.
 * @param transactionDateTime Date and time that 'amount' is posted to the work.
 * @param CostType [[ch.ninecode.model.CostType CostType]] <em>undocumented</em>
 * @param Design [[ch.ninecode.model.Design Design]] <em>undocumented</em>
 * @param ErpProjectAccounting [[ch.ninecode.model.ErpProjectAccounting ErpProjectAccounting]] <em>undocumented</em>
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
case class WorkCostDetail
(
    override val sup: WorkDocument,
    amount: Double,
    isDebit: Boolean,
    transactionDateTime: String,
    CostType: String,
    Design: String,
    ErpProjectAccounting: String,
    OverheadCost: String,
    PropertyUnits: List[String],
    WorkCostSummary: String,
    WorkTask: String,
    Works: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, false, null, null, null, null, null, List(), null, null, List()) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = WorkCostDetail.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (WorkCostDetail.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WorkCostDetail.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (WorkCostDetail.fields (position), x))
        emitelem (0, amount)
        emitelem (1, isDebit)
        emitelem (2, transactionDateTime)
        emitattr (3, CostType)
        emitattr (4, Design)
        emitattr (5, ErpProjectAccounting)
        emitattr (6, OverheadCost)
        emitattrs (7, PropertyUnits)
        emitattr (8, WorkCostSummary)
        emitattr (9, WorkTask)
        emitattrs (10, Works)
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
    val fields: Array[String] = Array[String] (
        "amount",
        "isDebit",
        "transactionDateTime",
        "CostType",
        "Design",
        "ErpProjectAccounting",
        "OverheadCost",
        "PropertyUnits",
        "WorkCostSummary",
        "WorkTask",
        "Works"
    )
    val amount: Fielder = parse_element (element (cls, fields(0)))
    val isDebit: Fielder = parse_element (element (cls, fields(1)))
    val transactionDateTime: Fielder = parse_element (element (cls, fields(2)))
    val CostType: Fielder = parse_attribute (attribute (cls, fields(3)))
    val Design: Fielder = parse_attribute (attribute (cls, fields(4)))
    val ErpProjectAccounting: Fielder = parse_attribute (attribute (cls, fields(5)))
    val OverheadCost: Fielder = parse_attribute (attribute (cls, fields(6)))
    val PropertyUnits: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val WorkCostSummary: Fielder = parse_attribute (attribute (cls, fields(8)))
    val WorkTask: Fielder = parse_attribute (attribute (cls, fields(9)))
    val Works: FielderMultiple = parse_attributes (attribute (cls, fields(10)))

    def parse (context: Context): WorkCostDetail =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = WorkCostDetail (
            WorkDocument.parse (context),
            toDouble (mask (amount (), 0)),
            toBoolean (mask (isDebit (), 1)),
            mask (transactionDateTime (), 2),
            mask (CostType (), 3),
            mask (Design (), 4),
            mask (ErpProjectAccounting (), 5),
            mask (OverheadCost (), 6),
            masks (PropertyUnits (), 7),
            mask (WorkCostSummary (), 8),
            mask (WorkTask (), 9),
            masks (Works (), 10)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("CostType", "CostType", false),
        Relationship ("Design", "Design", false),
        Relationship ("ErpProjectAccounting", "ErpProjectAccounting", false),
        Relationship ("OverheadCost", "OverheadCost", false),
        Relationship ("PropertyUnits", "PropertyUnit", true),
        Relationship ("WorkCostSummary", "WorkCostSummary", false),
        Relationship ("WorkTask", "OldWorkTask", false),
        Relationship ("Works", "Work", true)
    )
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
case class WorkCostSummary
(
    override val sup: WorkDocument,
    WorkCostDetail: String
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
    def WorkDocument: WorkDocument = sup.asInstanceOf[WorkDocument]
    override def copy (): Row = { clone ().asInstanceOf[WorkCostSummary] }
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
    val fields: Array[String] = Array[String] (
        "WorkCostDetail"
    )
    val WorkCostDetail: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): WorkCostSummary =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = WorkCostSummary (
            WorkDocument.parse (context),
            mask (WorkCostDetail (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("WorkCostDetail", "WorkCostDetail", false)
    )
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
case class WorkDocument
(
    override val sup: Document
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
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[WorkDocument] }
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
    val relations: List[Relationship] = List (

    )
}

/**
 * A pre-defined set of work steps for a given type of work.
 *
 * @param sup [[ch.ninecode.model.WorkIdentifiedObject WorkIdentifiedObject]] Reference to the superclass object.
 * @param sequenceNumber Used to define dependencies of each work flow step, which is for the instance of WorkTask associated with a given instance of WorkFlow.
 * @param status <em>undocumented</em>
 * @param Work [[ch.ninecode.model.Work Work]] <em>undocumented</em>
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
case class WorkFlowStep
(
    override val sup: WorkIdentifiedObject,
    sequenceNumber: Int,
    status: String,
    Work: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0, null, null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = WorkFlowStep.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (WorkFlowStep.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WorkFlowStep.fields (position), value)
        emitelem (0, sequenceNumber)
        emitattr (1, status)
        emitattr (2, Work)
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
    val fields: Array[String] = Array[String] (
        "sequenceNumber",
        "status",
        "Work"
    )
    val sequenceNumber: Fielder = parse_element (element (cls, fields(0)))
    val status: Fielder = parse_attribute (attribute (cls, fields(1)))
    val Work: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): WorkFlowStep =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = WorkFlowStep (
            WorkIdentifiedObject.parse (context),
            toInteger (mask (sequenceNumber (), 0)),
            mask (status (), 1),
            mask (Work (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Work", "Work", false)
    )
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
case class WorkIdentifiedObject
(
    override val sup: IdentifiedObject
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
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[WorkIdentifiedObject] }
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
    val relations: List[Relationship] = List (

    )
}

/**
 * A type of ActivityRecord that records information about the status of an item, such as a Work or WorkTask, at a point in time.
 *
 * @param sup [[ch.ninecode.model.ActivityRecord ActivityRecord]] Reference to the superclass object.
 * @param percentComplete Estimated percentage of completion of this individual work task or overall work order.
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
case class WorkStatusEntry
(
    override val sup: ActivityRecord,
    percentComplete: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ActivityRecord: ActivityRecord = sup.asInstanceOf[ActivityRecord]
    override def copy (): Row = { clone ().asInstanceOf[WorkStatusEntry] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = WorkStatusEntry.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (WorkStatusEntry.fields (position), value)
        emitelem (0, percentComplete)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WorkStatusEntry rdf:ID=\"%s\">\n%s\t</cim:WorkStatusEntry>".format (id, export_fields)
    }
}

object WorkStatusEntry
extends
    Parseable[WorkStatusEntry]
{
    val fields: Array[String] = Array[String] (
        "percentComplete"
    )
    val percentComplete: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): WorkStatusEntry =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = WorkStatusEntry (
            ActivityRecord.parse (context),
            toDouble (mask (percentComplete (), 0))
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
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
            CUAsset.register,
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
            WorkIdentifiedObject.register,
            WorkStatusEntry.register
        )
    }
}