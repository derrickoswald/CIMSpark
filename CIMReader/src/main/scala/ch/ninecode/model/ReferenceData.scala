package ch.ninecode.model

import com.esotericsoftware.kryo.Kryo
import com.esotericsoftware.kryo.Serializer
import com.esotericsoftware.kryo.io.Input
import com.esotericsoftware.kryo.io.Output
import org.apache.spark.sql.Row

import ch.ninecode.cim.CIMClassInfo
import ch.ninecode.cim.CIMContext
import ch.ninecode.cim.CIMParseable
import ch.ninecode.cim.CIMRelationship
import ch.ninecode.cim.CIMSerializer

/**
 * Groups Adjacent Control Areas.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param lossPercentage_1 Loss percentage
 * @param BidSelfSched [[ch.ninecode.model.BidSelfSched BidSelfSched]] <em>undocumented</em>
 * @param HostControlArea [[ch.ninecode.model.HostControlArea HostControlArea]] <em>undocumented</em>
 * @param RTO [[ch.ninecode.model.RTO RTO]] <em>undocumented</em>
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @param SubControlArea [[ch.ninecode.model.SubControlArea SubControlArea]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
final case class AdjacentCASet
(
    IdentifiedObject: IdentifiedObject = null,
    lossPercentage_1: Double = 0.0,
    BidSelfSched: List[String] = null,
    HostControlArea: String = null,
    RTO: String = null,
    RegisteredResource: List[String] = null,
    SubControlArea: List[String] = null
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
    override def sup: IdentifiedObject = IdentifiedObject

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
        implicit val clz: String = AdjacentCASet.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AdjacentCASet.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AdjacentCASet.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (AdjacentCASet.fields (position), x))
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
        "\t<cim:AdjacentCASet rdf:%s=\"%s\">\n%s\t</cim:AdjacentCASet>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object AdjacentCASet
extends
    CIMParseable[AdjacentCASet]
{
    override val fields: Array[String] = Array[String] (
        "lossPercentage ",
        "BidSelfSched",
        "HostControlArea",
        "RTO",
        "RegisteredResource",
        "SubControlArea"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("BidSelfSched", "BidSelfSched", "0..*", "0..1"),
        CIMRelationship ("HostControlArea", "HostControlArea", "0..1", "0..1"),
        CIMRelationship ("RTO", "RTO", "1", "0..*"),
        CIMRelationship ("RegisteredResource", "RegisteredResource", "0..*", "0..1"),
        CIMRelationship ("SubControlArea", "SubControlArea", "0..*", "0..1")
    )
    val lossPercentage_1: Fielder = parse_element (element (cls, fields(0)))
    val BidSelfSched: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val HostControlArea: Fielder = parse_attribute (attribute (cls, fields(2)))
    val RTO: Fielder = parse_attribute (attribute (cls, fields(3)))
    val RegisteredResource: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val SubControlArea: FielderMultiple = parse_attributes (attribute (cls, fields(5)))

    def parse (context: CIMContext): AdjacentCASet =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[AdjacentCASet] = AdjacentCASetSerializer
}

object AdjacentCASetSerializer extends CIMSerializer[AdjacentCASet]
{
    def write (kryo: Kryo, output: Output, obj: AdjacentCASet): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.lossPercentage_1),
            () => writeList (obj.BidSelfSched, output),
            () => output.writeString (obj.HostControlArea),
            () => output.writeString (obj.RTO),
            () => writeList (obj.RegisteredResource, output),
            () => writeList (obj.SubControlArea, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AdjacentCASet]): AdjacentCASet =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = AdjacentCASet (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) readList (input) else null,
            if (isSet (5)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * An aggregated node can define a typed grouping further defined by the AnodeType enumeratuion.
 *
 * Types range from System Zone/Regions to Market Energy Regions to Aggregated Loads and Aggregated Generators.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
final case class AggregateNode
(
    IdentifiedObject: IdentifiedObject = null,
    anodeType: String = null,
    qualifASOrder: Int = 0,
    AreaLoadCurve: List[String] = null,
    CnodeDistributionFactor: List[String] = null,
    Instruction: List[String] = null,
    Pnode: List[String] = null,
    RTO: String = null,
    RegisteredResource: List[String] = null,
    SubControlArea: List[String] = null
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
    override def sup: IdentifiedObject = IdentifiedObject

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
        implicit val clz: String = AggregateNode.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AggregateNode.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AggregateNode.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (AggregateNode.fields (position), x))
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
        "\t<cim:AggregateNode rdf:%s=\"%s\">\n%s\t</cim:AggregateNode>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object AggregateNode
extends
    CIMParseable[AggregateNode]
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AreaLoadCurve", "AreaLoadCurve", "0..*", "0..1"),
        CIMRelationship ("CnodeDistributionFactor", "CnodeDistributionFactor", "0..*", "0..1"),
        CIMRelationship ("Instruction", "Instructions", "0..*", "0..1"),
        CIMRelationship ("Pnode", "Pnode", "0..*", "0..*"),
        CIMRelationship ("RTO", "RTO", "1", "0..*"),
        CIMRelationship ("RegisteredResource", "RegisteredResource", "0..*", "0..1"),
        CIMRelationship ("SubControlArea", "SubControlArea", "0..*", "0..*")
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

    def parse (context: CIMContext): AggregateNode =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[AggregateNode] = AggregateNodeSerializer
}

object AggregateNodeSerializer extends CIMSerializer[AggregateNode]
{
    def write (kryo: Kryo, output: Output, obj: AggregateNode): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.anodeType),
            () => output.writeInt (obj.qualifASOrder),
            () => writeList (obj.AreaLoadCurve, output),
            () => writeList (obj.CnodeDistributionFactor, output),
            () => writeList (obj.Instruction, output),
            () => writeList (obj.Pnode, output),
            () => output.writeString (obj.RTO),
            () => writeList (obj.RegisteredResource, output),
            () => writeList (obj.SubControlArea, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AggregateNode]): AggregateNode =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = AggregateNode (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readInt else 0,
            if (isSet (2)) readList (input) else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) readList (input) else null,
            if (isSet (5)) readList (input) else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) readList (input) else null,
            if (isSet (8)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * An aggregated pricing node is a specialized type of pricing node used to model items such as System Zone, Default Price Zone, Custom Price Zone, Control Area, Aggregated Generation, Aggregated Particpating Load, Aggregated Non-Participating Load, Trading Hub, Designated Control Area(DCA) Zone.
 *
 * @param Pnode [[ch.ninecode.model.Pnode Pnode]] Reference to the superclass object.
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
final case class AggregatedPnode
(
    Pnode: Pnode = null,
    apnodeType: String = null,
    participationCategory: String = null,
    GenDistributionFactor: List[String] = null,
    LoadDistributionFactor: List[String] = null,
    MPMTestResults: List[String] = null,
    MPMTestThreshold: List[String] = null,
    MktCombinedCyclePlant: List[String] = null,
    PnodeDistributionFactor: List[String] = null,
    TACArea: List[String] = null,
    TradingHubValues: List[String] = null
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
    override def sup: Pnode = Pnode

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
        implicit val clz: String = AggregatedPnode.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AggregatedPnode.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (AggregatedPnode.fields (position), x))
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
        "\t<cim:AggregatedPnode rdf:%s=\"%s\">\n%s\t</cim:AggregatedPnode>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object AggregatedPnode
extends
    CIMParseable[AggregatedPnode]
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("GenDistributionFactor", "GenDistributionFactor", "1..*", "0..1"),
        CIMRelationship ("LoadDistributionFactor", "LoadDistributionFactor", "1..*", "0..1"),
        CIMRelationship ("MPMTestResults", "MPMTestResults", "1..*", "1"),
        CIMRelationship ("MPMTestThreshold", "MPMTestThreshold", "1..*", "0..*"),
        CIMRelationship ("MktCombinedCyclePlant", "MktCombinedCyclePlant", "0..*", "0..1"),
        CIMRelationship ("PnodeDistributionFactor", "PnodeDistributionFactor", "1..*", "1"),
        CIMRelationship ("TACArea", "TACArea", "0..*", "0..*"),
        CIMRelationship ("TradingHubValues", "TradingHubValues", "0..*", "1")
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

    def parse (context: CIMContext): AggregatedPnode =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[AggregatedPnode] = AggregatedPnodeSerializer
}

object AggregatedPnodeSerializer extends CIMSerializer[AggregatedPnode]
{
    def write (kryo: Kryo, output: Output, obj: AggregatedPnode): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.apnodeType),
            () => output.writeString (obj.participationCategory),
            () => writeList (obj.GenDistributionFactor, output),
            () => writeList (obj.LoadDistributionFactor, output),
            () => writeList (obj.MPMTestResults, output),
            () => writeList (obj.MPMTestThreshold, output),
            () => writeList (obj.MktCombinedCyclePlant, output),
            () => writeList (obj.PnodeDistributionFactor, output),
            () => writeList (obj.TACArea, output),
            () => writeList (obj.TradingHubValues, output)
        )
        PnodeSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AggregatedPnode]): AggregatedPnode =
    {
        val parent = PnodeSerializer.read (kryo, input, classOf[Pnode])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = AggregatedPnode (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) readList (input) else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) readList (input) else null,
            if (isSet (5)) readList (input) else null,
            if (isSet (6)) readList (input) else null,
            if (isSet (7)) readList (input) else null,
            if (isSet (8)) readList (input) else null,
            if (isSet (9)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * This class represent the bid price cap.
 *
 * @param Element Reference to the superclass object.
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
final case class BidPriceCap
(
    Element: BasicElement = null,
    bidCeiling: Double = 0.0,
    bidCeilingAS: Double = 0.0,
    bidFloor: Double = 0.0,
    bidFloorAS: Double = 0.0,
    defaultPrice: Double = 0.0,
    marketType: String = null,
    MarketProduct: String = null
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
    override def sup: Element = Element

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
        "\t<cim:BidPriceCap rdf:%s=\"%s\">\n%s\t</cim:BidPriceCap>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object BidPriceCap
extends
    CIMParseable[BidPriceCap]
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("MarketProduct", "MarketProduct", "0..1", "0..*")
    )
    val bidCeiling: Fielder = parse_element (element (cls, fields(0)))
    val bidCeilingAS: Fielder = parse_element (element (cls, fields(1)))
    val bidFloor: Fielder = parse_element (element (cls, fields(2)))
    val bidFloorAS: Fielder = parse_element (element (cls, fields(3)))
    val defaultPrice: Fielder = parse_element (element (cls, fields(4)))
    val marketType: Fielder = parse_attribute (attribute (cls, fields(5)))
    val MarketProduct: Fielder = parse_attribute (attribute (cls, fields(6)))

    def parse (context: CIMContext): BidPriceCap =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[BidPriceCap] = BidPriceCapSerializer
}

object BidPriceCapSerializer extends CIMSerializer[BidPriceCap]
{
    def write (kryo: Kryo, output: Output, obj: BidPriceCap): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.bidCeiling),
            () => output.writeDouble (obj.bidCeilingAS),
            () => output.writeDouble (obj.bidFloor),
            () => output.writeDouble (obj.bidFloorAS),
            () => output.writeDouble (obj.defaultPrice),
            () => output.writeString (obj.marketType),
            () => output.writeString (obj.MarketProduct)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[BidPriceCap]): BidPriceCap =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = BidPriceCap (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Participation factors per Cnode.
 *
 * Used to calculate "participation" of Cnode in an AggregateNode. Each Cnode associated to an AggregateNode would be assigned a participation factor for its participation within the AggregateNode.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
final case class CnodeDistributionFactor
(
    IdentifiedObject: IdentifiedObject = null,
    factor: Double = 0.0,
    podLossFactor: Double = 0.0,
    AggregateNode: String = null,
    HostControlArea: String = null,
    MktConnectivityNode: String = null,
    SubControlArea: String = null
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
    override def sup: IdentifiedObject = IdentifiedObject

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
        "\t<cim:CnodeDistributionFactor rdf:%s=\"%s\">\n%s\t</cim:CnodeDistributionFactor>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object CnodeDistributionFactor
extends
    CIMParseable[CnodeDistributionFactor]
{
    override val fields: Array[String] = Array[String] (
        "factor",
        "podLossFactor",
        "AggregateNode",
        "HostControlArea",
        "MktConnectivityNode",
        "SubControlArea"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AggregateNode", "AggregateNode", "0..1", "0..*"),
        CIMRelationship ("HostControlArea", "HostControlArea", "0..1", "0..*"),
        CIMRelationship ("MktConnectivityNode", "MktConnectivityNode", "1", "0..*"),
        CIMRelationship ("SubControlArea", "SubControlArea", "0..1", "0..*")
    )
    val factor: Fielder = parse_element (element (cls, fields(0)))
    val podLossFactor: Fielder = parse_element (element (cls, fields(1)))
    val AggregateNode: Fielder = parse_attribute (attribute (cls, fields(2)))
    val HostControlArea: Fielder = parse_attribute (attribute (cls, fields(3)))
    val MktConnectivityNode: Fielder = parse_attribute (attribute (cls, fields(4)))
    val SubControlArea: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: CIMContext): CnodeDistributionFactor =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[CnodeDistributionFactor] = CnodeDistributionFactorSerializer
}

object CnodeDistributionFactorSerializer extends CIMSerializer[CnodeDistributionFactor]
{
    def write (kryo: Kryo, output: Output, obj: CnodeDistributionFactor): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.factor),
            () => output.writeDouble (obj.podLossFactor),
            () => output.writeString (obj.AggregateNode),
            () => output.writeString (obj.HostControlArea),
            () => output.writeString (obj.MktConnectivityNode),
            () => output.writeString (obj.SubControlArea)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CnodeDistributionFactor]): CnodeDistributionFactor =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = CnodeDistributionFactor (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Configuration options for combined cycle units.
 *
 * For example, a Combined Cycle with (CT1, CT2, ST1) will have (CT1, ST1) and (CT2, ST1) configurations as part of(1CT + 1STlogicalconfiguration).
 *
 * @param RegisteredGenerator [[ch.ninecode.model.RegisteredGenerator RegisteredGenerator]] Reference to the superclass object.
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
final case class CombinedCycleConfiguration
(
    RegisteredGenerator: RegisteredGenerator = null,
    primaryConfiguration: Boolean = false,
    CombinedCycleConfigurationMember: List[String] = null,
    CombinedCycleLogicalConfiguration: String = null,
    FromTransitionState: List[String] = null,
    ShutdownFlag: Boolean = false,
    StartupFlag: Boolean = false,
    ToTransitionState: List[String] = null
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
    override def sup: RegisteredGenerator = RegisteredGenerator

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
        implicit val clz: String = CombinedCycleConfiguration.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CombinedCycleConfiguration.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CombinedCycleConfiguration.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (CombinedCycleConfiguration.fields (position), x))
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
        "\t<cim:CombinedCycleConfiguration rdf:%s=\"%s\">\n%s\t</cim:CombinedCycleConfiguration>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object CombinedCycleConfiguration
extends
    CIMParseable[CombinedCycleConfiguration]
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("CombinedCycleConfigurationMember", "CombinedCycleConfigurationMember", "0..*", "1"),
        CIMRelationship ("CombinedCycleLogicalConfiguration", "CombinedCycleLogicalConfiguration", "0..1", "1..*"),
        CIMRelationship ("FromTransitionState", "CombinedCycleTransitionState", "0..*", "1"),
        CIMRelationship ("ToTransitionState", "CombinedCycleTransitionState", "0..*", "1")
    )
    val primaryConfiguration: Fielder = parse_element (element (cls, fields(0)))
    val CombinedCycleConfigurationMember: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val CombinedCycleLogicalConfiguration: Fielder = parse_attribute (attribute (cls, fields(2)))
    val FromTransitionState: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val ShutdownFlag: Fielder = parse_element (element (cls, fields(4)))
    val StartupFlag: Fielder = parse_element (element (cls, fields(5)))
    val ToTransitionState: FielderMultiple = parse_attributes (attribute (cls, fields(6)))

    def parse (context: CIMContext): CombinedCycleConfiguration =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[CombinedCycleConfiguration] = CombinedCycleConfigurationSerializer
}

object CombinedCycleConfigurationSerializer extends CIMSerializer[CombinedCycleConfiguration]
{
    def write (kryo: Kryo, output: Output, obj: CombinedCycleConfiguration): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeBoolean (obj.primaryConfiguration),
            () => writeList (obj.CombinedCycleConfigurationMember, output),
            () => output.writeString (obj.CombinedCycleLogicalConfiguration),
            () => writeList (obj.FromTransitionState, output),
            () => output.writeBoolean (obj.ShutdownFlag),
            () => output.writeBoolean (obj.StartupFlag),
            () => writeList (obj.ToTransitionState, output)
        )
        RegisteredGeneratorSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CombinedCycleConfiguration]): CombinedCycleConfiguration =
    {
        val parent = RegisteredGeneratorSerializer.read (kryo, input, classOf[RegisteredGenerator])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = CombinedCycleConfiguration (
            parent,
            if (isSet (0)) input.readBoolean else false,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) input.readBoolean else false,
            if (isSet (5)) input.readBoolean else false,
            if (isSet (6)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Configuration Member of CCP Configuration.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param primary primary configuration.
 * @param steam Steam plant.
 * @param CombinedCycleConfiguration [[ch.ninecode.model.CombinedCycleConfiguration CombinedCycleConfiguration]] <em>undocumented</em>
 * @param MktThermalGeneratingUnit [[ch.ninecode.model.MktThermalGeneratingUnit MktThermalGeneratingUnit]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
final case class CombinedCycleConfigurationMember
(
    IdentifiedObject: IdentifiedObject = null,
    primary: Boolean = false,
    steam: Boolean = false,
    CombinedCycleConfiguration: String = null,
    MktThermalGeneratingUnit: String = null
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
    override def sup: IdentifiedObject = IdentifiedObject

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
        "\t<cim:CombinedCycleConfigurationMember rdf:%s=\"%s\">\n%s\t</cim:CombinedCycleConfigurationMember>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object CombinedCycleConfigurationMember
extends
    CIMParseable[CombinedCycleConfigurationMember]
{
    override val fields: Array[String] = Array[String] (
        "primary",
        "steam",
        "CombinedCycleConfiguration",
        "MktThermalGeneratingUnit"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("CombinedCycleConfiguration", "CombinedCycleConfiguration", "1", "0..*"),
        CIMRelationship ("MktThermalGeneratingUnit", "MktThermalGeneratingUnit", "1", "0..*")
    )
    val primary: Fielder = parse_element (element (cls, fields(0)))
    val steam: Fielder = parse_element (element (cls, fields(1)))
    val CombinedCycleConfiguration: Fielder = parse_attribute (attribute (cls, fields(2)))
    val MktThermalGeneratingUnit: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: CIMContext): CombinedCycleConfigurationMember =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[CombinedCycleConfigurationMember] = CombinedCycleConfigurationMemberSerializer
}

object CombinedCycleConfigurationMemberSerializer extends CIMSerializer[CombinedCycleConfigurationMember]
{
    def write (kryo: Kryo, output: Output, obj: CombinedCycleConfigurationMember): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeBoolean (obj.primary),
            () => output.writeBoolean (obj.steam),
            () => output.writeString (obj.CombinedCycleConfiguration),
            () => output.writeString (obj.MktThermalGeneratingUnit)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CombinedCycleConfigurationMember]): CombinedCycleConfigurationMember =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = CombinedCycleConfigurationMember (
            parent,
            if (isSet (0)) input.readBoolean else false,
            if (isSet (1)) input.readBoolean else false,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Logical Configuration of a Combined Cycle plant.
 *
 * Operating Combined Cycle Plant (CCP) configurations are represented as Logical CCP Resources. Logical representation shall be used for Market applications to optimize and control Market Operations. Logical representation is also necessary for controlling the number of CCP configurations and to temper performance issues that may otherwise occur.
 *
 * For example,(2CT configuration),(1CT + 1ST configuration) are examples of logical configuration, without specifying the specific CT and ST participating in the configuration.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param CombinedCycleConfiguration [[ch.ninecode.model.CombinedCycleConfiguration CombinedCycleConfiguration]] <em>undocumented</em>
 * @param MktCombinedCyclePlant [[ch.ninecode.model.MktCombinedCyclePlant MktCombinedCyclePlant]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
final case class CombinedCycleLogicalConfiguration
(
    IdentifiedObject: IdentifiedObject = null,
    CombinedCycleConfiguration: List[String] = null,
    MktCombinedCyclePlant: String = null
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
    override def sup: IdentifiedObject = IdentifiedObject

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
        implicit val clz: String = CombinedCycleLogicalConfiguration.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CombinedCycleLogicalConfiguration.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (CombinedCycleLogicalConfiguration.fields (position), x))
        emitattrs (0, CombinedCycleConfiguration)
        emitattr (1, MktCombinedCyclePlant)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CombinedCycleLogicalConfiguration rdf:%s=\"%s\">\n%s\t</cim:CombinedCycleLogicalConfiguration>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object CombinedCycleLogicalConfiguration
extends
    CIMParseable[CombinedCycleLogicalConfiguration]
{
    override val fields: Array[String] = Array[String] (
        "CombinedCycleConfiguration",
        "MktCombinedCyclePlant"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("CombinedCycleConfiguration", "CombinedCycleConfiguration", "1..*", "0..1"),
        CIMRelationship ("MktCombinedCyclePlant", "MktCombinedCyclePlant", "0..1", "1..*")
    )
    val CombinedCycleConfiguration: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val MktCombinedCyclePlant: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): CombinedCycleLogicalConfiguration =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CombinedCycleLogicalConfiguration (
            IdentifiedObject.parse (context),
            masks (CombinedCycleConfiguration (), 0),
            mask (MktCombinedCyclePlant (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[CombinedCycleLogicalConfiguration] = CombinedCycleLogicalConfigurationSerializer
}

object CombinedCycleLogicalConfigurationSerializer extends CIMSerializer[CombinedCycleLogicalConfiguration]
{
    def write (kryo: Kryo, output: Output, obj: CombinedCycleLogicalConfiguration): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.CombinedCycleConfiguration, output),
            () => output.writeString (obj.MktCombinedCyclePlant)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CombinedCycleLogicalConfiguration]): CombinedCycleLogicalConfiguration =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = CombinedCycleLogicalConfiguration (
            parent,
            if (isSet (0)) readList (input) else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Defines the available from and to Transition States for the Combine Cycle Configurations.
 *
 * @param Element Reference to the superclass object.
 * @param upTransition Flag indicating whether this is an UP transition.
 *        If not, it is a DOWN transition.
 * @param FromConfiguration [[ch.ninecode.model.CombinedCycleConfiguration CombinedCycleConfiguration]] <em>undocumented</em>
 * @param ToConfiguration [[ch.ninecode.model.CombinedCycleConfiguration CombinedCycleConfiguration]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
final case class CombinedCycleTransitionState
(
    Element: BasicElement = null,
    upTransition: Boolean = false,
    FromConfiguration: String = null,
    ToConfiguration: String = null
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
    override def sup: Element = Element

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
        "\t<cim:CombinedCycleTransitionState rdf:%s=\"%s\">\n%s\t</cim:CombinedCycleTransitionState>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object CombinedCycleTransitionState
extends
    CIMParseable[CombinedCycleTransitionState]
{
    override val fields: Array[String] = Array[String] (
        "upTransition",
        "FromConfiguration",
        "ToConfiguration"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("FromConfiguration", "CombinedCycleConfiguration", "1", "0..*"),
        CIMRelationship ("ToConfiguration", "CombinedCycleConfiguration", "1", "0..*")
    )
    val upTransition: Fielder = parse_element (element (cls, fields(0)))
    val FromConfiguration: Fielder = parse_attribute (attribute (cls, fields(1)))
    val ToConfiguration: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: CIMContext): CombinedCycleTransitionState =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CombinedCycleTransitionState (
            BasicElement.parse (context),
            toBoolean (mask (upTransition (), 0)),
            mask (FromConfiguration (), 1),
            mask (ToConfiguration (), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[CombinedCycleTransitionState] = CombinedCycleTransitionStateSerializer
}

object CombinedCycleTransitionStateSerializer extends CIMSerializer[CombinedCycleTransitionState]
{
    def write (kryo: Kryo, output: Output, obj: CombinedCycleTransitionState): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeBoolean (obj.upTransition),
            () => output.writeString (obj.FromConfiguration),
            () => output.writeString (obj.ToConfiguration)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CombinedCycleTransitionState]): CombinedCycleTransitionState =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = CombinedCycleTransitionState (
            parent,
            if (isSet (0)) input.readBoolean else false,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Designated Congestion Area Definition (DCA).
 *
 * @param AggregatedPnode [[ch.ninecode.model.AggregatedPnode AggregatedPnode]] Reference to the superclass object.
 * @param IndividualPnode [[ch.ninecode.model.IndividualPnode IndividualPnode]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
final case class CongestionArea
(
    AggregatedPnode: AggregatedPnode = null,
    IndividualPnode: List[String] = null
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
    override def sup: AggregatedPnode = AggregatedPnode

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
        implicit val clz: String = CongestionArea.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (CongestionArea.fields (position), x))
        emitattrs (0, IndividualPnode)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CongestionArea rdf:%s=\"%s\">\n%s\t</cim:CongestionArea>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object CongestionArea
extends
    CIMParseable[CongestionArea]
{
    override val fields: Array[String] = Array[String] (
        "IndividualPnode"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("IndividualPnode", "IndividualPnode", "0..*", "0..*")
    )
    val IndividualPnode: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): CongestionArea =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CongestionArea (
            AggregatedPnode.parse (context),
            masks (IndividualPnode (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[CongestionArea] = CongestionAreaSerializer
}

object CongestionAreaSerializer extends CIMSerializer[CongestionArea]
{
    def write (kryo: Kryo, output: Output, obj: CongestionArea): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.IndividualPnode, output)
        )
        AggregatedPnodeSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CongestionArea]): CongestionArea =
    {
        val parent = AggregatedPnodeSerializer.read (kryo, input, classOf[AggregatedPnode])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = CongestionArea (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Distribution among resources at the sink point or source point.
 *
 * @param Element Reference to the superclass object.
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
final case class ContractDistributionFactor
(
    Element: BasicElement = null,
    factor: Double = 0.0,
    sinkFlag: String = null,
    sourceFlag: String = null,
    Flowgate: String = null,
    RegisteredResource: String = null,
    TransmissionContractRight: String = null
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
    override def sup: Element = Element

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
        "\t<cim:ContractDistributionFactor rdf:%s=\"%s\">\n%s\t</cim:ContractDistributionFactor>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object ContractDistributionFactor
extends
    CIMParseable[ContractDistributionFactor]
{
    override val fields: Array[String] = Array[String] (
        "factor",
        "sinkFlag",
        "sourceFlag",
        "Flowgate",
        "RegisteredResource",
        "TransmissionContractRight"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Flowgate", "Flowgate", "0..1", "0..*"),
        CIMRelationship ("RegisteredResource", "RegisteredResource", "0..1", "0..*"),
        CIMRelationship ("TransmissionContractRight", "ContractRight", "0..1", "0..*")
    )
    val factor: Fielder = parse_element (element (cls, fields(0)))
    val sinkFlag: Fielder = parse_attribute (attribute (cls, fields(1)))
    val sourceFlag: Fielder = parse_attribute (attribute (cls, fields(2)))
    val Flowgate: Fielder = parse_attribute (attribute (cls, fields(3)))
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields(4)))
    val TransmissionContractRight: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: CIMContext): ContractDistributionFactor =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[ContractDistributionFactor] = ContractDistributionFactorSerializer
}

object ContractDistributionFactorSerializer extends CIMSerializer[ContractDistributionFactor]
{
    def write (kryo: Kryo, output: Output, obj: ContractDistributionFactor): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.factor),
            () => output.writeString (obj.sinkFlag),
            () => output.writeString (obj.sourceFlag),
            () => output.writeString (obj.Flowgate),
            () => output.writeString (obj.RegisteredResource),
            () => output.writeString (obj.TransmissionContractRight)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ContractDistributionFactor]): ContractDistributionFactor =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ContractDistributionFactor (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Provides definition of Transmission Ownership Right and Existing Transmission Contract identifiers for use by SCUC.
 *
 * RMR contract hosting: Startup lead time, Contract Service Limits, Max Service Hours, Max MWhs, Max Start-ups, Ramp Rate, Max Net Dependable Capacity, Min Capacity and Unit Substitution for DAM/RTM to retrieve.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param chainOrder When used in conjunction with a Transmission Right contract chain, this is the precedence for the contracts.
 * @param contractMW MW value of the contract
 * @param contractPrice Financial value of the contract
 * @param contractPriority Priority for the contract.
 *        This should be unique amoung all contracts for a specific resource. This value is the directive for the SCUC algorithm on the order to satisfy/cut contracts.
 * @param contractStatus Contract status
 * @param contractType type of the contract.
 *        Possible values are but not limited by:
 *        
 *        ETC, TOR or RMR and RMT self schedules
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
final case class ContractRight
(
    IdentifiedObject: IdentifiedObject = null,
    chainOrder: Int = 0,
    contractMW: Double = 0.0,
    contractPrice: Double = 0.0,
    contractPriority: Int = 0,
    contractStatus: String = null,
    contractType: String = null,
    financialLocation: String = null,
    financialRightsDAM: String = null,
    financialRightsRTM: String = null,
    fuelAdder: Double = 0.0,
    latestSchedMinutes: Int = 0,
    latestSchedMktType: String = null,
    maxNetDependableCapacity: Double = 0.0,
    maximumScheduleQuantity: Double = 0.0,
    maximumServiceHours: Int = 0,
    maximumStartups: Int = 0,
    minimumLoad: Double = 0.0,
    minimumScheduleQuantity: Double = 0.0,
    physicalRightsDAM: String = null,
    physicalRightsRTM: String = null,
    startupLeadTime: Int = 0,
    BidSelfSched: List[String] = null,
    Chain_TransmissionRightChain: String = null,
    ContractDistributionFactor: List[String] = null,
    Ind_TransmissionRightChain: String = null,
    RTO: String = null,
    SchedulingCoordinator: String = null,
    SubstitutionResourceList: List[String] = null,
    TREntitlement: List[String] = null,
    TRType: String = null,
    TransmissionInterfaceEntitlement: List[String] = null
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
    override def sup: IdentifiedObject = IdentifiedObject

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
        implicit val clz: String = ContractRight.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ContractRight.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ContractRight.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ContractRight.fields (position), x))
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
        "\t<cim:ContractRight rdf:%s=\"%s\">\n%s\t</cim:ContractRight>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object ContractRight
extends
    CIMParseable[ContractRight]
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("BidSelfSched", "BidSelfSched", "0..*", "0..1"),
        CIMRelationship ("Chain_TransmissionRightChain", "TransmissionRightChain", "0..1", "1"),
        CIMRelationship ("ContractDistributionFactor", "ContractDistributionFactor", "0..*", "0..1"),
        CIMRelationship ("Ind_TransmissionRightChain", "TransmissionRightChain", "0..1", "1..*"),
        CIMRelationship ("RTO", "RTO", "1", "0..*"),
        CIMRelationship ("SchedulingCoordinator", "SchedulingCoordinator", "1", "0..*"),
        CIMRelationship ("SubstitutionResourceList", "SubstitutionResourceList", "0..*", "0..1"),
        CIMRelationship ("TREntitlement", "TREntitlement", "0..*", "1"),
        CIMRelationship ("TransmissionInterfaceEntitlement", "TransmissionInterfaceRightEntitlement", "0..*", "1")
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

    def parse (context: CIMContext): ContractRight =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[ContractRight] = ContractRightSerializer
}

object ContractRightSerializer extends CIMSerializer[ContractRight]
{
    def write (kryo: Kryo, output: Output, obj: ContractRight): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeInt (obj.chainOrder),
            () => output.writeDouble (obj.contractMW),
            () => output.writeDouble (obj.contractPrice),
            () => output.writeInt (obj.contractPriority),
            () => output.writeString (obj.contractStatus),
            () => output.writeString (obj.contractType),
            () => output.writeString (obj.financialLocation),
            () => output.writeString (obj.financialRightsDAM),
            () => output.writeString (obj.financialRightsRTM),
            () => output.writeDouble (obj.fuelAdder),
            () => output.writeInt (obj.latestSchedMinutes),
            () => output.writeString (obj.latestSchedMktType),
            () => output.writeDouble (obj.maxNetDependableCapacity),
            () => output.writeDouble (obj.maximumScheduleQuantity),
            () => output.writeInt (obj.maximumServiceHours),
            () => output.writeInt (obj.maximumStartups),
            () => output.writeDouble (obj.minimumLoad),
            () => output.writeDouble (obj.minimumScheduleQuantity),
            () => output.writeString (obj.physicalRightsDAM),
            () => output.writeString (obj.physicalRightsRTM),
            () => output.writeInt (obj.startupLeadTime),
            () => writeList (obj.BidSelfSched, output),
            () => output.writeString (obj.Chain_TransmissionRightChain),
            () => writeList (obj.ContractDistributionFactor, output),
            () => output.writeString (obj.Ind_TransmissionRightChain),
            () => output.writeString (obj.RTO),
            () => output.writeString (obj.SchedulingCoordinator),
            () => writeList (obj.SubstitutionResourceList, output),
            () => writeList (obj.TREntitlement, output),
            () => output.writeString (obj.TRType),
            () => writeList (obj.TransmissionInterfaceEntitlement, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ContractRight]): ContractRight =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ContractRight (
            parent,
            if (isSet (0)) input.readInt else 0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readInt else 0,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) input.readString else null,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) input.readDouble else 0.0,
            if (isSet (10)) input.readInt else 0,
            if (isSet (11)) input.readString else null,
            if (isSet (12)) input.readDouble else 0.0,
            if (isSet (13)) input.readDouble else 0.0,
            if (isSet (14)) input.readInt else 0,
            if (isSet (15)) input.readInt else 0,
            if (isSet (16)) input.readDouble else 0.0,
            if (isSet (17)) input.readDouble else 0.0,
            if (isSet (18)) input.readString else null,
            if (isSet (19)) input.readString else null,
            if (isSet (20)) input.readInt else 0,
            if (isSet (21)) readList (input) else null,
            if (isSet (22)) input.readString else null,
            if (isSet (23)) readList (input) else null,
            if (isSet (24)) input.readString else null,
            if (isSet (25)) input.readString else null,
            if (isSet (26)) input.readString else null,
            if (isSet (27)) readList (input) else null,
            if (isSet (28)) readList (input) else null,
            if (isSet (29)) input.readString else null,
            if (isSet (30)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Indicates Control Area associated with self-schedule.
 *
 * @param Element Reference to the superclass object.
 * @param attained Attained.
 * @param native Native.
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @param SubControlArea [[ch.ninecode.model.SubControlArea SubControlArea]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
final case class ControlAreaDesignation
(
    Element: BasicElement = null,
    attained: String = null,
    `native`: String = null,
    RegisteredResource: List[String] = null,
    SubControlArea: List[String] = null
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
    override def sup: Element = Element

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
        implicit val clz: String = ControlAreaDesignation.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ControlAreaDesignation.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ControlAreaDesignation.fields (position), x))
        emitattr (0, attained)
        emitattr (1, `native`)
        emitattrs (2, RegisteredResource)
        emitattrs (3, SubControlArea)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ControlAreaDesignation rdf:%s=\"%s\">\n%s\t</cim:ControlAreaDesignation>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object ControlAreaDesignation
extends
    CIMParseable[ControlAreaDesignation]
{
    override val fields: Array[String] = Array[String] (
        "attained",
        "native",
        "RegisteredResource",
        "SubControlArea"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("RegisteredResource", "RegisteredResource", "0..*", "0..*"),
        CIMRelationship ("SubControlArea", "SubControlArea", "0..*", "0..*")
    )
    val attained: Fielder = parse_attribute (attribute (cls, fields(0)))
    val `native`: Fielder = parse_attribute (attribute (cls, fields(1)))
    val RegisteredResource: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val SubControlArea: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: CIMContext): ControlAreaDesignation =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[ControlAreaDesignation] = ControlAreaDesignationSerializer
}

object ControlAreaDesignationSerializer extends CIMSerializer[ControlAreaDesignation]
{
    def write (kryo: Kryo, output: Output, obj: ControlAreaDesignation): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.attained),
            () => output.writeString (obj.`native`),
            () => writeList (obj.RegisteredResource, output),
            () => writeList (obj.SubControlArea, output)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ControlAreaDesignation]): ControlAreaDesignation =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ControlAreaDesignation (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) readList (input) else null,
            if (isSet (3)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A flowgate, is single or group of transmission elements intended to model MW flow impact relating to transmission limitations and transmission service usage.
 *
 * @param PowerSystemResource [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
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
final case class Flowgate
(
    PowerSystemResource: PowerSystemResource = null,
    direction: String = null,
    exportMWRating: Double = 0.0,
    importMWRating: Double = 0.0,
    CongestionRevenueRight: String = null,
    ConstraintResults: List[String] = null,
    ContractDistributionFactor: List[String] = null,
    FTRs: List[String] = null,
    FlowgateRelief: List[String] = null,
    FlowgateValue: List[String] = null,
    From_SubControlArea: String = null,
    GeneratingUnitDynamicValues: List[String] = null,
    GenericConstraints: String = null,
    HostControlArea: String = null,
    InterTie: List[String] = null,
    InterTieResults: List[String] = null,
    MktLine: List[String] = null,
    MktPowerTransformer: List[String] = null,
    MktTerminal: List[String] = null,
    RegisteredInterTie: List[String] = null,
    SecurityConstraints: String = null,
    To_SubControlArea: String = null,
    TranmissionRightEntitlement: List[String] = null,
    TransmissionCapacity: List[String] = null,
    ViolationLimits: List[String] = null
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
    override def sup: PowerSystemResource = PowerSystemResource

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
        implicit val clz: String = Flowgate.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Flowgate.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Flowgate.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Flowgate.fields (position), x))
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
        "\t<cim:Flowgate rdf:%s=\"%s\">\n%s\t</cim:Flowgate>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object Flowgate
extends
    CIMParseable[Flowgate]
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("CongestionRevenueRight", "CongestionRevenueRight", "0..1", "0..1"),
        CIMRelationship ("ConstraintResults", "ConstraintResults", "1..*", "1"),
        CIMRelationship ("ContractDistributionFactor", "ContractDistributionFactor", "0..*", "0..1"),
        CIMRelationship ("FTRs", "FTR", "0..*", "0..1"),
        CIMRelationship ("FlowgateRelief", "FlowgateRelief", "0..*", "1"),
        CIMRelationship ("FlowgateValue", "FlowgateValue", "0..*", "1"),
        CIMRelationship ("From_SubControlArea", "SubControlArea", "0..1", "0..*"),
        CIMRelationship ("GeneratingUnitDynamicValues", "GeneratingUnitDynamicValues", "0..*", "0..1"),
        CIMRelationship ("GenericConstraints", "GenericConstraints", "0..1", "0..*"),
        CIMRelationship ("HostControlArea", "HostControlArea", "0..1", "0..*"),
        CIMRelationship ("InterTie", "SchedulingPoint", "0..*", "0..1"),
        CIMRelationship ("InterTieResults", "InterTieResults", "1..*", "1"),
        CIMRelationship ("MktLine", "MktLine", "0..*", "0..*"),
        CIMRelationship ("MktPowerTransformer", "MktPowerTransformer", "0..*", "0..*"),
        CIMRelationship ("MktTerminal", "MktTerminal", "0..*", "0..1"),
        CIMRelationship ("RegisteredInterTie", "RegisteredInterTie", "0..*", "1"),
        CIMRelationship ("SecurityConstraints", "SecurityConstraints", "0..1", "0..1"),
        CIMRelationship ("To_SubControlArea", "SubControlArea", "0..1", "0..*"),
        CIMRelationship ("TranmissionRightEntitlement", "TransmissionInterfaceRightEntitlement", "0..*", "0..1"),
        CIMRelationship ("TransmissionCapacity", "TransmissionCapacity", "0..*", "0..1"),
        CIMRelationship ("ViolationLimits", "ViolationLimit", "0..*", "0..1")
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

    def parse (context: CIMContext): Flowgate =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[Flowgate] = FlowgateSerializer
}

object FlowgateSerializer extends CIMSerializer[Flowgate]
{
    def write (kryo: Kryo, output: Output, obj: Flowgate): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.direction),
            () => output.writeDouble (obj.exportMWRating),
            () => output.writeDouble (obj.importMWRating),
            () => output.writeString (obj.CongestionRevenueRight),
            () => writeList (obj.ConstraintResults, output),
            () => writeList (obj.ContractDistributionFactor, output),
            () => writeList (obj.FTRs, output),
            () => writeList (obj.FlowgateRelief, output),
            () => writeList (obj.FlowgateValue, output),
            () => output.writeString (obj.From_SubControlArea),
            () => writeList (obj.GeneratingUnitDynamicValues, output),
            () => output.writeString (obj.GenericConstraints),
            () => output.writeString (obj.HostControlArea),
            () => writeList (obj.InterTie, output),
            () => writeList (obj.InterTieResults, output),
            () => writeList (obj.MktLine, output),
            () => writeList (obj.MktPowerTransformer, output),
            () => writeList (obj.MktTerminal, output),
            () => writeList (obj.RegisteredInterTie, output),
            () => output.writeString (obj.SecurityConstraints),
            () => output.writeString (obj.To_SubControlArea),
            () => writeList (obj.TranmissionRightEntitlement, output),
            () => writeList (obj.TransmissionCapacity, output),
            () => writeList (obj.ViolationLimits, output)
        )
        PowerSystemResourceSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Flowgate]): Flowgate =
    {
        val parent = PowerSystemResourceSerializer.read (kryo, input, classOf[PowerSystemResource])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Flowgate (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) readList (input) else null,
            if (isSet (5)) readList (input) else null,
            if (isSet (6)) readList (input) else null,
            if (isSet (7)) readList (input) else null,
            if (isSet (8)) readList (input) else null,
            if (isSet (9)) input.readString else null,
            if (isSet (10)) readList (input) else null,
            if (isSet (11)) input.readString else null,
            if (isSet (12)) input.readString else null,
            if (isSet (13)) readList (input) else null,
            if (isSet (14)) readList (input) else null,
            if (isSet (15)) readList (input) else null,
            if (isSet (16)) readList (input) else null,
            if (isSet (17)) readList (input) else null,
            if (isSet (18)) readList (input) else null,
            if (isSet (19)) input.readString else null,
            if (isSet (20)) input.readString else null,
            if (isSet (21)) readList (input) else null,
            if (isSet (22)) readList (input) else null,
            if (isSet (23)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Flowgate defined partner.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param FlowgateValue [[ch.ninecode.model.FlowgateValue FlowgateValue]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
final case class FlowgatePartner
(
    IdentifiedObject: IdentifiedObject = null,
    FlowgateValue: String = null
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
    override def sup: IdentifiedObject = IdentifiedObject

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
        implicit val clz: String = FlowgatePartner.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (FlowgatePartner.fields (position), value)
        emitattr (0, FlowgateValue)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:FlowgatePartner rdf:%s=\"%s\">\n%s\t</cim:FlowgatePartner>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object FlowgatePartner
extends
    CIMParseable[FlowgatePartner]
{
    override val fields: Array[String] = Array[String] (
        "FlowgateValue"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("FlowgateValue", "FlowgateValue", "0..1", "0..1")
    )
    val FlowgateValue: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): FlowgatePartner =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = FlowgatePartner (
            IdentifiedObject.parse (context),
            mask (FlowgateValue (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[FlowgatePartner] = FlowgatePartnerSerializer
}

object FlowgatePartnerSerializer extends CIMSerializer[FlowgatePartner]
{
    def write (kryo: Kryo, output: Output, obj: FlowgatePartner): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.FlowgateValue)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[FlowgatePartner]): FlowgatePartner =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = FlowgatePartner (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * IDC (Interchange Distribution Calulator) sends data for a TLR (Transmission Loading Relief).
 *
 * @param Element Reference to the superclass object.
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
final case class FlowgateRelief
(
    Element: BasicElement = null,
    effectiveDate: String = null,
    idcTargetMktFlow: Int = 0,
    terminateDate: String = null,
    Flowgate: String = null
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
    override def sup: Element = Element

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
        "\t<cim:FlowgateRelief rdf:%s=\"%s\">\n%s\t</cim:FlowgateRelief>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object FlowgateRelief
extends
    CIMParseable[FlowgateRelief]
{
    override val fields: Array[String] = Array[String] (
        "effectiveDate",
        "idcTargetMktFlow",
        "terminateDate",
        "Flowgate"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Flowgate", "Flowgate", "1", "0..*")
    )
    val effectiveDate: Fielder = parse_element (element (cls, fields(0)))
    val idcTargetMktFlow: Fielder = parse_element (element (cls, fields(1)))
    val terminateDate: Fielder = parse_element (element (cls, fields(2)))
    val Flowgate: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: CIMContext): FlowgateRelief =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[FlowgateRelief] = FlowgateReliefSerializer
}

object FlowgateReliefSerializer extends CIMSerializer[FlowgateRelief]
{
    def write (kryo: Kryo, output: Output, obj: FlowgateRelief): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.effectiveDate),
            () => output.writeInt (obj.idcTargetMktFlow),
            () => output.writeString (obj.terminateDate),
            () => output.writeString (obj.Flowgate)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[FlowgateRelief]): FlowgateRelief =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = FlowgateRelief (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readInt else 0,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Day Ahead,  Network Native Load, Economic Dispatch, values used for calculation of Network Native Load (NNL) Determinator process.
 *
 * @param Element Reference to the superclass object.
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
final case class FlowgateValue
(
    Element: BasicElement = null,
    economicDispatchLimit: Int = 0,
    effectiveDate: String = null,
    firmNetworkLimit: Int = 0,
    flowDirectionFlag: String = null,
    mktFlow: Int = 0,
    netFirmNetworkLimit: Int = 0,
    Flowgate: String = null,
    FlowgatePartner: String = null
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
    override def sup: Element = Element

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
        "\t<cim:FlowgateValue rdf:%s=\"%s\">\n%s\t</cim:FlowgateValue>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object FlowgateValue
extends
    CIMParseable[FlowgateValue]
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Flowgate", "Flowgate", "1", "0..*"),
        CIMRelationship ("FlowgatePartner", "FlowgatePartner", "0..1", "0..1")
    )
    val economicDispatchLimit: Fielder = parse_element (element (cls, fields(0)))
    val effectiveDate: Fielder = parse_element (element (cls, fields(1)))
    val firmNetworkLimit: Fielder = parse_element (element (cls, fields(2)))
    val flowDirectionFlag: Fielder = parse_attribute (attribute (cls, fields(3)))
    val mktFlow: Fielder = parse_element (element (cls, fields(4)))
    val netFirmNetworkLimit: Fielder = parse_element (element (cls, fields(5)))
    val Flowgate: Fielder = parse_attribute (attribute (cls, fields(6)))
    val FlowgatePartner: Fielder = parse_attribute (attribute (cls, fields(7)))

    def parse (context: CIMContext): FlowgateValue =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[FlowgateValue] = FlowgateValueSerializer
}

object FlowgateValueSerializer extends CIMSerializer[FlowgateValue]
{
    def write (kryo: Kryo, output: Output, obj: FlowgateValue): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeInt (obj.economicDispatchLimit),
            () => output.writeString (obj.effectiveDate),
            () => output.writeInt (obj.firmNetworkLimit),
            () => output.writeString (obj.flowDirectionFlag),
            () => output.writeInt (obj.mktFlow),
            () => output.writeInt (obj.netFirmNetworkLimit),
            () => output.writeString (obj.Flowgate),
            () => output.writeString (obj.FlowgatePartner)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[FlowgateValue]): FlowgateValue =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = FlowgateValue (
            parent,
            if (isSet (0)) input.readInt else 0,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readInt else 0,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readInt else 0,
            if (isSet (5)) input.readInt else 0,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Forbbiden region is operating ranges where the units are unable to maintain steady operation without causing equipment damage.
 *
 * The four attributes that define a forbidden region are the low MW, the High MW, the crossing time, and the crossing cost.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param crossTime Time to cross the forbidden region in minutes.
 * @param crossingCost Cost associated with crossing the forbidden region
 * @param highMW High end of the region definition
 * @param lowMW Low end of the region definition.
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
final case class ForbiddenRegion
(
    IdentifiedObject: IdentifiedObject = null,
    crossTime: Int = 0,
    crossingCost: Double = 0.0,
    highMW: Double = 0.0,
    lowMW: Double = 0.0,
    RegisteredResource: List[String] = null
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
    override def sup: IdentifiedObject = IdentifiedObject

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
        implicit val clz: String = ForbiddenRegion.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ForbiddenRegion.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ForbiddenRegion.fields (position), x))
        emitelem (0, crossTime)
        emitelem (1, crossingCost)
        emitelem (2, highMW)
        emitelem (3, lowMW)
        emitattrs (4, RegisteredResource)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ForbiddenRegion rdf:%s=\"%s\">\n%s\t</cim:ForbiddenRegion>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object ForbiddenRegion
extends
    CIMParseable[ForbiddenRegion]
{
    override val fields: Array[String] = Array[String] (
        "crossTime",
        "crossingCost",
        "highMW",
        "lowMW",
        "RegisteredResource"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("RegisteredResource", "RegisteredResource", "0..*", "0..*")
    )
    val crossTime: Fielder = parse_element (element (cls, fields(0)))
    val crossingCost: Fielder = parse_element (element (cls, fields(1)))
    val highMW: Fielder = parse_element (element (cls, fields(2)))
    val lowMW: Fielder = parse_element (element (cls, fields(3)))
    val RegisteredResource: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: CIMContext): ForbiddenRegion =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[ForbiddenRegion] = ForbiddenRegionSerializer
}

object ForbiddenRegionSerializer extends CIMSerializer[ForbiddenRegion]
{
    def write (kryo: Kryo, output: Output, obj: ForbiddenRegion): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeInt (obj.crossTime),
            () => output.writeDouble (obj.crossingCost),
            () => output.writeDouble (obj.highMW),
            () => output.writeDouble (obj.lowMW),
            () => writeList (obj.RegisteredResource, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ForbiddenRegion]): ForbiddenRegion =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ForbiddenRegion (
            parent,
            if (isSet (0)) input.readInt else 0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Used to indicate former references to the same piece of equipment.
 *
 * The ID, name, and effectivity dates are utilized.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
final case class FormerReference
(
    IdentifiedObject: IdentifiedObject = null,
    RegisteredResource: String = null
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
    override def sup: IdentifiedObject = IdentifiedObject

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
        implicit val clz: String = FormerReference.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (FormerReference.fields (position), value)
        emitattr (0, RegisteredResource)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:FormerReference rdf:%s=\"%s\">\n%s\t</cim:FormerReference>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object FormerReference
extends
    CIMParseable[FormerReference]
{
    override val fields: Array[String] = Array[String] (
        "RegisteredResource"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("RegisteredResource", "RegisteredResource", "1", "0..*")
    )
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): FormerReference =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = FormerReference (
            IdentifiedObject.parse (context),
            mask (RegisteredResource (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[FormerReference] = FormerReferenceSerializer
}

object FormerReferenceSerializer extends CIMSerializer[FormerReference]
{
    def write (kryo: Kryo, output: Output, obj: FormerReference): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.RegisteredResource)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[FormerReference]): FormerReference =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = FormerReference (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Relationship between unit fuel cost in \$/kWh(Y-axis) and  unit output in MW (X-axis).
 *
 * @param Curve [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param RegisteredGenerator [[ch.ninecode.model.RegisteredGenerator RegisteredGenerator]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
final case class FuelCostCurve
(
    Curve: Curve = null,
    RegisteredGenerator: String = null
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
    override def sup: Curve = Curve

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
        implicit val clz: String = FuelCostCurve.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (FuelCostCurve.fields (position), value)
        emitattr (0, RegisteredGenerator)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:FuelCostCurve rdf:%s=\"%s\">\n%s\t</cim:FuelCostCurve>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object FuelCostCurve
extends
    CIMParseable[FuelCostCurve]
{
    override val fields: Array[String] = Array[String] (
        "RegisteredGenerator"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("RegisteredGenerator", "RegisteredGenerator", "0..1", "0..1")
    )
    val RegisteredGenerator: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): FuelCostCurve =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = FuelCostCurve (
            Curve.parse (context),
            mask (RegisteredGenerator (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[FuelCostCurve] = FuelCostCurveSerializer
}

object FuelCostCurveSerializer extends CIMSerializer[FuelCostCurve]
{
    def write (kryo: Kryo, output: Output, obj: FuelCostCurve): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.RegisteredGenerator)
        )
        CurveSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[FuelCostCurve]): FuelCostCurve =
    {
        val parent = CurveSerializer.read (kryo, input, classOf[Curve])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = FuelCostCurve (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Indication of region for fuel inventory purposes.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
final case class FuelRegion
(
    IdentifiedObject: IdentifiedObject = null,
    fuelRegionType: String = null,
    lastModified: String = null,
    GasPrice: String = null,
    OilPrice: String = null,
    RTO: String = null,
    RegisteredGenerator: List[String] = null
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
    override def sup: IdentifiedObject = IdentifiedObject

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
        implicit val clz: String = FuelRegion.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (FuelRegion.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (FuelRegion.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (FuelRegion.fields (position), x))
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
        "\t<cim:FuelRegion rdf:%s=\"%s\">\n%s\t</cim:FuelRegion>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object FuelRegion
extends
    CIMParseable[FuelRegion]
{
    override val fields: Array[String] = Array[String] (
        "fuelRegionType",
        "lastModified",
        "GasPrice",
        "OilPrice",
        "RTO",
        "RegisteredGenerator"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("GasPrice", "GasPrice", "1", "1"),
        CIMRelationship ("OilPrice", "OilPrice", "1", "1"),
        CIMRelationship ("RTO", "RTO", "1", "0..*"),
        CIMRelationship ("RegisteredGenerator", "RegisteredGenerator", "0..*", "0..1")
    )
    val fuelRegionType: Fielder = parse_element (element (cls, fields(0)))
    val lastModified: Fielder = parse_element (element (cls, fields(1)))
    val GasPrice: Fielder = parse_attribute (attribute (cls, fields(2)))
    val OilPrice: Fielder = parse_attribute (attribute (cls, fields(3)))
    val RTO: Fielder = parse_attribute (attribute (cls, fields(4)))
    val RegisteredGenerator: FielderMultiple = parse_attributes (attribute (cls, fields(5)))

    def parse (context: CIMContext): FuelRegion =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[FuelRegion] = FuelRegionSerializer
}

object FuelRegionSerializer extends CIMSerializer[FuelRegion]
{
    def write (kryo: Kryo, output: Output, obj: FuelRegion): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.fuelRegionType),
            () => output.writeString (obj.lastModified),
            () => output.writeString (obj.GasPrice),
            () => output.writeString (obj.OilPrice),
            () => output.writeString (obj.RTO),
            () => writeList (obj.RegisteredGenerator, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[FuelRegion]): FuelRegion =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = FuelRegion (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Price of gas in monetary units.
 *
 * @param Element Reference to the superclass object.
 * @param gasPriceIndex The average natural gas price at a defined fuel region.
 * @param FuelRegion [[ch.ninecode.model.FuelRegion FuelRegion]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
final case class GasPrice
(
    Element: BasicElement = null,
    gasPriceIndex: Double = 0.0,
    FuelRegion: String = null
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
    override def sup: Element = Element

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
        implicit val clz: String = GasPrice.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GasPrice.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (GasPrice.fields (position), value)
        emitelem (0, gasPriceIndex)
        emitattr (1, FuelRegion)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GasPrice rdf:%s=\"%s\">\n%s\t</cim:GasPrice>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object GasPrice
extends
    CIMParseable[GasPrice]
{
    override val fields: Array[String] = Array[String] (
        "gasPriceIndex",
        "FuelRegion"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("FuelRegion", "FuelRegion", "1", "1")
    )
    val gasPriceIndex: Fielder = parse_element (element (cls, fields(0)))
    val FuelRegion: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): GasPrice =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = GasPrice (
            BasicElement.parse (context),
            toDouble (mask (gasPriceIndex (), 0)),
            mask (FuelRegion (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[GasPrice] = GasPriceSerializer
}

object GasPriceSerializer extends CIMSerializer[GasPrice]
{
    def write (kryo: Kryo, output: Output, obj: GasPrice): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.gasPriceIndex),
            () => output.writeString (obj.FuelRegion)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[GasPrice]): GasPrice =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = GasPrice (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A HostControlArea has a set of tie points and a set of generator controls (i.e., AGC).
 *
 * It also has a total load, including transmission and distribution losses.
 *
 * @param PowerSystemResource [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
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
final case class HostControlArea
(
    PowerSystemResource: PowerSystemResource = null,
    areaControlMode: String = null,
    freqSetPoint: Double = 0.0,
    frequencyBiasFactor: Double = 0.0,
    AdjacentCASet: String = null,
    BidSelfSched: List[String] = null,
    CnodeDistributionFactor: List[String] = null,
    Controls: String = null,
    Flowgate: List[String] = null,
    LossClearingResults: List[String] = null,
    RTO: String = null,
    RegisteredResource: List[String] = null,
    SubControlAreas: List[String] = null,
    SysLoadDistribuFactor: List[String] = null,
    TransferInterface: List[String] = null
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
    override def sup: PowerSystemResource = PowerSystemResource

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
        implicit val clz: String = HostControlArea.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (HostControlArea.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (HostControlArea.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (HostControlArea.fields (position), x))
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
        "\t<cim:HostControlArea rdf:%s=\"%s\">\n%s\t</cim:HostControlArea>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object HostControlArea
extends
    CIMParseable[HostControlArea]
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AdjacentCASet", "AdjacentCASet", "0..1", "0..1"),
        CIMRelationship ("BidSelfSched", "BidSelfSched", "0..*", "0..1"),
        CIMRelationship ("CnodeDistributionFactor", "CnodeDistributionFactor", "0..*", "0..1"),
        CIMRelationship ("Controls", "ControlAreaOperator", "1", "1"),
        CIMRelationship ("Flowgate", "Flowgate", "0..*", "0..1"),
        CIMRelationship ("LossClearingResults", "LossClearingResults", "0..*", "0..1"),
        CIMRelationship ("RTO", "RTO", "1", "0..*"),
        CIMRelationship ("RegisteredResource", "RegisteredResource", "0..*", "0..1"),
        CIMRelationship ("SubControlAreas", "SubControlArea", "0..*", "1"),
        CIMRelationship ("SysLoadDistribuFactor", "SysLoadDistributionFactor", "0..*", "1"),
        CIMRelationship ("TransferInterface", "TransferInterface", "0..*", "0..1")
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

    def parse (context: CIMContext): HostControlArea =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[HostControlArea] = HostControlAreaSerializer
}

object HostControlAreaSerializer extends CIMSerializer[HostControlArea]
{
    def write (kryo: Kryo, output: Output, obj: HostControlArea): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.areaControlMode),
            () => output.writeDouble (obj.freqSetPoint),
            () => output.writeDouble (obj.frequencyBiasFactor),
            () => output.writeString (obj.AdjacentCASet),
            () => writeList (obj.BidSelfSched, output),
            () => writeList (obj.CnodeDistributionFactor, output),
            () => output.writeString (obj.Controls),
            () => writeList (obj.Flowgate, output),
            () => writeList (obj.LossClearingResults, output),
            () => output.writeString (obj.RTO),
            () => writeList (obj.RegisteredResource, output),
            () => writeList (obj.SubControlAreas, output),
            () => writeList (obj.SysLoadDistribuFactor, output),
            () => writeList (obj.TransferInterface, output)
        )
        PowerSystemResourceSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[HostControlArea]): HostControlArea =
    {
        val parent = PowerSystemResourceSerializer.read (kryo, input, classOf[PowerSystemResource])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = HostControlArea (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) readList (input) else null,
            if (isSet (5)) readList (input) else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) readList (input) else null,
            if (isSet (8)) readList (input) else null,
            if (isSet (9)) input.readString else null,
            if (isSet (10)) readList (input) else null,
            if (isSet (11)) readList (input) else null,
            if (isSet (12)) readList (input) else null,
            if (isSet (13)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Individual pricing node based on Pnode.
 *
 * @param Pnode [[ch.ninecode.model.Pnode Pnode]] Reference to the superclass object.
 * @param CongestionArea [[ch.ninecode.model.CongestionArea CongestionArea]] <em>undocumented</em>
 * @param GenDistributionFactor [[ch.ninecode.model.GenDistributionFactor GenDistributionFactor]] <em>undocumented</em>
 * @param LoadDistributionFactor [[ch.ninecode.model.LoadDistributionFactor LoadDistributionFactor]] <em>undocumented</em>
 * @param MktConnectivityNode [[ch.ninecode.model.MktConnectivityNode MktConnectivityNode]] <em>undocumented</em>
 * @param PnodeDistributionFactor [[ch.ninecode.model.PnodeDistributionFactor PnodeDistributionFactor]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
final case class IndividualPnode
(
    Pnode: Pnode = null,
    CongestionArea: List[String] = null,
    GenDistributionFactor: String = null,
    LoadDistributionFactor: String = null,
    MktConnectivityNode: String = null,
    PnodeDistributionFactor: List[String] = null
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
    override def sup: Pnode = Pnode

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
        implicit val clz: String = IndividualPnode.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (IndividualPnode.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (IndividualPnode.fields (position), x))
        emitattrs (0, CongestionArea)
        emitattr (1, GenDistributionFactor)
        emitattr (2, LoadDistributionFactor)
        emitattr (3, MktConnectivityNode)
        emitattrs (4, PnodeDistributionFactor)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:IndividualPnode rdf:%s=\"%s\">\n%s\t</cim:IndividualPnode>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object IndividualPnode
extends
    CIMParseable[IndividualPnode]
{
    override val fields: Array[String] = Array[String] (
        "CongestionArea",
        "GenDistributionFactor",
        "LoadDistributionFactor",
        "MktConnectivityNode",
        "PnodeDistributionFactor"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("CongestionArea", "CongestionArea", "0..*", "0..*"),
        CIMRelationship ("GenDistributionFactor", "GenDistributionFactor", "0..1", "0..1"),
        CIMRelationship ("LoadDistributionFactor", "LoadDistributionFactor", "0..1", "0..1"),
        CIMRelationship ("MktConnectivityNode", "MktConnectivityNode", "1", "0..1"),
        CIMRelationship ("PnodeDistributionFactor", "PnodeDistributionFactor", "0..*", "1")
    )
    val CongestionArea: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val GenDistributionFactor: Fielder = parse_attribute (attribute (cls, fields(1)))
    val LoadDistributionFactor: Fielder = parse_attribute (attribute (cls, fields(2)))
    val MktConnectivityNode: Fielder = parse_attribute (attribute (cls, fields(3)))
    val PnodeDistributionFactor: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: CIMContext): IndividualPnode =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[IndividualPnode] = IndividualPnodeSerializer
}

object IndividualPnodeSerializer extends CIMSerializer[IndividualPnode]
{
    def write (kryo: Kryo, output: Output, obj: IndividualPnode): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.CongestionArea, output),
            () => output.writeString (obj.GenDistributionFactor),
            () => output.writeString (obj.LoadDistributionFactor),
            () => output.writeString (obj.MktConnectivityNode),
            () => writeList (obj.PnodeDistributionFactor, output)
        )
        PnodeSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[IndividualPnode]): IndividualPnode =
    {
        val parent = PnodeSerializer.read (kryo, input, classOf[Pnode])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = IndividualPnode (
            parent,
            if (isSet (0)) readList (input) else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A specialized class of type AggregatedNode type.
 *
 * Defines Load Aggregation Points.
 *
 * @param AggregateNode [[ch.ninecode.model.AggregateNode AggregateNode]] Reference to the superclass object.
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
final case class LoadAggregationPoint
(
    AggregateNode: AggregateNode = null
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
    override def sup: AggregateNode = AggregateNode

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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:LoadAggregationPoint rdf:%s=\"%s\">\n%s\t</cim:LoadAggregationPoint>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object LoadAggregationPoint
extends
    CIMParseable[LoadAggregationPoint]
{

    def parse (context: CIMContext): LoadAggregationPoint =
    {
        val ret = LoadAggregationPoint (
            AggregateNode.parse (context)
        )
        ret
    }

    def serializer: Serializer[LoadAggregationPoint] = LoadAggregationPointSerializer
}

object LoadAggregationPointSerializer extends CIMSerializer[LoadAggregationPoint]
{
    def write (kryo: Kryo, output: Output, obj: LoadAggregationPoint): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        AggregateNodeSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[LoadAggregationPoint]): LoadAggregationPoint =
    {
        val parent = AggregateNodeSerializer.read (kryo, input, classOf[AggregateNode])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = LoadAggregationPoint (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Representing the ratio of the load share for the associated SC.
 *
 * @param Element Reference to the superclass object.
 * @param intervalEndTime Interval End Time
 * @param intervalStartTime Interval Start Time
 * @param share Share in percentage of total Market load for the selected time interval.
 * @param SchedulingCoordinator [[ch.ninecode.model.SchedulingCoordinator SchedulingCoordinator]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
final case class LoadRatio
(
    Element: BasicElement = null,
    intervalEndTime: String = null,
    intervalStartTime: String = null,
    share: Double = 0.0,
    SchedulingCoordinator: String = null
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
    override def sup: Element = Element

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
        "\t<cim:LoadRatio rdf:%s=\"%s\">\n%s\t</cim:LoadRatio>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object LoadRatio
extends
    CIMParseable[LoadRatio]
{
    override val fields: Array[String] = Array[String] (
        "intervalEndTime",
        "intervalStartTime",
        "share",
        "SchedulingCoordinator"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("SchedulingCoordinator", "SchedulingCoordinator", "0..1", "1")
    )
    val intervalEndTime: Fielder = parse_element (element (cls, fields(0)))
    val intervalStartTime: Fielder = parse_element (element (cls, fields(1)))
    val share: Fielder = parse_element (element (cls, fields(2)))
    val SchedulingCoordinator: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: CIMContext): LoadRatio =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[LoadRatio] = LoadRatioSerializer
}

object LoadRatioSerializer extends CIMSerializer[LoadRatio]
{
    def write (kryo: Kryo, output: Output, obj: LoadRatio): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.intervalEndTime),
            () => output.writeString (obj.intervalStartTime),
            () => output.writeDouble (obj.share),
            () => output.writeString (obj.SchedulingCoordinator)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[LoadRatio]): LoadRatio =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = LoadRatio (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Allows definition of reliability areas (e.g.. load pockets) within the ISO/RTO.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param RTO [[ch.ninecode.model.RTO RTO]] <em>undocumented</em>
 * @param RegisteredGenerator [[ch.ninecode.model.RegisteredGenerator RegisteredGenerator]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
final case class LocalReliabilityArea
(
    IdentifiedObject: IdentifiedObject = null,
    RTO: String = null,
    RegisteredGenerator: List[String] = null
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
    override def sup: IdentifiedObject = IdentifiedObject

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
        implicit val clz: String = LocalReliabilityArea.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (LocalReliabilityArea.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (LocalReliabilityArea.fields (position), x))
        emitattr (0, RTO)
        emitattrs (1, RegisteredGenerator)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:LocalReliabilityArea rdf:%s=\"%s\">\n%s\t</cim:LocalReliabilityArea>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object LocalReliabilityArea
extends
    CIMParseable[LocalReliabilityArea]
{
    override val fields: Array[String] = Array[String] (
        "RTO",
        "RegisteredGenerator"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("RTO", "RTO", "1", "0..*"),
        CIMRelationship ("RegisteredGenerator", "RegisteredGenerator", "0..*", "0..1")
    )
    val RTO: Fielder = parse_attribute (attribute (cls, fields(0)))
    val RegisteredGenerator: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): LocalReliabilityArea =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = LocalReliabilityArea (
            IdentifiedObject.parse (context),
            mask (RTO (), 0),
            masks (RegisteredGenerator (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[LocalReliabilityArea] = LocalReliabilityAreaSerializer
}

object LocalReliabilityAreaSerializer extends CIMSerializer[LocalReliabilityArea]
{
    def write (kryo: Kryo, output: Output, obj: LocalReliabilityArea): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.RTO),
            () => writeList (obj.RegisteredGenerator, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[LocalReliabilityArea]): LocalReliabilityArea =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = LocalReliabilityArea (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Provides a reference to the Market Power Mitigation test identifiers and methods for the results of the DA or RT markets.
 *
 * Specific data is the test identifier (Price, Conduct, or Impact) and the test method (System MPM, Local MPM, Alternate System MPM, or Alternate Local MPM).
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
final case class MPMTestCategory
(
    IdentifiedObject: IdentifiedObject = null,
    purposeFlag: String = null,
    testIdentifier: String = null,
    testMethod: String = null,
    MPMResourceStatus: List[String] = null,
    MPMTestResults: List[String] = null,
    MPMTestThreshold: List[String] = null
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
    override def sup: IdentifiedObject = IdentifiedObject

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
        implicit val clz: String = MPMTestCategory.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MPMTestCategory.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MPMTestCategory.fields (position), x))
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
        "\t<cim:MPMTestCategory rdf:%s=\"%s\">\n%s\t</cim:MPMTestCategory>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object MPMTestCategory
extends
    CIMParseable[MPMTestCategory]
{
    override val fields: Array[String] = Array[String] (
        "purposeFlag",
        "testIdentifier",
        "testMethod",
        "MPMResourceStatus",
        "MPMTestResults",
        "MPMTestThreshold"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("MPMResourceStatus", "MPMResourceStatus", "0..*", "1"),
        CIMRelationship ("MPMTestResults", "MPMTestResults", "0..*", "1"),
        CIMRelationship ("MPMTestThreshold", "MPMTestThreshold", "0..*", "1")
    )
    val purposeFlag: Fielder = parse_attribute (attribute (cls, fields(0)))
    val testIdentifier: Fielder = parse_attribute (attribute (cls, fields(1)))
    val testMethod: Fielder = parse_attribute (attribute (cls, fields(2)))
    val MPMResourceStatus: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val MPMTestResults: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val MPMTestThreshold: FielderMultiple = parse_attributes (attribute (cls, fields(5)))

    def parse (context: CIMContext): MPMTestCategory =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[MPMTestCategory] = MPMTestCategorySerializer
}

object MPMTestCategorySerializer extends CIMSerializer[MPMTestCategory]
{
    def write (kryo: Kryo, output: Output, obj: MPMTestCategory): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.purposeFlag),
            () => output.writeString (obj.testIdentifier),
            () => output.writeString (obj.testMethod),
            () => writeList (obj.MPMResourceStatus, output),
            () => writeList (obj.MPMTestResults, output),
            () => writeList (obj.MPMTestThreshold, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MPMTestCategory]): MPMTestCategory =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = MPMTestCategory (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) readList (input) else null,
            if (isSet (5)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Market Power Mitigation (MPM) test thresholds for resource as well as designated congestion areas (DCAs).
 *
 * @param Element Reference to the superclass object.
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
final case class MPMTestThreshold
(
    Element: BasicElement = null,
    marketType: String = null,
    percent: Double = 0.0,
    price: Double = 0.0,
    AggregatedPnode: List[String] = null,
    MPMTestCategory: String = null,
    RegisteredResource: List[String] = null
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
    override def sup: Element = Element

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
        implicit val clz: String = MPMTestThreshold.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MPMTestThreshold.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MPMTestThreshold.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MPMTestThreshold.fields (position), x))
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
        "\t<cim:MPMTestThreshold rdf:%s=\"%s\">\n%s\t</cim:MPMTestThreshold>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object MPMTestThreshold
extends
    CIMParseable[MPMTestThreshold]
{
    override val fields: Array[String] = Array[String] (
        "marketType",
        "percent",
        "price",
        "AggregatedPnode",
        "MPMTestCategory",
        "RegisteredResource"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AggregatedPnode", "AggregatedPnode", "0..*", "1..*"),
        CIMRelationship ("MPMTestCategory", "MPMTestCategory", "1", "0..*"),
        CIMRelationship ("RegisteredResource", "RegisteredResource", "0..*", "0..*")
    )
    val marketType: Fielder = parse_attribute (attribute (cls, fields(0)))
    val percent: Fielder = parse_element (element (cls, fields(1)))
    val price: Fielder = parse_element (element (cls, fields(2)))
    val AggregatedPnode: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val MPMTestCategory: Fielder = parse_attribute (attribute (cls, fields(4)))
    val RegisteredResource: FielderMultiple = parse_attributes (attribute (cls, fields(5)))

    def parse (context: CIMContext): MPMTestThreshold =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[MPMTestThreshold] = MPMTestThresholdSerializer
}

object MPMTestThresholdSerializer extends CIMSerializer[MPMTestThreshold]
{
    def write (kryo: Kryo, output: Output, obj: MPMTestThreshold): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.marketType),
            () => output.writeDouble (obj.percent),
            () => output.writeDouble (obj.price),
            () => writeList (obj.AggregatedPnode, output),
            () => output.writeString (obj.MPMTestCategory),
            () => writeList (obj.RegisteredResource, output)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MPMTestThreshold]): MPMTestThreshold =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = MPMTestThreshold (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Metered Sub-System aggregation of MSS Zones.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
final case class MSSAggregation
(
    IdentifiedObject: IdentifiedObject = null,
    costRecovery: String = null,
    grossSettlement: String = null,
    ignoreLosses: String = null,
    ignoreMarginalLosses: String = null,
    loadFollowing: String = null,
    rucProcurement: String = null,
    MeteredSubSystem: List[String] = null,
    RTO: String = null
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
    override def sup: IdentifiedObject = IdentifiedObject

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
        implicit val clz: String = MSSAggregation.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MSSAggregation.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MSSAggregation.fields (position), x))
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
        "\t<cim:MSSAggregation rdf:%s=\"%s\">\n%s\t</cim:MSSAggregation>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object MSSAggregation
extends
    CIMParseable[MSSAggregation]
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("MeteredSubSystem", "MeteredSubSystem", "1..*", "0..1"),
        CIMRelationship ("RTO", "RTO", "1", "0..*")
    )
    val costRecovery: Fielder = parse_attribute (attribute (cls, fields(0)))
    val grossSettlement: Fielder = parse_attribute (attribute (cls, fields(1)))
    val ignoreLosses: Fielder = parse_attribute (attribute (cls, fields(2)))
    val ignoreMarginalLosses: Fielder = parse_attribute (attribute (cls, fields(3)))
    val loadFollowing: Fielder = parse_attribute (attribute (cls, fields(4)))
    val rucProcurement: Fielder = parse_attribute (attribute (cls, fields(5)))
    val MeteredSubSystem: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val RTO: Fielder = parse_attribute (attribute (cls, fields(7)))

    def parse (context: CIMContext): MSSAggregation =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[MSSAggregation] = MSSAggregationSerializer
}

object MSSAggregationSerializer extends CIMSerializer[MSSAggregation]
{
    def write (kryo: Kryo, output: Output, obj: MSSAggregation): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.costRecovery),
            () => output.writeString (obj.grossSettlement),
            () => output.writeString (obj.ignoreLosses),
            () => output.writeString (obj.ignoreMarginalLosses),
            () => output.writeString (obj.loadFollowing),
            () => output.writeString (obj.rucProcurement),
            () => writeList (obj.MeteredSubSystem, output),
            () => output.writeString (obj.RTO)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MSSAggregation]): MSSAggregation =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = MSSAggregation (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) readList (input) else null,
            if (isSet (7)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Model to define a zone within a Metered Sub System.
 *
 * @param AggregateNode [[ch.ninecode.model.AggregateNode AggregateNode]] Reference to the superclass object.
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
final case class MSSZone
(
    AggregateNode: AggregateNode = null,
    ignoreLosses: String = null,
    lossFactor: Double = 0.0,
    rucGrossSettlement: String = null,
    MeteredSubSystem: String = null
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
    override def sup: AggregateNode = AggregateNode

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
        "\t<cim:MSSZone rdf:%s=\"%s\">\n%s\t</cim:MSSZone>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object MSSZone
extends
    CIMParseable[MSSZone]
{
    override val fields: Array[String] = Array[String] (
        "ignoreLosses",
        "lossFactor",
        "rucGrossSettlement",
        "MeteredSubSystem"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("MeteredSubSystem", "MeteredSubSystem", "0..1", "0..*")
    )
    val ignoreLosses: Fielder = parse_attribute (attribute (cls, fields(0)))
    val lossFactor: Fielder = parse_element (element (cls, fields(1)))
    val rucGrossSettlement: Fielder = parse_attribute (attribute (cls, fields(2)))
    val MeteredSubSystem: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: CIMContext): MSSZone =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[MSSZone] = MSSZoneSerializer
}

object MSSZoneSerializer extends CIMSerializer[MSSZone]
{
    def write (kryo: Kryo, output: Output, obj: MSSZone): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.ignoreLosses),
            () => output.writeDouble (obj.lossFactor),
            () => output.writeString (obj.rucGrossSettlement),
            () => output.writeString (obj.MeteredSubSystem)
        )
        AggregateNodeSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MSSZone]): MSSZone =
    {
        val parent = AggregateNodeSerializer.read (kryo, input, classOf[AggregateNode])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = MSSZone (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * General purpose information for name and other information to contact people.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param category Category of this person relative to utility operations, classified according to the utility's corporate standards and practices.
 *        Examples include employee, contractor, agent, not affiliated, etc.
 *        This field is not used to indicate whether this person is a customer of the utility. Often an employee or contractor is also a customer. Customer information is gained with relationship to Organisation and CustomerData. In similar fashion, this field does not indicate the various roles this person may fill as part of utility operations.
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
final case class MarketPerson
(
    IdentifiedObject: IdentifiedObject = null,
    category: String = null,
    electronicAddressAlternate: String = null,
    electronicAddressPrimary: String = null,
    firstName: String = null,
    governmentID: String = null,
    landlinePhone: String = null,
    lastName: String = null,
    mName: String = null,
    mobilePhone: String = null,
    prefix: String = null,
    specialNeed: String = null,
    status: String = null,
    suffix: String = null,
    userID: String = null,
    MarketParticipant: List[String] = null,
    MarketSkills: List[String] = null
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
    override def sup: IdentifiedObject = IdentifiedObject

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
        implicit val clz: String = MarketPerson.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MarketPerson.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MarketPerson.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MarketPerson.fields (position), x))
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
        "\t<cim:MarketPerson rdf:%s=\"%s\">\n%s\t</cim:MarketPerson>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object MarketPerson
extends
    CIMParseable[MarketPerson]
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("MarketParticipant", "MarketParticipant", "0..*", "0..*"),
        CIMRelationship ("MarketSkills", "MarketSkill", "0..*", "0..1")
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

    def parse (context: CIMContext): MarketPerson =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[MarketPerson] = MarketPersonSerializer
}

object MarketPersonSerializer extends CIMSerializer[MarketPerson]
{
    def write (kryo: Kryo, output: Output, obj: MarketPerson): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.category),
            () => output.writeString (obj.electronicAddressAlternate),
            () => output.writeString (obj.electronicAddressPrimary),
            () => output.writeString (obj.firstName),
            () => output.writeString (obj.governmentID),
            () => output.writeString (obj.landlinePhone),
            () => output.writeString (obj.lastName),
            () => output.writeString (obj.mName),
            () => output.writeString (obj.mobilePhone),
            () => output.writeString (obj.prefix),
            () => output.writeString (obj.specialNeed),
            () => output.writeString (obj.status),
            () => output.writeString (obj.suffix),
            () => output.writeString (obj.userID),
            () => writeList (obj.MarketParticipant, output),
            () => writeList (obj.MarketSkills, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MarketPerson]): MarketPerson =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = MarketPerson (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) input.readString else null,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) input.readString else null,
            if (isSet (10)) input.readString else null,
            if (isSet (11)) input.readString else null,
            if (isSet (12)) input.readString else null,
            if (isSet (13)) input.readString else null,
            if (isSet (14)) readList (input) else null,
            if (isSet (15)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Certain skills are required and shall be certified in order for a person (typically a member of a crew) to be qualified to work on types of equipment.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param effectiveDate Effective date of the privilege, terminate date of the privilege, or effective date of the application for the organization
 * @param expirationDate This is the terminate date of the application for the organization
 *        The specific organization can no longer access the application as of the terminate date
 * @param qualificationID Qualification identifier.
 * @param status The status of the privilege.
 *        Shows the status of the user´s qualification.
 *        The current statuses are: 1=New, 2=Active, 3=Refused, 4=Terminated, 5=Withdrawn
 *        and it is subject to update.
 * @param statusType This is the name of the status of the qualification and is used to display the status of the user's or organization's status.
 * @param MarketSkills [[ch.ninecode.model.MarketSkill MarketSkill]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
final case class MarketQualificationRequirement
(
    IdentifiedObject: IdentifiedObject = null,
    effectiveDate: String = null,
    expirationDate: String = null,
    qualificationID: String = null,
    status: Int = 0,
    statusType: String = null,
    MarketSkills: List[String] = null
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
    override def sup: IdentifiedObject = IdentifiedObject

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
        implicit val clz: String = MarketQualificationRequirement.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MarketQualificationRequirement.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MarketQualificationRequirement.fields (position), x))
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
        "\t<cim:MarketQualificationRequirement rdf:%s=\"%s\">\n%s\t</cim:MarketQualificationRequirement>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object MarketQualificationRequirement
extends
    CIMParseable[MarketQualificationRequirement]
{
    override val fields: Array[String] = Array[String] (
        "effectiveDate",
        "expirationDate",
        "qualificationID",
        "status",
        "statusType",
        "MarketSkills"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("MarketSkills", "MarketSkill", "0..*", "0..*")
    )
    val effectiveDate: Fielder = parse_element (element (cls, fields(0)))
    val expirationDate: Fielder = parse_element (element (cls, fields(1)))
    val qualificationID: Fielder = parse_element (element (cls, fields(2)))
    val status: Fielder = parse_element (element (cls, fields(3)))
    val statusType: Fielder = parse_element (element (cls, fields(4)))
    val MarketSkills: FielderMultiple = parse_attributes (attribute (cls, fields(5)))

    def parse (context: CIMContext): MarketQualificationRequirement =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[MarketQualificationRequirement] = MarketQualificationRequirementSerializer
}

object MarketQualificationRequirementSerializer extends CIMSerializer[MarketQualificationRequirement]
{
    def write (kryo: Kryo, output: Output, obj: MarketQualificationRequirement): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.effectiveDate),
            () => output.writeString (obj.expirationDate),
            () => output.writeString (obj.qualificationID),
            () => output.writeInt (obj.status),
            () => output.writeString (obj.statusType),
            () => writeList (obj.MarketSkills, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MarketQualificationRequirement]): MarketQualificationRequirement =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = MarketQualificationRequirement (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readInt else 0,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A specialized class of AggregatedNode type.
 *
 * Defines the MarketRegions. Regions could be system Market Regions, Energy Regions or Ancillary Service Regions.
 *
 * @param AggregateNode [[ch.ninecode.model.AggregateNode AggregateNode]] Reference to the superclass object.
 * @param ExPostMarketRegionResults [[ch.ninecode.model.ExPostMarketRegionResults ExPostMarketRegionResults]] <em>undocumented</em>
 * @param MarketRegionResults [[ch.ninecode.model.MarketRegionResults MarketRegionResults]] <em>undocumented</em>
 * @param ReserveDemandCurve [[ch.ninecode.model.ReserveDemandCurve ReserveDemandCurve]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
final case class MarketRegion
(
    AggregateNode: AggregateNode = null,
    ExPostMarketRegionResults: List[String] = null,
    MarketRegionResults: List[String] = null,
    ReserveDemandCurve: List[String] = null
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
    override def sup: AggregateNode = AggregateNode

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
        implicit val clz: String = MarketRegion.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MarketRegion.fields (position), x))
        emitattrs (0, ExPostMarketRegionResults)
        emitattrs (1, MarketRegionResults)
        emitattrs (2, ReserveDemandCurve)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MarketRegion rdf:%s=\"%s\">\n%s\t</cim:MarketRegion>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object MarketRegion
extends
    CIMParseable[MarketRegion]
{
    override val fields: Array[String] = Array[String] (
        "ExPostMarketRegionResults",
        "MarketRegionResults",
        "ReserveDemandCurve"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ExPostMarketRegionResults", "ExPostMarketRegionResults", "0..*", "1"),
        CIMRelationship ("MarketRegionResults", "MarketRegionResults", "1..*", "1"),
        CIMRelationship ("ReserveDemandCurve", "ReserveDemandCurve", "0..*", "1")
    )
    val ExPostMarketRegionResults: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val MarketRegionResults: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val ReserveDemandCurve: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: CIMContext): MarketRegion =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MarketRegion (
            AggregateNode.parse (context),
            masks (ExPostMarketRegionResults (), 0),
            masks (MarketRegionResults (), 1),
            masks (ReserveDemandCurve (), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[MarketRegion] = MarketRegionSerializer
}

object MarketRegionSerializer extends CIMSerializer[MarketRegion]
{
    def write (kryo: Kryo, output: Output, obj: MarketRegion): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.ExPostMarketRegionResults, output),
            () => writeList (obj.MarketRegionResults, output),
            () => writeList (obj.ReserveDemandCurve, output)
        )
        AggregateNodeSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MarketRegion]): MarketRegion =
    {
        val parent = AggregateNodeSerializer.read (kryo, input, classOf[AggregateNode])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = MarketRegion (
            parent,
            if (isSet (0)) readList (input) else null,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Proficiency level of a craft, which is required to operate or maintain a particular type of asset and/or perform certain types of work.
 *
 * @param Document [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param certificationPeriod Interval between the certification and its expiry.
 * @param effectiveDateTime Date and time the skill became effective.
 * @param level Level of skill for a Craft.
 * @param MarketPerson [[ch.ninecode.model.MarketPerson MarketPerson]] <em>undocumented</em>
 * @param MarketQualificationRequirements [[ch.ninecode.model.MarketQualificationRequirement MarketQualificationRequirement]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
final case class MarketSkill
(
    Document: Document = null,
    certificationPeriod: String = null,
    effectiveDateTime: String = null,
    level: String = null,
    MarketPerson: String = null,
    MarketQualificationRequirements: List[String] = null
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
    override def sup: Document = Document

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
        implicit val clz: String = MarketSkill.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MarketSkill.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MarketSkill.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MarketSkill.fields (position), x))
        emitattr (0, certificationPeriod)
        emitelem (1, effectiveDateTime)
        emitelem (2, level)
        emitattr (3, MarketPerson)
        emitattrs (4, MarketQualificationRequirements)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MarketSkill rdf:%s=\"%s\">\n%s\t</cim:MarketSkill>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object MarketSkill
extends
    CIMParseable[MarketSkill]
{
    override val fields: Array[String] = Array[String] (
        "certificationPeriod",
        "effectiveDateTime",
        "level",
        "MarketPerson",
        "MarketQualificationRequirements"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("MarketPerson", "MarketPerson", "0..1", "0..*"),
        CIMRelationship ("MarketQualificationRequirements", "MarketQualificationRequirement", "0..*", "0..*")
    )
    val certificationPeriod: Fielder = parse_attribute (attribute (cls, fields(0)))
    val effectiveDateTime: Fielder = parse_element (element (cls, fields(1)))
    val level: Fielder = parse_element (element (cls, fields(2)))
    val MarketPerson: Fielder = parse_attribute (attribute (cls, fields(3)))
    val MarketQualificationRequirements: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: CIMContext): MarketSkill =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[MarketSkill] = MarketSkillSerializer
}

object MarketSkillSerializer extends CIMSerializer[MarketSkill]
{
    def write (kryo: Kryo, output: Output, obj: MarketSkill): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.certificationPeriod),
            () => output.writeString (obj.effectiveDateTime),
            () => output.writeString (obj.level),
            () => output.writeString (obj.MarketPerson),
            () => writeList (obj.MarketQualificationRequirements, output)
        )
        DocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MarketSkill]): MarketSkill =
    {
        val parent = DocumentSerializer.read (kryo, input, classOf[Document])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = MarketSkill (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The maximum Startup costs and time as a function of down time.
 *
 * Relationship between unit startup cost (Y1-axis) vs. unit elapsed down time (X-axis). This is used to validate the information provided in the Bid.
 *
 * @param Curve [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
final case class MaxStartUpCostCurve
(
    Curve: Curve = null
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
    override def sup: Curve = Curve

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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:MaxStartUpCostCurve rdf:%s=\"%s\">\n%s\t</cim:MaxStartUpCostCurve>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object MaxStartUpCostCurve
extends
    CIMParseable[MaxStartUpCostCurve]
{

    def parse (context: CIMContext): MaxStartUpCostCurve =
    {
        val ret = MaxStartUpCostCurve (
            Curve.parse (context)
        )
        ret
    }

    def serializer: Serializer[MaxStartUpCostCurve] = MaxStartUpCostCurveSerializer
}

object MaxStartUpCostCurveSerializer extends CIMSerializer[MaxStartUpCostCurve]
{
    def write (kryo: Kryo, output: Output, obj: MaxStartUpCostCurve): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        CurveSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MaxStartUpCostCurve]): MaxStartUpCostCurve =
    {
        val parent = CurveSerializer.read (kryo, input, classOf[Curve])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = MaxStartUpCostCurve (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A metered subsystem.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param MSSAggregation [[ch.ninecode.model.MSSAggregation MSSAggregation]] <em>undocumented</em>
 * @param MSSZone [[ch.ninecode.model.MSSZone MSSZone]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
final case class MeteredSubSystem
(
    IdentifiedObject: IdentifiedObject = null,
    MSSAggregation: String = null,
    MSSZone: List[String] = null
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
    override def sup: IdentifiedObject = IdentifiedObject

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
        implicit val clz: String = MeteredSubSystem.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MeteredSubSystem.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MeteredSubSystem.fields (position), x))
        emitattr (0, MSSAggregation)
        emitattrs (1, MSSZone)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MeteredSubSystem rdf:%s=\"%s\">\n%s\t</cim:MeteredSubSystem>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object MeteredSubSystem
extends
    CIMParseable[MeteredSubSystem]
{
    override val fields: Array[String] = Array[String] (
        "MSSAggregation",
        "MSSZone"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("MSSAggregation", "MSSAggregation", "0..1", "1..*"),
        CIMRelationship ("MSSZone", "MSSZone", "0..*", "0..1")
    )
    val MSSAggregation: Fielder = parse_attribute (attribute (cls, fields(0)))
    val MSSZone: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): MeteredSubSystem =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MeteredSubSystem (
            IdentifiedObject.parse (context),
            mask (MSSAggregation (), 0),
            masks (MSSZone (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[MeteredSubSystem] = MeteredSubSystemSerializer
}

object MeteredSubSystemSerializer extends CIMSerializer[MeteredSubSystem]
{
    def write (kryo: Kryo, output: Output, obj: MeteredSubSystem): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.MSSAggregation),
            () => writeList (obj.MSSZone, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MeteredSubSystem]): MeteredSubSystem =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = MeteredSubSystem (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Subclass of Production: CombinedCyclePlant from IEC 61970 package.
 *
 * A set of combustion turbines and steam turbines where the exhaust heat from the combustion turbines is recovered to make steam for the steam turbines, resulting in greater overall plant efficiency.
 *
 * @param CombinedCyclePlant [[ch.ninecode.model.CombinedCyclePlant CombinedCyclePlant]] Reference to the superclass object.
 * @param AggregatedPnode [[ch.ninecode.model.AggregatedPnode AggregatedPnode]] <em>undocumented</em>
 * @param CombinedCycleLogicalConfiguration [[ch.ninecode.model.CombinedCycleLogicalConfiguration CombinedCycleLogicalConfiguration]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
final case class MktCombinedCyclePlant
(
    CombinedCyclePlant: CombinedCyclePlant = null,
    AggregatedPnode: String = null,
    CombinedCycleLogicalConfiguration: List[String] = null
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
    override def sup: CombinedCyclePlant = CombinedCyclePlant

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
        implicit val clz: String = MktCombinedCyclePlant.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MktCombinedCyclePlant.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MktCombinedCyclePlant.fields (position), x))
        emitattr (0, AggregatedPnode)
        emitattrs (1, CombinedCycleLogicalConfiguration)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MktCombinedCyclePlant rdf:%s=\"%s\">\n%s\t</cim:MktCombinedCyclePlant>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object MktCombinedCyclePlant
extends
    CIMParseable[MktCombinedCyclePlant]
{
    override val fields: Array[String] = Array[String] (
        "AggregatedPnode",
        "CombinedCycleLogicalConfiguration"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AggregatedPnode", "AggregatedPnode", "0..1", "0..*"),
        CIMRelationship ("CombinedCycleLogicalConfiguration", "CombinedCycleLogicalConfiguration", "1..*", "0..1")
    )
    val AggregatedPnode: Fielder = parse_attribute (attribute (cls, fields(0)))
    val CombinedCycleLogicalConfiguration: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): MktCombinedCyclePlant =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MktCombinedCyclePlant (
            CombinedCyclePlant.parse (context),
            mask (AggregatedPnode (), 0),
            masks (CombinedCycleLogicalConfiguration (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[MktCombinedCyclePlant] = MktCombinedCyclePlantSerializer
}

object MktCombinedCyclePlantSerializer extends CIMSerializer[MktCombinedCyclePlant]
{
    def write (kryo: Kryo, output: Output, obj: MktCombinedCyclePlant): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.AggregatedPnode),
            () => writeList (obj.CombinedCycleLogicalConfiguration, output)
        )
        CombinedCyclePlantSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MktCombinedCyclePlant]): MktCombinedCyclePlant =
    {
        val parent = CombinedCyclePlantSerializer.read (kryo, input, classOf[CombinedCyclePlant])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = MktCombinedCyclePlant (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Subclass of IEC 61970:Core:ConductingEquipment.
 *
 * @param ConductingEquipment [[ch.ninecode.model.ConductingEquipment ConductingEquipment]] Reference to the superclass object.
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
final case class MktConductingEquipment
(
    ConductingEquipment: ConductingEquipment = null
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
    override def sup: ConductingEquipment = ConductingEquipment

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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:MktConductingEquipment rdf:%s=\"%s\">\n%s\t</cim:MktConductingEquipment>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object MktConductingEquipment
extends
    CIMParseable[MktConductingEquipment]
{

    def parse (context: CIMContext): MktConductingEquipment =
    {
        val ret = MktConductingEquipment (
            ConductingEquipment.parse (context)
        )
        ret
    }

    def serializer: Serializer[MktConductingEquipment] = MktConductingEquipmentSerializer
}

object MktConductingEquipmentSerializer extends CIMSerializer[MktConductingEquipment]
{
    def write (kryo: Kryo, output: Output, obj: MktConductingEquipment): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        ConductingEquipmentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MktConductingEquipment]): MktConductingEquipment =
    {
        val parent = ConductingEquipmentSerializer.read (kryo, input, classOf[ConductingEquipment])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = MktConductingEquipment (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Subclass of IEC 61970:Contingency.
 *
 * @param Contingency [[ch.ninecode.model.Contingency Contingency]] Reference to the superclass object.
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
final case class MktContingency
(
    Contingency: Contingency = null,
    loadRolloverFlag: Boolean = false,
    ltcControlFlag: Boolean = false,
    participationFactorSet: String = null,
    screeningFlag: Boolean = false,
    ConstraintResults: List[String] = null,
    ContingencyConstraintLimit: List[String] = null,
    TransferInterfaceSolutionA: String = null,
    TransferInterfaceSolutionB: String = null
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
    override def sup: Contingency = Contingency

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
        implicit val clz: String = MktContingency.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MktContingency.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MktContingency.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MktContingency.fields (position), x))
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
        "\t<cim:MktContingency rdf:%s=\"%s\">\n%s\t</cim:MktContingency>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object MktContingency
extends
    CIMParseable[MktContingency]
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ConstraintResults", "ConstraintResults", "0..*", "1"),
        CIMRelationship ("ContingencyConstraintLimit", "ContingencyConstraintLimit", "0..*", "1"),
        CIMRelationship ("TransferInterfaceSolutionA", "TransferInterfaceSolution", "0..1", "0..1"),
        CIMRelationship ("TransferInterfaceSolutionB", "TransferInterfaceSolution", "0..1", "0..1")
    )
    val loadRolloverFlag: Fielder = parse_element (element (cls, fields(0)))
    val ltcControlFlag: Fielder = parse_element (element (cls, fields(1)))
    val participationFactorSet: Fielder = parse_element (element (cls, fields(2)))
    val screeningFlag: Fielder = parse_element (element (cls, fields(3)))
    val ConstraintResults: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val ContingencyConstraintLimit: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val TransferInterfaceSolutionA: Fielder = parse_attribute (attribute (cls, fields(6)))
    val TransferInterfaceSolutionB: Fielder = parse_attribute (attribute (cls, fields(7)))

    def parse (context: CIMContext): MktContingency =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[MktContingency] = MktContingencySerializer
}

object MktContingencySerializer extends CIMSerializer[MktContingency]
{
    def write (kryo: Kryo, output: Output, obj: MktContingency): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeBoolean (obj.loadRolloverFlag),
            () => output.writeBoolean (obj.ltcControlFlag),
            () => output.writeString (obj.participationFactorSet),
            () => output.writeBoolean (obj.screeningFlag),
            () => writeList (obj.ConstraintResults, output),
            () => writeList (obj.ContingencyConstraintLimit, output),
            () => output.writeString (obj.TransferInterfaceSolutionA),
            () => output.writeString (obj.TransferInterfaceSolutionB)
        )
        ContingencySerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MktContingency]): MktContingency =
    {
        val parent = ContingencySerializer.read (kryo, input, classOf[Contingency])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = MktContingency (
            parent,
            if (isSet (0)) input.readBoolean else false,
            if (isSet (1)) input.readBoolean else false,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readBoolean else false,
            if (isSet (4)) readList (input) else null,
            if (isSet (5)) readList (input) else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Subclass of IEC 61970: Generation: Production:HeatRateCurve.
 *
 * @param HeatRateCurve [[ch.ninecode.model.HeatRateCurve HeatRateCurve]] Reference to the superclass object.
 * @param RegisteredGenerator [[ch.ninecode.model.RegisteredGenerator RegisteredGenerator]] <em>undocumented</em>
 * @param ResourceVerifiableCosts [[ch.ninecode.model.ResourceVerifiableCosts ResourceVerifiableCosts]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
final case class MktHeatRateCurve
(
    HeatRateCurve: HeatRateCurve = null,
    RegisteredGenerator: String = null,
    ResourceVerifiableCosts: String = null
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
    override def sup: HeatRateCurve = HeatRateCurve

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
        implicit val clz: String = MktHeatRateCurve.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MktHeatRateCurve.fields (position), value)
        emitattr (0, RegisteredGenerator)
        emitattr (1, ResourceVerifiableCosts)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MktHeatRateCurve rdf:%s=\"%s\">\n%s\t</cim:MktHeatRateCurve>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object MktHeatRateCurve
extends
    CIMParseable[MktHeatRateCurve]
{
    override val fields: Array[String] = Array[String] (
        "RegisteredGenerator",
        "ResourceVerifiableCosts"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("RegisteredGenerator", "RegisteredGenerator", "0..1", "0..1"),
        CIMRelationship ("ResourceVerifiableCosts", "ResourceVerifiableCosts", "0..1", "1")
    )
    val RegisteredGenerator: Fielder = parse_attribute (attribute (cls, fields(0)))
    val ResourceVerifiableCosts: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): MktHeatRateCurve =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MktHeatRateCurve (
            HeatRateCurve.parse (context),
            mask (RegisteredGenerator (), 0),
            mask (ResourceVerifiableCosts (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[MktHeatRateCurve] = MktHeatRateCurveSerializer
}

object MktHeatRateCurveSerializer extends CIMSerializer[MktHeatRateCurve]
{
    def write (kryo: Kryo, output: Output, obj: MktHeatRateCurve): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.RegisteredGenerator),
            () => output.writeString (obj.ResourceVerifiableCosts)
        )
        HeatRateCurveSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MktHeatRateCurve]): MktHeatRateCurve =
    {
        val parent = HeatRateCurveSerializer.read (kryo, input, classOf[HeatRateCurve])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = MktHeatRateCurve (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Subclass of ThermalGeneratingUnit from Production Package in IEC 61970.
 *
 * @param ThermalGeneratingUnit [[ch.ninecode.model.ThermalGeneratingUnit ThermalGeneratingUnit]] Reference to the superclass object.
 * @param CombinedCycleConfigurationMember [[ch.ninecode.model.CombinedCycleConfigurationMember CombinedCycleConfigurationMember]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
final case class MktThermalGeneratingUnit
(
    ThermalGeneratingUnit: ThermalGeneratingUnit = null,
    CombinedCycleConfigurationMember: List[String] = null
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
    override def sup: ThermalGeneratingUnit = ThermalGeneratingUnit

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
        implicit val clz: String = MktThermalGeneratingUnit.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MktThermalGeneratingUnit.fields (position), x))
        emitattrs (0, CombinedCycleConfigurationMember)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MktThermalGeneratingUnit rdf:%s=\"%s\">\n%s\t</cim:MktThermalGeneratingUnit>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object MktThermalGeneratingUnit
extends
    CIMParseable[MktThermalGeneratingUnit]
{
    override val fields: Array[String] = Array[String] (
        "CombinedCycleConfigurationMember"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("CombinedCycleConfigurationMember", "CombinedCycleConfigurationMember", "0..*", "1")
    )
    val CombinedCycleConfigurationMember: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): MktThermalGeneratingUnit =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MktThermalGeneratingUnit (
            ThermalGeneratingUnit.parse (context),
            masks (CombinedCycleConfigurationMember (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[MktThermalGeneratingUnit] = MktThermalGeneratingUnitSerializer
}

object MktThermalGeneratingUnitSerializer extends CIMSerializer[MktThermalGeneratingUnit]
{
    def write (kryo: Kryo, output: Output, obj: MktThermalGeneratingUnit): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.CombinedCycleConfigurationMember, output)
        )
        ThermalGeneratingUnitSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MktThermalGeneratingUnit]): MktThermalGeneratingUnit =
    {
        val parent = ThermalGeneratingUnitSerializer.read (kryo, input, classOf[ThermalGeneratingUnit])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = MktThermalGeneratingUnit (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Price of oil in monetary units.
 *
 * @param Element Reference to the superclass object.
 * @param oilPriceIndex The average oil price at a defined fuel region.
 * @param FuelRegion [[ch.ninecode.model.FuelRegion FuelRegion]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
final case class OilPrice
(
    Element: BasicElement = null,
    oilPriceIndex: Double = 0.0,
    FuelRegion: String = null
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
    override def sup: Element = Element

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
        implicit val clz: String = OilPrice.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (OilPrice.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OilPrice.fields (position), value)
        emitelem (0, oilPriceIndex)
        emitattr (1, FuelRegion)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OilPrice rdf:%s=\"%s\">\n%s\t</cim:OilPrice>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object OilPrice
extends
    CIMParseable[OilPrice]
{
    override val fields: Array[String] = Array[String] (
        "oilPriceIndex",
        "FuelRegion"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("FuelRegion", "FuelRegion", "1", "1")
    )
    val oilPriceIndex: Fielder = parse_element (element (cls, fields(0)))
    val FuelRegion: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): OilPrice =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OilPrice (
            BasicElement.parse (context),
            toDouble (mask (oilPriceIndex (), 0)),
            mask (FuelRegion (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[OilPrice] = OilPriceSerializer
}

object OilPriceSerializer extends CIMSerializer[OilPrice]
{
    def write (kryo: Kryo, output: Output, obj: OilPrice): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.oilPriceIndex),
            () => output.writeString (obj.FuelRegion)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OilPrice]): OilPrice =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = OilPrice (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * This class models the allocation between asset owners and pricing nodes.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param maxMWAllocation Maximum MW for the Source/Sink for the Allocation
 * @param Pnode [[ch.ninecode.model.Pnode Pnode]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
final case class OrgPnodeAllocation
(
    IdentifiedObject: IdentifiedObject = null,
    maxMWAllocation: Double = 0.0,
    Pnode: String = null
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
    override def sup: IdentifiedObject = IdentifiedObject

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
        implicit val clz: String = OrgPnodeAllocation.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (OrgPnodeAllocation.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OrgPnodeAllocation.fields (position), value)
        emitelem (0, maxMWAllocation)
        emitattr (1, Pnode)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OrgPnodeAllocation rdf:%s=\"%s\">\n%s\t</cim:OrgPnodeAllocation>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object OrgPnodeAllocation
extends
    CIMParseable[OrgPnodeAllocation]
{
    override val fields: Array[String] = Array[String] (
        "maxMWAllocation",
        "Pnode"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Pnode", "Pnode", "1", "0..*")
    )
    val maxMWAllocation: Fielder = parse_element (element (cls, fields(0)))
    val Pnode: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): OrgPnodeAllocation =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OrgPnodeAllocation (
            IdentifiedObject.parse (context),
            toDouble (mask (maxMWAllocation (), 0)),
            mask (Pnode (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[OrgPnodeAllocation] = OrgPnodeAllocationSerializer
}

object OrgPnodeAllocationSerializer extends CIMSerializer[OrgPnodeAllocation]
{
    def write (kryo: Kryo, output: Output, obj: OrgPnodeAllocation): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.maxMWAllocation),
            () => output.writeString (obj.Pnode)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OrgPnodeAllocation]): OrgPnodeAllocation =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = OrgPnodeAllocation (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * This class model the ownership percent and type of ownership between resource and organisation.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param asscType association type for the association between Organisation and Resource:
 * @param masterSchedulingCoordinatorFlag Flag to indicate that the SC representing the Resource is the Master SC.
 * @param ownershipPercent ownership percentage for each resource
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
final case class OrgResOwnership
(
    IdentifiedObject: IdentifiedObject = null,
    asscType: String = null,
    masterSchedulingCoordinatorFlag: String = null,
    ownershipPercent: Double = 0.0,
    RegisteredResource: String = null
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
    override def sup: IdentifiedObject = IdentifiedObject

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
        "\t<cim:OrgResOwnership rdf:%s=\"%s\">\n%s\t</cim:OrgResOwnership>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object OrgResOwnership
extends
    CIMParseable[OrgResOwnership]
{
    override val fields: Array[String] = Array[String] (
        "asscType",
        "masterSchedulingCoordinatorFlag",
        "ownershipPercent",
        "RegisteredResource"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("RegisteredResource", "RegisteredResource", "1", "0..*")
    )
    val asscType: Fielder = parse_attribute (attribute (cls, fields(0)))
    val masterSchedulingCoordinatorFlag: Fielder = parse_attribute (attribute (cls, fields(1)))
    val ownershipPercent: Fielder = parse_element (element (cls, fields(2)))
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: CIMContext): OrgResOwnership =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[OrgResOwnership] = OrgResOwnershipSerializer
}

object OrgResOwnershipSerializer extends CIMSerializer[OrgResOwnership]
{
    def write (kryo: Kryo, output: Output, obj: OrgResOwnership): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.asscType),
            () => output.writeString (obj.masterSchedulingCoordinatorFlag),
            () => output.writeDouble (obj.ownershipPercent),
            () => output.writeString (obj.RegisteredResource)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OrgResOwnership]): OrgResOwnership =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = OrgResOwnership (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A pricing node is directly associated with a connectivity node.
 *
 * It is a pricing location for which market participants submit their bids, offers, buy/sell CRRs, and settle.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
final case class Pnode
(
    IdentifiedObject: IdentifiedObject = null,
    isPublic: Boolean = false,
    AggregateNode: List[String] = null,
    CommodityDefinition: List[String] = null,
    DeliveryTransactionBids: List[String] = null,
    ExPostResults: List[String] = null,
    FTRs: List[String] = null,
    MktMeasurement: List[String] = null,
    OrgPnodeAllocation: List[String] = null,
    PnodeResults: List[String] = null,
    RTO: String = null,
    ReceiptTransactionBids: List[String] = null,
    RegisteredResources: List[String] = null,
    SinkCRRSegment: List[String] = null,
    SourceCRRSegment: List[String] = null,
    SubControlArea: String = null,
    Trade: List[String] = null
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
    override def sup: IdentifiedObject = IdentifiedObject

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
        implicit val clz: String = Pnode.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Pnode.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Pnode.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Pnode.fields (position), x))
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
        "\t<cim:Pnode rdf:%s=\"%s\">\n%s\t</cim:Pnode>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object Pnode
extends
    CIMParseable[Pnode]
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AggregateNode", "AggregateNode", "0..*", "0..*"),
        CIMRelationship ("CommodityDefinition", "CommodityDefinition", "0..*", "1"),
        CIMRelationship ("DeliveryTransactionBids", "TransactionBid", "0..*", "0..1"),
        CIMRelationship ("ExPostResults", "ExPostPricingResults", "0..*", "1"),
        CIMRelationship ("FTRs", "FTR", "0..*", "0..*"),
        CIMRelationship ("MktMeasurement", "MktMeasurement", "0..*", "0..1"),
        CIMRelationship ("OrgPnodeAllocation", "OrgPnodeAllocation", "0..*", "1"),
        CIMRelationship ("PnodeResults", "PnodeResults", "1..*", "0..1"),
        CIMRelationship ("RTO", "RTO", "0..1", "0..*"),
        CIMRelationship ("ReceiptTransactionBids", "TransactionBid", "0..*", "0..1"),
        CIMRelationship ("RegisteredResources", "RegisteredResource", "0..*", "0..1"),
        CIMRelationship ("SinkCRRSegment", "CRRSegment", "0..*", "0..*"),
        CIMRelationship ("SourceCRRSegment", "CRRSegment", "0..*", "0..*"),
        CIMRelationship ("SubControlArea", "SubControlArea", "0..1", "0..*"),
        CIMRelationship ("Trade", "Trade", "0..*", "0..1")
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

    def parse (context: CIMContext): Pnode =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[Pnode] = PnodeSerializer
}

object PnodeSerializer extends CIMSerializer[Pnode]
{
    def write (kryo: Kryo, output: Output, obj: Pnode): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeBoolean (obj.isPublic),
            () => writeList (obj.AggregateNode, output),
            () => writeList (obj.CommodityDefinition, output),
            () => writeList (obj.DeliveryTransactionBids, output),
            () => writeList (obj.ExPostResults, output),
            () => writeList (obj.FTRs, output),
            () => writeList (obj.MktMeasurement, output),
            () => writeList (obj.OrgPnodeAllocation, output),
            () => writeList (obj.PnodeResults, output),
            () => output.writeString (obj.RTO),
            () => writeList (obj.ReceiptTransactionBids, output),
            () => writeList (obj.RegisteredResources, output),
            () => writeList (obj.SinkCRRSegment, output),
            () => writeList (obj.SourceCRRSegment, output),
            () => output.writeString (obj.SubControlArea),
            () => writeList (obj.Trade, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Pnode]): Pnode =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Pnode (
            parent,
            if (isSet (0)) input.readBoolean else false,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) readList (input) else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) readList (input) else null,
            if (isSet (5)) readList (input) else null,
            if (isSet (6)) readList (input) else null,
            if (isSet (7)) readList (input) else null,
            if (isSet (8)) readList (input) else null,
            if (isSet (9)) input.readString else null,
            if (isSet (10)) readList (input) else null,
            if (isSet (11)) readList (input) else null,
            if (isSet (12)) readList (input) else null,
            if (isSet (13)) readList (input) else null,
            if (isSet (14)) input.readString else null,
            if (isSet (15)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * This class allows SC to input different distribution factors for pricing node.
 *
 * @param Element Reference to the superclass object.
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
final case class PnodeDistributionFactor
(
    Element: BasicElement = null,
    factor: Double = 0.0,
    offPeak: String = null,
    onPeak: String = null,
    podLossFactor: Double = 0.0,
    AggregatedPnode: String = null,
    BidDistributionFactor: String = null,
    IndividualPnode: String = null
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
    override def sup: Element = Element

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
        "\t<cim:PnodeDistributionFactor rdf:%s=\"%s\">\n%s\t</cim:PnodeDistributionFactor>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object PnodeDistributionFactor
extends
    CIMParseable[PnodeDistributionFactor]
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AggregatedPnode", "AggregatedPnode", "1", "1..*"),
        CIMRelationship ("BidDistributionFactor", "BidDistributionFactor", "0..1", "0..*"),
        CIMRelationship ("IndividualPnode", "IndividualPnode", "1", "0..*")
    )
    val factor: Fielder = parse_element (element (cls, fields(0)))
    val offPeak: Fielder = parse_attribute (attribute (cls, fields(1)))
    val onPeak: Fielder = parse_attribute (attribute (cls, fields(2)))
    val podLossFactor: Fielder = parse_element (element (cls, fields(3)))
    val AggregatedPnode: Fielder = parse_attribute (attribute (cls, fields(4)))
    val BidDistributionFactor: Fielder = parse_attribute (attribute (cls, fields(5)))
    val IndividualPnode: Fielder = parse_attribute (attribute (cls, fields(6)))

    def parse (context: CIMContext): PnodeDistributionFactor =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[PnodeDistributionFactor] = PnodeDistributionFactorSerializer
}

object PnodeDistributionFactorSerializer extends CIMSerializer[PnodeDistributionFactor]
{
    def write (kryo: Kryo, output: Output, obj: PnodeDistributionFactor): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.factor),
            () => output.writeString (obj.offPeak),
            () => output.writeString (obj.onPeak),
            () => output.writeDouble (obj.podLossFactor),
            () => output.writeString (obj.AggregatedPnode),
            () => output.writeString (obj.BidDistributionFactor),
            () => output.writeString (obj.IndividualPnode)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PnodeDistributionFactor]): PnodeDistributionFactor =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PnodeDistributionFactor (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Model to support processing of reliability must run units.
 *
 * @param Curve [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param RegisteredGenerator [[ch.ninecode.model.RegisteredGenerator RegisteredGenerator]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
final case class RMRHeatRateCurve
(
    Curve: Curve = null,
    RegisteredGenerator: String = null
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
    override def sup: Curve = Curve

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
        implicit val clz: String = RMRHeatRateCurve.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RMRHeatRateCurve.fields (position), value)
        emitattr (0, RegisteredGenerator)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RMRHeatRateCurve rdf:%s=\"%s\">\n%s\t</cim:RMRHeatRateCurve>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object RMRHeatRateCurve
extends
    CIMParseable[RMRHeatRateCurve]
{
    override val fields: Array[String] = Array[String] (
        "RegisteredGenerator"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("RegisteredGenerator", "RegisteredGenerator", "0..1", "0..1")
    )
    val RegisteredGenerator: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): RMRHeatRateCurve =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = RMRHeatRateCurve (
            Curve.parse (context),
            mask (RegisteredGenerator (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[RMRHeatRateCurve] = RMRHeatRateCurveSerializer
}

object RMRHeatRateCurveSerializer extends CIMSerializer[RMRHeatRateCurve]
{
    def write (kryo: Kryo, output: Output, obj: RMRHeatRateCurve): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.RegisteredGenerator)
        )
        CurveSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[RMRHeatRateCurve]): RMRHeatRateCurve =
    {
        val parent = CurveSerializer.read (kryo, input, classOf[Curve])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = RMRHeatRateCurve (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Model to support processing of reliability must run units.
 *
 * @param Curve [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param RegisteredGenerator [[ch.ninecode.model.RegisteredGenerator RegisteredGenerator]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
final case class RMRStartUpCostCurve
(
    Curve: Curve = null,
    RegisteredGenerator: String = null
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
    override def sup: Curve = Curve

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
        implicit val clz: String = RMRStartUpCostCurve.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RMRStartUpCostCurve.fields (position), value)
        emitattr (0, RegisteredGenerator)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RMRStartUpCostCurve rdf:%s=\"%s\">\n%s\t</cim:RMRStartUpCostCurve>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object RMRStartUpCostCurve
extends
    CIMParseable[RMRStartUpCostCurve]
{
    override val fields: Array[String] = Array[String] (
        "RegisteredGenerator"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("RegisteredGenerator", "RegisteredGenerator", "0..1", "0..1")
    )
    val RegisteredGenerator: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): RMRStartUpCostCurve =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = RMRStartUpCostCurve (
            Curve.parse (context),
            mask (RegisteredGenerator (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[RMRStartUpCostCurve] = RMRStartUpCostCurveSerializer
}

object RMRStartUpCostCurveSerializer extends CIMSerializer[RMRStartUpCostCurve]
{
    def write (kryo: Kryo, output: Output, obj: RMRStartUpCostCurve): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.RegisteredGenerator)
        )
        CurveSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[RMRStartUpCostCurve]): RMRStartUpCostCurve =
    {
        val parent = CurveSerializer.read (kryo, input, classOf[Curve])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = RMRStartUpCostCurve (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Model to support processing of reliability must run units.
 *
 * @param Curve [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param RegisteredGenerator [[ch.ninecode.model.RegisteredGenerator RegisteredGenerator]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
final case class RMRStartUpEnergyCurve
(
    Curve: Curve = null,
    RegisteredGenerator: String = null
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
    override def sup: Curve = Curve

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
        implicit val clz: String = RMRStartUpEnergyCurve.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RMRStartUpEnergyCurve.fields (position), value)
        emitattr (0, RegisteredGenerator)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RMRStartUpEnergyCurve rdf:%s=\"%s\">\n%s\t</cim:RMRStartUpEnergyCurve>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object RMRStartUpEnergyCurve
extends
    CIMParseable[RMRStartUpEnergyCurve]
{
    override val fields: Array[String] = Array[String] (
        "RegisteredGenerator"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("RegisteredGenerator", "RegisteredGenerator", "0..1", "0..1")
    )
    val RegisteredGenerator: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): RMRStartUpEnergyCurve =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = RMRStartUpEnergyCurve (
            Curve.parse (context),
            mask (RegisteredGenerator (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[RMRStartUpEnergyCurve] = RMRStartUpEnergyCurveSerializer
}

object RMRStartUpEnergyCurveSerializer extends CIMSerializer[RMRStartUpEnergyCurve]
{
    def write (kryo: Kryo, output: Output, obj: RMRStartUpEnergyCurve): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.RegisteredGenerator)
        )
        CurveSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[RMRStartUpEnergyCurve]): RMRStartUpEnergyCurve =
    {
        val parent = CurveSerializer.read (kryo, input, classOf[Curve])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = RMRStartUpEnergyCurve (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Model to support processing of reliability must run units.
 *
 * @param Curve [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param RegisteredGenerator [[ch.ninecode.model.RegisteredGenerator RegisteredGenerator]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
final case class RMRStartUpFuelCurve
(
    Curve: Curve = null,
    RegisteredGenerator: String = null
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
    override def sup: Curve = Curve

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
        implicit val clz: String = RMRStartUpFuelCurve.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RMRStartUpFuelCurve.fields (position), value)
        emitattr (0, RegisteredGenerator)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RMRStartUpFuelCurve rdf:%s=\"%s\">\n%s\t</cim:RMRStartUpFuelCurve>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object RMRStartUpFuelCurve
extends
    CIMParseable[RMRStartUpFuelCurve]
{
    override val fields: Array[String] = Array[String] (
        "RegisteredGenerator"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("RegisteredGenerator", "RegisteredGenerator", "0..1", "0..1")
    )
    val RegisteredGenerator: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): RMRStartUpFuelCurve =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = RMRStartUpFuelCurve (
            Curve.parse (context),
            mask (RegisteredGenerator (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[RMRStartUpFuelCurve] = RMRStartUpFuelCurveSerializer
}

object RMRStartUpFuelCurveSerializer extends CIMSerializer[RMRStartUpFuelCurve]
{
    def write (kryo: Kryo, output: Output, obj: RMRStartUpFuelCurve): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.RegisteredGenerator)
        )
        CurveSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[RMRStartUpFuelCurve]): RMRStartUpFuelCurve =
    {
        val parent = CurveSerializer.read (kryo, input, classOf[Curve])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = RMRStartUpFuelCurve (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Model to support processing of reliability must run units.
 *
 * @param Curve [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param RegisteredGenerator [[ch.ninecode.model.RegisteredGenerator RegisteredGenerator]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
final case class RMRStartUpTimeCurve
(
    Curve: Curve = null,
    RegisteredGenerator: String = null
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
    override def sup: Curve = Curve

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
        implicit val clz: String = RMRStartUpTimeCurve.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RMRStartUpTimeCurve.fields (position), value)
        emitattr (0, RegisteredGenerator)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RMRStartUpTimeCurve rdf:%s=\"%s\">\n%s\t</cim:RMRStartUpTimeCurve>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object RMRStartUpTimeCurve
extends
    CIMParseable[RMRStartUpTimeCurve]
{
    override val fields: Array[String] = Array[String] (
        "RegisteredGenerator"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("RegisteredGenerator", "RegisteredGenerator", "0..1", "0..1")
    )
    val RegisteredGenerator: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): RMRStartUpTimeCurve =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = RMRStartUpTimeCurve (
            Curve.parse (context),
            mask (RegisteredGenerator (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[RMRStartUpTimeCurve] = RMRStartUpTimeCurveSerializer
}

object RMRStartUpTimeCurveSerializer extends CIMSerializer[RMRStartUpTimeCurve]
{
    def write (kryo: Kryo, output: Output, obj: RMRStartUpTimeCurve): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.RegisteredGenerator)
        )
        CurveSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[RMRStartUpTimeCurve]): RMRStartUpTimeCurve =
    {
        val parent = CurveSerializer.read (kryo, input, classOf[Curve])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = RMRStartUpTimeCurve (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Regional transmission operator.
 *
 * @param MarketParticipant [[ch.ninecode.model.MarketParticipant MarketParticipant]] Reference to the superclass object.
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
final case class RTO
(
    MarketParticipant: MarketParticipant = null,
    AdjacentCASet: List[String] = null,
    AggregateNode: List[String] = null,
    CommodityDefinition: List[String] = null,
    EnergyMarkets: List[String] = null,
    FuelRegion: List[String] = null,
    HostControlArea: List[String] = null,
    LocalReliabilityArea: List[String] = null,
    MSSAggregation: List[String] = null,
    MktConnectivityNode: List[String] = null,
    Pnodes: List[String] = null,
    ResourceGroupReqs: List[String] = null,
    SecurityConstraints: List[String] = null,
    SecurityConstraintsLinear: List[String] = null,
    SubControlArea: List[String] = null,
    TransmissionContractRight: List[String] = null,
    TransmissionRightChain: List[String] = null
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
    override def sup: MarketParticipant = MarketParticipant

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
        implicit val clz: String = RTO.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (RTO.fields (position), x))
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
        "\t<cim:RTO rdf:%s=\"%s\">\n%s\t</cim:RTO>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object RTO
extends
    CIMParseable[RTO]
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AdjacentCASet", "AdjacentCASet", "0..*", "1"),
        CIMRelationship ("AggregateNode", "AggregateNode", "0..*", "1"),
        CIMRelationship ("CommodityDefinition", "CommodityDefinition", "0..*", "1"),
        CIMRelationship ("EnergyMarkets", "EnergyMarket", "0..*", "0..1"),
        CIMRelationship ("FuelRegion", "FuelRegion", "0..*", "1"),
        CIMRelationship ("HostControlArea", "HostControlArea", "0..*", "1"),
        CIMRelationship ("LocalReliabilityArea", "LocalReliabilityArea", "0..*", "1"),
        CIMRelationship ("MSSAggregation", "MSSAggregation", "0..*", "1"),
        CIMRelationship ("MktConnectivityNode", "MktConnectivityNode", "0..*", "1"),
        CIMRelationship ("Pnodes", "Pnode", "0..*", "0..1"),
        CIMRelationship ("ResourceGroupReqs", "ResourceGroupReq", "0..*", "0..*"),
        CIMRelationship ("SecurityConstraints", "SecurityConstraints", "0..*", "0..1"),
        CIMRelationship ("SecurityConstraintsLinear", "SecurityConstraintSum", "0..*", "0..1"),
        CIMRelationship ("SubControlArea", "SubControlArea", "0..*", "1"),
        CIMRelationship ("TransmissionContractRight", "ContractRight", "0..*", "1"),
        CIMRelationship ("TransmissionRightChain", "TransmissionRightChain", "0..*", "1")
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

    def parse (context: CIMContext): RTO =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[RTO] = RTOSerializer
}

object RTOSerializer extends CIMSerializer[RTO]
{
    def write (kryo: Kryo, output: Output, obj: RTO): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.AdjacentCASet, output),
            () => writeList (obj.AggregateNode, output),
            () => writeList (obj.CommodityDefinition, output),
            () => writeList (obj.EnergyMarkets, output),
            () => writeList (obj.FuelRegion, output),
            () => writeList (obj.HostControlArea, output),
            () => writeList (obj.LocalReliabilityArea, output),
            () => writeList (obj.MSSAggregation, output),
            () => writeList (obj.MktConnectivityNode, output),
            () => writeList (obj.Pnodes, output),
            () => writeList (obj.ResourceGroupReqs, output),
            () => writeList (obj.SecurityConstraints, output),
            () => writeList (obj.SecurityConstraintsLinear, output),
            () => writeList (obj.SubControlArea, output),
            () => writeList (obj.TransmissionContractRight, output),
            () => writeList (obj.TransmissionRightChain, output)
        )
        MarketParticipantSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[RTO]): RTO =
    {
        val parent = MarketParticipantSerializer.read (kryo, input, classOf[MarketParticipant])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = RTO (
            parent,
            if (isSet (0)) readList (input) else null,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) readList (input) else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) readList (input) else null,
            if (isSet (5)) readList (input) else null,
            if (isSet (6)) readList (input) else null,
            if (isSet (7)) readList (input) else null,
            if (isSet (8)) readList (input) else null,
            if (isSet (9)) readList (input) else null,
            if (isSet (10)) readList (input) else null,
            if (isSet (11)) readList (input) else null,
            if (isSet (12)) readList (input) else null,
            if (isSet (13)) readList (input) else null,
            if (isSet (14)) readList (input) else null,
            if (isSet (15)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A specialized class of type AggregatedNode type.
 *
 * Defines RUC Zones. A forecast region represents a collection of Nodes for which the Market operator has developed sufficient historical demand and relevant weather data to perform a demand forecast for such area. The Market Operator may further adjust this forecast to ensure that the Reliability Unit Commitment produces adequate local capacity procurement.
 *
 * @param AggregateNode [[ch.ninecode.model.AggregateNode AggregateNode]] Reference to the superclass object.
 * @param LossClearingResults [[ch.ninecode.model.LossClearingResults LossClearingResults]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
final case class RUCZone
(
    AggregateNode: AggregateNode = null,
    LossClearingResults: List[String] = null
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
    override def sup: AggregateNode = AggregateNode

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
        implicit val clz: String = RUCZone.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (RUCZone.fields (position), x))
        emitattrs (0, LossClearingResults)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RUCZone rdf:%s=\"%s\">\n%s\t</cim:RUCZone>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object RUCZone
extends
    CIMParseable[RUCZone]
{
    override val fields: Array[String] = Array[String] (
        "LossClearingResults"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("LossClearingResults", "LossClearingResults", "0..*", "0..1")
    )
    val LossClearingResults: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): RUCZone =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = RUCZone (
            AggregateNode.parse (context),
            masks (LossClearingResults (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[RUCZone] = RUCZoneSerializer
}

object RUCZoneSerializer extends CIMSerializer[RUCZone]
{
    def write (kryo: Kryo, output: Output, obj: RUCZone): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.LossClearingResults, output)
        )
        AggregateNodeSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[RUCZone]): RUCZone =
    {
        val parent = AggregateNodeSerializer.read (kryo, input, classOf[AggregateNode])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = RUCZone (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A registered resource that represents a distributed energy resource, such as a micro-generator, fuel cell, photo-voltaic energy source, etc.
 *
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] Reference to the superclass object.
 * @param distributedResourceType The type of resource.
 *        Examples include: fuel cell, flywheel, photovoltaic, micro-turbine, CHP (combined heat power), V2G (vehicle to grid), DES (distributed energy storage), and others.
 * @param ResourcePerformanceRatings [[ch.ninecode.model.ResourcePerformanceRating ResourcePerformanceRating]] <em>undocumented</em>
 * @param ResponseMethods [[ch.ninecode.model.ResponseMethod ResponseMethod]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
final case class RegisteredDistributedResource
(
    RegisteredResource: RegisteredResource = null,
    distributedResourceType: String = null,
    ResourcePerformanceRatings: List[String] = null,
    ResponseMethods: List[String] = null
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
    override def sup: RegisteredResource = RegisteredResource

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
        implicit val clz: String = RegisteredDistributedResource.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (RegisteredDistributedResource.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (RegisteredDistributedResource.fields (position), x))
        emitelem (0, distributedResourceType)
        emitattrs (1, ResourcePerformanceRatings)
        emitattrs (2, ResponseMethods)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RegisteredDistributedResource rdf:%s=\"%s\">\n%s\t</cim:RegisteredDistributedResource>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object RegisteredDistributedResource
extends
    CIMParseable[RegisteredDistributedResource]
{
    override val fields: Array[String] = Array[String] (
        "distributedResourceType",
        "ResourcePerformanceRatings",
        "ResponseMethods"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ResourcePerformanceRatings", "ResourcePerformanceRating", "0..*", "1"),
        CIMRelationship ("ResponseMethods", "ResponseMethod", "0..*", "1")
    )
    val distributedResourceType: Fielder = parse_element (element (cls, fields(0)))
    val ResourcePerformanceRatings: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val ResponseMethods: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: CIMContext): RegisteredDistributedResource =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = RegisteredDistributedResource (
            RegisteredResource.parse (context),
            mask (distributedResourceType (), 0),
            masks (ResourcePerformanceRatings (), 1),
            masks (ResponseMethods (), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[RegisteredDistributedResource] = RegisteredDistributedResourceSerializer
}

object RegisteredDistributedResourceSerializer extends CIMSerializer[RegisteredDistributedResource]
{
    def write (kryo: Kryo, output: Output, obj: RegisteredDistributedResource): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.distributedResourceType),
            () => writeList (obj.ResourcePerformanceRatings, output),
            () => writeList (obj.ResponseMethods, output)
        )
        RegisteredResourceSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[RegisteredDistributedResource]): RegisteredDistributedResource =
    {
        val parent = RegisteredResourceSerializer.read (kryo, input, classOf[RegisteredResource])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = RegisteredDistributedResource (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Model of a generator  that is registered to participate in the market.
 *
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] Reference to the superclass object.
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
final case class RegisteredGenerator
(
    RegisteredResource: RegisteredResource = null,
    capacityFactor: Double = 0.0,
    coldStartTime: Double = 0.0,
    combinedCycleOperatingMode: String = null,
    commericialOperationDate: String = null,
    constrainedOutputFlag: String = null,
    energyDownRampRate: Double = 0.0,
    energyUpRampRate: Double = 0.0,
    extremeLongStart: String = null,
    fuelSource: String = null,
    highControlLimit: Double = 0.0,
    hotIntTime: Double = 0.0,
    hotStartTime: Double = 0.0,
    intColdTime: Double = 0.0,
    intStartTime: Double = 0.0,
    loadFollowingDownMSS: String = null,
    loadFollowingUpMSS: String = null,
    lowControlLImit: Double = 0.0,
    maxDependableCap: Double = 0.0,
    maxMinLoadCost: Double = 0.0,
    maxPumpingLevel: Double = 0.0,
    maxShutdownTime: String = null,
    maxStartUpsPerDay: Int = 0,
    maxWeeklyEnergy: Double = 0.0,
    maxWeeklyStarts: Int = 0,
    maximumAllowableSpinningReserve: Double = 0.0,
    maximumOperatingLimit: Double = 0.0,
    minLoadCost: Double = 0.0,
    minimumLoadCostBasis: String = null,
    minimumLoadFuelCost: Double = 0.0,
    minimumOperatingLimit: Double = 0.0,
    mustOfferRA: String = null,
    nameplateCapacity: Double = 0.0,
    operatingMaintenanceCost: Double = 0.0,
    pumpMinDownTime: Double = 0.0,
    pumpMinUpTime: Double = 0.0,
    pumpShutdownCost: Double = 0.0,
    pumpShutdownTime: Int = 0,
    pumpingCost: Double = 0.0,
    pumpingFactor: Double = 0.0,
    quickStartFlag: String = null,
    rampCurveType: String = null,
    regulationDownRampRate: Double = 0.0,
    regulationFlag: String = null,
    regulationUpRampRate: Double = 0.0,
    resourceSubType: String = null,
    riverSystem: String = null,
    spinRampRate: Double = 0.0,
    startUpCostBasis: String = null,
    syncCondCapable: String = null,
    unitType: String = null,
    useLimitFlag: String = null,
    variableEnergyResource: String = null,
    AuxillaryObject: List[String] = null,
    EnergyPriceIndex: String = null,
    FuelCostCurve: String = null,
    FuelRegion: String = null,
    GeneratingBids: List[String] = null,
    LocalReliabilityArea: String = null,
    MktHeatRateCurve: String = null,
    RMNRFlag: String = null,
    RMRFlag: String = null,
    RMRHeatRateCurve: String = null,
    RMRManualIndicator: String = null,
    RMRStartUpCostCurve: String = null,
    RMRStartUpEnergyCurve: String = null,
    RMRStartUpFuelCurve: String = null,
    RMRStartUpTimeCurve: String = null,
    RMTFlag: String = null,
    RegulatingLimit: String = null,
    StartUpCostCurves: List[String] = null,
    StartUpEnergyCurve: String = null,
    StartUpFuelCurve: String = null,
    StartUpTimeCurve: String = null,
    Trade: List[String] = null,
    UnitInitialConditions: List[String] = null
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
    override def sup: RegisteredResource = RegisteredResource

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
        implicit val clz: String = RegisteredGenerator.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (RegisteredGenerator.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RegisteredGenerator.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (RegisteredGenerator.fields (position), x))
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
        "\t<cim:RegisteredGenerator rdf:%s=\"%s\">\n%s\t</cim:RegisteredGenerator>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object RegisteredGenerator
extends
    CIMParseable[RegisteredGenerator]
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AuxillaryObject", "AuxiliaryObject", "0..*", "0..1"),
        CIMRelationship ("EnergyPriceIndex", "EnergyPriceIndex", "1", "1"),
        CIMRelationship ("FuelCostCurve", "FuelCostCurve", "0..1", "0..1"),
        CIMRelationship ("FuelRegion", "FuelRegion", "0..1", "0..*"),
        CIMRelationship ("GeneratingBids", "GeneratingBid", "0..*", "0..1"),
        CIMRelationship ("LocalReliabilityArea", "LocalReliabilityArea", "0..1", "0..*"),
        CIMRelationship ("MktHeatRateCurve", "MktHeatRateCurve", "0..1", "0..1"),
        CIMRelationship ("RMRHeatRateCurve", "RMRHeatRateCurve", "0..1", "0..1"),
        CIMRelationship ("RMRStartUpCostCurve", "RMRStartUpCostCurve", "0..1", "0..1"),
        CIMRelationship ("RMRStartUpEnergyCurve", "RMRStartUpEnergyCurve", "0..1", "0..1"),
        CIMRelationship ("RMRStartUpFuelCurve", "RMRStartUpFuelCurve", "0..1", "0..1"),
        CIMRelationship ("RMRStartUpTimeCurve", "RMRStartUpTimeCurve", "0..1", "0..1"),
        CIMRelationship ("RegulatingLimit", "RegulatingLimit", "0..1", "0..1"),
        CIMRelationship ("StartUpCostCurves", "StartUpCostCurve", "0..*", "0..*"),
        CIMRelationship ("StartUpEnergyCurve", "StartUpEnergyCurve", "0..1", "0..1"),
        CIMRelationship ("StartUpFuelCurve", "StartUpFuelCurve", "0..1", "0..1"),
        CIMRelationship ("StartUpTimeCurve", "StartUpTimeCurve", "0..1", "0..1"),
        CIMRelationship ("Trade", "Trade", "0..*", "0..1"),
        CIMRelationship ("UnitInitialConditions", "UnitInitialConditions", "0..*", "0..1")
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

    def parse (context: CIMContext): RegisteredGenerator =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0,0,0)
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

    def serializer: Serializer[RegisteredGenerator] = RegisteredGeneratorSerializer
}

object RegisteredGeneratorSerializer extends CIMSerializer[RegisteredGenerator]
{
    def write (kryo: Kryo, output: Output, obj: RegisteredGenerator): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.capacityFactor),
            () => output.writeDouble (obj.coldStartTime),
            () => output.writeString (obj.combinedCycleOperatingMode),
            () => output.writeString (obj.commericialOperationDate),
            () => output.writeString (obj.constrainedOutputFlag),
            () => output.writeDouble (obj.energyDownRampRate),
            () => output.writeDouble (obj.energyUpRampRate),
            () => output.writeString (obj.extremeLongStart),
            () => output.writeString (obj.fuelSource),
            () => output.writeDouble (obj.highControlLimit),
            () => output.writeDouble (obj.hotIntTime),
            () => output.writeDouble (obj.hotStartTime),
            () => output.writeDouble (obj.intColdTime),
            () => output.writeDouble (obj.intStartTime),
            () => output.writeString (obj.loadFollowingDownMSS),
            () => output.writeString (obj.loadFollowingUpMSS),
            () => output.writeDouble (obj.lowControlLImit),
            () => output.writeDouble (obj.maxDependableCap),
            () => output.writeDouble (obj.maxMinLoadCost),
            () => output.writeDouble (obj.maxPumpingLevel),
            () => output.writeString (obj.maxShutdownTime),
            () => output.writeInt (obj.maxStartUpsPerDay),
            () => output.writeDouble (obj.maxWeeklyEnergy),
            () => output.writeInt (obj.maxWeeklyStarts),
            () => output.writeDouble (obj.maximumAllowableSpinningReserve),
            () => output.writeDouble (obj.maximumOperatingLimit),
            () => output.writeDouble (obj.minLoadCost),
            () => output.writeString (obj.minimumLoadCostBasis),
            () => output.writeDouble (obj.minimumLoadFuelCost),
            () => output.writeDouble (obj.minimumOperatingLimit),
            () => output.writeString (obj.mustOfferRA),
            () => output.writeDouble (obj.nameplateCapacity),
            () => output.writeDouble (obj.operatingMaintenanceCost),
            () => output.writeDouble (obj.pumpMinDownTime),
            () => output.writeDouble (obj.pumpMinUpTime),
            () => output.writeDouble (obj.pumpShutdownCost),
            () => output.writeInt (obj.pumpShutdownTime),
            () => output.writeDouble (obj.pumpingCost),
            () => output.writeDouble (obj.pumpingFactor),
            () => output.writeString (obj.quickStartFlag),
            () => output.writeString (obj.rampCurveType),
            () => output.writeDouble (obj.regulationDownRampRate),
            () => output.writeString (obj.regulationFlag),
            () => output.writeDouble (obj.regulationUpRampRate),
            () => output.writeString (obj.resourceSubType),
            () => output.writeString (obj.riverSystem),
            () => output.writeDouble (obj.spinRampRate),
            () => output.writeString (obj.startUpCostBasis),
            () => output.writeString (obj.syncCondCapable),
            () => output.writeString (obj.unitType),
            () => output.writeString (obj.useLimitFlag),
            () => output.writeString (obj.variableEnergyResource),
            () => writeList (obj.AuxillaryObject, output),
            () => output.writeString (obj.EnergyPriceIndex),
            () => output.writeString (obj.FuelCostCurve),
            () => output.writeString (obj.FuelRegion),
            () => writeList (obj.GeneratingBids, output),
            () => output.writeString (obj.LocalReliabilityArea),
            () => output.writeString (obj.MktHeatRateCurve),
            () => output.writeString (obj.RMNRFlag),
            () => output.writeString (obj.RMRFlag),
            () => output.writeString (obj.RMRHeatRateCurve),
            () => output.writeString (obj.RMRManualIndicator),
            () => output.writeString (obj.RMRStartUpCostCurve),
            () => output.writeString (obj.RMRStartUpEnergyCurve),
            () => output.writeString (obj.RMRStartUpFuelCurve),
            () => output.writeString (obj.RMRStartUpTimeCurve),
            () => output.writeString (obj.RMTFlag),
            () => output.writeString (obj.RegulatingLimit),
            () => writeList (obj.StartUpCostCurves, output),
            () => output.writeString (obj.StartUpEnergyCurve),
            () => output.writeString (obj.StartUpFuelCurve),
            () => output.writeString (obj.StartUpTimeCurve),
            () => writeList (obj.Trade, output),
            () => writeList (obj.UnitInitialConditions, output)
        )
        RegisteredResourceSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[RegisteredGenerator]): RegisteredGenerator =
    {
        val parent = RegisteredResourceSerializer.read (kryo, input, classOf[RegisteredResource])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = RegisteredGenerator (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readDouble else 0.0,
            if (isSet (6)) input.readDouble else 0.0,
            if (isSet (7)) input.readString else null,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) input.readDouble else 0.0,
            if (isSet (10)) input.readDouble else 0.0,
            if (isSet (11)) input.readDouble else 0.0,
            if (isSet (12)) input.readDouble else 0.0,
            if (isSet (13)) input.readDouble else 0.0,
            if (isSet (14)) input.readString else null,
            if (isSet (15)) input.readString else null,
            if (isSet (16)) input.readDouble else 0.0,
            if (isSet (17)) input.readDouble else 0.0,
            if (isSet (18)) input.readDouble else 0.0,
            if (isSet (19)) input.readDouble else 0.0,
            if (isSet (20)) input.readString else null,
            if (isSet (21)) input.readInt else 0,
            if (isSet (22)) input.readDouble else 0.0,
            if (isSet (23)) input.readInt else 0,
            if (isSet (24)) input.readDouble else 0.0,
            if (isSet (25)) input.readDouble else 0.0,
            if (isSet (26)) input.readDouble else 0.0,
            if (isSet (27)) input.readString else null,
            if (isSet (28)) input.readDouble else 0.0,
            if (isSet (29)) input.readDouble else 0.0,
            if (isSet (30)) input.readString else null,
            if (isSet (31)) input.readDouble else 0.0,
            if (isSet (32)) input.readDouble else 0.0,
            if (isSet (33)) input.readDouble else 0.0,
            if (isSet (34)) input.readDouble else 0.0,
            if (isSet (35)) input.readDouble else 0.0,
            if (isSet (36)) input.readInt else 0,
            if (isSet (37)) input.readDouble else 0.0,
            if (isSet (38)) input.readDouble else 0.0,
            if (isSet (39)) input.readString else null,
            if (isSet (40)) input.readString else null,
            if (isSet (41)) input.readDouble else 0.0,
            if (isSet (42)) input.readString else null,
            if (isSet (43)) input.readDouble else 0.0,
            if (isSet (44)) input.readString else null,
            if (isSet (45)) input.readString else null,
            if (isSet (46)) input.readDouble else 0.0,
            if (isSet (47)) input.readString else null,
            if (isSet (48)) input.readString else null,
            if (isSet (49)) input.readString else null,
            if (isSet (50)) input.readString else null,
            if (isSet (51)) input.readString else null,
            if (isSet (52)) readList (input) else null,
            if (isSet (53)) input.readString else null,
            if (isSet (54)) input.readString else null,
            if (isSet (55)) input.readString else null,
            if (isSet (56)) readList (input) else null,
            if (isSet (57)) input.readString else null,
            if (isSet (58)) input.readString else null,
            if (isSet (59)) input.readString else null,
            if (isSet (60)) input.readString else null,
            if (isSet (61)) input.readString else null,
            if (isSet (62)) input.readString else null,
            if (isSet (63)) input.readString else null,
            if (isSet (64)) input.readString else null,
            if (isSet (65)) input.readString else null,
            if (isSet (66)) input.readString else null,
            if (isSet (67)) input.readString else null,
            if (isSet (68)) input.readString else null,
            if (isSet (69)) readList (input) else null,
            if (isSet (70)) input.readString else null,
            if (isSet (71)) input.readString else null,
            if (isSet (72)) input.readString else null,
            if (isSet (73)) readList (input) else null,
            if (isSet (74)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * This class represents the inter tie resource.
 *
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] Reference to the superclass object.
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
final case class RegisteredInterTie
(
    RegisteredResource: RegisteredResource = null,
    direction: String = null,
    energyProductType: String = null,
    isDCTie: String = null,
    isDynamicInterchange: String = null,
    minHourlyBlockLimit: Int = 0,
    Flowgate: String = null,
    InterTieBid: String = null,
    InterTieDispatchResponse: List[String] = null,
    InterchangeSchedule: List[String] = null,
    WheelingCounterParty: List[String] = null
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
    override def sup: RegisteredResource = RegisteredResource

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
        implicit val clz: String = RegisteredInterTie.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (RegisteredInterTie.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RegisteredInterTie.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (RegisteredInterTie.fields (position), x))
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
        "\t<cim:RegisteredInterTie rdf:%s=\"%s\">\n%s\t</cim:RegisteredInterTie>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object RegisteredInterTie
extends
    CIMParseable[RegisteredInterTie]
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Flowgate", "Flowgate", "1", "0..*"),
        CIMRelationship ("InterTieBid", "InterTieBid", "0..1", "0..1"),
        CIMRelationship ("InterTieDispatchResponse", "InterTieDispatchResponse", "0..*", "1"),
        CIMRelationship ("InterchangeSchedule", "InterchangeSchedule", "0..*", "0..1"),
        CIMRelationship ("WheelingCounterParty", "WheelingCounterParty", "0..*", "0..*")
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

    def parse (context: CIMContext): RegisteredInterTie =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[RegisteredInterTie] = RegisteredInterTieSerializer
}

object RegisteredInterTieSerializer extends CIMSerializer[RegisteredInterTie]
{
    def write (kryo: Kryo, output: Output, obj: RegisteredInterTie): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.direction),
            () => output.writeString (obj.energyProductType),
            () => output.writeString (obj.isDCTie),
            () => output.writeString (obj.isDynamicInterchange),
            () => output.writeInt (obj.minHourlyBlockLimit),
            () => output.writeString (obj.Flowgate),
            () => output.writeString (obj.InterTieBid),
            () => writeList (obj.InterTieDispatchResponse, output),
            () => writeList (obj.InterchangeSchedule, output),
            () => writeList (obj.WheelingCounterParty, output)
        )
        RegisteredResourceSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[RegisteredInterTie]): RegisteredInterTie =
    {
        val parent = RegisteredResourceSerializer.read (kryo, input, classOf[RegisteredResource])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = RegisteredInterTie (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readInt else 0,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) readList (input) else null,
            if (isSet (8)) readList (input) else null,
            if (isSet (9)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Model of a load that is registered to participate in the market.
 *
 * RegisteredLoad is used to model any load that is served by the wholesale market directly. RegisteredLoads may be dispatchable or non-dispatchable and may or may not have bid curves. Examples of RegisteredLoads would include: distribution company load, energy retailer load, large bulk power system connected facility load.
 *
 * Loads that are served indirectly, for example - through an energy retailer or a vertical utility, should be modeled as RegisteredDistributedResources. Examples of RegisteredDistributedResources would include: distribution level storage, distribution level generation and distribution level demand response.
 *
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] Reference to the superclass object.
 * @param blockLoadTransfer Emergency operating procedure - Flag to indicate that the Resource is Block Load pseudo resource.
 * @param dynamicallyScheduledLoadResource Flag to indicate that a Load Resource is part of a DSR Load
 * @param dynamicallyScheduledQualification Qualification status (used for DSR qualification).
 * @param AuxillaryObject [[ch.ninecode.model.AuxiliaryObject AuxiliaryObject]] <em>undocumented</em>
 * @param LoadBids [[ch.ninecode.model.LoadBid LoadBid]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
final case class RegisteredLoad
(
    RegisteredResource: RegisteredResource = null,
    blockLoadTransfer: Boolean = false,
    dynamicallyScheduledLoadResource: Boolean = false,
    dynamicallyScheduledQualification: Boolean = false,
    AuxillaryObject: List[String] = null,
    LoadBids: List[String] = null
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
    override def sup: RegisteredResource = RegisteredResource

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
        implicit val clz: String = RegisteredLoad.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (RegisteredLoad.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (RegisteredLoad.fields (position), x))
        emitelem (0, blockLoadTransfer)
        emitelem (1, dynamicallyScheduledLoadResource)
        emitelem (2, dynamicallyScheduledQualification)
        emitattrs (3, AuxillaryObject)
        emitattrs (4, LoadBids)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RegisteredLoad rdf:%s=\"%s\">\n%s\t</cim:RegisteredLoad>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object RegisteredLoad
extends
    CIMParseable[RegisteredLoad]
{
    override val fields: Array[String] = Array[String] (
        "blockLoadTransfer",
        "dynamicallyScheduledLoadResource",
        "dynamicallyScheduledQualification",
        "AuxillaryObject",
        "LoadBids"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AuxillaryObject", "AuxiliaryObject", "0..*", "0..1"),
        CIMRelationship ("LoadBids", "LoadBid", "0..*", "0..1")
    )
    val blockLoadTransfer: Fielder = parse_element (element (cls, fields(0)))
    val dynamicallyScheduledLoadResource: Fielder = parse_element (element (cls, fields(1)))
    val dynamicallyScheduledQualification: Fielder = parse_element (element (cls, fields(2)))
    val AuxillaryObject: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val LoadBids: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: CIMContext): RegisteredLoad =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[RegisteredLoad] = RegisteredLoadSerializer
}

object RegisteredLoadSerializer extends CIMSerializer[RegisteredLoad]
{
    def write (kryo: Kryo, output: Output, obj: RegisteredLoad): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeBoolean (obj.blockLoadTransfer),
            () => output.writeBoolean (obj.dynamicallyScheduledLoadResource),
            () => output.writeBoolean (obj.dynamicallyScheduledQualification),
            () => writeList (obj.AuxillaryObject, output),
            () => writeList (obj.LoadBids, output)
        )
        RegisteredResourceSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[RegisteredLoad]): RegisteredLoad =
    {
        val parent = RegisteredResourceSerializer.read (kryo, input, classOf[RegisteredResource])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = RegisteredLoad (
            parent,
            if (isSet (0)) input.readBoolean else false,
            if (isSet (1)) input.readBoolean else false,
            if (isSet (2)) input.readBoolean else false,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * This class represents the physical characteristic of a generator regarding the regulating limit.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param highLimit <em>undocumented</em>
 * @param lowLimit <em>undocumented</em>
 * @param RegisteredGenerator [[ch.ninecode.model.RegisteredGenerator RegisteredGenerator]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
final case class RegulatingLimit
(
    IdentifiedObject: IdentifiedObject = null,
    highLimit: Double = 0.0,
    lowLimit: Double = 0.0,
    RegisteredGenerator: String = null
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
    override def sup: IdentifiedObject = IdentifiedObject

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
        "\t<cim:RegulatingLimit rdf:%s=\"%s\">\n%s\t</cim:RegulatingLimit>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object RegulatingLimit
extends
    CIMParseable[RegulatingLimit]
{
    override val fields: Array[String] = Array[String] (
        "highLimit",
        "lowLimit",
        "RegisteredGenerator"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("RegisteredGenerator", "RegisteredGenerator", "0..1", "0..1")
    )
    val highLimit: Fielder = parse_element (element (cls, fields(0)))
    val lowLimit: Fielder = parse_element (element (cls, fields(1)))
    val RegisteredGenerator: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: CIMContext): RegulatingLimit =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = RegulatingLimit (
            IdentifiedObject.parse (context),
            toDouble (mask (highLimit (), 0)),
            toDouble (mask (lowLimit (), 1)),
            mask (RegisteredGenerator (), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[RegulatingLimit] = RegulatingLimitSerializer
}

object RegulatingLimitSerializer extends CIMSerializer[RegulatingLimit]
{
    def write (kryo: Kryo, output: Output, obj: RegulatingLimit): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.highLimit),
            () => output.writeDouble (obj.lowLimit),
            () => output.writeString (obj.RegisteredGenerator)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[RegulatingLimit]): RegulatingLimit =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = RegulatingLimit (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Specifies certification for a resource to participate in a specific markets.
 *
 * @param Element Reference to the superclass object.
 * @param market market type
 * @param qualificationFlag Status of the qualification ('Y' = Active, 'N' = Inactive)
 * @param type Type of service based on ResourceAncillaryServiceType enumeration
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] RegisteredResources are qualified for resource ancillary service types (which include market product types as well as other types such as BlackStart) by the association to the class ResourceAncillaryServiceQualification.
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
final case class ResourceCertification
(
    Element: BasicElement = null,
    market: String = null,
    qualificationFlag: String = null,
    `type`: String = null,
    RegisteredResource: String = null
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
    override def sup: Element = Element

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
        "\t<cim:ResourceCertification rdf:%s=\"%s\">\n%s\t</cim:ResourceCertification>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object ResourceCertification
extends
    CIMParseable[ResourceCertification]
{
    override val fields: Array[String] = Array[String] (
        "market",
        "qualificationFlag",
        "type",
        "RegisteredResource"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("RegisteredResource", "RegisteredResource", "1", "0..*")
    )
    val market: Fielder = parse_attribute (attribute (cls, fields(0)))
    val qualificationFlag: Fielder = parse_attribute (attribute (cls, fields(1)))
    val `type`: Fielder = parse_attribute (attribute (cls, fields(2)))
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: CIMContext): ResourceCertification =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[ResourceCertification] = ResourceCertificationSerializer
}

object ResourceCertificationSerializer extends CIMSerializer[ResourceCertification]
{
    def write (kryo: Kryo, output: Output, obj: ResourceCertification): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.market),
            () => output.writeString (obj.qualificationFlag),
            () => output.writeString (obj.`type`),
            () => output.writeString (obj.RegisteredResource)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ResourceCertification]): ResourceCertification =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ResourceCertification (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * To model the Operation and Maintenance (O and M) costs of a generation resource.
 *
 * @param Curve [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
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
final case class ResourceOperationMaintenanceCost
(
    Curve: Curve = null,
    gasPercentAboveLowSustainedLimit: Double = 0.0,
    oilPercentAboveLowSustainedLimit: Double = 0.0,
    omCostColdStartup: Double = 0.0,
    omCostHotStartup: Double = 0.0,
    omCostIntermediateStartup: Double = 0.0,
    omCostLowSustainedLimit: Double = 0.0,
    solidfuelPercentAboveLowSustainedLimit: Double = 0.0,
    ResourceVerifiableCosts: String = null
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
    override def sup: Curve = Curve

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
        "\t<cim:ResourceOperationMaintenanceCost rdf:%s=\"%s\">\n%s\t</cim:ResourceOperationMaintenanceCost>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object ResourceOperationMaintenanceCost
extends
    CIMParseable[ResourceOperationMaintenanceCost]
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ResourceVerifiableCosts", "ResourceVerifiableCosts", "0..1", "1")
    )
    val gasPercentAboveLowSustainedLimit: Fielder = parse_element (element (cls, fields(0)))
    val oilPercentAboveLowSustainedLimit: Fielder = parse_element (element (cls, fields(1)))
    val omCostColdStartup: Fielder = parse_element (element (cls, fields(2)))
    val omCostHotStartup: Fielder = parse_element (element (cls, fields(3)))
    val omCostIntermediateStartup: Fielder = parse_element (element (cls, fields(4)))
    val omCostLowSustainedLimit: Fielder = parse_element (element (cls, fields(5)))
    val solidfuelPercentAboveLowSustainedLimit: Fielder = parse_element (element (cls, fields(6)))
    val ResourceVerifiableCosts: Fielder = parse_attribute (attribute (cls, fields(7)))

    def parse (context: CIMContext): ResourceOperationMaintenanceCost =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[ResourceOperationMaintenanceCost] = ResourceOperationMaintenanceCostSerializer
}

object ResourceOperationMaintenanceCostSerializer extends CIMSerializer[ResourceOperationMaintenanceCost]
{
    def write (kryo: Kryo, output: Output, obj: ResourceOperationMaintenanceCost): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.gasPercentAboveLowSustainedLimit),
            () => output.writeDouble (obj.oilPercentAboveLowSustainedLimit),
            () => output.writeDouble (obj.omCostColdStartup),
            () => output.writeDouble (obj.omCostHotStartup),
            () => output.writeDouble (obj.omCostIntermediateStartup),
            () => output.writeDouble (obj.omCostLowSustainedLimit),
            () => output.writeDouble (obj.solidfuelPercentAboveLowSustainedLimit),
            () => output.writeString (obj.ResourceVerifiableCosts)
        )
        CurveSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ResourceOperationMaintenanceCost]): ResourceOperationMaintenanceCost =
    {
        val parent = CurveSerializer.read (kryo, input, classOf[Curve])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ResourceOperationMaintenanceCost (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readDouble else 0.0,
            if (isSet (6)) input.readDouble else 0.0,
            if (isSet (7)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * To model the startup costs of a generation resource.
 *
 * @param Element Reference to the superclass object.
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
final case class ResourceStartupCost
(
    Element: BasicElement = null,
    fuelColdStartup: Double = 0.0,
    fuelHotStartup: Double = 0.0,
    fuelIntermediateStartup: Double = 0.0,
    fuelLowSustainedLimit: Double = 0.0,
    gasPercentColdStartup: Double = 0.0,
    gasPercentHotStartup: Double = 0.0,
    gasPercentIntermediateStartup: Double = 0.0,
    gasPercentLowSustainedLimit: Double = 0.0,
    oilPercentColdStartup: Double = 0.0,
    oilPercentHotStartup: Double = 0.0,
    oilPercentIntermediateStartup: Double = 0.0,
    oilPercentLowSustainedLimit: Double = 0.0,
    solidfuelPercentColdStartup: Double = 0.0,
    solidfuelPercentHotStartup: Double = 0.0,
    solidfuelPercentIntermediateStartup: Double = 0.0,
    solidfuelPercentLowSustainedLimit: Double = 0.0,
    ResourceVerifiableCosts: String = null
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
    override def sup: Element = Element

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
        "\t<cim:ResourceStartupCost rdf:%s=\"%s\">\n%s\t</cim:ResourceStartupCost>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object ResourceStartupCost
extends
    CIMParseable[ResourceStartupCost]
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ResourceVerifiableCosts", "ResourceVerifiableCosts", "1", "0..*")
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

    def parse (context: CIMContext): ResourceStartupCost =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[ResourceStartupCost] = ResourceStartupCostSerializer
}

object ResourceStartupCostSerializer extends CIMSerializer[ResourceStartupCost]
{
    def write (kryo: Kryo, output: Output, obj: ResourceStartupCost): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.fuelColdStartup),
            () => output.writeDouble (obj.fuelHotStartup),
            () => output.writeDouble (obj.fuelIntermediateStartup),
            () => output.writeDouble (obj.fuelLowSustainedLimit),
            () => output.writeDouble (obj.gasPercentColdStartup),
            () => output.writeDouble (obj.gasPercentHotStartup),
            () => output.writeDouble (obj.gasPercentIntermediateStartup),
            () => output.writeDouble (obj.gasPercentLowSustainedLimit),
            () => output.writeDouble (obj.oilPercentColdStartup),
            () => output.writeDouble (obj.oilPercentHotStartup),
            () => output.writeDouble (obj.oilPercentIntermediateStartup),
            () => output.writeDouble (obj.oilPercentLowSustainedLimit),
            () => output.writeDouble (obj.solidfuelPercentColdStartup),
            () => output.writeDouble (obj.solidfuelPercentHotStartup),
            () => output.writeDouble (obj.solidfuelPercentIntermediateStartup),
            () => output.writeDouble (obj.solidfuelPercentLowSustainedLimit),
            () => output.writeString (obj.ResourceVerifiableCosts)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ResourceStartupCost]): ResourceStartupCost =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ResourceStartupCost (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readDouble else 0.0,
            if (isSet (6)) input.readDouble else 0.0,
            if (isSet (7)) input.readDouble else 0.0,
            if (isSet (8)) input.readDouble else 0.0,
            if (isSet (9)) input.readDouble else 0.0,
            if (isSet (10)) input.readDouble else 0.0,
            if (isSet (11)) input.readDouble else 0.0,
            if (isSet (12)) input.readDouble else 0.0,
            if (isSet (13)) input.readDouble else 0.0,
            if (isSet (14)) input.readDouble else 0.0,
            if (isSet (15)) input.readDouble else 0.0,
            if (isSet (16)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * This class is defined to describe the verifiable costs associated with a generation resource.
 *
 * @param Element Reference to the superclass object.
 * @param MktHeatRateCurve [[ch.ninecode.model.MktHeatRateCurve MktHeatRateCurve]] <em>undocumented</em>
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @param ResourceOperationMaintenanceCost [[ch.ninecode.model.ResourceOperationMaintenanceCost ResourceOperationMaintenanceCost]] <em>undocumented</em>
 * @param ResourceStartupCost [[ch.ninecode.model.ResourceStartupCost ResourceStartupCost]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
final case class ResourceVerifiableCosts
(
    Element: BasicElement = null,
    MktHeatRateCurve: String = null,
    RegisteredResource: String = null,
    ResourceOperationMaintenanceCost: String = null,
    ResourceStartupCost: List[String] = null
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
    override def sup: Element = Element

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
        implicit val clz: String = ResourceVerifiableCosts.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ResourceVerifiableCosts.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ResourceVerifiableCosts.fields (position), x))
        emitattr (0, MktHeatRateCurve)
        emitattr (1, RegisteredResource)
        emitattr (2, ResourceOperationMaintenanceCost)
        emitattrs (3, ResourceStartupCost)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ResourceVerifiableCosts rdf:%s=\"%s\">\n%s\t</cim:ResourceVerifiableCosts>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object ResourceVerifiableCosts
extends
    CIMParseable[ResourceVerifiableCosts]
{
    override val fields: Array[String] = Array[String] (
        "MktHeatRateCurve",
        "RegisteredResource",
        "ResourceOperationMaintenanceCost",
        "ResourceStartupCost"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("MktHeatRateCurve", "MktHeatRateCurve", "1", "0..1"),
        CIMRelationship ("RegisteredResource", "RegisteredResource", "1", "0..1"),
        CIMRelationship ("ResourceOperationMaintenanceCost", "ResourceOperationMaintenanceCost", "1", "0..1"),
        CIMRelationship ("ResourceStartupCost", "ResourceStartupCost", "0..*", "1")
    )
    val MktHeatRateCurve: Fielder = parse_attribute (attribute (cls, fields(0)))
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields(1)))
    val ResourceOperationMaintenanceCost: Fielder = parse_attribute (attribute (cls, fields(2)))
    val ResourceStartupCost: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: CIMContext): ResourceVerifiableCosts =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[ResourceVerifiableCosts] = ResourceVerifiableCostsSerializer
}

object ResourceVerifiableCostsSerializer extends CIMSerializer[ResourceVerifiableCosts]
{
    def write (kryo: Kryo, output: Output, obj: ResourceVerifiableCosts): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.MktHeatRateCurve),
            () => output.writeString (obj.RegisteredResource),
            () => output.writeString (obj.ResourceOperationMaintenanceCost),
            () => writeList (obj.ResourceStartupCost, output)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ResourceVerifiableCosts]): ResourceVerifiableCosts =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ResourceVerifiableCosts (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Specifies a category of energy usage that the demand response applies for; e.g. energy from lighting, HVAC, other.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
final case class ResponseMethod
(
    IdentifiedObject: IdentifiedObject = null,
    activePower: Double = 0.0,
    activePowerUOM: String = null,
    method: String = null,
    siteMultiplier: Int = 0,
    RegisteredResource: String = null
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
    override def sup: IdentifiedObject = IdentifiedObject

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
        "\t<cim:ResponseMethod rdf:%s=\"%s\">\n%s\t</cim:ResponseMethod>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object ResponseMethod
extends
    CIMParseable[ResponseMethod]
{
    override val fields: Array[String] = Array[String] (
        "activePower",
        "activePowerUOM",
        "method",
        "siteMultiplier",
        "RegisteredResource"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("RegisteredResource", "RegisteredDistributedResource", "1", "0..*")
    )
    val activePower: Fielder = parse_element (element (cls, fields(0)))
    val activePowerUOM: Fielder = parse_element (element (cls, fields(1)))
    val method: Fielder = parse_element (element (cls, fields(2)))
    val siteMultiplier: Fielder = parse_element (element (cls, fields(3)))
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: CIMContext): ResponseMethod =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[ResponseMethod] = ResponseMethodSerializer
}

object ResponseMethodSerializer extends CIMSerializer[ResponseMethod]
{
    def write (kryo: Kryo, output: Output, obj: ResponseMethod): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.activePower),
            () => output.writeString (obj.activePowerUOM),
            () => output.writeString (obj.method),
            () => output.writeInt (obj.siteMultiplier),
            () => output.writeString (obj.RegisteredResource)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ResponseMethod]): ResponseMethod =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ResponseMethod (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readInt else 0,
            if (isSet (4)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Market participants could be represented by Scheduling Coordinators (SCs) that are registered with the RTO/ISO.
 *
 * One participant could register multiple SCs with the RTO/ISO. Many market participants can do business with the RTO/ISO using a single SC. One SC could schedule multiple generators. A load scheduling point could be used by multiple SCs. Each SC could schedule load at multiple scheduling points. An inter-tie scheduling point can be used by multiple SCs. Each SC can schedule interchange at multiple inter-tie scheduling points.
 *
 * @param MarketParticipant [[ch.ninecode.model.MarketParticipant MarketParticipant]] Reference to the superclass object.
 * @param creditFlag Flag to indicate creditworthiness (Y, N)
 * @param creditStartEffectiveDate Date that the scheduling coordinator becomes creditworthy.
 * @param lastModified Indication of the last time this scheduling coordinator information was modified.
 * @param qualificationStatus Scheduling coordinator qualification status, Qualified, Not Qualified, or Disqualified.
 * @param scid This is the short name or Scheduling Coordinator ID field.
 * @param FromSCTrade [[ch.ninecode.model.Trade Trade]] <em>undocumented</em>
 * @param LoadRatio [[ch.ninecode.model.LoadRatio LoadRatio]] <em>undocumented</em>
 * @param MarketParticipant_attr [[ch.ninecode.model.MarketParticipant MarketParticipant]] <em>undocumented</em>
 * @param SubmitFromSCTrade [[ch.ninecode.model.Trade Trade]] <em>undocumented</em>
 * @param SubmitToSCTrade [[ch.ninecode.model.Trade Trade]] <em>undocumented</em>
 * @param ToSCTrade [[ch.ninecode.model.Trade Trade]] <em>undocumented</em>
 * @param TransmissionContractRight [[ch.ninecode.model.ContractRight ContractRight]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
final case class SchedulingCoordinator
(
    MarketParticipant: MarketParticipant = null,
    creditFlag: String = null,
    creditStartEffectiveDate: String = null,
    lastModified: String = null,
    qualificationStatus: String = null,
    scid: String = null,
    FromSCTrade: List[String] = null,
    LoadRatio: String = null,
    MarketParticipant_attr: String = null,
    SubmitFromSCTrade: List[String] = null,
    SubmitToSCTrade: List[String] = null,
    ToSCTrade: List[String] = null,
    TransmissionContractRight: List[String] = null
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
    override def sup: MarketParticipant = MarketParticipant

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
        implicit val clz: String = SchedulingCoordinator.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SchedulingCoordinator.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SchedulingCoordinator.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (SchedulingCoordinator.fields (position), x))
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
        "\t<cim:SchedulingCoordinator rdf:%s=\"%s\">\n%s\t</cim:SchedulingCoordinator>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object SchedulingCoordinator
extends
    CIMParseable[SchedulingCoordinator]
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("FromSCTrade", "Trade", "0..*", "1"),
        CIMRelationship ("LoadRatio", "LoadRatio", "1", "0..1"),
        CIMRelationship ("MarketParticipant_attr", "MarketParticipant", "0..1", "0..*"),
        CIMRelationship ("SubmitFromSCTrade", "Trade", "0..*", "0..1"),
        CIMRelationship ("SubmitToSCTrade", "Trade", "0..*", "0..1"),
        CIMRelationship ("ToSCTrade", "Trade", "0..*", "1"),
        CIMRelationship ("TransmissionContractRight", "ContractRight", "0..*", "1")
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

    def parse (context: CIMContext): SchedulingCoordinator =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[SchedulingCoordinator] = SchedulingCoordinatorSerializer
}

object SchedulingCoordinatorSerializer extends CIMSerializer[SchedulingCoordinator]
{
    def write (kryo: Kryo, output: Output, obj: SchedulingCoordinator): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.creditFlag),
            () => output.writeString (obj.creditStartEffectiveDate),
            () => output.writeString (obj.lastModified),
            () => output.writeString (obj.qualificationStatus),
            () => output.writeString (obj.scid),
            () => writeList (obj.FromSCTrade, output),
            () => output.writeString (obj.LoadRatio),
            () => output.writeString (obj.MarketParticipant_attr),
            () => writeList (obj.SubmitFromSCTrade, output),
            () => writeList (obj.SubmitToSCTrade, output),
            () => writeList (obj.ToSCTrade, output),
            () => writeList (obj.TransmissionContractRight, output)
        )
        MarketParticipantSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[SchedulingCoordinator]): SchedulingCoordinator =
    {
        val parent = MarketParticipantSerializer.read (kryo, input, classOf[MarketParticipant])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = SchedulingCoordinator (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) readList (input) else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) input.readString else null,
            if (isSet (8)) readList (input) else null,
            if (isSet (9)) readList (input) else null,
            if (isSet (10)) readList (input) else null,
            if (isSet (11)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Describing users of a Scheduling Coordinator.
 *
 * @param Element Reference to the superclass object.
 * @param loginID Login ID
 * @param loginRole Assigned roles (these are roles with either Read or Read/Write privileges on different Market Systems)
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
final case class SchedulingCoordinatorUser
(
    Element: BasicElement = null,
    loginID: String = null,
    loginRole: String = null
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
    override def sup: Element = Element

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
        implicit val clz: String = SchedulingCoordinatorUser.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SchedulingCoordinatorUser.fields (position), value)
        emitelem (0, loginID)
        emitelem (1, loginRole)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SchedulingCoordinatorUser rdf:%s=\"%s\">\n%s\t</cim:SchedulingCoordinatorUser>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object SchedulingCoordinatorUser
extends
    CIMParseable[SchedulingCoordinatorUser]
{
    override val fields: Array[String] = Array[String] (
        "loginID",
        "loginRole"
    )
    val loginID: Fielder = parse_element (element (cls, fields(0)))
    val loginRole: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: CIMContext): SchedulingCoordinatorUser =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SchedulingCoordinatorUser (
            BasicElement.parse (context),
            mask (loginID (), 0),
            mask (loginRole (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[SchedulingCoordinatorUser] = SchedulingCoordinatorUserSerializer
}

object SchedulingCoordinatorUserSerializer extends CIMSerializer[SchedulingCoordinatorUser]
{
    def write (kryo: Kryo, output: Output, obj: SchedulingCoordinatorUser): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.loginID),
            () => output.writeString (obj.loginRole)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[SchedulingCoordinatorUser]): SchedulingCoordinatorUser =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = SchedulingCoordinatorUser (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Connection to other organizations at the boundary of the ISO/RTO.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param Flowgate [[ch.ninecode.model.Flowgate Flowgate]] <em>undocumented</em>
 * @param InterchangeSchedule [[ch.ninecode.model.InterchangeSchedule InterchangeSchedule]] <em>undocumented</em>
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
final case class SchedulingPoint
(
    IdentifiedObject: IdentifiedObject = null,
    Flowgate: String = null,
    InterchangeSchedule: List[String] = null,
    RegisteredResource: List[String] = null
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
    override def sup: IdentifiedObject = IdentifiedObject

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
        implicit val clz: String = SchedulingPoint.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SchedulingPoint.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (SchedulingPoint.fields (position), x))
        emitattr (0, Flowgate)
        emitattrs (1, InterchangeSchedule)
        emitattrs (2, RegisteredResource)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SchedulingPoint rdf:%s=\"%s\">\n%s\t</cim:SchedulingPoint>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object SchedulingPoint
extends
    CIMParseable[SchedulingPoint]
{
    override val fields: Array[String] = Array[String] (
        "Flowgate",
        "InterchangeSchedule",
        "RegisteredResource"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Flowgate", "Flowgate", "0..1", "0..*"),
        CIMRelationship ("InterchangeSchedule", "InterchangeSchedule", "0..*", "0..1"),
        CIMRelationship ("RegisteredResource", "RegisteredResource", "0..*", "0..*")
    )
    val Flowgate: Fielder = parse_attribute (attribute (cls, fields(0)))
    val InterchangeSchedule: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val RegisteredResource: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: CIMContext): SchedulingPoint =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SchedulingPoint (
            IdentifiedObject.parse (context),
            mask (Flowgate (), 0),
            masks (InterchangeSchedule (), 1),
            masks (RegisteredResource (), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[SchedulingPoint] = SchedulingPointSerializer
}

object SchedulingPointSerializer extends CIMSerializer[SchedulingPoint]
{
    def write (kryo: Kryo, output: Output, obj: SchedulingPoint): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.Flowgate),
            () => writeList (obj.InterchangeSchedule, output),
            () => writeList (obj.RegisteredResource, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[SchedulingPoint]): SchedulingPoint =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = SchedulingPoint (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The energy consumption of a generating resource to complete a start-up from the StartUpEnergyCurve.
 *
 * Definition of the StartUpEnergyCurve includes, xvalue as the cooling time and y1value as the MW value.
 *
 * @param Curve [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param RegisteredGenerator [[ch.ninecode.model.RegisteredGenerator RegisteredGenerator]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
final case class StartUpEnergyCurve
(
    Curve: Curve = null,
    RegisteredGenerator: String = null
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
    override def sup: Curve = Curve

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
        implicit val clz: String = StartUpEnergyCurve.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (StartUpEnergyCurve.fields (position), value)
        emitattr (0, RegisteredGenerator)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:StartUpEnergyCurve rdf:%s=\"%s\">\n%s\t</cim:StartUpEnergyCurve>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object StartUpEnergyCurve
extends
    CIMParseable[StartUpEnergyCurve]
{
    override val fields: Array[String] = Array[String] (
        "RegisteredGenerator"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("RegisteredGenerator", "RegisteredGenerator", "0..1", "0..1")
    )
    val RegisteredGenerator: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): StartUpEnergyCurve =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = StartUpEnergyCurve (
            Curve.parse (context),
            mask (RegisteredGenerator (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[StartUpEnergyCurve] = StartUpEnergyCurveSerializer
}

object StartUpEnergyCurveSerializer extends CIMSerializer[StartUpEnergyCurve]
{
    def write (kryo: Kryo, output: Output, obj: StartUpEnergyCurve): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.RegisteredGenerator)
        )
        CurveSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[StartUpEnergyCurve]): StartUpEnergyCurve =
    {
        val parent = CurveSerializer.read (kryo, input, classOf[Curve])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = StartUpEnergyCurve (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The fuel consumption of a Generating Resource to complete a Start-Up.(x=cooling time) Form Startup Fuel Curve. xAxisData -&gt; cooling time, y1AxisData -&gt; MBtu.
 *
 * @param Curve [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param RegisteredGenerator [[ch.ninecode.model.RegisteredGenerator RegisteredGenerator]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
final case class StartUpFuelCurve
(
    Curve: Curve = null,
    RegisteredGenerator: String = null
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
    override def sup: Curve = Curve

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
        implicit val clz: String = StartUpFuelCurve.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (StartUpFuelCurve.fields (position), value)
        emitattr (0, RegisteredGenerator)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:StartUpFuelCurve rdf:%s=\"%s\">\n%s\t</cim:StartUpFuelCurve>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object StartUpFuelCurve
extends
    CIMParseable[StartUpFuelCurve]
{
    override val fields: Array[String] = Array[String] (
        "RegisteredGenerator"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("RegisteredGenerator", "RegisteredGenerator", "0..1", "0..1")
    )
    val RegisteredGenerator: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): StartUpFuelCurve =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = StartUpFuelCurve (
            Curve.parse (context),
            mask (RegisteredGenerator (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[StartUpFuelCurve] = StartUpFuelCurveSerializer
}

object StartUpFuelCurveSerializer extends CIMSerializer[StartUpFuelCurve]
{
    def write (kryo: Kryo, output: Output, obj: StartUpFuelCurve): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.RegisteredGenerator)
        )
        CurveSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[StartUpFuelCurve]): StartUpFuelCurve =
    {
        val parent = CurveSerializer.read (kryo, input, classOf[Curve])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = StartUpFuelCurve (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * An area defined for the purpose of tracking interchange with surrounding areas via tie points; may or may not serve as a control area.
 *
 * @param PowerSystemResource [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
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
final case class SubControlArea
(
    PowerSystemResource: PowerSystemResource = null,
    areaShortName: String = null,
    constantCoefficient: Double = 0.0,
    embeddedControlArea: String = null,
    internalCA: String = null,
    linearCoefficient: Double = 0.0,
    localCA: String = null,
    maxSelfSchedMW: Double = 0.0,
    minSelfSchedMW: Double = 0.0,
    quadraticCoefficient: Double = 0.0,
    AdjacentCASet: String = null,
    AggregateNode: List[String] = null,
    AreaReserveSpecification: String = null,
    BidSelfSched: List[String] = null,
    CnodeDistributionFactor: List[String] = null,
    ControlAreaDesignation: List[String] = null,
    ExPostLossResults: List[String] = null,
    Export_EnergyTransactions: List[String] = null,
    From_Flowgate: List[String] = null,
    GeneralClearingResults: List[String] = null,
    HostControlArea: String = null,
    Import_EnergyTransactions: List[String] = null,
    InadvertentAccount: List[String] = null,
    LossClearingResults: List[String] = null,
    Pnode: List[String] = null,
    RTO: String = null,
    Receive_DynamicSchedules: List[String] = null,
    RegisteredResource: List[String] = null,
    Send_DynamicSchedules: List[String] = null,
    SideA_TieLines: List[String] = null,
    SideB_TieLines: List[String] = null,
    To_Flowgate: List[String] = null
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
    override def sup: PowerSystemResource = PowerSystemResource

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
        implicit val clz: String = SubControlArea.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SubControlArea.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SubControlArea.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (SubControlArea.fields (position), x))
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
        "\t<cim:SubControlArea rdf:%s=\"%s\">\n%s\t</cim:SubControlArea>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object SubControlArea
extends
    CIMParseable[SubControlArea]
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AdjacentCASet", "AdjacentCASet", "0..1", "0..*"),
        CIMRelationship ("AggregateNode", "AggregateNode", "0..*", "0..*"),
        CIMRelationship ("AreaReserveSpecification", "AreaReserveSpec", "1", "0..*"),
        CIMRelationship ("BidSelfSched", "BidSelfSched", "0..*", "0..1"),
        CIMRelationship ("CnodeDistributionFactor", "CnodeDistributionFactor", "0..*", "0..1"),
        CIMRelationship ("ControlAreaDesignation", "ControlAreaDesignation", "0..*", "0..*"),
        CIMRelationship ("ExPostLossResults", "ExPostLossResults", "0..*", "0..1"),
        CIMRelationship ("Export_EnergyTransactions", "EnergyTransaction", "0..*", "1"),
        CIMRelationship ("From_Flowgate", "Flowgate", "0..*", "0..1"),
        CIMRelationship ("GeneralClearingResults", "GeneralClearingResults", "0..*", "0..1"),
        CIMRelationship ("HostControlArea", "HostControlArea", "1", "0..*"),
        CIMRelationship ("Import_EnergyTransactions", "EnergyTransaction", "0..*", "1"),
        CIMRelationship ("InadvertentAccount", "InadvertentAccount", "0..*", "1"),
        CIMRelationship ("LossClearingResults", "LossClearingResults", "1..*", "0..1"),
        CIMRelationship ("Pnode", "Pnode", "0..*", "0..1"),
        CIMRelationship ("RTO", "RTO", "1", "0..*"),
        CIMRelationship ("Receive_DynamicSchedules", "DynamicSchedule", "0..*", "1"),
        CIMRelationship ("RegisteredResource", "RegisteredResource", "0..*", "0..*"),
        CIMRelationship ("Send_DynamicSchedules", "DynamicSchedule", "0..*", "1"),
        CIMRelationship ("SideA_TieLines", "TieLine", "0..*", "1"),
        CIMRelationship ("SideB_TieLines", "TieLine", "0..*", "1"),
        CIMRelationship ("To_Flowgate", "Flowgate", "0..*", "0..1")
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

    def parse (context: CIMContext): SubControlArea =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[SubControlArea] = SubControlAreaSerializer
}

object SubControlAreaSerializer extends CIMSerializer[SubControlArea]
{
    def write (kryo: Kryo, output: Output, obj: SubControlArea): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.areaShortName),
            () => output.writeDouble (obj.constantCoefficient),
            () => output.writeString (obj.embeddedControlArea),
            () => output.writeString (obj.internalCA),
            () => output.writeDouble (obj.linearCoefficient),
            () => output.writeString (obj.localCA),
            () => output.writeDouble (obj.maxSelfSchedMW),
            () => output.writeDouble (obj.minSelfSchedMW),
            () => output.writeDouble (obj.quadraticCoefficient),
            () => output.writeString (obj.AdjacentCASet),
            () => writeList (obj.AggregateNode, output),
            () => output.writeString (obj.AreaReserveSpecification),
            () => writeList (obj.BidSelfSched, output),
            () => writeList (obj.CnodeDistributionFactor, output),
            () => writeList (obj.ControlAreaDesignation, output),
            () => writeList (obj.ExPostLossResults, output),
            () => writeList (obj.Export_EnergyTransactions, output),
            () => writeList (obj.From_Flowgate, output),
            () => writeList (obj.GeneralClearingResults, output),
            () => output.writeString (obj.HostControlArea),
            () => writeList (obj.Import_EnergyTransactions, output),
            () => writeList (obj.InadvertentAccount, output),
            () => writeList (obj.LossClearingResults, output),
            () => writeList (obj.Pnode, output),
            () => output.writeString (obj.RTO),
            () => writeList (obj.Receive_DynamicSchedules, output),
            () => writeList (obj.RegisteredResource, output),
            () => writeList (obj.Send_DynamicSchedules, output),
            () => writeList (obj.SideA_TieLines, output),
            () => writeList (obj.SideB_TieLines, output),
            () => writeList (obj.To_Flowgate, output)
        )
        PowerSystemResourceSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[SubControlArea]): SubControlArea =
    {
        val parent = PowerSystemResourceSerializer.read (kryo, input, classOf[PowerSystemResource])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = SubControlArea (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readDouble else 0.0,
            if (isSet (7)) input.readDouble else 0.0,
            if (isSet (8)) input.readDouble else 0.0,
            if (isSet (9)) input.readString else null,
            if (isSet (10)) readList (input) else null,
            if (isSet (11)) input.readString else null,
            if (isSet (12)) readList (input) else null,
            if (isSet (13)) readList (input) else null,
            if (isSet (14)) readList (input) else null,
            if (isSet (15)) readList (input) else null,
            if (isSet (16)) readList (input) else null,
            if (isSet (17)) readList (input) else null,
            if (isSet (18)) readList (input) else null,
            if (isSet (19)) input.readString else null,
            if (isSet (20)) readList (input) else null,
            if (isSet (21)) readList (input) else null,
            if (isSet (22)) readList (input) else null,
            if (isSet (23)) readList (input) else null,
            if (isSet (24)) input.readString else null,
            if (isSet (25)) readList (input) else null,
            if (isSet (26)) readList (input) else null,
            if (isSet (27)) readList (input) else null,
            if (isSet (28)) readList (input) else null,
            if (isSet (29)) readList (input) else null,
            if (isSet (30)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * List of resources that can be substituted for within the bounds of a Contract definition.
 *
 * This class has a precedence and a resource.
 *
 * @param Element Reference to the superclass object.
 * @param precedence An indicator of the order a resource should be substituted.
 *        The lower the number the higher the precedence.
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @param TransmissionContractRight [[ch.ninecode.model.ContractRight ContractRight]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
final case class SubstitutionResourceList
(
    Element: BasicElement = null,
    precedence: Int = 0,
    RegisteredResource: String = null,
    TransmissionContractRight: String = null
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
    override def sup: Element = Element

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
        "\t<cim:SubstitutionResourceList rdf:%s=\"%s\">\n%s\t</cim:SubstitutionResourceList>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object SubstitutionResourceList
extends
    CIMParseable[SubstitutionResourceList]
{
    override val fields: Array[String] = Array[String] (
        "precedence",
        "RegisteredResource",
        "TransmissionContractRight"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("RegisteredResource", "RegisteredResource", "0..1", "0..*"),
        CIMRelationship ("TransmissionContractRight", "ContractRight", "0..1", "0..*")
    )
    val precedence: Fielder = parse_element (element (cls, fields(0)))
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields(1)))
    val TransmissionContractRight: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: CIMContext): SubstitutionResourceList =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SubstitutionResourceList (
            BasicElement.parse (context),
            toInteger (mask (precedence (), 0)),
            mask (RegisteredResource (), 1),
            mask (TransmissionContractRight (), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[SubstitutionResourceList] = SubstitutionResourceListSerializer
}

object SubstitutionResourceListSerializer extends CIMSerializer[SubstitutionResourceList]
{
    def write (kryo: Kryo, output: Output, obj: SubstitutionResourceList): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeInt (obj.precedence),
            () => output.writeString (obj.RegisteredResource),
            () => output.writeString (obj.TransmissionContractRight)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[SubstitutionResourceList]): SubstitutionResourceList =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = SubstitutionResourceList (
            parent,
            if (isSet (0)) input.readInt else 0,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Transmission Access Charge Area.
 *
 * Charges assessed, on behalf of the Participating Transmission Owner, to parties who require access to the controlled grid.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param AggregatedPnode [[ch.ninecode.model.AggregatedPnode AggregatedPnode]] <em>undocumented</em>
 * @param AreaLoadCurve [[ch.ninecode.model.AreaLoadCurve AreaLoadCurve]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
final case class TACArea
(
    IdentifiedObject: IdentifiedObject = null,
    AggregatedPnode: List[String] = null,
    AreaLoadCurve: List[String] = null
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
    override def sup: IdentifiedObject = IdentifiedObject

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
        implicit val clz: String = TACArea.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (TACArea.fields (position), x))
        emitattrs (0, AggregatedPnode)
        emitattrs (1, AreaLoadCurve)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TACArea rdf:%s=\"%s\">\n%s\t</cim:TACArea>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object TACArea
extends
    CIMParseable[TACArea]
{
    override val fields: Array[String] = Array[String] (
        "AggregatedPnode",
        "AreaLoadCurve"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AggregatedPnode", "AggregatedPnode", "0..*", "0..*"),
        CIMRelationship ("AreaLoadCurve", "AreaLoadCurve", "0..*", "0..1")
    )
    val AggregatedPnode: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val AreaLoadCurve: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): TACArea =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TACArea (
            IdentifiedObject.parse (context),
            masks (AggregatedPnode (), 0),
            masks (AreaLoadCurve (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[TACArea] = TACAreaSerializer
}

object TACAreaSerializer extends CIMSerializer[TACArea]
{
    def write (kryo: Kryo, output: Output, obj: TACArea): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.AggregatedPnode, output),
            () => writeList (obj.AreaLoadCurve, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TACArea]): TACArea =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = TACArea (
            parent,
            if (isSet (0)) readList (input) else null,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Allows chaining of TransmissionContractRights.
 *
 * Many individual contract rights can be included in the definition of a TransmissionRightChain. A TransmissionRightChain is also defined as a TransmissionContractRight itself.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param Chain_ContractRight [[ch.ninecode.model.ContractRight ContractRight]] <em>undocumented</em>
 * @param Ind_ContractRight [[ch.ninecode.model.ContractRight ContractRight]] <em>undocumented</em>
 * @param RTO [[ch.ninecode.model.RTO RTO]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
final case class TransmissionRightChain
(
    IdentifiedObject: IdentifiedObject = null,
    Chain_ContractRight: String = null,
    Ind_ContractRight: List[String] = null,
    RTO: String = null
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
    override def sup: IdentifiedObject = IdentifiedObject

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
        implicit val clz: String = TransmissionRightChain.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TransmissionRightChain.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (TransmissionRightChain.fields (position), x))
        emitattr (0, Chain_ContractRight)
        emitattrs (1, Ind_ContractRight)
        emitattr (2, RTO)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TransmissionRightChain rdf:%s=\"%s\">\n%s\t</cim:TransmissionRightChain>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object TransmissionRightChain
extends
    CIMParseable[TransmissionRightChain]
{
    override val fields: Array[String] = Array[String] (
        "Chain_ContractRight",
        "Ind_ContractRight",
        "RTO"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Chain_ContractRight", "ContractRight", "1", "0..1"),
        CIMRelationship ("Ind_ContractRight", "ContractRight", "1..*", "0..1"),
        CIMRelationship ("RTO", "RTO", "1", "0..*")
    )
    val Chain_ContractRight: Fielder = parse_attribute (attribute (cls, fields(0)))
    val Ind_ContractRight: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val RTO: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: CIMContext): TransmissionRightChain =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TransmissionRightChain (
            IdentifiedObject.parse (context),
            mask (Chain_ContractRight (), 0),
            masks (Ind_ContractRight (), 1),
            mask (RTO (), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[TransmissionRightChain] = TransmissionRightChainSerializer
}

object TransmissionRightChainSerializer extends CIMSerializer[TransmissionRightChain]
{
    def write (kryo: Kryo, output: Output, obj: TransmissionRightChain): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.Chain_ContractRight),
            () => writeList (obj.Ind_ContractRight, output),
            () => output.writeString (obj.RTO)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TransmissionRightChain]): TransmissionRightChain =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = TransmissionRightChain (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Counter party in a wheeling transaction.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param RegisteredInterTie [[ch.ninecode.model.RegisteredInterTie RegisteredInterTie]] <em>undocumented</em>
 * @group ReferenceData
 * @groupname ReferenceData Package ReferenceData
 * @groupdesc ReferenceData Market static reference data.
 */
final case class WheelingCounterParty
(
    IdentifiedObject: IdentifiedObject = null,
    RegisteredInterTie: List[String] = null
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
    override def sup: IdentifiedObject = IdentifiedObject

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
        implicit val clz: String = WheelingCounterParty.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (WheelingCounterParty.fields (position), x))
        emitattrs (0, RegisteredInterTie)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WheelingCounterParty rdf:%s=\"%s\">\n%s\t</cim:WheelingCounterParty>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object WheelingCounterParty
extends
    CIMParseable[WheelingCounterParty]
{
    override val fields: Array[String] = Array[String] (
        "RegisteredInterTie"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("RegisteredInterTie", "RegisteredInterTie", "0..*", "0..*")
    )
    val RegisteredInterTie: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): WheelingCounterParty =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WheelingCounterParty (
            IdentifiedObject.parse (context),
            masks (RegisteredInterTie (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[WheelingCounterParty] = WheelingCounterPartySerializer
}

object WheelingCounterPartySerializer extends CIMSerializer[WheelingCounterParty]
{
    def write (kryo: Kryo, output: Output, obj: WheelingCounterParty): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.RegisteredInterTie, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[WheelingCounterParty]): WheelingCounterParty =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = WheelingCounterParty (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _ReferenceData
{
    def register: List[CIMClassInfo] =
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