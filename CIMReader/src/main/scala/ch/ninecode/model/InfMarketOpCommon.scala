package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Kind of market role an organisation can have.
 *
 * This list is not exhausted, as other roles may exist.
 *
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
 *        <b><i>Additional information:</i></b>
 *        The meaning of the word "balance" in this context signifies that the quantity contracted to provide or to consume shall be equal to the quantity really provided or consumed. Equivalent to "Program responsible party" in the Netherlands. Equivalent to "Balance group manager" in Germany. Equivalent to "market agent" in Spain.
 * @param BalanceSupplier A party that markets the difference between actual metered energy consumption and the energy bought with firm energy contracts by the Party Connected to the Grid.
 *        In addition the Balance Supplier markets any difference with the firm energy contract (of the Party Connected to the Grid) and the metered production.
 *        <b><i>Additional information:</i></b>
 *        There is only one Balance Supplier for each Accounting Point.
 * @param BillingAgent The party responsible for invoicing a concerned party.
 * @param BlockEnergyTrader A party that is selling or buying energy on a firm basis (a fixed volume per market time period).
 * @param CapacityCoordinator A party, acting on behalf of the System Operators involved, responsible for establishing a coordinated Offered Capacity and/or Net Transfer Capacity (NTC) and/or Available Transfer Capacity (ATC) between several Market Balance Areas.
 * @param CapacityTrader A party that has a contract to participate in the Capacity Market to acquire capacity through a Transmission Capacity Allocator.
 *        The capacity may be acquired on behalf of an Interconnection Trade Responsible or for sale on secondary capacity markets.
 * @param Consumer A party that consumes electricity.
 *        <b><i>Additional information:</i></b>
 *        This is a Type of Party Connected to the Grid.
 * @param ConsumptionResponsibleParty A party who can be brought to rights, legally and financially, for any imbalance between enegry nominated and consumed for all associated Accounting Points.
 *        <b><i>Additional information:</i></b>
 *        This is a type of Balance Responsible Party.
 * @param ControlAreaOperator Responsible for :
 *        1.
 *        The coordination of exchange programs between its related Market Balance Areas and for the exchanges between its associated Control Areas.
 *        2. The load frequency control for its own area.
 *        3. The coordination of the correction of time deviations.
 * @param ControlBlockOperator Responsible for :
 *        1.
 *        The coordination of exchanges between its associated Control Blocks and the organisation of the coordination of exchange programs between its related Control Areas.
 *        2. The load frequency control within its own block and ensuring that its Control Areas respect their obligations in respect to load frequency control and time deviation.
 *        3. The organisation of the settlement and/or compensation between its Control Areas.
 * @param CoordinationCenterOperator Responsible for :
 *        1.
 *        The coordination of exchange programs between its related Control Blocks and for the exchanges between its associated Coordination Center Zones.
 *        2. Ensuring that its Control Blocks respect their obligations in respect to load frequency control.
 *        3. Calculating the time deviation in cooperation with the associated coordination centers.
 *        4. Carrying out the settlement and/or compensation between its Control Blocks and against the other Coordination Center Zones.
 * @param GridAccessProvider A party responsible for providing access to the grid through an Accounting Point and its use for energy consumption or production to the Party Connected to the Grid.
 * @param GridOperator A party that operates one or more grids.
 * @param ImbalanceSettlementResponsible A party that is responsible for settlement of the difference between the contracted quantities and the realised quantities of energy products for the Balance Responsible Parties in a Market Balance Area.
 *        Note:
 *        The Imbalance Settlement Responsible has not the responsibility to invoice. The Imbalance Settlement Responsible may delegate the invoicing responsibility to a more generic role such as a Billing Agent.
 * @param InterconnectionTradeResponsible Is a Balance Responsible Party or depends on one.
 *        They are recognized by the Nomination Validator for the nomination of already allocated capacity.
 *        <b><i>Additional information:</i></b>
 *        This is a type of Balance Responsible Party.
 * @param MOLResponsible Responsible for the management of the available tenders for all Acquiring System Operators to establish the order of the reserve capacity that can be activated.
 * @param MarketInformationAggregator Market Information Aggregator, A party that provides market related information that has been compiled from the figures supplied by different actors in the market.
 *        This information may also be published or distributed for general use.
 *        <b><i>Note:</i></b>
 *        The Market Information Aggregator may receive information from any market participant that is relevant for publication or distribution.
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
 *        <b><i>Additional information:</i></b>
 *        This is a type of Party Connected to the Grid.
 * @param ProductionResponsibleParty A party who can be brought to rights, legally and financially, for any imbalance between energy nominated and produced for all associated Accounting Points.
 *        <b><i>Additional information:</i></b>
 *        This is a type of Balance Responsible Party.
 * @param ReconciliationAccountable A party that is financially accountable for the reconciled volume of energy products for a profiled Accounting Point.
 * @param ReconciliationResponsible A party that is responsible for reconciling, within a Metering Grid Area, the volumes used in the imbalance settlement process for profiled Accounting Points and the actual metered quantities.
 *        Note:
 *        The Reconciliation Responsible may delegate the invoicing responsibility to a more generic role such as a Billing Agent.
 * @param ReserveAllocator Informs the market of reserve requirements, receives tenders against the requirements and in compliance with the prequalification criteria, determines what tenders meet requirements and assigns tenders.
 * @param ResourceProvider A role that manages a resource object and provides the schedules for it
 * @param SchedulingCoordinator A party that is responsible for the schedule information and its exchange on behalf of a Balance Responsible Party.
 *        For example in the Polish market a Scheduling Coordinator is responsible for information interchange for scheduling and settlement.
 * @param SystemOperator A party that is responsible for a stable power system operation
 *        (including the organisation of physical balance) through a transmission grid in a geographical area.
 *        The System Operator will also determine and be responsible for cross border capacity and exchanges. If necessary they may reduce allocated capacity to ensure operational stability. Transmission as mentioned above means "the transport of electricity on the extra high or high voltage network with a view to its delivery to final customers or to distributors. Operation of transmission includes as well the tasks of system operation concerning its management of energy flows, reliability of the system and availability of all necessary system services." (definition taken from the ENTSO-E RGCE Operation handbook Glossary).
 *        <b><i>Note: </i></b>additional obligations may be imposed through local market rules.
 * @param TradeResponsibleParty A party who can be brought to rights, legally and financially, for any imbalance between energy nominated and consumed for all associated Accounting Points.
 *        <b><i>Note:</i></b>
 *        A power exchange without any privileged responsibilities acts as a Trade Responsible Party.
 *        <b><i>Additional information:</i></b>
 *        This is a type of Balance Responsible Party.
 * @param TransmissionCapacityAllocator Manages the allocation of transmission capacity for an Allocated Capacity Area.
 *        <b><i>For explicit auctions:</i></b>
 *        The Transmission Capacity Allocator manages, on behalf of the System Operators, the allocation of available transmission capacity for an Allocated capacity Area.
 *        They offer the available transmission capacity to the market, allocates the available transmission capacity to individual Capacity Traders and calculates the billing amount of already allocated capacities to the Capacity Traders.
 * @group InfMarketOpCommon
 * @groupname InfMarketOpCommon Package InfMarketOpCommon
 */
final case class MarketRoleKind
(
    override val sup: BasicElement = null,
    balancingAuthority: String = null,
    competitiveRetailer: String = null,
    complianceMonitor: String = null,
    distributionProvider: String = null,
    energyServiceConsumer: String = null,
    generatorOperator: String = null,
    generatorOwner: String = null,
    interchangeAuthority: String = null,
    loadServingEntity: String = null,
    planningAuthority: String = null,
    purchasingSellingEntity: String = null,
    reliabilityAuthority: String = null,
    resourcePlanner: String = null,
    standardsDeveloper: String = null,
    transmissionOperator: String = null,
    transmissionOwner: String = null,
    transmissionPlanner: String = null,
    transmissionServiceProvider: String = null,
    BalanceResponsibleParty: String = null,
    BalanceSupplier: String = null,
    BillingAgent: String = null,
    BlockEnergyTrader: String = null,
    CapacityCoordinator: String = null,
    CapacityTrader: String = null,
    Consumer: String = null,
    ConsumptionResponsibleParty: String = null,
    ControlAreaOperator: String = null,
    ControlBlockOperator: String = null,
    CoordinationCenterOperator: String = null,
    GridAccessProvider: String = null,
    GridOperator: String = null,
    ImbalanceSettlementResponsible: String = null,
    InterconnectionTradeResponsible: String = null,
    MOLResponsible: String = null,
    MarketInformationAggregator: String = null,
    MarketOperator: String = null,
    MeterAdministrator: String = null,
    MeterOperator: String = null,
    MeteredDataAggregator: String = null,
    MeteredDataCollector: String = null,
    MeteredDataResponsible: String = null,
    MeteringPointAdministrator: String = null,
    NominationValidator: String = null,
    PartyConnectedToTheGrid: String = null,
    Producer: String = null,
    ProductionResponsibleParty: String = null,
    ReconciliationAccountable: String = null,
    ReconciliationResponsible: String = null,
    ReserveAllocator: String = null,
    ResourceProvider: String = null,
    SchedulingCoordinator: String = null,
    SystemOperator: String = null,
    TradeResponsibleParty: String = null,
    TransmissionCapacityAllocator: String = null
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
    def  Element: Element = sup.asInstanceOf[Element]
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
        implicit val clz: String = MarketRoleKind.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MarketRoleKind.fields (position), value)
        emitattr (0, balancingAuthority)
        emitattr (1, competitiveRetailer)
        emitattr (2, complianceMonitor)
        emitattr (3, distributionProvider)
        emitattr (4, energyServiceConsumer)
        emitattr (5, generatorOperator)
        emitattr (6, generatorOwner)
        emitattr (7, interchangeAuthority)
        emitattr (8, loadServingEntity)
        emitattr (9, planningAuthority)
        emitattr (10, purchasingSellingEntity)
        emitattr (11, reliabilityAuthority)
        emitattr (12, resourcePlanner)
        emitattr (13, standardsDeveloper)
        emitattr (14, transmissionOperator)
        emitattr (15, transmissionOwner)
        emitattr (16, transmissionPlanner)
        emitattr (17, transmissionServiceProvider)
        emitattr (18, BalanceResponsibleParty)
        emitattr (19, BalanceSupplier)
        emitattr (20, BillingAgent)
        emitattr (21, BlockEnergyTrader)
        emitattr (22, CapacityCoordinator)
        emitattr (23, CapacityTrader)
        emitattr (24, Consumer)
        emitattr (25, ConsumptionResponsibleParty)
        emitattr (26, ControlAreaOperator)
        emitattr (27, ControlBlockOperator)
        emitattr (28, CoordinationCenterOperator)
        emitattr (29, GridAccessProvider)
        emitattr (30, GridOperator)
        emitattr (31, ImbalanceSettlementResponsible)
        emitattr (32, InterconnectionTradeResponsible)
        emitattr (33, MOLResponsible)
        emitattr (34, MarketInformationAggregator)
        emitattr (35, MarketOperator)
        emitattr (36, MeterAdministrator)
        emitattr (37, MeterOperator)
        emitattr (38, MeteredDataAggregator)
        emitattr (39, MeteredDataCollector)
        emitattr (40, MeteredDataResponsible)
        emitattr (41, MeteringPointAdministrator)
        emitattr (42, NominationValidator)
        emitattr (43, PartyConnectedToTheGrid)
        emitattr (44, Producer)
        emitattr (45, ProductionResponsibleParty)
        emitattr (46, ReconciliationAccountable)
        emitattr (47, ReconciliationResponsible)
        emitattr (48, ReserveAllocator)
        emitattr (49, ResourceProvider)
        emitattr (50, SchedulingCoordinator)
        emitattr (51, SystemOperator)
        emitattr (52, TradeResponsibleParty)
        emitattr (53, TransmissionCapacityAllocator)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MarketRoleKind rdf:ID=\"%s\">\n%s\t</cim:MarketRoleKind>".format (id, export_fields)
    }
}

object MarketRoleKind
extends
    Parseable[MarketRoleKind]
{
    override val fields: Array[String] = Array[String] (
        "balancingAuthority",
        "competitiveRetailer",
        "complianceMonitor",
        "distributionProvider",
        "energyServiceConsumer",
        "generatorOperator",
        "generatorOwner",
        "interchangeAuthority",
        "loadServingEntity",
        "planningAuthority",
        "purchasingSellingEntity",
        "reliabilityAuthority",
        "resourcePlanner",
        "standardsDeveloper",
        "transmissionOperator",
        "transmissionOwner",
        "transmissionPlanner",
        "transmissionServiceProvider",
        "BalanceResponsibleParty",
        "BalanceSupplier",
        "BillingAgent",
        "BlockEnergyTrader",
        "CapacityCoordinator",
        "CapacityTrader",
        "Consumer",
        "ConsumptionResponsibleParty",
        "ControlAreaOperator",
        "ControlBlockOperator",
        "CoordinationCenterOperator",
        "GridAccessProvider",
        "GridOperator",
        "ImbalanceSettlementResponsible",
        "InterconnectionTradeResponsible",
        "MOLResponsible",
        "MarketInformationAggregator",
        "MarketOperator",
        "MeterAdministrator",
        "MeterOperator",
        "MeteredDataAggregator",
        "MeteredDataCollector",
        "MeteredDataResponsible",
        "MeteringPointAdministrator",
        "NominationValidator",
        "PartyConnectedToTheGrid",
        "Producer",
        "ProductionResponsibleParty",
        "ReconciliationAccountable",
        "ReconciliationResponsible",
        "ReserveAllocator",
        "ResourceProvider",
        "SchedulingCoordinator",
        "SystemOperator",
        "TradeResponsibleParty",
        "TransmissionCapacityAllocator"
    )
    val balancingAuthority: Fielder = parse_attribute (attribute (cls, fields(0)))
    val competitiveRetailer: Fielder = parse_attribute (attribute (cls, fields(1)))
    val complianceMonitor: Fielder = parse_attribute (attribute (cls, fields(2)))
    val distributionProvider: Fielder = parse_attribute (attribute (cls, fields(3)))
    val energyServiceConsumer: Fielder = parse_attribute (attribute (cls, fields(4)))
    val generatorOperator: Fielder = parse_attribute (attribute (cls, fields(5)))
    val generatorOwner: Fielder = parse_attribute (attribute (cls, fields(6)))
    val interchangeAuthority: Fielder = parse_attribute (attribute (cls, fields(7)))
    val loadServingEntity: Fielder = parse_attribute (attribute (cls, fields(8)))
    val planningAuthority: Fielder = parse_attribute (attribute (cls, fields(9)))
    val purchasingSellingEntity: Fielder = parse_attribute (attribute (cls, fields(10)))
    val reliabilityAuthority: Fielder = parse_attribute (attribute (cls, fields(11)))
    val resourcePlanner: Fielder = parse_attribute (attribute (cls, fields(12)))
    val standardsDeveloper: Fielder = parse_attribute (attribute (cls, fields(13)))
    val transmissionOperator: Fielder = parse_attribute (attribute (cls, fields(14)))
    val transmissionOwner: Fielder = parse_attribute (attribute (cls, fields(15)))
    val transmissionPlanner: Fielder = parse_attribute (attribute (cls, fields(16)))
    val transmissionServiceProvider: Fielder = parse_attribute (attribute (cls, fields(17)))
    val BalanceResponsibleParty: Fielder = parse_attribute (attribute (cls, fields(18)))
    val BalanceSupplier: Fielder = parse_attribute (attribute (cls, fields(19)))
    val BillingAgent: Fielder = parse_attribute (attribute (cls, fields(20)))
    val BlockEnergyTrader: Fielder = parse_attribute (attribute (cls, fields(21)))
    val CapacityCoordinator: Fielder = parse_attribute (attribute (cls, fields(22)))
    val CapacityTrader: Fielder = parse_attribute (attribute (cls, fields(23)))
    val Consumer: Fielder = parse_attribute (attribute (cls, fields(24)))
    val ConsumptionResponsibleParty: Fielder = parse_attribute (attribute (cls, fields(25)))
    val ControlAreaOperator: Fielder = parse_attribute (attribute (cls, fields(26)))
    val ControlBlockOperator: Fielder = parse_attribute (attribute (cls, fields(27)))
    val CoordinationCenterOperator: Fielder = parse_attribute (attribute (cls, fields(28)))
    val GridAccessProvider: Fielder = parse_attribute (attribute (cls, fields(29)))
    val GridOperator: Fielder = parse_attribute (attribute (cls, fields(30)))
    val ImbalanceSettlementResponsible: Fielder = parse_attribute (attribute (cls, fields(31)))
    val InterconnectionTradeResponsible: Fielder = parse_attribute (attribute (cls, fields(32)))
    val MOLResponsible: Fielder = parse_attribute (attribute (cls, fields(33)))
    val MarketInformationAggregator: Fielder = parse_attribute (attribute (cls, fields(34)))
    val MarketOperator: Fielder = parse_attribute (attribute (cls, fields(35)))
    val MeterAdministrator: Fielder = parse_attribute (attribute (cls, fields(36)))
    val MeterOperator: Fielder = parse_attribute (attribute (cls, fields(37)))
    val MeteredDataAggregator: Fielder = parse_attribute (attribute (cls, fields(38)))
    val MeteredDataCollector: Fielder = parse_attribute (attribute (cls, fields(39)))
    val MeteredDataResponsible: Fielder = parse_attribute (attribute (cls, fields(40)))
    val MeteringPointAdministrator: Fielder = parse_attribute (attribute (cls, fields(41)))
    val NominationValidator: Fielder = parse_attribute (attribute (cls, fields(42)))
    val PartyConnectedToTheGrid: Fielder = parse_attribute (attribute (cls, fields(43)))
    val Producer: Fielder = parse_attribute (attribute (cls, fields(44)))
    val ProductionResponsibleParty: Fielder = parse_attribute (attribute (cls, fields(45)))
    val ReconciliationAccountable: Fielder = parse_attribute (attribute (cls, fields(46)))
    val ReconciliationResponsible: Fielder = parse_attribute (attribute (cls, fields(47)))
    val ReserveAllocator: Fielder = parse_attribute (attribute (cls, fields(48)))
    val ResourceProvider: Fielder = parse_attribute (attribute (cls, fields(49)))
    val SchedulingCoordinator: Fielder = parse_attribute (attribute (cls, fields(50)))
    val SystemOperator: Fielder = parse_attribute (attribute (cls, fields(51)))
    val TradeResponsibleParty: Fielder = parse_attribute (attribute (cls, fields(52)))
    val TransmissionCapacityAllocator: Fielder = parse_attribute (attribute (cls, fields(53)))

    def parse (context: Context): MarketRoleKind =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0,0)
        val ret = MarketRoleKind (
            BasicElement.parse (context),
            mask (balancingAuthority (), 0),
            mask (competitiveRetailer (), 1),
            mask (complianceMonitor (), 2),
            mask (distributionProvider (), 3),
            mask (energyServiceConsumer (), 4),
            mask (generatorOperator (), 5),
            mask (generatorOwner (), 6),
            mask (interchangeAuthority (), 7),
            mask (loadServingEntity (), 8),
            mask (planningAuthority (), 9),
            mask (purchasingSellingEntity (), 10),
            mask (reliabilityAuthority (), 11),
            mask (resourcePlanner (), 12),
            mask (standardsDeveloper (), 13),
            mask (transmissionOperator (), 14),
            mask (transmissionOwner (), 15),
            mask (transmissionPlanner (), 16),
            mask (transmissionServiceProvider (), 17),
            mask (BalanceResponsibleParty (), 18),
            mask (BalanceSupplier (), 19),
            mask (BillingAgent (), 20),
            mask (BlockEnergyTrader (), 21),
            mask (CapacityCoordinator (), 22),
            mask (CapacityTrader (), 23),
            mask (Consumer (), 24),
            mask (ConsumptionResponsibleParty (), 25),
            mask (ControlAreaOperator (), 26),
            mask (ControlBlockOperator (), 27),
            mask (CoordinationCenterOperator (), 28),
            mask (GridAccessProvider (), 29),
            mask (GridOperator (), 30),
            mask (ImbalanceSettlementResponsible (), 31),
            mask (InterconnectionTradeResponsible (), 32),
            mask (MOLResponsible (), 33),
            mask (MarketInformationAggregator (), 34),
            mask (MarketOperator (), 35),
            mask (MeterAdministrator (), 36),
            mask (MeterOperator (), 37),
            mask (MeteredDataAggregator (), 38),
            mask (MeteredDataCollector (), 39),
            mask (MeteredDataResponsible (), 40),
            mask (MeteringPointAdministrator (), 41),
            mask (NominationValidator (), 42),
            mask (PartyConnectedToTheGrid (), 43),
            mask (Producer (), 44),
            mask (ProductionResponsibleParty (), 45),
            mask (ReconciliationAccountable (), 46),
            mask (ReconciliationResponsible (), 47),
            mask (ReserveAllocator (), 48),
            mask (ResourceProvider (), 49),
            mask (SchedulingCoordinator (), 50),
            mask (SystemOperator (), 51),
            mask (TradeResponsibleParty (), 52),
            mask (TransmissionCapacityAllocator (), 53)
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _InfMarketOpCommon
{
    def register: List[ClassInfo] =
    {
        List (
            MarketRoleKind.register
        )
    }
}