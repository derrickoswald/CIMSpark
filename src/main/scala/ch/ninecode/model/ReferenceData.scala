package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * Market static reference data.
 */

/**
 * Goups Adjacent Control Areas
 * @param sup Reference to the superclass object.
 * @param endEffectiveDate end effective date
 * @param lossPercentage_1 Loss percentage
 * @param startEffectiveDate start effective date
 * @param HostControlArea <em>undocumented</em>
 * @param RTO <em>undocumented</em>
 */
case class AdjacentCASet
(
    override val sup: IdentifiedObject,
    endEffectiveDate: String,
    lossPercentage_1: Double,
    startEffectiveDate: String,
    HostControlArea: String,
    RTO: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[AdjacentCASet] }
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
        (if (null != endEffectiveDate) "\t\t<cim:AdjacentCASet.endEffectiveDate>" + endEffectiveDate + "</cim:AdjacentCASet.endEffectiveDate>\n" else "") +
        "\t\t<cim:AdjacentCASet.lossPercentage >" + lossPercentage_1 + "</cim:AdjacentCASet.lossPercentage >\n" +
        (if (null != startEffectiveDate) "\t\t<cim:AdjacentCASet.startEffectiveDate>" + startEffectiveDate + "</cim:AdjacentCASet.startEffectiveDate>\n" else "") +
        (if (null != HostControlArea) "\t\t<cim:AdjacentCASet.HostControlArea rdf:resource=\"#" + HostControlArea + "\"/>\n" else "") +
        (if (null != RTO) "\t\t<cim:AdjacentCASet.RTO rdf:resource=\"#" + RTO + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AdjacentCASet rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AdjacentCASet>"
    }
}

object AdjacentCASet
extends
    Parseable[AdjacentCASet]
{
    val endEffectiveDate = parse_element (element ("""AdjacentCASet.endEffectiveDate"""))
    val lossPercentage_1 = parse_element (element ("""AdjacentCASet.lossPercentage """))
    val startEffectiveDate = parse_element (element ("""AdjacentCASet.startEffectiveDate"""))
    val HostControlArea = parse_attribute (attribute ("""AdjacentCASet.HostControlArea"""))
    val RTO = parse_attribute (attribute ("""AdjacentCASet.RTO"""))
    def parse (context: Context): AdjacentCASet =
    {
        AdjacentCASet(
            IdentifiedObject.parse (context),
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
 * @param Pnode <em>undocumented</em>
 * @param RTO <em>undocumented</em>
 * @param SubControlArea <em>undocumented</em>
 */
case class AggregateNode
(
    override val sup: IdentifiedObject,
    anodeType: String,
    endEffectiveDate: String,
    qualifASOrder: Int,
    startEffectiveDate: String,
    Pnode: List[String],
    RTO: String,
    SubControlArea: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, 0, null, List(), null, List()) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[AggregateNode] }
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
        (if (null != anodeType) "\t\t<cim:AggregateNode.anodeType rdf:resource=\"#" + anodeType + "\"/>\n" else "") +
        (if (null != endEffectiveDate) "\t\t<cim:AggregateNode.endEffectiveDate>" + endEffectiveDate + "</cim:AggregateNode.endEffectiveDate>\n" else "") +
        "\t\t<cim:AggregateNode.qualifASOrder>" + qualifASOrder + "</cim:AggregateNode.qualifASOrder>\n" +
        (if (null != startEffectiveDate) "\t\t<cim:AggregateNode.startEffectiveDate>" + startEffectiveDate + "</cim:AggregateNode.startEffectiveDate>\n" else "") +
        (if (null != Pnode) Pnode.map (x => "\t\t<cim:AggregateNode.Pnode rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != RTO) "\t\t<cim:AggregateNode.RTO rdf:resource=\"#" + RTO + "\"/>\n" else "") +
        (if (null != SubControlArea) SubControlArea.map (x => "\t\t<cim:AggregateNode.SubControlArea rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:AggregateNode rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AggregateNode>"
    }
}

object AggregateNode
extends
    Parseable[AggregateNode]
{
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
            IdentifiedObject.parse (context),
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
 *        
 *        'Y' - Participates in both Local Market Power Mitigation (LMPM) and System Market Power Mitigation (SMPM)
 *        'N' - Not included in LMP price measures
 *        'S' - Participatesin SMPM price measures
 *        'L' - Participatesin LMPM price measures
 * @param PnodeDistributionFactor <em>undocumented</em>
 * @param TACArea <em>undocumented</em>
 */
case class AggregatedPnode
(
    override val sup: Pnode,
    apnodeType: String,
    participationCategory: String,
    PnodeDistributionFactor: String,
    TACArea: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, null, List()) }
    def Pnode: Pnode = sup.asInstanceOf[Pnode]
    override def copy (): Row = { clone ().asInstanceOf[AggregatedPnode] }
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
        (if (null != apnodeType) "\t\t<cim:AggregatedPnode.apnodeType rdf:resource=\"#" + apnodeType + "\"/>\n" else "") +
        (if (null != participationCategory) "\t\t<cim:AggregatedPnode.participationCategory rdf:resource=\"#" + participationCategory + "\"/>\n" else "") +
        (if (null != PnodeDistributionFactor) "\t\t<cim:AggregatedPnode.PnodeDistributionFactor rdf:resource=\"#" + PnodeDistributionFactor + "\"/>\n" else "") +
        (if (null != TACArea) TACArea.map (x => "\t\t<cim:AggregatedPnode.TACArea rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:AggregatedPnode rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AggregatedPnode>"
    }
}

object AggregatedPnode
extends
    Parseable[AggregatedPnode]
{
    val apnodeType = parse_attribute (attribute ("""AggregatedPnode.apnodeType"""))
    val participationCategory = parse_attribute (attribute ("""AggregatedPnode.participationCategory"""))
    val PnodeDistributionFactor = parse_attribute (attribute ("""AggregatedPnode.PnodeDistributionFactor"""))
    val TACArea = parse_attributes (attribute ("""AggregatedPnode.TACArea"""))
    def parse (context: Context): AggregatedPnode =
    {
        AggregatedPnode(
            Pnode.parse (context),
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
 * @param bidCeiling Bid Ceiling (\$/MWH)
 * @param bidCeilingAS Bid Ceiling (\$/MWH) for generic AS versus a specific market product
 * @param bidFloor Bid Floor, (\$/MWH)
 * @param bidFloorAS Bid Floor (\$/MWH) for generic AS versus a specific market product
 * @param defaultPrice Bid Default Price(\$/MWH)
 * @param marketType Market Type of the cap (DAM or RTM)
 * @param MarketProduct <em>undocumented</em>
 */
case class BidPriceCap
(
    override val sup: BasicElement,
    bidCeiling: Double,
    bidCeilingAS: Double,
    bidFloor: Double,
    bidFloorAS: Double,
    defaultPrice: Double,
    marketType: String,
    MarketProduct: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[BidPriceCap] }
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
        "\t\t<cim:BidPriceCap.bidCeiling>" + bidCeiling + "</cim:BidPriceCap.bidCeiling>\n" +
        "\t\t<cim:BidPriceCap.bidCeilingAS>" + bidCeilingAS + "</cim:BidPriceCap.bidCeilingAS>\n" +
        "\t\t<cim:BidPriceCap.bidFloor>" + bidFloor + "</cim:BidPriceCap.bidFloor>\n" +
        "\t\t<cim:BidPriceCap.bidFloorAS>" + bidFloorAS + "</cim:BidPriceCap.bidFloorAS>\n" +
        "\t\t<cim:BidPriceCap.defaultPrice>" + defaultPrice + "</cim:BidPriceCap.defaultPrice>\n" +
        (if (null != marketType) "\t\t<cim:BidPriceCap.marketType rdf:resource=\"#" + marketType + "\"/>\n" else "") +
        (if (null != MarketProduct) "\t\t<cim:BidPriceCap.MarketProduct rdf:resource=\"#" + MarketProduct + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:BidPriceCap rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:BidPriceCap>"
    }
}

object BidPriceCap
extends
    Parseable[BidPriceCap]
{
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
            BasicElement.parse (context),
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
 * @param AggregateNode <em>undocumented</em>
 * @param HostControlArea <em>undocumented</em>
 * @param MktConnectivityNode <em>undocumented</em>
 * @param SubControlArea <em>undocumented</em>
 */
case class CnodeDistributionFactor
(
    override val sup: IdentifiedObject,
    factor: Double,
    podLossFactor: Double,
    AggregateNode: String,
    HostControlArea: String,
    MktConnectivityNode: String,
    SubControlArea: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[CnodeDistributionFactor] }
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
        "\t\t<cim:CnodeDistributionFactor.factor>" + factor + "</cim:CnodeDistributionFactor.factor>\n" +
        "\t\t<cim:CnodeDistributionFactor.podLossFactor>" + podLossFactor + "</cim:CnodeDistributionFactor.podLossFactor>\n" +
        (if (null != AggregateNode) "\t\t<cim:CnodeDistributionFactor.AggregateNode rdf:resource=\"#" + AggregateNode + "\"/>\n" else "") +
        (if (null != HostControlArea) "\t\t<cim:CnodeDistributionFactor.HostControlArea rdf:resource=\"#" + HostControlArea + "\"/>\n" else "") +
        (if (null != MktConnectivityNode) "\t\t<cim:CnodeDistributionFactor.MktConnectivityNode rdf:resource=\"#" + MktConnectivityNode + "\"/>\n" else "") +
        (if (null != SubControlArea) "\t\t<cim:CnodeDistributionFactor.SubControlArea rdf:resource=\"#" + SubControlArea + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:CnodeDistributionFactor rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CnodeDistributionFactor>"
    }
}

object CnodeDistributionFactor
extends
    Parseable[CnodeDistributionFactor]
{
    val factor = parse_element (element ("""CnodeDistributionFactor.factor"""))
    val podLossFactor = parse_element (element ("""CnodeDistributionFactor.podLossFactor"""))
    val AggregateNode = parse_attribute (attribute ("""CnodeDistributionFactor.AggregateNode"""))
    val HostControlArea = parse_attribute (attribute ("""CnodeDistributionFactor.HostControlArea"""))
    val MktConnectivityNode = parse_attribute (attribute ("""CnodeDistributionFactor.MktConnectivityNode"""))
    val SubControlArea = parse_attribute (attribute ("""CnodeDistributionFactor.SubControlArea"""))
    def parse (context: Context): CnodeDistributionFactor =
    {
        CnodeDistributionFactor(
            IdentifiedObject.parse (context),
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
 * @param CombinedCycleLogicalConfiguration <em>undocumented</em>
 * @param ShutdownFlag Whether Combined Cycle Plant can be shut-down in this Configuration?
 * @param StartupFlag Whether Combined Cycle Plant can be started in this Logical Configuration?
 */
case class CombinedCycleConfiguration
(
    override val sup: RegisteredGenerator,
    primaryConfiguration: Boolean,
    CombinedCycleLogicalConfiguration: String,
    ShutdownFlag: Boolean,
    StartupFlag: Boolean
)
extends
    Element
{
    def this () = { this (null, false, null, false, false) }
    def RegisteredGenerator: RegisteredGenerator = sup.asInstanceOf[RegisteredGenerator]
    override def copy (): Row = { clone ().asInstanceOf[CombinedCycleConfiguration] }
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
        "\t\t<cim:CombinedCycleConfiguration.primaryConfiguration>" + primaryConfiguration + "</cim:CombinedCycleConfiguration.primaryConfiguration>\n" +
        (if (null != CombinedCycleLogicalConfiguration) "\t\t<cim:CombinedCycleConfiguration.CombinedCycleLogicalConfiguration rdf:resource=\"#" + CombinedCycleLogicalConfiguration + "\"/>\n" else "") +
        "\t\t<cim:CombinedCycleConfiguration.ShutdownFlag>" + ShutdownFlag + "</cim:CombinedCycleConfiguration.ShutdownFlag>\n" +
        "\t\t<cim:CombinedCycleConfiguration.StartupFlag>" + StartupFlag + "</cim:CombinedCycleConfiguration.StartupFlag>\n"
    }
    override def export: String =
    {
        "\t<cim:CombinedCycleConfiguration rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CombinedCycleConfiguration>"
    }
}

object CombinedCycleConfiguration
extends
    Parseable[CombinedCycleConfiguration]
{
    val primaryConfiguration = parse_element (element ("""CombinedCycleConfiguration.primaryConfiguration"""))
    val CombinedCycleLogicalConfiguration = parse_attribute (attribute ("""CombinedCycleConfiguration.CombinedCycleLogicalConfiguration"""))
    val ShutdownFlag = parse_element (element ("""CombinedCycleConfiguration.ShutdownFlag"""))
    val StartupFlag = parse_element (element ("""CombinedCycleConfiguration.StartupFlag"""))
    def parse (context: Context): CombinedCycleConfiguration =
    {
        CombinedCycleConfiguration(
            RegisteredGenerator.parse (context),
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
 * @param CombinedCycleConfiguration <em>undocumented</em>
 * @param MktThermalGeneratingUnit <em>undocumented</em>
 */
case class CombinedCycleConfigurationMember
(
    override val sup: IdentifiedObject,
    primary: Boolean,
    steam: Boolean,
    CombinedCycleConfiguration: String,
    MktThermalGeneratingUnit: String
)
extends
    Element
{
    def this () = { this (null, false, false, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[CombinedCycleConfigurationMember] }
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
        "\t\t<cim:CombinedCycleConfigurationMember.primary>" + primary + "</cim:CombinedCycleConfigurationMember.primary>\n" +
        "\t\t<cim:CombinedCycleConfigurationMember.steam>" + steam + "</cim:CombinedCycleConfigurationMember.steam>\n" +
        (if (null != CombinedCycleConfiguration) "\t\t<cim:CombinedCycleConfigurationMember.CombinedCycleConfiguration rdf:resource=\"#" + CombinedCycleConfiguration + "\"/>\n" else "") +
        (if (null != MktThermalGeneratingUnit) "\t\t<cim:CombinedCycleConfigurationMember.MktThermalGeneratingUnit rdf:resource=\"#" + MktThermalGeneratingUnit + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:CombinedCycleConfigurationMember rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CombinedCycleConfigurationMember>"
    }
}

object CombinedCycleConfigurationMember
extends
    Parseable[CombinedCycleConfigurationMember]
{
    val primary = parse_element (element ("""CombinedCycleConfigurationMember.primary"""))
    val steam = parse_element (element ("""CombinedCycleConfigurationMember.steam"""))
    val CombinedCycleConfiguration = parse_attribute (attribute ("""CombinedCycleConfigurationMember.CombinedCycleConfiguration"""))
    val MktThermalGeneratingUnit = parse_attribute (attribute ("""CombinedCycleConfigurationMember.MktThermalGeneratingUnit"""))
    def parse (context: Context): CombinedCycleConfigurationMember =
    {
        CombinedCycleConfigurationMember(
            IdentifiedObject.parse (context),
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
 * @param MktCombinedCyclePlant <em>undocumented</em>
 */
case class CombinedCycleLogicalConfiguration
(
    override val sup: IdentifiedObject,
    MktCombinedCyclePlant: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[CombinedCycleLogicalConfiguration] }
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
        (if (null != MktCombinedCyclePlant) "\t\t<cim:CombinedCycleLogicalConfiguration.MktCombinedCyclePlant rdf:resource=\"#" + MktCombinedCyclePlant + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:CombinedCycleLogicalConfiguration rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CombinedCycleLogicalConfiguration>"
    }
}

object CombinedCycleLogicalConfiguration
extends
    Parseable[CombinedCycleLogicalConfiguration]
{
    val MktCombinedCyclePlant = parse_attribute (attribute ("""CombinedCycleLogicalConfiguration.MktCombinedCyclePlant"""))
    def parse (context: Context): CombinedCycleLogicalConfiguration =
    {
        CombinedCycleLogicalConfiguration(
            IdentifiedObject.parse (context),
            MktCombinedCyclePlant (context)
        )
    }
}

/**
 * Defines the available from and to Transition States for the Combine Cycle Configurations.
 * @param sup Reference to the superclass object.
 * @param upTransition Flag indicating whether this is an UP transition.
 *        If not, it is a DOWN transition.
 * @param FromConfiguration <em>undocumented</em>
 * @param ToConfiguration <em>undocumented</em>
 */
case class CombinedCycleTransitionState
(
    override val sup: BasicElement,
    upTransition: Boolean,
    FromConfiguration: String,
    ToConfiguration: String
)
extends
    Element
{
    def this () = { this (null, false, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[CombinedCycleTransitionState] }
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
        "\t\t<cim:CombinedCycleTransitionState.upTransition>" + upTransition + "</cim:CombinedCycleTransitionState.upTransition>\n" +
        (if (null != FromConfiguration) "\t\t<cim:CombinedCycleTransitionState.FromConfiguration rdf:resource=\"#" + FromConfiguration + "\"/>\n" else "") +
        (if (null != ToConfiguration) "\t\t<cim:CombinedCycleTransitionState.ToConfiguration rdf:resource=\"#" + ToConfiguration + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:CombinedCycleTransitionState rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CombinedCycleTransitionState>"
    }
}

object CombinedCycleTransitionState
extends
    Parseable[CombinedCycleTransitionState]
{
    val upTransition = parse_element (element ("""CombinedCycleTransitionState.upTransition"""))
    val FromConfiguration = parse_attribute (attribute ("""CombinedCycleTransitionState.FromConfiguration"""))
    val ToConfiguration = parse_attribute (attribute ("""CombinedCycleTransitionState.ToConfiguration"""))
    def parse (context: Context): CombinedCycleTransitionState =
    {
        CombinedCycleTransitionState(
            BasicElement.parse (context),
            toBoolean (upTransition (context), context),
            FromConfiguration (context),
            ToConfiguration (context)
        )
    }
}

/**
 * Designated Congestion Area Definition (DCA)
 * @param sup Reference to the superclass object.
 * @param IndividualPnode <em>undocumented</em>
 */
case class CongestionArea
(
    override val sup: AggregatedPnode,
    IndividualPnode: List[String]
)
extends
    Element
{
    def this () = { this (null, List()) }
    def AggregatedPnode: AggregatedPnode = sup.asInstanceOf[AggregatedPnode]
    override def copy (): Row = { clone ().asInstanceOf[CongestionArea] }
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
        (if (null != IndividualPnode) IndividualPnode.map (x => "\t\t<cim:CongestionArea.IndividualPnode rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:CongestionArea rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CongestionArea>"
    }
}

object CongestionArea
extends
    Parseable[CongestionArea]
{
    val IndividualPnode = parse_attributes (attribute ("""CongestionArea.IndividualPnode"""))
    def parse (context: Context): CongestionArea =
    {
        CongestionArea(
            AggregatedPnode.parse (context),
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
 * @param Flowgate <em>undocumented</em>
 * @param RegisteredResource <em>undocumented</em>
 * @param TransmissionContractRight <em>undocumented</em>
 */
case class ContractDistributionFactor
(
    override val sup: BasicElement,
    factor: Double,
    sinkFlag: String,
    sourceFlag: String,
    Flowgate: String,
    RegisteredResource: String,
    TransmissionContractRight: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ContractDistributionFactor] }
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
        "\t\t<cim:ContractDistributionFactor.factor>" + factor + "</cim:ContractDistributionFactor.factor>\n" +
        (if (null != sinkFlag) "\t\t<cim:ContractDistributionFactor.sinkFlag rdf:resource=\"#" + sinkFlag + "\"/>\n" else "") +
        (if (null != sourceFlag) "\t\t<cim:ContractDistributionFactor.sourceFlag rdf:resource=\"#" + sourceFlag + "\"/>\n" else "") +
        (if (null != Flowgate) "\t\t<cim:ContractDistributionFactor.Flowgate rdf:resource=\"#" + Flowgate + "\"/>\n" else "") +
        (if (null != RegisteredResource) "\t\t<cim:ContractDistributionFactor.RegisteredResource rdf:resource=\"#" + RegisteredResource + "\"/>\n" else "") +
        (if (null != TransmissionContractRight) "\t\t<cim:ContractDistributionFactor.TransmissionContractRight rdf:resource=\"#" + TransmissionContractRight + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ContractDistributionFactor rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ContractDistributionFactor>"
    }
}

object ContractDistributionFactor
extends
    Parseable[ContractDistributionFactor]
{
    val factor = parse_element (element ("""ContractDistributionFactor.factor"""))
    val sinkFlag = parse_attribute (attribute ("""ContractDistributionFactor.sinkFlag"""))
    val sourceFlag = parse_attribute (attribute ("""ContractDistributionFactor.sourceFlag"""))
    val Flowgate = parse_attribute (attribute ("""ContractDistributionFactor.Flowgate"""))
    val RegisteredResource = parse_attribute (attribute ("""ContractDistributionFactor.RegisteredResource"""))
    val TransmissionContractRight = parse_attribute (attribute ("""ContractDistributionFactor.TransmissionContractRight"""))
    def parse (context: Context): ContractDistributionFactor =
    {
        ContractDistributionFactor(
            BasicElement.parse (context),
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
 * @param Chain_TransmissionRightChain <em>undocumented</em>
 * @param Ind_TransmissionRightChain <em>undocumented</em>
 * @param RTO <em>undocumented</em>
 * @param SchedulingCoordinator <em>undocumented</em>
 * @param TRType Transmission Right type - is this an individual contract right or a chain contract right.
 *        Types = CHAIN or INDIVIDUAL
 */
case class ContractRight
(
    override val sup: IdentifiedObject,
    chainOrder: Int,
    contractMW: Double,
    contractPrice: Double,
    contractPriority: Int,
    contractStatus: String,
    contractType: String,
    endEffectiveDate: String,
    financialLocation: String,
    financialRightsDAM: String,
    financialRightsRTM: String,
    fuelAdder: Double,
    latestSchedMinutes: Int,
    latestSchedMktType: String,
    maxNetDependableCapacity: Double,
    maximumScheduleQuantity: Double,
    maximumServiceHours: Int,
    maximumStartups: Int,
    minimumLoad: Double,
    minimumScheduleQuantity: Double,
    physicalRightsDAM: String,
    physicalRightsRTM: String,
    startEffectiveDate: String,
    startupLeadTime: Int,
    Chain_TransmissionRightChain: String,
    Ind_TransmissionRightChain: String,
    RTO: String,
    SchedulingCoordinator: String,
    TRType: String
)
extends
    Element
{
    def this () = { this (null, 0, 0.0, 0.0, 0, null, null, null, null, null, null, 0.0, 0, null, 0.0, 0.0, 0, 0, 0.0, 0.0, null, null, null, 0, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ContractRight] }
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
        "\t\t<cim:ContractRight.chainOrder>" + chainOrder + "</cim:ContractRight.chainOrder>\n" +
        "\t\t<cim:ContractRight.contractMW>" + contractMW + "</cim:ContractRight.contractMW>\n" +
        "\t\t<cim:ContractRight.contractPrice>" + contractPrice + "</cim:ContractRight.contractPrice>\n" +
        "\t\t<cim:ContractRight.contractPriority>" + contractPriority + "</cim:ContractRight.contractPriority>\n" +
        (if (null != contractStatus) "\t\t<cim:ContractRight.contractStatus>" + contractStatus + "</cim:ContractRight.contractStatus>\n" else "") +
        (if (null != contractType) "\t\t<cim:ContractRight.contractType rdf:resource=\"#" + contractType + "\"/>\n" else "") +
        (if (null != endEffectiveDate) "\t\t<cim:ContractRight.endEffectiveDate>" + endEffectiveDate + "</cim:ContractRight.endEffectiveDate>\n" else "") +
        (if (null != financialLocation) "\t\t<cim:ContractRight.financialLocation rdf:resource=\"#" + financialLocation + "\"/>\n" else "") +
        (if (null != financialRightsDAM) "\t\t<cim:ContractRight.financialRightsDAM rdf:resource=\"#" + financialRightsDAM + "\"/>\n" else "") +
        (if (null != financialRightsRTM) "\t\t<cim:ContractRight.financialRightsRTM rdf:resource=\"#" + financialRightsRTM + "\"/>\n" else "") +
        "\t\t<cim:ContractRight.fuelAdder>" + fuelAdder + "</cim:ContractRight.fuelAdder>\n" +
        "\t\t<cim:ContractRight.latestSchedMinutes>" + latestSchedMinutes + "</cim:ContractRight.latestSchedMinutes>\n" +
        (if (null != latestSchedMktType) "\t\t<cim:ContractRight.latestSchedMktType rdf:resource=\"#" + latestSchedMktType + "\"/>\n" else "") +
        "\t\t<cim:ContractRight.maxNetDependableCapacity>" + maxNetDependableCapacity + "</cim:ContractRight.maxNetDependableCapacity>\n" +
        "\t\t<cim:ContractRight.maximumScheduleQuantity>" + maximumScheduleQuantity + "</cim:ContractRight.maximumScheduleQuantity>\n" +
        "\t\t<cim:ContractRight.maximumServiceHours>" + maximumServiceHours + "</cim:ContractRight.maximumServiceHours>\n" +
        "\t\t<cim:ContractRight.maximumStartups>" + maximumStartups + "</cim:ContractRight.maximumStartups>\n" +
        "\t\t<cim:ContractRight.minimumLoad>" + minimumLoad + "</cim:ContractRight.minimumLoad>\n" +
        "\t\t<cim:ContractRight.minimumScheduleQuantity>" + minimumScheduleQuantity + "</cim:ContractRight.minimumScheduleQuantity>\n" +
        (if (null != physicalRightsDAM) "\t\t<cim:ContractRight.physicalRightsDAM rdf:resource=\"#" + physicalRightsDAM + "\"/>\n" else "") +
        (if (null != physicalRightsRTM) "\t\t<cim:ContractRight.physicalRightsRTM rdf:resource=\"#" + physicalRightsRTM + "\"/>\n" else "") +
        (if (null != startEffectiveDate) "\t\t<cim:ContractRight.startEffectiveDate>" + startEffectiveDate + "</cim:ContractRight.startEffectiveDate>\n" else "") +
        "\t\t<cim:ContractRight.startupLeadTime>" + startupLeadTime + "</cim:ContractRight.startupLeadTime>\n" +
        (if (null != Chain_TransmissionRightChain) "\t\t<cim:ContractRight.Chain_TransmissionRightChain rdf:resource=\"#" + Chain_TransmissionRightChain + "\"/>\n" else "") +
        (if (null != Ind_TransmissionRightChain) "\t\t<cim:ContractRight.Ind_TransmissionRightChain rdf:resource=\"#" + Ind_TransmissionRightChain + "\"/>\n" else "") +
        (if (null != RTO) "\t\t<cim:ContractRight.RTO rdf:resource=\"#" + RTO + "\"/>\n" else "") +
        (if (null != SchedulingCoordinator) "\t\t<cim:ContractRight.SchedulingCoordinator rdf:resource=\"#" + SchedulingCoordinator + "\"/>\n" else "") +
        (if (null != TRType) "\t\t<cim:ContractRight.TRType rdf:resource=\"#" + TRType + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ContractRight rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ContractRight>"
    }
}

object ContractRight
extends
    Parseable[ContractRight]
{
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
            IdentifiedObject.parse (context),
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
 * @param native1 Native.
 * @param RegisteredResource <em>undocumented</em>
 * @param SubControlArea <em>undocumented</em>
 */
case class ControlAreaDesignation
(
    override val sup: BasicElement,
    attained: String,
    native1: String,
    RegisteredResource: List[String],
    SubControlArea: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, List(), List()) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ControlAreaDesignation] }
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
        (if (null != attained) "\t\t<cim:ControlAreaDesignation.attained rdf:resource=\"#" + attained + "\"/>\n" else "") +
        (if (null != native1) "\t\t<cim:ControlAreaDesignation.native rdf:resource=\"#" + native1 + "\"/>\n" else "") +
        (if (null != RegisteredResource) RegisteredResource.map (x => "\t\t<cim:ControlAreaDesignation.RegisteredResource rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != SubControlArea) SubControlArea.map (x => "\t\t<cim:ControlAreaDesignation.SubControlArea rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:ControlAreaDesignation rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ControlAreaDesignation>"
    }
}

object ControlAreaDesignation
extends
    Parseable[ControlAreaDesignation]
{
    val attained = parse_attribute (attribute ("""ControlAreaDesignation.attained"""))
    val native1 = parse_attribute (attribute ("""ControlAreaDesignation.native"""))
    val RegisteredResource = parse_attributes (attribute ("""ControlAreaDesignation.RegisteredResource"""))
    val SubControlArea = parse_attributes (attribute ("""ControlAreaDesignation.SubControlArea"""))
    def parse (context: Context): ControlAreaDesignation =
    {
        ControlAreaDesignation(
            BasicElement.parse (context),
            attained (context),
            native1 (context),
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
 * @param CRR <em>undocumented</em>
 * @param From_SubControlArea <em>undocumented</em>
 * @param GenericConstraints <em>undocumented</em>
 * @param HostControlArea <em>undocumented</em>
 * @param MktLine <em>undocumented</em>
 * @param MktPowerTransformer <em>undocumented</em>
 * @param SecurityConstraints <em>undocumented</em>
 * @param To_SubControlArea <em>undocumented</em>
 */
case class Flowgate
(
    override val sup: PowerSystemResource,
    direction: String,
    endEffectiveDate: String,
    exportMWRating: Double,
    importMWRating: Double,
    startEffectiveDate: String,
    CRR: String,
    From_SubControlArea: String,
    GenericConstraints: String,
    HostControlArea: String,
    MktLine: List[String],
    MktPowerTransformer: List[String],
    SecurityConstraints: String,
    To_SubControlArea: String
)
extends
    Element
{
    def this () = { this (null, null, null, 0.0, 0.0, null, null, null, null, null, List(), List(), null, null) }
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { clone ().asInstanceOf[Flowgate] }
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
        (if (null != direction) "\t\t<cim:Flowgate.direction rdf:resource=\"#" + direction + "\"/>\n" else "") +
        (if (null != endEffectiveDate) "\t\t<cim:Flowgate.endEffectiveDate>" + endEffectiveDate + "</cim:Flowgate.endEffectiveDate>\n" else "") +
        "\t\t<cim:Flowgate.exportMWRating>" + exportMWRating + "</cim:Flowgate.exportMWRating>\n" +
        "\t\t<cim:Flowgate.importMWRating>" + importMWRating + "</cim:Flowgate.importMWRating>\n" +
        (if (null != startEffectiveDate) "\t\t<cim:Flowgate.startEffectiveDate>" + startEffectiveDate + "</cim:Flowgate.startEffectiveDate>\n" else "") +
        (if (null != CRR) "\t\t<cim:Flowgate.CRR rdf:resource=\"#" + CRR + "\"/>\n" else "") +
        (if (null != From_SubControlArea) "\t\t<cim:Flowgate.From_SubControlArea rdf:resource=\"#" + From_SubControlArea + "\"/>\n" else "") +
        (if (null != GenericConstraints) "\t\t<cim:Flowgate.GenericConstraints rdf:resource=\"#" + GenericConstraints + "\"/>\n" else "") +
        (if (null != HostControlArea) "\t\t<cim:Flowgate.HostControlArea rdf:resource=\"#" + HostControlArea + "\"/>\n" else "") +
        (if (null != MktLine) MktLine.map (x => "\t\t<cim:Flowgate.MktLine rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != MktPowerTransformer) MktPowerTransformer.map (x => "\t\t<cim:Flowgate.MktPowerTransformer rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != SecurityConstraints) "\t\t<cim:Flowgate.SecurityConstraints rdf:resource=\"#" + SecurityConstraints + "\"/>\n" else "") +
        (if (null != To_SubControlArea) "\t\t<cim:Flowgate.To_SubControlArea rdf:resource=\"#" + To_SubControlArea + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Flowgate rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Flowgate>"
    }
}

object Flowgate
extends
    Parseable[Flowgate]
{
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
            PowerSystemResource.parse (context),
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
 * @param FlowgateValue <em>undocumented</em>
 */
case class FlowgatePartner
(
    override val sup: IdentifiedObject,
    FlowgateValue: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[FlowgatePartner] }
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
        (if (null != FlowgateValue) "\t\t<cim:FlowgatePartner.FlowgateValue rdf:resource=\"#" + FlowgateValue + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:FlowgatePartner rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:FlowgatePartner>"
    }
}

object FlowgatePartner
extends
    Parseable[FlowgatePartner]
{
    val FlowgateValue = parse_attribute (attribute ("""FlowgatePartner.FlowgateValue"""))
    def parse (context: Context): FlowgatePartner =
    {
        FlowgatePartner(
            IdentifiedObject.parse (context),
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
 * @param Flowgate <em>undocumented</em>
 */
case class FlowgateRelief
(
    override val sup: BasicElement,
    effectiveDate: String,
    idcTargetMktFlow: Int,
    terminateDate: String,
    Flowgate: String
)
extends
    Element
{
    def this () = { this (null, null, 0, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[FlowgateRelief] }
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
        (if (null != effectiveDate) "\t\t<cim:FlowgateRelief.effectiveDate>" + effectiveDate + "</cim:FlowgateRelief.effectiveDate>\n" else "") +
        "\t\t<cim:FlowgateRelief.idcTargetMktFlow>" + idcTargetMktFlow + "</cim:FlowgateRelief.idcTargetMktFlow>\n" +
        (if (null != terminateDate) "\t\t<cim:FlowgateRelief.terminateDate>" + terminateDate + "</cim:FlowgateRelief.terminateDate>\n" else "") +
        (if (null != Flowgate) "\t\t<cim:FlowgateRelief.Flowgate rdf:resource=\"#" + Flowgate + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:FlowgateRelief rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:FlowgateRelief>"
    }
}

object FlowgateRelief
extends
    Parseable[FlowgateRelief]
{
    val effectiveDate = parse_element (element ("""FlowgateRelief.effectiveDate"""))
    val idcTargetMktFlow = parse_element (element ("""FlowgateRelief.idcTargetMktFlow"""))
    val terminateDate = parse_element (element ("""FlowgateRelief.terminateDate"""))
    val Flowgate = parse_attribute (attribute ("""FlowgateRelief.Flowgate"""))
    def parse (context: Context): FlowgateRelief =
    {
        FlowgateRelief(
            BasicElement.parse (context),
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
 * @param Flowgate <em>undocumented</em>
 * @param FlowgatePartner <em>undocumented</em>
 */
case class FlowgateValue
(
    override val sup: BasicElement,
    economicDispatchLimit: Int,
    effectiveDate: String,
    firmNetworkLimit: Int,
    flowDirectionFlag: String,
    mktFlow: Int,
    netFirmNetworkLimit: Int,
    Flowgate: String,
    FlowgatePartner: String
)
extends
    Element
{
    def this () = { this (null, 0, null, 0, null, 0, 0, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[FlowgateValue] }
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
        "\t\t<cim:FlowgateValue.economicDispatchLimit>" + economicDispatchLimit + "</cim:FlowgateValue.economicDispatchLimit>\n" +
        (if (null != effectiveDate) "\t\t<cim:FlowgateValue.effectiveDate>" + effectiveDate + "</cim:FlowgateValue.effectiveDate>\n" else "") +
        "\t\t<cim:FlowgateValue.firmNetworkLimit>" + firmNetworkLimit + "</cim:FlowgateValue.firmNetworkLimit>\n" +
        (if (null != flowDirectionFlag) "\t\t<cim:FlowgateValue.flowDirectionFlag rdf:resource=\"#" + flowDirectionFlag + "\"/>\n" else "") +
        "\t\t<cim:FlowgateValue.mktFlow>" + mktFlow + "</cim:FlowgateValue.mktFlow>\n" +
        "\t\t<cim:FlowgateValue.netFirmNetworkLimit>" + netFirmNetworkLimit + "</cim:FlowgateValue.netFirmNetworkLimit>\n" +
        (if (null != Flowgate) "\t\t<cim:FlowgateValue.Flowgate rdf:resource=\"#" + Flowgate + "\"/>\n" else "") +
        (if (null != FlowgatePartner) "\t\t<cim:FlowgateValue.FlowgatePartner rdf:resource=\"#" + FlowgatePartner + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:FlowgateValue rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:FlowgateValue>"
    }
}

object FlowgateValue
extends
    Parseable[FlowgateValue]
{
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
            BasicElement.parse (context),
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
    override val sup: IdentifiedObject,
    crossTime: Int,
    crossingCost: Double,
    highMW: Double,
    lowMW: Double
)
extends
    Element
{
    def this () = { this (null, 0, 0.0, 0.0, 0.0) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ForbiddenRegion] }
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
        "\t\t<cim:ForbiddenRegion.crossTime>" + crossTime + "</cim:ForbiddenRegion.crossTime>\n" +
        "\t\t<cim:ForbiddenRegion.crossingCost>" + crossingCost + "</cim:ForbiddenRegion.crossingCost>\n" +
        "\t\t<cim:ForbiddenRegion.highMW>" + highMW + "</cim:ForbiddenRegion.highMW>\n" +
        "\t\t<cim:ForbiddenRegion.lowMW>" + lowMW + "</cim:ForbiddenRegion.lowMW>\n"
    }
    override def export: String =
    {
        "\t<cim:ForbiddenRegion rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ForbiddenRegion>"
    }
}

object ForbiddenRegion
extends
    Parseable[ForbiddenRegion]
{
    val crossTime = parse_element (element ("""ForbiddenRegion.crossTime"""))
    val crossingCost = parse_element (element ("""ForbiddenRegion.crossingCost"""))
    val highMW = parse_element (element ("""ForbiddenRegion.highMW"""))
    val lowMW = parse_element (element ("""ForbiddenRegion.lowMW"""))
    def parse (context: Context): ForbiddenRegion =
    {
        ForbiddenRegion(
            IdentifiedObject.parse (context),
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
 * @param RegisteredResource <em>undocumented</em>
 */
case class FormerReference
(
    override val sup: IdentifiedObject,
    RegisteredResource: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[FormerReference] }
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
        (if (null != RegisteredResource) "\t\t<cim:FormerReference.RegisteredResource rdf:resource=\"#" + RegisteredResource + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:FormerReference rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:FormerReference>"
    }
}

object FormerReference
extends
    Parseable[FormerReference]
{
    val RegisteredResource = parse_attribute (attribute ("""FormerReference.RegisteredResource"""))
    def parse (context: Context): FormerReference =
    {
        FormerReference(
            IdentifiedObject.parse (context),
            RegisteredResource (context)
        )
    }
}

/**
 * Relationship between unit fuel cost in \$/kWh(Y-axis) and  unit output in MW (X-axis).
 * @param sup Reference to the superclass object.
 * @param RegisteredGenerator <em>undocumented</em>
 */
case class FuelCostCurve
(
    override val sup: Curve,
    RegisteredGenerator: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[FuelCostCurve] }
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
        (if (null != RegisteredGenerator) "\t\t<cim:FuelCostCurve.RegisteredGenerator rdf:resource=\"#" + RegisteredGenerator + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:FuelCostCurve rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:FuelCostCurve>"
    }
}

object FuelCostCurve
extends
    Parseable[FuelCostCurve]
{
    val RegisteredGenerator = parse_attribute (attribute ("""FuelCostCurve.RegisteredGenerator"""))
    def parse (context: Context): FuelCostCurve =
    {
        FuelCostCurve(
            Curve.parse (context),
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
 * @param GasPrice <em>undocumented</em>
 * @param OilPrice <em>undocumented</em>
 * @param RTO <em>undocumented</em>
 */
case class FuelRegion
(
    override val sup: IdentifiedObject,
    endEffectiveDate: String,
    fuelRegionType: String,
    lastModified: String,
    startEffectiveDate: String,
    GasPrice: String,
    OilPrice: String,
    RTO: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[FuelRegion] }
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
        (if (null != endEffectiveDate) "\t\t<cim:FuelRegion.endEffectiveDate>" + endEffectiveDate + "</cim:FuelRegion.endEffectiveDate>\n" else "") +
        (if (null != fuelRegionType) "\t\t<cim:FuelRegion.fuelRegionType>" + fuelRegionType + "</cim:FuelRegion.fuelRegionType>\n" else "") +
        (if (null != lastModified) "\t\t<cim:FuelRegion.lastModified>" + lastModified + "</cim:FuelRegion.lastModified>\n" else "") +
        (if (null != startEffectiveDate) "\t\t<cim:FuelRegion.startEffectiveDate>" + startEffectiveDate + "</cim:FuelRegion.startEffectiveDate>\n" else "") +
        (if (null != GasPrice) "\t\t<cim:FuelRegion.GasPrice rdf:resource=\"#" + GasPrice + "\"/>\n" else "") +
        (if (null != OilPrice) "\t\t<cim:FuelRegion.OilPrice rdf:resource=\"#" + OilPrice + "\"/>\n" else "") +
        (if (null != RTO) "\t\t<cim:FuelRegion.RTO rdf:resource=\"#" + RTO + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:FuelRegion rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:FuelRegion>"
    }
}

object FuelRegion
extends
    Parseable[FuelRegion]
{
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
            IdentifiedObject.parse (context),
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
 * @param FuelRegion <em>undocumented</em>
 */
case class GasPrice
(
    override val sup: BasicElement,
    gasPriceIndex: Double,
    FuelRegion: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[GasPrice] }
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
        "\t\t<cim:GasPrice.gasPriceIndex>" + gasPriceIndex + "</cim:GasPrice.gasPriceIndex>\n" +
        (if (null != FuelRegion) "\t\t<cim:GasPrice.FuelRegion rdf:resource=\"#" + FuelRegion + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:GasPrice rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GasPrice>"
    }
}

object GasPrice
extends
    Parseable[GasPrice]
{
    val gasPriceIndex = parse_element (element ("""GasPrice.gasPriceIndex"""))
    val FuelRegion = parse_attribute (attribute ("""GasPrice.FuelRegion"""))
    def parse (context: Context): GasPrice =
    {
        GasPrice(
            BasicElement.parse (context),
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
 * @param AdjacentCASet <em>undocumented</em>
 * @param Controls A ControlAreaCompany controls a ControlArea.
 * @param RTO <em>undocumented</em>
 */
case class HostControlArea
(
    override val sup: PowerSystemResource,
    areaControlMode: String,
    endEffectiveDate: String,
    freqSetPoint: Double,
    frequencyBiasFactor: Double,
    startEffectiveDate: String,
    AdjacentCASet: String,
    Controls: String,
    RTO: String
)
extends
    Element
{
    def this () = { this (null, null, null, 0.0, 0.0, null, null, null, null) }
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { clone ().asInstanceOf[HostControlArea] }
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
        (if (null != areaControlMode) "\t\t<cim:HostControlArea.areaControlMode rdf:resource=\"#" + areaControlMode + "\"/>\n" else "") +
        (if (null != endEffectiveDate) "\t\t<cim:HostControlArea.endEffectiveDate>" + endEffectiveDate + "</cim:HostControlArea.endEffectiveDate>\n" else "") +
        "\t\t<cim:HostControlArea.freqSetPoint>" + freqSetPoint + "</cim:HostControlArea.freqSetPoint>\n" +
        "\t\t<cim:HostControlArea.frequencyBiasFactor>" + frequencyBiasFactor + "</cim:HostControlArea.frequencyBiasFactor>\n" +
        (if (null != startEffectiveDate) "\t\t<cim:HostControlArea.startEffectiveDate>" + startEffectiveDate + "</cim:HostControlArea.startEffectiveDate>\n" else "") +
        (if (null != AdjacentCASet) "\t\t<cim:HostControlArea.AdjacentCASet rdf:resource=\"#" + AdjacentCASet + "\"/>\n" else "") +
        (if (null != Controls) "\t\t<cim:HostControlArea.Controls rdf:resource=\"#" + Controls + "\"/>\n" else "") +
        (if (null != RTO) "\t\t<cim:HostControlArea.RTO rdf:resource=\"#" + RTO + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:HostControlArea rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:HostControlArea>"
    }
}

object HostControlArea
extends
    Parseable[HostControlArea]
{
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
            PowerSystemResource.parse (context),
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
 * @param GenDistributionFactor <em>undocumented</em>
 * @param LoadDistributionFactor <em>undocumented</em>
 * @param MktConnectivityNode <em>undocumented</em>
 */
case class IndividualPnode
(
    override val sup: Pnode,
    GenDistributionFactor: String,
    LoadDistributionFactor: String,
    MktConnectivityNode: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Pnode: Pnode = sup.asInstanceOf[Pnode]
    override def copy (): Row = { clone ().asInstanceOf[IndividualPnode] }
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
        (if (null != GenDistributionFactor) "\t\t<cim:IndividualPnode.GenDistributionFactor rdf:resource=\"#" + GenDistributionFactor + "\"/>\n" else "") +
        (if (null != LoadDistributionFactor) "\t\t<cim:IndividualPnode.LoadDistributionFactor rdf:resource=\"#" + LoadDistributionFactor + "\"/>\n" else "") +
        (if (null != MktConnectivityNode) "\t\t<cim:IndividualPnode.MktConnectivityNode rdf:resource=\"#" + MktConnectivityNode + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:IndividualPnode rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:IndividualPnode>"
    }
}

object IndividualPnode
extends
    Parseable[IndividualPnode]
{
    val GenDistributionFactor = parse_attribute (attribute ("""IndividualPnode.GenDistributionFactor"""))
    val LoadDistributionFactor = parse_attribute (attribute ("""IndividualPnode.LoadDistributionFactor"""))
    val MktConnectivityNode = parse_attribute (attribute ("""IndividualPnode.MktConnectivityNode"""))
    def parse (context: Context): IndividualPnode =
    {
        IndividualPnode(
            Pnode.parse (context),
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
    override val sup: AggregateNode
)
extends
    Element
{
    def this () = { this (null) }
    def AggregateNode: AggregateNode = sup.asInstanceOf[AggregateNode]
    override def copy (): Row = { clone ().asInstanceOf[LoadAggregationPoint] }
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
        "\t<cim:LoadAggregationPoint rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:LoadAggregationPoint>"
    }
}

object LoadAggregationPoint
extends
    Parseable[LoadAggregationPoint]
{
    def parse (context: Context): LoadAggregationPoint =
    {
        LoadAggregationPoint(
            AggregateNode.parse (context)
        )
    }
}

/**
 * Representing the ratio of the load share for the associated SC.
 * @param sup Reference to the superclass object.
 * @param intervalEndTime Interval End Time
 * @param intervalStartTime Interval Start Time
 * @param share Share in percentage of total Market load for the selected time interval.
 * @param SchedulingCoordinator <em>undocumented</em>
 */
case class LoadRatio
(
    override val sup: BasicElement,
    intervalEndTime: String,
    intervalStartTime: String,
    share: Double,
    SchedulingCoordinator: String
)
extends
    Element
{
    def this () = { this (null, null, null, 0.0, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[LoadRatio] }
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
        (if (null != intervalEndTime) "\t\t<cim:LoadRatio.intervalEndTime>" + intervalEndTime + "</cim:LoadRatio.intervalEndTime>\n" else "") +
        (if (null != intervalStartTime) "\t\t<cim:LoadRatio.intervalStartTime>" + intervalStartTime + "</cim:LoadRatio.intervalStartTime>\n" else "") +
        "\t\t<cim:LoadRatio.share>" + share + "</cim:LoadRatio.share>\n" +
        (if (null != SchedulingCoordinator) "\t\t<cim:LoadRatio.SchedulingCoordinator rdf:resource=\"#" + SchedulingCoordinator + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:LoadRatio rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:LoadRatio>"
    }
}

object LoadRatio
extends
    Parseable[LoadRatio]
{
    val intervalEndTime = parse_element (element ("""LoadRatio.intervalEndTime"""))
    val intervalStartTime = parse_element (element ("""LoadRatio.intervalStartTime"""))
    val share = parse_element (element ("""LoadRatio.share"""))
    val SchedulingCoordinator = parse_attribute (attribute ("""LoadRatio.SchedulingCoordinator"""))
    def parse (context: Context): LoadRatio =
    {
        LoadRatio(
            BasicElement.parse (context),
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
    override val sup: Curve,
    loadReductionTimeCurveType: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[LoadReductionTimeCurve] }
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
        (if (null != loadReductionTimeCurveType) "\t\t<cim:LoadReductionTimeCurve.loadReductionTimeCurveType>" + loadReductionTimeCurveType + "</cim:LoadReductionTimeCurve.loadReductionTimeCurveType>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:LoadReductionTimeCurve rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:LoadReductionTimeCurve>"
    }
}

object LoadReductionTimeCurve
extends
    Parseable[LoadReductionTimeCurve]
{
    val loadReductionTimeCurveType = parse_element (element ("""LoadReductionTimeCurve.loadReductionTimeCurveType"""))
    def parse (context: Context): LoadReductionTimeCurve =
    {
        LoadReductionTimeCurve(
            Curve.parse (context),
            loadReductionTimeCurveType (context)
        )
    }
}

/**
 * Allows definition of reliablity areas (eg load pockets) within the ISO/RTO
 * @param sup Reference to the superclass object.
 * @param RTO <em>undocumented</em>
 */
case class LocalReliabilityArea
(
    override val sup: IdentifiedObject,
    RTO: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[LocalReliabilityArea] }
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
        (if (null != RTO) "\t\t<cim:LocalReliabilityArea.RTO rdf:resource=\"#" + RTO + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:LocalReliabilityArea rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:LocalReliabilityArea>"
    }
}

object LocalReliabilityArea
extends
    Parseable[LocalReliabilityArea]
{
    val RTO = parse_attribute (attribute ("""LocalReliabilityArea.RTO"""))
    def parse (context: Context): LocalReliabilityArea =
    {
        LocalReliabilityArea(
            IdentifiedObject.parse (context),
            RTO (context)
        )
    }
}

/**
 * Provides a reference to the Market Power Mitigation test identifiers and methods for the results of the DA or RT markets.
 * Specific data is the test identifier (Price, Conduct, or Impact) and the test method (System MPM, Local MPM, Alternate System MPM, or Alternate Local MPM).
 * @param sup Reference to the superclass object.
 * @param purposeFlag Nature of threshold data:
 *        'M' - Mitigation threshold
 *        'R' - Reporting threshold
 * @param testIdentifier 1 - Global Price Test
 *        2 - Global Conduct Test
 *        3 - Global Impact Test
 *        4 - Local Price Test
 *        5 - Local Conduct Test
 *        6 - Local Impact Test
 * @param testMethod The method of performing the market power monitoring.
 *        Examples are Normal (default) thresholds or Alternate thresholds.
 */
case class MPMTestCategory
(
    override val sup: IdentifiedObject,
    purposeFlag: String,
    testIdentifier: String,
    testMethod: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[MPMTestCategory] }
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
        (if (null != purposeFlag) "\t\t<cim:MPMTestCategory.purposeFlag rdf:resource=\"#" + purposeFlag + "\"/>\n" else "") +
        (if (null != testIdentifier) "\t\t<cim:MPMTestCategory.testIdentifier rdf:resource=\"#" + testIdentifier + "\"/>\n" else "") +
        (if (null != testMethod) "\t\t<cim:MPMTestCategory.testMethod rdf:resource=\"#" + testMethod + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MPMTestCategory rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MPMTestCategory>"
    }
}

object MPMTestCategory
extends
    Parseable[MPMTestCategory]
{
    val purposeFlag = parse_attribute (attribute ("""MPMTestCategory.purposeFlag"""))
    val testIdentifier = parse_attribute (attribute ("""MPMTestCategory.testIdentifier"""))
    val testMethod = parse_attribute (attribute ("""MPMTestCategory.testMethod"""))
    def parse (context: Context): MPMTestCategory =
    {
        MPMTestCategory(
            IdentifiedObject.parse (context),
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
 * @param price Price Threshold in \$/MW
 * @param MPMTestCategory <em>undocumented</em>
 * @param RegisteredResource <em>undocumented</em>
 */
case class MPMTestThreshold
(
    override val sup: BasicElement,
    marketType: String,
    percent: Double,
    price: Double,
    MPMTestCategory: String,
    RegisteredResource: List[String]
)
extends
    Element
{
    def this () = { this (null, null, 0.0, 0.0, null, List()) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[MPMTestThreshold] }
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
        (if (null != marketType) "\t\t<cim:MPMTestThreshold.marketType rdf:resource=\"#" + marketType + "\"/>\n" else "") +
        "\t\t<cim:MPMTestThreshold.percent>" + percent + "</cim:MPMTestThreshold.percent>\n" +
        "\t\t<cim:MPMTestThreshold.price>" + price + "</cim:MPMTestThreshold.price>\n" +
        (if (null != MPMTestCategory) "\t\t<cim:MPMTestThreshold.MPMTestCategory rdf:resource=\"#" + MPMTestCategory + "\"/>\n" else "") +
        (if (null != RegisteredResource) RegisteredResource.map (x => "\t\t<cim:MPMTestThreshold.RegisteredResource rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:MPMTestThreshold rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MPMTestThreshold>"
    }
}

object MPMTestThreshold
extends
    Parseable[MPMTestThreshold]
{
    val marketType = parse_attribute (attribute ("""MPMTestThreshold.marketType"""))
    val percent = parse_element (element ("""MPMTestThreshold.percent"""))
    val price = parse_element (element ("""MPMTestThreshold.price"""))
    val MPMTestCategory = parse_attribute (attribute ("""MPMTestThreshold.MPMTestCategory"""))
    val RegisteredResource = parse_attributes (attribute ("""MPMTestThreshold.RegisteredResource"""))
    def parse (context: Context): MPMTestThreshold =
    {
        MPMTestThreshold(
            BasicElement.parse (context),
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
 * @param RTO <em>undocumented</em>
 */
case class MSSAggregation
(
    override val sup: IdentifiedObject,
    costRecovery: String,
    endEffectiveDate: String,
    grossSettlement: String,
    ignoreLosses: String,
    ignoreMarginalLosses: String,
    loadFollowing: String,
    rucProcurement: String,
    startEffectiveDate: String,
    RTO: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[MSSAggregation] }
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
        (if (null != costRecovery) "\t\t<cim:MSSAggregation.costRecovery rdf:resource=\"#" + costRecovery + "\"/>\n" else "") +
        (if (null != endEffectiveDate) "\t\t<cim:MSSAggregation.endEffectiveDate>" + endEffectiveDate + "</cim:MSSAggregation.endEffectiveDate>\n" else "") +
        (if (null != grossSettlement) "\t\t<cim:MSSAggregation.grossSettlement rdf:resource=\"#" + grossSettlement + "\"/>\n" else "") +
        (if (null != ignoreLosses) "\t\t<cim:MSSAggregation.ignoreLosses rdf:resource=\"#" + ignoreLosses + "\"/>\n" else "") +
        (if (null != ignoreMarginalLosses) "\t\t<cim:MSSAggregation.ignoreMarginalLosses rdf:resource=\"#" + ignoreMarginalLosses + "\"/>\n" else "") +
        (if (null != loadFollowing) "\t\t<cim:MSSAggregation.loadFollowing rdf:resource=\"#" + loadFollowing + "\"/>\n" else "") +
        (if (null != rucProcurement) "\t\t<cim:MSSAggregation.rucProcurement rdf:resource=\"#" + rucProcurement + "\"/>\n" else "") +
        (if (null != startEffectiveDate) "\t\t<cim:MSSAggregation.startEffectiveDate>" + startEffectiveDate + "</cim:MSSAggregation.startEffectiveDate>\n" else "") +
        (if (null != RTO) "\t\t<cim:MSSAggregation.RTO rdf:resource=\"#" + RTO + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MSSAggregation rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MSSAggregation>"
    }
}

object MSSAggregation
extends
    Parseable[MSSAggregation]
{
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
            IdentifiedObject.parse (context),
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
 * @param MeteredSubSystem <em>undocumented</em>
 */
case class MSSZone
(
    override val sup: AggregateNode,
    ignoreLosses: String,
    lossFactor: Double,
    rucGrossSettlement: String,
    MeteredSubSystem: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, null, null) }
    def AggregateNode: AggregateNode = sup.asInstanceOf[AggregateNode]
    override def copy (): Row = { clone ().asInstanceOf[MSSZone] }
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
        (if (null != ignoreLosses) "\t\t<cim:MSSZone.ignoreLosses rdf:resource=\"#" + ignoreLosses + "\"/>\n" else "") +
        "\t\t<cim:MSSZone.lossFactor>" + lossFactor + "</cim:MSSZone.lossFactor>\n" +
        (if (null != rucGrossSettlement) "\t\t<cim:MSSZone.rucGrossSettlement rdf:resource=\"#" + rucGrossSettlement + "\"/>\n" else "") +
        (if (null != MeteredSubSystem) "\t\t<cim:MSSZone.MeteredSubSystem rdf:resource=\"#" + MeteredSubSystem + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MSSZone rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MSSZone>"
    }
}

object MSSZone
extends
    Parseable[MSSZone]
{
    val ignoreLosses = parse_attribute (attribute ("""MSSZone.ignoreLosses"""))
    val lossFactor = parse_element (element ("""MSSZone.lossFactor"""))
    val rucGrossSettlement = parse_attribute (attribute ("""MSSZone.rucGrossSettlement"""))
    val MeteredSubSystem = parse_attribute (attribute ("""MSSZone.MeteredSubSystem"""))
    def parse (context: Context): MSSZone =
    {
        MSSZone(
            AggregateNode.parse (context),
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
 * @param status <em>undocumented</em>
 * @param suffix A suffix for the person's name, such as II, III, etc.
 * @param userID The user name for the person; required to log in.
 */
case class MarketPerson
(
    override val sup: IdentifiedObject,
    category: String,
    electronicAddressAlternate: String,
    electronicAddressPrimary: String,
    firstName: String,
    governmentID: String,
    landlinePhone: String,
    lastName: String,
    mName: String,
    mobilePhone: String,
    prefix: String,
    specialNeed: String,
    status: String,
    suffix: String,
    userID: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[MarketPerson] }
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
        (if (null != category) "\t\t<cim:MarketPerson.category>" + category + "</cim:MarketPerson.category>\n" else "") +
        (if (null != electronicAddressAlternate) "\t\t<cim:MarketPerson.electronicAddressAlternate rdf:resource=\"#" + electronicAddressAlternate + "\"/>\n" else "") +
        (if (null != electronicAddressPrimary) "\t\t<cim:MarketPerson.electronicAddressPrimary rdf:resource=\"#" + electronicAddressPrimary + "\"/>\n" else "") +
        (if (null != firstName) "\t\t<cim:MarketPerson.firstName>" + firstName + "</cim:MarketPerson.firstName>\n" else "") +
        (if (null != governmentID) "\t\t<cim:MarketPerson.governmentID>" + governmentID + "</cim:MarketPerson.governmentID>\n" else "") +
        (if (null != landlinePhone) "\t\t<cim:MarketPerson.landlinePhone rdf:resource=\"#" + landlinePhone + "\"/>\n" else "") +
        (if (null != lastName) "\t\t<cim:MarketPerson.lastName>" + lastName + "</cim:MarketPerson.lastName>\n" else "") +
        (if (null != mName) "\t\t<cim:MarketPerson.mName>" + mName + "</cim:MarketPerson.mName>\n" else "") +
        (if (null != mobilePhone) "\t\t<cim:MarketPerson.mobilePhone rdf:resource=\"#" + mobilePhone + "\"/>\n" else "") +
        (if (null != prefix) "\t\t<cim:MarketPerson.prefix>" + prefix + "</cim:MarketPerson.prefix>\n" else "") +
        (if (null != specialNeed) "\t\t<cim:MarketPerson.specialNeed>" + specialNeed + "</cim:MarketPerson.specialNeed>\n" else "") +
        (if (null != status) "\t\t<cim:MarketPerson.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != suffix) "\t\t<cim:MarketPerson.suffix>" + suffix + "</cim:MarketPerson.suffix>\n" else "") +
        (if (null != userID) "\t\t<cim:MarketPerson.userID>" + userID + "</cim:MarketPerson.userID>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MarketPerson rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MarketPerson>"
    }
}

object MarketPerson
extends
    Parseable[MarketPerson]
{
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
            IdentifiedObject.parse (context),
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
    override val sup: IdentifiedObject,
    effectiveDate: String,
    expirationDate: String,
    qualificationID: String,
    status: Int,
    statusType: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, 0, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[MarketQualificationRequirement] }
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
        (if (null != effectiveDate) "\t\t<cim:MarketQualificationRequirement.effectiveDate>" + effectiveDate + "</cim:MarketQualificationRequirement.effectiveDate>\n" else "") +
        (if (null != expirationDate) "\t\t<cim:MarketQualificationRequirement.expirationDate>" + expirationDate + "</cim:MarketQualificationRequirement.expirationDate>\n" else "") +
        (if (null != qualificationID) "\t\t<cim:MarketQualificationRequirement.qualificationID>" + qualificationID + "</cim:MarketQualificationRequirement.qualificationID>\n" else "") +
        "\t\t<cim:MarketQualificationRequirement.status>" + status + "</cim:MarketQualificationRequirement.status>\n" +
        (if (null != statusType) "\t\t<cim:MarketQualificationRequirement.statusType>" + statusType + "</cim:MarketQualificationRequirement.statusType>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MarketQualificationRequirement rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MarketQualificationRequirement>"
    }
}

object MarketQualificationRequirement
extends
    Parseable[MarketQualificationRequirement]
{
    val effectiveDate = parse_element (element ("""MarketQualificationRequirement.effectiveDate"""))
    val expirationDate = parse_element (element ("""MarketQualificationRequirement.expirationDate"""))
    val qualificationID = parse_element (element ("""MarketQualificationRequirement.qualificationID"""))
    val status = parse_element (element ("""MarketQualificationRequirement.status"""))
    val statusType = parse_element (element ("""MarketQualificationRequirement.statusType"""))
    def parse (context: Context): MarketQualificationRequirement =
    {
        MarketQualificationRequirement(
            IdentifiedObject.parse (context),
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
    override val sup: AggregateNode
)
extends
    Element
{
    def this () = { this (null) }
    def AggregateNode: AggregateNode = sup.asInstanceOf[AggregateNode]
    override def copy (): Row = { clone ().asInstanceOf[MarketRegion] }
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
        "\t<cim:MarketRegion rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MarketRegion>"
    }
}

object MarketRegion
extends
    Parseable[MarketRegion]
{
    def parse (context: Context): MarketRegion =
    {
        MarketRegion(
            AggregateNode.parse (context)
        )
    }
}

/**
 * Proficiency level of a craft, which is required to operate or maintain a particular type of asset and/or perform certain types of work.
 * @param sup Reference to the superclass object.
 * @param certificationPeriod Interval between the certification and its expiry.
 * @param effectiveDateTime Date and time the skill became effective.
 * @param level Level of skill for a Craft.
 * @param MarketPerson <em>undocumented</em>
 * @param MarketQualificationRequirements <em>undocumented</em>
 */
case class MarketSkill
(
    override val sup: Document,
    certificationPeriod: String,
    effectiveDateTime: String,
    level: String,
    MarketPerson: String,
    MarketQualificationRequirements: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, List()) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[MarketSkill] }
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
        (if (null != certificationPeriod) "\t\t<cim:MarketSkill.certificationPeriod rdf:resource=\"#" + certificationPeriod + "\"/>\n" else "") +
        (if (null != effectiveDateTime) "\t\t<cim:MarketSkill.effectiveDateTime>" + effectiveDateTime + "</cim:MarketSkill.effectiveDateTime>\n" else "") +
        (if (null != level) "\t\t<cim:MarketSkill.level>" + level + "</cim:MarketSkill.level>\n" else "") +
        (if (null != MarketPerson) "\t\t<cim:MarketSkill.MarketPerson rdf:resource=\"#" + MarketPerson + "\"/>\n" else "") +
        (if (null != MarketQualificationRequirements) MarketQualificationRequirements.map (x => "\t\t<cim:MarketSkill.MarketQualificationRequirements rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:MarketSkill rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MarketSkill>"
    }
}

object MarketSkill
extends
    Parseable[MarketSkill]
{
    val certificationPeriod = parse_attribute (attribute ("""MarketSkill.certificationPeriod"""))
    val effectiveDateTime = parse_element (element ("""MarketSkill.effectiveDateTime"""))
    val level = parse_element (element ("""MarketSkill.level"""))
    val MarketPerson = parse_attribute (attribute ("""MarketSkill.MarketPerson"""))
    val MarketQualificationRequirements = parse_attributes (attribute ("""MarketSkill.MarketQualificationRequirements"""))
    def parse (context: Context): MarketSkill =
    {
        MarketSkill(
            Document.parse (context),
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
    override val sup: Curve
)
extends
    Element
{
    def this () = { this (null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[MaxStartUpCostCurve] }
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
        "\t<cim:MaxStartUpCostCurve rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MaxStartUpCostCurve>"
    }
}

object MaxStartUpCostCurve
extends
    Parseable[MaxStartUpCostCurve]
{
    def parse (context: Context): MaxStartUpCostCurve =
    {
        MaxStartUpCostCurve(
            Curve.parse (context)
        )
    }
}

/**
 * A metered subsystem
 * @param sup Reference to the superclass object.
 * @param MSSAggregation <em>undocumented</em>
 */
case class MeteredSubSystem
(
    override val sup: IdentifiedObject,
    MSSAggregation: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[MeteredSubSystem] }
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
        (if (null != MSSAggregation) "\t\t<cim:MeteredSubSystem.MSSAggregation rdf:resource=\"#" + MSSAggregation + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MeteredSubSystem rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MeteredSubSystem>"
    }
}

object MeteredSubSystem
extends
    Parseable[MeteredSubSystem]
{
    val MSSAggregation = parse_attribute (attribute ("""MeteredSubSystem.MSSAggregation"""))
    def parse (context: Context): MeteredSubSystem =
    {
        MeteredSubSystem(
            IdentifiedObject.parse (context),
            MSSAggregation (context)
        )
    }
}

/**
 * Subclass of Production: CombinedCyclePlant from IEC61970 package.
 * A set of combustion turbines and steam turbines where the exhaust heat from the combustion turbines is recovered to make steam for the steam turbines, resulting in greater overall plant efficiency
 * @param sup Reference to the superclass object.
 * @param AggregatedPnode <em>undocumented</em>
 */
case class MktCombinedCyclePlant
(
    override val sup: CombinedCyclePlant,
    AggregatedPnode: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def CombinedCyclePlant: CombinedCyclePlant = sup.asInstanceOf[CombinedCyclePlant]
    override def copy (): Row = { clone ().asInstanceOf[MktCombinedCyclePlant] }
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
        (if (null != AggregatedPnode) "\t\t<cim:MktCombinedCyclePlant.AggregatedPnode rdf:resource=\"#" + AggregatedPnode + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MktCombinedCyclePlant rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MktCombinedCyclePlant>"
    }
}

object MktCombinedCyclePlant
extends
    Parseable[MktCombinedCyclePlant]
{
    val AggregatedPnode = parse_attribute (attribute ("""MktCombinedCyclePlant.AggregatedPnode"""))
    def parse (context: Context): MktCombinedCyclePlant =
    {
        MktCombinedCyclePlant(
            CombinedCyclePlant.parse (context),
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
    override val sup: ConductingEquipment
)
extends
    Element
{
    def this () = { this (null) }
    def ConductingEquipment: ConductingEquipment = sup.asInstanceOf[ConductingEquipment]
    override def copy (): Row = { clone ().asInstanceOf[MktConductingEquipment] }
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
        "\t<cim:MktConductingEquipment rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MktConductingEquipment>"
    }
}

object MktConductingEquipment
extends
    Parseable[MktConductingEquipment]
{
    def parse (context: Context): MktConductingEquipment =
    {
        MktConductingEquipment(
            ConductingEquipment.parse (context)
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
 * @param TransferInterfaceSolutionA <em>undocumented</em>
 * @param TransferInterfaceSolutionB <em>undocumented</em>
 */
case class MktContingency
(
    override val sup: Contingency,
    loadRolloverFlag: Boolean,
    ltcControlFlag: Boolean,
    participationFactorSet: String,
    screeningFlag: Boolean,
    TransferInterfaceSolutionA: String,
    TransferInterfaceSolutionB: String
)
extends
    Element
{
    def this () = { this (null, false, false, null, false, null, null) }
    def Contingency: Contingency = sup.asInstanceOf[Contingency]
    override def copy (): Row = { clone ().asInstanceOf[MktContingency] }
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
        "\t\t<cim:MktContingency.loadRolloverFlag>" + loadRolloverFlag + "</cim:MktContingency.loadRolloverFlag>\n" +
        "\t\t<cim:MktContingency.ltcControlFlag>" + ltcControlFlag + "</cim:MktContingency.ltcControlFlag>\n" +
        (if (null != participationFactorSet) "\t\t<cim:MktContingency.participationFactorSet>" + participationFactorSet + "</cim:MktContingency.participationFactorSet>\n" else "") +
        "\t\t<cim:MktContingency.screeningFlag>" + screeningFlag + "</cim:MktContingency.screeningFlag>\n" +
        (if (null != TransferInterfaceSolutionA) "\t\t<cim:MktContingency.TransferInterfaceSolutionA rdf:resource=\"#" + TransferInterfaceSolutionA + "\"/>\n" else "") +
        (if (null != TransferInterfaceSolutionB) "\t\t<cim:MktContingency.TransferInterfaceSolutionB rdf:resource=\"#" + TransferInterfaceSolutionB + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MktContingency rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MktContingency>"
    }
}

object MktContingency
extends
    Parseable[MktContingency]
{
    val loadRolloverFlag = parse_element (element ("""MktContingency.loadRolloverFlag"""))
    val ltcControlFlag = parse_element (element ("""MktContingency.ltcControlFlag"""))
    val participationFactorSet = parse_element (element ("""MktContingency.participationFactorSet"""))
    val screeningFlag = parse_element (element ("""MktContingency.screeningFlag"""))
    val TransferInterfaceSolutionA = parse_attribute (attribute ("""MktContingency.TransferInterfaceSolutionA"""))
    val TransferInterfaceSolutionB = parse_attribute (attribute ("""MktContingency.TransferInterfaceSolutionB"""))
    def parse (context: Context): MktContingency =
    {
        MktContingency(
            Contingency.parse (context),
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
 * @param RegisteredGenerator <em>undocumented</em>
 * @param ResourceVerifiableCosts <em>undocumented</em>
 */
case class MktHeatRateCurve
(
    override val sup: HeatRateCurve,
    RegisteredGenerator: String,
    ResourceVerifiableCosts: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def HeatRateCurve: HeatRateCurve = sup.asInstanceOf[HeatRateCurve]
    override def copy (): Row = { clone ().asInstanceOf[MktHeatRateCurve] }
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
        (if (null != RegisteredGenerator) "\t\t<cim:MktHeatRateCurve.RegisteredGenerator rdf:resource=\"#" + RegisteredGenerator + "\"/>\n" else "") +
        (if (null != ResourceVerifiableCosts) "\t\t<cim:MktHeatRateCurve.ResourceVerifiableCosts rdf:resource=\"#" + ResourceVerifiableCosts + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MktHeatRateCurve rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MktHeatRateCurve>"
    }
}

object MktHeatRateCurve
extends
    Parseable[MktHeatRateCurve]
{
    val RegisteredGenerator = parse_attribute (attribute ("""MktHeatRateCurve.RegisteredGenerator"""))
    val ResourceVerifiableCosts = parse_attribute (attribute ("""MktHeatRateCurve.ResourceVerifiableCosts"""))
    def parse (context: Context): MktHeatRateCurve =
    {
        MktHeatRateCurve(
            HeatRateCurve.parse (context),
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
    override val sup: ThermalGeneratingUnit
)
extends
    Element
{
    def this () = { this (null) }
    def ThermalGeneratingUnit: ThermalGeneratingUnit = sup.asInstanceOf[ThermalGeneratingUnit]
    override def copy (): Row = { clone ().asInstanceOf[MktThermalGeneratingUnit] }
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
        "\t<cim:MktThermalGeneratingUnit rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MktThermalGeneratingUnit>"
    }
}

object MktThermalGeneratingUnit
extends
    Parseable[MktThermalGeneratingUnit]
{
    def parse (context: Context): MktThermalGeneratingUnit =
    {
        MktThermalGeneratingUnit(
            ThermalGeneratingUnit.parse (context)
        )
    }
}

/**
 * Price of oil in monetary units
 * @param sup Reference to the superclass object.
 * @param oilPriceIndex The average oil price at a defined fuel region.
 * @param FuelRegion <em>undocumented</em>
 */
case class OilPrice
(
    override val sup: BasicElement,
    oilPriceIndex: Double,
    FuelRegion: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[OilPrice] }
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
        "\t\t<cim:OilPrice.oilPriceIndex>" + oilPriceIndex + "</cim:OilPrice.oilPriceIndex>\n" +
        (if (null != FuelRegion) "\t\t<cim:OilPrice.FuelRegion rdf:resource=\"#" + FuelRegion + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:OilPrice rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:OilPrice>"
    }
}

object OilPrice
extends
    Parseable[OilPrice]
{
    val oilPriceIndex = parse_element (element ("""OilPrice.oilPriceIndex"""))
    val FuelRegion = parse_attribute (attribute ("""OilPrice.FuelRegion"""))
    def parse (context: Context): OilPrice =
    {
        OilPrice(
            BasicElement.parse (context),
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
 * @param MktOrganisation <em>undocumented</em>
 * @param Pnode <em>undocumented</em>
 */
case class OrgPnodeAllocation
(
    override val sup: IdentifiedObject,
    endEffectiveDate: String,
    maxMWAllocation: Double,
    startEffectiveDate: String,
    MktOrganisation: String,
    Pnode: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[OrgPnodeAllocation] }
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
        (if (null != endEffectiveDate) "\t\t<cim:OrgPnodeAllocation.endEffectiveDate>" + endEffectiveDate + "</cim:OrgPnodeAllocation.endEffectiveDate>\n" else "") +
        "\t\t<cim:OrgPnodeAllocation.maxMWAllocation>" + maxMWAllocation + "</cim:OrgPnodeAllocation.maxMWAllocation>\n" +
        (if (null != startEffectiveDate) "\t\t<cim:OrgPnodeAllocation.startEffectiveDate>" + startEffectiveDate + "</cim:OrgPnodeAllocation.startEffectiveDate>\n" else "") +
        (if (null != MktOrganisation) "\t\t<cim:OrgPnodeAllocation.MktOrganisation rdf:resource=\"#" + MktOrganisation + "\"/>\n" else "") +
        (if (null != Pnode) "\t\t<cim:OrgPnodeAllocation.Pnode rdf:resource=\"#" + Pnode + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:OrgPnodeAllocation rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:OrgPnodeAllocation>"
    }
}

object OrgPnodeAllocation
extends
    Parseable[OrgPnodeAllocation]
{
    val endEffectiveDate = parse_element (element ("""OrgPnodeAllocation.endEffectiveDate"""))
    val maxMWAllocation = parse_element (element ("""OrgPnodeAllocation.maxMWAllocation"""))
    val startEffectiveDate = parse_element (element ("""OrgPnodeAllocation.startEffectiveDate"""))
    val MktOrganisation = parse_attribute (attribute ("""OrgPnodeAllocation.MktOrganisation"""))
    val Pnode = parse_attribute (attribute ("""OrgPnodeAllocation.Pnode"""))
    def parse (context: Context): OrgPnodeAllocation =
    {
        OrgPnodeAllocation(
            IdentifiedObject.parse (context),
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
 * @param MktOrganisation <em>undocumented</em>
 * @param RegisteredResource <em>undocumented</em>
 */
case class OrgResOwnership
(
    override val sup: IdentifiedObject,
    asscType: String,
    endEffectiveDate: String,
    masterSchedulingCoordinatorFlag: String,
    ownershipPercent: Double,
    startEffectiveDate: String,
    MktOrganisation: String,
    RegisteredResource: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, 0.0, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[OrgResOwnership] }
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
        (if (null != asscType) "\t\t<cim:OrgResOwnership.asscType rdf:resource=\"#" + asscType + "\"/>\n" else "") +
        (if (null != endEffectiveDate) "\t\t<cim:OrgResOwnership.endEffectiveDate>" + endEffectiveDate + "</cim:OrgResOwnership.endEffectiveDate>\n" else "") +
        (if (null != masterSchedulingCoordinatorFlag) "\t\t<cim:OrgResOwnership.masterSchedulingCoordinatorFlag rdf:resource=\"#" + masterSchedulingCoordinatorFlag + "\"/>\n" else "") +
        "\t\t<cim:OrgResOwnership.ownershipPercent>" + ownershipPercent + "</cim:OrgResOwnership.ownershipPercent>\n" +
        (if (null != startEffectiveDate) "\t\t<cim:OrgResOwnership.startEffectiveDate>" + startEffectiveDate + "</cim:OrgResOwnership.startEffectiveDate>\n" else "") +
        (if (null != MktOrganisation) "\t\t<cim:OrgResOwnership.MktOrganisation rdf:resource=\"#" + MktOrganisation + "\"/>\n" else "") +
        (if (null != RegisteredResource) "\t\t<cim:OrgResOwnership.RegisteredResource rdf:resource=\"#" + RegisteredResource + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:OrgResOwnership rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:OrgResOwnership>"
    }
}

object OrgResOwnership
extends
    Parseable[OrgResOwnership]
{
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
            IdentifiedObject.parse (context),
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
 *        'Control Area'
 *        'Regulation Region'
 *        'Price Zone'
 *        'Spin Region'
 *        'Non-Spin Region'
 *        'Price Hub'
 * @param RTO <em>undocumented</em>
 * @param SinkCRRSegment <em>undocumented</em>
 * @param SourceCRRSegment <em>undocumented</em>
 * @param SubControlArea <em>undocumented</em>
 */
case class Pnode
(
    override val sup: IdentifiedObject,
    endEffectiveDate: String,
    isPublic: Boolean,
    startEffectiveDate: String,
    typ: String,
    usage: String,
    RTO: String,
    SinkCRRSegment: List[String],
    SourceCRRSegment: List[String],
    SubControlArea: String
)
extends
    Element
{
    def this () = { this (null, null, false, null, null, null, null, List(), List(), null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Pnode] }
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
        (if (null != endEffectiveDate) "\t\t<cim:Pnode.endEffectiveDate>" + endEffectiveDate + "</cim:Pnode.endEffectiveDate>\n" else "") +
        "\t\t<cim:Pnode.isPublic>" + isPublic + "</cim:Pnode.isPublic>\n" +
        (if (null != startEffectiveDate) "\t\t<cim:Pnode.startEffectiveDate>" + startEffectiveDate + "</cim:Pnode.startEffectiveDate>\n" else "") +
        (if (null != typ) "\t\t<cim:Pnode.type>" + typ + "</cim:Pnode.type>\n" else "") +
        (if (null != usage) "\t\t<cim:Pnode.usage>" + usage + "</cim:Pnode.usage>\n" else "") +
        (if (null != RTO) "\t\t<cim:Pnode.RTO rdf:resource=\"#" + RTO + "\"/>\n" else "") +
        (if (null != SinkCRRSegment) SinkCRRSegment.map (x => "\t\t<cim:Pnode.SinkCRRSegment rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != SourceCRRSegment) SourceCRRSegment.map (x => "\t\t<cim:Pnode.SourceCRRSegment rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != SubControlArea) "\t\t<cim:Pnode.SubControlArea rdf:resource=\"#" + SubControlArea + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Pnode rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Pnode>"
    }
}

object Pnode
extends
    Parseable[Pnode]
{
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
            IdentifiedObject.parse (context),
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
 * @param BidDistributionFactor <em>undocumented</em>
 * @param IndividualPnode <em>undocumented</em>
 */
case class PnodeDistributionFactor
(
    override val sup: BasicElement,
    factor: Double,
    offPeak: String,
    onPeak: String,
    podLossFactor: Double,
    BidDistributionFactor: String,
    IndividualPnode: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null, 0.0, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[PnodeDistributionFactor] }
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
        "\t\t<cim:PnodeDistributionFactor.factor>" + factor + "</cim:PnodeDistributionFactor.factor>\n" +
        (if (null != offPeak) "\t\t<cim:PnodeDistributionFactor.offPeak rdf:resource=\"#" + offPeak + "\"/>\n" else "") +
        (if (null != onPeak) "\t\t<cim:PnodeDistributionFactor.onPeak rdf:resource=\"#" + onPeak + "\"/>\n" else "") +
        "\t\t<cim:PnodeDistributionFactor.podLossFactor>" + podLossFactor + "</cim:PnodeDistributionFactor.podLossFactor>\n" +
        (if (null != BidDistributionFactor) "\t\t<cim:PnodeDistributionFactor.BidDistributionFactor rdf:resource=\"#" + BidDistributionFactor + "\"/>\n" else "") +
        (if (null != IndividualPnode) "\t\t<cim:PnodeDistributionFactor.IndividualPnode rdf:resource=\"#" + IndividualPnode + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:PnodeDistributionFactor rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PnodeDistributionFactor>"
    }
}

object PnodeDistributionFactor
extends
    Parseable[PnodeDistributionFactor]
{
    val factor = parse_element (element ("""PnodeDistributionFactor.factor"""))
    val offPeak = parse_attribute (attribute ("""PnodeDistributionFactor.offPeak"""))
    val onPeak = parse_attribute (attribute ("""PnodeDistributionFactor.onPeak"""))
    val podLossFactor = parse_element (element ("""PnodeDistributionFactor.podLossFactor"""))
    val BidDistributionFactor = parse_attribute (attribute ("""PnodeDistributionFactor.BidDistributionFactor"""))
    val IndividualPnode = parse_attribute (attribute ("""PnodeDistributionFactor.IndividualPnode"""))
    def parse (context: Context): PnodeDistributionFactor =
    {
        PnodeDistributionFactor(
            BasicElement.parse (context),
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
 * @param RegisteredGenerator <em>undocumented</em>
 */
case class RMRHeatRateCurve
(
    override val sup: Curve,
    RegisteredGenerator: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[RMRHeatRateCurve] }
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
        (if (null != RegisteredGenerator) "\t\t<cim:RMRHeatRateCurve.RegisteredGenerator rdf:resource=\"#" + RegisteredGenerator + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:RMRHeatRateCurve rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RMRHeatRateCurve>"
    }
}

object RMRHeatRateCurve
extends
    Parseable[RMRHeatRateCurve]
{
    val RegisteredGenerator = parse_attribute (attribute ("""RMRHeatRateCurve.RegisteredGenerator"""))
    def parse (context: Context): RMRHeatRateCurve =
    {
        RMRHeatRateCurve(
            Curve.parse (context),
            RegisteredGenerator (context)
        )
    }
}

/**
 * Model to support processing of reliability must run units.
 * @param sup Reference to the superclass object.
 * @param RegisteredGenerator <em>undocumented</em>
 */
case class RMRStartUpCostCurve
(
    override val sup: Curve,
    RegisteredGenerator: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[RMRStartUpCostCurve] }
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
        (if (null != RegisteredGenerator) "\t\t<cim:RMRStartUpCostCurve.RegisteredGenerator rdf:resource=\"#" + RegisteredGenerator + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:RMRStartUpCostCurve rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RMRStartUpCostCurve>"
    }
}

object RMRStartUpCostCurve
extends
    Parseable[RMRStartUpCostCurve]
{
    val RegisteredGenerator = parse_attribute (attribute ("""RMRStartUpCostCurve.RegisteredGenerator"""))
    def parse (context: Context): RMRStartUpCostCurve =
    {
        RMRStartUpCostCurve(
            Curve.parse (context),
            RegisteredGenerator (context)
        )
    }
}

/**
 * Model to support processing of reliability must run units.
 * @param sup Reference to the superclass object.
 * @param RegisteredGenerator <em>undocumented</em>
 */
case class RMRStartUpEnergyCurve
(
    override val sup: Curve,
    RegisteredGenerator: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[RMRStartUpEnergyCurve] }
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
        (if (null != RegisteredGenerator) "\t\t<cim:RMRStartUpEnergyCurve.RegisteredGenerator rdf:resource=\"#" + RegisteredGenerator + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:RMRStartUpEnergyCurve rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RMRStartUpEnergyCurve>"
    }
}

object RMRStartUpEnergyCurve
extends
    Parseable[RMRStartUpEnergyCurve]
{
    val RegisteredGenerator = parse_attribute (attribute ("""RMRStartUpEnergyCurve.RegisteredGenerator"""))
    def parse (context: Context): RMRStartUpEnergyCurve =
    {
        RMRStartUpEnergyCurve(
            Curve.parse (context),
            RegisteredGenerator (context)
        )
    }
}

/**
 * Model to support processing of reliability must run units.
 * @param sup Reference to the superclass object.
 * @param RegisteredGenerator <em>undocumented</em>
 */
case class RMRStartUpFuelCurve
(
    override val sup: Curve,
    RegisteredGenerator: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[RMRStartUpFuelCurve] }
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
        (if (null != RegisteredGenerator) "\t\t<cim:RMRStartUpFuelCurve.RegisteredGenerator rdf:resource=\"#" + RegisteredGenerator + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:RMRStartUpFuelCurve rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RMRStartUpFuelCurve>"
    }
}

object RMRStartUpFuelCurve
extends
    Parseable[RMRStartUpFuelCurve]
{
    val RegisteredGenerator = parse_attribute (attribute ("""RMRStartUpFuelCurve.RegisteredGenerator"""))
    def parse (context: Context): RMRStartUpFuelCurve =
    {
        RMRStartUpFuelCurve(
            Curve.parse (context),
            RegisteredGenerator (context)
        )
    }
}

/**
 * Model to support processing of reliability must run units.
 * @param sup Reference to the superclass object.
 * @param RegisteredGenerator <em>undocumented</em>
 */
case class RMRStartUpTimeCurve
(
    override val sup: Curve,
    RegisteredGenerator: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[RMRStartUpTimeCurve] }
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
        (if (null != RegisteredGenerator) "\t\t<cim:RMRStartUpTimeCurve.RegisteredGenerator rdf:resource=\"#" + RegisteredGenerator + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:RMRStartUpTimeCurve rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RMRStartUpTimeCurve>"
    }
}

object RMRStartUpTimeCurve
extends
    Parseable[RMRStartUpTimeCurve]
{
    val RegisteredGenerator = parse_attribute (attribute ("""RMRStartUpTimeCurve.RegisteredGenerator"""))
    def parse (context: Context): RMRStartUpTimeCurve =
    {
        RMRStartUpTimeCurve(
            Curve.parse (context),
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
    override val sup: MktOrganisation
)
extends
    Element
{
    def this () = { this (null) }
    def MktOrganisation: MktOrganisation = sup.asInstanceOf[MktOrganisation]
    override def copy (): Row = { clone ().asInstanceOf[RTO] }
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
        "\t<cim:RTO rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RTO>"
    }
}

object RTO
extends
    Parseable[RTO]
{
    def parse (context: Context): RTO =
    {
        RTO(
            MktOrganisation.parse (context)
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
    override val sup: AggregateNode
)
extends
    Element
{
    def this () = { this (null) }
    def AggregateNode: AggregateNode = sup.asInstanceOf[AggregateNode]
    override def copy (): Row = { clone ().asInstanceOf[RUCZone] }
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
        "\t<cim:RUCZone rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RUCZone>"
    }
}

object RUCZone
extends
    Parseable[RUCZone]
{
    def parse (context: Context): RUCZone =
    {
        RUCZone(
            AggregateNode.parse (context)
        )
    }
}

/**
 * Model of a generator  that is registered to participate in the market
 * @param sup Reference to the superclass object.
 * @param capacityFactor Capacity Factor
 * @param coldStartTime Cold start time.
 * @param combinedCyclePlantName Name of the Combined Cycle Plant (valid for Combined Cyle modes or configurations)
 * @param commericialOperationDate <em>undocumented</em>
 * @param constrainedOutputFlag Constrained Output Generator (COG) Indicator (Yes/No), per Generating Resource
 * @param costBasis <em>undocumented</em>
 * @param extremeLongStart Some long-start up time units may need to receive start up instruction before DA market results are available.
 *        Long-Start resources may be either physical resources within the control with start-up times greater than 18 hours or the long-start contractual inter-tie commitment that shall be completed by 6 am one-day ahead.  Therefore, there is a need for a process to determine the commitment of such resources before the DA market.
 * @param fuelSource Values: Natural Gas Based Resource, Non Natural Gas Based Resource
 *        "NG" - Natural-Gas-Based Resource - a Resource that is powered by Natural Gas
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
 * @param lowerRampRate <em>undocumented</em>
 * @param maxDependableCap Maximum Dependable Capacity (MNDC).
 * @param maxLayOffSelfSchedQty <em>undocumented</em>
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
 * @param proxyFlag <em>undocumented</em>
 * @param pumpMinDownTime The minimum down time for the pump in a pump storage unit.
 * @param pumpMinUpTime The minimum up time aspect for the pump in a pump storage unit
 * @param pumpShutdownCost The cost to shutdown a pump during the pump aspect of a pump storage unit.
 * @param pumpShutdownTime The shutdown time (minutes) of the pump aspect of a pump storage unit.
 * @param pumpingCost <em>undocumented</em>
 * @param pumpingFactor Pumping factor for pump storage units, conversion factor between generating and pumping.
 * @param qualifyingFacilityOwner <em>undocumented</em>
 * @param quickStartFlag Quick start flag (Yes/No)
 * @param raiseControlRate Regulation up response rate in MW per minute
 * @param raiseRampRate <em>undocumented</em>
 * @param rampCurveType Ramp curve type:
 *        0 - Fixed ramp rate independent of rate function unit MW output
 *        1 - Static ramp rates as a function of unit MW output only
 *        2 - Dynamic ramp rates as a function of unit MW output and ramping time
 * @param rampMode Ramping mode
 *        0: ignore ramping limits
 *        1: 20-minute ramping rule
 *        2: 60-minute ramping rule
 * @param regulationFlag 0 = Unit is not on regulation
 *        1 = Unit is on AGC and regulating
 *        2 = Unit is suppose to be on regulation but it is not under regulation now
 * @param regulationRampRate For the outage scheduling services
 * @param resourceSubType CCGT90	Combined Cycle greater than 90 MW
 *        CCLE90	Combined Cycle less than or equal to 90 MW
 *        CLLIG	Coal and Lignite
 *        DSL	Diesel
 *        GASSTM	Gas-Steam
 *        GSNONR	Gas Steam Non-Reheat Boiler
 *        GSREH	Gas Steam Reheat Boiler
 *        GSSUP	Gas Steam Supercritical Boiler
 *        HYDRO	Hydro
 *        NUC	Nuclear
 *        RENEW	Renewable
 *        SCGT90	Simple Cycle greater than 90 MW
 *        SCLE90	Simple Cycle less than or equal to 90 MW
 *        WIND	Wind
 *        PS         Pumped Storage
 * @param riverSystem River System the Resource is tied to.
 * @param spinReserveRamp <em>undocumented</em>
 * @param syncCondCapable Is the Resource Synchronous Condenser capable Resource?
 * @param unitType Generating unit type: Combined Cycle, Gas Turbine, Hydro Turbine, Other, Photovoltaic, Hydro Pump-Turbine, Reciprocating Engine, Steam Turbine, Synchronous Condenser, Wind Turbine
 * @param useLimitFlag Use limit flag: indicates if the use-limited resource is fully scheduled (or has some slack for real-time dispatch) (Y/N)
 * @param EnergyPriceIndex <em>undocumented</em>
 * @param FuelCostCurve <em>undocumented</em>
 * @param FuelRegion <em>undocumented</em>
 * @param LocalReliabilityArea <em>undocumented</em>
 * @param MktHeatRateCurve <em>undocumented</em>
 * @param RMNRFlag Reliability must not run (RMNR) flag: indicated whether the RMR unit is set as an RMNR in the current market
 * @param RMRFlag Reliability must run (RMR) flag: indicates whether the unit is RMR; Indicates whether the unit is RMR:
 *        N' - not an RMR unit
 *        '1' - RMR Condition 1 unit
 *        '2' - RMR Condition 2 unit
 * @param RMRHeatRateCurve <em>undocumented</em>
 * @param RMRManualIndicator Indicates the RMR Manual pre-determination status [Y/N]
 * @param RMRStartUpCostCurve <em>undocumented</em>
 * @param RMRStartUpEnergyCurve <em>undocumented</em>
 * @param RMRStartUpFuelCurve <em>undocumented</em>
 * @param RMRStartUpTimeCurve <em>undocumented</em>
 * @param RMTFlag Reliability must take (RMT) flag (Yes/No): indicates whether the unit is RMT
 * @param RegulatingLimit <em>undocumented</em>
 * @param StartUpEnergyCurve <em>undocumented</em>
 * @param StartUpFuelCurve <em>undocumented</em>
 * @param StartUpTimeCurve <em>undocumented</em>
 */
case class RegisteredGenerator
(
    override val sup: RegisteredResource,
    capacityFactor: Double,
    coldStartTime: Double,
    combinedCyclePlantName: String,
    commericialOperationDate: String,
    constrainedOutputFlag: String,
    costBasis: String,
    extremeLongStart: String,
    fuelSource: String,
    highControlLimit: Double,
    hotIntTime: Double,
    hotStartTime: Double,
    intColdTime: Double,
    intStartTime: Double,
    intendedPIRP: String,
    loadFollowingDownMSS: String,
    loadFollowingUpMSS: String,
    lowControlLImit: Double,
    lowerControlRate: Double,
    lowerRampRate: Double,
    maxDependableCap: Double,
    maxLayOffSelfSchedQty: Double,
    maxMinLoadCost: Double,
    maxPumpingLevel: Double,
    maxShutdownTime: String,
    maxStartUpsPerDay: Int,
    maxWeeklyEnergy: Double,
    maxWeeklyStarts: Int,
    maximumAllowableSpinningReserve: Double,
    maximumOperatingMW: Double,
    minLoadCost: Double,
    minimumLoadFuelCost: String,
    minimumOperatingMW: Double,
    mustOfferRA: String,
    nameplateCapacity: Double,
    operatingMaintenanceCost: Double,
    operatingMode: String,
    proxyFlag: String,
    pumpMinDownTime: Double,
    pumpMinUpTime: Double,
    pumpShutdownCost: Double,
    pumpShutdownTime: Int,
    pumpingCost: Double,
    pumpingFactor: Double,
    qualifyingFacilityOwner: String,
    quickStartFlag: String,
    raiseControlRate: Double,
    raiseRampRate: Double,
    rampCurveType: String,
    rampMode: String,
    regulationFlag: Int,
    regulationRampRate: Double,
    resourceSubType: String,
    riverSystem: String,
    spinReserveRamp: Double,
    syncCondCapable: String,
    unitType: String,
    useLimitFlag: String,
    EnergyPriceIndex: String,
    FuelCostCurve: String,
    FuelRegion: String,
    LocalReliabilityArea: String,
    MktHeatRateCurve: String,
    RMNRFlag: String,
    RMRFlag: String,
    RMRHeatRateCurve: String,
    RMRManualIndicator: String,
    RMRStartUpCostCurve: String,
    RMRStartUpEnergyCurve: String,
    RMRStartUpFuelCurve: String,
    RMRStartUpTimeCurve: String,
    RMTFlag: String,
    RegulatingLimit: String,
    StartUpEnergyCurve: String,
    StartUpFuelCurve: String,
    StartUpTimeCurve: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null, null, null, null, null, null, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, 0, 0.0, 0, 0.0, 0.0, 0.0, null, 0.0, null, 0.0, 0.0, null, null, 0.0, 0.0, 0.0, 0, 0.0, 0.0, null, null, 0.0, 0.0, null, null, 0, 0.0, null, null, 0.0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def RegisteredResource: RegisteredResource = sup.asInstanceOf[RegisteredResource]
    override def copy (): Row = { clone ().asInstanceOf[RegisteredGenerator] }
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
        "\t\t<cim:RegisteredGenerator.capacityFactor>" + capacityFactor + "</cim:RegisteredGenerator.capacityFactor>\n" +
        "\t\t<cim:RegisteredGenerator.coldStartTime>" + coldStartTime + "</cim:RegisteredGenerator.coldStartTime>\n" +
        (if (null != combinedCyclePlantName) "\t\t<cim:RegisteredGenerator.combinedCyclePlantName>" + combinedCyclePlantName + "</cim:RegisteredGenerator.combinedCyclePlantName>\n" else "") +
        (if (null != commericialOperationDate) "\t\t<cim:RegisteredGenerator.commericialOperationDate>" + commericialOperationDate + "</cim:RegisteredGenerator.commericialOperationDate>\n" else "") +
        (if (null != constrainedOutputFlag) "\t\t<cim:RegisteredGenerator.constrainedOutputFlag rdf:resource=\"#" + constrainedOutputFlag + "\"/>\n" else "") +
        (if (null != costBasis) "\t\t<cim:RegisteredGenerator.costBasis rdf:resource=\"#" + costBasis + "\"/>\n" else "") +
        (if (null != extremeLongStart) "\t\t<cim:RegisteredGenerator.extremeLongStart rdf:resource=\"#" + extremeLongStart + "\"/>\n" else "") +
        (if (null != fuelSource) "\t\t<cim:RegisteredGenerator.fuelSource rdf:resource=\"#" + fuelSource + "\"/>\n" else "") +
        "\t\t<cim:RegisteredGenerator.highControlLimit>" + highControlLimit + "</cim:RegisteredGenerator.highControlLimit>\n" +
        "\t\t<cim:RegisteredGenerator.hotIntTime>" + hotIntTime + "</cim:RegisteredGenerator.hotIntTime>\n" +
        "\t\t<cim:RegisteredGenerator.hotStartTime>" + hotStartTime + "</cim:RegisteredGenerator.hotStartTime>\n" +
        "\t\t<cim:RegisteredGenerator.intColdTime>" + intColdTime + "</cim:RegisteredGenerator.intColdTime>\n" +
        "\t\t<cim:RegisteredGenerator.intStartTime>" + intStartTime + "</cim:RegisteredGenerator.intStartTime>\n" +
        (if (null != intendedPIRP) "\t\t<cim:RegisteredGenerator.intendedPIRP rdf:resource=\"#" + intendedPIRP + "\"/>\n" else "") +
        (if (null != loadFollowingDownMSS) "\t\t<cim:RegisteredGenerator.loadFollowingDownMSS rdf:resource=\"#" + loadFollowingDownMSS + "\"/>\n" else "") +
        (if (null != loadFollowingUpMSS) "\t\t<cim:RegisteredGenerator.loadFollowingUpMSS rdf:resource=\"#" + loadFollowingUpMSS + "\"/>\n" else "") +
        "\t\t<cim:RegisteredGenerator.lowControlLImit>" + lowControlLImit + "</cim:RegisteredGenerator.lowControlLImit>\n" +
        "\t\t<cim:RegisteredGenerator.lowerControlRate>" + lowerControlRate + "</cim:RegisteredGenerator.lowerControlRate>\n" +
        "\t\t<cim:RegisteredGenerator.lowerRampRate>" + lowerRampRate + "</cim:RegisteredGenerator.lowerRampRate>\n" +
        "\t\t<cim:RegisteredGenerator.maxDependableCap>" + maxDependableCap + "</cim:RegisteredGenerator.maxDependableCap>\n" +
        "\t\t<cim:RegisteredGenerator.maxLayOffSelfSchedQty>" + maxLayOffSelfSchedQty + "</cim:RegisteredGenerator.maxLayOffSelfSchedQty>\n" +
        "\t\t<cim:RegisteredGenerator.maxMinLoadCost>" + maxMinLoadCost + "</cim:RegisteredGenerator.maxMinLoadCost>\n" +
        "\t\t<cim:RegisteredGenerator.maxPumpingLevel>" + maxPumpingLevel + "</cim:RegisteredGenerator.maxPumpingLevel>\n" +
        (if (null != maxShutdownTime) "\t\t<cim:RegisteredGenerator.maxShutdownTime>" + maxShutdownTime + "</cim:RegisteredGenerator.maxShutdownTime>\n" else "") +
        "\t\t<cim:RegisteredGenerator.maxStartUpsPerDay>" + maxStartUpsPerDay + "</cim:RegisteredGenerator.maxStartUpsPerDay>\n" +
        "\t\t<cim:RegisteredGenerator.maxWeeklyEnergy>" + maxWeeklyEnergy + "</cim:RegisteredGenerator.maxWeeklyEnergy>\n" +
        "\t\t<cim:RegisteredGenerator.maxWeeklyStarts>" + maxWeeklyStarts + "</cim:RegisteredGenerator.maxWeeklyStarts>\n" +
        "\t\t<cim:RegisteredGenerator.maximumAllowableSpinningReserve>" + maximumAllowableSpinningReserve + "</cim:RegisteredGenerator.maximumAllowableSpinningReserve>\n" +
        "\t\t<cim:RegisteredGenerator.maximumOperatingMW>" + maximumOperatingMW + "</cim:RegisteredGenerator.maximumOperatingMW>\n" +
        "\t\t<cim:RegisteredGenerator.minLoadCost>" + minLoadCost + "</cim:RegisteredGenerator.minLoadCost>\n" +
        (if (null != minimumLoadFuelCost) "\t\t<cim:RegisteredGenerator.minimumLoadFuelCost rdf:resource=\"#" + minimumLoadFuelCost + "\"/>\n" else "") +
        "\t\t<cim:RegisteredGenerator.minimumOperatingMW>" + minimumOperatingMW + "</cim:RegisteredGenerator.minimumOperatingMW>\n" +
        (if (null != mustOfferRA) "\t\t<cim:RegisteredGenerator.mustOfferRA rdf:resource=\"#" + mustOfferRA + "\"/>\n" else "") +
        "\t\t<cim:RegisteredGenerator.nameplateCapacity>" + nameplateCapacity + "</cim:RegisteredGenerator.nameplateCapacity>\n" +
        "\t\t<cim:RegisteredGenerator.operatingMaintenanceCost>" + operatingMaintenanceCost + "</cim:RegisteredGenerator.operatingMaintenanceCost>\n" +
        (if (null != operatingMode) "\t\t<cim:RegisteredGenerator.operatingMode>" + operatingMode + "</cim:RegisteredGenerator.operatingMode>\n" else "") +
        (if (null != proxyFlag) "\t\t<cim:RegisteredGenerator.proxyFlag rdf:resource=\"#" + proxyFlag + "\"/>\n" else "") +
        "\t\t<cim:RegisteredGenerator.pumpMinDownTime>" + pumpMinDownTime + "</cim:RegisteredGenerator.pumpMinDownTime>\n" +
        "\t\t<cim:RegisteredGenerator.pumpMinUpTime>" + pumpMinUpTime + "</cim:RegisteredGenerator.pumpMinUpTime>\n" +
        "\t\t<cim:RegisteredGenerator.pumpShutdownCost>" + pumpShutdownCost + "</cim:RegisteredGenerator.pumpShutdownCost>\n" +
        "\t\t<cim:RegisteredGenerator.pumpShutdownTime>" + pumpShutdownTime + "</cim:RegisteredGenerator.pumpShutdownTime>\n" +
        "\t\t<cim:RegisteredGenerator.pumpingCost>" + pumpingCost + "</cim:RegisteredGenerator.pumpingCost>\n" +
        "\t\t<cim:RegisteredGenerator.pumpingFactor>" + pumpingFactor + "</cim:RegisteredGenerator.pumpingFactor>\n" +
        (if (null != qualifyingFacilityOwner) "\t\t<cim:RegisteredGenerator.qualifyingFacilityOwner>" + qualifyingFacilityOwner + "</cim:RegisteredGenerator.qualifyingFacilityOwner>\n" else "") +
        (if (null != quickStartFlag) "\t\t<cim:RegisteredGenerator.quickStartFlag rdf:resource=\"#" + quickStartFlag + "\"/>\n" else "") +
        "\t\t<cim:RegisteredGenerator.raiseControlRate>" + raiseControlRate + "</cim:RegisteredGenerator.raiseControlRate>\n" +
        "\t\t<cim:RegisteredGenerator.raiseRampRate>" + raiseRampRate + "</cim:RegisteredGenerator.raiseRampRate>\n" +
        (if (null != rampCurveType) "\t\t<cim:RegisteredGenerator.rampCurveType rdf:resource=\"#" + rampCurveType + "\"/>\n" else "") +
        (if (null != rampMode) "\t\t<cim:RegisteredGenerator.rampMode rdf:resource=\"#" + rampMode + "\"/>\n" else "") +
        "\t\t<cim:RegisteredGenerator.regulationFlag>" + regulationFlag + "</cim:RegisteredGenerator.regulationFlag>\n" +
        "\t\t<cim:RegisteredGenerator.regulationRampRate>" + regulationRampRate + "</cim:RegisteredGenerator.regulationRampRate>\n" +
        (if (null != resourceSubType) "\t\t<cim:RegisteredGenerator.resourceSubType>" + resourceSubType + "</cim:RegisteredGenerator.resourceSubType>\n" else "") +
        (if (null != riverSystem) "\t\t<cim:RegisteredGenerator.riverSystem>" + riverSystem + "</cim:RegisteredGenerator.riverSystem>\n" else "") +
        "\t\t<cim:RegisteredGenerator.spinReserveRamp>" + spinReserveRamp + "</cim:RegisteredGenerator.spinReserveRamp>\n" +
        (if (null != syncCondCapable) "\t\t<cim:RegisteredGenerator.syncCondCapable rdf:resource=\"#" + syncCondCapable + "\"/>\n" else "") +
        (if (null != unitType) "\t\t<cim:RegisteredGenerator.unitType rdf:resource=\"#" + unitType + "\"/>\n" else "") +
        (if (null != useLimitFlag) "\t\t<cim:RegisteredGenerator.useLimitFlag rdf:resource=\"#" + useLimitFlag + "\"/>\n" else "") +
        (if (null != EnergyPriceIndex) "\t\t<cim:RegisteredGenerator.EnergyPriceIndex rdf:resource=\"#" + EnergyPriceIndex + "\"/>\n" else "") +
        (if (null != FuelCostCurve) "\t\t<cim:RegisteredGenerator.FuelCostCurve rdf:resource=\"#" + FuelCostCurve + "\"/>\n" else "") +
        (if (null != FuelRegion) "\t\t<cim:RegisteredGenerator.FuelRegion rdf:resource=\"#" + FuelRegion + "\"/>\n" else "") +
        (if (null != LocalReliabilityArea) "\t\t<cim:RegisteredGenerator.LocalReliabilityArea rdf:resource=\"#" + LocalReliabilityArea + "\"/>\n" else "") +
        (if (null != MktHeatRateCurve) "\t\t<cim:RegisteredGenerator.MktHeatRateCurve rdf:resource=\"#" + MktHeatRateCurve + "\"/>\n" else "") +
        (if (null != RMNRFlag) "\t\t<cim:RegisteredGenerator.RMNRFlag rdf:resource=\"#" + RMNRFlag + "\"/>\n" else "") +
        (if (null != RMRFlag) "\t\t<cim:RegisteredGenerator.RMRFlag rdf:resource=\"#" + RMRFlag + "\"/>\n" else "") +
        (if (null != RMRHeatRateCurve) "\t\t<cim:RegisteredGenerator.RMRHeatRateCurve rdf:resource=\"#" + RMRHeatRateCurve + "\"/>\n" else "") +
        (if (null != RMRManualIndicator) "\t\t<cim:RegisteredGenerator.RMRManualIndicator rdf:resource=\"#" + RMRManualIndicator + "\"/>\n" else "") +
        (if (null != RMRStartUpCostCurve) "\t\t<cim:RegisteredGenerator.RMRStartUpCostCurve rdf:resource=\"#" + RMRStartUpCostCurve + "\"/>\n" else "") +
        (if (null != RMRStartUpEnergyCurve) "\t\t<cim:RegisteredGenerator.RMRStartUpEnergyCurve rdf:resource=\"#" + RMRStartUpEnergyCurve + "\"/>\n" else "") +
        (if (null != RMRStartUpFuelCurve) "\t\t<cim:RegisteredGenerator.RMRStartUpFuelCurve rdf:resource=\"#" + RMRStartUpFuelCurve + "\"/>\n" else "") +
        (if (null != RMRStartUpTimeCurve) "\t\t<cim:RegisteredGenerator.RMRStartUpTimeCurve rdf:resource=\"#" + RMRStartUpTimeCurve + "\"/>\n" else "") +
        (if (null != RMTFlag) "\t\t<cim:RegisteredGenerator.RMTFlag rdf:resource=\"#" + RMTFlag + "\"/>\n" else "") +
        (if (null != RegulatingLimit) "\t\t<cim:RegisteredGenerator.RegulatingLimit rdf:resource=\"#" + RegulatingLimit + "\"/>\n" else "") +
        (if (null != StartUpEnergyCurve) "\t\t<cim:RegisteredGenerator.StartUpEnergyCurve rdf:resource=\"#" + StartUpEnergyCurve + "\"/>\n" else "") +
        (if (null != StartUpFuelCurve) "\t\t<cim:RegisteredGenerator.StartUpFuelCurve rdf:resource=\"#" + StartUpFuelCurve + "\"/>\n" else "") +
        (if (null != StartUpTimeCurve) "\t\t<cim:RegisteredGenerator.StartUpTimeCurve rdf:resource=\"#" + StartUpTimeCurve + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:RegisteredGenerator rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RegisteredGenerator>"
    }
}

object RegisteredGenerator
extends
    Parseable[RegisteredGenerator]
{
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
            RegisteredResource.parse (context),
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
 * @param Flowgate <em>undocumented</em>
 * @param InterTieBid <em>undocumented</em>
 */
case class RegisteredInterTie
(
    override val sup: RegisteredResource,
    direction: String,
    energyProductType: String,
    isDCTie: String,
    isDynamicInterchange: String,
    minHourlyBlockLimit: Int,
    Flowgate: String,
    InterTieBid: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, 0, null, null) }
    def RegisteredResource: RegisteredResource = sup.asInstanceOf[RegisteredResource]
    override def copy (): Row = { clone ().asInstanceOf[RegisteredInterTie] }
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
        (if (null != direction) "\t\t<cim:RegisteredInterTie.direction rdf:resource=\"#" + direction + "\"/>\n" else "") +
        (if (null != energyProductType) "\t\t<cim:RegisteredInterTie.energyProductType rdf:resource=\"#" + energyProductType + "\"/>\n" else "") +
        (if (null != isDCTie) "\t\t<cim:RegisteredInterTie.isDCTie rdf:resource=\"#" + isDCTie + "\"/>\n" else "") +
        (if (null != isDynamicInterchange) "\t\t<cim:RegisteredInterTie.isDynamicInterchange rdf:resource=\"#" + isDynamicInterchange + "\"/>\n" else "") +
        "\t\t<cim:RegisteredInterTie.minHourlyBlockLimit>" + minHourlyBlockLimit + "</cim:RegisteredInterTie.minHourlyBlockLimit>\n" +
        (if (null != Flowgate) "\t\t<cim:RegisteredInterTie.Flowgate rdf:resource=\"#" + Flowgate + "\"/>\n" else "") +
        (if (null != InterTieBid) "\t\t<cim:RegisteredInterTie.InterTieBid rdf:resource=\"#" + InterTieBid + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:RegisteredInterTie rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RegisteredInterTie>"
    }
}

object RegisteredInterTie
extends
    Parseable[RegisteredInterTie]
{
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
            RegisteredResource.parse (context),
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
 * @param LoadReductionPriceCurve <em>undocumented</em>
 * @param LoadReductionTimeCurve <em>undocumented</em>
 * @param MktLoadArea <em>undocumented</em>
 * @param NPLCustomLoadAggregation A Non-Participating Load Resource aggregation scheme with resource-specific Distribution Factors that are submitted with the Bid and for which the distributed Energy is settled at the relevant Distribution Location marginal prices.
 */
case class RegisteredLoad
(
    override val sup: RegisteredResource,
    blockLoadTransferFlag: String,
    dynamicallyScheduledLoadResourceFlag: String,
    dynamicallyScheduledQualificationFlag: String,
    loadRegistryMSS: String,
    maxBaseLoad: Double,
    maxDeploymentTime: Double,
    maxLoadRedTimesPerDay: Int,
    maxLoadReduction: Double,
    maxReductionTime: Double,
    maxWeeklyDeployment: Int,
    minLoadReduction: Double,
    minLoadReductionCost: Double,
    minLoadReductionInterval: Double,
    minReductionTime: Double,
    minTimeBetLoadRed: Double,
    participatingLoad: String,
    reqNoticeTime: Double,
    resourceSubType: String,
    LoadReductionPriceCurve: List[String],
    LoadReductionTimeCurve: List[String],
    MktLoadArea: String,
    NPLCustomLoadAggregation: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, 0.0, 0.0, 0, 0.0, 0.0, 0, 0.0, 0.0, 0.0, 0.0, 0.0, null, 0.0, null, List(), List(), null, null) }
    def RegisteredResource: RegisteredResource = sup.asInstanceOf[RegisteredResource]
    override def copy (): Row = { clone ().asInstanceOf[RegisteredLoad] }
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
        (if (null != blockLoadTransferFlag) "\t\t<cim:RegisteredLoad.blockLoadTransferFlag rdf:resource=\"#" + blockLoadTransferFlag + "\"/>\n" else "") +
        (if (null != dynamicallyScheduledLoadResourceFlag) "\t\t<cim:RegisteredLoad.dynamicallyScheduledLoadResourceFlag rdf:resource=\"#" + dynamicallyScheduledLoadResourceFlag + "\"/>\n" else "") +
        (if (null != dynamicallyScheduledQualificationFlag) "\t\t<cim:RegisteredLoad.dynamicallyScheduledQualificationFlag rdf:resource=\"#" + dynamicallyScheduledQualificationFlag + "\"/>\n" else "") +
        (if (null != loadRegistryMSS) "\t\t<cim:RegisteredLoad.loadRegistryMSS rdf:resource=\"#" + loadRegistryMSS + "\"/>\n" else "") +
        "\t\t<cim:RegisteredLoad.maxBaseLoad>" + maxBaseLoad + "</cim:RegisteredLoad.maxBaseLoad>\n" +
        "\t\t<cim:RegisteredLoad.maxDeploymentTime>" + maxDeploymentTime + "</cim:RegisteredLoad.maxDeploymentTime>\n" +
        "\t\t<cim:RegisteredLoad.maxLoadRedTimesPerDay>" + maxLoadRedTimesPerDay + "</cim:RegisteredLoad.maxLoadRedTimesPerDay>\n" +
        "\t\t<cim:RegisteredLoad.maxLoadReduction>" + maxLoadReduction + "</cim:RegisteredLoad.maxLoadReduction>\n" +
        "\t\t<cim:RegisteredLoad.maxReductionTime>" + maxReductionTime + "</cim:RegisteredLoad.maxReductionTime>\n" +
        "\t\t<cim:RegisteredLoad.maxWeeklyDeployment>" + maxWeeklyDeployment + "</cim:RegisteredLoad.maxWeeklyDeployment>\n" +
        "\t\t<cim:RegisteredLoad.minLoadReduction>" + minLoadReduction + "</cim:RegisteredLoad.minLoadReduction>\n" +
        "\t\t<cim:RegisteredLoad.minLoadReductionCost>" + minLoadReductionCost + "</cim:RegisteredLoad.minLoadReductionCost>\n" +
        "\t\t<cim:RegisteredLoad.minLoadReductionInterval>" + minLoadReductionInterval + "</cim:RegisteredLoad.minLoadReductionInterval>\n" +
        "\t\t<cim:RegisteredLoad.minReductionTime>" + minReductionTime + "</cim:RegisteredLoad.minReductionTime>\n" +
        "\t\t<cim:RegisteredLoad.minTimeBetLoadRed>" + minTimeBetLoadRed + "</cim:RegisteredLoad.minTimeBetLoadRed>\n" +
        (if (null != participatingLoad) "\t\t<cim:RegisteredLoad.participatingLoad rdf:resource=\"#" + participatingLoad + "\"/>\n" else "") +
        "\t\t<cim:RegisteredLoad.reqNoticeTime>" + reqNoticeTime + "</cim:RegisteredLoad.reqNoticeTime>\n" +
        (if (null != resourceSubType) "\t\t<cim:RegisteredLoad.resourceSubType>" + resourceSubType + "</cim:RegisteredLoad.resourceSubType>\n" else "") +
        (if (null != LoadReductionPriceCurve) LoadReductionPriceCurve.map (x => "\t\t<cim:RegisteredLoad.LoadReductionPriceCurve rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != LoadReductionTimeCurve) LoadReductionTimeCurve.map (x => "\t\t<cim:RegisteredLoad.LoadReductionTimeCurve rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != MktLoadArea) "\t\t<cim:RegisteredLoad.MktLoadArea rdf:resource=\"#" + MktLoadArea + "\"/>\n" else "") +
        (if (null != NPLCustomLoadAggregation) "\t\t<cim:RegisteredLoad.NPLCustomLoadAggregation rdf:resource=\"#" + NPLCustomLoadAggregation + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:RegisteredLoad rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RegisteredLoad>"
    }
}

object RegisteredLoad
extends
    Parseable[RegisteredLoad]
{
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
            RegisteredResource.parse (context),
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
 * @param highLimit <em>undocumented</em>
 * @param lowLimit <em>undocumented</em>
 * @param RegisteredGenerator <em>undocumented</em>
 */
case class RegulatingLimit
(
    override val sup: IdentifiedObject,
    highLimit: Double,
    lowLimit: Double,
    RegisteredGenerator: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[RegulatingLimit] }
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
        "\t\t<cim:RegulatingLimit.highLimit>" + highLimit + "</cim:RegulatingLimit.highLimit>\n" +
        "\t\t<cim:RegulatingLimit.lowLimit>" + lowLimit + "</cim:RegulatingLimit.lowLimit>\n" +
        (if (null != RegisteredGenerator) "\t\t<cim:RegulatingLimit.RegisteredGenerator rdf:resource=\"#" + RegisteredGenerator + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:RegulatingLimit rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RegulatingLimit>"
    }
}

object RegulatingLimit
extends
    Parseable[RegulatingLimit]
{
    val highLimit = parse_element (element ("""RegulatingLimit.highLimit"""))
    val lowLimit = parse_element (element ("""RegulatingLimit.lowLimit"""))
    val RegisteredGenerator = parse_attribute (attribute ("""RegulatingLimit.RegisteredGenerator"""))
    def parse (context: Context): RegulatingLimit =
    {
        RegulatingLimit(
            IdentifiedObject.parse (context),
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
    override val sup: BasicElement,
    certifiedCapacity: Double,
    endEffectiveDate: String,
    market: String,
    qualificationFlag: String,
    startEffectiveDate: String,
    typ: String,
    RegisteredResource: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ResourceAncillaryServiceQualification] }
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
        "\t\t<cim:ResourceAncillaryServiceQualification.certifiedCapacity>" + certifiedCapacity + "</cim:ResourceAncillaryServiceQualification.certifiedCapacity>\n" +
        (if (null != endEffectiveDate) "\t\t<cim:ResourceAncillaryServiceQualification.endEffectiveDate>" + endEffectiveDate + "</cim:ResourceAncillaryServiceQualification.endEffectiveDate>\n" else "") +
        (if (null != market) "\t\t<cim:ResourceAncillaryServiceQualification.market rdf:resource=\"#" + market + "\"/>\n" else "") +
        (if (null != qualificationFlag) "\t\t<cim:ResourceAncillaryServiceQualification.qualificationFlag rdf:resource=\"#" + qualificationFlag + "\"/>\n" else "") +
        (if (null != startEffectiveDate) "\t\t<cim:ResourceAncillaryServiceQualification.startEffectiveDate>" + startEffectiveDate + "</cim:ResourceAncillaryServiceQualification.startEffectiveDate>\n" else "") +
        (if (null != typ) "\t\t<cim:ResourceAncillaryServiceQualification.type rdf:resource=\"#" + typ + "\"/>\n" else "") +
        (if (null != RegisteredResource) "\t\t<cim:ResourceAncillaryServiceQualification.RegisteredResource rdf:resource=\"#" + RegisteredResource + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ResourceAncillaryServiceQualification rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ResourceAncillaryServiceQualification>"
    }
}

object ResourceAncillaryServiceQualification
extends
    Parseable[ResourceAncillaryServiceQualification]
{
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
            BasicElement.parse (context),
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
 */
case class ResourceCapacity
(
    override val sup: BasicElement,
    capacityType: String,
    defaultCapacity: Double,
    maximumCapacity: Double,
    minimumCapacity: Double
)
extends
    Element
{
    def this () = { this (null, null, 0.0, 0.0, 0.0) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ResourceCapacity] }
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
        (if (null != capacityType) "\t\t<cim:ResourceCapacity.capacityType rdf:resource=\"#" + capacityType + "\"/>\n" else "") +
        "\t\t<cim:ResourceCapacity.defaultCapacity>" + defaultCapacity + "</cim:ResourceCapacity.defaultCapacity>\n" +
        "\t\t<cim:ResourceCapacity.maximumCapacity>" + maximumCapacity + "</cim:ResourceCapacity.maximumCapacity>\n" +
        "\t\t<cim:ResourceCapacity.minimumCapacity>" + minimumCapacity + "</cim:ResourceCapacity.minimumCapacity>\n"
    }
    override def export: String =
    {
        "\t<cim:ResourceCapacity rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ResourceCapacity>"
    }
}

object ResourceCapacity
extends
    Parseable[ResourceCapacity]
{
    val capacityType = parse_attribute (attribute ("""ResourceCapacity.capacityType"""))
    val defaultCapacity = parse_element (element ("""ResourceCapacity.defaultCapacity"""))
    val maximumCapacity = parse_element (element ("""ResourceCapacity.maximumCapacity"""))
    val minimumCapacity = parse_element (element ("""ResourceCapacity.minimumCapacity"""))
    def parse (context: Context): ResourceCapacity =
    {
        ResourceCapacity(
            BasicElement.parse (context),
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
 * @param omCostColdStartup Verifiable O&amp;M Cost (\$), Cold Startup
 * @param omCostHotStartup Verifiable O&amp;M Cost (\$), Hot Startup
 * @param omCostIntermediateStartup Verifiable O&amp;M Cost (\$), Intermediate Startup
 * @param omCostLowSustainedLimit Verifiable O&amp;M Cost (\$/MWh), LSL
 * @param solidfuelPercentAboveLowSustainedLimit Percentage of Solid Fuel for operating above Low Sustained Limit (LSL)
 * @param ResourceVerifiableCosts <em>undocumented</em>
 */
case class ResourceOperationMaintenanceCost
(
    override val sup: Curve,
    gasPercentAboveLowSustainedLimit: Double,
    oilPercentAboveLowSustainedLimit: Double,
    omCostColdStartup: Double,
    omCostHotStartup: Double,
    omCostIntermediateStartup: Double,
    omCostLowSustainedLimit: Double,
    solidfuelPercentAboveLowSustainedLimit: Double,
    ResourceVerifiableCosts: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[ResourceOperationMaintenanceCost] }
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
        "\t\t<cim:ResourceOperationMaintenanceCost.gasPercentAboveLowSustainedLimit>" + gasPercentAboveLowSustainedLimit + "</cim:ResourceOperationMaintenanceCost.gasPercentAboveLowSustainedLimit>\n" +
        "\t\t<cim:ResourceOperationMaintenanceCost.oilPercentAboveLowSustainedLimit>" + oilPercentAboveLowSustainedLimit + "</cim:ResourceOperationMaintenanceCost.oilPercentAboveLowSustainedLimit>\n" +
        "\t\t<cim:ResourceOperationMaintenanceCost.omCostColdStartup>" + omCostColdStartup + "</cim:ResourceOperationMaintenanceCost.omCostColdStartup>\n" +
        "\t\t<cim:ResourceOperationMaintenanceCost.omCostHotStartup>" + omCostHotStartup + "</cim:ResourceOperationMaintenanceCost.omCostHotStartup>\n" +
        "\t\t<cim:ResourceOperationMaintenanceCost.omCostIntermediateStartup>" + omCostIntermediateStartup + "</cim:ResourceOperationMaintenanceCost.omCostIntermediateStartup>\n" +
        "\t\t<cim:ResourceOperationMaintenanceCost.omCostLowSustainedLimit>" + omCostLowSustainedLimit + "</cim:ResourceOperationMaintenanceCost.omCostLowSustainedLimit>\n" +
        "\t\t<cim:ResourceOperationMaintenanceCost.solidfuelPercentAboveLowSustainedLimit>" + solidfuelPercentAboveLowSustainedLimit + "</cim:ResourceOperationMaintenanceCost.solidfuelPercentAboveLowSustainedLimit>\n" +
        (if (null != ResourceVerifiableCosts) "\t\t<cim:ResourceOperationMaintenanceCost.ResourceVerifiableCosts rdf:resource=\"#" + ResourceVerifiableCosts + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ResourceOperationMaintenanceCost rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ResourceOperationMaintenanceCost>"
    }
}

object ResourceOperationMaintenanceCost
extends
    Parseable[ResourceOperationMaintenanceCost]
{
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
            Curve.parse (context),
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
 * @param ResourceVerifiableCosts <em>undocumented</em>
 */
case class ResourceStartupCost
(
    override val sup: BasicElement,
    fuelColdStartup: Double,
    fuelHotStartup: Double,
    fuelIntermediateStartup: Double,
    fuelLowSustainedLimit: Double,
    gasPercentColdStartup: Double,
    gasPercentHotStartup: Double,
    gasPercentIntermediateStartup: Double,
    gasPercentLowSustainedLimit: Double,
    oilPercentColdStartup: Double,
    oilPercentHotStartup: Double,
    oilPercentIntermediateStartup: Double,
    oilPercentLowSustainedLimit: Double,
    solidfuelPercentColdStartup: Double,
    solidfuelPercentHotStartup: Double,
    solidfuelPercentIntermediateStartup: Double,
    solidfuelPercentLowSustainedLimit: Double,
    ResourceVerifiableCosts: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ResourceStartupCost] }
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
        "\t\t<cim:ResourceStartupCost.fuelColdStartup>" + fuelColdStartup + "</cim:ResourceStartupCost.fuelColdStartup>\n" +
        "\t\t<cim:ResourceStartupCost.fuelHotStartup>" + fuelHotStartup + "</cim:ResourceStartupCost.fuelHotStartup>\n" +
        "\t\t<cim:ResourceStartupCost.fuelIntermediateStartup>" + fuelIntermediateStartup + "</cim:ResourceStartupCost.fuelIntermediateStartup>\n" +
        "\t\t<cim:ResourceStartupCost.fuelLowSustainedLimit>" + fuelLowSustainedLimit + "</cim:ResourceStartupCost.fuelLowSustainedLimit>\n" +
        "\t\t<cim:ResourceStartupCost.gasPercentColdStartup>" + gasPercentColdStartup + "</cim:ResourceStartupCost.gasPercentColdStartup>\n" +
        "\t\t<cim:ResourceStartupCost.gasPercentHotStartup>" + gasPercentHotStartup + "</cim:ResourceStartupCost.gasPercentHotStartup>\n" +
        "\t\t<cim:ResourceStartupCost.gasPercentIntermediateStartup>" + gasPercentIntermediateStartup + "</cim:ResourceStartupCost.gasPercentIntermediateStartup>\n" +
        "\t\t<cim:ResourceStartupCost.gasPercentLowSustainedLimit>" + gasPercentLowSustainedLimit + "</cim:ResourceStartupCost.gasPercentLowSustainedLimit>\n" +
        "\t\t<cim:ResourceStartupCost.oilPercentColdStartup>" + oilPercentColdStartup + "</cim:ResourceStartupCost.oilPercentColdStartup>\n" +
        "\t\t<cim:ResourceStartupCost.oilPercentHotStartup>" + oilPercentHotStartup + "</cim:ResourceStartupCost.oilPercentHotStartup>\n" +
        "\t\t<cim:ResourceStartupCost.oilPercentIntermediateStartup>" + oilPercentIntermediateStartup + "</cim:ResourceStartupCost.oilPercentIntermediateStartup>\n" +
        "\t\t<cim:ResourceStartupCost.oilPercentLowSustainedLimit>" + oilPercentLowSustainedLimit + "</cim:ResourceStartupCost.oilPercentLowSustainedLimit>\n" +
        "\t\t<cim:ResourceStartupCost.solidfuelPercentColdStartup>" + solidfuelPercentColdStartup + "</cim:ResourceStartupCost.solidfuelPercentColdStartup>\n" +
        "\t\t<cim:ResourceStartupCost.solidfuelPercentHotStartup>" + solidfuelPercentHotStartup + "</cim:ResourceStartupCost.solidfuelPercentHotStartup>\n" +
        "\t\t<cim:ResourceStartupCost.solidfuelPercentIntermediateStartup>" + solidfuelPercentIntermediateStartup + "</cim:ResourceStartupCost.solidfuelPercentIntermediateStartup>\n" +
        "\t\t<cim:ResourceStartupCost.solidfuelPercentLowSustainedLimit>" + solidfuelPercentLowSustainedLimit + "</cim:ResourceStartupCost.solidfuelPercentLowSustainedLimit>\n" +
        (if (null != ResourceVerifiableCosts) "\t\t<cim:ResourceStartupCost.ResourceVerifiableCosts rdf:resource=\"#" + ResourceVerifiableCosts + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ResourceStartupCost rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ResourceStartupCost>"
    }
}

object ResourceStartupCost
extends
    Parseable[ResourceStartupCost]
{
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
    val ResourceVerifiableCosts = parse_attribute (attribute ("""ResourceStartupCost.ResourceVerifiableCosts"""))
    def parse (context: Context): ResourceStartupCost =
    {
        ResourceStartupCost(
            BasicElement.parse (context),
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
            toDouble (solidfuelPercentLowSustainedLimit (context), context),
            ResourceVerifiableCosts (context)
        )
    }
}

/**
 * This class is defined to describe the verifiable costs associated with a generation resource.
 * @param sup Reference to the superclass object.
 * @param MktHeatRateCurve <em>undocumented</em>
 * @param RegisteredResource <em>undocumented</em>
 * @param ResourceOperationMaintenanceCost <em>undocumented</em>
 */
case class ResourceVerifiableCosts
(
    override val sup: BasicElement,
    MktHeatRateCurve: String,
    RegisteredResource: String,
    ResourceOperationMaintenanceCost: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ResourceVerifiableCosts] }
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
        (if (null != MktHeatRateCurve) "\t\t<cim:ResourceVerifiableCosts.MktHeatRateCurve rdf:resource=\"#" + MktHeatRateCurve + "\"/>\n" else "") +
        (if (null != RegisteredResource) "\t\t<cim:ResourceVerifiableCosts.RegisteredResource rdf:resource=\"#" + RegisteredResource + "\"/>\n" else "") +
        (if (null != ResourceOperationMaintenanceCost) "\t\t<cim:ResourceVerifiableCosts.ResourceOperationMaintenanceCost rdf:resource=\"#" + ResourceOperationMaintenanceCost + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ResourceVerifiableCosts rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ResourceVerifiableCosts>"
    }
}

object ResourceVerifiableCosts
extends
    Parseable[ResourceVerifiableCosts]
{
    val MktHeatRateCurve = parse_attribute (attribute ("""ResourceVerifiableCosts.MktHeatRateCurve"""))
    val RegisteredResource = parse_attribute (attribute ("""ResourceVerifiableCosts.RegisteredResource"""))
    val ResourceOperationMaintenanceCost = parse_attribute (attribute ("""ResourceVerifiableCosts.ResourceOperationMaintenanceCost"""))
    def parse (context: Context): ResourceVerifiableCosts =
    {
        ResourceVerifiableCosts(
            BasicElement.parse (context),
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
 * @param LoadRatio <em>undocumented</em>
 * @param MktOrgansation <em>undocumented</em>
 */
case class SchedulingCoordinator
(
    override val sup: MktOrganisation,
    scid: String,
    LoadRatio: String,
    MktOrgansation: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def MktOrganisation: MktOrganisation = sup.asInstanceOf[MktOrganisation]
    override def copy (): Row = { clone ().asInstanceOf[SchedulingCoordinator] }
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
        (if (null != scid) "\t\t<cim:SchedulingCoordinator.scid>" + scid + "</cim:SchedulingCoordinator.scid>\n" else "") +
        (if (null != LoadRatio) "\t\t<cim:SchedulingCoordinator.LoadRatio rdf:resource=\"#" + LoadRatio + "\"/>\n" else "") +
        (if (null != MktOrgansation) "\t\t<cim:SchedulingCoordinator.MktOrgansation rdf:resource=\"#" + MktOrgansation + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SchedulingCoordinator rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SchedulingCoordinator>"
    }
}

object SchedulingCoordinator
extends
    Parseable[SchedulingCoordinator]
{
    val scid = parse_element (element ("""SchedulingCoordinator.scid"""))
    val LoadRatio = parse_attribute (attribute ("""SchedulingCoordinator.LoadRatio"""))
    val MktOrgansation = parse_attribute (attribute ("""SchedulingCoordinator.MktOrgansation"""))
    def parse (context: Context): SchedulingCoordinator =
    {
        SchedulingCoordinator(
            MktOrganisation.parse (context),
            scid (context),
            LoadRatio (context),
            MktOrgansation (context)
        )
    }
}

/**
 * Describing users of a Scheduling Coordinator
 * @param sup Reference to the superclass object.
 * @param attr <em>undocumented</em>
 * @param endEffectiveDate Login ID Expiration Date
 * @param loginID Login ID
 * @param loginRole Assigned roles (these are roles with either Read or Read/Write privileges on different Market Systems)
 * @param startEffectiveDate Login ID Effective Date
 */
case class SchedulingCoordinatorUser
(
    override val sup: BasicElement,
    attr: String,
    endEffectiveDate: String,
    loginID: String,
    loginRole: String,
    startEffectiveDate: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[SchedulingCoordinatorUser] }
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
        (if (null != attr) "\t\t<cim:SchedulingCoordinatorUser. rdf:resource=\"#" + attr + "\"/>\n" else "") +
        (if (null != endEffectiveDate) "\t\t<cim:SchedulingCoordinatorUser.endEffectiveDate>" + endEffectiveDate + "</cim:SchedulingCoordinatorUser.endEffectiveDate>\n" else "") +
        (if (null != loginID) "\t\t<cim:SchedulingCoordinatorUser.loginID>" + loginID + "</cim:SchedulingCoordinatorUser.loginID>\n" else "") +
        (if (null != loginRole) "\t\t<cim:SchedulingCoordinatorUser.loginRole>" + loginRole + "</cim:SchedulingCoordinatorUser.loginRole>\n" else "") +
        (if (null != startEffectiveDate) "\t\t<cim:SchedulingCoordinatorUser.startEffectiveDate>" + startEffectiveDate + "</cim:SchedulingCoordinatorUser.startEffectiveDate>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SchedulingCoordinatorUser rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SchedulingCoordinatorUser>"
    }
}

object SchedulingCoordinatorUser
extends
    Parseable[SchedulingCoordinatorUser]
{
    val attr = parse_attribute (attribute ("""SchedulingCoordinatorUser."""))
    val endEffectiveDate = parse_element (element ("""SchedulingCoordinatorUser.endEffectiveDate"""))
    val loginID = parse_element (element ("""SchedulingCoordinatorUser.loginID"""))
    val loginRole = parse_element (element ("""SchedulingCoordinatorUser.loginRole"""))
    val startEffectiveDate = parse_element (element ("""SchedulingCoordinatorUser.startEffectiveDate"""))
    def parse (context: Context): SchedulingCoordinatorUser =
    {
        SchedulingCoordinatorUser(
            BasicElement.parse (context),
            attr (context),
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
 * @param Flowgate <em>undocumented</em>
 */
case class SchedulingPoint
(
    override val sup: IdentifiedObject,
    endEffectiveDate: String,
    startEffectiveDate: String,
    Flowgate: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[SchedulingPoint] }
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
        (if (null != endEffectiveDate) "\t\t<cim:SchedulingPoint.endEffectiveDate>" + endEffectiveDate + "</cim:SchedulingPoint.endEffectiveDate>\n" else "") +
        (if (null != startEffectiveDate) "\t\t<cim:SchedulingPoint.startEffectiveDate>" + startEffectiveDate + "</cim:SchedulingPoint.startEffectiveDate>\n" else "") +
        (if (null != Flowgate) "\t\t<cim:SchedulingPoint.Flowgate rdf:resource=\"#" + Flowgate + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SchedulingPoint rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SchedulingPoint>"
    }
}

object SchedulingPoint
extends
    Parseable[SchedulingPoint]
{
    val endEffectiveDate = parse_element (element ("""SchedulingPoint.endEffectiveDate"""))
    val startEffectiveDate = parse_element (element ("""SchedulingPoint.startEffectiveDate"""))
    val Flowgate = parse_attribute (attribute ("""SchedulingPoint.Flowgate"""))
    def parse (context: Context): SchedulingPoint =
    {
        SchedulingPoint(
            IdentifiedObject.parse (context),
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
 * @param RegisteredGenerator <em>undocumented</em>
 */
case class StartUpEnergyCurve
(
    override val sup: Curve,
    RegisteredGenerator: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[StartUpEnergyCurve] }
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
        (if (null != RegisteredGenerator) "\t\t<cim:StartUpEnergyCurve.RegisteredGenerator rdf:resource=\"#" + RegisteredGenerator + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:StartUpEnergyCurve rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:StartUpEnergyCurve>"
    }
}

object StartUpEnergyCurve
extends
    Parseable[StartUpEnergyCurve]
{
    val RegisteredGenerator = parse_attribute (attribute ("""StartUpEnergyCurve.RegisteredGenerator"""))
    def parse (context: Context): StartUpEnergyCurve =
    {
        StartUpEnergyCurve(
            Curve.parse (context),
            RegisteredGenerator (context)
        )
    }
}

/**
 * The fuel consumption of a Generating Resource to complete a Start-Up.(x=cooling time) Form Startup Fuel Curve. xAxisData -&gt; cooling time, y1AxisData -&gt; MBtu
 * @param sup Reference to the superclass object.
 * @param RegisteredGenerator <em>undocumented</em>
 */
case class StartUpFuelCurve
(
    override val sup: Curve,
    RegisteredGenerator: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[StartUpFuelCurve] }
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
        (if (null != RegisteredGenerator) "\t\t<cim:StartUpFuelCurve.RegisteredGenerator rdf:resource=\"#" + RegisteredGenerator + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:StartUpFuelCurve rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:StartUpFuelCurve>"
    }
}

object StartUpFuelCurve
extends
    Parseable[StartUpFuelCurve]
{
    val RegisteredGenerator = parse_attribute (attribute ("""StartUpFuelCurve.RegisteredGenerator"""))
    def parse (context: Context): StartUpFuelCurve =
    {
        StartUpFuelCurve(
            Curve.parse (context),
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
 * @param AdjacentCASet <em>undocumented</em>
 * @param AreaReserveSpecification <em>undocumented</em>
 * @param HostControlArea The interchange area  may operate as a control area
 * @param RTO <em>undocumented</em>
 */
case class SubControlArea
(
    override val sup: PowerSystemResource,
    areaShortName: String,
    constantCoefficient: Double,
    embeddedControlArea: String,
    endEffectiveDate: String,
    internalCA: String,
    linearCoefficient: Double,
    localCA: String,
    maxSelfSchedMW: Double,
    minSelfSchedMW: Double,
    quadraticCoefficient: Double,
    startEffectiveDate: String,
    AdjacentCASet: String,
    AreaReserveSpecification: String,
    HostControlArea: String,
    RTO: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, null, null, null, 0.0, null, 0.0, 0.0, 0.0, null, null, null, null, null) }
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { clone ().asInstanceOf[SubControlArea] }
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
        (if (null != areaShortName) "\t\t<cim:SubControlArea.areaShortName>" + areaShortName + "</cim:SubControlArea.areaShortName>\n" else "") +
        "\t\t<cim:SubControlArea.constantCoefficient>" + constantCoefficient + "</cim:SubControlArea.constantCoefficient>\n" +
        (if (null != embeddedControlArea) "\t\t<cim:SubControlArea.embeddedControlArea rdf:resource=\"#" + embeddedControlArea + "\"/>\n" else "") +
        (if (null != endEffectiveDate) "\t\t<cim:SubControlArea.endEffectiveDate>" + endEffectiveDate + "</cim:SubControlArea.endEffectiveDate>\n" else "") +
        (if (null != internalCA) "\t\t<cim:SubControlArea.internalCA rdf:resource=\"#" + internalCA + "\"/>\n" else "") +
        "\t\t<cim:SubControlArea.linearCoefficient>" + linearCoefficient + "</cim:SubControlArea.linearCoefficient>\n" +
        (if (null != localCA) "\t\t<cim:SubControlArea.localCA rdf:resource=\"#" + localCA + "\"/>\n" else "") +
        "\t\t<cim:SubControlArea.maxSelfSchedMW>" + maxSelfSchedMW + "</cim:SubControlArea.maxSelfSchedMW>\n" +
        "\t\t<cim:SubControlArea.minSelfSchedMW>" + minSelfSchedMW + "</cim:SubControlArea.minSelfSchedMW>\n" +
        "\t\t<cim:SubControlArea.quadraticCoefficient>" + quadraticCoefficient + "</cim:SubControlArea.quadraticCoefficient>\n" +
        (if (null != startEffectiveDate) "\t\t<cim:SubControlArea.startEffectiveDate>" + startEffectiveDate + "</cim:SubControlArea.startEffectiveDate>\n" else "") +
        (if (null != AdjacentCASet) "\t\t<cim:SubControlArea.AdjacentCASet rdf:resource=\"#" + AdjacentCASet + "\"/>\n" else "") +
        (if (null != AreaReserveSpecification) "\t\t<cim:SubControlArea.AreaReserveSpecification rdf:resource=\"#" + AreaReserveSpecification + "\"/>\n" else "") +
        (if (null != HostControlArea) "\t\t<cim:SubControlArea.HostControlArea rdf:resource=\"#" + HostControlArea + "\"/>\n" else "") +
        (if (null != RTO) "\t\t<cim:SubControlArea.RTO rdf:resource=\"#" + RTO + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SubControlArea rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SubControlArea>"
    }
}

object SubControlArea
extends
    Parseable[SubControlArea]
{
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
            PowerSystemResource.parse (context),
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
 * @param RegisteredResource <em>undocumented</em>
 * @param TransmissionContractRight <em>undocumented</em>
 */
case class SubstitutionResourceList
(
    override val sup: BasicElement,
    precedence: Int,
    RegisteredResource: String,
    TransmissionContractRight: String
)
extends
    Element
{
    def this () = { this (null, 0, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[SubstitutionResourceList] }
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
        "\t\t<cim:SubstitutionResourceList.precedence>" + precedence + "</cim:SubstitutionResourceList.precedence>\n" +
        (if (null != RegisteredResource) "\t\t<cim:SubstitutionResourceList.RegisteredResource rdf:resource=\"#" + RegisteredResource + "\"/>\n" else "") +
        (if (null != TransmissionContractRight) "\t\t<cim:SubstitutionResourceList.TransmissionContractRight rdf:resource=\"#" + TransmissionContractRight + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SubstitutionResourceList rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SubstitutionResourceList>"
    }
}

object SubstitutionResourceList
extends
    Parseable[SubstitutionResourceList]
{
    val precedence = parse_element (element ("""SubstitutionResourceList.precedence"""))
    val RegisteredResource = parse_attribute (attribute ("""SubstitutionResourceList.RegisteredResource"""))
    val TransmissionContractRight = parse_attribute (attribute ("""SubstitutionResourceList.TransmissionContractRight"""))
    def parse (context: Context): SubstitutionResourceList =
    {
        SubstitutionResourceList(
            BasicElement.parse (context),
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
    override val sup: IdentifiedObject,
    endEffectiveDate: String,
    startEffectiveDate: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[TACArea] }
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
        (if (null != endEffectiveDate) "\t\t<cim:TACArea.endEffectiveDate>" + endEffectiveDate + "</cim:TACArea.endEffectiveDate>\n" else "") +
        (if (null != startEffectiveDate) "\t\t<cim:TACArea.startEffectiveDate>" + startEffectiveDate + "</cim:TACArea.startEffectiveDate>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TACArea rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TACArea>"
    }
}

object TACArea
extends
    Parseable[TACArea]
{
    val endEffectiveDate = parse_element (element ("""TACArea.endEffectiveDate"""))
    val startEffectiveDate = parse_element (element ("""TACArea.startEffectiveDate"""))
    def parse (context: Context): TACArea =
    {
        TACArea(
            IdentifiedObject.parse (context),
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
 * @param Chain_ContractRight <em>undocumented</em>
 * @param RTO <em>undocumented</em>
 */
case class TransmissionRightChain
(
    override val sup: IdentifiedObject,
    endEffectiveDate: String,
    startEffectiveDate: String,
    Chain_ContractRight: String,
    RTO: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[TransmissionRightChain] }
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
        (if (null != endEffectiveDate) "\t\t<cim:TransmissionRightChain.endEffectiveDate>" + endEffectiveDate + "</cim:TransmissionRightChain.endEffectiveDate>\n" else "") +
        (if (null != startEffectiveDate) "\t\t<cim:TransmissionRightChain.startEffectiveDate>" + startEffectiveDate + "</cim:TransmissionRightChain.startEffectiveDate>\n" else "") +
        (if (null != Chain_ContractRight) "\t\t<cim:TransmissionRightChain.Chain_ContractRight rdf:resource=\"#" + Chain_ContractRight + "\"/>\n" else "") +
        (if (null != RTO) "\t\t<cim:TransmissionRightChain.RTO rdf:resource=\"#" + RTO + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TransmissionRightChain rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TransmissionRightChain>"
    }
}

object TransmissionRightChain
extends
    Parseable[TransmissionRightChain]
{
    val endEffectiveDate = parse_element (element ("""TransmissionRightChain.endEffectiveDate"""))
    val startEffectiveDate = parse_element (element ("""TransmissionRightChain.startEffectiveDate"""))
    val Chain_ContractRight = parse_attribute (attribute ("""TransmissionRightChain.Chain_ContractRight"""))
    val RTO = parse_attribute (attribute ("""TransmissionRightChain.RTO"""))
    def parse (context: Context): TransmissionRightChain =
    {
        TransmissionRightChain(
            IdentifiedObject.parse (context),
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
 * @param RegisteredInterTie <em>undocumented</em>
 */
case class WheelingCounterParty
(
    override val sup: IdentifiedObject,
    RegisteredInterTie: List[String]
)
extends
    Element
{
    def this () = { this (null, List()) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[WheelingCounterParty] }
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
        (if (null != RegisteredInterTie) RegisteredInterTie.map (x => "\t\t<cim:WheelingCounterParty.RegisteredInterTie rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:WheelingCounterParty rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WheelingCounterParty>"
    }
}

object WheelingCounterParty
extends
    Parseable[WheelingCounterParty]
{
    val RegisteredInterTie = parse_attributes (attribute ("""WheelingCounterParty.RegisteredInterTie"""))
    def parse (context: Context): WheelingCounterParty =
    {
        WheelingCounterParty(
            IdentifiedObject.parse (context),
            RegisteredInterTie (context)
        )
    }
}

private[ninecode] object _ReferenceData
{
    def register: List[ClassInfo] =
    {
        List (
            AdjacentCASet.register,
            AggregateNode.register,
            AggregatedPnode.register,
            BidPriceCap.register,
            CnodeDistributionFactor.register,
            CombinedCycleConfiguration.register,
            CombinedCycleConfigurationMember.register,
            CombinedCycleLogicalConfiguration.register,
            CombinedCycleTransitionState.register,
            CongestionArea.register,
            ContractDistributionFactor.register,
            ContractRight.register,
            ControlAreaDesignation.register,
            Flowgate.register,
            FlowgatePartner.register,
            FlowgateRelief.register,
            FlowgateValue.register,
            ForbiddenRegion.register,
            FormerReference.register,
            FuelCostCurve.register,
            FuelRegion.register,
            GasPrice.register,
            HostControlArea.register,
            IndividualPnode.register,
            LoadAggregationPoint.register,
            LoadRatio.register,
            LoadReductionTimeCurve.register,
            LocalReliabilityArea.register,
            MPMTestCategory.register,
            MPMTestThreshold.register,
            MSSAggregation.register,
            MSSZone.register,
            MarketPerson.register,
            MarketQualificationRequirement.register,
            MarketRegion.register,
            MarketSkill.register,
            MaxStartUpCostCurve.register,
            MeteredSubSystem.register,
            MktCombinedCyclePlant.register,
            MktConductingEquipment.register,
            MktContingency.register,
            MktHeatRateCurve.register,
            MktThermalGeneratingUnit.register,
            OilPrice.register,
            OrgPnodeAllocation.register,
            OrgResOwnership.register,
            Pnode.register,
            PnodeDistributionFactor.register,
            RMRHeatRateCurve.register,
            RMRStartUpCostCurve.register,
            RMRStartUpEnergyCurve.register,
            RMRStartUpFuelCurve.register,
            RMRStartUpTimeCurve.register,
            RTO.register,
            RUCZone.register,
            RegisteredGenerator.register,
            RegisteredInterTie.register,
            RegisteredLoad.register,
            RegulatingLimit.register,
            ResourceAncillaryServiceQualification.register,
            ResourceCapacity.register,
            ResourceOperationMaintenanceCost.register,
            ResourceStartupCost.register,
            ResourceVerifiableCosts.register,
            SchedulingCoordinator.register,
            SchedulingCoordinatorUser.register,
            SchedulingPoint.register,
            StartUpEnergyCurve.register,
            StartUpFuelCurve.register,
            SubControlArea.register,
            SubstitutionResourceList.register,
            TACArea.register,
            TransmissionRightChain.register,
            WheelingCounterParty.register
        )
    }
}