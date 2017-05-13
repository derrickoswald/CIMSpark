package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * The package covers all types of work, including inspection, maintenance, repair, restoration, and construction.
 * It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.
 */

/**
 * A permit is sometimes needed to provide legal access to land or equipment.
 * For example, local authority permission for road works.
 * @param sup Reference to the superclass object.
 * @param applicationNumber Permit application number that is used by municipality, state, province, etc.
 * @param effectiveDate Date that permit became official.
 * @param expirationDate Permit expiration date.
 * @param payment Total cost of permit.
 * @param permitID Permit identifier.
 */
case class AccessPermit
(override val sup: WorkDocument,
val applicationNumber: String,
val effectiveDate: String,
val expirationDate: String,
val payment: Double,
val permitID: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, 0.0, null) }
    def WorkDocument: WorkDocument = sup.asInstanceOf[WorkDocument]
    override def copy (): Row = { return (clone ().asInstanceOf[AccessPermit]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AccessPermit
extends
    Parseable[AccessPermit]
{
    val sup = WorkDocument.parse _
    val applicationNumber = parse_element (element ("""AccessPermit.applicationNumber"""))_
    val effectiveDate = parse_element (element ("""AccessPermit.effectiveDate"""))_
    val expirationDate = parse_element (element ("""AccessPermit.expirationDate"""))_
    val payment = parse_element (element ("""AccessPermit.payment"""))_
    val permitID = parse_element (element ("""AccessPermit.permitID"""))_
    def parse (context: Context): AccessPermit =
    {
        AccessPermit(
            sup (context),
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
 * @param sup Reference to the superclass object.
 * @param effectivePeriod Period between the assignment becoming effective and its expiration.
 */
case class Assignment
(override val sup: WorkDocument,
val effectivePeriod: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def WorkDocument: WorkDocument = sup.asInstanceOf[WorkDocument]
    override def copy (): Row = { return (clone ().asInstanceOf[Assignment]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Assignment
extends
    Parseable[Assignment]
{
    val sup = WorkDocument.parse _
    val effectivePeriod = parse_attribute (attribute ("""Assignment.effectivePeriod"""))_
    def parse (context: Context): Assignment =
    {
        Assignment(
            sup (context),
            effectivePeriod (context)
        )
    }
}

/**
 * Business justification for capital expenditures, usually addressing operations and maintenance costs as well.
 * @param sup Reference to the superclass object.
 * @param corporateCode A codified representation of the business case (i.e., codes for highway relocation, replace substation transformers, etc.).
 */
case class BusinessCase
(override val sup: WorkDocument,
val corporateCode: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def WorkDocument: WorkDocument = sup.asInstanceOf[WorkDocument]
    override def copy (): Row = { return (clone ().asInstanceOf[BusinessCase]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BusinessCase
extends
    Parseable[BusinessCase]
{
    val sup = WorkDocument.parse _
    val corporateCode = parse_element (element ("""BusinessCase.corporateCode"""))_
    def parse (context: Context): BusinessCase =
    {
        BusinessCase(
            sup (context),
            corporateCode (context)
        )
    }
}

/**
 * Allowed actions: Install, Remove, Transfer, Abandon, etc.
 * @param sup Reference to the superclass object.
 * @param status
 */
case class CUAllowableAction
(override val sup: WorkIdentifiedObject,
val status: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def WorkIdentifiedObject: WorkIdentifiedObject = sup.asInstanceOf[WorkIdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[CUAllowableAction]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CUAllowableAction
extends
    Parseable[CUAllowableAction]
{
    val sup = WorkIdentifiedObject.parse _
    val status = parse_attribute (attribute ("""CUAllowableAction.status"""))_
    def parse (context: Context): CUAllowableAction =
    {
        CUAllowableAction(
            sup (context),
            status (context)
        )
    }
}

/**
 * Compatible unit for various types of assets such as transformers switches, substation fences, poles, etc..
 * @param sup Reference to the superclass object.
 * @param quantity Quantity of the type asset within the CU.
 * @param status
 * @param typeAssetCode The code for this type of asset.
 * @param TypeAsset
 */
case class CUAsset
(override val sup: WorkIdentifiedObject,
val quantity: String,
val status: String,
val typeAssetCode: String,
val TypeAsset: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def WorkIdentifiedObject: WorkIdentifiedObject = sup.asInstanceOf[WorkIdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[CUAsset]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CUAsset
extends
    Parseable[CUAsset]
{
    val sup = WorkIdentifiedObject.parse _
    val quantity = parse_attribute (attribute ("""CUAsset.quantity"""))_
    val status = parse_attribute (attribute ("""CUAsset.status"""))_
    val typeAssetCode = parse_element (element ("""CUAsset.typeAssetCode"""))_
    val TypeAsset = parse_attribute (attribute ("""CUAsset.TypeAsset"""))_
    def parse (context: Context): CUAsset =
    {
        CUAsset(
            sup (context),
            quantity (context),
            status (context),
            typeAssetCode (context),
            TypeAsset (context)
        )
    }
}

/**
 * Compatible unit contractor item.
 * @param sup Reference to the superclass object.
 * @param activityCode Activity code identifies a specific and distinguishable unit of work.
 * @param bidAmount The amount that a given contractor will charge for performing this unit of work.
 * @param status
 * @param CompatibleUnits
 */
case class CUContractorItem
(override val sup: WorkIdentifiedObject,
val activityCode: String,
val bidAmount: Double,
val status: String,
val CompatibleUnits: List[String]
)
extends
    Element
{
    def this () = { this (null, null, 0.0, null, List()) }
    def WorkIdentifiedObject: WorkIdentifiedObject = sup.asInstanceOf[WorkIdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[CUContractorItem]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CUContractorItem
extends
    Parseable[CUContractorItem]
{
    val sup = WorkIdentifiedObject.parse _
    val activityCode = parse_element (element ("""CUContractorItem.activityCode"""))_
    val bidAmount = parse_element (element ("""CUContractorItem.bidAmount"""))_
    val status = parse_attribute (attribute ("""CUContractorItem.status"""))_
    val CompatibleUnits = parse_attributes (attribute ("""CUContractorItem.CompatibleUnits"""))_
    def parse (context: Context): CUContractorItem =
    {
        CUContractorItem(
            sup (context),
            activityCode (context),
            toDouble (bidAmount (context), context),
            status (context),
            CompatibleUnits (context)
        )
    }
}

/**
 * A Compatible Unit Group identifies a set of compatible units which may be jointly utilized for estimating and designating jobs.
 * @param sup Reference to the superclass object.
 * @param status
 * @param ChildCUGroups
 */
case class CUGroup
(override val sup: WorkIdentifiedObject,
val status: String,
val ChildCUGroups: List[String]
)
extends
    Element
{
    def this () = { this (null, null, List()) }
    def WorkIdentifiedObject: WorkIdentifiedObject = sup.asInstanceOf[WorkIdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[CUGroup]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CUGroup
extends
    Parseable[CUGroup]
{
    val sup = WorkIdentifiedObject.parse _
    val status = parse_attribute (attribute ("""CUGroup.status"""))_
    val ChildCUGroups = parse_attributes (attribute ("""CUGroup.ChildCUGroups"""))_
    def parse (context: Context): CUGroup =
    {
        CUGroup(
            sup (context),
            status (context),
            ChildCUGroups (context)
        )
    }
}

/**
 * Labor code associated with various compatible unit labor items.
 * @param sup Reference to the superclass object.
 * @param code Labor code.
 * @param status
 */
case class CULaborCode
(override val sup: WorkIdentifiedObject,
val code: String,
val status: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def WorkIdentifiedObject: WorkIdentifiedObject = sup.asInstanceOf[WorkIdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[CULaborCode]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CULaborCode
extends
    Parseable[CULaborCode]
{
    val sup = WorkIdentifiedObject.parse _
    val code = parse_element (element ("""CULaborCode.code"""))_
    val status = parse_attribute (attribute ("""CULaborCode.status"""))_
    def parse (context: Context): CULaborCode =
    {
        CULaborCode(
            sup (context),
            code (context),
            status (context)
        )
    }
}

/**
 * Compatible unit labor item.
 * @param sup Reference to the superclass object.
 * @param activityCode Activity code identifies a specific and distinguishable unit of work.
 * @param laborDuration Estimated time to perform work.
 * @param laborRate The labor rate applied for work.
 * @param status
 * @param CULaborCode
 * @param CompatibleUnits
 * @param QualificationRequirements
 */
case class CULaborItem
(override val sup: WorkIdentifiedObject,
val activityCode: String,
val laborDuration: Double,
val laborRate: Double,
val status: String,
val CULaborCode: String,
val CompatibleUnits: List[String],
val QualificationRequirements: List[String]
)
extends
    Element
{
    def this () = { this (null, null, 0.0, 0.0, null, null, List(), List()) }
    def WorkIdentifiedObject: WorkIdentifiedObject = sup.asInstanceOf[WorkIdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[CULaborItem]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CULaborItem
extends
    Parseable[CULaborItem]
{
    val sup = WorkIdentifiedObject.parse _
    val activityCode = parse_element (element ("""CULaborItem.activityCode"""))_
    val laborDuration = parse_element (element ("""CULaborItem.laborDuration"""))_
    val laborRate = parse_element (element ("""CULaborItem.laborRate"""))_
    val status = parse_attribute (attribute ("""CULaborItem.status"""))_
    val CULaborCode = parse_attribute (attribute ("""CULaborItem.CULaborCode"""))_
    val CompatibleUnits = parse_attributes (attribute ("""CULaborItem.CompatibleUnits"""))_
    val QualificationRequirements = parse_attributes (attribute ("""CULaborItem.QualificationRequirements"""))_
    def parse (context: Context): CULaborItem =
    {
        CULaborItem(
            sup (context),
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
 * @param sup Reference to the superclass object.
 * @param corporateCode Code for material.
 * @param quantity Quantity of the TypeMaterial for this CU, used to determine estimated costs based on a per unit cost or a cost per unit length specified in the TypeMaterial.
 * @param status
 * @param CompatibleUnits
 * @param TypeMaterial
 */
case class CUMaterialItem
(override val sup: WorkIdentifiedObject,
val corporateCode: String,
val quantity: String,
val status: String,
val CompatibleUnits: List[String],
val TypeMaterial: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, List(), null) }
    def WorkIdentifiedObject: WorkIdentifiedObject = sup.asInstanceOf[WorkIdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[CUMaterialItem]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CUMaterialItem
extends
    Parseable[CUMaterialItem]
{
    val sup = WorkIdentifiedObject.parse _
    val corporateCode = parse_element (element ("""CUMaterialItem.corporateCode"""))_
    val quantity = parse_attribute (attribute ("""CUMaterialItem.quantity"""))_
    val status = parse_attribute (attribute ("""CUMaterialItem.status"""))_
    val CompatibleUnits = parse_attributes (attribute ("""CUMaterialItem.CompatibleUnits"""))_
    val TypeMaterial = parse_attribute (attribute ("""CUMaterialItem.TypeMaterial"""))_
    def parse (context: Context): CUMaterialItem =
    {
        CUMaterialItem(
            sup (context),
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
 * @param sup Reference to the superclass object.
 * @param equipCode The equipment type code.
 * @param rate Standard usage rate for the type of vehicle.
 * @param status
 * @param CompatibleUnits
 * @param TypeAsset
 */
case class CUWorkEquipmentItem
(override val sup: WorkIdentifiedObject,
val equipCode: String,
val rate: Double,
val status: String,
val CompatibleUnits: List[String],
val TypeAsset: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, null, List(), null) }
    def WorkIdentifiedObject: WorkIdentifiedObject = sup.asInstanceOf[WorkIdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[CUWorkEquipmentItem]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CUWorkEquipmentItem
extends
    Parseable[CUWorkEquipmentItem]
{
    val sup = WorkIdentifiedObject.parse _
    val equipCode = parse_element (element ("""CUWorkEquipmentItem.equipCode"""))_
    val rate = parse_element (element ("""CUWorkEquipmentItem.rate"""))_
    val status = parse_attribute (attribute ("""CUWorkEquipmentItem.status"""))_
    val CompatibleUnits = parse_attributes (attribute ("""CUWorkEquipmentItem.CompatibleUnits"""))_
    val TypeAsset = parse_attribute (attribute ("""CUWorkEquipmentItem.TypeAsset"""))_
    def parse (context: Context): CUWorkEquipmentItem =
    {
        CUWorkEquipmentItem(
            sup (context),
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
 * @param sup Reference to the superclass object.
 * @param performanceFactor Capability performance factor.
 * @param status
 * @param typ Classification by utility's work management standards and practices.
 * @param validityInterval Date and time interval for which this capability is valid (when it became effective and when it expires).
 * @param Crafts
 * @param Crew
 * @param WorkTasks
 */
case class Capability
(override val sup: WorkIdentifiedObject,
val performanceFactor: String,
val status: String,
val typ: String,
val validityInterval: String,
val Crafts: List[String],
val Crew: String,
val WorkTasks: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, List(), null, List()) }
    def WorkIdentifiedObject: WorkIdentifiedObject = sup.asInstanceOf[WorkIdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Capability]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Capability
extends
    Parseable[Capability]
{
    val sup = WorkIdentifiedObject.parse _
    val performanceFactor = parse_element (element ("""Capability.performanceFactor"""))_
    val status = parse_attribute (attribute ("""Capability.status"""))_
    val typ = parse_element (element ("""Capability.type"""))_
    val validityInterval = parse_attribute (attribute ("""Capability.validityInterval"""))_
    val Crafts = parse_attributes (attribute ("""Capability.Crafts"""))_
    val Crew = parse_attribute (attribute ("""Capability.Crew"""))_
    val WorkTasks = parse_attributes (attribute ("""Capability.WorkTasks"""))_
    def parse (context: Context): Capability =
    {
        Capability(
            sup (context),
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
 * @param sup Reference to the superclass object.
 * @param estCost Estimated total cost for perfoming CU.
 * @param quantity The quantity, unit of measure, and multiplier at the CU level that applies to the materials.
 * @param CUAllowableAction
 * @param CUAssets
 * @param CUGroup
 * @param CostType
 * @param DesignLocationCUs
 * @param Procedures
 * @param PropertyUnit
 */
case class CompatibleUnit
(override val sup: WorkDocument,
val estCost: Double,
val quantity: String,
val CUAllowableAction: String,
val CUAssets: List[String],
val CUGroup: String,
val CostType: String,
val DesignLocationCUs: List[String],
val Procedures: List[String],
val PropertyUnit: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null, List(), null, null, List(), List(), null) }
    def WorkDocument: WorkDocument = sup.asInstanceOf[WorkDocument]
    override def copy (): Row = { return (clone ().asInstanceOf[CompatibleUnit]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CompatibleUnit
extends
    Parseable[CompatibleUnit]
{
    val sup = WorkDocument.parse _
    val estCost = parse_element (element ("""CompatibleUnit.estCost"""))_
    val quantity = parse_element (element ("""CompatibleUnit.quantity"""))_
    val CUAllowableAction = parse_attribute (attribute ("""CompatibleUnit.CUAllowableAction"""))_
    val CUAssets = parse_attributes (attribute ("""CompatibleUnit.CUAssets"""))_
    val CUGroup = parse_attribute (attribute ("""CompatibleUnit.CUGroup"""))_
    val CostType = parse_attribute (attribute ("""CompatibleUnit.CostType"""))_
    val DesignLocationCUs = parse_attributes (attribute ("""CompatibleUnit.DesignLocationCUs"""))_
    val Procedures = parse_attributes (attribute ("""CompatibleUnit.Procedures"""))_
    val PropertyUnit = parse_attribute (attribute ("""CompatibleUnit.PropertyUnit"""))_
    def parse (context: Context): CompatibleUnit =
    {
        CompatibleUnit(
            sup (context),
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
 * @param sup Reference to the superclass object.
 * @param cfValue The actual value of the condition factor, such as labor flat fee or percentage.
 * @param kind Kind of this condition factor.
 * @param status
 */
case class ConditionFactor
(override val sup: WorkIdentifiedObject,
val cfValue: String,
val kind: String,
val status: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def WorkIdentifiedObject: WorkIdentifiedObject = sup.asInstanceOf[WorkIdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ConditionFactor]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ConditionFactor
extends
    Parseable[ConditionFactor]
{
    val sup = WorkIdentifiedObject.parse _
    val cfValue = parse_element (element ("""ConditionFactor.cfValue"""))_
    val kind = parse_attribute (attribute ("""ConditionFactor.kind"""))_
    val status = parse_attribute (attribute ("""ConditionFactor.status"""))_
    def parse (context: Context): ConditionFactor =
    {
        ConditionFactor(
            sup (context),
            cfValue (context),
            kind (context),
            status (context)
        )
    }
}

/**
 * Kind of condition factor.
 * @param sup Reference to the superclass object.
 * @param accountAllocation
 * @param labor
 * @param material
 * @param other
 * @param travel
 */
case class ConditionFactorKind
(override val sup: BasicElement,
val accountAllocation: String,
val labor: String,
val material: String,
val other: String,
val travel: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ConditionFactorKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ConditionFactorKind
extends
    Parseable[ConditionFactorKind]
{
    val sup = BasicElement.parse _
    val accountAllocation = parse_attribute (attribute ("""ConditionFactorKind.accountAllocation"""))_
    val labor = parse_attribute (attribute ("""ConditionFactorKind.labor"""))_
    val material = parse_attribute (attribute ("""ConditionFactorKind.material"""))_
    val other = parse_attribute (attribute ("""ConditionFactorKind.other"""))_
    val travel = parse_attribute (attribute ("""ConditionFactorKind.travel"""))_
    def parse (context: Context): ConditionFactorKind =
    {
        ConditionFactorKind(
            sup (context),
            accountAllocation (context),
            labor (context),
            material (context),
            other (context),
            travel (context)
        )
    }
}

/**
 * Contractor information for work task.
 * @param sup Reference to the superclass object.
 * @param activityCode Activity code identifies a specific and distinguishable unit of work.
 * @param bidAmount The amount that a given contractor will charge for performing this unit of work.
 * @param cost The total amount charged.
 * @param status
 * @param ErpPayables
 * @param WorkCostDetail
 * @param WorkTask
 */
case class ContractorItem
(override val sup: WorkIdentifiedObject,
val activityCode: String,
val bidAmount: Double,
val cost: Double,
val status: String,
val ErpPayables: List[String],
val WorkCostDetail: String,
val WorkTask: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, 0.0, null, List(), null, null) }
    def WorkIdentifiedObject: WorkIdentifiedObject = sup.asInstanceOf[WorkIdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ContractorItem]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ContractorItem
extends
    Parseable[ContractorItem]
{
    val sup = WorkIdentifiedObject.parse _
    val activityCode = parse_element (element ("""ContractorItem.activityCode"""))_
    val bidAmount = parse_element (element ("""ContractorItem.bidAmount"""))_
    val cost = parse_element (element ("""ContractorItem.cost"""))_
    val status = parse_attribute (attribute ("""ContractorItem.status"""))_
    val ErpPayables = parse_attributes (attribute ("""ContractorItem.ErpPayables"""))_
    val WorkCostDetail = parse_attribute (attribute ("""ContractorItem.WorkCostDetail"""))_
    val WorkTask = parse_attribute (attribute ("""ContractorItem.WorkTask"""))_
    def parse (context: Context): ContractorItem =
    {
        ContractorItem(
            sup (context),
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
 * @param sup Reference to the superclass object.
 * @param amountAssignable True if an amount can be assigned to the resource element (e.g., building in service, transmission plant, software development capital); false otherwise (e.g., internal labor, material components).
 * @param code A codified representation of the resource element.
 * @param level The level of the resource element in the hierarchy of resource elements (recursive relationship).
 * @param stage The stage for which this costType applies: estimated design, estimated actual or actual actual.
 * @param status
 * @param ErpJournalEntries
 * @param ParentCostType
 */
case class CostType
(override val sup: WorkIdentifiedObject,
val amountAssignable: Boolean,
val code: String,
val level: String,
val stage: String,
val status: String,
val ErpJournalEntries: List[String],
val ParentCostType: String
)
extends
    Element
{
    def this () = { this (null, false, null, null, null, null, List(), null) }
    def WorkIdentifiedObject: WorkIdentifiedObject = sup.asInstanceOf[WorkIdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[CostType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CostType
extends
    Parseable[CostType]
{
    val sup = WorkIdentifiedObject.parse _
    val amountAssignable = parse_element (element ("""CostType.amountAssignable"""))_
    val code = parse_element (element ("""CostType.code"""))_
    val level = parse_element (element ("""CostType.level"""))_
    val stage = parse_element (element ("""CostType.stage"""))_
    val status = parse_attribute (attribute ("""CostType.status"""))_
    val ErpJournalEntries = parse_attributes (attribute ("""CostType.ErpJournalEntries"""))_
    val ParentCostType = parse_attribute (attribute ("""CostType.ParentCostType"""))_
    def parse (context: Context): CostType =
    {
        CostType(
            sup (context),
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
 * @param sup Reference to the superclass object.
 * @param costEstimate Estimated cost (not price) of design.
 * @param kind Kind of this design.
 * @param price Price to customer for implementing design.
 * @param ConditionFactors
 * @param ErpQuoteLineItem
 * @param Work
 */
case class Design
(override val sup: WorkDocument,
val costEstimate: Double,
val kind: String,
val price: Double,
val ConditionFactors: List[String],
val ErpQuoteLineItem: String,
val Work: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, 0.0, List(), null, null) }
    def WorkDocument: WorkDocument = sup.asInstanceOf[WorkDocument]
    override def copy (): Row = { return (clone ().asInstanceOf[Design]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Design
extends
    Parseable[Design]
{
    val sup = WorkDocument.parse _
    val costEstimate = parse_element (element ("""Design.costEstimate"""))_
    val kind = parse_attribute (attribute ("""Design.kind"""))_
    val price = parse_element (element ("""Design.price"""))_
    val ConditionFactors = parse_attributes (attribute ("""Design.ConditionFactors"""))_
    val ErpQuoteLineItem = parse_attribute (attribute ("""Design.ErpQuoteLineItem"""))_
    val Work = parse_attribute (attribute ("""Design.Work"""))_
    def parse (context: Context): Design =
    {
        Design(
            sup (context),
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
 * Kind of design.
 * @param sup Reference to the superclass object.
 * @param asBuilt
 * @param estimated
 * @param other
 */
case class DesignKind
(override val sup: BasicElement,
val asBuilt: String,
val estimated: String,
val other: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[DesignKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DesignKind
extends
    Parseable[DesignKind]
{
    val sup = BasicElement.parse _
    val asBuilt = parse_attribute (attribute ("""DesignKind.asBuilt"""))_
    val estimated = parse_attribute (attribute ("""DesignKind.estimated"""))_
    val other = parse_attribute (attribute ("""DesignKind.other"""))_
    def parse (context: Context): DesignKind =
    {
        DesignKind(
            sup (context),
            asBuilt (context),
            estimated (context),
            other (context)
        )
    }
}

/**
 * A logical part of the design (e.g., pole and all equipment on a pole).
 * This includes points and spans.
 * @param sup Reference to the superclass object.
 * @param spanLength The legth of the span from the previous pole to this pole.
 * @param status
 * @param ConditionFactors
 */
case class DesignLocation
(override val sup: WorkIdentifiedObject,
val spanLength: Double,
val status: String,
val ConditionFactors: List[String]
)
extends
    Element
{
    def this () = { this (null, 0.0, null, List()) }
    def WorkIdentifiedObject: WorkIdentifiedObject = sup.asInstanceOf[WorkIdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[DesignLocation]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DesignLocation
extends
    Parseable[DesignLocation]
{
    val sup = WorkIdentifiedObject.parse _
    val spanLength = parse_element (element ("""DesignLocation.spanLength"""))_
    val status = parse_attribute (attribute ("""DesignLocation.status"""))_
    val ConditionFactors = parse_attributes (attribute ("""DesignLocation.ConditionFactors"""))_
    def parse (context: Context): DesignLocation =
    {
        DesignLocation(
            sup (context),
            toDouble (spanLength (context), context),
            status (context),
            ConditionFactors (context)
        )
    }
}

/**
 * Compatible unit at a given design location.
 * @param sup Reference to the superclass object.
 * @param cuAccount A code that helps direct accounting (capital, expense, or accounting treatment).
 * @param cuAction A code that instructs the crew what action to perform.
 * @param cuQuantity The quantity of the CU being assigned to this location.
 * @param cuUsage As the same CU can be used for different purposes and accounting purposes, usage must be specified.
 *        Examples include: distribution, transmission, substation.
 * @param removalDate Year when a CU that represents an asset is removed.
 * @param status
 * @param toBeEnergised True if associated electrical equipment is intended to be energized while work is being performed.
 * @param CUGroups
 * @param ConditionFactors
 * @param DesignLocation
 * @param Designs
 * @param WorkTasks
 */
case class DesignLocationCU
(override val sup: WorkIdentifiedObject,
val cuAccount: String,
val cuAction: String,
val cuQuantity: String,
val cuUsage: String,
val removalDate: String,
val status: String,
val toBeEnergised: Boolean,
val CUGroups: List[String],
val ConditionFactors: List[String],
val DesignLocation: String,
val Designs: List[String],
val WorkTasks: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, false, List(), List(), null, List(), List()) }
    def WorkIdentifiedObject: WorkIdentifiedObject = sup.asInstanceOf[WorkIdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[DesignLocationCU]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DesignLocationCU
extends
    Parseable[DesignLocationCU]
{
    val sup = WorkIdentifiedObject.parse _
    val cuAccount = parse_element (element ("""DesignLocationCU.cuAccount"""))_
    val cuAction = parse_attribute (attribute ("""DesignLocationCU.cuAction"""))_
    val cuQuantity = parse_attribute (attribute ("""DesignLocationCU.cuQuantity"""))_
    val cuUsage = parse_element (element ("""DesignLocationCU.cuUsage"""))_
    val removalDate = parse_element (element ("""DesignLocationCU.removalDate"""))_
    val status = parse_attribute (attribute ("""DesignLocationCU.status"""))_
    val toBeEnergised = parse_element (element ("""DesignLocationCU.toBeEnergised"""))_
    val CUGroups = parse_attributes (attribute ("""DesignLocationCU.CUGroups"""))_
    val ConditionFactors = parse_attributes (attribute ("""DesignLocationCU.ConditionFactors"""))_
    val DesignLocation = parse_attribute (attribute ("""DesignLocationCU.DesignLocation"""))_
    val Designs = parse_attributes (attribute ("""DesignLocationCU.Designs"""))_
    val WorkTasks = parse_attributes (attribute ("""DesignLocationCU.WorkTasks"""))_
    def parse (context: Context): DesignLocationCU =
    {
        DesignLocationCU(
            sup (context),
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
 * @param sup Reference to the superclass object.
 * @param answer Answer to question.
 * @param answerDateTime The date and time the quesiton was answered.
 * @param answerRemark Remarks to qualify the answer.
 * @param questionCode The question code.
 *        If blank, refer to questionText.
 * @param questionRemark Remarks to qualify the question in this situation.
 * @param questionText For non-coded questions, the question is provided here.
 * @param questionType The type of the question.
 */
case class InfoQuestion
(override val sup: WorkDocument,
val answer: String,
val answerDateTime: String,
val answerRemark: String,
val questionCode: String,
val questionRemark: String,
val questionText: String,
val questionType: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null) }
    def WorkDocument: WorkDocument = sup.asInstanceOf[WorkDocument]
    override def copy (): Row = { return (clone ().asInstanceOf[InfoQuestion]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object InfoQuestion
extends
    Parseable[InfoQuestion]
{
    val sup = WorkDocument.parse _
    val answer = parse_element (element ("""InfoQuestion.answer"""))_
    val answerDateTime = parse_element (element ("""InfoQuestion.answerDateTime"""))_
    val answerRemark = parse_element (element ("""InfoQuestion.answerRemark"""))_
    val questionCode = parse_element (element ("""InfoQuestion.questionCode"""))_
    val questionRemark = parse_element (element ("""InfoQuestion.questionRemark"""))_
    val questionText = parse_element (element ("""InfoQuestion.questionText"""))_
    val questionType = parse_element (element ("""InfoQuestion.questionType"""))_
    def parse (context: Context): InfoQuestion =
    {
        InfoQuestion(
            sup (context),
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
 * @param sup Reference to the superclass object.
 * @param activityCode Activity code identifies a specific and distinguishable unit of work.
 * @param cost Total cost for labor.
 *        Note that this may not be able to be derived from labor rate and time charged.
 * @param laborDuration Time required to perform work.
 * @param laborRate The labor rate applied for work.
 * @param status
 * @param WorkCostDetail
 * @param WorkTask
 */
case class LaborItem
(override val sup: WorkIdentifiedObject,
val activityCode: String,
val cost: Double,
val laborDuration: Double,
val laborRate: Double,
val status: String,
val WorkCostDetail: String,
val WorkTask: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, 0.0, 0.0, null, null, null) }
    def WorkIdentifiedObject: WorkIdentifiedObject = sup.asInstanceOf[WorkIdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[LaborItem]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object LaborItem
extends
    Parseable[LaborItem]
{
    val sup = WorkIdentifiedObject.parse _
    val activityCode = parse_element (element ("""LaborItem.activityCode"""))_
    val cost = parse_element (element ("""LaborItem.cost"""))_
    val laborDuration = parse_element (element ("""LaborItem.laborDuration"""))_
    val laborRate = parse_element (element ("""LaborItem.laborRate"""))_
    val status = parse_attribute (attribute ("""LaborItem.status"""))_
    val WorkCostDetail = parse_attribute (attribute ("""LaborItem.WorkCostDetail"""))_
    val WorkTask = parse_attribute (attribute ("""LaborItem.WorkTask"""))_
    def parse (context: Context): LaborItem =
    {
        LaborItem(
            sup (context),
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
 * @param sup Reference to the superclass object.
 * @param account This drives the accounting treatment for this misc. item.
 * @param costPerUnit The cost per unit for this misc. item.
 * @param costType The cost type for accounting, such as material, labor, vehicle, contractor, equipment, overhead.
 * @param externalRefID External reference identifier (e.g. purchase order number, serial number) .
 * @param quantity The quantity of the misc. item being assigned to this location.
 * @param status
 * @param DesignLocation
 * @param WorkCostDetail
 * @param WorkTask
 */
case class MiscCostItem
(override val sup: WorkIdentifiedObject,
val account: String,
val costPerUnit: Double,
val costType: String,
val externalRefID: String,
val quantity: String,
val status: String,
val DesignLocation: String,
val WorkCostDetail: String,
val WorkTask: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, null, null, null, null, null, null, null) }
    def WorkIdentifiedObject: WorkIdentifiedObject = sup.asInstanceOf[WorkIdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[MiscCostItem]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MiscCostItem
extends
    Parseable[MiscCostItem]
{
    val sup = WorkIdentifiedObject.parse _
    val account = parse_element (element ("""MiscCostItem.account"""))_
    val costPerUnit = parse_element (element ("""MiscCostItem.costPerUnit"""))_
    val costType = parse_element (element ("""MiscCostItem.costType"""))_
    val externalRefID = parse_element (element ("""MiscCostItem.externalRefID"""))_
    val quantity = parse_attribute (attribute ("""MiscCostItem.quantity"""))_
    val status = parse_attribute (attribute ("""MiscCostItem.status"""))_
    val DesignLocation = parse_attribute (attribute ("""MiscCostItem.DesignLocation"""))_
    val WorkCostDetail = parse_attribute (attribute ("""MiscCostItem.WorkCostDetail"""))_
    val WorkTask = parse_attribute (attribute ("""MiscCostItem.WorkTask"""))_
    def parse (context: Context): MiscCostItem =
    {
        MiscCostItem(
            sup (context),
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
 * @param sup Reference to the superclass object.
 * @param amount The projected cost for this item.
 */
case class NonStandardItem
(override val sup: WorkDocument,
val amount: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
    def WorkDocument: WorkDocument = sup.asInstanceOf[WorkDocument]
    override def copy (): Row = { return (clone ().asInstanceOf[NonStandardItem]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object NonStandardItem
extends
    Parseable[NonStandardItem]
{
    val sup = WorkDocument.parse _
    val amount = parse_element (element ("""NonStandardItem.amount"""))_
    def parse (context: Context): NonStandardItem =
    {
        NonStandardItem(
            sup (context),
            toDouble (amount (context), context)
        )
    }
}

/**
 * A set of tasks is required to implement a design.
 * @param sup Reference to the superclass object.
 * @param Design
 * @param OverheadCost
 * @param QualificationRequirements
 * @param WorkFlowStep
 */
case class OldWorkTask
(override val sup: WorkTask,
val Design: String,
val OverheadCost: String,
val QualificationRequirements: List[String],
val WorkFlowStep: String
)
extends
    Element
{
    def this () = { this (null, null, null, List(), null) }
    def WorkTask: WorkTask = sup.asInstanceOf[WorkTask]
    override def copy (): Row = { return (clone ().asInstanceOf[OldWorkTask]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OldWorkTask
extends
    Parseable[OldWorkTask]
{
    val sup = WorkTask.parse _
    val Design = parse_attribute (attribute ("""OldWorkTask.Design"""))_
    val OverheadCost = parse_attribute (attribute ("""OldWorkTask.OverheadCost"""))_
    val QualificationRequirements = parse_attributes (attribute ("""OldWorkTask.QualificationRequirements"""))_
    val WorkFlowStep = parse_attribute (attribute ("""OldWorkTask.WorkFlowStep"""))_
    def parse (context: Context): OldWorkTask =
    {
        OldWorkTask(
            sup (context),
            Design (context),
            OverheadCost (context),
            QualificationRequirements (context),
            WorkFlowStep (context)
        )
    }
}

/**
 * A request for other utilities to mark their underground facilities prior to commencement of construction and/or maintenance.
 * @param sup Reference to the superclass object.
 * @param explosivesUsed True if explosives have been or are planned to be used.
 * @param markedIndicator True if work location has been marked, for example for a dig area.
 * @param markingInstruction Instructions for marking a dig area, if applicable.
 */
case class OneCallRequest
(override val sup: WorkDocument,
val explosivesUsed: Boolean,
val markedIndicator: Boolean,
val markingInstruction: String
)
extends
    Element
{
    def this () = { this (null, false, false, null) }
    def WorkDocument: WorkDocument = sup.asInstanceOf[WorkDocument]
    override def copy (): Row = { return (clone ().asInstanceOf[OneCallRequest]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OneCallRequest
extends
    Parseable[OneCallRequest]
{
    val sup = WorkDocument.parse _
    val explosivesUsed = parse_element (element ("""OneCallRequest.explosivesUsed"""))_
    val markedIndicator = parse_element (element ("""OneCallRequest.markedIndicator"""))_
    val markingInstruction = parse_element (element ("""OneCallRequest.markingInstruction"""))_
    def parse (context: Context): OneCallRequest =
    {
        OneCallRequest(
            sup (context),
            toBoolean (explosivesUsed (context), context),
            toBoolean (markedIndicator (context), context),
            markingInstruction (context)
        )
    }
}

/**
 * Overhead cost applied to work order.
 * @param sup Reference to the superclass object.
 * @param code Overhead code.
 * @param cost The overhead cost to be applied.
 * @param status
 */
case class OverheadCost
(override val sup: WorkIdentifiedObject,
val code: String,
val cost: Double,
val status: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, null) }
    def WorkIdentifiedObject: WorkIdentifiedObject = sup.asInstanceOf[WorkIdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[OverheadCost]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OverheadCost
extends
    Parseable[OverheadCost]
{
    val sup = WorkIdentifiedObject.parse _
    val code = parse_element (element ("""OverheadCost.code"""))_
    val cost = parse_element (element ("""OverheadCost.cost"""))_
    val status = parse_attribute (attribute ("""OverheadCost.status"""))_
    def parse (context: Context): OverheadCost =
    {
        OverheadCost(
            sup (context),
            code (context),
            toDouble (cost (context), context),
            status (context)
        )
    }
}

/**
 * A collection of related work.
 * For construction projects and maintenance projects, multiple phases may be performed.
 * @param sup Reference to the superclass object.
 * @param budget Overall project budget.
 * @param BusinessCase
 * @param ErpProjectAccounting
 * @param ParentProject
 */
case class Project
(override val sup: WorkDocument,
val budget: Double,
val BusinessCase: String,
val ErpProjectAccounting: String,
val ParentProject: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null, null) }
    def WorkDocument: WorkDocument = sup.asInstanceOf[WorkDocument]
    override def copy (): Row = { return (clone ().asInstanceOf[Project]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Project
extends
    Parseable[Project]
{
    val sup = WorkDocument.parse _
    val budget = parse_element (element ("""Project.budget"""))_
    val BusinessCase = parse_attribute (attribute ("""Project.BusinessCase"""))_
    val ErpProjectAccounting = parse_attribute (attribute ("""Project.ErpProjectAccounting"""))_
    val ParentProject = parse_attribute (attribute ("""Project.ParentProject"""))_
    def parse (context: Context): Project =
    {
        Project(
            sup (context),
            toDouble (budget (context), context),
            BusinessCase (context),
            ErpProjectAccounting (context),
            ParentProject (context)
        )
    }
}

/**
 * Unit of property for reporting purposes.
 * @param sup Reference to the superclass object.
 * @param accountingUsage A code that identifies appropriate type of property accounts such as distribution, streetlgihts, communications.
 * @param activityCode Activity code identifies a specific and distinguishable work action.
 * @param propertyAccount Used for property record accounting.
 *        For example, in the USA, this would be a FERC account.
 * @param status
 * @param CUMaterialItems
 */
case class PropertyUnit
(override val sup: WorkIdentifiedObject,
val accountingUsage: String,
val activityCode: String,
val propertyAccount: String,
val status: String,
val CUMaterialItems: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, List()) }
    def WorkIdentifiedObject: WorkIdentifiedObject = sup.asInstanceOf[WorkIdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[PropertyUnit]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PropertyUnit
extends
    Parseable[PropertyUnit]
{
    val sup = WorkIdentifiedObject.parse _
    val accountingUsage = parse_element (element ("""PropertyUnit.accountingUsage"""))_
    val activityCode = parse_attribute (attribute ("""PropertyUnit.activityCode"""))_
    val propertyAccount = parse_element (element ("""PropertyUnit.propertyAccount"""))_
    val status = parse_attribute (attribute ("""PropertyUnit.status"""))_
    val CUMaterialItems = parse_attributes (attribute ("""PropertyUnit.CUMaterialItems"""))_
    def parse (context: Context): PropertyUnit =
    {
        PropertyUnit(
            sup (context),
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
 * @param sup Reference to the superclass object.
 * @param qualificationID Qualification identifier.
 * @param Specifications
 */
case class QualificationRequirement
(override val sup: WorkIdentifiedObject,
val qualificationID: String,
val Specifications: List[String]
)
extends
    Element
{
    def this () = { this (null, null, List()) }
    def WorkIdentifiedObject: WorkIdentifiedObject = sup.asInstanceOf[WorkIdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[QualificationRequirement]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object QualificationRequirement
extends
    Parseable[QualificationRequirement]
{
    val sup = WorkIdentifiedObject.parse _
    val qualificationID = parse_element (element ("""QualificationRequirement.qualificationID"""))_
    val Specifications = parse_attributes (attribute ("""QualificationRequirement.Specifications"""))_
    def parse (context: Context): QualificationRequirement =
    {
        QualificationRequirement(
            sup (context),
            qualificationID (context),
            Specifications (context)
        )
    }
}

/**
 * Special requirements and/or regulations may pertain to certain types of assets or work.
 * For example, fire protection and scaffolding.
 * @param sup Reference to the superclass object.
 * @param referenceNumber External reference to regulation, if applicable.
 */
case class Regulation
(override val sup: WorkDocument,
val referenceNumber: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def WorkDocument: WorkDocument = sup.asInstanceOf[WorkDocument]
    override def copy (): Row = { return (clone ().asInstanceOf[Regulation]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Regulation
extends
    Parseable[Regulation]
{
    val sup = WorkDocument.parse _
    val referenceNumber = parse_element (element ("""Regulation.referenceNumber"""))_
    def parse (context: Context): Regulation =
    {
        Regulation(
            sup (context),
            referenceNumber (context)
        )
    }
}

/**
 * The patterns of shifts worked by people or crews.
 * @param sup Reference to the superclass object.
 * @param assignmentType Type of assignement intended to be worked on this shift, for example, temporary, standard, etc.
 * @param cycleCount Number of cycles for a temporary shift.
 * @param status
 * @param validityInterval Date and time interval for which this shift pattern is valid (when it became effective and when it expires).
 */
case class ShiftPattern
(override val sup: WorkIdentifiedObject,
val assignmentType: String,
val cycleCount: Int,
val status: String,
val validityInterval: String
)
extends
    Element
{
    def this () = { this (null, null, 0, null, null) }
    def WorkIdentifiedObject: WorkIdentifiedObject = sup.asInstanceOf[WorkIdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ShiftPattern]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ShiftPattern
extends
    Parseable[ShiftPattern]
{
    val sup = WorkIdentifiedObject.parse _
    val assignmentType = parse_element (element ("""ShiftPattern.assignmentType"""))_
    val cycleCount = parse_element (element ("""ShiftPattern.cycleCount"""))_
    val status = parse_attribute (attribute ("""ShiftPattern.status"""))_
    val validityInterval = parse_attribute (attribute ("""ShiftPattern.validityInterval"""))_
    def parse (context: Context): ShiftPattern =
    {
        ShiftPattern(
            sup (context),
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
 * @param sup Reference to the superclass object.
 * @param costType The type of cost to which this Material Item belongs.
 * @param estUnitCost The estimated unit cost of this type of material, either for a unit cost or cost per unit length.
 *        Cost is for material or asset only and does not include labor to install/construct or configure it.
 * @param quantity The value, unit of measure, and multiplier for the quantity.
 * @param stockItem True if item is a stock item (default).
 */
case class TypeMaterial
(override val sup: WorkDocument,
val costType: String,
val estUnitCost: Double,
val quantity: String,
val stockItem: Boolean
)
extends
    Element
{
    def this () = { this (null, null, 0.0, null, false) }
    def WorkDocument: WorkDocument = sup.asInstanceOf[WorkDocument]
    override def copy (): Row = { return (clone ().asInstanceOf[TypeMaterial]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TypeMaterial
extends
    Parseable[TypeMaterial]
{
    val sup = WorkDocument.parse _
    val costType = parse_element (element ("""TypeMaterial.costType"""))_
    val estUnitCost = parse_element (element ("""TypeMaterial.estUnitCost"""))_
    val quantity = parse_element (element ("""TypeMaterial.quantity"""))_
    val stockItem = parse_element (element ("""TypeMaterial.stockItem"""))_
    def parse (context: Context): TypeMaterial =
    {
        TypeMaterial(
            sup (context),
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
 * @param sup Reference to the superclass object.
 * @param status
 * @param WorkTask
 */
case class Usage
(override val sup: WorkIdentifiedObject,
val status: String,
val WorkTask: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def WorkIdentifiedObject: WorkIdentifiedObject = sup.asInstanceOf[WorkIdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Usage]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Usage
extends
    Parseable[Usage]
{
    val sup = WorkIdentifiedObject.parse _
    val status = parse_attribute (attribute ("""Usage.status"""))_
    val WorkTask = parse_attribute (attribute ("""Usage.WorkTask"""))_
    def parse (context: Context): Usage =
    {
        Usage(
            sup (context),
            status (context),
            WorkTask (context)
        )
    }
}

/**
 * Kinds of activities to be performed on a Compatible Unit.
 * @param sup Reference to the superclass object.
 * @param abandon Leave it in place but not use it.
 * @param install Install.
 * @param remove Remove.
 * @param transfer Remove from one and install at another loctation.
 */
case class WorkActionKind
(override val sup: BasicElement,
val abandon: String,
val install: String,
val remove: String,
val transfer: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[WorkActionKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WorkActionKind
extends
    Parseable[WorkActionKind]
{
    val sup = BasicElement.parse _
    val abandon = parse_attribute (attribute ("""WorkActionKind.abandon"""))_
    val install = parse_attribute (attribute ("""WorkActionKind.install"""))_
    val remove = parse_attribute (attribute ("""WorkActionKind.remove"""))_
    val transfer = parse_attribute (attribute ("""WorkActionKind.transfer"""))_
    def parse (context: Context): WorkActionKind =
    {
        WorkActionKind(
            sup (context),
            abandon (context),
            install (context),
            remove (context),
            transfer (context)
        )
    }
}

/**
 * A collection of all of the individual cost items collected from multiple sources.
 * @param sup Reference to the superclass object.
 * @param amount Amount in designated currency for work, either a total or an individual element.
 *        As defined in the attribute "type," multiple instances are applicable to each work for: planned cost, actual cost, authorized cost, budgeted cost, forecasted cost, other.
 * @param isDebit True if 'amount' is a debit, false if it is a credit.
 * @param transactionDateTime Date and time that 'amount' is posted to the work.
 * @param CostType
 * @param Design
 * @param ErpProjectAccounting
 * @param OverheadCost
 * @param PropertyUnits
 * @param WorkCostSummary
 * @param WorkTask
 * @param Works
 */
case class WorkCostDetail
(override val sup: WorkDocument,
val amount: Double,
val isDebit: Boolean,
val transactionDateTime: String,
val CostType: String,
val Design: String,
val ErpProjectAccounting: String,
val OverheadCost: String,
val PropertyUnits: List[String],
val WorkCostSummary: String,
val WorkTask: String,
val Works: List[String]
)
extends
    Element
{
    def this () = { this (null, 0.0, false, null, null, null, null, null, List(), null, null, List()) }
    def WorkDocument: WorkDocument = sup.asInstanceOf[WorkDocument]
    override def copy (): Row = { return (clone ().asInstanceOf[WorkCostDetail]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WorkCostDetail
extends
    Parseable[WorkCostDetail]
{
    val sup = WorkDocument.parse _
    val amount = parse_element (element ("""WorkCostDetail.amount"""))_
    val isDebit = parse_element (element ("""WorkCostDetail.isDebit"""))_
    val transactionDateTime = parse_element (element ("""WorkCostDetail.transactionDateTime"""))_
    val CostType = parse_attribute (attribute ("""WorkCostDetail.CostType"""))_
    val Design = parse_attribute (attribute ("""WorkCostDetail.Design"""))_
    val ErpProjectAccounting = parse_attribute (attribute ("""WorkCostDetail.ErpProjectAccounting"""))_
    val OverheadCost = parse_attribute (attribute ("""WorkCostDetail.OverheadCost"""))_
    val PropertyUnits = parse_attributes (attribute ("""WorkCostDetail.PropertyUnits"""))_
    val WorkCostSummary = parse_attribute (attribute ("""WorkCostDetail.WorkCostSummary"""))_
    val WorkTask = parse_attribute (attribute ("""WorkCostDetail.WorkTask"""))_
    val Works = parse_attributes (attribute ("""WorkCostDetail.Works"""))_
    def parse (context: Context): WorkCostDetail =
    {
        WorkCostDetail(
            sup (context),
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
 * @param sup Reference to the superclass object.
 * @param WorkCostDetail
 */
case class WorkCostSummary
(override val sup: WorkDocument,
val WorkCostDetail: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def WorkDocument: WorkDocument = sup.asInstanceOf[WorkDocument]
    override def copy (): Row = { return (clone ().asInstanceOf[WorkCostSummary]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WorkCostSummary
extends
    Parseable[WorkCostSummary]
{
    val sup = WorkDocument.parse _
    val WorkCostDetail = parse_attribute (attribute ("""WorkCostSummary.WorkCostDetail"""))_
    def parse (context: Context): WorkCostSummary =
    {
        WorkCostSummary(
            sup (context),
            WorkCostDetail (context)
        )
    }
}

/**
 * Shadow class for Document, to isolate subclassing from this package.
 * If any subclass gets normative and needs inheritance, it will inherit directly from Document.
 * @param sup Reference to the superclass object.
 */
case class WorkDocument
(override val sup: Document
)
extends
    Element
{
    def this () = { this (null) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { return (clone ().asInstanceOf[WorkDocument]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WorkDocument
extends
    Parseable[WorkDocument]
{
    val sup = Document.parse _
    def parse (context: Context): WorkDocument =
    {
        WorkDocument(
            sup (context)
        )
    }
}

/**
 * A pre-defined set of work steps for a given type of work.
 * @param sup Reference to the superclass object.
 * @param sequenceNumber Used to define dependencies of each work flow step, which is for the instance of WorkTask associated with a given instance of WorkFlow.
 * @param status
 * @param Work
 */
case class WorkFlowStep
(override val sup: WorkIdentifiedObject,
val sequenceNumber: Int,
val status: String,
val Work: String
)
extends
    Element
{
    def this () = { this (null, 0, null, null) }
    def WorkIdentifiedObject: WorkIdentifiedObject = sup.asInstanceOf[WorkIdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[WorkFlowStep]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WorkFlowStep
extends
    Parseable[WorkFlowStep]
{
    val sup = WorkIdentifiedObject.parse _
    val sequenceNumber = parse_element (element ("""WorkFlowStep.sequenceNumber"""))_
    val status = parse_attribute (attribute ("""WorkFlowStep.status"""))_
    val Work = parse_attribute (attribute ("""WorkFlowStep.Work"""))_
    def parse (context: Context): WorkFlowStep =
    {
        WorkFlowStep(
            sup (context),
            toInteger (sequenceNumber (context), context),
            status (context),
            Work (context)
        )
    }
}

/**
 * Shadow class for IdentifiedObject, to isolate subclassing from this package.
 * If any subclass gets normative and needs inheritance, it will inherit directly from IdentifiedObject.
 * @param sup Reference to the superclass object.
 */
case class WorkIdentifiedObject
(override val sup: IdentifiedObject
)
extends
    Element
{
    def this () = { this (null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[WorkIdentifiedObject]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WorkIdentifiedObject
extends
    Parseable[WorkIdentifiedObject]
{
    val sup = IdentifiedObject.parse _
    def parse (context: Context): WorkIdentifiedObject =
    {
        WorkIdentifiedObject(
            sup (context)
        )
    }
}

/**
 * A type of ActivityRecord that records information about the status of an item, such as a Work or WorkTask, at a point in time.
 * @param sup Reference to the superclass object.
 * @param percentComplete Estimated percentage of completion of this individual work task or overall work order.
 */
case class WorkStatusEntry
(override val sup: ActivityRecord,
val percentComplete: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
    def ActivityRecord: ActivityRecord = sup.asInstanceOf[ActivityRecord]
    override def copy (): Row = { return (clone ().asInstanceOf[WorkStatusEntry]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WorkStatusEntry
extends
    Parseable[WorkStatusEntry]
{
    val sup = ActivityRecord.parse _
    val percentComplete = parse_element (element ("""WorkStatusEntry.percentComplete"""))_
    def parse (context: Context): WorkStatusEntry =
    {
        WorkStatusEntry(
            sup (context),
            toDouble (percentComplete (context), context)
        )
    }
}

object _InfWork
{
    def register: Unit =
    {
        AccessPermit.register
        Assignment.register
        BusinessCase.register
        CUAllowableAction.register
        CUAsset.register
        CUContractorItem.register
        CUGroup.register
        CULaborCode.register
        CULaborItem.register
        CUMaterialItem.register
        CUWorkEquipmentItem.register
        Capability.register
        CompatibleUnit.register
        ConditionFactor.register
        ConditionFactorKind.register
        ContractorItem.register
        CostType.register
        Design.register
        DesignKind.register
        DesignLocation.register
        DesignLocationCU.register
        InfoQuestion.register
        LaborItem.register
        MiscCostItem.register
        NonStandardItem.register
        OldWorkTask.register
        OneCallRequest.register
        OverheadCost.register
        Project.register
        PropertyUnit.register
        QualificationRequirement.register
        Regulation.register
        ShiftPattern.register
        TypeMaterial.register
        Usage.register
        WorkActionKind.register
        WorkCostDetail.register
        WorkCostSummary.register
        WorkDocument.register
        WorkFlowStep.register
        WorkIdentifiedObject.register
        WorkStatusEntry.register
    }
}