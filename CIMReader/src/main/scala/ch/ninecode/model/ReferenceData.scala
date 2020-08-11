package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Goups Adjacent Control Areas
 *
 * @param sup                [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param endEffectiveDate   end effective date
 * @param lossPercentage     Loss percentage
 * @param startEffectiveDate start effective date
 * @param BidSelfSched       [[ch.ninecode.model.BidSelfSched BidSelfSched]] <em>undocumented</em>
 * @param HostControlArea    [[ch.ninecode.model.HostControlArea HostControlArea]] <em>undocumented</em>
 * @param RTO                [[ch.ninecode.model.RTO RTO]] <em>undocumented</em>
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @param SubControlArea     [[ch.ninecode.model.SubControlArea SubControlArea]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class AdjacentCASet
(
    override val sup: IdentifiedObject,
    endEffectiveDate: String,
    lossPercentage_1: Double,
    startEffectiveDate: String,
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
    def this () =
    {
        this (null, null, 0.0, null, List (), null, null, List (), List ())
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
        clone ().asInstanceOf [AdjacentCASet]
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
        implicit val clz: String = AdjacentCASet.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AdjacentCASet.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AdjacentCASet.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (AdjacentCASet.fields (position), x))

        emitelem (0, endEffectiveDate)
        emitelem (1, lossPercentage_1)
        emitelem (2, startEffectiveDate)
        emitattrs (3, BidSelfSched)
        emitattr (4, HostControlArea)
        emitattr (5, RTO)
        emitattrs (6, RegisteredResource)
        emitattrs (7, SubControlArea)
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
    override val fields: Array[String] = Array [String](
        "endEffectiveDate",
        "lossPercentage ",
        "startEffectiveDate",
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
    val endEffectiveDate: Fielder = parse_element (element (cls, fields (0)))
    val lossPercentage_1: Fielder = parse_element (element (cls, fields (1)))
    val startEffectiveDate: Fielder = parse_element (element (cls, fields (2)))
    val BidSelfSched: FielderMultiple = parse_attributes (attribute (cls, fields (3)))
    val HostControlArea: Fielder = parse_attribute (attribute (cls, fields (4)))
    val RTO: Fielder = parse_attribute (attribute (cls, fields (5)))
    val RegisteredResource: FielderMultiple = parse_attributes (attribute (cls, fields (6)))
    val SubControlArea: FielderMultiple = parse_attributes (attribute (cls, fields (7)))

    def parse (context: Context): AdjacentCASet =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = AdjacentCASet (
            IdentifiedObject.parse (context),
            mask (endEffectiveDate (), 0),
            toDouble (mask (lossPercentage_1 (), 1)),
            mask (startEffectiveDate (), 2),
            masks (BidSelfSched (), 3),
            mask (HostControlArea (), 4),
            mask (RTO (), 5),
            masks (RegisteredResource (), 6),
            masks (SubControlArea (), 7)
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
 * @param sup                     [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param anodeType               Type of aggregated node
 * @param endEffectiveDate        end effective date
 * @param qualifASOrder           Processing Order for AS self-provisions for this region.
 *                                The priority of this attribute directs the awards of any resource that resides in overlapping regions. The regions are processed in priority manner.
 * @param startEffectiveDate      start effective date
 * @param AreaLoadCurve           [[ch.ninecode.model.AreaLoadCurve AreaLoadCurve]] <em>undocumented</em>
 * @param CnodeDistributionFactor [[ch.ninecode.model.CnodeDistributionFactor CnodeDistributionFactor]] <em>undocumented</em>
 * @param Pnode                   [[ch.ninecode.model.Pnode Pnode]] <em>undocumented</em>
 * @param RTO                     [[ch.ninecode.model.RTO RTO]] <em>undocumented</em>
 * @param RegisteredResource      [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @param SubControlArea          [[ch.ninecode.model.SubControlArea SubControlArea]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class AggregateNode
(
    override val sup: IdentifiedObject,
    anodeType: String,
    endEffectiveDate: String,
    qualifASOrder: Int,
    startEffectiveDate: String,
    AreaLoadCurve: List[String],
    CnodeDistributionFactor: List[String],
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
    def this () =
    {
        this (null, null, null, 0, null, List (), List (), List (), null, List (), List ())
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
        clone ().asInstanceOf [AggregateNode]
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
        implicit val clz: String = AggregateNode.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AggregateNode.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AggregateNode.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (AggregateNode.fields (position), x))

        emitattr (0, anodeType)
        emitelem (1, endEffectiveDate)
        emitelem (2, qualifASOrder)
        emitelem (3, startEffectiveDate)
        emitattrs (4, AreaLoadCurve)
        emitattrs (5, CnodeDistributionFactor)
        emitattrs (6, Pnode)
        emitattr (7, RTO)
        emitattrs (8, RegisteredResource)
        emitattrs (9, SubControlArea)
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
    override val fields: Array[String] = Array [String](
        "anodeType",
        "endEffectiveDate",
        "qualifASOrder",
        "startEffectiveDate",
        "AreaLoadCurve",
        "CnodeDistributionFactor",
        "Pnode",
        "RTO",
        "RegisteredResource",
        "SubControlArea"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AreaLoadCurve", "AreaLoadCurve", "0..*", "0..1"),
        Relationship ("CnodeDistributionFactor", "CnodeDistributionFactor", "0..*", "0..1"),
        Relationship ("Pnode", "Pnode", "0..*", "0..*"),
        Relationship ("RTO", "RTO", "1", "0..*"),
        Relationship ("RegisteredResource", "RegisteredResource", "0..*", "0..*"),
        Relationship ("SubControlArea", "SubControlArea", "0..*", "0..*")
    )
    val anodeType: Fielder = parse_attribute (attribute (cls, fields (0)))
    val endEffectiveDate: Fielder = parse_element (element (cls, fields (1)))
    val qualifASOrder: Fielder = parse_element (element (cls, fields (2)))
    val startEffectiveDate: Fielder = parse_element (element (cls, fields (3)))
    val AreaLoadCurve: FielderMultiple = parse_attributes (attribute (cls, fields (4)))
    val CnodeDistributionFactor: FielderMultiple = parse_attributes (attribute (cls, fields (5)))
    val Pnode: FielderMultiple = parse_attributes (attribute (cls, fields (6)))
    val RTO: Fielder = parse_attribute (attribute (cls, fields (7)))
    val RegisteredResource: FielderMultiple = parse_attributes (attribute (cls, fields (8)))
    val SubControlArea: FielderMultiple = parse_attributes (attribute (cls, fields (9)))

    def parse (context: Context): AggregateNode =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = AggregateNode (
            IdentifiedObject.parse (context),
            mask (anodeType (), 0),
            mask (endEffectiveDate (), 1),
            toInteger (mask (qualifASOrder (), 2)),
            mask (startEffectiveDate (), 3),
            masks (AreaLoadCurve (), 4),
            masks (CnodeDistributionFactor (), 5),
            masks (Pnode (), 6),
            mask (RTO (), 7),
            masks (RegisteredResource (), 8),
            masks (SubControlArea (), 9)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * An aggregated pricing node is a specialized type of pricing node used to model items such as System Zone, Default Price Zone, Custom Price Zone, Control Area, Aggregated Generation, Aggregated Particpating Load, Aggregated Non-Participating Load, Trading Hub, Designated Control Area(DCA) Zone
 *
 * @param sup                     [[ch.ninecode.model.Pnode Pnode]] Reference to the superclass object.
 * @param apnodeType              Aggregate Price Node Types
 * @param participationCategory   Designated Control Area participation in LMP price measurement
 *
 *                                'Y' - Participates in both Local Market Power Mitigation (LMPM) and System Market Power Mitigation (SMPM)
 *                                'N' - Not included in LMP price measures
 *                                'S' - Participatesin SMPM price measures
 *                                'L' - Participatesin LMPM price measures
 * @param GenDistributionFactor   [[ch.ninecode.model.GenDistributionFactor GenDistributionFactor]] <em>undocumented</em>
 * @param LoadDistributionFactor  [[ch.ninecode.model.LoadDistributionFactor LoadDistributionFactor]] <em>undocumented</em>
 * @param MPMTestResults          [[ch.ninecode.model.MPMTestResults MPMTestResults]] <em>undocumented</em>
 * @param MPMTestThreshold        [[ch.ninecode.model.MPMTestThreshold MPMTestThreshold]] <em>undocumented</em>
 * @param MktCombinedCyclePlant   [[ch.ninecode.model.MktCombinedCyclePlant MktCombinedCyclePlant]] <em>undocumented</em>
 * @param PnodeDistributionFactor [[ch.ninecode.model.PnodeDistributionFactor PnodeDistributionFactor]] <em>undocumented</em>
 * @param TACArea                 [[ch.ninecode.model.TACArea TACArea]] <em>undocumented</em>
 * @param TradingHubValues        [[ch.ninecode.model.TradingHubValues TradingHubValues]] <em>undocumented</em>
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
    PnodeDistributionFactor: String,
    TACArea: List[String],
    TradingHubValues: List[String]
)
    extends
        Element
{
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, null, null, List (), List (), List (), List (), List (), null, List (), List ())
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Pnode: Pnode = sup.asInstanceOf [Pnode]

    override def copy (): Row =
    {
        clone ().asInstanceOf [AggregatedPnode]
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
        emitattr (7, PnodeDistributionFactor)
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
    override val fields: Array[String] = Array [String](
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
        Relationship ("PnodeDistributionFactor", "PnodeDistributionFactor", "1", "0..*"),
        Relationship ("TACArea", "TACArea", "0..*", "0..*"),
        Relationship ("TradingHubValues", "TradingHubValues", "0..*", "1")
    )
    val apnodeType: Fielder = parse_attribute (attribute (cls, fields (0)))
    val participationCategory: Fielder = parse_attribute (attribute (cls, fields (1)))
    val GenDistributionFactor: FielderMultiple = parse_attributes (attribute (cls, fields (2)))
    val LoadDistributionFactor: FielderMultiple = parse_attributes (attribute (cls, fields (3)))
    val MPMTestResults: FielderMultiple = parse_attributes (attribute (cls, fields (4)))
    val MPMTestThreshold: FielderMultiple = parse_attributes (attribute (cls, fields (5)))
    val MktCombinedCyclePlant: FielderMultiple = parse_attributes (attribute (cls, fields (6)))
    val PnodeDistributionFactor: Fielder = parse_attribute (attribute (cls, fields (7)))
    val TACArea: FielderMultiple = parse_attributes (attribute (cls, fields (8)))
    val TradingHubValues: FielderMultiple = parse_attributes (attribute (cls, fields (9)))

    def parse (context: Context): AggregatedPnode =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = AggregatedPnode (
            Pnode.parse (context),
            mask (apnodeType (), 0),
            mask (participationCategory (), 1),
            masks (GenDistributionFactor (), 2),
            masks (LoadDistributionFactor (), 3),
            masks (MPMTestResults (), 4),
            masks (MPMTestThreshold (), 5),
            masks (MktCombinedCyclePlant (), 6),
            mask (PnodeDistributionFactor (), 7),
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
 * @param sup           Reference to the superclass object.
 * @param bidCeiling    Bid Ceiling (\$/MWH)
 * @param bidCeilingAS  Bid Ceiling (\$/MWH) for generic AS versus a specific market product
 * @param bidFloor      Bid Floor, (\$/MWH)
 * @param bidFloorAS    Bid Floor (\$/MWH) for generic AS versus a specific market product
 * @param defaultPrice  Bid Default Price(\$/MWH)
 * @param marketType    Market Type of the cap (DAM or RTM)
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
    def this () =
    {
        this (null, 0.0, 0.0, 0.0, 0.0, 0.0, null, null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Element: Element = sup.asInstanceOf [Element]

    override def copy (): Row =
    {
        clone ().asInstanceOf [BidPriceCap]
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
    override val fields: Array[String] = Array [String](
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
    val bidCeiling: Fielder = parse_element (element (cls, fields (0)))
    val bidCeilingAS: Fielder = parse_element (element (cls, fields (1)))
    val bidFloor: Fielder = parse_element (element (cls, fields (2)))
    val bidFloorAS: Fielder = parse_element (element (cls, fields (3)))
    val defaultPrice: Fielder = parse_element (element (cls, fields (4)))
    val marketType: Fielder = parse_attribute (attribute (cls, fields (5)))
    val MarketProduct: Fielder = parse_attribute (attribute (cls, fields (6)))

    def parse (context: Context): BidPriceCap =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
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
 * @param sup                 [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param factor              Used to calculate "participation" of Cnode in an AggregateNode
 * @param podLossFactor       Point of delivery loss factor
 * @param AggregateNode       [[ch.ninecode.model.AggregateNode AggregateNode]] <em>undocumented</em>
 * @param HostControlArea     [[ch.ninecode.model.HostControlArea HostControlArea]] <em>undocumented</em>
 * @param MktConnectivityNode [[ch.ninecode.model.MktConnectivityNode MktConnectivityNode]] <em>undocumented</em>
 * @param SubControlArea      [[ch.ninecode.model.SubControlArea SubControlArea]] <em>undocumented</em>
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
    def this () =
    {
        this (null, 0.0, 0.0, null, null, null, null)
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
        clone ().asInstanceOf [CnodeDistributionFactor]
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
    override val fields: Array[String] = Array [String](
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
    val factor: Fielder = parse_element (element (cls, fields (0)))
    val podLossFactor: Fielder = parse_element (element (cls, fields (1)))
    val AggregateNode: Fielder = parse_attribute (attribute (cls, fields (2)))
    val HostControlArea: Fielder = parse_attribute (attribute (cls, fields (3)))
    val MktConnectivityNode: Fielder = parse_attribute (attribute (cls, fields (4)))
    val SubControlArea: Fielder = parse_attribute (attribute (cls, fields (5)))

    def parse (context: Context): CnodeDistributionFactor =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
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
 * @param sup                               [[ch.ninecode.model.RegisteredGenerator RegisteredGenerator]] Reference to the superclass object.
 * @param primaryConfiguration              Whether this CombinedCycleConfiguration is the primary configuration in the associated Logical configuration?
 * @param CombinedCycleConfigurationMember  [[ch.ninecode.model.CombinedCycleConfigurationMember CombinedCycleConfigurationMember]] <em>undocumented</em>
 * @param CombinedCycleLogicalConfiguration [[ch.ninecode.model.CombinedCycleLogicalConfiguration CombinedCycleLogicalConfiguration]] <em>undocumented</em>
 * @param FromTransitionState               [[ch.ninecode.model.CombinedCycleTransitionState CombinedCycleTransitionState]] <em>undocumented</em>
 * @param ShutdownFlag                      Whether Combined Cycle Plant can be shut-down in this Configuration?
 * @param StartupFlag                       Whether Combined Cycle Plant can be started in this Logical Configuration?
 * @param ToTransitionState                 [[ch.ninecode.model.CombinedCycleTransitionState CombinedCycleTransitionState]] <em>undocumented</em>
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
    def this () =
    {
        this (null, false, List (), null, List (), false, false, List ())
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def RegisteredGenerator: RegisteredGenerator = sup.asInstanceOf [RegisteredGenerator]

    override def copy (): Row =
    {
        clone ().asInstanceOf [CombinedCycleConfiguration]
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
    override val fields: Array[String] = Array [String](
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
    val primaryConfiguration: Fielder = parse_element (element (cls, fields (0)))
    val CombinedCycleConfigurationMember: FielderMultiple = parse_attributes (attribute (cls, fields (1)))
    val CombinedCycleLogicalConfiguration: Fielder = parse_attribute (attribute (cls, fields (2)))
    val FromTransitionState: FielderMultiple = parse_attributes (attribute (cls, fields (3)))
    val ShutdownFlag: Fielder = parse_element (element (cls, fields (4)))
    val StartupFlag: Fielder = parse_element (element (cls, fields (5)))
    val ToTransitionState: FielderMultiple = parse_attributes (attribute (cls, fields (6)))

    def parse (context: Context): CombinedCycleConfiguration =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
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
 * @param sup                        [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param primary                    primary configuration.
 * @param steam                      Steam plant.
 * @param CombinedCycleConfiguration [[ch.ninecode.model.CombinedCycleConfiguration CombinedCycleConfiguration]] <em>undocumented</em>
 * @param MktThermalGeneratingUnit   [[ch.ninecode.model.MktThermalGeneratingUnit MktThermalGeneratingUnit]] <em>undocumented</em>
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
    def this () =
    {
        this (null, false, false, null, null)
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
        clone ().asInstanceOf [CombinedCycleConfigurationMember]
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
    override val fields: Array[String] = Array [String](
        "primary",
        "steam",
        "CombinedCycleConfiguration",
        "MktThermalGeneratingUnit"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CombinedCycleConfiguration", "CombinedCycleConfiguration", "1", "0..*"),
        Relationship ("MktThermalGeneratingUnit", "MktThermalGeneratingUnit", "1", "0..*")
    )
    val primary: Fielder = parse_element (element (cls, fields (0)))
    val steam: Fielder = parse_element (element (cls, fields (1)))
    val CombinedCycleConfiguration: Fielder = parse_attribute (attribute (cls, fields (2)))
    val MktThermalGeneratingUnit: Fielder = parse_attribute (attribute (cls, fields (3)))

    def parse (context: Context): CombinedCycleConfigurationMember =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
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
 * @param sup                        [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param CombinedCycleConfiguration [[ch.ninecode.model.CombinedCycleConfiguration CombinedCycleConfiguration]] <em>undocumented</em>
 * @param MktCombinedCyclePlant      [[ch.ninecode.model.MktCombinedCyclePlant MktCombinedCyclePlant]] <em>undocumented</em>
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
    def this () =
    {
        this (null, List (), null)
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
        clone ().asInstanceOf [CombinedCycleLogicalConfiguration]
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
    override val fields: Array[String] = Array [String](
        "CombinedCycleConfiguration",
        "MktCombinedCyclePlant"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CombinedCycleConfiguration", "CombinedCycleConfiguration", "1..*", "0..1"),
        Relationship ("MktCombinedCyclePlant", "MktCombinedCyclePlant", "0..1", "1..*")
    )
    val CombinedCycleConfiguration: FielderMultiple = parse_attributes (attribute (cls, fields (0)))
    val MktCombinedCyclePlant: Fielder = parse_attribute (attribute (cls, fields (1)))

    def parse (context: Context): CombinedCycleLogicalConfiguration =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
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
 * @param sup               Reference to the superclass object.
 * @param upTransition      Flag indicating whether this is an UP transition.
 *                          If not, it is a DOWN transition.
 * @param FromConfiguration [[ch.ninecode.model.CombinedCycleConfiguration CombinedCycleConfiguration]] <em>undocumented</em>
 * @param ToConfiguration   [[ch.ninecode.model.CombinedCycleConfiguration CombinedCycleConfiguration]] <em>undocumented</em>
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
    def this () =
    {
        this (null, false, null, null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Element: Element = sup.asInstanceOf [Element]

    override def copy (): Row =
    {
        clone ().asInstanceOf [CombinedCycleTransitionState]
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
    override val fields: Array[String] = Array [String](
        "upTransition",
        "FromConfiguration",
        "ToConfiguration"
    )
    override val relations: List[Relationship] = List (
        Relationship ("FromConfiguration", "CombinedCycleConfiguration", "1", "0..*"),
        Relationship ("ToConfiguration", "CombinedCycleConfiguration", "1", "0..*")
    )
    val upTransition: Fielder = parse_element (element (cls, fields (0)))
    val FromConfiguration: Fielder = parse_attribute (attribute (cls, fields (1)))
    val ToConfiguration: Fielder = parse_attribute (attribute (cls, fields (2)))

    def parse (context: Context): CombinedCycleTransitionState =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
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
 * Designated Congestion Area Definition (DCA)
 *
 * @param sup             [[ch.ninecode.model.AggregatedPnode AggregatedPnode]] Reference to the superclass object.
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
    def this () =
    {
        this (null, List ())
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def AggregatedPnode: AggregatedPnode = sup.asInstanceOf [AggregatedPnode]

    override def copy (): Row =
    {
        clone ().asInstanceOf [CongestionArea]
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
    override val fields: Array[String] = Array [String](
        "IndividualPnode"
    )
    override val relations: List[Relationship] = List (
        Relationship ("IndividualPnode", "IndividualPnode", "0..*", "0..*")
    )
    val IndividualPnode: FielderMultiple = parse_attributes (attribute (cls, fields (0)))

    def parse (context: Context): CongestionArea =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = CongestionArea (
            AggregatedPnode.parse (context),
            masks (IndividualPnode (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Distribution amoung resources at the sink point or source point
 *
 * @param sup                       Reference to the superclass object.
 * @param factor                    MW value that this resource provides to the overall contract.
 * @param sinkFlag                  This value will be set to YES if the referenced Cnode is defined as the sink point in the contract.
 * @param sourceFlag                This value will be set to YES if the referenced Cnode is defined as the source point in the contract.
 * @param Flowgate                  [[ch.ninecode.model.Flowgate Flowgate]] <em>undocumented</em>
 * @param RegisteredResource        [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
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
    def this () =
    {
        this (null, 0.0, null, null, null, null, null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Element: Element = sup.asInstanceOf [Element]

    override def copy (): Row =
    {
        clone ().asInstanceOf [ContractDistributionFactor]
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
    override val fields: Array[String] = Array [String](
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
    val factor: Fielder = parse_element (element (cls, fields (0)))
    val sinkFlag: Fielder = parse_attribute (attribute (cls, fields (1)))
    val sourceFlag: Fielder = parse_attribute (attribute (cls, fields (2)))
    val Flowgate: Fielder = parse_attribute (attribute (cls, fields (3)))
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields (4)))
    val TransmissionContractRight: Fielder = parse_attribute (attribute (cls, fields (5)))

    def parse (context: Context): ContractDistributionFactor =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
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
 * RMR contract hosting: Startup lead time, Contract Service Limits, Max Service Hours, Max MWhs, Max Start-ups, Ramp Rate, Max Net Dependable Capacity, Min Capacity and Unit Substitution for DAM/RTM to retrieve;
 *
 * @param sup                              [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param chainOrder                       When used in conjunction with a Transmission Right contract chain, this is the precedence for the contracts.
 * @param contractMW                       MW value of the contract
 * @param contractPrice                    Financial value of the contract
 * @param contractPriority                 Priority for the contract.
 *                                         This should be unique amoung all contracts for a specific resource. This value is the directive for the SCUC algorithm on the order to satisfy/cut contracts.
 * @param contractStatus                   Contract status
 * @param contractType                     type of the contract.
 *                                         Possible values are but not limited by:
 * @param endEffectiveDate                 end effective date
 * @param financialLocation                Indicator if the location associated with this contract is financial (e.g. pricing nodes) or physical (e.g. connectivity nodes).
 * @param financialRightsDAM               Flag to indicate this contract provides financial rights in the DA Market
 * @param financialRightsRTM               Flag to indicate this contract provides financial rights in the RT Market
 * @param fuelAdder                        Estimated Fuel Adder
 * @param latestSchedMinutes               This indicates the latest schedule minutes (e.g. t - xx) that this resource can be notified to respond.
 *                                         This attribute is only used if the market type is not supplied.
 * @param latestSchedMktType               This indicates the latest schedule market type a contract can be applied to.
 *                                         This is used in conjunction with the latestSchedMinutes attribute to determine the latest time this contract can be called in. The possible values for this attribute are: DAM, RTM or it can be omitted. If omitted, the latestSchedMinutes attribute defines the value.
 * @param maxNetDependableCapacity         Maximum Net Dependable Capacity
 * @param maximumScheduleQuantity          Maximum schedule MW quantity
 * @param maximumServiceHours              Maximum service hours
 * @param maximumStartups                  Maximum startups
 * @param minimumLoad                      Minimum Load
 * @param minimumScheduleQuantity          Minimum schedule quanity
 * @param physicalRightsDAM                Flag to indicate this contract provides physical rights in the DA Market
 * @param physicalRightsRTM                Flag to indicate this contract provides physical rights in the RT Market
 * @param startEffectiveDate               start effective date
 * @param startupLeadTime                  Start up lead time
 * @param BidSelfSched                     [[ch.ninecode.model.BidSelfSched BidSelfSched]] <em>undocumented</em>
 * @param Chain_TransmissionRightChain     [[ch.ninecode.model.TransmissionRightChain TransmissionRightChain]] <em>undocumented</em>
 * @param ContractDistributionFactor       [[ch.ninecode.model.ContractDistributionFactor ContractDistributionFactor]] <em>undocumented</em>
 * @param Ind_TransmissionRightChain       [[ch.ninecode.model.TransmissionRightChain TransmissionRightChain]] <em>undocumented</em>
 * @param RTO                              [[ch.ninecode.model.RTO RTO]] <em>undocumented</em>
 * @param SchedulingCoordinator            [[ch.ninecode.model.SchedulingCoordinator SchedulingCoordinator]] <em>undocumented</em>
 * @param SubstitutionResourceList         [[ch.ninecode.model.SubstitutionResourceList SubstitutionResourceList]] <em>undocumented</em>
 * @param TREntitlement                    [[ch.ninecode.model.TREntitlement TREntitlement]] <em>undocumented</em>
 * @param TRType                           Transmission Right type - is this an individual contract right or a chain contract right.
 *                                         Types = CHAIN or INDIVIDUAL
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
    def this () =
    {
        this (null, 0, 0.0, 0.0, 0, null, null, null, null, null, null, 0.0, 0, null, 0.0, 0.0, 0, 0, 0.0, 0.0, null, null, null, 0, List (), null, List (), null, null, null, List (), List (), null, List ())
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
        clone ().asInstanceOf [ContractRight]
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
        emitelem (6, endEffectiveDate)
        emitattr (7, financialLocation)
        emitattr (8, financialRightsDAM)
        emitattr (9, financialRightsRTM)
        emitelem (10, fuelAdder)
        emitelem (11, latestSchedMinutes)
        emitattr (12, latestSchedMktType)
        emitelem (13, maxNetDependableCapacity)
        emitelem (14, maximumScheduleQuantity)
        emitelem (15, maximumServiceHours)
        emitelem (16, maximumStartups)
        emitelem (17, minimumLoad)
        emitelem (18, minimumScheduleQuantity)
        emitattr (19, physicalRightsDAM)
        emitattr (20, physicalRightsRTM)
        emitelem (21, startEffectiveDate)
        emitelem (22, startupLeadTime)
        emitattrs (23, BidSelfSched)
        emitattr (24, Chain_TransmissionRightChain)
        emitattrs (25, ContractDistributionFactor)
        emitattr (26, Ind_TransmissionRightChain)
        emitattr (27, RTO)
        emitattr (28, SchedulingCoordinator)
        emitattrs (29, SubstitutionResourceList)
        emitattrs (30, TREntitlement)
        emitattr (31, TRType)
        emitattrs (32, TransmissionInterfaceEntitlement)
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
    override val fields: Array[String] = Array [String](
        "chainOrder",
        "contractMW",
        "contractPrice",
        "contractPriority",
        "contractStatus",
        "contractType",
        "endEffectiveDate",
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
        "startEffectiveDate",
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
    val chainOrder: Fielder = parse_element (element (cls, fields (0)))
    val contractMW: Fielder = parse_element (element (cls, fields (1)))
    val contractPrice: Fielder = parse_element (element (cls, fields (2)))
    val contractPriority: Fielder = parse_element (element (cls, fields (3)))
    val contractStatus: Fielder = parse_element (element (cls, fields (4)))
    val contractType: Fielder = parse_attribute (attribute (cls, fields (5)))
    val endEffectiveDate: Fielder = parse_element (element (cls, fields (6)))
    val financialLocation: Fielder = parse_attribute (attribute (cls, fields (7)))
    val financialRightsDAM: Fielder = parse_attribute (attribute (cls, fields (8)))
    val financialRightsRTM: Fielder = parse_attribute (attribute (cls, fields (9)))
    val fuelAdder: Fielder = parse_element (element (cls, fields (10)))
    val latestSchedMinutes: Fielder = parse_element (element (cls, fields (11)))
    val latestSchedMktType: Fielder = parse_attribute (attribute (cls, fields (12)))
    val maxNetDependableCapacity: Fielder = parse_element (element (cls, fields (13)))
    val maximumScheduleQuantity: Fielder = parse_element (element (cls, fields (14)))
    val maximumServiceHours: Fielder = parse_element (element (cls, fields (15)))
    val maximumStartups: Fielder = parse_element (element (cls, fields (16)))
    val minimumLoad: Fielder = parse_element (element (cls, fields (17)))
    val minimumScheduleQuantity: Fielder = parse_element (element (cls, fields (18)))
    val physicalRightsDAM: Fielder = parse_attribute (attribute (cls, fields (19)))
    val physicalRightsRTM: Fielder = parse_attribute (attribute (cls, fields (20)))
    val startEffectiveDate: Fielder = parse_element (element (cls, fields (21)))
    val startupLeadTime: Fielder = parse_element (element (cls, fields (22)))
    val BidSelfSched: FielderMultiple = parse_attributes (attribute (cls, fields (23)))
    val Chain_TransmissionRightChain: Fielder = parse_attribute (attribute (cls, fields (24)))
    val ContractDistributionFactor: FielderMultiple = parse_attributes (attribute (cls, fields (25)))
    val Ind_TransmissionRightChain: Fielder = parse_attribute (attribute (cls, fields (26)))
    val RTO: Fielder = parse_attribute (attribute (cls, fields (27)))
    val SchedulingCoordinator: Fielder = parse_attribute (attribute (cls, fields (28)))
    val SubstitutionResourceList: FielderMultiple = parse_attributes (attribute (cls, fields (29)))
    val TREntitlement: FielderMultiple = parse_attributes (attribute (cls, fields (30)))
    val TRType: Fielder = parse_attribute (attribute (cls, fields (31)))
    val TransmissionInterfaceEntitlement: FielderMultiple = parse_attributes (attribute (cls, fields (32)))

    def parse (context: Context): ContractRight =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0, 0)
        val ret = ContractRight (
            IdentifiedObject.parse (context),
            toInteger (mask (chainOrder (), 0)),
            toDouble (mask (contractMW (), 1)),
            toDouble (mask (contractPrice (), 2)),
            toInteger (mask (contractPriority (), 3)),
            mask (contractStatus (), 4),
            mask (contractType (), 5),
            mask (endEffectiveDate (), 6),
            mask (financialLocation (), 7),
            mask (financialRightsDAM (), 8),
            mask (financialRightsRTM (), 9),
            toDouble (mask (fuelAdder (), 10)),
            toInteger (mask (latestSchedMinutes (), 11)),
            mask (latestSchedMktType (), 12),
            toDouble (mask (maxNetDependableCapacity (), 13)),
            toDouble (mask (maximumScheduleQuantity (), 14)),
            toInteger (mask (maximumServiceHours (), 15)),
            toInteger (mask (maximumStartups (), 16)),
            toDouble (mask (minimumLoad (), 17)),
            toDouble (mask (minimumScheduleQuantity (), 18)),
            mask (physicalRightsDAM (), 19),
            mask (physicalRightsRTM (), 20),
            mask (startEffectiveDate (), 21),
            toInteger (mask (startupLeadTime (), 22)),
            masks (BidSelfSched (), 23),
            mask (Chain_TransmissionRightChain (), 24),
            masks (ContractDistributionFactor (), 25),
            mask (Ind_TransmissionRightChain (), 26),
            mask (RTO (), 27),
            mask (SchedulingCoordinator (), 28),
            masks (SubstitutionResourceList (), 29),
            masks (TREntitlement (), 30),
            mask (TRType (), 31),
            masks (TransmissionInterfaceEntitlement (), 32)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Indicates Control Area associated with self-schedule.
 *
 * @param sup                Reference to the superclass object.
 * @param attained           Attained.
 * @param native             Native.
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @param SubControlArea     [[ch.ninecode.model.SubControlArea SubControlArea]] <em>undocumented</em>
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
    def this () =
    {
        this (null, null, null, List (), List ())
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Element: Element = sup.asInstanceOf [Element]

    override def copy (): Row =
    {
        clone ().asInstanceOf [ControlAreaDesignation]
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
    override val fields: Array[String] = Array [String](
        "attained",
        "native",
        "RegisteredResource",
        "SubControlArea"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RegisteredResource", "RegisteredResource", "0..*", "0..*"),
        Relationship ("SubControlArea", "SubControlArea", "0..*", "0..*")
    )
    val attained: Fielder = parse_attribute (attribute (cls, fields (0)))
    val `native`: Fielder = parse_attribute (attribute (cls, fields (1)))
    val RegisteredResource: FielderMultiple = parse_attributes (attribute (cls, fields (2)))
    val SubControlArea: FielderMultiple = parse_attributes (attribute (cls, fields (3)))

    def parse (context: Context): ControlAreaDesignation =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
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
 * @param sup                         [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param direction                   The direction of the flowgate, export or import
 * @param endEffectiveDate            end effective date
 * @param exportMWRating              Export MW rating
 * @param importMWRating              Import MW rating
 * @param startEffectiveDate          start effective date
 * @param CRR                         [[ch.ninecode.model.CRR CRR]] <em>undocumented</em>
 * @param ConstraintResults           [[ch.ninecode.model.ConstraintResults ConstraintResults]] <em>undocumented</em>
 * @param ContractDistributionFactor  [[ch.ninecode.model.ContractDistributionFactor ContractDistributionFactor]] <em>undocumented</em>
 * @param FTRs                        [[ch.ninecode.model.FTR FTR]] <em>undocumented</em>
 * @param FlowgateRelief              [[ch.ninecode.model.FlowgateRelief FlowgateRelief]] <em>undocumented</em>
 * @param FlowgateValue               [[ch.ninecode.model.FlowgateValue FlowgateValue]] <em>undocumented</em>
 * @param From_SubControlArea         [[ch.ninecode.model.SubControlArea SubControlArea]] <em>undocumented</em>
 * @param GeneratingUnitDynamicValues [[ch.ninecode.model.GeneratingUnitDynamicValues GeneratingUnitDynamicValues]] <em>undocumented</em>
 * @param GenericConstraints          [[ch.ninecode.model.GenericConstraints GenericConstraints]] <em>undocumented</em>
 * @param HostControlArea             [[ch.ninecode.model.HostControlArea HostControlArea]] <em>undocumented</em>
 * @param InterTie                    [[ch.ninecode.model.SchedulingPoint SchedulingPoint]] <em>undocumented</em>
 * @param InterTieResults             [[ch.ninecode.model.InterTieResults InterTieResults]] <em>undocumented</em>
 * @param MktLine                     [[ch.ninecode.model.MktLine MktLine]] <em>undocumented</em>
 * @param MktPowerTransformer         [[ch.ninecode.model.MktPowerTransformer MktPowerTransformer]] <em>undocumented</em>
 * @param MktTerminal                 [[ch.ninecode.model.MktTerminal MktTerminal]] <em>undocumented</em>
 * @param RegisteredInterTie          [[ch.ninecode.model.RegisteredInterTie RegisteredInterTie]] <em>undocumented</em>
 * @param SecurityConstraints         [[ch.ninecode.model.SecurityConstraints SecurityConstraints]] <em>undocumented</em>
 * @param To_SubControlArea           [[ch.ninecode.model.SubControlArea SubControlArea]] <em>undocumented</em>
 * @param TranmissionRightEntitlement [[ch.ninecode.model.TransmissionInterfaceRightEntitlement TransmissionInterfaceRightEntitlement]] <em>undocumented</em>
 * @param TransmissionCapacity        [[ch.ninecode.model.TransmissionCapacity TransmissionCapacity]] <em>undocumented</em>
 * @param ViolationLimits             [[ch.ninecode.model.ViolationLimit ViolationLimit]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
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
    def this () =
    {
        this (null, null, null, 0.0, 0.0, null, null, List (), List (), List (), List (), List (), null, List (), null, null, List (), List (), List (), List (), List (), List (), null, null, List (), List (), List ())
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
        clone ().asInstanceOf [Flowgate]
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
        implicit val clz: String = Flowgate.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Flowgate.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Flowgate.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (Flowgate.fields (position), x))

        emitattr (0, direction)
        emitelem (1, endEffectiveDate)
        emitelem (2, exportMWRating)
        emitelem (3, importMWRating)
        emitelem (4, startEffectiveDate)
        emitattr (5, CRR)
        emitattrs (6, ConstraintResults)
        emitattrs (7, ContractDistributionFactor)
        emitattrs (8, FTRs)
        emitattrs (9, FlowgateRelief)
        emitattrs (10, FlowgateValue)
        emitattr (11, From_SubControlArea)
        emitattrs (12, GeneratingUnitDynamicValues)
        emitattr (13, GenericConstraints)
        emitattr (14, HostControlArea)
        emitattrs (15, InterTie)
        emitattrs (16, InterTieResults)
        emitattrs (17, MktLine)
        emitattrs (18, MktPowerTransformer)
        emitattrs (19, MktTerminal)
        emitattrs (20, RegisteredInterTie)
        emitattr (21, SecurityConstraints)
        emitattr (22, To_SubControlArea)
        emitattrs (23, TranmissionRightEntitlement)
        emitattrs (24, TransmissionCapacity)
        emitattrs (25, ViolationLimits)
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
    override val fields: Array[String] = Array [String](
        "direction",
        "endEffectiveDate",
        "exportMWRating",
        "importMWRating",
        "startEffectiveDate",
        "CRR",
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
        Relationship ("CRR", "CRR", "0..1", "0..1"),
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
    val direction: Fielder = parse_attribute (attribute (cls, fields (0)))
    val endEffectiveDate: Fielder = parse_element (element (cls, fields (1)))
    val exportMWRating: Fielder = parse_element (element (cls, fields (2)))
    val importMWRating: Fielder = parse_element (element (cls, fields (3)))
    val startEffectiveDate: Fielder = parse_element (element (cls, fields (4)))
    val CRR: Fielder = parse_attribute (attribute (cls, fields (5)))
    val ConstraintResults: FielderMultiple = parse_attributes (attribute (cls, fields (6)))
    val ContractDistributionFactor: FielderMultiple = parse_attributes (attribute (cls, fields (7)))
    val FTRs: FielderMultiple = parse_attributes (attribute (cls, fields (8)))
    val FlowgateRelief: FielderMultiple = parse_attributes (attribute (cls, fields (9)))
    val FlowgateValue: FielderMultiple = parse_attributes (attribute (cls, fields (10)))
    val From_SubControlArea: Fielder = parse_attribute (attribute (cls, fields (11)))
    val GeneratingUnitDynamicValues: FielderMultiple = parse_attributes (attribute (cls, fields (12)))
    val GenericConstraints: Fielder = parse_attribute (attribute (cls, fields (13)))
    val HostControlArea: Fielder = parse_attribute (attribute (cls, fields (14)))
    val InterTie: FielderMultiple = parse_attributes (attribute (cls, fields (15)))
    val InterTieResults: FielderMultiple = parse_attributes (attribute (cls, fields (16)))
    val MktLine: FielderMultiple = parse_attributes (attribute (cls, fields (17)))
    val MktPowerTransformer: FielderMultiple = parse_attributes (attribute (cls, fields (18)))
    val MktTerminal: FielderMultiple = parse_attributes (attribute (cls, fields (19)))
    val RegisteredInterTie: FielderMultiple = parse_attributes (attribute (cls, fields (20)))
    val SecurityConstraints: Fielder = parse_attribute (attribute (cls, fields (21)))
    val To_SubControlArea: Fielder = parse_attribute (attribute (cls, fields (22)))
    val TranmissionRightEntitlement: FielderMultiple = parse_attributes (attribute (cls, fields (23)))
    val TransmissionCapacity: FielderMultiple = parse_attributes (attribute (cls, fields (24)))
    val ViolationLimits: FielderMultiple = parse_attributes (attribute (cls, fields (25)))

    def parse (context: Context): Flowgate =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = Flowgate (
            PowerSystemResource.parse (context),
            mask (direction (), 0),
            mask (endEffectiveDate (), 1),
            toDouble (mask (exportMWRating (), 2)),
            toDouble (mask (importMWRating (), 3)),
            mask (startEffectiveDate (), 4),
            mask (CRR (), 5),
            masks (ConstraintResults (), 6),
            masks (ContractDistributionFactor (), 7),
            masks (FTRs (), 8),
            masks (FlowgateRelief (), 9),
            masks (FlowgateValue (), 10),
            mask (From_SubControlArea (), 11),
            masks (GeneratingUnitDynamicValues (), 12),
            mask (GenericConstraints (), 13),
            mask (HostControlArea (), 14),
            masks (InterTie (), 15),
            masks (InterTieResults (), 16),
            masks (MktLine (), 17),
            masks (MktPowerTransformer (), 18),
            masks (MktTerminal (), 19),
            masks (RegisteredInterTie (), 20),
            mask (SecurityConstraints (), 21),
            mask (To_SubControlArea (), 22),
            masks (TranmissionRightEntitlement (), 23),
            masks (TransmissionCapacity (), 24),
            masks (ViolationLimits (), 25)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Flowgate defined partner
 *
 * @param sup           [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
    def this () =
    {
        this (null, null)
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
        clone ().asInstanceOf [FlowgatePartner]
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
    override val fields: Array[String] = Array [String](
        "FlowgateValue"
    )
    override val relations: List[Relationship] = List (
        Relationship ("FlowgateValue", "FlowgateValue", "0..1", "0..1")
    )
    val FlowgateValue: Fielder = parse_attribute (attribute (cls, fields (0)))

    def parse (context: Context): FlowgatePartner =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
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
 * @param sup              Reference to the superclass object.
 * @param effectiveDate    Date/Time when record becomes effective
 *                         Used to determine when a record becomes effective.
 * @param idcTargetMktFlow Energy Flow level that should be maintained according to the TLR rules as specified by the IDC.
 *                         For Realtime Markets use in dispatch to control constraints under TLR and calculate unconstrained market flows
 * @param terminateDate    Date/Time when record is no longer effective
 *                         Used to determine when a record is no longer effective
 * @param Flowgate         [[ch.ninecode.model.Flowgate Flowgate]] <em>undocumented</em>
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
    def this () =
    {
        this (null, null, 0, null, null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Element: Element = sup.asInstanceOf [Element]

    override def copy (): Row =
    {
        clone ().asInstanceOf [FlowgateRelief]
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
    override val fields: Array[String] = Array [String](
        "effectiveDate",
        "idcTargetMktFlow",
        "terminateDate",
        "Flowgate"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Flowgate", "Flowgate", "1", "0..*")
    )
    val effectiveDate: Fielder = parse_element (element (cls, fields (0)))
    val idcTargetMktFlow: Fielder = parse_element (element (cls, fields (1)))
    val terminateDate: Fielder = parse_element (element (cls, fields (2)))
    val Flowgate: Fielder = parse_attribute (attribute (cls, fields (3)))

    def parse (context: Context): FlowgateRelief =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
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
 * @param sup                   Reference to the superclass object.
 * @param economicDispatchLimit Limit for Economic Dispatch priority 6 energy flow on the specified flowgate for the specified time period.
 * @param effectiveDate         Date/Time when record becomes effective
 *                              Used to determine when a record becomes effective
 * @param firmNetworkLimit      Limit for firm flow on the specified flowgate for the specified time period.
 *                              The amount of energy flow over a specifed flowgate due to generation in the market which can be classified as Firm Network priority.
 * @param flowDirectionFlag     Specifies the direction of energy flow in the flowgate
 * @param mktFlow               The amount of energy flow over a specifed flowgate due to generation in the market.
 * @param netFirmNetworkLimit   Net Energy flow in flowgate for the associated FlowgatePartner
 * @param Flowgate              [[ch.ninecode.model.Flowgate Flowgate]] <em>undocumented</em>
 * @param FlowgatePartner       [[ch.ninecode.model.FlowgatePartner FlowgatePartner]] <em>undocumented</em>
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
    def this () =
    {
        this (null, 0, null, 0, null, 0, 0, null, null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Element: Element = sup.asInstanceOf [Element]

    override def copy (): Row =
    {
        clone ().asInstanceOf [FlowgateValue]
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
    override val fields: Array[String] = Array [String](
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
    val economicDispatchLimit: Fielder = parse_element (element (cls, fields (0)))
    val effectiveDate: Fielder = parse_element (element (cls, fields (1)))
    val firmNetworkLimit: Fielder = parse_element (element (cls, fields (2)))
    val flowDirectionFlag: Fielder = parse_attribute (attribute (cls, fields (3)))
    val mktFlow: Fielder = parse_element (element (cls, fields (4)))
    val netFirmNetworkLimit: Fielder = parse_element (element (cls, fields (5)))
    val Flowgate: Fielder = parse_attribute (attribute (cls, fields (6)))
    val FlowgatePartner: Fielder = parse_attribute (attribute (cls, fields (7)))

    def parse (context: Context): FlowgateValue =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
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
 * @param sup                [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param crossTime          Time to cross the forbidden region in minutes.
 * @param crossingCost       Cost associated with crossing the forbidden region
 * @param highMW             High end of the region definition
 * @param lowMW              Low end of the region definition.
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
    def this () =
    {
        this (null, 0, 0.0, 0.0, 0.0, List ())
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
        clone ().asInstanceOf [ForbiddenRegion]
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
    override val fields: Array[String] = Array [String](
        "crossTime",
        "crossingCost",
        "highMW",
        "lowMW",
        "RegisteredResource"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RegisteredResource", "RegisteredResource", "0..*", "0..*")
    )
    val crossTime: Fielder = parse_element (element (cls, fields (0)))
    val crossingCost: Fielder = parse_element (element (cls, fields (1)))
    val highMW: Fielder = parse_element (element (cls, fields (2)))
    val lowMW: Fielder = parse_element (element (cls, fields (3)))
    val RegisteredResource: FielderMultiple = parse_attributes (attribute (cls, fields (4)))

    def parse (context: Context): ForbiddenRegion =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
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
 * @param sup                [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
    def this () =
    {
        this (null, null)
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
        clone ().asInstanceOf [FormerReference]
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
    override val fields: Array[String] = Array [String](
        "RegisteredResource"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RegisteredResource", "RegisteredResource", "1", "0..*")
    )
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields (0)))

    def parse (context: Context): FormerReference =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
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
 * @param sup                 [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
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
    def this () =
    {
        this (null, null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Curve: Curve = sup.asInstanceOf [Curve]

    override def copy (): Row =
    {
        clone ().asInstanceOf [FuelCostCurve]
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
    override val fields: Array[String] = Array [String](
        "RegisteredGenerator"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RegisteredGenerator", "RegisteredGenerator", "0..1", "0..1")
    )
    val RegisteredGenerator: Fielder = parse_attribute (attribute (cls, fields (0)))

    def parse (context: Context): FuelCostCurve =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = FuelCostCurve (
            Curve.parse (context),
            mask (RegisteredGenerator (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Indication of region for fuel inventory purposes
 *
 * @param sup                 [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param endEffectiveDate    end effective date
 * @param fuelRegionType      The type of fuel region
 * @param lastModified        Time of last update
 * @param startEffectiveDate  start effective date
 * @param GasPrice            [[ch.ninecode.model.GasPrice GasPrice]] <em>undocumented</em>
 * @param OilPrice            [[ch.ninecode.model.OilPrice OilPrice]] <em>undocumented</em>
 * @param RTO                 [[ch.ninecode.model.RTO RTO]] <em>undocumented</em>
 * @param RegisteredGenerator [[ch.ninecode.model.RegisteredGenerator RegisteredGenerator]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
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
    RTO: String,
    RegisteredGenerator: List[String]
)
    extends
        Element
{
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, null, null, null, null, null, null, null, List ())
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
        clone ().asInstanceOf [FuelRegion]
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
        implicit val clz: String = FuelRegion.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (FuelRegion.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (FuelRegion.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (FuelRegion.fields (position), x))

        emitelem (0, endEffectiveDate)
        emitelem (1, fuelRegionType)
        emitelem (2, lastModified)
        emitelem (3, startEffectiveDate)
        emitattr (4, GasPrice)
        emitattr (5, OilPrice)
        emitattr (6, RTO)
        emitattrs (7, RegisteredGenerator)
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
    override val fields: Array[String] = Array [String](
        "endEffectiveDate",
        "fuelRegionType",
        "lastModified",
        "startEffectiveDate",
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
    val endEffectiveDate: Fielder = parse_element (element (cls, fields (0)))
    val fuelRegionType: Fielder = parse_element (element (cls, fields (1)))
    val lastModified: Fielder = parse_element (element (cls, fields (2)))
    val startEffectiveDate: Fielder = parse_element (element (cls, fields (3)))
    val GasPrice: Fielder = parse_attribute (attribute (cls, fields (4)))
    val OilPrice: Fielder = parse_attribute (attribute (cls, fields (5)))
    val RTO: Fielder = parse_attribute (attribute (cls, fields (6)))
    val RegisteredGenerator: FielderMultiple = parse_attributes (attribute (cls, fields (7)))

    def parse (context: Context): FuelRegion =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = FuelRegion (
            IdentifiedObject.parse (context),
            mask (endEffectiveDate (), 0),
            mask (fuelRegionType (), 1),
            mask (lastModified (), 2),
            mask (startEffectiveDate (), 3),
            mask (GasPrice (), 4),
            mask (OilPrice (), 5),
            mask (RTO (), 6),
            masks (RegisteredGenerator (), 7)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Price of gas in monetary units
 *
 * @param sup           Reference to the superclass object.
 * @param gasPriceIndex The average natural gas price at a defined fuel region.
 * @param FuelRegion    [[ch.ninecode.model.FuelRegion FuelRegion]] <em>undocumented</em>
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
    def this () =
    {
        this (null, 0.0, null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Element: Element = sup.asInstanceOf [Element]

    override def copy (): Row =
    {
        clone ().asInstanceOf [GasPrice]
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
    override val fields: Array[String] = Array [String](
        "gasPriceIndex",
        "FuelRegion"
    )
    override val relations: List[Relationship] = List (
        Relationship ("FuelRegion", "FuelRegion", "1", "1")
    )
    val gasPriceIndex: Fielder = parse_element (element (cls, fields (0)))
    val FuelRegion: Fielder = parse_attribute (attribute (cls, fields (1)))

    def parse (context: Context): GasPrice =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
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
 * @param sup                     [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param areaControlMode         The area's present control mode: (CF = constant frequency) or (CTL = constant tie-line) or (TLB = tie-line bias) or (OFF = off control)
 * @param endEffectiveDate        end effective date
 * @param freqSetPoint            The present power system frequency set point for automatic generation control
 * @param frequencyBiasFactor     The control area's frequency bias factor, in MW/0.1 Hz, for automatic generation control (AGC)
 * @param startEffectiveDate      start effective date
 * @param AdjacentCASet           [[ch.ninecode.model.AdjacentCASet AdjacentCASet]] <em>undocumented</em>
 * @param BidSelfSched            [[ch.ninecode.model.BidSelfSched BidSelfSched]] <em>undocumented</em>
 * @param CnodeDistributionFactor [[ch.ninecode.model.CnodeDistributionFactor CnodeDistributionFactor]] <em>undocumented</em>
 * @param Controls                [[ch.ninecode.model.ControlAreaOperator ControlAreaOperator]] A ControlAreaCompany controls a ControlArea.
 * @param Flowgate                [[ch.ninecode.model.Flowgate Flowgate]] <em>undocumented</em>
 * @param LossClearingResults     [[ch.ninecode.model.LossClearingResults LossClearingResults]] <em>undocumented</em>
 * @param RTO                     [[ch.ninecode.model.RTO RTO]] <em>undocumented</em>
 * @param RegisteredResource      [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @param SubControlAreas         [[ch.ninecode.model.SubControlArea SubControlArea]] The interchange area  may operate as a control area
 * @param SysLoadDistribuFactor   [[ch.ninecode.model.SysLoadDistributionFactor SysLoadDistributionFactor]] <em>undocumented</em>
 * @param TransferInterface       [[ch.ninecode.model.TransferInterface TransferInterface]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
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
    def this () =
    {
        this (null, null, null, 0.0, 0.0, null, null, List (), List (), null, List (), List (), null, List (), List (), List (), List ())
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
        clone ().asInstanceOf [HostControlArea]
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
        implicit val clz: String = HostControlArea.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (HostControlArea.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (HostControlArea.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (HostControlArea.fields (position), x))

        emitattr (0, areaControlMode)
        emitelem (1, endEffectiveDate)
        emitelem (2, freqSetPoint)
        emitelem (3, frequencyBiasFactor)
        emitelem (4, startEffectiveDate)
        emitattr (5, AdjacentCASet)
        emitattrs (6, BidSelfSched)
        emitattrs (7, CnodeDistributionFactor)
        emitattr (8, Controls)
        emitattrs (9, Flowgate)
        emitattrs (10, LossClearingResults)
        emitattr (11, RTO)
        emitattrs (12, RegisteredResource)
        emitattrs (13, SubControlAreas)
        emitattrs (14, SysLoadDistribuFactor)
        emitattrs (15, TransferInterface)
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
    override val fields: Array[String] = Array [String](
        "areaControlMode",
        "endEffectiveDate",
        "freqSetPoint",
        "frequencyBiasFactor",
        "startEffectiveDate",
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
    val areaControlMode: Fielder = parse_attribute (attribute (cls, fields (0)))
    val endEffectiveDate: Fielder = parse_element (element (cls, fields (1)))
    val freqSetPoint: Fielder = parse_element (element (cls, fields (2)))
    val frequencyBiasFactor: Fielder = parse_element (element (cls, fields (3)))
    val startEffectiveDate: Fielder = parse_element (element (cls, fields (4)))
    val AdjacentCASet: Fielder = parse_attribute (attribute (cls, fields (5)))
    val BidSelfSched: FielderMultiple = parse_attributes (attribute (cls, fields (6)))
    val CnodeDistributionFactor: FielderMultiple = parse_attributes (attribute (cls, fields (7)))
    val Controls: Fielder = parse_attribute (attribute (cls, fields (8)))
    val Flowgate: FielderMultiple = parse_attributes (attribute (cls, fields (9)))
    val LossClearingResults: FielderMultiple = parse_attributes (attribute (cls, fields (10)))
    val RTO: Fielder = parse_attribute (attribute (cls, fields (11)))
    val RegisteredResource: FielderMultiple = parse_attributes (attribute (cls, fields (12)))
    val SubControlAreas: FielderMultiple = parse_attributes (attribute (cls, fields (13)))
    val SysLoadDistribuFactor: FielderMultiple = parse_attributes (attribute (cls, fields (14)))
    val TransferInterface: FielderMultiple = parse_attributes (attribute (cls, fields (15)))

    def parse (context: Context): HostControlArea =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = HostControlArea (
            PowerSystemResource.parse (context),
            mask (areaControlMode (), 0),
            mask (endEffectiveDate (), 1),
            toDouble (mask (freqSetPoint (), 2)),
            toDouble (mask (frequencyBiasFactor (), 3)),
            mask (startEffectiveDate (), 4),
            mask (AdjacentCASet (), 5),
            masks (BidSelfSched (), 6),
            masks (CnodeDistributionFactor (), 7),
            mask (Controls (), 8),
            masks (Flowgate (), 9),
            masks (LossClearingResults (), 10),
            mask (RTO (), 11),
            masks (RegisteredResource (), 12),
            masks (SubControlAreas (), 13),
            masks (SysLoadDistribuFactor (), 14),
            masks (TransferInterface (), 15)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Individual pricing node based on Pnode
 *
 * @param sup                     [[ch.ninecode.model.Pnode Pnode]] Reference to the superclass object.
 * @param CongestionArea          [[ch.ninecode.model.CongestionArea CongestionArea]] <em>undocumented</em>
 * @param GenDistributionFactor   [[ch.ninecode.model.GenDistributionFactor GenDistributionFactor]] <em>undocumented</em>
 * @param LoadDistributionFactor  [[ch.ninecode.model.LoadDistributionFactor LoadDistributionFactor]] <em>undocumented</em>
 * @param MktConnectivityNode     [[ch.ninecode.model.MktConnectivityNode MktConnectivityNode]] <em>undocumented</em>
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
    def this () =
    {
        this (null, List (), null, null, null, List ())
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Pnode: Pnode = sup.asInstanceOf [Pnode]

    override def copy (): Row =
    {
        clone ().asInstanceOf [IndividualPnode]
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
    override val fields: Array[String] = Array [String](
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
    val CongestionArea: FielderMultiple = parse_attributes (attribute (cls, fields (0)))
    val GenDistributionFactor: Fielder = parse_attribute (attribute (cls, fields (1)))
    val LoadDistributionFactor: Fielder = parse_attribute (attribute (cls, fields (2)))
    val MktConnectivityNode: Fielder = parse_attribute (attribute (cls, fields (3)))
    val PnodeDistributionFactor: FielderMultiple = parse_attributes (attribute (cls, fields (4)))

    def parse (context: Context): IndividualPnode =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
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
    def this () =
    {
        this (null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def AggregateNode: AggregateNode = sup.asInstanceOf [AggregateNode]

    override def copy (): Row =
    {
        clone ().asInstanceOf [LoadAggregationPoint]
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
 * @param sup                   Reference to the superclass object.
 * @param intervalEndTime       Interval End Time
 * @param intervalStartTime     Interval Start Time
 * @param share                 Share in percentage of total Market load for the selected time interval.
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
    def this () =
    {
        this (null, null, null, 0.0, null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Element: Element = sup.asInstanceOf [Element]

    override def copy (): Row =
    {
        clone ().asInstanceOf [LoadRatio]
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
    override val fields: Array[String] = Array [String](
        "intervalEndTime",
        "intervalStartTime",
        "share",
        "SchedulingCoordinator"
    )
    override val relations: List[Relationship] = List (
        Relationship ("SchedulingCoordinator", "SchedulingCoordinator", "0..1", "1")
    )
    val intervalEndTime: Fielder = parse_element (element (cls, fields (0)))
    val intervalStartTime: Fielder = parse_element (element (cls, fields (1)))
    val share: Fielder = parse_element (element (cls, fields (2)))
    val SchedulingCoordinator: Fielder = parse_attribute (attribute (cls, fields (3)))

    def parse (context: Context): LoadRatio =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
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
 * This is the cureve that describes the load reduction time.
 *
 * Relationship between time (Y1-axis) vs. MW (X-axis).
 *
 * @param sup                        [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param loadReductionTimeCurveType type of the curve: Possible values are but not limited to:
 *                                   Max, Min,
 * @param RegisteredLoad             [[ch.ninecode.model.RegisteredLoad RegisteredLoad]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class LoadReductionTimeCurve
(
    override val sup: Curve,
    loadReductionTimeCurveType: String,
    RegisteredLoad: List[String]
)
    extends
        Element
{
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, null, List ())
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Curve: Curve = sup.asInstanceOf [Curve]

    override def copy (): Row =
    {
        clone ().asInstanceOf [LoadReductionTimeCurve]
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
        implicit val clz: String = LoadReductionTimeCurve.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (LoadReductionTimeCurve.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (LoadReductionTimeCurve.fields (position), x))

        emitelem (0, loadReductionTimeCurveType)
        emitattrs (1, RegisteredLoad)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:LoadReductionTimeCurve rdf:ID=\"%s\">\n%s\t</cim:LoadReductionTimeCurve>".format (id, export_fields)
    }
}

object LoadReductionTimeCurve
    extends
        Parseable[LoadReductionTimeCurve]
{
    override val fields: Array[String] = Array [String](
        "loadReductionTimeCurveType",
        "RegisteredLoad"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RegisteredLoad", "RegisteredLoad", "0..*", "0..*")
    )
    val loadReductionTimeCurveType: Fielder = parse_element (element (cls, fields (0)))
    val RegisteredLoad: FielderMultiple = parse_attributes (attribute (cls, fields (1)))

    def parse (context: Context): LoadReductionTimeCurve =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = LoadReductionTimeCurve (
            Curve.parse (context),
            mask (loadReductionTimeCurveType (), 0),
            masks (RegisteredLoad (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Allows definition of reliablity areas (eg load pockets) within the ISO/RTO
 *
 * @param sup                 [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param RTO                 [[ch.ninecode.model.RTO RTO]] <em>undocumented</em>
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
    def this () =
    {
        this (null, null, List ())
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
        clone ().asInstanceOf [LocalReliabilityArea]
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
    override val fields: Array[String] = Array [String](
        "RTO",
        "RegisteredGenerator"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RTO", "RTO", "1", "0..*"),
        Relationship ("RegisteredGenerator", "RegisteredGenerator", "0..*", "0..1")
    )
    val RTO: Fielder = parse_attribute (attribute (cls, fields (0)))
    val RegisteredGenerator: FielderMultiple = parse_attributes (attribute (cls, fields (1)))

    def parse (context: Context): LocalReliabilityArea =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
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
 * @param sup               [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param purposeFlag       Nature of threshold data:
 *                          'M' - Mitigation threshold
 *                          'R' - Reporting threshold
 * @param testIdentifier    1 - Global Price Test
 *                          2 - Global Conduct Test
 *                          3 - Global Impact Test
 *                          4 - Local Price Test
 *                          5 - Local Conduct Test
 *                          6 - Local Impact Test
 * @param testMethod        The method of performing the market power monitoring.
 *                          Examples are Normal (default) thresholds or Alternate thresholds.
 * @param MPMResourceStatus [[ch.ninecode.model.MPMResourceStatus MPMResourceStatus]] <em>undocumented</em>
 * @param MPMTestResults    [[ch.ninecode.model.MPMTestResults MPMTestResults]] <em>undocumented</em>
 * @param MPMTestThreshold  [[ch.ninecode.model.MPMTestThreshold MPMTestThreshold]] <em>undocumented</em>
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
    def this () =
    {
        this (null, null, null, null, List (), List (), List ())
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
        clone ().asInstanceOf [MPMTestCategory]
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
    override val fields: Array[String] = Array [String](
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
    val purposeFlag: Fielder = parse_attribute (attribute (cls, fields (0)))
    val testIdentifier: Fielder = parse_attribute (attribute (cls, fields (1)))
    val testMethod: Fielder = parse_attribute (attribute (cls, fields (2)))
    val MPMResourceStatus: FielderMultiple = parse_attributes (attribute (cls, fields (3)))
    val MPMTestResults: FielderMultiple = parse_attributes (attribute (cls, fields (4)))
    val MPMTestThreshold: FielderMultiple = parse_attributes (attribute (cls, fields (5)))

    def parse (context: Context): MPMTestCategory =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
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
 * Market Power Mitigation (MPM) test thresholds for resource as well as designated congestion areas (DCAs)
 *
 * @param sup                Reference to the superclass object.
 * @param marketType         Market Type (DAM, RTM)
 * @param percent            Price Threshold in %
 * @param price              Price Threshold in \$/MW
 * @param AggregatedPnode    [[ch.ninecode.model.AggregatedPnode AggregatedPnode]] <em>undocumented</em>
 * @param MPMTestCategory    [[ch.ninecode.model.MPMTestCategory MPMTestCategory]] <em>undocumented</em>
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
    def this () =
    {
        this (null, null, 0.0, 0.0, List (), null, List ())
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Element: Element = sup.asInstanceOf [Element]

    override def copy (): Row =
    {
        clone ().asInstanceOf [MPMTestThreshold]
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
    override val fields: Array[String] = Array [String](
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
    val marketType: Fielder = parse_attribute (attribute (cls, fields (0)))
    val percent: Fielder = parse_element (element (cls, fields (1)))
    val price: Fielder = parse_element (element (cls, fields (2)))
    val AggregatedPnode: FielderMultiple = parse_attributes (attribute (cls, fields (3)))
    val MPMTestCategory: Fielder = parse_attribute (attribute (cls, fields (4)))
    val RegisteredResource: FielderMultiple = parse_attributes (attribute (cls, fields (5)))

    def parse (context: Context): MPMTestThreshold =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
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
 * @param sup                  [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param costRecovery         Charge for Emission Costs, Start Up Costs, or Minimum Load Costs.
 * @param endEffectiveDate     end effective date
 * @param grossSettlement      MSS Load Following may select Net vs.
 *                             Gross settlement.  Net Settlement requires the net Demand settled at the MSS LAP and Net Supply needs to settle at the equivalent to the weighted average price of the MSS generation.  Gross load will be settled at the System LAP and the Gross supply will be settled at the LMP.  MSS Aggregation that elects gross settlement shall have to identify if its resources are Load Following or not.
 * @param ignoreLosses         Provides an indication if losses are to be ignored for this zone.
 *                             Also refered to as Exclude Marginal Losses.
 * @param ignoreMarginalLosses Provides an indication if marginal losses are to be ignored for this zone.
 * @param loadFollowing        Indication that this particular MSSA participates in the Load Following function.
 * @param rucProcurement       Indicates that RUC will be procured by the ISO or self provided.
 * @param startEffectiveDate   start effective date
 * @param MeteredSubSystem     [[ch.ninecode.model.MeteredSubSystem MeteredSubSystem]] <em>undocumented</em>
 * @param RTO                  [[ch.ninecode.model.RTO RTO]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
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
    MeteredSubSystem: List[String],
    RTO: String
)
    extends
        Element
{
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, null, null, null, null, null, null, null, null, List (), null)
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
        clone ().asInstanceOf [MSSAggregation]
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
        implicit val clz: String = MSSAggregation.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MSSAggregation.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MSSAggregation.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (MSSAggregation.fields (position), x))

        emitattr (0, costRecovery)
        emitelem (1, endEffectiveDate)
        emitattr (2, grossSettlement)
        emitattr (3, ignoreLosses)
        emitattr (4, ignoreMarginalLosses)
        emitattr (5, loadFollowing)
        emitattr (6, rucProcurement)
        emitelem (7, startEffectiveDate)
        emitattrs (8, MeteredSubSystem)
        emitattr (9, RTO)
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
    override val fields: Array[String] = Array [String](
        "costRecovery",
        "endEffectiveDate",
        "grossSettlement",
        "ignoreLosses",
        "ignoreMarginalLosses",
        "loadFollowing",
        "rucProcurement",
        "startEffectiveDate",
        "MeteredSubSystem",
        "RTO"
    )
    override val relations: List[Relationship] = List (
        Relationship ("MeteredSubSystem", "MeteredSubSystem", "1..*", "0..1"),
        Relationship ("RTO", "RTO", "1", "0..*")
    )
    val costRecovery: Fielder = parse_attribute (attribute (cls, fields (0)))
    val endEffectiveDate: Fielder = parse_element (element (cls, fields (1)))
    val grossSettlement: Fielder = parse_attribute (attribute (cls, fields (2)))
    val ignoreLosses: Fielder = parse_attribute (attribute (cls, fields (3)))
    val ignoreMarginalLosses: Fielder = parse_attribute (attribute (cls, fields (4)))
    val loadFollowing: Fielder = parse_attribute (attribute (cls, fields (5)))
    val rucProcurement: Fielder = parse_attribute (attribute (cls, fields (6)))
    val startEffectiveDate: Fielder = parse_element (element (cls, fields (7)))
    val MeteredSubSystem: FielderMultiple = parse_attributes (attribute (cls, fields (8)))
    val RTO: Fielder = parse_attribute (attribute (cls, fields (9)))

    def parse (context: Context): MSSAggregation =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = MSSAggregation (
            IdentifiedObject.parse (context),
            mask (costRecovery (), 0),
            mask (endEffectiveDate (), 1),
            mask (grossSettlement (), 2),
            mask (ignoreLosses (), 3),
            mask (ignoreMarginalLosses (), 4),
            mask (loadFollowing (), 5),
            mask (rucProcurement (), 6),
            mask (startEffectiveDate (), 7),
            masks (MeteredSubSystem (), 8),
            mask (RTO (), 9)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Model to define a zone within a Metered Sub System
 *
 * @param sup                [[ch.ninecode.model.AggregateNode AggregateNode]] Reference to the superclass object.
 * @param ignoreLosses       Provides an indication if losses are to be ignored for this metered subsystem zone.
 * @param lossFactor         This is the default loss factor for the Metered Sub-System (MSS) zone.
 *                           The actual losses are calculated during the RT market.
 * @param rucGrossSettlement Metered Sub-System (MSS) Load Following may select Net vs.
 *                           Gross settlement.  Net Settlement requires the net Demand settled at the Metered Sub-Sustem (MSS) Load Aggregation Point (LAP) and Net Supply needs to settle at the equivalent to the weighted average price of the MSS generation.  Gross load will be settled at the System LAP and the Gross supply will be settled at the LMP.  MSS Aggregation that elects gross settlement shall have to identify if its resources are Load Following or not.
 * @param MeteredSubSystem   [[ch.ninecode.model.MeteredSubSystem MeteredSubSystem]] <em>undocumented</em>
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
    def this () =
    {
        this (null, null, 0.0, null, null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def AggregateNode: AggregateNode = sup.asInstanceOf [AggregateNode]

    override def copy (): Row =
    {
        clone ().asInstanceOf [MSSZone]
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
    override val fields: Array[String] = Array [String](
        "ignoreLosses",
        "lossFactor",
        "rucGrossSettlement",
        "MeteredSubSystem"
    )
    override val relations: List[Relationship] = List (
        Relationship ("MeteredSubSystem", "MeteredSubSystem", "0..1", "0..*")
    )
    val ignoreLosses: Fielder = parse_attribute (attribute (cls, fields (0)))
    val lossFactor: Fielder = parse_element (element (cls, fields (1)))
    val rucGrossSettlement: Fielder = parse_attribute (attribute (cls, fields (2)))
    val MeteredSubSystem: Fielder = parse_attribute (attribute (cls, fields (3)))

    def parse (context: Context): MSSZone =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
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
 * @param sup                        [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param category                   Category of this person relative to utility operations, classified according to the utility's corporate standards and practices.
 *                                   Examples include employee, contractor, agent, not affiliated, etc.
 * @param electronicAddressAlternate Alternate Electronic address.
 * @param electronicAddressPrimary   Primary Electronic address.
 * @param firstName                  Person's first name.
 * @param governmentID               Unique identifier for person relative to its governing authority, for example a federal tax identifier (such as a Social Security number in the United States).
 * @param landlinePhone              Landline phone number.
 * @param lastName                   Person's last (family, sir) name.
 * @param mName                      Middle name(s) or initial(s).
 * @param mobilePhone                Mobile phone number.
 * @param prefix                     A prefix or title for the person's name, such as Miss, Mister, Doctor, etc.
 * @param specialNeed                Special service needs for the person (contact) are described; examples include life support, etc.
 * @param status                     <em>undocumented</em>
 * @param suffix                     A suffix for the person's name, such as II, III, etc.
 * @param userID                     The user name for the person; required to log in.
 * @param MarketSkills               [[ch.ninecode.model.MarketSkill MarketSkill]] <em>undocumented</em>
 * @param MktOrganisation            [[ch.ninecode.model.MktOrganisation MktOrganisation]] <em>undocumented</em>
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
    MarketSkills: List[String],
    MktOrganisation: List[String]
)
    extends
        Element
{
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, List (), List ())
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
        clone ().asInstanceOf [MarketPerson]
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
        emitattrs (14, MarketSkills)
        emitattrs (15, MktOrganisation)
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
    override val fields: Array[String] = Array [String](
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
        "MarketSkills",
        "MktOrganisation"
    )
    override val relations: List[Relationship] = List (
        Relationship ("MarketSkills", "MarketSkill", "0..*", "0..1"),
        Relationship ("MktOrganisation", "MktOrganisation", "0..*", "0..*")
    )
    val category: Fielder = parse_element (element (cls, fields (0)))
    val electronicAddressAlternate: Fielder = parse_attribute (attribute (cls, fields (1)))
    val electronicAddressPrimary: Fielder = parse_attribute (attribute (cls, fields (2)))
    val firstName: Fielder = parse_element (element (cls, fields (3)))
    val governmentID: Fielder = parse_element (element (cls, fields (4)))
    val landlinePhone: Fielder = parse_attribute (attribute (cls, fields (5)))
    val lastName: Fielder = parse_element (element (cls, fields (6)))
    val mName: Fielder = parse_element (element (cls, fields (7)))
    val mobilePhone: Fielder = parse_attribute (attribute (cls, fields (8)))
    val prefix: Fielder = parse_element (element (cls, fields (9)))
    val specialNeed: Fielder = parse_element (element (cls, fields (10)))
    val status: Fielder = parse_attribute (attribute (cls, fields (11)))
    val suffix: Fielder = parse_element (element (cls, fields (12)))
    val userID: Fielder = parse_element (element (cls, fields (13)))
    val MarketSkills: FielderMultiple = parse_attributes (attribute (cls, fields (14)))
    val MktOrganisation: FielderMultiple = parse_attributes (attribute (cls, fields (15)))

    def parse (context: Context): MarketPerson =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
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
            masks (MarketSkills (), 14),
            masks (MktOrganisation (), 15)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Certain skills are required and shall be certified in order for a person (typically a member of a crew) to be qualified to work on types of equipment.
 *
 * @param sup             [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param effectiveDate   Effective date of the privilege, terminate date of the privilege, or effective date of the application for the organization
 * @param expirationDate  This is the terminate date of the application for the organization
 *                        The specific organization can no longer access the application as of the terminate date
 * @param qualificationID Qualification identifier.
 * @param status          The status of the privilege.
 *                        Shows the status of the user�s qualification.
 * @param statusType      This is the name of the status of the qualification and is used to display the status of the user's or organization's status.
 * @param MarketSkills    [[ch.ninecode.model.MarketSkill MarketSkill]] <em>undocumented</em>
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
    def this () =
    {
        this (null, null, null, null, 0, null, List ())
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
        clone ().asInstanceOf [MarketQualificationRequirement]
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
    override val fields: Array[String] = Array [String](
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
    val effectiveDate: Fielder = parse_element (element (cls, fields (0)))
    val expirationDate: Fielder = parse_element (element (cls, fields (1)))
    val qualificationID: Fielder = parse_element (element (cls, fields (2)))
    val status: Fielder = parse_element (element (cls, fields (3)))
    val statusType: Fielder = parse_element (element (cls, fields (4)))
    val MarketSkills: FielderMultiple = parse_attributes (attribute (cls, fields (5)))

    def parse (context: Context): MarketQualificationRequirement =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
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
 * @param sup                       [[ch.ninecode.model.AggregateNode AggregateNode]] Reference to the superclass object.
 * @param ExPostMarketRegionResults [[ch.ninecode.model.ExPostMarketRegionResults ExPostMarketRegionResults]] <em>undocumented</em>
 * @param MarketRegionResults       [[ch.ninecode.model.MarketRegionResults MarketRegionResults]] <em>undocumented</em>
 * @param ReserveDemandCurve        [[ch.ninecode.model.ReserveDemandCurve ReserveDemandCurve]] <em>undocumented</em>
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
    def this () =
    {
        this (null, List (), List (), List ())
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def AggregateNode: AggregateNode = sup.asInstanceOf [AggregateNode]

    override def copy (): Row =
    {
        clone ().asInstanceOf [MarketRegion]
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
    override val fields: Array[String] = Array [String](
        "ExPostMarketRegionResults",
        "MarketRegionResults",
        "ReserveDemandCurve"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ExPostMarketRegionResults", "ExPostMarketRegionResults", "0..*", "1"),
        Relationship ("MarketRegionResults", "MarketRegionResults", "1..*", "1"),
        Relationship ("ReserveDemandCurve", "ReserveDemandCurve", "0..*", "1")
    )
    val ExPostMarketRegionResults: FielderMultiple = parse_attributes (attribute (cls, fields (0)))
    val MarketRegionResults: FielderMultiple = parse_attributes (attribute (cls, fields (1)))
    val ReserveDemandCurve: FielderMultiple = parse_attributes (attribute (cls, fields (2)))

    def parse (context: Context): MarketRegion =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
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
 * @param sup                             [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param certificationPeriod             Interval between the certification and its expiry.
 * @param effectiveDateTime               Date and time the skill became effective.
 * @param level                           Level of skill for a Craft.
 * @param MarketPerson                    [[ch.ninecode.model.MarketPerson MarketPerson]] <em>undocumented</em>
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
    def this () =
    {
        this (null, null, null, null, null, List ())
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Document: Document = sup.asInstanceOf [Document]

    override def copy (): Row =
    {
        clone ().asInstanceOf [MarketSkill]
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
    override val fields: Array[String] = Array [String](
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
    val certificationPeriod: Fielder = parse_attribute (attribute (cls, fields (0)))
    val effectiveDateTime: Fielder = parse_element (element (cls, fields (1)))
    val level: Fielder = parse_element (element (cls, fields (2)))
    val MarketPerson: Fielder = parse_attribute (attribute (cls, fields (3)))
    val MarketQualificationRequirements: FielderMultiple = parse_attributes (attribute (cls, fields (4)))

    def parse (context: Context): MarketSkill =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
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
    def this () =
    {
        this (null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Curve: Curve = sup.asInstanceOf [Curve]

    override def copy (): Row =
    {
        clone ().asInstanceOf [MaxStartUpCostCurve]
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
 * A metered subsystem
 *
 * @param sup            [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param MSSAggregation [[ch.ninecode.model.MSSAggregation MSSAggregation]] <em>undocumented</em>
 * @param MSSZone        [[ch.ninecode.model.MSSZone MSSZone]] <em>undocumented</em>
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
    def this () =
    {
        this (null, null, List ())
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
        clone ().asInstanceOf [MeteredSubSystem]
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
    override val fields: Array[String] = Array [String](
        "MSSAggregation",
        "MSSZone"
    )
    override val relations: List[Relationship] = List (
        Relationship ("MSSAggregation", "MSSAggregation", "0..1", "1..*"),
        Relationship ("MSSZone", "MSSZone", "0..*", "0..1")
    )
    val MSSAggregation: Fielder = parse_attribute (attribute (cls, fields (0)))
    val MSSZone: FielderMultiple = parse_attributes (attribute (cls, fields (1)))

    def parse (context: Context): MeteredSubSystem =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
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
 * Subclass of Production: CombinedCyclePlant from IEC61970 package.
 *
 * A set of combustion turbines and steam turbines where the exhaust heat from the combustion turbines is recovered to make steam for the steam turbines, resulting in greater overall plant efficiency
 *
 * @param sup                               [[ch.ninecode.model.CombinedCyclePlant CombinedCyclePlant]] Reference to the superclass object.
 * @param AggregatedPnode                   [[ch.ninecode.model.AggregatedPnode AggregatedPnode]] <em>undocumented</em>
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
    def this () =
    {
        this (null, null, List ())
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def CombinedCyclePlant: CombinedCyclePlant = sup.asInstanceOf [CombinedCyclePlant]

    override def copy (): Row =
    {
        clone ().asInstanceOf [MktCombinedCyclePlant]
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
    override val fields: Array[String] = Array [String](
        "AggregatedPnode",
        "CombinedCycleLogicalConfiguration"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AggregatedPnode", "AggregatedPnode", "0..1", "0..*"),
        Relationship ("CombinedCycleLogicalConfiguration", "CombinedCycleLogicalConfiguration", "1..*", "0..1")
    )
    val AggregatedPnode: Fielder = parse_attribute (attribute (cls, fields (0)))
    val CombinedCycleLogicalConfiguration: FielderMultiple = parse_attributes (attribute (cls, fields (1)))

    def parse (context: Context): MktCombinedCyclePlant =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
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
 * Subclass of IEC61970:Core:ConductingEquipment
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
    def this () =
    {
        this (null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ConductingEquipment: ConductingEquipment = sup.asInstanceOf [ConductingEquipment]

    override def copy (): Row =
    {
        clone ().asInstanceOf [MktConductingEquipment]
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
 * Subclass of IEC61970:Contingency
 *
 * @param sup                        [[ch.ninecode.model.Contingency Contingency]] Reference to the superclass object.
 * @param loadRolloverFlag           load change flag
 *                                   Flag that indicates whether load rollover and load pickup should be processed for this contingency
 * @param ltcControlFlag             ltc enable flag
 *                                   Flag that indicates if LTCs regulate voltage during the solution of the contingency
 * @param participationFactorSet     Participation Factor flag
 *                                   An indication which set of generator participation factors should be used to re-allocate generation in this contingency
 * @param screeningFlag              sceening flag for outage
 *                                   Flag that indicated whether screening is bypassed for the contingency
 * @param ConstraintResults          [[ch.ninecode.model.ConstraintResults ConstraintResults]] <em>undocumented</em>
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
    def this () =
    {
        this (null, false, false, null, false, List (), List (), null, null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Contingency: Contingency = sup.asInstanceOf [Contingency]

    override def copy (): Row =
    {
        clone ().asInstanceOf [MktContingency]
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
    override val fields: Array[String] = Array [String](
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
    val loadRolloverFlag: Fielder = parse_element (element (cls, fields (0)))
    val ltcControlFlag: Fielder = parse_element (element (cls, fields (1)))
    val participationFactorSet: Fielder = parse_element (element (cls, fields (2)))
    val screeningFlag: Fielder = parse_element (element (cls, fields (3)))
    val ConstraintResults: FielderMultiple = parse_attributes (attribute (cls, fields (4)))
    val ContingencyConstraintLimit: FielderMultiple = parse_attributes (attribute (cls, fields (5)))
    val TransferInterfaceSolutionA: Fielder = parse_attribute (attribute (cls, fields (6)))
    val TransferInterfaceSolutionB: Fielder = parse_attribute (attribute (cls, fields (7)))

    def parse (context: Context): MktContingency =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
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
 * Subclass of IEC61970: Generation: Production:HeatRateCurve
 *
 * @param sup                     [[ch.ninecode.model.HeatRateCurve HeatRateCurve]] Reference to the superclass object.
 * @param RegisteredGenerator     [[ch.ninecode.model.RegisteredGenerator RegisteredGenerator]] <em>undocumented</em>
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
    def this () =
    {
        this (null, null, null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def HeatRateCurve: HeatRateCurve = sup.asInstanceOf [HeatRateCurve]

    override def copy (): Row =
    {
        clone ().asInstanceOf [MktHeatRateCurve]
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
    override val fields: Array[String] = Array [String](
        "RegisteredGenerator",
        "ResourceVerifiableCosts"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RegisteredGenerator", "RegisteredGenerator", "0..1", "0..1"),
        Relationship ("ResourceVerifiableCosts", "ResourceVerifiableCosts", "0..1", "1")
    )
    val RegisteredGenerator: Fielder = parse_attribute (attribute (cls, fields (0)))
    val ResourceVerifiableCosts: Fielder = parse_attribute (attribute (cls, fields (1)))

    def parse (context: Context): MktHeatRateCurve =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
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
 * Subclass of ThermalGeneratingUnit from Production Package in IEC61970.
 *
 * @param sup                              [[ch.ninecode.model.ThermalGeneratingUnit ThermalGeneratingUnit]] Reference to the superclass object.
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
    def this () =
    {
        this (null, List ())
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ThermalGeneratingUnit: ThermalGeneratingUnit = sup.asInstanceOf [ThermalGeneratingUnit]

    override def copy (): Row =
    {
        clone ().asInstanceOf [MktThermalGeneratingUnit]
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
    override val fields: Array[String] = Array [String](
        "CombinedCycleConfigurationMember"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CombinedCycleConfigurationMember", "CombinedCycleConfigurationMember", "0..*", "1")
    )
    val CombinedCycleConfigurationMember: FielderMultiple = parse_attributes (attribute (cls, fields (0)))

    def parse (context: Context): MktThermalGeneratingUnit =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = MktThermalGeneratingUnit (
            ThermalGeneratingUnit.parse (context),
            masks (CombinedCycleConfigurationMember (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Price of oil in monetary units
 *
 * @param sup           Reference to the superclass object.
 * @param oilPriceIndex The average oil price at a defined fuel region.
 * @param FuelRegion    [[ch.ninecode.model.FuelRegion FuelRegion]] <em>undocumented</em>
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
    def this () =
    {
        this (null, 0.0, null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Element: Element = sup.asInstanceOf [Element]

    override def copy (): Row =
    {
        clone ().asInstanceOf [OilPrice]
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
    override val fields: Array[String] = Array [String](
        "oilPriceIndex",
        "FuelRegion"
    )
    override val relations: List[Relationship] = List (
        Relationship ("FuelRegion", "FuelRegion", "1", "1")
    )
    val oilPriceIndex: Fielder = parse_element (element (cls, fields (0)))
    val FuelRegion: Fielder = parse_attribute (attribute (cls, fields (1)))

    def parse (context: Context): OilPrice =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
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
 * This class models the allocation between asset owners and pricing nodes
 *
 * @param sup                [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param endEffectiveDate   end effective date
 * @param maxMWAllocation    Maximum MW for the Source/Sink for the Allocation
 * @param startEffectiveDate start effective date
 * @param MktOrganisation    [[ch.ninecode.model.MktOrganisation MktOrganisation]] <em>undocumented</em>
 * @param Pnode              [[ch.ninecode.model.Pnode Pnode]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
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
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, null, 0.0, null, null, null)
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
        clone ().asInstanceOf [OrgPnodeAllocation]
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
        implicit val clz: String = OrgPnodeAllocation.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (OrgPnodeAllocation.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OrgPnodeAllocation.fields (position), value)

        emitelem (0, endEffectiveDate)
        emitelem (1, maxMWAllocation)
        emitelem (2, startEffectiveDate)
        emitattr (3, MktOrganisation)
        emitattr (4, Pnode)
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
    override val fields: Array[String] = Array [String](
        "endEffectiveDate",
        "maxMWAllocation",
        "startEffectiveDate",
        "MktOrganisation",
        "Pnode"
    )
    override val relations: List[Relationship] = List (
        Relationship ("MktOrganisation", "MktOrganisation", "1", "0..*"),
        Relationship ("Pnode", "Pnode", "1", "0..*")
    )
    val endEffectiveDate: Fielder = parse_element (element (cls, fields (0)))
    val maxMWAllocation: Fielder = parse_element (element (cls, fields (1)))
    val startEffectiveDate: Fielder = parse_element (element (cls, fields (2)))
    val MktOrganisation: Fielder = parse_attribute (attribute (cls, fields (3)))
    val Pnode: Fielder = parse_attribute (attribute (cls, fields (4)))

    def parse (context: Context): OrgPnodeAllocation =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = OrgPnodeAllocation (
            IdentifiedObject.parse (context),
            mask (endEffectiveDate (), 0),
            toDouble (mask (maxMWAllocation (), 1)),
            mask (startEffectiveDate (), 2),
            mask (MktOrganisation (), 3),
            mask (Pnode (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * This class model the ownership percent and type of ownership between resource and organisation
 *
 * @param sup                             [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param asscType                        association type for the association between Organisation and Resource:
 * @param endEffectiveDate                end effective date
 * @param masterSchedulingCoordinatorFlag Flag to indicate that the SC representing the Resource is the Master SC.
 * @param ownershipPercent                ownership percentage for each resource
 * @param startEffectiveDate              start effective date
 * @param MktOrganisation                 [[ch.ninecode.model.MktOrganisation MktOrganisation]] <em>undocumented</em>
 * @param RegisteredResource              [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
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
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, null, null, null, 0.0, null, null, null)
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
        clone ().asInstanceOf [OrgResOwnership]
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
        implicit val clz: String = OrgResOwnership.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (OrgResOwnership.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OrgResOwnership.fields (position), value)

        emitattr (0, asscType)
        emitelem (1, endEffectiveDate)
        emitattr (2, masterSchedulingCoordinatorFlag)
        emitelem (3, ownershipPercent)
        emitelem (4, startEffectiveDate)
        emitattr (5, MktOrganisation)
        emitattr (6, RegisteredResource)
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
    override val fields: Array[String] = Array [String](
        "asscType",
        "endEffectiveDate",
        "masterSchedulingCoordinatorFlag",
        "ownershipPercent",
        "startEffectiveDate",
        "MktOrganisation",
        "RegisteredResource"
    )
    override val relations: List[Relationship] = List (
        Relationship ("MktOrganisation", "MktOrganisation", "1", "0..*"),
        Relationship ("RegisteredResource", "RegisteredResource", "1", "0..*")
    )
    val asscType: Fielder = parse_attribute (attribute (cls, fields (0)))
    val endEffectiveDate: Fielder = parse_element (element (cls, fields (1)))
    val masterSchedulingCoordinatorFlag: Fielder = parse_attribute (attribute (cls, fields (2)))
    val ownershipPercent: Fielder = parse_element (element (cls, fields (3)))
    val startEffectiveDate: Fielder = parse_element (element (cls, fields (4)))
    val MktOrganisation: Fielder = parse_attribute (attribute (cls, fields (5)))
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields (6)))

    def parse (context: Context): OrgResOwnership =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = OrgResOwnership (
            IdentifiedObject.parse (context),
            mask (asscType (), 0),
            mask (endEffectiveDate (), 1),
            mask (masterSchedulingCoordinatorFlag (), 2),
            toDouble (mask (ownershipPercent (), 3)),
            mask (startEffectiveDate (), 4),
            mask (MktOrganisation (), 5),
            mask (RegisteredResource (), 6)
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
 * @param sup                     [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param endEffectiveDate        End effective date of the period in which the price node definition is valid.
 * @param isPublic                If true, this Pnode is public (prices are published for DA/RT and FTR markets), otherwise it is private (location is not usable by market for bidding/FTRs/transactions).
 * @param startEffectiveDate      Start effective date of the period in which the price node definition is valid.
 * @param type                    Pnode type
 * @param usage                   Price node usage:
 *                                'Control Area'
 *                                'Regulation Region'
 *                                'Price Zone'
 *                                'Spin Region'
 *                                'Non-Spin Region'
 *                                'Price Hub'
 * @param AggregateNode           [[ch.ninecode.model.AggregateNode AggregateNode]] <em>undocumented</em>
 * @param DeliveryTransactionBids [[ch.ninecode.model.TransactionBid TransactionBid]] <em>undocumented</em>
 * @param ExPostResults           [[ch.ninecode.model.ExPostPricingResults ExPostPricingResults]] <em>undocumented</em>
 * @param FTRs                    [[ch.ninecode.model.FTR FTR]] <em>undocumented</em>
 * @param MktMeasurement          [[ch.ninecode.model.MktMeasurement MktMeasurement]] <em>undocumented</em>
 * @param OrgPnodeAllocation      [[ch.ninecode.model.OrgPnodeAllocation OrgPnodeAllocation]] <em>undocumented</em>
 * @param PnodeResults            [[ch.ninecode.model.PnodeResults PnodeResults]] <em>undocumented</em>
 * @param RTO                     [[ch.ninecode.model.RTO RTO]] <em>undocumented</em>
 * @param ReceiptTransactionBids  [[ch.ninecode.model.TransactionBid TransactionBid]] <em>undocumented</em>
 * @param RegisteredResources     [[ch.ninecode.model.RegisteredResource RegisteredResource]] A registered resource injects power at one or more connectivity nodes related to a pnode
 * @param SinkCRRSegment          [[ch.ninecode.model.CRRSegment CRRSegment]] <em>undocumented</em>
 * @param SourceCRRSegment        [[ch.ninecode.model.CRRSegment CRRSegment]] <em>undocumented</em>
 * @param SubControlArea          [[ch.ninecode.model.SubControlArea SubControlArea]] <em>undocumented</em>
 * @param Trade                   [[ch.ninecode.model.Trade Trade]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class Pnode
(
    override val sup: IdentifiedObject,
    endEffectiveDate: String,
    isPublic: Boolean,
    startEffectiveDate: String,
    `type`: String,
    usage: String,
    AggregateNode: List[String],
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
    def this () =
    {
        this (null, null, false, null, null, null, List (), List (), List (), List (), List (), List (), List (), null, List (), List (), List (), List (), null, List ())
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
        clone ().asInstanceOf [Pnode]
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
        implicit val clz: String = Pnode.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Pnode.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Pnode.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (Pnode.fields (position), x))

        emitelem (0, endEffectiveDate)
        emitelem (1, isPublic)
        emitelem (2, startEffectiveDate)
        emitelem (3, `type`)
        emitelem (4, usage)
        emitattrs (5, AggregateNode)
        emitattrs (6, DeliveryTransactionBids)
        emitattrs (7, ExPostResults)
        emitattrs (8, FTRs)
        emitattrs (9, MktMeasurement)
        emitattrs (10, OrgPnodeAllocation)
        emitattrs (11, PnodeResults)
        emitattr (12, RTO)
        emitattrs (13, ReceiptTransactionBids)
        emitattrs (14, RegisteredResources)
        emitattrs (15, SinkCRRSegment)
        emitattrs (16, SourceCRRSegment)
        emitattr (17, SubControlArea)
        emitattrs (18, Trade)
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
    override val fields: Array[String] = Array [String](
        "endEffectiveDate",
        "isPublic",
        "startEffectiveDate",
        "type",
        "usage",
        "AggregateNode",
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
    val endEffectiveDate: Fielder = parse_element (element (cls, fields (0)))
    val isPublic: Fielder = parse_element (element (cls, fields (1)))
    val startEffectiveDate: Fielder = parse_element (element (cls, fields (2)))
    val `type`: Fielder = parse_element (element (cls, fields (3)))
    val usage: Fielder = parse_element (element (cls, fields (4)))
    val AggregateNode: FielderMultiple = parse_attributes (attribute (cls, fields (5)))
    val DeliveryTransactionBids: FielderMultiple = parse_attributes (attribute (cls, fields (6)))
    val ExPostResults: FielderMultiple = parse_attributes (attribute (cls, fields (7)))
    val FTRs: FielderMultiple = parse_attributes (attribute (cls, fields (8)))
    val MktMeasurement: FielderMultiple = parse_attributes (attribute (cls, fields (9)))
    val OrgPnodeAllocation: FielderMultiple = parse_attributes (attribute (cls, fields (10)))
    val PnodeResults: FielderMultiple = parse_attributes (attribute (cls, fields (11)))
    val RTO: Fielder = parse_attribute (attribute (cls, fields (12)))
    val ReceiptTransactionBids: FielderMultiple = parse_attributes (attribute (cls, fields (13)))
    val RegisteredResources: FielderMultiple = parse_attributes (attribute (cls, fields (14)))
    val SinkCRRSegment: FielderMultiple = parse_attributes (attribute (cls, fields (15)))
    val SourceCRRSegment: FielderMultiple = parse_attributes (attribute (cls, fields (16)))
    val SubControlArea: Fielder = parse_attribute (attribute (cls, fields (17)))
    val Trade: FielderMultiple = parse_attributes (attribute (cls, fields (18)))

    def parse (context: Context): Pnode =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = Pnode (
            IdentifiedObject.parse (context),
            mask (endEffectiveDate (), 0),
            toBoolean (mask (isPublic (), 1)),
            mask (startEffectiveDate (), 2),
            mask (`type` (), 3),
            mask (usage (), 4),
            masks (AggregateNode (), 5),
            masks (DeliveryTransactionBids (), 6),
            masks (ExPostResults (), 7),
            masks (FTRs (), 8),
            masks (MktMeasurement (), 9),
            masks (OrgPnodeAllocation (), 10),
            masks (PnodeResults (), 11),
            mask (RTO (), 12),
            masks (ReceiptTransactionBids (), 13),
            masks (RegisteredResources (), 14),
            masks (SinkCRRSegment (), 15),
            masks (SourceCRRSegment (), 16),
            mask (SubControlArea (), 17),
            masks (Trade (), 18)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * This class allows SC to input different distribution factors for pricing node
 *
 * @param sup                   Reference to the superclass object.
 * @param factor                Used to calculate "participation" of Pnode in an AggregatePnode.
 *                              For example, for regulation region this factor is 1 and total sum of all factors for a specific regulation region does not have to be 1. For pricing zone the total sum of all factors has to be 1.
 * @param offPeak               Indication that this distribution factor is to apply during off peak.
 * @param onPeak                Indication that this factor is to apply during Peak periods.
 * @param podLossFactor         Point of delivery loss factor
 * @param AggregatedPnode       [[ch.ninecode.model.AggregatedPnode AggregatedPnode]] <em>undocumented</em>
 * @param BidDistributionFactor [[ch.ninecode.model.BidDistributionFactor BidDistributionFactor]] <em>undocumented</em>
 * @param IndividualPnode       [[ch.ninecode.model.IndividualPnode IndividualPnode]] <em>undocumented</em>
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
    AggregatedPnode: List[String],
    BidDistributionFactor: String,
    IndividualPnode: String
)
    extends
        Element
{
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, 0.0, null, null, 0.0, List (), null, null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Element: Element = sup.asInstanceOf [Element]

    override def copy (): Row =
    {
        clone ().asInstanceOf [PnodeDistributionFactor]
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
        implicit val clz: String = PnodeDistributionFactor.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PnodeDistributionFactor.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PnodeDistributionFactor.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (PnodeDistributionFactor.fields (position), x))

        emitelem (0, factor)
        emitattr (1, offPeak)
        emitattr (2, onPeak)
        emitelem (3, podLossFactor)
        emitattrs (4, AggregatedPnode)
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
    override val fields: Array[String] = Array [String](
        "factor",
        "offPeak",
        "onPeak",
        "podLossFactor",
        "AggregatedPnode",
        "BidDistributionFactor",
        "IndividualPnode"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AggregatedPnode", "AggregatedPnode", "0..*", "1"),
        Relationship ("BidDistributionFactor", "BidDistributionFactor", "0..1", "0..*"),
        Relationship ("IndividualPnode", "IndividualPnode", "1", "0..*")
    )
    val factor: Fielder = parse_element (element (cls, fields (0)))
    val offPeak: Fielder = parse_attribute (attribute (cls, fields (1)))
    val onPeak: Fielder = parse_attribute (attribute (cls, fields (2)))
    val podLossFactor: Fielder = parse_element (element (cls, fields (3)))
    val AggregatedPnode: FielderMultiple = parse_attributes (attribute (cls, fields (4)))
    val BidDistributionFactor: Fielder = parse_attribute (attribute (cls, fields (5)))
    val IndividualPnode: Fielder = parse_attribute (attribute (cls, fields (6)))

    def parse (context: Context): PnodeDistributionFactor =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = PnodeDistributionFactor (
            BasicElement.parse (context),
            toDouble (mask (factor (), 0)),
            mask (offPeak (), 1),
            mask (onPeak (), 2),
            toDouble (mask (podLossFactor (), 3)),
            masks (AggregatedPnode (), 4),
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
 * @param sup                 [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
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
    def this () =
    {
        this (null, null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Curve: Curve = sup.asInstanceOf [Curve]

    override def copy (): Row =
    {
        clone ().asInstanceOf [RMRHeatRateCurve]
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
    override val fields: Array[String] = Array [String](
        "RegisteredGenerator"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RegisteredGenerator", "RegisteredGenerator", "0..1", "0..1")
    )
    val RegisteredGenerator: Fielder = parse_attribute (attribute (cls, fields (0)))

    def parse (context: Context): RMRHeatRateCurve =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
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
 * @param sup                 [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
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
    def this () =
    {
        this (null, null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Curve: Curve = sup.asInstanceOf [Curve]

    override def copy (): Row =
    {
        clone ().asInstanceOf [RMRStartUpCostCurve]
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
    override val fields: Array[String] = Array [String](
        "RegisteredGenerator"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RegisteredGenerator", "RegisteredGenerator", "0..1", "0..1")
    )
    val RegisteredGenerator: Fielder = parse_attribute (attribute (cls, fields (0)))

    def parse (context: Context): RMRStartUpCostCurve =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
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
 * @param sup                 [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
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
    def this () =
    {
        this (null, null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Curve: Curve = sup.asInstanceOf [Curve]

    override def copy (): Row =
    {
        clone ().asInstanceOf [RMRStartUpEnergyCurve]
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
    override val fields: Array[String] = Array [String](
        "RegisteredGenerator"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RegisteredGenerator", "RegisteredGenerator", "0..1", "0..1")
    )
    val RegisteredGenerator: Fielder = parse_attribute (attribute (cls, fields (0)))

    def parse (context: Context): RMRStartUpEnergyCurve =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
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
 * @param sup                 [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
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
    def this () =
    {
        this (null, null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Curve: Curve = sup.asInstanceOf [Curve]

    override def copy (): Row =
    {
        clone ().asInstanceOf [RMRStartUpFuelCurve]
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
    override val fields: Array[String] = Array [String](
        "RegisteredGenerator"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RegisteredGenerator", "RegisteredGenerator", "0..1", "0..1")
    )
    val RegisteredGenerator: Fielder = parse_attribute (attribute (cls, fields (0)))

    def parse (context: Context): RMRStartUpFuelCurve =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
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
 * @param sup                 [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
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
    def this () =
    {
        this (null, null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Curve: Curve = sup.asInstanceOf [Curve]

    override def copy (): Row =
    {
        clone ().asInstanceOf [RMRStartUpTimeCurve]
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
    override val fields: Array[String] = Array [String](
        "RegisteredGenerator"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RegisteredGenerator", "RegisteredGenerator", "0..1", "0..1")
    )
    val RegisteredGenerator: Fielder = parse_attribute (attribute (cls, fields (0)))

    def parse (context: Context): RMRStartUpTimeCurve =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
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
 * @param sup                       [[ch.ninecode.model.MktOrganisation MktOrganisation]] Reference to the superclass object.
 * @param AdjacentCASet             [[ch.ninecode.model.AdjacentCASet AdjacentCASet]] <em>undocumented</em>
 * @param AggregateNode             [[ch.ninecode.model.AggregateNode AggregateNode]] <em>undocumented</em>
 * @param EnergyMarkets             [[ch.ninecode.model.EnergyMarket EnergyMarket]] <em>undocumented</em>
 * @param FuelRegion                [[ch.ninecode.model.FuelRegion FuelRegion]] <em>undocumented</em>
 * @param HostControlArea           [[ch.ninecode.model.HostControlArea HostControlArea]] <em>undocumented</em>
 * @param LocalReliabilityArea      [[ch.ninecode.model.LocalReliabilityArea LocalReliabilityArea]] <em>undocumented</em>
 * @param MSSAggregation            [[ch.ninecode.model.MSSAggregation MSSAggregation]] <em>undocumented</em>
 * @param MktConnectivityNode       [[ch.ninecode.model.MktConnectivityNode MktConnectivityNode]] <em>undocumented</em>
 * @param Pnodes                    [[ch.ninecode.model.Pnode Pnode]] <em>undocumented</em>
 * @param ResourceGroupReqs         [[ch.ninecode.model.ResourceGroupReq ResourceGroupReq]] <em>undocumented</em>
 * @param SecurityConstraints       [[ch.ninecode.model.SecurityConstraints SecurityConstraints]] <em>undocumented</em>
 * @param SecurityConstraintsLinear [[ch.ninecode.model.SecurityConstraintSum SecurityConstraintSum]] <em>undocumented</em>
 * @param SubControlArea            [[ch.ninecode.model.SubControlArea SubControlArea]] <em>undocumented</em>
 * @param TransmissionContractRight [[ch.ninecode.model.ContractRight ContractRight]] <em>undocumented</em>
 * @param TransmissionRightChain    [[ch.ninecode.model.TransmissionRightChain TransmissionRightChain]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class RTO
(
    override val sup: MktOrganisation,
    AdjacentCASet: List[String],
    AggregateNode: List[String],
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
    def this () =
    {
        this (null, List (), List (), List (), List (), List (), List (), List (), List (), List (), List (), List (), List (), List (), List (), List ())
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def MktOrganisation: MktOrganisation = sup.asInstanceOf [MktOrganisation]

    override def copy (): Row =
    {
        clone ().asInstanceOf [RTO]
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
        implicit val clz: String = RTO.cls

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (RTO.fields (position), x))

        emitattrs (0, AdjacentCASet)
        emitattrs (1, AggregateNode)
        emitattrs (2, EnergyMarkets)
        emitattrs (3, FuelRegion)
        emitattrs (4, HostControlArea)
        emitattrs (5, LocalReliabilityArea)
        emitattrs (6, MSSAggregation)
        emitattrs (7, MktConnectivityNode)
        emitattrs (8, Pnodes)
        emitattrs (9, ResourceGroupReqs)
        emitattrs (10, SecurityConstraints)
        emitattrs (11, SecurityConstraintsLinear)
        emitattrs (12, SubControlArea)
        emitattrs (13, TransmissionContractRight)
        emitattrs (14, TransmissionRightChain)
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
    override val fields: Array[String] = Array [String](
        "AdjacentCASet",
        "AggregateNode",
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
    val AdjacentCASet: FielderMultiple = parse_attributes (attribute (cls, fields (0)))
    val AggregateNode: FielderMultiple = parse_attributes (attribute (cls, fields (1)))
    val EnergyMarkets: FielderMultiple = parse_attributes (attribute (cls, fields (2)))
    val FuelRegion: FielderMultiple = parse_attributes (attribute (cls, fields (3)))
    val HostControlArea: FielderMultiple = parse_attributes (attribute (cls, fields (4)))
    val LocalReliabilityArea: FielderMultiple = parse_attributes (attribute (cls, fields (5)))
    val MSSAggregation: FielderMultiple = parse_attributes (attribute (cls, fields (6)))
    val MktConnectivityNode: FielderMultiple = parse_attributes (attribute (cls, fields (7)))
    val Pnodes: FielderMultiple = parse_attributes (attribute (cls, fields (8)))
    val ResourceGroupReqs: FielderMultiple = parse_attributes (attribute (cls, fields (9)))
    val SecurityConstraints: FielderMultiple = parse_attributes (attribute (cls, fields (10)))
    val SecurityConstraintsLinear: FielderMultiple = parse_attributes (attribute (cls, fields (11)))
    val SubControlArea: FielderMultiple = parse_attributes (attribute (cls, fields (12)))
    val TransmissionContractRight: FielderMultiple = parse_attributes (attribute (cls, fields (13)))
    val TransmissionRightChain: FielderMultiple = parse_attributes (attribute (cls, fields (14)))

    def parse (context: Context): RTO =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = RTO (
            MktOrganisation.parse (context),
            masks (AdjacentCASet (), 0),
            masks (AggregateNode (), 1),
            masks (EnergyMarkets (), 2),
            masks (FuelRegion (), 3),
            masks (HostControlArea (), 4),
            masks (LocalReliabilityArea (), 5),
            masks (MSSAggregation (), 6),
            masks (MktConnectivityNode (), 7),
            masks (Pnodes (), 8),
            masks (ResourceGroupReqs (), 9),
            masks (SecurityConstraints (), 10),
            masks (SecurityConstraintsLinear (), 11),
            masks (SubControlArea (), 12),
            masks (TransmissionContractRight (), 13),
            masks (TransmissionRightChain (), 14)
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
 * @param sup                 [[ch.ninecode.model.AggregateNode AggregateNode]] Reference to the superclass object.
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
    def this () =
    {
        this (null, List ())
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def AggregateNode: AggregateNode = sup.asInstanceOf [AggregateNode]

    override def copy (): Row =
    {
        clone ().asInstanceOf [RUCZone]
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
    override val fields: Array[String] = Array [String](
        "LossClearingResults"
    )
    override val relations: List[Relationship] = List (
        Relationship ("LossClearingResults", "LossClearingResults", "0..*", "0..1")
    )
    val LossClearingResults: FielderMultiple = parse_attributes (attribute (cls, fields (0)))

    def parse (context: Context): RUCZone =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = RUCZone (
            AggregateNode.parse (context),
            masks (LossClearingResults (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Model of a generator  that is registered to participate in the market
 *
 * @param sup                             [[ch.ninecode.model.RegisteredResource RegisteredResource]] Reference to the superclass object.
 * @param capacityFactor                  Capacity Factor
 * @param coldStartTime                   Cold start time.
 * @param combinedCyclePlantName          Name of the Combined Cycle Plant (valid for Combined Cyle modes or configurations)
 * @param commericialOperationDate        <em>undocumented</em>
 * @param constrainedOutputFlag           Constrained Output Generator (COG) Indicator (Yes/No), per Generating Resource
 * @param costBasis                       <em>undocumented</em>
 * @param extremeLongStart                Some long-start up time units may need to receive start up instruction before DA market results are available.
 *                                        Long-Start resources may be either physical resources within the control with start-up times greater than 18 hours or the long-start contractual inter-tie commitment that shall be completed by 6 am one-day ahead.  Therefore, there is a need for a process to determine the commitment of such resources before the DA market.
 * @param fuelSource                      Values: Natural Gas Based Resource, Non Natural Gas Based Resource
 *                                        "NG" - Natural-Gas-Based Resource - a Resource that is powered by Natural Gas
 *                                        "NNG" - Non-Natural-Gas-Based Resource - a Resouce that is powered by some other fuel than Natural Gas
 * @param highControlLimit                High limit for secondary (AGC) control
 * @param hotIntTime                      Hot-to-intermediate time (Seasonal)
 * @param hotStartTime                    Hot start time.
 * @param intColdTime                     Intermediate-to-cold time (Seasonal)
 * @param intStartTime                    Intermediate start time.
 * @param intendedPIRP                    Provides an indication that this resource is intending to participate in the intermittent resource program.
 * @param loadFollowingDownMSS            Certifies resources for use in MSS Load Following Down
 * @param loadFollowingUpMSS              Certifies resources for use in MSS Load Following Up
 * @param lowControlLImit                 Low limit for secondary (AGC) control
 * @param lowerControlRate                Regulation down response rate in MW per minute
 * @param lowerRampRate                   <em>undocumented</em>
 * @param maxDependableCap                Maximum Dependable Capacity (MNDC).
 * @param maxLayOffSelfSchedQty           <em>undocumented</em>
 * @param maxMinLoadCost                  The registered maximum Minimum Load Cost of a Generating Resource registered with a Cost Basis of "Bid Cost".
 * @param maxPumpingLevel                 max pumping level of a hydro pump unit
 * @param maxShutdownTime                 Maximum time this device can be shut down.
 * @param maxStartUpsPerDay               maximum start ups per day
 * @param maxWeeklyEnergy                 Maximum weekly Energy (Seasonal)
 * @param maxWeeklyStarts                 Maximum weekly starts (seasonal parameter)
 * @param maximumAllowableSpinningReserve Maximum allowable spinning reserve.
 *                                        Spinning reserve will never be considered greater than this value regardless of the current operating point.
 * @param maximumOperatingMW              This is the maximum operating MW limit the dispatcher can enter for this unit
 * @param minLoadCost                     minimum load cost.
 *                                        Value is (currency/hr)
 * @param minimumLoadFuelCost             The cost for the fuel required to get a Generating Resource to operate at the minimum load level
 * @param minimumOperatingMW              This is the minimum operating MW limit the dispatcher can enter for this unit.
 * @param mustOfferRA                     Flag to indicate that this unit is a resource adequacy resource and must offer.
 * @param nameplateCapacity               MW value stated on the nameplate of the Generator -- the value it potentially could provide.
 * @param operatingMaintenanceCost        The portion of the Operating Cost of a Generating Resource that is not related to fuel cost.
 * @param operatingMode                   Combined Cycle operating mode.
 * @param proxyFlag                       <em>undocumented</em>
 * @param pumpMinDownTime                 The minimum down time for the pump in a pump storage unit.
 * @param pumpMinUpTime                   The minimum up time aspect for the pump in a pump storage unit
 * @param pumpShutdownCost                The cost to shutdown a pump during the pump aspect of a pump storage unit.
 * @param pumpShutdownTime                The shutdown time (minutes) of the pump aspect of a pump storage unit.
 * @param pumpingCost                     <em>undocumented</em>
 * @param pumpingFactor                   Pumping factor for pump storage units, conversion factor between generating and pumping.
 * @param qualifyingFacilityOwner         <em>undocumented</em>
 * @param quickStartFlag                  Quick start flag (Yes/No)
 * @param raiseControlRate                Regulation up response rate in MW per minute
 * @param raiseRampRate                   <em>undocumented</em>
 * @param rampCurveType                   Ramp curve type:
 *                                        0 - Fixed ramp rate independent of rate function unit MW output
 *                                        1 - Static ramp rates as a function of unit MW output only
 *                                        2 - Dynamic ramp rates as a function of unit MW output and ramping time
 * @param rampMode                        Ramping mode
 *                                        0: ignore ramping limits
 *                                        1: 20-minute ramping rule
 *                                        2: 60-minute ramping rule
 * @param regulationFlag                  0 = Unit is not on regulation
 *                                        1 = Unit is on AGC and regulating
 *                                        2 = Unit is suppose to be on regulation but it is not under regulation now
 * @param regulationRampRate              For the outage scheduling services
 * @param resourceSubType                 CCGT90	Combined Cycle greater than 90 MW
 *                                        CCLE90	Combined Cycle less than or equal to 90 MW
 *                                        CLLIG	Coal and Lignite
 *                                        DSL	Diesel
 *                                        GASSTM	Gas-Steam
 *                                        GSNONR	Gas Steam Non-Reheat Boiler
 *                                        GSREH	Gas Steam Reheat Boiler
 *                                        GSSUP	Gas Steam Supercritical Boiler
 *                                        HYDRO	Hydro
 *                                        NUC	Nuclear
 *                                        RENEW	Renewable
 *                                        SCGT90	Simple Cycle greater than 90 MW
 *                                        SCLE90	Simple Cycle less than or equal to 90 MW
 *                                        WIND	Wind
 *                                        PS         Pumped Storage
 * @param riverSystem                     River System the Resource is tied to.
 * @param spinReserveRamp                 <em>undocumented</em>
 * @param syncCondCapable                 Is the Resource Synchronous Condenser capable Resource?
 * @param unitType                        Generating unit type: Combined Cycle, Gas Turbine, Hydro Turbine, Other, Photovoltaic, Hydro Pump-Turbine, Reciprocating Engine, Steam Turbine, Synchronous Condenser, Wind Turbine
 * @param useLimitFlag                    Use limit flag: indicates if the use-limited resource is fully scheduled (or has some slack for real-time dispatch) (Y/N)
 * @param AuxillaryObject                 [[ch.ninecode.model.AuxiliaryObject AuxiliaryObject]] <em>undocumented</em>
 * @param EnergyPriceIndex                [[ch.ninecode.model.EnergyPriceIndex EnergyPriceIndex]] <em>undocumented</em>
 * @param FuelCostCurve                   [[ch.ninecode.model.FuelCostCurve FuelCostCurve]] <em>undocumented</em>
 * @param FuelRegion                      [[ch.ninecode.model.FuelRegion FuelRegion]] <em>undocumented</em>
 * @param GeneratingBids                  [[ch.ninecode.model.GeneratingBid GeneratingBid]] <em>undocumented</em>
 * @param LocalReliabilityArea            [[ch.ninecode.model.LocalReliabilityArea LocalReliabilityArea]] <em>undocumented</em>
 * @param MktGeneratingUnit               [[ch.ninecode.model.MktGeneratingUnit MktGeneratingUnit]] <em>undocumented</em>
 * @param MktHeatRateCurve                [[ch.ninecode.model.MktHeatRateCurve MktHeatRateCurve]] <em>undocumented</em>
 * @param RMNRFlag                        Reliability must not run (RMNR) flag: indicated whether the RMR unit is set as an RMNR in the current market
 * @param RMRFlag                         Reliability must run (RMR) flag: indicates whether the unit is RMR; Indicates whether the unit is RMR:
 *                                        N' - not an RMR unit
 *                                        '1' - RMR Condition 1 unit
 *                                        '2' - RMR Condition 2 unit
 * @param RMRHeatRateCurve                [[ch.ninecode.model.RMRHeatRateCurve RMRHeatRateCurve]] <em>undocumented</em>
 * @param RMRManualIndicator              Indicates the RMR Manual pre-determination status [Y/N]
 * @param RMRStartUpCostCurve             [[ch.ninecode.model.RMRStartUpCostCurve RMRStartUpCostCurve]] <em>undocumented</em>
 * @param RMRStartUpEnergyCurve           [[ch.ninecode.model.RMRStartUpEnergyCurve RMRStartUpEnergyCurve]] <em>undocumented</em>
 * @param RMRStartUpFuelCurve             [[ch.ninecode.model.RMRStartUpFuelCurve RMRStartUpFuelCurve]] <em>undocumented</em>
 * @param RMRStartUpTimeCurve             [[ch.ninecode.model.RMRStartUpTimeCurve RMRStartUpTimeCurve]] <em>undocumented</em>
 * @param RMTFlag                         Reliability must take (RMT) flag (Yes/No): indicates whether the unit is RMT
 * @param RegulatingLimit                 [[ch.ninecode.model.RegulatingLimit RegulatingLimit]] <em>undocumented</em>
 * @param StartUpCostCurves               [[ch.ninecode.model.StartUpCostCurve StartUpCostCurve]] <em>undocumented</em>
 * @param StartUpEnergyCurve              [[ch.ninecode.model.StartUpEnergyCurve StartUpEnergyCurve]] <em>undocumented</em>
 * @param StartUpFuelCurve                [[ch.ninecode.model.StartUpFuelCurve StartUpFuelCurve]] <em>undocumented</em>
 * @param StartUpTimeCurve                [[ch.ninecode.model.StartUpTimeCurve StartUpTimeCurve]] <em>undocumented</em>
 * @param Trade                           [[ch.ninecode.model.Trade Trade]] <em>undocumented</em>
 * @param UnitInitialConditions           [[ch.ninecode.model.UnitInitialConditions UnitInitialConditions]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
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
    minimumLoadFuelCost: Double,
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
    AuxillaryObject: List[String],
    EnergyPriceIndex: String,
    FuelCostCurve: String,
    FuelRegion: String,
    GeneratingBids: List[String],
    LocalReliabilityArea: String,
    MktGeneratingUnit: List[String],
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
    def this () =
    {
        this (null, 0.0, 0.0, null, null, null, null, null, null, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, 0, 0.0, 0, 0.0, 0.0, 0.0, 0.0, 0.0, null, 0.0, 0.0, null, null, 0.0, 0.0, 0.0, 0, 0.0, 0.0, null, null, 0.0, 0.0, null, null, 0, 0.0, null, null, 0.0, null, null, null, List (), null, null, null, List (), null, List (), null, null, null, null, null, null, null, null, null, null, null, List (), null, null, null, List (), List ())
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def RegisteredResource: RegisteredResource = sup.asInstanceOf [RegisteredResource]

    override def copy (): Row =
    {
        clone ().asInstanceOf [RegisteredGenerator]
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
        implicit val clz: String = RegisteredGenerator.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (RegisteredGenerator.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RegisteredGenerator.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (RegisteredGenerator.fields (position), x))

        emitelem (0, capacityFactor)
        emitelem (1, coldStartTime)
        emitelem (2, combinedCyclePlantName)
        emitelem (3, commericialOperationDate)
        emitattr (4, constrainedOutputFlag)
        emitattr (5, costBasis)
        emitattr (6, extremeLongStart)
        emitattr (7, fuelSource)
        emitelem (8, highControlLimit)
        emitelem (9, hotIntTime)
        emitelem (10, hotStartTime)
        emitelem (11, intColdTime)
        emitelem (12, intStartTime)
        emitattr (13, intendedPIRP)
        emitattr (14, loadFollowingDownMSS)
        emitattr (15, loadFollowingUpMSS)
        emitelem (16, lowControlLImit)
        emitelem (17, lowerControlRate)
        emitelem (18, lowerRampRate)
        emitelem (19, maxDependableCap)
        emitelem (20, maxLayOffSelfSchedQty)
        emitelem (21, maxMinLoadCost)
        emitelem (22, maxPumpingLevel)
        emitelem (23, maxShutdownTime)
        emitelem (24, maxStartUpsPerDay)
        emitelem (25, maxWeeklyEnergy)
        emitelem (26, maxWeeklyStarts)
        emitelem (27, maximumAllowableSpinningReserve)
        emitelem (28, maximumOperatingMW)
        emitelem (29, minLoadCost)
        emitelem (30, minimumLoadFuelCost)
        emitelem (31, minimumOperatingMW)
        emitattr (32, mustOfferRA)
        emitelem (33, nameplateCapacity)
        emitelem (34, operatingMaintenanceCost)
        emitelem (35, operatingMode)
        emitattr (36, proxyFlag)
        emitelem (37, pumpMinDownTime)
        emitelem (38, pumpMinUpTime)
        emitelem (39, pumpShutdownCost)
        emitelem (40, pumpShutdownTime)
        emitelem (41, pumpingCost)
        emitelem (42, pumpingFactor)
        emitelem (43, qualifyingFacilityOwner)
        emitattr (44, quickStartFlag)
        emitelem (45, raiseControlRate)
        emitelem (46, raiseRampRate)
        emitattr (47, rampCurveType)
        emitattr (48, rampMode)
        emitelem (49, regulationFlag)
        emitelem (50, regulationRampRate)
        emitelem (51, resourceSubType)
        emitelem (52, riverSystem)
        emitelem (53, spinReserveRamp)
        emitattr (54, syncCondCapable)
        emitattr (55, unitType)
        emitattr (56, useLimitFlag)
        emitattrs (57, AuxillaryObject)
        emitattr (58, EnergyPriceIndex)
        emitattr (59, FuelCostCurve)
        emitattr (60, FuelRegion)
        emitattrs (61, GeneratingBids)
        emitattr (62, LocalReliabilityArea)
        emitattrs (63, MktGeneratingUnit)
        emitattr (64, MktHeatRateCurve)
        emitattr (65, RMNRFlag)
        emitattr (66, RMRFlag)
        emitattr (67, RMRHeatRateCurve)
        emitattr (68, RMRManualIndicator)
        emitattr (69, RMRStartUpCostCurve)
        emitattr (70, RMRStartUpEnergyCurve)
        emitattr (71, RMRStartUpFuelCurve)
        emitattr (72, RMRStartUpTimeCurve)
        emitattr (73, RMTFlag)
        emitattr (74, RegulatingLimit)
        emitattrs (75, StartUpCostCurves)
        emitattr (76, StartUpEnergyCurve)
        emitattr (77, StartUpFuelCurve)
        emitattr (78, StartUpTimeCurve)
        emitattrs (79, Trade)
        emitattrs (80, UnitInitialConditions)
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
    override val fields: Array[String] = Array [String](
        "capacityFactor",
        "coldStartTime",
        "combinedCyclePlantName",
        "commericialOperationDate",
        "constrainedOutputFlag",
        "costBasis",
        "extremeLongStart",
        "fuelSource",
        "highControlLimit",
        "hotIntTime",
        "hotStartTime",
        "intColdTime",
        "intStartTime",
        "intendedPIRP",
        "loadFollowingDownMSS",
        "loadFollowingUpMSS",
        "lowControlLImit",
        "lowerControlRate",
        "lowerRampRate",
        "maxDependableCap",
        "maxLayOffSelfSchedQty",
        "maxMinLoadCost",
        "maxPumpingLevel",
        "maxShutdownTime",
        "maxStartUpsPerDay",
        "maxWeeklyEnergy",
        "maxWeeklyStarts",
        "maximumAllowableSpinningReserve",
        "maximumOperatingMW",
        "minLoadCost",
        "minimumLoadFuelCost",
        "minimumOperatingMW",
        "mustOfferRA",
        "nameplateCapacity",
        "operatingMaintenanceCost",
        "operatingMode",
        "proxyFlag",
        "pumpMinDownTime",
        "pumpMinUpTime",
        "pumpShutdownCost",
        "pumpShutdownTime",
        "pumpingCost",
        "pumpingFactor",
        "qualifyingFacilityOwner",
        "quickStartFlag",
        "raiseControlRate",
        "raiseRampRate",
        "rampCurveType",
        "rampMode",
        "regulationFlag",
        "regulationRampRate",
        "resourceSubType",
        "riverSystem",
        "spinReserveRamp",
        "syncCondCapable",
        "unitType",
        "useLimitFlag",
        "AuxillaryObject",
        "EnergyPriceIndex",
        "FuelCostCurve",
        "FuelRegion",
        "GeneratingBids",
        "LocalReliabilityArea",
        "MktGeneratingUnit",
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
        Relationship ("MktGeneratingUnit", "MktGeneratingUnit", "0..*", "0..1"),
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
    val capacityFactor: Fielder = parse_element (element (cls, fields (0)))
    val coldStartTime: Fielder = parse_element (element (cls, fields (1)))
    val combinedCyclePlantName: Fielder = parse_element (element (cls, fields (2)))
    val commericialOperationDate: Fielder = parse_element (element (cls, fields (3)))
    val constrainedOutputFlag: Fielder = parse_attribute (attribute (cls, fields (4)))
    val costBasis: Fielder = parse_attribute (attribute (cls, fields (5)))
    val extremeLongStart: Fielder = parse_attribute (attribute (cls, fields (6)))
    val fuelSource: Fielder = parse_attribute (attribute (cls, fields (7)))
    val highControlLimit: Fielder = parse_element (element (cls, fields (8)))
    val hotIntTime: Fielder = parse_element (element (cls, fields (9)))
    val hotStartTime: Fielder = parse_element (element (cls, fields (10)))
    val intColdTime: Fielder = parse_element (element (cls, fields (11)))
    val intStartTime: Fielder = parse_element (element (cls, fields (12)))
    val intendedPIRP: Fielder = parse_attribute (attribute (cls, fields (13)))
    val loadFollowingDownMSS: Fielder = parse_attribute (attribute (cls, fields (14)))
    val loadFollowingUpMSS: Fielder = parse_attribute (attribute (cls, fields (15)))
    val lowControlLImit: Fielder = parse_element (element (cls, fields (16)))
    val lowerControlRate: Fielder = parse_element (element (cls, fields (17)))
    val lowerRampRate: Fielder = parse_element (element (cls, fields (18)))
    val maxDependableCap: Fielder = parse_element (element (cls, fields (19)))
    val maxLayOffSelfSchedQty: Fielder = parse_element (element (cls, fields (20)))
    val maxMinLoadCost: Fielder = parse_element (element (cls, fields (21)))
    val maxPumpingLevel: Fielder = parse_element (element (cls, fields (22)))
    val maxShutdownTime: Fielder = parse_element (element (cls, fields (23)))
    val maxStartUpsPerDay: Fielder = parse_element (element (cls, fields (24)))
    val maxWeeklyEnergy: Fielder = parse_element (element (cls, fields (25)))
    val maxWeeklyStarts: Fielder = parse_element (element (cls, fields (26)))
    val maximumAllowableSpinningReserve: Fielder = parse_element (element (cls, fields (27)))
    val maximumOperatingMW: Fielder = parse_element (element (cls, fields (28)))
    val minLoadCost: Fielder = parse_element (element (cls, fields (29)))
    val minimumLoadFuelCost: Fielder = parse_element (element (cls, fields (30)))
    val minimumOperatingMW: Fielder = parse_element (element (cls, fields (31)))
    val mustOfferRA: Fielder = parse_attribute (attribute (cls, fields (32)))
    val nameplateCapacity: Fielder = parse_element (element (cls, fields (33)))
    val operatingMaintenanceCost: Fielder = parse_element (element (cls, fields (34)))
    val operatingMode: Fielder = parse_element (element (cls, fields (35)))
    val proxyFlag: Fielder = parse_attribute (attribute (cls, fields (36)))
    val pumpMinDownTime: Fielder = parse_element (element (cls, fields (37)))
    val pumpMinUpTime: Fielder = parse_element (element (cls, fields (38)))
    val pumpShutdownCost: Fielder = parse_element (element (cls, fields (39)))
    val pumpShutdownTime: Fielder = parse_element (element (cls, fields (40)))
    val pumpingCost: Fielder = parse_element (element (cls, fields (41)))
    val pumpingFactor: Fielder = parse_element (element (cls, fields (42)))
    val qualifyingFacilityOwner: Fielder = parse_element (element (cls, fields (43)))
    val quickStartFlag: Fielder = parse_attribute (attribute (cls, fields (44)))
    val raiseControlRate: Fielder = parse_element (element (cls, fields (45)))
    val raiseRampRate: Fielder = parse_element (element (cls, fields (46)))
    val rampCurveType: Fielder = parse_attribute (attribute (cls, fields (47)))
    val rampMode: Fielder = parse_attribute (attribute (cls, fields (48)))
    val regulationFlag: Fielder = parse_element (element (cls, fields (49)))
    val regulationRampRate: Fielder = parse_element (element (cls, fields (50)))
    val resourceSubType: Fielder = parse_element (element (cls, fields (51)))
    val riverSystem: Fielder = parse_element (element (cls, fields (52)))
    val spinReserveRamp: Fielder = parse_element (element (cls, fields (53)))
    val syncCondCapable: Fielder = parse_attribute (attribute (cls, fields (54)))
    val unitType: Fielder = parse_attribute (attribute (cls, fields (55)))
    val useLimitFlag: Fielder = parse_attribute (attribute (cls, fields (56)))
    val AuxillaryObject: FielderMultiple = parse_attributes (attribute (cls, fields (57)))
    val EnergyPriceIndex: Fielder = parse_attribute (attribute (cls, fields (58)))
    val FuelCostCurve: Fielder = parse_attribute (attribute (cls, fields (59)))
    val FuelRegion: Fielder = parse_attribute (attribute (cls, fields (60)))
    val GeneratingBids: FielderMultiple = parse_attributes (attribute (cls, fields (61)))
    val LocalReliabilityArea: Fielder = parse_attribute (attribute (cls, fields (62)))
    val MktGeneratingUnit: FielderMultiple = parse_attributes (attribute (cls, fields (63)))
    val MktHeatRateCurve: Fielder = parse_attribute (attribute (cls, fields (64)))
    val RMNRFlag: Fielder = parse_attribute (attribute (cls, fields (65)))
    val RMRFlag: Fielder = parse_attribute (attribute (cls, fields (66)))
    val RMRHeatRateCurve: Fielder = parse_attribute (attribute (cls, fields (67)))
    val RMRManualIndicator: Fielder = parse_attribute (attribute (cls, fields (68)))
    val RMRStartUpCostCurve: Fielder = parse_attribute (attribute (cls, fields (69)))
    val RMRStartUpEnergyCurve: Fielder = parse_attribute (attribute (cls, fields (70)))
    val RMRStartUpFuelCurve: Fielder = parse_attribute (attribute (cls, fields (71)))
    val RMRStartUpTimeCurve: Fielder = parse_attribute (attribute (cls, fields (72)))
    val RMTFlag: Fielder = parse_attribute (attribute (cls, fields (73)))
    val RegulatingLimit: Fielder = parse_attribute (attribute (cls, fields (74)))
    val StartUpCostCurves: FielderMultiple = parse_attributes (attribute (cls, fields (75)))
    val StartUpEnergyCurve: Fielder = parse_attribute (attribute (cls, fields (76)))
    val StartUpFuelCurve: Fielder = parse_attribute (attribute (cls, fields (77)))
    val StartUpTimeCurve: Fielder = parse_attribute (attribute (cls, fields (78)))
    val Trade: FielderMultiple = parse_attributes (attribute (cls, fields (79)))
    val UnitInitialConditions: FielderMultiple = parse_attributes (attribute (cls, fields (80)))

    def parse (context: Context): RegisteredGenerator =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0, 0, 0)
        val ret = RegisteredGenerator (
            RegisteredResource.parse (context),
            toDouble (mask (capacityFactor (), 0)),
            toDouble (mask (coldStartTime (), 1)),
            mask (combinedCyclePlantName (), 2),
            mask (commericialOperationDate (), 3),
            mask (constrainedOutputFlag (), 4),
            mask (costBasis (), 5),
            mask (extremeLongStart (), 6),
            mask (fuelSource (), 7),
            toDouble (mask (highControlLimit (), 8)),
            toDouble (mask (hotIntTime (), 9)),
            toDouble (mask (hotStartTime (), 10)),
            toDouble (mask (intColdTime (), 11)),
            toDouble (mask (intStartTime (), 12)),
            mask (intendedPIRP (), 13),
            mask (loadFollowingDownMSS (), 14),
            mask (loadFollowingUpMSS (), 15),
            toDouble (mask (lowControlLImit (), 16)),
            toDouble (mask (lowerControlRate (), 17)),
            toDouble (mask (lowerRampRate (), 18)),
            toDouble (mask (maxDependableCap (), 19)),
            toDouble (mask (maxLayOffSelfSchedQty (), 20)),
            toDouble (mask (maxMinLoadCost (), 21)),
            toDouble (mask (maxPumpingLevel (), 22)),
            mask (maxShutdownTime (), 23),
            toInteger (mask (maxStartUpsPerDay (), 24)),
            toDouble (mask (maxWeeklyEnergy (), 25)),
            toInteger (mask (maxWeeklyStarts (), 26)),
            toDouble (mask (maximumAllowableSpinningReserve (), 27)),
            toDouble (mask (maximumOperatingMW (), 28)),
            toDouble (mask (minLoadCost (), 29)),
            toDouble (mask (minimumLoadFuelCost (), 30)),
            toDouble (mask (minimumOperatingMW (), 31)),
            mask (mustOfferRA (), 32),
            toDouble (mask (nameplateCapacity (), 33)),
            toDouble (mask (operatingMaintenanceCost (), 34)),
            mask (operatingMode (), 35),
            mask (proxyFlag (), 36),
            toDouble (mask (pumpMinDownTime (), 37)),
            toDouble (mask (pumpMinUpTime (), 38)),
            toDouble (mask (pumpShutdownCost (), 39)),
            toInteger (mask (pumpShutdownTime (), 40)),
            toDouble (mask (pumpingCost (), 41)),
            toDouble (mask (pumpingFactor (), 42)),
            mask (qualifyingFacilityOwner (), 43),
            mask (quickStartFlag (), 44),
            toDouble (mask (raiseControlRate (), 45)),
            toDouble (mask (raiseRampRate (), 46)),
            mask (rampCurveType (), 47),
            mask (rampMode (), 48),
            toInteger (mask (regulationFlag (), 49)),
            toDouble (mask (regulationRampRate (), 50)),
            mask (resourceSubType (), 51),
            mask (riverSystem (), 52),
            toDouble (mask (spinReserveRamp (), 53)),
            mask (syncCondCapable (), 54),
            mask (unitType (), 55),
            mask (useLimitFlag (), 56),
            masks (AuxillaryObject (), 57),
            mask (EnergyPriceIndex (), 58),
            mask (FuelCostCurve (), 59),
            mask (FuelRegion (), 60),
            masks (GeneratingBids (), 61),
            mask (LocalReliabilityArea (), 62),
            masks (MktGeneratingUnit (), 63),
            mask (MktHeatRateCurve (), 64),
            mask (RMNRFlag (), 65),
            mask (RMRFlag (), 66),
            mask (RMRHeatRateCurve (), 67),
            mask (RMRManualIndicator (), 68),
            mask (RMRStartUpCostCurve (), 69),
            mask (RMRStartUpEnergyCurve (), 70),
            mask (RMRStartUpFuelCurve (), 71),
            mask (RMRStartUpTimeCurve (), 72),
            mask (RMTFlag (), 73),
            mask (RegulatingLimit (), 74),
            masks (StartUpCostCurves (), 75),
            mask (StartUpEnergyCurve (), 76),
            mask (StartUpFuelCurve (), 77),
            mask (StartUpTimeCurve (), 78),
            masks (Trade (), 79),
            masks (UnitInitialConditions (), 80)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * This class represents the inter tie resource.
 *
 * @param sup                      [[ch.ninecode.model.RegisteredResource RegisteredResource]] Reference to the superclass object.
 * @param direction                indicate the direction (export/import) of an intertie resource
 * @param energyProductType        Under each major product type, the commodity type can be applied to further specify the type.
 * @param isDCTie                  Flag to indicated whether this Inter-tie is a DC Tie.
 * @param isDynamicInterchange     check if the inter-tie resource is registered for the dynamic interchange..
 * @param minHourlyBlockLimit      The registered upper bound of minimum hourly block for an Inter-Tie Resource
 * @param Flowgate                 [[ch.ninecode.model.Flowgate Flowgate]] <em>undocumented</em>
 * @param InterTieBid              [[ch.ninecode.model.InterTieBid InterTieBid]] <em>undocumented</em>
 * @param InterTieDispatchResponse [[ch.ninecode.model.InterTieDispatchResponse InterTieDispatchResponse]] <em>undocumented</em>
 * @param InterchangeSchedule      [[ch.ninecode.model.InterchangeSchedule InterchangeSchedule]] <em>undocumented</em>
 * @param WheelingCounterParty     [[ch.ninecode.model.WheelingCounterParty WheelingCounterParty]] <em>undocumented</em>
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
    def this () =
    {
        this (null, null, null, null, null, 0, null, null, List (), List (), List ())
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def RegisteredResource: RegisteredResource = sup.asInstanceOf [RegisteredResource]

    override def copy (): Row =
    {
        clone ().asInstanceOf [RegisteredInterTie]
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
    override val fields: Array[String] = Array [String](
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
    val direction: Fielder = parse_attribute (attribute (cls, fields (0)))
    val energyProductType: Fielder = parse_attribute (attribute (cls, fields (1)))
    val isDCTie: Fielder = parse_attribute (attribute (cls, fields (2)))
    val isDynamicInterchange: Fielder = parse_attribute (attribute (cls, fields (3)))
    val minHourlyBlockLimit: Fielder = parse_element (element (cls, fields (4)))
    val Flowgate: Fielder = parse_attribute (attribute (cls, fields (5)))
    val InterTieBid: Fielder = parse_attribute (attribute (cls, fields (6)))
    val InterTieDispatchResponse: FielderMultiple = parse_attributes (attribute (cls, fields (7)))
    val InterchangeSchedule: FielderMultiple = parse_attributes (attribute (cls, fields (8)))
    val WheelingCounterParty: FielderMultiple = parse_attributes (attribute (cls, fields (9)))

    def parse (context: Context): RegisteredInterTie =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
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
 * Model of a load that is registered to participate in the market (demand reduction)
 *
 * @param sup                                   [[ch.ninecode.model.RegisteredResource RegisteredResource]] Reference to the superclass object.
 * @param blockLoadTransferFlag                 Flag to indicate that the Resource is Block Load pseudo resource (&lsquo;Y&rsquo;, &lsquo; N&rsquo;)
 * @param dynamicallyScheduledLoadResourceFlag  Flag to indicate that a Load Resource is part of a DSR Load
 * @param dynamicallyScheduledQualificationFlag Qualification status (used for DSR qualification)
 * @param loadRegistryMSS                       Non-participating load registry as a MSS load
 * @param maxBaseLoad                           Maximum Base Load (MW), per Participating Load Resource
 * @param maxDeploymentTime                     Maximum Deployment time (seconds)
 * @param maxLoadRedTimesPerDay                 Maximum Number of Daily Load Curtailments
 * @param maxLoadReduction                      maximum load reduction
 * @param maxReductionTime                      Maxiimum Load Reduction Time (min), per Participating Load Resource
 * @param maxWeeklyDeployment                   Maximum weekly deployments
 * @param minLoadReduction                      Minimum MW for a load reduction (e.g., MW rating of a discrete pump.
 *                                              This attribute may be used also in the LoadBid class. The reason that the attribute is also modeled in this class is that it is resource attribute and needs to be persistently stored.
 * @param minLoadReductionCost                  minimum load reduction cost.
 *                                              Single number for the load
 * @param minLoadReductionInterval              Shortest period load reduction shall be maintained before load can be restored to normal levels.
 *                                              This attribute may be used also in the LoadBid class. The reason that the attribute is also modeled in this class is that it is resource attribute and needs to be persistently stored.
 * @param minReductionTime                      Minimum Load Reduction Time (min), per Participating Load Resource
 * @param minTimeBetLoadRed                     Shortest time that load shall be left at normal levels before a new load reduction.
 *                                              This attribute may be used also in the LoadBid class. The reason that the attribute is also modeled in this class is that it is resource attribute and needs to be persistently stored.
 * @param participatingLoad                     Participating Load flag: indicates whether the load resource is participates in load reduction actions.
 * @param reqNoticeTime                         Time period that is required from an order to reduce a load to the time that it takes to get to the minimum load reduction.
 *                                              This attribute may be used also in the LoadBid class. The reason that the attribute is also modeled in this class is that it is resource attribute and needs to be persistently stored.
 * @param resourceSubType                       CLR	Controllable Load
 *                                              NCLR	Non-Controllable Load
 * @param AuxillaryObject                       [[ch.ninecode.model.AuxiliaryObject AuxiliaryObject]] <em>undocumented</em>
 * @param LoadBids                              [[ch.ninecode.model.LoadBid LoadBid]] <em>undocumented</em>
 * @param LoadReductionPriceCurve               [[ch.ninecode.model.LoadReductionPriceCurve LoadReductionPriceCurve]] <em>undocumented</em>
 * @param LoadReductionTimeCurve                [[ch.ninecode.model.LoadReductionTimeCurve LoadReductionTimeCurve]] <em>undocumented</em>
 * @param MktEnergyConsumer                     [[ch.ninecode.model.MktEnergyConsumer MktEnergyConsumer]] <em>undocumented</em>
 * @param MktLoadArea                           [[ch.ninecode.model.MktLoadArea MktLoadArea]] <em>undocumented</em>
 * @param NPLCustomLoadAggregation              A Non-Participating Load Resource aggregation scheme with resource-specific Distribution Factors that are submitted with the Bid and for which the distributed Energy is settled at the relevant Distribution Location marginal prices.
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
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
    AuxillaryObject: List[String],
    LoadBids: List[String],
    LoadReductionPriceCurve: List[String],
    LoadReductionTimeCurve: List[String],
    MktEnergyConsumer: List[String],
    MktLoadArea: String,
    NPLCustomLoadAggregation: String
)
    extends
        Element
{
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, null, null, null, null, 0.0, 0.0, 0, 0.0, 0.0, 0, 0.0, 0.0, 0.0, 0.0, 0.0, null, 0.0, null, List (), List (), List (), List (), List (), null, null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def RegisteredResource: RegisteredResource = sup.asInstanceOf [RegisteredResource]

    override def copy (): Row =
    {
        clone ().asInstanceOf [RegisteredLoad]
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
        implicit val clz: String = RegisteredLoad.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (RegisteredLoad.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RegisteredLoad.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (RegisteredLoad.fields (position), x))

        emitattr (0, blockLoadTransferFlag)
        emitattr (1, dynamicallyScheduledLoadResourceFlag)
        emitattr (2, dynamicallyScheduledQualificationFlag)
        emitattr (3, loadRegistryMSS)
        emitelem (4, maxBaseLoad)
        emitelem (5, maxDeploymentTime)
        emitelem (6, maxLoadRedTimesPerDay)
        emitelem (7, maxLoadReduction)
        emitelem (8, maxReductionTime)
        emitelem (9, maxWeeklyDeployment)
        emitelem (10, minLoadReduction)
        emitelem (11, minLoadReductionCost)
        emitelem (12, minLoadReductionInterval)
        emitelem (13, minReductionTime)
        emitelem (14, minTimeBetLoadRed)
        emitattr (15, participatingLoad)
        emitelem (16, reqNoticeTime)
        emitelem (17, resourceSubType)
        emitattrs (18, AuxillaryObject)
        emitattrs (19, LoadBids)
        emitattrs (20, LoadReductionPriceCurve)
        emitattrs (21, LoadReductionTimeCurve)
        emitattrs (22, MktEnergyConsumer)
        emitattr (23, MktLoadArea)
        emitattr (24, NPLCustomLoadAggregation)
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
    override val fields: Array[String] = Array [String](
        "blockLoadTransferFlag",
        "dynamicallyScheduledLoadResourceFlag",
        "dynamicallyScheduledQualificationFlag",
        "loadRegistryMSS",
        "maxBaseLoad",
        "maxDeploymentTime",
        "maxLoadRedTimesPerDay",
        "maxLoadReduction",
        "maxReductionTime",
        "maxWeeklyDeployment",
        "minLoadReduction",
        "minLoadReductionCost",
        "minLoadReductionInterval",
        "minReductionTime",
        "minTimeBetLoadRed",
        "participatingLoad",
        "reqNoticeTime",
        "resourceSubType",
        "AuxillaryObject",
        "LoadBids",
        "LoadReductionPriceCurve",
        "LoadReductionTimeCurve",
        "MktEnergyConsumer",
        "MktLoadArea",
        "NPLCustomLoadAggregation"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AuxillaryObject", "AuxiliaryObject", "0..*", "0..1"),
        Relationship ("LoadBids", "LoadBid", "0..*", "0..1"),
        Relationship ("LoadReductionPriceCurve", "LoadReductionPriceCurve", "0..*", "0..*"),
        Relationship ("LoadReductionTimeCurve", "LoadReductionTimeCurve", "0..*", "0..*"),
        Relationship ("MktEnergyConsumer", "MktEnergyConsumer", "0..*", "0..1"),
        Relationship ("MktLoadArea", "MktLoadArea", "1", "0..*")
    )
    val blockLoadTransferFlag: Fielder = parse_attribute (attribute (cls, fields (0)))
    val dynamicallyScheduledLoadResourceFlag: Fielder = parse_attribute (attribute (cls, fields (1)))
    val dynamicallyScheduledQualificationFlag: Fielder = parse_attribute (attribute (cls, fields (2)))
    val loadRegistryMSS: Fielder = parse_attribute (attribute (cls, fields (3)))
    val maxBaseLoad: Fielder = parse_element (element (cls, fields (4)))
    val maxDeploymentTime: Fielder = parse_element (element (cls, fields (5)))
    val maxLoadRedTimesPerDay: Fielder = parse_element (element (cls, fields (6)))
    val maxLoadReduction: Fielder = parse_element (element (cls, fields (7)))
    val maxReductionTime: Fielder = parse_element (element (cls, fields (8)))
    val maxWeeklyDeployment: Fielder = parse_element (element (cls, fields (9)))
    val minLoadReduction: Fielder = parse_element (element (cls, fields (10)))
    val minLoadReductionCost: Fielder = parse_element (element (cls, fields (11)))
    val minLoadReductionInterval: Fielder = parse_element (element (cls, fields (12)))
    val minReductionTime: Fielder = parse_element (element (cls, fields (13)))
    val minTimeBetLoadRed: Fielder = parse_element (element (cls, fields (14)))
    val participatingLoad: Fielder = parse_attribute (attribute (cls, fields (15)))
    val reqNoticeTime: Fielder = parse_element (element (cls, fields (16)))
    val resourceSubType: Fielder = parse_element (element (cls, fields (17)))
    val AuxillaryObject: FielderMultiple = parse_attributes (attribute (cls, fields (18)))
    val LoadBids: FielderMultiple = parse_attributes (attribute (cls, fields (19)))
    val LoadReductionPriceCurve: FielderMultiple = parse_attributes (attribute (cls, fields (20)))
    val LoadReductionTimeCurve: FielderMultiple = parse_attributes (attribute (cls, fields (21)))
    val MktEnergyConsumer: FielderMultiple = parse_attributes (attribute (cls, fields (22)))
    val MktLoadArea: Fielder = parse_attribute (attribute (cls, fields (23)))
    val NPLCustomLoadAggregation: Fielder = parse_attribute (attribute (cls, fields (24)))

    def parse (context: Context): RegisteredLoad =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = RegisteredLoad (
            RegisteredResource.parse (context),
            mask (blockLoadTransferFlag (), 0),
            mask (dynamicallyScheduledLoadResourceFlag (), 1),
            mask (dynamicallyScheduledQualificationFlag (), 2),
            mask (loadRegistryMSS (), 3),
            toDouble (mask (maxBaseLoad (), 4)),
            toDouble (mask (maxDeploymentTime (), 5)),
            toInteger (mask (maxLoadRedTimesPerDay (), 6)),
            toDouble (mask (maxLoadReduction (), 7)),
            toDouble (mask (maxReductionTime (), 8)),
            toInteger (mask (maxWeeklyDeployment (), 9)),
            toDouble (mask (minLoadReduction (), 10)),
            toDouble (mask (minLoadReductionCost (), 11)),
            toDouble (mask (minLoadReductionInterval (), 12)),
            toDouble (mask (minReductionTime (), 13)),
            toDouble (mask (minTimeBetLoadRed (), 14)),
            mask (participatingLoad (), 15),
            toDouble (mask (reqNoticeTime (), 16)),
            mask (resourceSubType (), 17),
            masks (AuxillaryObject (), 18),
            masks (LoadBids (), 19),
            masks (LoadReductionPriceCurve (), 20),
            masks (LoadReductionTimeCurve (), 21),
            masks (MktEnergyConsumer (), 22),
            mask (MktLoadArea (), 23),
            mask (NPLCustomLoadAggregation (), 24)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * This class represents the physical characteristc of a generator regarding the regulating limit
 *
 * @param sup                 [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param highLimit           <em>undocumented</em>
 * @param lowLimit            <em>undocumented</em>
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
    def this () =
    {
        this (null, 0.0, 0.0, null)
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
        clone ().asInstanceOf [RegulatingLimit]
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
    override val fields: Array[String] = Array [String](
        "highLimit",
        "lowLimit",
        "RegisteredGenerator"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RegisteredGenerator", "RegisteredGenerator", "0..1", "0..1")
    )
    val highLimit: Fielder = parse_element (element (cls, fields (0)))
    val lowLimit: Fielder = parse_element (element (cls, fields (1)))
    val RegisteredGenerator: Fielder = parse_attribute (attribute (cls, fields (2)))

    def parse (context: Context): RegulatingLimit =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
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
 * Ancillary Services that a resource is qualified to provide.
 *
 * @param sup                Reference to the superclass object.
 * @param certifiedCapacity  Certified capacity for associated resource and market type and ancillary service type product
 * @param endEffectiveDate   Ancillary Service Qualification end date
 * @param market             market type
 * @param qualificationFlag  Status of the qualification ('Y' = Active, 'N' = Inactive)
 * @param startEffectiveDate Ancillary Service Qualification effective from date
 * @param type               Type of service based on ResourceAncillaryServiceType enumeration
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] RegisteredResources are qualified for resource ancillary service types (which include market product types as well as other types such as BlackStart) by the association to the class ResourceAncillaryServiceQualification.
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class ResourceAncillaryServiceQualification
(
    override val sup: BasicElement,
    certifiedCapacity: Double,
    endEffectiveDate: String,
    market: String,
    qualificationFlag: String,
    startEffectiveDate: String,
    `type`: String,
    RegisteredResource: String
)
    extends
        Element
{
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, 0.0, null, null, null, null, null, null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Element: Element = sup.asInstanceOf [Element]

    override def copy (): Row =
    {
        clone ().asInstanceOf [ResourceAncillaryServiceQualification]
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
        implicit val clz: String = ResourceAncillaryServiceQualification.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ResourceAncillaryServiceQualification.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ResourceAncillaryServiceQualification.fields (position), value)

        emitelem (0, certifiedCapacity)
        emitelem (1, endEffectiveDate)
        emitattr (2, market)
        emitattr (3, qualificationFlag)
        emitelem (4, startEffectiveDate)
        emitattr (5, `type`)
        emitattr (6, RegisteredResource)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ResourceAncillaryServiceQualification rdf:ID=\"%s\">\n%s\t</cim:ResourceAncillaryServiceQualification>".format (id, export_fields)
    }
}

object ResourceAncillaryServiceQualification
    extends
        Parseable[ResourceAncillaryServiceQualification]
{
    override val fields: Array[String] = Array [String](
        "certifiedCapacity",
        "endEffectiveDate",
        "market",
        "qualificationFlag",
        "startEffectiveDate",
        "type",
        "RegisteredResource"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RegisteredResource", "RegisteredResource", "1", "0..*")
    )
    val certifiedCapacity: Fielder = parse_element (element (cls, fields (0)))
    val endEffectiveDate: Fielder = parse_element (element (cls, fields (1)))
    val market: Fielder = parse_attribute (attribute (cls, fields (2)))
    val qualificationFlag: Fielder = parse_attribute (attribute (cls, fields (3)))
    val startEffectiveDate: Fielder = parse_element (element (cls, fields (4)))
    val `type`: Fielder = parse_attribute (attribute (cls, fields (5)))
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields (6)))

    def parse (context: Context): ResourceAncillaryServiceQualification =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = ResourceAncillaryServiceQualification (
            BasicElement.parse (context),
            toDouble (mask (certifiedCapacity (), 0)),
            mask (endEffectiveDate (), 1),
            mask (market (), 2),
            mask (qualificationFlag (), 3),
            mask (startEffectiveDate (), 4),
            mask (`type` (), 5),
            mask (RegisteredResource (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * This class model the various capacities of a resource.
 *
 * A resource may have numbers of capacities related to operating, ancillary services, energy trade and so forth. The types are but not limited to:
 *
 * @param sup                Reference to the superclass object.
 * @param capacityType       capacity type
 *
 *                           The types are but not limited to:
 *
 *                           Regulation Up
 *                           Regulation Dn
 *                           Spinning Reserve
 *                           Non-Spinning Reserve
 *                           FOO capacity
 *                           MOO capacity
 * @param defaultCapacity    default capacity
 * @param maximumCapacity    maximum capacity
 * @param minimumCapacity    minimum capacity
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class ResourceCapacity
(
    override val sup: BasicElement,
    capacityType: String,
    defaultCapacity: Double,
    maximumCapacity: Double,
    minimumCapacity: Double,
    RegisteredResource: List[String]
)
    extends
        Element
{
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, null, 0.0, 0.0, 0.0, List ())
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Element: Element = sup.asInstanceOf [Element]

    override def copy (): Row =
    {
        clone ().asInstanceOf [ResourceCapacity]
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
        implicit val clz: String = ResourceCapacity.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ResourceCapacity.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ResourceCapacity.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (ResourceCapacity.fields (position), x))

        emitattr (0, capacityType)
        emitelem (1, defaultCapacity)
        emitelem (2, maximumCapacity)
        emitelem (3, minimumCapacity)
        emitattrs (4, RegisteredResource)
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
    override val fields: Array[String] = Array [String](
        "capacityType",
        "defaultCapacity",
        "maximumCapacity",
        "minimumCapacity",
        "RegisteredResource"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RegisteredResource", "RegisteredResource", "0..*", "0..*")
    )
    val capacityType: Fielder = parse_attribute (attribute (cls, fields (0)))
    val defaultCapacity: Fielder = parse_element (element (cls, fields (1)))
    val maximumCapacity: Fielder = parse_element (element (cls, fields (2)))
    val minimumCapacity: Fielder = parse_element (element (cls, fields (3)))
    val RegisteredResource: FielderMultiple = parse_attributes (attribute (cls, fields (4)))

    def parse (context: Context): ResourceCapacity =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = ResourceCapacity (
            BasicElement.parse (context),
            mask (capacityType (), 0),
            toDouble (mask (defaultCapacity (), 1)),
            toDouble (mask (maximumCapacity (), 2)),
            toDouble (mask (minimumCapacity (), 3)),
            masks (RegisteredResource (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * To model the Operation and Maintenance (O and M) costs of a generation resource.
 *
 * @param sup                                    [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param gasPercentAboveLowSustainedLimit       Percentage of Fuel Index Price (gas) for operating above Low Sustained Limit (LSL)
 * @param oilPercentAboveLowSustainedLimit       Percentage of Fuel Oil Price (FOP) for operating above Low Sustained Limit (LSL)
 * @param omCostColdStartup                      Verifiable O&amp;M Cost (\$), Cold Startup
 * @param omCostHotStartup                       Verifiable O&amp;M Cost (\$), Hot Startup
 * @param omCostIntermediateStartup              Verifiable O&amp;M Cost (\$), Intermediate Startup
 * @param omCostLowSustainedLimit                Verifiable O&amp;M Cost (\$/MWh), LSL
 * @param solidfuelPercentAboveLowSustainedLimit Percentage of Solid Fuel for operating above Low Sustained Limit (LSL)
 * @param ResourceVerifiableCosts                [[ch.ninecode.model.ResourceVerifiableCosts ResourceVerifiableCosts]] <em>undocumented</em>
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
    def this () =
    {
        this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Curve: Curve = sup.asInstanceOf [Curve]

    override def copy (): Row =
    {
        clone ().asInstanceOf [ResourceOperationMaintenanceCost]
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
    override val fields: Array[String] = Array [String](
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
    val gasPercentAboveLowSustainedLimit: Fielder = parse_element (element (cls, fields (0)))
    val oilPercentAboveLowSustainedLimit: Fielder = parse_element (element (cls, fields (1)))
    val omCostColdStartup: Fielder = parse_element (element (cls, fields (2)))
    val omCostHotStartup: Fielder = parse_element (element (cls, fields (3)))
    val omCostIntermediateStartup: Fielder = parse_element (element (cls, fields (4)))
    val omCostLowSustainedLimit: Fielder = parse_element (element (cls, fields (5)))
    val solidfuelPercentAboveLowSustainedLimit: Fielder = parse_element (element (cls, fields (6)))
    val ResourceVerifiableCosts: Fielder = parse_attribute (attribute (cls, fields (7)))

    def parse (context: Context): ResourceOperationMaintenanceCost =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
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
 * @param sup                                 Reference to the superclass object.
 * @param fuelColdStartup                     Verifiable Cold Start Up Fuel (MMBtu per start)
 * @param fuelHotStartup                      Verifiable Hot Start Up Fuel (MMBtu per start)
 * @param fuelIntermediateStartup             Verifiable Intermediate Start Up Fuel (MMBtu per start)
 * @param fuelLowSustainedLimit               Minimum-Energy fuel, MMBtu/MWh
 * @param gasPercentColdStartup               Percentage of Fuel Index Price (gas) for cold startup
 * @param gasPercentHotStartup                Percentage of Fuel Index Price (gas) for hot startup
 * @param gasPercentIntermediateStartup       Percentage of Fuel Index Price (gas) for intermediate startup
 * @param gasPercentLowSustainedLimit         Percentage of FIP (gas) for operating at LSL
 * @param oilPercentColdStartup               Percentage of Fuel Oil Price (FOP) for cold startup
 * @param oilPercentHotStartup                Percentage of Fuel Oil Price (FOP) for hot startup
 * @param oilPercentIntermediateStartup       Percentage of Fuel Oil Price (FOP) for intermediate startup
 * @param oilPercentLowSustainedLimit         Percentage of FOP (oil) for operating at LSL
 * @param solidfuelPercentColdStartup         Percentage of Solid Fuel for cold startup
 * @param solidfuelPercentHotStartup          Percentage of Solid Fuel for hot startup
 * @param solidfuelPercentIntermediateStartup Percentage of Solid Fuel for intermedite startup
 * @param solidfuelPercentLowSustainedLimit   Percentage of Solid Fuel for operating at LSL
 * @param ResourceVerifiableCosts             [[ch.ninecode.model.ResourceVerifiableCosts ResourceVerifiableCosts]] <em>undocumented</em>
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
    def this () =
    {
        this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Element: Element = sup.asInstanceOf [Element]

    override def copy (): Row =
    {
        clone ().asInstanceOf [ResourceStartupCost]
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
    override val fields: Array[String] = Array [String](
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
    val fuelColdStartup: Fielder = parse_element (element (cls, fields (0)))
    val fuelHotStartup: Fielder = parse_element (element (cls, fields (1)))
    val fuelIntermediateStartup: Fielder = parse_element (element (cls, fields (2)))
    val fuelLowSustainedLimit: Fielder = parse_element (element (cls, fields (3)))
    val gasPercentColdStartup: Fielder = parse_element (element (cls, fields (4)))
    val gasPercentHotStartup: Fielder = parse_element (element (cls, fields (5)))
    val gasPercentIntermediateStartup: Fielder = parse_element (element (cls, fields (6)))
    val gasPercentLowSustainedLimit: Fielder = parse_element (element (cls, fields (7)))
    val oilPercentColdStartup: Fielder = parse_element (element (cls, fields (8)))
    val oilPercentHotStartup: Fielder = parse_element (element (cls, fields (9)))
    val oilPercentIntermediateStartup: Fielder = parse_element (element (cls, fields (10)))
    val oilPercentLowSustainedLimit: Fielder = parse_element (element (cls, fields (11)))
    val solidfuelPercentColdStartup: Fielder = parse_element (element (cls, fields (12)))
    val solidfuelPercentHotStartup: Fielder = parse_element (element (cls, fields (13)))
    val solidfuelPercentIntermediateStartup: Fielder = parse_element (element (cls, fields (14)))
    val solidfuelPercentLowSustainedLimit: Fielder = parse_element (element (cls, fields (15)))
    val ResourceVerifiableCosts: Fielder = parse_attribute (attribute (cls, fields (16)))

    def parse (context: Context): ResourceStartupCost =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
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
 * @param sup                              Reference to the superclass object.
 * @param MktHeatRateCurve                 [[ch.ninecode.model.MktHeatRateCurve MktHeatRateCurve]] <em>undocumented</em>
 * @param RegisteredResource               [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @param ResourceOperationMaintenanceCost [[ch.ninecode.model.ResourceOperationMaintenanceCost ResourceOperationMaintenanceCost]] <em>undocumented</em>
 * @param ResourceStartupCost              [[ch.ninecode.model.ResourceStartupCost ResourceStartupCost]] <em>undocumented</em>
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
    def Element: Element = sup.asInstanceOf [Element]

    override def copy (): Row =
    {
        clone ().asInstanceOf [ResourceVerifiableCosts]
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
    override val fields: Array[String] = Array [String](
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
    val MktHeatRateCurve: Fielder = parse_attribute (attribute (cls, fields (0)))
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields (1)))
    val ResourceOperationMaintenanceCost: Fielder = parse_attribute (attribute (cls, fields (2)))
    val ResourceStartupCost: FielderMultiple = parse_attributes (attribute (cls, fields (3)))

    def parse (context: Context): ResourceVerifiableCosts =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
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
 * Market participants could be represented by Scheduling Coordinators (SCs) that are registered with the RTO/ISO.
 *
 * One participant could register multiple SCs with the RTO/ISO. Many market participants can do business with the RTO/ISO using a single SC. One SC could schedule multiple generators. A load scheduling point could be used by multiple SCs. Each SC could schedule load at multiple scheduling points. An inter-tie scheduling point can be used by multiple SCs. Each SC can schedule interchange at multiple inter-tie scheduling points.
 *
 * @param sup                       [[ch.ninecode.model.MktOrganisation MktOrganisation]] Reference to the superclass object.
 * @param scid                      This is the short name or Scheduling Coordinator ID field.
 * @param Bid                       [[ch.ninecode.model.Bid Bid]] <em>undocumented</em>
 * @param FromSCTrade               [[ch.ninecode.model.Trade Trade]] <em>undocumented</em>
 * @param LoadRatio                 [[ch.ninecode.model.LoadRatio LoadRatio]] <em>undocumented</em>
 * @param MktOrgansation            [[ch.ninecode.model.MktOrganisation MktOrganisation]] <em>undocumented</em>
 * @param SubmitFromSCTrade         [[ch.ninecode.model.Trade Trade]] <em>undocumented</em>
 * @param SubmitToSCTrade           [[ch.ninecode.model.Trade Trade]] <em>undocumented</em>
 * @param ToSCTrade                 [[ch.ninecode.model.Trade Trade]] <em>undocumented</em>
 * @param TransmissionContractRight [[ch.ninecode.model.ContractRight ContractRight]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class SchedulingCoordinator
(
    override val sup: MktOrganisation,
    scid: String,
    Bid: List[String],
    FromSCTrade: List[String],
    LoadRatio: String,
    MktOrgansation: String,
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
    def this () =
    {
        this (null, null, List (), List (), null, null, List (), List (), List (), List ())
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def MktOrganisation: MktOrganisation = sup.asInstanceOf [MktOrganisation]

    override def copy (): Row =
    {
        clone ().asInstanceOf [SchedulingCoordinator]
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
        implicit val clz: String = SchedulingCoordinator.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SchedulingCoordinator.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SchedulingCoordinator.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (SchedulingCoordinator.fields (position), x))

        emitelem (0, scid)
        emitattrs (1, Bid)
        emitattrs (2, FromSCTrade)
        emitattr (3, LoadRatio)
        emitattr (4, MktOrgansation)
        emitattrs (5, SubmitFromSCTrade)
        emitattrs (6, SubmitToSCTrade)
        emitattrs (7, ToSCTrade)
        emitattrs (8, TransmissionContractRight)
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
    override val fields: Array[String] = Array [String](
        "scid",
        "Bid",
        "FromSCTrade",
        "LoadRatio",
        "MktOrgansation",
        "SubmitFromSCTrade",
        "SubmitToSCTrade",
        "ToSCTrade",
        "TransmissionContractRight"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Bid", "Bid", "0..*", "0..1"),
        Relationship ("FromSCTrade", "Trade", "0..*", "1"),
        Relationship ("LoadRatio", "LoadRatio", "1", "0..1"),
        Relationship ("MktOrgansation", "MktOrganisation", "1", "0..*"),
        Relationship ("SubmitFromSCTrade", "Trade", "0..*", "0..1"),
        Relationship ("SubmitToSCTrade", "Trade", "0..*", "0..1"),
        Relationship ("ToSCTrade", "Trade", "0..*", "1"),
        Relationship ("TransmissionContractRight", "ContractRight", "0..*", "1")
    )
    val scid: Fielder = parse_element (element (cls, fields (0)))
    val Bid: FielderMultiple = parse_attributes (attribute (cls, fields (1)))
    val FromSCTrade: FielderMultiple = parse_attributes (attribute (cls, fields (2)))
    val LoadRatio: Fielder = parse_attribute (attribute (cls, fields (3)))
    val MktOrgansation: Fielder = parse_attribute (attribute (cls, fields (4)))
    val SubmitFromSCTrade: FielderMultiple = parse_attributes (attribute (cls, fields (5)))
    val SubmitToSCTrade: FielderMultiple = parse_attributes (attribute (cls, fields (6)))
    val ToSCTrade: FielderMultiple = parse_attributes (attribute (cls, fields (7)))
    val TransmissionContractRight: FielderMultiple = parse_attributes (attribute (cls, fields (8)))

    def parse (context: Context): SchedulingCoordinator =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = SchedulingCoordinator (
            MktOrganisation.parse (context),
            mask (scid (), 0),
            masks (Bid (), 1),
            masks (FromSCTrade (), 2),
            mask (LoadRatio (), 3),
            mask (MktOrgansation (), 4),
            masks (SubmitFromSCTrade (), 5),
            masks (SubmitToSCTrade (), 6),
            masks (ToSCTrade (), 7),
            masks (TransmissionContractRight (), 8)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Describing users of a Scheduling Coordinator
 *
 * @param sup                Reference to the superclass object.
 * @param endEffectiveDate   Login ID Expiration Date
 * @param loginID            Login ID
 * @param loginRole          Assigned roles (these are roles with either Read or Read/Write privileges on different Market Systems)
 * @param startEffectiveDate Login ID Effective Date
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class SchedulingCoordinatorUser
(
    override val sup: BasicElement,
    endEffectiveDate: String,
    loginID: String,
    loginRole: String,
    startEffectiveDate: String
)
    extends
        Element
{
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, null, null, null, null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Element: Element = sup.asInstanceOf [Element]

    override def copy (): Row =
    {
        clone ().asInstanceOf [SchedulingCoordinatorUser]
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
        implicit val clz: String = SchedulingCoordinatorUser.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SchedulingCoordinatorUser.fields (position), value)

        emitelem (0, endEffectiveDate)
        emitelem (1, loginID)
        emitelem (2, loginRole)
        emitelem (3, startEffectiveDate)
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
    override val fields: Array[String] = Array [String](
        "endEffectiveDate",
        "loginID",
        "loginRole",
        "startEffectiveDate"
    )
    val endEffectiveDate: Fielder = parse_element (element (cls, fields (0)))
    val loginID: Fielder = parse_element (element (cls, fields (1)))
    val loginRole: Fielder = parse_element (element (cls, fields (2)))
    val startEffectiveDate: Fielder = parse_element (element (cls, fields (3)))

    def parse (context: Context): SchedulingCoordinatorUser =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = SchedulingCoordinatorUser (
            BasicElement.parse (context),
            mask (endEffectiveDate (), 0),
            mask (loginID (), 1),
            mask (loginRole (), 2),
            mask (startEffectiveDate (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Connection to other organizations at the boundary of the ISO/RTO.
 *
 * @param sup                 [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param endEffectiveDate    End effective date.
 * @param startEffectiveDate  Start effective date.
 * @param Flowgate            [[ch.ninecode.model.Flowgate Flowgate]] <em>undocumented</em>
 * @param InterchangeSchedule [[ch.ninecode.model.InterchangeSchedule InterchangeSchedule]] <em>undocumented</em>
 * @param RegisteredResource  [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class SchedulingPoint
(
    override val sup: IdentifiedObject,
    endEffectiveDate: String,
    startEffectiveDate: String,
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
    def this () =
    {
        this (null, null, null, null, List (), List ())
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
        clone ().asInstanceOf [SchedulingPoint]
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
        implicit val clz: String = SchedulingPoint.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SchedulingPoint.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SchedulingPoint.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (SchedulingPoint.fields (position), x))

        emitelem (0, endEffectiveDate)
        emitelem (1, startEffectiveDate)
        emitattr (2, Flowgate)
        emitattrs (3, InterchangeSchedule)
        emitattrs (4, RegisteredResource)
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
    override val fields: Array[String] = Array [String](
        "endEffectiveDate",
        "startEffectiveDate",
        "Flowgate",
        "InterchangeSchedule",
        "RegisteredResource"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Flowgate", "Flowgate", "0..1", "0..*"),
        Relationship ("InterchangeSchedule", "InterchangeSchedule", "0..*", "0..1"),
        Relationship ("RegisteredResource", "RegisteredResource", "0..*", "0..*")
    )
    val endEffectiveDate: Fielder = parse_element (element (cls, fields (0)))
    val startEffectiveDate: Fielder = parse_element (element (cls, fields (1)))
    val Flowgate: Fielder = parse_attribute (attribute (cls, fields (2)))
    val InterchangeSchedule: FielderMultiple = parse_attributes (attribute (cls, fields (3)))
    val RegisteredResource: FielderMultiple = parse_attributes (attribute (cls, fields (4)))

    def parse (context: Context): SchedulingPoint =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = SchedulingPoint (
            IdentifiedObject.parse (context),
            mask (endEffectiveDate (), 0),
            mask (startEffectiveDate (), 1),
            mask (Flowgate (), 2),
            masks (InterchangeSchedule (), 3),
            masks (RegisteredResource (), 4)
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
 * @param sup                 [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
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
    def this () =
    {
        this (null, null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Curve: Curve = sup.asInstanceOf [Curve]

    override def copy (): Row =
    {
        clone ().asInstanceOf [StartUpEnergyCurve]
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
    override val fields: Array[String] = Array [String](
        "RegisteredGenerator"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RegisteredGenerator", "RegisteredGenerator", "0..1", "0..1")
    )
    val RegisteredGenerator: Fielder = parse_attribute (attribute (cls, fields (0)))

    def parse (context: Context): StartUpEnergyCurve =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = StartUpEnergyCurve (
            Curve.parse (context),
            mask (RegisteredGenerator (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The fuel consumption of a Generating Resource to complete a Start-Up.(x=cooling time) Form Startup Fuel Curve. xAxisData -&gt; cooling time, y1AxisData -&gt; MBtu
 *
 * @param sup                 [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
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
    def this () =
    {
        this (null, null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Curve: Curve = sup.asInstanceOf [Curve]

    override def copy (): Row =
    {
        clone ().asInstanceOf [StartUpFuelCurve]
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
    override val fields: Array[String] = Array [String](
        "RegisteredGenerator"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RegisteredGenerator", "RegisteredGenerator", "0..1", "0..1")
    )
    val RegisteredGenerator: Fielder = parse_attribute (attribute (cls, fields (0)))

    def parse (context: Context): StartUpFuelCurve =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
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
 * @param sup                       [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param areaShortName             Market area short name, which is the regulation zone.
 *                                  It references AGC regulation zone name.
 * @param constantCoefficient       Loss estimate constant coefficient
 * @param embeddedControlArea       Used in conjunction with the InternalCA flag.
 *                                  If the InternalCA flag is YES, this flag does not apply. If the InternaCA flag is NO, this flag provides an indication of AdjacentCA (NO) or Embedded CA (YES).
 * @param endEffectiveDate          end effective date
 * @param internalCA                A Yes/No indication that this control area is contained internal to the system.
 * @param linearCoefficient         Loss estimate linear coefficient
 * @param localCA                   Indication that this control area is the local control area.
 * @param maxSelfSchedMW            Maximum amount of self schedule MWs allowed for an embedded control area.
 * @param minSelfSchedMW            Minimum amount of self schedule MW allowed for an embedded control area.
 * @param quadraticCoefficient      Loss estimate quadratic coefficient
 * @param startEffectiveDate        start effective date
 * @param AdjacentCASet             [[ch.ninecode.model.AdjacentCASet AdjacentCASet]] <em>undocumented</em>
 * @param AggregateNode             [[ch.ninecode.model.AggregateNode AggregateNode]] <em>undocumented</em>
 * @param AreaReserveSpecification  [[ch.ninecode.model.AreaReserveSpec AreaReserveSpec]] <em>undocumented</em>
 * @param BidSelfSched              [[ch.ninecode.model.BidSelfSched BidSelfSched]] <em>undocumented</em>
 * @param CnodeDistributionFactor   [[ch.ninecode.model.CnodeDistributionFactor CnodeDistributionFactor]] <em>undocumented</em>
 * @param ControlAreaDesignation    [[ch.ninecode.model.ControlAreaDesignation ControlAreaDesignation]] <em>undocumented</em>
 * @param ExPostLossResults         [[ch.ninecode.model.ExPostLossResults ExPostLossResults]] <em>undocumented</em>
 * @param Export_EnergyTransactions [[ch.ninecode.model.EnergyTransaction EnergyTransaction]] Energy is transferred between interchange areas
 * @param From_Flowgate             [[ch.ninecode.model.Flowgate Flowgate]] <em>undocumented</em>
 * @param GeneralClearingResults    [[ch.ninecode.model.GeneralClearingResults GeneralClearingResults]] <em>undocumented</em>
 * @param HostControlArea           [[ch.ninecode.model.HostControlArea HostControlArea]] The interchange area  may operate as a control area
 * @param Import_EnergyTransactions [[ch.ninecode.model.EnergyTransaction EnergyTransaction]] Energy is transferred between interchange areas
 * @param InadvertentAccount        [[ch.ninecode.model.InadvertentAccount InadvertentAccount]] A control area can have one or more net inadvertent interchange accounts
 * @param LossClearingResults       [[ch.ninecode.model.LossClearingResults LossClearingResults]] <em>undocumented</em>
 * @param Pnode                     [[ch.ninecode.model.Pnode Pnode]] <em>undocumented</em>
 * @param RTO                       [[ch.ninecode.model.RTO RTO]] <em>undocumented</em>
 * @param Receive_DynamicSchedules  [[ch.ninecode.model.DynamicSchedule DynamicSchedule]] A control area can receive dynamic schedules from other control areas
 * @param RegisteredResource        [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @param Send_DynamicSchedules     [[ch.ninecode.model.DynamicSchedule DynamicSchedule]] A control area can send dynamic schedules to other control areas
 * @param SideA_TieLines            [[ch.ninecode.model.TieLine TieLine]] The SubControlArea is on the A side of a collection of metered points which define the SubControlArea's boundary for a ControlAreaOperator or CustomerConsumer.
 * @param SideB_TieLines            [[ch.ninecode.model.TieLine TieLine]] The SubControlArea is on the B side of a collection of metered points which define the SubControlArea's boundary for a ControlAreaOperator or CustomerConsumer.
 * @param To_Flowgate               [[ch.ninecode.model.Flowgate Flowgate]] <em>undocumented</em>
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
    endEffectiveDate: String,
    internalCA: String,
    linearCoefficient: Double,
    localCA: String,
    maxSelfSchedMW: Double,
    minSelfSchedMW: Double,
    quadraticCoefficient: Double,
    startEffectiveDate: String,
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
    def this () =
    {
        this (null, null, 0.0, null, null, null, 0.0, null, 0.0, 0.0, 0.0, null, null, List (), null, List (), List (), List (), List (), List (), List (), List (), null, List (), List (), List (), List (), null, List (), List (), List (), List (), List (), List ())
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
        clone ().asInstanceOf [SubControlArea]
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
        implicit val clz: String = SubControlArea.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SubControlArea.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SubControlArea.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (SubControlArea.fields (position), x))

        emitelem (0, areaShortName)
        emitelem (1, constantCoefficient)
        emitattr (2, embeddedControlArea)
        emitelem (3, endEffectiveDate)
        emitattr (4, internalCA)
        emitelem (5, linearCoefficient)
        emitattr (6, localCA)
        emitelem (7, maxSelfSchedMW)
        emitelem (8, minSelfSchedMW)
        emitelem (9, quadraticCoefficient)
        emitelem (10, startEffectiveDate)
        emitattr (11, AdjacentCASet)
        emitattrs (12, AggregateNode)
        emitattr (13, AreaReserveSpecification)
        emitattrs (14, BidSelfSched)
        emitattrs (15, CnodeDistributionFactor)
        emitattrs (16, ControlAreaDesignation)
        emitattrs (17, ExPostLossResults)
        emitattrs (18, Export_EnergyTransactions)
        emitattrs (19, From_Flowgate)
        emitattrs (20, GeneralClearingResults)
        emitattr (21, HostControlArea)
        emitattrs (22, Import_EnergyTransactions)
        emitattrs (23, InadvertentAccount)
        emitattrs (24, LossClearingResults)
        emitattrs (25, Pnode)
        emitattr (26, RTO)
        emitattrs (27, Receive_DynamicSchedules)
        emitattrs (28, RegisteredResource)
        emitattrs (29, Send_DynamicSchedules)
        emitattrs (30, SideA_TieLines)
        emitattrs (31, SideB_TieLines)
        emitattrs (32, To_Flowgate)
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
    override val fields: Array[String] = Array [String](
        "areaShortName",
        "constantCoefficient",
        "embeddedControlArea",
        "endEffectiveDate",
        "internalCA",
        "linearCoefficient",
        "localCA",
        "maxSelfSchedMW",
        "minSelfSchedMW",
        "quadraticCoefficient",
        "startEffectiveDate",
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
    val areaShortName: Fielder = parse_element (element (cls, fields (0)))
    val constantCoefficient: Fielder = parse_element (element (cls, fields (1)))
    val embeddedControlArea: Fielder = parse_attribute (attribute (cls, fields (2)))
    val endEffectiveDate: Fielder = parse_element (element (cls, fields (3)))
    val internalCA: Fielder = parse_attribute (attribute (cls, fields (4)))
    val linearCoefficient: Fielder = parse_element (element (cls, fields (5)))
    val localCA: Fielder = parse_attribute (attribute (cls, fields (6)))
    val maxSelfSchedMW: Fielder = parse_element (element (cls, fields (7)))
    val minSelfSchedMW: Fielder = parse_element (element (cls, fields (8)))
    val quadraticCoefficient: Fielder = parse_element (element (cls, fields (9)))
    val startEffectiveDate: Fielder = parse_element (element (cls, fields (10)))
    val AdjacentCASet: Fielder = parse_attribute (attribute (cls, fields (11)))
    val AggregateNode: FielderMultiple = parse_attributes (attribute (cls, fields (12)))
    val AreaReserveSpecification: Fielder = parse_attribute (attribute (cls, fields (13)))
    val BidSelfSched: FielderMultiple = parse_attributes (attribute (cls, fields (14)))
    val CnodeDistributionFactor: FielderMultiple = parse_attributes (attribute (cls, fields (15)))
    val ControlAreaDesignation: FielderMultiple = parse_attributes (attribute (cls, fields (16)))
    val ExPostLossResults: FielderMultiple = parse_attributes (attribute (cls, fields (17)))
    val Export_EnergyTransactions: FielderMultiple = parse_attributes (attribute (cls, fields (18)))
    val From_Flowgate: FielderMultiple = parse_attributes (attribute (cls, fields (19)))
    val GeneralClearingResults: FielderMultiple = parse_attributes (attribute (cls, fields (20)))
    val HostControlArea: Fielder = parse_attribute (attribute (cls, fields (21)))
    val Import_EnergyTransactions: FielderMultiple = parse_attributes (attribute (cls, fields (22)))
    val InadvertentAccount: FielderMultiple = parse_attributes (attribute (cls, fields (23)))
    val LossClearingResults: FielderMultiple = parse_attributes (attribute (cls, fields (24)))
    val Pnode: FielderMultiple = parse_attributes (attribute (cls, fields (25)))
    val RTO: Fielder = parse_attribute (attribute (cls, fields (26)))
    val Receive_DynamicSchedules: FielderMultiple = parse_attributes (attribute (cls, fields (27)))
    val RegisteredResource: FielderMultiple = parse_attributes (attribute (cls, fields (28)))
    val Send_DynamicSchedules: FielderMultiple = parse_attributes (attribute (cls, fields (29)))
    val SideA_TieLines: FielderMultiple = parse_attributes (attribute (cls, fields (30)))
    val SideB_TieLines: FielderMultiple = parse_attributes (attribute (cls, fields (31)))
    val To_Flowgate: FielderMultiple = parse_attributes (attribute (cls, fields (32)))

    def parse (context: Context): SubControlArea =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0, 0)
        val ret = SubControlArea (
            PowerSystemResource.parse (context),
            mask (areaShortName (), 0),
            toDouble (mask (constantCoefficient (), 1)),
            mask (embeddedControlArea (), 2),
            mask (endEffectiveDate (), 3),
            mask (internalCA (), 4),
            toDouble (mask (linearCoefficient (), 5)),
            mask (localCA (), 6),
            toDouble (mask (maxSelfSchedMW (), 7)),
            toDouble (mask (minSelfSchedMW (), 8)),
            toDouble (mask (quadraticCoefficient (), 9)),
            mask (startEffectiveDate (), 10),
            mask (AdjacentCASet (), 11),
            masks (AggregateNode (), 12),
            mask (AreaReserveSpecification (), 13),
            masks (BidSelfSched (), 14),
            masks (CnodeDistributionFactor (), 15),
            masks (ControlAreaDesignation (), 16),
            masks (ExPostLossResults (), 17),
            masks (Export_EnergyTransactions (), 18),
            masks (From_Flowgate (), 19),
            masks (GeneralClearingResults (), 20),
            mask (HostControlArea (), 21),
            masks (Import_EnergyTransactions (), 22),
            masks (InadvertentAccount (), 23),
            masks (LossClearingResults (), 24),
            masks (Pnode (), 25),
            mask (RTO (), 26),
            masks (Receive_DynamicSchedules (), 27),
            masks (RegisteredResource (), 28),
            masks (Send_DynamicSchedules (), 29),
            masks (SideA_TieLines (), 30),
            masks (SideB_TieLines (), 31),
            masks (To_Flowgate (), 32)
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
 * @param sup                       Reference to the superclass object.
 * @param precedence                An indicator of the order a resource should be substituted.
 *                                  The lower the number the higher the precedence.
 * @param RegisteredResource        [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
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
    def this () =
    {
        this (null, 0, null, null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Element: Element = sup.asInstanceOf [Element]

    override def copy (): Row =
    {
        clone ().asInstanceOf [SubstitutionResourceList]
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
    override val fields: Array[String] = Array [String](
        "precedence",
        "RegisteredResource",
        "TransmissionContractRight"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RegisteredResource", "RegisteredResource", "0..1", "0..*"),
        Relationship ("TransmissionContractRight", "ContractRight", "0..1", "0..*")
    )
    val precedence: Fielder = parse_element (element (cls, fields (0)))
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields (1)))
    val TransmissionContractRight: Fielder = parse_attribute (attribute (cls, fields (2)))

    def parse (context: Context): SubstitutionResourceList =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
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
 * @param sup                [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param endEffectiveDate   end effective date
 * @param startEffectiveDate start effective date
 * @param AggregatedPnode    [[ch.ninecode.model.AggregatedPnode AggregatedPnode]] <em>undocumented</em>
 * @param AreaLoadCurve      [[ch.ninecode.model.AreaLoadCurve AreaLoadCurve]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class TACArea
(
    override val sup: IdentifiedObject,
    endEffectiveDate: String,
    startEffectiveDate: String,
    AggregatedPnode: List[String],
    AreaLoadCurve: List[String]
)
    extends
        Element
{
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, null, null, List (), List ())
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
        clone ().asInstanceOf [TACArea]
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
        implicit val clz: String = TACArea.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TACArea.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (TACArea.fields (position), x))

        emitelem (0, endEffectiveDate)
        emitelem (1, startEffectiveDate)
        emitattrs (2, AggregatedPnode)
        emitattrs (3, AreaLoadCurve)
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
    override val fields: Array[String] = Array [String](
        "endEffectiveDate",
        "startEffectiveDate",
        "AggregatedPnode",
        "AreaLoadCurve"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AggregatedPnode", "AggregatedPnode", "0..*", "0..*"),
        Relationship ("AreaLoadCurve", "AreaLoadCurve", "0..*", "0..1")
    )
    val endEffectiveDate: Fielder = parse_element (element (cls, fields (0)))
    val startEffectiveDate: Fielder = parse_element (element (cls, fields (1)))
    val AggregatedPnode: FielderMultiple = parse_attributes (attribute (cls, fields (2)))
    val AreaLoadCurve: FielderMultiple = parse_attributes (attribute (cls, fields (3)))

    def parse (context: Context): TACArea =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = TACArea (
            IdentifiedObject.parse (context),
            mask (endEffectiveDate (), 0),
            mask (startEffectiveDate (), 1),
            masks (AggregatedPnode (), 2),
            masks (AreaLoadCurve (), 3)
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
 * @param sup                 [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param endEffectiveDate    end effective date
 * @param startEffectiveDate  start effective date
 * @param Chain_ContractRight [[ch.ninecode.model.ContractRight ContractRight]] <em>undocumented</em>
 * @param Ind_ContractRight   [[ch.ninecode.model.ContractRight ContractRight]] <em>undocumented</em>
 * @param RTO                 [[ch.ninecode.model.RTO RTO]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
case class TransmissionRightChain
(
    override val sup: IdentifiedObject,
    endEffectiveDate: String,
    startEffectiveDate: String,
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
    def this () =
    {
        this (null, null, null, null, List (), null)
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
        clone ().asInstanceOf [TransmissionRightChain]
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
        implicit val clz: String = TransmissionRightChain.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TransmissionRightChain.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TransmissionRightChain.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (TransmissionRightChain.fields (position), x))

        emitelem (0, endEffectiveDate)
        emitelem (1, startEffectiveDate)
        emitattr (2, Chain_ContractRight)
        emitattrs (3, Ind_ContractRight)
        emitattr (4, RTO)
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
    override val fields: Array[String] = Array [String](
        "endEffectiveDate",
        "startEffectiveDate",
        "Chain_ContractRight",
        "Ind_ContractRight",
        "RTO"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Chain_ContractRight", "ContractRight", "1", "0..1"),
        Relationship ("Ind_ContractRight", "ContractRight", "1..*", "0..1"),
        Relationship ("RTO", "RTO", "1", "0..*")
    )
    val endEffectiveDate: Fielder = parse_element (element (cls, fields (0)))
    val startEffectiveDate: Fielder = parse_element (element (cls, fields (1)))
    val Chain_ContractRight: Fielder = parse_attribute (attribute (cls, fields (2)))
    val Ind_ContractRight: FielderMultiple = parse_attributes (attribute (cls, fields (3)))
    val RTO: Fielder = parse_attribute (attribute (cls, fields (4)))

    def parse (context: Context): TransmissionRightChain =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = TransmissionRightChain (
            IdentifiedObject.parse (context),
            mask (endEffectiveDate (), 0),
            mask (startEffectiveDate (), 1),
            mask (Chain_ContractRight (), 2),
            masks (Ind_ContractRight (), 3),
            mask (RTO (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Counter party in a wheeling transaction.
 *
 * @param sup                [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
    def this () =
    {
        this (null, List ())
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
        clone ().asInstanceOf [WheelingCounterParty]
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
    override val fields: Array[String] = Array [String](
        "RegisteredInterTie"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RegisteredInterTie", "RegisteredInterTie", "0..*", "0..*")
    )
    val RegisteredInterTie: FielderMultiple = parse_attributes (attribute (cls, fields (0)))

    def parse (context: Context): WheelingCounterParty =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
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