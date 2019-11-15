package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * A roll up of invoice line items.
 *
 * The whole invoice has a due date and amount to be paid, with information such as customer, banks etc. being obtained through associations. The invoice roll up is based on individual line items that each contain amounts and descriptions for specific services or products.
 *
 * @param sup Reference to the superclass object.
 * @param amount Total amount due on this invoice based on line items and applicable adjustments.
 * @param billMediaKind Kind of media by which the CustomerBillingInfo was delivered.
 * @param dueDate Calculated date upon which the Invoice amount is due.
 * @param kind Kind of invoice (default is 'sales').
 * @param mailedDate Date on which the customer billing statement/invoice was printed/mailed.
 * @param proForma True if payment is to be paid by a Customer to accept a particular ErpQuote (with associated Design) and have work initiated, at which time an associated ErpInvoice should automatically be generated.
 *        EprPayment.subjectStatus satisfies terms specificed in the ErpQuote.
 * @param referenceNumber Number of an invoice to be reference by this invoice.
 * @param transactionDateTime Date and time when the invoice is issued.
 * @param transferType Type of invoice transfer.
 * @param MajorChargeGroup [[ch.ninecode.model.MajorChargeGroup MajorChargeGroup]] <em>undocumented</em>
 * @param MarketInvoiceLineItems [[ch.ninecode.model.MarketInvoiceLineItem MarketInvoiceLineItem]] <em>undocumented</em>
 * @group MarketOpCommon
 * @groupname MarketOpCommon Package MarketOpCommon
 * @groupdesc MarketOpCommon This package contains the common objects shared by MarketOperations packages.
 */
final case class MarketInvoice
(
    override val sup: BasicElement = null,
    amount: Double = 0.0,
    billMediaKind: String = null,
    dueDate: String = null,
    kind: String = null,
    mailedDate: String = null,
    proForma: Boolean = false,
    referenceNumber: String = null,
    transactionDateTime: String = null,
    transferType: String = null,
    MajorChargeGroup: List[String] = List(),
    MarketInvoiceLineItems: List[String] = List()
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
    override def copy (): Row = { clone ().asInstanceOf[MarketInvoice] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MarketInvoice.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MarketInvoice.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MarketInvoice.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MarketInvoice.fields (position), x))
        emitelem (0, amount)
        emitattr (1, billMediaKind)
        emitelem (2, dueDate)
        emitattr (3, kind)
        emitelem (4, mailedDate)
        emitelem (5, proForma)
        emitelem (6, referenceNumber)
        emitelem (7, transactionDateTime)
        emitelem (8, transferType)
        emitattrs (9, MajorChargeGroup)
        emitattrs (10, MarketInvoiceLineItems)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MarketInvoice rdf:ID=\"%s\">\n%s\t</cim:MarketInvoice>".format (id, export_fields)
    }
}

object MarketInvoice
extends
    Parseable[MarketInvoice]
{
    override val fields: Array[String] = Array[String] (
        "amount",
        "billMediaKind",
        "dueDate",
        "kind",
        "mailedDate",
        "proForma",
        "referenceNumber",
        "transactionDateTime",
        "transferType",
        "MajorChargeGroup",
        "MarketInvoiceLineItems"
    )
    override val relations: List[Relationship] = List (
        Relationship ("MajorChargeGroup", "MajorChargeGroup", "1..*", "0..*"),
        Relationship ("MarketInvoiceLineItems", "MarketInvoiceLineItem", "0..*", "1")
    )
    val amount: Fielder = parse_element (element (cls, fields(0)))
    val billMediaKind: Fielder = parse_attribute (attribute (cls, fields(1)))
    val dueDate: Fielder = parse_element (element (cls, fields(2)))
    val kind: Fielder = parse_attribute (attribute (cls, fields(3)))
    val mailedDate: Fielder = parse_element (element (cls, fields(4)))
    val proForma: Fielder = parse_element (element (cls, fields(5)))
    val referenceNumber: Fielder = parse_element (element (cls, fields(6)))
    val transactionDateTime: Fielder = parse_element (element (cls, fields(7)))
    val transferType: Fielder = parse_element (element (cls, fields(8)))
    val MajorChargeGroup: FielderMultiple = parse_attributes (attribute (cls, fields(9)))
    val MarketInvoiceLineItems: FielderMultiple = parse_attributes (attribute (cls, fields(10)))

    def parse (context: Context): MarketInvoice =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MarketInvoice (
            BasicElement.parse (context),
            toDouble (mask (amount (), 0)),
            mask (billMediaKind (), 1),
            mask (dueDate (), 2),
            mask (kind (), 3),
            mask (mailedDate (), 4),
            toBoolean (mask (proForma (), 5)),
            mask (referenceNumber (), 6),
            mask (transactionDateTime (), 7),
            mask (transferType (), 8),
            masks (MajorChargeGroup (), 9),
            masks (MarketInvoiceLineItems (), 10)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * An individual line item on an invoice.
 *
 * @param sup Reference to the superclass object.
 * @param billPeriod Bill period for the line item.
 * @param glAccount General Ledger account code, shall be a valid combination.
 * @param glDateTime Date and time line item will be posted to the General Ledger.
 * @param kind Kind of line item.
 * @param lineAmount Amount due for this line item.
 * @param lineNumber Line item number on invoice statement.
 * @param lineVersion Version number of the bill run.
 * @param netAmount Net line item charge amount.
 * @param previousAmount Previous line item charge amount.
 * @param ComponentMarketInvoiceLineItems [[ch.ninecode.model.MarketInvoiceLineItem MarketInvoiceLineItem]] <em>undocumented</em>
 * @param ContainerMarketInvoiceLineItem [[ch.ninecode.model.MarketInvoiceLineItem MarketInvoiceLineItem]] <em>undocumented</em>
 * @param MarketInvoice [[ch.ninecode.model.MarketInvoice MarketInvoice]] <em>undocumented</em>
 * @param Settlement [[ch.ninecode.model.Settlement Settlement]] <em>undocumented</em>
 * @group MarketOpCommon
 * @groupname MarketOpCommon Package MarketOpCommon
 * @groupdesc MarketOpCommon This package contains the common objects shared by MarketOperations packages.
 */
final case class MarketInvoiceLineItem
(
    override val sup: BasicElement = null,
    billPeriod: String = null,
    glAccount: String = null,
    glDateTime: String = null,
    kind: String = null,
    lineAmount: Double = 0.0,
    lineNumber: String = null,
    lineVersion: String = null,
    netAmount: Double = 0.0,
    previousAmount: Double = 0.0,
    ComponentMarketInvoiceLineItems: List[String] = List(),
    ContainerMarketInvoiceLineItem: String = null,
    MarketInvoice: String = null,
    Settlement: List[String] = List()
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
    override def copy (): Row = { clone ().asInstanceOf[MarketInvoiceLineItem] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MarketInvoiceLineItem.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MarketInvoiceLineItem.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MarketInvoiceLineItem.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MarketInvoiceLineItem.fields (position), x))
        emitattr (0, billPeriod)
        emitelem (1, glAccount)
        emitelem (2, glDateTime)
        emitattr (3, kind)
        emitelem (4, lineAmount)
        emitelem (5, lineNumber)
        emitelem (6, lineVersion)
        emitelem (7, netAmount)
        emitelem (8, previousAmount)
        emitattrs (9, ComponentMarketInvoiceLineItems)
        emitattr (10, ContainerMarketInvoiceLineItem)
        emitattr (11, MarketInvoice)
        emitattrs (12, Settlement)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MarketInvoiceLineItem rdf:ID=\"%s\">\n%s\t</cim:MarketInvoiceLineItem>".format (id, export_fields)
    }
}

object MarketInvoiceLineItem
extends
    Parseable[MarketInvoiceLineItem]
{
    override val fields: Array[String] = Array[String] (
        "billPeriod",
        "glAccount",
        "glDateTime",
        "kind",
        "lineAmount",
        "lineNumber",
        "lineVersion",
        "netAmount",
        "previousAmount",
        "ComponentMarketInvoiceLineItems",
        "ContainerMarketInvoiceLineItem",
        "MarketInvoice",
        "Settlement"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ComponentMarketInvoiceLineItems", "MarketInvoiceLineItem", "0..*", "0..1"),
        Relationship ("ContainerMarketInvoiceLineItem", "MarketInvoiceLineItem", "0..1", "0..*"),
        Relationship ("MarketInvoice", "MarketInvoice", "1", "0..*"),
        Relationship ("Settlement", "Settlement", "0..*", "0..*")
    )
    val billPeriod: Fielder = parse_attribute (attribute (cls, fields(0)))
    val glAccount: Fielder = parse_element (element (cls, fields(1)))
    val glDateTime: Fielder = parse_element (element (cls, fields(2)))
    val kind: Fielder = parse_attribute (attribute (cls, fields(3)))
    val lineAmount: Fielder = parse_element (element (cls, fields(4)))
    val lineNumber: Fielder = parse_element (element (cls, fields(5)))
    val lineVersion: Fielder = parse_element (element (cls, fields(6)))
    val netAmount: Fielder = parse_element (element (cls, fields(7)))
    val previousAmount: Fielder = parse_element (element (cls, fields(8)))
    val ComponentMarketInvoiceLineItems: FielderMultiple = parse_attributes (attribute (cls, fields(9)))
    val ContainerMarketInvoiceLineItem: Fielder = parse_attribute (attribute (cls, fields(10)))
    val MarketInvoice: Fielder = parse_attribute (attribute (cls, fields(11)))
    val Settlement: FielderMultiple = parse_attributes (attribute (cls, fields(12)))

    def parse (context: Context): MarketInvoiceLineItem =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MarketInvoiceLineItem (
            BasicElement.parse (context),
            mask (billPeriod (), 0),
            mask (glAccount (), 1),
            mask (glDateTime (), 2),
            mask (kind (), 3),
            toDouble (mask (lineAmount (), 4)),
            mask (lineNumber (), 5),
            mask (lineVersion (), 6),
            toDouble (mask (netAmount (), 7)),
            toDouble (mask (previousAmount (), 8)),
            masks (ComponentMarketInvoiceLineItems (), 9),
            mask (ContainerMarketInvoiceLineItem (), 10),
            mask (MarketInvoice (), 11),
            masks (Settlement (), 12)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * In accounting transactions, a ledger is a book containing accounts to which debits and credits are posted from journals, where transactions are initially recorded.
 *
 * Journal entries are periodically posted to the ledger. Ledger actual represents actual amounts by account within ledger within company or within business area. Actual amounts may be generated in a source application and then loaded to a specific ledger within the enterprise general ledger or budget application.
 *
 * @param sup Reference to the superclass object.
 * @param MarketLedgerEntries [[ch.ninecode.model.MarketLedgerEntry MarketLedgerEntry]] <em>undocumented</em>
 * @group MarketOpCommon
 * @groupname MarketOpCommon Package MarketOpCommon
 * @groupdesc MarketOpCommon This package contains the common objects shared by MarketOperations packages.
 */
final case class MarketLedger
(
    override val sup: BasicElement = null,
    MarketLedgerEntries: List[String] = List()
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
    override def copy (): Row = { clone ().asInstanceOf[MarketLedger] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MarketLedger.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MarketLedger.fields (position), x))
        emitattrs (0, MarketLedgerEntries)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MarketLedger rdf:ID=\"%s\">\n%s\t</cim:MarketLedger>".format (id, export_fields)
    }
}

object MarketLedger
extends
    Parseable[MarketLedger]
{
    override val fields: Array[String] = Array[String] (
        "MarketLedgerEntries"
    )
    override val relations: List[Relationship] = List (
        Relationship ("MarketLedgerEntries", "MarketLedgerEntry", "0..*", "1")
    )
    val MarketLedgerEntries: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): MarketLedger =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MarketLedger (
            BasicElement.parse (context),
            masks (MarketLedgerEntries (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Details of an individual entry in a ledger, which was posted from a journal on the posted date.
 *
 * @param sup Reference to the superclass object.
 * @param accountID Account identifier for this entry.
 * @param accountKind Kind of account for this entry.
 * @param amount The amount of the debit or credit for this account.
 * @param postedDateTime Date and time this entry was posted to the ledger.
 * @param status Status of ledger entry.
 * @param transactionDateTime Date and time journal entry was recorded.
 * @param MarketLedger [[ch.ninecode.model.MarketLedger MarketLedger]] <em>undocumented</em>
 * @param Settlement [[ch.ninecode.model.Settlement Settlement]] <em>undocumented</em>
 * @group MarketOpCommon
 * @groupname MarketOpCommon Package MarketOpCommon
 * @groupdesc MarketOpCommon This package contains the common objects shared by MarketOperations packages.
 */
final case class MarketLedgerEntry
(
    override val sup: BasicElement = null,
    accountID: String = null,
    accountKind: String = null,
    amount: Double = 0.0,
    postedDateTime: String = null,
    status: String = null,
    transactionDateTime: String = null,
    MarketLedger: String = null,
    Settlement: List[String] = List()
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
    override def copy (): Row = { clone ().asInstanceOf[MarketLedgerEntry] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MarketLedgerEntry.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MarketLedgerEntry.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MarketLedgerEntry.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MarketLedgerEntry.fields (position), x))
        emitelem (0, accountID)
        emitattr (1, accountKind)
        emitelem (2, amount)
        emitelem (3, postedDateTime)
        emitattr (4, status)
        emitelem (5, transactionDateTime)
        emitattr (6, MarketLedger)
        emitattrs (7, Settlement)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MarketLedgerEntry rdf:ID=\"%s\">\n%s\t</cim:MarketLedgerEntry>".format (id, export_fields)
    }
}

object MarketLedgerEntry
extends
    Parseable[MarketLedgerEntry]
{
    override val fields: Array[String] = Array[String] (
        "accountID",
        "accountKind",
        "amount",
        "postedDateTime",
        "status",
        "transactionDateTime",
        "MarketLedger",
        "Settlement"
    )
    override val relations: List[Relationship] = List (
        Relationship ("MarketLedger", "MarketLedger", "1", "0..*"),
        Relationship ("Settlement", "Settlement", "0..*", "0..*")
    )
    val accountID: Fielder = parse_element (element (cls, fields(0)))
    val accountKind: Fielder = parse_attribute (attribute (cls, fields(1)))
    val amount: Fielder = parse_element (element (cls, fields(2)))
    val postedDateTime: Fielder = parse_element (element (cls, fields(3)))
    val status: Fielder = parse_attribute (attribute (cls, fields(4)))
    val transactionDateTime: Fielder = parse_element (element (cls, fields(5)))
    val MarketLedger: Fielder = parse_attribute (attribute (cls, fields(6)))
    val Settlement: FielderMultiple = parse_attributes (attribute (cls, fields(7)))

    def parse (context: Context): MarketLedgerEntry =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MarketLedgerEntry (
            BasicElement.parse (context),
            mask (accountID (), 0),
            mask (accountKind (), 1),
            toDouble (mask (amount (), 2)),
            mask (postedDateTime (), 3),
            mask (status (), 4),
            mask (transactionDateTime (), 5),
            mask (MarketLedger (), 6),
            masks (Settlement (), 7)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Subclass of IEC61968: Common:ActivityRecord.
 *
 * @param sup [[ch.ninecode.model.ActivityRecord ActivityRecord]] Reference to the superclass object.
 * @param MarketFactors [[ch.ninecode.model.MarketFactors MarketFactors]] <em>undocumented</em>
 * @group MarketOpCommon
 * @groupname MarketOpCommon Package MarketOpCommon
 * @groupdesc MarketOpCommon This package contains the common objects shared by MarketOperations packages.
 */
final case class MktActivityRecord
(
    override val sup: ActivityRecord = null,
    MarketFactors: List[String] = List()
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
    def ActivityRecord: ActivityRecord = sup.asInstanceOf[ActivityRecord]
    override def copy (): Row = { clone ().asInstanceOf[MktActivityRecord] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MktActivityRecord.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MktActivityRecord.fields (position), x))
        emitattrs (0, MarketFactors)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MktActivityRecord rdf:ID=\"%s\">\n%s\t</cim:MktActivityRecord>".format (id, export_fields)
    }
}

object MktActivityRecord
extends
    Parseable[MktActivityRecord]
{
    override val fields: Array[String] = Array[String] (
        "MarketFactors"
    )
    override val relations: List[Relationship] = List (
        Relationship ("MarketFactors", "MarketFactors", "0..*", "0..*")
    )
    val MarketFactors: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): MktActivityRecord =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MktActivityRecord (
            ActivityRecord.parse (context),
            masks (MarketFactors (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Subclass of IEC61970:Topology:ConnectivityNode.
 *
 * @param sup [[ch.ninecode.model.ConnectivityNode ConnectivityNode]] Reference to the superclass object.
 * @param CnodeDistributionFactor [[ch.ninecode.model.CnodeDistributionFactor CnodeDistributionFactor]] <em>undocumented</em>
 * @param IndividualPnode [[ch.ninecode.model.IndividualPnode IndividualPnode]] <em>undocumented</em>
 * @param LossPenaltyFactor [[ch.ninecode.model.LossSensitivity LossSensitivity]] <em>undocumented</em>
 * @param NodeConstraintTerm [[ch.ninecode.model.NodeConstraintTerm NodeConstraintTerm]] <em>undocumented</em>
 * @param RTO [[ch.ninecode.model.RTO RTO]] <em>undocumented</em>
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @param SysLoadDistribuFactor [[ch.ninecode.model.SysLoadDistributionFactor SysLoadDistributionFactor]] <em>undocumented</em>
 * @group MarketOpCommon
 * @groupname MarketOpCommon Package MarketOpCommon
 * @groupdesc MarketOpCommon This package contains the common objects shared by MarketOperations packages.
 */
final case class MktConnectivityNode
(
    override val sup: ConnectivityNode = null,
    CnodeDistributionFactor: List[String] = List(),
    IndividualPnode: String = null,
    LossPenaltyFactor: List[String] = List(),
    NodeConstraintTerm: List[String] = List(),
    RTO: String = null,
    RegisteredResource: List[String] = List(),
    SysLoadDistribuFactor: String = null
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
    def ConnectivityNode: ConnectivityNode = sup.asInstanceOf[ConnectivityNode]
    override def copy (): Row = { clone ().asInstanceOf[MktConnectivityNode] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MktConnectivityNode.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MktConnectivityNode.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MktConnectivityNode.fields (position), x))
        emitattrs (0, CnodeDistributionFactor)
        emitattr (1, IndividualPnode)
        emitattrs (2, LossPenaltyFactor)
        emitattrs (3, NodeConstraintTerm)
        emitattr (4, RTO)
        emitattrs (5, RegisteredResource)
        emitattr (6, SysLoadDistribuFactor)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MktConnectivityNode rdf:ID=\"%s\">\n%s\t</cim:MktConnectivityNode>".format (id, export_fields)
    }
}

object MktConnectivityNode
extends
    Parseable[MktConnectivityNode]
{
    override val fields: Array[String] = Array[String] (
        "CnodeDistributionFactor",
        "IndividualPnode",
        "LossPenaltyFactor",
        "NodeConstraintTerm",
        "RTO",
        "RegisteredResource",
        "SysLoadDistribuFactor"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CnodeDistributionFactor", "CnodeDistributionFactor", "0..*", "1"),
        Relationship ("IndividualPnode", "IndividualPnode", "0..1", "1"),
        Relationship ("LossPenaltyFactor", "LossSensitivity", "0..*", "1"),
        Relationship ("NodeConstraintTerm", "NodeConstraintTerm", "0..*", "1"),
        Relationship ("RTO", "RTO", "1", "0..*"),
        Relationship ("RegisteredResource", "RegisteredResource", "0..*", "0..1"),
        Relationship ("SysLoadDistribuFactor", "SysLoadDistributionFactor", "0..1", "1")
    )
    val CnodeDistributionFactor: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val IndividualPnode: Fielder = parse_attribute (attribute (cls, fields(1)))
    val LossPenaltyFactor: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val NodeConstraintTerm: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val RTO: Fielder = parse_attribute (attribute (cls, fields(4)))
    val RegisteredResource: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val SysLoadDistribuFactor: Fielder = parse_attribute (attribute (cls, fields(6)))

    def parse (context: Context): MktConnectivityNode =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MktConnectivityNode (
            ConnectivityNode.parse (context),
            masks (CnodeDistributionFactor (), 0),
            mask (IndividualPnode (), 1),
            masks (LossPenaltyFactor (), 2),
            masks (NodeConstraintTerm (), 3),
            mask (RTO (), 4),
            masks (RegisteredResource (), 5),
            mask (SysLoadDistribuFactor (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Subclass for IEC61970:Wires:Line.
 *
 * @param sup [[ch.ninecode.model.Line Line]] Reference to the superclass object.
 * @param Flowgate [[ch.ninecode.model.Flowgate Flowgate]] <em>undocumented</em>
 * @param TransmissionRightOfWay [[ch.ninecode.model.TransmissionRightOfWay TransmissionRightOfWay]] <em>undocumented</em>
 * @group MarketOpCommon
 * @groupname MarketOpCommon Package MarketOpCommon
 * @groupdesc MarketOpCommon This package contains the common objects shared by MarketOperations packages.
 */
final case class MktLine
(
    override val sup: Line = null,
    Flowgate: List[String] = List(),
    TransmissionRightOfWay: String = null
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
    def Line: Line = sup.asInstanceOf[Line]
    override def copy (): Row = { clone ().asInstanceOf[MktLine] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MktLine.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MktLine.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MktLine.fields (position), x))
        emitattrs (0, Flowgate)
        emitattr (1, TransmissionRightOfWay)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MktLine rdf:ID=\"%s\">\n%s\t</cim:MktLine>".format (id, export_fields)
    }
}

object MktLine
extends
    Parseable[MktLine]
{
    override val fields: Array[String] = Array[String] (
        "Flowgate",
        "TransmissionRightOfWay"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Flowgate", "Flowgate", "0..*", "0..*"),
        Relationship ("TransmissionRightOfWay", "TransmissionRightOfWay", "0..1", "0..*")
    )
    val Flowgate: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val TransmissionRightOfWay: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): MktLine =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MktLine (
            Line.parse (context),
            masks (Flowgate (), 0),
            mask (TransmissionRightOfWay (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Subclass of IEC61970:Meas:Measurement.
 *
 * @param sup [[ch.ninecode.model.Measurement Measurement]] Reference to the superclass object.
 * @param ByTiePoint [[ch.ninecode.model.TiePoint TiePoint]] A measurement is made on the B side of a tie point
 * @param DynamicSchedule [[ch.ninecode.model.DynamicSchedule DynamicSchedule]] <em>undocumented</em>
 * @param ForTiePoint [[ch.ninecode.model.TiePoint TiePoint]] A measurement is made on the A side of a tie point
 * @param Pnode [[ch.ninecode.model.Pnode Pnode]] Allows Pnode an association to aggregated resources external DC ties or psuedo tie measurements.
 * @param ViolationLimit [[ch.ninecode.model.ViolationLimit ViolationLimit]] <em>undocumented</em>
 * @group MarketOpCommon
 * @groupname MarketOpCommon Package MarketOpCommon
 * @groupdesc MarketOpCommon This package contains the common objects shared by MarketOperations packages.
 */
final case class MktMeasurement
(
    override val sup: Measurement = null,
    ByTiePoint: String = null,
    DynamicSchedule: List[String] = List(),
    ForTiePoint: String = null,
    Pnode: String = null,
    ViolationLimit: List[String] = List()
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
    def Measurement: Measurement = sup.asInstanceOf[Measurement]
    override def copy (): Row = { clone ().asInstanceOf[MktMeasurement] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MktMeasurement.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MktMeasurement.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MktMeasurement.fields (position), x))
        emitattr (0, ByTiePoint)
        emitattrs (1, DynamicSchedule)
        emitattr (2, ForTiePoint)
        emitattr (3, Pnode)
        emitattrs (4, ViolationLimit)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MktMeasurement rdf:ID=\"%s\">\n%s\t</cim:MktMeasurement>".format (id, export_fields)
    }
}

object MktMeasurement
extends
    Parseable[MktMeasurement]
{
    override val fields: Array[String] = Array[String] (
        "ByTiePoint",
        "DynamicSchedule",
        "ForTiePoint",
        "Pnode",
        "ViolationLimit"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ByTiePoint", "TiePoint", "1", "1..*"),
        Relationship ("DynamicSchedule", "DynamicSchedule", "0..*", "1"),
        Relationship ("ForTiePoint", "TiePoint", "1", "1..*"),
        Relationship ("Pnode", "Pnode", "0..1", "0..*"),
        Relationship ("ViolationLimit", "ViolationLimit", "0..*", "0..1")
    )
    val ByTiePoint: Fielder = parse_attribute (attribute (cls, fields(0)))
    val DynamicSchedule: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val ForTiePoint: Fielder = parse_attribute (attribute (cls, fields(2)))
    val Pnode: Fielder = parse_attribute (attribute (cls, fields(3)))
    val ViolationLimit: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: Context): MktMeasurement =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MktMeasurement (
            Measurement.parse (context),
            mask (ByTiePoint (), 0),
            masks (DynamicSchedule (), 1),
            mask (ForTiePoint (), 2),
            mask (Pnode (), 3),
            masks (ViolationLimit (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Subclass of IEC61970:Wires:PowerTransformer.
 *
 * @param sup [[ch.ninecode.model.PowerTransformer PowerTransformer]] Reference to the superclass object.
 * @param EndAFlow [[ch.ninecode.model.BranchEndFlow BranchEndFlow]] <em>undocumented</em>
 * @param EndBFlow [[ch.ninecode.model.BranchEndFlow BranchEndFlow]] <em>undocumented</em>
 * @param Flowgate [[ch.ninecode.model.Flowgate Flowgate]] <em>undocumented</em>
 * @group MarketOpCommon
 * @groupname MarketOpCommon Package MarketOpCommon
 * @groupdesc MarketOpCommon This package contains the common objects shared by MarketOperations packages.
 */
final case class MktPowerTransformer
(
    override val sup: PowerTransformer = null,
    EndAFlow: String = null,
    EndBFlow: String = null,
    Flowgate: List[String] = List()
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
    def PowerTransformer: PowerTransformer = sup.asInstanceOf[PowerTransformer]
    override def copy (): Row = { clone ().asInstanceOf[MktPowerTransformer] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MktPowerTransformer.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MktPowerTransformer.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MktPowerTransformer.fields (position), x))
        emitattr (0, EndAFlow)
        emitattr (1, EndBFlow)
        emitattrs (2, Flowgate)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MktPowerTransformer rdf:ID=\"%s\">\n%s\t</cim:MktPowerTransformer>".format (id, export_fields)
    }
}

object MktPowerTransformer
extends
    Parseable[MktPowerTransformer]
{
    override val fields: Array[String] = Array[String] (
        "EndAFlow",
        "EndBFlow",
        "Flowgate"
    )
    override val relations: List[Relationship] = List (
        Relationship ("EndAFlow", "BranchEndFlow", "0..1", "0..*"),
        Relationship ("EndBFlow", "BranchEndFlow", "0..1", "0..*"),
        Relationship ("Flowgate", "Flowgate", "0..*", "0..*")
    )
    val EndAFlow: Fielder = parse_attribute (attribute (cls, fields(0)))
    val EndBFlow: Fielder = parse_attribute (attribute (cls, fields(1)))
    val Flowgate: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: Context): MktPowerTransformer =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MktPowerTransformer (
            PowerTransformer.parse (context),
            mask (EndAFlow (), 0),
            mask (EndBFlow (), 1),
            masks (Flowgate (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Subclass of IEC61970:Core:Terminal.
 *
 * @param sup [[ch.ninecode.model.Terminal Terminal]] Reference to the superclass object.
 * @param Flowgate [[ch.ninecode.model.Flowgate Flowgate]] <em>undocumented</em>
 * @param TerminalConstraintTerm [[ch.ninecode.model.TerminalConstraintTerm TerminalConstraintTerm]] <em>undocumented</em>
 * @group MarketOpCommon
 * @groupname MarketOpCommon Package MarketOpCommon
 * @groupdesc MarketOpCommon This package contains the common objects shared by MarketOperations packages.
 */
final case class MktTerminal
(
    override val sup: Terminal = null,
    Flowgate: String = null,
    TerminalConstraintTerm: List[String] = List()
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
    def Terminal: Terminal = sup.asInstanceOf[Terminal]
    override def copy (): Row = { clone ().asInstanceOf[MktTerminal] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MktTerminal.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MktTerminal.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MktTerminal.fields (position), x))
        emitattr (0, Flowgate)
        emitattrs (1, TerminalConstraintTerm)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MktTerminal rdf:ID=\"%s\">\n%s\t</cim:MktTerminal>".format (id, export_fields)
    }
}

object MktTerminal
extends
    Parseable[MktTerminal]
{
    override val fields: Array[String] = Array[String] (
        "Flowgate",
        "TerminalConstraintTerm"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Flowgate", "Flowgate", "0..1", "0..*"),
        Relationship ("TerminalConstraintTerm", "TerminalConstraintTerm", "0..*", "1")
    )
    val Flowgate: Fielder = parse_attribute (attribute (cls, fields(0)))
    val TerminalConstraintTerm: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): MktTerminal =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MktTerminal (
            Terminal.parse (context),
            mask (Flowgate (), 0),
            masks (TerminalConstraintTerm (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Subclass of IEC61968:Domain2:UserAttribute.
 *
 * @param sup [[ch.ninecode.model.UserAttribute UserAttribute]] Reference to the superclass object.
 * @param AttributeProperty [[ch.ninecode.model.AttributeProperty AttributeProperty]] <em>undocumented</em>
 * @param BillDeterminant [[ch.ninecode.model.BillDeterminant BillDeterminant]] <em>undocumented</em>
 * @param ChargeGroup [[ch.ninecode.model.ChargeGroup ChargeGroup]] <em>undocumented</em>
 * @param ChargeType [[ch.ninecode.model.ChargeType ChargeType]] <em>undocumented</em>
 * @param MarketStatementLineItem [[ch.ninecode.model.MarketStatementLineItem MarketStatementLineItem]] <em>undocumented</em>
 * @param PassThroughBill [[ch.ninecode.model.PassThroughBill PassThroughBill]] <em>undocumented</em>
 * @group MarketOpCommon
 * @groupname MarketOpCommon Package MarketOpCommon
 * @groupdesc MarketOpCommon This package contains the common objects shared by MarketOperations packages.
 */
final case class MktUserAttribute
(
    override val sup: UserAttribute = null,
    AttributeProperty: List[String] = List(),
    BillDeterminant: List[String] = List(),
    ChargeGroup: List[String] = List(),
    ChargeType: List[String] = List(),
    MarketStatementLineItem: List[String] = List(),
    PassThroughBill: List[String] = List()
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
    def UserAttribute: UserAttribute = sup.asInstanceOf[UserAttribute]
    override def copy (): Row = { clone ().asInstanceOf[MktUserAttribute] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MktUserAttribute.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MktUserAttribute.fields (position), x))
        emitattrs (0, AttributeProperty)
        emitattrs (1, BillDeterminant)
        emitattrs (2, ChargeGroup)
        emitattrs (3, ChargeType)
        emitattrs (4, MarketStatementLineItem)
        emitattrs (5, PassThroughBill)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MktUserAttribute rdf:ID=\"%s\">\n%s\t</cim:MktUserAttribute>".format (id, export_fields)
    }
}

object MktUserAttribute
extends
    Parseable[MktUserAttribute]
{
    override val fields: Array[String] = Array[String] (
        "AttributeProperty",
        "BillDeterminant",
        "ChargeGroup",
        "ChargeType",
        "MarketStatementLineItem",
        "PassThroughBill"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AttributeProperty", "AttributeProperty", "0..*", "1"),
        Relationship ("BillDeterminant", "BillDeterminant", "0..*", "0..*"),
        Relationship ("ChargeGroup", "ChargeGroup", "0..*", "0..*"),
        Relationship ("ChargeType", "ChargeType", "0..*", "0..*"),
        Relationship ("MarketStatementLineItem", "MarketStatementLineItem", "0..*", "0..*"),
        Relationship ("PassThroughBill", "PassThroughBill", "0..*", "0..*")
    )
    val AttributeProperty: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val BillDeterminant: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val ChargeGroup: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val ChargeType: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val MarketStatementLineItem: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val PassThroughBill: FielderMultiple = parse_attributes (attribute (cls, fields(5)))

    def parse (context: Context): MktUserAttribute =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MktUserAttribute (
            UserAttribute.parse (context),
            masks (AttributeProperty (), 0),
            masks (BillDeterminant (), 1),
            masks (ChargeGroup (), 2),
            masks (ChargeType (), 3),
            masks (MarketStatementLineItem (), 4),
            masks (PassThroughBill (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _MarketOpCommon
{
    def register: List[ClassInfo] =
    {
        List (
            MarketInvoice.register,
            MarketInvoiceLineItem.register,
            MarketLedger.register,
            MarketLedgerEntry.register,
            MktActivityRecord.register,
            MktConnectivityNode.register,
            MktLine.register,
            MktMeasurement.register,
            MktPowerTransformer.register,
            MktTerminal.register,
            MktUserAttribute.register
        )
    }
}