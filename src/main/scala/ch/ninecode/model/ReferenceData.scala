package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * Market static reference data.
 */

/**
 * Goups Adjacent Control Areas
 */
case class AdjacentCASet
(

    override val sup: IdentifiedObject,

    /**
     * end effective date
     */
    val endEffectiveDate: String,

    /**
     * Loss percentage
     */
    val lossPercentage_1: Double,

    /**
     * start effective date
     */
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
    val endEffectiveDate = parse_element (element ("""AdjacentCASet.endEffectiveDate"""))_
    val lossPercentage_1 = parse_element (element ("""AdjacentCASet.lossPercentage """))_
    val startEffectiveDate = parse_element (element ("""AdjacentCASet.startEffectiveDate"""))_
    val HostControlArea = parse_attribute (attribute ("""AdjacentCASet.HostControlArea"""))_
    val RTO = parse_attribute (attribute ("""AdjacentCASet.RTO"""))_
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
 */
case class AggregateNode
(

    override val sup: IdentifiedObject,

    /**
     * Type of aggregated node
     */
    val anodeType: String,

    /**
     * end effective date
     */
    val endEffectiveDate: String,

    /**
     * Processing Order for AS self-provisions for this region.
     * The priority of this attribute directs the awards of any resource that resides in overlapping regions. The regions are processed in priority manner.
     */
    val qualifASOrder: Int,

    /**
     * start effective date
     */
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
    val anodeType = parse_attribute (attribute ("""AggregateNode.anodeType"""))_
    val endEffectiveDate = parse_element (element ("""AggregateNode.endEffectiveDate"""))_
    val qualifASOrder = parse_element (element ("""AggregateNode.qualifASOrder"""))_
    val startEffectiveDate = parse_element (element ("""AggregateNode.startEffectiveDate"""))_
    val Pnode = parse_attributes (attribute ("""AggregateNode.Pnode"""))_
    val RTO = parse_attribute (attribute ("""AggregateNode.RTO"""))_
    val SubControlArea = parse_attributes (attribute ("""AggregateNode.SubControlArea"""))_
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
 */
case class AggregatedPnode
(

    override val sup: Pnode,

    /**
     * Aggregate Price Node Types
     */
    val apnodeType: String,

    /**
     * Designated Control Area participation in LMP price measurement
    
    'Y' - Participates in both Local Market Power Mitigation (LMPM) and System Market Power Mitigation (SMPM)
    'N' - Not included in LMP price measures
    'S' - Participatesin SMPM price measures
     * 'L' - Participatesin LMPM price measures
     */
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
    val apnodeType = parse_attribute (attribute ("""AggregatedPnode.apnodeType"""))_
    val participationCategory = parse_attribute (attribute ("""AggregatedPnode.participationCategory"""))_
    val PnodeDistributionFactor = parse_attribute (attribute ("""AggregatedPnode.PnodeDistributionFactor"""))_
    val TACArea = parse_attributes (attribute ("""AggregatedPnode.TACArea"""))_
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
 */
case class BidPriceCap
(

    override val sup: BasicElement,

    /**
     * Bid Ceiling ($/MWH)
     */
    val bidCeiling: Double,

    /**
     * Bid Ceiling ($/MWH) for generic AS versus a specific market product
     */
    val bidCeilingAS: Double,

    /**
     * Bid Floor, ($/MWH)
     */
    val bidFloor: Double,

    /**
     * Bid Floor ($/MWH) for generic AS versus a specific market product
     */
    val bidFloorAS: Double,

    /**
     * Bid Default Price($/MWH)
     */
    val defaultPrice: Double,

    /**
     * Market Type of the cap (DAM or RTM)
     */
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
    val bidCeiling = parse_element (element ("""BidPriceCap.bidCeiling"""))_
    val bidCeilingAS = parse_element (element ("""BidPriceCap.bidCeilingAS"""))_
    val bidFloor = parse_element (element ("""BidPriceCap.bidFloor"""))_
    val bidFloorAS = parse_element (element ("""BidPriceCap.bidFloorAS"""))_
    val defaultPrice = parse_element (element ("""BidPriceCap.defaultPrice"""))_
    val marketType = parse_attribute (attribute ("""BidPriceCap.marketType"""))_
    val MarketProduct = parse_attribute (attribute ("""BidPriceCap.MarketProduct"""))_
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
 */
case class CnodeDistributionFactor
(

    override val sup: IdentifiedObject,

    /**
     * Used to calculate "participation" of Cnode in an AggregateNode
     */
    val factor: Double,

    /**
     * Point of delivery loss factor
     */
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
    val factor = parse_element (element ("""CnodeDistributionFactor.factor"""))_
    val podLossFactor = parse_element (element ("""CnodeDistributionFactor.podLossFactor"""))_
    val AggregateNode = parse_attribute (attribute ("""CnodeDistributionFactor.AggregateNode"""))_
    val HostControlArea = parse_attribute (attribute ("""CnodeDistributionFactor.HostControlArea"""))_
    val MktConnectivityNode = parse_attribute (attribute ("""CnodeDistributionFactor.MktConnectivityNode"""))_
    val SubControlArea = parse_attribute (attribute ("""CnodeDistributionFactor.SubControlArea"""))_
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
 */
case class CombinedCycleConfiguration
(

    override val sup: RegisteredGenerator,

    /**
     * Whether this CombinedCycleConfiguration is the primary configuration in the associated Logical configuration?
     */
    val primaryConfiguration: Boolean,

    val CombinedCycleLogicalConfiguration: String,

    /**
     * Whether Combined Cycle Plant can be shut-down in this Configuration?
     */
    val ShutdownFlag: Boolean,

    /**
     * Whether Combined Cycle Plant can be started in this Logical Configuration?
     */
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
    val primaryConfiguration = parse_element (element ("""CombinedCycleConfiguration.primaryConfiguration"""))_
    val CombinedCycleLogicalConfiguration = parse_attribute (attribute ("""CombinedCycleConfiguration.CombinedCycleLogicalConfiguration"""))_
    val ShutdownFlag = parse_element (element ("""CombinedCycleConfiguration.ShutdownFlag"""))_
    val StartupFlag = parse_element (element ("""CombinedCycleConfiguration.StartupFlag"""))_
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
 */
case class CombinedCycleConfigurationMember
(

    override val sup: IdentifiedObject,

    /**
     * primary configuration.
     */
    val primary: Boolean,

    /**
     * Steam plant.
     */
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
    val primary = parse_element (element ("""CombinedCycleConfigurationMember.primary"""))_
    val steam = parse_element (element ("""CombinedCycleConfigurationMember.steam"""))_
    val CombinedCycleConfiguration = parse_attribute (attribute ("""CombinedCycleConfigurationMember.CombinedCycleConfiguration"""))_
    val MktThermalGeneratingUnit = parse_attribute (attribute ("""CombinedCycleConfigurationMember.MktThermalGeneratingUnit"""))_
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
 */
case class CombinedCycleLogicalConfiguration
(

    override val sup: IdentifiedObject,

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
    val MktCombinedCyclePlant = parse_attribute (attribute ("""CombinedCycleLogicalConfiguration.MktCombinedCyclePlant"""))_
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
 */
case class CombinedCycleTransitionState
(

    override val sup: BasicElement,

    /**
     * Flag indicating whether this is an UP transition.
     * If not, it is a DOWN transition.
     */
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
    val upTransition = parse_element (element ("""CombinedCycleTransitionState.upTransition"""))_
    val FromConfiguration = parse_attribute (attribute ("""CombinedCycleTransitionState.FromConfiguration"""))_
    val ToConfiguration = parse_attribute (attribute ("""CombinedCycleTransitionState.ToConfiguration"""))_
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
 */
case class CongestionArea
(

    override val sup: AggregatedPnode,

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
    val IndividualPnode = parse_attributes (attribute ("""CongestionArea.IndividualPnode"""))_
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
 */
case class ContractDistributionFactor
(

    override val sup: BasicElement,

    /**
     * MW value that this resource provides to the overall contract.
     */
    val factor: Double,

    /**
     * This value will be set to YES if the referenced Cnode is defined as the sink point in the contract.
     */
    val sinkFlag: String,

    /**
     * This value will be set to YES if the referenced Cnode is defined as the source point in the contract.
     */
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
    val factor = parse_element (element ("""ContractDistributionFactor.factor"""))_
    val sinkFlag = parse_attribute (attribute ("""ContractDistributionFactor.sinkFlag"""))_
    val sourceFlag = parse_attribute (attribute ("""ContractDistributionFactor.sourceFlag"""))_
    val Flowgate = parse_attribute (attribute ("""ContractDistributionFactor.Flowgate"""))_
    val RegisteredResource = parse_attribute (attribute ("""ContractDistributionFactor.RegisteredResource"""))_
    val TransmissionContractRight = parse_attribute (attribute ("""ContractDistributionFactor.TransmissionContractRight"""))_
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
 */
case class ContractRight
(

    override val sup: IdentifiedObject,

    /**
     * When used in conjunction with a Transmission Right contract chain, this is the precedence for the contracts.
     */
    val chainOrder: Int,

    /**
     * MW value of the contract
     */
    val contractMW: Double,

    /**
     * Financial value of the contract
     */
    val contractPrice: Double,

    /**
     * Priority for the contract.
     * This should be unique amoung all contracts for a specific resource. This value is the directive for the SCUC algorithm on the order to satisfy/cut contracts.
     */
    val contractPriority: Int,

    /**
     * Contract status
     */
    val contractStatus: String,

    /**
     * type of the contract.
     * Possible values are but not limited by:
     */
    val contractType: String,

    /**
     * end effective date
     */
    val endEffectiveDate: String,

    /**
     * Indicator if the location associated with this contract is financial (e.g. pricing nodes) or physical (e.g. connectivity nodes).
     */
    val financialLocation: String,

    /**
     * Flag to indicate this contract provides financial rights in the DA Market
     */
    val financialRightsDAM: String,

    /**
     * Flag to indicate this contract provides financial rights in the RT Market
     */
    val financialRightsRTM: String,

    /**
     * Estimated Fuel Adder
     */
    val fuelAdder: Double,

    /**
     * This indicates the latest schedule minutes (e.g. t - xx) that this resource can be notified to respond.
     * This attribute is only used if the market type is not supplied.
     */
    val latestSchedMinutes: Int,

    /**
     * This indicates the latest schedule market type a contract can be applied to.
     * This is used in conjunction with the latestSchedMinutes attribute to determine the latest time this contract can be called in. The possible values for this attribute are: DAM, RTM or it can be omitted. If omitted, the latestSchedMinutes attribute defines the value.
     */
    val latestSchedMktType: String,

    /**
     * Maximum Net Dependable Capacity
     */
    val maxNetDependableCapacity: Double,

    /**
     * Maximum schedule MW quantity
     */
    val maximumScheduleQuantity: Double,

    /**
     * Maximum service hours
     */
    val maximumServiceHours: Int,

    /**
     * Maximum startups
     */
    val maximumStartups: Int,

    /**
     * Minimum Load
     */
    val minimumLoad: Double,

    /**
     * Minimum schedule quanity
     */
    val minimumScheduleQuantity: Double,

    /**
     * Flag to indicate this contract provides physical rights in the DA Market
     */
    val physicalRightsDAM: String,

    /**
     * Flag to indicate this contract provides physical rights in the RT Market
     */
    val physicalRightsRTM: String,

    /**
     * start effective date
     */
    val startEffectiveDate: String,

    /**
     * Start up lead time
     */
    val startupLeadTime: Int,

    val Chain_TransmissionRightChain: String,

    val Ind_TransmissionRightChain: String,

    val RTO: String,

    val SchedulingCoordinator: String,

    /**
     * Transmission Right type - is this an individual contract right or a chain contract right.
     * Types = CHAIN or INDIVIDUAL
     */
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
    val chainOrder = parse_element (element ("""ContractRight.chainOrder"""))_
    val contractMW = parse_element (element ("""ContractRight.contractMW"""))_
    val contractPrice = parse_element (element ("""ContractRight.contractPrice"""))_
    val contractPriority = parse_element (element ("""ContractRight.contractPriority"""))_
    val contractStatus = parse_element (element ("""ContractRight.contractStatus"""))_
    val contractType = parse_attribute (attribute ("""ContractRight.contractType"""))_
    val endEffectiveDate = parse_element (element ("""ContractRight.endEffectiveDate"""))_
    val financialLocation = parse_attribute (attribute ("""ContractRight.financialLocation"""))_
    val financialRightsDAM = parse_attribute (attribute ("""ContractRight.financialRightsDAM"""))_
    val financialRightsRTM = parse_attribute (attribute ("""ContractRight.financialRightsRTM"""))_
    val fuelAdder = parse_element (element ("""ContractRight.fuelAdder"""))_
    val latestSchedMinutes = parse_element (element ("""ContractRight.latestSchedMinutes"""))_
    val latestSchedMktType = parse_attribute (attribute ("""ContractRight.latestSchedMktType"""))_
    val maxNetDependableCapacity = parse_element (element ("""ContractRight.maxNetDependableCapacity"""))_
    val maximumScheduleQuantity = parse_element (element ("""ContractRight.maximumScheduleQuantity"""))_
    val maximumServiceHours = parse_element (element ("""ContractRight.maximumServiceHours"""))_
    val maximumStartups = parse_element (element ("""ContractRight.maximumStartups"""))_
    val minimumLoad = parse_element (element ("""ContractRight.minimumLoad"""))_
    val minimumScheduleQuantity = parse_element (element ("""ContractRight.minimumScheduleQuantity"""))_
    val physicalRightsDAM = parse_attribute (attribute ("""ContractRight.physicalRightsDAM"""))_
    val physicalRightsRTM = parse_attribute (attribute ("""ContractRight.physicalRightsRTM"""))_
    val startEffectiveDate = parse_element (element ("""ContractRight.startEffectiveDate"""))_
    val startupLeadTime = parse_element (element ("""ContractRight.startupLeadTime"""))_
    val Chain_TransmissionRightChain = parse_attribute (attribute ("""ContractRight.Chain_TransmissionRightChain"""))_
    val Ind_TransmissionRightChain = parse_attribute (attribute ("""ContractRight.Ind_TransmissionRightChain"""))_
    val RTO = parse_attribute (attribute ("""ContractRight.RTO"""))_
    val SchedulingCoordinator = parse_attribute (attribute ("""ContractRight.SchedulingCoordinator"""))_
    val TRType = parse_attribute (attribute ("""ContractRight.TRType"""))_
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
 */
case class ControlAreaDesignation
(

    override val sup: BasicElement,

    /**
     * Attained.
     */
    val attained: String,

    /**
     * Native.
     */
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
    val attained = parse_attribute (attribute ("""ControlAreaDesignation.attained"""))_
    val native = parse_attribute (attribute ("""ControlAreaDesignation.native"""))_
    val RegisteredResource = parse_attributes (attribute ("""ControlAreaDesignation.RegisteredResource"""))_
    val SubControlArea = parse_attributes (attribute ("""ControlAreaDesignation.SubControlArea"""))_
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
 */
case class Flowgate
(

    override val sup: PowerSystemResource,

    /**
     * The direction of the flowgate, export or import
     */
    val direction: String,

    /**
     * end effective date
     */
    val endEffectiveDate: String,

    /**
     * Export MW rating
     */
    val exportMWRating: Double,

    /**
     * Import MW rating
     */
    val importMWRating: Double,

    /**
     * start effective date
     */
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
    val direction = parse_attribute (attribute ("""Flowgate.direction"""))_
    val endEffectiveDate = parse_element (element ("""Flowgate.endEffectiveDate"""))_
    val exportMWRating = parse_element (element ("""Flowgate.exportMWRating"""))_
    val importMWRating = parse_element (element ("""Flowgate.importMWRating"""))_
    val startEffectiveDate = parse_element (element ("""Flowgate.startEffectiveDate"""))_
    val CRR = parse_attribute (attribute ("""Flowgate.CRR"""))_
    val From_SubControlArea = parse_attribute (attribute ("""Flowgate.From_SubControlArea"""))_
    val GenericConstraints = parse_attribute (attribute ("""Flowgate.GenericConstraints"""))_
    val HostControlArea = parse_attribute (attribute ("""Flowgate.HostControlArea"""))_
    val MktLine = parse_attributes (attribute ("""Flowgate.MktLine"""))_
    val MktPowerTransformer = parse_attributes (attribute ("""Flowgate.MktPowerTransformer"""))_
    val SecurityConstraints = parse_attribute (attribute ("""Flowgate.SecurityConstraints"""))_
    val To_SubControlArea = parse_attribute (attribute ("""Flowgate.To_SubControlArea"""))_
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
 */
case class FlowgatePartner
(

    override val sup: IdentifiedObject,

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
    val FlowgateValue = parse_attribute (attribute ("""FlowgatePartner.FlowgateValue"""))_
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
 */
case class FlowgateRelief
(

    override val sup: BasicElement,

    /**
     * Date/Time when record becomes effective
     * Used to determine when a record becomes effective.
     */
    val effectiveDate: String,

    /**
     * Energy Flow level that should be maintained according to the TLR rules as specified by the IDC.
     * For Realtime Markets use in dispatch to control constraints under TLR and calculate unconstrained market flows
     */
    val idcTargetMktFlow: Int,

    /**
     * Date/Time when record is no longer effective
     * Used to determine when a record is no longer effective
     */
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
    val effectiveDate = parse_element (element ("""FlowgateRelief.effectiveDate"""))_
    val idcTargetMktFlow = parse_element (element ("""FlowgateRelief.idcTargetMktFlow"""))_
    val terminateDate = parse_element (element ("""FlowgateRelief.terminateDate"""))_
    val Flowgate = parse_attribute (attribute ("""FlowgateRelief.Flowgate"""))_
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
 */
case class FlowgateValue
(

    override val sup: BasicElement,

    /**
     * Limit for Economic Dispatch priority 6 energy flow on the specified flowgate for the specified time period.
     */
    val economicDispatchLimit: Int,

    /**
     * Date/Time when record becomes effective
     * Used to determine when a record becomes effective
     */
    val effectiveDate: String,

    /**
     * Limit for firm flow on the specified flowgate for the specified time period.
     * The amount of energy flow over a specifed flowgate due to generation in the market which can be classified as Firm Network priority.
     */
    val firmNetworkLimit: Int,

    /**
     * Specifies the direction of energy flow in the flowgate
     */
    val flowDirectionFlag: String,

    /**
     * The amount of energy flow over a specifed flowgate due to generation in the market.
     */
    val mktFlow: Int,

    /**
     * Net Energy flow in flowgate for the associated FlowgatePartner
     */
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
    val economicDispatchLimit = parse_element (element ("""FlowgateValue.economicDispatchLimit"""))_
    val effectiveDate = parse_element (element ("""FlowgateValue.effectiveDate"""))_
    val firmNetworkLimit = parse_element (element ("""FlowgateValue.firmNetworkLimit"""))_
    val flowDirectionFlag = parse_attribute (attribute ("""FlowgateValue.flowDirectionFlag"""))_
    val mktFlow = parse_element (element ("""FlowgateValue.mktFlow"""))_
    val netFirmNetworkLimit = parse_element (element ("""FlowgateValue.netFirmNetworkLimit"""))_
    val Flowgate = parse_attribute (attribute ("""FlowgateValue.Flowgate"""))_
    val FlowgatePartner = parse_attribute (attribute ("""FlowgateValue.FlowgatePartner"""))_
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
 */
case class ForbiddenRegion
(

    override val sup: IdentifiedObject,

    /**
     * Time to cross the forbidden region in minutes.
     */
    val crossTime: Int,

    /**
     * Cost associated with crossing the forbidden region
     */
    val crossingCost: Double,

    /**
     * High end of the region definition
     */
    val highMW: Double,

    /**
     * Low end of the region definition.
     */
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
    val crossTime = parse_element (element ("""ForbiddenRegion.crossTime"""))_
    val crossingCost = parse_element (element ("""ForbiddenRegion.crossingCost"""))_
    val highMW = parse_element (element ("""ForbiddenRegion.highMW"""))_
    val lowMW = parse_element (element ("""ForbiddenRegion.lowMW"""))_
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
 */
case class FormerReference
(

    override val sup: IdentifiedObject,

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
    val RegisteredResource = parse_attribute (attribute ("""FormerReference.RegisteredResource"""))_
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
 */
case class FuelCostCurve
(

    override val sup: Curve,

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
    val RegisteredGenerator = parse_attribute (attribute ("""FuelCostCurve.RegisteredGenerator"""))_
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
 */
case class FuelRegion
(

    override val sup: IdentifiedObject,

    /**
     * end effective date
     */
    val endEffectiveDate: String,

    /**
     * The type of fuel region
     */
    val fuelRegionType: String,

    /**
     * Time of last update
     */
    val lastModified: String,

    /**
     * start effective date
     */
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
    val endEffectiveDate = parse_element (element ("""FuelRegion.endEffectiveDate"""))_
    val fuelRegionType = parse_element (element ("""FuelRegion.fuelRegionType"""))_
    val lastModified = parse_element (element ("""FuelRegion.lastModified"""))_
    val startEffectiveDate = parse_element (element ("""FuelRegion.startEffectiveDate"""))_
    val GasPrice = parse_attribute (attribute ("""FuelRegion.GasPrice"""))_
    val OilPrice = parse_attribute (attribute ("""FuelRegion.OilPrice"""))_
    val RTO = parse_attribute (attribute ("""FuelRegion.RTO"""))_
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
 */
case class GasPrice
(

    override val sup: BasicElement,

    /**
     * The average natural gas price at a defined fuel region.
     */
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
    val gasPriceIndex = parse_element (element ("""GasPrice.gasPriceIndex"""))_
    val FuelRegion = parse_attribute (attribute ("""GasPrice.FuelRegion"""))_
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
 */
case class HostControlArea
(

    override val sup: PowerSystemResource,

    /**
     * The area's present control mode: (CF = constant frequency) or (CTL = constant tie-line) or (TLB = tie-line bias) or (OFF = off control)
     */
    val areaControlMode: String,

    /**
     * end effective date
     */
    val endEffectiveDate: String,

    /**
     * The present power system frequency set point for automatic generation control
     */
    val freqSetPoint: Double,

    /**
     * The control area's frequency bias factor, in MW/0.1 Hz, for automatic generation control (AGC)
     */
    val frequencyBiasFactor: Double,

    /**
     * start effective date
     */
    val startEffectiveDate: String,

    val AdjacentCASet: String,

    /**
     * A ControlAreaCompany controls a ControlArea.
     */
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
    val areaControlMode = parse_attribute (attribute ("""HostControlArea.areaControlMode"""))_
    val endEffectiveDate = parse_element (element ("""HostControlArea.endEffectiveDate"""))_
    val freqSetPoint = parse_element (element ("""HostControlArea.freqSetPoint"""))_
    val frequencyBiasFactor = parse_element (element ("""HostControlArea.frequencyBiasFactor"""))_
    val startEffectiveDate = parse_element (element ("""HostControlArea.startEffectiveDate"""))_
    val AdjacentCASet = parse_attribute (attribute ("""HostControlArea.AdjacentCASet"""))_
    val Controls = parse_attribute (attribute ("""HostControlArea.Controls"""))_
    val RTO = parse_attribute (attribute ("""HostControlArea.RTO"""))_
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
 */
case class IndividualPnode
(

    override val sup: Pnode,

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
    val GenDistributionFactor = parse_attribute (attribute ("""IndividualPnode.GenDistributionFactor"""))_
    val LoadDistributionFactor = parse_attribute (attribute ("""IndividualPnode.LoadDistributionFactor"""))_
    val MktConnectivityNode = parse_attribute (attribute ("""IndividualPnode.MktConnectivityNode"""))_
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
 */
case class LoadAggregationPoint
(

    override val sup: AggregateNode
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
 */
case class LoadRatio
(

    override val sup: BasicElement,

    /**
     * Interval End Time
     */
    val intervalEndTime: String,

    /**
     * Interval Start Time
     */
    val intervalStartTime: String,

    /**
     * Share in percentage of total Market load for the selected time interval.
     */
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
    val intervalEndTime = parse_element (element ("""LoadRatio.intervalEndTime"""))_
    val intervalStartTime = parse_element (element ("""LoadRatio.intervalStartTime"""))_
    val share = parse_element (element ("""LoadRatio.share"""))_
    val SchedulingCoordinator = parse_attribute (attribute ("""LoadRatio.SchedulingCoordinator"""))_
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
 */
case class LoadReductionTimeCurve
(

    override val sup: Curve,

    /**
     * type of the curve: Possible values are but not limited to:
     * Max, Min,
     */
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
    val loadReductionTimeCurveType = parse_element (element ("""LoadReductionTimeCurve.loadReductionTimeCurveType"""))_
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
 */
case class LocalReliabilityArea
(

    override val sup: IdentifiedObject,

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
    val RTO = parse_attribute (attribute ("""LocalReliabilityArea.RTO"""))_
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
 */
case class MPMTestCategory
(

    override val sup: IdentifiedObject,

    /**
     * Nature of threshold data:
    'M' - Mitigation threshold
     * 'R' - Reporting threshold
     */
    val purposeFlag: String,

    /**
     * 1 - Global Price Test
    2 - Global Conduct Test
    3 - Global Impact Test
    4 - Local Price Test
    5 - Local Conduct Test
     * 6 - Local Impact Test
     */
    val testIdentifier: String,

    /**
     * The method of performing the market power monitoring.
     * Examples are Normal (default) thresholds or Alternate thresholds.
     */
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
    val purposeFlag = parse_attribute (attribute ("""MPMTestCategory.purposeFlag"""))_
    val testIdentifier = parse_attribute (attribute ("""MPMTestCategory.testIdentifier"""))_
    val testMethod = parse_attribute (attribute ("""MPMTestCategory.testMethod"""))_
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
 */
case class MPMTestThreshold
(

    override val sup: BasicElement,

    /**
     * Market Type (DAM, RTM)
     */
    val marketType: String,

    /**
     * Price Threshold in %
     */
    val percent: Double,

    /**
     * Price Threshold in $/MW
     */
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
    val marketType = parse_attribute (attribute ("""MPMTestThreshold.marketType"""))_
    val percent = parse_element (element ("""MPMTestThreshold.percent"""))_
    val price = parse_element (element ("""MPMTestThreshold.price"""))_
    val MPMTestCategory = parse_attribute (attribute ("""MPMTestThreshold.MPMTestCategory"""))_
    val RegisteredResource = parse_attributes (attribute ("""MPMTestThreshold.RegisteredResource"""))_
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
 */
case class MSSAggregation
(

    override val sup: IdentifiedObject,

    /**
     * Charge for Emission Costs, Start Up Costs, or Minimum Load Costs.
     */
    val costRecovery: String,

    /**
     * end effective date
     */
    val endEffectiveDate: String,

    /**
     * MSS Load Following may select Net vs.
     * Gross settlement.  Net Settlement requires the net Demand settled at the MSS LAP and Net Supply needs to settle at the equivalent to the weighted average price of the MSS generation.  Gross load will be settled at the System LAP and the Gross supply will be settled at the LMP.  MSS Aggregation that elects gross settlement shall have to identify if its resources are Load Following or not.
     */
    val grossSettlement: String,

    /**
     * Provides an indication if losses are to be ignored for this zone.
     * Also refered to as Exclude Marginal Losses.
     */
    val ignoreLosses: String,

    /**
     * Provides an indication if marginal losses are to be ignored for this zone.
     */
    val ignoreMarginalLosses: String,

    /**
     * Indication that this particular MSSA participates in the Load Following function.
     */
    val loadFollowing: String,

    /**
     * Indicates that RUC will be procured by the ISO or self provided.
     */
    val rucProcurement: String,

    /**
     * start effective date
     */
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
    val costRecovery = parse_attribute (attribute ("""MSSAggregation.costRecovery"""))_
    val endEffectiveDate = parse_element (element ("""MSSAggregation.endEffectiveDate"""))_
    val grossSettlement = parse_attribute (attribute ("""MSSAggregation.grossSettlement"""))_
    val ignoreLosses = parse_attribute (attribute ("""MSSAggregation.ignoreLosses"""))_
    val ignoreMarginalLosses = parse_attribute (attribute ("""MSSAggregation.ignoreMarginalLosses"""))_
    val loadFollowing = parse_attribute (attribute ("""MSSAggregation.loadFollowing"""))_
    val rucProcurement = parse_attribute (attribute ("""MSSAggregation.rucProcurement"""))_
    val startEffectiveDate = parse_element (element ("""MSSAggregation.startEffectiveDate"""))_
    val RTO = parse_attribute (attribute ("""MSSAggregation.RTO"""))_
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
 */
case class MSSZone
(

    override val sup: AggregateNode,

    /**
     * Provides an indication if losses are to be ignored for this metered subsystem zone.
     */
    val ignoreLosses: String,

    /**
     * This is the default loss factor for the Metered Sub-System (MSS) zone.
     * The actual losses are calculated during the RT market.
     */
    val lossFactor: Double,

    /**
     * Metered Sub-System (MSS) Load Following may select Net vs.
     * Gross settlement.  Net Settlement requires the net Demand settled at the Metered Sub-Sustem (MSS) Load Aggregation Point (LAP) and Net Supply needs to settle at the equivalent to the weighted average price of the MSS generation.  Gross load will be settled at the System LAP and the Gross supply will be settled at the LMP.  MSS Aggregation that elects gross settlement shall have to identify if its resources are Load Following or not.
     */
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
    val ignoreLosses = parse_attribute (attribute ("""MSSZone.ignoreLosses"""))_
    val lossFactor = parse_element (element ("""MSSZone.lossFactor"""))_
    val rucGrossSettlement = parse_attribute (attribute ("""MSSZone.rucGrossSettlement"""))_
    val MeteredSubSystem = parse_attribute (attribute ("""MSSZone.MeteredSubSystem"""))_
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
 */
case class MarketPerson
(

    override val sup: IdentifiedObject,

    /**
     * Category of this person relative to utility operations, classified according to the utility's corporate standards and practices.
     * Examples include employee, contractor, agent, not affiliated, etc.
     */
    val category: String,

    /**
     * Alternate Electronic address.
     */
    val electronicAddressAlternate: String,

    /**
     * Primary Electronic address.
     */
    val electronicAddressPrimary: String,

    /**
     * Person's first name.
     */
    val firstName: String,

    /**
     * Unique identifier for person relative to its governing authority, for example a federal tax identifier (such as a Social Security number in the United States).
     */
    val governmentID: String,

    /**
     * Landline phone number.
     */
    val landlinePhone: String,

    /**
     * Person's last (family, sir) name.
     */
    val lastName: String,

    /**
     * Middle name(s) or initial(s).
     */
    val mName: String,

    /**
     * Mobile phone number.
     */
    val mobilePhone: String,

    /**
     * A prefix or title for the person's name, such as Miss, Mister, Doctor, etc.
     */
    val prefix: String,

    /**
     * Special service needs for the person (contact) are described; examples include life support, etc.
     */
    val specialNeed: String,

    val status: String,

    /**
     * A suffix for the person's name, such as II, III, etc.
     */
    val suffix: String,

    /**
     * The user name for the person; required to log in.
     */
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
    val category = parse_element (element ("""MarketPerson.category"""))_
    val electronicAddressAlternate = parse_attribute (attribute ("""MarketPerson.electronicAddressAlternate"""))_
    val electronicAddressPrimary = parse_attribute (attribute ("""MarketPerson.electronicAddressPrimary"""))_
    val firstName = parse_element (element ("""MarketPerson.firstName"""))_
    val governmentID = parse_element (element ("""MarketPerson.governmentID"""))_
    val landlinePhone = parse_attribute (attribute ("""MarketPerson.landlinePhone"""))_
    val lastName = parse_element (element ("""MarketPerson.lastName"""))_
    val mName = parse_element (element ("""MarketPerson.mName"""))_
    val mobilePhone = parse_attribute (attribute ("""MarketPerson.mobilePhone"""))_
    val prefix = parse_element (element ("""MarketPerson.prefix"""))_
    val specialNeed = parse_element (element ("""MarketPerson.specialNeed"""))_
    val status = parse_attribute (attribute ("""MarketPerson.status"""))_
    val suffix = parse_element (element ("""MarketPerson.suffix"""))_
    val userID = parse_element (element ("""MarketPerson.userID"""))_
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
 */
case class MarketQualificationRequirement
(

    override val sup: IdentifiedObject,

    /**
     * Effective date of the privilege, terminate date of the privilege, or effective date of the application for the organization
     */
    val effectiveDate: String,

    /**
     * This is the terminate date of the application for the organization
     * The specific organization can no longer access the application as of the terminate date
     */
    val expirationDate: String,

    /**
     * Qualification identifier.
     */
    val qualificationID: String,

    /**
     * The status of the privilege.
     * Shows the status of the user�s qualification.
     */
    val status: Int,

    /**
     * This is the name of the status of the qualification and is used to display the status of the user's or organization's status.
     */
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
    val effectiveDate = parse_element (element ("""MarketQualificationRequirement.effectiveDate"""))_
    val expirationDate = parse_element (element ("""MarketQualificationRequirement.expirationDate"""))_
    val qualificationID = parse_element (element ("""MarketQualificationRequirement.qualificationID"""))_
    val status = parse_element (element ("""MarketQualificationRequirement.status"""))_
    val statusType = parse_element (element ("""MarketQualificationRequirement.statusType"""))_
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
 */
case class MarketRegion
(

    override val sup: AggregateNode
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
 */
case class MarketSkill
(

    override val sup: Document,

    /**
     * Interval between the certification and its expiry.
     */
    val certificationPeriod: String,

    /**
     * Date and time the skill became effective.
     */
    val effectiveDateTime: String,

    /**
     * Level of skill for a Craft.
     */
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
    val certificationPeriod = parse_attribute (attribute ("""MarketSkill.certificationPeriod"""))_
    val effectiveDateTime = parse_element (element ("""MarketSkill.effectiveDateTime"""))_
    val level = parse_element (element ("""MarketSkill.level"""))_
    val MarketPerson = parse_attribute (attribute ("""MarketSkill.MarketPerson"""))_
    val MarketQualificationRequirements = parse_attributes (attribute ("""MarketSkill.MarketQualificationRequirements"""))_
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
 */
case class MaxStartUpCostCurve
(

    override val sup: Curve
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
 */
case class MeteredSubSystem
(

    override val sup: IdentifiedObject,

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
    val MSSAggregation = parse_attribute (attribute ("""MeteredSubSystem.MSSAggregation"""))_
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
 */
case class MktCombinedCyclePlant
(

    override val sup: CombinedCyclePlant,

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
    val AggregatedPnode = parse_attribute (attribute ("""MktCombinedCyclePlant.AggregatedPnode"""))_
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
 */
case class MktConductingEquipment
(

    override val sup: ConductingEquipment
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
 */
case class MktContingency
(

    override val sup: Contingency,

    /**
     * load change flag
     * Flag that indicates whether load rollover and load pickup should be processed for this contingency
     */
    val loadRolloverFlag: Boolean,

    /**
     * ltc enable flag
     * Flag that indicates if LTCs regulate voltage during the solution of the contingency
     */
    val ltcControlFlag: Boolean,

    /**
     * Participation Factor flag
     * An indication which set of generator participation factors should be used to re-allocate generation in this contingency
     */
    val participationFactorSet: String,

    /**
     * sceening flag for outage
     * Flag that indicated whether screening is bypassed for the contingency
     */
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
    val loadRolloverFlag = parse_element (element ("""MktContingency.loadRolloverFlag"""))_
    val ltcControlFlag = parse_element (element ("""MktContingency.ltcControlFlag"""))_
    val participationFactorSet = parse_element (element ("""MktContingency.participationFactorSet"""))_
    val screeningFlag = parse_element (element ("""MktContingency.screeningFlag"""))_
    val TransferInterfaceSolutionA = parse_attribute (attribute ("""MktContingency.TransferInterfaceSolutionA"""))_
    val TransferInterfaceSolutionB = parse_attribute (attribute ("""MktContingency.TransferInterfaceSolutionB"""))_
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
 */
case class MktHeatRateCurve
(

    override val sup: HeatRateCurve,

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
    val RegisteredGenerator = parse_attribute (attribute ("""MktHeatRateCurve.RegisteredGenerator"""))_
    val ResourceVerifiableCosts = parse_attribute (attribute ("""MktHeatRateCurve.ResourceVerifiableCosts"""))_
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
 */
case class MktThermalGeneratingUnit
(

    override val sup: ThermalGeneratingUnit
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
 */
case class OilPrice
(

    override val sup: BasicElement,

    /**
     * The average oil price at a defined fuel region.
     */
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
    val oilPriceIndex = parse_element (element ("""OilPrice.oilPriceIndex"""))_
    val FuelRegion = parse_attribute (attribute ("""OilPrice.FuelRegion"""))_
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
 */
case class OrgPnodeAllocation
(

    override val sup: IdentifiedObject,

    /**
     * end effective date
     */
    val endEffectiveDate: String,

    /**
     * Maximum MW for the Source/Sink for the Allocation
     */
    val maxMWAllocation: Double,

    /**
     * start effective date
     */
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
    val endEffectiveDate = parse_element (element ("""OrgPnodeAllocation.endEffectiveDate"""))_
    val maxMWAllocation = parse_element (element ("""OrgPnodeAllocation.maxMWAllocation"""))_
    val startEffectiveDate = parse_element (element ("""OrgPnodeAllocation.startEffectiveDate"""))_
    val MktOrganisation = parse_attribute (attribute ("""OrgPnodeAllocation.MktOrganisation"""))_
    val Pnode = parse_attribute (attribute ("""OrgPnodeAllocation.Pnode"""))_
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
 */
case class OrgResOwnership
(

    override val sup: IdentifiedObject,

    /**
     * association type for the association between Organisation and Resource:
     */
    val asscType: String,

    /**
     * end effective date
     */
    val endEffectiveDate: String,

    /**
     * Flag to indicate that the SC representing the Resource is the Master SC.
     */
    val masterSchedulingCoordinatorFlag: String,

    /**
     * ownership percentage for each resource
     */
    val ownershipPercent: Double,

    /**
     * start effective date
     */
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
    val asscType = parse_attribute (attribute ("""OrgResOwnership.asscType"""))_
    val endEffectiveDate = parse_element (element ("""OrgResOwnership.endEffectiveDate"""))_
    val masterSchedulingCoordinatorFlag = parse_attribute (attribute ("""OrgResOwnership.masterSchedulingCoordinatorFlag"""))_
    val ownershipPercent = parse_element (element ("""OrgResOwnership.ownershipPercent"""))_
    val startEffectiveDate = parse_element (element ("""OrgResOwnership.startEffectiveDate"""))_
    val MktOrganisation = parse_attribute (attribute ("""OrgResOwnership.MktOrganisation"""))_
    val RegisteredResource = parse_attribute (attribute ("""OrgResOwnership.RegisteredResource"""))_
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
 */
case class Pnode
(

    override val sup: IdentifiedObject,

    /**
     * End effective date of the period in which the price node definition is valid.
     */
    val endEffectiveDate: String,

    /**
     * If true, this Pnode is public (prices are published for DA/RT and FTR markets), otherwise it is private (location is not usable by market for bidding/FTRs/transactions).
     */
    val isPublic: Boolean,

    /**
     * Start effective date of the period in which the price node definition is valid.
     */
    val startEffectiveDate: String,

    /**
     * Pnode type
     */
    val typ: String,

    /**
     * Price node usage: 
    'Control Area'
    'Regulation Region'
    'Price Zone'
    'Spin Region'
    'Non-Spin Region'
     * 'Price Hub'
     */
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
    val endEffectiveDate = parse_element (element ("""Pnode.endEffectiveDate"""))_
    val isPublic = parse_element (element ("""Pnode.isPublic"""))_
    val startEffectiveDate = parse_element (element ("""Pnode.startEffectiveDate"""))_
    val typ = parse_element (element ("""Pnode.type"""))_
    val usage = parse_element (element ("""Pnode.usage"""))_
    val RTO = parse_attribute (attribute ("""Pnode.RTO"""))_
    val SinkCRRSegment = parse_attributes (attribute ("""Pnode.SinkCRRSegment"""))_
    val SourceCRRSegment = parse_attributes (attribute ("""Pnode.SourceCRRSegment"""))_
    val SubControlArea = parse_attribute (attribute ("""Pnode.SubControlArea"""))_
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
 */
case class PnodeDistributionFactor
(

    override val sup: BasicElement,

    /**
     * Used to calculate "participation" of Pnode in an AggregatePnode.
     * For example, for regulation region this factor is 1 and total sum of all factors for a specific regulation region does not have to be 1. For pricing zone the total sum of all factors has to be 1.
     */
    val factor: Double,

    /**
     * Indication that this distribution factor is to apply during off peak.
     */
    val offPeak: String,

    /**
     * Indication that this factor is to apply during Peak periods.
     */
    val onPeak: String,

    /**
     * Point of delivery loss factor
     */
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
    val factor = parse_element (element ("""PnodeDistributionFactor.factor"""))_
    val offPeak = parse_attribute (attribute ("""PnodeDistributionFactor.offPeak"""))_
    val onPeak = parse_attribute (attribute ("""PnodeDistributionFactor.onPeak"""))_
    val podLossFactor = parse_element (element ("""PnodeDistributionFactor.podLossFactor"""))_
    val BidDistributionFactor = parse_attribute (attribute ("""PnodeDistributionFactor.BidDistributionFactor"""))_
    val IndividualPnode = parse_attribute (attribute ("""PnodeDistributionFactor.IndividualPnode"""))_
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
 */
case class RMRHeatRateCurve
(

    override val sup: Curve,

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
    val RegisteredGenerator = parse_attribute (attribute ("""RMRHeatRateCurve.RegisteredGenerator"""))_
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
 */
case class RMRStartUpCostCurve
(

    override val sup: Curve,

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
    val RegisteredGenerator = parse_attribute (attribute ("""RMRStartUpCostCurve.RegisteredGenerator"""))_
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
 */
case class RMRStartUpEnergyCurve
(

    override val sup: Curve,

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
    val RegisteredGenerator = parse_attribute (attribute ("""RMRStartUpEnergyCurve.RegisteredGenerator"""))_
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
 */
case class RMRStartUpFuelCurve
(

    override val sup: Curve,

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
    val RegisteredGenerator = parse_attribute (attribute ("""RMRStartUpFuelCurve.RegisteredGenerator"""))_
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
 */
case class RMRStartUpTimeCurve
(

    override val sup: Curve,

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
    val RegisteredGenerator = parse_attribute (attribute ("""RMRStartUpTimeCurve.RegisteredGenerator"""))_
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
 */
case class RTO
(

    override val sup: MktOrganisation
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
 */
case class RUCZone
(

    override val sup: AggregateNode
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
 */
case class RegisteredGenerator
(

    override val sup: RegisteredResource,

    /**
     * Capacity Factor
     */
    val capacityFactor: Double,

    /**
     * Cold start time.
     */
    val coldStartTime: Double,

    /**
     * Name of the Combined Cycle Plant (valid for Combined Cyle modes or configurations)
     */
    val combinedCyclePlantName: String,

    val commericialOperationDate: String,

    /**
     * Constrained Output Generator (COG) Indicator (Yes/No), per Generating Resource
     */
    val constrainedOutputFlag: String,

    val costBasis: String,

    /**
     * Some long-start up time units may need to receive start up instruction before DA market results are available.
     * Long-Start resources may be either physical resources within the control with start-up times greater than 18 hours or the long-start contractual inter-tie commitment that shall be completed by 6 am one-day ahead.  Therefore, there is a need for a process to determine the commitment of such resources before the DA market.
     */
    val extremeLongStart: String,

    /**
     * Values: Natural Gas Based Resource, Non Natural Gas Based Resource
    "NG" - Natural-Gas-Based Resource - a Resource that is powered by Natural Gas
     * "NNG" - Non-Natural-Gas-Based Resource - a Resouce that is powered by some other fuel than Natural Gas
     */
    val fuelSource: String,

    /**
     * High limit for secondary (AGC) control
     */
    val highControlLimit: Double,

    /**
     * Hot-to-intermediate time (Seasonal)
     */
    val hotIntTime: Double,

    /**
     * Hot start time.
     */
    val hotStartTime: Double,

    /**
     * Intermediate-to-cold time (Seasonal)
     */
    val intColdTime: Double,

    /**
     * Intermediate start time.
     */
    val intStartTime: Double,

    /**
     * Provides an indication that this resource is intending to participate in the intermittent resource program.
     */
    val intendedPIRP: String,

    /**
     * Certifies resources for use in MSS Load Following Down
     */
    val loadFollowingDownMSS: String,

    /**
     * Certifies resources for use in MSS Load Following Up
     */
    val loadFollowingUpMSS: String,

    /**
     * Low limit for secondary (AGC) control
     */
    val lowControlLImit: Double,

    /**
     * Regulation down response rate in MW per minute
     */
    val lowerControlRate: Double,

    val lowerRampRate: Double,

    /**
     * Maximum Dependable Capacity (MNDC).
     */
    val maxDependableCap: Double,

    val maxLayOffSelfSchedQty: Double,

    /**
     * The registered maximum Minimum Load Cost of a Generating Resource registered with a Cost Basis of "Bid Cost".
     */
    val maxMinLoadCost: Double,

    /**
     * max pumping level of a hydro pump unit
     */
    val maxPumpingLevel: Double,

    /**
     * Maximum time this device can be shut down.
     */
    val maxShutdownTime: String,

    /**
     * maximum start ups per day
     */
    val maxStartUpsPerDay: Int,

    /**
     * Maximum weekly Energy (Seasonal)
     */
    val maxWeeklyEnergy: Double,

    /**
     * Maximum weekly starts (seasonal parameter)
     */
    val maxWeeklyStarts: Int,

    /**
     * Maximum allowable spinning reserve.
     * Spinning reserve will never be considered greater than this value regardless of the current operating point.
     */
    val maximumAllowableSpinningReserve: Double,

    /**
     * This is the maximum operating MW limit the dispatcher can enter for this unit
     */
    val maximumOperatingMW: Double,

    /**
     * minimum load cost.
     * Value is (currency/hr)
     */
    val minLoadCost: Double,

    /**
     * The cost for the fuel required to get a Generating Resource to operate at the minimum load level
     */
    val minimumLoadFuelCost: String,

    /**
     * This is the minimum operating MW limit the dispatcher can enter for this unit.
     */
    val minimumOperatingMW: Double,

    /**
     * Flag to indicate that this unit is a resource adequacy resource and must offer.
     */
    val mustOfferRA: String,

    /**
     * MW value stated on the nameplate of the Generator -- the value it potentially could provide.
     */
    val nameplateCapacity: Double,

    /**
     * The portion of the Operating Cost of a Generating Resource that is not related to fuel cost.
     */
    val operatingMaintenanceCost: Double,

    /**
     * Combined Cycle operating mode.
     */
    val operatingMode: String,

    val proxyFlag: String,

    /**
     * The minimum down time for the pump in a pump storage unit.
     */
    val pumpMinDownTime: Double,

    /**
     * The minimum up time aspect for the pump in a pump storage unit
     */
    val pumpMinUpTime: Double,

    /**
     * The cost to shutdown a pump during the pump aspect of a pump storage unit.
     */
    val pumpShutdownCost: Double,

    /**
     * The shutdown time (minutes) of the pump aspect of a pump storage unit.
     */
    val pumpShutdownTime: Int,

    val pumpingCost: Double,

    /**
     * Pumping factor for pump storage units, conversion factor between generating and pumping.
     */
    val pumpingFactor: Double,

    val qualifyingFacilityOwner: String,

    /**
     * Quick start flag (Yes/No)
     */
    val quickStartFlag: String,

    /**
     * Regulation up response rate in MW per minute
     */
    val raiseControlRate: Double,

    val raiseRampRate: Double,

    /**
     * Ramp curve type:
    0 - Fixed ramp rate independent of rate function unit MW output
    1 - Static ramp rates as a function of unit MW output only
     * 2 - Dynamic ramp rates as a function of unit MW output and ramping time
     */
    val rampCurveType: String,

    /**
     * Ramping mode
    0: ignore ramping limits
    1: 20-minute ramping rule
     * 2: 60-minute ramping rule
     */
    val rampMode: String,

    /**
     * 0 = Unit is not on regulation
    1 = Unit is on AGC and regulating
     * 2 = Unit is suppose to be on regulation but it is not under regulation now
     */
    val regulationFlag: Int,

    /**
     * For the outage scheduling services
     */
    val regulationRampRate: Double,

    /**
     * CCGT90	Combined Cycle greater than 90 MW
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
     * PS         Pumped Storage
     */
    val resourceSubType: String,

    /**
     * River System the Resource is tied to.
     */
    val riverSystem: String,

    val spinReserveRamp: Double,

    /**
     * Is the Resource Synchronous Condenser capable Resource?
     */
    val syncCondCapable: String,

    /**
     * Generating unit type: Combined Cycle, Gas Turbine, Hydro Turbine, Other, Photovoltaic, Hydro Pump-Turbine, Reciprocating Engine, Steam Turbine, Synchronous Condenser, Wind Turbine
     */
    val unitType: String,

    /**
     * Use limit flag: indicates if the use-limited resource is fully scheduled (or has some slack for real-time dispatch) (Y/N)
     */
    val useLimitFlag: String,

    val EnergyPriceIndex: String,

    val FuelCostCurve: String,

    val FuelRegion: String,

    val LocalReliabilityArea: String,

    val MktHeatRateCurve: String,

    /**
     * Reliability must not run (RMNR) flag: indicated whether the RMR unit is set as an RMNR in the current market
     */
    val RMNRFlag: String,

    /**
     * Reliability must run (RMR) flag: indicates whether the unit is RMR; Indicates whether the unit is RMR:
    N' - not an RMR unit
    '1' - RMR Condition 1 unit
     * '2' - RMR Condition 2 unit
     */
    val RMRFlag: String,

    val RMRHeatRateCurve: String,

    /**
     * Indicates the RMR Manual pre-determination status [Y/N]
     */
    val RMRManualIndicator: String,

    val RMRStartUpCostCurve: String,

    val RMRStartUpEnergyCurve: String,

    val RMRStartUpFuelCurve: String,

    val RMRStartUpTimeCurve: String,

    /**
     * Reliability must take (RMT) flag (Yes/No): indicates whether the unit is RMT
     */
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
    val capacityFactor = parse_element (element ("""RegisteredGenerator.capacityFactor"""))_
    val coldStartTime = parse_element (element ("""RegisteredGenerator.coldStartTime"""))_
    val combinedCyclePlantName = parse_element (element ("""RegisteredGenerator.combinedCyclePlantName"""))_
    val commericialOperationDate = parse_element (element ("""RegisteredGenerator.commericialOperationDate"""))_
    val constrainedOutputFlag = parse_attribute (attribute ("""RegisteredGenerator.constrainedOutputFlag"""))_
    val costBasis = parse_attribute (attribute ("""RegisteredGenerator.costBasis"""))_
    val extremeLongStart = parse_attribute (attribute ("""RegisteredGenerator.extremeLongStart"""))_
    val fuelSource = parse_attribute (attribute ("""RegisteredGenerator.fuelSource"""))_
    val highControlLimit = parse_element (element ("""RegisteredGenerator.highControlLimit"""))_
    val hotIntTime = parse_element (element ("""RegisteredGenerator.hotIntTime"""))_
    val hotStartTime = parse_element (element ("""RegisteredGenerator.hotStartTime"""))_
    val intColdTime = parse_element (element ("""RegisteredGenerator.intColdTime"""))_
    val intStartTime = parse_element (element ("""RegisteredGenerator.intStartTime"""))_
    val intendedPIRP = parse_attribute (attribute ("""RegisteredGenerator.intendedPIRP"""))_
    val loadFollowingDownMSS = parse_attribute (attribute ("""RegisteredGenerator.loadFollowingDownMSS"""))_
    val loadFollowingUpMSS = parse_attribute (attribute ("""RegisteredGenerator.loadFollowingUpMSS"""))_
    val lowControlLImit = parse_element (element ("""RegisteredGenerator.lowControlLImit"""))_
    val lowerControlRate = parse_element (element ("""RegisteredGenerator.lowerControlRate"""))_
    val lowerRampRate = parse_element (element ("""RegisteredGenerator.lowerRampRate"""))_
    val maxDependableCap = parse_element (element ("""RegisteredGenerator.maxDependableCap"""))_
    val maxLayOffSelfSchedQty = parse_element (element ("""RegisteredGenerator.maxLayOffSelfSchedQty"""))_
    val maxMinLoadCost = parse_element (element ("""RegisteredGenerator.maxMinLoadCost"""))_
    val maxPumpingLevel = parse_element (element ("""RegisteredGenerator.maxPumpingLevel"""))_
    val maxShutdownTime = parse_element (element ("""RegisteredGenerator.maxShutdownTime"""))_
    val maxStartUpsPerDay = parse_element (element ("""RegisteredGenerator.maxStartUpsPerDay"""))_
    val maxWeeklyEnergy = parse_element (element ("""RegisteredGenerator.maxWeeklyEnergy"""))_
    val maxWeeklyStarts = parse_element (element ("""RegisteredGenerator.maxWeeklyStarts"""))_
    val maximumAllowableSpinningReserve = parse_element (element ("""RegisteredGenerator.maximumAllowableSpinningReserve"""))_
    val maximumOperatingMW = parse_element (element ("""RegisteredGenerator.maximumOperatingMW"""))_
    val minLoadCost = parse_element (element ("""RegisteredGenerator.minLoadCost"""))_
    val minimumLoadFuelCost = parse_attribute (attribute ("""RegisteredGenerator.minimumLoadFuelCost"""))_
    val minimumOperatingMW = parse_element (element ("""RegisteredGenerator.minimumOperatingMW"""))_
    val mustOfferRA = parse_attribute (attribute ("""RegisteredGenerator.mustOfferRA"""))_
    val nameplateCapacity = parse_element (element ("""RegisteredGenerator.nameplateCapacity"""))_
    val operatingMaintenanceCost = parse_element (element ("""RegisteredGenerator.operatingMaintenanceCost"""))_
    val operatingMode = parse_element (element ("""RegisteredGenerator.operatingMode"""))_
    val proxyFlag = parse_attribute (attribute ("""RegisteredGenerator.proxyFlag"""))_
    val pumpMinDownTime = parse_element (element ("""RegisteredGenerator.pumpMinDownTime"""))_
    val pumpMinUpTime = parse_element (element ("""RegisteredGenerator.pumpMinUpTime"""))_
    val pumpShutdownCost = parse_element (element ("""RegisteredGenerator.pumpShutdownCost"""))_
    val pumpShutdownTime = parse_element (element ("""RegisteredGenerator.pumpShutdownTime"""))_
    val pumpingCost = parse_element (element ("""RegisteredGenerator.pumpingCost"""))_
    val pumpingFactor = parse_element (element ("""RegisteredGenerator.pumpingFactor"""))_
    val qualifyingFacilityOwner = parse_element (element ("""RegisteredGenerator.qualifyingFacilityOwner"""))_
    val quickStartFlag = parse_attribute (attribute ("""RegisteredGenerator.quickStartFlag"""))_
    val raiseControlRate = parse_element (element ("""RegisteredGenerator.raiseControlRate"""))_
    val raiseRampRate = parse_element (element ("""RegisteredGenerator.raiseRampRate"""))_
    val rampCurveType = parse_attribute (attribute ("""RegisteredGenerator.rampCurveType"""))_
    val rampMode = parse_attribute (attribute ("""RegisteredGenerator.rampMode"""))_
    val regulationFlag = parse_element (element ("""RegisteredGenerator.regulationFlag"""))_
    val regulationRampRate = parse_element (element ("""RegisteredGenerator.regulationRampRate"""))_
    val resourceSubType = parse_element (element ("""RegisteredGenerator.resourceSubType"""))_
    val riverSystem = parse_element (element ("""RegisteredGenerator.riverSystem"""))_
    val spinReserveRamp = parse_element (element ("""RegisteredGenerator.spinReserveRamp"""))_
    val syncCondCapable = parse_attribute (attribute ("""RegisteredGenerator.syncCondCapable"""))_
    val unitType = parse_attribute (attribute ("""RegisteredGenerator.unitType"""))_
    val useLimitFlag = parse_attribute (attribute ("""RegisteredGenerator.useLimitFlag"""))_
    val EnergyPriceIndex = parse_attribute (attribute ("""RegisteredGenerator.EnergyPriceIndex"""))_
    val FuelCostCurve = parse_attribute (attribute ("""RegisteredGenerator.FuelCostCurve"""))_
    val FuelRegion = parse_attribute (attribute ("""RegisteredGenerator.FuelRegion"""))_
    val LocalReliabilityArea = parse_attribute (attribute ("""RegisteredGenerator.LocalReliabilityArea"""))_
    val MktHeatRateCurve = parse_attribute (attribute ("""RegisteredGenerator.MktHeatRateCurve"""))_
    val RMNRFlag = parse_attribute (attribute ("""RegisteredGenerator.RMNRFlag"""))_
    val RMRFlag = parse_attribute (attribute ("""RegisteredGenerator.RMRFlag"""))_
    val RMRHeatRateCurve = parse_attribute (attribute ("""RegisteredGenerator.RMRHeatRateCurve"""))_
    val RMRManualIndicator = parse_attribute (attribute ("""RegisteredGenerator.RMRManualIndicator"""))_
    val RMRStartUpCostCurve = parse_attribute (attribute ("""RegisteredGenerator.RMRStartUpCostCurve"""))_
    val RMRStartUpEnergyCurve = parse_attribute (attribute ("""RegisteredGenerator.RMRStartUpEnergyCurve"""))_
    val RMRStartUpFuelCurve = parse_attribute (attribute ("""RegisteredGenerator.RMRStartUpFuelCurve"""))_
    val RMRStartUpTimeCurve = parse_attribute (attribute ("""RegisteredGenerator.RMRStartUpTimeCurve"""))_
    val RMTFlag = parse_attribute (attribute ("""RegisteredGenerator.RMTFlag"""))_
    val RegulatingLimit = parse_attribute (attribute ("""RegisteredGenerator.RegulatingLimit"""))_
    val StartUpEnergyCurve = parse_attribute (attribute ("""RegisteredGenerator.StartUpEnergyCurve"""))_
    val StartUpFuelCurve = parse_attribute (attribute ("""RegisteredGenerator.StartUpFuelCurve"""))_
    val StartUpTimeCurve = parse_attribute (attribute ("""RegisteredGenerator.StartUpTimeCurve"""))_
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
 */
case class RegisteredInterTie
(

    override val sup: RegisteredResource,

    /**
     * indicate the direction (export/import) of an intertie resource
     */
    val direction: String,

    /**
     * Under each major product type, the commodity type can be applied to further specify the type.
     */
    val energyProductType: String,

    /**
     * Flag to indicated whether this Inter-tie is a DC Tie.
     */
    val isDCTie: String,

    /**
     * check if the inter-tie resource is registered for the dynamic interchange..
     */
    val isDynamicInterchange: String,

    /**
     * The registered upper bound of minimum hourly block for an Inter-Tie Resource
     */
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
    val direction = parse_attribute (attribute ("""RegisteredInterTie.direction"""))_
    val energyProductType = parse_attribute (attribute ("""RegisteredInterTie.energyProductType"""))_
    val isDCTie = parse_attribute (attribute ("""RegisteredInterTie.isDCTie"""))_
    val isDynamicInterchange = parse_attribute (attribute ("""RegisteredInterTie.isDynamicInterchange"""))_
    val minHourlyBlockLimit = parse_element (element ("""RegisteredInterTie.minHourlyBlockLimit"""))_
    val Flowgate = parse_attribute (attribute ("""RegisteredInterTie.Flowgate"""))_
    val InterTieBid = parse_attribute (attribute ("""RegisteredInterTie.InterTieBid"""))_
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
 */
case class RegisteredLoad
(

    override val sup: RegisteredResource,

    /**
     * Flag to indicate that the Resource is Block Load pseudo resource (&lsquo;Y&rsquo;, &lsquo; N&rsquo;)
     */
    val blockLoadTransferFlag: String,

    /**
     * Flag to indicate that a Load Resource is part of a DSR Load
     */
    val dynamicallyScheduledLoadResourceFlag: String,

    /**
     * Qualification status (used for DSR qualification)
     */
    val dynamicallyScheduledQualificationFlag: String,

    /**
     * Non-participating load registry as a MSS load
     */
    val loadRegistryMSS: String,

    /**
     * Maximum Base Load (MW), per Participating Load Resource
     */
    val maxBaseLoad: Double,

    /**
     * Maximum Deployment time (seconds)
     */
    val maxDeploymentTime: Double,

    /**
     * Maximum Number of Daily Load Curtailments
     */
    val maxLoadRedTimesPerDay: Int,

    /**
     * maximum load reduction
     */
    val maxLoadReduction: Double,

    /**
     * Maxiimum Load Reduction Time (min), per Participating Load Resource
     */
    val maxReductionTime: Double,

    /**
     * Maximum weekly deployments
     */
    val maxWeeklyDeployment: Int,

    /**
     * Minimum MW for a load reduction (e.g., MW rating of a discrete pump.
     * This attribute may be used also in the LoadBid class. The reason that the attribute is also modeled in this class is that it is resource attribute and needs to be persistently stored.
     */
    val minLoadReduction: Double,

    /**
     * minimum load reduction cost.
     * Single number for the load
     */
    val minLoadReductionCost: Double,

    /**
     * Shortest period load reduction shall be maintained before load can be restored to normal levels.
     * This attribute may be used also in the LoadBid class. The reason that the attribute is also modeled in this class is that it is resource attribute and needs to be persistently stored.
     */
    val minLoadReductionInterval: Double,

    /**
     * Minimum Load Reduction Time (min), per Participating Load Resource
     */
    val minReductionTime: Double,

    /**
     * Shortest time that load shall be left at normal levels before a new load reduction.
     * This attribute may be used also in the LoadBid class. The reason that the attribute is also modeled in this class is that it is resource attribute and needs to be persistently stored.
     */
    val minTimeBetLoadRed: Double,

    /**
     * Participating Load flag: indicates whether the load resource is participates in load reduction actions.
     */
    val participatingLoad: String,

    /**
     * Time period that is required from an order to reduce a load to the time that it takes to get to the minimum load reduction.
     * This attribute may be used also in the LoadBid class. The reason that the attribute is also modeled in this class is that it is resource attribute and needs to be persistently stored.
     */
    val reqNoticeTime: Double,

    /**
     * CLR	Controllable Load
     * NCLR	Non-Controllable Load
     */
    val resourceSubType: String,

    val LoadReductionPriceCurve: List[String],

    val LoadReductionTimeCurve: List[String],

    val MktLoadArea: String,

    /**
     * A Non-Participating Load Resource aggregation scheme with resource-specific Distribution Factors that are submitted with the Bid and for which the distributed Energy is settled at the relevant Distribution Location marginal prices.
     */
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
    val blockLoadTransferFlag = parse_attribute (attribute ("""RegisteredLoad.blockLoadTransferFlag"""))_
    val dynamicallyScheduledLoadResourceFlag = parse_attribute (attribute ("""RegisteredLoad.dynamicallyScheduledLoadResourceFlag"""))_
    val dynamicallyScheduledQualificationFlag = parse_attribute (attribute ("""RegisteredLoad.dynamicallyScheduledQualificationFlag"""))_
    val loadRegistryMSS = parse_attribute (attribute ("""RegisteredLoad.loadRegistryMSS"""))_
    val maxBaseLoad = parse_element (element ("""RegisteredLoad.maxBaseLoad"""))_
    val maxDeploymentTime = parse_element (element ("""RegisteredLoad.maxDeploymentTime"""))_
    val maxLoadRedTimesPerDay = parse_element (element ("""RegisteredLoad.maxLoadRedTimesPerDay"""))_
    val maxLoadReduction = parse_element (element ("""RegisteredLoad.maxLoadReduction"""))_
    val maxReductionTime = parse_element (element ("""RegisteredLoad.maxReductionTime"""))_
    val maxWeeklyDeployment = parse_element (element ("""RegisteredLoad.maxWeeklyDeployment"""))_
    val minLoadReduction = parse_element (element ("""RegisteredLoad.minLoadReduction"""))_
    val minLoadReductionCost = parse_element (element ("""RegisteredLoad.minLoadReductionCost"""))_
    val minLoadReductionInterval = parse_element (element ("""RegisteredLoad.minLoadReductionInterval"""))_
    val minReductionTime = parse_element (element ("""RegisteredLoad.minReductionTime"""))_
    val minTimeBetLoadRed = parse_element (element ("""RegisteredLoad.minTimeBetLoadRed"""))_
    val participatingLoad = parse_attribute (attribute ("""RegisteredLoad.participatingLoad"""))_
    val reqNoticeTime = parse_element (element ("""RegisteredLoad.reqNoticeTime"""))_
    val resourceSubType = parse_element (element ("""RegisteredLoad.resourceSubType"""))_
    val LoadReductionPriceCurve = parse_attributes (attribute ("""RegisteredLoad.LoadReductionPriceCurve"""))_
    val LoadReductionTimeCurve = parse_attributes (attribute ("""RegisteredLoad.LoadReductionTimeCurve"""))_
    val MktLoadArea = parse_attribute (attribute ("""RegisteredLoad.MktLoadArea"""))_
    val NPLCustomLoadAggregation = parse_attribute (attribute ("""RegisteredLoad.NPLCustomLoadAggregation"""))_
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
 */
case class RegulatingLimit
(

    override val sup: IdentifiedObject,

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
    val highLimit = parse_element (element ("""RegulatingLimit.highLimit"""))_
    val lowLimit = parse_element (element ("""RegulatingLimit.lowLimit"""))_
    val RegisteredGenerator = parse_attribute (attribute ("""RegulatingLimit.RegisteredGenerator"""))_
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
 */
case class ResourceAncillaryServiceQualification
(

    override val sup: BasicElement,

    /**
     * Certified capacity for associated resource and market type and ancillary service type product
     */
    val certifiedCapacity: Double,

    /**
     * Ancillary Service Qualification end date
     */
    val endEffectiveDate: String,

    /**
     * market type
     */
    val market: String,

    /**
     * Status of the qualification ('Y' = Active, 'N' = Inactive)
     */
    val qualificationFlag: String,

    /**
     * Ancillary Service Qualification effective from date
     */
    val startEffectiveDate: String,

    /**
     * Type of service based on ResourceAncillaryServiceType enumeration
     */
    val typ: String,

    /**
     * RegisteredResources are qualified for resource ancillary service types (which include market product types as well as other types such as BlackStart) by the association to the class ResourceAncillaryServiceQualification.
     */
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
    val certifiedCapacity = parse_element (element ("""ResourceAncillaryServiceQualification.certifiedCapacity"""))_
    val endEffectiveDate = parse_element (element ("""ResourceAncillaryServiceQualification.endEffectiveDate"""))_
    val market = parse_attribute (attribute ("""ResourceAncillaryServiceQualification.market"""))_
    val qualificationFlag = parse_attribute (attribute ("""ResourceAncillaryServiceQualification.qualificationFlag"""))_
    val startEffectiveDate = parse_element (element ("""ResourceAncillaryServiceQualification.startEffectiveDate"""))_
    val typ = parse_attribute (attribute ("""ResourceAncillaryServiceQualification.type"""))_
    val RegisteredResource = parse_attribute (attribute ("""ResourceAncillaryServiceQualification.RegisteredResource"""))_
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
 */
case class ResourceCapacity
(

    override val sup: BasicElement,

    /**
     * capacity type
    
    The types are but not limited to:
    
    Regulation Up
    Regulation Dn
    Spinning Reserve
    Non-Spinning Reserve
    FOO capacity
     * MOO capacity
     */
    val capacityType: String,

    /**
     * default capacity
     */
    val defaultCapacity: Double,

    /**
     * maximum capacity
     */
    val maximumCapacity: Double,

    /**
     * minimum capacity
     */
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
    val capacityType = parse_attribute (attribute ("""ResourceCapacity.capacityType"""))_
    val defaultCapacity = parse_element (element ("""ResourceCapacity.defaultCapacity"""))_
    val maximumCapacity = parse_element (element ("""ResourceCapacity.maximumCapacity"""))_
    val minimumCapacity = parse_element (element ("""ResourceCapacity.minimumCapacity"""))_
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
 */
case class ResourceOperationMaintenanceCost
(

    override val sup: Curve,

    /**
     * Percentage of Fuel Index Price (gas) for operating above Low Sustained Limit (LSL)
     */
    val gasPercentAboveLowSustainedLimit: Double,

    /**
     * Percentage of Fuel Oil Price (FOP) for operating above Low Sustained Limit (LSL)
     */
    val oilPercentAboveLowSustainedLimit: Double,

    /**
     * Verifiable O&amp;M Cost ($), Cold Startup
     */
    val omCostColdStartup: Double,

    /**
     * Verifiable O&amp;M Cost ($), Hot Startup
     */
    val omCostHotStartup: Double,

    /**
     * Verifiable O&amp;M Cost ($), Intermediate Startup
     */
    val omCostIntermediateStartup: Double,

    /**
     * Verifiable O&amp;M Cost ($/MWh), LSL
     */
    val omCostLowSustainedLimit: Double,

    /**
     * Percentage of Solid Fuel for operating above Low Sustained Limit (LSL)
     */
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
    val gasPercentAboveLowSustainedLimit = parse_element (element ("""ResourceOperationMaintenanceCost.gasPercentAboveLowSustainedLimit"""))_
    val oilPercentAboveLowSustainedLimit = parse_element (element ("""ResourceOperationMaintenanceCost.oilPercentAboveLowSustainedLimit"""))_
    val omCostColdStartup = parse_element (element ("""ResourceOperationMaintenanceCost.omCostColdStartup"""))_
    val omCostHotStartup = parse_element (element ("""ResourceOperationMaintenanceCost.omCostHotStartup"""))_
    val omCostIntermediateStartup = parse_element (element ("""ResourceOperationMaintenanceCost.omCostIntermediateStartup"""))_
    val omCostLowSustainedLimit = parse_element (element ("""ResourceOperationMaintenanceCost.omCostLowSustainedLimit"""))_
    val solidfuelPercentAboveLowSustainedLimit = parse_element (element ("""ResourceOperationMaintenanceCost.solidfuelPercentAboveLowSustainedLimit"""))_
    val ResourceVerifiableCosts = parse_attribute (attribute ("""ResourceOperationMaintenanceCost.ResourceVerifiableCosts"""))_
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
 */
case class ResourceStartupCost
(

    override val sup: BasicElement,

    /**
     * Verifiable Cold Start Up Fuel (MMBtu per start)
     */
    val fuelColdStartup: Double,

    /**
     * Verifiable Hot Start Up Fuel (MMBtu per start)
     */
    val fuelHotStartup: Double,

    /**
     * Verifiable Intermediate Start Up Fuel (MMBtu per start)
     */
    val fuelIntermediateStartup: Double,

    /**
     * Minimum-Energy fuel, MMBtu/MWh
     */
    val fuelLowSustainedLimit: Double,

    /**
     * Percentage of Fuel Index Price (gas) for cold startup
     */
    val gasPercentColdStartup: Double,

    /**
     * Percentage of Fuel Index Price (gas) for hot startup
     */
    val gasPercentHotStartup: Double,

    /**
     * Percentage of Fuel Index Price (gas) for intermediate startup
     */
    val gasPercentIntermediateStartup: Double,

    /**
     * Percentage of FIP (gas) for operating at LSL
     */
    val gasPercentLowSustainedLimit: Double,

    /**
     * Percentage of Fuel Oil Price (FOP) for cold startup
     */
    val oilPercentColdStartup: Double,

    /**
     * Percentage of Fuel Oil Price (FOP) for hot startup
     */
    val oilPercentHotStartup: Double,

    /**
     * Percentage of Fuel Oil Price (FOP) for intermediate startup
     */
    val oilPercentIntermediateStartup: Double,

    /**
     * Percentage of FOP (oil) for operating at LSL
     */
    val oilPercentLowSustainedLimit: Double,

    /**
     * Percentage of Solid Fuel for cold startup
     */
    val solidfuelPercentColdStartup: Double,

    /**
     * Percentage of Solid Fuel for hot startup
     */
    val solidfuelPercentHotStartup: Double,

    /**
     * Percentage of Solid Fuel for intermedite startup
     */
    val solidfuelPercentIntermediateStartup: Double,

    /**
     * Percentage of Solid Fuel for operating at LSL
     */
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
    val fuelColdStartup = parse_element (element ("""ResourceStartupCost.fuelColdStartup"""))_
    val fuelHotStartup = parse_element (element ("""ResourceStartupCost.fuelHotStartup"""))_
    val fuelIntermediateStartup = parse_element (element ("""ResourceStartupCost.fuelIntermediateStartup"""))_
    val fuelLowSustainedLimit = parse_element (element ("""ResourceStartupCost.fuelLowSustainedLimit"""))_
    val gasPercentColdStartup = parse_element (element ("""ResourceStartupCost.gasPercentColdStartup"""))_
    val gasPercentHotStartup = parse_element (element ("""ResourceStartupCost.gasPercentHotStartup"""))_
    val gasPercentIntermediateStartup = parse_element (element ("""ResourceStartupCost.gasPercentIntermediateStartup"""))_
    val gasPercentLowSustainedLimit = parse_element (element ("""ResourceStartupCost.gasPercentLowSustainedLimit"""))_
    val oilPercentColdStartup = parse_element (element ("""ResourceStartupCost.oilPercentColdStartup"""))_
    val oilPercentHotStartup = parse_element (element ("""ResourceStartupCost.oilPercentHotStartup"""))_
    val oilPercentIntermediateStartup = parse_element (element ("""ResourceStartupCost.oilPercentIntermediateStartup"""))_
    val oilPercentLowSustainedLimit = parse_element (element ("""ResourceStartupCost.oilPercentLowSustainedLimit"""))_
    val solidfuelPercentColdStartup = parse_element (element ("""ResourceStartupCost.solidfuelPercentColdStartup"""))_
    val solidfuelPercentHotStartup = parse_element (element ("""ResourceStartupCost.solidfuelPercentHotStartup"""))_
    val solidfuelPercentIntermediateStartup = parse_element (element ("""ResourceStartupCost.solidfuelPercentIntermediateStartup"""))_
    val solidfuelPercentLowSustainedLimit = parse_element (element ("""ResourceStartupCost.solidfuelPercentLowSustainedLimit"""))_
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
 */
case class ResourceVerifiableCosts
(

    override val sup: BasicElement,

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
    val MktHeatRateCurve = parse_attribute (attribute ("""ResourceVerifiableCosts.MktHeatRateCurve"""))_
    val RegisteredResource = parse_attribute (attribute ("""ResourceVerifiableCosts.RegisteredResource"""))_
    val ResourceOperationMaintenanceCost = parse_attribute (attribute ("""ResourceVerifiableCosts.ResourceOperationMaintenanceCost"""))_
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
 */
case class SchedulingCoordinator
(

    override val sup: MktOrganisation,

    /**
     * This is the short name or Scheduling Coordinator ID field.
     */
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
    val scid = parse_element (element ("""SchedulingCoordinator.scid"""))_
    val LoadRatio = parse_attribute (attribute ("""SchedulingCoordinator.LoadRatio"""))_
    val MktOrgansation = parse_attribute (attribute ("""SchedulingCoordinator.MktOrgansation"""))_
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
 */
case class SchedulingCoordinatorUser
(

    override val sup: BasicElement,

    /**
     * Login ID Expiration Date
     */
    val endEffectiveDate: String,

    /**
     * Login ID
     */
    val loginID: String,

    /**
     * Assigned roles (these are roles with either Read or Read/Write privileges on different Market Systems)
     */
    val loginRole: String,

    /**
     * Login ID Effective Date
     */
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
    val endEffectiveDate = parse_element (element ("""SchedulingCoordinatorUser.endEffectiveDate"""))_
    val loginID = parse_element (element ("""SchedulingCoordinatorUser.loginID"""))_
    val loginRole = parse_element (element ("""SchedulingCoordinatorUser.loginRole"""))_
    val startEffectiveDate = parse_element (element ("""SchedulingCoordinatorUser.startEffectiveDate"""))_
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
 */
case class SchedulingPoint
(

    override val sup: IdentifiedObject,

    /**
     * End effective date.
     */
    val endEffectiveDate: String,

    /**
     * Start effective date.
     */
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
    val endEffectiveDate = parse_element (element ("""SchedulingPoint.endEffectiveDate"""))_
    val startEffectiveDate = parse_element (element ("""SchedulingPoint.startEffectiveDate"""))_
    val Flowgate = parse_attribute (attribute ("""SchedulingPoint.Flowgate"""))_
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
 */
case class StartUpEnergyCurve
(

    override val sup: Curve,

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
    val RegisteredGenerator = parse_attribute (attribute ("""StartUpEnergyCurve.RegisteredGenerator"""))_
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
 */
case class StartUpFuelCurve
(

    override val sup: Curve,

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
    val RegisteredGenerator = parse_attribute (attribute ("""StartUpFuelCurve.RegisteredGenerator"""))_
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
 */
case class SubControlArea
(

    override val sup: PowerSystemResource,

    /**
     * Market area short name, which is the regulation zone.
     * It references AGC regulation zone name.
     */
    val areaShortName: String,

    /**
     * Loss estimate constant coefficient
     */
    val constantCoefficient: Double,

    /**
     * Used in conjunction with the InternalCA flag.
     * If the InternalCA flag is YES, this flag does not apply. If the InternaCA flag is NO, this flag provides an indication of AdjacentCA (NO) or Embedded CA (YES).
     */
    val embeddedControlArea: String,

    /**
     * end effective date
     */
    val endEffectiveDate: String,

    /**
     * A Yes/No indication that this control area is contained internal to the system.
     */
    val internalCA: String,

    /**
     * Loss estimate linear coefficient
     */
    val linearCoefficient: Double,

    /**
     * Indication that this control area is the local control area.
     */
    val localCA: String,

    /**
     * Maximum amount of self schedule MWs allowed for an embedded control area.
     */
    val maxSelfSchedMW: Double,

    /**
     * Minimum amount of self schedule MW allowed for an embedded control area.
     */
    val minSelfSchedMW: Double,

    /**
     * Loss estimate quadratic coefficient
     */
    val quadraticCoefficient: Double,

    /**
     * start effective date
     */
    val startEffectiveDate: String,

    val AdjacentCASet: String,

    val AreaReserveSpecification: String,

    /**
     * The interchange area  may operate as a control area
     */
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
    val areaShortName = parse_element (element ("""SubControlArea.areaShortName"""))_
    val constantCoefficient = parse_element (element ("""SubControlArea.constantCoefficient"""))_
    val embeddedControlArea = parse_attribute (attribute ("""SubControlArea.embeddedControlArea"""))_
    val endEffectiveDate = parse_element (element ("""SubControlArea.endEffectiveDate"""))_
    val internalCA = parse_attribute (attribute ("""SubControlArea.internalCA"""))_
    val linearCoefficient = parse_element (element ("""SubControlArea.linearCoefficient"""))_
    val localCA = parse_attribute (attribute ("""SubControlArea.localCA"""))_
    val maxSelfSchedMW = parse_element (element ("""SubControlArea.maxSelfSchedMW"""))_
    val minSelfSchedMW = parse_element (element ("""SubControlArea.minSelfSchedMW"""))_
    val quadraticCoefficient = parse_element (element ("""SubControlArea.quadraticCoefficient"""))_
    val startEffectiveDate = parse_element (element ("""SubControlArea.startEffectiveDate"""))_
    val AdjacentCASet = parse_attribute (attribute ("""SubControlArea.AdjacentCASet"""))_
    val AreaReserveSpecification = parse_attribute (attribute ("""SubControlArea.AreaReserveSpecification"""))_
    val HostControlArea = parse_attribute (attribute ("""SubControlArea.HostControlArea"""))_
    val RTO = parse_attribute (attribute ("""SubControlArea.RTO"""))_
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
 */
case class SubstitutionResourceList
(

    override val sup: BasicElement,

    /**
     * An indicator of the order a resource should be substituted.
     * The lower the number the higher the precedence.
     */
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
    val precedence = parse_element (element ("""SubstitutionResourceList.precedence"""))_
    val RegisteredResource = parse_attribute (attribute ("""SubstitutionResourceList.RegisteredResource"""))_
    val TransmissionContractRight = parse_attribute (attribute ("""SubstitutionResourceList.TransmissionContractRight"""))_
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
 */
case class TACArea
(

    override val sup: IdentifiedObject,

    /**
     * end effective date
     */
    val endEffectiveDate: String,

    /**
     * start effective date
     */
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
    val endEffectiveDate = parse_element (element ("""TACArea.endEffectiveDate"""))_
    val startEffectiveDate = parse_element (element ("""TACArea.startEffectiveDate"""))_
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
 */
case class TransmissionRightChain
(

    override val sup: IdentifiedObject,

    /**
     * end effective date
     */
    val endEffectiveDate: String,

    /**
     * start effective date
     */
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
    val endEffectiveDate = parse_element (element ("""TransmissionRightChain.endEffectiveDate"""))_
    val startEffectiveDate = parse_element (element ("""TransmissionRightChain.startEffectiveDate"""))_
    val Chain_ContractRight = parse_attribute (attribute ("""TransmissionRightChain.Chain_ContractRight"""))_
    val RTO = parse_attribute (attribute ("""TransmissionRightChain.RTO"""))_
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
 */
case class WheelingCounterParty
(

    override val sup: IdentifiedObject,

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
    val RegisteredInterTie = parse_attributes (attribute ("""WheelingCounterParty.RegisteredInterTie"""))_
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