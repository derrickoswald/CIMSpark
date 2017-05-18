package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * Market static reference data.
 */

/**
 * Goups Adjacent Control Areas
 * @param sup Reference to the superclass object.
 * @param endEffectiveDate end effective date
 * @param lossPercentage_1 Loss percentage
 * @param startEffectiveDate start effective date
 * @param HostControlArea
 * @param RTO
 */
case class AdjacentCASet
(
    override val sup: Element,
    val endEffectiveDate: String,
    val lossPercentage_1: Double,
    val startEffectiveDate: String,
    val HostControlArea: String,
    val RTO: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[AdjacentCASet]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AdjacentCASet
extends
    Parseable[AdjacentCASet]
{
    val sup = IdentifiedObject.parse _
    val endEffectiveDate = parse_element (element ("""AdjacentCASet.endEffectiveDate"""))
    val lossPercentage_1 = parse_element (element ("""AdjacentCASet.lossPercentage """))
    val startEffectiveDate = parse_element (element ("""AdjacentCASet.startEffectiveDate"""))
    val HostControlArea = parse_attribute (attribute ("""AdjacentCASet.HostControlArea"""))
    val RTO = parse_attribute (attribute ("""AdjacentCASet.RTO"""))
    def parse (context: Context): AdjacentCASet =
    {
        AdjacentCASet(
            sup (context),
            endEffectiveDate (context),
            toDouble (lossPercentage_1 (context), context),
            startEffectiveDate (context),
            HostControlArea (context),
            RTO (context)
        )
    }
}

/**
 * An aggregated node can define a typed grouping further defined by the AnodeType enumeratuion.
 * Types range from System Zone/Regions to Market Energy Regions to Aggregated Loads and Aggregated Generators.
 * @param sup Reference to the superclass object.
 * @param anodeType Type of aggregated node
 * @param endEffectiveDate end effective date
 * @param qualifASOrder Processing Order for AS self-provisions for this region.
 *        The priority of this attribute directs the awards of any resource that resides in overlapping regions. The regions are processed in priority manner.
 * @param startEffectiveDate start effective date
 * @param Pnode
 * @param RTO
 * @param SubControlArea
 */
case class AggregateNode
(
    override val sup: Element,
    val anodeType: String,
    val endEffectiveDate: String,
    val qualifASOrder: Int,
    val startEffectiveDate: String,
    val Pnode: List[String],
    val RTO: String,
    val SubControlArea: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, 0, null, List(), null, List()) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[AggregateNode]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AggregateNode
extends
    Parseable[AggregateNode]
{
    val sup = IdentifiedObject.parse _
    val anodeType = parse_attribute (attribute ("""AggregateNode.anodeType"""))
    val endEffectiveDate = parse_element (element ("""AggregateNode.endEffectiveDate"""))
    val qualifASOrder = parse_element (element ("""AggregateNode.qualifASOrder"""))
    val startEffectiveDate = parse_element (element ("""AggregateNode.startEffectiveDate"""))
    val Pnode = parse_attributes (attribute ("""AggregateNode.Pnode"""))
    val RTO = parse_attribute (attribute ("""AggregateNode.RTO"""))
    val SubControlArea = parse_attributes (attribute ("""AggregateNode.SubControlArea"""))
    def parse (context: Context): AggregateNode =
    {
        AggregateNode(
            sup (context),
            anodeType (context),
            endEffectiveDate (context),
            toInteger (qualifASOrder (context), context),
            startEffectiveDate (context),
            Pnode (context),
            RTO (context),
            SubControlArea (context)
        )
    }
}

/**
 * An aggregated pricing node is a specialized type of pricing node used to model items such as System Zone, Default Price Zone, Custom Price Zone, Control Area, Aggregated Generation, Aggregated Particpating Load, Aggregated Non-Participating Load, Trading Hub, Designated Control Area(DCA) Zone
 * @param sup Reference to the superclass object.
 * @param apnodeType Aggregate Price Node Types
 * @param participationCategory Designated Control Area participation in LMP price measurement

'Y' - Participates in both Local Market Power Mitigation (LMPM) and System Market Power Mitigation (SMPM)
'N' - Not included in LMP price measures
'S' - Participatesin SMPM price measures
 *        'L' - Participatesin LMPM price measures
 * @param PnodeDistributionFactor
 * @param TACArea
 */
case class AggregatedPnode
(
    override val sup: Element,
    val apnodeType: String,
    val participationCategory: String,
    val PnodeDistributionFactor: String,
    val TACArea: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, null, List()) }
    def Pnode: Pnode = sup.asInstanceOf[Pnode]
    override def copy (): Row = { return (clone ().asInstanceOf[AggregatedPnode]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AggregatedPnode
extends
    Parseable[AggregatedPnode]
{
    val sup = Pnode.parse _
    val apnodeType = parse_attribute (attribute ("""AggregatedPnode.apnodeType"""))
    val participationCategory = parse_attribute (attribute ("""AggregatedPnode.participationCategory"""))
    val PnodeDistributionFactor = parse_attribute (attribute ("""AggregatedPnode.PnodeDistributionFactor"""))
    val TACArea = parse_attributes (attribute ("""AggregatedPnode.TACArea"""))
    def parse (context: Context): AggregatedPnode =
    {
        AggregatedPnode(
            sup (context),
            apnodeType (context),
            participationCategory (context),
            PnodeDistributionFactor (context),
            TACArea (context)
        )
    }
}

/**
 * This class represent the bid price cap.
 * @param sup Reference to the superclass object.
 * @param bidCeiling Bid Ceiling ($/MWH)
 * @param bidCeilingAS Bid Ceiling ($/MWH) for generic AS versus a specific market product
 * @param bidFloor Bid Floor, ($/MWH)
 * @param bidFloorAS Bid Floor ($/MWH) for generic AS versus a specific market product
 * @param defaultPrice Bid Default Price($/MWH)
 * @param marketType Market Type of the cap (DAM or RTM)
 * @param MarketProduct
 */
case class BidPriceCap
(
    override val sup: Element,
    val bidCeiling: Double,
    val bidCeilingAS: Double,
    val bidFloor: Double,
    val bidFloorAS: Double,
    val defaultPrice: Double,
    val marketType: String,
    val MarketProduct: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[BidPriceCap]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BidPriceCap
extends
    Parseable[BidPriceCap]
{
    val sup = BasicElement.parse _
    val bidCeiling = parse_element (element ("""BidPriceCap.bidCeiling"""))
    val bidCeilingAS = parse_element (element ("""BidPriceCap.bidCeilingAS"""))
    val bidFloor = parse_element (element ("""BidPriceCap.bidFloor"""))
    val bidFloorAS = parse_element (element ("""BidPriceCap.bidFloorAS"""))
    val defaultPrice = parse_element (element ("""BidPriceCap.defaultPrice"""))
    val marketType = parse_attribute (attribute ("""BidPriceCap.marketType"""))
    val MarketProduct = parse_attribute (attribute ("""BidPriceCap.MarketProduct"""))
    def parse (context: Context): BidPriceCap =
    {
        BidPriceCap(
            sup (context),
            toDouble (bidCeiling (context), context),
            toDouble (bidCeilingAS (context), context),
            toDouble (bidFloor (context), context),
            toDouble (bidFloorAS (context), context),
            toDouble (defaultPrice (context), context),
            marketType (context),
            MarketProduct (context)
        )
    }
}

/**
 * Participation factors per Cnode.
 * Used to calculate "participation" of Cnode in an AggregateNode. Each Cnode associated to an AggregateNode would be assigned a participation factor for its participation within the AggregateNode.
 * @param sup Reference to the superclass object.
 * @param factor Used to calculate "participation" of Cnode in an AggregateNode
 * @param podLossFactor Point of delivery loss factor
 * @param AggregateNode
 * @param HostControlArea
 * @param MktConnectivityNode
 * @param SubControlArea
 */
case class CnodeDistributionFactor
(
    override val sup: Element,
    val factor: Double,
    val podLossFactor: Double,
    val AggregateNode: String,
    val HostControlArea: String,
    val MktConnectivityNode: String,
    val SubControlArea: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[CnodeDistributionFactor]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CnodeDistributionFactor
extends
    Parseable[CnodeDistributionFactor]
{
    val sup = IdentifiedObject.parse _
    val factor = parse_element (element ("""CnodeDistributionFactor.factor"""))
    val podLossFactor = parse_element (element ("""CnodeDistributionFactor.podLossFactor"""))
    val AggregateNode = parse_attribute (attribute ("""CnodeDistributionFactor.AggregateNode"""))
    val HostControlArea = parse_attribute (attribute ("""CnodeDistributionFactor.HostControlArea"""))
    val MktConnectivityNode = parse_attribute (attribute ("""CnodeDistributionFactor.MktConnectivityNode"""))
    val SubControlArea = parse_attribute (attribute ("""CnodeDistributionFactor.SubControlArea"""))
    def parse (context: Context): CnodeDistributionFactor =
    {
        CnodeDistributionFactor(
            sup (context),
            toDouble (factor (context), context),
            toDouble (podLossFactor (context), context),
            AggregateNode (context),
            HostControlArea (context),
            MktConnectivityNode (context),
            SubControlArea (context)
        )
    }
}

/**
 * Configuration options for combined cycle units.
 * For example, a Combined Cycle with (CT1, CT2, ST1) will have (CT1, ST1) and (CT2, ST1) configurations as part of(1CT + 1STlogicalconfiguration).
 * @param sup Reference to the superclass object.
 * @param primaryConfiguration Whether this CombinedCycleConfiguration is the primary configuration in the associated Logical configuration?
 * @param CombinedCycleLogicalConfiguration
 * @param ShutdownFlag Whether Combined Cycle Plant can be shut-down in this Configuration?
 * @param StartupFlag Whether Combined Cycle Plant can be started in this Logical Configuration?
 */
case class CombinedCycleConfiguration
(
    override val sup: Element,
    val primaryConfiguration: Boolean,
    val CombinedCycleLogicalConfiguration: String,
    val ShutdownFlag: Boolean,
    val StartupFlag: Boolean
)
extends
    Element
{
    def this () = { this (null, false, null, false, false) }
    def RegisteredGenerator: RegisteredGenerator = sup.asInstanceOf[RegisteredGenerator]
    override def copy (): Row = { return (clone ().asInstanceOf[CombinedCycleConfiguration]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CombinedCycleConfiguration
extends
    Parseable[CombinedCycleConfiguration]
{
    val sup = RegisteredGenerator.parse _
    val primaryConfiguration = parse_element (element ("""CombinedCycleConfiguration.primaryConfiguration"""))
    val CombinedCycleLogicalConfiguration = parse_attribute (attribute ("""CombinedCycleConfiguration.CombinedCycleLogicalConfiguration"""))
    val ShutdownFlag = parse_element (element ("""CombinedCycleConfiguration.ShutdownFlag"""))
    val StartupFlag = parse_element (element ("""CombinedCycleConfiguration.StartupFlag"""))
    def parse (context: Context): CombinedCycleConfiguration =
    {
        CombinedCycleConfiguration(
            sup (context),
            toBoolean (primaryConfiguration (context), context),
            CombinedCycleLogicalConfiguration (context),
            toBoolean (ShutdownFlag (context), context),
            toBoolean (StartupFlag (context), context)
        )
    }
}

/**
 * Configuration Member of CCP Configuration.
 * @param sup Reference to the superclass object.
 * @param primary primary configuration.
 * @param steam Steam plant.
 * @param CombinedCycleConfiguration
 * @param MktThermalGeneratingUnit
 */
case class CombinedCycleConfigurationMember
(
    override val sup: Element,
    val primary: Boolean,
    val steam: Boolean,
    val CombinedCycleConfiguration: String,
    val MktThermalGeneratingUnit: String
)
extends
    Element
{
    def this () = { this (null, false, false, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[CombinedCycleConfigurationMember]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CombinedCycleConfigurationMember
extends
    Parseable[CombinedCycleConfigurationMember]
{
    val sup = IdentifiedObject.parse _
    val primary = parse_element (element ("""CombinedCycleConfigurationMember.primary"""))
    val steam = parse_element (element ("""CombinedCycleConfigurationMember.steam"""))
    val CombinedCycleConfiguration = parse_attribute (attribute ("""CombinedCycleConfigurationMember.CombinedCycleConfiguration"""))
    val MktThermalGeneratingUnit = parse_attribute (attribute ("""CombinedCycleConfigurationMember.MktThermalGeneratingUnit"""))
    def parse (context: Context): CombinedCycleConfigurationMember =
    {
        CombinedCycleConfigurationMember(
            sup (context),
            toBoolean (primary (context), context),
            toBoolean (steam (context), context),
            CombinedCycleConfiguration (context),
            MktThermalGeneratingUnit (context)
        )
    }
}

/**
 * Logical Configuration of a Combined Cycle plant.
 * Operating Combined Cycle Plant (CCP) configurations are represented as Logical CCP Resources. Logical representation shall be used for Market applications to optimize and control Market Operations. Logical representation is also necessary for controlling the number of CCP configurations and to temper performance issues that may otherwise occur.
 * @param sup Reference to the superclass object.
 * @param MktCombinedCyclePlant
 */
case class CombinedCycleLogicalConfiguration
(
    override val sup: Element,
    val MktCombinedCyclePlant: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[CombinedCycleLogicalConfiguration]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CombinedCycleLogicalConfiguration
extends
    Parseable[CombinedCycleLogicalConfiguration]
{
    val sup = IdentifiedObject.parse _
    val MktCombinedCyclePlant = parse_attribute (attribute ("""CombinedCycleLogicalConfiguration.MktCombinedCyclePlant"""))
    def parse (context: Context): CombinedCycleLogicalConfiguration =
    {
        CombinedCycleLogicalConfiguration(
            sup (context),
            MktCombinedCyclePlant (context)
        )
    }
}

/**
 * Defines the available from and to Transition States for the Combine Cycle Configurations.
 * @param sup Reference to the superclass object.
 * @param upTransition Flag indicating whether this is an UP transition.
 *        If not, it is a DOWN transition.
 * @param FromConfiguration
 * @param ToConfiguration
 */
case class CombinedCycleTransitionState
(
    override val sup: Element,
    val upTransition: Boolean,
    val FromConfiguration: String,
    val ToConfiguration: String
)
extends
    Element
{
    def this () = { this (null, false, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[CombinedCycleTransitionState]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CombinedCycleTransitionState
extends
    Parseable[CombinedCycleTransitionState]
{
    val sup = BasicElement.parse _
    val upTransition = parse_element (element ("""CombinedCycleTransitionState.upTransition"""))
    val FromConfiguration = parse_attribute (attribute ("""CombinedCycleTransitionState.FromConfiguration"""))
    val ToConfiguration = parse_attribute (attribute ("""CombinedCycleTransitionState.ToConfiguration"""))
    def parse (context: Context): CombinedCycleTransitionState =
    {
        CombinedCycleTransitionState(
            sup (context),
            toBoolean (upTransition (context), context),
            FromConfiguration (context),
            ToConfiguration (context)
        )
    }
}

/**
 * Designated Congestion Area Definition (DCA)
 * @param sup Reference to the superclass object.
 * @param IndividualPnode
 */
case class CongestionArea
(
    override val sup: Element,
    val IndividualPnode: List[String]
)
extends
    Element
{
    def this () = { this (null, List()) }
    def AggregatedPnode: AggregatedPnode = sup.asInstanceOf[AggregatedPnode]
    override def copy (): Row = { return (clone ().asInstanceOf[CongestionArea]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CongestionArea
extends
    Parseable[CongestionArea]
{
    val sup = AggregatedPnode.parse _
    val IndividualPnode = parse_attributes (attribute ("""CongestionArea.IndividualPnode"""))
    def parse (context: Context): CongestionArea =
    {
        CongestionArea(
            sup (context),
            IndividualPnode (context)
        )
    }
}

/**
 * Distribution amoung resources at the sink point or source point
 * @param sup Reference to the superclass object.
 * @param factor MW value that this resource provides to the overall contract.
 * @param sinkFlag This value will be set to YES if the referenced Cnode is defined as the sink point in the contract.
 * @param sourceFlag This value will be set to YES if the referenced Cnode is defined as the source point in the contract.
 * @param Flowgate
 * @param RegisteredResource
 * @param TransmissionContractRight
 */
case class ContractDistributionFactor
(
    override val sup: Element,
    val factor: Double,
    val sinkFlag: String,
    val sourceFlag: String,
    val Flowgate: String,
    val RegisteredResource: String,
    val TransmissionContractRight: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ContractDistributionFactor]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ContractDistributionFactor
extends
    Parseable[ContractDistributionFactor]
{
    val sup = BasicElement.parse _
    val factor = parse_element (element ("""ContractDistributionFactor.factor"""))
    val sinkFlag = parse_attribute (attribute ("""ContractDistributionFactor.sinkFlag"""))
    val sourceFlag = parse_attribute (attribute ("""ContractDistributionFactor.sourceFlag"""))
    val Flowgate = parse_attribute (attribute ("""ContractDistributionFactor.Flowgate"""))
    val RegisteredResource = parse_attribute (attribute ("""ContractDistributionFactor.RegisteredResource"""))
    val TransmissionContractRight = parse_attribute (attribute ("""ContractDistributionFactor.TransmissionContractRight"""))
    def parse (context: Context): ContractDistributionFactor =
    {
        ContractDistributionFactor(
            sup (context),
            toDouble (factor (context), context),
            sinkFlag (context),
            sourceFlag (context),
            Flowgate (context),
            RegisteredResource (context),
            TransmissionContractRight (context)
        )
    }
}

/**
 * Provides definition of Transmission Ownership Right and Existing Transmission Contract identifiers for use by SCUC.
 * RMR contract hosting: Startup lead time, Contract Service Limits, Max Service Hours, Max MWhs, Max Start-ups, Ramp Rate, Max Net Dependable Capacity, Min Capacity and Unit Substitution for DAM/RTM to retrieve;
 * @param sup Reference to the superclass object.
 * @param chainOrder When used in conjunction with a Transmission Right contract chain, this is the precedence for the contracts.
 * @param contractMW MW value of the contract
 * @param contractPrice Financial value of the contract
 * @param contractPriority Priority for the contract.
 *        This should be unique amoung all contracts for a specific resource. This value is the directive for the SCUC algorithm on the order to satisfy/cut contracts.
 * @param contractStatus Contract status
 * @param contractType type of the contract.
 *        Possible values are but not limited by:
 * @param endEffectiveDate end effective date
 * @param financialLocation Indicator if the location associated with this contract is financial (e.g. pricing nodes) or physical (e.g. connectivity nodes).
 * @param financialRightsDAM Flag to indicate this contract provides financial rights in the DA Market
 * @param financialRightsRTM Flag to indicate this contract provides financial rights in the RT Market
 * @param fuelAdder Estimated Fuel Adder
 * @param latestSchedMinutes This indicates the latest schedule minutes (e.g. t - xx) that this resource can be notified to respond.
 *        This attribute is only used if the market type is not supplied.
 * @param latestSchedMktType This indicates the latest schedule market type a contract can be applied to.
 *        This is used in conjunction with the latestSchedMinutes attribute to determine the latest time this contract can be called in. The possible values for this attribute are: DAM, RTM or it can be omitted. If omitted, the latestSchedMinutes attribute defines the value.
 * @param maxNetDependableCapacity Maximum Net Dependable Capacity
 * @param maximumScheduleQuantity Maximum schedule MW quantity
 * @param maximumServiceHours Maximum service hours
 * @param maximumStartups Maximum startups
 * @param minimumLoad Minimum Load
 * @param minimumScheduleQuantity Minimum schedule quanity
 * @param physicalRightsDAM Flag to indicate this contract provides physical rights in the DA Market
 * @param physicalRightsRTM Flag to indicate this contract provides physical rights in the RT Market
 * @param startEffectiveDate start effective date
 * @param startupLeadTime Start up lead time
 * @param Chain_TransmissionRightChain
 * @param Ind_TransmissionRightChain
 * @param RTO
 * @param SchedulingCoordinator
 * @param TRType Transmission Right type - is this an individual contract right or a chain contract right.
 *        Types = CHAIN or INDIVIDUAL
 */
case class ContractRight
(
    override val sup: Element,
    val chainOrder: Int,
    val contractMW: Double,
    val contractPrice: Double,
    val contractPriority: Int,
    val contractStatus: String,
    val contractType: String,
    val endEffectiveDate: String,
    val financialLocation: String,
    val financialRightsDAM: String,
    val financialRightsRTM: String,
    val fuelAdder: Double,
    val latestSchedMinutes: Int,
    val latestSchedMktType: String,
    val maxNetDependableCapacity: Double,
    val maximumScheduleQuantity: Double,
    val maximumServiceHours: Int,
    val maximumStartups: Int,
    val minimumLoad: Double,
    val minimumScheduleQuantity: Double,
    val physicalRightsDAM: String,
    val physicalRightsRTM: String,
    val startEffectiveDate: String,
    val startupLeadTime: Int,
    val Chain_TransmissionRightChain: String,
    val Ind_TransmissionRightChain: String,
    val RTO: String,
    val SchedulingCoordinator: String,
    val TRType: String
)
extends
    Element
{
    def this () = { this (null, 0, 0.0, 0.0, 0, null, null, null, null, null, null, 0.0, 0, null, 0.0, 0.0, 0, 0, 0.0, 0.0, null, null, null, 0, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ContractRight]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ContractRight
extends
    Parseable[ContractRight]
{
    val sup = IdentifiedObject.parse _
    val chainOrder = parse_element (element ("""ContractRight.chainOrder"""))
    val contractMW = parse_element (element ("""ContractRight.contractMW"""))
    val contractPrice = parse_element (element ("""ContractRight.contractPrice"""))
    val contractPriority = parse_element (element ("""ContractRight.contractPriority"""))
    val contractStatus = parse_element (element ("""ContractRight.contractStatus"""))
    val contractType = parse_attribute (attribute ("""ContractRight.contractType"""))
    val endEffectiveDate = parse_element (element ("""ContractRight.endEffectiveDate"""))
    val financialLocation = parse_attribute (attribute ("""ContractRight.financialLocation"""))
    val financialRightsDAM = parse_attribute (attribute ("""ContractRight.financialRightsDAM"""))
    val financialRightsRTM = parse_attribute (attribute ("""ContractRight.financialRightsRTM"""))
    val fuelAdder = parse_element (element ("""ContractRight.fuelAdder"""))
    val latestSchedMinutes = parse_element (element ("""ContractRight.latestSchedMinutes"""))
    val latestSchedMktType = parse_attribute (attribute ("""ContractRight.latestSchedMktType"""))
    val maxNetDependableCapacity = parse_element (element ("""ContractRight.maxNetDependableCapacity"""))
    val maximumScheduleQuantity = parse_element (element ("""ContractRight.maximumScheduleQuantity"""))
    val maximumServiceHours = parse_element (element ("""ContractRight.maximumServiceHours"""))
    val maximumStartups = parse_element (element ("""ContractRight.maximumStartups"""))
    val minimumLoad = parse_element (element ("""ContractRight.minimumLoad"""))
    val minimumScheduleQuantity = parse_element (element ("""ContractRight.minimumScheduleQuantity"""))
    val physicalRightsDAM = parse_attribute (attribute ("""ContractRight.physicalRightsDAM"""))
    val physicalRightsRTM = parse_attribute (attribute ("""ContractRight.physicalRightsRTM"""))
    val startEffectiveDate = parse_element (element ("""ContractRight.startEffectiveDate"""))
    val startupLeadTime = parse_element (element ("""ContractRight.startupLeadTime"""))
    val Chain_TransmissionRightChain = parse_attribute (attribute ("""ContractRight.Chain_TransmissionRightChain"""))
    val Ind_TransmissionRightChain = parse_attribute (attribute ("""ContractRight.Ind_TransmissionRightChain"""))
    val RTO = parse_attribute (attribute ("""ContractRight.RTO"""))
    val SchedulingCoordinator = parse_attribute (attribute ("""ContractRight.SchedulingCoordinator"""))
    val TRType = parse_attribute (attribute ("""ContractRight.TRType"""))
    def parse (context: Context): ContractRight =
    {
        ContractRight(
            sup (context),
            toInteger (chainOrder (context), context),
            toDouble (contractMW (context), context),
            toDouble (contractPrice (context), context),
            toInteger (contractPriority (context), context),
            contractStatus (context),
            contractType (context),
            endEffectiveDate (context),
            financialLocation (context),
            financialRightsDAM (context),
            financialRightsRTM (context),
            toDouble (fuelAdder (context), context),
            toInteger (latestSchedMinutes (context), context),
            latestSchedMktType (context),
            toDouble (maxNetDependableCapacity (context), context),
            toDouble (maximumScheduleQuantity (context), context),
            toInteger (maximumServiceHours (context), context),
            toInteger (maximumStartups (context), context),
            toDouble (minimumLoad (context), context),
            toDouble (minimumScheduleQuantity (context), context),
            physicalRightsDAM (context),
            physicalRightsRTM (context),
            startEffectiveDate (context),
            toInteger (startupLeadTime (context), context),
            Chain_TransmissionRightChain (context),
            Ind_TransmissionRightChain (context),
            RTO (context),
            SchedulingCoordinator (context),
            TRType (context)
        )
    }
}

/**
 * Indicates Control Area associated with self-schedule.
 * @param sup Reference to the superclass object.
 * @param attained Attained.
 * @param native Native.
 * @param RegisteredResource
 * @param SubControlArea
 */
case class ControlAreaDesignation
(
    override val sup: Element,
    val attained: String,
    val native: String,
    val RegisteredResource: List[String],
    val SubControlArea: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, List(), List()) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ControlAreaDesignation]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ControlAreaDesignation
extends
    Parseable[ControlAreaDesignation]
{
    val sup = BasicElement.parse _
    val attained = parse_attribute (attribute ("""ControlAreaDesignation.attained"""))
    val native = parse_attribute (attribute ("""ControlAreaDesignation.native"""))
    val RegisteredResource = parse_attributes (attribute ("""ControlAreaDesignation.RegisteredResource"""))
    val SubControlArea = parse_attributes (attribute ("""ControlAreaDesignation.SubControlArea"""))
    def parse (context: Context): ControlAreaDesignation =
    {
        ControlAreaDesignation(
            sup (context),
            attained (context),
            native (context),
            RegisteredResource (context),
            SubControlArea (context)
        )
    }
}

/**
 * A flowgate, is single or group of transmission elements intended to model MW flow impact relating to transmission limitations and transmission service usage.
 * @param sup Reference to the superclass object.
 * @param direction The direction of the flowgate, export or import
 * @param endEffectiveDate end effective date
 * @param exportMWRating Export MW rating
 * @param importMWRating Import MW rating
 * @param startEffectiveDate start effective date
 * @param CRR
 * @param From_SubControlArea
 * @param GenericConstraints
 * @param HostControlArea
 * @param MktLine
 * @param MktPowerTransformer
 * @param SecurityConstraints
 * @param To_SubControlArea
 */
case class Flowgate
(
    override val sup: Element,
    val direction: String,
    val endEffectiveDate: String,
    val exportMWRating: Double,
    val importMWRating: Double,
    val startEffectiveDate: String,
    val CRR: String,
    val From_SubControlArea: String,
    val GenericConstraints: String,
    val HostControlArea: String,
    val MktLine: List[String],
    val MktPowerTransformer: List[String],
    val SecurityConstraints: String,
    val To_SubControlArea: String
)
extends
    Element
{
    def this () = { this (null, null, null, 0.0, 0.0, null, null, null, null, null, List(), List(), null, null) }
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { return (clone ().asInstanceOf[Flowgate]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Flowgate
extends
    Parseable[Flowgate]
{
    val sup = PowerSystemResource.parse _
    val direction = parse_attribute (attribute ("""Flowgate.direction"""))
    val endEffectiveDate = parse_element (element ("""Flowgate.endEffectiveDate"""))
    val exportMWRating = parse_element (element ("""Flowgate.exportMWRating"""))
    val importMWRating = parse_element (element ("""Flowgate.importMWRating"""))
    val startEffectiveDate = parse_element (element ("""Flowgate.startEffectiveDate"""))
    val CRR = parse_attribute (attribute ("""Flowgate.CRR"""))
    val From_SubControlArea = parse_attribute (attribute ("""Flowgate.From_SubControlArea"""))
    val GenericConstraints = parse_attribute (attribute ("""Flowgate.GenericConstraints"""))
    val HostControlArea = parse_attribute (attribute ("""Flowgate.HostControlArea"""))
    val MktLine = parse_attributes (attribute ("""Flowgate.MktLine"""))
    val MktPowerTransformer = parse_attributes (attribute ("""Flowgate.MktPowerTransformer"""))
    val SecurityConstraints = parse_attribute (attribute ("""Flowgate.SecurityConstraints"""))
    val To_SubControlArea = parse_attribute (attribute ("""Flowgate.To_SubControlArea"""))
    def parse (context: Context): Flowgate =
    {
        Flowgate(
            sup (context),
            direction (context),
            endEffectiveDate (context),
            toDouble (exportMWRating (context), context),
            toDouble (importMWRating (context), context),
            startEffectiveDate (context),
            CRR (context),
            From_SubControlArea (context),
            GenericConstraints (context),
            HostControlArea (context),
            MktLine (context),
            MktPowerTransformer (context),
            SecurityConstraints (context),
            To_SubControlArea (context)
        )
    }
}

/**
 * Flowgate defined partner
 * @param sup Reference to the superclass object.
 * @param FlowgateValue
 */
case class FlowgatePartner
(
    override val sup: Element,
    val FlowgateValue: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[FlowgatePartner]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object FlowgatePartner
extends
    Parseable[FlowgatePartner]
{
    val sup = IdentifiedObject.parse _
    val FlowgateValue = parse_attribute (attribute ("""FlowgatePartner.FlowgateValue"""))
    def parse (context: Context): FlowgatePartner =
    {
        FlowgatePartner(
            sup (context),
            FlowgateValue (context)
        )
    }
}

/**
 * IDC (Interchange Distribution Calulator) sends data for a TLR (Transmission Loading Relief).
 * @param sup Reference to the superclass object.
 * @param effectiveDate Date/Time when record becomes effective
 *        Used to determine when a record becomes effective.
 * @param idcTargetMktFlow Energy Flow level that should be maintained according to the TLR rules as specified by the IDC.
 *        For Realtime Markets use in dispatch to control constraints under TLR and calculate unconstrained market flows
 * @param terminateDate Date/Time when record is no longer effective
 *        Used to determine when a record is no longer effective
 * @param Flowgate
 */
case class FlowgateRelief
(
    override val sup: Element,
    val effectiveDate: String,
    val idcTargetMktFlow: Int,
    val terminateDate: String,
    val Flowgate: String
)
extends
    Element
{
    def this () = { this (null, null, 0, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[FlowgateRelief]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object FlowgateRelief
extends
    Parseable[FlowgateRelief]
{
    val sup = BasicElement.parse _
    val effectiveDate = parse_element (element ("""FlowgateRelief.effectiveDate"""))
    val idcTargetMktFlow = parse_element (element ("""FlowgateRelief.idcTargetMktFlow"""))
    val terminateDate = parse_element (element ("""FlowgateRelief.terminateDate"""))
    val Flowgate = parse_attribute (attribute ("""FlowgateRelief.Flowgate"""))
    def parse (context: Context): FlowgateRelief =
    {
        FlowgateRelief(
            sup (context),
            effectiveDate (context),
            toInteger (idcTargetMktFlow (context), context),
            terminateDate (context),
            Flowgate (context)
        )
    }
}

/**
 * Day Ahead,  Network Native Load, Economic Dispatch, values used for calculation of Network Native Load (NNL) Determinator process.
 * @param sup Reference to the superclass object.
 * @param economicDispatchLimit Limit for Economic Dispatch priority 6 energy flow on the specified flowgate for the specified time period.
 * @param effectiveDate Date/Time when record becomes effective
 *        Used to determine when a record becomes effective
 * @param firmNetworkLimit Limit for firm flow on the specified flowgate for the specified time period.
 *        The amount of energy flow over a specifed flowgate due to generation in the market which can be classified as Firm Network priority.
 * @param flowDirectionFlag Specifies the direction of energy flow in the flowgate
 * @param mktFlow The amount of energy flow over a specifed flowgate due to generation in the market.
 * @param netFirmNetworkLimit Net Energy flow in flowgate for the associated FlowgatePartner
 * @param Flowgate
 * @param FlowgatePartner
 */
case class FlowgateValue
(
    override val sup: Element,
    val economicDispatchLimit: Int,
    val effectiveDate: String,
    val firmNetworkLimit: Int,
    val flowDirectionFlag: String,
    val mktFlow: Int,
    val netFirmNetworkLimit: Int,
    val Flowgate: String,
    val FlowgatePartner: String
)
extends
    Element
{
    def this () = { this (null, 0, null, 0, null, 0, 0, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[FlowgateValue]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object FlowgateValue
extends
    Parseable[FlowgateValue]
{
    val sup = BasicElement.parse _
    val economicDispatchLimit = parse_element (element ("""FlowgateValue.economicDispatchLimit"""))
    val effectiveDate = parse_element (element ("""FlowgateValue.effectiveDate"""))
    val firmNetworkLimit = parse_element (element ("""FlowgateValue.firmNetworkLimit"""))
    val flowDirectionFlag = parse_attribute (attribute ("""FlowgateValue.flowDirectionFlag"""))
    val mktFlow = parse_element (element ("""FlowgateValue.mktFlow"""))
    val netFirmNetworkLimit = parse_element (element ("""FlowgateValue.netFirmNetworkLimit"""))
    val Flowgate = parse_attribute (attribute ("""FlowgateValue.Flowgate"""))
    val FlowgatePartner = parse_attribute (attribute ("""FlowgateValue.FlowgatePartner"""))
    def parse (context: Context): FlowgateValue =
    {
        FlowgateValue(
            sup (context),
            toInteger (economicDispatchLimit (context), context),
            effectiveDate (context),
            toInteger (firmNetworkLimit (context), context),
            flowDirectionFlag (context),
            toInteger (mktFlow (context), context),
            toInteger (netFirmNetworkLimit (context), context),
            Flowgate (context),
            FlowgatePartner (context)
        )
    }
}

/**
 * Forbbiden region is operating ranges where the units are unable to maintain steady operation without causing equipment damage.
 * The four attributes that define a forbidden region are the low MW, the High MW, the crossing time, and the crossing cost.
 * @param sup Reference to the superclass object.
 * @param crossTime Time to cross the forbidden region in minutes.
 * @param crossingCost Cost associated with crossing the forbidden region
 * @param highMW High end of the region definition
 * @param lowMW Low end of the region definition.
 */
case class ForbiddenRegion
(
    override val sup: Element,
    val crossTime: Int,
    val crossingCost: Double,
    val highMW: Double,
    val lowMW: Double
)
extends
    Element
{
    def this () = { this (null, 0, 0.0, 0.0, 0.0) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ForbiddenRegion]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ForbiddenRegion
extends
    Parseable[ForbiddenRegion]
{
    val sup = IdentifiedObject.parse _
    val crossTime = parse_element (element ("""ForbiddenRegion.crossTime"""))
    val crossingCost = parse_element (element ("""ForbiddenRegion.crossingCost"""))
    val highMW = parse_element (element ("""ForbiddenRegion.highMW"""))
    val lowMW = parse_element (element ("""ForbiddenRegion.lowMW"""))
    def parse (context: Context): ForbiddenRegion =
    {
        ForbiddenRegion(
            sup (context),
            toInteger (crossTime (context), context),
            toDouble (crossingCost (context), context),
            toDouble (highMW (context), context),
            toDouble (lowMW (context), context)
        )
    }
}

/**
 * Used to indicate former references to the same piece of equipment.
 * The ID, name, and effectivity dates are utilized.
 * @param sup Reference to the superclass object.
 * @param RegisteredResource
 */
case class FormerReference
(
    override val sup: Element,
    val RegisteredResource: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[FormerReference]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object FormerReference
extends
    Parseable[FormerReference]
{
    val sup = IdentifiedObject.parse _
    val RegisteredResource = parse_attribute (attribute ("""FormerReference.RegisteredResource"""))
    def parse (context: Context): FormerReference =
    {
        FormerReference(
            sup (context),
            RegisteredResource (context)
        )
    }
}

/**
 * Relationship between unit fuel cost in $/kWh(Y-axis) and  unit output in MW (X-axis).
 * @param sup Reference to the superclass object.
 * @param RegisteredGenerator
 */
case class FuelCostCurve
(
    override val sup: Element,
    val RegisteredGenerator: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { return (clone ().asInstanceOf[FuelCostCurve]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object FuelCostCurve
extends
    Parseable[FuelCostCurve]
{
    val sup = Curve.parse _
    val RegisteredGenerator = parse_attribute (attribute ("""FuelCostCurve.RegisteredGenerator"""))
    def parse (context: Context): FuelCostCurve =
    {
        FuelCostCurve(
            sup (context),
            RegisteredGenerator (context)
        )
    }
}

/**
 * Indication of region for fuel inventory purposes
 * @param sup Reference to the superclass object.
 * @param endEffectiveDate end effective date
 * @param fuelRegionType The type of fuel region
 * @param lastModified Time of last update
 * @param startEffectiveDate start effective date
 * @param GasPrice
 * @param OilPrice
 * @param RTO
 */
case class FuelRegion
(
    override val sup: Element,
    val endEffectiveDate: String,
    val fuelRegionType: String,
    val lastModified: String,
    val startEffectiveDate: String,
    val GasPrice: String,
    val OilPrice: String,
    val RTO: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[FuelRegion]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object FuelRegion
extends
    Parseable[FuelRegion]
{
    val sup = IdentifiedObject.parse _
    val endEffectiveDate = parse_element (element ("""FuelRegion.endEffectiveDate"""))
    val fuelRegionType = parse_element (element ("""FuelRegion.fuelRegionType"""))
    val lastModified = parse_element (element ("""FuelRegion.lastModified"""))
    val startEffectiveDate = parse_element (element ("""FuelRegion.startEffectiveDate"""))
    val GasPrice = parse_attribute (attribute ("""FuelRegion.GasPrice"""))
    val OilPrice = parse_attribute (attribute ("""FuelRegion.OilPrice"""))
    val RTO = parse_attribute (attribute ("""FuelRegion.RTO"""))
    def parse (context: Context): FuelRegion =
    {
        FuelRegion(
            sup (context),
            endEffectiveDate (context),
            fuelRegionType (context),
            lastModified (context),
            startEffectiveDate (context),
            GasPrice (context),
            OilPrice (context),
            RTO (context)
        )
    }
}

/**
 * Price of gas in monetary units
 * @param sup Reference to the superclass object.
 * @param gasPriceIndex The average natural gas price at a defined fuel region.
 * @param FuelRegion
 */
case class GasPrice
(
    override val sup: Element,
    val gasPriceIndex: Double,
    val FuelRegion: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[GasPrice]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GasPrice
extends
    Parseable[GasPrice]
{
    val sup = BasicElement.parse _
    val gasPriceIndex = parse_element (element ("""GasPrice.gasPriceIndex"""))
    val FuelRegion = parse_attribute (attribute ("""GasPrice.FuelRegion"""))
    def parse (context: Context): GasPrice =
    {
        GasPrice(
            sup (context),
            toDouble (gasPriceIndex (context), context),
            FuelRegion (context)
        )
    }
}

/**
 * A HostControlArea has a set of tie points and a set of generator controls (i.e., AGC).
 * It also has a total load, including transmission and distribution losses.
 * @param sup Reference to the superclass object.
 * @param areaControlMode The area's present control mode: (CF = constant frequency) or (CTL = constant tie-line) or (TLB = tie-line bias) or (OFF = off control)
 * @param endEffectiveDate end effective date
 * @param freqSetPoint The present power system frequency set point for automatic generation control
 * @param frequencyBiasFactor The control area's frequency bias factor, in MW/0.1 Hz, for automatic generation control (AGC)
 * @param startEffectiveDate start effective date
 * @param AdjacentCASet
 * @param Controls A ControlAreaCompany controls a ControlArea.
 * @param RTO
 */
case class HostControlArea
(
    override val sup: Element,
    val areaControlMode: String,
    val endEffectiveDate: String,
    val freqSetPoint: Double,
    val frequencyBiasFactor: Double,
    val startEffectiveDate: String,
    val AdjacentCASet: String,
    val Controls: String,
    val RTO: String
)
extends
    Element
{
    def this () = { this (null, null, null, 0.0, 0.0, null, null, null, null) }
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { return (clone ().asInstanceOf[HostControlArea]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object HostControlArea
extends
    Parseable[HostControlArea]
{
    val sup = PowerSystemResource.parse _
    val areaControlMode = parse_attribute (attribute ("""HostControlArea.areaControlMode"""))
    val endEffectiveDate = parse_element (element ("""HostControlArea.endEffectiveDate"""))
    val freqSetPoint = parse_element (element ("""HostControlArea.freqSetPoint"""))
    val frequencyBiasFactor = parse_element (element ("""HostControlArea.frequencyBiasFactor"""))
    val startEffectiveDate = parse_element (element ("""HostControlArea.startEffectiveDate"""))
    val AdjacentCASet = parse_attribute (attribute ("""HostControlArea.AdjacentCASet"""))
    val Controls = parse_attribute (attribute ("""HostControlArea.Controls"""))
    val RTO = parse_attribute (attribute ("""HostControlArea.RTO"""))
    def parse (context: Context): HostControlArea =
    {
        HostControlArea(
            sup (context),
            areaControlMode (context),
            endEffectiveDate (context),
            toDouble (freqSetPoint (context), context),
            toDouble (frequencyBiasFactor (context), context),
            startEffectiveDate (context),
            AdjacentCASet (context),
            Controls (context),
            RTO (context)
        )
    }
}

/**
 * Individual pricing node based on Pnode
 * @param sup Reference to the superclass object.
 * @param GenDistributionFactor
 * @param LoadDistributionFactor
 * @param MktConnectivityNode
 */
case class IndividualPnode
(
    override val sup: Element,
    val GenDistributionFactor: String,
    val LoadDistributionFactor: String,
    val MktConnectivityNode: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Pnode: Pnode = sup.asInstanceOf[Pnode]
    override def copy (): Row = { return (clone ().asInstanceOf[IndividualPnode]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object IndividualPnode
extends
    Parseable[IndividualPnode]
{
    val sup = Pnode.parse _
    val GenDistributionFactor = parse_attribute (attribute ("""IndividualPnode.GenDistributionFactor"""))
    val LoadDistributionFactor = parse_attribute (attribute ("""IndividualPnode.LoadDistributionFactor"""))
    val MktConnectivityNode = parse_attribute (attribute ("""IndividualPnode.MktConnectivityNode"""))
    def parse (context: Context): IndividualPnode =
    {
        IndividualPnode(
            sup (context),
            GenDistributionFactor (context),
            LoadDistributionFactor (context),
            MktConnectivityNode (context)
        )
    }
}

/**
 * A specialized class of type AggregatedNode type.
 * Defines Load Aggregation Points.
 * @param sup Reference to the superclass object.
 */
case class LoadAggregationPoint
(
    override val sup: Element
)
extends
    Element
{
    def this () = { this (null) }
    def AggregateNode: AggregateNode = sup.asInstanceOf[AggregateNode]
    override def copy (): Row = { return (clone ().asInstanceOf[LoadAggregationPoint]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object LoadAggregationPoint
extends
    Parseable[LoadAggregationPoint]
{
    val sup = AggregateNode.parse _
    def parse (context: Context): LoadAggregationPoint =
    {
        LoadAggregationPoint(
            sup (context)
        )
    }
}

/**
 * Representing the ratio of the load share for the associated SC.
 * @param sup Reference to the superclass object.
 * @param intervalEndTime Interval End Time
 * @param intervalStartTime Interval Start Time
 * @param share Share in percentage of total Market load for the selected time interval.
 * @param SchedulingCoordinator
 */
case class LoadRatio
(
    override val sup: Element,
    val intervalEndTime: String,
    val intervalStartTime: String,
    val share: Double,
    val SchedulingCoordinator: String
)
extends
    Element
{
    def this () = { this (null, null, null, 0.0, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[LoadRatio]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object LoadRatio
extends
    Parseable[LoadRatio]
{
    val sup = BasicElement.parse _
    val intervalEndTime = parse_element (element ("""LoadRatio.intervalEndTime"""))
    val intervalStartTime = parse_element (element ("""LoadRatio.intervalStartTime"""))
    val share = parse_element (element ("""LoadRatio.share"""))
    val SchedulingCoordinator = parse_attribute (attribute ("""LoadRatio.SchedulingCoordinator"""))
    def parse (context: Context): LoadRatio =
    {
        LoadRatio(
            sup (context),
            intervalEndTime (context),
            intervalStartTime (context),
            toDouble (share (context), context),
            SchedulingCoordinator (context)
        )
    }
}

/**
 * This is the cureve that describes the load reduction time.
 * Relationship between time (Y1-axis) vs. MW (X-axis).
 * @param sup Reference to the superclass object.
 * @param loadReductionTimeCurveType type of the curve: Possible values are but not limited to:
 *        Max, Min,
 */
case class LoadReductionTimeCurve
(
    override val sup: Element,
    val loadReductionTimeCurveType: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { return (clone ().asInstanceOf[LoadReductionTimeCurve]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object LoadReductionTimeCurve
extends
    Parseable[LoadReductionTimeCurve]
{
    val sup = Curve.parse _
    val loadReductionTimeCurveType = parse_element (element ("""LoadReductionTimeCurve.loadReductionTimeCurveType"""))
    def parse (context: Context): LoadReductionTimeCurve =
    {
        LoadReductionTimeCurve(
            sup (context),
            loadReductionTimeCurveType (context)
        )
    }
}

/**
 * Allows definition of reliablity areas (eg load pockets) within the ISO/RTO
 * @param sup Reference to the superclass object.
 * @param RTO
 */
case class LocalReliabilityArea
(
    override val sup: Element,
    val RTO: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[LocalReliabilityArea]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object LocalReliabilityArea
extends
    Parseable[LocalReliabilityArea]
{
    val sup = IdentifiedObject.parse _
    val RTO = parse_attribute (attribute ("""LocalReliabilityArea.RTO"""))
    def parse (context: Context): LocalReliabilityArea =
    {
        LocalReliabilityArea(
            sup (context),
            RTO (context)
        )
    }
}

/**
 * Provides a reference to the Market Power Mitigation test identifiers and methods for the results of the DA or RT markets.
 * Specific data is the test identifier (Price, Conduct, or Impact) and the test method (System MPM, Local MPM, Alternate System MPM, or Alternate Local MPM).
 * @param sup Reference to the superclass object.
 * @param purposeFlag Nature of threshold data:
'M' - Mitigation threshold
 *        'R' - Reporting threshold
 * @param testIdentifier 1 - Global Price Test
2 - Global Conduct Test
3 - Global Impact Test
4 - Local Price Test
5 - Local Conduct Test
 *        6 - Local Impact Test
 * @param testMethod The method of performing the market power monitoring.
 *        Examples are Normal (default) thresholds or Alternate thresholds.
 */
case class MPMTestCategory
(
    override val sup: Element,
    val purposeFlag: String,
    val testIdentifier: String,
    val testMethod: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[MPMTestCategory]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MPMTestCategory
extends
    Parseable[MPMTestCategory]
{
    val sup = IdentifiedObject.parse _
    val purposeFlag = parse_attribute (attribute ("""MPMTestCategory.purposeFlag"""))
    val testIdentifier = parse_attribute (attribute ("""MPMTestCategory.testIdentifier"""))
    val testMethod = parse_attribute (attribute ("""MPMTestCategory.testMethod"""))
    def parse (context: Context): MPMTestCategory =
    {
        MPMTestCategory(
            sup (context),
            purposeFlag (context),
            testIdentifier (context),
            testMethod (context)
        )
    }
}

/**
 * Market Power Mitigation (MPM) test thresholds for resource as well as designated congestion areas (DCAs)
 * @param sup Reference to the superclass object.
 * @param marketType Market Type (DAM, RTM)
 * @param percent Price Threshold in %
 * @param price Price Threshold in $/MW
 * @param MPMTestCategory
 * @param RegisteredResource
 */
case class MPMTestThreshold
(
    override val sup: Element,
    val marketType: String,
    val percent: Double,
    val price: Double,
    val MPMTestCategory: String,
    val RegisteredResource: List[String]
)
extends
    Element
{
    def this () = { this (null, null, 0.0, 0.0, null, List()) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[MPMTestThreshold]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MPMTestThreshold
extends
    Parseable[MPMTestThreshold]
{
    val sup = BasicElement.parse _
    val marketType = parse_attribute (attribute ("""MPMTestThreshold.marketType"""))
    val percent = parse_element (element ("""MPMTestThreshold.percent"""))
    val price = parse_element (element ("""MPMTestThreshold.price"""))
    val MPMTestCategory = parse_attribute (attribute ("""MPMTestThreshold.MPMTestCategory"""))
    val RegisteredResource = parse_attributes (attribute ("""MPMTestThreshold.RegisteredResource"""))
    def parse (context: Context): MPMTestThreshold =
    {
        MPMTestThreshold(
            sup (context),
            marketType (context),
            toDouble (percent (context), context),
            toDouble (price (context), context),
            MPMTestCategory (context),
            RegisteredResource (context)
        )
    }
}

/**
 * Metered Sub-System aggregation of MSS Zones.
 * @param sup Reference to the superclass object.
 * @param costRecovery Charge for Emission Costs, Start Up Costs, or Minimum Load Costs.
 * @param endEffectiveDate end effective date
 * @param grossSettlement MSS Load Following may select Net vs.
 *        Gross settlement.  Net Settlement requires the net Demand settled at the MSS LAP and Net Supply needs to settle at the equivalent to the weighted average price of the MSS generation.  Gross load will be settled at the System LAP and the Gross supply will be settled at the LMP.  MSS Aggregation that elects gross settlement shall have to identify if its resources are Load Following or not.
 * @param ignoreLosses Provides an indication if losses are to be ignored for this zone.
 *        Also refered to as Exclude Marginal Losses.
 * @param ignoreMarginalLosses Provides an indication if marginal losses are to be ignored for this zone.
 * @param loadFollowing Indication that this particular MSSA participates in the Load Following function.
 * @param rucProcurement Indicates that RUC will be procured by the ISO or self provided.
 * @param startEffectiveDate start effective date
 * @param RTO
 */
case class MSSAggregation
(
    override val sup: Element,
    val costRecovery: String,
    val endEffectiveDate: String,
    val grossSettlement: String,
    val ignoreLosses: String,
    val ignoreMarginalLosses: String,
    val loadFollowing: String,
    val rucProcurement: String,
    val startEffectiveDate: String,
    val RTO: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[MSSAggregation]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MSSAggregation
extends
    Parseable[MSSAggregation]
{
    val sup = IdentifiedObject.parse _
    val costRecovery = parse_attribute (attribute ("""MSSAggregation.costRecovery"""))
    val endEffectiveDate = parse_element (element ("""MSSAggregation.endEffectiveDate"""))
    val grossSettlement = parse_attribute (attribute ("""MSSAggregation.grossSettlement"""))
    val ignoreLosses = parse_attribute (attribute ("""MSSAggregation.ignoreLosses"""))
    val ignoreMarginalLosses = parse_attribute (attribute ("""MSSAggregation.ignoreMarginalLosses"""))
    val loadFollowing = parse_attribute (attribute ("""MSSAggregation.loadFollowing"""))
    val rucProcurement = parse_attribute (attribute ("""MSSAggregation.rucProcurement"""))
    val startEffectiveDate = parse_element (element ("""MSSAggregation.startEffectiveDate"""))
    val RTO = parse_attribute (attribute ("""MSSAggregation.RTO"""))
    def parse (context: Context): MSSAggregation =
    {
        MSSAggregation(
            sup (context),
            costRecovery (context),
            endEffectiveDate (context),
            grossSettlement (context),
            ignoreLosses (context),
            ignoreMarginalLosses (context),
            loadFollowing (context),
            rucProcurement (context),
            startEffectiveDate (context),
            RTO (context)
        )
    }
}

/**
 * Model to define a zone within a Metered Sub System
 * @param sup Reference to the superclass object.
 * @param ignoreLosses Provides an indication if losses are to be ignored for this metered subsystem zone.
 * @param lossFactor This is the default loss factor for the Metered Sub-System (MSS) zone.
 *        The actual losses are calculated during the RT market.
 * @param rucGrossSettlement Metered Sub-System (MSS) Load Following may select Net vs.
 *        Gross settlement.  Net Settlement requires the net Demand settled at the Metered Sub-Sustem (MSS) Load Aggregation Point (LAP) and Net Supply needs to settle at the equivalent to the weighted average price of the MSS generation.  Gross load will be settled at the System LAP and the Gross supply will be settled at the LMP.  MSS Aggregation that elects gross settlement shall have to identify if its resources are Load Following or not.
 * @param MeteredSubSystem
 */
case class MSSZone
(
    override val sup: Element,
    val ignoreLosses: String,
    val lossFactor: Double,
    val rucGrossSettlement: String,
    val MeteredSubSystem: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, null, null) }
    def AggregateNode: AggregateNode = sup.asInstanceOf[AggregateNode]
    override def copy (): Row = { return (clone ().asInstanceOf[MSSZone]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MSSZone
extends
    Parseable[MSSZone]
{
    val sup = AggregateNode.parse _
    val ignoreLosses = parse_attribute (attribute ("""MSSZone.ignoreLosses"""))
    val lossFactor = parse_element (element ("""MSSZone.lossFactor"""))
    val rucGrossSettlement = parse_attribute (attribute ("""MSSZone.rucGrossSettlement"""))
    val MeteredSubSystem = parse_attribute (attribute ("""MSSZone.MeteredSubSystem"""))
    def parse (context: Context): MSSZone =
    {
        MSSZone(
            sup (context),
            ignoreLosses (context),
            toDouble (lossFactor (context), context),
            rucGrossSettlement (context),
            MeteredSubSystem (context)
        )
    }
}

/**
 * General purpose information for name and other information to contact people.
 * @param sup Reference to the superclass object.
 * @param category Category of this person relative to utility operations, classified according to the utility's corporate standards and practices.
 *        Examples include employee, contractor, agent, not affiliated, etc.
 * @param electronicAddressAlternate Alternate Electronic address.
 * @param electronicAddressPrimary Primary Electronic address.
 * @param firstName Person's first name.
 * @param governmentID Unique identifier for person relative to its governing authority, for example a federal tax identifier (such as a Social Security number in the United States).
 * @param landlinePhone Landline phone number.
 * @param lastName Person's last (family, sir) name.
 * @param mName Middle name(s) or initial(s).
 * @param mobilePhone Mobile phone number.
 * @param prefix A prefix or title for the person's name, such as Miss, Mister, Doctor, etc.
 * @param specialNeed Special service needs for the person (contact) are described; examples include life support, etc.
 * @param status
 * @param suffix A suffix for the person's name, such as II, III, etc.
 * @param userID The user name for the person; required to log in.
 */
case class MarketPerson
(
    override val sup: Element,
    val category: String,
    val electronicAddressAlternate: String,
    val electronicAddressPrimary: String,
    val firstName: String,
    val governmentID: String,
    val landlinePhone: String,
    val lastName: String,
    val mName: String,
    val mobilePhone: String,
    val prefix: String,
    val specialNeed: String,
    val status: String,
    val suffix: String,
    val userID: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[MarketPerson]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MarketPerson
extends
    Parseable[MarketPerson]
{
    val sup = IdentifiedObject.parse _
    val category = parse_element (element ("""MarketPerson.category"""))
    val electronicAddressAlternate = parse_attribute (attribute ("""MarketPerson.electronicAddressAlternate"""))
    val electronicAddressPrimary = parse_attribute (attribute ("""MarketPerson.electronicAddressPrimary"""))
    val firstName = parse_element (element ("""MarketPerson.firstName"""))
    val governmentID = parse_element (element ("""MarketPerson.governmentID"""))
    val landlinePhone = parse_attribute (attribute ("""MarketPerson.landlinePhone"""))
    val lastName = parse_element (element ("""MarketPerson.lastName"""))
    val mName = parse_element (element ("""MarketPerson.mName"""))
    val mobilePhone = parse_attribute (attribute ("""MarketPerson.mobilePhone"""))
    val prefix = parse_element (element ("""MarketPerson.prefix"""))
    val specialNeed = parse_element (element ("""MarketPerson.specialNeed"""))
    val status = parse_attribute (attribute ("""MarketPerson.status"""))
    val suffix = parse_element (element ("""MarketPerson.suffix"""))
    val userID = parse_element (element ("""MarketPerson.userID"""))
    def parse (context: Context): MarketPerson =
    {
        MarketPerson(
            sup (context),
            category (context),
            electronicAddressAlternate (context),
            electronicAddressPrimary (context),
            firstName (context),
            governmentID (context),
            landlinePhone (context),
            lastName (context),
            mName (context),
            mobilePhone (context),
            prefix (context),
            specialNeed (context),
            status (context),
            suffix (context),
            userID (context)
        )
    }
}

/**
 * Certain skills are required and shall be certified in order for a person (typically a member of a crew) to be qualified to work on types of equipment.
 * @param sup Reference to the superclass object.
 * @param effectiveDate Effective date of the privilege, terminate date of the privilege, or effective date of the application for the organization
 * @param expirationDate This is the terminate date of the application for the organization
 *        The specific organization can no longer access the application as of the terminate date
 * @param qualificationID Qualification identifier.
 * @param status The status of the privilege.
 *        Shows the status of the user�s qualification.
 * @param statusType This is the name of the status of the qualification and is used to display the status of the user's or organization's status.
 */
case class MarketQualificationRequirement
(
    override val sup: Element,
    val effectiveDate: String,
    val expirationDate: String,
    val qualificationID: String,
    val status: Int,
    val statusType: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, 0, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[MarketQualificationRequirement]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MarketQualificationRequirement
extends
    Parseable[MarketQualificationRequirement]
{
    val sup = IdentifiedObject.parse _
    val effectiveDate = parse_element (element ("""MarketQualificationRequirement.effectiveDate"""))
    val expirationDate = parse_element (element ("""MarketQualificationRequirement.expirationDate"""))
    val qualificationID = parse_element (element ("""MarketQualificationRequirement.qualificationID"""))
    val status = parse_element (element ("""MarketQualificationRequirement.status"""))
    val statusType = parse_element (element ("""MarketQualificationRequirement.statusType"""))
    def parse (context: Context): MarketQualificationRequirement =
    {
        MarketQualificationRequirement(
            sup (context),
            effectiveDate (context),
            expirationDate (context),
            qualificationID (context),
            toInteger (status (context), context),
            statusType (context)
        )
    }
}

/**
 * A specialized class of AggregatedNode type.
 * Defines the MarketRegions. Regions could be system Market Regions, Energy Regions or Ancillary Service Regions.
 * @param sup Reference to the superclass object.
 */
case class MarketRegion
(
    override val sup: Element
)
extends
    Element
{
    def this () = { this (null) }
    def AggregateNode: AggregateNode = sup.asInstanceOf[AggregateNode]
    override def copy (): Row = { return (clone ().asInstanceOf[MarketRegion]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MarketRegion
extends
    Parseable[MarketRegion]
{
    val sup = AggregateNode.parse _
    def parse (context: Context): MarketRegion =
    {
        MarketRegion(
            sup (context)
        )
    }
}

/**
 * Proficiency level of a craft, which is required to operate or maintain a particular type of asset and/or perform certain types of work.
 * @param sup Reference to the superclass object.
 * @param certificationPeriod Interval between the certification and its expiry.
 * @param effectiveDateTime Date and time the skill became effective.
 * @param level Level of skill for a Craft.
 * @param MarketPerson
 * @param MarketQualificationRequirements
 */
case class MarketSkill
(
    override val sup: Element,
    val certificationPeriod: String,
    val effectiveDateTime: String,
    val level: String,
    val MarketPerson: String,
    val MarketQualificationRequirements: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, List()) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { return (clone ().asInstanceOf[MarketSkill]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MarketSkill
extends
    Parseable[MarketSkill]
{
    val sup = Document.parse _
    val certificationPeriod = parse_attribute (attribute ("""MarketSkill.certificationPeriod"""))
    val effectiveDateTime = parse_element (element ("""MarketSkill.effectiveDateTime"""))
    val level = parse_element (element ("""MarketSkill.level"""))
    val MarketPerson = parse_attribute (attribute ("""MarketSkill.MarketPerson"""))
    val MarketQualificationRequirements = parse_attributes (attribute ("""MarketSkill.MarketQualificationRequirements"""))
    def parse (context: Context): MarketSkill =
    {
        MarketSkill(
            sup (context),
            certificationPeriod (context),
            effectiveDateTime (context),
            level (context),
            MarketPerson (context),
            MarketQualificationRequirements (context)
        )
    }
}

/**
 * The maximum Startup costs and time as a function of down time.
 * Relationship between unit startup cost (Y1-axis) vs. unit elapsed down time (X-axis). This is used to validate the information provided in the Bid.
 * @param sup Reference to the superclass object.
 */
case class MaxStartUpCostCurve
(
    override val sup: Element
)
extends
    Element
{
    def this () = { this (null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { return (clone ().asInstanceOf[MaxStartUpCostCurve]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MaxStartUpCostCurve
extends
    Parseable[MaxStartUpCostCurve]
{
    val sup = Curve.parse _
    def parse (context: Context): MaxStartUpCostCurve =
    {
        MaxStartUpCostCurve(
            sup (context)
        )
    }
}

/**
 * A metered subsystem
 * @param sup Reference to the superclass object.
 * @param MSSAggregation
 */
case class MeteredSubSystem
(
    override val sup: Element,
    val MSSAggregation: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[MeteredSubSystem]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MeteredSubSystem
extends
    Parseable[MeteredSubSystem]
{
    val sup = IdentifiedObject.parse _
    val MSSAggregation = parse_attribute (attribute ("""MeteredSubSystem.MSSAggregation"""))
    def parse (context: Context): MeteredSubSystem =
    {
        MeteredSubSystem(
            sup (context),
            MSSAggregation (context)
        )
    }
}

/**
 * Subclass of Production: CombinedCyclePlant from IEC61970 package.
 * A set of combustion turbines and steam turbines where the exhaust heat from the combustion turbines is recovered to make steam for the steam turbines, resulting in greater overall plant efficiency
 * @param sup Reference to the superclass object.
 * @param AggregatedPnode
 */
case class MktCombinedCyclePlant
(
    override val sup: Element,
    val AggregatedPnode: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def CombinedCyclePlant: CombinedCyclePlant = sup.asInstanceOf[CombinedCyclePlant]
    override def copy (): Row = { return (clone ().asInstanceOf[MktCombinedCyclePlant]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MktCombinedCyclePlant
extends
    Parseable[MktCombinedCyclePlant]
{
    val sup = CombinedCyclePlant.parse _
    val AggregatedPnode = parse_attribute (attribute ("""MktCombinedCyclePlant.AggregatedPnode"""))
    def parse (context: Context): MktCombinedCyclePlant =
    {
        MktCombinedCyclePlant(
            sup (context),
            AggregatedPnode (context)
        )
    }
}

/**
 * Subclass of IEC61970:Core:ConductingEquipment
 * @param sup Reference to the superclass object.
 */
case class MktConductingEquipment
(
    override val sup: Element
)
extends
    Element
{
    def this () = { this (null) }
    def ConductingEquipment: ConductingEquipment = sup.asInstanceOf[ConductingEquipment]
    override def copy (): Row = { return (clone ().asInstanceOf[MktConductingEquipment]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MktConductingEquipment
extends
    Parseable[MktConductingEquipment]
{
    val sup = ConductingEquipment.parse _
    def parse (context: Context): MktConductingEquipment =
    {
        MktConductingEquipment(
            sup (context)
        )
    }
}

/**
 * Subclass of IEC61970:Contingency
 * @param sup Reference to the superclass object.
 * @param loadRolloverFlag load change flag
 *        Flag that indicates whether load rollover and load pickup should be processed for this contingency
 * @param ltcControlFlag ltc enable flag
 *        Flag that indicates if LTCs regulate voltage during the solution of the contingency
 * @param participationFactorSet Participation Factor flag
 *        An indication which set of generator participation factors should be used to re-allocate generation in this contingency
 * @param screeningFlag sceening flag for outage
 *        Flag that indicated whether screening is bypassed for the contingency
 * @param TransferInterfaceSolutionA
 * @param TransferInterfaceSolutionB
 */
case class MktContingency
(
    override val sup: Element,
    val loadRolloverFlag: Boolean,
    val ltcControlFlag: Boolean,
    val participationFactorSet: String,
    val screeningFlag: Boolean,
    val TransferInterfaceSolutionA: String,
    val TransferInterfaceSolutionB: String
)
extends
    Element
{
    def this () = { this (null, false, false, null, false, null, null) }
    def Contingency: Contingency = sup.asInstanceOf[Contingency]
    override def copy (): Row = { return (clone ().asInstanceOf[MktContingency]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MktContingency
extends
    Parseable[MktContingency]
{
    val sup = Contingency.parse _
    val loadRolloverFlag = parse_element (element ("""MktContingency.loadRolloverFlag"""))
    val ltcControlFlag = parse_element (element ("""MktContingency.ltcControlFlag"""))
    val participationFactorSet = parse_element (element ("""MktContingency.participationFactorSet"""))
    val screeningFlag = parse_element (element ("""MktContingency.screeningFlag"""))
    val TransferInterfaceSolutionA = parse_attribute (attribute ("""MktContingency.TransferInterfaceSolutionA"""))
    val TransferInterfaceSolutionB = parse_attribute (attribute ("""MktContingency.TransferInterfaceSolutionB"""))
    def parse (context: Context): MktContingency =
    {
        MktContingency(
            sup (context),
            toBoolean (loadRolloverFlag (context), context),
            toBoolean (ltcControlFlag (context), context),
            participationFactorSet (context),
            toBoolean (screeningFlag (context), context),
            TransferInterfaceSolutionA (context),
            TransferInterfaceSolutionB (context)
        )
    }
}

/**
 * Subclass of IEC61970: Generation: Production:HeatRateCurve
 * @param sup Reference to the superclass object.
 * @param RegisteredGenerator
 * @param ResourceVerifiableCosts
 */
case class MktHeatRateCurve
(
    override val sup: Element,
    val RegisteredGenerator: String,
    val ResourceVerifiableCosts: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def HeatRateCurve: HeatRateCurve = sup.asInstanceOf[HeatRateCurve]
    override def copy (): Row = { return (clone ().asInstanceOf[MktHeatRateCurve]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MktHeatRateCurve
extends
    Parseable[MktHeatRateCurve]
{
    val sup = HeatRateCurve.parse _
    val RegisteredGenerator = parse_attribute (attribute ("""MktHeatRateCurve.RegisteredGenerator"""))
    val ResourceVerifiableCosts = parse_attribute (attribute ("""MktHeatRateCurve.ResourceVerifiableCosts"""))
    def parse (context: Context): MktHeatRateCurve =
    {
        MktHeatRateCurve(
            sup (context),
            RegisteredGenerator (context),
            ResourceVerifiableCosts (context)
        )
    }
}

/**
 * Subclass of ThermalGeneratingUnit from Production Package in IEC61970.
 * @param sup Reference to the superclass object.
 */
case class MktThermalGeneratingUnit
(
    override val sup: Element
)
extends
    Element
{
    def this () = { this (null) }
    def ThermalGeneratingUnit: ThermalGeneratingUnit = sup.asInstanceOf[ThermalGeneratingUnit]
    override def copy (): Row = { return (clone ().asInstanceOf[MktThermalGeneratingUnit]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MktThermalGeneratingUnit
extends
    Parseable[MktThermalGeneratingUnit]
{
    val sup = ThermalGeneratingUnit.parse _
    def parse (context: Context): MktThermalGeneratingUnit =
    {
        MktThermalGeneratingUnit(
            sup (context)
        )
    }
}

/**
 * Price of oil in monetary units
 * @param sup Reference to the superclass object.
 * @param oilPriceIndex The average oil price at a defined fuel region.
 * @param FuelRegion
 */
case class OilPrice
(
    override val sup: Element,
    val oilPriceIndex: Double,
    val FuelRegion: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[OilPrice]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OilPrice
extends
    Parseable[OilPrice]
{
    val sup = BasicElement.parse _
    val oilPriceIndex = parse_element (element ("""OilPrice.oilPriceIndex"""))
    val FuelRegion = parse_attribute (attribute ("""OilPrice.FuelRegion"""))
    def parse (context: Context): OilPrice =
    {
        OilPrice(
            sup (context),
            toDouble (oilPriceIndex (context), context),
            FuelRegion (context)
        )
    }
}

/**
 * This class models the allocation between asset owners and pricing nodes
 * @param sup Reference to the superclass object.
 * @param endEffectiveDate end effective date
 * @param maxMWAllocation Maximum MW for the Source/Sink for the Allocation
 * @param startEffectiveDate start effective date
 * @param MktOrganisation
 * @param Pnode
 */
case class OrgPnodeAllocation
(
    override val sup: Element,
    val endEffectiveDate: String,
    val maxMWAllocation: Double,
    val startEffectiveDate: String,
    val MktOrganisation: String,
    val Pnode: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[OrgPnodeAllocation]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OrgPnodeAllocation
extends
    Parseable[OrgPnodeAllocation]
{
    val sup = IdentifiedObject.parse _
    val endEffectiveDate = parse_element (element ("""OrgPnodeAllocation.endEffectiveDate"""))
    val maxMWAllocation = parse_element (element ("""OrgPnodeAllocation.maxMWAllocation"""))
    val startEffectiveDate = parse_element (element ("""OrgPnodeAllocation.startEffectiveDate"""))
    val MktOrganisation = parse_attribute (attribute ("""OrgPnodeAllocation.MktOrganisation"""))
    val Pnode = parse_attribute (attribute ("""OrgPnodeAllocation.Pnode"""))
    def parse (context: Context): OrgPnodeAllocation =
    {
        OrgPnodeAllocation(
            sup (context),
            endEffectiveDate (context),
            toDouble (maxMWAllocation (context), context),
            startEffectiveDate (context),
            MktOrganisation (context),
            Pnode (context)
        )
    }
}

/**
 * This class model the ownership percent and type of ownership between resource and organisation
 * @param sup Reference to the superclass object.
 * @param asscType association type for the association between Organisation and Resource:
 * @param endEffectiveDate end effective date
 * @param masterSchedulingCoordinatorFlag Flag to indicate that the SC representing the Resource is the Master SC.
 * @param ownershipPercent ownership percentage for each resource
 * @param startEffectiveDate start effective date
 * @param MktOrganisation
 * @param RegisteredResource
 */
case class OrgResOwnership
(
    override val sup: Element,
    val asscType: String,
    val endEffectiveDate: String,
    val masterSchedulingCoordinatorFlag: String,
    val ownershipPercent: Double,
    val startEffectiveDate: String,
    val MktOrganisation: String,
    val RegisteredResource: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, 0.0, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[OrgResOwnership]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OrgResOwnership
extends
    Parseable[OrgResOwnership]
{
    val sup = IdentifiedObject.parse _
    val asscType = parse_attribute (attribute ("""OrgResOwnership.asscType"""))
    val endEffectiveDate = parse_element (element ("""OrgResOwnership.endEffectiveDate"""))
    val masterSchedulingCoordinatorFlag = parse_attribute (attribute ("""OrgResOwnership.masterSchedulingCoordinatorFlag"""))
    val ownershipPercent = parse_element (element ("""OrgResOwnership.ownershipPercent"""))
    val startEffectiveDate = parse_element (element ("""OrgResOwnership.startEffectiveDate"""))
    val MktOrganisation = parse_attribute (attribute ("""OrgResOwnership.MktOrganisation"""))
    val RegisteredResource = parse_attribute (attribute ("""OrgResOwnership.RegisteredResource"""))
    def parse (context: Context): OrgResOwnership =
    {
        OrgResOwnership(
            sup (context),
            asscType (context),
            endEffectiveDate (context),
            masterSchedulingCoordinatorFlag (context),
            toDouble (ownershipPercent (context), context),
            startEffectiveDate (context),
            MktOrganisation (context),
            RegisteredResource (context)
        )
    }
}

/**
 * A pricing node is directly associated with a connectivity node.
 * It is a pricing location for which market participants submit their bids, offers, buy/sell CRRs, and settle.
 * @param sup Reference to the superclass object.
 * @param endEffectiveDate End effective date of the period in which the price node definition is valid.
 * @param isPublic If true, this Pnode is public (prices are published for DA/RT and FTR markets), otherwise it is private (location is not usable by market for bidding/FTRs/transactions).
 * @param startEffectiveDate Start effective date of the period in which the price node definition is valid.
 * @param typ Pnode type
 * @param usage Price node usage: 
'Control Area'
'Regulation Region'
'Price Zone'
'Spin Region'
'Non-Spin Region'
 *        'Price Hub'
 * @param RTO
 * @param SinkCRRSegment
 * @param SourceCRRSegment
 * @param SubControlArea
 */
case class Pnode
(
    override val sup: Element,
    val endEffectiveDate: String,
    val isPublic: Boolean,
    val startEffectiveDate: String,
    val typ: String,
    val usage: String,
    val RTO: String,
    val SinkCRRSegment: List[String],
    val SourceCRRSegment: List[String],
    val SubControlArea: String
)
extends
    Element
{
    def this () = { this (null, null, false, null, null, null, null, List(), List(), null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Pnode]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Pnode
extends
    Parseable[Pnode]
{
    val sup = IdentifiedObject.parse _
    val endEffectiveDate = parse_element (element ("""Pnode.endEffectiveDate"""))
    val isPublic = parse_element (element ("""Pnode.isPublic"""))
    val startEffectiveDate = parse_element (element ("""Pnode.startEffectiveDate"""))
    val typ = parse_element (element ("""Pnode.type"""))
    val usage = parse_element (element ("""Pnode.usage"""))
    val RTO = parse_attribute (attribute ("""Pnode.RTO"""))
    val SinkCRRSegment = parse_attributes (attribute ("""Pnode.SinkCRRSegment"""))
    val SourceCRRSegment = parse_attributes (attribute ("""Pnode.SourceCRRSegment"""))
    val SubControlArea = parse_attribute (attribute ("""Pnode.SubControlArea"""))
    def parse (context: Context): Pnode =
    {
        Pnode(
            sup (context),
            endEffectiveDate (context),
            toBoolean (isPublic (context), context),
            startEffectiveDate (context),
            typ (context),
            usage (context),
            RTO (context),
            SinkCRRSegment (context),
            SourceCRRSegment (context),
            SubControlArea (context)
        )
    }
}

/**
 * This class allows SC to input different distribution factors for pricing node
 * @param sup Reference to the superclass object.
 * @param factor Used to calculate "participation" of Pnode in an AggregatePnode.
 *        For example, for regulation region this factor is 1 and total sum of all factors for a specific regulation region does not have to be 1. For pricing zone the total sum of all factors has to be 1.
 * @param offPeak Indication that this distribution factor is to apply during off peak.
 * @param onPeak Indication that this factor is to apply during Peak periods.
 * @param podLossFactor Point of delivery loss factor
 * @param BidDistributionFactor
 * @param IndividualPnode
 */
case class PnodeDistributionFactor
(
    override val sup: Element,
    val factor: Double,
    val offPeak: String,
    val onPeak: String,
    val podLossFactor: Double,
    val BidDistributionFactor: String,
    val IndividualPnode: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null, 0.0, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[PnodeDistributionFactor]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PnodeDistributionFactor
extends
    Parseable[PnodeDistributionFactor]
{
    val sup = BasicElement.parse _
    val factor = parse_element (element ("""PnodeDistributionFactor.factor"""))
    val offPeak = parse_attribute (attribute ("""PnodeDistributionFactor.offPeak"""))
    val onPeak = parse_attribute (attribute ("""PnodeDistributionFactor.onPeak"""))
    val podLossFactor = parse_element (element ("""PnodeDistributionFactor.podLossFactor"""))
    val BidDistributionFactor = parse_attribute (attribute ("""PnodeDistributionFactor.BidDistributionFactor"""))
    val IndividualPnode = parse_attribute (attribute ("""PnodeDistributionFactor.IndividualPnode"""))
    def parse (context: Context): PnodeDistributionFactor =
    {
        PnodeDistributionFactor(
            sup (context),
            toDouble (factor (context), context),
            offPeak (context),
            onPeak (context),
            toDouble (podLossFactor (context), context),
            BidDistributionFactor (context),
            IndividualPnode (context)
        )
    }
}

/**
 * Model to support processing of reliability must run units.
 * @param sup Reference to the superclass object.
 * @param RegisteredGenerator
 */
case class RMRHeatRateCurve
(
    override val sup: Element,
    val RegisteredGenerator: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { return (clone ().asInstanceOf[RMRHeatRateCurve]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RMRHeatRateCurve
extends
    Parseable[RMRHeatRateCurve]
{
    val sup = Curve.parse _
    val RegisteredGenerator = parse_attribute (attribute ("""RMRHeatRateCurve.RegisteredGenerator"""))
    def parse (context: Context): RMRHeatRateCurve =
    {
        RMRHeatRateCurve(
            sup (context),
            RegisteredGenerator (context)
        )
    }
}

/**
 * Model to support processing of reliability must run units.
 * @param sup Reference to the superclass object.
 * @param RegisteredGenerator
 */
case class RMRStartUpCostCurve
(
    override val sup: Element,
    val RegisteredGenerator: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { return (clone ().asInstanceOf[RMRStartUpCostCurve]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RMRStartUpCostCurve
extends
    Parseable[RMRStartUpCostCurve]
{
    val sup = Curve.parse _
    val RegisteredGenerator = parse_attribute (attribute ("""RMRStartUpCostCurve.RegisteredGenerator"""))
    def parse (context: Context): RMRStartUpCostCurve =
    {
        RMRStartUpCostCurve(
            sup (context),
            RegisteredGenerator (context)
        )
    }
}

/**
 * Model to support processing of reliability must run units.
 * @param sup Reference to the superclass object.
 * @param RegisteredGenerator
 */
case class RMRStartUpEnergyCurve
(
    override val sup: Element,
    val RegisteredGenerator: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { return (clone ().asInstanceOf[RMRStartUpEnergyCurve]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RMRStartUpEnergyCurve
extends
    Parseable[RMRStartUpEnergyCurve]
{
    val sup = Curve.parse _
    val RegisteredGenerator = parse_attribute (attribute ("""RMRStartUpEnergyCurve.RegisteredGenerator"""))
    def parse (context: Context): RMRStartUpEnergyCurve =
    {
        RMRStartUpEnergyCurve(
            sup (context),
            RegisteredGenerator (context)
        )
    }
}

/**
 * Model to support processing of reliability must run units.
 * @param sup Reference to the superclass object.
 * @param RegisteredGenerator
 */
case class RMRStartUpFuelCurve
(
    override val sup: Element,
    val RegisteredGenerator: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { return (clone ().asInstanceOf[RMRStartUpFuelCurve]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RMRStartUpFuelCurve
extends
    Parseable[RMRStartUpFuelCurve]
{
    val sup = Curve.parse _
    val RegisteredGenerator = parse_attribute (attribute ("""RMRStartUpFuelCurve.RegisteredGenerator"""))
    def parse (context: Context): RMRStartUpFuelCurve =
    {
        RMRStartUpFuelCurve(
            sup (context),
            RegisteredGenerator (context)
        )
    }
}

/**
 * Model to support processing of reliability must run units.
 * @param sup Reference to the superclass object.
 * @param RegisteredGenerator
 */
case class RMRStartUpTimeCurve
(
    override val sup: Element,
    val RegisteredGenerator: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { return (clone ().asInstanceOf[RMRStartUpTimeCurve]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RMRStartUpTimeCurve
extends
    Parseable[RMRStartUpTimeCurve]
{
    val sup = Curve.parse _
    val RegisteredGenerator = parse_attribute (attribute ("""RMRStartUpTimeCurve.RegisteredGenerator"""))
    def parse (context: Context): RMRStartUpTimeCurve =
    {
        RMRStartUpTimeCurve(
            sup (context),
            RegisteredGenerator (context)
        )
    }
}

/**
 * Regional transmission operator.
 * @param sup Reference to the superclass object.
 */
case class RTO
(
    override val sup: Element
)
extends
    Element
{
    def this () = { this (null) }
    def MktOrganisation: MktOrganisation = sup.asInstanceOf[MktOrganisation]
    override def copy (): Row = { return (clone ().asInstanceOf[RTO]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RTO
extends
    Parseable[RTO]
{
    val sup = MktOrganisation.parse _
    def parse (context: Context): RTO =
    {
        RTO(
            sup (context)
        )
    }
}

/**
 * A specialized class of type AggregatedNode type.
 * Defines RUC Zones. A forecast region represents a collection of Nodes for which the Market operator has developed sufficient historical demand and relevant weather data to perform a demand forecast for such area. The Market Operator may further adjust this forecast to ensure that the Reliability Unit Commitment produces adequate local capacity procurement.
 * @param sup Reference to the superclass object.
 */
case class RUCZone
(
    override val sup: Element
)
extends
    Element
{
    def this () = { this (null) }
    def AggregateNode: AggregateNode = sup.asInstanceOf[AggregateNode]
    override def copy (): Row = { return (clone ().asInstanceOf[RUCZone]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RUCZone
extends
    Parseable[RUCZone]
{
    val sup = AggregateNode.parse _
    def parse (context: Context): RUCZone =
    {
        RUCZone(
            sup (context)
        )
    }
}

/**
 * Model of a generator  that is registered to participate in the market
 * @param sup Reference to the superclass object.
 * @param capacityFactor Capacity Factor
 * @param coldStartTime Cold start time.
 * @param combinedCyclePlantName Name of the Combined Cycle Plant (valid for Combined Cyle modes or configurations)
 * @param commericialOperationDate
 * @param constrainedOutputFlag Constrained Output Generator (COG) Indicator (Yes/No), per Generating Resource
 * @param costBasis
 * @param extremeLongStart Some long-start up time units may need to receive start up instruction before DA market results are available.
 *        Long-Start resources may be either physical resources within the control with start-up times greater than 18 hours or the long-start contractual inter-tie commitment that shall be completed by 6 am one-day ahead.  Therefore, there is a need for a process to determine the commitment of such resources before the DA market.
 * @param fuelSource Values: Natural Gas Based Resource, Non Natural Gas Based Resource
"NG" - Natural-Gas-Based Resource - a Resource that is powered by Natural Gas
 *        "NNG" - Non-Natural-Gas-Based Resource - a Resouce that is powered by some other fuel than Natural Gas
 * @param highControlLimit High limit for secondary (AGC) control
 * @param hotIntTime Hot-to-intermediate time (Seasonal)
 * @param hotStartTime Hot start time.
 * @param intColdTime Intermediate-to-cold time (Seasonal)
 * @param intStartTime Intermediate start time.
 * @param intendedPIRP Provides an indication that this resource is intending to participate in the intermittent resource program.
 * @param loadFollowingDownMSS Certifies resources for use in MSS Load Following Down
 * @param loadFollowingUpMSS Certifies resources for use in MSS Load Following Up
 * @param lowControlLImit Low limit for secondary (AGC) control
 * @param lowerControlRate Regulation down response rate in MW per minute
 * @param lowerRampRate
 * @param maxDependableCap Maximum Dependable Capacity (MNDC).
 * @param maxLayOffSelfSchedQty
 * @param maxMinLoadCost The registered maximum Minimum Load Cost of a Generating Resource registered with a Cost Basis of "Bid Cost".
 * @param maxPumpingLevel max pumping level of a hydro pump unit
 * @param maxShutdownTime Maximum time this device can be shut down.
 * @param maxStartUpsPerDay maximum start ups per day
 * @param maxWeeklyEnergy Maximum weekly Energy (Seasonal)
 * @param maxWeeklyStarts Maximum weekly starts (seasonal parameter)
 * @param maximumAllowableSpinningReserve Maximum allowable spinning reserve.
 *        Spinning reserve will never be considered greater than this value regardless of the current operating point.
 * @param maximumOperatingMW This is the maximum operating MW limit the dispatcher can enter for this unit
 * @param minLoadCost minimum load cost.
 *        Value is (currency/hr)
 * @param minimumLoadFuelCost The cost for the fuel required to get a Generating Resource to operate at the minimum load level
 * @param minimumOperatingMW This is the minimum operating MW limit the dispatcher can enter for this unit.
 * @param mustOfferRA Flag to indicate that this unit is a resource adequacy resource and must offer.
 * @param nameplateCapacity MW value stated on the nameplate of the Generator -- the value it potentially could provide.
 * @param operatingMaintenanceCost The portion of the Operating Cost of a Generating Resource that is not related to fuel cost.
 * @param operatingMode Combined Cycle operating mode.
 * @param proxyFlag
 * @param pumpMinDownTime The minimum down time for the pump in a pump storage unit.
 * @param pumpMinUpTime The minimum up time aspect for the pump in a pump storage unit
 * @param pumpShutdownCost The cost to shutdown a pump during the pump aspect of a pump storage unit.
 * @param pumpShutdownTime The shutdown time (minutes) of the pump aspect of a pump storage unit.
 * @param pumpingCost
 * @param pumpingFactor Pumping factor for pump storage units, conversion factor between generating and pumping.
 * @param qualifyingFacilityOwner
 * @param quickStartFlag Quick start flag (Yes/No)
 * @param raiseControlRate Regulation up response rate in MW per minute
 * @param raiseRampRate
 * @param rampCurveType Ramp curve type:
0 - Fixed ramp rate independent of rate function unit MW output
1 - Static ramp rates as a function of unit MW output only
 *        2 - Dynamic ramp rates as a function of unit MW output and ramping time
 * @param rampMode Ramping mode
0: ignore ramping limits
1: 20-minute ramping rule
 *        2: 60-minute ramping rule
 * @param regulationFlag 0 = Unit is not on regulation
1 = Unit is on AGC and regulating
 *        2 = Unit is suppose to be on regulation but it is not under regulation now
 * @param regulationRampRate For the outage scheduling services
 * @param resourceSubType CCGT90	Combined Cycle greater than 90 MW
CCLE90	Combined Cycle less than or equal to 90 MW
CLLIG	Coal and Lignite
DSL	Diesel
GASSTM	Gas-Steam
GSNONR	Gas Steam Non-Reheat Boiler
GSREH	Gas Steam Reheat Boiler
GSSUP	Gas Steam Supercritical Boiler
HYDRO	Hydro
NUC	Nuclear
RENEW	Renewable
SCGT90	Simple Cycle greater than 90 MW
SCLE90	Simple Cycle less than or equal to 90 MW
WIND	Wind
 *        PS         Pumped Storage
 * @param riverSystem River System the Resource is tied to.
 * @param spinReserveRamp
 * @param syncCondCapable Is the Resource Synchronous Condenser capable Resource?
 * @param unitType Generating unit type: Combined Cycle, Gas Turbine, Hydro Turbine, Other, Photovoltaic, Hydro Pump-Turbine, Reciprocating Engine, Steam Turbine, Synchronous Condenser, Wind Turbine
 * @param useLimitFlag Use limit flag: indicates if the use-limited resource is fully scheduled (or has some slack for real-time dispatch) (Y/N)
 * @param EnergyPriceIndex
 * @param FuelCostCurve
 * @param FuelRegion
 * @param LocalReliabilityArea
 * @param MktHeatRateCurve
 * @param RMNRFlag Reliability must not run (RMNR) flag: indicated whether the RMR unit is set as an RMNR in the current market
 * @param RMRFlag Reliability must run (RMR) flag: indicates whether the unit is RMR; Indicates whether the unit is RMR:
N' - not an RMR unit
'1' - RMR Condition 1 unit
 *        '2' - RMR Condition 2 unit
 * @param RMRHeatRateCurve
 * @param RMRManualIndicator Indicates the RMR Manual pre-determination status [Y/N]
 * @param RMRStartUpCostCurve
 * @param RMRStartUpEnergyCurve
 * @param RMRStartUpFuelCurve
 * @param RMRStartUpTimeCurve
 * @param RMTFlag Reliability must take (RMT) flag (Yes/No): indicates whether the unit is RMT
 * @param RegulatingLimit
 * @param StartUpEnergyCurve
 * @param StartUpFuelCurve
 * @param StartUpTimeCurve
 */
case class RegisteredGenerator
(
    override val sup: Element,
    val capacityFactor: Double,
    val coldStartTime: Double,
    val combinedCyclePlantName: String,
    val commericialOperationDate: String,
    val constrainedOutputFlag: String,
    val costBasis: String,
    val extremeLongStart: String,
    val fuelSource: String,
    val highControlLimit: Double,
    val hotIntTime: Double,
    val hotStartTime: Double,
    val intColdTime: Double,
    val intStartTime: Double,
    val intendedPIRP: String,
    val loadFollowingDownMSS: String,
    val loadFollowingUpMSS: String,
    val lowControlLImit: Double,
    val lowerControlRate: Double,
    val lowerRampRate: Double,
    val maxDependableCap: Double,
    val maxLayOffSelfSchedQty: Double,
    val maxMinLoadCost: Double,
    val maxPumpingLevel: Double,
    val maxShutdownTime: String,
    val maxStartUpsPerDay: Int,
    val maxWeeklyEnergy: Double,
    val maxWeeklyStarts: Int,
    val maximumAllowableSpinningReserve: Double,
    val maximumOperatingMW: Double,
    val minLoadCost: Double,
    val minimumLoadFuelCost: String,
    val minimumOperatingMW: Double,
    val mustOfferRA: String,
    val nameplateCapacity: Double,
    val operatingMaintenanceCost: Double,
    val operatingMode: String,
    val proxyFlag: String,
    val pumpMinDownTime: Double,
    val pumpMinUpTime: Double,
    val pumpShutdownCost: Double,
    val pumpShutdownTime: Int,
    val pumpingCost: Double,
    val pumpingFactor: Double,
    val qualifyingFacilityOwner: String,
    val quickStartFlag: String,
    val raiseControlRate: Double,
    val raiseRampRate: Double,
    val rampCurveType: String,
    val rampMode: String,
    val regulationFlag: Int,
    val regulationRampRate: Double,
    val resourceSubType: String,
    val riverSystem: String,
    val spinReserveRamp: Double,
    val syncCondCapable: String,
    val unitType: String,
    val useLimitFlag: String,
    val EnergyPriceIndex: String,
    val FuelCostCurve: String,
    val FuelRegion: String,
    val LocalReliabilityArea: String,
    val MktHeatRateCurve: String,
    val RMNRFlag: String,
    val RMRFlag: String,
    val RMRHeatRateCurve: String,
    val RMRManualIndicator: String,
    val RMRStartUpCostCurve: String,
    val RMRStartUpEnergyCurve: String,
    val RMRStartUpFuelCurve: String,
    val RMRStartUpTimeCurve: String,
    val RMTFlag: String,
    val RegulatingLimit: String,
    val StartUpEnergyCurve: String,
    val StartUpFuelCurve: String,
    val StartUpTimeCurve: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null, null, null, null, null, null, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, 0, 0.0, 0, 0.0, 0.0, 0.0, null, 0.0, null, 0.0, 0.0, null, null, 0.0, 0.0, 0.0, 0, 0.0, 0.0, null, null, 0.0, 0.0, null, null, 0, 0.0, null, null, 0.0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def RegisteredResource: RegisteredResource = sup.asInstanceOf[RegisteredResource]
    override def copy (): Row = { return (clone ().asInstanceOf[RegisteredGenerator]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RegisteredGenerator
extends
    Parseable[RegisteredGenerator]
{
    val sup = RegisteredResource.parse _
    val capacityFactor = parse_element (element ("""RegisteredGenerator.capacityFactor"""))
    val coldStartTime = parse_element (element ("""RegisteredGenerator.coldStartTime"""))
    val combinedCyclePlantName = parse_element (element ("""RegisteredGenerator.combinedCyclePlantName"""))
    val commericialOperationDate = parse_element (element ("""RegisteredGenerator.commericialOperationDate"""))
    val constrainedOutputFlag = parse_attribute (attribute ("""RegisteredGenerator.constrainedOutputFlag"""))
    val costBasis = parse_attribute (attribute ("""RegisteredGenerator.costBasis"""))
    val extremeLongStart = parse_attribute (attribute ("""RegisteredGenerator.extremeLongStart"""))
    val fuelSource = parse_attribute (attribute ("""RegisteredGenerator.fuelSource"""))
    val highControlLimit = parse_element (element ("""RegisteredGenerator.highControlLimit"""))
    val hotIntTime = parse_element (element ("""RegisteredGenerator.hotIntTime"""))
    val hotStartTime = parse_element (element ("""RegisteredGenerator.hotStartTime"""))
    val intColdTime = parse_element (element ("""RegisteredGenerator.intColdTime"""))
    val intStartTime = parse_element (element ("""RegisteredGenerator.intStartTime"""))
    val intendedPIRP = parse_attribute (attribute ("""RegisteredGenerator.intendedPIRP"""))
    val loadFollowingDownMSS = parse_attribute (attribute ("""RegisteredGenerator.loadFollowingDownMSS"""))
    val loadFollowingUpMSS = parse_attribute (attribute ("""RegisteredGenerator.loadFollowingUpMSS"""))
    val lowControlLImit = parse_element (element ("""RegisteredGenerator.lowControlLImit"""))
    val lowerControlRate = parse_element (element ("""RegisteredGenerator.lowerControlRate"""))
    val lowerRampRate = parse_element (element ("""RegisteredGenerator.lowerRampRate"""))
    val maxDependableCap = parse_element (element ("""RegisteredGenerator.maxDependableCap"""))
    val maxLayOffSelfSchedQty = parse_element (element ("""RegisteredGenerator.maxLayOffSelfSchedQty"""))
    val maxMinLoadCost = parse_element (element ("""RegisteredGenerator.maxMinLoadCost"""))
    val maxPumpingLevel = parse_element (element ("""RegisteredGenerator.maxPumpingLevel"""))
    val maxShutdownTime = parse_element (element ("""RegisteredGenerator.maxShutdownTime"""))
    val maxStartUpsPerDay = parse_element (element ("""RegisteredGenerator.maxStartUpsPerDay"""))
    val maxWeeklyEnergy = parse_element (element ("""RegisteredGenerator.maxWeeklyEnergy"""))
    val maxWeeklyStarts = parse_element (element ("""RegisteredGenerator.maxWeeklyStarts"""))
    val maximumAllowableSpinningReserve = parse_element (element ("""RegisteredGenerator.maximumAllowableSpinningReserve"""))
    val maximumOperatingMW = parse_element (element ("""RegisteredGenerator.maximumOperatingMW"""))
    val minLoadCost = parse_element (element ("""RegisteredGenerator.minLoadCost"""))
    val minimumLoadFuelCost = parse_attribute (attribute ("""RegisteredGenerator.minimumLoadFuelCost"""))
    val minimumOperatingMW = parse_element (element ("""RegisteredGenerator.minimumOperatingMW"""))
    val mustOfferRA = parse_attribute (attribute ("""RegisteredGenerator.mustOfferRA"""))
    val nameplateCapacity = parse_element (element ("""RegisteredGenerator.nameplateCapacity"""))
    val operatingMaintenanceCost = parse_element (element ("""RegisteredGenerator.operatingMaintenanceCost"""))
    val operatingMode = parse_element (element ("""RegisteredGenerator.operatingMode"""))
    val proxyFlag = parse_attribute (attribute ("""RegisteredGenerator.proxyFlag"""))
    val pumpMinDownTime = parse_element (element ("""RegisteredGenerator.pumpMinDownTime"""))
    val pumpMinUpTime = parse_element (element ("""RegisteredGenerator.pumpMinUpTime"""))
    val pumpShutdownCost = parse_element (element ("""RegisteredGenerator.pumpShutdownCost"""))
    val pumpShutdownTime = parse_element (element ("""RegisteredGenerator.pumpShutdownTime"""))
    val pumpingCost = parse_element (element ("""RegisteredGenerator.pumpingCost"""))
    val pumpingFactor = parse_element (element ("""RegisteredGenerator.pumpingFactor"""))
    val qualifyingFacilityOwner = parse_element (element ("""RegisteredGenerator.qualifyingFacilityOwner"""))
    val quickStartFlag = parse_attribute (attribute ("""RegisteredGenerator.quickStartFlag"""))
    val raiseControlRate = parse_element (element ("""RegisteredGenerator.raiseControlRate"""))
    val raiseRampRate = parse_element (element ("""RegisteredGenerator.raiseRampRate"""))
    val rampCurveType = parse_attribute (attribute ("""RegisteredGenerator.rampCurveType"""))
    val rampMode = parse_attribute (attribute ("""RegisteredGenerator.rampMode"""))
    val regulationFlag = parse_element (element ("""RegisteredGenerator.regulationFlag"""))
    val regulationRampRate = parse_element (element ("""RegisteredGenerator.regulationRampRate"""))
    val resourceSubType = parse_element (element ("""RegisteredGenerator.resourceSubType"""))
    val riverSystem = parse_element (element ("""RegisteredGenerator.riverSystem"""))
    val spinReserveRamp = parse_element (element ("""RegisteredGenerator.spinReserveRamp"""))
    val syncCondCapable = parse_attribute (attribute ("""RegisteredGenerator.syncCondCapable"""))
    val unitType = parse_attribute (attribute ("""RegisteredGenerator.unitType"""))
    val useLimitFlag = parse_attribute (attribute ("""RegisteredGenerator.useLimitFlag"""))
    val EnergyPriceIndex = parse_attribute (attribute ("""RegisteredGenerator.EnergyPriceIndex"""))
    val FuelCostCurve = parse_attribute (attribute ("""RegisteredGenerator.FuelCostCurve"""))
    val FuelRegion = parse_attribute (attribute ("""RegisteredGenerator.FuelRegion"""))
    val LocalReliabilityArea = parse_attribute (attribute ("""RegisteredGenerator.LocalReliabilityArea"""))
    val MktHeatRateCurve = parse_attribute (attribute ("""RegisteredGenerator.MktHeatRateCurve"""))
    val RMNRFlag = parse_attribute (attribute ("""RegisteredGenerator.RMNRFlag"""))
    val RMRFlag = parse_attribute (attribute ("""RegisteredGenerator.RMRFlag"""))
    val RMRHeatRateCurve = parse_attribute (attribute ("""RegisteredGenerator.RMRHeatRateCurve"""))
    val RMRManualIndicator = parse_attribute (attribute ("""RegisteredGenerator.RMRManualIndicator"""))
    val RMRStartUpCostCurve = parse_attribute (attribute ("""RegisteredGenerator.RMRStartUpCostCurve"""))
    val RMRStartUpEnergyCurve = parse_attribute (attribute ("""RegisteredGenerator.RMRStartUpEnergyCurve"""))
    val RMRStartUpFuelCurve = parse_attribute (attribute ("""RegisteredGenerator.RMRStartUpFuelCurve"""))
    val RMRStartUpTimeCurve = parse_attribute (attribute ("""RegisteredGenerator.RMRStartUpTimeCurve"""))
    val RMTFlag = parse_attribute (attribute ("""RegisteredGenerator.RMTFlag"""))
    val RegulatingLimit = parse_attribute (attribute ("""RegisteredGenerator.RegulatingLimit"""))
    val StartUpEnergyCurve = parse_attribute (attribute ("""RegisteredGenerator.StartUpEnergyCurve"""))
    val StartUpFuelCurve = parse_attribute (attribute ("""RegisteredGenerator.StartUpFuelCurve"""))
    val StartUpTimeCurve = parse_attribute (attribute ("""RegisteredGenerator.StartUpTimeCurve"""))
    def parse (context: Context): RegisteredGenerator =
    {
        RegisteredGenerator(
            sup (context),
            toDouble (capacityFactor (context), context),
            toDouble (coldStartTime (context), context),
            combinedCyclePlantName (context),
            commericialOperationDate (context),
            constrainedOutputFlag (context),
            costBasis (context),
            extremeLongStart (context),
            fuelSource (context),
            toDouble (highControlLimit (context), context),
            toDouble (hotIntTime (context), context),
            toDouble (hotStartTime (context), context),
            toDouble (intColdTime (context), context),
            toDouble (intStartTime (context), context),
            intendedPIRP (context),
            loadFollowingDownMSS (context),
            loadFollowingUpMSS (context),
            toDouble (lowControlLImit (context), context),
            toDouble (lowerControlRate (context), context),
            toDouble (lowerRampRate (context), context),
            toDouble (maxDependableCap (context), context),
            toDouble (maxLayOffSelfSchedQty (context), context),
            toDouble (maxMinLoadCost (context), context),
            toDouble (maxPumpingLevel (context), context),
            maxShutdownTime (context),
            toInteger (maxStartUpsPerDay (context), context),
            toDouble (maxWeeklyEnergy (context), context),
            toInteger (maxWeeklyStarts (context), context),
            toDouble (maximumAllowableSpinningReserve (context), context),
            toDouble (maximumOperatingMW (context), context),
            toDouble (minLoadCost (context), context),
            minimumLoadFuelCost (context),
            toDouble (minimumOperatingMW (context), context),
            mustOfferRA (context),
            toDouble (nameplateCapacity (context), context),
            toDouble (operatingMaintenanceCost (context), context),
            operatingMode (context),
            proxyFlag (context),
            toDouble (pumpMinDownTime (context), context),
            toDouble (pumpMinUpTime (context), context),
            toDouble (pumpShutdownCost (context), context),
            toInteger (pumpShutdownTime (context), context),
            toDouble (pumpingCost (context), context),
            toDouble (pumpingFactor (context), context),
            qualifyingFacilityOwner (context),
            quickStartFlag (context),
            toDouble (raiseControlRate (context), context),
            toDouble (raiseRampRate (context), context),
            rampCurveType (context),
            rampMode (context),
            toInteger (regulationFlag (context), context),
            toDouble (regulationRampRate (context), context),
            resourceSubType (context),
            riverSystem (context),
            toDouble (spinReserveRamp (context), context),
            syncCondCapable (context),
            unitType (context),
            useLimitFlag (context),
            EnergyPriceIndex (context),
            FuelCostCurve (context),
            FuelRegion (context),
            LocalReliabilityArea (context),
            MktHeatRateCurve (context),
            RMNRFlag (context),
            RMRFlag (context),
            RMRHeatRateCurve (context),
            RMRManualIndicator (context),
            RMRStartUpCostCurve (context),
            RMRStartUpEnergyCurve (context),
            RMRStartUpFuelCurve (context),
            RMRStartUpTimeCurve (context),
            RMTFlag (context),
            RegulatingLimit (context),
            StartUpEnergyCurve (context),
            StartUpFuelCurve (context),
            StartUpTimeCurve (context)
        )
    }
}

/**
 * This class represents the inter tie resource.
 * @param sup Reference to the superclass object.
 * @param direction indicate the direction (export/import) of an intertie resource
 * @param energyProductType Under each major product type, the commodity type can be applied to further specify the type.
 * @param isDCTie Flag to indicated whether this Inter-tie is a DC Tie.
 * @param isDynamicInterchange check if the inter-tie resource is registered for the dynamic interchange..
 * @param minHourlyBlockLimit The registered upper bound of minimum hourly block for an Inter-Tie Resource
 * @param Flowgate
 * @param InterTieBid
 */
case class RegisteredInterTie
(
    override val sup: Element,
    val direction: String,
    val energyProductType: String,
    val isDCTie: String,
    val isDynamicInterchange: String,
    val minHourlyBlockLimit: Int,
    val Flowgate: String,
    val InterTieBid: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, 0, null, null) }
    def RegisteredResource: RegisteredResource = sup.asInstanceOf[RegisteredResource]
    override def copy (): Row = { return (clone ().asInstanceOf[RegisteredInterTie]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RegisteredInterTie
extends
    Parseable[RegisteredInterTie]
{
    val sup = RegisteredResource.parse _
    val direction = parse_attribute (attribute ("""RegisteredInterTie.direction"""))
    val energyProductType = parse_attribute (attribute ("""RegisteredInterTie.energyProductType"""))
    val isDCTie = parse_attribute (attribute ("""RegisteredInterTie.isDCTie"""))
    val isDynamicInterchange = parse_attribute (attribute ("""RegisteredInterTie.isDynamicInterchange"""))
    val minHourlyBlockLimit = parse_element (element ("""RegisteredInterTie.minHourlyBlockLimit"""))
    val Flowgate = parse_attribute (attribute ("""RegisteredInterTie.Flowgate"""))
    val InterTieBid = parse_attribute (attribute ("""RegisteredInterTie.InterTieBid"""))
    def parse (context: Context): RegisteredInterTie =
    {
        RegisteredInterTie(
            sup (context),
            direction (context),
            energyProductType (context),
            isDCTie (context),
            isDynamicInterchange (context),
            toInteger (minHourlyBlockLimit (context), context),
            Flowgate (context),
            InterTieBid (context)
        )
    }
}

/**
 * Model of a load that is registered to participate in the market (demand reduction)
 * @param sup Reference to the superclass object.
 * @param blockLoadTransferFlag Flag to indicate that the Resource is Block Load pseudo resource (&lsquo;Y&rsquo;, &lsquo; N&rsquo;)
 * @param dynamicallyScheduledLoadResourceFlag Flag to indicate that a Load Resource is part of a DSR Load
 * @param dynamicallyScheduledQualificationFlag Qualification status (used for DSR qualification)
 * @param loadRegistryMSS Non-participating load registry as a MSS load
 * @param maxBaseLoad Maximum Base Load (MW), per Participating Load Resource
 * @param maxDeploymentTime Maximum Deployment time (seconds)
 * @param maxLoadRedTimesPerDay Maximum Number of Daily Load Curtailments
 * @param maxLoadReduction maximum load reduction
 * @param maxReductionTime Maxiimum Load Reduction Time (min), per Participating Load Resource
 * @param maxWeeklyDeployment Maximum weekly deployments
 * @param minLoadReduction Minimum MW for a load reduction (e.g., MW rating of a discrete pump.
 *        This attribute may be used also in the LoadBid class. The reason that the attribute is also modeled in this class is that it is resource attribute and needs to be persistently stored.
 * @param minLoadReductionCost minimum load reduction cost.
 *        Single number for the load
 * @param minLoadReductionInterval Shortest period load reduction shall be maintained before load can be restored to normal levels.
 *        This attribute may be used also in the LoadBid class. The reason that the attribute is also modeled in this class is that it is resource attribute and needs to be persistently stored.
 * @param minReductionTime Minimum Load Reduction Time (min), per Participating Load Resource
 * @param minTimeBetLoadRed Shortest time that load shall be left at normal levels before a new load reduction.
 *        This attribute may be used also in the LoadBid class. The reason that the attribute is also modeled in this class is that it is resource attribute and needs to be persistently stored.
 * @param participatingLoad Participating Load flag: indicates whether the load resource is participates in load reduction actions.
 * @param reqNoticeTime Time period that is required from an order to reduce a load to the time that it takes to get to the minimum load reduction.
 *        This attribute may be used also in the LoadBid class. The reason that the attribute is also modeled in this class is that it is resource attribute and needs to be persistently stored.
 * @param resourceSubType CLR	Controllable Load
 *        NCLR	Non-Controllable Load
 * @param LoadReductionPriceCurve
 * @param LoadReductionTimeCurve
 * @param MktLoadArea
 * @param NPLCustomLoadAggregation A Non-Participating Load Resource aggregation scheme with resource-specific Distribution Factors that are submitted with the Bid and for which the distributed Energy is settled at the relevant Distribution Location marginal prices.
 */
case class RegisteredLoad
(
    override val sup: Element,
    val blockLoadTransferFlag: String,
    val dynamicallyScheduledLoadResourceFlag: String,
    val dynamicallyScheduledQualificationFlag: String,
    val loadRegistryMSS: String,
    val maxBaseLoad: Double,
    val maxDeploymentTime: Double,
    val maxLoadRedTimesPerDay: Int,
    val maxLoadReduction: Double,
    val maxReductionTime: Double,
    val maxWeeklyDeployment: Int,
    val minLoadReduction: Double,
    val minLoadReductionCost: Double,
    val minLoadReductionInterval: Double,
    val minReductionTime: Double,
    val minTimeBetLoadRed: Double,
    val participatingLoad: String,
    val reqNoticeTime: Double,
    val resourceSubType: String,
    val LoadReductionPriceCurve: List[String],
    val LoadReductionTimeCurve: List[String],
    val MktLoadArea: String,
    val NPLCustomLoadAggregation: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, 0.0, 0.0, 0, 0.0, 0.0, 0, 0.0, 0.0, 0.0, 0.0, 0.0, null, 0.0, null, List(), List(), null, null) }
    def RegisteredResource: RegisteredResource = sup.asInstanceOf[RegisteredResource]
    override def copy (): Row = { return (clone ().asInstanceOf[RegisteredLoad]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RegisteredLoad
extends
    Parseable[RegisteredLoad]
{
    val sup = RegisteredResource.parse _
    val blockLoadTransferFlag = parse_attribute (attribute ("""RegisteredLoad.blockLoadTransferFlag"""))
    val dynamicallyScheduledLoadResourceFlag = parse_attribute (attribute ("""RegisteredLoad.dynamicallyScheduledLoadResourceFlag"""))
    val dynamicallyScheduledQualificationFlag = parse_attribute (attribute ("""RegisteredLoad.dynamicallyScheduledQualificationFlag"""))
    val loadRegistryMSS = parse_attribute (attribute ("""RegisteredLoad.loadRegistryMSS"""))
    val maxBaseLoad = parse_element (element ("""RegisteredLoad.maxBaseLoad"""))
    val maxDeploymentTime = parse_element (element ("""RegisteredLoad.maxDeploymentTime"""))
    val maxLoadRedTimesPerDay = parse_element (element ("""RegisteredLoad.maxLoadRedTimesPerDay"""))
    val maxLoadReduction = parse_element (element ("""RegisteredLoad.maxLoadReduction"""))
    val maxReductionTime = parse_element (element ("""RegisteredLoad.maxReductionTime"""))
    val maxWeeklyDeployment = parse_element (element ("""RegisteredLoad.maxWeeklyDeployment"""))
    val minLoadReduction = parse_element (element ("""RegisteredLoad.minLoadReduction"""))
    val minLoadReductionCost = parse_element (element ("""RegisteredLoad.minLoadReductionCost"""))
    val minLoadReductionInterval = parse_element (element ("""RegisteredLoad.minLoadReductionInterval"""))
    val minReductionTime = parse_element (element ("""RegisteredLoad.minReductionTime"""))
    val minTimeBetLoadRed = parse_element (element ("""RegisteredLoad.minTimeBetLoadRed"""))
    val participatingLoad = parse_attribute (attribute ("""RegisteredLoad.participatingLoad"""))
    val reqNoticeTime = parse_element (element ("""RegisteredLoad.reqNoticeTime"""))
    val resourceSubType = parse_element (element ("""RegisteredLoad.resourceSubType"""))
    val LoadReductionPriceCurve = parse_attributes (attribute ("""RegisteredLoad.LoadReductionPriceCurve"""))
    val LoadReductionTimeCurve = parse_attributes (attribute ("""RegisteredLoad.LoadReductionTimeCurve"""))
    val MktLoadArea = parse_attribute (attribute ("""RegisteredLoad.MktLoadArea"""))
    val NPLCustomLoadAggregation = parse_attribute (attribute ("""RegisteredLoad.NPLCustomLoadAggregation"""))
    def parse (context: Context): RegisteredLoad =
    {
        RegisteredLoad(
            sup (context),
            blockLoadTransferFlag (context),
            dynamicallyScheduledLoadResourceFlag (context),
            dynamicallyScheduledQualificationFlag (context),
            loadRegistryMSS (context),
            toDouble (maxBaseLoad (context), context),
            toDouble (maxDeploymentTime (context), context),
            toInteger (maxLoadRedTimesPerDay (context), context),
            toDouble (maxLoadReduction (context), context),
            toDouble (maxReductionTime (context), context),
            toInteger (maxWeeklyDeployment (context), context),
            toDouble (minLoadReduction (context), context),
            toDouble (minLoadReductionCost (context), context),
            toDouble (minLoadReductionInterval (context), context),
            toDouble (minReductionTime (context), context),
            toDouble (minTimeBetLoadRed (context), context),
            participatingLoad (context),
            toDouble (reqNoticeTime (context), context),
            resourceSubType (context),
            LoadReductionPriceCurve (context),
            LoadReductionTimeCurve (context),
            MktLoadArea (context),
            NPLCustomLoadAggregation (context)
        )
    }
}

/**
 * This class represents the physical characteristc of a generator regarding the regulating limit
 * @param sup Reference to the superclass object.
 * @param highLimit
 * @param lowLimit
 * @param RegisteredGenerator
 */
case class RegulatingLimit
(
    override val sup: Element,
    val highLimit: Double,
    val lowLimit: Double,
    val RegisteredGenerator: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[RegulatingLimit]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RegulatingLimit
extends
    Parseable[RegulatingLimit]
{
    val sup = IdentifiedObject.parse _
    val highLimit = parse_element (element ("""RegulatingLimit.highLimit"""))
    val lowLimit = parse_element (element ("""RegulatingLimit.lowLimit"""))
    val RegisteredGenerator = parse_attribute (attribute ("""RegulatingLimit.RegisteredGenerator"""))
    def parse (context: Context): RegulatingLimit =
    {
        RegulatingLimit(
            sup (context),
            toDouble (highLimit (context), context),
            toDouble (lowLimit (context), context),
            RegisteredGenerator (context)
        )
    }
}

/**
 * Ancillary Services that a resource is qualified to provide.
 * @param sup Reference to the superclass object.
 * @param certifiedCapacity Certified capacity for associated resource and market type and ancillary service type product
 * @param endEffectiveDate Ancillary Service Qualification end date
 * @param market market type
 * @param qualificationFlag Status of the qualification ('Y' = Active, 'N' = Inactive)
 * @param startEffectiveDate Ancillary Service Qualification effective from date
 * @param typ Type of service based on ResourceAncillaryServiceType enumeration
 * @param RegisteredResource RegisteredResources are qualified for resource ancillary service types (which include market product types as well as other types such as BlackStart) by the association to the class ResourceAncillaryServiceQualification.
 */
case class ResourceAncillaryServiceQualification
(
    override val sup: Element,
    val certifiedCapacity: Double,
    val endEffectiveDate: String,
    val market: String,
    val qualificationFlag: String,
    val startEffectiveDate: String,
    val typ: String,
    val RegisteredResource: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ResourceAncillaryServiceQualification]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ResourceAncillaryServiceQualification
extends
    Parseable[ResourceAncillaryServiceQualification]
{
    val sup = BasicElement.parse _
    val certifiedCapacity = parse_element (element ("""ResourceAncillaryServiceQualification.certifiedCapacity"""))
    val endEffectiveDate = parse_element (element ("""ResourceAncillaryServiceQualification.endEffectiveDate"""))
    val market = parse_attribute (attribute ("""ResourceAncillaryServiceQualification.market"""))
    val qualificationFlag = parse_attribute (attribute ("""ResourceAncillaryServiceQualification.qualificationFlag"""))
    val startEffectiveDate = parse_element (element ("""ResourceAncillaryServiceQualification.startEffectiveDate"""))
    val typ = parse_attribute (attribute ("""ResourceAncillaryServiceQualification.type"""))
    val RegisteredResource = parse_attribute (attribute ("""ResourceAncillaryServiceQualification.RegisteredResource"""))
    def parse (context: Context): ResourceAncillaryServiceQualification =
    {
        ResourceAncillaryServiceQualification(
            sup (context),
            toDouble (certifiedCapacity (context), context),
            endEffectiveDate (context),
            market (context),
            qualificationFlag (context),
            startEffectiveDate (context),
            typ (context),
            RegisteredResource (context)
        )
    }
}

/**
 * This class model the various capacities of a resource.
 * A resource may have numbers of capacities related to operating, ancillary services, energy trade and so forth. The types are but not limited to:
 * @param sup Reference to the superclass object.
 * @param capacityType capacity type

The types are but not limited to:

Regulation Up
Regulation Dn
Spinning Reserve
Non-Spinning Reserve
FOO capacity
 *        MOO capacity
 * @param defaultCapacity default capacity
 * @param maximumCapacity maximum capacity
 * @param minimumCapacity minimum capacity
 */
case class ResourceCapacity
(
    override val sup: Element,
    val capacityType: String,
    val defaultCapacity: Double,
    val maximumCapacity: Double,
    val minimumCapacity: Double
)
extends
    Element
{
    def this () = { this (null, null, 0.0, 0.0, 0.0) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ResourceCapacity]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ResourceCapacity
extends
    Parseable[ResourceCapacity]
{
    val sup = BasicElement.parse _
    val capacityType = parse_attribute (attribute ("""ResourceCapacity.capacityType"""))
    val defaultCapacity = parse_element (element ("""ResourceCapacity.defaultCapacity"""))
    val maximumCapacity = parse_element (element ("""ResourceCapacity.maximumCapacity"""))
    val minimumCapacity = parse_element (element ("""ResourceCapacity.minimumCapacity"""))
    def parse (context: Context): ResourceCapacity =
    {
        ResourceCapacity(
            sup (context),
            capacityType (context),
            toDouble (defaultCapacity (context), context),
            toDouble (maximumCapacity (context), context),
            toDouble (minimumCapacity (context), context)
        )
    }
}

/**
 * To model the Operation and Maintenance (O and M) costs of a generation resource.
 * @param sup Reference to the superclass object.
 * @param gasPercentAboveLowSustainedLimit Percentage of Fuel Index Price (gas) for operating above Low Sustained Limit (LSL)
 * @param oilPercentAboveLowSustainedLimit Percentage of Fuel Oil Price (FOP) for operating above Low Sustained Limit (LSL)
 * @param omCostColdStartup Verifiable O&amp;M Cost ($), Cold Startup
 * @param omCostHotStartup Verifiable O&amp;M Cost ($), Hot Startup
 * @param omCostIntermediateStartup Verifiable O&amp;M Cost ($), Intermediate Startup
 * @param omCostLowSustainedLimit Verifiable O&amp;M Cost ($/MWh), LSL
 * @param solidfuelPercentAboveLowSustainedLimit Percentage of Solid Fuel for operating above Low Sustained Limit (LSL)
 * @param ResourceVerifiableCosts
 */
case class ResourceOperationMaintenanceCost
(
    override val sup: Element,
    val gasPercentAboveLowSustainedLimit: Double,
    val oilPercentAboveLowSustainedLimit: Double,
    val omCostColdStartup: Double,
    val omCostHotStartup: Double,
    val omCostIntermediateStartup: Double,
    val omCostLowSustainedLimit: Double,
    val solidfuelPercentAboveLowSustainedLimit: Double,
    val ResourceVerifiableCosts: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { return (clone ().asInstanceOf[ResourceOperationMaintenanceCost]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ResourceOperationMaintenanceCost
extends
    Parseable[ResourceOperationMaintenanceCost]
{
    val sup = Curve.parse _
    val gasPercentAboveLowSustainedLimit = parse_element (element ("""ResourceOperationMaintenanceCost.gasPercentAboveLowSustainedLimit"""))
    val oilPercentAboveLowSustainedLimit = parse_element (element ("""ResourceOperationMaintenanceCost.oilPercentAboveLowSustainedLimit"""))
    val omCostColdStartup = parse_element (element ("""ResourceOperationMaintenanceCost.omCostColdStartup"""))
    val omCostHotStartup = parse_element (element ("""ResourceOperationMaintenanceCost.omCostHotStartup"""))
    val omCostIntermediateStartup = parse_element (element ("""ResourceOperationMaintenanceCost.omCostIntermediateStartup"""))
    val omCostLowSustainedLimit = parse_element (element ("""ResourceOperationMaintenanceCost.omCostLowSustainedLimit"""))
    val solidfuelPercentAboveLowSustainedLimit = parse_element (element ("""ResourceOperationMaintenanceCost.solidfuelPercentAboveLowSustainedLimit"""))
    val ResourceVerifiableCosts = parse_attribute (attribute ("""ResourceOperationMaintenanceCost.ResourceVerifiableCosts"""))
    def parse (context: Context): ResourceOperationMaintenanceCost =
    {
        ResourceOperationMaintenanceCost(
            sup (context),
            toDouble (gasPercentAboveLowSustainedLimit (context), context),
            toDouble (oilPercentAboveLowSustainedLimit (context), context),
            toDouble (omCostColdStartup (context), context),
            toDouble (omCostHotStartup (context), context),
            toDouble (omCostIntermediateStartup (context), context),
            toDouble (omCostLowSustainedLimit (context), context),
            toDouble (solidfuelPercentAboveLowSustainedLimit (context), context),
            ResourceVerifiableCosts (context)
        )
    }
}

/**
 * To model the startup costs of a generation resource.
 * @param sup Reference to the superclass object.
 * @param fuelColdStartup Verifiable Cold Start Up Fuel (MMBtu per start)
 * @param fuelHotStartup Verifiable Hot Start Up Fuel (MMBtu per start)
 * @param fuelIntermediateStartup Verifiable Intermediate Start Up Fuel (MMBtu per start)
 * @param fuelLowSustainedLimit Minimum-Energy fuel, MMBtu/MWh
 * @param gasPercentColdStartup Percentage of Fuel Index Price (gas) for cold startup
 * @param gasPercentHotStartup Percentage of Fuel Index Price (gas) for hot startup
 * @param gasPercentIntermediateStartup Percentage of Fuel Index Price (gas) for intermediate startup
 * @param gasPercentLowSustainedLimit Percentage of FIP (gas) for operating at LSL
 * @param oilPercentColdStartup Percentage of Fuel Oil Price (FOP) for cold startup
 * @param oilPercentHotStartup Percentage of Fuel Oil Price (FOP) for hot startup
 * @param oilPercentIntermediateStartup Percentage of Fuel Oil Price (FOP) for intermediate startup
 * @param oilPercentLowSustainedLimit Percentage of FOP (oil) for operating at LSL
 * @param solidfuelPercentColdStartup Percentage of Solid Fuel for cold startup
 * @param solidfuelPercentHotStartup Percentage of Solid Fuel for hot startup
 * @param solidfuelPercentIntermediateStartup Percentage of Solid Fuel for intermedite startup
 * @param solidfuelPercentLowSustainedLimit Percentage of Solid Fuel for operating at LSL
 */
case class ResourceStartupCost
(
    override val sup: Element,
    val fuelColdStartup: Double,
    val fuelHotStartup: Double,
    val fuelIntermediateStartup: Double,
    val fuelLowSustainedLimit: Double,
    val gasPercentColdStartup: Double,
    val gasPercentHotStartup: Double,
    val gasPercentIntermediateStartup: Double,
    val gasPercentLowSustainedLimit: Double,
    val oilPercentColdStartup: Double,
    val oilPercentHotStartup: Double,
    val oilPercentIntermediateStartup: Double,
    val oilPercentLowSustainedLimit: Double,
    val solidfuelPercentColdStartup: Double,
    val solidfuelPercentHotStartup: Double,
    val solidfuelPercentIntermediateStartup: Double,
    val solidfuelPercentLowSustainedLimit: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ResourceStartupCost]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ResourceStartupCost
extends
    Parseable[ResourceStartupCost]
{
    val sup = BasicElement.parse _
    val fuelColdStartup = parse_element (element ("""ResourceStartupCost.fuelColdStartup"""))
    val fuelHotStartup = parse_element (element ("""ResourceStartupCost.fuelHotStartup"""))
    val fuelIntermediateStartup = parse_element (element ("""ResourceStartupCost.fuelIntermediateStartup"""))
    val fuelLowSustainedLimit = parse_element (element ("""ResourceStartupCost.fuelLowSustainedLimit"""))
    val gasPercentColdStartup = parse_element (element ("""ResourceStartupCost.gasPercentColdStartup"""))
    val gasPercentHotStartup = parse_element (element ("""ResourceStartupCost.gasPercentHotStartup"""))
    val gasPercentIntermediateStartup = parse_element (element ("""ResourceStartupCost.gasPercentIntermediateStartup"""))
    val gasPercentLowSustainedLimit = parse_element (element ("""ResourceStartupCost.gasPercentLowSustainedLimit"""))
    val oilPercentColdStartup = parse_element (element ("""ResourceStartupCost.oilPercentColdStartup"""))
    val oilPercentHotStartup = parse_element (element ("""ResourceStartupCost.oilPercentHotStartup"""))
    val oilPercentIntermediateStartup = parse_element (element ("""ResourceStartupCost.oilPercentIntermediateStartup"""))
    val oilPercentLowSustainedLimit = parse_element (element ("""ResourceStartupCost.oilPercentLowSustainedLimit"""))
    val solidfuelPercentColdStartup = parse_element (element ("""ResourceStartupCost.solidfuelPercentColdStartup"""))
    val solidfuelPercentHotStartup = parse_element (element ("""ResourceStartupCost.solidfuelPercentHotStartup"""))
    val solidfuelPercentIntermediateStartup = parse_element (element ("""ResourceStartupCost.solidfuelPercentIntermediateStartup"""))
    val solidfuelPercentLowSustainedLimit = parse_element (element ("""ResourceStartupCost.solidfuelPercentLowSustainedLimit"""))
    def parse (context: Context): ResourceStartupCost =
    {
        ResourceStartupCost(
            sup (context),
            toDouble (fuelColdStartup (context), context),
            toDouble (fuelHotStartup (context), context),
            toDouble (fuelIntermediateStartup (context), context),
            toDouble (fuelLowSustainedLimit (context), context),
            toDouble (gasPercentColdStartup (context), context),
            toDouble (gasPercentHotStartup (context), context),
            toDouble (gasPercentIntermediateStartup (context), context),
            toDouble (gasPercentLowSustainedLimit (context), context),
            toDouble (oilPercentColdStartup (context), context),
            toDouble (oilPercentHotStartup (context), context),
            toDouble (oilPercentIntermediateStartup (context), context),
            toDouble (oilPercentLowSustainedLimit (context), context),
            toDouble (solidfuelPercentColdStartup (context), context),
            toDouble (solidfuelPercentHotStartup (context), context),
            toDouble (solidfuelPercentIntermediateStartup (context), context),
            toDouble (solidfuelPercentLowSustainedLimit (context), context)
        )
    }
}

/**
 * This class is defined to describe the verifiable costs associated with a generation resource.
 * @param sup Reference to the superclass object.
 * @param MktHeatRateCurve
 * @param RegisteredResource
 * @param ResourceOperationMaintenanceCost
 */
case class ResourceVerifiableCosts
(
    override val sup: Element,
    val MktHeatRateCurve: String,
    val RegisteredResource: String,
    val ResourceOperationMaintenanceCost: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ResourceVerifiableCosts]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ResourceVerifiableCosts
extends
    Parseable[ResourceVerifiableCosts]
{
    val sup = BasicElement.parse _
    val MktHeatRateCurve = parse_attribute (attribute ("""ResourceVerifiableCosts.MktHeatRateCurve"""))
    val RegisteredResource = parse_attribute (attribute ("""ResourceVerifiableCosts.RegisteredResource"""))
    val ResourceOperationMaintenanceCost = parse_attribute (attribute ("""ResourceVerifiableCosts.ResourceOperationMaintenanceCost"""))
    def parse (context: Context): ResourceVerifiableCosts =
    {
        ResourceVerifiableCosts(
            sup (context),
            MktHeatRateCurve (context),
            RegisteredResource (context),
            ResourceOperationMaintenanceCost (context)
        )
    }
}

/**
 * Market participants could be represented by Scheduling Coordinators (SCs) that are registered with the RTO/ISO.
 * One participant could register multiple SCs with the RTO/ISO. Many market participants can do business with the RTO/ISO using a single SC. One SC could schedule multiple generators. A load scheduling point could be used by multiple SCs. Each SC could schedule load at multiple scheduling points. An inter-tie scheduling point can be used by multiple SCs. Each SC can schedule interchange at multiple inter-tie scheduling points.
 * @param sup Reference to the superclass object.
 * @param scid This is the short name or Scheduling Coordinator ID field.
 * @param LoadRatio
 * @param MktOrgansation
 */
case class SchedulingCoordinator
(
    override val sup: Element,
    val scid: String,
    val LoadRatio: String,
    val MktOrgansation: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def MktOrganisation: MktOrganisation = sup.asInstanceOf[MktOrganisation]
    override def copy (): Row = { return (clone ().asInstanceOf[SchedulingCoordinator]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SchedulingCoordinator
extends
    Parseable[SchedulingCoordinator]
{
    val sup = MktOrganisation.parse _
    val scid = parse_element (element ("""SchedulingCoordinator.scid"""))
    val LoadRatio = parse_attribute (attribute ("""SchedulingCoordinator.LoadRatio"""))
    val MktOrgansation = parse_attribute (attribute ("""SchedulingCoordinator.MktOrgansation"""))
    def parse (context: Context): SchedulingCoordinator =
    {
        SchedulingCoordinator(
            sup (context),
            scid (context),
            LoadRatio (context),
            MktOrgansation (context)
        )
    }
}

/**
 * Describing users of a Scheduling Coordinator
 * @param sup Reference to the superclass object.
 * @param endEffectiveDate Login ID Expiration Date
 * @param loginID Login ID
 * @param loginRole Assigned roles (these are roles with either Read or Read/Write privileges on different Market Systems)
 * @param startEffectiveDate Login ID Effective Date
 */
case class SchedulingCoordinatorUser
(
    override val sup: Element,
    val endEffectiveDate: String,
    val loginID: String,
    val loginRole: String,
    val startEffectiveDate: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[SchedulingCoordinatorUser]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SchedulingCoordinatorUser
extends
    Parseable[SchedulingCoordinatorUser]
{
    val sup = BasicElement.parse _
    val endEffectiveDate = parse_element (element ("""SchedulingCoordinatorUser.endEffectiveDate"""))
    val loginID = parse_element (element ("""SchedulingCoordinatorUser.loginID"""))
    val loginRole = parse_element (element ("""SchedulingCoordinatorUser.loginRole"""))
    val startEffectiveDate = parse_element (element ("""SchedulingCoordinatorUser.startEffectiveDate"""))
    def parse (context: Context): SchedulingCoordinatorUser =
    {
        SchedulingCoordinatorUser(
            sup (context),
            endEffectiveDate (context),
            loginID (context),
            loginRole (context),
            startEffectiveDate (context)
        )
    }
}

/**
 * Connection to other organizations at the boundary of the ISO/RTO.
 * @param sup Reference to the superclass object.
 * @param endEffectiveDate End effective date.
 * @param startEffectiveDate Start effective date.
 * @param Flowgate
 */
case class SchedulingPoint
(
    override val sup: Element,
    val endEffectiveDate: String,
    val startEffectiveDate: String,
    val Flowgate: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[SchedulingPoint]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SchedulingPoint
extends
    Parseable[SchedulingPoint]
{
    val sup = IdentifiedObject.parse _
    val endEffectiveDate = parse_element (element ("""SchedulingPoint.endEffectiveDate"""))
    val startEffectiveDate = parse_element (element ("""SchedulingPoint.startEffectiveDate"""))
    val Flowgate = parse_attribute (attribute ("""SchedulingPoint.Flowgate"""))
    def parse (context: Context): SchedulingPoint =
    {
        SchedulingPoint(
            sup (context),
            endEffectiveDate (context),
            startEffectiveDate (context),
            Flowgate (context)
        )
    }
}

/**
 * The energy consumption of a generating resource to complete a start-up from the StartUpEnergyCurve.
 * Definition of the StartUpEnergyCurve includes, xvalue as the cooling time and y1value as the MW value.
 * @param sup Reference to the superclass object.
 * @param RegisteredGenerator
 */
case class StartUpEnergyCurve
(
    override val sup: Element,
    val RegisteredGenerator: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { return (clone ().asInstanceOf[StartUpEnergyCurve]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object StartUpEnergyCurve
extends
    Parseable[StartUpEnergyCurve]
{
    val sup = Curve.parse _
    val RegisteredGenerator = parse_attribute (attribute ("""StartUpEnergyCurve.RegisteredGenerator"""))
    def parse (context: Context): StartUpEnergyCurve =
    {
        StartUpEnergyCurve(
            sup (context),
            RegisteredGenerator (context)
        )
    }
}

/**
 * The fuel consumption of a Generating Resource to complete a Start-Up.(x=cooling time) Form Startup Fuel Curve. xAxisData -&gt; cooling time, y1AxisData -&gt; MBtu
 * @param sup Reference to the superclass object.
 * @param RegisteredGenerator
 */
case class StartUpFuelCurve
(
    override val sup: Element,
    val RegisteredGenerator: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { return (clone ().asInstanceOf[StartUpFuelCurve]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object StartUpFuelCurve
extends
    Parseable[StartUpFuelCurve]
{
    val sup = Curve.parse _
    val RegisteredGenerator = parse_attribute (attribute ("""StartUpFuelCurve.RegisteredGenerator"""))
    def parse (context: Context): StartUpFuelCurve =
    {
        StartUpFuelCurve(
            sup (context),
            RegisteredGenerator (context)
        )
    }
}

/**
 * An area defined for the purpose of tracking interchange with surrounding areas via tie points; may or may not serve as a control area.
 * @param sup Reference to the superclass object.
 * @param areaShortName Market area short name, which is the regulation zone.
 *        It references AGC regulation zone name.
 * @param constantCoefficient Loss estimate constant coefficient
 * @param embeddedControlArea Used in conjunction with the InternalCA flag.
 *        If the InternalCA flag is YES, this flag does not apply. If the InternaCA flag is NO, this flag provides an indication of AdjacentCA (NO) or Embedded CA (YES).
 * @param endEffectiveDate end effective date
 * @param internalCA A Yes/No indication that this control area is contained internal to the system.
 * @param linearCoefficient Loss estimate linear coefficient
 * @param localCA Indication that this control area is the local control area.
 * @param maxSelfSchedMW Maximum amount of self schedule MWs allowed for an embedded control area.
 * @param minSelfSchedMW Minimum amount of self schedule MW allowed for an embedded control area.
 * @param quadraticCoefficient Loss estimate quadratic coefficient
 * @param startEffectiveDate start effective date
 * @param AdjacentCASet
 * @param AreaReserveSpecification
 * @param HostControlArea The interchange area  may operate as a control area
 * @param RTO
 */
case class SubControlArea
(
    override val sup: Element,
    val areaShortName: String,
    val constantCoefficient: Double,
    val embeddedControlArea: String,
    val endEffectiveDate: String,
    val internalCA: String,
    val linearCoefficient: Double,
    val localCA: String,
    val maxSelfSchedMW: Double,
    val minSelfSchedMW: Double,
    val quadraticCoefficient: Double,
    val startEffectiveDate: String,
    val AdjacentCASet: String,
    val AreaReserveSpecification: String,
    val HostControlArea: String,
    val RTO: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, null, null, null, 0.0, null, 0.0, 0.0, 0.0, null, null, null, null, null) }
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { return (clone ().asInstanceOf[SubControlArea]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SubControlArea
extends
    Parseable[SubControlArea]
{
    val sup = PowerSystemResource.parse _
    val areaShortName = parse_element (element ("""SubControlArea.areaShortName"""))
    val constantCoefficient = parse_element (element ("""SubControlArea.constantCoefficient"""))
    val embeddedControlArea = parse_attribute (attribute ("""SubControlArea.embeddedControlArea"""))
    val endEffectiveDate = parse_element (element ("""SubControlArea.endEffectiveDate"""))
    val internalCA = parse_attribute (attribute ("""SubControlArea.internalCA"""))
    val linearCoefficient = parse_element (element ("""SubControlArea.linearCoefficient"""))
    val localCA = parse_attribute (attribute ("""SubControlArea.localCA"""))
    val maxSelfSchedMW = parse_element (element ("""SubControlArea.maxSelfSchedMW"""))
    val minSelfSchedMW = parse_element (element ("""SubControlArea.minSelfSchedMW"""))
    val quadraticCoefficient = parse_element (element ("""SubControlArea.quadraticCoefficient"""))
    val startEffectiveDate = parse_element (element ("""SubControlArea.startEffectiveDate"""))
    val AdjacentCASet = parse_attribute (attribute ("""SubControlArea.AdjacentCASet"""))
    val AreaReserveSpecification = parse_attribute (attribute ("""SubControlArea.AreaReserveSpecification"""))
    val HostControlArea = parse_attribute (attribute ("""SubControlArea.HostControlArea"""))
    val RTO = parse_attribute (attribute ("""SubControlArea.RTO"""))
    def parse (context: Context): SubControlArea =
    {
        SubControlArea(
            sup (context),
            areaShortName (context),
            toDouble (constantCoefficient (context), context),
            embeddedControlArea (context),
            endEffectiveDate (context),
            internalCA (context),
            toDouble (linearCoefficient (context), context),
            localCA (context),
            toDouble (maxSelfSchedMW (context), context),
            toDouble (minSelfSchedMW (context), context),
            toDouble (quadraticCoefficient (context), context),
            startEffectiveDate (context),
            AdjacentCASet (context),
            AreaReserveSpecification (context),
            HostControlArea (context),
            RTO (context)
        )
    }
}

/**
 * List of resources that can be substituted for within the bounds of a Contract definition.
 * This class has a precedence and a resource.
 * @param sup Reference to the superclass object.
 * @param precedence An indicator of the order a resource should be substituted.
 *        The lower the number the higher the precedence.
 * @param RegisteredResource
 * @param TransmissionContractRight
 */
case class SubstitutionResourceList
(
    override val sup: Element,
    val precedence: Int,
    val RegisteredResource: String,
    val TransmissionContractRight: String
)
extends
    Element
{
    def this () = { this (null, 0, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[SubstitutionResourceList]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SubstitutionResourceList
extends
    Parseable[SubstitutionResourceList]
{
    val sup = BasicElement.parse _
    val precedence = parse_element (element ("""SubstitutionResourceList.precedence"""))
    val RegisteredResource = parse_attribute (attribute ("""SubstitutionResourceList.RegisteredResource"""))
    val TransmissionContractRight = parse_attribute (attribute ("""SubstitutionResourceList.TransmissionContractRight"""))
    def parse (context: Context): SubstitutionResourceList =
    {
        SubstitutionResourceList(
            sup (context),
            toInteger (precedence (context), context),
            RegisteredResource (context),
            TransmissionContractRight (context)
        )
    }
}

/**
 * Transmission Access Charge Area.
 * Charges assessed, on behalf of the Participating Transmission Owner, to parties who require access to the controlled grid.
 * @param sup Reference to the superclass object.
 * @param endEffectiveDate end effective date
 * @param startEffectiveDate start effective date
 */
case class TACArea
(
    override val sup: Element,
    val endEffectiveDate: String,
    val startEffectiveDate: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[TACArea]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TACArea
extends
    Parseable[TACArea]
{
    val sup = IdentifiedObject.parse _
    val endEffectiveDate = parse_element (element ("""TACArea.endEffectiveDate"""))
    val startEffectiveDate = parse_element (element ("""TACArea.startEffectiveDate"""))
    def parse (context: Context): TACArea =
    {
        TACArea(
            sup (context),
            endEffectiveDate (context),
            startEffectiveDate (context)
        )
    }
}

/**
 * Allows chaining of TransmissionContractRights.
 * Many individual contract rights can be included in the definition of a TransmissionRightChain. A TransmissionRightChain is also defined as a TransmissionContractRight itself.
 * @param sup Reference to the superclass object.
 * @param endEffectiveDate end effective date
 * @param startEffectiveDate start effective date
 * @param Chain_ContractRight
 * @param RTO
 */
case class TransmissionRightChain
(
    override val sup: Element,
    val endEffectiveDate: String,
    val startEffectiveDate: String,
    val Chain_ContractRight: String,
    val RTO: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[TransmissionRightChain]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TransmissionRightChain
extends
    Parseable[TransmissionRightChain]
{
    val sup = IdentifiedObject.parse _
    val endEffectiveDate = parse_element (element ("""TransmissionRightChain.endEffectiveDate"""))
    val startEffectiveDate = parse_element (element ("""TransmissionRightChain.startEffectiveDate"""))
    val Chain_ContractRight = parse_attribute (attribute ("""TransmissionRightChain.Chain_ContractRight"""))
    val RTO = parse_attribute (attribute ("""TransmissionRightChain.RTO"""))
    def parse (context: Context): TransmissionRightChain =
    {
        TransmissionRightChain(
            sup (context),
            endEffectiveDate (context),
            startEffectiveDate (context),
            Chain_ContractRight (context),
            RTO (context)
        )
    }
}

/**
 * Counter party in a wheeling transaction.
 * @param sup Reference to the superclass object.
 * @param RegisteredInterTie
 */
case class WheelingCounterParty
(
    override val sup: Element,
    val RegisteredInterTie: List[String]
)
extends
    Element
{
    def this () = { this (null, List()) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[WheelingCounterParty]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WheelingCounterParty
extends
    Parseable[WheelingCounterParty]
{
    val sup = IdentifiedObject.parse _
    val RegisteredInterTie = parse_attributes (attribute ("""WheelingCounterParty.RegisteredInterTie"""))
    def parse (context: Context): WheelingCounterParty =
    {
        WheelingCounterParty(
            sup (context),
            RegisteredInterTie (context)
        )
    }
}

object _ReferenceData
{
    def register: Unit =
    {
        AdjacentCASet.register
        AggregateNode.register
        AggregatedPnode.register
        BidPriceCap.register
        CnodeDistributionFactor.register
        CombinedCycleConfiguration.register
        CombinedCycleConfigurationMember.register
        CombinedCycleLogicalConfiguration.register
        CombinedCycleTransitionState.register
        CongestionArea.register
        ContractDistributionFactor.register
        ContractRight.register
        ControlAreaDesignation.register
        Flowgate.register
        FlowgatePartner.register
        FlowgateRelief.register
        FlowgateValue.register
        ForbiddenRegion.register
        FormerReference.register
        FuelCostCurve.register
        FuelRegion.register
        GasPrice.register
        HostControlArea.register
        IndividualPnode.register
        LoadAggregationPoint.register
        LoadRatio.register
        LoadReductionTimeCurve.register
        LocalReliabilityArea.register
        MPMTestCategory.register
        MPMTestThreshold.register
        MSSAggregation.register
        MSSZone.register
        MarketPerson.register
        MarketQualificationRequirement.register
        MarketRegion.register
        MarketSkill.register
        MaxStartUpCostCurve.register
        MeteredSubSystem.register
        MktCombinedCyclePlant.register
        MktConductingEquipment.register
        MktContingency.register
        MktHeatRateCurve.register
        MktThermalGeneratingUnit.register
        OilPrice.register
        OrgPnodeAllocation.register
        OrgResOwnership.register
        Pnode.register
        PnodeDistributionFactor.register
        RMRHeatRateCurve.register
        RMRStartUpCostCurve.register
        RMRStartUpEnergyCurve.register
        RMRStartUpFuelCurve.register
        RMRStartUpTimeCurve.register
        RTO.register
        RUCZone.register
        RegisteredGenerator.register
        RegisteredInterTie.register
        RegisteredLoad.register
        RegulatingLimit.register
        ResourceAncillaryServiceQualification.register
        ResourceCapacity.register
        ResourceOperationMaintenanceCost.register
        ResourceStartupCost.register
        ResourceVerifiableCosts.register
        SchedulingCoordinator.register
        SchedulingCoordinatorUser.register
        SchedulingPoint.register
        StartUpEnergyCurve.register
        StartUpFuelCurve.register
        SubControlArea.register
        SubstitutionResourceList.register
        TACArea.register
        TransmissionRightChain.register
        WheelingCounterParty.register
    }
}