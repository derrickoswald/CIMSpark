package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * An identification of a party acting in a electricity market business process.
 *
 * This class is used to identify organizations that can participate in market management and/or market operations.
 *
 * @param sup            [[ch.ninecode.model.Organisation Organisation]] Reference to the superclass object.
 * @param Bid            [[ch.ninecode.model.Bid Bid]] <em>undocumented</em>
 * @param MarketDocument [[ch.ninecode.model.MarketDocument MarketDocument]] <em>undocumented</em>
 * @param MarketRole     [[ch.ninecode.model.MarketRole MarketRole]] <em>undocumented</em>
 * @param TimeSeries     [[ch.ninecode.model.TimeSeries TimeSeries]] <em>undocumented</em>
 * @group MarketCommon
 * @groupname MarketCommon Package MarketCommon
 * @groupdesc MarketCommon This package contains the common objects shared by both MarketManagement and MarketOperations packages.
 */
case class MarketParticipant
(
    override val sup: Organisation,
    Bid: List[String],
    MarketDocument: List[String],
    MarketRole: List[String],
    TimeSeries: List[String]
)
    extends
        Element
{
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, List (), List (), List (), List ())
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Organisation: Organisation = sup.asInstanceOf [Organisation]

    override def copy (): Row =
    {
        clone ().asInstanceOf [MarketParticipant]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MarketParticipant.cls

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (MarketParticipant.fields (position), x))

        emitattrs (0, Bid)
        emitattrs (1, MarketDocument)
        emitattrs (2, MarketRole)
        emitattrs (3, TimeSeries)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:MarketParticipant rdf:ID=\"%s\">\n%s\t</cim:MarketParticipant>".format (id, export_fields)
    }
}

object MarketParticipant
    extends
        Parseable[MarketParticipant]
{
    override val fields: Array[String] = Array [String](
        "Bid",
        "MarketDocument",
        "MarketRole",
        "TimeSeries"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Bid", "Bid", "0..*", "0..1"),
        Relationship ("MarketDocument", "MarketDocument", "0..*", "0..*"),
        Relationship ("MarketRole", "MarketRole", "0..*", "0..*"),
        Relationship ("TimeSeries", "TimeSeries", "0..*", "0..*")
    )
    val Bid: FielderMultiple = parse_attributes (attribute (cls, fields (0)))
    val MarketDocument: FielderMultiple = parse_attributes (attribute (cls, fields (1)))
    val MarketRole: FielderMultiple = parse_attributes (attribute (cls, fields (2)))
    val TimeSeries: FielderMultiple = parse_attributes (attribute (cls, fields (3)))

    def parse (context: Context): MarketParticipant =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = MarketParticipant (
            Organisation.parse (context),
            masks (Bid (), 0),
            masks (MarketDocument (), 1),
            masks (MarketRole (), 2),
            masks (TimeSeries (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The external intended behaviour played by a party within the electricity market.
 *
 * @param sup               [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param roleType          Defined using an enumerated list of types of market roles for use when a finite list of types are desired.
 * @param status            Status of the market role.
 * @param type              The kind of market roles that can be played by parties for given domains within the electricity market.
 *                          Types are flexible using dataType of string for free-entry of role types.
 * @param MarketParticipant [[ch.ninecode.model.MarketParticipant MarketParticipant]] <em>undocumented</em>
 * @group MarketCommon
 * @groupname MarketCommon Package MarketCommon
 * @groupdesc MarketCommon This package contains the common objects shared by both MarketManagement and MarketOperations packages.
 */
case class MarketRole
(
    override val sup: IdentifiedObject,
    roleType: String,
    status: String,
    `type`: String,
    MarketParticipant: List[String]
)
    extends
        Element
{
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, null, null, null, List ())
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf [IdentifiedObject]

    override def copy (): Row =
    {
        clone ().asInstanceOf [MarketRole]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MarketRole.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MarketRole.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MarketRole.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (MarketRole.fields (position), x))

        emitattr (0, roleType)
        emitattr (1, status)
        emitelem (2, `type`)
        emitattrs (3, MarketParticipant)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:MarketRole rdf:ID=\"%s\">\n%s\t</cim:MarketRole>".format (id, export_fields)
    }
}

object MarketRole
    extends
        Parseable[MarketRole]
{
    override val fields: Array[String] = Array [String](
        "roleType",
        "status",
        "type",
        "MarketParticipant"
    )
    override val relations: List[Relationship] = List (
        Relationship ("MarketParticipant", "MarketParticipant", "0..*", "0..*")
    )
    val roleType: Fielder = parse_attribute (attribute (cls, fields (0)))
    val status: Fielder = parse_attribute (attribute (cls, fields (1)))
    val `type`: Fielder = parse_element (element (cls, fields (2)))
    val MarketParticipant: FielderMultiple = parse_attributes (attribute (cls, fields (3)))

    def parse (context: Context): MarketRole =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = MarketRole (
            IdentifiedObject.parse (context),
            mask (roleType (), 0),
            mask (status (), 1),
            mask (`type` (), 2),
            masks (MarketParticipant (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A resource that is registered through the market participant registration system.
 *
 * Examples include generating unit, load, and non-physical generator or load.
 *
 * @param sup                                   [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param commercialOpDate                      Resource Commercial Operation Date.
 * @param contingencyAvailFlag                  contingent operating reserve availiability (Yes/No).
 *                                              Resource is availiable to participate with capacity in contingency dispatch.
 * @param dispatchFlag                          Dispatch flag: indicates whether the resource is dispatchable (Y/N)
 *                                              It is move to the RegisteredResource class for the participating load dispatch purpose
 * @param endEffectiveDate                      end effective date
 * @param flexibleOfferFlag                     flexible offer flag (Y/N)
 * @param hourlyPredispatch                     Indicates need to dispatch before the start of the operating hour.
 *                                              Only relevent in Real-Time Market. Applies to generation, intertie and participating load resource. Value (Y/N)
 * @param isAggregatedRes                       a flag to indicate if a resource is an aggregated resource
 * @param lastModified                          Indication of the last time this item was modified/versioned.
 * @param marketParticipationFlag               Market Participation flag: indicates whether the resource participate in the market (Y/N)
 * @param maxBaseSelfSchedQty                   maximum base self schedule quantity
 * @param maxOnTime                             maximum on time after start up
 * @param minDispatchTime                       minimum number of consecutive hours a resource shall be dispatched if bid is accepted
 * @param minOffTime                            minimum off time after shut  down
 * @param minOnTime                             minimum on time after start up
 * @param mustOfferFlag                         Must offer flag: indicates whether the unit is subject to the must offer provisions (Y/N)
 * @param nonMarket                             Flag to indicate that the Resource is not participating in the Market Operations.
 * @param pointOfDeliveryFlag                   Indication that the registered resource is a Point of Delivery (YES) resource which implies there is a POD Loss Factor.
 * @param priceSetFlagDA                        Price setting flag: indicates whether a resource is capable of setting the Market Clearing Price (Y) for the DA market, and if not, indicates whether the resource shall submit bids for energy at \$ 0 (S) or not (N)
 *
 *                                              Initially in the RegisteredGenerator class.
 *                                              It wasmove to the RegisteredResource class for the participating load dispatch purpose
 * @param priceSetFlagRT                        Price setting flag: indicates whether a resource is capable of setting the Market Clearing Price (Y) for the RT market, and if not, indicates whether the resource shall submit bids for energy at \$ 0 (S) or not (N)
 *
 *                                              Initially in the RegisteredGenerator class.
 *                                              It wasmove to the RegisteredResource class for the participating load dispatch purpose
 * @param registrationStatus                    Registration Status of resource - Active, Mothballed, Planned, or Decommissioned.
 * @param resourceAdequacyFlag                  Indication that this resource participates inthe resource adequacy function.
 * @param startEffectiveDate                    start effective date
 * @param ACAFlag                               Indication that this resource is associated with an Adjacent Control Area
 * @param ASSPOptimizationFlag                  Indication that the resource participates in the optimization process by default.
 * @param AdjacentCASet                         [[ch.ninecode.model.AdjacentCASet AdjacentCASet]] <em>undocumented</em>
 * @param AggregateNode                         [[ch.ninecode.model.AggregateNode AggregateNode]] <em>undocumented</em>
 * @param AllocationResultValues                [[ch.ninecode.model.AllocationResultValues AllocationResultValues]] <em>undocumented</em>
 * @param Commitments                           [[ch.ninecode.model.Commitments Commitments]] <em>undocumented</em>
 * @param ContractDistributionFactor            [[ch.ninecode.model.ContractDistributionFactor ContractDistributionFactor]] <em>undocumented</em>
 * @param ControlAreaDesignation                [[ch.ninecode.model.ControlAreaDesignation ControlAreaDesignation]] <em>undocumented</em>
 * @param DefaultBid                            [[ch.ninecode.model.DefaultBid DefaultBid]] <em>undocumented</em>
 * @param DispatchInstReply                     [[ch.ninecode.model.DispatchInstReply DispatchInstReply]] <em>undocumented</em>
 * @param DopInstruction                        [[ch.ninecode.model.DopInstruction DopInstruction]] <em>undocumented</em>
 * @param DotInstruction                        [[ch.ninecode.model.DotInstruction DotInstruction]] <em>undocumented</em>
 * @param ECAFlag                               Indication that this resource is associated with an Embedded Control area
 * @param EnergyMarkets                         [[ch.ninecode.model.EnergyMarket EnergyMarket]] <em>undocumented</em>
 * @param ExPostResourceResults                 [[ch.ninecode.model.ExPostResourceResults ExPostResourceResults]] <em>undocumented</em>
 * @param ExpectedEnergyValues                  [[ch.ninecode.model.ExpectedEnergyValues ExpectedEnergyValues]] <em>undocumented</em>
 * @param ForbiddenRegion                       [[ch.ninecode.model.ForbiddenRegion ForbiddenRegion]] <em>undocumented</em>
 * @param FormerReference                       [[ch.ninecode.model.FormerReference FormerReference]] <em>undocumented</em>
 * @param HostControlArea                       [[ch.ninecode.model.HostControlArea HostControlArea]] <em>undocumented</em>
 * @param Instructions                          [[ch.ninecode.model.Instructions Instructions]] <em>undocumented</em>
 * @param InterTie                              [[ch.ninecode.model.SchedulingPoint SchedulingPoint]] <em>undocumented</em>
 * @param IntermittentResourceEligibility       [[ch.ninecode.model.IntermittentResourceEligibility IntermittentResourceEligibility]] <em>undocumented</em>
 * @param LMPMFlag                              LMPM flag: indicates whether the resource is subject to the LMPM test (Yes/No)
 * @param LoadFollowingInst                     [[ch.ninecode.model.LoadFollowingInst LoadFollowingInst]] <em>undocumented</em>
 * @param LoadFollowingOperatorInput            [[ch.ninecode.model.LoadFollowingOperatorInput LoadFollowingOperatorInput]] <em>undocumented</em>
 * @param MPMResourceStatus                     [[ch.ninecode.model.MPMResourceStatus MPMResourceStatus]] <em>undocumented</em>
 * @param MPMTestThreshold                      [[ch.ninecode.model.MPMTestThreshold MPMTestThreshold]] <em>undocumented</em>
 * @param MktConnectivityNode                   [[ch.ninecode.model.MktConnectivityNode MktConnectivityNode]] <em>undocumented</em>
 * @param MktOrganisation                       [[ch.ninecode.model.MktOrganisation MktOrganisation]] <em>undocumented</em>
 * @param OrgResOwnership                       [[ch.ninecode.model.OrgResOwnership OrgResOwnership]] <em>undocumented</em>
 * @param Pnode                                 [[ch.ninecode.model.Pnode Pnode]] A registered resource injects power at one or more connectivity nodes related to a pnode
 * @param RMROperatorInput                      [[ch.ninecode.model.RMROperatorInput RMROperatorInput]] <em>undocumented</em>
 * @param RUCAwardInstruction                   [[ch.ninecode.model.RUCAwardInstruction RUCAwardInstruction]] <em>undocumented</em>
 * @param RampRateCurve                         [[ch.ninecode.model.RampRateCurve RampRateCurve]] <em>undocumented</em>
 * @param ResourceAncillaryServiceQualification [[ch.ninecode.model.ResourceAncillaryServiceQualification ResourceAncillaryServiceQualification]] RegisteredResources are qualified for resource ancillary service types (which include market product types as well as other types such as BlackStart) by the association to the class ResourceAncillaryServiceQualification.
 * @param ResourceAwardInstruction              [[ch.ninecode.model.ResourceAwardInstruction ResourceAwardInstruction]] <em>undocumented</em>
 * @param ResourceCapacity                      [[ch.ninecode.model.ResourceCapacity ResourceCapacity]] <em>undocumented</em>
 * @param ResourceCertification                 [[ch.ninecode.model.ResourceCertification ResourceCertification]] <em>undocumented</em>
 * @param ResourceDispatchResults               [[ch.ninecode.model.ResourceDispatchResults ResourceDispatchResults]] <em>undocumented</em>
 * @param ResourceGroups                        [[ch.ninecode.model.ResourceGroup ResourceGroup]] <em>undocumented</em>
 * @param ResourceLoadFollowingInst             [[ch.ninecode.model.ResourceLoadFollowingInst ResourceLoadFollowingInst]] <em>undocumented</em>
 * @param ResourceVerifiableCosts               [[ch.ninecode.model.ResourceVerifiableCosts ResourceVerifiableCosts]] <em>undocumented</em>
 * @param SMPMFlag                              SMPM flag: indicates whether the resource is subject to the SMPM test (Yes/No)
 * @param SubControlArea                        [[ch.ninecode.model.SubControlArea SubControlArea]] <em>undocumented</em>
 * @param SubstitutionResourceList              [[ch.ninecode.model.SubstitutionResourceList SubstitutionResourceList]] <em>undocumented</em>
 * @param TimeSeries                            [[ch.ninecode.model.TimeSeries TimeSeries]] <em>undocumented</em>
 * @group MarketCommon
 * @groupname MarketCommon Package MarketCommon
 * @groupdesc MarketCommon This package contains the common objects shared by both MarketManagement and MarketOperations packages.
 */
case class RegisteredResource
(
    override val sup: PowerSystemResource,
    commercialOpDate: String,
    contingencyAvailFlag: String,
    dispatchFlag: String,
    endEffectiveDate: String,
    flexibleOfferFlag: String,
    hourlyPredispatch: String,
    isAggregatedRes: String,
    lastModified: String,
    marketParticipationFlag: String,
    maxBaseSelfSchedQty_1: Double,
    maxOnTime: Double,
    minDispatchTime: Double,
    minOffTime: Double,
    minOnTime: Double,
    mustOfferFlag: String,
    nonMarket: String,
    pointOfDeliveryFlag: String,
    priceSetFlagDA: String,
    priceSetFlagRT: String,
    registrationStatus: String,
    resourceAdequacyFlag: String,
    startEffectiveDate: String,
    ACAFlag: String,
    ASSPOptimizationFlag: String,
    AdjacentCASet: String,
    AggregateNode: List[String],
    AllocationResultValues: List[String],
    Commitments: List[String],
    ContractDistributionFactor: List[String],
    ControlAreaDesignation: List[String],
    DefaultBid: String,
    DispatchInstReply: List[String],
    DopInstruction: List[String],
    DotInstruction: List[String],
    ECAFlag: String,
    EnergyMarkets: List[String],
    ExPostResourceResults: List[String],
    ExpectedEnergyValues: List[String],
    ForbiddenRegion: List[String],
    FormerReference: List[String],
    HostControlArea: String,
    Instructions: List[String],
    InterTie: List[String],
    IntermittentResourceEligibility: List[String],
    LMPMFlag: String,
    LoadFollowingInst: List[String],
    LoadFollowingOperatorInput: List[String],
    MPMResourceStatus: List[String],
    MPMTestThreshold: List[String],
    MktConnectivityNode: String,
    MktOrganisation: String,
    OrgResOwnership: List[String],
    Pnode: String,
    RMROperatorInput: List[String],
    RUCAwardInstruction: List[String],
    RampRateCurve: List[String],
    ResourceAncillaryServiceQualification: List[String],
    ResourceAwardInstruction: List[String],
    ResourceCapacity: List[String],
    ResourceCertification: List[String],
    ResourceDispatchResults: List[String],
    ResourceGroups: List[String],
    ResourceLoadFollowingInst: List[String],
    ResourceVerifiableCosts: String,
    SMPMFlag: String,
    SubControlArea: List[String],
    SubstitutionResourceList: List[String],
    TimeSeries: List[String]
)
    extends
        Element
{
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, null, null, null, null, null, null, null, null, null, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, null, null, null, null, null, null, null, null, null, List (), List (), List (), List (), List (), null, List (), List (), List (), null, List (), List (), List (), List (), List (), null, List (), List (), List (), null, List (), List (), List (), List (), null, null, List (), null, List (), List (), List (), List (), List (), List (), List (), List (), List (), List (), null, null, List (), List (), List ())
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf [PowerSystemResource]

    override def copy (): Row =
    {
        clone ().asInstanceOf [RegisteredResource]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = RegisteredResource.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (RegisteredResource.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RegisteredResource.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (RegisteredResource.fields (position), x))

        emitelem (0, commercialOpDate)
        emitattr (1, contingencyAvailFlag)
        emitattr (2, dispatchFlag)
        emitelem (3, endEffectiveDate)
        emitattr (4, flexibleOfferFlag)
        emitattr (5, hourlyPredispatch)
        emitattr (6, isAggregatedRes)
        emitelem (7, lastModified)
        emitattr (8, marketParticipationFlag)
        emitelem (9, maxBaseSelfSchedQty_1)
        emitelem (10, maxOnTime)
        emitelem (11, minDispatchTime)
        emitelem (12, minOffTime)
        emitelem (13, minOnTime)
        emitattr (14, mustOfferFlag)
        emitattr (15, nonMarket)
        emitattr (16, pointOfDeliveryFlag)
        emitattr (17, priceSetFlagDA)
        emitattr (18, priceSetFlagRT)
        emitattr (19, registrationStatus)
        emitattr (20, resourceAdequacyFlag)
        emitelem (21, startEffectiveDate)
        emitattr (22, ACAFlag)
        emitattr (23, ASSPOptimizationFlag)
        emitattr (24, AdjacentCASet)
        emitattrs (25, AggregateNode)
        emitattrs (26, AllocationResultValues)
        emitattrs (27, Commitments)
        emitattrs (28, ContractDistributionFactor)
        emitattrs (29, ControlAreaDesignation)
        emitattr (30, DefaultBid)
        emitattrs (31, DispatchInstReply)
        emitattrs (32, DopInstruction)
        emitattrs (33, DotInstruction)
        emitattr (34, ECAFlag)
        emitattrs (35, EnergyMarkets)
        emitattrs (36, ExPostResourceResults)
        emitattrs (37, ExpectedEnergyValues)
        emitattrs (38, ForbiddenRegion)
        emitattrs (39, FormerReference)
        emitattr (40, HostControlArea)
        emitattrs (41, Instructions)
        emitattrs (42, InterTie)
        emitattrs (43, IntermittentResourceEligibility)
        emitattr (44, LMPMFlag)
        emitattrs (45, LoadFollowingInst)
        emitattrs (46, LoadFollowingOperatorInput)
        emitattrs (47, MPMResourceStatus)
        emitattrs (48, MPMTestThreshold)
        emitattr (49, MktConnectivityNode)
        emitattr (50, MktOrganisation)
        emitattrs (51, OrgResOwnership)
        emitattr (52, Pnode)
        emitattrs (53, RMROperatorInput)
        emitattrs (54, RUCAwardInstruction)
        emitattrs (55, RampRateCurve)
        emitattrs (56, ResourceAncillaryServiceQualification)
        emitattrs (57, ResourceAwardInstruction)
        emitattrs (58, ResourceCapacity)
        emitattrs (59, ResourceCertification)
        emitattrs (60, ResourceDispatchResults)
        emitattrs (61, ResourceGroups)
        emitattrs (62, ResourceLoadFollowingInst)
        emitattr (63, ResourceVerifiableCosts)
        emitattr (64, SMPMFlag)
        emitattrs (65, SubControlArea)
        emitattrs (66, SubstitutionResourceList)
        emitattrs (67, TimeSeries)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:RegisteredResource rdf:ID=\"%s\">\n%s\t</cim:RegisteredResource>".format (id, export_fields)
    }
}

object RegisteredResource
    extends
        Parseable[RegisteredResource]
{
    override val fields: Array[String] = Array [String](
        "commercialOpDate",
        "contingencyAvailFlag",
        "dispatchFlag",
        "endEffectiveDate",
        "flexibleOfferFlag",
        "hourlyPredispatch",
        "isAggregatedRes",
        "lastModified",
        "marketParticipationFlag",
        "maxBaseSelfSchedQty ",
        "maxOnTime",
        "minDispatchTime",
        "minOffTime",
        "minOnTime",
        "mustOfferFlag",
        "nonMarket",
        "pointOfDeliveryFlag",
        "priceSetFlagDA",
        "priceSetFlagRT",
        "registrationStatus",
        "resourceAdequacyFlag",
        "startEffectiveDate",
        "ACAFlag",
        "ASSPOptimizationFlag",
        "AdjacentCASet",
        "AggregateNode",
        "AllocationResultValues",
        "Commitments",
        "ContractDistributionFactor",
        "ControlAreaDesignation",
        "DefaultBid",
        "DispatchInstReply",
        "DopInstruction",
        "DotInstruction",
        "ECAFlag",
        "EnergyMarkets",
        "ExPostResourceResults",
        "ExpectedEnergyValues",
        "ForbiddenRegion",
        "FormerReference",
        "HostControlArea",
        "Instructions",
        "InterTie",
        "IntermittentResourceEligibility",
        "LMPMFlag",
        "LoadFollowingInst",
        "LoadFollowingOperatorInput",
        "MPMResourceStatus",
        "MPMTestThreshold",
        "MktConnectivityNode",
        "MktOrganisation",
        "OrgResOwnership",
        "Pnode",
        "RMROperatorInput",
        "RUCAwardInstruction",
        "RampRateCurve",
        "ResourceAncillaryServiceQualification",
        "ResourceAwardInstruction",
        "ResourceCapacity",
        "ResourceCertification",
        "ResourceDispatchResults",
        "ResourceGroups",
        "ResourceLoadFollowingInst",
        "ResourceVerifiableCosts",
        "SMPMFlag",
        "SubControlArea",
        "SubstitutionResourceList",
        "TimeSeries"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AdjacentCASet", "AdjacentCASet", "0..1", "0..*"),
        Relationship ("AggregateNode", "AggregateNode", "0..*", "0..*"),
        Relationship ("AllocationResultValues", "AllocationResultValues", "0..*", "0..1"),
        Relationship ("Commitments", "Commitments", "0..*", "1"),
        Relationship ("ContractDistributionFactor", "ContractDistributionFactor", "0..*", "0..1"),
        Relationship ("ControlAreaDesignation", "ControlAreaDesignation", "0..*", "0..*"),
        Relationship ("DefaultBid", "DefaultBid", "0..1", "1"),
        Relationship ("DispatchInstReply", "DispatchInstReply", "0..*", "1"),
        Relationship ("DopInstruction", "DopInstruction", "0..*", "0..1"),
        Relationship ("DotInstruction", "DotInstruction", "0..*", "0..1"),
        Relationship ("EnergyMarkets", "EnergyMarket", "0..*", "0..*"),
        Relationship ("ExPostResourceResults", "ExPostResourceResults", "0..*", "0..1"),
        Relationship ("ExpectedEnergyValues", "ExpectedEnergyValues", "0..*", "0..1"),
        Relationship ("ForbiddenRegion", "ForbiddenRegion", "0..*", "0..*"),
        Relationship ("FormerReference", "FormerReference", "0..*", "1"),
        Relationship ("HostControlArea", "HostControlArea", "0..1", "0..*"),
        Relationship ("Instructions", "Instructions", "0..*", "1"),
        Relationship ("InterTie", "SchedulingPoint", "0..*", "0..*"),
        Relationship ("IntermittentResourceEligibility", "IntermittentResourceEligibility", "0..*", "1"),
        Relationship ("LoadFollowingInst", "LoadFollowingInst", "0..*", "1"),
        Relationship ("LoadFollowingOperatorInput", "LoadFollowingOperatorInput", "0..*", "0..1"),
        Relationship ("MPMResourceStatus", "MPMResourceStatus", "0..*", "0..1"),
        Relationship ("MPMTestThreshold", "MPMTestThreshold", "0..*", "0..*"),
        Relationship ("MktConnectivityNode", "MktConnectivityNode", "0..1", "0..*"),
        Relationship ("MktOrganisation", "MktOrganisation", "0..1", "0..*"),
        Relationship ("OrgResOwnership", "OrgResOwnership", "0..*", "1"),
        Relationship ("Pnode", "Pnode", "0..1", "0..*"),
        Relationship ("RMROperatorInput", "RMROperatorInput", "0..*", "0..1"),
        Relationship ("RUCAwardInstruction", "RUCAwardInstruction", "0..*", "0..1"),
        Relationship ("RampRateCurve", "RampRateCurve", "0..*", "0..*"),
        Relationship ("ResourceAncillaryServiceQualification", "ResourceAncillaryServiceQualification", "0..*", "1"),
        Relationship ("ResourceAwardInstruction", "ResourceAwardInstruction", "0..*", "0..1"),
        Relationship ("ResourceCapacity", "ResourceCapacity", "0..*", "0..*"),
        Relationship ("ResourceCertification", "ResourceCertification", "0..*", "0..*"),
        Relationship ("ResourceDispatchResults", "ResourceDispatchResults", "0..*", "0..1"),
        Relationship ("ResourceGroups", "ResourceGroup", "0..*", "1..*"),
        Relationship ("ResourceLoadFollowingInst", "ResourceLoadFollowingInst", "0..*", "0..1"),
        Relationship ("ResourceVerifiableCosts", "ResourceVerifiableCosts", "0..1", "1"),
        Relationship ("SubControlArea", "SubControlArea", "0..*", "0..*"),
        Relationship ("SubstitutionResourceList", "SubstitutionResourceList", "0..*", "0..1"),
        Relationship ("TimeSeries", "TimeSeries", "0..*", "0..*")
    )
    val commercialOpDate: Fielder = parse_element (element (cls, fields (0)))
    val contingencyAvailFlag: Fielder = parse_attribute (attribute (cls, fields (1)))
    val dispatchFlag: Fielder = parse_attribute (attribute (cls, fields (2)))
    val endEffectiveDate: Fielder = parse_element (element (cls, fields (3)))
    val flexibleOfferFlag: Fielder = parse_attribute (attribute (cls, fields (4)))
    val hourlyPredispatch: Fielder = parse_attribute (attribute (cls, fields (5)))
    val isAggregatedRes: Fielder = parse_attribute (attribute (cls, fields (6)))
    val lastModified: Fielder = parse_element (element (cls, fields (7)))
    val marketParticipationFlag: Fielder = parse_attribute (attribute (cls, fields (8)))
    val maxBaseSelfSchedQty_1: Fielder = parse_element (element (cls, fields (9)))
    val maxOnTime: Fielder = parse_element (element (cls, fields (10)))
    val minDispatchTime: Fielder = parse_element (element (cls, fields (11)))
    val minOffTime: Fielder = parse_element (element (cls, fields (12)))
    val minOnTime: Fielder = parse_element (element (cls, fields (13)))
    val mustOfferFlag: Fielder = parse_attribute (attribute (cls, fields (14)))
    val nonMarket: Fielder = parse_attribute (attribute (cls, fields (15)))
    val pointOfDeliveryFlag: Fielder = parse_attribute (attribute (cls, fields (16)))
    val priceSetFlagDA: Fielder = parse_attribute (attribute (cls, fields (17)))
    val priceSetFlagRT: Fielder = parse_attribute (attribute (cls, fields (18)))
    val registrationStatus: Fielder = parse_attribute (attribute (cls, fields (19)))
    val resourceAdequacyFlag: Fielder = parse_attribute (attribute (cls, fields (20)))
    val startEffectiveDate: Fielder = parse_element (element (cls, fields (21)))
    val ACAFlag: Fielder = parse_attribute (attribute (cls, fields (22)))
    val ASSPOptimizationFlag: Fielder = parse_attribute (attribute (cls, fields (23)))
    val AdjacentCASet: Fielder = parse_attribute (attribute (cls, fields (24)))
    val AggregateNode: FielderMultiple = parse_attributes (attribute (cls, fields (25)))
    val AllocationResultValues: FielderMultiple = parse_attributes (attribute (cls, fields (26)))
    val Commitments: FielderMultiple = parse_attributes (attribute (cls, fields (27)))
    val ContractDistributionFactor: FielderMultiple = parse_attributes (attribute (cls, fields (28)))
    val ControlAreaDesignation: FielderMultiple = parse_attributes (attribute (cls, fields (29)))
    val DefaultBid: Fielder = parse_attribute (attribute (cls, fields (30)))
    val DispatchInstReply: FielderMultiple = parse_attributes (attribute (cls, fields (31)))
    val DopInstruction: FielderMultiple = parse_attributes (attribute (cls, fields (32)))
    val DotInstruction: FielderMultiple = parse_attributes (attribute (cls, fields (33)))
    val ECAFlag: Fielder = parse_attribute (attribute (cls, fields (34)))
    val EnergyMarkets: FielderMultiple = parse_attributes (attribute (cls, fields (35)))
    val ExPostResourceResults: FielderMultiple = parse_attributes (attribute (cls, fields (36)))
    val ExpectedEnergyValues: FielderMultiple = parse_attributes (attribute (cls, fields (37)))
    val ForbiddenRegion: FielderMultiple = parse_attributes (attribute (cls, fields (38)))
    val FormerReference: FielderMultiple = parse_attributes (attribute (cls, fields (39)))
    val HostControlArea: Fielder = parse_attribute (attribute (cls, fields (40)))
    val Instructions: FielderMultiple = parse_attributes (attribute (cls, fields (41)))
    val InterTie: FielderMultiple = parse_attributes (attribute (cls, fields (42)))
    val IntermittentResourceEligibility: FielderMultiple = parse_attributes (attribute (cls, fields (43)))
    val LMPMFlag: Fielder = parse_attribute (attribute (cls, fields (44)))
    val LoadFollowingInst: FielderMultiple = parse_attributes (attribute (cls, fields (45)))
    val LoadFollowingOperatorInput: FielderMultiple = parse_attributes (attribute (cls, fields (46)))
    val MPMResourceStatus: FielderMultiple = parse_attributes (attribute (cls, fields (47)))
    val MPMTestThreshold: FielderMultiple = parse_attributes (attribute (cls, fields (48)))
    val MktConnectivityNode: Fielder = parse_attribute (attribute (cls, fields (49)))
    val MktOrganisation: Fielder = parse_attribute (attribute (cls, fields (50)))
    val OrgResOwnership: FielderMultiple = parse_attributes (attribute (cls, fields (51)))
    val Pnode: Fielder = parse_attribute (attribute (cls, fields (52)))
    val RMROperatorInput: FielderMultiple = parse_attributes (attribute (cls, fields (53)))
    val RUCAwardInstruction: FielderMultiple = parse_attributes (attribute (cls, fields (54)))
    val RampRateCurve: FielderMultiple = parse_attributes (attribute (cls, fields (55)))
    val ResourceAncillaryServiceQualification: FielderMultiple = parse_attributes (attribute (cls, fields (56)))
    val ResourceAwardInstruction: FielderMultiple = parse_attributes (attribute (cls, fields (57)))
    val ResourceCapacity: FielderMultiple = parse_attributes (attribute (cls, fields (58)))
    val ResourceCertification: FielderMultiple = parse_attributes (attribute (cls, fields (59)))
    val ResourceDispatchResults: FielderMultiple = parse_attributes (attribute (cls, fields (60)))
    val ResourceGroups: FielderMultiple = parse_attributes (attribute (cls, fields (61)))
    val ResourceLoadFollowingInst: FielderMultiple = parse_attributes (attribute (cls, fields (62)))
    val ResourceVerifiableCosts: Fielder = parse_attribute (attribute (cls, fields (63)))
    val SMPMFlag: Fielder = parse_attribute (attribute (cls, fields (64)))
    val SubControlArea: FielderMultiple = parse_attributes (attribute (cls, fields (65)))
    val SubstitutionResourceList: FielderMultiple = parse_attributes (attribute (cls, fields (66)))
    val TimeSeries: FielderMultiple = parse_attributes (attribute (cls, fields (67)))

    def parse (context: Context): RegisteredResource =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0, 0, 0)
        val ret = RegisteredResource (
            PowerSystemResource.parse (context),
            mask (commercialOpDate (), 0),
            mask (contingencyAvailFlag (), 1),
            mask (dispatchFlag (), 2),
            mask (endEffectiveDate (), 3),
            mask (flexibleOfferFlag (), 4),
            mask (hourlyPredispatch (), 5),
            mask (isAggregatedRes (), 6),
            mask (lastModified (), 7),
            mask (marketParticipationFlag (), 8),
            toDouble (mask (maxBaseSelfSchedQty_1 (), 9)),
            toDouble (mask (maxOnTime (), 10)),
            toDouble (mask (minDispatchTime (), 11)),
            toDouble (mask (minOffTime (), 12)),
            toDouble (mask (minOnTime (), 13)),
            mask (mustOfferFlag (), 14),
            mask (nonMarket (), 15),
            mask (pointOfDeliveryFlag (), 16),
            mask (priceSetFlagDA (), 17),
            mask (priceSetFlagRT (), 18),
            mask (registrationStatus (), 19),
            mask (resourceAdequacyFlag (), 20),
            mask (startEffectiveDate (), 21),
            mask (ACAFlag (), 22),
            mask (ASSPOptimizationFlag (), 23),
            mask (AdjacentCASet (), 24),
            masks (AggregateNode (), 25),
            masks (AllocationResultValues (), 26),
            masks (Commitments (), 27),
            masks (ContractDistributionFactor (), 28),
            masks (ControlAreaDesignation (), 29),
            mask (DefaultBid (), 30),
            masks (DispatchInstReply (), 31),
            masks (DopInstruction (), 32),
            masks (DotInstruction (), 33),
            mask (ECAFlag (), 34),
            masks (EnergyMarkets (), 35),
            masks (ExPostResourceResults (), 36),
            masks (ExpectedEnergyValues (), 37),
            masks (ForbiddenRegion (), 38),
            masks (FormerReference (), 39),
            mask (HostControlArea (), 40),
            masks (Instructions (), 41),
            masks (InterTie (), 42),
            masks (IntermittentResourceEligibility (), 43),
            mask (LMPMFlag (), 44),
            masks (LoadFollowingInst (), 45),
            masks (LoadFollowingOperatorInput (), 46),
            masks (MPMResourceStatus (), 47),
            masks (MPMTestThreshold (), 48),
            mask (MktConnectivityNode (), 49),
            mask (MktOrganisation (), 50),
            masks (OrgResOwnership (), 51),
            mask (Pnode (), 52),
            masks (RMROperatorInput (), 53),
            masks (RUCAwardInstruction (), 54),
            masks (RampRateCurve (), 55),
            masks (ResourceAncillaryServiceQualification (), 56),
            masks (ResourceAwardInstruction (), 57),
            masks (ResourceCapacity (), 58),
            masks (ResourceCertification (), 59),
            masks (ResourceDispatchResults (), 60),
            masks (ResourceGroups (), 61),
            masks (ResourceLoadFollowingInst (), 62),
            mask (ResourceVerifiableCosts (), 63),
            mask (SMPMFlag (), 64),
            masks (SubControlArea (), 65),
            masks (SubstitutionResourceList (), 66),
            masks (TimeSeries (), 67)
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _MarketCommon
{
    def register: List[ClassInfo] =
    {
        List (
            MarketParticipant.register,
            MarketRole.register,
            RegisteredResource.register
        )
    }
}