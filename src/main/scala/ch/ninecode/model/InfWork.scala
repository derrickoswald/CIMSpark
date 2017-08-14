package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * A permit is sometimes needed to provide legal access to land or equipment.
 * For example, local authority permission for road works.
 *
 * @param sup Reference to the superclass object.
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
        sup.export_fields +
        (if (null != applicationNumber) "\t\t<cim:AccessPermit.applicationNumber>" + applicationNumber + "</cim:AccessPermit.applicationNumber>\n" else "") +
        (if (null != effectiveDate) "\t\t<cim:AccessPermit.effectiveDate>" + effectiveDate + "</cim:AccessPermit.effectiveDate>\n" else "") +
        (if (null != expirationDate) "\t\t<cim:AccessPermit.expirationDate>" + expirationDate + "</cim:AccessPermit.expirationDate>\n" else "") +
        "\t\t<cim:AccessPermit.payment>" + payment + "</cim:AccessPermit.payment>\n" +
        (if (null != permitID) "\t\t<cim:AccessPermit.permitID>" + permitID + "</cim:AccessPermit.permitID>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AccessPermit rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AccessPermit>"
    }
}

object AccessPermit
extends
    Parseable[AccessPermit]
{
    val applicationNumber = parse_element (element ("""AccessPermit.applicationNumber"""))
    val effectiveDate = parse_element (element ("""AccessPermit.effectiveDate"""))
    val expirationDate = parse_element (element ("""AccessPermit.expirationDate"""))
    val payment = parse_element (element ("""AccessPermit.payment"""))
    val permitID = parse_element (element ("""AccessPermit.permitID"""))
    def parse (context: Context): AccessPermit =
    {
        AccessPermit(
            WorkDocument.parse (context),
            applicationNumber (context),
            effectiveDate (context),
            expirationDate (context),
            toDouble (payment (context), context),
            permitID (context)
        )
    }
}

/**
 * An assignment is given to an ErpPerson, Crew, Organisation, Equipment Item, Tool, etc. and may be used to perform Work, WorkTasks, Procedures, etc.
 * TimeSchedules may be set up directly for Assignments or indirectly via the associated WorkTask. Note that these associations are all inherited through the recursive relationship on Document.
 *
 * @param sup Reference to the superclass object.
 * @param effectivePeriod Period between the assignment becoming effective and its expiration.
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
    effectivePeriod: String
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
        sup.export_fields +
        (if (null != effectivePeriod) "\t\t<cim:Assignment.effectivePeriod rdf:resource=\"#" + effectivePeriod + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Assignment rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Assignment>"
    }
}

object Assignment
extends
    Parseable[Assignment]
{
    val effectivePeriod = parse_attribute (attribute ("""Assignment.effectivePeriod"""))
    def parse (context: Context): Assignment =
    {
        Assignment(
            WorkDocument.parse (context),
            effectivePeriod (context)
        )
    }
}

/**
 * Business justification for capital expenditures, usually addressing operations and maintenance costs as well.
 *
 * @param sup Reference to the superclass object.
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
        sup.export_fields +
        (if (null != corporateCode) "\t\t<cim:BusinessCase.corporateCode>" + corporateCode + "</cim:BusinessCase.corporateCode>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:BusinessCase rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:BusinessCase>"
    }
}

object BusinessCase
extends
    Parseable[BusinessCase]
{
    val corporateCode = parse_element (element ("""BusinessCase.corporateCode"""))
    def parse (context: Context): BusinessCase =
    {
        BusinessCase(
            WorkDocument.parse (context),
            corporateCode (context)
        )
    }
}

/**
 * Allowed actions: Install, Remove, Transfer, Abandon, etc.
 *
 * @param sup Reference to the superclass object.
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
        sup.export_fields +
        (if (null != status) "\t\t<cim:CUAllowableAction.status rdf:resource=\"#" + status + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:CUAllowableAction rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CUAllowableAction>"
    }
}

object CUAllowableAction
extends
    Parseable[CUAllowableAction]
{
    val status = parse_attribute (attribute ("""CUAllowableAction.status"""))
    def parse (context: Context): CUAllowableAction =
    {
        CUAllowableAction(
            WorkIdentifiedObject.parse (context),
            status (context)
        )
    }
}

/**
 * Compatible unit for various types of assets such as transformers switches, substation fences, poles, etc..
 *
 * @param sup Reference to the superclass object.
 * @param quantity Quantity of the type asset within the CU.
 * @param status <em>undocumented</em>
 * @param typeAssetCode The code for this type of asset.
 * @param TypeAsset <em>undocumented</em>
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
    TypeAsset: String
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
        sup.export_fields +
        (if (null != quantity) "\t\t<cim:CUAsset.quantity rdf:resource=\"#" + quantity + "\"/>\n" else "") +
        (if (null != status) "\t\t<cim:CUAsset.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != typeAssetCode) "\t\t<cim:CUAsset.typeAssetCode>" + typeAssetCode + "</cim:CUAsset.typeAssetCode>\n" else "") +
        (if (null != TypeAsset) "\t\t<cim:CUAsset.TypeAsset rdf:resource=\"#" + TypeAsset + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:CUAsset rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CUAsset>"
    }
}

object CUAsset
extends
    Parseable[CUAsset]
{
    val quantity = parse_attribute (attribute ("""CUAsset.quantity"""))
    val status = parse_attribute (attribute ("""CUAsset.status"""))
    val typeAssetCode = parse_element (element ("""CUAsset.typeAssetCode"""))
    val TypeAsset = parse_attribute (attribute ("""CUAsset.TypeAsset"""))
    def parse (context: Context): CUAsset =
    {
        CUAsset(
            WorkIdentifiedObject.parse (context),
            quantity (context),
            status (context),
            typeAssetCode (context),
            TypeAsset (context)
        )
    }
}

/**
 * Compatible unit contractor item.
 *
 * @param sup Reference to the superclass object.
 * @param activityCode Activity code identifies a specific and distinguishable unit of work.
 * @param bidAmount The amount that a given contractor will charge for performing this unit of work.
 * @param status <em>undocumented</em>
 * @param CompatibleUnits <em>undocumented</em>
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
        sup.export_fields +
        (if (null != activityCode) "\t\t<cim:CUContractorItem.activityCode>" + activityCode + "</cim:CUContractorItem.activityCode>\n" else "") +
        "\t\t<cim:CUContractorItem.bidAmount>" + bidAmount + "</cim:CUContractorItem.bidAmount>\n" +
        (if (null != status) "\t\t<cim:CUContractorItem.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != CompatibleUnits) CompatibleUnits.map (x => "\t\t<cim:CUContractorItem.CompatibleUnits rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:CUContractorItem rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CUContractorItem>"
    }
}

object CUContractorItem
extends
    Parseable[CUContractorItem]
{
    val activityCode = parse_element (element ("""CUContractorItem.activityCode"""))
    val bidAmount = parse_element (element ("""CUContractorItem.bidAmount"""))
    val status = parse_attribute (attribute ("""CUContractorItem.status"""))
    val CompatibleUnits = parse_attributes (attribute ("""CUContractorItem.CompatibleUnits"""))
    def parse (context: Context): CUContractorItem =
    {
        CUContractorItem(
            WorkIdentifiedObject.parse (context),
            activityCode (context),
            toDouble (bidAmount (context), context),
            status (context),
            CompatibleUnits (context)
        )
    }
}

/**
 * A Compatible Unit Group identifies a set of compatible units which may be jointly utilized for estimating and designating jobs.
 *
 * @param sup Reference to the superclass object.
 * @param status <em>undocumented</em>
 * @param ChildCUGroups <em>undocumented</em>
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
    ChildCUGroups: List[String]
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
        sup.export_fields +
        (if (null != status) "\t\t<cim:CUGroup.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != ChildCUGroups) ChildCUGroups.map (x => "\t\t<cim:CUGroup.ChildCUGroups rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:CUGroup rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CUGroup>"
    }
}

object CUGroup
extends
    Parseable[CUGroup]
{
    val status = parse_attribute (attribute ("""CUGroup.status"""))
    val ChildCUGroups = parse_attributes (attribute ("""CUGroup.ChildCUGroups"""))
    def parse (context: Context): CUGroup =
    {
        CUGroup(
            WorkIdentifiedObject.parse (context),
            status (context),
            ChildCUGroups (context)
        )
    }
}

/**
 * Labor code associated with various compatible unit labor items.
 *
 * @param sup Reference to the superclass object.
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
        sup.export_fields +
        (if (null != code) "\t\t<cim:CULaborCode.code>" + code + "</cim:CULaborCode.code>\n" else "") +
        (if (null != status) "\t\t<cim:CULaborCode.status rdf:resource=\"#" + status + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:CULaborCode rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CULaborCode>"
    }
}

object CULaborCode
extends
    Parseable[CULaborCode]
{
    val code = parse_element (element ("""CULaborCode.code"""))
    val status = parse_attribute (attribute ("""CULaborCode.status"""))
    def parse (context: Context): CULaborCode =
    {
        CULaborCode(
            WorkIdentifiedObject.parse (context),
            code (context),
            status (context)
        )
    }
}

/**
 * Compatible unit labor item.
 *
 * @param sup Reference to the superclass object.
 * @param activityCode Activity code identifies a specific and distinguishable unit of work.
 * @param laborDuration Estimated time to perform work.
 * @param laborRate The labor rate applied for work.
 * @param status <em>undocumented</em>
 * @param CULaborCode <em>undocumented</em>
 * @param CompatibleUnits <em>undocumented</em>
 * @param QualificationRequirements <em>undocumented</em>
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
        sup.export_fields +
        (if (null != activityCode) "\t\t<cim:CULaborItem.activityCode>" + activityCode + "</cim:CULaborItem.activityCode>\n" else "") +
        "\t\t<cim:CULaborItem.laborDuration>" + laborDuration + "</cim:CULaborItem.laborDuration>\n" +
        "\t\t<cim:CULaborItem.laborRate>" + laborRate + "</cim:CULaborItem.laborRate>\n" +
        (if (null != status) "\t\t<cim:CULaborItem.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != CULaborCode) "\t\t<cim:CULaborItem.CULaborCode rdf:resource=\"#" + CULaborCode + "\"/>\n" else "") +
        (if (null != CompatibleUnits) CompatibleUnits.map (x => "\t\t<cim:CULaborItem.CompatibleUnits rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != QualificationRequirements) QualificationRequirements.map (x => "\t\t<cim:CULaborItem.QualificationRequirements rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:CULaborItem rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CULaborItem>"
    }
}

object CULaborItem
extends
    Parseable[CULaborItem]
{
    val activityCode = parse_element (element ("""CULaborItem.activityCode"""))
    val laborDuration = parse_element (element ("""CULaborItem.laborDuration"""))
    val laborRate = parse_element (element ("""CULaborItem.laborRate"""))
    val status = parse_attribute (attribute ("""CULaborItem.status"""))
    val CULaborCode = parse_attribute (attribute ("""CULaborItem.CULaborCode"""))
    val CompatibleUnits = parse_attributes (attribute ("""CULaborItem.CompatibleUnits"""))
    val QualificationRequirements = parse_attributes (attribute ("""CULaborItem.QualificationRequirements"""))
    def parse (context: Context): CULaborItem =
    {
        CULaborItem(
            WorkIdentifiedObject.parse (context),
            activityCode (context),
            toDouble (laborDuration (context), context),
            toDouble (laborRate (context), context),
            status (context),
            CULaborCode (context),
            CompatibleUnits (context),
            QualificationRequirements (context)
        )
    }
}

/**
 * Compatible unit of a consumable supply item.
 * For example, nuts, bolts, brackets, glue, etc.
 *
 * @param sup Reference to the superclass object.
 * @param corporateCode Code for material.
 * @param quantity Quantity of the TypeMaterial for this CU, used to determine estimated costs based on a per unit cost or a cost per unit length specified in the TypeMaterial.
 * @param status <em>undocumented</em>
 * @param CompatibleUnits <em>undocumented</em>
 * @param TypeMaterial <em>undocumented</em>
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
    TypeMaterial: String
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
        sup.export_fields +
        (if (null != corporateCode) "\t\t<cim:CUMaterialItem.corporateCode>" + corporateCode + "</cim:CUMaterialItem.corporateCode>\n" else "") +
        (if (null != quantity) "\t\t<cim:CUMaterialItem.quantity rdf:resource=\"#" + quantity + "\"/>\n" else "") +
        (if (null != status) "\t\t<cim:CUMaterialItem.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != CompatibleUnits) CompatibleUnits.map (x => "\t\t<cim:CUMaterialItem.CompatibleUnits rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != TypeMaterial) "\t\t<cim:CUMaterialItem.TypeMaterial rdf:resource=\"#" + TypeMaterial + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:CUMaterialItem rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CUMaterialItem>"
    }
}

object CUMaterialItem
extends
    Parseable[CUMaterialItem]
{
    val corporateCode = parse_element (element ("""CUMaterialItem.corporateCode"""))
    val quantity = parse_attribute (attribute ("""CUMaterialItem.quantity"""))
    val status = parse_attribute (attribute ("""CUMaterialItem.status"""))
    val CompatibleUnits = parse_attributes (attribute ("""CUMaterialItem.CompatibleUnits"""))
    val TypeMaterial = parse_attribute (attribute ("""CUMaterialItem.TypeMaterial"""))
    def parse (context: Context): CUMaterialItem =
    {
        CUMaterialItem(
            WorkIdentifiedObject.parse (context),
            corporateCode (context),
            quantity (context),
            status (context),
            CompatibleUnits (context),
            TypeMaterial (context)
        )
    }
}

/**
 * Compatible unit for various types of WorkEquipmentAssets, including vehicles.
 *
 * @param sup Reference to the superclass object.
 * @param equipCode The equipment type code.
 * @param rate Standard usage rate for the type of vehicle.
 * @param status <em>undocumented</em>
 * @param CompatibleUnits <em>undocumented</em>
 * @param TypeAsset <em>undocumented</em>
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
        sup.export_fields +
        (if (null != equipCode) "\t\t<cim:CUWorkEquipmentItem.equipCode>" + equipCode + "</cim:CUWorkEquipmentItem.equipCode>\n" else "") +
        "\t\t<cim:CUWorkEquipmentItem.rate>" + rate + "</cim:CUWorkEquipmentItem.rate>\n" +
        (if (null != status) "\t\t<cim:CUWorkEquipmentItem.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != CompatibleUnits) CompatibleUnits.map (x => "\t\t<cim:CUWorkEquipmentItem.CompatibleUnits rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != TypeAsset) "\t\t<cim:CUWorkEquipmentItem.TypeAsset rdf:resource=\"#" + TypeAsset + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:CUWorkEquipmentItem rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CUWorkEquipmentItem>"
    }
}

object CUWorkEquipmentItem
extends
    Parseable[CUWorkEquipmentItem]
{
    val equipCode = parse_element (element ("""CUWorkEquipmentItem.equipCode"""))
    val rate = parse_element (element ("""CUWorkEquipmentItem.rate"""))
    val status = parse_attribute (attribute ("""CUWorkEquipmentItem.status"""))
    val CompatibleUnits = parse_attributes (attribute ("""CUWorkEquipmentItem.CompatibleUnits"""))
    val TypeAsset = parse_attribute (attribute ("""CUWorkEquipmentItem.TypeAsset"""))
    def parse (context: Context): CUWorkEquipmentItem =
    {
        CUWorkEquipmentItem(
            WorkIdentifiedObject.parse (context),
            equipCode (context),
            toDouble (rate (context), context),
            status (context),
            CompatibleUnits (context),
            TypeAsset (context)
        )
    }
}

/**
 * Capabilities of a crew.
 *
 * @param sup Reference to the superclass object.
 * @param performanceFactor Capability performance factor.
 * @param status <em>undocumented</em>
 * @param typ Classification by utility's work management standards and practices.
 * @param validityInterval Date and time interval for which this capability is valid (when it became effective and when it expires).
 * @param Crafts <em>undocumented</em>
 * @param Crew <em>undocumented</em>
 * @param WorkTasks <em>undocumented</em>
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
    typ: String,
    validityInterval: String,
    Crafts: List[String],
    Crew: String,
    WorkTasks: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, List(), null, List()) }
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
        sup.export_fields +
        (if (null != performanceFactor) "\t\t<cim:Capability.performanceFactor>" + performanceFactor + "</cim:Capability.performanceFactor>\n" else "") +
        (if (null != status) "\t\t<cim:Capability.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != typ) "\t\t<cim:Capability.type>" + typ + "</cim:Capability.type>\n" else "") +
        (if (null != validityInterval) "\t\t<cim:Capability.validityInterval rdf:resource=\"#" + validityInterval + "\"/>\n" else "") +
        (if (null != Crafts) Crafts.map (x => "\t\t<cim:Capability.Crafts rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != Crew) "\t\t<cim:Capability.Crew rdf:resource=\"#" + Crew + "\"/>\n" else "") +
        (if (null != WorkTasks) WorkTasks.map (x => "\t\t<cim:Capability.WorkTasks rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:Capability rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Capability>"
    }
}

object Capability
extends
    Parseable[Capability]
{
    val performanceFactor = parse_element (element ("""Capability.performanceFactor"""))
    val status = parse_attribute (attribute ("""Capability.status"""))
    val typ = parse_element (element ("""Capability.type"""))
    val validityInterval = parse_attribute (attribute ("""Capability.validityInterval"""))
    val Crafts = parse_attributes (attribute ("""Capability.Crafts"""))
    val Crew = parse_attribute (attribute ("""Capability.Crew"""))
    val WorkTasks = parse_attributes (attribute ("""Capability.WorkTasks"""))
    def parse (context: Context): Capability =
    {
        Capability(
            WorkIdentifiedObject.parse (context),
            performanceFactor (context),
            status (context),
            typ (context),
            validityInterval (context),
            Crafts (context),
            Crew (context),
            WorkTasks (context)
        )
    }
}

/**
 * A pre-planned job model containing labor, material, and accounting requirements for standardized job planning.
 *
 * @param sup Reference to the superclass object.
 * @param estCost Estimated total cost for perfoming CU.
 * @param quantity The quantity, unit of measure, and multiplier at the CU level that applies to the materials.
 * @param CUAllowableAction <em>undocumented</em>
 * @param CUAssets <em>undocumented</em>
 * @param CUGroup <em>undocumented</em>
 * @param CostType <em>undocumented</em>
 * @param DesignLocationCUs <em>undocumented</em>
 * @param Procedures <em>undocumented</em>
 * @param PropertyUnit <em>undocumented</em>
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
    CUGroup: String,
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
    def this () = { this (null, 0.0, null, null, List(), null, null, List(), List(), null) }
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
        sup.export_fields +
        "\t\t<cim:CompatibleUnit.estCost>" + estCost + "</cim:CompatibleUnit.estCost>\n" +
        (if (null != quantity) "\t\t<cim:CompatibleUnit.quantity>" + quantity + "</cim:CompatibleUnit.quantity>\n" else "") +
        (if (null != CUAllowableAction) "\t\t<cim:CompatibleUnit.CUAllowableAction rdf:resource=\"#" + CUAllowableAction + "\"/>\n" else "") +
        (if (null != CUAssets) CUAssets.map (x => "\t\t<cim:CompatibleUnit.CUAssets rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != CUGroup) "\t\t<cim:CompatibleUnit.CUGroup rdf:resource=\"#" + CUGroup + "\"/>\n" else "") +
        (if (null != CostType) "\t\t<cim:CompatibleUnit.CostType rdf:resource=\"#" + CostType + "\"/>\n" else "") +
        (if (null != DesignLocationCUs) DesignLocationCUs.map (x => "\t\t<cim:CompatibleUnit.DesignLocationCUs rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != Procedures) Procedures.map (x => "\t\t<cim:CompatibleUnit.Procedures rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != PropertyUnit) "\t\t<cim:CompatibleUnit.PropertyUnit rdf:resource=\"#" + PropertyUnit + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:CompatibleUnit rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CompatibleUnit>"
    }
}

object CompatibleUnit
extends
    Parseable[CompatibleUnit]
{
    val estCost = parse_element (element ("""CompatibleUnit.estCost"""))
    val quantity = parse_element (element ("""CompatibleUnit.quantity"""))
    val CUAllowableAction = parse_attribute (attribute ("""CompatibleUnit.CUAllowableAction"""))
    val CUAssets = parse_attributes (attribute ("""CompatibleUnit.CUAssets"""))
    val CUGroup = parse_attribute (attribute ("""CompatibleUnit.CUGroup"""))
    val CostType = parse_attribute (attribute ("""CompatibleUnit.CostType"""))
    val DesignLocationCUs = parse_attributes (attribute ("""CompatibleUnit.DesignLocationCUs"""))
    val Procedures = parse_attributes (attribute ("""CompatibleUnit.Procedures"""))
    val PropertyUnit = parse_attribute (attribute ("""CompatibleUnit.PropertyUnit"""))
    def parse (context: Context): CompatibleUnit =
    {
        CompatibleUnit(
            WorkDocument.parse (context),
            toDouble (estCost (context), context),
            quantity (context),
            CUAllowableAction (context),
            CUAssets (context),
            CUGroup (context),
            CostType (context),
            DesignLocationCUs (context),
            Procedures (context),
            PropertyUnit (context)
        )
    }
}

/**
 * This is to specify the various condition factors for a design that may alter the cost estimate or the allocation.
 *
 * @param sup Reference to the superclass object.
 * @param cfValue The actual value of the condition factor, such as labor flat fee or percentage.
 * @param kind Kind of this condition factor.
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
case class ConditionFactor
(
    override val sup: WorkIdentifiedObject,
    cfValue: String,
    kind: String,
    status: String
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
        sup.export_fields +
        (if (null != cfValue) "\t\t<cim:ConditionFactor.cfValue>" + cfValue + "</cim:ConditionFactor.cfValue>\n" else "") +
        (if (null != kind) "\t\t<cim:ConditionFactor.kind rdf:resource=\"#" + kind + "\"/>\n" else "") +
        (if (null != status) "\t\t<cim:ConditionFactor.status rdf:resource=\"#" + status + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ConditionFactor rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ConditionFactor>"
    }
}

object ConditionFactor
extends
    Parseable[ConditionFactor]
{
    val cfValue = parse_element (element ("""ConditionFactor.cfValue"""))
    val kind = parse_attribute (attribute ("""ConditionFactor.kind"""))
    val status = parse_attribute (attribute ("""ConditionFactor.status"""))
    def parse (context: Context): ConditionFactor =
    {
        ConditionFactor(
            WorkIdentifiedObject.parse (context),
            cfValue (context),
            kind (context),
            status (context)
        )
    }
}

/**
 * Contractor information for work task.
 *
 * @param sup Reference to the superclass object.
 * @param activityCode Activity code identifies a specific and distinguishable unit of work.
 * @param bidAmount The amount that a given contractor will charge for performing this unit of work.
 * @param cost The total amount charged.
 * @param status <em>undocumented</em>
 * @param ErpPayables <em>undocumented</em>
 * @param WorkCostDetail <em>undocumented</em>
 * @param WorkTask <em>undocumented</em>
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
        sup.export_fields +
        (if (null != activityCode) "\t\t<cim:ContractorItem.activityCode>" + activityCode + "</cim:ContractorItem.activityCode>\n" else "") +
        "\t\t<cim:ContractorItem.bidAmount>" + bidAmount + "</cim:ContractorItem.bidAmount>\n" +
        "\t\t<cim:ContractorItem.cost>" + cost + "</cim:ContractorItem.cost>\n" +
        (if (null != status) "\t\t<cim:ContractorItem.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != ErpPayables) ErpPayables.map (x => "\t\t<cim:ContractorItem.ErpPayables rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != WorkCostDetail) "\t\t<cim:ContractorItem.WorkCostDetail rdf:resource=\"#" + WorkCostDetail + "\"/>\n" else "") +
        (if (null != WorkTask) "\t\t<cim:ContractorItem.WorkTask rdf:resource=\"#" + WorkTask + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ContractorItem rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ContractorItem>"
    }
}

object ContractorItem
extends
    Parseable[ContractorItem]
{
    val activityCode = parse_element (element ("""ContractorItem.activityCode"""))
    val bidAmount = parse_element (element ("""ContractorItem.bidAmount"""))
    val cost = parse_element (element ("""ContractorItem.cost"""))
    val status = parse_attribute (attribute ("""ContractorItem.status"""))
    val ErpPayables = parse_attributes (attribute ("""ContractorItem.ErpPayables"""))
    val WorkCostDetail = parse_attribute (attribute ("""ContractorItem.WorkCostDetail"""))
    val WorkTask = parse_attribute (attribute ("""ContractorItem.WorkTask"""))
    def parse (context: Context): ContractorItem =
    {
        ContractorItem(
            WorkIdentifiedObject.parse (context),
            activityCode (context),
            toDouble (bidAmount (context), context),
            toDouble (cost (context), context),
            status (context),
            ErpPayables (context),
            WorkCostDetail (context),
            WorkTask (context)
        )
    }
}

/**
 * A categorization for resources, often costs, in accounting transactions.
 * Examples include: material components, building in service, coal sales, overhead, etc.
 *
 * @param sup Reference to the superclass object.
 * @param amountAssignable True if an amount can be assigned to the resource element (e.g., building in service, transmission plant, software development capital); false otherwise (e.g., internal labor, material components).
 * @param code A codified representation of the resource element.
 * @param level The level of the resource element in the hierarchy of resource elements (recursive relationship).
 * @param stage The stage for which this costType applies: estimated design, estimated actual or actual actual.
 * @param status <em>undocumented</em>
 * @param ErpJournalEntries <em>undocumented</em>
 * @param ParentCostType <em>undocumented</em>
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
        sup.export_fields +
        "\t\t<cim:CostType.amountAssignable>" + amountAssignable + "</cim:CostType.amountAssignable>\n" +
        (if (null != code) "\t\t<cim:CostType.code>" + code + "</cim:CostType.code>\n" else "") +
        (if (null != level) "\t\t<cim:CostType.level>" + level + "</cim:CostType.level>\n" else "") +
        (if (null != stage) "\t\t<cim:CostType.stage>" + stage + "</cim:CostType.stage>\n" else "") +
        (if (null != status) "\t\t<cim:CostType.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != ErpJournalEntries) ErpJournalEntries.map (x => "\t\t<cim:CostType.ErpJournalEntries rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != ParentCostType) "\t\t<cim:CostType.ParentCostType rdf:resource=\"#" + ParentCostType + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:CostType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CostType>"
    }
}

object CostType
extends
    Parseable[CostType]
{
    val amountAssignable = parse_element (element ("""CostType.amountAssignable"""))
    val code = parse_element (element ("""CostType.code"""))
    val level = parse_element (element ("""CostType.level"""))
    val stage = parse_element (element ("""CostType.stage"""))
    val status = parse_attribute (attribute ("""CostType.status"""))
    val ErpJournalEntries = parse_attributes (attribute ("""CostType.ErpJournalEntries"""))
    val ParentCostType = parse_attribute (attribute ("""CostType.ParentCostType"""))
    def parse (context: Context): CostType =
    {
        CostType(
            WorkIdentifiedObject.parse (context),
            toBoolean (amountAssignable (context), context),
            code (context),
            level (context),
            stage (context),
            status (context),
            ErpJournalEntries (context),
            ParentCostType (context)
        )
    }
}

/**
 * A design for consideration by customers, potential customers, or internal work.
 * Note that the Version of design is the revision attribute that is inherited from Document.
 *
 * @param sup Reference to the superclass object.
 * @param costEstimate Estimated cost (not price) of design.
 * @param kind Kind of this design.
 * @param price Price to customer for implementing design.
 * @param ConditionFactors <em>undocumented</em>
 * @param ErpQuoteLineItem <em>undocumented</em>
 * @param Work <em>undocumented</em>
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
    ErpQuoteLineItem: String,
    Work: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, 0.0, List(), null, null) }
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
        sup.export_fields +
        "\t\t<cim:Design.costEstimate>" + costEstimate + "</cim:Design.costEstimate>\n" +
        (if (null != kind) "\t\t<cim:Design.kind rdf:resource=\"#" + kind + "\"/>\n" else "") +
        "\t\t<cim:Design.price>" + price + "</cim:Design.price>\n" +
        (if (null != ConditionFactors) ConditionFactors.map (x => "\t\t<cim:Design.ConditionFactors rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != ErpQuoteLineItem) "\t\t<cim:Design.ErpQuoteLineItem rdf:resource=\"#" + ErpQuoteLineItem + "\"/>\n" else "") +
        (if (null != Work) "\t\t<cim:Design.Work rdf:resource=\"#" + Work + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Design rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Design>"
    }
}

object Design
extends
    Parseable[Design]
{
    val costEstimate = parse_element (element ("""Design.costEstimate"""))
    val kind = parse_attribute (attribute ("""Design.kind"""))
    val price = parse_element (element ("""Design.price"""))
    val ConditionFactors = parse_attributes (attribute ("""Design.ConditionFactors"""))
    val ErpQuoteLineItem = parse_attribute (attribute ("""Design.ErpQuoteLineItem"""))
    val Work = parse_attribute (attribute ("""Design.Work"""))
    def parse (context: Context): Design =
    {
        Design(
            WorkDocument.parse (context),
            toDouble (costEstimate (context), context),
            kind (context),
            toDouble (price (context), context),
            ConditionFactors (context),
            ErpQuoteLineItem (context),
            Work (context)
        )
    }
}

/**
 * A logical part of the design (e.g., pole and all equipment on a pole).
 * This includes points and spans.
 *
 * @param sup Reference to the superclass object.
 * @param spanLength The legth of the span from the previous pole to this pole.
 * @param status <em>undocumented</em>
 * @param ConditionFactors <em>undocumented</em>
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
    ConditionFactors: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, List()) }
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
        sup.export_fields +
        "\t\t<cim:DesignLocation.spanLength>" + spanLength + "</cim:DesignLocation.spanLength>\n" +
        (if (null != status) "\t\t<cim:DesignLocation.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != ConditionFactors) ConditionFactors.map (x => "\t\t<cim:DesignLocation.ConditionFactors rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:DesignLocation rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DesignLocation>"
    }
}

object DesignLocation
extends
    Parseable[DesignLocation]
{
    val spanLength = parse_element (element ("""DesignLocation.spanLength"""))
    val status = parse_attribute (attribute ("""DesignLocation.status"""))
    val ConditionFactors = parse_attributes (attribute ("""DesignLocation.ConditionFactors"""))
    def parse (context: Context): DesignLocation =
    {
        DesignLocation(
            WorkIdentifiedObject.parse (context),
            toDouble (spanLength (context), context),
            status (context),
            ConditionFactors (context)
        )
    }
}

/**
 * Compatible unit at a given design location.
 *
 * @param sup Reference to the superclass object.
 * @param cuAccount A code that helps direct accounting (capital, expense, or accounting treatment).
 * @param cuAction A code that instructs the crew what action to perform.
 * @param cuQuantity The quantity of the CU being assigned to this location.
 * @param cuUsage As the same CU can be used for different purposes and accounting purposes, usage must be specified.
 *        Examples include: distribution, transmission, substation.
 * @param removalDate Year when a CU that represents an asset is removed.
 * @param status <em>undocumented</em>
 * @param toBeEnergised True if associated electrical equipment is intended to be energized while work is being performed.
 * @param CUGroups <em>undocumented</em>
 * @param ConditionFactors <em>undocumented</em>
 * @param DesignLocation <em>undocumented</em>
 * @param Designs <em>undocumented</em>
 * @param WorkTasks <em>undocumented</em>
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
    def this () = { this (null, null, null, null, null, null, null, false, List(), List(), null, List(), List()) }
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
        sup.export_fields +
        (if (null != cuAccount) "\t\t<cim:DesignLocationCU.cuAccount>" + cuAccount + "</cim:DesignLocationCU.cuAccount>\n" else "") +
        (if (null != cuAction) "\t\t<cim:DesignLocationCU.cuAction rdf:resource=\"#" + cuAction + "\"/>\n" else "") +
        (if (null != cuQuantity) "\t\t<cim:DesignLocationCU.cuQuantity rdf:resource=\"#" + cuQuantity + "\"/>\n" else "") +
        (if (null != cuUsage) "\t\t<cim:DesignLocationCU.cuUsage>" + cuUsage + "</cim:DesignLocationCU.cuUsage>\n" else "") +
        (if (null != removalDate) "\t\t<cim:DesignLocationCU.removalDate>" + removalDate + "</cim:DesignLocationCU.removalDate>\n" else "") +
        (if (null != status) "\t\t<cim:DesignLocationCU.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        "\t\t<cim:DesignLocationCU.toBeEnergised>" + toBeEnergised + "</cim:DesignLocationCU.toBeEnergised>\n" +
        (if (null != CUGroups) CUGroups.map (x => "\t\t<cim:DesignLocationCU.CUGroups rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != ConditionFactors) ConditionFactors.map (x => "\t\t<cim:DesignLocationCU.ConditionFactors rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != DesignLocation) "\t\t<cim:DesignLocationCU.DesignLocation rdf:resource=\"#" + DesignLocation + "\"/>\n" else "") +
        (if (null != Designs) Designs.map (x => "\t\t<cim:DesignLocationCU.Designs rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != WorkTasks) WorkTasks.map (x => "\t\t<cim:DesignLocationCU.WorkTasks rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:DesignLocationCU rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DesignLocationCU>"
    }
}

object DesignLocationCU
extends
    Parseable[DesignLocationCU]
{
    val cuAccount = parse_element (element ("""DesignLocationCU.cuAccount"""))
    val cuAction = parse_attribute (attribute ("""DesignLocationCU.cuAction"""))
    val cuQuantity = parse_attribute (attribute ("""DesignLocationCU.cuQuantity"""))
    val cuUsage = parse_element (element ("""DesignLocationCU.cuUsage"""))
    val removalDate = parse_element (element ("""DesignLocationCU.removalDate"""))
    val status = parse_attribute (attribute ("""DesignLocationCU.status"""))
    val toBeEnergised = parse_element (element ("""DesignLocationCU.toBeEnergised"""))
    val CUGroups = parse_attributes (attribute ("""DesignLocationCU.CUGroups"""))
    val ConditionFactors = parse_attributes (attribute ("""DesignLocationCU.ConditionFactors"""))
    val DesignLocation = parse_attribute (attribute ("""DesignLocationCU.DesignLocation"""))
    val Designs = parse_attributes (attribute ("""DesignLocationCU.Designs"""))
    val WorkTasks = parse_attributes (attribute ("""DesignLocationCU.WorkTasks"""))
    def parse (context: Context): DesignLocationCU =
    {
        DesignLocationCU(
            WorkIdentifiedObject.parse (context),
            cuAccount (context),
            cuAction (context),
            cuQuantity (context),
            cuUsage (context),
            removalDate (context),
            status (context),
            toBoolean (toBeEnergised (context), context),
            CUGroups (context),
            ConditionFactors (context),
            DesignLocation (context),
            Designs (context),
            WorkTasks (context)
        )
    }
}

/**
 * Questions and answers associated with a type of document for purposes of clarification.
 * Questions may be predefined or ad hoc.
 *
 * @param sup Reference to the superclass object.
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
        sup.export_fields +
        (if (null != answer) "\t\t<cim:InfoQuestion.answer>" + answer + "</cim:InfoQuestion.answer>\n" else "") +
        (if (null != answerDateTime) "\t\t<cim:InfoQuestion.answerDateTime>" + answerDateTime + "</cim:InfoQuestion.answerDateTime>\n" else "") +
        (if (null != answerRemark) "\t\t<cim:InfoQuestion.answerRemark>" + answerRemark + "</cim:InfoQuestion.answerRemark>\n" else "") +
        (if (null != questionCode) "\t\t<cim:InfoQuestion.questionCode>" + questionCode + "</cim:InfoQuestion.questionCode>\n" else "") +
        (if (null != questionRemark) "\t\t<cim:InfoQuestion.questionRemark>" + questionRemark + "</cim:InfoQuestion.questionRemark>\n" else "") +
        (if (null != questionText) "\t\t<cim:InfoQuestion.questionText>" + questionText + "</cim:InfoQuestion.questionText>\n" else "") +
        (if (null != questionType) "\t\t<cim:InfoQuestion.questionType>" + questionType + "</cim:InfoQuestion.questionType>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:InfoQuestion rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:InfoQuestion>"
    }
}

object InfoQuestion
extends
    Parseable[InfoQuestion]
{
    val answer = parse_element (element ("""InfoQuestion.answer"""))
    val answerDateTime = parse_element (element ("""InfoQuestion.answerDateTime"""))
    val answerRemark = parse_element (element ("""InfoQuestion.answerRemark"""))
    val questionCode = parse_element (element ("""InfoQuestion.questionCode"""))
    val questionRemark = parse_element (element ("""InfoQuestion.questionRemark"""))
    val questionText = parse_element (element ("""InfoQuestion.questionText"""))
    val questionType = parse_element (element ("""InfoQuestion.questionType"""))
    def parse (context: Context): InfoQuestion =
    {
        InfoQuestion(
            WorkDocument.parse (context),
            answer (context),
            answerDateTime (context),
            answerRemark (context),
            questionCode (context),
            questionRemark (context),
            questionText (context),
            questionType (context)
        )
    }
}

/**
 * Labor used for work order.
 *
 * @param sup Reference to the superclass object.
 * @param activityCode Activity code identifies a specific and distinguishable unit of work.
 * @param cost Total cost for labor.
 *        Note that this may not be able to be derived from labor rate and time charged.
 * @param laborDuration Time required to perform work.
 * @param laborRate The labor rate applied for work.
 * @param status <em>undocumented</em>
 * @param WorkCostDetail <em>undocumented</em>
 * @param WorkTask <em>undocumented</em>
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
    WorkCostDetail: String,
    WorkTask: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, 0.0, 0.0, null, null, null) }
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
        sup.export_fields +
        (if (null != activityCode) "\t\t<cim:LaborItem.activityCode>" + activityCode + "</cim:LaborItem.activityCode>\n" else "") +
        "\t\t<cim:LaborItem.cost>" + cost + "</cim:LaborItem.cost>\n" +
        "\t\t<cim:LaborItem.laborDuration>" + laborDuration + "</cim:LaborItem.laborDuration>\n" +
        "\t\t<cim:LaborItem.laborRate>" + laborRate + "</cim:LaborItem.laborRate>\n" +
        (if (null != status) "\t\t<cim:LaborItem.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != WorkCostDetail) "\t\t<cim:LaborItem.WorkCostDetail rdf:resource=\"#" + WorkCostDetail + "\"/>\n" else "") +
        (if (null != WorkTask) "\t\t<cim:LaborItem.WorkTask rdf:resource=\"#" + WorkTask + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:LaborItem rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:LaborItem>"
    }
}

object LaborItem
extends
    Parseable[LaborItem]
{
    val activityCode = parse_element (element ("""LaborItem.activityCode"""))
    val cost = parse_element (element ("""LaborItem.cost"""))
    val laborDuration = parse_element (element ("""LaborItem.laborDuration"""))
    val laborRate = parse_element (element ("""LaborItem.laborRate"""))
    val status = parse_attribute (attribute ("""LaborItem.status"""))
    val WorkCostDetail = parse_attribute (attribute ("""LaborItem.WorkCostDetail"""))
    val WorkTask = parse_attribute (attribute ("""LaborItem.WorkTask"""))
    def parse (context: Context): LaborItem =
    {
        LaborItem(
            WorkIdentifiedObject.parse (context),
            activityCode (context),
            toDouble (cost (context), context),
            toDouble (laborDuration (context), context),
            toDouble (laborRate (context), context),
            status (context),
            WorkCostDetail (context),
            WorkTask (context)
        )
    }
}

/**
 * Various cost items that are not associated with compatible units.
 * Examples include rental equipment, labor, materials, contractor costs, permits - anything not covered in a CU.
 *
 * @param sup Reference to the superclass object.
 * @param account This drives the accounting treatment for this misc. item.
 * @param costPerUnit The cost per unit for this misc. item.
 * @param costType The cost type for accounting, such as material, labor, vehicle, contractor, equipment, overhead.
 * @param externalRefID External reference identifier (e.g. purchase order number, serial number) .
 * @param quantity The quantity of the misc. item being assigned to this location.
 * @param status <em>undocumented</em>
 * @param DesignLocation <em>undocumented</em>
 * @param WorkCostDetail <em>undocumented</em>
 * @param WorkTask <em>undocumented</em>
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
        sup.export_fields +
        (if (null != account) "\t\t<cim:MiscCostItem.account>" + account + "</cim:MiscCostItem.account>\n" else "") +
        "\t\t<cim:MiscCostItem.costPerUnit>" + costPerUnit + "</cim:MiscCostItem.costPerUnit>\n" +
        (if (null != costType) "\t\t<cim:MiscCostItem.costType>" + costType + "</cim:MiscCostItem.costType>\n" else "") +
        (if (null != externalRefID) "\t\t<cim:MiscCostItem.externalRefID>" + externalRefID + "</cim:MiscCostItem.externalRefID>\n" else "") +
        (if (null != quantity) "\t\t<cim:MiscCostItem.quantity rdf:resource=\"#" + quantity + "\"/>\n" else "") +
        (if (null != status) "\t\t<cim:MiscCostItem.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != DesignLocation) "\t\t<cim:MiscCostItem.DesignLocation rdf:resource=\"#" + DesignLocation + "\"/>\n" else "") +
        (if (null != WorkCostDetail) "\t\t<cim:MiscCostItem.WorkCostDetail rdf:resource=\"#" + WorkCostDetail + "\"/>\n" else "") +
        (if (null != WorkTask) "\t\t<cim:MiscCostItem.WorkTask rdf:resource=\"#" + WorkTask + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MiscCostItem rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MiscCostItem>"
    }
}

object MiscCostItem
extends
    Parseable[MiscCostItem]
{
    val account = parse_element (element ("""MiscCostItem.account"""))
    val costPerUnit = parse_element (element ("""MiscCostItem.costPerUnit"""))
    val costType = parse_element (element ("""MiscCostItem.costType"""))
    val externalRefID = parse_element (element ("""MiscCostItem.externalRefID"""))
    val quantity = parse_attribute (attribute ("""MiscCostItem.quantity"""))
    val status = parse_attribute (attribute ("""MiscCostItem.status"""))
    val DesignLocation = parse_attribute (attribute ("""MiscCostItem.DesignLocation"""))
    val WorkCostDetail = parse_attribute (attribute ("""MiscCostItem.WorkCostDetail"""))
    val WorkTask = parse_attribute (attribute ("""MiscCostItem.WorkTask"""))
    def parse (context: Context): MiscCostItem =
    {
        MiscCostItem(
            WorkIdentifiedObject.parse (context),
            account (context),
            toDouble (costPerUnit (context), context),
            costType (context),
            externalRefID (context),
            quantity (context),
            status (context),
            DesignLocation (context),
            WorkCostDetail (context),
            WorkTask (context)
        )
    }
}

/**
 * This document provides information for non-standard items like customer contributions (e.g., customer digs trench), vouchers (e.g., credit), and contractor bids.
 *
 * @param sup Reference to the superclass object.
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
        sup.export_fields +
        "\t\t<cim:NonStandardItem.amount>" + amount + "</cim:NonStandardItem.amount>\n"
    }
    override def export: String =
    {
        "\t<cim:NonStandardItem rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:NonStandardItem>"
    }
}

object NonStandardItem
extends
    Parseable[NonStandardItem]
{
    val amount = parse_element (element ("""NonStandardItem.amount"""))
    def parse (context: Context): NonStandardItem =
    {
        NonStandardItem(
            WorkDocument.parse (context),
            toDouble (amount (context), context)
        )
    }
}

/**
 * A set of tasks is required to implement a design.
 *
 * @param sup Reference to the superclass object.
 * @param Design <em>undocumented</em>
 * @param OverheadCost <em>undocumented</em>
 * @param QualificationRequirements <em>undocumented</em>
 * @param WorkFlowStep <em>undocumented</em>
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
    Design: String,
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
    def this () = { this (null, null, null, List(), null) }
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
        sup.export_fields +
        (if (null != Design) "\t\t<cim:OldWorkTask.Design rdf:resource=\"#" + Design + "\"/>\n" else "") +
        (if (null != OverheadCost) "\t\t<cim:OldWorkTask.OverheadCost rdf:resource=\"#" + OverheadCost + "\"/>\n" else "") +
        (if (null != QualificationRequirements) QualificationRequirements.map (x => "\t\t<cim:OldWorkTask.QualificationRequirements rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != WorkFlowStep) "\t\t<cim:OldWorkTask.WorkFlowStep rdf:resource=\"#" + WorkFlowStep + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:OldWorkTask rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:OldWorkTask>"
    }
}

object OldWorkTask
extends
    Parseable[OldWorkTask]
{
    val Design = parse_attribute (attribute ("""OldWorkTask.Design"""))
    val OverheadCost = parse_attribute (attribute ("""OldWorkTask.OverheadCost"""))
    val QualificationRequirements = parse_attributes (attribute ("""OldWorkTask.QualificationRequirements"""))
    val WorkFlowStep = parse_attribute (attribute ("""OldWorkTask.WorkFlowStep"""))
    def parse (context: Context): OldWorkTask =
    {
        OldWorkTask(
            WorkTask.parse (context),
            Design (context),
            OverheadCost (context),
            QualificationRequirements (context),
            WorkFlowStep (context)
        )
    }
}

/**
 * A request for other utilities to mark their underground facilities prior to commencement of construction and/or maintenance.
 *
 * @param sup Reference to the superclass object.
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
        sup.export_fields +
        "\t\t<cim:OneCallRequest.explosivesUsed>" + explosivesUsed + "</cim:OneCallRequest.explosivesUsed>\n" +
        "\t\t<cim:OneCallRequest.markedIndicator>" + markedIndicator + "</cim:OneCallRequest.markedIndicator>\n" +
        (if (null != markingInstruction) "\t\t<cim:OneCallRequest.markingInstruction>" + markingInstruction + "</cim:OneCallRequest.markingInstruction>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:OneCallRequest rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:OneCallRequest>"
    }
}

object OneCallRequest
extends
    Parseable[OneCallRequest]
{
    val explosivesUsed = parse_element (element ("""OneCallRequest.explosivesUsed"""))
    val markedIndicator = parse_element (element ("""OneCallRequest.markedIndicator"""))
    val markingInstruction = parse_element (element ("""OneCallRequest.markingInstruction"""))
    def parse (context: Context): OneCallRequest =
    {
        OneCallRequest(
            WorkDocument.parse (context),
            toBoolean (explosivesUsed (context), context),
            toBoolean (markedIndicator (context), context),
            markingInstruction (context)
        )
    }
}

/**
 * Overhead cost applied to work order.
 *
 * @param sup Reference to the superclass object.
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
        sup.export_fields +
        (if (null != code) "\t\t<cim:OverheadCost.code>" + code + "</cim:OverheadCost.code>\n" else "") +
        "\t\t<cim:OverheadCost.cost>" + cost + "</cim:OverheadCost.cost>\n" +
        (if (null != status) "\t\t<cim:OverheadCost.status rdf:resource=\"#" + status + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:OverheadCost rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:OverheadCost>"
    }
}

object OverheadCost
extends
    Parseable[OverheadCost]
{
    val code = parse_element (element ("""OverheadCost.code"""))
    val cost = parse_element (element ("""OverheadCost.cost"""))
    val status = parse_attribute (attribute ("""OverheadCost.status"""))
    def parse (context: Context): OverheadCost =
    {
        OverheadCost(
            WorkIdentifiedObject.parse (context),
            code (context),
            toDouble (cost (context), context),
            status (context)
        )
    }
}

/**
 * A collection of related work.
 * For construction projects and maintenance projects, multiple phases may be performed.
 *
 * @param sup Reference to the superclass object.
 * @param budget Overall project budget.
 * @param BusinessCase <em>undocumented</em>
 * @param ErpProjectAccounting <em>undocumented</em>
 * @param ParentProject <em>undocumented</em>
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
        sup.export_fields +
        "\t\t<cim:Project.budget>" + budget + "</cim:Project.budget>\n" +
        (if (null != BusinessCase) "\t\t<cim:Project.BusinessCase rdf:resource=\"#" + BusinessCase + "\"/>\n" else "") +
        (if (null != ErpProjectAccounting) "\t\t<cim:Project.ErpProjectAccounting rdf:resource=\"#" + ErpProjectAccounting + "\"/>\n" else "") +
        (if (null != ParentProject) "\t\t<cim:Project.ParentProject rdf:resource=\"#" + ParentProject + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Project rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Project>"
    }
}

object Project
extends
    Parseable[Project]
{
    val budget = parse_element (element ("""Project.budget"""))
    val BusinessCase = parse_attribute (attribute ("""Project.BusinessCase"""))
    val ErpProjectAccounting = parse_attribute (attribute ("""Project.ErpProjectAccounting"""))
    val ParentProject = parse_attribute (attribute ("""Project.ParentProject"""))
    def parse (context: Context): Project =
    {
        Project(
            WorkDocument.parse (context),
            toDouble (budget (context), context),
            BusinessCase (context),
            ErpProjectAccounting (context),
            ParentProject (context)
        )
    }
}

/**
 * Unit of property for reporting purposes.
 *
 * @param sup Reference to the superclass object.
 * @param accountingUsage A code that identifies appropriate type of property accounts such as distribution, streetlgihts, communications.
 * @param activityCode Activity code identifies a specific and distinguishable work action.
 * @param propertyAccount Used for property record accounting.
 *        For example, in the USA, this would be a FERC account.
 * @param status <em>undocumented</em>
 * @param CUMaterialItems <em>undocumented</em>
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
    CUMaterialItems: List[String]
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
        sup.export_fields +
        (if (null != accountingUsage) "\t\t<cim:PropertyUnit.accountingUsage>" + accountingUsage + "</cim:PropertyUnit.accountingUsage>\n" else "") +
        (if (null != activityCode) "\t\t<cim:PropertyUnit.activityCode rdf:resource=\"#" + activityCode + "\"/>\n" else "") +
        (if (null != propertyAccount) "\t\t<cim:PropertyUnit.propertyAccount>" + propertyAccount + "</cim:PropertyUnit.propertyAccount>\n" else "") +
        (if (null != status) "\t\t<cim:PropertyUnit.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != CUMaterialItems) CUMaterialItems.map (x => "\t\t<cim:PropertyUnit.CUMaterialItems rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:PropertyUnit rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PropertyUnit>"
    }
}

object PropertyUnit
extends
    Parseable[PropertyUnit]
{
    val accountingUsage = parse_element (element ("""PropertyUnit.accountingUsage"""))
    val activityCode = parse_attribute (attribute ("""PropertyUnit.activityCode"""))
    val propertyAccount = parse_element (element ("""PropertyUnit.propertyAccount"""))
    val status = parse_attribute (attribute ("""PropertyUnit.status"""))
    val CUMaterialItems = parse_attributes (attribute ("""PropertyUnit.CUMaterialItems"""))
    def parse (context: Context): PropertyUnit =
    {
        PropertyUnit(
            WorkIdentifiedObject.parse (context),
            accountingUsage (context),
            activityCode (context),
            propertyAccount (context),
            status (context),
            CUMaterialItems (context)
        )
    }
}

/**
 * Certain skills are required and must be certified in order for a person (typically a member of a crew) to be qualified to work on types of equipment.
 *
 * @param sup Reference to the superclass object.
 * @param qualificationID Qualification identifier.
 * @param Specifications <em>undocumented</em>
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
    Specifications: List[String]
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
        sup.export_fields +
        (if (null != qualificationID) "\t\t<cim:QualificationRequirement.qualificationID>" + qualificationID + "</cim:QualificationRequirement.qualificationID>\n" else "") +
        (if (null != Specifications) Specifications.map (x => "\t\t<cim:QualificationRequirement.Specifications rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:QualificationRequirement rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:QualificationRequirement>"
    }
}

object QualificationRequirement
extends
    Parseable[QualificationRequirement]
{
    val qualificationID = parse_element (element ("""QualificationRequirement.qualificationID"""))
    val Specifications = parse_attributes (attribute ("""QualificationRequirement.Specifications"""))
    def parse (context: Context): QualificationRequirement =
    {
        QualificationRequirement(
            WorkIdentifiedObject.parse (context),
            qualificationID (context),
            Specifications (context)
        )
    }
}

/**
 * Special requirements and/or regulations may pertain to certain types of assets or work.
 * For example, fire protection and scaffolding.
 *
 * @param sup Reference to the superclass object.
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
        sup.export_fields +
        (if (null != referenceNumber) "\t\t<cim:Regulation.referenceNumber>" + referenceNumber + "</cim:Regulation.referenceNumber>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Regulation rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Regulation>"
    }
}

object Regulation
extends
    Parseable[Regulation]
{
    val referenceNumber = parse_element (element ("""Regulation.referenceNumber"""))
    def parse (context: Context): Regulation =
    {
        Regulation(
            WorkDocument.parse (context),
            referenceNumber (context)
        )
    }
}

/**
 * The patterns of shifts worked by people or crews.
 *
 * @param sup Reference to the superclass object.
 * @param assignmentType Type of assignement intended to be worked on this shift, for example, temporary, standard, etc.
 * @param cycleCount Number of cycles for a temporary shift.
 * @param status <em>undocumented</em>
 * @param validityInterval Date and time interval for which this shift pattern is valid (when it became effective and when it expires).
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
    validityInterval: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0, null, null) }
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
        sup.export_fields +
        (if (null != assignmentType) "\t\t<cim:ShiftPattern.assignmentType>" + assignmentType + "</cim:ShiftPattern.assignmentType>\n" else "") +
        "\t\t<cim:ShiftPattern.cycleCount>" + cycleCount + "</cim:ShiftPattern.cycleCount>\n" +
        (if (null != status) "\t\t<cim:ShiftPattern.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != validityInterval) "\t\t<cim:ShiftPattern.validityInterval rdf:resource=\"#" + validityInterval + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ShiftPattern rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ShiftPattern>"
    }
}

object ShiftPattern
extends
    Parseable[ShiftPattern]
{
    val assignmentType = parse_element (element ("""ShiftPattern.assignmentType"""))
    val cycleCount = parse_element (element ("""ShiftPattern.cycleCount"""))
    val status = parse_attribute (attribute ("""ShiftPattern.status"""))
    val validityInterval = parse_attribute (attribute ("""ShiftPattern.validityInterval"""))
    def parse (context: Context): ShiftPattern =
    {
        ShiftPattern(
            WorkIdentifiedObject.parse (context),
            assignmentType (context),
            toInteger (cycleCount (context), context),
            status (context),
            validityInterval (context)
        )
    }
}

/**
 * Documentation for a generic material item that may be used for design, work and other purposes.
 * Any number of MaterialItems manufactured by various vendors may be used to perform this TypeMaterial.
 *
 * @param sup Reference to the superclass object.
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
        sup.export_fields +
        (if (null != costType) "\t\t<cim:TypeMaterial.costType>" + costType + "</cim:TypeMaterial.costType>\n" else "") +
        "\t\t<cim:TypeMaterial.estUnitCost>" + estUnitCost + "</cim:TypeMaterial.estUnitCost>\n" +
        (if (null != quantity) "\t\t<cim:TypeMaterial.quantity>" + quantity + "</cim:TypeMaterial.quantity>\n" else "") +
        "\t\t<cim:TypeMaterial.stockItem>" + stockItem + "</cim:TypeMaterial.stockItem>\n"
    }
    override def export: String =
    {
        "\t<cim:TypeMaterial rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TypeMaterial>"
    }
}

object TypeMaterial
extends
    Parseable[TypeMaterial]
{
    val costType = parse_element (element ("""TypeMaterial.costType"""))
    val estUnitCost = parse_element (element ("""TypeMaterial.estUnitCost"""))
    val quantity = parse_element (element ("""TypeMaterial.quantity"""))
    val stockItem = parse_element (element ("""TypeMaterial.stockItem"""))
    def parse (context: Context): TypeMaterial =
    {
        TypeMaterial(
            WorkDocument.parse (context),
            costType (context),
            toDouble (estUnitCost (context), context),
            quantity (context),
            toBoolean (stockItem (context), context)
        )
    }
}

/**
 * The way material and assets are used to perform a certain type of work task.
 * The way is described in text in the inheritied description attribute.
 *
 * @param sup Reference to the superclass object.
 * @param status <em>undocumented</em>
 * @param WorkTask <em>undocumented</em>
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
        sup.export_fields +
        (if (null != status) "\t\t<cim:Usage.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != WorkTask) "\t\t<cim:Usage.WorkTask rdf:resource=\"#" + WorkTask + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Usage rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Usage>"
    }
}

object Usage
extends
    Parseable[Usage]
{
    val status = parse_attribute (attribute ("""Usage.status"""))
    val WorkTask = parse_attribute (attribute ("""Usage.WorkTask"""))
    def parse (context: Context): Usage =
    {
        Usage(
            WorkIdentifiedObject.parse (context),
            status (context),
            WorkTask (context)
        )
    }
}

/**
 * A collection of all of the individual cost items collected from multiple sources.
 *
 * @param sup Reference to the superclass object.
 * @param amount Amount in designated currency for work, either a total or an individual element.
 *        As defined in the attribute "type," multiple instances are applicable to each work for: planned cost, actual cost, authorized cost, budgeted cost, forecasted cost, other.
 * @param isDebit True if 'amount' is a debit, false if it is a credit.
 * @param transactionDateTime Date and time that 'amount' is posted to the work.
 * @param CostType <em>undocumented</em>
 * @param Design <em>undocumented</em>
 * @param ErpProjectAccounting <em>undocumented</em>
 * @param OverheadCost <em>undocumented</em>
 * @param PropertyUnits <em>undocumented</em>
 * @param WorkCostSummary <em>undocumented</em>
 * @param WorkTask <em>undocumented</em>
 * @param Works <em>undocumented</em>
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
        sup.export_fields +
        "\t\t<cim:WorkCostDetail.amount>" + amount + "</cim:WorkCostDetail.amount>\n" +
        "\t\t<cim:WorkCostDetail.isDebit>" + isDebit + "</cim:WorkCostDetail.isDebit>\n" +
        (if (null != transactionDateTime) "\t\t<cim:WorkCostDetail.transactionDateTime>" + transactionDateTime + "</cim:WorkCostDetail.transactionDateTime>\n" else "") +
        (if (null != CostType) "\t\t<cim:WorkCostDetail.CostType rdf:resource=\"#" + CostType + "\"/>\n" else "") +
        (if (null != Design) "\t\t<cim:WorkCostDetail.Design rdf:resource=\"#" + Design + "\"/>\n" else "") +
        (if (null != ErpProjectAccounting) "\t\t<cim:WorkCostDetail.ErpProjectAccounting rdf:resource=\"#" + ErpProjectAccounting + "\"/>\n" else "") +
        (if (null != OverheadCost) "\t\t<cim:WorkCostDetail.OverheadCost rdf:resource=\"#" + OverheadCost + "\"/>\n" else "") +
        (if (null != PropertyUnits) PropertyUnits.map (x => "\t\t<cim:WorkCostDetail.PropertyUnits rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != WorkCostSummary) "\t\t<cim:WorkCostDetail.WorkCostSummary rdf:resource=\"#" + WorkCostSummary + "\"/>\n" else "") +
        (if (null != WorkTask) "\t\t<cim:WorkCostDetail.WorkTask rdf:resource=\"#" + WorkTask + "\"/>\n" else "") +
        (if (null != Works) Works.map (x => "\t\t<cim:WorkCostDetail.Works rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:WorkCostDetail rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WorkCostDetail>"
    }
}

object WorkCostDetail
extends
    Parseable[WorkCostDetail]
{
    val amount = parse_element (element ("""WorkCostDetail.amount"""))
    val isDebit = parse_element (element ("""WorkCostDetail.isDebit"""))
    val transactionDateTime = parse_element (element ("""WorkCostDetail.transactionDateTime"""))
    val CostType = parse_attribute (attribute ("""WorkCostDetail.CostType"""))
    val Design = parse_attribute (attribute ("""WorkCostDetail.Design"""))
    val ErpProjectAccounting = parse_attribute (attribute ("""WorkCostDetail.ErpProjectAccounting"""))
    val OverheadCost = parse_attribute (attribute ("""WorkCostDetail.OverheadCost"""))
    val PropertyUnits = parse_attributes (attribute ("""WorkCostDetail.PropertyUnits"""))
    val WorkCostSummary = parse_attribute (attribute ("""WorkCostDetail.WorkCostSummary"""))
    val WorkTask = parse_attribute (attribute ("""WorkCostDetail.WorkTask"""))
    val Works = parse_attributes (attribute ("""WorkCostDetail.Works"""))
    def parse (context: Context): WorkCostDetail =
    {
        WorkCostDetail(
            WorkDocument.parse (context),
            toDouble (amount (context), context),
            toBoolean (isDebit (context), context),
            transactionDateTime (context),
            CostType (context),
            Design (context),
            ErpProjectAccounting (context),
            OverheadCost (context),
            PropertyUnits (context),
            WorkCostSummary (context),
            WorkTask (context),
            Works (context)
        )
    }
}

/**
 * A roll up by cost type for the entire cost of a work order.
 * For example, total labor.
 *
 * @param sup Reference to the superclass object.
 * @param WorkCostDetail <em>undocumented</em>
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
        sup.export_fields +
        (if (null != WorkCostDetail) "\t\t<cim:WorkCostSummary.WorkCostDetail rdf:resource=\"#" + WorkCostDetail + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WorkCostSummary rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WorkCostSummary>"
    }
}

object WorkCostSummary
extends
    Parseable[WorkCostSummary]
{
    val WorkCostDetail = parse_attribute (attribute ("""WorkCostSummary.WorkCostDetail"""))
    def parse (context: Context): WorkCostSummary =
    {
        WorkCostSummary(
            WorkDocument.parse (context),
            WorkCostDetail (context)
        )
    }
}

/**
 * Shadow class for Document, to isolate subclassing from this package.
 * If any subclass gets normative and needs inheritance, it will inherit directly from Document.
 *
 * @param sup Reference to the superclass object.
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:WorkDocument rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WorkDocument>"
    }
}

object WorkDocument
extends
    Parseable[WorkDocument]
{
    def parse (context: Context): WorkDocument =
    {
        WorkDocument(
            Document.parse (context)
        )
    }
}

/**
 * A pre-defined set of work steps for a given type of work.
 *
 * @param sup Reference to the superclass object.
 * @param sequenceNumber Used to define dependencies of each work flow step, which is for the instance of WorkTask associated with a given instance of WorkFlow.
 * @param status <em>undocumented</em>
 * @param Work <em>undocumented</em>
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
        sup.export_fields +
        "\t\t<cim:WorkFlowStep.sequenceNumber>" + sequenceNumber + "</cim:WorkFlowStep.sequenceNumber>\n" +
        (if (null != status) "\t\t<cim:WorkFlowStep.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != Work) "\t\t<cim:WorkFlowStep.Work rdf:resource=\"#" + Work + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WorkFlowStep rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WorkFlowStep>"
    }
}

object WorkFlowStep
extends
    Parseable[WorkFlowStep]
{
    val sequenceNumber = parse_element (element ("""WorkFlowStep.sequenceNumber"""))
    val status = parse_attribute (attribute ("""WorkFlowStep.status"""))
    val Work = parse_attribute (attribute ("""WorkFlowStep.Work"""))
    def parse (context: Context): WorkFlowStep =
    {
        WorkFlowStep(
            WorkIdentifiedObject.parse (context),
            toInteger (sequenceNumber (context), context),
            status (context),
            Work (context)
        )
    }
}

/**
 * Shadow class for IdentifiedObject, to isolate subclassing from this package.
 * If any subclass gets normative and needs inheritance, it will inherit directly from IdentifiedObject.
 *
 * @param sup Reference to the superclass object.
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:WorkIdentifiedObject rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WorkIdentifiedObject>"
    }
}

object WorkIdentifiedObject
extends
    Parseable[WorkIdentifiedObject]
{
    def parse (context: Context): WorkIdentifiedObject =
    {
        WorkIdentifiedObject(
            IdentifiedObject.parse (context)
        )
    }
}

/**
 * A type of ActivityRecord that records information about the status of an item, such as a Work or WorkTask, at a point in time.
 *
 * @param sup Reference to the superclass object.
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
        sup.export_fields +
        "\t\t<cim:WorkStatusEntry.percentComplete>" + percentComplete + "</cim:WorkStatusEntry.percentComplete>\n"
    }
    override def export: String =
    {
        "\t<cim:WorkStatusEntry rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WorkStatusEntry>"
    }
}

object WorkStatusEntry
extends
    Parseable[WorkStatusEntry]
{
    val percentComplete = parse_element (element ("""WorkStatusEntry.percentComplete"""))
    def parse (context: Context): WorkStatusEntry =
    {
        WorkStatusEntry(
            ActivityRecord.parse (context),
            toDouble (percentComplete (context), context)
        )
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