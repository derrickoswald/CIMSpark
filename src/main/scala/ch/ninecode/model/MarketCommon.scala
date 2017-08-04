package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * This package contains the common objects shared by both MarketManagement and MarketOperations packages.
 */

/**
 * An identification of a party acting in a electricity market business process.
 * This class is used to identify organizations that can participate in market management and/or market operations.
 * @param sup Reference to the superclass object.
 * @param MarketDocument <em>undocumented</em>
 */
case class MarketParticipant
(
    override val sup: Organisation,
    MarketDocument: List[String]
)
extends
    Element
{
    def this () = { this (null, List()) }
    def Organisation: Organisation = sup.asInstanceOf[Organisation]
    override def copy (): Row = { clone ().asInstanceOf[MarketParticipant] }
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
        (if (null != MarketDocument) MarketDocument.map (x => "\t\t<cim:MarketParticipant.MarketDocument rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:MarketParticipant rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MarketParticipant>\n"
    }
}

object MarketParticipant
extends
    Parseable[MarketParticipant]
{
    val MarketDocument: (Context) => List[String] = parse_attributes (attribute ("""MarketParticipant.MarketDocument"""))
    def parse (context: Context): MarketParticipant =
    {
        MarketParticipant(
            Organisation.parse (context),
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
 * @param MarketParticipant <em>undocumented</em>
 */
case class MarketRole
(
    override val sup: IdentifiedObject,
    roleType: String,
    status: String,
    typ: String,
    MarketParticipant: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, null, List()) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[MarketRole] }
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
        (if (null != roleType) "\t\t<cim:MarketRole.roleType rdf:resource=\"#" + roleType + "\"/>\n" else "") +
        (if (null != status) "\t\t<cim:MarketRole.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != typ) "\t\t<cim:MarketRole.type>" + typ + "</cim:MarketRole.type>\n" else "") +
        (if (null != MarketParticipant) MarketParticipant.map (x => "\t\t<cim:MarketRole.MarketParticipant rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:MarketRole rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MarketRole>\n"
    }
}

object MarketRole
extends
    Parseable[MarketRole]
{
    val roleType: (Context) => String = parse_attribute (attribute ("""MarketRole.roleType"""))
    val status: (Context) => String = parse_attribute (attribute ("""MarketRole.status"""))
    val typ: (Context) => String = parse_element (element ("""MarketRole.type"""))
    val MarketParticipant: (Context) => List[String] = parse_attributes (attribute ("""MarketRole.MarketParticipant"""))
    def parse (context: Context): MarketRole =
    {
        MarketRole(
            IdentifiedObject.parse (context),
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
    balancingAuthority: String,
    competitiveRetailer: String,
    complianceMonitor: String,
    distributionProvider: String,
    energyServiceConsumer: String,
    generatorOperator: String,
    generatorOwner: String,
    interchangeAuthority: String,
    loadServingEntity: String,
    planningAuthority: String,
    purchasingSellingEntity: String,
    reliabilityAuthority: String,
    resourcePlanner: String,
    standardsDeveloper: String,
    transmissionOperator: String,
    transmissionOwner: String,
    transmissionPlanner: String,
    transmissionServiceProvider: String,
    BalanceResponsibleParty: String,
    BalanceSupplier: String,
    BillingAgent: String,
    BlockEnergyTrader: String,
    CapacityCoordinator: String,
    CapacityTrader: String,
    Consumer: String,
    ConsumptionResponsibleParty: String,
    ControlAreaOperator: String,
    ControlBlockOperator: String,
    CoordinationCenterOperator: String,
    GridAccessProvider: String,
    GridOperator: String,
    ImbalanceSettlementResponsible: String,
    InterconnectionTradeResponsible: String,
    MOLResponsible: String,
    MarketInformationAggregator: String,
    MarketOperator: String,
    MeterAdministrator: String,
    MeterOperator: String,
    MeteredDataAggregator: String,
    MeteredDataCollector: String,
    MeteredDataResponsible: String,
    MeteringPointAdministrator: String,
    NominationValidator: String,
    PartyConnectedToTheGrid: String,
    Producer: String,
    ProductionResponsibleParty: String,
    ReconciliationAccountable: String,
    ReconciliationResponsible: String,
    ReserveAllocator: String,
    ResourceProvider: String,
    SchedulingCoordinator: String,
    SystemOperator: String,
    TradeResponsibleParty: String,
    TransmissionCapacityAllocator: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[MarketRoleKind] }
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
        (if (null != balancingAuthority) "\t\t<cim:MarketRoleKind.balancingAuthority rdf:resource=\"#" + balancingAuthority + "\"/>\n" else "") +
        (if (null != competitiveRetailer) "\t\t<cim:MarketRoleKind.competitiveRetailer rdf:resource=\"#" + competitiveRetailer + "\"/>\n" else "") +
        (if (null != complianceMonitor) "\t\t<cim:MarketRoleKind.complianceMonitor rdf:resource=\"#" + complianceMonitor + "\"/>\n" else "") +
        (if (null != distributionProvider) "\t\t<cim:MarketRoleKind.distributionProvider rdf:resource=\"#" + distributionProvider + "\"/>\n" else "") +
        (if (null != energyServiceConsumer) "\t\t<cim:MarketRoleKind.energyServiceConsumer rdf:resource=\"#" + energyServiceConsumer + "\"/>\n" else "") +
        (if (null != generatorOperator) "\t\t<cim:MarketRoleKind.generatorOperator rdf:resource=\"#" + generatorOperator + "\"/>\n" else "") +
        (if (null != generatorOwner) "\t\t<cim:MarketRoleKind.generatorOwner rdf:resource=\"#" + generatorOwner + "\"/>\n" else "") +
        (if (null != interchangeAuthority) "\t\t<cim:MarketRoleKind.interchangeAuthority rdf:resource=\"#" + interchangeAuthority + "\"/>\n" else "") +
        (if (null != loadServingEntity) "\t\t<cim:MarketRoleKind.loadServingEntity rdf:resource=\"#" + loadServingEntity + "\"/>\n" else "") +
        (if (null != planningAuthority) "\t\t<cim:MarketRoleKind.planningAuthority rdf:resource=\"#" + planningAuthority + "\"/>\n" else "") +
        (if (null != purchasingSellingEntity) "\t\t<cim:MarketRoleKind.purchasingSellingEntity rdf:resource=\"#" + purchasingSellingEntity + "\"/>\n" else "") +
        (if (null != reliabilityAuthority) "\t\t<cim:MarketRoleKind.reliabilityAuthority rdf:resource=\"#" + reliabilityAuthority + "\"/>\n" else "") +
        (if (null != resourcePlanner) "\t\t<cim:MarketRoleKind.resourcePlanner rdf:resource=\"#" + resourcePlanner + "\"/>\n" else "") +
        (if (null != standardsDeveloper) "\t\t<cim:MarketRoleKind.standardsDeveloper rdf:resource=\"#" + standardsDeveloper + "\"/>\n" else "") +
        (if (null != transmissionOperator) "\t\t<cim:MarketRoleKind.transmissionOperator rdf:resource=\"#" + transmissionOperator + "\"/>\n" else "") +
        (if (null != transmissionOwner) "\t\t<cim:MarketRoleKind.transmissionOwner rdf:resource=\"#" + transmissionOwner + "\"/>\n" else "") +
        (if (null != transmissionPlanner) "\t\t<cim:MarketRoleKind.transmissionPlanner rdf:resource=\"#" + transmissionPlanner + "\"/>\n" else "") +
        (if (null != transmissionServiceProvider) "\t\t<cim:MarketRoleKind.transmissionServiceProvider rdf:resource=\"#" + transmissionServiceProvider + "\"/>\n" else "") +
        (if (null != BalanceResponsibleParty) "\t\t<cim:MarketRoleKind.BalanceResponsibleParty rdf:resource=\"#" + BalanceResponsibleParty + "\"/>\n" else "") +
        (if (null != BalanceSupplier) "\t\t<cim:MarketRoleKind.BalanceSupplier rdf:resource=\"#" + BalanceSupplier + "\"/>\n" else "") +
        (if (null != BillingAgent) "\t\t<cim:MarketRoleKind.BillingAgent rdf:resource=\"#" + BillingAgent + "\"/>\n" else "") +
        (if (null != BlockEnergyTrader) "\t\t<cim:MarketRoleKind.BlockEnergyTrader rdf:resource=\"#" + BlockEnergyTrader + "\"/>\n" else "") +
        (if (null != CapacityCoordinator) "\t\t<cim:MarketRoleKind.CapacityCoordinator rdf:resource=\"#" + CapacityCoordinator + "\"/>\n" else "") +
        (if (null != CapacityTrader) "\t\t<cim:MarketRoleKind.CapacityTrader rdf:resource=\"#" + CapacityTrader + "\"/>\n" else "") +
        (if (null != Consumer) "\t\t<cim:MarketRoleKind.Consumer rdf:resource=\"#" + Consumer + "\"/>\n" else "") +
        (if (null != ConsumptionResponsibleParty) "\t\t<cim:MarketRoleKind.ConsumptionResponsibleParty rdf:resource=\"#" + ConsumptionResponsibleParty + "\"/>\n" else "") +
        (if (null != ControlAreaOperator) "\t\t<cim:MarketRoleKind.ControlAreaOperator rdf:resource=\"#" + ControlAreaOperator + "\"/>\n" else "") +
        (if (null != ControlBlockOperator) "\t\t<cim:MarketRoleKind.ControlBlockOperator rdf:resource=\"#" + ControlBlockOperator + "\"/>\n" else "") +
        (if (null != CoordinationCenterOperator) "\t\t<cim:MarketRoleKind.CoordinationCenterOperator rdf:resource=\"#" + CoordinationCenterOperator + "\"/>\n" else "") +
        (if (null != GridAccessProvider) "\t\t<cim:MarketRoleKind.GridAccessProvider rdf:resource=\"#" + GridAccessProvider + "\"/>\n" else "") +
        (if (null != GridOperator) "\t\t<cim:MarketRoleKind.GridOperator rdf:resource=\"#" + GridOperator + "\"/>\n" else "") +
        (if (null != ImbalanceSettlementResponsible) "\t\t<cim:MarketRoleKind.ImbalanceSettlementResponsible rdf:resource=\"#" + ImbalanceSettlementResponsible + "\"/>\n" else "") +
        (if (null != InterconnectionTradeResponsible) "\t\t<cim:MarketRoleKind.InterconnectionTradeResponsible rdf:resource=\"#" + InterconnectionTradeResponsible + "\"/>\n" else "") +
        (if (null != MOLResponsible) "\t\t<cim:MarketRoleKind.MOLResponsible rdf:resource=\"#" + MOLResponsible + "\"/>\n" else "") +
        (if (null != MarketInformationAggregator) "\t\t<cim:MarketRoleKind.MarketInformationAggregator rdf:resource=\"#" + MarketInformationAggregator + "\"/>\n" else "") +
        (if (null != MarketOperator) "\t\t<cim:MarketRoleKind.MarketOperator rdf:resource=\"#" + MarketOperator + "\"/>\n" else "") +
        (if (null != MeterAdministrator) "\t\t<cim:MarketRoleKind.MeterAdministrator rdf:resource=\"#" + MeterAdministrator + "\"/>\n" else "") +
        (if (null != MeterOperator) "\t\t<cim:MarketRoleKind.MeterOperator rdf:resource=\"#" + MeterOperator + "\"/>\n" else "") +
        (if (null != MeteredDataAggregator) "\t\t<cim:MarketRoleKind.MeteredDataAggregator rdf:resource=\"#" + MeteredDataAggregator + "\"/>\n" else "") +
        (if (null != MeteredDataCollector) "\t\t<cim:MarketRoleKind.MeteredDataCollector rdf:resource=\"#" + MeteredDataCollector + "\"/>\n" else "") +
        (if (null != MeteredDataResponsible) "\t\t<cim:MarketRoleKind.MeteredDataResponsible rdf:resource=\"#" + MeteredDataResponsible + "\"/>\n" else "") +
        (if (null != MeteringPointAdministrator) "\t\t<cim:MarketRoleKind.MeteringPointAdministrator rdf:resource=\"#" + MeteringPointAdministrator + "\"/>\n" else "") +
        (if (null != NominationValidator) "\t\t<cim:MarketRoleKind.NominationValidator rdf:resource=\"#" + NominationValidator + "\"/>\n" else "") +
        (if (null != PartyConnectedToTheGrid) "\t\t<cim:MarketRoleKind.PartyConnectedToTheGrid rdf:resource=\"#" + PartyConnectedToTheGrid + "\"/>\n" else "") +
        (if (null != Producer) "\t\t<cim:MarketRoleKind.Producer rdf:resource=\"#" + Producer + "\"/>\n" else "") +
        (if (null != ProductionResponsibleParty) "\t\t<cim:MarketRoleKind.ProductionResponsibleParty rdf:resource=\"#" + ProductionResponsibleParty + "\"/>\n" else "") +
        (if (null != ReconciliationAccountable) "\t\t<cim:MarketRoleKind.ReconciliationAccountable rdf:resource=\"#" + ReconciliationAccountable + "\"/>\n" else "") +
        (if (null != ReconciliationResponsible) "\t\t<cim:MarketRoleKind.ReconciliationResponsible rdf:resource=\"#" + ReconciliationResponsible + "\"/>\n" else "") +
        (if (null != ReserveAllocator) "\t\t<cim:MarketRoleKind.ReserveAllocator rdf:resource=\"#" + ReserveAllocator + "\"/>\n" else "") +
        (if (null != ResourceProvider) "\t\t<cim:MarketRoleKind.ResourceProvider rdf:resource=\"#" + ResourceProvider + "\"/>\n" else "") +
        (if (null != SchedulingCoordinator) "\t\t<cim:MarketRoleKind.SchedulingCoordinator rdf:resource=\"#" + SchedulingCoordinator + "\"/>\n" else "") +
        (if (null != SystemOperator) "\t\t<cim:MarketRoleKind.SystemOperator rdf:resource=\"#" + SystemOperator + "\"/>\n" else "") +
        (if (null != TradeResponsibleParty) "\t\t<cim:MarketRoleKind.TradeResponsibleParty rdf:resource=\"#" + TradeResponsibleParty + "\"/>\n" else "") +
        (if (null != TransmissionCapacityAllocator) "\t\t<cim:MarketRoleKind.TransmissionCapacityAllocator rdf:resource=\"#" + TransmissionCapacityAllocator + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MarketRoleKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MarketRoleKind>\n"
    }
}

object MarketRoleKind
extends
    Parseable[MarketRoleKind]
{
    val balancingAuthority: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.balancingAuthority"""))
    val competitiveRetailer: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.competitiveRetailer"""))
    val complianceMonitor: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.complianceMonitor"""))
    val distributionProvider: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.distributionProvider"""))
    val energyServiceConsumer: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.energyServiceConsumer"""))
    val generatorOperator: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.generatorOperator"""))
    val generatorOwner: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.generatorOwner"""))
    val interchangeAuthority: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.interchangeAuthority"""))
    val loadServingEntity: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.loadServingEntity"""))
    val planningAuthority: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.planningAuthority"""))
    val purchasingSellingEntity: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.purchasingSellingEntity"""))
    val reliabilityAuthority: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.reliabilityAuthority"""))
    val resourcePlanner: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.resourcePlanner"""))
    val standardsDeveloper: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.standardsDeveloper"""))
    val transmissionOperator: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.transmissionOperator"""))
    val transmissionOwner: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.transmissionOwner"""))
    val transmissionPlanner: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.transmissionPlanner"""))
    val transmissionServiceProvider: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.transmissionServiceProvider"""))
    val BalanceResponsibleParty: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.BalanceResponsibleParty"""))
    val BalanceSupplier: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.BalanceSupplier"""))
    val BillingAgent: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.BillingAgent"""))
    val BlockEnergyTrader: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.BlockEnergyTrader"""))
    val CapacityCoordinator: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.CapacityCoordinator"""))
    val CapacityTrader: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.CapacityTrader"""))
    val Consumer: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.Consumer"""))
    val ConsumptionResponsibleParty: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.ConsumptionResponsibleParty"""))
    val ControlAreaOperator: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.ControlAreaOperator"""))
    val ControlBlockOperator: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.ControlBlockOperator"""))
    val CoordinationCenterOperator: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.CoordinationCenterOperator"""))
    val GridAccessProvider: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.GridAccessProvider"""))
    val GridOperator: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.GridOperator"""))
    val ImbalanceSettlementResponsible: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.ImbalanceSettlementResponsible"""))
    val InterconnectionTradeResponsible: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.InterconnectionTradeResponsible"""))
    val MOLResponsible: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.MOLResponsible"""))
    val MarketInformationAggregator: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.MarketInformationAggregator"""))
    val MarketOperator: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.MarketOperator"""))
    val MeterAdministrator: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.MeterAdministrator"""))
    val MeterOperator: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.MeterOperator"""))
    val MeteredDataAggregator: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.MeteredDataAggregator"""))
    val MeteredDataCollector: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.MeteredDataCollector"""))
    val MeteredDataResponsible: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.MeteredDataResponsible"""))
    val MeteringPointAdministrator: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.MeteringPointAdministrator"""))
    val NominationValidator: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.NominationValidator"""))
    val PartyConnectedToTheGrid: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.PartyConnectedToTheGrid"""))
    val Producer: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.Producer"""))
    val ProductionResponsibleParty: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.ProductionResponsibleParty"""))
    val ReconciliationAccountable: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.ReconciliationAccountable"""))
    val ReconciliationResponsible: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.ReconciliationResponsible"""))
    val ReserveAllocator: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.ReserveAllocator"""))
    val ResourceProvider: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.ResourceProvider"""))
    val SchedulingCoordinator: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.SchedulingCoordinator"""))
    val SystemOperator: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.SystemOperator"""))
    val TradeResponsibleParty: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.TradeResponsibleParty"""))
    val TransmissionCapacityAllocator: (Context) => String = parse_attribute (attribute ("""MarketRoleKind.TransmissionCapacityAllocator"""))
    def parse (context: Context): MarketRoleKind =
    {
        MarketRoleKind(
            BasicElement.parse (context),
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
 * @param AdjacentCASet <em>undocumented</em>
 * @param AggregateNode <em>undocumented</em>
 * @param DefaultBid <em>undocumented</em>
 * @param ECAFlag Indication that this resource is associated with an Embedded Control area
 * @param ForbiddenRegion <em>undocumented</em>
 * @param HostControlArea <em>undocumented</em>
 * @param InterTie <em>undocumented</em>
 * @param LMPMFlag LMPM flag: indicates whether the resource is subject to the LMPM test (Yes/No)
 * @param MktConnectivityNode <em>undocumented</em>
 * @param MktOrganisation <em>undocumented</em>
 * @param Pnode A registered resource injects power at one or more connectivity nodes related to a pnode
 * @param RampRateCurve <em>undocumented</em>
 * @param ResourceCapacity <em>undocumented</em>
 * @param ResourceCertification <em>undocumented</em>
 * @param ResourceVerifiableCosts <em>undocumented</em>
 * @param SMPMFlag SMPM flag: indicates whether the resource is subject to the SMPM test (Yes/No)
 * @param SubControlArea <em>undocumented</em>
 * @param TimeSeries <em>undocumented</em>
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
    DefaultBid: String,
    ECAFlag: String,
    ForbiddenRegion: List[String],
    HostControlArea: String,
    InterTie: List[String],
    LMPMFlag: String,
    MktConnectivityNode: String,
    MktOrganisation: String,
    Pnode: String,
    RampRateCurve: List[String],
    ResourceCapacity: List[String],
    ResourceCertification: List[String],
    ResourceVerifiableCosts: String,
    SMPMFlag: String,
    SubControlArea: List[String],
    TimeSeries: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, null, null, null, null, null, null, null, null, null, List(), null, null, List(), null, List(), null, null, null, null, List(), List(), List(), null, null, List(), List()) }
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { clone ().asInstanceOf[RegisteredResource] }
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
        (if (null != commercialOpDate) "\t\t<cim:RegisteredResource.commercialOpDate>" + commercialOpDate + "</cim:RegisteredResource.commercialOpDate>\n" else "") +
        (if (null != contingencyAvailFlag) "\t\t<cim:RegisteredResource.contingencyAvailFlag rdf:resource=\"#" + contingencyAvailFlag + "\"/>\n" else "") +
        (if (null != dispatchFlag) "\t\t<cim:RegisteredResource.dispatchFlag rdf:resource=\"#" + dispatchFlag + "\"/>\n" else "") +
        (if (null != endEffectiveDate) "\t\t<cim:RegisteredResource.endEffectiveDate>" + endEffectiveDate + "</cim:RegisteredResource.endEffectiveDate>\n" else "") +
        (if (null != flexibleOfferFlag) "\t\t<cim:RegisteredResource.flexibleOfferFlag rdf:resource=\"#" + flexibleOfferFlag + "\"/>\n" else "") +
        (if (null != hourlyPredispatch) "\t\t<cim:RegisteredResource.hourlyPredispatch rdf:resource=\"#" + hourlyPredispatch + "\"/>\n" else "") +
        (if (null != isAggregatedRes) "\t\t<cim:RegisteredResource.isAggregatedRes rdf:resource=\"#" + isAggregatedRes + "\"/>\n" else "") +
        (if (null != lastModified) "\t\t<cim:RegisteredResource.lastModified>" + lastModified + "</cim:RegisteredResource.lastModified>\n" else "") +
        (if (null != marketParticipationFlag) "\t\t<cim:RegisteredResource.marketParticipationFlag rdf:resource=\"#" + marketParticipationFlag + "\"/>\n" else "") +
        "\t\t<cim:RegisteredResource.maxBaseSelfSchedQty >" + maxBaseSelfSchedQty_1 + "</cim:RegisteredResource.maxBaseSelfSchedQty >\n" +
        "\t\t<cim:RegisteredResource.maxOnTime>" + maxOnTime + "</cim:RegisteredResource.maxOnTime>\n" +
        "\t\t<cim:RegisteredResource.minDispatchTime>" + minDispatchTime + "</cim:RegisteredResource.minDispatchTime>\n" +
        "\t\t<cim:RegisteredResource.minOffTime>" + minOffTime + "</cim:RegisteredResource.minOffTime>\n" +
        "\t\t<cim:RegisteredResource.minOnTime>" + minOnTime + "</cim:RegisteredResource.minOnTime>\n" +
        (if (null != mustOfferFlag) "\t\t<cim:RegisteredResource.mustOfferFlag rdf:resource=\"#" + mustOfferFlag + "\"/>\n" else "") +
        (if (null != nonMarket) "\t\t<cim:RegisteredResource.nonMarket rdf:resource=\"#" + nonMarket + "\"/>\n" else "") +
        (if (null != pointOfDeliveryFlag) "\t\t<cim:RegisteredResource.pointOfDeliveryFlag rdf:resource=\"#" + pointOfDeliveryFlag + "\"/>\n" else "") +
        (if (null != priceSetFlagDA) "\t\t<cim:RegisteredResource.priceSetFlagDA rdf:resource=\"#" + priceSetFlagDA + "\"/>\n" else "") +
        (if (null != priceSetFlagRT) "\t\t<cim:RegisteredResource.priceSetFlagRT rdf:resource=\"#" + priceSetFlagRT + "\"/>\n" else "") +
        (if (null != registrationStatus) "\t\t<cim:RegisteredResource.registrationStatus rdf:resource=\"#" + registrationStatus + "\"/>\n" else "") +
        (if (null != resourceAdequacyFlag) "\t\t<cim:RegisteredResource.resourceAdequacyFlag rdf:resource=\"#" + resourceAdequacyFlag + "\"/>\n" else "") +
        (if (null != startEffectiveDate) "\t\t<cim:RegisteredResource.startEffectiveDate>" + startEffectiveDate + "</cim:RegisteredResource.startEffectiveDate>\n" else "") +
        (if (null != ACAFlag) "\t\t<cim:RegisteredResource.ACAFlag rdf:resource=\"#" + ACAFlag + "\"/>\n" else "") +
        (if (null != ASSPOptimizationFlag) "\t\t<cim:RegisteredResource.ASSPOptimizationFlag rdf:resource=\"#" + ASSPOptimizationFlag + "\"/>\n" else "") +
        (if (null != AdjacentCASet) "\t\t<cim:RegisteredResource.AdjacentCASet rdf:resource=\"#" + AdjacentCASet + "\"/>\n" else "") +
        (if (null != AggregateNode) AggregateNode.map (x => "\t\t<cim:RegisteredResource.AggregateNode rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != DefaultBid) "\t\t<cim:RegisteredResource.DefaultBid rdf:resource=\"#" + DefaultBid + "\"/>\n" else "") +
        (if (null != ECAFlag) "\t\t<cim:RegisteredResource.ECAFlag rdf:resource=\"#" + ECAFlag + "\"/>\n" else "") +
        (if (null != ForbiddenRegion) ForbiddenRegion.map (x => "\t\t<cim:RegisteredResource.ForbiddenRegion rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != HostControlArea) "\t\t<cim:RegisteredResource.HostControlArea rdf:resource=\"#" + HostControlArea + "\"/>\n" else "") +
        (if (null != InterTie) InterTie.map (x => "\t\t<cim:RegisteredResource.InterTie rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != LMPMFlag) "\t\t<cim:RegisteredResource.LMPMFlag rdf:resource=\"#" + LMPMFlag + "\"/>\n" else "") +
        (if (null != MktConnectivityNode) "\t\t<cim:RegisteredResource.MktConnectivityNode rdf:resource=\"#" + MktConnectivityNode + "\"/>\n" else "") +
        (if (null != MktOrganisation) "\t\t<cim:RegisteredResource.MktOrganisation rdf:resource=\"#" + MktOrganisation + "\"/>\n" else "") +
        (if (null != Pnode) "\t\t<cim:RegisteredResource.Pnode rdf:resource=\"#" + Pnode + "\"/>\n" else "") +
        (if (null != RampRateCurve) RampRateCurve.map (x => "\t\t<cim:RegisteredResource.RampRateCurve rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != ResourceCapacity) ResourceCapacity.map (x => "\t\t<cim:RegisteredResource.ResourceCapacity rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != ResourceCertification) ResourceCertification.map (x => "\t\t<cim:RegisteredResource.ResourceCertification rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != ResourceVerifiableCosts) "\t\t<cim:RegisteredResource.ResourceVerifiableCosts rdf:resource=\"#" + ResourceVerifiableCosts + "\"/>\n" else "") +
        (if (null != SMPMFlag) "\t\t<cim:RegisteredResource.SMPMFlag rdf:resource=\"#" + SMPMFlag + "\"/>\n" else "") +
        (if (null != SubControlArea) SubControlArea.map (x => "\t\t<cim:RegisteredResource.SubControlArea rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != TimeSeries) TimeSeries.map (x => "\t\t<cim:RegisteredResource.TimeSeries rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:RegisteredResource rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RegisteredResource>\n"
    }
}

object RegisteredResource
extends
    Parseable[RegisteredResource]
{
    val commercialOpDate: (Context) => String = parse_element (element ("""RegisteredResource.commercialOpDate"""))
    val contingencyAvailFlag: (Context) => String = parse_attribute (attribute ("""RegisteredResource.contingencyAvailFlag"""))
    val dispatchFlag: (Context) => String = parse_attribute (attribute ("""RegisteredResource.dispatchFlag"""))
    val endEffectiveDate: (Context) => String = parse_element (element ("""RegisteredResource.endEffectiveDate"""))
    val flexibleOfferFlag: (Context) => String = parse_attribute (attribute ("""RegisteredResource.flexibleOfferFlag"""))
    val hourlyPredispatch: (Context) => String = parse_attribute (attribute ("""RegisteredResource.hourlyPredispatch"""))
    val isAggregatedRes: (Context) => String = parse_attribute (attribute ("""RegisteredResource.isAggregatedRes"""))
    val lastModified: (Context) => String = parse_element (element ("""RegisteredResource.lastModified"""))
    val marketParticipationFlag: (Context) => String = parse_attribute (attribute ("""RegisteredResource.marketParticipationFlag"""))
    val maxBaseSelfSchedQty_1: (Context) => String = parse_element (element ("""RegisteredResource.maxBaseSelfSchedQty """))
    val maxOnTime: (Context) => String = parse_element (element ("""RegisteredResource.maxOnTime"""))
    val minDispatchTime: (Context) => String = parse_element (element ("""RegisteredResource.minDispatchTime"""))
    val minOffTime: (Context) => String = parse_element (element ("""RegisteredResource.minOffTime"""))
    val minOnTime: (Context) => String = parse_element (element ("""RegisteredResource.minOnTime"""))
    val mustOfferFlag: (Context) => String = parse_attribute (attribute ("""RegisteredResource.mustOfferFlag"""))
    val nonMarket: (Context) => String = parse_attribute (attribute ("""RegisteredResource.nonMarket"""))
    val pointOfDeliveryFlag: (Context) => String = parse_attribute (attribute ("""RegisteredResource.pointOfDeliveryFlag"""))
    val priceSetFlagDA: (Context) => String = parse_attribute (attribute ("""RegisteredResource.priceSetFlagDA"""))
    val priceSetFlagRT: (Context) => String = parse_attribute (attribute ("""RegisteredResource.priceSetFlagRT"""))
    val registrationStatus: (Context) => String = parse_attribute (attribute ("""RegisteredResource.registrationStatus"""))
    val resourceAdequacyFlag: (Context) => String = parse_attribute (attribute ("""RegisteredResource.resourceAdequacyFlag"""))
    val startEffectiveDate: (Context) => String = parse_element (element ("""RegisteredResource.startEffectiveDate"""))
    val ACAFlag: (Context) => String = parse_attribute (attribute ("""RegisteredResource.ACAFlag"""))
    val ASSPOptimizationFlag: (Context) => String = parse_attribute (attribute ("""RegisteredResource.ASSPOptimizationFlag"""))
    val AdjacentCASet: (Context) => String = parse_attribute (attribute ("""RegisteredResource.AdjacentCASet"""))
    val AggregateNode: (Context) => List[String] = parse_attributes (attribute ("""RegisteredResource.AggregateNode"""))
    val DefaultBid: (Context) => String = parse_attribute (attribute ("""RegisteredResource.DefaultBid"""))
    val ECAFlag: (Context) => String = parse_attribute (attribute ("""RegisteredResource.ECAFlag"""))
    val ForbiddenRegion: (Context) => List[String] = parse_attributes (attribute ("""RegisteredResource.ForbiddenRegion"""))
    val HostControlArea: (Context) => String = parse_attribute (attribute ("""RegisteredResource.HostControlArea"""))
    val InterTie: (Context) => List[String] = parse_attributes (attribute ("""RegisteredResource.InterTie"""))
    val LMPMFlag: (Context) => String = parse_attribute (attribute ("""RegisteredResource.LMPMFlag"""))
    val MktConnectivityNode: (Context) => String = parse_attribute (attribute ("""RegisteredResource.MktConnectivityNode"""))
    val MktOrganisation: (Context) => String = parse_attribute (attribute ("""RegisteredResource.MktOrganisation"""))
    val Pnode: (Context) => String = parse_attribute (attribute ("""RegisteredResource.Pnode"""))
    val RampRateCurve: (Context) => List[String] = parse_attributes (attribute ("""RegisteredResource.RampRateCurve"""))
    val ResourceCapacity: (Context) => List[String] = parse_attributes (attribute ("""RegisteredResource.ResourceCapacity"""))
    val ResourceCertification: (Context) => List[String] = parse_attributes (attribute ("""RegisteredResource.ResourceCertification"""))
    val ResourceVerifiableCosts: (Context) => String = parse_attribute (attribute ("""RegisteredResource.ResourceVerifiableCosts"""))
    val SMPMFlag: (Context) => String = parse_attribute (attribute ("""RegisteredResource.SMPMFlag"""))
    val SubControlArea: (Context) => List[String] = parse_attributes (attribute ("""RegisteredResource.SubControlArea"""))
    val TimeSeries: (Context) => List[String] = parse_attributes (attribute ("""RegisteredResource.TimeSeries"""))
    def parse (context: Context): RegisteredResource =
    {
        RegisteredResource(
            PowerSystemResource.parse (context),
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

private[ninecode] object _MarketCommon
{
    def register: List[ClassInfo] =
    {
        List (
            MarketParticipant.register,
            MarketRole.register,
            MarketRoleKind.register,
            RegisteredResource.register
        )
    }
}