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
        sup.export_fields +
        "\t\t<cim:MarketInvoice.amount>" + amount + "</cim:MarketInvoice.amount>\n" +
        (if (null != billMediaKind) "\t\t<cim:MarketInvoice.billMediaKind rdf:resource=\"#" + billMediaKind + "\"/>\n" else "") +
        (if (null != dueDate) "\t\t<cim:MarketInvoice.dueDate>" + dueDate + "</cim:MarketInvoice.dueDate>\n" else "") +
        (if (null != kind) "\t\t<cim:MarketInvoice.kind rdf:resource=\"#" + kind + "\"/>\n" else "") +
        (if (null != mailedDate) "\t\t<cim:MarketInvoice.mailedDate>" + mailedDate + "</cim:MarketInvoice.mailedDate>\n" else "") +
        "\t\t<cim:MarketInvoice.proForma>" + proForma + "</cim:MarketInvoice.proForma>\n" +
        (if (null != referenceNumber) "\t\t<cim:MarketInvoice.referenceNumber>" + referenceNumber + "</cim:MarketInvoice.referenceNumber>\n" else "") +
        (if (null != transactionDateTime) "\t\t<cim:MarketInvoice.transactionDateTime>" + transactionDateTime + "</cim:MarketInvoice.transactionDateTime>\n" else "") +
        (if (null != transferType) "\t\t<cim:MarketInvoice.transferType>" + transferType + "</cim:MarketInvoice.transferType>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MarketInvoice rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MarketInvoice>"
    }
}

object MarketInvoice
extends
    Parseable[MarketInvoice]
{
    val amount = parse_element (element ("""MarketInvoice.amount"""))
    val billMediaKind = parse_attribute (attribute ("""MarketInvoice.billMediaKind"""))
    val dueDate = parse_element (element ("""MarketInvoice.dueDate"""))
    val kind = parse_attribute (attribute ("""MarketInvoice.kind"""))
    val mailedDate = parse_element (element ("""MarketInvoice.mailedDate"""))
    val proForma = parse_element (element ("""MarketInvoice.proForma"""))
    val referenceNumber = parse_element (element ("""MarketInvoice.referenceNumber"""))
    val transactionDateTime = parse_element (element ("""MarketInvoice.transactionDateTime"""))
    val transferType = parse_element (element ("""MarketInvoice.transferType"""))
    def parse (context: Context): MarketInvoice =
    {
        MarketInvoice(
            BasicElement.parse (context),
            toDouble (amount (context), context),
            billMediaKind (context),
            dueDate (context),
            kind (context),
            mailedDate (context),
            toBoolean (proForma (context), context),
            referenceNumber (context),
            transactionDateTime (context),
            transferType (context)
        )
    }
    val relations: List[Relationship] = List ()
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
        sup.export_fields +
        (if (null != billPeriod) "\t\t<cim:MarketInvoiceLineItem.billPeriod rdf:resource=\"#" + billPeriod + "\"/>\n" else "") +
        (if (null != glAccount) "\t\t<cim:MarketInvoiceLineItem.glAccount>" + glAccount + "</cim:MarketInvoiceLineItem.glAccount>\n" else "") +
        (if (null != glDateTime) "\t\t<cim:MarketInvoiceLineItem.glDateTime>" + glDateTime + "</cim:MarketInvoiceLineItem.glDateTime>\n" else "") +
        (if (null != kind) "\t\t<cim:MarketInvoiceLineItem.kind rdf:resource=\"#" + kind + "\"/>\n" else "") +
        "\t\t<cim:MarketInvoiceLineItem.lineAmount>" + lineAmount + "</cim:MarketInvoiceLineItem.lineAmount>\n" +
        (if (null != lineNumber) "\t\t<cim:MarketInvoiceLineItem.lineNumber>" + lineNumber + "</cim:MarketInvoiceLineItem.lineNumber>\n" else "") +
        (if (null != lineVersion) "\t\t<cim:MarketInvoiceLineItem.lineVersion>" + lineVersion + "</cim:MarketInvoiceLineItem.lineVersion>\n" else "") +
        "\t\t<cim:MarketInvoiceLineItem.netAmount>" + netAmount + "</cim:MarketInvoiceLineItem.netAmount>\n" +
        "\t\t<cim:MarketInvoiceLineItem.previousAmount>" + previousAmount + "</cim:MarketInvoiceLineItem.previousAmount>\n" +
        (if (null != ContainerMarketInvoiceLineItem) "\t\t<cim:MarketInvoiceLineItem.ContainerMarketInvoiceLineItem rdf:resource=\"#" + ContainerMarketInvoiceLineItem + "\"/>\n" else "") +
        (if (null != MarketInvoice) "\t\t<cim:MarketInvoiceLineItem.MarketInvoice rdf:resource=\"#" + MarketInvoice + "\"/>\n" else "") +
        (if (null != Settlement) Settlement.map (x => "\t\t<cim:MarketInvoiceLineItem.Settlement rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:MarketInvoiceLineItem rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MarketInvoiceLineItem>"
    }
}

object MarketInvoiceLineItem
extends
    Parseable[MarketInvoiceLineItem]
{
    val billPeriod = parse_attribute (attribute ("""MarketInvoiceLineItem.billPeriod"""))
    val glAccount = parse_element (element ("""MarketInvoiceLineItem.glAccount"""))
    val glDateTime = parse_element (element ("""MarketInvoiceLineItem.glDateTime"""))
    val kind = parse_attribute (attribute ("""MarketInvoiceLineItem.kind"""))
    val lineAmount = parse_element (element ("""MarketInvoiceLineItem.lineAmount"""))
    val lineNumber = parse_element (element ("""MarketInvoiceLineItem.lineNumber"""))
    val lineVersion = parse_element (element ("""MarketInvoiceLineItem.lineVersion"""))
    val netAmount = parse_element (element ("""MarketInvoiceLineItem.netAmount"""))
    val previousAmount = parse_element (element ("""MarketInvoiceLineItem.previousAmount"""))
    val ContainerMarketInvoiceLineItem = parse_attribute (attribute ("""MarketInvoiceLineItem.ContainerMarketInvoiceLineItem"""))
    val MarketInvoice = parse_attribute (attribute ("""MarketInvoiceLineItem.MarketInvoice"""))
    val Settlement = parse_attributes (attribute ("""MarketInvoiceLineItem.Settlement"""))
    def parse (context: Context): MarketInvoiceLineItem =
    {
        MarketInvoiceLineItem(
            BasicElement.parse (context),
            billPeriod (context),
            glAccount (context),
            glDateTime (context),
            kind (context),
            toDouble (lineAmount (context), context),
            lineNumber (context),
            lineVersion (context),
            toDouble (netAmount (context), context),
            toDouble (previousAmount (context), context),
            ContainerMarketInvoiceLineItem (context),
            MarketInvoice (context),
            Settlement (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("ContainerMarketInvoiceLineItem", "MarketInvoiceLineItem", false),
        Relationship ("MarketInvoice", "MarketInvoice", false),
        Relationship ("Settlement", "Settlement", true))
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:MarketLedger rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MarketLedger>"
    }
}

object MarketLedger
extends
    Parseable[MarketLedger]
{
    def parse (context: Context): MarketLedger =
    {
        MarketLedger(
            BasicElement.parse (context)
        )
    }
    val relations: List[Relationship] = List ()
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
        sup.export_fields +
        (if (null != accountID) "\t\t<cim:MarketLedgerEntry.accountID>" + accountID + "</cim:MarketLedgerEntry.accountID>\n" else "") +
        (if (null != accountKind) "\t\t<cim:MarketLedgerEntry.accountKind rdf:resource=\"#" + accountKind + "\"/>\n" else "") +
        "\t\t<cim:MarketLedgerEntry.amount>" + amount + "</cim:MarketLedgerEntry.amount>\n" +
        (if (null != postedDateTime) "\t\t<cim:MarketLedgerEntry.postedDateTime>" + postedDateTime + "</cim:MarketLedgerEntry.postedDateTime>\n" else "") +
        (if (null != status) "\t\t<cim:MarketLedgerEntry.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != transactionDateTime) "\t\t<cim:MarketLedgerEntry.transactionDateTime>" + transactionDateTime + "</cim:MarketLedgerEntry.transactionDateTime>\n" else "") +
        (if (null != MarketLedger) "\t\t<cim:MarketLedgerEntry.MarketLedger rdf:resource=\"#" + MarketLedger + "\"/>\n" else "") +
        (if (null != Settlement) Settlement.map (x => "\t\t<cim:MarketLedgerEntry.Settlement rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:MarketLedgerEntry rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MarketLedgerEntry>"
    }
}

object MarketLedgerEntry
extends
    Parseable[MarketLedgerEntry]
{
    val accountID = parse_element (element ("""MarketLedgerEntry.accountID"""))
    val accountKind = parse_attribute (attribute ("""MarketLedgerEntry.accountKind"""))
    val amount = parse_element (element ("""MarketLedgerEntry.amount"""))
    val postedDateTime = parse_element (element ("""MarketLedgerEntry.postedDateTime"""))
    val status = parse_attribute (attribute ("""MarketLedgerEntry.status"""))
    val transactionDateTime = parse_element (element ("""MarketLedgerEntry.transactionDateTime"""))
    val MarketLedger = parse_attribute (attribute ("""MarketLedgerEntry.MarketLedger"""))
    val Settlement = parse_attributes (attribute ("""MarketLedgerEntry.Settlement"""))
    def parse (context: Context): MarketLedgerEntry =
    {
        MarketLedgerEntry(
            BasicElement.parse (context),
            accountID (context),
            accountKind (context),
            toDouble (amount (context), context),
            postedDateTime (context),
            status (context),
            transactionDateTime (context),
            MarketLedger (context),
            Settlement (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("MarketLedger", "MarketLedger", false),
        Relationship ("Settlement", "Settlement", true))
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:MktActivityRecord rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MktActivityRecord>"
    }
}

object MktActivityRecord
extends
    Parseable[MktActivityRecord]
{
    def parse (context: Context): MktActivityRecord =
    {
        MktActivityRecord(
            ActivityRecord.parse (context)
        )
    }
    val relations: List[Relationship] = List ()
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
        sup.export_fields +
        (if (null != endEffectiveDate) "\t\t<cim:MktConnectivityNode.endEffectiveDate>" + endEffectiveDate + "</cim:MktConnectivityNode.endEffectiveDate>\n" else "") +
        (if (null != startEffectiveDate) "\t\t<cim:MktConnectivityNode.startEffectiveDate>" + startEffectiveDate + "</cim:MktConnectivityNode.startEffectiveDate>\n" else "") +
        (if (null != IndividualPnode) "\t\t<cim:MktConnectivityNode.IndividualPnode rdf:resource=\"#" + IndividualPnode + "\"/>\n" else "") +
        (if (null != RTO) "\t\t<cim:MktConnectivityNode.RTO rdf:resource=\"#" + RTO + "\"/>\n" else "") +
        (if (null != SysLoadDistribuFactor) "\t\t<cim:MktConnectivityNode.SysLoadDistribuFactor rdf:resource=\"#" + SysLoadDistribuFactor + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MktConnectivityNode rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MktConnectivityNode>"
    }
}

object MktConnectivityNode
extends
    Parseable[MktConnectivityNode]
{
    val endEffectiveDate = parse_element (element ("""MktConnectivityNode.endEffectiveDate"""))
    val startEffectiveDate = parse_element (element ("""MktConnectivityNode.startEffectiveDate"""))
    val IndividualPnode = parse_attribute (attribute ("""MktConnectivityNode.IndividualPnode"""))
    val RTO = parse_attribute (attribute ("""MktConnectivityNode.RTO"""))
    val SysLoadDistribuFactor = parse_attribute (attribute ("""MktConnectivityNode.SysLoadDistribuFactor"""))
    def parse (context: Context): MktConnectivityNode =
    {
        MktConnectivityNode(
            ConnectivityNode.parse (context),
            endEffectiveDate (context),
            startEffectiveDate (context),
            IndividualPnode (context),
            RTO (context),
            SysLoadDistribuFactor (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("IndividualPnode", "IndividualPnode", false),
        Relationship ("RTO", "RTO", false),
        Relationship ("SysLoadDistribuFactor", "SysLoadDistributionFactor", false))
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
        sup.export_fields +
        (if (null != RegisteredLoad) "\t\t<cim:MktEnergyConsumer.RegisteredLoad rdf:resource=\"#" + RegisteredLoad + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MktEnergyConsumer rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MktEnergyConsumer>"
    }
}

object MktEnergyConsumer
extends
    Parseable[MktEnergyConsumer]
{
    val RegisteredLoad = parse_attribute (attribute ("""MktEnergyConsumer.RegisteredLoad"""))
    def parse (context: Context): MktEnergyConsumer =
    {
        MktEnergyConsumer(
            EnergyConsumer.parse (context),
            RegisteredLoad (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("RegisteredLoad", "RegisteredLoad", false))
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
        sup.export_fields +
        (if (null != RegisteredGenerator) "\t\t<cim:MktGeneratingUnit.RegisteredGenerator rdf:resource=\"#" + RegisteredGenerator + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MktGeneratingUnit rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MktGeneratingUnit>"
    }
}

object MktGeneratingUnit
extends
    Parseable[MktGeneratingUnit]
{
    val RegisteredGenerator = parse_attribute (attribute ("""MktGeneratingUnit.RegisteredGenerator"""))
    def parse (context: Context): MktGeneratingUnit =
    {
        MktGeneratingUnit(
            GeneratingUnit.parse (context),
            RegisteredGenerator (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("RegisteredGenerator", "RegisteredGenerator", false))
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
        sup.export_fields +
        (if (null != TransmissionRightOfWay) "\t\t<cim:MktLine.TransmissionRightOfWay rdf:resource=\"#" + TransmissionRightOfWay + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MktLine rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MktLine>"
    }
}

object MktLine
extends
    Parseable[MktLine]
{
    val TransmissionRightOfWay = parse_attribute (attribute ("""MktLine.TransmissionRightOfWay"""))
    def parse (context: Context): MktLine =
    {
        MktLine(
            Line.parse (context),
            TransmissionRightOfWay (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("TransmissionRightOfWay", "TransmissionRightOfWay", false))
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:MktLoadArea rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MktLoadArea>"
    }
}

object MktLoadArea
extends
    Parseable[MktLoadArea]
{
    def parse (context: Context): MktLoadArea =
    {
        MktLoadArea(
            LoadArea.parse (context)
        )
    }
    val relations: List[Relationship] = List ()
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
        sup.export_fields +
        (if (null != ByTiePoint) "\t\t<cim:MktMeasurement.ByTiePoint rdf:resource=\"#" + ByTiePoint + "\"/>\n" else "") +
        (if (null != ForTiePoint) "\t\t<cim:MktMeasurement.ForTiePoint rdf:resource=\"#" + ForTiePoint + "\"/>\n" else "") +
        (if (null != Pnode) "\t\t<cim:MktMeasurement.Pnode rdf:resource=\"#" + Pnode + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MktMeasurement rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MktMeasurement>"
    }
}

object MktMeasurement
extends
    Parseable[MktMeasurement]
{
    val ByTiePoint = parse_attribute (attribute ("""MktMeasurement.ByTiePoint"""))
    val ForTiePoint = parse_attribute (attribute ("""MktMeasurement.ForTiePoint"""))
    val Pnode = parse_attribute (attribute ("""MktMeasurement.Pnode"""))
    def parse (context: Context): MktMeasurement =
    {
        MktMeasurement(
            Measurement.parse (context),
            ByTiePoint (context),
            ForTiePoint (context),
            Pnode (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("ByTiePoint", "TiePoint", false),
        Relationship ("ForTiePoint", "TiePoint", false),
        Relationship ("Pnode", "Pnode", false))
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
        sup.export_fields +
        (if (null != creditFlag) "\t\t<cim:MktOrganisation.creditFlag rdf:resource=\"#" + creditFlag + "\"/>\n" else "") +
        (if (null != creditStartEffectiveDate) "\t\t<cim:MktOrganisation.creditStartEffectiveDate>" + creditStartEffectiveDate + "</cim:MktOrganisation.creditStartEffectiveDate>\n" else "") +
        (if (null != endEffectiveDate) "\t\t<cim:MktOrganisation.endEffectiveDate>" + endEffectiveDate + "</cim:MktOrganisation.endEffectiveDate>\n" else "") +
        (if (null != lastModified) "\t\t<cim:MktOrganisation.lastModified>" + lastModified + "</cim:MktOrganisation.lastModified>\n" else "") +
        "\t\t<cim:MktOrganisation.organisationID>" + organisationID + "</cim:MktOrganisation.organisationID>\n" +
        (if (null != qualificationStatus) "\t\t<cim:MktOrganisation.qualificationStatus>" + qualificationStatus + "</cim:MktOrganisation.qualificationStatus>\n" else "") +
        (if (null != startEffectiveDate) "\t\t<cim:MktOrganisation.startEffectiveDate>" + startEffectiveDate + "</cim:MktOrganisation.startEffectiveDate>\n" else "") +
        (if (null != MarketPerson) MarketPerson.map (x => "\t\t<cim:MktOrganisation.MarketPerson rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:MktOrganisation rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MktOrganisation>"
    }
}

object MktOrganisation
extends
    Parseable[MktOrganisation]
{
    val creditFlag = parse_attribute (attribute ("""MktOrganisation.creditFlag"""))
    val creditStartEffectiveDate = parse_element (element ("""MktOrganisation.creditStartEffectiveDate"""))
    val endEffectiveDate = parse_element (element ("""MktOrganisation.endEffectiveDate"""))
    val lastModified = parse_element (element ("""MktOrganisation.lastModified"""))
    val organisationID = parse_element (element ("""MktOrganisation.organisationID"""))
    val qualificationStatus = parse_element (element ("""MktOrganisation.qualificationStatus"""))
    val startEffectiveDate = parse_element (element ("""MktOrganisation.startEffectiveDate"""))
    val MarketPerson = parse_attributes (attribute ("""MktOrganisation.MarketPerson"""))
    def parse (context: Context): MktOrganisation =
    {
        MktOrganisation(
            Organisation.parse (context),
            creditFlag (context),
            creditStartEffectiveDate (context),
            endEffectiveDate (context),
            lastModified (context),
            toInteger (organisationID (context), context),
            qualificationStatus (context),
            startEffectiveDate (context),
            MarketPerson (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("MarketPerson", "MarketPerson", true))
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
        sup.export_fields +
        (if (null != EndAFlow) "\t\t<cim:MktPowerTransformer.EndAFlow rdf:resource=\"#" + EndAFlow + "\"/>\n" else "") +
        (if (null != EndBFlow) "\t\t<cim:MktPowerTransformer.EndBFlow rdf:resource=\"#" + EndBFlow + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MktPowerTransformer rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MktPowerTransformer>"
    }
}

object MktPowerTransformer
extends
    Parseable[MktPowerTransformer]
{
    val EndAFlow = parse_attribute (attribute ("""MktPowerTransformer.EndAFlow"""))
    val EndBFlow = parse_attribute (attribute ("""MktPowerTransformer.EndBFlow"""))
    def parse (context: Context): MktPowerTransformer =
    {
        MktPowerTransformer(
            PowerTransformer.parse (context),
            EndAFlow (context),
            EndBFlow (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("EndAFlow", "BranchEndFlow", false),
        Relationship ("EndBFlow", "BranchEndFlow", false))
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
        sup.export_fields +
        (if (null != endEffectiveDate) "\t\t<cim:MktTerminal.endEffectiveDate>" + endEffectiveDate + "</cim:MktTerminal.endEffectiveDate>\n" else "") +
        (if (null != startEffectiveDate) "\t\t<cim:MktTerminal.startEffectiveDate>" + startEffectiveDate + "</cim:MktTerminal.startEffectiveDate>\n" else "") +
        (if (null != Flowgate) "\t\t<cim:MktTerminal.Flowgate rdf:resource=\"#" + Flowgate + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MktTerminal rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MktTerminal>"
    }
}

object MktTerminal
extends
    Parseable[MktTerminal]
{
    val endEffectiveDate = parse_element (element ("""MktTerminal.endEffectiveDate"""))
    val startEffectiveDate = parse_element (element ("""MktTerminal.startEffectiveDate"""))
    val Flowgate = parse_attribute (attribute ("""MktTerminal.Flowgate"""))
    def parse (context: Context): MktTerminal =
    {
        MktTerminal(
            Terminal.parse (context),
            endEffectiveDate (context),
            startEffectiveDate (context),
            Flowgate (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("Flowgate", "Flowgate", false))
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:MktUserAttribute rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MktUserAttribute>"
    }
}

object MktUserAttribute
extends
    Parseable[MktUserAttribute]
{
    def parse (context: Context): MktUserAttribute =
    {
        MktUserAttribute(
            UserAttribute.parse (context)
        )
    }
    val relations: List[Relationship] = List ()
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