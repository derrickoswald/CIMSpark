package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * An environmental monitoring station, examples of which could be a weather station or a seismic monitoring station.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param dstObserved Whether this station is currently reporting using daylight saving time.
 *        Intended to aid a utility Weather Service in interpreting information coming from a station and has no direct relationship to the manner in which time is expressed in EnvironmentalValueSet.
 * @param isNetworked Indication that station is part of a network of stations used to monitor weather phenomena covering a large geographical area.
 * @param timeZoneOffset The time offset from UTC (a.k.a.
 *        GMT) configured in the station "clock", not (necessarily) the time zone in which the station is physically located.
 *        This attribute exists to support management of utility monitoring stations and has no direct relationship to the manner in which time is expressed in EnvironmentalValueSet.
 * @param EnvironmentalAnalog [[ch.ninecode.model.EnvironmentalAnalog EnvironmentalAnalog]] Environmental analog measurement provided by this monitoring station.
 * @param Location [[ch.ninecode.model.Location Location]] Location of this monitoring station.
 * @param ReportingCapability [[ch.ninecode.model.ReportingCapability ReportingCapability]] One of the reporting capabilities of this monitoring station.
 * @param TimeSeries [[ch.ninecode.model.TimeSeries TimeSeries]] <em>undocumented</em>
 * @param UsagePoint [[ch.ninecode.model.UsagePoint UsagePoint]] <em>undocumented</em>
 * @group MarketCommon
 * @groupname MarketCommon Package MarketCommon
 * @groupdesc MarketCommon This package contains the common objects shared by MarketManagement, MarketOperations and Environmental packages.
 */
final case class EnvironmentalMonitoringStation
(
    override val sup: IdentifiedObject,
    dstObserved: Boolean,
    isNetworked: Boolean,
    timeZoneOffset: Double,
    EnvironmentalAnalog: List[String],
    Location: String,
    ReportingCapability: List[String],
    TimeSeries: List[String],
    UsagePoint: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, false, 0.0, List(), null, List(), List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[EnvironmentalMonitoringStation] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = EnvironmentalMonitoringStation.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (EnvironmentalMonitoringStation.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EnvironmentalMonitoringStation.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (EnvironmentalMonitoringStation.fields (position), x))
        emitelem (0, dstObserved)
        emitelem (1, isNetworked)
        emitelem (2, timeZoneOffset)
        emitattrs (3, EnvironmentalAnalog)
        emitattr (4, Location)
        emitattrs (5, ReportingCapability)
        emitattrs (6, TimeSeries)
        emitattrs (7, UsagePoint)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EnvironmentalMonitoringStation rdf:ID=\"%s\">\n%s\t</cim:EnvironmentalMonitoringStation>".format (id, export_fields)
    }
}

object EnvironmentalMonitoringStation
extends
    Parseable[EnvironmentalMonitoringStation]
{
    override val fields: Array[String] = Array[String] (
        "dstObserved",
        "isNetworked",
        "timeZoneOffset",
        "EnvironmentalAnalog",
        "Location",
        "ReportingCapability",
        "TimeSeries",
        "UsagePoint"
    )
    override val relations: List[Relationship] = List (
        Relationship ("EnvironmentalAnalog", "EnvironmentalAnalog", "0..*", "0..1"),
        Relationship ("Location", "Location", "0..1", "0..*"),
        Relationship ("ReportingCapability", "ReportingCapability", "0..*", "1"),
        Relationship ("TimeSeries", "TimeSeries", "0..*", "0..*"),
        Relationship ("UsagePoint", "UsagePoint", "0..*", "0..1")
    )
    val dstObserved: Fielder = parse_element (element (cls, fields(0)))
    val isNetworked: Fielder = parse_element (element (cls, fields(1)))
    val timeZoneOffset: Fielder = parse_element (element (cls, fields(2)))
    val EnvironmentalAnalog: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val Location: Fielder = parse_attribute (attribute (cls, fields(4)))
    val ReportingCapability: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val TimeSeries: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val UsagePoint: FielderMultiple = parse_attributes (attribute (cls, fields(7)))

    def parse (context: Context): EnvironmentalMonitoringStation =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = EnvironmentalMonitoringStation (
            IdentifiedObject.parse (context),
            toBoolean (mask (dstObserved (), 0)),
            toBoolean (mask (isNetworked (), 1)),
            toDouble (mask (timeZoneOffset (), 2)),
            masks (EnvironmentalAnalog (), 3),
            mask (Location (), 4),
            masks (ReportingCapability (), 5),
            masks (TimeSeries (), 6),
            masks (UsagePoint (), 7)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * An identification of a party acting in a electricity market business process.
 *
 * This class is used to identify organizations that can participate in market management and/or market operations.
 *
 * @param sup [[ch.ninecode.model.Organisation Organisation]] Reference to the superclass object.
 * @param Bid [[ch.ninecode.model.Bid Bid]] <em>undocumented</em>
 * @param MarketDocument [[ch.ninecode.model.MarketDocument MarketDocument]] <em>undocumented</em>
 * @param MarketPerson [[ch.ninecode.model.MarketPerson MarketPerson]] <em>undocumented</em>
 * @param MarketRole [[ch.ninecode.model.MarketRole MarketRole]] <em>undocumented</em>
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @param SchedulingCoordinator [[ch.ninecode.model.SchedulingCoordinator SchedulingCoordinator]] <em>undocumented</em>
 * @param TimeSeries [[ch.ninecode.model.TimeSeries TimeSeries]] <em>undocumented</em>
 * @group MarketCommon
 * @groupname MarketCommon Package MarketCommon
 * @groupdesc MarketCommon This package contains the common objects shared by MarketManagement, MarketOperations and Environmental packages.
 */
final case class MarketParticipant
(
    override val sup: Organisation,
    Bid: List[String],
    MarketDocument: List[String],
    MarketPerson: List[String],
    MarketRole: List[String],
    RegisteredResource: List[String],
    SchedulingCoordinator: List[String],
    TimeSeries: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List(), List(), List(), List(), List(), List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Organisation: Organisation = sup.asInstanceOf[Organisation]
    override def copy (): Row = { clone ().asInstanceOf[MarketParticipant] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MarketParticipant.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MarketParticipant.fields (position), x))
        emitattrs (0, Bid)
        emitattrs (1, MarketDocument)
        emitattrs (2, MarketPerson)
        emitattrs (3, MarketRole)
        emitattrs (4, RegisteredResource)
        emitattrs (5, SchedulingCoordinator)
        emitattrs (6, TimeSeries)
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
    override val fields: Array[String] = Array[String] (
        "Bid",
        "MarketDocument",
        "MarketPerson",
        "MarketRole",
        "RegisteredResource",
        "SchedulingCoordinator",
        "TimeSeries"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Bid", "Bid", "0..*", "0..1"),
        Relationship ("MarketDocument", "MarketDocument", "0..*", "0..*"),
        Relationship ("MarketPerson", "MarketPerson", "0..*", "0..*"),
        Relationship ("MarketRole", "MarketRole", "0..*", "0..*"),
        Relationship ("RegisteredResource", "RegisteredResource", "0..*", "0..1"),
        Relationship ("SchedulingCoordinator", "SchedulingCoordinator", "0..*", "0..1"),
        Relationship ("TimeSeries", "TimeSeries", "0..*", "0..*")
    )
    val Bid: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val MarketDocument: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val MarketPerson: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val MarketRole: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val RegisteredResource: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val SchedulingCoordinator: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val TimeSeries: FielderMultiple = parse_attributes (attribute (cls, fields(6)))

    def parse (context: Context): MarketParticipant =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MarketParticipant (
            Organisation.parse (context),
            masks (Bid (), 0),
            masks (MarketDocument (), 1),
            masks (MarketPerson (), 2),
            masks (MarketRole (), 3),
            masks (RegisteredResource (), 4),
            masks (SchedulingCoordinator (), 5),
            masks (TimeSeries (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The external intended behavior played by a party within the electricity market.
 *
 * @param sup [[ch.ninecode.model.OrganisationRole OrganisationRole]] Reference to the superclass object.
 * @param type The kind of market roles that can be played by parties for given domains within the electricity market.
 *        Types are flexible using dataType of string for free-entry of role types.
 * @param MarketParticipant [[ch.ninecode.model.MarketParticipant MarketParticipant]] <em>undocumented</em>
 * @group MarketCommon
 * @groupname MarketCommon Package MarketCommon
 * @groupdesc MarketCommon This package contains the common objects shared by MarketManagement, MarketOperations and Environmental packages.
 */
final case class MarketRole
(
    override val sup: OrganisationRole,
    `type`: String,
    MarketParticipant: List[String]
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
    def OrganisationRole: OrganisationRole = sup.asInstanceOf[OrganisationRole]
    override def copy (): Row = { clone ().asInstanceOf[MarketRole] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MarketRole.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MarketRole.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MarketRole.fields (position), x))
        emitelem (0, `type`)
        emitattrs (1, MarketParticipant)
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
    override val fields: Array[String] = Array[String] (
        "type",
        "MarketParticipant"
    )
    override val relations: List[Relationship] = List (
        Relationship ("MarketParticipant", "MarketParticipant", "0..*", "0..*")
    )
    val `type`: Fielder = parse_element (element (cls, fields(0)))
    val MarketParticipant: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): MarketRole =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MarketRole (
            OrganisationRole.parse (context),
            mask (`type` (), 0),
            masks (MarketParticipant (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Subclass of IEC61970:Production:GeneratingUnit.
 *
 * @param sup [[ch.ninecode.model.GeneratingUnit GeneratingUnit]] Reference to the superclass object.
 * @param GeneratingUnitDynamicValues [[ch.ninecode.model.GeneratingUnitDynamicValues GeneratingUnitDynamicValues]] <em>undocumented</em>
 * @group MarketCommon
 * @groupname MarketCommon Package MarketCommon
 * @groupdesc MarketCommon This package contains the common objects shared by MarketManagement, MarketOperations and Environmental packages.
 */
final case class MktGeneratingUnit
(
    override val sup: GeneratingUnit,
    GeneratingUnitDynamicValues: List[String]
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
    def GeneratingUnit: GeneratingUnit = sup.asInstanceOf[GeneratingUnit]
    override def copy (): Row = { clone ().asInstanceOf[MktGeneratingUnit] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MktGeneratingUnit.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MktGeneratingUnit.fields (position), x))
        emitattrs (0, GeneratingUnitDynamicValues)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MktGeneratingUnit rdf:ID=\"%s\">\n%s\t</cim:MktGeneratingUnit>".format (id, export_fields)
    }
}

object MktGeneratingUnit
extends
    Parseable[MktGeneratingUnit]
{
    override val fields: Array[String] = Array[String] (
        "GeneratingUnitDynamicValues"
    )
    override val relations: List[Relationship] = List (
        Relationship ("GeneratingUnitDynamicValues", "GeneratingUnitDynamicValues", "0..*", "1")
    )
    val GeneratingUnitDynamicValues: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): MktGeneratingUnit =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MktGeneratingUnit (
            GeneratingUnit.parse (context),
            masks (GeneratingUnitDynamicValues (), 0)
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
 * @param sup [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param commercialOpDate Resource Commercial Operation Date.
 * @param contingencyAvailFlag Contingent operating reserve availiability (Yes/No).
 *        Resource is availiable to participate with capacity in contingency dispatch.
 * @param dispatchable Dispatchable: indicates whether the resource is dispatchable.
 *        This implies that the resource intends to submit Energy bids/offers or Ancillary Services bids/offers, or self-provided schedules.
 * @param flexibleOfferFlag Flexible offer flag (Y/N).
 * @param hourlyPredispatch Indicates need to dispatch before the start of the operating hour.
 *        Only relevant in Real-Time Market. Applies to generation, intertie and participating load resource. Value (Y/N).
 * @param isAggregatedRes A flag to indicate if a resource is an aggregated resource.
 * @param lastModified Indication of the last time this item was modified/versioned.
 * @param marketParticipationFlag Market Participation flag: indicates whether the resource participate in the market.
 * @param maxBaseSelfSchedQty  Maximum base self schedule quantity.
 * @param maxOnTime Maximum on time after start up.
 * @param minDispatchTime Minimum number of consecutive hours a resource shall be dispatched if bid is accepted.
 * @param minOffTime Minimum off time after shut down.
 * @param minOnTime Minimum on time after start up.
 * @param mustOfferFlag Must offer flag: indicates whether the unit is subject to the must offer provisions (Y/N).
 * @param nonMarket Flag to indicate that the Resource is not participating in the Market Operations.
 * @param pointOfDeliveryFlag Indication that the registered resource is a Point of Delivery (YES) resource which implies there is a POD Loss Factor.
 * @param priceSetFlagDA Price setting flag: indicates whether a resource is capable of setting the Market Clearing Price (Y) for the DA market, and if not, indicates whether the resource shall submit bids for energy at \$ 0 (S) or not (N).
 *        Initially in the RegisteredGenerator class. It was moved to the RegisteredResource class for the participating load dispatch purpose.
 * @param priceSetFlagRT Price setting flag: indicates whether a resource is capable of setting the Market Clearing Price (Y) for the RT market, and if not, indicates whether the resource shall submit bids for energy at \$ 0 (S) or not (N).
 *        Initially in the RegisteredGenerator class. It was moved to the RegisteredResource class for the participating load dispatch purpose.
 * @param registrationStatus Registration Status of resource - Active, Mothballed, Planned, or Decommissioned.
 * @param resourceAdequacyFlag Indication that this resource participates in the resource adequacy function.
 * @param ACAFlag Indication that this resource is associated with an Adjacent Control Area.
 * @param ASSPOptimizationFlag Indication that the resource participates in the optimization process by default.
 * @param AdjacentCASet [[ch.ninecode.model.AdjacentCASet AdjacentCASet]] <em>undocumented</em>
 * @param AggregateNode [[ch.ninecode.model.AggregateNode AggregateNode]] An AggregateNode may be associated with up to many RegisteredResources.
 * @param AllocationResultValues [[ch.ninecode.model.AllocationResultValues AllocationResultValues]] <em>undocumented</em>
 * @param Commitments [[ch.ninecode.model.Commitments Commitments]] <em>undocumented</em>
 * @param ContractDistributionFactor [[ch.ninecode.model.ContractDistributionFactor ContractDistributionFactor]] <em>undocumented</em>
 * @param ControlAreaDesignation [[ch.ninecode.model.ControlAreaDesignation ControlAreaDesignation]] <em>undocumented</em>
 * @param DefaultBid [[ch.ninecode.model.DefaultBid DefaultBid]] <em>undocumented</em>
 * @param DispatchInstReply [[ch.ninecode.model.DispatchInstReply DispatchInstReply]] <em>undocumented</em>
 * @param Domain [[ch.ninecode.model.Domain Domain]] <em>undocumented</em>
 * @param DopInstruction [[ch.ninecode.model.DopInstruction DopInstruction]] <em>undocumented</em>
 * @param DotInstruction [[ch.ninecode.model.DotInstruction DotInstruction]] <em>undocumented</em>
 * @param ECAFlag Indication that this resource is associated with an Embedded Control area.
 * @param EnergyMarkets [[ch.ninecode.model.EnergyMarket EnergyMarket]] <em>undocumented</em>
 * @param ExPostResourceResults [[ch.ninecode.model.ExPostResourceResults ExPostResourceResults]] <em>undocumented</em>
 * @param ExpectedEnergyValues [[ch.ninecode.model.ExpectedEnergyValues ExpectedEnergyValues]] <em>undocumented</em>
 * @param ForbiddenRegion [[ch.ninecode.model.ForbiddenRegion ForbiddenRegion]] <em>undocumented</em>
 * @param FormerReference [[ch.ninecode.model.FormerReference FormerReference]] <em>undocumented</em>
 * @param HostControlArea [[ch.ninecode.model.HostControlArea HostControlArea]] <em>undocumented</em>
 * @param Instructions [[ch.ninecode.model.Instructions Instructions]] <em>undocumented</em>
 * @param InterTie [[ch.ninecode.model.SchedulingPoint SchedulingPoint]] <em>undocumented</em>
 * @param IntermittentResourceEligibility [[ch.ninecode.model.IntermittentResourceEligibility IntermittentResourceEligibility]] <em>undocumented</em>
 * @param LMPMFlag LMPM flag: indicates whether the resource is subject to the LMPM test (Yes/No).
 * @param LoadFollowingInst [[ch.ninecode.model.LoadFollowingInst LoadFollowingInst]] <em>undocumented</em>
 * @param LoadFollowingOperatorInput [[ch.ninecode.model.LoadFollowingOperatorInput LoadFollowingOperatorInput]] <em>undocumented</em>
 * @param MPMResourceStatus [[ch.ninecode.model.MPMResourceStatus MPMResourceStatus]] <em>undocumented</em>
 * @param MPMTestThreshold [[ch.ninecode.model.MPMTestThreshold MPMTestThreshold]] <em>undocumented</em>
 * @param MarketObjectStatus [[ch.ninecode.model.MarketObjectStatus MarketObjectStatus]] <em>undocumented</em>
 * @param MarketParticipant [[ch.ninecode.model.MarketParticipant MarketParticipant]] <em>undocumented</em>
 * @param MktConnectivityNode [[ch.ninecode.model.MktConnectivityNode MktConnectivityNode]] <em>undocumented</em>
 * @param OrgResOwnership [[ch.ninecode.model.OrgResOwnership OrgResOwnership]] <em>undocumented</em>
 * @param Pnode [[ch.ninecode.model.Pnode Pnode]] A registered resource injects power at one or more connectivity nodes related to a pnode
 * @param RMROperatorInput [[ch.ninecode.model.RMROperatorInput RMROperatorInput]] <em>undocumented</em>
 * @param RUCAwardInstruction [[ch.ninecode.model.RUCAwardInstruction RUCAwardInstruction]] <em>undocumented</em>
 * @param RampRateCurve [[ch.ninecode.model.RampRateCurve RampRateCurve]] <em>undocumented</em>
 * @param Reason [[ch.ninecode.model.Reason Reason]] <em>undocumented</em>
 * @param ResourceAncillaryServiceQualification [[ch.ninecode.model.ResourceCertification ResourceCertification]] RegisteredResources are qualified for resource ancillary service types (which include market product types as well as other types such as BlackStart) by the association to the class ResourceAncillaryServiceQualification.
 * @param ResourceAwardInstruction [[ch.ninecode.model.ResourceAwardInstruction ResourceAwardInstruction]] <em>undocumented</em>
 * @param ResourceCapacity [[ch.ninecode.model.ResourceCapacity ResourceCapacity]] <em>undocumented</em>
 * @param ResourceCertification [[ch.ninecode.model.ResourceCertification2 ResourceCertification2]] <em>undocumented</em>
 * @param ResourceDispatchResults [[ch.ninecode.model.ResourceDispatchResults ResourceDispatchResults]] <em>undocumented</em>
 * @param ResourceGroups [[ch.ninecode.model.ResourceGroup ResourceGroup]] <em>undocumented</em>
 * @param ResourceLoadFollowingInst [[ch.ninecode.model.ResourceLoadFollowingInst ResourceLoadFollowingInst]] <em>undocumented</em>
 * @param ResourceVerifiableCosts [[ch.ninecode.model.ResourceVerifiableCosts ResourceVerifiableCosts]] <em>undocumented</em>
 * @param SMPMFlag SMPM flag: indicates whether the resource is subject to the SMPM test (Yes/No).
 * @param SubControlArea [[ch.ninecode.model.SubControlArea SubControlArea]] <em>undocumented</em>
 * @param SubstitutionResourceList [[ch.ninecode.model.SubstitutionResourceList SubstitutionResourceList]] <em>undocumented</em>
 * @param TimeSeries [[ch.ninecode.model.TimeSeries TimeSeries]] <em>undocumented</em>
 * @group MarketCommon
 * @groupname MarketCommon Package MarketCommon
 * @groupdesc MarketCommon This package contains the common objects shared by MarketManagement, MarketOperations and Environmental packages.
 */
final case class RegisteredResource
(
    override val sup: PowerSystemResource,
    commercialOpDate: String,
    contingencyAvailFlag: String,
    dispatchable: Boolean,
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
    ACAFlag: String,
    ASSPOptimizationFlag: String,
    AdjacentCASet: String,
    AggregateNode: String,
    AllocationResultValues: List[String],
    Commitments: List[String],
    ContractDistributionFactor: List[String],
    ControlAreaDesignation: List[String],
    DefaultBid: String,
    DispatchInstReply: List[String],
    Domain: List[String],
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
    MarketObjectStatus: List[String],
    MarketParticipant: String,
    MktConnectivityNode: String,
    OrgResOwnership: List[String],
    Pnode: String,
    RMROperatorInput: List[String],
    RUCAwardInstruction: List[String],
    RampRateCurve: List[String],
    Reason: List[String],
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
    def this () = { this (null, null, null, false, null, null, null, null, null, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, null, null, null, null, null, null, null, null, null, List(), List(), List(), List(), null, List(), List(), List(), List(), null, List(), List(), List(), List(), List(), null, List(), List(), List(), null, List(), List(), List(), List(), List(), null, null, List(), null, List(), List(), List(), List(), List(), List(), List(), List(), List(), List(), List(), null, null, List(), List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { clone ().asInstanceOf[RegisteredResource] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = RegisteredResource.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (RegisteredResource.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RegisteredResource.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (RegisteredResource.fields (position), x))
        emitelem (0, commercialOpDate)
        emitattr (1, contingencyAvailFlag)
        emitelem (2, dispatchable)
        emitattr (3, flexibleOfferFlag)
        emitattr (4, hourlyPredispatch)
        emitattr (5, isAggregatedRes)
        emitelem (6, lastModified)
        emitattr (7, marketParticipationFlag)
        emitelem (8, maxBaseSelfSchedQty_1)
        emitelem (9, maxOnTime)
        emitelem (10, minDispatchTime)
        emitelem (11, minOffTime)
        emitelem (12, minOnTime)
        emitattr (13, mustOfferFlag)
        emitattr (14, nonMarket)
        emitattr (15, pointOfDeliveryFlag)
        emitattr (16, priceSetFlagDA)
        emitattr (17, priceSetFlagRT)
        emitattr (18, registrationStatus)
        emitattr (19, resourceAdequacyFlag)
        emitattr (20, ACAFlag)
        emitattr (21, ASSPOptimizationFlag)
        emitattr (22, AdjacentCASet)
        emitattr (23, AggregateNode)
        emitattrs (24, AllocationResultValues)
        emitattrs (25, Commitments)
        emitattrs (26, ContractDistributionFactor)
        emitattrs (27, ControlAreaDesignation)
        emitattr (28, DefaultBid)
        emitattrs (29, DispatchInstReply)
        emitattrs (30, Domain)
        emitattrs (31, DopInstruction)
        emitattrs (32, DotInstruction)
        emitattr (33, ECAFlag)
        emitattrs (34, EnergyMarkets)
        emitattrs (35, ExPostResourceResults)
        emitattrs (36, ExpectedEnergyValues)
        emitattrs (37, ForbiddenRegion)
        emitattrs (38, FormerReference)
        emitattr (39, HostControlArea)
        emitattrs (40, Instructions)
        emitattrs (41, InterTie)
        emitattrs (42, IntermittentResourceEligibility)
        emitattr (43, LMPMFlag)
        emitattrs (44, LoadFollowingInst)
        emitattrs (45, LoadFollowingOperatorInput)
        emitattrs (46, MPMResourceStatus)
        emitattrs (47, MPMTestThreshold)
        emitattrs (48, MarketObjectStatus)
        emitattr (49, MarketParticipant)
        emitattr (50, MktConnectivityNode)
        emitattrs (51, OrgResOwnership)
        emitattr (52, Pnode)
        emitattrs (53, RMROperatorInput)
        emitattrs (54, RUCAwardInstruction)
        emitattrs (55, RampRateCurve)
        emitattrs (56, Reason)
        emitattrs (57, ResourceAncillaryServiceQualification)
        emitattrs (58, ResourceAwardInstruction)
        emitattrs (59, ResourceCapacity)
        emitattrs (60, ResourceCertification)
        emitattrs (61, ResourceDispatchResults)
        emitattrs (62, ResourceGroups)
        emitattrs (63, ResourceLoadFollowingInst)
        emitattr (64, ResourceVerifiableCosts)
        emitattr (65, SMPMFlag)
        emitattrs (66, SubControlArea)
        emitattrs (67, SubstitutionResourceList)
        emitattrs (68, TimeSeries)
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
    override val fields: Array[String] = Array[String] (
        "commercialOpDate",
        "contingencyAvailFlag",
        "dispatchable",
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
        "Domain",
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
        "MarketObjectStatus",
        "MarketParticipant",
        "MktConnectivityNode",
        "OrgResOwnership",
        "Pnode",
        "RMROperatorInput",
        "RUCAwardInstruction",
        "RampRateCurve",
        "Reason",
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
        Relationship ("AggregateNode", "AggregateNode", "0..1", "0..*"),
        Relationship ("AllocationResultValues", "AllocationResultValues", "0..*", "0..1"),
        Relationship ("Commitments", "Commitments", "0..*", "1"),
        Relationship ("ContractDistributionFactor", "ContractDistributionFactor", "0..*", "0..1"),
        Relationship ("ControlAreaDesignation", "ControlAreaDesignation", "0..*", "0..*"),
        Relationship ("DefaultBid", "DefaultBid", "0..1", "1"),
        Relationship ("DispatchInstReply", "DispatchInstReply", "0..*", "1"),
        Relationship ("Domain", "Domain", "0..*", "0..*"),
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
        Relationship ("MarketObjectStatus", "MarketObjectStatus", "0..*", "0..*"),
        Relationship ("MarketParticipant", "MarketParticipant", "0..1", "0..*"),
        Relationship ("MktConnectivityNode", "MktConnectivityNode", "0..1", "0..*"),
        Relationship ("OrgResOwnership", "OrgResOwnership", "0..*", "1"),
        Relationship ("Pnode", "Pnode", "0..1", "0..*"),
        Relationship ("RMROperatorInput", "RMROperatorInput", "0..*", "0..1"),
        Relationship ("RUCAwardInstruction", "RUCAwardInstruction", "0..*", "0..1"),
        Relationship ("RampRateCurve", "RampRateCurve", "0..*", "0..*"),
        Relationship ("Reason", "Reason", "0..*", "0..*"),
        Relationship ("ResourceAncillaryServiceQualification", "ResourceCertification", "0..*", "1"),
        Relationship ("ResourceAwardInstruction", "ResourceAwardInstruction", "0..*", "0..1"),
        Relationship ("ResourceCapacity", "ResourceCapacity", "0..*", "0..*"),
        Relationship ("ResourceCertification", "ResourceCertification2", "0..*", "0..*"),
        Relationship ("ResourceDispatchResults", "ResourceDispatchResults", "0..*", "0..1"),
        Relationship ("ResourceGroups", "ResourceGroup", "0..*", "1..*"),
        Relationship ("ResourceLoadFollowingInst", "ResourceLoadFollowingInst", "0..*", "0..1"),
        Relationship ("ResourceVerifiableCosts", "ResourceVerifiableCosts", "0..1", "1"),
        Relationship ("SubControlArea", "SubControlArea", "0..*", "0..*"),
        Relationship ("SubstitutionResourceList", "SubstitutionResourceList", "0..*", "0..1"),
        Relationship ("TimeSeries", "TimeSeries", "0..*", "0..*")
    )
    val commercialOpDate: Fielder = parse_element (element (cls, fields(0)))
    val contingencyAvailFlag: Fielder = parse_attribute (attribute (cls, fields(1)))
    val dispatchable: Fielder = parse_element (element (cls, fields(2)))
    val flexibleOfferFlag: Fielder = parse_attribute (attribute (cls, fields(3)))
    val hourlyPredispatch: Fielder = parse_attribute (attribute (cls, fields(4)))
    val isAggregatedRes: Fielder = parse_attribute (attribute (cls, fields(5)))
    val lastModified: Fielder = parse_element (element (cls, fields(6)))
    val marketParticipationFlag: Fielder = parse_attribute (attribute (cls, fields(7)))
    val maxBaseSelfSchedQty_1: Fielder = parse_element (element (cls, fields(8)))
    val maxOnTime: Fielder = parse_element (element (cls, fields(9)))
    val minDispatchTime: Fielder = parse_element (element (cls, fields(10)))
    val minOffTime: Fielder = parse_element (element (cls, fields(11)))
    val minOnTime: Fielder = parse_element (element (cls, fields(12)))
    val mustOfferFlag: Fielder = parse_attribute (attribute (cls, fields(13)))
    val nonMarket: Fielder = parse_attribute (attribute (cls, fields(14)))
    val pointOfDeliveryFlag: Fielder = parse_attribute (attribute (cls, fields(15)))
    val priceSetFlagDA: Fielder = parse_attribute (attribute (cls, fields(16)))
    val priceSetFlagRT: Fielder = parse_attribute (attribute (cls, fields(17)))
    val registrationStatus: Fielder = parse_attribute (attribute (cls, fields(18)))
    val resourceAdequacyFlag: Fielder = parse_attribute (attribute (cls, fields(19)))
    val ACAFlag: Fielder = parse_attribute (attribute (cls, fields(20)))
    val ASSPOptimizationFlag: Fielder = parse_attribute (attribute (cls, fields(21)))
    val AdjacentCASet: Fielder = parse_attribute (attribute (cls, fields(22)))
    val AggregateNode: Fielder = parse_attribute (attribute (cls, fields(23)))
    val AllocationResultValues: FielderMultiple = parse_attributes (attribute (cls, fields(24)))
    val Commitments: FielderMultiple = parse_attributes (attribute (cls, fields(25)))
    val ContractDistributionFactor: FielderMultiple = parse_attributes (attribute (cls, fields(26)))
    val ControlAreaDesignation: FielderMultiple = parse_attributes (attribute (cls, fields(27)))
    val DefaultBid: Fielder = parse_attribute (attribute (cls, fields(28)))
    val DispatchInstReply: FielderMultiple = parse_attributes (attribute (cls, fields(29)))
    val Domain: FielderMultiple = parse_attributes (attribute (cls, fields(30)))
    val DopInstruction: FielderMultiple = parse_attributes (attribute (cls, fields(31)))
    val DotInstruction: FielderMultiple = parse_attributes (attribute (cls, fields(32)))
    val ECAFlag: Fielder = parse_attribute (attribute (cls, fields(33)))
    val EnergyMarkets: FielderMultiple = parse_attributes (attribute (cls, fields(34)))
    val ExPostResourceResults: FielderMultiple = parse_attributes (attribute (cls, fields(35)))
    val ExpectedEnergyValues: FielderMultiple = parse_attributes (attribute (cls, fields(36)))
    val ForbiddenRegion: FielderMultiple = parse_attributes (attribute (cls, fields(37)))
    val FormerReference: FielderMultiple = parse_attributes (attribute (cls, fields(38)))
    val HostControlArea: Fielder = parse_attribute (attribute (cls, fields(39)))
    val Instructions: FielderMultiple = parse_attributes (attribute (cls, fields(40)))
    val InterTie: FielderMultiple = parse_attributes (attribute (cls, fields(41)))
    val IntermittentResourceEligibility: FielderMultiple = parse_attributes (attribute (cls, fields(42)))
    val LMPMFlag: Fielder = parse_attribute (attribute (cls, fields(43)))
    val LoadFollowingInst: FielderMultiple = parse_attributes (attribute (cls, fields(44)))
    val LoadFollowingOperatorInput: FielderMultiple = parse_attributes (attribute (cls, fields(45)))
    val MPMResourceStatus: FielderMultiple = parse_attributes (attribute (cls, fields(46)))
    val MPMTestThreshold: FielderMultiple = parse_attributes (attribute (cls, fields(47)))
    val MarketObjectStatus: FielderMultiple = parse_attributes (attribute (cls, fields(48)))
    val MarketParticipant: Fielder = parse_attribute (attribute (cls, fields(49)))
    val MktConnectivityNode: Fielder = parse_attribute (attribute (cls, fields(50)))
    val OrgResOwnership: FielderMultiple = parse_attributes (attribute (cls, fields(51)))
    val Pnode: Fielder = parse_attribute (attribute (cls, fields(52)))
    val RMROperatorInput: FielderMultiple = parse_attributes (attribute (cls, fields(53)))
    val RUCAwardInstruction: FielderMultiple = parse_attributes (attribute (cls, fields(54)))
    val RampRateCurve: FielderMultiple = parse_attributes (attribute (cls, fields(55)))
    val Reason: FielderMultiple = parse_attributes (attribute (cls, fields(56)))
    val ResourceAncillaryServiceQualification: FielderMultiple = parse_attributes (attribute (cls, fields(57)))
    val ResourceAwardInstruction: FielderMultiple = parse_attributes (attribute (cls, fields(58)))
    val ResourceCapacity: FielderMultiple = parse_attributes (attribute (cls, fields(59)))
    val ResourceCertification: FielderMultiple = parse_attributes (attribute (cls, fields(60)))
    val ResourceDispatchResults: FielderMultiple = parse_attributes (attribute (cls, fields(61)))
    val ResourceGroups: FielderMultiple = parse_attributes (attribute (cls, fields(62)))
    val ResourceLoadFollowingInst: FielderMultiple = parse_attributes (attribute (cls, fields(63)))
    val ResourceVerifiableCosts: Fielder = parse_attribute (attribute (cls, fields(64)))
    val SMPMFlag: Fielder = parse_attribute (attribute (cls, fields(65)))
    val SubControlArea: FielderMultiple = parse_attributes (attribute (cls, fields(66)))
    val SubstitutionResourceList: FielderMultiple = parse_attributes (attribute (cls, fields(67)))
    val TimeSeries: FielderMultiple = parse_attributes (attribute (cls, fields(68)))

    def parse (context: Context): RegisteredResource =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0,0,0)
        val ret = RegisteredResource (
            PowerSystemResource.parse (context),
            mask (commercialOpDate (), 0),
            mask (contingencyAvailFlag (), 1),
            toBoolean (mask (dispatchable (), 2)),
            mask (flexibleOfferFlag (), 3),
            mask (hourlyPredispatch (), 4),
            mask (isAggregatedRes (), 5),
            mask (lastModified (), 6),
            mask (marketParticipationFlag (), 7),
            toDouble (mask (maxBaseSelfSchedQty_1 (), 8)),
            toDouble (mask (maxOnTime (), 9)),
            toDouble (mask (minDispatchTime (), 10)),
            toDouble (mask (minOffTime (), 11)),
            toDouble (mask (minOnTime (), 12)),
            mask (mustOfferFlag (), 13),
            mask (nonMarket (), 14),
            mask (pointOfDeliveryFlag (), 15),
            mask (priceSetFlagDA (), 16),
            mask (priceSetFlagRT (), 17),
            mask (registrationStatus (), 18),
            mask (resourceAdequacyFlag (), 19),
            mask (ACAFlag (), 20),
            mask (ASSPOptimizationFlag (), 21),
            mask (AdjacentCASet (), 22),
            mask (AggregateNode (), 23),
            masks (AllocationResultValues (), 24),
            masks (Commitments (), 25),
            masks (ContractDistributionFactor (), 26),
            masks (ControlAreaDesignation (), 27),
            mask (DefaultBid (), 28),
            masks (DispatchInstReply (), 29),
            masks (Domain (), 30),
            masks (DopInstruction (), 31),
            masks (DotInstruction (), 32),
            mask (ECAFlag (), 33),
            masks (EnergyMarkets (), 34),
            masks (ExPostResourceResults (), 35),
            masks (ExpectedEnergyValues (), 36),
            masks (ForbiddenRegion (), 37),
            masks (FormerReference (), 38),
            mask (HostControlArea (), 39),
            masks (Instructions (), 40),
            masks (InterTie (), 41),
            masks (IntermittentResourceEligibility (), 42),
            mask (LMPMFlag (), 43),
            masks (LoadFollowingInst (), 44),
            masks (LoadFollowingOperatorInput (), 45),
            masks (MPMResourceStatus (), 46),
            masks (MPMTestThreshold (), 47),
            masks (MarketObjectStatus (), 48),
            mask (MarketParticipant (), 49),
            mask (MktConnectivityNode (), 50),
            masks (OrgResOwnership (), 51),
            mask (Pnode (), 52),
            masks (RMROperatorInput (), 53),
            masks (RUCAwardInstruction (), 54),
            masks (RampRateCurve (), 55),
            masks (Reason (), 56),
            masks (ResourceAncillaryServiceQualification (), 57),
            masks (ResourceAwardInstruction (), 58),
            masks (ResourceCapacity (), 59),
            masks (ResourceCertification (), 60),
            masks (ResourceDispatchResults (), 61),
            masks (ResourceGroups (), 62),
            masks (ResourceLoadFollowingInst (), 63),
            mask (ResourceVerifiableCosts (), 64),
            mask (SMPMFlag (), 65),
            masks (SubControlArea (), 66),
            masks (SubstitutionResourceList (), 67),
            masks (TimeSeries (), 68)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * This class model the various capacities of a resource.
 *
 * A resource may have numbers of capacities related to operating, ancillary services, energy trade and so forth. Capacities may be defined for active power or reactive power.
 *
 * @param sup Reference to the superclass object.
 * @param capacityType capacity type
 *        
 *        The types are but not limited to:
 *        
 *        Regulation Up
 *        Regulation Dn
 *        Spinning Reserve
 *        Non-Spinning Reserve
 *        FOO capacity
 *        MOO capacity
 * @param defaultCapacity default capacity
 * @param maximumCapacity maximum capacity
 * @param minimumCapacity minimum capacity
 * @param unitSymbol Unit selection for the capacity values.
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @group MarketCommon
 * @groupname MarketCommon Package MarketCommon
 * @groupdesc MarketCommon This package contains the common objects shared by MarketManagement, MarketOperations and Environmental packages.
 */
final case class ResourceCapacity
(
    override val sup: BasicElement,
    capacityType: String,
    defaultCapacity: Double,
    maximumCapacity: Double,
    minimumCapacity: Double,
    unitSymbol: String,
    RegisteredResource: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, 0.0, 0.0, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ResourceCapacity] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ResourceCapacity.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ResourceCapacity.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ResourceCapacity.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ResourceCapacity.fields (position), x))
        emitattr (0, capacityType)
        emitelem (1, defaultCapacity)
        emitelem (2, maximumCapacity)
        emitelem (3, minimumCapacity)
        emitattr (4, unitSymbol)
        emitattrs (5, RegisteredResource)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ResourceCapacity rdf:ID=\"%s\">\n%s\t</cim:ResourceCapacity>".format (id, export_fields)
    }
}

object ResourceCapacity
extends
    Parseable[ResourceCapacity]
{
    override val fields: Array[String] = Array[String] (
        "capacityType",
        "defaultCapacity",
        "maximumCapacity",
        "minimumCapacity",
        "unitSymbol",
        "RegisteredResource"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RegisteredResource", "RegisteredResource", "0..*", "0..*")
    )
    val capacityType: Fielder = parse_attribute (attribute (cls, fields(0)))
    val defaultCapacity: Fielder = parse_element (element (cls, fields(1)))
    val maximumCapacity: Fielder = parse_element (element (cls, fields(2)))
    val minimumCapacity: Fielder = parse_element (element (cls, fields(3)))
    val unitSymbol: Fielder = parse_attribute (attribute (cls, fields(4)))
    val RegisteredResource: FielderMultiple = parse_attributes (attribute (cls, fields(5)))

    def parse (context: Context): ResourceCapacity =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ResourceCapacity (
            BasicElement.parse (context),
            mask (capacityType (), 0),
            toDouble (mask (defaultCapacity (), 1)),
            toDouble (mask (maximumCapacity (), 2)),
            toDouble (mask (minimumCapacity (), 3)),
            mask (unitSymbol (), 4),
            masks (RegisteredResource (), 5)
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
            EnvironmentalMonitoringStation.register,
            MarketParticipant.register,
            MarketRole.register,
            MktGeneratingUnit.register,
            RegisteredResource.register,
            ResourceCapacity.register
        )
    }
}