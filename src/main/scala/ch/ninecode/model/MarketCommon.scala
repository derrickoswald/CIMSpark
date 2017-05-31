package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * This package contains the common objects shared by both MarketManagement and MarketOperations packages.
 */

/**
 * An identification of a party acting in a electricity market business process.
 * This class is used to identify organizations that can participate in market management and/or market operations.
 * @param sup Reference to the superclass object.
 * @param MarketDocument
 */
case class MarketParticipant
(
    override val sup: Organisation,
    val MarketDocument: List[String]
)
extends
    Element
{
    def this () = { this (null, List()) }
    def Organisation: Organisation = sup.asInstanceOf[Organisation]
    override def copy (): Row = { return (clone ().asInstanceOf[MarketParticipant]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MarketParticipant
extends
    Parseable[MarketParticipant]
{
    val sup = Organisation.parse _
    val MarketDocument = parse_attributes (attribute ("""MarketParticipant.MarketDocument"""))
    def parse (context: Context): MarketParticipant =
    {
        MarketParticipant(
            sup (context),
            MarketDocument (context)
        )
    }
}

/**
 * The external intended behaviour played by a party within the electricity market.
 * @param sup Reference to the superclass object.
 * @param roleType Defined using an enumerated list of types of market roles for use when a finite list of types are desired.
 * @param status Status of the market role.
 * @param typ The kind of market roles that can be played by parties for given domains within the electricity market.
 *        Types are flexible using dataType of string for free-entry of role types.
 * @param MarketParticipant
 */
case class MarketRole
(
    override val sup: IdentifiedObject,
    val roleType: String,
    val status: String,
    val typ: String,
    val MarketParticipant: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, null, List()) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[MarketRole]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MarketRole
extends
    Parseable[MarketRole]
{
    val sup = IdentifiedObject.parse _
    val roleType = parse_attribute (attribute ("""MarketRole.roleType"""))
    val status = parse_attribute (attribute ("""MarketRole.status"""))
    val typ = parse_element (element ("""MarketRole.type"""))
    val MarketParticipant = parse_attributes (attribute ("""MarketRole.MarketParticipant"""))
    def parse (context: Context): MarketRole =
    {
        MarketRole(
            sup (context),
            roleType (context),
            status (context),
            typ (context),
            MarketParticipant (context)
        )
    }
}

/**
 * Kind of market role an organisation can have.
 * @param sup Reference to the superclass object.
 * @param balancingAuthority Balancing authority.
 * @param competitiveRetailer Competitive retailer.
 * @param complianceMonitor Compliance monitor.
 * @param distributionProvider Distribution provider.
 * @param energyServiceConsumer Energy service consumer.
 * @param generatorOperator Generator merchant operator.
 * @param generatorOwner Generator merchant owner.
 * @param interchangeAuthority Interchange authority.
 * @param loadServingEntity Load serving entity.
 * @param planningAuthority Planning authority.
 * @param purchasingSellingEntity Purchasing selling entity.
 * @param reliabilityAuthority Reliability authority.
 * @param resourcePlanner Resource planner.
 * @param standardsDeveloper Standards developer.
 * @param transmissionOperator Transmission operator.
 * @param transmissionOwner Transmission owner.
 * @param transmissionPlanner Transmission planner.
 * @param transmissionServiceProvider Transmission service provider.
 * @param BalanceResponsibleParty A party that has a contract proving financial security and identifying balance responsibility with the Imbalance Settlement Responsible of the Market Balance Area entitling the party to operate in the market.
 *        This is the only role allowing a party to nominate energy on a wholesale level.
 * @param BalanceSupplier A party that markets the difference between actual metered energy consumption and the energy bought with firm energy contracts by the Party Connected to the Grid.
 *        In addition the Balance Supplier markets any difference with the firm energy contract (of the Party Connected to the Grid) and the metered production.
 * @param BillingAgent The party responsible for invoicing a concerned party.
 * @param BlockEnergyTrader A party that is selling or buying energy on a firm basis (a fixed volume per market time period).
 * @param CapacityCoordinator A party, acting on behalf of the System Operators involved, responsible for establishing a coordinated Offered Capacity and/or Net Transfer Capacity (NTC) and/or Available Transfer Capacity (ATC) between several Market Balance Areas.
 * @param CapacityTrader A party that has a contract to participate in the Capacity Market to acquire capacity through a Transmission Capacity Allocator.
 *        The capacity may be acquired on behalf of an Interconnection Trade Responsible or for sale on secondary capacity markets.
 * @param Consumer A party that consumes electricity.
<b><i>Additional information:</i></b>
 *        This is a Type of Party Connected to the Grid.
 * @param ConsumptionResponsibleParty A party who can be brought to rights, legally and financially, for any imbalance between enegry nominated and consumed for all associated Accounting Points.
<b><i>Additional information:</i></b>
 *        This is a type of Balance Responsible Party.
 * @param ControlAreaOperator Responsible for :
1.
 *        The coordination of exchange programs between its related Market Balance Areas and for the exchanges between its associated Control Areas.
 * @param ControlBlockOperator Responsible for :
1.
 *        The coordination of exchanges between its associated Control Blocks and the organisation of the coordination of exchange programs between its related Control Areas.
 * @param CoordinationCenterOperator Responsible for :
1.
 *        The coordination of exchange programs between its related Control Blocks and for the exchanges between its associated Coordination Center Zones.
 * @param GridAccessProvider A party responsible for providing access to the grid through an Accounting Point and its use for energy consumption or production to the Party Connected to the Grid.
 * @param GridOperator A party that operates one or more grids.
 * @param ImbalanceSettlementResponsible A party that is responsible for settlement of the difference between the contracted quantities and the realised quantities of energy products for the Balance Responsible Parties in a Market Balance Area.
 *        Note:
 * @param InterconnectionTradeResponsible Is a Balance Responsible Party or depends on one.
 *        They are recognized by the Nomination Validator for the nomination of already allocated capacity.
 * @param MOLResponsible Responsible for the management of the available tenders for all Acquiring System Operators to establish the order of the reserve capacity that can be activated.
 * @param MarketInformationAggregator Market Information Aggregator, A party that provides market related information that has been compiled from the figures supplied by different actors in the market.
 *        This information may also be published or distributed for general use.
 * @param MarketOperator The unique power exchange of trades for the actual delivery of energy that receives the bids from the Balance Responsible Parties that have a contract to bid.
 *        The Market Operator determines the market energy price for the Market Balance Area after applying technical constraints from the System Operator. It may also establish the price for the reconciliation within a Metering Grid Area.
 * @param MeterAdministrator A party responsible for keeping a database of meters.
 * @param MeterOperator A party responsible for installing, maintaining, testing, certifying and decommissioning physical meters.
 * @param MeteredDataAggregator A party responsible for the establishment and qualification of metered data from the Metered Data Responsible.
 *        This data is aggregated according to a defined set of market rules.
 * @param MeteredDataCollector A party responsible for meter reading and quality control of the reading.
 * @param MeteredDataResponsible A party responsible for the establishment and validation of metered data based on the collected data received from the Metered Data Collector.
 *        The party is responsible for the history of metered data for a Metering Point.
 * @param MeteringPointAdministrator A party responsible for registering the parties linked to the metering points in a Metering Grid Area.
 *        They are also responsible for maintaining the Metering Point technical specifications. They are responsible for creating and terminating metering points.
 * @param NominationValidator Has the responsibility of ensuring that all capacity nominated is within the allowed limits and confirming all valid nominations to all involved parties.
 *        They inform the Interconnection Trade Responsible of the maximum nominated capacity allowed. Depending on market rules for a given interconnection the corresponding System Operators may appoint one Nomination Validator.
 * @param PartyConnectedToTheGrid A party that contracts for the right to consume or produce electricity at an Accounting Point.
 * @param Producer A party that produces electricity.
<b><i>Additional information:</i></b>
 *        This is a type of Party Connected to the Grid.
 * @param ProductionResponsibleParty A party who can be brought to rights, legally and financially, for any imbalance between energy nominated and produced for all associated Accounting Points.
<b><i>Additional information:</i></b>
 *        This is a type of Balance Responsible Party.
 * @param ReconciliationAccountable A party that is financially accountable for the reconciled volume of energy products for a profiled Accounting Point.
 * @param ReconciliationResponsible A party that is responsible for reconciling, within a Metering Grid Area, the volumes used in the imbalance settlement process for profiled Accounting Points and the actual metered quantities.
 *        Note:
 * @param ReserveAllocator Informs the market of reserve requirements, receives tenders against the requirements and in compliance with the prequalification criteria, determines what tenders meet requirements and assigns tenders.
 * @param ResourceProvider A role that manages a resource object and provides the schedules for it
 * @param SchedulingCoordinator A party that is responsible for the schedule information and its exchange on behalf of a Balance Responsible Party.
 *        For example in the Polish market a Scheduling Coordinator is responsible for information interchange for scheduling and settlement.
 * @param SystemOperator A party that is responsible for a stable power system operation
(including the organisation of physical balance) through a transmission grid in a geographical area.
 *        The System Operator will also determine and be responsible for cross border capacity and exchanges. If necessary they may reduce allocated capacity to ensure operational stability. Transmission as mentioned above means "the transport of electricity on the extra high or high voltage network with a view to its delivery to final customers or to distributors. Operation of transmission includes as well the tasks of system operation concerning its management of energy flows, reliability of the system and availability of all necessary system services." (definition taken from the ENTSO-E RGCE Operation handbook Glossary).
 * @param TradeResponsibleParty A party who can be brought to rights, legally and financially, for any imbalance between energy nominated and consumed for all associated Accounting Points.
<b><i>Note:</i></b>
A power exchange without any privileged responsibilities acts as a Trade Responsible Party.
<b><i>Additional information:</i></b>
 *        This is a type of Balance Responsible Party.
 * @param TransmissionCapacityAllocator Manages the allocation of transmission capacity for an Allocated Capacity Area.
<b><i>For explicit auctions:</i></b>
The Transmission Capacity Allocator manages, on behalf of the System Operators, the allocation of available transmission capacity for an Allocated capacity Area.
 *        They offer the available transmission capacity to the market, allocates the available transmission capacity to individual Capacity Traders and calculates the billing amount of already allocated capacities to the Capacity Traders.
 */
case class MarketRoleKind
(
    override val sup: BasicElement,
    val balancingAuthority: String,
    val competitiveRetailer: String,
    val complianceMonitor: String,
    val distributionProvider: String,
    val energyServiceConsumer: String,
    val generatorOperator: String,
    val generatorOwner: String,
    val interchangeAuthority: String,
    val loadServingEntity: String,
    val planningAuthority: String,
    val purchasingSellingEntity: String,
    val reliabilityAuthority: String,
    val resourcePlanner: String,
    val standardsDeveloper: String,
    val transmissionOperator: String,
    val transmissionOwner: String,
    val transmissionPlanner: String,
    val transmissionServiceProvider: String,
    val BalanceResponsibleParty: String,
    val BalanceSupplier: String,
    val BillingAgent: String,
    val BlockEnergyTrader: String,
    val CapacityCoordinator: String,
    val CapacityTrader: String,
    val Consumer: String,
    val ConsumptionResponsibleParty: String,
    val ControlAreaOperator: String,
    val ControlBlockOperator: String,
    val CoordinationCenterOperator: String,
    val GridAccessProvider: String,
    val GridOperator: String,
    val ImbalanceSettlementResponsible: String,
    val InterconnectionTradeResponsible: String,
    val MOLResponsible: String,
    val MarketInformationAggregator: String,
    val MarketOperator: String,
    val MeterAdministrator: String,
    val MeterOperator: String,
    val MeteredDataAggregator: String,
    val MeteredDataCollector: String,
    val MeteredDataResponsible: String,
    val MeteringPointAdministrator: String,
    val NominationValidator: String,
    val PartyConnectedToTheGrid: String,
    val Producer: String,
    val ProductionResponsibleParty: String,
    val ReconciliationAccountable: String,
    val ReconciliationResponsible: String,
    val ReserveAllocator: String,
    val ResourceProvider: String,
    val SchedulingCoordinator: String,
    val SystemOperator: String,
    val TradeResponsibleParty: String,
    val TransmissionCapacityAllocator: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[MarketRoleKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MarketRoleKind
extends
    Parseable[MarketRoleKind]
{
    val sup = BasicElement.parse _
    val balancingAuthority = parse_attribute (attribute ("""MarketRoleKind.balancingAuthority"""))
    val competitiveRetailer = parse_attribute (attribute ("""MarketRoleKind.competitiveRetailer"""))
    val complianceMonitor = parse_attribute (attribute ("""MarketRoleKind.complianceMonitor"""))
    val distributionProvider = parse_attribute (attribute ("""MarketRoleKind.distributionProvider"""))
    val energyServiceConsumer = parse_attribute (attribute ("""MarketRoleKind.energyServiceConsumer"""))
    val generatorOperator = parse_attribute (attribute ("""MarketRoleKind.generatorOperator"""))
    val generatorOwner = parse_attribute (attribute ("""MarketRoleKind.generatorOwner"""))
    val interchangeAuthority = parse_attribute (attribute ("""MarketRoleKind.interchangeAuthority"""))
    val loadServingEntity = parse_attribute (attribute ("""MarketRoleKind.loadServingEntity"""))
    val planningAuthority = parse_attribute (attribute ("""MarketRoleKind.planningAuthority"""))
    val purchasingSellingEntity = parse_attribute (attribute ("""MarketRoleKind.purchasingSellingEntity"""))
    val reliabilityAuthority = parse_attribute (attribute ("""MarketRoleKind.reliabilityAuthority"""))
    val resourcePlanner = parse_attribute (attribute ("""MarketRoleKind.resourcePlanner"""))
    val standardsDeveloper = parse_attribute (attribute ("""MarketRoleKind.standardsDeveloper"""))
    val transmissionOperator = parse_attribute (attribute ("""MarketRoleKind.transmissionOperator"""))
    val transmissionOwner = parse_attribute (attribute ("""MarketRoleKind.transmissionOwner"""))
    val transmissionPlanner = parse_attribute (attribute ("""MarketRoleKind.transmissionPlanner"""))
    val transmissionServiceProvider = parse_attribute (attribute ("""MarketRoleKind.transmissionServiceProvider"""))
    val BalanceResponsibleParty = parse_attribute (attribute ("""MarketRoleKind.BalanceResponsibleParty"""))
    val BalanceSupplier = parse_attribute (attribute ("""MarketRoleKind.BalanceSupplier"""))
    val BillingAgent = parse_attribute (attribute ("""MarketRoleKind.BillingAgent"""))
    val BlockEnergyTrader = parse_attribute (attribute ("""MarketRoleKind.BlockEnergyTrader"""))
    val CapacityCoordinator = parse_attribute (attribute ("""MarketRoleKind.CapacityCoordinator"""))
    val CapacityTrader = parse_attribute (attribute ("""MarketRoleKind.CapacityTrader"""))
    val Consumer = parse_attribute (attribute ("""MarketRoleKind.Consumer"""))
    val ConsumptionResponsibleParty = parse_attribute (attribute ("""MarketRoleKind.ConsumptionResponsibleParty"""))
    val ControlAreaOperator = parse_attribute (attribute ("""MarketRoleKind.ControlAreaOperator"""))
    val ControlBlockOperator = parse_attribute (attribute ("""MarketRoleKind.ControlBlockOperator"""))
    val CoordinationCenterOperator = parse_attribute (attribute ("""MarketRoleKind.CoordinationCenterOperator"""))
    val GridAccessProvider = parse_attribute (attribute ("""MarketRoleKind.GridAccessProvider"""))
    val GridOperator = parse_attribute (attribute ("""MarketRoleKind.GridOperator"""))
    val ImbalanceSettlementResponsible = parse_attribute (attribute ("""MarketRoleKind.ImbalanceSettlementResponsible"""))
    val InterconnectionTradeResponsible = parse_attribute (attribute ("""MarketRoleKind.InterconnectionTradeResponsible"""))
    val MOLResponsible = parse_attribute (attribute ("""MarketRoleKind.MOLResponsible"""))
    val MarketInformationAggregator = parse_attribute (attribute ("""MarketRoleKind.MarketInformationAggregator"""))
    val MarketOperator = parse_attribute (attribute ("""MarketRoleKind.MarketOperator"""))
    val MeterAdministrator = parse_attribute (attribute ("""MarketRoleKind.MeterAdministrator"""))
    val MeterOperator = parse_attribute (attribute ("""MarketRoleKind.MeterOperator"""))
    val MeteredDataAggregator = parse_attribute (attribute ("""MarketRoleKind.MeteredDataAggregator"""))
    val MeteredDataCollector = parse_attribute (attribute ("""MarketRoleKind.MeteredDataCollector"""))
    val MeteredDataResponsible = parse_attribute (attribute ("""MarketRoleKind.MeteredDataResponsible"""))
    val MeteringPointAdministrator = parse_attribute (attribute ("""MarketRoleKind.MeteringPointAdministrator"""))
    val NominationValidator = parse_attribute (attribute ("""MarketRoleKind.NominationValidator"""))
    val PartyConnectedToTheGrid = parse_attribute (attribute ("""MarketRoleKind.PartyConnectedToTheGrid"""))
    val Producer = parse_attribute (attribute ("""MarketRoleKind.Producer"""))
    val ProductionResponsibleParty = parse_attribute (attribute ("""MarketRoleKind.ProductionResponsibleParty"""))
    val ReconciliationAccountable = parse_attribute (attribute ("""MarketRoleKind.ReconciliationAccountable"""))
    val ReconciliationResponsible = parse_attribute (attribute ("""MarketRoleKind.ReconciliationResponsible"""))
    val ReserveAllocator = parse_attribute (attribute ("""MarketRoleKind.ReserveAllocator"""))
    val ResourceProvider = parse_attribute (attribute ("""MarketRoleKind.ResourceProvider"""))
    val SchedulingCoordinator = parse_attribute (attribute ("""MarketRoleKind.SchedulingCoordinator"""))
    val SystemOperator = parse_attribute (attribute ("""MarketRoleKind.SystemOperator"""))
    val TradeResponsibleParty = parse_attribute (attribute ("""MarketRoleKind.TradeResponsibleParty"""))
    val TransmissionCapacityAllocator = parse_attribute (attribute ("""MarketRoleKind.TransmissionCapacityAllocator"""))
    def parse (context: Context): MarketRoleKind =
    {
        MarketRoleKind(
            sup (context),
            balancingAuthority (context),
            competitiveRetailer (context),
            complianceMonitor (context),
            distributionProvider (context),
            energyServiceConsumer (context),
            generatorOperator (context),
            generatorOwner (context),
            interchangeAuthority (context),
            loadServingEntity (context),
            planningAuthority (context),
            purchasingSellingEntity (context),
            reliabilityAuthority (context),
            resourcePlanner (context),
            standardsDeveloper (context),
            transmissionOperator (context),
            transmissionOwner (context),
            transmissionPlanner (context),
            transmissionServiceProvider (context),
            BalanceResponsibleParty (context),
            BalanceSupplier (context),
            BillingAgent (context),
            BlockEnergyTrader (context),
            CapacityCoordinator (context),
            CapacityTrader (context),
            Consumer (context),
            ConsumptionResponsibleParty (context),
            ControlAreaOperator (context),
            ControlBlockOperator (context),
            CoordinationCenterOperator (context),
            GridAccessProvider (context),
            GridOperator (context),
            ImbalanceSettlementResponsible (context),
            InterconnectionTradeResponsible (context),
            MOLResponsible (context),
            MarketInformationAggregator (context),
            MarketOperator (context),
            MeterAdministrator (context),
            MeterOperator (context),
            MeteredDataAggregator (context),
            MeteredDataCollector (context),
            MeteredDataResponsible (context),
            MeteringPointAdministrator (context),
            NominationValidator (context),
            PartyConnectedToTheGrid (context),
            Producer (context),
            ProductionResponsibleParty (context),
            ReconciliationAccountable (context),
            ReconciliationResponsible (context),
            ReserveAllocator (context),
            ResourceProvider (context),
            SchedulingCoordinator (context),
            SystemOperator (context),
            TradeResponsibleParty (context),
            TransmissionCapacityAllocator (context)
        )
    }
}

/**
 * A resource that is registered through the market participant registration system.
 * Examples include generating unit, load, and non-physical generator or load.
 * @param sup Reference to the superclass object.
 * @param commercialOpDate Resource Commercial Operation Date.
 * @param contingencyAvailFlag contingent operating reserve availiability (Yes/No).
 *        Resource is availiable to participate with capacity in contingency dispatch.
 * @param dispatchFlag Dispatch flag: indicates whether the resource is dispatchable (Y/N)
 *        It is move to the RegisteredResource class for the participating load dispatch purpose
 * @param endEffectiveDate end effective date
 * @param flexibleOfferFlag flexible offer flag (Y/N)
 * @param hourlyPredispatch Indicates need to dispatch before the start of the operating hour.
 *        Only relevent in Real-Time Market. Applies to generation, intertie and participating load resource. Value (Y/N)
 * @param isAggregatedRes a flag to indicate if a resource is an aggregated resource
 * @param lastModified Indication of the last time this item was modified/versioned.
 * @param marketParticipationFlag Market Participation flag: indicates whether the resource participate in the market (Y/N)
 * @param maxBaseSelfSchedQty_1 maximum base self schedule quantity
 * @param maxOnTime maximum on time after start up
 * @param minDispatchTime minimum number of consecutive hours a resource shall be dispatched if bid is accepted
 * @param minOffTime minimum off time after shut  down
 * @param minOnTime minimum on time after start up
 * @param mustOfferFlag Must offer flag: indicates whether the unit is subject to the must offer provisions (Y/N)
 * @param nonMarket Flag to indicate that the Resource is not participating in the Market Operations.
 * @param pointOfDeliveryFlag Indication that the registered resource is a Point of Delivery (YES) resource which implies there is a POD Loss Factor.
 * @param priceSetFlagDA Price setting flag: indicates whether a resource is capable of setting the Market Clearing Price (Y) for the DA market, and if not, indicates whether the resource shall submit bids for energy at $ 0 (S) or not (N)

Initially in the RegisteredGenerator class.
 *        It wasmove to the RegisteredResource class for the participating load dispatch purpose
 * @param priceSetFlagRT Price setting flag: indicates whether a resource is capable of setting the Market Clearing Price (Y) for the RT market, and if not, indicates whether the resource shall submit bids for energy at $ 0 (S) or not (N)

Initially in the RegisteredGenerator class.
 *        It wasmove to the RegisteredResource class for the participating load dispatch purpose
 * @param registrationStatus Registration Status of resource - Active, Mothballed, Planned, or Decommissioned.
 * @param resourceAdequacyFlag Indication that this resource participates inthe resource adequacy function.
 * @param startEffectiveDate start effective date
 * @param ACAFlag Indication that this resource is associated with an Adjacent Control Area
 * @param ASSPOptimizationFlag Indication that the resource participates in the optimization process by default.
 * @param AdjacentCASet
 * @param AggregateNode
 * @param DefaultBid
 * @param ECAFlag Indication that this resource is associated with an Embedded Control area
 * @param ForbiddenRegion
 * @param HostControlArea
 * @param InterTie
 * @param LMPMFlag LMPM flag: indicates whether the resource is subject to the LMPM test (Yes/No)
 * @param MktConnectivityNode
 * @param MktOrganisation
 * @param Pnode A registered resource injects power at one or more connectivity nodes related to a pnode
 * @param RampRateCurve
 * @param ResourceCapacity
 * @param ResourceCertification
 * @param ResourceVerifiableCosts
 * @param SMPMFlag SMPM flag: indicates whether the resource is subject to the SMPM test (Yes/No)
 * @param SubControlArea
 * @param TimeSeries
 */
case class RegisteredResource
(
    override val sup: PowerSystemResource,
    val commercialOpDate: String,
    val contingencyAvailFlag: String,
    val dispatchFlag: String,
    val endEffectiveDate: String,
    val flexibleOfferFlag: String,
    val hourlyPredispatch: String,
    val isAggregatedRes: String,
    val lastModified: String,
    val marketParticipationFlag: String,
    val maxBaseSelfSchedQty_1: Double,
    val maxOnTime: Double,
    val minDispatchTime: Double,
    val minOffTime: Double,
    val minOnTime: Double,
    val mustOfferFlag: String,
    val nonMarket: String,
    val pointOfDeliveryFlag: String,
    val priceSetFlagDA: String,
    val priceSetFlagRT: String,
    val registrationStatus: String,
    val resourceAdequacyFlag: String,
    val startEffectiveDate: String,
    val ACAFlag: String,
    val ASSPOptimizationFlag: String,
    val AdjacentCASet: String,
    val AggregateNode: List[String],
    val DefaultBid: String,
    val ECAFlag: String,
    val ForbiddenRegion: List[String],
    val HostControlArea: String,
    val InterTie: List[String],
    val LMPMFlag: String,
    val MktConnectivityNode: String,
    val MktOrganisation: String,
    val Pnode: String,
    val RampRateCurve: List[String],
    val ResourceCapacity: List[String],
    val ResourceCertification: List[String],
    val ResourceVerifiableCosts: String,
    val SMPMFlag: String,
    val SubControlArea: List[String],
    val TimeSeries: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, null, null, null, null, null, null, null, null, null, List(), null, null, List(), null, List(), null, null, null, null, List(), List(), List(), null, null, List(), List()) }
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { return (clone ().asInstanceOf[RegisteredResource]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RegisteredResource
extends
    Parseable[RegisteredResource]
{
    val sup = PowerSystemResource.parse _
    val commercialOpDate = parse_element (element ("""RegisteredResource.commercialOpDate"""))
    val contingencyAvailFlag = parse_attribute (attribute ("""RegisteredResource.contingencyAvailFlag"""))
    val dispatchFlag = parse_attribute (attribute ("""RegisteredResource.dispatchFlag"""))
    val endEffectiveDate = parse_element (element ("""RegisteredResource.endEffectiveDate"""))
    val flexibleOfferFlag = parse_attribute (attribute ("""RegisteredResource.flexibleOfferFlag"""))
    val hourlyPredispatch = parse_attribute (attribute ("""RegisteredResource.hourlyPredispatch"""))
    val isAggregatedRes = parse_attribute (attribute ("""RegisteredResource.isAggregatedRes"""))
    val lastModified = parse_element (element ("""RegisteredResource.lastModified"""))
    val marketParticipationFlag = parse_attribute (attribute ("""RegisteredResource.marketParticipationFlag"""))
    val maxBaseSelfSchedQty_1 = parse_element (element ("""RegisteredResource.maxBaseSelfSchedQty """))
    val maxOnTime = parse_element (element ("""RegisteredResource.maxOnTime"""))
    val minDispatchTime = parse_element (element ("""RegisteredResource.minDispatchTime"""))
    val minOffTime = parse_element (element ("""RegisteredResource.minOffTime"""))
    val minOnTime = parse_element (element ("""RegisteredResource.minOnTime"""))
    val mustOfferFlag = parse_attribute (attribute ("""RegisteredResource.mustOfferFlag"""))
    val nonMarket = parse_attribute (attribute ("""RegisteredResource.nonMarket"""))
    val pointOfDeliveryFlag = parse_attribute (attribute ("""RegisteredResource.pointOfDeliveryFlag"""))
    val priceSetFlagDA = parse_attribute (attribute ("""RegisteredResource.priceSetFlagDA"""))
    val priceSetFlagRT = parse_attribute (attribute ("""RegisteredResource.priceSetFlagRT"""))
    val registrationStatus = parse_attribute (attribute ("""RegisteredResource.registrationStatus"""))
    val resourceAdequacyFlag = parse_attribute (attribute ("""RegisteredResource.resourceAdequacyFlag"""))
    val startEffectiveDate = parse_element (element ("""RegisteredResource.startEffectiveDate"""))
    val ACAFlag = parse_attribute (attribute ("""RegisteredResource.ACAFlag"""))
    val ASSPOptimizationFlag = parse_attribute (attribute ("""RegisteredResource.ASSPOptimizationFlag"""))
    val AdjacentCASet = parse_attribute (attribute ("""RegisteredResource.AdjacentCASet"""))
    val AggregateNode = parse_attributes (attribute ("""RegisteredResource.AggregateNode"""))
    val DefaultBid = parse_attribute (attribute ("""RegisteredResource.DefaultBid"""))
    val ECAFlag = parse_attribute (attribute ("""RegisteredResource.ECAFlag"""))
    val ForbiddenRegion = parse_attributes (attribute ("""RegisteredResource.ForbiddenRegion"""))
    val HostControlArea = parse_attribute (attribute ("""RegisteredResource.HostControlArea"""))
    val InterTie = parse_attributes (attribute ("""RegisteredResource.InterTie"""))
    val LMPMFlag = parse_attribute (attribute ("""RegisteredResource.LMPMFlag"""))
    val MktConnectivityNode = parse_attribute (attribute ("""RegisteredResource.MktConnectivityNode"""))
    val MktOrganisation = parse_attribute (attribute ("""RegisteredResource.MktOrganisation"""))
    val Pnode = parse_attribute (attribute ("""RegisteredResource.Pnode"""))
    val RampRateCurve = parse_attributes (attribute ("""RegisteredResource.RampRateCurve"""))
    val ResourceCapacity = parse_attributes (attribute ("""RegisteredResource.ResourceCapacity"""))
    val ResourceCertification = parse_attributes (attribute ("""RegisteredResource.ResourceCertification"""))
    val ResourceVerifiableCosts = parse_attribute (attribute ("""RegisteredResource.ResourceVerifiableCosts"""))
    val SMPMFlag = parse_attribute (attribute ("""RegisteredResource.SMPMFlag"""))
    val SubControlArea = parse_attributes (attribute ("""RegisteredResource.SubControlArea"""))
    val TimeSeries = parse_attributes (attribute ("""RegisteredResource.TimeSeries"""))
    def parse (context: Context): RegisteredResource =
    {
        RegisteredResource(
            sup (context),
            commercialOpDate (context),
            contingencyAvailFlag (context),
            dispatchFlag (context),
            endEffectiveDate (context),
            flexibleOfferFlag (context),
            hourlyPredispatch (context),
            isAggregatedRes (context),
            lastModified (context),
            marketParticipationFlag (context),
            toDouble (maxBaseSelfSchedQty_1 (context), context),
            toDouble (maxOnTime (context), context),
            toDouble (minDispatchTime (context), context),
            toDouble (minOffTime (context), context),
            toDouble (minOnTime (context), context),
            mustOfferFlag (context),
            nonMarket (context),
            pointOfDeliveryFlag (context),
            priceSetFlagDA (context),
            priceSetFlagRT (context),
            registrationStatus (context),
            resourceAdequacyFlag (context),
            startEffectiveDate (context),
            ACAFlag (context),
            ASSPOptimizationFlag (context),
            AdjacentCASet (context),
            AggregateNode (context),
            DefaultBid (context),
            ECAFlag (context),
            ForbiddenRegion (context),
            HostControlArea (context),
            InterTie (context),
            LMPMFlag (context),
            MktConnectivityNode (context),
            MktOrganisation (context),
            Pnode (context),
            RampRateCurve (context),
            ResourceCapacity (context),
            ResourceCertification (context),
            ResourceVerifiableCosts (context),
            SMPMFlag (context),
            SubControlArea (context),
            TimeSeries (context)
        )
    }
}

object _MarketCommon
{
    def register: Unit =
    {
        MarketParticipant.register
        MarketRole.register
        MarketRoleKind.register
        RegisteredResource.register
    }
}