package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG).
 * It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 */

/**
 * Kind of bill media.
 * @param sup Reference to the superclass object.
 * @param electronic
 * @param other
 * @param paper
 */
case class BillMediaKind
(
    override val sup: BasicElement,
    val electronic: String,
    val other: String,
    val paper: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[BillMediaKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BillMediaKind
extends
    Parseable[BillMediaKind]
{
    val sup = BasicElement.parse _
    val electronic = parse_attribute (attribute ("""BillMediaKind.electronic"""))
    val other = parse_attribute (attribute ("""BillMediaKind.other"""))
    val paper = parse_attribute (attribute ("""BillMediaKind.paper"""))
    def parse (context: Context): BillMediaKind =
    {
        BillMediaKind(
            sup (context),
            electronic (context),
            other (context),
            paper (context)
        )
    }
}

/**
 * Kind of ERP account.
 * @param sup Reference to the superclass object.
 * @param estimate
 * @param normal
 * @param reversal
 * @param statistical
 */
case class ErpAccountKind
(
    override val sup: BasicElement,
    val estimate: String,
    val normal: String,
    val reversal: String,
    val statistical: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ErpAccountKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ErpAccountKind
extends
    Parseable[ErpAccountKind]
{
    val sup = BasicElement.parse _
    val estimate = parse_attribute (attribute ("""ErpAccountKind.estimate"""))
    val normal = parse_attribute (attribute ("""ErpAccountKind.normal"""))
    val reversal = parse_attribute (attribute ("""ErpAccountKind.reversal"""))
    val statistical = parse_attribute (attribute ("""ErpAccountKind.statistical"""))
    def parse (context: Context): ErpAccountKind =
    {
        ErpAccountKind(
            sup (context),
            estimate (context),
            normal (context),
            reversal (context),
            statistical (context)
        )
    }
}

/**
 * Information that generally describes the Bill of Material Structure and its contents for a utility.
 * This is used by ERP systems to transfer Bill of Material information between two business applications.
 * @param sup Reference to the superclass object.
 * @param Design
 */
case class ErpBOM
(
    override val sup: ErpDocument,
    val Design: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def ErpDocument: ErpDocument = sup.asInstanceOf[ErpDocument]
    override def copy (): Row = { return (clone ().asInstanceOf[ErpBOM]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ErpBOM
extends
    Parseable[ErpBOM]
{
    val sup = ErpDocument.parse _
    val Design = parse_attribute (attribute ("""ErpBOM.Design"""))
    def parse (context: Context): ErpBOM =
    {
        ErpBOM(
            sup (context),
            Design (context)
        )
    }
}

/**
 * Relationship under a particular name, usually evidenced by a deposit against which withdrawals can be made.
 * Types of bank accounts include: demand, time, custodial, joint, trustee, corporate, special, and regular accounts.
 * @param sup Reference to the superclass object.
 * @param bankABA Bank ABA.
 */
case class ErpBankAccount
(
    override val sup: BankAccount,
    val bankABA: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def BankAccount: BankAccount = sup.asInstanceOf[BankAccount]
    override def copy (): Row = { return (clone ().asInstanceOf[ErpBankAccount]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ErpBankAccount
extends
    Parseable[ErpBankAccount]
{
    val sup = BankAccount.parse _
    val bankABA = parse_element (element ("""ErpBankAccount.bankABA"""))
    def parse (context: Context): ErpBankAccount =
    {
        ErpBankAccount(
            sup (context),
            bankABA (context)
        )
    }
}

/**
 * An individual item on a bill of materials.
 * @param sup Reference to the superclass object.
 * @param DesignLocation
 * @param ErpBOM
 * @param TypeAsset
 */
case class ErpBomItemData
(
    override val sup: ErpIdentifiedObject,
    val DesignLocation: String,
    val ErpBOM: String,
    val TypeAsset: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def ErpIdentifiedObject: ErpIdentifiedObject = sup.asInstanceOf[ErpIdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ErpBomItemData]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ErpBomItemData
extends
    Parseable[ErpBomItemData]
{
    val sup = ErpIdentifiedObject.parse _
    val DesignLocation = parse_attribute (attribute ("""ErpBomItemData.DesignLocation"""))
    val ErpBOM = parse_attribute (attribute ("""ErpBomItemData.ErpBOM"""))
    val TypeAsset = parse_attribute (attribute ("""ErpBomItemData.TypeAsset"""))
    def parse (context: Context): ErpBomItemData =
    {
        ErpBomItemData(
            sup (context),
            DesignLocation (context),
            ErpBOM (context),
            TypeAsset (context)
        )
    }
}

/**
 * Accounting structure of a business.
 * Each account represents a financial aspect of a business, such as its Accounts Payable, or the value of its inventory, or its office supply expenses.
 * @param sup Reference to the superclass object.
 */
case class ErpChartOfAccounts
(
    override val sup: ErpDocument
)
extends
    Element
{
    def this () = { this (null) }
    def ErpDocument: ErpDocument = sup.asInstanceOf[ErpDocument]
    override def copy (): Row = { return (clone ().asInstanceOf[ErpChartOfAccounts]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ErpChartOfAccounts
extends
    Parseable[ErpChartOfAccounts]
{
    val sup = ErpDocument.parse _
    def parse (context: Context): ErpChartOfAccounts =
    {
        ErpChartOfAccounts(
            sup (context)
        )
    }
}

/**
 * Information that describes aptitudes of a utility employee.
 * Unlike Skills that an ErpPerson must be certified to perform before undertaking certain type of assignments (to be able to perfrom a Craft), ErpCompetency has more to do with typical Human Resource (HR) matters such as schooling, training, etc.
 * @param sup Reference to the superclass object.
 */
case class ErpCompetency
(
    override val sup: ErpIdentifiedObject
)
extends
    Element
{
    def this () = { this (null) }
    def ErpIdentifiedObject: ErpIdentifiedObject = sup.asInstanceOf[ErpIdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ErpCompetency]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ErpCompetency
extends
    Parseable[ErpCompetency]
{
    val sup = ErpIdentifiedObject.parse _
    def parse (context: Context): ErpCompetency =
    {
        ErpCompetency(
            sup (context)
        )
    }
}

/**
 * Shadow class for Document, to isolate subclassing from this package.
 * If any subclass gets normative and needs inheritance, it will inherit directly from Document.
 * @param sup Reference to the superclass object.
 */
case class ErpDocument
(
    override val sup: Document
)
extends
    Element
{
    def this () = { this (null) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { return (clone ().asInstanceOf[ErpDocument]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ErpDocument
extends
    Parseable[ErpDocument]
{
    val sup = Document.parse _
    def parse (context: Context): ErpDocument =
    {
        ErpDocument(
            sup (context)
        )
    }
}

/**
 * General Utility Engineering Change Order information.
 * @param sup Reference to the superclass object.
 */
case class ErpEngChangeOrder
(
    override val sup: ErpDocument
)
extends
    Element
{
    def this () = { this (null) }
    def ErpDocument: ErpDocument = sup.asInstanceOf[ErpDocument]
    override def copy (): Row = { return (clone ().asInstanceOf[ErpEngChangeOrder]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ErpEngChangeOrder
extends
    Parseable[ErpEngChangeOrder]
{
    val sup = ErpDocument.parse _
    def parse (context: Context): ErpEngChangeOrder =
    {
        ErpEngChangeOrder(
            sup (context)
        )
    }
}

/**
 * Shadow class for IdentifiedObject, to isolate subclassing from this package.
 * If any subclass gets normative and needs inheritance, it will inherit directly from IdentifiedObject.
 * @param sup Reference to the superclass object.
 */
case class ErpIdentifiedObject
(
    override val sup: IdentifiedObject
)
extends
    Element
{
    def this () = { this (null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ErpIdentifiedObject]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ErpIdentifiedObject
extends
    Parseable[ErpIdentifiedObject]
{
    val sup = IdentifiedObject.parse _
    def parse (context: Context): ErpIdentifiedObject =
    {
        ErpIdentifiedObject(
            sup (context)
        )
    }
}

/**
 * Utility inventory-related information about an item or part (and not for description of the item and its attributes).
 * It is used by ERP applications to enable the synchronization of Inventory data that exists on separate Item Master databases. This data is not the master data that describes the attributes of the item such as dimensions, weight, or unit of measure - it describes the item as it exists at a specific location.
 * @param sup Reference to the superclass object.
 * @param status
 * @param Asset
 */
case class ErpInventory
(
    override val sup: ErpIdentifiedObject,
    val status: String,
    val Asset: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def ErpIdentifiedObject: ErpIdentifiedObject = sup.asInstanceOf[ErpIdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ErpInventory]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ErpInventory
extends
    Parseable[ErpInventory]
{
    val sup = ErpIdentifiedObject.parse _
    val status = parse_attribute (attribute ("""ErpInventory.status"""))
    val Asset = parse_attribute (attribute ("""ErpInventory.Asset"""))
    def parse (context: Context): ErpInventory =
    {
        ErpInventory(
            sup (context),
            status (context),
            Asset (context)
        )
    }
}

/**
 * This is related to Inventory physical counts organized by AssetModel.
 * Note that a count of a type of asset can be accomplished by the association inherited by AssetModel (from Document) to Asset.
 * @param sup Reference to the superclass object.
 * @param status
 * @param AssetModel
 */
case class ErpInventoryCount
(
    override val sup: ErpIdentifiedObject,
    val status: String,
    val AssetModel: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def ErpIdentifiedObject: ErpIdentifiedObject = sup.asInstanceOf[ErpIdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ErpInventoryCount]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ErpInventoryCount
extends
    Parseable[ErpInventoryCount]
{
    val sup = ErpIdentifiedObject.parse _
    val status = parse_attribute (attribute ("""ErpInventoryCount.status"""))
    val AssetModel = parse_attribute (attribute ("""ErpInventoryCount.AssetModel"""))
    def parse (context: Context): ErpInventoryCount =
    {
        ErpInventoryCount(
            sup (context),
            status (context),
            AssetModel (context)
        )
    }
}

/**
 * A roll up of invoice line items.
 * The whole invoice has a due date and amount to be paid, with information such as customer, banks etc. being obtained through associations. The invoice roll up is based on individual line items that each contain amounts and descriptions for specific services or products.
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
 * @param CustomerAccount
 */
case class ErpInvoice
(
    override val sup: ErpDocument,
    val amount: Double,
    val billMediaKind: String,
    val dueDate: String,
    val kind: String,
    val mailedDate: String,
    val proForma: Boolean,
    val referenceNumber: String,
    val transactionDateTime: String,
    val transferType: String,
    val CustomerAccount: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null, null, null, false, null, null, null, null) }
    def ErpDocument: ErpDocument = sup.asInstanceOf[ErpDocument]
    override def copy (): Row = { return (clone ().asInstanceOf[ErpInvoice]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ErpInvoice
extends
    Parseable[ErpInvoice]
{
    val sup = ErpDocument.parse _
    val amount = parse_element (element ("""ErpInvoice.amount"""))
    val billMediaKind = parse_attribute (attribute ("""ErpInvoice.billMediaKind"""))
    val dueDate = parse_element (element ("""ErpInvoice.dueDate"""))
    val kind = parse_attribute (attribute ("""ErpInvoice.kind"""))
    val mailedDate = parse_element (element ("""ErpInvoice.mailedDate"""))
    val proForma = parse_element (element ("""ErpInvoice.proForma"""))
    val referenceNumber = parse_element (element ("""ErpInvoice.referenceNumber"""))
    val transactionDateTime = parse_element (element ("""ErpInvoice.transactionDateTime"""))
    val transferType = parse_element (element ("""ErpInvoice.transferType"""))
    val CustomerAccount = parse_attribute (attribute ("""ErpInvoice.CustomerAccount"""))
    def parse (context: Context): ErpInvoice =
    {
        ErpInvoice(
            sup (context),
            toDouble (amount (context), context),
            billMediaKind (context),
            dueDate (context),
            kind (context),
            mailedDate (context),
            toBoolean (proForma (context), context),
            referenceNumber (context),
            transactionDateTime (context),
            transferType (context),
            CustomerAccount (context)
        )
    }
}

/**
 * Kind of ERP invoice.
 * @param sup Reference to the superclass object.
 * @param purchase
 * @param sale
 */
case class ErpInvoiceKind
(
    override val sup: BasicElement,
    val purchase: String,
    val sale: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ErpInvoiceKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ErpInvoiceKind
extends
    Parseable[ErpInvoiceKind]
{
    val sup = BasicElement.parse _
    val purchase = parse_attribute (attribute ("""ErpInvoiceKind.purchase"""))
    val sale = parse_attribute (attribute ("""ErpInvoiceKind.sale"""))
    def parse (context: Context): ErpInvoiceKind =
    {
        ErpInvoiceKind(
            sup (context),
            purchase (context),
            sale (context)
        )
    }
}

/**
 * An individual line item on an invoice.
 * @param sup Reference to the superclass object.
 * @param billPeriod Bill period for the line item.
 * @param glAccount General Ledger account code, must be a valid combination.
 * @param glDateTime Date and time line item will be posted to the General Ledger.
 * @param kind Kind of line item.
 * @param lineAmount Amount due for this line item.
 * @param lineNumber Line item number on invoice statement.
 * @param lineVersion Version number of the bill run.
 * @param netAmount Net line item charge amount.
 * @param previousAmount Previous line item charge amount.
 * @param ContainerErpInvoiceLineItem
 * @param ErpInvoice
 * @param ErpPayableLineItem
 * @param ErpPayments
 * @param ErpQuoteLineItem
 * @param ErpRecDelvLineItem
 * @param ErpRecLineItem
 * @param UserAttributes
 */
case class ErpInvoiceLineItem
(
    override val sup: ErpDocument,
    val billPeriod: String,
    val glAccount: String,
    val glDateTime: String,
    val kind: String,
    val lineAmount: Double,
    val lineNumber: String,
    val lineVersion: String,
    val netAmount: Double,
    val previousAmount: Double,
    val ContainerErpInvoiceLineItem: String,
    val ErpInvoice: String,
    val ErpPayableLineItem: String,
    val ErpPayments: List[String],
    val ErpQuoteLineItem: String,
    val ErpRecDelvLineItem: String,
    val ErpRecLineItem: String,
    val UserAttributes: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, 0.0, null, null, 0.0, 0.0, null, null, null, List(), null, null, null, List()) }
    def ErpDocument: ErpDocument = sup.asInstanceOf[ErpDocument]
    override def copy (): Row = { return (clone ().asInstanceOf[ErpInvoiceLineItem]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ErpInvoiceLineItem
extends
    Parseable[ErpInvoiceLineItem]
{
    val sup = ErpDocument.parse _
    val billPeriod = parse_attribute (attribute ("""ErpInvoiceLineItem.billPeriod"""))
    val glAccount = parse_element (element ("""ErpInvoiceLineItem.glAccount"""))
    val glDateTime = parse_element (element ("""ErpInvoiceLineItem.glDateTime"""))
    val kind = parse_attribute (attribute ("""ErpInvoiceLineItem.kind"""))
    val lineAmount = parse_element (element ("""ErpInvoiceLineItem.lineAmount"""))
    val lineNumber = parse_element (element ("""ErpInvoiceLineItem.lineNumber"""))
    val lineVersion = parse_element (element ("""ErpInvoiceLineItem.lineVersion"""))
    val netAmount = parse_element (element ("""ErpInvoiceLineItem.netAmount"""))
    val previousAmount = parse_element (element ("""ErpInvoiceLineItem.previousAmount"""))
    val ContainerErpInvoiceLineItem = parse_attribute (attribute ("""ErpInvoiceLineItem.ContainerErpInvoiceLineItem"""))
    val ErpInvoice = parse_attribute (attribute ("""ErpInvoiceLineItem.ErpInvoice"""))
    val ErpPayableLineItem = parse_attribute (attribute ("""ErpInvoiceLineItem.ErpPayableLineItem"""))
    val ErpPayments = parse_attributes (attribute ("""ErpInvoiceLineItem.ErpPayments"""))
    val ErpQuoteLineItem = parse_attribute (attribute ("""ErpInvoiceLineItem.ErpQuoteLineItem"""))
    val ErpRecDelvLineItem = parse_attribute (attribute ("""ErpInvoiceLineItem.ErpRecDelvLineItem"""))
    val ErpRecLineItem = parse_attribute (attribute ("""ErpInvoiceLineItem.ErpRecLineItem"""))
    val UserAttributes = parse_attributes (attribute ("""ErpInvoiceLineItem.UserAttributes"""))
    def parse (context: Context): ErpInvoiceLineItem =
    {
        ErpInvoiceLineItem(
            sup (context),
            billPeriod (context),
            glAccount (context),
            glDateTime (context),
            kind (context),
            toDouble (lineAmount (context), context),
            lineNumber (context),
            lineVersion (context),
            toDouble (netAmount (context), context),
            toDouble (previousAmount (context), context),
            ContainerErpInvoiceLineItem (context),
            ErpInvoice (context),
            ErpPayableLineItem (context),
            ErpPayments (context),
            ErpQuoteLineItem (context),
            ErpRecDelvLineItem (context),
            ErpRecLineItem (context),
            UserAttributes (context)
        )
    }
}

/**
 * Kind of invoice line item.
 * @param sup Reference to the superclass object.
 * @param initial
 * @param other
 * @param recalculation
 */
case class ErpInvoiceLineItemKind
(
    override val sup: BasicElement,
    val initial: String,
    val other: String,
    val recalculation: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ErpInvoiceLineItemKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ErpInvoiceLineItemKind
extends
    Parseable[ErpInvoiceLineItemKind]
{
    val sup = BasicElement.parse _
    val initial = parse_attribute (attribute ("""ErpInvoiceLineItemKind.initial"""))
    val other = parse_attribute (attribute ("""ErpInvoiceLineItemKind.other"""))
    val recalculation = parse_attribute (attribute ("""ErpInvoiceLineItemKind.recalculation"""))
    def parse (context: Context): ErpInvoiceLineItemKind =
    {
        ErpInvoiceLineItemKind(
            sup (context),
            initial (context),
            other (context),
            recalculation (context)
        )
    }
}

/**
 * Can be used to request an application to process an issue or request information about an issue.
 * @param sup Reference to the superclass object.
 * @param status
 * @param TypeAsset
 * @param TypeMaterial
 */
case class ErpIssueInventory
(
    override val sup: ErpIdentifiedObject,
    val status: String,
    val TypeAsset: String,
    val TypeMaterial: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def ErpIdentifiedObject: ErpIdentifiedObject = sup.asInstanceOf[ErpIdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ErpIssueInventory]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ErpIssueInventory
extends
    Parseable[ErpIssueInventory]
{
    val sup = ErpIdentifiedObject.parse _
    val status = parse_attribute (attribute ("""ErpIssueInventory.status"""))
    val TypeAsset = parse_attribute (attribute ("""ErpIssueInventory.TypeAsset"""))
    val TypeMaterial = parse_attribute (attribute ("""ErpIssueInventory.TypeMaterial"""))
    def parse (context: Context): ErpIssueInventory =
    {
        ErpIssueInventory(
            sup (context),
            status (context),
            TypeAsset (context),
            TypeMaterial (context)
        )
    }
}

/**
 * Any unique purchased part for manufactured product tracked by ERP systems for a utility.
 * Item, as used by the OAG, refers to the basic information about an item, including its attributes, cost, and locations. It does not include item quantities. Compare to the Inventory, which includes all quantities and other location-specific information.
 * @param sup Reference to the superclass object.
 * @param status
 * @param Asset
 */
case class ErpItemMaster
(
    override val sup: ErpIdentifiedObject,
    val status: String,
    val Asset: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def ErpIdentifiedObject: ErpIdentifiedObject = sup.asInstanceOf[ErpIdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ErpItemMaster]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ErpItemMaster
extends
    Parseable[ErpItemMaster]
{
    val sup = ErpIdentifiedObject.parse _
    val status = parse_attribute (attribute ("""ErpItemMaster.status"""))
    val Asset = parse_attribute (attribute ("""ErpItemMaster.Asset"""))
    def parse (context: Context): ErpItemMaster =
    {
        ErpItemMaster(
            sup (context),
            status (context),
            Asset (context)
        )
    }
}

/**
 * Book for recording accounting transactions as they occur.
 * Transactions and adjustments are first recorded in a journal, which is like a diary of instructions, advising which account to be charged and by how much.
 * @param sup Reference to the superclass object.
 */
case class ErpJournal
(
    override val sup: ErpDocument
)
extends
    Element
{
    def this () = { this (null) }
    def ErpDocument: ErpDocument = sup.asInstanceOf[ErpDocument]
    override def copy (): Row = { return (clone ().asInstanceOf[ErpJournal]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ErpJournal
extends
    Parseable[ErpJournal]
{
    val sup = ErpDocument.parse _
    def parse (context: Context): ErpJournal =
    {
        ErpJournal(
            sup (context)
        )
    }
}

/**
 * Details of an individual entry in a journal, which is to be posted to a ledger on the posting date.
 * @param sup Reference to the superclass object.
 * @param accountID Account identifier for this entry.
 * @param amount The amount of the debit or credit for this account.
 * @param postingDateTime Date and time this entry is to be posted to the ledger.
 * @param sourceID The identifer of the source for this entry.
 * @param status
 * @param transactionDateTime Date and time journal entry was recorded.
 * @param ErpInvoiceLineItem
 * @param ErpJournal
 * @param ErpLedgerEntry
 */
case class ErpJournalEntry
(
    override val sup: ErpIdentifiedObject,
    val accountID: String,
    val amount: Double,
    val postingDateTime: String,
    val sourceID: String,
    val status: String,
    val transactionDateTime: String,
    val ErpInvoiceLineItem: String,
    val ErpJournal: String,
    val ErpLedgerEntry: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, null, null, null, null, null, null, null) }
    def ErpIdentifiedObject: ErpIdentifiedObject = sup.asInstanceOf[ErpIdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ErpJournalEntry]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ErpJournalEntry
extends
    Parseable[ErpJournalEntry]
{
    val sup = ErpIdentifiedObject.parse _
    val accountID = parse_element (element ("""ErpJournalEntry.accountID"""))
    val amount = parse_element (element ("""ErpJournalEntry.amount"""))
    val postingDateTime = parse_element (element ("""ErpJournalEntry.postingDateTime"""))
    val sourceID = parse_element (element ("""ErpJournalEntry.sourceID"""))
    val status = parse_attribute (attribute ("""ErpJournalEntry.status"""))
    val transactionDateTime = parse_element (element ("""ErpJournalEntry.transactionDateTime"""))
    val ErpInvoiceLineItem = parse_attribute (attribute ("""ErpJournalEntry.ErpInvoiceLineItem"""))
    val ErpJournal = parse_attribute (attribute ("""ErpJournalEntry.ErpJournal"""))
    val ErpLedgerEntry = parse_attribute (attribute ("""ErpJournalEntry.ErpLedgerEntry"""))
    def parse (context: Context): ErpJournalEntry =
    {
        ErpJournalEntry(
            sup (context),
            accountID (context),
            toDouble (amount (context), context),
            postingDateTime (context),
            sourceID (context),
            status (context),
            transactionDateTime (context),
            ErpInvoiceLineItem (context),
            ErpJournal (context),
            ErpLedgerEntry (context)
        )
    }
}

/**
 * Individual entry of a given Ledger Budget, typically containing information such as amount, accounting date, accounting period, and is associated with the applicable general ledger account.
 * @param sup Reference to the superclass object.
 * @param status
 * @param ErpLedBudLineItem_attr
 * @param ErpLedgerBudget
 */
case class ErpLedBudLineItem
(
    override val sup: ErpIdentifiedObject,
    val status: String,
    val ErpLedBudLineItem_attr: String,
    val ErpLedgerBudget: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def ErpIdentifiedObject: ErpIdentifiedObject = sup.asInstanceOf[ErpIdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ErpLedBudLineItem]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ErpLedBudLineItem
extends
    Parseable[ErpLedBudLineItem]
{
    val sup = ErpIdentifiedObject.parse _
    val status = parse_attribute (attribute ("""ErpLedBudLineItem.status"""))
    val ErpLedBudLineItem_attr = parse_attribute (attribute ("""ErpLedBudLineItem.ErpLedBudLineItem"""))
    val ErpLedgerBudget = parse_attribute (attribute ("""ErpLedBudLineItem.ErpLedgerBudget"""))
    def parse (context: Context): ErpLedBudLineItem =
    {
        ErpLedBudLineItem(
            sup (context),
            status (context),
            ErpLedBudLineItem_attr (context),
            ErpLedgerBudget (context)
        )
    }
}

/**
 * In accounting transactions, a ledger is a book containing accounts to which debits and credits are posted from journals, where transactions are initially recorded.
 * Journal entries are periodically posted to the ledger. Ledger Actual represents actual amounts by account within ledger within company or business area. Actual amounts may be generated in a source application and then loaded to a specific ledger within the enterprise general ledger or budget application.
 * @param sup Reference to the superclass object.
 */
case class ErpLedger
(
    override val sup: ErpDocument
)
extends
    Element
{
    def this () = { this (null) }
    def ErpDocument: ErpDocument = sup.asInstanceOf[ErpDocument]
    override def copy (): Row = { return (clone ().asInstanceOf[ErpLedger]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ErpLedger
extends
    Parseable[ErpLedger]
{
    val sup = ErpDocument.parse _
    def parse (context: Context): ErpLedger =
    {
        ErpLedger(
            sup (context)
        )
    }
}

/**
 * Information for utility Ledger Budgets.
 * They support the transfer budget amounts between all possible source applications throughout an enterprise and a general ledger or budget application.
 * @param sup Reference to the superclass object.
 */
case class ErpLedgerBudget
(
    override val sup: ErpDocument
)
extends
    Element
{
    def this () = { this (null) }
    def ErpDocument: ErpDocument = sup.asInstanceOf[ErpDocument]
    override def copy (): Row = { return (clone ().asInstanceOf[ErpLedgerBudget]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ErpLedgerBudget
extends
    Parseable[ErpLedgerBudget]
{
    val sup = ErpDocument.parse _
    def parse (context: Context): ErpLedgerBudget =
    {
        ErpLedgerBudget(
            sup (context)
        )
    }
}

/**
 * Details of an individual entry in a ledger, which was posted from a journal on the posted date.
 * @param sup Reference to the superclass object.
 * @param accountID Account identifier for this entry.
 * @param accountKind Kind of account for this entry.
 * @param amount The amount of the debit or credit for this account.
 * @param postedDateTime Date and time this entry was posted to the ledger.
 * @param status
 * @param transactionDateTime Date and time journal entry was recorded.
 * @param ErpJounalEntry
 * @param ErpLedger
 * @param ErpLedgerEntry_attr
 * @param UserAttributes
 */
case class ErpLedgerEntry
(
    override val sup: ErpIdentifiedObject,
    val accountID: String,
    val accountKind: String,
    val amount: Double,
    val postedDateTime: String,
    val status: String,
    val transactionDateTime: String,
    val ErpJounalEntry: String,
    val ErpLedger: String,
    val ErpLedgerEntry_attr: String,
    val UserAttributes: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, 0.0, null, null, null, null, null, null, List()) }
    def ErpIdentifiedObject: ErpIdentifiedObject = sup.asInstanceOf[ErpIdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ErpLedgerEntry]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ErpLedgerEntry
extends
    Parseable[ErpLedgerEntry]
{
    val sup = ErpIdentifiedObject.parse _
    val accountID = parse_element (element ("""ErpLedgerEntry.accountID"""))
    val accountKind = parse_attribute (attribute ("""ErpLedgerEntry.accountKind"""))
    val amount = parse_element (element ("""ErpLedgerEntry.amount"""))
    val postedDateTime = parse_element (element ("""ErpLedgerEntry.postedDateTime"""))
    val status = parse_attribute (attribute ("""ErpLedgerEntry.status"""))
    val transactionDateTime = parse_element (element ("""ErpLedgerEntry.transactionDateTime"""))
    val ErpJounalEntry = parse_attribute (attribute ("""ErpLedgerEntry.ErpJounalEntry"""))
    val ErpLedger = parse_attribute (attribute ("""ErpLedgerEntry.ErpLedger"""))
    val ErpLedgerEntry_attr = parse_attribute (attribute ("""ErpLedgerEntry.ErpLedgerEntry"""))
    val UserAttributes = parse_attributes (attribute ("""ErpLedgerEntry.UserAttributes"""))
    def parse (context: Context): ErpLedgerEntry =
    {
        ErpLedgerEntry(
            sup (context),
            accountID (context),
            accountKind (context),
            toDouble (amount (context), context),
            postedDateTime (context),
            status (context),
            transactionDateTime (context),
            ErpJounalEntry (context),
            ErpLedger (context),
            ErpLedgerEntry_attr (context),
            UserAttributes (context)
        )
    }
}

/**
 * Of an ErpPurchaseOrder, this is an individually ordered item or product along with the quantity, price and other descriptive information.
 * @param sup Reference to the superclass object.
 * @param AssetModelCatalogueItem
 * @param ErpPurchaseOrder
 * @param ErpRecDelLineItem
 * @param ErpReqLineItem
 */
case class ErpPOLineItem
(
    override val sup: ErpDocument,
    val AssetModelCatalogueItem: String,
    val ErpPurchaseOrder: String,
    val ErpRecDelLineItem: String,
    val ErpReqLineItem: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def ErpDocument: ErpDocument = sup.asInstanceOf[ErpDocument]
    override def copy (): Row = { return (clone ().asInstanceOf[ErpPOLineItem]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ErpPOLineItem
extends
    Parseable[ErpPOLineItem]
{
    val sup = ErpDocument.parse _
    val AssetModelCatalogueItem = parse_attribute (attribute ("""ErpPOLineItem.AssetModelCatalogueItem"""))
    val ErpPurchaseOrder = parse_attribute (attribute ("""ErpPOLineItem.ErpPurchaseOrder"""))
    val ErpRecDelLineItem = parse_attribute (attribute ("""ErpPOLineItem.ErpRecDelLineItem"""))
    val ErpReqLineItem = parse_attribute (attribute ("""ErpPOLineItem.ErpReqLineItem"""))
    def parse (context: Context): ErpPOLineItem =
    {
        ErpPOLineItem(
            sup (context),
            AssetModelCatalogueItem (context),
            ErpPurchaseOrder (context),
            ErpRecDelLineItem (context),
            ErpReqLineItem (context)
        )
    }
}

/**
 * A transaction that represents an invoice from a supplier.
 * A payable (or voucher) is an open item, approved and ready for payment, in the Accounts Payable ledger.
 * @param sup Reference to the superclass object.
 */
case class ErpPayable
(
    override val sup: ErpDocument
)
extends
    Element
{
    def this () = { this (null) }
    def ErpDocument: ErpDocument = sup.asInstanceOf[ErpDocument]
    override def copy (): Row = { return (clone ().asInstanceOf[ErpPayable]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ErpPayable
extends
    Parseable[ErpPayable]
{
    val sup = ErpDocument.parse _
    def parse (context: Context): ErpPayable =
    {
        ErpPayable(
            sup (context)
        )
    }
}

/**
 * Of an ErpPayable, a line item references an ErpInvoiceLineitem or other source such as credit memos.
 * @param sup Reference to the superclass object.
 * @param status
 * @param ErpInvoiceLineItem
 * @param ErpJournalEntries
 * @param ErpPayable
 * @param ErpPayments
 */
case class ErpPayableLineItem
(
    override val sup: ErpIdentifiedObject,
    val status: String,
    val ErpInvoiceLineItem: String,
    val ErpJournalEntries: List[String],
    val ErpPayable: String,
    val ErpPayments: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, List(), null, List()) }
    def ErpIdentifiedObject: ErpIdentifiedObject = sup.asInstanceOf[ErpIdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ErpPayableLineItem]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ErpPayableLineItem
extends
    Parseable[ErpPayableLineItem]
{
    val sup = ErpIdentifiedObject.parse _
    val status = parse_attribute (attribute ("""ErpPayableLineItem.status"""))
    val ErpInvoiceLineItem = parse_attribute (attribute ("""ErpPayableLineItem.ErpInvoiceLineItem"""))
    val ErpJournalEntries = parse_attributes (attribute ("""ErpPayableLineItem.ErpJournalEntries"""))
    val ErpPayable = parse_attribute (attribute ("""ErpPayableLineItem.ErpPayable"""))
    val ErpPayments = parse_attributes (attribute ("""ErpPayableLineItem.ErpPayments"""))
    def parse (context: Context): ErpPayableLineItem =
    {
        ErpPayableLineItem(
            sup (context),
            status (context),
            ErpInvoiceLineItem (context),
            ErpJournalEntries (context),
            ErpPayable (context),
            ErpPayments (context)
        )
    }
}

/**
 * Payment infromation and status for any individual line item of an ErpInvoice (e.g., when payment is from a customer).
 * ErpPayable is also updated when payment is to a supplier and ErpReceivable is updated when payment is from a customer. Multiple payments can be made against a single line item and an individual payment can apply to more that one line item.
 * @param sup Reference to the superclass object.
 * @param termsPayment Payment terms (e.g., net 30).
 */
case class ErpPayment
(
    override val sup: ErpDocument,
    val termsPayment: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def ErpDocument: ErpDocument = sup.asInstanceOf[ErpDocument]
    override def copy (): Row = { return (clone ().asInstanceOf[ErpPayment]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ErpPayment
extends
    Parseable[ErpPayment]
{
    val sup = ErpDocument.parse _
    val termsPayment = parse_element (element ("""ErpPayment.termsPayment"""))
    def parse (context: Context): ErpPayment =
    {
        ErpPayment(
            sup (context),
            termsPayment (context)
        )
    }
}

/**
 * Information that applies to the basic data about a utility person, used by ERP applications to transfer Personnel data for a worker.
 * @param sup Reference to the superclass object.
 * @param status
 */
case class ErpPersonnel
(
    override val sup: ErpIdentifiedObject,
    val status: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def ErpIdentifiedObject: ErpIdentifiedObject = sup.asInstanceOf[ErpIdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ErpPersonnel]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ErpPersonnel
extends
    Parseable[ErpPersonnel]
{
    val sup = ErpIdentifiedObject.parse _
    val status = parse_attribute (attribute ("""ErpPersonnel.status"""))
    def parse (context: Context): ErpPersonnel =
    {
        ErpPersonnel(
            sup (context),
            status (context)
        )
    }
}

/**
 * Utility Project Accounting information, used by ERP applications to enable all relevant sub-systems that submit single sided transactions to transfer information with a Project Accounting Application.
 * This would include, but not necessarily be limited to: Accounts Payable, Accounts Receivable, Budget, Order Management, Purchasing, Time and Labor, Travel and Expense.
 * @param sup Reference to the superclass object.
 */
case class ErpProjectAccounting
(
    override val sup: ErpDocument
)
extends
    Element
{
    def this () = { this (null) }
    def ErpDocument: ErpDocument = sup.asInstanceOf[ErpDocument]
    override def copy (): Row = { return (clone ().asInstanceOf[ErpProjectAccounting]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ErpProjectAccounting
extends
    Parseable[ErpProjectAccounting]
{
    val sup = ErpDocument.parse _
    def parse (context: Context): ErpProjectAccounting =
    {
        ErpProjectAccounting(
            sup (context)
        )
    }
}

/**
 * A document that communicates an order to purchase goods from a buyer to a supplier.
 * The PurchaseOrder carries information to and from the buyer and supplier. It is a legally binding document once both Parties agree to the contents and the specified terms and conditions of the order.
 * @param sup Reference to the superclass object.
 */
case class ErpPurchaseOrder
(
    override val sup: ErpDocument
)
extends
    Element
{
    def this () = { this (null) }
    def ErpDocument: ErpDocument = sup.asInstanceOf[ErpDocument]
    override def copy (): Row = { return (clone ().asInstanceOf[ErpPurchaseOrder]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ErpPurchaseOrder
extends
    Parseable[ErpPurchaseOrder]
{
    val sup = ErpDocument.parse _
    def parse (context: Context): ErpPurchaseOrder =
    {
        ErpPurchaseOrder(
            sup (context)
        )
    }
}

/**
 * Document describing the prices of goods or services provided by a supplier.
 * It includes the terms of the purchase, delivery proposals, identification of goods or services ordered, as well as their quantities.
 * @param sup Reference to the superclass object.
 */
case class ErpQuote
(
    override val sup: ErpDocument
)
extends
    Element
{
    def this () = { this (null) }
    def ErpDocument: ErpDocument = sup.asInstanceOf[ErpDocument]
    override def copy (): Row = { return (clone ().asInstanceOf[ErpQuote]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ErpQuote
extends
    Parseable[ErpQuote]
{
    val sup = ErpDocument.parse _
    def parse (context: Context): ErpQuote =
    {
        ErpQuote(
            sup (context)
        )
    }
}

/**
 * Of an ErpQuote, the item or product quoted along with quantity, price and other descriptive information.
 * @param sup Reference to the superclass object.
 * @param status
 * @param AssetModelCatalogueItem
 * @param Design
 * @param ErpInvoiceLineItem Some utilities provide quotes to customer for services, where the customer accepts the quote by making a payment.
 *        An invoice is required for this to occur.
 * @param ErpQuote
 * @param ErpReqLineItem
 */
case class ErpQuoteLineItem
(
    override val sup: ErpIdentifiedObject,
    val status: String,
    val AssetModelCatalogueItem: String,
    val Design: String,
    val ErpInvoiceLineItem: String,
    val ErpQuote: String,
    val ErpReqLineItem: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null) }
    def ErpIdentifiedObject: ErpIdentifiedObject = sup.asInstanceOf[ErpIdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ErpQuoteLineItem]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ErpQuoteLineItem
extends
    Parseable[ErpQuoteLineItem]
{
    val sup = ErpIdentifiedObject.parse _
    val status = parse_attribute (attribute ("""ErpQuoteLineItem.status"""))
    val AssetModelCatalogueItem = parse_attribute (attribute ("""ErpQuoteLineItem.AssetModelCatalogueItem"""))
    val Design = parse_attribute (attribute ("""ErpQuoteLineItem.Design"""))
    val ErpInvoiceLineItem = parse_attribute (attribute ("""ErpQuoteLineItem.ErpInvoiceLineItem"""))
    val ErpQuote = parse_attribute (attribute ("""ErpQuoteLineItem.ErpQuote"""))
    val ErpReqLineItem = parse_attribute (attribute ("""ErpQuoteLineItem.ErpReqLineItem"""))
    def parse (context: Context): ErpQuoteLineItem =
    {
        ErpQuoteLineItem(
            sup (context),
            status (context),
            AssetModelCatalogueItem (context),
            Design (context),
            ErpInvoiceLineItem (context),
            ErpQuote (context),
            ErpReqLineItem (context)
        )
    }
}

/**
 * Of an ErpReceiveDelivery, this is an individually received good or service by the Organisation receiving goods or services.
 * It may be used to indicate receipt of goods in conjunction with a purchase order line item.
 * @param sup Reference to the superclass object.
 * @param status
 * @param ErpInvoiceLineItem
 * @param ErpPOLineItem
 * @param ErpReceiveDelivery
 */
case class ErpRecDelvLineItem
(
    override val sup: ErpIdentifiedObject,
    val status: String,
    val ErpInvoiceLineItem: String,
    val ErpPOLineItem: String,
    val ErpReceiveDelivery: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def ErpIdentifiedObject: ErpIdentifiedObject = sup.asInstanceOf[ErpIdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ErpRecDelvLineItem]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ErpRecDelvLineItem
extends
    Parseable[ErpRecDelvLineItem]
{
    val sup = ErpIdentifiedObject.parse _
    val status = parse_attribute (attribute ("""ErpRecDelvLineItem.status"""))
    val ErpInvoiceLineItem = parse_attribute (attribute ("""ErpRecDelvLineItem.ErpInvoiceLineItem"""))
    val ErpPOLineItem = parse_attribute (attribute ("""ErpRecDelvLineItem.ErpPOLineItem"""))
    val ErpReceiveDelivery = parse_attribute (attribute ("""ErpRecDelvLineItem.ErpReceiveDelivery"""))
    def parse (context: Context): ErpRecDelvLineItem =
    {
        ErpRecDelvLineItem(
            sup (context),
            status (context),
            ErpInvoiceLineItem (context),
            ErpPOLineItem (context),
            ErpReceiveDelivery (context)
        )
    }
}

/**
 * Individual entry of an ErpReceivable, it is a particular transaction representing an invoice, credit memo or debit memo to a customer.
 * @param sup Reference to the superclass object.
 * @param status
 * @param ErpInvoiceLineItem
 * @param ErpJournalEntries
 * @param ErpPayments
 * @param ErpReceivable
 */
case class ErpRecLineItem
(
    override val sup: ErpIdentifiedObject,
    val status: String,
    val ErpInvoiceLineItem: String,
    val ErpJournalEntries: List[String],
    val ErpPayments: List[String],
    val ErpReceivable: String
)
extends
    Element
{
    def this () = { this (null, null, null, List(), List(), null) }
    def ErpIdentifiedObject: ErpIdentifiedObject = sup.asInstanceOf[ErpIdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ErpRecLineItem]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ErpRecLineItem
extends
    Parseable[ErpRecLineItem]
{
    val sup = ErpIdentifiedObject.parse _
    val status = parse_attribute (attribute ("""ErpRecLineItem.status"""))
    val ErpInvoiceLineItem = parse_attribute (attribute ("""ErpRecLineItem.ErpInvoiceLineItem"""))
    val ErpJournalEntries = parse_attributes (attribute ("""ErpRecLineItem.ErpJournalEntries"""))
    val ErpPayments = parse_attributes (attribute ("""ErpRecLineItem.ErpPayments"""))
    val ErpReceivable = parse_attribute (attribute ("""ErpRecLineItem.ErpReceivable"""))
    def parse (context: Context): ErpRecLineItem =
    {
        ErpRecLineItem(
            sup (context),
            status (context),
            ErpInvoiceLineItem (context),
            ErpJournalEntries (context),
            ErpPayments (context),
            ErpReceivable (context)
        )
    }
}

/**
 * Transaction representing an invoice, credit memo or debit memo to a customer.
 * It is an open (unpaid) item in the Accounts Receivable ledger.
 * @param sup Reference to the superclass object.
 */
case class ErpReceivable
(
    override val sup: ErpDocument
)
extends
    Element
{
    def this () = { this (null) }
    def ErpDocument: ErpDocument = sup.asInstanceOf[ErpDocument]
    override def copy (): Row = { return (clone ().asInstanceOf[ErpReceivable]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ErpReceivable
extends
    Parseable[ErpReceivable]
{
    val sup = ErpDocument.parse _
    def parse (context: Context): ErpReceivable =
    {
        ErpReceivable(
            sup (context)
        )
    }
}

/**
 * Transaction for an Organisation receiving goods or services that may be used to indicate receipt of goods in conjunction with a purchase order.
 * A receivable is an open (unpaid) item in the Accounts Receivable ledger.
 * @param sup Reference to the superclass object.
 */
case class ErpReceiveDelivery
(
    override val sup: ErpDocument
)
extends
    Element
{
    def this () = { this (null) }
    def ErpDocument: ErpDocument = sup.asInstanceOf[ErpDocument]
    override def copy (): Row = { return (clone ().asInstanceOf[ErpReceiveDelivery]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ErpReceiveDelivery
extends
    Parseable[ErpReceiveDelivery]
{
    val sup = ErpDocument.parse _
    def parse (context: Context): ErpReceiveDelivery =
    {
        ErpReceiveDelivery(
            sup (context)
        )
    }
}

/**
 * Information that describes a requested item and its attributes.
 * @param sup Reference to the superclass object.
 * @param code
 * @param cost Cost of material.
 * @param deliveryDate
 * @param quantity Quantity of item requisitioned.
 * @param status
 * @param ErpPOLineItem
 * @param ErpQuoteLineItem
 * @param ErpRequisition
 * @param TypeAsset
 * @param TypeMaterial
 */
case class ErpReqLineItem
(
    override val sup: ErpIdentifiedObject,
    val code: String,
    val cost: Double,
    val deliveryDate: String,
    val quantity: Int,
    val status: String,
    val ErpPOLineItem: String,
    val ErpQuoteLineItem: String,
    val ErpRequisition: String,
    val TypeAsset: String,
    val TypeMaterial: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, null, 0, null, null, null, null, null, null) }
    def ErpIdentifiedObject: ErpIdentifiedObject = sup.asInstanceOf[ErpIdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ErpReqLineItem]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ErpReqLineItem
extends
    Parseable[ErpReqLineItem]
{
    val sup = ErpIdentifiedObject.parse _
    val code = parse_element (element ("""ErpReqLineItem.code"""))
    val cost = parse_element (element ("""ErpReqLineItem.cost"""))
    val deliveryDate = parse_element (element ("""ErpReqLineItem.deliveryDate"""))
    val quantity = parse_element (element ("""ErpReqLineItem.quantity"""))
    val status = parse_attribute (attribute ("""ErpReqLineItem.status"""))
    val ErpPOLineItem = parse_attribute (attribute ("""ErpReqLineItem.ErpPOLineItem"""))
    val ErpQuoteLineItem = parse_attribute (attribute ("""ErpReqLineItem.ErpQuoteLineItem"""))
    val ErpRequisition = parse_attribute (attribute ("""ErpReqLineItem.ErpRequisition"""))
    val TypeAsset = parse_attribute (attribute ("""ErpReqLineItem.TypeAsset"""))
    val TypeMaterial = parse_attribute (attribute ("""ErpReqLineItem.TypeMaterial"""))
    def parse (context: Context): ErpReqLineItem =
    {
        ErpReqLineItem(
            sup (context),
            code (context),
            toDouble (cost (context), context),
            deliveryDate (context),
            toInteger (quantity (context), context),
            status (context),
            ErpPOLineItem (context),
            ErpQuoteLineItem (context),
            ErpRequisition (context),
            TypeAsset (context),
            TypeMaterial (context)
        )
    }
}

/**
 * General information that applies to a utility requisition that is a request for the purchase of goods or services.
 * Typically, a requisition leads to the creation of a purchase order to a specific supplier.
 * @param sup Reference to the superclass object.
 */
case class ErpRequisition
(
    override val sup: ErpDocument
)
extends
    Element
{
    def this () = { this (null) }
    def ErpDocument: ErpDocument = sup.asInstanceOf[ErpDocument]
    override def copy (): Row = { return (clone ().asInstanceOf[ErpRequisition]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ErpRequisition
extends
    Parseable[ErpRequisition]
{
    val sup = ErpDocument.parse _
    def parse (context: Context): ErpRequisition =
    {
        ErpRequisition(
            sup (context)
        )
    }
}

/**
 * General purpose Sales Order is used for utility service orders, etc.
 * As used by the OAG, the SalesOrder is a step beyond a PurchaseOrder in that the receiving entity of the order also communicates SalesInformoration about the Order along with the Order itself.
 * @param sup Reference to the superclass object.
 */
case class ErpSalesOrder
(
    override val sup: ErpDocument
)
extends
    Element
{
    def this () = { this (null) }
    def ErpDocument: ErpDocument = sup.asInstanceOf[ErpDocument]
    override def copy (): Row = { return (clone ().asInstanceOf[ErpSalesOrder]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ErpSalesOrder
extends
    Parseable[ErpSalesOrder]
{
    val sup = ErpDocument.parse _
    def parse (context: Context): ErpSalesOrder =
    {
        ErpSalesOrder(
            sup (context)
        )
    }
}

/**
 * For a utility, general information that describes physical locations of organizations or the location codes and their meanings.
 * This enables ERP applications to ensure that the physical location identifiers are synchronized between the business applications.
 * @param sup Reference to the superclass object.
 * @param status
 * @param LandProperty
 */
case class ErpSiteLevelData
(
    override val sup: ErpIdentifiedObject,
    val status: String,
    val LandProperty: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def ErpIdentifiedObject: ErpIdentifiedObject = sup.asInstanceOf[ErpIdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ErpSiteLevelData]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ErpSiteLevelData
extends
    Parseable[ErpSiteLevelData]
{
    val sup = ErpIdentifiedObject.parse _
    val status = parse_attribute (attribute ("""ErpSiteLevelData.status"""))
    val LandProperty = parse_attribute (attribute ("""ErpSiteLevelData.LandProperty"""))
    def parse (context: Context): ErpSiteLevelData =
    {
        ErpSiteLevelData(
            sup (context),
            status (context),
            LandProperty (context)
        )
    }
}

/**
 * An individual entry on an ErpTimeSheet.
 * @param sup Reference to the superclass object.
 * @param status
 * @param ErpProjectAccounting
 * @param ErpTimeSheet
 */
case class ErpTimeEntry
(
    override val sup: ErpIdentifiedObject,
    val status: String,
    val ErpProjectAccounting: String,
    val ErpTimeSheet: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def ErpIdentifiedObject: ErpIdentifiedObject = sup.asInstanceOf[ErpIdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ErpTimeEntry]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ErpTimeEntry
extends
    Parseable[ErpTimeEntry]
{
    val sup = ErpIdentifiedObject.parse _
    val status = parse_attribute (attribute ("""ErpTimeEntry.status"""))
    val ErpProjectAccounting = parse_attribute (attribute ("""ErpTimeEntry.ErpProjectAccounting"""))
    val ErpTimeSheet = parse_attribute (attribute ("""ErpTimeEntry.ErpTimeSheet"""))
    def parse (context: Context): ErpTimeEntry =
    {
        ErpTimeEntry(
            sup (context),
            status (context),
            ErpProjectAccounting (context),
            ErpTimeSheet (context)
        )
    }
}

/**
 * Time sheet for employees and contractors.
 * Note that ErpTimeSheet inherits the relationship to ErpPerson from Document.
 * @param sup Reference to the superclass object.
 */
case class ErpTimeSheet
(
    override val sup: ErpDocument
)
extends
    Element
{
    def this () = { this (null) }
    def ErpDocument: ErpDocument = sup.asInstanceOf[ErpDocument]
    override def copy (): Row = { return (clone ().asInstanceOf[ErpTimeSheet]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ErpTimeSheet
extends
    Parseable[ErpTimeSheet]
{
    val sup = ErpDocument.parse _
    def parse (context: Context): ErpTimeSheet =
    {
        ErpTimeSheet(
            sup (context)
        )
    }
}

object _InfERPSupport
{
    def register: Unit =
    {
        BillMediaKind.register
        ErpAccountKind.register
        ErpBOM.register
        ErpBankAccount.register
        ErpBomItemData.register
        ErpChartOfAccounts.register
        ErpCompetency.register
        ErpDocument.register
        ErpEngChangeOrder.register
        ErpIdentifiedObject.register
        ErpInventory.register
        ErpInventoryCount.register
        ErpInvoice.register
        ErpInvoiceKind.register
        ErpInvoiceLineItem.register
        ErpInvoiceLineItemKind.register
        ErpIssueInventory.register
        ErpItemMaster.register
        ErpJournal.register
        ErpJournalEntry.register
        ErpLedBudLineItem.register
        ErpLedger.register
        ErpLedgerBudget.register
        ErpLedgerEntry.register
        ErpPOLineItem.register
        ErpPayable.register
        ErpPayableLineItem.register
        ErpPayment.register
        ErpPersonnel.register
        ErpProjectAccounting.register
        ErpPurchaseOrder.register
        ErpQuote.register
        ErpQuoteLineItem.register
        ErpRecDelvLineItem.register
        ErpRecLineItem.register
        ErpReceivable.register
        ErpReceiveDelivery.register
        ErpReqLineItem.register
        ErpRequisition.register
        ErpSalesOrder.register
        ErpSiteLevelData.register
        ErpTimeEntry.register
        ErpTimeSheet.register
    }
}