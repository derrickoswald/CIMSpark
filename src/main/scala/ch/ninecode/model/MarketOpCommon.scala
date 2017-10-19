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
    transferType: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, null, null, null, false, null, null, null) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
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
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MarketInvoice.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MarketInvoice.fields (position), value)
        emitelem (0, amount)
        emitattr (1, billMediaKind)
        emitelem (2, dueDate)
        emitattr (3, kind)
        emitelem (4, mailedDate)
        emitelem (5, proForma)
        emitelem (6, referenceNumber)
        emitelem (7, transactionDateTime)
        emitelem (8, transferType)
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
    val fields: Array[String] = Array[String] (
        "amount",
        "billMediaKind",
        "dueDate",
        "kind",
        "mailedDate",
        "proForma",
        "referenceNumber",
        "transactionDateTime",
        "transferType"
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

    def parse (context: Context): MarketInvoice =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
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
            mask (transferType (), 8)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (

    )
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
    def this () = { this (null, null, null, null, null, 0.0, null, null, 0.0, 0.0, null, null, List()) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
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
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
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
        emitattr (9, ContainerMarketInvoiceLineItem)
        emitattr (10, MarketInvoice)
        emitattrs (11, Settlement)
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
    val fields: Array[String] = Array[String] (
        "billPeriod",
        "glAccount",
        "glDateTime",
        "kind",
        "lineAmount",
        "lineNumber",
        "lineVersion",
        "netAmount",
        "previousAmount",
        "ContainerMarketInvoiceLineItem",
        "MarketInvoice",
        "Settlement"
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
    val ContainerMarketInvoiceLineItem: Fielder = parse_attribute (attribute (cls, fields(9)))
    val MarketInvoice: Fielder = parse_attribute (attribute (cls, fields(10)))
    val Settlement: FielderMultiple = parse_attributes (attribute (cls, fields(11)))

    def parse (context: Context): MarketInvoiceLineItem =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        def masks (field: Fields, position: Int): List[String] = { if (field._2) fields |= 1 << position; field._1 }
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
            mask (ContainerMarketInvoiceLineItem (), 9),
            mask (MarketInvoice (), 10),
            masks (Settlement (), 11)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ContainerMarketInvoiceLineItem", "MarketInvoiceLineItem", false),
        Relationship ("MarketInvoice", "MarketInvoice", false),
        Relationship ("Settlement", "Settlement", true)
    )
}

/**
 * In accounting transactions, a ledger is a book containing accounts to which debits and credits are posted from journals, where transactions are initially recorded.
 *
 * Journal entries are periodically posted to the ledger. Ledger Actual represents actual amounts by account within ledger within company or business area. Actual amounts may be generated in a source application and then loaded to a specific ledger within the enterprise general ledger or budget application.
 *
 * @param sup Reference to the superclass object.
 * @group MarketOpCommon
 * @groupname MarketOpCommon Package MarketOpCommon
 * @groupdesc MarketOpCommon This package contains the common objects shared by MarketOperations packages.
 */
case class MarketLedger
(
    override val sup: BasicElement
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
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
        sup.export_fields
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

    def parse (context: Context): MarketLedger =
    {
        implicit val ctx: Context = context
        val ret = MarketLedger (
            BasicElement.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
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
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
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
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
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
    val fields: Array[String] = Array[String] (
        "accountID",
        "accountKind",
        "amount",
        "postedDateTime",
        "status",
        "transactionDateTime",
        "MarketLedger",
        "Settlement"
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
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        def masks (field: Fields, position: Int): List[String] = { if (field._2) fields |= 1 << position; field._1 }
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
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("MarketLedger", "MarketLedger", false),
        Relationship ("Settlement", "Settlement", true)
    )
}

/**
 * Subclass of IEC61968: Common:ActivityRecord
 *
 * @param sup [[ch.ninecode.model.ActivityRecord ActivityRecord]] Reference to the superclass object.
 * @group MarketOpCommon
 * @groupname MarketOpCommon Package MarketOpCommon
 * @groupdesc MarketOpCommon This package contains the common objects shared by MarketOperations packages.
 */
case class MktActivityRecord
(
    override val sup: ActivityRecord
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
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
        sup.export_fields
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

    def parse (context: Context): MktActivityRecord =
    {
        implicit val ctx: Context = context
        val ret = MktActivityRecord (
            ActivityRecord.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Subclass of IEC61970:Topology:ConnectivityNode
 *
 * @param sup [[ch.ninecode.model.ConnectivityNode ConnectivityNode]] Reference to the superclass object.
 * @param endEffectiveDate end effective date
 * @param startEffectiveDate start effective date
 * @param IndividualPnode [[ch.ninecode.model.IndividualPnode IndividualPnode]] <em>undocumented</em>
 * @param RTO [[ch.ninecode.model.RTO RTO]] <em>undocumented</em>
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
    IndividualPnode: String,
    RTO: String,
    SysLoadDistribuFactor: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
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
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MktConnectivityNode.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MktConnectivityNode.fields (position), value)
        emitelem (0, endEffectiveDate)
        emitelem (1, startEffectiveDate)
        emitattr (2, IndividualPnode)
        emitattr (3, RTO)
        emitattr (4, SysLoadDistribuFactor)
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
    val fields: Array[String] = Array[String] (
        "endEffectiveDate",
        "startEffectiveDate",
        "IndividualPnode",
        "RTO",
        "SysLoadDistribuFactor"
    )
    val endEffectiveDate: Fielder = parse_element (element (cls, fields(0)))
    val startEffectiveDate: Fielder = parse_element (element (cls, fields(1)))
    val IndividualPnode: Fielder = parse_attribute (attribute (cls, fields(2)))
    val RTO: Fielder = parse_attribute (attribute (cls, fields(3)))
    val SysLoadDistribuFactor: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): MktConnectivityNode =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = MktConnectivityNode (
            ConnectivityNode.parse (context),
            mask (endEffectiveDate (), 0),
            mask (startEffectiveDate (), 1),
            mask (IndividualPnode (), 2),
            mask (RTO (), 3),
            mask (SysLoadDistribuFactor (), 4)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("IndividualPnode", "IndividualPnode", false),
        Relationship ("RTO", "RTO", false),
        Relationship ("SysLoadDistribuFactor", "SysLoadDistributionFactor", false)
    )
}

/**
 * Subclass of IEC61970:Wires:EnergyConsumer
 *
 * @param sup [[ch.ninecode.model.EnergyConsumer EnergyConsumer]] Reference to the superclass object.
 * @param RegisteredLoad [[ch.ninecode.model.RegisteredLoad RegisteredLoad]] <em>undocumented</em>
 * @group MarketOpCommon
 * @groupname MarketOpCommon Package MarketOpCommon
 * @groupdesc MarketOpCommon This package contains the common objects shared by MarketOperations packages.
 */
case class MktEnergyConsumer
(
    override val sup: EnergyConsumer,
    RegisteredLoad: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
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
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MktEnergyConsumer.fields (position), value)
        emitattr (0, RegisteredLoad)
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
    val fields: Array[String] = Array[String] (
        "RegisteredLoad"
    )
    val RegisteredLoad: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): MktEnergyConsumer =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = MktEnergyConsumer (
            EnergyConsumer.parse (context),
            mask (RegisteredLoad (), 0)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("RegisteredLoad", "RegisteredLoad", false)
    )
}

/**
 * Subclass of IEC61970:Production:GeneratingUnit
 *
 * @param sup [[ch.ninecode.model.GeneratingUnit GeneratingUnit]] Reference to the superclass object.
 * @param RegisteredGenerator [[ch.ninecode.model.RegisteredGenerator RegisteredGenerator]] <em>undocumented</em>
 * @group MarketOpCommon
 * @groupname MarketOpCommon Package MarketOpCommon
 * @groupdesc MarketOpCommon This package contains the common objects shared by MarketOperations packages.
 */
case class MktGeneratingUnit
(
    override val sup: GeneratingUnit,
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
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
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
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MktGeneratingUnit.fields (position), value)
        emitattr (0, RegisteredGenerator)
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
    val fields: Array[String] = Array[String] (
        "RegisteredGenerator"
    )
    val RegisteredGenerator: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): MktGeneratingUnit =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = MktGeneratingUnit (
            GeneratingUnit.parse (context),
            mask (RegisteredGenerator (), 0)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("RegisteredGenerator", "RegisteredGenerator", false)
    )
}

/**
 * Subclass for IEC61970:Wires:Line
 *
 * @param sup [[ch.ninecode.model.Line Line]] Reference to the superclass object.
 * @param TransmissionRightOfWay [[ch.ninecode.model.TransmissionRightOfWay TransmissionRightOfWay]] <em>undocumented</em>
 * @group MarketOpCommon
 * @groupname MarketOpCommon Package MarketOpCommon
 * @groupdesc MarketOpCommon This package contains the common objects shared by MarketOperations packages.
 */
case class MktLine
(
    override val sup: Line,
    TransmissionRightOfWay: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
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
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MktLine.fields (position), value)
        emitattr (0, TransmissionRightOfWay)
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
    val fields: Array[String] = Array[String] (
        "TransmissionRightOfWay"
    )
    val TransmissionRightOfWay: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): MktLine =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = MktLine (
            Line.parse (context),
            mask (TransmissionRightOfWay (), 0)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("TransmissionRightOfWay", "TransmissionRightOfWay", false)
    )
}

/**
 * Subclass of IEC61970:LoadModel: LoadArea
 *
 * @param sup [[ch.ninecode.model.LoadArea LoadArea]] Reference to the superclass object.
 * @group MarketOpCommon
 * @groupname MarketOpCommon Package MarketOpCommon
 * @groupdesc MarketOpCommon This package contains the common objects shared by MarketOperations packages.
 */
case class MktLoadArea
(
    override val sup: LoadArea
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
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
        sup.export_fields
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

    def parse (context: Context): MktLoadArea =
    {
        implicit val ctx: Context = context
        val ret = MktLoadArea (
            LoadArea.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Subclass of IEC61970:Meas:Measurement
 *
 * @param sup [[ch.ninecode.model.Measurement Measurement]] Reference to the superclass object.
 * @param ByTiePoint [[ch.ninecode.model.TiePoint TiePoint]] A measurement is made on the B side of a tie point
 * @param ForTiePoint [[ch.ninecode.model.TiePoint TiePoint]] A measurement is made on the A side of a tie point
 * @param Pnode [[ch.ninecode.model.Pnode Pnode]] <em>undocumented</em>
 * @group MarketOpCommon
 * @groupname MarketOpCommon Package MarketOpCommon
 * @groupdesc MarketOpCommon This package contains the common objects shared by MarketOperations packages.
 */
case class MktMeasurement
(
    override val sup: Measurement,
    ByTiePoint: String,
    ForTiePoint: String,
    Pnode: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
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
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MktMeasurement.fields (position), value)
        emitattr (0, ByTiePoint)
        emitattr (1, ForTiePoint)
        emitattr (2, Pnode)
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
    val fields: Array[String] = Array[String] (
        "ByTiePoint",
        "ForTiePoint",
        "Pnode"
    )
    val ByTiePoint: Fielder = parse_attribute (attribute (cls, fields(0)))
    val ForTiePoint: Fielder = parse_attribute (attribute (cls, fields(1)))
    val Pnode: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): MktMeasurement =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = MktMeasurement (
            Measurement.parse (context),
            mask (ByTiePoint (), 0),
            mask (ForTiePoint (), 1),
            mask (Pnode (), 2)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ByTiePoint", "TiePoint", false),
        Relationship ("ForTiePoint", "TiePoint", false),
        Relationship ("Pnode", "Pnode", false)
    )
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
 * @param MarketPerson [[ch.ninecode.model.MarketPerson MarketPerson]] <em>undocumented</em>
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
    MarketPerson: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, 0, null, null, List()) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
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
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
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
        emitattrs (7, MarketPerson)
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
    val fields: Array[String] = Array[String] (
        "creditFlag",
        "creditStartEffectiveDate",
        "endEffectiveDate",
        "lastModified",
        "organisationID",
        "qualificationStatus",
        "startEffectiveDate",
        "MarketPerson"
    )
    val creditFlag: Fielder = parse_attribute (attribute (cls, fields(0)))
    val creditStartEffectiveDate: Fielder = parse_element (element (cls, fields(1)))
    val endEffectiveDate: Fielder = parse_element (element (cls, fields(2)))
    val lastModified: Fielder = parse_element (element (cls, fields(3)))
    val organisationID: Fielder = parse_element (element (cls, fields(4)))
    val qualificationStatus: Fielder = parse_element (element (cls, fields(5)))
    val startEffectiveDate: Fielder = parse_element (element (cls, fields(6)))
    val MarketPerson: FielderMultiple = parse_attributes (attribute (cls, fields(7)))

    def parse (context: Context): MktOrganisation =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        def masks (field: Fields, position: Int): List[String] = { if (field._2) fields |= 1 << position; field._1 }
        val ret = MktOrganisation (
            Organisation.parse (context),
            mask (creditFlag (), 0),
            mask (creditStartEffectiveDate (), 1),
            mask (endEffectiveDate (), 2),
            mask (lastModified (), 3),
            toInteger (mask (organisationID (), 4)),
            mask (qualificationStatus (), 5),
            mask (startEffectiveDate (), 6),
            masks (MarketPerson (), 7)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("MarketPerson", "MarketPerson", true)
    )
}

/**
 * Subclass of IEC61970:Wires:PowerTransformer
 *
 * @param sup [[ch.ninecode.model.PowerTransformer PowerTransformer]] Reference to the superclass object.
 * @param EndAFlow [[ch.ninecode.model.BranchEndFlow BranchEndFlow]] <em>undocumented</em>
 * @param EndBFlow [[ch.ninecode.model.BranchEndFlow BranchEndFlow]] <em>undocumented</em>
 * @group MarketOpCommon
 * @groupname MarketOpCommon Package MarketOpCommon
 * @groupdesc MarketOpCommon This package contains the common objects shared by MarketOperations packages.
 */
case class MktPowerTransformer
(
    override val sup: PowerTransformer,
    EndAFlow: String,
    EndBFlow: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
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
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MktPowerTransformer.fields (position), value)
        emitattr (0, EndAFlow)
        emitattr (1, EndBFlow)
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
    val fields: Array[String] = Array[String] (
        "EndAFlow",
        "EndBFlow"
    )
    val EndAFlow: Fielder = parse_attribute (attribute (cls, fields(0)))
    val EndBFlow: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): MktPowerTransformer =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = MktPowerTransformer (
            PowerTransformer.parse (context),
            mask (EndAFlow (), 0),
            mask (EndBFlow (), 1)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("EndAFlow", "BranchEndFlow", false),
        Relationship ("EndBFlow", "BranchEndFlow", false)
    )
}

/**
 * Subclass of IEC61970:Core:Terminal
 *
 * @param sup [[ch.ninecode.model.Terminal Terminal]] Reference to the superclass object.
 * @param endEffectiveDate This is the end date/time of the element eligibility for the flowgate.
 * @param startEffectiveDate This is the begin date/time of the element eligibility for the flowgate.
 * @param Flowgate [[ch.ninecode.model.Flowgate Flowgate]] <em>undocumented</em>
 * @group MarketOpCommon
 * @groupname MarketOpCommon Package MarketOpCommon
 * @groupdesc MarketOpCommon This package contains the common objects shared by MarketOperations packages.
 */
case class MktTerminal
(
    override val sup: Terminal,
    endEffectiveDate: String,
    startEffectiveDate: String,
    Flowgate: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
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
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MktTerminal.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MktTerminal.fields (position), value)
        emitelem (0, endEffectiveDate)
        emitelem (1, startEffectiveDate)
        emitattr (2, Flowgate)
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
    val fields: Array[String] = Array[String] (
        "endEffectiveDate",
        "startEffectiveDate",
        "Flowgate"
    )
    val endEffectiveDate: Fielder = parse_element (element (cls, fields(0)))
    val startEffectiveDate: Fielder = parse_element (element (cls, fields(1)))
    val Flowgate: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): MktTerminal =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = MktTerminal (
            Terminal.parse (context),
            mask (endEffectiveDate (), 0),
            mask (startEffectiveDate (), 1),
            mask (Flowgate (), 2)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Flowgate", "Flowgate", false)
    )
}

/**
 * Subclass of IEC61968:Domain2:UserAttribute
 *
 * @param sup [[ch.ninecode.model.UserAttribute UserAttribute]] Reference to the superclass object.
 * @group MarketOpCommon
 * @groupname MarketOpCommon Package MarketOpCommon
 * @groupdesc MarketOpCommon This package contains the common objects shared by MarketOperations packages.
 */
case class MktUserAttribute
(
    override val sup: UserAttribute
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
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
        sup.export_fields
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

    def parse (context: Context): MktUserAttribute =
    {
        implicit val ctx: Context = context
        val ret = MktUserAttribute (
            UserAttribute.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
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