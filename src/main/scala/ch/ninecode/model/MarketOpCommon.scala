package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * This package contains the common objects shared by MarketOperations packages.
 */

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
 */
case class MarketInvoice
(override val sup: BasicElement,
val amount: Double,
val billMediaKind: String,
val dueDate: String,
val kind: String,
val mailedDate: String,
val proForma: Boolean,
val referenceNumber: String,
val transactionDateTime: String,
val transferType: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null, null, null, false, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[MarketInvoice]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MarketInvoice
extends
    Parseable[MarketInvoice]
{
    val sup = BasicElement.parse _
    val amount = parse_element (element ("""MarketInvoice.amount"""))_
    val billMediaKind = parse_attribute (attribute ("""MarketInvoice.billMediaKind"""))_
    val dueDate = parse_element (element ("""MarketInvoice.dueDate"""))_
    val kind = parse_attribute (attribute ("""MarketInvoice.kind"""))_
    val mailedDate = parse_element (element ("""MarketInvoice.mailedDate"""))_
    val proForma = parse_element (element ("""MarketInvoice.proForma"""))_
    val referenceNumber = parse_element (element ("""MarketInvoice.referenceNumber"""))_
    val transactionDateTime = parse_element (element ("""MarketInvoice.transactionDateTime"""))_
    val transferType = parse_element (element ("""MarketInvoice.transferType"""))_
    def parse (context: Context): MarketInvoice =
    {
        MarketInvoice(
            sup (context),
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
}

/**
 * An individual line item on an invoice.
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
 * @param ContainerMarketInvoiceLineItem
 * @param MarketInvoice
 * @param Settlement
 */
case class MarketInvoiceLineItem
(override val sup: BasicElement,
val billPeriod: String,
val glAccount: String,
val glDateTime: String,
val kind: String,
val lineAmount: Double,
val lineNumber: String,
val lineVersion: String,
val netAmount: Double,
val previousAmount: Double,
val ContainerMarketInvoiceLineItem: String,
val MarketInvoice: String,
val Settlement: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, 0.0, null, null, 0.0, 0.0, null, null, List()) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[MarketInvoiceLineItem]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MarketInvoiceLineItem
extends
    Parseable[MarketInvoiceLineItem]
{
    val sup = BasicElement.parse _
    val billPeriod = parse_attribute (attribute ("""MarketInvoiceLineItem.billPeriod"""))_
    val glAccount = parse_element (element ("""MarketInvoiceLineItem.glAccount"""))_
    val glDateTime = parse_element (element ("""MarketInvoiceLineItem.glDateTime"""))_
    val kind = parse_attribute (attribute ("""MarketInvoiceLineItem.kind"""))_
    val lineAmount = parse_element (element ("""MarketInvoiceLineItem.lineAmount"""))_
    val lineNumber = parse_element (element ("""MarketInvoiceLineItem.lineNumber"""))_
    val lineVersion = parse_element (element ("""MarketInvoiceLineItem.lineVersion"""))_
    val netAmount = parse_element (element ("""MarketInvoiceLineItem.netAmount"""))_
    val previousAmount = parse_element (element ("""MarketInvoiceLineItem.previousAmount"""))_
    val ContainerMarketInvoiceLineItem = parse_attribute (attribute ("""MarketInvoiceLineItem.ContainerMarketInvoiceLineItem"""))_
    val MarketInvoice = parse_attribute (attribute ("""MarketInvoiceLineItem.MarketInvoice"""))_
    val Settlement = parse_attributes (attribute ("""MarketInvoiceLineItem.Settlement"""))_
    def parse (context: Context): MarketInvoiceLineItem =
    {
        MarketInvoiceLineItem(
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
            ContainerMarketInvoiceLineItem (context),
            MarketInvoice (context),
            Settlement (context)
        )
    }
}

/**
 * In accounting transactions, a ledger is a book containing accounts to which debits and credits are posted from journals, where transactions are initially recorded.
 * Journal entries are periodically posted to the ledger. Ledger Actual represents actual amounts by account within ledger within company or business area. Actual amounts may be generated in a source application and then loaded to a specific ledger within the enterprise general ledger or budget application.
 * @param sup Reference to the superclass object.
 */
case class MarketLedger
(override val sup: BasicElement
)
extends
    Element
{
    def this () = { this (null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[MarketLedger]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MarketLedger
extends
    Parseable[MarketLedger]
{
    val sup = BasicElement.parse _
    def parse (context: Context): MarketLedger =
    {
        MarketLedger(
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
 * @param status Status of ledger entry.
 * @param transactionDateTime Date and time journal entry was recorded.
 * @param MarketLedger
 * @param Settlement
 */
case class MarketLedgerEntry
(override val sup: BasicElement,
val accountID: String,
val accountKind: String,
val amount: Double,
val postedDateTime: String,
val status: String,
val transactionDateTime: String,
val MarketLedger: String,
val Settlement: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, 0.0, null, null, null, null, List()) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[MarketLedgerEntry]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MarketLedgerEntry
extends
    Parseable[MarketLedgerEntry]
{
    val sup = BasicElement.parse _
    val accountID = parse_element (element ("""MarketLedgerEntry.accountID"""))_
    val accountKind = parse_attribute (attribute ("""MarketLedgerEntry.accountKind"""))_
    val amount = parse_element (element ("""MarketLedgerEntry.amount"""))_
    val postedDateTime = parse_element (element ("""MarketLedgerEntry.postedDateTime"""))_
    val status = parse_attribute (attribute ("""MarketLedgerEntry.status"""))_
    val transactionDateTime = parse_element (element ("""MarketLedgerEntry.transactionDateTime"""))_
    val MarketLedger = parse_attribute (attribute ("""MarketLedgerEntry.MarketLedger"""))_
    val Settlement = parse_attributes (attribute ("""MarketLedgerEntry.Settlement"""))_
    def parse (context: Context): MarketLedgerEntry =
    {
        MarketLedgerEntry(
            sup (context),
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
}

/**
 * Subclass of IEC61968: Common:ActivityRecord
 * @param sup Reference to the superclass object.
 */
case class MktActivityRecord
(override val sup: ActivityRecord
)
extends
    Element
{
    def this () = { this (null) }
    def ActivityRecord: ActivityRecord = sup.asInstanceOf[ActivityRecord]
    override def copy (): Row = { return (clone ().asInstanceOf[MktActivityRecord]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MktActivityRecord
extends
    Parseable[MktActivityRecord]
{
    val sup = ActivityRecord.parse _
    def parse (context: Context): MktActivityRecord =
    {
        MktActivityRecord(
            sup (context)
        )
    }
}

/**
 * Subclass of IEC61970:Topology:ConnectivityNode
 * @param sup Reference to the superclass object.
 * @param endEffectiveDate end effective date
 * @param startEffectiveDate start effective date
 * @param IndividualPnode
 * @param RTO
 * @param SysLoadDistribuFactor
 */
case class MktConnectivityNode
(override val sup: ConnectivityNode,
val endEffectiveDate: String,
val startEffectiveDate: String,
val IndividualPnode: String,
val RTO: String,
val SysLoadDistribuFactor: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def ConnectivityNode: ConnectivityNode = sup.asInstanceOf[ConnectivityNode]
    override def copy (): Row = { return (clone ().asInstanceOf[MktConnectivityNode]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MktConnectivityNode
extends
    Parseable[MktConnectivityNode]
{
    val sup = ConnectivityNode.parse _
    val endEffectiveDate = parse_element (element ("""MktConnectivityNode.endEffectiveDate"""))_
    val startEffectiveDate = parse_element (element ("""MktConnectivityNode.startEffectiveDate"""))_
    val IndividualPnode = parse_attribute (attribute ("""MktConnectivityNode.IndividualPnode"""))_
    val RTO = parse_attribute (attribute ("""MktConnectivityNode.RTO"""))_
    val SysLoadDistribuFactor = parse_attribute (attribute ("""MktConnectivityNode.SysLoadDistribuFactor"""))_
    def parse (context: Context): MktConnectivityNode =
    {
        MktConnectivityNode(
            sup (context),
            endEffectiveDate (context),
            startEffectiveDate (context),
            IndividualPnode (context),
            RTO (context),
            SysLoadDistribuFactor (context)
        )
    }
}

/**
 * Subclass of IEC61970:Wires:EnergyConsumer
 * @param sup Reference to the superclass object.
 * @param RegisteredLoad
 */
case class MktEnergyConsumer
(override val sup: EnergyConsumer,
val RegisteredLoad: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def EnergyConsumer: EnergyConsumer = sup.asInstanceOf[EnergyConsumer]
    override def copy (): Row = { return (clone ().asInstanceOf[MktEnergyConsumer]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MktEnergyConsumer
extends
    Parseable[MktEnergyConsumer]
{
    val sup = EnergyConsumer.parse _
    val RegisteredLoad = parse_attribute (attribute ("""MktEnergyConsumer.RegisteredLoad"""))_
    def parse (context: Context): MktEnergyConsumer =
    {
        MktEnergyConsumer(
            sup (context),
            RegisteredLoad (context)
        )
    }
}

/**
 * Subclass of IEC61970:Production:GeneratingUnit
 * @param sup Reference to the superclass object.
 * @param RegisteredGenerator
 */
case class MktGeneratingUnit
(override val sup: GeneratingUnit,
val RegisteredGenerator: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def GeneratingUnit: GeneratingUnit = sup.asInstanceOf[GeneratingUnit]
    override def copy (): Row = { return (clone ().asInstanceOf[MktGeneratingUnit]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MktGeneratingUnit
extends
    Parseable[MktGeneratingUnit]
{
    val sup = GeneratingUnit.parse _
    val RegisteredGenerator = parse_attribute (attribute ("""MktGeneratingUnit.RegisteredGenerator"""))_
    def parse (context: Context): MktGeneratingUnit =
    {
        MktGeneratingUnit(
            sup (context),
            RegisteredGenerator (context)
        )
    }
}

/**
 * Subclass for IEC61970:Wires:Line
 * @param sup Reference to the superclass object.
 * @param TransmissionRightOfWay
 */
case class MktLine
(override val sup: Line,
val TransmissionRightOfWay: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Line: Line = sup.asInstanceOf[Line]
    override def copy (): Row = { return (clone ().asInstanceOf[MktLine]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MktLine
extends
    Parseable[MktLine]
{
    val sup = Line.parse _
    val TransmissionRightOfWay = parse_attribute (attribute ("""MktLine.TransmissionRightOfWay"""))_
    def parse (context: Context): MktLine =
    {
        MktLine(
            sup (context),
            TransmissionRightOfWay (context)
        )
    }
}

/**
 * Subclass of IEC61970:LoadModel: LoadArea
 * @param sup Reference to the superclass object.
 */
case class MktLoadArea
(override val sup: LoadArea
)
extends
    Element
{
    def this () = { this (null) }
    def LoadArea: LoadArea = sup.asInstanceOf[LoadArea]
    override def copy (): Row = { return (clone ().asInstanceOf[MktLoadArea]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MktLoadArea
extends
    Parseable[MktLoadArea]
{
    val sup = LoadArea.parse _
    def parse (context: Context): MktLoadArea =
    {
        MktLoadArea(
            sup (context)
        )
    }
}

/**
 * Subclass of IEC61970:Meas:Measurement
 * @param sup Reference to the superclass object.
 * @param ByTiePoint A measurement is made on the B side of a tie point
 * @param ForTiePoint A measurement is made on the A side of a tie point
 * @param Pnode
 */
case class MktMeasurement
(override val sup: Measurement,
val ByTiePoint: String,
val ForTiePoint: String,
val Pnode: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Measurement: Measurement = sup.asInstanceOf[Measurement]
    override def copy (): Row = { return (clone ().asInstanceOf[MktMeasurement]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MktMeasurement
extends
    Parseable[MktMeasurement]
{
    val sup = Measurement.parse _
    val ByTiePoint = parse_attribute (attribute ("""MktMeasurement.ByTiePoint"""))_
    val ForTiePoint = parse_attribute (attribute ("""MktMeasurement.ForTiePoint"""))_
    val Pnode = parse_attribute (attribute ("""MktMeasurement.Pnode"""))_
    def parse (context: Context): MktMeasurement =
    {
        MktMeasurement(
            sup (context),
            ByTiePoint (context),
            ForTiePoint (context),
            Pnode (context)
        )
    }
}

/**
 * Subclass of IEC61968:Core2:TopLevel:Organisation
 * @param sup Reference to the superclass object.
 * @param creditFlag Flag to indicate creditworthiness (Y, N)
 * @param creditStartEffectiveDate Date that the organisation becomes creditworthy.
 * @param endEffectiveDate end effective date
 * @param lastModified Indication of the last time this Organization information was modified.
 * @param organisationID Organisation (internal) ID
 * @param qualificationStatus Organisation qualification status, Qualified, Not Qualified, or Disqualified
 * @param startEffectiveDate start effective date
 * @param MarketPerson
 */
case class MktOrganisation
(override val sup: Organisation,
val creditFlag: String,
val creditStartEffectiveDate: String,
val endEffectiveDate: String,
val lastModified: String,
val organisationID: Int,
val qualificationStatus: String,
val startEffectiveDate: String,
val MarketPerson: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, 0, null, null, List()) }
    def Organisation: Organisation = sup.asInstanceOf[Organisation]
    override def copy (): Row = { return (clone ().asInstanceOf[MktOrganisation]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MktOrganisation
extends
    Parseable[MktOrganisation]
{
    val sup = Organisation.parse _
    val creditFlag = parse_attribute (attribute ("""MktOrganisation.creditFlag"""))_
    val creditStartEffectiveDate = parse_element (element ("""MktOrganisation.creditStartEffectiveDate"""))_
    val endEffectiveDate = parse_element (element ("""MktOrganisation.endEffectiveDate"""))_
    val lastModified = parse_element (element ("""MktOrganisation.lastModified"""))_
    val organisationID = parse_element (element ("""MktOrganisation.organisationID"""))_
    val qualificationStatus = parse_element (element ("""MktOrganisation.qualificationStatus"""))_
    val startEffectiveDate = parse_element (element ("""MktOrganisation.startEffectiveDate"""))_
    val MarketPerson = parse_attributes (attribute ("""MktOrganisation.MarketPerson"""))_
    def parse (context: Context): MktOrganisation =
    {
        MktOrganisation(
            sup (context),
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
}

/**
 * Subclass of IEC61970:Wires:PowerTransformer
 * @param sup Reference to the superclass object.
 * @param EndAFlow
 * @param EndBFlow
 */
case class MktPowerTransformer
(override val sup: PowerTransformer,
val EndAFlow: String,
val EndBFlow: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def PowerTransformer: PowerTransformer = sup.asInstanceOf[PowerTransformer]
    override def copy (): Row = { return (clone ().asInstanceOf[MktPowerTransformer]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MktPowerTransformer
extends
    Parseable[MktPowerTransformer]
{
    val sup = PowerTransformer.parse _
    val EndAFlow = parse_attribute (attribute ("""MktPowerTransformer.EndAFlow"""))_
    val EndBFlow = parse_attribute (attribute ("""MktPowerTransformer.EndBFlow"""))_
    def parse (context: Context): MktPowerTransformer =
    {
        MktPowerTransformer(
            sup (context),
            EndAFlow (context),
            EndBFlow (context)
        )
    }
}

/**
 * Subclass of IEC61970:Core:Terminal
 * @param sup Reference to the superclass object.
 * @param endEffectiveDate This is the end date/time of the element eligibility for the flowgate.
 * @param startEffectiveDate This is the begin date/time of the element eligibility for the flowgate.
 * @param Flowgate
 */
case class MktTerminal
(override val sup: Terminal,
val endEffectiveDate: String,
val startEffectiveDate: String,
val Flowgate: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Terminal: Terminal = sup.asInstanceOf[Terminal]
    override def copy (): Row = { return (clone ().asInstanceOf[MktTerminal]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MktTerminal
extends
    Parseable[MktTerminal]
{
    val sup = Terminal.parse _
    val endEffectiveDate = parse_element (element ("""MktTerminal.endEffectiveDate"""))_
    val startEffectiveDate = parse_element (element ("""MktTerminal.startEffectiveDate"""))_
    val Flowgate = parse_attribute (attribute ("""MktTerminal.Flowgate"""))_
    def parse (context: Context): MktTerminal =
    {
        MktTerminal(
            sup (context),
            endEffectiveDate (context),
            startEffectiveDate (context),
            Flowgate (context)
        )
    }
}

/**
 * Subclass of IEC61968:Domain2:UserAttribute
 * @param sup Reference to the superclass object.
 */
case class MktUserAttribute
(override val sup: UserAttribute
)
extends
    Element
{
    def this () = { this (null) }
    def UserAttribute: UserAttribute = sup.asInstanceOf[UserAttribute]
    override def copy (): Row = { return (clone ().asInstanceOf[MktUserAttribute]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MktUserAttribute
extends
    Parseable[MktUserAttribute]
{
    val sup = UserAttribute.parse _
    def parse (context: Context): MktUserAttribute =
    {
        MktUserAttribute(
            sup (context)
        )
    }
}

object _MarketOpCommon
{
    def register: Unit =
    {
        MarketInvoice.register
        MarketInvoiceLineItem.register
        MarketLedger.register
        MarketLedgerEntry.register
        MktActivityRecord.register
        MktConnectivityNode.register
        MktEnergyConsumer.register
        MktGeneratingUnit.register
        MktLine.register
        MktLoadArea.register
        MktMeasurement.register
        MktOrganisation.register
        MktPowerTransformer.register
        MktTerminal.register
        MktUserAttribute.register
    }
}