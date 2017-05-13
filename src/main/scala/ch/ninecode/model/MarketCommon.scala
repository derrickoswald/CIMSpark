package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * This package contains the common objects shared by both MarketManagement and MarketOperations packages.
 */

/**
 * An identification of a party acting in a electricity market business process.
 * This class is used to identify organizations that can participate in market management and/or market operations.
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
    val MarketDocument = parse_attributes (attribute ("""MarketParticipant.MarketDocument"""))_
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
 */
case class MarketRole
(

    override val sup: IdentifiedObject,

    /**
     * Defined using an enumerated list of types of market roles for use when a finite list of types are desired.
     */
    val roleType: String,

    /**
     * Status of the market role.
     */
    val status: String,

    /**
     * The kind of market roles that can be played by parties for given domains within the electricity market.
     * Types are flexible using dataType of string for free-entry of role types.
     */
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
    val roleType = parse_attribute (attribute ("""MarketRole.roleType"""))_
    val status = parse_attribute (attribute ("""MarketRole.status"""))_
    val typ = parse_element (element ("""MarketRole.type"""))_
    val MarketParticipant = parse_attributes (attribute ("""MarketRole.MarketParticipant"""))_
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
 */
case class MarketRoleKind
(

    override val sup: BasicElement,

    /**
     * Balancing authority.
     */
    val balancingAuthority: String,

    /**
     * Competitive retailer.
     */
    val competitiveRetailer: String,

    /**
     * Compliance monitor.
     */
    val complianceMonitor: String,

    /**
     * Distribution provider.
     */
    val distributionProvider: String,

    /**
     * Energy service consumer.
     */
    val energyServiceConsumer: String,

    /**
     * Generator merchant operator.
     */
    val generatorOperator: String,

    /**
     * Generator merchant owner.
     */
    val generatorOwner: String,

    /**
     * Interchange authority.
     */
    val interchangeAuthority: String,

    /**
     * Load serving entity.
     */
    val loadServingEntity: String,

    /**
     * Planning authority.
     */
    val planningAuthority: String,

    /**
     * Purchasing selling entity.
     */
    val purchasingSellingEntity: String,

    /**
     * Reliability authority.
     */
    val reliabilityAuthority: String,

    /**
     * Resource planner.
     */
    val resourcePlanner: String,

    /**
     * Standards developer.
     */
    val standardsDeveloper: String,

    /**
     * Transmission operator.
     */
    val transmissionOperator: String,

    /**
     * Transmission owner.
     */
    val transmissionOwner: String,

    /**
     * Transmission planner.
     */
    val transmissionPlanner: String,

    /**
     * Transmission service provider.
     */
    val transmissionServiceProvider: String,

    /**
     * A party that has a contract proving financial security and identifying balance responsibility with the Imbalance Settlement Responsible of the Market Balance Area entitling the party to operate in the market.
     * This is the only role allowing a party to nominate energy on a wholesale level.
     */
    val BalanceResponsibleParty: String,

    /**
     * A party that markets the difference between actual metered energy consumption and the energy bought with firm energy contracts by the Party Connected to the Grid.
     * In addition the Balance Supplier markets any difference with the firm energy contract (of the Party Connected to the Grid) and the metered production.
     */
    val BalanceSupplier: String,

    /**
     * The party responsible for invoicing a concerned party.
     */
    val BillingAgent: String,

    /**
     * A party that is selling or buying energy on a firm basis (a fixed volume per market time period).
     */
    val BlockEnergyTrader: String,

    /**
     * A party, acting on behalf of the System Operators involved, responsible for establishing a coordinated Offered Capacity and/or Net Transfer Capacity (NTC) and/or Available Transfer Capacity (ATC) between several Market Balance Areas.
     */
    val CapacityCoordinator: String,

    /**
     * A party that has a contract to participate in the Capacity Market to acquire capacity through a Transmission Capacity Allocator.
     * The capacity may be acquired on behalf of an Interconnection Trade Responsible or for sale on secondary capacity markets.
     */
    val CapacityTrader: String,

    /**
     * A party that consumes electricity.
    <b><i>Additional information:</i></b>
     * This is a Type of Party Connected to the Grid.
     */
    val Consumer: String,

    /**
     * A party who can be brought to rights, legally and financially, for any imbalance between enegry nominated and consumed for all associated Accounting Points.
    <b><i>Additional information:</i></b>
     * This is a type of Balance Responsible Party.
     */
    val ConsumptionResponsibleParty: String,

    /**
     * Responsible for :
    1.
     * The coordination of exchange programs between its related Market Balance Areas and for the exchanges between its associated Control Areas.
     */
    val ControlAreaOperator: String,

    /**
     * Responsible for :
    1.
     * The coordination of exchanges between its associated Control Blocks and the organisation of the coordination of exchange programs between its related Control Areas.
     */
    val ControlBlockOperator: String,

    /**
     * Responsible for :
    1.
     * The coordination of exchange programs between its related Control Blocks and for the exchanges between its associated Coordination Center Zones.
     */
    val CoordinationCenterOperator: String,

    /**
     * A party responsible for providing access to the grid through an Accounting Point and its use for energy consumption or production to the Party Connected to the Grid.
     */
    val GridAccessProvider: String,

    /**
     * A party that operates one or more grids.
     */
    val GridOperator: String,

    /**
     * A party that is responsible for settlement of the difference between the contracted quantities and the realised quantities of energy products for the Balance Responsible Parties in a Market Balance Area.
     * Note:
     */
    val ImbalanceSettlementResponsible: String,

    /**
     * Is a Balance Responsible Party or depends on one.
     * They are recognized by the Nomination Validator for the nomination of already allocated capacity.
     */
    val InterconnectionTradeResponsible: String,

    /**
     * Responsible for the management of the available tenders for all Acquiring System Operators to establish the order of the reserve capacity that can be activated.
     */
    val MOLResponsible: String,

    /**
     * Market Information Aggregator, A party that provides market related information that has been compiled from the figures supplied by different actors in the market.
     * This information may also be published or distributed for general use.
     */
    val MarketInformationAggregator: String,

    /**
     * The unique power exchange of trades for the actual delivery of energy that receives the bids from the Balance Responsible Parties that have a contract to bid.
     * The Market Operator determines the market energy price for the Market Balance Area after applying technical constraints from the System Operator. It may also establish the price for the reconciliation within a Metering Grid Area.
     */
    val MarketOperator: String,

    /**
     * A party responsible for keeping a database of meters.
     */
    val MeterAdministrator: String,

    /**
     * A party responsible for installing, maintaining, testing, certifying and decommissioning physical meters.
     */
    val MeterOperator: String,

    /**
     * A party responsible for the establishment and qualification of metered data from the Metered Data Responsible.
     * This data is aggregated according to a defined set of market rules.
     */
    val MeteredDataAggregator: String,

    /**
     * A party responsible for meter reading and quality control of the reading.
     */
    val MeteredDataCollector: String,

    /**
     * A party responsible for the establishment and validation of metered data based on the collected data received from the Metered Data Collector.
     * The party is responsible for the history of metered data for a Metering Point.
     */
    val MeteredDataResponsible: String,

    /**
     * A party responsible for registering the parties linked to the metering points in a Metering Grid Area.
     * They are also responsible for maintaining the Metering Point technical specifications. They are responsible for creating and terminating metering points.
     */
    val MeteringPointAdministrator: String,

    /**
     * Has the responsibility of ensuring that all capacity nominated is within the allowed limits and confirming all valid nominations to all involved parties.
     * They inform the Interconnection Trade Responsible of the maximum nominated capacity allowed. Depending on market rules for a given interconnection the corresponding System Operators may appoint one Nomination Validator.
     */
    val NominationValidator: String,

    /**
     * A party that contracts for the right to consume or produce electricity at an Accounting Point.
     */
    val PartyConnectedToTheGrid: String,

    /**
     * A party that produces electricity.
    <b><i>Additional information:</i></b>
     * This is a type of Party Connected to the Grid.
     */
    val Producer: String,

    /**
     * A party who can be brought to rights, legally and financially, for any imbalance between energy nominated and produced for all associated Accounting Points.
    <b><i>Additional information:</i></b>
     * This is a type of Balance Responsible Party.
     */
    val ProductionResponsibleParty: String,

    /**
     * A party that is financially accountable for the reconciled volume of energy products for a profiled Accounting Point.
     */
    val ReconciliationAccountable: String,

    /**
     * A party that is responsible for reconciling, within a Metering Grid Area, the volumes used in the imbalance settlement process for profiled Accounting Points and the actual metered quantities.
     * Note:
     */
    val ReconciliationResponsible: String,

    /**
     * Informs the market of reserve requirements, receives tenders against the requirements and in compliance with the prequalification criteria, determines what tenders meet requirements and assigns tenders.
     */
    val ReserveAllocator: String,

    /**
     * A role that manages a resource object and provides the schedules for it
     */
    val ResourceProvider: String,

    /**
     * A party that is responsible for the schedule information and its exchange on behalf of a Balance Responsible Party.
     * For example in the Polish market a Scheduling Coordinator is responsible for information interchange for scheduling and settlement.
     */
    val SchedulingCoordinator: String,

    /**
     * A party that is responsible for a stable power system operation
    (including the organisation of physical balance) through a transmission grid in a geographical area.
     * The System Operator will also determine and be responsible for cross border capacity and exchanges. If necessary they may reduce allocated capacity to ensure operational stability. Transmission as mentioned above means "the transport of electricity on the extra high or high voltage network with a view to its delivery to final customers or to distributors. Operation of transmission includes as well the tasks of system operation concerning its management of energy flows, reliability of the system and availability of all necessary system services." (definition taken from the ENTSO-E RGCE Operation handbook Glossary).
     */
    val SystemOperator: String,

    /**
     * A party who can be brought to rights, legally and financially, for any imbalance between energy nominated and consumed for all associated Accounting Points.
    <b><i>Note:</i></b>
    A power exchange without any privileged responsibilities acts as a Trade Responsible Party.
    <b><i>Additional information:</i></b>
     * This is a type of Balance Responsible Party.
     */
    val TradeResponsibleParty: String,

    /**
     * Manages the allocation of transmission capacity for an Allocated Capacity Area.
    <b><i>For explicit auctions:</i></b>
    The Transmission Capacity Allocator manages, on behalf of the System Operators, the allocation of available transmission capacity for an Allocated capacity Area.
     * They offer the available transmission capacity to the market, allocates the available transmission capacity to individual Capacity Traders and calculates the billing amount of already allocated capacities to the Capacity Traders.
     */
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
    val balancingAuthority = parse_attribute (attribute ("""MarketRoleKind.balancingAuthority"""))_
    val competitiveRetailer = parse_attribute (attribute ("""MarketRoleKind.competitiveRetailer"""))_
    val complianceMonitor = parse_attribute (attribute ("""MarketRoleKind.complianceMonitor"""))_
    val distributionProvider = parse_attribute (attribute ("""MarketRoleKind.distributionProvider"""))_
    val energyServiceConsumer = parse_attribute (attribute ("""MarketRoleKind.energyServiceConsumer"""))_
    val generatorOperator = parse_attribute (attribute ("""MarketRoleKind.generatorOperator"""))_
    val generatorOwner = parse_attribute (attribute ("""MarketRoleKind.generatorOwner"""))_
    val interchangeAuthority = parse_attribute (attribute ("""MarketRoleKind.interchangeAuthority"""))_
    val loadServingEntity = parse_attribute (attribute ("""MarketRoleKind.loadServingEntity"""))_
    val planningAuthority = parse_attribute (attribute ("""MarketRoleKind.planningAuthority"""))_
    val purchasingSellingEntity = parse_attribute (attribute ("""MarketRoleKind.purchasingSellingEntity"""))_
    val reliabilityAuthority = parse_attribute (attribute ("""MarketRoleKind.reliabilityAuthority"""))_
    val resourcePlanner = parse_attribute (attribute ("""MarketRoleKind.resourcePlanner"""))_
    val standardsDeveloper = parse_attribute (attribute ("""MarketRoleKind.standardsDeveloper"""))_
    val transmissionOperator = parse_attribute (attribute ("""MarketRoleKind.transmissionOperator"""))_
    val transmissionOwner = parse_attribute (attribute ("""MarketRoleKind.transmissionOwner"""))_
    val transmissionPlanner = parse_attribute (attribute ("""MarketRoleKind.transmissionPlanner"""))_
    val transmissionServiceProvider = parse_attribute (attribute ("""MarketRoleKind.transmissionServiceProvider"""))_
    val BalanceResponsibleParty = parse_attribute (attribute ("""MarketRoleKind.BalanceResponsibleParty"""))_
    val BalanceSupplier = parse_attribute (attribute ("""MarketRoleKind.BalanceSupplier"""))_
    val BillingAgent = parse_attribute (attribute ("""MarketRoleKind.BillingAgent"""))_
    val BlockEnergyTrader = parse_attribute (attribute ("""MarketRoleKind.BlockEnergyTrader"""))_
    val CapacityCoordinator = parse_attribute (attribute ("""MarketRoleKind.CapacityCoordinator"""))_
    val CapacityTrader = parse_attribute (attribute ("""MarketRoleKind.CapacityTrader"""))_
    val Consumer = parse_attribute (attribute ("""MarketRoleKind.Consumer"""))_
    val ConsumptionResponsibleParty = parse_attribute (attribute ("""MarketRoleKind.ConsumptionResponsibleParty"""))_
    val ControlAreaOperator = parse_attribute (attribute ("""MarketRoleKind.ControlAreaOperator"""))_
    val ControlBlockOperator = parse_attribute (attribute ("""MarketRoleKind.ControlBlockOperator"""))_
    val CoordinationCenterOperator = parse_attribute (attribute ("""MarketRoleKind.CoordinationCenterOperator"""))_
    val GridAccessProvider = parse_attribute (attribute ("""MarketRoleKind.GridAccessProvider"""))_
    val GridOperator = parse_attribute (attribute ("""MarketRoleKind.GridOperator"""))_
    val ImbalanceSettlementResponsible = parse_attribute (attribute ("""MarketRoleKind.ImbalanceSettlementResponsible"""))_
    val InterconnectionTradeResponsible = parse_attribute (attribute ("""MarketRoleKind.InterconnectionTradeResponsible"""))_
    val MOLResponsible = parse_attribute (attribute ("""MarketRoleKind.MOLResponsible"""))_
    val MarketInformationAggregator = parse_attribute (attribute ("""MarketRoleKind.MarketInformationAggregator"""))_
    val MarketOperator = parse_attribute (attribute ("""MarketRoleKind.MarketOperator"""))_
    val MeterAdministrator = parse_attribute (attribute ("""MarketRoleKind.MeterAdministrator"""))_
    val MeterOperator = parse_attribute (attribute ("""MarketRoleKind.MeterOperator"""))_
    val MeteredDataAggregator = parse_attribute (attribute ("""MarketRoleKind.MeteredDataAggregator"""))_
    val MeteredDataCollector = parse_attribute (attribute ("""MarketRoleKind.MeteredDataCollector"""))_
    val MeteredDataResponsible = parse_attribute (attribute ("""MarketRoleKind.MeteredDataResponsible"""))_
    val MeteringPointAdministrator = parse_attribute (attribute ("""MarketRoleKind.MeteringPointAdministrator"""))_
    val NominationValidator = parse_attribute (attribute ("""MarketRoleKind.NominationValidator"""))_
    val PartyConnectedToTheGrid = parse_attribute (attribute ("""MarketRoleKind.PartyConnectedToTheGrid"""))_
    val Producer = parse_attribute (attribute ("""MarketRoleKind.Producer"""))_
    val ProductionResponsibleParty = parse_attribute (attribute ("""MarketRoleKind.ProductionResponsibleParty"""))_
    val ReconciliationAccountable = parse_attribute (attribute ("""MarketRoleKind.ReconciliationAccountable"""))_
    val ReconciliationResponsible = parse_attribute (attribute ("""MarketRoleKind.ReconciliationResponsible"""))_
    val ReserveAllocator = parse_attribute (attribute ("""MarketRoleKind.ReserveAllocator"""))_
    val ResourceProvider = parse_attribute (attribute ("""MarketRoleKind.ResourceProvider"""))_
    val SchedulingCoordinator = parse_attribute (attribute ("""MarketRoleKind.SchedulingCoordinator"""))_
    val SystemOperator = parse_attribute (attribute ("""MarketRoleKind.SystemOperator"""))_
    val TradeResponsibleParty = parse_attribute (attribute ("""MarketRoleKind.TradeResponsibleParty"""))_
    val TransmissionCapacityAllocator = parse_attribute (attribute ("""MarketRoleKind.TransmissionCapacityAllocator"""))_
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
 */
case class RegisteredResource
(

    override val sup: PowerSystemResource,

    /**
     * Resource Commercial Operation Date.
     */
    val commercialOpDate: String,

    /**
     * contingent operating reserve availiability (Yes/No).
     * Resource is availiable to participate with capacity in contingency dispatch.
     */
    val contingencyAvailFlag: String,

    /**
     * Dispatch flag: indicates whether the resource is dispatchable (Y/N)
     * It is move to the RegisteredResource class for the participating load dispatch purpose
     */
    val dispatchFlag: String,

    /**
     * end effective date
     */
    val endEffectiveDate: String,

    /**
     * flexible offer flag (Y/N)
     */
    val flexibleOfferFlag: String,

    /**
     * Indicates need to dispatch before the start of the operating hour.
     * Only relevent in Real-Time Market. Applies to generation, intertie and participating load resource. Value (Y/N)
     */
    val hourlyPredispatch: String,

    /**
     * a flag to indicate if a resource is an aggregated resource
     */
    val isAggregatedRes: String,

    /**
     * Indication of the last time this item was modified/versioned.
     */
    val lastModified: String,

    /**
     * Market Participation flag: indicates whether the resource participate in the market (Y/N)
     */
    val marketParticipationFlag: String,

    /**
     * maximum base self schedule quantity
     */
    val maxBaseSelfSchedQty_1: Double,

    /**
     * maximum on time after start up
     */
    val maxOnTime: Double,

    /**
     * minimum number of consecutive hours a resource shall be dispatched if bid is accepted
     */
    val minDispatchTime: Double,

    /**
     * minimum off time after shut  down
     */
    val minOffTime: Double,

    /**
     * minimum on time after start up
     */
    val minOnTime: Double,

    /**
     * Must offer flag: indicates whether the unit is subject to the must offer provisions (Y/N)
     */
    val mustOfferFlag: String,

    /**
     * Flag to indicate that the Resource is not participating in the Market Operations.
     */
    val nonMarket: String,

    /**
     * Indication that the registered resource is a Point of Delivery (YES) resource which implies there is a POD Loss Factor.
     */
    val pointOfDeliveryFlag: String,

    /**
     * Price setting flag: indicates whether a resource is capable of setting the Market Clearing Price (Y) for the DA market, and if not, indicates whether the resource shall submit bids for energy at $ 0 (S) or not (N)
    
    Initially in the RegisteredGenerator class.
     * It wasmove to the RegisteredResource class for the participating load dispatch purpose
     */
    val priceSetFlagDA: String,

    /**
     * Price setting flag: indicates whether a resource is capable of setting the Market Clearing Price (Y) for the RT market, and if not, indicates whether the resource shall submit bids for energy at $ 0 (S) or not (N)
    
    Initially in the RegisteredGenerator class.
     * It wasmove to the RegisteredResource class for the participating load dispatch purpose
     */
    val priceSetFlagRT: String,

    /**
     * Registration Status of resource - Active, Mothballed, Planned, or Decommissioned.
     */
    val registrationStatus: String,

    /**
     * Indication that this resource participates inthe resource adequacy function.
     */
    val resourceAdequacyFlag: String,

    /**
     * start effective date
     */
    val startEffectiveDate: String,

    /**
     * Indication that this resource is associated with an Adjacent Control Area
     */
    val ACAFlag: String,

    /**
     * Indication that the resource participates in the optimization process by default.
     */
    val ASSPOptimizationFlag: String,

    val AdjacentCASet: String,

    val AggregateNode: List[String],

    val DefaultBid: String,

    /**
     * Indication that this resource is associated with an Embedded Control area
     */
    val ECAFlag: String,

    val ForbiddenRegion: List[String],

    val HostControlArea: String,

    val InterTie: List[String],

    /**
     * LMPM flag: indicates whether the resource is subject to the LMPM test (Yes/No)
     */
    val LMPMFlag: String,

    val MktConnectivityNode: String,

    val MktOrganisation: String,

    /**
     * A registered resource injects power at one or more connectivity nodes related to a pnode
     */
    val Pnode: String,

    val RampRateCurve: List[String],

    val ResourceCapacity: List[String],

    val ResourceCertification: List[String],

    val ResourceVerifiableCosts: String,

    /**
     * SMPM flag: indicates whether the resource is subject to the SMPM test (Yes/No)
     */
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
    val commercialOpDate = parse_element (element ("""RegisteredResource.commercialOpDate"""))_
    val contingencyAvailFlag = parse_attribute (attribute ("""RegisteredResource.contingencyAvailFlag"""))_
    val dispatchFlag = parse_attribute (attribute ("""RegisteredResource.dispatchFlag"""))_
    val endEffectiveDate = parse_element (element ("""RegisteredResource.endEffectiveDate"""))_
    val flexibleOfferFlag = parse_attribute (attribute ("""RegisteredResource.flexibleOfferFlag"""))_
    val hourlyPredispatch = parse_attribute (attribute ("""RegisteredResource.hourlyPredispatch"""))_
    val isAggregatedRes = parse_attribute (attribute ("""RegisteredResource.isAggregatedRes"""))_
    val lastModified = parse_element (element ("""RegisteredResource.lastModified"""))_
    val marketParticipationFlag = parse_attribute (attribute ("""RegisteredResource.marketParticipationFlag"""))_
    val maxBaseSelfSchedQty_1 = parse_element (element ("""RegisteredResource.maxBaseSelfSchedQty """))_
    val maxOnTime = parse_element (element ("""RegisteredResource.maxOnTime"""))_
    val minDispatchTime = parse_element (element ("""RegisteredResource.minDispatchTime"""))_
    val minOffTime = parse_element (element ("""RegisteredResource.minOffTime"""))_
    val minOnTime = parse_element (element ("""RegisteredResource.minOnTime"""))_
    val mustOfferFlag = parse_attribute (attribute ("""RegisteredResource.mustOfferFlag"""))_
    val nonMarket = parse_attribute (attribute ("""RegisteredResource.nonMarket"""))_
    val pointOfDeliveryFlag = parse_attribute (attribute ("""RegisteredResource.pointOfDeliveryFlag"""))_
    val priceSetFlagDA = parse_attribute (attribute ("""RegisteredResource.priceSetFlagDA"""))_
    val priceSetFlagRT = parse_attribute (attribute ("""RegisteredResource.priceSetFlagRT"""))_
    val registrationStatus = parse_attribute (attribute ("""RegisteredResource.registrationStatus"""))_
    val resourceAdequacyFlag = parse_attribute (attribute ("""RegisteredResource.resourceAdequacyFlag"""))_
    val startEffectiveDate = parse_element (element ("""RegisteredResource.startEffectiveDate"""))_
    val ACAFlag = parse_attribute (attribute ("""RegisteredResource.ACAFlag"""))_
    val ASSPOptimizationFlag = parse_attribute (attribute ("""RegisteredResource.ASSPOptimizationFlag"""))_
    val AdjacentCASet = parse_attribute (attribute ("""RegisteredResource.AdjacentCASet"""))_
    val AggregateNode = parse_attributes (attribute ("""RegisteredResource.AggregateNode"""))_
    val DefaultBid = parse_attribute (attribute ("""RegisteredResource.DefaultBid"""))_
    val ECAFlag = parse_attribute (attribute ("""RegisteredResource.ECAFlag"""))_
    val ForbiddenRegion = parse_attributes (attribute ("""RegisteredResource.ForbiddenRegion"""))_
    val HostControlArea = parse_attribute (attribute ("""RegisteredResource.HostControlArea"""))_
    val InterTie = parse_attributes (attribute ("""RegisteredResource.InterTie"""))_
    val LMPMFlag = parse_attribute (attribute ("""RegisteredResource.LMPMFlag"""))_
    val MktConnectivityNode = parse_attribute (attribute ("""RegisteredResource.MktConnectivityNode"""))_
    val MktOrganisation = parse_attribute (attribute ("""RegisteredResource.MktOrganisation"""))_
    val Pnode = parse_attribute (attribute ("""RegisteredResource.Pnode"""))_
    val RampRateCurve = parse_attributes (attribute ("""RegisteredResource.RampRateCurve"""))_
    val ResourceCapacity = parse_attributes (attribute ("""RegisteredResource.ResourceCapacity"""))_
    val ResourceCertification = parse_attributes (attribute ("""RegisteredResource.ResourceCertification"""))_
    val ResourceVerifiableCosts = parse_attribute (attribute ("""RegisteredResource.ResourceVerifiableCosts"""))_
    val SMPMFlag = parse_attribute (attribute ("""RegisteredResource.SMPMFlag"""))_
    val SubControlArea = parse_attributes (attribute ("""RegisteredResource.SubControlArea"""))_
    val TimeSeries = parse_attributes (attribute ("""RegisteredResource.TimeSeries"""))_
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