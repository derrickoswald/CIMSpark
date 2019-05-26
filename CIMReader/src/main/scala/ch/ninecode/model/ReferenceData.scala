package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Groups Adjacent Control Areas.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param lossPercentage  Loss percentage
 * @param BidSelfSched [[ch.ninecode.model.BidSelfSched BidSelfSched]] <em>undocumented</em>
 * @param HostControlArea [[ch.ninecode.model.HostControlArea HostControlArea]] <em>undocumented</em>
 * @param RTO [[ch.ninecode.model.RTO RTO]] <em>undocumented</em>
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @param SubControlArea [[ch.ninecode.model.SubControlArea SubControlArea]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class AdjacentCASet
(
    override val sup: IdentifiedObject,
    lossPercentage_1: Double,
    BidSelfSched: List[String],
    HostControlArea: String,
    RTO: String,
    RegisteredResource: List[String],
    SubControlArea: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, List(), null, null, List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = AdjacentCASet.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AdjacentCASet.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AdjacentCASet.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (AdjacentCASet.fields (position), x))
        emitelem (0, lossPercentage_1)
        emitattrs (1, BidSelfSched)
        emitattr (2, HostControlArea)
        emitattr (3, RTO)
        emitattrs (4, RegisteredResource)
        emitattrs (5, SubControlArea)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AdjacentCASet rdf:ID=\"%s\">\n%s\t</cim:AdjacentCASet>".format (id, export_fields)
    }
}

object AdjacentCASet
extends
    Parseable[AdjacentCASet]
{
    override val fields: Array[String] = Array[String] (
        "lossPercentage ",
        "BidSelfSched",
        "HostControlArea",
        "RTO",
        "RegisteredResource",
        "SubControlArea"
    )
    override val relations: List[Relationship] = List (
        Relationship ("BidSelfSched", "BidSelfSched", "0..*", "0..1"),
        Relationship ("HostControlArea", "HostControlArea", "0..1", "0..1"),
        Relationship ("RTO", "RTO", "1", "0..*"),
        Relationship ("RegisteredResource", "RegisteredResource", "0..*", "0..1"),
        Relationship ("SubControlArea", "SubControlArea", "0..*", "0..1")
    )
    val lossPercentage_1: Fielder = parse_element (element (cls, fields(0)))
    val BidSelfSched: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val HostControlArea: Fielder = parse_attribute (attribute (cls, fields(2)))
    val RTO: Fielder = parse_attribute (attribute (cls, fields(3)))
    val RegisteredResource: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val SubControlArea: FielderMultiple = parse_attributes (attribute (cls, fields(5)))

    def parse (context: Context): AdjacentCASet =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = AdjacentCASet (
            IdentifiedObject.parse (context),
            toDouble (mask (lossPercentage_1 (), 0)),
            masks (BidSelfSched (), 1),
            mask (HostControlArea (), 2),
            mask (RTO (), 3),
            masks (RegisteredResource (), 4),
            masks (SubControlArea (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * An aggregated node can define a typed grouping further defined by the AnodeType enumeratuion.
 *
 * Types range from System Zone/Regions to Market Energy Regions to Aggregated Loads and Aggregated Generators.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param anodeType Type of aggregated node
 * @param qualifASOrder Processing Order for AS self-provisions for this region.
 *        The priority of this attribute directs the awards of any resource that resides in overlapping regions. The regions are processed in priority manner.
 * @param AreaLoadCurve [[ch.ninecode.model.AreaLoadCurve AreaLoadCurve]] <em>undocumented</em>
 * @param CnodeDistributionFactor [[ch.ninecode.model.CnodeDistributionFactor CnodeDistributionFactor]] <em>undocumented</em>
 * @param Instruction [[ch.ninecode.model.Instructions Instructions]] <em>undocumented</em>
 * @param Pnode [[ch.ninecode.model.Pnode Pnode]] <em>undocumented</em>
 * @param RTO [[ch.ninecode.model.RTO RTO]] <em>undocumented</em>
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] A RegisteredResource can be associated to only one AggregateNode if not connected to a Pnode or MktConnectivityNode.
 * @param SubControlArea [[ch.ninecode.model.SubControlArea SubControlArea]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class AggregateNode
(
    override val sup: IdentifiedObject,
    anodeType: String,
    qualifASOrder: Int,
    AreaLoadCurve: List[String],
    CnodeDistributionFactor: List[String],
    Instruction: List[String],
    Pnode: List[String],
    RTO: String,
    RegisteredResource: List[String],
    SubControlArea: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0, List(), List(), List(), List(), null, List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = AggregateNode.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AggregateNode.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AggregateNode.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (AggregateNode.fields (position), x))
        emitattr (0, anodeType)
        emitelem (1, qualifASOrder)
        emitattrs (2, AreaLoadCurve)
        emitattrs (3, CnodeDistributionFactor)
        emitattrs (4, Instruction)
        emitattrs (5, Pnode)
        emitattr (6, RTO)
        emitattrs (7, RegisteredResource)
        emitattrs (8, SubControlArea)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AggregateNode rdf:ID=\"%s\">\n%s\t</cim:AggregateNode>".format (id, export_fields)
    }
}

object AggregateNode
extends
    Parseable[AggregateNode]
{
    override val fields: Array[String] = Array[String] (
        "anodeType",
        "qualifASOrder",
        "AreaLoadCurve",
        "CnodeDistributionFactor",
        "Instruction",
        "Pnode",
        "RTO",
        "RegisteredResource",
        "SubControlArea"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AreaLoadCurve", "AreaLoadCurve", "0..*", "0..1"),
        Relationship ("CnodeDistributionFactor", "CnodeDistributionFactor", "0..*", "0..1"),
        Relationship ("Instruction", "Instructions", "0..*", "0..1"),
        Relationship ("Pnode", "Pnode", "0..*", "0..*"),
        Relationship ("RTO", "RTO", "1", "0..*"),
        Relationship ("RegisteredResource", "RegisteredResource", "0..*", "0..1"),
        Relationship ("SubControlArea", "SubControlArea", "0..*", "0..*")
    )
    val anodeType: Fielder = parse_attribute (attribute (cls, fields(0)))
    val qualifASOrder: Fielder = parse_element (element (cls, fields(1)))
    val AreaLoadCurve: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val CnodeDistributionFactor: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val Instruction: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val Pnode: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val RTO: Fielder = parse_attribute (attribute (cls, fields(6)))
    val RegisteredResource: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val SubControlArea: FielderMultiple = parse_attributes (attribute (cls, fields(8)))

    def parse (context: Context): AggregateNode =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = AggregateNode (
            IdentifiedObject.parse (context),
            mask (anodeType (), 0),
            toInteger (mask (qualifASOrder (), 1)),
            masks (AreaLoadCurve (), 2),
            masks (CnodeDistributionFactor (), 3),
            masks (Instruction (), 4),
            masks (Pnode (), 5),
            mask (RTO (), 6),
            masks (RegisteredResource (), 7),
            masks (SubControlArea (), 8)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * An aggregated pricing node is a specialized type of pricing node used to model items such as System Zone, Default Price Zone, Custom Price Zone, Control Area, Aggregated Generation, Aggregated Particpating Load, Aggregated Non-Participating Load, Trading Hub, Designated Control Area(DCA) Zone.
 *
 * @param sup [[ch.ninecode.model.Pnode Pnode]] Reference to the superclass object.
 * @param apnodeType Aggregate Price Node Types
 * @param participationCategory Designated Control Area participation in LMP price measurement
 *        
 *        'Y' - Participates in both Local Market Power Mitigation (LMPM) and System Market Power Mitigation (SMPM)
 *        'N' - Not included in LMP price measures
 *        'S' - Participatesin SMPM price measures
 *        'L' - Participatesin LMPM price measures
 * @param GenDistributionFactor [[ch.ninecode.model.GenDistributionFactor GenDistributionFactor]] <em>undocumented</em>
 * @param LoadDistributionFactor [[ch.ninecode.model.LoadDistributionFactor LoadDistributionFactor]] <em>undocumented</em>
 * @param MPMTestResults [[ch.ninecode.model.MPMTestResults MPMTestResults]] <em>undocumented</em>
 * @param MPMTestThreshold [[ch.ninecode.model.MPMTestThreshold MPMTestThreshold]] <em>undocumented</em>
 * @param MktCombinedCyclePlant [[ch.ninecode.model.MktCombinedCyclePlant MktCombinedCyclePlant]] <em>undocumented</em>
 * @param PnodeDistributionFactor [[ch.ninecode.model.PnodeDistributionFactor PnodeDistributionFactor]] <em>undocumented</em>
 * @param TACArea [[ch.ninecode.model.TACArea TACArea]] <em>undocumented</em>
 * @param TradingHubValues [[ch.ninecode.model.TradingHubValues TradingHubValues]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class AggregatedPnode
(
    override val sup: Pnode,
    apnodeType: String,
    participationCategory: String,
    GenDistributionFactor: List[String],
    LoadDistributionFactor: List[String],
    MPMTestResults: List[String],
    MPMTestThreshold: List[String],
    MktCombinedCyclePlant: List[String],
    PnodeDistributionFactor: List[String],
    TACArea: List[String],
    TradingHubValues: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, List(), List(), List(), List(), List(), List(), List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = AggregatedPnode.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AggregatedPnode.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (AggregatedPnode.fields (position), x))
        emitattr (0, apnodeType)
        emitattr (1, participationCategory)
        emitattrs (2, GenDistributionFactor)
        emitattrs (3, LoadDistributionFactor)
        emitattrs (4, MPMTestResults)
        emitattrs (5, MPMTestThreshold)
        emitattrs (6, MktCombinedCyclePlant)
        emitattrs (7, PnodeDistributionFactor)
        emitattrs (8, TACArea)
        emitattrs (9, TradingHubValues)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AggregatedPnode rdf:ID=\"%s\">\n%s\t</cim:AggregatedPnode>".format (id, export_fields)
    }
}

object AggregatedPnode
extends
    Parseable[AggregatedPnode]
{
    override val fields: Array[String] = Array[String] (
        "apnodeType",
        "participationCategory",
        "GenDistributionFactor",
        "LoadDistributionFactor",
        "MPMTestResults",
        "MPMTestThreshold",
        "MktCombinedCyclePlant",
        "PnodeDistributionFactor",
        "TACArea",
        "TradingHubValues"
    )
    override val relations: List[Relationship] = List (
        Relationship ("GenDistributionFactor", "GenDistributionFactor", "1..*", "0..1"),
        Relationship ("LoadDistributionFactor", "LoadDistributionFactor", "1..*", "0..1"),
        Relationship ("MPMTestResults", "MPMTestResults", "1..*", "1"),
        Relationship ("MPMTestThreshold", "MPMTestThreshold", "1..*", "0..*"),
        Relationship ("MktCombinedCyclePlant", "MktCombinedCyclePlant", "0..*", "0..1"),
        Relationship ("PnodeDistributionFactor", "PnodeDistributionFactor", "1..*", "1"),
        Relationship ("TACArea", "TACArea", "0..*", "0..*"),
        Relationship ("TradingHubValues", "TradingHubValues", "0..*", "1")
    )
    val apnodeType: Fielder = parse_attribute (attribute (cls, fields(0)))
    val participationCategory: Fielder = parse_attribute (attribute (cls, fields(1)))
    val GenDistributionFactor: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val LoadDistributionFactor: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val MPMTestResults: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val MPMTestThreshold: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val MktCombinedCyclePlant: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val PnodeDistributionFactor: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val TACArea: FielderMultiple = parse_attributes (attribute (cls, fields(8)))
    val TradingHubValues: FielderMultiple = parse_attributes (attribute (cls, fields(9)))

    def parse (context: Context): AggregatedPnode =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = AggregatedPnode (
            Pnode.parse (context),
            mask (apnodeType (), 0),
            mask (participationCategory (), 1),
            masks (GenDistributionFactor (), 2),
            masks (LoadDistributionFactor (), 3),
            masks (MPMTestResults (), 4),
            masks (MPMTestThreshold (), 5),
            masks (MktCombinedCyclePlant (), 6),
            masks (PnodeDistributionFactor (), 7),
            masks (TACArea (), 8),
            masks (TradingHubValues (), 9)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * This class represent the bid price cap.
 *
 * @param sup Reference to the superclass object.
 * @param bidCeiling Bid Ceiling (\$/MWH)
 * @param bidCeilingAS Bid Ceiling (\$/MWH) for generic AS versus a specific market product
 * @param bidFloor Bid Floor, (\$/MWH)
 * @param bidFloorAS Bid Floor (\$/MWH) for generic AS versus a specific market product
 * @param defaultPrice Bid Default Price(\$/MWH)
 * @param marketType Market Type of the cap (DAM or RTM)
 * @param MarketProduct [[ch.ninecode.model.MarketProduct MarketProduct]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
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
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = BidPriceCap.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (BidPriceCap.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (BidPriceCap.fields (position), value)
        emitelem (0, bidCeiling)
        emitelem (1, bidCeilingAS)
        emitelem (2, bidFloor)
        emitelem (3, bidFloorAS)
        emitelem (4, defaultPrice)
        emitattr (5, marketType)
        emitattr (6, MarketProduct)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:BidPriceCap rdf:ID=\"%s\">\n%s\t</cim:BidPriceCap>".format (id, export_fields)
    }
}

object BidPriceCap
extends
    Parseable[BidPriceCap]
{
    override val fields: Array[String] = Array[String] (
        "bidCeiling",
        "bidCeilingAS",
        "bidFloor",
        "bidFloorAS",
        "defaultPrice",
        "marketType",
        "MarketProduct"
    )
    override val relations: List[Relationship] = List (
        Relationship ("MarketProduct", "MarketProduct", "0..1", "0..*")
    )
    val bidCeiling: Fielder = parse_element (element (cls, fields(0)))
    val bidCeilingAS: Fielder = parse_element (element (cls, fields(1)))
    val bidFloor: Fielder = parse_element (element (cls, fields(2)))
    val bidFloorAS: Fielder = parse_element (element (cls, fields(3)))
    val defaultPrice: Fielder = parse_element (element (cls, fields(4)))
    val marketType: Fielder = parse_attribute (attribute (cls, fields(5)))
    val MarketProduct: Fielder = parse_attribute (attribute (cls, fields(6)))

    def parse (context: Context): BidPriceCap =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = BidPriceCap (
            BasicElement.parse (context),
            toDouble (mask (bidCeiling (), 0)),
            toDouble (mask (bidCeilingAS (), 1)),
            toDouble (mask (bidFloor (), 2)),
            toDouble (mask (bidFloorAS (), 3)),
            toDouble (mask (defaultPrice (), 4)),
            mask (marketType (), 5),
            mask (MarketProduct (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Participation factors per Cnode.
 *
 * Used to calculate "participation" of Cnode in an AggregateNode. Each Cnode associated to an AggregateNode would be assigned a participation factor for its participation within the AggregateNode.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param factor Used to calculate "participation" of Cnode in an AggregateNode
 * @param podLossFactor Point of delivery loss factor
 * @param AggregateNode [[ch.ninecode.model.AggregateNode AggregateNode]] <em>undocumented</em>
 * @param HostControlArea [[ch.ninecode.model.HostControlArea HostControlArea]] <em>undocumented</em>
 * @param MktConnectivityNode [[ch.ninecode.model.MktConnectivityNode MktConnectivityNode]] <em>undocumented</em>
 * @param SubControlArea [[ch.ninecode.model.SubControlArea SubControlArea]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
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
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CnodeDistributionFactor.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CnodeDistributionFactor.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CnodeDistributionFactor.fields (position), value)
        emitelem (0, factor)
        emitelem (1, podLossFactor)
        emitattr (2, AggregateNode)
        emitattr (3, HostControlArea)
        emitattr (4, MktConnectivityNode)
        emitattr (5, SubControlArea)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CnodeDistributionFactor rdf:ID=\"%s\">\n%s\t</cim:CnodeDistributionFactor>".format (id, export_fields)
    }
}

object CnodeDistributionFactor
extends
    Parseable[CnodeDistributionFactor]
{
    override val fields: Array[String] = Array[String] (
        "factor",
        "podLossFactor",
        "AggregateNode",
        "HostControlArea",
        "MktConnectivityNode",
        "SubControlArea"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AggregateNode", "AggregateNode", "0..1", "0..*"),
        Relationship ("HostControlArea", "HostControlArea", "0..1", "0..*"),
        Relationship ("MktConnectivityNode", "MktConnectivityNode", "1", "0..*"),
        Relationship ("SubControlArea", "SubControlArea", "0..1", "0..*")
    )
    val factor: Fielder = parse_element (element (cls, fields(0)))
    val podLossFactor: Fielder = parse_element (element (cls, fields(1)))
    val AggregateNode: Fielder = parse_attribute (attribute (cls, fields(2)))
    val HostControlArea: Fielder = parse_attribute (attribute (cls, fields(3)))
    val MktConnectivityNode: Fielder = parse_attribute (attribute (cls, fields(4)))
    val SubControlArea: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: Context): CnodeDistributionFactor =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = CnodeDistributionFactor (
            IdentifiedObject.parse (context),
            toDouble (mask (factor (), 0)),
            toDouble (mask (podLossFactor (), 1)),
            mask (AggregateNode (), 2),
            mask (HostControlArea (), 3),
            mask (MktConnectivityNode (), 4),
            mask (SubControlArea (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Configuration options for combined cycle units.
 *
 * For example, a Combined Cycle with (CT1, CT2, ST1) will have (CT1, ST1) and (CT2, ST1) configurations as part of(1CT + 1STlogicalconfiguration).
 *
 * @param sup [[ch.ninecode.model.RegisteredGenerator RegisteredGenerator]] Reference to the superclass object.
 * @param primaryConfiguration Whether this CombinedCycleConfiguration is the primary configuration in the associated Logical configuration?
 * @param CombinedCycleConfigurationMember [[ch.ninecode.model.CombinedCycleConfigurationMember CombinedCycleConfigurationMember]] <em>undocumented</em>
 * @param CombinedCycleLogicalConfiguration [[ch.ninecode.model.CombinedCycleLogicalConfiguration CombinedCycleLogicalConfiguration]] <em>undocumented</em>
 * @param FromTransitionState [[ch.ninecode.model.CombinedCycleTransitionState CombinedCycleTransitionState]] <em>undocumented</em>
 * @param ShutdownFlag Whether Combined Cycle Plant can be shut-down in this Configuration?
 * @param StartupFlag Whether Combined Cycle Plant can be started in this Logical Configuration?
 * @param ToTransitionState [[ch.ninecode.model.CombinedCycleTransitionState CombinedCycleTransitionState]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class CombinedCycleConfiguration
(
    override val sup: RegisteredGenerator,
    primaryConfiguration: Boolean,
    CombinedCycleConfigurationMember: List[String],
    CombinedCycleLogicalConfiguration: String,
    FromTransitionState: List[String],
    ShutdownFlag: Boolean,
    StartupFlag: Boolean,
    ToTransitionState: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, List(), null, List(), false, false, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CombinedCycleConfiguration.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CombinedCycleConfiguration.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CombinedCycleConfiguration.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (CombinedCycleConfiguration.fields (position), x))
        emitelem (0, primaryConfiguration)
        emitattrs (1, CombinedCycleConfigurationMember)
        emitattr (2, CombinedCycleLogicalConfiguration)
        emitattrs (3, FromTransitionState)
        emitelem (4, ShutdownFlag)
        emitelem (5, StartupFlag)
        emitattrs (6, ToTransitionState)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CombinedCycleConfiguration rdf:ID=\"%s\">\n%s\t</cim:CombinedCycleConfiguration>".format (id, export_fields)
    }
}

object CombinedCycleConfiguration
extends
    Parseable[CombinedCycleConfiguration]
{
    override val fields: Array[String] = Array[String] (
        "primaryConfiguration",
        "CombinedCycleConfigurationMember",
        "CombinedCycleLogicalConfiguration",
        "FromTransitionState",
        "ShutdownFlag",
        "StartupFlag",
        "ToTransitionState"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CombinedCycleConfigurationMember", "CombinedCycleConfigurationMember", "0..*", "1"),
        Relationship ("CombinedCycleLogicalConfiguration", "CombinedCycleLogicalConfiguration", "0..1", "1..*"),
        Relationship ("FromTransitionState", "CombinedCycleTransitionState", "0..*", "1"),
        Relationship ("ToTransitionState", "CombinedCycleTransitionState", "0..*", "1")
    )
    val primaryConfiguration: Fielder = parse_element (element (cls, fields(0)))
    val CombinedCycleConfigurationMember: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val CombinedCycleLogicalConfiguration: Fielder = parse_attribute (attribute (cls, fields(2)))
    val FromTransitionState: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val ShutdownFlag: Fielder = parse_element (element (cls, fields(4)))
    val StartupFlag: Fielder = parse_element (element (cls, fields(5)))
    val ToTransitionState: FielderMultiple = parse_attributes (attribute (cls, fields(6)))

    def parse (context: Context): CombinedCycleConfiguration =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = CombinedCycleConfiguration (
            RegisteredGenerator.parse (context),
            toBoolean (mask (primaryConfiguration (), 0)),
            masks (CombinedCycleConfigurationMember (), 1),
            mask (CombinedCycleLogicalConfiguration (), 2),
            masks (FromTransitionState (), 3),
            toBoolean (mask (ShutdownFlag (), 4)),
            toBoolean (mask (StartupFlag (), 5)),
            masks (ToTransitionState (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Configuration Member of CCP Configuration.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param primary primary configuration.
 * @param steam Steam plant.
 * @param CombinedCycleConfiguration [[ch.ninecode.model.CombinedCycleConfiguration CombinedCycleConfiguration]] <em>undocumented</em>
 * @param MktThermalGeneratingUnit [[ch.ninecode.model.MktThermalGeneratingUnit MktThermalGeneratingUnit]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
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
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, false, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CombinedCycleConfigurationMember.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CombinedCycleConfigurationMember.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CombinedCycleConfigurationMember.fields (position), value)
        emitelem (0, primary)
        emitelem (1, steam)
        emitattr (2, CombinedCycleConfiguration)
        emitattr (3, MktThermalGeneratingUnit)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CombinedCycleConfigurationMember rdf:ID=\"%s\">\n%s\t</cim:CombinedCycleConfigurationMember>".format (id, export_fields)
    }
}

object CombinedCycleConfigurationMember
extends
    Parseable[CombinedCycleConfigurationMember]
{
    override val fields: Array[String] = Array[String] (
        "primary",
        "steam",
        "CombinedCycleConfiguration",
        "MktThermalGeneratingUnit"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CombinedCycleConfiguration", "CombinedCycleConfiguration", "1", "0..*"),
        Relationship ("MktThermalGeneratingUnit", "MktThermalGeneratingUnit", "1", "0..*")
    )
    val primary: Fielder = parse_element (element (cls, fields(0)))
    val steam: Fielder = parse_element (element (cls, fields(1)))
    val CombinedCycleConfiguration: Fielder = parse_attribute (attribute (cls, fields(2)))
    val MktThermalGeneratingUnit: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): CombinedCycleConfigurationMember =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = CombinedCycleConfigurationMember (
            IdentifiedObject.parse (context),
            toBoolean (mask (primary (), 0)),
            toBoolean (mask (steam (), 1)),
            mask (CombinedCycleConfiguration (), 2),
            mask (MktThermalGeneratingUnit (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Logical Configuration of a Combined Cycle plant.
 *
 * Operating Combined Cycle Plant (CCP) configurations are represented as Logical CCP Resources. Logical representation shall be used for Market applications to optimize and control Market Operations. Logical representation is also necessary for controlling the number of CCP configurations and to temper performance issues that may otherwise occur.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param CombinedCycleConfiguration [[ch.ninecode.model.CombinedCycleConfiguration CombinedCycleConfiguration]] <em>undocumented</em>
 * @param MktCombinedCyclePlant [[ch.ninecode.model.MktCombinedCyclePlant MktCombinedCyclePlant]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class CombinedCycleLogicalConfiguration
(
    override val sup: IdentifiedObject,
    CombinedCycleConfiguration: List[String],
    MktCombinedCyclePlant: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List(), null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CombinedCycleLogicalConfiguration.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CombinedCycleLogicalConfiguration.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (CombinedCycleLogicalConfiguration.fields (position), x))
        emitattrs (0, CombinedCycleConfiguration)
        emitattr (1, MktCombinedCyclePlant)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CombinedCycleLogicalConfiguration rdf:ID=\"%s\">\n%s\t</cim:CombinedCycleLogicalConfiguration>".format (id, export_fields)
    }
}

object CombinedCycleLogicalConfiguration
extends
    Parseable[CombinedCycleLogicalConfiguration]
{
    override val fields: Array[String] = Array[String] (
        "CombinedCycleConfiguration",
        "MktCombinedCyclePlant"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CombinedCycleConfiguration", "CombinedCycleConfiguration", "1..*", "0..1"),
        Relationship ("MktCombinedCyclePlant", "MktCombinedCyclePlant", "0..1", "1..*")
    )
    val CombinedCycleConfiguration: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val MktCombinedCyclePlant: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): CombinedCycleLogicalConfiguration =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = CombinedCycleLogicalConfiguration (
            IdentifiedObject.parse (context),
            masks (CombinedCycleConfiguration (), 0),
            mask (MktCombinedCyclePlant (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Defines the available from and to Transition States for the Combine Cycle Configurations.
 *
 * @param sup Reference to the superclass object.
 * @param upTransition Flag indicating whether this is an UP transition.
 *        If not, it is a DOWN transition.
 * @param FromConfiguration [[ch.ninecode.model.CombinedCycleConfiguration CombinedCycleConfiguration]] <em>undocumented</em>
 * @param ToConfiguration [[ch.ninecode.model.CombinedCycleConfiguration CombinedCycleConfiguration]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
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
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CombinedCycleTransitionState.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CombinedCycleTransitionState.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CombinedCycleTransitionState.fields (position), value)
        emitelem (0, upTransition)
        emitattr (1, FromConfiguration)
        emitattr (2, ToConfiguration)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CombinedCycleTransitionState rdf:ID=\"%s\">\n%s\t</cim:CombinedCycleTransitionState>".format (id, export_fields)
    }
}

object CombinedCycleTransitionState
extends
    Parseable[CombinedCycleTransitionState]
{
    override val fields: Array[String] = Array[String] (
        "upTransition",
        "FromConfiguration",
        "ToConfiguration"
    )
    override val relations: List[Relationship] = List (
        Relationship ("FromConfiguration", "CombinedCycleConfiguration", "1", "0..*"),
        Relationship ("ToConfiguration", "CombinedCycleConfiguration", "1", "0..*")
    )
    val upTransition: Fielder = parse_element (element (cls, fields(0)))
    val FromConfiguration: Fielder = parse_attribute (attribute (cls, fields(1)))
    val ToConfiguration: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): CombinedCycleTransitionState =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = CombinedCycleTransitionState (
            BasicElement.parse (context),
            toBoolean (mask (upTransition (), 0)),
            mask (FromConfiguration (), 1),
            mask (ToConfiguration (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Designated Congestion Area Definition (DCA).
 *
 * @param sup [[ch.ninecode.model.AggregatedPnode AggregatedPnode]] Reference to the superclass object.
 * @param IndividualPnode [[ch.ninecode.model.IndividualPnode IndividualPnode]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class CongestionArea
(
    override val sup: AggregatedPnode,
    IndividualPnode: List[String]
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CongestionArea.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (CongestionArea.fields (position), x))
        emitattrs (0, IndividualPnode)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CongestionArea rdf:ID=\"%s\">\n%s\t</cim:CongestionArea>".format (id, export_fields)
    }
}

object CongestionArea
extends
    Parseable[CongestionArea]
{
    override val fields: Array[String] = Array[String] (
        "IndividualPnode"
    )
    override val relations: List[Relationship] = List (
        Relationship ("IndividualPnode", "IndividualPnode", "0..*", "0..*")
    )
    val IndividualPnode: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): CongestionArea =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = CongestionArea (
            AggregatedPnode.parse (context),
            masks (IndividualPnode (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Distribution among resources at the sink point or source point.
 *
 * @param sup Reference to the superclass object.
 * @param factor MW value that this resource provides to the overall contract.
 * @param sinkFlag This value will be set to YES if the referenced Cnode is defined as the sink point in the contract.
 * @param sourceFlag This value will be set to YES if the referenced Cnode is defined as the source point in the contract.
 * @param Flowgate [[ch.ninecode.model.Flowgate Flowgate]] <em>undocumented</em>
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @param TransmissionContractRight [[ch.ninecode.model.ContractRight ContractRight]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
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
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ContractDistributionFactor.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ContractDistributionFactor.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ContractDistributionFactor.fields (position), value)
        emitelem (0, factor)
        emitattr (1, sinkFlag)
        emitattr (2, sourceFlag)
        emitattr (3, Flowgate)
        emitattr (4, RegisteredResource)
        emitattr (5, TransmissionContractRight)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ContractDistributionFactor rdf:ID=\"%s\">\n%s\t</cim:ContractDistributionFactor>".format (id, export_fields)
    }
}

object ContractDistributionFactor
extends
    Parseable[ContractDistributionFactor]
{
    override val fields: Array[String] = Array[String] (
        "factor",
        "sinkFlag",
        "sourceFlag",
        "Flowgate",
        "RegisteredResource",
        "TransmissionContractRight"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Flowgate", "Flowgate", "0..1", "0..*"),
        Relationship ("RegisteredResource", "RegisteredResource", "0..1", "0..*"),
        Relationship ("TransmissionContractRight", "ContractRight", "0..1", "0..*")
    )
    val factor: Fielder = parse_element (element (cls, fields(0)))
    val sinkFlag: Fielder = parse_attribute (attribute (cls, fields(1)))
    val sourceFlag: Fielder = parse_attribute (attribute (cls, fields(2)))
    val Flowgate: Fielder = parse_attribute (attribute (cls, fields(3)))
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields(4)))
    val TransmissionContractRight: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: Context): ContractDistributionFactor =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ContractDistributionFactor (
            BasicElement.parse (context),
            toDouble (mask (factor (), 0)),
            mask (sinkFlag (), 1),
            mask (sourceFlag (), 2),
            mask (Flowgate (), 3),
            mask (RegisteredResource (), 4),
            mask (TransmissionContractRight (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Provides definition of Transmission Ownership Right and Existing Transmission Contract identifiers for use by SCUC.
 *
 * RMR contract hosting: Startup lead time, Contract Service Limits, Max Service Hours, Max MWhs, Max Start-ups, Ramp Rate, Max Net Dependable Capacity, Min Capacity and Unit Substitution for DAM/RTM to retrieve.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param chainOrder When used in conjunction with a Transmission Right contract chain, this is the precedence for the contracts.
 * @param contractMW MW value of the contract
 * @param contractPrice Financial value of the contract
 * @param contractPriority Priority for the contract.
 *        This should be unique amoung all contracts for a specific resource. This value is the directive for the SCUC algorithm on the order to satisfy/cut contracts.
 * @param contractStatus Contract status
 * @param contractType type of the contract.
 *        Possible values are but not limited by:
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
 * @param startupLeadTime Start up lead time
 * @param BidSelfSched [[ch.ninecode.model.BidSelfSched BidSelfSched]] <em>undocumented</em>
 * @param Chain_TransmissionRightChain [[ch.ninecode.model.TransmissionRightChain TransmissionRightChain]] <em>undocumented</em>
 * @param ContractDistributionFactor [[ch.ninecode.model.ContractDistributionFactor ContractDistributionFactor]] <em>undocumented</em>
 * @param Ind_TransmissionRightChain [[ch.ninecode.model.TransmissionRightChain TransmissionRightChain]] <em>undocumented</em>
 * @param RTO [[ch.ninecode.model.RTO RTO]] <em>undocumented</em>
 * @param SchedulingCoordinator [[ch.ninecode.model.SchedulingCoordinator SchedulingCoordinator]] <em>undocumented</em>
 * @param SubstitutionResourceList [[ch.ninecode.model.SubstitutionResourceList SubstitutionResourceList]] <em>undocumented</em>
 * @param TREntitlement [[ch.ninecode.model.TREntitlement TREntitlement]] <em>undocumented</em>
 * @param TRType Transmission Right type - is this an individual contract right or a chain contract right.
 *        Types = CHAIN or INDIVIDUAL
 * @param TransmissionInterfaceEntitlement [[ch.ninecode.model.TransmissionInterfaceRightEntitlement TransmissionInterfaceRightEntitlement]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
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
    startupLeadTime: Int,
    BidSelfSched: List[String],
    Chain_TransmissionRightChain: String,
    ContractDistributionFactor: List[String],
    Ind_TransmissionRightChain: String,
    RTO: String,
    SchedulingCoordinator: String,
    SubstitutionResourceList: List[String],
    TREntitlement: List[String],
    TRType: String,
    TransmissionInterfaceEntitlement: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0, 0.0, 0.0, 0, null, null, null, null, null, 0.0, 0, null, 0.0, 0.0, 0, 0, 0.0, 0.0, null, null, 0, List(), null, List(), null, null, null, List(), List(), null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ContractRight.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ContractRight.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ContractRight.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (ContractRight.fields (position), x))
        emitelem (0, chainOrder)
        emitelem (1, contractMW)
        emitelem (2, contractPrice)
        emitelem (3, contractPriority)
        emitelem (4, contractStatus)
        emitattr (5, contractType)
        emitattr (6, financialLocation)
        emitattr (7, financialRightsDAM)
        emitattr (8, financialRightsRTM)
        emitelem (9, fuelAdder)
        emitelem (10, latestSchedMinutes)
        emitattr (11, latestSchedMktType)
        emitelem (12, maxNetDependableCapacity)
        emitelem (13, maximumScheduleQuantity)
        emitelem (14, maximumServiceHours)
        emitelem (15, maximumStartups)
        emitelem (16, minimumLoad)
        emitelem (17, minimumScheduleQuantity)
        emitattr (18, physicalRightsDAM)
        emitattr (19, physicalRightsRTM)
        emitelem (20, startupLeadTime)
        emitattrs (21, BidSelfSched)
        emitattr (22, Chain_TransmissionRightChain)
        emitattrs (23, ContractDistributionFactor)
        emitattr (24, Ind_TransmissionRightChain)
        emitattr (25, RTO)
        emitattr (26, SchedulingCoordinator)
        emitattrs (27, SubstitutionResourceList)
        emitattrs (28, TREntitlement)
        emitattr (29, TRType)
        emitattrs (30, TransmissionInterfaceEntitlement)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ContractRight rdf:ID=\"%s\">\n%s\t</cim:ContractRight>".format (id, export_fields)
    }
}

object ContractRight
extends
    Parseable[ContractRight]
{
    override val fields: Array[String] = Array[String] (
        "chainOrder",
        "contractMW",
        "contractPrice",
        "contractPriority",
        "contractStatus",
        "contractType",
        "financialLocation",
        "financialRightsDAM",
        "financialRightsRTM",
        "fuelAdder",
        "latestSchedMinutes",
        "latestSchedMktType",
        "maxNetDependableCapacity",
        "maximumScheduleQuantity",
        "maximumServiceHours",
        "maximumStartups",
        "minimumLoad",
        "minimumScheduleQuantity",
        "physicalRightsDAM",
        "physicalRightsRTM",
        "startupLeadTime",
        "BidSelfSched",
        "Chain_TransmissionRightChain",
        "ContractDistributionFactor",
        "Ind_TransmissionRightChain",
        "RTO",
        "SchedulingCoordinator",
        "SubstitutionResourceList",
        "TREntitlement",
        "TRType",
        "TransmissionInterfaceEntitlement"
    )
    override val relations: List[Relationship] = List (
        Relationship ("BidSelfSched", "BidSelfSched", "0..*", "0..1"),
        Relationship ("Chain_TransmissionRightChain", "TransmissionRightChain", "0..1", "1"),
        Relationship ("ContractDistributionFactor", "ContractDistributionFactor", "0..*", "0..1"),
        Relationship ("Ind_TransmissionRightChain", "TransmissionRightChain", "0..1", "1..*"),
        Relationship ("RTO", "RTO", "1", "0..*"),
        Relationship ("SchedulingCoordinator", "SchedulingCoordinator", "1", "0..*"),
        Relationship ("SubstitutionResourceList", "SubstitutionResourceList", "0..*", "0..1"),
        Relationship ("TREntitlement", "TREntitlement", "0..*", "1"),
        Relationship ("TransmissionInterfaceEntitlement", "TransmissionInterfaceRightEntitlement", "0..*", "1")
    )
    val chainOrder: Fielder = parse_element (element (cls, fields(0)))
    val contractMW: Fielder = parse_element (element (cls, fields(1)))
    val contractPrice: Fielder = parse_element (element (cls, fields(2)))
    val contractPriority: Fielder = parse_element (element (cls, fields(3)))
    val contractStatus: Fielder = parse_element (element (cls, fields(4)))
    val contractType: Fielder = parse_attribute (attribute (cls, fields(5)))
    val financialLocation: Fielder = parse_attribute (attribute (cls, fields(6)))
    val financialRightsDAM: Fielder = parse_attribute (attribute (cls, fields(7)))
    val financialRightsRTM: Fielder = parse_attribute (attribute (cls, fields(8)))
    val fuelAdder: Fielder = parse_element (element (cls, fields(9)))
    val latestSchedMinutes: Fielder = parse_element (element (cls, fields(10)))
    val latestSchedMktType: Fielder = parse_attribute (attribute (cls, fields(11)))
    val maxNetDependableCapacity: Fielder = parse_element (element (cls, fields(12)))
    val maximumScheduleQuantity: Fielder = parse_element (element (cls, fields(13)))
    val maximumServiceHours: Fielder = parse_element (element (cls, fields(14)))
    val maximumStartups: Fielder = parse_element (element (cls, fields(15)))
    val minimumLoad: Fielder = parse_element (element (cls, fields(16)))
    val minimumScheduleQuantity: Fielder = parse_element (element (cls, fields(17)))
    val physicalRightsDAM: Fielder = parse_attribute (attribute (cls, fields(18)))
    val physicalRightsRTM: Fielder = parse_attribute (attribute (cls, fields(19)))
    val startupLeadTime: Fielder = parse_element (element (cls, fields(20)))
    val BidSelfSched: FielderMultiple = parse_attributes (attribute (cls, fields(21)))
    val Chain_TransmissionRightChain: Fielder = parse_attribute (attribute (cls, fields(22)))
    val ContractDistributionFactor: FielderMultiple = parse_attributes (attribute (cls, fields(23)))
    val Ind_TransmissionRightChain: Fielder = parse_attribute (attribute (cls, fields(24)))
    val RTO: Fielder = parse_attribute (attribute (cls, fields(25)))
    val SchedulingCoordinator: Fielder = parse_attribute (attribute (cls, fields(26)))
    val SubstitutionResourceList: FielderMultiple = parse_attributes (attribute (cls, fields(27)))
    val TREntitlement: FielderMultiple = parse_attributes (attribute (cls, fields(28)))
    val TRType: Fielder = parse_attribute (attribute (cls, fields(29)))
    val TransmissionInterfaceEntitlement: FielderMultiple = parse_attributes (attribute (cls, fields(30)))

    def parse (context: Context): ContractRight =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ContractRight (
            IdentifiedObject.parse (context),
            toInteger (mask (chainOrder (), 0)),
            toDouble (mask (contractMW (), 1)),
            toDouble (mask (contractPrice (), 2)),
            toInteger (mask (contractPriority (), 3)),
            mask (contractStatus (), 4),
            mask (contractType (), 5),
            mask (financialLocation (), 6),
            mask (financialRightsDAM (), 7),
            mask (financialRightsRTM (), 8),
            toDouble (mask (fuelAdder (), 9)),
            toInteger (mask (latestSchedMinutes (), 10)),
            mask (latestSchedMktType (), 11),
            toDouble (mask (maxNetDependableCapacity (), 12)),
            toDouble (mask (maximumScheduleQuantity (), 13)),
            toInteger (mask (maximumServiceHours (), 14)),
            toInteger (mask (maximumStartups (), 15)),
            toDouble (mask (minimumLoad (), 16)),
            toDouble (mask (minimumScheduleQuantity (), 17)),
            mask (physicalRightsDAM (), 18),
            mask (physicalRightsRTM (), 19),
            toInteger (mask (startupLeadTime (), 20)),
            masks (BidSelfSched (), 21),
            mask (Chain_TransmissionRightChain (), 22),
            masks (ContractDistributionFactor (), 23),
            mask (Ind_TransmissionRightChain (), 24),
            mask (RTO (), 25),
            mask (SchedulingCoordinator (), 26),
            masks (SubstitutionResourceList (), 27),
            masks (TREntitlement (), 28),
            mask (TRType (), 29),
            masks (TransmissionInterfaceEntitlement (), 30)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Indicates Control Area associated with self-schedule.
 *
 * @param sup Reference to the superclass object.
 * @param attained Attained.
 * @param native Native.
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @param SubControlArea [[ch.ninecode.model.SubControlArea SubControlArea]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class ControlAreaDesignation
(
    override val sup: BasicElement,
    attained: String,
    `native`: String,
    RegisteredResource: List[String],
    SubControlArea: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ControlAreaDesignation.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ControlAreaDesignation.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (ControlAreaDesignation.fields (position), x))
        emitattr (0, attained)
        emitattr (1, `native`)
        emitattrs (2, RegisteredResource)
        emitattrs (3, SubControlArea)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ControlAreaDesignation rdf:ID=\"%s\">\n%s\t</cim:ControlAreaDesignation>".format (id, export_fields)
    }
}

object ControlAreaDesignation
extends
    Parseable[ControlAreaDesignation]
{
    override val fields: Array[String] = Array[String] (
        "attained",
        "native",
        "RegisteredResource",
        "SubControlArea"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RegisteredResource", "RegisteredResource", "0..*", "0..*"),
        Relationship ("SubControlArea", "SubControlArea", "0..*", "0..*")
    )
    val attained: Fielder = parse_attribute (attribute (cls, fields(0)))
    val `native`: Fielder = parse_attribute (attribute (cls, fields(1)))
    val RegisteredResource: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val SubControlArea: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: Context): ControlAreaDesignation =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ControlAreaDesignation (
            BasicElement.parse (context),
            mask (attained (), 0),
            mask (`native` (), 1),
            masks (RegisteredResource (), 2),
            masks (SubControlArea (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A flowgate, is single or group of transmission elements intended to model MW flow impact relating to transmission limitations and transmission service usage.
 *
 * @param sup [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param direction The direction of the flowgate, export or import
 * @param exportMWRating Export MW rating
 * @param importMWRating Import MW rating
 * @param CongestionRevenueRight [[ch.ninecode.model.CongestionRevenueRight CongestionRevenueRight]] <em>undocumented</em>
 * @param ConstraintResults [[ch.ninecode.model.ConstraintResults ConstraintResults]] <em>undocumented</em>
 * @param ContractDistributionFactor [[ch.ninecode.model.ContractDistributionFactor ContractDistributionFactor]] <em>undocumented</em>
 * @param FTRs [[ch.ninecode.model.FTR FTR]] <em>undocumented</em>
 * @param FlowgateRelief [[ch.ninecode.model.FlowgateRelief FlowgateRelief]] <em>undocumented</em>
 * @param FlowgateValue [[ch.ninecode.model.FlowgateValue FlowgateValue]] <em>undocumented</em>
 * @param From_SubControlArea [[ch.ninecode.model.SubControlArea SubControlArea]] <em>undocumented</em>
 * @param GeneratingUnitDynamicValues [[ch.ninecode.model.GeneratingUnitDynamicValues GeneratingUnitDynamicValues]] <em>undocumented</em>
 * @param GenericConstraints [[ch.ninecode.model.GenericConstraints GenericConstraints]] <em>undocumented</em>
 * @param HostControlArea [[ch.ninecode.model.HostControlArea HostControlArea]] <em>undocumented</em>
 * @param InterTie [[ch.ninecode.model.SchedulingPoint SchedulingPoint]] <em>undocumented</em>
 * @param InterTieResults [[ch.ninecode.model.InterTieResults InterTieResults]] <em>undocumented</em>
 * @param MktLine [[ch.ninecode.model.MktLine MktLine]] <em>undocumented</em>
 * @param MktPowerTransformer [[ch.ninecode.model.MktPowerTransformer MktPowerTransformer]] <em>undocumented</em>
 * @param MktTerminal [[ch.ninecode.model.MktTerminal MktTerminal]] <em>undocumented</em>
 * @param RegisteredInterTie [[ch.ninecode.model.RegisteredInterTie RegisteredInterTie]] <em>undocumented</em>
 * @param SecurityConstraints [[ch.ninecode.model.SecurityConstraints SecurityConstraints]] <em>undocumented</em>
 * @param To_SubControlArea [[ch.ninecode.model.SubControlArea SubControlArea]] <em>undocumented</em>
 * @param TranmissionRightEntitlement [[ch.ninecode.model.TransmissionInterfaceRightEntitlement TransmissionInterfaceRightEntitlement]] <em>undocumented</em>
 * @param TransmissionCapacity [[ch.ninecode.model.TransmissionCapacity TransmissionCapacity]] <em>undocumented</em>
 * @param ViolationLimits [[ch.ninecode.model.ViolationLimit ViolationLimit]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class Flowgate
(
    override val sup: PowerSystemResource,
    direction: String,
    exportMWRating: Double,
    importMWRating: Double,
    CongestionRevenueRight: String,
    ConstraintResults: List[String],
    ContractDistributionFactor: List[String],
    FTRs: List[String],
    FlowgateRelief: List[String],
    FlowgateValue: List[String],
    From_SubControlArea: String,
    GeneratingUnitDynamicValues: List[String],
    GenericConstraints: String,
    HostControlArea: String,
    InterTie: List[String],
    InterTieResults: List[String],
    MktLine: List[String],
    MktPowerTransformer: List[String],
    MktTerminal: List[String],
    RegisteredInterTie: List[String],
    SecurityConstraints: String,
    To_SubControlArea: String,
    TranmissionRightEntitlement: List[String],
    TransmissionCapacity: List[String],
    ViolationLimits: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, 0.0, null, List(), List(), List(), List(), List(), null, List(), null, null, List(), List(), List(), List(), List(), List(), null, null, List(), List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Flowgate.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Flowgate.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Flowgate.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (Flowgate.fields (position), x))
        emitattr (0, direction)
        emitelem (1, exportMWRating)
        emitelem (2, importMWRating)
        emitattr (3, CongestionRevenueRight)
        emitattrs (4, ConstraintResults)
        emitattrs (5, ContractDistributionFactor)
        emitattrs (6, FTRs)
        emitattrs (7, FlowgateRelief)
        emitattrs (8, FlowgateValue)
        emitattr (9, From_SubControlArea)
        emitattrs (10, GeneratingUnitDynamicValues)
        emitattr (11, GenericConstraints)
        emitattr (12, HostControlArea)
        emitattrs (13, InterTie)
        emitattrs (14, InterTieResults)
        emitattrs (15, MktLine)
        emitattrs (16, MktPowerTransformer)
        emitattrs (17, MktTerminal)
        emitattrs (18, RegisteredInterTie)
        emitattr (19, SecurityConstraints)
        emitattr (20, To_SubControlArea)
        emitattrs (21, TranmissionRightEntitlement)
        emitattrs (22, TransmissionCapacity)
        emitattrs (23, ViolationLimits)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Flowgate rdf:ID=\"%s\">\n%s\t</cim:Flowgate>".format (id, export_fields)
    }
}

object Flowgate
extends
    Parseable[Flowgate]
{
    override val fields: Array[String] = Array[String] (
        "direction",
        "exportMWRating",
        "importMWRating",
        "CongestionRevenueRight",
        "ConstraintResults",
        "ContractDistributionFactor",
        "FTRs",
        "FlowgateRelief",
        "FlowgateValue",
        "From_SubControlArea",
        "GeneratingUnitDynamicValues",
        "GenericConstraints",
        "HostControlArea",
        "InterTie",
        "InterTieResults",
        "MktLine",
        "MktPowerTransformer",
        "MktTerminal",
        "RegisteredInterTie",
        "SecurityConstraints",
        "To_SubControlArea",
        "TranmissionRightEntitlement",
        "TransmissionCapacity",
        "ViolationLimits"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CongestionRevenueRight", "CongestionRevenueRight", "0..1", "0..1"),
        Relationship ("ConstraintResults", "ConstraintResults", "1..*", "1"),
        Relationship ("ContractDistributionFactor", "ContractDistributionFactor", "0..*", "0..1"),
        Relationship ("FTRs", "FTR", "0..*", "0..1"),
        Relationship ("FlowgateRelief", "FlowgateRelief", "0..*", "1"),
        Relationship ("FlowgateValue", "FlowgateValue", "0..*", "1"),
        Relationship ("From_SubControlArea", "SubControlArea", "0..1", "0..*"),
        Relationship ("GeneratingUnitDynamicValues", "GeneratingUnitDynamicValues", "0..*", "0..1"),
        Relationship ("GenericConstraints", "GenericConstraints", "0..1", "0..*"),
        Relationship ("HostControlArea", "HostControlArea", "0..1", "0..*"),
        Relationship ("InterTie", "SchedulingPoint", "0..*", "0..1"),
        Relationship ("InterTieResults", "InterTieResults", "1..*", "1"),
        Relationship ("MktLine", "MktLine", "0..*", "0..*"),
        Relationship ("MktPowerTransformer", "MktPowerTransformer", "0..*", "0..*"),
        Relationship ("MktTerminal", "MktTerminal", "0..*", "0..1"),
        Relationship ("RegisteredInterTie", "RegisteredInterTie", "0..*", "1"),
        Relationship ("SecurityConstraints", "SecurityConstraints", "0..1", "0..1"),
        Relationship ("To_SubControlArea", "SubControlArea", "0..1", "0..*"),
        Relationship ("TranmissionRightEntitlement", "TransmissionInterfaceRightEntitlement", "0..*", "0..1"),
        Relationship ("TransmissionCapacity", "TransmissionCapacity", "0..*", "0..1"),
        Relationship ("ViolationLimits", "ViolationLimit", "0..*", "0..1")
    )
    val direction: Fielder = parse_attribute (attribute (cls, fields(0)))
    val exportMWRating: Fielder = parse_element (element (cls, fields(1)))
    val importMWRating: Fielder = parse_element (element (cls, fields(2)))
    val CongestionRevenueRight: Fielder = parse_attribute (attribute (cls, fields(3)))
    val ConstraintResults: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val ContractDistributionFactor: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val FTRs: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val FlowgateRelief: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val FlowgateValue: FielderMultiple = parse_attributes (attribute (cls, fields(8)))
    val From_SubControlArea: Fielder = parse_attribute (attribute (cls, fields(9)))
    val GeneratingUnitDynamicValues: FielderMultiple = parse_attributes (attribute (cls, fields(10)))
    val GenericConstraints: Fielder = parse_attribute (attribute (cls, fields(11)))
    val HostControlArea: Fielder = parse_attribute (attribute (cls, fields(12)))
    val InterTie: FielderMultiple = parse_attributes (attribute (cls, fields(13)))
    val InterTieResults: FielderMultiple = parse_attributes (attribute (cls, fields(14)))
    val MktLine: FielderMultiple = parse_attributes (attribute (cls, fields(15)))
    val MktPowerTransformer: FielderMultiple = parse_attributes (attribute (cls, fields(16)))
    val MktTerminal: FielderMultiple = parse_attributes (attribute (cls, fields(17)))
    val RegisteredInterTie: FielderMultiple = parse_attributes (attribute (cls, fields(18)))
    val SecurityConstraints: Fielder = parse_attribute (attribute (cls, fields(19)))
    val To_SubControlArea: Fielder = parse_attribute (attribute (cls, fields(20)))
    val TranmissionRightEntitlement: FielderMultiple = parse_attributes (attribute (cls, fields(21)))
    val TransmissionCapacity: FielderMultiple = parse_attributes (attribute (cls, fields(22)))
    val ViolationLimits: FielderMultiple = parse_attributes (attribute (cls, fields(23)))

    def parse (context: Context): Flowgate =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Flowgate (
            PowerSystemResource.parse (context),
            mask (direction (), 0),
            toDouble (mask (exportMWRating (), 1)),
            toDouble (mask (importMWRating (), 2)),
            mask (CongestionRevenueRight (), 3),
            masks (ConstraintResults (), 4),
            masks (ContractDistributionFactor (), 5),
            masks (FTRs (), 6),
            masks (FlowgateRelief (), 7),
            masks (FlowgateValue (), 8),
            mask (From_SubControlArea (), 9),
            masks (GeneratingUnitDynamicValues (), 10),
            mask (GenericConstraints (), 11),
            mask (HostControlArea (), 12),
            masks (InterTie (), 13),
            masks (InterTieResults (), 14),
            masks (MktLine (), 15),
            masks (MktPowerTransformer (), 16),
            masks (MktTerminal (), 17),
            masks (RegisteredInterTie (), 18),
            mask (SecurityConstraints (), 19),
            mask (To_SubControlArea (), 20),
            masks (TranmissionRightEntitlement (), 21),
            masks (TransmissionCapacity (), 22),
            masks (ViolationLimits (), 23)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Flowgate defined partner.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param FlowgateValue [[ch.ninecode.model.FlowgateValue FlowgateValue]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class FlowgatePartner
(
    override val sup: IdentifiedObject,
    FlowgateValue: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = FlowgatePartner.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (FlowgatePartner.fields (position), value)
        emitattr (0, FlowgateValue)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:FlowgatePartner rdf:ID=\"%s\">\n%s\t</cim:FlowgatePartner>".format (id, export_fields)
    }
}

object FlowgatePartner
extends
    Parseable[FlowgatePartner]
{
    override val fields: Array[String] = Array[String] (
        "FlowgateValue"
    )
    override val relations: List[Relationship] = List (
        Relationship ("FlowgateValue", "FlowgateValue", "0..1", "0..1")
    )
    val FlowgateValue: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): FlowgatePartner =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = FlowgatePartner (
            IdentifiedObject.parse (context),
            mask (FlowgateValue (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * IDC (Interchange Distribution Calulator) sends data for a TLR (Transmission Loading Relief).
 *
 * @param sup Reference to the superclass object.
 * @param effectiveDate Date/Time when record becomes effective
 *        Used to determine when a record becomes effective.
 * @param idcTargetMktFlow Energy Flow level that should be maintained according to the TLR rules as specified by the IDC.
 *        For Realtime Markets use in dispatch to control constraints under TLR and calculate unconstrained market flows
 * @param terminateDate Date/Time when record is no longer effective
 *        Used to determine when a record is no longer effective
 * @param Flowgate [[ch.ninecode.model.Flowgate Flowgate]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
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
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = FlowgateRelief.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (FlowgateRelief.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (FlowgateRelief.fields (position), value)
        emitelem (0, effectiveDate)
        emitelem (1, idcTargetMktFlow)
        emitelem (2, terminateDate)
        emitattr (3, Flowgate)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:FlowgateRelief rdf:ID=\"%s\">\n%s\t</cim:FlowgateRelief>".format (id, export_fields)
    }
}

object FlowgateRelief
extends
    Parseable[FlowgateRelief]
{
    override val fields: Array[String] = Array[String] (
        "effectiveDate",
        "idcTargetMktFlow",
        "terminateDate",
        "Flowgate"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Flowgate", "Flowgate", "1", "0..*")
    )
    val effectiveDate: Fielder = parse_element (element (cls, fields(0)))
    val idcTargetMktFlow: Fielder = parse_element (element (cls, fields(1)))
    val terminateDate: Fielder = parse_element (element (cls, fields(2)))
    val Flowgate: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): FlowgateRelief =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = FlowgateRelief (
            BasicElement.parse (context),
            mask (effectiveDate (), 0),
            toInteger (mask (idcTargetMktFlow (), 1)),
            mask (terminateDate (), 2),
            mask (Flowgate (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Day Ahead,  Network Native Load, Economic Dispatch, values used for calculation of Network Native Load (NNL) Determinator process.
 *
 * @param sup Reference to the superclass object.
 * @param economicDispatchLimit Limit for Economic Dispatch priority 6 energy flow on the specified flowgate for the specified time period.
 * @param effectiveDate Date/Time when record becomes effective
 *        Used to determine when a record becomes effective
 * @param firmNetworkLimit Limit for firm flow on the specified flowgate for the specified time period.
 *        The amount of energy flow over a specifed flowgate due to generation in the market which can be classified as Firm Network priority.
 * @param flowDirectionFlag Specifies the direction of energy flow in the flowgate
 * @param mktFlow The amount of energy flow over a specifed flowgate due to generation in the market.
 * @param netFirmNetworkLimit Net Energy flow in flowgate for the associated FlowgatePartner
 * @param Flowgate [[ch.ninecode.model.Flowgate Flowgate]] <em>undocumented</em>
 * @param FlowgatePartner [[ch.ninecode.model.FlowgatePartner FlowgatePartner]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
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
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0, null, 0, null, 0, 0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = FlowgateValue.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (FlowgateValue.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (FlowgateValue.fields (position), value)
        emitelem (0, economicDispatchLimit)
        emitelem (1, effectiveDate)
        emitelem (2, firmNetworkLimit)
        emitattr (3, flowDirectionFlag)
        emitelem (4, mktFlow)
        emitelem (5, netFirmNetworkLimit)
        emitattr (6, Flowgate)
        emitattr (7, FlowgatePartner)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:FlowgateValue rdf:ID=\"%s\">\n%s\t</cim:FlowgateValue>".format (id, export_fields)
    }
}

object FlowgateValue
extends
    Parseable[FlowgateValue]
{
    override val fields: Array[String] = Array[String] (
        "economicDispatchLimit",
        "effectiveDate",
        "firmNetworkLimit",
        "flowDirectionFlag",
        "mktFlow",
        "netFirmNetworkLimit",
        "Flowgate",
        "FlowgatePartner"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Flowgate", "Flowgate", "1", "0..*"),
        Relationship ("FlowgatePartner", "FlowgatePartner", "0..1", "0..1")
    )
    val economicDispatchLimit: Fielder = parse_element (element (cls, fields(0)))
    val effectiveDate: Fielder = parse_element (element (cls, fields(1)))
    val firmNetworkLimit: Fielder = parse_element (element (cls, fields(2)))
    val flowDirectionFlag: Fielder = parse_attribute (attribute (cls, fields(3)))
    val mktFlow: Fielder = parse_element (element (cls, fields(4)))
    val netFirmNetworkLimit: Fielder = parse_element (element (cls, fields(5)))
    val Flowgate: Fielder = parse_attribute (attribute (cls, fields(6)))
    val FlowgatePartner: Fielder = parse_attribute (attribute (cls, fields(7)))

    def parse (context: Context): FlowgateValue =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = FlowgateValue (
            BasicElement.parse (context),
            toInteger (mask (economicDispatchLimit (), 0)),
            mask (effectiveDate (), 1),
            toInteger (mask (firmNetworkLimit (), 2)),
            mask (flowDirectionFlag (), 3),
            toInteger (mask (mktFlow (), 4)),
            toInteger (mask (netFirmNetworkLimit (), 5)),
            mask (Flowgate (), 6),
            mask (FlowgatePartner (), 7)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Forbbiden region is operating ranges where the units are unable to maintain steady operation without causing equipment damage.
 *
 * The four attributes that define a forbidden region are the low MW, the High MW, the crossing time, and the crossing cost.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param crossTime Time to cross the forbidden region in minutes.
 * @param crossingCost Cost associated with crossing the forbidden region
 * @param highMW High end of the region definition
 * @param lowMW Low end of the region definition.
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class ForbiddenRegion
(
    override val sup: IdentifiedObject,
    crossTime: Int,
    crossingCost: Double,
    highMW: Double,
    lowMW: Double,
    RegisteredResource: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0, 0.0, 0.0, 0.0, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ForbiddenRegion.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ForbiddenRegion.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (ForbiddenRegion.fields (position), x))
        emitelem (0, crossTime)
        emitelem (1, crossingCost)
        emitelem (2, highMW)
        emitelem (3, lowMW)
        emitattrs (4, RegisteredResource)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ForbiddenRegion rdf:ID=\"%s\">\n%s\t</cim:ForbiddenRegion>".format (id, export_fields)
    }
}

object ForbiddenRegion
extends
    Parseable[ForbiddenRegion]
{
    override val fields: Array[String] = Array[String] (
        "crossTime",
        "crossingCost",
        "highMW",
        "lowMW",
        "RegisteredResource"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RegisteredResource", "RegisteredResource", "0..*", "0..*")
    )
    val crossTime: Fielder = parse_element (element (cls, fields(0)))
    val crossingCost: Fielder = parse_element (element (cls, fields(1)))
    val highMW: Fielder = parse_element (element (cls, fields(2)))
    val lowMW: Fielder = parse_element (element (cls, fields(3)))
    val RegisteredResource: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: Context): ForbiddenRegion =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ForbiddenRegion (
            IdentifiedObject.parse (context),
            toInteger (mask (crossTime (), 0)),
            toDouble (mask (crossingCost (), 1)),
            toDouble (mask (highMW (), 2)),
            toDouble (mask (lowMW (), 3)),
            masks (RegisteredResource (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Used to indicate former references to the same piece of equipment.
 *
 * The ID, name, and effectivity dates are utilized.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class FormerReference
(
    override val sup: IdentifiedObject,
    RegisteredResource: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = FormerReference.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (FormerReference.fields (position), value)
        emitattr (0, RegisteredResource)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:FormerReference rdf:ID=\"%s\">\n%s\t</cim:FormerReference>".format (id, export_fields)
    }
}

object FormerReference
extends
    Parseable[FormerReference]
{
    override val fields: Array[String] = Array[String] (
        "RegisteredResource"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RegisteredResource", "RegisteredResource", "1", "0..*")
    )
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): FormerReference =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = FormerReference (
            IdentifiedObject.parse (context),
            mask (RegisteredResource (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Relationship between unit fuel cost in \$/kWh(Y-axis) and  unit output in MW (X-axis).
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param RegisteredGenerator [[ch.ninecode.model.RegisteredGenerator RegisteredGenerator]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class FuelCostCurve
(
    override val sup: Curve,
    RegisteredGenerator: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = FuelCostCurve.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (FuelCostCurve.fields (position), value)
        emitattr (0, RegisteredGenerator)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:FuelCostCurve rdf:ID=\"%s\">\n%s\t</cim:FuelCostCurve>".format (id, export_fields)
    }
}

object FuelCostCurve
extends
    Parseable[FuelCostCurve]
{
    override val fields: Array[String] = Array[String] (
        "RegisteredGenerator"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RegisteredGenerator", "RegisteredGenerator", "0..1", "0..1")
    )
    val RegisteredGenerator: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): FuelCostCurve =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = FuelCostCurve (
            Curve.parse (context),
            mask (RegisteredGenerator (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Indication of region for fuel inventory purposes.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param fuelRegionType The type of fuel region
 * @param lastModified Time of last update
 * @param GasPrice [[ch.ninecode.model.GasPrice GasPrice]] <em>undocumented</em>
 * @param OilPrice [[ch.ninecode.model.OilPrice OilPrice]] <em>undocumented</em>
 * @param RTO [[ch.ninecode.model.RTO RTO]] <em>undocumented</em>
 * @param RegisteredGenerator [[ch.ninecode.model.RegisteredGenerator RegisteredGenerator]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class FuelRegion
(
    override val sup: IdentifiedObject,
    fuelRegionType: String,
    lastModified: String,
    GasPrice: String,
    OilPrice: String,
    RTO: String,
    RegisteredGenerator: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = FuelRegion.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (FuelRegion.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (FuelRegion.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (FuelRegion.fields (position), x))
        emitelem (0, fuelRegionType)
        emitelem (1, lastModified)
        emitattr (2, GasPrice)
        emitattr (3, OilPrice)
        emitattr (4, RTO)
        emitattrs (5, RegisteredGenerator)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:FuelRegion rdf:ID=\"%s\">\n%s\t</cim:FuelRegion>".format (id, export_fields)
    }
}

object FuelRegion
extends
    Parseable[FuelRegion]
{
    override val fields: Array[String] = Array[String] (
        "fuelRegionType",
        "lastModified",
        "GasPrice",
        "OilPrice",
        "RTO",
        "RegisteredGenerator"
    )
    override val relations: List[Relationship] = List (
        Relationship ("GasPrice", "GasPrice", "1", "1"),
        Relationship ("OilPrice", "OilPrice", "1", "1"),
        Relationship ("RTO", "RTO", "1", "0..*"),
        Relationship ("RegisteredGenerator", "RegisteredGenerator", "0..*", "0..1")
    )
    val fuelRegionType: Fielder = parse_element (element (cls, fields(0)))
    val lastModified: Fielder = parse_element (element (cls, fields(1)))
    val GasPrice: Fielder = parse_attribute (attribute (cls, fields(2)))
    val OilPrice: Fielder = parse_attribute (attribute (cls, fields(3)))
    val RTO: Fielder = parse_attribute (attribute (cls, fields(4)))
    val RegisteredGenerator: FielderMultiple = parse_attributes (attribute (cls, fields(5)))

    def parse (context: Context): FuelRegion =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = FuelRegion (
            IdentifiedObject.parse (context),
            mask (fuelRegionType (), 0),
            mask (lastModified (), 1),
            mask (GasPrice (), 2),
            mask (OilPrice (), 3),
            mask (RTO (), 4),
            masks (RegisteredGenerator (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Price of gas in monetary units.
 *
 * @param sup Reference to the superclass object.
 * @param gasPriceIndex The average natural gas price at a defined fuel region.
 * @param FuelRegion [[ch.ninecode.model.FuelRegion FuelRegion]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
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
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = GasPrice.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GasPrice.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (GasPrice.fields (position), value)
        emitelem (0, gasPriceIndex)
        emitattr (1, FuelRegion)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GasPrice rdf:ID=\"%s\">\n%s\t</cim:GasPrice>".format (id, export_fields)
    }
}

object GasPrice
extends
    Parseable[GasPrice]
{
    override val fields: Array[String] = Array[String] (
        "gasPriceIndex",
        "FuelRegion"
    )
    override val relations: List[Relationship] = List (
        Relationship ("FuelRegion", "FuelRegion", "1", "1")
    )
    val gasPriceIndex: Fielder = parse_element (element (cls, fields(0)))
    val FuelRegion: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): GasPrice =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = GasPrice (
            BasicElement.parse (context),
            toDouble (mask (gasPriceIndex (), 0)),
            mask (FuelRegion (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A HostControlArea has a set of tie points and a set of generator controls (i.e., AGC).
 *
 * It also has a total load, including transmission and distribution losses.
 *
 * @param sup [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param areaControlMode The area's present control mode: (CF = constant frequency) or (CTL = constant tie-line) or (TLB = tie-line bias) or (OFF = off control)
 * @param freqSetPoint The present power system frequency set point for automatic generation control
 * @param frequencyBiasFactor The control area's frequency bias factor, in MW/0.1 Hz, for automatic generation control (AGC)
 * @param AdjacentCASet [[ch.ninecode.model.AdjacentCASet AdjacentCASet]] <em>undocumented</em>
 * @param BidSelfSched [[ch.ninecode.model.BidSelfSched BidSelfSched]] <em>undocumented</em>
 * @param CnodeDistributionFactor [[ch.ninecode.model.CnodeDistributionFactor CnodeDistributionFactor]] <em>undocumented</em>
 * @param Controls [[ch.ninecode.model.ControlAreaOperator ControlAreaOperator]] A ControlAreaCompany controls a ControlArea.
 * @param Flowgate [[ch.ninecode.model.Flowgate Flowgate]] <em>undocumented</em>
 * @param LossClearingResults [[ch.ninecode.model.LossClearingResults LossClearingResults]] <em>undocumented</em>
 * @param RTO [[ch.ninecode.model.RTO RTO]] <em>undocumented</em>
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @param SubControlAreas [[ch.ninecode.model.SubControlArea SubControlArea]] The interchange area  may operate as a control area
 * @param SysLoadDistribuFactor [[ch.ninecode.model.SysLoadDistributionFactor SysLoadDistributionFactor]] <em>undocumented</em>
 * @param TransferInterface [[ch.ninecode.model.TransferInterface TransferInterface]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class HostControlArea
(
    override val sup: PowerSystemResource,
    areaControlMode: String,
    freqSetPoint: Double,
    frequencyBiasFactor: Double,
    AdjacentCASet: String,
    BidSelfSched: List[String],
    CnodeDistributionFactor: List[String],
    Controls: String,
    Flowgate: List[String],
    LossClearingResults: List[String],
    RTO: String,
    RegisteredResource: List[String],
    SubControlAreas: List[String],
    SysLoadDistribuFactor: List[String],
    TransferInterface: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, 0.0, null, List(), List(), null, List(), List(), null, List(), List(), List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = HostControlArea.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (HostControlArea.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (HostControlArea.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (HostControlArea.fields (position), x))
        emitattr (0, areaControlMode)
        emitelem (1, freqSetPoint)
        emitelem (2, frequencyBiasFactor)
        emitattr (3, AdjacentCASet)
        emitattrs (4, BidSelfSched)
        emitattrs (5, CnodeDistributionFactor)
        emitattr (6, Controls)
        emitattrs (7, Flowgate)
        emitattrs (8, LossClearingResults)
        emitattr (9, RTO)
        emitattrs (10, RegisteredResource)
        emitattrs (11, SubControlAreas)
        emitattrs (12, SysLoadDistribuFactor)
        emitattrs (13, TransferInterface)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:HostControlArea rdf:ID=\"%s\">\n%s\t</cim:HostControlArea>".format (id, export_fields)
    }
}

object HostControlArea
extends
    Parseable[HostControlArea]
{
    override val fields: Array[String] = Array[String] (
        "areaControlMode",
        "freqSetPoint",
        "frequencyBiasFactor",
        "AdjacentCASet",
        "BidSelfSched",
        "CnodeDistributionFactor",
        "Controls",
        "Flowgate",
        "LossClearingResults",
        "RTO",
        "RegisteredResource",
        "SubControlAreas",
        "SysLoadDistribuFactor",
        "TransferInterface"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AdjacentCASet", "AdjacentCASet", "0..1", "0..1"),
        Relationship ("BidSelfSched", "BidSelfSched", "0..*", "0..1"),
        Relationship ("CnodeDistributionFactor", "CnodeDistributionFactor", "0..*", "0..1"),
        Relationship ("Controls", "ControlAreaOperator", "1", "1"),
        Relationship ("Flowgate", "Flowgate", "0..*", "0..1"),
        Relationship ("LossClearingResults", "LossClearingResults", "0..*", "0..1"),
        Relationship ("RTO", "RTO", "1", "0..*"),
        Relationship ("RegisteredResource", "RegisteredResource", "0..*", "0..1"),
        Relationship ("SubControlAreas", "SubControlArea", "0..*", "1"),
        Relationship ("SysLoadDistribuFactor", "SysLoadDistributionFactor", "0..*", "1"),
        Relationship ("TransferInterface", "TransferInterface", "0..*", "0..1")
    )
    val areaControlMode: Fielder = parse_attribute (attribute (cls, fields(0)))
    val freqSetPoint: Fielder = parse_element (element (cls, fields(1)))
    val frequencyBiasFactor: Fielder = parse_element (element (cls, fields(2)))
    val AdjacentCASet: Fielder = parse_attribute (attribute (cls, fields(3)))
    val BidSelfSched: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val CnodeDistributionFactor: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val Controls: Fielder = parse_attribute (attribute (cls, fields(6)))
    val Flowgate: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val LossClearingResults: FielderMultiple = parse_attributes (attribute (cls, fields(8)))
    val RTO: Fielder = parse_attribute (attribute (cls, fields(9)))
    val RegisteredResource: FielderMultiple = parse_attributes (attribute (cls, fields(10)))
    val SubControlAreas: FielderMultiple = parse_attributes (attribute (cls, fields(11)))
    val SysLoadDistribuFactor: FielderMultiple = parse_attributes (attribute (cls, fields(12)))
    val TransferInterface: FielderMultiple = parse_attributes (attribute (cls, fields(13)))

    def parse (context: Context): HostControlArea =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = HostControlArea (
            PowerSystemResource.parse (context),
            mask (areaControlMode (), 0),
            toDouble (mask (freqSetPoint (), 1)),
            toDouble (mask (frequencyBiasFactor (), 2)),
            mask (AdjacentCASet (), 3),
            masks (BidSelfSched (), 4),
            masks (CnodeDistributionFactor (), 5),
            mask (Controls (), 6),
            masks (Flowgate (), 7),
            masks (LossClearingResults (), 8),
            mask (RTO (), 9),
            masks (RegisteredResource (), 10),
            masks (SubControlAreas (), 11),
            masks (SysLoadDistribuFactor (), 12),
            masks (TransferInterface (), 13)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Individual pricing node based on Pnode.
 *
 * @param sup [[ch.ninecode.model.Pnode Pnode]] Reference to the superclass object.
 * @param CongestionArea [[ch.ninecode.model.CongestionArea CongestionArea]] <em>undocumented</em>
 * @param GenDistributionFactor [[ch.ninecode.model.GenDistributionFactor GenDistributionFactor]] <em>undocumented</em>
 * @param LoadDistributionFactor [[ch.ninecode.model.LoadDistributionFactor LoadDistributionFactor]] <em>undocumented</em>
 * @param MktConnectivityNode [[ch.ninecode.model.MktConnectivityNode MktConnectivityNode]] <em>undocumented</em>
 * @param PnodeDistributionFactor [[ch.ninecode.model.PnodeDistributionFactor PnodeDistributionFactor]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class IndividualPnode
(
    override val sup: Pnode,
    CongestionArea: List[String],
    GenDistributionFactor: String,
    LoadDistributionFactor: String,
    MktConnectivityNode: String,
    PnodeDistributionFactor: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List(), null, null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = IndividualPnode.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (IndividualPnode.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (IndividualPnode.fields (position), x))
        emitattrs (0, CongestionArea)
        emitattr (1, GenDistributionFactor)
        emitattr (2, LoadDistributionFactor)
        emitattr (3, MktConnectivityNode)
        emitattrs (4, PnodeDistributionFactor)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:IndividualPnode rdf:ID=\"%s\">\n%s\t</cim:IndividualPnode>".format (id, export_fields)
    }
}

object IndividualPnode
extends
    Parseable[IndividualPnode]
{
    override val fields: Array[String] = Array[String] (
        "CongestionArea",
        "GenDistributionFactor",
        "LoadDistributionFactor",
        "MktConnectivityNode",
        "PnodeDistributionFactor"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CongestionArea", "CongestionArea", "0..*", "0..*"),
        Relationship ("GenDistributionFactor", "GenDistributionFactor", "0..1", "0..1"),
        Relationship ("LoadDistributionFactor", "LoadDistributionFactor", "0..1", "0..1"),
        Relationship ("MktConnectivityNode", "MktConnectivityNode", "1", "0..1"),
        Relationship ("PnodeDistributionFactor", "PnodeDistributionFactor", "0..*", "1")
    )
    val CongestionArea: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val GenDistributionFactor: Fielder = parse_attribute (attribute (cls, fields(1)))
    val LoadDistributionFactor: Fielder = parse_attribute (attribute (cls, fields(2)))
    val MktConnectivityNode: Fielder = parse_attribute (attribute (cls, fields(3)))
    val PnodeDistributionFactor: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: Context): IndividualPnode =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = IndividualPnode (
            Pnode.parse (context),
            masks (CongestionArea (), 0),
            mask (GenDistributionFactor (), 1),
            mask (LoadDistributionFactor (), 2),
            mask (MktConnectivityNode (), 3),
            masks (PnodeDistributionFactor (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A specialized class of type AggregatedNode type.
 *
 * Defines Load Aggregation Points.
 *
 * @param sup [[ch.ninecode.model.AggregateNode AggregateNode]] Reference to the superclass object.
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class LoadAggregationPoint
(
    override val sup: AggregateNode
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:LoadAggregationPoint rdf:ID=\"%s\">\n%s\t</cim:LoadAggregationPoint>".format (id, export_fields)
    }
}

object LoadAggregationPoint
extends
    Parseable[LoadAggregationPoint]
{

    def parse (context: Context): LoadAggregationPoint =
    {
        implicit val ctx: Context = context
        val ret = LoadAggregationPoint (
            AggregateNode.parse (context)
        )
        ret
    }
}

/**
 * Representing the ratio of the load share for the associated SC.
 *
 * @param sup Reference to the superclass object.
 * @param intervalEndTime Interval End Time
 * @param intervalStartTime Interval Start Time
 * @param share Share in percentage of total Market load for the selected time interval.
 * @param SchedulingCoordinator [[ch.ninecode.model.SchedulingCoordinator SchedulingCoordinator]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
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
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = LoadRatio.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (LoadRatio.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (LoadRatio.fields (position), value)
        emitelem (0, intervalEndTime)
        emitelem (1, intervalStartTime)
        emitelem (2, share)
        emitattr (3, SchedulingCoordinator)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:LoadRatio rdf:ID=\"%s\">\n%s\t</cim:LoadRatio>".format (id, export_fields)
    }
}

object LoadRatio
extends
    Parseable[LoadRatio]
{
    override val fields: Array[String] = Array[String] (
        "intervalEndTime",
        "intervalStartTime",
        "share",
        "SchedulingCoordinator"
    )
    override val relations: List[Relationship] = List (
        Relationship ("SchedulingCoordinator", "SchedulingCoordinator", "0..1", "1")
    )
    val intervalEndTime: Fielder = parse_element (element (cls, fields(0)))
    val intervalStartTime: Fielder = parse_element (element (cls, fields(1)))
    val share: Fielder = parse_element (element (cls, fields(2)))
    val SchedulingCoordinator: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): LoadRatio =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = LoadRatio (
            BasicElement.parse (context),
            mask (intervalEndTime (), 0),
            mask (intervalStartTime (), 1),
            toDouble (mask (share (), 2)),
            mask (SchedulingCoordinator (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Allows definition of reliability areas (e.g.. load pockets) within the ISO/RTO.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param RTO [[ch.ninecode.model.RTO RTO]] <em>undocumented</em>
 * @param RegisteredGenerator [[ch.ninecode.model.RegisteredGenerator RegisteredGenerator]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class LocalReliabilityArea
(
    override val sup: IdentifiedObject,
    RTO: String,
    RegisteredGenerator: List[String]
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = LocalReliabilityArea.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (LocalReliabilityArea.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (LocalReliabilityArea.fields (position), x))
        emitattr (0, RTO)
        emitattrs (1, RegisteredGenerator)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:LocalReliabilityArea rdf:ID=\"%s\">\n%s\t</cim:LocalReliabilityArea>".format (id, export_fields)
    }
}

object LocalReliabilityArea
extends
    Parseable[LocalReliabilityArea]
{
    override val fields: Array[String] = Array[String] (
        "RTO",
        "RegisteredGenerator"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RTO", "RTO", "1", "0..*"),
        Relationship ("RegisteredGenerator", "RegisteredGenerator", "0..*", "0..1")
    )
    val RTO: Fielder = parse_attribute (attribute (cls, fields(0)))
    val RegisteredGenerator: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): LocalReliabilityArea =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = LocalReliabilityArea (
            IdentifiedObject.parse (context),
            mask (RTO (), 0),
            masks (RegisteredGenerator (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Provides a reference to the Market Power Mitigation test identifiers and methods for the results of the DA or RT markets.
 *
 * Specific data is the test identifier (Price, Conduct, or Impact) and the test method (System MPM, Local MPM, Alternate System MPM, or Alternate Local MPM).
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
 * @param MPMResourceStatus [[ch.ninecode.model.MPMResourceStatus MPMResourceStatus]] <em>undocumented</em>
 * @param MPMTestResults [[ch.ninecode.model.MPMTestResults MPMTestResults]] <em>undocumented</em>
 * @param MPMTestThreshold [[ch.ninecode.model.MPMTestThreshold MPMTestThreshold]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class MPMTestCategory
(
    override val sup: IdentifiedObject,
    purposeFlag: String,
    testIdentifier: String,
    testMethod: String,
    MPMResourceStatus: List[String],
    MPMTestResults: List[String],
    MPMTestThreshold: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, List(), List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MPMTestCategory.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MPMTestCategory.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (MPMTestCategory.fields (position), x))
        emitattr (0, purposeFlag)
        emitattr (1, testIdentifier)
        emitattr (2, testMethod)
        emitattrs (3, MPMResourceStatus)
        emitattrs (4, MPMTestResults)
        emitattrs (5, MPMTestThreshold)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MPMTestCategory rdf:ID=\"%s\">\n%s\t</cim:MPMTestCategory>".format (id, export_fields)
    }
}

object MPMTestCategory
extends
    Parseable[MPMTestCategory]
{
    override val fields: Array[String] = Array[String] (
        "purposeFlag",
        "testIdentifier",
        "testMethod",
        "MPMResourceStatus",
        "MPMTestResults",
        "MPMTestThreshold"
    )
    override val relations: List[Relationship] = List (
        Relationship ("MPMResourceStatus", "MPMResourceStatus", "0..*", "1"),
        Relationship ("MPMTestResults", "MPMTestResults", "0..*", "1"),
        Relationship ("MPMTestThreshold", "MPMTestThreshold", "0..*", "1")
    )
    val purposeFlag: Fielder = parse_attribute (attribute (cls, fields(0)))
    val testIdentifier: Fielder = parse_attribute (attribute (cls, fields(1)))
    val testMethod: Fielder = parse_attribute (attribute (cls, fields(2)))
    val MPMResourceStatus: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val MPMTestResults: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val MPMTestThreshold: FielderMultiple = parse_attributes (attribute (cls, fields(5)))

    def parse (context: Context): MPMTestCategory =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MPMTestCategory (
            IdentifiedObject.parse (context),
            mask (purposeFlag (), 0),
            mask (testIdentifier (), 1),
            mask (testMethod (), 2),
            masks (MPMResourceStatus (), 3),
            masks (MPMTestResults (), 4),
            masks (MPMTestThreshold (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Market Power Mitigation (MPM) test thresholds for resource as well as designated congestion areas (DCAs).
 *
 * @param sup Reference to the superclass object.
 * @param marketType Market Type (DAM, RTM)
 * @param percent Price Threshold in %
 * @param price Price Threshold in \$/MW
 * @param AggregatedPnode [[ch.ninecode.model.AggregatedPnode AggregatedPnode]] <em>undocumented</em>
 * @param MPMTestCategory [[ch.ninecode.model.MPMTestCategory MPMTestCategory]] <em>undocumented</em>
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class MPMTestThreshold
(
    override val sup: BasicElement,
    marketType: String,
    percent: Double,
    price: Double,
    AggregatedPnode: List[String],
    MPMTestCategory: String,
    RegisteredResource: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, 0.0, List(), null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MPMTestThreshold.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MPMTestThreshold.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MPMTestThreshold.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (MPMTestThreshold.fields (position), x))
        emitattr (0, marketType)
        emitelem (1, percent)
        emitelem (2, price)
        emitattrs (3, AggregatedPnode)
        emitattr (4, MPMTestCategory)
        emitattrs (5, RegisteredResource)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MPMTestThreshold rdf:ID=\"%s\">\n%s\t</cim:MPMTestThreshold>".format (id, export_fields)
    }
}

object MPMTestThreshold
extends
    Parseable[MPMTestThreshold]
{
    override val fields: Array[String] = Array[String] (
        "marketType",
        "percent",
        "price",
        "AggregatedPnode",
        "MPMTestCategory",
        "RegisteredResource"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AggregatedPnode", "AggregatedPnode", "0..*", "1..*"),
        Relationship ("MPMTestCategory", "MPMTestCategory", "1", "0..*"),
        Relationship ("RegisteredResource", "RegisteredResource", "0..*", "0..*")
    )
    val marketType: Fielder = parse_attribute (attribute (cls, fields(0)))
    val percent: Fielder = parse_element (element (cls, fields(1)))
    val price: Fielder = parse_element (element (cls, fields(2)))
    val AggregatedPnode: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val MPMTestCategory: Fielder = parse_attribute (attribute (cls, fields(4)))
    val RegisteredResource: FielderMultiple = parse_attributes (attribute (cls, fields(5)))

    def parse (context: Context): MPMTestThreshold =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MPMTestThreshold (
            BasicElement.parse (context),
            mask (marketType (), 0),
            toDouble (mask (percent (), 1)),
            toDouble (mask (price (), 2)),
            masks (AggregatedPnode (), 3),
            mask (MPMTestCategory (), 4),
            masks (RegisteredResource (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Metered Sub-System aggregation of MSS Zones.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param costRecovery Charge for Emission Costs, Start Up Costs, or Minimum Load Costs.
 * @param grossSettlement MSS Load Following may select Net vs.
 *        Gross settlement.  Net Settlement requires the net Demand settled at the MSS LAP and Net Supply needs to settle at the equivalent to the weighted average price of the MSS generation.  Gross load will be settled at the System LAP and the Gross supply will be settled at the LMP.  MSS Aggregation that elects gross settlement shall have to identify if its resources are Load Following or not.
 * @param ignoreLosses Provides an indication if losses are to be ignored for this zone.
 *        Also refered to as Exclude Marginal Losses.
 * @param ignoreMarginalLosses Provides an indication if marginal losses are to be ignored for this zone.
 * @param loadFollowing Indication that this particular MSSA participates in the Load Following function.
 * @param rucProcurement Indicates that RUC will be procured by the ISO or self provided.
 * @param MeteredSubSystem [[ch.ninecode.model.MeteredSubSystem MeteredSubSystem]] <em>undocumented</em>
 * @param RTO [[ch.ninecode.model.RTO RTO]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class MSSAggregation
(
    override val sup: IdentifiedObject,
    costRecovery: String,
    grossSettlement: String,
    ignoreLosses: String,
    ignoreMarginalLosses: String,
    loadFollowing: String,
    rucProcurement: String,
    MeteredSubSystem: List[String],
    RTO: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null, List(), null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MSSAggregation.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MSSAggregation.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (MSSAggregation.fields (position), x))
        emitattr (0, costRecovery)
        emitattr (1, grossSettlement)
        emitattr (2, ignoreLosses)
        emitattr (3, ignoreMarginalLosses)
        emitattr (4, loadFollowing)
        emitattr (5, rucProcurement)
        emitattrs (6, MeteredSubSystem)
        emitattr (7, RTO)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MSSAggregation rdf:ID=\"%s\">\n%s\t</cim:MSSAggregation>".format (id, export_fields)
    }
}

object MSSAggregation
extends
    Parseable[MSSAggregation]
{
    override val fields: Array[String] = Array[String] (
        "costRecovery",
        "grossSettlement",
        "ignoreLosses",
        "ignoreMarginalLosses",
        "loadFollowing",
        "rucProcurement",
        "MeteredSubSystem",
        "RTO"
    )
    override val relations: List[Relationship] = List (
        Relationship ("MeteredSubSystem", "MeteredSubSystem", "1..*", "0..1"),
        Relationship ("RTO", "RTO", "1", "0..*")
    )
    val costRecovery: Fielder = parse_attribute (attribute (cls, fields(0)))
    val grossSettlement: Fielder = parse_attribute (attribute (cls, fields(1)))
    val ignoreLosses: Fielder = parse_attribute (attribute (cls, fields(2)))
    val ignoreMarginalLosses: Fielder = parse_attribute (attribute (cls, fields(3)))
    val loadFollowing: Fielder = parse_attribute (attribute (cls, fields(4)))
    val rucProcurement: Fielder = parse_attribute (attribute (cls, fields(5)))
    val MeteredSubSystem: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val RTO: Fielder = parse_attribute (attribute (cls, fields(7)))

    def parse (context: Context): MSSAggregation =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MSSAggregation (
            IdentifiedObject.parse (context),
            mask (costRecovery (), 0),
            mask (grossSettlement (), 1),
            mask (ignoreLosses (), 2),
            mask (ignoreMarginalLosses (), 3),
            mask (loadFollowing (), 4),
            mask (rucProcurement (), 5),
            masks (MeteredSubSystem (), 6),
            mask (RTO (), 7)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Model to define a zone within a Metered Sub System.
 *
 * @param sup [[ch.ninecode.model.AggregateNode AggregateNode]] Reference to the superclass object.
 * @param ignoreLosses Provides an indication if losses are to be ignored for this metered subsystem zone.
 * @param lossFactor This is the default loss factor for the Metered Sub-System (MSS) zone.
 *        The actual losses are calculated during the RT market.
 * @param rucGrossSettlement Metered Sub-System (MSS) Load Following may select Net vs.
 *        Gross settlement.  Net Settlement requires the net Demand settled at the Metered Sub-Sustem (MSS) Load Aggregation Point (LAP) and Net Supply needs to settle at the equivalent to the weighted average price of the MSS generation.  Gross load will be settled at the System LAP and the Gross supply will be settled at the LMP.  MSS Aggregation that elects gross settlement shall have to identify if its resources are Load Following or not.
 * @param MeteredSubSystem [[ch.ninecode.model.MeteredSubSystem MeteredSubSystem]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
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
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MSSZone.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MSSZone.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MSSZone.fields (position), value)
        emitattr (0, ignoreLosses)
        emitelem (1, lossFactor)
        emitattr (2, rucGrossSettlement)
        emitattr (3, MeteredSubSystem)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MSSZone rdf:ID=\"%s\">\n%s\t</cim:MSSZone>".format (id, export_fields)
    }
}

object MSSZone
extends
    Parseable[MSSZone]
{
    override val fields: Array[String] = Array[String] (
        "ignoreLosses",
        "lossFactor",
        "rucGrossSettlement",
        "MeteredSubSystem"
    )
    override val relations: List[Relationship] = List (
        Relationship ("MeteredSubSystem", "MeteredSubSystem", "0..1", "0..*")
    )
    val ignoreLosses: Fielder = parse_attribute (attribute (cls, fields(0)))
    val lossFactor: Fielder = parse_element (element (cls, fields(1)))
    val rucGrossSettlement: Fielder = parse_attribute (attribute (cls, fields(2)))
    val MeteredSubSystem: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): MSSZone =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MSSZone (
            AggregateNode.parse (context),
            mask (ignoreLosses (), 0),
            toDouble (mask (lossFactor (), 1)),
            mask (rucGrossSettlement (), 2),
            mask (MeteredSubSystem (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * General purpose information for name and other information to contact people.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
 * @param MarketParticipant [[ch.ninecode.model.MarketParticipant MarketParticipant]] <em>undocumented</em>
 * @param MarketSkills [[ch.ninecode.model.MarketSkill MarketSkill]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
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
    userID: String,
    MarketParticipant: List[String],
    MarketSkills: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MarketPerson.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MarketPerson.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MarketPerson.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (MarketPerson.fields (position), x))
        emitelem (0, category)
        emitattr (1, electronicAddressAlternate)
        emitattr (2, electronicAddressPrimary)
        emitelem (3, firstName)
        emitelem (4, governmentID)
        emitattr (5, landlinePhone)
        emitelem (6, lastName)
        emitelem (7, mName)
        emitattr (8, mobilePhone)
        emitelem (9, prefix)
        emitelem (10, specialNeed)
        emitattr (11, status)
        emitelem (12, suffix)
        emitelem (13, userID)
        emitattrs (14, MarketParticipant)
        emitattrs (15, MarketSkills)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MarketPerson rdf:ID=\"%s\">\n%s\t</cim:MarketPerson>".format (id, export_fields)
    }
}

object MarketPerson
extends
    Parseable[MarketPerson]
{
    override val fields: Array[String] = Array[String] (
        "category",
        "electronicAddressAlternate",
        "electronicAddressPrimary",
        "firstName",
        "governmentID",
        "landlinePhone",
        "lastName",
        "mName",
        "mobilePhone",
        "prefix",
        "specialNeed",
        "status",
        "suffix",
        "userID",
        "MarketParticipant",
        "MarketSkills"
    )
    override val relations: List[Relationship] = List (
        Relationship ("MarketParticipant", "MarketParticipant", "0..*", "0..*"),
        Relationship ("MarketSkills", "MarketSkill", "0..*", "0..1")
    )
    val category: Fielder = parse_element (element (cls, fields(0)))
    val electronicAddressAlternate: Fielder = parse_attribute (attribute (cls, fields(1)))
    val electronicAddressPrimary: Fielder = parse_attribute (attribute (cls, fields(2)))
    val firstName: Fielder = parse_element (element (cls, fields(3)))
    val governmentID: Fielder = parse_element (element (cls, fields(4)))
    val landlinePhone: Fielder = parse_attribute (attribute (cls, fields(5)))
    val lastName: Fielder = parse_element (element (cls, fields(6)))
    val mName: Fielder = parse_element (element (cls, fields(7)))
    val mobilePhone: Fielder = parse_attribute (attribute (cls, fields(8)))
    val prefix: Fielder = parse_element (element (cls, fields(9)))
    val specialNeed: Fielder = parse_element (element (cls, fields(10)))
    val status: Fielder = parse_attribute (attribute (cls, fields(11)))
    val suffix: Fielder = parse_element (element (cls, fields(12)))
    val userID: Fielder = parse_element (element (cls, fields(13)))
    val MarketParticipant: FielderMultiple = parse_attributes (attribute (cls, fields(14)))
    val MarketSkills: FielderMultiple = parse_attributes (attribute (cls, fields(15)))

    def parse (context: Context): MarketPerson =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MarketPerson (
            IdentifiedObject.parse (context),
            mask (category (), 0),
            mask (electronicAddressAlternate (), 1),
            mask (electronicAddressPrimary (), 2),
            mask (firstName (), 3),
            mask (governmentID (), 4),
            mask (landlinePhone (), 5),
            mask (lastName (), 6),
            mask (mName (), 7),
            mask (mobilePhone (), 8),
            mask (prefix (), 9),
            mask (specialNeed (), 10),
            mask (status (), 11),
            mask (suffix (), 12),
            mask (userID (), 13),
            masks (MarketParticipant (), 14),
            masks (MarketSkills (), 15)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Certain skills are required and shall be certified in order for a person (typically a member of a crew) to be qualified to work on types of equipment.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param effectiveDate Effective date of the privilege, terminate date of the privilege, or effective date of the application for the organization
 * @param expirationDate This is the terminate date of the application for the organization
 *        The specific organization can no longer access the application as of the terminate date
 * @param qualificationID Qualification identifier.
 * @param status The status of the privilege.
 *        Shows the status of the user�s qualification.
 * @param statusType This is the name of the status of the qualification and is used to display the status of the user's or organization's status.
 * @param MarketSkills [[ch.ninecode.model.MarketSkill MarketSkill]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class MarketQualificationRequirement
(
    override val sup: IdentifiedObject,
    effectiveDate: String,
    expirationDate: String,
    qualificationID: String,
    status: Int,
    statusType: String,
    MarketSkills: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, 0, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MarketQualificationRequirement.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MarketQualificationRequirement.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (MarketQualificationRequirement.fields (position), x))
        emitelem (0, effectiveDate)
        emitelem (1, expirationDate)
        emitelem (2, qualificationID)
        emitelem (3, status)
        emitelem (4, statusType)
        emitattrs (5, MarketSkills)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MarketQualificationRequirement rdf:ID=\"%s\">\n%s\t</cim:MarketQualificationRequirement>".format (id, export_fields)
    }
}

object MarketQualificationRequirement
extends
    Parseable[MarketQualificationRequirement]
{
    override val fields: Array[String] = Array[String] (
        "effectiveDate",
        "expirationDate",
        "qualificationID",
        "status",
        "statusType",
        "MarketSkills"
    )
    override val relations: List[Relationship] = List (
        Relationship ("MarketSkills", "MarketSkill", "0..*", "0..*")
    )
    val effectiveDate: Fielder = parse_element (element (cls, fields(0)))
    val expirationDate: Fielder = parse_element (element (cls, fields(1)))
    val qualificationID: Fielder = parse_element (element (cls, fields(2)))
    val status: Fielder = parse_element (element (cls, fields(3)))
    val statusType: Fielder = parse_element (element (cls, fields(4)))
    val MarketSkills: FielderMultiple = parse_attributes (attribute (cls, fields(5)))

    def parse (context: Context): MarketQualificationRequirement =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MarketQualificationRequirement (
            IdentifiedObject.parse (context),
            mask (effectiveDate (), 0),
            mask (expirationDate (), 1),
            mask (qualificationID (), 2),
            toInteger (mask (status (), 3)),
            mask (statusType (), 4),
            masks (MarketSkills (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A specialized class of AggregatedNode type.
 *
 * Defines the MarketRegions. Regions could be system Market Regions, Energy Regions or Ancillary Service Regions.
 *
 * @param sup [[ch.ninecode.model.AggregateNode AggregateNode]] Reference to the superclass object.
 * @param ExPostMarketRegionResults [[ch.ninecode.model.ExPostMarketRegionResults ExPostMarketRegionResults]] <em>undocumented</em>
 * @param MarketRegionResults [[ch.ninecode.model.MarketRegionResults MarketRegionResults]] <em>undocumented</em>
 * @param ReserveDemandCurve [[ch.ninecode.model.ReserveDemandCurve ReserveDemandCurve]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class MarketRegion
(
    override val sup: AggregateNode,
    ExPostMarketRegionResults: List[String],
    MarketRegionResults: List[String],
    ReserveDemandCurve: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List(), List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MarketRegion.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (MarketRegion.fields (position), x))
        emitattrs (0, ExPostMarketRegionResults)
        emitattrs (1, MarketRegionResults)
        emitattrs (2, ReserveDemandCurve)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MarketRegion rdf:ID=\"%s\">\n%s\t</cim:MarketRegion>".format (id, export_fields)
    }
}

object MarketRegion
extends
    Parseable[MarketRegion]
{
    override val fields: Array[String] = Array[String] (
        "ExPostMarketRegionResults",
        "MarketRegionResults",
        "ReserveDemandCurve"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ExPostMarketRegionResults", "ExPostMarketRegionResults", "0..*", "1"),
        Relationship ("MarketRegionResults", "MarketRegionResults", "1..*", "1"),
        Relationship ("ReserveDemandCurve", "ReserveDemandCurve", "0..*", "1")
    )
    val ExPostMarketRegionResults: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val MarketRegionResults: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val ReserveDemandCurve: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: Context): MarketRegion =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MarketRegion (
            AggregateNode.parse (context),
            masks (ExPostMarketRegionResults (), 0),
            masks (MarketRegionResults (), 1),
            masks (ReserveDemandCurve (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Proficiency level of a craft, which is required to operate or maintain a particular type of asset and/or perform certain types of work.
 *
 * @param sup [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param certificationPeriod Interval between the certification and its expiry.
 * @param effectiveDateTime Date and time the skill became effective.
 * @param level Level of skill for a Craft.
 * @param MarketPerson [[ch.ninecode.model.MarketPerson MarketPerson]] <em>undocumented</em>
 * @param MarketQualificationRequirements [[ch.ninecode.model.MarketQualificationRequirement MarketQualificationRequirement]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
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
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MarketSkill.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MarketSkill.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MarketSkill.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (MarketSkill.fields (position), x))
        emitattr (0, certificationPeriod)
        emitelem (1, effectiveDateTime)
        emitelem (2, level)
        emitattr (3, MarketPerson)
        emitattrs (4, MarketQualificationRequirements)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MarketSkill rdf:ID=\"%s\">\n%s\t</cim:MarketSkill>".format (id, export_fields)
    }
}

object MarketSkill
extends
    Parseable[MarketSkill]
{
    override val fields: Array[String] = Array[String] (
        "certificationPeriod",
        "effectiveDateTime",
        "level",
        "MarketPerson",
        "MarketQualificationRequirements"
    )
    override val relations: List[Relationship] = List (
        Relationship ("MarketPerson", "MarketPerson", "0..1", "0..*"),
        Relationship ("MarketQualificationRequirements", "MarketQualificationRequirement", "0..*", "0..*")
    )
    val certificationPeriod: Fielder = parse_attribute (attribute (cls, fields(0)))
    val effectiveDateTime: Fielder = parse_element (element (cls, fields(1)))
    val level: Fielder = parse_element (element (cls, fields(2)))
    val MarketPerson: Fielder = parse_attribute (attribute (cls, fields(3)))
    val MarketQualificationRequirements: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: Context): MarketSkill =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MarketSkill (
            Document.parse (context),
            mask (certificationPeriod (), 0),
            mask (effectiveDateTime (), 1),
            mask (level (), 2),
            mask (MarketPerson (), 3),
            masks (MarketQualificationRequirements (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The maximum Startup costs and time as a function of down time.
 *
 * Relationship between unit startup cost (Y1-axis) vs. unit elapsed down time (X-axis). This is used to validate the information provided in the Bid.
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class MaxStartUpCostCurve
(
    override val sup: Curve
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:MaxStartUpCostCurve rdf:ID=\"%s\">\n%s\t</cim:MaxStartUpCostCurve>".format (id, export_fields)
    }
}

object MaxStartUpCostCurve
extends
    Parseable[MaxStartUpCostCurve]
{

    def parse (context: Context): MaxStartUpCostCurve =
    {
        implicit val ctx: Context = context
        val ret = MaxStartUpCostCurve (
            Curve.parse (context)
        )
        ret
    }
}

/**
 * A metered subsystem.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param MSSAggregation [[ch.ninecode.model.MSSAggregation MSSAggregation]] <em>undocumented</em>
 * @param MSSZone [[ch.ninecode.model.MSSZone MSSZone]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class MeteredSubSystem
(
    override val sup: IdentifiedObject,
    MSSAggregation: String,
    MSSZone: List[String]
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MeteredSubSystem.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MeteredSubSystem.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (MeteredSubSystem.fields (position), x))
        emitattr (0, MSSAggregation)
        emitattrs (1, MSSZone)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MeteredSubSystem rdf:ID=\"%s\">\n%s\t</cim:MeteredSubSystem>".format (id, export_fields)
    }
}

object MeteredSubSystem
extends
    Parseable[MeteredSubSystem]
{
    override val fields: Array[String] = Array[String] (
        "MSSAggregation",
        "MSSZone"
    )
    override val relations: List[Relationship] = List (
        Relationship ("MSSAggregation", "MSSAggregation", "0..1", "1..*"),
        Relationship ("MSSZone", "MSSZone", "0..*", "0..1")
    )
    val MSSAggregation: Fielder = parse_attribute (attribute (cls, fields(0)))
    val MSSZone: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): MeteredSubSystem =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MeteredSubSystem (
            IdentifiedObject.parse (context),
            mask (MSSAggregation (), 0),
            masks (MSSZone (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Subclass of Production: CombinedCyclePlant from IEC 61970 package.
 *
 * A set of combustion turbines and steam turbines where the exhaust heat from the combustion turbines is recovered to make steam for the steam turbines, resulting in greater overall plant efficiency.
 *
 * @param sup [[ch.ninecode.model.CombinedCyclePlant CombinedCyclePlant]] Reference to the superclass object.
 * @param AggregatedPnode [[ch.ninecode.model.AggregatedPnode AggregatedPnode]] <em>undocumented</em>
 * @param CombinedCycleLogicalConfiguration [[ch.ninecode.model.CombinedCycleLogicalConfiguration CombinedCycleLogicalConfiguration]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class MktCombinedCyclePlant
(
    override val sup: CombinedCyclePlant,
    AggregatedPnode: String,
    CombinedCycleLogicalConfiguration: List[String]
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MktCombinedCyclePlant.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MktCombinedCyclePlant.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (MktCombinedCyclePlant.fields (position), x))
        emitattr (0, AggregatedPnode)
        emitattrs (1, CombinedCycleLogicalConfiguration)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MktCombinedCyclePlant rdf:ID=\"%s\">\n%s\t</cim:MktCombinedCyclePlant>".format (id, export_fields)
    }
}

object MktCombinedCyclePlant
extends
    Parseable[MktCombinedCyclePlant]
{
    override val fields: Array[String] = Array[String] (
        "AggregatedPnode",
        "CombinedCycleLogicalConfiguration"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AggregatedPnode", "AggregatedPnode", "0..1", "0..*"),
        Relationship ("CombinedCycleLogicalConfiguration", "CombinedCycleLogicalConfiguration", "1..*", "0..1")
    )
    val AggregatedPnode: Fielder = parse_attribute (attribute (cls, fields(0)))
    val CombinedCycleLogicalConfiguration: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): MktCombinedCyclePlant =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MktCombinedCyclePlant (
            CombinedCyclePlant.parse (context),
            mask (AggregatedPnode (), 0),
            masks (CombinedCycleLogicalConfiguration (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Subclass of IEC 61970:Core:ConductingEquipment.
 *
 * @param sup [[ch.ninecode.model.ConductingEquipment ConductingEquipment]] Reference to the superclass object.
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class MktConductingEquipment
(
    override val sup: ConductingEquipment
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:MktConductingEquipment rdf:ID=\"%s\">\n%s\t</cim:MktConductingEquipment>".format (id, export_fields)
    }
}

object MktConductingEquipment
extends
    Parseable[MktConductingEquipment]
{

    def parse (context: Context): MktConductingEquipment =
    {
        implicit val ctx: Context = context
        val ret = MktConductingEquipment (
            ConductingEquipment.parse (context)
        )
        ret
    }
}

/**
 * Subclass of IEC 61970:Contingency.
 *
 * @param sup [[ch.ninecode.model.Contingency Contingency]] Reference to the superclass object.
 * @param loadRolloverFlag load change flag
 *        Flag that indicates whether load rollover and load pickup should be processed for this contingency
 * @param ltcControlFlag ltc enable flag
 *        Flag that indicates if LTCs regulate voltage during the solution of the contingency
 * @param participationFactorSet Participation Factor flag
 *        An indication which set of generator participation factors should be used to re-allocate generation in this contingency
 * @param screeningFlag sceening flag for outage
 *        Flag that indicated whether screening is bypassed for the contingency
 * @param ConstraintResults [[ch.ninecode.model.ConstraintResults ConstraintResults]] <em>undocumented</em>
 * @param ContingencyConstraintLimit [[ch.ninecode.model.ContingencyConstraintLimit ContingencyConstraintLimit]] <em>undocumented</em>
 * @param TransferInterfaceSolutionA [[ch.ninecode.model.TransferInterfaceSolution TransferInterfaceSolution]] <em>undocumented</em>
 * @param TransferInterfaceSolutionB [[ch.ninecode.model.TransferInterfaceSolution TransferInterfaceSolution]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class MktContingency
(
    override val sup: Contingency,
    loadRolloverFlag: Boolean,
    ltcControlFlag: Boolean,
    participationFactorSet: String,
    screeningFlag: Boolean,
    ConstraintResults: List[String],
    ContingencyConstraintLimit: List[String],
    TransferInterfaceSolutionA: String,
    TransferInterfaceSolutionB: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, false, null, false, List(), List(), null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MktContingency.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MktContingency.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MktContingency.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (MktContingency.fields (position), x))
        emitelem (0, loadRolloverFlag)
        emitelem (1, ltcControlFlag)
        emitelem (2, participationFactorSet)
        emitelem (3, screeningFlag)
        emitattrs (4, ConstraintResults)
        emitattrs (5, ContingencyConstraintLimit)
        emitattr (6, TransferInterfaceSolutionA)
        emitattr (7, TransferInterfaceSolutionB)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MktContingency rdf:ID=\"%s\">\n%s\t</cim:MktContingency>".format (id, export_fields)
    }
}

object MktContingency
extends
    Parseable[MktContingency]
{
    override val fields: Array[String] = Array[String] (
        "loadRolloverFlag",
        "ltcControlFlag",
        "participationFactorSet",
        "screeningFlag",
        "ConstraintResults",
        "ContingencyConstraintLimit",
        "TransferInterfaceSolutionA",
        "TransferInterfaceSolutionB"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ConstraintResults", "ConstraintResults", "0..*", "1"),
        Relationship ("ContingencyConstraintLimit", "ContingencyConstraintLimit", "0..*", "1"),
        Relationship ("TransferInterfaceSolutionA", "TransferInterfaceSolution", "0..1", "0..1"),
        Relationship ("TransferInterfaceSolutionB", "TransferInterfaceSolution", "0..1", "0..1")
    )
    val loadRolloverFlag: Fielder = parse_element (element (cls, fields(0)))
    val ltcControlFlag: Fielder = parse_element (element (cls, fields(1)))
    val participationFactorSet: Fielder = parse_element (element (cls, fields(2)))
    val screeningFlag: Fielder = parse_element (element (cls, fields(3)))
    val ConstraintResults: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val ContingencyConstraintLimit: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val TransferInterfaceSolutionA: Fielder = parse_attribute (attribute (cls, fields(6)))
    val TransferInterfaceSolutionB: Fielder = parse_attribute (attribute (cls, fields(7)))

    def parse (context: Context): MktContingency =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MktContingency (
            Contingency.parse (context),
            toBoolean (mask (loadRolloverFlag (), 0)),
            toBoolean (mask (ltcControlFlag (), 1)),
            mask (participationFactorSet (), 2),
            toBoolean (mask (screeningFlag (), 3)),
            masks (ConstraintResults (), 4),
            masks (ContingencyConstraintLimit (), 5),
            mask (TransferInterfaceSolutionA (), 6),
            mask (TransferInterfaceSolutionB (), 7)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Subclass of IEC 61970: Generation: Production:HeatRateCurve.
 *
 * @param sup [[ch.ninecode.model.HeatRateCurve HeatRateCurve]] Reference to the superclass object.
 * @param RegisteredGenerator [[ch.ninecode.model.RegisteredGenerator RegisteredGenerator]] <em>undocumented</em>
 * @param ResourceVerifiableCosts [[ch.ninecode.model.ResourceVerifiableCosts ResourceVerifiableCosts]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
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
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MktHeatRateCurve.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MktHeatRateCurve.fields (position), value)
        emitattr (0, RegisteredGenerator)
        emitattr (1, ResourceVerifiableCosts)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MktHeatRateCurve rdf:ID=\"%s\">\n%s\t</cim:MktHeatRateCurve>".format (id, export_fields)
    }
}

object MktHeatRateCurve
extends
    Parseable[MktHeatRateCurve]
{
    override val fields: Array[String] = Array[String] (
        "RegisteredGenerator",
        "ResourceVerifiableCosts"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RegisteredGenerator", "RegisteredGenerator", "0..1", "0..1"),
        Relationship ("ResourceVerifiableCosts", "ResourceVerifiableCosts", "0..1", "1")
    )
    val RegisteredGenerator: Fielder = parse_attribute (attribute (cls, fields(0)))
    val ResourceVerifiableCosts: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): MktHeatRateCurve =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MktHeatRateCurve (
            HeatRateCurve.parse (context),
            mask (RegisteredGenerator (), 0),
            mask (ResourceVerifiableCosts (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Subclass of ThermalGeneratingUnit from Production Package in IEC 61970.
 *
 * @param sup [[ch.ninecode.model.ThermalGeneratingUnit ThermalGeneratingUnit]] Reference to the superclass object.
 * @param CombinedCycleConfigurationMember [[ch.ninecode.model.CombinedCycleConfigurationMember CombinedCycleConfigurationMember]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class MktThermalGeneratingUnit
(
    override val sup: ThermalGeneratingUnit,
    CombinedCycleConfigurationMember: List[String]
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MktThermalGeneratingUnit.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (MktThermalGeneratingUnit.fields (position), x))
        emitattrs (0, CombinedCycleConfigurationMember)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MktThermalGeneratingUnit rdf:ID=\"%s\">\n%s\t</cim:MktThermalGeneratingUnit>".format (id, export_fields)
    }
}

object MktThermalGeneratingUnit
extends
    Parseable[MktThermalGeneratingUnit]
{
    override val fields: Array[String] = Array[String] (
        "CombinedCycleConfigurationMember"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CombinedCycleConfigurationMember", "CombinedCycleConfigurationMember", "0..*", "1")
    )
    val CombinedCycleConfigurationMember: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): MktThermalGeneratingUnit =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MktThermalGeneratingUnit (
            ThermalGeneratingUnit.parse (context),
            masks (CombinedCycleConfigurationMember (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Price of oil in monetary units.
 *
 * @param sup Reference to the superclass object.
 * @param oilPriceIndex The average oil price at a defined fuel region.
 * @param FuelRegion [[ch.ninecode.model.FuelRegion FuelRegion]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
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
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = OilPrice.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (OilPrice.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OilPrice.fields (position), value)
        emitelem (0, oilPriceIndex)
        emitattr (1, FuelRegion)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OilPrice rdf:ID=\"%s\">\n%s\t</cim:OilPrice>".format (id, export_fields)
    }
}

object OilPrice
extends
    Parseable[OilPrice]
{
    override val fields: Array[String] = Array[String] (
        "oilPriceIndex",
        "FuelRegion"
    )
    override val relations: List[Relationship] = List (
        Relationship ("FuelRegion", "FuelRegion", "1", "1")
    )
    val oilPriceIndex: Fielder = parse_element (element (cls, fields(0)))
    val FuelRegion: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): OilPrice =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = OilPrice (
            BasicElement.parse (context),
            toDouble (mask (oilPriceIndex (), 0)),
            mask (FuelRegion (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * This class models the allocation between asset owners and pricing nodes.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param maxMWAllocation Maximum MW for the Source/Sink for the Allocation
 * @param Pnode [[ch.ninecode.model.Pnode Pnode]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class OrgPnodeAllocation
(
    override val sup: IdentifiedObject,
    maxMWAllocation: Double,
    Pnode: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = OrgPnodeAllocation.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (OrgPnodeAllocation.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OrgPnodeAllocation.fields (position), value)
        emitelem (0, maxMWAllocation)
        emitattr (1, Pnode)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OrgPnodeAllocation rdf:ID=\"%s\">\n%s\t</cim:OrgPnodeAllocation>".format (id, export_fields)
    }
}

object OrgPnodeAllocation
extends
    Parseable[OrgPnodeAllocation]
{
    override val fields: Array[String] = Array[String] (
        "maxMWAllocation",
        "Pnode"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Pnode", "Pnode", "1", "0..*")
    )
    val maxMWAllocation: Fielder = parse_element (element (cls, fields(0)))
    val Pnode: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): OrgPnodeAllocation =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = OrgPnodeAllocation (
            IdentifiedObject.parse (context),
            toDouble (mask (maxMWAllocation (), 0)),
            mask (Pnode (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * This class model the ownership percent and type of ownership between resource and organisation.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param asscType association type for the association between Organisation and Resource:
 * @param masterSchedulingCoordinatorFlag Flag to indicate that the SC representing the Resource is the Master SC.
 * @param ownershipPercent ownership percentage for each resource
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class OrgResOwnership
(
    override val sup: IdentifiedObject,
    asscType: String,
    masterSchedulingCoordinatorFlag: String,
    ownershipPercent: Double,
    RegisteredResource: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = OrgResOwnership.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (OrgResOwnership.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OrgResOwnership.fields (position), value)
        emitattr (0, asscType)
        emitattr (1, masterSchedulingCoordinatorFlag)
        emitelem (2, ownershipPercent)
        emitattr (3, RegisteredResource)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OrgResOwnership rdf:ID=\"%s\">\n%s\t</cim:OrgResOwnership>".format (id, export_fields)
    }
}

object OrgResOwnership
extends
    Parseable[OrgResOwnership]
{
    override val fields: Array[String] = Array[String] (
        "asscType",
        "masterSchedulingCoordinatorFlag",
        "ownershipPercent",
        "RegisteredResource"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RegisteredResource", "RegisteredResource", "1", "0..*")
    )
    val asscType: Fielder = parse_attribute (attribute (cls, fields(0)))
    val masterSchedulingCoordinatorFlag: Fielder = parse_attribute (attribute (cls, fields(1)))
    val ownershipPercent: Fielder = parse_element (element (cls, fields(2)))
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): OrgResOwnership =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = OrgResOwnership (
            IdentifiedObject.parse (context),
            mask (asscType (), 0),
            mask (masterSchedulingCoordinatorFlag (), 1),
            toDouble (mask (ownershipPercent (), 2)),
            mask (RegisteredResource (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A pricing node is directly associated with a connectivity node.
 *
 * It is a pricing location for which market participants submit their bids, offers, buy/sell CRRs, and settle.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param isPublic If true, this Pnode is public (prices are published for DA/RT and FTR markets), otherwise it is private (location is not usable by market for bidding/FTRs/transactions).
 * @param AggregateNode [[ch.ninecode.model.AggregateNode AggregateNode]] <em>undocumented</em>
 * @param CommodityDefinition [[ch.ninecode.model.CommodityDefinition CommodityDefinition]] <em>undocumented</em>
 * @param DeliveryTransactionBids [[ch.ninecode.model.TransactionBid TransactionBid]] <em>undocumented</em>
 * @param ExPostResults [[ch.ninecode.model.ExPostPricingResults ExPostPricingResults]] <em>undocumented</em>
 * @param FTRs [[ch.ninecode.model.FTR FTR]] <em>undocumented</em>
 * @param MktMeasurement [[ch.ninecode.model.MktMeasurement MktMeasurement]] Allows Measurements to be associated to Pnodes.
 * @param OrgPnodeAllocation [[ch.ninecode.model.OrgPnodeAllocation OrgPnodeAllocation]] <em>undocumented</em>
 * @param PnodeResults [[ch.ninecode.model.PnodeResults PnodeResults]] <em>undocumented</em>
 * @param RTO [[ch.ninecode.model.RTO RTO]] <em>undocumented</em>
 * @param ReceiptTransactionBids [[ch.ninecode.model.TransactionBid TransactionBid]] <em>undocumented</em>
 * @param RegisteredResources [[ch.ninecode.model.RegisteredResource RegisteredResource]] A registered resource injects power at one or more connectivity nodes related to a pnode
 * @param SinkCRRSegment [[ch.ninecode.model.CRRSegment CRRSegment]] <em>undocumented</em>
 * @param SourceCRRSegment [[ch.ninecode.model.CRRSegment CRRSegment]] <em>undocumented</em>
 * @param SubControlArea [[ch.ninecode.model.SubControlArea SubControlArea]] <em>undocumented</em>
 * @param Trade [[ch.ninecode.model.Trade Trade]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class Pnode
(
    override val sup: IdentifiedObject,
    isPublic: Boolean,
    AggregateNode: List[String],
    CommodityDefinition: List[String],
    DeliveryTransactionBids: List[String],
    ExPostResults: List[String],
    FTRs: List[String],
    MktMeasurement: List[String],
    OrgPnodeAllocation: List[String],
    PnodeResults: List[String],
    RTO: String,
    ReceiptTransactionBids: List[String],
    RegisteredResources: List[String],
    SinkCRRSegment: List[String],
    SourceCRRSegment: List[String],
    SubControlArea: String,
    Trade: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, List(), List(), List(), List(), List(), List(), List(), List(), null, List(), List(), List(), List(), null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Pnode.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Pnode.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Pnode.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (Pnode.fields (position), x))
        emitelem (0, isPublic)
        emitattrs (1, AggregateNode)
        emitattrs (2, CommodityDefinition)
        emitattrs (3, DeliveryTransactionBids)
        emitattrs (4, ExPostResults)
        emitattrs (5, FTRs)
        emitattrs (6, MktMeasurement)
        emitattrs (7, OrgPnodeAllocation)
        emitattrs (8, PnodeResults)
        emitattr (9, RTO)
        emitattrs (10, ReceiptTransactionBids)
        emitattrs (11, RegisteredResources)
        emitattrs (12, SinkCRRSegment)
        emitattrs (13, SourceCRRSegment)
        emitattr (14, SubControlArea)
        emitattrs (15, Trade)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Pnode rdf:ID=\"%s\">\n%s\t</cim:Pnode>".format (id, export_fields)
    }
}

object Pnode
extends
    Parseable[Pnode]
{
    override val fields: Array[String] = Array[String] (
        "isPublic",
        "AggregateNode",
        "CommodityDefinition",
        "DeliveryTransactionBids",
        "ExPostResults",
        "FTRs",
        "MktMeasurement",
        "OrgPnodeAllocation",
        "PnodeResults",
        "RTO",
        "ReceiptTransactionBids",
        "RegisteredResources",
        "SinkCRRSegment",
        "SourceCRRSegment",
        "SubControlArea",
        "Trade"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AggregateNode", "AggregateNode", "0..*", "0..*"),
        Relationship ("CommodityDefinition", "CommodityDefinition", "0..*", "1"),
        Relationship ("DeliveryTransactionBids", "TransactionBid", "0..*", "0..1"),
        Relationship ("ExPostResults", "ExPostPricingResults", "0..*", "1"),
        Relationship ("FTRs", "FTR", "0..*", "0..*"),
        Relationship ("MktMeasurement", "MktMeasurement", "0..*", "0..1"),
        Relationship ("OrgPnodeAllocation", "OrgPnodeAllocation", "0..*", "1"),
        Relationship ("PnodeResults", "PnodeResults", "1..*", "0..1"),
        Relationship ("RTO", "RTO", "0..1", "0..*"),
        Relationship ("ReceiptTransactionBids", "TransactionBid", "0..*", "0..1"),
        Relationship ("RegisteredResources", "RegisteredResource", "0..*", "0..1"),
        Relationship ("SinkCRRSegment", "CRRSegment", "0..*", "0..*"),
        Relationship ("SourceCRRSegment", "CRRSegment", "0..*", "0..*"),
        Relationship ("SubControlArea", "SubControlArea", "0..1", "0..*"),
        Relationship ("Trade", "Trade", "0..*", "0..1")
    )
    val isPublic: Fielder = parse_element (element (cls, fields(0)))
    val AggregateNode: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val CommodityDefinition: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val DeliveryTransactionBids: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val ExPostResults: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val FTRs: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val MktMeasurement: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val OrgPnodeAllocation: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val PnodeResults: FielderMultiple = parse_attributes (attribute (cls, fields(8)))
    val RTO: Fielder = parse_attribute (attribute (cls, fields(9)))
    val ReceiptTransactionBids: FielderMultiple = parse_attributes (attribute (cls, fields(10)))
    val RegisteredResources: FielderMultiple = parse_attributes (attribute (cls, fields(11)))
    val SinkCRRSegment: FielderMultiple = parse_attributes (attribute (cls, fields(12)))
    val SourceCRRSegment: FielderMultiple = parse_attributes (attribute (cls, fields(13)))
    val SubControlArea: Fielder = parse_attribute (attribute (cls, fields(14)))
    val Trade: FielderMultiple = parse_attributes (attribute (cls, fields(15)))

    def parse (context: Context): Pnode =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Pnode (
            IdentifiedObject.parse (context),
            toBoolean (mask (isPublic (), 0)),
            masks (AggregateNode (), 1),
            masks (CommodityDefinition (), 2),
            masks (DeliveryTransactionBids (), 3),
            masks (ExPostResults (), 4),
            masks (FTRs (), 5),
            masks (MktMeasurement (), 6),
            masks (OrgPnodeAllocation (), 7),
            masks (PnodeResults (), 8),
            mask (RTO (), 9),
            masks (ReceiptTransactionBids (), 10),
            masks (RegisteredResources (), 11),
            masks (SinkCRRSegment (), 12),
            masks (SourceCRRSegment (), 13),
            mask (SubControlArea (), 14),
            masks (Trade (), 15)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * This class allows SC to input different distribution factors for pricing node.
 *
 * @param sup Reference to the superclass object.
 * @param factor Used to calculate "participation" of Pnode in an AggregatePnode.
 *        For example, for regulation region this factor is 1 and total sum of all factors for a specific regulation region does not have to be 1. For pricing zone the total sum of all factors has to be 1.
 * @param offPeak Indication that this distribution factor is to apply during off peak.
 * @param onPeak Indication that this factor is to apply during Peak periods.
 * @param podLossFactor Point of delivery loss factor
 * @param AggregatedPnode [[ch.ninecode.model.AggregatedPnode AggregatedPnode]] <em>undocumented</em>
 * @param BidDistributionFactor [[ch.ninecode.model.BidDistributionFactor BidDistributionFactor]] <em>undocumented</em>
 * @param IndividualPnode [[ch.ninecode.model.IndividualPnode IndividualPnode]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class PnodeDistributionFactor
(
    override val sup: BasicElement,
    factor: Double,
    offPeak: String,
    onPeak: String,
    podLossFactor: Double,
    AggregatedPnode: String,
    BidDistributionFactor: String,
    IndividualPnode: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, null, 0.0, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PnodeDistributionFactor.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PnodeDistributionFactor.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PnodeDistributionFactor.fields (position), value)
        emitelem (0, factor)
        emitattr (1, offPeak)
        emitattr (2, onPeak)
        emitelem (3, podLossFactor)
        emitattr (4, AggregatedPnode)
        emitattr (5, BidDistributionFactor)
        emitattr (6, IndividualPnode)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PnodeDistributionFactor rdf:ID=\"%s\">\n%s\t</cim:PnodeDistributionFactor>".format (id, export_fields)
    }
}

object PnodeDistributionFactor
extends
    Parseable[PnodeDistributionFactor]
{
    override val fields: Array[String] = Array[String] (
        "factor",
        "offPeak",
        "onPeak",
        "podLossFactor",
        "AggregatedPnode",
        "BidDistributionFactor",
        "IndividualPnode"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AggregatedPnode", "AggregatedPnode", "1", "1..*"),
        Relationship ("BidDistributionFactor", "BidDistributionFactor", "0..1", "0..*"),
        Relationship ("IndividualPnode", "IndividualPnode", "1", "0..*")
    )
    val factor: Fielder = parse_element (element (cls, fields(0)))
    val offPeak: Fielder = parse_attribute (attribute (cls, fields(1)))
    val onPeak: Fielder = parse_attribute (attribute (cls, fields(2)))
    val podLossFactor: Fielder = parse_element (element (cls, fields(3)))
    val AggregatedPnode: Fielder = parse_attribute (attribute (cls, fields(4)))
    val BidDistributionFactor: Fielder = parse_attribute (attribute (cls, fields(5)))
    val IndividualPnode: Fielder = parse_attribute (attribute (cls, fields(6)))

    def parse (context: Context): PnodeDistributionFactor =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = PnodeDistributionFactor (
            BasicElement.parse (context),
            toDouble (mask (factor (), 0)),
            mask (offPeak (), 1),
            mask (onPeak (), 2),
            toDouble (mask (podLossFactor (), 3)),
            mask (AggregatedPnode (), 4),
            mask (BidDistributionFactor (), 5),
            mask (IndividualPnode (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Model to support processing of reliability must run units.
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param RegisteredGenerator [[ch.ninecode.model.RegisteredGenerator RegisteredGenerator]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class RMRHeatRateCurve
(
    override val sup: Curve,
    RegisteredGenerator: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = RMRHeatRateCurve.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RMRHeatRateCurve.fields (position), value)
        emitattr (0, RegisteredGenerator)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RMRHeatRateCurve rdf:ID=\"%s\">\n%s\t</cim:RMRHeatRateCurve>".format (id, export_fields)
    }
}

object RMRHeatRateCurve
extends
    Parseable[RMRHeatRateCurve]
{
    override val fields: Array[String] = Array[String] (
        "RegisteredGenerator"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RegisteredGenerator", "RegisteredGenerator", "0..1", "0..1")
    )
    val RegisteredGenerator: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): RMRHeatRateCurve =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = RMRHeatRateCurve (
            Curve.parse (context),
            mask (RegisteredGenerator (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Model to support processing of reliability must run units.
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param RegisteredGenerator [[ch.ninecode.model.RegisteredGenerator RegisteredGenerator]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class RMRStartUpCostCurve
(
    override val sup: Curve,
    RegisteredGenerator: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = RMRStartUpCostCurve.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RMRStartUpCostCurve.fields (position), value)
        emitattr (0, RegisteredGenerator)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RMRStartUpCostCurve rdf:ID=\"%s\">\n%s\t</cim:RMRStartUpCostCurve>".format (id, export_fields)
    }
}

object RMRStartUpCostCurve
extends
    Parseable[RMRStartUpCostCurve]
{
    override val fields: Array[String] = Array[String] (
        "RegisteredGenerator"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RegisteredGenerator", "RegisteredGenerator", "0..1", "0..1")
    )
    val RegisteredGenerator: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): RMRStartUpCostCurve =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = RMRStartUpCostCurve (
            Curve.parse (context),
            mask (RegisteredGenerator (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Model to support processing of reliability must run units.
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param RegisteredGenerator [[ch.ninecode.model.RegisteredGenerator RegisteredGenerator]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class RMRStartUpEnergyCurve
(
    override val sup: Curve,
    RegisteredGenerator: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = RMRStartUpEnergyCurve.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RMRStartUpEnergyCurve.fields (position), value)
        emitattr (0, RegisteredGenerator)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RMRStartUpEnergyCurve rdf:ID=\"%s\">\n%s\t</cim:RMRStartUpEnergyCurve>".format (id, export_fields)
    }
}

object RMRStartUpEnergyCurve
extends
    Parseable[RMRStartUpEnergyCurve]
{
    override val fields: Array[String] = Array[String] (
        "RegisteredGenerator"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RegisteredGenerator", "RegisteredGenerator", "0..1", "0..1")
    )
    val RegisteredGenerator: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): RMRStartUpEnergyCurve =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = RMRStartUpEnergyCurve (
            Curve.parse (context),
            mask (RegisteredGenerator (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Model to support processing of reliability must run units.
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param RegisteredGenerator [[ch.ninecode.model.RegisteredGenerator RegisteredGenerator]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class RMRStartUpFuelCurve
(
    override val sup: Curve,
    RegisteredGenerator: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = RMRStartUpFuelCurve.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RMRStartUpFuelCurve.fields (position), value)
        emitattr (0, RegisteredGenerator)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RMRStartUpFuelCurve rdf:ID=\"%s\">\n%s\t</cim:RMRStartUpFuelCurve>".format (id, export_fields)
    }
}

object RMRStartUpFuelCurve
extends
    Parseable[RMRStartUpFuelCurve]
{
    override val fields: Array[String] = Array[String] (
        "RegisteredGenerator"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RegisteredGenerator", "RegisteredGenerator", "0..1", "0..1")
    )
    val RegisteredGenerator: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): RMRStartUpFuelCurve =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = RMRStartUpFuelCurve (
            Curve.parse (context),
            mask (RegisteredGenerator (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Model to support processing of reliability must run units.
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param RegisteredGenerator [[ch.ninecode.model.RegisteredGenerator RegisteredGenerator]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class RMRStartUpTimeCurve
(
    override val sup: Curve,
    RegisteredGenerator: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = RMRStartUpTimeCurve.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RMRStartUpTimeCurve.fields (position), value)
        emitattr (0, RegisteredGenerator)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RMRStartUpTimeCurve rdf:ID=\"%s\">\n%s\t</cim:RMRStartUpTimeCurve>".format (id, export_fields)
    }
}

object RMRStartUpTimeCurve
extends
    Parseable[RMRStartUpTimeCurve]
{
    override val fields: Array[String] = Array[String] (
        "RegisteredGenerator"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RegisteredGenerator", "RegisteredGenerator", "0..1", "0..1")
    )
    val RegisteredGenerator: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): RMRStartUpTimeCurve =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = RMRStartUpTimeCurve (
            Curve.parse (context),
            mask (RegisteredGenerator (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Regional transmission operator.
 *
 * @param sup [[ch.ninecode.model.MarketParticipant MarketParticipant]] Reference to the superclass object.
 * @param AdjacentCASet [[ch.ninecode.model.AdjacentCASet AdjacentCASet]] <em>undocumented</em>
 * @param AggregateNode [[ch.ninecode.model.AggregateNode AggregateNode]] <em>undocumented</em>
 * @param CommodityDefinition [[ch.ninecode.model.CommodityDefinition CommodityDefinition]] <em>undocumented</em>
 * @param EnergyMarkets [[ch.ninecode.model.EnergyMarket EnergyMarket]] <em>undocumented</em>
 * @param FuelRegion [[ch.ninecode.model.FuelRegion FuelRegion]] <em>undocumented</em>
 * @param HostControlArea [[ch.ninecode.model.HostControlArea HostControlArea]] <em>undocumented</em>
 * @param LocalReliabilityArea [[ch.ninecode.model.LocalReliabilityArea LocalReliabilityArea]] <em>undocumented</em>
 * @param MSSAggregation [[ch.ninecode.model.MSSAggregation MSSAggregation]] <em>undocumented</em>
 * @param MktConnectivityNode [[ch.ninecode.model.MktConnectivityNode MktConnectivityNode]] <em>undocumented</em>
 * @param Pnodes [[ch.ninecode.model.Pnode Pnode]] <em>undocumented</em>
 * @param ResourceGroupReqs [[ch.ninecode.model.ResourceGroupReq ResourceGroupReq]] <em>undocumented</em>
 * @param SecurityConstraints [[ch.ninecode.model.SecurityConstraints SecurityConstraints]] <em>undocumented</em>
 * @param SecurityConstraintsLinear [[ch.ninecode.model.SecurityConstraintSum SecurityConstraintSum]] <em>undocumented</em>
 * @param SubControlArea [[ch.ninecode.model.SubControlArea SubControlArea]] <em>undocumented</em>
 * @param TransmissionContractRight [[ch.ninecode.model.ContractRight ContractRight]] <em>undocumented</em>
 * @param TransmissionRightChain [[ch.ninecode.model.TransmissionRightChain TransmissionRightChain]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class RTO
(
    override val sup: MarketParticipant,
    AdjacentCASet: List[String],
    AggregateNode: List[String],
    CommodityDefinition: List[String],
    EnergyMarkets: List[String],
    FuelRegion: List[String],
    HostControlArea: List[String],
    LocalReliabilityArea: List[String],
    MSSAggregation: List[String],
    MktConnectivityNode: List[String],
    Pnodes: List[String],
    ResourceGroupReqs: List[String],
    SecurityConstraints: List[String],
    SecurityConstraintsLinear: List[String],
    SubControlArea: List[String],
    TransmissionContractRight: List[String],
    TransmissionRightChain: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List(), List(), List(), List(), List(), List(), List(), List(), List(), List(), List(), List(), List(), List(), List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def MarketParticipant: MarketParticipant = sup.asInstanceOf[MarketParticipant]
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = RTO.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (RTO.fields (position), x))
        emitattrs (0, AdjacentCASet)
        emitattrs (1, AggregateNode)
        emitattrs (2, CommodityDefinition)
        emitattrs (3, EnergyMarkets)
        emitattrs (4, FuelRegion)
        emitattrs (5, HostControlArea)
        emitattrs (6, LocalReliabilityArea)
        emitattrs (7, MSSAggregation)
        emitattrs (8, MktConnectivityNode)
        emitattrs (9, Pnodes)
        emitattrs (10, ResourceGroupReqs)
        emitattrs (11, SecurityConstraints)
        emitattrs (12, SecurityConstraintsLinear)
        emitattrs (13, SubControlArea)
        emitattrs (14, TransmissionContractRight)
        emitattrs (15, TransmissionRightChain)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RTO rdf:ID=\"%s\">\n%s\t</cim:RTO>".format (id, export_fields)
    }
}

object RTO
extends
    Parseable[RTO]
{
    override val fields: Array[String] = Array[String] (
        "AdjacentCASet",
        "AggregateNode",
        "CommodityDefinition",
        "EnergyMarkets",
        "FuelRegion",
        "HostControlArea",
        "LocalReliabilityArea",
        "MSSAggregation",
        "MktConnectivityNode",
        "Pnodes",
        "ResourceGroupReqs",
        "SecurityConstraints",
        "SecurityConstraintsLinear",
        "SubControlArea",
        "TransmissionContractRight",
        "TransmissionRightChain"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AdjacentCASet", "AdjacentCASet", "0..*", "1"),
        Relationship ("AggregateNode", "AggregateNode", "0..*", "1"),
        Relationship ("CommodityDefinition", "CommodityDefinition", "0..*", "1"),
        Relationship ("EnergyMarkets", "EnergyMarket", "0..*", "0..1"),
        Relationship ("FuelRegion", "FuelRegion", "0..*", "1"),
        Relationship ("HostControlArea", "HostControlArea", "0..*", "1"),
        Relationship ("LocalReliabilityArea", "LocalReliabilityArea", "0..*", "1"),
        Relationship ("MSSAggregation", "MSSAggregation", "0..*", "1"),
        Relationship ("MktConnectivityNode", "MktConnectivityNode", "0..*", "1"),
        Relationship ("Pnodes", "Pnode", "0..*", "0..1"),
        Relationship ("ResourceGroupReqs", "ResourceGroupReq", "0..*", "0..*"),
        Relationship ("SecurityConstraints", "SecurityConstraints", "0..*", "0..1"),
        Relationship ("SecurityConstraintsLinear", "SecurityConstraintSum", "0..*", "0..1"),
        Relationship ("SubControlArea", "SubControlArea", "0..*", "1"),
        Relationship ("TransmissionContractRight", "ContractRight", "0..*", "1"),
        Relationship ("TransmissionRightChain", "TransmissionRightChain", "0..*", "1")
    )
    val AdjacentCASet: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val AggregateNode: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val CommodityDefinition: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val EnergyMarkets: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val FuelRegion: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val HostControlArea: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val LocalReliabilityArea: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val MSSAggregation: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val MktConnectivityNode: FielderMultiple = parse_attributes (attribute (cls, fields(8)))
    val Pnodes: FielderMultiple = parse_attributes (attribute (cls, fields(9)))
    val ResourceGroupReqs: FielderMultiple = parse_attributes (attribute (cls, fields(10)))
    val SecurityConstraints: FielderMultiple = parse_attributes (attribute (cls, fields(11)))
    val SecurityConstraintsLinear: FielderMultiple = parse_attributes (attribute (cls, fields(12)))
    val SubControlArea: FielderMultiple = parse_attributes (attribute (cls, fields(13)))
    val TransmissionContractRight: FielderMultiple = parse_attributes (attribute (cls, fields(14)))
    val TransmissionRightChain: FielderMultiple = parse_attributes (attribute (cls, fields(15)))

    def parse (context: Context): RTO =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = RTO (
            MarketParticipant.parse (context),
            masks (AdjacentCASet (), 0),
            masks (AggregateNode (), 1),
            masks (CommodityDefinition (), 2),
            masks (EnergyMarkets (), 3),
            masks (FuelRegion (), 4),
            masks (HostControlArea (), 5),
            masks (LocalReliabilityArea (), 6),
            masks (MSSAggregation (), 7),
            masks (MktConnectivityNode (), 8),
            masks (Pnodes (), 9),
            masks (ResourceGroupReqs (), 10),
            masks (SecurityConstraints (), 11),
            masks (SecurityConstraintsLinear (), 12),
            masks (SubControlArea (), 13),
            masks (TransmissionContractRight (), 14),
            masks (TransmissionRightChain (), 15)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A specialized class of type AggregatedNode type.
 *
 * Defines RUC Zones. A forecast region represents a collection of Nodes for which the Market operator has developed sufficient historical demand and relevant weather data to perform a demand forecast for such area. The Market Operator may further adjust this forecast to ensure that the Reliability Unit Commitment produces adequate local capacity procurement.
 *
 * @param sup [[ch.ninecode.model.AggregateNode AggregateNode]] Reference to the superclass object.
 * @param LossClearingResults [[ch.ninecode.model.LossClearingResults LossClearingResults]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class RUCZone
(
    override val sup: AggregateNode,
    LossClearingResults: List[String]
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = RUCZone.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (RUCZone.fields (position), x))
        emitattrs (0, LossClearingResults)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RUCZone rdf:ID=\"%s\">\n%s\t</cim:RUCZone>".format (id, export_fields)
    }
}

object RUCZone
extends
    Parseable[RUCZone]
{
    override val fields: Array[String] = Array[String] (
        "LossClearingResults"
    )
    override val relations: List[Relationship] = List (
        Relationship ("LossClearingResults", "LossClearingResults", "0..*", "0..1")
    )
    val LossClearingResults: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): RUCZone =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = RUCZone (
            AggregateNode.parse (context),
            masks (LossClearingResults (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A registered resource that represents a distributed energy resource, such as a micro-generator, fuel cell, photo-voltaic energy source, etc.
 *
 * @param sup [[ch.ninecode.model.RegisteredResource RegisteredResource]] Reference to the superclass object.
 * @param distributedResourceType The type of resource.
 *        Examples include: fuel cell, flywheel, photovoltaic, micro-turbine, CHP (combined heat power), V2G (vehicle to grid), DES (distributed energy storage), and others.
 * @param ResourcePerformanceRatings [[ch.ninecode.model.ResourcePerformanceRating ResourcePerformanceRating]] <em>undocumented</em>
 * @param ResponseMethods [[ch.ninecode.model.ResponseMethod ResponseMethod]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class RegisteredDistributedResource
(
    override val sup: RegisteredResource,
    distributedResourceType: String,
    ResourcePerformanceRatings: List[String],
    ResponseMethods: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def RegisteredResource: RegisteredResource = sup.asInstanceOf[RegisteredResource]
    override def copy (): Row = { clone ().asInstanceOf[RegisteredDistributedResource] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = RegisteredDistributedResource.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (RegisteredDistributedResource.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (RegisteredDistributedResource.fields (position), x))
        emitelem (0, distributedResourceType)
        emitattrs (1, ResourcePerformanceRatings)
        emitattrs (2, ResponseMethods)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RegisteredDistributedResource rdf:ID=\"%s\">\n%s\t</cim:RegisteredDistributedResource>".format (id, export_fields)
    }
}

object RegisteredDistributedResource
extends
    Parseable[RegisteredDistributedResource]
{
    override val fields: Array[String] = Array[String] (
        "distributedResourceType",
        "ResourcePerformanceRatings",
        "ResponseMethods"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ResourcePerformanceRatings", "ResourcePerformanceRating", "0..*", "1"),
        Relationship ("ResponseMethods", "ResponseMethod", "0..*", "1")
    )
    val distributedResourceType: Fielder = parse_element (element (cls, fields(0)))
    val ResourcePerformanceRatings: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val ResponseMethods: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: Context): RegisteredDistributedResource =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = RegisteredDistributedResource (
            RegisteredResource.parse (context),
            mask (distributedResourceType (), 0),
            masks (ResourcePerformanceRatings (), 1),
            masks (ResponseMethods (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Model of a generator  that is registered to participate in the market.
 *
 * @param sup [[ch.ninecode.model.RegisteredResource RegisteredResource]] Reference to the superclass object.
 * @param capacityFactor The ratio of actual energy produced by resource divided by the maximum potential energy if the resource is fully utilized.
 *        As an example, wind farms.
 * @param coldStartTime Cold start time.
 * @param combinedCycleOperatingMode Combined Cycle operating mode.
 * @param commericialOperationDate <em>undocumented</em>
 * @param constrainedOutputFlag Constrained Output Generator (COG) Indicator (Yes/No), per Generating Resource
 * @param energyDownRampRate Response rate in MW per minute for ramping energy down.
 * @param energyUpRampRate Response rate in MW per minute for ramping energy up.
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
 * @param loadFollowingDownMSS Certifies resources for use in MSS Load Following Down
 * @param loadFollowingUpMSS Certifies resources for use in MSS Load Following Up
 * @param lowControlLImit Low limit for secondary (AGC) control
 * @param maxDependableCap Maximum Dependable Capacity (MNDC).
 *        Maximun Net Dependable Capacity is used in association with an RMR contract.
 * @param maxMinLoadCost The registered maximum Minimum Load Cost of a Generating Resource registered with a Cost Basis of "Bid Cost".
 * @param maxPumpingLevel max pumping level of a hydro pump unit
 * @param maxShutdownTime Maximum time this device can be shut down.
 * @param maxStartUpsPerDay maximum start ups per day
 * @param maxWeeklyEnergy Maximum weekly Energy (Seasonal)
 * @param maxWeeklyStarts Maximum weekly starts (seasonal parameter)
 * @param maximumAllowableSpinningReserve Maximum allowable spinning reserve.
 *        Spinning reserve will never be considered greater than this value regardless of the current operating point.
 * @param maximumOperatingLimit This is the maximum operating MW limit the dispatcher can enter for this unit
 * @param minLoadCost minimum load cost.
 *        Value is (currency/hr)
 * @param minimumLoadCostBasis The cost basis for minimum load.
 * @param minimumLoadFuelCost The cost for the fuel required to get a Generating Resource to operate at the minimum load level
 * @param minimumOperatingLimit This is the minimum operating MW limit the dispatcher can enter for this unit.
 * @param mustOfferRA Flag to indicate that this unit is a resource adequacy resource and must offer.
 * @param nameplateCapacity MW value stated on the nameplate of the Generator -- the value it potentially could provide.
 * @param operatingMaintenanceCost The portion of the Operating Cost of a Generating Resource that is not related to fuel cost.
 * @param pumpMinDownTime The minimum down time for the pump in a pump storage unit.
 * @param pumpMinUpTime The minimum up time aspect for the pump in a pump storage unit
 * @param pumpShutdownCost The cost to shutdown a pump during the pump aspect of a pump storage unit.
 * @param pumpShutdownTime The shutdown time (minutes) of the pump aspect of a pump storage unit.
 * @param pumpingCost <em>undocumented</em>
 * @param pumpingFactor Pumping factor for pump storage units, conversion factor between generating and pumping.
 * @param quickStartFlag Quick start flag (Yes/No).
 *        Identifies the registered generator as a quick start unit. A quick start unit is a unit that has the ability to be available for load within a 30 minute period.
 * @param rampCurveType Ramp curve type.
 *        Identifies the type of curve which may be a fixed, static or dynamic.
 * @param regulationDownRampRate Regulation down response rate in MW per minute
 * @param regulationFlag Specifies if the unit is regulating or not regulating or expected to be regulating but is not.
 * @param regulationUpRampRate Regulation up response rate in MW per minute.
 * @param resourceSubType Unit sub type used by Settlements or scheduling application.
 *        Application use of the unit sub type may define the necessary types as applicable.
 * @param riverSystem River System the Resource is tied to.
 * @param spinRampRate Response rate in MW per minute for spinning reserve.
 * @param startUpCostBasis The cost basis for start up.
 * @param syncCondCapable Is the Resource Synchronous Condenser capable Resource?
 * @param unitType Generating unit type: Combined Cycle, Gas Turbine, Hydro Turbine, Other, Photovoltaic, Hydro Pump-Turbine, Reciprocating Engine, Steam Turbine, Synchronous Condenser, Wind Turbine
 * @param useLimitFlag Use limit flag: indicates if the use-limited resource is fully scheduled (or has some slack for real-time dispatch) (Y/N)
 * @param variableEnergyResource Provides an indication that this resource is intending to participate in an intermittent resource program.
 * @param AuxillaryObject [[ch.ninecode.model.AuxiliaryObject AuxiliaryObject]] <em>undocumented</em>
 * @param EnergyPriceIndex [[ch.ninecode.model.EnergyPriceIndex EnergyPriceIndex]] <em>undocumented</em>
 * @param FuelCostCurve [[ch.ninecode.model.FuelCostCurve FuelCostCurve]] <em>undocumented</em>
 * @param FuelRegion [[ch.ninecode.model.FuelRegion FuelRegion]] <em>undocumented</em>
 * @param GeneratingBids [[ch.ninecode.model.GeneratingBid GeneratingBid]] <em>undocumented</em>
 * @param LocalReliabilityArea [[ch.ninecode.model.LocalReliabilityArea LocalReliabilityArea]] <em>undocumented</em>
 * @param MktHeatRateCurve [[ch.ninecode.model.MktHeatRateCurve MktHeatRateCurve]] <em>undocumented</em>
 * @param RMNRFlag Reliability must not run (RMNR) flag: indicated whether the RMR unit is set as an RMNR in the current market
 * @param RMRFlag Reliability must run (RMR) flag: indicates whether the unit is RMR; Indicates whether the unit is RMR:
 *        N' - not an RMR unit
 *        '1' - RMR Condition 1 unit
 *        '2' - RMR Condition 2 unit
 * @param RMRHeatRateCurve [[ch.ninecode.model.RMRHeatRateCurve RMRHeatRateCurve]] <em>undocumented</em>
 * @param RMRManualIndicator Indicates the RMR Manual pre-determination status [Y/N]
 * @param RMRStartUpCostCurve [[ch.ninecode.model.RMRStartUpCostCurve RMRStartUpCostCurve]] <em>undocumented</em>
 * @param RMRStartUpEnergyCurve [[ch.ninecode.model.RMRStartUpEnergyCurve RMRStartUpEnergyCurve]] <em>undocumented</em>
 * @param RMRStartUpFuelCurve [[ch.ninecode.model.RMRStartUpFuelCurve RMRStartUpFuelCurve]] <em>undocumented</em>
 * @param RMRStartUpTimeCurve [[ch.ninecode.model.RMRStartUpTimeCurve RMRStartUpTimeCurve]] <em>undocumented</em>
 * @param RMTFlag Reliability must take (RMT) flag (Yes/No): indicates whether the unit is RMT
 * @param RegulatingLimit [[ch.ninecode.model.RegulatingLimit RegulatingLimit]] <em>undocumented</em>
 * @param StartUpCostCurves [[ch.ninecode.model.StartUpCostCurve StartUpCostCurve]] <em>undocumented</em>
 * @param StartUpEnergyCurve [[ch.ninecode.model.StartUpEnergyCurve StartUpEnergyCurve]] <em>undocumented</em>
 * @param StartUpFuelCurve [[ch.ninecode.model.StartUpFuelCurve StartUpFuelCurve]] <em>undocumented</em>
 * @param StartUpTimeCurve [[ch.ninecode.model.StartUpTimeCurve StartUpTimeCurve]] <em>undocumented</em>
 * @param Trade [[ch.ninecode.model.Trade Trade]] <em>undocumented</em>
 * @param UnitInitialConditions [[ch.ninecode.model.UnitInitialConditions UnitInitialConditions]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class RegisteredGenerator
(
    override val sup: RegisteredResource,
    capacityFactor: Double,
    coldStartTime: Double,
    combinedCycleOperatingMode: String,
    commericialOperationDate: String,
    constrainedOutputFlag: String,
    energyDownRampRate: Double,
    energyUpRampRate: Double,
    extremeLongStart: String,
    fuelSource: String,
    highControlLimit: Double,
    hotIntTime: Double,
    hotStartTime: Double,
    intColdTime: Double,
    intStartTime: Double,
    loadFollowingDownMSS: String,
    loadFollowingUpMSS: String,
    lowControlLImit: Double,
    maxDependableCap: Double,
    maxMinLoadCost: Double,
    maxPumpingLevel: Double,
    maxShutdownTime: String,
    maxStartUpsPerDay: Int,
    maxWeeklyEnergy: Double,
    maxWeeklyStarts: Int,
    maximumAllowableSpinningReserve: Double,
    maximumOperatingLimit: Double,
    minLoadCost: Double,
    minimumLoadCostBasis: String,
    minimumLoadFuelCost: Double,
    minimumOperatingLimit: Double,
    mustOfferRA: String,
    nameplateCapacity: Double,
    operatingMaintenanceCost: Double,
    pumpMinDownTime: Double,
    pumpMinUpTime: Double,
    pumpShutdownCost: Double,
    pumpShutdownTime: Int,
    pumpingCost: Double,
    pumpingFactor: Double,
    quickStartFlag: String,
    rampCurveType: String,
    regulationDownRampRate: Double,
    regulationFlag: String,
    regulationUpRampRate: Double,
    resourceSubType: String,
    riverSystem: String,
    spinRampRate: Double,
    startUpCostBasis: String,
    syncCondCapable: String,
    unitType: String,
    useLimitFlag: String,
    variableEnergyResource: String,
    AuxillaryObject: List[String],
    EnergyPriceIndex: String,
    FuelCostCurve: String,
    FuelRegion: String,
    GeneratingBids: List[String],
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
    StartUpCostCurves: List[String],
    StartUpEnergyCurve: String,
    StartUpFuelCurve: String,
    StartUpTimeCurve: String,
    Trade: List[String],
    UnitInitialConditions: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, null, null, null, 0.0, 0.0, null, null, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, 0.0, 0.0, 0.0, 0.0, null, 0, 0.0, 0, 0.0, 0.0, 0.0, null, 0.0, 0.0, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0, 0.0, 0.0, null, null, 0.0, null, 0.0, null, null, 0.0, null, null, null, null, null, List(), null, null, null, List(), null, null, null, null, null, null, null, null, null, null, null, null, List(), null, null, null, List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = RegisteredGenerator.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (RegisteredGenerator.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RegisteredGenerator.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (RegisteredGenerator.fields (position), x))
        emitelem (0, capacityFactor)
        emitelem (1, coldStartTime)
        emitelem (2, combinedCycleOperatingMode)
        emitelem (3, commericialOperationDate)
        emitattr (4, constrainedOutputFlag)
        emitelem (5, energyDownRampRate)
        emitelem (6, energyUpRampRate)
        emitattr (7, extremeLongStart)
        emitattr (8, fuelSource)
        emitelem (9, highControlLimit)
        emitelem (10, hotIntTime)
        emitelem (11, hotStartTime)
        emitelem (12, intColdTime)
        emitelem (13, intStartTime)
        emitattr (14, loadFollowingDownMSS)
        emitattr (15, loadFollowingUpMSS)
        emitelem (16, lowControlLImit)
        emitelem (17, maxDependableCap)
        emitelem (18, maxMinLoadCost)
        emitelem (19, maxPumpingLevel)
        emitelem (20, maxShutdownTime)
        emitelem (21, maxStartUpsPerDay)
        emitelem (22, maxWeeklyEnergy)
        emitelem (23, maxWeeklyStarts)
        emitelem (24, maximumAllowableSpinningReserve)
        emitelem (25, maximumOperatingLimit)
        emitelem (26, minLoadCost)
        emitattr (27, minimumLoadCostBasis)
        emitelem (28, minimumLoadFuelCost)
        emitelem (29, minimumOperatingLimit)
        emitattr (30, mustOfferRA)
        emitelem (31, nameplateCapacity)
        emitelem (32, operatingMaintenanceCost)
        emitelem (33, pumpMinDownTime)
        emitelem (34, pumpMinUpTime)
        emitelem (35, pumpShutdownCost)
        emitelem (36, pumpShutdownTime)
        emitelem (37, pumpingCost)
        emitelem (38, pumpingFactor)
        emitattr (39, quickStartFlag)
        emitattr (40, rampCurveType)
        emitelem (41, regulationDownRampRate)
        emitattr (42, regulationFlag)
        emitelem (43, regulationUpRampRate)
        emitelem (44, resourceSubType)
        emitelem (45, riverSystem)
        emitelem (46, spinRampRate)
        emitattr (47, startUpCostBasis)
        emitattr (48, syncCondCapable)
        emitattr (49, unitType)
        emitattr (50, useLimitFlag)
        emitattr (51, variableEnergyResource)
        emitattrs (52, AuxillaryObject)
        emitattr (53, EnergyPriceIndex)
        emitattr (54, FuelCostCurve)
        emitattr (55, FuelRegion)
        emitattrs (56, GeneratingBids)
        emitattr (57, LocalReliabilityArea)
        emitattr (58, MktHeatRateCurve)
        emitattr (59, RMNRFlag)
        emitattr (60, RMRFlag)
        emitattr (61, RMRHeatRateCurve)
        emitattr (62, RMRManualIndicator)
        emitattr (63, RMRStartUpCostCurve)
        emitattr (64, RMRStartUpEnergyCurve)
        emitattr (65, RMRStartUpFuelCurve)
        emitattr (66, RMRStartUpTimeCurve)
        emitattr (67, RMTFlag)
        emitattr (68, RegulatingLimit)
        emitattrs (69, StartUpCostCurves)
        emitattr (70, StartUpEnergyCurve)
        emitattr (71, StartUpFuelCurve)
        emitattr (72, StartUpTimeCurve)
        emitattrs (73, Trade)
        emitattrs (74, UnitInitialConditions)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RegisteredGenerator rdf:ID=\"%s\">\n%s\t</cim:RegisteredGenerator>".format (id, export_fields)
    }
}

object RegisteredGenerator
extends
    Parseable[RegisteredGenerator]
{
    override val fields: Array[String] = Array[String] (
        "capacityFactor",
        "coldStartTime",
        "combinedCycleOperatingMode",
        "commericialOperationDate",
        "constrainedOutputFlag",
        "energyDownRampRate",
        "energyUpRampRate",
        "extremeLongStart",
        "fuelSource",
        "highControlLimit",
        "hotIntTime",
        "hotStartTime",
        "intColdTime",
        "intStartTime",
        "loadFollowingDownMSS",
        "loadFollowingUpMSS",
        "lowControlLImit",
        "maxDependableCap",
        "maxMinLoadCost",
        "maxPumpingLevel",
        "maxShutdownTime",
        "maxStartUpsPerDay",
        "maxWeeklyEnergy",
        "maxWeeklyStarts",
        "maximumAllowableSpinningReserve",
        "maximumOperatingLimit",
        "minLoadCost",
        "minimumLoadCostBasis",
        "minimumLoadFuelCost",
        "minimumOperatingLimit",
        "mustOfferRA",
        "nameplateCapacity",
        "operatingMaintenanceCost",
        "pumpMinDownTime",
        "pumpMinUpTime",
        "pumpShutdownCost",
        "pumpShutdownTime",
        "pumpingCost",
        "pumpingFactor",
        "quickStartFlag",
        "rampCurveType",
        "regulationDownRampRate",
        "regulationFlag",
        "regulationUpRampRate",
        "resourceSubType",
        "riverSystem",
        "spinRampRate",
        "startUpCostBasis",
        "syncCondCapable",
        "unitType",
        "useLimitFlag",
        "variableEnergyResource",
        "AuxillaryObject",
        "EnergyPriceIndex",
        "FuelCostCurve",
        "FuelRegion",
        "GeneratingBids",
        "LocalReliabilityArea",
        "MktHeatRateCurve",
        "RMNRFlag",
        "RMRFlag",
        "RMRHeatRateCurve",
        "RMRManualIndicator",
        "RMRStartUpCostCurve",
        "RMRStartUpEnergyCurve",
        "RMRStartUpFuelCurve",
        "RMRStartUpTimeCurve",
        "RMTFlag",
        "RegulatingLimit",
        "StartUpCostCurves",
        "StartUpEnergyCurve",
        "StartUpFuelCurve",
        "StartUpTimeCurve",
        "Trade",
        "UnitInitialConditions"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AuxillaryObject", "AuxiliaryObject", "0..*", "0..1"),
        Relationship ("EnergyPriceIndex", "EnergyPriceIndex", "1", "1"),
        Relationship ("FuelCostCurve", "FuelCostCurve", "0..1", "0..1"),
        Relationship ("FuelRegion", "FuelRegion", "0..1", "0..*"),
        Relationship ("GeneratingBids", "GeneratingBid", "0..*", "0..1"),
        Relationship ("LocalReliabilityArea", "LocalReliabilityArea", "0..1", "0..*"),
        Relationship ("MktHeatRateCurve", "MktHeatRateCurve", "0..1", "0..1"),
        Relationship ("RMRHeatRateCurve", "RMRHeatRateCurve", "0..1", "0..1"),
        Relationship ("RMRStartUpCostCurve", "RMRStartUpCostCurve", "0..1", "0..1"),
        Relationship ("RMRStartUpEnergyCurve", "RMRStartUpEnergyCurve", "0..1", "0..1"),
        Relationship ("RMRStartUpFuelCurve", "RMRStartUpFuelCurve", "0..1", "0..1"),
        Relationship ("RMRStartUpTimeCurve", "RMRStartUpTimeCurve", "0..1", "0..1"),
        Relationship ("RegulatingLimit", "RegulatingLimit", "0..1", "0..1"),
        Relationship ("StartUpCostCurves", "StartUpCostCurve", "0..*", "0..*"),
        Relationship ("StartUpEnergyCurve", "StartUpEnergyCurve", "0..1", "0..1"),
        Relationship ("StartUpFuelCurve", "StartUpFuelCurve", "0..1", "0..1"),
        Relationship ("StartUpTimeCurve", "StartUpTimeCurve", "0..1", "0..1"),
        Relationship ("Trade", "Trade", "0..*", "0..1"),
        Relationship ("UnitInitialConditions", "UnitInitialConditions", "0..*", "0..1")
    )
    val capacityFactor: Fielder = parse_element (element (cls, fields(0)))
    val coldStartTime: Fielder = parse_element (element (cls, fields(1)))
    val combinedCycleOperatingMode: Fielder = parse_element (element (cls, fields(2)))
    val commericialOperationDate: Fielder = parse_element (element (cls, fields(3)))
    val constrainedOutputFlag: Fielder = parse_attribute (attribute (cls, fields(4)))
    val energyDownRampRate: Fielder = parse_element (element (cls, fields(5)))
    val energyUpRampRate: Fielder = parse_element (element (cls, fields(6)))
    val extremeLongStart: Fielder = parse_attribute (attribute (cls, fields(7)))
    val fuelSource: Fielder = parse_attribute (attribute (cls, fields(8)))
    val highControlLimit: Fielder = parse_element (element (cls, fields(9)))
    val hotIntTime: Fielder = parse_element (element (cls, fields(10)))
    val hotStartTime: Fielder = parse_element (element (cls, fields(11)))
    val intColdTime: Fielder = parse_element (element (cls, fields(12)))
    val intStartTime: Fielder = parse_element (element (cls, fields(13)))
    val loadFollowingDownMSS: Fielder = parse_attribute (attribute (cls, fields(14)))
    val loadFollowingUpMSS: Fielder = parse_attribute (attribute (cls, fields(15)))
    val lowControlLImit: Fielder = parse_element (element (cls, fields(16)))
    val maxDependableCap: Fielder = parse_element (element (cls, fields(17)))
    val maxMinLoadCost: Fielder = parse_element (element (cls, fields(18)))
    val maxPumpingLevel: Fielder = parse_element (element (cls, fields(19)))
    val maxShutdownTime: Fielder = parse_element (element (cls, fields(20)))
    val maxStartUpsPerDay: Fielder = parse_element (element (cls, fields(21)))
    val maxWeeklyEnergy: Fielder = parse_element (element (cls, fields(22)))
    val maxWeeklyStarts: Fielder = parse_element (element (cls, fields(23)))
    val maximumAllowableSpinningReserve: Fielder = parse_element (element (cls, fields(24)))
    val maximumOperatingLimit: Fielder = parse_element (element (cls, fields(25)))
    val minLoadCost: Fielder = parse_element (element (cls, fields(26)))
    val minimumLoadCostBasis: Fielder = parse_attribute (attribute (cls, fields(27)))
    val minimumLoadFuelCost: Fielder = parse_element (element (cls, fields(28)))
    val minimumOperatingLimit: Fielder = parse_element (element (cls, fields(29)))
    val mustOfferRA: Fielder = parse_attribute (attribute (cls, fields(30)))
    val nameplateCapacity: Fielder = parse_element (element (cls, fields(31)))
    val operatingMaintenanceCost: Fielder = parse_element (element (cls, fields(32)))
    val pumpMinDownTime: Fielder = parse_element (element (cls, fields(33)))
    val pumpMinUpTime: Fielder = parse_element (element (cls, fields(34)))
    val pumpShutdownCost: Fielder = parse_element (element (cls, fields(35)))
    val pumpShutdownTime: Fielder = parse_element (element (cls, fields(36)))
    val pumpingCost: Fielder = parse_element (element (cls, fields(37)))
    val pumpingFactor: Fielder = parse_element (element (cls, fields(38)))
    val quickStartFlag: Fielder = parse_attribute (attribute (cls, fields(39)))
    val rampCurveType: Fielder = parse_attribute (attribute (cls, fields(40)))
    val regulationDownRampRate: Fielder = parse_element (element (cls, fields(41)))
    val regulationFlag: Fielder = parse_attribute (attribute (cls, fields(42)))
    val regulationUpRampRate: Fielder = parse_element (element (cls, fields(43)))
    val resourceSubType: Fielder = parse_element (element (cls, fields(44)))
    val riverSystem: Fielder = parse_element (element (cls, fields(45)))
    val spinRampRate: Fielder = parse_element (element (cls, fields(46)))
    val startUpCostBasis: Fielder = parse_attribute (attribute (cls, fields(47)))
    val syncCondCapable: Fielder = parse_attribute (attribute (cls, fields(48)))
    val unitType: Fielder = parse_attribute (attribute (cls, fields(49)))
    val useLimitFlag: Fielder = parse_attribute (attribute (cls, fields(50)))
    val variableEnergyResource: Fielder = parse_attribute (attribute (cls, fields(51)))
    val AuxillaryObject: FielderMultiple = parse_attributes (attribute (cls, fields(52)))
    val EnergyPriceIndex: Fielder = parse_attribute (attribute (cls, fields(53)))
    val FuelCostCurve: Fielder = parse_attribute (attribute (cls, fields(54)))
    val FuelRegion: Fielder = parse_attribute (attribute (cls, fields(55)))
    val GeneratingBids: FielderMultiple = parse_attributes (attribute (cls, fields(56)))
    val LocalReliabilityArea: Fielder = parse_attribute (attribute (cls, fields(57)))
    val MktHeatRateCurve: Fielder = parse_attribute (attribute (cls, fields(58)))
    val RMNRFlag: Fielder = parse_attribute (attribute (cls, fields(59)))
    val RMRFlag: Fielder = parse_attribute (attribute (cls, fields(60)))
    val RMRHeatRateCurve: Fielder = parse_attribute (attribute (cls, fields(61)))
    val RMRManualIndicator: Fielder = parse_attribute (attribute (cls, fields(62)))
    val RMRStartUpCostCurve: Fielder = parse_attribute (attribute (cls, fields(63)))
    val RMRStartUpEnergyCurve: Fielder = parse_attribute (attribute (cls, fields(64)))
    val RMRStartUpFuelCurve: Fielder = parse_attribute (attribute (cls, fields(65)))
    val RMRStartUpTimeCurve: Fielder = parse_attribute (attribute (cls, fields(66)))
    val RMTFlag: Fielder = parse_attribute (attribute (cls, fields(67)))
    val RegulatingLimit: Fielder = parse_attribute (attribute (cls, fields(68)))
    val StartUpCostCurves: FielderMultiple = parse_attributes (attribute (cls, fields(69)))
    val StartUpEnergyCurve: Fielder = parse_attribute (attribute (cls, fields(70)))
    val StartUpFuelCurve: Fielder = parse_attribute (attribute (cls, fields(71)))
    val StartUpTimeCurve: Fielder = parse_attribute (attribute (cls, fields(72)))
    val Trade: FielderMultiple = parse_attributes (attribute (cls, fields(73)))
    val UnitInitialConditions: FielderMultiple = parse_attributes (attribute (cls, fields(74)))

    def parse (context: Context): RegisteredGenerator =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0,0,0)
        val ret = RegisteredGenerator (
            RegisteredResource.parse (context),
            toDouble (mask (capacityFactor (), 0)),
            toDouble (mask (coldStartTime (), 1)),
            mask (combinedCycleOperatingMode (), 2),
            mask (commericialOperationDate (), 3),
            mask (constrainedOutputFlag (), 4),
            toDouble (mask (energyDownRampRate (), 5)),
            toDouble (mask (energyUpRampRate (), 6)),
            mask (extremeLongStart (), 7),
            mask (fuelSource (), 8),
            toDouble (mask (highControlLimit (), 9)),
            toDouble (mask (hotIntTime (), 10)),
            toDouble (mask (hotStartTime (), 11)),
            toDouble (mask (intColdTime (), 12)),
            toDouble (mask (intStartTime (), 13)),
            mask (loadFollowingDownMSS (), 14),
            mask (loadFollowingUpMSS (), 15),
            toDouble (mask (lowControlLImit (), 16)),
            toDouble (mask (maxDependableCap (), 17)),
            toDouble (mask (maxMinLoadCost (), 18)),
            toDouble (mask (maxPumpingLevel (), 19)),
            mask (maxShutdownTime (), 20),
            toInteger (mask (maxStartUpsPerDay (), 21)),
            toDouble (mask (maxWeeklyEnergy (), 22)),
            toInteger (mask (maxWeeklyStarts (), 23)),
            toDouble (mask (maximumAllowableSpinningReserve (), 24)),
            toDouble (mask (maximumOperatingLimit (), 25)),
            toDouble (mask (minLoadCost (), 26)),
            mask (minimumLoadCostBasis (), 27),
            toDouble (mask (minimumLoadFuelCost (), 28)),
            toDouble (mask (minimumOperatingLimit (), 29)),
            mask (mustOfferRA (), 30),
            toDouble (mask (nameplateCapacity (), 31)),
            toDouble (mask (operatingMaintenanceCost (), 32)),
            toDouble (mask (pumpMinDownTime (), 33)),
            toDouble (mask (pumpMinUpTime (), 34)),
            toDouble (mask (pumpShutdownCost (), 35)),
            toInteger (mask (pumpShutdownTime (), 36)),
            toDouble (mask (pumpingCost (), 37)),
            toDouble (mask (pumpingFactor (), 38)),
            mask (quickStartFlag (), 39),
            mask (rampCurveType (), 40),
            toDouble (mask (regulationDownRampRate (), 41)),
            mask (regulationFlag (), 42),
            toDouble (mask (regulationUpRampRate (), 43)),
            mask (resourceSubType (), 44),
            mask (riverSystem (), 45),
            toDouble (mask (spinRampRate (), 46)),
            mask (startUpCostBasis (), 47),
            mask (syncCondCapable (), 48),
            mask (unitType (), 49),
            mask (useLimitFlag (), 50),
            mask (variableEnergyResource (), 51),
            masks (AuxillaryObject (), 52),
            mask (EnergyPriceIndex (), 53),
            mask (FuelCostCurve (), 54),
            mask (FuelRegion (), 55),
            masks (GeneratingBids (), 56),
            mask (LocalReliabilityArea (), 57),
            mask (MktHeatRateCurve (), 58),
            mask (RMNRFlag (), 59),
            mask (RMRFlag (), 60),
            mask (RMRHeatRateCurve (), 61),
            mask (RMRManualIndicator (), 62),
            mask (RMRStartUpCostCurve (), 63),
            mask (RMRStartUpEnergyCurve (), 64),
            mask (RMRStartUpFuelCurve (), 65),
            mask (RMRStartUpTimeCurve (), 66),
            mask (RMTFlag (), 67),
            mask (RegulatingLimit (), 68),
            masks (StartUpCostCurves (), 69),
            mask (StartUpEnergyCurve (), 70),
            mask (StartUpFuelCurve (), 71),
            mask (StartUpTimeCurve (), 72),
            masks (Trade (), 73),
            masks (UnitInitialConditions (), 74)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * This class represents the inter tie resource.
 *
 * @param sup [[ch.ninecode.model.RegisteredResource RegisteredResource]] Reference to the superclass object.
 * @param direction Indicates the direction (export/import) of an InterTie resource.
 * @param energyProductType Under each major product type, the commodity type can be applied to further specify the type.
 * @param isDCTie Flag to indicated whether this Inter-tie is a DC Tie.
 * @param isDynamicInterchange Specifies whether the inter-tie resource is registered for the dynamic interchange.
 * @param minHourlyBlockLimit The registered upper bound of minimum hourly block for an Inter-Tie Resource.
 * @param Flowgate [[ch.ninecode.model.Flowgate Flowgate]] <em>undocumented</em>
 * @param InterTieBid [[ch.ninecode.model.InterTieBid InterTieBid]] <em>undocumented</em>
 * @param InterTieDispatchResponse [[ch.ninecode.model.InterTieDispatchResponse InterTieDispatchResponse]] <em>undocumented</em>
 * @param InterchangeSchedule [[ch.ninecode.model.InterchangeSchedule InterchangeSchedule]] <em>undocumented</em>
 * @param WheelingCounterParty [[ch.ninecode.model.WheelingCounterParty WheelingCounterParty]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
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
    InterTieBid: String,
    InterTieDispatchResponse: List[String],
    InterchangeSchedule: List[String],
    WheelingCounterParty: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, 0, null, null, List(), List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = RegisteredInterTie.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (RegisteredInterTie.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RegisteredInterTie.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (RegisteredInterTie.fields (position), x))
        emitattr (0, direction)
        emitattr (1, energyProductType)
        emitattr (2, isDCTie)
        emitattr (3, isDynamicInterchange)
        emitelem (4, minHourlyBlockLimit)
        emitattr (5, Flowgate)
        emitattr (6, InterTieBid)
        emitattrs (7, InterTieDispatchResponse)
        emitattrs (8, InterchangeSchedule)
        emitattrs (9, WheelingCounterParty)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RegisteredInterTie rdf:ID=\"%s\">\n%s\t</cim:RegisteredInterTie>".format (id, export_fields)
    }
}

object RegisteredInterTie
extends
    Parseable[RegisteredInterTie]
{
    override val fields: Array[String] = Array[String] (
        "direction",
        "energyProductType",
        "isDCTie",
        "isDynamicInterchange",
        "minHourlyBlockLimit",
        "Flowgate",
        "InterTieBid",
        "InterTieDispatchResponse",
        "InterchangeSchedule",
        "WheelingCounterParty"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Flowgate", "Flowgate", "1", "0..*"),
        Relationship ("InterTieBid", "InterTieBid", "0..1", "0..1"),
        Relationship ("InterTieDispatchResponse", "InterTieDispatchResponse", "0..*", "1"),
        Relationship ("InterchangeSchedule", "InterchangeSchedule", "0..*", "0..1"),
        Relationship ("WheelingCounterParty", "WheelingCounterParty", "0..*", "0..*")
    )
    val direction: Fielder = parse_attribute (attribute (cls, fields(0)))
    val energyProductType: Fielder = parse_attribute (attribute (cls, fields(1)))
    val isDCTie: Fielder = parse_attribute (attribute (cls, fields(2)))
    val isDynamicInterchange: Fielder = parse_attribute (attribute (cls, fields(3)))
    val minHourlyBlockLimit: Fielder = parse_element (element (cls, fields(4)))
    val Flowgate: Fielder = parse_attribute (attribute (cls, fields(5)))
    val InterTieBid: Fielder = parse_attribute (attribute (cls, fields(6)))
    val InterTieDispatchResponse: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val InterchangeSchedule: FielderMultiple = parse_attributes (attribute (cls, fields(8)))
    val WheelingCounterParty: FielderMultiple = parse_attributes (attribute (cls, fields(9)))

    def parse (context: Context): RegisteredInterTie =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = RegisteredInterTie (
            RegisteredResource.parse (context),
            mask (direction (), 0),
            mask (energyProductType (), 1),
            mask (isDCTie (), 2),
            mask (isDynamicInterchange (), 3),
            toInteger (mask (minHourlyBlockLimit (), 4)),
            mask (Flowgate (), 5),
            mask (InterTieBid (), 6),
            masks (InterTieDispatchResponse (), 7),
            masks (InterchangeSchedule (), 8),
            masks (WheelingCounterParty (), 9)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Model of a load that is registered to participate in the market.
 *
 * RegisteredLoad is used to model any load that is served by the wholesale market directly. RegisteredLoads may be dispatchable or non-dispatchable and may or may not have bid curves. Examples of RegisteredLoads would include: distribution company load, energy retailer load, large bulk power system connected facility load.
 *
 * @param sup [[ch.ninecode.model.RegisteredResource RegisteredResource]] Reference to the superclass object.
 * @param blockLoadTransfer Emergency operating procedure - Flag to indicate that the Resource is Block Load pseudo resource.
 * @param dynamicallyScheduledLoadResource Flag to indicate that a Load Resource is part of a DSR Load
 * @param dynamicallyScheduledQualification Qualification status (used for DSR qualification).
 * @param AuxillaryObject [[ch.ninecode.model.AuxiliaryObject AuxiliaryObject]] <em>undocumented</em>
 * @param LoadBids [[ch.ninecode.model.LoadBid LoadBid]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class RegisteredLoad
(
    override val sup: RegisteredResource,
    blockLoadTransfer: Boolean,
    dynamicallyScheduledLoadResource: Boolean,
    dynamicallyScheduledQualification: Boolean,
    AuxillaryObject: List[String],
    LoadBids: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, false, false, List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = RegisteredLoad.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (RegisteredLoad.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (RegisteredLoad.fields (position), x))
        emitelem (0, blockLoadTransfer)
        emitelem (1, dynamicallyScheduledLoadResource)
        emitelem (2, dynamicallyScheduledQualification)
        emitattrs (3, AuxillaryObject)
        emitattrs (4, LoadBids)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RegisteredLoad rdf:ID=\"%s\">\n%s\t</cim:RegisteredLoad>".format (id, export_fields)
    }
}

object RegisteredLoad
extends
    Parseable[RegisteredLoad]
{
    override val fields: Array[String] = Array[String] (
        "blockLoadTransfer",
        "dynamicallyScheduledLoadResource",
        "dynamicallyScheduledQualification",
        "AuxillaryObject",
        "LoadBids"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AuxillaryObject", "AuxiliaryObject", "0..*", "0..1"),
        Relationship ("LoadBids", "LoadBid", "0..*", "0..1")
    )
    val blockLoadTransfer: Fielder = parse_element (element (cls, fields(0)))
    val dynamicallyScheduledLoadResource: Fielder = parse_element (element (cls, fields(1)))
    val dynamicallyScheduledQualification: Fielder = parse_element (element (cls, fields(2)))
    val AuxillaryObject: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val LoadBids: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: Context): RegisteredLoad =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = RegisteredLoad (
            RegisteredResource.parse (context),
            toBoolean (mask (blockLoadTransfer (), 0)),
            toBoolean (mask (dynamicallyScheduledLoadResource (), 1)),
            toBoolean (mask (dynamicallyScheduledQualification (), 2)),
            masks (AuxillaryObject (), 3),
            masks (LoadBids (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * This class represents the physical characteristic of a generator regarding the regulating limit.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param highLimit <em>undocumented</em>
 * @param lowLimit <em>undocumented</em>
 * @param RegisteredGenerator [[ch.ninecode.model.RegisteredGenerator RegisteredGenerator]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
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
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = RegulatingLimit.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (RegulatingLimit.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RegulatingLimit.fields (position), value)
        emitelem (0, highLimit)
        emitelem (1, lowLimit)
        emitattr (2, RegisteredGenerator)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RegulatingLimit rdf:ID=\"%s\">\n%s\t</cim:RegulatingLimit>".format (id, export_fields)
    }
}

object RegulatingLimit
extends
    Parseable[RegulatingLimit]
{
    override val fields: Array[String] = Array[String] (
        "highLimit",
        "lowLimit",
        "RegisteredGenerator"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RegisteredGenerator", "RegisteredGenerator", "0..1", "0..1")
    )
    val highLimit: Fielder = parse_element (element (cls, fields(0)))
    val lowLimit: Fielder = parse_element (element (cls, fields(1)))
    val RegisteredGenerator: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): RegulatingLimit =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = RegulatingLimit (
            IdentifiedObject.parse (context),
            toDouble (mask (highLimit (), 0)),
            toDouble (mask (lowLimit (), 1)),
            mask (RegisteredGenerator (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Specifies certification for a resource to participate in a specific markets.
 *
 * @param sup Reference to the superclass object.
 * @param market market type
 * @param qualificationFlag Status of the qualification ('Y' = Active, 'N' = Inactive)
 * @param type Type of service based on ResourceAncillaryServiceType enumeration
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] RegisteredResources are qualified for resource ancillary service types (which include market product types as well as other types such as BlackStart) by the association to the class ResourceAncillaryServiceQualification.
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class ResourceCertification
(
    override val sup: BasicElement,
    market: String,
    qualificationFlag: String,
    `type`: String,
    RegisteredResource: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ResourceCertification] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ResourceCertification.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ResourceCertification.fields (position), value)
        emitattr (0, market)
        emitattr (1, qualificationFlag)
        emitattr (2, `type`)
        emitattr (3, RegisteredResource)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ResourceCertification rdf:ID=\"%s\">\n%s\t</cim:ResourceCertification>".format (id, export_fields)
    }
}

object ResourceCertification
extends
    Parseable[ResourceCertification]
{
    override val fields: Array[String] = Array[String] (
        "market",
        "qualificationFlag",
        "type",
        "RegisteredResource"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RegisteredResource", "RegisteredResource", "1", "0..*")
    )
    val market: Fielder = parse_attribute (attribute (cls, fields(0)))
    val qualificationFlag: Fielder = parse_attribute (attribute (cls, fields(1)))
    val `type`: Fielder = parse_attribute (attribute (cls, fields(2)))
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): ResourceCertification =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ResourceCertification (
            BasicElement.parse (context),
            mask (market (), 0),
            mask (qualificationFlag (), 1),
            mask (`type` (), 2),
            mask (RegisteredResource (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * To model the Operation and Maintenance (O and M) costs of a generation resource.
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param gasPercentAboveLowSustainedLimit Percentage of Fuel Index Price (gas) for operating above Low Sustained Limit (LSL)
 * @param oilPercentAboveLowSustainedLimit Percentage of Fuel Oil Price (FOP) for operating above Low Sustained Limit (LSL)
 * @param omCostColdStartup Verifiable O&amp;M Cost (\$), Cold Startup
 * @param omCostHotStartup Verifiable O&amp;M Cost (\$), Hot Startup
 * @param omCostIntermediateStartup Verifiable O&amp;M Cost (\$), Intermediate Startup
 * @param omCostLowSustainedLimit Verifiable O&amp;M Cost (\$/MWh), LSL
 * @param solidfuelPercentAboveLowSustainedLimit Percentage of Solid Fuel for operating above Low Sustained Limit (LSL)
 * @param ResourceVerifiableCosts [[ch.ninecode.model.ResourceVerifiableCosts ResourceVerifiableCosts]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
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
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ResourceOperationMaintenanceCost.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ResourceOperationMaintenanceCost.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ResourceOperationMaintenanceCost.fields (position), value)
        emitelem (0, gasPercentAboveLowSustainedLimit)
        emitelem (1, oilPercentAboveLowSustainedLimit)
        emitelem (2, omCostColdStartup)
        emitelem (3, omCostHotStartup)
        emitelem (4, omCostIntermediateStartup)
        emitelem (5, omCostLowSustainedLimit)
        emitelem (6, solidfuelPercentAboveLowSustainedLimit)
        emitattr (7, ResourceVerifiableCosts)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ResourceOperationMaintenanceCost rdf:ID=\"%s\">\n%s\t</cim:ResourceOperationMaintenanceCost>".format (id, export_fields)
    }
}

object ResourceOperationMaintenanceCost
extends
    Parseable[ResourceOperationMaintenanceCost]
{
    override val fields: Array[String] = Array[String] (
        "gasPercentAboveLowSustainedLimit",
        "oilPercentAboveLowSustainedLimit",
        "omCostColdStartup",
        "omCostHotStartup",
        "omCostIntermediateStartup",
        "omCostLowSustainedLimit",
        "solidfuelPercentAboveLowSustainedLimit",
        "ResourceVerifiableCosts"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ResourceVerifiableCosts", "ResourceVerifiableCosts", "0..1", "1")
    )
    val gasPercentAboveLowSustainedLimit: Fielder = parse_element (element (cls, fields(0)))
    val oilPercentAboveLowSustainedLimit: Fielder = parse_element (element (cls, fields(1)))
    val omCostColdStartup: Fielder = parse_element (element (cls, fields(2)))
    val omCostHotStartup: Fielder = parse_element (element (cls, fields(3)))
    val omCostIntermediateStartup: Fielder = parse_element (element (cls, fields(4)))
    val omCostLowSustainedLimit: Fielder = parse_element (element (cls, fields(5)))
    val solidfuelPercentAboveLowSustainedLimit: Fielder = parse_element (element (cls, fields(6)))
    val ResourceVerifiableCosts: Fielder = parse_attribute (attribute (cls, fields(7)))

    def parse (context: Context): ResourceOperationMaintenanceCost =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ResourceOperationMaintenanceCost (
            Curve.parse (context),
            toDouble (mask (gasPercentAboveLowSustainedLimit (), 0)),
            toDouble (mask (oilPercentAboveLowSustainedLimit (), 1)),
            toDouble (mask (omCostColdStartup (), 2)),
            toDouble (mask (omCostHotStartup (), 3)),
            toDouble (mask (omCostIntermediateStartup (), 4)),
            toDouble (mask (omCostLowSustainedLimit (), 5)),
            toDouble (mask (solidfuelPercentAboveLowSustainedLimit (), 6)),
            mask (ResourceVerifiableCosts (), 7)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * To model the startup costs of a generation resource.
 *
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
 * @param ResourceVerifiableCosts [[ch.ninecode.model.ResourceVerifiableCosts ResourceVerifiableCosts]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
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
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ResourceStartupCost.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ResourceStartupCost.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ResourceStartupCost.fields (position), value)
        emitelem (0, fuelColdStartup)
        emitelem (1, fuelHotStartup)
        emitelem (2, fuelIntermediateStartup)
        emitelem (3, fuelLowSustainedLimit)
        emitelem (4, gasPercentColdStartup)
        emitelem (5, gasPercentHotStartup)
        emitelem (6, gasPercentIntermediateStartup)
        emitelem (7, gasPercentLowSustainedLimit)
        emitelem (8, oilPercentColdStartup)
        emitelem (9, oilPercentHotStartup)
        emitelem (10, oilPercentIntermediateStartup)
        emitelem (11, oilPercentLowSustainedLimit)
        emitelem (12, solidfuelPercentColdStartup)
        emitelem (13, solidfuelPercentHotStartup)
        emitelem (14, solidfuelPercentIntermediateStartup)
        emitelem (15, solidfuelPercentLowSustainedLimit)
        emitattr (16, ResourceVerifiableCosts)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ResourceStartupCost rdf:ID=\"%s\">\n%s\t</cim:ResourceStartupCost>".format (id, export_fields)
    }
}

object ResourceStartupCost
extends
    Parseable[ResourceStartupCost]
{
    override val fields: Array[String] = Array[String] (
        "fuelColdStartup",
        "fuelHotStartup",
        "fuelIntermediateStartup",
        "fuelLowSustainedLimit",
        "gasPercentColdStartup",
        "gasPercentHotStartup",
        "gasPercentIntermediateStartup",
        "gasPercentLowSustainedLimit",
        "oilPercentColdStartup",
        "oilPercentHotStartup",
        "oilPercentIntermediateStartup",
        "oilPercentLowSustainedLimit",
        "solidfuelPercentColdStartup",
        "solidfuelPercentHotStartup",
        "solidfuelPercentIntermediateStartup",
        "solidfuelPercentLowSustainedLimit",
        "ResourceVerifiableCosts"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ResourceVerifiableCosts", "ResourceVerifiableCosts", "1", "0..*")
    )
    val fuelColdStartup: Fielder = parse_element (element (cls, fields(0)))
    val fuelHotStartup: Fielder = parse_element (element (cls, fields(1)))
    val fuelIntermediateStartup: Fielder = parse_element (element (cls, fields(2)))
    val fuelLowSustainedLimit: Fielder = parse_element (element (cls, fields(3)))
    val gasPercentColdStartup: Fielder = parse_element (element (cls, fields(4)))
    val gasPercentHotStartup: Fielder = parse_element (element (cls, fields(5)))
    val gasPercentIntermediateStartup: Fielder = parse_element (element (cls, fields(6)))
    val gasPercentLowSustainedLimit: Fielder = parse_element (element (cls, fields(7)))
    val oilPercentColdStartup: Fielder = parse_element (element (cls, fields(8)))
    val oilPercentHotStartup: Fielder = parse_element (element (cls, fields(9)))
    val oilPercentIntermediateStartup: Fielder = parse_element (element (cls, fields(10)))
    val oilPercentLowSustainedLimit: Fielder = parse_element (element (cls, fields(11)))
    val solidfuelPercentColdStartup: Fielder = parse_element (element (cls, fields(12)))
    val solidfuelPercentHotStartup: Fielder = parse_element (element (cls, fields(13)))
    val solidfuelPercentIntermediateStartup: Fielder = parse_element (element (cls, fields(14)))
    val solidfuelPercentLowSustainedLimit: Fielder = parse_element (element (cls, fields(15)))
    val ResourceVerifiableCosts: Fielder = parse_attribute (attribute (cls, fields(16)))

    def parse (context: Context): ResourceStartupCost =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ResourceStartupCost (
            BasicElement.parse (context),
            toDouble (mask (fuelColdStartup (), 0)),
            toDouble (mask (fuelHotStartup (), 1)),
            toDouble (mask (fuelIntermediateStartup (), 2)),
            toDouble (mask (fuelLowSustainedLimit (), 3)),
            toDouble (mask (gasPercentColdStartup (), 4)),
            toDouble (mask (gasPercentHotStartup (), 5)),
            toDouble (mask (gasPercentIntermediateStartup (), 6)),
            toDouble (mask (gasPercentLowSustainedLimit (), 7)),
            toDouble (mask (oilPercentColdStartup (), 8)),
            toDouble (mask (oilPercentHotStartup (), 9)),
            toDouble (mask (oilPercentIntermediateStartup (), 10)),
            toDouble (mask (oilPercentLowSustainedLimit (), 11)),
            toDouble (mask (solidfuelPercentColdStartup (), 12)),
            toDouble (mask (solidfuelPercentHotStartup (), 13)),
            toDouble (mask (solidfuelPercentIntermediateStartup (), 14)),
            toDouble (mask (solidfuelPercentLowSustainedLimit (), 15)),
            mask (ResourceVerifiableCosts (), 16)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * This class is defined to describe the verifiable costs associated with a generation resource.
 *
 * @param sup Reference to the superclass object.
 * @param MktHeatRateCurve [[ch.ninecode.model.MktHeatRateCurve MktHeatRateCurve]] <em>undocumented</em>
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @param ResourceOperationMaintenanceCost [[ch.ninecode.model.ResourceOperationMaintenanceCost ResourceOperationMaintenanceCost]] <em>undocumented</em>
 * @param ResourceStartupCost [[ch.ninecode.model.ResourceStartupCost ResourceStartupCost]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class ResourceVerifiableCosts
(
    override val sup: BasicElement,
    MktHeatRateCurve: String,
    RegisteredResource: String,
    ResourceOperationMaintenanceCost: String,
    ResourceStartupCost: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ResourceVerifiableCosts.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ResourceVerifiableCosts.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (ResourceVerifiableCosts.fields (position), x))
        emitattr (0, MktHeatRateCurve)
        emitattr (1, RegisteredResource)
        emitattr (2, ResourceOperationMaintenanceCost)
        emitattrs (3, ResourceStartupCost)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ResourceVerifiableCosts rdf:ID=\"%s\">\n%s\t</cim:ResourceVerifiableCosts>".format (id, export_fields)
    }
}

object ResourceVerifiableCosts
extends
    Parseable[ResourceVerifiableCosts]
{
    override val fields: Array[String] = Array[String] (
        "MktHeatRateCurve",
        "RegisteredResource",
        "ResourceOperationMaintenanceCost",
        "ResourceStartupCost"
    )
    override val relations: List[Relationship] = List (
        Relationship ("MktHeatRateCurve", "MktHeatRateCurve", "1", "0..1"),
        Relationship ("RegisteredResource", "RegisteredResource", "1", "0..1"),
        Relationship ("ResourceOperationMaintenanceCost", "ResourceOperationMaintenanceCost", "1", "0..1"),
        Relationship ("ResourceStartupCost", "ResourceStartupCost", "0..*", "1")
    )
    val MktHeatRateCurve: Fielder = parse_attribute (attribute (cls, fields(0)))
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields(1)))
    val ResourceOperationMaintenanceCost: Fielder = parse_attribute (attribute (cls, fields(2)))
    val ResourceStartupCost: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: Context): ResourceVerifiableCosts =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ResourceVerifiableCosts (
            BasicElement.parse (context),
            mask (MktHeatRateCurve (), 0),
            mask (RegisteredResource (), 1),
            mask (ResourceOperationMaintenanceCost (), 2),
            masks (ResourceStartupCost (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Specifies a category of energy usage that the demand response applies for; e.g. energy from lighting, HVAC, other.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param activePower The active power value for the demand adjustment type.
 *        This supports requests to be made to a resource for some amount of active power provided by a particular response method, as specified by the method attribute (e.g. lighting, HVAC, wall mounted air conditioners, etc.).
 * @param activePowerUOM The unit of measure of active power, e.g. kiloWatts (kW), megaWatts (mW), etc.
 * @param method The response method (e.g. lighting, HVAC, wall mounted air conditioners, etc.).
 * @param siteMultiplier This value provides for scaling of a response method's active power.
 *        For example, a response method of air conditioning could utilize a small amount of active power from each air conditioning unit (e.g. 0.1 kiloWatt), but the site multiplier could be used to produce a the total active power adjustment by multiplying the response method active power by this value (e.g. a building with 100 window air conditioning  units, so 100 * 0.1 kW = 10 kW).
 * @param RegisteredResource [[ch.ninecode.model.RegisteredDistributedResource RegisteredDistributedResource]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class ResponseMethod
(
    override val sup: IdentifiedObject,
    activePower: Double,
    activePowerUOM: String,
    method: String,
    siteMultiplier: Int,
    RegisteredResource: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, null, 0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ResponseMethod] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ResponseMethod.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ResponseMethod.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ResponseMethod.fields (position), value)
        emitelem (0, activePower)
        emitelem (1, activePowerUOM)
        emitelem (2, method)
        emitelem (3, siteMultiplier)
        emitattr (4, RegisteredResource)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ResponseMethod rdf:ID=\"%s\">\n%s\t</cim:ResponseMethod>".format (id, export_fields)
    }
}

object ResponseMethod
extends
    Parseable[ResponseMethod]
{
    override val fields: Array[String] = Array[String] (
        "activePower",
        "activePowerUOM",
        "method",
        "siteMultiplier",
        "RegisteredResource"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RegisteredResource", "RegisteredDistributedResource", "1", "0..*")
    )
    val activePower: Fielder = parse_element (element (cls, fields(0)))
    val activePowerUOM: Fielder = parse_element (element (cls, fields(1)))
    val method: Fielder = parse_element (element (cls, fields(2)))
    val siteMultiplier: Fielder = parse_element (element (cls, fields(3)))
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): ResponseMethod =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ResponseMethod (
            IdentifiedObject.parse (context),
            toDouble (mask (activePower (), 0)),
            mask (activePowerUOM (), 1),
            mask (method (), 2),
            toInteger (mask (siteMultiplier (), 3)),
            mask (RegisteredResource (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Market participants could be represented by Scheduling Coordinators (SCs) that are registered with the RTO/ISO.
 *
 * One participant could register multiple SCs with the RTO/ISO. Many market participants can do business with the RTO/ISO using a single SC. One SC could schedule multiple generators. A load scheduling point could be used by multiple SCs. Each SC could schedule load at multiple scheduling points. An inter-tie scheduling point can be used by multiple SCs. Each SC can schedule interchange at multiple inter-tie scheduling points.
 *
 * @param sup [[ch.ninecode.model.MarketParticipant MarketParticipant]] Reference to the superclass object.
 * @param creditFlag Flag to indicate creditworthiness (Y, N)
 * @param creditStartEffectiveDate Date that the scheduling coordinator becomes creditworthy.
 * @param lastModified Indication of the last time this scheduling coordinator information was modified.
 * @param qualificationStatus Scheduling coordinator qualification status, Qualified, Not Qualified, or Disqualified.
 * @param scid This is the short name or Scheduling Coordinator ID field.
 * @param FromSCTrade [[ch.ninecode.model.Trade Trade]] <em>undocumented</em>
 * @param LoadRatio [[ch.ninecode.model.LoadRatio LoadRatio]] <em>undocumented</em>
 * @param MarketParticipant [[ch.ninecode.model.MarketParticipant MarketParticipant]] <em>undocumented</em>
 * @param SubmitFromSCTrade [[ch.ninecode.model.Trade Trade]] <em>undocumented</em>
 * @param SubmitToSCTrade [[ch.ninecode.model.Trade Trade]] <em>undocumented</em>
 * @param ToSCTrade [[ch.ninecode.model.Trade Trade]] <em>undocumented</em>
 * @param TransmissionContractRight [[ch.ninecode.model.ContractRight ContractRight]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class SchedulingCoordinator
(
    override val sup: MarketParticipant,
    creditFlag: String,
    creditStartEffectiveDate: String,
    lastModified: String,
    qualificationStatus: String,
    scid: String,
    FromSCTrade: List[String],
    LoadRatio: String,
    MarketParticipant_attr: String,
    SubmitFromSCTrade: List[String],
    SubmitToSCTrade: List[String],
    ToSCTrade: List[String],
    TransmissionContractRight: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, List(), null, null, List(), List(), List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def MarketParticipant: MarketParticipant = sup.asInstanceOf[MarketParticipant]
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = SchedulingCoordinator.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SchedulingCoordinator.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SchedulingCoordinator.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (SchedulingCoordinator.fields (position), x))
        emitattr (0, creditFlag)
        emitelem (1, creditStartEffectiveDate)
        emitelem (2, lastModified)
        emitelem (3, qualificationStatus)
        emitelem (4, scid)
        emitattrs (5, FromSCTrade)
        emitattr (6, LoadRatio)
        emitattr (7, MarketParticipant_attr)
        emitattrs (8, SubmitFromSCTrade)
        emitattrs (9, SubmitToSCTrade)
        emitattrs (10, ToSCTrade)
        emitattrs (11, TransmissionContractRight)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SchedulingCoordinator rdf:ID=\"%s\">\n%s\t</cim:SchedulingCoordinator>".format (id, export_fields)
    }
}

object SchedulingCoordinator
extends
    Parseable[SchedulingCoordinator]
{
    override val fields: Array[String] = Array[String] (
        "creditFlag",
        "creditStartEffectiveDate",
        "lastModified",
        "qualificationStatus",
        "scid",
        "FromSCTrade",
        "LoadRatio",
        "MarketParticipant",
        "SubmitFromSCTrade",
        "SubmitToSCTrade",
        "ToSCTrade",
        "TransmissionContractRight"
    )
    override val relations: List[Relationship] = List (
        Relationship ("FromSCTrade", "Trade", "0..*", "1"),
        Relationship ("LoadRatio", "LoadRatio", "1", "0..1"),
        Relationship ("MarketParticipant_attr", "MarketParticipant", "0..1", "0..*"),
        Relationship ("SubmitFromSCTrade", "Trade", "0..*", "0..1"),
        Relationship ("SubmitToSCTrade", "Trade", "0..*", "0..1"),
        Relationship ("ToSCTrade", "Trade", "0..*", "1"),
        Relationship ("TransmissionContractRight", "ContractRight", "0..*", "1")
    )
    val creditFlag: Fielder = parse_attribute (attribute (cls, fields(0)))
    val creditStartEffectiveDate: Fielder = parse_element (element (cls, fields(1)))
    val lastModified: Fielder = parse_element (element (cls, fields(2)))
    val qualificationStatus: Fielder = parse_element (element (cls, fields(3)))
    val scid: Fielder = parse_element (element (cls, fields(4)))
    val FromSCTrade: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val LoadRatio: Fielder = parse_attribute (attribute (cls, fields(6)))
    val MarketParticipant_attr: Fielder = parse_attribute (attribute (cls, fields(7)))
    val SubmitFromSCTrade: FielderMultiple = parse_attributes (attribute (cls, fields(8)))
    val SubmitToSCTrade: FielderMultiple = parse_attributes (attribute (cls, fields(9)))
    val ToSCTrade: FielderMultiple = parse_attributes (attribute (cls, fields(10)))
    val TransmissionContractRight: FielderMultiple = parse_attributes (attribute (cls, fields(11)))

    def parse (context: Context): SchedulingCoordinator =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = SchedulingCoordinator (
            MarketParticipant.parse (context),
            mask (creditFlag (), 0),
            mask (creditStartEffectiveDate (), 1),
            mask (lastModified (), 2),
            mask (qualificationStatus (), 3),
            mask (scid (), 4),
            masks (FromSCTrade (), 5),
            mask (LoadRatio (), 6),
            mask (MarketParticipant_attr (), 7),
            masks (SubmitFromSCTrade (), 8),
            masks (SubmitToSCTrade (), 9),
            masks (ToSCTrade (), 10),
            masks (TransmissionContractRight (), 11)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Describing users of a Scheduling Coordinator.
 *
 * @param sup Reference to the superclass object.
 * @param loginID Login ID
 * @param loginRole Assigned roles (these are roles with either Read or Read/Write privileges on different Market Systems)
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class SchedulingCoordinatorUser
(
    override val sup: BasicElement,
    loginID: String,
    loginRole: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = SchedulingCoordinatorUser.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SchedulingCoordinatorUser.fields (position), value)
        emitelem (0, loginID)
        emitelem (1, loginRole)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SchedulingCoordinatorUser rdf:ID=\"%s\">\n%s\t</cim:SchedulingCoordinatorUser>".format (id, export_fields)
    }
}

object SchedulingCoordinatorUser
extends
    Parseable[SchedulingCoordinatorUser]
{
    override val fields: Array[String] = Array[String] (
        "loginID",
        "loginRole"
    )
    val loginID: Fielder = parse_element (element (cls, fields(0)))
    val loginRole: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: Context): SchedulingCoordinatorUser =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = SchedulingCoordinatorUser (
            BasicElement.parse (context),
            mask (loginID (), 0),
            mask (loginRole (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Connection to other organizations at the boundary of the ISO/RTO.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param Flowgate [[ch.ninecode.model.Flowgate Flowgate]] <em>undocumented</em>
 * @param InterchangeSchedule [[ch.ninecode.model.InterchangeSchedule InterchangeSchedule]] <em>undocumented</em>
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class SchedulingPoint
(
    override val sup: IdentifiedObject,
    Flowgate: String,
    InterchangeSchedule: List[String],
    RegisteredResource: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = SchedulingPoint.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SchedulingPoint.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (SchedulingPoint.fields (position), x))
        emitattr (0, Flowgate)
        emitattrs (1, InterchangeSchedule)
        emitattrs (2, RegisteredResource)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SchedulingPoint rdf:ID=\"%s\">\n%s\t</cim:SchedulingPoint>".format (id, export_fields)
    }
}

object SchedulingPoint
extends
    Parseable[SchedulingPoint]
{
    override val fields: Array[String] = Array[String] (
        "Flowgate",
        "InterchangeSchedule",
        "RegisteredResource"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Flowgate", "Flowgate", "0..1", "0..*"),
        Relationship ("InterchangeSchedule", "InterchangeSchedule", "0..*", "0..1"),
        Relationship ("RegisteredResource", "RegisteredResource", "0..*", "0..*")
    )
    val Flowgate: Fielder = parse_attribute (attribute (cls, fields(0)))
    val InterchangeSchedule: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val RegisteredResource: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: Context): SchedulingPoint =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = SchedulingPoint (
            IdentifiedObject.parse (context),
            mask (Flowgate (), 0),
            masks (InterchangeSchedule (), 1),
            masks (RegisteredResource (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The energy consumption of a generating resource to complete a start-up from the StartUpEnergyCurve.
 *
 * Definition of the StartUpEnergyCurve includes, xvalue as the cooling time and y1value as the MW value.
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param RegisteredGenerator [[ch.ninecode.model.RegisteredGenerator RegisteredGenerator]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class StartUpEnergyCurve
(
    override val sup: Curve,
    RegisteredGenerator: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = StartUpEnergyCurve.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (StartUpEnergyCurve.fields (position), value)
        emitattr (0, RegisteredGenerator)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:StartUpEnergyCurve rdf:ID=\"%s\">\n%s\t</cim:StartUpEnergyCurve>".format (id, export_fields)
    }
}

object StartUpEnergyCurve
extends
    Parseable[StartUpEnergyCurve]
{
    override val fields: Array[String] = Array[String] (
        "RegisteredGenerator"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RegisteredGenerator", "RegisteredGenerator", "0..1", "0..1")
    )
    val RegisteredGenerator: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): StartUpEnergyCurve =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = StartUpEnergyCurve (
            Curve.parse (context),
            mask (RegisteredGenerator (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The fuel consumption of a Generating Resource to complete a Start-Up.(x=cooling time) Form Startup Fuel Curve. xAxisData -&gt; cooling time, y1AxisData -&gt; MBtu.
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param RegisteredGenerator [[ch.ninecode.model.RegisteredGenerator RegisteredGenerator]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class StartUpFuelCurve
(
    override val sup: Curve,
    RegisteredGenerator: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = StartUpFuelCurve.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (StartUpFuelCurve.fields (position), value)
        emitattr (0, RegisteredGenerator)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:StartUpFuelCurve rdf:ID=\"%s\">\n%s\t</cim:StartUpFuelCurve>".format (id, export_fields)
    }
}

object StartUpFuelCurve
extends
    Parseable[StartUpFuelCurve]
{
    override val fields: Array[String] = Array[String] (
        "RegisteredGenerator"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RegisteredGenerator", "RegisteredGenerator", "0..1", "0..1")
    )
    val RegisteredGenerator: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): StartUpFuelCurve =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = StartUpFuelCurve (
            Curve.parse (context),
            mask (RegisteredGenerator (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * An area defined for the purpose of tracking interchange with surrounding areas via tie points; may or may not serve as a control area.
 *
 * @param sup [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param areaShortName Market area short name, which is the regulation zone.
 *        It references AGC regulation zone name.
 * @param constantCoefficient Loss estimate constant coefficient
 * @param embeddedControlArea Used in conjunction with the InternalCA flag.
 *        If the InternalCA flag is YES, this flag does not apply. If the InternaCA flag is NO, this flag provides an indication of AdjacentCA (NO) or Embedded CA (YES).
 * @param internalCA A Yes/No indication that this control area is contained internal to the system.
 * @param linearCoefficient Loss estimate linear coefficient
 * @param localCA Indication that this control area is the local control area.
 * @param maxSelfSchedMW Maximum amount of self schedule MWs allowed for an embedded control area.
 * @param minSelfSchedMW Minimum amount of self schedule MW allowed for an embedded control area.
 * @param quadraticCoefficient Loss estimate quadratic coefficient
 * @param AdjacentCASet [[ch.ninecode.model.AdjacentCASet AdjacentCASet]] <em>undocumented</em>
 * @param AggregateNode [[ch.ninecode.model.AggregateNode AggregateNode]] <em>undocumented</em>
 * @param AreaReserveSpecification [[ch.ninecode.model.AreaReserveSpec AreaReserveSpec]] <em>undocumented</em>
 * @param BidSelfSched [[ch.ninecode.model.BidSelfSched BidSelfSched]] <em>undocumented</em>
 * @param CnodeDistributionFactor [[ch.ninecode.model.CnodeDistributionFactor CnodeDistributionFactor]] <em>undocumented</em>
 * @param ControlAreaDesignation [[ch.ninecode.model.ControlAreaDesignation ControlAreaDesignation]] <em>undocumented</em>
 * @param ExPostLossResults [[ch.ninecode.model.ExPostLossResults ExPostLossResults]] <em>undocumented</em>
 * @param Export_EnergyTransactions [[ch.ninecode.model.EnergyTransaction EnergyTransaction]] Energy is transferred between interchange areas
 * @param From_Flowgate [[ch.ninecode.model.Flowgate Flowgate]] <em>undocumented</em>
 * @param GeneralClearingResults [[ch.ninecode.model.GeneralClearingResults GeneralClearingResults]] <em>undocumented</em>
 * @param HostControlArea [[ch.ninecode.model.HostControlArea HostControlArea]] The interchange area  may operate as a control area
 * @param Import_EnergyTransactions [[ch.ninecode.model.EnergyTransaction EnergyTransaction]] Energy is transferred between interchange areas
 * @param InadvertentAccount [[ch.ninecode.model.InadvertentAccount InadvertentAccount]] A control area can have one or more net inadvertent interchange accounts
 * @param LossClearingResults [[ch.ninecode.model.LossClearingResults LossClearingResults]] <em>undocumented</em>
 * @param Pnode [[ch.ninecode.model.Pnode Pnode]] <em>undocumented</em>
 * @param RTO [[ch.ninecode.model.RTO RTO]] <em>undocumented</em>
 * @param Receive_DynamicSchedules [[ch.ninecode.model.DynamicSchedule DynamicSchedule]] A control area can receive dynamic schedules from other control areas
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @param Send_DynamicSchedules [[ch.ninecode.model.DynamicSchedule DynamicSchedule]] A control area can send dynamic schedules to other control areas
 * @param SideA_TieLines [[ch.ninecode.model.TieLine TieLine]] The SubControlArea is on the A side of a collection of metered points which define the SubControlArea's boundary for a ControlAreaOperator or CustomerConsumer.
 * @param SideB_TieLines [[ch.ninecode.model.TieLine TieLine]] The SubControlArea is on the B side of a collection of metered points which define the SubControlArea's boundary for a ControlAreaOperator or CustomerConsumer.
 * @param To_Flowgate [[ch.ninecode.model.Flowgate Flowgate]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class SubControlArea
(
    override val sup: PowerSystemResource,
    areaShortName: String,
    constantCoefficient: Double,
    embeddedControlArea: String,
    internalCA: String,
    linearCoefficient: Double,
    localCA: String,
    maxSelfSchedMW: Double,
    minSelfSchedMW: Double,
    quadraticCoefficient: Double,
    AdjacentCASet: String,
    AggregateNode: List[String],
    AreaReserveSpecification: String,
    BidSelfSched: List[String],
    CnodeDistributionFactor: List[String],
    ControlAreaDesignation: List[String],
    ExPostLossResults: List[String],
    Export_EnergyTransactions: List[String],
    From_Flowgate: List[String],
    GeneralClearingResults: List[String],
    HostControlArea: String,
    Import_EnergyTransactions: List[String],
    InadvertentAccount: List[String],
    LossClearingResults: List[String],
    Pnode: List[String],
    RTO: String,
    Receive_DynamicSchedules: List[String],
    RegisteredResource: List[String],
    Send_DynamicSchedules: List[String],
    SideA_TieLines: List[String],
    SideB_TieLines: List[String],
    To_Flowgate: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, null, null, 0.0, null, 0.0, 0.0, 0.0, null, List(), null, List(), List(), List(), List(), List(), List(), List(), null, List(), List(), List(), List(), null, List(), List(), List(), List(), List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = SubControlArea.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SubControlArea.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SubControlArea.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (SubControlArea.fields (position), x))
        emitelem (0, areaShortName)
        emitelem (1, constantCoefficient)
        emitattr (2, embeddedControlArea)
        emitattr (3, internalCA)
        emitelem (4, linearCoefficient)
        emitattr (5, localCA)
        emitelem (6, maxSelfSchedMW)
        emitelem (7, minSelfSchedMW)
        emitelem (8, quadraticCoefficient)
        emitattr (9, AdjacentCASet)
        emitattrs (10, AggregateNode)
        emitattr (11, AreaReserveSpecification)
        emitattrs (12, BidSelfSched)
        emitattrs (13, CnodeDistributionFactor)
        emitattrs (14, ControlAreaDesignation)
        emitattrs (15, ExPostLossResults)
        emitattrs (16, Export_EnergyTransactions)
        emitattrs (17, From_Flowgate)
        emitattrs (18, GeneralClearingResults)
        emitattr (19, HostControlArea)
        emitattrs (20, Import_EnergyTransactions)
        emitattrs (21, InadvertentAccount)
        emitattrs (22, LossClearingResults)
        emitattrs (23, Pnode)
        emitattr (24, RTO)
        emitattrs (25, Receive_DynamicSchedules)
        emitattrs (26, RegisteredResource)
        emitattrs (27, Send_DynamicSchedules)
        emitattrs (28, SideA_TieLines)
        emitattrs (29, SideB_TieLines)
        emitattrs (30, To_Flowgate)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SubControlArea rdf:ID=\"%s\">\n%s\t</cim:SubControlArea>".format (id, export_fields)
    }
}

object SubControlArea
extends
    Parseable[SubControlArea]
{
    override val fields: Array[String] = Array[String] (
        "areaShortName",
        "constantCoefficient",
        "embeddedControlArea",
        "internalCA",
        "linearCoefficient",
        "localCA",
        "maxSelfSchedMW",
        "minSelfSchedMW",
        "quadraticCoefficient",
        "AdjacentCASet",
        "AggregateNode",
        "AreaReserveSpecification",
        "BidSelfSched",
        "CnodeDistributionFactor",
        "ControlAreaDesignation",
        "ExPostLossResults",
        "Export_EnergyTransactions",
        "From_Flowgate",
        "GeneralClearingResults",
        "HostControlArea",
        "Import_EnergyTransactions",
        "InadvertentAccount",
        "LossClearingResults",
        "Pnode",
        "RTO",
        "Receive_DynamicSchedules",
        "RegisteredResource",
        "Send_DynamicSchedules",
        "SideA_TieLines",
        "SideB_TieLines",
        "To_Flowgate"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AdjacentCASet", "AdjacentCASet", "0..1", "0..*"),
        Relationship ("AggregateNode", "AggregateNode", "0..*", "0..*"),
        Relationship ("AreaReserveSpecification", "AreaReserveSpec", "1", "0..*"),
        Relationship ("BidSelfSched", "BidSelfSched", "0..*", "0..1"),
        Relationship ("CnodeDistributionFactor", "CnodeDistributionFactor", "0..*", "0..1"),
        Relationship ("ControlAreaDesignation", "ControlAreaDesignation", "0..*", "0..*"),
        Relationship ("ExPostLossResults", "ExPostLossResults", "0..*", "0..1"),
        Relationship ("Export_EnergyTransactions", "EnergyTransaction", "0..*", "1"),
        Relationship ("From_Flowgate", "Flowgate", "0..*", "0..1"),
        Relationship ("GeneralClearingResults", "GeneralClearingResults", "0..*", "0..1"),
        Relationship ("HostControlArea", "HostControlArea", "1", "0..*"),
        Relationship ("Import_EnergyTransactions", "EnergyTransaction", "0..*", "1"),
        Relationship ("InadvertentAccount", "InadvertentAccount", "0..*", "1"),
        Relationship ("LossClearingResults", "LossClearingResults", "1..*", "0..1"),
        Relationship ("Pnode", "Pnode", "0..*", "0..1"),
        Relationship ("RTO", "RTO", "1", "0..*"),
        Relationship ("Receive_DynamicSchedules", "DynamicSchedule", "0..*", "1"),
        Relationship ("RegisteredResource", "RegisteredResource", "0..*", "0..*"),
        Relationship ("Send_DynamicSchedules", "DynamicSchedule", "0..*", "1"),
        Relationship ("SideA_TieLines", "TieLine", "0..*", "1"),
        Relationship ("SideB_TieLines", "TieLine", "0..*", "1"),
        Relationship ("To_Flowgate", "Flowgate", "0..*", "0..1")
    )
    val areaShortName: Fielder = parse_element (element (cls, fields(0)))
    val constantCoefficient: Fielder = parse_element (element (cls, fields(1)))
    val embeddedControlArea: Fielder = parse_attribute (attribute (cls, fields(2)))
    val internalCA: Fielder = parse_attribute (attribute (cls, fields(3)))
    val linearCoefficient: Fielder = parse_element (element (cls, fields(4)))
    val localCA: Fielder = parse_attribute (attribute (cls, fields(5)))
    val maxSelfSchedMW: Fielder = parse_element (element (cls, fields(6)))
    val minSelfSchedMW: Fielder = parse_element (element (cls, fields(7)))
    val quadraticCoefficient: Fielder = parse_element (element (cls, fields(8)))
    val AdjacentCASet: Fielder = parse_attribute (attribute (cls, fields(9)))
    val AggregateNode: FielderMultiple = parse_attributes (attribute (cls, fields(10)))
    val AreaReserveSpecification: Fielder = parse_attribute (attribute (cls, fields(11)))
    val BidSelfSched: FielderMultiple = parse_attributes (attribute (cls, fields(12)))
    val CnodeDistributionFactor: FielderMultiple = parse_attributes (attribute (cls, fields(13)))
    val ControlAreaDesignation: FielderMultiple = parse_attributes (attribute (cls, fields(14)))
    val ExPostLossResults: FielderMultiple = parse_attributes (attribute (cls, fields(15)))
    val Export_EnergyTransactions: FielderMultiple = parse_attributes (attribute (cls, fields(16)))
    val From_Flowgate: FielderMultiple = parse_attributes (attribute (cls, fields(17)))
    val GeneralClearingResults: FielderMultiple = parse_attributes (attribute (cls, fields(18)))
    val HostControlArea: Fielder = parse_attribute (attribute (cls, fields(19)))
    val Import_EnergyTransactions: FielderMultiple = parse_attributes (attribute (cls, fields(20)))
    val InadvertentAccount: FielderMultiple = parse_attributes (attribute (cls, fields(21)))
    val LossClearingResults: FielderMultiple = parse_attributes (attribute (cls, fields(22)))
    val Pnode: FielderMultiple = parse_attributes (attribute (cls, fields(23)))
    val RTO: Fielder = parse_attribute (attribute (cls, fields(24)))
    val Receive_DynamicSchedules: FielderMultiple = parse_attributes (attribute (cls, fields(25)))
    val RegisteredResource: FielderMultiple = parse_attributes (attribute (cls, fields(26)))
    val Send_DynamicSchedules: FielderMultiple = parse_attributes (attribute (cls, fields(27)))
    val SideA_TieLines: FielderMultiple = parse_attributes (attribute (cls, fields(28)))
    val SideB_TieLines: FielderMultiple = parse_attributes (attribute (cls, fields(29)))
    val To_Flowgate: FielderMultiple = parse_attributes (attribute (cls, fields(30)))

    def parse (context: Context): SubControlArea =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = SubControlArea (
            PowerSystemResource.parse (context),
            mask (areaShortName (), 0),
            toDouble (mask (constantCoefficient (), 1)),
            mask (embeddedControlArea (), 2),
            mask (internalCA (), 3),
            toDouble (mask (linearCoefficient (), 4)),
            mask (localCA (), 5),
            toDouble (mask (maxSelfSchedMW (), 6)),
            toDouble (mask (minSelfSchedMW (), 7)),
            toDouble (mask (quadraticCoefficient (), 8)),
            mask (AdjacentCASet (), 9),
            masks (AggregateNode (), 10),
            mask (AreaReserveSpecification (), 11),
            masks (BidSelfSched (), 12),
            masks (CnodeDistributionFactor (), 13),
            masks (ControlAreaDesignation (), 14),
            masks (ExPostLossResults (), 15),
            masks (Export_EnergyTransactions (), 16),
            masks (From_Flowgate (), 17),
            masks (GeneralClearingResults (), 18),
            mask (HostControlArea (), 19),
            masks (Import_EnergyTransactions (), 20),
            masks (InadvertentAccount (), 21),
            masks (LossClearingResults (), 22),
            masks (Pnode (), 23),
            mask (RTO (), 24),
            masks (Receive_DynamicSchedules (), 25),
            masks (RegisteredResource (), 26),
            masks (Send_DynamicSchedules (), 27),
            masks (SideA_TieLines (), 28),
            masks (SideB_TieLines (), 29),
            masks (To_Flowgate (), 30)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * List of resources that can be substituted for within the bounds of a Contract definition.
 *
 * This class has a precedence and a resource.
 *
 * @param sup Reference to the superclass object.
 * @param precedence An indicator of the order a resource should be substituted.
 *        The lower the number the higher the precedence.
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @param TransmissionContractRight [[ch.ninecode.model.ContractRight ContractRight]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
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
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = SubstitutionResourceList.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SubstitutionResourceList.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SubstitutionResourceList.fields (position), value)
        emitelem (0, precedence)
        emitattr (1, RegisteredResource)
        emitattr (2, TransmissionContractRight)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SubstitutionResourceList rdf:ID=\"%s\">\n%s\t</cim:SubstitutionResourceList>".format (id, export_fields)
    }
}

object SubstitutionResourceList
extends
    Parseable[SubstitutionResourceList]
{
    override val fields: Array[String] = Array[String] (
        "precedence",
        "RegisteredResource",
        "TransmissionContractRight"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RegisteredResource", "RegisteredResource", "0..1", "0..*"),
        Relationship ("TransmissionContractRight", "ContractRight", "0..1", "0..*")
    )
    val precedence: Fielder = parse_element (element (cls, fields(0)))
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields(1)))
    val TransmissionContractRight: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): SubstitutionResourceList =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = SubstitutionResourceList (
            BasicElement.parse (context),
            toInteger (mask (precedence (), 0)),
            mask (RegisteredResource (), 1),
            mask (TransmissionContractRight (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Transmission Access Charge Area.
 *
 * Charges assessed, on behalf of the Participating Transmission Owner, to parties who require access to the controlled grid.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param AggregatedPnode [[ch.ninecode.model.AggregatedPnode AggregatedPnode]] <em>undocumented</em>
 * @param AreaLoadCurve [[ch.ninecode.model.AreaLoadCurve AreaLoadCurve]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class TACArea
(
    override val sup: IdentifiedObject,
    AggregatedPnode: List[String],
    AreaLoadCurve: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TACArea.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (TACArea.fields (position), x))
        emitattrs (0, AggregatedPnode)
        emitattrs (1, AreaLoadCurve)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TACArea rdf:ID=\"%s\">\n%s\t</cim:TACArea>".format (id, export_fields)
    }
}

object TACArea
extends
    Parseable[TACArea]
{
    override val fields: Array[String] = Array[String] (
        "AggregatedPnode",
        "AreaLoadCurve"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AggregatedPnode", "AggregatedPnode", "0..*", "0..*"),
        Relationship ("AreaLoadCurve", "AreaLoadCurve", "0..*", "0..1")
    )
    val AggregatedPnode: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val AreaLoadCurve: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): TACArea =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = TACArea (
            IdentifiedObject.parse (context),
            masks (AggregatedPnode (), 0),
            masks (AreaLoadCurve (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Allows chaining of TransmissionContractRights.
 *
 * Many individual contract rights can be included in the definition of a TransmissionRightChain. A TransmissionRightChain is also defined as a TransmissionContractRight itself.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param Chain_ContractRight [[ch.ninecode.model.ContractRight ContractRight]] <em>undocumented</em>
 * @param Ind_ContractRight [[ch.ninecode.model.ContractRight ContractRight]] <em>undocumented</em>
 * @param RTO [[ch.ninecode.model.RTO RTO]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class TransmissionRightChain
(
    override val sup: IdentifiedObject,
    Chain_ContractRight: String,
    Ind_ContractRight: List[String],
    RTO: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, List(), null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TransmissionRightChain.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TransmissionRightChain.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (TransmissionRightChain.fields (position), x))
        emitattr (0, Chain_ContractRight)
        emitattrs (1, Ind_ContractRight)
        emitattr (2, RTO)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TransmissionRightChain rdf:ID=\"%s\">\n%s\t</cim:TransmissionRightChain>".format (id, export_fields)
    }
}

object TransmissionRightChain
extends
    Parseable[TransmissionRightChain]
{
    override val fields: Array[String] = Array[String] (
        "Chain_ContractRight",
        "Ind_ContractRight",
        "RTO"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Chain_ContractRight", "ContractRight", "1", "0..1"),
        Relationship ("Ind_ContractRight", "ContractRight", "1..*", "0..1"),
        Relationship ("RTO", "RTO", "1", "0..*")
    )
    val Chain_ContractRight: Fielder = parse_attribute (attribute (cls, fields(0)))
    val Ind_ContractRight: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val RTO: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): TransmissionRightChain =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = TransmissionRightChain (
            IdentifiedObject.parse (context),
            mask (Chain_ContractRight (), 0),
            masks (Ind_ContractRight (), 1),
            mask (RTO (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Counter party in a wheeling transaction.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param RegisteredInterTie [[ch.ninecode.model.RegisteredInterTie RegisteredInterTie]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class WheelingCounterParty
(
    override val sup: IdentifiedObject,
    RegisteredInterTie: List[String]
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = WheelingCounterParty.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (WheelingCounterParty.fields (position), x))
        emitattrs (0, RegisteredInterTie)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WheelingCounterParty rdf:ID=\"%s\">\n%s\t</cim:WheelingCounterParty>".format (id, export_fields)
    }
}

object WheelingCounterParty
extends
    Parseable[WheelingCounterParty]
{
    override val fields: Array[String] = Array[String] (
        "RegisteredInterTie"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RegisteredInterTie", "RegisteredInterTie", "0..*", "0..*")
    )
    val RegisteredInterTie: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): WheelingCounterParty =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = WheelingCounterParty (
            IdentifiedObject.parse (context),
            masks (RegisteredInterTie (), 0)
        )
        ret.bitfields = bitfields
        ret
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
            RegisteredDistributedResource.register,
            RegisteredGenerator.register,
            RegisteredInterTie.register,
            RegisteredLoad.register,
            RegulatingLimit.register,
            ResourceCertification.register,
            ResourceOperationMaintenanceCost.register,
            ResourceStartupCost.register,
            ResourceVerifiableCosts.register,
            ResponseMethod.register,
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