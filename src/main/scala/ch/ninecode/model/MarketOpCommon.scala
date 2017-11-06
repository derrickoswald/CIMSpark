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
case class MarketInvoice
(
    override val sup: BasicElement,
    amount: Double,
    billMediaKind: String,
    dueDate: String,
    kind: String,
    mailedDate: String,
    proForma: Boolean,
    referenceNumber: String,
    transactionDateTime: String,
    transferType: String,
    MajorChargeGroup: List[String],
    MarketInvoiceLineItems: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, null, null, null, false, null, null, null, List(), List()) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MarketInvoice.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MarketInvoice.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MarketInvoice.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (MarketInvoice.fields (position), x))
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
        implicit var bitfields: Array[Int] = Array(0)
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
case class MarketInvoiceLineItem
(
    override val sup: BasicElement,
    billPeriod: String,
    glAccount: String,
    glDateTime: String,
    kind: String,
    lineAmount: Double,
    lineNumber: String,
    lineVersion: String,
    netAmount: Double,
    previousAmount: Double,
    ComponentMarketInvoiceLineItems: List[String],
    ContainerMarketInvoiceLineItem: String,
    MarketInvoice: String,
    Settlement: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, 0.0, null, null, 0.0, 0.0, List(), null, null, List()) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MarketInvoiceLineItem.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MarketInvoiceLineItem.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MarketInvoiceLineItem.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (MarketInvoiceLineItem.fields (position), x))
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
        implicit var bitfields: Array[Int] = Array(0)
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
 * Journal entries are periodically posted to the ledger. Ledger Actual represents actual amounts by account within ledger within company or business area. Actual amounts may be generated in a source application and then loaded to a specific ledger within the enterprise general ledger or budget application.
 *
 * @param sup Reference to the superclass object.
 * @param MarketLedgerEntries [[ch.ninecode.model.MarketLedgerEntry MarketLedgerEntry]] <em>undocumented</em>
 * @group MarketOpCommon
 * @groupname MarketOpCommon Package MarketOpCommon
 * @groupdesc MarketOpCommon This package contains the common objects shared by MarketOperations packages.
 */
case class MarketLedger
(
    override val sup: BasicElement,
    MarketLedgerEntries: List[String]
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
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[MarketLedger] }
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
        implicit val clz: String = MarketLedger.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (MarketLedger.fields (position), x))
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
        implicit var bitfields: Array[Int] = Array(0)
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
case class MarketLedgerEntry
(
    override val sup: BasicElement,
    accountID: String,
    accountKind: String,
    amount: Double,
    postedDateTime: String,
    status: String,
    transactionDateTime: String,
    MarketLedger: String,
    Settlement: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, 0.0, null, null, null, null, List()) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MarketLedgerEntry.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MarketLedgerEntry.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MarketLedgerEntry.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (MarketLedgerEntry.fields (position), x))
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
        implicit var bitfields: Array[Int] = Array(0)
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
 * Subclass of IEC61968: Common:ActivityRecord
 *
 * @param sup [[ch.ninecode.model.ActivityRecord ActivityRecord]] Reference to the superclass object.
 * @param MarketFactors [[ch.ninecode.model.MarketFactors MarketFactors]] <em>undocumented</em>
 * @group MarketOpCommon
 * @groupname MarketOpCommon Package MarketOpCommon
 * @groupdesc MarketOpCommon This package contains the common objects shared by MarketOperations packages.
 */
case class MktActivityRecord
(
    override val sup: ActivityRecord,
    MarketFactors: List[String]
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
    def ActivityRecord: ActivityRecord = sup.asInstanceOf[ActivityRecord]
    override def copy (): Row = { clone ().asInstanceOf[MktActivityRecord] }
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
        implicit val clz: String = MktActivityRecord.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (MktActivityRecord.fields (position), x))
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
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MktActivityRecord (
            ActivityRecord.parse (context),
            masks (MarketFactors (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Subclass of IEC61970:Topology:ConnectivityNode
 *
 * @param sup [[ch.ninecode.model.ConnectivityNode ConnectivityNode]] Reference to the superclass object.
 * @param endEffectiveDate end effective date
 * @param startEffectiveDate start effective date
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
case class MktConnectivityNode
(
    override val sup: ConnectivityNode,
    endEffectiveDate: String,
    startEffectiveDate: String,
    CnodeDistributionFactor: List[String],
    IndividualPnode: String,
    LossPenaltyFactor: List[String],
    NodeConstraintTerm: List[String],
    RTO: String,
    RegisteredResource: List[String],
    SysLoadDistribuFactor: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, List(), null, List(), List(), null, List(), null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MktConnectivityNode.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MktConnectivityNode.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MktConnectivityNode.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (MktConnectivityNode.fields (position), x))
        emitelem (0, endEffectiveDate)
        emitelem (1, startEffectiveDate)
        emitattrs (2, CnodeDistributionFactor)
        emitattr (3, IndividualPnode)
        emitattrs (4, LossPenaltyFactor)
        emitattrs (5, NodeConstraintTerm)
        emitattr (6, RTO)
        emitattrs (7, RegisteredResource)
        emitattr (8, SysLoadDistribuFactor)
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
        "endEffectiveDate",
        "startEffectiveDate",
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
    val endEffectiveDate: Fielder = parse_element (element (cls, fields(0)))
    val startEffectiveDate: Fielder = parse_element (element (cls, fields(1)))
    val CnodeDistributionFactor: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val IndividualPnode: Fielder = parse_attribute (attribute (cls, fields(3)))
    val LossPenaltyFactor: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val NodeConstraintTerm: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val RTO: Fielder = parse_attribute (attribute (cls, fields(6)))
    val RegisteredResource: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val SysLoadDistribuFactor: Fielder = parse_attribute (attribute (cls, fields(8)))

    def parse (context: Context): MktConnectivityNode =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MktConnectivityNode (
            ConnectivityNode.parse (context),
            mask (endEffectiveDate (), 0),
            mask (startEffectiveDate (), 1),
            masks (CnodeDistributionFactor (), 2),
            mask (IndividualPnode (), 3),
            masks (LossPenaltyFactor (), 4),
            masks (NodeConstraintTerm (), 5),
            mask (RTO (), 6),
            masks (RegisteredResource (), 7),
            mask (SysLoadDistribuFactor (), 8)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Subclass of IEC61970:Wires:EnergyConsumer
 *
 * @param sup [[ch.ninecode.model.EnergyConsumer EnergyConsumer]] Reference to the superclass object.
 * @param EnergyConsumerData [[ch.ninecode.model.EnergyConsumerData EnergyConsumerData]] <em>undocumented</em>
 * @param RegisteredLoad [[ch.ninecode.model.RegisteredLoad RegisteredLoad]] <em>undocumented</em>
 * @group MarketOpCommon
 * @groupname MarketOpCommon Package MarketOpCommon
 * @groupdesc MarketOpCommon This package contains the common objects shared by MarketOperations packages.
 */
case class MktEnergyConsumer
(
    override val sup: EnergyConsumer,
    EnergyConsumerData: List[String],
    RegisteredLoad: String
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
    def EnergyConsumer: EnergyConsumer = sup.asInstanceOf[EnergyConsumer]
    override def copy (): Row = { clone ().asInstanceOf[MktEnergyConsumer] }
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
        implicit val clz: String = MktEnergyConsumer.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MktEnergyConsumer.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (MktEnergyConsumer.fields (position), x))
        emitattrs (0, EnergyConsumerData)
        emitattr (1, RegisteredLoad)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MktEnergyConsumer rdf:ID=\"%s\">\n%s\t</cim:MktEnergyConsumer>".format (id, export_fields)
    }
}

object MktEnergyConsumer
extends
    Parseable[MktEnergyConsumer]
{
    override val fields: Array[String] = Array[String] (
        "EnergyConsumerData",
        "RegisteredLoad"
    )
    override val relations: List[Relationship] = List (
        Relationship ("EnergyConsumerData", "EnergyConsumerData", "0..*", "1"),
        Relationship ("RegisteredLoad", "RegisteredLoad", "0..1", "0..*")
    )
    val EnergyConsumerData: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val RegisteredLoad: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): MktEnergyConsumer =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MktEnergyConsumer (
            EnergyConsumer.parse (context),
            masks (EnergyConsumerData (), 0),
            mask (RegisteredLoad (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Subclass of IEC61970:Production:GeneratingUnit
 *
 * @param sup [[ch.ninecode.model.GeneratingUnit GeneratingUnit]] Reference to the superclass object.
 * @param GeneratingUnitDynamicValues [[ch.ninecode.model.GeneratingUnitDynamicValues GeneratingUnitDynamicValues]] <em>undocumented</em>
 * @param RegisteredGenerator [[ch.ninecode.model.RegisteredGenerator RegisteredGenerator]] <em>undocumented</em>
 * @group MarketOpCommon
 * @groupname MarketOpCommon Package MarketOpCommon
 * @groupdesc MarketOpCommon This package contains the common objects shared by MarketOperations packages.
 */
case class MktGeneratingUnit
(
    override val sup: GeneratingUnit,
    GeneratingUnitDynamicValues: List[String],
    RegisteredGenerator: String
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
    def GeneratingUnit: GeneratingUnit = sup.asInstanceOf[GeneratingUnit]
    override def copy (): Row = { clone ().asInstanceOf[MktGeneratingUnit] }
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
        implicit val clz: String = MktGeneratingUnit.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MktGeneratingUnit.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (MktGeneratingUnit.fields (position), x))
        emitattrs (0, GeneratingUnitDynamicValues)
        emitattr (1, RegisteredGenerator)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MktGeneratingUnit rdf:ID=\"%s\">\n%s\t</cim:MktGeneratingUnit>".format (id, export_fields)
    }
}

object MktGeneratingUnit
extends
    Parseable[MktGeneratingUnit]
{
    override val fields: Array[String] = Array[String] (
        "GeneratingUnitDynamicValues",
        "RegisteredGenerator"
    )
    override val relations: List[Relationship] = List (
        Relationship ("GeneratingUnitDynamicValues", "GeneratingUnitDynamicValues", "0..*", "1"),
        Relationship ("RegisteredGenerator", "RegisteredGenerator", "0..1", "0..*")
    )
    val GeneratingUnitDynamicValues: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val RegisteredGenerator: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): MktGeneratingUnit =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MktGeneratingUnit (
            GeneratingUnit.parse (context),
            masks (GeneratingUnitDynamicValues (), 0),
            mask (RegisteredGenerator (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Subclass for IEC61970:Wires:Line
 *
 * @param sup [[ch.ninecode.model.Line Line]] Reference to the superclass object.
 * @param Flowgate [[ch.ninecode.model.Flowgate Flowgate]] <em>undocumented</em>
 * @param TransmissionRightOfWay [[ch.ninecode.model.TransmissionRightOfWay TransmissionRightOfWay]] <em>undocumented</em>
 * @group MarketOpCommon
 * @groupname MarketOpCommon Package MarketOpCommon
 * @groupdesc MarketOpCommon This package contains the common objects shared by MarketOperations packages.
 */
case class MktLine
(
    override val sup: Line,
    Flowgate: List[String],
    TransmissionRightOfWay: String
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
    def Line: Line = sup.asInstanceOf[Line]
    override def copy (): Row = { clone ().asInstanceOf[MktLine] }
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
        implicit val clz: String = MktLine.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MktLine.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (MktLine.fields (position), x))
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
        implicit var bitfields: Array[Int] = Array(0)
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
 * Subclass of IEC61970:LoadModel: LoadArea
 *
 * @param sup [[ch.ninecode.model.LoadArea LoadArea]] Reference to the superclass object.
 * @param AreaLoadCurve [[ch.ninecode.model.AreaLoadCurve AreaLoadCurve]] <em>undocumented</em>
 * @param RegisteredLoad [[ch.ninecode.model.RegisteredLoad RegisteredLoad]] <em>undocumented</em>
 * @group MarketOpCommon
 * @groupname MarketOpCommon Package MarketOpCommon
 * @groupdesc MarketOpCommon This package contains the common objects shared by MarketOperations packages.
 */
case class MktLoadArea
(
    override val sup: LoadArea,
    AreaLoadCurve: List[String],
    RegisteredLoad: List[String]
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
    def LoadArea: LoadArea = sup.asInstanceOf[LoadArea]
    override def copy (): Row = { clone ().asInstanceOf[MktLoadArea] }
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
        implicit val clz: String = MktLoadArea.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (MktLoadArea.fields (position), x))
        emitattrs (0, AreaLoadCurve)
        emitattrs (1, RegisteredLoad)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MktLoadArea rdf:ID=\"%s\">\n%s\t</cim:MktLoadArea>".format (id, export_fields)
    }
}

object MktLoadArea
extends
    Parseable[MktLoadArea]
{
    override val fields: Array[String] = Array[String] (
        "AreaLoadCurve",
        "RegisteredLoad"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AreaLoadCurve", "AreaLoadCurve", "0..*", "0..1"),
        Relationship ("RegisteredLoad", "RegisteredLoad", "0..*", "1")
    )
    val AreaLoadCurve: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val RegisteredLoad: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): MktLoadArea =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MktLoadArea (
            LoadArea.parse (context),
            masks (AreaLoadCurve (), 0),
            masks (RegisteredLoad (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Subclass of IEC61970:Meas:Measurement
 *
 * @param sup [[ch.ninecode.model.Measurement Measurement]] Reference to the superclass object.
 * @param ByTiePoint [[ch.ninecode.model.TiePoint TiePoint]] A measurement is made on the B side of a tie point
 * @param DynamicSchedule [[ch.ninecode.model.DynamicSchedule DynamicSchedule]] <em>undocumented</em>
 * @param ForTiePoint [[ch.ninecode.model.TiePoint TiePoint]] A measurement is made on the A side of a tie point
 * @param Pnode [[ch.ninecode.model.Pnode Pnode]] <em>undocumented</em>
 * @param ViolationLimit [[ch.ninecode.model.ViolationLimit ViolationLimit]] <em>undocumented</em>
 * @group MarketOpCommon
 * @groupname MarketOpCommon Package MarketOpCommon
 * @groupdesc MarketOpCommon This package contains the common objects shared by MarketOperations packages.
 */
case class MktMeasurement
(
    override val sup: Measurement,
    ByTiePoint: String,
    DynamicSchedule: List[String],
    ForTiePoint: String,
    Pnode: String,
    ViolationLimit: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, List(), null, null, List()) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MktMeasurement.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MktMeasurement.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (MktMeasurement.fields (position), x))
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
        implicit var bitfields: Array[Int] = Array(0)
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
 * Subclass of IEC61968:Core2:TopLevel:Organisation
 *
 * @param sup [[ch.ninecode.model.Organisation Organisation]] Reference to the superclass object.
 * @param creditFlag Flag to indicate creditworthiness (Y, N)
 * @param creditStartEffectiveDate Date that the organisation becomes creditworthy.
 * @param endEffectiveDate end effective date
 * @param lastModified Indication of the last time this Organization information was modified.
 * @param organisationID Organisation (internal) ID
 * @param qualificationStatus Organisation qualification status, Qualified, Not Qualified, or Disqualified
 * @param startEffectiveDate start effective date
 * @param CRROrgRole [[ch.ninecode.model.CRROrgRole CRROrgRole]] <em>undocumented</em>
 * @param IntSchedAgreement [[ch.ninecode.model.IntSchedAgreement IntSchedAgreement]] <em>undocumented</em>
 * @param MarketPerson [[ch.ninecode.model.MarketPerson MarketPerson]] <em>undocumented</em>
 * @param OrgPnodeAllocation [[ch.ninecode.model.OrgPnodeAllocation OrgPnodeAllocation]] <em>undocumented</em>
 * @param OrgResOwnership [[ch.ninecode.model.OrgResOwnership OrgResOwnership]] <em>undocumented</em>
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @param SchedulingCoordinator [[ch.ninecode.model.SchedulingCoordinator SchedulingCoordinator]] <em>undocumented</em>
 * @param ViolationLimit [[ch.ninecode.model.ViolationLimit ViolationLimit]] <em>undocumented</em>
 * @group MarketOpCommon
 * @groupname MarketOpCommon Package MarketOpCommon
 * @groupdesc MarketOpCommon This package contains the common objects shared by MarketOperations packages.
 */
case class MktOrganisation
(
    override val sup: Organisation,
    creditFlag: String,
    creditStartEffectiveDate: String,
    endEffectiveDate: String,
    lastModified: String,
    organisationID: Int,
    qualificationStatus: String,
    startEffectiveDate: String,
    CRROrgRole: List[String],
    IntSchedAgreement: List[String],
    MarketPerson: List[String],
    OrgPnodeAllocation: List[String],
    OrgResOwnership: List[String],
    RegisteredResource: List[String],
    SchedulingCoordinator: List[String],
    ViolationLimit: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, 0, null, null, List(), List(), List(), List(), List(), List(), List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Organisation: Organisation = sup.asInstanceOf[Organisation]
    override def copy (): Row = { clone ().asInstanceOf[MktOrganisation] }
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
        implicit val clz: String = MktOrganisation.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MktOrganisation.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MktOrganisation.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (MktOrganisation.fields (position), x))
        emitattr (0, creditFlag)
        emitelem (1, creditStartEffectiveDate)
        emitelem (2, endEffectiveDate)
        emitelem (3, lastModified)
        emitelem (4, organisationID)
        emitelem (5, qualificationStatus)
        emitelem (6, startEffectiveDate)
        emitattrs (7, CRROrgRole)
        emitattrs (8, IntSchedAgreement)
        emitattrs (9, MarketPerson)
        emitattrs (10, OrgPnodeAllocation)
        emitattrs (11, OrgResOwnership)
        emitattrs (12, RegisteredResource)
        emitattrs (13, SchedulingCoordinator)
        emitattrs (14, ViolationLimit)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MktOrganisation rdf:ID=\"%s\">\n%s\t</cim:MktOrganisation>".format (id, export_fields)
    }
}

object MktOrganisation
extends
    Parseable[MktOrganisation]
{
    override val fields: Array[String] = Array[String] (
        "creditFlag",
        "creditStartEffectiveDate",
        "endEffectiveDate",
        "lastModified",
        "organisationID",
        "qualificationStatus",
        "startEffectiveDate",
        "CRROrgRole",
        "IntSchedAgreement",
        "MarketPerson",
        "OrgPnodeAllocation",
        "OrgResOwnership",
        "RegisteredResource",
        "SchedulingCoordinator",
        "ViolationLimit"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CRROrgRole", "CRROrgRole", "0..*", "1"),
        Relationship ("IntSchedAgreement", "IntSchedAgreement", "0..*", "0..*"),
        Relationship ("MarketPerson", "MarketPerson", "0..*", "0..*"),
        Relationship ("OrgPnodeAllocation", "OrgPnodeAllocation", "0..*", "1"),
        Relationship ("OrgResOwnership", "OrgResOwnership", "0..*", "1"),
        Relationship ("RegisteredResource", "RegisteredResource", "0..*", "0..1"),
        Relationship ("SchedulingCoordinator", "SchedulingCoordinator", "0..*", "1"),
        Relationship ("ViolationLimit", "ViolationLimit", "0..*", "0..*")
    )
    val creditFlag: Fielder = parse_attribute (attribute (cls, fields(0)))
    val creditStartEffectiveDate: Fielder = parse_element (element (cls, fields(1)))
    val endEffectiveDate: Fielder = parse_element (element (cls, fields(2)))
    val lastModified: Fielder = parse_element (element (cls, fields(3)))
    val organisationID: Fielder = parse_element (element (cls, fields(4)))
    val qualificationStatus: Fielder = parse_element (element (cls, fields(5)))
    val startEffectiveDate: Fielder = parse_element (element (cls, fields(6)))
    val CRROrgRole: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val IntSchedAgreement: FielderMultiple = parse_attributes (attribute (cls, fields(8)))
    val MarketPerson: FielderMultiple = parse_attributes (attribute (cls, fields(9)))
    val OrgPnodeAllocation: FielderMultiple = parse_attributes (attribute (cls, fields(10)))
    val OrgResOwnership: FielderMultiple = parse_attributes (attribute (cls, fields(11)))
    val RegisteredResource: FielderMultiple = parse_attributes (attribute (cls, fields(12)))
    val SchedulingCoordinator: FielderMultiple = parse_attributes (attribute (cls, fields(13)))
    val ViolationLimit: FielderMultiple = parse_attributes (attribute (cls, fields(14)))

    def parse (context: Context): MktOrganisation =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MktOrganisation (
            Organisation.parse (context),
            mask (creditFlag (), 0),
            mask (creditStartEffectiveDate (), 1),
            mask (endEffectiveDate (), 2),
            mask (lastModified (), 3),
            toInteger (mask (organisationID (), 4)),
            mask (qualificationStatus (), 5),
            mask (startEffectiveDate (), 6),
            masks (CRROrgRole (), 7),
            masks (IntSchedAgreement (), 8),
            masks (MarketPerson (), 9),
            masks (OrgPnodeAllocation (), 10),
            masks (OrgResOwnership (), 11),
            masks (RegisteredResource (), 12),
            masks (SchedulingCoordinator (), 13),
            masks (ViolationLimit (), 14)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Subclass of IEC61970:Wires:PowerTransformer
 *
 * @param sup [[ch.ninecode.model.PowerTransformer PowerTransformer]] Reference to the superclass object.
 * @param EndAFlow [[ch.ninecode.model.BranchEndFlow BranchEndFlow]] <em>undocumented</em>
 * @param EndBFlow [[ch.ninecode.model.BranchEndFlow BranchEndFlow]] <em>undocumented</em>
 * @param Flowgate [[ch.ninecode.model.Flowgate Flowgate]] <em>undocumented</em>
 * @group MarketOpCommon
 * @groupname MarketOpCommon Package MarketOpCommon
 * @groupdesc MarketOpCommon This package contains the common objects shared by MarketOperations packages.
 */
case class MktPowerTransformer
(
    override val sup: PowerTransformer,
    EndAFlow: String,
    EndBFlow: String,
    Flowgate: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, List()) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MktPowerTransformer.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MktPowerTransformer.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (MktPowerTransformer.fields (position), x))
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
        implicit var bitfields: Array[Int] = Array(0)
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
 * Subclass of IEC61970:Core:Terminal
 *
 * @param sup [[ch.ninecode.model.Terminal Terminal]] Reference to the superclass object.
 * @param endEffectiveDate This is the end date/time of the element eligibility for the flowgate.
 * @param startEffectiveDate This is the begin date/time of the element eligibility for the flowgate.
 * @param Flowgate [[ch.ninecode.model.Flowgate Flowgate]] <em>undocumented</em>
 * @param TerminalConstraintTerm [[ch.ninecode.model.TerminalConstraintTerm TerminalConstraintTerm]] <em>undocumented</em>
 * @group MarketOpCommon
 * @groupname MarketOpCommon Package MarketOpCommon
 * @groupdesc MarketOpCommon This package contains the common objects shared by MarketOperations packages.
 */
case class MktTerminal
(
    override val sup: Terminal,
    endEffectiveDate: String,
    startEffectiveDate: String,
    Flowgate: String,
    TerminalConstraintTerm: List[String]
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
    def Terminal: Terminal = sup.asInstanceOf[Terminal]
    override def copy (): Row = { clone ().asInstanceOf[MktTerminal] }
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
        implicit val clz: String = MktTerminal.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MktTerminal.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MktTerminal.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (MktTerminal.fields (position), x))
        emitelem (0, endEffectiveDate)
        emitelem (1, startEffectiveDate)
        emitattr (2, Flowgate)
        emitattrs (3, TerminalConstraintTerm)
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
        "endEffectiveDate",
        "startEffectiveDate",
        "Flowgate",
        "TerminalConstraintTerm"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Flowgate", "Flowgate", "0..1", "0..*"),
        Relationship ("TerminalConstraintTerm", "TerminalConstraintTerm", "0..*", "1")
    )
    val endEffectiveDate: Fielder = parse_element (element (cls, fields(0)))
    val startEffectiveDate: Fielder = parse_element (element (cls, fields(1)))
    val Flowgate: Fielder = parse_attribute (attribute (cls, fields(2)))
    val TerminalConstraintTerm: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: Context): MktTerminal =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MktTerminal (
            Terminal.parse (context),
            mask (endEffectiveDate (), 0),
            mask (startEffectiveDate (), 1),
            mask (Flowgate (), 2),
            masks (TerminalConstraintTerm (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Subclass of IEC61968:Domain2:UserAttribute
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
case class MktUserAttribute
(
    override val sup: UserAttribute,
    AttributeProperty: List[String],
    BillDeterminant: List[String],
    ChargeGroup: List[String],
    ChargeType: List[String],
    MarketStatementLineItem: List[String],
    PassThroughBill: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List(), List(), List(), List(), List(), List()) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MktUserAttribute.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (MktUserAttribute.fields (position), x))
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
        implicit var bitfields: Array[Int] = Array(0)
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
            MktEnergyConsumer.register,
            MktGeneratingUnit.register,
            MktLine.register,
            MktLoadArea.register,
            MktMeasurement.register,
            MktOrganisation.register,
            MktPowerTransformer.register,
            MktTerminal.register,
            MktUserAttribute.register
        )
    }
}